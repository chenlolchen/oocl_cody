const express = require('express');

module.exports = (app) => {
    const router = express.Router();
    // 过滤器
    router.all('/api/admin/manage', function(req, res, next) {
        console.log("*************************");
        next();
    });
};