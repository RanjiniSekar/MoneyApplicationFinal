var express = require('express');
var router = express.Router();

/* GET users listing. */
router.get('/', function (req, res) {
    console.log("GET request on /trader");
    res.send('Welcome to trader page');
});

router.get('/Users/:userId', function(req, res) {
   res.send(req.params.userId); 
});


function insert_block(req) {
    /* Insert general order info into pm_order table */
    var blockId = 0;

    db.query({
            sql: 'INSERT INTO trader_block (block_id, t_id, b_id, symbol, quantity, order_type, price_executed, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?)'
        }, [blockId, req.body.traderId, req.body.brokerId, req.body.symbol, req.body.quantity, req.body.orderType, req.body.executedPrice, req.body.status],
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
                blockId = results.insertId;

                /* Insert each single_order info into single_order table */
                for (var singleOrder in req.body.containedSingleOrders) {
                    console.log(singleOrder);

                    db.query({
                            sql: 'UPDATE single_order SET blockId=12 WHERE id=?' 
                        }, blockId,
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


module.exports = router;