package com.servinglynk.report.business;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.servinglynk.report.bean.Q05aHMISComparableDBDataQualityDataBean;

public class Q05aBeanMaker extends BaseBeanMaker {
	
//	public static List<Q06aReportValidationsTableDataBean> getQ06aReportValidationsTableList(String schema,ReportData data){
	public static List<Q05aHMISComparableDBDataQualityDataBean> getQ05aReportValidationsTableList(){
		Q05aHMISComparableDBDataQualityDataBean q05aReportValidationsTableBean = new Q05aHMISComparableDBDataQualityDataBean();
		/*List<ClientModel> clients = data.getClients();
		List<ClientModel> adults = clients.parallelStream().filter(client -> isAdult(client.getDob())).collect(Collectors.toList());
		List<ClientModel> children = clients.parallelStream().filter(client -> isChild(client.getDob())).collect(Collectors.toList());
		List<ClientModel> ageUnknown = clients.parallelStream().filter(client -> client.getDob() == null).collect(Collectors.toList());
		List<ClientModel> veterans = clients.parallelStream().filter(client -> StringUtils.equals("1",client.getVeteran_status())).collect(Collectors.toList());
		q05aReportValidationsTableBean.setTotNumOfPersonServed(BigInteger.valueOf(clients !=null ? clients.size() : 0));
		q05aReportValidationsTableBean.setNumOfAdults(BigInteger.valueOf(adults !=null ?adults.size() : 0));
		q05aReportValidationsTableBean.setNumOfChildren(BigInteger.valueOf(children !=null ? children.size() : 0));
		q05aReportValidationsTableBean.setNumOfPersonsWithUnknownAge(BigInteger.valueOf(ageUnknown !=null ? ageUnknown.size() :0));*/
		
		q05aReportValidationsTableBean.setNoOfAdultHeadsOfHousehold(BigInteger.valueOf(1));
		q05aReportValidationsTableBean.setNoOfChildHeadsOfHousehold(BigInteger.valueOf(1));
		q05aReportValidationsTableBean.setNoOfChronicallyHomelessPersons(BigInteger.valueOf(1));
		q05aReportValidationsTableBean.setNoOfVeterans(BigInteger.valueOf(1));
		q05aReportValidationsTableBean.setNumOfAdultandHeadOfHHLeavers(BigInteger.valueOf(1));
		q05aReportValidationsTableBean.setNumOfAdults(BigInteger.valueOf(1));
		q05aReportValidationsTableBean.setNumOfChildren(BigInteger.valueOf(1));
		q05aReportValidationsTableBean.setNumOfHeadsOfHHandAdults365Days(BigInteger.valueOf(1));
		q05aReportValidationsTableBean.setNumOfParentingYouthUnderAge25WithChildren(BigInteger.valueOf(1));
		q05aReportValidationsTableBean.setNumOfPersonsWithUnknownAge(BigInteger.valueOf(1));
		q05aReportValidationsTableBean.setNumOfYouthUnderAge25(BigInteger.valueOf(1));
		q05aReportValidationsTableBean.setTotNoOfAdultLeavers(BigInteger.valueOf(1));
		q05aReportValidationsTableBean.setTotNoOfAdultStayers(BigInteger.valueOf(1));
		q05aReportValidationsTableBean.setTotNoOfLeavers(BigInteger.valueOf(1));
		q05aReportValidationsTableBean.setTotNoOfStayers(BigInteger.valueOf(1));
		q05aReportValidationsTableBean.setTotNumOfPersonServed(BigInteger.valueOf(1));
		
		
        return Arrays.asList(q05aReportValidationsTableBean);
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
