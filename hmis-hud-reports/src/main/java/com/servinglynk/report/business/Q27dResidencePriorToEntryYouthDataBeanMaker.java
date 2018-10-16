package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.servinglynk.report.bean.Q27dResidencePriorToEntryYouthDataBean;
import com.servinglynk.report.bean.ReportData;
import com.servinglynk.report.model.EnrollmentModel;

public class Q27dResidencePriorToEntryYouthDataBeanMaker extends BaseBeanMaker {
	
	public static List<Q27dResidencePriorToEntryYouthDataBean> getQ27dResidencePriorToEntryYouthList(ReportData data){
		
		Q27dResidencePriorToEntryYouthDataBean q27dResidencePriorToEntryYouthTable = new Q27dResidencePriorToEntryYouthDataBean();
		
		if(data.isLiveMode()) {
			try {
			int overallTot = data.getNumOfAdults().intValue() + data.getNoOfChildHeadsOfHousehold().intValue();
				
			List<EnrollmentModel> unfilteredEnrollments = data.getEnrollments();
			List<EnrollmentModel> enrollments = unfilteredEnrollments.parallelStream().filter(enrollment -> enrollment.getAgeatentry() >= 18 && enrollment.getAgeatentry() <=25 && StringUtils.equals("1", enrollment.getRelationshiptohoh()) ).collect(Collectors.toList());
			
			List<String> projectsHHWithOutChildren = data.getProjectsHHWithOutChildren();
			List<String> projectsHHWithOneAdultChild = data.getProjectsHHWithOneAdultChild();
			List<String> projectsHHWithChildren = data.getProjectsHHWithChildren();
			List<String> projectsUnknownHouseHold = data.getProjectsUnknownHouseHold();
			
			BigInteger  homelessSitualtionTotalUHHT = BigInteger.ZERO;
			BigInteger	homelessSitualtionTotalWCA = BigInteger.ZERO;
			BigInteger	homelessSitualtionTotalWithOnlyChild = BigInteger.ZERO;
			BigInteger	homelessSitualtionTotalWOC = BigInteger.ZERO;
			BigInteger  homelessSitualtionOverallTotal = BigInteger.ZERO;
			
			/*
			 * 	q27dResidencePriorToEntryYouthTable.setQ15HomeLessSituationsTotal(BigInteger.valueOf(emergencyShelter.size()));
				q27dResidencePriorToEntryYouthTable.setQ15HomeLessSituationsWithoutChildren(BigInteger.valueOf(withOutChildrenIntSize));
				q27dResidencePriorToEntryYouthTable.setQ15HomeLessSituationWithChildAndAdult(BigInteger.valueOf(withOneAdultChildIntSize));
				q27dResidencePriorToEntryYouthTable.setQ15HomeLessSituationsWithChildOnly(BigInteger.valueOf(withChildrenIntSize));
				q27dResidencePriorToEntryYouthTable.setQ15HomeLessSituationsUnknownHouseHold(BigInteger.valueOf(unknownHouseHoldIntSize));
			 */
			List<EnrollmentModel> emergencyShelter = enrollments.parallelStream().filter(enrollment -> StringUtils.equals("1", enrollment.getLivingSituation())).collect(Collectors.toList());
			if(CollectionUtils.isNotEmpty(emergencyShelter)) {
				List<EnrollmentModel> withChildren = emergencyShelter.parallelStream().filter(enrollment -> projectsHHWithChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
				List<EnrollmentModel> withOutChildren = emergencyShelter.parallelStream().filter(enrollment -> projectsHHWithOutChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
				List<EnrollmentModel> withOneAdultChild = emergencyShelter.parallelStream().filter(enrollment -> projectsHHWithOneAdultChild.contains(enrollment.getProjectID())).collect(Collectors.toList());
				List<EnrollmentModel> unknownHouseHold = emergencyShelter.parallelStream().filter(enrollment -> projectsUnknownHouseHold.contains(enrollment.getProjectID())).collect(Collectors.toList());
				
				int withOutChildrenIntSize = withOutChildren != null ?withOutChildren.size() :0 ;
				int withOneAdultChildIntSize = withOneAdultChild != null ?withOneAdultChild.size() :0;
				int withChildrenIntSize = withChildren != null ?withChildren.size() :0;
				int unknownHouseHoldIntSize = unknownHouseHold !=null ?unknownHouseHold.size() :0;
				
				homelessSitualtionOverallTotal.add(BigInteger.valueOf(emergencyShelter.size()));
				homelessSitualtionTotalWithOnlyChild.add(BigInteger.valueOf(withChildrenIntSize));
				homelessSitualtionTotalWOC.add(BigInteger.valueOf(withOutChildrenIntSize));
				homelessSitualtionTotalWCA.add(BigInteger.valueOf(withOneAdultChildIntSize));
				homelessSitualtionTotalUHHT.add(BigInteger.valueOf(unknownHouseHoldIntSize));
				
				q27dResidencePriorToEntryYouthTable.setQ27dA1EmergencyShelterTotal(BigInteger.valueOf(emergencyShelter.size()));
				q27dResidencePriorToEntryYouthTable.setQ27dA1EmergencyShelterWithoutChild(BigInteger.valueOf(withOutChildrenIntSize));
				q27dResidencePriorToEntryYouthTable.setQ27dA1EmergencyShelterWithChildAndAdults(BigInteger.valueOf(withOneAdultChildIntSize));
				q27dResidencePriorToEntryYouthTable.setQ27dA1EmergencyShelterWithChildOnly(BigInteger.valueOf(withChildrenIntSize));
				q27dResidencePriorToEntryYouthTable.setQ27dA1EmergencyShelterUnknownHouseHoldtype(BigInteger.valueOf(unknownHouseHoldIntSize));
			}
		
			List<EnrollmentModel> transitionalHousing = enrollments.parallelStream().filter(enrollment -> StringUtils.equals("2", enrollment.getLivingSituation())).collect(Collectors.toList());
			if(CollectionUtils.isNotEmpty(transitionalHousing)) {
				List<EnrollmentModel> withChildren = transitionalHousing.parallelStream().filter(enrollment -> projectsHHWithChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
				List<EnrollmentModel> withOutChildren = transitionalHousing.parallelStream().filter(enrollment -> projectsHHWithOutChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
				List<EnrollmentModel> withOneAdultChild = transitionalHousing.parallelStream().filter(enrollment -> projectsHHWithOneAdultChild.contains(enrollment.getProjectID())).collect(Collectors.toList());
				List<EnrollmentModel> unknownHouseHold = transitionalHousing.parallelStream().filter(enrollment -> projectsUnknownHouseHold.contains(enrollment.getProjectID())).collect(Collectors.toList());
				
				int withOutChildrenIntSize = withOutChildren != null ?withOutChildren.size() :0 ;
				int withOneAdultChildIntSize = withOneAdultChild != null ?withOneAdultChild.size() :0;
				int withChildrenIntSize = withChildren != null ?withChildren.size() :0;
				int unknownHouseHoldIntSize = unknownHouseHold !=null ?unknownHouseHold.size() :0;
				
				homelessSitualtionOverallTotal.add(BigInteger.valueOf(transitionalHousing.size()));
				homelessSitualtionTotalWithOnlyChild.add(BigInteger.valueOf(withChildrenIntSize));
				homelessSitualtionTotalWOC.add(BigInteger.valueOf(withOutChildrenIntSize));
				homelessSitualtionTotalWCA.add(BigInteger.valueOf(withOneAdultChildIntSize));
				homelessSitualtionTotalUHHT.add(BigInteger.valueOf(unknownHouseHoldIntSize));
				
				q27dResidencePriorToEntryYouthTable.setQ27dA2TransitionalHousingForHomelessTotal(BigInteger.valueOf(transitionalHousing.size()));
				q27dResidencePriorToEntryYouthTable.setQ27dA2TransitionalHousingForHomelessWithoutChild(BigInteger.valueOf(withOutChildrenIntSize));
				q27dResidencePriorToEntryYouthTable.setQ27dA2TransitionalHousingForHomelessWithChildAndAdults(BigInteger.valueOf(withOneAdultChildIntSize));
				q27dResidencePriorToEntryYouthTable.setQ27dA2TransitionalHousingForHomelessWithChildOnly(BigInteger.valueOf(withChildrenIntSize));
				q27dResidencePriorToEntryYouthTable.setQ27dA2TransitionalHousingForHomelessUnknownHouseHoldtype(BigInteger.valueOf(unknownHouseHoldIntSize));
			}
			
			List<EnrollmentModel> placeNotMeant = enrollments.parallelStream().filter(enrollment -> StringUtils.equals("16", enrollment.getLivingSituation())).collect(Collectors.toList());
			if(CollectionUtils.isNotEmpty(placeNotMeant)) {
				List<EnrollmentModel> withChildren = placeNotMeant.parallelStream().filter(enrollment -> projectsHHWithChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
				List<EnrollmentModel> withOutChildren = placeNotMeant.parallelStream().filter(enrollment -> projectsHHWithOutChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
				List<EnrollmentModel> withOneAdultChild = placeNotMeant.parallelStream().filter(enrollment -> projectsHHWithOneAdultChild.contains(enrollment.getProjectID())).collect(Collectors.toList());
				List<EnrollmentModel> unknownHouseHold = placeNotMeant.parallelStream().filter(enrollment -> projectsUnknownHouseHold.contains(enrollment.getProjectID())).collect(Collectors.toList());
				
				int withOutChildrenIntSize = withOutChildren != null ?withOutChildren.size() :0 ;
				int withOneAdultChildIntSize = withOneAdultChild != null ?withOneAdultChild.size() :0;
				int withChildrenIntSize = withChildren != null ?withChildren.size() :0;
				int unknownHouseHoldIntSize = unknownHouseHold !=null ?unknownHouseHold.size() :0;
				
				homelessSitualtionOverallTotal.add(BigInteger.valueOf(placeNotMeant.size()));
				homelessSitualtionTotalWithOnlyChild.add(BigInteger.valueOf(withChildrenIntSize));
				homelessSitualtionTotalWOC.add(BigInteger.valueOf(withOutChildrenIntSize));
				homelessSitualtionTotalWCA.add(BigInteger.valueOf(withOneAdultChildIntSize));
				homelessSitualtionTotalUHHT.add(BigInteger.valueOf(unknownHouseHoldIntSize));
				
				q27dResidencePriorToEntryYouthTable.setQ27dA3PlaceNotMeantForHumanHabitationTotal(BigInteger.valueOf(placeNotMeant.size()));
				q27dResidencePriorToEntryYouthTable.setQ27dA3PlaceNotMeantForHumanHabitationWithoutChild(BigInteger.valueOf(withOutChildrenIntSize));
				q27dResidencePriorToEntryYouthTable.setQ27dA3PlaceNotMeantForHumanHabitationWithChildAndAdults(BigInteger.valueOf(withOneAdultChildIntSize));
				q27dResidencePriorToEntryYouthTable.setQ27dA3PlaceNotMeantForHumanHabitationWithChildOnly(BigInteger.valueOf(withChildrenIntSize));
				q27dResidencePriorToEntryYouthTable.setQ27dA3PlaceNotMeantForHumanHabitationUnknownHouseHoldtype(BigInteger.valueOf(unknownHouseHoldIntSize));
			}
			
			List<EnrollmentModel> safeHeaven = enrollments.parallelStream().filter(enrollment -> StringUtils.equals("18", enrollment.getLivingSituation())).collect(Collectors.toList());
			if(CollectionUtils.isNotEmpty(safeHeaven)) {
				List<EnrollmentModel> withChildren = safeHeaven.parallelStream().filter(enrollment -> projectsHHWithChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
				List<EnrollmentModel> withOutChildren = safeHeaven.parallelStream().filter(enrollment -> projectsHHWithOutChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
				List<EnrollmentModel> withOneAdultChild = safeHeaven.parallelStream().filter(enrollment -> projectsHHWithOneAdultChild.contains(enrollment.getProjectID())).collect(Collectors.toList());
				List<EnrollmentModel> unknownHouseHold = safeHeaven.parallelStream().filter(enrollment -> projectsUnknownHouseHold.contains(enrollment.getProjectID())).collect(Collectors.toList());
				
				int withOutChildrenIntSize = withOutChildren != null ?withOutChildren.size() :0 ;
				int withOneAdultChildIntSize = withOneAdultChild != null ?withOneAdultChild.size() :0;
				int withChildrenIntSize = withChildren != null ?withChildren.size() :0;
				int unknownHouseHoldIntSize = unknownHouseHold !=null ?unknownHouseHold.size() :0;
				
				homelessSitualtionOverallTotal.add(BigInteger.valueOf(safeHeaven.size()));
				homelessSitualtionTotalWithOnlyChild.add(BigInteger.valueOf(withChildrenIntSize));
				homelessSitualtionTotalWOC.add(BigInteger.valueOf(withOutChildrenIntSize));
				homelessSitualtionTotalWCA.add(BigInteger.valueOf(withOneAdultChildIntSize));
				homelessSitualtionTotalUHHT.add(BigInteger.valueOf(unknownHouseHoldIntSize));
				
				q27dResidencePriorToEntryYouthTable.setQ27dA4SafeHavenTotal(BigInteger.valueOf(safeHeaven.size()));
				q27dResidencePriorToEntryYouthTable.setQ27dA4SafeHavenWithoutChild(BigInteger.valueOf(withOutChildrenIntSize));
				q27dResidencePriorToEntryYouthTable.setQ27dA4SafeHavenWithChildAndAdults(BigInteger.valueOf(withOneAdultChildIntSize));
				q27dResidencePriorToEntryYouthTable.setQ27dA4SafeHavenWithChildOnly(BigInteger.valueOf(withChildrenIntSize));
				q27dResidencePriorToEntryYouthTable.setQ27dA4SafeHavenUnknownHouseHoldtype(BigInteger.valueOf(unknownHouseHoldIntSize));
			}
			
			List<EnrollmentModel> interimHousing = enrollments.parallelStream().filter(enrollment -> StringUtils.equals("27", enrollment.getLivingSituation())).collect(Collectors.toList());
			if(CollectionUtils.isNotEmpty(interimHousing)) {
				List<EnrollmentModel> withChildren = interimHousing.parallelStream().filter(enrollment -> projectsHHWithChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
				List<EnrollmentModel> withOutChildren = interimHousing.parallelStream().filter(enrollment -> projectsHHWithOutChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
				List<EnrollmentModel> withOneAdultChild = interimHousing.parallelStream().filter(enrollment -> projectsHHWithOneAdultChild.contains(enrollment.getProjectID())).collect(Collectors.toList());
				List<EnrollmentModel> unknownHouseHold = interimHousing.parallelStream().filter(enrollment -> projectsUnknownHouseHold.contains(enrollment.getProjectID())).collect(Collectors.toList());
				
				int withOutChildrenIntSize = withOutChildren != null ?withOutChildren.size() :0 ;
				int withOneAdultChildIntSize = withOneAdultChild != null ?withOneAdultChild.size() :0;
				int withChildrenIntSize = withChildren != null ?withChildren.size() :0;
				int unknownHouseHoldIntSize = unknownHouseHold !=null ?unknownHouseHold.size() :0;
				
				homelessSitualtionOverallTotal.add(BigInteger.valueOf(interimHousing.size()));
				homelessSitualtionTotalWithOnlyChild.add(BigInteger.valueOf(withChildrenIntSize));
				homelessSitualtionTotalWOC.add(BigInteger.valueOf(withOutChildrenIntSize));
				homelessSitualtionTotalWCA.add(BigInteger.valueOf(withOneAdultChildIntSize));
				homelessSitualtionTotalUHHT.add(BigInteger.valueOf(unknownHouseHoldIntSize));
				
				q27dResidencePriorToEntryYouthTable.setQ27dA5InterimHousingTotal(BigInteger.valueOf(interimHousing.size()));
				q27dResidencePriorToEntryYouthTable.setQ27dA5InterimHousingWithoutChild(BigInteger.valueOf(withOutChildrenIntSize));
				q27dResidencePriorToEntryYouthTable.setQ27dA5InterimHousingWithChildAndAdults(BigInteger.valueOf(withOneAdultChildIntSize));
				q27dResidencePriorToEntryYouthTable.setQ27dA5InterimHousingWithChildOnly(BigInteger.valueOf(withChildrenIntSize));
				q27dResidencePriorToEntryYouthTable.setQ27dA5InterimHousingUnknownHouseHoldtype(BigInteger.valueOf(unknownHouseHoldIntSize));
			}
			
			q27dResidencePriorToEntryYouthTable.setQ27dAzTotTotal(homelessSitualtionOverallTotal);
			q27dResidencePriorToEntryYouthTable.setQ27dAzTotWithoutChild(homelessSitualtionTotalWOC);
			q27dResidencePriorToEntryYouthTable.setQ27dAzTotWithChildAndAdults(homelessSitualtionTotalWCA);
			q27dResidencePriorToEntryYouthTable.setQ27dAzTotWithChildOnly(homelessSitualtionTotalWithOnlyChild);
			q27dResidencePriorToEntryYouthTable.setQ27dAzTotUnknownHouseHoldtype(homelessSitualtionTotalUHHT);
			
			
		/*	
			q27dResidencePriorToEntryYouthTable.setQ15InstitutionalSettingsTotal(BigInteger.valueOf(0));
			q27dResidencePriorToEntryYouthTable.setQ15InstitutionalSettingsWithoutChildren(BigInteger.valueOf(0));
			q27dResidencePriorToEntryYouthTable.setQ15InstitutionalSettingsWithChildandAdult(BigInteger.valueOf(0));
			q27dResidencePriorToEntryYouthTable.setQ15InstitutionalSettingsWithChildOnly(BigInteger.valueOf(0));
			q27dResidencePriorToEntryYouthTable.setQ15InstitutionalSettingsUnknowHouseHold(BigInteger.valueOf(0));
			
			*/
			BigInteger  institutionalSettingTotalUHHT = BigInteger.ZERO;
			BigInteger	institutionalSettinTotalWCA = BigInteger.ZERO;
			BigInteger	institutionalSettinTotalWithOnlyChild = BigInteger.ZERO;
			BigInteger	institutionalSettinTotalWOC = BigInteger.ZERO;
			BigInteger  institutionalSettinOverallTotal = BigInteger.ZERO;
			
			List<EnrollmentModel> psychiatricFacility = enrollments.parallelStream().filter(enrollment -> StringUtils.equals("4", enrollment.getLivingSituation())).collect(Collectors.toList());
			if(CollectionUtils.isNotEmpty(psychiatricFacility)) {
				List<EnrollmentModel> withChildren = psychiatricFacility.parallelStream().filter(enrollment -> projectsHHWithChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
				List<EnrollmentModel> withOutChildren = psychiatricFacility.parallelStream().filter(enrollment -> projectsHHWithOutChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
				List<EnrollmentModel> withOneAdultChild = psychiatricFacility.parallelStream().filter(enrollment -> projectsHHWithOneAdultChild.contains(enrollment.getProjectID())).collect(Collectors.toList());
				List<EnrollmentModel> unknownHouseHold = psychiatricFacility.parallelStream().filter(enrollment -> projectsUnknownHouseHold.contains(enrollment.getProjectID())).collect(Collectors.toList());
				
				int withOutChildrenIntSize = withOutChildren != null ?withOutChildren.size() :0 ;
				int withOneAdultChildIntSize = withOneAdultChild != null ?withOneAdultChild.size() :0;
				int withChildrenIntSize = withChildren != null ?withChildren.size() :0;
				int unknownHouseHoldIntSize = unknownHouseHold !=null ?unknownHouseHold.size() :0;
				
				institutionalSettinOverallTotal.add(BigInteger.valueOf(psychiatricFacility.size()));
				institutionalSettinTotalWithOnlyChild.add(BigInteger.valueOf(withChildrenIntSize));
				institutionalSettinTotalWOC.add(BigInteger.valueOf(withOutChildrenIntSize));
				institutionalSettinTotalWCA.add(BigInteger.valueOf(withOneAdultChildIntSize));
				institutionalSettingTotalUHHT.add(BigInteger.valueOf(unknownHouseHoldIntSize));
				
				q27dResidencePriorToEntryYouthTable.setQ27dB1PsychiatricFacilityTotal(BigInteger.valueOf(psychiatricFacility.size()));
				q27dResidencePriorToEntryYouthTable.setQ27dB1PsychiatricFacilityWithoutChild(BigInteger.valueOf(withOutChildrenIntSize));
				q27dResidencePriorToEntryYouthTable.setQ27dB1PsychiatricFacilityWithChildAndAdults(BigInteger.valueOf(withOneAdultChildIntSize));
				q27dResidencePriorToEntryYouthTable.setQ27dB1PsychiatricFacilityWithChildOnly(BigInteger.valueOf(withChildrenIntSize));
				q27dResidencePriorToEntryYouthTable.setQ27dB1PsychiatricFacilityUnknownHouseHoldtype(BigInteger.valueOf(unknownHouseHoldIntSize));
			}
			
			List<EnrollmentModel> substanceAbuse = enrollments.parallelStream().filter(enrollment -> StringUtils.equals("5", enrollment.getLivingSituation())).collect(Collectors.toList());
			if(CollectionUtils.isNotEmpty(substanceAbuse)) {
				List<EnrollmentModel> withChildren = substanceAbuse.parallelStream().filter(enrollment -> projectsHHWithChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
				List<EnrollmentModel> withOutChildren = substanceAbuse.parallelStream().filter(enrollment -> projectsHHWithOutChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
				List<EnrollmentModel> withOneAdultChild = substanceAbuse.parallelStream().filter(enrollment -> projectsHHWithOneAdultChild.contains(enrollment.getProjectID())).collect(Collectors.toList());
				List<EnrollmentModel> unknownHouseHold = substanceAbuse.parallelStream().filter(enrollment -> projectsUnknownHouseHold.contains(enrollment.getProjectID())).collect(Collectors.toList());
				
				int withOutChildrenIntSize = withOutChildren != null ?withOutChildren.size() :0 ;
				int withOneAdultChildIntSize = withOneAdultChild != null ?withOneAdultChild.size() :0;
				int withChildrenIntSize = withChildren != null ?withChildren.size() :0;
				int unknownHouseHoldIntSize = unknownHouseHold !=null ?unknownHouseHold.size() :0;
				
				institutionalSettinOverallTotal.add(BigInteger.valueOf(substanceAbuse.size()));
				institutionalSettinTotalWithOnlyChild.add(BigInteger.valueOf(withChildrenIntSize));
				institutionalSettinTotalWOC.add(BigInteger.valueOf(withOutChildrenIntSize));
				institutionalSettinTotalWCA.add(BigInteger.valueOf(withOneAdultChildIntSize));
				institutionalSettingTotalUHHT.add(BigInteger.valueOf(unknownHouseHoldIntSize));
				
				q27dResidencePriorToEntryYouthTable.setQ27dB2SubstanceAbuseTotal(BigInteger.valueOf(substanceAbuse.size()));
				q27dResidencePriorToEntryYouthTable.setQ27dB2SubstanceAbuseWithoutChild(BigInteger.valueOf(withOutChildrenIntSize));
				q27dResidencePriorToEntryYouthTable.setQ27dB2SubstanceAbuseWithChildAndAdults(BigInteger.valueOf(withOneAdultChildIntSize));
				q27dResidencePriorToEntryYouthTable.setQ27dB2SubstanceAbuseWithChildOnly(BigInteger.valueOf(withChildrenIntSize));
				q27dResidencePriorToEntryYouthTable.setQ27dB2SubstanceAbuseUnknownHouseHoldtype(BigInteger.valueOf(unknownHouseHoldIntSize));
			}
			
			List<EnrollmentModel> hospitalNonPhychiatric = enrollments.parallelStream().filter(enrollment -> StringUtils.equals("6", enrollment.getLivingSituation())).collect(Collectors.toList());
			if(CollectionUtils.isNotEmpty(hospitalNonPhychiatric)) {
				List<EnrollmentModel> withChildren = hospitalNonPhychiatric.parallelStream().filter(enrollment -> projectsHHWithChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
				List<EnrollmentModel> withOutChildren = hospitalNonPhychiatric.parallelStream().filter(enrollment -> projectsHHWithOutChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
				List<EnrollmentModel> withOneAdultChild = hospitalNonPhychiatric.parallelStream().filter(enrollment -> projectsHHWithOneAdultChild.contains(enrollment.getProjectID())).collect(Collectors.toList());
				List<EnrollmentModel> unknownHouseHold = hospitalNonPhychiatric.parallelStream().filter(enrollment -> projectsUnknownHouseHold.contains(enrollment.getProjectID())).collect(Collectors.toList());
				
				int withOutChildrenIntSize = withOutChildren != null ?withOutChildren.size() :0 ;
				int withOneAdultChildIntSize = withOneAdultChild != null ?withOneAdultChild.size() :0;
				int withChildrenIntSize = withChildren != null ?withChildren.size() :0;
				int unknownHouseHoldIntSize = unknownHouseHold !=null ?unknownHouseHold.size() :0;
				
				institutionalSettinOverallTotal.add(BigInteger.valueOf(hospitalNonPhychiatric.size()));
				institutionalSettinTotalWithOnlyChild.add(BigInteger.valueOf(withChildrenIntSize));
				institutionalSettinTotalWOC.add(BigInteger.valueOf(withOutChildrenIntSize));
				institutionalSettinTotalWCA.add(BigInteger.valueOf(withOneAdultChildIntSize));
				institutionalSettingTotalUHHT.add(BigInteger.valueOf(unknownHouseHoldIntSize));
				
				q27dResidencePriorToEntryYouthTable.setQ27dB3HospitalNonPsychiatricTotal(BigInteger.valueOf(hospitalNonPhychiatric.size()));
				q27dResidencePriorToEntryYouthTable.setQ27dB3HospitalNonPsychiatricWithoutChild(BigInteger.valueOf(withOutChildrenIntSize));
				q27dResidencePriorToEntryYouthTable.setQ27dB3HospitalNonPsychiatricWithChildAndAdults(BigInteger.valueOf(withOneAdultChildIntSize));
				q27dResidencePriorToEntryYouthTable.setQ27dB3HospitalNonPsychiatricWithChildOnly(BigInteger.valueOf(withChildrenIntSize));
				q27dResidencePriorToEntryYouthTable.setQ27dB3HospitalNonPsychiatricUnknownHouseHoldtype(BigInteger.valueOf(unknownHouseHoldIntSize));
			}
			
			List<EnrollmentModel> jailPrison = enrollments.parallelStream().filter(enrollment -> StringUtils.equals("7", enrollment.getLivingSituation())).collect(Collectors.toList());
			if(CollectionUtils.isNotEmpty(jailPrison)) {
				List<EnrollmentModel> withChildren = jailPrison.parallelStream().filter(enrollment -> projectsHHWithChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
				List<EnrollmentModel> withOutChildren = jailPrison.parallelStream().filter(enrollment -> projectsHHWithOutChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
				List<EnrollmentModel> withOneAdultChild = jailPrison.parallelStream().filter(enrollment -> projectsHHWithOneAdultChild.contains(enrollment.getProjectID())).collect(Collectors.toList());
				List<EnrollmentModel> unknownHouseHold = jailPrison.parallelStream().filter(enrollment -> projectsUnknownHouseHold.contains(enrollment.getProjectID())).collect(Collectors.toList());
				
				int withOutChildrenIntSize = withOutChildren != null ?withOutChildren.size() :0 ;
				int withOneAdultChildIntSize = withOneAdultChild != null ?withOneAdultChild.size() :0;
				int withChildrenIntSize = withChildren != null ?withChildren.size() :0;
				int unknownHouseHoldIntSize = unknownHouseHold !=null ?unknownHouseHold.size() :0;
				
				institutionalSettinOverallTotal.add(BigInteger.valueOf(jailPrison.size()));
				institutionalSettinTotalWithOnlyChild.add(BigInteger.valueOf(withChildrenIntSize));
				institutionalSettinTotalWOC.add(BigInteger.valueOf(withOutChildrenIntSize));
				institutionalSettinTotalWCA.add(BigInteger.valueOf(withOneAdultChildIntSize));
				institutionalSettingTotalUHHT.add(BigInteger.valueOf(unknownHouseHoldIntSize));
				
				q27dResidencePriorToEntryYouthTable.setQ27dB4JailPrisonOrJuvenileDetentionTotal(BigInteger.valueOf(jailPrison.size()));
				q27dResidencePriorToEntryYouthTable.setQ27dB4JailPrisonOrJuvenileDetentionWithoutChild(BigInteger.valueOf(withOutChildrenIntSize));
				q27dResidencePriorToEntryYouthTable.setQ27dB4JailPrisonOrJuvenileDetentionWithChildAndAdults(BigInteger.valueOf(withOneAdultChildIntSize));
				q27dResidencePriorToEntryYouthTable.setQ27dB4JailPrisonOrJuvenileDetentionWithChildOnly(BigInteger.valueOf(withChildrenIntSize));
				q27dResidencePriorToEntryYouthTable.setQ27dB4JailPrisonOrJuvenileDetentionUnknownHouseHoldtype(BigInteger.valueOf(unknownHouseHoldIntSize));
			}
			
			List<EnrollmentModel> fosterCarehome = enrollments.parallelStream().filter(enrollment -> StringUtils.equals("15", enrollment.getLivingSituation())).collect(Collectors.toList());
			if(CollectionUtils.isNotEmpty(fosterCarehome)) {
				List<EnrollmentModel> withChildren = fosterCarehome.parallelStream().filter(enrollment -> projectsHHWithChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
				List<EnrollmentModel> withOutChildren = fosterCarehome.parallelStream().filter(enrollment -> projectsHHWithOutChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
				List<EnrollmentModel> withOneAdultChild = fosterCarehome.parallelStream().filter(enrollment -> projectsHHWithOneAdultChild.contains(enrollment.getProjectID())).collect(Collectors.toList());
				List<EnrollmentModel> unknownHouseHold = fosterCarehome.parallelStream().filter(enrollment -> projectsUnknownHouseHold.contains(enrollment.getProjectID())).collect(Collectors.toList());
				
				int withOutChildrenIntSize = withOutChildren != null ?withOutChildren.size() :0 ;
				int withOneAdultChildIntSize = withOneAdultChild != null ?withOneAdultChild.size() :0;
				int withChildrenIntSize = withChildren != null ?withChildren.size() :0;
				int unknownHouseHoldIntSize = unknownHouseHold !=null ?unknownHouseHold.size() :0;
				
				institutionalSettinOverallTotal.add(BigInteger.valueOf(fosterCarehome.size()));
				institutionalSettinTotalWithOnlyChild.add(BigInteger.valueOf(withChildrenIntSize));
				institutionalSettinTotalWOC.add(BigInteger.valueOf(withOutChildrenIntSize));
				institutionalSettinTotalWCA.add(BigInteger.valueOf(withOneAdultChildIntSize));
				institutionalSettingTotalUHHT.add(BigInteger.valueOf(unknownHouseHoldIntSize));
				
				q27dResidencePriorToEntryYouthTable.setQ27dB5FosterCareHomeOrGroupTotal(BigInteger.valueOf(fosterCarehome.size()));
				q27dResidencePriorToEntryYouthTable.setQ27dB5FosterCareHomeOrGroupWithoutChild(BigInteger.valueOf(withOutChildrenIntSize));
				q27dResidencePriorToEntryYouthTable.setQ27dB5FosterCareHomeOrGroupWithChildAndAdults(BigInteger.valueOf(withOneAdultChildIntSize));
				q27dResidencePriorToEntryYouthTable.setQ27dB5FosterCareHomeOrGroupWithChildOnly(BigInteger.valueOf(withChildrenIntSize));
				q27dResidencePriorToEntryYouthTable.setQ27dB5FosterCareHomeOrGroupUnknownHouseHoldtype(BigInteger.valueOf(unknownHouseHoldIntSize));
			}
			
			List<EnrollmentModel> longTermCareFacility = enrollments.parallelStream().filter(enrollment -> StringUtils.equals("24", enrollment.getLivingSituation())).collect(Collectors.toList());
			if(CollectionUtils.isNotEmpty(longTermCareFacility)) {
				List<EnrollmentModel> withChildren = longTermCareFacility.parallelStream().filter(enrollment -> projectsHHWithChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
				List<EnrollmentModel> withOutChildren = longTermCareFacility.parallelStream().filter(enrollment -> projectsHHWithOutChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
				List<EnrollmentModel> withOneAdultChild = longTermCareFacility.parallelStream().filter(enrollment -> projectsHHWithOneAdultChild.contains(enrollment.getProjectID())).collect(Collectors.toList());
				List<EnrollmentModel> unknownHouseHold = longTermCareFacility.parallelStream().filter(enrollment -> projectsUnknownHouseHold.contains(enrollment.getProjectID())).collect(Collectors.toList());
				
				int withOutChildrenIntSize = withOutChildren != null ?withOutChildren.size() :0 ;
				int withOneAdultChildIntSize = withOneAdultChild != null ?withOneAdultChild.size() :0;
				int withChildrenIntSize = withChildren != null ?withChildren.size() :0;
				int unknownHouseHoldIntSize = unknownHouseHold !=null ?unknownHouseHold.size() :0;
				
				institutionalSettinOverallTotal.add(BigInteger.valueOf(longTermCareFacility.size()));
				institutionalSettinTotalWithOnlyChild.add(BigInteger.valueOf(withChildrenIntSize));
				institutionalSettinTotalWOC.add(BigInteger.valueOf(withOutChildrenIntSize));
				institutionalSettinTotalWCA.add(BigInteger.valueOf(withOneAdultChildIntSize));
				institutionalSettingTotalUHHT.add(BigInteger.valueOf(unknownHouseHoldIntSize));
				
				q27dResidencePriorToEntryYouthTable.setQ27dB6LongTermCareFacilityTotal(BigInteger.valueOf(longTermCareFacility.size()));
				q27dResidencePriorToEntryYouthTable.setQ27dB6LongTermCareFacilityWithoutChild(BigInteger.valueOf(withOutChildrenIntSize));
				q27dResidencePriorToEntryYouthTable.setQ27dB6LongTermCareFacilityWithChildAndAdults(BigInteger.valueOf(withOneAdultChildIntSize));
				q27dResidencePriorToEntryYouthTable.setQ27dB6LongTermCareFacilityWithChildOnly(BigInteger.valueOf(withChildrenIntSize));
				q27dResidencePriorToEntryYouthTable.setQ27dB6LongTermCareFacilityUnknownHouseHoldtype(BigInteger.valueOf(unknownHouseHoldIntSize));
			}
			
			
			List<EnrollmentModel> residentialProject = enrollments.parallelStream().filter(enrollment -> StringUtils.equals("24", enrollment.getLivingSituation())).collect(Collectors.toList());
			if(CollectionUtils.isNotEmpty(residentialProject)) {
				List<EnrollmentModel> withChildren = residentialProject.parallelStream().filter(enrollment -> projectsHHWithChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
				List<EnrollmentModel> withOutChildren = residentialProject.parallelStream().filter(enrollment -> projectsHHWithOutChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
				List<EnrollmentModel> withOneAdultChild = residentialProject.parallelStream().filter(enrollment -> projectsHHWithOneAdultChild.contains(enrollment.getProjectID())).collect(Collectors.toList());
				List<EnrollmentModel> unknownHouseHold = residentialProject.parallelStream().filter(enrollment -> projectsUnknownHouseHold.contains(enrollment.getProjectID())).collect(Collectors.toList());
				
				int withOutChildrenIntSize = withOutChildren != null ?withOutChildren.size() :0 ;
				int withOneAdultChildIntSize = withOneAdultChild != null ?withOneAdultChild.size() :0;
				int withChildrenIntSize = withChildren != null ?withChildren.size() :0;
				int unknownHouseHoldIntSize = unknownHouseHold !=null ?unknownHouseHold.size() :0;
				
				institutionalSettinOverallTotal.add(BigInteger.valueOf(residentialProject.size()));
				institutionalSettinTotalWithOnlyChild.add(BigInteger.valueOf(withChildrenIntSize));
				institutionalSettinTotalWOC.add(BigInteger.valueOf(withOutChildrenIntSize));
				institutionalSettinTotalWCA.add(BigInteger.valueOf(withOneAdultChildIntSize));
				institutionalSettingTotalUHHT.add(BigInteger.valueOf(unknownHouseHoldIntSize));
				
				q27dResidencePriorToEntryYouthTable.setQ27dB7ResidentialProjectTotal(BigInteger.valueOf(residentialProject.size()));
				q27dResidencePriorToEntryYouthTable.setQ27dB7ResidentialProjectWithoutChild(BigInteger.valueOf(withOutChildrenIntSize));
				q27dResidencePriorToEntryYouthTable.setQ27dB7ResidentialProjectWithChildAndAdults(BigInteger.valueOf(withOneAdultChildIntSize));
				q27dResidencePriorToEntryYouthTable.setQ27dB7ResidentialProjectWithChildOnly(BigInteger.valueOf(withChildrenIntSize));
				q27dResidencePriorToEntryYouthTable.setQ27dB7ResidentialProjectUnknownHouseHoldtype(BigInteger.valueOf(unknownHouseHoldIntSize));
			}
			
			q27dResidencePriorToEntryYouthTable.setQ27dBzTotTotal(institutionalSettinOverallTotal);
			q27dResidencePriorToEntryYouthTable.setQ27dBzTotWithoutChild(institutionalSettinTotalWOC);
			q27dResidencePriorToEntryYouthTable.setQ27dBzTotWithChildAndAdults(institutionalSettinTotalWCA);
			q27dResidencePriorToEntryYouthTable.setQ27dBzTotWithChildOnly(institutionalSettinTotalWithOnlyChild);
			q27dResidencePriorToEntryYouthTable.setQ27dBzTotUnknownHouseHoldtype(institutionalSettingTotalUHHT);
			
//			q27dResidencePriorToEntryYouthTable.setQ15OtherLocationTotal(BigInteger.valueOf(0));
//			q27dResidencePriorToEntryYouthTable.setQ15OtherLocationWithoutChild(BigInteger.valueOf(0));
//			q27dResidencePriorToEntryYouthTable.setQ15OtherLocationWithChildandAdult(BigInteger.valueOf(0));
//			q27dResidencePriorToEntryYouthTable.setQ15OtherLocationWithChildOnly(BigInteger.valueOf(0));
//			q27dResidencePriorToEntryYouthTable.setQ15OtherLocationUnkownHousehold(BigInteger.valueOf(0));
			
			BigInteger  otherLocationTotalUHHT = BigInteger.ZERO;
			BigInteger	otherLocationTotalWCA = BigInteger.ZERO;
			BigInteger	otherLocationTotalWithOnlyChild = BigInteger.ZERO;
			BigInteger	otherLocationTotalWOC = BigInteger.ZERO;
			BigInteger  otherLocationOverallTotal = BigInteger.ZERO;
			
			List<EnrollmentModel> pshforHomelessPerson = enrollments.parallelStream().filter(enrollment -> StringUtils.equals("3", enrollment.getLivingSituation())).collect(Collectors.toList());
			if(CollectionUtils.isNotEmpty(pshforHomelessPerson)) {
				List<EnrollmentModel> withChildren = pshforHomelessPerson.parallelStream().filter(enrollment -> projectsHHWithChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
				List<EnrollmentModel> withOutChildren = pshforHomelessPerson.parallelStream().filter(enrollment -> projectsHHWithOutChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
				List<EnrollmentModel> withOneAdultChild = pshforHomelessPerson.parallelStream().filter(enrollment -> projectsHHWithOneAdultChild.contains(enrollment.getProjectID())).collect(Collectors.toList());
				List<EnrollmentModel> unknownHouseHold = pshforHomelessPerson.parallelStream().filter(enrollment -> projectsUnknownHouseHold.contains(enrollment.getProjectID())).collect(Collectors.toList());
				
				int withOutChildrenIntSize = withOutChildren != null ?withOutChildren.size() :0 ;
				int withOneAdultChildIntSize = withOneAdultChild != null ?withOneAdultChild.size() :0;
				int withChildrenIntSize = withChildren != null ?withChildren.size() :0;
				int unknownHouseHoldIntSize = unknownHouseHold !=null ?unknownHouseHold.size() :0;
				
				otherLocationOverallTotal.add(BigInteger.valueOf(pshforHomelessPerson.size()));
				otherLocationTotalWithOnlyChild.add(BigInteger.valueOf(withChildrenIntSize));
				otherLocationTotalWOC.add(BigInteger.valueOf(withOutChildrenIntSize));
				otherLocationTotalWCA.add(BigInteger.valueOf(withOneAdultChildIntSize));
				otherLocationTotalUHHT.add(BigInteger.valueOf(unknownHouseHoldIntSize));
				
				q27dResidencePriorToEntryYouthTable.setQ27dC1PSHForHomelessPersonsTotal(BigInteger.valueOf(pshforHomelessPerson.size()));
				q27dResidencePriorToEntryYouthTable.setQ27dC1PSHForHomelessPersonsWithoutChild(BigInteger.valueOf(withOutChildrenIntSize));
				q27dResidencePriorToEntryYouthTable.setQ27dC1PSHForHomelessPersonsWithChildAndAdults(BigInteger.valueOf(withOneAdultChildIntSize));
				q27dResidencePriorToEntryYouthTable.setQ27dC1PSHForHomelessPersonsWithChildOnly(BigInteger.valueOf(withChildrenIntSize));
				q27dResidencePriorToEntryYouthTable.setQ27dC1PSHForHomelessPersonsUnknownHouseHoldtype(BigInteger.valueOf(unknownHouseHoldIntSize));
			}
			
			
			List<EnrollmentModel> ownedByclientNoSubsidy = enrollments.parallelStream().filter(enrollment -> StringUtils.equals("23", enrollment.getLivingSituation())).collect(Collectors.toList());
			if(CollectionUtils.isNotEmpty(ownedByclientNoSubsidy)) {
				List<EnrollmentModel> withChildren = ownedByclientNoSubsidy.parallelStream().filter(enrollment -> projectsHHWithChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
				List<EnrollmentModel> withOutChildren = ownedByclientNoSubsidy.parallelStream().filter(enrollment -> projectsHHWithOutChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
				List<EnrollmentModel> withOneAdultChild = ownedByclientNoSubsidy.parallelStream().filter(enrollment -> projectsHHWithOneAdultChild.contains(enrollment.getProjectID())).collect(Collectors.toList());
				List<EnrollmentModel> unknownHouseHold = ownedByclientNoSubsidy.parallelStream().filter(enrollment -> projectsUnknownHouseHold.contains(enrollment.getProjectID())).collect(Collectors.toList());
				
				int withOutChildrenIntSize = withOutChildren != null ?withOutChildren.size() :0 ;
				int withOneAdultChildIntSize = withOneAdultChild != null ?withOneAdultChild.size() :0;
				int withChildrenIntSize = withChildren != null ?withChildren.size() :0;
				int unknownHouseHoldIntSize = unknownHouseHold !=null ?unknownHouseHold.size() :0;
				
				otherLocationOverallTotal.add(BigInteger.valueOf(ownedByclientNoSubsidy.size()));
				otherLocationTotalWithOnlyChild.add(BigInteger.valueOf(withChildrenIntSize));
				otherLocationTotalWOC.add(BigInteger.valueOf(withOutChildrenIntSize));
				otherLocationTotalWCA.add(BigInteger.valueOf(withOneAdultChildIntSize));
				otherLocationTotalUHHT.add(BigInteger.valueOf(unknownHouseHoldIntSize));
				
				q27dResidencePriorToEntryYouthTable.setQ27dC2OwnedByClientNoSubsidyTotal(BigInteger.valueOf(ownedByclientNoSubsidy.size()));
				q27dResidencePriorToEntryYouthTable.setQ27dC2OwnedByClientNoSubsidyWithoutChild(BigInteger.valueOf(withOutChildrenIntSize));
				q27dResidencePriorToEntryYouthTable.setQ27dC2OwnedByClientNoSubsidyWithChildAndAdults(BigInteger.valueOf(withOneAdultChildIntSize));
				q27dResidencePriorToEntryYouthTable.setQ27dC2OwnedByClientNoSubsidyWithChildOnly(BigInteger.valueOf(withChildrenIntSize));
				q27dResidencePriorToEntryYouthTable.setQ27dC2OwnedByClientNoSubsidyUnknownHouseHoldtype(BigInteger.valueOf(unknownHouseHoldIntSize));
			}
			
			List<EnrollmentModel> ownedByclientWithSubsidy = enrollments.parallelStream().filter(enrollment -> StringUtils.equals("21", enrollment.getLivingSituation())).collect(Collectors.toList());
			if(CollectionUtils.isNotEmpty(ownedByclientWithSubsidy)) {
				List<EnrollmentModel> withChildren = ownedByclientWithSubsidy.parallelStream().filter(enrollment -> projectsHHWithChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
				List<EnrollmentModel> withOutChildren = ownedByclientWithSubsidy.parallelStream().filter(enrollment -> projectsHHWithOutChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
				List<EnrollmentModel> withOneAdultChild = ownedByclientWithSubsidy.parallelStream().filter(enrollment -> projectsHHWithOneAdultChild.contains(enrollment.getProjectID())).collect(Collectors.toList());
				List<EnrollmentModel> unknownHouseHold = ownedByclientWithSubsidy.parallelStream().filter(enrollment -> projectsUnknownHouseHold.contains(enrollment.getProjectID())).collect(Collectors.toList());
				
				int withOutChildrenIntSize = withOutChildren != null ?withOutChildren.size() :0 ;
				int withOneAdultChildIntSize = withOneAdultChild != null ?withOneAdultChild.size() :0;
				int withChildrenIntSize = withChildren != null ?withChildren.size() :0;
				int unknownHouseHoldIntSize = unknownHouseHold !=null ?unknownHouseHold.size() :0;
				
				otherLocationOverallTotal.add(BigInteger.valueOf(ownedByclientWithSubsidy.size()));
				otherLocationTotalWithOnlyChild.add(BigInteger.valueOf(withChildrenIntSize));
				otherLocationTotalWOC.add(BigInteger.valueOf(withOutChildrenIntSize));
				otherLocationTotalWCA.add(BigInteger.valueOf(withOneAdultChildIntSize));
				otherLocationTotalUHHT.add(BigInteger.valueOf(unknownHouseHoldIntSize));
				
				q27dResidencePriorToEntryYouthTable.setQ27dC3OwnedByClientWithSubsidyTotal(BigInteger.valueOf(ownedByclientWithSubsidy.size()));
				q27dResidencePriorToEntryYouthTable.setQ27dC3OwnedByClientWithSubsidyWithoutChild(BigInteger.valueOf(withOutChildrenIntSize));
				q27dResidencePriorToEntryYouthTable.setQ27dC3OwnedByClientWithSubsidyWithChildAndAdults(BigInteger.valueOf(withOneAdultChildIntSize));
				q27dResidencePriorToEntryYouthTable.setQ27dC3OwnedByClientWithSubsidyWithChildOnly(BigInteger.valueOf(withChildrenIntSize));
				q27dResidencePriorToEntryYouthTable.setQ27dC3OwnedByClientWithSubsidyUnknownHouseHoldtype(BigInteger.valueOf(unknownHouseHoldIntSize));
			}
			
			   
			List<EnrollmentModel> rentalByClientNoSubsidy = enrollments.parallelStream().filter(enrollment -> StringUtils.equals("22", enrollment.getLivingSituation())).collect(Collectors.toList());
			if(CollectionUtils.isNotEmpty(rentalByClientNoSubsidy)) {
				List<EnrollmentModel> withChildren = rentalByClientNoSubsidy.parallelStream().filter(enrollment -> projectsHHWithChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
				List<EnrollmentModel> withOutChildren = rentalByClientNoSubsidy.parallelStream().filter(enrollment -> projectsHHWithOutChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
				List<EnrollmentModel> withOneAdultChild = rentalByClientNoSubsidy.parallelStream().filter(enrollment -> projectsHHWithOneAdultChild.contains(enrollment.getProjectID())).collect(Collectors.toList());
				List<EnrollmentModel> unknownHouseHold = rentalByClientNoSubsidy.parallelStream().filter(enrollment -> projectsUnknownHouseHold.contains(enrollment.getProjectID())).collect(Collectors.toList());
				
				int withOutChildrenIntSize = withOutChildren != null ?withOutChildren.size() :0 ;
				int withOneAdultChildIntSize = withOneAdultChild != null ?withOneAdultChild.size() :0;
				int withChildrenIntSize = withChildren != null ?withChildren.size() :0;
				int unknownHouseHoldIntSize = unknownHouseHold !=null ?unknownHouseHold.size() :0;
				
				otherLocationOverallTotal.add(BigInteger.valueOf(rentalByClientNoSubsidy.size()));
				otherLocationTotalWithOnlyChild.add(BigInteger.valueOf(withChildrenIntSize));
				otherLocationTotalWOC.add(BigInteger.valueOf(withOutChildrenIntSize));
				otherLocationTotalWCA.add(BigInteger.valueOf(withOneAdultChildIntSize));
				otherLocationTotalUHHT.add(BigInteger.valueOf(unknownHouseHoldIntSize));
				
				q27dResidencePriorToEntryYouthTable.setQ27dC4RentalByClientNoSubsidyTotal(BigInteger.valueOf(rentalByClientNoSubsidy.size()));
				q27dResidencePriorToEntryYouthTable.setQ27dC4RentalByClientNoSubsidyWithoutChild(BigInteger.valueOf(withOutChildrenIntSize));
				q27dResidencePriorToEntryYouthTable.setQ27dC4RentalByClientNoSubsidyWithChildAndAdults(BigInteger.valueOf(withOneAdultChildIntSize));
				q27dResidencePriorToEntryYouthTable.setQ27dC4RentalByClientNoSubsidyWithChildOnly(BigInteger.valueOf(withChildrenIntSize));
				q27dResidencePriorToEntryYouthTable.setQ27dC4RentalByClientNoSubsidyUnknownHouseHoldtype(BigInteger.valueOf(unknownHouseHoldIntSize));
			}
			
			List<EnrollmentModel> rentalByClientWithVASHSubsidy = enrollments.parallelStream().filter(enrollment -> StringUtils.equals("19", enrollment.getLivingSituation())).collect(Collectors.toList());
			if(CollectionUtils.isNotEmpty(rentalByClientWithVASHSubsidy)) {
				List<EnrollmentModel> withChildren = rentalByClientWithVASHSubsidy.parallelStream().filter(enrollment -> projectsHHWithChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
				List<EnrollmentModel> withOutChildren = rentalByClientWithVASHSubsidy.parallelStream().filter(enrollment -> projectsHHWithOutChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
				List<EnrollmentModel> withOneAdultChild = rentalByClientWithVASHSubsidy.parallelStream().filter(enrollment -> projectsHHWithOneAdultChild.contains(enrollment.getProjectID())).collect(Collectors.toList());
				List<EnrollmentModel> unknownHouseHold = rentalByClientWithVASHSubsidy.parallelStream().filter(enrollment -> projectsUnknownHouseHold.contains(enrollment.getProjectID())).collect(Collectors.toList());
				
				int withOutChildrenIntSize = withOutChildren != null ?withOutChildren.size() :0 ;
				int withOneAdultChildIntSize = withOneAdultChild != null ?withOneAdultChild.size() :0;
				int withChildrenIntSize = withChildren != null ?withChildren.size() :0;
				int unknownHouseHoldIntSize = unknownHouseHold !=null ?unknownHouseHold.size() :0;
				
				otherLocationOverallTotal.add(BigInteger.valueOf(rentalByClientWithVASHSubsidy.size()));
				otherLocationTotalWithOnlyChild.add(BigInteger.valueOf(withChildrenIntSize));
				otherLocationTotalWOC.add(BigInteger.valueOf(withOutChildrenIntSize));
				otherLocationTotalWCA.add(BigInteger.valueOf(withOneAdultChildIntSize));
				otherLocationTotalUHHT.add(BigInteger.valueOf(unknownHouseHoldIntSize));
				
				q27dResidencePriorToEntryYouthTable.setQ27dC5RentalByClientWithVASHSubsidyTotal(BigInteger.valueOf(rentalByClientWithVASHSubsidy.size()));
				q27dResidencePriorToEntryYouthTable.setQ27dC5RentalByClientWithVASHSubsidyWithoutChild(BigInteger.valueOf(withOutChildrenIntSize));
				q27dResidencePriorToEntryYouthTable.setQ27dC4RentalByClientNoSubsidyWithChildAndAdults(BigInteger.valueOf(withOneAdultChildIntSize));
				q27dResidencePriorToEntryYouthTable.setQ27dC4RentalByClientNoSubsidyWithChildOnly(BigInteger.valueOf(withChildrenIntSize));
				q27dResidencePriorToEntryYouthTable.setQ27dC4RentalByClientNoSubsidyUnknownHouseHoldtype(BigInteger.valueOf(unknownHouseHoldIntSize));
			}
			
			List<EnrollmentModel> rentalByClientWithGPDTIPSubsidy = enrollments.parallelStream().filter(enrollment -> StringUtils.equals("25", enrollment.getLivingSituation())).collect(Collectors.toList());
			if(CollectionUtils.isNotEmpty(rentalByClientWithGPDTIPSubsidy)) {
				List<EnrollmentModel> withChildren = rentalByClientWithGPDTIPSubsidy.parallelStream().filter(enrollment -> projectsHHWithChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
				List<EnrollmentModel> withOutChildren = rentalByClientWithGPDTIPSubsidy.parallelStream().filter(enrollment -> projectsHHWithOutChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
				List<EnrollmentModel> withOneAdultChild = rentalByClientWithGPDTIPSubsidy.parallelStream().filter(enrollment -> projectsHHWithOneAdultChild.contains(enrollment.getProjectID())).collect(Collectors.toList());
				List<EnrollmentModel> unknownHouseHold = rentalByClientWithGPDTIPSubsidy.parallelStream().filter(enrollment -> projectsUnknownHouseHold.contains(enrollment.getProjectID())).collect(Collectors.toList());
				
				int withOutChildrenIntSize = withOutChildren != null ?withOutChildren.size() :0 ;
				int withOneAdultChildIntSize = withOneAdultChild != null ?withOneAdultChild.size() :0;
				int withChildrenIntSize = withChildren != null ?withChildren.size() :0;
				int unknownHouseHoldIntSize = unknownHouseHold !=null ?unknownHouseHold.size() :0;
				
				otherLocationOverallTotal.add(BigInteger.valueOf(rentalByClientWithGPDTIPSubsidy.size()));
				otherLocationTotalWithOnlyChild.add(BigInteger.valueOf(withChildrenIntSize));
				otherLocationTotalWOC.add(BigInteger.valueOf(withOutChildrenIntSize));
				otherLocationTotalWCA.add(BigInteger.valueOf(withOneAdultChildIntSize));
				otherLocationTotalUHHT.add(BigInteger.valueOf(unknownHouseHoldIntSize));
				
				q27dResidencePriorToEntryYouthTable.setQ27dC6RentalByClientWithGPDTIPSubsidyTotal(BigInteger.valueOf(rentalByClientWithGPDTIPSubsidy.size()));
				q27dResidencePriorToEntryYouthTable.setQ27dC6RentalByClientWithGPDTIPSubsidyWithoutChild(BigInteger.valueOf(withOutChildrenIntSize));
				q27dResidencePriorToEntryYouthTable.setQ27dC6RentalByClientWithGPDTIPSubsidyWithChildAndAdults(BigInteger.valueOf(withOneAdultChildIntSize));
				q27dResidencePriorToEntryYouthTable.setQ27dC6RentalByClientWithGPDTIPSubsidyWithChildOnly(BigInteger.valueOf(withChildrenIntSize));
				q27dResidencePriorToEntryYouthTable.setQ27dC6RentalByClientWithGPDTIPSubsidyUnknownHouseHoldtype(BigInteger.valueOf(unknownHouseHoldIntSize));
			}
			
			
			List<EnrollmentModel> rentalByClientWithOtherSubsidy = enrollments.parallelStream().filter(enrollment -> StringUtils.equals("20", enrollment.getLivingSituation())).collect(Collectors.toList());
			if(CollectionUtils.isNotEmpty(rentalByClientWithGPDTIPSubsidy)) {
				List<EnrollmentModel> withChildren = rentalByClientWithOtherSubsidy.parallelStream().filter(enrollment -> projectsHHWithChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
				List<EnrollmentModel> withOutChildren = rentalByClientWithOtherSubsidy.parallelStream().filter(enrollment -> projectsHHWithOutChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
				List<EnrollmentModel> withOneAdultChild = rentalByClientWithOtherSubsidy.parallelStream().filter(enrollment -> projectsHHWithOneAdultChild.contains(enrollment.getProjectID())).collect(Collectors.toList());
				List<EnrollmentModel> unknownHouseHold = rentalByClientWithOtherSubsidy.parallelStream().filter(enrollment -> projectsUnknownHouseHold.contains(enrollment.getProjectID())).collect(Collectors.toList());
				
				int withOutChildrenIntSize = withOutChildren != null ?withOutChildren.size() :0 ;
				int withOneAdultChildIntSize = withOneAdultChild != null ?withOneAdultChild.size() :0;
				int withChildrenIntSize = withChildren != null ?withChildren.size() :0;
				int unknownHouseHoldIntSize = unknownHouseHold !=null ?unknownHouseHold.size() :0;
				
				otherLocationOverallTotal.add(BigInteger.valueOf(rentalByClientWithOtherSubsidy.size()));
				otherLocationTotalWithOnlyChild.add(BigInteger.valueOf(withChildrenIntSize));
				otherLocationTotalWOC.add(BigInteger.valueOf(withOutChildrenIntSize));
				otherLocationTotalWCA.add(BigInteger.valueOf(withOneAdultChildIntSize));
				otherLocationTotalUHHT.add(BigInteger.valueOf(unknownHouseHoldIntSize));
				
				q27dResidencePriorToEntryYouthTable.setQ27dC7RentalByClientWithOtherSubsidyTotal(BigInteger.valueOf(rentalByClientWithOtherSubsidy.size()));
				q27dResidencePriorToEntryYouthTable.setQ27dC7RentalByClientWithOtherSubsidyWithoutChild(BigInteger.valueOf(withOutChildrenIntSize));
				q27dResidencePriorToEntryYouthTable.setQ27dC7RentalByClientWithOtherSubsidyWithChildAndAdults(BigInteger.valueOf(withOneAdultChildIntSize));
				q27dResidencePriorToEntryYouthTable.setQ27dC7RentalByClientWithOtherSubsidyWithChildOnly(BigInteger.valueOf(withChildrenIntSize));
				q27dResidencePriorToEntryYouthTable.setQ27dC7RentalByClientWithOtherSubsidyUnknownHouseHoldtype(BigInteger.valueOf(unknownHouseHoldIntSize));
			}
			
			List<EnrollmentModel> hotelOrMotel = enrollments.parallelStream().filter(enrollment -> StringUtils.equals("14", enrollment.getLivingSituation())).collect(Collectors.toList());
			if(CollectionUtils.isNotEmpty(hotelOrMotel)) {
				List<EnrollmentModel> withChildren = hotelOrMotel.parallelStream().filter(enrollment -> projectsHHWithChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
				List<EnrollmentModel> withOutChildren = hotelOrMotel.parallelStream().filter(enrollment -> projectsHHWithOutChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
				List<EnrollmentModel> withOneAdultChild = hotelOrMotel.parallelStream().filter(enrollment -> projectsHHWithOneAdultChild.contains(enrollment.getProjectID())).collect(Collectors.toList());
				List<EnrollmentModel> unknownHouseHold = hotelOrMotel.parallelStream().filter(enrollment -> projectsUnknownHouseHold.contains(enrollment.getProjectID())).collect(Collectors.toList());
				
				int withOutChildrenIntSize = withOutChildren != null ?withOutChildren.size() :0 ;
				int withOneAdultChildIntSize = withOneAdultChild != null ?withOneAdultChild.size() :0;
				int withChildrenIntSize = withChildren != null ?withChildren.size() :0;
				int unknownHouseHoldIntSize = unknownHouseHold !=null ?unknownHouseHold.size() :0;
				
				otherLocationOverallTotal.add(BigInteger.valueOf(hotelOrMotel.size()));
				otherLocationTotalWithOnlyChild.add(BigInteger.valueOf(withChildrenIntSize));
				otherLocationTotalWOC.add(BigInteger.valueOf(withOutChildrenIntSize));
				otherLocationTotalWCA.add(BigInteger.valueOf(withOneAdultChildIntSize));
				otherLocationTotalUHHT.add(BigInteger.valueOf(unknownHouseHoldIntSize));
				
				q27dResidencePriorToEntryYouthTable.setQ27dC8HotelOrMotelPaidByClientTotal(BigInteger.valueOf(hotelOrMotel.size()));
				q27dResidencePriorToEntryYouthTable.setQ27dC8HotelOrMotelPaidByClientWithoutChild(BigInteger.valueOf(withOutChildrenIntSize));
				q27dResidencePriorToEntryYouthTable.setQ27dC8HotelOrMotelPaidByClientWithChildAndAdults(BigInteger.valueOf(withOneAdultChildIntSize));
				q27dResidencePriorToEntryYouthTable.setQ27dC8HotelOrMotelPaidByClientWithoutChild(BigInteger.valueOf(withChildrenIntSize));
				q27dResidencePriorToEntryYouthTable.setQ27dC8HotelOrMotelPaidByClientUnknownHouseHoldtype(BigInteger.valueOf(unknownHouseHoldIntSize));
			}
			
			
			List<EnrollmentModel> stayingOrLivingWithFriends = enrollments.parallelStream().filter(enrollment -> StringUtils.equals("13", enrollment.getLivingSituation())).collect(Collectors.toList());
			if(CollectionUtils.isNotEmpty(stayingOrLivingWithFriends)) {
				List<EnrollmentModel> withChildren = stayingOrLivingWithFriends.parallelStream().filter(enrollment -> projectsHHWithChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
				List<EnrollmentModel> withOutChildren = stayingOrLivingWithFriends.parallelStream().filter(enrollment -> projectsHHWithOutChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
				List<EnrollmentModel> withOneAdultChild = stayingOrLivingWithFriends.parallelStream().filter(enrollment -> projectsHHWithOneAdultChild.contains(enrollment.getProjectID())).collect(Collectors.toList());
				List<EnrollmentModel> unknownHouseHold = stayingOrLivingWithFriends.parallelStream().filter(enrollment -> projectsUnknownHouseHold.contains(enrollment.getProjectID())).collect(Collectors.toList());
				
				int withOutChildrenIntSize = withOutChildren != null ?withOutChildren.size() :0 ;
				int withOneAdultChildIntSize = withOneAdultChild != null ?withOneAdultChild.size() :0;
				int withChildrenIntSize = withChildren != null ?withChildren.size() :0;
				int unknownHouseHoldIntSize = unknownHouseHold !=null ?unknownHouseHold.size() :0;
				
				otherLocationOverallTotal.add(BigInteger.valueOf(stayingOrLivingWithFriends.size()));
				otherLocationTotalWithOnlyChild.add(BigInteger.valueOf(withChildrenIntSize));
				otherLocationTotalWOC.add(BigInteger.valueOf(withOutChildrenIntSize));
				otherLocationTotalWCA.add(BigInteger.valueOf(withOneAdultChildIntSize));
				otherLocationTotalUHHT.add(BigInteger.valueOf(unknownHouseHoldIntSize));
				
				q27dResidencePriorToEntryYouthTable.setQ27dC9StayingOrLivingWithFriendsTotal(BigInteger.valueOf(stayingOrLivingWithFriends.size()));
				q27dResidencePriorToEntryYouthTable.setQ27dC9StayingOrLivingWithFriendsWithoutChild(BigInteger.valueOf(withOutChildrenIntSize));
				q27dResidencePriorToEntryYouthTable.setQ27dC9StayingOrLivingWithFriendsWithChildAndAdults(BigInteger.valueOf(withOneAdultChildIntSize));
				q27dResidencePriorToEntryYouthTable.setQ27dC9StayingOrLivingWithFriendsWithoutChild(BigInteger.valueOf(withChildrenIntSize));
				q27dResidencePriorToEntryYouthTable.setQ27dC9StayingOrLivingWithFriendsUnknownHouseHoldtype(BigInteger.valueOf(unknownHouseHoldIntSize));
			}
			
			List<EnrollmentModel> stayingOrLivingWithFamily = enrollments.parallelStream().filter(enrollment -> StringUtils.equals("12", enrollment.getLivingSituation())).collect(Collectors.toList());
			if(CollectionUtils.isNotEmpty(stayingOrLivingWithFamily)) {
				List<EnrollmentModel> withChildren = stayingOrLivingWithFamily.parallelStream().filter(enrollment -> projectsHHWithChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
				List<EnrollmentModel> withOutChildren = stayingOrLivingWithFamily.parallelStream().filter(enrollment -> projectsHHWithOutChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
				List<EnrollmentModel> withOneAdultChild = stayingOrLivingWithFamily.parallelStream().filter(enrollment -> projectsHHWithOneAdultChild.contains(enrollment.getProjectID())).collect(Collectors.toList());
				List<EnrollmentModel> unknownHouseHold = stayingOrLivingWithFamily.parallelStream().filter(enrollment -> projectsUnknownHouseHold.contains(enrollment.getProjectID())).collect(Collectors.toList());
				
				int withOutChildrenIntSize = withOutChildren != null ?withOutChildren.size() :0 ;
				int withOneAdultChildIntSize = withOneAdultChild != null ?withOneAdultChild.size() :0;
				int withChildrenIntSize = withChildren != null ?withChildren.size() :0;
				int unknownHouseHoldIntSize = unknownHouseHold !=null ?unknownHouseHold.size() :0;
				
				otherLocationOverallTotal.add(BigInteger.valueOf(stayingOrLivingWithFamily.size()));
				otherLocationTotalWithOnlyChild.add(BigInteger.valueOf(withChildrenIntSize));
				otherLocationTotalWOC.add(BigInteger.valueOf(withOutChildrenIntSize));
				otherLocationTotalWCA.add(BigInteger.valueOf(withOneAdultChildIntSize));
				otherLocationTotalUHHT.add(BigInteger.valueOf(unknownHouseHoldIntSize));
				
				q27dResidencePriorToEntryYouthTable.setQ27dC10StayingOrLivingWithFamilyTotal(BigInteger.valueOf(stayingOrLivingWithFamily.size()));
				q27dResidencePriorToEntryYouthTable.setQ27dC10StayingOrLivingWithFamilyWithoutChild(BigInteger.valueOf(withOutChildrenIntSize));
				q27dResidencePriorToEntryYouthTable.setQ27dC10StayingOrLivingWithFamilyWithChildAndAdults(BigInteger.valueOf(withOneAdultChildIntSize));
				q27dResidencePriorToEntryYouthTable.setQ27dC10StayingOrLivingWithFamilyWithChildOnly(BigInteger.valueOf(withChildrenIntSize));
				q27dResidencePriorToEntryYouthTable.setQ27dC10StayingOrLivingWithFamilyUnknownHouseHoldtype(BigInteger.valueOf(unknownHouseHoldIntSize));
			}
			
			List<EnrollmentModel> dontRefusedWith = enrollments.parallelStream().filter(enrollment -> StringUtils.equals("12", enrollment.getLivingSituation())).collect(Collectors.toList());
			if(CollectionUtils.isNotEmpty(dontRefusedWith)) {
				List<EnrollmentModel> withChildren = dontRefusedWith.parallelStream().filter(enrollment -> projectsHHWithChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
				List<EnrollmentModel> withOutChildren = dontRefusedWith.parallelStream().filter(enrollment -> projectsHHWithOutChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
				List<EnrollmentModel> withOneAdultChild = dontRefusedWith.parallelStream().filter(enrollment -> projectsHHWithOneAdultChild.contains(enrollment.getProjectID())).collect(Collectors.toList());
				List<EnrollmentModel> unknownHouseHold = dontRefusedWith.parallelStream().filter(enrollment -> projectsUnknownHouseHold.contains(enrollment.getProjectID())).collect(Collectors.toList());
				
				int withOutChildrenIntSize = withOutChildren != null ?withOutChildren.size() :0 ;
				int withOneAdultChildIntSize = withOneAdultChild != null ?withOneAdultChild.size() :0;
				int withChildrenIntSize = withChildren != null ?withChildren.size() :0;
				int unknownHouseHoldIntSize = unknownHouseHold !=null ?unknownHouseHold.size() :0;
				
				otherLocationOverallTotal.add(BigInteger.valueOf(dontRefusedWith.size()));
				otherLocationTotalWithOnlyChild.add(BigInteger.valueOf(withChildrenIntSize));
				otherLocationTotalWOC.add(BigInteger.valueOf(withOutChildrenIntSize));
				otherLocationTotalWCA.add(BigInteger.valueOf(withOneAdultChildIntSize));
				otherLocationTotalUHHT.add(BigInteger.valueOf(unknownHouseHoldIntSize));
				
				q27dResidencePriorToEntryYouthTable.setQ27dC12DKRTotal(BigInteger.valueOf(dontRefusedWith.size()));
				q27dResidencePriorToEntryYouthTable.setQ27dC12DKRWithoutChild(BigInteger.valueOf(withOutChildrenIntSize));
				q27dResidencePriorToEntryYouthTable.setQ27dC12DKRWithChildAndAdults(BigInteger.valueOf(withOneAdultChildIntSize));
				q27dResidencePriorToEntryYouthTable.setQ27dC12DKRWithChildOnly(BigInteger.valueOf(withChildrenIntSize));
				q27dResidencePriorToEntryYouthTable.setQ27dC12DKRUnknownHouseHoldtype(BigInteger.valueOf(unknownHouseHoldIntSize));
			}
			
			
			List<EnrollmentModel> informationMissing = enrollments.parallelStream().filter(enrollment -> StringUtils.equals("12", enrollment.getLivingSituation())).collect(Collectors.toList());
			if(CollectionUtils.isNotEmpty(informationMissing)) {
				List<EnrollmentModel> withChildren = informationMissing.parallelStream().filter(enrollment -> projectsHHWithChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
				List<EnrollmentModel> withOutChildren = informationMissing.parallelStream().filter(enrollment -> projectsHHWithOutChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
				List<EnrollmentModel> withOneAdultChild = informationMissing.parallelStream().filter(enrollment -> projectsHHWithOneAdultChild.contains(enrollment.getProjectID())).collect(Collectors.toList());
				List<EnrollmentModel> unknownHouseHold = informationMissing.parallelStream().filter(enrollment -> projectsUnknownHouseHold.contains(enrollment.getProjectID())).collect(Collectors.toList());
				
				int withOutChildrenIntSize = withOutChildren != null ?withOutChildren.size() :0 ;
				int withOneAdultChildIntSize = withOneAdultChild != null ?withOneAdultChild.size() :0;
				int withChildrenIntSize = withChildren != null ?withChildren.size() :0;
				int unknownHouseHoldIntSize = unknownHouseHold !=null ?unknownHouseHold.size() :0;
				
				otherLocationOverallTotal.add(BigInteger.valueOf(informationMissing.size()));
				otherLocationTotalWithOnlyChild.add(BigInteger.valueOf(withChildrenIntSize));
				otherLocationTotalWOC.add(BigInteger.valueOf(withOutChildrenIntSize));
				otherLocationTotalWCA.add(BigInteger.valueOf(withOneAdultChildIntSize));
				otherLocationTotalUHHT.add(BigInteger.valueOf(unknownHouseHoldIntSize));
				
				q27dResidencePriorToEntryYouthTable.setQ27dC13InformationMissingTotal(BigInteger.valueOf(informationMissing.size()));
				q27dResidencePriorToEntryYouthTable.setQ27dC13InformationMissingWithoutChild(BigInteger.valueOf(withOutChildrenIntSize));
				q27dResidencePriorToEntryYouthTable.setQ27dC13InformationMissingWithChildAndAdults(BigInteger.valueOf(withOneAdultChildIntSize));
				q27dResidencePriorToEntryYouthTable.setQ27dC13InformationMissingWithChildOnly(BigInteger.valueOf(withChildrenIntSize));
				q27dResidencePriorToEntryYouthTable.setQ27dC13InformationMissingUnknownHouseHoldtype(BigInteger.valueOf(unknownHouseHoldIntSize));
			}
			
			q27dResidencePriorToEntryYouthTable.setQ27dCzTotTotal(otherLocationOverallTotal);
			q27dResidencePriorToEntryYouthTable.setQ27dCzTotWithoutChild(otherLocationTotalWOC);
			q27dResidencePriorToEntryYouthTable.setQ27dCzTotWithChildAndAdults(otherLocationTotalWithOnlyChild);
			q27dResidencePriorToEntryYouthTable.setQ27dCzTotWithChildOnly(otherLocationTotalWCA);
			q27dResidencePriorToEntryYouthTable.setQ27dCzTotUnknownHouseHoldtype(otherLocationTotalUHHT);
			
			q27dResidencePriorToEntryYouthTable.setQ27dDTotTotal(BigInteger.valueOf(overallTot));
			q27dResidencePriorToEntryYouthTable.setQ27dDTotWithoutChild(otherLocationTotalWOC.add(institutionalSettinTotalWOC).add(homelessSitualtionTotalWOC));
			q27dResidencePriorToEntryYouthTable.setQ27dDTotWithChildAndAdults(otherLocationTotalWCA.add(institutionalSettinTotalWCA).add(homelessSitualtionTotalWCA));
			q27dResidencePriorToEntryYouthTable.setQ27dDTotWithChildOnly(otherLocationTotalWithOnlyChild.add(institutionalSettinTotalWithOnlyChild).add(homelessSitualtionTotalWithOnlyChild));
			q27dResidencePriorToEntryYouthTable.setQ27dDTotUnknownHouseHoldtype(otherLocationTotalUHHT.add(institutionalSettingTotalUHHT).add(homelessSitualtionTotalUHHT));

		} catch (Exception e) {
			logger.error("Error in q27dResidencePriorToEntryYouthTableMaker:" + e);
		}
		}
			return Arrays.asList(q27dResidencePriorToEntryYouthTable);
		}

	}
 