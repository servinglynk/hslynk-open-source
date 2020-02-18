package com.servinglynk.report.business;

import java.util.List;

import com.servinglynk.report.bean.DisabIncomeAndSourceDataBean;
import com.servinglynk.report.bean.ReportData;

public class Q19bBeanMaker extends DisabIncomeAndSourceDataBeanMaker {
	
	public static List<DisabIncomeAndSourceDataBean> getQ19DataBean(ReportData data){
		return getDisabIncomeAndSourceDataBean(data,null);
	}
}
