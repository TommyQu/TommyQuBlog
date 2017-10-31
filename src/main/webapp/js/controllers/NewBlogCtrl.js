app.controller('NewBlogCtrl', function($scope, $state, $window, BlogService, CategoryService) {
	
	$scope.checkSession();
	$scope.blog = {};
	$scope.blog.categories = "";
	$scope.inputCategories = [];

	var editor = CKEDITOR.replace( "content", {
		uiColor: "#F5F5F5",
		removePlugins: 'resize'
	});
    
    CategoryService.getAllCategories().then(function(response) {
    	if(response.status == "200") {
    		var categories = response.data;
            for(var i = 0; i < Object.keys(categories).length; i++) {
            	var category = {name:categories[i].content, ticked: false};
            	$scope.inputCategories.push(category);
            }
    	} else {
    		alert("Error: "+response.status+", "+response.statusText);
    	}
    });
    
	$scope.newBlog = function() {
		angular.forEach($scope.outputCategories, function(value, key) {
			$scope.blog.categories += value.name + ",";
		});
		$scope.blog.categories = $scope.blog.categories.substring(0, $scope.blog.categories.length-1);
		$scope.blog.content = editor.getData();
		
	    BlogService.newBlog($scope.blog).then(function(response) {
	    	if(response.status == "200") {
            	alert("New blog successfully!");
            	$window.history.back();
//                	$state.go("app.blog", {
//                		params: "all"
//                	}, {reload: true})
	    	} else if(response.status == "401") {
	    		alert(NO_SESSION_MSG);
	    	} else {
	    		alert("Error: "+response.status+", "+response.statusText);
	    	}
	    });
	};
});