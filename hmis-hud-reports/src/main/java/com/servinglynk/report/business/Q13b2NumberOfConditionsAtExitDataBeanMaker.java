package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import com.servinglynk.report.bean.Q13b2NumberOfConditionsAtExitDataBean;

public class Q13b2NumberOfConditionsAtExitDataBeanMaker {
	
	public static List<Q13b2NumberOfConditionsAtExitDataBean> getQ13b2NumberOfConditionsAtExitList(){
		
		Q13b2NumberOfConditionsAtExitDataBean q13b2NumberOfConditionsAtExitTableBean = new Q13b2NumberOfConditionsAtExitDataBean();
		
		q13b2NumberOfConditionsAtExitTableBean.setQ13b2NoneTotal(BigInteger.valueOf(0));
    	q13b2NumberOfConditionsAtExitTableBean.setQ13b2NoneWithoutChildren(BigInteger.valueOf(0));
    	q13b2NumberOfConditionsAtExitTableBean.setQ13b2NoneWithChildAndAdults(BigInteger.valueOf(0));
    	q13b2NumberOfConditionsAtExitTableBean.setQ13b2NoneWithOnlychildren(BigInteger.valueOf(0));
    	q13b2NumberOfConditionsAtExitTableBean.setQ13b2NoneUnknowHousehold(BigInteger.valueOf(0));
    	
    	q13b2NumberOfConditionsAtExitTableBean.setQ13b2Condition1Total(BigInteger.valueOf(0));
    	q13b2NumberOfConditionsAtExitTableBean.setQ13b2Condition1WithoutChildren(BigInteger.valueOf(0));
    	q13b2NumberOfConditionsAtExitTableBean.setQ13b2Condition1WithChildAndAdults(BigInteger.valueOf(0));
    	q13b2NumberOfConditionsAtExitTableBean.setQ13b2Condition1WithOnlychildren(BigInteger.valueOf(0));
    	q13b2NumberOfConditionsAtExitTableBean.setQ13b2Condition1UnknowHousehold(BigInteger.valueOf(0));
    	
    	q13b2NumberOfConditionsAtExitTableBean.setQ13b2Condition2Total(BigInteger.valueOf(0));
    	q13b2NumberOfConditionsAtExitTableBean.setQ13b2Condition2WithoutChildren(BigInteger.valueOf(0));
    	q13b2NumberOfConditionsAtExitTableBean.setQ13b2Condition2WithChildAndAdults(BigInteger.valueOf(0));
    	q13b2NumberOfConditionsAtExitTableBean.setQ13b2Condition2WithOnlychildren(BigInteger.valueOf(0));
    	q13b2NumberOfConditionsAtExitTableBean.setQ13b2Condition2UnknowHousehold(BigInteger.valueOf(0));
    	
    	q13b2NumberOfConditionsAtExitTableBean.setQ13b2Condition3PlusTotal(BigInteger.valueOf(0));
    	q13b2NumberOfConditionsAtExitTableBean.setQ13b2Condition3PlusWithoutChildren(BigInteger.valueOf(0));
    	q13b2NumberOfConditionsAtExitTableBean.setQ13b2Condition3PlusWithChildAndAdults(BigInteger.valueOf(0));
    	q13b2NumberOfConditionsAtExitTableBean.setQ13b2Condition3PlusWithOnlychildren(BigInteger.valueOf(0));
    	q13b2NumberOfConditionsAtExitTableBean.setQ13b2Condition3PlusUnknowHousehold(BigInteger.valueOf(0));
    	
    	q13b2NumberOfConditionsAtExitTableBean.setQ13b2ConditionUnknownTotal(BigInteger.valueOf(0));
    	q13b2NumberOfConditionsAtExitTableBean.setQ13b2ConditionUnknownWithoutChildren(BigInteger.valueOf(0));
    	q13b2NumberOfConditionsAtExitTableBean.setQ13b2ConditionUnknownWithChildAndAdults(BigInteger.valueOf(0));
    	q13b2NumberOfConditionsAtExitTableBean.setQ13b2ConditionUnknownWithOnlychildren(BigInteger.valueOf(0));
    	q13b2NumberOfConditionsAtExitTableBean.setQ13b2ConditionUnknownUnknowHousehold(BigInteger.valueOf(0));
    	
    	q13b2NumberOfConditionsAtExitTableBean.setQ13b2DontKnowRefusedTotal(BigInteger.valueOf(0));
    	q13b2NumberOfConditionsAtExitTableBean.setQ13b2DontKnowRefusedWithoutChildren(BigInteger.valueOf(0));
    	q13b2NumberOfConditionsAtExitTableBean.setQ13b2DontKnowRefusedWithChildAndAdults(BigInteger.valueOf(0));
    	q13b2NumberOfConditionsAtExitTableBean.setQ13b2DontKnowRefusedWithOnlychildren(BigInteger.valueOf(0));
    	q13b2NumberOfConditionsAtExitTableBean.setQ13b2DontKnowRefusedUnknowHousehold(BigInteger.valueOf(0));
    	
    	q13b2NumberOfConditionsAtExitTableBean.setQ13b2InformationmissingTotal(BigInteger.valueOf(0));
    	q13b2NumberOfConditionsAtExitTableBean.setQ13b2InformationmissingWithoutChildren(BigInteger.valueOf(0));
    	q13b2NumberOfConditionsAtExitTableBean.setQ13b2InformationmissingWithChildAndAdults(BigInteger.valueOf(0));
    	q13b2NumberOfConditionsAtExitTableBean.setQ13b2InformationmissingWithOnlychildren(BigInteger.valueOf(0));
    	q13b2NumberOfConditionsAtExitTableBean.setQ13b2InformationmissingUnknowHousehold(BigInteger.valueOf(0));
    	
    	q13b2NumberOfConditionsAtExitTableBean.setQ13b2TotalSummed(BigInteger.valueOf(0));
    	q13b2NumberOfConditionsAtExitTableBean.setQ13b2TotalWithoutChildren(BigInteger.valueOf(0));
    	q13b2NumberOfConditionsAtExitTableBean.setQ13b2TotalWithChildAndAdults(BigInteger.valueOf(0));
    	q13b2NumberOfConditionsAtExitTableBean.setQ13b2TotalWithOnlychildren(BigInteger.valueOf(0));
    	q13b2NumberOfConditionsAtExitTableBean.setQ13b2TotalUnknowHousehold(BigInteger.valueOf(0));
    
		
		return Arrays.asList(q13b2NumberOfConditionsAtExitTableBean);
		
		
	}

}
