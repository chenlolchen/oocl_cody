require('../models/admin.model.js');
const mongoose = require('mongoose');
let adminModel = mongoose.model('admins');



module.exports = {
    checkLogin: checkLogin
};

function checkLogin(admin, callback) {
    adminModel.find({
        name: admin.name,
        password: admin.password
    }, {}, function(err, data) {
        callback(err, data[0])
    });
}