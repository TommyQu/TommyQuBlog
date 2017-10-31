app.controller('NewGalleryCtrl', function($scope, $state, $window, FileUploader, GalleryService) {
	
	$scope.checkSession();
	$scope.gallery = {};

	var uploader = $scope.uploader = new FileUploader({});

    uploader.filters.push({
        name: 'asyncFilter',
        fn: function(item /*{File|FileLikeObject}*/, options, deferred) {
            setTimeout(deferred.resolve, 10);
        }
    });

	uploader.filters.push({
	    'name': 'enforceMaxFileSize',
	    'fn': function (item) {
	        return item.size <= 20971520; // 10 MiB to bytes
	    }
	});
	
    angular.element(document).ready(function () {
  	  document.getElementById("upload_widget_opener").addEventListener("click", function() {
		    cloudinary.openUploadWidget({ cloud_name: 'tommyqu', upload_preset: 'lstuuhqk'}, 
		      function(error, result) { console.log(error, result) });
		  }, false);
    });

	  
    $scope.newGallery = function() {
    	GalleryService.newGallery($scope.gallery).then(function(response){
        	if(response.status == "200") {
                if (response.data == "success") {
                	alert("New gallery successfully!");
                	$window.history.back();
                } else
                	alert("Interner server error!");
        	} else {
        		alert("Error: "+response.status+", "+response.statusText);
        	}
    	});
    };
});