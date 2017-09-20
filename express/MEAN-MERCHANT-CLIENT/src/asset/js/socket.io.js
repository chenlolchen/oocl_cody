
var io = require('socket.io-client')
var socket = io.connect('http://zha-ita077-w7:3001');
require('sweetalert');
socket.on('newOrder', function (data) {
    console.log(data);
    var merchantId = localStorage.getItem('merchantId');
    console.log(merchantId);
    if(merchantId == data.merchantId){
        if (data.code == 1) {
            swal({
                    title: "notify",
                    text: " new order,forward to order page?",
                    type: "info",
                    showCancelButton: true,
                    confirmButtonText: "forward now",
                    cancelButtonText:"cancle",
                    closeOnConfirm: true,
                    closeOnCancel: true
                },
                function(isConfirm){
                console.log(isConfirm);
                    if (isConfirm) {
                       var url = window.location.href
                        var params = url.split("!");
                        window.location.href = "/#!/manager/order?"+data.orderId;

                       if (params.length>1&&params[1]=="/manager/order"){
                           window.location.reload();
                       }
                    }
                });

        }
        if (data.code == 2) {//
            swal({
                    title: "notify",
                    text: " new status,forward to info page?",
                    type: "info",
                    showCancelButton: true,
                    confirmButtonText: "forward now",
                    cancelButtonText:"cancle",
                    closeOnConfirm: true,
                    closeOnCancel: true
                },
                function(isConfirm){
                    console.log(isConfirm);
                    if (isConfirm) {
                        var url = window.location.href
                        var params = url.split("!");
                        if (params.length>1&&params[1]=="/manager/merchant/info"){
                            window.location.reload();
                        }else{
                            window.location.href = "/#!/manager/merchant/info?";
                        }
                    }
                });

        }
    }
});