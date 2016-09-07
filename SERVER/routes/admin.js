var express = require('express');
var router = express.Router();
var pool = require('../db/config');

router.route('/')
    .get(function (req, res) {
        console.log('GET request on /admin');
        pool.getConnection(function (err, conn) {
            conn.query('SELECT * from user', function (err, rows, fields) {
                if (!err) {
                    console.log(rows);
                    res.json(rows);
                } else
                    console.log('Error performing the query');
            });
            conn.release();
        });
    })
    .post(function (req, res) {
        console.log('Inserting new user...');
        console.log(req.body);
        var userId = 0;
        pool.getConnection(function (err, conn) {
            conn.query({
                    sql: 'INSERT INTO user (name, username, password, user_type) VALUES (?, ?, ?, ?)'
                }, [req.body.name, req.body.username, req.body.password, req.body.user_type],
                function (error, results, fields) {
                    // error will be an Error if one occurred during the query 
                    // results will contain the results of the query 
                    // fields will contain information about the returned results fields (if any)
                    if (error) {
                        console.log('Error performing the query');
                        res.status(500).send(error);
                    } else {
                        console.log("INSERT user successfully");
                        userId = results.insertId;

                        var query = "";
                        if (req.body.user_type === "trader") {
                            query = 'INSERT INTO trader (t_id) VALUES (?)'
                        } else if (req.body.user_type === "pm") {
                            query = 'INSERT INTO portfolio_manager (pm_id) VALUES (?)'
                        } else if (req.body.user_type === "admin") {
                            query = 'INSERT INTO admin (adm_id) VALUES (?)'
                        }

                        conn.query(query, [userId],
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
            conn.release();
        })
    });

router.route('/traders')
    .get(function (req, res) {
        console.log('GET request on /admin/traders');
        pool.getConnection(function (err, conn) {
            conn.query('SELECT * from user where user_type = ?', ["trader"], function (err, rows, fields) {
                if (!err) {
                    console.log(rows);
                    res.json(rows);
                } else
                    console.log('Error performing the query');
            });
            conn.release();
        })
    })

router.route('/brokers')
    .get(function (req, res) {
        console.log('GET request on /admin/brokers');
        pool.getConnection(function (err, conn) {
            conn.query('SELECT * from broker', function (err, rows, fields) {
                if (!err) {
                    console.log(rows);
                    res.json(rows);
                } else
                    console.log('Error performing the query');
            });
            conn.release();
        })
    })

router.route('/user/:username')
    .get(function (req, res) {
        pool.getConnection(function (err, conn) {
            conn.query('SELECT * from user WHERE username = ?',
                req.params.username,
                function (error, results, fields) {
                    // error will be an Error if one occurred during the query 
                    // results will contain the results of the query 
                    // fields will contain information about the returned results fields (if any)
                    if (error) {
                        console.log('Error performing the query');
                        res.status(500).send(error);
                    } else {
                        res.json(results);
                    }
                });
            conn.release();
        });
    })
    .put(function (req, res) {
        pool.getConnection(function (err, conn) {
            conn.query('UPDATE user SET password = ? WHERE username = ?', [req.body.password, req.params.username],
                function (error, results, fields) {
                    // error will be an Error if one occurred during the query 
                    // results will contain the results of the query 
                    // fields will contain information about the returned results fields (if any)
                    if (error) {
                        console.log('Error performing the query');
                        res.status(500).send(error);
                    } else {
                        res.json(results);
                    }
                });
            conn.release();
        });

    })

module.exports = router;