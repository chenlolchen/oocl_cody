/**
 * Created by CHENCO7 on 8/30/2017.
 */
var mongoose = require('mongoose');

var schema = mongoose.Schema({
    name: {type: String, required: true},
    bookId: {type: Number}
});

module.exports = schema;