/**
 * Created by HUANGYE2 on 8/30/2017.
 */
/** Model for Person **/


var mongoose = require('mongoose');

var schema = mongoose.Schema({
    _id: mongoose.Schema.Types.ObjectId,
    name: String,
    age: Number
}, {
    collection: 'persons'
});

var personModel = mongoose.model('Person', schema);

module.exports = personModel;