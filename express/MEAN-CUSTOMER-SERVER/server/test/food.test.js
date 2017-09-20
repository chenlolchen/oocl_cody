var app = require('../app');
var request = require('supertest')(app);
var should = require('should');

describe('test findAllFoods....', function () {
    it(' in it...', function (done) {
        request.get('/api/food/59a9477de54dc11b68b83392')
            .expect(200, function (err, res) {
                should.not.exist(err);
                console.log(res.text);
                res.text.should.containEql('ttt');
                done();
            });
    });
});

describe('test findFoodByTypeId....', function () {
    it(' in it...', function (done) {
        request.get('/api/food/categories?categories=ttt&merchantId=59a9477de54dc11b68b83392')
            .expect(200, function (err, res) {
                should.not.exist(err);
                console.log(res.text);
                res.text.should.containEql('ttt');
                done();
            });
    });
});

describe('test find food by foodId....', function () {
    it(' in it...', function (done) {
        //var food = {
        //    "name": "nicole",
        //    "price": 11,
        //    "image": "img",
        //    "categories": "零食",
        //    "merchant": [
        //        "59a9477de54dc11b68b83392"
        //    ]
        //};
        request.get('/api/food/item/59a92c5fe54dc11b68b83371')
            .expect(200, function (err, res) {
                should.not.exist(err);
                console.log(res.text);
                res.text.should.containEql('m_jordan2');
                done();
            });
    });
});