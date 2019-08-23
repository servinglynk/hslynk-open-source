package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.servinglynk.report.bean.Q08bDataBean;
import com.servinglynk.report.bean.ReportData;
import com.servinglynk.report.model.EnrollmentModel;
import com.servinglynk.report.model.ExitModel;

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
			List<EnrollmentModel> leavers = data.getLeavers();
			List<EnrollmentModel> newEnrollments = new ArrayList<>();
			newEnrollments.addAll(enrollments);
			newEnrollments.addAll(leavers);
			// First of all lets get enrollments with in the report date range.
			// i.e enrollment.getEntryDate() is with in the report start date
			// and report end date.
			List<EnrollmentModel> fileteredEnrollments = newEnrollments.parallelStream()
					.filter(enrollment -> enrollment.getEntrydate() != null
							&& data.getReportEndDate().after(enrollment.getEntrydate()))
					.collect(Collectors.toList());

			List<EnrollmentModel> janEnrollments = getEnrollments(fileteredEnrollments, data, 1);
			if (janEnrollments != null) {
				q08bDataBean.setHhJanTotal(BigInteger.valueOf(janEnrollments.size()));
				List<EnrollmentModel> janEnrollmentsWithUnkownHouseHold = janEnrollments.parallelStream()
						.filter(enrollment -> projectsUnknownHouseHold.contains(enrollment.getProjectID()))
						.collect(Collectors.toList());
				List<EnrollmentModel> janEnrollmentsHHWithChildren = janEnrollments.parallelStream()
						.filter(enrollment -> projectsHHWithChildren.contains(enrollment.getProjectID()))
						.collect(Collectors.toList());
				List<EnrollmentModel> janEnrollmentsHHWithOutChildren = janEnrollments.parallelStream()
						.filter(enrollment -> projectsHHWithOutChildren.contains(enrollment.getProjectID()))
						.collect(Collectors.toList());
				List<EnrollmentModel> janEnrollmentsHHWithOneAdultChild = janEnrollments.parallelStream()
						.filter(enrollment -> projectsHHWithOneAdultChild.contains(enrollment.getProjectID()))
						.collect(Collectors.toList());
				
				q08bDataBean.setHhCountJanUht(BigInteger.valueOf(
						janEnrollmentsWithUnkownHouseHold != null ? janEnrollmentsWithUnkownHouseHold.size() : 0));
				q08bDataBean.setHhCountJanWoc(BigInteger
						.valueOf(janEnrollmentsHHWithChildren != null ? janEnrollmentsHHWithChildren.size() : 0));
				q08bDataBean.setHhCountJanWca(BigInteger.valueOf(
						janEnrollmentsHHWithOneAdultChild != null ? janEnrollmentsHHWithOneAdultChild.size() : 0));
				q08bDataBean.setHhCountJanWc(BigInteger
						.valueOf(janEnrollmentsHHWithOutChildren != null ? janEnrollmentsHHWithOutChildren.size() : 0));
			} else {
				q08bDataBean.setHhJanTotal(BigInteger.valueOf(0));
				q08bDataBean.setHhCountJanUht(BigInteger.valueOf(0));
				q08bDataBean.setHhCountJanWc(BigInteger.valueOf(0));
				q08bDataBean.setHhCountJanWca(BigInteger.valueOf(0));
				q08bDataBean.setHhCountJanWoc(BigInteger.valueOf(0));
			}

			List<EnrollmentModel> aprilEnrollments = getEnrollments(fileteredEnrollments, data, 4);
			if (aprilEnrollments != null) {
				List<EnrollmentModel> aprilEnrollmentsWithUnkownHouseHold = aprilEnrollments.parallelStream()
						.filter(enrollment -> projectsUnknownHouseHold.contains(enrollment.getProjectID()))
						.collect(Collectors.toList());
				List<EnrollmentModel> aprilEnrollmentsHHWithChildren = aprilEnrollments.parallelStream()
						.filter(enrollment -> projectsHHWithChildren.contains(enrollment.getProjectID()))
						.collect(Collectors.toList());
				List<EnrollmentModel> aprilEnrollmentsHHWithOutChildren = aprilEnrollments.parallelStream()
						.filter(enrollment -> projectsHHWithOutChildren.contains(enrollment.getProjectID()))
						.collect(Collectors.toList());
				List<EnrollmentModel> aprilEnrollmentsHHWithOneAdultChild = aprilEnrollments.parallelStream()
						.filter(enrollment -> projectsHHWithOneAdultChild.contains(enrollment.getProjectID()))
						.collect(Collectors.toList());
				
				q08bDataBean.setHhCountAprUht(BigInteger.valueOf(
						aprilEnrollmentsWithUnkownHouseHold != null ? aprilEnrollmentsWithUnkownHouseHold.size() : 0));
				q08bDataBean.setHhCountAprWoc(BigInteger
						.valueOf(aprilEnrollmentsHHWithChildren != null ? aprilEnrollmentsHHWithChildren.size() : 0));
				
				q08bDataBean.setHhCountAprWca(BigInteger.valueOf(
						aprilEnrollmentsHHWithOneAdultChild != null ? aprilEnrollmentsHHWithOneAdultChild.size() : 0));
				q08bDataBean.setHhCountAprWc(BigInteger.valueOf(
						aprilEnrollmentsHHWithOutChildren != null ? aprilEnrollmentsHHWithOutChildren.size() : 0));
				q08bDataBean.setHhAprTotal(BigInteger.valueOf(aprilEnrollments.size()));
			} else {
				q08bDataBean.setHhAprTotal(BigInteger.valueOf(0));
				q08bDataBean.setHhCountAprUht(BigInteger.valueOf(0));
				q08bDataBean.setHhCountAprWc(BigInteger.valueOf(0));
				q08bDataBean.setHhCountAprWca(BigInteger.valueOf(0));
				q08bDataBean.setHhCountAprWoc(BigInteger.valueOf(0));
			}

			List<EnrollmentModel> julyEnrollments = getEnrollments(fileteredEnrollments, data, 7);
			if (julyEnrollments != null) {
				List<EnrollmentModel> julyEnrollmentsWithUnkownHouseHold = julyEnrollments.parallelStream()
						.filter(enrollment -> projectsUnknownHouseHold.contains(enrollment.getProjectID()))
						.collect(Collectors.toList());
				List<EnrollmentModel> julyEnrollmentsHHWithChildren = julyEnrollments.parallelStream()
						.filter(enrollment -> projectsHHWithChildren.contains(enrollment.getProjectID()))
						.collect(Collectors.toList());
				List<EnrollmentModel> julyEnrollmentsHHWithOutChildren = julyEnrollments.parallelStream()
						.filter(enrollment -> projectsHHWithOutChildren.contains(enrollment.getProjectID()))
						.collect(Collectors.toList());
				List<EnrollmentModel> julyEnrollmentsHHWithOneAdultChild = julyEnrollments.parallelStream()
						.filter(enrollment -> projectsHHWithOneAdultChild.contains(enrollment.getProjectID()))
						.collect(Collectors.toList());
				q08bDataBean.setHhCountJulUht(BigInteger.valueOf(
						julyEnrollmentsWithUnkownHouseHold != null ? julyEnrollmentsWithUnkownHouseHold.size() : 0));
				q08bDataBean.setHhCountJulWoc(BigInteger
						.valueOf(julyEnrollmentsHHWithChildren != null ? julyEnrollmentsHHWithChildren.size() : 0));
				q08bDataBean.setHhCountJulWca(BigInteger.valueOf(
						julyEnrollmentsHHWithOneAdultChild != null ? julyEnrollmentsHHWithOneAdultChild.size() : 0));
				q08bDataBean.setHhCountJulWc(BigInteger.valueOf(
						julyEnrollmentsHHWithOutChildren != null ? julyEnrollmentsHHWithOutChildren.size() : 0));
				q08bDataBean.setHhJulTotal(BigInteger.valueOf(julyEnrollments.size()));
			} else {
				q08bDataBean.setHhJulTotal(BigInteger.valueOf(0));
				q08bDataBean.setHhCountJulUht(BigInteger.valueOf(0));
				q08bDataBean.setHhCountJulWc(BigInteger.valueOf(0));
				q08bDataBean.setHhCountJulWca(BigInteger.valueOf(0));
				q08bDataBean.setHhCountJulWoc(BigInteger.valueOf(0));
			}
			List<EnrollmentModel> octEnrollments = getEnrollments(fileteredEnrollments, data, 10);
			if (octEnrollments != null) {
				List<EnrollmentModel> octEnrollmentsWithUnkownHouseHold = octEnrollments.parallelStream()
						.filter(enrollment -> projectsUnknownHouseHold.contains(enrollment.getProjectID()))
						.collect(Collectors.toList());
				List<EnrollmentModel> octEnrollmentsHHWithChildren = octEnrollments.parallelStream()
						.filter(enrollment -> projectsHHWithChildren.contains(enrollment.getProjectID()))
						.collect(Collectors.toList());
				List<EnrollmentModel> octEnrollmentsHHWithOutChildren = octEnrollments.parallelStream()
						.filter(enrollment -> projectsHHWithOutChildren.contains(enrollment.getProjectID()))
						.collect(Collectors.toList());
				List<EnrollmentModel> octEnrollmentsHHWithOneAdultChild = octEnrollments.parallelStream()
						.filter(enrollment -> projectsHHWithOneAdultChild.contains(enrollment.getProjectID()))
						.collect(Collectors.toList());
				q08bDataBean.setHhCountOctUht(BigInteger.valueOf(
						octEnrollmentsWithUnkownHouseHold != null ? octEnrollmentsWithUnkownHouseHold.size() : 0));
				q08bDataBean.setHhCountOctWoc(BigInteger
						.valueOf(octEnrollmentsHHWithChildren != null ? octEnrollmentsHHWithChildren.size() : 0));
				q08bDataBean.setHhCountOctWca(BigInteger.valueOf(
						octEnrollmentsHHWithOneAdultChild != null ? octEnrollmentsHHWithOneAdultChild.size() : 0));
				q08bDataBean.setHhCountOctWc(BigInteger
						.valueOf(octEnrollmentsHHWithOutChildren != null ? octEnrollmentsHHWithOutChildren.size() : 0));
				q08bDataBean.setHhOctTotal(BigInteger.valueOf(octEnrollments.size()));
			} else {
				q08bDataBean.setHhOctTotal(BigInteger.valueOf(0));
				q08bDataBean.setHhCountOctUht(BigInteger.valueOf(0));
				q08bDataBean.setHhCountOctWc(BigInteger.valueOf(0));
				q08bDataBean.setHhCountOctWca(BigInteger.valueOf(0));
				q08bDataBean.setHhCountOctWoc(BigInteger.valueOf(0));
			}
		} catch (Exception e) {
			logger.error("Error in Q07bBeanMaker:" + e);
		}
	}
		return Arrays.asList(q08bDataBean);
	}

	public static void main(String args[]) {
		//System.out.println(lasWednesayOf(2018, 3).toString());
	}

	public static boolean isEnrollmentsFromLastWedForMonth(int year, int month, ReportData data,
			EnrollmentModel enrollment) {
		List<ExitModel> exits = data.getExits();
		if (exits != null) {
			List<ExitModel> exitForEnrollment = exits.parallelStream()
					.filter(exit -> StringUtils.equals(enrollment.getProjectEntryID(), exit.getProjectEntryID()))
					.collect(Collectors.toList());
			List<ExitModel> finalEnrollment = exitForEnrollment.parallelStream()
					.filter(exit -> exit.getExitdate() == null
							|| (exit.getExitdate() != null && Util.getLocalDateFromUtilDate(exit.getExitdate())
									.isBefore(lasWednesayOf(data.getReportEndDate(), month))))
					.collect(Collectors.toList());
			if (CollectionUtils.isNotEmpty(finalEnrollment)) {
				return false;
			}
		} else {
			return true;
		}
		return true;
	}

	public static List<EnrollmentModel> getEnrollments(List<EnrollmentModel> fileteredEnrollments, ReportData data,
			int month) {
		String[] housingProjectTypesArray = new String[] { "2", "3", "8", "9", "10", "13" };
		String[] otherProjectTypesArray = new String[] { "4", "6", "14" };
		List<String> housingProjectTypes = Arrays.asList(housingProjectTypesArray);
		List<String> otherProjectTypes = Arrays.asList(otherProjectTypesArray);
		List<EnrollmentModel> enrollmentJanTotal = new ArrayList<EnrollmentModel>();
		fileteredEnrollments.forEach(enrollment -> {
			 Calendar cal = Calendar.getInstance();
			 cal.setTime(data.getReportEndDate());
			 int year = cal.get(Calendar.YEAR);
			if (isEnrollmentsFromLastWedForMonth(year, month, data, enrollment)) {
				enrollmentJanTotal.add(enrollment);
			}
		});
		return enrollmentJanTotal;
	}

	public static boolean isEnrollmentsFromLastWedForMonthForOtherProjectTypes(int year, int month, ReportData data,
			EnrollmentModel enrollment) {
		List<ExitModel> exits = data.getExits();
		if (exits != null) {
			List<ExitModel> exitForEnrollment = exits.parallelStream()
					.filter(exit -> StringUtils.equals(enrollment.getProjectEntryID(), exit.getProjectEntryID()))
					.collect(Collectors.toList());
			List<ExitModel> finalEnrollment = exitForEnrollment.parallelStream()
					.filter(exit -> exit.getExitdate() == null
							|| (exit.getExitdate() != null && Util.getLocalDateFromUtilDate(exit.getExitdate())
									.compareTo(lasWednesayOf(data.getReportEndDate(), month)) <= 0))
					.collect(Collectors.toList());
			if (finalEnrollment != null) {
				return true;
			}
		} else {
			return true;
		}
		return false;
	}

}
