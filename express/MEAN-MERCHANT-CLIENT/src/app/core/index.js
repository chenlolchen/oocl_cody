/** Created by CUIJA on 05-19-2017.*/

var angular = require('angular');


var coreRoutes = require('./routes/core.routes');

var navMenuService = require('./services/menu.service');
var orderService = require('./services/orderService');

var navbarController = require('./components/navbar/navbar.controller');
var welcomeController = require('./controllers/welcome.controller');
var orderController = require('./controllers/order.controller');

var navbarComponent = require('./components/navbar/navbar');
var foodController = require('./controllers/food.controller');
var foodService = require('./services/food.service');
const moduleName = 'core';

angular.module(moduleName, [])
  .config(coreRoutes)
  .factory('navMenuService', navMenuService)
    .factory('orderService', orderService)
  .component('navbar', navbarComponent)
  .controller('navbarController', navbarController)
  .controller('foodController',foodController)
  .factory('foodService',foodService)
      .controller('welcomeController',welcomeController)
    .controller('orderController',orderController)
;

module.exports = moduleName;