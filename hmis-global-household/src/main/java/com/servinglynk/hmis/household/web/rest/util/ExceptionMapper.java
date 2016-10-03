package com.servinglynk.hmis.household.web.rest.util;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.client.HttpClientErrorException;

public class ExceptionMapper {

	private final String ERR_CODE_INVALID_PARAMETER ="";
	private final String ERR_CODE_UNKNOWN ="";
	
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	// error messages
	public static final String ERR_MSG_UNKNOWN = "unexpected error occurred";

	// query parameter names
	public static final String PARAM_NAME_SC_200_ONLY = "sc200Only";

	private boolean internalErrorMessageReturned;
	
	public Result map(Throwable th, HttpServletRequest request) {

		Result r = new Result();

		try {
			th.printStackTrace();

			throw th;
		} catch (HttpClientErrorException ex) {
			logger.info(ex.getMessage());
			logger.error(ex.getMessage(), ex);
			r.setErrorCode("REQUEST_AUTHENTICATION_FAILED");
			r.setErrorMessage("REQUEST_AUTHENTICATION_FAILED");
			r.setStatusCode(HttpServletResponse.SC_FORBIDDEN);
		}catch (ResourceNotFoundException ex) {
			logger.info(ex.getMessage());
			logger.error(ex.getMessage(), ex);
			r.setErrorCode("RESOURCE_NOT_FOUND");
			r.setErrorMessage(ex.getMessage());
			r.setStatusCode(HttpServletResponse.SC_NOT_FOUND);
		}
		catch (org.springframework.http.converter.HttpMessageNotReadableException ex) {
			logger.info(ex.getMessage());
			logger.error(ex.getMessage(), ex);
			r.setErrorCode("INVALID_REQUEST_DATA");
			r.setErrorMessage("Invalid request data");
			r.setStatusCode(HttpServletResponse.SC_BAD_REQUEST);

		} 
		catch (Throwable t) {
    	
		logger.error(t.getMessage(), t);

		if (t.getCause().getClass().getName().endsWith("UnmarshallingFailureException"))	{
			r.setStatusCode(HttpServletResponse.SC_BAD_REQUEST);
			r.setErrorCode(ERR_CODE_INVALID_PARAMETER);
			r.setErrorMessage("Invalid payload");
    	}
    	else	{
			r.setStatusCode(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			r.setErrorCode(ERR_CODE_UNKNOWN);
			if (isInternalErrorMessageReturned()) {
				r.setErrorMessage(ERR_MSG_UNKNOWN + " : " + t.getMessage());
			} else {
				r.setErrorMessage(ERR_MSG_UNKNOWN);
			}
    	}
	}

	if (returnStatusCode200Only(request)) {
		r.setStatusCode(HttpServletResponse.SC_OK);
	}

	return r;
}


@SuppressWarnings("rawtypes")
private boolean returnStatusCode200Only(HttpServletRequest request) {
	boolean sc200Only = false;
	Map parameterMap = request.getParameterMap();
	if (parameterMap != null) {
		sc200Only = parameterMap.keySet().contains(PARAM_NAME_SC_200_ONLY);
	}

	return sc200Only;
}

public boolean isInternalErrorMessageReturned() {
	return internalErrorMessageReturned;
}

public void setInternalErrorMessageReturned(boolean internalErrorMessageReturned) {
	this.internalErrorMessageReturned = internalErrorMessageReturned;
}



public static class Result {

	private int statusCode;
	private Error error = new Error();

	public int getStatusCode() {

		return statusCode;

	}

	public void setStatusCode(int statusCode) {

		this.statusCode = statusCode;

	}

	public Error getError() {

		return error;

	}

	public void setErrorCode(String errorCode) {

		this.error.setCode(errorCode);

	}

	public void setErrorMessage(String errorMessage) {

		this.error.setMessage(errorMessage);

	}

}
	
}