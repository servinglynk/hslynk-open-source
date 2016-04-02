package com.servinglynk.hmis.warehouse.service.core;

import com.servinglynk.hmis.warehouse.base.service.core.BaseServiceFactory;
import com.servinglynk.hmis.warehouse.service.AffiliationService;
import com.servinglynk.hmis.warehouse.service.ClientService;
import com.servinglynk.hmis.warehouse.service.DateofengagementService;
import com.servinglynk.hmis.warehouse.service.DisabilitiesService;
import com.servinglynk.hmis.warehouse.service.DomesticviolenceService;
import com.servinglynk.hmis.warehouse.service.EmploymentService;
import com.servinglynk.hmis.warehouse.service.EnrollmentCocService;
import com.servinglynk.hmis.warehouse.service.EnrollmentService;
import com.servinglynk.hmis.warehouse.service.EntryrhspService;
import com.servinglynk.hmis.warehouse.service.EntryrhyService;
import com.servinglynk.hmis.warehouse.service.EntryssvfService;
import com.servinglynk.hmis.warehouse.service.ExitService;
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



public interface ParentServiceFactory  extends BaseServiceFactory {
	

	EnrollmentService getEnrollmentService();
	EmploymentService getEmploymentService();
	DateofengagementService getDateofengagementService();
	DisabilitiesService getDisabilitiesService();
	DomesticviolenceService getDomesticviolenceService();
	EnrollmentCocService getEnrollmentCocService();
	HealthinsuranceService getHealthinsuranceService();
	MedicalassistanceService getMedicalassistanceService();
	NoncashbenefitsService getNoncashbenefitsService();	
	PathstatusService getPathstatusService();
	ResidentialmoveindateService getResidentialmoveindateService();
	HealthstatusService getHealthstatusService();
	RhybcpstatusService getRhybcpstatusService();
	OrganizationService getOrganizationService();
	ProjectcocService getProjectcocService();
	FunderService getFunderService();
	AffiliationService getAffiliationService();
	SiteService getSiteService();
	InventoryService getInventoryService();
	ProjectService getProjectService();
	ExitService getExitService();
	HousingAssessmentDispositionService getHousingAssessmentDispositionService();
	VeteranInfoService getVeteranInfoService();
	IncomeAndSourceService getIncomeAndSourceService();
	ExitpathService getExitpathService();
	ExitrhyService getExitrhyService();
	EntryrhspService getEntryrhspService();
	EntryrhyService getEntryrhyService();
	EntryssvfService getEntryssvfService();
	ServicefareferralService getServicefareferralService();
	ClientService getClientService();
}