var Upload = require("angular-file-upload");

registerController.$inject = ['Upload', '$location'];

function registerController(Upload, $location) {
  var vm = this;

  vm.uploadFile = function(file) {
    var files = [file];
    console.log(vm.username);
    if (files) {
      Upload.upload({
        url: 'http://127.0.0.1:3001/api/customers',
        fields: {
          'username': vm.username,
          'password': vm.password
        },
        file: files
      }).progress(function(evt) {
        var progressPercentage = parseInt(100.0 * evt.loaded / evt.total);
        console.log('progress: ' + progressPercentage + '% ' + evt.config.file.name);
      }).success(function(data, status, headers, config) {
        console.log(data);
        console.log(status);
        console.log(headers);
        console.log(config);
        $location.path('/login');
      }).error(function(data, status, headers, config) {
        console.log('error status: ' + status);
      })
    } else {
      console.log("upload failed")
    }
  };
}

module.exports = registerController;