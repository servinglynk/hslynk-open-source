package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import com.servinglynk.report.bean.Q15DataBean;
import com.servinglynk.report.bean.ReportData;

public class Q15BeanMaker extends BaseBeanMaker {
	
	public static List<Q15DataBean> getQ15ResidencePriorToProgramEntryList(ReportData data) {
		
		int overallTot = data.getNumOfAdults().intValue() + data.getNoOfChildHeadsOfHousehold().intValue();
		
		Q15DataBean q15Bean = new Q15DataBean();
		
		q15Bean.setQ15HomeLessSituationsTotal(BigInteger.valueOf(0));
		q15Bean.setQ15HomeLessSituationsWithoutChildren(BigInteger.valueOf(0));
		q15Bean.setQ15HomeLessSituationWithChildAndAdult(BigInteger.valueOf(0));
		q15Bean.setQ15HomeLessSituationsWithChildOnly(BigInteger.valueOf(0));
		q15Bean.setQ15HomeLessSituationsUnknownHouseHold(BigInteger.valueOf(0));
		
		q15Bean.setQ15EmergencyShelterTotal(BigInteger.valueOf(0));
		q15Bean.setQ15EmergencyShelterWithoutChildren(BigInteger.valueOf(0));
		q15Bean.setQ15EmergencyShelterWithChildAndAdult(BigInteger.valueOf(0));
		q15Bean.setQ15EmergencyShelterWithChildOnly(BigInteger.valueOf(0));
		q15Bean.setQ15EmergencyShelterUnknownHouseHold(BigInteger.valueOf(0));
		
		q15Bean.setQ15TransitionalHousingForhomelessTotal(BigInteger.valueOf(0));
		q15Bean.setQ15TransitionalHousingForhomelessWithoutChildren(BigInteger.valueOf(0));
		q15Bean.setQ15TransitionalHousingForhomelessWithChildAndAdult(BigInteger.valueOf(0));
		q15Bean.setQ15TransitionalHousingForhomelessWithChildOnly(BigInteger.valueOf(0));
		q15Bean.setQ15TransitionalHousingForhomelessUnknownHouseHold(BigInteger.valueOf(0));
		
		q15Bean.setQ15PlaceNotMeantTotal(BigInteger.valueOf(0));
		q15Bean.setQ15PlaceNotMeantWithoutChildren(BigInteger.valueOf(0));
		q15Bean.setQ15PlaceNotMeantWithChildAndAdult(BigInteger.valueOf(0));
		q15Bean.setQ15PlaceNotMeantWithChildOnly(BigInteger.valueOf(0));
		q15Bean.setQ15PlaceNotMeantsUnknownHouseHold(BigInteger.valueOf(0));
		
		q15Bean.setQ15SafeHeavenTotal(BigInteger.valueOf(0));
		q15Bean.setQ15SafeHeavenWithoutChildren(BigInteger.valueOf(0));
		q15Bean.setQ15SafeHeavenWithChildAndAdult(BigInteger.valueOf(0));
		q15Bean.setQ15SafeHeavenWithChildOnly(BigInteger.valueOf(0));
		q15Bean.setQ15SafeHeavenUnknownHouseHold(BigInteger.valueOf(0));
		
		q15Bean.setQ15InterimHousingTotal(BigInteger.valueOf(0));
		q15Bean.setQ15InterimHousingUnknownHouseHold(BigInteger.valueOf(0));
		q15Bean.setQ15InterimHousingWithChildAndAdult(BigInteger.valueOf(0));
		q15Bean.setQ15InterimHousingWithChildOnly(BigInteger.valueOf(0));
		q15Bean.setQ15InterimHousingWithoutChildren(BigInteger.valueOf(0));
		
		q15Bean.setQ15AzTotalSummed(BigInteger.valueOf(0));
		q15Bean.setQ15AzTotalWithoutChildren(BigInteger.valueOf(0));
		q15Bean.setQ15AzTotalWithChildAndAdult(BigInteger.valueOf(0));
		q15Bean.setQ15AzTotalWithChildOnly(BigInteger.valueOf(0));
		q15Bean.setQ15AzTotalUnknownHouseHold(BigInteger.valueOf(0));
		
		q15Bean.setQ15InstitutionalSettingsTotal(BigInteger.valueOf(0));
		q15Bean.setQ15InstitutionalSettingsWithoutChildren(BigInteger.valueOf(0));
		q15Bean.setQ15InstitutionalSettingsWithChildandAdult(BigInteger.valueOf(0));
		q15Bean.setQ15InstitutionalSettingsWithChildOnly(BigInteger.valueOf(0));
		q15Bean.setQ15InstitutionalSettingsUnknowHouseHold(BigInteger.valueOf(0));
		
		q15Bean.setQ15PsychiatricFacilityTotal(BigInteger.valueOf(0));
		q15Bean.setQ15PsychiatricFacilityWithoutChildren(BigInteger.valueOf(0));
		q15Bean.setQ15PsychiatricFacilityWithChildandAdult(BigInteger.valueOf(0));
		q15Bean.setQ15PsychiatricFacilityWithChildOnly(BigInteger.valueOf(0));
		q15Bean.setQ15PsychiatricFacilityUnknownhouseHold(BigInteger.valueOf(0));
		
		q15Bean.setQ15SubstanceAbuseTotal(BigInteger.valueOf(0));
		q15Bean.setQ15SubstanceAbuseWithoutChildren(BigInteger.valueOf(0));
		q15Bean.setQ15SubstanceAbuseWithChildandAdult(BigInteger.valueOf(0));
		q15Bean.setQ15SubstanceAbuseWithChildOnly(BigInteger.valueOf(0));
		q15Bean.setQ15SubstanceAbuseUnknowHouseHold(BigInteger.valueOf(0));
		
		q15Bean.setQ15HospitalNonPhychiatricTotal(BigInteger.valueOf(0));    	
		q15Bean.setQ15HospitalNonPhychiatricWithoutChild(BigInteger.valueOf(0));
		q15Bean.setQ15HospitalNonPhychiatricWithChildOnly(BigInteger.valueOf(0));
		q15Bean.setQ15HospitalNonPhychiatricWithChildandAdult(BigInteger.valueOf(0));
		q15Bean.setQ15HospitalNonPhychiatricUnknownHouseHold(BigInteger.valueOf(0));
		
		q15Bean.setQ15JailPrisonTotal(BigInteger.valueOf(0));
		q15Bean.setQ15JailPrisonWithoutChild(BigInteger.valueOf(0));
		q15Bean.setQ15JailPrisonWithChildandAdult(BigInteger.valueOf(0));
		q15Bean.setQ15JailPrisonWithChildOnly(BigInteger.valueOf(0));
		q15Bean.setQ15JailPrisonUnknowHouseHold(BigInteger.valueOf(0));
		
		q15Bean.setQ15FosterCarehomeTotal(BigInteger.valueOf(0));
		q15Bean.setQ15FosterCarehomeWithoutChild(BigInteger.valueOf(0));
		q15Bean.setQ15FosterCarehomeWithChildandAdult(BigInteger.valueOf(0));
		q15Bean.setQ15FosterCarehomeWithChildOnly(BigInteger.valueOf(0));
		q15Bean.setQ15FosterCarehomeUnknownHouseHold(BigInteger.valueOf(0));
		
		q15Bean.setQ15LongTermCareFacilityTotal(BigInteger.valueOf(0));
		q15Bean.setQ15LongTermCareFacilityWithoutChild(BigInteger.valueOf(0));
		q15Bean.setQ15LongTermCareFacilityWithChildandAdult(BigInteger.valueOf(0));
		q15Bean.setQ15LongTermCareFacilityWithChildOnly(BigInteger.valueOf(0));
		q15Bean.setQ15LongTermCareFacilityUnknowHouseHold(BigInteger.valueOf(0));
		
		q15Bean.setQ15ResidentialProjectTotal(BigInteger.valueOf(0));
		q15Bean.setQ15ResidentialProjectWithoutChild(BigInteger.valueOf(0));
		q15Bean.setQ15ResidentialProjectWithChildandAdult(BigInteger.valueOf(0));
		q15Bean.setQ15ResidentialProjectWithChildOnly(BigInteger.valueOf(0));
		q15Bean.setQ15ResidentialProjectUnknownHouseHold(BigInteger.valueOf(0));
		
		q15Bean.setQ15BzTotalSummed(BigInteger.valueOf(0));
		q15Bean.setQ15BzTotalWithoutChild(BigInteger.valueOf(0));
		q15Bean.setQ15BzTotalWithChildandAdult(BigInteger.valueOf(0));
		q15Bean.setQ15BzTotalWithChildOnly(BigInteger.valueOf(0));
		q15Bean.setQ15BzTotalUnknowHousehold(BigInteger.valueOf(0));
		
		q15Bean.setQ15OtherLocationTotal(BigInteger.valueOf(0));
		q15Bean.setQ15OtherLocationWithoutChild(BigInteger.valueOf(0));
		q15Bean.setQ15OtherLocationWithChildandAdult(BigInteger.valueOf(0));
		q15Bean.setQ15OtherLocationWithChildOnly(BigInteger.valueOf(0));
		q15Bean.setQ15OtherLocationUnkownHousehold(BigInteger.valueOf(0));
		
		q15Bean.setQ15PSHforHomelessPersonsTotal(BigInteger.valueOf(0));
		q15Bean.setQ15PSHforHomelessPersonsWithoutChild(BigInteger.valueOf(0));
		q15Bean.setQ15PSHforHomelessPersonsWithChilandAdult(BigInteger.valueOf(0));
		q15Bean.setQ15PSHforHomelessPersonsWithChildOnly(BigInteger.valueOf(0));
		q15Bean.setQ15PSHforHomelessPersonsUnknowHousehold(BigInteger.valueOf(0));
		
		q15Bean.setQ15OwnedByclientNoSubsidyTotal(BigInteger.valueOf(0));
		q15Bean.setQ15OwnedByclientNoSubsidyWithoutchild(BigInteger.valueOf(0));
		q15Bean.setQ15OwnedByclientNoSubsidyWithChildandAdult(BigInteger.valueOf(0));
		q15Bean.setQ15OwnedByclientNoSubsidyWithChildOnly(BigInteger.valueOf(0));
		q15Bean.setQ15OwnedByclientNoSubsidyUnknowHousehold(BigInteger.valueOf(0));
		    		
		q15Bean.setQ15OwnedByclientWithSubsidyTotal(BigInteger.valueOf(0));
		q15Bean.setQ15OwnedByclientWithSubsidyWithoutchild(BigInteger.valueOf(0));
		q15Bean.setQ15OwnedByclientWithSubsidyWithChildandAdult(BigInteger.valueOf(0));
		q15Bean.setQ15OwnedByclientWithSubsidyWithChildOnly(BigInteger.valueOf(0));
		q15Bean.setQ15OwnedByclientWithSubsidyUnknowHousehold(BigInteger.valueOf(0));

		q15Bean.setQ15RentalByClientNoSubsidyTotal(BigInteger.valueOf(0));
		q15Bean.setQ15RentalByClientNoSubsidyWithoutChild(BigInteger.valueOf(0));
		q15Bean.setQ15RentalByClientNoSubsidyWithChildandAdult(BigInteger.valueOf(0));
		q15Bean.setQ15RentalByClientNoSubsidyWithchildOnly(BigInteger.valueOf(0));
		q15Bean.setQ15RentalByClientNoSubsidyUnknownHousehold(BigInteger.valueOf(0));
		
		q15Bean.setQ15RentalByClientWithVASHSubsidyTotal(BigInteger.valueOf(0));
		q15Bean.setQ15RentalByClientWithVASHSubsidyWithoutChild(BigInteger.valueOf(0));
		q15Bean.setQ15RentalByClientWithVASHSubsidyWithChildOnly(BigInteger.valueOf(0));
		q15Bean.setQ15RentalByClientWithVASHSubsidyWithchildandAdult(BigInteger.valueOf(0));
		q15Bean.setQ15RentalByClientWithVASHSubsidyUnknownHousehold(BigInteger.valueOf(0));
		
		q15Bean.setQ15RentalByClientWithGPDTIPSubsidyTotal(BigInteger.valueOf(0));
		q15Bean.setQ15RentalByClientWithGPDTIPSubsidyWithoutChild(BigInteger.valueOf(0));
		q15Bean.setQ15RentalByClientWithGPDTIPSubsidyWithchildandAdult(BigInteger.valueOf(0));
		q15Bean.setQ15RentalByClientWithGPDTIPSubsidyWithChildOnly(BigInteger.valueOf(0));
		q15Bean.setQ15RentalByClientWithGPDTIPSubsidyUnknownHousehold(BigInteger.valueOf(0));
		
		q15Bean.setQ15RentalByClientWithOtherSubsidyTotal(BigInteger.valueOf(0));
		q15Bean.setQ15RentalByClientWithOtherSubsidyWithoutChild(BigInteger.valueOf(0));
		q15Bean.setQ15RentalByClientWithOtherSubsidyWithChildandAdult(BigInteger.valueOf(0));
		q15Bean.setQ15RentalByClientWithOtherSubsidyWithChildOnly(BigInteger.valueOf(0));
		q15Bean.setQ15RentalByClientWithOtherSubsidyUnknowHousehold(BigInteger.valueOf(0));
		
		q15Bean.setQ15HotelOrMotelTotal(BigInteger.valueOf(0));
		q15Bean.setQ15HotelOrMotelWithoutChild(BigInteger.valueOf(0));
		q15Bean.setQ15HotelOrMotelWithChildOnly(BigInteger.valueOf(0));
		q15Bean.setQ15HotelOrMotelWithChidandAdult(BigInteger.valueOf(0));
		q15Bean.setQ15HotelOrMotelUnkownHousehold(BigInteger.valueOf(0));
		
		q15Bean.setQ15StayingOrLivingWithFriendsTotal(BigInteger.valueOf(0));
		q15Bean.setQ15StayingOrLivingWithFriendsWithoutChild(BigInteger.valueOf(0));
		q15Bean.setQ15StayingOrLivingWithFriendsWithChildandAdult(BigInteger.valueOf(0));
		q15Bean.setQ15StayingOrLivingWithFriendsWithChildOnly(BigInteger.valueOf(0));
		q15Bean.setQ15StayingOrLivingWithFriendsUnknownHousehold(BigInteger.valueOf(0));
		
		q15Bean.setQ15StayingOrLivingWithFamilyTotal(BigInteger.valueOf(0));
		q15Bean.setQ15StayingOrLivingWithFamilyWithoutChild(BigInteger.valueOf(0));
		q15Bean.setQ15StayingOrLivingWithFamilyWithChildandAdult(BigInteger.valueOf(0));
		q15Bean.setQ15StayingOrLivingWithFamilyWithChildOnly(BigInteger.valueOf(0));
		q15Bean.setQ15StayingOrLivingWithFamilyUnknownHousehold(BigInteger.valueOf(0));
		
		q15Bean.setQ15OtherTotal(BigInteger.valueOf(0));
		q15Bean.setQ15OtherWithoutChild(BigInteger.valueOf(0));
		q15Bean.setQ15OtherWithChildandAdult(BigInteger.valueOf(0));
		q15Bean.setQ15OtherWithChildOnly(BigInteger.valueOf(0));
		q15Bean.setQ15OtherUnknownHousehold(BigInteger.valueOf(0));
		
		q15Bean.setQ15DontRefusedTotal(BigInteger.valueOf(0));
		q15Bean.setQ15DontRefusedWithoutChild(BigInteger.valueOf(0));
		q15Bean.setQ15DontRefusedWithChildandAdult(BigInteger.valueOf(0));
		q15Bean.setQ15DontRefusedWithChildOnly(BigInteger.valueOf(0));
		q15Bean.setQ15DontRefusedUnknownHousehold(BigInteger.valueOf(0));
		
		q15Bean.setQ15InformationMissingTotal(BigInteger.valueOf(0));
		q15Bean.setQ15InformationMissingWithoutChild(BigInteger.valueOf(0));
		q15Bean.setQ15InformationMissingUnknownHousehold(BigInteger.valueOf(0));
		q15Bean.setQ15InformationMissingWithChildandAdult(BigInteger.valueOf(0));
		q15Bean.setQ15InformationMissingwithChildOnly(BigInteger.valueOf(0));
		
		q15Bean.setQ15CzTotalSummed(BigInteger.valueOf(0));
		q15Bean.setQ15CzTotalWithoutChild(BigInteger.valueOf(0));
		q15Bean.setQ15CzTotalWithChildOnly(BigInteger.valueOf(0));
		q15Bean.setQ15CzTotalWithChildandAdult(BigInteger.valueOf(0));
		q15Bean.setQ15CzTotalUnknownHousehold(BigInteger.valueOf(0));
		
		q15Bean.setQ15DTotalSummed(BigInteger.valueOf(overallTot));
		q15Bean.setQ15DTotalWithoutChild(BigInteger.valueOf(0));
		q15Bean.setQ15DTotalWithChildandAdult(BigInteger.valueOf(0));
		q15Bean.setQ15DTotalWithChildOnly(BigInteger.valueOf(0));
		q15Bean.setQ15DTotalUnknownHousehold(BigInteger.valueOf(0));

		return Arrays.asList(q15Bean);
	}

}
