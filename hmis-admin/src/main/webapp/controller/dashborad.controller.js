
app.controller('dashboradCtrl', function($scope,$location,$routeSegment,$http, $timeout) {
    Service.CheckServiceAvailableBulkUpload($http,
    //success
    function(data){$("#divBulkUpload .button-success").css("display", "inline");},
	//error
	function(){$("#divBulkUpload .button-error").css("display", "inline");})
	
	
	
	Service.CheckServiceAvailableUploadFile($http,
    //success
    function(data){$("#divUploadFile .button-success").css("display", "inline");},
	//error
	function(){$("#divUploadFile .button-success").css("display", "inline");})
	  
	  
	 Service.CheckServiceAvailableAuthenticate($http,
    //success
    function(data){$("#divAuthenticate .button-success").css("display", "inline");},
	//error
	function(){$("#divAuthenticate .button-success").css("display", "inline");})
	
	
	
	
	Service.LoadStatistics($http,
    //success
    function(filesCollection){
 	 $scope.managefiles = filesCollection;

    })
  
   
});
