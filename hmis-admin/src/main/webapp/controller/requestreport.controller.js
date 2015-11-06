
app.controller('requestreportCtrl', function($scope,$location,$routeSegment,$http, $timeout) {
											 
	Service.GetProjectList($http,
    //success
    function(data){$scope.projects =data;  })
											   
											   
  $scope.submitForm = function() {
	  
       Service.SendRequestReport($http,$scope,
    //success
    function(data){
	
		$scope.successTextAlert = "Your Requset has been sent successfully.";
		$scope.showSuccessAlert = true;
		$scope.form.email='';
		$scope.form.report='';
		$scope.form.year='';
		$scope.form.project='';
		

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
