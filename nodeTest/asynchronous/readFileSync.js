/**
 * Created by CHENCO7 on 8/28/2017.
 */
const fs = require('fs');
let content;
console.log('start reading a file ..');
try {
    content = fs.readFileSync('hello.txt');
} catch(ex) {
    console.log(ex);
}