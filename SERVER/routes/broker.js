var express = require('express');
var router = express.Router();

/* GET users listing. */
router.get('/', function (req, res, next) {
    console.log("GET request on /broker");
    res.send('Welcome to broker page');
});

module.exports = router;