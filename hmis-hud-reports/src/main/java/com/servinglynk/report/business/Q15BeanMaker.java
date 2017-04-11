package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import com.servinglynk.report.bean.Q15ResidencePriorToProgramEntryDataBean;
import com.servinglynk.report.bean.ReportData;

public class Q15BeanMaker {
	
	public static List<Q15ResidencePriorToProgramEntryDataBean> getQ15ResidencePriorToProgramEntryList(ReportData data) {
		
		int overallTot = data.getNumOfAdults() + data.getNoOfChildHeadsOfHousehold();
		
		Q15ResidencePriorToProgramEntryDataBean q15ResidencePriorToProgramEntrTableBean = new Q15ResidencePriorToProgramEntryDataBean();
		
		q15ResidencePriorToProgramEntrTableBean.setQ15HomeLessSituationsTotal(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15HomeLessSituationsWithoutChildren(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15HomeLessSituationWithChildAndAdult(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15HomeLessSituationsWithChildOnly(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15HomeLessSituationsUnknownHouseHold(BigInteger.valueOf(0));
		
		q15ResidencePriorToProgramEntrTableBean.setQ15EmergencyShelterTotal(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15EmergencyShelterWithoutChildren(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15EmergencyShelterWithChildAndAdult(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15EmergencyShelterWithChildOnly(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15EmergencyShelterUnknownHouseHold(BigInteger.valueOf(0));
		
		q15ResidencePriorToProgramEntrTableBean.setQ15TransitionalHousingForhomelessTotal(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15TransitionalHousingForhomelessWithoutChildren(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15TransitionalHousingForhomelessWithChildAndAdult(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15TransitionalHousingForhomelessWithChildOnly(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15TransitionalHousingForhomelessUnknownHouseHold(BigInteger.valueOf(0));
		
		q15ResidencePriorToProgramEntrTableBean.setQ15PlaceNotMeantTotal(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15PlaceNotMeantWithoutChildren(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15PlaceNotMeantWithChildAndAdult(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15PlaceNotMeantWithChildOnly(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15PlaceNotMeantsUnknownHouseHold(BigInteger.valueOf(0));
		
		q15ResidencePriorToProgramEntrTableBean.setQ15SafeHeavenTotal(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15SafeHeavenWithoutChildren(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15SafeHeavenWithChildAndAdult(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15SafeHeavenWithChildOnly(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15SafeHeavenUnknownHouseHold(BigInteger.valueOf(0));
		
		q15ResidencePriorToProgramEntrTableBean.setQ15InterimHousingTotal(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15InterimHousingUnknownHouseHold(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15InterimHousingWithChildAndAdult(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15InterimHousingWithChildOnly(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15InterimHousingWithoutChildren(BigInteger.valueOf(0));
		
		q15ResidencePriorToProgramEntrTableBean.setQ15AzTotalSummed(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15AzTotalWithoutChildren(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15AzTotalWithChildAndAdult(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15AzTotalWithChildOnly(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15AzTotalUnknownHouseHold(BigInteger.valueOf(0));
		
		q15ResidencePriorToProgramEntrTableBean.setQ15InstitutionalSettingsTotal(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15InstitutionalSettingsWithoutChildren(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15InstitutionalSettingsWithChildandAdult(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15InstitutionalSettingsWithChildOnly(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15InstitutionalSettingsUnknowHouseHold(BigInteger.valueOf(0));
		
		q15ResidencePriorToProgramEntrTableBean.setQ15PsychiatricFacilityTotal(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15PsychiatricFacilityWithoutChildren(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15PsychiatricFacilityWithChildandAdult(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15PsychiatricFacilityWithChildOnly(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15PsychiatricFacilityUnknownhouseHold(BigInteger.valueOf(0));
		
		q15ResidencePriorToProgramEntrTableBean.setQ15SubstanceAbuseTotal(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15SubstanceAbuseWithoutChildren(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15SubstanceAbuseWithChildandAdult(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15SubstanceAbuseWithChildOnly(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15SubstanceAbuseUnknowHouseHold(BigInteger.valueOf(0));
		
		q15ResidencePriorToProgramEntrTableBean.setQ15HospitalNonPhychiatricTotal(BigInteger.valueOf(0));    	
		q15ResidencePriorToProgramEntrTableBean.setQ15HospitalNonPhychiatricWithoutChild(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15HospitalNonPhychiatricWithChildOnly(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15HospitalNonPhychiatricWithChildandAdult(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15HospitalNonPhychiatricUnknownHouseHold(BigInteger.valueOf(0));
		
		q15ResidencePriorToProgramEntrTableBean.setQ15JailPrisonTotal(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15JailPrisonWithoutChild(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15JailPrisonWithChildandAdult(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15JailPrisonWithChildOnly(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15JailPrisonUnknowHouseHold(BigInteger.valueOf(0));
		
		q15ResidencePriorToProgramEntrTableBean.setQ15FosterCarehomeTotal(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15FosterCarehomeWithoutChild(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15FosterCarehomeWithChildandAdult(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15FosterCarehomeWithChildOnly(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15FosterCarehomeUnknownHouseHold(BigInteger.valueOf(0));
		
		q15ResidencePriorToProgramEntrTableBean.setQ15LongTermCareFacilityTotal(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15LongTermCareFacilityWithoutChild(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15LongTermCareFacilityWithChildandAdult(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15LongTermCareFacilityWithChildOnly(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15LongTermCareFacilityUnknowHouseHold(BigInteger.valueOf(0));
		
		q15ResidencePriorToProgramEntrTableBean.setQ15ResidentialProjectTotal(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15ResidentialProjectWithoutChild(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15ResidentialProjectWithChildandAdult(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15ResidentialProjectWithChildOnly(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15ResidentialProjectUnknownHouseHold(BigInteger.valueOf(0));
		
		q15ResidencePriorToProgramEntrTableBean.setQ15BzTotalSummed(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15BzTotalWithoutChild(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15BzTotalWithChildandAdult(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15BzTotalWithChildOnly(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15BzTotalUnknowHousehold(BigInteger.valueOf(0));
		
		q15ResidencePriorToProgramEntrTableBean.setQ15OtherLocationTotal(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15OtherLocationWithoutChild(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15OtherLocationWithChildandAdult(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15OtherLocationWithChildOnly(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15OtherLocationUnkownHousehold(BigInteger.valueOf(0));
		
		q15ResidencePriorToProgramEntrTableBean.setQ15PSHforHomelessPersonsTotal(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15PSHforHomelessPersonsWithoutChild(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15PSHforHomelessPersonsWithChilandAdult(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15PSHforHomelessPersonsWithChildOnly(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15PSHforHomelessPersonsUnknowHousehold(BigInteger.valueOf(0));
		
		q15ResidencePriorToProgramEntrTableBean.setQ15OwnedByclientNoSubsidyTotal(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15OwnedByclientNoSubsidyWithoutchild(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15OwnedByclientNoSubsidyWithChildandAdult(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15OwnedByclientNoSubsidyWithChildOnly(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15OwnedByclientNoSubsidyUnknowHousehold(BigInteger.valueOf(0));
		    		
		q15ResidencePriorToProgramEntrTableBean.setQ15OwnedByclientWithSubsidyTotal(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15OwnedByclientWithSubsidyWithoutchild(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15OwnedByclientWithSubsidyWithChildandAdult(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15OwnedByclientWithSubsidyWithChildOnly(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15OwnedByclientWithSubsidyUnknowHousehold(BigInteger.valueOf(0));

		q15ResidencePriorToProgramEntrTableBean.setQ15RentalByClientNoSubsidyTotal(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15RentalByClientNoSubsidyWithoutChild(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15RentalByClientNoSubsidyWithChildandAdult(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15RentalByClientNoSubsidyWithchildOnly(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15RentalByClientNoSubsidyUnknownHousehold(BigInteger.valueOf(0));
		
		q15ResidencePriorToProgramEntrTableBean.setQ15RentalByClientWithVASHSubsidyTotal(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15RentalByClientWithVASHSubsidyWithoutChild(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15RentalByClientWithVASHSubsidyWithChildOnly(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15RentalByClientWithVASHSubsidyWithchildandAdult(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15RentalByClientWithVASHSubsidyUnknownHousehold(BigInteger.valueOf(0));
		
		q15ResidencePriorToProgramEntrTableBean.setQ15RentalByClientWithGPDTIPSubsidyTotal(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15RentalByClientWithGPDTIPSubsidyWithoutChild(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15RentalByClientWithGPDTIPSubsidyWithchildandAdult(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15RentalByClientWithGPDTIPSubsidyWithChildOnly(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15RentalByClientWithGPDTIPSubsidyUnknownHousehold(BigInteger.valueOf(0));
		
		q15ResidencePriorToProgramEntrTableBean.setQ15RentalByClientWithOtherSubsidyTotal(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15RentalByClientWithOtherSubsidyWithoutChild(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15RentalByClientWithOtherSubsidyWithChildandAdult(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15RentalByClientWithOtherSubsidyWithChildOnly(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15RentalByClientWithOtherSubsidyUnknowHousehold(BigInteger.valueOf(0));
		
		q15ResidencePriorToProgramEntrTableBean.setQ15HotelOrMotelTotal(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15HotelOrMotelWithoutChild(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15HotelOrMotelWithChildOnly(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15HotelOrMotelWithChidandAdult(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15HotelOrMotelUnkownHousehold(BigInteger.valueOf(0));
		
		q15ResidencePriorToProgramEntrTableBean.setQ15StayingOrLivingWithFriendsTotal(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15StayingOrLivingWithFriendsWithoutChild(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15StayingOrLivingWithFriendsWithChildandAdult(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15StayingOrLivingWithFriendsWithChildOnly(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15StayingOrLivingWithFriendsUnknownHousehold(BigInteger.valueOf(0));
		
		q15ResidencePriorToProgramEntrTableBean.setQ15StayingOrLivingWithFamilyTotal(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15StayingOrLivingWithFamilyWithoutChild(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15StayingOrLivingWithFamilyWithChildandAdult(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15StayingOrLivingWithFamilyWithChildOnly(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15StayingOrLivingWithFamilyUnknownHousehold(BigInteger.valueOf(0));
		
		q15ResidencePriorToProgramEntrTableBean.setQ15OtherTotal(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15OtherWithoutChild(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15OtherWithChildandAdult(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15OtherWithChildOnly(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15OtherUnknownHousehold(BigInteger.valueOf(0));
		
		q15ResidencePriorToProgramEntrTableBean.setQ15DontRefusedTotal(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15DontRefusedWithoutChild(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15DontRefusedWithChildandAdult(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15DontRefusedWithChildOnly(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15DontRefusedUnknownHousehold(BigInteger.valueOf(0));
		
		q15ResidencePriorToProgramEntrTableBean.setQ15InformationMissingTotal(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15InformationMissingWithoutChild(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15InformationMissingUnknownHousehold(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15InformationMissingWithChildandAdult(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15InformationMissingwithChildOnly(BigInteger.valueOf(0));
		
		q15ResidencePriorToProgramEntrTableBean.setQ15CzTotalSummed(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15CzTotalWithoutChild(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15CzTotalWithChildOnly(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15CzTotalWithChildandAdult(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15CzTotalUnknownHousehold(BigInteger.valueOf(0));
		
		q15ResidencePriorToProgramEntrTableBean.setQ15DTotalSummed(BigInteger.valueOf(overallTot));
		q15ResidencePriorToProgramEntrTableBean.setQ15DTotalWithoutChild(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15DTotalWithChildandAdult(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15DTotalWithChildOnly(BigInteger.valueOf(0));
		q15ResidencePriorToProgramEntrTableBean.setQ15DTotalUnknownHousehold(BigInteger.valueOf(0));

		return Arrays.asList(q15ResidencePriorToProgramEntrTableBean);
	}

}
