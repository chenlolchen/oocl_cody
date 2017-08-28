/**
 * Created by CHENCO7 on 8/28/2017.
 */
const fs = require('fs');

var fileReadStream = fs.createReadStream('./hello.txt');
var fileWriteStream = fs.createWriteStream('./new_hello.txt');

fileReadStream.pipe(fileWriteStream);

fileWriteStream.on('close',function(){
    console.log('copy over');
});