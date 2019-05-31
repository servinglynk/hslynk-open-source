$(document).ready(function() {
	resizeArea();

	//set url params to hidden form field
	setFormParams(true);	
	$('#consent_decline').click(function () {
		$('#authorize-form').submit();
	});
	
	$('#consent_accept').click(function () {
		$('#consented').val('true');
		$('#authorize-form').submit();
	});
	
});
