require('../../assets/css/order.css');

var angular = require('angular');
var orderRoutes = require('./routes/order.routes');
var orderDetailController = require('./controllers/orderDetail.controller');
var orderListController = require('./controllers/orderList.controller');
var orderDetailService = require('./services/orderDetail.service');
var orderListService = require('./services/orderList.service');
const moduleName = 'orderDetail';

angular.module(moduleName, []).
    config(orderRoutes).
    factory('orderDetailService', orderDetailService).
    factory('orderListService', orderListService).
    controller('orderDetailController', orderDetailController).
    controller('orderListController', orderListController);

module.exports = moduleName;