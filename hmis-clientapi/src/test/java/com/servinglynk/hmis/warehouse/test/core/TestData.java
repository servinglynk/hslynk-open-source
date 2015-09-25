package com.servinglynk.hmis.warehouse.test.core;

import java.util.Date;
import java.util.Random;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.common.Constants;
import com.servinglynk.hmis.warehouse.common.GeneralUtil;
import com.servinglynk.hmis.warehouse.core.model.Account;
import com.servinglynk.hmis.warehouse.core.model.ApiMethod;
import com.servinglynk.hmis.warehouse.core.model.Client;
import com.servinglynk.hmis.warehouse.core.model.DeveloperCompany;
import com.servinglynk.hmis.warehouse.core.model.DeveloperService;
import com.servinglynk.hmis.warehouse.core.model.Employment;
import com.servinglynk.hmis.warehouse.core.model.Enrollment;
import com.servinglynk.hmis.warehouse.core.model.Exit;
import com.servinglynk.hmis.warehouse.core.model.Organization;
import com.servinglynk.hmis.warehouse.core.model.PermissionSet;
import com.servinglynk.hmis.warehouse.core.model.Profile;
import com.servinglynk.hmis.warehouse.core.model.Project;
import com.servinglynk.hmis.warehouse.core.model.RedirectUri;
import com.servinglynk.hmis.warehouse.core.model.RedirectUris;
import com.servinglynk.hmis.warehouse.core.model.Role;
import com.servinglynk.hmis.warehouse.core.model.ServiceStatus;
import com.servinglynk.hmis.warehouse.core.model.SharingRule;
import com.servinglynk.hmis.warehouse.core.model.TrustedApp;
import com.servinglynk.hmis.warehouse.core.model.TrustedAppStatus;
import com.servinglynk.hmis.warehouse.enums.ProjectResidentialaffiliationEnum;

public class TestData {
	
	
	public static Account getAccount() {
		
		Account account=new Account();
		account.setEmailAddress("test@test.com");
		account.setFirstName("First Name");
		account.setGender("Male");
		account.setLastName("Last Name");
		account.setMiddleName("Middle Name");
		account.setPassword("password");
		account.setUsername("username_"+System.currentTimeMillis()+"@hmis.com");
		
		Profile profile = new Profile();
		profile.setId(UUID.fromString("c8aa2d91-f982-4f59-a400-142be1af9fca"));
		
		account.setProfile(profile);
		return account;
	}

	public static Account getAccount(String userName) {
		
		Account account=new Account();
		String uName = userName+"_"+System.currentTimeMillis()+"@hmis.com";
		account.setEmailAddress(uName);
		account.setFirstName("First Name");
		account.setGender("Male");
		account.setLastName("Last Name");
		account.setMiddleName("Middle Name");
		account.setPassword("password");
		account.setUsername(uName);
		
		return account;
	}

	public static Account getAccountWithoutProfile(){
		Account account=new Account();
		account.setEmailAddress("test@test.com");
		account.setFirstName("First Name");
		account.setGender("Male");
		account.setLastName("Last Name");
		account.setMiddleName("Middle Name");
		account.setPassword("password");
		account.setUsername("username_"+System.currentTimeMillis()+"@hmis.com");
		
		return account;
	}

	
	
	public static DeveloperCompany getDeveloperCompany(){
		
		DeveloperCompany developerCompany=new DeveloperCompany();
		developerCompany.setAppExperience("1");
		developerCompany.setAppPlatforms("AppPlatforms");
		developerCompany.setCompanySize(10);
		developerCompany.setCompanySkillSet("Skills Set");
		developerCompany.setDomain("Domain");
		developerCompany.setExpectedAppFinishDate(new Date());
		developerCompany.setLogoUrl("www.test.com");
		developerCompany.setName("Developer Company Name");
		
		
		return developerCompany;
	}
	
	
	public static DeveloperCompany getDeveloperCompanyWithOwner(Account account){
		
		DeveloperCompany developerCompany=new DeveloperCompany();
		developerCompany.setAppExperience("1");
		developerCompany.setAppPlatforms("AppPlatforms");
		developerCompany.setCompanySize(10);
		developerCompany.setCompanySkillSet("Skills Set");
		developerCompany.setDomain("Domain");
		developerCompany.setExpectedAppFinishDate(new Date());
		developerCompany.setLogoUrl("www.test.com");
		developerCompany.setName("Developer Company Name");
		developerCompany.setOwner(account);		
		return developerCompany;
	}
	
	public static DeveloperService getDeveloperService(){
		DeveloperService service = new DeveloperService();
		service.setDescription("My First Service");
		//service.setDeveloperCompany(developerCompany);
		service.setFriendlyName("Friendly Name_"+System.currentTimeMillis());
		service.setLicenseType("NONE");
		service.setServiceId("12");
		
		return service;
	}
	
	public static DeveloperService getDeveloperServiceForDC(DeveloperCompany developerCompany){
		DeveloperService service = new DeveloperService();
		service.setDescription("My First Service");
		service.setDeveloperCompany(developerCompany);
		service.setFriendlyName("Friendly Name_"+System.currentTimeMillis());
		service.setLicenseType("NONE");
		service.setServiceId("12");
		
		return service;
	}
	
	public static ServiceStatus getServiceStatus(boolean flag){
		ServiceStatus serviceStatus = new ServiceStatus();
		serviceStatus.setComment("Approving Service");
		if(flag){
			serviceStatus.setStatus("Approved");
		}else{
			serviceStatus.setStatus("Rejected");
		}
	
		return serviceStatus;
	}
	
	
	public static TrustedApp getTrustedApp(){
		TrustedApp trustedApp = new TrustedApp();
		
		trustedApp.setTrustedAppFamilyType("CC_CONTAINER");
		trustedApp.setTrustedAppProfileType("SERVER_SIDE_WEB_APP");
		trustedApp.setTrustedAppSecret("secret");
		trustedApp.setDescription("Description");
		trustedApp.setExpirationTime(10);
		trustedApp.setFriendlyName("Friendly Name_"+System.currentTimeMillis());
		trustedApp.setImplicitGrantSupported(true);
		trustedApp.setInternal(true);
		trustedApp.setVersion("1.0.0");

		return trustedApp;
	}
	
	public static TrustedApp getTrustedAppForService(DeveloperService service){
		TrustedApp trustedApp = new TrustedApp();
		
		trustedApp.setTrustedAppFamilyType("CC_CONTAINER");
		trustedApp.setTrustedAppProfileType("SERVER_SIDE_WEB_APP");
		trustedApp.setTrustedAppSecret("secret");
		trustedApp.setDescription("Description");
		trustedApp.setExpirationTime(10);
		trustedApp.setFriendlyName("Friendly Name_"+System.currentTimeMillis());
		trustedApp.setImplicitGrantSupported(true);
		trustedApp.setInternal(true);
		trustedApp.setVersion("1.0.0");
		trustedApp.setService(service);

		return trustedApp;
	}
	
	
	public static TrustedAppStatus getTrustedAppStatus(boolean flag){
		TrustedAppStatus trustedAppStatus = new TrustedAppStatus();
		
		trustedAppStatus.setComment("TrustedApp Comment");
	
		if(flag){
			trustedAppStatus.setStatus(Constants.TRUSTEDAPP_STATUS_SUBMITTED);
		}else{
			trustedAppStatus.setStatus("Rejected");
		}
		
		return trustedAppStatus;
	}
	
	
	
	public static RedirectUri getRedirectUri(){
		RedirectUri redirectUri = new RedirectUri();
		redirectUri.setUri("www."+GeneralUtil.getAlphaNumericGuid()+".com");
		return redirectUri;
	}
	
	
	public static RedirectUris getRedirectUris(int count){
		RedirectUris redirectUris = new RedirectUris();
		for(int i=0;i<=count;i++){
			redirectUris.addRedirectUri(getRedirectUri());
		}
		
		
		return redirectUris;
	}

	
	public static ApiMethod getApiMethod(){
	ApiMethod apiMethod=new ApiMethod();
	apiMethod.setAuthorizationMsg("AuthorizationMsg "+System.currentTimeMillis());
	apiMethod.setFriendlyName("FriendlyName "+System.currentTimeMillis());
	apiMethod.setDescription("Desc "+System.currentTimeMillis());
	apiMethod.setMethodSequence(new Long(1));
	apiMethod.setType("Type "+System.currentTimeMillis());
	
	
	return apiMethod;
	}
		
	public static Role getRole(){
		Role role = new Role();
		role.setRoleName("roleName"+System.currentTimeMillis());
		role.setRoleDescription("Role Description");
		return role;
	}

	public static Role getRole(String roleName){
		Role role = new Role();
		role.setRoleName(roleName+"_"+System.currentTimeMillis());
		role.setRoleDescription("Role Description");
		return role;
	}
	
	public static Profile getProfile() throws Exception {
		Profile profile = new Profile();
		profile.setProfileName("Profile Name "+System.currentTimeMillis());
		profile.setProfileDescription("Profile Desc "+System.currentTimeMillis());
		ApiMethod loginMethod=new ApiMethod();
		loginMethod.setExternalId("USR_CREATE_SESSION");
		ApiMethod logoutMethod=new ApiMethod();
		logoutMethod.setExternalId("USR_END_SESSION");
		profile.addApiMethod(loginMethod);
		profile.addApiMethod(logoutMethod);
		return profile;
	}
	
	public static Profile getProfile(String profileName) throws Exception {
		Profile profile = new Profile();
		profile.setProfileName(profileName+"_"+System.currentTimeMillis());
		profile.setProfileDescription("Profile Desc "+System.currentTimeMillis());
		ApiMethod loginMethod=new ApiMethod();
		loginMethod.setExternalId("USR_CREATE_SESSION");
		ApiMethod logoutMethod=new ApiMethod();
		logoutMethod.setExternalId("USR_END_SESSION");
		profile.addApiMethod(loginMethod);
		profile.addApiMethod(logoutMethod);
		return profile;
	}
	
	
	public static PermissionSet getPermissionSet() throws Exception {
		PermissionSet permissionSet=new PermissionSet();
		permissionSet.setPermissionSetName("PermissionSet Name"+System.currentTimeMillis());
		permissionSet.setPermissionSetDescription("PermissionSet Desc "+System.currentTimeMillis());
		
		
		return permissionSet;
	}
	
	public static Exit getExit(){
		Exit exit = new Exit();
		exit.setExitDate(new Date());
		exit.setOtherDestination("TWENTY_FOUR");
		
		return exit;
	}
	
	
	
	public static Client getClient(){
		Client client = new Client();
//		client.setAmIndAKNative("");
//		client.setAsian("");
//		client.setBlackAfAmerican("");
		client.setDob(new Date());
		client.setDobDataQuality("ONE");
		client.setEthnicity("ONE");
		client.setFirstName("");
		client.setGender("ONE");
		client.setLastName("LAST NAME");
		client.setMiddleName("Middle Name");
		client.setNameDataQuality("ONE");
		client.setNameSuffix("NS");
//		client.setNativeHIOtherPacific("");
		client.setOtherGender("Test");
		client.setRace("ONE");
		client.setSsn("ssn");
		client.setSsnDataQuality("ONE");
//		client.setVeteranStatus("");
//		client.setWhite("");
		
		
		return client;
	}
	
	
	public static Enrollment getEnrollment(UUID clientId){
		
		Enrollment enrollment = new Enrollment();
		enrollment.setClientId(clientId);
		enrollment.setContinuouslyhomelessoneyear("ONE");
		enrollment.setDisablingcondition("ZERO");
		enrollment.setEntrydate(new Date());
		enrollment.setHouseholdid(UUID.randomUUID());
		enrollment.setHousingstatus("ONE");
		enrollment.setMonthshomelesspastthreeyears("SEVEN");
		enrollment.setMonthshomelessthistime("ONE");
		enrollment.setOtherresidenceprior("1");
		enrollment.setPersonalid(UUID.randomUUID());
		enrollment.setProjectentryid(UUID.randomUUID());
		enrollment.setProjectid(UUID.randomUUID());
		enrollment.setRelationshiptohoh("TWO");
		enrollment.setResidenceprior("TWO");
		enrollment.setResidencepriorlengthofstay("TWO");
		enrollment.setStatusdocumented("ONE");
		enrollment.setTimeshomelesspastthreeyears("ONE");
		enrollment.setYearshomeless(2);
		
		return enrollment;
	}
	
	
	public static Organization getOrganization(){
		Organization organization = new Organization();

		organization.setOrganizationCommonName("Common Name");
		organization.setOrganizationName("Organization Name");
		
		
		return organization;
	}
	
	
	public static Project getProject(){
		Project project = new Project();
		
		project.setContinuumProject(getRandamFromEnum("ProjectContinuumprojectEnum"));
		project.setProjectCommonName("ProjectCommonName_"+System.currentTimeMillis());
		project.setProjectName("ProjectName_"+System.currentTimeMillis());
		project.setProjectType(getRandamFromEnum("ProjectProjecttypeEnum"));
		project.setResidentialAffiliation(getRandamFromEnum("ProjectResidentialaffiliationEnum"));
		project.setTargetPopulation(getRandamFromEnum("ProjectTargetpopulationEnum"));
		project.setTrackingMethod(getRandamFromEnum("ProjectTrackingmethodEnum"));
		
		
		return project;
	}
	
	
	
	public static Employment getEmployment(){
		Employment employment = new Employment();
		   employment.setEmployed(getRandamFromEnum("EmploymentEmployedEnum"));
	
	       employment.setEmploymentType(getRandamFromEnum("EmploymentEmploymentTypeEnum"));
	       employment.setInformationDate(new Date());
	       employment.setNotEmployedReason(getRandamFromEnum("EmploymentNotEmployedReasonEnum"));
		return employment;
	}
	
	public static String getRandamFromEnum(String enumName){
		Object[] enumArray = null;
		try{
		Class<?> cls = Class.forName("com.servinglynk.hmis.warehouse.enums." + enumName);
        enumArray = cls.getEnumConstants();
        
    /*    for(int i=0;i<enumArray.length;i++){
        	System.out.println(enumArray[i]);
        }*/
        
		}catch(Exception e){
			e.printStackTrace();
		}
		return  enumArray[new Random().nextInt(enumArray.length)].toString();
	}
	
	

	public static void main(String args[]){
		TestData.getRandamFromEnum("EmploymentEmployedEnum");
	}
	
	public static SharingRule getSharingRule() throws Exception {
		return null;
	}
	
	
	
}
