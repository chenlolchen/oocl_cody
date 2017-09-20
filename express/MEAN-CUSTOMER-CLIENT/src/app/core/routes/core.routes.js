/** Created by CUIJA on 05-19-2017.*/
require('../../../assets/css/nav.css');

module.exports = function ($stateProvider) {
  $stateProvider
    .state({
      name: 'default',
      url: '',
      template: require('../layouts/home/home.html')
    })
    .state({
      name: 'home',
      url: '/',
      template: require('../layouts/home/login.html')
    })
    .state({
      name: 'about',
      url: '/about',
      template: require('../layouts/about/about.html')
    });
};