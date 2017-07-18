package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import com.servinglynk.report.bean.Q20bNumberOfNonCashBenefitSourcesDataBean;
import com.servinglynk.report.bean.ReportData;

public class Q20bNumberOfNonCashBenefitSourcesDataBeanMaker {
	
	public static List<Q20bNumberOfNonCashBenefitSourcesDataBean> getQ20bNumberOfNonCashBenefitSourcesList(ReportData data){
		
		Q20bNumberOfNonCashBenefitSourcesDataBean q20bNumberOfNonCashBenefitSourcesTable = new Q20bNumberOfNonCashBenefitSourcesDataBean();
		
				q20bNumberOfNonCashBenefitSourcesTable.setQ20bNosourcesAtEntry(BigInteger.valueOf(0));
				q20bNumberOfNonCashBenefitSourcesTable.setQ20bNosourcesAtLatestStayers(BigInteger.valueOf(0));
				q20bNumberOfNonCashBenefitSourcesTable.setQ20bNosourcesAtExitLeavers(BigInteger.valueOf(0));
						
				q20bNumberOfNonCashBenefitSourcesTable.setQ20b1PlusSourcesAtEntry(BigInteger.valueOf(0));
				q20bNumberOfNonCashBenefitSourcesTable.setQ20b1PlusSourcesAtLatestStayers(BigInteger.valueOf(0));
				q20bNumberOfNonCashBenefitSourcesTable.setQ20b1PlusSourcesAtExitLeavers(BigInteger.valueOf(0));

				q20bNumberOfNonCashBenefitSourcesTable.setQ20bDKRAtEntry(BigInteger.valueOf(0));
				q20bNumberOfNonCashBenefitSourcesTable.setQ20bDKRAtLatestStayers(BigInteger.valueOf(0));
				q20bNumberOfNonCashBenefitSourcesTable.setQ20bDKRAtExitLeavers(BigInteger.valueOf(0));

				q20bNumberOfNonCashBenefitSourcesTable.setQ20bMissingInfoAtEntry(BigInteger.valueOf(0));
				q20bNumberOfNonCashBenefitSourcesTable.setQ20bMissingInfoAtLatestStayers(BigInteger.valueOf(0));
				q20bNumberOfNonCashBenefitSourcesTable.setQ20bMissingInfoAtExitLeavers(BigInteger.valueOf(0));

				q20bNumberOfNonCashBenefitSourcesTable.setQ20bTotalClientsAtEntry(data.getNumOfAdults());
				q20bNumberOfNonCashBenefitSourcesTable.setQ20bTotalClientsAtLatestStayers(data.getTotNoOfAdultStayers());
				q20bNumberOfNonCashBenefitSourcesTable.setQ20bTotalClientsAtExitLeavers(data.getTotNoOfAdultLeavers());
						
		
		return Arrays.asList(q20bNumberOfNonCashBenefitSourcesTable);
	}

}
