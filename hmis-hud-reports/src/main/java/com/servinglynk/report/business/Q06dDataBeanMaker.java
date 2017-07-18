package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import com.servinglynk.report.bean.Q06dDataBean;

public class Q06dDataBeanMaker {


	public static List<Q06dDataBean> getQ06DataBeanList(){
		
		Q06dDataBean q06dDataBean =new Q06dDataBean();
		
		q06dDataBean.setEsshCountOfTotalRecords(BigInteger.valueOf(0));
		q06dDataBean.setEsshMissingTimeInInstitution(BigInteger.valueOf(0));
		q06dDataBean.setEsshMissingTimeInHousing(BigInteger.valueOf(0));
		q06dDataBean.setEsshApproximateDateStarted(BigInteger.valueOf(0));
		q06dDataBean.setEsshnumberOfTimesDKR(BigInteger.valueOf(0));
		q06dDataBean.setEsshNumberOfMonthsDKR(BigInteger.valueOf(0));
		q06dDataBean.setEsshPercentOfRecords(BigInteger.valueOf(0));
		q06dDataBean.setThCountOfTotalRecords(BigInteger.valueOf(0));
		q06dDataBean.setThMissingTimeInInstitution(BigInteger.valueOf(0));
		q06dDataBean.setThMissingTimeInHousing(BigInteger.valueOf(0));
		q06dDataBean.setThApproximateDateStarted(BigInteger.valueOf(0));
		q06dDataBean.setThnumberOfTimesDKR(BigInteger.valueOf(0));
		q06dDataBean.setThNumberOfMonthsDKR(BigInteger.valueOf(0));
		q06dDataBean.setThPercentOfRecords(BigInteger.valueOf(0));
		q06dDataBean.setPhCountOfTotalRecords(BigInteger.valueOf(0));
		q06dDataBean.setPhMissingTimeInInstitution(BigInteger.valueOf(0));
		q06dDataBean.setPhMissingTimeInHousing(BigInteger.valueOf(0));
		q06dDataBean.setPhApproximateDateStarted(BigInteger.valueOf(0));
		q06dDataBean.setPhnumberOfTimesDKR(BigInteger.valueOf(0));
		q06dDataBean.setPhNumberOfMonthsDKR(BigInteger.valueOf(0));
		q06dDataBean.setPhPercentOfRecords(BigInteger.valueOf(0));
		q06dDataBean.setTotalCountOfTotalRecords(BigInteger.valueOf(0));
		q06dDataBean.setTotalMissingTimeInInstitution(BigInteger.valueOf(0));
		q06dDataBean.setTotalMissingTimeInHousing(BigInteger.valueOf(0));
		q06dDataBean.setTotalApproximateDateStarted(BigInteger.valueOf(0));
		q06dDataBean.setTotalnumberOfTimesDKR(BigInteger.valueOf(0));
		q06dDataBean.setTotalNumberOfMonthsDKR(BigInteger.valueOf(0));
		q06dDataBean.setTotalPercentOfRecords(BigInteger.valueOf(0));	
		
		
		return Arrays.asList(q06dDataBean);
	}

}
