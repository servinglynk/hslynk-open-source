package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import com.servinglynk.report.bean.ClientModel;
import com.servinglynk.report.bean.Q25fCashIncomeCategoryIncomeCategoryByEntryDataBean;
import com.servinglynk.report.bean.ReportData;

public class Q25fCashIncomeCategoryIncomeCategoryByEntryDataBeanMaker {
	
	public static List<Q25fCashIncomeCategoryIncomeCategoryByEntryDataBean> getQ25fCashIncomeCategoryIncomeCategoryByEntryList(ReportData data){
		
		List<ClientModel> clients = data.getClients();
		List<ClientModel> veterans = clients.parallelStream().filter(client -> StringUtils.equals("1",client.getVeteran_status())).collect(Collectors.toList());
		
		Q25fCashIncomeCategoryIncomeCategoryByEntryDataBean q25fCashIncomeCategoryIncomeCategoryByEntryTable = new Q25fCashIncomeCategoryIncomeCategoryByEntryDataBean();
		
				q25fCashIncomeCategoryIncomeCategoryByEntryTable.setQ25fAdultsWithOnlyEarnedIncomeAtEntry(BigInteger.valueOf(0));
				q25fCashIncomeCategoryIncomeCategoryByEntryTable.setQ25fAdultsWithOnlyEarnedIncomeStayers(BigInteger.valueOf(0));
				q25fCashIncomeCategoryIncomeCategoryByEntryTable.setQ25fAdultsWithOnlyEarnedIncomeLeavers(BigInteger.valueOf(0));

				q25fCashIncomeCategoryIncomeCategoryByEntryTable.setQ25fAdultsWithOnlyOtherIncomeAtEntry(BigInteger.valueOf(0));
				q25fCashIncomeCategoryIncomeCategoryByEntryTable.setQ25fAdultsWithOnlyOtherIncomeStayers(BigInteger.valueOf(0));
				q25fCashIncomeCategoryIncomeCategoryByEntryTable.setQ25fAdultsWithOnlyOtherIncomeLeavers(BigInteger.valueOf(0));

				q25fCashIncomeCategoryIncomeCategoryByEntryTable.setQ25fAdultsWithBothEarnedAndOtherAtEntry(BigInteger.valueOf(0));
				q25fCashIncomeCategoryIncomeCategoryByEntryTable.setQ25fAdultsWithBothEarnedAndOtherStayers(BigInteger.valueOf(0));
				q25fCashIncomeCategoryIncomeCategoryByEntryTable.setQ25fAdultsWithBothEarnedAndOtherLeavers(BigInteger.valueOf(0));

				q25fCashIncomeCategoryIncomeCategoryByEntryTable.setQ25fAdultsWithNoIncomeAtEntry(BigInteger.valueOf(0));
				q25fCashIncomeCategoryIncomeCategoryByEntryTable.setQ25fAdultsWithNoIncomeStayers(BigInteger.valueOf(0));
				q25fCashIncomeCategoryIncomeCategoryByEntryTable.setQ25fAdultsWithNoIncomeLeavers(BigInteger.valueOf(0));

				q25fCashIncomeCategoryIncomeCategoryByEntryTable.setQ25fAdultsWithDontRefusedIncomeAtEntry(BigInteger.valueOf(0));
				q25fCashIncomeCategoryIncomeCategoryByEntryTable.setQ25fAdultsWithDontRefusedIncomeStayers(BigInteger.valueOf(0));
				q25fCashIncomeCategoryIncomeCategoryByEntryTable.setQ25fAdultsWithDontRefusedIncomeLeavers(BigInteger.valueOf(0));

				q25fCashIncomeCategoryIncomeCategoryByEntryTable.setQ25fAdultsWithMissingInomeInfoAtEntry(BigInteger.valueOf(0));
				q25fCashIncomeCategoryIncomeCategoryByEntryTable.setQ25fAdultsWithMissingInomeInfoStayers(BigInteger.valueOf(0));
				q25fCashIncomeCategoryIncomeCategoryByEntryTable.setQ25fAdultsWithMissingInomeInfoLeavers(BigInteger.valueOf(0));

				q25fCashIncomeCategoryIncomeCategoryByEntryTable.setQ25fNumberOfAdultStayersNotYetRequiredAtEntry(BigInteger.valueOf(0));
				q25fCashIncomeCategoryIncomeCategoryByEntryTable.setQ25fNumberOfAdultStayersNotYetRequiredStayers(BigInteger.valueOf(0));
				q25fCashIncomeCategoryIncomeCategoryByEntryTable.setQ25fNumberOfAdultStayersNotYetRequiredLeavers(BigInteger.valueOf(0));

				q25fCashIncomeCategoryIncomeCategoryByEntryTable.setQ25fNumberOfAdultStayersWithoutRequiredAtEntry(BigInteger.valueOf(0));
				q25fCashIncomeCategoryIncomeCategoryByEntryTable.setQ25fNumberOfAdultStayersWithoutRequiredStayers(BigInteger.valueOf(0));
				q25fCashIncomeCategoryIncomeCategoryByEntryTable.setQ25fNumberOfAdultStayersWithoutRequiredLeavers(BigInteger.valueOf(0));

				q25fCashIncomeCategoryIncomeCategoryByEntryTable.setQ25fTotalAdultsAtEntry(BigInteger.valueOf(veterans !=null ? veterans.size() : 0));
				q25fCashIncomeCategoryIncomeCategoryByEntryTable.setQ25fTotalAdultsStayers(BigInteger.valueOf(0));
				q25fCashIncomeCategoryIncomeCategoryByEntryTable.setQ25fTotalAdultsLeavers(BigInteger.valueOf(0));

				q25fCashIncomeCategoryIncomeCategoryByEntryTable.setQ25f1OrMoreSourceOfIncomeAtEntry(BigInteger.valueOf(0));
				q25fCashIncomeCategoryIncomeCategoryByEntryTable.setQ25f1OrMoreSourceOfIncomeStayers(BigInteger.valueOf(0));
				q25fCashIncomeCategoryIncomeCategoryByEntryTable.setQ25f1OrMoreSourceOfIncomeLeavers(BigInteger.valueOf(0));

				q25fCashIncomeCategoryIncomeCategoryByEntryTable.setQ25fAdultsWithIncomeInfoAtEntry(BigInteger.valueOf(0));
				q25fCashIncomeCategoryIncomeCategoryByEntryTable.setQ25fAdultsWithIncomeInfoStayers(BigInteger.valueOf(0));
				q25fCashIncomeCategoryIncomeCategoryByEntryTable.setQ25fAdultsWithIncomeInfoLeavers(BigInteger.valueOf(0));
						

		
		return Arrays.asList(q25fCashIncomeCategoryIncomeCategoryByEntryTable); 
	}

}
