package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import com.servinglynk.report.bean.Q09aNumberPersonsContactedDataBean;

public class Q09aDataBeanMaker {
	
	public static List<Q09aNumberPersonsContactedDataBean> getQ09aNumberPersonsContactedList(){
		
		Q09aNumberPersonsContactedDataBean q09aNumberPersonsContactedDataBean=new Q09aNumberPersonsContactedDataBean();
		q09aNumberPersonsContactedDataBean.setTotContactedOnce(BigInteger.valueOf(0));
		q09aNumberPersonsContactedDataBean.setCoFirstContactHumanHabitation(BigInteger.valueOf(0));
		q09aNumberPersonsContactedDataBean.setCoFirstContactNRSS(BigInteger.valueOf(0));
		q09aNumberPersonsContactedDataBean.setCoFirstContactPlaceMissing(BigInteger.valueOf(0));
		q09aNumberPersonsContactedDataBean.setCoFirstContactRSS(BigInteger.valueOf(0));
		q09aNumberPersonsContactedDataBean.setTotContacted2to5Times(BigInteger.valueOf(0));
		q09aNumberPersonsContactedDataBean.setC2to5FirstContactedHumanHabitation(BigInteger.valueOf(0));
		q09aNumberPersonsContactedDataBean.setC2to5FirstContactedNRSS(BigInteger.valueOf(0));
		q09aNumberPersonsContactedDataBean.setC2to5FirstContactedPlaceMissing(BigInteger.valueOf(0));
		q09aNumberPersonsContactedDataBean.setC2to5FirstContactedRSS(BigInteger.valueOf(0));
		q09aNumberPersonsContactedDataBean.setTotContacted6to9Times(BigInteger.valueOf(0));
		q09aNumberPersonsContactedDataBean.setC6to9FirstContactedHumanHabitation(BigInteger.valueOf(0));
		q09aNumberPersonsContactedDataBean.setC6to9FirstContactedNRSS(BigInteger.valueOf(0));
		q09aNumberPersonsContactedDataBean.setC6to9FirstContactedPlaceMissing(BigInteger.valueOf(0));
		q09aNumberPersonsContactedDataBean.setC6to9FirstContactedRSS(BigInteger.valueOf(0));
		q09aNumberPersonsContactedDataBean.setTotContacted10orMore(BigInteger.valueOf(0));
		q09aNumberPersonsContactedDataBean.setC10orMoreFirstContactedHumanHabitation(BigInteger.valueOf(0));
		q09aNumberPersonsContactedDataBean.setC10orMoreFirstContactedNRSS(BigInteger.valueOf(0));
		q09aNumberPersonsContactedDataBean.setC10orMoreFirstContactedPlaceMissing(BigInteger.valueOf(0));
		q09aNumberPersonsContactedDataBean.setC10orMoreFirstContactedRSS(BigInteger.valueOf(0));
		q09aNumberPersonsContactedDataBean.setTotPersonsContacted(BigInteger.valueOf(0));
		q09aNumberPersonsContactedDataBean.setTpcFirstContactedHumanHabitation(BigInteger.valueOf(0));
		q09aNumberPersonsContactedDataBean.setTpcFirstContactedNRSS(BigInteger.valueOf(0));
		q09aNumberPersonsContactedDataBean.setTpcFirstContactedPlaceMissing(BigInteger.valueOf(0));
		q09aNumberPersonsContactedDataBean.setTpcFirstContacteRSS(BigInteger.valueOf(0));
		
		return Arrays.asList(q09aNumberPersonsContactedDataBean);
	}

}
