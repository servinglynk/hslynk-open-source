package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.servinglynk.report.bean.Q27fExitDestinationYouthDataBean;
import com.servinglynk.report.bean.ReportData;
import com.servinglynk.report.model.Q22BeanModel;

public class Q27fExitDestinationYouthDataBeanMaker extends BaseBeanMaker{
	
	public static List<Q27fExitDestinationYouthDataBean> getQ27fExitDestinationYouthList(ReportData data){
		
		Q27fExitDestinationYouthDataBean q27fExitDestinationYouthTable = new Q27fExitDestinationYouthDataBean();
		
		
		String query = 		  
				" select distinct(e.dedup_client_id ),p.projecttype,p.trackingmethod,p.operatingstartdate,ext.exitdate,e.entrydate,mid.moveindate,e1.destination  from %s.enrollment e join %s.project p  on (e.projectid = p.id  %p ) "+
				" join %s.exit ext on ( e.id = ext.enrollmentid and ext.exitdate >= :startDate  and ext.exitdate <= :endDate) "+
				" join %s.client c on (c.id = e.client_id ) " +
				" join %s.moveindate mid on (e.id = mid.enrollmentid) "+
				" join %s.enrollment e1 on (e.householdid = e1.householdid and e1.relationshipToHoH='1') "+
				" where c.age >= 18 and c.age <= 24 "+  //added a check for youth
				" order by e.dedup_client_id ";	
		
		try {
			if(data.isLiveMode()) {
				List<Q22BeanModel> allData = getQ22BeanLengthOfStay(data, query, null,true,true);
				List<Q22BeanModel> withoutChildren = getQ22BeanLengthOfStay(data, query, data.getProjectsHHWithOutChildren(),false,true);
				List<Q22BeanModel> withChildAndAdults = getQ22BeanLengthOfStay(data, query, data.getProjectsHHWithOneAdultChild(),false,true);
				List<Q22BeanModel> withChildren = getQ22BeanLengthOfStay(data, query, data.getProjectsHHWithChildren(),false,true);
				List<Q22BeanModel> unknown = getQ22BeanLengthOfStay(data, query, data.getProjectsUnknownHouseHold(),false,true);
				//3
				int allTotal3 = getDestination(allData,  "26");
				int allTotal4 = getDestination(allData,  "11");
				int allTotal5 = getDestination(allData,  "21");
				int allTotal6 = getDestination(allData,  "10");
				int allTotal7 = getDestination(allData,  "19");
				int allTotal8 = getDestination(allData,  "28");
				int allTotal9 = getDestination(allData,  "20");
				int allTotal10 = getDestination(allData,  "3");
				int allTotal11 = getDestination(allData,  "22");
				int allTotal12 = getDestination(allData,  "23");
				int allTotal13 = getDestination(allData,  "31");
				
				int withoutChildren3 = getDestination(withoutChildren,  "26");
				int withoutChildren4 = getDestination(withoutChildren,  "11");
				int withoutChildren5 = getDestination(withoutChildren,  "21");
				int withoutChildren6 = getDestination(withoutChildren,  "10");
				int withoutChildren8 = getDestination(withoutChildren,  "19");
				int withoutChildren7 = getDestination(withoutChildren,  "28");
				int withoutChildren9 = getDestination(withoutChildren,  "20");
				int withoutChildren10 = getDestination(withoutChildren,  "3");
				int withoutChildren11 = getDestination(withoutChildren,  "22");
				int withoutChildren12 = getDestination(withoutChildren,  "23");
				int withoutChildren13 = getDestination(withoutChildren,  "31");
				
				
				int withChildAndAdults3 = getDestination(withChildAndAdults,  "26");
				int withChildAndAdults4 = getDestination(withChildAndAdults,  "11");
				int withChildAndAdults5 = getDestination(withChildAndAdults,  "21");
				int withChildAndAdults6 = getDestination(withChildAndAdults,  "10");
				int withChildAndAdults7 = getDestination(withChildAndAdults,  "19");
				int withChildAndAdults8 = getDestination(withChildAndAdults,  "28");
				int withChildAndAdults9 = getDestination(withChildAndAdults,  "20");
				int withChildAndAdults10 = getDestination(withChildAndAdults,  "3");
				int withChildAndAdults11 = getDestination(withChildAndAdults,  "22");
				int withChildAndAdults12 = getDestination(withChildAndAdults,  "23");
				int withChildAndAdults13 = getDestination(withChildAndAdults,  "31");
				
				
				int withChildren3 = getDestination(withChildren,  "26");
				int withChildren4 = getDestination(withChildren,  "11");
				int withChildren5 = getDestination(withChildren,  "21");
				int withChildren6 = getDestination(withChildren,  "10");
				int withChildren7 = getDestination(withChildren,  "19");
				int withChildren8 = getDestination(withChildren,  "28");
				int withChildren9 = getDestination(withChildren,  "20");
				int withChildren10 = getDestination(withChildren,  "3");
				int withChildren11 = getDestination(withChildren,  "22");
				int withChildren12 = getDestination(withChildren,  "23");
				int withChildren13 = getDestination(withChildren,  "31");
				
				int unknown3 = getDestination(unknown,  "26");
				int unknown4 = getDestination(unknown,  "11");
				int unknown5 = getDestination(unknown,  "21");
				int unknown6 = getDestination(unknown,  "10");
				int unknown7 = getDestination(unknown,  "19");
				int unknown8 = getDestination(unknown,  "28");
				int unknown9 = getDestination(unknown,  "20");
				int unknown10 = getDestination(unknown,  "3");
				int unknown11 = getDestination(unknown,  "22");
				int unknown12 = getDestination(unknown,  "23");
				int unknown13 = getDestination(unknown,  "31");
				
	
				//3
				q27fExitDestinationYouthTable.setQ27fA1MovedFromOneHOPWAFundedProjectTotal(BigInteger.valueOf(allTotal3));
				q27fExitDestinationYouthTable.setQ27fA1MovedFromOneHOPWAFundedProjectWithoutChild( BigInteger.valueOf(withoutChildren3) );
				q27fExitDestinationYouthTable.setQ27fA1MovedFromOneHOPWAFundedProjectWithChildAndAdults(BigInteger.valueOf(withChildAndAdults3));
				q27fExitDestinationYouthTable.setQ27fA1MovedFromOneHOPWAFundedProjectWithChildOnly(BigInteger.valueOf(withChildren3) );
				q27fExitDestinationYouthTable.setQ27fA1MovedFromOneHOPWAFundedProjectUnknownHouseHoldtype(BigInteger.valueOf(unknown3));
				//4
				q27fExitDestinationYouthTable.setQ27fA2OwnedByClientNoOngoingSubsidyTotal(BigInteger.valueOf(allTotal4));
				q27fExitDestinationYouthTable.setQ27fA2OwnedByClientNoOngoingSubsidyWithoutChild(BigInteger.valueOf(withoutChildren4) );
				q27fExitDestinationYouthTable.setQ27fA2OwnedByClientNoOngoingSubsidyWithChildAndAdults(BigInteger.valueOf(withChildAndAdults4) );
				q27fExitDestinationYouthTable.setQ27fA2OwnedByClientNoOngoingSubsidyWithChildOnly(BigInteger.valueOf(withChildren4) );
				q27fExitDestinationYouthTable.setQ27fA2OwnedByClientNoOngoingSubsidyUnknownHouseHoldtype(BigInteger.valueOf(unknown4) );
				//5
				q27fExitDestinationYouthTable.setQ27fA3OwnedByClientWithOngoingSubsidyTotal(BigInteger.valueOf(allTotal5));
				q27fExitDestinationYouthTable.setQ27fA3OwnedByClientWithOngoingSubsidyWithoutChild(BigInteger.valueOf(withoutChildren5));
				q27fExitDestinationYouthTable.setQ27fA3OwnedByClientWithOngoingSubsidyWithChildAndAdults(BigInteger.valueOf(withChildAndAdults5));
				q27fExitDestinationYouthTable.setQ27fA3OwnedByClientWithOngoingSubsidyWithChildOnly(BigInteger.valueOf(withChildren5));
				q27fExitDestinationYouthTable.setQ27fA3OwnedByClientWithOngoingSubsidyUnknownHouseHoldtype(BigInteger.valueOf(unknown5));
				//6
				q27fExitDestinationYouthTable.setQ27fA4RentalByClientNoOngoingSubsidyTotal(BigInteger.valueOf(allTotal6));
				q27fExitDestinationYouthTable.setQ27fA4RentalByClientNoOngoingSubsidyWithoutChild(BigInteger.valueOf(withoutChildren6));
				q27fExitDestinationYouthTable.setQ27fA4RentalByClientNoOngoingSubsidyWithChildAndAdults(BigInteger.valueOf(withChildAndAdults6));
				q27fExitDestinationYouthTable.setQ27fA4RentalByClientNoOngoingSubsidyWithChildOnly(BigInteger.valueOf(withChildren6));
				q27fExitDestinationYouthTable.setQ27fA4RentalByClientNoOngoingSubsidyUnknownHouseHoldtype(BigInteger.valueOf(unknown6));
				//7
				q27fExitDestinationYouthTable.setQ27fA5RentalByClientVASHSubsidyTotal(BigInteger.valueOf(allTotal7));
				q27fExitDestinationYouthTable.setQ27fA5RentalByClientVASHSubsidyWithoutChild(BigInteger.valueOf(withoutChildren7));
				q27fExitDestinationYouthTable.setQ27fA5RentalByClientVASHSubsidyWithChildAndAdults(BigInteger.valueOf(withChildAndAdults7));
				q27fExitDestinationYouthTable.setQ27fA5RentalByClientVASHSubsidyWithChildOnly(BigInteger.valueOf(withChildren7));
				q27fExitDestinationYouthTable.setQ27fA5RentalByClientVASHSubsidyUnknownHouseHoldtype(BigInteger.valueOf(unknown7));
				//8
				q27fExitDestinationYouthTable.setQ27fA6RentalByClientWithGPDTIPHousingTotal(BigInteger.valueOf(allTotal8));
				q27fExitDestinationYouthTable.setQ27fA6RentalByClientWithGPDTIPHousingWithoutChild(BigInteger.valueOf(withoutChildren8));
				q27fExitDestinationYouthTable.setQ27fA6RentalByClientWithGPDTIPHousingWithChildAndAdults(BigInteger.valueOf(withChildAndAdults8));
				q27fExitDestinationYouthTable.setQ27fA6RentalByClientWithGPDTIPHousingWithChildOnly(BigInteger.valueOf(withChildren8));
				q27fExitDestinationYouthTable.setQ27fA6RentalByClientWithGPDTIPHousingUnknownHouseHoldtype(BigInteger.valueOf(unknown8));
				//9
				q27fExitDestinationYouthTable.setQ27fA7RentalByClientOtherOngoingSubsidyTotal(BigInteger.valueOf(allTotal9));
				q27fExitDestinationYouthTable.setQ27fA7RentalByClientOtherOngoingSubsidyWithoutChild(BigInteger.valueOf(withoutChildren9));
				q27fExitDestinationYouthTable.setQ27fA7RentalByClientOtherOngoingSubsidyWithChildAndAdults(BigInteger.valueOf(withChildAndAdults9));
				q27fExitDestinationYouthTable.setQ27fA7RentalByClientOtherOngoingSubsidyWithChildOnly(BigInteger.valueOf(withChildren9));
				q27fExitDestinationYouthTable.setQ27fA7RentalByClientOtherOngoingSubsidyUnknownHouseHoldtype(BigInteger.valueOf(unknown9));
				//10
				q27fExitDestinationYouthTable.setQ27fA8PermanentHousingForHomelessTotal(BigInteger.valueOf(allTotal10));
				q27fExitDestinationYouthTable.setQ27fA8PermanentHousingForHomelessWithoutChild(BigInteger.valueOf(withoutChildren10));
				q27fExitDestinationYouthTable.setQ27fA8PermanentHousingForHomelessWithChildAndAdults(BigInteger.valueOf(withChildAndAdults10));
				q27fExitDestinationYouthTable.setQ27fA8PermanentHousingForHomelessWithChildOnly(BigInteger.valueOf(withChildren10));
				q27fExitDestinationYouthTable.setQ27fA8PermanentHousingForHomelessUnknownHouseHoldtype(BigInteger.valueOf(unknown10));
				//11
				q27fExitDestinationYouthTable.setQ27fA9StayingOrLivingWithFamilyPermanentTotal(BigInteger.valueOf(allTotal11));
				q27fExitDestinationYouthTable.setQ27fA9StayingOrLivingWithFamilyPermanentWithoutChild((BigInteger.valueOf(withoutChildren11)));
				q27fExitDestinationYouthTable.setQ27fA9StayingOrLivingWithFamilyPermanentWithChildAndAdults(BigInteger.valueOf(withChildAndAdults11));
				q27fExitDestinationYouthTable.setQ27fA9StayingOrLivingWithFamilyPermanentWithChildOnly(BigInteger.valueOf(withChildren11));
				q27fExitDestinationYouthTable.setQ27fA9StayingOrLivingWithFamilyPermanentUnknownHouseHoldtype(BigInteger.valueOf(unknown11));
				//12
				q27fExitDestinationYouthTable.setQ27fA10StayingOrLivingWithFriendsPermanentTotal(BigInteger.valueOf(allTotal12));
				q27fExitDestinationYouthTable.setQ27fA10StayingOrLivingWithFriendsPermanentWithoutChild(BigInteger.valueOf(withoutChildren12));
				q27fExitDestinationYouthTable.setQ27fA10StayingOrLivingWithFriendsPermanentWithChildAndAdults(BigInteger.valueOf(withChildAndAdults12));
				q27fExitDestinationYouthTable.setQ27fA10StayingOrLivingWithFriendsPermanentWithChildOnly(BigInteger.valueOf(withChildren12));
				q27fExitDestinationYouthTable.setQ27fA10StayingOrLivingWithFriendsPermanentUnknownHouseHoldtype(BigInteger.valueOf(unknown12));
				
				int subTotal1AllData = allTotal3 + allTotal4+ allTotal5+ allTotal6+ allTotal7 + allTotal8 + allTotal9 + allTotal10 + allTotal11 + allTotal12 + allTotal13;
				int subTotal1WithoutChild = withoutChildren3 + withoutChildren4+ withoutChildren5+ withoutChildren6+ withoutChildren7 + withoutChildren8 + withoutChildren9 + withoutChildren10 + withoutChildren11 + withoutChildren12 + withoutChildren13;
				int subTotal1WithChildAndAdults = withChildAndAdults3 + withChildAndAdults4+ withChildAndAdults5+ withChildAndAdults6+ withChildAndAdults7 + withChildAndAdults8 + withChildAndAdults9 + withChildAndAdults10 + withChildAndAdults11 + withChildAndAdults12 + withChildAndAdults13;
				int subTotal1WithChildren = withChildren3 + withChildren4+ withChildren5+ withChildren6+ withChildren7 + withChildren8 + withChildren9 + withChildren10 + withChildren11 + withChildren12 + withChildren13;
				int subTotal1Unknown = unknown3 + unknown4+ unknown5+ unknown6+ unknown7 + unknown8 + unknown9 + unknown10 + unknown11 + unknown12 + unknown13;
				
				
				//Sandeep TODO :  Missing row for # 13 Rental by client, with RRH or equivalent subsidy
				//14
				q27fExitDestinationYouthTable.setQ27fAzTotTotal(BigInteger.valueOf(subTotal1AllData));
				q27fExitDestinationYouthTable.setQ27fAzTotWithoutChild(BigInteger.valueOf(subTotal1WithoutChild));
				q27fExitDestinationYouthTable.setQ27fAzTotWithChildAndAdults(BigInteger.valueOf(subTotal1WithChildAndAdults));
				q27fExitDestinationYouthTable.setQ27fAzTotWithChildOnly(BigInteger.valueOf(subTotal1WithChildren));
				q27fExitDestinationYouthTable.setQ27fAzTotUnknownHouseHoldtype(BigInteger.valueOf(subTotal1Unknown));
				// Permanent Housing sub total above
				
//				q27fExitDestinationYouthTable.setQ27fBTemporaryDestinationsTotal(BigInteger.valueOf(0));
//				q27fExitDestinationYouthTable.setQ27fBTemporaryDestinationsWithoutChild(BigInteger.valueOf(0));
//				q27fExitDestinationYouthTable.setQ27fBTemporaryDestinationsWithChildAndAdults(BigInteger.valueOf(0));
//				q27fExitDestinationYouthTable.setQ27fBTemporaryDestinationsWithChildOnly(BigInteger.valueOf(0));
//				q27fExitDestinationYouthTable.setQ27fBTemporaryDestinationsUnknownHouseHoldtype(BigInteger.valueOf(0));

				int allTotal16 = getDestination(allData,  "1");
				int allTotal17 = getDestination(allData,  "27");
				int allTotal18 = getDestination(allData,  "2");
				int allTotal19 = getDestination(allData,  "12");
				int allTotal20 = getDestination(allData,  "13");
				int allTotal21 = getDestination(allData,  "16");
				int allTotal22 = getDestination(allData,  "18");
				int allTotal23 = getDestination(allData,  "14");
				
				int withoutChildren16 = getDestination(withoutChildren,  "1");
				int withoutChildren17 = getDestination(withoutChildren,  "27");
				int withoutChildren18 = getDestination(withoutChildren,  "2");
				int withoutChildren19 = getDestination(withoutChildren,  "12");
				int withoutChildren20 = getDestination(withoutChildren,  "13");
				int withoutChildren21 = getDestination(withoutChildren,  "16");
				int withoutChildren22 = getDestination(withoutChildren,  "18");
				int withoutChildren23 = getDestination(withoutChildren,  "14");
				
				int withChildAndAdult16 = getDestination(withChildAndAdults,  "1");
				int withChildAndAdult17 = getDestination(withChildAndAdults,  "27");
				int withChildAndAdult18 = getDestination(withChildAndAdults,  "2");
				int withChildAndAdult19 = getDestination(withChildAndAdults,  "12");
				int withChildAndAdult20 = getDestination(withChildAndAdults,  "13");
				int withChildAndAdult21 = getDestination(withChildAndAdults,  "16");
				int withChildAndAdult22 = getDestination(withChildAndAdults,  "18");
				int withChildAndAdult23 = getDestination(withChildAndAdults,  "14");
				
				int withChildren16 = getDestination(withChildren,  "1");
				int withChildren17 = getDestination(withChildren,  "27");
				int withChildren18 = getDestination(withChildren,  "2");
				int withChildren19 = getDestination(withChildren,  "12");
				int withChildren20 = getDestination(withChildren,  "13");
				int withChildren21 = getDestination(withChildren,  "16");
				int withChildren22 = getDestination(withChildren,  "18");
				int withChildren23 = getDestination(withChildren,  "14");
				
				int unknown16 = getDestination(unknown,  "1");
				int unknown17 = getDestination(unknown,  "27");
				int unknown18 = getDestination(unknown,  "2");
				int unknown19 = getDestination(unknown,  "12");
				int unknown20 = getDestination(unknown,  "13");
				int unknown21 = getDestination(unknown,  "16");
				int unknown22 = getDestination(unknown,  "18");
				int unknown23 = getDestination(unknown,  "14");
				
				int subTotal2AllData =  allTotal16+ allTotal17 + allTotal18 + allTotal19 + allTotal20 + allTotal21 + allTotal22 + allTotal23;
				int subTotal2WithoutChild =  withoutChildren16+ withoutChildren17 + withoutChildren18 + withoutChildren19 + withoutChildren20 + withoutChildren21 + withoutChildren22 + withoutChildren23;
				int subTotal2WithChildAndAdults = withChildAndAdult16 + withChildAndAdult17 + withChildAndAdult18 + withChildAndAdult19 + withChildAndAdult20 + withChildAndAdult21 + withChildAndAdult22 + withChildAndAdult23;
				int subTotal2WithChildren =  withChildren16+ withChildren17 + withChildren18 + withChildren19 + withChildren20 + withChildren21 + withChildren22 + withChildren23;
				int subTotal2Unknown = unknown16+ unknown17 + unknown18 + unknown19 + unknown20 + unknown21 + unknown22 + unknown23;
				
				//16
				q27fExitDestinationYouthTable.setQ27fB1EmergencyShelterTotal(BigInteger.valueOf(allTotal16));
				q27fExitDestinationYouthTable.setQ27fB1EmergencyShelterWithoutChild(BigInteger.valueOf(withoutChildren16));
				q27fExitDestinationYouthTable.setQ27fB1EmergencyShelterWithChildAndAdults(BigInteger.valueOf(withChildAndAdult16));
				q27fExitDestinationYouthTable.setQ27fB1EmergencyShelterWithChildOnly(BigInteger.valueOf(withChildren16));
				q27fExitDestinationYouthTable.setQ27fB1EmergencyShelterUnknownHouseHoldtype(BigInteger.valueOf(unknown16));
				//17
				q27fExitDestinationYouthTable.setQ27fB2MovedFromOneHOPWAFundedProjectTotal(BigInteger.valueOf(allTotal17));
				q27fExitDestinationYouthTable.setQ27fB2MovedFromOneHOPWAFundedProjectWithoutChild(BigInteger.valueOf(withoutChildren17));
				q27fExitDestinationYouthTable.setQ27fB2MovedFromOneHOPWAFundedProjectWithChildAndAdults(BigInteger.valueOf(withChildAndAdult17));
				q27fExitDestinationYouthTable.setQ27fB2MovedFromOneHOPWAFundedProjectWithChildOnly(BigInteger.valueOf(withChildren17));
				q27fExitDestinationYouthTable.setQ27fB2MovedFromOneHOPWAFundedProjectUnknownHouseHoldtype(BigInteger.valueOf(unknown17));
				//18
				q27fExitDestinationYouthTable.setQ27fB3TransitionalHousingForHomelessTotal(BigInteger.valueOf(allTotal18));
				q27fExitDestinationYouthTable.setQ27fB3TransitionalHousingForHomelessWithoutChild(BigInteger.valueOf(withoutChildren18));
				q27fExitDestinationYouthTable.setQ27fB3TransitionalHousingForHomelessWithChildAndAdults(BigInteger.valueOf(withChildAndAdult18));
				q27fExitDestinationYouthTable.setQ27fB3TransitionalHousingForHomelessWithChildOnly(BigInteger.valueOf(withChildren18));
				q27fExitDestinationYouthTable.setQ27fB3TransitionalHousingForHomelessUnknownHouseHoldtype(BigInteger.valueOf(unknown18));
				//19
				q27fExitDestinationYouthTable.setQ27fB4StayingWithFamilyTemporaryTenureTotal(BigInteger.valueOf(allTotal19));
				q27fExitDestinationYouthTable.setQ27fB4StayingWithFamilyTemporaryTenureWithoutChild(BigInteger.valueOf(withoutChildren19));
				q27fExitDestinationYouthTable.setQ27fB4StayingWithFamilyTemporaryTenureWithChildAndAdults(BigInteger.valueOf(withChildAndAdult19));
				q27fExitDestinationYouthTable.setQ27fB4StayingWithFamilyTemporaryTenureWithChildOnly(BigInteger.valueOf(withChildren19));
				q27fExitDestinationYouthTable.setQ27fB4StayingWithFamilyTemporaryTenureUnknownHouseHoldtype(BigInteger.valueOf(unknown19));
				//20
				q27fExitDestinationYouthTable.setQ27fB5StayingWithFriendsTemporaryTenureTotal(BigInteger.valueOf(allTotal20));
				q27fExitDestinationYouthTable.setQ27fB5StayingWithFriendsTemporaryTenureWithoutChild(BigInteger.valueOf(withoutChildren20));
				q27fExitDestinationYouthTable.setQ27fB5StayingWithFriendsTemporaryTenureWithChildAndAdults(BigInteger.valueOf(withChildAndAdult20));
				q27fExitDestinationYouthTable.setQ27fB5StayingWithFriendsTemporaryTenureWithChildOnly(BigInteger.valueOf(withChildren20));
				q27fExitDestinationYouthTable.setQ27fB5StayingWithFriendsTemporaryTenureUnknownHouseHoldtype(BigInteger.valueOf(unknown20));
				//21
				q27fExitDestinationYouthTable.setQ27fB6PlaceNotMeantForHumanHabitationTotal(BigInteger.valueOf(allTotal21));
				q27fExitDestinationYouthTable.setQ27fB6PlaceNotMeantForHumanHabitationWithoutChild(BigInteger.valueOf(withoutChildren21));
				q27fExitDestinationYouthTable.setQ27fB6PlaceNotMeantForHumanHabitationWithChildAndAdults(BigInteger.valueOf(withChildAndAdult21));
				q27fExitDestinationYouthTable.setQ27fB6PlaceNotMeantForHumanHabitationWithChildOnly(BigInteger.valueOf(withChildren21));
				q27fExitDestinationYouthTable.setQ27fB6PlaceNotMeantForHumanHabitationUnknownHouseHoldtype(BigInteger.valueOf(unknown21));
				//22
				q27fExitDestinationYouthTable.setQ27fB7SafeHavenTotal(BigInteger.valueOf(allTotal22));
				q27fExitDestinationYouthTable.setQ27fB7SafeHavenWithoutChild(BigInteger.valueOf(withoutChildren22));
				q27fExitDestinationYouthTable.setQ27fB7SafeHavenWithChildAndAdults(BigInteger.valueOf(withChildAndAdult22));
				q27fExitDestinationYouthTable.setQ27fB7SafeHavenWithChildOnly(BigInteger.valueOf(withChildren22));
				q27fExitDestinationYouthTable.setQ27fB7SafeHavenUnknownHouseHoldtype(BigInteger.valueOf(unknown22));
				//23
				q27fExitDestinationYouthTable.setQ27fB8HotelOrMotelPaidByClientTotal(BigInteger.valueOf(allTotal23));
				q27fExitDestinationYouthTable.setQ27fB8HotelOrMotelPaidByClientWithoutChild(BigInteger.valueOf(withoutChildren23));
				q27fExitDestinationYouthTable.setQ27fB8HotelOrMotelPaidByClientWithChildAndAdults(BigInteger.valueOf(withChildAndAdult23));
				q27fExitDestinationYouthTable.setQ27fB8HotelOrMotelPaidByClientWithChildOnly(BigInteger.valueOf(withChildren23));
				q27fExitDestinationYouthTable.setQ27fB8HotelOrMotelPaidByClientUnknownHouseHoldtype(BigInteger.valueOf(unknown23));
				
				//24
				q27fExitDestinationYouthTable.setQ27fBzTotTotal(BigInteger.valueOf(subTotal2AllData));
				q27fExitDestinationYouthTable.setQ27fBzTotWithoutChild(BigInteger.valueOf(subTotal2WithoutChild));
				q27fExitDestinationYouthTable.setQ27fBzTotWithChildAndAdults(BigInteger.valueOf(subTotal2WithChildAndAdults));
				q27fExitDestinationYouthTable.setQ27fBzTotWithChildOnly(BigInteger.valueOf(subTotal2WithChildren));
				q27fExitDestinationYouthTable.setQ27fBzTotUnknownHouseHoldtype(BigInteger.valueOf(subTotal2Unknown));
				// Temp Housing sub total above
				
				//Sandeep TODO : need to remove the below  row or it can be empty string.
//				q27fExitDestinationYouthTable.setQ27fBCInstitutionalSettingsTotal(BigInteger.valueOf(0));
//				q27fExitDestinationYouthTable.setQ27fBCInstitutionalSettingsWithoutChild(BigInteger.valueOf(0));
//				q27fExitDestinationYouthTable.setQ27fBCInstitutionalSettingsWithChildAndAdults(BigInteger.valueOf(0));
//				q27fExitDestinationYouthTable.setQ27fBCInstitutionalSettingsWithChildOnly(BigInteger.valueOf(0));
//				q27fExitDestinationYouthTable.setQ27fBCInstitutionalSettingsUnknownHouseHoldtype(BigInteger.valueOf(0));
				
				
				int allTotal26 = getDestination(allData,  "15");
				int allTotal27 = getDestination(allData,  "4");
				int allTotal28 = getDestination(allData,  "5");
				int allTotal29 = getDestination(allData,  "6");
				int allTotal30 = getDestination(allData,  "7");
				int allTotal31 = getDestination(allData,  "25");
				
				int withoutChildren26 = getDestination(withoutChildren,  "15");
				int withoutChildren27 = getDestination(withoutChildren,  "4");
				int withoutChildren28 = getDestination(withoutChildren,  "5");
				int withoutChildren29 = getDestination(withoutChildren,  "6");
				int withoutChildren30 = getDestination(withoutChildren,  "7");
				int withoutChildren31 = getDestination(withoutChildren,  "25");
				
				int withChildAndAdult26 = getDestination(withChildAndAdults,  "15");
				int withChildAndAdult27 = getDestination(withChildAndAdults,  "4");
				int withChildAndAdult28 = getDestination(withChildAndAdults,  "5");
				int withChildAndAdult29 = getDestination(withChildAndAdults,  "6");
				int withChildAndAdult30 = getDestination(withChildAndAdults,  "7");
				int withChildAndAdult31 = getDestination(withChildAndAdults,  "25");
				
				int withChildren26 = getDestination(withChildren,  "15");
				int withChildren27 = getDestination(withChildren,  "4");
				int withChildren28 = getDestination(withChildren,  "5");
				int withChildren29 = getDestination(withChildren,  "6");
				int withChildren30 = getDestination(withChildren,  "7");
				int withChildren31 = getDestination(withChildren,  "25");
				
				int unknown26 = getDestination(unknown,  "15");
				int unknown27 = getDestination(unknown,  "4");
				int unknown28 = getDestination(unknown,  "5");
				int unknown29 = getDestination(unknown,  "6");
				int unknown30 = getDestination(unknown,  "7");
				int unknown31 = getDestination(unknown,  "25");
				
				int subTotal3AllData =  allTotal26+ allTotal27 + allTotal28 + allTotal29 + allTotal30 + allTotal31 ;
				int subTotal3WithoutChild =  withoutChildren26+ withoutChildren27 + withoutChildren28 + withoutChildren29 + withoutChildren30 + withoutChildren31 ;
				int subTotal3WithChildAndAdults = withChildAndAdult26 + withChildAndAdult27 + withChildAndAdult28 + withChildAndAdult29 + withChildAndAdult30 + withChildAndAdult31 ;
				int subTotal3WithChildren =  withChildren26+ withChildren27 + withChildren28 + withChildren29 + withChildren30 + withChildren31 ;
				int subTotal3Unknown = unknown26+ unknown27 + unknown28 + unknown29 + unknown30 + unknown31 ;
				
				//26
				q27fExitDestinationYouthTable.setQ27fC1FosterCareHomeOrGroupFosterCareTotal(BigInteger.valueOf(allTotal26));
				q27fExitDestinationYouthTable.setQ27fC1FosterCareHomeOrGroupFosterCareWithoutChild(BigInteger.valueOf(withoutChildren26));
				q27fExitDestinationYouthTable.setQ27fC1FosterCareHomeOrGroupFosterCareWithChildAndAdults(BigInteger.valueOf(withChildAndAdult26));
				q27fExitDestinationYouthTable.setQ27fC1FosterCareHomeOrGroupFosterCareWithChildOnly(BigInteger.valueOf(withChildren26));
				q27fExitDestinationYouthTable.setQ27fC1FosterCareHomeOrGroupFosterCareUnknownHouseHoldtype(BigInteger.valueOf(unknown26));
				//27
				q27fExitDestinationYouthTable.setQ27fC2PsychiatricHospitalOrOtherTotal(BigInteger.valueOf(allTotal27));
				q27fExitDestinationYouthTable.setQ27fC2PsychiatricHospitalOrOtherWithoutChild(BigInteger.valueOf(withoutChildren27));
				q27fExitDestinationYouthTable.setQ27fC2PsychiatricHospitalOrOtherWithChildAndAdults(BigInteger.valueOf(withChildAndAdult27));
				q27fExitDestinationYouthTable.setQ27fC2PsychiatricHospitalOrOtherWithChildOnly(BigInteger.valueOf(withChildren27));
				q27fExitDestinationYouthTable.setQ27fC2PsychiatricHospitalOrOtherUnknownHouseHoldtype(BigInteger.valueOf(unknown27));
				//28
				q27fExitDestinationYouthTable.setQ27fC3SubstanceAbuseTreatmentFacilityTotal(BigInteger.valueOf(allTotal28));
				q27fExitDestinationYouthTable.setQ27fC3SubstanceAbuseTreatmentFacilityWithoutChild(BigInteger.valueOf(withoutChildren28));
				q27fExitDestinationYouthTable.setQ27fC3SubstanceAbuseTreatmentFacilityWithChildAndAdults(BigInteger.valueOf(withChildAndAdult28));
				q27fExitDestinationYouthTable.setQ27fC3SubstanceAbuseTreatmentFacilityWithChildOnly(BigInteger.valueOf(withChildren28));
				q27fExitDestinationYouthTable.setQ27fC3SubstanceAbuseTreatmentFacilityUnknownHouseHoldtype(BigInteger.valueOf(unknown28));
				//29
				q27fExitDestinationYouthTable.setQ27fC4HospitalOrOtherResidentialTotal(BigInteger.valueOf(allTotal29));
				q27fExitDestinationYouthTable.setQ27fC4HospitalOrOtherResidentialWithoutChild(BigInteger.valueOf(withoutChildren29));
				q27fExitDestinationYouthTable.setQ27fC4HospitalOrOtherResidentialWithChildAndAdults(BigInteger.valueOf(withChildAndAdult29));
				q27fExitDestinationYouthTable.setQ27fC4HospitalOrOtherResidentialWithChildOnly(BigInteger.valueOf(withChildren29));
				q27fExitDestinationYouthTable.setQ27fC4HospitalOrOtherResidentialUnknownHouseHoldtype(BigInteger.valueOf(unknown29));
				//30
				q27fExitDestinationYouthTable.setQ27fC5JailPrisonOrJuvenileDetentionTotal(BigInteger.valueOf(allTotal30));
				q27fExitDestinationYouthTable.setQ27fC5JailPrisonOrJuvenileDetentionWithoutChild(BigInteger.valueOf(withoutChildren30));
				q27fExitDestinationYouthTable.setQ27fC5JailPrisonOrJuvenileDetentionWithChildAndAdults(BigInteger.valueOf(withChildAndAdult30));
				q27fExitDestinationYouthTable.setQ27fC5JailPrisonOrJuvenileDetentionWithChildOnly(BigInteger.valueOf(withChildren30));
				q27fExitDestinationYouthTable.setQ27fC5JailPrisonOrJuvenileDetentionUnknownHouseHoldtype(BigInteger.valueOf(unknown30));
				//31
				q27fExitDestinationYouthTable.setQ27fC6LongTermCareFacilityOrNursingHomeTotal(BigInteger.valueOf(allTotal31));
				q27fExitDestinationYouthTable.setQ27fC6LongTermCareFacilityOrNursingHomeWithoutChild(BigInteger.valueOf(withoutChildren31));
				q27fExitDestinationYouthTable.setQ27fC6LongTermCareFacilityOrNursingHomeWithChildAndAdults(BigInteger.valueOf(withChildAndAdult31));
				q27fExitDestinationYouthTable.setQ27fC6LongTermCareFacilityOrNursingHomeWithChildOnly(BigInteger.valueOf(withChildren31));
				q27fExitDestinationYouthTable.setQ27fC6LongTermCareFacilityOrNursingHomeUnknownHouseHoldtype(BigInteger.valueOf(unknown31));
				
				//32
				q27fExitDestinationYouthTable.setQ27fCzTotTotal(BigInteger.valueOf(subTotal3AllData));
				q27fExitDestinationYouthTable.setQ27fCzTotWithoutChild(BigInteger.valueOf(subTotal3WithoutChild));
				q27fExitDestinationYouthTable.setQ27fCzTotWithChildAndAdults(BigInteger.valueOf(subTotal3WithChildAndAdults));
				q27fExitDestinationYouthTable.setQ27fCzTotWithChildOnly(BigInteger.valueOf(subTotal3WithChildren));
				q27fExitDestinationYouthTable.setQ27fCzTotUnknownHouseHoldtype(BigInteger.valueOf(subTotal3Unknown));
				
				// 33  No data needs to be populdated for 33...
//				q27fExitDestinationYouthTable.setQ27fBDOtherDestinationsTotal(BigInteger.valueOf(0));
//				q27fExitDestinationYouthTable.setQ27fBDOtherDestinationsWithoutChild(BigInteger.valueOf(0));
//				q27fExitDestinationYouthTable.setQ27fBDOtherDestinationsWithChildAndAdults(BigInteger.valueOf(0));
//				q27fExitDestinationYouthTable.setQ27fBDOtherDestinationsWithChildOnly(BigInteger.valueOf(0));
//				q27fExitDestinationYouthTable.setQ27fBDOtherDestinationsUnknownHouseHoldtype(BigInteger.valueOf(0));
//				
				
				int allTotal34 = getDestination(allData,  "29");
				int allTotal35 = getDestination(allData,  "24");
				int allTotal36 = getDestination(allData,  "17");
				int allTotal37 = getDestination(allData,  "8","9");
				int allTotal38 = getDestination(allData,  "30","99");
				
				int withoutChildren34 = getDestination(withoutChildren,  "29");
				int withoutChildren35 = getDestination(withoutChildren,  "24");
				int withoutChildren36 = getDestination(withoutChildren,  "17");
				int withoutChildren37 = getDestination(withoutChildren,  "8","9");
				int withoutChildren38 = getDestination(withoutChildren,  "30","99");
				
				int withChildAndAdult34 = getDestination(withChildAndAdults,  "29");
				int withChildAndAdult35 = getDestination(withChildAndAdults,  "24");
				int withChildAndAdult36 = getDestination(withChildAndAdults,  "17");
				int withChildAndAdult37 = getDestination(withChildAndAdults,  "8","9");
				int withChildAndAdult38 = getDestination(withChildAndAdults,  "30","99");
				
				int withChildren34 = getDestination(withChildren,  "29");
				int withChildren35 = getDestination(withChildren,  "24");
				int withChildren36 = getDestination(withChildren,  "17");
				int withChildren37 = getDestination(withChildren, "8","9");
				int withChildren38 = getDestination(withChildren,  "30","99");
				
				int unknown34 = getDestination(unknown,  "29");
				int unknown35 = getDestination(unknown,  "24");
				int unknown36 = getDestination(unknown,  "17");
				int unknown37 = getDestination(unknown,  "8","9");
				int unknown38 = getDestination(unknown,  "30","99");
				
				
				int subTotal4AllData =  allTotal34+ allTotal35 + allTotal36 + allTotal37 + allTotal38 ;
				int subTotal4WithoutChild =  withoutChildren34+ withoutChildren35 + withoutChildren36 + withoutChildren37 + withoutChildren38  ;
				int subTotal4WithChildAndAdults = withChildAndAdult34 + withChildAndAdult35 + withChildAndAdult36 + withChildAndAdult37 + withChildAndAdult38 ;
				int subTotal4WithChildren =  withChildren34+ withChildren35  + withChildren36 + withChildren37 + withChildren38 ;
				int subTotal4Unknown = unknown34+ unknown35 + unknown36 + unknown37 + unknown38 ;
				
				// Other Destination sub total above
				//34
				q27fExitDestinationYouthTable.setQ27fD1ResidentialProjectorHalfwayHouseWithTotal(BigInteger.valueOf(allTotal34));
				q27fExitDestinationYouthTable.setQ27fD1ResidentialProjectorHalfwayHouseWithWithoutChild(BigInteger.valueOf(withoutChildren34));
				q27fExitDestinationYouthTable.setQ27fD1ResidentialProjectorHalfwayHouseWithWithChildAndAdults(BigInteger.valueOf(withChildAndAdult34));
				q27fExitDestinationYouthTable.setQ27fD1ResidentialProjectorHalfwayHouseWithWithChildOnly(BigInteger.valueOf(withChildren34));
				q27fExitDestinationYouthTable.setQ27fD1ResidentialProjectorHalfwayHouseWithUnknownHouseHoldtype(BigInteger.valueOf(unknown34));
				//35
				q27fExitDestinationYouthTable.setQ27fD2DeceasedTotal(BigInteger.valueOf(allTotal35));
				q27fExitDestinationYouthTable.setQ27fD2DeceasedWithoutChild(BigInteger.valueOf(withoutChildren35));
				q27fExitDestinationYouthTable.setQ27fD2DeceasedWithChildAndAdults(BigInteger.valueOf(withChildAndAdult36));
				q27fExitDestinationYouthTable.setQ27fD2DeceasedWithChildOnly(BigInteger.valueOf(withChildren35));
				q27fExitDestinationYouthTable.setQ27fD2DeceasedUnknownHouseHoldtype(BigInteger.valueOf(unknown35));
				//36
				q27fExitDestinationYouthTable.setQ27fD3OtherTotal(BigInteger.valueOf(allTotal36));
				q27fExitDestinationYouthTable.setQ27fD3OtherWithoutChild(BigInteger.valueOf(withoutChildren36));
				q27fExitDestinationYouthTable.setQ27fD3OtherWithChildAndAdults(BigInteger.valueOf(withChildAndAdult36));
				q27fExitDestinationYouthTable.setQ27fD3OtherWithChildOnly(BigInteger.valueOf(withChildren36));
				q27fExitDestinationYouthTable.setQ27fD3OtherUnknownHouseHoldtype(BigInteger.valueOf(unknown36));
				//37
				q27fExitDestinationYouthTable.setQ27fD4DKRTotal(BigInteger.valueOf(allTotal37));
				q27fExitDestinationYouthTable.setQ27fD4DKRWithoutChild(BigInteger.valueOf(withoutChildren37));
				q27fExitDestinationYouthTable.setQ27fD4DKRWithChildAndAdults(BigInteger.valueOf(withChildAndAdult37));
				q27fExitDestinationYouthTable.setQ27fD4DKRWithChildOnly(BigInteger.valueOf(withChildren37));
				q27fExitDestinationYouthTable.setQ27fD4DKRUnknownHouseHoldtype(BigInteger.valueOf(unknown37));
				//38
				q27fExitDestinationYouthTable.setQ27fD5InformationMissingTotal(BigInteger.valueOf(allTotal38));
				q27fExitDestinationYouthTable.setQ27fD5InformationMissingWithoutChild(BigInteger.valueOf(withoutChildren38));
				q27fExitDestinationYouthTable.setQ27fD5InformationMissingWithChildAndAdults(BigInteger.valueOf(withChildAndAdult38));
				q27fExitDestinationYouthTable.setQ27fD5InformationMissingWithChildOnly(BigInteger.valueOf(withChildren38));
				q27fExitDestinationYouthTable.setQ27fD5InformationMissingUnknownHouseHoldtype(BigInteger.valueOf(unknown38));

				//39
				q27fExitDestinationYouthTable.setQ27fDzTotTotal(BigInteger.valueOf(subTotal4AllData));
				q27fExitDestinationYouthTable.setQ27fDzTotWithoutChild(BigInteger.valueOf(subTotal4WithoutChild));
				q27fExitDestinationYouthTable.setQ27fDzTotWithChildAndAdults(BigInteger.valueOf(subTotal4WithChildAndAdults));
				q27fExitDestinationYouthTable.setQ27fDzTotWithChildOnly(BigInteger.valueOf(subTotal4WithChildren));
				q27fExitDestinationYouthTable.setQ27fDzTotUnknownHouseHoldtype(BigInteger.valueOf(subTotal4Unknown));
				
				int totalAllData = subTotal1AllData + subTotal2AllData + subTotal3AllData + subTotal4AllData ;
				int totalWithoutChild = subTotal1WithoutChild + subTotal2WithoutChild + subTotal3WithoutChild + subTotal4WithoutChild;
				int totalWithChildAndAdults = subTotal1WithChildAndAdults + subTotal2WithChildAndAdults + subTotal3WithChildAndAdults + subTotal4WithChildAndAdults;
				int totalWithChildren = subTotal1WithChildren + subTotal2WithChildren + subTotal3WithChildren + subTotal4WithChildren;
				int totalUnknown = subTotal1Unknown + subTotal2Unknown + subTotal3Unknown + subTotal4Unknown ;
				//40
				q27fExitDestinationYouthTable.setQ27fETotTotal(BigInteger.valueOf(totalAllData));
				q27fExitDestinationYouthTable.setQ27fETotWithoutChild(BigInteger.valueOf(totalWithoutChild));
				q27fExitDestinationYouthTable.setQ27fETotWithChildAndAdults(BigInteger.valueOf(totalWithChildAndAdults));
				q27fExitDestinationYouthTable.setQ27fETotWithChildOnly(BigInteger.valueOf(totalWithChildren));
				q27fExitDestinationYouthTable.setQ27fETotUnknownHouseHoldtype(BigInteger.valueOf(totalUnknown));
				
				List<String> positiveDestinationTypes = new ArrayList<String>();
				positiveDestinationTypes.add("26");
				positiveDestinationTypes.add("11");
				positiveDestinationTypes.add("21");
				positiveDestinationTypes.add("10");
				positiveDestinationTypes.add("19");
				positiveDestinationTypes.add("28");
				positiveDestinationTypes.add("20");
				positiveDestinationTypes.add("3");
				positiveDestinationTypes.add("22");
				positiveDestinationTypes.add("23");
				positiveDestinationTypes.add("31");
				
				List<String> tempInstDestinationTypes = new ArrayList<String>();
				tempInstDestinationTypes.add("1");
				tempInstDestinationTypes.add("15");
				tempInstDestinationTypes.add("14");
				tempInstDestinationTypes.add("7");
				tempInstDestinationTypes.add("27");
				tempInstDestinationTypes.add("16");
				tempInstDestinationTypes.add("4");
				tempInstDestinationTypes.add("29");
				tempInstDestinationTypes.add("18");
				tempInstDestinationTypes.add("12");
				tempInstDestinationTypes.add("13");
				tempInstDestinationTypes.add("5");
				tempInstDestinationTypes.add("2");
				tempInstDestinationTypes.add("25");
			
				int destinationByDestinationTypeAllData = getDestinationByDestinationType(allData,  positiveDestinationTypes);
				int destinationByProjectTypeAllData = getDestinationByProjectType(allData,  tempInstDestinationTypes, "6");
				int positiveHousingAllData = destinationByDestinationTypeAllData + destinationByProjectTypeAllData ;
				
				int destinationByDestinationTypeWithoutChildren = getDestinationByDestinationType(withoutChildren,  positiveDestinationTypes);
				int destinationByProjectTypeWithoutChildren = getDestinationByProjectType(withoutChildren,  tempInstDestinationTypes, "6");
				int positiveHousingWithoutChildren = destinationByDestinationTypeWithoutChildren + destinationByProjectTypeWithoutChildren ;
				
				int destinationByDestinationTypeWithChildAndAdults = getDestinationByDestinationType(withChildAndAdults,  positiveDestinationTypes);
				int destinationByProjectTypeWithChildAndAdults = getDestinationByProjectType(withChildAndAdults,  tempInstDestinationTypes, "6");
				int positiveHousingWithChildAndAdults = destinationByDestinationTypeWithChildAndAdults + destinationByProjectTypeWithChildAndAdults ;
				
				int destinationByDestinationTypeWithChildren = getDestinationByDestinationType(withChildren,  positiveDestinationTypes);
				int destinationByProjectTypeWithChildren = getDestinationByProjectType(withChildren,  tempInstDestinationTypes, "6");
				int positiveHousingWithChildren = destinationByDestinationTypeWithChildren + destinationByProjectTypeWithChildren ;
				
				int destinationByDestinationTypeUnknown = getDestinationByDestinationType(unknown,  positiveDestinationTypes);
				int destinationByProjectTypeUnknown = getDestinationByProjectType(unknown,  tempInstDestinationTypes, "6");
				int positiveHousingWithoutUnknown = destinationByDestinationTypeUnknown + destinationByProjectTypeUnknown ;
				
				//41
				q27fExitDestinationYouthTable.setQ27fTotalPrsnExitUnknownHouseHoldtype(BigInteger.valueOf(positiveHousingAllData));
				q27fExitDestinationYouthTable.setQ27fTotalPrsnExitWithChildOnly(BigInteger.valueOf(positiveHousingWithoutChildren));
				q27fExitDestinationYouthTable.setQ27fTotalPrsnExitWithChildAndAdults(BigInteger.valueOf(positiveHousingWithChildAndAdults));
				q27fExitDestinationYouthTable.setQ27fTotalPrsnExitWithoutChild(BigInteger.valueOf(positiveHousingWithChildren));
				q27fExitDestinationYouthTable.setQ27fTotalPrsnExitTotal(BigInteger.valueOf(positiveHousingWithoutUnknown));
				
				List<String> destinationTypeExcluded = new ArrayList<>();
				destinationTypeExcluded.add("6");
				destinationTypeExcluded.add("24");
				
				
				List<String> projectTypeExcluded = new ArrayList<>();
				projectTypeExcluded.add("1");
				projectTypeExcluded.add("2");
				projectTypeExcluded.add("8");
				projectTypeExcluded.add("9");
				projectTypeExcluded.add("10");
				
				int clientsExcludedAllData = getDestinationByDestinationType(allData,  destinationTypeExcluded);
				int projectTypeClientsExcludedAllData = getDestinationByProjectTypes(allData,  destinationTypeExcluded, projectTypeExcluded);
				int destinationClientsExcludedAllData = clientsExcludedAllData + projectTypeClientsExcludedAllData ;
				
				int clientsExcludedwithoutChildren = getDestinationByDestinationType(withoutChildren,  destinationTypeExcluded);
				int projectTypeClientsExcludedwithoutChildren = getDestinationByProjectTypes(withoutChildren,  destinationTypeExcluded, projectTypeExcluded);
				int destinationClientsExcludedwithoutChildren = clientsExcludedwithoutChildren + projectTypeClientsExcludedwithoutChildren ;
				
				int clientsExcludedeWithOnlyChild = getDestinationByDestinationType(withChildren,  destinationTypeExcluded);
				int projectTypeClientsExcludedeWithOnlyChild = getDestinationByProjectTypes(withChildren,  destinationTypeExcluded, projectTypeExcluded);
				int destinationClientsExcludedeWithOnlyChild = clientsExcludedeWithOnlyChild + projectTypeClientsExcludedeWithOnlyChild ;
				
				int clientsExcludedWithChildAndAdults = getDestinationByDestinationType(withChildAndAdults,  destinationTypeExcluded);
				int projectTypeClientsExcludedWithChildAndAdults = getDestinationByProjectTypes(withChildAndAdults,  destinationTypeExcluded, projectTypeExcluded);
				int destinationClientsExcludedWithChildAndAdults = clientsExcludedWithChildAndAdults + projectTypeClientsExcludedWithChildAndAdults ;
				
				int clientsExcludedWithUnknown = getDestinationByDestinationType(unknown,  destinationTypeExcluded);
				int projectTypeClientsExcludedWithUnknown = getDestinationByProjectTypes(unknown,  destinationTypeExcluded, projectTypeExcluded);
				int destinationClientsExcludedWithUnknown = clientsExcludedWithUnknown + projectTypeClientsExcludedWithUnknown ;
				
				
				//42
				q27fExitDestinationYouthTable.setQ27fTotalPrsnDstnWithoutChild(BigInteger.valueOf(destinationClientsExcludedwithoutChildren));
				q27fExitDestinationYouthTable.setQ27fTotalPrsnDstnTotal(BigInteger.valueOf(destinationClientsExcludedAllData));
				q27fExitDestinationYouthTable.setQ27fTotalPrsnDstnUnknownHouseHoldtype(BigInteger.valueOf(destinationClientsExcludedWithUnknown));
				q27fExitDestinationYouthTable.setQ27fTotalPrsnDstnWithChildOnly(BigInteger.valueOf(destinationClientsExcludedeWithOnlyChild));
				q27fExitDestinationYouthTable.setQ27fTotalPrsnDstnWithChildAndAdults(BigInteger.valueOf(destinationClientsExcludedWithChildAndAdults));
				
				// percentage below.
				//43 = 41/40-42
				q27fExitDestinationYouthTable.setQ27fPercentageWithChildAndAdults(BigInteger.valueOf(divide(positiveHousingWithChildAndAdults, totalWithChildAndAdults, destinationClientsExcludedWithChildAndAdults)));
				q27fExitDestinationYouthTable.setQ27fPercentageUnknownHouseHoldtype(BigInteger.valueOf(divide(positiveHousingWithoutUnknown, totalUnknown, destinationClientsExcludedWithUnknown)));
				q27fExitDestinationYouthTable.setQ27fPercentageWithChildOnly(BigInteger.valueOf(divide(positiveHousingWithChildren, totalWithChildren, destinationClientsExcludedeWithOnlyChild)));
				q27fExitDestinationYouthTable.setQ27fPercentageWithoutChild(BigInteger.valueOf(divide(positiveHousingWithoutChildren, totalWithoutChild, destinationClientsExcludedwithoutChildren)));
				q27fExitDestinationYouthTable.setQ27fPercentageTotal(BigInteger.valueOf(divide(positiveHousingAllData, totalAllData, destinationClientsExcludedAllData)));
		
			}	}catch(Exception e){
				logger.error("Error in Q27faLengthOfParticipationByHouseholdTypeDataBeanMaker:" + e);
			}
			return Arrays.asList(q27fExitDestinationYouthTable);
	  }
	}