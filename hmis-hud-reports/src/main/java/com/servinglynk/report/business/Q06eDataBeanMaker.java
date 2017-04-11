package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import com.servinglynk.report.bean.Q06eDataBean;

public class Q06eDataBeanMaker {

	public static List<Q06eDataBean> getQ06eDataBeanList(){
		
		Q06eDataBean q06eDataBean =new Q06eDataBean();
		
		q06eDataBean.setZeroDaysNumberOfProjectEntry(BigInteger.valueOf(0));
		q06eDataBean.setZeroDaysNumberOfProjectExit(BigInteger.valueOf(0));
		q06eDataBean.setOneToThreeDaysNumberOfProjectEntry(BigInteger.valueOf(0));
		q06eDataBean.setOneToThreeDaysNumberOfProjectExit(BigInteger.valueOf(0));
		q06eDataBean.setFourToSixDaysNumberOfProjectEntry(BigInteger.valueOf(0));
		q06eDataBean.setFourToSixDaysNumberOfProjectExit(BigInteger.valueOf(0));
		q06eDataBean.setSevenToTenDaysNumberOfProjectEntry(BigInteger.valueOf(0));
		q06eDataBean.setSevenToTenDaysNumberOfProjectExit(BigInteger.valueOf(0));
		q06eDataBean.setElevenPlusDaysNumberOfProjectEntry(BigInteger.valueOf(0));
		q06eDataBean.setElevenPlusDaysNumberOfProjectExit(BigInteger.valueOf(0));

		
		return Arrays.asList(q06eDataBean);
	}
	



	
}
