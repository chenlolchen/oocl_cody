/**
 * Created by CHENCO7 on 8/28/2017.
 */
let http = require('http');
let _ = require('lodash');
let [host, port] = ['localhost', 1336];

http.createServer((req, res) => {
    res.writeHead(200, {
        'Content-Type': 'text/plain'
    });
    res.end('hello');
}).listen(port);

host = _.isInteger(port) ? 'localhost:1336;' : '';
console.log(`server is start at ${host}`);