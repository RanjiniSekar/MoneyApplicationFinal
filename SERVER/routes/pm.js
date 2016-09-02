var express = require('express');
var db = require('../db/config');


var router = express.Router();

/* GET users listing. */
router.get('/', function (req, res, next) {
    console.log("GET request on /pm");
    res.send('Welcome to pm page');
});

router.route('/orders')
    .get(function (req, res) {
        console.log('GET request on /pm/orders');

        db.query('SELECT * from orders', function (err, rows, fields) {
            if (!err) {
                console.log(rows);
                res.json(rows);
            } else
                console.log('Error performing the query');

        });
        // db.end();

    })
    .post(function (req, res) {
        console.log('Inserting new order...');
        console.log(req.body);

        /* Check if the trader is set or should be automatically set */
        if (req.body.assignedTrader == "Automatic") {
            // query the database for finding the less busy one
            var assignedTo = 0;
            req.body.assignedTo = assignedTo;
        }

        /* Insert general order info into pm_order table */
        var orderId = 0;

        db.query({
                sql: 'INSERT INTO pm_order (pm_id, assigned_to) VALUES (?, ?)'
            }, [req.body.portfolioManagerId, req.body.assignedTo],
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
                    console.log(fields);
                    orderId = results.insertId;
                    res.status(201).send(results);
                }
            });

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
                        console.log("SINGLE_    ORDER insert successful");
                        res.status(201).send(results);
                    }
                });

        }

    });


module.exports = router;