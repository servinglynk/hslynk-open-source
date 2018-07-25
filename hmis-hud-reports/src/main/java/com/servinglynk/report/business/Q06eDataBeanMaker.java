package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import com.servinglynk.report.bean.Q06eDataBean;
import com.servinglynk.report.bean.ReportData;
import com.servinglynk.report.model.EnrollmentModel;
import com.servinglynk.report.model.ExitModel;

public class Q06eDataBeanMaker extends BaseBeanMaker {

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
		try {
			List<EnrollmentModel> enrollments = data.getEnrollments();
			List<EnrollmentModel>  filteredEnrollments = enrollments.parallelStream().filter(enrollment ->enrollment.getEntrydate() != null && (enrollment.getEntrydate().compareTo(data.getReportStartDate()) > 0) && enrollment.getEntrydate().compareTo(data.getReportStartDate()) < 0).collect(Collectors.toList());
			filteredEnrollments.parallelStream().forEach(enrollment -> { 
			    long diff = enrollment.getEntrydate().getTime() - enrollment.getDateCreatedFromSource().getTime();
			    long days = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
				if(enrollment.getEntrydate().compareTo(enrollment.getDateCreatedFromSource()) ==0) {
					zeroDaysNumberOfProjectEntry++;
				}else if(days >=1 && days <=3) { 
					oneToThreeDaysNumberOfProjectEntry++;
				}else if(days >=4 && days <=6) {
					fourToSixDaysNumberOfProjectEntry++;
				}else if(days >=7 && days <=10) {
					sevenToTenDaysNumberOfProjectEntry++;
				}else if(days >=11){
					elevenPlusDaysNumberOfProjectEntry++;
				}
			}
			);
			List<ExitModel> exits = data.getExits();
			List<ExitModel>  filteredExits = exits.parallelStream().filter(exit -> exit.getExitdate() != null && (exit.getExitdate().compareTo(data.getReportStartDate()) > 0) && (exit.getExitdate().compareTo(data.getReportStartDate()) < 0)).collect(Collectors.toList());
			
			filteredExits.parallelStream().forEach(exit -> { 
			    long diff = exit.getExitdate().getTime() - exit.getDateCreatedFromSource().getTime();
			    long days = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
				if(exit.getExitdate().compareTo(exit.getDateCreatedFromSource()) ==0) {
					zeroDaysNumberOfProjectExit++;
				}else if(days >=1 && days <=3) { 
					oneToThreeDaysNumberOfProjectExit++;
				}else if(days >=4 && days <=6) {
					fourToSixDaysNumberOfProjectExit++;
				}else if(days >=7 && days <=10) {
					sevenToTenDaysNumberOfProjectExit++;
				}else if(days >=11){
					elevenPlusDaysNumberOfProjectExit++;
				}
			}
			);
			
			q06eDataBean.setZeroDaysNumberOfProjectEntry(BigInteger.valueOf(zeroDaysNumberOfProjectEntry));
			q06eDataBean.setZeroDaysNumberOfProjectExit(BigInteger.valueOf(zeroDaysNumberOfProjectExit));
			q06eDataBean.setOneToThreeDaysNumberOfProjectEntry(BigInteger.valueOf(oneToThreeDaysNumberOfProjectEntry));
			q06eDataBean.setOneToThreeDaysNumberOfProjectExit(BigInteger.valueOf(oneToThreeDaysNumberOfProjectExit));
			q06eDataBean.setFourToSixDaysNumberOfProjectEntry(BigInteger.valueOf(fourToSixDaysNumberOfProjectEntry));
			q06eDataBean.setFourToSixDaysNumberOfProjectExit(BigInteger.valueOf(fourToSixDaysNumberOfProjectExit));
			q06eDataBean.setSevenToTenDaysNumberOfProjectEntry(BigInteger.valueOf(sevenToTenDaysNumberOfProjectEntry));
			q06eDataBean.setSevenToTenDaysNumberOfProjectExit(BigInteger.valueOf(sevenToTenDaysNumberOfProjectExit));
			q06eDataBean.setElevenPlusDaysNumberOfProjectEntry(BigInteger.valueOf(elevenPlusDaysNumberOfProjectEntry));
			q06eDataBean.setElevenPlusDaysNumberOfProjectExit(BigInteger.valueOf(elevenPlusDaysNumberOfProjectExit));

		}catch(Exception e) {
			logger.error("Error in Q06eDataBeanMaker:"+e);
		}
		
		return Arrays.asList(q06eDataBean);
	}
	



	
}
