package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import com.servinglynk.report.bean.Q06cPointInTimeCountPersonsLastWednesdayDataBean;

public class Q06cBeanMaker {

	public static List<Q06cPointInTimeCountPersonsLastWednesdayDataBean> getQ06cPointInTimeCountPersonsLastWednesdayList(){
		
		Q06cPointInTimeCountPersonsLastWednesdayDataBean q06cPointInTimeCountPersonsLastWednesdayDataBean =new Q06cPointInTimeCountPersonsLastWednesdayDataBean();
		
		q06cPointInTimeCountPersonsLastWednesdayDataBean.setDestinationStatusErrorCount(BigInteger.valueOf(0));
		q06cPointInTimeCountPersonsLastWednesdayDataBean.setDestinationStatusErrorRate(BigInteger.valueOf(0));
		q06cPointInTimeCountPersonsLastWednesdayDataBean.setIseErrorCount(BigInteger.valueOf(0));
		q06cPointInTimeCountPersonsLastWednesdayDataBean.setIseErrorRate(BigInteger.valueOf(0));
		q06cPointInTimeCountPersonsLastWednesdayDataBean.setIsaaErrorCount(BigInteger.valueOf(0));
		q06cPointInTimeCountPersonsLastWednesdayDataBean.setIsaaErrorRate(BigInteger.valueOf(0));
		q06cPointInTimeCountPersonsLastWednesdayDataBean.setIsaeErrorCount(BigInteger.valueOf(0));
		q06cPointInTimeCountPersonsLastWednesdayDataBean.setIsaeErrorRate(BigInteger.valueOf(0));
		
		
		
		return Arrays.asList(q06cPointInTimeCountPersonsLastWednesdayDataBean);
	}
	
}