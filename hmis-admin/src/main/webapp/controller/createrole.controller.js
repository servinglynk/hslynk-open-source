
app.controller('createprojgrpCtrl', function($scope,$location,$routeSegment,$http, $timeout,$sessionStorage) {
	//$rootScope.sessionToken = $window.localStorage.getItem('sessionToken');
	console.log('Session Token..'+$sessionStorage.sessionToken);	
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
});
