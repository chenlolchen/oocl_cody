/**
 * Created by CHENCO7 on 8/30/2017.
 */
require('../models/trainee.model');
const mongoose = require('mongoose');
let TraineeModel = mongoose.model('Trainee');

module.exports = {
    findAllTrainee: findAllTrainee
};

function findAllTrainee(callback) {
    TraineeModel.find({}, function(err, foods){
        if(err) {
            console.error(err);
        }
        console.log(err, foods);
        callback(null, foods);
    })
}