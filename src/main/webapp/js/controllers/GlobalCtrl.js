app.controller('GlobalCtrl', function($scope, $state, $http, $cookies, $window, UserService) {
    $scope.user = {};
    $scope.userCookie = $cookies.getObject('userCookie');

    $scope.checkSession = function() {
        var settings = {
                method: 'POST',
                url: baseUrl + "/user/checkSession.do",
                params: {
                    email: $scope.userCookie.email,
                }
            }
        $http(settings).then(function(response) {
            if (response.data != null && response.data != "") {
            	if(response.data == "fail") {
                	$cookies.remove("userCookie");
                	$scope.userCookie = null;
                	alert(NO_SESSION_MSG);
                	$state.go("app.home");
                	return false;
            	}
            } else {
            	alert("Network error!");
            }
        }, function(error) {
            alert("Error:" + JSON.stringify(error.data));
        });
        return true;
    }

    
    $scope.userLogin = function() {
        var settings = {
            method: 'POST',
            url: baseUrl + "/user/login.do",
            params: {
                email: $scope.user.email,
                pwd: $scope.user.pwd,
            }
        }
        $http(settings).then(function(response) {
            if (response.data != null && response.data != "") {
            	if(response.data == "fail")
            		alert("Incorrect username or password!");
            	else {
            		var data = JSON.parse(response.data);
            		var userCookie = {
	    				"id": data.id,
	    				"email": data.email,
	    				"firstName": data.firstName,
	    				"lastName": data.lastName,
	    				"bio": data.bio,
	    				"avatar": data.avatar
            		};
            		$cookies.putObject('userCookie', userCookie);
            		angular.element('#loginModal').modal('hide');
            		$window.location.reload();
            	}	
            } else {
            	alert("Network error!");
            }
        }, function(error) {
            alert("Error:" + JSON.stringify(error.data));
        });
    };
    
    $scope.signUp = function() {
	    UserService.signUp($scope.user).then(function(response) {
	    	if(response.status == "200") {
                if (response.data == "success") {
                	alert("Sign up successfully!");
                	angular.element('#signUpModal').modal('hide');
                } else if(response.data == "exist")
                	alert("Email has already exists!");
                else
                	alert("Internal Server Error!");
	    	} else {
	    		alert("Error: "+response.status+", "+response.statusText);
	    	}
	    });
    };
    
    $scope.signOut = function() {
    	$scope.checkSession();
    	$cookies.remove("userCookie");
    	$state.go("app.home", {}, {reload: true});
    };
    
});