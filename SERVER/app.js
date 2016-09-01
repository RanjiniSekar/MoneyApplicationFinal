var express = require('express');
var bodyParser = require('body-parser');
var cors = require('cors');
var app = express();


app.use(cors());

var port = process.env.PORT || 8080;

app.use(bodyParser.json());
app.use(bodyParser.urlencoded({
    extended: true
}));

app.listen(port, function () {
    console.log('Listening on port ' + port);
});


var traderRouter = require('./routes/trader');
var pmRouter = require('./routes/pm');
var brokerRouter = require('./routes/broker');
var adminRouter = require('./routes/admin');

app.use('/api/trader', traderRouter);
app.use('/api/pm', pmRouter);
app.use('/api/admin', adminRouter);
app.use('/api/broker', brokerRouter);

app.use('/', function (req, res) {
    res.send('Welcome');
});
