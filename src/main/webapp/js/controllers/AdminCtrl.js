app.controller('AdminCtrl', function($scope, $state, $http, $cookies, $window) {

	$scope.checkSession();
	$scope.toCategoryAdminPage = function() {
		$state.go('app.categoryAdmin');
	};
});