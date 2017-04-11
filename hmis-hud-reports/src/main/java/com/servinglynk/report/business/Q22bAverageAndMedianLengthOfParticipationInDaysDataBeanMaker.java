package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import com.servinglynk.report.bean.Q22bAverageAndMedianLengthOfParticipationInDaysDataBean;

public class Q22bAverageAndMedianLengthOfParticipationInDaysDataBeanMaker {
	
	public static List<Q22bAverageAndMedianLengthOfParticipationInDaysDataBean> getQ22bAverageAndMedianLengthOfParticipationInDaysList(){
		
		Q22bAverageAndMedianLengthOfParticipationInDaysDataBean q22bAverageAndMedianLengthOfParticipationInDaysTable =new Q22bAverageAndMedianLengthOfParticipationInDaysDataBean();
		
		q22bAverageAndMedianLengthOfParticipationInDaysTable.setQ22bAverageLengthInDaysLeavers(BigInteger.valueOf(0));
		q22bAverageAndMedianLengthOfParticipationInDaysTable.setQ22bAverageLengthInDaysStayers(BigInteger.valueOf(0));
		
		q22bAverageAndMedianLengthOfParticipationInDaysTable.setQ22bMedianLengthInDaysStayers(BigInteger.valueOf(0));
		q22bAverageAndMedianLengthOfParticipationInDaysTable.setQ22bMedianLengthInDaysLeavers(BigInteger.valueOf(0));
		
		return Arrays.asList(q22bAverageAndMedianLengthOfParticipationInDaysTable);
		
	}

}
