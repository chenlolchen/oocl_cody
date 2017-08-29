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

// Remove Tom
studentModel.remove(
    {name: 'Tom' },
    function (err) {
        if (err) return console.error(err);
        else return console.log('Removed !');
});