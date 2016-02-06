app.controller('onboardfellowCtrl', function($scope, $location, $routeSegment, $http, $timeout, $sessionStorage) {

    if ($sessionStorage.isLoggedIn) {
        $("#userDetails").html($sessionStorage.account.emailAddress);
    }
    $scope.sessionToken = $sessionStorage.sessionToken;

});

app.controller('onboardfellowgroupCtrl', function($scope, $location, $routeSegment, $http, $timeout, $sessionStorage) {
    $("#createUser").removeClass("active");
    $("#createGroup").addClass("active");

    $scope.sessionToken = $sessionStorage.sessionToken;
    $scope.submitForm = function() {
        Service.createProjectGroup($http, $scope,
            //success
            function(data) {

                $scope.successTextAlert = "Your Requset has been sent successfully.";
                $scope.showSuccessAlert = true;
                $scope.form.name = '';
                $scope.form.desc = '';
                $location.path("/admin/onboardfellowuser");

            },
            //error
            function() {
                $scope.errorTextAlert = "Error, Something gone wrong.";
                $scope.showErrorAlert = true;
            })


    };
    // switch flag
    $scope.switchBool = function(value) {
        $scope[value] = !$scope[value];
    };

});
app.controller('onboardfellowuserCtrl', function($rootScope,$scope, $location, $routeSegment, $http, $timeout, $sessionStorage) {
    $("#createGroup").removeClass("active");
    $("#createUser").addClass("active");
    $scope.sessionToken = $sessionStorage.sessionToken;
    Service.GetProfiles($http, $scope,
            //success
            function(data) {
                $scope.profiles = data.profiles.profile;
            }),
        Service.GetRoles($http, $scope,
            //success
            function(data) {
        	var _tempArr = [];
        	for(var i=0;i<data.roles.role.length;i++)
            {
        	
        		if($rootScope.roleName!="SUPERADMIN" && data.roles.role[i].roleName=='SUPERADMIN'){
        			
        		}
        		else
        		{
        			_tempArr.push(data.roles.role[i]);
        		}
        		
            }
        	$scope.roles =_tempArr; //data.roles.role;
            }),

        Service.GetProjectGroups($http, $scope,
            //success
            function(data) {
                $scope.projectgroups = data.projectgroups.projectGroups;
            }),


        $scope.prev = function() {
			
            $location.path("/admin/onboardfellowgroup");
        }


    $scope.submitForm = function() {
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
                $location.path("/admin/manageuser");
            },
            //error
            function(errors) {
                $scope.errorTextAlert = errors.errors.error[0].message;
                $scope.showErrorAlert = true;
            })


    };
    // switch flag
    $scope.switchBool = function(value) {
        $scope[value] = !$scope[value];
    };
});