
app.controller('logoutCtrl', function($scope,$location,$routeSegment,$http, $timeout,$sessionStorage) {
	$scope.sessionToken =$sessionStorage.sessionToken;
	console.log('Session Token..'+$scope.sessionToken);	
	delete $sessionStorage.sessionToken;
	delete $sessionStorage.sessionToken;
	delete $sessionStorage.expiresIn;
	delete $sessionStorage.tokenType;
	delete $sessionStorage.authToken;
	delete $sessionStorage.isLoggedIn;
	delete $sessionStorage.account;
	
	Service.logout($http,$scope,
    //success
    //success
    function(){
		//$window.localStorage.

},
	//error
	function(){});
	// switch flag
$scope.switchBool = function(value) {
   $scope[value] = !$scope[value];
};
});
