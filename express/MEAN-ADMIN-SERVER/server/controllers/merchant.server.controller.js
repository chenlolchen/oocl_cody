require('../models/merchant.model.js')
const mongoose = require('mongoose');
let merchantModel = mongoose.model('merchants');
let request = require('request');
module.exports = {
    addMerchant: addMerchant,
    findMerchants: findMerchants,
    findMerchantById: findMerchantById,
    findMerchantByStatus: findMerchantByStatus,
    getMerchantStatus: getMerchantStatus,
    changeMerchantStatusToBlack: changeMerchantStatusToBlack,
    changeMerchantStatusToWhite: changeMerchantStatusToWhite,
    changeMerchantStatusToRejected: changeMerchantStatusToRejected,
    getMerchantCount: getMerchantCount,
    statusChangeResponse: statusChangeResponse
};

function addMerchant(merchant, callback) {
    // merchant._id = new mongoose.Types.ObjectId(),
    merchantModel.find({
        name: merchant.name,
        password: merchant.password
    }, function(err, data) {
        console.log(data);
        if (!data) {
            merchantTemp.save(function(err, data) {
                if (!err)
                    return data
                else
                    return null;
            });
        } else {
            return null;
        }
    })
}

function findMerchants(callback) {
    merchantModel.find({}, function(err, data) {
        callback(err, data);
    });
}

function findMerchantById(id, callback) {
    merchantModel.find({ _id: id }, function(err, data) {
        callback(err, data);
    })
}

function findMerchantByStatus(status, callback) {
    merchantModel.find({ mStatus: status }, function(err, data) {

        callback(err, data);
    })
}

function getMerchantStatus(id, callback) {
    merchantModel.find({
        _id: id
    }, function(err, data) {
        callback(err, data);
    })
}

function changeMerchantStatusToBlack(id, callback) {
    merchantModel.update({ _id: id }, {
        $set: { mStatus: 'black_list' }
    }, function(err, data) {
        if (data.nModified == 1) {
            statusChangeResponse(id, 'white_list', 'black_list');
        }
        callback(err, data);
    })
}

function changeMerchantStatusToWhite(id, callback) {
    merchantModel.update({ _id: id }, {
        $set: { mStatus: 'white_list' }
    }, function(err, data) {
        if (data.nModified == 1) {
            statusChangeResponse(id, 'black_list', 'white_list');
        }
        callback(err, data);
    })
}

function changeMerchantStatusToRejected(id, reason, callback) {
    merchantModel.update({ _id: id }, {
        $set: { mStatus: 'reject', rejectReason: reason }
    }, function(err, data) {
        if (data.nModified == 1) {
            statusChangeResponse(id, 'audit', 'reject');
        }
        callback(err, data);
    })
}

function getMerchantCount(callbacl) {
    var count = {
        all: 0,
        audit: 0,
        white: 0,
        black: 0,
        reject: 0
    };
    merchantModel.find({}, function(err, data) {
        for (var i = 0; i < data.length; i++) {
            count.all++;
            if (data[i].mStatus == 'audit')
                count.audit++;
            else if (data[i].mStatus == 'white_list')
                count.white++;
            else if (data[i].mStatus == 'black_list')
                count.black++
                else
                    count.reject++;
        }
        callbacl(err, count);
    });
}


function statusChangeResponse(id, start_status, end_status) {
    var requestData = {
        id: id,
        start_status: start_status,
        end_status: end_status
    };
    request({
        url: 'http://ZHA-ITA118-w7:3002/#!/api/merchants/status',
        method: 'POST',
        body: JSON.stringify(requestData),
        json: true,
        headers: {
            "content-type": "application/json",
        }
    }, function(err, response, BODY) {
        if (!err && response.statusCode == 200) {
            console.log("Merchant status change info end success");
        }
    });
}