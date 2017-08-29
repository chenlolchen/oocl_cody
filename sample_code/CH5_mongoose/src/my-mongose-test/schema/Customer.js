/**
 * Created by CHENCO7 on 8/29/2017.
 */
var mongoose = require('mongoose');
var addressSchema = require('./../schema/Address');

var schema = mongoose.Schema({
    name: {type: String, required: true},
    password: {type: Number, max: 10},
    code: {type: String,
        validate: {
            validator: function (v) {
                return v.length < 5;
            },
            message: 'cccc'
        }
    },
    address: addressSchema
});

module.exports = schema;