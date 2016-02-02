
app.controller('manageuserCtrl', function($scope,$location,$routeSegment,$http, $timeout, $sessionStorage) {
	$scope.sessionToken = $sessionStorage.sessionToken;
	if($sessionStorage.isLoggedIn){
		$("#userDetails").html($sessionStorage.account.emailAddress);	
	}
	
    Service.GetUserByOrganization($http,$scope,
    //success
    function(data){
       $scope.list = data.account;
        $scope.currentPage = 1; //current page
        $scope.entryLimit = 10; //max no of items to display in a page
        $scope.filteredItems = $scope.list.length; //Initially for no filter  
        $scope.totalItems = $scope.list.length;
    },function(error) {})
  
    $scope.setPage = function (pageNo) {
        $scope.currentPage = pageNo;
    };


});
