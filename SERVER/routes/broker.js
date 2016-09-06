var express = require('express');
var router = express.Router();
var db = require('../db/config');

var router = express.Router();


/* GET users listing. */
router.get('/', function (req, res, next) {
    console.log("GET request on /broker");
    res.send('Welcome to broker page');
});

router.route('/')
    .post(function (req, res) {
        console.log('Inserting new broker...');
        console.log(req.body);

        db.query({
                sql: 'INSERT INTO broker (name, email) VALUES (?, ?)'
            }, [req.body.name, req.body.email],
            function (error, results, fields) {
                // error will be an Error if one occurred during the query 
                // results will contain the results of the query 
                // fields will contain information about the returned results fields (if any)
                if (error) {
                    console.log('Error performing the query');
                    res.status(500).send(error);
                } else {
                    console.log("INSERT broker successfully");
                    res.status(201).send(results);
                }
            }
        );
    });

module.exports = router;