
app.controller('requestreportCtrl',['$scope','$location','$routeSegment','$http', '$timeout', '$sessionStorage', function($scope,$location,$routeSegment,$http, $timeout, $sessionStorage) {
	if($sessionStorage.isLoggedIn){
		$("#userDetails").html($sessionStorage.account.emailAddress);
	}
	$scope.sessionToken = $sessionStorage.sessionToken;
	Service.GetProjectList($http,
    //success
    function(data){$scope.projects =data;  },//error
	function(){$scope.errorTextAlert = "Error, Something gone wrong with getting projects.";
	$scope.showErrorAlert = true;},
	$scope)
	
		Service.GetCocCode($http,
    //success
    function(data){$scope.cocs =data;  },//error
	function(){$scope.errorTextAlert = "Error, Something gone wrong with getting projects.";
	$scope.showErrorAlert = true;},
	$scope)
	
$scope.onSelectChange = function() {
	if($scope.form.reportType ==='LSA') {
		$scope.showLSA = true;
	}else {
		$scope.showLSA = false;
	}
		
},
  $scope.submitForm = function() {

       Service.SendRequestReport($http,$scope,
    //success
    function(data){

		$scope.successTextAlert = "Your request has been sent successfully.";
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
