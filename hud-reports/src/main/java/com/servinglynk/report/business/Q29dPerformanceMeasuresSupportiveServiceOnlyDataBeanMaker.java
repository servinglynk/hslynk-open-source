package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import com.servinglynk.report.bean.Q29dPerformanceMeasuresSupportiveServiceOnlyDataBean;

public class Q29dPerformanceMeasuresSupportiveServiceOnlyDataBeanMaker {
	
	public static List<Q29dPerformanceMeasuresSupportiveServiceOnlyDataBean> getQ29dPerformanceMeasuresSupportiveServiceOnlyDataBeanList(){
		
		Q29dPerformanceMeasuresSupportiveServiceOnlyDataBean q29dPerformanceMeasuresSupportiveServiceOnlyTable = new Q29dPerformanceMeasuresSupportiveServiceOnlyDataBean();
		
		q29dPerformanceMeasuresSupportiveServiceOnlyTable.setQ29dHousingStabilityMeasureApplicableMeasure(BigInteger.valueOf(0));
		q29dPerformanceMeasuresSupportiveServiceOnlyTable.setQ29dHousingStabilityMeasureAccomplishedMeasure(BigInteger.valueOf(0));
		q29dPerformanceMeasuresSupportiveServiceOnlyTable.setQ29dHousingStabilityMeasure(BigInteger.valueOf(0));
		q29dPerformanceMeasuresSupportiveServiceOnlyTable.setQ29dTotalIncomeApplicableMeasure(BigInteger.valueOf(0));
		q29dPerformanceMeasuresSupportiveServiceOnlyTable.setQ29dTotalIncomeAccomplishedMeasure(BigInteger.valueOf(0));
		q29dPerformanceMeasuresSupportiveServiceOnlyTable.setQ29dTotalIncome(BigInteger.valueOf(0));
		q29dPerformanceMeasuresSupportiveServiceOnlyTable.setQ29dEarnedIncomeApplicableMeasure(BigInteger.valueOf(0));
		q29dPerformanceMeasuresSupportiveServiceOnlyTable.setQ29dEarnedIncomeAccomplishedMeasure(BigInteger.valueOf(0));
		q29dPerformanceMeasuresSupportiveServiceOnlyTable.setQ29dEarnedIncome(BigInteger.valueOf(0));
		
		return Arrays.asList(q29dPerformanceMeasuresSupportiveServiceOnlyTable);
		
	}

}
