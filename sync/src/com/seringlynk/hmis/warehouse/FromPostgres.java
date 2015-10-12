package com.seringlynk.hmis.warehouse;

import java.util.Date;
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
	//java.sql.Date lastSyncDate = baseProcessor.getLastSyncDate(); 
//	if (lastSyncDate != null) {
	//UUID syncID =	baseProcessor.insertSyncStartDate(); 		
	// For now I want it to sync everything.
	java.sql.Date lastSyncDate = null;
	//End
	java.util.Map<String, Integer> tableSyncList = new HashMap<>();
	// 
	BaseProcessor<Affiliation> aff = new BaseProcessor<>();
	aff.syncToHBASE(Affiliation.class,"Affiliation",tableSyncList, lastSyncDate);
	
	BaseProcessor<Client> db = new BaseProcessor<>();
	db.syncToHBASE(Client.class,"Client",tableSyncList, lastSyncDate);
	
	BaseProcessor<Bedinventory> bedInventory = new BaseProcessor<>();
	bedInventory.syncToHBASE(Bedinventory.class,"Bedinventory",tableSyncList, lastSyncDate);
	
	BaseProcessor<Commercialsexualexploitation> commercialsexualexploitation = new BaseProcessor<>();
	commercialsexualexploitation.syncToHBASE(Commercialsexualexploitation.class,"Commercialsexualexploitation",tableSyncList, lastSyncDate);
	
	BaseProcessor<Connectionwithsoar> connectionwithsoar = new BaseProcessor<>();
	connectionwithsoar.syncToHBASE(Connectionwithsoar.class,"Connectionwithsoar",tableSyncList, lastSyncDate);
	
	BaseProcessor<Dateofengagement> dateofengagement = new BaseProcessor<>();
	dateofengagement.syncToHBASE(Dateofengagement.class,"Dateofengagement",tableSyncList, lastSyncDate);
	
	BaseProcessor<Disabilities> disabilities = new BaseProcessor<>();
	disabilities.syncToHBASE(Disabilities.class,"Disabilities",tableSyncList, lastSyncDate);
	
	BaseProcessor<Domesticviolence> domesticviolence = new BaseProcessor<>();
	domesticviolence.syncToHBASE(Domesticviolence.class,"Domesticviolence",tableSyncList, lastSyncDate);
	
	BaseProcessor<Employment> employment = new BaseProcessor<>();
	employment.syncToHBASE(Employment.class,"Employment",tableSyncList, lastSyncDate);
	
	BaseProcessor<Enrollment> enrollment = new BaseProcessor<>();
	enrollment.syncToHBASE(Enrollment.class,"Enrollment",tableSyncList, lastSyncDate);
	
	BaseProcessor<EnrollmentCoc> enrollmentCoc = new BaseProcessor<>();
	enrollmentCoc.syncToHBASE(EnrollmentCoc.class,"Enrollment_coc",tableSyncList, lastSyncDate);
	
	BaseProcessor<Exit> exit = new BaseProcessor<>();
	exit.syncToHBASE(Exit.class,"Exit",tableSyncList, lastSyncDate);

	BaseProcessor<Exithousingassessment> exithousingassessment = new BaseProcessor<>();
	exithousingassessment.syncToHBASE(Exithousingassessment.class,"Exithousingassessment",tableSyncList, lastSyncDate);
	
	BaseProcessor<Exitplansactions> exitplansactions = new BaseProcessor<>();
	exitplansactions.syncToHBASE(Exitplansactions.class,"Exitplansactions",tableSyncList, lastSyncDate);
	
	BaseProcessor<Export> export = new BaseProcessor<>();
	export.syncToHBASE(Export.class,"Export",tableSyncList, lastSyncDate);
	
	BaseProcessor<Familyreunification> familyreunification = new BaseProcessor<>();
	familyreunification.syncToHBASE(Familyreunification.class,"Familyreunification",tableSyncList, lastSyncDate);
	
	BaseProcessor<Formerwardchildwelfare> formerwardchildwelfare = new BaseProcessor<>();
	formerwardchildwelfare.syncToHBASE(Formerwardchildwelfare.class,"Formerwardchildwelfare",tableSyncList, lastSyncDate);
	
	BaseProcessor<Formerwardjuvenilejustice> formerwardjuvenilejustice = new BaseProcessor<>();
	formerwardjuvenilejustice.syncToHBASE(Formerwardjuvenilejustice.class,"Formerwardjuvenilejustice",tableSyncList, lastSyncDate);
	
	BaseProcessor<Funder> funder = new BaseProcessor<>();
	funder.syncToHBASE(Funder.class,"Funder",tableSyncList, lastSyncDate);
	
	BaseProcessor<HealthStatus> healthStatus = new BaseProcessor<>();
	healthStatus.syncToHBASE(HealthStatus.class,"Health_Status",tableSyncList, lastSyncDate);

	BaseProcessor<Housingassessmentdisposition> housingassessmentdisposition = new BaseProcessor<>();
	housingassessmentdisposition.syncToHBASE(Housingassessmentdisposition.class,"Housingassessmentdisposition",tableSyncList, lastSyncDate);
	
	BaseProcessor<Incomeandsources> incomeandsources = new BaseProcessor<>();
	incomeandsources.syncToHBASE(Incomeandsources.class,"Incomeandsources",tableSyncList, lastSyncDate);
	
	BaseProcessor<Inventory> inventory = new BaseProcessor<>();
	inventory.syncToHBASE(Inventory.class,"Inventory",tableSyncList, lastSyncDate);
	
	BaseProcessor<Lastgradecompleted> lastgradecompleted = new BaseProcessor<>();
	lastgradecompleted.syncToHBASE(Lastgradecompleted.class,"Lastgradecompleted",tableSyncList, lastSyncDate);
	
	BaseProcessor<Lastpermanentaddress> Lastpermanentaddress = new BaseProcessor<>();
	Lastpermanentaddress.syncToHBASE(Lastpermanentaddress.class,"Lastpermanentaddress",tableSyncList, lastSyncDate);
	
	BaseProcessor<Medicalassistance> Medicalassistance = new BaseProcessor<>();
	Medicalassistance.syncToHBASE(Medicalassistance.class,"Medicalassistance",tableSyncList, lastSyncDate);
	
	BaseProcessor<Noncashbenefits> Noncashbenefits = new BaseProcessor<>();
	Noncashbenefits.syncToHBASE(Noncashbenefits.class,"Noncashbenefits",tableSyncList, lastSyncDate);
	
	BaseProcessor<Organization> Organization = new BaseProcessor<>();
	Organization.syncToHBASE(Organization.class,"Organization",tableSyncList, lastSyncDate);
	
	BaseProcessor<Pathstatus> Pathstatus = new BaseProcessor<>();
	Pathstatus.syncToHBASE(Pathstatus.class,"Path_status",tableSyncList, lastSyncDate);
	
	BaseProcessor<Percentami> Percentami = new BaseProcessor<>();
	Percentami.syncToHBASE(Percentami.class,"Percent_ami",tableSyncList, lastSyncDate);
	
	BaseProcessor<Project> Project = new BaseProcessor<>();
	Project.syncToHBASE(Project.class,"Project",tableSyncList, lastSyncDate);
	
	BaseProcessor<Projectcoc> Projectcoc = new BaseProcessor<>();
	Projectcoc.syncToHBASE(Projectcoc.class,"Projectcoc",tableSyncList, lastSyncDate);
	
	BaseProcessor<Projectcompletionstatus> Projectcompletionstatus = new BaseProcessor<>();
	Projectcompletionstatus.syncToHBASE(Projectcompletionstatus.class,"Projectcompletionstatus",tableSyncList, lastSyncDate);
	
	BaseProcessor<Referralsource> Referralsource = new BaseProcessor<>();
	Referralsource.syncToHBASE(Referralsource.class,"Referralsource",tableSyncList, lastSyncDate);
	
	BaseProcessor<Residentialmoveindate> Residentialmoveindate = new BaseProcessor<>();
	Residentialmoveindate.syncToHBASE(Residentialmoveindate.class,"residentialmoveindate",tableSyncList, lastSyncDate);
	
	BaseProcessor<Rhybcpstatus> Rhybcpstatus = new BaseProcessor<>();
	Rhybcpstatus.syncToHBASE(Rhybcpstatus.class,"Rhybcp_status",tableSyncList, lastSyncDate);
	
	BaseProcessor<Schoolstatus> Schoolstatus = new BaseProcessor<>();
	Schoolstatus.syncToHBASE(Schoolstatus.class,"Schoolstatus",tableSyncList, lastSyncDate);
	
	BaseProcessor<Services> Services = new BaseProcessor<>();
	Services.syncToHBASE(Services.class,"Services",tableSyncList, lastSyncDate);
	
	BaseProcessor<Sexualorientation> Sexualorientation = new BaseProcessor<>();
	Sexualorientation.syncToHBASE(Sexualorientation.class,"Sexualorientation",tableSyncList, lastSyncDate);
	
	BaseProcessor<Site> Site = new BaseProcessor<>();
	Site.syncToHBASE(Site.class,"Site",tableSyncList, lastSyncDate);
	
//	BaseProcessor<Source> Source = new BaseProcessor<>();
//	Source.getResult(Source.class);
//	
	BaseProcessor<VeteranInfo> VeteranInfo = new BaseProcessor<>();
	VeteranInfo.syncToHBASE(VeteranInfo.class,"Veteran_Info",tableSyncList, lastSyncDate);
	
	BaseProcessor<Worsthousingsituation> Worsthousingsituation = new BaseProcessor<>();
	Worsthousingsituation.syncToHBASE(Worsthousingsituation.class,"Worsthousingsituation",tableSyncList, lastSyncDate);
	
	BaseProcessor<Youthcriticalissues> Youthcriticalissues = new BaseProcessor<>();
	Youthcriticalissues.syncToHBASE(Youthcriticalissues.class,"Youthcriticalissues",tableSyncList, lastSyncDate);
	
	System.out.println("Tables::"+tableSyncList.toString());

	//baseProcessor.updateSyncEndDate(tableSyncList.toString(), syncID); 
 }
	
}
