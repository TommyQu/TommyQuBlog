app.controller('OneBlogCtrl', function($scope, $state, $http, $stateParams, $window, $timeout, $cookies, BlogService, CommentService) {
	
	$scope.params = {};
	$scope.params.isLoading = true;
	$scope.comment = {};
	
	var height;
	
    var editor = CKEDITOR.instances["content"];
    if (editor) { 
    	editor.destroy(true); 
    }
    
    BlogService.getOneBlog($stateParams.id).then(function(response) {
    	if(response.status == "200") {
    		$scope.blog = response.data;
    	    var e = CKEDITOR.replace("content", {
    			uiColor: "#F5F5F5",
    			removePlugins: 'resize,dragdrop,basket',
    			height: '600px'
    		});
    		e.setData($scope.blog.content);
    		getComments();
    	} else {
    		alert("Error: "+response.status+", "+response.statusText);
    	}
    });
    

    function getComments() {
        CommentService.getComments($scope.blog.id).then(function(response) {
        	if(response.status == "200") {
        		$scope.comments = response.data;
        	} else {
        		alert("Error: "+response.status+", "+response.statusText);
        	}
            $timeout(function () {
            	$scope.params.isLoading = false;
            }, 500);
        });

    };
    
    $scope.toUpdateBlogPage = function(id) {
        $state.go('app.updateBlog', {
            id: id
        });
    }
    
    $scope.deleteBlog = function(id) {
        if (confirm("Are you sure to delete this blog?") == true) {
            BlogService.deleteBlog(id).then(function(response) {
            	if(response.status == "200") {
            		if(response.data == "success") {
            			alert("Delete blog successfully!");
            			$window.history.back();
            		}
            		else
            			alert("Error occurs when deleting blog!");
            	} else {
            		alert("Error: "+response.status+", "+response.statusText);
            	}
            });
        }
    };
    
    $scope.newComment = function() {
    	$scope.comment.parentId = $scope.blog.id;
        CommentService.newComment($scope.comment).then(function(response) {
        	if(response.status == "200") {
            	alert("New comment successfully!");
            	$scope.comment.content = "";
            	getComments();
        	} else if(response.status == "401") {
            	$cookies.remove("userCookie");
            	alert(NO_SESSION_MSG);
            	$window.location.reload();
        	} else {
        		alert("Error: "+response.status+", "+response.statusText);
        	}
        });
    };
});