var express = require('express');
var router = express.Router();
var nodemailer = require('../mailer/mailer.js')

/* GET users listing. */
router.get('/', function (req, res) {
    console.log("GET request on /trader");
    res.send('Welcome to trader page');
});


router.route('/blocks')
    .post(function (req, res) {
        /* Insert general block info into trader_block table */
        var blockId = 0;

        db.query({
                sql: 'INSERT INTO trader_block (block_id, t_id, b_id, symbol, quantity, order_type) VALUES (?, ?, ?, ?, ?, ?)'
            }, [blockId, req.body.traderId, req.body.brokerId, req.body.symbol, req.body.quantity, req.body.orderType],
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


                    res.status(201).send(results);
                }
            }
        );

    });


router.route('/sendMail')
    .get(function (req, res) {
        nodemailer.send_mail({
            sender: 'info@moneytree.com',
            to: 'otorrillas@gmail.com',
            subject: 'Govind is a pussy',
            body: 'Hey there I am using WhatsApp'
        }, function (error, success) {
            if (error)
                console.log(error);
            else
                console.log(success);
        });

    })

module.exports = router;