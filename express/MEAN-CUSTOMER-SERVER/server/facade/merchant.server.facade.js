let foodFacade = require('../facade/food.server.facade');
require('../models/merchant.model');
require('../models/food.model');
const mongoose = require('mongoose');
mongoose.Promise = global.Promise;

let merchantModel = mongoose.model('merchants');
let foodModel = mongoose.model('foods');

module.exports = {
    findAllMerchants : findAllMerchants,
    addMerchant : addMerchant,
    findMerchantByTypeId : findMerchantByTypeId
};

function findAllMerchants(callback){
    console.log('test..............');
    merchantModel.find({mStatus : 'white_list'}, function(err, data){
        console.log('in find..');
        if(err) {
            console.error(err);
        }
        console.log(data);
        callback(null, data);
    });
}

function addMerchant(merchant, callback){
    merchantModel.create(merchant, function(err, data){
        callback(null, data);
    });
}

function findMerchantByTypeId(typeId, callback){
    foodFacade.findFoodByTypeId(typeId, (err, data) => {
            if(err) {
                console.error(err);
            }
            merchantModel.find({$and : [{_id : {$in : data}}, {mStatus : 'white_list'}]}, (err, data) => {
                if(err) {
                    console.error(err);
                }
                console.log('in find merch....... ' + data);
                callback(null, data);
            });
    });

}