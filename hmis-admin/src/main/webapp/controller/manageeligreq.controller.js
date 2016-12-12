
app.controller('manageeligreqCtrl', function($scope,$location,$routeSegment,$http, $timeout, $sessionStorage) {
	if($sessionStorage.isLoggedIn){
		$("#userDetails").html($sessionStorage.account.emailAddress);	
	}
	
	$scope.sessionToken = $sessionStorage.sessionToken;
    Service.GetEligReq($http,$scope,
    //success
    function(data){
       $scope.list = data.content;
        $scope.currentPage = 1; //current page
        $scope.entryLimit = 10; //max no of items to display in a page
        $scope.filteredItems = $scope.list.length; //Initially for no filter  
        $scope.totalItems = $scope.list.length;
    },function(error) {})
  
    $scope.setPage = function (pageNo) {
        $scope.currentPage = pageNo;
    };
    
    $scope.viewRequirements = function (data) {
//success
    var modalInstance = $modal.open({
        templateUrl: 'templates/partial/vieweligreq.html',
        controller: 'ModalInstanceLogCtrl',
        resolve: {
            datajson: function () {
                return data.requirements;
            }
        }
    });
};

});
