var nodemailer = require('nodemailer');

nodemailer.sendmail = true;

var options = {
	host: 'localhost',
	port: 25,
	tls:{
        rejectUnauthorized: false
    }
}

var transporter = nodemailer.createTransport(options);

var mailOptions = {
	from: 'info@moneytree.com',
        to: 'otorrillas@gmail.com',
        subject: 'Govind is a pussy',
        text: 'Hey there I am using WhatsApp'

};

transporter.sendMail(mailOptions, function(error, info){
    if(error){
        return console.log(error);
    }
    console.log('Message sent: ' + info.response);
});

