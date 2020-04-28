
app.controller('updateUserPwdCtrl',['$scope','$location','$routeParams','$routeSegment','$http', '$timeout','$sessionStorage', function($scope,$location,$routeParams,$routeSegment,$http, $timeout,$sessionStorage) {
		
	$scope.sessionToken = $sessionStorage.sessionToken;
	if($sessionStorage.isLoggedIn){
		$("#userDetails").html($sessionStorage.account.emailAddress);	
	}
	
	$scope.accountId = $routeParams.id;
	
    Service.getAccountById($http,$scope,
    	    //success
    	    function (data) {
    	        $scope.username = data.account.username;
    	    },function(data){console.log('error when getting accont by id');})

    $scope.setPageErrorMessage = function (pageNo) {
        $scope.currentPageErrorMessage = pageNo;
    };
 
 
  $scope.submitForm = function() {
    	$scope.errorTextAlert= "";
    	$scope.showErrorAlert = false;
       Service.updateAccountPassword($http,$scope,
    //success
    function(data){
	
		$scope.successTextAlert = "Your request has been sent successfully.";
		$scope.showSuccessAlert = true;
		$scope.form.firstName='';
		$scope.form.lastName ='';
		$scope.form.username ='';
		$scope.form.password ='';
		$scope.form.emailAddress ='';

},
	//error
	function(errors){
	$scope.errorTextAlert = errors.errors.error[0].message;
	$scope.showErrorAlert = true;
})
	
       
    };
	// switch flag
$scope.switchBool = function(value) {
   $scope[value] = !$scope[value];
};
}]);
