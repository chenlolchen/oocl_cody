const app = require('./config/express.js');
const config = require('./config/env/config_development.json');
const http = require('http');
const winston = require('winston');
let server = http.createServer(app);

server.listen(config.NJ_DOM_FS.port);

// exception handling
process.on('uncaughtException', function(err) {
	winston.error('Caught exception:', err);
});

// Expose app
exports = module.exports = app;

// Logging initialization
winston.info('--');
winston.info(config.NJ_DOM_FS.title, 'application started');
winston.info('Environment:\t\t\t', process.env.NODE_ENV);
winston.info('Port:\t\t\t\t', config.NJ_DOM_FS.port);
if (process.env.NODE_ENV === 'secure') {
	winston.info('HTTPs:\t\t\t\ton');
}
winston.info('--');
