/**
 * Created by HUANGYE2 on 7/31/2017.
 */

var mongoose = require('mongoose');
var SchoolSchema = require('./School');
var schema = mongoose.Schema({
    name: String,
    age: Number,
    school: SchoolSchema
}, {
    collection: 'students'
});

// Middlewares
schema.pre('save', function(next) {
    console.log('Student.pre.save ! -- 1', this.name);
    next();
});

schema.pre('save', function(next) {
    console.log('Student.pre.save ! -- 2', this.name);
    next();
});

schema.post('save', function(doc) {
    console.log('Student.post.save ! -- 1', doc.name);
});

module.exports = schema;