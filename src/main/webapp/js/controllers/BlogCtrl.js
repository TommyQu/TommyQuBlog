app.controller('BlogCtrl', function($scope, $state, $http, $stateParams, $location) {
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
        } else {
            alert("Network error!");
        }
    }, function(error) {
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
            alert("Network error!");
        }
    }, function(error) {
        alert("Error:" + JSON.stringify(error.data));
    });
    
    $scope.toOneBlogPage = function(id) {
        $state.go('app.oneBlog', {
            "id": id
        });
    };
    
});