package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import com.servinglynk.report.bean.Q07bPointInTimeCountHouseholdsLastWednesdayDataBean;

public class Q07bBeanMaker {;
	
	public static List<Q07bPointInTimeCountHouseholdsLastWednesdayDataBean> getQ07bPointInTimeCountHouseholdsLastWednesdayList(){
		
		Q07bPointInTimeCountHouseholdsLastWednesdayDataBean q07bPointInTimeCountHouseholdsLastWednesdayDataBean	= new Q07bPointInTimeCountHouseholdsLastWednesdayDataBean();
		
		q07bPointInTimeCountHouseholdsLastWednesdayDataBean.setHhJanTotal(BigInteger.valueOf(0));
		q07bPointInTimeCountHouseholdsLastWednesdayDataBean.setHhCountJanUht(BigInteger.valueOf(0));
		q07bPointInTimeCountHouseholdsLastWednesdayDataBean.setHhCountJanWc(BigInteger.valueOf(0));
		q07bPointInTimeCountHouseholdsLastWednesdayDataBean.setHhCountJanWca(BigInteger.valueOf(0));
		q07bPointInTimeCountHouseholdsLastWednesdayDataBean.setHhCountJanWoc(BigInteger.valueOf(0));
		q07bPointInTimeCountHouseholdsLastWednesdayDataBean.setHhAprTotal(BigInteger.valueOf(0));
		q07bPointInTimeCountHouseholdsLastWednesdayDataBean.setHhCountAprUht(BigInteger.valueOf(0));
		q07bPointInTimeCountHouseholdsLastWednesdayDataBean.setHhCountAprWc(BigInteger.valueOf(0));
		q07bPointInTimeCountHouseholdsLastWednesdayDataBean.setHhCountAprWca(BigInteger.valueOf(0));
		q07bPointInTimeCountHouseholdsLastWednesdayDataBean.setHhCountAprWoc(BigInteger.valueOf(0));
		q07bPointInTimeCountHouseholdsLastWednesdayDataBean.setHhJulTotal(BigInteger.valueOf(0));
		q07bPointInTimeCountHouseholdsLastWednesdayDataBean.setHhCountJulUht(BigInteger.valueOf(0));
		q07bPointInTimeCountHouseholdsLastWednesdayDataBean.setHhCountJulWc(BigInteger.valueOf(0));
		q07bPointInTimeCountHouseholdsLastWednesdayDataBean.setHhCountJulWca(BigInteger.valueOf(0));
		q07bPointInTimeCountHouseholdsLastWednesdayDataBean.setHhCountJulWoc(BigInteger.valueOf(0));
		q07bPointInTimeCountHouseholdsLastWednesdayDataBean.setHhOctTotal(BigInteger.valueOf(0));
		q07bPointInTimeCountHouseholdsLastWednesdayDataBean.setHhCountOctUht(BigInteger.valueOf(0));
		q07bPointInTimeCountHouseholdsLastWednesdayDataBean.setHhCountOctWc(BigInteger.valueOf(0));
		q07bPointInTimeCountHouseholdsLastWednesdayDataBean.setHhCountOctWca(BigInteger.valueOf(0));
		q07bPointInTimeCountHouseholdsLastWednesdayDataBean.setHhCountOctWoc(BigInteger.valueOf(0));		
		
		return Arrays.asList(q07bPointInTimeCountHouseholdsLastWednesdayDataBean);
	}

}
