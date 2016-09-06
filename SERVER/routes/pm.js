var express = require('express');
var db = require('../db/config');


var router = express.Router();

/* GET users listing. */
router.get('/', function (req, res, next) {
    console.log("GET request on /pm");
    res.send('Welcome to pm page');
});

router.route('/orders/:pmId')
    .get(function (req, res) {
        console.log('GET request on /pm/orders/:pmId');

        db.query('SELECT s.sorder_id, s.order_id, s.block_id , s.symbol FROM single_order s RIGHT JOIN pm_order p ON s.order_id = p.order_id WHERE p.pm_id = ? ORDER BY s.sorder_id;',
            req.params.pmId,
            function (err, rows, fields) {
                if (!err) {
                    console.log(rows);
                    res.json(rows);
                } else
                    console.log('Error performing the query');

            });
        // db.end();

    });


function insert_order(req, res, assignedTo) {
    /* Insert general order info into pm_order table */
    console.log(assignedTo);
    db.query({
            sql: 'INSERT INTO pm_order (pm_id, assigned_to) VALUES (?, ?)'
        }, [req.body.portfolioManagerId, assignedTo],
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
                for (var singleOrder in req.body.containedSingleOrders) {
                    console.log(singleOrder);

                    db.query({
                            sql: 'INSERT INTO single_order (pm_id, assigned_to) VALUES (?, ?)'
                        }, [
                                singleOrder.portfolioId,
                                orderId,
                                singleOrder.symbol,
                                singleOrder.quantity,
                                singleOrder.action,
                                singleOrder.stopPrice,
                                singleOrder.limitPrice,
                                singleOrder.stockExchange,
                                singleOrder.accountType,
                                singleOrder.orderType,
                                req.body.portfolioManagerId,
                                req.body.assignedTo
                            ],
                        function (error, results, fields) {
                            // error will be an Error if one occurred during the query 
                            // results will contain the results of the query 
                            // fields will contain information about the returned results fields (if any)
                            if (error) {
                                console.log('Error performing the query:');
                                console.log(error);
                                res.status(500).send(error);
                            } else {
                                console.log("SINGLE_ORDER insert successful");
                                res.status(201).send(results);
                            }
                        });

                    res.status(201).send(results);
                }
            }
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

            db.query({
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
                        insert_order(req, res, results[0].t_id);
                    }
                });

        } else {
            insert_order(req, res, req.body.assignedTo);
        }

    });

module.exports = router;
