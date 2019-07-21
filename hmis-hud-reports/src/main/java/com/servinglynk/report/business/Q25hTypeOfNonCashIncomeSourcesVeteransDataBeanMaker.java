package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import com.servinglynk.report.bean.Q25hTypeOfNonCashIncomeSourcesVeteransDataBean;
import com.servinglynk.report.bean.ReportData;
import com.servinglynk.report.model.DataCollectionStage;

public class Q25hTypeOfNonCashIncomeSourcesVeteransDataBeanMaker extends BaseBeanMaker {

	public static List<Q25hTypeOfNonCashIncomeSourcesVeteransDataBean> getQ25hTypeOfNonCashIncomeSourcesVeteransList(ReportData data){
		
		Q25hTypeOfNonCashIncomeSourcesVeteransDataBean Q25hTypeOfNonCashBenefitSourcesTable = new Q25hTypeOfNonCashIncomeSourcesVeteransDataBean();
		
		/********
		 * Any changes here needs change to Q25h
		 */
		
		String entryQuery = " select  count(distinct(e.dedup_client_id)) as cnt from %s.enrollment e, %s.noncashbenefits nb,%s.client c  where  "+
			      "   nb.enrollmentid = e.id "+
				  "  and nb.information_date <= :endDate "+
				  " and e.ageatentry >=18  and nb.datacollectionstage = '1'   and c.id = e.client_id and c.veteran_status='1'  ";
			       
			String exitQuery = " select  count(distinct(e.dedup_client_id)) as cnt from %s.enrollment e,%s.noncashbenefits nb,%s.exit ext,%s.client c  where  "+
				      "   nb.enrollmentid = e.id and e.id = ext.enrollmentid   and c.id = e.client_id and c.veteran_status='1' "+
					  "  and i.information_date <= :endDate "+
					  " and e.ageatentry >=18  and nb.datacollectionstage = '3' ";
				       
			String stayersQuery = " select count(distinct(e.dedup_client_id)) as cnt  from  %s.enrollment e, %s.noncashbenefits nb,%s.client c  where "+
						"    nb.enrollmentid = e.id   and c.id = e.client_id and c.veteran_status='1'  "+
						" and nb.information_date >= e.entrydate and  nb.information_date <= :endDate and e.ageatentry >= 18 "+
						" and nb.datacollectionstage in ('1','2','5')  ";
						//" and datediff(nb.information_date,e.entrydate) > 365 ";
			try {
			if(data.isLiveMode()) {
					Q25hTypeOfNonCashBenefitSourcesTable.setQ25hSupplementalNutritionalAssistanceAtEntry(BigInteger.valueOf(getIncomeCnt(data, entryQuery +" and nb.snap='1' ", DataCollectionStage.ENTRY.getCode())));
					Q25hTypeOfNonCashBenefitSourcesTable.setQ25hSupplementalNutritionalAssistanceStayers(BigInteger.valueOf(getIncomeForAnnualAssesment(data, stayersQuery +" and nb.snap='1' ", DataCollectionStage.ANNUAL_ASSESMENT.getCode())));
					Q25hTypeOfNonCashBenefitSourcesTable.setQ25hSupplementalNutritionalAssistanceLeavers(BigInteger.valueOf(getIncomeCnt(data, exitQuery +" and nb.snap='1' ", DataCollectionStage.EXIT.getCode())));

					Q25hTypeOfNonCashBenefitSourcesTable.setQ25hWICAtEntry(BigInteger.valueOf(getIncomeCnt(data, entryQuery +" and nb.wic='1' ", DataCollectionStage.ENTRY.getCode())));
					Q25hTypeOfNonCashBenefitSourcesTable.setQ25hWICStayers(BigInteger.valueOf(getIncomeForAnnualAssesment(data, stayersQuery +" and nb.wic='1' ", DataCollectionStage.ANNUAL_ASSESMENT.getCode())));
					Q25hTypeOfNonCashBenefitSourcesTable.setQ25hWICLeavers(BigInteger.valueOf(getIncomeCnt(data, exitQuery +" and  nb.wic='1' ", DataCollectionStage.EXIT.getCode())));

					Q25hTypeOfNonCashBenefitSourcesTable.setQ25hTANFChildCareServicesAtEntry(BigInteger.valueOf(getIncomeCnt(data, entryQuery +" and nb.tanfchildcare='1' ", DataCollectionStage.ENTRY.getCode())));
					Q25hTypeOfNonCashBenefitSourcesTable.setQ25hTANFChildCareServicesStayers(BigInteger.valueOf(getIncomeForAnnualAssesment(data, stayersQuery +" and nb.tanfchildcare='1' ", DataCollectionStage.ANNUAL_ASSESMENT.getCode())));
					Q25hTypeOfNonCashBenefitSourcesTable.setQ25hTANFChildCareServicesLeavers(BigInteger.valueOf(getIncomeCnt(data, exitQuery +" and nb.tanfchildcare='1' ", DataCollectionStage.EXIT.getCode())));

					Q25hTypeOfNonCashBenefitSourcesTable.setQ25hTANFTransportationServicesAtEntry(BigInteger.valueOf(getIncomeCnt(data, entryQuery +" and nb.tanftransportation='1' ", DataCollectionStage.ENTRY.getCode())));
					Q25hTypeOfNonCashBenefitSourcesTable.setQ25hTANFTransportationServicesStayers(BigInteger.valueOf(getIncomeForAnnualAssesment(data, stayersQuery +" and nb.tanftransportation='1' ", DataCollectionStage.ANNUAL_ASSESMENT.getCode())));
					Q25hTypeOfNonCashBenefitSourcesTable.setQ25hTANFTransportationServicesLeavers(BigInteger.valueOf(getIncomeCnt(data, exitQuery +" and nb.tanftransportation='1' ", DataCollectionStage.EXIT.getCode())));

					Q25hTypeOfNonCashBenefitSourcesTable.setQ25hOtherTANFFundedServicesAtEntry(BigInteger.valueOf(getIncomeCnt(data, entryQuery +" and nb.othertanf='1' ", DataCollectionStage.ENTRY.getCode())));
					Q25hTypeOfNonCashBenefitSourcesTable.setQ25hOtherTANFFundedServicesStayers(BigInteger.valueOf(getIncomeForAnnualAssesment(data, stayersQuery +" and nb.othertanf='1' ", DataCollectionStage.ANNUAL_ASSESMENT.getCode())));
					Q25hTypeOfNonCashBenefitSourcesTable.setQ25hOtherTANFFundedServicesLeavers(BigInteger.valueOf(getIncomeCnt(data, exitQuery +" and nb.othertanf='1' ", DataCollectionStage.EXIT.getCode())));

					Q25hTypeOfNonCashBenefitSourcesTable.setQ25hOtherSourceAtEntry(BigInteger.valueOf(getIncomeCnt(data, entryQuery +" and nb.othersource='1' ", DataCollectionStage.ENTRY.getCode())));
					Q25hTypeOfNonCashBenefitSourcesTable.setQ25hOtherSourceStayers(BigInteger.valueOf(getIncomeForAnnualAssesment(data, stayersQuery +" and nb.othersource='1' ", DataCollectionStage.ANNUAL_ASSESMENT.getCode())));
					Q25hTypeOfNonCashBenefitSourcesTable.setQ25hOtherSourceLeavers(BigInteger.valueOf(getIncomeCnt(data, exitQuery +" and nb.othersource='1' ", DataCollectionStage.EXIT.getCode())));
				}
			}catch(Exception e) {
				logger.error("Error in Q25hBeanMaker:" + e);
			}
				
		return Arrays.asList(Q25hTypeOfNonCashBenefitSourcesTable);
	}
}