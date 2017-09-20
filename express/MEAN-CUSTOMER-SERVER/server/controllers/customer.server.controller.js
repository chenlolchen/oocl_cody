/**
 * Created by CHENCO7 on 9/1/2017.
 */
const customerFacade = require('../facade/customer.server.facade');
const fileUtil = require('../utils/fileUtil');
const config = require('../config/env/config_development.json');
const redis = require('redis'), client = redis.createClient();
const jwt = require('jsonwebtoken');

module.exports = {
  addCustomer: addCustomer,
  findCustomer: findCustomer,
  getRedisData: getRedisData
};

function getRedisData(req, res, next) {
  client.smembers("customer", function(a, b) {
    console.log(a);
    console.log(b);
    var c = JSON.parse(b);
    console.log(c.name);
    return res.json(c);
  });
}

function addCustomer(req, res, next) {
  let body = req.body;
  let posterDatas = req.files.file;
  let customer = {};
  customer.name = body.username;
  customer.password = body.password;
  customer.avator = fileUtil.uploadFile(posterDatas[0], 'upload');
  customer.address = "";

  customerFacade.addCustomer(customer, (error, result) => {
    if(error){
      return next(new Error(error));
    }else {
      return res.json(result);
    }
  })
}

function findCustomer(req, res, next) {
  let params = req.params;
  let customer = {name: params.name, password: params.password};
  customerFacade.findCustomer(customer, (error, result) => {
    if(error){
      return next(new Error(error));
    }else {
      console.log(result);
      var temp = JSON.stringify(result);

      console.log(temp);
      console.log(params.password);
      client.sadd("customer", temp);
      if(result === null){
        res.json({
          code:-1,
          message:"wrong password"
        });
      }else{
        if(result.password === params.password){
          var customer = {
            _id: result._id,
            customerName : result.name
          }
          var token = jwt.sign(customer, config.secret, {expiresIn : "3d"});
          console.log("token = " + token);
          res.json({
            code:1,
            token : token
          })
        }else{
          res.json({
            code:-1,
            message:"wrong password"
          });
        }
      }
    }
  })
}
