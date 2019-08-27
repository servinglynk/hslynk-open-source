
app.controller('unmergeclientCtrl',['$scope','$location','$routeSegment','$http', '$timeout', '$sessionStorage', function($scope,$location,$routeSegment,$http, $timeout, $sessionStorage) {
	if($sessionStorage.isLoggedIn){
		$("#userDetails").html($sessionStorage.account.emailAddress);	
	}
	$scope.sessionToken = $sessionStorage.sessionToken;								 
											   
  $scope.submitForm = function() {
	  
       Service.UnMergeClient($http,$scope,
    //success
    function(data){
    	
		$scope.successTextAlert = "Your Requset has been sent successfully. Your dedup Id is "+data.client.dedupClientId;
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
