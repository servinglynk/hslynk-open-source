

app.controller('bulkUploadCtrl', function ($scope, $location, $routeSegment, $http, $timeout) {

    $scope.submitForm = function () {

        $scope.infoTextAlert = "Please wait uploading....";
        $scope.showInfoAlert = true;

        Service.bulkupload($http, $scope,
 //success
            function () {
                $scope.switchBool("showInfoAlert");
                $scope.successTextAlert = "Your Requset has been sent successfully.";
                $scope.showSuccessAlert = true;
            },
//error
       function () {
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


