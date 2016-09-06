var nodemailer = require('nodemailer');

nodemailer.sendmail = true;

var options = {
	host: 'localhost',
	port: 25,
	auth: {
	    user: 'nodeserver',
	    pass: 'S@pientTeam4'
	}
}

var transporter = nodemailer.createTransport(options);


