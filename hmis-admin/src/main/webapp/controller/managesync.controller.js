app.controller('ModalInstanceCtrl',['$scope','$location','$routeSegment','$http', '$timeout','datajson', function($scope,$location,$routeSegment,$http, $timeout,datajson) {
	 $scope.datajson =datajson;
}]);
app.controller('managesyncCtrl',['$scope','$location','$routeSegment','$http', '$timeout','$modal','$sessionStorage', function($scope,$location,$routeSegment,$http, $timeout,$modal, $sessionStorage) {
	if($sessionStorage.isLoggedIn){
		$("#userDetails").html($sessionStorage.account.emailAddress);	
	}
	
    Service.GetSyncFilesList($http,
    //success
    function(data){
        $scope.listSTAGING = data;
        $scope.currentPageSTAGING = 1; //current page
        $scope.entryLimitSTAGING = 10; //max no of items to display in a page
        $scope.filteredItemsSTAGING = $scope.listSTAGING.length; //Initially for no filter  
        $scope.totalItemsSTAGING = $scope.listSTAGING.length;
    })
  
    $scope.setPageSTAGING = function (pageNo) {
        $scope.currentPageSTAGING = pageNo;
    };
	
												   
  $scope.openModel = function(data) {
	
	  var modalInstance = $modal.open({
      templateUrl: 'templates/partial/syncpopopup.html',
      controller: 'ModalInstanceCtrl',
    resolve: {
        datajson: function () {
		
		return	 data.json.replace("}", "").replace("{", "").split(',');
	     
        }
      }
    });

  
       
    };

  
}]);

