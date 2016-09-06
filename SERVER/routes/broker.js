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

router.route('/updateTrade')
    .post(function (req, res) {
        console.log('Updating Trade...');
        console.log(req.body);

        db.query({
             sql: "UPDATE trader_block SET price_executed=? WHERE block_id= (select block_id from temp_link where uid = ?)"
            }, [req.body.price, req.body.uid],
            function (error, results, fields) {
                // error will be an Error if one occurred during the query 
                // results will contain the results of the query 
                // fields will contain information about the returned results fields (if any)
                if (error) {
                    console.log('Error performing the query');
                    res.status(500).send(error);
                } else {
                    console.log("TRADER_BLOCK update successfully");
                    
                    db.query({
                            sql: "UPDATE single_order SET price_executed=? WHERE block_id= (select block_id from temp_link where uid = ?)"
                    }, [req.body.price, req.body.uid],
                        function (error, results, fields) {
                            // error will be an Error if one occurred during the query 
                            // results will contain the results of the query 
                            // fields will contain information about the returned results fields (if any)
                            if (error) {
                                console.log('Error performing the query:');
                                console.log(error);
                                res.status(500).send(error);
                            } else {
                                console.log("SINGLE_ORDER update successful");
                            }
                        });
                    
                    res.status(201).send(results);
                }
            }
        );
    });

module.exports = router;