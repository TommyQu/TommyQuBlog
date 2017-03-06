app.controller('GalleryCtrl', function($scope, $state, $window, GalleryService) {
	
	GalleryService.getAllGalleries().then(function(response) {
    	if(response.status == "200") {
    		$scope.galleries = response.data;
    	} else {
    		alert("Error: "+response.status+", "+response.statusText);
    	}
	});

});