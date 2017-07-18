package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import com.servinglynk.report.bean.Q08bDataBean;

public class Q08bDataBeanMaker {
	
	public static List<Q08bDataBean> getQ08bDataBeanList(){
		
		Q08bDataBean q08bDataBean	= new Q08bDataBean();
		
		q08bDataBean.setHhJanTotal(BigInteger.valueOf(0));
		q08bDataBean.setHhCountJanUht(BigInteger.valueOf(0));
		q08bDataBean.setHhCountJanWc(BigInteger.valueOf(0));
		q08bDataBean.setHhCountJanWca(BigInteger.valueOf(0));
		q08bDataBean.setHhCountJanWoc(BigInteger.valueOf(0));
		q08bDataBean.setHhAprTotal(BigInteger.valueOf(0));
		q08bDataBean.setHhCountAprUht(BigInteger.valueOf(0));
		q08bDataBean.setHhCountAprWc(BigInteger.valueOf(0));
		q08bDataBean.setHhCountAprWca(BigInteger.valueOf(0));
		q08bDataBean.setHhCountAprWoc(BigInteger.valueOf(0));
		q08bDataBean.setHhJulTotal(BigInteger.valueOf(0));
		q08bDataBean.setHhCountJulUht(BigInteger.valueOf(0));
		q08bDataBean.setHhCountJulWc(BigInteger.valueOf(0));
		q08bDataBean.setHhCountJulWca(BigInteger.valueOf(0));
		q08bDataBean.setHhCountJulWoc(BigInteger.valueOf(0));
		q08bDataBean.setHhOctTotal(BigInteger.valueOf(0));
		q08bDataBean.setHhCountOctUht(BigInteger.valueOf(0));
		q08bDataBean.setHhCountOctWc(BigInteger.valueOf(0));
		q08bDataBean.setHhCountOctWca(BigInteger.valueOf(0));
		q08bDataBean.setHhCountOctWoc(BigInteger.valueOf(0));		
		
		return Arrays.asList(q08bDataBean);
	}

}
