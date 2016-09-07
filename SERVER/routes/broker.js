var express = require('express');
var pool = require('../db/config');
var router = express.Router();


router.route('/updateTrade')
    .post(function (req, res) {
        console.log('Updating Trade...');
        console.log(req.body);
        pool.getConnection(function (err, conn) {
            if (req.body.action == "accept") {
                conn.query({
                        sql: "UPDATE trader_block SET price_executed = ?, status = ?  WHERE block_id= (select block_id from temp_link where uid = ?)"
                    }, [req.body.price, "Executed", req.body.uid],
                    function (error, results, fields) {
                        // error will be an Error if one occurred during the query 
                        // results will contain the results of the query 
                        // fields will contain information about the returned results fields (if any)
                        if (error) {
                            console.log('Error performing the query');
                            res.status(500).send(error);
                        } else {
                            console.log("TRADER_BLOCK update successfully");
                            conn.query({
                                    sql: "UPDATE single_order SET price_executed = ?, status = ? WHERE block_id= (select block_id from temp_link where uid = ?)"
                                }, [req.body.price, "Executed", req.body.uid],
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

                                        //pending - DELETE FROM tmp_link table: uid
                                    }
                                });

                            res.status(201).send(results);


                        }
                    }
                );
            } else if (req.body.action == "reject") {
                // order has been rejected
                conn.query({
                        sql: "UPDATE trader_block SET status = ? WHERE block_id= (select block_id from temp_link where uid = ?)"
                    }, ["Rejected", req.body.uid],
                    function (error, results, fields) {
                        // error will be an Error if one occurred during the query 
                        // results will contain the results of the query 
                        // fields will contain information about the returned results fields (if any)
                        if (error) {
                            console.log('Error performing the query');
                            res.status(500).send(error);
                        } else {
                            console.log("TRADER_BLOCK update successfully");
                            conn.query({
                                    sql: "UPDATE single_order SET status = ? WHERE block_id= (select block_id from temp_link where uid = ?)"
                                }, ["Rejected", req.body.uid],
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

                                        conn.query({
                                                sql: "DELETE FROM temp_link WHERE uid = ?"
                                            }, [req.body.uid],
                                            function (error, results, fields) {
                                                if (error) {
                                                    console.log('Error performing the query:');
                                                    console.log(error);
                                                    res.status(500).send(error);
                                                } else {
                                                    console.log('temp_link deleted successfully')
                                                    res.status(204).send(results);
                                                }
                                            });

                                    }
                                });




                        }
                    }
                );
            }
            conn.release();
        });
    });

router.route('/')
    .post(function (req, res) {
        console.log('Inserting new broker...');
        console.log(req.body);
        pool.getConnection(function (err, conn) {
            conn.query({
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
            conn.release();
        });
    });

module.exports = router;