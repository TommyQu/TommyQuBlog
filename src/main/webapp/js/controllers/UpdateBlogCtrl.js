app.controller('UpdateBlogCtrl', function($scope, $state, $http, $window, $stateParams) {
	
	$scope.checkSession();
	$scope.blog = {};
	$scope.blog.categories = "";
	$scope.inputCategories = [];

    var editor = CKEDITOR.instances["content"];
    if (editor) { 
    	editor.destroy(true); 
    }
	var e;
	
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

    var settings = {
            method: 'GET',
            url: baseUrl + "/blog/getOneBlog.do",
            params: {
            	id: $stateParams.id
            }
        }
        $http(settings).then(function(response) {
        	if (response.data != null && response.data != "") {
        		$scope.blog = JSON.parse(response.data);
        	    e = CKEDITOR.replace("content", {
        			uiColor: "#F5F5F5",
        			removePlugins: 'resize',
        			height: '600px'
        		});
        		e.setData($scope.blog.content);
        	} else {
            	alert("Network error!");
            }
        }, function(error) {
            alert("Error:" + JSON.stringify(error.data));
        });
    
	$scope.updateBlog = function() {
//		angular.forEach($scope.outputCategories, function(value, key) {    
//			$scope.blog.categories += value.name + ",";
//		});
//		$scope.blog.categories = $scope.blog.categories.substring(0, $scope.blog.categories.length-1);
		$scope.blog.content = e.getData();
        var settings = {
            method: 'POST',
            url: baseUrl + "/blog/updateBlog.do",
            data: $scope.blog
        }
        $http(settings).then(function(response) {
        	if (response.data != null && response.data != "") {
                if (response.data == "success") {
                	alert("Update blog successfully!");
                	$window.history.back();
                } else if (response.data == "no_session") {
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