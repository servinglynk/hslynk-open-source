

app.controller('bulkuploadNewCtrl', function ($scope, $location, $routeSegment, $http, $timeout,$sessionStorage){
	$scope.sessionToken = $sessionStorage.sessionToken;
	if($sessionStorage.isLoggedIn){
		$("#userDetails").html($sessionStorage.account.emailAddress);	
	}
    $scope.submitForm = function () {
        $scope.infoTextAlert = "Please wait uploading....";
        $scope.showInfoAlert = true;
        var file = $scope.inputfile;
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
    }

    // switch flag
    $scope.switchBool = function (value) {
        $scope[value] = !$scope[value];
    };

});


