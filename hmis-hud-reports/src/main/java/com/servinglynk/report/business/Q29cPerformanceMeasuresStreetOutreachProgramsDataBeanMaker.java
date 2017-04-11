package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import com.servinglynk.report.bean.Q29cPerformanceMeasuresStreetOutreachProgramsDataBean;

public class Q29cPerformanceMeasuresStreetOutreachProgramsDataBeanMaker {

	public static List<Q29cPerformanceMeasuresStreetOutreachProgramsDataBean> getQ29cPerformanceMeasuresStreetOutreachProgramsList(){
		
		Q29cPerformanceMeasuresStreetOutreachProgramsDataBean q29cPerformanceMeasuresStreetOutreachProgramsTable = new Q29cPerformanceMeasuresStreetOutreachProgramsDataBean();
		
		q29cPerformanceMeasuresStreetOutreachProgramsTable.setQ29cHousingStabilityMeasureApplicableMeasure(BigInteger.valueOf(0));
		q29cPerformanceMeasuresStreetOutreachProgramsTable.setQ29cHousingStabilityMeasureAccomplishedMeasure(BigInteger.valueOf(0));
		q29cPerformanceMeasuresStreetOutreachProgramsTable.setQ29cHousingStabilityMeasure(BigInteger.valueOf(0));

		q29cPerformanceMeasuresStreetOutreachProgramsTable.setQ29cPhysicalDisabilityServiceLinkageApplicableMeasure(BigInteger.valueOf(0));
		q29cPerformanceMeasuresStreetOutreachProgramsTable.setQ29cPhysicalDisabilityServiceLinkageAccomplishedMeasure(BigInteger.valueOf(0));
		q29cPerformanceMeasuresStreetOutreachProgramsTable.setQ29cPhysicalDisabilityServiceLinkage(BigInteger.valueOf(0));

		q29cPerformanceMeasuresStreetOutreachProgramsTable.setQ29cDevelopmentalDisabilityServiceLinkageApplicableMeasure(BigInteger.valueOf(0));
		q29cPerformanceMeasuresStreetOutreachProgramsTable.setQ29cDevelopmentalDisabilityServiceLinkageAccomplishedMeasure(BigInteger.valueOf(0));
		q29cPerformanceMeasuresStreetOutreachProgramsTable.setQ29cDevelopmentalDisabilityServiceLinkage(BigInteger.valueOf(0));

		q29cPerformanceMeasuresStreetOutreachProgramsTable.setQ29cChronicHealthServiceLinkageApplicableMeasure(BigInteger.valueOf(0));
		q29cPerformanceMeasuresStreetOutreachProgramsTable.setQ29cChronicHealthServiceLinkageAccomplishedMeasure(BigInteger.valueOf(0));
		q29cPerformanceMeasuresStreetOutreachProgramsTable.setQ29cChronicHealthServiceLinkage(BigInteger.valueOf(0));

		q29cPerformanceMeasuresStreetOutreachProgramsTable.setQ29cHIVOrAIDSServiceLinkageApplicableMeasure(BigInteger.valueOf(0));
		q29cPerformanceMeasuresStreetOutreachProgramsTable.setQ29cHIVOrAIDSServiceLinkageAccomplishedMeasure(BigInteger.valueOf(0));
		q29cPerformanceMeasuresStreetOutreachProgramsTable.setQ29cHIVOrAIDSServiceLinkage(BigInteger.valueOf(0));

		q29cPerformanceMeasuresStreetOutreachProgramsTable.setQ29cMentalHealthServiceLinkageApplicableMeasure(BigInteger.valueOf(0));
		q29cPerformanceMeasuresStreetOutreachProgramsTable.setQ29cMentalHealthServiceLinkageAccomplishedMeasure(BigInteger.valueOf(0));
		q29cPerformanceMeasuresStreetOutreachProgramsTable.setQ29cMentalHealthServiceLinkage(BigInteger.valueOf(0));

		q29cPerformanceMeasuresStreetOutreachProgramsTable.setQ29cSubstanceAbuseServiceLinkageApplicableMeasure(BigInteger.valueOf(0));
		q29cPerformanceMeasuresStreetOutreachProgramsTable.setQ29cSubstanceAbuseServiceLinkageAccomplishedMeasure(BigInteger.valueOf(0));
		q29cPerformanceMeasuresStreetOutreachProgramsTable.setQ29cSubstanceAbuseServiceLinkage(BigInteger.valueOf(0));
		
		return Arrays.asList(q29cPerformanceMeasuresStreetOutreachProgramsTable);
	}
}
