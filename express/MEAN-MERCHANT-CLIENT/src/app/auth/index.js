/** Created by CUIJA on 05-19-2017.*/

var angular = require('angular');

var core = require('../core');


var authRoutes = require('./routes/auth.routes');

var loginController = require('./controllers/login.controller');
var registerController = require('./controllers/register.controller');
var reRegisterController = require('./controllers/reRegister.controller');
var merchantInfoController = require('./controllers/merchantInfo.controller');

var userService = require('./services/user.service');
var authConfig = require('./configs/auth.config');
var authInterceptorService = require('./services/authInterceptor.service');

var ngFileUpload = require('ng-file-upload');

const moduleName = 'auth';

angular.module(moduleName, [
  core,
   ngFileUpload
])
  .config(authRoutes)
  .factory('userService', userService)
    .factory('authInterceptorService',authInterceptorService)
    .config( function($httpProvider){
        $httpProvider.interceptors.push('authInterceptorService')
    })
  .controller('loginController',loginController)
  .controller('registerController',registerController)
    .controller('reRegisterController',reRegisterController)
    .controller('merchantInfoController',merchantInfoController)
     .run(authConfig)
;

module.exports = moduleName;
