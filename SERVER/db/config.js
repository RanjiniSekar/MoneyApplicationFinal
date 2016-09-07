var mysql = require('mysql');

var pool = mysql.createPool({
    connectionLimit: 100,
    host: 'localhost',
    user: 'nodeserver',
    password: 'S@pientBaby',
    database: 'moneytree'
});

module.exports = pool;