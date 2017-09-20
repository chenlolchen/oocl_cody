const express = require('express');
const adminController = require('../controllers/admin.server.controller.js');
var expressJwt = require('express-jwt');
var jwt = require('jsonwebtoken');
const envConfig = require('../config/env/config_development.json');
module.exports = (app) => {
    const router = express.Router();

    router.use(function(req, res, next) {
        console.log("*************************");
        next();
    });

    router.route('/login').post(function(req, res, next) {
        var adminLogin = req.body;
        adminController.checkLogin(adminLogin, function(err, data) {
            // 如果data不会空， 验证通过跳转到管理界面
            // 如果data为空返回login界面
            if (data != undefined) {
                console.log("------ Admin Login -------");
                console.log("AdminName :" + data.name);
                console.log("Password  :" + data.password);
                console.log("--------------------------");

                var admin_token = jwt.sign(data, envConfig.secret, { expiresIn: 60 * 1000 });
                res.json({
                    token: admin_token,
                    username: 'username'
                });
            } else {
                res.json({
                    token: null,
                    username: ''
                });
            }

        });
    });

    app.use('/admin', router);
};