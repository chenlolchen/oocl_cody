/**
 * Created by ZHENGNI3 on 9/1/2017.
 */
var mongoose = require('mongoose'), Schema = mongoose.Schema;

var OrderSchema = new Schema({
    processNumber: String,
    createDate: Date,
    amount: Number,
    foods: [
        { 
            name: String,
            price: Number,
            image: String
        } ],
    merchant: { type: Schema.Types.ObjectId, ref: 'merchants' },
    customer: { type: Schema.Types.ObjectId, ref: 'customers' }
}, {
    collection: 'orders'
});

mongoose.model('order', OrderSchema);