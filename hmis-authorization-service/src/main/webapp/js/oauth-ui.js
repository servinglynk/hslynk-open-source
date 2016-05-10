function getURLParameter(name) {
    return decodeURI(
        (RegExp(name + '=' + '(.+?)(&|$)').exec(location.search) || [, null])[1]
    );
}

function resizeArea(){
	var winHeight = $(window).height();
	var mainContentHeight = winHeight - $('#header-wrapper').height();
	$('#main-content-wrapper').css('min-height', mainContentHeight + 'px');
	$('#main-content').css('min-height', mainContentHeight - 40 + 'px');
}

function getAppInfo(clientId, token, callback){
	$.ajax({
		headers: {
				  "Content-Type": "application/json;charset=UTF-8",
				  "Accept-Language": "en-us,en;q=0.5",  
				  "Accept":"application/json",
				 
				  "Authorization" : "HMISUserAuth session_token="+token
		},
		beforeSend: function (request) {

            request.setRequestHeader("X-HMIS-TrustedApp-Id", clientId);
        },
		
		type: "GET",
		url: "/hmis-user-service/rest/clients/"+clientId+"/basicinfo",
		dataType: "json",
		success: callback,
		error: function (res) {
			var responseError = JSON.parse(res.responseText);
			var errorCode = responseError.errors[0].error.code; 
			var errorMessage = responseError.errors[0].error.message; 
			$('#errorMsg').html(errorMessage); 
			
		}
	
	});	
}

function getApiGroups(clientId, token, callback){
	$.ajax({
		headers: {
				  "Content-Type": "application/json;charset=UTF-8",
				  "Accept-Language": "en-us,en;q=0.5",  
				  "Accept":"application/json",
				  "X-HMIS-TrustedApp-Id": "631D1191-9AC5-4F3F-836A-8DB0DBAE3CD3",
				  "Authorization" : "HMISUserAuth session_token="+token
		},
		
		type: "GET",
		url: "/hmis-developerservice/rest/client/"+clientId+"/apigroups",
		dataType: "json",
		success: callback,
		error: function (res) {
			var responseError = JSON.parse(res.responseText);
			var errorCode = responseError.errors[0].error.code; 
			var errorMessage = responseError.errors[0].error.message; 
			$('#errorMsg').html(errorMessage); 
			
		}
	
	});	
}

function getConsentMsgs(clientId, token, callback){
	$.ajax({
		headers: {
				  "Content-Type": "application/json;charset=UTF-8",
				  "Accept-Language": "en-us,en;q=0.5",  
				  "Accept":"application/json",
				  "Authorization" : "HMISUserAuth session_token="+token
		},
		beforeSend: function (request) {

             request.setRequestHeader("X-HMIS-TrustedApp-Id", clientId);
         },
		
		type: "GET",
		url: "/hmis-authorization-service-v2015/rest/trustedapps/"+clientId+"/consentmessages",
		dataType: "json",
		success: callback,
		error: function (res) {
			var responseError = JSON.parse(res.responseText);
			var errorCode = responseError.errors[0].error.code; 
			var errorMessage = responseError.errors[0].error.message; 
			$('#errorMsg').html(errorMessage); 
			
		}
	
	});	
}

function getDetailedConsentMsgs(clientId, token, callback){
	$.ajax({
		headers: {
				  "Content-Type": "application/json;charset=UTF-8",
				  "Accept-Language": "en-us,en;q=0.5",  
				  "Accept":"application/json",
				  "Authorization" : "HMISUserAuth session_token="+token
		},
		beforeSend: function (request) {

             request.setRequestHeader("X-HMIS-TrustedApp-Id", clientId);
         },
		
		type: "GET",
		url: "/hmis-authorization-service-v2015/rest/trustedapps/"+clientId+"/detailedconsentmessages",
		dataType: "json",
		success: callback,
		error: function (res) {
			var responseError = JSON.parse(res.responseText);
			var errorCode = responseError.errors[0].error.code; 
			var errorMessage = responseError.errors[0].error.message; 
			$('#errorMsg').html(errorMessage); 
			
		}
	
	});	
}

$('#submit-otp').click(function (){
	var date = new Date();
	date.setTime(date.getTime() + (10 * 60 * 1000));	
		$.ajax({
			headers: {
					  "Content-Type": "application/json;charset=UTF-8",
					  "Accept-Language": "en-us,en;q=0.5",  
					  "Accept":"application/json",
					  "X-HMIS-TrustedApp-Id" : getURLParameter("trustedApp_id")
			},
			
			type: "POST",
			url: "/hmis-authorization-service-v2015/rest/authorize/validateotp?otp="+$.trim($('#otp').val())+"&authKey="+jQuery("#authKey").val(),
			dataType: "json",
			success: function(data){
				//set cookie here
				$.cookie('authentication_token', data.session.token, { expires: date, path: '/' });
				$("#authentication_token").val(data.session.token)
				//GET authorization
				$('#authorize-form').submit();
			},
			error: function (res) {
				loginErrorHandler(res, "errorMsg", userName)
			}
		
		});		
	

});
function submitLoginForWeb(userName, password){
	var date = new Date();
	date.setTime(date.getTime() + (10 * 60 * 1000));	
		$.ajax({
			headers: {
					  "Content-Type": "application/json;charset=UTF-8",
					  "Accept-Language": "en-us,en;q=0.5",  
					  "Accept":"application/json"
			},
			cache :false,
			type: "POST",
			url: "/hmis-authorization-service-v2015/rest/authorize/session?trustedApp_id="+getURLParameter("trustedApp_id")+"&redirect_uri="+getURLParameter("redirect_uri")+"&response_type="+getURLParameter("response_type")+"&state="+getURLParameter("state")+"&username="+userName+"&password="+password+"&access_type="+getURLParameter("access_type")+"&approval_prompt="+getURLParameter("approval_prompt"),
			dataType: "json",
			success: function(res){
				//set cookie here
				console.log('Looking good.');
			},
			error: function (e) {
				loginError(e, "errorMsg", userName);
			}
		
		}).done(function () {
	        window.location.href = getURLParameter("redirect_uri");
	    });		
	
}

function submitLogin(userName, password){
	var date = new Date();
	date.setTime(date.getTime() + (10 * 60 * 1000));	
		$.ajax({
			headers: {
					  "Content-Type": "application/json;charset=UTF-8",
					  "Accept-Language": "en-us,en;q=0.5",  
					  "Accept":"application/json"
			},
			
			type: "POST",
			url: "/hmis-user-service/rest/sessions?trustedApp_id="+getURLParameter("trustedApp_id"),
			data: JSON.stringify({ session: { account: { username: userName, password: password}} }),
			dataType: "json",
			success: function(res){
				//set cookie here
				$.cookie('authentication_token', data.session.token, { expires: date, path: '/' });
				$("#authentication_token").val(data.session.token)
				//GET authorization
				$('#authorize-form').submit();

			},
			error: function (res) {
				loginErrorHandler(res, "errorMsg", userName)
			}
		
		});		
	
}

function setFormParams(isConsentPage){
	$("#response_type").val(getURLParameter("response_type"));
	$("#trustedApp_id").val(getURLParameter("trustedApp_id"));
	$("#state").val(getURLParameter("state"));

	$("#redirect_uri").val(decodeURIComponent(getURLParameter("redirect_uri")));
	if(getURLParameter("access_type") != 'null'){
		$("#access_type").val(getURLParameter("access_type"));
	}
	if(getURLParameter("approval_prompt") != 'null'){
		$("#approval_prompt").val(getURLParameter("approval_prompt"));
	}
	if(getURLParameter("authentication_token") != 'null'){
		$("#authentication_token").val(getURLParameter("authentication_token"));
	}
	if(isConsentPage){
		$("#consent_token").val(getURLParameter("consent_token"));
	}
}

function getCaptcha(){
	$.ajax({
		headers: {
				  "Content-Type": "application/json;charset=UTF-8",
				  "Accept-Language": "en-us,en;q=0.5",  
				  "Accept":"application/json",
				  "X-HMIS-TrustedApp-Id": "F1F24914-2674-4DD9-9335-09D5136675FC"
		},
		
		type: "POST",
		url: "/captcha-service/rest/captchas",
		data: JSON.stringify({ captcha: { type: "IMAGE" } }),
		dataType: "json",
		success: function(res){
			$("#captcha-image").attr('src', res.captcha.resourceUrl);
			Captcha.token = res.captcha.challengeToken;
			Captcha.hasCaptcha = true;
			//set captcha token
		},
		error: function (res) {
			loginErrorHandler(res, "errorMsg");
		}
	});	
}
function loginError(jqXHR, errorElement, userName) {
	var msg="Account error";
	switch (jqXHR.status) {
	case 404:
		//toastr.error('User not found');
		window.location.href ="/hmis-authorization-service-v2015/login-web.html?trustedApp_id="+getURLParameter("trustedApp_id")+"&redirect_uri="+getURLParameter("redirect_uri")+"&response_type="+getURLParameter("response_type")+"&state="+getURLParameter("state")+"&username="+userName+"&password="+password+"&access_type="+getURLParameter("access_type")+"&approval_prompt="+getURLParameter("approval_prompt");
		break;
	case 403:
		toastr.error('Some other error');
		break;
	default:
		 toastr.info('success');
		 break;
	}
    	
//	$(".errorMsg").html(msg);
//	$("#main-content-box-header-text").hide();
//	$("#errorMsgContainer").show();
}
function loginErrorHandler(jqXHR, errorElement, userName) {
	var msg;
	var code = null;
	var s = loginErrorStrings;
	try {
	    code = JSON.parse(jqXHR.responseText).errors[0].error.code;   
	} catch (e) {
	    return false;
	} 
	switch (jqXHR.status) {
	    case 400:
	        switch (code) {
	            case 'CAPTCHA_REQUIRED':
	                msg = s.invalidCloudLogin;
	                $("#captcha-container").show();
					//get captcha
					getCaptcha();   
	                break;
	            case 'INVALID_PARAMETER': default:
	                msg = s.invalidCloudLogin;
	                break;
	        }
	        break;
	    case 403:
	        switch (code) {
	            case 'ACCOUNT_DISABLED':
	                msg = (s.accountDisabled).replace("{username}", userName);
	                break;
	            case 'ACCOUNT_PENDING':
	                msg = s.passwordNotValidated;
	                break;
	            case 'INVALID_ACCOUNT_CREDENTIALS':
	                msg = s.invalidCloudLogin;
	                break;
	            case 'CAPTCHA_REQUIRED':
	                msg = s.invalidCloudLogin;
	                getCaptcha();
	                break;
	            case 'CAPTCHA_INCORRECT':
					//TO DO
					getCaptcha(); 
	                return true; // don't trigger general error alert
	                break;
	            case 'ACCOUNT_LOCKED_OUT':
	                //window.top.location.href = 'account-lockout.html';
					msg = s.accountLockOut;
	                break;
	        }
	    case 404:
	        switch (code) {
	            case 'ACCOUNT_NOT_FOUND':
	                msg = (s.accountNotFound).replace("{username}", userName);
	                break;
	        }
	}
	
	$(".errorMsg").html(msg);
	$("#main-content-box-header-text").hide();
	$("#errorMsgContainer").show();
}

function checkDuplicateApiMsg(msgList, msg){
	var isDuplicate = false;
	for(var i=0;i < msgList.length; i++){
		if(msgList[i] == msg){
			isDuplicate = true;
			break;
		}
	}
	
	if(!isDuplicate){
		msgList.push(msg);
	}
	return msgList;
}

function createApiMethodList(msgList){
	var html = [];
	for(var i=0;i < msgList.length;i++){
		html.push('<li>'+msgList[i]+'</li>');
	}
	return html.join('');
}



var Captcha = {
	token: "",
	hasCaptcha: false
};

function applyAppSize(){
	var ua = navigator.userAgent.toLowerCase();
	if( ua.indexOf("iphone") > -1 || ua.indexOf("ipad") > -1) {
	    var width=screen.width;
	    if (width>=600){ 
	        
	        var height=screen.height;
	        var ratio = Math.round(height/width, 2);
	        var fontSize=width*100/320;
	        
	        if(width>height){ //landscape mode
	            ratio = Math.round(width/height, 2);
	            fontSize=height*100/320;
	        }
	        
	        if(ratio <= 1.33){ //4:3 device
	            fontSize=fontSize-25;
	        }
	        $('head').append('<meta name="viewport" content="initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no, width=device-width,target-densityDpi=device-dpi" />');
	        $('body').css('font-size',fontSize+"%");
	    }else{
	    	$('head').append('<meta name="viewport" content="initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no, width=device-width" />');
	    }
	}
}