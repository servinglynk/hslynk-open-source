
app.controller('createuserCtrl', function($scope,$location,$routeSegment,$http, $timeout,$window) {
	$scope.sessionToken = $window.localStorage.getItem('sessionToken');
	
	
//	Service.GetOrganizations($http,
//		    //success
//		 function(data){$scope.organizations =data;  }),
    Service.GetProfiles($http,$scope,
		    //success
		 function(data){$scope.profiles =data;  }),
	Service.GetRoles($http,$scope,
			//success
	 function(data){$scope.roles =data;  }),
		    
//	Service.GetProjectGroups($http,$scope,
//    //success
//    function(data){$scope.projectGroups =data;  }),
											   
											   
  $scope.submitForm = function() {
	  
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
	function(){$scope.errorTextAlert = "Error, Something gone wrong.";
$scope.showErrorAlert = true;})
	
       
    };
	// switch flag
$scope.switchBool = function(value) {
   $scope[value] = !$scope[value];
};
});
