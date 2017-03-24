package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import com.servinglynk.report.bean.Q06bNumberOfPersonsServedDataBean;
import com.servinglynk.report.bean.ReportData;

public class Q06bBeanMaker  {
	
//	public static List<Q06bNumberOfPersonsServedDataBean> getQ06bNumberOfPersonsServedTableList(String schema,ReportData data){
	public static List<Q06bNumberOfPersonsServedDataBean> getQ06bNumberOfPersonsServedTableList(){
		Q06bNumberOfPersonsServedDataBean q06bNumberOfPersonsServedDataBean = new Q06bNumberOfPersonsServedDataBean();
		
	//	q06aReportValidationsTableBean.setNumOfAdults(BigInteger.valueOf(adults !=null ?adults.size() : 0));
	//	q06aReportValidationsTableBean.setNumOfChildren(BigInteger.valueOf(children !=null ? children.size() : 0));
		q06bNumberOfPersonsServedDataBean.setNpTotalAdults(BigInteger.valueOf(11));
		q06bNumberOfPersonsServedDataBean.setNpAdultsWcTot(BigInteger.valueOf(1));
		q06bNumberOfPersonsServedDataBean.setNpAdultsWocTot(BigInteger.valueOf(0));
		q06bNumberOfPersonsServedDataBean.setNpAdultsWcaTot(BigInteger.valueOf(0));
		q06bNumberOfPersonsServedDataBean.setNpAdultsUhtTot(BigInteger.valueOf(10));
		
		q06bNumberOfPersonsServedDataBean.setNpTotalChildren(BigInteger.valueOf(4));
		q06bNumberOfPersonsServedDataBean.setNpChildWcTot(BigInteger.valueOf(2));
		q06bNumberOfPersonsServedDataBean.setNpChildWocTot(BigInteger.valueOf(0));
		q06bNumberOfPersonsServedDataBean.setNpChildWcaTot(BigInteger.valueOf(0));
		q06bNumberOfPersonsServedDataBean.setNpChildUhtTot(BigInteger.valueOf(2));
		
		q06bNumberOfPersonsServedDataBean.setNpTotalDKR(BigInteger.valueOf(0));
		q06bNumberOfPersonsServedDataBean.setNpDkrWcaTot(BigInteger.valueOf(0));
		q06bNumberOfPersonsServedDataBean.setNpDkrWcTot(BigInteger.valueOf(0));
		q06bNumberOfPersonsServedDataBean.setNpDkrWocTot(BigInteger.valueOf(0));
		q06bNumberOfPersonsServedDataBean.setNpDkrUhtTot(BigInteger.valueOf(0));
		
		q06bNumberOfPersonsServedDataBean.setNpTotalMI(BigInteger.valueOf(1));
		q06bNumberOfPersonsServedDataBean.setNpMiWcaTot(BigInteger.valueOf(0));
		q06bNumberOfPersonsServedDataBean.setNpMiWcTot(BigInteger.valueOf(1));
		q06bNumberOfPersonsServedDataBean.setNpMiWocTot(BigInteger.valueOf(0));
		q06bNumberOfPersonsServedDataBean.setNpMiUhtTot(BigInteger.valueOf(0));
		
		q06bNumberOfPersonsServedDataBean.setNpOverallTotal(BigInteger.valueOf(16));
		q06bNumberOfPersonsServedDataBean.setNpTotalWC(BigInteger.valueOf(0));
		q06bNumberOfPersonsServedDataBean.setNpWCATotal(BigInteger.valueOf(3));
		q06bNumberOfPersonsServedDataBean.setNpWOCTotal(BigInteger.valueOf(2));
		q06bNumberOfPersonsServedDataBean.setNpUHTTotal(BigInteger.valueOf(10));
		
		return Arrays.asList(q06bNumberOfPersonsServedDataBean);
	}

}
