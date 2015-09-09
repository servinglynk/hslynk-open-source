package com.servinglynk.hmis.warehouse.rest.common;

import static com.servinglynk.hmis.warehouse.common.ErrorCodes.ERR_CODE_ACCESS_DENIED;
import static com.servinglynk.hmis.warehouse.common.ErrorCodes.ERR_CODE_ILLEGAL_STATE;
import static com.servinglynk.hmis.warehouse.common.ErrorCodes.ERR_CODE_INVALID_PARAMETER;
import static com.servinglynk.hmis.warehouse.common.ErrorCodes.ERR_CODE_INVALID_SESSION_TOKEN;
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
import com.servinglynk.hmis.warehouse.core.model.exception.InvalidSessionTokenException;
import com.servinglynk.hmis.warehouse.core.model.exception.MissingParameterException;
import com.servinglynk.hmis.warehouse.service.exception.AccountNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.ApiMethodNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.DeveloperCompanyAccountAlreadyExistsException;
import com.servinglynk.hmis.warehouse.service.exception.DeveloperCompanyAccountNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.DeveloperCompanyNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.DeveloperCompanyOwnerDissociationNotAllowedException;
import com.servinglynk.hmis.warehouse.service.exception.DuplicateDataException;
import com.servinglynk.hmis.warehouse.service.exception.InvalidApiMethodException;
import com.servinglynk.hmis.warehouse.service.exception.InvalidRedirectUriException;
import com.servinglynk.hmis.warehouse.service.exception.ServiceAlreadyExistsException;
import com.servinglynk.hmis.warehouse.service.exception.ServiceNotFoundException;


public class ExceptionMapper {

	protected final Logger logger = LoggerFactory.getLogger(getClass());

	// error codes
	public static final String ERR_CODE_DEVELOPER_COMPANY_NOT_FOUND                 = "DEVELOPER_COMPANY_NOT_FOUND";
	public static final String ERR_CODE_DEVELOPER_COMPANY_OWNER_DISSOC_NOT_ALLOWED  = "DEVELOPER_COMPANY_OWNER_DISSOC_NOT_ALLOWED";
	public static final String ERR_CODE_DEVELOPER_COMPANY_ACCOUNT_NOT_FOUND         = "DEVELOPER_COMPANY_ACCOUNT_NOT_FOUND";
	public static final String ERR_CODE_DEVELOPER_COMPANY_ACCOUNT_ALREADY_EXISTS    = "DEVELOPER_COMPANY_ACCOUNT_ALREADY_EXISTS";
	public static final String ERR_CODE_ACCOUNT_NOT_FOUND                           = "ACCOUNT_NOT_FOUND";	
	public static final String ERR_CODE_SERVICE_NOT_FOUND                           = "SERVICE_NOT_FOUND";
	public static final String ERR_CODE_API_METHOD_NOT_FOUND                        = "API_METHOD_NOT_FOUND";	
	public static final String ERR_CODE_SERVICE_ALREADY_EXISTS                      = "SERVICE_ALREADY_EXISTS";
	public static final String ERR_CODE_DUPLICATE_DATA                      		= "DUPLICATE_DATA";
	public static final String ERR_CODE_INVALID_REDIRECT_URI                      	= "INVALID_REDIRECT_URI";
	public static final String ERR_CODE_INVALID_API_METHOD                      	= "INVALID_API_METHOD";	
	public static final String ERR_CODE_API_DEPRECATED                      		= "DEPRECATED_API_METHOD";	
	public static final String ERR_CODE_CATEGORY_NOT_FOUND                      	= "CATEGORY_NOT_FOUND";	
	public static final String ERR_CODE_PLATFORM_NOT_FOUND                      	= "PLATFORM_NOT_FOUND";	
	public static final String ERR_CODE_LOCALE_NOT_FOUND                      		= "LOCALE_NOT_FOUND";	
	public static final String ERR_CODE_DEVICE_MODEL_NUMBER_NOT_FOUND               = "DEVICE_MODEL_NUMBER_NOT_FOUND";	
	public static final String ERR_CODE_INVALID_DEVICE_COMPATIBILITY                = "INVALID_DEVICE_COMPATIBILITY";	
	public static final String ERR_CODE_INVALID_PLATFORM                      		= "INVALID_PLATFORM ";	
	public static final String ERR_CODE_INVALID_LOCALE                      		= "INVALID_LOCALE";	
	public static final String ERR_CODE_INVALID_CATEGORY                   			= "INVALID_CATEGORY";	
	public static final String ERR_CODE_INVALID_UPLOAD_ITEM                   		= "INVALID_UPLOAD_ITEM";	
	public static final String ERR_CODE_UPLOAD_ITEM_NOT_FOUND                   	= "UPLOAD_ITEM_NOT_FOUND";	
	public static final String ERR_CODE_PARAMETER_NOT_FOUND							= "PARAMETER_NOT_FOUND";
	
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

		} catch (AccountNotFoundException ex) {
			logger.info("AccountNotFoundException: " + ex.getMessage(), ex);
			r.setStatusCode(HttpServletResponse.SC_NOT_FOUND);
			r.setErrorCode(ERR_CODE_ACCOUNT_NOT_FOUND);
			r.setErrorMessage(ex.getMessage());

		} catch (ApiMethodNotFoundException ex) {
			logger.info("ApiMethodNotFoundException: " + ex.getMessage(), ex);
			r.setStatusCode(HttpServletResponse.SC_NOT_FOUND);
			r.setErrorCode(ERR_CODE_API_METHOD_NOT_FOUND);
			r.setErrorMessage(ex.getMessage());

		} catch (DeveloperCompanyAccountAlreadyExistsException ex) {
			logger.info("DeveloperCompanyAccountAlreadyExistsException: " + ex.getMessage(), ex);
			r.setStatusCode(HttpServletResponse.SC_CONFLICT);
			r.setErrorCode(ERR_CODE_DEVELOPER_COMPANY_ACCOUNT_ALREADY_EXISTS);
			r.setErrorMessage(ex.getMessage());

		} catch (DeveloperCompanyAccountNotFoundException ex) {
			logger.info("DeveloperCompanyAccountNotFoundException: " + ex.getMessage(), ex);
			r.setStatusCode(HttpServletResponse.SC_CONFLICT);
			r.setErrorCode(ERR_CODE_DEVELOPER_COMPANY_ACCOUNT_NOT_FOUND);
			r.setErrorMessage(ex.getMessage());

		} catch (DeveloperCompanyNotFoundException ex) {
			logger.info("DeveloperCompanyNotFoundException: " + ex.getMessage(), ex);
			r.setStatusCode(HttpServletResponse.SC_NOT_FOUND);
			r.setErrorCode(ERR_CODE_DEVELOPER_COMPANY_NOT_FOUND);
			r.setErrorMessage(ex.getMessage());

		} catch (ServiceNotFoundException ex) {
			logger.info("ServiceNotFoundException: " + ex.getMessage(), ex);
			r.setStatusCode(HttpServletResponse.SC_NOT_FOUND);
			r.setErrorCode(ERR_CODE_SERVICE_NOT_FOUND);
			r.setErrorMessage(ex.getMessage());

		} catch (ServiceAlreadyExistsException ex) {

			logger.info("AccessDeniedException: " + ex.getMessage(), ex);
			r.setStatusCode(HttpServletResponse.SC_CONFLICT);
			r.setErrorCode(ERR_CODE_SERVICE_ALREADY_EXISTS);
			r.setErrorMessage(ex.getMessage());

		}catch (DeveloperCompanyOwnerDissociationNotAllowedException ex) {
			logger.info("DeveloperCompanyOwnerDissociationNotAllowedException: " + ex.getMessage(), ex);
			r.setStatusCode(HttpServletResponse.SC_FORBIDDEN);
			r.setErrorCode(ERR_CODE_DEVELOPER_COMPANY_OWNER_DISSOC_NOT_ALLOWED);
			r.setErrorMessage(ex.getMessage());

		} catch (InvalidSessionTokenException ex) {
			
			logger.info("InvalidSessionTokenException: " + ex.getMessage());
			r.setStatusCode(HttpServletResponse.SC_UNAUTHORIZED);
			r.setErrorCode(ERR_CODE_INVALID_SESSION_TOKEN);
			r.setErrorMessage(ex.getMessage());
			
		}  catch (DuplicateDataException ex) {
			logger.info("DuplicateDataException: " +ex.getMessage());
			r.setStatusCode(HttpServletResponse.SC_CONFLICT);
			r.setErrorCode(ERR_CODE_DUPLICATE_DATA);
			r.setErrorMessage(ex.getMessage());
		} catch (InvalidRedirectUriException ex) {
			logger.info("InvalidRedirectUriException: " +ex.getMessage());
			r.setStatusCode(HttpServletResponse.SC_BAD_REQUEST);
			r.setErrorCode(ERR_CODE_INVALID_REDIRECT_URI);
			r.setErrorMessage(ex.getMessage());
		} catch (InvalidApiMethodException ex) {
			logger.info("InvalidApiMethodException: " +ex.getMessage());
			r.setStatusCode(HttpServletResponse.SC_BAD_REQUEST);
			r.setErrorCode(ERR_CODE_INVALID_API_METHOD);
			r.setErrorMessage(ex.getMessage());
		}  catch (Throwable t) {
        	
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
