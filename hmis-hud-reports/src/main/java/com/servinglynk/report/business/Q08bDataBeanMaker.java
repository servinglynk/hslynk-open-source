package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;

import com.servinglynk.report.bean.Q08bDataBean;
import com.servinglynk.report.bean.ReportData;
import com.servinglynk.report.model.ContactModel;
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
		
		
		List<EnrollmentModel> enrollmentJanTotal = enrollments.parallelStream().filter(enrollment -> Util.getLocalDateFromUtilDate(enrollment.getEntrydate()).compareTo(lasWednesayOf(data.getReportEndDate(), 1)) == 0).collect(Collectors.toList());
		List<EnrollmentModel> enrollmentAprilTotal = enrollments.parallelStream().filter(enrollment -> Util.getLocalDateFromUtilDate(enrollment.getEntrydate()).compareTo(lasWednesayOf(data.getReportEndDate(), 4)) == 0).collect(Collectors.toList());
		List<EnrollmentModel> enrollmentJulyTotal = enrollments.parallelStream().filter(enrollment -> Util.getLocalDateFromUtilDate(enrollment.getEntrydate()).compareTo(lasWednesayOf(data.getReportEndDate(), 7)) == 0).collect(Collectors.toList());
		List<EnrollmentModel> enrollmentOctoberTotal = enrollments.parallelStream().filter(enrollment -> Util.getLocalDateFromUtilDate(enrollment.getEntrydate()).compareTo(lasWednesayOf(data.getReportEndDate(), 9)) == 0).collect(Collectors.toList());
			
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
		
		
		q08bDataBean.setHhJanTotal(BigInteger.valueOf(getGroupBySize(enrollmentJanTotal)));
		q08bDataBean.setHhCountJanUht(BigInteger.valueOf(getGroupBySize(enrollmentJanUnknownHouseHold))); 
		q08bDataBean.setHhCountJanWc(BigInteger.valueOf(getGroupBySize(enrollmentJanHHWithChildren)));
		q08bDataBean.setHhCountJanWca(BigInteger.valueOf(enrollmentsJanHHWithOneAdultChild != null ? enrollmentsJanHHWithOneAdultChild.size() : getDefaultIntValue() ));
		q08bDataBean.setHhCountJanWoc(BigInteger.valueOf(getGroupBySize(enrollmentJanHHWithOutChildren)));
		
		q08bDataBean.setHhAprTotal(BigInteger.valueOf(getGroupBySize(enrollmentAprilTotal)));
		q08bDataBean.setHhCountAprUht(BigInteger.valueOf(getGroupBySize(enrollmentAprilUnknownHouseHold)));
		q08bDataBean.setHhCountAprWc(BigInteger.valueOf(getGroupBySize(enrollmentAprilHHWithChildren)));
		q08bDataBean.setHhCountAprWca(BigInteger.valueOf(getGroupBySize(enrollmentsAprilHHWithOneAdultChild)));
		q08bDataBean.setHhCountAprWoc(BigInteger.valueOf(getGroupBySize(enrollmentAprilHHWithOutChildren)));
		
		q08bDataBean.setHhJulTotal(BigInteger.valueOf(getGroupBySize((enrollmentJulyTotal))));
		q08bDataBean.setHhCountJulUht(BigInteger.valueOf(getGroupBySize(enrollmentJulyUnknownHouseHold)));
		q08bDataBean.setHhCountJulWc(BigInteger.valueOf(getGroupBySize(enrollmentJulyHHWithChildren)));
		q08bDataBean.setHhCountJulWca(BigInteger.valueOf(getGroupBySize(enrollmentsJulyHHWithOneAdultChild)));
		q08bDataBean.setHhCountJulWoc(BigInteger.valueOf(getGroupBySize(enrollmentJulyHHWithOutChildren)));
		
		q08bDataBean.setHhOctTotal(BigInteger.valueOf(getGroupBySize(enrollmentOctoberTotal)));
		q08bDataBean.setHhCountOctUht(BigInteger.valueOf(getGroupBySize(enrollmentOctoberUnknownHouseHold)));
		q08bDataBean.setHhCountOctWc(BigInteger.valueOf(getGroupBySize(enrollmentOctoberHHWithChildren)));
		q08bDataBean.setHhCountOctWca(BigInteger.valueOf(getGroupBySize(enrollmentsOctoberHHWithOneAdultChild)));
		q08bDataBean.setHhCountOctWoc(BigInteger.valueOf(getGroupBySize(enrollmentOctoberHHWithOutChildren)));		
	} catch (Exception e) {
		logger.error("Error in Q08bDataBeanMaker:" + e);
	}
	}
		return Arrays.asList(q08bDataBean);
	}
	
	public static int getGroupBySize(List<EnrollmentModel> enrollments) {
		if(CollectionUtils.isNotEmpty(enrollments)) {
			Map<String, Long> collect = enrollments.stream().collect(Collectors.groupingBy(EnrollmentModel::getHouseholdid, Collectors.counting()));
			if(collect != null) {
				return collect.size();
			}
		}
			return 0;
	}

}
