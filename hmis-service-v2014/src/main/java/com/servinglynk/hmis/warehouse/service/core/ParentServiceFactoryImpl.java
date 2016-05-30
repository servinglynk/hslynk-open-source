package com.servinglynk.hmis.warehouse.service.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.servinglynk.hmis.warehouse.base.service.BulkUploadService;
import com.servinglynk.hmis.warehouse.base.service.ProjectGroupService;
import com.servinglynk.hmis.warehouse.base.service.SearchService;
import com.servinglynk.hmis.warehouse.base.service.core.BaseServiceFactoryImpl;
import com.servinglynk.hmis.warehouse.service.AffiliationService;
import com.servinglynk.hmis.warehouse.service.ClientService;
import com.servinglynk.hmis.warehouse.service.CommercialSexualExploitationService;
import com.servinglynk.hmis.warehouse.service.ConnectionwithsoarService;
import com.servinglynk.hmis.warehouse.service.DateofengagementService;
import com.servinglynk.hmis.warehouse.service.DisabilitiesService;
import com.servinglynk.hmis.warehouse.service.DomesticViolenceService;
import com.servinglynk.hmis.warehouse.service.EmploymentService;
import com.servinglynk.hmis.warehouse.service.EnrollmentService;
import com.servinglynk.hmis.warehouse.service.ExitPlansActionsService;
import com.servinglynk.hmis.warehouse.service.ExitService;
import com.servinglynk.hmis.warehouse.service.FamilyReunificationService;
import com.servinglynk.hmis.warehouse.service.FunderService;
import com.servinglynk.hmis.warehouse.service.HealthInsuranceService;
import com.servinglynk.hmis.warehouse.service.HealthStatusService;
import com.servinglynk.hmis.warehouse.service.HousingAssessmentDispositionService;
import com.servinglynk.hmis.warehouse.service.IncomeAndSourceService;
import com.servinglynk.hmis.warehouse.service.InformationReleasesService;
import com.servinglynk.hmis.warehouse.service.InventoryService;
import com.servinglynk.hmis.warehouse.service.LastPermanentAddressService;
import com.servinglynk.hmis.warehouse.service.MedicalassistanceService;
import com.servinglynk.hmis.warehouse.service.NonCashBenefitService;
import com.servinglynk.hmis.warehouse.service.OrganizationService;
import com.servinglynk.hmis.warehouse.service.PathstatusService;
import com.servinglynk.hmis.warehouse.service.PercentamiService;
import com.servinglynk.hmis.warehouse.service.ProjectCompletionStatusService;
import com.servinglynk.hmis.warehouse.service.ProjectService;
import com.servinglynk.hmis.warehouse.service.ProjectcocService;
import com.servinglynk.hmis.warehouse.service.ReferralsourceService;
import com.servinglynk.hmis.warehouse.service.ResidentialmoveindateService;
import com.servinglynk.hmis.warehouse.service.RhybcpstatusService;
import com.servinglynk.hmis.warehouse.service.SchoolstatusService;
import com.servinglynk.hmis.warehouse.service.ServicesService;
import com.servinglynk.hmis.warehouse.service.SexualorientationService;
import com.servinglynk.hmis.warehouse.service.SharingRuleService;
import com.servinglynk.hmis.warehouse.service.SiteService;
import com.servinglynk.hmis.warehouse.service.VeteranInfoService;
import com.servinglynk.hmis.warehouse.service.WorstHousingSituationService;
import com.servinglynk.hmis.warehouse.service.YouthCriticalIssuesService;
import com.servinglynk.hmis.warehouse.service.impl.SearchServiceImpl;

@Component
public class ParentServiceFactoryImpl extends BaseServiceFactoryImpl  implements ParentServiceFactory {
	

	
	@Autowired
	private SharingRuleService sharingRuleService;
	
	@Autowired				  
	private EnrollmentService enrollmentService;
	
	@Autowired
	private BulkUploadService bulkUploadService;
	
	@Autowired
	private SearchService searchService;
	
	
	public BulkUploadService getBulkUploadService() {
		return bulkUploadService;
	}

	public void setBulkUploadService(BulkUploadService bulkUploadService) {
		this.bulkUploadService = bulkUploadService;
	}

	
	public SharingRuleService getSharingRuleService() {
		return sharingRuleService;
	}

	public void setSharingRuleService(SharingRuleService sharingRuleService) {
		this.sharingRuleService = sharingRuleService;
	}

	public EnrollmentService getEnrollmentService() {
		return enrollmentService;
	}

	public void setEnrollmentService(EnrollmentService enrollmentService) {
		this.enrollmentService = enrollmentService;
	}
	
	
	@Autowired
	private InformationReleasesService informationReleasesService;


	public InformationReleasesService getInformationReleasesService() {
		return informationReleasesService;
	}

	public void setInformationReleasesService(InformationReleasesService informationReleasesService) {
		this.informationReleasesService = informationReleasesService;
	}	

	@Autowired
	private OrganizationService organizationService;

	public OrganizationService getOrganizationService() {
		return organizationService;
	}

	public void setOrganizationService(OrganizationService organizationService) {
		this.organizationService = organizationService;
	}
	
	@Autowired
	private ProjectService projectService;


	public ProjectService getProjectService() {
		return projectService;
	}

	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}
	
	@Autowired
	private ExitService exitService;


	public ExitService getExitService() {
		return exitService;
	}

	public void setExitService(ExitService exitService) {
		this.exitService = exitService;
	}
	
	@Autowired
	private EmploymentService employmentService;


	public EmploymentService getEmploymentService() {
		return employmentService;
	}

	public void setEmploymentService(EmploymentService employmentService) {
		this.employmentService = employmentService;
	}
	
	@Autowired
	private VeteranInfoService veteranInfoService;


	public VeteranInfoService getVeteranInfoService() {
		return veteranInfoService;
	}

	public void setVeteranInfoService(VeteranInfoService veteranInfoService) {
		this.veteranInfoService = veteranInfoService;
	}
	
	
	@Autowired
	private DisabilitiesService disabilitiesService;


	public DisabilitiesService getDisabilitiesService() {
		return disabilitiesService;
	}

	public void setDisabilitiesService(DisabilitiesService disabilitiesService) {
		this.disabilitiesService = disabilitiesService;
	}
	
	@Autowired
	private ConnectionwithsoarService connectionwithsoarService;


	public ConnectionwithsoarService getConnectionwithsoarService() {
		return connectionwithsoarService;
	}

	public void setConnectionwithsoarService(ConnectionwithsoarService connectionwithsoarService) {
		this.connectionwithsoarService = connectionwithsoarService;
	}

	@Autowired
	private ExitPlansActionsService exitPlansActionsService;


	public ExitPlansActionsService getExitPlansActionsService() {
		return exitPlansActionsService;
	}

	public void setExitPlansActionsService(ExitPlansActionsService exitPlansActionsService) {
		this.exitPlansActionsService = exitPlansActionsService;
	}
	
	@Autowired
	private FamilyReunificationService familyReunificationService;


	public FamilyReunificationService getFamilyReunificationService() {
		return familyReunificationService;
	}

	public void setFamilyReunificationService(FamilyReunificationService familyReunificationService) {
		this.familyReunificationService = familyReunificationService;
	}
	
	@Autowired
	private HousingAssessmentDispositionService housingAssessmentDispositionService;


	public HousingAssessmentDispositionService getHousingAssessmentDispositionService() {
		return housingAssessmentDispositionService;
	}

	public void setHousingAssessmentDispositionService(
			HousingAssessmentDispositionService housingAssessmentDispositionService) {
		this.housingAssessmentDispositionService = housingAssessmentDispositionService;
	}
	
	@Autowired
	private ProjectCompletionStatusService projectCompletionStatusService;


	public ProjectCompletionStatusService getProjectCompletionStatusService() {
		return projectCompletionStatusService;
	}

	public void setProjectCompletionStatusService(ProjectCompletionStatusService projectCompletionStatusService) {
		this.projectCompletionStatusService = projectCompletionStatusService;
	}
	
	
	@Autowired
	private IncomeAndSourceService incomeAndSourceService;


	public IncomeAndSourceService getIncomeAndSourceService() {
		return incomeAndSourceService;
	}

	public void setIncomeAndSourceService(IncomeAndSourceService incomeAndSourceService) {
		this.incomeAndSourceService = incomeAndSourceService;
	}
	
	@Autowired
	private HealthInsuranceService healthInsuranceService;


	public HealthInsuranceService getHealthInsuranceService() {
		return healthInsuranceService;
	}

	public void setHealthInsuranceService(HealthInsuranceService healthInsuranceService) {
		this.healthInsuranceService = healthInsuranceService;
	}

		
	@Autowired
	private ServicesService  servicesService;


	public ServicesService getServicesService() {
		return servicesService;
	}

	public void setServicesService(ServicesService servicesService) {
		this.servicesService = servicesService;
	}
	
	@Autowired
	private HealthStatusService healthStatusService;


	public HealthStatusService getHealthStatusService() {
		return healthStatusService;
	}

	public void setHealthStatusService(HealthStatusService healthStatusService) {
		this.healthStatusService = healthStatusService;
	}
	
	@Autowired
	public CommercialSexualExploitationService commercialSexualExploitationService;


	public CommercialSexualExploitationService getCommercialSexualExploitationService() {
		return commercialSexualExploitationService;
	}

	public void setCommercialSexualExploitationService(
			CommercialSexualExploitationService commercialSexualExploitationService) {
		this.commercialSexualExploitationService = commercialSexualExploitationService;
	}
	
	@Autowired
	private DateofengagementService dateofengagementService;


	public DateofengagementService getDateofengagementService() {
		return dateofengagementService;
	}

	public void setDateofengagementService(DateofengagementService dateofengagementService) {
		this.dateofengagementService = dateofengagementService;
	}
	
	@Autowired
	private DomesticViolenceService domesticViolenceService;


	public DomesticViolenceService getDomesticViolenceService() {
		return domesticViolenceService;
	}

	public void setDomesticViolenceService(DomesticViolenceService domesticViolenceService) {
		this.domesticViolenceService = domesticViolenceService;
	}
	
	@Autowired
	private LastPermanentAddressService lastPermanentAddressService;


	public LastPermanentAddressService getLastPermanentAddressService() {
		return lastPermanentAddressService;
	}

	public void setLastPermanentAddressService(LastPermanentAddressService lastPermanentAddressService) {
		this.lastPermanentAddressService = lastPermanentAddressService;
	}
	
	
	@Autowired
	private YouthCriticalIssuesService youthCriticalIssuesService;


	public YouthCriticalIssuesService getYouthCriticalIssuesService() {
		return youthCriticalIssuesService;
	}

	public void setYouthCriticalIssuesService(YouthCriticalIssuesService youthCriticalIssuesService) {
		this.youthCriticalIssuesService = youthCriticalIssuesService;
	}
	
	@Autowired
	private WorstHousingSituationService worstHousingSituationService;


	public WorstHousingSituationService getWorstHousingSituationService() {
		return worstHousingSituationService;
	}

	public void setWorstHousingSituationService(WorstHousingSituationService worstHousingSituationService) {
		this.worstHousingSituationService = worstHousingSituationService;
	}
	
	@Autowired
	private SexualorientationService sexualorientationService;
	
	@Autowired
	private SchoolstatusService schoolstatusService;


	public SexualorientationService getSexualorientationService() {
		return sexualorientationService;
	}

	public void setSexualorientationService(SexualorientationService sexualorientationService) {
		this.sexualorientationService = sexualorientationService;
	}

	public SchoolstatusService getSchoolstatusService() {
		return schoolstatusService;
	}

	public void setSchoolstatusService(SchoolstatusService schoolstatusService) {
		this.schoolstatusService = schoolstatusService;
	} 
	
	
	
	
	@Autowired private PathstatusService pathstatusService;
	@Autowired private PercentamiService percentamiService;
	@Autowired private RhybcpstatusService rhybcpstatusService;
	@Autowired private ResidentialmoveindateService residentialmoveindateService;
	@Autowired private ReferralsourceService referralsourceService;
	@Autowired private MedicalassistanceService medicalassistanceService;


	public PathstatusService getPathstatusService() {
		return pathstatusService;
	}

	public void setPathstatusService(PathstatusService pathstatusService) {
		this.pathstatusService = pathstatusService;
	}

	public PercentamiService getPercentamiService() {
		return percentamiService;
	}

	public void setPercentamiService(PercentamiService percentamiService) {
		this.percentamiService = percentamiService;
	}

	public RhybcpstatusService getRhybcpstatusService() {
		return rhybcpstatusService;
	}

	public void setRhybcpstatusService(RhybcpstatusService rhybcpstatusService) {
		this.rhybcpstatusService = rhybcpstatusService;
	}

	public ResidentialmoveindateService getResidentialmoveindateService() {
		return residentialmoveindateService;
	}

	public void setResidentialmoveindateService(ResidentialmoveindateService residentialmoveindateService) {
		this.residentialmoveindateService = residentialmoveindateService;
	}

	public ReferralsourceService getReferralsourceService() {
		return referralsourceService;
	}

	public void setReferralsourceService(ReferralsourceService referralsourceService) {
		this.referralsourceService = referralsourceService;
	}

	public MedicalassistanceService getMedicalassistanceService() {
		return medicalassistanceService;
	}

	public void setMedicalassistanceService(MedicalassistanceService medicalassistanceService) {
		this.medicalassistanceService = medicalassistanceService;
	}	
	
	@Autowired private ProjectcocService projectcocService;


	public ProjectcocService getProjectcocService() {
		return projectcocService;
	}

	public void setProjectcocService(ProjectcocService projectcocService) {
		this.projectcocService = projectcocService;
	}
	
	@Autowired private FunderService funderService;
	@Autowired private AffiliationService affiliationService;


	public FunderService getFunderService() {
		return funderService;
	}

	public void setFunderService(FunderService funderService) {
		this.funderService = funderService;
	}

	public AffiliationService getAffiliationService() {
		return affiliationService;
	}

	public void setAffiliationService(AffiliationService affiliationService) {
		this.affiliationService = affiliationService;
	}
	
	@Autowired ProjectGroupService projectGroupService;


	public ProjectGroupService getProjectGroupService() {
		return projectGroupService;
	}

	public void setProjectGroupService(ProjectGroupService projectGroupService) {
		this.projectGroupService = projectGroupService;
	}
	
	@Autowired NonCashBenefitService nonCashBenefitService;


	public NonCashBenefitService getNonCashBenefitService() {
		return nonCashBenefitService;
	}

	public void setNonCashBenefitService(NonCashBenefitService nonCashBenefitService) {
		this.nonCashBenefitService = nonCashBenefitService;
	}
	
	@Autowired SiteService siteService;


	public SiteService getSiteService() {
		return siteService;
	}

	public void setSiteService(SiteService siteService) {
		this.siteService = siteService;
	}

	@Autowired InventoryService inventoryService;


	public InventoryService getInventoryService() {
		return inventoryService;
	}

	public void setInventoryService(InventoryService inventoryService) {
		this.inventoryService = inventoryService;
	}
	
	@Autowired public ClientService clientService;


	public ClientService getClientService() {
		return clientService;
	}

	public void setClientService(ClientService clientService) {
		this.clientService = clientService;
	}

	public SearchService getSearchService() {
		return searchService;
	}

	public void setSearchService(SearchService searchService) {
		this.searchService = searchService;
	}
}