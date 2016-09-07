var express = require('express');
var router = express.Router();
var path = require('path');

router.route('/trade')
    .get(function (req, res) {
        res.sendFile(path.join(__dirname + '/../html/home_broker.html'));
    });

module.exports = router;
