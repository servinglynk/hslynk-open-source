package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.servinglynk.hive.connection.ReportQuery;
import com.servinglynk.report.bean.Q07bPointInTimeCountHouseholdsLastWednesdayDataBean;
import com.servinglynk.report.bean.ReportData;
import com.servinglynk.report.model.EnrollmentModel;
import com.servinglynk.report.model.ExitModel;
import com.servinglynk.report.model.MoveInDateModel;

public class Q07bBeanMaker extends BaseBeanMaker {
	;

	/***
	 * HMIS Reporting Glossary Reference: Active Clients; Date of Birth / Age;
	 * Household Types; Unduplicated Household Counts and Unduplicated Client
	 * Counts by Household Type Programming Instructions: Report the total count
	 * of all persons in the project on the LAST WEDNESDAY of January, April,
	 * July and October falling with the report date range. For housing projects
	 * (types 2, 3, 8, 9, 10, 13), the client must not be exited the
	 * point-in-time date in order to be included ([project exit date] is null
	 * or > [point in time date]). For other project types (4, 6, and 14), the
	 * client’s [project exit date] may be on the point-in-time date and still
	 * be included on that date. See Reporting counts of clients by element by
	 * household type for column instructions.
	 * 
	 * @param data
	 * @return
	 */
	public static List<Q07bPointInTimeCountHouseholdsLastWednesdayDataBean> getQ07bPointInTimeCountHouseholdsLastWednesdayList(ReportData data) {
		Q07bPointInTimeCountHouseholdsLastWednesdayDataBean q07bDataBean = new Q07bPointInTimeCountHouseholdsLastWednesdayDataBean();
		if(data.isLiveMode()) {
		try {
			List<String> projectsHHWithChildren = data.getProjectsHHWithChildren();
			List<String> projectsHHWithOneAdultChild = data.getProjectsHHWithOneAdultChild();
			List<String> projectsHHWithOutChildren = data.getProjectsHHWithOutChildren();
			List<String> projectsUnknownHouseHold = data.getProjectsUnknownHouseHold();
			List<EnrollmentModel> leavers = data.getLeavers();
			List<EnrollmentModel> enrollments = data.getEnrollments();
			List<EnrollmentModel> newEnrollments = new ArrayList<>();
			newEnrollments.addAll(enrollments);
			newEnrollments.addAll(leavers);
			// First of all lets get enrollments with in the report date range.
			// i.e enrollment.getEntryDate() is with in the report start date
			// and report end date.
			
			// Get dedup Ids and move in date.
			List<MoveInDateModel> clientsWithMoveInDates = getClientsWithMoveInDates(data, formatQuery(ReportQuery.GET_CLIENTS_MOVE_IN_DATE,data.getSchema(),data));
			
			List<EnrollmentModel> fileteredEnrollments = newEnrollments.parallelStream()
					.filter(enrollment -> enrollment.getEntrydate() != null
							&& data.getReportEndDate().after(enrollment.getEntrydate()))
					.collect(Collectors.toList());
			/** Start filtering and applying all the below rules here 
			 * 
			  **/

			List<EnrollmentModel> janEnrollments = getEnrollments(fileteredEnrollments, data, 1, clientsWithMoveInDates);
			if (janEnrollments != null) {
				q07bDataBean.setHhJanTotal(BigInteger.valueOf(janEnrollments.size()));
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
				
				q07bDataBean.setHhCountJanUht(BigInteger.valueOf(
						janEnrollmentsWithUnkownHouseHold != null ? janEnrollmentsWithUnkownHouseHold.size() : 0));
				q07bDataBean.setHhCountJanWoc(BigInteger
						.valueOf(janEnrollmentsHHWithChildren != null ? janEnrollmentsHHWithChildren.size() : 0));
				q07bDataBean.setHhCountJanWca(BigInteger.valueOf(
						janEnrollmentsHHWithOneAdultChild != null ? janEnrollmentsHHWithOneAdultChild.size() : 0));
				q07bDataBean.setHhCountJanWc(BigInteger
						.valueOf(janEnrollmentsHHWithOutChildren != null ? janEnrollmentsHHWithOutChildren.size() : 0));
			} else {
				q07bDataBean.setHhJanTotal(BigInteger.valueOf(0));
				q07bDataBean.setHhCountJanUht(BigInteger.valueOf(0));
				q07bDataBean.setHhCountJanWc(BigInteger.valueOf(0));
				q07bDataBean.setHhCountJanWca(BigInteger.valueOf(0));
				q07bDataBean.setHhCountJanWoc(BigInteger.valueOf(0));
			}

			List<EnrollmentModel> aprilEnrollments = getEnrollments(fileteredEnrollments, data, 4, clientsWithMoveInDates);
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
				
				q07bDataBean.setHhCountAprUht(BigInteger.valueOf(
						aprilEnrollmentsWithUnkownHouseHold != null ? aprilEnrollmentsWithUnkownHouseHold.size() : 0));
				q07bDataBean.setHhCountAprWoc(BigInteger
						.valueOf(aprilEnrollmentsHHWithChildren != null ? aprilEnrollmentsHHWithChildren.size() : 0));
				
				q07bDataBean.setHhCountAprWca(BigInteger.valueOf(
						aprilEnrollmentsHHWithOneAdultChild != null ? aprilEnrollmentsHHWithOneAdultChild.size() : 0));
				q07bDataBean.setHhCountAprWc(BigInteger.valueOf(
						aprilEnrollmentsHHWithOutChildren != null ? aprilEnrollmentsHHWithOutChildren.size() : 0));
				q07bDataBean.setHhAprTotal(BigInteger.valueOf(aprilEnrollments.size()));
			} else {
				q07bDataBean.setHhAprTotal(BigInteger.valueOf(0));
				q07bDataBean.setHhCountAprUht(BigInteger.valueOf(0));
				q07bDataBean.setHhCountAprWc(BigInteger.valueOf(0));
				q07bDataBean.setHhCountAprWca(BigInteger.valueOf(0));
				q07bDataBean.setHhCountAprWoc(BigInteger.valueOf(0));
			}

			List<EnrollmentModel> julyEnrollments = getEnrollments(fileteredEnrollments, data, 7, clientsWithMoveInDates);
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
				q07bDataBean.setHhCountJulUht(BigInteger.valueOf(
						julyEnrollmentsWithUnkownHouseHold != null ? julyEnrollmentsWithUnkownHouseHold.size() : 0));
				q07bDataBean.setHhCountJulWoc(BigInteger
						.valueOf(julyEnrollmentsHHWithChildren != null ? julyEnrollmentsHHWithChildren.size() : 0));
				q07bDataBean.setHhCountJulWca(BigInteger.valueOf(
						julyEnrollmentsHHWithOneAdultChild != null ? julyEnrollmentsHHWithOneAdultChild.size() : 0));
				q07bDataBean.setHhCountJulWc(BigInteger.valueOf(
						julyEnrollmentsHHWithOutChildren != null ? julyEnrollmentsHHWithOutChildren.size() : 0));
				q07bDataBean.setHhJulTotal(BigInteger.valueOf(julyEnrollments.size()));
			} else {
				q07bDataBean.setHhJulTotal(BigInteger.valueOf(0));
				q07bDataBean.setHhCountJulUht(BigInteger.valueOf(0));
				q07bDataBean.setHhCountJulWc(BigInteger.valueOf(0));
				q07bDataBean.setHhCountJulWca(BigInteger.valueOf(0));
				q07bDataBean.setHhCountJulWoc(BigInteger.valueOf(0));
			}
			List<EnrollmentModel> octEnrollments = getEnrollments(fileteredEnrollments, data, 10, clientsWithMoveInDates);
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
				q07bDataBean.setHhCountOctUht(BigInteger.valueOf(
						octEnrollmentsWithUnkownHouseHold != null ? octEnrollmentsWithUnkownHouseHold.size() : 0));
				q07bDataBean.setHhCountOctWoc(BigInteger
						.valueOf(octEnrollmentsHHWithChildren != null ? octEnrollmentsHHWithChildren.size() : 0));
				q07bDataBean.setHhCountOctWca(BigInteger.valueOf(
						octEnrollmentsHHWithOneAdultChild != null ? octEnrollmentsHHWithOneAdultChild.size() : 0));
				q07bDataBean.setHhCountOctWc(BigInteger
						.valueOf(octEnrollmentsHHWithOutChildren != null ? octEnrollmentsHHWithOutChildren.size() : 0));
				q07bDataBean.setHhOctTotal(BigInteger.valueOf(octEnrollments.size()));
			} else {
				q07bDataBean.setHhOctTotal(BigInteger.valueOf(0));
				q07bDataBean.setHhCountOctUht(BigInteger.valueOf(0));
				q07bDataBean.setHhCountOctWc(BigInteger.valueOf(0));
				q07bDataBean.setHhCountOctWca(BigInteger.valueOf(0));
				q07bDataBean.setHhCountOctWoc(BigInteger.valueOf(0));
			}
		} catch (Exception e) {
			logger.error("Error in Q07bBeanMaker:" + e);
		}
	}
		return Arrays.asList(q07bDataBean);
	}

	public static void main(String args[]) {
		//System.out.println(lasWednesayOf(2018, 3).toString());
	}
	/***
	 * 2.	For project types 3 and 13 (Permanent Supportive Housing and Rapid Re-Housing): report the total count of all persons in the project where the head of household had a move in date on or before the LAST WEDNESDAY of January, April, July, and October, respectively. 
			a.	[project start date] <= [point in time date]
			b.	AND [project exit date] is null or > [point in time date]
			c.	AND [housing move-in date] <= [point in time date]
			3.	For all other project types: Report the total count of all persons in the project on the LAST WEDNESDAY of January, April, July, and October falling with the report date range.  
			4.	For all housing project types (types 2, 3, 8, 9, 10, 13), the client must not be exited on the point-in-time date in order to be included ([project exit date] is null or > [point in time date]).
			5.	For other project types (4, 6, and 14), the client’s [project exit date] may be on the point-in-time date and still be included on that date.
	 * @param year
	 * @param month
	 * @param data
	 * @param enrollment
	 * @return
	 */
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
			int month, List<MoveInDateModel> clientsWithMoveInDates) {
		
		List<EnrollmentModel> enrollmentJanTotal = new ArrayList<EnrollmentModel>();
		fileteredEnrollments.forEach(enrollment -> {
			 Calendar cal = Calendar.getInstance();
			 cal.setTime(data.getReportEndDate());
			 int year = cal.get(Calendar.YEAR);
			 boolean pshRRFlag = false;
			 if(CollectionUtils.isNotEmpty(clientsWithMoveInDates)) {
				 
				 List<MoveInDateModel> filteredMoveInDates = clientsWithMoveInDates.parallelStream().filter(moveInDate -> StringUtils.equals(moveInDate.getDedupClientId(), enrollment.getDedupClientId())).collect(Collectors.toList());
				 if(CollectionUtils.isNotEmpty(filteredMoveInDates)) {
					 MoveInDateModel moveInDate = filteredMoveInDates.get(0);
					 if(StringUtils.equals("3", moveInDate.getProjectType()) || StringUtils.equals("13", moveInDate.getProjectType())) {
						 if(enrollment.getEntrydate() != null && Util.getLocalDateFromUtilDate(enrollment.getEntrydate())
									.compareTo(lasWednesayOf(data.getReportEndDate(), month)) <= 0 
									&&				
									moveInDate.getMoveInDate() != null  && Util.getLocalDateFromUtilDate(moveInDate.getMoveInDate())
									.compareTo(lasWednesayOf(data.getReportEndDate(), month)) <= 0 	) {
							 if (isEnrollmentsFromLastWedForMonth(year, month, data, enrollment) ) {
									enrollmentJanTotal.add(enrollment);
									 pshRRFlag = true;
								}
						 }
					 }
				 }
			 }
			 
			if (isEnrollmentsFromLastWedForMonth(year, month, data, enrollment) && !pshRRFlag) {
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
