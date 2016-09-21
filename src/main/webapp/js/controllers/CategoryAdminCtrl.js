app.controller('CategoryAdminCtrl', function($scope, $state, $http, $cookies, $window) {
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
    
	$scope.newCategory = function() {
        var settings = {
                method: 'POST',
                url: baseUrl + "/admin/newCategory.do",
                params: {
                	categoryJson: JSON.stringify($scope.category)
                }
            }
            $http(settings).then(function(response) {
            	if (response.data != null && response.data != "") {
                    if (response.data == "success") {
                    	alert("Add category successfully!");
                    	angular.element('#newCategoryModal').modal('hide');
                    	$window.location.reload();
                    } else
                    	alert("Category has already exists!");
            	} else {
                	alert("Network error!");
                }
            }, function(error) {
                alert("Error:" + JSON.stringify(error.data));
            });
	};
});