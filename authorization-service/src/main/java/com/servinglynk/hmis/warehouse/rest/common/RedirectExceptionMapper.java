package com.servinglynk.hmis.warehouse.rest.common;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.servinglynk.hmis.warehouse.common.Constants;
import com.servinglynk.hmis.warehouse.service.exception.InvalidRedirectUriException;


public class RedirectExceptionMapper extends OAuthExceptionMapper {

	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	//@Autowired
	private String errorUri="";
	
	public String mapRedirect(Throwable th, HttpServletRequest request) {

		Result r = new Result();
		String redirectUri = request.getParameter("redirect_uri");

		try {
			
			throw th;

		} catch (InvalidRedirectUriException ex) {

			logger.info("InvalidRedirectUriException: " + ex.getMessage(), ex);
			redirectUri = errorUri + "?error=InvalidRedirectUriException";
			return redirectUri;

		} catch (Throwable t) {

			r = map(t, request);
			redirectUri = errorUri +"?error="+r.getError().getErrorDescription();
		}

/*		// use HASH for IMPLICIT GRANT FLOWS
		String hashOrQM = Constants.OAUTH_RESPONSE_TYPE_TOKEN.equals(request.getParameter("response_type")) ? "#" : "?";
		// append the error code
		redirectUri = redirectUri + hashOrQM + "error="+r.getError().getError();
		
		// append error description if any 
		if (!StringUtils.isBlank(r.getError().getErrorDescription()))	{
			redirectUri = redirectUri + "&error_description=" + r.getError().getErrorDescription();
		}
		
		// append state if any
		if (!StringUtils.isBlank(request.getParameter("state")))	{
			redirectUri = redirectUri + "&state=" + request.getParameter("state");
		}*/
		
		return redirectUri;
	}
}
