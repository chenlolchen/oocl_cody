merchantController.$inject = [
    '$location',
    '$stateParams',
    'merchantService',
    '$state'
];
var fwslider = require('../../../assets/js/slider-advs/fwslider.js');
var io = require('socket.io-client');
const socket = io('http://zha-ita012-w7:3001');

function merchantController($location, $stateParams, merchantService, $state) {
  fwslider.init();

  socket.on('change', function(value) {
    console.log(value);
    vm.findAllMerchants();
  });

    var vm = this;
    vm.merchants = [];
    vm.findAllMerchants = function(){
        merchantService.findAllMerchants(function(err, data){
            vm.merchants = data;
            console.log(vm.merchants);
        });
    };

    vm.findMerchantByTypeId = function(typeId){
        vm.typeId = typeId;
        if(vm.typeId == 'ALL'){
            vm.findAllMerchants();
        }
        else {
            merchantService.findMerchantByTypeId(vm.typeId, function (err, data) {
                //是一个数组
                vm.merchants = data;
                console.log(vm.merchants);
            });
        }
    }

     vm.showMerchantFoods = function(merchantId){
         console.log(merchantId);
        $state.go('foods', {merchantId: merchantId});
    }

    vm.findAllMerchants();
}

module.exports = merchantController;