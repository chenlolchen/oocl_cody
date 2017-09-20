/* Created by Aquariuslt on 5/20/17.*/
var io = require('socket.io-client')

navbarController.$inject = ['userService','$state'];
function navbarController(userService,$state) {
  var vm = this;
  vm.user = localStorage.getItem('username');
  vm.logout = function(){
      userService.logout(function (res) {
          console.log(res);
          if (res.data.code==1){
            localStorage.clear();
            $state.go('login');
          }
      })
  }

    // var socket = io.connect('http://zha-ita077-w7:3001');
    // socket.on('newOrder', function (data) {
    //     console.log(data);
    //     var merchantId = localStorage.getItem('merchantId');
    //     console.log(merchantId);
    //     if(merchantId == data.merchantId){
    //         if (data.code == 1) {//
    //             swal({
    //                     title: "notify",
    //                     text: " new order,forward to order page?",
    //                     type: "info",
    //                     showCancelButton: true,
    //                     confirmButtonText: "forward now",
    //                     cancelButtonText:"cancle",
    //                     closeOnConfirm: true,
    //                     closeOnCancel: true
    //                 },
    //                 function(isConfirm){
    //                     console.log(isConfirm);
    //                     if (isConfirm) {
    //                         console.log("heheheh");
    //                        $state.go('manager.order',{orderId:data.orderId});
    //                     }
    //                 });
    //
    //         }
    //     }
    // });

}

module.exports = navbarController;