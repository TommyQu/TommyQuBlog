app.service('CommentService', function($http) {

    this.getComments = function(id) {
        var getCommentsSettings = {
                method: 'GET',
                url: baseUrl + "/comment/getCommentsByBlogId.do",
                params: {
                	blogId: id
                }
        };
        return $http(getCommentsSettings).then(function(response) {
        	return response;
        }, function(error) {
        	return error;
        });
    };

    
    this.newComment = function(commentObj) {
        var settings = {
                method: 'POST',
                url: baseUrl + "/comment/newComment.do",
                data: commentObj
            };
            return $http(settings).then(function(response) {
            	return response;
            }, function(error) {
                return error;
            });
    };
});