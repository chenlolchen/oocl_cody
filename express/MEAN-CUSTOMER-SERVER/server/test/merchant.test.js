var app = require('../app');
var request = require('supertest')(app);
var should = require('should');

describe('test findAllMerchants....', function () {
    it(' in it...', function (done) {
        request.get('/api/merchants')
            .expect(200, function (err, res) {
                should.not.exist(err);
                res.text.should.containEql('m_jordan');
                done();
            });
    });
});

describe('test findMerchantByTypeId....', function (){
    var typeId = 'drink';
    it(' in it...', function (done) {
        request.get('/api/merchants/type?typeId=drink')
            .expect(200, function (err, res) {
                should.not.exist(err);
                console.log(res.text);
                res.text.should.containEql('m_jordan');
                done();
            });
    });
});

describe('test addMerchant....', function () {
      var merchant = {
          "merchant" : {
              "name" : "jjjjj",
              "password": "123",
              "idCard": "ddd",
              "avator": "ddd",
              "mStatus": "pass",
              "address": "addr"
          }
      }
    it(' in it...', function (done) {
        request.post('/api/merchants')
            .send(merchant)
            .expect(200, function (err, res) {
                should.not.exist(err);
                console.log(res.text);
                res.text.should.containEql('jjjjj');
                done();
            });
    });
});