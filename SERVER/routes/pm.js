var express = require('express');
var pool = require('../db/config');
var router = express.Router();

/* GET users listing. */
router.get('/', function (req, res, next) {
    console.log("GET request on /pm");
    res.send('Welcome to pm page');
});

router.route('/eod/:username/:minusDay')
    .get(function (req, res) {
        console.log('GET request on /pm/eod/:username/:minusDay');
        pool.getConnection(function (err, conn) {
            var query = '';
            if (req.params.minusDay == 1)
                query = 'SELECT s.* FROM single_order s INNER join pm_order o ON o.order_id = s.order_id WHERE date_bexecuted = (DATE_ADD(CURDATE(), INTERVAL -1 DAY)) and o.pm_id = (SELECT u_id FROM user WHERE username = ? )';
            else
                query = 'SELECT s.* FROM single_order s INNER join pm_order o ON o.order_id = s.order_id WHERE date_bexecuted = (CURDATE()) and o.pm_id = (SELECT u_id FROM user WHERE username = ? )';

            conn.query({
                    sql: query
                }, [req.params.username],
                function (err, rows, fields) {
                    if (!err) {
                        console.log(rows);
                        res.json(rows);
                    } else {
                        console.log('Error performing the query');
                        res.json(err);
                    }


                });
            conn.release();
        });
    });

router.route('/orders/:username')
    .get(function (req, res) {
        console.log('GET request on /pm/orders/:username');

        pool.getConnection(function (err, conn) {
            conn.query('SELECT s.*, u.username, p.assigned_to FROM single_order s INNER JOIN pm_order p ON s.order_id = p.order_id INNER JOIN user u ON u.u_id = p.assigned_to WHERE p.pm_id = (SELECT u_id FROM user WHERE username = ? ) ORDER BY s.sorder_id;',
                req.params.username,
                function (err, rows, fields) {
                    if (!err) {
                        //console.log(rows);
                        res.json(rows);
                    } else
                        console.log('Error performing the query');

                });
        });
    });


function insert_order(req, res, assignedTo) {
    /* Insert general order info into pm_order table */
    console.log(assignedTo);
    pool.getConnection(function (err, conn) {
        conn.query({
                sql: 'INSERT INTO pm_order (pm_id, assigned_to) VALUES (?, ?)'
            }, [req.body.pm_id, assignedTo],
            function (error, results, fields) {
                // error will be an Error if one occurred during the query 
                // results will contain the results of the query 
                // fields will contain information about the returned results fields (if any)
                if (error) {
                    console.log('Error performing the query:');
                    console.log(error);
                    res.status(500).send(error);
                } else {
                    console.log("ORDER insert successful");
                    console.log(results);
                    var orderId = results.insertId;
                    console.log("orderId: " + orderId);

                    /* Insert each single_order info into single_order table */
                    var i;
                    var hasBeenError = false;
                    for (i = 0; i < req.body.containedSingleOrders.length; i++) {
                        var singleOrder = req.body.containedSingleOrders[i];
                        console.log(singleOrder);

                        conn.query({
                                sql: 'INSERT INTO single_order (p_id, order_id, symbol, quantity, action_type, order_type, account_type, stock_exchange, price_stop, price_limit) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)'
                            }, [
                                    singleOrder.p_id,
                                    orderId,
                                    singleOrder.symbol,
                                    singleOrder.quantity,
                                    singleOrder.action_type,
                                    singleOrder.order_type,
                                    singleOrder.account_type,
                                    singleOrder.stock_exchange,
                                    singleOrder.price_stop,
                                    singleOrder.price_limit
                                ],
                            function (error, results, fields) {
                                // error will be an Error if one occurred during the query 
                                // results will contain the results of the query 
                                // fields will contain information about the returned results fields (if any)
                                if (error) {
                                    console.log('Error performing the query:');
                                    console.log(error);
                                    res.status(500).send(error);
                                    hasBeenError = true;
                                } else {
                                    console.log("SINGLE_ORDER insert successful");
                                }
                            });
                    }
                    if (!hasBeenError)
                        res.status(201).send('Successfully created all the orders');
                }
            });
        conn.release();
    });
}

router.route('/orders')
    .post(function (req, res) {
        console.log('Inserting new order...');
        console.log(req.body);

        /* Check if the trader is set or should be automatically set */
        if (req.body.assignedTrader == "Automatic") {

            /* 
            Automatic trader assignment:
            
            Criteria: trader with less pending orders
            */
            pool.getConnection(function (err, conn) {

                conn.query({
                        sql: 'select p.order_id, t.t_id, count(p.order_id) from trader t LEFT OUTER JOIN pm_order p ON t.t_id = p.assigned_to LEFT OUTER JOIN single_order s ON p.order_id = s.order_id GROUP BY p.order_id ORDER BY COUNT(p.order_id) ASC LIMIT 1;'
                    },
                    function (error, results, fields) {
                        // error will be an Error if one occurred during the query 
                        // results will contain the results of the query 
                        // fields will contain information about the returned results fields (if any)
                        if (error) {
                            console.log('Error performing the query:');
                            console.log(error);
                            res.status(500).send(error);
                        } else {
                            console.log(results);
                            conn.release();
                            insert_order(req, res, results[0].t_id);
                        }
                    });
            });

        } else {
            insert_order(req, res, req.body.assignedTo);
        }

    });


module.exports = router;