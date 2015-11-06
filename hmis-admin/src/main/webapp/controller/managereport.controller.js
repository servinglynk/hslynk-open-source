
app.controller('managereportCtrl', function($scope,$location,$routeSegment,$http, $timeout) {
    
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


});
