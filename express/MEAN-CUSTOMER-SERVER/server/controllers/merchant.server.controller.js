let merchantFacade = require('../facade/merchant.server.facade');

module.exports = {
    findAllMerchants : findAllMerchants,
    addMerchant : addMerchant,
    findMerchantByTypeId : findMerchantByTypeId
};

function findAllMerchants(req, res, next) {
    console.log('test find....');
    merchantFacade.findAllMerchants((err, data)=> {
        if (err) {
            return next(new Error(err));
        } else {
            console.log("in call..con..");
            return res.json(data);
        }
    });
}

function addMerchant(req, res, next){
    console.log('add.. test..');
    let body = req.body;
    console.log(body);
    console.log('test add merchant..');
    merchantFacade.addMerchant(body.merchant, (err, data)=>{
        if (err) {
            return next(new Error(err));
        } else {
            return res.json(data);
        }
    });
}

function findMerchantByTypeId(req, res, next){
    var typeId = req.query.typeId;
    console.log(typeId);
    merchantFacade.findMerchantByTypeId(typeId, (err, data) => {
        console.log('merchant..... in contr' + data);
        if (err) {
            return next(new Error(err));
        } else {
            return res.json(data);
        }
    });
}