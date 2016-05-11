package com.servinglynk.hmis.warehouse.service.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.servinglynk.hmis.warehouse.base.service.core.BaseServiceFactoryImpl;
import com.servinglynk.hmis.warehouse.service.AffiliationService;
import com.servinglynk.hmis.warehouse.service.ClientService;
import com.servinglynk.hmis.warehouse.service.ContactService;
import com.servinglynk.hmis.warehouse.service.DateofengagementService;
import com.servinglynk.hmis.warehouse.service.DisabilitiesService;
import com.servinglynk.hmis.warehouse.service.DomesticviolenceService;
import com.servinglynk.hmis.warehouse.service.EducationService;
import com.servinglynk.hmis.warehouse.service.EmploymentService;
import com.servinglynk.hmis.warehouse.service.EnrollmentCocService;
import com.servinglynk.hmis.warehouse.service.EnrollmentService;
import com.servinglynk.hmis.warehouse.service.EntryrhspService;
import com.servinglynk.hmis.warehouse.service.EntryrhyService;
import com.servinglynk.hmis.warehouse.service.EntryssvfService;
import com.servinglynk.hmis.warehouse.service.ExitService;
import com.servinglynk.hmis.warehouse.service.ExithousingassessmentService;
import com.servinglynk.hmis.warehouse.service.ExitpathService;
import com.servinglynk.hmis.warehouse.service.ExitrhyService;
import com.servinglynk.hmis.warehouse.service.FunderService;
import com.servinglynk.hmis.warehouse.service.HealthinsuranceService;
import com.servinglynk.hmis.warehouse.service.HealthstatusService;
import com.servinglynk.hmis.warehouse.service.HousingAssessmentDispositionService;
import com.servinglynk.hmis.warehouse.service.IncomeAndSourceService;
import com.servinglynk.hmis.warehouse.service.InventoryService;
import com.servinglynk.hmis.warehouse.service.MedicalassistanceService;
import com.servinglynk.hmis.warehouse.service.NoncashbenefitsService;
import com.servinglynk.hmis.warehouse.service.OrganizationService;
import com.servinglynk.hmis.warehouse.service.PathstatusService;
import com.servinglynk.hmis.warehouse.service.ProjectService;
import com.servinglynk.hmis.warehouse.service.ProjectcocService;
import com.servinglynk.hmis.warehouse.service.ResidentialmoveindateService;
import com.servinglynk.hmis.warehouse.service.RhybcpstatusService;
import com.servinglynk.hmis.warehouse.service.ServicefareferralService;
import com.servinglynk.hmis.warehouse.service.SiteService;
import com.servinglynk.hmis.warehouse.service.VeteranInfoService;

@Component
public class ParentServiceFactoryImpl extends BaseServiceFactoryImpl  implements ParentServiceFactory {

	@Autowired public OrganizationService organizationService;
	@Autowired public EmploymentService employmentService;
	@Autowired public EnrollmentService enrollmentService;
	@Autowired public DateofengagementService dateofengagementService;
	@Autowired public DisabilitiesService disabilitiesService;
	@Autowired public DomesticviolenceService domesticviolenceService;
	@Autowired public EnrollmentCocService enrollmentCocService;
	@Autowired public HealthinsuranceService healthinsuranceService;
	@Autowired public MedicalassistanceService medicalassistanceService;
	@Autowired public NoncashbenefitsService noncashbenefitsService;
	@Autowired public PathstatusService pathstatusService;
	@Autowired public ResidentialmoveindateService residentialmoveindateService;
	@Autowired public HealthstatusService healthstatusService;
	@Autowired public RhybcpstatusService rhybcpstatusService;
	@Autowired public ProjectService projectService;
	@Autowired public ExitService exitService;
	@Autowired public HousingAssessmentDispositionService housingAssessmentDispositionService;
	@Autowired public VeteranInfoService veteranInfoService;
	@Autowired public IncomeAndSourceService incomeAndSourceService;
	@Autowired public ExitpathService exitpathService;
	@Autowired public ExitrhyService exitrhyService;
	@Autowired public EntryrhspService entryrhspService;
	@Autowired public EntryrhyService entryrhyService;
	@Autowired public EntryssvfService entryssvfService;
	@Autowired public ServicefareferralService servicefareferralService;
	@Autowired public ClientService clientService;
	@Autowired public ContactService contactService;
	@Autowired public EducationService educationService;
	@Autowired public ExithousingassessmentService exithousingassessmentService;
	
	public RhybcpstatusService getRhybcpstatusService() {
		return rhybcpstatusService;
	}

	public void setRhybcpstatusService(RhybcpstatusService rhybcpstatusService) {
		this.rhybcpstatusService = rhybcpstatusService;
	}

	public HealthstatusService getHealthstatusService() {
		return healthstatusService;
	}

	public void setHealthstatusService(HealthstatusService healthstatusService) {
		this.healthstatusService = healthstatusService;
	}

	public ResidentialmoveindateService getResidentialmoveindateService() {
		return residentialmoveindateService;
	}

	public void setResidentialmoveindateService(ResidentialmoveindateService residentialmoveindateService) {
		this.residentialmoveindateService = residentialmoveindateService;
	}

	public PathstatusService getPathstatusService() {
		return pathstatusService;
	}

	public void setPathstatusService(PathstatusService pathstatusService) {
		this.pathstatusService = pathstatusService;
	}

	public NoncashbenefitsService getNoncashbenefitsService() {
		return noncashbenefitsService;
	}

	public void setNoncashbenefitsService(NoncashbenefitsService noncashbenefitsService) {
		this.noncashbenefitsService = noncashbenefitsService;
	}

	public MedicalassistanceService getMedicalassistanceService() {
		return medicalassistanceService;
	}

	public void setMedicalassistanceService(MedicalassistanceService medicalassistanceService) {
		this.medicalassistanceService = medicalassistanceService;
	}

	public HealthinsuranceService getHealthinsuranceService() {
		return healthinsuranceService;
	}

	public void setHealthinsuranceService(HealthinsuranceService healthinsuranceService) {
		this.healthinsuranceService = healthinsuranceService;
	}

	public EnrollmentCocService getEnrollmentCocService() {
		return enrollmentCocService;
	}

	public void setEnrollmentCocService(EnrollmentCocService enrollmentCocService) {
		this.enrollmentCocService = enrollmentCocService;
	}

	public DomesticviolenceService getDomesticviolenceService() {
		return domesticviolenceService;
	}

	public void setDomesticviolenceService(DomesticviolenceService domesticviolenceService) {
		this.domesticviolenceService = domesticviolenceService;
	}

	public DisabilitiesService getDisabilitiesService() {
		return disabilitiesService;
	}

	public void setDisabilitiesService(DisabilitiesService disabilitiesService) {
		this.disabilitiesService = disabilitiesService;
	}

	public DateofengagementService getDateofengagementService() {
		return dateofengagementService;
	}

	public void setDateofengagementService(DateofengagementService dateofengagementService) {
		this.dateofengagementService = dateofengagementService;
	}

	public EmploymentService getEmploymentService() {
		return employmentService;
	}

	public void setEmploymentService(EmploymentService employmentService) {
		this.employmentService = employmentService;
	}

	public EnrollmentService getEnrollmentService() {
		return enrollmentService;
	}

	public void setEnrollmentService(EnrollmentService enrollmentService) {
		this.enrollmentService = enrollmentService;
	}

	public OrganizationService getOrganizationService() {
		return organizationService;
	}

	public void setOrganizationService(OrganizationService organizationService) {
		this.organizationService = organizationService;
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

	public ProjectService getProjectService() {
		return projectService;
	}

	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}

	public ExitService getExitService() {
		return exitService;
	}

	public void setExitService(ExitService exitService) {
		this.exitService = exitService;
	}

	public HousingAssessmentDispositionService getHousingAssessmentDispositionService() {
		return housingAssessmentDispositionService;
	}

	public void setHousingAssessmentDispositionService(
			HousingAssessmentDispositionService housingAssessmentDispositionService) {
		this.housingAssessmentDispositionService = housingAssessmentDispositionService;
	}

	public VeteranInfoService getVeteranInfoService() {
		return veteranInfoService;
	}

	public void setVeteranInfoService(VeteranInfoService veteranInfoService) {
		this.veteranInfoService = veteranInfoService;
	}

	public IncomeAndSourceService getIncomeAndSourceService() {
		return incomeAndSourceService;
	}

	public void setIncomeAndSourceService(IncomeAndSourceService incomeAndSourceService) {
		this.incomeAndSourceService = incomeAndSourceService;
	}

	public ExitpathService getExitpathService() {
		return exitpathService;
	}

	public void setExitpathService(ExitpathService exitpathService) {
		this.exitpathService = exitpathService;
	}

	public ExitrhyService getExitrhyService() {
		return exitrhyService;
	}

	public void setExitrhyService(ExitrhyService exitrhyService) {
		this.exitrhyService = exitrhyService;
	}

	public EntryrhspService getEntryrhspService() {
		return entryrhspService;
	}

	public void setEntryrhspService(EntryrhspService entryrhspService) {
		this.entryrhspService = entryrhspService;
	}

	public EntryrhyService getEntryrhyService() {
		return entryrhyService;
	}

	public void setEntryrhyService(EntryrhyService entryrhyService) {
		this.entryrhyService = entryrhyService;
	}

	public EntryssvfService getEntryssvfService() {
		return entryssvfService;
	}

	public void setEntryssvfService(EntryssvfService entryssvfService) {
		this.entryssvfService = entryssvfService;
	}

	public ServicefareferralService getServicefareferralService() {
		return servicefareferralService;
	}

	public void setServicefareferralService(ServicefareferralService servicefareferralService) {
		this.servicefareferralService = servicefareferralService;
	}

	public ClientService getClientService() {
		return clientService;
	}

	public void setClientService(ClientService clientService) {
		this.clientService = clientService;
	}

	public ContactService getContactService() {
		return contactService;
	}

	public void setContactService(ContactService contactService) {
		this.contactService = contactService;
	}

	public EducationService getEducationService() {
		return educationService;
	}

	public void setEducationService(EducationService educationService) {
		this.educationService = educationService;
	}

	public ExithousingassessmentService getExithousingassessmentService() {
		return exithousingassessmentService;
	}

	public void setExithousingassessmentService(ExithousingassessmentService exithousingassessmentService) {
		this.exithousingassessmentService = exithousingassessmentService;
	}
}