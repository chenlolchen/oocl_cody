const express = require('express');
const traineeController = require('../controllers/trainee.server.controller.js');

module.exports = (app) => {
    const router = express.Router();

    router.use(function (req, res, next) {
       console.log("*************************");
       next();
    });

    router.route('/').get(traineeController.findAllTrainee);

    app.use('/trainees', router);
};