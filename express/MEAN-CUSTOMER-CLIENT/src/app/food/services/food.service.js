/* Created by ZHENGNI3 on 09-02-2017.*/

foodListService.$inject = ['$http'];

function foodListService($http) {
  return {
    getFoodsByMerchantId: getFoodsByMerchantId,
    getFoodsByCategories: getFoodsByCategories
  };

  function getFoodsByMerchantId(merchantId, callback) {
    var request = {
      method: 'GET',
      url: '/api/food/' + merchantId
    };

    return $http(request).then(function(data, status, headers) {
      callback(null, data);
    });
  }

  function getFoodsByCategories(merchantId, categories, callback) {
    var request = {
      method: 'GET',
      url: '/api/food/categories/?merchantId=' + merchantId + '&categories=' + categories
    };

    console.log(merchantId);
    console.log(categories);
    return $http(request).then(function(data, status, headers) {
      callback(null, data);
    });
  }

  getFoodsByMerchantId();
}

module.exports = foodListService;