var app = require('express');
var router = app.Router();
var socket_io = require('socket.io');

router.prepareSocketIO = function (server) {
    var io = socket_io.listen(server);
    io.sockets.on('connection', function (socket) {
        console.log("connect....."+socket);
        socket.on('change', function (msg) {
            console.log("change....."+msg);
            socket.broadcast.emit('change', "change");
        });
        socket.on('disconnection', function (data) {
            socket.disconnect(true);
        });

    });

};

module.exports = router;