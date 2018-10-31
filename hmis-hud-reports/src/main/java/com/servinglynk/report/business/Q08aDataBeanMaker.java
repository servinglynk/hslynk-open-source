package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.servinglynk.report.bean.Q08aDataBean;
import com.servinglynk.report.bean.ReportData;
import com.servinglynk.report.model.ClientModel;
import com.servinglynk.report.model.EnrollmentModel;

public class Q08aDataBeanMaker extends BaseBeanMaker {

	public static List<Q08aDataBean> getQ08aDataBeanList(ReportData data) {
		Q08aDataBean q08aDataBean = new Q08aDataBean();
		if(data.isLiveMode()) {
		try {
		
			List<String> projectsHHWithChildren = data.getProjectsHHWithChildren();
			List<String> projectsHHWithOneAdultChild = data.getProjectsHHWithOneAdultChild();
			List<String> projectsHHWithOutChildren = data.getProjectsHHWithOutChildren();
			List<String> projectsUnknownHouseHold = data.getProjectsUnknownHouseHold();

			List<ClientModel> clients = data.getClients();
			List<EnrollmentModel> enrollments = data.getEnrollments();
			List<EnrollmentModel> enrollmentsHHWithChildren = enrollments.parallelStream()
					.filter(enrollment -> projectsHHWithChildren.contains(enrollment.getProjectID()))
					.collect(Collectors.toList());
			
			List<EnrollmentModel> enrollmentsHHWithOneAdultChild = enrollments.parallelStream()
					.filter(enrollment -> projectsHHWithOneAdultChild.contains(enrollment.getProjectID()))
					.collect(Collectors.toList());
	

			List<EnrollmentModel> enrollmentsHHWithOutChildren = enrollments.parallelStream()
					.filter(enrollment -> projectsHHWithOutChildren.contains(enrollment.getProjectID()))
					.collect(Collectors.toList());
			

			List<EnrollmentModel> enrollmentsUnknownHouseHold = enrollments.parallelStream()
					.filter(enrollment -> projectsUnknownHouseHold.contains(enrollment.getProjectID()))
					.collect(Collectors.toList());
		
			q08aDataBean.setOverAllTotHouseHolds(BigInteger.valueOf(clients != null ? clients.size() : 0));
			q08aDataBean.setTotHhWithoutChild(
					BigInteger.valueOf(getSize(enrollmentsHHWithOutChildren)));
			q08aDataBean.setTotHhUnknownHhType(
					BigInteger.valueOf(getSize(enrollmentsUnknownHouseHold)));
			q08aDataBean.setTotHhWothOnlyChild(
					BigInteger.valueOf(getSize(enrollmentsHHWithChildren)));
			q08aDataBean.setTotHhWithChildAndAdults(
					BigInteger.valueOf(getSize(enrollmentsHHWithOneAdultChild)));
			
			data.setOverAllTotHouseHolds(q08aDataBean.getOverAllTotHouseHolds());
			data.setTotHhWithoutChild(q08aDataBean.getTotHhWithoutChild());
			data.setTotHhUnknownHhType(q08aDataBean.getTotHhUnknownHhType());
			data.setTotHhWothOnlyChild(q08aDataBean.getTotHhWothOnlyChild());
			data.setTotHhWithChildAndAdults(q08aDataBean.getTotHhWithChildAndAdults());
		} catch (Exception e) {
			logger.error("Error in Q08aDataBeanMaker:" + e);
		}
	}
		return Arrays.asList(q08aDataBean);
	}

}