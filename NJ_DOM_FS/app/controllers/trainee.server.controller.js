var _ = require('lodash');
var traineeFacade = require('../../app/facade/trainee.server.facade.js');

module.exports = {
    findAllTrainee: findAllTrainee
};

function findAllTrainee(req, res, next) {
    traineeFacade.findAllTrainee((error, result) => {
        if(error){
            return next(new Error(error));
        }else {
            return res.json(result);
        }
    })
}
