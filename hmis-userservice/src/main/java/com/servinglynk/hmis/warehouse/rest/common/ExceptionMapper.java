package com.servinglynk.hmis.warehouse.rest.common;

import static com.servinglynk.hmis.warehouse.common.ErrorCodes.ERR_CODE_ACCESS_DENIED;
import static com.servinglynk.hmis.warehouse.common.ErrorCodes.ERR_CODE_ILLEGAL_STATE;
import static com.servinglynk.hmis.warehouse.common.ErrorCodes.ERR_CODE_INVALID_PARAMETER;
import static com.servinglynk.hmis.warehouse.common.ErrorCodes.ERR_CODE_INVALID_SESSION_TOKEN;
import static com.servinglynk.hmis.warehouse.common.ErrorCodes.ERR_CODE_INVALID_TRUSTEDAPP_TYPE;
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
import com.servinglynk.hmis.warehouse.core.model.exception.InvalidTrustedAppException;
import com.servinglynk.hmis.warehouse.core.model.exception.MissingParameterException;
import com.servinglynk.hmis.warehouse.core.model.exception.TrustedAppNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.AccountAlreadyExistsException;
import com.servinglynk.hmis.warehouse.service.exception.AccountNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.AccountPendingException;
import com.servinglynk.hmis.warehouse.service.exception.ApiMethodNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.DeveloperCompanyAccountAlreadyExistsException;
import com.servinglynk.hmis.warehouse.service.exception.DeveloperCompanyAccountNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.DeveloperCompanyNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.DeveloperCompanyOwnerDissociationNotAllowedException;
import com.servinglynk.hmis.warehouse.service.exception.DuplicateDataException;
import com.servinglynk.hmis.warehouse.service.exception.EnrollmentNotFound;
import com.servinglynk.hmis.warehouse.service.exception.InvalidApiMethodException;
import com.servinglynk.hmis.warehouse.service.exception.InvalidCurrentPasswordException;
import com.servinglynk.hmis.warehouse.service.exception.InvalidRedirectUriException;
import com.servinglynk.hmis.warehouse.service.exception.OrganizationNotFound;
import com.servinglynk.hmis.warehouse.service.exception.PermissionSetNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.ProfileNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.ReleaseOfInfoNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.RoleNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.ServiceAlreadyExistsException;
import com.servinglynk.hmis.warehouse.service.exception.ServiceNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.SharingRuleNotFound;


public class ExceptionMapper {

	protected final Logger logger = LoggerFactory.getLogger(getClass());

	
	// error codes
	public static final String ERR_CODE_DEVELOPER_COMPANY_NOT_FOUND                 = "DEVELOPER_COMPANY_NOT_FOUND";
	public static final String ERR_CODE_DEVELOPER_COMPANY_OWNER_DISSOC_NOT_ALLOWED  = "DEVELOPER_COMPANY_OWNER_DISSOC_NOT_ALLOWED";
	public static final String ERR_CODE_DEVELOPER_COMPANY_ACCOUNT_NOT_FOUND         = "DEVELOPER_COMPANY_ACCOUNT_NOT_FOUND";
	public static final String ERR_CODE_DEVELOPER_COMPANY_ACCOUNT_ALREADY_EXISTS    = "DEVELOPER_COMPANY_ACCOUNT_ALREADY_EXISTS";
	public static final String ERR_CODE_ACCOUNT_NOT_FOUND                           = "ACCOUNT_NOT_FOUND";	
	public static final String ERR_CODE_SERVICE_NOT_FOUND                           = "SERVICE_NOT_FOUND";
	public static final String ERR_CODE_TRUSTEDAPP_NOT_FOUND                        = "TRUSTEDAPP_NOT_FOUND";	
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
	public static final String ERR_CODE_ACCOUNT_ALREADY_EXISTS						= "ERR_CODE_ACCOUNT_ALREADY_EXISTS";
	public static final String ERR_CODE_INVALID_CURRENT_PASSWORD					= "ERR_CODE_INVALID_CURRENT_PASSWORD";
	public static final String ERR_CODE_INVALID_ACCOUNT_CREDENTIALS					= "ERR_CODE_INVALID_ACCOUNT_CREDENTIALS";
	public static final String ERR_CODE_ACCOUNT_STATUS_PENDING						= "ERR_CODE_ACCOUNT_STATUS_PENDING";
	public static final String ERR_CODE_PROFILE_NOT_FOUND   						= "ERR_CODE_PROFILE_NOT_FOUND";
	public static final String ERR_CODE_ROLE_NOT_FOUND								= "ERR_CODE_ROLE_NOT_FOUND";
	public static final String ERR_CODE_PERMISSION_SET_NOT_FOUND					= "ERR_CODE_PERMISSION_SET_NOT_FOUND";
	public static final String ERR_CODE_SHARING_RULE_NOT_FOUND						= "ERR_CODE_SHARING_RULE_NOT_FOUND";
	public static final String ERR_CODE_ORGANIZATION_NOT_FOUND						= "ERR_CODE_ORGANIZATION_NOT_FOUND";
	public static final String ERR_CODE_ENROLLMENT_NOT_FOUND						= "ERR_CODE_ENROLLMENT_NOT_FOUND";
	public static final String ERR_CODE_PROJECT_NOT_FOUND						    = "ERR_CODE_PROJECT_NOT_FOUND";
	public static final String ERR_CODE_RELEASE_OF_INFO_NOT_FOUND					= "ERR_CODE_RELEASE_OF_INFO_NOT_FOUND";
	
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
			
		} catch (TrustedAppNotFoundException ex) {
			logger.info("TrustedAppNotFoundException: " + ex.getMessage());
			r.setStatusCode(HttpServletResponse.SC_NOT_FOUND);
			r.setErrorCode(ERR_CODE_TRUSTEDAPP_NOT_FOUND);
			r.setErrorMessage(ex.getMessage());
		} catch (DuplicateDataException ex) {
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
		} catch (InvalidTrustedAppException ex) {
			logger.info("InvalidTrustedAppException: " + ex.getMessage());
			r.setStatusCode(HttpServletResponse.SC_FORBIDDEN);
			r.setErrorCode(ERR_CODE_INVALID_TRUSTEDAPP_TYPE);
			r.setErrorMessage(ex.getMessage());
		}  catch (AccountAlreadyExistsException ex) {
			logger.info("AccountAlreadyExistsException: " +ex.getMessage());
			r.setStatusCode(HttpServletResponse.SC_CONFLICT);
			r.setErrorCode(ERR_CODE_ACCOUNT_ALREADY_EXISTS);
			r.setErrorMessage(ex.getMessage());
		} catch (InvalidCurrentPasswordException ex) {
			logger.info("InvalidCurrentPasswordException: " +ex.getMessage());
			r.setStatusCode(HttpServletResponse.SC_FORBIDDEN);
			r.setErrorCode(ERR_CODE_INVALID_CURRENT_PASSWORD);
			r.setErrorMessage(ex.getMessage());
		} catch(AccountPendingException ex){
			logger.info("AccountPendingException: " +ex.getMessage());
			r.setStatusCode(HttpServletResponse.SC_FORBIDDEN);
			r.setErrorCode(ERR_CODE_ACCOUNT_STATUS_PENDING);
			r.setErrorMessage(ex.getMessage());
		} catch(ProfileNotFoundException ex){
			logger.info("ProfileNotFoundException: " +ex.getMessage());
			r.setStatusCode(HttpServletResponse.SC_NOT_FOUND);
			r.setErrorCode(ERR_CODE_PROFILE_NOT_FOUND);
			r.setErrorMessage(ex.getMessage());
		} catch(RoleNotFoundException ex){
			logger.info("RoleNotFoundException: " +ex.getMessage());
			r.setStatusCode(HttpServletResponse.SC_NOT_FOUND);
			r.setErrorCode(ERR_CODE_ROLE_NOT_FOUND);
			r.setErrorMessage(ex.getMessage());
		} catch(OrganizationNotFound ex){
			logger.info("OrganizationNotFound: " +ex.getMessage());
			r.setStatusCode(HttpServletResponse.SC_NOT_FOUND);
			r.setErrorCode(ERR_CODE_ORGANIZATION_NOT_FOUND);
			r.setErrorMessage(ex.getMessage());
		} catch(EnrollmentNotFound ex){
			logger.info("EnrollmentNotFound: " +ex.getMessage());
			r.setStatusCode(HttpServletResponse.SC_NOT_FOUND);
			r.setErrorCode(ERR_CODE_ENROLLMENT_NOT_FOUND);
			r.setErrorMessage(ex.getMessage());
		} catch(PermissionSetNotFoundException ex){
			logger.info("PermissionSetNotFoundException: " +ex.getMessage());
			r.setStatusCode(HttpServletResponse.SC_NOT_FOUND);
			r.setErrorCode(ERR_CODE_PERMISSION_SET_NOT_FOUND);
			r.setErrorMessage(ex.getMessage());
		} catch(SharingRuleNotFound ex){
			logger.info("SharingRuleNotFound: " +ex.getMessage());
			r.setStatusCode(HttpServletResponse.SC_NOT_FOUND);
			r.setErrorCode(ERR_CODE_SHARING_RULE_NOT_FOUND);
			r.setErrorMessage(ex.getMessage());
		} catch(ReleaseOfInfoNotFoundException ex){
			logger.info("ReleaseOfInfoNotFoundException "+ex.getMessage());
			r.setStatusCode(HttpServletResponse.SC_NOT_FOUND);
			r.setErrorCode(ERR_CODE_RELEASE_OF_INFO_NOT_FOUND);
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
