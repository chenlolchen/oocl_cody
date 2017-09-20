/**
 * Created by CHENCO7 on 9/1/2017.
 */
require('../models/customer.model');
const mongoose = require('mongoose');
const customerModel = mongoose.model('customers');

module.exports = {
  addCustomer: addCustomer,
  findCustomer: findCustomer
};

function addCustomer(customer, callback) {
  customerModel.create(customer, (error, data) => {
    callback(null, data);
  });
}

function findCustomer(customer, callback) {
  customerModel.findOne(customer, (err, data) => {
    callback(null, data);
  })
}