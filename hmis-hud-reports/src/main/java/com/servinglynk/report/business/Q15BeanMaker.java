package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.servinglynk.report.bean.Q15ResidencePriorToProgramEntryDataBean;
import com.servinglynk.report.bean.ReportData;
import com.servinglynk.report.model.EnrollmentModel;

public class Q15BeanMaker extends BaseBeanMaker {
	
	public static List<Q15ResidencePriorToProgramEntryDataBean> getQ15ResidencePriorToProgramEntryList(ReportData data) {
		
		
		Q15ResidencePriorToProgramEntryDataBean q15Bean = new Q15ResidencePriorToProgramEntryDataBean();
		if(data.isLiveMode()) {
		try {
		int overallTot = data.getNumOfAdults().intValue() + data.getNoOfChildHeadsOfHousehold().intValue();
			
		List<EnrollmentModel> enrollments = data.getEnrollments();
		
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
		 * 	q15Bean.setQ15HomeLessSituationsTotal(BigInteger.valueOf(emergencyShelter.size()));
			q15Bean.setQ15HomeLessSituationsWithoutChildren(BigInteger.valueOf(withOutChildrenIntSize));
			q15Bean.setQ15HomeLessSituationWithChildAndAdult(BigInteger.valueOf(withOneAdultChildIntSize));
			q15Bean.setQ15HomeLessSituationsWithChildOnly(BigInteger.valueOf(withChildrenIntSize));
			q15Bean.setQ15HomeLessSituationsUnknownHouseHold(BigInteger.valueOf(unknownHouseHoldIntSize));
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
			
			q15Bean.setQ15EmergencyShelterTotal(BigInteger.valueOf(emergencyShelter.size()));
			q15Bean.setQ15EmergencyShelterWithoutChildren(BigInteger.valueOf(withOutChildrenIntSize));
			q15Bean.setQ15EmergencyShelterWithChildAndAdult(BigInteger.valueOf(withOneAdultChildIntSize));
			q15Bean.setQ15EmergencyShelterWithChildOnly(BigInteger.valueOf(withChildrenIntSize));
			q15Bean.setQ15EmergencyShelterUnknownHouseHold(BigInteger.valueOf(unknownHouseHoldIntSize));
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
			
			q15Bean.setQ15TransitionalHousingForhomelessTotal(BigInteger.valueOf(transitionalHousing.size()));
			q15Bean.setQ15TransitionalHousingForhomelessWithoutChildren(BigInteger.valueOf(withOutChildrenIntSize));
			q15Bean.setQ15TransitionalHousingForhomelessWithChildAndAdult(BigInteger.valueOf(withOneAdultChildIntSize));
			q15Bean.setQ15TransitionalHousingForhomelessWithChildOnly(BigInteger.valueOf(withChildrenIntSize));
			q15Bean.setQ15TransitionalHousingForhomelessUnknownHouseHold(BigInteger.valueOf(unknownHouseHoldIntSize));
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
			
			q15Bean.setQ15PlaceNotMeantTotal(BigInteger.valueOf(placeNotMeant.size()));
			q15Bean.setQ15PlaceNotMeantWithoutChildren(BigInteger.valueOf(withOutChildrenIntSize));
			q15Bean.setQ15PlaceNotMeantWithChildAndAdult(BigInteger.valueOf(withOneAdultChildIntSize));
			q15Bean.setQ15PlaceNotMeantWithChildOnly(BigInteger.valueOf(withChildrenIntSize));
			q15Bean.setQ15PlaceNotMeantsUnknownHouseHold(BigInteger.valueOf(unknownHouseHoldIntSize));
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
			
			q15Bean.setQ15SafeHeavenTotal(BigInteger.valueOf(safeHeaven.size()));
			q15Bean.setQ15SafeHeavenWithoutChildren(BigInteger.valueOf(withOutChildrenIntSize));
			q15Bean.setQ15SafeHeavenWithChildAndAdult(BigInteger.valueOf(withOneAdultChildIntSize));
			q15Bean.setQ15SafeHeavenWithChildOnly(BigInteger.valueOf(withChildrenIntSize));
			q15Bean.setQ15SafeHeavenUnknownHouseHold(BigInteger.valueOf(unknownHouseHoldIntSize));
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
			
			q15Bean.setQ15InterimHousingTotal(BigInteger.valueOf(interimHousing.size()));
			q15Bean.setQ15InterimHousingWithoutChildren(BigInteger.valueOf(withOutChildrenIntSize));
			q15Bean.setQ15InterimHousingWithChildAndAdult(BigInteger.valueOf(withOneAdultChildIntSize));
			q15Bean.setQ15InterimHousingWithChildOnly(BigInteger.valueOf(withChildrenIntSize));
			q15Bean.setQ15InterimHousingUnknownHouseHold(BigInteger.valueOf(unknownHouseHoldIntSize));
		}
		
		q15Bean.setQ15AzTotalSummed(homelessSitualtionOverallTotal);
		q15Bean.setQ15AzTotalWithoutChildren(homelessSitualtionTotalWOC);
		q15Bean.setQ15AzTotalWithChildAndAdult(homelessSitualtionTotalWCA);
		q15Bean.setQ15AzTotalWithChildOnly(homelessSitualtionTotalWithOnlyChild);
		q15Bean.setQ15AzTotalUnknownHouseHold(homelessSitualtionTotalUHHT);
		
		
	/*	
		q15Bean.setQ15InstitutionalSettingsTotal(BigInteger.valueOf(0));
		q15Bean.setQ15InstitutionalSettingsWithoutChildren(BigInteger.valueOf(0));
		q15Bean.setQ15InstitutionalSettingsWithChildandAdult(BigInteger.valueOf(0));
		q15Bean.setQ15InstitutionalSettingsWithChildOnly(BigInteger.valueOf(0));
		q15Bean.setQ15InstitutionalSettingsUnknowHouseHold(BigInteger.valueOf(0));
		
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
			
			q15Bean.setQ15PsychiatricFacilityTotal(BigInteger.valueOf(psychiatricFacility.size()));
			q15Bean.setQ15PsychiatricFacilityWithoutChildren(BigInteger.valueOf(withOutChildrenIntSize));
			q15Bean.setQ15PsychiatricFacilityWithChildandAdult(BigInteger.valueOf(withOneAdultChildIntSize));
			q15Bean.setQ15PsychiatricFacilityWithChildOnly(BigInteger.valueOf(withChildrenIntSize));
			q15Bean.setQ15PsychiatricFacilityUnknownhouseHold(BigInteger.valueOf(unknownHouseHoldIntSize));
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
			
			q15Bean.setQ15SubstanceAbuseTotal(BigInteger.valueOf(substanceAbuse.size()));
			q15Bean.setQ15SubstanceAbuseWithoutChildren(BigInteger.valueOf(withOutChildrenIntSize));
			q15Bean.setQ15SubstanceAbuseWithChildandAdult(BigInteger.valueOf(withOneAdultChildIntSize));
			q15Bean.setQ15SubstanceAbuseWithChildOnly(BigInteger.valueOf(withChildrenIntSize));
			q15Bean.setQ15SubstanceAbuseUnknowHouseHold(BigInteger.valueOf(unknownHouseHoldIntSize));
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
			
			q15Bean.setQ15HospitalNonPhychiatricTotal(BigInteger.valueOf(hospitalNonPhychiatric.size()));
			q15Bean.setQ15HospitalNonPhychiatricWithoutChild(BigInteger.valueOf(withOutChildrenIntSize));
			q15Bean.setQ15HospitalNonPhychiatricWithChildandAdult(BigInteger.valueOf(withOneAdultChildIntSize));
			q15Bean.setQ15HospitalNonPhychiatricWithChildOnly(BigInteger.valueOf(withChildrenIntSize));
			q15Bean.setQ15HospitalNonPhychiatricUnknownHouseHold(BigInteger.valueOf(unknownHouseHoldIntSize));
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
			
			q15Bean.setQ15JailPrisonTotal(BigInteger.valueOf(jailPrison.size()));
			q15Bean.setQ15JailPrisonWithoutChild(BigInteger.valueOf(withOutChildrenIntSize));
			q15Bean.setQ15JailPrisonWithChildandAdult(BigInteger.valueOf(withOneAdultChildIntSize));
			q15Bean.setQ15JailPrisonWithChildOnly(BigInteger.valueOf(withChildrenIntSize));
			q15Bean.setQ15JailPrisonUnknowHouseHold(BigInteger.valueOf(unknownHouseHoldIntSize));
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
			
			q15Bean.setQ15FosterCarehomeTotal(BigInteger.valueOf(fosterCarehome.size()));
			q15Bean.setQ15FosterCarehomeWithoutChild(BigInteger.valueOf(withOutChildrenIntSize));
			q15Bean.setQ15FosterCarehomeWithChildandAdult(BigInteger.valueOf(withOneAdultChildIntSize));
			q15Bean.setQ15FosterCarehomeWithChildOnly(BigInteger.valueOf(withChildrenIntSize));
			q15Bean.setQ15FosterCarehomeUnknownHouseHold(BigInteger.valueOf(unknownHouseHoldIntSize));
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
			
			q15Bean.setQ15LongTermCareFacilityTotal(BigInteger.valueOf(longTermCareFacility.size()));
			q15Bean.setQ15LongTermCareFacilityWithoutChild(BigInteger.valueOf(withOutChildrenIntSize));
			q15Bean.setQ15LongTermCareFacilityWithChildandAdult(BigInteger.valueOf(withOneAdultChildIntSize));
			q15Bean.setQ15LongTermCareFacilityWithChildOnly(BigInteger.valueOf(withChildrenIntSize));
			q15Bean.setQ15LongTermCareFacilityUnknowHouseHold(BigInteger.valueOf(unknownHouseHoldIntSize));
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
			
			q15Bean.setQ15ResidentialProjectTotal(BigInteger.valueOf(residentialProject.size()));
			q15Bean.setQ15ResidentialProjectWithoutChild(BigInteger.valueOf(withOutChildrenIntSize));
			q15Bean.setQ15ResidentialProjectWithChildandAdult(BigInteger.valueOf(withOneAdultChildIntSize));
			q15Bean.setQ15ResidentialProjectWithChildOnly(BigInteger.valueOf(withChildrenIntSize));
			q15Bean.setQ15ResidentialProjectUnknownHouseHold(BigInteger.valueOf(unknownHouseHoldIntSize));
		}
		
		q15Bean.setQ15BzTotalSummed(institutionalSettinOverallTotal);
		q15Bean.setQ15BzTotalWithoutChild(institutionalSettinTotalWOC);
		q15Bean.setQ15BzTotalWithChildandAdult(institutionalSettinTotalWCA);
		q15Bean.setQ15BzTotalWithChildOnly(institutionalSettinTotalWithOnlyChild);
		q15Bean.setQ15BzTotalUnknowHousehold(institutionalSettingTotalUHHT);
		
//		q15Bean.setQ15OtherLocationTotal(BigInteger.valueOf(0));
//		q15Bean.setQ15OtherLocationWithoutChild(BigInteger.valueOf(0));
//		q15Bean.setQ15OtherLocationWithChildandAdult(BigInteger.valueOf(0));
//		q15Bean.setQ15OtherLocationWithChildOnly(BigInteger.valueOf(0));
//		q15Bean.setQ15OtherLocationUnkownHousehold(BigInteger.valueOf(0));
		
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
			
			otherLocationOverallTotal=otherLocationOverallTotal.add(BigInteger.valueOf(pshforHomelessPerson.size()));
			otherLocationTotalWithOnlyChild=otherLocationTotalWithOnlyChild=otherLocationTotalWithOnlyChild.add(BigInteger.valueOf(withChildrenIntSize));
			otherLocationTotalWOC=otherLocationTotalWOC.add(BigInteger.valueOf(withOutChildrenIntSize));
			otherLocationTotalWCA=otherLocationTotalWCA.add(BigInteger.valueOf(withOneAdultChildIntSize));
			otherLocationTotalUHHT=otherLocationTotalUHHT.add(BigInteger.valueOf(unknownHouseHoldIntSize));
			
			q15Bean.setQ15PSHforHomelessPersonsTotal(BigInteger.valueOf(pshforHomelessPerson.size()));
			q15Bean.setQ15PSHforHomelessPersonsWithoutChild(BigInteger.valueOf(withOutChildrenIntSize));
			q15Bean.setQ15PSHforHomelessPersonsWithChilandAdult(BigInteger.valueOf(withOneAdultChildIntSize));
			q15Bean.setQ15PSHforHomelessPersonsWithChildOnly(BigInteger.valueOf(withChildrenIntSize));
			q15Bean.setQ15PSHforHomelessPersonsUnknowHousehold(BigInteger.valueOf(unknownHouseHoldIntSize));
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
			
			otherLocationOverallTotal=otherLocationOverallTotal.add(BigInteger.valueOf(ownedByclientNoSubsidy.size()));
			otherLocationTotalWithOnlyChild=otherLocationTotalWithOnlyChild=otherLocationTotalWithOnlyChild.add(BigInteger.valueOf(withChildrenIntSize));
			otherLocationTotalWOC=otherLocationTotalWOC=otherLocationTotalWOC.add(BigInteger.valueOf(withOutChildrenIntSize));
			otherLocationTotalWCA=otherLocationTotalWCA=otherLocationTotalWCA.add(BigInteger.valueOf(withOneAdultChildIntSize));
			otherLocationTotalUHHT=otherLocationTotalUHHT=otherLocationTotalUHHT.add(BigInteger.valueOf(unknownHouseHoldIntSize));
			
			q15Bean.setQ15OwnedByclientNoSubsidyTotal(BigInteger.valueOf(ownedByclientNoSubsidy.size()));
			q15Bean.setQ15OwnedByclientNoSubsidyWithoutchild(BigInteger.valueOf(withOutChildrenIntSize));
			q15Bean.setQ15OwnedByclientNoSubsidyWithChildandAdult(BigInteger.valueOf(withOneAdultChildIntSize));
			q15Bean.setQ15OwnedByclientNoSubsidyWithChildOnly(BigInteger.valueOf(withChildrenIntSize));
			q15Bean.setQ15OwnedByclientNoSubsidyUnknowHousehold(BigInteger.valueOf(unknownHouseHoldIntSize));
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
			
			otherLocationOverallTotal=otherLocationOverallTotal.add(BigInteger.valueOf(ownedByclientWithSubsidy.size()));
			otherLocationTotalWithOnlyChild=otherLocationTotalWithOnlyChild.add(BigInteger.valueOf(withChildrenIntSize));
			otherLocationTotalWOC=otherLocationTotalWOC.add(BigInteger.valueOf(withOutChildrenIntSize));
			otherLocationTotalWCA=otherLocationTotalWCA.add(BigInteger.valueOf(withOneAdultChildIntSize));
			otherLocationTotalUHHT=otherLocationTotalUHHT.add(BigInteger.valueOf(unknownHouseHoldIntSize));
			
			q15Bean.setQ15OwnedByclientWithSubsidyTotal(BigInteger.valueOf(ownedByclientWithSubsidy.size()));
			q15Bean.setQ15OwnedByclientWithSubsidyWithoutchild(BigInteger.valueOf(withOutChildrenIntSize));
			q15Bean.setQ15OwnedByclientWithSubsidyWithChildandAdult(BigInteger.valueOf(withOneAdultChildIntSize));
			q15Bean.setQ15OwnedByclientWithSubsidyWithChildOnly(BigInteger.valueOf(withChildrenIntSize));
			q15Bean.setQ15OwnedByclientWithSubsidyUnknowHousehold(BigInteger.valueOf(unknownHouseHoldIntSize));
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
			
			otherLocationOverallTotal=otherLocationOverallTotal.add(BigInteger.valueOf(rentalByClientNoSubsidy.size()));
			otherLocationTotalWithOnlyChild=otherLocationTotalWithOnlyChild.add(BigInteger.valueOf(withChildrenIntSize));
			otherLocationTotalWOC=otherLocationTotalWOC.add(BigInteger.valueOf(withOutChildrenIntSize));
			otherLocationTotalWCA=otherLocationTotalWCA.add(BigInteger.valueOf(withOneAdultChildIntSize));
			otherLocationTotalUHHT=otherLocationTotalUHHT.add(BigInteger.valueOf(unknownHouseHoldIntSize));
			
			q15Bean.setQ15RentalByClientNoSubsidyTotal(BigInteger.valueOf(rentalByClientNoSubsidy.size()));
			q15Bean.setQ15RentalByClientNoSubsidyWithoutChild(BigInteger.valueOf(withOutChildrenIntSize));
			q15Bean.setQ15RentalByClientNoSubsidyWithChildandAdult(BigInteger.valueOf(withOneAdultChildIntSize));
			q15Bean.setQ15RentalByClientNoSubsidyWithchildOnly(BigInteger.valueOf(withChildrenIntSize));
			q15Bean.setQ15RentalByClientNoSubsidyUnknownHousehold(BigInteger.valueOf(unknownHouseHoldIntSize));
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
			
			otherLocationOverallTotal=otherLocationOverallTotal.add(BigInteger.valueOf(rentalByClientWithVASHSubsidy.size()));
			otherLocationTotalWithOnlyChild=otherLocationTotalWithOnlyChild.add(BigInteger.valueOf(withChildrenIntSize));
			otherLocationTotalWOC=otherLocationTotalWOC.add(BigInteger.valueOf(withOutChildrenIntSize));
			otherLocationTotalWCA=otherLocationTotalWCA.add(BigInteger.valueOf(withOneAdultChildIntSize));
			otherLocationTotalUHHT=otherLocationTotalUHHT.add(BigInteger.valueOf(unknownHouseHoldIntSize));
			
			q15Bean.setQ15RentalByClientWithVASHSubsidyTotal(BigInteger.valueOf(rentalByClientWithVASHSubsidy.size()));
			q15Bean.setQ15RentalByClientWithVASHSubsidyWithoutChild(BigInteger.valueOf(withOutChildrenIntSize));
			q15Bean.setQ15RentalByClientWithVASHSubsidyWithchildandAdult(BigInteger.valueOf(withOneAdultChildIntSize));
			q15Bean.setQ15RentalByClientWithVASHSubsidyWithChildOnly(BigInteger.valueOf(withChildrenIntSize));
			q15Bean.setQ15RentalByClientWithVASHSubsidyUnknownHousehold(BigInteger.valueOf(unknownHouseHoldIntSize));
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
			
			otherLocationOverallTotal=otherLocationOverallTotal.add(BigInteger.valueOf(rentalByClientWithGPDTIPSubsidy.size()));
			otherLocationTotalWithOnlyChild=otherLocationTotalWithOnlyChild.add(BigInteger.valueOf(withChildrenIntSize));
			otherLocationTotalWOC=otherLocationTotalWOC.add(BigInteger.valueOf(withOutChildrenIntSize));
			otherLocationTotalWCA=otherLocationTotalWCA.add(BigInteger.valueOf(withOneAdultChildIntSize));
			otherLocationTotalUHHT=otherLocationTotalUHHT.add(BigInteger.valueOf(unknownHouseHoldIntSize));
			
			q15Bean.setQ15RentalByClientWithGPDTIPSubsidyTotal(BigInteger.valueOf(rentalByClientWithGPDTIPSubsidy.size()));
			q15Bean.setQ15RentalByClientWithGPDTIPSubsidyWithoutChild(BigInteger.valueOf(withOutChildrenIntSize));
			q15Bean.setQ15RentalByClientWithGPDTIPSubsidyWithchildandAdult(BigInteger.valueOf(withOneAdultChildIntSize));
			q15Bean.setQ15RentalByClientWithGPDTIPSubsidyWithChildOnly(BigInteger.valueOf(withChildrenIntSize));
			q15Bean.setQ15RentalByClientWithGPDTIPSubsidyUnknownHousehold(BigInteger.valueOf(unknownHouseHoldIntSize));
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
			
			otherLocationOverallTotal=otherLocationOverallTotal.add(BigInteger.valueOf(rentalByClientWithOtherSubsidy.size()));
			otherLocationTotalWithOnlyChild=otherLocationTotalWithOnlyChild.add(BigInteger.valueOf(withChildrenIntSize));
			otherLocationTotalWOC=otherLocationTotalWOC.add(BigInteger.valueOf(withOutChildrenIntSize));
			otherLocationTotalWCA=otherLocationTotalWCA.add(BigInteger.valueOf(withOneAdultChildIntSize));
			otherLocationTotalUHHT=otherLocationTotalUHHT.add(BigInteger.valueOf(unknownHouseHoldIntSize));
			
			q15Bean.setQ15RentalByClientWithOtherSubsidyTotal(BigInteger.valueOf(rentalByClientWithOtherSubsidy.size()));
			q15Bean.setQ15RentalByClientWithOtherSubsidyWithoutChild(BigInteger.valueOf(withOutChildrenIntSize));
			q15Bean.setQ15RentalByClientWithOtherSubsidyWithChildandAdult(BigInteger.valueOf(withOneAdultChildIntSize));
			q15Bean.setQ15RentalByClientWithOtherSubsidyWithChildOnly(BigInteger.valueOf(withChildrenIntSize));
			q15Bean.setQ15RentalByClientWithOtherSubsidyUnknowHousehold(BigInteger.valueOf(unknownHouseHoldIntSize));
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
			
			otherLocationOverallTotal=otherLocationOverallTotal.add(BigInteger.valueOf(hotelOrMotel.size()));
			otherLocationTotalWithOnlyChild=otherLocationTotalWithOnlyChild.add(BigInteger.valueOf(withChildrenIntSize));
			otherLocationTotalWOC=otherLocationTotalWOC.add(BigInteger.valueOf(withOutChildrenIntSize));
			otherLocationTotalWCA=otherLocationTotalWCA.add(BigInteger.valueOf(withOneAdultChildIntSize));
			otherLocationTotalUHHT=otherLocationTotalUHHT.add(BigInteger.valueOf(unknownHouseHoldIntSize));
			
			q15Bean.setQ15HotelOrMotelTotal(BigInteger.valueOf(hotelOrMotel.size()));
			q15Bean.setQ15HotelOrMotelWithoutChild(BigInteger.valueOf(withOutChildrenIntSize));
			q15Bean.setQ15HotelOrMotelWithChidandAdult(BigInteger.valueOf(withOneAdultChildIntSize));
			q15Bean.setQ15HotelOrMotelWithChildOnly(BigInteger.valueOf(withChildrenIntSize));
			q15Bean.setQ15HotelOrMotelUnkownHousehold(BigInteger.valueOf(unknownHouseHoldIntSize));
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
			
			otherLocationOverallTotal=otherLocationOverallTotal.add(BigInteger.valueOf(stayingOrLivingWithFriends.size()));
			otherLocationTotalWithOnlyChild=otherLocationTotalWithOnlyChild.add(BigInteger.valueOf(withChildrenIntSize));
			otherLocationTotalWOC=otherLocationTotalWOC.add(BigInteger.valueOf(withOutChildrenIntSize));
			otherLocationTotalWCA=otherLocationTotalWCA.add(BigInteger.valueOf(withOneAdultChildIntSize));
			otherLocationTotalUHHT=otherLocationTotalUHHT.add(BigInteger.valueOf(unknownHouseHoldIntSize));
			
			q15Bean.setQ15StayingOrLivingWithFriendsTotal(BigInteger.valueOf(stayingOrLivingWithFriends.size()));
			q15Bean.setQ15StayingOrLivingWithFriendsWithoutChild(BigInteger.valueOf(withOutChildrenIntSize));
			q15Bean.setQ15StayingOrLivingWithFriendsWithChildandAdult(BigInteger.valueOf(withOneAdultChildIntSize));
			q15Bean.setQ15StayingOrLivingWithFriendsWithChildOnly(BigInteger.valueOf(withChildrenIntSize));
			q15Bean.setQ15StayingOrLivingWithFriendsUnknownHousehold(BigInteger.valueOf(unknownHouseHoldIntSize));
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
			
			otherLocationOverallTotal=otherLocationOverallTotal.add(BigInteger.valueOf(stayingOrLivingWithFamily.size()));
			otherLocationTotalWithOnlyChild=otherLocationTotalWithOnlyChild.add(BigInteger.valueOf(withChildrenIntSize));
			otherLocationTotalWOC=otherLocationTotalWOC.add(BigInteger.valueOf(withOutChildrenIntSize));
			otherLocationTotalWCA=otherLocationTotalWCA.add(BigInteger.valueOf(withOneAdultChildIntSize));
			otherLocationTotalUHHT=otherLocationTotalUHHT.add(BigInteger.valueOf(unknownHouseHoldIntSize));
			
			q15Bean.setQ15StayingOrLivingWithFamilyTotal(BigInteger.valueOf(stayingOrLivingWithFamily.size()));
			q15Bean.setQ15StayingOrLivingWithFamilyWithoutChild(BigInteger.valueOf(withOutChildrenIntSize));
			q15Bean.setQ15StayingOrLivingWithFamilyWithChildandAdult(BigInteger.valueOf(withOneAdultChildIntSize));
			q15Bean.setQ15StayingOrLivingWithFamilyWithChildOnly(BigInteger.valueOf(withChildrenIntSize));
			q15Bean.setQ15StayingOrLivingWithFamilyUnknownHousehold(BigInteger.valueOf(unknownHouseHoldIntSize));
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
			
			otherLocationOverallTotal=otherLocationOverallTotal.add(BigInteger.valueOf(dontRefusedWith.size()));
			otherLocationTotalWithOnlyChild=otherLocationTotalWithOnlyChild.add(BigInteger.valueOf(withChildrenIntSize));
			otherLocationTotalWOC=otherLocationTotalWOC.add(BigInteger.valueOf(withOutChildrenIntSize));
			otherLocationTotalWCA=otherLocationTotalWCA.add(BigInteger.valueOf(withOneAdultChildIntSize));
			otherLocationTotalUHHT=otherLocationTotalUHHT.add(BigInteger.valueOf(unknownHouseHoldIntSize));
			
			q15Bean.setQ15DontRefusedTotal(BigInteger.valueOf(dontRefusedWith.size()));
			q15Bean.setQ15DontRefusedWithoutChild(BigInteger.valueOf(withOutChildrenIntSize));
			q15Bean.setQ15DontRefusedWithChildandAdult(BigInteger.valueOf(withOneAdultChildIntSize));
			q15Bean.setQ15DontRefusedWithChildOnly(BigInteger.valueOf(withChildrenIntSize));
			q15Bean.setQ15DontRefusedUnknownHousehold(BigInteger.valueOf(unknownHouseHoldIntSize));
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
			
			otherLocationOverallTotal=otherLocationOverallTotal.add(BigInteger.valueOf(informationMissing.size()));
			otherLocationTotalWithOnlyChild=otherLocationTotalWithOnlyChild.add(BigInteger.valueOf(withChildrenIntSize));
			otherLocationTotalWOC=otherLocationTotalWOC.add(BigInteger.valueOf(withOutChildrenIntSize));
			otherLocationTotalWCA=otherLocationTotalWCA.add(BigInteger.valueOf(withOneAdultChildIntSize));
			otherLocationTotalUHHT=otherLocationTotalUHHT.add(BigInteger.valueOf(unknownHouseHoldIntSize));
			
			q15Bean.setQ15InformationMissingTotal(BigInteger.valueOf(informationMissing.size()));
			q15Bean.setQ15InformationMissingWithoutChild(BigInteger.valueOf(withOutChildrenIntSize));
			q15Bean.setQ15InformationMissingWithChildandAdult(BigInteger.valueOf(withOneAdultChildIntSize));
			q15Bean.setQ15InformationMissingwithChildOnly(BigInteger.valueOf(withChildrenIntSize));
			q15Bean.setQ15InformationMissingUnknownHousehold(BigInteger.valueOf(unknownHouseHoldIntSize));
		}
		
		q15Bean.setQ15CzTotalSummed(otherLocationOverallTotal);
		q15Bean.setQ15CzTotalWithoutChild(otherLocationTotalWOC);
		q15Bean.setQ15CzTotalWithChildOnly(otherLocationTotalWithOnlyChild);
		q15Bean.setQ15CzTotalWithChildandAdult(otherLocationTotalWCA);
		q15Bean.setQ15CzTotalUnknownHousehold(otherLocationTotalUHHT);
		otherLocationTotalWOC=otherLocationTotalWOC.add(institutionalSettinTotalWOC).add(homelessSitualtionTotalWOC);
		otherLocationTotalWithOnlyChild=otherLocationTotalWithOnlyChild.add(institutionalSettinTotalWithOnlyChild).add(homelessSitualtionTotalWithOnlyChild);
		otherLocationTotalUHHT=otherLocationTotalUHHT.add(institutionalSettingTotalUHHT).add(homelessSitualtionTotalUHHT);
		otherLocationTotalWCA=otherLocationTotalWCA.add(institutionalSettinTotalWCA).add(homelessSitualtionTotalWCA);
		
		q15Bean.setQ15DTotalSummed(BigInteger.valueOf(overallTot));
		q15Bean.setQ15DTotalWithoutChild(otherLocationTotalWOC);
		q15Bean.setQ15DTotalWithChildandAdult(otherLocationTotalWCA);
		q15Bean.setQ15DTotalWithChildOnly(otherLocationTotalWOC);
		q15Bean.setQ15DTotalUnknownHousehold(otherLocationTotalUHHT);

	} catch (Exception e) {
		logger.error("Error in Q15BeanMaker:" + e);
	}
	}
		return Arrays.asList(q15Bean);
	}

}
