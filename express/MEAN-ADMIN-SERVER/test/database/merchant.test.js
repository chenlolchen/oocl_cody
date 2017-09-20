require('../../server/models/merchant.model.js')
const mongoose = require('mongoose');
let merchantModel = mongoose.model('admins');
let merchantController = require('../../server/controllers/merchant.server.controller.js')
    // insert admin data
var docs = [{
    name: 'audi',
    password: 'audi',
    idCard: 'audi.jpg',
    avator: 'audi.jpg',
    mStatus: 'audit',
    address: 'german'
}, {
    name: 'benz',
    password: 'benz',
    idCard: 'benz.jpg',
    avator: 'benz.jpg',
    mStatus: 'white_list',
    address: 'frensh'
}, {
    name: 'bmw',
    password: 'bmw',
    idCard: 'bmw.jpg',
    avator: 'bmw.jpg',
    mStatus: 'black_list',
    address: 'japan'
}];
merchantModel.insertMany(docs);

var findResult = adminController.checkLogin({
    name: "sky",
    password: "sky"
});