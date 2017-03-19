package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import com.servinglynk.report.bean.Q14aDomesticViolenceHistoryDataBean;

public class Q14aBeanMaker {
	
	public static List<Q14aDomesticViolenceHistoryDataBean> getQ14aDomesticViolenceHistoryList() {
		
		
		
		Q14aDomesticViolenceHistoryDataBean q14aDomesticViolenceHistoryTableBean= new Q14aDomesticViolenceHistoryDataBean();
		
		q14aDomesticViolenceHistoryTableBean.setQ14aYesTotal(BigInteger.valueOf(0));
		q14aDomesticViolenceHistoryTableBean.setQ14aYesWithoutChildren(BigInteger.valueOf(0));
		q14aDomesticViolenceHistoryTableBean.setQ14aYesWithChildAndAdults(BigInteger.valueOf(0));
		q14aDomesticViolenceHistoryTableBean.setQ14aYesWithOnlyChildren(BigInteger.valueOf(0));
		q14aDomesticViolenceHistoryTableBean.setQ14aYesUnknownHouseholdType(BigInteger.valueOf(0));
		
		q14aDomesticViolenceHistoryTableBean.setQ14aNoTotal(BigInteger.valueOf(0));
		q14aDomesticViolenceHistoryTableBean.setQ14aNoWithoutChildren(BigInteger.valueOf(0));
		q14aDomesticViolenceHistoryTableBean.setQ14aNoWithChildAndAdults(BigInteger.valueOf(0));
		q14aDomesticViolenceHistoryTableBean.setQ14aNoWithOnlyChildren(BigInteger.valueOf(0));
		q14aDomesticViolenceHistoryTableBean.setQ14aNoUnknownHouseholdType(BigInteger.valueOf(0));
		
		q14aDomesticViolenceHistoryTableBean.setQ14aDKRTotal(BigInteger.valueOf(0));
		q14aDomesticViolenceHistoryTableBean.setQ14aDKRWithoutChildren(BigInteger.valueOf(0));
		q14aDomesticViolenceHistoryTableBean.setQ14aDKRWithChildAndAdults(BigInteger.valueOf(0));
		q14aDomesticViolenceHistoryTableBean.setQ14aDKRWithOnlyChildren(BigInteger.valueOf(0));
		q14aDomesticViolenceHistoryTableBean.setQ14aDKRUnknownHouseholdType(BigInteger.valueOf(0));
		
		q14aDomesticViolenceHistoryTableBean.setQ14aInformationMissingTotal(BigInteger.valueOf(0));
		q14aDomesticViolenceHistoryTableBean.setQ14aInformationMissingWithoutChildren(BigInteger.valueOf(0));
		q14aDomesticViolenceHistoryTableBean.setQ14aInformationMissingWithChildAndAdults(BigInteger.valueOf(0));
		q14aDomesticViolenceHistoryTableBean.setQ14aInformationMissingWithOnlyChildren(BigInteger.valueOf(0));
		q14aDomesticViolenceHistoryTableBean.setQ14aInformationMissingUnknownHouseholdType(BigInteger.valueOf(0));
  		
		q14aDomesticViolenceHistoryTableBean.setQ14aTotalSummed(BigInteger.valueOf(0));
		q14aDomesticViolenceHistoryTableBean.setQ14aTotalWithoutChildren(BigInteger.valueOf(0));
		q14aDomesticViolenceHistoryTableBean.setQ14aTotalWithChildAndAdults(BigInteger.valueOf(0));
		q14aDomesticViolenceHistoryTableBean.setQ14aTotalWithOnlychildren(BigInteger.valueOf(0));
		q14aDomesticViolenceHistoryTableBean.setQ14aTotalUnknowHousehold(BigInteger.valueOf(0));
		
		return Arrays.asList(q14aDomesticViolenceHistoryTableBean);
		
	}

}
