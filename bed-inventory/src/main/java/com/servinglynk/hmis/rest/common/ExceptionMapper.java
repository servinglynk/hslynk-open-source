package com.servinglynk.hmis.rest.common;

import static com.servinglynk.hmis.warehouse.common.ErrorCodes.ERR_CODE_ACCESS_DENIED;
import static com.servinglynk.hmis.warehouse.common.ErrorCodes.ERR_CODE_INVALID_PARAMETER;
import static com.servinglynk.hmis.warehouse.common.ErrorCodes.ERR_CODE_UNKNOWN;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.servinglynk.hmis.service.exception.ResourceAlreadyExists;
import com.servinglynk.hmis.service.exception.ResourceNotFoundException;
import com.servinglynk.hmis.service.exception.RestClientException;
import com.servinglynk.hmis.warehouse.core.model.Error;
import com.servinglynk.hmis.warehouse.core.model.exception.AccessDeniedException;
import com.servinglynk.hmis.warehouse.core.model.exception.InvalidParameterException;


public class ExceptionMapper {

	protected final Logger logger = LoggerFactory.getLogger(getClass());

	// error messages
	public static final String ERR_MSG_UNKNOWN = "unexpected error occurred";

	public Result map(Throwable th, HttpServletRequest request) {
		
		Result r = new Result();

		try {

			throw th;
		}catch (ResourceNotFoundException e) {
			logger.info("ResourceNotFoundException: " + e.getMessage(), e);
			r.setStatusCode(HttpServletResponse.SC_NOT_FOUND);
			r.setErrorCode("ERR_CODE_NOT_FOUND");
			r.setErrorMessage(e.getMessage());
		} 
		catch (InvalidParameterException ex) {

			logger.info("InvalidParameterException: " + ex.getMessage(), ex);
			r.setStatusCode(HttpServletResponse.SC_BAD_REQUEST);
			r.setErrorCode(ERR_CODE_INVALID_PARAMETER);
			r.setErrorMessage(ex.getMessage());

		} catch (AccessDeniedException ex) {

			logger.info("AccessDeniedException: " + ex.getMessage(), ex);
			r.setStatusCode(HttpServletResponse.SC_FORBIDDEN);
			r.setErrorCode(ERR_CODE_ACCESS_DENIED);
			r.setErrorMessage(ex.getMessage());

		}catch (RestClientException e) {
			logger.info("RestClientException: " + e.getMessage(), e);
			r.setErrorMessage(e.getMessage());
			r.setStatusCode(e.getStatus());
			r.setErrorCode(e.getCode());
		}catch (ResourceAlreadyExists ex) {

			logger.info("ResourceAlreadyExists: " + ex.getMessage(), ex);
			r.setStatusCode(HttpServletResponse.SC_CONFLICT);
			r.setErrorCode("RESOURCE_ALREADY_EXISTS");
			r.setErrorMessage(ex.getMessage());

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
					r.setErrorMessage(ERR_MSG_UNKNOWN + " : " + t.getMessage());

        	}
		}

		

		return r;
	}


	/************************** Nested Classes *******************************/

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
