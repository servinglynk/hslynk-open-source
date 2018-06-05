package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import com.servinglynk.report.bean.Q16CashIncomeRangesDataBean;
import com.servinglynk.report.bean.ReportData;

public class Q16BeanMaker {
	
	public static List<Q16CashIncomeRangesDataBean> getQ16CashIncomeRangesList(ReportData data){
		
		/*List<ClientModel> clients = data.getClients();
		List<EnrollmentModel>  enrollments = data.getEnrollments();
		List<ClientModel> adults = clients.parallelStream().filter(client -> Q05aBeanMaker.isAdult(client.getDob())).collect(Collectors.toList());
		List<ClientModel> children = clients.parallelStream().filter(client -> Q05aBeanMaker.isChild(client.getDob())).collect(Collectors.toList());
		List<ClientModel> ageUnknown = clients.parallelStream().filter(client -> client.getDob() == null).collect(Collectors.toList());
		List<ExitModel> exits = data.getExits();
		List<ClientModel> veterans = clients.parallelStream().filter(client -> StringUtils.equals("1",client.getVeteran_status())).collect(Collectors.toList());
		
		int stayers = clients !=null && exits != null ? clients.size() - exits.size() : 0;*/
		
		Q16CashIncomeRangesDataBean q16Bean = new Q16CashIncomeRangesDataBean();
		
		q16Bean.setQ16NoIncomeIncomeAtEntry(BigInteger.valueOf(0));
		q16Bean.setQ16NoIncomeIncomeAtExitforLeavers(BigInteger.valueOf(0));
		q16Bean.setQ16NoIncomeIncomeAtLatestFollowupforStayers(BigInteger.valueOf(0));
		
		q16Bean.setQ161To150IncomeAtEntry(BigInteger.valueOf(0));
		q16Bean.setQ161To150IncomeAtExitforLeavers(BigInteger.valueOf(0));
		q16Bean.setQ161To150IncomeAtLatestFollowupforStayers(BigInteger.valueOf(0));
		
		q16Bean.setQ16151To250IncomeAtEntry(BigInteger.valueOf(0));
		q16Bean.setQ16151To250IncomeAtExitforLeavers(BigInteger.valueOf(0));
		q16Bean.setQ16151To250IncomeAtLatestFollowupforStayers(BigInteger.valueOf(0));
		
		q16Bean.setQ16251To500IncomeAtEntry(BigInteger.valueOf(0));
		q16Bean.setQ16251To500IncomeAtExitforLeavers(BigInteger.valueOf(0));
		q16Bean.setQ16251To500IncomeAtLatestFollowupforStayers(BigInteger.valueOf(0));
		
		q16Bean.setQ16501To1000IncomeAtEntry(BigInteger.valueOf(0));
		q16Bean.setQ16501To1000IncomeAtExitforLeavers(BigInteger.valueOf(0));
		q16Bean.setQ16501To1000IncomeAtLatestFollowupforStayers(BigInteger.valueOf(0));
		
		q16Bean.setQ161001To1500IncomeAtEntry(BigInteger.valueOf(0));
		q16Bean.setQ161001To1500IncomeAtExitforLeavers(BigInteger.valueOf(0));
		q16Bean.setQ161001To1500IncomeAtLatestFollowupforStayers(BigInteger.valueOf(0));
		
		q16Bean.setQ161501To2000IncomeAtEntry(BigInteger.valueOf(0));
		q16Bean.setQ161501To2000IncomeAtExitforLeavers(BigInteger.valueOf(0));
		q16Bean.setQ161501To2000IncomeAtLatestFollowupforStayers(BigInteger.valueOf(0));
		
		q16Bean.setQ162000PlusIncomeAtEntry(BigInteger.valueOf(0));
		q16Bean.setQ162000PlusIncomeAtExitforLeavers(BigInteger.valueOf(0));
		q16Bean.setQ162000PlusIncomeAtLatestFollowupforStayers(BigInteger.valueOf(0));
		
		q16Bean.setQ16ClientDoesntKnowIncomeAtEntry(BigInteger.valueOf(0));
		q16Bean.setQ16ClientDoesntKnowIncomeAtExitforLeavers(BigInteger.valueOf(0));
		q16Bean.setQ16ClientDoesntKnowIncomeAtLatestFollowupforStayers(BigInteger.valueOf(0));
		
		q16Bean.setQ16DataNotCollectedIncomeAtEntry(BigInteger.valueOf(0));
		q16Bean.setQ16DataNotCollectedIncomeAtExitforLeavers(BigInteger.valueOf(0));
		q16Bean.setQ16DataNotCollectedIncomeAtLatestFollowupforStayers(BigInteger.valueOf(0));
		
		q16Bean.setQ16NumberOfAdultStayersNotYetRequiredIncomeAtEntry(BigInteger.valueOf(0));
		q16Bean.setQ16NumberOfAdultStayersNotYetRequiredIncomeAtExitforLeavers(BigInteger.valueOf(0));
		q16Bean.setQ16NumberOfAdultStayersNotYetRequiredIncomeAtLatestFollowupforStayers(BigInteger.valueOf(0));
		
		q16Bean.setQ16NumberOfAdultStayersWithoutRequiredIncomeAtEntry(BigInteger.valueOf(0));
		q16Bean.setQ16NumberOfAdultStayersWithoutRequiredIncomeAtExitforLeavers(BigInteger.valueOf(0));
		q16Bean.setQ16NumberOfAdultStayersWithoutRequiredIncomeAtLatestFollowupforStayers(BigInteger.valueOf(0));

		q16Bean.setQ16TotalAdultsIncomeAtEntry(data.getNumOfAdults());
		q16Bean.setQ16TotalAdultsIncomeAtExitforLeavers(data.getTotNoOfAdultLeavers());
		q16Bean.setQ16TotalAdultsIncomeAtLatestFollowupforStayers(data.getTotNoOfAdultStayers());
		
		return Arrays.asList(q16Bean);
	}

}
