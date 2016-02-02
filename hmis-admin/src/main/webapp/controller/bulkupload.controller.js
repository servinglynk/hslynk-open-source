

app.controller('bulkUploadCtrl', function ($scope, $location, $routeSegment, $http, $timeout,$sessionStorage){
	$scope.sessionToken = $sessionStorage.sessionToken;
	if($sessionStorage.isLoggedIn){
		$("#userDetails").html($sessionStorage.account.emailAddress);	
	}
	
    $scope.submitForm = function (file) {
    	$scope.projectGroupCode = $sessionStorage.account.projectGroup.projectGroupCode;
        $scope.infoTextAlert = "Please wait uploading....";
        $scope.showInfoAlert = true;
        Service.bulkupload($http, $scope,file,
 //success
            function () {
                $scope.switchBool("showInfoAlert");
                $scope.successTextAlert = "File has been uploaded successfully.";
                $scope.showSuccessAlert = true;
				$location.path("/admin/managefiles");
            },
//error
       function () {
		//	   $location.path("/admin/managefiles");
           $scope.switchBool("showInfoAlert");
           $scope.errorTextAlert = "Error, Something gone wrong.";
           $scope.showErrorAlert = true;
           
       })

      
        return false;
    }

    // switch flag
    $scope.switchBool = function (value) {
        $scope[value] = !$scope[value];
    };

});


