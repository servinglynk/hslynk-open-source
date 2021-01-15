package com.servinglynk.hive.connection;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.servinglynk.hmis.warehouse.Logging;
import com.servinglynk.hmis.warehouse.Properties;

public class CsvExporter  extends Logging {
	private BufferedWriter fileWriter;
	DateFormat  format = new SimpleDateFormat("");

	public void export(String schema, String table,String field, int reportId) throws ClassNotFoundException {

		String csvFileName = getFileName(table);

		try (Connection connection = SyncPostgresProcessor.getConnection()) {
			String sql = "SELECT * FROM ".concat(schema).concat(".").concat(table) +" where "+field+"="+reportId;

			Statement statement = connection.createStatement();
			ResultSet result = null;
			try {
				result = statement.executeQuery(sql);
			} catch(Exception e) {
				// Eat the exception
			}
			if(result != null) {
				fileWriter = new BufferedWriter(new FileWriter(schema+"/"+csvFileName));

				int columnCount = writeHeaderLine(result, table);
				boolean includeColumn = true;
				while (result.next()) {
					String line = "";

					for (int i = 1; i <= columnCount; i++) {
						ResultSetMetaData metaData = result.getMetaData();
						String column = metaData.getColumnName(i);
						Object valueObject = result.getObject(column);
						String valueString = "";
						if (valueObject != null) {
							valueString = String.valueOf(valueObject);
						}
						if(column.contains("id") && valueObject != null) {
							valueString = valueObject.toString();
							if(valueString.length() == 36) {
								valueString = valueString.substring(0, valueString.indexOf("-"));
							}
						}
						
						if(StringUtils.equals(column, "reportdate")) {
								valueString =  valueString.substring(0, valueString.length() -7);
						}
						if(StringUtils.equals(column, "project_group_code") || StringUtils.equals(column, "step")) {
							includeColumn = false;
						} else {
							valueString = valueString.replaceAll(",", "");
							line = line.concat(valueString);
						}
						

						if (i != columnCount && includeColumn) {
							line = line.concat(",");
						}
						includeColumn = true;
					}

					fileWriter.newLine();
					fileWriter.write(line);
				}

				fileWriter.close();
			}

		} catch (SQLException e) {
			System.out.println("Datababse error:");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("File IO error:");
			e.printStackTrace();
		}

	}

	private String getFileName(String tableName) {
		if(StringUtils.contains(tableName, "Organization")) {
			return "Organization.csv";
		}
		if(StringUtils.contains(tableName, "ProjectCoC")) {
			return "ProjectCoC.csv";
		}
		if(StringUtils.contains(tableName, "Project")) {
			return "Project.csv";
		}
		if(StringUtils.contains(tableName, "Funder")) {
			return "Funder.csv";
		}
		if(StringUtils.contains(tableName, "Inventory")) {
			return "Inventory.csv";
		}
		if(StringUtils.isNotBlank(tableName)) {
			tableName = tableName.replaceAll("", "");
			String[] split = tableName.split("_");
			String str = split[1]; 
			tableName = split[0].toUpperCase()+str.substring(0, 1).toUpperCase() + str.substring(1);
		}
		return tableName+".csv";
	}

	private int writeHeaderLine(ResultSet result, final String tableName) throws SQLException, IOException {
// write header line containing column names
		ResultSetMetaData metaData = result.getMetaData();
		int numberOfColumns = metaData.getColumnCount();
		String headerLine = "";
// exclude the first column which is the ID field
		for (int i = 1; i <= numberOfColumns; i++) {
				 switch(tableName) 
			        { 
			            case "lsa_Funder": 
			            	headerLine = "FunderID,ProjectID,Funder,OtherFunder,GrantID,StartDate,EndDate,DateCreated,DateUpdated,UserID,DateDeleted,ExportID";
			                break; 
			            case "lsa_Inventory": 
			            	headerLine = "InventoryID,ProjectID,CoCCode,HouseholdType,Availability,UnitInventory,BedInventory,CHVetBedInventory,YouthVetBedInventory,VetBedInventory,CHYouthBedInventory,YouthBedInventory,CHBedInventory,OtherBedInventory,ESBedType,InventoryStartDate,InventoryEndDate,DateCreated,DateUpdated,UserID,DateDeleted,ExportID";
			                break; 
			            case "lsa_Calculated": 
			            	headerLine = "Value,Cohort,Universe,HHType,Population,SystemPath,ProjectID,ReportRow,ReportID";
			            	numberOfColumns =9;
			                break; 
			            case "lsa_Exit": 
			            	headerLine = "RowTotal,Cohort,Stat,ExitFrom,ExitTo,ReturnTime,HHType,HHVet,HHDisability,HHFleeingDV,HoHRace,HoHEthnicity,HHAdultAge,HHParent,AC3Plus,SystemPath,ReportID"; 
			                break; 
			            case "lsa_Household": 
			            	headerLine = "RowTotal,Stat,ReturnTime,HHType,HHChronic,HHVet,HHDisability,HHFleeingDV,HoHRace,HoHEthnicity,HHAdult,HHChild,HHNoDOB,HHAdultAge,HHParent,ESTStatus,ESTGeography,ESTLivingSit,ESTDestination,ESTChronic,ESTVet,ESTDisability,ESTFleeingDV,ESTAC3Plus,ESTAdultAge,ESTParent,RRHStatus,RRHMoveIn,RRHGeography,RRHLivingSit,RRHDestination,RRHPreMoveInDays,RRHChronic,RRHVet,RRHDisability,RRHFleeingDV,RRHAC3Plus,RRHAdultAge,RRHParent,PSHStatus,PSHMoveIn,PSHGeography,PSHLivingSit,PSHDestination,PSHHousedDays,PSHChronic,PSHVet,PSHDisability,PSHFleeingDV,PSHAC3Plus,PSHAdultAge,PSHParent,ESDays,THDays,ESTDays,RRHPSHPreMoveInDays,RRHHousedDays,SystemDaysNotPSHHoused,SystemHomelessDays,Other3917Days,TotalHomelessDays,SystemPath,ESTAHAR,RRHAHAR,PSHAHAR,ReportID";
			                break; 
			            case "lsa_Person": 
			            	headerLine = "RowTotal,Gender,Race,Ethnicity,VetStatus,DisabilityStatus,CHTime,CHTimeStatus,DVStatus,ESTAgeMin,ESTAgeMax,HHTypeEST,HoHEST,AdultEST,HHChronicEST,HHVetEST,HHDisabilityEST,HHFleeingDVEST,HHAdultAgeAOEST,HHAdultAgeACEST,HHParentEST,AC3PlusEST,AHAREST,AHARHoHEST,RRHAgeMin,RRHAgeMax,HHTypeRRH,HoHRRH,AdultRRH,HHChronicRRH,HHVetRRH,HHDisabilityRRH,HHFleeingDVRRH,HHAdultAgeAORRH,HHAdultAgeACRRH,HHParentRRH,AC3PlusRRH,AHARRRH,AHARHoHRRH,PSHAgeMin,PSHAgeMax,HHTypePSH,HoHPSH,AdultPSH,HHChronicPSH,HHVetPSH,HHDisabilityPSH,HHFleeingDVPSH,HHAdultAgeAOPSH,HHAdultAgeACPSH,HHParentPSH,AC3PlusPSH,AHARPSH,AHARHoHPSH,ReportID";
			                break; 
			            case "lsa_Report": 
			            	headerLine = "ReportID,ReportDate,ReportStart,ReportEnd,ReportCoC,SoftwareVendor,SoftwareName,VendorContact,VendorEmail,LSAScope,UnduplicatedClient1,UnduplicatedClient3,UnduplicatedAdult1,UnduplicatedAdult3,AdultHoHEntry1,AdultHoHEntry3,ClientEntry1,ClientEntry3,ClientExit1,ClientExit3,Household1,Household3,HoHPermToPH1,HoHPermToPH3,NoCoC,SSNNotProvided,SSNMissingOrInvalid,ClientSSNNotUnique,DistinctSSNValueNotUnique,DOB1,DOB3,Gender1,Gender3,Race1,Race3,Ethnicity1,Ethnicity3,VetStatus1,VetStatus3,RelationshipToHoH1,RelationshipToHoH3,DisablingCond1,DisablingCond3,LivingSituation1,LivingSituation3,LengthOfStay1,LengthOfStay3,HomelessDate1,HomelessDate3,TimesHomeless1,TimesHomeless3,MonthsHomeless1,MonthsHomeless3,DV1,DV3,Destination1,Destination3,NotOneHoH1,NotOneHoH3,MoveInDate1,MoveInDate3"; 
			            	numberOfColumns =61;
			            	break; 
			            case "lsa_Organization": 
			            	headerLine = "OrganizationID,OrganizationName,VictimServicesProvider,OrganizationCommonName,DateCreated,DateUpdated,UserID,DateDeleted,ExportID"; 
			                break; 
			            case "lsa_Project": 
			            	headerLine = "ProjectID,OrganizationID,ProjectName,ProjectCommonName,OperatingStartDate,OperatingEndDate,ContinuumProject,ProjectType,HousingType,ResidentialAffiliation,TrackingMethod,HMISParticipatingProject,TargetPopulation,PITCount,DateCreated,DateUpdated,UserID,DateDeleted,ExportID"; 
			                break; 
			            case "lsa_ProjectCoC": 
			            	headerLine = "ProjectCoCID,ProjectID,CoCCode,Geocode,Address1,Address2,City,State,ZIP,GeographyType,DateCreated,DateUpdated,UserID,DateDeleted,ExportID"; 
			                break; 
			            default: 
			                System.out.println("no match"); 
			}
			
			
		}

		fileWriter.write(headerLine);

		return  numberOfColumns;
	}

	private String escapeDoubleQuotes(String value) {
		return value.replaceAll("", "");
	}

	public static void main(String[] args) throws Exception {
		Properties props = new Properties();
		props.generatePropValues();
		CsvExporter exporter = new CsvExporter();
		Map<String,String> csvs = new HashMap<>();
		csvs.put("lsa_Calculated","ReportID");
		csvs.put("lsa_Exit","ReportID");
		csvs.put("lsa_Funder","ExportID");
		csvs.put("lsa_Inventory","ExportID");
		csvs.put("lsa_Organization","ExportID");
		csvs.put("lsa_Project","ExportID");
		csvs.put("lsa_ProjectCoC","ExportID");
		csvs.put("lsa_Person","ReportID");
		csvs.put("lsa_Report","ReportID");
		csvs.put("lsa_Household","ReportID");
		for (Map.Entry<String,String> entry : csvs.entrySet())   {
			exporter.export("lsa",entry.getKey(),entry.getValue(),12345);
		}
	}
}