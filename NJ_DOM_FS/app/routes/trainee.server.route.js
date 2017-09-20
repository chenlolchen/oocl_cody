const express = require('express');
const traineeController = require('../../app/controllers/trainee.server.controller.js');

module.exports = (app) => {
    const router = express.Router();
    router.route('/').get(traineeController.findAllTrainee);

    app.use('/trainees', router);
};