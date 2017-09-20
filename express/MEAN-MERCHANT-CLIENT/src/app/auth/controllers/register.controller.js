registerController.$inject = ['userService','$state'];
function registerController(userService,$state) {
    var vm = this;
    vm.merchant = {};
    vm.signUp=function(){

        userService.register(vm.merchant,function(res){
            console.log(res);
           $state.go('login');
        })
    }




}

module.exports = registerController;