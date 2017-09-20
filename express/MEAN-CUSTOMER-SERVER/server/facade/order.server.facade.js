/**
 * Created by CHENCO7 on 9/1/2017.
 */
require('../models/order.model');
require('../models/customer.model');
require('../models/merchant.model');
const mongoose = require('mongoose');
let orderModel = mongoose.model('order');
const redis = require('redis');
const _ = require('lodash');

module.exports = {
  addOrder: addOrder,
  findAllOrders: findAllOrders,
  findOrderById: findOrderById,
  addOrderItem: addOrderItem,
  findOrderItems: findOrderItems
};

function findAllOrders(customerId, callback) {
  orderModel.find({'customer': customerId}).
      populate('customer').
      populate('merchant').
      exec(function(err, story) {
        console.log('***********');
        console.log(story);
        callback(null, story);
        // prints "The author is Ian Fleming"
      });
}

function addOrder(customerName, order, callback) {
  let customerOrderName = customerName + "_order";

  orderModel.create(order, function(err, data) {
    let client = redis.createClient();
    client.spop(customerOrderName);
    callback(null, data);
  });
}

function findOrderById(orderId, callback) {
  orderModel.findOne({_id: orderId}, (err, data) => {
    callback(null, data);
  })
}

function addOrderItem(customerName, orderItem, operator, callback) {
 let client = redis.createClient();
 let customerOrderName = customerName + "_order";

 client.smembers(customerOrderName, function(err, data) {
   let customerOrder = [];

   if(data.length > 0){
     if(operator === 'add'){
       let flag = true;

       _.each(data, function(value) {
         customerOrder = JSON.parse(value);
         _.each(customerOrder, function(item) {
           if(item._id === orderItem._id){
             item.amount++;
             flag = false;
           }
         })
       });

       if(flag){
         customerOrder = JSON.parse(data);
         customerOrder.push(orderItem);
       }
     } else {
       _.each(data, function(value) {
         customerOrder = JSON.parse(value);
         _.each(customerOrder, function(item) {
           if(item._id === orderItem._id){
             item.amount--;
             flag = false;
           }
         })
       });
     }
   }else{
     customerOrder.push(orderItem);
   }

   client.spop(customerOrderName);
   client.sadd(customerOrderName, JSON.stringify(customerOrder));
   callback(null, customerOrder);
 });
}

function findOrderItems(customerName, callback) {
  let client = redis.createClient();
  let customerOrderName = customerName + "_order";
  console.log(customerOrderName);

  client.smembers(customerOrderName, function(err, data) {
    if(data.length === 0){
      callback(null, null);
    }else {
      callback(null, JSON.parse(data));
    }
  });
}
