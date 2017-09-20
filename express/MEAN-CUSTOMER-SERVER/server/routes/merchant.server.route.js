/**
 * Created by CHENCO7 on 9/1/2017.
 */
const express = require('express');
const merchantController = require('../controllers/merchant.server.controller');
// const merchantStatusController = require('../controllers/merchant.status.server.controller');

module.exports = (app) => {
    const router = express.Router();

    router.route('/').get(merchantController.findAllMerchants);
    router.route('/').post(merchantController.addMerchant);
    router.route('/type').get(merchantController.findMerchantByTypeId);
    // router.route('/status').post(merchantStatusController.updateMerchantStatus);

    app.use('/merchants', router);
};