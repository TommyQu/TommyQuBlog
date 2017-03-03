app.service('UserService', function($http) {

    this.signUp = function(userObj) {
        var settings = {
                method: 'POST',
                url: baseUrl + "/user/signUp.do",
                data: userObj
            }
            return $http(settings).then(function(response) {
            	return response;
            }, function(error) {
                return error;
            });
    };

});