const app = require('./config/express');
const config = require('./config/env/config_development.json');
const http = require('http');
const winston = require('winston');
const server = http.createServer(app);
const mongoose = require('mongoose');

// Bootstrap db connection
if (config.mongodb.debug) {
    mongoose.set('debug', true);
}

let db = mongoose.connect(config.mongodb.uri, config.mongodb.options, function(err) {
    if (err) {
        console.error('Could not connect to MongoDB!');
        console.error(err);
        process.exit(-1);
    } else {
        console.log('Connected to MongoDB!');
    }
});


server.listen(config.NJ_DOM_FS.port);

// exception handling
process.on('uncaughtException', function(err) {
    winston.error('Caught exception:', err);
});

// Logging initialization
winston.info('--');
winston.info(config.NJ_DOM_FS.title, 'application started');
winston.info('Environment:\t\t\t', process.env.NODE_ENV);
winston.info('Port:\t\t\t\t', config.NJ_DOM_FS.port);
if (process.env.NODE_ENV === 'secure') {
    winston.info('HTTPs:\t\t\t\ton');
}
winston.info('--');