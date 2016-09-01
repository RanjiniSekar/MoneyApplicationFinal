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

module.exports = router;