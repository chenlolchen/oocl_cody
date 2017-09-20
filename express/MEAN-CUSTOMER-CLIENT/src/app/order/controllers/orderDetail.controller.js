orderDetailController.$inject = ['orderDetailService','$stateParams'];

function orderDetailController(orderDetailService, $stateParams) {
  var vm = this;
  orderDetailService.findOrderById($stateParams.orderId, function(err, result) {
    vm.order = result.data;
  })
}

module.exports = orderDetailController;