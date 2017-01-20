package com.servinglynk.hmis.warehouse.base.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.servinglynk.hmis.warehouse.base.dao.DeveloperCompanyDaoImpl;
import com.servinglynk.hmis.warehouse.base.dao.HmisUserDao;
import com.servinglynk.hmis.warehouse.base.dao.HmisUserDaoImpl;
import com.servinglynk.hmis.warehouse.base.service.BulkUploadService;
import com.servinglynk.hmis.warehouse.base.service.core.BaseServiceFactory;
import com.servinglynk.hmis.warehouse.base.service.core.BaseServiceFactoryImpl;
import com.servinglynk.hmis.warehouse.base.service.core.security.LocalApiAuthChecker;
import com.servinglynk.hmis.warehouse.base.service.impl.AccountServiceImpl;
import com.servinglynk.hmis.warehouse.base.service.impl.ApiMethodServiceImpl;
import com.servinglynk.hmis.warehouse.base.service.impl.AuthorizationServiceImpl;
import com.servinglynk.hmis.warehouse.base.service.impl.BaseSearchServiceImpl;
import com.servinglynk.hmis.warehouse.base.service.impl.BulkUploadServiceImpl;
import com.servinglynk.hmis.warehouse.base.service.impl.ClientConsentServiceImpl;
import com.servinglynk.hmis.warehouse.base.service.impl.ClientDataElementsServiceImpl;
import com.servinglynk.hmis.warehouse.base.service.impl.DeveloperCompanyServiceImpl;
import com.servinglynk.hmis.warehouse.base.service.impl.HealthServiceImpl;
import com.servinglynk.hmis.warehouse.base.service.impl.PasswordResetServiceImpl;
import com.servinglynk.hmis.warehouse.base.service.impl.PermissionSetServiceImpl;
import com.servinglynk.hmis.warehouse.base.service.impl.ProfileServiceImpl;
import com.servinglynk.hmis.warehouse.base.service.impl.ProjectGroupServiceImpl;
import com.servinglynk.hmis.warehouse.base.service.impl.ProjectServiceImpl;
import com.servinglynk.hmis.warehouse.base.service.impl.RoleServiceImpl;
import com.servinglynk.hmis.warehouse.base.service.impl.SessionServiceImpl;
import com.servinglynk.hmis.warehouse.base.service.impl.TrustedAppServiceImpl;
import com.servinglynk.hmis.warehouse.base.service.impl.UsernameChangeServiceImpl;
import com.servinglynk.hmis.warehouse.base.service.impl.VerificationServiceImpl;
import com.servinglynk.hmis.warehouse.common.ValidationBean;
import com.servinglynk.hmis.warehouse.core.web.interceptor.ApiAuthCheckInterceptor;
import com.servinglynk.hmis.warehouse.core.web.interceptor.SessionHelper;
import com.servinglynk.hmis.warehouse.core.web.interceptor.TrustedAppHelper;


@Configuration
@EnableWebMvc
@EnableTransactionManagement
@Import({com.servinglynk.hmis.warehouse.client.config.SpringConfig.class})
public class BaseServiceConfig extends WebMvcConfigurerAdapter  {


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
	
	@Bean(name="serviceFactory")
	public BaseServiceFactory serviceFactory(){
		return new BaseServiceFactoryImpl();
	}

	@Bean(name="hmisUserDao")
	public HmisUserDao hmisUserDao() {
		return new HmisUserDaoImpl();
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
	 public ProjectGroupServiceImpl projectGroupService(){
		 return new ProjectGroupServiceImpl();
	 }	 
	 
	 @Bean
	 public BulkUploadService bulkUploadService() {
		 return new BulkUploadServiceImpl();
	 }
	 
	 @Bean
	 public BaseSearchServiceImpl baseSearchService(){
		 return new BaseSearchServiceImpl();
	 }
	 
	 @Bean
	 public ProjectServiceImpl baseProjectService(){
		 return new ProjectServiceImpl();
	 }
	 
	 @Bean
	 public HealthServiceImpl healthService(){
		 return new HealthServiceImpl();
	 }
	 
	 @Bean
	 public ClientConsentServiceImpl clientConsentService(){
		 return new ClientConsentServiceImpl();
	 }
	 
	 @Bean
	 public ClientDataElementsServiceImpl clientDataElementsService(){
		 return new ClientDataElementsServiceImpl();
	 }
}