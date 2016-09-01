var mysql = require('mysql');

var connection = mysql.createConnection({
    host: 'localhost',
    user: 'nodeserver',
    password: 'S@pientBaby',
    database: 'moneytree'
});

module.exports = connection;