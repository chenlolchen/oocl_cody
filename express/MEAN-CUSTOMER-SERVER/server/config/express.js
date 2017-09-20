const express = require('express');
const path = require('path');
const favicon = require('serve-favicon');
const logger = require('morgan');
const cookieParser = require('cookie-parser');
const bodyParser = require('body-parser');
const app = express();
const router = express.Router();
const config = require('./config.js');
const envConfig = require('./env/config_development.json');
const expressJwt = require('express-jwt');
var update_socket = require('../socket_io/status.update.js');

// view engine setup
app.set(path.join(path.resolve(__dirname, '..'), 'views'));
app.set('view engine', 'ejs');

app.use(logger('dev'));
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({extended: false}));
app.use(cookieParser());
app.use(express.static('../public'));

config.getGlobbedFiles(path.join(path.resolve(__dirname, '..'), 'routes/**/*.js')).forEach(function(routePath) {
    require(path.resolve(routePath))(router);
});

app.all('*', function (req, res, next) {
  res.header("Access-Control-Allow-Origin", "*");
  res.header('Access-Control-Allow-Methods', 'GET,PUT,POST,DELETE,OPTIONS');
  res.header("Access-Control-Allow-Headers", "X-Requested-With,X-Powered-By,Content-Type");
  if (req.method === 'OPTIONS') {
    res.status(200).end();
  } else {
    next();
  }
});

app.use(envConfig.NJ_DOM_FS.context, router);

app.use(expressJwt({ secret: envConfig.secret}));

app.use(function (req, res, next) {
    console.log("aa");
    const err = new Error('Not Found');
    err.status = 404;
    // next(err);
    res.json({status: 404, message: "page not found"});
});

app.use(function (err, req, res, next) {
    // set locals, only providing error in development
    res.locals.message = err.message;
    res.locals.error = req.app.get('env') === 'development' ? err : {};

    // render the error page
    res.status(err.status || 500);
    // res.render('error');
    res.json({status: 500, message: "server error"});
});

app.ready = function(server) {
  update_socket.prepareSocketIO(server);
}

exports = module.exports = app;
