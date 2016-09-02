var express = require('express');
var db = require('../db/config');


var router = express.Router();
router.route('/')
    .get(function (req, res, next) {
        console.log('GET request on /admin');
        db.connect();
        db.query('SELECT * from user', function (err, rows, fields) {
            if (!err) {
                console.log(rows);
                res.json(rows);
            } else
                console.log('Error performing the query');

        });
        db.disconnect();

    })
    .post(function () {
        console.log('Inserting new user');

    });


module.exports = router;