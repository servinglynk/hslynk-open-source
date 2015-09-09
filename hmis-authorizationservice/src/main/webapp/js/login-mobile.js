$(document).ready(function() {
	//set url params to hidden form field
	setFormParams();

	$('#refresh-captcha').click(function () {
		getCaptcha();
	});
	
	$('#submit-login').click(function () {
		var userName = $.trim($('#username').val()),
			password = $.trim($('#password').val());
		submitLogin(userName, password)
	});
});