app.controller('GlobalCtrl', function($scope, $state, $http, $cookies, $window) {
    $scope.user = {};
    $scope.userCookie = $cookies.getObject('userCookie');
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
	    				"firstName": data.firstName,
	    				"lastName": data.lastName,
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
        var settings = {
                method: 'POST',
                url: baseUrl + "/user/signUp.do",
                params: {
                	userJson: JSON.stringify($scope.user)
                }
            }
            $http(settings).then(function(response) {
            	if (response.data != null && response.data != "") {
                    if (response.data == "success") {
                    	alert("Sign up successfully!");
                    	angular.element('#signUpModal').modal('hide');
                    } else
                    	alert("Email has already exists!");
            	} else {
                	alert("Network error!");
                }
            }, function(error) {
                alert("Error:" + JSON.stringify(error.data));
            });
    };
    
    $scope.signOut = function() {
    	$cookies.remove("userCookie");
    	$window.location.reload();
    };
    
});