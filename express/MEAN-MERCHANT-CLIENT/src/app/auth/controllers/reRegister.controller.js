reRegisterController.$inject = ['userService','$state'];
function reRegisterController(userService,$state) {
    var vm = this;

    vm.reRignUp = function(){
       userService.reRegister(vm.merchant,function (res) {
           if (res.code==1){
               $state.go('login');
               localStorage.clear();
           }
       })
    }

}

module.exports = reRegisterController;