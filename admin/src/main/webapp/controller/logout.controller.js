app.controller('logoutCtrl', ['$scope', '$location', '$routeSegment', '$http', '$timeout', '$sessionStorage', function ($scope, $location, $routeSegment, $http, $timeout, $sessionStorage) {
    if ($sessionStorage.isLoggedIn) {
        $("#userDetails").html($sessionStorage.account.emailAddress);
    }

    $scope.sessionToken = $sessionStorage.sessionToken;
    delete $sessionStorage.sessionToken;
    delete $sessionStorage.sessionToken;
    delete $sessionStorage.expiresIn;
    delete $sessionStorage.tokenType;
    delete $sessionStorage.authToken;
    delete $sessionStorage.isLoggedIn;
    delete $sessionStorage.account;

    Service.logout($http, $scope,
        //success
        //success
        function () {
            //$window.localStorage.

        },
        //error
        function () {
        });
    // switch flag
    $scope.switchBool = function (value) {
        $scope[value] = !$scope[value];
    };
}]);
