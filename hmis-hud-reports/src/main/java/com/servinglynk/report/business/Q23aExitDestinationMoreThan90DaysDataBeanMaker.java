package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import com.servinglynk.report.bean.Q23aExitDestinationMoreThan90DaysDataBean;

public class Q23aExitDestinationMoreThan90DaysDataBeanMaker {
	
	public static List<Q23aExitDestinationMoreThan90DaysDataBean> getQ23ExitDestinationMoreThan90DaysList(){
		
		Q23aExitDestinationMoreThan90DaysDataBean q23ExitDestinationMoreThan90DaysTable = new Q23aExitDestinationMoreThan90DaysDataBean();
		
				/*q23ExitDestinationMoreThan90DaysTable.setQ23APermanentDestinationsTotal(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23APermanentDestinationsWithoutChild(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23APermanentDestinationsWithChildAndAdults(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23APermanentDestinationsWithOnlyChild(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23APermanentDestinationsUnknownHouseHold(BigInteger.valueOf(0));*/

				q23ExitDestinationMoreThan90DaysTable.setQ23A01MovedFromOneHOPWATotal(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23A01MovedFromOneHOPWAWithoutChild(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23A01MovedFromOneHOPWAWithChildAndAdults(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23A01MovedFromOneHOPWAWithOnlyChild(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23A01MovedFromOneHOPWAUnknownHouseHold(BigInteger.valueOf(0));


				q23ExitDestinationMoreThan90DaysTable.setQ23A02OwnedByClientNoOngoingSubsidyTotal(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23A02OwnedByClientNoOngoingSubsidyWithoutChild(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23A02OwnedByClientNoOngoingSubsidyWithChildAndAdults(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23A02OwnedByClientNoOngoingSubsidyWithOnlyChild(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23A02OwnedByClientNoOngoingSubsidyUnknownHouseHold(BigInteger.valueOf(0));

				q23ExitDestinationMoreThan90DaysTable.setQ23A03OwnedByClientWithOngoingSubsidyTotal(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23A03OwnedByClientWithOngoingSubsidyWithoutChild(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23A03OwnedByClientWithOngoingSubsidyWithChildAndAdults(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23A03OwnedByClientWithOngoingSubsidyWithOnlyChild(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23A03OwnedByClientWithOngoingSubsidyUnknownHouseHold(BigInteger.valueOf(0));

				q23ExitDestinationMoreThan90DaysTable.setQ23A04RentalByClientNoOngoingSubsidyTotal(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23A04RentalByClientNoOngoingSubsidyWithoutChild(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23A04RentalByClientNoOngoingSubsidyWithChildAndAdults(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23A04RentalByClientNoOngoingSubsidyWithOnlyChild(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23A04RentalByClientNoOngoingSubsidyUnknownHouseHold(BigInteger.valueOf(0));

				q23ExitDestinationMoreThan90DaysTable.setQ23A05RentalByClientVASHSubsidyTotal(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23A05RentalByClientVASHSubsidyWithoutChild(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23A05RentalByClientVASHSubsidyWithChildAndAdults(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23A05RentalByClientVASHSubsidyWithOnlyChild(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23A05RentalByClientVASHSubsidyUnknownHouseHold(BigInteger.valueOf(0));

				q23ExitDestinationMoreThan90DaysTable.setQ23A06RentalByClientwithGPDTIPHousingTotal(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23A06RentalByClientwithGPDTIPHousingWithoutChild(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23A06RentalByClientwithGPDTIPHousingWithChildAndAdults(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23A06RentalByClientwithGPDTIPHousingWithOnlyChild(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23A06RentalByClientwithGPDTIPHousingUnknownHouseHold(BigInteger.valueOf(0));

				q23ExitDestinationMoreThan90DaysTable.setQ23A07RentalByClientOtherOngoingSubsidyTotal(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23A07RentalByClientOtherOngoingSubsidyWithoutChild(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23A07RentalByClientOtherOngoingSubsidyWithChildAndAdults(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23A07RentalByClientOtherOngoingSubsidyWithOnlyChild(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23A07RentalByClientOtherOngoingSubsidyUnknownHouseHold(BigInteger.valueOf(0));

				q23ExitDestinationMoreThan90DaysTable.setQ23A08PermanentHousingForHomelessTotal(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23A08PermanentHousingForHomelessWithoutChild(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23A08PermanentHousingForHomelessWithChildAndAdults(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23A08PermanentHousingForHomelessWithOnlyChild(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23A08PermanentHousingForHomelessUnknownHouseHold(BigInteger.valueOf(0));

				q23ExitDestinationMoreThan90DaysTable.setQ23A09StayingOrLivingWithFamilyPermanentTotal(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23A09StayingOrLivingWithFamilyPermanentWithoutChild(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23A09StayingOrLivingWithFamilyPermanentWithChildAndAdults(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23A09StayingOrLivingWithFamilyPermanentWithOnlyChild(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23A09StayingOrLivingWithFamilyPermanentUnknownHouseHold(BigInteger.valueOf(0));

				q23ExitDestinationMoreThan90DaysTable.setQ23A10StayingOrLivingWithFriendsPermanentTotal(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23A10StayingOrLivingWithFriendsPermanentWithoutChild(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23A10StayingOrLivingWithFriendsPermanentWithChildAndAdults(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23A10StayingOrLivingWithFriendsPermanentWithOnlyChild(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23A10StayingOrLivingWithFriendsPermanentUnknownHouseHold(BigInteger.valueOf(0));

				q23ExitDestinationMoreThan90DaysTable.setQ23AzTotTotal(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23AzTotWithoutChild(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23AzTotWithChildAndAdults(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23AzTotWithOnlyChild(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23AzTotUnknownHouseHold(BigInteger.valueOf(0));

				/*q23ExitDestinationMoreThan90DaysTable.setQ23BTemporaryDestinationsTotal(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23BTemporaryDestinationsWithoutChild(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23BTemporaryDestinationsWithChildAndAdults(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23BTemporaryDestinationsWithOnlyChild(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23BTemporaryDestinationsUnknownHouseHold(BigInteger.valueOf(0));*/

				q23ExitDestinationMoreThan90DaysTable.setQ23B1EmergencyShelterTotal(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23B1EmergencyShelterWithoutChild(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23B1EmergencyShelterWithChildAndAdults(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23B1EmergencyShelterWithOnlyChild(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23B1EmergencyShelterUnknownHouseHold(BigInteger.valueOf(0));

				q23ExitDestinationMoreThan90DaysTable.setQ23B2MovedFromOneHOPWATotal(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23B2MovedFromOneHOPWAWithoutChild(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23B2MovedFromOneHOPWAWithChildAndAdults(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23B2MovedFromOneHOPWAWithOnlyChild(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23B2MovedFromOneHOPWAUnknownHouseHold(BigInteger.valueOf(0));

				q23ExitDestinationMoreThan90DaysTable.setQ23B3TransitionalHousingForHomeLessTotal(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23B3TransitionalHousingForHomeLessWithoutChild(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23B3TransitionalHousingForHomeLessWithChildAndAdults(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23B3TransitionalHousingForHomeLessWithOnlyChild(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23B3TransitionalHousingForHomeLessUnknownHouseHold(BigInteger.valueOf(0));

				q23ExitDestinationMoreThan90DaysTable.setQ23B4StayingWithFamilyTemporaryTenureTotal(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23B4StayingWithFamilyTemporaryTenureWithoutChild(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23B4StayingWithFamilyTemporaryTenureWithChildAndAdults(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23B4StayingWithFamilyTemporaryTenureWithOnlyChild(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23B4StayingWithFamilyTemporaryTenureUnknownHouseHold(BigInteger.valueOf(0));

				q23ExitDestinationMoreThan90DaysTable.setQ23B5StayingWithFriendsTemporaryTenureTotal(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23B5StayingWithFriendsTemporaryTenureWithoutChild(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23B5StayingWithFriendsTemporaryTenureWithChildAndAdults(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23B5StayingWithFriendsTemporaryTenureWithOnlyChild(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23B5StayingWithFriendsTemporaryTenureUnknownHouseHold(BigInteger.valueOf(0));

				q23ExitDestinationMoreThan90DaysTable.setQ23B6PlaceNotMeantForHumanHabitationTotal(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23B6PlaceNotMeantForHumanHabitationWithoutChild(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23B6PlaceNotMeantForHumanHabitationWithChildAndAdults(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23B6PlaceNotMeantForHumanHabitationWithOnlyChild(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23B6PlaceNotMeantForHumanHabitationUnknownHouseHold(BigInteger.valueOf(0));

				q23ExitDestinationMoreThan90DaysTable.setQ23B7SafeHavenTotal(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23B7SafeHavenWithoutChild(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23B7SafeHavenWithChildAndAdults(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23B7SafeHavenWithOnlyChild(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23B7SafeHavenUnknownHouseHold(BigInteger.valueOf(0));

				q23ExitDestinationMoreThan90DaysTable.setQ23B8HotelOrMotelPaidByClientTotal(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23B8HotelOrMotelPaidByClientWithoutChild(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23B8HotelOrMotelPaidByClientWithChildAndAdults(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23B8HotelOrMotelPaidByClientWithOnlyChild(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23B8HotelOrMotelPaidByClientUnknownHouseHold(BigInteger.valueOf(0));

				q23ExitDestinationMoreThan90DaysTable.setQ23BzTotTotal(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23BzTotWithoutChild(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23BzTotWithChildAndAdults(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23BzTotWithOnlyChild(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23BzTotUnknownHouseHold(BigInteger.valueOf(0));

				/*q23ExitDestinationMoreThan90DaysTable.setQ23CInstitutionalSettingsTotal(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23CInstitutionalSettingsWithoutChild(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23CInstitutionalSettingsWithChildAndAdults(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23CInstitutionalSettingsWithOnlyChild(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23CInstitutionalSettingsUnknownHouseHold(BigInteger.valueOf(0));*/

				q23ExitDestinationMoreThan90DaysTable.setQ23C1FosterCareHomeOrGroupFosterCareTotal(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23C1FosterCareHomeOrGroupFosterCareWithoutChild(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23C1FosterCareHomeOrGroupFosterCareWithChildAndAdults(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23C1FosterCareHomeOrGroupFosterCareWithOnlyChild(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23C1FosterCareHomeOrGroupFosterCareUnknownHouseHold(BigInteger.valueOf(0));

				q23ExitDestinationMoreThan90DaysTable.setQ23C2PsychiatricHospitalOrOtherTotal(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23C2PsychiatricHospitalOrOtherWithoutChild(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23C2PsychiatricHospitalOrOtherWithChildAndAdults(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23C2PsychiatricHospitalOrOtherWithOnlyChild(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23C2PsychiatricHospitalOrOtherUnknownHouseHold(BigInteger.valueOf(0));

				q23ExitDestinationMoreThan90DaysTable.setQ23C3SubstanceAbuseTreatmentFacilityTotal(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23C3SubstanceAbuseTreatmentFacilityWithoutChild(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23C3SubstanceAbuseTreatmentFacilityWithChildAndAdults(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23C3SubstanceAbuseTreatmentFacilityWithOnlyChild(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23C3SubstanceAbuseTreatmentFacilityUnknownHouseHold(BigInteger.valueOf(0));

				q23ExitDestinationMoreThan90DaysTable.setQ23C4HospitalOrOtherTotal(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23C4HospitalOrOtherWithoutChild(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23C4HospitalOrOtherWithChildAndAdults(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23C4HospitalOrOtherWithOnlyChild(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23C4HospitalOrOtherUnknownHouseHold(BigInteger.valueOf(0));

				q23ExitDestinationMoreThan90DaysTable.setQ23C5JailPrisonOrJuvenileDetentionTotal(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23C5JailPrisonOrJuvenileDetentionWithoutChild(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23C5JailPrisonOrJuvenileDetentionWithChildAndAdults(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23C5JailPrisonOrJuvenileDetentionWithOnlyChild(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23C5JailPrisonOrJuvenileDetentionUnknownHouseHold(BigInteger.valueOf(0));

				q23ExitDestinationMoreThan90DaysTable.setQ23C6LongTermCareFacilityOrNursingHomeTotal(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23C6LongTermCareFacilityOrNursingHomeWithoutChild(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23C6LongTermCareFacilityOrNursingHomeWithChildAndAdults(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23C6LongTermCareFacilityOrNursingHomeWithOnlyChild(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23C6LongTermCareFacilityOrNursingHomeUnknownHouseHold(BigInteger.valueOf(0));

				q23ExitDestinationMoreThan90DaysTable.setQ23CzTotTotal(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23CzTotWithoutChild(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23CzTotWithChildAndAdults(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23CzTotWithOnlyChild(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23CzTotUnknownHouseHold(BigInteger.valueOf(0));

				/*q23ExitDestinationMoreThan90DaysTable.setQ23DOtherDestinationsTotal(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23DOtherDestinationsWithoutChild(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23DOtherDestinationsWithChildAndAdults(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23DOtherDestinationsWithOnlyChild(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23DOtherDestinationsUnknownHouseHold(BigInteger.valueOf(0));*/

				q23ExitDestinationMoreThan90DaysTable.setQ23D1ResidentialProjectorHalfwayHouseTotal(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23D1ResidentialProjectorHalfwayHouseWithoutChild(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23D1ResidentialProjectorHalfwayHouseWithChildAndAdults(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23D1ResidentialProjectorHalfwayHouseWithOnlyChild(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23D1ResidentialProjectorHalfwayHouseUnknownHouseHold(BigInteger.valueOf(0));

				q23ExitDestinationMoreThan90DaysTable.setQ23D2DeceasedTotal(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23D2DeceasedWithoutChild(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23D2DeceasedWithChildAndAdults(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23D2DeceasedWithOnlyChild(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23D2DeceasedUnknownHouseHold(BigInteger.valueOf(0));

				q23ExitDestinationMoreThan90DaysTable.setQ23D3OtherTotal(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23D3OtherWithoutChild(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23D3OtherWithChildAndAdults(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23D3OtherWithOnlyChild(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23D3OtherUnknownHouseHold(BigInteger.valueOf(0));

				q23ExitDestinationMoreThan90DaysTable.setQ23D4DKRTotal(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23D4DKRWithoutChild(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23D4DKRWithChildAndAdults(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23D4DKRWithOnlyChild(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23D4DKRUnknownHouseHold(BigInteger.valueOf(0));

				q23ExitDestinationMoreThan90DaysTable.setQ23D5InfoMissingTotal(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23D5InfoMissingWithoutChild(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23D5InfoMissingWithChildAndAdults(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23D5InfoMissingWithOnlyChild(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23D5InfoMissingUnknownHouseHold(BigInteger.valueOf(0));

				q23ExitDestinationMoreThan90DaysTable.setQ23DzTotTotal(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23DzTotWithoutChild(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23DzTotWithChildAndAdults(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23DzTotWithOnlyChild(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23DzTotUnknownHouseHold(BigInteger.valueOf(0));

				q23ExitDestinationMoreThan90DaysTable.setQ23ETotTotal(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23ETotWithoutChild(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23ETotWithChildAndAdults(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23ETotWithOnlyChild(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23ETotUnknownHouseHold(BigInteger.valueOf(0));
				
				q23ExitDestinationMoreThan90DaysTable.setQ23TotPersonsExistTotal(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23TotPersonsExistWithoutChild(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23TotPersonsExistWithChildAndAdults(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23TotPersonsExistWithOnlyChild(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23TotPersonsExistUnknownHouseHold(BigInteger.valueOf(0));
		
				q23ExitDestinationMoreThan90DaysTable.setQ23TotPersonsDstnsWithoutChild(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23TotPersonsDstnsTotal(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23TotPersonsDstnsUnknownHouseHold(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23TotPersonsDstnsWithOnlyChild(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23TotPersonsDstnsWithChildAndAdults(BigInteger.valueOf(0));
		
				q23ExitDestinationMoreThan90DaysTable.setQ23PercentageWithChildAndAdults(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23PercentageUnknownHouseHold(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23PercentageWithOnlyChild(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23PercentageWithoutChild(BigInteger.valueOf(0));
				q23ExitDestinationMoreThan90DaysTable.setQ23PercentageTotal(BigInteger.valueOf(0));
				
				return Arrays.asList(q23ExitDestinationMoreThan90DaysTable);
		
	}

}
