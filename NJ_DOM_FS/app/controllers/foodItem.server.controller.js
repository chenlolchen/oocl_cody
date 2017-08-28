const _ = require('lodash');
const foodItemFacade = require('../../app/facade/foodItem.server.facade.js');
const uuidv4 = require('uuid/v4');

module.exports = {
    getFoodItemByName : getFoodItemByName,
    getFoodItemByProducer: getFoodItemByProducer,
    addFoodItem: addFoodItem,
    deleteFoodItem: deleteFoodItem,
    findAllFoodItem: findAllFoodItem,
    findByNameAndProducer: findByNameAndProducer
};

function getFoodItemByName(req, res, next) {
    let params = req.params;
    let name = params.name;
    if (_.isEmpty(name)) {
        return next(new Error('food name is empty'));
    } else {
    foodItemFacade.getFoodItemByName(name, (error, result) => {
        if (error) {
            return next(new Error(error));
        } else {
            return res.json(result);
            // res.render('foodItem', result);
        }
    });
    }
}

function getFoodItemByProducer(req, res, next) {
    let body = req.body;
    let producer = body.producer;
    if (_.isEmpty(producer)) {
        return next(new Error('producer name is empty'));
    } else {
    foodItemFacade.getFoodItemByProducer(producer, (error, result) => {
        if (error) {
            return next(new Error(error));
        } else {
            return res.json(result);
        }
    });
    }
}

function addFoodItem(req, res, next) {
    let body = req.body;
    let foodItem = {
        itemId: uuidv4(),
        name: body.name,
        price: body.price,
        curreny: body.curreny,
        producer: body.producer,
        bestBefore: body.bestBefore,
        amount: body.amount,
        createDatetime: body.createDatetime,
        updateDatetime: body.updateDatetime
    };

    foodItemFacade.addFoodItem(foodItem, (error, result) => {
        if(error){
            return next(new Error(error));
        }else {
            return res.json(result);
        }
    })
}

function deleteFoodItem(req, res, next) {
    let body = req.body;
    let itemId = body.itemId;

    foodItemFacade.deleteFoodItem(itemId, (error, result) => {
        if(error){
            return next(new Error(error));
        }else {
            return res.json(result);
        }
    })
}

function findAllFoodItem(req, res, next) {
    foodItemFacade.findAllFoodItem((error, result) => {
        if(error){
            return next(new Error(error));
        }else {
            return res.json(result);
        }
    })
}

function findByNameAndProducer(req, res, next) {
    let body = req.body;
    let name = body.name;
    let producer = body.producer;
    foodItemFacade.findByNameAndProducer(name, producer, (error, result) => {
        if(error){
            return next(new Error(error));
        }else {
            return res.json(result);
        }
    })
}