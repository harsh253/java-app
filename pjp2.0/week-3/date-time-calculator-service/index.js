const express = require('express');
const mongoose = require('mongoose');
const config = require('./config');
const setupController = require('./controllers/setupController');
const apiController = require('./controllers/apiController');

var app = express();
var port = process.env.PORT || 3000;

mongoose.connect(config.DBUrl(), {useNewUrlParser: true}, (err)=>{
    err ? console.log(err) : console.log("Connected");
})

setupController(app);
apiController(app);

app.listen(port);