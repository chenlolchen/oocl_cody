/**
 * Created by CHENCO7 on 8/30/2017.
 */
var mongoose = require('mongoose');
mongoose.Promise = global.Promise;

mongoose.connect('mongodb://localhost:27017/test', {useMongoClient: true}).then(function (db) {
    console.log('db start ..');
}).catch(function (err) {
    console.log('DB connect failed!');
    console.log(err.stack);
});

let userSchema = require('./schema/User');
let bookSchema = require('./schema/Book');
let userModel = mongoose.model('User', userSchema);
let bookModel = mongoose.model('Book', )

let user = {
    name: 'cody2',
    bookId: 123456
};

console.log(userModel.create(user).then(function (data) {
    console.log(data);

}));

mongoose.disconnect();