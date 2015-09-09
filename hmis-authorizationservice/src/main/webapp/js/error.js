$(document).ready(function() {
	resizeArea();
	//set url params to hidden form field
	//ClientTypeNotFoundException
	//InvalidRedirectUriException
	var errorCode = getURLParameter("error");
	var errorMsg = "";
	
	switch(errorCode){
		case "ClientTypeNotFoundException":
			errorMsg = "Invalid ClientType ID";
			break;
		case "InvalidRedirectUriException":
			errorMsg = "Invalid Redirect URI";
			break;
		default:
			errorMsg ="unknown error"
	}
	$("#error-msg").html(errorMsg);

});
