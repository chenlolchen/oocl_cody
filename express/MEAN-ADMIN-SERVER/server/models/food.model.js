/**
 * Created by ZHENGNI3 on 9/1/2017.
 */
var mongoose = require('mongoose'),
    Schema = mongoose.Schema;

var FoodsSchema = new Schema({
    name: String,
    price: Number,
    image: String,
    categories: String,
    merchant: { type: Schema.Types.ObjectId, ref: 'merchants' }
}, {
    collection: 'foods'
});

mongoose.model('foods', FoodsSchema);