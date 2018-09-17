package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.servinglynk.report.bean.Q23bExitDestination90DaysOrLessDataBean;
import com.servinglynk.report.bean.ReportData;
import com.servinglynk.report.model.Q22BeanModel;

public class Q23bExitDestination90DaysOrLessDataBeanMaker extends BaseBeanMaker {
	public static int numOfDays = 90;
	public static List<Q23bExitDestination90DaysOrLessDataBean> getQ23bExitDestination90DaysOrLessList(ReportData data){
		Q23bExitDestination90DaysOrLessDataBean q23bExitDestination90DaysOrLessTable = new Q23bExitDestination90DaysOrLessDataBean();
	
		String query = 		  
				" select distinct(e.dedup_client_id ),,p.projecttype,p.trackingmethod,p.operatingstartdate,ext.exitdate,e.entrydate,mid.moveindate,e1.destination  from enrollment e join project p  on (e.projectid = p.id  %p"+
				" join exit ext on ( e.id = ext.enrollmentid and ext.exitdate >= ?  and ext.exitdate <= ?) "+
				" join moveindate mid on (e.id = mid.enrollmentid) "+
				" join enrollment e1 on (e.householdid = e1.householdid and e1.relationshipToHoH='1') "+
				" order by e.dedup_client_id ";	
		
		try {
			if(data.isLiveMode()) {
				List<Q22BeanModel> allData = getQ22BeanLengthOfStay(data, query, null,true,true);
				List<Q22BeanModel> withoutChildren = getQ22BeanLengthOfStay(data, query, data.getProjectsHHWithOutChildren(),false,true);
				List<Q22BeanModel> withChildAndAdults = getQ22BeanLengthOfStay(data, query, data.getProjectsHHWithOneAdultChild(),false,true);
				List<Q22BeanModel> withChildren = getQ22BeanLengthOfStay(data, query, data.getProjectsHHWithChildren(),false,true);
				List<Q22BeanModel> unknown = getQ22BeanLengthOfStay(data, query, data.getProjectsUnknownHouseHold(),false,true);
				//3
				int allTotal3 = getDestination(allData, numOfDays, "26");
				int allTotal4 = getDestination(allData, numOfDays, "11");
				int allTotal5 = getDestination(allData, numOfDays, "21");
				int allTotal6 = getDestination(allData, numOfDays, "10");
				int allTotal7 = getDestination(allData, numOfDays, "19");
				int allTotal8 = getDestination(allData, numOfDays, "28");
				int allTotal9 = getDestination(allData, numOfDays, "20");
				int allTotal10 = getDestination(allData, numOfDays, "3");
				int allTotal11 = getDestination(allData, numOfDays, "22");
				int allTotal12 = getDestination(allData, numOfDays, "23");
				int allTotal13 = getDestination(allData, numOfDays, "31");
				
				int withoutChildren3 = getDestination(withoutChildren, numOfDays, "26");
				int withoutChildren4 = getDestination(withoutChildren, numOfDays, "11");
				int withoutChildren5 = getDestination(withoutChildren, numOfDays, "21");
				int withoutChildren6 = getDestination(withoutChildren, numOfDays, "10");
				int withoutChildren7 = getDestination(withoutChildren, numOfDays, "19");
				int withoutChildren8 = getDestination(withoutChildren, numOfDays, "28");
				int withoutChildren9 = getDestination(withoutChildren, numOfDays, "20");
				int withoutChildren10 = getDestination(withoutChildren, numOfDays, "3");
				int withoutChildren11 = getDestination(withoutChildren, numOfDays, "22");
				int withoutChildren12 = getDestination(withoutChildren, numOfDays, "23");
				int withoutChildren13 = getDestination(withoutChildren, numOfDays, "31");
				
				
				int withChildAndAdults3 = getDestination(withChildAndAdults, numOfDays, "26");
				int withChildAndAdults4 = getDestination(withChildAndAdults, numOfDays, "11");
				int withChildAndAdults5 = getDestination(withChildAndAdults, numOfDays, "21");
				int withChildAndAdults6 = getDestination(withChildAndAdults, numOfDays, "10");
				int withChildAndAdults7 = getDestination(withChildAndAdults, numOfDays, "19");
				int withChildAndAdults8 = getDestination(withChildAndAdults, numOfDays, "28");
				int withChildAndAdults9 = getDestination(withChildAndAdults, numOfDays, "20");
				int withChildAndAdults10 = getDestination(withChildAndAdults, numOfDays, "3");
				int withChildAndAdults11 = getDestination(withChildAndAdults, numOfDays, "22");
				int withChildAndAdults12 = getDestination(withChildAndAdults, numOfDays, "23");
				int withChildAndAdults13 = getDestination(withChildAndAdults, numOfDays, "31");
				
				
				int withChildren3 = getDestination(withChildren, numOfDays, "26");
				int withChildren4 = getDestination(withChildren, numOfDays, "11");
				int withChildren5 = getDestination(withChildren, numOfDays, "21");
				int withChildren6 = getDestination(withChildren, numOfDays, "10");
				int withChildren7 = getDestination(withChildren, numOfDays, "19");
				int withChildren8 = getDestination(withChildren, numOfDays, "28");
				int withChildren9 = getDestination(withChildren, numOfDays, "20");
				int withChildren10 = getDestination(withChildren, numOfDays, "3");
				int withChildren11 = getDestination(withChildren, numOfDays, "22");
				int withChildren12 = getDestination(withChildren, numOfDays, "23");
				int withChildren13 = getDestination(withChildren, numOfDays, "31");
				
				int unknown3 = getDestination(unknown, numOfDays, "26");
				int unknown4 = getDestination(unknown, numOfDays, "11");
				int unknown5 = getDestination(unknown, numOfDays, "21");
				int unknown6 = getDestination(unknown, numOfDays, "10");
				int unknown7 = getDestination(unknown, numOfDays, "19");
				int unknown8 = getDestination(unknown, numOfDays, "28");
				int unknown9 = getDestination(unknown, numOfDays, "20");
				int unknown10 = getDestination(unknown, numOfDays, "3");
				int unknown11 = getDestination(unknown, numOfDays, "22");
				int unknown12 = getDestination(unknown, numOfDays, "23");
				int unknown13 = getDestination(unknown, numOfDays, "31");
				
	
				//3
				q23bExitDestination90DaysOrLessTable.setQ23BA01MovedFromOneHOPWATotal(BigInteger.valueOf(allTotal3));
				q23bExitDestination90DaysOrLessTable.setQ23BA01MovedFromOneHOPWAWithoutChild( BigInteger.valueOf(withoutChildren3) );
				q23bExitDestination90DaysOrLessTable.setQ23BA01MovedFromOneHOPWAWithChildAndAdults(BigInteger.valueOf(withChildAndAdults3));
				q23bExitDestination90DaysOrLessTable.setQ23BA01MovedFromOneHOPWAWithOnlyChild(BigInteger.valueOf(withChildren3) );
				q23bExitDestination90DaysOrLessTable.setQ23BA01MovedFromOneHOPWAUnknownHouseHold(BigInteger.valueOf(unknown3));
				//4
				q23bExitDestination90DaysOrLessTable.setQ23BA02OwnedByClientNoOngoingSubsidyTotal(BigInteger.valueOf(allTotal4));
				q23bExitDestination90DaysOrLessTable.setQ23BA02OwnedByClientNoOngoingSubsidyWithoutChild(BigInteger.valueOf(withoutChildren4) );
				q23bExitDestination90DaysOrLessTable.setQ23BA02OwnedByClientNoOngoingSubsidyWithChildAndAdults(BigInteger.valueOf(withChildAndAdults4) );
				q23bExitDestination90DaysOrLessTable.setQ23BA02OwnedByClientNoOngoingSubsidyWithOnlyChild(BigInteger.valueOf(withChildren4) );
				q23bExitDestination90DaysOrLessTable.setQ23BA02OwnedByClientNoOngoingSubsidyUnknownHouseHold(BigInteger.valueOf(unknown4) );
				//5
				q23bExitDestination90DaysOrLessTable.setQ23BA03OwnedByClientWithOngoingSubsidyTotal(BigInteger.valueOf(allTotal5));
				q23bExitDestination90DaysOrLessTable.setQ23BA03OwnedByClientWithOngoingSubsidyWithoutChild(BigInteger.valueOf(withoutChildren5));
				q23bExitDestination90DaysOrLessTable.setQ23BA03OwnedByClientWithOngoingSubsidyWithChildAndAdults(BigInteger.valueOf(withChildAndAdults5));
				q23bExitDestination90DaysOrLessTable.setQ23BA03OwnedByClientWithOngoingSubsidyWithOnlyChild(BigInteger.valueOf(withChildren5));
				q23bExitDestination90DaysOrLessTable.setQ23BA03OwnedByClientWithOngoingSubsidyUnknownHouseHold(BigInteger.valueOf(unknown5));
				//6
				q23bExitDestination90DaysOrLessTable.setQ23BA04RentalByClientNoOngoingSubsidyTotal(BigInteger.valueOf(allTotal6));
				q23bExitDestination90DaysOrLessTable.setQ23BA04RentalByClientNoOngoingSubsidyWithoutChild(BigInteger.valueOf(withoutChildren6));
				q23bExitDestination90DaysOrLessTable.setQ23BA04RentalByClientNoOngoingSubsidyWithChildAndAdults(BigInteger.valueOf(withChildAndAdults6));
				q23bExitDestination90DaysOrLessTable.setQ23BA04RentalByClientNoOngoingSubsidyWithOnlyChild(BigInteger.valueOf(withChildren6));
				q23bExitDestination90DaysOrLessTable.setQ23BA04RentalByClientNoOngoingSubsidyUnknownHouseHold(BigInteger.valueOf(unknown6));
				//7
				q23bExitDestination90DaysOrLessTable.setQ23BA05RentalByClientVASHSubsidyTotal(BigInteger.valueOf(allTotal7));
				q23bExitDestination90DaysOrLessTable.setQ23BA05RentalByClientVASHSubsidyWithoutChild(BigInteger.valueOf(withoutChildren7));
				q23bExitDestination90DaysOrLessTable.setQ23BA05RentalByClientVASHSubsidyWithChildAndAdults(BigInteger.valueOf(withChildAndAdults7));
				q23bExitDestination90DaysOrLessTable.setQ23BA05RentalByClientVASHSubsidyWithOnlyChild(BigInteger.valueOf(withChildren7));
				q23bExitDestination90DaysOrLessTable.setQ23BA05RentalByClientVASHSubsidyUnknownHouseHold(BigInteger.valueOf(unknown7));
				//8
				q23bExitDestination90DaysOrLessTable.setQ23BA06RentalByClientwithGPDTIPHousingTotal(BigInteger.valueOf(allTotal8));
				q23bExitDestination90DaysOrLessTable.setQ23BA06RentalByClientwithGPDTIPHousingWithoutChild(BigInteger.valueOf(withoutChildren8));
				q23bExitDestination90DaysOrLessTable.setQ23BA06RentalByClientwithGPDTIPHousingWithChildAndAdults(BigInteger.valueOf(withChildAndAdults8));
				q23bExitDestination90DaysOrLessTable.setQ23BA06RentalByClientwithGPDTIPHousingWithOnlyChild(BigInteger.valueOf(withChildren8));
				q23bExitDestination90DaysOrLessTable.setQ23BA06RentalByClientwithGPDTIPHousingUnknownHouseHold(BigInteger.valueOf(unknown8));
				//9
				q23bExitDestination90DaysOrLessTable.setQ23BA07RentalByClientOtherOngoingSubsidyTotal(BigInteger.valueOf(allTotal9));
				q23bExitDestination90DaysOrLessTable.setQ23BA07RentalByClientOtherOngoingSubsidyWithoutChild(BigInteger.valueOf(withoutChildren9));
				q23bExitDestination90DaysOrLessTable.setQ23BA07RentalByClientOtherOngoingSubsidyWithChildAndAdults(BigInteger.valueOf(withChildAndAdults9));
				q23bExitDestination90DaysOrLessTable.setQ23BA07RentalByClientOtherOngoingSubsidyWithOnlyChild(BigInteger.valueOf(withChildren9));
				q23bExitDestination90DaysOrLessTable.setQ23BA07RentalByClientOtherOngoingSubsidyUnknownHouseHold(BigInteger.valueOf(unknown9));
				//10
				q23bExitDestination90DaysOrLessTable.setQ23BA08PermanentHousingForHomelessTotal(BigInteger.valueOf(allTotal10));
				q23bExitDestination90DaysOrLessTable.setQ23BA08PermanentHousingForHomelessWithoutChild(BigInteger.valueOf(withoutChildren10));
				q23bExitDestination90DaysOrLessTable.setQ23BA08PermanentHousingForHomelessWithChildAndAdults(BigInteger.valueOf(withChildAndAdults10));
				q23bExitDestination90DaysOrLessTable.setQ23BA08PermanentHousingForHomelessWithOnlyChild(BigInteger.valueOf(withChildren10));
				q23bExitDestination90DaysOrLessTable.setQ23BA08PermanentHousingForHomelessUnknownHouseHold(BigInteger.valueOf(unknown10));
				//11
				q23bExitDestination90DaysOrLessTable.setQ23BA09StayingOrLivingWithFamilyPermanentTotal(BigInteger.valueOf(allTotal11));
				q23bExitDestination90DaysOrLessTable.setQ23BA09StayingOrLivingWithFamilyPermanentWithoutChild((BigInteger.valueOf(withoutChildren11)));
				q23bExitDestination90DaysOrLessTable.setQ23BA09StayingOrLivingWithFamilyPermanentWithChildAndAdults(BigInteger.valueOf(withChildAndAdults11));
				q23bExitDestination90DaysOrLessTable.setQ23BA09StayingOrLivingWithFamilyPermanentWithOnlyChild(BigInteger.valueOf(withChildren11));
				q23bExitDestination90DaysOrLessTable.setQ23BA09StayingOrLivingWithFamilyPermanentUnknownHouseHold(BigInteger.valueOf(unknown11));
				//12
				q23bExitDestination90DaysOrLessTable.setQ23BA10StayingOrLivingWithFriendsPermanentTotal(BigInteger.valueOf(allTotal12));
				q23bExitDestination90DaysOrLessTable.setQ23BA10StayingOrLivingWithFriendsPermanentWithoutChild(BigInteger.valueOf(withoutChildren12));
				q23bExitDestination90DaysOrLessTable.setQ23BA10StayingOrLivingWithFriendsPermanentWithChildAndAdults(BigInteger.valueOf(withChildAndAdults12));
				q23bExitDestination90DaysOrLessTable.setQ23BA10StayingOrLivingWithFriendsPermanentWithOnlyChild(BigInteger.valueOf(withChildren12));
				q23bExitDestination90DaysOrLessTable.setQ23BA10StayingOrLivingWithFriendsPermanentUnknownHouseHold(BigInteger.valueOf(unknown12));
				
				int subTotal1AllData = allTotal3 + allTotal4+ allTotal5+ allTotal6+ allTotal7 + allTotal8 + allTotal9 + allTotal10 + allTotal11 + allTotal12 + allTotal3;
				int subTotal1WithoutChild = withoutChildren3 + withoutChildren4+ withoutChildren5+ withoutChildren6+ withoutChildren7 + withoutChildren8 + withoutChildren9 + withoutChildren10 + withoutChildren11 + withoutChildren12 + withoutChildren3;
				int subTotal1WithChildAndAdults = withChildAndAdults3 + withChildAndAdults4+ withChildAndAdults5+ withChildAndAdults6+ withChildAndAdults7 + withChildAndAdults8 + withChildAndAdults9 + withChildAndAdults10 + withChildAndAdults11 + withChildAndAdults12 + withChildAndAdults3;
				int subTotal1WithChildren = withChildren3 + withChildren4+ withChildren5+ withChildren6+ withChildren7 + withChildren8 + withChildren9 + withChildren10 + withChildren11 + withChildren12 + withChildren3;
				int subTotal1Unknown = unknown3 + unknown4+ unknown5+ unknown6+ unknown7 + unknown8 + unknown9 + unknown10 + unknown11 + unknown12 + unknown3;
				
				
				//Sandeep TODO :  Missing row for # 13 Rental by client, with RRH or equivalent subsidy
				//14
				q23bExitDestination90DaysOrLessTable.setQ23BAzTotTotal(BigInteger.valueOf(subTotal1AllData));
				q23bExitDestination90DaysOrLessTable.setQ23BAzTotWithoutChild(BigInteger.valueOf(subTotal1WithoutChild));
				q23bExitDestination90DaysOrLessTable.setQ23BAzTotWithChildAndAdults(BigInteger.valueOf(subTotal1WithChildAndAdults));
				q23bExitDestination90DaysOrLessTable.setQ23BAzTotWithOnlyChild(BigInteger.valueOf(subTotal1WithChildren));
				q23bExitDestination90DaysOrLessTable.setQ23BAzTotUnknownHouseHold(BigInteger.valueOf(subTotal1Unknown));
				// Permanent Housing sub total above
				
//				q23bExitDestination90DaysOrLessTable.setQ23BBTemporaryDestinationsTotal();
//				q23bExitDestination90DaysOrLessTable.setQ23BBTemporaryDestinationsWithoutChild();
//				q23bExitDestination90DaysOrLessTable.setQ23BBTemporaryDestinationsWithChildAndAdults();
//				q23bExitDestination90DaysOrLessTable.setQ23BBTemporaryDestinationsWithOnlyChild();
//				q23bExitDestination90DaysOrLessTable.setQ23BBTemporaryDestinationsUnknownHouseHold();

				int allTotal16 = getDestination(allData, numOfDays, "1");
				int allTotal17 = getDestination(allData, numOfDays, "27");
				int allTotal18 = getDestination(allData, numOfDays, "2");
				int allTotal19 = getDestination(allData, numOfDays, "12");
				int allTotal20 = getDestination(allData, numOfDays, "13");
				int allTotal21 = getDestination(allData, numOfDays, "16");
				int allTotal22 = getDestination(allData, numOfDays, "18");
				int allTotal23 = getDestination(allData, numOfDays, "14");
				
				int withoutChildren16 = getDestination(withoutChildren, numOfDays, "1");
				int withoutChildren17 = getDestination(withoutChildren, numOfDays, "27");
				int withoutChildren18 = getDestination(withoutChildren, numOfDays, "2");
				int withoutChildren19 = getDestination(withoutChildren, numOfDays, "12");
				int withoutChildren20 = getDestination(withoutChildren, numOfDays, "13");
				int withoutChildren21 = getDestination(withoutChildren, numOfDays, "16");
				int withoutChildren22 = getDestination(withoutChildren, numOfDays, "18");
				int withoutChildren23 = getDestination(withoutChildren, numOfDays, "14");
				
				int withChildAndAdult16 = getDestination(withChildAndAdults, numOfDays, "1");
				int withChildAndAdult17 = getDestination(withChildAndAdults, numOfDays, "27");
				int withChildAndAdult18 = getDestination(withChildAndAdults, numOfDays, "2");
				int withChildAndAdult19 = getDestination(withChildAndAdults, numOfDays, "12");
				int withChildAndAdult20 = getDestination(withChildAndAdults, numOfDays, "13");
				int withChildAndAdult21 = getDestination(withChildAndAdults, numOfDays, "16");
				int withChildAndAdult22 = getDestination(withChildAndAdults, numOfDays, "18");
				int withChildAndAdult23 = getDestination(withChildAndAdults, numOfDays, "14");
				
				int withChildren16 = getDestination(withChildren, numOfDays, "1");
				int withChildren17 = getDestination(withChildren, numOfDays, "27");
				int withChildren18 = getDestination(withChildren, numOfDays, "2");
				int withChildren19 = getDestination(withChildren, numOfDays, "12");
				int withChildren20 = getDestination(withChildren, numOfDays, "13");
				int withChildren21 = getDestination(withChildren, numOfDays, "16");
				int withChildren22 = getDestination(withChildren, numOfDays, "18");
				int withChildren23 = getDestination(withChildren, numOfDays, "14");
				
				int unknown16 = getDestination(unknown, numOfDays, "1");
				int unknown17 = getDestination(unknown, numOfDays, "27");
				int unknown18 = getDestination(unknown, numOfDays, "2");
				int unknown19 = getDestination(unknown, numOfDays, "12");
				int unknown20 = getDestination(unknown, numOfDays, "13");
				int unknown21 = getDestination(unknown, numOfDays, "16");
				int unknown22 = getDestination(unknown, numOfDays, "18");
				int unknown23 = getDestination(unknown, numOfDays, "14");
				//16
				q23bExitDestination90DaysOrLessTable.setQ23BB1EmergencyShelterTotal();
				q23bExitDestination90DaysOrLessTable.setQ23BB1EmergencyShelterWithoutChild();
				q23bExitDestination90DaysOrLessTable.setQ23BB1EmergencyShelterWithChildAndAdults();
				q23bExitDestination90DaysOrLessTable.setQ23BB1EmergencyShelterWithOnlyChild();
				q23bExitDestination90DaysOrLessTable.setQ23BB1EmergencyShelterUnknownHouseHold();
				//17
				q23bExitDestination90DaysOrLessTable.setQ23BB2MovedFromOneHOPWATotal();
				q23bExitDestination90DaysOrLessTable.setQ23BB2MovedFromOneHOPWAWithoutChild();
				q23bExitDestination90DaysOrLessTable.setQ23BB2MovedFromOneHOPWAWithChildAndAdults();
				q23bExitDestination90DaysOrLessTable.setQ23BB2MovedFromOneHOPWAWithOnlyChild();
				q23bExitDestination90DaysOrLessTable.setQ23BB2MovedFromOneHOPWAUnknownHouseHold();
				//18
				q23bExitDestination90DaysOrLessTable.setQ23BB3TransitionalHousingForHomeLessTotal();
				q23bExitDestination90DaysOrLessTable.setQ23BB3TransitionalHousingForHomeLessWithoutChild();
				q23bExitDestination90DaysOrLessTable.setQ23BB3TransitionalHousingForHomeLessWithChildAndAdults();
				q23bExitDestination90DaysOrLessTable.setQ23BB3TransitionalHousingForHomeLessWithOnlyChild();
				q23bExitDestination90DaysOrLessTable.setQ23BB3TransitionalHousingForHomeLessUnknownHouseHold();
				//19
				q23bExitDestination90DaysOrLessTable.setQ23BB4StayingWithFamilyTemporaryTenureTotal();
				q23bExitDestination90DaysOrLessTable.setQ23BB4StayingWithFamilyTemporaryTenureWithoutChild();
				q23bExitDestination90DaysOrLessTable.setQ23BB4StayingWithFamilyTemporaryTenureWithChildAndAdults();
				q23bExitDestination90DaysOrLessTable.setQ23BB4StayingWithFamilyTemporaryTenureWithOnlyChild();
				q23bExitDestination90DaysOrLessTable.setQ23BB4StayingWithFamilyTemporaryTenureUnknownHouseHold();
				//20
				q23bExitDestination90DaysOrLessTable.setQ23BB5StayingWithFriendsTemporaryTenureTotal();
				q23bExitDestination90DaysOrLessTable.setQ23BB5StayingWithFriendsTemporaryTenureWithoutChild();
				q23bExitDestination90DaysOrLessTable.setQ23BB5StayingWithFriendsTemporaryTenureWithChildAndAdults();
				q23bExitDestination90DaysOrLessTable.setQ23BB5StayingWithFriendsTemporaryTenureWithOnlyChild();
				q23bExitDestination90DaysOrLessTable.setQ23BB5StayingWithFriendsTemporaryTenureUnknownHouseHold();
				//21
				q23bExitDestination90DaysOrLessTable.setQ23BB6PlaceNotMeantForHumanHabitationTotal();
				q23bExitDestination90DaysOrLessTable.setQ23BB6PlaceNotMeantForHumanHabitationWithoutChild();
				q23bExitDestination90DaysOrLessTable.setQ23BB6PlaceNotMeantForHumanHabitationWithChildAndAdults();
				q23bExitDestination90DaysOrLessTable.setQ23BB6PlaceNotMeantForHumanHabitationWithOnlyChild();
				q23bExitDestination90DaysOrLessTable.setQ23BB6PlaceNotMeantForHumanHabitationUnknownHouseHold();
				//22
				q23bExitDestination90DaysOrLessTable.setQ23BB7SafeHavenTotal();
				q23bExitDestination90DaysOrLessTable.setQ23BB7SafeHavenWithoutChild();
				q23bExitDestination90DaysOrLessTable.setQ23BB7SafeHavenWithChildAndAdults();
				q23bExitDestination90DaysOrLessTable.setQ23BB7SafeHavenWithOnlyChild();
				q23bExitDestination90DaysOrLessTable.setQ23BB7SafeHavenUnknownHouseHold();
				//23
				q23bExitDestination90DaysOrLessTable.setQ23BB8HotelOrMotelPaidByClientTotal();
				q23bExitDestination90DaysOrLessTable.setQ23BB8HotelOrMotelPaidByClientWithoutChild();
				q23bExitDestination90DaysOrLessTable.setQ23BB8HotelOrMotelPaidByClientWithChildAndAdults();
				q23bExitDestination90DaysOrLessTable.setQ23BB8HotelOrMotelPaidByClientWithOnlyChild();
				q23bExitDestination90DaysOrLessTable.setQ23BB8HotelOrMotelPaidByClientUnknownHouseHold();
				
				//24
				q23bExitDestination90DaysOrLessTable.setQ23BBzTotTotal();
				q23bExitDestination90DaysOrLessTable.setQ23BBzTotWithoutChild();
				q23bExitDestination90DaysOrLessTable.setQ23BBzTotWithChildAndAdults();
				q23bExitDestination90DaysOrLessTable.setQ23BBzTotWithOnlyChild();
				q23bExitDestination90DaysOrLessTable.setQ23BBzTotUnknownHouseHold();
				// Temp Housing sub total above
				
				//Sandeep TODO : need to remove the below  row or it can be empty string.
//				q23bExitDestination90DaysOrLessTable.setQ23BCInstitutionalSettingsTotal();
//				q23bExitDestination90DaysOrLessTable.setQ23BCInstitutionalSettingsWithoutChild();
//				q23bExitDestination90DaysOrLessTable.setQ23BCInstitutionalSettingsWithChildAndAdults();
//				q23bExitDestination90DaysOrLessTable.setQ23BCInstitutionalSettingsWithOnlyChild();
//				q23bExitDestination90DaysOrLessTable.setQ23BCInstitutionalSettingsUnknownHouseHold();
				
				//26
				q23bExitDestination90DaysOrLessTable.setQ23BC1FosterCareHomeOrGroupFosterCareTotal();
				q23bExitDestination90DaysOrLessTable.setQ23BC1FosterCareHomeOrGroupFosterCareWithoutChild();
				q23bExitDestination90DaysOrLessTable.setQ23BC1FosterCareHomeOrGroupFosterCareWithChildAndAdults();
				q23bExitDestination90DaysOrLessTable.setQ23BC1FosterCareHomeOrGroupFosterCareWithOnlyChild();
				q23bExitDestination90DaysOrLessTable.setQ23BC1FosterCareHomeOrGroupFosterCareUnknownHouseHold();
				//27
				q23bExitDestination90DaysOrLessTable.setQ23BC2PsychiatricHospitalOrOtherTotal();
				q23bExitDestination90DaysOrLessTable.setQ23BC2PsychiatricHospitalOrOtherWithoutChild();
				q23bExitDestination90DaysOrLessTable.setQ23BC2PsychiatricHospitalOrOtherWithChildAndAdults();
				q23bExitDestination90DaysOrLessTable.setQ23BC2PsychiatricHospitalOrOtherWithOnlyChild();
				q23bExitDestination90DaysOrLessTable.setQ23BC2PsychiatricHospitalOrOtherUnknownHouseHold();
				//28
				q23bExitDestination90DaysOrLessTable.setQ23BC3SubstanceAbuseTreatmentFacilityTotal();
				q23bExitDestination90DaysOrLessTable.setQ23BC3SubstanceAbuseTreatmentFacilityWithoutChild();
				q23bExitDestination90DaysOrLessTable.setQ23BC3SubstanceAbuseTreatmentFacilityWithChildAndAdults();
				q23bExitDestination90DaysOrLessTable.setQ23BC3SubstanceAbuseTreatmentFacilityWithOnlyChild();
				q23bExitDestination90DaysOrLessTable.setQ23BC3SubstanceAbuseTreatmentFacilityUnknownHouseHold();
				//29
				q23bExitDestination90DaysOrLessTable.setQ23BC4HospitalOrOtherTotal();
				q23bExitDestination90DaysOrLessTable.setQ23BC4HospitalOrOtherWithoutChild();
				q23bExitDestination90DaysOrLessTable.setQ23BC4HospitalOrOtherWithChildAndAdults();
				q23bExitDestination90DaysOrLessTable.setQ23BC4HospitalOrOtherWithOnlyChild();
				q23bExitDestination90DaysOrLessTable.setQ23BC4HospitalOrOtherUnknownHouseHold();
				//30
				q23bExitDestination90DaysOrLessTable.setQ23BC5JailPrisonOrJuvenileDetentionTotal();
				q23bExitDestination90DaysOrLessTable.setQ23BC5JailPrisonOrJuvenileDetentionWithoutChild();
				q23bExitDestination90DaysOrLessTable.setQ23BC5JailPrisonOrJuvenileDetentionWithChildAndAdults();
				q23bExitDestination90DaysOrLessTable.setQ23BC5JailPrisonOrJuvenileDetentionWithOnlyChild();
				q23bExitDestination90DaysOrLessTable.setQ23BC5JailPrisonOrJuvenileDetentionUnknownHouseHold();
				//31
				q23bExitDestination90DaysOrLessTable.setQ23BC6LongTermCareFacilityOrNursingHomeTotal();
				q23bExitDestination90DaysOrLessTable.setQ23BC6LongTermCareFacilityOrNursingHomeWithoutChild();
				q23bExitDestination90DaysOrLessTable.setQ23BC6LongTermCareFacilityOrNursingHomeWithChildAndAdults();
				q23bExitDestination90DaysOrLessTable.setQ23BC6LongTermCareFacilityOrNursingHomeWithOnlyChild();
				q23bExitDestination90DaysOrLessTable.setQ23BC6LongTermCareFacilityOrNursingHomeUnknownHouseHold();
				//32
				q23bExitDestination90DaysOrLessTable.setQ23BCzTotTotal();
				q23bExitDestination90DaysOrLessTable.setQ23BCzTotWithoutChild();
				q23bExitDestination90DaysOrLessTable.setQ23BCzTotWithChildAndAdults();
				q23bExitDestination90DaysOrLessTable.setQ23BCzTotWithOnlyChild();
				q23bExitDestination90DaysOrLessTable.setQ23BCzTotUnknownHouseHold();
				
				// 33  No data needs to be populdated for 33...
//				q23bExitDestination90DaysOrLessTable.setQ23BDOtherDestinationsTotal();
//				q23bExitDestination90DaysOrLessTable.setQ23BDOtherDestinationsWithoutChild();
//				q23bExitDestination90DaysOrLessTable.setQ23BDOtherDestinationsWithChildAndAdults();
//				q23bExitDestination90DaysOrLessTable.setQ23BDOtherDestinationsWithOnlyChild();
//				q23bExitDestination90DaysOrLessTable.setQ23BDOtherDestinationsUnknownHouseHold();
//				
				// Other Destination sub total above
				//34
				q23bExitDestination90DaysOrLessTable.setQ23BD1ResidentialProjectorHalfwayHouseTotal();
				q23bExitDestination90DaysOrLessTable.setQ23BD1ResidentialProjectorHalfwayHouseWithoutChild();
				q23bExitDestination90DaysOrLessTable.setQ23BD1ResidentialProjectorHalfwayHouseWithChildAndAdults();
				q23bExitDestination90DaysOrLessTable.setQ23BD1ResidentialProjectorHalfwayHouseWithOnlyChild();
				q23bExitDestination90DaysOrLessTable.setQ23BD1ResidentialProjectorHalfwayHouseUnknownHouseHold();
				//35
				q23bExitDestination90DaysOrLessTable.setQ23BD2DeceasedTotal();
				q23bExitDestination90DaysOrLessTable.setQ23BD2DeceasedWithoutChild();
				q23bExitDestination90DaysOrLessTable.setQ23BD2DeceasedWithChildAndAdults();
				q23bExitDestination90DaysOrLessTable.setQ23BD2DeceasedWithOnlyChild();
				q23bExitDestination90DaysOrLessTable.setQ23BD2DeceasedUnknownHouseHold();
				//36
				q23bExitDestination90DaysOrLessTable.setQ23BD3OtherTotal();
				q23bExitDestination90DaysOrLessTable.setQ23BD3OtherWithoutChild();
				q23bExitDestination90DaysOrLessTable.setQ23BD3OtherWithChildAndAdults();
				q23bExitDestination90DaysOrLessTable.setQ23BD3OtherWithOnlyChild();
				q23bExitDestination90DaysOrLessTable.setQ23BD3OtherUnknownHouseHold();
				//37
				q23bExitDestination90DaysOrLessTable.setQ23BD4DKRTotal();
				q23bExitDestination90DaysOrLessTable.setQ23BD4DKRWithoutChild();
				q23bExitDestination90DaysOrLessTable.setQ23BD4DKRWithChildAndAdults();
				q23bExitDestination90DaysOrLessTable.setQ23BD4DKRWithOnlyChild();
				q23bExitDestination90DaysOrLessTable.setQ23BD4DKRUnknownHouseHold();
				//38
				q23bExitDestination90DaysOrLessTable.setQ23BD5InfoMissingTotal();
				q23bExitDestination90DaysOrLessTable.setQ23BD5InfoMissingWithoutChild();
				q23bExitDestination90DaysOrLessTable.setQ23BD5InfoMissingWithChildAndAdults();
				q23bExitDestination90DaysOrLessTable.setQ23BD5InfoMissingWithOnlyChild();
				q23bExitDestination90DaysOrLessTable.setQ23BD5InfoMissingUnknownHouseHold();
				//39
				q23bExitDestination90DaysOrLessTable.setQ23BDzTotTotal();
				q23bExitDestination90DaysOrLessTable.setQ23BDzTotWithoutChild();
				q23bExitDestination90DaysOrLessTable.setQ23BDzTotWithChildAndAdults();
				q23bExitDestination90DaysOrLessTable.setQ23BDzTotWithOnlyChild();
				q23bExitDestination90DaysOrLessTable.setQ23BDzTotUnknownHouseHold();
				
				//40
				q23bExitDestination90DaysOrLessTable.setQ23BETotTotal();
				q23bExitDestination90DaysOrLessTable.setQ23BETotWithoutChild();
				q23bExitDestination90DaysOrLessTable.setQ23BETotWithChildAndAdults();
				q23bExitDestination90DaysOrLessTable.setQ23BETotWithOnlyChild();
				q23bExitDestination90DaysOrLessTable.setQ23BETotUnknownHouseHold();
				
				//41
				q23bExitDestination90DaysOrLessTable.setQ23BTotPersonsExistUnknownHouseHold();
				q23bExitDestination90DaysOrLessTable.setQ23BTotPersonsExistWithOnlyChild();
				q23bExitDestination90DaysOrLessTable.setQ23BTotPersonsExistWithChildAndAdults();
				q23bExitDestination90DaysOrLessTable.setQ23BTotPersonsExistWithoutChild();
				q23bExitDestination90DaysOrLessTable.setQ23BTotPersonsExistTotal();
				//42
				q23bExitDestination90DaysOrLessTable.setQ23BTotPersonsDstnsWithoutChild();
				q23bExitDestination90DaysOrLessTable.setQ23BTotPersonsDstnsTotal();
				q23bExitDestination90DaysOrLessTable.setQ23BTotPersonsDstnsUnknownHouseHold();
				q23bExitDestination90DaysOrLessTable.setQ23BTotPersonsDstnsWithOnlyChild();
				q23bExitDestination90DaysOrLessTable.setQ23BTotPersonsDstnsWithChildAndAdults();
				
				// percentage below.
				//43
				q23bExitDestination90DaysOrLessTable.setQ23BPercentageWithChildAndAdults();
				q23bExitDestination90DaysOrLessTable.setQ23BPercentageUnknownHouseHold();
				q23bExitDestination90DaysOrLessTable.setQ23BPercentageWithOnlyChild();
				q23bExitDestination90DaysOrLessTable.setQ23BPercentageWithoutChild();
				q23bExitDestination90DaysOrLessTable.setQ23BPercentageTotal();
		
			}	}catch(Exception e){
				logger.error("Error in Q22dLengthOfParticipationByHouseholdTypeDataBeanMaker:" + e);
			}
			return Arrays.asList(q23bExitDestination90DaysOrLessTable);
	
	}
	
	
	public static int  getDestination (List<Q22BeanModel> q22Beans , int numOfDays, String destination) {
		if(CollectionUtils.isNotEmpty(q22Beans)) {
			List<Q22BeanModel>  q22Bean7DaysOrLessAllData = q22Beans.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() > numOfDays  && StringUtils.equals(destination, q22BeanModel.getDestination())).collect(Collectors.toList());
			return q22Bean7DaysOrLessAllData.size();
		}
		 return 0;
	}

}
