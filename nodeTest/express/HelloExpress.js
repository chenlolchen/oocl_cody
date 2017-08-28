/**
 * Created by CHENCO7 on 8/28/2017.
 */
const express = require('express');
const app = express();

app.get('/', (req, res) => {
    res.send('hello express')
});

app.listen(3000, () => {
    console.log('Hello Express app is listen on port 3000')
});