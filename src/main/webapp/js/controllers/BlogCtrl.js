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

    var getAllBlogsSettings = {
        method: 'GET',
        url: baseUrl + "/blog/getAllBlogs.do"
    }

    $http(getAllBlogsSettings).then(function(response) {
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