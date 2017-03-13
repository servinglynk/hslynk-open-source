package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import com.servinglynk.report.bean.Q13a1PhysicalAndMentalHealthConditionsAtEntryDataBean;

public class Q13a1BeanMaker {
	
	public static List<Q13a1PhysicalAndMentalHealthConditionsAtEntryDataBean> getQ13a1PhysicalAndMentalHealthConditionsAtEntryList(){
		
		Q13a1PhysicalAndMentalHealthConditionsAtEntryDataBean q13a1PhysicalMntlHealthCondTableBean = new Q13a1PhysicalAndMentalHealthConditionsAtEntryDataBean();
		
		q13a1PhysicalMntlHealthCondTableBean.setQ13a1MentalIllnessTotal(BigInteger.valueOf(0));
    	q13a1PhysicalMntlHealthCondTableBean.setQ13a1MentalIllnessWithoutChildren(BigInteger.valueOf(0));
    	q13a1PhysicalMntlHealthCondTableBean.setQ13a1MentalIllnessWithChildAndAdults(BigInteger.valueOf(0));
    	q13a1PhysicalMntlHealthCondTableBean.setQ13a1MentalIllnessWithOnlychildren(BigInteger.valueOf(0));
    	q13a1PhysicalMntlHealthCondTableBean.setQ13a1MentalIllnessUnknowHousehold(BigInteger.valueOf(0));
    	
    	q13a1PhysicalMntlHealthCondTableBean.setQ13a1AlcoholAbuseTotal(BigInteger.valueOf(0));
    	q13a1PhysicalMntlHealthCondTableBean.setQ13a1AlcoholAbuseWithoutChildren(BigInteger.valueOf(0));
    	q13a1PhysicalMntlHealthCondTableBean.setQ13a1AlcoholAbuseWithChildAndAdults(BigInteger.valueOf(0));
    	q13a1PhysicalMntlHealthCondTableBean.setQ13a1AlcoholAbuseWithOnlychildren(BigInteger.valueOf(0));
    	q13a1PhysicalMntlHealthCondTableBean.setQ13a1AlcoholAbuseUnknowHousehold(BigInteger.valueOf(0));
    	
    	q13a1PhysicalMntlHealthCondTableBean.setQ13a1DrugAbuseTotal(BigInteger.valueOf(0));
    	q13a1PhysicalMntlHealthCondTableBean.setQ13a1DrugAbuseWithoutChildren(BigInteger.valueOf(0));
    	q13a1PhysicalMntlHealthCondTableBean.setQ13a1DrugAbuseWithChildAndAdults(BigInteger.valueOf(0));
    	q13a1PhysicalMntlHealthCondTableBean.setQ13a1DrugAbuseWithOnlychildren(BigInteger.valueOf(0));
    	q13a1PhysicalMntlHealthCondTableBean.setQ13a1DrugAbuseUnknowHousehold(BigInteger.valueOf(0));
    	
    	q13a1PhysicalMntlHealthCondTableBean.setQ13a1BothAlcoholAndDrugAbuseTotal(BigInteger.valueOf(0));
    	q13a1PhysicalMntlHealthCondTableBean.setQ13a1BothAlcoholAndDrugAbuseWithoutChildren(BigInteger.valueOf(0));
    	q13a1PhysicalMntlHealthCondTableBean.setQ13a1BothAlcoholAndDrugAbuseWithChildAndAdults(BigInteger.valueOf(0));
    	q13a1PhysicalMntlHealthCondTableBean.setQ13a1BothAlcoholAndDrugAbuseWithOnlychildren(BigInteger.valueOf(0));
    	q13a1PhysicalMntlHealthCondTableBean.setQ13a1BothAlcoholAndDrugAbuseUnknowHousehold(BigInteger.valueOf(0));
    	
    	q13a1PhysicalMntlHealthCondTableBean.setQ13a1ChronicHealthConditionTotal(BigInteger.valueOf(0));
    	q13a1PhysicalMntlHealthCondTableBean.setQ13a1ChronicHealthConditionWithoutChildren(BigInteger.valueOf(0));
    	q13a1PhysicalMntlHealthCondTableBean.setQ13a1ChronicHealthConditionWithChildAndAdults(BigInteger.valueOf(0));
    	q13a1PhysicalMntlHealthCondTableBean.setQ13a1ChronicHealthConditionWithOnlychildren(BigInteger.valueOf(0));
    	q13a1PhysicalMntlHealthCondTableBean.setQ13a1ChronicHealthConditionUnknowHousehold(BigInteger.valueOf(0));
    	
    	q13a1PhysicalMntlHealthCondTableBean.setQ13a1HIVRelatedDiseasesTotal(BigInteger.valueOf(0));
    	q13a1PhysicalMntlHealthCondTableBean.setQ13a1HIVRelatedDiseasesWithoutChildren(BigInteger.valueOf(0));
    	q13a1PhysicalMntlHealthCondTableBean.setQ13a1HIVRelatedDiseasesWithOnlychildren(BigInteger.valueOf(0));
    	q13a1PhysicalMntlHealthCondTableBean.setQ13a1HIVRelatedDiseasesWithChildAndAdults(BigInteger.valueOf(0));
    	q13a1PhysicalMntlHealthCondTableBean.setQ13a1HIVRelatedDiseasesUnknowHousehold(BigInteger.valueOf(0));
    	
    	q13a1PhysicalMntlHealthCondTableBean.setQ13a1DevelopmentalDisabilityTotal(BigInteger.valueOf(0));
    	q13a1PhysicalMntlHealthCondTableBean.setQ13a1DevelopmentalDisabilityWithoutChildren(BigInteger.valueOf(0));
    	q13a1PhysicalMntlHealthCondTableBean.setQ13a1DevelopmentalDisabilityWithChildAndAdults(BigInteger.valueOf(0));
    	q13a1PhysicalMntlHealthCondTableBean.setQ13a1DevelopmentalDisabilityWithOnlychildren(BigInteger.valueOf(0));
    	q13a1PhysicalMntlHealthCondTableBean.setQ13a1DevelopmentalDisabilityUnknowHousehold(BigInteger.valueOf(0));
    	
    	q13a1PhysicalMntlHealthCondTableBean.setQ13a1PhysicalDisabilityTotal(BigInteger.valueOf(0));
    	q13a1PhysicalMntlHealthCondTableBean.setQ13a1PhysicalDisabilityWithoutChildren(BigInteger.valueOf(0));
    	q13a1PhysicalMntlHealthCondTableBean.setQ13a1PhysicalDisabilityWithChildAndAdults(BigInteger.valueOf(0));
    	q13a1PhysicalMntlHealthCondTableBean.setQ13a1PhysicalDisabilityWithOnlychildren(BigInteger.valueOf(0));
    	q13a1PhysicalMntlHealthCondTableBean.setQ13a1PhysicalDisabilityUnknowHousehold(BigInteger.valueOf(0));
		
		
		return Arrays.asList(q13a1PhysicalMntlHealthCondTableBean);
	}

}
