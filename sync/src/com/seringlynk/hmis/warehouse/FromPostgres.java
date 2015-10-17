package com.seringlynk.hmis.warehouse;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.model.Affiliation;
import com.servinglynk.hmis.warehouse.model.Bedinventory;
import com.servinglynk.hmis.warehouse.model.Client;
import com.servinglynk.hmis.warehouse.model.Commercialsexualexploitation;
import com.servinglynk.hmis.warehouse.model.Connectionwithsoar;
import com.servinglynk.hmis.warehouse.model.Dateofengagement;
import com.servinglynk.hmis.warehouse.model.Disabilities;
import com.servinglynk.hmis.warehouse.model.Domesticviolence;
import com.servinglynk.hmis.warehouse.model.Employment;
import com.servinglynk.hmis.warehouse.model.Enrollment;
import com.servinglynk.hmis.warehouse.model.EnrollmentCoc;
import com.servinglynk.hmis.warehouse.model.Exit;
import com.servinglynk.hmis.warehouse.model.Exithousingassessment;
import com.servinglynk.hmis.warehouse.model.Exitplansactions;
import com.servinglynk.hmis.warehouse.model.Export;
import com.servinglynk.hmis.warehouse.model.Familyreunification;
import com.servinglynk.hmis.warehouse.model.Formerwardchildwelfare;
import com.servinglynk.hmis.warehouse.model.Formerwardjuvenilejustice;
import com.servinglynk.hmis.warehouse.model.Funder;
import com.servinglynk.hmis.warehouse.model.HealthStatus;
import com.servinglynk.hmis.warehouse.model.Housingassessmentdisposition;
import com.servinglynk.hmis.warehouse.model.Incomeandsources;
import com.servinglynk.hmis.warehouse.model.Inventory;
import com.servinglynk.hmis.warehouse.model.Lastgradecompleted;
import com.servinglynk.hmis.warehouse.model.Lastpermanentaddress;
import com.servinglynk.hmis.warehouse.model.Medicalassistance;
import com.servinglynk.hmis.warehouse.model.Noncashbenefits;
import com.servinglynk.hmis.warehouse.model.Organization;
import com.servinglynk.hmis.warehouse.model.Pathstatus;
import com.servinglynk.hmis.warehouse.model.Percentami;
import com.servinglynk.hmis.warehouse.model.Project;
import com.servinglynk.hmis.warehouse.model.Projectcoc;
import com.servinglynk.hmis.warehouse.model.Projectcompletionstatus;
import com.servinglynk.hmis.warehouse.model.Referralsource;
import com.servinglynk.hmis.warehouse.model.Residentialmoveindate;
import com.servinglynk.hmis.warehouse.model.Rhybcpstatus;
import com.servinglynk.hmis.warehouse.model.Schoolstatus;
import com.servinglynk.hmis.warehouse.model.Services;
import com.servinglynk.hmis.warehouse.model.Sexualorientation;
import com.servinglynk.hmis.warehouse.model.Site;
import com.servinglynk.hmis.warehouse.model.VeteranInfo;
import com.servinglynk.hmis.warehouse.model.Worsthousingsituation;
import com.servinglynk.hmis.warehouse.model.Youthcriticalissues;

public class FromPostgres {

	public static void main(String args[]) {
		
	//	syncClient(date,Client.class);
	System.out.println("-------- PostgreSQL "
			+ "JDBC Connection Testing ------------");
	
	// Sync Table Start
	BaseProcessor baseProcessor = new BaseProcessor();
	// Lets use timestamp instead of date.
	Timestamp lastSyncTime = baseProcessor.getLastSyncTime();
	UUID syncUid = baseProcessor.insertSyncStartTime();		
	
	System.out.println(lastSyncTime);
	java.util.Map<String, Integer> tableSyncList = new HashMap<>();

	BaseProcessor<Affiliation> aff = new BaseProcessor<>();
	aff.syncToHBASE(Affiliation.class,"affiliation",tableSyncList, lastSyncTime);
	
	BaseProcessor<Client> db = new BaseProcessor<>();
	db.syncToHBASE(Client.class,"Client",tableSyncList, lastSyncTime);
	
	BaseProcessor<Bedinventory> bedInventory = new BaseProcessor<>();
	bedInventory.syncToHBASE(Bedinventory.class,"Bedinventory",tableSyncList, lastSyncTime);
	
	BaseProcessor<Commercialsexualexploitation> commercialsexualexploitation = new BaseProcessor<>();
	commercialsexualexploitation.syncToHBASE(Commercialsexualexploitation.class,"Commercialsexualexploitation",tableSyncList, lastSyncTime);
	
	BaseProcessor<Connectionwithsoar> connectionwithsoar = new BaseProcessor<>();
	connectionwithsoar.syncToHBASE(Connectionwithsoar.class,"Connectionwithsoar",tableSyncList, lastSyncTime);
	
	BaseProcessor<Dateofengagement> dateofengagement = new BaseProcessor<>();
	dateofengagement.syncToHBASE(Dateofengagement.class,"Dateofengagement",tableSyncList, lastSyncTime);
	
	BaseProcessor<Disabilities> disabilities = new BaseProcessor<>();
	disabilities.syncToHBASE(Disabilities.class,"Disabilities",tableSyncList, lastSyncTime);
	
	BaseProcessor<Domesticviolence> domesticviolence = new BaseProcessor<>();
	domesticviolence.syncToHBASE(Domesticviolence.class,"Domesticviolence",tableSyncList, lastSyncTime);
	
	BaseProcessor<Employment> employment = new BaseProcessor<>();
	employment.syncToHBASE(Employment.class,"Employment",tableSyncList, lastSyncTime);
	
	BaseProcessor<Enrollment> enrollment = new BaseProcessor<>();
	enrollment.syncToHBASE(Enrollment.class,"Enrollment",tableSyncList, lastSyncTime);
	
	BaseProcessor<EnrollmentCoc> enrollmentCoc = new BaseProcessor<>();
	enrollmentCoc.syncToHBASE(EnrollmentCoc.class,"Enrollment_coc",tableSyncList, lastSyncTime);
	
	BaseProcessor<Exit> exit = new BaseProcessor<>();
	exit.syncToHBASE(Exit.class,"Exit",tableSyncList, lastSyncTime);

	BaseProcessor<Exithousingassessment> exithousingassessment = new BaseProcessor<>();
	exithousingassessment.syncToHBASE(Exithousingassessment.class,"Exithousingassessment",tableSyncList, lastSyncTime);
	
	BaseProcessor<Exitplansactions> exitplansactions = new BaseProcessor<>();
	exitplansactions.syncToHBASE(Exitplansactions.class,"Exitplansactions",tableSyncList, lastSyncTime);
	
	BaseProcessor<Export> export = new BaseProcessor<>();
	export.syncToHBASE(Export.class,"Export",tableSyncList, lastSyncTime);
	
	BaseProcessor<Familyreunification> familyreunification = new BaseProcessor<>();
	familyreunification.syncToHBASE(Familyreunification.class,"familyreunification",tableSyncList, lastSyncTime);
	
	BaseProcessor<Formerwardchildwelfare> formerwardchildwelfare = new BaseProcessor<>();
	formerwardchildwelfare.syncToHBASE(Formerwardchildwelfare.class,"Formerwardchildwelfare",tableSyncList, lastSyncTime);
	
	BaseProcessor<Formerwardjuvenilejustice> formerwardjuvenilejustice = new BaseProcessor<>();
	formerwardjuvenilejustice.syncToHBASE(Formerwardjuvenilejustice.class,"Formerwardjuvenilejustice",tableSyncList, lastSyncTime);
	
	BaseProcessor<Funder> funder = new BaseProcessor<>();
	funder.syncToHBASE(Funder.class,"Funder",tableSyncList, lastSyncTime);
	
	BaseProcessor<HealthStatus> healthStatus = new BaseProcessor<>();
	healthStatus.syncToHBASE(HealthStatus.class,"Health_Status",tableSyncList, lastSyncTime);

	BaseProcessor<Housingassessmentdisposition> housingassessmentdisposition = new BaseProcessor<>();
	housingassessmentdisposition.syncToHBASE(Housingassessmentdisposition.class,"Housingassessmentdisposition",tableSyncList, lastSyncTime);
	
	BaseProcessor<Incomeandsources> incomeandsources = new BaseProcessor<>();
	incomeandsources.syncToHBASE(Incomeandsources.class,"Incomeandsources",tableSyncList, lastSyncTime);
	
	BaseProcessor<Inventory> inventory = new BaseProcessor<>();
	inventory.syncToHBASE(Inventory.class,"Inventory",tableSyncList, lastSyncTime);
	
	BaseProcessor<Lastgradecompleted> lastgradecompleted = new BaseProcessor<>();
	lastgradecompleted.syncToHBASE(Lastgradecompleted.class,"Lastgradecompleted",tableSyncList, lastSyncTime);
	
	BaseProcessor<Lastpermanentaddress> Lastpermanentaddress = new BaseProcessor<>();
	Lastpermanentaddress.syncToHBASE(Lastpermanentaddress.class,"last_perm_address",tableSyncList, lastSyncTime);
	
	BaseProcessor<Medicalassistance> Medicalassistance = new BaseProcessor<>();
	Medicalassistance.syncToHBASE(Medicalassistance.class,"Medicalassistance",tableSyncList, lastSyncTime);
	
	BaseProcessor<Noncashbenefits> Noncashbenefits = new BaseProcessor<>();
	Noncashbenefits.syncToHBASE(Noncashbenefits.class,"Noncashbenefits",tableSyncList, lastSyncTime);
	
	BaseProcessor<Organization> Organization = new BaseProcessor<>();
	Organization.syncToHBASE(Organization.class,"Organization",tableSyncList, lastSyncTime);
	
	BaseProcessor<Pathstatus> Pathstatus = new BaseProcessor<>();
	Pathstatus.syncToHBASE(Pathstatus.class,"Path_status",tableSyncList, lastSyncTime);
	
	BaseProcessor<Percentami> Percentami = new BaseProcessor<>();
	Percentami.syncToHBASE(Percentami.class,"Percent_ami",tableSyncList, lastSyncTime);
	
	BaseProcessor<Project> Project = new BaseProcessor<>();
	Project.syncToHBASE(Project.class,"Project",tableSyncList, lastSyncTime);
	
	BaseProcessor<Projectcoc> Projectcoc = new BaseProcessor<>();
	Projectcoc.syncToHBASE(Projectcoc.class,"Projectcoc",tableSyncList, lastSyncTime);
	
	BaseProcessor<Projectcompletionstatus> Projectcompletionstatus = new BaseProcessor<>();
	Projectcompletionstatus.syncToHBASE(Projectcompletionstatus.class,"Projectcompletionstatus",tableSyncList, lastSyncTime);
	
	BaseProcessor<Referralsource> Referralsource = new BaseProcessor<>();
	Referralsource.syncToHBASE(Referralsource.class,"Referralsource",tableSyncList, lastSyncTime);
	
	BaseProcessor<Residentialmoveindate> Residentialmoveindate = new BaseProcessor<>();
	Residentialmoveindate.syncToHBASE(Residentialmoveindate.class,"residentialmoveindate",tableSyncList, lastSyncTime);
	
	BaseProcessor<Rhybcpstatus> Rhybcpstatus = new BaseProcessor<>();
	Rhybcpstatus.syncToHBASE(Rhybcpstatus.class,"Rhybcp_status",tableSyncList, lastSyncTime);
	
	BaseProcessor<Schoolstatus> Schoolstatus = new BaseProcessor<>();
	Schoolstatus.syncToHBASE(Schoolstatus.class,"Schoolstatus",tableSyncList, lastSyncTime);
	
	BaseProcessor<Services> Services = new BaseProcessor<>();
	Services.syncToHBASE(Services.class,"Services",tableSyncList, lastSyncTime);
	
	BaseProcessor<Sexualorientation> Sexualorientation = new BaseProcessor<>();
	Sexualorientation.syncToHBASE(Sexualorientation.class,"Sexualorientation",tableSyncList, lastSyncTime);
	
	BaseProcessor<Site> Site = new BaseProcessor<>();
	Site.syncToHBASE(Site.class,"Site",tableSyncList, lastSyncTime);
	
//	BaseProcessor<Source> Source = new BaseProcessor<>();
//	Source.getResult(Source.class);
//	
	BaseProcessor<VeteranInfo> VeteranInfo = new BaseProcessor<>();
	VeteranInfo.syncToHBASE(VeteranInfo.class,"Veteran_Info",tableSyncList, lastSyncTime);
	
	BaseProcessor<Worsthousingsituation> Worsthousingsituation = new BaseProcessor<>();
	Worsthousingsituation.syncToHBASE(Worsthousingsituation.class,"Worsthousingsituation",tableSyncList, lastSyncTime);
	
	BaseProcessor<Youthcriticalissues> Youthcriticalissues = new BaseProcessor<>();
	Youthcriticalissues.syncToHBASE(Youthcriticalissues.class,"Youthcriticalissues",tableSyncList, lastSyncTime);
	
	System.out.println("Tables::"+tableSyncList.toString());

	baseProcessor.updateSyncEndDate(tableSyncList.toString(), syncUid); 
 }
	
}
