var $ = require('jquery');
require('bootstrap');
orderListController.$inject = ['orderListService', '$state', '$location'];

function orderListController(orderListService, $state, $location) {
  var vm = this;
  vm.orderList = [];

  orderListService.findAllOrders(function(err, result) {
    console.log(result);
    if(result.data !== null){
      if(result.data.code === -1){
        $("#orderMessageDialog").modal("show");
      }else {
        vm.orderList = result.data;
      }
    }
  });

  vm.gotoLogin = function() {
    $("#orderMessageDialog").modal("hide");
    $location.path('/login');
  };

  vm.showOrderDetail = function(orderId) {
    console.log(orderId);
    $state.go('orderDetail', {orderId: orderId});
  }
}

module.exports = orderListController;