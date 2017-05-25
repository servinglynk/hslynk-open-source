package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import com.servinglynk.report.bean.Q06eDataBean;
import com.servinglynk.report.bean.ReportData;
import com.servinglynk.report.model.EnrollmentModel;

public class Q06eDataBeanMaker {

	public static Long zeroDaysNumberOfProjectEntry=0L;
	public static Long zeroDaysNumberOfProjectExit=0L;
	public static Long oneToThreeDaysNumberOfProjectEntry=0L;
	public static Long oneToThreeDaysNumberOfProjectExit=0L;
	public static Long fourToSixDaysNumberOfProjectEntry=0L;
	public static Long fourToSixDaysNumberOfProjectExit=0L;
	public static Long sevenToTenDaysNumberOfProjectEntry=0L;
	public static Long sevenToTenDaysNumberOfProjectExit=0L;
	public static Long elevenPlusDaysNumberOfProjectEntry=0L;
	public static Long elevenPlusDaysNumberOfProjectExit=0L;
	
	public static List<Q06eDataBean> getQ06eDataBeanList(ReportData data){
		
		Q06eDataBean q06eDataBean =new Q06eDataBean();
		List<EnrollmentModel> enrollments = data.getEnrollments();
		
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
