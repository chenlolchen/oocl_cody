/**
 * Created by CHENCO7 on 9/1/2017.
 */
const express = require('express');
const customerController = require('../controllers/customer.server.controller');
var multiparty = require('connect-multiparty');
var multipartMiddleware = multiparty();

module.exports = (app) => {
  const router = express.Router();

  router.route('/').post(multipartMiddleware, customerController.addCustomer);
  router.route('/:name/:password').get(multipartMiddleware, customerController.findCustomer);
  router.route('/getRedisData').get(customerController.getRedisData);

  app.use('/customers', router);
};