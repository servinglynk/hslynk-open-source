package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.ArrayList;
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
				" select distinct(e.dedup_client_id ),p.projecttype,p.trackingmethod,p.operatingstartdate,ext.exitdate,e.entrydate,mid.moveindate,ext.destination  from %s.enrollment e join %s.project p  on (e.projectid = p.id  %p ) "+
				" left outer join %s.exit ext on ( e.id = ext.enrollmentid and ext.exitdate >= :startDate  and ext.exitdate <= :endDate) "+
				" left outer join %s.moveindate mid on (e.id = mid.enrollmentid) "+
				" join %s.enrollment e1 on (e.householdid = e1.householdid and e1.relationshipToHoH='1') ";
		
		try {
			if(data.isLiveMode()) {
				List<Q22BeanModel> allData = getQ22BeanLengthOfStayForExit(data, query, null,true,true);
				List<Q22BeanModel> withoutChildren = getQ22BeanLengthOfStayForExit(data, query, data.getProjectsHHWithOutChildren(),false,true);
				List<Q22BeanModel> withChildAndAdults = getQ22BeanLengthOfStayForExit(data, query, data.getProjectsHHWithOneAdultChild(),false,true);
				List<Q22BeanModel> withChildren = getQ22BeanLengthOfStayForExit(data, query, data.getProjectsHHWithChildren(),false,true);
				List<Q22BeanModel> unknown = getQ22BeanLengthOfStayForExit(data, query, data.getProjectsUnknownHouseHold(),false,true);
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
				
				int subTotal1AllData = allTotal3 + allTotal4+ allTotal5+ allTotal6+ allTotal7 + allTotal8 + allTotal9 + allTotal10 + allTotal11 + allTotal12 + allTotal13;
				int subTotal1WithoutChild = withoutChildren3 + withoutChildren4+ withoutChildren5+ withoutChildren6+ withoutChildren7 + withoutChildren8 + withoutChildren9 + withoutChildren10 + withoutChildren11 + withoutChildren12 + withoutChildren13;
				int subTotal1WithChildAndAdults = withChildAndAdults3 + withChildAndAdults4+ withChildAndAdults5+ withChildAndAdults6+ withChildAndAdults7 + withChildAndAdults8 + withChildAndAdults9 + withChildAndAdults10 + withChildAndAdults11 + withChildAndAdults12 + withChildAndAdults13;
				int subTotal1WithChildren = withChildren3 + withChildren4+ withChildren5+ withChildren6+ withChildren7 + withChildren8 + withChildren9 + withChildren10 + withChildren11 + withChildren12 + withChildren13;
				int subTotal1Unknown = unknown3 + unknown4+ unknown5+ unknown6+ unknown7 + unknown8 + unknown9 + unknown10 + unknown11 + unknown12 + unknown13;
				
				
				//Sandeep TODO :  Missing row for # 13 Rental by client, with RRH or equivalent subsidy
				//14
				q23bExitDestination90DaysOrLessTable.setQ23BAzTotTotal(BigInteger.valueOf(subTotal1AllData));
				q23bExitDestination90DaysOrLessTable.setQ23BAzTotWithoutChild(BigInteger.valueOf(subTotal1WithoutChild));
				q23bExitDestination90DaysOrLessTable.setQ23BAzTotWithChildAndAdults(BigInteger.valueOf(subTotal1WithChildAndAdults));
				q23bExitDestination90DaysOrLessTable.setQ23BAzTotWithOnlyChild(BigInteger.valueOf(subTotal1WithChildren));
				q23bExitDestination90DaysOrLessTable.setQ23BAzTotUnknownHouseHold(BigInteger.valueOf(subTotal1Unknown));
				// Permanent Housing sub total above
				
//				q23bExitDestination90DaysOrLessTable.setQ23BBTemporaryDestinationsTotal(BigInteger.valueOf(0));
//				q23bExitDestination90DaysOrLessTable.setQ23BBTemporaryDestinationsWithoutChild(BigInteger.valueOf(0));
//				q23bExitDestination90DaysOrLessTable.setQ23BBTemporaryDestinationsWithChildAndAdults(BigInteger.valueOf(0));
//				q23bExitDestination90DaysOrLessTable.setQ23BBTemporaryDestinationsWithOnlyChild(BigInteger.valueOf(0));
//				q23bExitDestination90DaysOrLessTable.setQ23BBTemporaryDestinationsUnknownHouseHold(BigInteger.valueOf(0));

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
				
				int subTotal2AllData =  allTotal16+ allTotal17 + allTotal18 + allTotal19 + allTotal20 + allTotal21 + allTotal22 + allTotal23;
				int subTotal2WithoutChild =  withoutChildren16+ withoutChildren17 + withoutChildren18 + withoutChildren19 + withoutChildren20 + withoutChildren21 + withoutChildren22 + withoutChildren23;
				int subTotal2WithChildAndAdults = withChildAndAdult16 + withChildAndAdult17 + withChildAndAdult18 + withChildAndAdult19 + withChildAndAdult20 + withChildAndAdult21 + withChildAndAdult22 + withChildAndAdult23;
				int subTotal2WithChildren =  withChildren16+ withChildren17 + withChildren18 + withChildren19 + withChildren20 + withChildren21 + withChildren22 + withChildren23;
				int subTotal2Unknown = unknown16+ unknown17 + unknown18 + unknown19 + unknown20 + unknown21 + unknown22 + unknown23;
				
				//16
				q23bExitDestination90DaysOrLessTable.setQ23BB1EmergencyShelterTotal(BigInteger.valueOf(allTotal16));
				q23bExitDestination90DaysOrLessTable.setQ23BB1EmergencyShelterWithoutChild(BigInteger.valueOf(withoutChildren16));
				q23bExitDestination90DaysOrLessTable.setQ23BB1EmergencyShelterWithChildAndAdults(BigInteger.valueOf(withChildAndAdult16));
				q23bExitDestination90DaysOrLessTable.setQ23BB1EmergencyShelterWithOnlyChild(BigInteger.valueOf(withChildren16));
				q23bExitDestination90DaysOrLessTable.setQ23BB1EmergencyShelterUnknownHouseHold(BigInteger.valueOf(unknown16));
				//17
				q23bExitDestination90DaysOrLessTable.setQ23BB2MovedFromOneHOPWATotal(BigInteger.valueOf(allTotal17));
				q23bExitDestination90DaysOrLessTable.setQ23BB2MovedFromOneHOPWAWithoutChild(BigInteger.valueOf(withoutChildren17));
				q23bExitDestination90DaysOrLessTable.setQ23BB2MovedFromOneHOPWAWithChildAndAdults(BigInteger.valueOf(withChildAndAdult17));
				q23bExitDestination90DaysOrLessTable.setQ23BB2MovedFromOneHOPWAWithOnlyChild(BigInteger.valueOf(withChildren17));
				q23bExitDestination90DaysOrLessTable.setQ23BB2MovedFromOneHOPWAUnknownHouseHold(BigInteger.valueOf(unknown17));
				//18
				q23bExitDestination90DaysOrLessTable.setQ23BB3TransitionalHousingForHomeLessTotal(BigInteger.valueOf(allTotal18));
				q23bExitDestination90DaysOrLessTable.setQ23BB3TransitionalHousingForHomeLessWithoutChild(BigInteger.valueOf(withoutChildren18));
				q23bExitDestination90DaysOrLessTable.setQ23BB3TransitionalHousingForHomeLessWithChildAndAdults(BigInteger.valueOf(withChildAndAdult18));
				q23bExitDestination90DaysOrLessTable.setQ23BB3TransitionalHousingForHomeLessWithOnlyChild(BigInteger.valueOf(withChildren18));
				q23bExitDestination90DaysOrLessTable.setQ23BB3TransitionalHousingForHomeLessUnknownHouseHold(BigInteger.valueOf(unknown18));
				//19
				q23bExitDestination90DaysOrLessTable.setQ23BB4StayingWithFamilyTemporaryTenureTotal(BigInteger.valueOf(allTotal19));
				q23bExitDestination90DaysOrLessTable.setQ23BB4StayingWithFamilyTemporaryTenureWithoutChild(BigInteger.valueOf(withoutChildren19));
				q23bExitDestination90DaysOrLessTable.setQ23BB4StayingWithFamilyTemporaryTenureWithChildAndAdults(BigInteger.valueOf(withChildAndAdult19));
				q23bExitDestination90DaysOrLessTable.setQ23BB4StayingWithFamilyTemporaryTenureWithOnlyChild(BigInteger.valueOf(withChildren19));
				q23bExitDestination90DaysOrLessTable.setQ23BB4StayingWithFamilyTemporaryTenureUnknownHouseHold(BigInteger.valueOf(unknown19));
				//20
				q23bExitDestination90DaysOrLessTable.setQ23BB5StayingWithFriendsTemporaryTenureTotal(BigInteger.valueOf(allTotal20));
				q23bExitDestination90DaysOrLessTable.setQ23BB5StayingWithFriendsTemporaryTenureWithoutChild(BigInteger.valueOf(withoutChildren20));
				q23bExitDestination90DaysOrLessTable.setQ23BB5StayingWithFriendsTemporaryTenureWithChildAndAdults(BigInteger.valueOf(withChildAndAdult20));
				q23bExitDestination90DaysOrLessTable.setQ23BB5StayingWithFriendsTemporaryTenureWithOnlyChild(BigInteger.valueOf(withChildren20));
				q23bExitDestination90DaysOrLessTable.setQ23BB5StayingWithFriendsTemporaryTenureUnknownHouseHold(BigInteger.valueOf(unknown20));
				//21
				q23bExitDestination90DaysOrLessTable.setQ23BB6PlaceNotMeantForHumanHabitationTotal(BigInteger.valueOf(allTotal21));
				q23bExitDestination90DaysOrLessTable.setQ23BB6PlaceNotMeantForHumanHabitationWithoutChild(BigInteger.valueOf(withoutChildren21));
				q23bExitDestination90DaysOrLessTable.setQ23BB6PlaceNotMeantForHumanHabitationWithChildAndAdults(BigInteger.valueOf(withChildAndAdult21));
				q23bExitDestination90DaysOrLessTable.setQ23BB6PlaceNotMeantForHumanHabitationWithOnlyChild(BigInteger.valueOf(withChildren21));
				q23bExitDestination90DaysOrLessTable.setQ23BB6PlaceNotMeantForHumanHabitationUnknownHouseHold(BigInteger.valueOf(unknown21));
				//22
				q23bExitDestination90DaysOrLessTable.setQ23BB7SafeHavenTotal(BigInteger.valueOf(allTotal22));
				q23bExitDestination90DaysOrLessTable.setQ23BB7SafeHavenWithoutChild(BigInteger.valueOf(withoutChildren22));
				q23bExitDestination90DaysOrLessTable.setQ23BB7SafeHavenWithChildAndAdults(BigInteger.valueOf(withChildAndAdult22));
				q23bExitDestination90DaysOrLessTable.setQ23BB7SafeHavenWithOnlyChild(BigInteger.valueOf(withChildren22));
				q23bExitDestination90DaysOrLessTable.setQ23BB7SafeHavenUnknownHouseHold(BigInteger.valueOf(unknown22));
				//23
				q23bExitDestination90DaysOrLessTable.setQ23BB8HotelOrMotelPaidByClientTotal(BigInteger.valueOf(allTotal23));
				q23bExitDestination90DaysOrLessTable.setQ23BB8HotelOrMotelPaidByClientWithoutChild(BigInteger.valueOf(withoutChildren23));
				q23bExitDestination90DaysOrLessTable.setQ23BB8HotelOrMotelPaidByClientWithChildAndAdults(BigInteger.valueOf(withChildAndAdult23));
				q23bExitDestination90DaysOrLessTable.setQ23BB8HotelOrMotelPaidByClientWithOnlyChild(BigInteger.valueOf(withChildren23));
				q23bExitDestination90DaysOrLessTable.setQ23BB8HotelOrMotelPaidByClientUnknownHouseHold(BigInteger.valueOf(unknown23));
				
				//24
				q23bExitDestination90DaysOrLessTable.setQ23BBzTotTotal(BigInteger.valueOf(subTotal2AllData));
				q23bExitDestination90DaysOrLessTable.setQ23BBzTotWithoutChild(BigInteger.valueOf(subTotal2WithoutChild));
				q23bExitDestination90DaysOrLessTable.setQ23BBzTotWithChildAndAdults(BigInteger.valueOf(subTotal2WithChildAndAdults));
				q23bExitDestination90DaysOrLessTable.setQ23BBzTotWithOnlyChild(BigInteger.valueOf(subTotal2WithChildren));
				q23bExitDestination90DaysOrLessTable.setQ23BBzTotUnknownHouseHold(BigInteger.valueOf(subTotal2Unknown));
				// Temp Housing sub total above
				
				//Sandeep TODO : need to remove the below  row or it can be empty string.
//				q23bExitDestination90DaysOrLessTable.setQ23BCInstitutionalSettingsTotal(BigInteger.valueOf(0));
//				q23bExitDestination90DaysOrLessTable.setQ23BCInstitutionalSettingsWithoutChild(BigInteger.valueOf(0));
//				q23bExitDestination90DaysOrLessTable.setQ23BCInstitutionalSettingsWithChildAndAdults(BigInteger.valueOf(0));
//				q23bExitDestination90DaysOrLessTable.setQ23BCInstitutionalSettingsWithOnlyChild(BigInteger.valueOf(0));
//				q23bExitDestination90DaysOrLessTable.setQ23BCInstitutionalSettingsUnknownHouseHold(BigInteger.valueOf(0));
				
				
				int allTotal26 = getDestination(allData, numOfDays, "15");
				int allTotal27 = getDestination(allData, numOfDays, "4");
				int allTotal28 = getDestination(allData, numOfDays, "5");
				int allTotal29 = getDestination(allData, numOfDays, "6");
				int allTotal30 = getDestination(allData, numOfDays, "7");
				int allTotal31 = getDestination(allData, numOfDays, "25");
				
				int withoutChildren26 = getDestination(withoutChildren, numOfDays, "15");
				int withoutChildren27 = getDestination(withoutChildren, numOfDays, "4");
				int withoutChildren28 = getDestination(withoutChildren, numOfDays, "5");
				int withoutChildren29 = getDestination(withoutChildren, numOfDays, "6");
				int withoutChildren30 = getDestination(withoutChildren, numOfDays, "7");
				int withoutChildren31 = getDestination(withoutChildren, numOfDays, "25");
				
				int withChildAndAdult26 = getDestination(withChildAndAdults, numOfDays, "15");
				int withChildAndAdult27 = getDestination(withChildAndAdults, numOfDays, "4");
				int withChildAndAdult28 = getDestination(withChildAndAdults, numOfDays, "5");
				int withChildAndAdult29 = getDestination(withChildAndAdults, numOfDays, "6");
				int withChildAndAdult30 = getDestination(withChildAndAdults, numOfDays, "7");
				int withChildAndAdult31 = getDestination(withChildAndAdults, numOfDays, "25");
				
				int withChildren26 = getDestination(withChildren, numOfDays, "15");
				int withChildren27 = getDestination(withChildren, numOfDays, "4");
				int withChildren28 = getDestination(withChildren, numOfDays, "5");
				int withChildren29 = getDestination(withChildren, numOfDays, "6");
				int withChildren30 = getDestination(withChildren, numOfDays, "7");
				int withChildren31 = getDestination(withChildren, numOfDays, "25");
				
				int unknown26 = getDestination(unknown, numOfDays, "15");
				int unknown27 = getDestination(unknown, numOfDays, "4");
				int unknown28 = getDestination(unknown, numOfDays, "5");
				int unknown29 = getDestination(unknown, numOfDays, "6");
				int unknown30 = getDestination(unknown, numOfDays, "7");
				int unknown31 = getDestination(unknown, numOfDays, "25");
				
				int subTotal3AllData =  allTotal26+ allTotal27 + allTotal28 + allTotal29 + allTotal30 + allTotal31 ;
				int subTotal3WithoutChild =  withoutChildren26+ withoutChildren27 + withoutChildren28 + withoutChildren29 + withoutChildren30 + withoutChildren31 ;
				int subTotal3WithChildAndAdults = withChildAndAdult26 + withChildAndAdult27 + withChildAndAdult28 + withChildAndAdult29 + withChildAndAdult30 + withChildAndAdult31 ;
				int subTotal3WithChildren =  withChildren26+ withChildren27 + withChildren28 + withChildren29 + withChildren30 + withChildren31 ;
				int subTotal3Unknown = unknown26+ unknown27 + unknown28 + unknown29 + unknown30 + unknown31 ;
				
				//26
				q23bExitDestination90DaysOrLessTable.setQ23BC1FosterCareHomeOrGroupFosterCareTotal(BigInteger.valueOf(allTotal26));
				q23bExitDestination90DaysOrLessTable.setQ23BC1FosterCareHomeOrGroupFosterCareWithoutChild(BigInteger.valueOf(withoutChildren26));
				q23bExitDestination90DaysOrLessTable.setQ23BC1FosterCareHomeOrGroupFosterCareWithChildAndAdults(BigInteger.valueOf(withChildAndAdult26));
				q23bExitDestination90DaysOrLessTable.setQ23BC1FosterCareHomeOrGroupFosterCareWithOnlyChild(BigInteger.valueOf(withChildren26));
				q23bExitDestination90DaysOrLessTable.setQ23BC1FosterCareHomeOrGroupFosterCareUnknownHouseHold(BigInteger.valueOf(unknown26));
				//27
				q23bExitDestination90DaysOrLessTable.setQ23BC2PsychiatricHospitalOrOtherTotal(BigInteger.valueOf(allTotal27));
				q23bExitDestination90DaysOrLessTable.setQ23BC2PsychiatricHospitalOrOtherWithoutChild(BigInteger.valueOf(withoutChildren27));
				q23bExitDestination90DaysOrLessTable.setQ23BC2PsychiatricHospitalOrOtherWithChildAndAdults(BigInteger.valueOf(withChildAndAdult27));
				q23bExitDestination90DaysOrLessTable.setQ23BC2PsychiatricHospitalOrOtherWithOnlyChild(BigInteger.valueOf(withChildren27));
				q23bExitDestination90DaysOrLessTable.setQ23BC2PsychiatricHospitalOrOtherUnknownHouseHold(BigInteger.valueOf(unknown27));
				//28
				q23bExitDestination90DaysOrLessTable.setQ23BC3SubstanceAbuseTreatmentFacilityTotal(BigInteger.valueOf(allTotal28));
				q23bExitDestination90DaysOrLessTable.setQ23BC3SubstanceAbuseTreatmentFacilityWithoutChild(BigInteger.valueOf(withoutChildren28));
				q23bExitDestination90DaysOrLessTable.setQ23BC3SubstanceAbuseTreatmentFacilityWithChildAndAdults(BigInteger.valueOf(withChildAndAdult28));
				q23bExitDestination90DaysOrLessTable.setQ23BC3SubstanceAbuseTreatmentFacilityWithOnlyChild(BigInteger.valueOf(withChildren28));
				q23bExitDestination90DaysOrLessTable.setQ23BC3SubstanceAbuseTreatmentFacilityUnknownHouseHold(BigInteger.valueOf(unknown28));
				//29
				q23bExitDestination90DaysOrLessTable.setQ23BC4HospitalOrOtherTotal(BigInteger.valueOf(allTotal29));
				q23bExitDestination90DaysOrLessTable.setQ23BC4HospitalOrOtherWithoutChild(BigInteger.valueOf(withoutChildren29));
				q23bExitDestination90DaysOrLessTable.setQ23BC4HospitalOrOtherWithChildAndAdults(BigInteger.valueOf(withChildAndAdult29));
				q23bExitDestination90DaysOrLessTable.setQ23BC4HospitalOrOtherWithOnlyChild(BigInteger.valueOf(withChildren29));
				q23bExitDestination90DaysOrLessTable.setQ23BC4HospitalOrOtherUnknownHouseHold(BigInteger.valueOf(unknown29));
				//30
				q23bExitDestination90DaysOrLessTable.setQ23BC5JailPrisonOrJuvenileDetentionTotal(BigInteger.valueOf(allTotal30));
				q23bExitDestination90DaysOrLessTable.setQ23BC5JailPrisonOrJuvenileDetentionWithoutChild(BigInteger.valueOf(withoutChildren30));
				q23bExitDestination90DaysOrLessTable.setQ23BC5JailPrisonOrJuvenileDetentionWithChildAndAdults(BigInteger.valueOf(withChildAndAdult30));
				q23bExitDestination90DaysOrLessTable.setQ23BC5JailPrisonOrJuvenileDetentionWithOnlyChild(BigInteger.valueOf(withChildren30));
				q23bExitDestination90DaysOrLessTable.setQ23BC5JailPrisonOrJuvenileDetentionUnknownHouseHold(BigInteger.valueOf(unknown30));
				//31
				q23bExitDestination90DaysOrLessTable.setQ23BC6LongTermCareFacilityOrNursingHomeTotal(BigInteger.valueOf(allTotal31));
				q23bExitDestination90DaysOrLessTable.setQ23BC6LongTermCareFacilityOrNursingHomeWithoutChild(BigInteger.valueOf(withoutChildren31));
				q23bExitDestination90DaysOrLessTable.setQ23BC6LongTermCareFacilityOrNursingHomeWithChildAndAdults(BigInteger.valueOf(withChildAndAdult31));
				q23bExitDestination90DaysOrLessTable.setQ23BC6LongTermCareFacilityOrNursingHomeWithOnlyChild(BigInteger.valueOf(withChildren31));
				q23bExitDestination90DaysOrLessTable.setQ23BC6LongTermCareFacilityOrNursingHomeUnknownHouseHold(BigInteger.valueOf(unknown31));
				
				//32
				q23bExitDestination90DaysOrLessTable.setQ23BCzTotTotal(BigInteger.valueOf(subTotal3AllData));
				q23bExitDestination90DaysOrLessTable.setQ23BCzTotWithoutChild(BigInteger.valueOf(subTotal3WithoutChild));
				q23bExitDestination90DaysOrLessTable.setQ23BCzTotWithChildAndAdults(BigInteger.valueOf(subTotal3WithChildAndAdults));
				q23bExitDestination90DaysOrLessTable.setQ23BCzTotWithOnlyChild(BigInteger.valueOf(subTotal3WithChildren));
				q23bExitDestination90DaysOrLessTable.setQ23BCzTotUnknownHouseHold(BigInteger.valueOf(subTotal3Unknown));
				
				// 33  No data needs to be populdated for 33...
//				q23bExitDestination90DaysOrLessTable.setQ23BDOtherDestinationsTotal(BigInteger.valueOf(0));
//				q23bExitDestination90DaysOrLessTable.setQ23BDOtherDestinationsWithoutChild(BigInteger.valueOf(0));
//				q23bExitDestination90DaysOrLessTable.setQ23BDOtherDestinationsWithChildAndAdults(BigInteger.valueOf(0));
//				q23bExitDestination90DaysOrLessTable.setQ23BDOtherDestinationsWithOnlyChild(BigInteger.valueOf(0));
//				q23bExitDestination90DaysOrLessTable.setQ23BDOtherDestinationsUnknownHouseHold(BigInteger.valueOf(0));
//				
				
				int allTotal34 = getDestination(allData, numOfDays, "29");
				int allTotal35 = getDestination(allData, numOfDays, "24");
				int allTotal36 = getDestination(allData, numOfDays, "17");
				int allTotal37 = getDestination(allData, numOfDays, "8","9");
				int allTotal38 = getDestination(allData, numOfDays, "30","99");
				
				int withoutChildren34 = getDestination(withoutChildren, numOfDays, "29");
				int withoutChildren35 = getDestination(withoutChildren, numOfDays, "24");
				int withoutChildren36 = getDestination(withoutChildren, numOfDays, "17");
				int withoutChildren37 = getDestination(withoutChildren, numOfDays, "8","9");
				int withoutChildren38 = getDestination(withoutChildren, numOfDays, "30","99");
				
				int withChildAndAdult34 = getDestination(withChildAndAdults, numOfDays, "29");
				int withChildAndAdult35 = getDestination(withChildAndAdults, numOfDays, "24");
				int withChildAndAdult36 = getDestination(withChildAndAdults, numOfDays, "17");
				int withChildAndAdult37 = getDestination(withChildAndAdults, numOfDays, "8","9");
				int withChildAndAdult38 = getDestination(withChildAndAdults, numOfDays, "30","99");
				
				int withChildren34 = getDestination(withChildren, numOfDays, "29");
				int withChildren35 = getDestination(withChildren, numOfDays, "24");
				int withChildren36 = getDestination(withChildren, numOfDays, "17");
				int withChildren37 = getDestination(withChildren, numOfDays,"8","9");
				int withChildren38 = getDestination(withChildren, numOfDays, "30","99");
				
				int unknown34 = getDestination(unknown, numOfDays, "29");
				int unknown35 = getDestination(unknown, numOfDays, "24");
				int unknown36 = getDestination(unknown, numOfDays, "17");
				int unknown37 = getDestination(unknown, numOfDays, "8","9");
				int unknown38 = getDestination(unknown, numOfDays, "30","99");
				
				
				int subTotal4AllData =  allTotal34+ allTotal35 + allTotal36 + allTotal37 + allTotal38 ;
				int subTotal4WithoutChild =  withoutChildren34+ withoutChildren35 + withoutChildren36 + withoutChildren37 + withoutChildren38  ;
				int subTotal4WithChildAndAdults = withChildAndAdult34 + withChildAndAdult35 + withChildAndAdult36 + withChildAndAdult37 + withChildAndAdult38 ;
				int subTotal4WithChildren =  withChildren34+ withChildren35  + withChildren36 + withChildren37 + withChildren38 ;
				int subTotal4Unknown = unknown34+ unknown35 + unknown36 + unknown37 + unknown38 ;
				
				// Other Destination sub total above
				//34
				q23bExitDestination90DaysOrLessTable.setQ23BD1ResidentialProjectorHalfwayHouseTotal(BigInteger.valueOf(allTotal34));
				q23bExitDestination90DaysOrLessTable.setQ23BD1ResidentialProjectorHalfwayHouseWithoutChild(BigInteger.valueOf(withoutChildren34));
				q23bExitDestination90DaysOrLessTable.setQ23BD1ResidentialProjectorHalfwayHouseWithChildAndAdults(BigInteger.valueOf(withChildAndAdult34));
				q23bExitDestination90DaysOrLessTable.setQ23BD1ResidentialProjectorHalfwayHouseWithOnlyChild(BigInteger.valueOf(withChildren34));
				q23bExitDestination90DaysOrLessTable.setQ23BD1ResidentialProjectorHalfwayHouseUnknownHouseHold(BigInteger.valueOf(unknown34));
				//35
				q23bExitDestination90DaysOrLessTable.setQ23BD2DeceasedTotal(BigInteger.valueOf(allTotal35));
				q23bExitDestination90DaysOrLessTable.setQ23BD2DeceasedWithoutChild(BigInteger.valueOf(withoutChildren35));
				q23bExitDestination90DaysOrLessTable.setQ23BD2DeceasedWithChildAndAdults(BigInteger.valueOf(withChildAndAdult36));
				q23bExitDestination90DaysOrLessTable.setQ23BD2DeceasedWithOnlyChild(BigInteger.valueOf(withChildren35));
				q23bExitDestination90DaysOrLessTable.setQ23BD2DeceasedUnknownHouseHold(BigInteger.valueOf(unknown35));
				//36
				q23bExitDestination90DaysOrLessTable.setQ23BD3OtherTotal(BigInteger.valueOf(allTotal36));
				q23bExitDestination90DaysOrLessTable.setQ23BD3OtherWithoutChild(BigInteger.valueOf(withoutChildren36));
				q23bExitDestination90DaysOrLessTable.setQ23BD3OtherWithChildAndAdults(BigInteger.valueOf(withChildAndAdult36));
				q23bExitDestination90DaysOrLessTable.setQ23BD3OtherWithOnlyChild(BigInteger.valueOf(withChildren36));
				q23bExitDestination90DaysOrLessTable.setQ23BD3OtherUnknownHouseHold(BigInteger.valueOf(unknown36));
				//37
				q23bExitDestination90DaysOrLessTable.setQ23BD4DKRTotal(BigInteger.valueOf(allTotal37));
				q23bExitDestination90DaysOrLessTable.setQ23BD4DKRWithoutChild(BigInteger.valueOf(withoutChildren37));
				q23bExitDestination90DaysOrLessTable.setQ23BD4DKRWithChildAndAdults(BigInteger.valueOf(withChildAndAdult37));
				q23bExitDestination90DaysOrLessTable.setQ23BD4DKRWithOnlyChild(BigInteger.valueOf(withChildren37));
				q23bExitDestination90DaysOrLessTable.setQ23BD4DKRUnknownHouseHold(BigInteger.valueOf(unknown37));
				//38
				q23bExitDestination90DaysOrLessTable.setQ23BD5InfoMissingTotal(BigInteger.valueOf(allTotal38));
				q23bExitDestination90DaysOrLessTable.setQ23BD5InfoMissingWithoutChild(BigInteger.valueOf(withoutChildren38));
				q23bExitDestination90DaysOrLessTable.setQ23BD5InfoMissingWithChildAndAdults(BigInteger.valueOf(withChildAndAdult38));
				q23bExitDestination90DaysOrLessTable.setQ23BD5InfoMissingWithOnlyChild(BigInteger.valueOf(withChildren38));
				q23bExitDestination90DaysOrLessTable.setQ23BD5InfoMissingUnknownHouseHold(BigInteger.valueOf(unknown38));

				//39
				q23bExitDestination90DaysOrLessTable.setQ23BDzTotTotal(BigInteger.valueOf(subTotal4AllData));
				q23bExitDestination90DaysOrLessTable.setQ23BDzTotWithoutChild(BigInteger.valueOf(subTotal4WithoutChild));
				q23bExitDestination90DaysOrLessTable.setQ23BDzTotWithChildAndAdults(BigInteger.valueOf(subTotal4WithChildAndAdults));
				q23bExitDestination90DaysOrLessTable.setQ23BDzTotWithOnlyChild(BigInteger.valueOf(subTotal4WithChildren));
				q23bExitDestination90DaysOrLessTable.setQ23BDzTotUnknownHouseHold(BigInteger.valueOf(subTotal4Unknown));
				
				int totalAllData = subTotal1AllData + subTotal2AllData + subTotal3AllData + subTotal4AllData ;
				int totalWithoutChild = subTotal1WithoutChild + subTotal2WithoutChild + subTotal3WithoutChild + subTotal4WithoutChild;
				int totalWithChildAndAdults = subTotal1WithChildAndAdults + subTotal2WithChildAndAdults + subTotal3WithChildAndAdults + subTotal4WithChildAndAdults;
				int totalWithChildren = subTotal1WithChildren + subTotal2WithChildren + subTotal3WithChildren + subTotal4WithChildren;
				int totalUnknown = subTotal1Unknown + subTotal2Unknown + subTotal3Unknown + subTotal4Unknown ;
				//40
				q23bExitDestination90DaysOrLessTable.setQ23BETotTotal(BigInteger.valueOf(getSize(data.getAdultLeavers())));
				q23bExitDestination90DaysOrLessTable.setQ23BETotWithoutChild(BigInteger.valueOf(totalWithoutChild));
				q23bExitDestination90DaysOrLessTable.setQ23BETotWithChildAndAdults(BigInteger.valueOf(totalWithChildAndAdults));
				q23bExitDestination90DaysOrLessTable.setQ23BETotWithOnlyChild(BigInteger.valueOf(totalWithChildren));
				q23bExitDestination90DaysOrLessTable.setQ23BETotUnknownHouseHold(BigInteger.valueOf(totalUnknown));
				
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
			
				int destinationByDestinationTypeAllData = getDestinationByDestinationType(allData, numOfDays, positiveDestinationTypes);
				int destinationByProjectTypeAllData = getDestinationByProjectType(allData, numOfDays, tempInstDestinationTypes, "6");
				int positiveHousingAllData = destinationByDestinationTypeAllData + destinationByProjectTypeAllData ;
				
				int destinationByDestinationTypeWithoutChildren = getDestinationByDestinationType(withoutChildren, numOfDays, positiveDestinationTypes);
				int destinationByProjectTypeWithoutChildren = getDestinationByProjectType(withoutChildren, numOfDays, tempInstDestinationTypes, "6");
				int positiveHousingWithoutChildren = destinationByDestinationTypeWithoutChildren + destinationByProjectTypeWithoutChildren ;
				
				int destinationByDestinationTypeWithChildAndAdults = getDestinationByDestinationType(withChildAndAdults, numOfDays, positiveDestinationTypes);
				int destinationByProjectTypeWithChildAndAdults = getDestinationByProjectType(withChildAndAdults, numOfDays, tempInstDestinationTypes, "6");
				int positiveHousingWithChildAndAdults = destinationByDestinationTypeWithChildAndAdults + destinationByProjectTypeWithChildAndAdults ;
				
				int destinationByDestinationTypeWithChildren = getDestinationByDestinationType(withChildren, numOfDays, positiveDestinationTypes);
				int destinationByProjectTypeWithChildren = getDestinationByProjectType(withChildren, numOfDays, tempInstDestinationTypes, "6");
				int positiveHousingWithChildren = destinationByDestinationTypeWithChildren + destinationByProjectTypeWithChildren ;
				
				int destinationByDestinationTypeUnknown = getDestinationByDestinationType(unknown, numOfDays, positiveDestinationTypes);
				int destinationByProjectTypeUnknown = getDestinationByProjectType(unknown, numOfDays, tempInstDestinationTypes, "6");
				int positiveHousingWithoutUnknown = destinationByDestinationTypeUnknown + destinationByProjectTypeUnknown ;
				
				//41
				q23bExitDestination90DaysOrLessTable.setQ23BTotPersonsExistUnknownHouseHold(BigInteger.valueOf(positiveHousingAllData));
				q23bExitDestination90DaysOrLessTable.setQ23BTotPersonsExistWithOnlyChild(BigInteger.valueOf(positiveHousingWithoutChildren));
				q23bExitDestination90DaysOrLessTable.setQ23BTotPersonsExistWithChildAndAdults(BigInteger.valueOf(positiveHousingWithChildAndAdults));
				q23bExitDestination90DaysOrLessTable.setQ23BTotPersonsExistWithoutChild(BigInteger.valueOf(positiveHousingWithChildren));
				q23bExitDestination90DaysOrLessTable.setQ23BTotPersonsExistTotal(BigInteger.valueOf(positiveHousingWithoutUnknown));
				
				List<String> destinationTypeExcluded = new ArrayList<>();
				destinationTypeExcluded.add("6");
				destinationTypeExcluded.add("24");
				
				
				List<String> projectTypeExcluded = new ArrayList<>();
				projectTypeExcluded.add("1");
				projectTypeExcluded.add("2");
				projectTypeExcluded.add("8");
				projectTypeExcluded.add("9");
				projectTypeExcluded.add("10");
				
				int clientsExcludedAllData = getDestinationByDestinationType(allData, numOfDays, destinationTypeExcluded);
				int projectTypeClientsExcludedAllData = getDestinationByProjectTypes(allData, numOfDays, destinationTypeExcluded, projectTypeExcluded);
				int destinationClientsExcludedAllData = clientsExcludedAllData + projectTypeClientsExcludedAllData ;
				
				int clientsExcludedwithoutChildren = getDestinationByDestinationType(withoutChildren, numOfDays, destinationTypeExcluded);
				int projectTypeClientsExcludedwithoutChildren = getDestinationByProjectTypes(withoutChildren, numOfDays, destinationTypeExcluded, projectTypeExcluded);
				int destinationClientsExcludedwithoutChildren = clientsExcludedwithoutChildren + projectTypeClientsExcludedwithoutChildren ;
				
				int clientsExcludedeWithOnlyChild = getDestinationByDestinationType(withChildren, numOfDays, destinationTypeExcluded);
				int projectTypeClientsExcludedeWithOnlyChild = getDestinationByProjectTypes(withChildren, numOfDays, destinationTypeExcluded, projectTypeExcluded);
				int destinationClientsExcludedeWithOnlyChild = clientsExcludedeWithOnlyChild + projectTypeClientsExcludedeWithOnlyChild ;
				
				int clientsExcludedWithChildAndAdults = getDestinationByDestinationType(withChildAndAdults, numOfDays, destinationTypeExcluded);
				int projectTypeClientsExcludedWithChildAndAdults = getDestinationByProjectTypes(withChildAndAdults, numOfDays, destinationTypeExcluded, projectTypeExcluded);
				int destinationClientsExcludedWithChildAndAdults = clientsExcludedWithChildAndAdults + projectTypeClientsExcludedWithChildAndAdults ;
				
				int clientsExcludedWithUnknown = getDestinationByDestinationType(unknown, numOfDays, destinationTypeExcluded);
				int projectTypeClientsExcludedWithUnknown = getDestinationByProjectTypes(unknown, numOfDays, destinationTypeExcluded, projectTypeExcluded);
				int destinationClientsExcludedWithUnknown = clientsExcludedWithUnknown + projectTypeClientsExcludedWithUnknown ;
				
				
				//42
				q23bExitDestination90DaysOrLessTable.setQ23BTotPersonsDstnsWithoutChild(BigInteger.valueOf(destinationClientsExcludedwithoutChildren));
				q23bExitDestination90DaysOrLessTable.setQ23BTotPersonsDstnsTotal(BigInteger.valueOf(destinationClientsExcludedAllData));
				q23bExitDestination90DaysOrLessTable.setQ23BTotPersonsDstnsUnknownHouseHold(BigInteger.valueOf(destinationClientsExcludedWithUnknown));
				q23bExitDestination90DaysOrLessTable.setQ23BTotPersonsDstnsWithOnlyChild(BigInteger.valueOf(destinationClientsExcludedeWithOnlyChild));
				q23bExitDestination90DaysOrLessTable.setQ23BTotPersonsDstnsWithChildAndAdults(BigInteger.valueOf(destinationClientsExcludedWithChildAndAdults));
				
				// percentage below.
				//43 = 41/40-42
				q23bExitDestination90DaysOrLessTable.setQ23BPercentageWithChildAndAdults(BigInteger.valueOf(divide(positiveHousingWithChildAndAdults, totalWithChildAndAdults, destinationClientsExcludedWithChildAndAdults)));
				q23bExitDestination90DaysOrLessTable.setQ23BPercentageUnknownHouseHold(BigInteger.valueOf(divide(positiveHousingWithoutUnknown, totalUnknown, destinationClientsExcludedWithUnknown)));
				q23bExitDestination90DaysOrLessTable.setQ23BPercentageWithOnlyChild(BigInteger.valueOf(divide(positiveHousingWithChildren, totalWithChildren, destinationClientsExcludedeWithOnlyChild)));
				q23bExitDestination90DaysOrLessTable.setQ23BPercentageWithoutChild(BigInteger.valueOf(divide(positiveHousingWithoutChildren, totalWithoutChild, destinationClientsExcludedwithoutChildren)));
				q23bExitDestination90DaysOrLessTable.setQ23BPercentageTotal(BigInteger.valueOf(divide(positiveHousingAllData, totalAllData, destinationClientsExcludedAllData)));
		
			}	}catch(Exception e){
				logger.error("Error in Q22dLengthOfParticipationByHouseholdTypeDataBeanMaker:" + e);
			}
			return Arrays.asList(q23bExitDestination90DaysOrLessTable);
	
	}
	
	
	public static int  getDestination (List<Q22BeanModel> q22Beans , int numOfDays, String destination) {
		if(CollectionUtils.isNotEmpty(q22Beans)) {
			List<Q22BeanModel>  q22Bean7DaysOrLessAllData = q22Beans.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() < numOfDays  && StringUtils.equals(destination, q22BeanModel.getDestination())).collect(Collectors.toList());
			return q22Bean7DaysOrLessAllData.size();
		}
		 return 0;
	}

	public static int  getDestination (List<Q22BeanModel> q22Beans , int numOfDays, String destination1,String destination2) {
		if(CollectionUtils.isNotEmpty(q22Beans)) {
			List<Q22BeanModel>  q22Bean7DaysOrLessAllData = q22Beans.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() < numOfDays  && ( StringUtils.equals(destination1, q22BeanModel.getDestination())  || StringUtils.equals(destination2, q22BeanModel.getDestination()) )).collect(Collectors.toList());
			return q22Bean7DaysOrLessAllData.size();
		}
		 return 0;
	}
	
	public static int  getDestinationByDestinationType(List<Q22BeanModel> q22Beans , int numOfDays, List<String> destinations) {
		if(CollectionUtils.isNotEmpty(q22Beans)) {
			List<Q22BeanModel>  q22Bean7DaysOrLessAllData = q22Beans.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() < numOfDays  && ( destinations.contains(q22BeanModel.getDestination()))).collect(Collectors.toList());
			return q22Bean7DaysOrLessAllData.size();
		}
		 return 0;
	}
	
	public static int  getDestinationByProjectType(List<Q22BeanModel> q22Beans , int numOfDays, List<String> destinations,String projectType) {
		if(CollectionUtils.isNotEmpty(q22Beans)) {
			List<Q22BeanModel>  q22Bean7DaysOrLessAllData = q22Beans.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() < numOfDays  && ( destinations.contains(q22BeanModel.getDestination())) && StringUtils.equals(projectType, q22BeanModel.getProjectType()) ).collect(Collectors.toList());
			return q22Bean7DaysOrLessAllData.size();
		}
		 return 0;
	}
	
	public static int  getDestinationByProjectTypes(List<Q22BeanModel> q22Beans , int numOfDays, List<String> destinations,List<String> projectTypes) {
		if(CollectionUtils.isNotEmpty(q22Beans)) {
			List<Q22BeanModel>  q22Bean7DaysOrLessAllData = q22Beans.parallelStream().filter(q22BeanModel -> q22BeanModel.getNumberOfDays() < numOfDays  && ( destinations.contains(q22BeanModel.getDestination())) && projectTypes.contains(q22BeanModel.getProjectType()) ).collect(Collectors.toList());
			return q22Bean7DaysOrLessAllData.size();
		}
		 return 0;
	}
	
	public static long  divide(int destination41 , int destination40,int destination42) {
		if(destination41 == 0){
			 return 0;
		}
		int subTotal = (destination40 - destination42);
		if(subTotal <= 0) {
			return 0;
		}
		long percentage = destination41/subTotal;
		return percentage;
	}
}
