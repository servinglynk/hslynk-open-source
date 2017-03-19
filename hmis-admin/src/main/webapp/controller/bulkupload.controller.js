

app.controller('bulkUploadCtrl', function ($scope, $location, $routeSegment, $http, $timeout,$sessionStorage){
	$scope.sessionToken = $sessionStorage.sessionToken;
	if($sessionStorage.isLoggedIn){
		$("#userDetails").html($sessionStorage.account.emailAddress);	
	}
	
    $scope.submitForm = function (file) {
    	$scope.projectGroupCode = $sessionStorage.account.projectGroup.projectGroupCode;
        $scope.infoTextAlert = "Please wait uploading....";
        $scope.showInfoAlert = true;
   $scope.showSuccessAlert = false;
     $scope.showErrorAlert = false;
     
     
        AWS.config.update({
        accessKeyId : 'AKIAJH6EMBEDW342TOAQ',
        secretAccessKey : '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'
    });
    AWS.config.region = 'us-east-1';
     
  var bucket = new AWS.S3({params: {Bucket: $sessionStorage.account.projectGroup.bucketName.toLocaleLowerCase(),Prefix:'testfolder'}});
    var fileChooser = $("input[type='file'")[0];
    var file1 = fileChooser.files[0];
    if (file1) {
    var params = {Key: file1.name, ContentType: file1.type, Body: file1,xhrFields: {
      withCredentials: true }};
    bucket.upload(params).on('httpUploadProgress', function(evt) {
    console.log("Uploaded :: " + parseInt((evt.loaded * 100) / evt.total)+'%');
 
   $(".bg-info").html( "Please wait uploading.... " + parseInt((evt.loaded * 100) / evt.total)+'%');
        
     
 
    }).send(function(err, data) {
   // alert("File uploaded successfully.");
 
        $scope.fileName = file1.name;
        $scope.bucketName = 'sdolia-2015';
      //  $scope.fileSize = file1.size;
        Service.bulkupload($http, $scope,file,
 //success
            function () {
                $scope.switchBool("showInfoAlert");
                $scope.successTextAlert = "File has been uploaded successfully.";
    $scope.showInfoAlert = false;
                $scope.showSuccessAlert = true;
    
    $location.path("/admin/managefiles");
            },
//error
       function () {
     $location.path("/admin/managefiles");
           $scope.switchBool("showInfoAlert");
           $scope.errorTextAlert = "Error, Something gone wrong.";
     $scope.showInfoAlert = false;
           $scope.showErrorAlert = true;
           
       })
    
 
    });
    }
        return false;
    }

    // switch flag
    $scope.switchBool = function (value) {
        $scope[value] = !$scope[value];
    };

});


