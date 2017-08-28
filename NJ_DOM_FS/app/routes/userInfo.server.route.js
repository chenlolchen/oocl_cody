/**
 * Created by CHENCO7 on 8/28/2017.
 */
const express = require('express');
const userInfo = require('../../app/controllers/userInfo.server.controller.js');

module.exports = (app) => {
    const router = express.Router();
    router.route('/users/:userId').get(userInfo.searchUserByName);
    router.route('/users').post(userInfo.addUser);

    app.use('/userInfo', router);
};

