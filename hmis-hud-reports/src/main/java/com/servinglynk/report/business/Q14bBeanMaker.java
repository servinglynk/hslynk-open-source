package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import com.servinglynk.report.bean.Q14bPersonsFleeingDomesticViolenceDataBean;

public class Q14bBeanMaker {
	
	public static List<Q14bPersonsFleeingDomesticViolenceDataBean> getQ14bPersonsFleeingDomesticViolenceList(){
		
		Q14bPersonsFleeingDomesticViolenceDataBean q14bPersonsFleeingDomesticViolenceTableBean = new Q14bPersonsFleeingDomesticViolenceDataBean();
		
		q14bPersonsFleeingDomesticViolenceTableBean.setQ14bYesTotal(BigInteger.valueOf(0));
		q14bPersonsFleeingDomesticViolenceTableBean.setQ14bYesWithoutChildren(BigInteger.valueOf(0));
		q14bPersonsFleeingDomesticViolenceTableBean.setQ14bYesWithChildAndAdults(BigInteger.valueOf(0));
		q14bPersonsFleeingDomesticViolenceTableBean.setQ14bYesWithOnlyChildren(BigInteger.valueOf(0));
		q14bPersonsFleeingDomesticViolenceTableBean.setQ14bYesUnknownHouseholdType(BigInteger.valueOf(0));
		
		q14bPersonsFleeingDomesticViolenceTableBean.setQ14bNoTotal(BigInteger.valueOf(0));
		q14bPersonsFleeingDomesticViolenceTableBean.setQ14bNoWithoutChildren(BigInteger.valueOf(0));
		q14bPersonsFleeingDomesticViolenceTableBean.setQ14bNoWithChildAndAdults(BigInteger.valueOf(0));
		q14bPersonsFleeingDomesticViolenceTableBean.setQ14bNoWithOnlyChildren(BigInteger.valueOf(0));
		q14bPersonsFleeingDomesticViolenceTableBean.setQ14bNoUnknownHouseholdType(BigInteger.valueOf(0));
		
		q14bPersonsFleeingDomesticViolenceTableBean.setQ14bDKRTotal(BigInteger.valueOf(0));
		q14bPersonsFleeingDomesticViolenceTableBean.setQ14bDKRWithoutChildren(BigInteger.valueOf(0));
		q14bPersonsFleeingDomesticViolenceTableBean.setQ14bDKRWithChildAndAdults(BigInteger.valueOf(0));
		q14bPersonsFleeingDomesticViolenceTableBean.setQ14bDKRWithOnlyChildren(BigInteger.valueOf(0));
		q14bPersonsFleeingDomesticViolenceTableBean.setQ14bDKRUnknownHouseholdType(BigInteger.valueOf(0));
	
		q14bPersonsFleeingDomesticViolenceTableBean.setQ14bInformationMissingTotal(BigInteger.valueOf(0));
		q14bPersonsFleeingDomesticViolenceTableBean.setQ14bInformationMissingWithoutChildren(BigInteger.valueOf(0));
		q14bPersonsFleeingDomesticViolenceTableBean.setQ14bInformationMissingWithChildAndAdults(BigInteger.valueOf(0));
		q14bPersonsFleeingDomesticViolenceTableBean.setQ14bInformationMissingWithOnlyChildren(BigInteger.valueOf(0));
		q14bPersonsFleeingDomesticViolenceTableBean.setQ14bInformationMissingUnknownHouseholdType(BigInteger.valueOf(0));
  		
		q14bPersonsFleeingDomesticViolenceTableBean.setQ14bTotalSummed(BigInteger.valueOf(0));
		q14bPersonsFleeingDomesticViolenceTableBean.setQ14bTotalWithoutChildren(BigInteger.valueOf(0));
		q14bPersonsFleeingDomesticViolenceTableBean.setQ14bTotalWithChildAndAdults(BigInteger.valueOf(0));
		q14bPersonsFleeingDomesticViolenceTableBean.setQ14bTotalWithOnlychildren(BigInteger.valueOf(0));
		q14bPersonsFleeingDomesticViolenceTableBean.setQ14bTotalUnknowHousehold(BigInteger.valueOf(0));
		
		return Arrays.asList(q14bPersonsFleeingDomesticViolenceTableBean);
	}

}
