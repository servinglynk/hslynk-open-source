package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import com.servinglynk.report.bean.Q05aHMISComparableDBDataQualityDataBean;

public class Q05aHMISComparableDBDataQualityDataBeanMaker {
	
	public static List<Q05aHMISComparableDBDataQualityDataBean> getQ05aHMISCDDQDataList(){
	       
		Q05aHMISComparableDBDataQualityDataBean q05aHMISCDDQBean = new Q05aHMISComparableDBDataQualityDataBean();
		
		q05aHMISCDDQBean.setQ05aFirstName(BigInteger.valueOf(0));
		q05aHMISCDDQBean.setQ05aDNCFirstName(BigInteger.valueOf(0));
		q05aHMISCDDQBean.setQ05aLastName(BigInteger.valueOf(0));
		q05aHMISCDDQBean.setQ05aDNCLastName(BigInteger.valueOf(0));
		q05aHMISCDDQBean.setQ05aSSN(BigInteger.valueOf(4));
		q05aHMISCDDQBean.setQ05aDNCSSN(BigInteger.valueOf(0));
		q05aHMISCDDQBean.setQ05aDoB(BigInteger.valueOf(0));
		q05aHMISCDDQBean.setQ05aDNCDoB(BigInteger.valueOf(0));
		q05aHMISCDDQBean.setQ05aRace(BigInteger.valueOf(11));
		q05aHMISCDDQBean.setQ05aDNCRace(BigInteger.valueOf(1));
		q05aHMISCDDQBean.setQ05aEthinicity(BigInteger.valueOf(0));
		q05aHMISCDDQBean.setQ05aDNCEthinicity(BigInteger.valueOf(1));
		q05aHMISCDDQBean.setQ05aGender(BigInteger.valueOf(0));
		q05aHMISCDDQBean.setQ05aDNCGender(BigInteger.valueOf(1));
		q05aHMISCDDQBean.setQ05aVeteranStatus(BigInteger.valueOf(1));
		q05aHMISCDDQBean.setQ05aDNCVeteranStatus(BigInteger.valueOf(0));
		q05aHMISCDDQBean.setQ05aDisablingCond(BigInteger.valueOf(0));
		q05aHMISCDDQBean.setQ05aDNCDisablingCond(BigInteger.valueOf(2));
		q05aHMISCDDQBean.setQ05aResidencePriorEntry(BigInteger.valueOf(1));
		q05aHMISCDDQBean.setQ05aDNCResidencePriorEntry(BigInteger.valueOf(0));
		q05aHMISCDDQBean.setQ05aRelationshipToHH(BigInteger.valueOf(10));
		q05aHMISCDDQBean.setQ05aDNCRelationshipToHH(BigInteger.valueOf(0));
		q05aHMISCDDQBean.setQ05aDestination(BigInteger.valueOf(0));
		q05aHMISCDDQBean.setQ05aDNCDestination(BigInteger.valueOf(3));
		q05aHMISCDDQBean.setQ05aClientLocatorPE(BigInteger.valueOf(0));
		q05aHMISCDDQBean.setQ05aDNCClientLocatorPE(BigInteger.valueOf(16));
		q05aHMISCDDQBean.setQ05aLengthOfTime(BigInteger.valueOf(0));
		q05aHMISCDDQBean.setQ05aDNCLengthOfTime(BigInteger.valueOf(1));
		
         		
        return Arrays.asList(q05aHMISCDDQBean);
    }


}
