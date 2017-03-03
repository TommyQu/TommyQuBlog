app.service('BlogService', function($http) {

    this.getBlogsByCategory = function(currentCategory) {
        var getBlogsByCategorySettings = {
            method: 'GET',
            url: baseUrl + "/blog/getBlogsByCategory.do",
            params: {
                category: currentCategory
            }
        };
        return $http(getBlogsByCategorySettings).then(function(response) {
            return response;
        }, function(error) {
            return error;
        });
    };

    this.newBlog = function(blogObj) {
        var settings = {
            method: 'POST',
            url: baseUrl + "/blog/newBlog.do",
            data: blogObj
        }
        return $http(settings).then(function(response) {
            return response;
        }, function(error) {
            return error;
        });
    };

    this.getOneBlog = function(id) {
        var settings = {
            method: 'GET',
            url: baseUrl + "/blog/getOneBlog.do",
            params: {
                id: id
            }
        };
        return $http(settings).then(function(response) {
            return response;
        }, function(error) {
            return error;
        });
    };

    this.deleteBlog = function(id) {
        var settings = {
            method: 'POST',
            url: baseUrl + "/blog/deleteBlog.do",
            params: {
                id: id
            }
        };
        return $http(settings).then(function(response) {
            return response;
        }, function(error) {
            return error;
        });
    };
    
    this.updateBlog = function(blogObj) {
        var settings = {
                method: 'POST',
                url: baseUrl + "/blog/updateBlog.do",
                data: blogObj
            }
            return $http(settings).then(function(response) {
            	return response;
            }, function(error) {
            	return error;
            });
    };
});