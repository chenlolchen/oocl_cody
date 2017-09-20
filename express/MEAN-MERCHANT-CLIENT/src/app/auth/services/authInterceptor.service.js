
authInterceptorService.$inject = ['$rootScope'];

function  authInterceptorService($rootScope) {
    return {
        request: function(config) {
            // console.log('all222222');
            var user = localStorage.getItem("username");
            var token = localStorage.getItem("userToken");
            if(user!=undefined&&token!=undefined){
                config.headers.Authorization = 'Bearer ' +token;
            }
            // config.headers['token'] = 5555;
            return config;
        },
        /*
         * 超时处理、未授权、在这里定义规则
         */
        response: function(response) {
           // if (response.data.code==-1){
           //     reject(response);
           //     $state.go('login');
           // }
            return response;
        },
        responseError:function (response) {
            return response;
        }

    };
}
module.exports=authInterceptorService;