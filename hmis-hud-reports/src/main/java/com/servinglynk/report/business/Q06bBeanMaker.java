package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.servinglynk.report.bean.Q06bDataBean;
import com.servinglynk.report.bean.ReportData;
import com.servinglynk.report.model.ClientModel;
import com.servinglynk.report.model.EnrollmentModel;

public class Q06bBeanMaker  {
	public static Long veteranStatusErrorCount = 0L;
	public static Long pedErrorCount = 0L;
	public static Long relationShipHHErrorCount = 0L;
	public static Long clientLocationErrorCount = 0L;
	public static Long disablingCondErrorCount = 0L;
	
	public static List<Q06bDataBean> getQ06bNumberOfPersonsServedTableList(ReportData data){
		Q06bDataBean q06bDataBean = new Q06bDataBean();
		List<ClientModel> clients = data.getClients();
		List<EnrollmentModel> enrollments = data.getEnrollments();
		Long numOfClients = Long.valueOf(clients.size());
		clients.parallelStream().forEach(client -> { 
			
			if(StringUtils.equals("8", client.getVeteran_status()) || StringUtils.equals("9", client.getVeteran_status()) || StringUtils.equals("9", client.getVeteran_status()) || 
				(StringUtils.equals("1", client.getVeteran_status()) && client.getDob() != null && getAge(client.getDob())  < 18 ) ) {
				veteranStatusErrorCount++;
			}
		}
		);
		enrollments.parallelStream().forEach(enrollment -> { 
			if(StringUtils.equals("8", enrollment.getDisablingcondition()) || StringUtils.equals("9", enrollment.getDisablingcondition())) {
				disablingCondErrorCount++;
			}
			if(StringUtils.equals("8", enrollment.getRelationshiptohoh()) || StringUtils.equals("9", enrollment.getRelationshiptohoh())) {
				relationShipHHErrorCount++;
			}
//			if(enrollment.getEntrydate() == null) {
//				pedErrorCount++;
//			}
		 }
		);
		
		q06bDataBean.setVeteranStatusErrorCount(BigInteger.valueOf(veteranStatusErrorCount));
		Long numOfAdults = Long.parseLong(String.valueOf(data.getNumOfAdults()));
		if(numOfAdults !=0) {
			q06bDataBean.setVeteranStatusErrorRate(BigInteger.valueOf(veteranStatusErrorCount/numOfAdults));
		}else {
			q06bDataBean.setVeteranStatusErrorRate(BigInteger.valueOf(0));
		}
		
		q06bDataBean.setPedErrorCount(BigInteger.valueOf(pedErrorCount));
		q06bDataBean.setPedErrorRate(BigInteger.valueOf(pedErrorCount/numOfClients));
		q06bDataBean.setRelationshipHHErrorCount(BigInteger.valueOf(relationShipHHErrorCount));
		q06bDataBean.setRelationshipHHErrorRate(BigInteger.valueOf(relationShipHHErrorCount/numOfClients));
		q06bDataBean.setClientLocationErrorCount(BigInteger.valueOf(0));
		q06bDataBean.setClientLocationErrorRate(BigInteger.valueOf(0));
		q06bDataBean.setDisablingCondErrorCount(BigInteger.valueOf(disablingCondErrorCount));
		q06bDataBean.setDisablingCondErrorRate(BigInteger.valueOf(disablingCondErrorCount/numOfClients));
		
		return Arrays.asList(q06bDataBean);
	}

	public static int getAge(Date dateOfBirth) {
	    int age = 0;
	    Calendar born = Calendar.getInstance();
	    Calendar now = Calendar.getInstance();
	    if(dateOfBirth!= null) {
	        now.setTime(new Date());
	        born.setTime(dateOfBirth);  
	        if(born.after(now)) {
	            throw new IllegalArgumentException("Can't be born in the future");
	        }
	        age = now.get(Calendar.YEAR) - born.get(Calendar.YEAR);             
	        if(now.get(Calendar.DAY_OF_YEAR) < born.get(Calendar.DAY_OF_YEAR))  {
	            age-=1;
	        }
	    }  
	    return age;
	}
}
