app.controller('UserAdminCtrl', function($scope, $state, $http, $window) {
	$scope.users = {};
    var getAllUsersSettings = {
            method: 'GET',
            url: baseUrl + "/admin/getAllUsers.do"
        }
        $http(getAllUsersSettings).then(function(response) {
        	if (response.data != null && response.data != "") {
        		$scope.users = JSON.parse(response.data);
        	} else {
            	alert("Network error!");
            }
        }, function(error) {
            alert("Error:" + JSON.stringify(error.data));
        });
    
});