package com.seringlynk.hmis.warehouse;

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

public class FromPostgres {

	public static void main(String args[]) {
		
	//	syncClient(date,Client.class);
	System.out.println("-------- PostgreSQL "
			+ "JDBC Connection Testing ------------");
	// 
	BaseProcessor<Affiliation> aff = new BaseProcessor<>();
	aff.getResult(Affiliation.class);
	
	BaseProcessor<Client> db = new BaseProcessor<>();
	db.getResult(Client.class);
	
	BaseProcessor<Bedinventory> bedInventory = new BaseProcessor<>();
	bedInventory.getResult(Bedinventory.class);
	
	BaseProcessor<Commercialsexualexploitation> commercialsexualexploitation = new BaseProcessor<>();
	commercialsexualexploitation.getResult(Commercialsexualexploitation.class);
	
	BaseProcessor<Connectionwithsoar> connectionwithsoar = new BaseProcessor<>();
	connectionwithsoar.getResult(Connectionwithsoar.class);
	
	BaseProcessor<Dateofengagement> dateofengagement = new BaseProcessor<>();
	dateofengagement.getResult(Dateofengagement.class);
	
	BaseProcessor<Disabilities> disabilities = new BaseProcessor<>();
	disabilities.getResult(Disabilities.class);
	
	BaseProcessor<Domesticviolence> domesticviolence = new BaseProcessor<>();
	domesticviolence.getResult(Domesticviolence.class);
	
	BaseProcessor<Employment> employment = new BaseProcessor<>();
	employment.getResult(Employment.class);
	
	BaseProcessor<Enrollment> enrollment = new BaseProcessor<>();
	enrollment.getResult(Enrollment.class);
	
	BaseProcessor<EnrollmentCoc> enrollmentCoc = new BaseProcessor<>();
	enrollmentCoc.getResult(EnrollmentCoc.class);
	
	BaseProcessor<Exit> exit = new BaseProcessor<>();
	exit.getResult(Exit.class);

	BaseProcessor<Exithousingassessment> exithousingassessment = new BaseProcessor<>();
	exithousingassessment.getResult(Exithousingassessment.class);
	
	BaseProcessor<Exitplansactions> exitplansactions = new BaseProcessor<>();
	exitplansactions.getResult(Exitplansactions.class);
	
	BaseProcessor<Export> export = new BaseProcessor<>();
	export.getResult(Export.class);
	
	BaseProcessor<Familyreunification> familyreunification = new BaseProcessor<>();
	familyreunification.getResult(Familyreunification.class);
	
	BaseProcessor<Formerwardchildwelfare> formerwardchildwelfare = new BaseProcessor<>();
	formerwardchildwelfare.getResult(Formerwardchildwelfare.class);
	
	BaseProcessor<Formerwardjuvenilejustice> formerwardjuvenilejustice = new BaseProcessor<>();
	formerwardjuvenilejustice.getResult(Formerwardjuvenilejustice.class);
	
	BaseProcessor<Funder> funder = new BaseProcessor<>();
	funder.getResult(Funder.class);
	
	BaseProcessor<HealthStatus> healthStatus = new BaseProcessor<>();
	healthStatus.getResult(HealthStatus.class);

	BaseProcessor<Housingassessmentdisposition> housingassessmentdisposition = new BaseProcessor<>();
	housingassessmentdisposition.getResult(Housingassessmentdisposition.class);
	
	BaseProcessor<Incomeandsources> incomeandsources = new BaseProcessor<>();
	incomeandsources.getResult(Incomeandsources.class);
	
	BaseProcessor<Inventory> inventory = new BaseProcessor<>();
	inventory.getResult(Inventory.class);
	
 }
	
}
