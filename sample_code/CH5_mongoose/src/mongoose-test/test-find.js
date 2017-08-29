/**
 * Created by yellowb on 2017/7/30.
 */

var mongoose = require('mongoose');
mongoose.Promise = global.Promise;

// Connect to mongodb
mongoose.connect(
    'mongodb://localhost:27017/test',
    {useMongoClient: true}
).then(function (db) {
    console.log('DB connected!');
}).catch(function (err) {
    console.log('DB connect failed!');
    console.log(err.stack);
});

var studentSchema = require('./schema/Student');
var studentModel = mongoose.model('Student', studentSchema);

studentModel.
    find({
        age: {$gt: 5}
    }).
//find({
//    _id: '597ee82460bf4c87e01ac951'
//}).
    limit(10).
    sort({name: 1}).
    select({name: 1, age: 1}).
    exec(function (err, result) {
        if (err) return console.error(err);
        else return console.log(result);
    });

mongoose.disconnect();