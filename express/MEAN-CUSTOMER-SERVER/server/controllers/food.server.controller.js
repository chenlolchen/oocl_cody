/**
 * Created by ZHENGNI3 on 9/1/2017.
 */
let foodFacade = require('../facade/food.server.facade');

module.exports = {
    getAllFoods: getAllFoods,
    getFoodsByCategories: getFoodsByCategories,
    getFoodsByFoodId: getFoodsByFoodId
}
function getAllFoods(req, res, next) {
    foodFacade.getAllFoods(req.params.merchantId, (err, result) => {
        if(err)
            return next(new Error(err));
        return res.json(result);
    });
}

function getFoodsByCategories(req, res, next) {
    let categories = req.query.categories;
    let merchantId = req.query.merchantId;

    console.log('categories..'+categories);
    foodFacade.getFoodsByCategories(merchantId, categories, (err, result) => {
        if(err)
            return next(new Error(err));
        return res.json(result);
    });
}

function getFoodsByFoodId(req, res, next) {
    let foodId = req.params.foodId;

    console.log('out..'+foodId);
    foodFacade.getFoodsByFoodId(foodId, (err, result) => {
        if(err)
            return next(new Error(err));
        return res.json(result);
    });
}