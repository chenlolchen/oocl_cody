orderDetailService.$inject = ['$http'];

function orderDetailService($http) {
  return {
    findOrderById: findOrderById,
    addOrderItem: addOrderItem,
    getOrderItems: getOrderItems,
    takeOrder: takeOrder
  };

  function addOrderItem(item, operator, callback) {
    var request = {
      method: 'POST',
      url: '/api/orders/orderItems',
      headers: {"Authorization": "Bearer " + localStorage.token },
      data: { orderItem : item, operator: operator }
    };

    return $http(request).then(function(data, status) {
      callback(null, data);
    });
  }

  function getOrderItems(callback) {
    console.log("aaaaaaaaaaaaa");
    var request = {
      method: 'GET',
      url: '/api/orders/orderItems',
      headers: {"Authorization": "Bearer " + localStorage.token }
    };

    return $http(request).then(function(result, status) {
        callback(null, result);
    }, function(result) {
      callback(null, result);
    });
  }

  function findOrderById(orderId, callback) {
    var request = {
      method: 'GET',
      url: '/api/orders/' + orderId,
      headers: {"Authorization": "Bearer " + localStorage.token }
    };

    return $http(request).then(function(data, status) {
      callback(null, data);
    });
  }

  function takeOrder(orderItems, amount, merchantId, callback) {
    var request = {
      method: 'POST',
      url: '/api/orders',
      data: {orderItems: orderItems, amount: amount, merchantId: merchantId },
      headers: {"Authorization": "Bearer " + localStorage.token }
    };

    return $http(request).then(function(data, status) {
      callback(null, data);
    });
  }
}

module.exports = orderDetailService;