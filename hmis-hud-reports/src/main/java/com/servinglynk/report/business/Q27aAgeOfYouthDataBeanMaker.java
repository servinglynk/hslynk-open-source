package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import com.servinglynk.report.bean.Q27aAgeOfYouthDataBean;
import com.servinglynk.report.bean.ReportData;

public class Q27aAgeOfYouthDataBeanMaker extends BaseBeanMaker {

	public static List<Q27aAgeOfYouthDataBean> getQ27aAgeOfYouthList(ReportData data){
		
		Q27aAgeOfYouthDataBean q27aAgeOfYoutTable = new Q27aAgeOfYouthDataBean();
		try {
			if(data.isLiveMode()) {
				
				String query = "select distinct(e.dedup_client_id)  "+
							" from %s.client c,%s.enrollment e, %s.project p,%s.exit ext where e.client_id=c.id and e.projectid= p.id  %p and entrydate <= :endDate "+
						      " and e.id not in ( select enrollmentid from %s.exit ext where  ext.exitdate is null  or  ext.exitdate <= :startDate ) ";
				
				List<String> projectsHHWithChildren = data.getProjectsHHWithChildren();
				List<String> projectsHHWithOneAdultChild = data.getProjectsHHWithOneAdultChild();
				List<String> projectsHHWithOutChildren = data.getProjectsHHWithOutChildren();
				List<String> projectsUnknownHouseHold = data.getProjectsUnknownHouseHold();
				
				String query12To17 = " and c.age >= 12 and c.age <= 17 " ;
				int a12To17Total = getSize(getClients(data, query+query12To17, null, true));
				int a12To17WithoutChildSize = getSize(getClients(data, query+query12To17, projectsHHWithOutChildren, false));
				int a12To17ChildAndAdultsSize = getSize(getClients(data, query+query12To17, projectsHHWithOneAdultChild, false));
				int a12To17WithOnlyChildSize = getSize(getClients(data, query+query12To17, projectsHHWithChildren, false));
				int a12To17UnknownHouseHoldSize = getSize(getClients(data, query+query12To17, projectsUnknownHouseHold, false));
				
		
				q27aAgeOfYoutTable.setQ27a12To17Total(BigInteger.valueOf(a12To17Total));
				q27aAgeOfYoutTable.setQ27a12To17WithoutChild(BigInteger.valueOf(a12To17WithoutChildSize));
				q27aAgeOfYoutTable.setQ27a12To17WithChildAndAdults(BigInteger.valueOf(a12To17ChildAndAdultsSize));
				q27aAgeOfYoutTable.setQ27a12To17WithChildOnly(BigInteger.valueOf(a12To17WithOnlyChildSize));
				q27aAgeOfYoutTable.setQ27a12To17UnknownHouseHoldtype(BigInteger.valueOf(a12To17UnknownHouseHoldSize));

				String query18To24 = " and c.age >= 18 and c.age <= 24 " ;
				int a18To24Total = getSize(getClients(data, query+query18To24, null, true));
				int a18To24WithoutChildSize = getSize(getClients(data, query+query18To24, projectsHHWithOutChildren, false));
				int a18To24ChildAndAdultsSize = getSize(getClients(data, query+query18To24, projectsHHWithOneAdultChild, false));
				int a18To24WithOnlyChildSize = getSize(getClients(data, query+query18To24, projectsHHWithChildren, false));
				int a18To24UnknownHouseHoldSize = getSize(getClients(data, query+query18To24, projectsUnknownHouseHold, false));
				
				q27aAgeOfYoutTable.setQ27a18To24Total(BigInteger.valueOf(a18To24Total));
				q27aAgeOfYoutTable.setQ27a18To24WithoutChild(BigInteger.valueOf(a18To24WithoutChildSize));
				q27aAgeOfYoutTable.setQ27a18To24WithChildAndAdults(BigInteger.valueOf(a18To24ChildAndAdultsSize));
				q27aAgeOfYoutTable.setQ27a18To24WithChildOnly(BigInteger.valueOf(a18To24WithOnlyChildSize));
				q27aAgeOfYoutTable.setQ27a18To24UnknownHouseHoldtype(BigInteger.valueOf(a18To24UnknownHouseHoldSize));

				String querydkr = " and c.id=e.client_id and c.dob_data_quality in ('8','9') and c.age <= 24 " ;
				int dkrTotal = getSize(getClients(data, query+querydkr, null, true));
				int dkrWithoutChildSize = getSize(getClients(data, query+querydkr, projectsHHWithOutChildren, false));
				int dkrChildAndAdultsSize = getSize(getClients(data, query+querydkr, projectsHHWithOneAdultChild, false));
				int dkrWithOnlyChildSize = getSize(getClients(data, query+querydkr, projectsHHWithChildren, false));
				int dkrUnknownHouseHoldSize = getSize(getClients(data, query+querydkr, projectsUnknownHouseHold, false));
				
				q27aAgeOfYoutTable.setQ27aDKRTotal(BigInteger.valueOf(dkrTotal));
				q27aAgeOfYoutTable.setQ27aDKRWithoutChild(BigInteger.valueOf(dkrWithoutChildSize));
				q27aAgeOfYoutTable.setQ27aDKRWithChildAndAdults(BigInteger.valueOf(dkrChildAndAdultsSize));
				q27aAgeOfYoutTable.setQ27aDKRWithChildOnly(BigInteger.valueOf(dkrWithOnlyChildSize));
				q27aAgeOfYoutTable.setQ27aDKRUnknownHouseHoldtype(BigInteger.valueOf(dkrUnknownHouseHoldSize));

				String querydnc = " and c.id=e.client_id  and c.dob_data_quality = '99' and c.age <= 24 " ;
				int dncTotal = getSize(getClients(data, query+querydkr, null, true));
				int dncWithoutChildSize = getSize(getClients(data, query+querydnc, projectsHHWithOutChildren, false));
				int dncChildAndAdultsSize = getSize(getClients(data, query+querydnc, projectsHHWithOneAdultChild, false));
				int dncWithOnlyChildSize = getSize(getClients(data, query+querydnc, projectsHHWithChildren, false));
				int dncUnknownHouseHoldSize = getSize(getClients(data, query+querydnc, projectsUnknownHouseHold, false));
				
				q27aAgeOfYoutTable.setQ27aInformationMissingTotal(BigInteger.valueOf(dncTotal));
				q27aAgeOfYoutTable.setQ27aInformationMissingWithoutChild(BigInteger.valueOf(dncWithoutChildSize));
				q27aAgeOfYoutTable.setQ27aInformationMissingWithChildAndAdults(BigInteger.valueOf(dncChildAndAdultsSize));
				q27aAgeOfYoutTable.setQ27aInformationMissingWithChildOnly(BigInteger.valueOf(dncWithOnlyChildSize));
				q27aAgeOfYoutTable.setQ27aInformationMissingUnknownHouseHoldtype(BigInteger.valueOf(dncUnknownHouseHoldSize));

				int total = a12To17Total + a18To24Total + dkrTotal + dncTotal;
				int withoutChild =a12To17WithoutChildSize + a18To24WithoutChildSize + dkrWithoutChildSize + dncWithoutChildSize ;
				int withChildAndAdults =a12To17ChildAndAdultsSize + a18To24ChildAndAdultsSize  + dkrChildAndAdultsSize + dncChildAndAdultsSize;
				int withOnlyChild =a12To17WithOnlyChildSize + a18To24WithOnlyChildSize + dkrWithOnlyChildSize+dncWithOnlyChildSize;
				int unknownHouseHold = a12To17UnknownHouseHoldSize + a18To24UnknownHouseHoldSize + dkrUnknownHouseHoldSize + dncUnknownHouseHoldSize;
				
				q27aAgeOfYoutTable.setQ27aTotTotal(BigInteger.valueOf(total));
				q27aAgeOfYoutTable.setQ27aTotWithoutChild(BigInteger.valueOf(withoutChild));
				q27aAgeOfYoutTable.setQ27aTotWithChildAndAdults(BigInteger.valueOf(withChildAndAdults));
				q27aAgeOfYoutTable.setQ27aTotWithChildOnly(BigInteger.valueOf(withOnlyChild));
				q27aAgeOfYoutTable.setQ27aTotUnknownHouseHoldtype(BigInteger.valueOf(unknownHouseHold));
			}
		}catch(Exception e) {
			logger.error("Error in Q26hBeanMaker:" + e);
		}
		return Arrays.asList(q27aAgeOfYoutTable);
	}
	 
}
