var filesCollection="";
var Service= ({
	
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
    CheckServiceAvailable: function ($http, success,error) {
        $http.get('/hmis-bulk-loader/bulkupload?status=STAGING').success(function (data) {
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
}
	
});