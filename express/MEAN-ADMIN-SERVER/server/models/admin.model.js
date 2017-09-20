/**
 * Created by ZHENGNI3 on 9/1/2017.
 */
var mongoose = require('mongoose'),
    Schema = mongoose.Schema;

var AdminsSchema = new Schema({
    name: String,
    password: String
}, {
    collection: 'admins'
});

mongoose.model('admins', AdminsSchema);