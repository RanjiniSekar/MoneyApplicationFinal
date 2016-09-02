var express = require('express');
var db = require('../db/config');


var router = express.Router();
router.route('/')
    .get(function (req, res) {
        console.log('GET request on /admin');
        db.connect();
        db.query('SELECT * from user', function (err, rows, fields) {
            if (!err) {
                console.log(rows);
                res.json(rows);
            } else
                console.log('Error performing the query');

        });
        db.end();

    })
    .post(function (req, res) {
        console.log('Inserting new user...');
        console.log(req.body);


        db.connect();
        db.query({
                sql: 'INSERT INTO user SET '
            },
            req.body,
            function (error, results, fields) {
                // error will be an Error if one occurred during the query 
                // results will contain the results of the query 
                // fields will contain information about the returned results fields (if any)
                if (error) {
                    console.log('Error performing the query');
                    res.status(500).send(error);
                } else {
                    res.status(201).send(results);
                }
            });
        db.end();
    });


module.exports = router;