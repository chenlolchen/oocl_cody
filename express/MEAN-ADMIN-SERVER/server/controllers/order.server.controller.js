/**
 * Created by CHENCO7 on 9/1/2017.
 */
let orderFacade = require('../facade/order.server.facade');

module.exports = {
    addOrder: addOrder,
    findAllOrders: findAllOrders
};

function findAllOrders(req, res, next) {
    orderFacade.findAllTrainee((error, result) => {
        if (error) {
            return next(new Error(error));
        } else {
            return res.json(result);
        }
    })
}

function addOrder(req, res, next) {
    orderFacade.addOrder(req.body, (error, result) => {
        if (error) {
            return next(new Error(error));
        } else {
            return res.json(result);
        }
    })
}