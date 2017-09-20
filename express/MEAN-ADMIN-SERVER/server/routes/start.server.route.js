const express = require('express');

module.exports = (app) => {
    const router = express.Router();

    router.use(function(req, res, next) {
        console.log("*************************");
        next();
    });

    router.route('/').get(function(req, res, next) {
        res.render('');
    });

    app.use('/login', router);
};