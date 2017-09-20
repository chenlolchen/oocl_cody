/**
 * Created by ZHENGNI3 on 9/1/2017.
 */
var mongoose = require('mongoose'),
    Schema = mongoose.Schema;

var MerchantsSchema = new Schema({
    name: String,
    password: String,
    idCard: String,
    avator: String,
    mStatus: String,
    address: String,
    rejectReason: String
}, {
    collection: 'merchants'
});

mongoose.model('merchants', MerchantsSchema);