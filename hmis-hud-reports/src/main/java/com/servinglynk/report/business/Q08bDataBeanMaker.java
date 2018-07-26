package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.servinglynk.report.bean.Q08bDataBean;
import com.servinglynk.report.bean.ReportData;
import com.servinglynk.report.model.EnrollmentModel;

public class Q08bDataBeanMaker extends BaseBeanMaker {
	
	public static List<Q08bDataBean> getQ08bDataBeanList(ReportData data){
		
		Q08bDataBean q08bDataBean	= new Q08bDataBean();
		if(data.isLiveMode()) {
		try {
		List<String> projectsHHWithChildren = data.getProjectsHHWithChildren();
		List<String> projectsHHWithOneAdultChild = data.getProjectsHHWithOneAdultChild();
		List<String> projectsHHWithOutChildren = data.getProjectsHHWithOutChildren();
		List<String> projectsUnknownHouseHold = data.getProjectsUnknownHouseHold();
		
		List<EnrollmentModel> enrollments = data.getEnrollments();
		List<EnrollmentModel> enrollmentJanTotal = enrollments.parallelStream().filter(enrollment -> Util.getLocalDateFromUtilDate(enrollment.getEntrydate()).compareTo(lasWednesayOf(data.getReportEndDate().getYear(), 1)) == 0).collect(Collectors.toList());
		List<EnrollmentModel> enrollmentAprilTotal = enrollments.parallelStream().filter(enrollment -> Util.getLocalDateFromUtilDate(enrollment.getEntrydate()).compareTo(lasWednesayOf(data.getReportEndDate().getYear(), 1)) == 0).collect(Collectors.toList());
		List<EnrollmentModel> enrollmentJulyTotal = enrollments.parallelStream().filter(enrollment -> Util.getLocalDateFromUtilDate(enrollment.getEntrydate()).compareTo(lasWednesayOf(data.getReportEndDate().getYear(), 1)) == 0).collect(Collectors.toList());
		List<EnrollmentModel> enrollmentOctoberTotal = enrollments.parallelStream().filter(enrollment -> Util.getLocalDateFromUtilDate(enrollment.getEntrydate()).compareTo(lasWednesayOf(data.getReportEndDate().getYear(), 1)) == 0).collect(Collectors.toList());
			
		List<EnrollmentModel> enrollmentJanHHWithOutChildren = enrollmentJanTotal.parallelStream().filter(enrollment->projectsHHWithOutChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
		List<EnrollmentModel> enrollmentJanHHWithChildren = enrollmentJanTotal.parallelStream().filter(enrollment->projectsHHWithChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
		List<EnrollmentModel> enrollmentsJanHHWithOneAdultChild = enrollmentJanTotal.parallelStream().filter(enrollment->projectsHHWithOneAdultChild.contains(enrollment.getProjectID())).collect(Collectors.toList());
		List<EnrollmentModel> enrollmentJanUnknownHouseHold = enrollmentJanTotal.parallelStream().filter(enrollment->projectsUnknownHouseHold.contains(enrollment.getProjectID())).collect(Collectors.toList());
		
		
		List<EnrollmentModel> enrollmentAprilHHWithOutChildren = enrollmentAprilTotal.parallelStream().filter(enrollment->projectsHHWithOutChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
		List<EnrollmentModel> enrollmentAprilHHWithChildren = enrollmentAprilTotal.parallelStream().filter(enrollment->projectsHHWithChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
		List<EnrollmentModel> enrollmentsAprilHHWithOneAdultChild = enrollmentAprilTotal.parallelStream().filter(enrollment->projectsHHWithOneAdultChild.contains(enrollment.getProjectID())).collect(Collectors.toList());
		List<EnrollmentModel> enrollmentAprilUnknownHouseHold = enrollmentAprilTotal.parallelStream().filter(enrollment->projectsUnknownHouseHold.contains(enrollment.getProjectID())).collect(Collectors.toList());
		
		
		List<EnrollmentModel> enrollmentJulyHHWithOutChildren = enrollmentJulyTotal.parallelStream().filter(enrollment->projectsHHWithOutChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
		List<EnrollmentModel> enrollmentJulyHHWithChildren = enrollmentJulyTotal.parallelStream().filter(enrollment->projectsHHWithChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
		List<EnrollmentModel> enrollmentsJulyHHWithOneAdultChild = enrollmentJulyTotal.parallelStream().filter(enrollment->projectsHHWithOneAdultChild.contains(enrollment.getProjectID())).collect(Collectors.toList());
		List<EnrollmentModel> enrollmentJulyUnknownHouseHold = enrollmentJulyTotal.parallelStream().filter(enrollment->projectsUnknownHouseHold.contains(enrollment.getProjectID())).collect(Collectors.toList());
		
		List<EnrollmentModel> enrollmentOctoberHHWithOutChildren = enrollmentOctoberTotal.parallelStream().filter(enrollment->projectsHHWithOutChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
		List<EnrollmentModel> enrollmentOctoberHHWithChildren = enrollmentOctoberTotal.parallelStream().filter(enrollment->projectsHHWithChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
		List<EnrollmentModel> enrollmentsOctoberHHWithOneAdultChild = enrollmentOctoberTotal.parallelStream().filter(enrollment->projectsHHWithOneAdultChild.contains(enrollment.getProjectID())).collect(Collectors.toList());
		List<EnrollmentModel> enrollmentOctoberUnknownHouseHold = enrollmentOctoberTotal.parallelStream().filter(enrollment->projectsUnknownHouseHold.contains(enrollment.getProjectID())).collect(Collectors.toList());
		
		
		q08bDataBean.setHhJanTotal(BigInteger.valueOf(enrollmentJanTotal !=null ? enrollmentJanTotal.size() : getDefaultIntValue()));
		q08bDataBean.setHhCountJanUht(BigInteger.valueOf(enrollmentJanUnknownHouseHold != null ? enrollmentJanUnknownHouseHold.size() : getDefaultIntValue()));
		q08bDataBean.setHhCountJanWc(BigInteger.valueOf(enrollmentJanHHWithChildren != null ? enrollmentJanHHWithChildren.size() : getDefaultIntValue()));
		q08bDataBean.setHhCountJanWca(BigInteger.valueOf(enrollmentsJanHHWithOneAdultChild != null ? enrollmentsJanHHWithOneAdultChild.size() : getDefaultIntValue() ));
		q08bDataBean.setHhCountJanWoc(BigInteger.valueOf(enrollmentJanHHWithOutChildren != null ? enrollmentJanHHWithOutChildren.size() : getDefaultIntValue()));
		
		q08bDataBean.setHhAprTotal(BigInteger.valueOf(enrollmentAprilTotal != null ? enrollmentAprilTotal.size() : getDefaultIntValue()));
		q08bDataBean.setHhCountAprUht(BigInteger.valueOf(enrollmentAprilUnknownHouseHold != null ? enrollmentAprilUnknownHouseHold.size() : getDefaultIntValue()));
		q08bDataBean.setHhCountAprWc(BigInteger.valueOf(enrollmentAprilHHWithChildren != null ? enrollmentAprilHHWithChildren.size() :getDefaultIntValue()));
		q08bDataBean.setHhCountAprWca(BigInteger.valueOf(enrollmentsAprilHHWithOneAdultChild != null ? enrollmentsAprilHHWithOneAdultChild.size() : getDefaultIntValue()));
		q08bDataBean.setHhCountAprWoc(BigInteger.valueOf(enrollmentAprilHHWithOutChildren != null ? enrollmentAprilHHWithOutChildren.size() : getDefaultIntValue()));
		
		q08bDataBean.setHhJulTotal(BigInteger.valueOf(enrollmentJulyTotal != null ? enrollmentJulyTotal.size() : getDefaultIntValue()));
		q08bDataBean.setHhCountJulUht(BigInteger.valueOf(enrollmentJulyUnknownHouseHold != null ? enrollmentJulyUnknownHouseHold.size() : getDefaultIntValue()));
		q08bDataBean.setHhCountJulWc(BigInteger.valueOf(enrollmentJulyHHWithChildren != null ? enrollmentJulyHHWithChildren.size() : getDefaultIntValue()));
		q08bDataBean.setHhCountJulWca(BigInteger.valueOf(enrollmentsJulyHHWithOneAdultChild != null ? enrollmentsJulyHHWithOneAdultChild.size() : getDefaultIntValue()));
		q08bDataBean.setHhCountJulWoc(BigInteger.valueOf(enrollmentJulyHHWithOutChildren != null? enrollmentJulyHHWithOutChildren.size() : getDefaultIntValue()));
		
		q08bDataBean.setHhOctTotal(BigInteger.valueOf(enrollmentOctoberTotal != null ? enrollmentOctoberTotal.size() :getDefaultIntValue()));
		q08bDataBean.setHhCountOctUht(BigInteger.valueOf(enrollmentOctoberUnknownHouseHold != null ? enrollmentOctoberUnknownHouseHold.size() : getDefaultIntValue()));
		q08bDataBean.setHhCountOctWc(BigInteger.valueOf(enrollmentOctoberHHWithChildren != null ? enrollmentOctoberHHWithChildren.size() : getDefaultIntValue()));
		q08bDataBean.setHhCountOctWca(BigInteger.valueOf(enrollmentsOctoberHHWithOneAdultChild != null ? enrollmentsOctoberHHWithOneAdultChild.size() : getDefaultIntValue()));
		q08bDataBean.setHhCountOctWoc(BigInteger.valueOf(enrollmentOctoberHHWithOutChildren != null ? enrollmentOctoberHHWithOutChildren.size() : getDefaultIntValue()));		
	} catch (Exception e) {
		logger.error("Error in Q08bDataBeanMaker:" + e);
	}
	}
		return Arrays.asList(q08bDataBean);
	}

}
