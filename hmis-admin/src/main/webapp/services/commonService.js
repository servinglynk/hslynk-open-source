var filesCollection="";
var Service= ({
	GetProjectList: function ($http, success) {
        $http.get('/hmis-bulk-loader/mapper/projects').success(function (data) {
				if(success)success(data)
			});
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
     

     //$http({
     //    method: 'POST',
     //    url: apiurl,
     //    headers: {
     //        'Content-Type': 'multipart/form-data'
     //    },
     //    data: {
     //        file: $scope.form.inputfile.files[0],
     //        name: $scope.form.inputfilename
     //    },
     //    transformRequest: function (data, headersGetter) {
     //        var formData = new FormData();
     //        angular.forEach(data, function (value, key) {
     //            formData.append(key, value);
     //        });

     //        var headers = headersGetter();
     //        delete headers['Content-Type'];

     //        return formData;
     //    }
     //})
     //   .success(success)
     //   .error(error);

    $http.post(apiurl, formData, {
         transformRequest: angular.identity,
         headers: { 'Content-Type': undefined }
     }).success(function () { success() }).error(error);
  		
    }
	
});