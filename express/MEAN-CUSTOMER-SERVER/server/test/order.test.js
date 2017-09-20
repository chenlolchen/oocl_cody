var app = require('../app');
var request = require('supertest')(app);
var should = require('should');

describe('test add order....', function () {
    var food = {
        'processNumber' : '123',
        'createDate' : new Date(),
        'status' : 'pass',
        'foods' : [{
            'name' : 'food1',
            'price' : 123
        }]
    }
    it(' in it...', function (done) {
        request.post('/api/orders/')
            .send(food)
            .expect(200, function (err, res) {
                should.not.exist(err);
                console.log(res.text);
                res.text.should.containEql('59a9477de54dc11b68b83392');
                done();
            });
    });
});

describe('test find all foods....', function () {
    it(' in it...', function (done) {
        request.get('/api/orders/')
            .expect(200, function (err, res) {
                should.not.exist(err);
                console.log(res.text);
                res.text.should.containEql('59a9477de54dc11b68b83392');
                done();
            });
    });
});

describe('test find order by order id....', function () {
    it(' in it...', function (done) {
        request.get('/api/orders/59aab9a5d8c7c1285c34603d')
            .expect(200, function (err, res) {
                should.not.exist(err);
                console.log(res.text);
                res.text.should.containEql('59a9477de54dc11b68b83392');
                done();
            });
    });
});