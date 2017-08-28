const app = require('http').createServer();
const io = require('socket.io')(app);

const PORT = 8001;
app.listen(PORT);

let clientCount = 0;

io.on('connection', function (socket) {
    clientCount++;
    socket.nickName = 'user' + clientCount;

    io.emit('enter', socket.nickName + ' comes in');

    socket.on('message', function (str) {
        io.emit('message', socket.nickName + " says: " + str);
    });

    socket.on('disconnect', function () {
        io.emit('leave', socket.nickName + "is left");
    });
});

// Scream server example: "hi" -> "HI!!!"
// const server = ws.createServer(function (connect) {
//
//     let message = {};
//     message.type = "enter";
//     message.data = connect.nickName + ' comes in';
//     broadcast(JSON.stringify(message));
//
//     connect.on("text", function (str) {
//         let message = {};
//         message.type = "message";
//         message.data = connect.nickName + " says: " + str;
//         broadcast(JSON.stringify(message));
//     });
//
//     connect.on("close", function (code, reason) {
//         let message = {};
//         message.type = "leave";
//         message.data = connect.nickName + " is closed";
//         broadcast(JSON.stringify(message));
//     });
//
//     connect.on("error", function (err) {
//         console.log("handle err");
//         console.log(err);
//     });
//
// }).listen(PORT);
//

//
// function broadcast(str) {
//     server.connections.forEach((connection) => {
//         connection.sendText(str);
//     })
// }

console.log("websocket server listen in localhost:8001");