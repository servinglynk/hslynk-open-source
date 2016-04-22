package com.servinglynk.hmis.warehouse;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import com.servinglynk.hmis.warehouse.model.v2014.Affiliation;
import com.servinglynk.hmis.warehouse.model.v2014.Bedinventory;
import com.servinglynk.hmis.warehouse.model.v2014.Client;
import com.servinglynk.hmis.warehouse.model.v2014.Commercialsexualexploitation;
import com.servinglynk.hmis.warehouse.model.v2014.Connectionwithsoar;
import com.servinglynk.hmis.warehouse.model.v2014.Dateofengagement;
import com.servinglynk.hmis.warehouse.model.v2014.Disabilities;
import com.servinglynk.hmis.warehouse.model.v2014.Domesticviolence;
import com.servinglynk.hmis.warehouse.model.v2014.Employment;
import com.servinglynk.hmis.warehouse.model.v2014.Enrollment;
import com.servinglynk.hmis.warehouse.model.v2014.EnrollmentCoc;
import com.servinglynk.hmis.warehouse.model.v2014.Exit;
import com.servinglynk.hmis.warehouse.model.v2014.Exithousingassessment;
import com.servinglynk.hmis.warehouse.model.v2014.Exitplansactions;
import com.servinglynk.hmis.warehouse.model.v2014.Export;
import com.servinglynk.hmis.warehouse.model.v2014.Familyreunification;
import com.servinglynk.hmis.warehouse.model.v2014.Formerwardchildwelfare;
import com.servinglynk.hmis.warehouse.model.v2014.Formerwardjuvenilejustice;
import com.servinglynk.hmis.warehouse.model.v2014.Funder;
import com.servinglynk.hmis.warehouse.model.v2014.HealthStatus;
import com.servinglynk.hmis.warehouse.model.v2014.Housingassessmentdisposition;
import com.servinglynk.hmis.warehouse.model.v2014.Incomeandsources;
import com.servinglynk.hmis.warehouse.model.v2014.Inventory;
import com.servinglynk.hmis.warehouse.model.v2014.Lastgradecompleted;
import com.servinglynk.hmis.warehouse.model.v2014.Lastpermanentaddress;
import com.servinglynk.hmis.warehouse.model.v2014.Medicalassistance;
import com.servinglynk.hmis.warehouse.model.v2014.Noncashbenefits;
import com.servinglynk.hmis.warehouse.model.v2014.Organization;
import com.servinglynk.hmis.warehouse.model.v2014.Percentami;
import com.servinglynk.hmis.warehouse.model.v2014.Projectcoc;
import com.servinglynk.hmis.warehouse.model.v2014.Projectcompletionstatus;
import com.servinglynk.hmis.warehouse.model.v2014.Referralsource;
import com.servinglynk.hmis.warehouse.model.v2014.Residentialmoveindate;
import com.servinglynk.hmis.warehouse.model.v2014.Rhybcpstatus;
import com.servinglynk.hmis.warehouse.model.v2014.Schoolstatus;
import com.servinglynk.hmis.warehouse.model.v2014.Services;
import com.servinglynk.hmis.warehouse.model.v2014.Sexualorientation;
import com.servinglynk.hmis.warehouse.model.v2014.Site;
import com.servinglynk.hmis.warehouse.model.v2014.VeteranInfo;
import com.servinglynk.hmis.warehouse.model.v2014.Worsthousingsituation;
import com.servinglynk.hmis.warehouse.model.v2014.Youthcriticalissues;
import com.servinglynk.hmis.warehouse.model.v2015.Pathstatus;
import com.servinglynk.hmis.warehouse.model.v2015.Project;

public class FromPostgres {

	public static void main(String args[]) {
		
	//	syncClient(date,Client.class);
	System.out.println("-------- PostgreSQL "
			+ "JDBC Connection Testing ------------");
	long startNanos = System.nanoTime();
	// Sync Table Start
	BaseProcessor baseProcessor = new BaseProcessor();
	// Lets use timestamp instead of date.
	Timestamp lastSyncTime = null;
	UUID syncUid = baseProcessor.insertSyncStartTime();		
	final List<BulkUpload> uploads = baseProcessor.getExportIDFromBulkUpload();
	final Map<String,String> hmisTypes = baseProcessor.loadHmisTypeMap();
	System.out.println(lastSyncTime);
	java.util.Map<String, Integer> tableSyncList = new HashMap<>();
	final java.util.Map<String, Integer> affiliationMap = new HashMap<>();
	final java.util.Map<String, Integer> 	ClientMap					 = new HashMap<>();
	final java.util.Map<String, Integer> 	bedinventoryMap				= new HashMap<>();
	final java.util.Map<String, Integer> 	CommercialsexualexploitationMap		= new HashMap<>();
	final java.util.Map<String, Integer> 	ConnectionwithsoarMap			= new HashMap<>();
	final java.util.Map<String, Integer> 	DateofengagementMap			= new HashMap<>();
	final java.util.Map<String, Integer> 	DisabilitiesMap			= new HashMap<>();
	final java.util.Map<String, Integer> 	DomesticviolenceMap		        = new HashMap<>();
	final java.util.Map<String, Integer> 	EmploymentMap				 = new HashMap<>();
	final java.util.Map<String, Integer> 	EnrollmentMap				 = new HashMap<>();
	final java.util.Map<String, Integer> 	Enrollment_cocMap				= new HashMap<>();
	final java.util.Map<String, Integer> 	ExitMap					= new HashMap<>();
	final java.util.Map<String, Integer> 	ExithousingassessmentMap			= new HashMap<>();
	final java.util.Map<String, Integer> 	ExitplansactionsMap			= new HashMap<>();
	final java.util.Map<String, Integer> 	ExportMap					= new HashMap<>();
	final java.util.Map<String, Integer> 	familyreunificationMap			= new HashMap<>();
	final java.util.Map<String, Integer> 	FormerwardchildwelfareMap			 = new HashMap<>();
	final java.util.Map<String, Integer> 	FormerwardjuvenilejusticeMap		 = new HashMap<>();
	final java.util.Map<String, Integer> 	FunderMap					= new HashMap<>();
	final java.util.Map<String, Integer> 	Health_StatusMap				= new HashMap<>();
	final java.util.Map<String, Integer> 	HousingassessmentdispositionMap		= new HashMap<>();
	final java.util.Map<String, Integer> 	IncomeandsourcesMap			= new HashMap<>();
	final java.util.Map<String, Integer> 	InventoryMap				= new HashMap<>();
	final java.util.Map<String, Integer> 	LastgradecompletedMap			= new HashMap<>();
	final java.util.Map<String, Integer> 	last_perm_addressMap			 = new HashMap<>();
	final java.util.Map<String, Integer> 	MedicalassistanceMap			 = new HashMap<>();
	final java.util.Map<String, Integer> 	NoncashbenefitsMap				= new HashMap<>();
	final java.util.Map<String, Integer> 	OrganizationMap				= new HashMap<>();
	final java.util.Map<String, Integer> 	Path_statusMap				= new HashMap<>();
	final java.util.Map<String, Integer> 	Percent_amiMap				= new HashMap<>();
	final java.util.Map<String, Integer> 	ProjectMap					= new HashMap<>();
	final java.util.Map<String, Integer> 	ProjectcocMap				= new HashMap<>();
	final java.util.Map<String, Integer> 	ProjectcompletionstatusMap			 = new HashMap<>();
	final java.util.Map<String, Integer> 	ReferralsourceMap				 = new HashMap<>();
	final java.util.Map<String, Integer> 	residentialmoveindateMap			= new HashMap<>();
	final java.util.Map<String, Integer> 	Rhybcp_statusMap				= new HashMap<>();
	final java.util.Map<String, Integer> 	SchoolstatusMap				= new HashMap<>();
	final java.util.Map<String, Integer> 	ServicesMap				= new HashMap<>();
	final java.util.Map<String, Integer> 	SexualorientationMap			= new HashMap<>();
	final java.util.Map<String, Integer> 	SiteMap					= new HashMap<>();
	final java.util.Map<String, Integer> 	Veteran_InfoMap				 = new HashMap<>();
	final java.util.Map<String, Integer> 	WorsthousingsituationMap			 = new HashMap<>();
	final java.util.Map<String, Integer> 	YouthcriticalissuesMap			= new HashMap<>();
					
	Thread thread1 = new Thread() {
	    public void run() {
	    	long startNanos = System.nanoTime();
	    	BaseProcessor<Affiliation> aff = new BaseProcessor<>();
	    	aff.syncToHBASE(Affiliation.class,"affiliation",affiliationMap, null,uploads.get(0),hmisTypes);
	    	System.out.println("Time taken to complete Sync in millis"+
		            TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos));
	    }
	};
	
	Thread thread2 = new Thread() {
	    public void run() {
	    	long startNanos = System.nanoTime();
	    	BaseProcessor<Client> db = new BaseProcessor<>();
	    	db.syncToHBASE(Client.class,"Client",ClientMap, null,uploads.get(0),hmisTypes);
	     	System.out.println("Sync in millis for Client containing "+ClientMap.size() +" is "+
		            TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos));
	    }
	};
	
	
	
	Thread thread3 = new Thread() {
	    public void run() {
	    	long startNanos = System.nanoTime();
	    	BaseProcessor<Bedinventory> bedInventory = new BaseProcessor<>();
	    	bedInventory.syncToHBASE(Bedinventory.class,"Bedinventory",bedinventoryMap, null,uploads.get(0),hmisTypes);
	     	System.out.println("Sync in millis for Bedinventory containing "+bedinventoryMap.size() +" is "+
		            TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos));
	    }
	};
	
	Thread thread4 = new Thread() {
	    public void run() {
	    	long startNanos = System.nanoTime();
	    	BaseProcessor<Connectionwithsoar> connectionwithsoar = new BaseProcessor<>();
	    	connectionwithsoar.syncToHBASE(Connectionwithsoar.class,"Connectionwithsoar",ConnectionwithsoarMap, null,uploads.get(0),hmisTypes);
	    	System.out.println("Sync in millis for Connectionwithsoar containing "+ConnectionwithsoarMap.size() +" is "+
		            TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos));
	    }
	};

	Thread thread5 = new Thread() {
	    public void run() {
	    	long startNanos = System.nanoTime();
	    	BaseProcessor<Dateofengagement> dateofengagement = new BaseProcessor<>();
	    	dateofengagement.syncToHBASE(Dateofengagement.class,"Dateofengagement",DateofengagementMap, null,uploads.get(0),hmisTypes);
	    	System.out.println("Sync in millis for Dateofengagement containing "+DateofengagementMap.size() +" is "+
		            TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos));
	    	
	    }
	};
	
	Thread thread6 = new Thread() {
	    public void run() {
	    	long startNanos = System.nanoTime();
	    	BaseProcessor<Disabilities> disabilities = new BaseProcessor<>();
	    	disabilities.syncToHBASE(Disabilities.class,"Disabilities",DisabilitiesMap, null,uploads.get(0),hmisTypes);
	    	System.out.println("Sync in millis for Disabilities containing "+DisabilitiesMap.size() +" is "+
		            TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos));
	    	
	    }
	};
	Thread thread7 = new Thread() {
	    public void run() {
	    	long startNanos = System.nanoTime();
	    	BaseProcessor<Domesticviolence> domesticviolence = new BaseProcessor<>();
	    	domesticviolence.syncToHBASE(Domesticviolence.class,"Domesticviolence",DomesticviolenceMap, null,uploads.get(0),hmisTypes);
	    	System.out.println("Sync in millis for Domesticviolence containing "+DomesticviolenceMap.size() +" is "+
		            TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos));
	    	
	    }
	};
	Thread thread8 = new Thread() {
	    public void run() {
	    	long startNanos = System.nanoTime();
	    	BaseProcessor<Employment> employment = new BaseProcessor<>();
	    	employment.syncToHBASE(Employment.class,"Employment",EmploymentMap, null,uploads.get(0),hmisTypes);
	    	System.out.println("Sync in millis for Employment containing "+EmploymentMap.size() +" is "+
		            TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos));
	    }
	};
	Thread thread9 = new Thread() {
	    public void run() {
	    	long startNanos = System.nanoTime();
	    	BaseProcessor<Commercialsexualexploitation> commercialsexualexploitation = new BaseProcessor<>();
	    	commercialsexualexploitation.syncToHBASE(Commercialsexualexploitation.class,"Commercialsexualexploitation",CommercialsexualexploitationMap, null,uploads.get(0),hmisTypes);
	    	System.out.println("Sync in millis for Commercialsexualexploitation containing "+CommercialsexualexploitationMap.size() +" is "+
		            TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos));
	    }
	};
	
	Thread thread10 = new Thread() {
	    public void run() {
	    	long startNanos = System.nanoTime();
	    	BaseProcessor<Enrollment> enrollment = new BaseProcessor<>();
	    	enrollment.syncToHBASE(Enrollment.class,"Enrollment",EnrollmentMap, null,uploads.get(0),hmisTypes);
	    	System.out.println("Sync in millis for Enrollment containing "+EnrollmentMap.size() +" is "+
		            TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos));
	    	
	    }
	};
	Thread thread11 = new Thread() {
	    public void run() {
	    	long startNanos = System.nanoTime();
	    	BaseProcessor<EnrollmentCoc> enrollmentCoc = new BaseProcessor<>();
	    	enrollmentCoc.syncToHBASE(EnrollmentCoc.class,"Enrollment_coc",Enrollment_cocMap, null,uploads.get(0),hmisTypes);
	    	System.out.println("Sync in millis for Enrollment_coc containing "+Enrollment_cocMap.size() +" is "+
		            TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos));
	    }
	};
	Thread thread12 = new Thread() {
	    public void run() {
	    	long startNanos = System.nanoTime();
	    	BaseProcessor<Exit> exit = new BaseProcessor<>();
	    	exit.syncToHBASE(Exit.class,"Exit",ExitMap, null,uploads.get(0),hmisTypes);
	    	System.out.println("Sync in millis for Exit containing "+ExitMap.size() +" is "+
		            TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos));

	    }
	};
	Thread thread14 = new Thread() {
	    public void run() {
	    	long startNanos = System.nanoTime();
	    	BaseProcessor<Exithousingassessment> exithousingassessment = new BaseProcessor<>();
	    	exithousingassessment.syncToHBASE(Exithousingassessment.class,"Exithousingassessment",ExithousingassessmentMap, null,uploads.get(0),hmisTypes);
	    	System.out.println("Sync in millis for Exithousingassessment containing "+ExithousingassessmentMap.size() +" is "+
		            TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos));
	    }
	};
	Thread thread15 = new Thread() {
	    public void run() {
	    	long startNanos = System.nanoTime();
	    	BaseProcessor<Exitplansactions> exitplansactions = new BaseProcessor<>();
	    	exitplansactions.syncToHBASE(Exitplansactions.class,"Exitplansactions",ExitplansactionsMap, null,uploads.get(0),hmisTypes);
	    	System.out.println("Sync in millis for Exitplansactions containing "+ExitplansactionsMap.size() +" is "+
		            TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos));
	    }
	};
	
	Thread thread16 = new Thread() {
	    public void run() {
	    	long startNanos = System.nanoTime();
	    	BaseProcessor<Export> export = new BaseProcessor<>();
	    	export.syncToHBASE(Export.class,"Export",ExportMap, null,uploads.get(0),hmisTypes);
	    	System.out.println("Sync in millis for Export containing "+ExportMap.size() +" is "+
		            TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos));
	    }
	};
	Thread thread17 = new Thread() {
	    public void run() {
	    	long startNanos = System.nanoTime();
	    	BaseProcessor<Familyreunification> familyreunification = new BaseProcessor<>();
	    	familyreunification.syncToHBASE(Familyreunification.class,"familyreunification",familyreunificationMap, null,uploads.get(0),hmisTypes);
	    	System.out.println("Sync in millis for familyreunification containing "+familyreunificationMap.size() +" is "+
		            TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos));
	    }
	};
	Thread thread18 = new Thread() {
	    public void run() {
	    	long startNanos = System.nanoTime();
	    	BaseProcessor<Formerwardchildwelfare> formerwardchildwelfare = new BaseProcessor<>();
	    	formerwardchildwelfare.syncToHBASE(Formerwardchildwelfare.class,"Formerwardchildwelfare",FormerwardchildwelfareMap, null,uploads.get(0),hmisTypes);
	    	System.out.println("Sync in millis for Formerwardchildwelfare containing "+FormerwardchildwelfareMap.size() +" is "+
		            TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos));
	    }
	};
	Thread thread20 = new Thread() {
	    public void run() {
	    	long startNanos = System.nanoTime();
	    	BaseProcessor<Formerwardjuvenilejustice> formerwardjuvenilejustice = new BaseProcessor<>();
	    	formerwardjuvenilejustice.syncToHBASE(Formerwardjuvenilejustice.class,"Formerwardjuvenilejustice",FormerwardjuvenilejusticeMap, null,uploads.get(0),hmisTypes);
	    	System.out.println("Sync in millis for Formerwardjuvenilejustice containing "+FormerwardjuvenilejusticeMap.size() +" is "+
		            TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos));
	    	
	    }
	};
	Thread thread21 = new Thread() {
	    public void run() {
	    	long startNanos = System.nanoTime();
	    	BaseProcessor<Funder> funder = new BaseProcessor<>();
	    	funder.syncToHBASE(Funder.class,"Funder",FunderMap, null,uploads.get(0),hmisTypes);
	    	System.out.println("Sync in millis for Funder containing "+FunderMap.size() +" is "+
		            TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos));
	    }
	};
	Thread thread22 = new Thread() {
	    public void run() {
	    	long startNanos = System.nanoTime();
	    	BaseProcessor<HealthStatus> healthStatus = new BaseProcessor<>();
	    	healthStatus.syncToHBASE(HealthStatus.class,"Health_Status",Health_StatusMap, null,uploads.get(0),hmisTypes);
	    	System.out.println("Sync in millis for Health_Status containing "+Health_StatusMap.size() +" is "+
		            TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos));

	    }
	};
	Thread thread23 = new Thread() {
	    public void run() {
	    	long startNanos = System.nanoTime();
	    	BaseProcessor<Housingassessmentdisposition> housingassessmentdisposition = new BaseProcessor<>();
	    	housingassessmentdisposition.syncToHBASE(Housingassessmentdisposition.class,"Housingassessmentdisposition",HousingassessmentdispositionMap, null,uploads.get(0),hmisTypes);
	    	System.out.println("Sync in millis for Housingassessmentdisposition containing "+HousingassessmentdispositionMap.size() +" is "+
		            TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos));
	    	
	    }
	};
	Thread thread24 = new Thread() {
	    public void run() {
	    	long startNanos = System.nanoTime();
	    	BaseProcessor<Incomeandsources> incomeandsources = new BaseProcessor<>();
	    	incomeandsources.syncToHBASE(Incomeandsources.class,"Incomeandsources",IncomeandsourcesMap, null,uploads.get(0),hmisTypes);
	    	System.out.println("Sync in millis for Incomeandsources containing "+IncomeandsourcesMap.size() +" is "+
		            TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos));
	    	
	    }
	};
	Thread thread25 = new Thread() {
	    public void run() {
	    	long startNanos = System.nanoTime();
	    	BaseProcessor<Inventory> inventory = new BaseProcessor<>();
	    	inventory.syncToHBASE(Inventory.class,"Inventory",InventoryMap, null,uploads.get(0),hmisTypes);
	    	System.out.println("Sync in millis for Inventory containing "+InventoryMap.size() +" is "+
		            TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos));
	    }
	};
	Thread thread26 = new Thread() {
	    public void run() {
	    	long startNanos = System.nanoTime();
	    	BaseProcessor<Lastgradecompleted> lastgradecompleted = new BaseProcessor<>();
	    	lastgradecompleted.syncToHBASE(Lastgradecompleted.class,"Lastgradecompleted",LastgradecompletedMap, null,uploads.get(0),hmisTypes);
	    	System.out.println("Sync in millis for Lastgradecompleted containing "+LastgradecompletedMap.size() +" is "+
		            TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos));
	    	
	    }
	};
	
	Thread thread27 = new Thread() {
	    public void run() {
	    	long startNanos = System.nanoTime();
	    	BaseProcessor<Lastpermanentaddress> Lastpermanentaddress = new BaseProcessor<>();
	    	Lastpermanentaddress.syncToHBASE(Lastpermanentaddress.class,"last_perm_address",last_perm_addressMap, null,uploads.get(0),hmisTypes);
	    	System.out.println("Sync in millis for Lastpermanentaddress containing "+last_perm_addressMap.size() +" is "+
		            TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos));
	    }
	};
	Thread thread28 = new Thread() {
	    public void run() {
	    	long startNanos = System.nanoTime();
	    	BaseProcessor<Medicalassistance> Medicalassistance = new BaseProcessor<>();
	    	Medicalassistance.syncToHBASE(Medicalassistance.class,"Medicalassistance",MedicalassistanceMap, null,uploads.get(0),hmisTypes);
	    	System.out.println("Sync in millis for Medicalassistance containing "+MedicalassistanceMap.size() +" is "+
		            TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos));
	    }
	};
	Thread thread29 = new Thread() {
	    public void run() {
	    	long startNanos = System.nanoTime();
	    	BaseProcessor<Noncashbenefits> Noncashbenefits = new BaseProcessor<>();
	    	Noncashbenefits.syncToHBASE(Noncashbenefits.class,"Noncashbenefits",NoncashbenefitsMap, null,uploads.get(0),hmisTypes);
	    	System.out.println("Sync in millis for Noncashbenefits containing "+NoncashbenefitsMap.size() +" is "+
		            TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos));
	    	
	    }
	};
	Thread thread30 = new Thread() {
	    public void run() {
	    	long startNanos = System.nanoTime();
	    	BaseProcessor<Organization> Organization = new BaseProcessor<>();
	    	Organization.syncToHBASE(Organization.class,"Organization",OrganizationMap, null,uploads.get(0),hmisTypes);
	    	System.out.println("Sync in millis for Organization containing "+OrganizationMap.size() +" is "+
		            TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos));
	    }
	};
	Thread thread31 = new Thread() {
	    public void run() {
	    	long startNanos = System.nanoTime();
	    	BaseProcessor<Pathstatus> Pathstatus = new BaseProcessor<>();
	    	Pathstatus.syncToHBASE(Pathstatus.class,"Path_status",Path_statusMap, null,uploads.get(0),hmisTypes);
	    	System.out.println("Sync in millis for Path_status containing "+Path_statusMap.size() +" is "+
		            TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos));
	    }
	};
	
	Thread thread32 = new Thread() {
	    public void run() {
	    	long startNanos = System.nanoTime();
	    	BaseProcessor<Percentami> Percentami = new BaseProcessor<>();
	    	Percentami.syncToHBASE(Percentami.class,"Percent_ami",Percent_amiMap, null,uploads.get(0),hmisTypes);
	    	System.out.println("Sync in millis for Percent_ami containing "+Percent_amiMap.size() +" is "+
		            TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos));
	    }
	};
	Thread thread33 = new Thread() {
	    public void run() {
	    	long startNanos = System.nanoTime();
	    	BaseProcessor<Project> Project = new BaseProcessor<>();
	    	Project.syncToHBASE(Project.class,"Project",ProjectMap, null,uploads.get(0),hmisTypes);
	    	System.out.println("Sync in millis for Project containing "+ProjectMap.size() +" is "+
		            TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos));
	    }
	};
	Thread thread34 = new Thread() {
	    public void run() {
	    	long startNanos = System.nanoTime();
	    	BaseProcessor<Projectcoc> Projectcoc = new BaseProcessor<>();
	    	Projectcoc.syncToHBASE(Projectcoc.class,"Projectcoc",ProjectcocMap, null,uploads.get(0),hmisTypes);
	    	System.out.println("Sync in millis for Projectcoc containing "+ProjectcocMap.size() +" is "+
		            TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos));
	    	
	    }
	};
	Thread thread35 = new Thread() {
	    public void run() {
	    	long startNanos = System.nanoTime();
	    	BaseProcessor<Projectcompletionstatus> Projectcompletionstatus = new BaseProcessor<>();
	    	Projectcompletionstatus.syncToHBASE(Projectcompletionstatus.class,"Projectcompletionstatus",ProjectcompletionstatusMap, null,uploads.get(0),hmisTypes);
	    	System.out.println("Sync in millis for Projectcompletionstatus containing "+ProjectcompletionstatusMap.size() +" is "+
		            TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos));
	    	
	    }
	};
	Thread thread36 = new Thread() {
	    public void run() {
	    	long startNanos = System.nanoTime();
	    	BaseProcessor<Referralsource> Referralsource = new BaseProcessor<>();
	    	Referralsource.syncToHBASE(Referralsource.class,"Referralsource",ReferralsourceMap, null,uploads.get(0),hmisTypes);
	    	System.out.println("Sync in millis for Referralsource containing "+ReferralsourceMap.size() +" is "+
		            TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos));
	    	
	    }
	};
	Thread thread37 = new Thread() {
	    public void run() {
	    	long startNanos = System.nanoTime();
	    	BaseProcessor<Residentialmoveindate> Residentialmoveindate = new BaseProcessor<>();
	    	Residentialmoveindate.syncToHBASE(Residentialmoveindate.class,"residentialmoveindate",residentialmoveindateMap, null,uploads.get(0),hmisTypes);
	    	System.out.println("Sync in millis for Residentialmoveindate containing "+residentialmoveindateMap.size() +" is "+
		            TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos));
	    }
	};
	Thread thread38 = new Thread() {
	    public void run() {
	    	long startNanos = System.nanoTime();
	    	BaseProcessor<Rhybcpstatus> Rhybcpstatus = new BaseProcessor<>();
	    	Rhybcpstatus.syncToHBASE(Rhybcpstatus.class,"Rhybcp_status",Rhybcp_statusMap, null,uploads.get(0),hmisTypes);
	    	System.out.println("Sync in millis for Rhybcp_status containing "+Rhybcp_statusMap.size() +" is "+
		            TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos));
	    }
	};
	Thread thread39 = new Thread() {
	    public void run() {
	    	long startNanos = System.nanoTime();
	    	BaseProcessor<Schoolstatus> Schoolstatus = new BaseProcessor<>();
	    	Schoolstatus.syncToHBASE(Schoolstatus.class,"Schoolstatus",SchoolstatusMap, null,uploads.get(0),hmisTypes);
	    	System.out.println("Sync in millis for Schoolstatus containing "+SchoolstatusMap.size() +" is "+
		            TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos));
	    }
	};
	Thread thread40 = new Thread() {
	    public void run() {
	    	long startNanos = System.nanoTime();
	    	BaseProcessor<Services> Services = new BaseProcessor<>();
	    	Services.syncToHBASE(Services.class,"Services",ServicesMap, null,uploads.get(0),hmisTypes);
	    	System.out.println("Sync in millis for Services containing "+ServicesMap.size() +" is "+
		            TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos));
	    }
	};
	Thread thread41 = new Thread() {
	    public void run() {
	    	long startNanos = System.nanoTime();
	    	BaseProcessor<Sexualorientation> Sexualorientation = new BaseProcessor<>();
	    	Sexualorientation.syncToHBASE(Sexualorientation.class,"Sexualorientation",SexualorientationMap, null,uploads.get(0),hmisTypes);
	    	System.out.println("Sync in millis for Sexualorientation containing "+SexualorientationMap.size() +" is "+
		            TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos));
	    }
	};
	Thread thread42 = new Thread() {
	    public void run() {
	    	long startNanos = System.nanoTime();
	    	BaseProcessor<Site> Site = new BaseProcessor<>();
	    	Site.syncToHBASE(Site.class,"Site",SiteMap, null,uploads.get(0),hmisTypes);
	    	System.out.println("Sync in millis for Site containing "+SiteMap.size() +" is "+
		            TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos));
	    }
	};
//	BaseProcessor<Source> Source = new BaseProcessor<>();
//	Source.getResult(Source.class);
	
	Thread thread43 = new Thread() {
	    public void run() {
	    	long startNanos = System.nanoTime();
	    	BaseProcessor<VeteranInfo> VeteranInfo = new BaseProcessor<>();
	    	VeteranInfo.syncToHBASE(VeteranInfo.class,"Veteran_Info",Veteran_InfoMap, null,uploads.get(0),hmisTypes);
	    	System.out.println("Sync in millis for Veteran_Info containing "+Veteran_InfoMap.size() +" is "+
		            TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos));
	    }
	};
	Thread thread44 = new Thread() {
	    public void run() {
	    	long startNanos = System.nanoTime();
	    	BaseProcessor<Worsthousingsituation> Worsthousingsituation = new BaseProcessor<>();
	    	Worsthousingsituation.syncToHBASE(Worsthousingsituation.class,"Worsthousingsituation",WorsthousingsituationMap, null,uploads.get(0),hmisTypes);
	    	System.out.println("Sync in millis for Worsthousingsituation containing "+WorsthousingsituationMap.size() +" is "+
		            TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos));
	    	
	    }
	};
	
	Thread thread45 = new Thread() {
	    public void run() {
	    	long startNanos = System.nanoTime();
	    	BaseProcessor<Youthcriticalissues> Youthcriticalissues = new BaseProcessor<>();
	    	Youthcriticalissues.syncToHBASE(Youthcriticalissues.class,"Youthcriticalissues",YouthcriticalissuesMap, null,uploads.get(0),hmisTypes);
	    	System.out.println("Sync in millis for Youthcriticalissues containing "+YouthcriticalissuesMap.size() +" is "+
		            TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos));

	    }
	};
	
	/*
	BaseProcessor<Commercialsexualexploitation> commercialsexualexploitation = new BaseProcessor<>();
	commercialsexualexploitation.syncToHBASE(Commercialsexualexploitation.class,"Commercialsexualexploitation",tableSyncList, null,uploads.get(0),hmisTypes);
	
	System.out.println("Tables::"+tableSyncList.toString());
	*/
	thread1.start();
	thread2.start();
	thread3.start();
	thread4.start();
	thread5.start();
	thread6.start();
	thread7.start();
	thread8.start();
	thread9.start();
	thread10.start();
	thread11.start();
	thread12.start();
	thread14.start();
	thread15.start();
	thread16.start();
	thread17.start();
	thread18.start();
	thread20.start();
	thread21.start();
	thread22.start();
	thread23.start();
	thread24.start();
	thread25.start();
	thread26.start();
	thread27.start();
	thread28.start();
	thread29.start();
	thread30.start();
	thread31.start();
	thread32.start();
	thread33.start();
	thread34.start();
	thread35.start();
	thread36.start();
	thread37.start();
	thread38.start();
	thread39.start();
	thread40.start();
	thread41.start();
	thread42.start();
	thread43.start();
	thread44.start();
	thread45.start();
	
	
	
try {
		thread1.join();
		thread2.join();
		thread4.join();
		thread5.join();
		thread6.join();
		thread7.join();
		thread8.join();
		thread9.join();
		thread10.join();
		thread11.join();
		thread12.join();
		thread14.join();
		thread15.join();
		thread16.join();
		thread17.join();
		thread18.join();
		thread20.join();
		thread21.join();
		thread22.join();
		thread23.join();
		thread24.join();
		thread25.join();
		thread26.join();
		thread27.join();
		thread28.join();
		thread29.join();
		thread30.join();
		thread31.join();
		thread32.join();
		thread33.join();
		thread34.join();
		thread35.join();
		thread36.join();
		thread37.join();
		thread38.join();
		thread39.join();
		thread40.join();
		thread41.join();
		thread42.join();
		thread43.join();
		thread44.join();
		thread45.join();
		baseProcessor.updateSyncEndDate(tableSyncList.toString(), syncUid); 
		System.out.println("Time taken to complete Sync in millis"+
	            TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos));
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	
	
	
}
}