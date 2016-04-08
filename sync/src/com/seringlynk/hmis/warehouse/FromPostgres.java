package com.seringlynk.hmis.warehouse;

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
import com.servinglynk.hmis.warehouse.model.v2014.Pathstatus;
import com.servinglynk.hmis.warehouse.model.v2014.Percentami;
import com.servinglynk.hmis.warehouse.model.v2014.Project;
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
