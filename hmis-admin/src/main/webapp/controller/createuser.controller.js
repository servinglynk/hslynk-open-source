
app.controller('createuserCtrl', function($scope,$location,$routeSegment,$http, $timeout,$sessionStorage) {
		
	$scope.sessionToken = $sessionStorage.sessionToken;
	if($sessionStorage.isLoggedIn){
		$("#userDetails").html($sessionStorage.account.emailAddress);	
	}
	
//	Service.GetOrganizations($http,
//		    //success
//		 function(data){$scope.organizations =data;  }),
    Service.GetProfiles($http,$scope,
		    //success
		 function(data){$scope.profiles =data.profiles.profile;  }),
	Service.GetRoles($http,$scope,
			//success
	 function(data){$scope.roles =data.roles.role;  }),
		    
	Service.GetProjectGroups($http,$scope,
    //success
    function(data){$scope.projectgroups =data.projectgroups.projectGroups;  }),
											   
											   
  $scope.submitForm = function() {
    	$scope.errorTextAlert= "";
    	$scope.showErrorAlert = false;
       Service.createUser($http,$scope,
    //success
    function(data){
	
		$scope.successTextAlert = "Your Requset has been sent successfully.";
		$scope.showSuccessAlert = true;
		$scope.form.firstName='';
		$scope.form.lastName ='';
		$scope.form.username ='';
		$scope.form.password ='';
		$scope.form.emailAddress ='';
		$scope.form.gender ='';

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
});
