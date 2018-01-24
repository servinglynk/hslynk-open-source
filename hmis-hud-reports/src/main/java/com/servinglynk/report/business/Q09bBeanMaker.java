package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import com.servinglynk.report.bean.Q09bDataBean;

public class Q09bBeanMaker {
	
	public static List<Q09bDataBean> getQ09bNumberofPersonsEngagedList(){
		
		Q09bDataBean q09BNumberOfPersonsEngaged = new Q09bDataBean();
		
		q09BNumberOfPersonsEngaged.setTotEngagedAfter1Contract(BigInteger.valueOf(0));
		q09BNumberOfPersonsEngaged.setTotEngagedAfter2to5Contract(BigInteger.valueOf(0));
		q09BNumberOfPersonsEngaged.setTotEngagedAfter6to9Contract(BigInteger.valueOf(0));
		q09BNumberOfPersonsEngaged.setTotEngagedAfter10orMoreContract(BigInteger.valueOf(0));
		q09BNumberOfPersonsEngaged.setTotPersonsEngaged(BigInteger.valueOf(0));
		q09BNumberOfPersonsEngaged.setTotRateOfEngagement(BigInteger.valueOf(0));
		q09BNumberOfPersonsEngaged.setEngFirstContactHumanHabitation(BigInteger.valueOf(0));
		q09BNumberOfPersonsEngaged.setEngFirstContactNRSS(BigInteger.valueOf(0));
		q09BNumberOfPersonsEngaged.setEngFirstContactRSS(BigInteger.valueOf(0));
		q09BNumberOfPersonsEngaged.setEngFirstContactPlaceMissing(BigInteger.valueOf(0));
		q09BNumberOfPersonsEngaged.setEng2to5FirstContactHumanHabitation(BigInteger.valueOf(0));
		q09BNumberOfPersonsEngaged.setEng2to5FirstContactNRSS(BigInteger.valueOf(0));
		q09BNumberOfPersonsEngaged.setEng2to5FirstContactRSS(BigInteger.valueOf(0));
		q09BNumberOfPersonsEngaged.setEng2to5FirstContactPlaceMissing(BigInteger.valueOf(0));
		q09BNumberOfPersonsEngaged.setEng6to9FirstContactHumanHabitation(BigInteger.valueOf(0));
		q09BNumberOfPersonsEngaged.setEng6to9FirstContactNRSS(BigInteger.valueOf(0));
		q09BNumberOfPersonsEngaged.setEng6to9FirstContactRSS(BigInteger.valueOf(0));
		q09BNumberOfPersonsEngaged.setEng6to9FirstContactPlaceMissing(BigInteger.valueOf(0));
		q09BNumberOfPersonsEngaged.setEng10FirstContactHumanHabitation(BigInteger.valueOf(0));
		q09BNumberOfPersonsEngaged.setEng10FirstContactNRSS(BigInteger.valueOf(0));
		q09BNumberOfPersonsEngaged.setEng10FirstContactRSS(BigInteger.valueOf(0));
		q09BNumberOfPersonsEngaged.setEng10FirstContactPlaceMissing(BigInteger.valueOf(0));
		q09BNumberOfPersonsEngaged.setTpeFirstContactHumanHabitation(BigInteger.valueOf(0));
		q09BNumberOfPersonsEngaged.setTpeFirstContactNRSS(BigInteger.valueOf(0));
		q09BNumberOfPersonsEngaged.setTpeFirstContactRSS(BigInteger.valueOf(0));
		q09BNumberOfPersonsEngaged.setTpeFirstContactPlaceMissing(BigInteger.valueOf(0));
		q09BNumberOfPersonsEngaged.setRoeFirstContactHumanHabitation(BigInteger.valueOf(0));
		q09BNumberOfPersonsEngaged.setRoeFirstContactNRSS(BigInteger.valueOf(0));
		q09BNumberOfPersonsEngaged.setRoeFirstContactRSS(BigInteger.valueOf(0));
		q09BNumberOfPersonsEngaged.setRoeFirstContactPlaceMissing(BigInteger.valueOf(0));
		
		
		return Arrays.asList(q09BNumberOfPersonsEngaged);
	}

}
