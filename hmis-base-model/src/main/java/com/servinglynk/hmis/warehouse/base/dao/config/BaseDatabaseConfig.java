package com.servinglynk.hmis.warehouse.base.dao.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.servinglynk.hmis.warehouse.base.dao.AccountConsentDaoImpl;
import com.servinglynk.hmis.warehouse.base.dao.AccountDaoImpl;
import com.servinglynk.hmis.warehouse.base.dao.AccountDataChangeDaoImpl;
import com.servinglynk.hmis.warehouse.base.dao.ApiMethodDaoImpl;
import com.servinglynk.hmis.warehouse.base.dao.BaseDaoFactoryImpl;
import com.servinglynk.hmis.warehouse.base.dao.DeveloperCompanyAccountDaoImpl;
import com.servinglynk.hmis.warehouse.base.dao.DeveloperCompanyDaoImpl;
import com.servinglynk.hmis.warehouse.base.dao.DeveloperCompanyStatusDaoImpl;
import com.servinglynk.hmis.warehouse.base.dao.DeveloperServiceDaoImpl;
import com.servinglynk.hmis.warehouse.base.dao.HmisUserDao;
import com.servinglynk.hmis.warehouse.base.dao.HmisUserDaoImpl;
import com.servinglynk.hmis.warehouse.base.dao.OrganizationDao;
import com.servinglynk.hmis.warehouse.base.dao.OrganizationDaoImpl;
import com.servinglynk.hmis.warehouse.base.dao.PasswordResetDaoImpl;
import com.servinglynk.hmis.warehouse.base.dao.PermissionSetDaoImpl;
import com.servinglynk.hmis.warehouse.base.dao.ProfileAclDaoImpl;
import com.servinglynk.hmis.warehouse.base.dao.ProfileDaoImpl;
import com.servinglynk.hmis.warehouse.base.dao.ProjectGroupDaoImpl;
import com.servinglynk.hmis.warehouse.base.dao.PropertyDaoImpl;
import com.servinglynk.hmis.warehouse.base.dao.RedirectUriDaoImpl;
import com.servinglynk.hmis.warehouse.base.dao.RefreshTokenDaoImpl;
import com.servinglynk.hmis.warehouse.base.dao.RoleDaoImpl;
import com.servinglynk.hmis.warehouse.base.dao.ServiceApiMethodDaoImpl;
import com.servinglynk.hmis.warehouse.base.dao.ServiceDaoImpl;
import com.servinglynk.hmis.warehouse.base.dao.ServiceStatusDaoImpl;
import com.servinglynk.hmis.warehouse.base.dao.SessionDaoImpl;
import com.servinglynk.hmis.warehouse.base.dao.TrustedAppDaoImpl;
import com.servinglynk.hmis.warehouse.base.dao.TrustedAppStatusDaoImpl;
import com.servinglynk.hmis.warehouse.base.dao.VerificationDaoImpl;

@Configuration
public class BaseDatabaseConfig {


	@Bean
	public HmisUserDao hmisUserDao()
	{
		return new HmisUserDaoImpl();
	}

	@Bean
	public OrganizationDao organizationDao() { 
		return new OrganizationDaoImpl();
	}	
	@Bean
	public DeveloperCompanyDaoImpl developerCompanyDao(){
		return new DeveloperCompanyDaoImpl();
	}
	
	@Bean
	public AccountDaoImpl accountDao(){

		return new AccountDaoImpl();
	}
	
	
	@Bean
	public DeveloperCompanyAccountDaoImpl developerCompanyAccountDao(){
		return new DeveloperCompanyAccountDaoImpl();
	}
	
	@Bean
	public DeveloperServiceDaoImpl developerServiceDao(){
		return new DeveloperServiceDaoImpl();
	}
	
	
	@Bean
	public ServiceApiMethodDaoImpl serviceApiMethodDao(){
		return new ServiceApiMethodDaoImpl();
	}

	@Bean	
	public ServiceStatusDaoImpl serviceStatusDao(){
		return new ServiceStatusDaoImpl();
	}
	
	@Bean
	public ApiMethodDaoImpl apiMethodDao(){
		return new ApiMethodDaoImpl();
	}
	
	@Bean
	public TrustedAppDaoImpl trustedAppDao(){
		return new TrustedAppDaoImpl();
	}
	
	@Bean
	public TrustedAppStatusDaoImpl trustedAppStatusDao(){
		return new TrustedAppStatusDaoImpl();
	}
	
	@Bean
	public RedirectUriDaoImpl redirectUriDao(){
		return new RedirectUriDaoImpl();
	}
	
	
	@Bean
	public AccountConsentDaoImpl accountConsentDao(){
		return new AccountConsentDaoImpl();
	}
	
	@Bean
	public RefreshTokenDaoImpl refreshTokenDao(){
		return new RefreshTokenDaoImpl();
	}
	
	@Bean
	public SessionDaoImpl sessionDao(){
		return new SessionDaoImpl();
	}
	
	@Bean
	public String loginUri(){
		return new String("/hmis-authorization-service/login.html");
	}
	
	@Bean
	public String consentUri(){
		return new String("/hmis-authorization-service/consent.html");
	}
	
	
	@Bean
	public ServiceDaoImpl serviceDao(){
		return new ServiceDaoImpl();
	}
	
	@Bean
	public VerificationDaoImpl verificationDao(){
		return new VerificationDaoImpl();
	}
	
	@Bean
	public PasswordResetDaoImpl passwordResetDao(){
		return new PasswordResetDaoImpl();
	}
	
	@Bean
	public AccountDataChangeDaoImpl accountDataChangeDao(){
		return new AccountDataChangeDaoImpl();
	}
	@Bean
	public DeveloperCompanyStatusDaoImpl developerCompanyStatusDao(){
		return new DeveloperCompanyStatusDaoImpl();
	}
	
	@Bean
	public ProfileDaoImpl profileDao(){
		return new ProfileDaoImpl();
	}
	
	@Bean
	public ProfileAclDaoImpl profileAclDao(){
		return new ProfileAclDaoImpl();
	}
	
	@Bean
	public RoleDaoImpl roleDao(){
		return new RoleDaoImpl();
	}
	
	@Bean
	public PermissionSetDaoImpl permissionSetDao(){
		return new PermissionSetDaoImpl();
	}
	
	@Bean
	public ProjectGroupDaoImpl projectGroupDao(){
		return new ProjectGroupDaoImpl();
	}
	
	@Bean
	public PropertyDaoImpl propertyDao(){
		return new PropertyDaoImpl();
	}
}