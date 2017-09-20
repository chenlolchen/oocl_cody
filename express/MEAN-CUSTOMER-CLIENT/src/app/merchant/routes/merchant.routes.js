require('../../../assets/css/merchant.css');
require('../../../assets/css/fwslider.css');

require('../../../assets/js/slider-advs/jquery1.min.js');
require('../../../assets/js/slider-advs/jquery-ui.min.js');
require('../../../assets/js/slider-advs/css3-mediaqueries.js');

module.exports = function ($stateProvider) {
    $stateProvider
        .state({
            name: 'merchantList',
            url: '/merchants',
            controller: "merchantController",
            controllerAs: 'vm',
            template: require('../layouts/merchant/merchants.html')
        });
};
