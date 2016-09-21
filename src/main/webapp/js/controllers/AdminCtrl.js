app.controller('AdminCtrl', function($scope, $state, $http, $cookies, $window) {
	$scope.toCategoryAdminPage = function() {
		$state.go('app.categoryAdmin');
	};
});