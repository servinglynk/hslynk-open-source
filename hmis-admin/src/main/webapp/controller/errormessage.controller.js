
app.controller('errormessageCtrl', function ($scope, $location, $routeParams, $routeSegment, $http, $timeout, $sessionStorage) {
    if ($sessionStorage.isLoggedIn) {
        $("#userDetails").html($sessionStorage.account.emailAddress);
    }
    $scope.sessionToken = $sessionStorage.sessionToken;
    var routeParams = $routeParams.id;
    var params = routeParams.split("-");
    $scope.id= params[0];
    $scope.year= params[1];
    Service.GetErrorMessage($http,
    	    //success
    	    function (data) {
    	        $scope.listErrorMessage = data;
    	        $scope.currentPageErrorMessage = 1; //current page
    	        $scope.entryLimitErrorMessage = 10; //max no of items to display in a page
    	        $scope.filteredItemsErrorMessage = $scope.listErrorMessage.length; //Initially for no filter  
    	        $scope.totalItemsErrorMessage = $scope.listErrorMessage.length;
    	    }, $scope)

    $scope.setPageErrorMessage = function (pageNo) {
        $scope.currentPageErrorMessage = pageNo;
    };
   

 
});
