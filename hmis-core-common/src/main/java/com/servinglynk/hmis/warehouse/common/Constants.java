package com.servinglynk.hmis.warehouse.common;

/* 05/20/2015 - All constants related to HTTP headers ,  TrustedApp, Developer company, Developer company service constants, OAUTH */

public interface Constants {

	public static final String TRUSTEDAPP_HEADER         	        = "X-HMIS-TrustedApp-Id";
    public static final String USER_AUTHENTICATION_HEADER 	        = "X-HMIS-HN-User-Authentication";

	public static final String AUTHORIZATION_HEADER         	= "Authorization";
	public static final String ACCEPT_HEADER ="Accept";
	public static final String JSON_ACCEPT_HEADER_VALUE ="application/json";
	public static final String XML_ACCEPT_HEADER_VALUE ="application/xml";
	public static final String TEXT_PLAIN_ACCEPT_HEADER_VALUE ="text/plain";
	public static final String CONTENT_TYPE_HEADER="Content-Type";
	public static final String JSON_CONTENT_TYPE_VALUE = "application/json; charset=UTF-8";

	public static final String TRUSTEDAPP_STATUS_ACTIVE         = "ACTIVE";
	public static final String TRUSTEDAPP_STATUS_DISABLED       = "DISABLED";	
	public static final String TRUSTEDAPP_STATUS_IN_DEVELOPMENT = "IN_DEVELOPMENT";	
	public static final String TRUSTEDAPP_STATUS_SUBMITTED      = "SUBMITTED";
	
	public static final String SERVICE_STATUS_ACTIVE         = "ACTIVE";
	public static final String SERVICE_STATUS_DISABLED       = "DISABLED";	
	public static final String SERVICE_STATUS_IN_DEVELOPMENT = "IN_DEVELOPMENT";	
	public static final String SERVICE_STATUS_SUBMITTED      = "SUBMITTED";
	public static final String SERVICE_STATUS_APPROVED      = "APPROVED";
	public static final String SERVICE_STATUS_REJECTED      = "REJECTED";
	
	public static final String DC_STATUS_ACTIVE         = "ACTIVE";
	public static final String DC_STATUS_DISABLED       = "DISABLED";	
	public static final String DC_STATUS_REJECTED = "REJECTED";	
	public static final String DC_STATUS_SUBMITTED      = "SUBMITTED";

	
	public static final String OAUTH_AUTHORIZATION_CODE = "authorization_code";
	public static final String OAUTH_REFRESH_TOKEN = "refresh_token";
	public static final String OAUTH_IMPLICIT = "implicit";
	public static final String OAUTH_ACCESS_TYPE_ONLINE = "online";	
	public static final String OAUTH_ACCESS_TYPE_OFFLINE = "offline";
	public static final String OAUTH_APPROVAL_PROMPT_FORCE = "force";	
	public static final String OAUTH_APPROVAL_PROMPT_AUTO = "auto";
	public static final String OAUTH_RESPONSE_TYPE_CODE = "code";
	public static final String OAUTH_RESPONSE_TYPE_TOKEN = "token";
	public static final int    OAUTH_FLOW_REQUEST_CONSENT = 1;
	public static final int    OAUTH_FLOW_REDIRECT_AUTH_CODE_TO_TRUSTEDAPP = 2;
	public static final int    OAUTH_FLOW_REDIRECT_ACCESS_TOKEN_TO_TRUSTEDAPP = 3;
	public static final int    OAUTH_FLOW_LOGIN = 4;
	public static final String OAUTH_AUTHENTICATION_COOKIE = "authentication_token";
	public static final String OAUTH_ACCOUNT_CONSENT_NEVER = "NEVER";
	public static final String OAUTH_ACCOUNT_CONSENT_ONCE = "ONCE";
	public static final int TWO_FACTOR_AUTH_FLOW_OPT= 1;
	
	
	// developer company account roles
	public static final String DEVELOPER_ACCOUNT_ROLE_ADMIN = "ADMIN";
	public static final String DEVELOPER_ACCOUNT_ROLE_BASIC = "BASIC";


	public static final String BASIC_AUTH_REALM = "Basic";
	
	public static final String TRUSTEDAPP_PROFILE_TYPE_NATIVE = "NATIVE";
	public static final String TRUSTEDAPP_PROFILE_TYPE_SERVER_SIDE_WEB_APP = "SERVER_SIDE_WEB_APP";
	public static final String TRUSTEDAPP_PROFILE_TYPE_TRUSTEDAPP_SIDE_WEB_APP = "TRUSTEDAPP_SIDE_WEB_APP";
	
	public static final String TRUSTEDAPP_FAMILY_TYPE_APP = "APP";
	public static final String TRUSTEDAPP_FAMILY_TYPE_CC_CONTAINER = "CC_CONTAINER";
	public static final String TRUSTEDAPP_FAMILY_TYPE_CC_CONTAINER_APP = "CC_CONTAINER_APP";
	
//	07/19/2015 - Added Constants related to developer_service , user_service and Authorization_services 
	
	public static final String VERIFICATION_TYPE_ACCOUNT_CREATION="ACCOUNT_CREATION";
	public static final String VERIFICATION_TYPE_USERNAME_CHANGE="USERNAME_CHANGE";
	public static final String VERIFICATION_STATUS_REJECTED="REJECTED";
	public static final String VERIFICATION_STATUS_ACCEPTED="ACCEPTED";
	public static final String ACCOUNT_STATUS_PENDING="PENDING";
	public static final String ACCOUNT_STATUS_ACTIVE="ACTIVE";
	public static final String ACCOUNT_STATUS_DISABLED="DISABLED";
	public static final String ACCOUNT_STATUS_NONEXISTENT="NONEXISTENT";
	
	public static final String DEVELOPER_CONSOLE_SERVICE="DEVELOPER_CONSOLE_SERVICE";
	public static final String VERIFICATION_TYPE_PASSWORD_RESET="PASSWORD_RESET";
	public static final String PASSWORD_RESET_STATUS_CREATED="CREATED";
	public static final String PASSWORD_RESET_STATUS_ACCEPTED="ACCEPTED";
	public static final String PASSWORD_RESET_STATUS_REJECTED="REJECTED";
	
	public static final String SESSION_SERVICE="SESSION_SERVICE";
	public static final String USER_SERVICE="USER_SERVICE";
	public static final String AUTHORIZATION_SERVICE="AUTHORIZATION_SERVICE";
	
	public static final String INTERNAL_USERNAME_DOMAIN_NAME="hmis.com";

	public static final String AUDIT_USER_UNIT_TEST="unit-test";
	
	public static final String ALPHA_CAPS  = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static final String ALPHA   = "abcdefghijklmnopqrstuvwxyz";
	public static final String NUM     = "0123456789";
	public static final String SPL_CHARS   = "!@#$*";


}
