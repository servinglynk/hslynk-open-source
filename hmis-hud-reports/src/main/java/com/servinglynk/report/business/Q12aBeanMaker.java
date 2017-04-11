package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import com.servinglynk.report.bean.Q12aRaceDataBean;
import com.servinglynk.report.bean.ReportData;

public class Q12aBeanMaker {
	
	public static List<Q12aRaceDataBean> getQ12aRaceList(ReportData data){
		
		Q12aRaceDataBean q12aRaceDataBean = new Q12aRaceDataBean();
		
		q12aRaceDataBean.setQ12aWhiteTotal(BigInteger.valueOf(0));
    	q12aRaceDataBean.setQ12aWhiteWithChildrenAndAdults(BigInteger.valueOf(0));
    	q12aRaceDataBean.setQ12aWhiteWithOnlyChildren(BigInteger.valueOf(0));
    	q12aRaceDataBean.setQ12aWhiteWithoutChildren(BigInteger.valueOf(0));
    	q12aRaceDataBean.setQ12aWhiteWithUnkownhouseholdtype(BigInteger.valueOf(0));
    	
    	q12aRaceDataBean.setQ12aBlckAfrnAmrnTotal(BigInteger.valueOf(0));
    	q12aRaceDataBean.setQ12aBlckAfrnAmrnWithChildrenAndAdults(BigInteger.valueOf(0));
    	q12aRaceDataBean.setQ12aBlckAfrnAmrnWithOnlyChildren(BigInteger.valueOf(0));
    	q12aRaceDataBean.setQ12aBlckAfrnAmrnWithoutChildren(BigInteger.valueOf(0));
    	q12aRaceDataBean.setQ12aBlckAfrnAmrnWithUnkownhouseholdtype(BigInteger.valueOf(0));
    	
    	q12aRaceDataBean.setQ12aAsianTotal(BigInteger.valueOf(0));
    	q12aRaceDataBean.setQ12aAsianUnkownhouseholdtype(BigInteger.valueOf(0));
    	q12aRaceDataBean.setQ12aAsianWithChildrenAndAdults(BigInteger.valueOf(0));
    	q12aRaceDataBean.setQ12aAsianWithOnlyChildren(BigInteger.valueOf(0));
    	q12aRaceDataBean.setQ12aAsianWithoutChildren(BigInteger.valueOf(0));
    	
    	q12aRaceDataBean.setQ12aAmericanIndianTotal(BigInteger.valueOf(0));
    	q12aRaceDataBean.setQ12aAmericanIndianUnkownhouseholdtype(BigInteger.valueOf(0));
    	q12aRaceDataBean.setQ12aAmericanIndianWithChildrenAndAdults(BigInteger.valueOf(0));
    	q12aRaceDataBean.setQ12aAmericanIndianWithOnlyChildren(BigInteger.valueOf(0));
    	q12aRaceDataBean.setQ12aAmericanIndianWithoutChildren(BigInteger.valueOf(0));
    	
    	q12aRaceDataBean.setQ12aNativeHawalianTotal(BigInteger.valueOf(0));
    	q12aRaceDataBean.setQ12aNativeHawalianUnkownhouseholdtype(BigInteger.valueOf(0));
    	q12aRaceDataBean.setQ12aNativeHawalianWithChildrenAndAdults(BigInteger.valueOf(0));
    	q12aRaceDataBean.setQ12aNativeHawalianWithOnlyChildren(BigInteger.valueOf(0));
    	q12aRaceDataBean.setQ12aNativeHawalianWithoutChildren(BigInteger.valueOf(0));
    	
    	q12aRaceDataBean.setQ12aMultipleRacesTotal(BigInteger.valueOf(0));
    	q12aRaceDataBean.setQ12aMultipleRacesUnkownhouseholdtype(BigInteger.valueOf(0));
    	q12aRaceDataBean.setQ12aMultipleRacesWithChildrenAndAdults(BigInteger.valueOf(0));
    	q12aRaceDataBean.setQ12aMultipleRacesWithOnlyChildren(BigInteger.valueOf(0));
    	q12aRaceDataBean.setQ12aMultipleRacesWithoutChildren(BigInteger.valueOf(0));
    	
    	q12aRaceDataBean.setQ12aDontKnowRacesTotal(BigInteger.valueOf(0));
    	q12aRaceDataBean.setQ12aDontKnowRacesUnkownhouseholdtype(BigInteger.valueOf(0));
    	q12aRaceDataBean.setQ12aDontKnowRacesWithChildrenAndAdults(BigInteger.valueOf(0));
    	q12aRaceDataBean.setQ12aDontKnowRacesWithOnlyChildren(BigInteger.valueOf(0));
    	q12aRaceDataBean.setQ12aDontKnowRacesWithoutChildren(BigInteger.valueOf(0));
    	
    	q12aRaceDataBean.setQ12aInformationMissingTotal(BigInteger.valueOf(0));
    	q12aRaceDataBean.setQ12aInformationMissingUnkownhouseholdtype(BigInteger.valueOf(0));
    	q12aRaceDataBean.setQ12aInformationMissingWithChildrenAndAdults(BigInteger.valueOf(0));
    	q12aRaceDataBean.setQ12aInformationMissingWithOnlyChildren(BigInteger.valueOf(0));
    	q12aRaceDataBean.setQ12aInformationMissingWithoutChildren(BigInteger.valueOf(0));
    	
    	q12aRaceDataBean.setQ12aTotalSummed(BigInteger.valueOf(data.getTotNumOfPersonServed()));
    	q12aRaceDataBean.setQ12aTotalUnkownhouseholdtype(BigInteger.valueOf(0));
    	q12aRaceDataBean.setQ12aTotalWithChildrenAndAdults(BigInteger.valueOf(0));
    	q12aRaceDataBean.setQ12aTotalWithOnlyChildren(BigInteger.valueOf(0));
    	q12aRaceDataBean.setQ12aTotalWithoutChildren(BigInteger.valueOf(0));

    	
		return Arrays.asList(q12aRaceDataBean);
		
	}

}
