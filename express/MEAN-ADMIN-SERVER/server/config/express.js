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

// view engine setup
app.set(path.join(path.resolve(__dirname, '..'), 'views'));
app.set('view engine', 'ejs');

app.use(logger('dev'));
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: false }));
app.use(cookieParser());
app.use(express.static('public'));


app.all('*', function(req, res, next) {

    res.header("Access-Control-Allow-Origin", "*");
    res.header('Access-Control-Allow-Methods', 'GET,PUT,POST,DELETE,OPTIONS');
    res.header("Access-Control-Allow-Headers", "X-Requested-With,X-Powered-By,Content-Type,authorization");
    if (req.method === 'OPTIONS') {
        res.status(200).end();
    } else {
        next();
    }
});

// express-jwt token confirm
var expressJwt = require('express-jwt');
var jwt = require('jsonwebtoken');
app.use('/api', expressJwt({ secret: envConfig.secret }).unless({
    path: [
        '/api/admin/login'
    ]
}));
// app.use(express.join());
// app.use(express.urlencoded());



config.getGlobbedFiles(path.join(path.resolve(__dirname, '..'), 'routes/**/*.js')).forEach(function(routePath) {
    require(path.resolve(routePath))(router);
});

app.use(envConfig.NJ_DOM_FS.context, router);

app.use(function(req, res, next) {
    const err = new Error('Not Found');
    err.status = 404;
    // next(err);
    res.json({ status: 404, message: "page not found" });
});

app.use(function(err, req, res, next) {
    // set locals, only providing error in development
    res.locals.message = err.message;
    res.locals.error = req.app.get('env') === 'development' ? err : {};
    console.error(err);
    // render the error page
    res.status(err.status || 500);
    // res.render('error');
    res.json({ status: 500, message: "server error" });
});

exports = module.exports = app;