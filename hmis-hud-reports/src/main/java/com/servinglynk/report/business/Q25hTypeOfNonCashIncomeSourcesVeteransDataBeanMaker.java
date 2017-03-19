package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import com.servinglynk.report.bean.Q25hTypeOfNonCashIncomeSourcesVeteransDataBean;

public class Q25hTypeOfNonCashIncomeSourcesVeteransDataBeanMaker {

	public static List<Q25hTypeOfNonCashIncomeSourcesVeteransDataBean> getQ25hTypeOfNonCashIncomeSourcesVeteransList(){
		
		Q25hTypeOfNonCashIncomeSourcesVeteransDataBean q25hTypeOfNonCashIncomeSourcesVeteransTable = new Q25hTypeOfNonCashIncomeSourcesVeteransDataBean();
		
				q25hTypeOfNonCashIncomeSourcesVeteransTable.setQ25hSupplementalNutritionalAssistanceAtEntry(BigInteger.valueOf(0));
				q25hTypeOfNonCashIncomeSourcesVeteransTable.setQ25hSupplementalNutritionalAssistanceStayers(BigInteger.valueOf(0));
				q25hTypeOfNonCashIncomeSourcesVeteransTable.setQ25hSupplementalNutritionalAssistanceLeavers(BigInteger.valueOf(0));

				q25hTypeOfNonCashIncomeSourcesVeteransTable.setQ25hWICAtEntry(BigInteger.valueOf(0));
				q25hTypeOfNonCashIncomeSourcesVeteransTable.setQ25hWICStayers(BigInteger.valueOf(0));
				q25hTypeOfNonCashIncomeSourcesVeteransTable.setQ25hWICLeavers(BigInteger.valueOf(0));

				q25hTypeOfNonCashIncomeSourcesVeteransTable.setQ25hTANFChildCareServicesAtEntry(BigInteger.valueOf(0));
				q25hTypeOfNonCashIncomeSourcesVeteransTable.setQ25hTANFChildCareServicesStayers(BigInteger.valueOf(0));
				q25hTypeOfNonCashIncomeSourcesVeteransTable.setQ25hTANFChildCareServicesLeavers(BigInteger.valueOf(0));

				q25hTypeOfNonCashIncomeSourcesVeteransTable.setQ25hTANFTransportationServicesAtEntry(BigInteger.valueOf(0));
				q25hTypeOfNonCashIncomeSourcesVeteransTable.setQ25hTANFTransportationServicesStayers(BigInteger.valueOf(0));
				q25hTypeOfNonCashIncomeSourcesVeteransTable.setQ25hTANFTransportationServicesLeavers(BigInteger.valueOf(0));

				q25hTypeOfNonCashIncomeSourcesVeteransTable.setQ25hOtherTANFFundedServicesAtEntry(BigInteger.valueOf(0));
				q25hTypeOfNonCashIncomeSourcesVeteransTable.setQ25hOtherTANFFundedServicesStayers(BigInteger.valueOf(0));
				q25hTypeOfNonCashIncomeSourcesVeteransTable.setQ25hOtherTANFFundedServicesLeavers(BigInteger.valueOf(0));

				q25hTypeOfNonCashIncomeSourcesVeteransTable.setQ25hOtherSourceAtEntry(BigInteger.valueOf(0));
				q25hTypeOfNonCashIncomeSourcesVeteransTable.setQ25hOtherSourceStayers(BigInteger.valueOf(0));
				q25hTypeOfNonCashIncomeSourcesVeteransTable.setQ25hOtherSourceLeavers(BigInteger.valueOf(0));
		
		return Arrays.asList(q25hTypeOfNonCashIncomeSourcesVeteransTable);
		
	}
}
