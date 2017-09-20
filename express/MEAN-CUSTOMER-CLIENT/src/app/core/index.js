var angular = require('angular');

var coreRoutes = require('./routes/core.routes');

var navMenuService = require('./services/menu.service');
var navbarController = require('./components/navbar/navbar.controller');
var navbarComponent = require('./components/navbar/navbar');

var footerService = require('./services/footer.service');
var footerController = require('./components/footer/footer.controller');
var footerComponent = require('./components/footer/footer');

const moduleName = 'core';

angular.module(moduleName, []).
    config(coreRoutes).
    factory('navMenuService', navMenuService).
    component('navbar', navbarComponent).
    controller('navbarController', navbarController).
    factory('footerService', footerService).
    component('footer', footerComponent).
    controller('footerController', footerController);

module.exports = moduleName;