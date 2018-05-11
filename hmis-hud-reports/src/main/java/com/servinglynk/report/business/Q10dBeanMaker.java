package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import com.servinglynk.report.bean.Q10dDataBean;
import com.servinglynk.report.bean.ReportData;

public class Q10dBeanMaker {

	public static List<Q10dDataBean> getQ10DGARList(ReportData data){
		
		Q10dDataBean q10dGenderByAgeRanges= new Q10dDataBean();
	
		q10dGenderByAgeRanges.setQ10dTotMale(BigInteger.valueOf(0));
		q10dGenderByAgeRanges.setQ10dU18Male(BigInteger.valueOf(0));
		q10dGenderByAgeRanges.setQ10dAge18to24Male(BigInteger.valueOf(0));
		q10dGenderByAgeRanges.setQ10dAge25to61Male(BigInteger.valueOf(0));
		q10dGenderByAgeRanges.setQ10dAge62OverMale(BigInteger.valueOf(0));
		q10dGenderByAgeRanges.setQ10dCDRMale(BigInteger.valueOf(0));
		q10dGenderByAgeRanges.setQ10dDNCMale(BigInteger.valueOf(0));
		q10dGenderByAgeRanges.setQ10dTotFemale(BigInteger.valueOf(0));
		q10dGenderByAgeRanges.setQ10dAgeU18Female(BigInteger.valueOf(0));
		q10dGenderByAgeRanges.setQ10dAge18TO24Female(BigInteger.valueOf(0));
		q10dGenderByAgeRanges.setQ10dAge25TO61Female(BigInteger.valueOf(0));
		q10dGenderByAgeRanges.setQ10dAge62OverFemale(BigInteger.valueOf(0));
		q10dGenderByAgeRanges.setQ10dCDRFemale(BigInteger.valueOf(0));
		q10dGenderByAgeRanges.setQ10dDNCFemale(BigInteger.valueOf(0));
		q10dGenderByAgeRanges.setQ10dTotMTF(BigInteger.valueOf(0)); 
		q10dGenderByAgeRanges.setQ10dAgeU18MTF(BigInteger.valueOf(0));
		q10dGenderByAgeRanges.setQ10dAge18to24MTF(BigInteger.valueOf(0));
		q10dGenderByAgeRanges.setQ10dAge25to61MTF(BigInteger.valueOf(0));
		q10dGenderByAgeRanges.setQ10dAge62OverMTF(BigInteger.valueOf(0));
		q10dGenderByAgeRanges.setQ10dCDRMTF(BigInteger.valueOf(0));
		q10dGenderByAgeRanges.setQ10dDNCMTF(BigInteger.valueOf(0));
		q10dGenderByAgeRanges.setQ10dTotFTM(BigInteger.valueOf(0));
		q10dGenderByAgeRanges.setQ10dAgeU18FTM(BigInteger.valueOf(0));
		q10dGenderByAgeRanges.setQ10dAge18to24FTM(BigInteger.valueOf(0));
		q10dGenderByAgeRanges.setQ10dAge25to61FTM(BigInteger.valueOf(0));
		q10dGenderByAgeRanges.setQ10dAge62OverFTM(BigInteger.valueOf(0));
		q10dGenderByAgeRanges.setQ10dCDRFTM(BigInteger.valueOf(0));
		q10dGenderByAgeRanges.setQ10dDNCFTM(BigInteger.valueOf(0));
		q10dGenderByAgeRanges.setQ10dTotGNC(BigInteger.valueOf(0));
		q10dGenderByAgeRanges.setQ10dAgeU18GNC(BigInteger.valueOf(0));
		q10dGenderByAgeRanges.setQ10dAge18to24GNC(BigInteger.valueOf(0));
		q10dGenderByAgeRanges.setQ10dAge25to61GNC(BigInteger.valueOf(0));
		q10dGenderByAgeRanges.setQ10dAge62OverGNC(BigInteger.valueOf(0));
		q10dGenderByAgeRanges.setQ10dCDRGNC(BigInteger.valueOf(0));
		q10dGenderByAgeRanges.setQ10dDNCGNC(BigInteger.valueOf(0));
		q10dGenderByAgeRanges.setQ10dTotCDR(BigInteger.valueOf(0));
		q10dGenderByAgeRanges.setQ10dAgeU18CDR(BigInteger.valueOf(0));
		q10dGenderByAgeRanges.setQ10dAge18to24CDR(BigInteger.valueOf(0));
		q10dGenderByAgeRanges.setQ10dAge25to61CDR(BigInteger.valueOf(0));
		q10dGenderByAgeRanges.setQ10dAge62OverCDR(BigInteger.valueOf(0));
		q10dGenderByAgeRanges.setQ10dClientCDR(BigInteger.valueOf(0));
		q10dGenderByAgeRanges.setQ10dDNCCDR(BigInteger.valueOf(0));
		q10dGenderByAgeRanges.setQ10dTotDNC(BigInteger.valueOf(0));
		q10dGenderByAgeRanges.setQ10dAgeU18DNC(BigInteger.valueOf(0));
		q10dGenderByAgeRanges.setQ10dAge18to24DNC(BigInteger.valueOf(0));
		q10dGenderByAgeRanges.setQ10dAge25to61DNC(BigInteger.valueOf(0));
		q10dGenderByAgeRanges.setQ10dAge62OverDNC(BigInteger.valueOf(0));
		q10dGenderByAgeRanges.setQ10dCDRDNC(BigInteger.valueOf(0));
		q10dGenderByAgeRanges.setQ10dDataDNC(BigInteger.valueOf(0));
		q10dGenderByAgeRanges.setQ10dTotSubTotal(BigInteger.valueOf(0));
		q10dGenderByAgeRanges.setQ10dAgeU18SubTotal(BigInteger.valueOf(0));
		q10dGenderByAgeRanges.setQ10dAge18to24SubTotal(BigInteger.valueOf(0));
		q10dGenderByAgeRanges.setQ10dAge25to61SubTotal(BigInteger.valueOf(0));
		q10dGenderByAgeRanges.setQ10dAge62OverSubTotal(BigInteger.valueOf(0));
		q10dGenderByAgeRanges.setQ10dCDRSubTotal(BigInteger.valueOf(0));
		q10dGenderByAgeRanges.setQ10dDNCSubTotal(BigInteger.valueOf(0));
			
			
		
		
		
	return Arrays.asList(q10dGenderByAgeRanges);
	
}


	
	
}
