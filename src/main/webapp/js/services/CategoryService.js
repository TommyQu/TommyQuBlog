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

	this.newCategory = function(categoryObj) {
        var settings = {
                method: 'POST',
                url: baseUrl + "/admin/newCategory.do",
                data: categoryObj
            }
            return $http(settings).then(function(response) {
            	return response;
            }, function(error) {
                return error;
            });
	};
	
	this.deleteCategory = function(id) {
        var settings = {
                method: 'DELETE',
                url: baseUrl + "/admin/deleteCategory.do",
                params: {
                	id: id
                }
            };
            return $http(settings).then(function(response) {
            	return response;
            }, function(error) {
            	return error;
            });
	};
});