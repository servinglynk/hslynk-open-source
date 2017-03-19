package com.servinglynk.report.business;

import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.servinglynk.report.bean.DataBean;

public class DataBeanMaker {

	public static ArrayList<DataBean> getDataBeanList() {

		ArrayList<DataBean> dataBeanList = new ArrayList<DataBean>();

		DataBean bean = (firstPage("1/1/2015", " ", "APR - Services Only",
				"Everyone", "all grants", "Aggregate / summary",
				"All Practical Reporting, Inc.", "APR", "APR - Services Only",
				BigInteger.valueOf(240), BigInteger.valueOf(6),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(1),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(1),
				/*
				 * BigInteger.valueOf(0), BigInteger.valueOf(1),
				 * BigInteger.valueOf(0), BigInteger.valueOf(0),
				 */
				BigInteger.valueOf(0), BigInteger.valueOf(0)));

		/**
		 * Q05A HMIS or Comparable Database Data Quality Table -- Starts
		 **/
		q05ACDDQ(BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(11),
				BigInteger.valueOf(10), BigInteger.valueOf(1),
				BigInteger.valueOf(4), BigInteger.valueOf(1),
				BigInteger.valueOf(16), BigInteger.valueOf(3),
				BigInteger.valueOf(2), BigInteger.valueOf(0),
				BigInteger.valueOf(1), BigInteger.valueOf(0),
				BigInteger.valueOf(1), BigInteger.valueOf(0),
				BigInteger.valueOf(1), BigInteger.valueOf(1),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0), bean);

		/**
		 * Q06A Report Validations Table -- Starts
		 **/
		q06AReportValidations("16", "11", "4", "3", "3", "4", "2", "11", "1",
				"1", "2", "1", "13", "8", bean);

		/**
		 * Q06B Number of Persons Served Table -- Starts
		 **/
		q06BNumberOfPersonsServed(BigInteger.valueOf(11),
				BigInteger.valueOf(4), BigInteger.valueOf(0),
				BigInteger.valueOf(1), BigInteger.valueOf(16),
				BigInteger.valueOf(10), BigInteger.valueOf(1),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(2), BigInteger.valueOf(2),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(1), BigInteger.valueOf(10),
				BigInteger.valueOf(0), BigInteger.valueOf(3),
				BigInteger.valueOf(2), BigInteger.valueOf(1), bean);

		/**
		 * Q06C Point-in-Time Count of Persons on the Last Wednesday Table --
		 * Starts
		 **/
		q06CPCPLastWednesday(BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0), bean);

		/**
		 * Q07a HouseholdsServed Table -- Starts
		 **/
		q07AHouseHoldsServed(BigInteger.valueOf(13), BigInteger.valueOf(10),
				BigInteger.valueOf(1), BigInteger.valueOf(1),
				BigInteger.valueOf(1), bean);
		/**
		 * Q07b: Point-in-Time Count of Households on the Last Wednesday Table
		 * -- Starts
		 **/
		q07BPointinTimeCountHHLastWednesday(BigInteger.valueOf(2),
				BigInteger.valueOf(4), BigInteger.valueOf(7),
				BigInteger.valueOf(9), BigInteger.valueOf(2),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(3),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(1), BigInteger.valueOf(6),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(1), BigInteger.valueOf(6),
				BigInteger.valueOf(1), BigInteger.valueOf(1),
				BigInteger.valueOf(1), bean);

		/**
		 * Q09a: Number of Persons Contacted Table -- Starts
		 **/
		q09ANumberOfPersonsContacted(BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0), bean);

		/**
		 * "Q09b: Number of Persons Engaged" Table -- Starts
		 */
		q09BNumberOfPersonsEngaged(BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), bean);

		/**
		 * "Q10a: Gender of Adults" Table -- Starts
		 */
		q10AGenderOfAdults(BigInteger.valueOf(5), BigInteger.valueOf(4),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(1), BigInteger.valueOf(0),
				BigInteger.valueOf(11), BigInteger.valueOf(5),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(3), BigInteger.valueOf(1),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(1),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(10),
				BigInteger.valueOf(1), BigInteger.valueOf(0),
				BigInteger.valueOf(1), BigInteger.valueOf(1),
				BigInteger.valueOf(0), BigInteger.valueOf(0), bean);

		/**
		 * "Q10b: Gender of Children" Table -- Starts
		 **/
		q10bGenderOfChildren(BigInteger.valueOf(2), BigInteger.valueOf(2),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(4), BigInteger.valueOf(1),
				BigInteger.valueOf(1), BigInteger.valueOf(0),
				BigInteger.valueOf(1), BigInteger.valueOf(1),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(2),
				BigInteger.valueOf(2), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0), bean);

		/**
		 * "Q10c: Gender of Persons Missing Age Information" Table -- Starts
		 */
		q10CGPMI(BigInteger.valueOf(1), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(1), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(1),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0), bean);
		/**
		 * "Q11: Age" Table -- Starts
		 */
		q11AgeTableBean(BigInteger.valueOf(1), BigInteger.valueOf(2),
				BigInteger.valueOf(1), BigInteger.valueOf(2),
				BigInteger.valueOf(4), BigInteger.valueOf(1),
				BigInteger.valueOf(2), BigInteger.valueOf(1),
				BigInteger.valueOf(1), BigInteger.valueOf(0),
				BigInteger.valueOf(1), BigInteger.valueOf(16),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(1), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(2),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(1), BigInteger.valueOf(0),
				BigInteger.valueOf(1), BigInteger.valueOf(1),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(4), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(1), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(2), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(1), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(1), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(1),
				BigInteger.valueOf(10), BigInteger.valueOf(3),
				BigInteger.valueOf(2), BigInteger.valueOf(1), bean);

		/**
		 * "Q12a: Race" Table -- Starts
		 */
		q12aRaceTableBean(BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), bean);

		/**
		 * "Q12b: Ethnicity" Table -- Starts
		 */
		q12bEthnicityTableBean(BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), bean);

		/**
		 * "Q13a1: Physical Mental Health Condition" Table -- Starts
		 */
		q13a1PhysicalMntlHealthCondTableBean(BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), bean);

		/**
		 * "Q13a2: Number of Conditions" Table -- Starts
		 */
		q13a2NumberofConditioinsTableBean(BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), bean);

		q13b1PhysicalAndMentalHealthConditionsAtExitTableBean(
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0), bean);

		q13b2NumberOfConditionsAtExitTableBean(BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), bean);

		q13c1PhysicalAndMentalHealthConditionsForStayerTableBean(
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0), bean);

		q13c2NumberOfConditionForStayersTableBean(BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), bean);

		q14aDomesticViolenceHistoryTableBean(BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0), bean);

		q14bPersonsFleeingDomesticViolenceTableBean(BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0), bean);

		q15ResidencePriorToProgramEntryBeanPublic(BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0), bean);

		q16CashIncomeRangesTableBean(BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0),
				BigInteger.valueOf(0), BigInteger.valueOf(0), bean);

		dataBeanList.add(bean);
		return dataBeanList;
	}

	private static DataBean firstPage(String homePageStartDate,
			String homePageEndDate, String homePageProjects,
			String homePageHomeLess, String homePageGrants,
			String homePageView, String q04aOrgName, String q04aOrgId,
			String q04aProjectName, BigInteger q04aHmisProjectIdService,
			BigInteger q04aHmisProjectType, BigInteger q04aIdentityProjectId,
			BigInteger q04aMethodOfTracking, BigInteger q04aProjectId,
			BigInteger countJanTotal, BigInteger countAprTotal,
			BigInteger countJulTotal, BigInteger countOctTotal,
			BigInteger npDkrTot, BigInteger npMiTot, BigInteger npAdultsTot,
			BigInteger npChildTot, BigInteger npTotSum, BigInteger npWcSum,
			BigInteger npWCASum, BigInteger npWOCSum, BigInteger npUHTSum

	// twenty seven
	) {

		DataBean dataBean = new DataBean();

		dataBean.setCountAprTotal(countAprTotal);
		dataBean.setCountJanTotal(countJanTotal);
		dataBean.setCountJulTotal(countJulTotal);
		dataBean.setCountOctTotal(countOctTotal);
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		// dataBean.setHomePageEndDate(dateFormat.format(date));
		dataBean.setEndDate(dateFormat.format(date));
		// dataBean.setHomePageGrants(homePageGrants);
		dataBean.setGrants(homePageGrants);
		dataBean.setQ04aHmisProjectIdService(q04aHmisProjectIdService);
		dataBean.setQ04aHmisProjectType(q04aHmisProjectType);
		// dataBean.setHomePageHomeLess(homePageHomeLess);
		dataBean.setHomeLess(homePageHomeLess);
		dataBean.setQ04aIdentityProjectId(q04aIdentityProjectId);
		dataBean.setQ04aMethodOfTracking(q04aMethodOfTracking);
		dataBean.setQ04aOrgId(q04aOrgId);
		dataBean.setQ04aOrgName(q04aOrgName);
		dataBean.setQ04aProjectId(q04aProjectId);
		dataBean.setQ04aProjectName(q04aProjectName);
		/*
		 * dataBean.setHomePageProjects(homePageProjects);
		 * dataBean.setHomePageStartDate(homePageStartDate);
		 * dataBean.setHomePageView(homePageView);
		 */
		dataBean.setProjects(homePageProjects);
		dataBean.setStartDate(homePageStartDate);
		dataBean.setView(homePageView);
		dataBean.setNpAdultsTot(npAdultsTot);
		dataBean.setNpChildTot(npChildTot);
		dataBean.setNpDkrTot(npDkrTot);
		dataBean.setNpMiTot(npMiTot);
		dataBean.setNpTotSum(npTotSum);
		dataBean.setNpUHTSum(npUHTSum);
		dataBean.setNpWCASum(npWCASum);
		dataBean.setNpWcSum(npWcSum);
		dataBean.setNpWOCSum(npWOCSum);

		return dataBean;
	}

	/**
	 * Q05A HMIS or Comparable Database Data Quality Table -- Starts
	 **/
	private static DataBean q05ACDDQ(BigInteger clientlocationForPe,
			BigInteger destination, BigInteger disablingCond, BigInteger dob,
			BigInteger ethnicity, BigInteger firstName, BigInteger gender,
			BigInteger lastName, BigInteger ltsInEs, BigInteger race,
			BigInteger relationshiptToHh, BigInteger residencePriorToEntry,
			BigInteger ssn, BigInteger veteranStatus,
			BigInteger mdClientlocationForPe, BigInteger mdDestination,
			BigInteger mdDisablingCond, BigInteger mdDob,
			BigInteger mdEthnicity, BigInteger mdFirstName,
			BigInteger mdGender, BigInteger mdLastName, BigInteger mdLtsInEsSh,
			BigInteger mdRace, BigInteger mdRelationshipToHh, BigInteger mdSsn,
			BigInteger mdVeteranStatus, BigInteger mdresidencepriortoentry,
			DataBean q05ACDDQ) {

		q05ACDDQ.setClientlocationForPe(clientlocationForPe);
		q05ACDDQ.setDestination(destination);
		q05ACDDQ.setDisablingCond(disablingCond);
		q05ACDDQ.setDob(dob);
		q05ACDDQ.setEthnicity(ethnicity);
		q05ACDDQ.setFirstName(firstName);
		q05ACDDQ.setGender(gender);
		q05ACDDQ.setLastName(lastName);
		q05ACDDQ.setLtsInEs(ltsInEs);
		q05ACDDQ.setMdClientlocationForPe(mdClientlocationForPe);
		q05ACDDQ.setMdDestination(mdDestination);
		q05ACDDQ.setMdDisablingCond(mdDisablingCond);
		q05ACDDQ.setMdDob(mdDob);
		q05ACDDQ.setMdEthnicity(mdEthnicity);
		q05ACDDQ.setMdFirstName(mdFirstName);
		q05ACDDQ.setMdGender(mdGender);
		q05ACDDQ.setMdLastName(mdLastName);
		q05ACDDQ.setMdLtsInEsSh(mdLtsInEsSh);
		q05ACDDQ.setMdRace(mdRace);
		q05ACDDQ.setMdRelationshipToHh(mdRelationshipToHh);
		q05ACDDQ.setMdresidencepriortoentry(mdresidencepriortoentry);
		q05ACDDQ.setMdSsn(mdSsn);
		q05ACDDQ.setMdVeteranStatus(mdVeteranStatus);
		q05ACDDQ.setRace(race);
		q05ACDDQ.setRelationshiptToHh(relationshiptToHh);
		q05ACDDQ.setResidencePriorToEntry(residencePriorToEntry);
		q05ACDDQ.setSsn(ssn);
		q05ACDDQ.setVeteranStatus(veteranStatus);

		return q05ACDDQ;
	}

	/**
	 * Q06A Report Validations Table -- Starts
	 **/
	private static DataBean q06AReportValidations(String totNumOfPersonServed,
			String numOfAdults, String numOfChildren,
			String numOfPersonsWithUnknownAge, String totNoOfLeavers,
			String totNoOfAdultLeavers, String noOfVeterans,
			String noOfChronicallyHomelessPersons,
			String noOfAdultHeadsOfHousehold, String noOfChildHeadsOfHousehold,
			String numOfUnaccompaniedYouthUnderAge25,
			String numOfParentingYouthUnderAge25WithChildren,
			String totNoOfStayers, String totNoOfAdultStayers,
			DataBean q06AReportValidations) {

		q06AReportValidations
				.setNoOfAdultHeadsOfHousehold(noOfAdultHeadsOfHousehold);
		q06AReportValidations
				.setNoOfChildHeadsOfHousehold(noOfChildHeadsOfHousehold);
		q06AReportValidations
				.setNoOfChronicallyHomelessPersons(noOfChronicallyHomelessPersons);
		q06AReportValidations.setNoOfVeterans(noOfVeterans);
		q06AReportValidations.setNumOfAdults(numOfAdults);
		q06AReportValidations.setNumOfChildren(numOfChildren);
		q06AReportValidations
				.setNumOfParentingYouthUnderAge25WithChildren(numOfParentingYouthUnderAge25WithChildren);
		q06AReportValidations
				.setNumOfPersonsWithUnknownAge(numOfPersonsWithUnknownAge);
		q06AReportValidations
				.setNumOfUnaccompaniedYouthUnderAge25(numOfUnaccompaniedYouthUnderAge25);
		q06AReportValidations.setTotNoOfAdultLeavers(totNoOfAdultLeavers);
		q06AReportValidations.setTotNoOfLeavers(totNoOfLeavers);
		q06AReportValidations.setTotNumOfPersonServed(totNumOfPersonServed);
		q06AReportValidations.setTotNoOfAdultStayers(totNoOfAdultStayers);
		q06AReportValidations.setTotNoOfStayers(totNoOfStayers);

		return q06AReportValidations;
	}

	/**
	 * Q06B Number of Persons Served Table -- Starts
	 **/
	private static DataBean q06BNumberOfPersonsServed(

	BigInteger npTotalAdults, BigInteger npTotalChildren,
			BigInteger npTotalDKR, BigInteger npTotalMI,
			BigInteger npOverallTotal,

			BigInteger npAdultsUhtTot, BigInteger npAdultsWcTot,
			BigInteger npAdultsWcaTot, BigInteger npAdultsWocTot,

			BigInteger npChildUhtTot, BigInteger npChildWcTot,
			BigInteger npChildWcaTot, BigInteger npChildWocTot,
			BigInteger npDkrUhtTot, BigInteger npDkrWcTot,
			BigInteger npDkrWcsTot, BigInteger npDkrWocTot,
			BigInteger npMiUhtTot, BigInteger npMiWcTot, BigInteger npMiWcaTot,
			BigInteger npMiWocTot, BigInteger npTotalWC, BigInteger npWCATotal,
			BigInteger npWOCTotal, BigInteger npUHTTotal,
			DataBean q06BNumberOfPersonsServed) {

		q06BNumberOfPersonsServed.setNpAdultsUhtTot(npAdultsUhtTot);
		q06BNumberOfPersonsServed.setNpAdultsWcaTot(npAdultsWcaTot);
		q06BNumberOfPersonsServed.setNpAdultsWcTot(npAdultsWcTot);
		q06BNumberOfPersonsServed.setNpAdultsWocTot(npAdultsWocTot);
		q06BNumberOfPersonsServed.setNpChildUhtTot(npChildUhtTot);
		q06BNumberOfPersonsServed.setNpChildWcaTot(npChildWcaTot);
		q06BNumberOfPersonsServed.setNpChildWcTot(npChildWcTot);
		q06BNumberOfPersonsServed.setNpChildWocTot(npChildWocTot);
		q06BNumberOfPersonsServed.setNpDkrUhtTot(npDkrUhtTot);
		q06BNumberOfPersonsServed.setNpDkrWcsTot(npDkrWcsTot);
		q06BNumberOfPersonsServed.setNpDkrWcTot(npDkrWcTot);
		q06BNumberOfPersonsServed.setNpDkrWocTot(npDkrWocTot);
		q06BNumberOfPersonsServed.setNpMiUhtTot(npMiUhtTot);
		q06BNumberOfPersonsServed.setNpMiWcTot(npMiWcTot);
		q06BNumberOfPersonsServed.setNpMiWcaTot(npMiWcaTot);
		q06BNumberOfPersonsServed.setNpMiWocTot(npMiWocTot);
		q06BNumberOfPersonsServed.setNpOverallTotal(npOverallTotal);
		q06BNumberOfPersonsServed.setNpTotalAdults(npTotalAdults);
		q06BNumberOfPersonsServed.setNpTotalChildren(npTotalChildren);
		q06BNumberOfPersonsServed.setNpTotalDKR(npTotalDKR);
		q06BNumberOfPersonsServed.setNpTotalMI(npTotalMI);
		q06BNumberOfPersonsServed.setNpTotalWC(npTotalWC);
		q06BNumberOfPersonsServed.setNpUHTTotal(npUHTTotal);
		q06BNumberOfPersonsServed.setNpWCATotal(npWCATotal);
		q06BNumberOfPersonsServed.setNpWOCTotal(npWOCTotal);

		return q06BNumberOfPersonsServed;
	}

	/**
	 * Q06C Point-in-Time Count of Persons on the Last Wednesday Table -- Starts
	 **/
	private static DataBean q06CPCPLastWednesday(BigInteger janTotal,
			BigInteger aprTotal, BigInteger julyTotal, BigInteger octTotal,
			BigInteger countAprUht, BigInteger countAprWc,
			BigInteger countAprWca, BigInteger countAprWoc,
			BigInteger countJanUht, BigInteger countJanWc,
			BigInteger countJanWca, BigInteger countJanWoc,
			BigInteger countJulUht, BigInteger countJulWc,
			BigInteger countJulWca, BigInteger countJulWoc,
			BigInteger countOctUht, BigInteger countOctWc,
			BigInteger countOctWca, BigInteger countOctWoc,
			DataBean q06CPCPLastWednesday) {

		q06CPCPLastWednesday.setAprTotal(aprTotal);
		q06CPCPLastWednesday.setCountAprUht(countAprUht);
		q06CPCPLastWednesday.setCountAprWc(countAprWc);
		q06CPCPLastWednesday.setCountAprWca(countAprWca);
		q06CPCPLastWednesday.setCountAprWoc(countAprWoc);
		q06CPCPLastWednesday.setCountJanUht(countJanUht);
		q06CPCPLastWednesday.setCountJanWc(countJanWc);
		q06CPCPLastWednesday.setCountJanWca(countJanWca);
		q06CPCPLastWednesday.setCountJanWoc(countJanWoc);
		q06CPCPLastWednesday.setCountJulUht(countJulUht);
		q06CPCPLastWednesday.setCountJulWc(countJulWc);
		q06CPCPLastWednesday.setCountJulWca(countJulWca);
		q06CPCPLastWednesday.setCountJulWoc(countJulWoc);
		q06CPCPLastWednesday.setCountOctUht(countOctUht);
		q06CPCPLastWednesday.setCountOctWc(countOctWc);
		q06CPCPLastWednesday.setCountOctWca(countOctWca);
		q06CPCPLastWednesday.setCountOctWoc(countOctWoc);
		q06CPCPLastWednesday.setJanTotal(janTotal);
		q06CPCPLastWednesday.setJulyTotal(julyTotal);
		q06CPCPLastWednesday.setOctTotal(octTotal);

		return q06CPCPLastWednesday;
	}

	/**
	 * Q07a _HouseholdsServed Table -- Starts
	 **/
	private static DataBean q07AHouseHoldsServed(BigInteger overAllTot,
			BigInteger totHhWithoutChild, BigInteger totHhWithChildAndAdults,
			BigInteger totHhWithOnlyChild, BigInteger totHhUnknowHhType,
			DataBean q07AHouseHoldsServed) {

		q07AHouseHoldsServed.setOverAllTotHouseHolds(overAllTot);
		q07AHouseHoldsServed.setTotHhWithoutChild(totHhWithoutChild);
		q07AHouseHoldsServed.setTotHhUnknownHhType(totHhUnknowHhType);
		q07AHouseHoldsServed.setTotHhWothOnlyChild(totHhWithOnlyChild);
		q07AHouseHoldsServed
				.setTotHhWithChildAndAdults(totHhWithChildAndAdults);

		return q07AHouseHoldsServed;
	}

	/**
	 * Q07b: Point-in-Time Count of Households on the Last Wednesday Table --
	 * Starts
	 **/

	private static DataBean q07BPointinTimeCountHHLastWednesday(
			BigInteger hhJanTotal, BigInteger hhAprTotal,
			BigInteger hhJulTotal, BigInteger hhOctTotal,
			BigInteger hhCountJanWc, BigInteger hhCountJanWca,
			BigInteger hhCountJanWoc, BigInteger hhCountJanUht,
			BigInteger hhCountAprWc, BigInteger hhCountAprWca,
			BigInteger hhCountAprWoc, BigInteger hhCountAprUht,
			BigInteger hhCountJulWc, BigInteger hhCountJulWca,
			BigInteger hhCountJulWoc, BigInteger hhCountJulUht,
			BigInteger hhCountOctWc, BigInteger hhCountOctWca,
			BigInteger hhCountOctWoc, BigInteger hhCountOctUht,
			DataBean q07BPointinTimeCountHHLastWednesday) {

		q07BPointinTimeCountHHLastWednesday.setHhJanTotal(hhJanTotal);
		q07BPointinTimeCountHHLastWednesday.setHhAprTotal(hhAprTotal);
		q07BPointinTimeCountHHLastWednesday.setHhJulTotal(hhJulTotal);
		q07BPointinTimeCountHHLastWednesday.setHhOctTotal(hhOctTotal);
		q07BPointinTimeCountHHLastWednesday.setHhCountJanWc(hhCountJanWc);
		q07BPointinTimeCountHHLastWednesday.setHhCountJanWca(hhCountJanWca);
		q07BPointinTimeCountHHLastWednesday.setHhCountJanWoc(hhCountJanWoc);
		q07BPointinTimeCountHHLastWednesday.setHhCountJanUht(hhCountJanUht);
		q07BPointinTimeCountHHLastWednesday.setHhCountAprWc(hhCountAprWc);
		q07BPointinTimeCountHHLastWednesday.setHhCountAprWca(hhCountAprWca);
		q07BPointinTimeCountHHLastWednesday.setHhCountAprWoc(hhCountAprWoc);
		q07BPointinTimeCountHHLastWednesday.setHhCountAprUht(hhCountAprUht);
		q07BPointinTimeCountHHLastWednesday.setHhCountJulWc(hhCountJulWc);
		q07BPointinTimeCountHHLastWednesday.setHhCountJulWca(hhCountJulWca);
		q07BPointinTimeCountHHLastWednesday.setHhCountJulWoc(hhCountJulWoc);
		q07BPointinTimeCountHHLastWednesday.setHhCountJulUht(hhCountJulUht);
		q07BPointinTimeCountHHLastWednesday.setHhCountOctWc(hhCountOctWc);
		q07BPointinTimeCountHHLastWednesday.setHhCountOctWca(hhCountOctWca);
		q07BPointinTimeCountHHLastWednesday.setHhCountOctWoc(hhCountOctWoc);
		q07BPointinTimeCountHHLastWednesday.setHhCountOctUht(hhCountOctUht);

		return q07BPointinTimeCountHHLastWednesday;
	}

	/**
	 * "Q09a: Number of Persons Contact" Table -- Starts
	 **/
	private static DataBean q09ANumberOfPersonsContacted(
			BigInteger totContactedOnce, BigInteger totContacted2to5Times,
			BigInteger totContacted6to9Times, BigInteger totContacted10orMore,
			BigInteger totPersonsContacted,
			BigInteger coFirstContactHumanHabitation,
			BigInteger coFirstContactNRSS, BigInteger coFirstContactRSS,
			BigInteger coFirstContactPlaceMissing,
			BigInteger c2to5FirstContactedHumanHabitation,
			BigInteger c2to5FirstContactedNRSS,
			BigInteger c2to5FirstContactedRSS,
			BigInteger c2to5FirstContactedPlaceMissing,
			BigInteger c6to9FirstContactedHumanHabitation,
			BigInteger c6to9FirstContactedNRSS,
			BigInteger c6to9FirstContactedRSS,
			BigInteger c6to9FirstContactedPlaceMissing,
			BigInteger c10orMoreFirstContactedHumanHabitation,
			BigInteger c10orMoreFirstContactedNRSS,
			BigInteger c10orMoreFirstContactedRSS,
			BigInteger c10orMoreFirstContactedPlaceMissing,
			BigInteger tpcFirstContactedHumanHabitation,
			BigInteger tpcFirstContactedNRSS, BigInteger tpcFirstContacteRSS,
			BigInteger tpcFirstContactedPlaceMissing,
			DataBean q09ANumberOfPersonsContacted) {

		q09ANumberOfPersonsContacted.setTotContactedOnce(totContactedOnce);
		q09ANumberOfPersonsContacted
				.setTotContacted2to5Times(totContacted2to5Times);
		q09ANumberOfPersonsContacted
				.setTotContacted6to9Times(totContacted6to9Times);
		q09ANumberOfPersonsContacted
				.setTotContacted10orMore(totContacted10orMore);
		q09ANumberOfPersonsContacted
				.setTotPersonsContacted(totPersonsContacted);
		q09ANumberOfPersonsContacted
				.setCoFirstContactHumanHabitation(coFirstContactHumanHabitation);
		q09ANumberOfPersonsContacted.setCoFirstContactNRSS(coFirstContactNRSS);
		q09ANumberOfPersonsContacted.setCoFirstContactRSS(coFirstContactRSS);
		q09ANumberOfPersonsContacted
				.setCoFirstContactPlaceMissing(coFirstContactPlaceMissing);
		q09ANumberOfPersonsContacted
				.setC2to5FirstContactedHumanHabitation(c2to5FirstContactedHumanHabitation);
		q09ANumberOfPersonsContacted
				.setC2to5FirstContactedNRSS(c2to5FirstContactedNRSS);
		q09ANumberOfPersonsContacted
				.setC2to5FirstContactedRSS(c2to5FirstContactedRSS);
		q09ANumberOfPersonsContacted
				.setC2to5FirstContactedPlaceMissing(c2to5FirstContactedPlaceMissing);
		q09ANumberOfPersonsContacted
				.setC6to9FirstContactedHumanHabitation(c6to9FirstContactedHumanHabitation);
		q09ANumberOfPersonsContacted
				.setC6to9FirstContactedNRSS(c6to9FirstContactedNRSS);
		q09ANumberOfPersonsContacted
				.setC6to9FirstContactedRSS(c6to9FirstContactedRSS);
		q09ANumberOfPersonsContacted
				.setC6to9FirstContactedPlaceMissing(c6to9FirstContactedPlaceMissing);
		q09ANumberOfPersonsContacted
				.setC10orMoreFirstContactedHumanHabitation(c10orMoreFirstContactedHumanHabitation);
		q09ANumberOfPersonsContacted
				.setC10orMoreFirstContactedNRSS(c10orMoreFirstContactedNRSS);
		q09ANumberOfPersonsContacted
				.setC10orMoreFirstContactedRSS(c10orMoreFirstContactedRSS);
		q09ANumberOfPersonsContacted
				.setC10orMoreFirstContactedPlaceMissing(c10orMoreFirstContactedPlaceMissing);
		q09ANumberOfPersonsContacted
				.setTpcFirstContactedHumanHabitation(tpcFirstContactedHumanHabitation);
		q09ANumberOfPersonsContacted
				.setTpcFirstContactedNRSS(tpcFirstContactedNRSS);
		q09ANumberOfPersonsContacted
				.setTpcFirstContacteRSS(tpcFirstContacteRSS);
		q09ANumberOfPersonsContacted
				.setTpcFirstContactedPlaceMissing(tpcFirstContactedPlaceMissing);

		return q09ANumberOfPersonsContacted;
	}

	/**
	 * "Q09b: Number of Persons Engaged" Table -- Starts
	 **/
	private static DataBean q09BNumberOfPersonsEngaged(
			BigInteger totEngagedAfter1Contract,
			BigInteger totEngagedAfter2to5Contract,
			BigInteger totEngagedAfter6to9Contract,
			BigInteger totEngagedAfter10orMoreContract,
			BigInteger totPersonsEngaged, BigInteger totRateOfEngagement,
			BigInteger engFirstContactHumanHabitation,
			BigInteger engFirstContactNRSS, BigInteger engFirstContactRSS,
			BigInteger engFirstContactPlaceMissing,
			BigInteger eng2to5FirstContactHumanHabitation,
			BigInteger eng2to5FirstContactNRSS,
			BigInteger eng2to5FirstContactRSS,
			BigInteger eng2to5FirstContactPlaceMissing,
			BigInteger eng6to9FirstContactHumanHabitation,
			BigInteger eng6to9FirstContactNRSS,
			BigInteger eng6to9FirstContactRSS,
			BigInteger eng6to9FirstContactPlaceMissing,
			BigInteger eng10FirstContactHumanHabitation,
			BigInteger eng10FirstContactNRSS, BigInteger eng10FirstContactRSS,
			BigInteger eng10FirstContactPlaceMissing,
			BigInteger tpeFirstContactHumanHabitation,
			BigInteger tpeFirstContactNRSS, BigInteger tpeFirstContactRSS,
			BigInteger tpeFirstContactPlaceMissing,
			BigInteger roeFirstContactHumanHabitation,
			BigInteger roeFirstContactNRSS, BigInteger roeFirstContactRSS,
			BigInteger roeFirstContactPlaceMissing,
			DataBean q09BNumberOfPersonsEngaged) {

		q09BNumberOfPersonsEngaged
				.setTotEngagedAfter1Contract(totEngagedAfter1Contract);
		q09BNumberOfPersonsEngaged
				.setTotEngagedAfter2to5Contract(totEngagedAfter2to5Contract);
		q09BNumberOfPersonsEngaged
				.setTotEngagedAfter6to9Contract(totEngagedAfter6to9Contract);
		q09BNumberOfPersonsEngaged
				.setTotEngagedAfter10orMoreContract(totEngagedAfter10orMoreContract);
		q09BNumberOfPersonsEngaged.setTotPersonsEngaged(totPersonsEngaged);
		q09BNumberOfPersonsEngaged.setTotRateOfEngagement(totRateOfEngagement);
		q09BNumberOfPersonsEngaged
				.setEngFirstContactHumanHabitation(engFirstContactHumanHabitation);
		q09BNumberOfPersonsEngaged.setEngFirstContactNRSS(engFirstContactNRSS);
		q09BNumberOfPersonsEngaged.setEngFirstContactRSS(engFirstContactRSS);
		q09BNumberOfPersonsEngaged
				.setEngFirstContactPlaceMissing(engFirstContactPlaceMissing);
		q09BNumberOfPersonsEngaged
				.setEng2to5FirstContactHumanHabitation(eng2to5FirstContactHumanHabitation);
		q09BNumberOfPersonsEngaged
				.setEng2to5FirstContactNRSS(eng2to5FirstContactNRSS);
		q09BNumberOfPersonsEngaged
				.setEng2to5FirstContactRSS(eng2to5FirstContactRSS);
		q09BNumberOfPersonsEngaged
				.setEng2to5FirstContactPlaceMissing(eng2to5FirstContactPlaceMissing);
		q09BNumberOfPersonsEngaged
				.setEng6to9FirstContactHumanHabitation(eng6to9FirstContactHumanHabitation);
		q09BNumberOfPersonsEngaged
				.setEng6to9FirstContactNRSS(eng6to9FirstContactNRSS);
		q09BNumberOfPersonsEngaged
				.setEng6to9FirstContactRSS(eng6to9FirstContactRSS);
		q09BNumberOfPersonsEngaged
				.setEng6to9FirstContactPlaceMissing(eng6to9FirstContactPlaceMissing);
		q09BNumberOfPersonsEngaged
				.setEng10FirstContactHumanHabitation(eng10FirstContactHumanHabitation);
		q09BNumberOfPersonsEngaged
				.setEng10FirstContactNRSS(eng10FirstContactNRSS);
		q09BNumberOfPersonsEngaged
				.setEng10FirstContactRSS(eng10FirstContactRSS);
		q09BNumberOfPersonsEngaged
				.setEng10FirstContactPlaceMissing(eng10FirstContactPlaceMissing);
		q09BNumberOfPersonsEngaged
				.setTpeFirstContactHumanHabitation(tpeFirstContactHumanHabitation);
		q09BNumberOfPersonsEngaged.setTpeFirstContactNRSS(tpeFirstContactNRSS);
		q09BNumberOfPersonsEngaged.setTpeFirstContactRSS(tpeFirstContactRSS);
		q09BNumberOfPersonsEngaged
				.setTpeFirstContactPlaceMissing(tpeFirstContactPlaceMissing);
		q09BNumberOfPersonsEngaged
				.setRoeFirstContactHumanHabitation(roeFirstContactHumanHabitation);
		q09BNumberOfPersonsEngaged.setRoeFirstContactNRSS(roeFirstContactNRSS);
		q09BNumberOfPersonsEngaged.setRoeFirstContactRSS(roeFirstContactRSS);
		q09BNumberOfPersonsEngaged
				.setRoeFirstContactPlaceMissing(roeFirstContactPlaceMissing);

		return q09BNumberOfPersonsEngaged;
	}

	/**
	 * "Q10a: Gender of Adults" Table -- Ends
	 **/

	private static DataBean q10AGenderOfAdults(BigInteger totMale,
			BigInteger totFemale, BigInteger totTransgenderMF,
			BigInteger totOther, BigInteger totDontKnowRefused,
			BigInteger totInfoMissing, BigInteger totSubtotal,
			BigInteger maleWOC, BigInteger maleWCA, BigInteger maleUHHT,
			BigInteger femaleWOC, BigInteger femaleWCA, BigInteger femaleUHHT,
			BigInteger transgenderMFWOC, BigInteger transgenderMFWCA,
			BigInteger transgenderMFUHHT, BigInteger otherWOC,
			BigInteger otherWCA, BigInteger otherUHHT, BigInteger dkrWOC,
			BigInteger dkrWCA, BigInteger dkrUHHT, BigInteger infomiisingWOC,
			BigInteger infomiisingWCA, BigInteger infomiisingUHHT,
			BigInteger subtotalWOC, BigInteger subtotalWCA,
			BigInteger subtotalUHHT, BigInteger totTransgenderFM,
			BigInteger transgenderFMWOC, BigInteger transgenderFMWCA,
			BigInteger transgenderFMUHHT, DataBean q10AGenderOfAdults) {

		q10AGenderOfAdults.setTotMale(totMale);
		q10AGenderOfAdults.setTotFemale(totFemale);
		q10AGenderOfAdults.setTotTransgenderMF(totTransgenderMF);
		q10AGenderOfAdults.setTotOther(totOther);
		q10AGenderOfAdults.setTotDontKnowRefused(totDontKnowRefused);
		q10AGenderOfAdults.setTotInfoMissing(totInfoMissing);
		q10AGenderOfAdults.setTotSubtotal(totSubtotal);
		q10AGenderOfAdults.setMaleWOC(maleWOC);
		q10AGenderOfAdults.setMaleWCA(maleWCA);
		q10AGenderOfAdults.setMaleUHHT(maleUHHT);
		q10AGenderOfAdults.setFemaleWOC(femaleWOC);
		q10AGenderOfAdults.setFemaleWCA(femaleWCA);
		q10AGenderOfAdults.setFemaleUHHT(femaleUHHT);
		q10AGenderOfAdults.setTransgenderMFWOC(transgenderMFWOC);
		q10AGenderOfAdults.setTransgenderMFWCA(transgenderMFWCA);
		q10AGenderOfAdults.setTransgenderMFUHHT(transgenderMFUHHT);
		q10AGenderOfAdults.setOtherWOC(otherWOC);
		q10AGenderOfAdults.setOtherWCA(otherWCA);
		q10AGenderOfAdults.setOtherUHHT(otherUHHT);
		q10AGenderOfAdults.setDkrWOC(dkrWOC);
		q10AGenderOfAdults.setDkrWCA(dkrWCA);
		q10AGenderOfAdults.setDkrUHHT(dkrUHHT);
		q10AGenderOfAdults.setInfomiisingWOC(infomiisingWOC);
		q10AGenderOfAdults.setInfomiisingWCA(infomiisingWCA);
		q10AGenderOfAdults.setInfomiisingUHHT(infomiisingUHHT);
		q10AGenderOfAdults.setSubtotalWOC(subtotalWOC);
		q10AGenderOfAdults.setSubtotalWCA(subtotalWCA);
		q10AGenderOfAdults.setSubtotalUHHT(subtotalUHHT);
		q10AGenderOfAdults.setTotTransgenderFM(totTransgenderFM);
		q10AGenderOfAdults.setTransgenderFMWOC(transgenderFMWOC);
		q10AGenderOfAdults.setTransgenderFMWCA(transgenderFMWCA);
		q10AGenderOfAdults.setTransgenderFMUHHT(transgenderFMUHHT);

		return q10AGenderOfAdults;
	}

	/**
	 * "Q10b: Gender of Children" Table -- Starts
	 **/
	private static DataBean q10bGenderOfChildren(BigInteger totChildMale,
			BigInteger totChildFemale, BigInteger totChildTransgenderMF,
			BigInteger totChildOther, BigInteger totChildDontKnowRefused,
			BigInteger totChildInfoMissing, BigInteger totChildSubtotal,
			BigInteger childMaleWOC, BigInteger childMaleWCA,
			BigInteger childMaleUHHT, BigInteger childFemaleWOC,
			BigInteger childFemaleWCA, BigInteger childFemaleUHHT,
			BigInteger childTransgenderMFWOC, BigInteger childTransgenderMFWCA,
			BigInteger childTransgenderMFUHHT, BigInteger childOtherWOC,
			BigInteger childOtherWCA, BigInteger childOtherUHHT,
			BigInteger childDkrWOC, BigInteger childDkrWCA,
			BigInteger childDkrUHHT, BigInteger childInfomiisingWOC,
			BigInteger childInfomiisingWCA, BigInteger childInfomiisingUHHT,
			BigInteger childSubtotalWOC, BigInteger childSubtotalWCA,
			BigInteger childSubtotalUHHT, BigInteger totChildTransgenderFM,
			BigInteger childTransgenderFMWOC, BigInteger childTransgenderFMWCA,
			BigInteger childTransgenderFMUHHT, DataBean q10bGenderOfChildren) {

		q10bGenderOfChildren.setTotChildMale(totChildMale);
		q10bGenderOfChildren.setTotChildFemale(totChildFemale);
		q10bGenderOfChildren.setTotChildTransgenderMF(totChildTransgenderMF);
		q10bGenderOfChildren.setTotChildOther(totChildOther);
		q10bGenderOfChildren
				.setTotChildDontKnowRefused(totChildDontKnowRefused);
		q10bGenderOfChildren.setTotChildInfoMissing(totChildInfoMissing);
		q10bGenderOfChildren.setTotChildSubtotal(totChildSubtotal);
		q10bGenderOfChildren.setChildMaleWOC(childMaleWOC);
		q10bGenderOfChildren.setChildMaleWCA(childMaleWCA);
		q10bGenderOfChildren.setChildMaleUHHT(childMaleUHHT);
		q10bGenderOfChildren.setChildFemaleWOC(childFemaleWOC);
		q10bGenderOfChildren.setChildFemaleWCA(childFemaleWCA);
		q10bGenderOfChildren.setChildFemaleUHHT(childFemaleUHHT);
		q10bGenderOfChildren.setChildTransgenderMFWOC(childTransgenderMFWOC);
		q10bGenderOfChildren.setChildTransgenderMFWCA(childTransgenderMFWCA);
		q10bGenderOfChildren.setChildTransgenderMFUHHT(childTransgenderMFUHHT);
		q10bGenderOfChildren.setChildOtherWOC(childOtherWOC);
		q10bGenderOfChildren.setChildOtherWCA(childOtherWCA);
		q10bGenderOfChildren.setChildOtherUHHT(childOtherUHHT);
		q10bGenderOfChildren.setChildDkrWOC(childDkrWOC);
		q10bGenderOfChildren.setChildDkrWCA(childDkrWCA);
		q10bGenderOfChildren.setChildDkrUHHT(childDkrUHHT);
		q10bGenderOfChildren.setChildInfomiisingWOC(childInfomiisingWOC);
		q10bGenderOfChildren.setChildInfomiisingWCA(childInfomiisingWCA);
		q10bGenderOfChildren.setChildInfomiisingUHHT(childInfomiisingUHHT);
		q10bGenderOfChildren.setChildSubtotalWOC(childSubtotalWOC);
		q10bGenderOfChildren.setChildSubtotalWCA(childSubtotalWCA);
		q10bGenderOfChildren.setChildSubtotalUHHT(childSubtotalUHHT);
		q10bGenderOfChildren.setTotChildTransgenderFM(totChildTransgenderFM);
		q10bGenderOfChildren.setChildTransgenderFMWOC(childTransgenderFMWOC);
		q10bGenderOfChildren.setChildTransgenderFMWCA(childTransgenderFMWCA);
		q10bGenderOfChildren.setChildTransgenderFMUHHT(childTransgenderFMUHHT);
		return q10bGenderOfChildren;

	}

	/**
	 * "Q10c: Gender of Persons Missing Age Information" Table -- Starts
	 */
	private static DataBean q10CGPMI(BigInteger totMAIMale,
			BigInteger totMAIFemale, BigInteger totMAITransgenderMF,
			BigInteger totMAIOther, BigInteger totMAIDontKnowRefused,
			BigInteger totMAIInfoMissing, BigInteger totMAISubtotal,
			BigInteger maleMAIWOC, BigInteger maleMAIWCA,
			BigInteger maleMAIUHHT, BigInteger femaleMAIWOC,
			BigInteger femaleMAIWCA, BigInteger femaleMAIUHHT,
			BigInteger transgenderMFMAIWOC, BigInteger transgenderMFMAIWCA,
			BigInteger transgenderMFMAIUHHT, BigInteger otherMAIWOC,
			BigInteger otherMAIWCA, BigInteger otherMAIUHHT,
			BigInteger dkrMAIWOC, BigInteger dkrMAIWCA, BigInteger dkrMAIUHHT,
			BigInteger infomissingMAIWOC, BigInteger infomissingMAIWCA,
			BigInteger infomissingMAIUHHT, BigInteger subtotalMAIWOC,
			BigInteger subtotalMAIWCA, BigInteger subtotalMAIUHHT,
			BigInteger totMAITransgenderFM, BigInteger transgenderFMMAIWOC,
			BigInteger transgenderFMMAIWCA, BigInteger transgenderFMMAIUHHT,
			BigInteger transgenderFMMAIWithOnlyChild,
			BigInteger subtotalMAIWithOnlyChild,
			BigInteger infomissingMAIWithOnlyChild,
			BigInteger dkrMAIWithOnlyChild,
			BigInteger transgenderMFMAIWithOnlyChild,
			BigInteger otherMAIWithOnlyChild, BigInteger maleMAIWithOnlyChild,
			BigInteger femaleMAIWithOnlyChild,
			DataBean q10cGenderofPersonsMissingAgeInformation) {

		q10cGenderofPersonsMissingAgeInformation.setTotMAIMale(totMAIMale);
		q10cGenderofPersonsMissingAgeInformation.setTotMAIFemale(totMAIFemale);
		q10cGenderofPersonsMissingAgeInformation
				.setTotMAITransgenderMF(totMAITransgenderMF);
		q10cGenderofPersonsMissingAgeInformation.setTotMAIOther(totMAIOther);
		q10cGenderofPersonsMissingAgeInformation
				.setTotMAIDontKnowRefused(totMAIDontKnowRefused);
		q10cGenderofPersonsMissingAgeInformation
				.setTotMAIInfoMissing(totMAIInfoMissing);
		q10cGenderofPersonsMissingAgeInformation
				.setTotMAISubtotal(totMAISubtotal);
		q10cGenderofPersonsMissingAgeInformation.setMaleMAIWOC(maleMAIWOC);
		q10cGenderofPersonsMissingAgeInformation.setMaleMAIWCA(maleMAIWCA);
		q10cGenderofPersonsMissingAgeInformation.setMaleMAIUHHT(maleMAIUHHT);
		q10cGenderofPersonsMissingAgeInformation.setFemaleMAIWOC(femaleMAIWOC);
		q10cGenderofPersonsMissingAgeInformation.setFemaleMAIWCA(femaleMAIWCA);
		q10cGenderofPersonsMissingAgeInformation
				.setFemaleMAIUHHT(femaleMAIUHHT);
		q10cGenderofPersonsMissingAgeInformation
				.setTransgenderMFMAIWOC(transgenderMFMAIWOC);
		q10cGenderofPersonsMissingAgeInformation
				.setTransgenderMFMAIWCA(transgenderMFMAIWCA);
		q10cGenderofPersonsMissingAgeInformation
				.setTransgenderMFMAIUHHT(transgenderMFMAIUHHT);
		q10cGenderofPersonsMissingAgeInformation.setOtherMAIWOC(otherMAIWOC);
		q10cGenderofPersonsMissingAgeInformation.setOtherMAIWCA(otherMAIWCA);
		q10cGenderofPersonsMissingAgeInformation.setOtherMAIUHHT(otherMAIUHHT);
		q10cGenderofPersonsMissingAgeInformation.setDkrMAIWOC(dkrMAIWOC);
		q10cGenderofPersonsMissingAgeInformation.setDkrMAIWCA(dkrMAIWCA);
		q10cGenderofPersonsMissingAgeInformation.setDkrMAIUHHT(dkrMAIUHHT);
		q10cGenderofPersonsMissingAgeInformation
				.setInfomissingMAIWOC(infomissingMAIWOC);
		q10cGenderofPersonsMissingAgeInformation
				.setInfomissingMAIWCA(infomissingMAIWCA);
		q10cGenderofPersonsMissingAgeInformation
				.setInfomissingMAIUHHT(infomissingMAIUHHT);
		q10cGenderofPersonsMissingAgeInformation
				.setSubtotalMAIWOC(subtotalMAIWOC);
		q10cGenderofPersonsMissingAgeInformation
				.setSubtotalMAIWCA(subtotalMAIWCA);
		q10cGenderofPersonsMissingAgeInformation
				.setSubtotalMAIUHHT(subtotalMAIUHHT);
		q10cGenderofPersonsMissingAgeInformation
				.setTotMAITransgenderFM(totMAITransgenderFM);
		q10cGenderofPersonsMissingAgeInformation
				.setTransgenderFMMAIWOC(transgenderFMMAIWOC);
		q10cGenderofPersonsMissingAgeInformation
				.setTransgenderFMMAIWCA(transgenderFMMAIWCA);
		q10cGenderofPersonsMissingAgeInformation
				.setTransgenderFMMAIUHHT(transgenderFMMAIUHHT);
		q10cGenderofPersonsMissingAgeInformation
				.setTransgenderFMMAIWithOnlyChild(transgenderFMMAIWithOnlyChild);
		q10cGenderofPersonsMissingAgeInformation
				.setSubtotalMAIWithOnlyChild(subtotalMAIWithOnlyChild);
		q10cGenderofPersonsMissingAgeInformation
				.setInfomissingMAIWithOnlyChild(infomissingMAIWithOnlyChild);
		q10cGenderofPersonsMissingAgeInformation
				.setDkrMAIWithOnlyChild(dkrMAIWithOnlyChild);
		q10cGenderofPersonsMissingAgeInformation
				.setTransgenderMFMAIWithOnlyChild(transgenderMFMAIWithOnlyChild);
		q10cGenderofPersonsMissingAgeInformation
				.setOtherMAIWithOnlyChild(otherMAIWithOnlyChild);
		q10cGenderofPersonsMissingAgeInformation
				.setMaleMAIWithOnlyChild(maleMAIWithOnlyChild);
		q10cGenderofPersonsMissingAgeInformation
				.setFemaleMAIWithOnlyChild(femaleMAIWithOnlyChild);

		return q10cGenderofPersonsMissingAgeInformation;

	}

	/**
	 * "Q10c: Gender of Persons Missing Age Information" Table -- Ends
	 */

	/**
	 * "Q11: Age" Table -- Starts
	 */
	private static DataBean q11AgeTableBean(BigInteger totAgeUnder5,
			BigInteger totAge5to12, BigInteger totAge13to17,
			BigInteger totAge18to24, BigInteger totAge25to34,
			BigInteger totAge35to44, BigInteger totAge45to54,
			BigInteger totAge55to61, BigInteger totAge62Plus,
			BigInteger totAgeDKR, BigInteger totAgeInfoMissing,
			BigInteger totOverallTotal, BigInteger ageUnder5WOC,
			BigInteger ageUnder5WCA, BigInteger ageUnder5WithOnlyChild,
			BigInteger ageUnder5UHHT, BigInteger age5to12woc,
			BigInteger age5to12wca, BigInteger age5to12WithOnlyChild,
			BigInteger age5to12uhht, BigInteger age13to17woc,
			BigInteger age13to17wca, BigInteger age13to17WithOnlyChild,
			BigInteger age13to17uhht, BigInteger age18to24woc,
			BigInteger age18to24wca, BigInteger age18to24WithOnlyChild,
			BigInteger age18to24uhht, BigInteger age25to34woc,
			BigInteger age25to34wca, BigInteger age25to34WithOnlyChild,
			BigInteger age25to34uhht, BigInteger age35to44woc,
			BigInteger age35to44wca, BigInteger age35to44WithOnlyChild,
			BigInteger age35to44uhht, BigInteger age45to54woc,
			BigInteger age45to54wca, BigInteger age45to54WithOnlyChild,
			BigInteger age45to54uhht, BigInteger age55to61woc,
			BigInteger age55to61wca, BigInteger age55to61WithOnlyChild,
			BigInteger age55to61uhht, BigInteger age62PlusWOC,
			BigInteger age62PlusWCA, BigInteger age62PlusWithOnlyChild,
			BigInteger age62PlusUHHT, BigInteger ageDKRWOC,
			BigInteger ageDKRWCA, BigInteger ageDKRWithOnlyChild,
			BigInteger ageDKRUHHT, BigInteger ageInfoMissingWOC,
			BigInteger ageInfoMissingWCA,
			BigInteger ageInfoMissingWithOnlyChild,
			BigInteger ageInfoMissingUHHT, BigInteger ageOverallTotalWOC,
			BigInteger ageOverallTotalWCA,
			BigInteger ageOverallTotalWithOnlyChild,
			BigInteger ageOverallTotalUHHT, DataBean q11AgeTableBean) {

		q11AgeTableBean.setAge13to17UHHT(age13to17uhht);
		q11AgeTableBean.setAge13to17WCA(age13to17wca);
		q11AgeTableBean.setAge13to17WithOnlyChild(age13to17WithOnlyChild);
		q11AgeTableBean.setAge13to17WOC(age13to17woc);
		q11AgeTableBean.setAge18to24UHHT(age18to24uhht);
		q11AgeTableBean.setAge18to24WCA(age18to24wca);
		q11AgeTableBean.setAge18to24WithOnlyChild(age18to24WithOnlyChild);
		q11AgeTableBean.setAge18to24WOC(age18to24woc);
		q11AgeTableBean.setAge25to34UHHT(age25to34uhht);
		q11AgeTableBean.setAge25to34WCA(age25to34wca);
		q11AgeTableBean.setAge25to34WithOnlyChild(age25to34WithOnlyChild);
		q11AgeTableBean.setAge25to34WOC(age25to34woc);
		q11AgeTableBean.setAge35to44UHHT(age35to44uhht);
		q11AgeTableBean.setAge35to44WCA(age35to44wca);
		q11AgeTableBean.setAge35to44WithOnlyChild(age35to44WithOnlyChild);
		q11AgeTableBean.setAge35to44WOC(age35to44woc);
		q11AgeTableBean.setAge45to54UHHT(age45to54uhht);
		q11AgeTableBean.setAge45to54WCA(age45to54wca);
		q11AgeTableBean.setAge45to54WithOnlyChild(age45to54WithOnlyChild);
		q11AgeTableBean.setAge45to54WOC(age45to54woc);
		q11AgeTableBean.setAge55to61UHHT(age55to61uhht);
		q11AgeTableBean.setAge55to61WCA(age55to61wca);
		q11AgeTableBean.setAge55to61WithOnlyChild(age55to61WithOnlyChild);
		q11AgeTableBean.setAge55to61WOC(age55to61woc);
		q11AgeTableBean.setAge62PlusUHHT(age62PlusUHHT);
		q11AgeTableBean.setAge62PlusWCA(age62PlusWCA);
		q11AgeTableBean.setAge62PlusWithOnlyChild(age62PlusWithOnlyChild);
		q11AgeTableBean.setAge62PlusWOC(age62PlusWOC);
		q11AgeTableBean.setAgeDKRUHHT(ageDKRUHHT);
		q11AgeTableBean.setAgeDKRWCA(ageDKRWCA);
		q11AgeTableBean.setAgeDKRWithOnlyChild(ageDKRWithOnlyChild);
		q11AgeTableBean.setAgeDKRWOC(ageDKRWOC);
		q11AgeTableBean.setAgeInfoMissingUHHT(ageInfoMissingUHHT);
		q11AgeTableBean.setAgeInfoMissingWCA(ageInfoMissingWCA);
		q11AgeTableBean
				.setAgeInfoMissingWithOnlyChild(ageInfoMissingWithOnlyChild);
		q11AgeTableBean.setAgeInfoMissingWOC(ageInfoMissingWOC);
		q11AgeTableBean.setAgeUnder5UHHT(ageUnder5UHHT);
		q11AgeTableBean.setAgeUnder5WCA(ageUnder5WCA);
		q11AgeTableBean.setAgeUnder5WithOnlyChild(ageUnder5WithOnlyChild);
		q11AgeTableBean.setAgeUnder5WOC(ageUnder5WOC);
		q11AgeTableBean.setAgeOverallTotalUHHT(ageOverallTotalUHHT);
		q11AgeTableBean.setAgeOverallTotalWCA(ageOverallTotalWCA);
		q11AgeTableBean
				.setAgeOverallTotalWithOnlyChild(ageOverallTotalWithOnlyChild);
		q11AgeTableBean.setAgeOverallTotalWOC(ageOverallTotalWOC);
		q11AgeTableBean.setTotOverallTotal(totOverallTotal);
		q11AgeTableBean.setTotAge13to17(totAge13to17);
		q11AgeTableBean.setTotAge18to24(totAge18to24);
		q11AgeTableBean.setTotAge25to34(totAge25to34);
		q11AgeTableBean.setTotAge35to44(totAge35to44);
		q11AgeTableBean.setTotAge45to54(totAge45to54);
		q11AgeTableBean.setTotAge55to61(totAge55to61);
		q11AgeTableBean.setTotAge5to12(totAge5to12);
		q11AgeTableBean.setTotAge62Plus(totAge62Plus);
		q11AgeTableBean.setTotAgeDKR(totAgeDKR);
		q11AgeTableBean.setTotAgeInfoMissing(totAgeInfoMissing);
		q11AgeTableBean.setTotAgeUnder5(totAgeUnder5);
		q11AgeTableBean.setTotOverallTotal(totOverallTotal);
		q11AgeTableBean.setAge5to12UHHT(age5to12uhht);
		q11AgeTableBean.setAge5to12WCA(age5to12wca);
		q11AgeTableBean.setAge5to12WithOnlyChild(age5to12WithOnlyChild);
		q11AgeTableBean.setAge5to12WOC(age5to12woc);

		return q11AgeTableBean;
	}

	/**
	 * "Q11: Age" Table -- Ends
	 */

	/**
	 * "Q12a: Race" Table -- Starts
	 */
	private static DataBean q12aRaceTableBean(BigInteger q12aWhiteTotal,
			BigInteger q12aWhiteWithoutChildren,
			BigInteger q12aWhiteWithChildrenAndAdults,
			BigInteger q12aWhiteWithOnlyChildren,
			BigInteger q12aWhiteWithUnkownhouseholdtype,
			BigInteger q12aBlckAfrnAmrnTotal,
			BigInteger q12aBlckAfrnAmrnWithoutChildren,
			BigInteger q12aBlckAfrnAmrnWithChildrenAndAdults,
			BigInteger q12aBlckAfrnAmrnWithOnlyChildren,
			BigInteger q12aBlckAfrnAmrnWithUnkownhouseholdtype,
			BigInteger q12aAsianTotal, BigInteger q12aAsianWithoutChildren,
			BigInteger q12aAsianWithChildrenAndAdults,
			BigInteger q12aAsianWithOnlyChildren,
			BigInteger q12aAsianUnkownhouseholdtype,
			BigInteger q12aAmericanIndianTotal,
			BigInteger q12aAmericanIndianWithoutChildren,
			BigInteger q12aAmericanIndianWithChildrenAndAdults,
			BigInteger q12aAmericanIndianWithOnlyChildren,
			BigInteger q12aAmericanIndianUnkownhouseholdtype,
			BigInteger q12aNativeHawalianTotal,
			BigInteger q12aNativeHawalianWithoutChildren,
			BigInteger q12aNativeHawalianWithChildrenAndAdults,
			BigInteger q12aNativeHawalianWithOnlyChildren,
			BigInteger q12aNativeHawalianUnkownhouseholdtype,
			BigInteger q12aMultipleRacesTotal,
			BigInteger q12aMultipleRacesWithoutChildren,
			BigInteger q12aMultipleRacesWithChildrenAndAdults,
			BigInteger q12aMultipleRacesWithOnlyChildren,
			BigInteger q12aMultipleRacesUnkownhouseholdtype,
			BigInteger q12aDontKnowRacesTotal,
			BigInteger q12aDontKnowRacesWithoutChildren,
			BigInteger q12aDontKnowRacesWithChildrenAndAdults,
			BigInteger q12aDontKnowRacesWithOnlyChildren,
			BigInteger q12aDontKnowRacesUnkownhouseholdtype,
			BigInteger q12aInformationMissingTotal,
			BigInteger q12aInformationMissingWithoutChildren,
			BigInteger q12aInformationMissingWithChildrenAndAdults,
			BigInteger q12aInformationMissingWithOnlyChildren,
			BigInteger q12aInformationMissingUnkownhouseholdtype,
			BigInteger q12aTotalSummed, BigInteger q12aTotalWithoutChildren,
			BigInteger q12aTotalWithChildrenAndAdults,
			BigInteger q12aTotalWithOnlyChildren,
			BigInteger q12aTotalUnkownhouseholdtype, DataBean q12aRaceTableBean) {

		q12aRaceTableBean.setQ12aWhiteTotal(q12aWhiteTotal);
		q12aRaceTableBean
				.setQ12aWhiteWithChildrenAndAdults(q12aWhiteWithChildrenAndAdults);
		q12aRaceTableBean
				.setQ12aWhiteWithOnlyChildren(q12aWhiteWithOnlyChildren);
		q12aRaceTableBean.setQ12aWhiteWithoutChildren(q12aWhiteWithoutChildren);
		q12aRaceTableBean
				.setQ12aWhiteWithUnkownhouseholdtype(q12aWhiteWithUnkownhouseholdtype);

		q12aRaceTableBean.setQ12aBlckAfrnAmrnTotal(q12aBlckAfrnAmrnTotal);
		q12aRaceTableBean
				.setQ12aBlckAfrnAmrnWithChildrenAndAdults(q12aBlckAfrnAmrnWithChildrenAndAdults);
		q12aRaceTableBean
				.setQ12aBlckAfrnAmrnWithOnlyChildren(q12aBlckAfrnAmrnWithOnlyChildren);
		q12aRaceTableBean
				.setQ12aBlckAfrnAmrnWithoutChildren(q12aBlckAfrnAmrnWithoutChildren);
		q12aRaceTableBean
				.setQ12aBlckAfrnAmrnWithUnkownhouseholdtype(q12aBlckAfrnAmrnWithUnkownhouseholdtype);

		q12aRaceTableBean.setQ12aAsianTotal(q12aAsianTotal);
		q12aRaceTableBean
				.setQ12aAsianUnkownhouseholdtype(q12aAsianUnkownhouseholdtype);
		q12aRaceTableBean
				.setQ12aAsianWithChildrenAndAdults(q12aAsianWithChildrenAndAdults);
		q12aRaceTableBean
				.setQ12aAsianWithOnlyChildren(q12aAsianWithOnlyChildren);
		q12aRaceTableBean.setQ12aAsianWithoutChildren(q12aAsianWithoutChildren);

		q12aRaceTableBean.setQ12aAmericanIndianTotal(q12aAmericanIndianTotal);
		q12aRaceTableBean
				.setQ12aAmericanIndianUnkownhouseholdtype(q12aAmericanIndianUnkownhouseholdtype);
		q12aRaceTableBean
				.setQ12aAmericanIndianWithChildrenAndAdults(q12aAmericanIndianWithChildrenAndAdults);
		q12aRaceTableBean
				.setQ12aAmericanIndianWithOnlyChildren(q12aAmericanIndianWithOnlyChildren);
		q12aRaceTableBean
				.setQ12aAmericanIndianWithoutChildren(q12aAmericanIndianWithoutChildren);

		q12aRaceTableBean.setQ12aNativeHawalianTotal(q12aNativeHawalianTotal);
		q12aRaceTableBean
				.setQ12aNativeHawalianUnkownhouseholdtype(q12aNativeHawalianUnkownhouseholdtype);
		q12aRaceTableBean
				.setQ12aNativeHawalianWithChildrenAndAdults(q12aNativeHawalianWithChildrenAndAdults);
		q12aRaceTableBean
				.setQ12aNativeHawalianWithOnlyChildren(q12aNativeHawalianWithOnlyChildren);
		q12aRaceTableBean
				.setQ12aNativeHawalianWithoutChildren(q12aNativeHawalianWithoutChildren);

		q12aRaceTableBean.setQ12aMultipleRacesTotal(q12aMultipleRacesTotal);
		q12aRaceTableBean
				.setQ12aMultipleRacesUnkownhouseholdtype(q12aMultipleRacesUnkownhouseholdtype);
		q12aRaceTableBean
				.setQ12aMultipleRacesWithChildrenAndAdults(q12aMultipleRacesWithChildrenAndAdults);
		q12aRaceTableBean
				.setQ12aMultipleRacesWithOnlyChildren(q12aMultipleRacesWithOnlyChildren);
		q12aRaceTableBean
				.setQ12aMultipleRacesWithoutChildren(q12aMultipleRacesWithoutChildren);

		q12aRaceTableBean.setQ12aDontKnowRacesTotal(q12aDontKnowRacesTotal);
		q12aRaceTableBean
				.setQ12aDontKnowRacesUnkownhouseholdtype(q12aDontKnowRacesUnkownhouseholdtype);
		q12aRaceTableBean
				.setQ12aDontKnowRacesWithChildrenAndAdults(q12aDontKnowRacesWithChildrenAndAdults);
		q12aRaceTableBean
				.setQ12aDontKnowRacesWithOnlyChildren(q12aDontKnowRacesWithOnlyChildren);
		q12aRaceTableBean
				.setQ12aDontKnowRacesWithoutChildren(q12aDontKnowRacesWithoutChildren);

		q12aRaceTableBean
				.setQ12aInformationMissingTotal(q12aInformationMissingTotal);
		q12aRaceTableBean
				.setQ12aInformationMissingUnkownhouseholdtype(q12aInformationMissingUnkownhouseholdtype);
		q12aRaceTableBean
				.setQ12aInformationMissingWithChildrenAndAdults(q12aInformationMissingWithChildrenAndAdults);
		q12aRaceTableBean
				.setQ12aInformationMissingWithOnlyChildren(q12aInformationMissingWithOnlyChildren);
		q12aRaceTableBean
				.setQ12aInformationMissingWithoutChildren(q12aInformationMissingWithoutChildren);

		q12aRaceTableBean.setQ12aTotalSummed(q12aTotalSummed);
		q12aRaceTableBean
				.setQ12aTotalUnkownhouseholdtype(q12aTotalUnkownhouseholdtype);
		q12aRaceTableBean
				.setQ12aTotalWithChildrenAndAdults(q12aTotalWithChildrenAndAdults);
		q12aRaceTableBean
				.setQ12aTotalWithOnlyChildren(q12aTotalWithOnlyChildren);
		q12aRaceTableBean.setQ12aTotalWithoutChildren(q12aTotalWithoutChildren);

		return q12aRaceTableBean;
	}

	/**
	 * "Q12a: Race" Table -- Ends
	 */

	public static DataBean q12bEthnicityTableBean(
			BigInteger q12bNonHispanicTotal,
			BigInteger q12bNonHispanicWithoutChildren,
			BigInteger q12bNonHispanicWithChildrenAndAdults,
			BigInteger q12bNonHispanicWithOnlyChildren,
			BigInteger q12bNonHispanicUnknownhouseholdtype,
			BigInteger q12bHispanicTotal,
			BigInteger q12bHispanicWithoutChildren,
			BigInteger q12bHispanicWithChildrenAndAdults,
			BigInteger q12bHispanicWithOnlyChildren,
			BigInteger q12bHispanicUnknownhouseholdtype,
			BigInteger q12bDontKnowRacesTotal,
			BigInteger q12bDontKnowRacesWithoutChildren,
			BigInteger q12bDontKnowRacesWithChildrenAndAdults,
			BigInteger q12bDontKnowRacesWithOnlyChildren,
			BigInteger q12bDontKnowRacesUnkownhouseholdtype,
			BigInteger q12bInformationMissingTotal,
			BigInteger q12bInformationMissingWithoutChildren,
			BigInteger q12bInformationMissingWithChildrenAndAdults,
			BigInteger q12bInformationMissingWithOnlyChildren,
			BigInteger q12bInformationMissingUnkownhouseholdtype,
			BigInteger q12bTotalSummed, BigInteger q12bTotalWithoutChildren,
			BigInteger q12bTotalWithChildrenAndAdults,
			BigInteger q12bTotalWithOnlyChildren,
			BigInteger q12bTotalUnkownhouseholdtype,
			DataBean q12bEthnicityTableBean) {

		q12bEthnicityTableBean.setQ12bNonHispanicTotal(q12bNonHispanicTotal);
		q12bEthnicityTableBean
				.setQ12bNonHispanicWithoutChildren(q12bNonHispanicWithoutChildren);
		q12bEthnicityTableBean
				.setQ12bNonHispanicWithChildrenAndAdults(q12bNonHispanicWithChildrenAndAdults);
		q12bEthnicityTableBean
				.setQ12bNonHispanicWithOnlyChildren(q12bNonHispanicWithOnlyChildren);
		q12bEthnicityTableBean
				.setQ12bNonHispanicUnknownhouseholdtype(q12bNonHispanicUnknownhouseholdtype);

		q12bEthnicityTableBean.setQ12bHispanicTotal(q12bHispanicTotal);
		q12bEthnicityTableBean
				.setQ12bHispanicWithoutChildren(q12bHispanicWithoutChildren);
		q12bEthnicityTableBean
				.setQ12bHispanicWithChildrenAndAdults(q12bHispanicWithChildrenAndAdults);
		q12bEthnicityTableBean
				.setQ12bHispanicWithOnlyChildren(q12bHispanicWithOnlyChildren);
		q12bEthnicityTableBean
				.setQ12bHispanicUnknownhouseholdtype(q12bHispanicUnknownhouseholdtype);

		q12bEthnicityTableBean
				.setQ12bDontKnowRacesTotal(q12bDontKnowRacesTotal);
		q12bEthnicityTableBean
				.setQ12bDontKnowRacesWithoutChildren(q12bDontKnowRacesWithoutChildren);
		q12bEthnicityTableBean
				.setQ12bDontKnowRacesWithChildrenAndAdults(q12bDontKnowRacesWithChildrenAndAdults);
		q12bEthnicityTableBean
				.setQ12bDontKnowRacesWithOnlyChildren(q12bDontKnowRacesWithOnlyChildren);
		q12bEthnicityTableBean
				.setQ12bDontKnowRacesUnkownhouseholdtype(q12bDontKnowRacesUnkownhouseholdtype);

		q12bEthnicityTableBean
				.setQ12bInformationMissingTotal(q12bInformationMissingTotal);
		q12bEthnicityTableBean
				.setQ12bInformationMissingWithoutChildren(q12bInformationMissingWithoutChildren);
		q12bEthnicityTableBean
				.setQ12bInformationMissingWithChildrenAndAdults(q12bInformationMissingWithChildrenAndAdults);
		q12bEthnicityTableBean
				.setQ12bInformationMissingWithOnlyChildren(q12bInformationMissingWithOnlyChildren);
		q12bEthnicityTableBean
				.setQ12bInformationMissingUnkownhouseholdtype(q12bInformationMissingUnkownhouseholdtype);

		q12bEthnicityTableBean.setQ12bTotalSummed(q12bTotalSummed);
		q12bEthnicityTableBean
				.setQ12bTotalWithoutChildren(q12bTotalWithoutChildren);
		q12bEthnicityTableBean
				.setQ12bTotalWithChildrenAndAdults(q12bTotalWithChildrenAndAdults);
		q12bEthnicityTableBean
				.setQ12bTotalWithOnlyChildren(q12bTotalWithOnlyChildren);
		q12bEthnicityTableBean
				.setQ12bTotalUnkownhouseholdtype(q12bTotalUnkownhouseholdtype);

		return q12bEthnicityTableBean;
	}

	/**
	 * "Q13a1: Physical and Mental Health Conditions at Entry" Table -- Starts
	 * */
	public static DataBean q13a1PhysicalMntlHealthCondTableBean(
			BigInteger q13a1MentalIllnessTotal,
			BigInteger q13a1MentalIllnessWithoutChildren,
			BigInteger q13a1MentalIllnessWithChildAndAdults,
			BigInteger q13a1MentalIllnessWithOnlychildren,
			BigInteger q13a1MentalIllnessUnknowHousehold,
			BigInteger q13a1AlcoholAbuseTotal,
			BigInteger q13a1AlcoholAbuseWithoutChildren,
			BigInteger q13a1AlcoholAbuseWithChildAndAdults,
			BigInteger q13a1AlcoholAbuseWithOnlychildren,
			BigInteger q13a1AlcoholAbuseUnknowHousehold,
			BigInteger q13a1DrugAbuseTotal,
			BigInteger q13a1DrugAbuseWithoutChildren,
			BigInteger q13a1DrugAbuseWithChildAndAdults,
			BigInteger q13a1DrugAbuseWithOnlychildren,
			BigInteger q13a1DrugAbuseUnknowHousehold,
			BigInteger q13a1BothAlcoholAndDrugAbuseTotal,
			BigInteger q13a1BothAlcoholAndDrugAbuseWithoutChildren,
			BigInteger q13a1BothAlcoholAndDrugAbuseWithChildAndAdults,
			BigInteger q13a1BothAlcoholAndDrugAbuseWithOnlychildren,
			BigInteger q13a1BothAlcoholAndDrugAbuseUnknowHousehold,
			BigInteger q13a1ChronicHealthConditionTotal,
			BigInteger q13a1ChronicHealthConditionWithoutChildren,
			BigInteger q13a1ChronicHealthConditionWithChildAndAdults,
			BigInteger q13a1ChronicHealthConditionWithOnlychildren,
			BigInteger q13a1ChronicHealthConditionUnknowHousehold,
			BigInteger q13a1HIVRelatedDiseasesTotal,
			BigInteger q13a1HIVRelatedDiseasesWithoutChildren,
			BigInteger q13a1HIVRelatedDiseasesWithChildAndAdults,
			BigInteger q13a1HIVRelatedDiseasesWithOnlychildren,
			BigInteger q13a1HIVRelatedDiseasesUnknowHousehold,
			BigInteger q13a1DevelopmentalDisabilityTotal,
			BigInteger q13a1DevelopmentalDisabilityWithoutChildren,
			BigInteger q13a1DevelopmentalDisabilityWithChildAndAdults,
			BigInteger q13a1DevelopmentalDisabilityWithOnlychildren,
			BigInteger q13a1DevelopmentalDisabilityUnknowHousehold,
			BigInteger q13a1PhysicalDisabilityTotal,
			BigInteger q13a1PhysicalDisabilityWithoutChildren,
			BigInteger q13a1PhysicalDisabilityWithChildAndAdults,
			BigInteger q13a1PhysicalDisabilityWithOnlychildren,
			BigInteger q13a1PhysicalDisabilityUnknowHousehold,
			DataBean q13a1PhysicalMntlHealthCondTableBean) {

		q13a1PhysicalMntlHealthCondTableBean
				.setQ13a1MentalIllnessTotal(q13a1MentalIllnessTotal);
		q13a1PhysicalMntlHealthCondTableBean
				.setQ13a1MentalIllnessWithoutChildren(q13a1MentalIllnessWithoutChildren);
		q13a1PhysicalMntlHealthCondTableBean
				.setQ13a1MentalIllnessWithChildAndAdults(q13a1MentalIllnessWithChildAndAdults);
		q13a1PhysicalMntlHealthCondTableBean
				.setQ13a1MentalIllnessWithOnlychildren(q13a1MentalIllnessWithOnlychildren);
		q13a1PhysicalMntlHealthCondTableBean
				.setQ13a1MentalIllnessUnknowHousehold(q13a1MentalIllnessUnknowHousehold);

		q13a1PhysicalMntlHealthCondTableBean
				.setQ13a1AlcoholAbuseTotal(q13a1AlcoholAbuseTotal);
		q13a1PhysicalMntlHealthCondTableBean
				.setQ13a1AlcoholAbuseWithoutChildren(q13a1AlcoholAbuseWithoutChildren);
		q13a1PhysicalMntlHealthCondTableBean
				.setQ13a1AlcoholAbuseWithChildAndAdults(q13a1AlcoholAbuseWithChildAndAdults);
		q13a1PhysicalMntlHealthCondTableBean
				.setQ13a1AlcoholAbuseWithOnlychildren(q13a1AlcoholAbuseWithOnlychildren);
		q13a1PhysicalMntlHealthCondTableBean
				.setQ13a1AlcoholAbuseUnknowHousehold(q13a1AlcoholAbuseUnknowHousehold);

		q13a1PhysicalMntlHealthCondTableBean
				.setQ13a1DrugAbuseTotal(q13a1DrugAbuseTotal);
		q13a1PhysicalMntlHealthCondTableBean
				.setQ13a1DrugAbuseWithoutChildren(q13a1DrugAbuseWithoutChildren);
		q13a1PhysicalMntlHealthCondTableBean
				.setQ13a1DrugAbuseWithChildAndAdults(q13a1DrugAbuseWithChildAndAdults);
		q13a1PhysicalMntlHealthCondTableBean
				.setQ13a1DrugAbuseWithOnlychildren(q13a1DrugAbuseWithOnlychildren);
		q13a1PhysicalMntlHealthCondTableBean
				.setQ13a1DrugAbuseUnknowHousehold(q13a1DrugAbuseUnknowHousehold);

		q13a1PhysicalMntlHealthCondTableBean
				.setQ13a1BothAlcoholAndDrugAbuseTotal(q13a1BothAlcoholAndDrugAbuseTotal);
		q13a1PhysicalMntlHealthCondTableBean
				.setQ13a1BothAlcoholAndDrugAbuseWithoutChildren(q13a1BothAlcoholAndDrugAbuseWithoutChildren);
		q13a1PhysicalMntlHealthCondTableBean
				.setQ13a1BothAlcoholAndDrugAbuseWithChildAndAdults(q13a1BothAlcoholAndDrugAbuseWithChildAndAdults);
		q13a1PhysicalMntlHealthCondTableBean
				.setQ13a1BothAlcoholAndDrugAbuseWithOnlychildren(q13a1BothAlcoholAndDrugAbuseWithOnlychildren);
		q13a1PhysicalMntlHealthCondTableBean
				.setQ13a1BothAlcoholAndDrugAbuseUnknowHousehold(q13a1BothAlcoholAndDrugAbuseUnknowHousehold);

		q13a1PhysicalMntlHealthCondTableBean
				.setQ13a1ChronicHealthConditionTotal(q13a1ChronicHealthConditionTotal);
		q13a1PhysicalMntlHealthCondTableBean
				.setQ13a1ChronicHealthConditionWithoutChildren(q13a1ChronicHealthConditionWithoutChildren);
		q13a1PhysicalMntlHealthCondTableBean
				.setQ13a1ChronicHealthConditionWithChildAndAdults(q13a1ChronicHealthConditionWithChildAndAdults);
		q13a1PhysicalMntlHealthCondTableBean
				.setQ13a1ChronicHealthConditionWithOnlychildren(q13a1ChronicHealthConditionWithOnlychildren);
		q13a1PhysicalMntlHealthCondTableBean
				.setQ13a1ChronicHealthConditionUnknowHousehold(q13a1ChronicHealthConditionUnknowHousehold);

		q13a1PhysicalMntlHealthCondTableBean
				.setQ13a1HIVRelatedDiseasesTotal(q13a1HIVRelatedDiseasesTotal);
		q13a1PhysicalMntlHealthCondTableBean
				.setQ13a1HIVRelatedDiseasesWithoutChildren(q13a1HIVRelatedDiseasesWithoutChildren);
		q13a1PhysicalMntlHealthCondTableBean
				.setQ13a1HIVRelatedDiseasesWithOnlychildren(q13a1HIVRelatedDiseasesWithOnlychildren);
		q13a1PhysicalMntlHealthCondTableBean
				.setQ13a1HIVRelatedDiseasesWithChildAndAdults(q13a1HIVRelatedDiseasesWithChildAndAdults);
		q13a1PhysicalMntlHealthCondTableBean
				.setQ13a1HIVRelatedDiseasesUnknowHousehold(q13a1HIVRelatedDiseasesUnknowHousehold);

		q13a1PhysicalMntlHealthCondTableBean
				.setQ13a1DevelopmentalDisabilityTotal(q13a1DevelopmentalDisabilityTotal);
		q13a1PhysicalMntlHealthCondTableBean
				.setQ13a1DevelopmentalDisabilityWithoutChildren(q13a1DevelopmentalDisabilityWithoutChildren);
		q13a1PhysicalMntlHealthCondTableBean
				.setQ13a1DevelopmentalDisabilityWithChildAndAdults(q13a1DevelopmentalDisabilityWithChildAndAdults);
		q13a1PhysicalMntlHealthCondTableBean
				.setQ13a1DevelopmentalDisabilityWithOnlychildren(q13a1DevelopmentalDisabilityWithOnlychildren);
		q13a1PhysicalMntlHealthCondTableBean
				.setQ13a1DevelopmentalDisabilityUnknowHousehold(q13a1DevelopmentalDisabilityUnknowHousehold);

		q13a1PhysicalMntlHealthCondTableBean
				.setQ13a1PhysicalDisabilityTotal(q13a1PhysicalDisabilityTotal);
		q13a1PhysicalMntlHealthCondTableBean
				.setQ13a1PhysicalDisabilityWithoutChildren(q13a1PhysicalDisabilityWithoutChildren);
		q13a1PhysicalMntlHealthCondTableBean
				.setQ13a1PhysicalDisabilityWithChildAndAdults(q13a1PhysicalDisabilityWithChildAndAdults);
		q13a1PhysicalMntlHealthCondTableBean
				.setQ13a1PhysicalDisabilityWithOnlychildren(q13a1PhysicalDisabilityWithOnlychildren);
		q13a1PhysicalMntlHealthCondTableBean
				.setQ13a1PhysicalDisabilityUnknowHousehold(q13a1PhysicalDisabilityUnknowHousehold);

		return q13a1PhysicalMntlHealthCondTableBean;
	}

	public static DataBean q13a2NumberofConditioinsTableBean(
			BigInteger q13a2NoneTotal, BigInteger q13a2NoneWithoutChildren,
			BigInteger q13a2NoneWithChildAndAdults,
			BigInteger q13a2NoneWithOnlychildren,
			BigInteger q13a2NoneUnknowHousehold,
			BigInteger q13a2Condition1Total,
			BigInteger q13a2Condition1WithoutChildren,
			BigInteger q13a2Condition1WithChildAndAdults,
			BigInteger q13a2Condition1WithOnlychildren,
			BigInteger q13a2Condition1UnknowHousehold,
			BigInteger q13a2Condition2Total,
			BigInteger q13a2Condition2WithoutChildren,
			BigInteger q13a2Condition2WithChildAndAdults,
			BigInteger q13a2Condition2WithOnlychildren,
			BigInteger q13a2Condition2UnknowHousehold,
			BigInteger q13a2Condition3PlusTotal,
			BigInteger q13a2Condition3PlusWithoutChildren,
			BigInteger q13a2Condition3PlusWithChildAndAdults,
			BigInteger q13a2Condition3PlusWithOnlychildren,
			BigInteger q13a2Condition3PlusUnknowHousehold,
			BigInteger q13a2ConditionUnknownTotal,
			BigInteger q13a2ConditionUnknownWithoutChildren,
			BigInteger q13a2ConditionUnknownWithChildAndAdults,
			BigInteger q13a2ConditionUnknownWithOnlychildren,
			BigInteger q13a2ConditionUnknownUnknowHousehold,
			BigInteger q13a2DontKnowRefusedTotal,
			BigInteger q13a2DontKnowRefusedWithoutChildren,
			BigInteger q13a2DontKnowRefusedWithChildAndAdults,
			BigInteger q13a2DontKnowRefusedWithOnlychildren,
			BigInteger q13a2DontKnowRefusedUnknowHousehold,
			BigInteger q13a2InformationmissingTotal,
			BigInteger q13a2InformationmissingWithoutChildren,
			BigInteger q13a2InformationmissingWithChildAndAdults,
			BigInteger q13a2InformationmissingWithOnlychildren,
			BigInteger q13a2InformationmissingUnknowHousehold,
			BigInteger q13a2TotalSummed, BigInteger q13a2TotalWithoutChildren,
			BigInteger q13a2TotalWithChildAndAdults,
			BigInteger q13a2TotalWithOnlychildren,
			BigInteger q13a2TotalUnknowHousehold,
			DataBean q13a2NumberofConditioinsTableBean) {

		q13a2NumberofConditioinsTableBean.setQ13a2NoneTotal(q13a2NoneTotal);
		q13a2NumberofConditioinsTableBean
				.setQ13a2NoneWithoutChildren(q13a2NoneWithoutChildren);
		q13a2NumberofConditioinsTableBean
				.setQ13a2NoneWithChildAndAdults(q13a2NoneWithChildAndAdults);
		q13a2NumberofConditioinsTableBean
				.setQ13a2NoneWithOnlychildren(q13a2NoneWithOnlychildren);
		q13a2NumberofConditioinsTableBean
				.setQ13a2NoneUnknowHousehold(q13a2NoneUnknowHousehold);

		q13a2NumberofConditioinsTableBean
				.setQ13a2Condition1Total(q13a2Condition1Total);
		q13a2NumberofConditioinsTableBean
				.setQ13a2Condition1WithoutChildren(q13a2Condition1WithoutChildren);
		q13a2NumberofConditioinsTableBean
				.setQ13a2Condition1WithChildAndAdults(q13a2Condition1WithChildAndAdults);
		q13a2NumberofConditioinsTableBean
				.setQ13a2Condition1WithOnlychildren(q13a2Condition1WithOnlychildren);
		q13a2NumberofConditioinsTableBean
				.setQ13a2Condition1UnknowHousehold(q13a2Condition1UnknowHousehold);

		q13a2NumberofConditioinsTableBean
				.setQ13a2Condition2Total(q13a2Condition2Total);
		q13a2NumberofConditioinsTableBean
				.setQ13a2Condition2WithoutChildren(q13a2Condition2WithoutChildren);
		q13a2NumberofConditioinsTableBean
				.setQ13a2Condition2WithChildAndAdults(q13a2Condition2WithChildAndAdults);
		q13a2NumberofConditioinsTableBean
				.setQ13a2Condition2WithOnlychildren(q13a2Condition2WithOnlychildren);
		q13a2NumberofConditioinsTableBean
				.setQ13a2Condition2UnknowHousehold(q13a2Condition2UnknowHousehold);

		q13a2NumberofConditioinsTableBean
				.setQ13a2Condition3PlusTotal(q13a2Condition3PlusTotal);
		q13a2NumberofConditioinsTableBean
				.setQ13a2Condition3PlusWithoutChildren(q13a2Condition3PlusWithoutChildren);
		q13a2NumberofConditioinsTableBean
				.setQ13a2Condition3PlusWithChildAndAdults(q13a2Condition3PlusWithChildAndAdults);
		q13a2NumberofConditioinsTableBean
				.setQ13a2Condition3PlusWithOnlychildren(q13a2Condition3PlusWithOnlychildren);
		q13a2NumberofConditioinsTableBean
				.setQ13a2Condition3PlusUnknowHousehold(q13a2Condition3PlusUnknowHousehold);

		q13a2NumberofConditioinsTableBean
				.setQ13a2ConditionUnknownTotal(q13a2ConditionUnknownTotal);
		q13a2NumberofConditioinsTableBean
				.setQ13a2ConditionUnknownWithoutChildren(q13a2ConditionUnknownWithoutChildren);
		q13a2NumberofConditioinsTableBean
				.setQ13a2ConditionUnknownWithChildAndAdults(q13a2ConditionUnknownWithChildAndAdults);
		q13a2NumberofConditioinsTableBean
				.setQ13a2ConditionUnknownWithOnlychildren(q13a2ConditionUnknownWithOnlychildren);
		q13a2NumberofConditioinsTableBean
				.setQ13a2ConditionUnknownUnknowHousehold(q13a2ConditionUnknownUnknowHousehold);

		q13a2NumberofConditioinsTableBean
				.setQ13a2DontKnowRefusedTotal(q13a2DontKnowRefusedTotal);
		q13a2NumberofConditioinsTableBean
				.setQ13a2DontKnowRefusedWithoutChildren(q13a2DontKnowRefusedWithoutChildren);
		q13a2NumberofConditioinsTableBean
				.setQ13a2DontKnowRefusedWithChildAndAdults(q13a2DontKnowRefusedWithChildAndAdults);
		q13a2NumberofConditioinsTableBean
				.setQ13a2DontKnowRefusedWithOnlychildren(q13a2DontKnowRefusedWithOnlychildren);
		q13a2NumberofConditioinsTableBean
				.setQ13a2DontKnowRefusedUnknowHousehold(q13a2DontKnowRefusedUnknowHousehold);

		q13a2NumberofConditioinsTableBean
				.setQ13a2InformationmissingTotal(q13a2InformationmissingTotal);
		q13a2NumberofConditioinsTableBean
				.setQ13a2InformationmissingWithoutChildren(q13a2InformationmissingWithoutChildren);
		q13a2NumberofConditioinsTableBean
				.setQ13a2InformationmissingWithChildAndAdults(q13a2InformationmissingWithChildAndAdults);
		q13a2NumberofConditioinsTableBean
				.setQ13a2InformationmissingWithOnlychildren(q13a2InformationmissingWithOnlychildren);
		q13a2NumberofConditioinsTableBean
				.setQ13a2InformationmissingUnknowHousehold(q13a2InformationmissingUnknowHousehold);

		q13a2NumberofConditioinsTableBean.setQ13a2TotalSummed(q13a2TotalSummed);
		q13a2NumberofConditioinsTableBean
				.setQ13a2TotalWithoutChildren(q13a2TotalWithoutChildren);
		q13a2NumberofConditioinsTableBean
				.setQ13a2TotalWithChildAndAdults(q13a2TotalWithChildAndAdults);
		q13a2NumberofConditioinsTableBean
				.setQ13a2TotalWithOnlychildren(q13a2TotalWithOnlychildren);
		q13a2NumberofConditioinsTableBean
				.setQ13a2TotalUnknowHousehold(q13a2TotalUnknowHousehold);

		return q13a2NumberofConditioinsTableBean;

	}

	public static DataBean q13b1PhysicalAndMentalHealthConditionsAtExitTableBean(
			BigInteger q13b1MentalIllnessTotal,
			BigInteger q13b1MentalIllnessWithoutChildren,
			BigInteger q13b1MentalIllnessWithChildAndAdults,
			BigInteger q13b1MentalIllnessWithOnlychildren,
			BigInteger q13b1MentalIllnessUnknowHousehold,
			BigInteger q13b1AlcoholAbuseTotal,
			BigInteger q13b1AlcoholAbuseWithoutChildren,
			BigInteger q13b1AlcoholAbuseWithChildAndAdults,
			BigInteger q13b1AlcoholAbuseWithOnlychildren,
			BigInteger q13b1AlcoholAbuseUnknowHousehold,
			BigInteger q13b1DrugAbuseTotal,
			BigInteger q13b1DrugAbuseWithoutChildren,
			BigInteger q13b1DrugAbuseWithChildAndAdults,
			BigInteger q13b1DrugAbuseWithOnlychildren,
			BigInteger q13b1DrugAbuseUnknowHousehold,
			BigInteger q13b1BothAlcoholAndDrugAbuseTotal,
			BigInteger q13b1BothAlcoholAndDrugAbuseWithoutChildren,
			BigInteger q13b1BothAlcoholAndDrugAbuseWithChildAndAdults,
			BigInteger q13b1BothAlcoholAndDrugAbuseWithOnlychildren,
			BigInteger q13b1BothAlcoholAndDrugAbuseUnknowHousehold,
			BigInteger q13b1ChronicHealthConditionTotal,
			BigInteger q13b1ChronicHealthConditionWithoutChildren,
			BigInteger q13b1ChronicHealthConditionWithChildAndAdults,
			BigInteger q13b1ChronicHealthConditionWithOnlychildren,
			BigInteger q13b1ChronicHealthConditionUnknowHousehold,
			BigInteger q13b1hivRelatedDiseasesTotal,
			BigInteger q13b1hivRelatedDiseasesWithoutChildren,
			BigInteger q13b1hivRelatedDiseasesWithChildAndAdults,
			BigInteger q13b1hivRelatedDiseasesWithOnlychildren,
			BigInteger q13b1hivRelatedDiseasesUnknowHousehold,
			BigInteger q13b1DevelopmentalDisabilityTotal,
			BigInteger q13b1DevelopmentalDisabilityWithoutChildren,
			BigInteger q13b1DevelopmentalDisabilityWithChildAndAdults,
			BigInteger q13b1DevelopmentalDisabilityWithOnlychildren,
			BigInteger q13b1DevelopmentalDisabilityUnknowHousehold,
			BigInteger q13b1PhysicalDisabilityTotal,
			BigInteger q13b1PhysicalDisabilityWithoutChildren,
			BigInteger q13b1PhysicalDisabilityWithChildAndAdults,
			BigInteger q13b1PhysicalDisabilityWithOnlychildren,
			BigInteger q13b1PhysicalDisabilityUnknowHousehold,
			DataBean q13b1PhysicalAndMentalHealthConditionsAtExitTableBean) {

		q13b1PhysicalAndMentalHealthConditionsAtExitTableBean
				.setQ13b1MentalIllnessTotal(q13b1MentalIllnessTotal);
		q13b1PhysicalAndMentalHealthConditionsAtExitTableBean
				.setQ13b1MentalIllnessWithoutChildren(q13b1MentalIllnessWithoutChildren);
		q13b1PhysicalAndMentalHealthConditionsAtExitTableBean
				.setQ13b1MentalIllnessWithChildAndAdults(q13b1MentalIllnessWithChildAndAdults);
		q13b1PhysicalAndMentalHealthConditionsAtExitTableBean
				.setQ13b1MentalIllnessWithChildAndAdults(q13b1MentalIllnessWithChildAndAdults);
		q13b1PhysicalAndMentalHealthConditionsAtExitTableBean
				.setQ13b1MentalIllnessUnknowHousehold(q13b1MentalIllnessUnknowHousehold);

		q13b1PhysicalAndMentalHealthConditionsAtExitTableBean
				.setQ13b1AlcoholAbuseTotal(q13b1AlcoholAbuseTotal);
		q13b1PhysicalAndMentalHealthConditionsAtExitTableBean
				.setQ13b1AlcoholAbuseWithoutChildren(q13b1AlcoholAbuseWithoutChildren);
		q13b1PhysicalAndMentalHealthConditionsAtExitTableBean
				.setQ13b1AlcoholAbuseWithChildAndAdults(q13b1AlcoholAbuseWithChildAndAdults);
		q13b1PhysicalAndMentalHealthConditionsAtExitTableBean
				.setQ13b1AlcoholAbuseWithOnlychildren(q13b1AlcoholAbuseWithOnlychildren);
		q13b1PhysicalAndMentalHealthConditionsAtExitTableBean
				.setQ13b1AlcoholAbuseUnknowHousehold(q13b1AlcoholAbuseUnknowHousehold);

		q13b1PhysicalAndMentalHealthConditionsAtExitTableBean
				.setQ13b1DrugAbuseTotal(q13b1DrugAbuseTotal);
		q13b1PhysicalAndMentalHealthConditionsAtExitTableBean
				.setQ13b1DrugAbuseWithoutChildren(q13b1DrugAbuseWithoutChildren);
		q13b1PhysicalAndMentalHealthConditionsAtExitTableBean
				.setQ13b1DrugAbuseWithChildAndAdults(q13b1DrugAbuseWithChildAndAdults);
		q13b1PhysicalAndMentalHealthConditionsAtExitTableBean
				.setQ13b1DrugAbuseWithOnlychildren(q13b1DrugAbuseWithOnlychildren);
		q13b1PhysicalAndMentalHealthConditionsAtExitTableBean
				.setQ13b1DrugAbuseUnknowHousehold(q13b1DrugAbuseUnknowHousehold);

		q13b1PhysicalAndMentalHealthConditionsAtExitTableBean
				.setQ13b1BothAlcoholAndDrugAbuseTotal(q13b1BothAlcoholAndDrugAbuseTotal);
		q13b1PhysicalAndMentalHealthConditionsAtExitTableBean
				.setQ13b1BothAlcoholAndDrugAbuseWithoutChildren(q13b1BothAlcoholAndDrugAbuseWithoutChildren);
		q13b1PhysicalAndMentalHealthConditionsAtExitTableBean
				.setQ13b1BothAlcoholAndDrugAbuseWithChildAndAdults(q13b1BothAlcoholAndDrugAbuseWithChildAndAdults);
		q13b1PhysicalAndMentalHealthConditionsAtExitTableBean
				.setQ13b1BothAlcoholAndDrugAbuseWithOnlychildren(q13b1BothAlcoholAndDrugAbuseWithOnlychildren);
		q13b1PhysicalAndMentalHealthConditionsAtExitTableBean
				.setQ13b1BothAlcoholAndDrugAbuseUnknowHousehold(q13b1BothAlcoholAndDrugAbuseUnknowHousehold);

		q13b1PhysicalAndMentalHealthConditionsAtExitTableBean
				.setQ13b1ChronicHealthConditionTotal(q13b1ChronicHealthConditionTotal);
		q13b1PhysicalAndMentalHealthConditionsAtExitTableBean
				.setQ13b1ChronicHealthConditionWithoutChildren(q13b1ChronicHealthConditionWithoutChildren);
		q13b1PhysicalAndMentalHealthConditionsAtExitTableBean
				.setQ13b1ChronicHealthConditionWithChildAndAdults(q13b1ChronicHealthConditionWithChildAndAdults);
		q13b1PhysicalAndMentalHealthConditionsAtExitTableBean
				.setQ13b1ChronicHealthConditionWithOnlychildren(q13b1ChronicHealthConditionWithOnlychildren);
		q13b1PhysicalAndMentalHealthConditionsAtExitTableBean
				.setQ13b1ChronicHealthConditionUnknowHousehold(q13b1ChronicHealthConditionUnknowHousehold);

		q13b1PhysicalAndMentalHealthConditionsAtExitTableBean
				.setQ13b1HIVRelatedDiseasesTotal(q13b1hivRelatedDiseasesTotal);
		q13b1PhysicalAndMentalHealthConditionsAtExitTableBean
				.setQ13b1HIVRelatedDiseasesWithoutChildren(q13b1hivRelatedDiseasesWithoutChildren);
		q13b1PhysicalAndMentalHealthConditionsAtExitTableBean
				.setQ13b1HIVRelatedDiseasesWithChildAndAdults(q13b1hivRelatedDiseasesWithChildAndAdults);
		q13b1PhysicalAndMentalHealthConditionsAtExitTableBean
				.setQ13b1HIVRelatedDiseasesWithOnlychildren(q13b1hivRelatedDiseasesWithOnlychildren);
		q13b1PhysicalAndMentalHealthConditionsAtExitTableBean
				.setQ13b1HIVRelatedDiseasesUnknowHousehold(q13b1hivRelatedDiseasesUnknowHousehold);

		q13b1PhysicalAndMentalHealthConditionsAtExitTableBean
				.setQ13b1DevelopmentalDisabilityTotal(q13b1DevelopmentalDisabilityTotal);
		q13b1PhysicalAndMentalHealthConditionsAtExitTableBean
				.setQ13b1DevelopmentalDisabilityWithoutChildren(q13b1DevelopmentalDisabilityWithoutChildren);
		q13b1PhysicalAndMentalHealthConditionsAtExitTableBean
				.setQ13b1DevelopmentalDisabilityWithChildAndAdults(q13b1DevelopmentalDisabilityWithChildAndAdults);
		q13b1PhysicalAndMentalHealthConditionsAtExitTableBean
				.setQ13b1DevelopmentalDisabilityWithOnlychildren(q13b1DevelopmentalDisabilityWithOnlychildren);
		q13b1PhysicalAndMentalHealthConditionsAtExitTableBean
				.setQ13b1DevelopmentalDisabilityUnknowHousehold(q13b1DevelopmentalDisabilityUnknowHousehold);

		q13b1PhysicalAndMentalHealthConditionsAtExitTableBean
				.setQ13b1PhysicalDisabilityTotal(q13b1PhysicalDisabilityTotal);
		q13b1PhysicalAndMentalHealthConditionsAtExitTableBean
				.setQ13b1PhysicalDisabilityWithoutChildren(q13b1PhysicalDisabilityWithoutChildren);
		q13b1PhysicalAndMentalHealthConditionsAtExitTableBean
				.setQ13b1PhysicalDisabilityWithChildAndAdults(q13b1PhysicalDisabilityWithChildAndAdults);
		q13b1PhysicalAndMentalHealthConditionsAtExitTableBean
				.setQ13b1PhysicalDisabilityWithOnlychildren(q13b1PhysicalDisabilityWithOnlychildren);
		q13b1PhysicalAndMentalHealthConditionsAtExitTableBean
				.setQ13b1PhysicalDisabilityUnknowHousehold(q13b1PhysicalDisabilityUnknowHousehold);

		return q13b1PhysicalAndMentalHealthConditionsAtExitTableBean;
	}

	public static DataBean q13b2NumberOfConditionsAtExitTableBean(
			BigInteger q13b2NoneTotal, BigInteger q13b2NoneWithoutChildren,
			BigInteger q13b2NoneWithChildAndAdults,
			BigInteger q13b2NoneWithOnlychildren,
			BigInteger q13b2NoneUnknowHousehold,
			BigInteger q13b2Condition1Total,
			BigInteger q13b2Condition1WithoutChildren,
			BigInteger q13b2Condition1WithChildAndAdults,
			BigInteger q13b2Condition1WithOnlychildren,
			BigInteger q13b2Condition1UnknowHousehold,
			BigInteger q13b2Condition2Total,
			BigInteger q13b2Condition2WithoutChildren,
			BigInteger q13b2Condition2WithChildAndAdults,
			BigInteger q13b2Condition2WithOnlychildren,
			BigInteger q13b2Condition2UnknowHousehold,
			BigInteger q13b2Condition3PlusTotal,
			BigInteger q13b2Condition3PlusWithoutChildren,
			BigInteger q13b2Condition3PlusWithChildAndAdults,
			BigInteger q13b2Condition3PlusWithOnlychildren,
			BigInteger q13b2Condition3PlusUnknowHousehold,
			BigInteger q13b2ConditionUnknownTotal,
			BigInteger q13b2ConditionUnknownWithoutChildren,
			BigInteger q13b2ConditionUnknownWithChildAndAdults,
			BigInteger q13b2ConditionUnknownWithOnlychildren,
			BigInteger q13b2ConditionUnknownUnknowHousehold,
			BigInteger q13b2DontKnowRefusedTotal,
			BigInteger q13b2DontKnowRefusedWithoutChildren,
			BigInteger q13b2DontKnowRefusedWithChildAndAdults,
			BigInteger q13b2DontKnowRefusedWithOnlychildren,
			BigInteger q13b2DontKnowRefusedUnknowHousehold,
			BigInteger q13b2InformationmissingTotal,
			BigInteger q13b2InformationmissingWithoutChildren,
			BigInteger q13b2InformationmissingWithChildAndAdults,
			BigInteger q13b2InformationmissingWithOnlychildren,
			BigInteger q13b2InformationmissingUnknowHousehold,
			BigInteger q13b2TotalSummed, BigInteger q13b2TotalWithoutChildren,
			BigInteger q13b2TotalWithChildAndAdults,
			BigInteger q13b2TotalWithOnlychildren,
			BigInteger q13b2TotalUnknowHousehold,
			DataBean q13b2NumberOfConditionsAtExitTableBean) {

		q13b2NumberOfConditionsAtExitTableBean
				.setQ13b2NoneTotal(q13b2NoneTotal);
		q13b2NumberOfConditionsAtExitTableBean
				.setQ13b2NoneWithoutChildren(q13b2NoneWithoutChildren);
		q13b2NumberOfConditionsAtExitTableBean
				.setQ13b2NoneWithChildAndAdults(q13b2NoneWithChildAndAdults);
		q13b2NumberOfConditionsAtExitTableBean
				.setQ13b2NoneWithOnlychildren(q13b2NoneWithOnlychildren);
		q13b2NumberOfConditionsAtExitTableBean
				.setQ13b2NoneUnknowHousehold(q13b2NoneUnknowHousehold);

		q13b2NumberOfConditionsAtExitTableBean
				.setQ13b2Condition1Total(q13b2Condition1Total);
		q13b2NumberOfConditionsAtExitTableBean
				.setQ13b2Condition1WithoutChildren(q13b2Condition1WithoutChildren);
		q13b2NumberOfConditionsAtExitTableBean
				.setQ13b2Condition1WithChildAndAdults(q13b2Condition1WithChildAndAdults);
		q13b2NumberOfConditionsAtExitTableBean
				.setQ13b2Condition1WithOnlychildren(q13b2Condition1WithOnlychildren);
		q13b2NumberOfConditionsAtExitTableBean
				.setQ13b2Condition1UnknowHousehold(q13b2Condition1UnknowHousehold);

		q13b2NumberOfConditionsAtExitTableBean
				.setQ13b2Condition2Total(q13b2Condition2Total);
		q13b2NumberOfConditionsAtExitTableBean
				.setQ13b2Condition2WithoutChildren(q13b2Condition2WithoutChildren);
		q13b2NumberOfConditionsAtExitTableBean
				.setQ13b2Condition2WithChildAndAdults(q13b2Condition2WithChildAndAdults);
		q13b2NumberOfConditionsAtExitTableBean
				.setQ13b2Condition2WithOnlychildren(q13b2Condition2WithOnlychildren);
		q13b2NumberOfConditionsAtExitTableBean
				.setQ13b2Condition2UnknowHousehold(q13b2Condition2UnknowHousehold);

		q13b2NumberOfConditionsAtExitTableBean
				.setQ13b2Condition3PlusTotal(q13b2Condition3PlusTotal);
		q13b2NumberOfConditionsAtExitTableBean
				.setQ13b2Condition3PlusWithoutChildren(q13b2Condition3PlusWithoutChildren);
		q13b2NumberOfConditionsAtExitTableBean
				.setQ13b2Condition3PlusWithChildAndAdults(q13b2Condition3PlusWithChildAndAdults);
		q13b2NumberOfConditionsAtExitTableBean
				.setQ13b2Condition3PlusWithOnlychildren(q13b2Condition3PlusWithOnlychildren);
		q13b2NumberOfConditionsAtExitTableBean
				.setQ13b2Condition3PlusUnknowHousehold(q13b2Condition3PlusUnknowHousehold);

		q13b2NumberOfConditionsAtExitTableBean
				.setQ13b2ConditionUnknownTotal(q13b2ConditionUnknownTotal);
		q13b2NumberOfConditionsAtExitTableBean
				.setQ13b2ConditionUnknownWithoutChildren(q13b2ConditionUnknownWithoutChildren);
		q13b2NumberOfConditionsAtExitTableBean
				.setQ13b2ConditionUnknownWithChildAndAdults(q13b2ConditionUnknownWithChildAndAdults);
		q13b2NumberOfConditionsAtExitTableBean
				.setQ13b2ConditionUnknownWithOnlychildren(q13b2ConditionUnknownWithOnlychildren);
		q13b2NumberOfConditionsAtExitTableBean
				.setQ13b2ConditionUnknownUnknowHousehold(q13b2ConditionUnknownUnknowHousehold);

		q13b2NumberOfConditionsAtExitTableBean
				.setQ13b2DontKnowRefusedTotal(q13b2DontKnowRefusedTotal);
		q13b2NumberOfConditionsAtExitTableBean
				.setQ13b2DontKnowRefusedWithoutChildren(q13b2DontKnowRefusedWithoutChildren);
		q13b2NumberOfConditionsAtExitTableBean
				.setQ13b2DontKnowRefusedWithChildAndAdults(q13b2DontKnowRefusedWithChildAndAdults);
		q13b2NumberOfConditionsAtExitTableBean
				.setQ13b2DontKnowRefusedWithOnlychildren(q13b2DontKnowRefusedWithOnlychildren);
		q13b2NumberOfConditionsAtExitTableBean
				.setQ13b2DontKnowRefusedUnknowHousehold(q13b2DontKnowRefusedUnknowHousehold);

		q13b2NumberOfConditionsAtExitTableBean
				.setQ13b2InformationmissingTotal(q13b2InformationmissingTotal);
		q13b2NumberOfConditionsAtExitTableBean
				.setQ13b2InformationmissingWithoutChildren(q13b2InformationmissingWithoutChildren);
		q13b2NumberOfConditionsAtExitTableBean
				.setQ13b2InformationmissingWithChildAndAdults(q13b2InformationmissingWithChildAndAdults);
		q13b2NumberOfConditionsAtExitTableBean
				.setQ13b2InformationmissingWithOnlychildren(q13b2InformationmissingWithOnlychildren);
		q13b2NumberOfConditionsAtExitTableBean
				.setQ13b2InformationmissingUnknowHousehold(q13b2InformationmissingUnknowHousehold);

		q13b2NumberOfConditionsAtExitTableBean
				.setQ13b2TotalSummed(q13b2TotalSummed);
		q13b2NumberOfConditionsAtExitTableBean
				.setQ13b2TotalWithoutChildren(q13b2TotalWithoutChildren);
		q13b2NumberOfConditionsAtExitTableBean
				.setQ13b2TotalWithChildAndAdults(q13b2TotalWithChildAndAdults);
		q13b2NumberOfConditionsAtExitTableBean
				.setQ13b2TotalWithOnlychildren(q13b2TotalWithOnlychildren);
		q13b2NumberOfConditionsAtExitTableBean
				.setQ13b2TotalUnknowHousehold(q13b2TotalUnknowHousehold);

		return q13b2NumberOfConditionsAtExitTableBean;
	}

	public static DataBean q13c1PhysicalAndMentalHealthConditionsForStayerTableBean(
			BigInteger q13c1MentalIllnessTotal,
			BigInteger q13c1MentalIllnessWithoutChildren,
			BigInteger q13c1MentalIllnessWithChildAndAdults,
			BigInteger q13c1MentalIllnessWithOnlychildren,
			BigInteger q13c1MentalIllnessUnknowHousehold,
			BigInteger q13c1AlcoholAbuseTotal,
			BigInteger q13c1AlcoholAbuseWithoutChildren,
			BigInteger q13c1AlcoholAbuseWithChildAndAdults,
			BigInteger q13c1AlcoholAbuseWithOnlychildren,
			BigInteger q13c1AlcoholAbuseUnknowHousehold,
			BigInteger q13c1DrugAbuseTotal,
			BigInteger q13c1DrugAbuseWithoutChildren,
			BigInteger q13c1DrugAbuseWithChildAndAdults,
			BigInteger q13c1DrugAbuseWithOnlychildren,
			BigInteger q13c1DrugAbuseUnknowHousehold,
			BigInteger q13c1BothAlcoholAndDrugAbuseTotal,
			BigInteger q13c1BothAlcoholAndDrugAbuseWithoutChildren,
			BigInteger q13c1BothAlcoholAndDrugAbuseWithChildAndAdults,
			BigInteger q13c1BothAlcoholAndDrugAbuseWithOnlychildren,
			BigInteger q13c1BothAlcoholAndDrugAbuseUnknowHousehold,
			BigInteger q13c1ChronicHealthConditionTotal,
			BigInteger q13c1ChronicHealthConditionWithoutChildren,
			BigInteger q13c1ChronicHealthConditionWithChildAndAdults,
			BigInteger q13c1ChronicHealthConditionWithOnlychildren,
			BigInteger q13c1ChronicHealthConditionUnknowHousehold,
			BigInteger q13c1hivRelatedDiseasesTotal,
			BigInteger q13c1hivRelatedDiseasesWithoutChildren,
			BigInteger q13c1hivRelatedDiseasesWithChildAndAdults,
			BigInteger q13c1hivRelatedDiseasesWithOnlychildren,
			BigInteger q13c1hivRelatedDiseasesUnknowHousehold,
			BigInteger q13c1DevelopmentalDisabilityTotal,
			BigInteger q13c1DevelopmentalDisabilityWithoutChildren,
			BigInteger q13c1DevelopmentalDisabilityWithChildAndAdults,
			BigInteger q13c1DevelopmentalDisabilityWithOnlychildren,
			BigInteger q13c1DevelopmentalDisabilityUnknowHousehold,
			BigInteger q13c1PhysicalDisabilityTotal,
			BigInteger q13c1PhysicalDisabilityWithoutChildren,
			BigInteger q13c1PhysicalDisabilityWithChildAndAdults,
			BigInteger q13c1PhysicalDisabilityWithOnlychildren,
			BigInteger q13c1PhysicalDisabilityUnknowHousehold,
			DataBean q13c1PhysicalAndMentalHealthConditionsForStayerTableBean) {

		q13c1PhysicalAndMentalHealthConditionsForStayerTableBean
				.setQ13c1MentalIllnessTotal(q13c1MentalIllnessTotal);
		q13c1PhysicalAndMentalHealthConditionsForStayerTableBean
				.setQ13c1MentalIllnessWithoutChildren(q13c1MentalIllnessWithoutChildren);
		q13c1PhysicalAndMentalHealthConditionsForStayerTableBean
				.setQ13c1MentalIllnessWithChildAndAdults(q13c1MentalIllnessWithChildAndAdults);
		q13c1PhysicalAndMentalHealthConditionsForStayerTableBean
				.setQ13c1MentalIllnessWithOnlychildren(q13c1MentalIllnessWithOnlychildren);
		q13c1PhysicalAndMentalHealthConditionsForStayerTableBean
				.setQ13c1MentalIllnessUnknowHousehold(q13c1MentalIllnessUnknowHousehold);

		q13c1PhysicalAndMentalHealthConditionsForStayerTableBean
				.setQ13c1AlcoholAbuseTotal(q13c1AlcoholAbuseTotal);
		q13c1PhysicalAndMentalHealthConditionsForStayerTableBean
				.setQ13c1AlcoholAbuseWithoutChildren(q13c1AlcoholAbuseWithoutChildren);
		q13c1PhysicalAndMentalHealthConditionsForStayerTableBean
				.setQ13c1AlcoholAbuseWithChildAndAdults(q13c1AlcoholAbuseWithChildAndAdults);
		q13c1PhysicalAndMentalHealthConditionsForStayerTableBean
				.setQ13c1AlcoholAbuseWithOnlychildren(q13c1AlcoholAbuseWithOnlychildren);
		q13c1PhysicalAndMentalHealthConditionsForStayerTableBean
				.setQ13c1AlcoholAbuseUnknowHousehold(q13c1AlcoholAbuseUnknowHousehold);

		q13c1PhysicalAndMentalHealthConditionsForStayerTableBean
				.setQ13c1DrugAbuseTotal(q13c1DrugAbuseTotal);
		q13c1PhysicalAndMentalHealthConditionsForStayerTableBean
				.setQ13c1DrugAbuseWithoutChildren(q13c1DrugAbuseWithoutChildren);
		q13c1PhysicalAndMentalHealthConditionsForStayerTableBean
				.setQ13c1DrugAbuseWithChildAndAdults(q13c1DrugAbuseWithChildAndAdults);
		q13c1PhysicalAndMentalHealthConditionsForStayerTableBean
				.setQ13c1DrugAbuseWithOnlychildren(q13c1DrugAbuseWithOnlychildren);
		q13c1PhysicalAndMentalHealthConditionsForStayerTableBean
				.setQ13c1DrugAbuseUnknowHousehold(q13c1DrugAbuseUnknowHousehold);

		q13c1PhysicalAndMentalHealthConditionsForStayerTableBean
				.setQ13c1BothAlcoholAndDrugAbuseTotal(q13c1BothAlcoholAndDrugAbuseTotal);
		q13c1PhysicalAndMentalHealthConditionsForStayerTableBean
				.setQ13c1BothAlcoholAndDrugAbuseWithoutChildren(q13c1BothAlcoholAndDrugAbuseWithoutChildren);
		q13c1PhysicalAndMentalHealthConditionsForStayerTableBean
				.setQ13c1BothAlcoholAndDrugAbuseWithChildAndAdults(q13c1BothAlcoholAndDrugAbuseWithChildAndAdults);
		q13c1PhysicalAndMentalHealthConditionsForStayerTableBean
				.setQ13c1BothAlcoholAndDrugAbuseWithOnlychildren(q13c1BothAlcoholAndDrugAbuseWithOnlychildren);
		q13c1PhysicalAndMentalHealthConditionsForStayerTableBean
				.setQ13c1BothAlcoholAndDrugAbuseUnknowHousehold(q13c1BothAlcoholAndDrugAbuseUnknowHousehold);

		q13c1PhysicalAndMentalHealthConditionsForStayerTableBean
				.setQ13c1ChronicHealthConditionTotal(q13c1ChronicHealthConditionTotal);
		q13c1PhysicalAndMentalHealthConditionsForStayerTableBean
				.setQ13c1ChronicHealthConditionWithoutChildren(q13c1ChronicHealthConditionWithoutChildren);
		q13c1PhysicalAndMentalHealthConditionsForStayerTableBean
				.setQ13c1ChronicHealthConditionWithChildAndAdults(q13c1ChronicHealthConditionWithChildAndAdults);
		q13c1PhysicalAndMentalHealthConditionsForStayerTableBean
				.setQ13c1ChronicHealthConditionWithOnlychildren(q13c1ChronicHealthConditionWithOnlychildren);
		q13c1PhysicalAndMentalHealthConditionsForStayerTableBean
				.setQ13c1ChronicHealthConditionUnknowHousehold(q13c1ChronicHealthConditionUnknowHousehold);

		q13c1PhysicalAndMentalHealthConditionsForStayerTableBean
				.setQ13c1HIVRelatedDiseasesTotal(q13c1hivRelatedDiseasesTotal);
		q13c1PhysicalAndMentalHealthConditionsForStayerTableBean
				.setQ13c1HIVRelatedDiseasesWithoutChildren(q13c1hivRelatedDiseasesWithoutChildren);
		q13c1PhysicalAndMentalHealthConditionsForStayerTableBean
				.setQ13c1HIVRelatedDiseasesWithChildAndAdults(q13c1hivRelatedDiseasesWithChildAndAdults);
		q13c1PhysicalAndMentalHealthConditionsForStayerTableBean
				.setQ13c1HIVRelatedDiseasesWithOnlychildren(q13c1hivRelatedDiseasesWithOnlychildren);
		q13c1PhysicalAndMentalHealthConditionsForStayerTableBean
				.setQ13c1HIVRelatedDiseasesUnknowHousehold(q13c1hivRelatedDiseasesUnknowHousehold);

		q13c1PhysicalAndMentalHealthConditionsForStayerTableBean
				.setQ13c1DevelopmentalDisabilityTotal(q13c1DevelopmentalDisabilityTotal);
		q13c1PhysicalAndMentalHealthConditionsForStayerTableBean
				.setQ13c1DevelopmentalDisabilityWithoutChildren(q13c1DevelopmentalDisabilityWithoutChildren);
		q13c1PhysicalAndMentalHealthConditionsForStayerTableBean
				.setQ13c1DevelopmentalDisabilityWithChildAndAdults(q13c1DevelopmentalDisabilityWithChildAndAdults);
		q13c1PhysicalAndMentalHealthConditionsForStayerTableBean
				.setQ13c1DevelopmentalDisabilityWithOnlychildren(q13c1DevelopmentalDisabilityWithOnlychildren);
		q13c1PhysicalAndMentalHealthConditionsForStayerTableBean
				.setQ13c1DevelopmentalDisabilityUnknowHousehold(q13c1DevelopmentalDisabilityUnknowHousehold);

		q13c1PhysicalAndMentalHealthConditionsForStayerTableBean
				.setQ13c1PhysicalDisabilityTotal(q13c1PhysicalDisabilityTotal);
		q13c1PhysicalAndMentalHealthConditionsForStayerTableBean
				.setQ13c1PhysicalDisabilityWithoutChildren(q13c1PhysicalDisabilityWithoutChildren);
		q13c1PhysicalAndMentalHealthConditionsForStayerTableBean
				.setQ13c1PhysicalDisabilityWithChildAndAdults(q13c1PhysicalDisabilityWithChildAndAdults);
		q13c1PhysicalAndMentalHealthConditionsForStayerTableBean
				.setQ13c1PhysicalDisabilityWithOnlychildren(q13c1PhysicalDisabilityWithOnlychildren);
		q13c1PhysicalAndMentalHealthConditionsForStayerTableBean
				.setQ13c1PhysicalDisabilityUnknowHousehold(q13c1PhysicalDisabilityUnknowHousehold);

		return q13c1PhysicalAndMentalHealthConditionsForStayerTableBean;
	}

	public static DataBean q13c2NumberOfConditionForStayersTableBean(
			BigInteger q13c2NoneTotal, BigInteger q13c2NoneWithoutChildren,
			BigInteger q13c2NoneWithChildAndAdults,
			BigInteger q13c2NoneWithOnlychildren,
			BigInteger q13c2NoneUnknowHousehold,
			BigInteger q13c2Condition1Total,
			BigInteger q13c2Condition1WithoutChildren,
			BigInteger q13c2Condition1WithChildAndAdults,
			BigInteger q13c2Condition1WithOnlychildren,
			BigInteger q13c2Condition1UnknowHousehold,
			BigInteger q13c2Condition2Total,
			BigInteger q13c2Condition2WithoutChildren,
			BigInteger q13c2Condition2WithChildAndAdults,
			BigInteger q13c2Condition2WithOnlychildren,
			BigInteger q13c2Condition2UnknowHousehold,
			BigInteger q13c2Condition3PlusTotal,
			BigInteger q13c2Condition3PlusWithoutChildren,
			BigInteger q13c2Condition3PlusWithChildAndAdults,
			BigInteger q13c2Condition3PlusWithOnlychildren,
			BigInteger q13c2Condition3PlusUnknowHousehold,
			BigInteger q13c2ConditionUnknownTotal,
			BigInteger q13c2ConditionUnknownWithoutChildren,
			BigInteger q13c2ConditionUnknownWithChildAndAdults,
			BigInteger q13c2ConditionUnknownWithOnlychildren,
			BigInteger q13c2ConditionUnknownUnknowHousehold,
			BigInteger q13c2DontKnowRefusedTotal,
			BigInteger q13c2DontKnowRefusedWithoutChildren,
			BigInteger q13c2DontKnowRefusedWithChildAndAdults,
			BigInteger q13c2DontKnowRefusedWithOnlychildren,
			BigInteger q13c2DontKnowRefusedUnknowHousehold,
			BigInteger q13c2InformationmissingTotal,
			BigInteger q13c2InformationmissingWithoutChildren,
			BigInteger q13c2InformationmissingWithChildAndAdults,
			BigInteger q13c2InformationmissingWithOnlychildren,
			BigInteger q13c2InformationmissingUnknowHousehold,
			BigInteger q13c2TotalSummed, BigInteger q13c2TotalWithoutChildren,
			BigInteger q13c2TotalWithChildAndAdults,
			BigInteger q13c2TotalWithOnlychildren,
			BigInteger q13c2TotalUnknowHousehold,
			DataBean q13c2NumberOfConditionsForStayersTableBean) {

		q13c2NumberOfConditionsForStayersTableBean
				.setQ13c2NoneTotal(q13c2NoneTotal);
		q13c2NumberOfConditionsForStayersTableBean
				.setQ13c2NoneWithoutChildren(q13c2NoneWithoutChildren);
		q13c2NumberOfConditionsForStayersTableBean
				.setQ13c2NoneWithChildAndAdults(q13c2NoneWithChildAndAdults);
		q13c2NumberOfConditionsForStayersTableBean
				.setQ13c2NoneWithOnlychildren(q13c2NoneWithOnlychildren);
		q13c2NumberOfConditionsForStayersTableBean
				.setQ13c2NoneUnknowHousehold(q13c2NoneUnknowHousehold);

		q13c2NumberOfConditionsForStayersTableBean
				.setQ13c2Condition1Total(q13c2Condition1Total);
		q13c2NumberOfConditionsForStayersTableBean
				.setQ13c2Condition1WithoutChildren(q13c2Condition1WithoutChildren);
		q13c2NumberOfConditionsForStayersTableBean
				.setQ13c2Condition1WithChildAndAdults(q13c2Condition1WithChildAndAdults);
		q13c2NumberOfConditionsForStayersTableBean
				.setQ13c2Condition1WithOnlychildren(q13c2Condition1WithOnlychildren);
		q13c2NumberOfConditionsForStayersTableBean
				.setQ13c2Condition1UnknowHousehold(q13c2Condition1UnknowHousehold);

		q13c2NumberOfConditionsForStayersTableBean
				.setQ13c2Condition2Total(q13c2Condition2Total);
		q13c2NumberOfConditionsForStayersTableBean
				.setQ13c2Condition2WithoutChildren(q13c2Condition2WithoutChildren);
		q13c2NumberOfConditionsForStayersTableBean
				.setQ13c2Condition2WithChildAndAdults(q13c2Condition2WithChildAndAdults);
		q13c2NumberOfConditionsForStayersTableBean
				.setQ13c2Condition2WithOnlychildren(q13c2Condition2WithOnlychildren);
		q13c2NumberOfConditionsForStayersTableBean
				.setQ13c2Condition2UnknowHousehold(q13c2Condition2UnknowHousehold);

		q13c2NumberOfConditionsForStayersTableBean
				.setQ13c2Condition3PlusTotal(q13c2Condition3PlusTotal);
		q13c2NumberOfConditionsForStayersTableBean
				.setQ13c2Condition3PlusWithoutChildren(q13c2Condition3PlusWithoutChildren);
		q13c2NumberOfConditionsForStayersTableBean
				.setQ13c2Condition3PlusWithChildAndAdults(q13c2Condition3PlusWithChildAndAdults);
		q13c2NumberOfConditionsForStayersTableBean
				.setQ13c2Condition3PlusWithOnlychildren(q13c2Condition3PlusWithOnlychildren);
		q13c2NumberOfConditionsForStayersTableBean
				.setQ13c2Condition3PlusUnknowHousehold(q13c2Condition3PlusUnknowHousehold);

		q13c2NumberOfConditionsForStayersTableBean
				.setQ13c2ConditionUnknownTotal(q13c2ConditionUnknownTotal);
		q13c2NumberOfConditionsForStayersTableBean
				.setQ13c2ConditionUnknownWithoutChildren(q13c2ConditionUnknownWithoutChildren);
		q13c2NumberOfConditionsForStayersTableBean
				.setQ13c2ConditionUnknownWithChildAndAdults(q13c2ConditionUnknownWithChildAndAdults);
		q13c2NumberOfConditionsForStayersTableBean
				.setQ13c2ConditionUnknownWithOnlychildren(q13c2ConditionUnknownWithOnlychildren);
		q13c2NumberOfConditionsForStayersTableBean
				.setQ13c2ConditionUnknownUnknowHousehold(q13c2ConditionUnknownUnknowHousehold);

		q13c2NumberOfConditionsForStayersTableBean
				.setQ13c2DontKnowRefusedTotal(q13c2DontKnowRefusedTotal);
		q13c2NumberOfConditionsForStayersTableBean
				.setQ13c2DontKnowRefusedWithoutChildren(q13c2DontKnowRefusedWithoutChildren);
		q13c2NumberOfConditionsForStayersTableBean
				.setQ13c2DontKnowRefusedWithChildAndAdults(q13c2DontKnowRefusedWithChildAndAdults);
		q13c2NumberOfConditionsForStayersTableBean
				.setQ13c2DontKnowRefusedWithOnlychildren(q13c2DontKnowRefusedWithOnlychildren);
		q13c2NumberOfConditionsForStayersTableBean
				.setQ13c2DontKnowRefusedUnknowHousehold(q13c2DontKnowRefusedUnknowHousehold);

		q13c2NumberOfConditionsForStayersTableBean
				.setQ13c2InformationmissingTotal(q13c2InformationmissingTotal);
		q13c2NumberOfConditionsForStayersTableBean
				.setQ13c2InformationmissingWithoutChildren(q13c2InformationmissingWithoutChildren);
		q13c2NumberOfConditionsForStayersTableBean
				.setQ13c2InformationmissingWithChildAndAdults(q13c2InformationmissingWithChildAndAdults);
		q13c2NumberOfConditionsForStayersTableBean
				.setQ13c2InformationmissingWithOnlychildren(q13c2InformationmissingWithOnlychildren);
		q13c2NumberOfConditionsForStayersTableBean
				.setQ13c2InformationmissingUnknowHousehold(q13c2InformationmissingUnknowHousehold);

		q13c2NumberOfConditionsForStayersTableBean
				.setQ13c2TotalSummed(q13c2TotalSummed);
		q13c2NumberOfConditionsForStayersTableBean
				.setQ13c2TotalWithoutChildren(q13c2TotalWithoutChildren);
		q13c2NumberOfConditionsForStayersTableBean
				.setQ13c2TotalWithChildAndAdults(q13c2TotalWithChildAndAdults);
		q13c2NumberOfConditionsForStayersTableBean
				.setQ13c2TotalWithOnlychildren(q13c2TotalWithOnlychildren);
		q13c2NumberOfConditionsForStayersTableBean
				.setQ13c2TotalUnknowHousehold(q13c2TotalUnknowHousehold);

		return q13c2NumberOfConditionsForStayersTableBean;

	}

	public static DataBean q14aDomesticViolenceHistoryTableBean(
			BigInteger q14aYesTotal, BigInteger q14aYesWithoutChildren,
			BigInteger q14aYesWithChildAndAdults,
			BigInteger q14aYesWithOnlyChildren,
			BigInteger q14aYesUnknownHouseholdType, BigInteger q14aNoTotal,
			BigInteger q14aNoWithoutChildren,
			BigInteger q14aNoWithChildAndAdults,
			BigInteger q14aNoWithOnlyChildren,
			BigInteger q14aNoUnknownHouseholdType, BigInteger q14aDKRTotal,
			BigInteger q14aDKRWithoutChildren,
			BigInteger q14aDKRWithChildAndAdults,
			BigInteger q14aDKRWithOnlyChildren,
			BigInteger q14aDKRUnknownHouseholdType,
			BigInteger q14aInformationMissingTotal,
			BigInteger q14aInformationMissingWithoutChildren,
			BigInteger q14aInformationMissingWithChildAndAdults,
			BigInteger q14aInformationMissingWithOnlyChildren,
			BigInteger q14aInformationMissingUnknownHouseholdType,
			BigInteger q14aTotalSummed, BigInteger q14aTotalWithoutChildren,
			BigInteger q14aTotalWithChildAndAdults,
			BigInteger q14aTotalWithOnlychildren,
			BigInteger q14aTotalUnknowHousehold,
			DataBean q14aDomesticViolenceHistoryTableBean) {

		q14aDomesticViolenceHistoryTableBean.setQ14aYesTotal(q14aYesTotal);
		q14aDomesticViolenceHistoryTableBean
				.setQ14aYesWithoutChildren(q14aYesWithoutChildren);
		q14aDomesticViolenceHistoryTableBean
				.setQ14aYesWithChildAndAdults(q14aYesWithChildAndAdults);
		q14aDomesticViolenceHistoryTableBean
				.setQ14aYesWithOnlyChildren(q14aYesWithOnlyChildren);
		q14aDomesticViolenceHistoryTableBean
				.setQ14aYesUnknownHouseholdType(q14aYesUnknownHouseholdType);

		q14aDomesticViolenceHistoryTableBean.setQ14aNoTotal(q14aNoTotal);
		q14aDomesticViolenceHistoryTableBean
				.setQ14aNoWithoutChildren(q14aNoWithoutChildren);
		q14aDomesticViolenceHistoryTableBean
				.setQ14aNoWithChildAndAdults(q14aNoWithChildAndAdults);
		q14aDomesticViolenceHistoryTableBean
				.setQ14aNoWithOnlyChildren(q14aNoWithOnlyChildren);
		q14aDomesticViolenceHistoryTableBean
				.setQ14aNoUnknownHouseholdType(q14aNoUnknownHouseholdType);

		q14aDomesticViolenceHistoryTableBean.setQ14aDKRTotal(q14aDKRTotal);
		q14aDomesticViolenceHistoryTableBean
				.setQ14aDKRWithoutChildren(q14aDKRWithoutChildren);
		q14aDomesticViolenceHistoryTableBean
				.setQ14aDKRWithChildAndAdults(q14aDKRWithChildAndAdults);
		q14aDomesticViolenceHistoryTableBean
				.setQ14aDKRWithOnlyChildren(q14aDKRWithOnlyChildren);
		q14aDomesticViolenceHistoryTableBean
				.setQ14aDKRUnknownHouseholdType(q14aDKRUnknownHouseholdType);

		q14aDomesticViolenceHistoryTableBean
				.setQ14aInformationMissingTotal(q14aInformationMissingTotal);
		q14aDomesticViolenceHistoryTableBean
				.setQ14aInformationMissingWithoutChildren(q14aInformationMissingWithoutChildren);
		q14aDomesticViolenceHistoryTableBean
				.setQ14aInformationMissingWithChildAndAdults(q14aInformationMissingWithChildAndAdults);
		q14aDomesticViolenceHistoryTableBean
				.setQ14aInformationMissingWithOnlyChildren(q14aInformationMissingWithOnlyChildren);
		q14aDomesticViolenceHistoryTableBean
				.setQ14aInformationMissingUnknownHouseholdType(q14aInformationMissingUnknownHouseholdType);

		q14aDomesticViolenceHistoryTableBean
				.setQ14aTotalSummed(q14aTotalSummed);
		q14aDomesticViolenceHistoryTableBean
				.setQ14aTotalWithoutChildren(q14aTotalWithoutChildren);
		q14aDomesticViolenceHistoryTableBean
				.setQ14aTotalWithChildAndAdults(q14aTotalWithChildAndAdults);
		q14aDomesticViolenceHistoryTableBean
				.setQ14aTotalWithOnlychildren(q14aTotalWithOnlychildren);
		q14aDomesticViolenceHistoryTableBean
				.setQ14aTotalUnknowHousehold(q14aTotalUnknowHousehold);

		return q14aDomesticViolenceHistoryTableBean;
	}

	public static DataBean q14bPersonsFleeingDomesticViolenceTableBean(
			BigInteger q14bYesTotal, BigInteger q14bYesWithoutChildren,
			BigInteger q14bYesWithChildAndAdults,
			BigInteger q14bYesWithOnlyChildren,
			BigInteger q14bYesUnknownHouseholdType, BigInteger q14bNoTotal,
			BigInteger q14bNoWithoutChildren,
			BigInteger q14bNoWithChildAndAdults,
			BigInteger q14bNoWithOnlyChildren,
			BigInteger q14bNoUnknownHouseholdType, BigInteger q14bDKRTotal,
			BigInteger q14bDKRWithoutChildren,
			BigInteger q14bDKRWithChildAndAdults,
			BigInteger q14bDKRWithOnlyChildren,
			BigInteger q14bDKRUnknownHouseholdType,
			BigInteger q14bInformationMissingTotal,
			BigInteger q14bInformationMissingWithoutChildren,
			BigInteger q14bInformationMissingWithChildAndAdults,
			BigInteger q14bInformationMissingWithOnlyChildren,
			BigInteger q14bInformationMissingUnknownHouseholdType,
			BigInteger q14bTotalSummed, BigInteger q14bTotalWithoutChildren,
			BigInteger q14bTotalWithChildAndAdults,
			BigInteger q14bTotalWithOnlychildren,
			BigInteger q14bTotalUnknowHousehold,
			DataBean q14bPersonsFleeingDomesticViolenceTableBean) {

		q14bPersonsFleeingDomesticViolenceTableBean
				.setQ14bYesTotal(q14bYesTotal);
		q14bPersonsFleeingDomesticViolenceTableBean
				.setQ14bYesWithoutChildren(q14bYesWithoutChildren);
		q14bPersonsFleeingDomesticViolenceTableBean
				.setQ14bYesWithChildAndAdults(q14bYesWithChildAndAdults);
		q14bPersonsFleeingDomesticViolenceTableBean
				.setQ14bYesWithOnlyChildren(q14bYesWithOnlyChildren);
		q14bPersonsFleeingDomesticViolenceTableBean
				.setQ14bYesUnknownHouseholdType(q14bYesUnknownHouseholdType);

		q14bPersonsFleeingDomesticViolenceTableBean.setQ14bNoTotal(q14bNoTotal);
		q14bPersonsFleeingDomesticViolenceTableBean
				.setQ14bNoWithoutChildren(q14bNoWithoutChildren);
		q14bPersonsFleeingDomesticViolenceTableBean
				.setQ14bNoWithChildAndAdults(q14bNoWithChildAndAdults);
		q14bPersonsFleeingDomesticViolenceTableBean
				.setQ14bNoWithOnlyChildren(q14bNoWithOnlyChildren);
		q14bPersonsFleeingDomesticViolenceTableBean
				.setQ14bNoUnknownHouseholdType(q14bNoUnknownHouseholdType);

		q14bPersonsFleeingDomesticViolenceTableBean
				.setQ14bDKRTotal(q14bDKRTotal);
		q14bPersonsFleeingDomesticViolenceTableBean
				.setQ14bDKRWithoutChildren(q14bDKRWithoutChildren);
		q14bPersonsFleeingDomesticViolenceTableBean
				.setQ14bDKRWithChildAndAdults(q14bDKRWithChildAndAdults);
		q14bPersonsFleeingDomesticViolenceTableBean
				.setQ14bDKRWithOnlyChildren(q14bDKRWithOnlyChildren);
		q14bPersonsFleeingDomesticViolenceTableBean
				.setQ14bDKRUnknownHouseholdType(q14bDKRUnknownHouseholdType);

		q14bPersonsFleeingDomesticViolenceTableBean
				.setQ14bInformationMissingTotal(q14bInformationMissingTotal);
		q14bPersonsFleeingDomesticViolenceTableBean
				.setQ14bInformationMissingWithoutChildren(q14bInformationMissingWithoutChildren);
		q14bPersonsFleeingDomesticViolenceTableBean
				.setQ14bInformationMissingWithChildAndAdults(q14bInformationMissingWithChildAndAdults);
		q14bPersonsFleeingDomesticViolenceTableBean
				.setQ14bInformationMissingWithOnlyChildren(q14bInformationMissingWithOnlyChildren);
		q14bPersonsFleeingDomesticViolenceTableBean
				.setQ14bInformationMissingUnknownHouseholdType(q14bInformationMissingUnknownHouseholdType);

		q14bPersonsFleeingDomesticViolenceTableBean
				.setQ14bTotalSummed(q14bTotalSummed);
		q14bPersonsFleeingDomesticViolenceTableBean
				.setQ14bTotalWithoutChildren(q14bTotalWithoutChildren);
		q14bPersonsFleeingDomesticViolenceTableBean
				.setQ14bTotalWithChildAndAdults(q14bTotalWithChildAndAdults);
		q14bPersonsFleeingDomesticViolenceTableBean
				.setQ14bTotalWithOnlychildren(q14bTotalWithOnlychildren);
		q14bPersonsFleeingDomesticViolenceTableBean
				.setQ14bTotalUnknowHousehold(q14bTotalUnknowHousehold);

		return q14bPersonsFleeingDomesticViolenceTableBean;
	}

	public static DataBean q15ResidencePriorToProgramEntryBeanPublic(
			BigInteger q15HomeLessSituationsTotal,
			BigInteger q15HomeLessSituationsWithoutChildren,
			BigInteger q15HomeLessSituationWithChildAndAdult,
			BigInteger q15HomeLessSituationsWithChildOnly,
			BigInteger q15HomeLessSituationsUnknownHouseHold,
			BigInteger q15EmergencyShelterTotal,
			BigInteger q15EmergencyShelterWithoutChildren,
			BigInteger q15EmergencyShelterWithChildAndAdult,
			BigInteger q15EmergencyShelterWithChildOnly,
			BigInteger q15EmergencyShelterUnknownHouseHold,
			BigInteger q15TransitionalHousingForhomelessTotal,
			BigInteger q15TransitionalHousingForhomelessWithoutChildren,
			BigInteger q15TransitionalHousingForhomelessWithChildAndAdult,
			BigInteger q15TransitionalHousingForhomelessWithChildOnly,
			BigInteger q15TransitionalHousingForhomelessUnknownHouseHold,
			BigInteger q15PlaceNotMeantTotal,
			BigInteger q15PlaceNotMeantWithoutChildren,
			BigInteger q15PlaceNotMeantWithChildAndAdult,
			BigInteger q15PlaceNotMeantWithChildOnly,
			BigInteger q15PlaceNotMeantsUnknownHouseHold,
			BigInteger q15SafeHeavenTotal,
			BigInteger q15SafeHeavenWithoutChildren,
			BigInteger q15SafeHeavenWithChildAndAdult,
			BigInteger q15SafeHeavenWithChildOnly,
			BigInteger q15SafeHeavenUnknownHouseHold,
			BigInteger q15AzTotalSummed, BigInteger q15AzTotalWithoutChildren,
			BigInteger q15AzTotalWithChildAndAdult,
			BigInteger q15AzTotalWithChildOnly,
			BigInteger q15AzTotalUnknownHouseHold,
			BigInteger q15InstitutionalSettingsTotal,
			BigInteger q15InstitutionalSettingsWithoutChildren,
			BigInteger q15InstitutionalSettingsWithChildandAdult,
			BigInteger q15InstitutionalSettingsWithChildOnly,
			BigInteger q15InstitutionalSettingsUnknowHouseHold,
			BigInteger q15PsychiatricFacilityTotal,
			BigInteger q15PsychiatricFacilityWithoutChildren,
			BigInteger q15PsychiatricFacilityWithChildandAdult,
			BigInteger q15PsychiatricFacilityWithChildOnly,
			BigInteger q15PsychiatricFacilityUnknownhouseHold,
			BigInteger q15SubstanceAbuseTotal,
			BigInteger q15SubstanceAbuseWithoutChildren,
			BigInteger q15SubstanceAbuseWithChildandAdult,
			BigInteger q15SubstanceAbuseWithChildOnly,
			BigInteger q15SubstanceAbuseUnknowHouseHold,
			BigInteger q15HospitalNonPhychiatricTotal,
			BigInteger q15HospitalNonPhychiatricWithoutChild,
			BigInteger q15HospitalNonPhychiatricWithChildandAdult,
			BigInteger q15HospitalNonPhychiatricWithChildOnly,
			BigInteger q15HospitalNonPhychiatricUnknownHouseHold,
			BigInteger q15JailPrisonTotal,
			BigInteger q15JailPrisonWithoutChild,
			BigInteger q15JailPrisonWithChildandAdult,
			BigInteger q15JailPrisonWithChildOnly,
			BigInteger q15JailPrisonUnknowHouseHold,
			BigInteger q15FosterCarehomeTotal,
			BigInteger q15FosterCarehomeWithoutChild,
			BigInteger q15FosterCarehomeWithChildandAdult,
			BigInteger q15FosterCarehomeWithChildOnly,
			BigInteger q15FosterCarehomeUnknownHouseHold,
			BigInteger q15LongTermCareFacilityTotal,
			BigInteger q15LongTermCareFacilityWithoutChild,
			BigInteger q15LongTermCareFacilityWithChildandAdult,
			BigInteger q15LongTermCareFacilityWithChildOnly,
			BigInteger q15LongTermCareFacilityUnknowHouseHold,
			BigInteger q15ResidentialProjectTotal,
			BigInteger q15ResidentialProjectWithoutChild,
			BigInteger q15ResidentialProjectWithChildandAdult,
			BigInteger q15ResidentialProjectWithChildOnly,
			BigInteger q15ResidentialProjectUnknownHouseHold,
			BigInteger q15BzTotalSummed, BigInteger q15BzTotalWithoutChild,
			BigInteger q15BzTotalWithChildandAdult,
			BigInteger q15BzTotalWithChildOnly,
			BigInteger q15BzTotalUnknowHousehold,
			BigInteger q15OtherLocationTotal,
			BigInteger q15OtherLocationWithoutChild,
			BigInteger q15OtherLocationWithChildandAdult,
			BigInteger q15OtherLocationWithChildOnly,
			BigInteger q15OtherLocationUnkownHousehold,
			BigInteger q15PSHforHomelessPersonsTotal,
			BigInteger q15PSHforHomelessPersonsWithoutChild,
			BigInteger q15PSHforHomelessPersonsWithChilandAdult,
			BigInteger q15PSHforHomelessPersonsWithChildOnly,
			BigInteger q15PSHforHomelessPersonsUnknowHousehold,
			BigInteger q15OwnedByclientNoSubsidyTotal,
			BigInteger q15OwnedByclientNoSubsidyWithoutchild,
			BigInteger q15OwnedByclientNoSubsidyWithChildandAdult,
			BigInteger q15OwnedByclientNoSubsidyWithChildOnly,
			BigInteger q15OwnedByclientNoSubsidyUnknowHousehold,
			BigInteger q15OwnedByclientWithSubsidyTotal,
			BigInteger q15OwnedByclientWithSubsidyWithoutchild,
			BigInteger q15OwnedByclientWithSubsidyWithChildandAdult,
			BigInteger q15OwnedByclientWithSubsidyWithChildOnly,
			BigInteger q15OwnedByclientWithSubsidyUnknowHousehold,
			BigInteger q15RentalByClientNoSubsidyTotal,
			BigInteger q15RentalByClientNoSubsidyWithoutChild,
			BigInteger q15RentalByClientNoSubsidyWithChildandAdult,
			BigInteger q15RentalByClientNoSubsidyWithchildOnly,
			BigInteger q15RentalByClientNoSubsidyUnknownHousehold,
			BigInteger q15RentalByClientWithVASHSubsidyTotal,
			BigInteger q15RentalByClientWithVASHSubsidyWithoutChild,
			BigInteger q15RentalByClientWithVASHSubsidyWithchildandAdult,
			BigInteger q15RentalByClientWithVASHSubsidyWithChildOnly,
			BigInteger q15RentalByClientWithVASHSubsidyUnknownHousehold,
			BigInteger q15RentalByClientWithGPDTIPSubsidyTotal,
			BigInteger q15RentalByClientWithGPDTIPSubsidyWithoutChild,
			BigInteger q15RentalByClientWithGPDTIPSubsidyWithchildandAdult,
			BigInteger q15RentalByClientWithGPDTIPSubsidyWithChildOnly,
			BigInteger q15RentalByClientWithGPDTIPSubsidyUnknownHousehold,
			BigInteger q15RentalByClientWithOtherSubsidyTotal,
			BigInteger q15RentalByClientWithOtherSubsidyWithoutChild,
			BigInteger q15RentalByClientWithOtherSubsidyWithChildandAdult,
			BigInteger q15RentalByClientWithOtherSubsidyWithChildOnly,
			BigInteger q15RentalByClientWithOtherSubsidyUnknowHousehold,
			BigInteger q15HotelOrMotelTotal,
			BigInteger q15HotelOrMotelWithoutChild,
			BigInteger q15HotelOrMotelWithChidandAdult,
			BigInteger q15HotelOrMotelWithChildOnly,
			BigInteger q15HotelOrMotelUnkownHousehold,
			BigInteger q15StayingOrLivingWithFriendsTotal,
			BigInteger q15StayingOrLivingWithFriendsWithoutChild,
			BigInteger q15StayingOrLivingWithFriendsWithChildandAdult,
			BigInteger q15StayingOrLivingWithFriendsWithChildOnly,
			BigInteger q15StayingOrLivingWithFriendsUnknownHousehold,
			BigInteger q15StayingOrLivingWithFamilyTotal,
			BigInteger q15StayingOrLivingWithFamilyWithoutChild,
			BigInteger q15StayingOrLivingWithFamilyWithChildandAdult,
			BigInteger q15StayingOrLivingWithFamilyWithChildOnly,
			BigInteger q15StayingOrLivingWithFamilyUnknownHousehold,
			BigInteger q15OtherTotal, BigInteger q15OtherWithoutChild,
			BigInteger q15OtherWithChildandAdult,
			BigInteger q15OtherWithChildOnly,
			BigInteger q15OtherUnknownHousehold,
			BigInteger q15DontRefusedTotal,
			BigInteger q15DontRefusedWithoutChild,
			BigInteger q15DontRefusedWithChildandAdult,
			BigInteger q15DontRefusedWithChildOnly,
			BigInteger q15DontRefusedUnknownHousehold,
			BigInteger q15InformationMissingTotal,
			BigInteger q15InformationMissingWithoutChild,
			BigInteger q15InformationMissingWithChildandAdult,
			BigInteger q15InformationMissingwithChildOnly,
			BigInteger q15InformationMissingUnknownHousehold,
			BigInteger q15CzTotalSummed, BigInteger q15CzTotalWithoutChild,
			BigInteger q15CzTotalWithChildandAdult,
			BigInteger q15CzTotalWithChildOnly,
			BigInteger q15CzTotalUnknownHousehold, BigInteger q15dTotalSummed,
			BigInteger q15dTotalWithoutChild,
			BigInteger q15dTotalWithChildandAdult,
			BigInteger q15dTotalWithChildOnly,
			BigInteger q15dTotalUnknownHousehold,
			DataBean q15ResidencePriorToProgramEntrTableBean) {

		q15ResidencePriorToProgramEntrTableBean
				.setQ15HomeLessSituationsTotal(q15HomeLessSituationsTotal);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15HomeLessSituationsWithoutChildren(q15HomeLessSituationsWithoutChildren);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15HomeLessSituationWithChildAndAdult(q15HomeLessSituationWithChildAndAdult);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15HomeLessSituationsWithChildOnly(q15HomeLessSituationsWithChildOnly);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15HomeLessSituationsUnknownHouseHold(q15HomeLessSituationsUnknownHouseHold);

		q15ResidencePriorToProgramEntrTableBean
				.setQ15EmergencyShelterTotal(q15EmergencyShelterTotal);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15EmergencyShelterWithoutChildren(q15EmergencyShelterWithoutChildren);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15EmergencyShelterWithChildAndAdult(q15EmergencyShelterWithChildAndAdult);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15EmergencyShelterWithChildOnly(q15EmergencyShelterWithChildOnly);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15EmergencyShelterUnknownHouseHold(q15EmergencyShelterUnknownHouseHold);

		q15ResidencePriorToProgramEntrTableBean
				.setQ15TransitionalHousingForhomelessTotal(q15TransitionalHousingForhomelessTotal);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15TransitionalHousingForhomelessWithoutChildren(q15TransitionalHousingForhomelessWithoutChildren);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15TransitionalHousingForhomelessWithChildAndAdult(q15TransitionalHousingForhomelessWithChildAndAdult);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15TransitionalHousingForhomelessWithChildOnly(q15TransitionalHousingForhomelessWithChildOnly);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15TransitionalHousingForhomelessUnknownHouseHold(q15TransitionalHousingForhomelessUnknownHouseHold);

		q15ResidencePriorToProgramEntrTableBean
				.setQ15PlaceNotMeantTotal(q15PlaceNotMeantTotal);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15PlaceNotMeantWithoutChildren(q15PlaceNotMeantWithoutChildren);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15PlaceNotMeantWithChildAndAdult(q15PlaceNotMeantWithChildAndAdult);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15PlaceNotMeantWithChildOnly(q15PlaceNotMeantWithChildOnly);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15PlaceNotMeantsUnknownHouseHold(q15PlaceNotMeantsUnknownHouseHold);

		q15ResidencePriorToProgramEntrTableBean
				.setQ15SafeHeavenTotal(q15SafeHeavenTotal);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15SafeHeavenWithoutChildren(q15SafeHeavenWithoutChildren);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15SafeHeavenWithChildAndAdult(q15SafeHeavenWithChildAndAdult);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15SafeHeavenWithChildOnly(q15SafeHeavenWithChildOnly);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15SafeHeavenUnknownHouseHold(q15SafeHeavenUnknownHouseHold);

		q15ResidencePriorToProgramEntrTableBean
				.setQ15AzTotalSummed(q15AzTotalSummed);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15AzTotalWithoutChildren(q15AzTotalWithoutChildren);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15AzTotalWithChildAndAdult(q15AzTotalWithChildAndAdult);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15AzTotalWithChildOnly(q15AzTotalWithChildOnly);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15AzTotalUnknownHouseHold(q15AzTotalUnknownHouseHold);

		q15ResidencePriorToProgramEntrTableBean
				.setQ15InstitutionalSettingsTotal(q15InstitutionalSettingsTotal);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15InstitutionalSettingsWithoutChildren(q15InstitutionalSettingsWithoutChildren);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15InstitutionalSettingsWithChildandAdult(q15InstitutionalSettingsWithChildandAdult);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15InstitutionalSettingsWithChildOnly(q15InstitutionalSettingsWithChildOnly);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15InstitutionalSettingsUnknowHouseHold(q15InstitutionalSettingsUnknowHouseHold);

		q15ResidencePriorToProgramEntrTableBean
				.setQ15PsychiatricFacilityTotal(q15PsychiatricFacilityTotal);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15PsychiatricFacilityWithoutChildren(q15PsychiatricFacilityWithoutChildren);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15PsychiatricFacilityWithChildandAdult(q15PsychiatricFacilityWithChildandAdult);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15PsychiatricFacilityWithChildOnly(q15PsychiatricFacilityWithChildOnly);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15PsychiatricFacilityUnknownhouseHold(q15PsychiatricFacilityUnknownhouseHold);

		q15ResidencePriorToProgramEntrTableBean
				.setQ15SubstanceAbuseTotal(q15SubstanceAbuseTotal);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15SubstanceAbuseWithoutChildren(q15SubstanceAbuseWithoutChildren);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15SubstanceAbuseWithChildandAdult(q15SubstanceAbuseWithChildandAdult);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15SubstanceAbuseWithChildOnly(q15SubstanceAbuseWithChildOnly);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15SubstanceAbuseUnknowHouseHold(q15SubstanceAbuseUnknowHouseHold);

		q15ResidencePriorToProgramEntrTableBean
				.setQ15HospitalNonPhychiatricTotal(q15HospitalNonPhychiatricTotal);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15HospitalNonPhychiatricWithoutChild(q15HospitalNonPhychiatricWithoutChild);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15HospitalNonPhychiatricWithChildOnly(q15HospitalNonPhychiatricWithChildOnly);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15HospitalNonPhychiatricWithChildandAdult(q15HospitalNonPhychiatricWithChildandAdult);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15HospitalNonPhychiatricUnknownHouseHold(q15HospitalNonPhychiatricUnknownHouseHold);

		q15ResidencePriorToProgramEntrTableBean
				.setQ15JailPrisonTotal(q15JailPrisonTotal);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15JailPrisonWithoutChild(q15JailPrisonWithoutChild);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15JailPrisonWithChildandAdult(q15JailPrisonWithChildandAdult);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15JailPrisonWithChildOnly(q15JailPrisonWithChildOnly);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15JailPrisonUnknowHouseHold(q15JailPrisonUnknowHouseHold);

		q15ResidencePriorToProgramEntrTableBean
				.setQ15FosterCarehomeTotal(q15FosterCarehomeTotal);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15FosterCarehomeWithoutChild(q15FosterCarehomeWithoutChild);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15FosterCarehomeWithChildandAdult(q15FosterCarehomeWithChildandAdult);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15FosterCarehomeWithChildOnly(q15FosterCarehomeWithChildOnly);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15FosterCarehomeUnknownHouseHold(q15FosterCarehomeUnknownHouseHold);

		q15ResidencePriorToProgramEntrTableBean
				.setQ15LongTermCareFacilityTotal(q15LongTermCareFacilityTotal);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15LongTermCareFacilityWithoutChild(q15LongTermCareFacilityWithoutChild);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15LongTermCareFacilityWithChildandAdult(q15LongTermCareFacilityWithChildandAdult);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15LongTermCareFacilityWithChildOnly(q15LongTermCareFacilityWithChildOnly);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15LongTermCareFacilityUnknowHouseHold(q15LongTermCareFacilityUnknowHouseHold);

		q15ResidencePriorToProgramEntrTableBean
				.setQ15ResidentialProjectTotal(q15ResidentialProjectTotal);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15ResidentialProjectWithoutChild(q15ResidentialProjectWithoutChild);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15ResidentialProjectWithChildandAdult(q15ResidentialProjectWithChildandAdult);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15ResidentialProjectWithChildOnly(q15ResidentialProjectWithChildOnly);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15ResidentialProjectUnknownHouseHold(q15ResidentialProjectUnknownHouseHold);

		q15ResidencePriorToProgramEntrTableBean
				.setQ15BzTotalSummed(q15BzTotalSummed);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15BzTotalWithoutChild(q15BzTotalWithoutChild);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15BzTotalWithChildandAdult(q15BzTotalWithChildandAdult);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15BzTotalWithChildOnly(q15BzTotalWithChildOnly);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15BzTotalUnknowHousehold(q15BzTotalUnknowHousehold);

		q15ResidencePriorToProgramEntrTableBean
				.setQ15OtherLocationTotal(q15OtherLocationTotal);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15OtherLocationWithoutChild(q15OtherLocationWithoutChild);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15OtherLocationWithChildandAdult(q15OtherLocationWithChildandAdult);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15OtherLocationWithChildOnly(q15OtherLocationWithChildOnly);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15OtherLocationUnkownHousehold(q15OtherLocationUnkownHousehold);

		q15ResidencePriorToProgramEntrTableBean
				.setQ15PSHforHomelessPersonsTotal(q15PSHforHomelessPersonsTotal);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15PSHforHomelessPersonsWithoutChild(q15PSHforHomelessPersonsWithoutChild);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15PSHforHomelessPersonsWithChilandAdult(q15PSHforHomelessPersonsWithChilandAdult);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15PSHforHomelessPersonsWithChildOnly(q15PSHforHomelessPersonsWithChildOnly);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15PSHforHomelessPersonsUnknowHousehold(q15PSHforHomelessPersonsUnknowHousehold);

		q15ResidencePriorToProgramEntrTableBean
				.setQ15OwnedByclientNoSubsidyTotal(q15OwnedByclientNoSubsidyTotal);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15OwnedByclientNoSubsidyWithoutchild(q15OwnedByclientNoSubsidyWithoutchild);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15OwnedByclientNoSubsidyWithChildandAdult(q15OwnedByclientNoSubsidyWithChildandAdult);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15OwnedByclientNoSubsidyWithChildOnly(q15OwnedByclientNoSubsidyWithChildOnly);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15OwnedByclientNoSubsidyUnknowHousehold(q15OwnedByclientNoSubsidyUnknowHousehold);

		q15ResidencePriorToProgramEntrTableBean
				.setQ15OwnedByclientWithSubsidyTotal(q15OwnedByclientWithSubsidyTotal);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15OwnedByclientWithSubsidyWithoutchild(q15OwnedByclientWithSubsidyWithoutchild);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15OwnedByclientWithSubsidyWithChildandAdult(q15OwnedByclientWithSubsidyWithChildandAdult);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15OwnedByclientWithSubsidyWithChildOnly(q15OwnedByclientWithSubsidyWithChildOnly);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15OwnedByclientWithSubsidyUnknowHousehold(q15OwnedByclientWithSubsidyUnknowHousehold);

		q15ResidencePriorToProgramEntrTableBean
				.setQ15RentalByClientNoSubsidyTotal(q15RentalByClientNoSubsidyTotal);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15RentalByClientNoSubsidyWithoutChild(q15RentalByClientNoSubsidyWithoutChild);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15RentalByClientNoSubsidyWithChildandAdult(q15RentalByClientNoSubsidyWithChildandAdult);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15RentalByClientNoSubsidyWithchildOnly(q15RentalByClientNoSubsidyWithchildOnly);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15RentalByClientNoSubsidyUnknownHousehold(q15RentalByClientNoSubsidyUnknownHousehold);

		q15ResidencePriorToProgramEntrTableBean
				.setQ15RentalByClientWithVASHSubsidyTotal(q15RentalByClientWithVASHSubsidyTotal);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15RentalByClientWithVASHSubsidyWithoutChild(q15RentalByClientWithVASHSubsidyWithoutChild);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15RentalByClientWithVASHSubsidyWithChildOnly(q15RentalByClientWithVASHSubsidyWithChildOnly);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15RentalByClientWithVASHSubsidyWithchildandAdult(q15RentalByClientWithVASHSubsidyWithchildandAdult);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15RentalByClientWithVASHSubsidyUnknownHousehold(q15RentalByClientWithVASHSubsidyUnknownHousehold);

		q15ResidencePriorToProgramEntrTableBean
				.setQ15RentalByClientWithGPDTIPSubsidyTotal(q15RentalByClientWithGPDTIPSubsidyTotal);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15RentalByClientWithGPDTIPSubsidyWithoutChild(q15RentalByClientWithGPDTIPSubsidyWithoutChild);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15RentalByClientWithGPDTIPSubsidyWithchildandAdult(q15RentalByClientWithGPDTIPSubsidyWithchildandAdult);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15RentalByClientWithGPDTIPSubsidyWithChildOnly(q15RentalByClientWithGPDTIPSubsidyWithChildOnly);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15RentalByClientWithGPDTIPSubsidyUnknownHousehold(q15RentalByClientWithGPDTIPSubsidyUnknownHousehold);

		q15ResidencePriorToProgramEntrTableBean
				.setQ15RentalByClientWithOtherSubsidyTotal(q15RentalByClientWithOtherSubsidyTotal);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15RentalByClientWithOtherSubsidyWithoutChild(q15RentalByClientWithOtherSubsidyWithoutChild);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15RentalByClientWithOtherSubsidyWithChildandAdult(q15RentalByClientWithOtherSubsidyWithChildandAdult);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15RentalByClientWithOtherSubsidyWithChildOnly(q15RentalByClientWithOtherSubsidyWithChildOnly);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15RentalByClientWithOtherSubsidyUnknowHousehold(q15RentalByClientWithOtherSubsidyUnknowHousehold);

		q15ResidencePriorToProgramEntrTableBean
				.setQ15HotelOrMotelTotal(q15HotelOrMotelTotal);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15HotelOrMotelWithoutChild(q15HotelOrMotelWithoutChild);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15HotelOrMotelWithChildOnly(q15HotelOrMotelWithChildOnly);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15HotelOrMotelWithChidandAdult(q15HotelOrMotelWithChidandAdult);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15HotelOrMotelUnkownHousehold(q15HotelOrMotelUnkownHousehold);

		q15ResidencePriorToProgramEntrTableBean
				.setQ15StayingOrLivingWithFriendsTotal(q15StayingOrLivingWithFriendsTotal);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15StayingOrLivingWithFriendsWithoutChild(q15StayingOrLivingWithFriendsWithoutChild);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15StayingOrLivingWithFriendsWithChildandAdult(q15StayingOrLivingWithFriendsWithChildandAdult);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15StayingOrLivingWithFriendsWithChildOnly(q15StayingOrLivingWithFriendsWithChildOnly);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15StayingOrLivingWithFriendsUnknownHousehold(q15StayingOrLivingWithFriendsUnknownHousehold);

		q15ResidencePriorToProgramEntrTableBean
				.setQ15StayingOrLivingWithFamilyTotal(q15StayingOrLivingWithFamilyTotal);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15StayingOrLivingWithFamilyWithoutChild(q15StayingOrLivingWithFamilyWithoutChild);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15StayingOrLivingWithFamilyWithChildandAdult(q15StayingOrLivingWithFamilyWithChildandAdult);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15StayingOrLivingWithFamilyWithChildOnly(q15StayingOrLivingWithFamilyWithChildOnly);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15StayingOrLivingWithFamilyUnknownHousehold(q15StayingOrLivingWithFamilyUnknownHousehold);

		q15ResidencePriorToProgramEntrTableBean.setQ15OtherTotal(q15OtherTotal);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15OtherWithoutChild(q15OtherWithoutChild);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15OtherWithChildandAdult(q15OtherWithChildandAdult);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15OtherWithChildOnly(q15OtherWithChildOnly);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15OtherUnknownHousehold(q15OtherUnknownHousehold);

		q15ResidencePriorToProgramEntrTableBean
				.setQ15DontRefusedTotal(q15DontRefusedTotal);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15DontRefusedWithoutChild(q15DontRefusedWithoutChild);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15DontRefusedWithChildandAdult(q15DontRefusedWithChildandAdult);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15DontRefusedWithChildOnly(q15DontRefusedWithChildOnly);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15DontRefusedUnknownHousehold(q15DontRefusedUnknownHousehold);

		q15ResidencePriorToProgramEntrTableBean
				.setQ15InformationMissingTotal(q15InformationMissingTotal);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15InformationMissingWithoutChild(q15InformationMissingWithoutChild);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15InformationMissingUnknownHousehold(q15InformationMissingUnknownHousehold);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15InformationMissingWithChildandAdult(q15InformationMissingWithChildandAdult);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15InformationMissingwithChildOnly(q15InformationMissingwithChildOnly);

		q15ResidencePriorToProgramEntrTableBean
				.setQ15CzTotalSummed(q15CzTotalSummed);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15CzTotalWithoutChild(q15CzTotalWithoutChild);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15CzTotalWithChildOnly(q15CzTotalWithChildOnly);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15CzTotalWithChildandAdult(q15CzTotalWithChildandAdult);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15CzTotalUnknownHousehold(q15CzTotalUnknownHousehold);

		q15ResidencePriorToProgramEntrTableBean
				.setQ15DTotalSummed(q15dTotalSummed);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15DTotalWithoutChild(q15dTotalWithoutChild);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15DTotalWithChildandAdult(q15dTotalWithChildandAdult);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15DTotalWithChildOnly(q15dTotalWithChildOnly);
		q15ResidencePriorToProgramEntrTableBean
				.setQ15DTotalUnknownHousehold(q15dTotalUnknownHousehold);

		return q15ResidencePriorToProgramEntrTableBean;
	}

	public static DataBean q16CashIncomeRangesTableBean(
			BigInteger q16NoIncomeIncomeAtEntry,
			BigInteger q16NoIncomeIncomeAtLatestFollowupforStayers,
			BigInteger q16NoIncomeIncomeAtExitforLeavers,
			BigInteger q161To150IncomeAtEntry,
			BigInteger q161To150IncomeAtLatestFollowupforStayers,
			BigInteger q161To150IncomeAtExitforLeavers,
			BigInteger q16151To250IncomeAtEntry,
			BigInteger q16151To250IncomeAtLatestFollowupforStayers,
			BigInteger q16151To250IncomeAtExitforLeavers,
			BigInteger q16251To500IncomeAtEntry,
			BigInteger q16251To500IncomeAtLatestFollowupforStayers,
			BigInteger q16251To500IncomeAtExitforLeavers,
			BigInteger q16501To1000IncomeAtEntry,
			BigInteger q16501To1000IncomeAtLatestFollowupforStayers,
			BigInteger q16501To1000IncomeAtExitforLeavers,
			BigInteger q161001To1500IncomeAtEntry,
			BigInteger q161001To1500IncomeAtLatestFollowupforStayers,
			BigInteger q161001To1500IncomeAtExitforLeavers,
			BigInteger q161501To2000IncomeAtEntry,
			BigInteger q161501To2000IncomeAtLatestFollowupforStayers,
			BigInteger q161501To2000IncomeAtExitforLeavers,
			BigInteger q162000PlusIncomeAtEntry,
			BigInteger q162000PlusIncomeAtLatestFollowupforStayers,
			BigInteger q162000PlusIncomeAtExitforLeavers,
			BigInteger q16ClientDoesntKnowIncomeAtEntry,
			BigInteger q16ClientDoesntKnowIncomeAtLatestFollowupforStayers,
			BigInteger q16ClientDoesntKnowIncomeAtExitforLeavers,
			BigInteger q16DataNotCollectedIncomeAtEntry,
			BigInteger q16DataNotCollectedIncomeAtLatestFollowupforStayers,
			BigInteger q16DataNotCollectedIncomeAtExitforLeavers,
			BigInteger q16NumberOfAdultStayersNotYetRequiredIncomeAtEntry,
			BigInteger q16NumberOfAdultStayersNotYetRequiredIncomeAtLatestFollowupforStayers,
			BigInteger q16NumberOfAdultStayersNotYetRequiredIncomeAtExitforLeavers,
			BigInteger q16NumberOfAdultStayersWithoutRequiredIncomeAtEntry,
			BigInteger q16NumberOfAdultStayersWithoutRequiredIncomeAtLatestFollowupforStayers,
			BigInteger q16NumberOfAdultStayersWithoutRequiredIncomeAtExitforLeavers,
			BigInteger q16TotalAdultsIncomeAtEntry,
			BigInteger q16TotalAdultsIncomeAtLatestFollowupforStayers,
			BigInteger q16TotalAdultsIncomeAtExitforLeavers,
			DataBean q16CashIncomeRangesTableBean) {

		q16CashIncomeRangesTableBean
				.setQ16NoIncomeIncomeAtEntry(q16NoIncomeIncomeAtEntry);
		q16CashIncomeRangesTableBean
				.setQ16NoIncomeIncomeAtExitforLeavers(q16NoIncomeIncomeAtExitforLeavers);
		q16CashIncomeRangesTableBean
				.setQ16NoIncomeIncomeAtLatestFollowupforStayers(q16NoIncomeIncomeAtLatestFollowupforStayers);

		q16CashIncomeRangesTableBean
				.setQ161To150IncomeAtEntry(q161To150IncomeAtEntry);
		q16CashIncomeRangesTableBean
				.setQ161To150IncomeAtExitforLeavers(q161To150IncomeAtExitforLeavers);
		q16CashIncomeRangesTableBean
				.setQ161To150IncomeAtLatestFollowupforStayers(q161To150IncomeAtLatestFollowupforStayers);

		q16CashIncomeRangesTableBean
				.setQ16151To250IncomeAtEntry(q16151To250IncomeAtEntry);
		q16CashIncomeRangesTableBean
				.setQ16151To250IncomeAtExitforLeavers(q16151To250IncomeAtExitforLeavers);
		q16CashIncomeRangesTableBean
				.setQ16151To250IncomeAtLatestFollowupforStayers(q16151To250IncomeAtLatestFollowupforStayers);

		q16CashIncomeRangesTableBean
				.setQ16251To500IncomeAtEntry(q16251To500IncomeAtEntry);
		q16CashIncomeRangesTableBean
				.setQ16251To500IncomeAtExitforLeavers(q16251To500IncomeAtExitforLeavers);
		q16CashIncomeRangesTableBean
				.setQ16251To500IncomeAtLatestFollowupforStayers(q16251To500IncomeAtLatestFollowupforStayers);

		q16CashIncomeRangesTableBean
				.setQ16501To1000IncomeAtEntry(q16501To1000IncomeAtEntry);
		q16CashIncomeRangesTableBean
				.setQ16501To1000IncomeAtExitforLeavers(q16501To1000IncomeAtExitforLeavers);
		q16CashIncomeRangesTableBean
				.setQ16501To1000IncomeAtLatestFollowupforStayers(q16501To1000IncomeAtLatestFollowupforStayers);

		q16CashIncomeRangesTableBean
				.setQ161001To1500IncomeAtEntry(q161001To1500IncomeAtEntry);
		q16CashIncomeRangesTableBean
				.setQ161001To1500IncomeAtExitforLeavers(q161001To1500IncomeAtExitforLeavers);
		q16CashIncomeRangesTableBean
				.setQ161001To1500IncomeAtLatestFollowupforStayers(q161001To1500IncomeAtLatestFollowupforStayers);

		q16CashIncomeRangesTableBean
				.setQ161501To2000IncomeAtEntry(q161501To2000IncomeAtEntry);
		q16CashIncomeRangesTableBean
				.setQ161501To2000IncomeAtExitforLeavers(q161501To2000IncomeAtExitforLeavers);
		q16CashIncomeRangesTableBean
				.setQ161501To2000IncomeAtLatestFollowupforStayers(q161501To2000IncomeAtLatestFollowupforStayers);

		q16CashIncomeRangesTableBean
				.setQ162000PlusIncomeAtEntry(q162000PlusIncomeAtEntry);
		q16CashIncomeRangesTableBean
				.setQ162000PlusIncomeAtExitforLeavers(q162000PlusIncomeAtExitforLeavers);
		q16CashIncomeRangesTableBean
				.setQ162000PlusIncomeAtLatestFollowupforStayers(q162000PlusIncomeAtLatestFollowupforStayers);

		q16CashIncomeRangesTableBean
				.setQ16ClientDoesntKnowIncomeAtEntry(q16ClientDoesntKnowIncomeAtEntry);
		q16CashIncomeRangesTableBean
				.setQ16ClientDoesntKnowIncomeAtExitforLeavers(q16ClientDoesntKnowIncomeAtExitforLeavers);
		q16CashIncomeRangesTableBean
				.setQ16ClientDoesntKnowIncomeAtLatestFollowupforStayers(q16ClientDoesntKnowIncomeAtLatestFollowupforStayers);

		q16CashIncomeRangesTableBean
				.setQ16DataNotCollectedIncomeAtEntry(q16DataNotCollectedIncomeAtEntry);
		q16CashIncomeRangesTableBean
				.setQ16DataNotCollectedIncomeAtExitforLeavers(q16DataNotCollectedIncomeAtExitforLeavers);
		q16CashIncomeRangesTableBean
				.setQ16DataNotCollectedIncomeAtLatestFollowupforStayers(q16DataNotCollectedIncomeAtLatestFollowupforStayers);

		q16CashIncomeRangesTableBean
				.setQ16NumberOfAdultStayersNotYetRequiredIncomeAtEntry(q16NumberOfAdultStayersNotYetRequiredIncomeAtEntry);
		q16CashIncomeRangesTableBean
				.setQ16NumberOfAdultStayersNotYetRequiredIncomeAtExitforLeavers(q16NumberOfAdultStayersNotYetRequiredIncomeAtExitforLeavers);
		q16CashIncomeRangesTableBean
				.setQ16NumberOfAdultStayersNotYetRequiredIncomeAtLatestFollowupforStayers(q16NumberOfAdultStayersNotYetRequiredIncomeAtLatestFollowupforStayers);

		q16CashIncomeRangesTableBean
				.setQ16NumberOfAdultStayersWithoutRequiredIncomeAtEntry(q16NumberOfAdultStayersWithoutRequiredIncomeAtEntry);
		q16CashIncomeRangesTableBean
				.setQ16NumberOfAdultStayersWithoutRequiredIncomeAtExitforLeavers(q16NumberOfAdultStayersWithoutRequiredIncomeAtExitforLeavers);
		q16CashIncomeRangesTableBean
				.setQ16NumberOfAdultStayersWithoutRequiredIncomeAtLatestFollowupforStayers(q16NumberOfAdultStayersWithoutRequiredIncomeAtLatestFollowupforStayers);

		q16CashIncomeRangesTableBean
				.setQ16TotalAdultsIncomeAtEntry(q16TotalAdultsIncomeAtEntry);
		q16CashIncomeRangesTableBean
				.setQ16TotalAdultsIncomeAtExitforLeavers(q16TotalAdultsIncomeAtExitforLeavers);
		q16CashIncomeRangesTableBean
				.setQ16TotalAdultsIncomeAtLatestFollowupforStayers(q16TotalAdultsIncomeAtLatestFollowupforStayers);

		return q16CashIncomeRangesTableBean;

	}

	public static DataBean q19A1ClientCashIncomeChangeIncomeSrcByEntryLatestStatus(
			BigInteger q19a1NoOfAdltsWithEarnedIncomeHadIncomeCategoryAtEntryAndNotHaveFollowup,
			BigInteger q19a1NoOfAdltsWithEarnedIncomeRetainedIncomeCategoryButHadLessDollar,
			BigInteger q19a1NoOfAdltsWithEarnedIncomeRetainedIncomeCategoryAndSameDollar,
			BigInteger q19a1NoOfAdltsWithEarnedIncomeRetainedIncomeCategoryAndIncreasedDollar,
			BigInteger q19a1NoOfAdltsWithEarnedIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome,
			BigInteger q19a1NoOfAdltsWithEarnedIncomeDidNotHaveTheIncomeCategoryAtEntryOrFollowup,
			BigInteger q19a1NoOfAdltsWithEarnedIncomeTotalAdult,
			BigInteger q19a1NoOfAdltsWithEarnedIncomePerformanceMeasures,
			BigInteger q19a1NoOfAdltsWithEarnedIncomePercent,
			BigInteger q19a1AverageChangeInEarnedIncomeHadIncomeCategoryAtEntryAndNotHaveFollowup,
			BigInteger q19a1AverageChangeInEarnedIncomeRetainedIncomeCategoryButHadLessDollar,
			BigInteger q19a1AverageChangeInEarnedIncomeRetainedIncomeCategoryAndSameDollar,
			BigInteger q19a1AverageChangeInEarnedIncomeRetainedIncomeCategoryAndIncreasedDollar,
			BigInteger q19a1AverageChangeInEarnedIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome,
			BigInteger q19a1AverageChangeInEarnedIncomeDidNotHaveTheIncomeCategoryAtEntryOrFollowup,
			BigInteger q19a1AverageChangeInEarnedIncomeTotalAdult,
			BigInteger q19a1AverageChangeInEarnedIncomePerformanceMeasures,
			BigInteger q19a1AverageChangeInEarnedIncomePercent,
			BigInteger q19a1NoOfAdultsWithOtherIncomeHadIncomeCategoryAtEntryAndNotHaveFollowup,
			BigInteger q19a1NoOfAdultsWithOtherIncomeRetainedIncomeCategoryButHadLessDollar,
			BigInteger q19a1NoOfAdultsWithOtherIncomeRetainedIncomeCategoryAndSameDollar,
			BigInteger q19a1NoOfAdultsWithOtherIncomeRetainedIncomeCategoryAndIncreasedDollar,
			BigInteger q19a1NoOfAdultsWithOtherIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome,
			BigInteger q19a1NoOfAdultsWithOtherIncomeDidNotHaveTheIncomeCategoryAtEntryOrFollowup,
			BigInteger q19a1NoOfAdultsWithOtherIncomeTotalAdult,
			BigInteger q19a1NoOfAdultsWithOtherIncomePerformanceMeasures,
			BigInteger q19a1NoOfAdultsWithOtherIncomePercent,
			BigInteger q19a1AverageChangeInOtherIncomeHadIncomeCategoryAtEntryAndNotHaveFollowup,
			BigInteger q19a1AverageChangeInOtherIncomeRetainedIncomeCategoryButHadLessDollar,
			BigInteger q19a1AverageChangeInOtherIncomeRetainedIncomeCategoryAndSameDollar,
			BigInteger q19a1AverageChangeInOtherIncomeRetainedIncomeCategoryAndIncreasedDollar,
			BigInteger q19a1AverageChangeInOtherIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome,
			BigInteger q19a1AverageChangeInOtherIncomeDidNotHaveTheIncomeCategoryAtEntryOrFollowup,
			BigInteger q19a1AverageChangeInOtherIncomeTotalAdult,
			BigInteger q19a1AverageChangeInOtherIncomePerformanceMeasures,
			BigInteger q19a1AverageChangeInOtherIncomePercent,
			BigInteger q19a1NumberOfAdultsWithAnyIncomeHadIncomeCategoryAtEntryAndNotHaveFollowup,
			BigInteger q19a1NumberOfAdultsWithAnyIncomeRetainedIncomeCategoryButHadLessDollar,
			BigInteger q19a1NumberOfAdultsWithAnyIncomeRetainedIncomeCategoryAndSameDollar,
			BigInteger q19a1NumberOfAdultsWithAnyIncomeRetainedIncomeCategoryAndIncreasedDollar,
			BigInteger q19a1NumberOfAdultsWithAnyIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome,
			BigInteger q19a1NumberOfAdultsWithAnyIncomeDidNotHaveTheIncomeCategoryAtEntryOrFollowup,
			BigInteger q19a1NumberOfAdultsWithAnyIncomeTotalAdult,
			BigInteger q19a1NumberOfAdultsWithAnyIncomePerformanceMeasures,
			BigInteger q19a1NumberOfAdultsWithAnyIncomePercent,
			BigInteger q19a1AverageChangeInOverallIncomeHadIncomeCategoryAtEntryAndNotHaveFollowup,
			BigInteger q19a1AverageChangeInOverallIncomeRetainedIncomeCategoryButHadLessDollar,
			BigInteger q19a1AverageChangeInOverallIncomeRetainedIncomeCategoryAndSameDollar,
			BigInteger q19a1AverageChangeInOverallIncomeRetainedIncomeCategoryAndIncreasedDollar,
			BigInteger q19a1AverageChangeInOverallIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome,
			BigInteger q19a1AverageChangeInOverallIncomeDidNotHaveTheIncomeCategoryAtEntryOrFollowup,
			BigInteger q19a1AverageChangeInOverallIncomeTotalAdult,
			BigInteger q19a1AverageChangeInOverallIncomePerformanceMeasures,
			BigInteger q19a1AverageChangeInOverallIncomePercent,
			DataBean q19A1ClientCashIncomeChangeIncomeSourceByEntryAndLatestStatus) {

		q19A1ClientCashIncomeChangeIncomeSourceByEntryAndLatestStatus
				.setQ19a1AverageChangeInEarnedIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome(q19a1AverageChangeInEarnedIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome);
		q19A1ClientCashIncomeChangeIncomeSourceByEntryAndLatestStatus
				.setQ19a1AverageChangeInEarnedIncomeDidNotHaveTheIncomeCategoryAtEntryOrFollowup(q19a1AverageChangeInEarnedIncomeDidNotHaveTheIncomeCategoryAtEntryOrFollowup);
		q19A1ClientCashIncomeChangeIncomeSourceByEntryAndLatestStatus
				.setQ19a1AverageChangeInEarnedIncomeHadIncomeCategoryAtEntryAndNotHaveFollowup(q19a1AverageChangeInEarnedIncomeHadIncomeCategoryAtEntryAndNotHaveFollowup);
		q19A1ClientCashIncomeChangeIncomeSourceByEntryAndLatestStatus
				.setQ19a1AverageChangeInEarnedIncomePercent(q19a1AverageChangeInEarnedIncomePercent);

		q19A1ClientCashIncomeChangeIncomeSourceByEntryAndLatestStatus
				.setQ19a1AverageChangeInEarnedIncomePerformanceMeasures(q19a1AverageChangeInEarnedIncomePerformanceMeasures);
		q19A1ClientCashIncomeChangeIncomeSourceByEntryAndLatestStatus
				.setQ19a1AverageChangeInEarnedIncomeRetainedIncomeCategoryAndIncreasedDollar(q19a1AverageChangeInEarnedIncomeRetainedIncomeCategoryAndIncreasedDollar);
		q19A1ClientCashIncomeChangeIncomeSourceByEntryAndLatestStatus
				.setQ19a1AverageChangeInEarnedIncomeRetainedIncomeCategoryAndSameDollar(q19a1AverageChangeInEarnedIncomeRetainedIncomeCategoryAndSameDollar);
		q19A1ClientCashIncomeChangeIncomeSourceByEntryAndLatestStatus
				.setQ19a1AverageChangeInEarnedIncomeRetainedIncomeCategoryButHadLessDollar(q19a1AverageChangeInEarnedIncomeRetainedIncomeCategoryButHadLessDollar);

		q19A1ClientCashIncomeChangeIncomeSourceByEntryAndLatestStatus
				.setQ19a1AverageChangeInEarnedIncomeTotalAdult(q19a1AverageChangeInEarnedIncomeTotalAdult);
		q19A1ClientCashIncomeChangeIncomeSourceByEntryAndLatestStatus
				.setQ19a1AverageChangeInOtherIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome(q19a1AverageChangeInOtherIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome);
		q19A1ClientCashIncomeChangeIncomeSourceByEntryAndLatestStatus
				.setQ19a1AverageChangeInOtherIncomeDidNotHaveTheIncomeCategoryAtEntryOrFollowup(q19a1AverageChangeInOtherIncomeDidNotHaveTheIncomeCategoryAtEntryOrFollowup);
		q19A1ClientCashIncomeChangeIncomeSourceByEntryAndLatestStatus
				.setQ19a1AverageChangeInOtherIncomeHadIncomeCategoryAtEntryAndNotHaveFollowup(q19a1AverageChangeInOtherIncomeHadIncomeCategoryAtEntryAndNotHaveFollowup);
		q19A1ClientCashIncomeChangeIncomeSourceByEntryAndLatestStatus
				.setQ19a1AverageChangeInOtherIncomePercent(q19a1AverageChangeInOtherIncomePercent);

		q19A1ClientCashIncomeChangeIncomeSourceByEntryAndLatestStatus
				.setQ19a1AverageChangeInOverallIncomeDidNotHaveTheIncomeCategoryAtEntryOrFollowup(q19a1AverageChangeInOverallIncomeDidNotHaveTheIncomeCategoryAtEntryOrFollowup);
		q19A1ClientCashIncomeChangeIncomeSourceByEntryAndLatestStatus
				.setQ19a1AverageChangeInOverallIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome(q19a1AverageChangeInOverallIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome);
		q19A1ClientCashIncomeChangeIncomeSourceByEntryAndLatestStatus
				.setQ19a1AverageChangeInOverallIncomeHadIncomeCategoryAtEntryAndNotHaveFollowup(q19a1AverageChangeInOverallIncomeHadIncomeCategoryAtEntryAndNotHaveFollowup);
		q19A1ClientCashIncomeChangeIncomeSourceByEntryAndLatestStatus
				.setQ19a1AverageChangeInOverallIncomePerformanceMeasures(q19a1AverageChangeInOverallIncomePerformanceMeasures);
		q19A1ClientCashIncomeChangeIncomeSourceByEntryAndLatestStatus
				.setQ19a1AverageChangeInOverallIncomeRetainedIncomeCategoryAndIncreasedDollar(q19a1AverageChangeInOverallIncomeRetainedIncomeCategoryAndIncreasedDollar);
		q19A1ClientCashIncomeChangeIncomeSourceByEntryAndLatestStatus
				.setQ19a1AverageChangeInOverallIncomeRetainedIncomeCategoryAndSameDollar(q19a1AverageChangeInOverallIncomeRetainedIncomeCategoryAndSameDollar);
		q19A1ClientCashIncomeChangeIncomeSourceByEntryAndLatestStatus
				.setQ19a1AverageChangeInOverallIncomeRetainedIncomeCategoryButHadLessDollar(q19a1AverageChangeInOverallIncomeRetainedIncomeCategoryButHadLessDollar);
		q19A1ClientCashIncomeChangeIncomeSourceByEntryAndLatestStatus
				.setQ19a1AverageChangeInOtherIncomeTotalAdult(q19a1AverageChangeInOtherIncomeTotalAdult);
		q19A1ClientCashIncomeChangeIncomeSourceByEntryAndLatestStatus
				.setQ19a1NoOfAdltsWithEarnedIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome(q19a1NoOfAdltsWithEarnedIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome);
		q19A1ClientCashIncomeChangeIncomeSourceByEntryAndLatestStatus
				.setQ19a1NoOfAdltsWithEarnedIncomeDidNotHaveTheIncomeCategoryAtEntryOrFollowup(q19a1NoOfAdltsWithEarnedIncomeDidNotHaveTheIncomeCategoryAtEntryOrFollowup);
		q19A1ClientCashIncomeChangeIncomeSourceByEntryAndLatestStatus
				.setQ19a1NoOfAdltsWithEarnedIncomeHadIncomeCategoryAtEntryAndNotHaveFollowup(q19a1NoOfAdltsWithEarnedIncomeHadIncomeCategoryAtEntryAndNotHaveFollowup);
		q19A1ClientCashIncomeChangeIncomeSourceByEntryAndLatestStatus
				.setQ19a1NoOfAdltsWithEarnedIncomePercent(q19a1NoOfAdltsWithEarnedIncomePercent);
		q19A1ClientCashIncomeChangeIncomeSourceByEntryAndLatestStatus
				.setQ19a1NoOfAdltsWithEarnedIncomePerformanceMeasures(q19a1NoOfAdltsWithEarnedIncomePerformanceMeasures);
		q19A1ClientCashIncomeChangeIncomeSourceByEntryAndLatestStatus
				.setQ19a1NoOfAdltsWithEarnedIncomeRetainedIncomeCategoryAndIncreasedDollar(q19a1NoOfAdltsWithEarnedIncomeRetainedIncomeCategoryAndIncreasedDollar);
		q19A1ClientCashIncomeChangeIncomeSourceByEntryAndLatestStatus
				.setQ19a1NoOfAdltsWithEarnedIncomeRetainedIncomeCategoryAndSameDollar(q19a1NoOfAdltsWithEarnedIncomeRetainedIncomeCategoryAndSameDollar);
		q19A1ClientCashIncomeChangeIncomeSourceByEntryAndLatestStatus
				.setQ19a1NoOfAdltsWithEarnedIncomeRetainedIncomeCategoryButHadLessDollar(q19a1NoOfAdltsWithEarnedIncomeRetainedIncomeCategoryButHadLessDollar);
		q19A1ClientCashIncomeChangeIncomeSourceByEntryAndLatestStatus
				.setQ19a1NoOfAdltsWithEarnedIncomeTotalAdult(q19a1NoOfAdltsWithEarnedIncomeTotalAdult);
		q19A1ClientCashIncomeChangeIncomeSourceByEntryAndLatestStatus
				.setQ19a1NoOfAdultsWithOtherIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome(q19a1NoOfAdultsWithOtherIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome);
		q19A1ClientCashIncomeChangeIncomeSourceByEntryAndLatestStatus
				.setQ19a1NoOfAdultsWithOtherIncomeDidNotHaveTheIncomeCategoryAtEntryOrFollowup(q19a1NoOfAdultsWithOtherIncomeDidNotHaveTheIncomeCategoryAtEntryOrFollowup);
		q19A1ClientCashIncomeChangeIncomeSourceByEntryAndLatestStatus
				.setQ19a1NoOfAdultsWithOtherIncomeHadIncomeCategoryAtEntryAndNotHaveFollowup(q19a1NoOfAdultsWithOtherIncomeHadIncomeCategoryAtEntryAndNotHaveFollowup);
		q19A1ClientCashIncomeChangeIncomeSourceByEntryAndLatestStatus
				.setQ19a1NoOfAdultsWithOtherIncomePercent(q19a1NoOfAdultsWithOtherIncomePercent);
		q19A1ClientCashIncomeChangeIncomeSourceByEntryAndLatestStatus
				.setQ19a1NoOfAdultsWithOtherIncomePerformanceMeasures(q19a1NoOfAdultsWithOtherIncomePerformanceMeasures);
		q19A1ClientCashIncomeChangeIncomeSourceByEntryAndLatestStatus
				.setQ19a1NoOfAdultsWithOtherIncomeRetainedIncomeCategoryAndIncreasedDollar(q19a1NoOfAdultsWithOtherIncomeRetainedIncomeCategoryAndIncreasedDollar);
		q19A1ClientCashIncomeChangeIncomeSourceByEntryAndLatestStatus
				.setQ19a1NoOfAdultsWithOtherIncomeRetainedIncomeCategoryAndSameDollar(q19a1NoOfAdultsWithOtherIncomeRetainedIncomeCategoryAndSameDollar);
		q19A1ClientCashIncomeChangeIncomeSourceByEntryAndLatestStatus
				.setQ19a1NoOfAdultsWithOtherIncomeTotalAdult(q19a1NoOfAdultsWithOtherIncomeTotalAdult);

		return q19A1ClientCashIncomeChangeIncomeSourceByEntryAndLatestStatus;

	}

	public static DataBean q19a2ClientCashIncomeChangeIncomeSourceByEntry(
			BigInteger q19a2NoOfAdltsWithEarnedIncomeHadIncomeCategoryAtEntryAndDidNotHaveAtExit,
			BigInteger q19a2NoOfAdltsWithEarnedIncomeRetainedIncomeCategoryButHadLessDollarAtExitThanAtEntry,
			BigInteger q19a2NoOfAdltsWithEarnedIncomeRetainedIncomeCategoryAndSameDollarAtExitAsAtEntry,
			BigInteger q19a2NoOfAdltsWithEarnedIncomeRetainedIncomeCategoryAndIncreasedDollarAtExit,
			BigInteger q19a2NoOfAdltsWithEarnedIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedIncomeCategoryExit,
			BigInteger q19a2NoOfAdltsWithEarnedIncomeDidNotHaveIncomeCategoryAtEntryOrExit,
			BigInteger q19a2NoOfAdltsWithEarnedIncomeTotalAdult,
			BigInteger q19a2NoOfAdltsWithEarnedIncomePerformanceMeasures,
			BigInteger q19a2NoOfAdltsWithEarnedIncomePercent,

			BigInteger q19a2AverageChangeInEarnedIncomeHadIncomeCategoryAtEntryAndDidNotHaveAtExit,
			BigInteger q19a2AverageChangeInEarnedIncomeRetainedIncomeCategoryButHadLessDollarAtExitThanAtEntry,
			BigInteger q19a2AverageChangeInEarnedIncomeRetainedIncomeCategoryAndSameDollarAtExitAsAtEntry,
			BigInteger q19a2AverageChangeInEarnedIncomeRetainedIncomeCategoryAndIncreasedDollarAtExit,
			BigInteger q19a2AverageChangeInEarnedIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedIncomeCategoryExit,
			BigInteger q19a2AverageChangeInEarnedIncomeDidNotHaveIncomeCategoryAtEntryOrExit,
			BigInteger q19a2AverageChangeInEarnedIncomeTotalAdult,
			BigInteger q19a2AverageChangeInEarnedIncomePerformanceMeasures,
			BigInteger q19a2AverageChangeInEarnedIncomePercent,

			BigInteger q19a2NoOfAdultsWithOtherIncomeHadIncomeCategoryAtEntryAndDidNotHaveAtExit,
			BigInteger q19a2NoOfAdultsWithOtherIncomeRetainedIncomeCategoryButHadLessDollarAtExitThanAtEntry,
			BigInteger q19a2NoOfAdultsWithOtherIncomeRetainedIncomeCategoryAndSameDollarAtExitAsAtEntry,
			BigInteger q19a2NoOfAdultsWithOtherIncomeRetainedIncomeCategoryAndIncreasedDollarAtExit,
			BigInteger q19a2NoOfAdultsWithOtherIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedIncomeCategoryExit,
			BigInteger q19a2NoOfAdultsWithOtherIncomeDidNotHaveIncomeCategoryAtEntryOrExit,
			BigInteger q19a2NoOfAdultsWithOtherIncomeTotalAdult,
			BigInteger q19a2NoOfAdultsWithOtherIncomePerformanceMeasures,
			BigInteger q19a2NoOfAdultsWithOtherIncomePercent,

			BigInteger q19a2AverageChangeInOtherIncomeHadIncomeCategoryAtEntryAndDidNotHaveAtExit,
			BigInteger q19a2AverageChangeInOtherIncomeRetainedIncomeCategoryButHadLessDollarAtExitThanAtEntry,
			BigInteger q19a2AverageChangeInOtherIncomeRetainedIncomeCategoryAndSameDollarAtExitAsAtEntry,
			BigInteger q19a2AverageChangeInOtherIncomeRetainedIncomeCategoryAndIncreasedDollarAtExit,
			BigInteger q19a2AverageChangeInOtherIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedIncomeCategoryExit,
			BigInteger q19a2AverageChangeInOtherIncomeDidNotHaveIncomeCategoryAtEntryOrExit,
			BigInteger q19a2AverageChangeInOtherIncomeTotalAdult,
			BigInteger q19a2AverageChangeInOtherIncomePerformanceMeasures,
			BigInteger q19a2AverageChangeInOtherIncomePercent,

			BigInteger q19a2NumberOfAdultsWithAnyIncomeHadIncomeCategoryAtEntryAndDidNotHaveAtExit,
			BigInteger q19a2NumberOfAdultsWithAnyIncomeRetainedIncomeCategoryButHadLessDollarAtExitThanAtEntry,
			BigInteger q19a2NumberOfAdultsWithAnyIncomeRetainedIncomeCategoryAndSameDollarAtExitAsAtEntry,
			BigInteger q19a2NumberOfAdultsWithAnyIncomeRetainedIncomeCategoryAndIncreasedDollarAtExit,
			BigInteger q19a2NumberOfAdultsWithAnyIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedIncomeCategoryExit,
			BigInteger q19a2NumberOfAdultsWithAnyIncomeDidNotHaveIncomeCategoryAtEntryOrExit,
			BigInteger q19a2NumberOfAdultsWithAnyIncomeTotalAdult,
			BigInteger q19a2NumberOfAdultsWithAnyIncomePerformanceMeasures,
			BigInteger q19a2NumberOfAdultsWithAnyIncomePercent,

			BigInteger q19a2AverageChangeInOverallIncomeHadIncomeCategoryAtEntryAndDidNotHaveAtExit,
			BigInteger q19a2AverageChangeInOverallIncomeRetainedIncomeCategoryButHadLessDollarAtExitThanAtEntry,
			BigInteger q19a2AverageChangeInOverallIncomeRetainedIncomeCategoryAndSameDollarAtExitAsAtEntry,
			BigInteger q19a2AverageChangeInOverallIncomeRetainedIncomeCategoryAndIncreasedDollarAtExit,
			BigInteger q19a2AverageChangeInOverallIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedIncomeCategoryExit,
			BigInteger q19a2AverageChangeInOverallIncomeDidNotHaveIncomeCategoryAtEntryOrExit,
			BigInteger q19a2AverageChangeInOverallIncomeTotalAdult,
			BigInteger q19a2AverageChangeInOverallIncomePerformanceMeasures,
			BigInteger q19a2AverageChangeInOverallIncomePercent,
			DataBean q19a2ClientCashIncomeChangeIncomeSourceByEntryTable) {

		q19a2ClientCashIncomeChangeIncomeSourceByEntryTable
				.setQ19a2NoOfAdltsWithEarnedIncomeHadIncomeCategoryAtEntryAndDidNotHaveAtExit(BigInteger
						.valueOf(0));
		q19a2ClientCashIncomeChangeIncomeSourceByEntryTable
				.setQ19a2NoOfAdltsWithEarnedIncomeRetainedIncomeCategoryButHadLessDollarAtExitThanAtEntry(BigInteger
						.valueOf(0));
		q19a2ClientCashIncomeChangeIncomeSourceByEntryTable
				.setQ19a2NoOfAdltsWithEarnedIncomeRetainedIncomeCategoryAndSameDollarAtExitAsAtEntry(BigInteger
						.valueOf(0));
		q19a2ClientCashIncomeChangeIncomeSourceByEntryTable
				.setQ19a2NoOfAdltsWithEarnedIncomeRetainedIncomeCategoryAndIncreasedDollarAtExit(BigInteger
						.valueOf(0));
		q19a2ClientCashIncomeChangeIncomeSourceByEntryTable
				.setQ19a2NoOfAdltsWithEarnedIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedIncomeCategoryExit(BigInteger
						.valueOf(0));
		q19a2ClientCashIncomeChangeIncomeSourceByEntryTable
				.setQ19a2NoOfAdltsWithEarnedIncomeDidNotHaveIncomeCategoryAtEntryOrExit(BigInteger
						.valueOf(0));
		q19a2ClientCashIncomeChangeIncomeSourceByEntryTable
				.setQ19a2NoOfAdltsWithEarnedIncomeTotalAdult(BigInteger
						.valueOf(0));
		q19a2ClientCashIncomeChangeIncomeSourceByEntryTable
				.setQ19a2NoOfAdltsWithEarnedIncomePerformanceMeasures(BigInteger
						.valueOf(0));
		q19a2ClientCashIncomeChangeIncomeSourceByEntryTable
				.setQ19a2NoOfAdltsWithEarnedIncomePercent(BigInteger.valueOf(0));

		q19a2ClientCashIncomeChangeIncomeSourceByEntryTable
				.setQ19a2AverageChangeInEarnedIncomeHadIncomeCategoryAtEntryAndDidNotHaveAtExit(BigInteger
						.valueOf(0));
		q19a2ClientCashIncomeChangeIncomeSourceByEntryTable
				.setQ19a2AverageChangeInEarnedIncomeRetainedIncomeCategoryButHadLessDollarAtExitThanAtEntry(BigInteger
						.valueOf(0));
		q19a2ClientCashIncomeChangeIncomeSourceByEntryTable
				.setQ19a2AverageChangeInEarnedIncomeRetainedIncomeCategoryAndSameDollarAtExitAsAtEntry(BigInteger
						.valueOf(0));
		q19a2ClientCashIncomeChangeIncomeSourceByEntryTable
				.setQ19a2AverageChangeInEarnedIncomeRetainedIncomeCategoryAndIncreasedDollarAtExit(BigInteger
						.valueOf(0));
		q19a2ClientCashIncomeChangeIncomeSourceByEntryTable
				.setQ19a2AverageChangeInEarnedIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedIncomeCategoryExit(BigInteger
						.valueOf(0));
		q19a2ClientCashIncomeChangeIncomeSourceByEntryTable
				.setQ19a2AverageChangeInEarnedIncomeDidNotHaveIncomeCategoryAtEntryOrExit(BigInteger
						.valueOf(0));
		q19a2ClientCashIncomeChangeIncomeSourceByEntryTable
				.setQ19a2AverageChangeInEarnedIncomeTotalAdult(BigInteger
						.valueOf(0));
		q19a2ClientCashIncomeChangeIncomeSourceByEntryTable
				.setQ19a2AverageChangeInEarnedIncomePerformanceMeasures(BigInteger
						.valueOf(0));
		q19a2ClientCashIncomeChangeIncomeSourceByEntryTable
				.setQ19a2AverageChangeInEarnedIncomePercent(BigInteger
						.valueOf(0));

		q19a2ClientCashIncomeChangeIncomeSourceByEntryTable
				.setQ19a2NoOfAdultsWithOtherIncomeHadIncomeCategoryAtEntryAndDidNotHaveAtExit(BigInteger
						.valueOf(0));
		q19a2ClientCashIncomeChangeIncomeSourceByEntryTable
				.setQ19a2NoOfAdultsWithOtherIncomeRetainedIncomeCategoryButHadLessDollarAtExitThanAtEntry(BigInteger
						.valueOf(0));
		q19a2ClientCashIncomeChangeIncomeSourceByEntryTable
				.setQ19a2NoOfAdultsWithOtherIncomeRetainedIncomeCategoryAndSameDollarAtExitAsAtEntry(BigInteger
						.valueOf(0));
		q19a2ClientCashIncomeChangeIncomeSourceByEntryTable
				.setQ19a2NoOfAdultsWithOtherIncomeRetainedIncomeCategoryAndIncreasedDollarAtExit(BigInteger
						.valueOf(0));
		q19a2ClientCashIncomeChangeIncomeSourceByEntryTable
				.setQ19a2NoOfAdultsWithOtherIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedIncomeCategoryExit(BigInteger
						.valueOf(0));
		q19a2ClientCashIncomeChangeIncomeSourceByEntryTable
				.setQ19a2NoOfAdultsWithOtherIncomeDidNotHaveIncomeCategoryAtEntryOrExit(BigInteger
						.valueOf(0));
		q19a2ClientCashIncomeChangeIncomeSourceByEntryTable
				.setQ19a2NoOfAdultsWithOtherIncomeTotalAdult(BigInteger
						.valueOf(0));
		q19a2ClientCashIncomeChangeIncomeSourceByEntryTable
				.setQ19a2NoOfAdultsWithOtherIncomePerformanceMeasures(BigInteger
						.valueOf(0));
		q19a2ClientCashIncomeChangeIncomeSourceByEntryTable
				.setQ19a2NoOfAdultsWithOtherIncomePercent(BigInteger.valueOf(0));

		q19a2ClientCashIncomeChangeIncomeSourceByEntryTable
				.setQ19a2AverageChangeInOtherIncomeHadIncomeCategoryAtEntryAndDidNotHaveAtExit(BigInteger
						.valueOf(0));
		q19a2ClientCashIncomeChangeIncomeSourceByEntryTable
				.setQ19a2AverageChangeInOtherIncomeRetainedIncomeCategoryButHadLessDollarAtExitThanAtEntry(BigInteger
						.valueOf(0));
		q19a2ClientCashIncomeChangeIncomeSourceByEntryTable
				.setQ19a2AverageChangeInOtherIncomeRetainedIncomeCategoryAndSameDollarAtExitAsAtEntry(BigInteger
						.valueOf(0));
		q19a2ClientCashIncomeChangeIncomeSourceByEntryTable
				.setQ19a2AverageChangeInOtherIncomeRetainedIncomeCategoryAndIncreasedDollarAtExit(BigInteger
						.valueOf(0));
		q19a2ClientCashIncomeChangeIncomeSourceByEntryTable
				.setQ19a2AverageChangeInOtherIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedIncomeCategoryExit(BigInteger
						.valueOf(0));
		q19a2ClientCashIncomeChangeIncomeSourceByEntryTable
				.setQ19a2AverageChangeInOtherIncomeDidNotHaveIncomeCategoryAtEntryOrExit(BigInteger
						.valueOf(0));
		q19a2ClientCashIncomeChangeIncomeSourceByEntryTable
				.setQ19a2AverageChangeInOtherIncomeTotalAdult(BigInteger
						.valueOf(0));
		q19a2ClientCashIncomeChangeIncomeSourceByEntryTable
				.setQ19a2AverageChangeInOtherIncomePerformanceMeasures(BigInteger
						.valueOf(0));
		q19a2ClientCashIncomeChangeIncomeSourceByEntryTable
				.setQ19a2AverageChangeInOtherIncomePercent(BigInteger
						.valueOf(0));

		q19a2ClientCashIncomeChangeIncomeSourceByEntryTable
				.setQ19a2NumberOfAdultsWithAnyIncomeHadIncomeCategoryAtEntryAndDidNotHaveAtExit(BigInteger
						.valueOf(0));
		q19a2ClientCashIncomeChangeIncomeSourceByEntryTable
				.setQ19a2NumberOfAdultsWithAnyIncomeRetainedIncomeCategoryButHadLessDollarAtExitThanAtEntry(BigInteger
						.valueOf(0));
		q19a2ClientCashIncomeChangeIncomeSourceByEntryTable
				.setQ19a2NumberOfAdultsWithAnyIncomeRetainedIncomeCategoryAndSameDollarAtExitAsAtEntry(BigInteger
						.valueOf(0));
		q19a2ClientCashIncomeChangeIncomeSourceByEntryTable
				.setQ19a2NumberOfAdultsWithAnyIncomeRetainedIncomeCategoryAndIncreasedDollarAtExit(BigInteger
						.valueOf(0));
		q19a2ClientCashIncomeChangeIncomeSourceByEntryTable
				.setQ19a2NumberOfAdultsWithAnyIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedIncomeCategoryExit(BigInteger
						.valueOf(0));
		q19a2ClientCashIncomeChangeIncomeSourceByEntryTable
				.setQ19a2NumberOfAdultsWithAnyIncomeDidNotHaveIncomeCategoryAtEntryOrExit(BigInteger
						.valueOf(0));
		q19a2ClientCashIncomeChangeIncomeSourceByEntryTable
				.setQ19a2NumberOfAdultsWithAnyIncomeTotalAdult(BigInteger
						.valueOf(0));
		q19a2ClientCashIncomeChangeIncomeSourceByEntryTable
				.setQ19a2NumberOfAdultsWithAnyIncomePerformanceMeasures(BigInteger
						.valueOf(0));
		q19a2ClientCashIncomeChangeIncomeSourceByEntryTable
				.setQ19a2NumberOfAdultsWithAnyIncomePercent(BigInteger
						.valueOf(0));

		q19a2ClientCashIncomeChangeIncomeSourceByEntryTable
				.setQ19a2AverageChangeInOverallIncomeHadIncomeCategoryAtEntryAndDidNotHaveAtExit(BigInteger
						.valueOf(0));
		q19a2ClientCashIncomeChangeIncomeSourceByEntryTable
				.setQ19a2AverageChangeInOverallIncomeRetainedIncomeCategoryButHadLessDollarAtExitThanAtEntry(BigInteger
						.valueOf(0));
		q19a2ClientCashIncomeChangeIncomeSourceByEntryTable
				.setQ19a2AverageChangeInOverallIncomeRetainedIncomeCategoryAndSameDollarAtExitAsAtEntry(BigInteger
						.valueOf(0));
		q19a2ClientCashIncomeChangeIncomeSourceByEntryTable
				.setQ19a2AverageChangeInOverallIncomeRetainedIncomeCategoryAndIncreasedDollarAtExit(BigInteger
						.valueOf(0));
		q19a2ClientCashIncomeChangeIncomeSourceByEntryTable
				.setQ19a2AverageChangeInOverallIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedIncomeCategoryExit(BigInteger
						.valueOf(0));
		q19a2ClientCashIncomeChangeIncomeSourceByEntryTable
				.setQ19a2AverageChangeInOverallIncomeDidNotHaveIncomeCategoryAtEntryOrExit(BigInteger
						.valueOf(0));
		q19a2ClientCashIncomeChangeIncomeSourceByEntryTable
				.setQ19a2AverageChangeInOverallIncomeTotalAdult(BigInteger
						.valueOf(0));
		q19a2ClientCashIncomeChangeIncomeSourceByEntryTable
				.setQ19a2AverageChangeInOverallIncomePerformanceMeasures(BigInteger
						.valueOf(0));
		q19a2ClientCashIncomeChangeIncomeSourceByEntryTable
				.setQ19a2AverageChangeInOverallIncomePercent(BigInteger
						.valueOf(0));

		return q19a2ClientCashIncomeChangeIncomeSourceByEntryTable;

	}

	public static DataBean q19a3ClientCashIncomeChangeIncomeSourceByEntry(

			BigInteger q19a3NoOfAdltsWithEarnedIncomeHadIncomeCategoryAtEntryAndDidNotHavefollowupOrExit,
			BigInteger q19a3NoOfAdltsWithEarnedIncomeRetainedIncomeCategoryButHadLessDollarAtFollowupOrExitAtEntry,
			BigInteger q19a3NoOfAdltsWithEarnedIncomeRetainedIncomeCategoryAndSameDollartFollowupOrExitAtEntry,
			BigInteger q19a3NoOfAdltsWithEarnedIncomeRetainedIncomeCategoryAndIncreasedDollarAtFollowupOrExit,
			BigInteger q19a3NoOfAdltsWithEarnedIncomeDidNotHaveIncomeCategoryEntryAndGainedIncomeCategoryAtFollowupOrExit,
			BigInteger q19a3NoOfAdltsWithEarnedIncomeDidNotHaveIncomeCategoryAtEntryOrFollowupOrExit,
			BigInteger q19a3NoOfAdltsWithEarnedIncomeTotalAdult,
			BigInteger q19a3NoOfAdltsWithEarnedIncomePerformanceMeasures,
			BigInteger q19a3NoOfAdltsWithEarnedIncomePercent,

			BigInteger q19a3AverageChangeInEarnedIncomeHadIncomeCategoryAtEntryAndDidNotHavefollowupOrExit,
			BigInteger q19a3AverageChangeInEarnedIncomeRetainedIncomeCategoryButHadLessDollarAtFollowupOrExitAtEntry,
			BigInteger q19a3AverageChangeInEarnedIncomeRetainedIncomeCategoryAndSameDollartFollowupOrExitAtEntry,
			BigInteger q19a3AverageChangeInEarnedIncomeRetainedIncomeCategoryAndIncreasedDollarAtFollowupOrExit,
			BigInteger q19a3AverageChangeInEarnedIncomeDidNotHaveIncomeCategoryEntryAndGainedIncomeCategoryAtFollowupOrExit,
			BigInteger q19a3AverageChangeInEarnedIncomeDidNotHaveIncomeCategoryAtEntryOrFollowupOrExit,
			BigInteger q19a3AverageChangeInEarnedIncomeTotalAdult,
			BigInteger q19a3AverageChangeInEarnedIncomePerformanceMeasures,
			BigInteger q19a3AverageChangeInEarnedIncomePercent,

			BigInteger q19a3NoOfAdultsWithOtherIncomeHadIncomeCategoryAtEntryAndDidNotHavefollowupOrExit,
			BigInteger q19a3NoOfAdultsWithOtherIncomeRetainedIncomeCategoryButHadLessDollarAtFollowupOrExitAtEntry,
			BigInteger q19a3NoOfAdultsWithOtherIncomeRetainedIncomeCategoryAndSameDollartFollowupOrExitAtEntry,
			BigInteger q19a3NoOfAdultsWithOtherIncomeRetainedIncomeCategoryAndIncreasedDollarAtFollowupOrExit,
			BigInteger q19a3NoOfAdultsWithOtherIncomeDidNotHaveIncomeCategoryEntryAndGainedIncomeCategoryAtFollowupOrExit,
			BigInteger q19a3NoOfAdultsWithOtherIncomeDidNotHaveIncomeCategoryAtEntryOrFollowupOrExit,
			BigInteger q19a3NoOfAdultsWithOtherIncomeTotalAdult,
			BigInteger q19a3NoOfAdultsWithOtherIncomePerformanceMeasures,
			BigInteger q19a3NoOfAdultsWithOtherIncomePercent,

			BigInteger q19a3AverageChangeInOtherIncomeHadIncomeCategoryAtEntryAndDidNotHavefollowupOrExit,
			BigInteger q19a3AverageChangeInOtherIncomeRetainedIncomeCategoryButHadLessDollarAtFollowupOrExitAtEntry,
			BigInteger q19a3AverageChangeInOtherIncomeRetainedIncomeCategoryAndSameDollartFollowupOrExitAtEntry,
			BigInteger q19a3AverageChangeInOtherIncomeRetainedIncomeCategoryAndIncreasedDollarAtFollowupOrExit,
			BigInteger q19a3AverageChangeInOtherIncomeDidNotHaveIncomeCategoryEntryAndGainedIncomeCategoryAtFollowupOrExit,
			BigInteger q19a3AverageChangeInOtherIncomeDidNotHaveIncomeCategoryAtEntryOrFollowupOrExit,
			BigInteger q19a3AverageChangeInOtherIncomeTotalAdult,
			BigInteger q19a3AverageChangeInOtherIncomePerformanceMeasures,
			BigInteger q19a3AverageChangeInOtherIncomePercent,

			BigInteger q19a3NumberOfAdultsWithAnyIncomeHadIncomeCategoryAtEntryAndDidNotHavefollowupOrExit,
			BigInteger q19a3NumberOfAdultsWithAnyIncomeRetainedIncomeCategoryButHadLessDollarAtFollowupOrExitAtEntry,
			BigInteger q19a3NumberOfAdultsWithAnyIncomeRetainedIncomeCategoryAndSameDollartFollowupOrExitAtEntry,
			BigInteger q19a3NumberOfAdultsWithAnyIncomeRetainedIncomeCategoryAndIncreasedDollarAtFollowupOrExit,
			BigInteger q19a3NumberOfAdultsWithAnyIncomeDidNotHaveIncomeCategoryEntryAndGainedIncomeCategoryAtFollowupOrExit,
			BigInteger q19a3NumberOfAdultsWithAnyIncomeDidNotHaveIncomeCategoryAtEntryOrFollowupOrExit,
			BigInteger q19a3NumberOfAdultsWithAnyIncomeTotalAdult,
			BigInteger q19a3NumberOfAdultsWithAnyIncomePerformanceMeasures,
			BigInteger q19a3NumberOfAdultsWithAnyIncomePercent,

			BigInteger q19a3AverageChangeInOverallIncomeHadIncomeCategoryAtEntryAndDidNotHavefollowupOrExit,
			BigInteger q19a3AverageChangeInOverallIncomeRetainedIncomeCategoryButHadLessDollarAtFollowupOrExitAtEntry,
			BigInteger q19a3AverageChangeInOverallIncomeRetainedIncomeCategoryAndSameDollartFollowupOrExitAtEntry,
			BigInteger q19a3AverageChangeInOverallIncomeRetainedIncomeCategoryAndIncreasedDollarAtFollowupOrExit,
			BigInteger q19a3AverageChangeInOverallIncomeDidNotHaveIncomeCategoryEntryAndGainedIncomeCategoryAtFollowupOrExit,
			BigInteger q19a3AverageChangeInOverallIncomeDidNotHaveIncomeCategoryAtEntryOrFollowupOrExit,
			BigInteger q19a3AverageChangeInOverallIncomeTotalAdult,
			BigInteger q19a3AverageChangeInOverallIncomePerformanceMeasures,
			BigInteger q19a3AverageChangeInOverallIncomePercent,
			DataBean q19a3ClientCashIncomeChangeIncomeSourceByEntryTable) {

		q19a3ClientCashIncomeChangeIncomeSourceByEntryTable
				.setQ19a3NoOfAdltsWithEarnedIncomeHadIncomeCategoryAtEntryAndDidNotHavefollowupOrExit(BigInteger
						.valueOf(0));
		q19a3ClientCashIncomeChangeIncomeSourceByEntryTable
				.setQ19a3NoOfAdltsWithEarnedIncomeRetainedIncomeCategoryButHadLessDollarAtFollowupOrExitAtEntry(BigInteger
						.valueOf(0));
		q19a3ClientCashIncomeChangeIncomeSourceByEntryTable
				.setQ19a3NoOfAdltsWithEarnedIncomeRetainedIncomeCategoryAndSameDollartFollowupOrExitAtEntry(BigInteger
						.valueOf(0));
		q19a3ClientCashIncomeChangeIncomeSourceByEntryTable
				.setQ19a3NoOfAdltsWithEarnedIncomeRetainedIncomeCategoryAndIncreasedDollarAtFollowupOrExit(BigInteger
						.valueOf(0));
		q19a3ClientCashIncomeChangeIncomeSourceByEntryTable
				.setQ19a3NoOfAdltsWithEarnedIncomeDidNotHaveIncomeCategoryEntryAndGainedIncomeCategoryAtFollowupOrExit(BigInteger
						.valueOf(0));
		q19a3ClientCashIncomeChangeIncomeSourceByEntryTable
				.setQ19a3NoOfAdltsWithEarnedIncomeDidNotHaveIncomeCategoryAtEntryOrFollowupOrExit(BigInteger
						.valueOf(0));
		q19a3ClientCashIncomeChangeIncomeSourceByEntryTable
				.setQ19a3NoOfAdltsWithEarnedIncomeTotalAdult(BigInteger
						.valueOf(0));
		q19a3ClientCashIncomeChangeIncomeSourceByEntryTable
				.setQ19a3NoOfAdltsWithEarnedIncomePerformanceMeasures(BigInteger
						.valueOf(0));
		q19a3ClientCashIncomeChangeIncomeSourceByEntryTable
				.setQ19a3NoOfAdltsWithEarnedIncomePercent(BigInteger.valueOf(0));

		q19a3ClientCashIncomeChangeIncomeSourceByEntryTable
				.setQ19a3AverageChangeInEarnedIncomeHadIncomeCategoryAtEntryAndDidNotHavefollowupOrExit(BigInteger
						.valueOf(0));
		q19a3ClientCashIncomeChangeIncomeSourceByEntryTable
				.setQ19a3AverageChangeInEarnedIncomeRetainedIncomeCategoryButHadLessDollarAtFollowupOrExitAtEntry(BigInteger
						.valueOf(0));
		q19a3ClientCashIncomeChangeIncomeSourceByEntryTable
				.setQ19a3AverageChangeInEarnedIncomeRetainedIncomeCategoryAndSameDollartFollowupOrExitAtEntry(BigInteger
						.valueOf(0));
		q19a3ClientCashIncomeChangeIncomeSourceByEntryTable
				.setQ19a3AverageChangeInEarnedIncomeRetainedIncomeCategoryAndIncreasedDollarAtFollowupOrExit(BigInteger
						.valueOf(0));
		q19a3ClientCashIncomeChangeIncomeSourceByEntryTable
				.setQ19a3AverageChangeInEarnedIncomeDidNotHaveIncomeCategoryEntryAndGainedIncomeCategoryAtFollowupOrExit(BigInteger
						.valueOf(0));
		q19a3ClientCashIncomeChangeIncomeSourceByEntryTable
				.setQ19a3AverageChangeInEarnedIncomeDidNotHaveIncomeCategoryAtEntryOrFollowupOrExit(BigInteger
						.valueOf(0));
		q19a3ClientCashIncomeChangeIncomeSourceByEntryTable
				.setQ19a3AverageChangeInEarnedIncomeTotalAdult(BigInteger
						.valueOf(0));
		q19a3ClientCashIncomeChangeIncomeSourceByEntryTable
				.setQ19a3AverageChangeInEarnedIncomePerformanceMeasures(BigInteger
						.valueOf(0));
		q19a3ClientCashIncomeChangeIncomeSourceByEntryTable
				.setQ19a3AverageChangeInEarnedIncomePercent(BigInteger
						.valueOf(0));

		q19a3ClientCashIncomeChangeIncomeSourceByEntryTable
				.setQ19a3NoOfAdultsWithOtherIncomeHadIncomeCategoryAtEntryAndDidNotHavefollowupOrExit(BigInteger
						.valueOf(0));
		q19a3ClientCashIncomeChangeIncomeSourceByEntryTable
				.setQ19a3NoOfAdultsWithOtherIncomeRetainedIncomeCategoryButHadLessDollarAtFollowupOrExitAtEntry(BigInteger
						.valueOf(0));
		q19a3ClientCashIncomeChangeIncomeSourceByEntryTable
				.setQ19a3NoOfAdultsWithOtherIncomeRetainedIncomeCategoryAndSameDollartFollowupOrExitAtEntry(BigInteger
						.valueOf(0));
		q19a3ClientCashIncomeChangeIncomeSourceByEntryTable
				.setQ19a3NoOfAdultsWithOtherIncomeRetainedIncomeCategoryAndIncreasedDollarAtFollowupOrExit(BigInteger
						.valueOf(0));
		q19a3ClientCashIncomeChangeIncomeSourceByEntryTable
				.setQ19a3NoOfAdultsWithOtherIncomeDidNotHaveIncomeCategoryEntryAndGainedIncomeCategoryAtFollowupOrExit(BigInteger
						.valueOf(0));
		q19a3ClientCashIncomeChangeIncomeSourceByEntryTable
				.setQ19a3NoOfAdultsWithOtherIncomeDidNotHaveIncomeCategoryAtEntryOrFollowupOrExit(BigInteger
						.valueOf(0));
		q19a3ClientCashIncomeChangeIncomeSourceByEntryTable
				.setQ19a3NoOfAdultsWithOtherIncomeTotalAdult(BigInteger
						.valueOf(0));
		q19a3ClientCashIncomeChangeIncomeSourceByEntryTable
				.setQ19a3NoOfAdultsWithOtherIncomePerformanceMeasures(BigInteger
						.valueOf(0));
		q19a3ClientCashIncomeChangeIncomeSourceByEntryTable
				.setQ19a3NoOfAdultsWithOtherIncomePercent(BigInteger.valueOf(0));

		q19a3ClientCashIncomeChangeIncomeSourceByEntryTable
				.setQ19a3AverageChangeInOtherIncomeHadIncomeCategoryAtEntryAndDidNotHavefollowupOrExit(BigInteger
						.valueOf(0));
		q19a3ClientCashIncomeChangeIncomeSourceByEntryTable
				.setQ19a3AverageChangeInOtherIncomeRetainedIncomeCategoryButHadLessDollarAtFollowupOrExitAtEntry(BigInteger
						.valueOf(0));
		q19a3ClientCashIncomeChangeIncomeSourceByEntryTable
				.setQ19a3AverageChangeInOtherIncomeRetainedIncomeCategoryAndSameDollartFollowupOrExitAtEntry(BigInteger
						.valueOf(0));
		q19a3ClientCashIncomeChangeIncomeSourceByEntryTable
				.setQ19a3AverageChangeInOtherIncomeRetainedIncomeCategoryAndIncreasedDollarAtFollowupOrExit(BigInteger
						.valueOf(0));
		q19a3ClientCashIncomeChangeIncomeSourceByEntryTable
				.setQ19a3AverageChangeInOtherIncomeDidNotHaveIncomeCategoryEntryAndGainedIncomeCategoryAtFollowupOrExit(BigInteger
						.valueOf(0));
		q19a3ClientCashIncomeChangeIncomeSourceByEntryTable
				.setQ19a3AverageChangeInOtherIncomeDidNotHaveIncomeCategoryAtEntryOrFollowupOrExit(BigInteger
						.valueOf(0));
		q19a3ClientCashIncomeChangeIncomeSourceByEntryTable
				.setQ19a3AverageChangeInOtherIncomeTotalAdult(BigInteger
						.valueOf(0));
		q19a3ClientCashIncomeChangeIncomeSourceByEntryTable
				.setQ19a3AverageChangeInOtherIncomePerformanceMeasures(BigInteger
						.valueOf(0));
		q19a3ClientCashIncomeChangeIncomeSourceByEntryTable
				.setQ19a3AverageChangeInOtherIncomePercent(BigInteger
						.valueOf(0));

		q19a3ClientCashIncomeChangeIncomeSourceByEntryTable
				.setQ19a3NumberOfAdultsWithAnyIncomeHadIncomeCategoryAtEntryAndDidNotHavefollowupOrExit(BigInteger
						.valueOf(0));
		q19a3ClientCashIncomeChangeIncomeSourceByEntryTable
				.setQ19a3NumberOfAdultsWithAnyIncomeRetainedIncomeCategoryButHadLessDollarAtFollowupOrExitAtEntry(BigInteger
						.valueOf(0));
		q19a3ClientCashIncomeChangeIncomeSourceByEntryTable
				.setQ19a3NumberOfAdultsWithAnyIncomeRetainedIncomeCategoryAndSameDollartFollowupOrExitAtEntry(BigInteger
						.valueOf(0));
		q19a3ClientCashIncomeChangeIncomeSourceByEntryTable
				.setQ19a3NumberOfAdultsWithAnyIncomeRetainedIncomeCategoryAndIncreasedDollarAtFollowupOrExit(BigInteger
						.valueOf(0));
		q19a3ClientCashIncomeChangeIncomeSourceByEntryTable
				.setQ19a3NumberOfAdultsWithAnyIncomeDidNotHaveIncomeCategoryEntryAndGainedIncomeCategoryAtFollowupOrExit(BigInteger
						.valueOf(0));
		q19a3ClientCashIncomeChangeIncomeSourceByEntryTable
				.setQ19a3NumberOfAdultsWithAnyIncomeDidNotHaveIncomeCategoryAtEntryOrFollowupOrExit(BigInteger
						.valueOf(0));
		q19a3ClientCashIncomeChangeIncomeSourceByEntryTable
				.setQ19a3NumberOfAdultsWithAnyIncomeTotalAdult(BigInteger
						.valueOf(0));
		q19a3ClientCashIncomeChangeIncomeSourceByEntryTable
				.setQ19a3NumberOfAdultsWithAnyIncomePerformanceMeasures(BigInteger
						.valueOf(0));
		q19a3ClientCashIncomeChangeIncomeSourceByEntryTable
				.setQ19a3NumberOfAdultsWithAnyIncomePercent(BigInteger
						.valueOf(0));

		q19a3ClientCashIncomeChangeIncomeSourceByEntryTable
				.setQ19a3AverageChangeInOverallIncomeHadIncomeCategoryAtEntryAndDidNotHavefollowupOrExit(BigInteger
						.valueOf(0));
		q19a3ClientCashIncomeChangeIncomeSourceByEntryTable
				.setQ19a3AverageChangeInOverallIncomeRetainedIncomeCategoryButHadLessDollarAtFollowupOrExitAtEntry(BigInteger
						.valueOf(0));
		q19a3ClientCashIncomeChangeIncomeSourceByEntryTable
				.setQ19a3AverageChangeInOverallIncomeRetainedIncomeCategoryAndSameDollartFollowupOrExitAtEntry(BigInteger
						.valueOf(0));
		q19a3ClientCashIncomeChangeIncomeSourceByEntryTable
				.setQ19a3AverageChangeInOverallIncomeRetainedIncomeCategoryAndIncreasedDollarAtFollowupOrExit(BigInteger
						.valueOf(0));
		q19a3ClientCashIncomeChangeIncomeSourceByEntryTable
				.setQ19a3AverageChangeInOverallIncomeDidNotHaveIncomeCategoryEntryAndGainedIncomeCategoryAtFollowupOrExit(BigInteger
						.valueOf(0));
		q19a3ClientCashIncomeChangeIncomeSourceByEntryTable
				.setQ19a3AverageChangeInOverallIncomeDidNotHaveIncomeCategoryAtEntryOrFollowupOrExit(BigInteger
						.valueOf(0));
		q19a3ClientCashIncomeChangeIncomeSourceByEntryTable
				.setQ19a3AverageChangeInOverallIncomeTotalAdult(BigInteger
						.valueOf(0));
		q19a3ClientCashIncomeChangeIncomeSourceByEntryTable
				.setQ19a3AverageChangeInOverallIncomePerformanceMeasures(BigInteger
						.valueOf(0));
		q19a3ClientCashIncomeChangeIncomeSourceByEntryTable
				.setQ19a3AverageChangeInOverallIncomePercent(BigInteger
						.valueOf(0));

		return q19a3ClientCashIncomeChangeIncomeSourceByEntryTable;

	}

	public static DataBean q20aTypeOfNonCashBenefitSources(

	BigInteger q20aSupplementalNutritionalAssistanceAtEntry,
			BigInteger q20aSupplementalNutritionalAssistanceAtLatestStayers,
			BigInteger q20aSupplementalNutritionalAssistanceAtExitLeavers,

			BigInteger q20aWICAtEntry, BigInteger q20aWICAtLatestStayers,
			BigInteger q20aWICAtExitLeavers,

			BigInteger q20aTANFChildCareAtEntry,
			BigInteger q20aTANFChildCareAtLatestStayers,
			BigInteger q20aTANFChildCareAtExitLeavers,

			BigInteger q20aTANFTransportationAtEntry,
			BigInteger q20aTANFTransportationAtLatestStayers,
			BigInteger q20aTANFTransportationAtExitLeavers,

			BigInteger q20aOtherTANFAtEntry,
			BigInteger q20aOtherTANFAtLatestStayers,
			BigInteger q20aOtherTANFAtExitLeavers,

			BigInteger q20aOtherSourcesAtEntry,
			BigInteger q20aOtherSourcesAtLatestStayers,
			BigInteger q20aOtherSourcesAtExitLeavers,
			DataBean q20aTypeOfNonCashBenefitSourcesTable) {

		q20aTypeOfNonCashBenefitSourcesTable
				.setQ20aSupplementalNutritionalAssistanceAtEntry(BigInteger
						.valueOf(0));
		q20aTypeOfNonCashBenefitSourcesTable
				.setQ20aSupplementalNutritionalAssistanceAtLatestStayers(BigInteger
						.valueOf(0));
		q20aTypeOfNonCashBenefitSourcesTable
				.setQ20aSupplementalNutritionalAssistanceAtExitLeavers(BigInteger
						.valueOf(0));

		q20aTypeOfNonCashBenefitSourcesTable.setQ20aWICAtEntry(BigInteger
				.valueOf(0));
		q20aTypeOfNonCashBenefitSourcesTable
				.setQ20aWICAtLatestStayers(BigInteger.valueOf(0));
		q20aTypeOfNonCashBenefitSourcesTable.setQ20aWICAtExitLeavers(BigInteger
				.valueOf(0));

		q20aTypeOfNonCashBenefitSourcesTable
				.setQ20aTANFChildCareAtEntry(BigInteger.valueOf(0));
		q20aTypeOfNonCashBenefitSourcesTable
				.setQ20aTANFChildCareAtLatestStayers(BigInteger.valueOf(0));
		q20aTypeOfNonCashBenefitSourcesTable
				.setQ20aTANFChildCareAtExitLeavers(BigInteger.valueOf(0));

		q20aTypeOfNonCashBenefitSourcesTable
				.setQ20aTANFTransportationAtEntry(BigInteger.valueOf(0));
		q20aTypeOfNonCashBenefitSourcesTable
				.setQ20aTANFTransportationAtLatestStayers(BigInteger.valueOf(0));
		q20aTypeOfNonCashBenefitSourcesTable
				.setQ20aTANFTransportationAtExitLeavers(BigInteger.valueOf(0));

		q20aTypeOfNonCashBenefitSourcesTable.setQ20aOtherTANFAtEntry(BigInteger
				.valueOf(0));
		q20aTypeOfNonCashBenefitSourcesTable
				.setQ20aOtherTANFAtLatestStayers(BigInteger.valueOf(0));
		q20aTypeOfNonCashBenefitSourcesTable
				.setQ20aOtherTANFAtExitLeavers(BigInteger.valueOf(0));

		q20aTypeOfNonCashBenefitSourcesTable
				.setQ20aOtherSourcesAtEntry(BigInteger.valueOf(0));
		q20aTypeOfNonCashBenefitSourcesTable
				.setQ20aOtherSourcesAtLatestStayers(BigInteger.valueOf(0));
		q20aTypeOfNonCashBenefitSourcesTable
				.setQ20aOtherSourcesAtExitLeavers(BigInteger.valueOf(0));

		return q20aTypeOfNonCashBenefitSourcesTable;

	}

	public static DataBean q20bNumberOfNonCashBenefitSources(

	BigInteger q20bNosourcesAtEntry, BigInteger q20bNosourcesAtLatestStayers,
			BigInteger q20bNosourcesAtExitLeavers,

			BigInteger q20b1PlusSourcesAtEntry,
			BigInteger q20b1PlusSourcesAtLatestStayers,
			BigInteger q20b1PlusSourcesAtExitLeavers,

			BigInteger q20bDKRAtEntry, BigInteger q20bDKRAtLatestStayers,
			BigInteger q20bDKRAtExitLeavers,

			BigInteger q20bMissingInfoAtEntry,
			BigInteger q20bMissingInfoAtLatestStayers,
			BigInteger q20bMissingInfoAtExitLeavers,

			BigInteger q20bTotalClientsAtEntry,
			BigInteger q20bTotalClientsAtLatestStayers,
			BigInteger q20bTotalClientsAtExitLeavers,
			DataBean q20bNumberOfNonCashBenefitSourcesTable) {

		q20bNumberOfNonCashBenefitSourcesTable
				.setQ20bNosourcesAtEntry(BigInteger.valueOf(0));
		q20bNumberOfNonCashBenefitSourcesTable
				.setQ20bNosourcesAtLatestStayers(BigInteger.valueOf(0));
		q20bNumberOfNonCashBenefitSourcesTable
				.setQ20bNosourcesAtExitLeavers(BigInteger.valueOf(0));

		q20bNumberOfNonCashBenefitSourcesTable
				.setQ20b1PlusSourcesAtEntry(BigInteger.valueOf(0));
		q20bNumberOfNonCashBenefitSourcesTable
				.setQ20b1PlusSourcesAtLatestStayers(BigInteger.valueOf(0));
		q20bNumberOfNonCashBenefitSourcesTable
				.setQ20b1PlusSourcesAtExitLeavers(BigInteger.valueOf(0));

		q20bNumberOfNonCashBenefitSourcesTable.setQ20bDKRAtEntry(BigInteger
				.valueOf(0));
		q20bNumberOfNonCashBenefitSourcesTable
				.setQ20bDKRAtLatestStayers(BigInteger.valueOf(0));
		q20bNumberOfNonCashBenefitSourcesTable
				.setQ20bDKRAtExitLeavers(BigInteger.valueOf(0));

		q20bNumberOfNonCashBenefitSourcesTable
				.setQ20bMissingInfoAtEntry(BigInteger.valueOf(0));
		q20bNumberOfNonCashBenefitSourcesTable
				.setQ20bMissingInfoAtLatestStayers(BigInteger.valueOf(0));
		q20bNumberOfNonCashBenefitSourcesTable
				.setQ20bMissingInfoAtExitLeavers(BigInteger.valueOf(0));

		q20bNumberOfNonCashBenefitSourcesTable
				.setQ20bTotalClientsAtEntry(BigInteger.valueOf(0));
		q20bNumberOfNonCashBenefitSourcesTable
				.setQ20bTotalClientsAtLatestStayers(BigInteger.valueOf(0));
		q20bNumberOfNonCashBenefitSourcesTable
				.setQ20bTotalClientsAtExitLeavers(BigInteger.valueOf(0));

		return q20bNumberOfNonCashBenefitSourcesTable;

	}

	public static DataBean q21HealthInsurance(

	BigInteger q21AMedicaidHealthInsuranceAtEntry,
			BigInteger q21AMedicaidHealthInsuranceAtLatestStayers,
			BigInteger q21AMedicaidHealthInsuranceAtExitLeavers,

			BigInteger q21BMedicaidHealthInsuranceAtEntry,
			BigInteger q21BMedicaidHealthInsuranceAtLatestStayers,
			BigInteger q21BMedicaidHealthInsuranceAtExitLeavers,

			BigInteger q21CStateChildHealthInsuranceAtEntry,
			BigInteger q21CStateChildHealthInsuranceAtLatestStayers,
			BigInteger q21CStateChildHealthInsuranceAtExitLeavers,

			BigInteger q21DVAMedicalServicesAtEntry,
			BigInteger q21DVAMedicalServicesAtLatestStayers,
			BigInteger q21DVAMedicalServicesAtExitLeavers,

			BigInteger q21EEmployerProvidedHealthInsuranceAtEntry,
			BigInteger q21EEmployerProvidedHealthInsuranceAtLatestStayers,
			BigInteger q21EEmployerProvidedHealthInsuranceAtExitLeavers,

			BigInteger q21FHealthInsuranceThroughCobraAtEntry,
			BigInteger q21FHealthInsuranceThroughCobraAtLatestStayers,
			BigInteger q21FHealthInsuranceThroughCobraAtExitLeavers,

			BigInteger q21GPrivatePayHealthInsuranceAtEntry,
			BigInteger q21GPrivatePayHealthInsuranceAtLatestStayers,
			BigInteger q21GPrivatePayHealthInsuranceAtExitLeavers,

			BigInteger q21HStateHealthInsuranceForAdultsAtEntry,
			BigInteger q21HStateHealthInsuranceForAdultsAtLatestStayers,
			BigInteger q21HStateHealthInsuranceForAdultsAtExitLeavers,

			BigInteger q21INoHealthInsuranceAtEntry,
			BigInteger q21INoHealthInsuranceAtLatestStayers,
			BigInteger q21INoHealthInsuranceAtExitLeavers,

			BigInteger q21JClientRefusedAtEntry,
			BigInteger q21JClientRefusedAtLatestStayers,
			BigInteger q21JClientRefusedAtExitLeavers,

			BigInteger q21KDataNotCollectedAtEntry,
			BigInteger q21KDataNotCollectedAtLatestStayers,
			BigInteger q21KDataNotCollectedAtExitLeavers,

			BigInteger q21LNoOfAdultStayersNotRequiredAtEntry,
			BigInteger q21LNoOfAdultStayersNotRequiredAtLatestStayers,
			BigInteger q21LNoOfAdultStayersNotRequiredAtExitLeavers,

			BigInteger q21M1SourceOfHealthInsuranceAtEntry,
			BigInteger q21M1SourceOfHealthInsuranceAtLatestStayers,
			BigInteger q21M1SourceOfHealthInsuranceAtExitLeavers,

			BigInteger q21NMoreThan1SourceOfHealthInsuranceAtEntry,
			BigInteger q21NMoreThan1SourceOfHealthInsuranceAtLatestStayers,
			BigInteger q21NMoreThan1SourceOfHealthInsuranceAtExitLeavers,
			DataBean q21HealthInsuranceDataBeanTable) {

		q21HealthInsuranceDataBeanTable
				.setQ21AMedicaidHealthInsuranceAtEntry(BigInteger.valueOf(0));
		q21HealthInsuranceDataBeanTable
				.setQ21AMedicaidHealthInsuranceAtLatestStayers(BigInteger
						.valueOf(0));
		q21HealthInsuranceDataBeanTable
				.setQ21AMedicaidHealthInsuranceAtExitLeavers(BigInteger
						.valueOf(0));

		q21HealthInsuranceDataBeanTable
				.setQ21BMedicaidHealthInsuranceAtEntry(BigInteger.valueOf(0));
		q21HealthInsuranceDataBeanTable
				.setQ21BMedicaidHealthInsuranceAtLatestStayers(BigInteger
						.valueOf(0));
		q21HealthInsuranceDataBeanTable
				.setQ21BMedicaidHealthInsuranceAtExitLeavers(BigInteger
						.valueOf(0));

		q21HealthInsuranceDataBeanTable
				.setQ21CStateChildHealthInsuranceAtEntry(BigInteger.valueOf(0));
		q21HealthInsuranceDataBeanTable
				.setQ21CStateChildHealthInsuranceAtLatestStayers(BigInteger
						.valueOf(0));
		q21HealthInsuranceDataBeanTable
				.setQ21CStateChildHealthInsuranceAtExitLeavers(BigInteger
						.valueOf(0));

		q21HealthInsuranceDataBeanTable
				.setQ21DVAMedicalServicesAtEntry(BigInteger.valueOf(0));
		q21HealthInsuranceDataBeanTable
				.setQ21DVAMedicalServicesAtLatestStayers(BigInteger.valueOf(0));
		q21HealthInsuranceDataBeanTable
				.setQ21DVAMedicalServicesAtExitLeavers(BigInteger.valueOf(0));

		q21HealthInsuranceDataBeanTable
				.setQ21EEmployerProvidedHealthInsuranceAtEntry(BigInteger
						.valueOf(0));
		q21HealthInsuranceDataBeanTable
				.setQ21EEmployerProvidedHealthInsuranceAtLatestStayers(BigInteger
						.valueOf(0));
		q21HealthInsuranceDataBeanTable
				.setQ21EEmployerProvidedHealthInsuranceAtExitLeavers(BigInteger
						.valueOf(0));

		q21HealthInsuranceDataBeanTable
				.setQ21FHealthInsuranceThroughCobraAtEntry(BigInteger
						.valueOf(0));
		q21HealthInsuranceDataBeanTable
				.setQ21FHealthInsuranceThroughCobraAtLatestStayers(BigInteger
						.valueOf(0));
		q21HealthInsuranceDataBeanTable
				.setQ21FHealthInsuranceThroughCobraAtExitLeavers(BigInteger
						.valueOf(0));

		q21HealthInsuranceDataBeanTable
				.setQ21GPrivatePayHealthInsuranceAtEntry(BigInteger.valueOf(0));
		q21HealthInsuranceDataBeanTable
				.setQ21GPrivatePayHealthInsuranceAtLatestStayers(BigInteger
						.valueOf(0));
		q21HealthInsuranceDataBeanTable
				.setQ21GPrivatePayHealthInsuranceAtExitLeavers(BigInteger
						.valueOf(0));

		q21HealthInsuranceDataBeanTable
				.setQ21HStateHealthInsuranceForAdultsAtEntry(BigInteger
						.valueOf(0));
		q21HealthInsuranceDataBeanTable
				.setQ21HStateHealthInsuranceForAdultsAtLatestStayers(BigInteger
						.valueOf(0));
		q21HealthInsuranceDataBeanTable
				.setQ21HStateHealthInsuranceForAdultsAtExitLeavers(BigInteger
						.valueOf(0));

		q21HealthInsuranceDataBeanTable
				.setQ21INoHealthInsuranceAtEntry(BigInteger.valueOf(0));
		q21HealthInsuranceDataBeanTable
				.setQ21INoHealthInsuranceAtLatestStayers(BigInteger.valueOf(0));
		q21HealthInsuranceDataBeanTable
				.setQ21INoHealthInsuranceAtExitLeavers(BigInteger.valueOf(0));

		q21HealthInsuranceDataBeanTable.setQ21JClientRefusedAtEntry(BigInteger
				.valueOf(0));
		q21HealthInsuranceDataBeanTable
				.setQ21JClientRefusedAtLatestStayers(BigInteger.valueOf(0));
		q21HealthInsuranceDataBeanTable
				.setQ21JClientRefusedAtExitLeavers(BigInteger.valueOf(0));

		q21HealthInsuranceDataBeanTable
				.setQ21KDataNotCollectedAtEntry(BigInteger.valueOf(0));
		q21HealthInsuranceDataBeanTable
				.setQ21KDataNotCollectedAtLatestStayers(BigInteger.valueOf(0));
		q21HealthInsuranceDataBeanTable
				.setQ21KDataNotCollectedAtExitLeavers(BigInteger.valueOf(0));

		q21HealthInsuranceDataBeanTable
				.setQ21LNoOfAdultStayersNotRequiredAtEntry(BigInteger
						.valueOf(0));
		q21HealthInsuranceDataBeanTable
				.setQ21LNoOfAdultStayersNotRequiredAtLatestStayers(BigInteger
						.valueOf(0));
		q21HealthInsuranceDataBeanTable
				.setQ21LNoOfAdultStayersNotRequiredAtExitLeavers(BigInteger
						.valueOf(0));

		q21HealthInsuranceDataBeanTable
				.setQ21M1SourceOfHealthInsuranceAtEntry(BigInteger.valueOf(0));
		q21HealthInsuranceDataBeanTable
				.setQ21M1SourceOfHealthInsuranceAtLatestStayers(BigInteger
						.valueOf(0));
		q21HealthInsuranceDataBeanTable
				.setQ21M1SourceOfHealthInsuranceAtExitLeavers(BigInteger
						.valueOf(0));

		q21HealthInsuranceDataBeanTable
				.setQ21NMoreThan1SourceOfHealthInsuranceAtEntry(BigInteger
						.valueOf(0));
		q21HealthInsuranceDataBeanTable
				.setQ21NMoreThan1SourceOfHealthInsuranceAtLatestStayers(BigInteger
						.valueOf(0));
		q21HealthInsuranceDataBeanTable
				.setQ21NMoreThan1SourceOfHealthInsuranceAtExitLeavers(BigInteger
						.valueOf(0));

		return q21HealthInsuranceDataBeanTable;

	}

	public static DataBean getQ22a1LengthOfParticipationCoCProjectsList(

	BigInteger q22a1A30DaysOrLessTotal, BigInteger q22a1A30DaysOrLessLeavers,
			BigInteger q22a1A30DaysOrLessStayers,

			BigInteger q22a1B31To60DaysTotal,
			BigInteger q22a1B31To60DaysLeavers,
			BigInteger q22a1B31To60DaysStayers,

			BigInteger q22a1C61To180DaysTotal,
			BigInteger q22a1C61To180DaysLeavers,
			BigInteger q22a1C61To180DaysStayers,

			BigInteger q22a1D181To365DaysTotal,
			BigInteger q22a1D181To365DaysLeavers,
			BigInteger q22a1D181To365DaysStayers,

			BigInteger q22a1E366To730DaysTotal,
			BigInteger q22a1E366To730DaysLeavers,
			BigInteger q22a1E366To730DaysStayers,

			BigInteger q22a1F731To1095DaysTotal,
			BigInteger q22a1F731To1095DaysLeavers,
			BigInteger q22a1F731To1095DaysStayers,

			BigInteger q22a1G1096To1460DaysTotal,
			BigInteger q22a1G1096To1460DaysLeavers,
			BigInteger q22a1G1096To1460DaysStayers,

			BigInteger q22a1H1461To1825DaysTotal,
			BigInteger q22a1H1461To1825DaysLeavers,
			BigInteger q22a1H1461To1825DaysStayers,

			BigInteger q22a1IMoreThan1825DaysTotal,
			BigInteger q22a1IMoreThan1825DaysLeavers,
			BigInteger q22a1IMoreThan1825DaysStayers,

			BigInteger q22a1JInfoMissingTotal,
			BigInteger q22a1JInfoMissingLeavers,
			BigInteger q22a1JInfoMissingStayers,

			BigInteger q22a1KTotTotal, BigInteger q22a1KTotLeavers,
			BigInteger q22a1KTotStayers,
			DataBean q22a1LengthOfParticipationCoCProjectsTable) {

		q22a1LengthOfParticipationCoCProjectsTable
				.setQ22a1A30DaysOrLessTotal(BigInteger.valueOf(0));
		q22a1LengthOfParticipationCoCProjectsTable
				.setQ22a1A30DaysOrLessLeavers(BigInteger.valueOf(0));
		q22a1LengthOfParticipationCoCProjectsTable
				.setQ22a1A30DaysOrLessStayers(BigInteger.valueOf(0));

		q22a1LengthOfParticipationCoCProjectsTable
				.setQ22a1B31To60DaysTotal(BigInteger.valueOf(0));
		q22a1LengthOfParticipationCoCProjectsTable
				.setQ22a1B31To60DaysLeavers(BigInteger.valueOf(0));
		q22a1LengthOfParticipationCoCProjectsTable
				.setQ22a1B31To60DaysStayers(BigInteger.valueOf(0));

		q22a1LengthOfParticipationCoCProjectsTable
				.setQ22a1C61To180DaysTotal(BigInteger.valueOf(0));
		q22a1LengthOfParticipationCoCProjectsTable
				.setQ22a1C61To180DaysLeavers(BigInteger.valueOf(0));
		q22a1LengthOfParticipationCoCProjectsTable
				.setQ22a1C61To180DaysStayers(BigInteger.valueOf(0));

		q22a1LengthOfParticipationCoCProjectsTable
				.setQ22a1D181To365DaysTotal(BigInteger.valueOf(0));
		q22a1LengthOfParticipationCoCProjectsTable
				.setQ22a1D181To365DaysLeavers(BigInteger.valueOf(0));
		q22a1LengthOfParticipationCoCProjectsTable
				.setQ22a1D181To365DaysStayers(BigInteger.valueOf(0));

		q22a1LengthOfParticipationCoCProjectsTable
				.setQ22a1E366To730DaysTotal(BigInteger.valueOf(0));
		q22a1LengthOfParticipationCoCProjectsTable
				.setQ22a1E366To730DaysLeavers(BigInteger.valueOf(0));
		q22a1LengthOfParticipationCoCProjectsTable
				.setQ22a1E366To730DaysStayers(BigInteger.valueOf(0));

		q22a1LengthOfParticipationCoCProjectsTable
				.setQ22a1F731To1095DaysTotal(BigInteger.valueOf(0));
		q22a1LengthOfParticipationCoCProjectsTable
				.setQ22a1F731To1095DaysLeavers(BigInteger.valueOf(0));
		q22a1LengthOfParticipationCoCProjectsTable
				.setQ22a1F731To1095DaysStayers(BigInteger.valueOf(0));

		q22a1LengthOfParticipationCoCProjectsTable
				.setQ22a1G1096To1460DaysTotal(BigInteger.valueOf(0));
		q22a1LengthOfParticipationCoCProjectsTable
				.setQ22a1G1096To1460DaysLeavers(BigInteger.valueOf(0));
		q22a1LengthOfParticipationCoCProjectsTable
				.setQ22a1G1096To1460DaysStayers(BigInteger.valueOf(0));

		q22a1LengthOfParticipationCoCProjectsTable
				.setQ22a1H1461To1825DaysTotal(BigInteger.valueOf(0));
		q22a1LengthOfParticipationCoCProjectsTable
				.setQ22a1H1461To1825DaysLeavers(BigInteger.valueOf(0));
		q22a1LengthOfParticipationCoCProjectsTable
				.setQ22a1H1461To1825DaysStayers(BigInteger.valueOf(0));

		q22a1LengthOfParticipationCoCProjectsTable
				.setQ22a1IMoreThan1825DaysTotal(BigInteger.valueOf(0));
		q22a1LengthOfParticipationCoCProjectsTable
				.setQ22a1IMoreThan1825DaysLeavers(BigInteger.valueOf(0));
		q22a1LengthOfParticipationCoCProjectsTable
				.setQ22a1IMoreThan1825DaysStayers(BigInteger.valueOf(0));

		q22a1LengthOfParticipationCoCProjectsTable
				.setQ22a1JInfoMissingTotal(BigInteger.valueOf(0));
		q22a1LengthOfParticipationCoCProjectsTable
				.setQ22a1JInfoMissingLeavers(BigInteger.valueOf(0));
		q22a1LengthOfParticipationCoCProjectsTable
				.setQ22a1JInfoMissingStayers(BigInteger.valueOf(0));

		q22a1LengthOfParticipationCoCProjectsTable.setQ22a1KTotTotal(BigInteger
				.valueOf(0));
		q22a1LengthOfParticipationCoCProjectsTable
				.setQ22a1KTotLeavers(BigInteger.valueOf(0));
		q22a1LengthOfParticipationCoCProjectsTable
				.setQ22a1KTotStayers(BigInteger.valueOf(0));

		return q22a1LengthOfParticipationCoCProjectsTable;

	}

	public static DataBean getQ22bAverageAndMedianLengthOfParticipationInDaysList(

	BigInteger q22bAverageLengthInDaysTotal,
			BigInteger q22bAverageLengthInDaysLeavers,
			BigInteger q22bAverageLengthInDaysStayers,

			BigInteger q22bMedianLengthInDaysTotal,
			BigInteger q22bMedianLengthInDaysLeavers,
			BigInteger q22bMedianLengthInDaysStayers,
			DataBean q22bAverageAndMedianLengthOfParticipationInDaysTable) {

		q22bAverageAndMedianLengthOfParticipationInDaysTable
				.setQ22bAverageLengthInDaysTotal(BigInteger.valueOf(0));
		q22bAverageAndMedianLengthOfParticipationInDaysTable
				.setQ22bAverageLengthInDaysLeavers(BigInteger.valueOf(0));
		q22bAverageAndMedianLengthOfParticipationInDaysTable
				.setQ22bAverageLengthInDaysStayers(BigInteger.valueOf(0));

		q22bAverageAndMedianLengthOfParticipationInDaysTable
				.setQ22bMedianLengthInDaysTotal(BigInteger.valueOf(0));
		q22bAverageAndMedianLengthOfParticipationInDaysTable
				.setQ22bMedianLengthInDaysStayers(BigInteger.valueOf(0));
		q22bAverageAndMedianLengthOfParticipationInDaysTable
				.setQ22bMedianLengthInDaysLeavers(BigInteger.valueOf(0));
		return q22bAverageAndMedianLengthOfParticipationInDaysTable;

	}

	public static DataBean getQ23ExitDestinationMoreThan90DaysList(
			BigInteger q23APermanentDestinationsTotal,
			BigInteger q23APermanentDestinationsWithoutChild,
			BigInteger q23APermanentDestinationsWithChildAndAdults,
			BigInteger q23APermanentDestinationsWithOnlyChild,
			BigInteger q23APermanentDestinationsUnknownHouseHold,

			BigInteger q23A01MovedFromOneHOPWATotal,
			BigInteger q23A01MovedFromOneHOPWAWithoutChild,
			BigInteger q23A01MovedFromOneHOPWAWithChildAndAdults,
			BigInteger q23A01MovedFromOneHOPWAWithOnlyChild,
			BigInteger q23A01MovedFromOneHOPWAUnknownHouseHold,

			BigInteger q23A02OwnedByClientNoOngoingSubsidyTotal,
			BigInteger q23A02OwnedByClientNoOngoingSubsidyWithoutChild,
			BigInteger q23A02OwnedByClientNoOngoingSubsidyWithChildAndAdults,
			BigInteger q23A02OwnedByClientNoOngoingSubsidyWithOnlyChild,
			BigInteger q23A02OwnedByClientNoOngoingSubsidyUnknownHouseHold,

			BigInteger q23A03OwnedByClientWithOngoingSubsidyTotal,
			BigInteger q23A03OwnedByClientWithOngoingSubsidyWithoutChild,
			BigInteger q23A03OwnedByClientWithOngoingSubsidyWithChildAndAdults,
			BigInteger q23A03OwnedByClientWithOngoingSubsidyWithOnlyChild,
			BigInteger q23A03OwnedByClientWithOngoingSubsidyUnknownHouseHold,

			BigInteger q23A04RentalByClientNoOngoingSubsidyTotal,
			BigInteger q23A04RentalByClientNoOngoingSubsidyWithoutChild,
			BigInteger q23A04RentalByClientNoOngoingSubsidyWithChildAndAdults,
			BigInteger q23A04RentalByClientNoOngoingSubsidyWithOnlyChild,
			BigInteger q23A04RentalByClientNoOngoingSubsidyUnknownHouseHold,

			BigInteger q23A05RentalByClientVASHSubsidyTotal,
			BigInteger q23A05RentalByClientVASHSubsidyWithoutChild,
			BigInteger q23A05RentalByClientVASHSubsidyWithChildAndAdults,
			BigInteger q23A05RentalByClientVASHSubsidyWithOnlyChild,
			BigInteger q23A05RentalByClientVASHSubsidyUnknownHouseHold,

			BigInteger q23A06RentalByClientwithGPDTIPHousingTotal,
			BigInteger q23A06RentalByClientwithGPDTIPHousingWithoutChild,
			BigInteger q23A06RentalByClientwithGPDTIPHousingWithChildAndAdults,
			BigInteger q23A06RentalByClientwithGPDTIPHousingWithOnlyChild,
			BigInteger q23A06RentalByClientwithGPDTIPHousingUnknownHouseHold,

			BigInteger q23A07RentalByClientOtherOngoingSubsidyTotal,
			BigInteger q23A07RentalByClientOtherOngoingSubsidyWithoutChild,
			BigInteger q23A07RentalByClientOtherOngoingSubsidyWithChildAndAdults,
			BigInteger q23A07RentalByClientOtherOngoingSubsidyWithOnlyChild,
			BigInteger q23A07RentalByClientOtherOngoingSubsidyUnknownHouseHold,

			BigInteger q23A08PermanentHousingForHomelessTotal,
			BigInteger q23A08PermanentHousingForHomelessWithoutChild,
			BigInteger q23A08PermanentHousingForHomelessWithChildAndAdults,
			BigInteger q23A08PermanentHousingForHomelessWithOnlyChild,
			BigInteger q23A08PermanentHousingForHomelessUnknownHouseHold,

			BigInteger q23A09StayingOrLivingWithFamilyPermanentTotal,
			BigInteger q23A09StayingOrLivingWithFamilyPermanentWithoutChild,
			BigInteger q23A09StayingOrLivingWithFamilyPermanentWithChildAndAdults,
			BigInteger q23A09StayingOrLivingWithFamilyPermanentWithOnlyChild,
			BigInteger q23A09StayingOrLivingWithFamilyPermanentUnknownHouseHold,

			BigInteger q23A10StayingOrLivingWithFriendsPermanentTotal,
			BigInteger q23A10StayingOrLivingWithFriendsPermanentWithoutChild,
			BigInteger q23A10StayingOrLivingWithFriendsPermanentWithChildAndAdults,
			BigInteger q23A10StayingOrLivingWithFriendsPermanentWithOnlyChild,
			BigInteger q23A10StayingOrLivingWithFriendsPermanentUnknownHouseHold,

			BigInteger q23AzTotTotal,
			BigInteger q23AzTotWithoutChild,
			BigInteger q23AzTotWithChildAndAdults,
			BigInteger q23AzTotWithOnlyChild,
			BigInteger q23AzTotUnknownHouseHold,

			BigInteger q23BTemporaryDestinationsTotal,
			BigInteger q23BTemporaryDestinationsWithoutChild,
			BigInteger q23BTemporaryDestinationsWithChildAndAdults,
			BigInteger q23BTemporaryDestinationsWithOnlyChild,
			BigInteger q23BTemporaryDestinationsUnknownHouseHold,

			BigInteger q23B1EmergencyShelterTotal,
			BigInteger q23B1EmergencyShelterWithoutChild,
			BigInteger q23B1EmergencyShelterWithChildAndAdults,
			BigInteger q23B1EmergencyShelterWithOnlyChild,
			BigInteger q23B1EmergencyShelterUnknownHouseHold,

			BigInteger q23B2MovedFromOneHOPWATotal,
			BigInteger q23B2MovedFromOneHOPWAWithoutChild,
			BigInteger q23B2MovedFromOneHOPWAWithChildAndAdults,
			BigInteger q23B2MovedFromOneHOPWAWithOnlyChild,
			BigInteger q23B2MovedFromOneHOPWAUnknownHouseHold,

			BigInteger q23B3TransitionalHousingForHomeLessTotal,
			BigInteger q23B3TransitionalHousingForHomeLessWithoutChild,
			BigInteger q23B3TransitionalHousingForHomeLessWithChildAndAdults,
			BigInteger q23B3TransitionalHousingForHomeLessWithOnlyChild,
			BigInteger q23B3TransitionalHousingForHomeLessUnknownHouseHold,

			BigInteger q23B4StayingWithFamilyTemporaryTenureTotal,
			BigInteger q23B4StayingWithFamilyTemporaryTenureWithoutChild,
			BigInteger q23B4StayingWithFamilyTemporaryTenureWithChildAndAdults,
			BigInteger q23B4StayingWithFamilyTemporaryTenureWithOnlyChild,
			BigInteger q23B4StayingWithFamilyTemporaryTenureUnknownHouseHold,

			BigInteger q23B5StayingWithFriendsTemporaryTenureTotal,
			BigInteger q23B5StayingWithFriendsTemporaryTenureWithoutChild,
			BigInteger q23B5StayingWithFriendsTemporaryTenureWithChildAndAdults,
			BigInteger q23B5StayingWithFriendsTemporaryTenureWithOnlyChild,
			BigInteger q23B5StayingWithFriendsTemporaryTenureUnknownHouseHold,

			BigInteger q23B6PlaceNotMeantForHumanHabitationTotal,
			BigInteger q23B6PlaceNotMeantForHumanHabitationWithoutChild,
			BigInteger q23B6PlaceNotMeantForHumanHabitationWithChildAndAdults,
			BigInteger q23B6PlaceNotMeantForHumanHabitationWithOnlyChild,
			BigInteger q23B6PlaceNotMeantForHumanHabitationUnknownHouseHold,

			BigInteger q23B7SafeHavenTotal,
			BigInteger q23B7SafeHavenWithoutChild,
			BigInteger q23B7SafeHavenWithChildAndAdults,
			BigInteger q23B7SafeHavenWithOnlyChild,
			BigInteger q23B7SafeHavenUnknownHouseHold,

			BigInteger q23B8HotelOrMotelPaidByClientTotal,
			BigInteger q23B8HotelOrMotelPaidByClientWithoutChild,
			BigInteger q23B8HotelOrMotelPaidByClientWithChildAndAdults,
			BigInteger q23B8HotelOrMotelPaidByClientWithOnlyChild,
			BigInteger q23B8HotelOrMotelPaidByClientUnknownHouseHold,

			BigInteger q23BzTotTotal,
			BigInteger q23BzTotWithoutChild,
			BigInteger q23BzTotWithChildAndAdults,
			BigInteger q23BzTotWithOnlyChild,
			BigInteger q23BzTotUnknownHouseHold,

			BigInteger q23CInstitutionalSettingsTotal,
			BigInteger q23CInstitutionalSettingsWithoutChild,
			BigInteger q23CInstitutionalSettingsWithChildAndAdults,
			BigInteger q23CInstitutionalSettingsWithOnlyChild,
			BigInteger q23CInstitutionalSettingsUnknownHouseHold,

			BigInteger q23C1FosterCareHomeOrGroupFosterCareTotal,
			BigInteger q23C1FosterCareHomeOrGroupFosterCareWithoutChild,
			BigInteger q23C1FosterCareHomeOrGroupFosterCareWithChildAndAdults,
			BigInteger q23C1FosterCareHomeOrGroupFosterCareWithOnlyChild,
			BigInteger q23C1FosterCareHomeOrGroupFosterCareUnknownHouseHold,

			BigInteger q23C2PsychiatricHospitalOrOtherTotal,
			BigInteger q23C2PsychiatricHospitalOrOtherWithoutChild,
			BigInteger q23C2PsychiatricHospitalOrOtherWithChildAndAdults,
			BigInteger q23C2PsychiatricHospitalOrOtherWithOnlyChild,
			BigInteger q23C2PsychiatricHospitalOrOtherUnknownHouseHold,

			BigInteger q23C3SubstanceAbuseTreatmentFacilityTotal,
			BigInteger q23C3SubstanceAbuseTreatmentFacilityWithoutChild,
			BigInteger q23C3SubstanceAbuseTreatmentFacilityWithChildAndAdults,
			BigInteger q23C3SubstanceAbuseTreatmentFacilityWithOnlyChild,
			BigInteger q23C3SubstanceAbuseTreatmentFacilityUnknownHouseHold,

			BigInteger q23C4HospitalOrOtherTotal,
			BigInteger q23C4HospitalOrOtherWithoutChild,
			BigInteger q23C4HospitalOrOtherWithChildAndAdults,
			BigInteger q23C4HospitalOrOtherWithOnlyChild,
			BigInteger q23C4HospitalOrOtherUnknownHouseHold,

			BigInteger q23C5JailPrisonOrJuvenileDetentionTotal,
			BigInteger q23C5JailPrisonOrJuvenileDetentionWithoutChild,
			BigInteger q23C5JailPrisonOrJuvenileDetentionWithChildAndAdults,
			BigInteger q23C5JailPrisonOrJuvenileDetentionWithOnlyChild,
			BigInteger q23C5JailPrisonOrJuvenileDetentionUnknownHouseHold,

			BigInteger q23C6LongTermCareFacilityOrNursingHomeTotal,
			BigInteger q23C6LongTermCareFacilityOrNursingHomeWithoutChild,
			BigInteger q23C6LongTermCareFacilityOrNursingHomeWithChildAndAdults,
			BigInteger q23C6LongTermCareFacilityOrNursingHomeWithOnlyChild,
			BigInteger q23C6LongTermCareFacilityOrNursingHomeUnknownHouseHold,

			BigInteger q23CzTotTotal, BigInteger q23CzTotWithoutChild,
			BigInteger q23CzTotWithChildAndAdults,
			BigInteger q23CzTotWithOnlyChild,
			BigInteger q23CzTotUnknownHouseHold,

			BigInteger q23DOtherDestinationsTotal,
			BigInteger q23DOtherDestinationsWithoutChild,
			BigInteger q23DOtherDestinationsWithChildAndAdults,
			BigInteger q23DOtherDestinationsWithOnlyChild,
			BigInteger q23DOtherDestinationsUnknownHouseHold,

			BigInteger q23D1ResidentialProjectorHalfwayHouseTotal,
			BigInteger q23D1ResidentialProjectorHalfwayHouseWithoutChild,
			BigInteger q23D1ResidentialProjectorHalfwayHouseWithChildAndAdults,
			BigInteger q23D1ResidentialProjectorHalfwayHouseWithOnlyChild,
			BigInteger q23D1ResidentialProjectorHalfwayHouseUnknownHouseHold,

			BigInteger q23D2DeceasedTotal,
			BigInteger q23D2DeceasedWithoutChild,
			BigInteger q23D2DeceasedWithChildAndAdults,
			BigInteger q23D2DeceasedWithOnlyChild,
			BigInteger q23D2DeceasedUnknownHouseHold,

			BigInteger q23D3OtherTotal, BigInteger q23D3OtherWithoutChild,
			BigInteger q23D3OtherWithChildAndAdults,
			BigInteger q23D3OtherWithOnlyChild,
			BigInteger q23D3OtherUnknownHouseHold,

			BigInteger q23D4DKRTotal, BigInteger q23D4DKRWithoutChild,
			BigInteger q23D4DKRWithChildAndAdults,
			BigInteger q23D4DKRWithOnlyChild,
			BigInteger q23D4DKRUnknownHouseHold,

			BigInteger q23D5InfoMissingTotal,
			BigInteger q23D5InfoMissingWithoutChild,
			BigInteger q23D5InfoMissingWithChildAndAdults,
			BigInteger q23D5InfoMissingWithOnlyChild,
			BigInteger q23D5InfoMissingUnknownHouseHold,

			BigInteger q23DzTotTotal, BigInteger q23DzTotWithoutChild,
			BigInteger q23DzTotWithChildAndAdults,
			BigInteger q23DzTotWithOnlyChild,
			BigInteger q23DzTotUnknownHouseHold,

			BigInteger q23ETotTotal, BigInteger q23ETotWithoutChild,
			BigInteger q23ETotWithChildAndAdults,
			BigInteger q23ETotWithOnlyChild,
			BigInteger q23ETotUnknownHouseHold,

			BigInteger q23PercentageWithChildAndAdults,
			BigInteger q23PercentageUnknownHouseHold,
			BigInteger q23PercentageWithOnlyChild,
			BigInteger q23PercentageWithoutChild,
			BigInteger q23PercentageTotal,

			BigInteger q23TotPersonsDstnsWithoutChild,
			BigInteger q23TotPersonsDstnsTotal,
			BigInteger q23TotPersonsDstnsUnknownHouseHold,
			BigInteger q23TotPersonsDstnsWithOnlyChild,
			BigInteger q23TotPersonsDstnsWithChildAndAdults,

			BigInteger q23TotPersonsExistTotal,
			BigInteger q23TotPersonsExistWithoutChild,
			BigInteger q23TotPersonsExistWithChildAndAdults,
			BigInteger q23TotPersonsExistWithOnlyChild,
			BigInteger q23TotPersonsExistUnknownHouseHold,
			DataBean q23ExitDestinationMoreThan90DaysTable) {

		q23ExitDestinationMoreThan90DaysTable
				.setQ23APermanentDestinationsTotal(BigInteger.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23APermanentDestinationsWithoutChild(BigInteger.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23APermanentDestinationsWithChildAndAdults(BigInteger
						.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23APermanentDestinationsWithOnlyChild(BigInteger
						.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23APermanentDestinationsUnknownHouseHold(BigInteger
						.valueOf(0));

		q23ExitDestinationMoreThan90DaysTable
				.setQ23A01MovedFromOneHOPWATotal(BigInteger.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23A01MovedFromOneHOPWAWithoutChild(BigInteger.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23A01MovedFromOneHOPWAWithChildAndAdults(BigInteger
						.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23A01MovedFromOneHOPWAWithOnlyChild(BigInteger.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23A01MovedFromOneHOPWAUnknownHouseHold(BigInteger
						.valueOf(0));

		q23ExitDestinationMoreThan90DaysTable
				.setQ23A02OwnedByClientNoOngoingSubsidyTotal(BigInteger
						.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23A02OwnedByClientNoOngoingSubsidyWithoutChild(BigInteger
						.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23A02OwnedByClientNoOngoingSubsidyWithChildAndAdults(BigInteger
						.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23A02OwnedByClientNoOngoingSubsidyWithOnlyChild(BigInteger
						.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23A02OwnedByClientNoOngoingSubsidyUnknownHouseHold(BigInteger
						.valueOf(0));

		q23ExitDestinationMoreThan90DaysTable
				.setQ23A03OwnedByClientWithOngoingSubsidyTotal(BigInteger
						.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23A03OwnedByClientWithOngoingSubsidyWithoutChild(BigInteger
						.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23A03OwnedByClientWithOngoingSubsidyWithChildAndAdults(BigInteger
						.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23A03OwnedByClientWithOngoingSubsidyWithOnlyChild(BigInteger
						.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23A03OwnedByClientWithOngoingSubsidyUnknownHouseHold(BigInteger
						.valueOf(0));

		q23ExitDestinationMoreThan90DaysTable
				.setQ23A04RentalByClientNoOngoingSubsidyTotal(BigInteger
						.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23A04RentalByClientNoOngoingSubsidyWithoutChild(BigInteger
						.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23A04RentalByClientNoOngoingSubsidyWithChildAndAdults(BigInteger
						.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23A04RentalByClientNoOngoingSubsidyWithOnlyChild(BigInteger
						.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23A04RentalByClientNoOngoingSubsidyUnknownHouseHold(BigInteger
						.valueOf(0));

		q23ExitDestinationMoreThan90DaysTable
				.setQ23A05RentalByClientVASHSubsidyTotal(BigInteger.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23A05RentalByClientVASHSubsidyWithoutChild(BigInteger
						.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23A05RentalByClientVASHSubsidyWithChildAndAdults(BigInteger
						.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23A05RentalByClientVASHSubsidyWithOnlyChild(BigInteger
						.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23A05RentalByClientVASHSubsidyUnknownHouseHold(BigInteger
						.valueOf(0));

		q23ExitDestinationMoreThan90DaysTable
				.setQ23A06RentalByClientwithGPDTIPHousingTotal(BigInteger
						.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23A06RentalByClientwithGPDTIPHousingWithoutChild(BigInteger
						.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23A06RentalByClientwithGPDTIPHousingWithChildAndAdults(BigInteger
						.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23A06RentalByClientwithGPDTIPHousingWithOnlyChild(BigInteger
						.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23A06RentalByClientwithGPDTIPHousingUnknownHouseHold(BigInteger
						.valueOf(0));

		q23ExitDestinationMoreThan90DaysTable
				.setQ23A07RentalByClientOtherOngoingSubsidyTotal(BigInteger
						.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23A07RentalByClientOtherOngoingSubsidyWithoutChild(BigInteger
						.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23A07RentalByClientOtherOngoingSubsidyWithChildAndAdults(BigInteger
						.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23A07RentalByClientOtherOngoingSubsidyWithOnlyChild(BigInteger
						.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23A07RentalByClientOtherOngoingSubsidyUnknownHouseHold(BigInteger
						.valueOf(0));

		q23ExitDestinationMoreThan90DaysTable
				.setQ23A08PermanentHousingForHomelessTotal(BigInteger
						.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23A08PermanentHousingForHomelessWithoutChild(BigInteger
						.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23A08PermanentHousingForHomelessWithChildAndAdults(BigInteger
						.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23A08PermanentHousingForHomelessWithOnlyChild(BigInteger
						.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23A08PermanentHousingForHomelessUnknownHouseHold(BigInteger
						.valueOf(0));

		q23ExitDestinationMoreThan90DaysTable
				.setQ23A09StayingOrLivingWithFamilyPermanentTotal(BigInteger
						.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23A09StayingOrLivingWithFamilyPermanentWithoutChild(BigInteger
						.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23A09StayingOrLivingWithFamilyPermanentWithChildAndAdults(BigInteger
						.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23A09StayingOrLivingWithFamilyPermanentWithOnlyChild(BigInteger
						.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23A09StayingOrLivingWithFamilyPermanentUnknownHouseHold(BigInteger
						.valueOf(0));

		q23ExitDestinationMoreThan90DaysTable
				.setQ23A10StayingOrLivingWithFriendsPermanentTotal(BigInteger
						.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23A10StayingOrLivingWithFriendsPermanentWithoutChild(BigInteger
						.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23A10StayingOrLivingWithFriendsPermanentWithChildAndAdults(BigInteger
						.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23A10StayingOrLivingWithFriendsPermanentWithOnlyChild(BigInteger
						.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23A10StayingOrLivingWithFriendsPermanentUnknownHouseHold(BigInteger
						.valueOf(0));

		q23ExitDestinationMoreThan90DaysTable.setQ23AzTotTotal(BigInteger
				.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23AzTotWithoutChild(BigInteger.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23AzTotWithChildAndAdults(BigInteger.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23AzTotWithOnlyChild(BigInteger.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23AzTotUnknownHouseHold(BigInteger.valueOf(0));

		q23ExitDestinationMoreThan90DaysTable
				.setQ23BTemporaryDestinationsTotal(BigInteger.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23BTemporaryDestinationsWithoutChild(BigInteger.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23BTemporaryDestinationsWithChildAndAdults(BigInteger
						.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23BTemporaryDestinationsWithOnlyChild(BigInteger
						.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23BTemporaryDestinationsUnknownHouseHold(BigInteger
						.valueOf(0));

		q23ExitDestinationMoreThan90DaysTable
				.setQ23B1EmergencyShelterTotal(BigInteger.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23B1EmergencyShelterWithoutChild(BigInteger.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23B1EmergencyShelterWithChildAndAdults(BigInteger
						.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23B1EmergencyShelterWithOnlyChild(BigInteger.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23B1EmergencyShelterUnknownHouseHold(BigInteger.valueOf(0));

		q23ExitDestinationMoreThan90DaysTable
				.setQ23B2MovedFromOneHOPWATotal(BigInteger.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23B2MovedFromOneHOPWAWithoutChild(BigInteger.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23B2MovedFromOneHOPWAWithChildAndAdults(BigInteger
						.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23B2MovedFromOneHOPWAWithOnlyChild(BigInteger.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23B2MovedFromOneHOPWAUnknownHouseHold(BigInteger
						.valueOf(0));

		q23ExitDestinationMoreThan90DaysTable
				.setQ23B3TransitionalHousingForHomeLessTotal(BigInteger
						.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23B3TransitionalHousingForHomeLessWithoutChild(BigInteger
						.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23B3TransitionalHousingForHomeLessWithChildAndAdults(BigInteger
						.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23B3TransitionalHousingForHomeLessWithOnlyChild(BigInteger
						.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23B3TransitionalHousingForHomeLessUnknownHouseHold(BigInteger
						.valueOf(0));

		q23ExitDestinationMoreThan90DaysTable
				.setQ23B4StayingWithFamilyTemporaryTenureTotal(BigInteger
						.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23B4StayingWithFamilyTemporaryTenureWithoutChild(BigInteger
						.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23B4StayingWithFamilyTemporaryTenureWithChildAndAdults(BigInteger
						.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23B4StayingWithFamilyTemporaryTenureWithOnlyChild(BigInteger
						.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23B4StayingWithFamilyTemporaryTenureUnknownHouseHold(BigInteger
						.valueOf(0));

		q23ExitDestinationMoreThan90DaysTable
				.setQ23B5StayingWithFriendsTemporaryTenureTotal(BigInteger
						.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23B5StayingWithFriendsTemporaryTenureWithoutChild(BigInteger
						.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23B5StayingWithFriendsTemporaryTenureWithChildAndAdults(BigInteger
						.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23B5StayingWithFriendsTemporaryTenureWithOnlyChild(BigInteger
						.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23B5StayingWithFriendsTemporaryTenureUnknownHouseHold(BigInteger
						.valueOf(0));

		q23ExitDestinationMoreThan90DaysTable
				.setQ23B6PlaceNotMeantForHumanHabitationTotal(BigInteger
						.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23B6PlaceNotMeantForHumanHabitationWithoutChild(BigInteger
						.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23B6PlaceNotMeantForHumanHabitationWithChildAndAdults(BigInteger
						.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23B6PlaceNotMeantForHumanHabitationWithOnlyChild(BigInteger
						.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23B6PlaceNotMeantForHumanHabitationUnknownHouseHold(BigInteger
						.valueOf(0));

		q23ExitDestinationMoreThan90DaysTable.setQ23B7SafeHavenTotal(BigInteger
				.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23B7SafeHavenWithoutChild(BigInteger.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23B7SafeHavenWithChildAndAdults(BigInteger.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23B7SafeHavenWithOnlyChild(BigInteger.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23B7SafeHavenUnknownHouseHold(BigInteger.valueOf(0));

		q23ExitDestinationMoreThan90DaysTable
				.setQ23B8HotelOrMotelPaidByClientTotal(BigInteger.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23B8HotelOrMotelPaidByClientWithoutChild(BigInteger
						.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23B8HotelOrMotelPaidByClientWithChildAndAdults(BigInteger
						.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23B8HotelOrMotelPaidByClientWithOnlyChild(BigInteger
						.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23B8HotelOrMotelPaidByClientUnknownHouseHold(BigInteger
						.valueOf(0));

		q23ExitDestinationMoreThan90DaysTable.setQ23BzTotTotal(BigInteger
				.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23BzTotWithoutChild(BigInteger.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23BzTotWithChildAndAdults(BigInteger.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23BzTotWithOnlyChild(BigInteger.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23BzTotUnknownHouseHold(BigInteger.valueOf(0));

		q23ExitDestinationMoreThan90DaysTable
				.setQ23CInstitutionalSettingsTotal(BigInteger.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23CInstitutionalSettingsWithoutChild(BigInteger.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23CInstitutionalSettingsWithChildAndAdults(BigInteger
						.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23CInstitutionalSettingsWithOnlyChild(BigInteger
						.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23CInstitutionalSettingsUnknownHouseHold(BigInteger
						.valueOf(0));

		q23ExitDestinationMoreThan90DaysTable
				.setQ23C1FosterCareHomeOrGroupFosterCareTotal(BigInteger
						.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23C1FosterCareHomeOrGroupFosterCareWithoutChild(BigInteger
						.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23C1FosterCareHomeOrGroupFosterCareWithChildAndAdults(BigInteger
						.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23C1FosterCareHomeOrGroupFosterCareWithOnlyChild(BigInteger
						.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23C1FosterCareHomeOrGroupFosterCareUnknownHouseHold(BigInteger
						.valueOf(0));

		q23ExitDestinationMoreThan90DaysTable
				.setQ23C2PsychiatricHospitalOrOtherTotal(BigInteger.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23C2PsychiatricHospitalOrOtherWithoutChild(BigInteger
						.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23C2PsychiatricHospitalOrOtherWithChildAndAdults(BigInteger
						.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23C2PsychiatricHospitalOrOtherWithOnlyChild(BigInteger
						.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23C2PsychiatricHospitalOrOtherUnknownHouseHold(BigInteger
						.valueOf(0));

		q23ExitDestinationMoreThan90DaysTable
				.setQ23C3SubstanceAbuseTreatmentFacilityTotal(BigInteger
						.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23C3SubstanceAbuseTreatmentFacilityWithoutChild(BigInteger
						.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23C3SubstanceAbuseTreatmentFacilityWithChildAndAdults(BigInteger
						.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23C3SubstanceAbuseTreatmentFacilityWithOnlyChild(BigInteger
						.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23C3SubstanceAbuseTreatmentFacilityUnknownHouseHold(BigInteger
						.valueOf(0));

		q23ExitDestinationMoreThan90DaysTable
				.setQ23C4HospitalOrOtherTotal(BigInteger.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23C4HospitalOrOtherWithoutChild(BigInteger.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23C4HospitalOrOtherWithChildAndAdults(BigInteger
						.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23C4HospitalOrOtherWithOnlyChild(BigInteger.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23C4HospitalOrOtherUnknownHouseHold(BigInteger.valueOf(0));

		q23ExitDestinationMoreThan90DaysTable
				.setQ23C5JailPrisonOrJuvenileDetentionTotal(BigInteger
						.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23C5JailPrisonOrJuvenileDetentionWithoutChild(BigInteger
						.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23C5JailPrisonOrJuvenileDetentionWithChildAndAdults(BigInteger
						.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23C5JailPrisonOrJuvenileDetentionWithOnlyChild(BigInteger
						.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23C5JailPrisonOrJuvenileDetentionUnknownHouseHold(BigInteger
						.valueOf(0));

		q23ExitDestinationMoreThan90DaysTable
				.setQ23C6LongTermCareFacilityOrNursingHomeTotal(BigInteger
						.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23C6LongTermCareFacilityOrNursingHomeWithoutChild(BigInteger
						.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23C6LongTermCareFacilityOrNursingHomeWithChildAndAdults(BigInteger
						.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23C6LongTermCareFacilityOrNursingHomeWithOnlyChild(BigInteger
						.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23C6LongTermCareFacilityOrNursingHomeUnknownHouseHold(BigInteger
						.valueOf(0));

		q23ExitDestinationMoreThan90DaysTable.setQ23CzTotTotal(BigInteger
				.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23CzTotWithoutChild(BigInteger.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23CzTotWithChildAndAdults(BigInteger.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23CzTotWithOnlyChild(BigInteger.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23CzTotUnknownHouseHold(BigInteger.valueOf(0));

		q23ExitDestinationMoreThan90DaysTable
				.setQ23DOtherDestinationsTotal(BigInteger.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23DOtherDestinationsWithoutChild(BigInteger.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23DOtherDestinationsWithChildAndAdults(BigInteger
						.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23DOtherDestinationsWithOnlyChild(BigInteger.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23DOtherDestinationsUnknownHouseHold(BigInteger.valueOf(0));

		q23ExitDestinationMoreThan90DaysTable
				.setQ23D1ResidentialProjectorHalfwayHouseTotal(BigInteger
						.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23D1ResidentialProjectorHalfwayHouseWithoutChild(BigInteger
						.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23D1ResidentialProjectorHalfwayHouseWithChildAndAdults(BigInteger
						.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23D1ResidentialProjectorHalfwayHouseWithOnlyChild(BigInteger
						.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23D1ResidentialProjectorHalfwayHouseUnknownHouseHold(BigInteger
						.valueOf(0));

		q23ExitDestinationMoreThan90DaysTable.setQ23D2DeceasedTotal(BigInteger
				.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23D2DeceasedWithoutChild(BigInteger.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23D2DeceasedWithChildAndAdults(BigInteger.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23D2DeceasedWithOnlyChild(BigInteger.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23D2DeceasedUnknownHouseHold(BigInteger.valueOf(0));

		q23ExitDestinationMoreThan90DaysTable.setQ23D3OtherTotal(BigInteger
				.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23D3OtherWithoutChild(BigInteger.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23D3OtherWithChildAndAdults(BigInteger.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23D3OtherWithOnlyChild(BigInteger.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23D3OtherUnknownHouseHold(BigInteger.valueOf(0));

		q23ExitDestinationMoreThan90DaysTable.setQ23D4DKRTotal(BigInteger
				.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23D4DKRWithoutChild(BigInteger.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23D4DKRWithChildAndAdults(BigInteger.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23D4DKRWithOnlyChild(BigInteger.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23D4DKRUnknownHouseHold(BigInteger.valueOf(0));

		q23ExitDestinationMoreThan90DaysTable
				.setQ23D5InfoMissingTotal(BigInteger.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23D5InfoMissingWithoutChild(BigInteger.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23D5InfoMissingWithChildAndAdults(BigInteger.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23D5InfoMissingWithOnlyChild(BigInteger.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23D5InfoMissingUnknownHouseHold(BigInteger.valueOf(0));

		q23ExitDestinationMoreThan90DaysTable.setQ23DzTotTotal(BigInteger
				.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23DzTotWithoutChild(BigInteger.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23DzTotWithChildAndAdults(BigInteger.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23DzTotWithOnlyChild(BigInteger.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23DzTotUnknownHouseHold(BigInteger.valueOf(0));

		q23ExitDestinationMoreThan90DaysTable.setQ23ETotTotal(BigInteger
				.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable.setQ23ETotWithoutChild(BigInteger
				.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23ETotWithChildAndAdults(BigInteger.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23ETotWithOnlyChild(BigInteger.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23ETotUnknownHouseHold(BigInteger.valueOf(0));

		q23ExitDestinationMoreThan90DaysTable
				.setQ23TotPersonsExistTotal(BigInteger.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23TotPersonsExistWithoutChild(BigInteger.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23TotPersonsExistWithChildAndAdults(BigInteger.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23TotPersonsExistWithOnlyChild(BigInteger.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23TotPersonsExistUnknownHouseHold(BigInteger.valueOf(0));

		q23ExitDestinationMoreThan90DaysTable
				.setQ23TotPersonsDstnsWithoutChild(BigInteger.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23TotPersonsDstnsTotal(BigInteger.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23TotPersonsDstnsUnknownHouseHold(BigInteger.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23TotPersonsDstnsWithOnlyChild(BigInteger.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23TotPersonsDstnsWithChildAndAdults(BigInteger.valueOf(0));

		q23ExitDestinationMoreThan90DaysTable
				.setQ23PercentageWithChildAndAdults(BigInteger.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23PercentageUnknownHouseHold(BigInteger.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23PercentageWithOnlyChild(BigInteger.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable
				.setQ23PercentageWithoutChild(BigInteger.valueOf(0));
		q23ExitDestinationMoreThan90DaysTable.setQ23PercentageTotal(BigInteger
				.valueOf(0));

		return q23ExitDestinationMoreThan90DaysTable;

	}

	public static DataBean getQ23BExitDestination90DaysOrLessList(
			BigInteger q23BAPermanentDestinationsTotal,
			BigInteger q23BAPermanentDestinationsWithoutChild,
			BigInteger q23BAPermanentDestinationsWithChildAndAdults,
			BigInteger q23BAPermanentDestinationsWithOnlyChild,
			BigInteger q23BAPermanentDestinationsUnknownHouseHold,

			BigInteger q23BA01MovedFromOneHOPWATotal,
			BigInteger q23BA01MovedFromOneHOPWAWithoutChild,
			BigInteger q23BA01MovedFromOneHOPWAWithChildAndAdults,
			BigInteger q23BA01MovedFromOneHOPWAWithOnlyChild,
			BigInteger q23BA01MovedFromOneHOPWAUnknownHouseHold,

			BigInteger q23BA02OwnedByClientNoOngoingSubsidyTotal,
			BigInteger q23BA02OwnedByClientNoOngoingSubsidyWithoutChild,
			BigInteger q23BA02OwnedByClientNoOngoingSubsidyWithChildAndAdults,
			BigInteger q23BA02OwnedByClientNoOngoingSubsidyWithOnlyChild,
			BigInteger q23BA02OwnedByClientNoOngoingSubsidyUnknownHouseHold,

			BigInteger q23BA03OwnedByClientWithOngoingSubsidyTotal,
			BigInteger q23BA03OwnedByClientWithOngoingSubsidyWithoutChild,
			BigInteger q23BA03OwnedByClientWithOngoingSubsidyWithChildAndAdults,
			BigInteger q23BA03OwnedByClientWithOngoingSubsidyWithOnlyChild,
			BigInteger q23BA03OwnedByClientWithOngoingSubsidyUnknownHouseHold,

			BigInteger q23BA04RentalByClientNoOngoingSubsidyTotal,
			BigInteger q23BA04RentalByClientNoOngoingSubsidyWithoutChild,
			BigInteger q23BA04RentalByClientNoOngoingSubsidyWithChildAndAdults,
			BigInteger q23BA04RentalByClientNoOngoingSubsidyWithOnlyChild,
			BigInteger q23BA04RentalByClientNoOngoingSubsidyUnknownHouseHold,

			BigInteger q23BA05RentalByClientVASHSubsidyTotal,
			BigInteger q23BA05RentalByClientVASHSubsidyWithoutChild,
			BigInteger q23BA05RentalByClientVASHSubsidyWithChildAndAdults,
			BigInteger q23BA05RentalByClientVASHSubsidyWithOnlyChild,
			BigInteger q23BA05RentalByClientVASHSubsidyUnknownHouseHold,

			BigInteger q23BA06RentalByClientwithGPDTIPHousingTotal,
			BigInteger q23BA06RentalByClientwithGPDTIPHousingWithoutChild,
			BigInteger q23BA06RentalByClientwithGPDTIPHousingWithChildAndAdults,
			BigInteger q23BA06RentalByClientwithGPDTIPHousingWithOnlyChild,
			BigInteger q23BA06RentalByClientwithGPDTIPHousingUnknownHouseHold,

			BigInteger q23BA07RentalByClientOtherOngoingSubsidyTotal,
			BigInteger q23BA07RentalByClientOtherOngoingSubsidyWithoutChild,
			BigInteger q23BA07RentalByClientOtherOngoingSubsidyWithChildAndAdults,
			BigInteger q23BA07RentalByClientOtherOngoingSubsidyWithOnlyChild,
			BigInteger q23BA07RentalByClientOtherOngoingSubsidyUnknownHouseHold,

			BigInteger q23BA08PermanentHousingForHomelessTotal,
			BigInteger q23BA08PermanentHousingForHomelessWithoutChild,
			BigInteger q23BA08PermanentHousingForHomelessWithChildAndAdults,
			BigInteger q23BA08PermanentHousingForHomelessWithOnlyChild,
			BigInteger q23BA08PermanentHousingForHomelessUnknownHouseHold,

			BigInteger q23BA09StayingOrLivingWithFamilyPermanentTotal,
			BigInteger q23BA09StayingOrLivingWithFamilyPermanentWithoutChild,
			BigInteger q23BA09StayingOrLivingWithFamilyPermanentWithChildAndAdults,
			BigInteger q23BA09StayingOrLivingWithFamilyPermanentWithOnlyChild,
			BigInteger q23BA09StayingOrLivingWithFamilyPermanentUnknownHouseHold,

			BigInteger q23BA10StayingOrLivingWithFriendsPermanentTotal,
			BigInteger q23BA10StayingOrLivingWithFriendsPermanentWithoutChild,
			BigInteger q23BA10StayingOrLivingWithFriendsPermanentWithChildAndAdults,
			BigInteger q23BA10StayingOrLivingWithFriendsPermanentWithOnlyChild,
			BigInteger q23BA10StayingOrLivingWithFriendsPermanentUnknownHouseHold,

			BigInteger q23BAzTotTotal,
			BigInteger q23BAzTotWithoutChild,
			BigInteger q23BAzTotWithChildAndAdults,
			BigInteger q23BAzTotWithOnlyChild,
			BigInteger q23BAzTotUnknownHouseHold,

			BigInteger q23BBTemporaryDestinationsTotal,
			BigInteger q23BBTemporaryDestinationsWithoutChild,
			BigInteger q23BBTemporaryDestinationsWithChildAndAdults,
			BigInteger q23BBTemporaryDestinationsWithOnlyChild,
			BigInteger q23BBTemporaryDestinationsUnknownHouseHold,

			BigInteger q23BB1EmergencyShelterTotal,
			BigInteger q23BB1EmergencyShelterWithoutChild,
			BigInteger q23BB1EmergencyShelterWithChildAndAdults,
			BigInteger q23BB1EmergencyShelterWithOnlyChild,
			BigInteger q23BB1EmergencyShelterUnknownHouseHold,

			BigInteger q23BB2MovedFromOneHOPWATotal,
			BigInteger q23BB2MovedFromOneHOPWAWithoutChild,
			BigInteger q23BB2MovedFromOneHOPWAWithChildAndAdults,
			BigInteger q23BB2MovedFromOneHOPWAWithOnlyChild,
			BigInteger q23BB2MovedFromOneHOPWAUnknownHouseHold,

			BigInteger q23BB3TransitionalHousingForHomeLessTotal,
			BigInteger q23BB3TransitionalHousingForHomeLessWithoutChild,
			BigInteger q23BB3TransitionalHousingForHomeLessWithChildAndAdults,
			BigInteger q23BB3TransitionalHousingForHomeLessWithOnlyChild,
			BigInteger q23BB3TransitionalHousingForHomeLessUnknownHouseHold,

			BigInteger q23BB4StayingWithFamilyTemporaryTenureTotal,
			BigInteger q23BB4StayingWithFamilyTemporaryTenureWithoutChild,
			BigInteger q23BB4StayingWithFamilyTemporaryTenureWithChildAndAdults,
			BigInteger q23BB4StayingWithFamilyTemporaryTenureWithOnlyChild,
			BigInteger q23BB4StayingWithFamilyTemporaryTenureUnknownHouseHold,

			BigInteger q23BB5StayingWithFriendsTemporaryTenureTotal,
			BigInteger q23BB5StayingWithFriendsTemporaryTenureWithoutChild,
			BigInteger q23BB5StayingWithFriendsTemporaryTenureWithChildAndAdults,
			BigInteger q23BB5StayingWithFriendsTemporaryTenureWithOnlyChild,
			BigInteger q23BB5StayingWithFriendsTemporaryTenureUnknownHouseHold,

			BigInteger q23BB6PlaceNotMeantForHumanHabitationTotal,
			BigInteger q23BB6PlaceNotMeantForHumanHabitationWithoutChild,
			BigInteger q23BB6PlaceNotMeantForHumanHabitationWithChildAndAdults,
			BigInteger q23BB6PlaceNotMeantForHumanHabitationWithOnlyChild,
			BigInteger q23BB6PlaceNotMeantForHumanHabitationUnknownHouseHold,

			BigInteger q23BB7SafeHavenTotal,
			BigInteger q23BB7SafeHavenWithoutChild,
			BigInteger q23BB7SafeHavenWithChildAndAdults,
			BigInteger q23BB7SafeHavenWithOnlyChild,
			BigInteger q23BB7SafeHavenUnknownHouseHold,

			BigInteger q23BB8HotelOrMotelPaidByClientTotal,
			BigInteger q23BB8HotelOrMotelPaidByClientWithoutChild,
			BigInteger q23BB8HotelOrMotelPaidByClientWithChildAndAdults,
			BigInteger q23BB8HotelOrMotelPaidByClientWithOnlyChild,
			BigInteger q23BB8HotelOrMotelPaidByClientUnknownHouseHold,

			BigInteger q23BBzTotTotal,
			BigInteger q23BBzTotWithoutChild,
			BigInteger q23BBzTotWithChildAndAdults,
			BigInteger q23BBzTotWithOnlyChild,
			BigInteger q23BBzTotUnknownHouseHold,

			BigInteger q23BCInstitutionalSettingsTotal,
			BigInteger q23BCInstitutionalSettingsWithoutChild,
			BigInteger q23BCInstitutionalSettingsWithChildAndAdults,
			BigInteger q23BCInstitutionalSettingsWithOnlyChild,
			BigInteger q23BCInstitutionalSettingsUnknownHouseHold,

			BigInteger q23BC1FosterCareHomeOrGroupFosterCareTotal,
			BigInteger q23BC1FosterCareHomeOrGroupFosterCareWithoutChild,
			BigInteger q23BC1FosterCareHomeOrGroupFosterCareWithChildAndAdults,
			BigInteger q23BC1FosterCareHomeOrGroupFosterCareWithOnlyChild,
			BigInteger q23BC1FosterCareHomeOrGroupFosterCareUnknownHouseHold,

			BigInteger q23BC2PsychiatricHospitalOrOtherTotal,
			BigInteger q23BC2PsychiatricHospitalOrOtherWithoutChild,
			BigInteger q23BC2PsychiatricHospitalOrOtherWithChildAndAdults,
			BigInteger q23BC2PsychiatricHospitalOrOtherWithOnlyChild,
			BigInteger q23BC2PsychiatricHospitalOrOtherUnknownHouseHold,

			BigInteger q23BC3SubstanceAbuseTreatmentFacilityTotal,
			BigInteger q23BC3SubstanceAbuseTreatmentFacilityWithoutChild,
			BigInteger q23BC3SubstanceAbuseTreatmentFacilityWithChildAndAdults,
			BigInteger q23BC3SubstanceAbuseTreatmentFacilityWithOnlyChild,
			BigInteger q23BC3SubstanceAbuseTreatmentFacilityUnknownHouseHold,

			BigInteger q23BC4HospitalOrOtherTotal,
			BigInteger q23BC4HospitalOrOtherWithoutChild,
			BigInteger q23BC4HospitalOrOtherWithChildAndAdults,
			BigInteger q23BC4HospitalOrOtherWithOnlyChild,
			BigInteger q23BC4HospitalOrOtherUnknownHouseHold,

			BigInteger q23BC5JailPrisonOrJuvenileDetentionTotal,
			BigInteger q23BC5JailPrisonOrJuvenileDetentionWithoutChild,
			BigInteger q23BC5JailPrisonOrJuvenileDetentionWithChildAndAdults,
			BigInteger q23BC5JailPrisonOrJuvenileDetentionWithOnlyChild,
			BigInteger q23BC5JailPrisonOrJuvenileDetentionUnknownHouseHold,

			BigInteger q23BC6LongTermCareFacilityOrNursingHomeTotal,
			BigInteger q23BC6LongTermCareFacilityOrNursingHomeWithoutChild,
			BigInteger q23BC6LongTermCareFacilityOrNursingHomeWithChildAndAdults,
			BigInteger q23BC6LongTermCareFacilityOrNursingHomeWithOnlyChild,
			BigInteger q23BC6LongTermCareFacilityOrNursingHomeUnknownHouseHold,

			BigInteger q23BCzTotTotal,
			BigInteger q23BCzTotWithoutChild,
			BigInteger q23BCzTotWithChildAndAdults,
			BigInteger q23BCzTotWithOnlyChild,
			BigInteger q23BCzTotUnknownHouseHold,

			BigInteger q23BDOtherDestinationsTotal,
			BigInteger q23BDOtherDestinationsWithoutChild,
			BigInteger q23BDOtherDestinationsWithChildAndAdults,
			BigInteger q23BDOtherDestinationsWithOnlyChild,
			BigInteger q23BDOtherDestinationsUnknownHouseHold,

			BigInteger q23BD1ResidentialProjectorHalfwayHouseTotal,
			BigInteger q23BD1ResidentialProjectorHalfwayHouseWithoutChild,
			BigInteger q23BD1ResidentialProjectorHalfwayHouseWithChildAndAdults,
			BigInteger q23BD1ResidentialProjectorHalfwayHouseWithOnlyChild,
			BigInteger q23BD1ResidentialProjectorHalfwayHouseUnknownHouseHold,

			BigInteger q23BD2DeceasedTotal,
			BigInteger q23BD2DeceasedWithoutChild,
			BigInteger q23BD2DeceasedWithChildAndAdults,
			BigInteger q23BD2DeceasedWithOnlyChild,
			BigInteger q23BD2DeceasedUnknownHouseHold,

			BigInteger q23BD3OtherTotal, BigInteger q23BD3OtherWithoutChild,
			BigInteger q23BD3OtherWithChildAndAdults,
			BigInteger q23BD3OtherWithOnlyChild,
			BigInteger q23BD3OtherUnknownHouseHold,

			BigInteger q23BD4DKRTotal, BigInteger q23BD4DKRWithoutChild,
			BigInteger q23BD4DKRWithChildAndAdults,
			BigInteger q23BD4DKRWithOnlyChild,
			BigInteger q23BD4DKRUnknownHouseHold,

			BigInteger q23BD5InfoMissingTotal,
			BigInteger q23BD5InfoMissingWithoutChild,
			BigInteger q23BD5InfoMissingWithChildAndAdults,
			BigInteger q23BD5InfoMissingWithOnlyChild,
			BigInteger q23BD5InfoMissingUnknownHouseHold,

			BigInteger q23BDzTotTotal, BigInteger q23BDzTotWithoutChild,
			BigInteger q23BDzTotWithChildAndAdults,
			BigInteger q23BDzTotWithOnlyChild,
			BigInteger q23BDzTotUnknownHouseHold,

			BigInteger q23BETotTotal, BigInteger q23BETotWithoutChild,
			BigInteger q23BETotWithChildAndAdults,
			BigInteger q23BETotWithOnlyChild,
			BigInteger q23BETotUnknownHouseHold,

			BigInteger q23BPercentageWithChildAndAdults,
			BigInteger q23BPercentageUnknownHouseHold,
			BigInteger q23BPercentageWithOnlyChild,
			BigInteger q23BPercentageWithoutChild,
			BigInteger q23BPercentageTotal,

			BigInteger q23BTotPersonsDstnsWithoutChild,
			BigInteger q23BTotPersonsDstnsTotal,
			BigInteger q23BTotPersonsDstnsUnknownHouseHold,
			BigInteger q23BTotPersonsDstnsWithOnlyChild,
			BigInteger q23BTotPersonsDstnsWithChildAndAdults,

			BigInteger q23BTotPersonsExistTotal,
			BigInteger q23BTotPersonsExistWithoutChild,
			BigInteger q23BTotPersonsExistWithChildAndAdults,
			BigInteger q23BTotPersonsExistWithOnlyChild,
			BigInteger q23BTotPersonsExistUnknownHouseHold,
			DataBean q23BExitDestination90DaysOrLessTable) {

		q23BExitDestination90DaysOrLessTable
				.setQ23BAPermanentDestinationsTotal(BigInteger.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BAPermanentDestinationsWithoutChild(BigInteger
						.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BAPermanentDestinationsWithChildAndAdults(BigInteger
						.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BAPermanentDestinationsWithOnlyChild(BigInteger
						.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BAPermanentDestinationsUnknownHouseHold(BigInteger
						.valueOf(0));

		q23BExitDestination90DaysOrLessTable
				.setQ23BA01MovedFromOneHOPWATotal(BigInteger.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BA01MovedFromOneHOPWAWithoutChild(BigInteger.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BA01MovedFromOneHOPWAWithChildAndAdults(BigInteger
						.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BA01MovedFromOneHOPWAWithOnlyChild(BigInteger.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BA01MovedFromOneHOPWAUnknownHouseHold(BigInteger
						.valueOf(0));

		q23BExitDestination90DaysOrLessTable
				.setQ23BA02OwnedByClientNoOngoingSubsidyTotal(BigInteger
						.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BA02OwnedByClientNoOngoingSubsidyWithoutChild(BigInteger
						.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BA02OwnedByClientNoOngoingSubsidyWithChildAndAdults(BigInteger
						.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BA02OwnedByClientNoOngoingSubsidyWithOnlyChild(BigInteger
						.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BA02OwnedByClientNoOngoingSubsidyUnknownHouseHold(BigInteger
						.valueOf(0));

		q23BExitDestination90DaysOrLessTable
				.setQ23BA03OwnedByClientWithOngoingSubsidyTotal(BigInteger
						.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BA03OwnedByClientWithOngoingSubsidyWithoutChild(BigInteger
						.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BA03OwnedByClientWithOngoingSubsidyWithChildAndAdults(BigInteger
						.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BA03OwnedByClientWithOngoingSubsidyWithOnlyChild(BigInteger
						.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BA03OwnedByClientWithOngoingSubsidyUnknownHouseHold(BigInteger
						.valueOf(0));

		q23BExitDestination90DaysOrLessTable
				.setQ23BA04RentalByClientNoOngoingSubsidyTotal(BigInteger
						.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BA04RentalByClientNoOngoingSubsidyWithoutChild(BigInteger
						.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BA04RentalByClientNoOngoingSubsidyWithChildAndAdults(BigInteger
						.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BA04RentalByClientNoOngoingSubsidyWithOnlyChild(BigInteger
						.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BA04RentalByClientNoOngoingSubsidyUnknownHouseHold(BigInteger
						.valueOf(0));

		q23BExitDestination90DaysOrLessTable
				.setQ23BA05RentalByClientVASHSubsidyTotal(BigInteger.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BA05RentalByClientVASHSubsidyWithoutChild(BigInteger
						.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BA05RentalByClientVASHSubsidyWithChildAndAdults(BigInteger
						.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BA05RentalByClientVASHSubsidyWithOnlyChild(BigInteger
						.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BA05RentalByClientVASHSubsidyUnknownHouseHold(BigInteger
						.valueOf(0));

		q23BExitDestination90DaysOrLessTable
				.setQ23BA06RentalByClientwithGPDTIPHousingTotal(BigInteger
						.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BA06RentalByClientwithGPDTIPHousingWithoutChild(BigInteger
						.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BA06RentalByClientwithGPDTIPHousingWithChildAndAdults(BigInteger
						.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BA06RentalByClientwithGPDTIPHousingWithOnlyChild(BigInteger
						.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BA06RentalByClientwithGPDTIPHousingUnknownHouseHold(BigInteger
						.valueOf(0));

		q23BExitDestination90DaysOrLessTable
				.setQ23BA07RentalByClientOtherOngoingSubsidyTotal(BigInteger
						.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BA07RentalByClientOtherOngoingSubsidyWithoutChild(BigInteger
						.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BA07RentalByClientOtherOngoingSubsidyWithChildAndAdults(BigInteger
						.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BA07RentalByClientOtherOngoingSubsidyWithOnlyChild(BigInteger
						.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BA07RentalByClientOtherOngoingSubsidyUnknownHouseHold(BigInteger
						.valueOf(0));

		q23BExitDestination90DaysOrLessTable
				.setQ23BA08PermanentHousingForHomelessTotal(BigInteger
						.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BA08PermanentHousingForHomelessWithoutChild(BigInteger
						.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BA08PermanentHousingForHomelessWithChildAndAdults(BigInteger
						.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BA08PermanentHousingForHomelessWithOnlyChild(BigInteger
						.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BA08PermanentHousingForHomelessUnknownHouseHold(BigInteger
						.valueOf(0));

		q23BExitDestination90DaysOrLessTable
				.setQ23BA09StayingOrLivingWithFamilyPermanentTotal(BigInteger
						.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BA09StayingOrLivingWithFamilyPermanentWithoutChild(BigInteger
						.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BA09StayingOrLivingWithFamilyPermanentWithChildAndAdults(BigInteger
						.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BA09StayingOrLivingWithFamilyPermanentWithOnlyChild(BigInteger
						.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BA09StayingOrLivingWithFamilyPermanentUnknownHouseHold(BigInteger
						.valueOf(0));

		q23BExitDestination90DaysOrLessTable
				.setQ23BA10StayingOrLivingWithFriendsPermanentTotal(BigInteger
						.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BA10StayingOrLivingWithFriendsPermanentWithoutChild(BigInteger
						.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BA10StayingOrLivingWithFriendsPermanentWithChildAndAdults(BigInteger
						.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BA10StayingOrLivingWithFriendsPermanentWithOnlyChild(BigInteger
						.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BA10StayingOrLivingWithFriendsPermanentUnknownHouseHold(BigInteger
						.valueOf(0));

		q23BExitDestination90DaysOrLessTable.setQ23BAzTotTotal(BigInteger
				.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BAzTotWithoutChild(BigInteger.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BAzTotWithChildAndAdults(BigInteger.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BAzTotWithOnlyChild(BigInteger.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BAzTotUnknownHouseHold(BigInteger.valueOf(0));

		q23BExitDestination90DaysOrLessTable
				.setQ23BBTemporaryDestinationsTotal(BigInteger.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BBTemporaryDestinationsWithoutChild(BigInteger
						.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BBTemporaryDestinationsWithChildAndAdults(BigInteger
						.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BBTemporaryDestinationsWithOnlyChild(BigInteger
						.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BBTemporaryDestinationsUnknownHouseHold(BigInteger
						.valueOf(0));

		q23BExitDestination90DaysOrLessTable
				.setQ23BB1EmergencyShelterTotal(BigInteger.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BB1EmergencyShelterWithoutChild(BigInteger.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BB1EmergencyShelterWithChildAndAdults(BigInteger
						.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BB1EmergencyShelterWithOnlyChild(BigInteger.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BB1EmergencyShelterUnknownHouseHold(BigInteger
						.valueOf(0));

		q23BExitDestination90DaysOrLessTable
				.setQ23BB2MovedFromOneHOPWATotal(BigInteger.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BB2MovedFromOneHOPWAWithoutChild(BigInteger.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BB2MovedFromOneHOPWAWithChildAndAdults(BigInteger
						.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BB2MovedFromOneHOPWAWithOnlyChild(BigInteger.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BB2MovedFromOneHOPWAUnknownHouseHold(BigInteger
						.valueOf(0));

		q23BExitDestination90DaysOrLessTable
				.setQ23BB3TransitionalHousingForHomeLessTotal(BigInteger
						.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BB3TransitionalHousingForHomeLessWithoutChild(BigInteger
						.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BB3TransitionalHousingForHomeLessWithChildAndAdults(BigInteger
						.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BB3TransitionalHousingForHomeLessWithOnlyChild(BigInteger
						.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BB3TransitionalHousingForHomeLessUnknownHouseHold(BigInteger
						.valueOf(0));

		q23BExitDestination90DaysOrLessTable
				.setQ23BB4StayingWithFamilyTemporaryTenureTotal(BigInteger
						.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BB4StayingWithFamilyTemporaryTenureWithoutChild(BigInteger
						.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BB4StayingWithFamilyTemporaryTenureWithChildAndAdults(BigInteger
						.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BB4StayingWithFamilyTemporaryTenureWithOnlyChild(BigInteger
						.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BB4StayingWithFamilyTemporaryTenureUnknownHouseHold(BigInteger
						.valueOf(0));

		q23BExitDestination90DaysOrLessTable
				.setQ23BB5StayingWithFriendsTemporaryTenureTotal(BigInteger
						.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BB5StayingWithFriendsTemporaryTenureWithoutChild(BigInteger
						.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BB5StayingWithFriendsTemporaryTenureWithChildAndAdults(BigInteger
						.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BB5StayingWithFriendsTemporaryTenureWithOnlyChild(BigInteger
						.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BB5StayingWithFriendsTemporaryTenureUnknownHouseHold(BigInteger
						.valueOf(0));

		q23BExitDestination90DaysOrLessTable
				.setQ23BB6PlaceNotMeantForHumanHabitationTotal(BigInteger
						.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BB6PlaceNotMeantForHumanHabitationWithoutChild(BigInteger
						.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BB6PlaceNotMeantForHumanHabitationWithChildAndAdults(BigInteger
						.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BB6PlaceNotMeantForHumanHabitationWithOnlyChild(BigInteger
						.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BB6PlaceNotMeantForHumanHabitationUnknownHouseHold(BigInteger
						.valueOf(0));

		q23BExitDestination90DaysOrLessTable.setQ23BB7SafeHavenTotal(BigInteger
				.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BB7SafeHavenWithoutChild(BigInteger.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BB7SafeHavenWithChildAndAdults(BigInteger.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BB7SafeHavenWithOnlyChild(BigInteger.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BB7SafeHavenUnknownHouseHold(BigInteger.valueOf(0));

		q23BExitDestination90DaysOrLessTable
				.setQ23BB8HotelOrMotelPaidByClientTotal(BigInteger.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BB8HotelOrMotelPaidByClientWithoutChild(BigInteger
						.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BB8HotelOrMotelPaidByClientWithChildAndAdults(BigInteger
						.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BB8HotelOrMotelPaidByClientWithOnlyChild(BigInteger
						.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BB8HotelOrMotelPaidByClientUnknownHouseHold(BigInteger
						.valueOf(0));

		q23BExitDestination90DaysOrLessTable.setQ23BBzTotTotal(BigInteger
				.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BBzTotWithoutChild(BigInteger.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BBzTotWithChildAndAdults(BigInteger.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BBzTotWithOnlyChild(BigInteger.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BBzTotUnknownHouseHold(BigInteger.valueOf(0));

		q23BExitDestination90DaysOrLessTable
				.setQ23BCInstitutionalSettingsTotal(BigInteger.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BCInstitutionalSettingsWithoutChild(BigInteger
						.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BCInstitutionalSettingsWithChildAndAdults(BigInteger
						.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BCInstitutionalSettingsWithOnlyChild(BigInteger
						.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BCInstitutionalSettingsUnknownHouseHold(BigInteger
						.valueOf(0));

		q23BExitDestination90DaysOrLessTable
				.setQ23BC1FosterCareHomeOrGroupFosterCareTotal(BigInteger
						.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BC1FosterCareHomeOrGroupFosterCareWithoutChild(BigInteger
						.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BC1FosterCareHomeOrGroupFosterCareWithChildAndAdults(BigInteger
						.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BC1FosterCareHomeOrGroupFosterCareWithOnlyChild(BigInteger
						.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BC1FosterCareHomeOrGroupFosterCareUnknownHouseHold(BigInteger
						.valueOf(0));

		q23BExitDestination90DaysOrLessTable
				.setQ23BC2PsychiatricHospitalOrOtherTotal(BigInteger.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BC2PsychiatricHospitalOrOtherWithoutChild(BigInteger
						.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BC2PsychiatricHospitalOrOtherWithChildAndAdults(BigInteger
						.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BC2PsychiatricHospitalOrOtherWithOnlyChild(BigInteger
						.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BC2PsychiatricHospitalOrOtherUnknownHouseHold(BigInteger
						.valueOf(0));

		q23BExitDestination90DaysOrLessTable
				.setQ23BC3SubstanceAbuseTreatmentFacilityTotal(BigInteger
						.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BC3SubstanceAbuseTreatmentFacilityWithoutChild(BigInteger
						.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BC3SubstanceAbuseTreatmentFacilityWithChildAndAdults(BigInteger
						.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BC3SubstanceAbuseTreatmentFacilityWithOnlyChild(BigInteger
						.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BC3SubstanceAbuseTreatmentFacilityUnknownHouseHold(BigInteger
						.valueOf(0));

		q23BExitDestination90DaysOrLessTable
				.setQ23BC4HospitalOrOtherTotal(BigInteger.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BC4HospitalOrOtherWithoutChild(BigInteger.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BC4HospitalOrOtherWithChildAndAdults(BigInteger
						.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BC4HospitalOrOtherWithOnlyChild(BigInteger.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BC4HospitalOrOtherUnknownHouseHold(BigInteger.valueOf(0));

		q23BExitDestination90DaysOrLessTable
				.setQ23BC5JailPrisonOrJuvenileDetentionTotal(BigInteger
						.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BC5JailPrisonOrJuvenileDetentionWithoutChild(BigInteger
						.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BC5JailPrisonOrJuvenileDetentionWithChildAndAdults(BigInteger
						.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BC5JailPrisonOrJuvenileDetentionWithOnlyChild(BigInteger
						.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BC5JailPrisonOrJuvenileDetentionUnknownHouseHold(BigInteger
						.valueOf(0));

		q23BExitDestination90DaysOrLessTable
				.setQ23BC6LongTermCareFacilityOrNursingHomeTotal(BigInteger
						.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BC6LongTermCareFacilityOrNursingHomeWithoutChild(BigInteger
						.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BC6LongTermCareFacilityOrNursingHomeWithChildAndAdults(BigInteger
						.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BC6LongTermCareFacilityOrNursingHomeWithOnlyChild(BigInteger
						.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BC6LongTermCareFacilityOrNursingHomeUnknownHouseHold(BigInteger
						.valueOf(0));

		q23BExitDestination90DaysOrLessTable.setQ23BCzTotTotal(BigInteger
				.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BCzTotWithoutChild(BigInteger.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BCzTotWithChildAndAdults(BigInteger.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BCzTotWithOnlyChild(BigInteger.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BCzTotUnknownHouseHold(BigInteger.valueOf(0));

		q23BExitDestination90DaysOrLessTable
				.setQ23BDOtherDestinationsTotal(BigInteger.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BDOtherDestinationsWithoutChild(BigInteger.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BDOtherDestinationsWithChildAndAdults(BigInteger
						.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BDOtherDestinationsWithOnlyChild(BigInteger.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BDOtherDestinationsUnknownHouseHold(BigInteger
						.valueOf(0));

		q23BExitDestination90DaysOrLessTable
				.setQ23BD1ResidentialProjectorHalfwayHouseTotal(BigInteger
						.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BD1ResidentialProjectorHalfwayHouseWithoutChild(BigInteger
						.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BD1ResidentialProjectorHalfwayHouseWithChildAndAdults(BigInteger
						.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BD1ResidentialProjectorHalfwayHouseWithOnlyChild(BigInteger
						.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BD1ResidentialProjectorHalfwayHouseUnknownHouseHold(BigInteger
						.valueOf(0));

		q23BExitDestination90DaysOrLessTable.setQ23BD2DeceasedTotal(BigInteger
				.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BD2DeceasedWithoutChild(BigInteger.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BD2DeceasedWithChildAndAdults(BigInteger.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BD2DeceasedWithOnlyChild(BigInteger.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BD2DeceasedUnknownHouseHold(BigInteger.valueOf(0));

		q23BExitDestination90DaysOrLessTable.setQ23BD3OtherTotal(BigInteger
				.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BD3OtherWithoutChild(BigInteger.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BD3OtherWithChildAndAdults(BigInteger.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BD3OtherWithOnlyChild(BigInteger.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BD3OtherUnknownHouseHold(BigInteger.valueOf(0));

		q23BExitDestination90DaysOrLessTable.setQ23BD4DKRTotal(BigInteger
				.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BD4DKRWithoutChild(BigInteger.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BD4DKRWithChildAndAdults(BigInteger.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BD4DKRWithOnlyChild(BigInteger.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BD4DKRUnknownHouseHold(BigInteger.valueOf(0));

		q23BExitDestination90DaysOrLessTable
				.setQ23BD5InfoMissingTotal(BigInteger.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BD5InfoMissingWithoutChild(BigInteger.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BD5InfoMissingWithChildAndAdults(BigInteger.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BD5InfoMissingWithOnlyChild(BigInteger.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BD5InfoMissingUnknownHouseHold(BigInteger.valueOf(0));

		q23BExitDestination90DaysOrLessTable.setQ23BDzTotTotal(BigInteger
				.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BDzTotWithoutChild(BigInteger.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BDzTotWithChildAndAdults(BigInteger.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BDzTotWithOnlyChild(BigInteger.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BDzTotUnknownHouseHold(BigInteger.valueOf(0));

		q23BExitDestination90DaysOrLessTable.setQ23BETotTotal(BigInteger
				.valueOf(0));
		q23BExitDestination90DaysOrLessTable.setQ23BETotWithoutChild(BigInteger
				.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BETotWithChildAndAdults(BigInteger.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BETotWithOnlyChild(BigInteger.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BETotUnknownHouseHold(BigInteger.valueOf(0));

		q23BExitDestination90DaysOrLessTable
				.setQ23BTotPersonsExistTotal(BigInteger.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BTotPersonsExistWithoutChild(BigInteger.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BTotPersonsExistWithChildAndAdults(BigInteger.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BTotPersonsExistWithOnlyChild(BigInteger.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BTotPersonsExistUnknownHouseHold(BigInteger.valueOf(0));

		q23BExitDestination90DaysOrLessTable
				.setQ23BTotPersonsDstnsWithoutChild(BigInteger.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BTotPersonsDstnsTotal(BigInteger.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BTotPersonsDstnsUnknownHouseHold(BigInteger.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BTotPersonsDstnsWithOnlyChild(BigInteger.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BTotPersonsDstnsWithChildAndAdults(BigInteger.valueOf(0));

		q23BExitDestination90DaysOrLessTable
				.setQ23BPercentageWithChildAndAdults(BigInteger.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BPercentageUnknownHouseHold(BigInteger.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BPercentageWithOnlyChild(BigInteger.valueOf(0));
		q23BExitDestination90DaysOrLessTable
				.setQ23BPercentageWithoutChild(BigInteger.valueOf(0));
		q23BExitDestination90DaysOrLessTable.setQ23BPercentageTotal(BigInteger
				.valueOf(0));

		return q23BExitDestination90DaysOrLessTable;
	}

	public static DataBean getQ25aNumberOfVeteransList(

	BigInteger q25aChronicallyHomelessVeteranTotal,
			BigInteger q25aChronicallyHomelessVeteranWithoutChildren,
			BigInteger q25aChronicallyHomelessVeteranWithChildAndAdults,
			BigInteger q25aChronicallyHomelessVeteranUnknownHouseHold,

			BigInteger q25aNonChronicallyHomelessVeteranTotal,
			BigInteger q25aNonChronicallyHomelessVeteranWithoutChildren,
			BigInteger q25aNonChronicallyHomelessVeteranWithChildAndAdults,
			BigInteger q25aNonChronicallyHomelessVeteranUnknownHouseHold,

			BigInteger q25aNotVeteranTotal,
			BigInteger q25aNotVeteranWithoutChildren,
			BigInteger q25aNotVeteranWithChildAndAdults,
			BigInteger q25aNotVeteranUnknownHouseHold,

			BigInteger q25aClientRefusedTotal,
			BigInteger q25aClientRefusedWithoutChildren,
			BigInteger q25aClientRefusedWithChildAndAdults,
			BigInteger q25aClientRefusedUnknownHouseHold,

			BigInteger q25aDataNotCollectedTotal,
			BigInteger q25aDataNotCollectedWithoutChildren,
			BigInteger q25aDataNotCollectedWithChildAndAdults,
			BigInteger q25aDataNotCollectedUnknownHouseHold,

			BigInteger q25aTotTotal, BigInteger q25aTotWithoutChildren,
			BigInteger q25aTotWithChildAndAdults,
			BigInteger q25aTotUnknownHouseHold,
			DataBean q25aNumberOfVeteransTable) {

		q25aNumberOfVeteransTable
				.setQ25aChronicallyHomelessVeteranTotal(BigInteger.valueOf(0));
		q25aNumberOfVeteransTable
				.setQ25aChronicallyHomelessVeteranWithoutChildren(BigInteger
						.valueOf(0));
		q25aNumberOfVeteransTable
				.setQ25aChronicallyHomelessVeteranWithChildAndAdults(BigInteger
						.valueOf(0));
		q25aNumberOfVeteransTable
				.setQ25aChronicallyHomelessVeteranUnknownHouseHold(BigInteger
						.valueOf(0));

		q25aNumberOfVeteransTable
				.setQ25aNonChronicallyHomelessVeteranTotal(BigInteger
						.valueOf(0));
		q25aNumberOfVeteransTable
				.setQ25aNonChronicallyHomelessVeteranWithoutChildren(BigInteger
						.valueOf(0));
		q25aNumberOfVeteransTable
				.setQ25aNonChronicallyHomelessVeteranWithChildAndAdults(BigInteger
						.valueOf(0));
		q25aNumberOfVeteransTable
				.setQ25aNonChronicallyHomelessVeteranUnknownHouseHold(BigInteger
						.valueOf(0));

		q25aNumberOfVeteransTable.setQ25aNotVeteranTotal(BigInteger.valueOf(0));
		q25aNumberOfVeteransTable.setQ25aNotVeteranWithoutChildren(BigInteger
				.valueOf(0));
		q25aNumberOfVeteransTable
				.setQ25aNotVeteranWithChildAndAdults(BigInteger.valueOf(0));
		q25aNumberOfVeteransTable.setQ25aNotVeteranUnknownHouseHold(BigInteger
				.valueOf(0));

		q25aNumberOfVeteransTable.setQ25aClientRefusedTotal(BigInteger
				.valueOf(0));
		q25aNumberOfVeteransTable
				.setQ25aClientRefusedWithoutChildren(BigInteger.valueOf(0));
		q25aNumberOfVeteransTable
				.setQ25aClientRefusedWithChildAndAdults(BigInteger.valueOf(0));
		q25aNumberOfVeteransTable
				.setQ25aClientRefusedUnknownHouseHold(BigInteger.valueOf(0));

		q25aNumberOfVeteransTable.setQ25aDataNotCollectedTotal(BigInteger
				.valueOf(0));
		q25aNumberOfVeteransTable
				.setQ25aDataNotCollectedWithoutChildren(BigInteger.valueOf(0));
		q25aNumberOfVeteransTable
				.setQ25aDataNotCollectedWithChildAndAdults(BigInteger
						.valueOf(0));
		q25aNumberOfVeteransTable
				.setQ25aDataNotCollectedUnknownHouseHold(BigInteger.valueOf(0));

		q25aNumberOfVeteransTable.setQ25aTotTotal(BigInteger.valueOf(0));
		q25aNumberOfVeteransTable.setQ25aTotWithoutChildren(BigInteger
				.valueOf(0));
		q25aNumberOfVeteransTable.setQ25aTotWithChildAndAdults(BigInteger
				.valueOf(0));
		q25aNumberOfVeteransTable.setQ25aTotUnknownHouseHold(BigInteger
				.valueOf(0));

		return q25aNumberOfVeteransTable;
	}

	public static DataBean getQ25bNumberOfVeteranHouseholdsList(
			BigInteger q25bChronicallyHomelessVeteranTotal,
			BigInteger q25bChronicallyHomelessVeteranWithoutChildren,
			BigInteger q25bChronicallyHomelessVeteranWithChildAndAdults,
			BigInteger q25bChronicallyHomelessVeteranUnknownHouseHold,

			BigInteger q25bNonChronicallyHomelessVeteranTotal,
			BigInteger q25bNonChronicallyHomelessVeteranWithoutChildren,
			BigInteger q25bNonChronicallyHomelessVeteranWithChildAndAdults,
			BigInteger q25bNonChronicallyHomelessVeteranUnknownHouseHold,

			BigInteger q25bNotVeteranTotal,
			BigInteger q25bNotVeteranWithoutChildren,
			BigInteger q25bNotVeteranWithChildAndAdults,
			BigInteger q25bNotVeteranUnknownHouseHold,

			BigInteger q25bClientRefusedTotal,
			BigInteger q25bClientRefusedWithoutChildren,
			BigInteger q25bClientRefusedWithChildAndAdults,
			BigInteger q25bClientRefusedUnknownHouseHold,

			BigInteger q25bDataNotCollectedTotal,
			BigInteger q25bDataNotCollectedWithoutChildren,
			BigInteger q25bDataNotCollectedWithChildAndAdults,
			BigInteger q25bDataNotCollectedUnknownHouseHold,

			BigInteger q25bTotTotal, BigInteger q25bTotWithoutChildren,
			BigInteger q25bTotWithChildAndAdults,
			BigInteger q25bTotUnknownHouseHold,
			DataBean q25bNumberOfVeteranHouseholdsTable) {

		q25bNumberOfVeteranHouseholdsTable
				.setQ25bChronicallyHomelessVeteranTotal(BigInteger.valueOf(0));
		q25bNumberOfVeteranHouseholdsTable
				.setQ25bChronicallyHomelessVeteranWithoutChildren(BigInteger
						.valueOf(0));
		q25bNumberOfVeteranHouseholdsTable
				.setQ25bChronicallyHomelessVeteranWithChildAndAdults(BigInteger
						.valueOf(0));
		q25bNumberOfVeteranHouseholdsTable
				.setQ25bChronicallyHomelessVeteranUnknownHouseHold(BigInteger
						.valueOf(0));

		q25bNumberOfVeteranHouseholdsTable
				.setQ25bNonChronicallyHomelessVeteranTotal(BigInteger
						.valueOf(0));
		q25bNumberOfVeteranHouseholdsTable
				.setQ25bNonChronicallyHomelessVeteranWithoutChildren(BigInteger
						.valueOf(0));
		q25bNumberOfVeteranHouseholdsTable
				.setQ25bNonChronicallyHomelessVeteranWithChildAndAdults(BigInteger
						.valueOf(0));
		q25bNumberOfVeteranHouseholdsTable
				.setQ25bNonChronicallyHomelessVeteranUnknownHouseHold(BigInteger
						.valueOf(0));

		q25bNumberOfVeteranHouseholdsTable.setQ25bNotVeteranTotal(BigInteger
				.valueOf(0));
		q25bNumberOfVeteranHouseholdsTable
				.setQ25bNotVeteranWithoutChildren(BigInteger.valueOf(0));
		q25bNumberOfVeteranHouseholdsTable
				.setQ25bNotVeteranWithChildAndAdults(BigInteger.valueOf(0));
		q25bNumberOfVeteranHouseholdsTable
				.setQ25bNotVeteranUnknownHouseHold(BigInteger.valueOf(0));

		q25bNumberOfVeteranHouseholdsTable.setQ25bClientRefusedTotal(BigInteger
				.valueOf(0));
		q25bNumberOfVeteranHouseholdsTable
				.setQ25bClientRefusedWithoutChildren(BigInteger.valueOf(0));
		q25bNumberOfVeteranHouseholdsTable
				.setQ25bClientRefusedWithChildAndAdults(BigInteger.valueOf(0));
		q25bNumberOfVeteranHouseholdsTable
				.setQ25bClientRefusedUnknownHouseHold(BigInteger.valueOf(0));

		q25bNumberOfVeteranHouseholdsTable
				.setQ25bDataNotCollectedTotal(BigInteger.valueOf(0));
		q25bNumberOfVeteranHouseholdsTable
				.setQ25bDataNotCollectedWithoutChildren(BigInteger.valueOf(0));
		q25bNumberOfVeteranHouseholdsTable
				.setQ25bDataNotCollectedWithChildAndAdults(BigInteger
						.valueOf(0));
		q25bNumberOfVeteranHouseholdsTable
				.setQ25bDataNotCollectedUnknownHouseHold(BigInteger.valueOf(0));

		q25bNumberOfVeteranHouseholdsTable.setQ25bTotTotal(BigInteger
				.valueOf(0));
		q25bNumberOfVeteranHouseholdsTable.setQ25bTotWithoutChildren(BigInteger
				.valueOf(0));
		q25bNumberOfVeteranHouseholdsTable
				.setQ25bTotWithChildAndAdults(BigInteger.valueOf(0));
		q25bNumberOfVeteranHouseholdsTable
				.setQ25bTotUnknownHouseHold(BigInteger.valueOf(0));

		return q25bNumberOfVeteranHouseholdsTable;
	}

	public static DataBean getQ25cGenderVeteransList(BigInteger q25cMaleTotal,
			BigInteger q25cMaleWithoutChildren,
			BigInteger q25cMaleWithChildAndAdults,
			BigInteger q25cMaleUnknownHouseHold,

			BigInteger q25cFemaleTotal, BigInteger q25cFemaleWithoutChildren,
			BigInteger q25cFemaleWithChildAndAdults,
			BigInteger q25cFemaleUnknownHouseHold,

			BigInteger q25cTransgenderMaleToFemaleTotal,
			BigInteger q25cTransgenderMaleToFemaleWithoutChildren,
			BigInteger q25cTransgenderMaleToFemaleWithChildAndAdults,
			BigInteger q25cTransgenderMaleToFemaleUnknownHouseHold,

			BigInteger q25cTransgendereFemaleToMaleTotal,
			BigInteger q25cTransgendereFemaleToMaleWithoutChildren,
			BigInteger q25cTransgendereFemaleToMaleWithChildAndAdults,
			BigInteger q25cTransgendereFemaleToMaleUnknownHouseHold,

			BigInteger q25cOtherTotal, BigInteger q25cOtherWithoutChildren,
			BigInteger q25cOtherWithChildAndAdults,
			BigInteger q25cOtherUnknownHouseHold,

			BigInteger q25cDKRTotal, BigInteger q25cDKRWithoutChildren,
			BigInteger q25cDKRWithChildAndAdults,
			BigInteger q25cDKRUnknownHouseHold,

			BigInteger q25cInformationMissingTotal,
			BigInteger q25cInformationMissingWithoutChildren,
			BigInteger q25cInformationMissingWithChildAndAdults,
			BigInteger q25cInformationMissingUnknownHouseHold,

			BigInteger q25cTotTotal, BigInteger q25cTotWithoutChildren,
			BigInteger q25cTotWithChildAndAdults,
			BigInteger q25cTotUnknownHouseHold, DataBean q25cGenderVeteranTable) {

		q25cGenderVeteranTable.setQ25cMaleTotal(BigInteger.valueOf(0));
		q25cGenderVeteranTable
				.setQ25cMaleWithoutChildren(BigInteger.valueOf(0));
		q25cGenderVeteranTable.setQ25cMaleWithChildAndAdults(BigInteger
				.valueOf(0));
		q25cGenderVeteranTable.setQ25cMaleUnknownHouseHold(BigInteger
				.valueOf(0));

		q25cGenderVeteranTable.setQ25cFemaleTotal(BigInteger.valueOf(0));
		q25cGenderVeteranTable.setQ25cFemaleWithoutChildren(BigInteger
				.valueOf(0));
		q25cGenderVeteranTable.setQ25cFemaleWithChildAndAdults(BigInteger
				.valueOf(0));
		q25cGenderVeteranTable.setQ25cFemaleUnknownHouseHold(BigInteger
				.valueOf(0));

		q25cGenderVeteranTable.setQ25cTransgenderMaleToFemaleTotal(BigInteger
				.valueOf(0));
		q25cGenderVeteranTable
				.setQ25cTransgenderMaleToFemaleWithoutChildren(BigInteger
						.valueOf(0));
		q25cGenderVeteranTable
				.setQ25cTransgenderMaleToFemaleWithChildAndAdults(BigInteger
						.valueOf(0));
		q25cGenderVeteranTable
				.setQ25cTransgenderMaleToFemaleUnknownHouseHold(BigInteger
						.valueOf(0));

		q25cGenderVeteranTable.setQ25cTransgendereFemaleToMaleTotal(BigInteger
				.valueOf(0));
		q25cGenderVeteranTable
				.setQ25cTransgendereFemaleToMaleWithoutChildren(BigInteger
						.valueOf(0));
		q25cGenderVeteranTable
				.setQ25cTransgendereFemaleToMaleWithChildAndAdults(BigInteger
						.valueOf(0));
		q25cGenderVeteranTable
				.setQ25cTransgendereFemaleToMaleUnknownHouseHold(BigInteger
						.valueOf(0));

		q25cGenderVeteranTable.setQ25cOtherTotal(BigInteger.valueOf(0));
		q25cGenderVeteranTable.setQ25cOtherWithoutChildren(BigInteger
				.valueOf(0));
		q25cGenderVeteranTable.setQ25cOtherWithChildAndAdults(BigInteger
				.valueOf(0));
		q25cGenderVeteranTable.setQ25cOtherUnknownHouseHold(BigInteger
				.valueOf(0));

		q25cGenderVeteranTable.setQ25cDKRTotal(BigInteger.valueOf(0));
		q25cGenderVeteranTable.setQ25cDKRWithoutChildren(BigInteger.valueOf(0));
		q25cGenderVeteranTable.setQ25cDKRWithChildAndAdults(BigInteger
				.valueOf(0));
		q25cGenderVeteranTable
				.setQ25cDKRUnknownHouseHold(BigInteger.valueOf(0));

		q25cGenderVeteranTable.setQ25cInformationMissingTotal(BigInteger
				.valueOf(0));
		q25cGenderVeteranTable
				.setQ25cInformationMissingWithoutChildren(BigInteger.valueOf(0));
		q25cGenderVeteranTable
				.setQ25cInformationMissingWithChildAndAdults(BigInteger
						.valueOf(0));
		q25cGenderVeteranTable
				.setQ25cInformationMissingUnknownHouseHold(BigInteger
						.valueOf(0));

		q25cGenderVeteranTable.setQ25cTotTotal(BigInteger.valueOf(0));
		q25cGenderVeteranTable.setQ25cTotWithoutChildren(BigInteger.valueOf(0));
		q25cGenderVeteranTable.setQ25cTotWithChildAndAdults(BigInteger
				.valueOf(0));
		q25cGenderVeteranTable
				.setQ25cTotUnknownHouseHold(BigInteger.valueOf(0));

		return q25cGenderVeteranTable;
	}

	public static DataBean getQ25dAgeVeteransList(BigInteger q25d18To24Total,
			BigInteger q25d18To24WithoutChildren,
			BigInteger q25d18To24WithChildAndAdults,
			BigInteger q25d18To24UnknownHouseHold,

			BigInteger q25d25To34Total, BigInteger q25d25To34WithoutChildren,
			BigInteger q25d25To34WithChildAndAdults,
			BigInteger q25d25To34UnknownHouseHold,

			BigInteger q25d35To44Total, BigInteger q25d35To44WithoutChildren,
			BigInteger q25d35To44WithChildAndAdults,
			BigInteger q25d35To44UnknownHouseHold,

			BigInteger q25d45To54Total, BigInteger q25d45To54WithoutChildren,
			BigInteger q25d45To54WithChildAndAdults,
			BigInteger q25d45To54UnknownHouseHold,

			BigInteger q25d55To61Total, BigInteger q25d55To61WithoutChildren,
			BigInteger q25d55To61WithChildAndAdults,
			BigInteger q25d55To61UnknownHouseHold,

			BigInteger q25d62PlusTotal, BigInteger q25d62PlusWithoutChildren,
			BigInteger q25d62PlusWithChildAndAdults,
			BigInteger q25d62PlusUnknownHouseHold,

			BigInteger q25dDKRTotal, BigInteger q25dDKRWithoutChildren,
			BigInteger q25dDKRWithChildAndAdults,
			BigInteger q25dDKRUnknownHouseHold,

			BigInteger q25dInformationMissingTotal,
			BigInteger q25dInformationMissingWithoutChildren,
			BigInteger q25dInformationMissingWithChildAndAdults,
			BigInteger q25dInformationMissingUnknownHouseHold,

			BigInteger q25dTotTotal, BigInteger q25dTotWithoutChildren,
			BigInteger q25dTotWithChildAndAdults,
			BigInteger q25dTotUnknownHouseHold,

			DataBean q25dAgeVeteransTable) {

		q25dAgeVeteransTable.setQ25d18To24Total(BigInteger.valueOf(0));
		q25dAgeVeteransTable
				.setQ25d18To24WithoutChildren(BigInteger.valueOf(0));
		q25dAgeVeteransTable.setQ25d18To24WithChildAndAdults(BigInteger
				.valueOf(0));
		q25dAgeVeteransTable.setQ25d18To24UnknownHouseHold(BigInteger
				.valueOf(0));

		q25dAgeVeteransTable.setQ25d25To34Total(BigInteger.valueOf(0));
		q25dAgeVeteransTable
				.setQ25d25To34WithoutChildren(BigInteger.valueOf(0));
		q25dAgeVeteransTable.setQ25d25To34WithChildAndAdults(BigInteger
				.valueOf(0));
		q25dAgeVeteransTable.setQ25d25To34UnknownHouseHold(BigInteger
				.valueOf(0));

		q25dAgeVeteransTable.setQ25d35To44Total(BigInteger.valueOf(0));
		q25dAgeVeteransTable
				.setQ25d35To44WithoutChildren(BigInteger.valueOf(0));
		q25dAgeVeteransTable.setQ25d35To44WithChildAndAdults(BigInteger
				.valueOf(0));
		q25dAgeVeteransTable.setQ25d35To44UnknownHouseHold(BigInteger
				.valueOf(0));

		q25dAgeVeteransTable.setQ25d45To54Total(BigInteger.valueOf(0));
		q25dAgeVeteransTable
				.setQ25d45To54WithoutChildren(BigInteger.valueOf(0));
		q25dAgeVeteransTable.setQ25d45To54WithChildAndAdults(BigInteger
				.valueOf(0));
		q25dAgeVeteransTable.setQ25d45To54UnknownHouseHold(BigInteger
				.valueOf(0));

		q25dAgeVeteransTable.setQ25d55To61Total(BigInteger.valueOf(0));
		q25dAgeVeteransTable
				.setQ25d55To61WithoutChildren(BigInteger.valueOf(0));
		q25dAgeVeteransTable.setQ25d55To61WithChildAndAdults(BigInteger
				.valueOf(0));
		q25dAgeVeteransTable.setQ25d55To61UnknownHouseHold(BigInteger
				.valueOf(0));

		q25dAgeVeteransTable.setQ25d62PlusTotal(BigInteger.valueOf(0));
		q25dAgeVeteransTable
				.setQ25d62PlusWithoutChildren(BigInteger.valueOf(0));
		q25dAgeVeteransTable.setQ25d62PlusWithChildAndAdults(BigInteger
				.valueOf(0));
		q25dAgeVeteransTable.setQ25d62PlusUnknownHouseHold(BigInteger
				.valueOf(0));

		q25dAgeVeteransTable.setQ25dDKRTotal(BigInteger.valueOf(0));
		q25dAgeVeteransTable.setQ25dDKRWithoutChildren(BigInteger.valueOf(0));
		q25dAgeVeteransTable
				.setQ25dDKRWithChildAndAdults(BigInteger.valueOf(0));
		q25dAgeVeteransTable.setQ25dDKRUnknownHouseHold(BigInteger.valueOf(0));

		q25dAgeVeteransTable.setQ25dInformationMissingTotal(BigInteger
				.valueOf(0));
		q25dAgeVeteransTable
				.setQ25dInformationMissingWithoutChildren(BigInteger.valueOf(0));
		q25dAgeVeteransTable
				.setQ25dInformationMissingWithChildAndAdults(BigInteger
						.valueOf(0));
		q25dAgeVeteransTable
				.setQ25dInformationMissingUnknownHouseHold(BigInteger
						.valueOf(0));

		q25dAgeVeteransTable.setQ25dTotTotal(BigInteger.valueOf(0));
		q25dAgeVeteransTable.setQ25dTotWithoutChildren(BigInteger.valueOf(0));
		q25dAgeVeteransTable
				.setQ25dTotWithChildAndAdults(BigInteger.valueOf(0));
		q25dAgeVeteransTable.setQ25dTotUnknownHouseHold(BigInteger.valueOf(0));

		return q25dAgeVeteransTable;
	}

	public static DataBean getQ25ePhysicalAndMentalHealthConditionsVeteransList(
			BigInteger q25eMentalIllnessAtEntry,
			BigInteger q25eMentalIllnessStayers,
			BigInteger q25eMentalIllnessLeavers,

			BigInteger q25eAlcoholAbuseAtEntry,
			BigInteger q25eAlcoholAbuseStayers,
			BigInteger q25eAlcoholAbuseLeavers,

			BigInteger q25eDrugAbuseAtEntry, BigInteger q25eDrugAbuseStayers,
			BigInteger q25eDrugAbuseLeavers,

			BigInteger q25eBothAlcoholAndDrugAbuseAtEntry,
			BigInteger q25eBothAlcoholAndDrugAbuseStayers,
			BigInteger q25eBothAlcoholAndDrugAbuseLeavers,

			BigInteger q25eChronicHealthConditionAtEntry,
			BigInteger q25eChronicHealthConditionStayers,
			BigInteger q25eChronicHealthConditionLeavers,

			BigInteger q25eHIVandRelatedDiseaseAtEntry,
			BigInteger q25eHIVandRelatedDiseaseStayers,
			BigInteger q25eHIVandRelatedDiseaseLeavers,

			BigInteger q25eDevelopmentalDisabilityAtEntry,
			BigInteger q25eDevelopmentalDisabilityStayers,
			BigInteger q25eDevelopmentalDisabilityLeavers,

			BigInteger q25ePhysicalDisabilityAtEntry,
			BigInteger q25ePhysicalDisabilityStayers,
			BigInteger q25ePhysicalDisabilityLeavers,

			DataBean q25ePhysicalAndMentalHealthConditionsVeteransTable) {
		q25ePhysicalAndMentalHealthConditionsVeteransTable
				.setQ25eMentalIllnessAtEntry(BigInteger.valueOf(0));
		q25ePhysicalAndMentalHealthConditionsVeteransTable
				.setQ25eMentalIllnessStayers(BigInteger.valueOf(0));
		q25ePhysicalAndMentalHealthConditionsVeteransTable
				.setQ25eMentalIllnessLeavers(BigInteger.valueOf(0));

		q25ePhysicalAndMentalHealthConditionsVeteransTable
				.setQ25eAlcoholAbuseAtEntry(BigInteger.valueOf(0));
		q25ePhysicalAndMentalHealthConditionsVeteransTable
				.setQ25eAlcoholAbuseStayers(BigInteger.valueOf(0));
		q25ePhysicalAndMentalHealthConditionsVeteransTable
				.setQ25eAlcoholAbuseLeavers(BigInteger.valueOf(0));

		q25ePhysicalAndMentalHealthConditionsVeteransTable
				.setQ25eDrugAbuseAtEntry(BigInteger.valueOf(0));
		q25ePhysicalAndMentalHealthConditionsVeteransTable
				.setQ25eDrugAbuseStayers(BigInteger.valueOf(0));
		q25ePhysicalAndMentalHealthConditionsVeteransTable
				.setQ25eDrugAbuseLeavers(BigInteger.valueOf(0));

		q25ePhysicalAndMentalHealthConditionsVeteransTable
				.setQ25eBothAlcoholAndDrugAbuseAtEntry(BigInteger.valueOf(0));
		q25ePhysicalAndMentalHealthConditionsVeteransTable
				.setQ25eBothAlcoholAndDrugAbuseStayers(BigInteger.valueOf(0));
		q25ePhysicalAndMentalHealthConditionsVeteransTable
				.setQ25eBothAlcoholAndDrugAbuseLeavers(BigInteger.valueOf(0));

		q25ePhysicalAndMentalHealthConditionsVeteransTable
				.setQ25eChronicHealthConditionAtEntry(BigInteger.valueOf(0));
		q25ePhysicalAndMentalHealthConditionsVeteransTable
				.setQ25eChronicHealthConditionStayers(BigInteger.valueOf(0));
		q25ePhysicalAndMentalHealthConditionsVeteransTable
				.setQ25eChronicHealthConditionLeavers(BigInteger.valueOf(0));

		q25ePhysicalAndMentalHealthConditionsVeteransTable
				.setQ25eHIVandRelatedDiseaseAtEntry(BigInteger.valueOf(0));
		q25ePhysicalAndMentalHealthConditionsVeteransTable
				.setQ25eHIVandRelatedDiseaseStayers(BigInteger.valueOf(0));
		q25ePhysicalAndMentalHealthConditionsVeteransTable
				.setQ25eHIVandRelatedDiseaseLeavers(BigInteger.valueOf(0));

		q25ePhysicalAndMentalHealthConditionsVeteransTable
				.setQ25eDevelopmentalDisabilityAtEntry(BigInteger.valueOf(0));
		q25ePhysicalAndMentalHealthConditionsVeteransTable
				.setQ25eDevelopmentalDisabilityStayers(BigInteger.valueOf(0));
		q25ePhysicalAndMentalHealthConditionsVeteransTable
				.setQ25eDevelopmentalDisabilityLeavers(BigInteger.valueOf(0));

		q25ePhysicalAndMentalHealthConditionsVeteransTable
				.setQ25ePhysicalDisabilityAtEntry(BigInteger.valueOf(0));
		q25ePhysicalAndMentalHealthConditionsVeteransTable
				.setQ25ePhysicalDisabilityStayers(BigInteger.valueOf(0));
		q25ePhysicalAndMentalHealthConditionsVeteransTable
				.setQ25ePhysicalDisabilityLeavers(BigInteger.valueOf(0));

		return q25ePhysicalAndMentalHealthConditionsVeteransTable;
	}

	public static DataBean getQ25fCashIncomeCategoryIncomeCategoryByEntryList(
			BigInteger q25fAdultsWithOnlyEarnedIncomeAtEntry,
			BigInteger q25fAdultsWithOnlyEarnedIncomeStayers,
			BigInteger q25fAdultsWithOnlyEarnedIncomeLeavers,
					
			BigInteger q25fAdultsWithOnlyOtherIncomeAtEntry,
			BigInteger q25fAdultsWithOnlyOtherIncomeStayers,
			BigInteger q25fAdultsWithOnlyOtherIncomeLeavers,
					
			BigInteger q25fAdultsWithBothEarnedAndOtherAtEntry,
			BigInteger q25fAdultsWithBothEarnedAndOtherStayers,
			BigInteger q25fAdultsWithBothEarnedAndOtherLeavers,
					
			BigInteger q25fAdultsWithNoIncomeAtEntry,
			BigInteger q25fAdultsWithNoIncomeStayers,
			BigInteger q25fAdultsWithNoIncomeLeavers,
					
			BigInteger q25fAdultsWithDontRefusedIncomeAtEntry,
			BigInteger q25fAdultsWithDontRefusedIncomeStayers,
			BigInteger q25fAdultsWithDontRefusedIncomeLeavers,
					
			BigInteger q25fAdultsWithMissingInomeInfoAtEntry,
			BigInteger q25fAdultsWithMissingInomeInfoStayers,
			BigInteger q25fAdultsWithMissingInomeInfoLeavers,
					
			BigInteger q25fNumberOfAdultStayersNotYetRequiredAtEntry,
			BigInteger q25fNumberOfAdultStayersNotYetRequiredStayers,
			BigInteger q25fNumberOfAdultStayersNotYetRequiredLeavers,
					
			BigInteger q25fNumberOfAdultStayersWithoutRequiredAtEntry,
			BigInteger q25fNumberOfAdultStayersWithoutRequiredStayers,
			BigInteger q25fNumberOfAdultStayersWithoutRequiredLeavers,
					
			BigInteger q25fTotalAdultsAtEntry,
			BigInteger q25fTotalAdultsStayers,
			BigInteger q25fTotalAdultsLeavers,
			DataBean q25fCashIncomeCategoryIncomeCategoryByEntryTable) {

		q25fCashIncomeCategoryIncomeCategoryByEntryTable
				.setQ25fAdultsWithOnlyEarnedIncomeAtEntry(BigInteger.valueOf(0));
		q25fCashIncomeCategoryIncomeCategoryByEntryTable
				.setQ25fAdultsWithOnlyEarnedIncomeStayers(BigInteger.valueOf(0));
		q25fCashIncomeCategoryIncomeCategoryByEntryTable
				.setQ25fAdultsWithOnlyEarnedIncomeLeavers(BigInteger.valueOf(0));

		q25fCashIncomeCategoryIncomeCategoryByEntryTable
				.setQ25fAdultsWithOnlyOtherIncomeAtEntry(BigInteger.valueOf(0));
		q25fCashIncomeCategoryIncomeCategoryByEntryTable
				.setQ25fAdultsWithOnlyOtherIncomeStayers(BigInteger.valueOf(0));
		q25fCashIncomeCategoryIncomeCategoryByEntryTable
				.setQ25fAdultsWithOnlyOtherIncomeLeavers(BigInteger.valueOf(0));

		q25fCashIncomeCategoryIncomeCategoryByEntryTable
				.setQ25fAdultsWithBothEarnedAndOtherAtEntry(BigInteger
						.valueOf(0));
		q25fCashIncomeCategoryIncomeCategoryByEntryTable
				.setQ25fAdultsWithBothEarnedAndOtherStayers(BigInteger
						.valueOf(0));
		q25fCashIncomeCategoryIncomeCategoryByEntryTable
				.setQ25fAdultsWithBothEarnedAndOtherLeavers(BigInteger
						.valueOf(0));

		q25fCashIncomeCategoryIncomeCategoryByEntryTable
				.setQ25fAdultsWithNoIncomeAtEntry(BigInteger.valueOf(0));
		q25fCashIncomeCategoryIncomeCategoryByEntryTable
				.setQ25fAdultsWithNoIncomeStayers(BigInteger.valueOf(0));
		q25fCashIncomeCategoryIncomeCategoryByEntryTable
				.setQ25fAdultsWithNoIncomeLeavers(BigInteger.valueOf(0));

		q25fCashIncomeCategoryIncomeCategoryByEntryTable
				.setQ25fAdultsWithDontRefusedIncomeAtEntry(BigInteger
						.valueOf(0));
		q25fCashIncomeCategoryIncomeCategoryByEntryTable
				.setQ25fAdultsWithDontRefusedIncomeStayers(BigInteger
						.valueOf(0));
		q25fCashIncomeCategoryIncomeCategoryByEntryTable
				.setQ25fAdultsWithDontRefusedIncomeLeavers(BigInteger
						.valueOf(0));

		q25fCashIncomeCategoryIncomeCategoryByEntryTable
				.setQ25fAdultsWithMissingInomeInfoAtEntry(BigInteger.valueOf(0));
		q25fCashIncomeCategoryIncomeCategoryByEntryTable
				.setQ25fAdultsWithMissingInomeInfoStayers(BigInteger.valueOf(0));
		q25fCashIncomeCategoryIncomeCategoryByEntryTable
				.setQ25fAdultsWithMissingInomeInfoLeavers(BigInteger.valueOf(0));

		q25fCashIncomeCategoryIncomeCategoryByEntryTable
				.setQ25fNumberOfAdultStayersNotYetRequiredAtEntry(BigInteger
						.valueOf(0));
		q25fCashIncomeCategoryIncomeCategoryByEntryTable
				.setQ25fNumberOfAdultStayersNotYetRequiredStayers(BigInteger
						.valueOf(0));
		q25fCashIncomeCategoryIncomeCategoryByEntryTable
				.setQ25fNumberOfAdultStayersNotYetRequiredLeavers(BigInteger
						.valueOf(0));

		q25fCashIncomeCategoryIncomeCategoryByEntryTable
				.setQ25fNumberOfAdultStayersWithoutRequiredAtEntry(BigInteger
						.valueOf(0));
		q25fCashIncomeCategoryIncomeCategoryByEntryTable
				.setQ25fNumberOfAdultStayersWithoutRequiredStayers(BigInteger
						.valueOf(0));
		q25fCashIncomeCategoryIncomeCategoryByEntryTable
				.setQ25fNumberOfAdultStayersWithoutRequiredLeavers(BigInteger
						.valueOf(0));

		q25fCashIncomeCategoryIncomeCategoryByEntryTable
				.setQ25fTotalAdultsAtEntry(BigInteger.valueOf(0));
		q25fCashIncomeCategoryIncomeCategoryByEntryTable
				.setQ25fTotalAdultsStayers(BigInteger.valueOf(0));
		q25fCashIncomeCategoryIncomeCategoryByEntryTable
				.setQ25fTotalAdultsLeavers(BigInteger.valueOf(0));

		return q25fCashIncomeCategoryIncomeCategoryByEntryTable;
	}

	public static DataBean getQ25gTypeOfCashIncomeSourcesVeteranList(
			BigInteger q25gEarnedIncomeAtEntry,
			BigInteger q25gEarnedIncomeStayers,
			BigInteger q25gEarnedIncomeLeavers,
					
			BigInteger q25gUnemploymentInsuranceAtEntry,
			BigInteger q25gUnemploymentInsuranceStayers,
			BigInteger q25gUnemploymentInsuranceLeavers,
					
			BigInteger q25gSSIAtEntry,
			BigInteger q25gSSIStayers,
			BigInteger q25gSSILeavers,
					
			BigInteger q25gSSDIAtEntry,
			BigInteger q25gSSDIStayers,
			BigInteger q25gSSDILeavers,
					
			BigInteger q25gVAServiceConnectedDisabilityAtEntry,
			BigInteger q25gVAServiceConnectedDisabilityStayers,
			BigInteger q25gVAServiceConnectedDisabilityLeavers,
					
			BigInteger q25gVANonServiceConnectedDisabilityAtEntry,
			BigInteger q25gVANonServiceConnectedDisabilityStayers,
			BigInteger q25gVANonServiceConnectedDisabilityLeavers,
					
			BigInteger q25gPrivateDisabilityInsuranceAtEntry,
			BigInteger q25gPrivateDisabilityInsuranceStayers,
			BigInteger q25gPrivateDisabilityInsuranceLeavers,
					
			BigInteger q25gWorkersCompensationAtEntry,
			BigInteger q25gWorkersCompensationStayers,
			BigInteger q25gWorkersCompensationLeavers,
					
			BigInteger q25gTANFAtEntry,
			BigInteger q25gTANFStayers,
			BigInteger q25gTANFLeavers,
					
			BigInteger q25gGeneralAssistanceAtEntry,
			BigInteger q25gGeneralAssistanceStayers,
			BigInteger q25gGeneralAssistanceLeavers,
					
			BigInteger q25gRetirementAtEntry,
			BigInteger q25gRetirementStayers,
			BigInteger q25gRetirementLeavers,
					
			BigInteger q25gPensionFromFormerJobAtEntry,
			BigInteger q25gPensionFromFormerJobStayers,
			BigInteger q25gPensionFromFormerJobLeavers,
					
			BigInteger q25gChildSupportAtEntry,
			BigInteger q25gChildSupportStayers,
			BigInteger q25gChildSupportLeavers,
					
			BigInteger q25gAlimonyAtEntry,
			BigInteger q25gAlimonyStayers,
			BigInteger q25gAlimonyLeavers,
					
			BigInteger q25gOtherSourceAtEntry,
			BigInteger q25gOtherSourceStayers,
			BigInteger q25gOtherSourceLeavers,
					
			BigInteger q25gAdultsWithIncomeInfoAtEntryAtEntry,
			BigInteger q25gAdultsWithIncomeInfoAtEntryStayers,
			BigInteger q25gAdultsWithIncomeInfoAtEntryLeavers,
				
	DataBean q25gTypeOfCashIncomeSourcesVeteransTable) {
		q25gTypeOfCashIncomeSourcesVeteransTable.setQ25gEarnedIncomeAtEntry(BigInteger.valueOf(0));
		q25gTypeOfCashIncomeSourcesVeteransTable.setQ25gEarnedIncomeStayers(BigInteger.valueOf(0));
		q25gTypeOfCashIncomeSourcesVeteransTable.setQ25gEarnedIncomeLeavers(BigInteger.valueOf(0));

		q25gTypeOfCashIncomeSourcesVeteransTable.setQ25gUnemploymentInsuranceAtEntry(BigInteger.valueOf(0));
		q25gTypeOfCashIncomeSourcesVeteransTable.setQ25gUnemploymentInsuranceStayers(BigInteger.valueOf(0));
		q25gTypeOfCashIncomeSourcesVeteransTable.setQ25gUnemploymentInsuranceLeavers(BigInteger.valueOf(0));

		q25gTypeOfCashIncomeSourcesVeteransTable.setQ25gSSIAtEntry(BigInteger.valueOf(0));
		q25gTypeOfCashIncomeSourcesVeteransTable.setQ25gSSIStayers(BigInteger.valueOf(0));
		q25gTypeOfCashIncomeSourcesVeteransTable.setQ25gSSILeavers(BigInteger.valueOf(0));

		q25gTypeOfCashIncomeSourcesVeteransTable.setQ25gSSDIAtEntry(BigInteger.valueOf(0));
		q25gTypeOfCashIncomeSourcesVeteransTable.setQ25gSSDIStayers(BigInteger.valueOf(0));
		q25gTypeOfCashIncomeSourcesVeteransTable.setQ25gSSDILeavers(BigInteger.valueOf(0));

		q25gTypeOfCashIncomeSourcesVeteransTable.setQ25gVAServiceConnectedDisabilityAtEntry(BigInteger.valueOf(0));
		q25gTypeOfCashIncomeSourcesVeteransTable.setQ25gVAServiceConnectedDisabilityStayers(BigInteger.valueOf(0));
		q25gTypeOfCashIncomeSourcesVeteransTable.setQ25gVAServiceConnectedDisabilityLeavers(BigInteger.valueOf(0));

		q25gTypeOfCashIncomeSourcesVeteransTable.setQ25gVANonServiceConnectedDisabilityAtEntry(BigInteger.valueOf(0));
		q25gTypeOfCashIncomeSourcesVeteransTable.setQ25gVANonServiceConnectedDisabilityStayers(BigInteger.valueOf(0));
		q25gTypeOfCashIncomeSourcesVeteransTable.setQ25gVANonServiceConnectedDisabilityLeavers(BigInteger.valueOf(0));

		q25gTypeOfCashIncomeSourcesVeteransTable.setQ25gPrivateDisabilityInsuranceAtEntry(BigInteger.valueOf(0));
		q25gTypeOfCashIncomeSourcesVeteransTable.setQ25gPrivateDisabilityInsuranceStayers(BigInteger.valueOf(0));
		q25gTypeOfCashIncomeSourcesVeteransTable.setQ25gPrivateDisabilityInsuranceLeavers(BigInteger.valueOf(0));

		q25gTypeOfCashIncomeSourcesVeteransTable.setQ25gWorkersCompensationAtEntry(BigInteger.valueOf(0));
		q25gTypeOfCashIncomeSourcesVeteransTable.setQ25gWorkersCompensationStayers(BigInteger.valueOf(0));
		q25gTypeOfCashIncomeSourcesVeteransTable.setQ25gWorkersCompensationLeavers(BigInteger.valueOf(0));

		q25gTypeOfCashIncomeSourcesVeteransTable.setQ25gTANFAtEntry(BigInteger.valueOf(0));
		q25gTypeOfCashIncomeSourcesVeteransTable.setQ25gTANFStayers(BigInteger.valueOf(0));
		q25gTypeOfCashIncomeSourcesVeteransTable.setQ25gTANFLeavers(BigInteger.valueOf(0));

		q25gTypeOfCashIncomeSourcesVeteransTable.setQ25gGeneralAssistanceAtEntry(BigInteger.valueOf(0));
		q25gTypeOfCashIncomeSourcesVeteransTable.setQ25gGeneralAssistanceStayers(BigInteger.valueOf(0));
		q25gTypeOfCashIncomeSourcesVeteransTable.setQ25gGeneralAssistanceLeavers(BigInteger.valueOf(0));

		q25gTypeOfCashIncomeSourcesVeteransTable.setQ25gRetirementAtEntry(BigInteger.valueOf(0));
		q25gTypeOfCashIncomeSourcesVeteransTable.setQ25gRetirementStayers(BigInteger.valueOf(0));
		q25gTypeOfCashIncomeSourcesVeteransTable.setQ25gRetirementLeavers(BigInteger.valueOf(0));

		q25gTypeOfCashIncomeSourcesVeteransTable.setQ25gPensionFromFormerJobAtEntry(BigInteger.valueOf(0));
		q25gTypeOfCashIncomeSourcesVeteransTable.setQ25gPensionFromFormerJobStayers(BigInteger.valueOf(0));
		q25gTypeOfCashIncomeSourcesVeteransTable.setQ25gPensionFromFormerJobLeavers(BigInteger.valueOf(0));

		q25gTypeOfCashIncomeSourcesVeteransTable.setQ25gChildSupportAtEntry(BigInteger.valueOf(0));
		q25gTypeOfCashIncomeSourcesVeteransTable.setQ25gChildSupportStayers(BigInteger.valueOf(0));
		q25gTypeOfCashIncomeSourcesVeteransTable.setQ25gChildSupportLeavers(BigInteger.valueOf(0));

		q25gTypeOfCashIncomeSourcesVeteransTable.setQ25gAlimonyAtEntry(BigInteger.valueOf(0));
		q25gTypeOfCashIncomeSourcesVeteransTable.setQ25gAlimonyStayers(BigInteger.valueOf(0));
		q25gTypeOfCashIncomeSourcesVeteransTable.setQ25gAlimonyLeavers(BigInteger.valueOf(0));

		q25gTypeOfCashIncomeSourcesVeteransTable.setQ25gOtherSourceAtEntry(BigInteger.valueOf(0));
		q25gTypeOfCashIncomeSourcesVeteransTable.setQ25gOtherSourceStayers(BigInteger.valueOf(0));
		q25gTypeOfCashIncomeSourcesVeteransTable.setQ25gOtherSourceLeavers(BigInteger.valueOf(0));

		q25gTypeOfCashIncomeSourcesVeteransTable.setQ25gAdultsWithIncomeInfoAtEntryAtEntry(BigInteger.valueOf(0));
		q25gTypeOfCashIncomeSourcesVeteransTable.setQ25gAdultsWithIncomeInfoAtEntryStayers(BigInteger.valueOf(0));
		q25gTypeOfCashIncomeSourcesVeteransTable.setQ25gAdultsWithIncomeInfoAtEntryLeavers(BigInteger.valueOf(0));

		return q25gTypeOfCashIncomeSourcesVeteransTable;
	}
	public static DataBean getQ25hTypeOfNonCashIncomeSourcesVeteransList(
			BigInteger q25hSupplementalNutritionalAssistanceAtEntry,
			BigInteger q25hSupplementalNutritionalAssistanceStayers,
			BigInteger q25hSupplementalNutritionalAssistanceLeavers,

			BigInteger q25hWICAtEntry,
			BigInteger q25hWICStayers,
			BigInteger q25hWICLeavers,
					
			BigInteger q25hTANFChildCareServicesAtEntry,
			BigInteger q25hTANFChildCareServicesStayers,
			BigInteger q25hTANFChildCareServicesLeavers,
					
			BigInteger q25hTANFTransportationServicesAtEntry,
			BigInteger q25hTANFTransportationServicesStayers,
			BigInteger q25hTANFTransportationServicesLeavers,
					
			BigInteger q25hOtherTANFFundedServicesAtEntry,
			BigInteger q25hOtherTANFFundedServicesStayers,
			BigInteger q25hOtherTANFFundedServicesLeavers,
					
			BigInteger q25hOtherSourceAtEntry,
			BigInteger q25hOtherSourceStayers,
			BigInteger q25hOtherSourceLeavers,
			DataBean q25hTypeOfNonCashIncomeSourcesVeteransTable) {
		q25hTypeOfNonCashIncomeSourcesVeteransTable.setQ25hSupplementalNutritionalAssistanceAtEntry(BigInteger.valueOf(0));
		q25hTypeOfNonCashIncomeSourcesVeteransTable.setQ25hSupplementalNutritionalAssistanceStayers(BigInteger.valueOf(0));
		q25hTypeOfNonCashIncomeSourcesVeteransTable.setQ25hSupplementalNutritionalAssistanceLeavers(BigInteger.valueOf(0));

		q25hTypeOfNonCashIncomeSourcesVeteransTable.setQ25hWICAtEntry(BigInteger.valueOf(0));
		q25hTypeOfNonCashIncomeSourcesVeteransTable.setQ25hWICStayers(BigInteger.valueOf(0));
		q25hTypeOfNonCashIncomeSourcesVeteransTable.setQ25hWICLeavers(BigInteger.valueOf(0));

		q25hTypeOfNonCashIncomeSourcesVeteransTable.setQ25hTANFChildCareServicesAtEntry(BigInteger.valueOf(0));
		q25hTypeOfNonCashIncomeSourcesVeteransTable.setQ25hTANFChildCareServicesStayers(BigInteger.valueOf(0));
		q25hTypeOfNonCashIncomeSourcesVeteransTable.setQ25hTANFChildCareServicesLeavers(BigInteger.valueOf(0));

		q25hTypeOfNonCashIncomeSourcesVeteransTable.setQ25hTANFTransportationServicesAtEntry(BigInteger.valueOf(0));
		q25hTypeOfNonCashIncomeSourcesVeteransTable.setQ25hTANFTransportationServicesStayers(BigInteger.valueOf(0));
		q25hTypeOfNonCashIncomeSourcesVeteransTable.setQ25hTANFTransportationServicesLeavers(BigInteger.valueOf(0));

		q25hTypeOfNonCashIncomeSourcesVeteransTable.setQ25hOtherTANFFundedServicesAtEntry(BigInteger.valueOf(0));
		q25hTypeOfNonCashIncomeSourcesVeteransTable.setQ25hOtherTANFFundedServicesStayers(BigInteger.valueOf(0));
		q25hTypeOfNonCashIncomeSourcesVeteransTable.setQ25hOtherTANFFundedServicesLeavers(BigInteger.valueOf(0));

		q25hTypeOfNonCashIncomeSourcesVeteransTable.setQ25hOtherSourceAtEntry(BigInteger.valueOf(0));
		q25hTypeOfNonCashIncomeSourcesVeteransTable.setQ25hOtherSourceStayers(BigInteger.valueOf(0));
		q25hTypeOfNonCashIncomeSourcesVeteransTable.setQ25hOtherSourceLeavers(BigInteger.valueOf(0));

		return q25hTypeOfNonCashIncomeSourcesVeteransTable;
	}

	public static DataBean getQ25iExitDestinationVeteransList(
			BigInteger q25iA01MovedFromOneHOPWATotal,
			BigInteger q25iA01MovedFromOneHOPWAWithoutChild,
			BigInteger q25iA01MovedFromOneHOPWAWithChildAndAdults,
			BigInteger q25iA01MovedFromOneHOPWAWithOnlyChild,
			BigInteger q25iA01MovedFromOneHOPWAUnknownHouseHold,
					
			BigInteger q25iA02OwnedByClientNoOngoingSubsidyTotal,
			BigInteger q25iA02OwnedByClientNoOngoingSubsidyWithoutChild,
			BigInteger q25iA02OwnedByClientNoOngoingSubsidyWithChildAndAdults,
			BigInteger q25iA02OwnedByClientNoOngoingSubsidyWithOnlyChild,
			BigInteger q25iA02OwnedByClientNoOngoingSubsidyUnknownHouseHold,
					
			BigInteger q25iA03OwnedByClientWithOngoingSubsidyTotal,
			BigInteger q25iA03OwnedByClientWithOngoingSubsidyWithoutChild,
			BigInteger q25iA03OwnedByClientWithOngoingSubsidyWithChildAndAdults,
			BigInteger q25iA03OwnedByClientWithOngoingSubsidyWithOnlyChild,
			BigInteger q25iA03OwnedByClientWithOngoingSubsidyUnknownHouseHold,
					
			BigInteger q25iA04RentalByClientNoOngoingSubsidyTotal,
			BigInteger q25iA04RentalByClientNoOngoingSubsidyWithoutChild,
			BigInteger q25iA04RentalByClientNoOngoingSubsidyWithChildAndAdults,
			BigInteger q25iA04RentalByClientNoOngoingSubsidyWithOnlyChild,
			BigInteger q25iA04RentalByClientNoOngoingSubsidyUnknownHouseHold,
					
			BigInteger q25iA05RentalByClientVASHSubsidyTotal,
			BigInteger q25iA05RentalByClientVASHSubsidyWithoutChild,
			BigInteger q25iA05RentalByClientVASHSubsidyWithChildAndAdults,
			BigInteger q25iA05RentalByClientVASHSubsidyWithOnlyChild,
			BigInteger q25iA05RentalByClientVASHSubsidyUnknownHouseHold,
					
			BigInteger q25iA06RentalByClientwithGPDTIPHousingTotal,
			BigInteger q25iA06RentalByClientwithGPDTIPHousingWithoutChild,
			BigInteger q25iA06RentalByClientwithGPDTIPHousingWithChildAndAdults,
			BigInteger q25iA06RentalByClientwithGPDTIPHousingWithOnlyChild,
			BigInteger q25iA06RentalByClientwithGPDTIPHousingUnknownHouseHold,
					
			BigInteger q25iA07RentalByClientOtherOngoingSubsidyTotal,
			BigInteger q25iA07RentalByClientOtherOngoingSubsidyWithoutChild,
			BigInteger q25iA07RentalByClientOtherOngoingSubsidyWithChildAndAdults,
			BigInteger q25iA07RentalByClientOtherOngoingSubsidyWithOnlyChild,
			BigInteger q25iA07RentalByClientOtherOngoingSubsidyUnknownHouseHold,
					
			BigInteger q25iA08PermanentHousingForHomelessTotal,
			BigInteger q25iA08PermanentHousingForHomelessWithoutChild,
			BigInteger q25iA08PermanentHousingForHomelessWithChildAndAdults,
			BigInteger q25iA08PermanentHousingForHomelessWithOnlyChild,
			BigInteger q25iA08PermanentHousingForHomelessUnknownHouseHold,
					
			BigInteger q25iA09StayingOrLivingWithFamilyPermanentTotal,
			BigInteger q25iA09StayingOrLivingWithFamilyPermanentWithoutChild,
			BigInteger q25iA09StayingOrLivingWithFamilyPermanentWithChildAndAdults,
			BigInteger q25iA09StayingOrLivingWithFamilyPermanentWithOnlyChild,
			BigInteger q25iA09StayingOrLivingWithFamilyPermanentUnknownHouseHold,
					
			BigInteger q25iA10StayingOrLivingWithFriendsPermanentTotal,
			BigInteger q25iA10StayingOrLivingWithFriendsPermanentWithoutChild,
			BigInteger q25iA10StayingOrLivingWithFriendsPermanentWithChildAndAdults,
			BigInteger q25iA10StayingOrLivingWithFriendsPermanentWithOnlyChild,
			BigInteger q25iA10StayingOrLivingWithFriendsPermanentUnknownHouseHold,
					
			BigInteger q25iAzTotTotal,
			BigInteger q25iAzTotWithoutChild,
			BigInteger q25iAzTotWithChildAndAdults,
			BigInteger q25iAzTotWithOnlyChild,
			BigInteger q25iAzTotUnknownHouseHold,
					
			BigInteger q25iB1EmergencyShelterTotal,
			BigInteger q25iB1EmergencyShelterWithoutChild,
			BigInteger q25iB1EmergencyShelterWithChildAndAdults,
			BigInteger q25iB1EmergencyShelterWithOnlyChild,
			BigInteger q25iB1EmergencyShelterUnknownHouseHold,
					
			BigInteger q25iB2MovedFromOneHOPWATotal,
			BigInteger q25iB2MovedFromOneHOPWAWithoutChild,
			BigInteger q25iB2MovedFromOneHOPWAWithChildAndAdults,
			BigInteger q25iB2MovedFromOneHOPWAWithOnlyChild,
			BigInteger q25iB2MovedFromOneHOPWAUnknownHouseHold,
					
			BigInteger q25iB3TransitionalHousingForHomelessTotal,
			BigInteger q25iB3TransitionalHousingForHomelessWithoutChild,
			BigInteger q25iB3TransitionalHousingForHomelessWithChildAndAdults,
			BigInteger q25iB3TransitionalHousingForHomelessWithOnlyChild,
			BigInteger q25iB3TransitionalHousingForHomelessUnknownHouseHold,
					
			BigInteger q25iB4StayingWithFamilyTemporaryTenureTotal,
			BigInteger q25iB4StayingWithFamilyTemporaryTenureWithoutChild,
			BigInteger q25iB4StayingWithFamilyTemporaryTenureWithChildAndAdults,
			BigInteger q25iB4StayingWithFamilyTemporaryTenureWithOnlyChild,
			BigInteger q25iB4StayingWithFamilyTemporaryTenureUnknownHouseHold,
					
			BigInteger q25iB5StayingWithFriendsTemporaryTenureTotal,
			BigInteger q25iB5StayingWithFriendsTemporaryTenureWithoutChild,
			BigInteger q25iB5StayingWithFriendsTemporaryTenureWithChildAndAdults,
			BigInteger q25iB5StayingWithFriendsTemporaryTenureWithOnlyChild,
			BigInteger q25iB5StayingWithFriendsTemporaryTenureUnknownHouseHold,
					
			BigInteger q25iB6PlaceNotMeantForHumanHabitationTotal,
			BigInteger q25iB6PlaceNotMeantForHumanHabitationWithoutChild,
			BigInteger q25iB6PlaceNotMeantForHumanHabitationWithChildAndAdults,
			BigInteger q25iB6PlaceNotMeantForHumanHabitationWithOnlyChild,
			BigInteger q25iB6PlaceNotMeantForHumanHabitationUnknownHouseHold,
					
			BigInteger q25iB7SafeHavenTotal,
			BigInteger q25iB7SafeHavenWithoutChild,
			BigInteger q25iB7SafeHavenWithChildAndAdults,
			BigInteger q25iB7SafeHavenWithOnlyChild,
			BigInteger q25iB7SafeHavenUnknownHouseHold,
					
			BigInteger q25iB8HotelOrMotelPaidbyClientTotal,
			BigInteger q25iB8HotelOrMotelPaidbyClientWithoutChild,
			BigInteger q25iB8HotelOrMotelPaidbyClientWithChildAndAdults,
			BigInteger q25iB8HotelOrMotelPaidbyClientWithOnlyChild,
			BigInteger q25iB8HotelOrMotelPaidbyClientUnknownHouseHold,
					
			BigInteger q25iBzTotTotal,
			BigInteger q25iBzTotWithoutChild,
			BigInteger q25iBzTotWithChildAndAdults,
			BigInteger q25iBzTotWithOnlyChild,
			BigInteger q25iBzTotUnknownHouseHold,
					
			BigInteger q25iC1FosterCareHomeOrGroupFosterCareTotal,
			BigInteger q25iC1FosterCareHomeOrGroupFosterCareWithoutChild,
			BigInteger q25iC1FosterCareHomeOrGroupFosterCareWithChildAndAdults,
			BigInteger q25iC1FosterCareHomeOrGroupFosterCareWithOnlyChild,
			BigInteger q25iC1FosterCareHomeOrGroupFosterCareUnknownHouseHold,
					
			BigInteger q25iC2PsychiatricHospitalOrOtherTotal,
			BigInteger q25iC2PsychiatricHospitalOrOtherWithoutChild,
			BigInteger q25iC2PsychiatricHospitalOrOtherWithChildAndAdults,
			BigInteger q25iC2PsychiatricHospitalOrOtherWithOnlyChild,
			BigInteger q25iC2PsychiatricHospitalOrOtherUnknownHouseHold,
					
			BigInteger q25iC3SubstanceAbuseTreatmentFacilityTotal,
			BigInteger q25iC3SubstanceAbuseTreatmentFacilityWithoutChild,
			BigInteger q25iC3SubstanceAbuseTreatmentFacilityWithChildAndAdults,
			BigInteger q25iC3SubstanceAbuseTreatmentFacilityWithOnlyChild,
			BigInteger q25iC3SubstanceAbuseTreatmentFacilityUnknownHouseHold,
					
			BigInteger q25iC4HospitalOrOtherResidentialTotal,
			BigInteger q25iC4HospitalOrOtherResidentialWithoutChild,
			BigInteger q25iC4HospitalOrOtherResidentialWithChildAndAdults,
			BigInteger q25iC4HospitalOrOtherResidentialWithOnlyChild,
			BigInteger q25iC4HospitalOrOtherResidentialUnknownHouseHold,
					
			BigInteger q25iC5JailPrisonOrUvenileDetentionTotal,
			BigInteger q25iC5JailPrisonOrUvenileDetentionWithoutChild,
			BigInteger q25iC5JailPrisonOrUvenileDetentionWithChildAndAdults,
			BigInteger q25iC5JailPrisonOrUvenileDetentionWithOnlyChild,
			BigInteger q25iC5JailPrisonOrUvenileDetentionUnknownHouseHold,
					
			BigInteger q25iC6LongTermCareFacilityTotal,
			BigInteger q25iC6LongTermCareFacilityWithoutChild,
			BigInteger q25iC6LongTermCareFacilityWithChildAndAdults,
			BigInteger q25iC6LongTermCareFacilityWithOnlyChild,
			BigInteger q25iC6LongTermCareFacilityUnknownHouseHold,
					
			BigInteger q25iCzTotTotal,
			BigInteger q25iCzTotWithoutChild,
			BigInteger q25iCzTotWithChildAndAdults,
			BigInteger q25iCzTotWithOnlyChild,
			BigInteger q25iCzTotUnknownHouseHold,
					
			BigInteger q25iD1ResidentialProjectTotal,
			BigInteger q25iD1ResidentialProjectWithoutChild,
			BigInteger q25iD1ResidentialProjectWithChildAndAdults,
			BigInteger q25iD1ResidentialProjectWithOnlyChild,
			BigInteger q25iD1ResidentialProjectUnknownHouseHold,
					
			BigInteger q25iD2DeceasedTotal,
			BigInteger q25iD2DeceasedWithoutChild,
			BigInteger q25iD2DeceasedWithChildAndAdults,
			BigInteger q25iD2DeceasedWithOnlyChild,
			BigInteger q25iD2DeceasedUnknownHouseHold,
					
			BigInteger q25iD3OtherTotal,
			BigInteger q25iD3OtherWithoutChild,
			BigInteger q25iD3OtherWithChildAndAdults,
			BigInteger q25iD3OtherWithOnlyChild,
			BigInteger q25iD3OtherUnknownHouseHold,
					
			BigInteger q25iD4DontKnowRefusedTotal,
			BigInteger q25iD4DontKnowRefusedWithoutChild,
			BigInteger q25iD4DontKnowRefusedWithChildAndAdults,
			BigInteger q25iD4DontKnowRefusedWithOnlyChild,
			BigInteger q25iD4DontKnowRefusedUnknownHouseHold,
					
			BigInteger q25iD5InformationMissingTotal,
			BigInteger q25iD5InformationMissingWithoutChild,
			BigInteger q25iD5InformationMissingWithChildAndAdults,
			BigInteger q25iD5InformationMissingWithOnlyChild,
			BigInteger q25iD5InformationMissingUnknownHouseHold,
					
			BigInteger q25iDzTotTotal,
			BigInteger q25iDzTotWithoutChild,
			BigInteger q25iDzTotWithChildAndAdults,
			BigInteger q25iDzTotWithOnlyChild,
			BigInteger q25iDzTotUnknownHouseHold,
					
			BigInteger q25iETotTotal,
			BigInteger q25iETotWithoutChild,
			BigInteger q25iETotWithChildAndAdults,
			BigInteger q25iETotWithOnlyChild,
			BigInteger q25iETotUnknownHouseHold,
				
			BigInteger q25iTotPersonsExistTotal,
			BigInteger q25iTotPersonsExistWithoutChild,
			BigInteger q25iTotPersonsExistWithChildAndAdults,
			BigInteger q25iTotPersonsExistWithOnlyChild,
			BigInteger q25iTotPersonsExistUnknownHouseHold,
				
			BigInteger q25iTotPersonsDstnTotal,
			BigInteger q25iTotPersonsDstnWithoutChild,
			BigInteger q25iTotPersonsDstnWithChildAndAdults,
			BigInteger q25iTotPersonsDstnWithOnlyChild,
			BigInteger q25iTotPersonsDstnUnknownHouseHold,
				
			BigInteger q25iPercentageTotal,
			BigInteger q25iPercentageWithoutChild,
			BigInteger q25iPercentageWithChildAndAdults,
			BigInteger q25iPercentageWithOnlyChild,
			BigInteger q25iPercentageUnknownHouseHold,
			DataBean q25iExitDestinationVeteransTable) {
		
		q25iExitDestinationVeteransTable.setQ25iA01MovedFromOneHOPWATotal(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iA01MovedFromOneHOPWAWithoutChild(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iA01MovedFromOneHOPWAWithChildAndAdults(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iA01MovedFromOneHOPWAWithOnlyChild(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iA01MovedFromOneHOPWAUnknownHouseHold(BigInteger.valueOf(0));

		q25iExitDestinationVeteransTable.setQ25iA02OwnedByClientNoOngoingSubsidyTotal(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iA02OwnedByClientNoOngoingSubsidyWithoutChild(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iA02OwnedByClientNoOngoingSubsidyWithChildAndAdults(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iA02OwnedByClientNoOngoingSubsidyWithOnlyChild(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iA02OwnedByClientNoOngoingSubsidyUnknownHouseHold(BigInteger.valueOf(0));

		q25iExitDestinationVeteransTable.setQ25iA03OwnedByClientWithOngoingSubsidyTotal(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iA03OwnedByClientWithOngoingSubsidyWithoutChild(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iA03OwnedByClientWithOngoingSubsidyWithChildAndAdults(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iA03OwnedByClientWithOngoingSubsidyWithOnlyChild(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iA03OwnedByClientWithOngoingSubsidyUnknownHouseHold(BigInteger.valueOf(0));

		q25iExitDestinationVeteransTable.setQ25iA04RentalByClientNoOngoingSubsidyTotal(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iA04RentalByClientNoOngoingSubsidyWithoutChild(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iA04RentalByClientNoOngoingSubsidyWithChildAndAdults(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iA04RentalByClientNoOngoingSubsidyWithOnlyChild(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iA04RentalByClientNoOngoingSubsidyUnknownHouseHold(BigInteger.valueOf(0));

		q25iExitDestinationVeteransTable.setQ25iA05RentalByClientVASHSubsidyTotal(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iA05RentalByClientVASHSubsidyWithoutChild(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iA05RentalByClientVASHSubsidyWithChildAndAdults(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iA05RentalByClientVASHSubsidyWithOnlyChild(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iA05RentalByClientVASHSubsidyUnknownHouseHold(BigInteger.valueOf(0));

		q25iExitDestinationVeteransTable.setQ25iA06RentalByClientwithGPDTIPHousingTotal(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iA06RentalByClientwithGPDTIPHousingWithoutChild(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iA06RentalByClientwithGPDTIPHousingWithChildAndAdults(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iA06RentalByClientwithGPDTIPHousingWithOnlyChild(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iA06RentalByClientwithGPDTIPHousingUnknownHouseHold(BigInteger.valueOf(0));

		q25iExitDestinationVeteransTable.setQ25iA07RentalByClientOtherOngoingSubsidyTotal(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iA07RentalByClientOtherOngoingSubsidyWithoutChild(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iA07RentalByClientOtherOngoingSubsidyWithChildAndAdults(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iA07RentalByClientOtherOngoingSubsidyWithOnlyChild(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iA07RentalByClientOtherOngoingSubsidyUnknownHouseHold(BigInteger.valueOf(0));

		q25iExitDestinationVeteransTable.setQ25iA08PermanentHousingForHomelessTotal(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iA08PermanentHousingForHomelessWithoutChild(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iA08PermanentHousingForHomelessWithChildAndAdults(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iA08PermanentHousingForHomelessWithOnlyChild(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iA08PermanentHousingForHomelessUnknownHouseHold(BigInteger.valueOf(0));

		q25iExitDestinationVeteransTable.setQ25iA09StayingOrLivingWithFamilyPermanentTotal(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iA09StayingOrLivingWithFamilyPermanentWithoutChild(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iA09StayingOrLivingWithFamilyPermanentWithChildAndAdults(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iA09StayingOrLivingWithFamilyPermanentWithOnlyChild(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iA09StayingOrLivingWithFamilyPermanentUnknownHouseHold(BigInteger.valueOf(0));

		q25iExitDestinationVeteransTable.setQ25iA10StayingOrLivingWithFriendsPermanentTotal(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iA10StayingOrLivingWithFriendsPermanentWithoutChild(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iA10StayingOrLivingWithFriendsPermanentWithChildAndAdults(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iA10StayingOrLivingWithFriendsPermanentWithOnlyChild(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iA10StayingOrLivingWithFriendsPermanentUnknownHouseHold(BigInteger.valueOf(0));

		q25iExitDestinationVeteransTable.setQ25iAzTotTotal(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iAzTotWithoutChild(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iAzTotWithChildAndAdults(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iAzTotWithOnlyChild(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iAzTotUnknownHouseHold(BigInteger.valueOf(0));

		q25iExitDestinationVeteransTable.setQ25iB1EmergencyShelterTotal(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iB1EmergencyShelterWithoutChild(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iB1EmergencyShelterWithChildAndAdults(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iB1EmergencyShelterWithOnlyChild(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iB1EmergencyShelterUnknownHouseHold(BigInteger.valueOf(0));

		q25iExitDestinationVeteransTable.setQ25iB2MovedFromOneHOPWATotal(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iB2MovedFromOneHOPWAWithoutChild(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iB2MovedFromOneHOPWAWithChildAndAdults(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iB2MovedFromOneHOPWAWithOnlyChild(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iB2MovedFromOneHOPWAUnknownHouseHold(BigInteger.valueOf(0));

		q25iExitDestinationVeteransTable.setQ25iB3TransitionalHousingForHomelessTotal(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iB3TransitionalHousingForHomelessWithoutChild(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iB3TransitionalHousingForHomelessWithChildAndAdults(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iB3TransitionalHousingForHomelessWithOnlyChild(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iB3TransitionalHousingForHomelessUnknownHouseHold(BigInteger.valueOf(0));

		q25iExitDestinationVeteransTable.setQ25iB4StayingWithFamilyTemporaryTenureTotal(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iB4StayingWithFamilyTemporaryTenureWithoutChild(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iB4StayingWithFamilyTemporaryTenureWithChildAndAdults(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iB4StayingWithFamilyTemporaryTenureWithOnlyChild(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iB4StayingWithFamilyTemporaryTenureUnknownHouseHold(BigInteger.valueOf(0));

		q25iExitDestinationVeteransTable.setQ25iB5StayingWithFriendsTemporaryTenureTotal(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iB5StayingWithFriendsTemporaryTenureWithoutChild(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iB5StayingWithFriendsTemporaryTenureWithChildAndAdults(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iB5StayingWithFriendsTemporaryTenureWithOnlyChild(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iB5StayingWithFriendsTemporaryTenureUnknownHouseHold(BigInteger.valueOf(0));

		q25iExitDestinationVeteransTable.setQ25iB6PlaceNotMeantForHumanHabitationTotal(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iB6PlaceNotMeantForHumanHabitationWithoutChild(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iB6PlaceNotMeantForHumanHabitationWithChildAndAdults(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iB6PlaceNotMeantForHumanHabitationWithOnlyChild(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iB6PlaceNotMeantForHumanHabitationUnknownHouseHold(BigInteger.valueOf(0));

		q25iExitDestinationVeteransTable.setQ25iB7SafeHavenTotal(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iB7SafeHavenWithoutChild(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iB7SafeHavenWithChildAndAdults(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iB7SafeHavenWithOnlyChild(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iB7SafeHavenUnknownHouseHold(BigInteger.valueOf(0));

		q25iExitDestinationVeteransTable.setQ25iB8HotelOrMotelPaidbyClientTotal(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iB8HotelOrMotelPaidbyClientWithoutChild(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iB8HotelOrMotelPaidbyClientWithChildAndAdults(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iB8HotelOrMotelPaidbyClientWithOnlyChild(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iB8HotelOrMotelPaidbyClientUnknownHouseHold(BigInteger.valueOf(0));

		q25iExitDestinationVeteransTable.setQ25iBzTotTotal(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iBzTotWithoutChild(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iBzTotWithChildAndAdults(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iBzTotWithOnlyChild(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iBzTotUnknownHouseHold(BigInteger.valueOf(0));

		q25iExitDestinationVeteransTable.setQ25iC1FosterCareHomeOrGroupFosterCareTotal(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iC1FosterCareHomeOrGroupFosterCareWithoutChild(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iC1FosterCareHomeOrGroupFosterCareWithChildAndAdults(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iC1FosterCareHomeOrGroupFosterCareWithOnlyChild(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iC1FosterCareHomeOrGroupFosterCareUnknownHouseHold(BigInteger.valueOf(0));

		q25iExitDestinationVeteransTable.setQ25iC2PsychiatricHospitalOrOtherTotal(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iC2PsychiatricHospitalOrOtherWithoutChild(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iC2PsychiatricHospitalOrOtherWithChildAndAdults(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iC2PsychiatricHospitalOrOtherWithOnlyChild(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iC2PsychiatricHospitalOrOtherUnknownHouseHold(BigInteger.valueOf(0));

		q25iExitDestinationVeteransTable.setQ25iC3SubstanceAbuseTreatmentFacilityTotal(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iC3SubstanceAbuseTreatmentFacilityWithoutChild(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iC3SubstanceAbuseTreatmentFacilityWithOnlyChild(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iC3SubstanceAbuseTreatmentFacilityWithChildAndAdults(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iC3SubstanceAbuseTreatmentFacilityUnknownHouseHold(BigInteger.valueOf(0));

		q25iExitDestinationVeteransTable.setQ25iC4HospitalOrOtherResidentialTotal(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iC4HospitalOrOtherResidentialWithoutChild(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iC4HospitalOrOtherResidentialWithChildAndAdults(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iC4HospitalOrOtherResidentialWithOnlyChild(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iC4HospitalOrOtherResidentialUnknownHouseHold(BigInteger.valueOf(0));

		q25iExitDestinationVeteransTable.setQ25iC5JailPrisonOrUvenileDetentionTotal(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iC5JailPrisonOrUvenileDetentionWithoutChild(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iC5JailPrisonOrUvenileDetentionWithChildAndAdults(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iC5JailPrisonOrUvenileDetentionWithOnlyChild(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iC5JailPrisonOrUvenileDetentionUnknownHouseHold(BigInteger.valueOf(0));

		q25iExitDestinationVeteransTable.setQ25iC6LongTermCareFacilityTotal(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iC6LongTermCareFacilityWithoutChild(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iC6LongTermCareFacilityWithChildAndAdults(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iC6LongTermCareFacilityWithOnlyChild(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iC6LongTermCareFacilityUnknownHouseHold(BigInteger.valueOf(0));

		q25iExitDestinationVeteransTable.setQ25iCzTotTotal(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iCzTotWithoutChild(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iCzTotWithChildAndAdults(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iCzTotWithOnlyChild(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iCzTotUnknownHouseHold(BigInteger.valueOf(0));

		q25iExitDestinationVeteransTable.setQ25iD1ResidentialProjectTotal(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iD1ResidentialProjectWithoutChild(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iD1ResidentialProjectWithChildAndAdults(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iD1ResidentialProjectWithOnlyChild(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iD1ResidentialProjectUnknownHouseHold(BigInteger.valueOf(0));

		q25iExitDestinationVeteransTable.setQ25iD2DeceasedTotal(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iD2DeceasedWithoutChild(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iD2DeceasedWithChildAndAdults(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iD2DeceasedWithOnlyChild(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iD2DeceasedUnknownHouseHold(BigInteger.valueOf(0));

		q25iExitDestinationVeteransTable.setQ25iD3OtherTotal(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iD3OtherWithoutChild(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iD3OtherWithChildAndAdults(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iD3OtherWithOnlyChild(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iD3OtherUnknownHouseHold(BigInteger.valueOf(0));

		q25iExitDestinationVeteransTable.setQ25iD4DontKnowRefusedTotal(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iD4DontKnowRefusedWithoutChild(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iD4DontKnowRefusedWithChildAndAdults(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iD4DontKnowRefusedWithOnlyChild(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iD4DontKnowRefusedUnknownHouseHold(BigInteger.valueOf(0));

		q25iExitDestinationVeteransTable.setQ25iD5InformationMissingTotal(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iD5InformationMissingWithoutChild(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iD5InformationMissingWithChildAndAdults(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iD5InformationMissingWithOnlyChild(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iD5InformationMissingUnknownHouseHold(BigInteger.valueOf(0));

		q25iExitDestinationVeteransTable.setQ25iDzTotTotal(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iDzTotWithoutChild(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iDzTotWithChildAndAdults(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iDzTotWithOnlyChild(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iDzTotUnknownHouseHold(BigInteger.valueOf(0));

		q25iExitDestinationVeteransTable.setQ25iETotTotal(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iETotWithoutChild(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iETotWithChildAndAdults(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iETotWithOnlyChild(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iETotUnknownHouseHold(BigInteger.valueOf(0));

		q25iExitDestinationVeteransTable.setQ25iTotPersonsExistTotal(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iTotPersonsExistUnknownHouseHold(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iTotPersonsExistWithChildAndAdults(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iTotPersonsExistWithOnlyChild(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iTotPersonsExistWithoutChild(BigInteger.valueOf(0));

		q25iExitDestinationVeteransTable.setQ25iTotPersonsDstnTotal(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iTotPersonsDstnUnknownHouseHold(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iTotPersonsDstnWithChildAndAdults(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iTotPersonsDstnWithOnlyChild(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iTotPersonsDstnWithoutChild(BigInteger.valueOf(0));

		q25iExitDestinationVeteransTable.setQ25iPercentageTotal(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iPercentageUnknownHouseHold(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iPercentageWithChildAndAdults(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iPercentageWithOnlyChild(BigInteger.valueOf(0));
		q25iExitDestinationVeteransTable.setQ25iPercentageWithoutChild(BigInteger.valueOf(0));

		return q25iExitDestinationVeteransTable;
	}
	
	public static DataBean getQ26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyList(
			BigInteger q26aChronicallyHomelessTotal,
			BigInteger q26aChronicallyHomelessWithoutChild,
			BigInteger q26aChronicallyHomelessWithChildAndAdults,
			BigInteger q26aChronicallyHomelessWithOnlyChild,
			BigInteger q26aChronicallyHomelessUnknownHouseholdType,

			BigInteger q26aNotChronicallyHomelessTotal,
			BigInteger q26aNotChronicallyHomelessWithoutChild,
			BigInteger q26aNotChronicallyHomelessWithChildAndAdults,
			BigInteger q26aNotChronicallyHomelessWithOnlyChild,
			BigInteger q26aNotChronicallyHomelessUnknownHouseholdType,

			BigInteger q26aClientRefusedTotal,
			BigInteger q26aClientRefusedWithoutChild,
			BigInteger q26aClientRefusedWithChildAndAdults,
			BigInteger q26aClientRefusedWithOnlyChild,
			BigInteger q26aClientRefusedUnknownHouseholdType,

			BigInteger q26aDataNotCollectedTotal,
			BigInteger q26aDataNotCollectedWithoutChild,
			BigInteger q26aDataNotCollectedWithChildAndAdults,
			BigInteger q26aDataNotCollectedWithOnlyChild,
			BigInteger q26aDataNotCollectedUnknownHouseholdType,

			BigInteger q26aTotTotal,
			BigInteger q26aTotWithoutChild,
			BigInteger q26aTotWithChildAndAdults,
			BigInteger q26aTotWithOnlyChild,
			BigInteger q26aTotUnknownHouseholdType,
			DataBean q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyTable) {
		
		q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyTable.setQ26aChronicallyHomelessTotal(BigInteger.valueOf(0));
		q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyTable.setQ26aChronicallyHomelessWithoutChild(BigInteger.valueOf(0));
		q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyTable.setQ26aChronicallyHomelessWithChildAndAdults(BigInteger.valueOf(0));
		q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyTable.setQ26aChronicallyHomelessWithOnlyChild(BigInteger.valueOf(0));
		q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyTable.setQ26aChronicallyHomelessUnknownHouseholdType(BigInteger.valueOf(0));

		q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyTable.setQ26aNotChronicallyHomelessTotal(BigInteger.valueOf(0));
		q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyTable.setQ26aNotChronicallyHomelessWithoutChild(BigInteger.valueOf(0));
		q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyTable.setQ26aNotChronicallyHomelessWithChildAndAdults(BigInteger.valueOf(0));
		q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyTable.setQ26aNotChronicallyHomelessWithOnlyChild(BigInteger.valueOf(0));
		q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyTable.setQ26aNotChronicallyHomelessUnknownHouseholdType(BigInteger.valueOf(0));

		q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyTable.setQ26aClientRefusedTotal(BigInteger.valueOf(0));
		q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyTable.setQ26aClientRefusedWithoutChild(BigInteger.valueOf(0));
		q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyTable.setQ26aClientRefusedWithChildAndAdults(BigInteger.valueOf(0));
		q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyTable.setQ26aClientRefusedWithOnlyChild(BigInteger.valueOf(0));
		q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyTable.setQ26aClientRefusedUnknownHouseholdType(BigInteger.valueOf(0));

		q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyTable.setQ26aDataNotCollectedTotal(BigInteger.valueOf(0));
		q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyTable.setQ26aDataNotCollectedWithoutChild(BigInteger.valueOf(0));
		q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyTable.setQ26aDataNotCollectedWithChildAndAdults(BigInteger.valueOf(0));
		q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyTable.setQ26aDataNotCollectedWithOnlyChild(BigInteger.valueOf(0));
		q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyTable.setQ26aDataNotCollectedUnknownHouseholdType(BigInteger.valueOf(0));

		q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyTable.setQ26aTotTotal(BigInteger.valueOf(0));
		q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyTable.setQ26aTotWithoutChild(BigInteger.valueOf(0));
		q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyTable.setQ26aTotWithChildAndAdults(BigInteger.valueOf(0));
		q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyTable.setQ26aTotWithOnlyChild(BigInteger.valueOf(0));
		q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyTable.setQ26aTotUnknownHouseholdType(BigInteger.valueOf(0));

		
		return q26aNumberOfHouseholdsAtLeastOneOrMoreChronicallyTable;
	}
	
	public static DataBean getQ26bNumberOfChronicallyHomelessPersonsByHouseholdList(
			BigInteger q26bChronicallyHomelessTotal,
			BigInteger q26bChronicallyHomelessWithoutChild,
			BigInteger q26bChronicallyHomelessWithChildAndAdults,
			BigInteger q26bChronicallyHomelessWithOnlyChild,
			BigInteger q26bChronicallyHomelessUnknownHouseholdType,

			BigInteger q26bNotChronicallyHomelessTotal,
			BigInteger q26bNotChronicallyHomelessWithoutChild,
			BigInteger q26bNotChronicallyHomelessWithChildAndAdults,
			BigInteger q26bNotChronicallyHomelessWithOnlyChild,
			BigInteger q26bNotChronicallyHomelessUnknownHouseholdType,

			BigInteger q26bClientRefusedTotal,
			BigInteger q26bClientRefusedWithoutChild,
			BigInteger q26bClientRefusedWithChildAndAdults,
			BigInteger q26bClientRefusedWithOnlyChild,
			BigInteger q26bClientRefusedUnknownHouseholdType,

			BigInteger q26bDataNotCollectedTotal,
			BigInteger q26bDataNotCollectedWithoutChild,
			BigInteger q26bDataNotCollectedWithChildAndAdults,
			BigInteger q26bDataNotCollectedWithOnlyChild,
			BigInteger q26bDataNotCollectedUnknownHouseholdType,

			BigInteger q26bTotTotal,
			BigInteger q26bTotWithoutChild,
			BigInteger q26bTotWithChildAndAdults,
			BigInteger q26bTotWithOnlyChild,
			BigInteger q26bTotUnknownHouseholdType,
			DataBean q26bNumberOfChronicallyHomelessPersonsByHouseholdTable) {
			
		q26bNumberOfChronicallyHomelessPersonsByHouseholdTable.setQ26bChronicallyHomelessTotal(BigInteger.valueOf(0));
		q26bNumberOfChronicallyHomelessPersonsByHouseholdTable.setQ26bChronicallyHomelessWithoutChild(BigInteger.valueOf(0));
		q26bNumberOfChronicallyHomelessPersonsByHouseholdTable.setQ26bChronicallyHomelessWithChildAndAdults(BigInteger.valueOf(0));
		q26bNumberOfChronicallyHomelessPersonsByHouseholdTable.setQ26bChronicallyHomelessWithOnlyChild(BigInteger.valueOf(0));
		q26bNumberOfChronicallyHomelessPersonsByHouseholdTable.setQ26bChronicallyHomelessUnknownHouseholdType(BigInteger.valueOf(0));

		q26bNumberOfChronicallyHomelessPersonsByHouseholdTable.setQ26bNotChronicallyHomelessTotal(BigInteger.valueOf(0));
		q26bNumberOfChronicallyHomelessPersonsByHouseholdTable.setQ26bNotChronicallyHomelessWithoutChild(BigInteger.valueOf(0));
		q26bNumberOfChronicallyHomelessPersonsByHouseholdTable.setQ26bNotChronicallyHomelessWithChildAndAdults(BigInteger.valueOf(0));
		q26bNumberOfChronicallyHomelessPersonsByHouseholdTable.setQ26bNotChronicallyHomelessWithOnlyChild(BigInteger.valueOf(0));
		q26bNumberOfChronicallyHomelessPersonsByHouseholdTable.setQ26bNotChronicallyHomelessUnknownHouseholdType(BigInteger.valueOf(0));

		q26bNumberOfChronicallyHomelessPersonsByHouseholdTable.setQ26bClientRefusedTotal(BigInteger.valueOf(0));
		q26bNumberOfChronicallyHomelessPersonsByHouseholdTable.setQ26bClientRefusedWithoutChild(BigInteger.valueOf(0));
		q26bNumberOfChronicallyHomelessPersonsByHouseholdTable.setQ26bClientRefusedWithChildAndAdults(BigInteger.valueOf(0));
		q26bNumberOfChronicallyHomelessPersonsByHouseholdTable.setQ26bClientRefusedWithOnlyChild(BigInteger.valueOf(0));
		q26bNumberOfChronicallyHomelessPersonsByHouseholdTable.setQ26bClientRefusedUnknownHouseholdType(BigInteger.valueOf(0));

		q26bNumberOfChronicallyHomelessPersonsByHouseholdTable.setQ26bDataNotCollectedTotal(BigInteger.valueOf(0));
		q26bNumberOfChronicallyHomelessPersonsByHouseholdTable.setQ26bDataNotCollectedWithoutChild(BigInteger.valueOf(0));
		q26bNumberOfChronicallyHomelessPersonsByHouseholdTable.setQ26bDataNotCollectedWithChildAndAdults(BigInteger.valueOf(0));
		q26bNumberOfChronicallyHomelessPersonsByHouseholdTable.setQ26bDataNotCollectedWithOnlyChild(BigInteger.valueOf(0));
		q26bNumberOfChronicallyHomelessPersonsByHouseholdTable.setQ26bDataNotCollectedUnknownHouseholdType(BigInteger.valueOf(0));

		q26bNumberOfChronicallyHomelessPersonsByHouseholdTable.setQ26bTotTotal(BigInteger.valueOf(0));
		q26bNumberOfChronicallyHomelessPersonsByHouseholdTable.setQ26bTotWithoutChild(BigInteger.valueOf(0));
		q26bNumberOfChronicallyHomelessPersonsByHouseholdTable.setQ26bTotWithChildAndAdults(BigInteger.valueOf(0));
		q26bNumberOfChronicallyHomelessPersonsByHouseholdTable.setQ26bTotWithOnlyChild(BigInteger.valueOf(0));
		q26bNumberOfChronicallyHomelessPersonsByHouseholdTable.setQ26bTotUnknownHouseholdType(BigInteger.valueOf(0));

		    return q26bNumberOfChronicallyHomelessPersonsByHouseholdTable;
	}
	
	public static DataBean getQ26cGenderOfChronicallyHomelessPersonList(
			BigInteger q26cMaleTotal,
			BigInteger q26cMaleWithoutChild,
			BigInteger q26cMaleWithChildAndAdults,
			BigInteger q26cMaleWithOnlyChild,
			BigInteger q26cMaleUnknownHouseholdType,
					
			BigInteger q26cFemaleTotal,
			BigInteger q26cFemaleWithoutChild,
			BigInteger q26cFemaleWithChildAndAdults,
			BigInteger q26cFemaleWithOnlyChild,
			BigInteger q26cFemaleUnknownHouseholdType,
					
			BigInteger q26cTransgenderMaleToFemaleTotal,
			BigInteger q26cTransgenderMaleToFemaleWithoutChild,
			BigInteger q26cTransgenderMaleToFemaleWithChildAndAdults,
			BigInteger q26cTransgenderMaleToFemaleWithOnlyChild,
			BigInteger q26cTransgenderMaleToFemaleUnknownHouseholdType,
					
			BigInteger q26cTransgenderFemaleToMaleTotal,
			BigInteger q26cTransgenderFemaleToMaleWithoutChild,
			BigInteger q26cTransgenderFemaleToMaleWithChildAndAdults,
			BigInteger q26cTransgenderFemaleToMaleWithOnlyChild,
			BigInteger q26cTransgenderFemaleToMaleUnknownHouseholdType,
					
			BigInteger q26cOtherTotal,
			BigInteger q26cOtherWithoutChild,
			BigInteger q26cOtherWithChildAndAdults,
			BigInteger q26cOtherWithOnlyChild,
			BigInteger q26cOtherUnknownHouseholdType,
					
			BigInteger q26cDKRTotal,
			BigInteger q26cDKRWithoutChild,
			BigInteger q26cDKRWithChildAndAdults,
			BigInteger q26cDKRWithOnlyChild,
			BigInteger q26cDKRUnknownHouseholdType,
					
			BigInteger q26cInformationMissingTotal,
			BigInteger q26cInformationMissingWithoutChild,
			BigInteger q26cInformationMissingWithChildAndAdults,
			BigInteger q26cInformationMissingWithOnlyChild,
			BigInteger q26cInformationMissingUnknownHouseholdType,
					
			BigInteger q26cSubtotalTotal,
			BigInteger q26cSubtotalWithoutChild,
			BigInteger q26cSubtotalWithChildAndAdults,
			BigInteger q26cSubtotalWithOnlyChild,
			BigInteger q26cSubtotalUnknownHouseholdType,
			DataBean q26cGenderOfChronicallyHomelessPersonTable) {
			
		q26cGenderOfChronicallyHomelessPersonTable.setQ26cMaleTotal(BigInteger.valueOf(0));
		q26cGenderOfChronicallyHomelessPersonTable.setQ26cMaleWithoutChild(BigInteger.valueOf(0));
		q26cGenderOfChronicallyHomelessPersonTable.setQ26cMaleWithChildAndAdults(BigInteger.valueOf(0));
		q26cGenderOfChronicallyHomelessPersonTable.setQ26cMaleWithOnlyChild(BigInteger.valueOf(0));
		q26cGenderOfChronicallyHomelessPersonTable.setQ26cMaleUnknownHouseholdType(BigInteger.valueOf(0));

		q26cGenderOfChronicallyHomelessPersonTable.setQ26cFemaleTotal(BigInteger.valueOf(0));
		q26cGenderOfChronicallyHomelessPersonTable.setQ26cFemaleWithoutChild(BigInteger.valueOf(0));
		q26cGenderOfChronicallyHomelessPersonTable.setQ26cFemaleWithChildAndAdults(BigInteger.valueOf(0));
		q26cGenderOfChronicallyHomelessPersonTable.setQ26cFemaleWithOnlyChild(BigInteger.valueOf(0));
		q26cGenderOfChronicallyHomelessPersonTable.setQ26cFemaleUnknownHouseholdType(BigInteger.valueOf(0));

		q26cGenderOfChronicallyHomelessPersonTable.setQ26cTransgenderMaleToFemaleTotal(BigInteger.valueOf(0));
		q26cGenderOfChronicallyHomelessPersonTable.setQ26cTransgenderMaleToFemaleWithoutChild(BigInteger.valueOf(0));
		q26cGenderOfChronicallyHomelessPersonTable.setQ26cTransgenderMaleToFemaleWithChildAndAdults(BigInteger.valueOf(0));
		q26cGenderOfChronicallyHomelessPersonTable.setQ26cTransgenderMaleToFemaleWithOnlyChild(BigInteger.valueOf(0));
		q26cGenderOfChronicallyHomelessPersonTable.setQ26cTransgenderMaleToFemaleUnknownHouseholdType(BigInteger.valueOf(0));

		q26cGenderOfChronicallyHomelessPersonTable.setQ26cTransgenderFemaleToMaleTotal(BigInteger.valueOf(0));
		q26cGenderOfChronicallyHomelessPersonTable.setQ26cTransgenderFemaleToMaleWithoutChild(BigInteger.valueOf(0));
		q26cGenderOfChronicallyHomelessPersonTable.setQ26cTransgenderFemaleToMaleWithChildAndAdults(BigInteger.valueOf(0));
		q26cGenderOfChronicallyHomelessPersonTable.setQ26cTransgenderFemaleToMaleWithOnlyChild(BigInteger.valueOf(0));
		q26cGenderOfChronicallyHomelessPersonTable.setQ26cTransgenderFemaleToMaleUnknownHouseholdType(BigInteger.valueOf(0));

		q26cGenderOfChronicallyHomelessPersonTable.setQ26cOtherTotal(BigInteger.valueOf(0));
		q26cGenderOfChronicallyHomelessPersonTable.setQ26cOtherWithoutChild(BigInteger.valueOf(0));
		q26cGenderOfChronicallyHomelessPersonTable.setQ26cOtherWithChildAndAdults(BigInteger.valueOf(0));
		q26cGenderOfChronicallyHomelessPersonTable.setQ26cOtherWithOnlyChild(BigInteger.valueOf(0));
		q26cGenderOfChronicallyHomelessPersonTable.setQ26cOtherUnknownHouseholdType(BigInteger.valueOf(0));

		q26cGenderOfChronicallyHomelessPersonTable.setQ26cDKRTotal(BigInteger.valueOf(0));
		q26cGenderOfChronicallyHomelessPersonTable.setQ26cDKRWithoutChild(BigInteger.valueOf(0));
		q26cGenderOfChronicallyHomelessPersonTable.setQ26cDKRWithChildAndAdults(BigInteger.valueOf(0));
		q26cGenderOfChronicallyHomelessPersonTable.setQ26cDKRWithOnlyChild(BigInteger.valueOf(0));
		q26cGenderOfChronicallyHomelessPersonTable.setQ26cDKRUnknownHouseholdType(BigInteger.valueOf(0));

		q26cGenderOfChronicallyHomelessPersonTable.setQ26cInformationMissingTotal(BigInteger.valueOf(0));
		q26cGenderOfChronicallyHomelessPersonTable.setQ26cInformationMissingWithoutChild(BigInteger.valueOf(0));
		q26cGenderOfChronicallyHomelessPersonTable.setQ26cInformationMissingWithChildAndAdults(BigInteger.valueOf(0));
		q26cGenderOfChronicallyHomelessPersonTable.setQ26cInformationMissingWithOnlyChild(BigInteger.valueOf(0));
		q26cGenderOfChronicallyHomelessPersonTable.setQ26cInformationMissingUnknownHouseholdType(BigInteger.valueOf(0));

		q26cGenderOfChronicallyHomelessPersonTable.setQ26cSubtotalTotal(BigInteger.valueOf(0));
		q26cGenderOfChronicallyHomelessPersonTable.setQ26cSubtotalWithoutChild(BigInteger.valueOf(0));
		q26cGenderOfChronicallyHomelessPersonTable.setQ26cSubtotalWithChildAndAdults(BigInteger.valueOf(0));
		q26cGenderOfChronicallyHomelessPersonTable.setQ26cSubtotalWithOnlyChild(BigInteger.valueOf(0));
		q26cGenderOfChronicallyHomelessPersonTable.setQ26cSubtotalUnknownHouseholdType(BigInteger.valueOf(0));


		    return q26cGenderOfChronicallyHomelessPersonTable;
	}

	public static DataBean getQ26dAgeOfChronicallyHomelessPersonsList(
			BigInteger q26d0To17Total,
			BigInteger q26d0To17WithoutChild,
			BigInteger q26d0To17WithChildAndAdults,
			BigInteger q26d0To17WithOnlyChild,
			BigInteger q26d0To17UnknownHouseholdType,
					
			BigInteger q26d18To24Total,
			BigInteger q26d18To24WithoutChild,
			BigInteger q26d18To24WithChildAndAdults,
			BigInteger q26d18To24WithOnlyChild,
			BigInteger q26d18To24UnknownHouseholdType,
					
			BigInteger q26d25To34Total,
			BigInteger q26d25To34WithoutChild,
			BigInteger q26d25To34WithChildAndAdults,
			BigInteger q26d25To34WithOnlyChild,
			BigInteger q26d25To34UnknownHouseholdType,
					
			BigInteger q26d35To44Total,
			BigInteger q26d35To44WithoutChild,
			BigInteger q26d35To44WithChildAndAdults,
			BigInteger q26d35To44WithOnlyChild,
			BigInteger q26d35To44UnknownHouseholdType,
					
			BigInteger q26d45To54Total,
			BigInteger q26d45To54WithoutChild,
			BigInteger q26d45To54WithChildAndAdults,
			BigInteger q26d45To54WithOnlyChild,
			BigInteger q26d45To54UnknownHouseholdType,
					
			BigInteger q26d55To61Total,
			BigInteger q26d55To61WithoutChild,
			BigInteger q26d55To61WithChildAndAdults,
			BigInteger q26d55To61WithOnlyChild,
			BigInteger q26d55To61UnknownHouseholdType,
					
			BigInteger q26d62PlusTotal,
			BigInteger q26d62PlusWithoutChild,
			BigInteger q26d62PlusWithChildAndAdults,
			BigInteger q26d62PlusWithOnlyChild,
			BigInteger q26d62PlusUnknownHouseholdType,
					
			BigInteger q26dDKRTotal,
			BigInteger q26dDKRWithoutChild,
			BigInteger q26dDKRWithChildAndAdults,
			BigInteger q26dDKRWithOnlyChild,
			BigInteger q26dDKRUnknownHouseholdType,
					
			BigInteger q26dInformationMissingTotal,
			BigInteger q26dInformationMissingWithoutChild,
			BigInteger q26dInformationMissingWithChildAndAdults,
			BigInteger q26dInformationMissingWithOnlyChild,
			BigInteger q26dInformationMissingUnknownHouseholdType,
					
			BigInteger q26dSubtotalTotal,
			BigInteger q26dSubtotalWithoutChild,
			BigInteger q26dSubtotalWithChildAndAdults,
			BigInteger q26dSubtotalWithOnlyChild,
			BigInteger q26dSubtotalUnknownHouseholdType,
				
			DataBean q26dAgeOfChronicallyHomelessPersonsTable) {
			
		q26dAgeOfChronicallyHomelessPersonsTable.setQ26d0To17Total(BigInteger.valueOf(0));
		q26dAgeOfChronicallyHomelessPersonsTable.setQ26d0To17WithoutChild(BigInteger.valueOf(0));
		q26dAgeOfChronicallyHomelessPersonsTable.setQ26d0To17WithChildAndAdults(BigInteger.valueOf(0));
		q26dAgeOfChronicallyHomelessPersonsTable.setQ26d0To17WithOnlyChild(BigInteger.valueOf(0));
		q26dAgeOfChronicallyHomelessPersonsTable.setQ26d0To17UnknownHouseholdType(BigInteger.valueOf(0));

		q26dAgeOfChronicallyHomelessPersonsTable.setQ26d18To24Total(BigInteger.valueOf(0));
		q26dAgeOfChronicallyHomelessPersonsTable.setQ26d18To24WithoutChild(BigInteger.valueOf(0));
		q26dAgeOfChronicallyHomelessPersonsTable.setQ26d18To24WithChildAndAdults(BigInteger.valueOf(0));
		q26dAgeOfChronicallyHomelessPersonsTable.setQ26d18To24WithOnlyChild(BigInteger.valueOf(0));
		q26dAgeOfChronicallyHomelessPersonsTable.setQ26d18To24UnknownHouseholdType(BigInteger.valueOf(0));

		q26dAgeOfChronicallyHomelessPersonsTable.setQ26d25To34Total(BigInteger.valueOf(0));
		q26dAgeOfChronicallyHomelessPersonsTable.setQ26d25To34WithoutChild(BigInteger.valueOf(0));
		q26dAgeOfChronicallyHomelessPersonsTable.setQ26d25To34WithChildAndAdults(BigInteger.valueOf(0));
		q26dAgeOfChronicallyHomelessPersonsTable.setQ26d25To34WithOnlyChild(BigInteger.valueOf(0));
		q26dAgeOfChronicallyHomelessPersonsTable.setQ26d25To34UnknownHouseholdType(BigInteger.valueOf(0));

		q26dAgeOfChronicallyHomelessPersonsTable.setQ26d35To44Total(BigInteger.valueOf(0));
		q26dAgeOfChronicallyHomelessPersonsTable.setQ26d35To44WithoutChild(BigInteger.valueOf(0));
		q26dAgeOfChronicallyHomelessPersonsTable.setQ26d35To44WithChildAndAdults(BigInteger.valueOf(0));
		q26dAgeOfChronicallyHomelessPersonsTable.setQ26d35To44WithOnlyChild(BigInteger.valueOf(0));
		q26dAgeOfChronicallyHomelessPersonsTable.setQ26d35To44UnknownHouseholdType(BigInteger.valueOf(0));

		q26dAgeOfChronicallyHomelessPersonsTable.setQ26d45To54Total(BigInteger.valueOf(0));
		q26dAgeOfChronicallyHomelessPersonsTable.setQ26d45To54WithoutChild(BigInteger.valueOf(0));
		q26dAgeOfChronicallyHomelessPersonsTable.setQ26d45To54WithChildAndAdults(BigInteger.valueOf(0));
		q26dAgeOfChronicallyHomelessPersonsTable.setQ26d45To54WithOnlyChild(BigInteger.valueOf(0));
		q26dAgeOfChronicallyHomelessPersonsTable.setQ26d45To54UnknownHouseholdType(BigInteger.valueOf(0));

		q26dAgeOfChronicallyHomelessPersonsTable.setQ26d55To61Total(BigInteger.valueOf(0));
		q26dAgeOfChronicallyHomelessPersonsTable.setQ26d55To61WithoutChild(BigInteger.valueOf(0));
		q26dAgeOfChronicallyHomelessPersonsTable.setQ26d55To61WithChildAndAdults(BigInteger.valueOf(0));
		q26dAgeOfChronicallyHomelessPersonsTable.setQ26d55To61WithOnlyChild(BigInteger.valueOf(0));
		q26dAgeOfChronicallyHomelessPersonsTable.setQ26d55To61UnknownHouseholdType(BigInteger.valueOf(0));

		q26dAgeOfChronicallyHomelessPersonsTable.setQ26d62PlusTotal(BigInteger.valueOf(0));
		q26dAgeOfChronicallyHomelessPersonsTable.setQ26d62PlusWithoutChild(BigInteger.valueOf(0));
		q26dAgeOfChronicallyHomelessPersonsTable.setQ26d62PlusWithChildAndAdults(BigInteger.valueOf(0));
		q26dAgeOfChronicallyHomelessPersonsTable.setQ26d62PlusWithOnlyChild(BigInteger.valueOf(0));
		q26dAgeOfChronicallyHomelessPersonsTable.setQ26d62PlusUnknownHouseholdType(BigInteger.valueOf(0));

		q26dAgeOfChronicallyHomelessPersonsTable.setQ26dDKRTotal(BigInteger.valueOf(0));
		q26dAgeOfChronicallyHomelessPersonsTable.setQ26dDKRWithoutChild(BigInteger.valueOf(0));
		q26dAgeOfChronicallyHomelessPersonsTable.setQ26dDKRWithChildAndAdults(BigInteger.valueOf(0));
		q26dAgeOfChronicallyHomelessPersonsTable.setQ26dDKRWithOnlyChild(BigInteger.valueOf(0));
		q26dAgeOfChronicallyHomelessPersonsTable.setQ26dDKRUnknownHouseholdType(BigInteger.valueOf(0));

		q26dAgeOfChronicallyHomelessPersonsTable.setQ26dInformationMissingTotal(BigInteger.valueOf(0));
		q26dAgeOfChronicallyHomelessPersonsTable.setQ26dInformationMissingWithoutChild(BigInteger.valueOf(0));
		q26dAgeOfChronicallyHomelessPersonsTable.setQ26dInformationMissingWithChildAndAdults(BigInteger.valueOf(0));
		q26dAgeOfChronicallyHomelessPersonsTable.setQ26dInformationMissingWithOnlyChild(BigInteger.valueOf(0));
		q26dAgeOfChronicallyHomelessPersonsTable.setQ26dInformationMissingUnknownHouseholdType(BigInteger.valueOf(0));

		q26dAgeOfChronicallyHomelessPersonsTable.setQ26dSubtotalTotal(BigInteger.valueOf(0));
		q26dAgeOfChronicallyHomelessPersonsTable.setQ26dSubtotalWithoutChild(BigInteger.valueOf(0));
		q26dAgeOfChronicallyHomelessPersonsTable.setQ26dSubtotalWithChildAndAdults(BigInteger.valueOf(0));
		q26dAgeOfChronicallyHomelessPersonsTable.setQ26dSubtotalWithOnlyChild(BigInteger.valueOf(0));
		q26dAgeOfChronicallyHomelessPersonsTable.setQ26dSubtotalUnknownHouseholdType(BigInteger.valueOf(0));



		    return q26dAgeOfChronicallyHomelessPersonsTable;
	}

	
	public static DataBean getQ26ePhysicalAndMentalHealthConditionsChronicallyList(
			BigInteger q26eMentalIllnessAtEntry,
			BigInteger q26eMentalIllnessStayers,
			BigInteger q26eMentalIllnessLeavers,
					
			BigInteger q26eAlcoholAbuseAtEntry,
			BigInteger q26eAlcoholAbuseStayers,
			BigInteger q26eAlcoholAbuseLeavers,
					
			BigInteger q26eDrugAbuseAtEntry,
			BigInteger q26eDrugAbuseStayers,
			BigInteger q26eDrugAbuseLeavers,
					
			BigInteger q26eBothAlcoholAndDrugAbuseAtEntry,
			BigInteger q26eBothAlcoholAndDrugAbuseStayers,
			BigInteger q26eBothAlcoholAndDrugAbuseLeavers,
					
			BigInteger q26eChronicHealthConditionAtEntry,
			BigInteger q26eChronicHealthConditionStayers,
			BigInteger q26eChronicHealthConditionLeavers,
					
			BigInteger q26eHIVAIDSAndRelatedDiseasesAtEntry,
			BigInteger q26eHIVAIDSAndRelatedDiseasesStayers,
			BigInteger q26eHIVAIDSAndRelatedDiseasesLeavers,
					
			BigInteger q26eDevelopmentalDisabilityAtEntry,
			BigInteger q26eDevelopmentalDisabilityStayers,
			BigInteger q26eDevelopmentalDisabilityLeavers,
					
			BigInteger q26ePhysicalDisabilityAtEntry,
			BigInteger q26ePhysicalDisabilityStayers,
			BigInteger q26ePhysicalDisabilityLeavers,
				
			
						DataBean q26ePhysicalAndMentalHealthConditionsChronicallyTable) {
			
		q26ePhysicalAndMentalHealthConditionsChronicallyTable.setQ26eMentalIllnessAtEntry(BigInteger.valueOf(0));
		q26ePhysicalAndMentalHealthConditionsChronicallyTable.setQ26eMentalIllnessStayers(BigInteger.valueOf(0));
		q26ePhysicalAndMentalHealthConditionsChronicallyTable.setQ26eMentalIllnessLeavers(BigInteger.valueOf(0));

		q26ePhysicalAndMentalHealthConditionsChronicallyTable.setQ26eAlcoholAbuseAtEntry(BigInteger.valueOf(0));
		q26ePhysicalAndMentalHealthConditionsChronicallyTable.setQ26eAlcoholAbuseStayers(BigInteger.valueOf(0));
		q26ePhysicalAndMentalHealthConditionsChronicallyTable.setQ26eAlcoholAbuseLeavers(BigInteger.valueOf(0));

		q26ePhysicalAndMentalHealthConditionsChronicallyTable.setQ26eDrugAbuseAtEntry(BigInteger.valueOf(0));
		q26ePhysicalAndMentalHealthConditionsChronicallyTable.setQ26eDrugAbuseStayers(BigInteger.valueOf(0));
		q26ePhysicalAndMentalHealthConditionsChronicallyTable.setQ26eDrugAbuseLeavers(BigInteger.valueOf(0));

		q26ePhysicalAndMentalHealthConditionsChronicallyTable.setQ26eBothAlcoholAndDrugAbuseAtEntry(BigInteger.valueOf(0));
		q26ePhysicalAndMentalHealthConditionsChronicallyTable.setQ26eBothAlcoholAndDrugAbuseStayers(BigInteger.valueOf(0));
		q26ePhysicalAndMentalHealthConditionsChronicallyTable.setQ26eBothAlcoholAndDrugAbuseLeavers(BigInteger.valueOf(0));

		q26ePhysicalAndMentalHealthConditionsChronicallyTable.setQ26eChronicHealthConditionAtEntry(BigInteger.valueOf(0));
		q26ePhysicalAndMentalHealthConditionsChronicallyTable.setQ26eChronicHealthConditionStayers(BigInteger.valueOf(0));
		q26ePhysicalAndMentalHealthConditionsChronicallyTable.setQ26eChronicHealthConditionLeavers(BigInteger.valueOf(0));

		q26ePhysicalAndMentalHealthConditionsChronicallyTable.setQ26eHIVAIDSAndRelatedDiseasesAtEntry(BigInteger.valueOf(0));
		q26ePhysicalAndMentalHealthConditionsChronicallyTable.setQ26eHIVAIDSAndRelatedDiseasesStayers(BigInteger.valueOf(0));
		q26ePhysicalAndMentalHealthConditionsChronicallyTable.setQ26eHIVAIDSAndRelatedDiseasesLeavers(BigInteger.valueOf(0));

		q26ePhysicalAndMentalHealthConditionsChronicallyTable.setQ26eDevelopmentalDisabilityAtEntry(BigInteger.valueOf(0));
		q26ePhysicalAndMentalHealthConditionsChronicallyTable.setQ26eDevelopmentalDisabilityStayers(BigInteger.valueOf(0));
		q26ePhysicalAndMentalHealthConditionsChronicallyTable.setQ26eDevelopmentalDisabilityLeavers(BigInteger.valueOf(0));

		q26ePhysicalAndMentalHealthConditionsChronicallyTable.setQ26ePhysicalDisabilityAtEntry(BigInteger.valueOf(0));
		q26ePhysicalAndMentalHealthConditionsChronicallyTable.setQ26ePhysicalDisabilityStayers(BigInteger.valueOf(0));
		q26ePhysicalAndMentalHealthConditionsChronicallyTable.setQ26ePhysicalDisabilityLeavers(BigInteger.valueOf(0));



		    return q26ePhysicalAndMentalHealthConditionsChronicallyTable;
	}

	public static DataBean getQ26fClientCashIncomeChronicallyHomelessPersonsList(
			BigInteger q26fAdultsWithOnlyEarnedIncomeAtEntry,
			BigInteger q26fAdultsWithOnlyEarnedIncomeStayers,
			BigInteger q26fAdultsWithOnlyEarnedIncomeLeavers,
					
			BigInteger q26fAdultsWithOnlyOtherIncomeAtEntry,
			BigInteger q26fAdultsWithOnlyOtherIncomeStayers,
			BigInteger q26fAdultsWithOnlyOtherIncomeLeavers,
					
			BigInteger q26fAdultsWithBothEarnedAndOtherIncomeAtEntry,
			BigInteger q26fAdultsWithBothEarnedAndOtherIncomeStayers,
			BigInteger q26fAdultsWithBothEarnedAndOtherIncomeLeavers,
					
			BigInteger q26fAdultsWithNoIncomeAtEntry,
			BigInteger q26fAdultsWithNoIncomeStayers,
			BigInteger q26fAdultsWithNoIncomeLeavers,
					
			BigInteger q26fAdultsWithDontRefusedIncomeAtEntry,
			BigInteger q26fAdultsWithDontRefusedIncomeStayers,
			BigInteger q26fAdultsWithDontRefusedIncomeLeavers,
					
			BigInteger q26fAdultsWithMissingIncomeInfoAtEntry,
			BigInteger q26fAdultsWithMissingIncomeInfoStayers,
			BigInteger q26fAdultsWithMissingIncomeInfoLeavers,
					
			BigInteger q26fNumberOfAdultStayersNotYetRequiredAtEntry,
			BigInteger q26fNumberOfAdultStayersNotYetRequiredStayers,
			BigInteger q26fNumberOfAdultStayersNotYetRequiredLeavers,
					
			BigInteger q26fNumberOfAdultStayersWithoutRequiredAtEntry,
			BigInteger q26fNumberOfAdultStayersWithoutRequiredStayers,
			BigInteger q26fNumberOfAdultStayersWithoutRequiredLeavers,
					
			BigInteger q26fTotalAdultsAtEntry,
			BigInteger q26fTotalAdultsStayers,
			BigInteger q26fTotalAdultsLeavers,
					
			DataBean q26fClientCashIncomeChronicallyHomelessPersonsTable) {

		q26fClientCashIncomeChronicallyHomelessPersonsTable.setQ26fAdultsWithOnlyEarnedIncomeAtEntry(BigInteger.valueOf(0));
		q26fClientCashIncomeChronicallyHomelessPersonsTable.setQ26fAdultsWithOnlyEarnedIncomeStayers(BigInteger.valueOf(0));
		q26fClientCashIncomeChronicallyHomelessPersonsTable.setQ26fAdultsWithOnlyEarnedIncomeLeavers(BigInteger.valueOf(0));

		q26fClientCashIncomeChronicallyHomelessPersonsTable.setQ26fAdultsWithOnlyOtherIncomeAtEntry(BigInteger.valueOf(0));
		q26fClientCashIncomeChronicallyHomelessPersonsTable.setQ26fAdultsWithOnlyOtherIncomeStayers(BigInteger.valueOf(0));
		q26fClientCashIncomeChronicallyHomelessPersonsTable.setQ26fAdultsWithOnlyOtherIncomeLeavers(BigInteger.valueOf(0));

		q26fClientCashIncomeChronicallyHomelessPersonsTable.setQ26fAdultsWithBothEarnedAndOtherIncomeAtEntry(BigInteger.valueOf(0));
		q26fClientCashIncomeChronicallyHomelessPersonsTable.setQ26fAdultsWithBothEarnedAndOtherIncomeStayers(BigInteger.valueOf(0));
		q26fClientCashIncomeChronicallyHomelessPersonsTable.setQ26fAdultsWithBothEarnedAndOtherIncomeLeavers(BigInteger.valueOf(0));

		q26fClientCashIncomeChronicallyHomelessPersonsTable.setQ26fAdultsWithNoIncomeAtEntry(BigInteger.valueOf(0));
		q26fClientCashIncomeChronicallyHomelessPersonsTable.setQ26fAdultsWithNoIncomeStayers(BigInteger.valueOf(0));
		q26fClientCashIncomeChronicallyHomelessPersonsTable.setQ26fAdultsWithNoIncomeLeavers(BigInteger.valueOf(0));

		q26fClientCashIncomeChronicallyHomelessPersonsTable.setQ26fAdultsWithDontRefusedIncomeAtEntry(BigInteger.valueOf(0));
		q26fClientCashIncomeChronicallyHomelessPersonsTable.setQ26fAdultsWithDontRefusedIncomeStayers(BigInteger.valueOf(0));
		q26fClientCashIncomeChronicallyHomelessPersonsTable.setQ26fAdultsWithDontRefusedIncomeLeavers(BigInteger.valueOf(0));

		q26fClientCashIncomeChronicallyHomelessPersonsTable.setQ26fAdultsWithMissingIncomeInfoAtEntry(BigInteger.valueOf(0));
		q26fClientCashIncomeChronicallyHomelessPersonsTable.setQ26fAdultsWithMissingIncomeInfoStayers(BigInteger.valueOf(0));
		q26fClientCashIncomeChronicallyHomelessPersonsTable.setQ26fAdultsWithMissingIncomeInfoLeavers(BigInteger.valueOf(0));

		q26fClientCashIncomeChronicallyHomelessPersonsTable.setQ26fNumberOfAdultStayersNotYetRequiredAtEntry(BigInteger.valueOf(0));
		q26fClientCashIncomeChronicallyHomelessPersonsTable.setQ26fNumberOfAdultStayersNotYetRequiredStayers(BigInteger.valueOf(0));
		q26fClientCashIncomeChronicallyHomelessPersonsTable.setQ26fNumberOfAdultStayersNotYetRequiredLeavers(BigInteger.valueOf(0));

		q26fClientCashIncomeChronicallyHomelessPersonsTable.setQ26fNumberOfAdultStayersWithoutRequiredAtEntry(BigInteger.valueOf(0));
		q26fClientCashIncomeChronicallyHomelessPersonsTable.setQ26fNumberOfAdultStayersWithoutRequiredStayers(BigInteger.valueOf(0));
		q26fClientCashIncomeChronicallyHomelessPersonsTable.setQ26fNumberOfAdultStayersWithoutRequiredLeavers(BigInteger.valueOf(0));

		q26fClientCashIncomeChronicallyHomelessPersonsTable.setQ26fTotalAdultsAtEntry(BigInteger.valueOf(0));
		q26fClientCashIncomeChronicallyHomelessPersonsTable.setQ26fTotalAdultsStayers(BigInteger.valueOf(0));
		q26fClientCashIncomeChronicallyHomelessPersonsTable.setQ26fTotalAdultsLeavers(BigInteger.valueOf(0));

		return q26fClientCashIncomeChronicallyHomelessPersonsTable;
	}

	public static DataBean getQ26gTypeOfCashIncomeSourcesChronicallyHomelessList(
			BigInteger q26gEarnedIncomeAtEntry,
			BigInteger q26gEarnedIncomeStayers,
			BigInteger q26gEarnedIncomeLeavers,
					
			BigInteger q26gUnemploymentInsuranceAtEntry,
			BigInteger q26gUnemploymentInsuranceStayers,
			BigInteger q26gUnemploymentInsuranceLeavers,
					
			BigInteger q26gSSIAtEntry,
			BigInteger q26gSSIStayers,
			BigInteger q26gSSILeavers,
					
			BigInteger q26gSSDIAtEntry,
			BigInteger q26gSSDIStayers,
			BigInteger q26gSSDILeavers,
					
			BigInteger q26gVAServiceConnectedDisabilityAtEntry,
			BigInteger q26gVAServiceConnectedDisabilityStayers,
			BigInteger q26gVAServiceConnectedDisabilityLeavers,
					
			BigInteger q26gVANonServiceConnectedDisabilityAtEntry,
			BigInteger q26gVANonServiceConnectedDisabilityStayers,
			BigInteger q26gVANonServiceConnectedDisabilityLeavers,
					
			BigInteger q26gPrivateDisabilityInsuranceAtEntry,
			BigInteger q26gPrivateDisabilityInsuranceStayers,
			BigInteger q26gPrivateDisabilityInsuranceLeavers,
					
			BigInteger q26gWorkerCompensationAtEntry,
			BigInteger q26gWorkerCompensationStayers,
			BigInteger q26gWorkerCompensationLeavers,
					
			BigInteger q26gTANFAtEntry,
			BigInteger q26gTANFStayers,
			BigInteger q26gTANFLeavers,
					
			BigInteger q26gGeneralAssistanceAtEntry,
			BigInteger q26gGeneralAssistanceStayers,
			BigInteger q26gGeneralAssistanceLeavers,
					
			BigInteger q26gRetirementAtEntry,
			BigInteger q26gRetirementStayers,
			BigInteger q26gRetirementLeavers,
					
			BigInteger q26gPensionFromFormerJobAtEntry,
			BigInteger q26gPensionFromFormerJobStayers,
			BigInteger q26gPensionFromFormerJobLeavers,
					
			BigInteger q26gChildSupportAtEntry,
			BigInteger q26gChildSupportStayers,
			BigInteger q26gChildSupportLeavers,
					
			BigInteger q26gAlimonyAtEntry,
			BigInteger q26gAlimonyStayers,
			BigInteger q26gAlimonyLeavers,
					
			BigInteger q26gOtherSourceAtEntry,
			BigInteger q26gOtherSourceStayers,
			BigInteger q26gOtherSourceLeavers,
					
			BigInteger q26gAdultsWithIncomeInfoAtEntry,
			BigInteger q26gAdultsWithIncomeInfoStayers,
			BigInteger q26gAdultsWithIncomeInfoLeavers,
				
					
			DataBean q26gTypeOfCashIncomeSourcesChronicallyHomelessTable) {
		q26gTypeOfCashIncomeSourcesChronicallyHomelessTable.setQ26gEarnedIncomeAtEntry(BigInteger.valueOf(0));
		q26gTypeOfCashIncomeSourcesChronicallyHomelessTable.setQ26gEarnedIncomeStayers(BigInteger.valueOf(0));
		q26gTypeOfCashIncomeSourcesChronicallyHomelessTable.setQ26gEarnedIncomeLeavers(BigInteger.valueOf(0));

		q26gTypeOfCashIncomeSourcesChronicallyHomelessTable.setQ26gUnemploymentInsuranceAtEntry(BigInteger.valueOf(0));
		q26gTypeOfCashIncomeSourcesChronicallyHomelessTable.setQ26gUnemploymentInsuranceStayers(BigInteger.valueOf(0));
		q26gTypeOfCashIncomeSourcesChronicallyHomelessTable.setQ26gUnemploymentInsuranceLeavers(BigInteger.valueOf(0));

		q26gTypeOfCashIncomeSourcesChronicallyHomelessTable.setQ26gSSIAtEntry(BigInteger.valueOf(0));
		q26gTypeOfCashIncomeSourcesChronicallyHomelessTable.setQ26gSSIStayers(BigInteger.valueOf(0));
		q26gTypeOfCashIncomeSourcesChronicallyHomelessTable.setQ26gSSILeavers(BigInteger.valueOf(0));

		q26gTypeOfCashIncomeSourcesChronicallyHomelessTable.setQ26gSSDIAtEntry(BigInteger.valueOf(0));
		q26gTypeOfCashIncomeSourcesChronicallyHomelessTable.setQ26gSSDIStayers(BigInteger.valueOf(0));
		q26gTypeOfCashIncomeSourcesChronicallyHomelessTable.setQ26gSSDILeavers(BigInteger.valueOf(0));

		q26gTypeOfCashIncomeSourcesChronicallyHomelessTable.setQ26gVAServiceConnectedDisabilityAtEntry(BigInteger.valueOf(0));
		q26gTypeOfCashIncomeSourcesChronicallyHomelessTable.setQ26gVAServiceConnectedDisabilityStayers(BigInteger.valueOf(0));
		q26gTypeOfCashIncomeSourcesChronicallyHomelessTable.setQ26gVAServiceConnectedDisabilityLeavers(BigInteger.valueOf(0));

		q26gTypeOfCashIncomeSourcesChronicallyHomelessTable.setQ26gVANonServiceConnectedDisabilityAtEntry(BigInteger.valueOf(0));
		q26gTypeOfCashIncomeSourcesChronicallyHomelessTable.setQ26gVANonServiceConnectedDisabilityStayers(BigInteger.valueOf(0));
		q26gTypeOfCashIncomeSourcesChronicallyHomelessTable.setQ26gVANonServiceConnectedDisabilityLeavers(BigInteger.valueOf(0));

		q26gTypeOfCashIncomeSourcesChronicallyHomelessTable.setQ26gPrivateDisabilityInsuranceAtEntry(BigInteger.valueOf(0));
		q26gTypeOfCashIncomeSourcesChronicallyHomelessTable.setQ26gPrivateDisabilityInsuranceStayers(BigInteger.valueOf(0));
		q26gTypeOfCashIncomeSourcesChronicallyHomelessTable.setQ26gPrivateDisabilityInsuranceLeavers(BigInteger.valueOf(0));

		q26gTypeOfCashIncomeSourcesChronicallyHomelessTable.setQ26gWorkerCompensationAtEntry(BigInteger.valueOf(0));
		q26gTypeOfCashIncomeSourcesChronicallyHomelessTable.setQ26gWorkerCompensationStayers(BigInteger.valueOf(0));
		q26gTypeOfCashIncomeSourcesChronicallyHomelessTable.setQ26gWorkerCompensationLeavers(BigInteger.valueOf(0));

		q26gTypeOfCashIncomeSourcesChronicallyHomelessTable.setQ26gTANFAtEntry(BigInteger.valueOf(0));
		q26gTypeOfCashIncomeSourcesChronicallyHomelessTable.setQ26gTANFStayers(BigInteger.valueOf(0));
		q26gTypeOfCashIncomeSourcesChronicallyHomelessTable.setQ26gTANFLeavers(BigInteger.valueOf(0));

		q26gTypeOfCashIncomeSourcesChronicallyHomelessTable.setQ26gGeneralAssistanceAtEntry(BigInteger.valueOf(0));
		q26gTypeOfCashIncomeSourcesChronicallyHomelessTable.setQ26gGeneralAssistanceStayers(BigInteger.valueOf(0));
		q26gTypeOfCashIncomeSourcesChronicallyHomelessTable.setQ26gGeneralAssistanceLeavers(BigInteger.valueOf(0));

		q26gTypeOfCashIncomeSourcesChronicallyHomelessTable.setQ26gRetirementAtEntry(BigInteger.valueOf(0));
		q26gTypeOfCashIncomeSourcesChronicallyHomelessTable.setQ26gRetirementStayers(BigInteger.valueOf(0));
		q26gTypeOfCashIncomeSourcesChronicallyHomelessTable.setQ26gRetirementLeavers(BigInteger.valueOf(0));

		q26gTypeOfCashIncomeSourcesChronicallyHomelessTable.setQ26gPensionFromFormerJobAtEntry(BigInteger.valueOf(0));
		q26gTypeOfCashIncomeSourcesChronicallyHomelessTable.setQ26gPensionFromFormerJobStayers(BigInteger.valueOf(0));
		q26gTypeOfCashIncomeSourcesChronicallyHomelessTable.setQ26gPensionFromFormerJobLeavers(BigInteger.valueOf(0));

		q26gTypeOfCashIncomeSourcesChronicallyHomelessTable.setQ26gChildSupportAtEntry(BigInteger.valueOf(0));
		q26gTypeOfCashIncomeSourcesChronicallyHomelessTable.setQ26gChildSupportStayers(BigInteger.valueOf(0));
		q26gTypeOfCashIncomeSourcesChronicallyHomelessTable.setQ26gChildSupportLeavers(BigInteger.valueOf(0));

		q26gTypeOfCashIncomeSourcesChronicallyHomelessTable.setQ26gAlimonyAtEntry(BigInteger.valueOf(0));
		q26gTypeOfCashIncomeSourcesChronicallyHomelessTable.setQ26gAlimonyStayers(BigInteger.valueOf(0));
		q26gTypeOfCashIncomeSourcesChronicallyHomelessTable.setQ26gAlimonyLeavers(BigInteger.valueOf(0));

		q26gTypeOfCashIncomeSourcesChronicallyHomelessTable.setQ26gOtherSourceAtEntry(BigInteger.valueOf(0));
		q26gTypeOfCashIncomeSourcesChronicallyHomelessTable.setQ26gOtherSourceStayers(BigInteger.valueOf(0));
		q26gTypeOfCashIncomeSourcesChronicallyHomelessTable.setQ26gOtherSourceLeavers(BigInteger.valueOf(0));

		q26gTypeOfCashIncomeSourcesChronicallyHomelessTable.setQ26gAdultsWithIncomeInfoAtEntry(BigInteger.valueOf(0));
		q26gTypeOfCashIncomeSourcesChronicallyHomelessTable.setQ26gAdultsWithIncomeInfoStayers(BigInteger.valueOf(0));
		q26gTypeOfCashIncomeSourcesChronicallyHomelessTable.setQ26gAdultsWithIncomeInfoLeavers(BigInteger.valueOf(0));
			


		return q26gTypeOfCashIncomeSourcesChronicallyHomelessTable;
	}

	

	public static DataBean getQ26hTypeOfNonCashIncomeSourcesChronicallyHomelessList(
			BigInteger q26hSupplementalNutritionalATANFChildCareServicesstanceAtEntry,
			BigInteger q26hSupplementalNutritionalATANFChildCareServicesstanceStayers,
			BigInteger q26hSupplementalNutritionalATANFChildCareServicesstanceLeavers,
					
			BigInteger q26hWICAtEntry,
			BigInteger q26hWICStayers,
			BigInteger q26hWICLeavers,
					
			BigInteger q26hTANFChildCareServicesAtEntry,
			BigInteger q26hTANFChildCareServicesStayers,
			BigInteger q26hTANFChildCareServicesLeavers,
					
			BigInteger q26hTANFTransportationServicesAtEntry,
			BigInteger q26hTANFTransportationServicesStayers,
			BigInteger q26hTANFTransportationServicesLeavers,
					
			BigInteger q26hOtherTANFFundedServicesAtEntry,
			BigInteger q26hOtherTANFFundedServicesStayers,
			BigInteger q26hOtherTANFFundedServicesLeavers,
					
			BigInteger q26hOtherSourceAtEntry,
			BigInteger q26hOtherSourceStayers,
			BigInteger q26hOtherSourceLeavers,
					
			DataBean q26hTypeOfNonCashIncomeSourcesChronicallyHomelessTable) {
		q26hTypeOfNonCashIncomeSourcesChronicallyHomelessTable.setQ26hSupplementalNutritionalATANFChildCareServicesstanceAtEntry(BigInteger.valueOf(0));
		q26hTypeOfNonCashIncomeSourcesChronicallyHomelessTable.setQ26hSupplementalNutritionalATANFChildCareServicesstanceStayers(BigInteger.valueOf(0));
		q26hTypeOfNonCashIncomeSourcesChronicallyHomelessTable.setQ26hSupplementalNutritionalATANFChildCareServicesstanceLeavers(BigInteger.valueOf(0));

		q26hTypeOfNonCashIncomeSourcesChronicallyHomelessTable.setQ26hWICAtEntry(BigInteger.valueOf(0));
		q26hTypeOfNonCashIncomeSourcesChronicallyHomelessTable.setQ26hWICStayers(BigInteger.valueOf(0));
		q26hTypeOfNonCashIncomeSourcesChronicallyHomelessTable.setQ26hWICLeavers(BigInteger.valueOf(0));

		q26hTypeOfNonCashIncomeSourcesChronicallyHomelessTable.setQ26hTANFChildCareServicesAtEntry(BigInteger.valueOf(0));
		q26hTypeOfNonCashIncomeSourcesChronicallyHomelessTable.setQ26hTANFChildCareServicesStayers(BigInteger.valueOf(0));
		q26hTypeOfNonCashIncomeSourcesChronicallyHomelessTable.setQ26hTANFChildCareServicesLeavers(BigInteger.valueOf(0));

		q26hTypeOfNonCashIncomeSourcesChronicallyHomelessTable.setQ26hTANFTransportationServicesAtEntry(BigInteger.valueOf(0));
		q26hTypeOfNonCashIncomeSourcesChronicallyHomelessTable.setQ26hTANFTransportationServicesStayers(BigInteger.valueOf(0));
		q26hTypeOfNonCashIncomeSourcesChronicallyHomelessTable.setQ26hTANFTransportationServicesLeavers(BigInteger.valueOf(0));

		q26hTypeOfNonCashIncomeSourcesChronicallyHomelessTable.setQ26hOtherTANFFundedServicesAtEntry(BigInteger.valueOf(0));
		q26hTypeOfNonCashIncomeSourcesChronicallyHomelessTable.setQ26hOtherTANFFundedServicesStayers(BigInteger.valueOf(0));
		q26hTypeOfNonCashIncomeSourcesChronicallyHomelessTable.setQ26hOtherTANFFundedServicesLeavers(BigInteger.valueOf(0));

		q26hTypeOfNonCashIncomeSourcesChronicallyHomelessTable.setQ26hOtherSourceAtEntry(BigInteger.valueOf(0));
		q26hTypeOfNonCashIncomeSourcesChronicallyHomelessTable.setQ26hOtherSourceStayers(BigInteger.valueOf(0));
		q26hTypeOfNonCashIncomeSourcesChronicallyHomelessTable.setQ26hOtherSourceLeavers(BigInteger.valueOf(0));
		return q26hTypeOfNonCashIncomeSourcesChronicallyHomelessTable;
	}

	public static DataBean getQ27aAgeOfYouthList(
			BigInteger q27a12To17Total,
			BigInteger q27a12To17WithoutChild,
			BigInteger q27a12To17WithChildAndAdults,
			BigInteger q27a12To17WithChildOnly,
			BigInteger q27a12To17UnknownHouseHoldtype,
					
			BigInteger q27a18To24Total,
			BigInteger q27a18To24WithoutChild,
			BigInteger q27a18To24WithChildAndAdults,
			BigInteger q27a18To24WithChildOnly,
			BigInteger q27a18To24UnknownHouseHoldtype,
					
			BigInteger q27aDKRTotal,
			BigInteger q27aDKRWithoutChild,
			BigInteger q27aDKRWithChildAndAdults,
			BigInteger q27aDKRWithChildOnly,
			BigInteger q27aDKRUnknownHouseHoldtype,
					
			BigInteger q27aInformationMissingTotal,
			BigInteger q27aInformationMissingWithoutChild,
			BigInteger q27aInformationMissingWithChildAndAdults,
			BigInteger q27aInformationMissingWithChildOnly,
			BigInteger q27aInformationMissingUnknownHouseHoldtype,
					
			BigInteger q27aTotTotal,
			BigInteger q27aTotWithoutChild,
			BigInteger q27aTotWithChildAndAdults,
			BigInteger q27aTotWithChildOnly,
			BigInteger q27aTotUnknownHouseHoldtype,
			DataBean q27aAgeOfYoutTable) {
		q27aAgeOfYoutTable.setQ27a12To17Total(BigInteger.valueOf(0));
		q27aAgeOfYoutTable.setQ27a12To17WithoutChild(BigInteger.valueOf(0));
		q27aAgeOfYoutTable.setQ27a12To17WithChildAndAdults(BigInteger.valueOf(0));
		q27aAgeOfYoutTable.setQ27a12To17WithChildOnly(BigInteger.valueOf(0));
		q27aAgeOfYoutTable.setQ27a12To17UnknownHouseHoldtype(BigInteger.valueOf(0));

		q27aAgeOfYoutTable.setQ27a18To24Total(BigInteger.valueOf(0));
		q27aAgeOfYoutTable.setQ27a18To24WithoutChild(BigInteger.valueOf(0));
		q27aAgeOfYoutTable.setQ27a18To24WithChildAndAdults(BigInteger.valueOf(0));
		q27aAgeOfYoutTable.setQ27a18To24WithChildOnly(BigInteger.valueOf(0));
		q27aAgeOfYoutTable.setQ27a18To24UnknownHouseHoldtype(BigInteger.valueOf(0));

		q27aAgeOfYoutTable.setQ27aDKRTotal(BigInteger.valueOf(0));
		q27aAgeOfYoutTable.setQ27aDKRWithoutChild(BigInteger.valueOf(0));
		q27aAgeOfYoutTable.setQ27aDKRWithChildAndAdults(BigInteger.valueOf(0));
		q27aAgeOfYoutTable.setQ27aDKRWithChildOnly(BigInteger.valueOf(0));
		q27aAgeOfYoutTable.setQ27aDKRUnknownHouseHoldtype(BigInteger.valueOf(0));

		q27aAgeOfYoutTable.setQ27aInformationMissingTotal(BigInteger.valueOf(0));
		q27aAgeOfYoutTable.setQ27aInformationMissingWithoutChild(BigInteger.valueOf(0));
		q27aAgeOfYoutTable.setQ27aInformationMissingWithChildAndAdults(BigInteger.valueOf(0));
		q27aAgeOfYoutTable.setQ27aInformationMissingWithChildOnly(BigInteger.valueOf(0));
		q27aAgeOfYoutTable.setQ27aInformationMissingUnknownHouseHoldtype(BigInteger.valueOf(0));

		q27aAgeOfYoutTable.setQ27aTotTotal(BigInteger.valueOf(0));
		q27aAgeOfYoutTable.setQ27aTotWithoutChild(BigInteger.valueOf(0));
		q27aAgeOfYoutTable.setQ27aTotWithChildAndAdults(BigInteger.valueOf(0));
		q27aAgeOfYoutTable.setQ27aTotWithChildOnly(BigInteger.valueOf(0));
		q27aAgeOfYoutTable.setQ27aTotUnknownHouseHoldtype(BigInteger.valueOf(0));

		return q27aAgeOfYoutTable;
	}

	public static DataBean getQ27bParentingYouthList(
			BigInteger q27bParentYouthLeassThan18TotalParentingYouth,
			BigInteger q27bParentYouthLeassThan18TotalChildrenOfParentingYouth,
			BigInteger q27bParentYouthLeassThan18TotalPersons,
			BigInteger q27bParentYouthLeassThan18TotalHouseholds,

			BigInteger q27bParentYouth18To24TotalParentingYouth,
			BigInteger q27bParentYouth18To24TotalChildrenOfParentingYouth,
			BigInteger q27bParentYouth18To24TotalPersons,
			BigInteger q27bParentYouth18To24TotalHouseholds,
			DataBean q27bParentingYouthTable) {
		q27bParentingYouthTable.setQ27bParentYouthLeassThan18TotalParentingYouth(BigInteger.valueOf(0));
		q27bParentingYouthTable.setQ27bParentYouthLeassThan18TotalChildrenOfParentingYouth(BigInteger.valueOf(0));
		q27bParentingYouthTable.setQ27bParentYouthLeassThan18TotalPersons(BigInteger.valueOf(0));
		q27bParentingYouthTable.setQ27bParentYouthLeassThan18TotalHouseholds(BigInteger.valueOf(0));

		q27bParentingYouthTable.setQ27bParentYouth18To24TotalParentingYouth(BigInteger.valueOf(0));
		q27bParentingYouthTable.setQ27bParentYouth18To24TotalChildrenOfParentingYouth(BigInteger.valueOf(0));
		q27bParentingYouthTable.setQ27bParentYouth18To24TotalPersons(BigInteger.valueOf(0));
		q27bParentingYouthTable.setQ27bParentYouth18To24TotalHouseholds(BigInteger.valueOf(0));


		return q27bParentingYouthTable;
	}

	public static DataBean getQ27cGenderYouthList(
			BigInteger q27cMaleTotal,
			BigInteger q27cMaleWithoutChild,
			BigInteger q27cMaleWithChildAndAdults,
			BigInteger q27cMaleWithChildOnly,
			BigInteger q27cMaleUnknownHouseHoldtype,

			BigInteger q27cFemaleTotal,
			BigInteger q27cFemaleWithoutChild,
			BigInteger q27cFemaleWithChildAndAdults,
			BigInteger q27cFemaleWithChildOnly,
			BigInteger q27cFemaleUnknownHouseHoldtype,

			BigInteger q27cTransgenderMaleToFemaleTotal,
			BigInteger q27cTransgenderMaleToFemaleWithoutChild,
			BigInteger q27cTransgenderMaleToFemaleWithChildAndAdults,
			BigInteger q27cTransgenderMaleToFemaleWithChildOnly,
			BigInteger q27cTransgenderMaleToFemaleUnknownHouseHoldtype,

			BigInteger q27cTransgenderFemaleToMaleTotal,
			BigInteger q27cTransgenderFemaleToMaleWithoutChild,
			BigInteger q27cTransgenderFemaleToMaleWithChildAndAdults,
			BigInteger q27cTransgenderFemaleToMaleWithChildOnly,
			BigInteger q27cTransgenderFemaleToMaleUnknownHouseHoldtype,

			BigInteger q27cOtherTotal,
			BigInteger q27cOtherWithoutChild,
			BigInteger q27cOtherWithChildAndAdults,
			BigInteger q27cOtherWithChildOnly,
			BigInteger q27cOtherUnknownHouseHoldtype,

			BigInteger q27cDKRTotal,
			BigInteger q27cDKRWithoutChild,
			BigInteger q27cDKRWithChildAndAdults,
			BigInteger q27cDKRWithChildOnly,
			BigInteger q27cDKRUnknownHouseHoldtype,

			BigInteger q27cInformationMissingTotal,
			BigInteger q27cInformationMissingWithoutChild,
			BigInteger q27cInformationMissingWithChildAndAdults,
			BigInteger q27cInformationMissingWithChildOnly,
			BigInteger q27cInformationMissingUnknownHouseHoldtype,

			BigInteger q27cTotTotal,
			BigInteger q27cTotWithoutChild,
			BigInteger q27cTotWithChildAndAdults,
			BigInteger q27cTotWithChildOnly,
			BigInteger q27cTotUnknownHouseHoldtype,
			DataBean q27cGenderYouthTable) {
		q27cGenderYouthTable.setQ27cMaleTotal(BigInteger.valueOf(0));
		q27cGenderYouthTable.setQ27cMaleWithoutChild(BigInteger.valueOf(0));
		q27cGenderYouthTable.setQ27cMaleWithChildAndAdults(BigInteger.valueOf(0));
		q27cGenderYouthTable.setQ27cMaleWithChildOnly(BigInteger.valueOf(0));
		q27cGenderYouthTable.setQ27cMaleUnknownHouseHoldtype(BigInteger.valueOf(0));

		q27cGenderYouthTable.setQ27cFemaleTotal(BigInteger.valueOf(0));
		q27cGenderYouthTable.setQ27cFemaleWithoutChild(BigInteger.valueOf(0));
		q27cGenderYouthTable.setQ27cFemaleWithChildAndAdults(BigInteger.valueOf(0));
		q27cGenderYouthTable.setQ27cFemaleWithChildOnly(BigInteger.valueOf(0));
		q27cGenderYouthTable.setQ27cFemaleUnknownHouseHoldtype(BigInteger.valueOf(0));

		q27cGenderYouthTable.setQ27cTransgenderMaleToFemaleTotal(BigInteger.valueOf(0));
		q27cGenderYouthTable.setQ27cTransgenderMaleToFemaleWithoutChild(BigInteger.valueOf(0));
		q27cGenderYouthTable.setQ27cTransgenderMaleToFemaleWithChildAndAdults(BigInteger.valueOf(0));
		q27cGenderYouthTable.setQ27cTransgenderMaleToFemaleWithChildOnly(BigInteger.valueOf(0));
		q27cGenderYouthTable.setQ27cTransgenderMaleToFemaleUnknownHouseHoldtype(BigInteger.valueOf(0));
					
		q27cGenderYouthTable.setQ27cTransgenderFemaleToMaleTotal(BigInteger.valueOf(0));
		q27cGenderYouthTable.setQ27cTransgenderFemaleToMaleWithoutChild(BigInteger.valueOf(0));
		q27cGenderYouthTable.setQ27cTransgenderFemaleToMaleWithChildAndAdults(BigInteger.valueOf(0));
		q27cGenderYouthTable.setQ27cTransgenderFemaleToMaleWithChildOnly(BigInteger.valueOf(0));
		q27cGenderYouthTable.setQ27cTransgenderFemaleToMaleUnknownHouseHoldtype(BigInteger.valueOf(0));

		q27cGenderYouthTable.setQ27cOtherTotal(BigInteger.valueOf(0));
		q27cGenderYouthTable.setQ27cOtherWithoutChild(BigInteger.valueOf(0));
		q27cGenderYouthTable.setQ27cOtherWithChildAndAdults(BigInteger.valueOf(0));
		q27cGenderYouthTable.setQ27cOtherWithChildOnly(BigInteger.valueOf(0));
		q27cGenderYouthTable.setQ27cOtherUnknownHouseHoldtype(BigInteger.valueOf(0));

		q27cGenderYouthTable.setQ27cDKRTotal(BigInteger.valueOf(0));
		q27cGenderYouthTable.setQ27cDKRWithoutChild(BigInteger.valueOf(0));
		q27cGenderYouthTable.setQ27cDKRWithChildAndAdults(BigInteger.valueOf(0));
		q27cGenderYouthTable.setQ27cDKRWithChildOnly(BigInteger.valueOf(0));
		q27cGenderYouthTable.setQ27cDKRUnknownHouseHoldtype(BigInteger.valueOf(0));

		q27cGenderYouthTable.setQ27cInformationMissingTotal(BigInteger.valueOf(0));
		q27cGenderYouthTable.setQ27cInformationMissingWithoutChild(BigInteger.valueOf(0));
		q27cGenderYouthTable.setQ27cInformationMissingWithChildAndAdults(BigInteger.valueOf(0));
		q27cGenderYouthTable.setQ27cInformationMissingWithChildOnly(BigInteger.valueOf(0));
		q27cGenderYouthTable.setQ27cInformationMissingUnknownHouseHoldtype(BigInteger.valueOf(0));

		q27cGenderYouthTable.setQ27cTotTotal(BigInteger.valueOf(0));
		q27cGenderYouthTable.setQ27cTotWithoutChild(BigInteger.valueOf(0));
		q27cGenderYouthTable.setQ27cTotWithChildAndAdults(BigInteger.valueOf(0));
		q27cGenderYouthTable.setQ27cTotWithChildOnly(BigInteger.valueOf(0));
		q27cGenderYouthTable.setQ27cTotUnknownHouseHoldtype(BigInteger.valueOf(0));



		return q27cGenderYouthTable;
	}
	
}

