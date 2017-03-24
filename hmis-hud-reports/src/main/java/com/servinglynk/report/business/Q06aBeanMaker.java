package com.servinglynk.report.business;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import com.servinglynk.report.bean.ClientModel;
import com.servinglynk.report.bean.Q06aReportValidationsTableDataBean;
import com.servinglynk.report.bean.ReportData;

public class Q06aBeanMaker {
	
//	public static List<Q06aReportValidationsTableDataBean> getQ06aReportValidationsTableList(String schema,ReportData data){
	public static List<Q06aReportValidationsTableDataBean> getQ06aReportValidationsTableList(){
		Q06aReportValidationsTableDataBean q06aReportValidationsTableBean = new Q06aReportValidationsTableDataBean();
		/*List<ClientModel> clients = data.getClients();
		List<ClientModel> adults = clients.parallelStream().filter(client -> isAdult(client.getDob())).collect(Collectors.toList());
		List<ClientModel> children = clients.parallelStream().filter(client -> isChild(client.getDob())).collect(Collectors.toList());
		List<ClientModel> ageUnknown = clients.parallelStream().filter(client -> client.getDob() == null).collect(Collectors.toList());
		List<ClientModel> veterans = clients.parallelStream().filter(client -> StringUtils.equals("1",client.getVeteran_status())).collect(Collectors.toList());
		q06aReportValidationsTableBean.setTotNumOfPersonServed(BigInteger.valueOf(clients !=null ? clients.size() : 0));
		q06aReportValidationsTableBean.setNumOfAdults(BigInteger.valueOf(adults !=null ?adults.size() : 0));
		q06aReportValidationsTableBean.setNumOfChildren(BigInteger.valueOf(children !=null ? children.size() : 0));
		q06aReportValidationsTableBean.setNumOfPersonsWithUnknownAge(BigInteger.valueOf(ageUnknown !=null ? ageUnknown.size() :0));*/
		
		q06aReportValidationsTableBean.setTotNumOfPersonServed(BigInteger.valueOf(0));
		q06aReportValidationsTableBean.setNumOfAdults(BigInteger.valueOf(0));
		q06aReportValidationsTableBean.setNumOfChildren(BigInteger.valueOf(0));
		q06aReportValidationsTableBean.setNumOfPersonsWithUnknownAge(BigInteger.valueOf(0));
		q06aReportValidationsTableBean.setTotNoOfLeavers(BigInteger.valueOf(3));
		q06aReportValidationsTableBean.setTotNoOfAdultLeavers(BigInteger.valueOf(4));
		q06aReportValidationsTableBean.setTotNoOfStayers(BigInteger.valueOf(13));
		q06aReportValidationsTableBean.setTotNoOfAdultStayers(BigInteger.valueOf(8));
//		q06aReportValidationsTableBean.setNoOfVeterans(BigInteger.valueOf(veterans !=null ? veterans.size() :0));
		q06aReportValidationsTableBean.setNoOfVeterans(BigInteger.valueOf(0));
		q06aReportValidationsTableBean.setNoOfChronicallyHomelessPersons(BigInteger.valueOf(11));
		q06aReportValidationsTableBean.setNoOfAdultHeadsOfHousehold(BigInteger.valueOf(1));
		q06aReportValidationsTableBean.setNoOfChildHeadsOfHousehold(BigInteger.valueOf(1));
		q06aReportValidationsTableBean.setNumOfUnaccompaniedYouthUnderAge25(BigInteger.valueOf(2));
		q06aReportValidationsTableBean.setNumOfParentingYouthUnderAge25WithChildren(BigInteger.valueOf(1));
		
        return Arrays.asList(q06aReportValidationsTableBean);
    }
	public static boolean isAdult(Date dob) {
		try {
			LocalDate currentDate = LocalDate.now();
			if(dob !=null) {
				@SuppressWarnings("deprecation")
				LocalDate dateOfBirth = LocalDate.of(dob.getYear(), dob.getMonth(), dob.getDay());
				Period p = Period.between(dateOfBirth, currentDate);
				if(p.getYears() > 18 )
					return true;
				else 
					return false;
			}
			return false;
		}catch(Exception e) {
			return false;
		}
	
	}
	
	public static boolean isChild(Date dob) {
		try {
			LocalDate currentDate = LocalDate.now();
			if(dob !=null) {
				@SuppressWarnings("deprecation")
				LocalDate dateOfBirth = LocalDate.of(dob.getYear(), dob.getMonth(), dob.getDay());
				Period p = Period.between(dateOfBirth, currentDate);
				if(p.getYears() < 18 )
					return true;
				else 
					return false;
			}
			return false;
		}catch(Exception e) {
			return false;
		}
		
	}

}
