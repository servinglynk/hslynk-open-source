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
import com.servinglynk.hmis.warehouse.service.impl.ApiMethodServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.AuthorizationServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.DeveloperCompanyServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.EnrollmentServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.InformationReleasesServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.PasswordResetServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.PermissionSetServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.ProfileServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.RoleServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.SessionServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.SharingRuleServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.TrustedAppServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.UsernameChangeServiceImpl;
import com.servinglynk.hmis.warehouse.service.impl.VerificationServiceImpl;


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
}
