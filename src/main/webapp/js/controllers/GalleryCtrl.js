app.controller('GalleryCtrl', function($scope, $state, $http, $window) {
	
    var getAllGalleriesSettings = {
            method: 'GET',
            url: baseUrl + "/gallery/getAllGalleries.do",
        }
        $http(getAllGalleriesSettings).then(function(response) {
            if (response.data != null && response.data != "") {
                $scope.galleries = JSON.parse(response.data);
            } else {
                alert("Network error!");
            }
        }, function(error) {
            alert("Error:" + JSON.stringify(error.data));
        });
    
});