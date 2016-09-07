var express = require('express');
var router = express.Router();

router.route('/trade')
    .get(function (req, res) {
        res.sendFile('../html/home_broker.html')
    });

module.exports = router;