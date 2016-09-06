package com.servinglynk.hmis.warehouse.test.core;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.common.Constants;
import com.servinglynk.hmis.warehouse.common.GeneralUtil;
import com.servinglynk.hmis.warehouse.core.model.Account;
import com.servinglynk.hmis.warehouse.core.model.Affiliation;
import com.servinglynk.hmis.warehouse.core.model.ApiMethod;
import com.servinglynk.hmis.warehouse.core.model.Client;
import com.servinglynk.hmis.warehouse.core.model.CommercialSexualExploitation;
import com.servinglynk.hmis.warehouse.core.model.Dateofengagement;
import com.servinglynk.hmis.warehouse.core.model.DeveloperCompany;
import com.servinglynk.hmis.warehouse.core.model.DeveloperService;
import com.servinglynk.hmis.warehouse.core.model.Disabilities;
import com.servinglynk.hmis.warehouse.core.model.DomesticViolence;
import com.servinglynk.hmis.warehouse.core.model.Employment;
import com.servinglynk.hmis.warehouse.core.model.Enrollment;
import com.servinglynk.hmis.warehouse.core.model.Exit;
import com.servinglynk.hmis.warehouse.core.model.FormerWardChildWelfare;
import com.servinglynk.hmis.warehouse.core.model.Funder;
import com.servinglynk.hmis.warehouse.core.model.HealthInsurance;
import com.servinglynk.hmis.warehouse.core.model.HealthStatus;
import com.servinglynk.hmis.warehouse.core.model.IncomeAndSource;
import com.servinglynk.hmis.warehouse.core.model.LastPermanentAddress;
import com.servinglynk.hmis.warehouse.core.model.Medicalassistance;
import com.servinglynk.hmis.warehouse.core.model.NonCashBenefit;
import com.servinglynk.hmis.warehouse.core.model.Organization;
import com.servinglynk.hmis.warehouse.core.model.Pathstatus;
import com.servinglynk.hmis.warehouse.core.model.Percentami;
import com.servinglynk.hmis.warehouse.core.model.PermissionSet;
import com.servinglynk.hmis.warehouse.core.model.Profile;
import com.servinglynk.hmis.warehouse.core.model.Project;
import com.servinglynk.hmis.warehouse.core.model.Projectcoc;
import com.servinglynk.hmis.warehouse.core.model.RedirectUri;
import com.servinglynk.hmis.warehouse.core.model.RedirectUris;
import com.servinglynk.hmis.warehouse.core.model.Referralsource;
import com.servinglynk.hmis.warehouse.core.model.Residentialmoveindate;
import com.servinglynk.hmis.warehouse.core.model.Rhybcpstatus;
import com.servinglynk.hmis.warehouse.core.model.Role;
import com.servinglynk.hmis.warehouse.core.model.Schoolstatus;
import com.servinglynk.hmis.warehouse.core.model.ServiceStatus;
import com.servinglynk.hmis.warehouse.core.model.Services;
import com.servinglynk.hmis.warehouse.core.model.Sexualorientation;
import com.servinglynk.hmis.warehouse.core.model.SharingRule;
import com.servinglynk.hmis.warehouse.core.model.TrustedApp;
import com.servinglynk.hmis.warehouse.core.model.TrustedAppStatus;
import com.servinglynk.hmis.warehouse.core.model.VeteranInfo;
import com.servinglynk.hmis.warehouse.core.model.WorstHousingSituation;
import com.servinglynk.hmis.warehouse.core.model.YouthCriticalIssue;

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
		//account.setGender("Male");
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
		//account.setGender("Male");
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
		//account.setGender("Male");
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
		client.setDobDataQuality(1);
		client.setEthnicity(1);
		client.setFirstName("First Name");
		client.setGender(1);
		client.setLastName("LAST NAME");
		client.setMiddleName("Middle Name");
		client.setNameDataQuality(1);
		client.setNameSuffix("NS");
//		client.setNativeHIOtherPacific("");
		client.setOtherGender("Test");
		client.setRace(1);
		client.setSsn("ssn");
		client.setSsnDataQuality(1);
//		client.setVeteranStatus("");
//		client.setWhite("");
		
		
		return client;
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
	       employment.setInformationDate(LocalDateTime.now());
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
	
	
	
	public static VeteranInfo getVeteranInfo(){
		Random random = new Random();
		
		VeteranInfo veteranInfo = new VeteranInfo();
		
		   veteranInfo.setAfghanistanOef(getRandamFromEnum("VeteranInfoAfghanistanOefEnum"));
	       veteranInfo.setDesertStorm(getRandamFromEnum("VeteranInfoDesertStormEnum"));
	       veteranInfo.setIraqOif(getRandamFromEnum("VeteranInfoIraqOifEnum"));
	       veteranInfo.setIraqOnd(getRandamFromEnum("VeteranInfoIraqOndEnum"));
	       veteranInfo.setKoreanWar(getRandamFromEnum("VeteranInfoKoreanWarEnum"));
	       veteranInfo.setMilitaryBranch(getRandamFromEnum("VeteranInfoMilitaryBranchEnum"));
	       veteranInfo.setOtherTheater(getRandamFromEnum("VeteranInfoOtherTheaterEnum"));
	       veteranInfo.setVietnamWar(getRandamFromEnum("VeteranInfoVietnamWarEnum"));
	       veteranInfo.setWorldWar2(getRandamFromEnum("VeteranInfoWorldWar2Enum"));
	       veteranInfo.setYearEntrdService(random.nextInt());
	       veteranInfo.setYearSeperated(random.nextInt());
	       veteranInfo.setDischargeStatus(getRandamFromEnum("VeteranInfoDischargeStatusEnum"));

		
		return veteranInfo;
	}
	
	
	public static Disabilities getDisabilities(){
		Random random = new Random();
		Disabilities disabilities = new Disabilities();
		disabilities.setDisabilityresponse(random.nextInt());
		//disabilities.setDisabilitytype(getRandamFromEnum("DisabilitiesDisabilitytypeEnum"));
		disabilities.setDocumentationonfile(getRandamFromEnum("DisabilitiesDocumentationonfileEnum"));
		disabilities.setIndefiniteandimpairs(getRandamFromEnum("DisabilitiesIndefiniteandimpairsEnum"));
		disabilities.setPathhowconfirmed(getRandamFromEnum("DisabilitiesPathhowconfirmedEnum"));
		disabilities.setPathsmiinformation(getRandamFromEnum("DisabilitiesPathsmiinformationEnum"));
		disabilities.setReceivingservices(getRandamFromEnum("DisabilitiesReceivingservicesEnum"));
		
		return disabilities;
	}

	
	public static IncomeAndSource getIncomeAndSource(){
		IncomeAndSource model = new IncomeAndSource();
		
		Random random = new Random();
		
		   model.setAlimony(getRandamFromEnum("IncomeandsourcesAlimonyEnum"));
	       model.setAlimonyamount(random.nextFloat());
	       model.setChildsupport(getRandamFromEnum("IncomeandsourcesChildsupportEnum"));
	       model.setChildsupportamount(random.nextFloat());
	       model.setEarned(getRandamFromEnum("IncomeandsourcesEarnedEnum"));
	       model.setEarnedamount(random.nextFloat());
	       model.setGa(getRandamFromEnum("IncomeandsourcesGaEnum"));
	       model.setGaamount(random.nextFloat());
	       model.setIncomefromanysource(getRandamFromEnum("IncomeandsourcesIncomefromanysourceEnum"));
	       model.setOthersource(getRandamFromEnum("IncomeandsourcesOthersourceEnum"));
	       model.setOthersourceamount(random.nextFloat());
	       model.setOthersourceidentify("TestData");
	       model.setPension(getRandamFromEnum("IncomeandsourcesPensionEnum"));
	       model.setPensionamount(random.nextFloat());
	       model.setPrivatedisability(getRandamFromEnum("IncomeandsourcesPrivatedisabilityEnum"));
	       model.setPrivatedisabilityamount(random.nextFloat());
	       model.setSocsecretirement(getRandamFromEnum("IncomeandsourcesSocsecretirementEnum"));
	       model.setSocsecretirementamount(random.nextFloat());
	       model.setSsdi(getRandamFromEnum("IncomeandsourcesSsdiEnum"));
	       model.setSsdiamount(random.nextFloat());
	       model.setSsi(getRandamFromEnum("IncomeandsourcesSsiEnum"));
	       model.setSsiamount(random.nextFloat());
	       model.setTanf(getRandamFromEnum("IncomeandsourcesTanfEnum"));
	       model.setTanfamount(random.nextFloat());
	       model.setTotalmonthlyincome(random.nextFloat());
	       model.setUnemployment(getRandamFromEnum("IncomeandsourcesUnemploymentEnum"));
	       model.setUnemploymentamount(random.nextFloat());
	       model.setVadisabilitynonservice(getRandamFromEnum("IncomeandsourcesVadisabilitynonserviceEnum"));
	       model.setVadisabilitynonserviceamount(random.nextFloat());
	       model.setVadisabilityservice(getRandamFromEnum("IncomeandsourcesVadisabilityserviceEnum"));
	       model.setVadisabilityserviceamount(random.nextFloat());
	       model.setWorkerscomp(getRandamFromEnum("IncomeandsourcesWorkerscompEnum"));
	       model.setWorkerscompamount(random.nextFloat());
		
		
		
		return model;
	}
	
	public static HealthInsurance getHealthInsurance(){
	       HealthInsurance healthInsurance = new HealthInsurance();

	       Random random = new Random();
	       healthInsurance.setCobra(random.nextInt());
	       healthInsurance.setEmployerprovided(random.nextInt());
	       healthInsurance.setInsurancefromanysource(getRandamFromEnum("HealthinsuranceInsurancefromanysourceEnum"));
	       healthInsurance.setMedicaid(getRandamFromEnum("HealthinsuranceMedicaidEnum"));
	       healthInsurance.setMedicare(getRandamFromEnum("HealthinsuranceMedicareEnum"));
	       healthInsurance.setNocobrareason(getRandamFromEnum("HealthinsuranceNocobrareasonEnum"));
	       healthInsurance.setNoemployerprovidedreason(getRandamFromEnum("HealthinsuranceNoemployerprovidedreasonEnum"));
	       healthInsurance.setNomedicaidreason(getRandamFromEnum("HealthinsuranceNomedicaidreasonEnum"));
	       healthInsurance.setNomedicarereason(getRandamFromEnum("HealthinsuranceNomedicarereasonEnum"));
	       healthInsurance.setNoprivatepayreason(getRandamFromEnum("HealthinsuranceNoprivatepayreasonEnum"));
	       healthInsurance.setNoschipreason(getRandamFromEnum("HealthinsuranceNoschipreasonEnum"));
	       healthInsurance.setNostatehealthinsreason(getRandamFromEnum("HealthinsuranceNostatehealthinsreasonEnum"));
	       healthInsurance.setNovamedreason(getRandamFromEnum("HealthinsuranceNovamedreasonEnum"));
	       healthInsurance.setPrivatepay(getRandamFromEnum("HealthinsurancePrivatepayEnum"));
	       healthInsurance.setSchip(getRandamFromEnum("HealthinsuranceSchipEnum"));
	       healthInsurance.setStatehealthins(getRandamFromEnum("HealthinsuranceStatehealthinsEnum"));
	       healthInsurance.setVamedicalservices(getRandamFromEnum("HealthinsuranceVamedicalservicesEnum"));
	       return healthInsurance;
	}
	
	
	 public static Services getServices(){
	       Services services = new Services();

	       Random random = new Random();
	       services.setDateprovided(new Date());
	       services.setFaamount(random.nextInt());
	       services.setRecordtype(getRandamFromEnum("ServicesRecordtypeEnum"));
	       services.setReferraloutcome(getRandamFromEnum("ServicesReferraloutcomeEnum"));
	       services.setSubtypeprovided(random.nextInt());
	       services.setTypeprovided(random.nextInt());
	       return services;
	}
	
	 
	 public static HealthStatus getHealthStatus(){
	       HealthStatus healthStatus = new HealthStatus();

	       healthStatus.setHealthCategory(getRandamFromEnum("HealthStatusHealthCategoryEnum"));
	       healthStatus.setHealthStatus(getRandamFromEnum("HealthStatusHealthStatusEnum"));
	       healthStatus.setDueDate(new Date());
	       healthStatus.setInformationDate(LocalDateTime.now());
	       return healthStatus;
	}
	 
	 public static CommercialSexualExploitation getCommercialSexualExploitation(){
	       CommercialSexualExploitation commercialSexualExploitation = new CommercialSexualExploitation();

	       commercialSexualExploitation.setAskedorforcedtoexchangeforsex(getRandamFromEnum("CommercialsexualexploitationAskedorforcedtoexchangeforsexEnum"));
	       commercialSexualExploitation.setCountofexchangeforsex(getRandamFromEnum("CommercialsexualexploitationCountofexchangeforsexEnum"));
	       commercialSexualExploitation.setExchangeforsexpastthreemonths(getRandamFromEnum("CommercialsexualexploitationExchangeforsexpastthreemonthsEnum"));
	       return commercialSexualExploitation;
	}
	 
	 public static Dateofengagement getDateofengagement(){
	       Dateofengagement dateofengagement = new Dateofengagement();
	       		dateofengagement.setDateofengagement(new Date());
	       return dateofengagement;
	} 
	 
	 public static DomesticViolence getDomesticViolence(){
	       DomesticViolence domesticViolence = new DomesticViolence();

	       domesticViolence.setDomesticviolencevictim(getRandamFromEnum("DomesticviolenceDomesticviolencevictimEnum"));
	       domesticViolence.setWhenoccurred(getRandamFromEnum("DomesticviolenceWhenoccurredEnum"));
	       return domesticViolence;
	}

	 public static FormerWardChildWelfare getFormerWardChildWelfare(){
	       FormerWardChildWelfare formerWardChildWelfare = new FormerWardChildWelfare();

	       Random random = new Random();
	       formerWardChildWelfare.setChildwelfaremonths(random.nextInt());
	       formerWardChildWelfare.setChildwelfareyears(getRandamFromEnum("FormerwardchildwelfareChildwelfareyearsEnum"));
	       formerWardChildWelfare.setFormerwardchildwelfare(getRandamFromEnum("FormerwardchildwelfareFormerwardchildwelfareEnum"));
	       return formerWardChildWelfare;
	} 
	 
	 public static LastPermanentAddress getLastPermanentAddress(){
	       LastPermanentAddress lastPermanentAddress = new LastPermanentAddress();

	       Random random = new Random();
	       lastPermanentAddress.setAddressdataquality(random.nextInt());
	       lastPermanentAddress.setLastpermanentstate(getRandamFromEnum("StateEnum"));
	       lastPermanentAddress.setLastpermanentcity(generateRandomString(50));
	       lastPermanentAddress.setLastpermanentstreet(generateRandomString(100));
	       lastPermanentAddress.setLastpermanentzip(generateRandomString(32));
	       
	       return lastPermanentAddress;
	} 
	 
	 
	 public static YouthCriticalIssue getYouthCriticalIssues(){
	       YouthCriticalIssue youthCriticalIssues = new YouthCriticalIssue();

	       youthCriticalIssues.setAbuseandneglectfam(getRandamFromEnum("YouthcriticalissuesAbuseandneglectfamEnum"));
	       youthCriticalIssues.setAbuseandneglectyouth(getRandamFromEnum("YouthcriticalissuesAbuseandneglectyouthEnum"));
	       youthCriticalIssues.setActivemilitaryparent(getRandamFromEnum("YouthcriticalissuesActivemilitaryparentEnum"));
	       youthCriticalIssues.setAlcoholdrugabusefam(getRandamFromEnum("YouthcriticalissuesAlcoholdrugabusefamEnum"));
	       youthCriticalIssues.setAlcoholdrugabuseyouth(getRandamFromEnum("YouthcriticalissuesAlcoholdrugabuseyouthEnum"));
	       youthCriticalIssues.setHealthissuesfam(getRandamFromEnum("YouthcriticalissuesHealthissuesfamEnum"));
	       youthCriticalIssues.setHealthissuesyouth(getRandamFromEnum("YouthcriticalissuesHealthissuesyouthEnum"));
	       youthCriticalIssues.setHouseholddynamics(getRandamFromEnum("YouthcriticalissuesHouseholddynamicsEnum"));
	       youthCriticalIssues.setHousingissuesfam(getRandamFromEnum("YouthcriticalissuesHousingissuesfamEnum"));
	       youthCriticalIssues.setHousingissuesyouth(getRandamFromEnum("YouthcriticalissuesHousingissuesyouthEnum"));
	       youthCriticalIssues.setIncarceratedparent(getRandamFromEnum("YouthcriticalissuesIncarceratedparentEnum"));
	       youthCriticalIssues.setIncarceratedparentstatus(getRandamFromEnum("YouthcriticalissuesIncarceratedparentstatusEnum"));
	       youthCriticalIssues.setInsufficientincome(getRandamFromEnum("YouthcriticalissuesInsufficientincomeEnum"));
	       youthCriticalIssues.setMentaldisabilityfam(getRandamFromEnum("YouthcriticalissuesMentaldisabilityfamEnum"));
	       youthCriticalIssues.setMentaldisabilityyouth(getRandamFromEnum("YouthcriticalissuesMentaldisabilityyouthEnum"));
	       youthCriticalIssues.setMentalhealthissuesfam(getRandamFromEnum("YouthcriticalissuesMentalhealthissuesfamEnum"));
	       youthCriticalIssues.setMentalhealthissuesyouth(getRandamFromEnum("YouthcriticalissuesMentalhealthissuesyouthEnum"));
	       youthCriticalIssues.setPhysicaldisabilityfam(getRandamFromEnum("YouthcriticalissuesPhysicaldisabilityfamEnum"));
	       youthCriticalIssues.setPhysicaldisabilityyouth(getRandamFromEnum("YouthcriticalissuesPhysicaldisabilityyouthEnum"));
	       youthCriticalIssues.setSchooleducationalissuesfam(getRandamFromEnum("YouthcriticalissuesSchooleducationalissuesfamEnum"));
	       youthCriticalIssues.setSchooleducationalissuesyouth(getRandamFromEnum("YouthcriticalissuesSchooleducationalissuesyouthEnum"));
	       youthCriticalIssues.setSexualorientationgenderidfam(getRandamFromEnum("YouthcriticalissuesSexualorientationgenderidfamEnum"));
	       youthCriticalIssues.setSexualorientationgenderidyouth(getRandamFromEnum("YouthcriticalissuesSexualorientationgenderidyouthEnum"));
	       youthCriticalIssues.setUnemploymentfam(getRandamFromEnum("YouthcriticalissuesUnemploymentfamEnum"));
	       youthCriticalIssues.setUnemploymentyouth(getRandamFromEnum("YouthcriticalissuesUnemploymentyouthEnum"));
	       return youthCriticalIssues;
	}
	 
	 
	 
	 public static WorstHousingSituation getWorstHousingSituation(){
	       WorstHousingSituation worstHousingSituation = new WorstHousingSituation();
	       worstHousingSituation.setWorsthousingsituation(getRandamFromEnum("WorsthousingsituationWorsthousingsituationEnum"));
	       return worstHousingSituation;
	}
	 
	 public static Sexualorientation getSexualorientation(){
	       Sexualorientation sexualorientation = new Sexualorientation();
	       sexualorientation.setSexualorientation(getRandamFromEnum("SexualorientationSexualorientationEnum"));
	       return sexualorientation;
	}

	 public static Schoolstatus getSchoolstatus(){
	       Schoolstatus schoolstatus = new Schoolstatus();

	       Random random = new Random();
	       schoolstatus.setInformationDate(LocalDateTime.now());
	       schoolstatus.setSchoolStatus(random.nextInt());
	       return schoolstatus;
	}

	 
	 public static Medicalassistance getMedicalassistance(){
	       Medicalassistance medicalassistance = new Medicalassistance();

	       medicalassistance.setAdap(getRandamFromEnum("MedicalassistanceAdapEnum"));
	       return medicalassistance;
	}
	 
	 
	 public static Pathstatus getPathstatus(){
	       Pathstatus pathstatus = new Pathstatus();

	       Random random = new Random();
	       pathstatus.setClientenrolledinpath(random.nextLong());
	       return pathstatus;
	} 
	 
	 
	 public static Percentami getPercentami(){
	       Percentami percentami = new Percentami();

	       Random random = new Random();
	       percentami.setPercentage(random.nextInt());
	       return percentami;
	}
 
	 public static Referralsource getReferralsource(){
	       Referralsource referralsource = new Referralsource();

	       Random random = new Random();
	       referralsource.setCountoutreachreferralapproaches(random.nextInt());
	       return referralsource;
	}
	 
	 
	 public static Residentialmoveindate getResidentialmoveindate(){
	       Residentialmoveindate residentialmoveindate = new Residentialmoveindate();

	       residentialmoveindate.setInpermanenthousing(getRandamFromEnum("ResidentialmoveindateInpermanenthousingEnum"));
	       return residentialmoveindate;
	} 
	 
	 public static Rhybcpstatus getRhybcpstatus(){
	       Rhybcpstatus rhybcpstatus = new Rhybcpstatus();

	       rhybcpstatus.setStatusDate(LocalDateTime.now());
	       
	       return rhybcpstatus;
	} 
	 
	 public static Projectcoc getProjectcoc(){
		 Projectcoc projectcoc = new Projectcoc();
		 projectcoc.setCoccode(generateRandomString(30));
		 return projectcoc;
	 }
	 
	 
	 public static Affiliation getaffiliation(){
	       Affiliation affiliation = new Affiliation();
	      affiliation.setResprojectid(generateRandomString(20));
	        return affiliation;
	}
	 
	 
	 public static Funder getFunder(){
	       Funder funder = new Funder();
	       funder.setEnddate(LocalDateTime.now());
	       funder.setFunder(getRandamFromEnum("FunderFunderEnum"));
	       funder.setGrantid(UUID.randomUUID().toString());
	       funder.setStartdate(LocalDateTime.now());
	   return funder;
	} 
	 
	 
	 public static NonCashBenefit getNonCashBenefit(){
	       NonCashBenefit nonCashBenefit = new NonCashBenefit();
	       
	       nonCashBenefit.setOthersourceidentify(generateRandomString(20));
	       nonCashBenefit.setOthersource(getRandamFromEnum("NoncashbenefitsOthersourceEnum"));
	       nonCashBenefit.setOthertanf(getRandamFromEnum("NoncashbenefitsOthertanfEnum"));
	       nonCashBenefit.setRentalassistanceongoing(getRandamFromEnum("NoncashbenefitsRentalassistanceongoingEnum"));
	       nonCashBenefit.setRentalassistancetemp(getRandamFromEnum("NoncashbenefitsRentalassistancetempEnum"));
	       nonCashBenefit.setSnap(getRandamFromEnum("NoncashbenefitsSnapEnum"));
	       nonCashBenefit.setTanfchildcare(getRandamFromEnum("NoncashbenefitsTanfchildcareEnum"));
	       nonCashBenefit.setTanftransportation(getRandamFromEnum("NoncashbenefitsTanftransportationEnum"));
	       nonCashBenefit.setWic(getRandamFromEnum("NoncashbenefitsWicEnum"));
	       nonCashBenefit.setBenefitsfromanysource(getRandamFromEnum("NoncashbenefitsBenefitsfromanysourceEnum"));
	       return nonCashBenefit;
	}
	 
	public static void main(String args[]){
		TestData.getRandamFromEnum("EmploymentEmployedEnum");
	}
	
	public static SharingRule getSharingRule() throws Exception {
		return null;
	}
	
	
	
}
