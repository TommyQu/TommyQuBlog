app.controller('UpdateBlogCtrl', function($scope, $state, $http, $window, $stateParams, BlogService, CategoryService) {
	
	$scope.checkSession();
	$scope.blog = {};
	$scope.blog.categories = "";
	$scope.inputCategories = [];

    var editor = CKEDITOR.instances["content"];
    if (editor) { 
    	editor.destroy(true); 
    }
	var e;
	
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

    BlogService.getOneBlog($stateParams.id).then(function(response) {
    	if(response.status == "200") {
    		$scope.blog = response.data;
    	    e = CKEDITOR.replace("content", {
    			uiColor: "#F5F5F5",
    			removePlugins: 'resize',
    			height: '600px'
    		});
    		e.setData($scope.blog.content);
    	} else {
    		alert("Error: "+response.status+", "+response.statusText);
    	}
    });
    
	$scope.updateBlog = function() {
//		angular.forEach($scope.outputCategories, function(value, key) {    
//			$scope.blog.categories += value.name + ",";
//		});
//		$scope.blog.categories = $scope.blog.categories.substring(0, $scope.blog.categories.length-1);
		$scope.blog.content = e.getData();
		BlogService.updateBlog($scope.blog).then(function(response) {
	    	if(response.status == "200") {
	            if (response.data == "success") {
	            	alert("Update blog successfully!");
	            	$window.history.back();
	            } else if (response.data == "no_session") {
	            	alert(NO_SESSION_MSG);
	            } else
	            	alert("Interner server error!");
	    	} else {
	    		alert("Error: "+response.status+", "+response.statusText);
	    	}
	    });
	};
});