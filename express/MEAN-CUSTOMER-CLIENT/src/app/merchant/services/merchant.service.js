merchantService.$inject = ['$http', '$rootScope'];

function merchantService($http){
    return {
        findAllMerchants : findAllMerchants,
        findMerchantByTypeId : findMerchantByTypeId
    }

    function findAllMerchants(callback){
        console.log('find all merchants in angular service..');

        //这里要通过转发proxy
        var request = {
            method: 'GET',
            url: '/api/merchants'
        };

        return $http(request).then(function(result, status, headers) {
            //console.log(result.data);
            callback(null, result.data);
        });
    }

    function findMerchantByTypeId(typeId, callback){
        console.log('find merchant by type in angular service.. ' + typeId);

        var request = {
            method: 'GET',
            url: '/api/merchants/type?typeId=' + typeId
        };
        return $http(request).then(function(result, status, headers) {
            //console.log(result.data);
            callback(null, result.data);
        });
    }
}

module.exports = merchantService;
