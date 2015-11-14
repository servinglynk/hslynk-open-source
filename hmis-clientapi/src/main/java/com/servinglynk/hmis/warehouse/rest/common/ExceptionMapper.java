package com.servinglynk.hmis.warehouse.rest.common;

import static com.servinglynk.hmis.warehouse.common.ErrorCodes.ERR_CODE_ACCESS_DENIED;
import static com.servinglynk.hmis.warehouse.common.ErrorCodes.ERR_CODE_ILLEGAL_STATE;
import static com.servinglynk.hmis.warehouse.common.ErrorCodes.ERR_CODE_INVALID_PARAMETER;
import static com.servinglynk.hmis.warehouse.common.ErrorCodes.ERR_CODE_MISSING_PARAMETER;
import static com.servinglynk.hmis.warehouse.common.ErrorCodes.ERR_CODE_UNKNOWN;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.servinglynk.hmis.warehouse.core.model.Error;
import com.servinglynk.hmis.warehouse.core.model.exception.AccessDeniedException;
import com.servinglynk.hmis.warehouse.core.model.exception.IllegalBusinessStateException;
import com.servinglynk.hmis.warehouse.core.model.exception.InvalidParameterException;
import com.servinglynk.hmis.warehouse.core.model.exception.MissingParameterException;
import com.servinglynk.hmis.warehouse.service.exception.ClientNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.EmploymentNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.EnrollmentNotFound;
import com.servinglynk.hmis.warehouse.service.exception.ExitNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.ProjectNotFoundException;


public class ExceptionMapper {

	protected final Logger logger = LoggerFactory.getLogger(getClass());

	
	// error codes
	public static final String ERR_CODE_PARAMETER_NOT_FOUND							= "PARAMETER_NOT_FOUND";
	public static final String ERR_CODE_CLIENT_NOT_FOUND							= "CLIENT_NOT_FOUND";
	public static final String ERR_CODE_ENROLLMENT_NOT_FOUND						= "ENROLLMENT_NOT_FOUND";
	public static final String ERR_CODE_EXIT_NOT_FOUND								= "EXIT_NOT_FOUND";
	public static final String ERR_CODE_EMPLOYMENT_NOT_FOUND						= "EMPLOYMENT_NOT_FOUND";
	public static final String ERR_CODE_PROJECT_NOT_FOUND						    = "PROJECT_NOT_FOUND";	
	
	// error messages
	public static final String ERR_MSG_UNKNOWN = "unexpected error occurred";

	// query parameter names
	public static final String PARAM_NAME_SC_200_ONLY = "sc200Only";

	private boolean internalErrorMessageReturned;

	public Result map(Throwable th, HttpServletRequest request) {
		
		Result r = new Result();

		try {

			throw th;
		}  catch (InvalidParameterException ex) {

			logger.info("InvalidParameterException: " + ex.getMessage(), ex);
			r.setStatusCode(HttpServletResponse.SC_BAD_REQUEST);
			r.setErrorCode(ERR_CODE_INVALID_PARAMETER);
			r.setErrorMessage(ex.getMessage());

		} catch (AccessDeniedException ex) {

			logger.info("AccessDeniedException: " + ex.getMessage(), ex);
			r.setStatusCode(HttpServletResponse.SC_FORBIDDEN);
			r.setErrorCode(ERR_CODE_ACCESS_DENIED);
			r.setErrorMessage(ex.getMessage());

		} catch (IllegalBusinessStateException ex) {

			logger.info("IllegalBusinessStateException: " + ex.getMessage(), ex);
			r.setStatusCode(HttpServletResponse.SC_FORBIDDEN);
			r.setErrorCode(ERR_CODE_ILLEGAL_STATE);
			r.setErrorMessage(ex.getMessage());

		} catch (MissingParameterException ex) {

			logger.info("MissingParameterException: " + ex.getMessage(), ex);
			r.setStatusCode(HttpServletResponse.SC_BAD_REQUEST);
			r.setErrorCode(ERR_CODE_MISSING_PARAMETER);
			r.setErrorMessage(ex.getMessage());

		} catch(ClientNotFoundException ex){
			logger.info("ClientNotFoundException: " + ex.getMessage(), ex);
			r.setStatusCode(HttpServletResponse.SC_NOT_FOUND);
			r.setErrorCode(ERR_CODE_CLIENT_NOT_FOUND);
			r.setErrorMessage(ex.getMessage());
		} catch(EnrollmentNotFound ex){
			logger.info("EnrollmentNotFound: " + ex.getMessage(), ex);
			r.setStatusCode(HttpServletResponse.SC_NOT_FOUND);
			r.setErrorCode(ERR_CODE_ENROLLMENT_NOT_FOUND);
			r.setErrorMessage(ex.getMessage());			
		}catch(ExitNotFoundException ex){
			logger.info("ExitNotFoundException: " + ex.getMessage(), ex);
			r.setStatusCode(HttpServletResponse.SC_NOT_FOUND);
			r.setErrorCode(ERR_CODE_EXIT_NOT_FOUND);
			r.setErrorMessage(ex.getMessage());			
		}catch(EmploymentNotFoundException ex){
			logger.info("EmploymentNotFoundException: " + ex.getMessage(), ex);
			r.setStatusCode(HttpServletResponse.SC_NOT_FOUND);
			r.setErrorCode(ERR_CODE_EMPLOYMENT_NOT_FOUND);
			r.setErrorMessage(ex.getMessage());			
		}catch(ProjectNotFoundException ex){
			logger.info("ProjectNotFoundException: " + ex.getMessage(), ex);
			r.setStatusCode(HttpServletResponse.SC_NOT_FOUND);
			r.setErrorCode(ERR_CODE_PROJECT_NOT_FOUND);
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
