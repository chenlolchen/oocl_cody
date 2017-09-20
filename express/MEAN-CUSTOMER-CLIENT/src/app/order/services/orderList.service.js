orderListService.$inject = ['$http'];

function orderListService($http) {
  return {
    findAllOrders: findAllOrders
  };

  function findAllOrders(callback) {
    var request = {
      method: 'GET',
      url: '/api/orders/',
      headers: {"Authorization": "Bearer " + localStorage.token }
    };

    return $http(request).then(function(data, status) {
      callback(null, data);
    });
  }
}

module.exports = orderListService;