/* Created by ZHENGNI3 on 09-02-2017.*/
foodListController.$inject = ['foodListService', 'orderDetailService', '$stateParams', '$location', '$state'];
var $ = require('jquery');
require('bootstrap');
var cart = require('../../../assets/js/cart.js');
var _ = require('lodash');
var fwslider = require('../../../assets/js/slider-advs/fwslider.js');
var io = require('socket.io-client');
const socket = io('http://zha-ita077-w7:3001');

function foodListController(foodListService, orderDetailService, $stateParams, $location, $state) {
  fwslider.init();
  var vm = this;
  vm.cartClick = cart.cartClick();
  vm.merchantId = $stateParams.merchantId;
  vm.orderItemList = [];
  vm.orderMessage = false;

  vm.gotoLogin = function() {
    $("#messageDialog").modal("hide");
    $location.path('/login');
  };

  vm.getFoodsByMerchantId = function(){
      foodListService.getFoodsByMerchantId(vm.merchantId, function(err, result) {
        vm.foodList = result.data;
      });
  }


  orderDetailService.getOrderItems(function(err, result) {
    console.log(result);
    if(result.data !== null){
      if(result.data.code !== -1){
        vm.orderMessage = true;
        vm.orderItemList = result.data;
      }
    }else {
      vm.orderMessage = true;
    }
    console.log(vm.orderMessage);

    calculateTotalPrice();
  });

  vm.addToShopCar = function(item) {
    var orderItem = _.find(vm.foodList, { '_id': item });
    orderItem.amount = 1;

    orderDetailService.addOrderItem(orderItem, 'add', function(error, result) {

      if(result.data !== null){
        if (result.data.code === -1){
          $("#messageDialog").modal('show');
        }else{
          cart.shake();
          vm.orderItemList = result.data;
        }
      }
      calculateTotalPrice();
    });
  };

  vm.up = function(itemId) {
    var item = _.find(vm.foodList, { '_id': itemId });

    orderDetailService.addOrderItem(item, 'add', function(error, result) {
      vm.orderItemList = result.data;
      calculateTotalPrice();
    });
  };

  vm.del = function(itemId) {
    var item = _.find(vm.foodList, { '_id': itemId });

    orderDetailService.addOrderItem(item, 'del', function(error, result) {
      vm.orderItemList = result.data;
      calculateTotalPrice();
    });
  };

  vm.takeOrder = function() {
    orderDetailService.takeOrder(vm.orderItemList, vm.totalPrice, vm.merchantId, function(error, result) {
      socket.emit('notify', { merchantId: vm.merchantId, message: 'new order', code: 1 , orderId:result.data._id});
      $state.go('orderDetail', {orderId: result.data._id });
    });
    console.log(vm.orderItemList);
  };

  function calculateTotalPrice() {
    var sum = 0;
    _.each(vm.orderItemList, function(value) {
      sum += value.amount * value.price;
    });
    vm.totalPrice = sum;
  }
  
  vm.findFoodListByFoodType = function(merchantId, categories) {
      if(categories == 'ALL'){
        vm.getFoodsByMerchantId();
      }
      else{
          foodListService.getFoodsByCategories(merchantId, categories, function(err, result) {
          vm.foodList = result.data;
          console.log(result.data);
        });
      }
  }
   vm.getFoodsByMerchantId();
}

module.exports = foodListController;