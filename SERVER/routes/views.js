var express = require('express');
var router = express.Router();
var path = require('path');

router.route('/trade')
    .get(function (req, res) {
        res.sendFile(path.join(__dirname + '/../html/home_broker.html'));
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