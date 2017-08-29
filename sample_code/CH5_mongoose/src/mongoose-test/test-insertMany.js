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

var students = [{
    name: 'Mary',
    age: 10,
    school: {
        address: 'USA',
        phone: '911',
        fee: 9000
    }
}, {
    name: 'Ken',
    age: 10,
    school: {
        address: 'USA',
        phone: '911',
        fee: 9000
    }
}];

// Insert the students !
// Note that the middlewares will NOT be invoked !
studentModel.insertMany(students, function (error, docs) {
    if (error) return console.error(error);
    else     console.log(docs);
});
