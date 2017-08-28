/**
 * Created by CHENCO7 on 8/28/2017.
 */
const fs = require('fs');
fs.readFile('hello.txt', 'utf-8', (err, content) => {
    if(err){
        console.log('error happend during reading the file');
        return console.log(err)
    }
    console.log(`Content is "${content}"`);
});