merchantInfoController.$inject = ['userService','$stateParams'];
var $ = require('jquery');
function merchantInfoController(userService,$stateParams) {
    var vm = this;
    vm.error = {};
    vm.error.message = $stateParams.message;
    if ( vm.error.message!=null){
        console.log(vm.error.message);
        $("#alter-div").show();
        window.setTimeout(function () {
            $("#alter-div").hide();
        },1500);
    }

    vm.merchant={};
    userService.getUserInfo(function (res) {
        console.log(res.data);
        vm.merchant = res.data;
    })


}

module.exports = merchantInfoController;