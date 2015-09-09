package com.servinglynk.hmis.warehouse.enums;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class EnumTypeGenerator {

	List<String> list = new ArrayList<>();
	
	public EnumTypeGenerator() {
		// TODO Auto-generated constructor stub
		list.add("EnrollmentResidencepriorlengthofstayEnum");
		list.add("EnrollmentStatusdocumentedEnum");
		list.add("EnrollmentTimeshomelesspastthreeyearsEnum");
		list.add("ExitDestinationEnum");
		list.add("ExithousingassessmentHousingassessmentEnum");
		list.add("ExithousingassessmentSubsidyinformationEnum");
		list.add("ExitplansactionsAssistancemainstreambenefitsEnum");
		list.add("ExitplansactionsExitcounselingEnum");
		list.add("ExitplansactionsFurtherfollowupservicesEnum");
		list.add("ExitplansactionsOtheraftercareplanoractionEnum");
		list.add("ExitplansactionsPermanenthousingplacementEnum");
		list.add("ExitplansactionsResourcepackageEnum");
		list.add("ExitplansactionsScheduledfollowupcontactsEnum");
		list.add("ExitplansactionsTemporaryshelterplacementEnum");
		list.add("ExitplansactionsWrittenaftercareplanEnum");
		list.add("FamilyreunificationFamilyreunificationachievedEnum");
		list.add("FormerwardchildwelfareChildwelfareyearsEnum");
		list.add("FormerwardchildwelfareFormerwardchildwelfareEnum");
		list.add("FormerwardjuvenilejusticeFormerwardjuvenilejusticeEnum");
		list.add("FormerwardjuvenilejusticeJuvenilejusticeyearsEnum");
		list.add("FunderFunderEnum");
		list.add("HealthinsuranceInsurancefromanysourceEnum");
		list.add("HealthinsuranceMedicaidEnum");
		list.add("HealthinsuranceMedicareEnum");
		list.add("HealthinsuranceNocobrareasonEnum");
		list.add("HealthinsuranceNoemployerprovidedreasonEnum");
		list.add("HealthinsuranceNomedicaidreasonEnum");
		list.add("HealthinsuranceNomedicarereasonEnum");
		list.add("HealthinsuranceNoprivatepayreasonEnum");
		list.add("HealthinsuranceNoschipreasonEnum");
		list.add("HealthinsuranceNostatehealthinsreasonEnum");
		list.add("HealthinsuranceNovamedreasonEnum");
		list.add("HealthinsurancePrivatepayEnum");
		list.add("HealthinsuranceSchipEnum");
		list.add("HealthinsuranceStatehealthinsEnum");
		list.add("HealthinsuranceVamedicalservicesEnum");
		list.add("HealthStatusHealthCategoryEnum");
		list.add("HealthStatusHealthStatusEnum");
		list.add("HmisUserGenderEnum");
		list.add("HmisUserOrganizationEnum");
		list.add("HousingassessmentdispositionAssessmentdispositionEnum");
		list.add("IncomeandsourcesAlimonyEnum");
		list.add("IncomeandsourcesChildsupportEnum");
		list.add("IncomeandsourcesEarnedEnum");
		list.add("IncomeandsourcesGaEnum");
		list.add("IncomeandsourcesIncomefromanysourceEnum");
		list.add("IncomeandsourcesOthersourceEnum");
		list.add("IncomeandsourcesPensionEnum");
		list.add("IncomeandsourcesPrivatedisabilityEnum");
		list.add("IncomeandsourcesSocsecretirementEnum");
		list.add("IncomeandsourcesSsdiEnum");
		list.add("IncomeandsourcesSsiEnum");
		list.add("IncomeandsourcesTanfEnum");
		list.add("IncomeandsourcesUnemploymentEnum");
		list.add("IncomeandsourcesVadisabilitynonserviceEnum");
		list.add("IncomeandsourcesVadisabilityserviceEnum");
		list.add("IncomeandsourcesWorkerscompEnum");
		list.add("InventoryAvailabiltyEnum");
		list.add("InventoryBedtypeEnum");
		list.add("InventoryHouseholdtypeEnum");
		list.add("LastgradecompletedLastgradecompletedEnum");
		list.add("LastPermAddressAddressDataQualityEnum");
		list.add("MedicalassistanceAdapEnum");
		list.add("MedicalassistanceHivaidsassistanceEnum");
		list.add("MedicalassistanceNoadapreasonEnum");
		list.add("MedicalassistanceNohivaidsassistancereasonEnum");
		list.add("NoncashbenefitsBenefitsfromanysourceEnum");
		list.add("NoncashbenefitsOthersourceEnum");
		list.add("NoncashbenefitsOthertanfEnum");
		list.add("NoncashbenefitsRentalassistanceongoingEnum");
		list.add("NoncashbenefitsRentalassistancetempEnum");
		list.add("NoncashbenefitsSnapEnum");
		list.add("NoncashbenefitsTanfchildcareEnum");
		list.add("NoncashbenefitsTanftransportationEnum");
		list.add("NoncashbenefitsWicEnum");
		list.add("OrganizationEnumTypeType.java");
		list.add("PathstatusClientenrolledinpathEnum");
		list.add("PathstatusReasonnotenrolledEnum");
		list.add("ProjectcompletionstatusEarlyexitreasonEnum");
		list.add("ProjectcompletionstatusProjectcompletionstatusEnum");
		list.add("ProjectContinuumprojectEnum");
		list.add("ProjectProjecttypeEnum");
		list.add("ProjectResidentialaffiliationEnum");
		list.add("ProjectTargetpopulationEnum");
		list.add("ProjectTrackingmethodEnum");
		list.add("ReferralsourceReferralsourceEnum");
		list.add("ResidentialmoveindateInpermanenthousingEnum");
		list.add("RhybcpStatusFysbYouthEnum");
		list.add("RhybcpStatusReasonNoServicesEnum");
		list.add("ServicesRecordtypeEnum");
		list.add("ServicesReferraloutcomeEnum");
		list.add("SexualorientationSexualorientationEnum");
		list.add("SitePrincipalSiteEnum");
		list.add("VeteranInfoAfghanistanOefEnum");
		list.add("VeteranInfoDesertStormEnum");
		list.add("VeteranInfoDischargeStatusEnum");
		list.add("VeteranInfoIraqOifEnum");
		list.add("VeteranInfoIraqOndEnum");
		list.add("VeteranInfoKoreanWarEnum");
		list.add("VeteranInfoMilitaryBranchEnum");
		list.add("VeteranInfoOtherTheaterEnum");
		list.add("VeteranInfoVietnamWarEnum");
		list.add("VeteranInfoWorldWar2Enum");
		list.add("WorsthousingsituationWorsthousingsituationEnum");
		list.add("YouthcriticalissuesAbuseandneglectfamEnum");
		list.add("YouthcriticalissuesAbuseandneglectyouthEnum");
		list.add("YouthcriticalissuesActivemilitaryparentEnum");
		list.add("YouthcriticalissuesAlcoholdrugabusefamEnum");
		list.add("YouthcriticalissuesAlcoholdrugabuseyouthEnum");
		list.add("YouthcriticalissuesHealthissuesfamEnum");
		list.add("YouthcriticalissuesHealthissuesyouthEnum");
		list.add("YouthcriticalissuesHouseholddynamicsEnum");
		list.add("YouthcriticalissuesHousingissuesfamEnum");
		list.add("YouthcriticalissuesIncarceratedparentEnum");
		list.add("YouthcriticalissuesIncarceratedparentstatusEnum");
		list.add("YouthcriticalissuesInsufficientincomeEnum");
		list.add("YouthcriticalissuesMentaldisabilityfamEnum");
		list.add("YouthcriticalissuesMentaldisabilityyouthEnum");
		list.add("YouthcriticalissuesMentalhealthissuesfamEnum");
		list.add("YouthcriticalissuesMentalhealthissuesyouthEnum");
		list.add("YouthcriticalissuesPhysicaldisabilityfamEnum");
		list.add("YouthcriticalissuesPhysicaldisabilityyouthEnum");
		list.add("YouthcriticalissuesSchooleducationalissuesfamEnum");
		list.add("YouthcriticalissuesSchooleducationalissuesyouthEnum");
		list.add("YouthcriticalissuesSexualorientationgenderidfamEnum");
		list.add("YouthcriticalissuesSexualorientationgenderidyouthEnum");
		list.add("YouthcriticalissuesUnemploymentfamEnum");
		list.add("YouthcriticalissuesUnemploymentyouthEnum");
		
	}
	private void generateFiles()
	{
		for(String enumName :list)
		{
			try {
		        File input = new File("C:/HMISTEstDev/HMISModel/src/main/java/com/servinglynk/hmis/warehouse/enums/EnrollmentDisablingconditionEnumType.java");
		        File output = new File(enumName+"Type.java");
		        Scanner sc = new Scanner(input);
		        PrintWriter printer = new PrintWriter("C:/HMISTEstDev/HMISModel/src/main/java/com/servinglynk/hmis/warehouse/enums/"+output);
		        while(sc.hasNextLine()) {
		            String s = sc.nextLine();
		            String line =s.replace("EnrollmentDisablingconditionEnum", enumName);
		            printer.write(line);
		            printer.write("\n");
		        }
		        printer.flush();
		    }
		    catch(FileNotFoundException e) {
		        System.err.println("File not found. Please scan in new file.");
		    }
		}
	}
	public static void main(String args[])
	{
		EnumTypeGenerator generator = new EnumTypeGenerator();
		generator.generateFiles();
		
	}

}