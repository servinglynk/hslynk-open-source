var filesCollection="";
var Service= ({
	GetProjectList: function ($http, success) {
        $http.get('/hmis-bulk-loader/mapper/projects').success(function (data) {
				if(success)success(data)
			});
    },
    GetUserInfo: function ($http,$scope, success, error) {
  	  var apiurl = "/hmis-user-service/rest/accounts/self/basicinfo";
  	 console.log('Session Token..'+$scope.sessionToken);
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
   	 console.log('Session Token..'+$scope.sessionToken);
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
    GetReports: function ($http, success) {
	
        $http.get('/hmis-bulk-loader/mapper/getReportMaster').success(function (data) {
				if(success)success(data)
			});
    },
    GetFilesListSTAGING: function ($http, success) {
        $http.get('/hmis-bulk-loader/bulkupload?status=STAGING').success(function (data) {
				if(success)success(data)
			});
    },
    GetFilesListLIVE: function ($http, success) {
        $http.get('/hmis-bulk-loader/bulkupload?status=LIVE').success(function (data) {
            if(success)success(data)
        });
    },
    GetFilesListERROR: function ($http, success) {
        $http.get('/hmis-bulk-loader/bulkupload?status=ERROR').success(function (data) {
        if(success)success(data)
    });
},
 GetSyncFilesList: function ($http, success) {
        $http.get('/hmis-bulk-loader/sync').success(function (data) {
				if(success)success(data)
			});
    },
    CheckServiceAvailableBulkUpload: function ($http, success,error) {
        $http.get('/hmis-bulk-loader/bulkupload?status=STAGING').success(function (data) {
        if(success)success(data)
    }).error(error);
		
},
CheckServiceAvailableUploadFile: function ($http, success,error) {
        $http.post('/hmis-bulk-loader-service/uploadFile').success(function (data) {
        if(success)success(data)
    }).error(error);
		
},
CheckServiceAvailableAuthenticate: function ($http, success,error) {
        $http.post('/hmis-client-dedup/rest/api/v1/authenticate').success(function (data) {
        if(success)success(data)
    }).error(error);
		
},
LoadStatistics: function ($http, success) {
        $http.get('/hmis-bulk-loader/bulkupload?status=STAGING').success(
		function (data) 
		{
			 filesCollection =data;
	    	// success(data)
			  $http.get('/hmis-bulk-loader/bulkupload?status=LIVE').success(
				function (data) 
				{
					Array.prototype.push.apply(filesCollection, data);
				// success(data)
					
					$http.get('/hmis-bulk-loader/bulkupload?status=ERROR').success(
					function (data) 
					{
						Array.prototype.push.apply(filesCollection, data);
						success(filesCollection)
				  })
					
			  })
			  
  	  });
},
logout: function ($http,$scope, success,error) {
	// need to change url for services
	console.log('Session Token..'+$scope.sessionToken);
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
/*
SaveSetting: function ($http,$scope, success,error) {
	data =$scope.form;
	// need to change url for services
	 $http.post('form.php', JSON.stringify(data)).success(function(){ success() }).error(error);
  		
}
,*/
SendRequestReport: function ($http,$scope, success,error) {
	data =$scope.form;
	 $http.get('/hmis-bulk-loader/mapper/reportMaster?report='+  data.report +'&id='+  data.project.exportID +'&email='+  data.email +'&year='+  data.year +'').success(function(){ success() }).error(error);
  		
},

bulkupload: function ($http, $scope, success, error) {
    var apiurl = "/hmis-bulk-loader-service/uploadFile";
     var formData = new FormData();
     formData.append("file", $scope.form.inputfile.files[0]);
     formData.append("name", $scope.form.inputfilename);

    $http.post(apiurl, formData, {
         transformRequest: angular.identity,
         headers: { 'Content-Type': undefined }
     }).success(function () { success() }).error(error);
  		
    },
    
//	GetOrganizations: function ($http, success) {
//        $http.get('/hmis-user-service/rest/accounts').success(function (data) {
//				if(success)success(data)
//			});
//    },
	GetRoles: function ($http,$scope, success) {
		  var apiurl = "/hmis-user-service/rest/roles?maxItems=10";
		 console.log('Session Token..'+$scope.sessionToken);
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
		 console.log('Session Token..'+$scope.sessionToken);
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
	  var apiurl = "/hmis-user-service/rest/projectgroups?maxItems=10";
	 console.log('Session Token..'+$scope.sessionToken);
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
    
    createUser : function ($http, $scope, success, error) {
        var apiurl = "/hmis-user-service/rest/accounts";
        console.log('Session Token..'+$scope.sessionToken);
        
        data = $scope.form;
        $http({
            method: 'POST',
            url: apiurl,
            data : 
            	{ "account":{
                    "username": data.username,
                    "emailAddress":data.emailAddress,
                    "password":data.password,
                    "firstName":data.firstName,
                    "middleName":data.middleName,
                    "lastName":data.lastName,
                    "gender":data.gender,
                    "organizationId":"b5598c6c-d021-4f5f-9695-77f7f4685ed2",
                    "role" : {
                    	"id": data.role.id
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
        console.log('Session Token..'+$scope.sessionToken);
        
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
        var apiurl = "/hmis-user-service/rest/projectgroups";
        console.log('Session Token..'+$scope.sessionToken);
        
        data = $scope.form;
        $http({
            method: 'POST',
            url: apiurl,
            data : {
              "projectGroup" : {
                "projectGroupName" : data.name,
                "projectGroupDesc" : data.desc
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
        var apiurl = "/hmis-authorization-service/rest/token?grant_type=authorization_code&code="+$scope.authToken+"&redirect_uri=abc";
        $http({
            method: 'POST',
            url: apiurl,
            headers: {
            	'X-HMIS-TrustedApp-Id': 'c08caa30-9f4c-4bf5-a2f4-d016aec78219',
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