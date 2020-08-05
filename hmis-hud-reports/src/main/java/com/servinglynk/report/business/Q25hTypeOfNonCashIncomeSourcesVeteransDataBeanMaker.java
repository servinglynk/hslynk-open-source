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
			      "  and TO_DATE(nb.information_date) = TO_DATE(e.entrydate) "+
				  "  and nb.information_date <= :endDate "+
				  " and e.ageatentry >=18  and nb.datacollectionstage = '1'   and c.id = e.client_id and c.veteran_status='1'  ";
			       
			String exitQuery = " select  count(distinct(e.dedup_client_id)) as cnt from %s.enrollment e,%s.noncashbenefits nb,%s.exit ext,%s.client c  where  "+
				      "   nb.enrollmentid = e.id and e.id = ext.enrollmentid   and c.id = e.client_id and c.veteran_status='1' "+
					  "  and TO_DATE(nb.information_date) = TO_DATE(ext.exitdate) and  nb.information_date <= :endDate "+
					  " and e.ageatentry >=18  and nb.datacollectionstage = '3' ";
				       
			String stayersQuery = " select count(distinct(e.dedup_client_id)) as cnt  from  %s.enrollment e, %s.noncashbenefits nb,%s.client c  where "+
						"    nb.enrollmentid = e.id   and c.id = e.client_id and c.veteran_status='1'  "+
						" and  nb.information_date <= :endDate and e.ageatentry >= 18 "+
						" and nb.datacollectionstage in ('1','2','5')  ";
						//" and datediff(nb.information_date,e.entrydate) > 365 ";
			try {
			if(data.isLiveMode()) {
				Q25hTypeOfNonCashBenefitSourcesTable.setQ25hSupplementalNutritionalAssistanceAtEntry(BigInteger.valueOf(getIncomeCntForVeterans(data.getSchema(),entryQuery +" and nb.snap='1' ", DataCollectionStage.ENTRY.getCode(), data)));
				Q25hTypeOfNonCashBenefitSourcesTable.setQ25hSupplementalNutritionalAssistanceStayers(BigInteger.valueOf(getIncomeCntForVeterans(data.getSchema(), stayersQuery +" and nb.snap='1' ", DataCollectionStage.ANNUAL_ASSESMENT.getCode(), data)));
				Q25hTypeOfNonCashBenefitSourcesTable.setQ25hSupplementalNutritionalAssistanceLeavers(BigInteger.valueOf(getIncomeCntForVeterans(data.getSchema(), exitQuery +" and nb.snap='1' ", DataCollectionStage.EXIT.getCode(), data)));

				Q25hTypeOfNonCashBenefitSourcesTable.setQ25hWICAtEntry(BigInteger.valueOf(getIncomeCntForVeterans(data.getSchema(), entryQuery +" and nb.wic='1' ", DataCollectionStage.ENTRY.getCode(), data)));
				Q25hTypeOfNonCashBenefitSourcesTable.setQ25hWICStayers(BigInteger.valueOf(getIncomeCntForVeterans(data.getSchema(), stayersQuery +" and nb.wic='1' ", DataCollectionStage.ANNUAL_ASSESMENT.getCode(), data)));
				Q25hTypeOfNonCashBenefitSourcesTable.setQ25hWICLeavers(BigInteger.valueOf(getIncomeCntForVeterans(data.getSchema(), exitQuery +" and  nb.wic='1' ", DataCollectionStage.EXIT.getCode(), data)));

				Q25hTypeOfNonCashBenefitSourcesTable.setQ25hTANFChildCareServicesAtEntry(BigInteger.valueOf(getIncomeCntForVeterans(data.getSchema(), entryQuery +" and nb.tanfchildcare='1' ", DataCollectionStage.ENTRY.getCode(), data)));
				Q25hTypeOfNonCashBenefitSourcesTable.setQ25hTANFChildCareServicesStayers(BigInteger.valueOf(getIncomeCntForVeterans(data.getSchema(), stayersQuery +" and nb.tanfchildcare='1' ", DataCollectionStage.ANNUAL_ASSESMENT.getCode(), data)));
				Q25hTypeOfNonCashBenefitSourcesTable.setQ25hTANFChildCareServicesLeavers(BigInteger.valueOf(getIncomeCntForVeterans(data.getSchema(), exitQuery +" and nb.tanfchildcare='1' ", DataCollectionStage.EXIT.getCode(), data)));

				Q25hTypeOfNonCashBenefitSourcesTable.setQ25hTANFTransportationServicesAtEntry(BigInteger.valueOf(getIncomeCntForVeterans(data.getSchema(), entryQuery +" and nb.tanftransportation='1' ", DataCollectionStage.ENTRY.getCode(), data)));
				Q25hTypeOfNonCashBenefitSourcesTable.setQ25hTANFTransportationServicesStayers(BigInteger.valueOf(getIncomeCntForVeterans(data.getSchema(), stayersQuery +" and nb.tanftransportation='1' ", DataCollectionStage.ANNUAL_ASSESMENT.getCode(), data)));
				Q25hTypeOfNonCashBenefitSourcesTable.setQ25hTANFTransportationServicesLeavers(BigInteger.valueOf(getIncomeCntForVeterans(data.getSchema(), exitQuery +" and nb.tanftransportation='1' ", DataCollectionStage.EXIT.getCode(), data)));

				Q25hTypeOfNonCashBenefitSourcesTable.setQ25hOtherTANFFundedServicesAtEntry(BigInteger.valueOf(getIncomeCntForVeterans(data.getSchema(), entryQuery +" and nb.othertanf='1' ", DataCollectionStage.ENTRY.getCode(), data)));
				Q25hTypeOfNonCashBenefitSourcesTable.setQ25hOtherTANFFundedServicesStayers(BigInteger.valueOf(getIncomeCntForVeterans(data.getSchema(), stayersQuery +" and nb.othertanf='1' ", DataCollectionStage.ANNUAL_ASSESMENT.getCode(), data)));
				Q25hTypeOfNonCashBenefitSourcesTable.setQ25hOtherTANFFundedServicesLeavers(BigInteger.valueOf(getIncomeCntForVeterans(data.getSchema(), exitQuery +" and nb.othertanf='1' ", DataCollectionStage.EXIT.getCode(), data)));

				Q25hTypeOfNonCashBenefitSourcesTable.setQ25hOtherSourceAtEntry(BigInteger.valueOf(getIncomeCntForVeterans(data.getSchema(), entryQuery +" and nb.othersource='1' ", DataCollectionStage.ENTRY.getCode(), data)));
				Q25hTypeOfNonCashBenefitSourcesTable.setQ25hOtherSourceStayers(BigInteger.valueOf(getIncomeCntForVeterans(data.getSchema(), stayersQuery +" and nb.othersource='1' ", DataCollectionStage.ANNUAL_ASSESMENT.getCode(), data)));
				Q25hTypeOfNonCashBenefitSourcesTable.setQ25hOtherSourceLeavers(BigInteger.valueOf(getIncomeCntForVeterans(data.getSchema(), exitQuery +" and nb.othersource='1' ", DataCollectionStage.EXIT.getCode(), data)));

				}
			}catch(Exception e) {
				logger.error("Error in Q25hBeanMaker:" + e);
			}
				
		return Arrays.asList(Q25hTypeOfNonCashBenefitSourcesTable);
	}
}