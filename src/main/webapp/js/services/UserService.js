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

    this.login = function(email, pwd) {
        var settings = {
                method: 'POST',
                url: baseUrl + "/user/login.do",
                params: {
                    email: email,
                    pwd: pwd,
                }
            };
            return $http(settings).then(function(response) {
            	return response;
            }, function(error) {
                return error;
            });
    };
    
    this.signOut = function() {
        var settings = {
                method: 'GET',
                url: baseUrl + "/user/signOut.do"
            };
            return $http(settings).then(function(response) {
            	return response;
            }, function(error) {
                return error;
            });
    };
});