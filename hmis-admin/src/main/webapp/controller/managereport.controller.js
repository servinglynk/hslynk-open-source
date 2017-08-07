
app.controller('managereportCtrl',['$scope','$location','$routeSegment','$http', '$timeout', '$sessionStorage', function($scope,$location,$routeSegment,$http, $timeout, $sessionStorage) {
	if($sessionStorage.isLoggedIn){
		$("#userDetails").html($sessionStorage.account.emailAddress);	
	}
	
    Service.GetReports($http,
    //success
    function(data){
       $scope.list = data;
        $scope.currentPage = 1; //current page
        $scope.entryLimit = 10; //max no of items to display in a page
        $scope.filteredItems = $scope.list.length; //Initially for no filter  
        $scope.totalItems = $scope.list.length;
    })
  
    $scope.setPage = function (pageNo) {
        $scope.currentPage = pageNo;
    };


}]);
