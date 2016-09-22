app.controller('NewBlogCtrl', function($scope, $state, $http, $cookies, $window) {
	
	$scope.blog = {};
	
	var editor = CKEDITOR.replace( "content", {
		uiColor: "#F5F5F5",
		extraPlugins: 'autogrow',
		autoGrow_minHeight: 200,
		autoGrow_maxHeight: 600,
		autoGrow_bottomSpace: 50,
		removePlugins: 'resize'
	});
	$scope.newBlog = function() {
		$scope.blog.content = editor.getData();
        var settings = {
                method: 'POST',
                url: baseUrl + "/blog/newBlog.do",
                params: {
                	blogJson: JSON.stringify($scope.blog)
                }
            }
            $http(settings).then(function(response) {
            	if (response.data != null && response.data != "") {
                    if (response.data == "success") {
                    	alert("New blog successfully!");
                    	$window.history.back();
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