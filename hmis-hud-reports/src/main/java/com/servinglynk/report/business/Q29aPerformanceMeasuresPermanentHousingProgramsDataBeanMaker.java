package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import com.servinglynk.report.bean.Q29aPerformanceMeasuresPermanentHousingProgramsDataBean;

public class Q29aPerformanceMeasuresPermanentHousingProgramsDataBeanMaker {
	
	public static List<Q29aPerformanceMeasuresPermanentHousingProgramsDataBean> getQ29aPerformanceMeasuresPermanentHousingProgramsList(){
		
		Q29aPerformanceMeasuresPermanentHousingProgramsDataBean q29aPerformanceMeasuresPermanentHousingProgramsTable = new Q29aPerformanceMeasuresPermanentHousingProgramsDataBean();
		
		q29aPerformanceMeasuresPermanentHousingProgramsTable.setQ29aHousingStabilityMeasureApplicableMeasure(BigInteger.valueOf(0));
		q29aPerformanceMeasuresPermanentHousingProgramsTable.setQ29aHousingStabilityMeasureAccomplishedMeasure(BigInteger.valueOf(0));
		q29aPerformanceMeasuresPermanentHousingProgramsTable.setQ29aHousingStabilityMeasure(BigInteger.valueOf(0));
		q29aPerformanceMeasuresPermanentHousingProgramsTable.setQ29aTotalIncomeApplicableMeasure(BigInteger.valueOf(0));
		q29aPerformanceMeasuresPermanentHousingProgramsTable.setQ29aTotalIncomeAccomplishedMeasure(BigInteger.valueOf(0));
		q29aPerformanceMeasuresPermanentHousingProgramsTable.setQ29aTotalIncome(BigInteger.valueOf(0));
		q29aPerformanceMeasuresPermanentHousingProgramsTable.setQ29aEarnedIncomeApplicableMeasure(BigInteger.valueOf(0));
		q29aPerformanceMeasuresPermanentHousingProgramsTable.setQ29aEarnedIncomeAccomplishedMeasure(BigInteger.valueOf(0));
		q29aPerformanceMeasuresPermanentHousingProgramsTable.setQ29aEarnedIncome(BigInteger.valueOf(0));

		return Arrays.asList(q29aPerformanceMeasuresPermanentHousingProgramsTable);
		
	}

}
