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
import com.servinglynk.hmis.warehouse.service.exception.AffiliationNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.ApiMethodNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.ClientNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.CommercialSexualExploitationNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.ConnectionwithsoarNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.DateofengagementNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.DisabilitiesNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.DomesticViolenceNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.EmploymentNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.EnrollmentNotFound;
import com.servinglynk.hmis.warehouse.service.exception.ExitNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.ExitPlansActionsNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.FamilyReunificationNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.FormerWardChildWelfareNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.FunderNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.HealthInsuranceNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.HealthStatusNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.HousingAssessmentDispositionNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.IncomeAndSourceNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.InvalidRequest;
import com.servinglynk.hmis.warehouse.service.exception.InventoryNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.LastPermanentAddressNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.MedicalassistanceNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.NonCashBenefitNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.OrganizationNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.PathstatusNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.PercentamiNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.ProfileNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.ProjectCompletionStatusNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.ProjectGroupNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.ProjectNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.ProjectcocNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.ReferralsourceNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.ResidentialmoveindateNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.RhybcpstatusNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.RoleNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.SchoolstatusNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.ServiceNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.SexualorientationNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.SiteNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.VeteranInfoNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.WorstHousingSituationNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.YouthCriticalIssuesNotFoundException;


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
		}  catch (InvalidParameterException ex) {

			logger.info("InvalidParameterException: " + ex.getMessage(), ex);
			r.setStatusCode(HttpServletResponse.SC_BAD_REQUEST);
			r.setErrorCode(ERR_CODE_INVALID_PARAMETER);
			r.setErrorMessage(ex.getMessage());

		}catch (InvalidRequest ex) {

			logger.info("InvalidRequest: " + ex.getMessage(), ex);
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
		}catch(AffiliationNotFoundException ex){
			logger.info("AffiliationNotFoundException: " + ex.getMessage(), ex);
			r.setStatusCode(HttpServletResponse.SC_NOT_FOUND);
			r.setErrorCode(ERR_CODE_AFFILIATION_NOT_FOUND);
			r.setErrorMessage(ex.getMessage());		
		}catch(CommercialSexualExploitationNotFoundException ex){
			logger.info("CommercialSexualExploitationNotFoundException: " + ex.getMessage(), ex);
			r.setStatusCode(HttpServletResponse.SC_NOT_FOUND);
			r.setErrorCode(ERR_CODE_COMMERCIALSEXUALEXPLOITATION_NOT_FOUND);
			r.setErrorMessage(ex.getMessage());		
		}catch(ConnectionwithsoarNotFoundException ex){
			logger.info("ConnectionwithsoarNotFoundException: " + ex.getMessage(), ex);
			r.setStatusCode(HttpServletResponse.SC_NOT_FOUND);
			r.setErrorCode(ERR_CODE_CONNECTIONWITHSOAR_NOT_FOUND);
			r.setErrorMessage(ex.getMessage());		
		}catch(DateofengagementNotFoundException ex){
			logger.info("DateofengagementNotFoundException: " + ex.getMessage(), ex);
			r.setStatusCode(HttpServletResponse.SC_NOT_FOUND);
			r.setErrorCode(ERR_CODE_DATEOFENGAGEMENT_NOT_FOUND);
			r.setErrorMessage(ex.getMessage());		
		}catch(DisabilitiesNotFoundException ex){
			logger.info("DisabilitiesNotFoundException: " + ex.getMessage(), ex);
			r.setStatusCode(HttpServletResponse.SC_NOT_FOUND);
			r.setErrorCode(ERR_CODE_DISABILITIES_NOT_FOUND);
			r.setErrorMessage(ex.getMessage());		
		}catch(DomesticViolenceNotFoundException ex){
			logger.info("DomesticViolenceNotFoundException: " + ex.getMessage(), ex);
			r.setStatusCode(HttpServletResponse.SC_NOT_FOUND);
			r.setErrorCode(ERR_CODE_DOMESTICVIOLENCE_NOT_FOUND);
			r.setErrorMessage(ex.getMessage());		
		}catch(ExitPlansActionsNotFoundException ex){
			logger.info("ExitPlansActionsNotFoundException: " + ex.getMessage(), ex);
			r.setStatusCode(HttpServletResponse.SC_NOT_FOUND);
			r.setErrorCode(ERR_CODE_EXITPLANSACTIONS_NOT_FOUND);
			r.setErrorMessage(ex.getMessage());		
		}catch(FamilyReunificationNotFoundException ex){
			logger.info("FamilyReunificationNotFoundException: " + ex.getMessage(), ex);
			r.setStatusCode(HttpServletResponse.SC_NOT_FOUND);
			r.setErrorCode(ERR_CODE_FAMILYREUNIFICATION_NOT_FOUND);
			r.setErrorMessage(ex.getMessage());		
		}catch(FormerWardChildWelfareNotFoundException ex){
			logger.info("FormerWardChildWelfareNotFoundException: " + ex.getMessage(), ex);
			r.setStatusCode(HttpServletResponse.SC_NOT_FOUND);
			r.setErrorCode(ERR_CODE_FORMERWARDCHILDWELFARE_NOT_FOUND);
			r.setErrorMessage(ex.getMessage());		
		}catch(FunderNotFoundException ex){
			logger.info("FunderNotFoundException: " + ex.getMessage(), ex);
			r.setStatusCode(HttpServletResponse.SC_NOT_FOUND);
			r.setErrorCode(ERR_CODE_FUNDER_NOT_FOUND);
			r.setErrorMessage(ex.getMessage());		
		}catch(HealthInsuranceNotFoundException ex){
			logger.info("HealthInsuranceNotFoundException: " + ex.getMessage(), ex);
			r.setStatusCode(HttpServletResponse.SC_NOT_FOUND);
			r.setErrorCode(ERR_CODE_HEALTHINSURANCE_NOT_FOUND);
			r.setErrorMessage(ex.getMessage());		
		}catch(HealthStatusNotFoundException ex){
			logger.info("HealthStatusNotFoundException: " + ex.getMessage(), ex);
			r.setStatusCode(HttpServletResponse.SC_NOT_FOUND);
			r.setErrorCode(ERR_CODE_HEALTHSTATUS_NOT_FOUND);
			r.setErrorMessage(ex.getMessage());		
		}catch(HousingAssessmentDispositionNotFoundException ex){
			logger.info("HousingAssessmentDispositionNotFoundException: " + ex.getMessage(), ex);
			r.setStatusCode(HttpServletResponse.SC_NOT_FOUND);
			r.setErrorCode(ERR_CODE_HOUSINGASSESSMENTDISPOSITION_NOT_FOUND);
			r.setErrorMessage(ex.getMessage());		
		}catch(IncomeAndSourceNotFoundException ex){
			logger.info("IncomeAndSourceNotFoundException: " + ex.getMessage(), ex);
			r.setStatusCode(HttpServletResponse.SC_NOT_FOUND);
			r.setErrorCode(ERR_CODE_INCOMEANDSOURCE_NOT_FOUND);
			r.setErrorMessage(ex.getMessage());		
		}catch(InventoryNotFoundException ex){
			logger.info("InventoryNotFoundException: " + ex.getMessage(), ex);
			r.setStatusCode(HttpServletResponse.SC_NOT_FOUND);
			r.setErrorCode(ERR_CODE_INVENTORY_NOT_FOUND);
			r.setErrorMessage(ex.getMessage());		
		}catch(LastPermanentAddressNotFoundException ex){
			logger.info("LastPermanentAddressNotFoundException: " + ex.getMessage(), ex);
			r.setStatusCode(HttpServletResponse.SC_NOT_FOUND);
			r.setErrorCode(ERR_CODE_LASTPERMANENTADDRESS_NOT_FOUND);
			r.setErrorMessage(ex.getMessage());		
		}catch(MedicalassistanceNotFoundException ex){
			logger.info("MedicalassistanceNotFoundException: " + ex.getMessage(), ex);
			r.setStatusCode(HttpServletResponse.SC_NOT_FOUND);
			r.setErrorCode(ERR_CODE_MEDICALASSISTANCE_NOT_FOUND);
			r.setErrorMessage(ex.getMessage());		
		}catch(NonCashBenefitNotFoundException ex){
			logger.info("NonCashBenefitNotFoundException: " + ex.getMessage(), ex);
			r.setStatusCode(HttpServletResponse.SC_NOT_FOUND);
			r.setErrorCode(ERR_CODE_NONCASHBENIFITS_NOT_FOUND);
			r.setErrorMessage(ex.getMessage());		
		}catch(OrganizationNotFoundException ex){
			logger.info("OrganizationNotFoundException: " + ex.getMessage(), ex);
			r.setStatusCode(HttpServletResponse.SC_NOT_FOUND);
			r.setErrorCode(ERR_CODE_ORGANIZATION_NOT_FOUND);
			r.setErrorMessage(ex.getMessage());		
		}catch(PathstatusNotFoundException ex){
			logger.info("PathstatusNotFoundException: " + ex.getMessage(), ex);
			r.setStatusCode(HttpServletResponse.SC_NOT_FOUND);
			r.setErrorCode(ERR_CODE_PATHSTATUS_NOT_FOUND);
			r.setErrorMessage(ex.getMessage());		
		}catch(PercentamiNotFoundException ex){
			logger.info("PercentamiNotFoundException: " + ex.getMessage(), ex);
			r.setStatusCode(HttpServletResponse.SC_NOT_FOUND);
			r.setErrorCode(ERR_CODE_PERCENTAMI_NOT_FOUND);
			r.setErrorMessage(ex.getMessage());		
		}catch(ProfileNotFoundException ex){
			logger.info("ProfileNotFoundException: " + ex.getMessage(), ex);
			r.setStatusCode(HttpServletResponse.SC_NOT_FOUND);
			r.setErrorCode(ERR_CODE_PROFILE_NOT_FOUND);
			r.setErrorMessage(ex.getMessage());		
		}catch(ProjectcocNotFoundException ex){
			logger.info("ProjectcocNotFoundException: " + ex.getMessage(), ex);
			r.setStatusCode(HttpServletResponse.SC_NOT_FOUND);
			r.setErrorCode(ERR_CODE_PROJECTCOC_NOT_FOUND);
			r.setErrorMessage(ex.getMessage());		
		}catch(ProjectCompletionStatusNotFoundException ex){
			logger.info("ProjectCompletionStatusNotFoundException: " + ex.getMessage(), ex);
			r.setStatusCode(HttpServletResponse.SC_NOT_FOUND);
			r.setErrorCode(ERR_CODE_PROJECTCOMPLETIONSTATUS_NOT_FOUND);
			r.setErrorMessage(ex.getMessage());		
		}catch(ProjectGroupNotFoundException ex){
			logger.info("ProjectGroupNotFoundException: " + ex.getMessage(), ex);
			r.setStatusCode(HttpServletResponse.SC_NOT_FOUND);
			r.setErrorCode(ERR_CODE_PROJECTGROUP_NOT_FOUND);
			r.setErrorMessage(ex.getMessage());		
		}catch(ReferralsourceNotFoundException ex){
			logger.info("ReferralsourceNotFoundException: " + ex.getMessage(), ex);
			r.setStatusCode(HttpServletResponse.SC_NOT_FOUND);
			r.setErrorCode(ERR_CODE_REFERRALSOURCE_NOT_FOUND);
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
		}catch(RoleNotFoundException ex){
			logger.info("RoleNotFoundException: " + ex.getMessage(), ex);
			r.setStatusCode(HttpServletResponse.SC_NOT_FOUND);
			r.setErrorCode(ERR_CODE_ROLE_NOT_FOUND);
			r.setErrorMessage(ex.getMessage());		
		}catch(SchoolstatusNotFoundException ex){
			logger.info("SchoolstatusNotFoundException: " + ex.getMessage(), ex);
			r.setStatusCode(HttpServletResponse.SC_NOT_FOUND);
			r.setErrorCode(ERR_CODE_SCHOOLSTATUS_NOT_FOUND);
			r.setErrorMessage(ex.getMessage());		
		}catch(ServiceNotFoundException ex){
			logger.info("ServiceNotFoundException: " + ex.getMessage(), ex);
			r.setStatusCode(HttpServletResponse.SC_NOT_FOUND);
			r.setErrorCode(ERR_CODE_SERVICE_NOT_FOUND);
			r.setErrorMessage(ex.getMessage());		
		}catch(SexualorientationNotFoundException ex){
			logger.info("SexualorientationNotFoundException: " + ex.getMessage(), ex);
			r.setStatusCode(HttpServletResponse.SC_NOT_FOUND);
			r.setErrorCode(ERR_CODE_SEXUALORIENTATION_NOT_FOUND);
			r.setErrorMessage(ex.getMessage());		
		}catch(SiteNotFoundException ex){
			logger.info("SiteNotFoundException: " + ex.getMessage(), ex);
			r.setStatusCode(HttpServletResponse.SC_NOT_FOUND);
			r.setErrorCode(ERR_CODE_SITE_NOT_FOUND);
			r.setErrorMessage(ex.getMessage());		
		}catch(VeteranInfoNotFoundException ex){
			logger.info("VeteranInfoNotFoundException: " + ex.getMessage(), ex);
			r.setStatusCode(HttpServletResponse.SC_NOT_FOUND);
			r.setErrorCode(ERR_CODE_VETERANINFO_NOT_FOUND);
			r.setErrorMessage(ex.getMessage());		
		}catch(WorstHousingSituationNotFoundException ex){
			logger.info("WorstHousingSituationNotFoundException: " + ex.getMessage(), ex);
			r.setStatusCode(HttpServletResponse.SC_NOT_FOUND);
			r.setErrorCode(ERR_CODE_WORSTHOUSINGSITUATION_NOT_FOUND);
			r.setErrorMessage(ex.getMessage());		
		}catch(YouthCriticalIssuesNotFoundException ex){
			logger.info("YouthCriticalIssuesNotFoundException: " + ex.getMessage(), ex);
			r.setStatusCode(HttpServletResponse.SC_NOT_FOUND);
			r.setErrorCode(ERR_CODE_YOUTHCRITICALISSUES_NOT_FOUND);
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
		}catch (com.servinglynk.hmis.warehouse.service.exception.ResourceNotFoundException ex) {
			logger.info("ResourceNotFoundException: " + ex.getMessage(), ex);
			r.setStatusCode(HttpServletResponse.SC_NOT_FOUND);
			r.setErrorCode("RESOURCE_NOT_FOUND");
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
