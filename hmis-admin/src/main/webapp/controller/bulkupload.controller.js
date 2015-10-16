$scope.uploadedFile = function(element) {
 $scope.$apply(function($scope) {
   $scope.files = element.files;         
 });
}
