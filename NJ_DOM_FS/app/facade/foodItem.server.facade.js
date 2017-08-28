const _ = require('lodash');
const foodItemModel = require('../../app/models/foodItems.json');
const fs = require('fs');

module.exports = {
    getFoodItemByName : getFoodItemByName,
    getFoodItemByProducer: getFoodItemByProducer,
    addFoodItem: addFoodItem,
    deleteFoodItem: deleteFoodItem,
    findAllFoodItem: findAllFoodItem,
    findByNameAndProducer: findByNameAndProducer
};

function getFoodItemByName(name, callback) {
    let result = null;
    _.forEach(foodItemModel, (item) => {
        if (_.isEqual(name, item.name)) {
            result = item;
        }
    });
    callback(null, result);
}

function getFoodItemByProducer(producer, callback) {
    let result = null;
    _.forEach(foodItemModel, (item) => {
        if (_.isEqual(producer, item.producer)) {
            result = item;
        }
    });
    callback(null, result);
}

function addFoodItem(foodItem, callback) {
    let result = null;
    result = _.concat(foodItemModel, foodItem);
    fs.writeFile('app/models/foodItems.json', JSON.stringify(result), function () {
        callback(null, result);
    });
}

function deleteFoodItem(itemId, callback) {
    let result = null;
    result = _.remove(foodItemModel, function (item) {
        if(!_.isEqual(itemId, item.itemId)){
            return item;
        }
    });
    fs.writeFile('app/models/foodItems.json', JSON.stringify(result), function () {
        callback(null, result);
    });
}

function findAllFoodItem(callback) {
    callback(null, foodItemModel);
}

function findByNameAndProducer(name, producer, callback) {
    let result = null;
    _.forEach(foodItemModel, (item) => {
        if (_.isEqual(producer, item.producer) && _.isEqual(name, item.name)) {
            result = item;
        }
    });
    callback(null, result);
}