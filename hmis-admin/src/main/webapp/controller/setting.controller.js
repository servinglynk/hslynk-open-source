
app.controller('settingCtrl', function($scope,$location,$routeSegment,$http, $timeout, $sessionStorage) {
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
});
