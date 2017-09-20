/** Created by CUIJA on 05-19-2017.*/

var angular = require('angular');

var core = require('../core');

var authRoutes = require('./routes/auth.routes');

var authMenuConfig = require('./configs/menu.config');

var loginCtr = require('./controllers/login.controller');
var loginService = require('./services/login.service');

var registerCtr = require('./controllers/register.controller');

const moduleName = 'auth';
var ngFileUpload = require('ng-file-upload');

angular.module(moduleName, [core, ngFileUpload]).
    config(authRoutes).
    factory('loginService', loginService).
    controller('loginController', loginCtr).
    controller('registerController', registerCtr).
    run(authMenuConfig);

module.exports = moduleName;
