app.controller('dashboardCtrl', function($rootScope, $scope, $location, $routeSegment, $http, $timeout, $sessionStorage) {
    $scope.authToken = ($location.search()).code;
    if($rootScope.roleName=="SUPERADMIN")
	{
		$(".dashboard").show();
	}
	else
	{
		$(".dashboard").hide();
	}
    //$scope.sessionToken= $window.localStorage.getItem('sessionToken');
    //$window.localStorage.setItem('authToken',$scope.authToken);
    $sessionStorage.authToken = $scope.authToken;
	 var sessionToken = $sessionStorage.sessionToken;
    if (!sessionToken) {
        Service.getToken($http, $scope, //success
            function(data) {
                $sessionStorage.sessionToken = data.oAuthAuthorization.accessToken;
                $sessionStorage.expiresIn = data.oAuthAuthorization.expiresIn;
                $sessionStorage.tokenType = data.oAuthAuthorization.tokenType;
                $sessionStorage.isLoggedIn = true;
                $scope.sessionToken = data.oAuthAuthorization.accessToken;
                $scope.expiresIn = data.oAuthAuthorization.expiresIn;
                $scope.tokenType = data.oAuthAuthorization.tokenType;
                
                Service.GetUserInfo($http, $scope, function(data) {
                        //$window.localStorage.setItem('account',data.account);
                        $sessionStorage.account = data.account;
                        $("#userDetails").html(data.account.emailAddress);
                        $rootScope.roleName = $sessionStorage.account.roles.role[0].roleName; // data.account.roles.role[0].roleName;
                        $sessionStorage.roleName = $sessionStorage.account.roles.role[0].roleName;
                        if($rootScope.roleName=="SUPERADMIN")
                		{
                			$(".dashboard").show();
                		}
                		else
                		{
                			$(".dashboard").hide();
                		}
                    },
                    function() {
                        if ($sessionStorage.isLoggedIn) {
                            $("#userDetails").html($sessionStorage.account.emailAddress);
                        } else {
                            $location.path('/login');//
                        }
                    });
                	Service.CheckServiceAvailableBulkUpload($http,$scope,
                        //success
                        function(data) {
                            $("#divBulkUpload .button-success").css("display", "inline");
                            $("#divBulkUpload .button-error").css("display", "none");
                        },
                        //error
                        function() {
                        	$("#divBulkUpload .button-success").css("display", "none");
                            $("#divBulkUpload .button-error").css("display", "inline");
                        });

                    Service.CheckServiceAvailableUploadFile($http,$scope,
                        //success
                        function(data) {
                            $("#divUploadFile .button-success").css("display", "inline");
                            $("#divUploadFile .button-success").css("display", "none");
                        },
                        //error
                        function() {
                            $("#divUploadFile .button-success").css("display", "inline");
                            $("#divUploadFile .button-success").css("display", "none");
                        });
                    Service.CheckServiceAvailableAuthenticate($http,$scope,
                        //success
                        function(data) {
                            $("#divAuthenticate .button-success").css("display", "inline");
                            $("#divAuthenticate .button-success").css("display", "none");
                        },
                        //error
                        function() {
                            $("#divAuthenticate .button-success").css("display", "inline");
                            $("#divAuthenticate .button-success").css("display", "none");
                        });
                    Service.LoadStatistics($http,$scope,
                        //success
                        function(filesCollection) {
                            $scope.managefiles = filesCollection;

                        });
                    if($rootScope.roleName=="SUPERADMIN")
            		{
            			$(".dashboard").show();
            		}
            		else
            		{
            			$(".dashboard").hide();
            		}            
                },
            //error
            function() {
            	
                if ($sessionStorage.isLoggedIn) {
                    $("#userDetails").html($sessionStorage.account.emailAddress);
                } else {
                    $location.path('/login');//
                }
            })
		if($rootScope.roleName=="SUPERADMIN")
		{
			$(".dashboard").show();
		}
		else
		{
			$(".dashboard").hide();
		}
    }
    $scope.sessionToken = $sessionStorage.sessionToken;

    Service.CheckServiceAvailableBulkUpload($http,$scope,
        //success
        function(data) {
            $("#divBulkUpload .button-success").css("display", "inline");
        },
        //error
        function() {
            $("#divBulkUpload .button-error").css("display", "inline");
        })



    Service.CheckServiceAvailableUploadFile($http,$scope,
        //success
        function(data) {
            $("#divUploadFile .button-success").css("display", "inline");
        },
        //error
        function() {
            $("#divUploadFile .button-success").css("display", "inline");
        })


    Service.CheckServiceAvailableAuthenticate($http,$scope,
        //success
        function(data) {
            $("#divAuthenticate .button-success").css("display", "inline");
        },
        //error
        function() {
            $("#divAuthenticate .button-success").css("display", "inline");
        })




    Service.LoadStatistics($http,$scope,
        //success
        function(filesCollection) {
            $scope.managefiles = filesCollection;

        })


});