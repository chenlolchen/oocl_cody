/**
 * Created by CHENCO7 on 8/28/2017.
 */
let http = require('http');
let _ = require('lodash');
let [host, port] = ['localhost', 9999];

http.createServer((req, res)=>{
    res.writeHead(200, {
        'Content-Type': 'text/plain'
    });
    res.end('Hello Node.js');
}).listen(port);
console.log(`server is start at ${host}`);