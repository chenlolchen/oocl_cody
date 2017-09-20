var app = require('../../server/app.js');
var request = require('supertest')(app);
var should = require('should');

// test get all merchants 
describe('test get all merchants ....', function() {
    it(' in it...', function(done) {

        request.get('/api/merchants')
            .expect(200, function(err, res) {
                should.not.exist(err);
                console.log(res.text);
                // res.text.should.containEql('sky');
                done();
            });
    });
});

// test get one merchant info by id
describe('test get one merchant info by id....', function() {
    it(' in it...', function(done) {
        var m_id = '59a93f6ecc69723e283642f8';
        request.get('/api/manage/merchants/' + m_id)
            .expect(200, function(err, res) {
                should.not.exist(err);
                console.log(res.text);
                res.text.should.containEql('bmw');
                done();
            });
    });
});

// test get merchants array by status....
describe('test get merchants array by status....', function() {
    it(' in it...', function(done) {
        var m_status = 'audit';
        request.get('/api/manage/merchants/status/' + m_status)
            .expect(200, function(err, res) {
                should.not.exist(err);
                console.log(res.text);
                res.text.should.containEql('bmw');
                done();
            });
    });
});


// test get one merchant status by id....
describe('test get one merchant status by id....', function() {
    it(' in it...', function(done) {
        var m_id = '59a93f6ecc69723e283642f8';
        request.get('/api/manage/merchants/id/' + m_id + '/status')
            .expect(200, function(err, res) {
                should.not.exist(err);
                console.log(res.text);
                res.text.should.containEql('white_test');
                done();
            });
    });
});


// test change one merchant status to white....
describe('test change one merchant status to white....', function() {
    it(' in it...', function(done) {
        var m_id = '59a93f6ecc69723e283642f8';
        request.put('/api/manage/merchants/white')
            .send(m_id)
            .expect(200, function(err, res) {
                should.not.exist(err);
                console.log(res.text);
                // res.text.should.containEql('white_test');
                done();
            });
    });
});


// test change one merchant status to black....
describe('test change one merchant status to black....', function() {
    it(' in it...', function(done) {
        var m_id = '59a93f6ecc69723e283642f8';
        request.put('/api/manage/merchants/black')
            .send(m_id)
            .expect(200, function(err, res) {
                should.not.exist(err);
                console.log(res.text);
                // res.text.should.containEql('white_test');
                done();
            });
    });
});

// test change one merchant status to black....
describe('test change one merchant status to reject....', function() {
    it(' in it...', function(done) {
        var m_id = '59a93f6ecc69723e283642f8';
        request.put('/api/manage/merchants/reject')
            .send(m_id)
            .expect(200, function(err, res) {
                should.not.exist(err);
                console.log(res.text);
                // res.text.should.containEql('white_test');
                done();
            });
    });
});

// test merchant count info
describe('test get one merchant info by id....', function() {
    it(' in it...', function(done) {
        request.get('/api/manage/merchants/count')
            .expect(200, function(err, res) {
                should.not.exist(err);
                console.log(res.text);
                res.text.should.containEql('all');
                res.text.should.containEql('audit');
                res.text.should.containEql('black');
                res.text.should.containEql('white');
                res.text.should.containEql('reject');
                done();
            });
    });
});