package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import com.servinglynk.report.bean.Q06aReportValidationsTableDataBean;

public class Q06aReportValidationsTableDataBeanMaker {
	
	public static List<Q06aReportValidationsTableDataBean> getQ06aReportValidationsTableList(){
	       
		Q06aReportValidationsTableDataBean q06aReportValidationsTableBean = new Q06aReportValidationsTableDataBean();
		
		q06aReportValidationsTableBean.setTotNumOfPersonServed(BigInteger.valueOf(16));
		q06aReportValidationsTableBean.setNumOfAdults(BigInteger.valueOf(11));
		q06aReportValidationsTableBean.setNumOfChildren(BigInteger.valueOf(4));
		q06aReportValidationsTableBean.setNumOfPersonsWithUnknownAge(BigInteger.valueOf(3));
		q06aReportValidationsTableBean.setTotNoOfLeavers(BigInteger.valueOf(3));
		q06aReportValidationsTableBean.setTotNoOfAdultLeavers(BigInteger.valueOf(4));
		q06aReportValidationsTableBean.setTotNoOfStayers(BigInteger.valueOf(13));
		q06aReportValidationsTableBean.setTotNoOfAdultStayers(BigInteger.valueOf(8));
		q06aReportValidationsTableBean.setNoOfVeterans(BigInteger.valueOf(2));
		q06aReportValidationsTableBean.setNoOfChronicallyHomelessPersons(BigInteger.valueOf(11));
		q06aReportValidationsTableBean.setNoOfAdultHeadsOfHousehold(BigInteger.valueOf(1));
		q06aReportValidationsTableBean.setNoOfChildHeadsOfHousehold(BigInteger.valueOf(1));
		q06aReportValidationsTableBean.setNumOfUnaccompaniedYouthUnderAge25(BigInteger.valueOf(2));
		q06aReportValidationsTableBean.setNumOfParentingYouthUnderAge25WithChildren(BigInteger.valueOf(1));
		
        return Arrays.asList(q06aReportValidationsTableBean);
    }


}
