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
		  .when('/admin/bulkuploadNew',      's2.bulkuploadNew')
		   .when('/admin/managesync',      's2.managesync')
		      .when('/admin/managereport',      's2.managereport')
		      .when('/admin/manageeligreq',      's2.manageeligreq')
       		  .when('/admin/setting',      's2.setting')
			   .when('/admin/requestreport',      's2.requestreport')
			    .when('/admin/mergeclient',      's2.mergeclient')
			    .when('/admin/unmergeclient',      's2.unmergeclient')
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
		   .segment('bulkuploadNew', {
		      templateUrl: 'templates/partial/bulkuploadnew.html', controller: 'bulkUploadNewCtrl'})  
		  .segment('managesync', {
                templateUrl: 'templates/partial/managesync.html', controller: 'managesyncCtrl'})   
		    .segment('setting', {
                templateUrl: 'templates/partial/setting.html', controller: 'settingCtrl'})   
			 .segment('requestreport', {
                templateUrl: 'templates/partial/requestreport.html', controller: 'requestreportCtrl'}) 
               .segment('mergeclient', {
                templateUrl: 'templates/partial/mergeclient.html', controller: 'mergeclientCtrl'}) 
                  .segment('unmergeclient', {
                templateUrl: 'templates/partial/unmergeclient.html', controller: 'unmergeclientCtrl'}) 
                
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
;var filesCollection="";
/*app.service('Calculator',[ function () {
        this.square = function (a) { return a*a};

    this.GetProjectList = function ($http, success) {
        $http.get('/hmis-bulk-loader/mapper/projects').success(function (data) {
            if(success)success(data)
        });
    };

}]);*/
var Service= ({
	GetProjectList: function ($http, success,error,$scope) {
        var apiurl = "/hmis-clientapi-v2017/rest/v2/projects";
        $http({
            method: 'GET',
            url: apiurl,
            headers: {
              'X-HMIS-TrustedApp-Id': 'MASTER_TRUSTED_APP',
                'Authorization': 'HMISUserAuth session_token='+$scope.sessionToken,
                'Accept': 'application/json;odata=verbose'}
        }).success(function (data) {
            if(success)success(data.projects.projects)
        }).error(error);
    },
    GetUserInfo: function ($http,$scope, success, error) {
  	  var apiurl = "/hmis-user-service/rest/accounts/self/basicinfo";
        $http({
            method: 'GET',
            url: apiurl,
            headers: {
              'X-HMIS-TrustedApp-Id': 'MASTER_TRUSTED_APP',
                'Authorization': 'HMISUserAuth session_token='+$scope.sessionToken,
                'Accept': 'application/json;odata=verbose'}
        }).success(function (data) {
            if(success)success(data)
        }).error(error);
  },
  GetUserByOrganization:function ($http,$scope, success, error) {
	  $scope.organizationId ="b5598c6c-d021-4f5f-9695-77f7f4685ed2"
  	  var apiurl = "/hmis-user-service/rest/accounts/"+$scope.organizationId+"/users";
         $http({
             method: 'GET',
             url: apiurl,
             headers: {
               'X-HMIS-TrustedApp-Id': 'MASTER_TRUSTED_APP',
                 'Authorization': 'HMISUserAuth session_token='+$scope.sessionToken,
                 'Accept': 'application/json;odata=verbose'}
         }).success(function (data) {
             if(success)success(data.accounts)
         }).error(error);
   },
    GetReports: function ($http, success,$scope) {
        var apiurl = "/hmis-report-service/rest/reports";
        $http({
            method: 'GET',
            url: apiurl,
            headers: {
              'X-HMIS-TrustedApp-Id': 'MASTER_TRUSTED_APP',
                'Authorization': 'HMISUserAuth session_token='+$scope.sessionToken,
                'Accept': 'application/json;odata=verbose'}
        }).success(function (data) {
            if(success)success(data.ReportConfigs.reportConfigs)
        });
    },
    GetFilesListRECENT: function ($http, success, $scope) {
        var apiurl = "/hmis-upload-service/rest/bulk-upload?status=RECENT";
            $http({
                method: 'GET',
                url: apiurl,
                headers: {
                  'X-HMIS-TrustedApp-Id': 'MASTER_TRUSTED_APP',
                    'Authorization': 'HMISUserAuth session_token='+$scope.sessionToken,
                    'Accept': 'application/json;odata=verbose'}
            }).success(function (data) {
                if(success)success(data.BulkUploads.bulkUploads)
            });
      },
    GetFilesListSTAGING: function ($http, success, $scope) {
        var apiurl = "/hmis-upload-service/rest/bulk-upload?status=STAGING";
            $http({
                method: 'GET',
                url: apiurl,
                headers: {
                  'X-HMIS-TrustedApp-Id': 'MASTER_TRUSTED_APP',
                    'Authorization': 'HMISUserAuth session_token='+$scope.sessionToken,
                    'Accept': 'application/json;odata=verbose'}
            }).success(function (data) {
                if(success)success(data.BulkUploads.bulkUploads)
            });
      },  GetFilesListDELETED: function ($http, success, $scope) {
          var apiurl = "/hmis-upload-service/rest/bulk-upload?status=DELETED";
             $http({
                 method: 'GET',
                 url: apiurl,
                 headers: {
                   'X-HMIS-TrustedApp-Id': 'MASTER_TRUSTED_APP',
                     'Authorization': 'HMISUserAuth session_token='+$scope.sessionToken,
                     'Accept': 'application/json;odata=verbose'}
             }).success(function (data) {
                 if(success)success(data.BulkUploads.bulkUploads)
             });
       },
    GetFilesListLIVE: function ($http, success,$scope) {
    var apiurl = "/hmis-upload-service/rest/bulk-upload?status=LIVE";
       $http({
           method: 'GET',
           url: apiurl,
           headers: {
             'X-HMIS-TrustedApp-Id': 'MASTER_TRUSTED_APP',
               'Authorization': 'HMISUserAuth session_token='+$scope.sessionToken,
               'Accept': 'application/json;odata=verbose'}
       }).success(function (data) {
           if(success)success(data.BulkUploads.bulkUploads)
       });
 },
    GetFilesListERROR: function ($http, success,$scope) {
         var apiurl = "/hmis-upload-service/rest/bulk-upload?status=ERROR";
             $http({
                 method: 'GET',
                 url: apiurl,
                 headers: {
                   'X-HMIS-TrustedApp-Id': 'MASTER_TRUSTED_APP',
                     'Authorization': 'HMISUserAuth session_token='+$scope.sessionToken,
                     'Accept': 'application/json;odata=verbose'}
             }).success(function (data) {
                 if(success)success(data.BulkUploads.bulkUploads)
             });
    },
    GetFilesLogList: function ($http,success, $scope) {
    	var apiurl = "/hmis-clientapi-v"+$scope.year+"/rest/bulkupload/activities/"+$scope.idForLog;
        $http({
            method: 'GET',
            url: apiurl,
            headers: {
                'X-HMIS-TrustedApp-Id': 'MASTER_TRUSTED_APP',
                'Authorization': 'HMISUserAuth session_token=' + $scope.sessionToken,
                'Accept': 'application/json;odata=verbose'
            }
        }).success(function (data) {
            if (success) success(data)
        });
    },
    GetErrorMessage: function ($http, success, $scope) {
        var apiurl = "/hmis-clientapi-v"+$scope.year+"/rest/bulkupload/errors/"+$scope.id;
        $http({
            method: 'GET',
            url: apiurl,
            headers: {
                'X-HMIS-TrustedApp-Id': 'MASTER_TRUSTED_APP',
                'Authorization': 'HMISUserAuth session_token=' + $scope.sessionToken,
                'Accept': 'application/json;odata=verbose'
            }
        }).success(function (data) {
            if (success) success(data.bulkUploadErrors.bulkUploadErrors)
        });
    },
 GetSyncFilesList: function ($http, success) {
        $http.get('/hmis-bulk-loader-v2014/sync').success(function (data) {
				if(success)success(data)
			});
    },
    CheckServiceAvailableBulkUpload: function ($http,$scope, success,error) {
    	  var apiurl = "/hmis-upload-service/rest/bulk-upload?status=STAGING";
             $http({
                 method: 'GET',
                 url: apiurl,
                 headers: {
                   'X-HMIS-TrustedApp-Id': 'MASTER_TRUSTED_APP',
                     'Authorization': 'HMISUserAuth session_token='+$scope.sessionToken,
                     'Accept': 'application/json;odata=verbose'}
             }).success(function (data) {
                 if(success)success(data.BulkUploads.bulkUploads)
             }).error(error);
       },
CheckServiceAvailableUploadFile: function ($http,$scope, success,error) {
        $http.post('/hmis-upload-service/uploadFile',{
            headers: {
                'X-HMIS-TrustedApp-Id': 'MASTER_TRUSTED_APP',
                  'Authorization': 'HMISUserAuth session_token='+$scope.sessionToken,
                  'Accept': 'application/json;odata=verbose'}}).success(function (data) {
        if(success)success(data)
    }).error(error);

},
CheckServiceAvailableAuthenticate: function ($http,$scope, success,error) {
        $http.post('/hmis-client-dedup/rest/api/v1/authenticate',{
            headers: {
                'X-HMIS-TrustedApp-Id': 'MASTER_TRUSTED_APP',
                  'Authorization': 'HMISUserAuth session_token='+$scope.sessionToken,
                  'Accept': 'application/json;odata=verbose'}}).success(function (data) {
        if(success)success(data)
    }).error(error);

},
LoadStatistics: function ($http,$scope, success) {
        $http.get('/hmis-upload-service/rest/bulk-upload?status=LIVE',{
                headers: {
                    'X-HMIS-TrustedApp-Id': 'MASTER_TRUSTED_APP',
                      'Authorization': 'HMISUserAuth session_token='+$scope.sessionToken,
                      'Accept': 'application/json;odata=verbose'}}).success(
		function (data)
		{
			 filesCollection =data.BulkUploads.bulkUploads;
	    	// success(data)
			  $http.get('/hmis-upload-service/rest/bulk-upload?status=STAGING', {
			            headers: {
			                'X-HMIS-TrustedApp-Id': 'MASTER_TRUSTED_APP',
			                  'Authorization': 'HMISUserAuth session_token='+$scope.sessionToken,
			                  'Accept': 'application/json;odata=verbose'}}).success(
				function (data)
				{
					Array.prototype.push.apply(filesCollection, data.BulkUploads.bulkUploads);
				// success(data)

					$http.get('/hmis-upload-service/rest/bulk-upload?status=ERROR',{
				            headers: {
				                'X-HMIS-TrustedApp-Id': 'MASTER_TRUSTED_APP',
				                  'Authorization': 'HMISUserAuth session_token='+$scope.sessionToken,
				                  'Accept': 'application/json;odata=verbose'}}).success(
					function (data)
					{
						Array.prototype.push.apply(filesCollection, data.BulkUploads.bulkUploads);
						success(filesCollection)
				  })
			  })

  	  });
},
logout: function ($http,$scope, success,error) {
	// need to change url for services
    $http({
        method: 'DELETE',
        url: '/hmis-user-service/rest/sessions/'+$scope.sessionToken,
        headers: {
          'X-HMIS-TrustedApp-Id': 'MASTER_TRUSTED_APP',
            'Authorization': 'HMISUserAuth session_token='+$scope.sessionToken,
            'Accept': 'application/json;odata=verbose'}
    }).success(function (data) {
        if(success)success(data)
    });
},

SaveSetting: function ($http,$scope, success,error) {
	 var apiurl = "/hmis-user-service/rest/accounts"; // need to upate url

        $http({
            method: 'POST',
            url: apiurl,
            data :
            	{ "account":{
                    "username": $scope.emailAddress,
                    "emailAddress":$scope.emailAddress,
                    "password":$scope.password,
                    "firstName":$scope.firstName,
                    "lastName":$scope.lastName,
                  	"accountId":$scope.accountId
                 }
           },
            headers: {
              'X-HMIS-TrustedApp-Id': 'MASTER_TRUSTED_APP',
                'Authorization': 'HMISUserAuth session_token='+$scope.sessionToken,
                'Accept': 'application/json;odata=verbose'}
        }).success(function (data) {
            if(success)success(data)
        }).error(error);

},
submitHivePasswordForm: function ($http,$scope, success,error) {
	 var apiurl = "/hmis-user-service/rest/accounts"; // need to upate url
       $http({
           method: 'POST',
           url: apiurl,
           data :
           	{ "account":{
                   "username": $scope.emailAddress,
                   "emailAddress":$scope.emailAddress,
                   "password":$scope.password,
                   "firstName":$scope.firstName,
                   "lastName":$scope.lastName,
                 	"accountId":$scope.accountId
                }
          },
           headers: {
             'X-HMIS-TrustedApp-Id': 'MASTER_TRUSTED_APP',
               'Authorization': 'HMISUserAuth session_token='+$scope.sessionToken,
               'Accept': 'application/json;odata=verbose'}
       }).success(function (data) {
           if(success)success(data)
       }).error(error);

},
SendRequestReport: function ($http,$scope, success,error) {
	data =$scope.form;
     var apiurl = "/hmis-report-service/rest/reports";
     data = $scope.form;
     $http({
         method: 'POST',
         url: apiurl,
         data :
         	{ "reportConfig":{
                 "name": data.name,
                 "startDate":data.startDate,
                 "endDate":data.endDate,
                 "reportType" : data.reportType,
                 "reportLevel":data.reportLevel,
                 "projectIds" : data.project
              }
        },
         headers: {
           'X-HMIS-TrustedApp-Id': 'MASTER_TRUSTED_APP',
             'Authorization': 'HMISUserAuth session_token='+$scope.sessionToken,
             'Accept': 'application/json;odata=verbose'}
     }).success(function (data) {
         if(success)success(data)
     }).error(error);
},

bulkupload: function ($http, $scope,file, success, error) {
    var apiurl = "/hmis-upload-service/rest/upload";
     var formData = new FormData();
    // formData.append("file", $scope.form.inputfile);
     formData.append("version", $scope.form.version);
     formData.append("fileName", $scope.fileName);
     formData.append("bucketName", $scope.bucketName);
    $http.post(apiurl, formData, {
         transformRequest: angular.identity,
    headers: {
        'X-HMIS-TrustedApp-Id': 'MASTER_TRUSTED_APP',
          'Authorization': 'HMISUserAuth session_token='+$scope.sessionToken,
           'Content-Type': undefined
      } //TODO change accept to multipart.
     }).success(function () { success() }).error(error);

    },
    bulkuploadNew: function ($http, $scope,file,progress,success, error) {
        var apiurl = "/hmis-upload-service/rest/bulk-upload/"+$scope.form.version;
        var formData = new FormData();
        formData.append("file", file);
        $http.post(apiurl, formData, {
             transformRequest: angular.identity,
        headers: {
            'X-HMIS-TrustedApp-Id': 'MASTER_TRUSTED_APP',
              'Authorization': 'HMISUserAuth session_token='+$scope.sessionToken,
               'Content-Type': undefined
          } //TODO change accept to multipart.
         }).success(function () { success() }).error(error);

        },

//	GetOrganizations: function ($http, success) {
//        $http.get('/hmis-user-service/rest/accounts').success(function (data) {
//				if(success)success(data)
//			});
//    },
	GetRoles: function ($http,$scope, success) {
		  var apiurl = "/hmis-user-service/rest/roles?maxItems=10";
	        $http({
	            method: 'GET',
	            url: apiurl,
	            headers: {
	              'X-HMIS-TrustedApp-Id': 'MASTER_TRUSTED_APP',
	                'Authorization': 'HMISUserAuth session_token='+$scope.sessionToken,
	                'Accept': 'application/json;odata=verbose'}
	        }).success(function (data) {
	            if(success)success(data)
	        });
  },
	GetProfiles: function ($http,$scope, success) {
		  var apiurl = "/hmis-user-service/rest/profiles?maxItems=10";
		 $http.get(apiurl,{
	            headers: {
	              'X-HMIS-TrustedApp-Id': 'MASTER_TRUSTED_APP',
	                'Authorization': 'HMISUserAuth session_token='+$scope.sessionToken,
	                'Accept': 'application/json;odata=verbose'}
	        }).success(function (data) {
	            if(success)success(data)
	        });
},
GetProjectGroups: function ($http,$scope, success) {
	  var apiurl = "/hmis-user-service/rest/projectgroups?maxItems=100";
      $http({
          method: 'GET',
          cache:false,
          url: apiurl,
          headers: {
            'X-HMIS-TrustedApp-Id': 'MASTER_TRUSTED_APP',
              'Authorization': 'HMISUserAuth session_token='+$scope.sessionToken,
              'Accept': 'application/json;odata=verbose'}
      }).success(function (data) {
          if(success)success(data)
      });
},
GetEligReq: function ($http,$scope, success) {
	  var apiurl = "/inventory-api/rest/projects/eligibilityrequirements?page=0&size=100";
    $http({
        method: 'GET',
        data:'',
        cache:false,
        url: apiurl,
        headers: {
          'X-HMIS-TrustedApp-Id': 'MASTER_TRUSTED_APP',
            'Authorization': 'HMISUserAuth session_token='+$scope.sessionToken,
            'Accept': 'application/json;odata=verbose',
            'Content-Type': 'application/json'}
    }).success(function (data) {
        if(success)success(data)
    });
},
    createUser : function ($http, $scope, success, error) {
        var apiurl = "/hmis-user-service/rest/accounts";
        data = $scope.form;
        $http({
            method: 'POST',
            url: apiurl,
            data :
            	{ "account":{
                    "username": data.username,
                    "emailAddress":data.emailAddress,
                    "password":data.password,
                    "confirmPassword" : data.confirmPassword,
                    "firstName":data.firstName,
                    "middleName":data.middleName,
                    "lastName":data.lastName,
                    "role" : {
                    	"id": data.role.id
                    },
                    "projectGroup" : {
                    	projectGroupId : data.projectgroup.projectGroupId
                    },
                    "profile" : {
                    	"id" : data.profile.id
                    }
                 }
           },
            headers: {
              'X-HMIS-TrustedApp-Id': 'MASTER_TRUSTED_APP',
                'Authorization': 'HMISUserAuth session_token='+$scope.sessionToken,
                'Accept': 'application/json;odata=verbose'}
        }).success(function (data) {
            if(success)success(data)
        }).error(error);
        },
    createRole : function ($http, $scope, success, error) {
        var apiurl = "/hmis-user-service/rest/roles";

        data = $scope.form;
        $http({
            method: 'POST',
            url: apiurl,
            data :
            {
            	  "role":{
            	    "roleName":data.name,
            	    "roleDescription":data.desc
            	  }
           },
            headers: {
              'X-HMIS-TrustedApp-Id': 'MASTER_TRUSTED_APP',
                'Authorization': 'HMISUserAuth session_token='+$scope.sessionToken,
                'Accept': 'application/json;odata=verbose'}
        }).success(function (data) {
            if(success)success(data)
        }).error(error);
        },
    createProjectGroup: function ($http, $scope, success, error) {
    	console.warn($scope,2);
        var apiurl = "/hmis-user-service/rest/projectgroups";

        data = $scope.form;

        $http({
            method: 'POST',
            url: apiurl,
            data : {
              "projectGroup" : {
                "projectGroupName" : data.name,
                "projectGroupDesc" : data.desc,
                "skipuseridentifers" : data.skipuseridentifers
              }
            },
            headers: {
              'X-HMIS-TrustedApp-Id': 'MASTER_TRUSTED_APP',
                'Authorization': 'HMISUserAuth session_token='+$scope.sessionToken,
                'Accept': 'application/json;odata=verbose'}
        }).success(function (data) {
           if(success)success(data)
        }).error(error);
        },
    getToken: function ($http, $scope, success, error) {
        var apiurl = "/hmis-authorization-service/rest/token?grant_type=authorization_code&code="+$scope.authToken+"&redirect_uri=http://ec2-52-38-189-237.us-west-2.compute.amazonaws.com:8080/hmis-admin/#/admin/dashboard";
        $http({
            method: 'POST',
            url: apiurl,
            headers: {
            	'X-HMIS-TrustedApp-Id': 'MASTER_TRUSTED_APP',
                'authorization': 'Basic:TUFTVEVSX1RSVVNURURfQVBQOkhNSVM=',
                'Accept': 'application/json;odata=verbose'}
        }).success(function (data) {
            if(success)success(data)
        }).error(error);
        },
        _keyStr: "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=",
        encode: function(input) {
            var output = "";
            var chr1, chr2, chr3, enc1, enc2, enc3, enc4;
            var i = 0;

            input = _utf8_encode(input);

            while (i < input.length) {

                chr1 = input.charCodeAt(i++);
                chr2 = input.charCodeAt(i++);
                chr3 = input.charCodeAt(i++);

                enc1 = chr1 >> 2;
                enc2 = ((chr1 & 3) << 4) | (chr2 >> 4);
                enc3 = ((chr2 & 15) << 2) | (chr3 >> 6);
                enc4 = chr3 & 63;

                if (isNaN(chr2)) {
                    enc3 = enc4 = 64;
                } else if (isNaN(chr3)) {
                    enc4 = 64;
                }

                output = output + this._keyStr.charAt(enc1) + this._keyStr.charAt(enc2) + this._keyStr.charAt(enc3) + this._keyStr.charAt(enc4);

            }

            return output;
        },


        decode: function(input) {
            var output = "";
            var chr1, chr2, chr3;
            var enc1, enc2, enc3, enc4;
            var i = 0;

            input = input.replace(/[^A-Za-z0-9\+\/\=]/g, "");

            while (i < input.length) {

                enc1 = this._keyStr.indexOf(input.charAt(i++));
                enc2 = this._keyStr.indexOf(input.charAt(i++));
                enc3 = this._keyStr.indexOf(input.charAt(i++));
                enc4 = this._keyStr.indexOf(input.charAt(i++));

                chr1 = (enc1 << 2) | (enc2 >> 4);
                chr2 = ((enc2 & 15) << 4) | (enc3 >> 2);
                chr3 = ((enc3 & 3) << 6) | enc4;

                output = output + String.fromCharCode(chr1);

                if (enc3 != 64) {
                    output = output + String.fromCharCode(chr2);
                }
                if (enc4 != 64) {
                    output = output + String.fromCharCode(chr3);
                }

            }

            output = _utf8_decode(output);

            return output;

        },

        _utf8_encode: function(string) {
            string = string.replace(/\r\n/g, "\n");
            var utftext = "";

            for (var n = 0; n < string.length; n++) {

                var c = string.charCodeAt(n);

                if (c < 128) {
                    utftext += String.fromCharCode(c);
                }
                else if ((c > 127) && (c < 2048)) {
                    utftext += String.fromCharCode((c >> 6) | 192);
                    utftext += String.fromCharCode((c & 63) | 128);
                }
                else {
                    utftext += String.fromCharCode((c >> 12) | 224);
                    utftext += String.fromCharCode(((c >> 6) & 63) | 128);
                    utftext += String.fromCharCode((c & 63) | 128);
                }

            }

            return utftext;
        }

});
;

app.controller('bulkUploadCtrl',[ '$scope', '$location', '$routeSegment', '$http', '$timeout','$sessionStorage', function ($scope, $location, $routeSegment, $http, $timeout,$sessionStorage){
	$scope.sessionToken = $sessionStorage.sessionToken;
	if($sessionStorage.isLoggedIn){
		$("#userDetails").html($sessionStorage.account.emailAddress);	
	}
	var Base64={_keyStr:"ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=",encode:function(e){var t="";var n,r,i,s,o,u,a;var f=0;e=Base64._utf8_encode(e);while(f<e.length){n=e.charCodeAt(f++);r=e.charCodeAt(f++);i=e.charCodeAt(f++);s=n>>2;o=(n&3)<<4|r>>4;u=(r&15)<<2|i>>6;a=i&63;if(isNaN(r)){u=a=64}else if(isNaN(i)){a=64}t=t+this._keyStr.charAt(s)+this._keyStr.charAt(o)+this._keyStr.charAt(u)+this._keyStr.charAt(a)}return t},decode:function(e){var t="";var n,r,i;var s,o,u,a;var f=0;e=e.replace(/[^A-Za-z0-9+/=]/g,"");while(f<e.length){s=this._keyStr.indexOf(e.charAt(f++));o=this._keyStr.indexOf(e.charAt(f++));u=this._keyStr.indexOf(e.charAt(f++));a=this._keyStr.indexOf(e.charAt(f++));n=s<<2|o>>4;r=(o&15)<<4|u>>2;i=(u&3)<<6|a;t=t+String.fromCharCode(n);if(u!=64){t=t+String.fromCharCode(r)}if(a!=64){t=t+String.fromCharCode(i)}}t=Base64._utf8_decode(t);return t},_utf8_encode:function(e){e=e.replace(/rn/g,"n");var t="";for(var n=0;n<e.length;n++){var r=e.charCodeAt(n);if(r<128){t+=String.fromCharCode(r)}else if(r>127&&r<2048){t+=String.fromCharCode(r>>6|192);t+=String.fromCharCode(r&63|128)}else{t+=String.fromCharCode(r>>12|224);t+=String.fromCharCode(r>>6&63|128);t+=String.fromCharCode(r&63|128)}}return t},_utf8_decode:function(e){var t="";var n=0;var r=c1=c2=0;while(n<e.length){r=e.charCodeAt(n);if(r<128){t+=String.fromCharCode(r);n++}else if(r>191&&r<224){c2=e.charCodeAt(n+1);t+=String.fromCharCode((r&31)<<6|c2&63);n+=2}else{c2=e.charCodeAt(n+1);c3=e.charCodeAt(n+2);t+=String.fromCharCode((r&15)<<12|(c2&63)<<6|c3&63);n+=3}}return t}}
	// Define the string
	var aKey ='';
	var sKey ='';
	var reg = '';
   var region='';
   $http.get('./config.json').then(function (response) {
	    var app =  response.data;
        AWS.config.update({
            accessKeyId : Base64.decode(app.aKey),
            secretAccessKey : Base64.decode(app.sKey),
            region : Base64.decode(app.reg)
        });
	    });
    $scope.submitForm = function (file) {
    	$scope.projectGroupCode = $sessionStorage.account.projectGroup.projectGroupCode;
        $scope.infoTextAlert = "Please wait uploading....";
        $scope.showInfoAlert = true;
   $scope.showSuccessAlert = false;
     $scope.showErrorAlert = false;
     
  var bucket = new AWS.S3({params: {Bucket: $sessionStorage.account.projectGroup.bucketName.toLocaleLowerCase(),Prefix:'testfolder'}});
    var fileChooser = $("input[type='file'")[0];
    var file1 = fileChooser.files[0];
    if (file1) {
    var params = {Key: file1.name, ContentType: file1.type, Body: file1,xhrFields: {
      withCredentials: true }};
    bucket.upload(params).on('httpUploadProgress', function(evt) {
    console.log("Uploaded :: " + parseInt((evt.loaded * 100) / evt.total)+'%');
 
   $(".bg-info").html( "Please wait uploading.... " + parseInt((evt.loaded * 100) / evt.total)+'%');
        
     
 
    }).send(function(err, data) {
   // alert("File uploaded successfully.");
    	 if (err) {
    		 $scope.successTextAlert = "There was an error uploading your Hmis upload:"+ err.message;
    	      return false;
    	    }
        $scope.fileName = file1.name;
        $scope.bucketName = 'sdolia-2015';
      //  $scope.fileSize = file1.size;
        Service.bulkupload($http, $scope,file,
 //success
            function () {
                $scope.switchBool("showInfoAlert");
                $scope.successTextAlert = "File has been uploaded successfully.";
    $scope.showInfoAlert = false;
                $scope.showSuccessAlert = true;
    
    $location.path("/admin/managefiles");
            },
//error
       function () {
     $location.path("/admin/managefiles");
           $scope.switchBool("showInfoAlert");
           $scope.errorTextAlert = "Error, Something gone wrong.";
     $scope.showInfoAlert = false;
           $scope.showErrorAlert = true;
           
       })
    
 
    });
    }
        return false;
    }

    // switch flag
    $scope.switchBool = function (value) {
        $scope[value] = !$scope[value];
    };

}]);


;
app.controller('bulkUploadNewCtrl',[ '$scope', '$location', '$routeSegment', '$http', '$timeout','$sessionStorage', function ($scope, $location, $routeSegment, $http, $timeout,$sessionStorage){
	$scope.sessionToken = $sessionStorage.sessionToken;
	if($sessionStorage.isLoggedIn){
		$("#userDetails").html($sessionStorage.account.emailAddress);	
	}
	
    $scope.submitForm = function () {
        $scope.infoTextAlert = "Please wait uploading....";
        $scope.showInfoAlert = true;
        var file = $scope.form.inputfile;
        Service.bulkuploadNew($http, $scope,file,
  //progress
        	function(evt) {
        			   console.log('percent: ' + parseInt(100.0 * evt.loaded / evt.total));
        			   $scope.infoTextAlert = parseInt(100.0 * evt.loaded / evt.total);
        	 },
 //success
            function () {
                $scope.switchBool("showInfoAlert");
                $scope.successTextAlert = "File has been uploaded successfully.";
                $scope.showSuccessAlert = true;
				$location.path("/admin/managefiles");
            },
//error
       function () {
		//	   $location.path("/admin/managefiles");
           $scope.switchBool("showInfoAlert");
           $scope.errorTextAlert = "Error, Something gone wrong.";
           $scope.showErrorAlert = true;
           
       })
    }

    // switch flag
    $scope.switchBool = function (value) {
        $scope[value] = !$scope[value];
    };


}]);




;
app.controller('createorgCtrl',[ '$scope','$location','$routeSegment','$http', '$timeout','$sessionStorage', function($scope,$location,$routeSegment,$http, $timeout,$sessionStorage) {
	
	if($sessionStorage.isLoggedIn){
		$("#userDetails").html($sessionStorage.account.emailAddress);	
	}
	
	Service.GetProjectList($http,
    //success
    function(data){$scope.projects =data;  }),
											   
											   
  $scope.submitForm = function() {
	  
       Service.SendRequestReport($http,$scope,
    //success
    function(data){
	
		$scope.successTextAlert = "Your Requset has been sent successfully.";
		$scope.showSuccessAlert = true;
		$scope.form.email='';
		$scope.form.report='';
		$scope.form.year='';
		$scope.form.project='';
		

},
	//error
	function(){$scope.errorTextAlert = "Error, Something gone wrong.";
$scope.showErrorAlert = true;})
	
       
    };
	// switch flag
$scope.switchBool = function(value) {
   $scope[value] = !$scope[value];
};
}]);
;
app.controller('createprojgrpCtrl',['$scope','$location','$routeSegment','$http', '$timeout','$sessionStorage', function($scope,$location,$routeSegment,$http, $timeout,$sessionStorage) {
	$scope.sessionToken = $sessionStorage.sessionToken;
	if($sessionStorage.isLoggedIn){
		$("#userDetails").html($sessionStorage.account.emailAddress);	
	}
	
	Service.GetProjectList($http,	
    //success
    function(data){$scope.projects =data;  }),
											   
											   
  $scope.submitForm = function() {
	  
       Service.createProjectGroup($http,$scope,
    //success
    function(data){
	
		$scope.successTextAlert = "Your Requset has been sent successfully.";
		$scope.showSuccessAlert = true;
		$scope.form.name='';
		$scope.form.desc='';

},
	//error
	function(){$scope.errorTextAlert = "Error, Something gone wrong.";
$scope.showErrorAlert = true;})
	
       
    };
	// switch flag
$scope.switchBool = function(value) {
   $scope[value] = !$scope[value];
};
}]);
;
app.controller('createprojgrpCtrl',['$scope','$location','$routeSegment','$http', '$timeout','$sessionStorage', function($scope,$location,$routeSegment,$http, $timeout,$sessionStorage) {
	$scope.sessionToken = $sessionStorage.sessionToken;
	if($sessionStorage.isLoggedIn){
		$("#userDetails").html($sessionStorage.account.emailAddress);	
	}
	
	Service.GetProjectList($http,
    //success
    function(data){$scope.projects =data;  }),
											   
											   
  $scope.submitForm = function() {
	  
       Service.createProjectGroup($http,$scope,
    //success
    function(data){
	
		$scope.successTextAlert = "Your Requset has been sent successfully.";
		$scope.showSuccessAlert = true;
		$scope.form.name='';
		$scope.form.desc='';

},
	//error
	function(){$scope.errorTextAlert = "Error, Something gone wrong.";
$scope.showErrorAlert = true;})
	
       
    };
	// switch flag
$scope.switchBool = function(value) {
   $scope[value] = !$scope[value];
};
}]);
;
app.controller('createuserCtrl',['$scope','$location','$routeSegment','$http', '$timeout','$sessionStorage', function($scope,$location,$routeSegment,$http, $timeout,$sessionStorage) {
		
	$scope.sessionToken = $sessionStorage.sessionToken;
	if($sessionStorage.isLoggedIn){
		$("#userDetails").html($sessionStorage.account.emailAddress);	
	}
	
//	Service.GetOrganizations($http,
//		    //success
//		 function(data){$scope.organizations =data;  }),
    Service.GetProfiles($http,$scope,
		    //success
		 function(data){$scope.profiles =data.profiles.profile;  }),
	Service.GetRoles($http,$scope,
			//success
	 function(data){$scope.roles =data.roles.role;  }),
		    
	Service.GetProjectGroups($http,$scope,
    //success
    function(data){$scope.projectgroups =data.projectgroups.projectGroups;  }),
											   
											   
  $scope.submitForm = function() {
    	$scope.errorTextAlert= "";
    	$scope.showErrorAlert = false;
       Service.createUser($http,$scope,
    //success
    function(data){
	
		$scope.successTextAlert = "Your Requset has been sent successfully.";
		$scope.showSuccessAlert = true;
		$scope.form.firstName='';
		$scope.form.lastName ='';
		$scope.form.username ='';
		$scope.form.password ='';
		$scope.form.emailAddress ='';

},
	//error
	function(errors){
	$scope.errorTextAlert = errors.errors.error[0].message;
	$scope.showErrorAlert = true;
})
	
       
    };
	// switch flag
$scope.switchBool = function(value) {
   $scope[value] = !$scope[value];
};
}]);
;app.controller('dashboardCtrl',['$rootScope', '$scope', '$location', '$routeSegment', '$http', '$timeout', '$sessionStorage', function($rootScope, $scope, $location, $routeSegment, $http, $timeout, $sessionStorage) {
    $scope.authToken = ($location.search()).code;
    if($rootScope.roleName=="SUPERADMIN")
	{
		$(".dashboard").show();
	}
	else
	{
		$(".dashboard").hide();
	}
    //$scope.sessionToken= $window.localStorage.getItem('sessionToken');
    //$window.localStorage.setItem('authToken',$scope.authToken);
		var checkservice = function(){
    Service.CheckServiceAvailableBulkUpload($http,$scope,
        //success
        function(data) {
            $("#divBulkUpload .button-success").css("display", "inline");
        },
        //error
        function() {
            $("#divBulkUpload .button-error").css("display", "inline");
        })



    Service.CheckServiceAvailableUploadFile($http,$scope,
        //success
        function(data) {
            $("#divUploadFile .button-success").css("display", "inline");
        },
        //error
        function() {
            $("#divUploadFile .button-success").css("display", "inline");
        })


    Service.CheckServiceAvailableAuthenticate($http,$scope,
        //success
        function(data) {
            $("#divAuthenticate .button-success").css("display", "inline");
        },
        //error
        function() {
            $("#divAuthenticate .button-success").css("display", "inline");
        })




    Service.LoadStatistics($http,$scope,
        //success
        function(filesCollection) {
            $scope.managefiles = filesCollection;

        })
		}
	
	
    $sessionStorage.authToken = $scope.authToken;
	 var sessionToken = $sessionStorage.sessionToken;
    if (!sessionToken) {
        Service.getToken($http, $scope, //success
            function(data) {
                $sessionStorage.sessionToken = data.oAuthAuthorization.accessToken;
                $sessionStorage.expiresIn = data.oAuthAuthorization.expiresIn;
                $sessionStorage.tokenType = data.oAuthAuthorization.tokenType;
                $sessionStorage.isLoggedIn = true;
                $scope.sessionToken = data.oAuthAuthorization.accessToken;
                $scope.expiresIn = data.oAuthAuthorization.expiresIn;
                $scope.tokenType = data.oAuthAuthorization.tokenType;
                checkservice();
                Service.GetUserInfo($http, $scope, function(data) {
                        //$window.localStorage.setItem('account',data.account);
                        $sessionStorage.account = data.account;
                        $("#userDetails").html(data.account.emailAddress);
                        $rootScope.roleName = $sessionStorage.account.roles.role[0].roleName; // data.account.roles.role[0].roleName;
                        $sessionStorage.roleName = $sessionStorage.account.roles.role[0].roleName;
                        if($rootScope.roleName=="SUPERADMIN")
                		{
                			$(".dashboard").show();
                		}
                		else
                		{
                			$(".dashboard").hide();
                		}
						
                    },
                    function() {
                        if ($sessionStorage.isLoggedIn) {
                            $("#userDetails").html($sessionStorage.account.emailAddress);
                        } else {
                            $location.path('/login');//
                        }
                    });
                /*	Service.CheckServiceAvailableBulkUpload($http,$scope,
                        //success
                        function(data) {
                            $("#divBulkUpload .button-success").css("display", "inline");
                            $("#divBulkUpload .button-error").css("display", "none");
                        },
                        //error
                        function() {
                        	$("#divBulkUpload .button-success").css("display", "none");
                            $("#divBulkUpload .button-error").css("display", "inline");
                        });

                    Service.CheckServiceAvailableUploadFile($http,$scope,
                        //success
                        function(data) {
                            $("#divUploadFile .button-success").css("display", "inline");
                            $("#divUploadFile .button-success").css("display", "none");
                        },
                        //error
                        function() {
                            $("#divUploadFile .button-success").css("display", "inline");
                            $("#divUploadFile .button-success").css("display", "none");
                        });
                    Service.CheckServiceAvailableAuthenticate($http,$scope,
                        //success
                        function(data) {
                            $("#divAuthenticate .button-success").css("display", "inline");
                            $("#divAuthenticate .button-success").css("display", "none");
                        },
                        //error
                        function() {
                            $("#divAuthenticate .button-success").css("display", "inline");
                            $("#divAuthenticate .button-success").css("display", "none");
                        });
                    Service.LoadStatistics($http,$scope,
                        //success
                        function(filesCollection) {
                            $scope.managefiles = filesCollection;

                        }); */
                    if($rootScope.roleName=="SUPERADMIN")
            		{
            			$(".dashboard").show();
            		}
            		else
            		{
            			$(".dashboard").hide();
            		}            
                },
            //error
            function() {
            	
                if ($sessionStorage.isLoggedIn) {
                    $("#userDetails").html($sessionStorage.account.emailAddress);
                } else {
                    $location.path('/login');//
                }
            })
		if($rootScope.roleName=="SUPERADMIN")
		{
			$(".dashboard").show();
		}
		else
		{
			$(".dashboard").hide();
		}
    }
	else{
    $scope.sessionToken = $sessionStorage.sessionToken;
	checkservice();
	}

}]);;
app.controller('errormessageCtrl',['$scope', '$location', '$routeParams', '$routeSegment', '$http', '$timeout', '$sessionStorage', function ($scope, $location, $routeParams, $routeSegment, $http, $timeout, $sessionStorage) {
    if ($sessionStorage.isLoggedIn) {
        $("#userDetails").html($sessionStorage.account.emailAddress);
    }
    $scope.sessionToken = $sessionStorage.sessionToken;
    var routeParams = $routeParams.id;
    var params = routeParams.split("-");
    $scope.id= params[0];
    $scope.year= params[1];
    Service.GetErrorMessage($http,
    	    //success
    	    function (data) {
    	        $scope.listErrorMessage = data;
    	        $scope.currentPageErrorMessage = 1; //current page
    	        $scope.entryLimitErrorMessage = 10; //max no of items to display in a page
    	        $scope.filteredItemsErrorMessage = $scope.listErrorMessage.length; //Initially for no filter  
    	        $scope.totalItemsErrorMessage = $scope.listErrorMessage.length;
    	    }, $scope)

    $scope.setPageErrorMessage = function (pageNo) {
        $scope.currentPageErrorMessage = pageNo;
    };
   

 
}]);
;/* Login */
app.controller('validateLoginCtrl',['$scope','$location','$routeSegment', function($scope,$location,$routeSegment) {
	
  $scope.SubmitLogin = function() {

	if($scope.email=="admin@servinglynk.com" && $scope.password=="admin")
	{
		$location.path($routeSegment.getSegmentUrl('s2.dashboard')); 
	}
	else
	{
		alert("Invalid username & password");
	}

  };
}]);
;app.controller('logoutCtrl', ['$scope', '$location', '$routeSegment', '$http', '$timeout', '$sessionStorage', function ($scope, $location, $routeSegment, $http, $timeout, $sessionStorage) {
    if ($sessionStorage.isLoggedIn) {
        $("#userDetails").html($sessionStorage.account.emailAddress);
    }

    $scope.sessionToken = $sessionStorage.sessionToken;
    delete $sessionStorage.sessionToken;
    delete $sessionStorage.sessionToken;
    delete $sessionStorage.expiresIn;
    delete $sessionStorage.tokenType;
    delete $sessionStorage.authToken;
    delete $sessionStorage.isLoggedIn;
    delete $sessionStorage.account;

    Service.logout($http, $scope,
        //success
        //success
        function () {
            //$window.localStorage.

        },
        //error
        function () {
        });
    // switch flag
    $scope.switchBool = function (value) {
        $scope[value] = !$scope[value];
    };
}]);
;
app.controller('manageeligreqCtrl',['$scope','$location','$routeSegment','$http', '$timeout','$modal', '$sessionStorage', function($scope,$location,$routeSegment,$http, $timeout,$modal, $sessionStorage) {
	if($sessionStorage.isLoggedIn){
		$("#userDetails").html($sessionStorage.account.emailAddress);	
	}
	
	$scope.sessionToken = $sessionStorage.sessionToken;
    Service.GetEligReq($http,$scope,
    //success
    function(data){
       $scope.list = data.content;
        $scope.currentPage = 1; //current page
        $scope.entryLimit = 10; //max no of items to display in a page
        $scope.filteredItems = $scope.list.length; //Initially for no filter  
        $scope.totalItems = $scope.list.length;
    },function(error) {})
  
    $scope.setPage = function (pageNo) {
        $scope.currentPage = pageNo;
    };
    
    $scope.viewRequirements = function (data) {
//success
    var modalInstance = $modal.open({
        templateUrl: 'templates/partial/vieweligreq.html',
        controller: 'viewEligReqCtrl',
        resolve: {
            datajson: function () {
                return data.requirements;
            }
        }
    });
};

}]);

app.controller('viewEligReqCtrl',['$scope', '$location', '$routeSegment', '$http', '$timeout', 'datajson', function ($scope, $location, $routeSegment, $http, $timeout, datajson) {
    $scope.datajson = datajson;
}]);
;/* Login */
app.filter('startFrom', function() {
    return function(input, start) {
        if(input) {
            start = +start; //parse to int
            return input.slice(start);
        }
        return [];
    }
});

app.controller('ModalInstanceLogCtrl',['$scope', '$location', '$routeSegment', '$http', '$timeout', 'datajson', function ($scope, $location, $routeSegment, $http, $timeout, datajson) {
    $scope.datajson = datajson;
}]);

app.controller('managefilesCtrl',['$scope','$location','$routeSegment','$http', '$timeout','$modal', '$sessionStorage', function($scope,$location,$routeSegment,$http, $timeout,$modal, $sessionStorage) {
	if($sessionStorage.isLoggedIn){
		$("#userDetails").html($sessionStorage.account.emailAddress);	
	}
	$scope.sessionToken = $sessionStorage.sessionToken;
    Service.GetFilesListRECENT($http,
    	    //success
    	    function(data){
    	        $scope.listRECENT = data;
    	        $scope.currentPageRECENT = 1; //current page
    	        $scope.entryLimitRECENT = 10; //max no of items to display in a page
    	        $scope.filteredItemsRECENT = $scope.listRECENT.length; //Initially for no filter  
    	        $scope.totalItemsRECENT = $scope.listRECENT.length;
    	    },$scope)
    	  
    	    $scope.setPageRECENT = function (pageNo) {
    	        $scope.currentPageRECENT = pageNo;
    	    };
    Service.GetFilesListSTAGING($http,
    //success
    function(data){
        $scope.listSTAGING = data;
        $scope.currentPageSTAGING = 1; //current page
        $scope.entryLimitSTAGING = 10; //max no of items to display in a page
        $scope.filteredItemsSTAGING = $scope.listSTAGING.length; //Initially for no filter  
        $scope.totalItemsSTAGING = $scope.listSTAGING.length;
    },$scope)
  
    $scope.setPageSTAGING = function (pageNo) {
        $scope.currentPageSTAGING = pageNo;
    };

    Service.GetFilesListLIVE($http,
   //success
   function (data) {
       $scope.listLIVE = data;
       $scope.currentPageLIVE = 1; //current page
       $scope.entryLimitLIVE = 10; //max no of items to display in a page
       $scope.filteredItemsLIVE = $scope.listLIVE.length; //Initially for no filter  
       $scope.totalItemsLIVE = $scope.listLIVE.length;
   },$scope)

    $scope.setPageLIVE = function (pageNo) {
        $scope.currentPageLIVE = pageNo;
    };

    Service.GetFilesListERROR($http,
  //success
  function (data) {
      $scope.listERROR = data;
      $scope.currentPageERROR = 1; //current page
      $scope.entryLimitERROR = 10; //max no of items to display in a page
      $scope.filteredItemsERROR = $scope.listERROR.length; //Initially for no filter  
      $scope.totalItemsERROR = $scope.listERROR.length;
  },$scope)

    $scope.setPageERROR = function (pageNo) {
        $scope.currentPageERROR = pageNo;
    };
   
    Service.GetFilesListDELETED($http,
    		  //success
    		  function (data) {
    		      $scope.listDELETED = data;
    		      $scope.currentPageDELETED = 1; //current page
    		      $scope.entryLimitDELETED = 10; //max no of items to display in a page
    		      $scope.filteredItemsDELETED = $scope.listDELETED.length; //Initially for no filter  
    		      $scope.totalItemsDELETED = $scope.listDELETED.length;
    		  },$scope)

    		    $scope.setPageDELETED = function (pageNo) {
    		        $scope.currentPageDELETED = pageNo;
    		    };
    
    		    $scope.openlog = function (id,year) {
    		        $scope.idForLog = id
    		        $scope.year = year;
    		Service.GetFilesLogList($http,
            //success
            function (data) {
                var modalInstance = $modal.open({
                    templateUrl: 'templates/partial/syncfilelogpopopup.html',
                    controller: 'ModalInstanceLogCtrl',
                    resolve: {
                        'datajson': function () {
                            return data.bulkUploadActivities.bulkUploadActivities;
                        }
                    }
                });

            }, $scope)


      };
}]);
;
app.controller('manageprojgrpCtrl',['$scope','$location','$routeSegment','$http', '$timeout', '$sessionStorage', function($scope,$location,$routeSegment,$http, $timeout, $sessionStorage) {
	if($sessionStorage.isLoggedIn){
		$("#userDetails").html($sessionStorage.account.emailAddress);	
	}
	
	$scope.sessionToken = $sessionStorage.sessionToken;
    Service.GetProjectGroups($http,$scope,
    //success
    function(data){
       $scope.list = data.projectgroups.projectGroups;
        $scope.currentPage = 1; //current page
        $scope.entryLimit = 10; //max no of items to display in a page
        $scope.filteredItems = $scope.list.length; //Initially for no filter  
        $scope.totalItems = $scope.list.length;
    },function(error) {})
  
    $scope.setPage = function (pageNo) {
        $scope.currentPage = pageNo;
    };


}]);
;
app.controller('managereportCtrl',['$scope','$location','$routeSegment','$http','$modal', '$timeout', '$sessionStorage', function($scope,$location,$routeSegment,$http,$modal,$timeout, $sessionStorage) {
	if($sessionStorage.isLoggedIn){
		$("#userDetails").html($sessionStorage.account.emailAddress);	
	}
	$scope.sessionToken = $sessionStorage.sessionToken;
    Service.GetReports($http,
    //success
    function(data){
       $scope.list = data;
        $scope.currentPage = 1; //current page
        $scope.entryLimit = 10; //max no of items to display in a page
        $scope.filteredItems = $scope.list.length; //Initially for no filter  
        $scope.totalItems = $scope.list.length;
    },$scope)
  
    $scope.setPage = function (pageNo) {
        $scope.currentPage = pageNo;
    };

    $scope.openlog =  function (projectIds) {
        $scope.projectIds = projectIds;
       console.log('Projects'+projectIds);
       var modalInstance = $modal.open({
            templateUrl: 'templates/partial/reportprojectspopopup.html',
            controller: 'ModalInstanceLogCtrl',
            resolve: {
                'datajson': function () {
                    return projectIds;
                }
            }
        });
    }
    

}]);


app.controller('ModalInstanceLogCtrl',['$scope', '$location', '$routeSegment', '$http', '$timeout', 'datajson', function ($scope, $location, $routeSegment, $http, $timeout, datajson) {
    $scope.datajson = datajson;
}]);
;app.controller('ModalInstanceCtrl',['$scope','$location','$routeSegment','$http', '$timeout','datajson', function($scope,$location,$routeSegment,$http, $timeout,datajson) {
	 $scope.datajson =datajson;
}]);
app.controller('managesyncCtrl',['$scope','$location','$routeSegment','$http', '$timeout','$modal','$sessionStorage', function($scope,$location,$routeSegment,$http, $timeout,$modal, $sessionStorage) {
	if($sessionStorage.isLoggedIn){
		$("#userDetails").html($sessionStorage.account.emailAddress);	
	}
	
    Service.GetSyncFilesList($http,
    //success
    function(data){
        $scope.listSTAGING = data;
        $scope.currentPageSTAGING = 1; //current page
        $scope.entryLimitSTAGING = 10; //max no of items to display in a page
        $scope.filteredItemsSTAGING = $scope.listSTAGING.length; //Initially for no filter  
        $scope.totalItemsSTAGING = $scope.listSTAGING.length;
    })
  
    $scope.setPageSTAGING = function (pageNo) {
        $scope.currentPageSTAGING = pageNo;
    };
	
												   
  $scope.openModel = function(data) {
	
	  var modalInstance = $modal.open({
      templateUrl: 'templates/partial/syncpopopup.html',
      controller: 'ModalInstanceCtrl',
    resolve: {
        datajson: function () {
		
		return	 data.json.replace("}", "").replace("{", "").split(',');
	     
        }
      }
    });

  
       
    };

  
}]);

;
app.controller('manageuserCtrl',['$scope','$location','$routeSegment','$http', '$timeout', '$sessionStorage', function($scope,$location,$routeSegment,$http, $timeout, $sessionStorage) {
	$scope.sessionToken = $sessionStorage.sessionToken;
	if($sessionStorage.isLoggedIn){
		$("#userDetails").html($sessionStorage.account.emailAddress);	
	}
	
    Service.GetUserByOrganization($http,$scope,
    //success
    function(data){
       $scope.list = data.account;
        $scope.currentPage = 1; //current page
        $scope.entryLimit = 10; //max no of items to display in a page
        $scope.filteredItems = $scope.list.length; //Initially for no filter  
        $scope.totalItems = $scope.list.length;
    },function(error) {})
  
    $scope.setPage = function (pageNo) {
        $scope.currentPage = pageNo;
    };


}]);
;app.controller('onboardfellowCtrl',['$scope', '$location', '$routeSegment', '$http', '$timeout', '$sessionStorage', function($scope, $location, $routeSegment, $http, $timeout, $sessionStorage) {

    if ($sessionStorage.isLoggedIn) {
        $("#userDetails").html($sessionStorage.account.emailAddress);
    }
    $scope.sessionToken = $sessionStorage.sessionToken;

}]);

app.controller('onboardfellowgroupCtrl',['$scope', '$location', '$routeSegment', '$http', '$timeout', '$sessionStorage', function($scope, $location, $routeSegment, $http, $timeout, $sessionStorage) {
    $("#createUser").removeClass("active");
    $("#createGroup").addClass("active");

    $scope.sessionToken = $sessionStorage.sessionToken;
    $scope.submitForm = function() {
        Service.createProjectGroup($http, $scope,
            //success
            function(data) {

                $scope.successTextAlert = "Your Requset has been sent successfully.";
                $scope.showSuccessAlert = true;
                $scope.form.name = '';
                $scope.form.desc = '';
                $location.path("/admin/onboardfellowuser");

            },
            //error
            function() {
                $scope.errorTextAlert = "Error, Something gone wrong.";
                $scope.showErrorAlert = true;
            })


    };
    // switch flag
    $scope.switchBool = function(value) {
        $scope[value] = !$scope[value];
    };

}]);
app.controller('onboardfellowuserCtrl',['$rootScope','$scope', '$location', '$routeSegment', '$http', '$timeout', '$sessionStorage', function($rootScope,$scope, $location, $routeSegment, $http, $timeout, $sessionStorage) {
    $("#createGroup").removeClass("active");
    $("#createUser").addClass("active");
    $scope.sessionToken = $sessionStorage.sessionToken;
    Service.GetProfiles($http, $scope,
            //success
            function(data) {
                $scope.profiles = data.profiles.profile;
            }),
        Service.GetRoles($http, $scope,
            //success
            function(data) {
        	var _tempArr = [];
        	for(var i=0;i<data.roles.role.length;i++)
            {
        	
        		if($rootScope.roleName!="SUPERADMIN" && data.roles.role[i].roleName=='SUPERADMIN'){
        			
        		}
        		else
        		{
        			_tempArr.push(data.roles.role[i]);
        		}
        		
            }
        	$scope.roles =_tempArr; //data.roles.role;
            }),

        Service.GetProjectGroups($http, $scope,
            //success
            function(data) {
                $scope.projectgroups = data.projectgroups.projectGroups;
            }),


        $scope.prev = function() {
			
            $location.path("/admin/onboardfellowgroup");
        }


    $scope.submitForm = function() {
        $scope.errorTextAlert = "";
        $scope.showErrorAlert = false;
        Service.createUser($http, $scope,
            //success
            function(data) {

                $scope.successTextAlert = "Your Requset has been sent successfully.";
                $scope.showSuccessAlert = true;
                $scope.form.firstName = '';
                $scope.form.lastName = '';
                $scope.form.username = '';
                $scope.form.password = '';
                $scope.form.emailAddress = '';
                $scope.form.gender = '';
                $location.path("/admin/manageuser");
            },
            //error
            function(errors) {
                $scope.errorTextAlert = errors.errors.error[0].message;
                $scope.showErrorAlert = true;
            })


    };
    // switch flag
    $scope.switchBool = function(value) {
        $scope[value] = !$scope[value];
    };
}]);;
app.controller('requestreportCtrl',['$scope','$location','$routeSegment','$http', '$timeout', '$sessionStorage', function($scope,$location,$routeSegment,$http, $timeout, $sessionStorage) {
	if($sessionStorage.isLoggedIn){
		$("#userDetails").html($sessionStorage.account.emailAddress);	
	}
	$scope.sessionToken = $sessionStorage.sessionToken;								 
	Service.GetProjectList($http,
    //success
    function(data){$scope.projects =data;  },//error
	function(){$scope.errorTextAlert = "Error, Something gone wrong with getting projects.";
	$scope.showErrorAlert = true;},
	$scope)
											   
											   
  $scope.submitForm = function() {
	  
       Service.SendRequestReport($http,$scope,
    //success
    function(data){
	
		$scope.successTextAlert = "Your Requset has been sent successfully.";
		$scope.showSuccessAlert = true;
		$scope.form.name='';
		$scope.form.reportLevel='';
		$scope.form.reportType='';
		$scope.form.startDate='';
		$scope.form.endDate='';
		$scope.form.project=[];
		

},
	//error
	function(){$scope.errorTextAlert = "Error, Something gone wrong.";
$scope.showErrorAlert = true;})
	
       
    };
	// switch flag
$scope.switchBool = function(value) {
   $scope[value] = !$scope[value];
};
}]);
;
app.controller('settingCtrl',['$scope','$location','$routeSegment','$http', '$timeout', '$sessionStorage', function($scope,$location,$routeSegment,$http, $timeout, $sessionStorage) {
	if($sessionStorage.isLoggedIn){
		$scope.sessionToken = $sessionStorage.sessionToken;	
		$("#userDetails").html($sessionStorage.account.emailAddress);	

		$scope.emailAddress=$sessionStorage.account.emailAddress;
		$scope.username=$sessionStorage.account.emailAddress;
		$scope.role=$sessionStorage.account.roles.role[0].roleName;
		$scope.firstName=$sessionStorage.account.firstName;
		$scope.lastName=$sessionStorage.account.lastName;
		$scope.accountId=$sessionStorage.account.accountId;

		
	}
	
	 
  $scope.submitForm = function() {
	  test = $scope;
       Service.SaveSetting($http,$scope,
    //success
    function(data){$scope.successTextAlert = "Setting has been updated successfully.";
$scope.showSuccessAlert = true;},
	//error
	function(){$scope.errorTextAlert = "Error, Something gone wrong.";
$scope.showErrorAlert = true;})
	
       
    };
    
    $scope.submitHivePasswordForm = function() {
  	  test = $scope;
         Service.updateHivePassword($http,$scope,
      //success
      function(data){$scope.successTextAlert = "Setting has been updated successfully.";
  $scope.showSuccessAlert = true;},
  	//error
  	function(){$scope.errorTextAlert = "Error, Something gone wrong.";
  $scope.showErrorAlert = true;})
  	
         
      };
	// switch flag
$scope.switchBool = function(value) {
   $scope[value] = !$scope[value];
};
}]);
;(function () {
    'use strict';

    angular
        .module('app')
        .factory('AuthenticationService', AuthenticationService);

    AuthenticationService.$inject = ['$http', '$cookieStore', '$rootScope', '$timeout', 'UserService'];
    function AuthenticationService($http, $cookieStore, $rootScope, $timeout, UserService) {
        var service = {};

        service.Login = Login;
        service.SetCredentials = SetCredentials;
        service.ClearCredentials = ClearCredentials;

        return service;

        function Login(username, password, callback) {

            /* Dummy authentication for testing, uses $timeout to simulate api call
             ----------------------------------------------*/
            $timeout(function () {
                var response;
                UserService.GetByUsername(username)
                    .then(function (user) {
                        if (user !== null && user.password === password) {
                            response = { success: true };
                        } else {
                            response = { success: false, message: 'Username or password is incorrect' };
                        }
                        callback(response);
                    });
            }, 1000);

            /* Use this for real authentication
             ----------------------------------------------*/
            //$http.post('/api/authenticate', { username: username, password: password })
            //    .success(function (response) {
            //        callback(response);
            //    });

        }

        function SetCredentials(username, password) {
            var authdata = Base64.encode(username + ':' + password);

            $rootScope.globals = {
                currentUser: {
                    username: username,
                    authdata: authdata
                }
            };

            $http.defaults.headers.common['Authorization'] = 'Basic ' + authdata; // jshint ignore:line
            $cookieStore.put('globals', $rootScope.globals);
        }

        function ClearCredentials() {
            $rootScope.globals = {};
            $cookieStore.remove('globals');
            $http.defaults.headers.common.Authorization = 'Basic ';
        }
    }

    // Base64 encoding service used by AuthenticationService
    var Base64 = {

        keyStr: 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=',

        encode: function (input) {
            var output = "";
            var chr1, chr2, chr3 = "";
            var enc1, enc2, enc3, enc4 = "";
            var i = 0;

            do {
                chr1 = input.charCodeAt(i++);
                chr2 = input.charCodeAt(i++);
                chr3 = input.charCodeAt(i++);

                enc1 = chr1 >> 2;
                enc2 = ((chr1 & 3) << 4) | (chr2 >> 4);
                enc3 = ((chr2 & 15) << 2) | (chr3 >> 6);
                enc4 = chr3 & 63;

                if (isNaN(chr2)) {
                    enc3 = enc4 = 64;
                } else if (isNaN(chr3)) {
                    enc4 = 64;
                }

                output = output +
                    this.keyStr.charAt(enc1) +
                    this.keyStr.charAt(enc2) +
                    this.keyStr.charAt(enc3) +
                    this.keyStr.charAt(enc4);
                chr1 = chr2 = chr3 = "";
                enc1 = enc2 = enc3 = enc4 = "";
            } while (i < input.length);

            return output;
        },

        decode: function (input) {
            var output = "";
            var chr1, chr2, chr3 = "";
            var enc1, enc2, enc3, enc4 = "";
            var i = 0;

            // remove all characters that are not A-Z, a-z, 0-9, +, /, or =
            var base64test = /[^A-Za-z0-9\+\/\=]/g;
            if (base64test.exec(input)) {
                window.alert("There were invalid base64 characters in the input text.\n" +
                    "Valid base64 characters are A-Z, a-z, 0-9, '+', '/',and '='\n" +
                    "Expect errors in decoding.");
            }
            input = input.replace(/[^A-Za-z0-9\+\/\=]/g, "");

            do {
                enc1 = this.keyStr.indexOf(input.charAt(i++));
                enc2 = this.keyStr.indexOf(input.charAt(i++));
                enc3 = this.keyStr.indexOf(input.charAt(i++));
                enc4 = this.keyStr.indexOf(input.charAt(i++));

                chr1 = (enc1 << 2) | (enc2 >> 4);
                chr2 = ((enc2 & 15) << 4) | (enc3 >> 2);
                chr3 = ((enc3 & 3) << 6) | enc4;

                output = output + String.fromCharCode(chr1);

                if (enc3 != 64) {
                    output = output + String.fromCharCode(chr2);
                }
                if (enc4 != 64) {
                    output = output + String.fromCharCode(chr3);
                }

                chr1 = chr2 = chr3 = "";
                enc1 = enc2 = enc3 = enc4 = "";

            } while (i < input.length);

            return output;
        }
    };

})();;(function () {
    'use strict';

    angular
        .module('app')
        .factory('FlashService', FlashService);

    FlashService.$inject = ['$rootScope'];
    function FlashService($rootScope) {
        var service = {};

        service.Success = Success;
        service.Error = Error;

        initService();

        return service;

        function initService() {
            $rootScope.$on('$locationChangeStart', function () {
                clearFlashMessage();
            });

            function clearFlashMessage() {
                var flash = $rootScope.flash;
                if (flash) {
                    if (!flash.keepAfterLocationChange) {
                        delete $rootScope.flash;
                    } else {
                        // only keep for a single location change
                        flash.keepAfterLocationChange = false;
                    }
                }
            }
        }

        function Success(message, keepAfterLocationChange) {
            $rootScope.flash = {
                message: message,
                type: 'success', 
                keepAfterLocationChange: keepAfterLocationChange
            };
        }

        function Error(message, keepAfterLocationChange) {
            $rootScope.flash = {
                message: message,
                type: 'error',
                keepAfterLocationChange: keepAfterLocationChange
            };
        }
    }

})();;(function () {
    'use strict';

    angular
        .module('app')
        .factory('UserService', UserService);

    UserService.$inject = ['$http'];
    function UserService($http) {
        var service = {};

        service.GetAll = GetAll;
        service.GetById = GetById;
        service.GetByUsername = GetByUsername;
        service.Create = Create;
        service.Update = Update;
        service.Delete = Delete;

        return service;

        function GetAll() {
            return $http.get('/api/users').then(handleSuccess, handleError('Error getting all users'));
        }

        function GetById(id) {
            return $http.get('/api/users/' + id).then(handleSuccess, handleError('Error getting user by id'));
        }

        function GetByUsername(username) {
            return $http.get('/api/users/' + username).then(handleSuccess, handleError('Error getting user by username'));
        }

        function Create(user) {
            return $http.post('/api/users', user).then(handleSuccess, handleError('Error creating user'));
        }

        function Update(user) {
            return $http.put('/api/users/' + user.id, user).then(handleSuccess, handleError('Error updating user'));
        }

//        function Delete(id) {
//            return $http.delete('/api/users/' + id).then(handleSuccess, handleError('Error deleting user'));
//        }

        // private functions

        function handleSuccess(data) {
            return data;
        }

        function handleError(error) {
            return function () {
                return { success: false, message: error };
            };
        }
    }

})();
;(function () {
    'use strict';

    angular
        .module('app')
        .factory('UserService', UserService);

    UserService.$inject = ['$timeout', '$filter', '$q'];
    function UserService($timeout, $filter, $q) {

        var service = {};

        service.GetAll = GetAll;
        service.GetById = GetById;
        service.GetByUsername = GetByUsername;
        service.Create = Create;
        service.Update = Update;
        service.Delete = Delete;

        return service;

        function GetAll() {
            var deferred = $q.defer();
            deferred.resolve(getUsers());
            return deferred.promise;
        }

        function GetById(id) {
            var deferred = $q.defer();
            var filtered = $filter('filter')(getUsers(), { id: id });
            var user = filtered.length ? filtered[0] : null;
            deferred.resolve(user);
            return deferred.promise;
        }

        function GetByUsername(username) {
            var deferred = $q.defer();
            var filtered = $filter('filter')(getUsers(), { username: username });
            var user = filtered.length ? filtered[0] : null;
            deferred.resolve(user);
            return deferred.promise;
        }

        function Create(user) {
            var deferred = $q.defer();

            // simulate api call with $timeout
            $timeout(function () {
                GetByUsername(user.username)
                    .then(function (duplicateUser) {
                        if (duplicateUser !== null) {
                            deferred.resolve({ success: false, message: 'Username "' + user.username + '" is already taken' });
                        } else {
                            var users = getUsers();

                            // assign id
                            var lastUser = users[users.length - 1] || { id: 0 };
                            user.id = lastUser.id + 1;

                            // save to local storage
                            users.push(user);
                            setUsers(users);

                            deferred.resolve({ success: true });
                        }
                    });
            }, 1000);

            return deferred.promise;
        }

        function Update(user) {
            var deferred = $q.defer();

            var users = getUsers();
            for (var i = 0; i < users.length; i++) {
                if (users[i].id === user.id) {
                    users[i] = user;
                    break;
                }
            }
            setUsers(users);
            deferred.resolve();

            return deferred.promise;
        }

        function Delete(id) {
            var deferred = $q.defer();

            var users = getUsers();
            for (var i = 0; i < users.length; i++) {
                var user = users[i];
                if (user.id === id) {
                    users.splice(i, 1);
                    break;
                }
            }
            setUsers(users);
            deferred.resolve();

            return deferred.promise;
        }

        // private functions

        function getUsers() {
            if(!localStorage.users){
                localStorage.users = JSON.stringify([]);
            }

            return JSON.parse(localStorage.users);
        }

        function setUsers(users) {
            localStorage.users = JSON.stringify(users);
        }
    }
})();