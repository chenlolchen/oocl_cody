/**
 * Created by CHENCO7 on 9/1/2017.
 */
const express = require('express');
const orderController = require('../controllers/order.server.controller');

module.exports = (app) => {
    const router = express.Router();

    router.route('/').get(orderController.findAllOrders);
    router.route('/').post(orderController.addOrder);

    app.use('/orders', router);
};