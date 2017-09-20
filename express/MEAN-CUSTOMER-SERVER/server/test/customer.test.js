var app = require('../app');
var request = require('supertest')(app);
var should = require('should');

describe('test find customer by name and password', function () {
    it(' in it...', function (done) {
        request.get('/api/customers/nick/123')
            .expect(200, function (err, res) {
                should.not.exist(err);
                console.log(res.text);
                res.text.should.containEql('nick');
                done();
            });
    });
});

describe('test find redis data....', function () {
    it(' in it...', function (done) {
        request.get('/api/customers/getRedisData')
            .expect(200, function (err, res) {
                should.not.exist(err);
                console.log(res.text);
                //res.text.should.containEql('jordan');
                done();
            });
    });
});