package com.servinglynk.report.business;

import java.util.List;

import com.servinglynk.report.bean.Q18ClientCashIncomeCategoryEarnedOtherIncomeDataBean;
import com.servinglynk.report.bean.ReportData;

public class Q18DataBeanMaker extends ClientCashIncomeCategoryBeanMaker {
	public static List<Q18ClientCashIncomeCategoryEarnedOtherIncomeDataBean> getQ18ClientCashIncomeCategoryEarnedOtherIncomeList(ReportData data){
		return getClientCashIncomeCategoryEarnedOtherIncomeList(data, false);
	}
}
