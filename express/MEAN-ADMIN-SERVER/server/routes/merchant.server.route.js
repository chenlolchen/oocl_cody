const express = require('express');
var fs = require('fs');
var path = require('path');
var multiparty = require('connect-multiparty')
var multipartMiddleware = multiparty();
var merchantController = require('../controllers/merchant.server.controller.js');

var storePath = function(posterData, divPath) {
    var timestamp = Date.now();
    var type = posterData.type.split('/')[1];
    var poster = timestamp + '.' + type;
    var newPath = path.join(__dirname, '../', '/file/' + divPath + '/' + poster);
    return newPath;
};

var storeFiel = function(posterData, newPath) {
    var filePath = posterData.path;
    var originalFilename = posterData.originalFilename
    if (originalFilename) {
        fs.readFile(filePath, function(err, data) {
            fs.writeFile(newPath, data, function(err) {
                console.log(newPath);
            });
        })
    }
};

module.exports = (app) => {
    const router = express.Router();

    router.use(function(req, res, next) {
        console.log("*************************");
        next();
    });

    router.post('/merchant', multipartMiddleware, function(req, res, next) {

        var merchant = req.body;
        var posterDatas = req.files.file;
        // 根据schema从requestBody中获取添加其他字段
        merchant.idCard = storePath(posterDatas[0], 'head_portrait');
        merchant.avator = storePath(posterDatas[1], 'id_photo');
        merchant.mStatus = 'audit';
        merchantController.addMerchant(merchant, function(err, data) {
            if (data) {
                storeFiel(posterDatas[0], merchant.idCard);
                storeFiel(posterDatas[1], merchant.avator);
            }
        });
    });

    router.route('/merchants').get(function(req, res, next) {
        merchantController.findMerchants(function(err, data) {
            res.json(data);
        });

    });
    router.route('/merchants/id/:id').get(function(req, res, next) {
        merchantController.findMerchantById(req.params.id, function(err, data) {
            res.json(data);
        });

    });
    router.route('/merchants/status/:status').get(function(req, res, next) {
        merchantController.findMerchantByStatus(req.params.status, function(err, data) {
            console.log(data);
            res.json(data);
        });
    });
    router.route('/merchants/id/:id/status').get(function(req, res, next) {
        merchantController.getMerchantStatus(req.params.id, function(err, data) {
            res.json(data);
        });
    });
    router.route('/merchants/white').put(function(req, res, next) {

        var rejectReason = req.body.reason;
        merchantController.changeMerchantStatusToWhite(req.body.id, function(err, data) {
            res.json(data);
        });
    });
    router.route('/merchants/black').put(function(req, res, next) {
        merchantController.changeMerchantStatusToBlack(req.body.id, function(err, data) {
            res.json(data);
        });
    });
    router.route('/merchants/reject').put(function(req, res, next) {
        console.log(req.body);
        merchantController.changeMerchantStatusToRejected(req.body.id, req.body.reason, function(err, data) {
            res.json(data);
        });
    });

    router.route('/merchants/count').get(function(req, res, next) {
        merchantController.getMerchantCount(function(err, data) {
            res.json(data);
        });
    });


    app.use('/admin/manage', router);
};