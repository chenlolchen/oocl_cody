// var app = require('express')();
// var http = require('http').Server(app);
// var io = require('socket.io')(http);

// module.exports = {
//     updateMerchantStatus : updateMerchantStatus
// };

// //  http.listen(3002, function(){
// //     console.log('listening on *:3002');
// // });

// function updateMerchantStatus(req, res, next) {
//     let body = req.body;
//     console.log('getdata...'+body);
//     io.on('connection', function(socket) {
//         socket.on('change', function(body) {
//             io.emit('change', body);
//         });
//     });
//     res.json({name: 111});
// }


