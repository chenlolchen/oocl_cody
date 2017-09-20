/* Created by ZHENGNI3 on 09-02-2017.*/
require('../../../assets/css/style.css');
require('../../../assets/css/default.css');
require('../../../assets/css/nivo-slider.css');
require('../../../assets/css/cart.css');

require('../../../assets/css/foodList.css');
require('../../../assets/css/fwslider.css');
require('../../../assets/js/slider-advs/jquery1.min.js');
require('../../../assets/js/slider-advs/jquery-ui.min.js');
require('../../../assets/js/slider-advs/css3-mediaqueries.js');

module.exports = function ($stateProvider) {
  $stateProvider
    .state({
      name: 'foods',
      url: '/foods/:merchantId',
      template: require('../layouts/foodList.html')
    })
};