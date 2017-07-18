package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import com.servinglynk.report.bean.Q29ePerformanceMeasuresSafeHavensDataBean;

public class Q29ePerformanceMeasuresSafeHavensDataBeanMaker {
	
	public static List<Q29ePerformanceMeasuresSafeHavensDataBean> getQ29ePerformanceMeasuresSafeHavensDataBeanList(){
		
		Q29ePerformanceMeasuresSafeHavensDataBean q29ePerformanceMeasuresSafeHavensDataBeanTable = new Q29ePerformanceMeasuresSafeHavensDataBean();
		
		q29ePerformanceMeasuresSafeHavensDataBeanTable.setQ29eHousingStabilityMeasureApplicableMeasure(BigInteger.valueOf(0));
		q29ePerformanceMeasuresSafeHavensDataBeanTable.setQ29eHousingStabilityMeasureAccomplishedMeasure(BigInteger.valueOf(0));
		q29ePerformanceMeasuresSafeHavensDataBeanTable.setQ29eHousingStabilityMeasure(BigInteger.valueOf(0));
		q29ePerformanceMeasuresSafeHavensDataBeanTable.setQ29eTotalIncomeApplicableMeasure(BigInteger.valueOf(0));
		q29ePerformanceMeasuresSafeHavensDataBeanTable.setQ29eTotalIncomeAccomplishedMeasure(BigInteger.valueOf(0));
		q29ePerformanceMeasuresSafeHavensDataBeanTable.setQ29eTotalIncome(BigInteger.valueOf(0));
		q29ePerformanceMeasuresSafeHavensDataBeanTable.setQ29eEarnedIncomeApplicableMeasure(BigInteger.valueOf(0));
		q29ePerformanceMeasuresSafeHavensDataBeanTable.setQ29eEarnedIncomeAccomplishedMeasure(BigInteger.valueOf(0));
		q29ePerformanceMeasuresSafeHavensDataBeanTable.setQ29eEarnedIncome(BigInteger.valueOf(0));
		
		return Arrays.asList(q29ePerformanceMeasuresSafeHavensDataBeanTable);
		
	}

}
