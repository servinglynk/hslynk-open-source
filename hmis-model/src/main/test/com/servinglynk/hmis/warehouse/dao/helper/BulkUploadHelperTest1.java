package com.servinglynk.hmis.warehouse.dao.helper;

import java.net.URL;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.servinglynk.hmis.warehouse.domain.Sources;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Client;
import com.servinglynk.hmis.warehouse.model.live.BulkUpload;

public class BulkUploadHelperTest1 {

	public BulkUploadHelper helper = new BulkUploadHelper();
	
	@Before
	public void setUp() {
		
	}
	
	@Test
	public void testCVSUpload() {
		URL path = BulkUploadHelper.class.getResource("CSV_files.zip");
		BulkUpload upload = new BulkUpload();
		upload.setInputPath(path.getPath());
		Sources sources = helper.getSourcesFromFiles(upload);
		assertNotNull(sources);
		List<Client> clients = sources.getSource().getExport().getClient();
		assertNotNull(clients);
		assertEquals(clients.size(), 16);
		Client client = clients.get(0);
		/*PersonalID	FirstName	MiddleName	LastName	NameSuffix	NameDataQuality	SSN	SSNDataQuality	DOB	DOBDataQuality	AmIndAKNative	Asian	BlackAfAmerican	NativeHIOtherPacific	White	RaceNone	Ethnicity	Gender	OtherGender	VeteranStatus	YearEnteredService	YearSeparated	WorldWarII	KoreanWar	VietnamWar	DesertStorm	AfghanistanOEF	IraqOIF	IraqOND	OtherTheater	MilitaryBranch	DischargeStatus	DateCreated	DateUpdated	UserID	DateDeleted	ExportID
					135	Ignatz	Ignateous	Icecream								1	654585241	1	1/1/1981	1	0	0	1	0	0		0	1		0			99	99	99	99	99	99	99	99	99	99	6/25/2015 11:28	6/25/2015 0:00	McComas, Mark		7E4D12A248584E92B0E2235B363AB0A6
*/
		assertEquals(client.getFirstName(), "Ignatz");
		assertEquals(client.getMiddleName(), "Ignateous");
		assertEquals(client.getLastName(), "Icecream");
		assertEquals(client.getNameDataQuality(), helper.getByte("1"));
		assertEquals(client.getSSN(), "654585241");
		assertEquals(client.getSSNDataQuality(), helper.getByte("1"));
		assertEquals(client.getDOB(), helper.getXMLGregorianCalendar("1981-01-01"));
		assertEquals(client.getDOBDataQuality(), helper.getByte("1"));
		assertEquals(16, clients.size());
		
	}
	@Test
	public void testXMLUpload() {
		URL path = BulkUploadHelper.class.getResource("New_HUD_Boman.xml");
		BulkUpload upload = new BulkUpload();
		upload.setInputPath(path.getFile());
		Sources sources = helper.getSourcesFromFiles(upload);
		assertNotNull(sources);
	}
}
