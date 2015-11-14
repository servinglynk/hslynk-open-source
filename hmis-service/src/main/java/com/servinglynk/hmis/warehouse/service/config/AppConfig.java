package com.servinglynk.hmis.warehouse.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.servinglynk.hmis.warehouse.common.ValidationBean;
import com.servinglynk.hmis.warehouse.core.web.interceptor.ApiAuthCheckInterceptor;
import com.servinglynk.hmis.warehouse.core.web.interceptor.SessionHelper;
import com.servinglynk.hmis.warehouse.core.web.interceptor.TrustedAppHelper;
import com.servinglynk.hmis.warehouse.dao.DeveloperCompanyDaoImpl;
import com.servinglynk.hmis.warehouse.dao.HmisUserDao;
import com.servinglynk.hmis.warehouse.dao.HmisUserDaoImpl;
import com.servinglynk.hmis.warehouse.dao.SyncListDao;
import com.servinglynk.hmis.warehouse.dao.SyncListDaoImpl;
import com.servinglynk.hmis.warehouse.service.core.HmisUserService;
import com.servinglynk.hmis.warehouse.service.core.HmisUserServiceImpl;
import com.servinglynk.hmis.warehouse.service.core.ParentServiceFactory;
import com.servinglynk.hmis.warehouse.service.core.ParentServiceFactoryImpl;
import com.servinglynk.hmis.warehouse.service.core.SyncListService;
import com.servinglynk.hmis.warehouse.service.core.SyncListServiceImpl;
import com.servinglynk.hmis.warehouse.service.core.security.LocalApiAuthChecker;
import com.servinglynk.hmis.warehouse.service.impl.AccountServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.AffiliationServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.ApiMethodServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.AuthorizationServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.ClientServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.CommercialSexualExploitationServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.ConnectionwithsoarServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.DateofengagementServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.DeveloperCompanyServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.DisabilitiesServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.DomesticViolenceServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.EmploymentServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.EnrollmentServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.ExitPlansActionsServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.ExitServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.FamilyReunificationServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.FunderServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.HealthInsuranceServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.HealthStatusServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.HousingAssessmentDispositionServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.IncomeAndSourceServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.InformationReleasesServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.InventoryServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.LastPermanentAddressServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.MedicalassistanceServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.NonCashBenefitServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.OrganizationServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.PasswordResetServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.PathstatusServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.PercentamiServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.PermissionSetServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.ProfileServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.ProjectCompletionStatusServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.ProjectGroupServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.ProjectServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.ProjectcocServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.ReferralsourceServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.ResidentialmoveindateServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.RhybcpstatusServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.RoleServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.SchoolstatusServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.ServicesServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.SessionServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.SexualorientationServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.SharingRuleServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.SiteServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.TrustedAppServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.UsernameChangeServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.VerificationServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.VeteranInfoServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.WorstHousingSituationServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.YouthCriticalIssuesServiceImpl;


@Configuration
@EnableWebMvc
@EnableTransactionManagement
public class AppConfig extends WebMvcConfigurerAdapter  {


	@Bean
	public TrustedAppHelper trustedAppHelper(){
		return new TrustedAppHelper();
	}
	
	
	@Bean
	public SessionHelper sessionHelper(){
		return new SessionHelper();
	}
	
	@Bean
	public LocalApiAuthChecker apiAuthChecker(){
		return new LocalApiAuthChecker();
	}
	
	
	  @Override
	    public void addInterceptors(InterceptorRegistry registry) {
	        registry.addInterceptor(apiAuthCheckInterceptor());
	    }

/*	@Bean(name="enrollmentService")
	public EnrollmentService enrollmentService(){
		return new EnrollmentServiceImpl();
	}*/
	
	@Bean(name="serviceFactory")
	public ParentServiceFactory serviceFactory(){
		return new ParentServiceFactoryImpl();
	}
	
	@Bean(name="hmisUserService")
	public HmisUserService hmisUserService(){
		return new HmisUserServiceImpl();
	}
	
	@Bean(name="syncListService")
	public SyncListService syncListService(){
		return new SyncListServiceImpl();
	}
	@Bean(name="hmisUserDao")
	public HmisUserDao hmisUserDao() {
		return new HmisUserDaoImpl();
	}
	
	@Bean(name="syncListDao")
	public SyncListDao syncListDao() {
		return new SyncListDaoImpl();
	}
	
	@Bean
	public DeveloperCompanyDaoImpl developerCompanyDao(){
		return new DeveloperCompanyDaoImpl(); 
	}
	
	@Bean
	public DeveloperCompanyServiceImpl developerCompanyService(){
		return new DeveloperCompanyServiceImpl();
	}
	
	
	
	@Bean
	public ValidationBean validationBean(){
		ValidationBean bean =new ValidationBean();
		bean.setFnMaxLength(256);
		bean.setLnMaxLength(256);
		bean.setLockoutMinutes("200");
		bean.setMaxExternalDeviceIdLength(256);
		bean.setMaxFriendlyNameLength(256);
		bean.setMaxLength(256);
		bean.setMaxPwattempts(5);
		bean.setMinLength(6);
		bean.setPwMinLength(6);
		bean.setPwMaxLength(256);
		bean.setMnMaxLength(128);
		
		
		
		return bean;
	}
	
	
	@Bean
	public TrustedAppServiceImpl trustedAppService(){
		return new TrustedAppServiceImpl();
	}
	
	@Bean
	public SessionServiceImpl sessionService(){
		return new SessionServiceImpl();
	}
	
	@Bean
	public AccountServiceImpl accountService(){
		return new AccountServiceImpl();
	}
	
	@Bean 
	public AuthorizationServiceImpl authorizationService(){
		return new AuthorizationServiceImpl();
	}
	

	@Bean 
	public UsernameChangeServiceImpl usernameChangeService(){
		return new UsernameChangeServiceImpl();
	}
	
	@Bean 
	public PasswordResetServiceImpl passwordResetService(){
		return new PasswordResetServiceImpl();
	}
	
	@Bean 
	public VerificationServiceImpl verificationService(){
		return new VerificationServiceImpl();
	}

	 @Bean
	 public String notificationurl(){
		 return "http://localhost:8080/notification-service/rest";
	 }
	 
	 
	 @Bean
	 public ApiMethodServiceImpl apiMethodService(){
		 return new ApiMethodServiceImpl();
	 }
	 
	 
	 @Bean
	 public ApiAuthCheckInterceptor apiAuthCheckInterceptor(){
		 return new ApiAuthCheckInterceptor();
	 }
	 
	 @Bean
	 public RoleServiceImpl roleService(){
		 return new RoleServiceImpl();
	 }
	 
	 @Bean
	 public ProfileServiceImpl profileService(){
		 return new ProfileServiceImpl();
	 }
	 
	 @Bean
	 public PermissionSetServiceImpl permissionSetService(){
		 return new PermissionSetServiceImpl();
	 }
	 
	 @Bean
	 public SharingRuleServiceImpl sharingRuleService(){
		 return new SharingRuleServiceImpl();
	 }
	 
	 @Bean
	 public EnrollmentServiceImpl enrollmentService(){
		 return new EnrollmentServiceImpl();
	 }
	 
	 @Bean
	 public InformationReleasesServiceImpl informationReleasesService(){
		 return new InformationReleasesServiceImpl();
	 }
	 
	 @Bean
	 public ClientServiceImpl clientService(){
		 return new ClientServiceImpl();
	 }
	 
	 @Bean
	 public OrganizationServiceImpl organizationService(){
		 return new OrganizationServiceImpl();
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
	 public ProjectGroupServiceImpl projectGroupService(){
		 return new ProjectGroupServiceImpl();
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
}
