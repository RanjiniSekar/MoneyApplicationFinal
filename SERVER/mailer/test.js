var nodemailer = require('nodemailer');

nodemailer.sendmail = true;

var options = {
    host: 'localhost',
    port: 25,
    tls: {
        rejectUnauthorized: false
    }
}

var transporter = nodemailer.createTransport(options);

module.exports = transporter;