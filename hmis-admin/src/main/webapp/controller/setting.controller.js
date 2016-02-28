
app.controller('settingCtrl', function($scope,$location,$routeSegment,$http, $timeout, $sessionStorage) {
	if($sessionStorage.isLoggedIn){
		$("#userDetails").html($sessionStorage.account.emailAddress);	
	}
	 Service.GetUserInfo($http, $scope, function(data) {
                    
                     // here setup edit mode
                    },
                    function() {
                        if ($sessionStorage.isLoggedIn) {
                            $("#userDetails").html($sessionStorage.account.emailAddress);
                        } else {
                          //  $location.path('/login');
                        }
                    });
	 
  $scope.submitForm = function() {
       Service.SaveSetting($http,$scope,
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
