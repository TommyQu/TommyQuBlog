app.controller('NewGalleryCtrl', function($scope, $state, $http, $window) {
	
	$scope.checkSession();
	$scope.gallery = {};
	
    var manualUploader = new qq.FineUploader({
        element: document.getElementById('fine-uploader-manual-trigger'),
        template: 'qq-template-manual-trigger',
        request: {
            endpoint: baseUrl+'/gallery/uploadImages.do'
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
        var settings = {
            method: 'POST',
            url: baseUrl + "/gallery/newGallery.do",
            params: {
            	galleryJson: JSON.stringify($scope.gallery)
            }
        }
        $http(settings).then(function(response) {
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
            alert("Error:" + JSON.stringify(error.data));
        });
    };
});