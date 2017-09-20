

module.exports=userService;
userService.$inject = ['$http','Upload'];

function userService($http,Upload){
    return {
        register:register,
        login:login,
        getUserInfo:getUserInfo,
        getUserStatus:getUserStatus,
        reRegister:reRegister,
        logout:logout
    };

    function register(user,callback){
        var files = {
            idCard: user.idCard,
            avator: user.avator
        };
        var fields = {
            name:user.name,
            password:user.password,
            address:user.address
        }
        var request = {
            method:'POST',
            url:'/api/merchants/register',
            fields:fields,
            file:files
        }
        return Upload.upload(request).success(function success(res) {
            console.log(res);
            callback(res);
        }).error(function error(res) {
            console.log(res);
        });
    }

    function reRegister(user,callback) {
        var files = {
            idCard: user.idCard,
            avator: user.avator
        };
        var fields = {
            name:user.name,
            password:user.password,
            address:user.address
        }
        var request = {
            method:'POST',
            url:'/api/merchants/re/register',
            fields:fields,
            file:files
        }
        return Upload.upload(request).success(function success(res) {
            console.log(res);
            callback(res);
        }).error(function error(res) {
            console.log(res);
        });
    }

    function login(user,callback){
        var request = {
            method:'POST',
            url:'/api/merchants/login',
            data:user
        }
        $http(request).then(function (res) {
            callback(res);
        },function (res) {
            console.log(res);
        })
    }

    function getUserInfo(callback){
        var request = {
            method:"GET",
            url:"/api/merchants"
        }
        $http(request).then(function (res) {
            callback(res);
        },function (res) {
            console.log(res);
        })
    }

    function getUserStatus(callback){
        var request = {
            method:"GET",
            url:"/api/merchants/status"
        }
        $http(request).then(function (res) {
            callback(res);
        },function (res) {
            console.log(res);
        })
    }

    function logout(callback){
        var request = {
            method:'DELETE',
            url:'/api/merchants/logout'
        }
        $http(request).then(function (res) {
            callback(res);
        },function (res) {
            console.log(res);
        })
    }
}





