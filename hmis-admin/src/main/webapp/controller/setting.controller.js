
app.controller('settingCtrl', function($scope,$location,$routeSegment,$http, $timeout) {
  $scope.submitForm = function() {
       Service.SaveSetting($http,$scope,
    //success
    function(data){$scope.successTextAlert = "Setting has been updated successfully.";
$scope.showSuccessAlert = true;},
	//error
	function(){$scope.errorTextAlert = "Error, Something gone wrong.";
$scope.showErrorAlert = true;})
	
       
    };
	// switch flag
$scope.switchBool = function(value) {
   $scope[value] = !$scope[value];
};
});
