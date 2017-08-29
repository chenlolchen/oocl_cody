/**
 * Created by CHENCO7 on 8/29/2017.
 */
var mongoose = require('mongoose');
mongoose.Promise = global.Promise;

mongoose.connect('mongodb://localhost:27017/test', {useMongoClient: true}).then(function (db) {
    console.log('db start ..');
}).catch(function (err) {
    console.log('DB connect failed!');
    console.log(err.stack);
});

let customerSchema = require('./schema/Customer');
let customerModel = mongoose.model('Customer', customerSchema);

let customer = {
    name: 'cody2',
    password: '4',
    code: '1002',
    address: {
        addressName: "珠海",
        zipcode: 222222
    }
};

customerModel.create(customer, function (a, b) {
    console.log(a);
    console.log(b);
});

mongoose.disconnect();