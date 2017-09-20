/** Created by CUIJA on 05-19-2017.*/

var angular = require('angular');
var uirouter = require('@uirouter/angularjs');
var uibootstrap = require('angular-ui-bootstrap');

var core = require('./core');
var auth = require('./auth');
var food = require('./food');
var merchant = require('./merchant');
var order = require('./order');

module.exports = angular.module('ita-app', [
  'ui.router',
  'ui.bootstrap',
  // application modules
  core,
  auth,
  food,
  merchant,
  order
]);