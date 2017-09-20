/**
 * Created by ZHENGNI3 on 9/1/2017.
 */
require('../models/food.model');
const mongoose = require('mongoose');
require('../models/merchant.model');
let foodModel = mongoose.model('foods');

module.exports = {
  getAllFoods: getAllFoods,
  getFoodsByCategories: getFoodsByCategories,
  getFoodsByFoodId: getFoodsByFoodId,
  findFoodByTypeId: findFoodByTypeId
};

function getAllFoods(merchantId, callback) {
  foodModel.find({'merchant': merchantId})
  //  .populate('merchant')
      .populate({path: 'merchant', select: 'name address'}).
      exec(function(err, foods) {
        if (err)
          console.log(err);
        callback(null, foods);
      });
};

function getFoodsByCategories(merchantId, categories, callback) {
  foodModel.find({$and: [{categories: categories}, {'merchant': merchantId}]}).
      populate('merchant').
      exec(function(err, foods) {
        if (err)
          console.log(err);
        callback(null, foods);
      });
};

function getFoodsByFoodId(foodId, callback) {
  console.log('get...' + foodId);
  foodModel.find({_id: foodId}).populate('merchant').exec(function(err, foods) {
    if (err)
      console.log(err);
    callback(null, foods);
  });
};

function findFoodByTypeId(typeId, callback) {
  foodModel.distinct('merchant', {categories: typeId}, function(err, data) {
    callback(null, data);
  });
}

//just for test
// var food = [{
//         name: "酸奶",
//         price: 999.9,
//         image: "ui/idoif",
//         categories: "饮料",
//         merchant: null
//     },
//     {
//         name: "喀什",
//         price: 899.9,
//         image: "ui/idoif",
//         categories: "饮料",
//         merchant: null
//     }
// ];
// food[0].merchant = "59a92465e713d335e8d76c78";
// food[1].merchant = "59a92465e713d335e8d76c78";
// foodModel.insertMany(food, function (err, doc) {
//     if (err) return console.error(err);
//     else console.log(doc);
// });
