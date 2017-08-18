app.controller('BlogCtrl', function($scope, $state, $stateParams, $location, $timeout, BlogService, CategoryService) {
	$scope.params = {};
	$scope.params.isLoading = true;
    var currentCategory = $stateParams.category;
    $scope.getClass = function (path) {
    	  return ($location.path().substr(10, path.length) === path) ? 'active' : '';
    };

    CategoryService.getAllCategories().then(function(response) {
    	if(response.status == "200") {
            $scope.categories = response.data;
    	} else {
    		alert("Error: "+response.status+", "+response.statusText);
    	}
    });
    
    BlogService.getBlogsByCategory(currentCategory).then(function(response) {
    	if(response.status == "200") {
    		$scope.blogs = response.data;
    	} else {
    		alert("Error: "+response.status+", "+response.statusText);
    	}
        $scope.$watch("$viewContentLoaded", function() {
            $timeout(function () {
            	$scope.params.isLoading = false;
            }, 500);
        });
    });
    
    $scope.searchBlog = function() {
    	if($scope.params.searchText == null || $scope.params.searchText == "undefined" || $scope.params.searchText == "")
    		return;
        BlogService.getBlogsBySearchText($scope.params.searchText).then(function(response) {
        	if(response.status == "200") {
        		$scope.blogs = response.data;
        	} else {
        		alert("Error: "+response.status+", "+response.statusText);
        	}
            $scope.$watch("$viewContentLoaded", function() {
                $timeout(function () {
                	$scope.params.isLoading = false;
                }, 500);
            });
        });
    };
    
    $scope.toOneBlogPage = function(id) {
        $state.go('app.oneBlog', {
            "id": id
        });
    };
    
});