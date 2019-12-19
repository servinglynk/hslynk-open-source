package com.servinglynk.hmis.warehouse.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.servinglynk.hmis.warehouse.dao.SyncListDao;
import com.servinglynk.hmis.warehouse.dao.SyncListDaoImpl;
import com.servinglynk.hmis.warehouse.service.core.ParentServiceFactory;
import com.servinglynk.hmis.warehouse.service.core.ParentServiceFactoryImpl;
import com.servinglynk.hmis.warehouse.service.impl.AffiliationServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.BulkUploadErrorActivityServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.ClientServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.CommercialSexualExploitationServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.ConnectionwithsoarServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.DateofengagementServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.DisabilitiesServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.DomesticViolenceServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.EmploymentServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.EnrollmentCocServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.EnrollmentServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.EnrollmentServiceImplV2;
import com.servinglynk.hmis.warehouse.service.impl.ExitPlansActionsServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.ExitServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.FamilyReunificationServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.FunderServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.HMISTypeServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.HealthInsuranceServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.HealthStatusServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.HmisHouseHoldServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.HousingAssessmentDispositionServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.IncomeAndSourceServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.InformationReleasesServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.InventoryServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.LastPermanentAddressServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.MedicalassistanceServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.NonCashBenefitServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.OrganizationServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.PathstatusServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.PercentamiServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.ProjectCompletionStatusServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.ProjectServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.ProjectServiceImplV2;
import com.servinglynk.hmis.warehouse.service.impl.ProjectcocServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.QuestionServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.ReferralsourceServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.ResidentialmoveindateServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.RhybcpstatusServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.SchoolstatusServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.ServicesServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.SexualorientationServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.SiteServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.VeteranInfoServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.WorstHousingSituationServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.YouthCriticalIssuesServiceImpl;


@Configuration
@EnableTransactionManagement
public class ServiceConfig  {
	
	@Bean(name="serviceFactory")
	public ParentServiceFactory serviceFactory(){
		return new ParentServiceFactoryImpl();
	}
	
	@Bean(name="syncListDao")
	public SyncListDao syncListDao() {
		return new SyncListDaoImpl();
	}
	
	@Bean
	public OrganizationServiceImpl  organizationService(){
		return new OrganizationServiceImpl();
	}
	 	 
	 @Bean
	 public EnrollmentServiceImpl enrollmentService(){
		 return new EnrollmentServiceImpl();
	 }
	 
	 @Bean
	 public EnrollmentCocServiceImpl enrollmentCocService() {
		 return new EnrollmentCocServiceImpl();
	 }
	 
	 @Bean
	 public InformationReleasesServiceImpl informationReleasesService(){
		 return new InformationReleasesServiceImpl();
	 }
	 
	 @Bean
	 public ProjectServiceImpl projectServiceImpl(){
		 return new ProjectServiceImpl();
	 }
	 
	 @Bean
	 public ExitServiceImpl exitService(){
		 return new ExitServiceImpl();
	 }
	 
	 @Bean
	 public EmploymentServiceImpl employmentService(){
		 return new EmploymentServiceImpl();
	 }
	 
	 @Bean
	 public VeteranInfoServiceImpl veteranInfoService(){
		 return new VeteranInfoServiceImpl();
	 }
	 
	 @Bean
	 public DisabilitiesServiceImpl disabilitiesService(){
		 return new DisabilitiesServiceImpl();
	 }
	 
	 @Bean
	 public ExitPlansActionsServiceImpl exitPlansActionsService(){
		 return new ExitPlansActionsServiceImpl();
	 }
	 
	 @Bean
	 public ConnectionwithsoarServiceImpl connectionwithsoarService(){
		 return new ConnectionwithsoarServiceImpl();
	 }
	 
	 @Bean
	 public FamilyReunificationServiceImpl familyReunificationService(){
		 return new FamilyReunificationServiceImpl();
	 }
	 
	 
	 @Bean
	 public HousingAssessmentDispositionServiceImpl housingAssessmentDispositionService(){
		 return new HousingAssessmentDispositionServiceImpl();
	 }
	 
	 @Bean
	 public ProjectCompletionStatusServiceImpl projectCompletionStatusService(){
		 return new ProjectCompletionStatusServiceImpl();
	 }
	 
	 @Bean
	 public IncomeAndSourceServiceImpl incomeAndSourceService(){
		 return new IncomeAndSourceServiceImpl();
	 }
	 
	 @Bean
	 public HealthInsuranceServiceImpl healthInsuranceService(){
		 return new HealthInsuranceServiceImpl();
	 }
	 
	 @Bean
	 public ServicesServiceImpl servicesServiceImpl(){
		 return new ServicesServiceImpl();
	 }
	 
	 @Bean
	 public HealthStatusServiceImpl healthStatusService(){
		 return new HealthStatusServiceImpl();
	 }
	 
	 @Bean
	 public CommercialSexualExploitationServiceImpl commercialSexualExploitationService(){
		 return new CommercialSexualExploitationServiceImpl();
	 }
	 
	 @Bean
	 public DateofengagementServiceImpl dateofengagementService(){
		 return new DateofengagementServiceImpl();
	 }
	 
	 @Bean
	 public DomesticViolenceServiceImpl domesticViolenceService(){
		 return new DomesticViolenceServiceImpl();
	 }
	 
	 @Bean
	 public LastPermanentAddressServiceImpl lastPermanentAddressService(){
		 return new LastPermanentAddressServiceImpl();
	 }
	 
	 @Bean
	 public YouthCriticalIssuesServiceImpl youthCriticalIssuesService(){
		 return new YouthCriticalIssuesServiceImpl();
	 }
	 
	 @Bean
	 public WorstHousingSituationServiceImpl worstHousingSituationService(){
		 return new WorstHousingSituationServiceImpl();
	 }
	 
	 @Bean
	 public SexualorientationServiceImpl sexualorientationServiceImpl(){
		 return new SexualorientationServiceImpl();
	 }
	 
	 @Bean
	 public SchoolstatusServiceImpl schoolstatusService(){
		 return new SchoolstatusServiceImpl();
	 }
	 
	 @Bean
	 public PathstatusServiceImpl pathstatusService(){
		 return new PathstatusServiceImpl();
	 }
	 
	 @Bean
	 public PercentamiServiceImpl percentamiService(){
		 return new PercentamiServiceImpl();
	 }
	 
	 @Bean
	 public RhybcpstatusServiceImpl rhybcpstatusService(){
		 return new RhybcpstatusServiceImpl();
	 }
	 
	 @Bean
	 public ResidentialmoveindateServiceImpl residentialmoveindateService(){
		 return new ResidentialmoveindateServiceImpl();
	 }
	 
	 @Bean
	 public ReferralsourceServiceImpl referralsourceService(){
		 return new ReferralsourceServiceImpl();
	 }
	 
	 @Bean
	 public MedicalassistanceServiceImpl medicalassistanceService(){
		 return new MedicalassistanceServiceImpl();
	 }
	 
	 @Bean
	 public ProjectcocServiceImpl projectcocService(){
		 return new ProjectcocServiceImpl();
	 }
	 
	 @Bean
	 public AffiliationServiceImpl affiliationService(){
		 return new AffiliationServiceImpl();
	 }
	 
	 @Bean
	 public FunderServiceImpl funderService(){
		 return new FunderServiceImpl();
	 }
	 
	 @Bean
	 public NonCashBenefitServiceImpl nonCashBenefitService(){
		 return new NonCashBenefitServiceImpl();
	 }
	 
	 @Bean
	 public SiteServiceImpl siteService(){
		 return new SiteServiceImpl();
	 }
	 
	 @Bean
	 public InventoryServiceImpl inventoryService(){
		 return new InventoryServiceImpl();
	 }
	 
	 @Bean
	 public ParentServiceFactoryImpl parentServiceFactory(){
		 return new ParentServiceFactoryImpl();
	 }
	 
	 @Bean
	 public ClientServiceImpl clientService(){
		 return new ClientServiceImpl();
	 }
	 
	 
	 @Bean BulkUploadErrorActivityServiceImpl bulkUploadErrorActivityService() {
		 return new BulkUploadErrorActivityServiceImpl();
	 }
	 
	 @Bean
	 public HMISTypeServiceImpl hmisTypeService() {
		 return new HMISTypeServiceImpl();
	 }
	 
	 @Bean
	 public QuestionServiceImpl questionService() {
		 return new QuestionServiceImpl();
	 }
	 
	 @Bean
	 public EnrollmentServiceImplV2 enrollmentServiceV2() {
		 return new EnrollmentServiceImplV2();
	 }
	 @Bean
	 public ProjectServiceImplV2 projectServiceV2() {
		 return new ProjectServiceImplV2();
	 }
	 
	 @Bean
	 public HmisHouseHoldServiceImpl hmisHouseHoldService() {
		 return new HmisHouseHoldServiceImpl();
	 }
}