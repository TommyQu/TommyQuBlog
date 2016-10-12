app.controller('OneBlogCtrl', function($scope, $state, $http, $stateParams) {
	
	var height;
	

	CKEDITOR.replace("content", {
		uiColor: "#F5F5F5",
//		removePlugins: 'elementspath',
//		resize_enabled: false,
//	   toolbar: 'Custom', //makes all editors use this toolbar
//
//	   toolbar_Custom: [] //define an empty array or whatever buttons you want.
	});
	
	
    var settings = {
            method: 'GET',
            url: baseUrl + "/blog/getOneBlog.do",
            params: {
            	id: $stateParams.id
            }
        }
        $http(settings).then(function(response) {
        	if (response.data != null && response.data != "") {
        		$scope.blog = JSON.parse(response.data);
        		var contentDiv = document.getElementById("content");
        		height = Math.max(contentDiv.scrollHeight, contentDiv.offsetHeight, contentDiv.clientHeight);
        	} else {
            	alert("Network error!");
            }
        }, function(error) {
            alert("Error:" + JSON.stringify(error.data));
        });

    $scope.deleteBlog = function(id) {
        if (confirm("Are you sure to delete this blog?") == true) {
            var settings = {
                    method: 'POST',
                    url: baseUrl + "/blog/deleteBlog.do",
                    params: {
                    	id: id
                    }
                }
                $http(settings).then(function(response) {
                	if (response.data != null && response.data != "") {
                		if(response.data == "success") {
                			alert("Delete blog successfully!");
                			$state.go("app.blog");
                		}
                		else
                			alert("Error occurs when deleting blog!");
                	} else {
                    	alert("Network error!");
                    }
                }, function(error) {
                    alert("Error:" + JSON.stringify(error.data));
                });
        }
    };
});