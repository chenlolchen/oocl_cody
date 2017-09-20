/**
 * Created by ZHENGNI3 on 9/1/2017.
 */
const express = require('express');
const foodConreoller = require('../controllers/food.server.controller');

module.exports = (app) => {
    const router = express.Router();
    router.use(function(req, res, next) {
        console.log("food.server.route.....");
        next();
    });

    //sovle param in chinese 
    // router.route('/:merchantId/:categories')
    router.route('/categories')
    .get(foodConreoller.getFoodsByCategories);

      router.route('/item/:foodId')
    .get(foodConreoller.getFoodsByFoodId);

     router.route('/:merchantId')
    .get(foodConreoller.getAllFoods);

    app.use('/food',router);
}