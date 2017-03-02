app.controller('NewBlogCtrl', function($scope, $state, $http, $window) {
	
	$scope.checkSession();
	$scope.blog = {};
	$scope.blog.categories = "";
	$scope.inputCategories = [];

	var editor = CKEDITOR.replace( "content", {
		uiColor: "#F5F5F5",
		removePlugins: 'resize'
	});
	
    var getAllCategoriesSettings = {
            method: 'GET',
            url: baseUrl + "/admin/getAllCategories.do"
    }
    $http(getAllCategoriesSettings).then(function(response) {
        if (response.data != null && response.data != "") {
            var categories = JSON.parse(response.data);
            for(var i = 0; i < Object.keys(categories).length; i++) {
            	var category = {name:categories[i].content, ticked: false};
            	$scope.inputCategories.push(category);
            }
        } else {
            alert("Network error!");
        }
    }, function(error) {
        alert("Error:" + JSON.stringify(error.data));
    });
    
	$scope.newBlog = function() {
		angular.forEach($scope.outputCategories, function(value, key) {    
			$scope.blog.categories += value.name + ",";
		});
		$scope.blog.categories = $scope.blog.categories.substring(0, $scope.blog.categories.length-1);
		$scope.blog.content = editor.getData();
        var settings = {
            method: 'POST',
            url: baseUrl + "/blog/newBlog.do",
            data: $scope.blog
        }
        $http(settings).then(function(response) {
        	if (response.data != null && response.data != "") {
                if (response.data == "success") {
                	alert("New blog successfully!");
                	$state.go("app.blog", {
                		params: "all"
                	}, {reload: true})
                } else if(response.data == "no_session") {
                	alert(NO_SESSION_MSG);
                } else
                	alert("Interner server error!");
        	} else {
            	alert("Network error!");
            }
        }, function(error) {
            alert("Error:" + JSON.stringify(error.data));
        });
	};
});