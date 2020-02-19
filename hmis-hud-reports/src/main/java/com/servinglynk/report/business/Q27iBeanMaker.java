package com.servinglynk.report.business;

import java.util.List;

import com.servinglynk.report.bean.DisabIncomeAndSourceDataBean;
import com.servinglynk.report.bean.ReportData;

public class Q27iBeanMaker extends DisabIncomeAndSourceDataBeanMaker {
	
	public static List<DisabIncomeAndSourceDataBean> getQ27iDataBean(ReportData data){
		return getDisabIncomeAndSourceDataBean(data,true);
	}
}