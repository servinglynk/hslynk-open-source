var app = angular.module('app', ['ngRoute','ngStorage','ngAnimate', 'route-segment', 'view-segment','ui.bootstrap']);

var header = { sessionToken : '' };

app.directive('fileModel', ['$parse', function ($parse) {
    return {
       restrict: 'A',
       link: function(scope, element, attrs) {
          var model = $parse(attrs.fileModel);
          var modelSetter = model.assign;
          
          element.bind('change', function(){
             scope.$apply(function(){
                modelSetter(scope, element[0].files[0]);
             });
          });
       }
    };
 }]);
app.factory("LS", [ '$window', '$rootScope', function($window, $rootScope) {
	  angular.element($window).on('storage', function(event) {
	    if (event.key === 'my-storage') {
	      $rootScope.$apply();
	    }
	  });
	  return {
	    setData: function(val) {
	      $window.localStorage && $window.localStorage.setItem('my-storage', val);
	      return this;
	    },
	    getData: function() {
	      return $window.localStorage && $window.localStorage.getItem('my-storage');
	    }
	  };
	}]);
app.config(['$routeSegmentProvider', '$routeProvider', function($routeSegmentProvider, $routeProvider) {
    
    // Configuring provider options
    
    $routeSegmentProvider.options.autoLoadTemplates = true;
    
    // Setting routes. This consists of two parts:
    // 1. `when` is similar to vanilla $route `when` but takes segment name instead of params hash
    // 2. traversing through segment tree to set it up
  
    $routeSegmentProvider
    
        .when('/login',          's1') // this is for login
        .when('/login',          's4') // this is for login
        .when('/admin',          's2.dashboard')
        .when('/admin/dashboard',      's2.dashboard')
		 .when('/admin/managefiles',      's2.managefiles')
		  .when('/admin/bulkupload',      's2.bulkupload')
		   .when('/admin/managesync',      's2.managesync')
		      .when('/admin/managereport',      's2.managereport')
		      .when('/admin/manageeligreq',      's2.manageeligreq')
       		  .when('/admin/setting',      's2.setting')
			   .when('/admin/requestreport',      's2.requestreport')
			   
			   .when('/admin/createprojgrp',      's2.createprojgrp')
			   .when('/admin/manageprojgrp',      's2.manageprojgrp')
			   
			   .when('/admin/createorg',      's2.createorg')
			   .when('/admin/manageorg',      's2.manageorg')
			   
			   .when('/admin/createprofile',      's2.createprofile')
			   .when('/admin/manageprofile',      's2.manageprofile')
			   
			   .when('/admin/createrole',      's2.createrole')
			   .when('/admin/managerole',      's2.managerole')
			   
			    .when('/admin/createuser',      's2.createuser')
			   .when('/admin/manageuser',      's2.manageuser')
			     .when('/admin/onboardfellow', 's2.onboardfellow')
                 .when('/admin/errormessage/:id', 's2.errormessage')
				 
				  .when('/admin/onboardfellowgroup',      's2.onboardfellow.onboardfellowgroup')
   			    .when('/admin/onboardfellowuser',      's2.onboardfellow.onboardfellowuser')

        .segment('s1', {
            templateUrl: 'templates/login.html'})
        .segment('s4', {
            templateUrl: 'templates/login.html', controller: 'logoutCtrl'})
        .segment('s2', {
            templateUrl: 'templates/root.html'})
		 .within()
		
         .segment('dashboard', {
                templateUrl: 'templates/partial/dashboard.html', controller: 'dashboardCtrl'})   
		  .segment('managefiles', {
                templateUrl: 'templates/partial/managefiles.html', controller: 'managefilesCtrl'})
          .segment('errormessage', {
              templateUrl: 'templates/partial/errormessage.html', controller: 'errormessageCtrl'
             
          } )
                .segment('manageuser', {
                templateUrl: 'templates/partial/manageuser.html', controller: 'manageuserCtrl'})   
		   .segment('managereport', {
                templateUrl: 'templates/partial/managereport.html', controller: 'managereportCtrl'})   
            .segment('manageeligreq', {
                templateUrl: 'templates/partial/manageeligreq.html', controller: 'manageeligreqCtrl'})   
		  .segment('bulkupload', {
		      templateUrl: 'templates/partial/bulkupload.html', controller: 'bulkUploadCtrl'})   
		  .segment('managesync', {
                templateUrl: 'templates/partial/managesync.html', controller: 'managesyncCtrl'})   
		    .segment('setting', {
                templateUrl: 'templates/partial/setting.html', controller: 'settingCtrl'})   
			 .segment('requestreport', {
                templateUrl: 'templates/partial/requestreport.html', controller: 'requestreportCtrl'}) 
               
                .segment('createorg', {
                templateUrl: 'templates/partial/createorg.html', controller: 'createorgCtrl'})  
                .segment('manageorg', {
                templateUrl: 'templates/partial/manageorg.html', controller: 'manageorgCtrl'})
                
                 .segment('createprofile', {
                templateUrl: 'templates/partial/createprofile.html', controller: 'createprofileCtrl'})  
                .segment('manageprofile', {
                templateUrl: 'templates/partial/manageprofile.html', controller: 'manageprofileCtrl'})
                
                  .segment('createrole', {
                templateUrl: 'templates/partial/createrole.html', controller: 'createroleCtrl'})  
                .segment('manageprofile', {
                templateUrl: 'templates/partial/managerole.html', controller: 'manageroleCtrl'})
                
                 .segment('createprojgrp', {
                templateUrl: 'templates/partial/createprojgrp.html', controller: 'createprojgrpCtrl'})  
                .segment('manageprojgrp', {
                templateUrl: 'templates/partial/manageprojgrp.html', controller: 'manageprojgrpCtrl'})

                  .segment('createuser', {
                templateUrl: 'templates/partial/createuser.html', controller: 'createuserCtrl'})  
                .segment('manageuser', {
                templateUrl: 'templates/partial/manageuser.html', controller: 'manageuserCtrl'})
                
                 .segment('onboardfellow', {
                templateUrl: 'templates/partial/onboardfellow.html', controller: 'onboardfellowCtrl'})
        
			
           .within()
			 // nested states 
			// each of these sections will have their own view
			// url will be nested (/form/profile)
			.segment('onboardfellowgroup', {
				templateUrl: 'templates/partial/onboardfellowgroup.html', controller: 'onboardfellowgroupCtrl'
			})
				.segment('onboardfellowuser', {
				templateUrl: 'templates/partial/onboardfellowuser.html', controller: 'onboardfellowuserCtrl'
			})
                
        .up()

    $routeProvider.otherwise({redirectTo: '/login'});  // default redirect
    
}]) ;
app.run(['$rootScope', '$location', '$sessionStorage', '$http',
         function ($rootScope, $location, $sessionStorage, $http) {
			 
			if($sessionStorage.account!=undefined && $sessionStorage.account.roles !=undefined)
			{
				$rootScope.roleName=$sessionStorage.account.roles[0].roleName;// data.account.roles.role[0].roleName;
			}
     		// here we have to check why keep out(isLoggedIn is undefined  when dashbaorad load)
     		//$sessionStorage.isLoggedIn=true;
			if($location.path() != '/admin/dashboard' && $location.path() != '/login' )
			{
     			 if ($sessionStorage.isLoggedIn==undefined) {
     			
                   $location.path('/login');//
     	       }
			}
       
         }]);
app.value('loader', { show: false });

app.directive('appFilereader',['$q', function ($q) {
    var slice = Array.prototype.slice;
		
    return {
        restrict: 'A',
        require: '?ngModel',
        link: function (scope, element, attrs, ngModel) {
            if (!ngModel) return;

            ngModel.$render = function () { };

            element.bind('change', function (e) {
									
                var element = e.target;
                ngModel.$setViewValue(element);
            }); 

        } //link
    }; //return
}]);
