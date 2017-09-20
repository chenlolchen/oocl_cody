loginController.$inject = ['userService','$state'];
var $ = require("jquery");
function loginController(userService,$state) {
    var vm = this;
    vm.user={};
    vm.error={};
    vm.user.name = 'allen';
    vm.signIn = function(){
        userService.login(vm.merchant,function(res){
            var data = res.data;
            if(data.code==1){
                localStorage.setItem("username",vm.merchant.name);
                localStorage.setItem("userToken",data.token);
                localStorage.setItem('merchantId',data.merchantId);
                $state.go('manager.welcome');
            }else{
                vm.error.message = data.message;
                $("#alter-div").show();
                window.setTimeout(function () {
                    $("#alter-div").hide();
                },1500);
            }
        })
    }

}

module.exports = loginController;