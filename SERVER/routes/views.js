var express = require('express');
var router = express.Router();
var path = require('path');

router.route('/trade')
    .get(function (req, res) {
        var uid = req.param('uid');
        var pool = require('../db/config');
        pool.getConnection(function (err, conn) {
            conn.query({
                    sql: 'SELECT EXISTS(SELECT 1 FROM temp_link WHERE uid = ?) as uidExists'

                }, [uid],
                function (error, results, fields) {
                    // error will be an Error if one occurred during the query 
                    // results will contain the results of the query 
                    // fields will contain information about the returned results fields (if any)
                    if (error) {
                        console.log('Error performing the query:');
                        console.log(error);
                        res.sendFile(path.join(__dirname + '/../html/error.html'));
                    } else {
                        console.log(results);
                        var uidExists = results.uidExists;
                        if (uidExists == "1")
                            res.sendFile(path.join(__dirname + '/../html/home_broker.html'));
                        else
                            res.status(404).send("Trade has already been executed");
                    }
                });
            conn.release();
        });

    });

router.route('/success')
    .get(function (req, res) {
        res.sendFile(path.join(__dirname + '/../html/success.html'));
    });

router.route('/error')
    .get(function (req, res) {
        res.sendFile(path.join(__dirname + '/../html/error.html'));
    });

module.exports = router;