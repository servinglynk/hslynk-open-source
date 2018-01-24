package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import com.servinglynk.report.bean.Q10aDataBean;
import com.servinglynk.report.bean.ReportData;

public class Q10aBeanMaker {
	
	public static List<Q10aDataBean> getQ10AGenderOfAdultsList(ReportData data){
		
		Q10aDataBean q10AGenderOfAdults = new Q10aDataBean();
	
		
	q10AGenderOfAdults.setTotMale(BigInteger.valueOf(0));
	q10AGenderOfAdults.setTotFemale(BigInteger.valueOf(0));
	q10AGenderOfAdults.setTotTransgenderMF(BigInteger.valueOf(0));
	q10AGenderOfAdults.setTotOther(BigInteger.valueOf(0));
	q10AGenderOfAdults.setTotDontKnowRefused(BigInteger.valueOf(0));
	q10AGenderOfAdults.setTotInfoMissing(BigInteger.valueOf(0));
	q10AGenderOfAdults.setTotSubtotal(data.getNumOfAdults());
	q10AGenderOfAdults.setMaleWOC(BigInteger.valueOf(0));
	q10AGenderOfAdults.setMaleWCA(BigInteger.valueOf(0));
	q10AGenderOfAdults.setMaleUHHT(BigInteger.valueOf(0));
	q10AGenderOfAdults.setFemaleWOC(BigInteger.valueOf(0));
	q10AGenderOfAdults.setFemaleWCA(BigInteger.valueOf(0));
	q10AGenderOfAdults.setFemaleUHHT(BigInteger.valueOf(0));
	q10AGenderOfAdults.setTransgenderMFWOC(BigInteger.valueOf(0));
	q10AGenderOfAdults.setTransgenderMFWCA(BigInteger.valueOf(0));
	q10AGenderOfAdults.setTransgenderMFUHHT(BigInteger.valueOf(0));
	q10AGenderOfAdults.setOtherWOC(BigInteger.valueOf(0));
	q10AGenderOfAdults.setOtherWCA(BigInteger.valueOf(0));
	q10AGenderOfAdults.setOtherUHHT(BigInteger.valueOf(0));
	q10AGenderOfAdults.setDkrWOC(BigInteger.valueOf(0));
	q10AGenderOfAdults.setDkrWCA(BigInteger.valueOf(0));
	q10AGenderOfAdults.setDkrUHHT(BigInteger.valueOf(0));
	q10AGenderOfAdults.setInfomiisingWOC(BigInteger.valueOf(0));
	q10AGenderOfAdults.setInfomiisingWCA(BigInteger.valueOf(0));
	q10AGenderOfAdults.setInfomiisingUHHT(BigInteger.valueOf(0));
	q10AGenderOfAdults.setSubtotalWOC(BigInteger.valueOf(0));
	q10AGenderOfAdults.setSubtotalWCA(BigInteger.valueOf(0));
	q10AGenderOfAdults.setSubtotalUHHT(BigInteger.valueOf(0));
	q10AGenderOfAdults.setTotTransgenderFM(BigInteger.valueOf(0));
	q10AGenderOfAdults.setTransgenderFMWOC(BigInteger.valueOf(0));
	q10AGenderOfAdults.setTransgenderFMWCA(BigInteger.valueOf(0));
	q10AGenderOfAdults.setTransgenderFMUHHT(BigInteger.valueOf(0));
	
	return Arrays.asList(q10AGenderOfAdults);
}


}
