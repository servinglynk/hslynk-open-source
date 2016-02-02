app.controller('onboarddevelopmentcompanyCtrl', function($scope, $location, $routeSegment, $http, $timeout, $sessionStorage) {
    $(".secondstep").hide();
    if($sessionStorage.isLoggedIn){
		$("#userDetails").html($sessionStorage.account.emailAddress);	
	}
	
    $scope.CreateGroup = function() {
        $(".firststep").hide();
        $(".secondstep").show();
        $("#createGroup").removeClass("active");
        $("#createUser").addClass("active");
    }

    $scope.PrevUser = function() {
        $(".secondstep").hide();
        $(".firststep").show();
        $("#createUser").removeClass("active");
        $("#createGroup").addClass("active");
    }
    $scope.CreateUser = function() {

        $(".secondstep").hide();
     
        Service.createProjectGroup($http, $scope,
            //success
            function(data) {

                $scope.showSuccessAlert = true;
                $scope.form.name = '';
                $scope.form.desc = '';
                // here we have to set project group

            },
            //error
            function() {
                $scope.errorTextAlert = "Error, Something gone wrong.";
                $scope.showErrorAlert = true;
            })

        $scope.errorTextAlert = "";
        $scope.showErrorAlert = false;
        Service.createUser($http, $scope,
            //success
            function(data) {

                $scope.successTextAlert = "Your Requset has been sent successfully.";
                $scope.showSuccessAlert = true;
                $scope.form.firstName = '';
                $scope.form.lastName = '';
                $scope.form.username = '';
                $scope.form.password = '';
                $scope.form.emailAddress = '';
                $scope.form.gender = '';
				$location.path("/admin/managesync");
            },
            //error
            function(errors) {
                $scope.errorTextAlert = errors.errors.error[0].message;
                $scope.showErrorAlert = true;
					$location.path("/admin/managesync");
            })

	
    }


});