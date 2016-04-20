package com.servinglynk.hmis.warehouse;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.UUID;

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
	
	// Sync Table Start
	BaseProcessor baseProcessor = new BaseProcessor();
	// Lets use timestamp instead of date.
	Timestamp lastSyncTime = null;
	UUID syncUid = baseProcessor.insertSyncStartTime();		
	
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
	    	BaseProcessor<Affiliation> aff = new BaseProcessor<>();
	    	aff.syncToHBASE(Affiliation.class,"affiliation",affiliationMap, null);
	    }
	};
	
	Thread thread2 = new Thread() {
	    public void run() {
	    	BaseProcessor<Client> db = new BaseProcessor<>();
	    	db.syncToHBASE(Client.class,"Client",ClientMap, null);
	    }
	};
	
	
	
	Thread thread3 = new Thread() {
	    public void run() {
	    	BaseProcessor<Bedinventory> bedInventory = new BaseProcessor<>();
	    	bedInventory.syncToHBASE(Bedinventory.class,"Bedinventory",bedinventoryMap, null);
	    }
	};
	
	Thread thread4 = new Thread() {
	    public void run() {
	    	BaseProcessor<Connectionwithsoar> connectionwithsoar = new BaseProcessor<>();
	    	connectionwithsoar.syncToHBASE(Connectionwithsoar.class,"Connectionwithsoar",ConnectionwithsoarMap, null);
	    }
	};

	Thread thread5 = new Thread() {
	    public void run() {
	    	BaseProcessor<Dateofengagement> dateofengagement = new BaseProcessor<>();
	    	dateofengagement.syncToHBASE(Dateofengagement.class,"Dateofengagement",DateofengagementMap, null);
	    	
	    }
	};
	
	Thread thread6 = new Thread() {
	    public void run() {
	    	BaseProcessor<Disabilities> disabilities = new BaseProcessor<>();
	    	disabilities.syncToHBASE(Disabilities.class,"Disabilities",DisabilitiesMap, null);
	    	
	    }
	};
	Thread thread7 = new Thread() {
	    public void run() {
	    	BaseProcessor<Domesticviolence> domesticviolence = new BaseProcessor<>();
	    	domesticviolence.syncToHBASE(Domesticviolence.class,"Domesticviolence",DomesticviolenceMap, null);
	    	
	    }
	};
	Thread thread8 = new Thread() {
	    public void run() {
	    	BaseProcessor<Employment> employment = new BaseProcessor<>();
	    	employment.syncToHBASE(Employment.class,"Employment",EmploymentMap, null);
	    }
	};
	Thread thread9 = new Thread() {
	    public void run() {
	    	BaseProcessor<Commercialsexualexploitation> commercialsexualexploitation = new BaseProcessor<>();
	    	commercialsexualexploitation.syncToHBASE(Commercialsexualexploitation.class,"Commercialsexualexploitation",CommercialsexualexploitationMap, null);
	    }
	};
	
	Thread thread10 = new Thread() {
	    public void run() {
	    	BaseProcessor<Enrollment> enrollment = new BaseProcessor<>();
	    	enrollment.syncToHBASE(Enrollment.class,"Enrollment",EnrollmentMap, null);
	    	
	    }
	};
	Thread thread11 = new Thread() {
	    public void run() {
	    	BaseProcessor<EnrollmentCoc> enrollmentCoc = new BaseProcessor<>();
	    	enrollmentCoc.syncToHBASE(EnrollmentCoc.class,"Enrollment_coc",Enrollment_cocMap, null);
	    }
	};
	Thread thread12 = new Thread() {
	    public void run() {
	    	BaseProcessor<Exit> exit = new BaseProcessor<>();
	    	exit.syncToHBASE(Exit.class,"Exit",ExitMap, null);

	    }
	};
	Thread thread14 = new Thread() {
	    public void run() {
	    	BaseProcessor<Exithousingassessment> exithousingassessment = new BaseProcessor<>();
	    	exithousingassessment.syncToHBASE(Exithousingassessment.class,"Exithousingassessment",ExithousingassessmentMap, null);
	    }
	};
	Thread thread15 = new Thread() {
	    public void run() {
	    	BaseProcessor<Exitplansactions> exitplansactions = new BaseProcessor<>();
	    	exitplansactions.syncToHBASE(Exitplansactions.class,"Exitplansactions",ExitplansactionsMap, null);
	    }
	};
	
	Thread thread16 = new Thread() {
	    public void run() {
	    	BaseProcessor<Export> export = new BaseProcessor<>();
	    	export.syncToHBASE(Export.class,"Export",ExportMap, null);
	    }
	};
	Thread thread17 = new Thread() {
	    public void run() {
	    	BaseProcessor<Familyreunification> familyreunification = new BaseProcessor<>();
	    	familyreunification.syncToHBASE(Familyreunification.class,"familyreunification",familyreunificationMap, null);
	    }
	};
	Thread thread18 = new Thread() {
	    public void run() {
	    	BaseProcessor<Formerwardchildwelfare> formerwardchildwelfare = new BaseProcessor<>();
	    	formerwardchildwelfare.syncToHBASE(Formerwardchildwelfare.class,"Formerwardchildwelfare",FormerwardchildwelfareMap, null);
	    }
	};
	Thread thread20 = new Thread() {
	    public void run() {
	    	BaseProcessor<Formerwardjuvenilejustice> formerwardjuvenilejustice = new BaseProcessor<>();
	    	formerwardjuvenilejustice.syncToHBASE(Formerwardjuvenilejustice.class,"Formerwardjuvenilejustice",FormerwardjuvenilejusticeMap, null);
	    	
	    }
	};
	Thread thread21 = new Thread() {
	    public void run() {
	    	BaseProcessor<Funder> funder = new BaseProcessor<>();
	    	funder.syncToHBASE(Funder.class,"Funder",FunderMap, null);
	    }
	};
	Thread thread22 = new Thread() {
	    public void run() {
	    	BaseProcessor<HealthStatus> healthStatus = new BaseProcessor<>();
	    	healthStatus.syncToHBASE(HealthStatus.class,"Health_Status",Health_StatusMap, null);

	    }
	};
	Thread thread23 = new Thread() {
	    public void run() {
	    	BaseProcessor<Housingassessmentdisposition> housingassessmentdisposition = new BaseProcessor<>();
	    	housingassessmentdisposition.syncToHBASE(Housingassessmentdisposition.class,"Housingassessmentdisposition",HousingassessmentdispositionMap, null);
	    	
	    }
	};
	Thread thread24 = new Thread() {
	    public void run() {
	    	BaseProcessor<Incomeandsources> incomeandsources = new BaseProcessor<>();
	    	incomeandsources.syncToHBASE(Incomeandsources.class,"Incomeandsources",IncomeandsourcesMap, null);
	    	
	    }
	};
	Thread thread25 = new Thread() {
	    public void run() {
	    	BaseProcessor<Inventory> inventory = new BaseProcessor<>();
	    	inventory.syncToHBASE(Inventory.class,"Inventory",InventoryMap, null);
	    }
	};
	Thread thread26 = new Thread() {
	    public void run() {
	    	BaseProcessor<Lastgradecompleted> lastgradecompleted = new BaseProcessor<>();
	    	lastgradecompleted.syncToHBASE(Lastgradecompleted.class,"Lastgradecompleted",LastgradecompletedMap, null);
	    	
	    }
	};
	
	Thread thread27 = new Thread() {
	    public void run() {
	    	BaseProcessor<Lastpermanentaddress> Lastpermanentaddress = new BaseProcessor<>();
	    	Lastpermanentaddress.syncToHBASE(Lastpermanentaddress.class,"last_perm_address",last_perm_addressMap, null);
	    }
	};
	Thread thread28 = new Thread() {
	    public void run() {
	    	BaseProcessor<Medicalassistance> Medicalassistance = new BaseProcessor<>();
	    	Medicalassistance.syncToHBASE(Medicalassistance.class,"Medicalassistance",MedicalassistanceMap, null);
	    }
	};
	Thread thread29 = new Thread() {
	    public void run() {
	    	BaseProcessor<Noncashbenefits> Noncashbenefits = new BaseProcessor<>();
	    	Noncashbenefits.syncToHBASE(Noncashbenefits.class,"Noncashbenefits",NoncashbenefitsMap, null);
	    	
	    }
	};
	Thread thread30 = new Thread() {
	    public void run() {
	    	BaseProcessor<Organization> Organization = new BaseProcessor<>();
	    	Organization.syncToHBASE(Organization.class,"Organization",OrganizationMap, null);
	    }
	};
	Thread thread31 = new Thread() {
	    public void run() {
	    	BaseProcessor<Pathstatus> Pathstatus = new BaseProcessor<>();
	    	Pathstatus.syncToHBASE(Pathstatus.class,"Path_status",Path_statusMap, null);
	    }
	};
	
	Thread thread32 = new Thread() {
	    public void run() {
	    	BaseProcessor<Percentami> Percentami = new BaseProcessor<>();
	    	Percentami.syncToHBASE(Percentami.class,"Percent_ami",Percent_amiMap, null);
	    }
	};
	Thread thread33 = new Thread() {
	    public void run() {
	    	BaseProcessor<Project> Project = new BaseProcessor<>();
	    	Project.syncToHBASE(Project.class,"Project",ProjectMap, null);
	    }
	};
	Thread thread34 = new Thread() {
	    public void run() {
	    	BaseProcessor<Projectcoc> Projectcoc = new BaseProcessor<>();
	    	Projectcoc.syncToHBASE(Projectcoc.class,"Projectcoc",ProjectcocMap, null);
	    	
	    }
	};
	Thread thread35 = new Thread() {
	    public void run() {
	    	BaseProcessor<Projectcompletionstatus> Projectcompletionstatus = new BaseProcessor<>();
	    	Projectcompletionstatus.syncToHBASE(Projectcompletionstatus.class,"Projectcompletionstatus",ProjectcompletionstatusMap, null);
	    	
	    }
	};
	Thread thread36 = new Thread() {
	    public void run() {
	    	BaseProcessor<Referralsource> Referralsource = new BaseProcessor<>();
	    	Referralsource.syncToHBASE(Referralsource.class,"Referralsource",ReferralsourceMap, null);
	    	
	    }
	};
	Thread thread37 = new Thread() {
	    public void run() {
	    	BaseProcessor<Residentialmoveindate> Residentialmoveindate = new BaseProcessor<>();
	    	Residentialmoveindate.syncToHBASE(Residentialmoveindate.class,"residentialmoveindate",residentialmoveindateMap, null);
	    }
	};
	Thread thread38 = new Thread() {
	    public void run() {
	    	BaseProcessor<Rhybcpstatus> Rhybcpstatus = new BaseProcessor<>();
	    	Rhybcpstatus.syncToHBASE(Rhybcpstatus.class,"Rhybcp_status",Rhybcp_statusMap, null);
	    }
	};
	Thread thread39 = new Thread() {
	    public void run() {
	    	BaseProcessor<Schoolstatus> Schoolstatus = new BaseProcessor<>();
	    	Schoolstatus.syncToHBASE(Schoolstatus.class,"Schoolstatus",SchoolstatusMap, null);
	    }
	};
	Thread thread40 = new Thread() {
	    public void run() {
	    	BaseProcessor<Services> Services = new BaseProcessor<>();
	    	Services.syncToHBASE(Services.class,"Services",ServicesMap, null);
	    }
	};
	Thread thread41 = new Thread() {
	    public void run() {
	    	BaseProcessor<Sexualorientation> Sexualorientation = new BaseProcessor<>();
	    	Sexualorientation.syncToHBASE(Sexualorientation.class,"Sexualorientation",SexualorientationMap, null);
	    }
	};
	Thread thread42 = new Thread() {
	    public void run() {
	    	BaseProcessor<Site> Site = new BaseProcessor<>();
	    	Site.syncToHBASE(Site.class,"Site",SiteMap, null);
	    }
	};
//	BaseProcessor<Source> Source = new BaseProcessor<>();
//	Source.getResult(Source.class);
	
	Thread thread43 = new Thread() {
	    public void run() {
	    	BaseProcessor<VeteranInfo> VeteranInfo = new BaseProcessor<>();
	    	VeteranInfo.syncToHBASE(VeteranInfo.class,"Veteran_Info",Veteran_InfoMap, null);
	    }
	};
	Thread thread44 = new Thread() {
	    public void run() {
	    	BaseProcessor<Worsthousingsituation> Worsthousingsituation = new BaseProcessor<>();
	    	Worsthousingsituation.syncToHBASE(Worsthousingsituation.class,"Worsthousingsituation",WorsthousingsituationMap, null);
	    	
	    }
	};
	
	Thread thread45 = new Thread() {
	    public void run() {
	    	BaseProcessor<Youthcriticalissues> Youthcriticalissues = new BaseProcessor<>();
	    	Youthcriticalissues.syncToHBASE(Youthcriticalissues.class,"Youthcriticalissues",YouthcriticalissuesMap, null);

	    }
	};
	
	/*
	BaseProcessor<Commercialsexualexploitation> commercialsexualexploitation = new BaseProcessor<>();
	commercialsexualexploitation.syncToHBASE(Commercialsexualexploitation.class,"Commercialsexualexploitation",tableSyncList, null);
	
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
	
	
	
	/*try {
		thread1.join();
		thread2.join();
		thread3.join();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
*/
	
	baseProcessor.updateSyncEndDate(tableSyncList.toString(), syncUid); 
}
}