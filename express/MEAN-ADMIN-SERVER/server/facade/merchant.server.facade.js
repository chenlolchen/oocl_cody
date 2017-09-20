/**
 * Created by CHENCO7 on 9/1/2017.
 */
require('../models/order.model');
const mongoose = require('mongoose');
let orderModel = mongoose.model('order');

module.exports = {
    addOrder: addOrder,
    findAllOrders: findAllOrders
};

function findAllOrders(callback) {
    orderModel.find({}, function(err, data){
        if(err) {
            console.error(err);
        }
        console.log(data);
        callback(null, data);
    })
}

function addOrder(order, callback) {
    orderModel.create(order, function (err, data) {
        console.log(data);
        callback(null, data);
    })
}
