package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import com.servinglynk.report.bean.Q20aTypeOfNonCashBenefitSourcesDataBean;

public class Q20aTypeOfNonCashBenefitSourcesDataBeanMaker {

	public static List<Q20aTypeOfNonCashBenefitSourcesDataBean> getQ20aTypeOfNonCashBenefitSourcesList(){
		
		Q20aTypeOfNonCashBenefitSourcesDataBean q20aTypeOfNonCashBenefitSourcesTable = new Q20aTypeOfNonCashBenefitSourcesDataBean();
		
				q20aTypeOfNonCashBenefitSourcesTable.setQ20aSupplementalNutritionalAssistanceAtEntry(BigInteger.valueOf(0));
				q20aTypeOfNonCashBenefitSourcesTable.setQ20aSupplementalNutritionalAssistanceAtLatestStayers(BigInteger.valueOf(0));
				q20aTypeOfNonCashBenefitSourcesTable.setQ20aSupplementalNutritionalAssistanceAtExitLeavers(BigInteger.valueOf(0));

				q20aTypeOfNonCashBenefitSourcesTable.setQ20aWICAtEntry(BigInteger.valueOf(0));
				q20aTypeOfNonCashBenefitSourcesTable.setQ20aWICAtLatestStayers(BigInteger.valueOf(0));
				q20aTypeOfNonCashBenefitSourcesTable.setQ20aWICAtExitLeavers(BigInteger.valueOf(0));

				q20aTypeOfNonCashBenefitSourcesTable.setQ20aTANFChildCareAtEntry(BigInteger.valueOf(0));
				q20aTypeOfNonCashBenefitSourcesTable.setQ20aTANFChildCareAtLatestStayers(BigInteger.valueOf(0));
				q20aTypeOfNonCashBenefitSourcesTable.setQ20aTANFChildCareAtExitLeavers(BigInteger.valueOf(0));

				q20aTypeOfNonCashBenefitSourcesTable.setQ20aTANFTransportationAtEntry(BigInteger.valueOf(0));
				q20aTypeOfNonCashBenefitSourcesTable.setQ20aTANFTransportationAtLatestStayers(BigInteger.valueOf(0));
				q20aTypeOfNonCashBenefitSourcesTable.setQ20aTANFTransportationAtExitLeavers(BigInteger.valueOf(0));

				q20aTypeOfNonCashBenefitSourcesTable.setQ20aOtherTANFAtEntry(BigInteger.valueOf(0));
				q20aTypeOfNonCashBenefitSourcesTable.setQ20aOtherTANFAtLatestStayers(BigInteger.valueOf(0));
				q20aTypeOfNonCashBenefitSourcesTable.setQ20aOtherTANFAtExitLeavers(BigInteger.valueOf(0));

				q20aTypeOfNonCashBenefitSourcesTable.setQ20aOtherSourcesAtEntry(BigInteger.valueOf(0));
				q20aTypeOfNonCashBenefitSourcesTable.setQ20aOtherSourcesAtLatestStayers(BigInteger.valueOf(0));
				q20aTypeOfNonCashBenefitSourcesTable.setQ20aOtherSourcesAtExitLeavers(BigInteger.valueOf(0));
		
		return Arrays.asList(q20aTypeOfNonCashBenefitSourcesTable);
	}
}
