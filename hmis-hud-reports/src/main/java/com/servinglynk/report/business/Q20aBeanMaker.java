package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import com.servinglynk.report.bean.Q20aTypeOfNonCashBenefitSourcesDataBean;
import com.servinglynk.report.bean.ReportData;
import com.servinglynk.report.model.DataCollectionStage;

public class Q20aBeanMaker extends BaseBeanMaker {

	public static List<Q20aTypeOfNonCashBenefitSourcesDataBean> getQ20aTypeOfNonCashBenefitSourcesList(ReportData data){
		/********
		 * Any changes here needs change to Q25h
		 */
		Q20aTypeOfNonCashBenefitSourcesDataBean q20aTypeOfNonCashBenefitSourcesTable = new Q20aTypeOfNonCashBenefitSourcesDataBean();
		String entryQuery = " select  count(distinct(dedup_client_id)) as cnt from %s.enrollment e, %s.noncashbenefits nb where  "+
		      "   nb.enrollmentid = e.id "+
			  " and nb.information_date = e.entrydate  and nb.information_date >= :endDate "+
			  " and e.ageatentry >=18  and nb.datacollectionstage = :datacollectionstage ";
		       
		String exitQuery = " select  count(distinct(dedup_client_id)) as cnt from %s.enrollment e,%s.noncashbenefits nb,%s.exit ext where  "+
			      "   nb.enrollmentid = e.id and e.id = ext.enrollmentid"+
				  " and nb.information_date = ext.exitdate and nb.information_date >= :endDate "+
				  " and e.ageatentry >=18  and nb.datacollectionstage = :datacollectionstage ";
			       
		String stayersQuery = " select count(distinct(dedup_client_id)) as cnt  from  %s.enrollment e, %s.noncashbenefits nb where "+
					" nb.enrollmentid=e.id  and nb.information_date <= :endDate and e.ageatentry >= 18 "+
					" and nb.datacollectionstage='5'  "+
					" and datediff(nb.information_date,e.entrydate) > 365 ";
			try {
				if(data.isLiveMode()) {
					q20aTypeOfNonCashBenefitSourcesTable.setQ20aSupplementalNutritionalAssistanceAtEntry(BigInteger.valueOf(getIncomeCnt(data, entryQuery +" and nb.snap='1' ", DataCollectionStage.ENTRY.getCode())));
					q20aTypeOfNonCashBenefitSourcesTable.setQ20aSupplementalNutritionalAssistanceAtLatestStayers(BigInteger.valueOf(getIncomeForAnnualAssesment(data, stayersQuery +" and nb.snap='1' ", DataCollectionStage.ANNUAL_ASSESMENT.getCode())));
					q20aTypeOfNonCashBenefitSourcesTable.setQ20aSupplementalNutritionalAssistanceAtExitLeavers(BigInteger.valueOf(getIncomeCnt(data, exitQuery +" and nb.snap='1' ", DataCollectionStage.EXIT.getCode())));

					q20aTypeOfNonCashBenefitSourcesTable.setQ20aWICAtEntry(BigInteger.valueOf(getIncomeCnt(data, entryQuery +" and nb.wic='1' ", DataCollectionStage.ENTRY.getCode())));
					q20aTypeOfNonCashBenefitSourcesTable.setQ20aWICAtLatestStayers(BigInteger.valueOf(getIncomeForAnnualAssesment(data, stayersQuery +" and nb.wic='1' ", DataCollectionStage.ANNUAL_ASSESMENT.getCode())));
					q20aTypeOfNonCashBenefitSourcesTable.setQ20aWICAtExitLeavers(BigInteger.valueOf(getIncomeCnt(data, exitQuery +" and  nb.wic='1' ", DataCollectionStage.EXIT.getCode())));

					q20aTypeOfNonCashBenefitSourcesTable.setQ20aTANFChildCareAtEntry(BigInteger.valueOf(getIncomeCnt(data, entryQuery +" and nb.tanfchildcare='1' ", DataCollectionStage.ENTRY.getCode())));
					q20aTypeOfNonCashBenefitSourcesTable.setQ20aTANFChildCareAtLatestStayers(BigInteger.valueOf(getIncomeForAnnualAssesment(data, stayersQuery +" and nb.tanfchildcare='1' ", DataCollectionStage.ANNUAL_ASSESMENT.getCode())));
					q20aTypeOfNonCashBenefitSourcesTable.setQ20aTANFChildCareAtExitLeavers(BigInteger.valueOf(getIncomeCnt(data, exitQuery +" and nb.tanfchildcare='1' ", DataCollectionStage.EXIT.getCode())));

					q20aTypeOfNonCashBenefitSourcesTable.setQ20aTANFTransportationAtEntry(BigInteger.valueOf(getIncomeCnt(data, entryQuery +" and nb.tanftransportation='1' ", DataCollectionStage.ENTRY.getCode())));
					q20aTypeOfNonCashBenefitSourcesTable.setQ20aTANFTransportationAtLatestStayers(BigInteger.valueOf(getIncomeForAnnualAssesment(data, stayersQuery +" and nb.tanftransportation='1' ", DataCollectionStage.ANNUAL_ASSESMENT.getCode())));
					q20aTypeOfNonCashBenefitSourcesTable.setQ20aTANFTransportationAtExitLeavers(BigInteger.valueOf(getIncomeCnt(data, exitQuery +" and nb.tanftransportation='1' ", DataCollectionStage.EXIT.getCode())));

					q20aTypeOfNonCashBenefitSourcesTable.setQ20aOtherTANFAtEntry(BigInteger.valueOf(getIncomeCnt(data, entryQuery +" and nb.othertanf='1' ", DataCollectionStage.ENTRY.getCode())));
					q20aTypeOfNonCashBenefitSourcesTable.setQ20aOtherTANFAtLatestStayers(BigInteger.valueOf(getIncomeForAnnualAssesment(data, stayersQuery +" and nb.othertanf='1' ", DataCollectionStage.ANNUAL_ASSESMENT.getCode())));
					q20aTypeOfNonCashBenefitSourcesTable.setQ20aOtherTANFAtExitLeavers(BigInteger.valueOf(getIncomeCnt(data, exitQuery +" and nb.othertanf='1' ", DataCollectionStage.EXIT.getCode())));

					q20aTypeOfNonCashBenefitSourcesTable.setQ20aOtherSourcesAtEntry(BigInteger.valueOf(getIncomeCnt(data, entryQuery +" and nb.othersource='1' ", DataCollectionStage.ENTRY.getCode())));
					q20aTypeOfNonCashBenefitSourcesTable.setQ20aOtherSourcesAtLatestStayers(BigInteger.valueOf(getIncomeForAnnualAssesment(data, stayersQuery +" and nb.othersource='1' ", DataCollectionStage.ANNUAL_ASSESMENT.getCode())));
					q20aTypeOfNonCashBenefitSourcesTable.setQ20aOtherSourcesAtExitLeavers(BigInteger.valueOf(getIncomeCnt(data, exitQuery +" and nb.othersource='1' ", DataCollectionStage.EXIT.getCode())));
				}
			}catch(Exception e) {
				logger.error("Error in Q20aBeanMaker:" + e);
			}
				
		return Arrays.asList(q20aTypeOfNonCashBenefitSourcesTable);
	}
}
