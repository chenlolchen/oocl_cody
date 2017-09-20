loginController.$inject = ['loginService','$location'];
// var io = require('socket.io-client');


function loginController(loginService, $location) {
  var vm = this;

  // const socket = io('ws://localhost:3001');
  //
  // socket.on('change', function(value) {
  //   console.log(value);
  // });
  //
  // vm.test = function() {
  //   socket.emit('change','test change ..');
  // };

  vm.login = function() {
    var customer = {name: vm.name, password: vm.password};
    loginService.login(customer, function(err, result) {
      if(result.data.code === 1){
        localStorage.token = result.data.token;
        $location.path('/merchants')
      }else{
        vm.message = "用户名或密码错误!";
      }
    });
  };
}

module.exports = loginController;