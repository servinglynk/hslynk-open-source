/* Login */
app.controller('validateLoginCtrl', function($scope,$location,$routeSegment) {
  $scope.SubmitLogin = function() {

	if($scope.email=="admin@servinglynk.com" && $scope.password=="admin")
	{
		$location.path($routeSegment.getSegmentUrl('s2.dashborad')); 
	}
	else
	{
		alert("Invalid username & password");
	}

  };
});
