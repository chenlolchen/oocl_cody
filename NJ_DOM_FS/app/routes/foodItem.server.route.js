const express = require('express');
const foodItem = require('../../app/controllers/foodItem.server.controller.js');

module.exports = (app) => {
    const router = express.Router();
    router.route('/getFoodItemByName/:name').get(foodItem.getFoodItemByName);
    router.route('/getFoodItemByProducer').post(foodItem.getFoodItemByProducer);
    router.route('/foodItems').post(foodItem.addFoodItem);
    router.route('/foodItems').delete(foodItem.deleteFoodItem);
    router.route('/foodItems').get(foodItem.findAllFoodItem);
    router.route('/foodItems/conditions').post(foodItem.findByNameAndProducer);

    app.use('/foodStore', router);
};