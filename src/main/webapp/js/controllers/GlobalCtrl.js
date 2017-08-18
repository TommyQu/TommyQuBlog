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
    	UserService.login($scope.user.email, $scope.user.pwd).then(function(response){
	    	if(response.status == "200") {
        		var data = response.data;
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
	    	} else if(response.status == "422") {
	    		alert("Incorrect username or password!");
	    	} else {
	    		alert("Error: "+response.status+", "+response.statusText);
	    	}
    	});
    };
    
    $scope.signUp = function() {
	    UserService.signUp($scope.user).then(function(response) {
	    	if(response.status == "200") {
            	alert("Sign up successfully!");
            	angular.element('#signUpModal').modal('hide');
	    	} else if(response.status == "409") {
	    		alert("Email has already exists!");
	    	} else {
	    		alert("Error: "+response.status+", "+response.statusText);
	    	}
	    });
    };
    
    $scope.signOut = function() {
	    UserService.signOut().then(function(response) {
	    	if(response.status == "200") {
	        	$cookies.remove("userCookie");
	        	$state.go("app.home", {}, {reload: true});
	    	} else {
	    		alert("Error: "+response.status+", "+response.statusText);
	    	}
	    });
    };
    
});