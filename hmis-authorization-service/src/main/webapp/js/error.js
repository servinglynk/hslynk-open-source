$(document).ready(function() {
	resizeArea();
	//set url params to hidden form field
	//ClientTypeNotFoundException
	//InvalidRedirectUriException
	var errorCode = getURLParameter("error");
	var errorMsg = "";
	
	$("#error-msg").html(errorCode);

});
