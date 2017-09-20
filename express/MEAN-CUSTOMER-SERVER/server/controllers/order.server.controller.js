/**
 * Created by CHENCO7 on 9/1/2017.
 */
let orderFacade = require('../facade/order.server.facade');
const numberUtil = require('../utils/numberUtil');

module.exports = {
  addOrder: addOrder,
  findAllOrders: findAllOrders,
  findOrderById: findOrderById,
  addOrderItem: addOrderItem,
  findOrderItems: findOrderItems
};

function findAllOrders(req, res, next) {
  // get by redis
  // let customerId = '59a903c9cbece8137076439d';
  let customerId = req._id;
  console.log(customerId);
  orderFacade.findAllOrders(customerId, (error, result) => {
    if (error) {
      return next(new Error(error));
    } else {
      return res.json(result);
    }
  });
}

function addOrder(req, res, next) {
  var merchant = req.body.merchantId;
  var customer = req._id;

  var order = {};
  order.foods = req.body.orderItems;
  order.processNumber = 'NO' + new Date().getTime() + numberUtil.generateMixed(3);
  order.createDate = new Date();
  order.amount = req.body.amount;
  order.merchant = merchant;
  order.customer = customer;
  order.status = "WAIT";

  orderFacade.addOrder(req.customerName, order, (error, result) => {
    if (error) {
      return next(new Error(error));
    } else {
      return res.json(result);
    }
  });
}

function findOrderById(req, res, next) {
  console.log("findOrderById ..");
  let orderId = req.params.orderId;
  orderFacade.findOrderById(orderId, (error, result) => {
    if (error) {
      return next(new Error(error));
    } else {
      return res.json(result);
    }
  });
}

function addOrderItem(req, res, next) {
  let body = req.body;
  let orderItem = body.orderItem;
  let operator = body.operator;

  orderFacade.addOrderItem(req.customerName, orderItem, operator, (error, result) => {
    if (error) {
      return next(new Error(error));
    } else {
      return res.json(result);
    }
  });
}

function findOrderItems(req, res, next) {
  console.log("findOrderItems ..");
  orderFacade.findOrderItems(req.customerName, (error, result) => {
    if (error) {
      return next(new Error(error));
    } else {
      return res.json(result);
    }
  });
}
