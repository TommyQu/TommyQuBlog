app.controller('CategoryAdminCtrl', function($scope, $state, $window, CategoryService) {
	$scope.category = {};
    
    CategoryService.getAllCategories().then(function(response) {
    	if(response.status == "200") {
    		$scope.categories = response.data;
    	} else {
    		alert("Error: "+response.status+", "+response.statusText);
    	}
    });
    
	$scope.newCategory = function() {
		CategoryService.newCategory($scope.category).then(function(response) {
	    	if(response.status == "200") {
	          if (response.data == "success") {
	          	alert("Add category successfully!");
	          	angular.element('#newCategoryModal').modal('hide');
	          	$window.location.reload();
	          } else if(response.data == "exist")
	          	alert("Category has already exists!");
	    	} else {
	    		alert("Error: "+response.status+", "+response.statusText);
	    	}
	    });
	};
	
    $scope.deleteCategory = function(id) {
        if (confirm("Are you sure to delete this category?") == true) {
        	CategoryService.deleteCategory(id).then(function(response){
    	    	if(response.status == "200") {
    		          if (response.data == "success") {
    	        			alert("Delete category successfully!");
    	        			$window.location.reload();
    		          } else
    		          	alert("Internal server errpr!");
    		    	} else {
    		    		alert("Error: "+response.status+", "+response.statusText);
    		    	}
        	});
        }
    };
});