package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import com.servinglynk.report.bean.Q06cPointInTimeCountPersonsLastWednesdayDataBean;

public class Q06cBeanMaker {

	public static List<Q06cPointInTimeCountPersonsLastWednesdayDataBean> getQ06cPointInTimeCountPersonsLastWednesdayList(){
		
		Q06cPointInTimeCountPersonsLastWednesdayDataBean q06cPointInTimeCountPersonsLastWednesdayDataBean =new Q06cPointInTimeCountPersonsLastWednesdayDataBean();
		
		q06cPointInTimeCountPersonsLastWednesdayDataBean.setCountJanWc(BigInteger.valueOf(0));
		q06cPointInTimeCountPersonsLastWednesdayDataBean.setCountJanWca(BigInteger.valueOf(0));
		q06cPointInTimeCountPersonsLastWednesdayDataBean.setCountJanWoc(BigInteger.valueOf(0));
		q06cPointInTimeCountPersonsLastWednesdayDataBean.setCountJanUht(BigInteger.valueOf(0));
		q06cPointInTimeCountPersonsLastWednesdayDataBean.setJanTotal(BigInteger.valueOf(0));
		q06cPointInTimeCountPersonsLastWednesdayDataBean.setCountAprWc(BigInteger.valueOf(0));
		q06cPointInTimeCountPersonsLastWednesdayDataBean.setCountAprWca(BigInteger.valueOf(0));
		q06cPointInTimeCountPersonsLastWednesdayDataBean.setCountAprWoc(BigInteger.valueOf(0));
		q06cPointInTimeCountPersonsLastWednesdayDataBean.setCountAprUht(BigInteger.valueOf(0));
		q06cPointInTimeCountPersonsLastWednesdayDataBean.setAprTotal(BigInteger.valueOf(0));
		q06cPointInTimeCountPersonsLastWednesdayDataBean.setJulyTotal(BigInteger.valueOf(0));
		q06cPointInTimeCountPersonsLastWednesdayDataBean.setCountJulWc(BigInteger.valueOf(0));
		q06cPointInTimeCountPersonsLastWednesdayDataBean.setCountJulWca(BigInteger.valueOf(0));
		q06cPointInTimeCountPersonsLastWednesdayDataBean.setCountJulWoc(BigInteger.valueOf(0));
		q06cPointInTimeCountPersonsLastWednesdayDataBean.setCountJulUht(BigInteger.valueOf(0));
		q06cPointInTimeCountPersonsLastWednesdayDataBean.setOctTotal(BigInteger.valueOf(0));
		q06cPointInTimeCountPersonsLastWednesdayDataBean.setCountOctUht(BigInteger.valueOf(0));
		q06cPointInTimeCountPersonsLastWednesdayDataBean.setCountOctWc(BigInteger.valueOf(0));
		q06cPointInTimeCountPersonsLastWednesdayDataBean.setCountOctWca(BigInteger.valueOf(0));
		q06cPointInTimeCountPersonsLastWednesdayDataBean.setCountOctWoc(BigInteger.valueOf(0));
		
		
		
		return Arrays.asList(q06cPointInTimeCountPersonsLastWednesdayDataBean);
	}
	
}