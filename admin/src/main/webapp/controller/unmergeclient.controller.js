
app.controller('unmergeclientCtrl',['$scope','$location','$routeSegment','$http','$modal', '$timeout', '$sessionStorage', function($scope,$location,$routeSegment,$http,$modal, $timeout, $sessionStorage) {
	if($sessionStorage.isLoggedIn){
		$("#userDetails").html($sessionStorage.account.emailAddress);	
	}
	$scope.sessionToken = $sessionStorage.sessionToken;								 
	
  $scope.submitForm = function() {
	  
       Service.UnMergeClient($http,$scope,
    //success
    function(data){
    	   
   	       var modalInstance = $modal.open({
   	            templateUrl: 'templates/partial/mergeclientpopup.html',
   	            controller: 'ModalInstanceLogCtrl',
   	            resolve: {
   	                'datajson': function () {
   	                    return data.client;
   	                }
   	            }
   	        });
    	
		$scope.successTextAlert = "";
		$scope.showSuccessAlert = true;
		$scope.form.name='';
		$scope.form.reportLevel='';
		$scope.form.reportType='';
		$scope.form.startDate='';
		$scope.form.endDate='';
		$scope.form.project=[];
		
},
	//error
	function(){$scope.errorTextAlert = "Error, Something gone wrong.";
$scope.showErrorAlert = true;})
	
       
    };
    $scope.pushUnMerge = function(data) {
		console.log(data);
		data.projetGroupCode=$sessionStorage.account.projectGroup.projectGroupCode;
		data.eventType='client.unmerge';
		Service.Events($http,$scope,data,
			    //success
			    function(data){ console.log(data) },function(error) {});
	};
	// switch flag
$scope.switchBool = function(value) {
   $scope[value] = !$scope[value];
};
}]);
