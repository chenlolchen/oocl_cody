require('../../server/models/admin.model.js')
const mongoose = require('mongoose');
let adminModel = mongoose.model('admins');
let adminController = require('../../server/controllers/admin.server.controller.js')
    // insert admin data
var docs = [{
    name: "anegrs",
    password: "anegrs"
}, {
    name: "sky",
    password: "sky"
}];

var insertResult = adminModel.insertMany(docs);
console.log(insertResult);

var findResult = adminController.checkLogin({
    name: "sky",
    password: "sky"
});
console.log(findResult);