
app.controller('manageexportCtrl',['$scope','$location','$routeSegment','$http','$modal', '$timeout', '$sessionStorage', function($scope,$location,$routeSegment,$http,$modal,$timeout, $sessionStorage) {
	if($sessionStorage.isLoggedIn){
		$("#userDetails").html($sessionStorage.account.emailAddress);	
	}
	$scope.sessionToken = $sessionStorage.sessionToken;
    Service.GetExports($http,
    //success
    function(data){
       $scope.list = data;
        $scope.currentPage = 1; //current page
        $scope.entryLimit = 10; //max no of items to display in a page
        $scope.filteredItems = $scope.list.length; //Initially for no filter  
        $scope.totalItems = $scope.list.length;
    },$scope)
  
    $scope.setPage = function (pageNo) {
        $scope.currentPage = pageNo;
    };

    $scope.openlog =  function (projectIds) {
        $scope.projectIds = projectIds;
       console.log('Projects'+projectIds);
       var modalInstance = $modal.open({
            templateUrl: 'templates/partial/exportprojectspopopup.html',
            controller: 'ModalInstanceLogCtrl',
            resolve: {
                'datajson': function () {
                    return projectIds;
                }
            }
        });
    }
    
    $scope.downloadZIP =  function (exportId) {
        console.log('export config:'+exportId);
        $scope.downloadId=exportId;
        Service.DownloadZIP($http,$scope,
     		    //success
     		    function(data){
        	 		console.log('export config download success :'+exportId);
     		    },function(error) {})
     }

}]);


app.controller('ModalInstanceLogCtrl',['$scope', '$location', '$routeSegment', '$http', '$timeout', 'datajson', function ($scope, $location, $routeSegment, $http, $timeout, datajson) {
    $scope.datajson = datajson;
}]);
