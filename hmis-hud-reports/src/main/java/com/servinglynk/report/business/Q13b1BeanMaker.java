package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import com.servinglynk.report.bean.Q13b1PhysicalAndMentalHealthConditionsAtExitDataBean;

public class Q13b1BeanMaker {
	
	public static List<Q13b1PhysicalAndMentalHealthConditionsAtExitDataBean> getQ13b1PhysicalAndMentalHealthConditionsAtExitList(){
		
		Q13b1PhysicalAndMentalHealthConditionsAtExitDataBean q13b1PhysicalAndMentalHealthConditionsAtExitTableBean = new Q13b1PhysicalAndMentalHealthConditionsAtExitDataBean();
		
		q13b1PhysicalAndMentalHealthConditionsAtExitTableBean.setQ13b1MentalIllnessTotal(BigInteger.valueOf(0));
    	q13b1PhysicalAndMentalHealthConditionsAtExitTableBean.setQ13b1MentalIllnessWithoutChildren(BigInteger.valueOf(0));
    	q13b1PhysicalAndMentalHealthConditionsAtExitTableBean.setQ13b1MentalIllnessWithChildAndAdults(BigInteger.valueOf(0));
    	q13b1PhysicalAndMentalHealthConditionsAtExitTableBean.setQ13b1MentalIllnessWithChildAndAdults(BigInteger.valueOf(0));
    	q13b1PhysicalAndMentalHealthConditionsAtExitTableBean.setQ13b1MentalIllnessUnknowHousehold(BigInteger.valueOf(0));
    	
    	q13b1PhysicalAndMentalHealthConditionsAtExitTableBean.setQ13b1AlcoholAbuseTotal(BigInteger.valueOf(0));
    	q13b1PhysicalAndMentalHealthConditionsAtExitTableBean.setQ13b1AlcoholAbuseWithoutChildren(BigInteger.valueOf(0));
    	q13b1PhysicalAndMentalHealthConditionsAtExitTableBean.setQ13b1AlcoholAbuseWithChildAndAdults(BigInteger.valueOf(0));
    	q13b1PhysicalAndMentalHealthConditionsAtExitTableBean.setQ13b1AlcoholAbuseWithOnlychildren(BigInteger.valueOf(0));
    	q13b1PhysicalAndMentalHealthConditionsAtExitTableBean.setQ13b1AlcoholAbuseUnknowHousehold(BigInteger.valueOf(0));
    	
    	q13b1PhysicalAndMentalHealthConditionsAtExitTableBean.setQ13b1DrugAbuseTotal(BigInteger.valueOf(0));
    	q13b1PhysicalAndMentalHealthConditionsAtExitTableBean.setQ13b1DrugAbuseWithoutChildren(BigInteger.valueOf(0));
    	q13b1PhysicalAndMentalHealthConditionsAtExitTableBean.setQ13b1DrugAbuseWithChildAndAdults(BigInteger.valueOf(0));
    	q13b1PhysicalAndMentalHealthConditionsAtExitTableBean.setQ13b1DrugAbuseWithOnlychildren(BigInteger.valueOf(0));
    	q13b1PhysicalAndMentalHealthConditionsAtExitTableBean.setQ13b1DrugAbuseUnknowHousehold(BigInteger.valueOf(0));
    	
    	q13b1PhysicalAndMentalHealthConditionsAtExitTableBean.setQ13b1BothAlcoholAndDrugAbuseTotal(BigInteger.valueOf(0));
    	q13b1PhysicalAndMentalHealthConditionsAtExitTableBean.setQ13b1BothAlcoholAndDrugAbuseWithoutChildren(BigInteger.valueOf(0));
    	q13b1PhysicalAndMentalHealthConditionsAtExitTableBean.setQ13b1BothAlcoholAndDrugAbuseWithChildAndAdults(BigInteger.valueOf(0));
    	q13b1PhysicalAndMentalHealthConditionsAtExitTableBean.setQ13b1BothAlcoholAndDrugAbuseWithOnlychildren(BigInteger.valueOf(0));
    	q13b1PhysicalAndMentalHealthConditionsAtExitTableBean.setQ13b1BothAlcoholAndDrugAbuseUnknowHousehold(BigInteger.valueOf(0));
    	
    	q13b1PhysicalAndMentalHealthConditionsAtExitTableBean.setQ13b1ChronicHealthConditionTotal(BigInteger.valueOf(0));
    	q13b1PhysicalAndMentalHealthConditionsAtExitTableBean.setQ13b1ChronicHealthConditionWithoutChildren(BigInteger.valueOf(0));
    	q13b1PhysicalAndMentalHealthConditionsAtExitTableBean.setQ13b1ChronicHealthConditionWithChildAndAdults(BigInteger.valueOf(0));
    	q13b1PhysicalAndMentalHealthConditionsAtExitTableBean.setQ13b1ChronicHealthConditionWithOnlychildren(BigInteger.valueOf(0));
    	q13b1PhysicalAndMentalHealthConditionsAtExitTableBean.setQ13b1ChronicHealthConditionUnknowHousehold(BigInteger.valueOf(0));
    	
    	q13b1PhysicalAndMentalHealthConditionsAtExitTableBean.setQ13b1HIVRelatedDiseasesTotal(BigInteger.valueOf(0));
    	q13b1PhysicalAndMentalHealthConditionsAtExitTableBean.setQ13b1HIVRelatedDiseasesWithoutChildren(BigInteger.valueOf(0));
    	q13b1PhysicalAndMentalHealthConditionsAtExitTableBean.setQ13b1HIVRelatedDiseasesWithChildAndAdults(BigInteger.valueOf(0));
    	q13b1PhysicalAndMentalHealthConditionsAtExitTableBean.setQ13b1HIVRelatedDiseasesWithOnlychildren(BigInteger.valueOf(0));
    	q13b1PhysicalAndMentalHealthConditionsAtExitTableBean.setQ13b1HIVRelatedDiseasesUnknowHousehold(BigInteger.valueOf(0));
    	
    	q13b1PhysicalAndMentalHealthConditionsAtExitTableBean.setQ13b1DevelopmentalDisabilityTotal(BigInteger.valueOf(0));
    	q13b1PhysicalAndMentalHealthConditionsAtExitTableBean.setQ13b1DevelopmentalDisabilityWithoutChildren(BigInteger.valueOf(0));
    	q13b1PhysicalAndMentalHealthConditionsAtExitTableBean.setQ13b1DevelopmentalDisabilityWithChildAndAdults(BigInteger.valueOf(0));
    	q13b1PhysicalAndMentalHealthConditionsAtExitTableBean.setQ13b1DevelopmentalDisabilityWithOnlychildren(BigInteger.valueOf(0));
    	q13b1PhysicalAndMentalHealthConditionsAtExitTableBean.setQ13b1DevelopmentalDisabilityUnknowHousehold(BigInteger.valueOf(0));
    	
    	q13b1PhysicalAndMentalHealthConditionsAtExitTableBean.setQ13b1PhysicalDisabilityTotal(BigInteger.valueOf(0));
    	q13b1PhysicalAndMentalHealthConditionsAtExitTableBean.setQ13b1PhysicalDisabilityWithoutChildren(BigInteger.valueOf(0));
    	q13b1PhysicalAndMentalHealthConditionsAtExitTableBean.setQ13b1PhysicalDisabilityWithChildAndAdults(BigInteger.valueOf(0));
    	q13b1PhysicalAndMentalHealthConditionsAtExitTableBean.setQ13b1PhysicalDisabilityWithOnlychildren(BigInteger.valueOf(0));
    	q13b1PhysicalAndMentalHealthConditionsAtExitTableBean.setQ13b1PhysicalDisabilityUnknowHousehold(BigInteger.valueOf(0));
    
		
		return Arrays.asList(q13b1PhysicalAndMentalHealthConditionsAtExitTableBean);
	}

}
