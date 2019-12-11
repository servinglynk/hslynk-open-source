package com.servinglynk.hmis.warehouse.rest.common;

import static com.servinglynk.hmis.warehouse.common.ErrorCodes.ERR_CODE_ACCESS_DENIED;
import static com.servinglynk.hmis.warehouse.common.ErrorCodes.ERR_CODE_ILLEGAL_STATE;
import static com.servinglynk.hmis.warehouse.common.ErrorCodes.ERR_CODE_INVALID_PARAMETER;
import static com.servinglynk.hmis.warehouse.common.ErrorCodes.ERR_CODE_INVALID_SESSION_TOKEN;
import static com.servinglynk.hmis.warehouse.common.ErrorCodes.ERR_CODE_MISSING_PARAMETER;
import static com.servinglynk.hmis.warehouse.common.ErrorCodes.ERR_CODE_UNKNOWN;

import java.time.format.DateTimeParseException;
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
import com.servinglynk.hmis.warehouse.service.exception.ApiMethodNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.ClientNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.CocNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.DateofengagementNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.DisabilitiesNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.DomesticviolenceNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.EmploymentNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.EnrollmentCocNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.EnrollmentNotFound;
import com.servinglynk.hmis.warehouse.service.exception.EntryrhspNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.EntryrhyNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.EntryssvfNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.ExitNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.ExithousingassessmentNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.ExitpathNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.ExitrhyNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.HealthinsuranceNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.HealthstatusNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.HousingAssessmentDispositionNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.IncomeAndSourceNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.MedicalassistanceNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.NoncashbenefitsNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.PathstatusNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.ProjectNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.ResidentialmoveindateNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.RhybcpstatusNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.ServicefareferralNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.VerificationNotFoundException;


public class ExceptionMapper {

	protected final Logger logger = LoggerFactory.getLogger(getClass());

	
	// error codes
	public static final String ERR_CODE_PARAMETER_NOT_FOUND							= "PARAMETER_NOT_FOUND";
	public static final String ERR_CODE_CLIENT_NOT_FOUND							= "CLIENT_NOT_FOUND";
	public static final String ERR_CODE_ENROLLMENT_NOT_FOUND						= "ENROLLMENT_NOT_FOUND";
	public static final String ERR_CODE_EXIT_NOT_FOUND								= "EXIT_NOT_FOUND";
	public static final String ERR_CODE_EMPLOYMENT_NOT_FOUND						= "EMPLOYMENT_NOT_FOUND";
	public static final String ERR_PROJECT_NOT_FOUND								= "PROJECT_NOT_FOUND";	
	public static final String ERR_COC_NOT_FOUND								    = "COC_NOT_FOUND";	
	public static final String ERR_DATEOFENGAGEMENT_PROJECT_NOT_FOUND				= "DATEOFENGAGEMENT_NOT_FOUND";	
	public static final String ERR_CODE_DISABILITIES_NOT_FOUND						= "DISABILITIES_NOT_FOUND";	
	public static final String ERR_CODE_DOMESTICVIOLENCE_NOT_FOUND					= "DOMESTICVIOLENCE_NOT_FOUND";	
	public static final String ERR_CODE_ENROLLMENTCOC_NOT_FOUND						= "ENROLLMENTCOC_NOT_FOUND";	
	public static final String ERR_CODE_ENTRYRHSP_NOT_FOUND						    = "ENTRYRHSP_NOT_FOUND";	
	public static final String ERR_CODE_ENTRYRHY_NOT_FOUND						    = "ENTRYRHY_NOT_FOUND";	
	public static final String ERR_CODE_ENTRYSSVF_NOT_FOUND						    = "ENTRYSSVF_NOT_FOUND";	
	public static final String ERR_CODE_EXITHOUSINGASSEMENT_NOT_FOUND				= "EXITHOUSINGASSEMENT_NOT_FOUND";	
	public static final String ERR_CODE_EXITPATH_NOT_FOUND						    = "EXITPATH_NOT_FOUND";	
	public static final String ERR_CODE_EXITRHY_NOT_FOUND						    = "EXITRHY_NOT_FOUND";	
	public static final String ERR_CODE_HEALTHINSURANCE_NOT_FOUND				    = "HEALTHINSURANCE_NOT_FOUND";	
	public static final String ERR_CODE_HEALTHSTATUS_NOT_FOUND						= "HEALTHSTATUS_NOT_FOUND";	
	public static final String ERR_CODE_HOUSINGASSESMENTDISPOSITION_NOT_FOUND	    = "HOUSINGASSESMENTDISPOSITION_NOT_FOUND";	
	public static final String ERR_CODE_INCOMEANDSOURCE_NOT_FOUND					= "INCOMEANDSOURCE_NOT_FOUND";	
	public static final String ERR_CODE_MEDICALASSISTANCE_NOT_FOUND				    = "MEDICALASSISTANCE_NOT_FOUND";	
	public static final String ERR_CODE_NONCASHBENIFITS_NOT_FOUND					= "NONCASHBENIFITS_NOT_FOUND";	
	public static final String ERR_CODE_PATHSTATUS_NOT_FOUND						= "PATHSTATUS_NOT_FOUND";	
	public static final String ERR_CODE_RESIDENTIALMOVEINDATE_NOT_FOUND			    = "RESIDENTIALMOVEINDATE_NOT_FOUND";	
	public static final String ERR_CODE_RHYBCPSTATUS_NOT_FOUND					    = "RHYBCPSTATUS_NOT_FOUND";	
	public static final String ERR_CODE_SERVICEFARWFERRAL_NOT_FOUND				    = "SERVICEFARWFERRAL_NOT_FOUND";	
	public static final String ERR_CODE_VERIFICATION_NOT_FOUND					    = "VERIFICATION_NOT_FOUND";	
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
			r.setErrorCode(ERR_PROJECT_NOT_FOUND);
			r.setErrorMessage(ex.getMessage());		
		}catch(CocNotFoundException ex){
			logger.info("CocNotFoundException: " + ex.getMessage(), ex);
			r.setStatusCode(HttpServletResponse.SC_NOT_FOUND);
			r.setErrorCode(ERR_COC_NOT_FOUND);
			r.setErrorMessage(ex.getMessage());		
		}catch(DateofengagementNotFoundException ex){
			logger.info("DateofengagementNotFoundException: " + ex.getMessage(), ex);
			r.setStatusCode(HttpServletResponse.SC_NOT_FOUND);
			r.setErrorCode(ERR_DATEOFENGAGEMENT_PROJECT_NOT_FOUND);
			r.setErrorMessage(ex.getMessage());		
		}catch(DisabilitiesNotFoundException ex){
			logger.info("DisabilitiesNotFoundException: " + ex.getMessage(), ex);
			r.setStatusCode(HttpServletResponse.SC_NOT_FOUND);
			r.setErrorCode(ERR_CODE_DISABILITIES_NOT_FOUND);
			r.setErrorMessage(ex.getMessage());		
		}catch(DomesticviolenceNotFoundException ex){
			logger.info("DomesticviolenceNotFoundException: " + ex.getMessage(), ex);
			r.setStatusCode(HttpServletResponse.SC_NOT_FOUND);
			r.setErrorCode(ERR_CODE_DOMESTICVIOLENCE_NOT_FOUND);
			r.setErrorMessage(ex.getMessage());		
		}catch(EnrollmentCocNotFoundException ex){
			logger.info("EnrollmentCocNotFoundException: " + ex.getMessage(), ex);
			r.setStatusCode(HttpServletResponse.SC_NOT_FOUND);
			r.setErrorCode(ERR_CODE_ENROLLMENTCOC_NOT_FOUND);
			r.setErrorMessage(ex.getMessage());		
		}catch(EntryrhspNotFoundException ex){
			logger.info("EntryrhspNotFoundException: " + ex.getMessage(), ex);
			r.setStatusCode(HttpServletResponse.SC_NOT_FOUND);
			r.setErrorCode(ERR_CODE_ENTRYRHSP_NOT_FOUND);
			r.setErrorMessage(ex.getMessage());		
		}catch(EntryrhyNotFoundException ex){
			logger.info("EntryrhyNotFoundException: " + ex.getMessage(), ex);
			r.setStatusCode(HttpServletResponse.SC_NOT_FOUND);
			r.setErrorCode(ERR_CODE_ENTRYRHY_NOT_FOUND);
			r.setErrorMessage(ex.getMessage());		
		}catch(EntryssvfNotFoundException ex){
			logger.info("EntryssvfNotFoundException: " + ex.getMessage(), ex);
			r.setStatusCode(HttpServletResponse.SC_NOT_FOUND);
			r.setErrorCode(ERR_CODE_ENTRYSSVF_NOT_FOUND);
			r.setErrorMessage(ex.getMessage());		
		}catch(ExithousingassessmentNotFoundException ex){
			logger.info("ExithousingassessmentNotFoundException: " + ex.getMessage(), ex);
			r.setStatusCode(HttpServletResponse.SC_NOT_FOUND);
			r.setErrorCode(ERR_CODE_EXITHOUSINGASSEMENT_NOT_FOUND);
			r.setErrorMessage(ex.getMessage());		
		}catch(ExitpathNotFoundException ex){
			logger.info("ExitpathNotFoundException: " + ex.getMessage(), ex);
			r.setStatusCode(HttpServletResponse.SC_NOT_FOUND);
			r.setErrorCode(ERR_CODE_EXITPATH_NOT_FOUND);
			r.setErrorMessage(ex.getMessage());		
		}catch(ExitrhyNotFoundException ex){
			logger.info("ExitrhyNotFoundException: " + ex.getMessage(), ex);
			r.setStatusCode(HttpServletResponse.SC_NOT_FOUND);
			r.setErrorCode(ERR_CODE_EXITRHY_NOT_FOUND);
			r.setErrorMessage(ex.getMessage());		
		}catch(HealthinsuranceNotFoundException ex){
			logger.info("HealthinsuranceNotFoundException: " + ex.getMessage(), ex);
			r.setStatusCode(HttpServletResponse.SC_NOT_FOUND);
			r.setErrorCode(ERR_CODE_HEALTHINSURANCE_NOT_FOUND);
			r.setErrorMessage(ex.getMessage());		
		}catch(HealthstatusNotFoundException ex){
			logger.info("HealthstatusNotFoundException: " + ex.getMessage(), ex);
			r.setStatusCode(HttpServletResponse.SC_NOT_FOUND);
			r.setErrorCode(ERR_CODE_HEALTHSTATUS_NOT_FOUND);
			r.setErrorMessage(ex.getMessage());		
		}catch(HousingAssessmentDispositionNotFoundException ex){
			logger.info("HousingAssessmentDispositionNotFoundException: " + ex.getMessage(), ex);
			r.setStatusCode(HttpServletResponse.SC_NOT_FOUND);
			r.setErrorCode(ERR_CODE_HOUSINGASSESMENTDISPOSITION_NOT_FOUND);
			r.setErrorMessage(ex.getMessage());		
		}catch(IncomeAndSourceNotFoundException ex){
			logger.info("IncomeAndSourceNotFoundException: " + ex.getMessage(), ex);
			r.setStatusCode(HttpServletResponse.SC_NOT_FOUND);
			r.setErrorCode(ERR_CODE_INCOMEANDSOURCE_NOT_FOUND);
			r.setErrorMessage(ex.getMessage());		
		}catch(MedicalassistanceNotFoundException ex){
			logger.info("MedicalassistanceNotFoundException: " + ex.getMessage(), ex);
			r.setStatusCode(HttpServletResponse.SC_NOT_FOUND);
			r.setErrorCode(ERR_CODE_MEDICALASSISTANCE_NOT_FOUND);
			r.setErrorMessage(ex.getMessage());		
		}catch(NoncashbenefitsNotFoundException ex){
			logger.info("NoncashbenefitsNotFoundException: " + ex.getMessage(), ex);
			r.setStatusCode(HttpServletResponse.SC_NOT_FOUND);
			r.setErrorCode(ERR_CODE_NONCASHBENIFITS_NOT_FOUND);
			r.setErrorMessage(ex.getMessage());		
		}catch(PathstatusNotFoundException ex){
			logger.info("PathstatusNotFoundException: " + ex.getMessage(), ex);
			r.setStatusCode(HttpServletResponse.SC_NOT_FOUND);
			r.setErrorCode(ERR_CODE_PATHSTATUS_NOT_FOUND);
			r.setErrorMessage(ex.getMessage());		
		}catch(ResidentialmoveindateNotFoundException ex){
			logger.info("ResidentialmoveindateNotFoundException: " + ex.getMessage(), ex);
			r.setStatusCode(HttpServletResponse.SC_NOT_FOUND);
			r.setErrorCode(ERR_CODE_RESIDENTIALMOVEINDATE_NOT_FOUND);
			r.setErrorMessage(ex.getMessage());		
		}catch(RhybcpstatusNotFoundException ex){
			logger.info("RhybcpstatusNotFoundException: " + ex.getMessage(), ex);
			r.setStatusCode(HttpServletResponse.SC_NOT_FOUND);
			r.setErrorCode(ERR_CODE_RHYBCPSTATUS_NOT_FOUND);
			r.setErrorMessage(ex.getMessage());		
		}catch(ServicefareferralNotFoundException ex){
			logger.info("ServicefareferralNotFoundException: " + ex.getMessage(), ex);
			r.setStatusCode(HttpServletResponse.SC_NOT_FOUND);
			r.setErrorCode(ERR_CODE_SERVICEFARWFERRAL_NOT_FOUND);
			r.setErrorMessage(ex.getMessage());		
		}catch(VerificationNotFoundException ex){
			logger.info("VerificationNotFoundException: " + ex.getMessage(), ex);
			r.setStatusCode(HttpServletResponse.SC_NOT_FOUND);
			r.setErrorCode(ERR_CODE_VERIFICATION_NOT_FOUND);
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
		}catch (ApiMethodNotFoundException ex) {
			logger.info("ApiMethodNotFoundException: " + ex.getMessage(), ex);
			r.setStatusCode(HttpServletResponse.SC_NOT_FOUND);
			r.setErrorCode(ERR_CODE_API_METHOD_NOT_FOUND);
			r.setErrorMessage(ex.getMessage());

		} catch (InvalidTrustedAppException ex) {
			logger.info("InvalidTrustedAppException: " + ex.getMessage(), ex);
			r.setStatusCode(HttpServletResponse.SC_NOT_FOUND);
			r.setErrorCode(ERR_CODE_INVALID_TRUSTED_APP);
			r.setErrorMessage(ex.getMessage());
		} catch (DateTimeParseException ex) {
			logger.info("InvalidTrustedAppException: " + ex.getMessage(), ex);
			r.setStatusCode(HttpServletResponse.SC_BAD_REQUEST);
			r.setErrorCode("INVALID_DATE_FORMAT");
			ex.printStackTrace();
			r.setErrorMessage(ex.getMessage());		
	}catch (com.servinglynk.hmis.warehouse.service.exception.ResourceNotFound ex) {
		logger.info("ResourceNotFoundException: " + ex.getMessage(), ex);
		r.setStatusCode(HttpServletResponse.SC_NOT_FOUND);
		r.setErrorCode("REQUEST_RESOURCE_NOTFOUND");
		ex.printStackTrace();
		r.setErrorMessage(ex.getMessage());
	}
		catch (com.servinglynk.hmis.warehouse.service.exception.ResourceNotFoundException ex) {
			logger.info("ResourceNotFoundException: " + ex.getMessage(), ex);
			r.setStatusCode(HttpServletResponse.SC_NOT_FOUND);
			r.setErrorCode("REQUEST_RESOURCE_NOTFOUND");
			ex.printStackTrace();
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
