package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import com.servinglynk.report.bean.Q25iExitDestinationVeteransDataBean;

public class Q25iExitDestinationVeteransDataBeanMaker {
	
	public static List<Q25iExitDestinationVeteransDataBean> getQ25iExitDestinationVeteransList(){
		
		Q25iExitDestinationVeteransDataBean q25iExitDestinationVeteransTable = new Q25iExitDestinationVeteransDataBean();
		
				/*q25iExitDestinationVeteransTable.setQ25iAPermanentDestinationsTotal(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iAPermanentDestinationsWithoutChild(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iAPermanentDestinationsWithChildAndAdults(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iAPermanentDestinationsWithOnlyChild(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iAPermanentDestinationsUnknownHouseHold(BigInteger.valueOf(0));*/

				q25iExitDestinationVeteransTable.setQ25iA01MovedFromOneHOPWATotal(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iA01MovedFromOneHOPWAWithoutChild(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iA01MovedFromOneHOPWAWithChildAndAdults(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iA01MovedFromOneHOPWAWithOnlyChild(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iA01MovedFromOneHOPWAUnknownHouseHold(BigInteger.valueOf(0));

				q25iExitDestinationVeteransTable.setQ25iA02OwnedByClientNoOngoingSubsidyTotal(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iA02OwnedByClientNoOngoingSubsidyWithoutChild(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iA02OwnedByClientNoOngoingSubsidyWithChildAndAdults(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iA02OwnedByClientNoOngoingSubsidyWithOnlyChild(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iA02OwnedByClientNoOngoingSubsidyUnknownHouseHold(BigInteger.valueOf(0));

				q25iExitDestinationVeteransTable.setQ25iA03OwnedByClientWithOngoingSubsidyTotal(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iA03OwnedByClientWithOngoingSubsidyWithoutChild(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iA03OwnedByClientWithOngoingSubsidyWithChildAndAdults(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iA03OwnedByClientWithOngoingSubsidyWithOnlyChild(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iA03OwnedByClientWithOngoingSubsidyUnknownHouseHold(BigInteger.valueOf(0));

				q25iExitDestinationVeteransTable.setQ25iA04RentalByClientNoOngoingSubsidyTotal(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iA04RentalByClientNoOngoingSubsidyWithoutChild(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iA04RentalByClientNoOngoingSubsidyWithChildAndAdults(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iA04RentalByClientNoOngoingSubsidyWithOnlyChild(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iA04RentalByClientNoOngoingSubsidyUnknownHouseHold(BigInteger.valueOf(0));

				q25iExitDestinationVeteransTable.setQ25iA05RentalByClientVASHSubsidyTotal(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iA05RentalByClientVASHSubsidyWithoutChild(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iA05RentalByClientVASHSubsidyWithChildAndAdults(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iA05RentalByClientVASHSubsidyWithOnlyChild(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iA05RentalByClientVASHSubsidyUnknownHouseHold(BigInteger.valueOf(0));

				q25iExitDestinationVeteransTable.setQ25iA06RentalByClientwithGPDTIPHousingTotal(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iA06RentalByClientwithGPDTIPHousingWithoutChild(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iA06RentalByClientwithGPDTIPHousingWithChildAndAdults(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iA06RentalByClientwithGPDTIPHousingWithOnlyChild(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iA06RentalByClientwithGPDTIPHousingUnknownHouseHold(BigInteger.valueOf(0));

				q25iExitDestinationVeteransTable.setQ25iA07RentalByClientOtherOngoingSubsidyTotal(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iA07RentalByClientOtherOngoingSubsidyWithoutChild(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iA07RentalByClientOtherOngoingSubsidyWithChildAndAdults(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iA07RentalByClientOtherOngoingSubsidyWithOnlyChild(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iA07RentalByClientOtherOngoingSubsidyUnknownHouseHold(BigInteger.valueOf(0));

				q25iExitDestinationVeteransTable.setQ25iA08PermanentHousingForHomelessTotal(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iA08PermanentHousingForHomelessWithoutChild(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iA08PermanentHousingForHomelessWithChildAndAdults(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iA08PermanentHousingForHomelessWithOnlyChild(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iA08PermanentHousingForHomelessUnknownHouseHold(BigInteger.valueOf(0));

				q25iExitDestinationVeteransTable.setQ25iA09StayingOrLivingWithFamilyPermanentTotal(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iA09StayingOrLivingWithFamilyPermanentWithoutChild(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iA09StayingOrLivingWithFamilyPermanentWithChildAndAdults(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iA09StayingOrLivingWithFamilyPermanentWithOnlyChild(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iA09StayingOrLivingWithFamilyPermanentUnknownHouseHold(BigInteger.valueOf(0));

				q25iExitDestinationVeteransTable.setQ25iA10StayingOrLivingWithFriendsPermanentTotal(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iA10StayingOrLivingWithFriendsPermanentWithoutChild(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iA10StayingOrLivingWithFriendsPermanentWithChildAndAdults(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iA10StayingOrLivingWithFriendsPermanentWithOnlyChild(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iA10StayingOrLivingWithFriendsPermanentUnknownHouseHold(BigInteger.valueOf(0));

				q25iExitDestinationVeteransTable.setQ25iAzTotTotal(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iAzTotWithoutChild(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iAzTotWithChildAndAdults(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iAzTotWithOnlyChild(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iAzTotUnknownHouseHold(BigInteger.valueOf(0));

				/*q25iExitDestinationVeteransTable.setQ25iBTemporaryDestinationsTotal(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iBTemporaryDestinationsWithoutChild(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iBTemporaryDestinationsWithChildAndAdults(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iBTemporaryDestinationsWithOnlyChild(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iBTemporaryDestinationsUnknownHouseHold(BigInteger.valueOf(0));
*/
				q25iExitDestinationVeteransTable.setQ25iB1EmergencyShelterTotal(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iB1EmergencyShelterWithoutChild(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iB1EmergencyShelterWithChildAndAdults(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iB1EmergencyShelterWithOnlyChild(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iB1EmergencyShelterUnknownHouseHold(BigInteger.valueOf(0));

				q25iExitDestinationVeteransTable.setQ25iB2MovedFromOneHOPWATotal(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iB2MovedFromOneHOPWAWithoutChild(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iB2MovedFromOneHOPWAWithChildAndAdults(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iB2MovedFromOneHOPWAWithOnlyChild(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iB2MovedFromOneHOPWAUnknownHouseHold(BigInteger.valueOf(0));

				q25iExitDestinationVeteransTable.setQ25iB3TransitionalHousingForHomelessTotal(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iB3TransitionalHousingForHomelessWithoutChild(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iB3TransitionalHousingForHomelessWithChildAndAdults(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iB3TransitionalHousingForHomelessWithOnlyChild(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iB3TransitionalHousingForHomelessUnknownHouseHold(BigInteger.valueOf(0));

				q25iExitDestinationVeteransTable.setQ25iB4StayingWithFamilyTemporaryTenureTotal(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iB4StayingWithFamilyTemporaryTenureWithoutChild(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iB4StayingWithFamilyTemporaryTenureWithChildAndAdults(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iB4StayingWithFamilyTemporaryTenureWithOnlyChild(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iB4StayingWithFamilyTemporaryTenureUnknownHouseHold(BigInteger.valueOf(0));

				q25iExitDestinationVeteransTable.setQ25iB5StayingWithFriendsTemporaryTenureTotal(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iB5StayingWithFriendsTemporaryTenureWithoutChild(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iB5StayingWithFriendsTemporaryTenureWithChildAndAdults(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iB5StayingWithFriendsTemporaryTenureWithOnlyChild(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iB5StayingWithFriendsTemporaryTenureUnknownHouseHold(BigInteger.valueOf(0));

				q25iExitDestinationVeteransTable.setQ25iB6PlaceNotMeantForHumanHabitationTotal(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iB6PlaceNotMeantForHumanHabitationWithoutChild(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iB6PlaceNotMeantForHumanHabitationWithChildAndAdults(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iB6PlaceNotMeantForHumanHabitationWithOnlyChild(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iB6PlaceNotMeantForHumanHabitationUnknownHouseHold(BigInteger.valueOf(0));

				q25iExitDestinationVeteransTable.setQ25iB7SafeHavenTotal(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iB7SafeHavenWithoutChild(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iB7SafeHavenWithChildAndAdults(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iB7SafeHavenWithOnlyChild(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iB7SafeHavenUnknownHouseHold(BigInteger.valueOf(0));

				q25iExitDestinationVeteransTable.setQ25iB8HotelOrMotelPaidbyClientTotal(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iB8HotelOrMotelPaidbyClientWithoutChild(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iB8HotelOrMotelPaidbyClientWithChildAndAdults(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iB8HotelOrMotelPaidbyClientWithOnlyChild(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iB8HotelOrMotelPaidbyClientUnknownHouseHold(BigInteger.valueOf(0));

				q25iExitDestinationVeteransTable.setQ25iBzTotTotal(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iBzTotWithoutChild(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iBzTotWithChildAndAdults(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iBzTotWithOnlyChild(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iBzTotUnknownHouseHold(BigInteger.valueOf(0));

			/*	q25iExitDestinationVeteransTable.setQ25iCInstitutionalSettingsWithOnlyChild(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iCInstitutionalSettingsTotal(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iCInstitutionalSettingsWithChildAndAdults(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iCInstitutionalSettingsWithoutChild(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iCInstitutionalSettingsUnknownHouseHold(BigInteger.valueOf(0));*/

				q25iExitDestinationVeteransTable.setQ25iC1FosterCareHomeOrGroupFosterCareTotal(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iC1FosterCareHomeOrGroupFosterCareWithoutChild(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iC1FosterCareHomeOrGroupFosterCareWithChildAndAdults(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iC1FosterCareHomeOrGroupFosterCareWithOnlyChild(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iC1FosterCareHomeOrGroupFosterCareUnknownHouseHold(BigInteger.valueOf(0));

				q25iExitDestinationVeteransTable.setQ25iC2PsychiatricHospitalOrOtherTotal(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iC2PsychiatricHospitalOrOtherWithoutChild(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iC2PsychiatricHospitalOrOtherWithChildAndAdults(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iC2PsychiatricHospitalOrOtherWithOnlyChild(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iC2PsychiatricHospitalOrOtherUnknownHouseHold(BigInteger.valueOf(0));

				q25iExitDestinationVeteransTable.setQ25iC3SubstanceAbuseTreatmentFacilityTotal(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iC3SubstanceAbuseTreatmentFacilityWithoutChild(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iC3SubstanceAbuseTreatmentFacilityWithOnlyChild(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iC3SubstanceAbuseTreatmentFacilityWithChildAndAdults(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iC3SubstanceAbuseTreatmentFacilityUnknownHouseHold(BigInteger.valueOf(0));

				q25iExitDestinationVeteransTable.setQ25iC4HospitalOrOtherResidentialTotal(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iC4HospitalOrOtherResidentialWithoutChild(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iC4HospitalOrOtherResidentialWithChildAndAdults(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iC4HospitalOrOtherResidentialWithOnlyChild(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iC4HospitalOrOtherResidentialUnknownHouseHold(BigInteger.valueOf(0));

				q25iExitDestinationVeteransTable.setQ25iC5JailPrisonOrUvenileDetentionTotal(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iC5JailPrisonOrUvenileDetentionWithoutChild(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iC5JailPrisonOrUvenileDetentionWithChildAndAdults(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iC5JailPrisonOrUvenileDetentionWithOnlyChild(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iC5JailPrisonOrUvenileDetentionUnknownHouseHold(BigInteger.valueOf(0));

				q25iExitDestinationVeteransTable.setQ25iC6LongTermCareFacilityTotal(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iC6LongTermCareFacilityWithoutChild(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iC6LongTermCareFacilityWithChildAndAdults(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iC6LongTermCareFacilityWithOnlyChild(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iC6LongTermCareFacilityUnknownHouseHold(BigInteger.valueOf(0));

				q25iExitDestinationVeteransTable.setQ25iCzTotTotal(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iCzTotWithoutChild(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iCzTotWithChildAndAdults(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iCzTotWithOnlyChild(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iCzTotUnknownHouseHold(BigInteger.valueOf(0));

				/*q25iExitDestinationVeteransTable.setQ25iDOtheDrestinationsTotal(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iDOtheDrestinationsWithoutChild(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iDOtheDrestinationsWithChildAndAdults(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iDOtheDrestinationsWithOnlyChild(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iDOtheDrestinationsUnknownHouseHold(BigInteger.valueOf(0));*/

				q25iExitDestinationVeteransTable.setQ25iD1ResidentialProjectTotal(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iD1ResidentialProjectWithoutChild(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iD1ResidentialProjectWithChildAndAdults(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iD1ResidentialProjectWithOnlyChild(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iD1ResidentialProjectUnknownHouseHold(BigInteger.valueOf(0));

				q25iExitDestinationVeteransTable.setQ25iD2DeceasedTotal(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iD2DeceasedWithoutChild(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iD2DeceasedWithChildAndAdults(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iD2DeceasedWithOnlyChild(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iD2DeceasedUnknownHouseHold(BigInteger.valueOf(0));

				q25iExitDestinationVeteransTable.setQ25iD3OtherTotal(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iD3OtherWithoutChild(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iD3OtherWithChildAndAdults(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iD3OtherWithOnlyChild(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iD3OtherUnknownHouseHold(BigInteger.valueOf(0));

				q25iExitDestinationVeteransTable.setQ25iD4DontKnowRefusedTotal(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iD4DontKnowRefusedWithoutChild(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iD4DontKnowRefusedWithChildAndAdults(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iD4DontKnowRefusedWithOnlyChild(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iD4DontKnowRefusedUnknownHouseHold(BigInteger.valueOf(0));

				q25iExitDestinationVeteransTable.setQ25iD5InformationMissingTotal(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iD5InformationMissingWithoutChild(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iD5InformationMissingWithChildAndAdults(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iD5InformationMissingWithOnlyChild(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iD5InformationMissingUnknownHouseHold(BigInteger.valueOf(0));

				q25iExitDestinationVeteransTable.setQ25iDzTotTotal(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iDzTotWithoutChild(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iDzTotWithChildAndAdults(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iDzTotWithOnlyChild(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iDzTotUnknownHouseHold(BigInteger.valueOf(0));

				q25iExitDestinationVeteransTable.setQ25iETotTotal(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iETotWithoutChild(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iETotWithChildAndAdults(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iETotWithOnlyChild(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iETotUnknownHouseHold(BigInteger.valueOf(0));
				
				q25iExitDestinationVeteransTable.setQ25iTotPersonsExistTotal(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iTotPersonsExistUnknownHouseHold(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iTotPersonsExistWithChildAndAdults(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iTotPersonsExistWithOnlyChild(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iTotPersonsExistWithoutChild(BigInteger.valueOf(0));

				q25iExitDestinationVeteransTable.setQ25iTotPersonsDstnTotal(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iTotPersonsDstnUnknownHouseHold(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iTotPersonsDstnWithChildAndAdults(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iTotPersonsDstnWithOnlyChild(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iTotPersonsDstnWithoutChild(BigInteger.valueOf(0));

				q25iExitDestinationVeteransTable.setQ25iPercentageTotal(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iPercentageUnknownHouseHold(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iPercentageWithChildAndAdults(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iPercentageWithOnlyChild(BigInteger.valueOf(0));
				q25iExitDestinationVeteransTable.setQ25iPercentageWithoutChild(BigInteger.valueOf(0));

						
		return Arrays.asList(q25iExitDestinationVeteransTable);
		
	}

}
