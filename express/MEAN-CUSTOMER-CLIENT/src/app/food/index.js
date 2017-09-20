/** Created by CUIJA on 05-19-2017.*/

var angular = require('angular');

var core = require('../core');

var foodRoutes = require('./routes/foodList.routes');

var authMenuConfig = require('./configs/menu.config');

var foodListCtr = require('./controllers/food.controller');

var foodListSvc = require('./services/food.service');

var orderDetailService = require('./../order/services/orderDetail.service');

const moduleName = 'food';
angular.module(moduleName, [core]).
    config(foodRoutes).
    factory("foodListService", foodListSvc).
    factory("orderDetailService", orderDetailService).
    controller('foodListController', foodListCtr).
    run(authMenuConfig);

module.exports = moduleName;
