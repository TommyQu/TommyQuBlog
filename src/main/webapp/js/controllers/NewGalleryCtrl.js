app.controller('NewGalleryCtrl', function($scope, $state, $window, GalleryService) {
	
	$scope.checkSession();
	$scope.gallery = {};
    
    var manualUploader = new qq.FineUploader({
        element: document.getElementById('fine-uploader-manual-trigger'),
        template: 'qq-template-manual-trigger',
        request: {
            endpoint: 'https://api.cloudinary.com/v1_1/tommyqu/image/upload'
        },
        thumbnails: {
            placeholders: {
                waitingPath: '/source/placeholders/waiting-generic.png',
                notAvailablePath: '/source/placeholders/not_available-generic.png'
            }
        },
        validation: {
        	allowedExtensions: ['jpeg', 'jpg', 'png'],
        	itemLimit: 10,
        	sizeLimit: 5120000
        },
        autoUpload: false,
        debug: true
    });

    qq(document.getElementById("trigger-upload")).attach("click", function() {
        manualUploader.uploadStoredFiles();
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