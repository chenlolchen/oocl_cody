/** Created by CUIJA on 05-19-2017.*/


module.exports = function ($stateProvider,$httpProvider) {
  $stateProvider
      .state({
          name: 'default',
          url: '',
          params:{message:null},
          template: require('../layouts/login/login.html'),
          controller:'loginController',
          controllerAs: 'vm'
      })
    .state({
      name: 'login',
      url: '/login',
      params:{message:null},
      template: require('../layouts/login/login.html'),
      controller:'loginController',
      controllerAs: 'vm'
    })
    .state({
      name: 'register',
      url: '/register',
      template: require('../layouts/register/register.html'),
      controller:'registerController',
      controllerAs: 'vm'
    })
      .state({
      name: 'reRegister',
      url: '/reRegister',
      template: require('../layouts/register/reRegister.html'),
      controller:'reRegisterController',
      controllerAs: 'vm'
  }) .state({
      name: 'manager.merchantinfo',
      url: '/merchant/info',
      params:{message:null},
      template: require('../layouts/merchant/merchantInfo.html'),
      controller:'merchantInfoController',
      controllerAs: 'vm'
  }).state("otherwise", { url : '/login'})
  ;

};