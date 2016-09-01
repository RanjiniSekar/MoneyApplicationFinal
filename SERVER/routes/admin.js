var express = require('express');
var router = express.Router();

/* GET users listing. */
router.get('/', function (req, res, next) {
    console.log("GET request on /admin");
    res.send('Welcome to admin page');
});

module.exports = router;