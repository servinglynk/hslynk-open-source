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
	
	public static List<Q06aReportValidationsTableDataBean> getQ06aReportValidationsTableList(ReportData data){
		Q06aReportValidationsTableDataBean q06aReportValidationsTableBean = new Q06aReportValidationsTableDataBean();
		List<ClientModel> clients = data.getClients();
		List<ClientModel> adults = clients.parallelStream().filter(client -> isAdult(client.getDob())).collect(Collectors.toList());
		List<ClientModel> children = clients.parallelStream().filter(client -> isChild(client.getDob())).collect(Collectors.toList());
		List<ClientModel> ageUnknown = clients.parallelStream().filter(client -> client.getDob() == null).collect(Collectors.toList());
		List<ClientModel> veterans = clients.parallelStream().filter(client -> StringUtils.equals("1",client.getVeteran_status())).collect(Collectors.toList());
//		q06aReportValidationsTableBean.setTotNumOfPersonServed(BigInteger.valueOf(clients !=null ? clients.size() : 0));
//		q06aReportValidationsTableBean.setNumOfAdults(BigInteger.valueOf(adults !=null ?adults.size() : 0));
//		q06aReportValidationsTableBean.setNumOfChildren(BigInteger.valueOf(children !=null ? children.size() : 0));
//		q06aReportValidationsTableBean.setNumOfPersonsWithUnknownAge(BigInteger.valueOf(ageUnknown !=null ? ageUnknown.size() :0));
//		
		q06aReportValidationsTableBean.setNameCDK(BigInteger.valueOf(1));
		q06aReportValidationsTableBean.setNameInfoMissing(BigInteger.valueOf(1));
		q06aReportValidationsTableBean.setNameDataIssue(BigInteger.valueOf(1));
		q06aReportValidationsTableBean.setNamePercentageErrorRate(BigInteger.valueOf(1));
		q06aReportValidationsTableBean.setSsnCDK(BigInteger.valueOf(1));
		q06aReportValidationsTableBean.setSsnInfoMissing(BigInteger.valueOf(1));
		q06aReportValidationsTableBean.setSsnDataIssue(BigInteger.valueOf(1));
		q06aReportValidationsTableBean.setSsnPercentageErrorRate(BigInteger.valueOf(1));
		q06aReportValidationsTableBean.setDobCDK(BigInteger.valueOf(1));
		q06aReportValidationsTableBean.setDobInfoMissing(BigInteger.valueOf(1));
		q06aReportValidationsTableBean.setDobDataIssue(BigInteger.valueOf(1));
		q06aReportValidationsTableBean.setDobPercentageErrorRate(BigInteger.valueOf(1)); 
		q06aReportValidationsTableBean.setRaceCDK(BigInteger.valueOf(1));
		q06aReportValidationsTableBean.setRaceInfoMissing(BigInteger.valueOf(1));
		q06aReportValidationsTableBean.setRaceDataIssue(BigInteger.valueOf(1));
		q06aReportValidationsTableBean.setRacePercentageErrorRate(BigInteger.valueOf(1));
		q06aReportValidationsTableBean.setEthnicityCDK(BigInteger.valueOf(1));
		q06aReportValidationsTableBean.setEthnicityInfoMissing(BigInteger.valueOf(1));
		q06aReportValidationsTableBean.setEthnicityDataIssue(BigInteger.valueOf(1));
		q06aReportValidationsTableBean.setEthnicityPercentageErrorRate(BigInteger.valueOf(1));
		q06aReportValidationsTableBean.setGenderCDK(BigInteger.valueOf(1));
		q06aReportValidationsTableBean.setGenderInfoMissing(BigInteger.valueOf(1));
		q06aReportValidationsTableBean.setGenderPercentageErrorRate(BigInteger.valueOf(1));
		q06aReportValidationsTableBean.setOverAllPercentage(BigInteger.valueOf(1));


		
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
