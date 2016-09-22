app.controller('OneBlogCtrl', function($scope, $state, $http, $stateParams) {
	
	var height;
	CKEDITOR.replace("content", {
		uiColor: "#F5F5F5",
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
	
    	CKEDITOR.on('instanceReady', function(e) {
    		alert(height);
    		$("#cke_1_top").remove();
    		$("#cke_1_bottom").remove();
    		$("#cke_1_contents").height(height);
    	});

});