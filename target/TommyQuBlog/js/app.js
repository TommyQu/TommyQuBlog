var app = angular.module('BlogApp', ['ui.router', 'ngCookies', 'isteven-multi-select']);
app.config(function($stateProvider, $urlRouterProvider) {
  //
  // For any unmatched url, redirect to /state1ico
  $urlRouterProvider.otherwise("app/home");
  //
  // Now set up the states
  $stateProvider
  .state('app', {
    url: "/app",
    abstract: true,
    templateUrl: "view/global.html",
    controller: "GlobalCtrl"
  })
  
    .state('app.home', {
      url: "/home",
      views: {
    	  'mainContent': {
    		  templateUrl: "view/home.html"
    	  }
      }
    })
    
    .state('app.blog', {
      url: "/blog/:category",
      views: {
    	  'mainContent': {
    		  templateUrl: "view/blog.html",
    		  controller: "BlogCtrl"
    	  }
      }
    })

    .state('app.oneBlog', {
      url: "/oneBlog/:id",
      views: {
    	  'mainContent': {
    		  templateUrl: "view/oneBlog.html",
    		  controller: "OneBlogCtrl"
    	  }
      }
    })
    
    .state('app.aboutMe', {
      url: "/aboutMe",
      views: {
    	  'mainContent': {
    		  templateUrl: "view/aboutMe.html"
    	  }
      }
    })
    
    .state('app.admin', {
      url: "/admin",
      views: {
    	  'mainContent': {
    		  templateUrl: "view/admin.html",
    		  controller: "AdminCtrl"
    	  }
      }
    })

    .state('app.newBlog', {
      url: "/newBlog",
      views: {
    	  'mainContent': {
    		  templateUrl: "view/newBlog.html",
    		  controller: "NewBlogCtrl"
    	  }
      }
    })
    
    .state('app.gallery', {
      url: "/gallery",
      views: {
    	  'mainContent': {
    		  templateUrl: "view/gallery.html",
    		  controller: "GalleryCtrl"
    	  }
      }
    })
    
    .state('app.categoryAdmin', {
        url: "/categoryAdmin",
        views: {
      	  'mainContent': {
      		  templateUrl: "view/categoryAdmin.html",
      		  controller: "CategoryAdminCtrl"
      	  }
        }
      }); 

});

//app.factory('checkSessionService', function() {
//    return {
//        checkSession: function() {
//            alert("I'm foo!");
//        }
//    };
//});

//var baseUrl = "https://tommyqublog.herokuapp.com";
var baseUrl = "http://localhost:8080/tommyqublog";