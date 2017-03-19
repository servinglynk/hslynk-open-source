package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import com.servinglynk.report.bean.Q12bEthnicityDataBean;

public class Q12bBeanMaker {
	
	public static List<Q12bEthnicityDataBean> getQ12bEthnicityList(){
		
		Q12bEthnicityDataBean q12bEthnicityDataBean = new Q12bEthnicityDataBean();
		
		q12bEthnicityDataBean.setQ12bNonHispanicTotal(BigInteger.valueOf(0));
		q12bEthnicityDataBean.setQ12bNonHispanicWithoutChildren(BigInteger.valueOf(0));
		q12bEthnicityDataBean.setQ12bNonHispanicWithChildrenAndAdults(BigInteger.valueOf(0));
		q12bEthnicityDataBean.setQ12bNonHispanicWithOnlyChildren(BigInteger.valueOf(0));
		q12bEthnicityDataBean.setQ12bNonHispanicUnknownhouseholdtype(BigInteger.valueOf(0));

		q12bEthnicityDataBean.setQ12bHispanicTotal(BigInteger.valueOf(0));
		q12bEthnicityDataBean.setQ12bHispanicWithoutChildren(BigInteger.valueOf(0));
		q12bEthnicityDataBean.setQ12bHispanicWithChildrenAndAdults(BigInteger.valueOf(0));
		q12bEthnicityDataBean.setQ12bHispanicWithOnlyChildren(BigInteger.valueOf(0));
		q12bEthnicityDataBean.setQ12bHispanicUnknownhouseholdtype(BigInteger.valueOf(0));

		q12bEthnicityDataBean.setQ12bDontKnowRacesTotal(BigInteger.valueOf(0));
		q12bEthnicityDataBean.setQ12bDontKnowRacesWithoutChildren(BigInteger.valueOf(0));
		q12bEthnicityDataBean.setQ12bDontKnowRacesWithChildrenAndAdults(BigInteger.valueOf(0));
		q12bEthnicityDataBean.setQ12bDontKnowRacesWithOnlyChildren(BigInteger.valueOf(0));
		q12bEthnicityDataBean.setQ12bDontKnowRacesUnkownhouseholdtype(BigInteger.valueOf(0));

		q12bEthnicityDataBean.setQ12bInformationMissingTotal(BigInteger.valueOf(0));
		q12bEthnicityDataBean.setQ12bInformationMissingWithoutChildren(BigInteger.valueOf(0));
		q12bEthnicityDataBean.setQ12bInformationMissingWithChildrenAndAdults(BigInteger.valueOf(0));
		q12bEthnicityDataBean.setQ12bInformationMissingWithOnlyChildren(BigInteger.valueOf(0));
		q12bEthnicityDataBean.setQ12bInformationMissingUnkownhouseholdtype(BigInteger.valueOf(0));

		q12bEthnicityDataBean.setQ12bTotalSummed(BigInteger.valueOf(0));
		q12bEthnicityDataBean.setQ12bTotalWithoutChildren(BigInteger.valueOf(0));
		q12bEthnicityDataBean.setQ12bTotalWithChildrenAndAdults(BigInteger.valueOf(0));
		q12bEthnicityDataBean.setQ12bTotalWithOnlyChildren(BigInteger.valueOf(0));
		q12bEthnicityDataBean.setQ12bTotalUnkownhouseholdtype(BigInteger.valueOf(0));
		
		return Arrays.asList(q12bEthnicityDataBean);
		
	}

}
