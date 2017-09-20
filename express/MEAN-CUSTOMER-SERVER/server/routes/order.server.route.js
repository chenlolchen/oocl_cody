/**
 * Created by CHENCO7 on 9/1/2017.
 */
const express = require('express');
const orderController = require('../controllers/order.server.controller');
const _ = require('lodash');
const jwt = require('jsonwebtoken');
const config = require('../config/env/config_development.json');

module.exports = (app) => {
    const router = express.Router();

  router.use(function(req, res, next) {
    var token = req.headers.authorization;
    console.log("3333");
    console.log(token);
    if (_.isEmpty(token)){
      console.log("2222");
      return res.json({ code:-1, message:"no auth, please auth..." });
    }else{
      try{
        console.log("1111");
        var trueToken = token.split(" ")[1];
        if(trueToken === 'undefined'){
          return res.json({ code:-1, message:"no auth, please auth..." });
        }
        //这里进行验证
        console.log(config.secret);

        var decoded = jwt.verify(trueToken, config.secret);
        req.customerName = decoded.customerName;
        req._id = decoded._id;
        console.log(req.name);
        //跳到后续路由
        next();
      }catch (error){
        console.log(error);
        next(new Error(error))
      }
    }
  });

  router.route('/orderItems').get(orderController.findOrderItems);
  router.route('/orderItems').post(orderController.addOrderItem);

  router.route('/:orderId').get(orderController.findOrderById);
    router.route('/').get(orderController.findAllOrders);
    router.route('/').post(orderController.addOrder);

    app.use('/orders', router);
};