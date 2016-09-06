package com.servinglynk.hmis.warehouse.test.core;

import java.util.Date;
import java.util.Random;
import java.util.UUID;

import org.joda.time.LocalDateTime;

import com.servinglynk.hmis.warehouse.common.Constants;
import com.servinglynk.hmis.warehouse.common.GeneralUtil;
import com.servinglynk.hmis.warehouse.core.model.Account;
import com.servinglynk.hmis.warehouse.core.model.ApiMethod;
import com.servinglynk.hmis.warehouse.core.model.Client;
import com.servinglynk.hmis.warehouse.core.model.Dateofengagement;
import com.servinglynk.hmis.warehouse.core.model.DeveloperCompany;
import com.servinglynk.hmis.warehouse.core.model.DeveloperService;
import com.servinglynk.hmis.warehouse.core.model.Disabilities;
import com.servinglynk.hmis.warehouse.core.model.Domesticviolence;
import com.servinglynk.hmis.warehouse.core.model.Employment;
import com.servinglynk.hmis.warehouse.core.model.Enrollment;
import com.servinglynk.hmis.warehouse.core.model.EnrollmentCoc;
import com.servinglynk.hmis.warehouse.core.model.Healthinsurance;
import com.servinglynk.hmis.warehouse.core.model.Healthstatus;
import com.servinglynk.hmis.warehouse.core.model.Inventory;
import com.servinglynk.hmis.warehouse.core.model.Medicalassistance;
import com.servinglynk.hmis.warehouse.core.model.Noncashbenefits;
import com.servinglynk.hmis.warehouse.core.model.Organization;
import com.servinglynk.hmis.warehouse.core.model.Pathstatus;
import com.servinglynk.hmis.warehouse.core.model.PermissionSet;
import com.servinglynk.hmis.warehouse.core.model.Profile;
import com.servinglynk.hmis.warehouse.core.model.Project;
import com.servinglynk.hmis.warehouse.core.model.Projectcoc;
import com.servinglynk.hmis.warehouse.core.model.RedirectUri;
import com.servinglynk.hmis.warehouse.core.model.RedirectUris;
import com.servinglynk.hmis.warehouse.core.model.Residentialmoveindate;
import com.servinglynk.hmis.warehouse.core.model.Rhybcpstatus;
import com.servinglynk.hmis.warehouse.core.model.Role;
import com.servinglynk.hmis.warehouse.core.model.ServiceStatus;
import com.servinglynk.hmis.warehouse.core.model.TrustedApp;
import com.servinglynk.hmis.warehouse.core.model.TrustedAppStatus;

public class TestData {
	
	private static final String CHAR_LIST =
	        "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

	public static String generateRandomString(int stringsize){
	
		Random random = new Random();
		
		StringBuffer randStr = new StringBuffer();
		for(int i=0; i<stringsize; i++){
			int number = random.nextInt(CHAR_LIST.length());
			char ch = CHAR_LIST.charAt(number);
			randStr.append(ch);
		}
		return randStr.toString();
	}
	
	public static Account getAccount() {
		
		Account account=new Account();
		account.setEmailAddress("test@test.com");
		account.setFirstName("First Name");
//		account.setGender("Male");
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
	//	account.setGender("Male");
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
	//	account.setGender("Male");
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
	
	
	
	
	
	
	public static Organization getOrganization(){
		Organization organization = new Organization();

		organization.setOrganizationCommonName("Common Name");
		organization.setOrganizationName("Organization Name");
		
		
		return organization;
	}
	
	
	 public static Inventory getInventory(){
	       Inventory inventory = new Inventory();

	       Random random = new Random();
	       inventory.setAvailabilty(getRandamFromEnum("InventoryAvailabiltyEnum"));
	       inventory.setBedtype(getRandamFromEnum("InventoryBedtypeEnum"));
	       inventory.setHmisparticipatingbeds(random.nextInt());
	       inventory.setHouseholdtype(getRandamFromEnum("InventoryHouseholdtypeEnum"));
	       inventory.setUnitinventory(random.nextInt());
	       return inventory;
	}
	 
	 
	 public static Enrollment getEnrollment(UUID clientId){
			
			Enrollment enrollment = new Enrollment();
			enrollment.setClientId(clientId);
			enrollment.setContinuouslyhomelessoneyear(1);
			enrollment.setDisablingcondition(0);
			enrollment.setEntrydate(new Date());
			enrollment.setHouseholdid(UUID.randomUUID());
			enrollment.setHousingstatus(0);
			enrollment.setMonthshomelesspastthreeyears(7);
			enrollment.setMonthshomelessthistime(1);
			enrollment.setOtherresidenceprior("1");
			enrollment.setPersonalid(UUID.randomUUID());
			enrollment.setProjectentryid(UUID.randomUUID());
			enrollment.setProjectid(UUID.randomUUID());
			enrollment.setRelationshiptohoh(2);
			enrollment.setResidenceprior(2);
			enrollment.setResidencepriorlengthofstay(2);
			enrollment.setStatusdocumented(1);
			enrollment.setTimeshomelesspastthreeyears(1);
			enrollment.setYearshomeless(2);
			
			return enrollment;
		}
	 

		public static Client getClient(){
			Client client = new Client();
			client.setAmIndAKNative("");
			client.setAsian("");
			client.setBlackAfAmerican("");
			client.setDob(new Date());
			client.setDobDataQuality(1);
			client.setEthnicity(1);
			client.setFirstName("First Name");
			client.setGender(1);
			client.setLastName("LAST NAME");
			client.setMiddleName("Middle Name");
			client.setNameDataQuality(1);
			client.setNameSuffix("NS");
			client.setNativeHIOtherPacific("");
			client.setOtherGender("Test");
			client.setRace(1);
			client.setSsn("ssn");
			client.setSsnDataQuality(1);
			client.setVeteranStatus("");
			client.setWhite("");
			
			
			return client;
		}
	
		 public static Employment getEmployment(){
		       Employment employment = new Employment();

		       employment.setEmployed(getRandamFromEnum("EmploymentEmployedEnum"));
		       employment.setEmploymentType(getRandamFromEnum("EmploymentEmploymentTypeEnum"));
		       employment.setNotEmployedReason(getRandamFromEnum("EmploymentNotEmployedReasonEnum"));
		       return employment;
		}

	public static Integer getRandamFromEnum(String enumName){
/*		Object[] enumArray = null;
		try{
		Class<?> cls = Class.forName("com.servinglynk.hmis.warehouse.enums." + enumName);
        enumArray = cls.getEnumConstants();
        
        for(int i=0;i<enumArray.length;i++){
        	System.out.println(enumArray[i]);
        }
        
		}catch(Exception e){
			e.printStackTrace();
		}
		return  enumArray[new Random().nextInt(enumArray.length)].toString();*/
		
		return 0;
	}
	
	
	 
	public static void main(String args[]){
		TestData.getRandamFromEnum("EmploymentEmployedEnum");
	}
	
	 public static Dateofengagement getDateofengagement(){
	       Dateofengagement dateofengagement = new Dateofengagement();
	       dateofengagement.setDateofengagement(java.time.LocalDateTime.now());
	       Random random = new Random();
	       return dateofengagement;
	}

	 public static Disabilities getdisabilities(){
	       Disabilities disabilities = new Disabilities();

	       Random random = new Random();
	       disabilities.setDisabilitytype(getRandamFromEnum("DisabilitiesDisabilitytypeEnum"));
	       disabilities.setDisabilityresponse(random.nextInt());
	       disabilities.setIndefiniteandimpairs(getRandamFromEnum("DisabilitiesIndefiniteandimpairsEnum"));
	       disabilities.setDocumentationonfile(getRandamFromEnum("DisabilitiesDocumentationonfileEnum"));
	       disabilities.setReceivingservices(getRandamFromEnum("DisabilitiesReceivingservicesEnum"));
	       disabilities.setPathhowconfirmed(getRandamFromEnum("DisabilitiesPathhowconfirmedEnum"));
	       disabilities.setPathsmiinformation(getRandamFromEnum("DisabilitiesPathsmiinformationEnum"));
	       disabilities.setTcellcountavailable(random.nextInt());
	       disabilities.setTcellcount(random.nextInt());
	       disabilities.setViralLoadAvailable(random.nextInt());
	       disabilities.setViralLoad(random.nextInt());
	       return disabilities;
	}

	 public static Domesticviolence getdomesticviolence(){
	       Domesticviolence domesticviolence = new Domesticviolence();

	       Random random = new Random();
	       domesticviolence.setDomesticviolencevictim(getRandamFromEnum("DomesticviolenceDomesticviolencevictimEnum"));
	       domesticviolence.setWhenoccurred(getRandamFromEnum("DomesticviolenceWhenoccurredEnum"));
	       domesticviolence.setCurrentlyFleeing(random.nextInt());
	       return domesticviolence;
	}

	 public static EnrollmentCoc getenrollmentCoc(){
	       EnrollmentCoc enrollmentCoc = new EnrollmentCoc();
	       enrollmentCoc.setDateCreated(java.time.LocalDateTime.now());

	       Random random = new Random();
	       return enrollmentCoc;
	}

	 public static Healthinsurance gethealthinsurance(){
	       Healthinsurance healthinsurance = new Healthinsurance();

	       Random random = new Random();
	       healthinsurance.setNomedicaidreason(getRandamFromEnum("HealthinsuranceNomedicaidreasonEnum"));
	       healthinsurance.setMedicare(getRandamFromEnum("HealthinsuranceMedicareEnum"));
	       healthinsurance.setNomedicarereason(getRandamFromEnum("HealthinsuranceNomedicarereasonEnum"));
	       healthinsurance.setSchip(getRandamFromEnum("HealthinsuranceSchipEnum"));
	       healthinsurance.setNoschipreason(getRandamFromEnum("HealthinsuranceNoschipreasonEnum"));
	       healthinsurance.setVamedicalservices(getRandamFromEnum("HealthinsuranceVamedicalservicesEnum"));
	       healthinsurance.setNovamedreason(getRandamFromEnum("HealthinsuranceNovamedreasonEnum"));
	       healthinsurance.setEmployerprovided(random.nextInt());
	       healthinsurance.setNoemployerprovidedreason(getRandamFromEnum("HealthinsuranceNoemployerprovidedreasonEnum"));
	       healthinsurance.setCobra(random.nextInt());
	       healthinsurance.setNocobrareason(getRandamFromEnum("HealthinsuranceNocobrareasonEnum"));
	       healthinsurance.setPrivatepay(getRandamFromEnum("HealthinsurancePrivatepayEnum"));
	       healthinsurance.setNoprivatepayreason(getRandamFromEnum("HealthinsuranceNoprivatepayreasonEnum"));
	       healthinsurance.setStatehealthins(getRandamFromEnum("HealthinsuranceStatehealthinsEnum"));
	       healthinsurance.setNostatehealthinsreason(getRandamFromEnum("HealthinsuranceNostatehealthinsreasonEnum"));
	       healthinsurance.setOtherSource(random.nextInt());
	       return healthinsurance;
	}

	 public static Medicalassistance getmedicalassistance(){
	       Medicalassistance medicalassistance = new Medicalassistance();

	       Random random = new Random();
	       medicalassistance.setHivaidsassistance(getRandamFromEnum("MedicalassistanceHivaidsassistanceEnum"));
	       medicalassistance.setNohivaidsassistancereason(getRandamFromEnum("MedicalassistanceNohivaidsassistancereasonEnum"));
	       medicalassistance.setAdap(getRandamFromEnum("MedicalassistanceAdapEnum"));
	       medicalassistance.setNoadapreason(getRandamFromEnum("MedicalassistanceNoadapreasonEnum"));
	       return medicalassistance;
	}

	 public static Noncashbenefits getnoncashbenefits(){
	       Noncashbenefits noncashbenefits = new Noncashbenefits();

	       Random random = new Random();
	       noncashbenefits.setBenefitsfromanysource(getRandamFromEnum("NoncashbenefitsBenefitsfromanysourceEnum"));
	       noncashbenefits.setOthersource(getRandamFromEnum("NoncashbenefitsOthersourceEnum"));
	       noncashbenefits.setOthertanf(getRandamFromEnum("NoncashbenefitsOthertanfEnum"));
	       noncashbenefits.setRentalassistanceongoing(getRandamFromEnum("NoncashbenefitsRentalassistanceongoingEnum"));
	       noncashbenefits.setRentalassistancetemp(getRandamFromEnum("NoncashbenefitsRentalassistancetempEnum"));
	       noncashbenefits.setSnap(getRandamFromEnum("NoncashbenefitsSnapEnum"));
	       noncashbenefits.setTanfchildcare(getRandamFromEnum("NoncashbenefitsTanfchildcareEnum"));
	       noncashbenefits.setTanftransportation(getRandamFromEnum("NoncashbenefitsTanftransportationEnum"));
	       noncashbenefits.setWic(getRandamFromEnum("NoncashbenefitsWicEnum"));
	       return noncashbenefits;
	}

	 public static Pathstatus getpathstatus(){
	       Pathstatus pathstatus = new Pathstatus();

	       Random random = new Random();
	       pathstatus.setClientEnrolledInPath((long) random.nextInt());
	       pathstatus.setReasonNotEnrolled(getRandamFromEnum("PathstatusReasonnotenrolledEnum"));
	       return pathstatus;
	}
	 
	 public static Residentialmoveindate getresidentialmoveindate(){
	       Residentialmoveindate residentialmoveindate = new Residentialmoveindate();

	       Random random = new Random();
	       residentialmoveindate.setInpermanenthousing(getRandamFromEnum("ResidentialmoveindateInpermanenthousingEnum"));
	       return residentialmoveindate;
	}

	 public static Healthstatus gethealthstatus(){
	       Healthstatus healthstatus = new Healthstatus();

	       Random random = new Random();
	       healthstatus.setHealthCategory(getRandamFromEnum("HealthStatusHealthCategoryEnum"));
	       healthstatus.setHealthStatus(getRandamFromEnum("HealthStatusHealthStatusEnum"));
	       return healthstatus;
	}

	 public static Rhybcpstatus getrhybcpstatus(){
	       Rhybcpstatus rhybcpstatus = new Rhybcpstatus();

	       Random random = new Random();
	       rhybcpstatus.setFysbYouth(getRandamFromEnum("RhybcpStatusFysbYouthEnum"));
	       rhybcpstatus.setReasonNoServices(getRandamFromEnum("RhybcpStatusReasonNoServicesEnum"));
	       return rhybcpstatus;
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
		
	 public static Projectcoc getProjectcoc(){
		 Projectcoc projectcoc = new Projectcoc();
		 projectcoc.setCoccode(generateRandomString(30));
		 return projectcoc;
	 }
}
