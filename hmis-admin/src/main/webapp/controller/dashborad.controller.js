
app.controller('dashboradCtrl', function($scope,$location,$routeSegment,$http, $timeout) {
    Service.CheckServiceAvailable($http,
    //success
    function(data){
  
	$(".button-success").css("display", "block");

    },
	//error
	function(){$(".button-error").css("display", "block");})
	
	Service.LoadStatistics($http,
    //success
    function(filesCollection){
 	 $scope.managefiles = filesCollection;

    })
  
   
});
