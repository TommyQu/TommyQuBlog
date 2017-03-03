app.service('CategoryService', function($http) {
	this.getAllCategories = function() {
	    var getAllCategoriesSettings = {
	            method: 'GET',
	            url: baseUrl + "/admin/getAllCategories.do",
	        }
	        return $http(getAllCategoriesSettings).then(function(response) {
	        	return response;
	        }, function(error) {
	        	return error;
	        });
	};

});