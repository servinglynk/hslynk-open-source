package com.servinglynk.hmis.rest.common;

import static com.servinglynk.hmis.warehouse.common.ErrorCodes.ERR_CODE_ACCESS_DENIED;
import static com.servinglynk.hmis.warehouse.common.ErrorCodes.ERR_CODE_INVALID_PARAMETER;
import static com.servinglynk.hmis.warehouse.common.ErrorCodes.ERR_CODE_UNKNOWN;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.servinglynk.hmis.service.exception.ResourceNotFoundException;
import com.servinglynk.hmis.service.exception.RestClientException;
import com.servinglynk.hmis.warehouse.core.model.Error;
import com.servinglynk.hmis.warehouse.core.model.exception.AccessDeniedException;
import com.servinglynk.hmis.warehouse.core.model.exception.InvalidParameterException;


public class ExceptionMapper {

	protected final Logger logger = LoggerFactory.getLogger(getClass());

	
	// error codes
	public static final String ERR_CODE_PARAMETER_NOT_FOUND							= "PARAMETER_NOT_FOUND";
	public static final String ERR_CODE_CLIENT_NOT_FOUND							= "CLIENT_NOT_FOUND";
	public static final String ERR_CODE_ENROLLMENT_NOT_FOUND						= "ENROLLMENT_NOT_FOUND";
	public static final String ERR_CODE_EXIT_NOT_FOUND								= "EXIT_NOT_FOUND";
	public static final String ERR_CODE_EMPLOYMENT_NOT_FOUND						= "EMPLOYMENT_NOT_FOUND";
	public static final String ERR_CODE_PROJECT_NOT_FOUND						    = "PROJECT_NOT_FOUND";	
	public static final String ERR_CODE_AFFILIATION_NOT_FOUND						= "AFFILIATION_NOT_FOUND";
	public static final String ERR_CODE_COMMERCIALSEXUALEXPLOITATION_NOT_FOUND		= "COMMERCIALSEXUALEXPLOITATION_NOT_FOUND";
	public static final String ERR_CODE_CONNECTIONWITHSOAR_NOT_FOUND				= "CONNECTIONWITHSOAR_NOT_FOUND";
	public static final String ERR_CODE_DATEOFENGAGEMENT_NOT_FOUND					= "DATEOFENGAGEMENT_NOT_FOUND";
	public static final String ERR_CODE_DISABILITIES_NOT_FOUND						= "DISABILITIES_NOT_FOUND";
	public static final String ERR_CODE_DOMESTICVIOLENCE_NOT_FOUND					= "DOMESTICVIOLENCE_NOT_FOUND";
	public static final String ERR_CODE_EXITPLANSACTIONS_NOT_FOUND					= "EXITPLANSACTIONS_NOT_FOUND";
	public static final String ERR_CODE_FAMILYREUNIFICATION_NOT_FOUND				= "FAMILYREUNIFICATION_NOT_FOUND";
	public static final String ERR_CODE_FORMERWARDCHILDWELFARE_NOT_FOUND			= "FORMERWARDCHILDWELFARE_NOT_FOUND";
	public static final String ERR_CODE_FUNDER_NOT_FOUND							= "FUNDER_NOT_FOUND";
	public static final String ERR_CODE_HEALTHINSURANCE_NOT_FOUND					= "HEALTHINSURANCE_NOT_FOUND";
	public static final String ERR_CODE_HEALTHSTATUS_NOT_FOUND						= "HEALTHSTATUS_NOT_FOUND";
	public static final String ERR_CODE_HOUSINGASSESSMENTDISPOSITION_NOT_FOUND		= "HOUSINGASSESSMENTDISPOSITION_NOT_FOUND";
	public static final String ERR_CODE_INCOMEANDSOURCE_NOT_FOUND					= "INCOMEANDSOURCE_NOT_FOUND";
	public static final String ERR_CODE_INVENTORY_NOT_FOUND							= "INVENTORY_NOT_FOUND";
	public static final String ERR_CODE_LASTPERMANENTADDRESS_NOT_FOUND				= "LASTPERMANENTADDRESS_NOT_FOUND";
	public static final String ERR_CODE_MEDICALASSISTANCE_NOT_FOUND					= "MEDICALASSISTANCE_NOT_FOUND";
	public static final String ERR_CODE_NONCASHBENIFITS_NOT_FOUND					= "NONCASHBENIFITS_NOT_FOUND";
	public static final String ERR_CODE_ORGANIZATION_NOT_FOUND						= "ORGANIZATION_NOT_FOUND";
	public static final String ERR_CODE_PATHSTATUS_NOT_FOUND						= "PATHSTATUS_NOT_FOUND";
	public static final String ERR_CODE_PERCENTAMI_NOT_FOUND						= "PERCENTAMI_NOT_FOUND";
	public static final String ERR_CODE_PROFILE_NOT_FOUND							= "PROFILE_NOT_FOUND";
	public static final String ERR_CODE_PROJECTCOC_NOT_FOUND						= "PROJECTCOC_NOT_FOUND";
	public static final String ERR_CODE_PROJECTCOMPLETIONSTATUS_NOT_FOUND			= "PROJECTCOMPLETIONSTATUS_NOT_FOUND";
	public static final String ERR_CODE_PROJECTGROUP_NOT_FOUND						= "PROJECTGROUP_NOT_FOUND";
	public static final String ERR_CODE_REFERRALSOURCE_NOT_FOUND					= "REFERRALSOURCE_NOT_FOUND";
	public static final String ERR_CODE_RESIDENTIALMOVEINDATE_NOT_FOUND				= "RESIDENTIALMOVEINDATE_NOT_FOUND";
	public static final String ERR_CODE_RHYBCPSTATUS_NOT_FOUND						= "RHYBCPSTATUS_NOT_FOUND";
	public static final String ERR_CODE_ROLE_NOT_FOUND								= "ROLE_NOT_FOUND";
	public static final String ERR_CODE_SCHOOLSTATUS_NOT_FOUND						= "SCHOOLSTATUS_NOT_FOUND";
	public static final String ERR_CODE_SERVICE_NOT_FOUND							= "SERVICE_NOT_FOUND";
	public static final String ERR_CODE_SEXUALORIENTATION_NOT_FOUND					= "SEXUALORIENTATION_NOT_FOUND";
	public static final String ERR_CODE_SITE_NOT_FOUND								= "SITE_NOT_FOUND";
	public static final String ERR_CODE_VETERANINFO_NOT_FOUND						= "VETERANINFO_NOT_FOUND";
	public static final String ERR_CODE_WORSTHOUSINGSITUATION_NOT_FOUND				= "WORSTHOUSINGSITUATION_NOT_FOUND";
	public static final String ERR_CODE_YOUTHCRITICALISSUES_NOT_FOUND				= "YOUTHCRITICALISSUES_NOT_FOUND";
	public static final String ERR_CODE_TRUSTEDAPP_NOT_FOUND                        = "TRUSTEDAPP_NOT_FOUND";	
	public static final String ERR_CODE_API_METHOD_NOT_FOUND                        = "API_METHOD_NOT_FOUND";	
	public static final String ERR_CODE_INVALID_TRUSTED_APP							= "INVALID_TRUSTED_APP";
	
	// error messages
	public static final String ERR_MSG_UNKNOWN = "unexpected error occurred";

	// query parameter names
	public static final String PARAM_NAME_SC_200_ONLY = "sc200Only";

	private boolean internalErrorMessageReturned;

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
