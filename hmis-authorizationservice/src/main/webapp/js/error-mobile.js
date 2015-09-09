$(document).ready(function() {
	resizeArea();
	//set url params to hidden form field
	//ClientTypeNotFoundException
	//InvalidRedirectUriException
	var errorCode = getURLParameter("error");
	var errorMsg = "";
	var exceptionMsg = exceptionErrorStrings; 
	
	switch(errorCode){
		case "ClientTypeNotFoundException":
			errorMsg = exceptionMsg.errorMessage;
			break;
		case "InvalidRedirectUriException":
			errorMsg = exceptionMsg.errorRedirectUri;
			break;
		default:
			errorMsg = exceptionMsg.errorUnknown;
	}
	$("#error-msg").html(errorMsg);
	applyAppSize();

});
