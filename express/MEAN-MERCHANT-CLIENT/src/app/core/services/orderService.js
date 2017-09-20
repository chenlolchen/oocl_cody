

module.exports=orderService;
orderService.$inject = ['$http'];

function orderService($http){
    return {
        getOrders:getOrders,
        getOrdersByStatus:getOrdersByStatus,
        updateOrderStatus:updateOrderStatus
    };

    function getOrdersByStatus(status,callback){
        var request = {
            method:"GET",
            url:"/api/orders/status/"+status
        }
        $http(request).then(function (res) {
            callback(res);
        },function (res) {
            console.log(res);
        })
    }

    function getOrders(callback){
        var request = {
            method:"GET",
            url:"/api/orders"
        }
        $http(request).then(function (res) {
            callback(res);
        },function (res) {
            console.log(res);
        })
    }

    function updateOrderStatus(order,callback){
        var request = {
            method:'PUT',
            url:'/api/orders',
            data:order
        }
        $http(request).then(function (res) {
            callback(res);
        },function (res) {
            console.log(res);
        })
    }
}





