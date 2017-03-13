package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import com.servinglynk.report.bean.Q13a2NumberOfConditionsAtEntryDataBean;

public class Q13a2BeanMaker {
	
	public static List<Q13a2NumberOfConditionsAtEntryDataBean> getQ13a2NumberOfConditionsAtEntryList(){
		
		Q13a2NumberOfConditionsAtEntryDataBean q13a2NumberofConditioinsTableBean = new Q13a2NumberOfConditionsAtEntryDataBean();
		
		q13a2NumberofConditioinsTableBean.setQ13a2NoneTotal(BigInteger.valueOf(0));
    	q13a2NumberofConditioinsTableBean.setQ13a2NoneWithoutChildren(BigInteger.valueOf(0));
    	q13a2NumberofConditioinsTableBean.setQ13a2NoneWithChildAndAdults(BigInteger.valueOf(0));
    	q13a2NumberofConditioinsTableBean.setQ13a2NoneWithOnlychildren(BigInteger.valueOf(0));
    	q13a2NumberofConditioinsTableBean.setQ13a2NoneUnknowHousehold(BigInteger.valueOf(0));
    	
    	q13a2NumberofConditioinsTableBean.setQ13a2Condition1Total(BigInteger.valueOf(0));
    	q13a2NumberofConditioinsTableBean.setQ13a2Condition1WithoutChildren(BigInteger.valueOf(0));
    	q13a2NumberofConditioinsTableBean.setQ13a2Condition1WithChildAndAdults(BigInteger.valueOf(0));
    	q13a2NumberofConditioinsTableBean.setQ13a2Condition1WithOnlychildren(BigInteger.valueOf(0));
    	q13a2NumberofConditioinsTableBean.setQ13a2Condition1UnknowHousehold(BigInteger.valueOf(0));
    	
    	q13a2NumberofConditioinsTableBean.setQ13a2Condition2Total(BigInteger.valueOf(0));
    	q13a2NumberofConditioinsTableBean.setQ13a2Condition2WithoutChildren(BigInteger.valueOf(0));
    	q13a2NumberofConditioinsTableBean.setQ13a2Condition2WithChildAndAdults(BigInteger.valueOf(0));
    	q13a2NumberofConditioinsTableBean.setQ13a2Condition2WithOnlychildren(BigInteger.valueOf(0));
    	q13a2NumberofConditioinsTableBean.setQ13a2Condition2UnknowHousehold(BigInteger.valueOf(0));
    	
    	q13a2NumberofConditioinsTableBean.setQ13a2Condition3PlusTotal(BigInteger.valueOf(0));
    	q13a2NumberofConditioinsTableBean.setQ13a2Condition3PlusWithoutChildren(BigInteger.valueOf(0));
    	q13a2NumberofConditioinsTableBean.setQ13a2Condition3PlusWithChildAndAdults(BigInteger.valueOf(0));
    	q13a2NumberofConditioinsTableBean.setQ13a2Condition3PlusWithOnlychildren(BigInteger.valueOf(0));
    	q13a2NumberofConditioinsTableBean.setQ13a2Condition3PlusUnknowHousehold(BigInteger.valueOf(0));
    	
    	q13a2NumberofConditioinsTableBean.setQ13a2ConditionUnknownTotal(BigInteger.valueOf(0));
    	q13a2NumberofConditioinsTableBean.setQ13a2ConditionUnknownWithoutChildren(BigInteger.valueOf(0));
    	q13a2NumberofConditioinsTableBean.setQ13a2ConditionUnknownWithChildAndAdults(BigInteger.valueOf(0));
    	q13a2NumberofConditioinsTableBean.setQ13a2ConditionUnknownWithOnlychildren(BigInteger.valueOf(0));
    	q13a2NumberofConditioinsTableBean.setQ13a2ConditionUnknownUnknowHousehold(BigInteger.valueOf(0));
    	
    	q13a2NumberofConditioinsTableBean.setQ13a2DontKnowRefusedTotal(BigInteger.valueOf(0));
    	q13a2NumberofConditioinsTableBean.setQ13a2DontKnowRefusedWithoutChildren(BigInteger.valueOf(0));
    	q13a2NumberofConditioinsTableBean.setQ13a2DontKnowRefusedWithChildAndAdults(BigInteger.valueOf(0));
    	q13a2NumberofConditioinsTableBean.setQ13a2DontKnowRefusedWithOnlychildren(BigInteger.valueOf(0));
    	q13a2NumberofConditioinsTableBean.setQ13a2DontKnowRefusedUnknowHousehold(BigInteger.valueOf(0));
    	
    	q13a2NumberofConditioinsTableBean.setQ13a2InformationmissingTotal(BigInteger.valueOf(0));
    	q13a2NumberofConditioinsTableBean.setQ13a2InformationmissingWithoutChildren(BigInteger.valueOf(0));
    	q13a2NumberofConditioinsTableBean.setQ13a2InformationmissingWithChildAndAdults(BigInteger.valueOf(0));
    	q13a2NumberofConditioinsTableBean.setQ13a2InformationmissingWithOnlychildren(BigInteger.valueOf(0));
    	q13a2NumberofConditioinsTableBean.setQ13a2InformationmissingUnknowHousehold(BigInteger.valueOf(0));
    	
    	q13a2NumberofConditioinsTableBean.setQ13a2TotalSummed(BigInteger.valueOf(0));
    	q13a2NumberofConditioinsTableBean.setQ13a2TotalWithoutChildren(BigInteger.valueOf(0));
    	q13a2NumberofConditioinsTableBean.setQ13a2TotalWithChildAndAdults(BigInteger.valueOf(0));
    	q13a2NumberofConditioinsTableBean.setQ13a2TotalWithOnlychildren(BigInteger.valueOf(0));
    	q13a2NumberofConditioinsTableBean.setQ13a2TotalUnknowHousehold(BigInteger.valueOf(0));
    	
    	return Arrays.asList(q13a2NumberofConditioinsTableBean);
    
		
	}

}
