app.controller('OneBlogCtrl', function($scope, $state, $http, $stateParams, $window, $timeout) {
	
	$scope.params = {};
	$scope.params.isLoading = true;
	
	var height;
	
    var editor = CKEDITOR.instances["content"];
    if (editor) { 
    	editor.destroy(true); 
    }

    
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
        	    var e = CKEDITOR.replace("content", {
        			uiColor: "#F5F5F5",
        			removePlugins: 'resize',
        			height: '600px'
        		});
        		e.setData($scope.blog.content);
                $timeout(function () {
                	$scope.params.isLoading = false;
                }, 500);
        	} else {
        		$scope.params.isLoading = false;
            	alert("Network error!");
            }
        }, function(error) {
        	$scope.params.isLoading = false;
            alert("Error:" + JSON.stringify(error.data));
        });

    $scope.toUpdateBlogPage = function(id) {
        $state.go('app.updateBlog', {
            id: id
        });
    }
    $scope.deleteBlog = function(id) {
        if (confirm("Are you sure to delete this blog?") == true) {
            var settings = {
                    method: 'POST',
                    url: baseUrl + "/blog/deleteBlog.do",
                    params: {
                    	id: id
                    }
                }
                $http(settings).then(function(response) {
                	if (response.data != null && response.data != "") {
                		if(response.data == "success") {
                			alert("Delete blog successfully!");
                			$window.history.back();
                		}
                		else
                			alert("Error occurs when deleting blog!");
                	} else {
                    	alert("Network error!");
                    }
                }, function(error) {
                    alert("Error:" + JSON.stringify(error.data));
                });
        }
    };
});