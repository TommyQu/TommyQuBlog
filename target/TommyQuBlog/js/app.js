var app = angular.module('BlogApp', ['ui.router', 'ngCookies', 'isteven-multi-select']);
app.config(function($stateProvider, $urlRouterProvider) {

  $urlRouterProvider.otherwise("app/home");

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

    .state('app.profile', {
      url: "/profile",
      views: {
    	  'mainContent': {
    		  templateUrl: "view/profile.html",
    		  controller: "ProfileCtrl"
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
    
    .state('app.updateBlog', {
      url: "/updateBlog/:id",
      views: {
    	  'mainContent': {
    		  templateUrl: "view/updateBlog.html",
    		  controller: "UpdateBlogCtrl"
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
   
    .state('app.newGallery', {
      url: "/newGallery",
      views: {
    	  'mainContent': {
    		  templateUrl: "view/newGallery.html",
    		  controller: "NewGalleryCtrl"
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

//var baseUrl = "https://tommyqublog.herokuapp.com";
var baseUrl = "http://localhost:8080/tommyqublog";