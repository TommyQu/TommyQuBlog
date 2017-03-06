app.service('GalleryService', function($http) {

    this.getAllGalleries = function() {
        var getAllGalleriesSettings = {
                method: 'GET',
                url: baseUrl + "/gallery/getAllGalleries.do",
            }
            return $http(getAllGalleriesSettings).then(function(response) {
            	return response;
            }, function(error) {
                return error;
            });
    };
    
    this.newGallery = function(galleryObj) {
        var settings = {
                method: 'POST',
                url: baseUrl + "/gallery/newGallery.do",
                data: galleryObj
            };
            return $http(settings).then(function(response) {
            	return response;
            	if (response.data != null && response.data != "") {
                    if (response.data == "success") {
                    	alert("New gallery successfully!");
                    	$window.history.back();
                    } else
                    	alert("Interner server error!");
            	} else {
                	alert("Network error!");
                }
            }, function(error) {
                return error;
            });
    };

});