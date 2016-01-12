
app.controller('dashboradCtrl', function($scope,$location,$routeSegment,$http, $timeout,$window) {
	$scope.authToken = ($location.search()).code;
	$window.localStorage.setItem('authToken',$scope.authToken);
	if(!$scope.sessionToken) {
		Service.getToken($http,$scope,  //success
			    function(data){ 
					$window.localStorage.setItem('sessionToken',data.oAuthAuthorization.accessToken);
					$window.localStorage.setItem('expiresIn',data.oAuthAuthorization.expiresIn);
					$window.localStorage.setItem('tokenType',data.oAuthAuthorization.tokenType);
					$scope.sessionToken=data.oAuthAuthorization.accessToken;
					$scope.expiresIn = data.oAuthAuthorization.expiresIn;
					$scope.tokenType = data.oAuthAuthorization.tokenType;
			},
				//error
				function(){})
}
	
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
