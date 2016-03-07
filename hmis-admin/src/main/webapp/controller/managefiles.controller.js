/* Login */
app.filter('startFrom', function() {
    return function(input, start) {
        if(input) {
            start = +start; //parse to int
            return input.slice(start);
        }
        return [];
    }
});
app.controller('managefilesCtrl', function($scope,$location,$routeSegment,$http, $timeout, $sessionStorage) {
	if($sessionStorage.isLoggedIn){
		$("#userDetails").html($sessionStorage.account.emailAddress);	
	}
	$scope.sessionToken = $sessionStorage.sessionToken;
    Service.GetFilesListSTAGING($http,
    //success
    function(data){
        $scope.listSTAGING = data;
        $scope.currentPageSTAGING = 1; //current page
        $scope.entryLimitSTAGING = 10; //max no of items to display in a page
        $scope.filteredItemsSTAGING = $scope.listSTAGING.length; //Initially for no filter  
        $scope.totalItemsSTAGING = $scope.listSTAGING.length;
    },$scope)
  
    $scope.setPageSTAGING = function (pageNo) {
        $scope.currentPageSTAGING = pageNo;
    };

    Service.GetFilesListLIVE($http,
   //success
   function (data) {
       $scope.listLIVE = data;
       $scope.currentPageLIVE = 1; //current page
       $scope.entryLimitLIVE = 10; //max no of items to display in a page
       $scope.filteredItemsLIVE = $scope.listLIVE.length; //Initially for no filter  
       $scope.totalItemsLIVE = $scope.listLIVE.length;
   },$scope)

    $scope.setPageLIVE = function (pageNo) {
        $scope.currentPageLIVE = pageNo;
    };

    Service.GetFilesListERROR($http,
  //success
  function (data) {
      $scope.listERROR = data;
      $scope.currentPageERROR = 1; //current page
      $scope.entryLimitERROR = 10; //max no of items to display in a page
      $scope.filteredItemsERROR = $scope.listERROR.length; //Initially for no filter  
      $scope.totalItemsERROR = $scope.listERROR.length;
  },$scope)

    $scope.setPageERROR = function (pageNo) {
        $scope.currentPageERROR = pageNo;
    };
   
    Service.GetFilesListDELETED($http,
    		  //success
    		  function (data) {
    		      $scope.listDELETED = data;
    		      $scope.currentPageDELETED = 1; //current page
    		      $scope.entryLimitDELETED = 10; //max no of items to display in a page
    		      $scope.filteredItemsDELETED = $scope.listDELETED.length; //Initially for no filter  
    		      $scope.totalItemsDELETED = $scope.listDELETED.length;
    		  },$scope)

    		    $scope.setPageDELETED = function (pageNo) {
    		        $scope.currentPageDELETED = pageNo;
    		    };
});
