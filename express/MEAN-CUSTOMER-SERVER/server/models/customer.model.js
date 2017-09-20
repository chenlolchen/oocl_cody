/**
 * Created by ZHENGNI3 on 9/1/2017.
 */
var mongoose = require('mongoose'),
    Schema = mongoose.Schema;

var CustomersSchema = new Schema({
    name: String,
    password: String,
    avator: String,
    address: String
}, {
    collection: 'customers'
});

mongoose.model('customers', CustomersSchema);

// for mongo insert test
// var customer = {name: "ccc",
//     password: "456",
//     avator: "/c.jpg",
//     address: "/f.jpg"}
//
// db.customers.insertOne(customer);