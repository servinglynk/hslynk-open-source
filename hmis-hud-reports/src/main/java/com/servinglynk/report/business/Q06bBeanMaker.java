package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import com.servinglynk.report.bean.Q06bNumberOfPersonsServedDataBean;

public class Q06bBeanMaker  {
	
//	public static List<Q06bNumberOfPersonsServedDataBean> getQ06bNumberOfPersonsServedTableList(String schema,ReportData data){
	public static List<Q06bNumberOfPersonsServedDataBean> getQ06bNumberOfPersonsServedTableList(){
		Q06bNumberOfPersonsServedDataBean q06bNumberOfPersonsServedDataBean = new Q06bNumberOfPersonsServedDataBean();
		
	//	q06aReportValidationsTableBean.setNumOfAdults(BigInteger.valueOf(adults !=null ?adults.size() : 0));
	//	q06aReportValidationsTableBean.setNumOfChildren(BigInteger.valueOf(children !=null ? children.size() : 0));
		
		q06bNumberOfPersonsServedDataBean.setVeteranStatusErrorCount(BigInteger.valueOf(0));
		q06bNumberOfPersonsServedDataBean.setVeteranStatusErrorRate(BigInteger.valueOf(0));
		q06bNumberOfPersonsServedDataBean.setPedErrorCount(BigInteger.valueOf(0));
		q06bNumberOfPersonsServedDataBean.setPedErrorRate(BigInteger.valueOf(0));
		q06bNumberOfPersonsServedDataBean.setRelationshipHHErrorCount(BigInteger.valueOf(0));
		q06bNumberOfPersonsServedDataBean.setRelationshipHHErrorRate(BigInteger.valueOf(0));
		q06bNumberOfPersonsServedDataBean.setClientLocationErrorCount(BigInteger.valueOf(0));
		q06bNumberOfPersonsServedDataBean.setClientLocationErrorRate(BigInteger.valueOf(0));
		q06bNumberOfPersonsServedDataBean.setDisablingCondErrorCount(BigInteger.valueOf(0));
		q06bNumberOfPersonsServedDataBean.setDisablingCondErrorRate(BigInteger.valueOf(0));
		
		return Arrays.asList(q06bNumberOfPersonsServedDataBean);
	}

}
