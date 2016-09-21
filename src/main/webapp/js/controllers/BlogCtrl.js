app.controller('BlogCtrl', function($scope, $state, $http, $cookies, $window) {
	$scope.category = {};
    var getAllCategoriesSettings = {
            method: 'GET',
            url: baseUrl + "/admin/getAllCategories.do"
        }
        $http(getAllCategoriesSettings).then(function(response) {
        	if (response.data != null && response.data != "") {
        		$scope.categories = JSON.parse(response.data);
        	} else {
            	alert("Network error!");
            }
        }, function(error) {
            alert("Error:" + JSON.stringify(error.data));
        });
    
});