var filesCollection="";
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
        var apiurl = "/hmis-clientapi-v2017/rest/v2/projects?maxItems=200";
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
  DownloadPDF: function ($http,$scope, success, error) {
          var apiurl = "/hmis-report-service/rest/reports/download/"+$scope.downloadId+"/pdf";
        $http({
            method: 'POST',
            url: apiurl,
            responseType :'arraybuffer',
            headers: {
              'X-HMIS-TrustedApp-Id': 'MASTER_TRUSTED_APP',
                'Authorization': 'HMISUserAuth session_token='+$scope.sessionToken,
                'Accept': 'application/json;odata=verbose'
                }
      }).success(function (data, status, headers) {
          headers = headers();
          
          var filename = headers['x-filename'];
          var contentType = headers['content-type'];
   
          var linkElement = document.createElement('a');
          try {
              var blob = new Blob([data], { type: contentType });
              var url = window.URL.createObjectURL(blob);
   
              linkElement.setAttribute('href', url);
              linkElement.setAttribute("download", filename);
   
              var clickEvent = new MouseEvent("click", {
                  "view": window,
                  "bubbles": true,
                  "cancelable": false
              });
              linkElement.dispatchEvent(clickEvent);
          } catch (ex) {
              console.log(ex);
          }
      }).error(function (data) {
          console.log(data);
      });
  },
  DownloadZIP: function ($http,$scope, success, error) {
  	  var apiurl = "/hmis-report-service/rest/reports/download/"+$scope.downloadId+"/zip";
        $http({
            method: 'POST',
            url: apiurl,
            headers: {
              'X-HMIS-TrustedApp-Id': 'MASTER_TRUSTED_APP',
                'Authorization': 'HMISUserAuth session_token='+$scope.sessionToken,
                'Accept': 'application/json;odata=verbose',
                'Content-Type' : 'application/zip'}
        }).success(function (data, status, headers) {
            headers = headers();
            
            var fileName = headers['x-filename'];
            var contentType = headers['content-Type'];
     
            var a = document.createElement("a");
            document.body.appendChild(a);
            a.style = "display: none";
            var blob = new Blob([data], {type: "application/zip"}),
                    url = window.URL.createObjectURL(blob);
                a.href = url;
                a.download = name;
                a.click();
                window.URL.revokeObjectURL(url);
        });
  },
  DownloadExportZIP: function ($http,$scope, success, error) {
  	  
  	var apiurl = "/hmis-report-service/rest/reports/download/"+$scope.exportId+"/zip";
    $http({
        method: 'POST',
        url: apiurl,
        headers: {
          'X-HMIS-TrustedApp-Id': 'MASTER_TRUSTED_APP',
            'Authorization': 'HMISUserAuth session_token='+$scope.sessionToken,
            'Accept': 'application/json;odata=verbose',
            'Content-Type' : 'application/zip'}
    }).success(function (data, status, headers) {
    	headers = headers();

        var filename = headers['x-filename'];
        var contentType = headers['content-type'];

        var linkElement = document.createElement('a');
        try {
            var blob = new Blob([data], { type: "application/zip" });
            var url = window.URL.createObjectURL(blob);

            linkElement.setAttribute('href', url);
            linkElement.setAttribute("download", filename);

            var clickEvent = new MouseEvent("click", {
                "view": window,
                "bubbles": true,
                "cancelable": false
            });
            linkElement.dispatchEvent(clickEvent);
        } catch (ex) {
            console.log(ex);
        }
    }).error(function (data) {
        console.log(data);
    });
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
    GetExports: function ($http, success,$scope) {
        var apiurl = "/hmis-report-service/rest/export";
        $http({
            method: 'GET',
            url: apiurl,
            headers: {
              'X-HMIS-TrustedApp-Id': 'MASTER_TRUSTED_APP',
                'Authorization': 'HMISUserAuth session_token='+$scope.sessionToken,
                'Accept': 'application/json;odata=verbose'}
        }).success(function (data) {
            if(success)success(data.FileExports.fileExports)
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
MergeClient: function ($http,$scope, success,error) {
	data =$scope.form;
     var apiurl = "/hmis-globalapi/rest/clients/"+data.clientId+"/dedup/merge";
     data = $scope.form;
     $http({
         method: 'POST',
         url: apiurl,
         data :
         	{ "client":{
                 "firstName": data.firstName,
                 "lastName": data.lastName,
                 "ssn": data.ssn,
                 "dob":data.dob
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
UnMergeClient: function ($http,$scope, success,error) {
	data =$scope.form;
	var apiurl = "/hmis-globalapi/rest/clients/"+data.clientId+"/dedup/unmerge";
     data = $scope.form;
     $http({
         method: 'POST',
         url: apiurl,
         data :
         	{ "client":{
                 "firstName": data.firstName,
                 "lastName": data.lastName,
                 "ssn": data.ssn,
                 "dob":data.dob
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
Events: function ($http,$scope,data, success,error) {
	var apiurl = "/hmis-globalapi/rest/events";
     $http({
         method: 'POST',
         url: apiurl,
         data :
         	{
         		  "event": {
         			    "payload": {
         			      "projectGroupCode": data.projectGroupCode,
         			      "clientId": data.clientId,
         			      "targetDedupId": data.dedupClientId
         			    },
         			    "eventType": data.eventType
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
SendRequestExport: function ($http,$scope, success,error) {
	data =$scope.form;
     var apiurl = "/hmis-report-service/rest/export";
     data = $scope.form;
     $http({
         method: 'POST',
         url: apiurl,
         data :
         	{ "fileExport":{
                 "name": data.name,
                 "startDate":data.startDate,
                 "endDate":data.endDate,
                 "exportType" : data.reportType,
                 "exportLevel":data.reportLevel,
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
	getAccountById : function ($http, $scope, success, error) {
            var apiurl = "/hmis-user-service/rest/accounts/"+$scope.accountId;
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
    updateAccountPassword : function ($http, $scope, success, error) {
        var apiurl = "/hmis-user-service/rest/accounts/"+$scope.username+"/passwordupdate";
        data = $scope.form;
        $http({
            method: 'PUT',
            url: apiurl,
            data :
            	{ "passwordChange":{
                    "newPassword": data.newPassword,
                    "confirmNewPassword":data.confirmNewPassword
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
