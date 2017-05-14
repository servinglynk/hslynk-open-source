package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import com.servinglynk.report.bean.ClientModel;
import com.servinglynk.report.bean.EnrollmentModel;
import com.servinglynk.report.bean.Q06bDataBean;
import com.servinglynk.report.bean.ReportData;
import jodd.util.StringUtil;

public class Q06bBeanMaker  {
	public static Long veteranStatusErrorCount = 0L;
	public static Long pedErrorCount;
	public static Long relationShipHHErrorCount;
	public static Long clientLocationErrorCount;
	public static Long disablingCondErrorCount;
	
	public static List<Q06bDataBean> getQ06bNumberOfPersonsServedTableList(ReportData data){
		Q06bDataBean q06bDataBean = new Q06bDataBean();
		List<ClientModel> clients = data.getClients();
		List<EnrollmentModel> enrollments = data.getEnrollments();
		Long numOfClients = Long.valueOf(clients.size());
		clients.parallelStream().forEach(client -> { 
			
			if(StringUtil.equals("8", client.getVeteran_status()) || StringUtil.equals("9", client.getVeteran_status())) {
				veteranStatusErrorCount++;
			}
		}
		);
		enrollments.parallelStream().forEach(enrollment -> { 
			if(StringUtil.equals("8", enrollment.getDisablingcondition()) || StringUtil.equals("9", enrollment.getDisablingcondition())) {
				disablingCondErrorCount++;
			}
			if(StringUtil.equals("8", enrollment.getRelationshiptohoh()) || StringUtil.equals("9", enrollment.getRelationshiptohoh())) {
				relationShipHHErrorCount++;
			}
			if(enrollment.getEntrydate() == null) {
				pedErrorCount++;
			}
		
		 }
		);
		
		q06bDataBean.setVeteranStatusErrorCount(BigInteger.valueOf(0));
		q06bDataBean.setVeteranStatusErrorRate(BigInteger.valueOf(numOfClients/veteranStatusErrorCount));
		q06bDataBean.setPedErrorCount(BigInteger.valueOf(pedErrorCount));
		q06bDataBean.setPedErrorRate(BigInteger.valueOf(numOfClients/pedErrorCount));
		q06bDataBean.setRelationshipHHErrorCount(BigInteger.valueOf(relationShipHHErrorCount));
		q06bDataBean.setRelationshipHHErrorRate(BigInteger.valueOf(numOfClients/relationShipHHErrorCount));
		q06bDataBean.setClientLocationErrorCount(BigInteger.valueOf(0));
		q06bDataBean.setClientLocationErrorRate(BigInteger.valueOf(0));
		q06bDataBean.setDisablingCondErrorCount(BigInteger.valueOf(disablingCondErrorCount));
		q06bDataBean.setDisablingCondErrorRate(BigInteger.valueOf(numOfClients/disablingCondErrorCount));
		
		return Arrays.asList(q06bDataBean);
	}

}
