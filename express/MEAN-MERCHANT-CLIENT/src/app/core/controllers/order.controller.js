var $ = require('jquery');
orderController.$inject = ['orderService','$state'];
function orderController(orderService,$state) {
    var vm = this;
    vm.currentStatus = 'all';
    getOrders();

    function getOrders(){
        var thisUrl = window.location.href;
        var params = thisUrl.split("?");
        console.log(params);
        if(params.length>1){
            var url = params[1];
            console.log("url:"+url);
            vm.currentStatus = 'WAIT';
        }
        orderService.getOrdersByStatus(vm.currentStatus,function(res){
            console.log(res.data);
            vm.orders = res.data;
            if (url!=undefined){
                $(vm.orders).each(function (index ,item){
                    if(item._id==url){
                        vm.openDetail(item);
                    }
                })
            }

        });
    }

    changeListen();
    function changeListen() {
            $('#myModal').on('hidden.bs.modal', function (e) {
                var thisUrl = window.location.href;
                var params = thisUrl.split("?");
                if(params.length>1) {
                    console.log("1634564")
                    window.location.href = "/#!/manager/order";
                }
            })

    }

    vm.getOrdersByStatus=function(status){
        vm.currentStatus = status;
        getOrders();
    }

    vm.openDetail = function(order){
        vm.currentOrder = order;
        $('#myModal').modal('show');
    }

    vm.update = function(order,status){
        var updateOrder = {
            id:order._id,
            status:status
        }
        orderService.updateOrderStatus(updateOrder,function(res){
            console.log(res.data);
            getOrders();
            swal({
                title: "operation",
                text: status.toLowerCase()+" success",
                timer: 1000,
                showConfirmButton: false
            });
        })
    };

    vm.updateCurrent = function(status){
        var order = {
            id:vm.currentOrder._id,
            status:status
        }
        orderService.updateOrderStatus(order,function(res){
            console.log(res.data);
            vm.currentOrder.status = status;
           getOrders();
            swal({
                title: "operation",
                text: status.toLowerCase()+" success",
                timer: 1000,
                showConfirmButton: false
            });
        })
    };



}

module.exports = orderController;