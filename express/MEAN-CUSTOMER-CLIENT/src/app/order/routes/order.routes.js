require('../../../assets/css/orderDetail.css');

module.exports = function ($stateProvider) {
  $stateProvider
  .state({
    name: 'orderDetail',
    url: '/orderDetail/:orderId',
    template: require('../layouts/orderDetail.html')
  })
  .state({
    name: 'orderList',
    url: '/orderList',
    template: require('../layouts/orderList.html')
  })
};