package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import com.servinglynk.report.bean.Q26hTypeOfNonCashIncomeSourcesChronicallyHomelessDataBean;
import com.servinglynk.report.bean.ReportData;
import com.servinglynk.report.model.DataCollectionStage;

public class Q26hTypeOfNonCashIncomeSourcesChronicallyHomelessDataBeanMaker extends BaseBeanMaker {
	
	public static List<Q26hTypeOfNonCashIncomeSourcesChronicallyHomelessDataBean> getQ26hTypeOfNonCashIncomeSourcesChronicallyHomelessList(ReportData data){
		
		Q26hTypeOfNonCashIncomeSourcesChronicallyHomelessDataBean q26hTypeOfNonCashIncomeSourcesChronicallyHomelessTable = new Q26hTypeOfNonCashIncomeSourcesChronicallyHomelessDataBean();
		
		
		/********
		 * Any changes here needs change to Q26h
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
				q26hTypeOfNonCashIncomeSourcesChronicallyHomelessTable.setQ26hSupplementalNutritionalATANFChildCareServicesstanceAtEntry(BigInteger.valueOf(getIncomeCntForVeterans(data.getSchema(),entryQuery +" and nb.snap='1' ", DataCollectionStage.ENTRY.getCode(), data)));
				q26hTypeOfNonCashIncomeSourcesChronicallyHomelessTable.setQ26hSupplementalNutritionalATANFChildCareServicesstanceStayers(BigInteger.valueOf(getIncomeCntForVeterans(data.getSchema(), stayersQuery +" and nb.snap='1' ", DataCollectionStage.ANNUAL_ASSESMENT.getCode(), data)));
				q26hTypeOfNonCashIncomeSourcesChronicallyHomelessTable.setQ26hSupplementalNutritionalATANFChildCareServicesstanceLeavers(BigInteger.valueOf(getIncomeCntForVeterans(data.getSchema(), exitQuery +" and nb.snap='1' ", DataCollectionStage.EXIT.getCode(), data)));

				q26hTypeOfNonCashIncomeSourcesChronicallyHomelessTable.setQ26hWICAtEntry(BigInteger.valueOf(getIncomeCntForVeterans(data.getSchema(), entryQuery +" and nb.wic='1' ", DataCollectionStage.ENTRY.getCode(), data)));
				q26hTypeOfNonCashIncomeSourcesChronicallyHomelessTable.setQ26hWICStayers(BigInteger.valueOf(getIncomeCntForVeterans(data.getSchema(), stayersQuery +" and nb.wic='1' ", DataCollectionStage.ANNUAL_ASSESMENT.getCode(), data)));
				q26hTypeOfNonCashIncomeSourcesChronicallyHomelessTable.setQ26hWICLeavers(BigInteger.valueOf(getIncomeCntForVeterans(data.getSchema(), exitQuery +" and  nb.wic='1' ", DataCollectionStage.EXIT.getCode(), data)));

				q26hTypeOfNonCashIncomeSourcesChronicallyHomelessTable.setQ26hTANFChildCareServicesAtEntry(BigInteger.valueOf(getIncomeCntForVeterans(data.getSchema(), entryQuery +" and nb.tanfchildcare='1' ", DataCollectionStage.ENTRY.getCode(), data)));
				q26hTypeOfNonCashIncomeSourcesChronicallyHomelessTable.setQ26hTANFChildCareServicesStayers(BigInteger.valueOf(getIncomeCntForVeterans(data.getSchema(), stayersQuery +" and nb.tanfchildcare='1' ", DataCollectionStage.ANNUAL_ASSESMENT.getCode(), data)));
				q26hTypeOfNonCashIncomeSourcesChronicallyHomelessTable.setQ26hTANFChildCareServicesLeavers(BigInteger.valueOf(getIncomeCntForVeterans(data.getSchema(), exitQuery +" and nb.tanfchildcare='1' ", DataCollectionStage.EXIT.getCode(), data)));

				q26hTypeOfNonCashIncomeSourcesChronicallyHomelessTable.setQ26hTANFTransportationServicesAtEntry(BigInteger.valueOf(getIncomeCntForVeterans(data.getSchema(), entryQuery +" and nb.tanftransportation='1' ", DataCollectionStage.ENTRY.getCode(), data)));
				q26hTypeOfNonCashIncomeSourcesChronicallyHomelessTable.setQ26hTANFTransportationServicesStayers(BigInteger.valueOf(getIncomeCntForVeterans(data.getSchema(), stayersQuery +" and nb.tanftransportation='1' ", DataCollectionStage.ANNUAL_ASSESMENT.getCode(), data)));
				q26hTypeOfNonCashIncomeSourcesChronicallyHomelessTable.setQ26hTANFTransportationServicesLeavers(BigInteger.valueOf(getIncomeCntForVeterans(data.getSchema(), exitQuery +" and nb.tanftransportation='1' ", DataCollectionStage.EXIT.getCode(), data)));

				q26hTypeOfNonCashIncomeSourcesChronicallyHomelessTable.setQ26hOtherTANFFundedServicesAtEntry(BigInteger.valueOf(getIncomeCntForVeterans(data.getSchema(), entryQuery +" and nb.othertanf='1' ", DataCollectionStage.ENTRY.getCode(), data)));
				q26hTypeOfNonCashIncomeSourcesChronicallyHomelessTable.setQ26hOtherTANFFundedServicesStayers(BigInteger.valueOf(getIncomeCntForVeterans(data.getSchema(), stayersQuery +" and nb.othertanf='1' ", DataCollectionStage.ANNUAL_ASSESMENT.getCode(), data)));
				q26hTypeOfNonCashIncomeSourcesChronicallyHomelessTable.setQ26hOtherTANFFundedServicesLeavers(BigInteger.valueOf(getIncomeCntForVeterans(data.getSchema(), exitQuery +" and nb.othertanf='1' ", DataCollectionStage.EXIT.getCode(), data)));

				q26hTypeOfNonCashIncomeSourcesChronicallyHomelessTable.setQ26hOtherSourceAtEntry(BigInteger.valueOf(getIncomeCntForVeterans(data.getSchema(), entryQuery +" and nb.othersource='1' ", DataCollectionStage.ENTRY.getCode(), data)));
				q26hTypeOfNonCashIncomeSourcesChronicallyHomelessTable.setQ26hOtherSourceStayers(BigInteger.valueOf(getIncomeCntForVeterans(data.getSchema(), stayersQuery +" and nb.othersource='1' ", DataCollectionStage.ANNUAL_ASSESMENT.getCode(), data)));
				q26hTypeOfNonCashIncomeSourcesChronicallyHomelessTable.setQ26hOtherSourceLeavers(BigInteger.valueOf(getIncomeCntForVeterans(data.getSchema(), exitQuery +" and nb.othersource='1' ", DataCollectionStage.EXIT.getCode(), data)));
	}
			}catch(Exception e) {
				logger.error("Error in Q26hBeanMaker:" + e);
			}
				
		return Arrays.asList(q26hTypeOfNonCashIncomeSourcesChronicallyHomelessTable);
	}
}