app.controller('BlogCtrl', function($scope, $state, $http, $stateParams, $location, $timeout) {
	$scope.params = {};
	$scope.params.isLoading = true;
    var currentCategory = $stateParams.category;
    $scope.getClass = function (path) {
    	  return ($location.path().substr(10, path.length) === path) ? 'active' : '';
    };
    var getAllCategoriesSettings = {
        method: 'GET',
        url: baseUrl + "/admin/getAllCategories.do",
    }
    $http(getAllCategoriesSettings).then(function(response) {
        if (response.data != null && response.data != "") {
            $scope.categories = JSON.parse(response.data);
            $scope.$watch("$viewContentLoaded", function() {
                $timeout(function () {
                	$scope.params.isLoading = false;
                }, 500);
            });
        } else {
        	$scope.params.isLoading = false;
            alert("Network error!");
        }
    }, function(error) {
    	$scope.params.isLoading = false;
        alert("Error:" + JSON.stringify(error.data));
    });

    var getBlogsByCategorySettings = {
        method: 'GET',
        url: baseUrl + "/blog/getBlogsByCategory.do",
        params: {
        	category: currentCategory
        }
    }

    $http(getBlogsByCategorySettings).then(function(response) {
        if (response.data != null && response.data != "") {
            $scope.blogs = JSON.parse(response.data);
        } else {
        	$scope.params.isLoading = false;
            alert("Network error!");
        }
    }, function(error) {
    	$scope.params.isLoading = false;
        alert("Error:" + JSON.stringify(error.data));
    });
    
    $scope.toOneBlogPage = function(id) {
        $state.go('app.oneBlog', {
            "id": id
        });
    };
    
});