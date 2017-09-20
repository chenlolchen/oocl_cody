var app = require('../../server/app.js');
var request = require('supertest')(app);
var should = require('should');

// corect admin info test
describe('test admin login check....', function() {
    it(' in it...', function(done) {

        var data = {
            "admin": {
                "name": "sky",
                "password": "sky"
            }
        }
        request.post('/api/admin')
            .send(data)
            .expect(200, function(err, res) {
                should.not.exist(err);
                console.log(res.text);
                res.text.should.containEql('sky');
                done();
            });
    });
});

// incorrect admin info test
describe('test admin login check....', function() {
    it(' in it...', function(done) {

        var data = {
            "admin": {
                "name": "sky",
                "password": "xxx"
            }
        }
        request.post('/api/admin')
            .send(data)
            .expect(200, function(err, res) {
                should.not.exist(err);
                console.log(res.text);
                res.text.should.containEql('sky');
                done();
            });
    });
});