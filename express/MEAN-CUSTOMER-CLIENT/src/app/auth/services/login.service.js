loginService.$inject = ['$http'];

function loginService($http) {
  return {
    login: login
  };

  function login(customer, callback) {
    var request = {
      method: 'GET',
      url: '/api/customers/' + customer.name + '/' + customer.password
    };

    return $http(request).then(function(data, status, headers) {
      callback(null, data);
    });
  }
}

module.exports = loginService;