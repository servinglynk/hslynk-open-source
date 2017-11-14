package com.servinglynk.hmis.warehouse.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.servinglynk.hmis.warehouse.service.core.ParentServiceFactory;
import com.servinglynk.hmis.warehouse.service.core.ParentServiceFactoryImpl;
import com.servinglynk.hmis.warehouse.service.impl.AffiliationServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.BulkUploadErrorActivityServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.ClientServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.ConnectionwithsoarServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.ContactServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.DateofengagementServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.DisabilitiesServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.DomesticviolenceServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.EducationServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.EmploymentServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.EnrollmentCocServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.EnrollmentServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.EntryrhspServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.EntryrhyServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.EntryssvfServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.ExitServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.ExithousingassessmentServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.ExitrhyServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.FunderServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.GeographyServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.HealthinsuranceServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.HealthstatusServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.HousingAssessmentDispositionServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.IncomeAndSourceServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.InventoryServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.MedicalassistanceServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.NoncashbenefitsServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.OrganizationServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.PathstatusServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.ProjectServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.ProjectcocServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.RHYAfterCareServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.ResidentialmoveindateServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.RhybcpstatusServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.SearchServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.ServicefareferralServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.VashExitReasonServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.VeteranInfoServiceImpl;


@Configuration
@EnableTransactionManagement
public class ServiceConfig  {
	
	@Bean
	public ParentServiceFactory serviceFactory(){
		return new ParentServiceFactoryImpl();
	}

	@Bean
	public EnrollmentServiceImpl enrollmentService(){
		return new EnrollmentServiceImpl();
	}
	
	@Bean
	public EmploymentServiceImpl employmentService(){
		return new EmploymentServiceImpl();
	}

	@Bean
	public DateofengagementServiceImpl dateofengagementService(){
		return new DateofengagementServiceImpl();
	}
	
	@Bean
	public DisabilitiesServiceImpl disabilitiesService(){
		return new DisabilitiesServiceImpl();
	}
	
	@Bean
	public DomesticviolenceServiceImpl domesticviolenceService(){
		return new DomesticviolenceServiceImpl();
	}
	
	@Bean
	public EnrollmentCocServiceImpl enrollmentCocService (){
		return new EnrollmentCocServiceImpl();
	}
	
	@Bean
	public HealthinsuranceServiceImpl healthinsuranceService (){
		return new HealthinsuranceServiceImpl();
	}
	
	@Bean
	public MedicalassistanceServiceImpl medicalassistanceService (){
		return new MedicalassistanceServiceImpl();
	}
	
	@Bean
	public NoncashbenefitsServiceImpl noncashbenefitsService (){
		return new NoncashbenefitsServiceImpl();
	}
	
	@Bean
	public PathstatusServiceImpl pathstatusService (){
		return new PathstatusServiceImpl();
	}
	
	@Bean
	public ResidentialmoveindateServiceImpl residentialmoveindateService (){
		return new ResidentialmoveindateServiceImpl();
	}
	
	@Bean
	public HealthstatusServiceImpl healthstatusService(){
		return new HealthstatusServiceImpl();
	}

	@Bean
	public RhybcpstatusServiceImpl rhybcpstatusService(){
		return new RhybcpstatusServiceImpl();
	}
	
	@Bean
	public OrganizationServiceImpl organizationService(){
		return new OrganizationServiceImpl();
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
	 public InventoryServiceImpl inventoryService(){
		 return new InventoryServiceImpl();
	 }
	 
	 @Bean
	 public ParentServiceFactoryImpl parentServiceFactory(){
		 return new ParentServiceFactoryImpl();
	 }
	 @Bean
	 public ProjectcocServiceImpl projectcocService(){
		 return new ProjectcocServiceImpl();
	 }
	 
	 @Bean
	 public ProjectServiceImpl projectService(){
		 return new ProjectServiceImpl();
	 }
	 
	 @Bean
	 public ExitServiceImpl exitService(){
		 return new ExitServiceImpl();
	 }
	 
	 @Bean
	 public HousingAssessmentDispositionServiceImpl housingAssessmentDispositionService(){
		 return new HousingAssessmentDispositionServiceImpl();
	 }
	 
	 @Bean
	 public VeteranInfoServiceImpl veteranInfoService(){
		 return new VeteranInfoServiceImpl();
	 }
	 
	 @Bean
	 public IncomeAndSourceServiceImpl incomeAndSourceService(){
		 return new IncomeAndSourceServiceImpl();
	 }
	 
	 @Bean
	 public ExitrhyServiceImpl exitrhyService(){
		 return new ExitrhyServiceImpl();
	 }
	
	@Bean
	public EntryrhspServiceImpl entryrhspService(){
		return new EntryrhspServiceImpl();
	}
	
	@Bean
	public EntryrhyServiceImpl entryrhyService(){
		return new EntryrhyServiceImpl();
	}

	@Bean
	public EntryssvfServiceImpl entryssvfService(){
		return new EntryssvfServiceImpl();
	}
	
	@Bean
	public ServicefareferralServiceImpl servicefareferralService(){
		return new ServicefareferralServiceImpl();
	}
	
	@Bean
	public ClientServiceImpl clientService(){
		return new ClientServiceImpl();
	}
	
	@Bean
	public ContactServiceImpl contactService(){
		return new ContactServiceImpl();
	}
	
	@Bean
	public EducationServiceImpl educationService(){
		return new EducationServiceImpl();
	}
	@Bean
	public ExithousingassessmentServiceImpl exithousingassessmentService(){
		return new ExithousingassessmentServiceImpl();
	}
	
	@Bean
	public SearchServiceImpl searchService(){
		return new SearchServiceImpl();
	}
	 
	 @Bean BulkUploadErrorActivityServiceImpl bulkUploadErrorActivityService() {
		 return new BulkUploadErrorActivityServiceImpl();
	 }
	 
	 @Bean GeographyServiceImpl geographyService() {
		 return new GeographyServiceImpl();
	 }
	 
	 @Bean ConnectionwithsoarServiceImpl connectionwithsoarService() {
		 return new ConnectionwithsoarServiceImpl();
	 }
	 
	 @Bean RHYAfterCareServiceImpl RHYAfterCareService() {
		 return new RHYAfterCareServiceImpl();
	 }
	 
	 @Bean VashExitReasonServiceImpl VashExitReasonService() {
		 return new VashExitReasonServiceImpl();
	 }
}