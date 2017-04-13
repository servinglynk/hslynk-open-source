package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import com.servinglynk.report.bean.Q10cGenderOfPersonsMissingAgeInformationDataBean;
import com.servinglynk.report.bean.ReportData;

public class Q10cBeanMaker {
	
	public static List<Q10cGenderOfPersonsMissingAgeInformationDataBean> getQ10CGPMIList(ReportData data){
		
		Q10cGenderOfPersonsMissingAgeInformationDataBean q10cGenderofPersonsMissingAgeInformation= new Q10cGenderOfPersonsMissingAgeInformationDataBean();
	
	q10cGenderofPersonsMissingAgeInformation.setTotMAIMale(BigInteger.valueOf(0));
	q10cGenderofPersonsMissingAgeInformation.setTotMAIFemale(BigInteger.valueOf(0));
	q10cGenderofPersonsMissingAgeInformation.setTotMAITransgenderMF(BigInteger.valueOf(0));
	q10cGenderofPersonsMissingAgeInformation.setTotMAIOther(BigInteger.valueOf(0));
	q10cGenderofPersonsMissingAgeInformation.setTotMAIDontKnowRefused(BigInteger.valueOf(0));
	q10cGenderofPersonsMissingAgeInformation.setTotMAIInfoMissing(BigInteger.valueOf(0));
	q10cGenderofPersonsMissingAgeInformation.setTotMAISubtotal(data.getNumOfPersonsWithUnknownAge());
	q10cGenderofPersonsMissingAgeInformation.setMaleMAIWOC(BigInteger.valueOf(0));
	q10cGenderofPersonsMissingAgeInformation.setMaleMAIWCA(BigInteger.valueOf(0));
	q10cGenderofPersonsMissingAgeInformation.setMaleMAIUHHT(BigInteger.valueOf(0));
	q10cGenderofPersonsMissingAgeInformation.setFemaleMAIWOC(BigInteger.valueOf(0));
	q10cGenderofPersonsMissingAgeInformation.setFemaleMAIWCA(BigInteger.valueOf(0));
	q10cGenderofPersonsMissingAgeInformation.setFemaleMAIUHHT(BigInteger.valueOf(0));
	q10cGenderofPersonsMissingAgeInformation.setTransgenderMFMAIWOC(BigInteger.valueOf(0));
	q10cGenderofPersonsMissingAgeInformation.setTransgenderMFMAIWCA(BigInteger.valueOf(0));
	q10cGenderofPersonsMissingAgeInformation.setTransgenderMFMAIUHHT(BigInteger.valueOf(0));
	q10cGenderofPersonsMissingAgeInformation.setOtherMAIWOC(BigInteger.valueOf(0));
	q10cGenderofPersonsMissingAgeInformation.setOtherMAIWCA(BigInteger.valueOf(0));
	q10cGenderofPersonsMissingAgeInformation.setOtherMAIUHHT(BigInteger.valueOf(0));
	q10cGenderofPersonsMissingAgeInformation.setDkrMAIWOC(BigInteger.valueOf(0));
	q10cGenderofPersonsMissingAgeInformation.setDkrMAIWCA(BigInteger.valueOf(0));
	q10cGenderofPersonsMissingAgeInformation.setDkrMAIUHHT(BigInteger.valueOf(0));
	q10cGenderofPersonsMissingAgeInformation.setInfomissingMAIWOC(BigInteger.valueOf(0));
	q10cGenderofPersonsMissingAgeInformation.setInfomissingMAIWCA(BigInteger.valueOf(0));
	q10cGenderofPersonsMissingAgeInformation.setInfomissingMAIUHHT(BigInteger.valueOf(0));
	q10cGenderofPersonsMissingAgeInformation.setSubtotalMAIWOC(BigInteger.valueOf(0));
	q10cGenderofPersonsMissingAgeInformation.setSubtotalMAIWCA(BigInteger.valueOf(0));
	q10cGenderofPersonsMissingAgeInformation.setSubtotalMAIUHHT(BigInteger.valueOf(0));
	q10cGenderofPersonsMissingAgeInformation.setTotMAITransgenderFM(BigInteger.valueOf(0));
	q10cGenderofPersonsMissingAgeInformation.setTransgenderFMMAIWOC(BigInteger.valueOf(0));
	q10cGenderofPersonsMissingAgeInformation.setTransgenderFMMAIWCA(BigInteger.valueOf(0));
	q10cGenderofPersonsMissingAgeInformation.setTransgenderFMMAIUHHT(BigInteger.valueOf(0));
	q10cGenderofPersonsMissingAgeInformation.setTransgenderFMMAIWithOnlyChild(BigInteger.valueOf(0));
	q10cGenderofPersonsMissingAgeInformation.setSubtotalMAIWithOnlyChild(BigInteger.valueOf(0));
	q10cGenderofPersonsMissingAgeInformation.setInfomissingMAIWithOnlyChild(BigInteger.valueOf(0));
	q10cGenderofPersonsMissingAgeInformation.setDkrMAIWithOnlyChild(BigInteger.valueOf(0));
	q10cGenderofPersonsMissingAgeInformation.setTransgenderMFMAIWithOnlyChild(BigInteger.valueOf(0));
	q10cGenderofPersonsMissingAgeInformation.setOtherMAIWithOnlyChild(BigInteger.valueOf(0));
	q10cGenderofPersonsMissingAgeInformation.setMaleMAIWithOnlyChild(BigInteger.valueOf(0));
	q10cGenderofPersonsMissingAgeInformation.setFemaleMAIWithOnlyChild(BigInteger.valueOf(0));
	
	return Arrays.asList(q10cGenderofPersonsMissingAgeInformation);
	
}

}
