/*
 *create by Allen 前端拦截，带上token
 */
authConfig.$inject = [

    '$rootScope',
    '$transitions',
    'userService'
];
function authConfig($rootScope,$transitions,userService) {

    $transitions.onStart( { to: 'manager.*' },function(trans){
        // trans.abort();
        var toState = trans.to();
        var $state = trans.router.stateService;
        if(toState.name=='login'||toState.name=='register'){
            return;
        }

        if(!localStorage.getItem("username") || !localStorage.getItem("userToken")){
            $state.transitionTo('login',{message:"you need login"});
 
        }else{
            userService.getUserStatus(function(res){
                var status = res.data;
                console.log("55555");
                console.log(status);
                if (status.status=='white_list'){
                    return;
                }else{
                    $state.transitionTo('manager.merchantinfo',{message:"your status is "+status.status});
                }
            })
        }
    });

}

module.exports = authConfig;