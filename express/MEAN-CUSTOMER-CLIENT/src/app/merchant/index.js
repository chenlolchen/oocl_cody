var angular = require('angular');
//var merchant = require('../merchant');
var merchantRoutes = require('./routes/merchant.routes');

var merchantService = require('./services/merchant.service');

var merchantController = require('./controllers/merchant.controller');

const moduleName = 'merchant';

angular.module(moduleName, [])
    .config(merchantRoutes)
    .factory('merchantService', merchantService)
    .controller('merchantController', merchantController)
;

module.exports = moduleName;