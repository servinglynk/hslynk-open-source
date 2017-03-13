package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import com.servinglynk.report.bean.Q16CashIncomeRangesDataBean;

public class Q16BeanMaker {
	
	public static List<Q16CashIncomeRangesDataBean> getQ16CashIncomeRangesList(){
		
		Q16CashIncomeRangesDataBean q16CashIncomeRangesTableBean = new Q16CashIncomeRangesDataBean();
		
		q16CashIncomeRangesTableBean.setQ16NoIncomeIncomeAtEntry(BigInteger.valueOf(0));
		q16CashIncomeRangesTableBean.setQ16NoIncomeIncomeAtExitforLeavers(BigInteger.valueOf(0));
		q16CashIncomeRangesTableBean.setQ16NoIncomeIncomeAtLatestFollowupforStayers(BigInteger.valueOf(0));
		
		q16CashIncomeRangesTableBean.setQ161To150IncomeAtEntry(BigInteger.valueOf(0));
		q16CashIncomeRangesTableBean.setQ161To150IncomeAtExitforLeavers(BigInteger.valueOf(0));
		q16CashIncomeRangesTableBean.setQ161To150IncomeAtLatestFollowupforStayers(BigInteger.valueOf(0));
		
		q16CashIncomeRangesTableBean.setQ16151To250IncomeAtEntry(BigInteger.valueOf(0));
		q16CashIncomeRangesTableBean.setQ16151To250IncomeAtExitforLeavers(BigInteger.valueOf(0));
		q16CashIncomeRangesTableBean.setQ16151To250IncomeAtLatestFollowupforStayers(BigInteger.valueOf(0));
		
		q16CashIncomeRangesTableBean.setQ16251To500IncomeAtEntry(BigInteger.valueOf(0));
		q16CashIncomeRangesTableBean.setQ16251To500IncomeAtExitforLeavers(BigInteger.valueOf(0));
		q16CashIncomeRangesTableBean.setQ16251To500IncomeAtLatestFollowupforStayers(BigInteger.valueOf(0));
		
		q16CashIncomeRangesTableBean.setQ16501To1000IncomeAtEntry(BigInteger.valueOf(0));
		q16CashIncomeRangesTableBean.setQ16501To1000IncomeAtExitforLeavers(BigInteger.valueOf(0));
		q16CashIncomeRangesTableBean.setQ16501To1000IncomeAtLatestFollowupforStayers(BigInteger.valueOf(0));
		
		q16CashIncomeRangesTableBean.setQ161001To1500IncomeAtEntry(BigInteger.valueOf(0));
		q16CashIncomeRangesTableBean.setQ161001To1500IncomeAtExitforLeavers(BigInteger.valueOf(0));
		q16CashIncomeRangesTableBean.setQ161001To1500IncomeAtLatestFollowupforStayers(BigInteger.valueOf(0));
		
		q16CashIncomeRangesTableBean.setQ161501To2000IncomeAtEntry(BigInteger.valueOf(0));
		q16CashIncomeRangesTableBean.setQ161501To2000IncomeAtExitforLeavers(BigInteger.valueOf(0));
		q16CashIncomeRangesTableBean.setQ161501To2000IncomeAtLatestFollowupforStayers(BigInteger.valueOf(0));
		
		q16CashIncomeRangesTableBean.setQ162000PlusIncomeAtEntry(BigInteger.valueOf(0));
		q16CashIncomeRangesTableBean.setQ162000PlusIncomeAtExitforLeavers(BigInteger.valueOf(0));
		q16CashIncomeRangesTableBean.setQ162000PlusIncomeAtLatestFollowupforStayers(BigInteger.valueOf(0));
		
		q16CashIncomeRangesTableBean.setQ16ClientDoesntKnowIncomeAtEntry(BigInteger.valueOf(0));
		q16CashIncomeRangesTableBean.setQ16ClientDoesntKnowIncomeAtExitforLeavers(BigInteger.valueOf(0));
		q16CashIncomeRangesTableBean.setQ16ClientDoesntKnowIncomeAtLatestFollowupforStayers(BigInteger.valueOf(0));
		
		q16CashIncomeRangesTableBean.setQ16DataNotCollectedIncomeAtEntry(BigInteger.valueOf(0));
		q16CashIncomeRangesTableBean.setQ16DataNotCollectedIncomeAtExitforLeavers(BigInteger.valueOf(0));
		q16CashIncomeRangesTableBean.setQ16DataNotCollectedIncomeAtLatestFollowupforStayers(BigInteger.valueOf(0));
		
		q16CashIncomeRangesTableBean.setQ16NumberOfAdultStayersNotYetRequiredIncomeAtEntry(BigInteger.valueOf(0));
		q16CashIncomeRangesTableBean.setQ16NumberOfAdultStayersNotYetRequiredIncomeAtExitforLeavers(BigInteger.valueOf(0));
		q16CashIncomeRangesTableBean.setQ16NumberOfAdultStayersNotYetRequiredIncomeAtLatestFollowupforStayers(BigInteger.valueOf(0));
		
		q16CashIncomeRangesTableBean.setQ16NumberOfAdultStayersWithoutRequiredIncomeAtEntry(BigInteger.valueOf(0));
		q16CashIncomeRangesTableBean.setQ16NumberOfAdultStayersWithoutRequiredIncomeAtExitforLeavers(BigInteger.valueOf(0));
		q16CashIncomeRangesTableBean.setQ16NumberOfAdultStayersWithoutRequiredIncomeAtLatestFollowupforStayers(BigInteger.valueOf(0));

		q16CashIncomeRangesTableBean.setQ16TotalAdultsIncomeAtEntry(BigInteger.valueOf(0));
		q16CashIncomeRangesTableBean.setQ16TotalAdultsIncomeAtExitforLeavers(BigInteger.valueOf(0));
		q16CashIncomeRangesTableBean.setQ16TotalAdultsIncomeAtLatestFollowupforStayers(BigInteger.valueOf(0));
		
		return Arrays.asList(q16CashIncomeRangesTableBean);
	}

}
