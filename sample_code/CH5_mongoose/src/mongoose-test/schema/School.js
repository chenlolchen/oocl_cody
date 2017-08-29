/**
 * Created by HUANGYE2 on 7/31/2017.
 */

var mongoose = require('mongoose');
var schema = mongoose.Schema({
    address: String,
    phone: String,
    fee: Number
});
module.exports = schema;