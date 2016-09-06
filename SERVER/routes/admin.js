var express = require('express');
var db = require('../db/config');


var router = express.Router();
router.route('/')
    .get(function (req, res) {
        console.log('GET request on /admin');

        db.query('SELECT * from user', function (err, rows, fields) {
            if (!err) {
                console.log(rows);
                res.json(rows);
            } else
                console.log('Error performing the query');
        });
        // db.end();

    })
    .post(function (req, res) {
        console.log('Inserting new user...');
        console.log(req.body);
        var userId = 0;

        db.query({
                sql: 'INSERT INTO user (name, username, password) VALUES (?, ?, ?)'
            }, [req.body.name, req.body.username, req.body.password],
            function (error, results, fields) {
                // error will be an Error if one occurred during the query 
                // results will contain the results of the query 
                // fields will contain information about the returned results fields (if any)
                if (error) {
                    console.log('Error performing the query');
                    res.status(500).send(error);
                } else {
                    console.log("INSERT user successfully");
                    var query = "";
                    if (req.body.user_type === "trader") {
                        query = 'INSERT INTO trader (t_id) VALUES (?)'
                    } else if (req.body.user_type === "pm") {
                        query = 'INSERT INTO portfolio_manager (pm_id) VALUES (?)'
                    } else if (req.body.user_type === "admin") {
                        query = 'INSERT INTO admin (adm_id) VALUES (?)'
                    }

		   userId = results.insertId;
                    db.query(query, [userId],
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
                }
            });
    });



module.exports = router;
