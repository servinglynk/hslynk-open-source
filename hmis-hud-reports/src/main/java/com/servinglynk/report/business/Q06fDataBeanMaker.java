package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import com.servinglynk.report.bean.Q06fDataBean;

public class Q06fDataBeanMaker {


	public static List<Q06fDataBean> getQ06fDataBeanList(){
		
		Q06fDataBean q06fDataBean =new Q06fDataBean();
		
		q06fDataBean.setContactNumberOfRecords(BigInteger.valueOf(0));
		q06fDataBean.setContactNumberOfInactiveRecords(BigInteger.valueOf(0));
		q06fDataBean.setContactPercentOfInactiveRecords(BigInteger.valueOf(0));
		q06fDataBean.setBedNightNumberOfRecords(BigInteger.valueOf(0));
		q06fDataBean.setBedNightNumberOfInactiveRecords(BigInteger.valueOf(0));
		q06fDataBean.setBedNightPercentOfInactiveRecords(BigInteger.valueOf(0));
		
		return Arrays.asList(q06fDataBean);
	}
	



	


}
