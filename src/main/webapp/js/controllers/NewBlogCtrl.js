app.controller('NewBlogCtrl', function($scope, $state, $http, $cookies, $window) {
	
	$scope.blog = {};
	
	CKEDITOR.replace( "content", {
		uiColor: "#F5F5F5",
		extraPlugins: 'autogrow',
		autoGrow_minHeight: 200,
		autoGrow_maxHeight: 600,
		autoGrow_bottomSpace: 50,
		removePlugins: 'resize'
	});
	$scope.editorOptions = {
			uiColor: "#F5F5F5",
			extraPlugins: 'autogrow',
			autoGrow_minHeight: 200,
			autoGrow_maxHeight: 600,
			autoGrow_bottomSpace: 50,
			removePlugins: 'resize'
		};
	$scope.newBlog = function() {
		alert($scope.blog.content);
	};
});