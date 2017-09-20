/** Created by CUIJA on 05-19-2017.*/


module.exports = function ($stateProvider) {
  $stateProvider
    .state({
      name: 'manager',
      url: '/manager',
      template: require('../components/navbar/navbar.html'),
        controller:'navbarController',
        controllerAs:'vm'
    })
      .state({
          name: 'manager.welcome',
          url: '/welcome',
          template: require('../layouts/welcome.html'),
          controller:'welcomeController',
          controllerAs:'vm'
      })
    .state({
      name: 'manager.order',
      url: '/order',
        // params:{orderId:null},
      template: require('../layouts/order/order.html'),
        controller:'orderController',
        controllerAs:'vm'
    })
    .state({
      name: 'manager.food',
      url: '/food',
      template: require('../layouts/food/food.html'),
      controller:'foodController',
      controllerAs: 'vm'
    });
};