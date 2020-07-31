package com.servinglynk.report.business;

import java.util.List;

import com.servinglynk.report.bean.Q18ClientCashIncomeCategoryEarnedOtherIncomeDataBean;
import com.servinglynk.report.bean.ReportData;

public class Q27hDataBeanMaker extends ClientCashIncomeCategoryBeanMaker {
	public static List<Q18ClientCashIncomeCategoryEarnedOtherIncomeDataBean> getQ27hClientCashIncomeCategoryEarnedOtherIncomeList(ReportData data){
		return getClientCashIncomeCategoryEarnedOtherIncomeList(data, true);
	}
}
