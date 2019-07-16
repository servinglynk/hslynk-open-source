package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.servinglynk.report.bean.Q25fCashIncomeCategoryIncomeCategoryByEntryDataBean;
import com.servinglynk.report.bean.ReportData;
import com.servinglynk.report.model.ClientModel;
import com.servinglynk.report.model.IncomeAndSourceModel;
import com.servinglynk.report.model.NoYesEnum;

public class Q25fCashIncomeCategoryIncomeCategoryByEntryDataBeanMaker extends BaseBeanMaker {
	
	public static List<Q25fCashIncomeCategoryIncomeCategoryByEntryDataBean> getQ25fCashIncomeCategoryIncomeCategoryByEntryList(ReportData data){
		
		Q25fCashIncomeCategoryIncomeCategoryByEntryDataBean q25eData = new Q25fCashIncomeCategoryIncomeCategoryByEntryDataBean();
		
		if(data.isLiveMode()) {
			try {
		
				List<ClientModel> veterans = data.getVeterans();
				if(CollectionUtils.isNotEmpty(veterans)) {
					return Arrays.asList(q25eData);
				}
				Set<String> veteransDedup = new HashSet<>();
				veterans.forEach(client -> veteransDedup.add(client.getDedupClientId()));
				List<IncomeAndSourceModel> incomeEntry = data.getIncomeAndSourcesAtEntry();
				List<IncomeAndSourceModel> incomeAtEntry  = incomeEntry.parallelStream().filter(income -> veteransDedup.contains(income.getDedupClientId())).collect(Collectors.toList());
				List<IncomeAndSourceModel> incomeExit= data.getIncomeAndSourcesAtExit();
				List<IncomeAndSourceModel> incomeAA = data.getIncomeAndSourcesAtAnnualAssesment();
				List<IncomeAndSourceModel> incomeAtExit  = incomeExit.parallelStream().filter(income -> veteransDedup.contains(income.getDedupClientId())).collect(Collectors.toList());
				List<IncomeAndSourceModel> incomeAtAnnualAssesment  = incomeAA.parallelStream().filter(income -> veteransDedup.contains(income.getDedupClientId())).collect(Collectors.toList());
				
			q25eData.setQ25fAdultsWithIncomeInfoAtEntry(BigInteger.valueOf(getIncomeCnt(incomeAtEntry)));
			q25eData.setQ25fAdultsWithIncomeInfoLeavers(BigInteger.valueOf(getIncomeCnt(incomeAtExit)));
			q25eData.setQ25fAdultsWithIncomeInfoStayers(BigInteger.valueOf(getIncomeCnt(incomeAtAnnualAssesment)));
			
			List<IncomeAndSourceModel> earnedIncomeAtEntry = incomeAtEntry.parallelStream().filter(income -> getFloat(income.getEarnedamount()) ==0).collect(Collectors.toList());
			List<IncomeAndSourceModel> earnedIncomeAtsAtExit = incomeAtExit.parallelStream().filter(income -> getFloat(income.getEarnedamount()) >0 &&  getFloat(income.getOthersourceamount()) ==0).collect(Collectors.toList());
			List<IncomeAndSourceModel> earnedIncomeAtAnnualAssesment = incomeAtAnnualAssesment.parallelStream().filter(income -> getFloat(income.getEarnedamount()) >0 &&  getFloat(income.getOthersourceamount()) ==0).collect(Collectors.toList());
			
			q25eData.setQ25fAdultsWithOnlyEarnedIncomeAtEntry(BigInteger.valueOf(getIncomeCnt(earnedIncomeAtEntry)));
			q25eData.setQ25fAdultsWithOnlyEarnedIncomeLeavers(BigInteger.valueOf(getIncomeCnt(earnedIncomeAtsAtExit)));
			q25eData.setQ25fAdultsWithOnlyEarnedIncomeStayers(BigInteger.valueOf(getIncomeCnt(earnedIncomeAtAnnualAssesment)));
			
			List<IncomeAndSourceModel> bothEarnedAndOtherIncomeAtEntry = incomeAtEntry.parallelStream().filter(income -> getFloat(income.getEarnedamount()) >0 &&  getFloat(income.getOthersourceamount()) >0).collect(Collectors.toList());
			List<IncomeAndSourceModel> bothEarnedAndOtherIncomeAtsAtExit = incomeAtExit.parallelStream().filter(income -> getFloat(income.getEarnedamount()) >0 &&  getFloat(income.getOthersourceamount()) >0).collect(Collectors.toList());
			List<IncomeAndSourceModel> bothEarnedAndOtherIncomeAtAnnualAssesment = incomeAtAnnualAssesment.parallelStream().filter(income -> getFloat(income.getEarnedamount()) >0 &&  getFloat(income.getOthersourceamount()) >0).collect(Collectors.toList());
			
			q25eData.setQ25fAdultsWithBothEarnedAndOtherAtEntry(BigInteger.valueOf(getIncomeCnt(bothEarnedAndOtherIncomeAtEntry)));
			q25eData.setQ25fAdultsWithBothEarnedAndOtherLeavers(BigInteger.valueOf(getIncomeCnt(bothEarnedAndOtherIncomeAtsAtExit)));
			q25eData.setQ25fAdultsWithBothEarnedAndOtherStayers(BigInteger.valueOf(getIncomeCnt(bothEarnedAndOtherIncomeAtAnnualAssesment)));
			
			List<IncomeAndSourceModel> noearnedIncomeAtEntry = incomeAtEntry.parallelStream().filter(income -> getFloat(income.getEarnedamount()) == 0).collect(Collectors.toList());
			List<IncomeAndSourceModel> noearnedIncomeAtExit = incomeAtExit.parallelStream().filter(income -> getFloat(income.getEarnedamount()) == 0).collect(Collectors.toList());
			List<IncomeAndSourceModel> noearnedIncomeAtAnnualAssesment = incomeAtAnnualAssesment.parallelStream().filter(income -> getFloat(income.getEarnedamount()) == 0).collect(Collectors.toList());			
			
			
			List<IncomeAndSourceModel> otherIncomeAtEntry = noearnedIncomeAtEntry.parallelStream().filter(income -> getFloat(income.getOthersourceamount()) > 0).collect(Collectors.toList());
			List<IncomeAndSourceModel> otherIncomeAtsAtExit = noearnedIncomeAtExit.parallelStream().filter(income -> getFloat(income.getOthersourceamount()) > 0).collect(Collectors.toList());
			List<IncomeAndSourceModel> otherIncomeAtAnnualAssesment = noearnedIncomeAtAnnualAssesment.parallelStream().filter(income -> getFloat(income.getOthersourceamount()) > 0).collect(Collectors.toList());			
			
			

			q25eData.setQ25fAdultsWithOnlyOtherIncomeAtEntry(BigInteger.valueOf(getIncomeCnt(otherIncomeAtEntry)));
			q25eData.setQ25fAdultsWithOnlyOtherIncomeLeavers(BigInteger.valueOf(getIncomeCnt(otherIncomeAtsAtExit)));
			q25eData.setQ25fAdultsWithOnlyOtherIncomeStayers(BigInteger.valueOf(getIncomeCnt(otherIncomeAtAnnualAssesment)));
			
			List<IncomeAndSourceModel> dkIncomeAtEntry = incomeAtEntry.parallelStream().filter(income -> income != null && ( StringUtils.equals(NoYesEnum.EIGHT.getValue(), income.getIncomefromanysource()) || StringUtils.equals(NoYesEnum.NINE.getValue(), income.getIncomefromanysource())) ).collect(Collectors.toList());
			List<IncomeAndSourceModel> dkIncomeAtsAtExit = incomeAtExit.parallelStream().filter(income -> income != null && ( StringUtils.equals(NoYesEnum.EIGHT.getValue(), income.getIncomefromanysource()) || StringUtils.equals(NoYesEnum.NINE.getValue(), income.getIncomefromanysource())) ).collect(Collectors.toList());
			List<IncomeAndSourceModel> dkIncomeAtAnnualAssesment = incomeAtAnnualAssesment.parallelStream().filter(income -> income != null && ( StringUtils.equals(NoYesEnum.EIGHT.getValue(), income.getIncomefromanysource()) || StringUtils.equals(NoYesEnum.NINE.getValue(), income.getIncomefromanysource())) ).collect(Collectors.toList());

			q25eData.setQ25fAdultsWithDontRefusedIncomeAtEntry(BigInteger.valueOf(dkIncomeAtEntry != null ? dkIncomeAtEntry.size(): 0));
			q25eData.setQ25fAdultsWithDontRefusedIncomeLeavers(BigInteger.valueOf(dkIncomeAtsAtExit != null ? dkIncomeAtsAtExit.size() : 0));
			q25eData.setQ25fAdultsWithDontRefusedIncomeStayers(BigInteger.valueOf(dkIncomeAtAnnualAssesment  != null ? dkIncomeAtAnnualAssesment.size() : 0));
			
			List<IncomeAndSourceModel> missingIncomeAtEntry = incomeAtEntry.parallelStream().filter(income -> income != null && ( StringUtils.equals(NoYesEnum.NINTY_NINE.getValue(), income.getIncomefromanysource()) )).collect(Collectors.toList());
			List<IncomeAndSourceModel> missingIncomeAtsAtExit = incomeAtExit.parallelStream().filter(income -> income != null && ( StringUtils.equals(NoYesEnum.NINTY_NINE.getValue(), income.getIncomefromanysource()) )).collect(Collectors.toList());
			List<IncomeAndSourceModel> missingIncomeAtAnnualAssesment = incomeAtAnnualAssesment.parallelStream().filter(income -> income != null && ( StringUtils.equals(NoYesEnum.NINTY_NINE.getValue(), income.getIncomefromanysource()) )).collect(Collectors.toList());
			
		
			q25eData.setQ25fAdultsWithMissingInomeInfoAtEntry(BigInteger.valueOf(missingIncomeAtEntry != null ? missingIncomeAtEntry .size() :0));
			q25eData.setQ25fAdultsWithMissingInomeInfoLeavers(BigInteger.valueOf(missingIncomeAtsAtExit != null ? missingIncomeAtsAtExit.size() :0 ));
			q25eData.setQ25fAdultsWithMissingInomeInfoStayers(BigInteger.valueOf(missingIncomeAtAnnualAssesment != null ? missingIncomeAtAnnualAssesment.size() :0));
			
			List<IncomeAndSourceModel> noIncomeAtEntry = incomeAtEntry.parallelStream().filter(income -> getFloat(income.getTotalmonthlyincome()) ==0 ).collect(Collectors.toList());
			List<IncomeAndSourceModel> noIncomeAtsAtExit = incomeAtExit.parallelStream().filter(income -> getFloat(income.getTotalmonthlyincome()) ==0).collect(Collectors.toList());
			List<IncomeAndSourceModel> noIncomeAtAnnualAssesment = incomeAtAnnualAssesment.parallelStream().filter(income -> getFloat(income.getTotalmonthlyincome()) ==0).collect(Collectors.toList());
			
			
			q25eData.setQ25fAdultsWithNoIncomeAtEntry(BigInteger.valueOf(noIncomeAtEntry !=null ? noIncomeAtEntry.size() :0));
			q25eData.setQ25fAdultsWithNoIncomeLeavers(BigInteger.valueOf(noIncomeAtsAtExit != null ? noIncomeAtsAtExit.size() :0 ));
			q25eData.setQ25fAdultsWithNoIncomeStayers(BigInteger.valueOf(noIncomeAtAnnualAssesment != null ? noIncomeAtAnnualAssesment.size() :0));
			
			
		
			q25eData.setQ25fNumberOfAdultStayersNotYetRequiredAtEntry(BigInteger.valueOf(0));
			q25eData.setQ25fNumberOfAdultStayersNotYetRequiredLeavers(BigInteger.valueOf(0));
			q25eData.setQ25fNumberOfAdultStayersNotYetRequiredStayers(data.getNumOfAdultStayersNotRequiredAnnualAssesment());
			
			q25eData.setQ25fNumberOfAdultStayersWithoutRequiredAtEntry(BigInteger.valueOf(0));
			q25eData.setQ25fNumberOfAdultStayersWithoutRequiredLeavers(BigInteger.valueOf(0));
			q25eData.setQ25fNumberOfAdultStayersWithoutRequiredStayers(data.getNumOfAdultStayersWithoutRequiredAnnualAssesment());
			
			
			q25eData.setQ25fTotalAdultsAtEntry(BigInteger.valueOf(getSize(data.getVeterans())));
			q25eData.setQ25fTotalAdultsLeavers(data.getTotNoOfAdultLeavers());
			q25eData.setQ25fTotalAdultsStayers(data.getTotNoOfAdultStayers());
			
			List<IncomeAndSourceModel> oneOrMoreIncomeAtEntry = incomeAtEntry.parallelStream().filter(income -> getFloat(income.getTotalmonthlyincome()) >0 ).collect(Collectors.toList());
			List<IncomeAndSourceModel> oneOrMoreIncomeAtsAtExit = incomeAtExit.parallelStream().filter(income -> getFloat(income.getTotalmonthlyincome()) >0).collect(Collectors.toList());
			List<IncomeAndSourceModel> oneOrMoreIncomeAtAnnualAssesment = incomeAtAnnualAssesment.parallelStream().filter(income -> getFloat(income.getTotalmonthlyincome()) >0).collect(Collectors.toList());
			
			q25eData.setQ25f1OrMoreSourceOfIncomeAtEntry(BigInteger.valueOf(oneOrMoreIncomeAtEntry != null ? oneOrMoreIncomeAtEntry.size() :0));
			q25eData.setQ25f1OrMoreSourceOfIncomeLeavers(BigInteger.valueOf(oneOrMoreIncomeAtsAtExit != null ? oneOrMoreIncomeAtsAtExit.size() :0));
			q25eData.setQ25f1OrMoreSourceOfIncomeStayers(BigInteger.valueOf(oneOrMoreIncomeAtAnnualAssesment != null ? oneOrMoreIncomeAtAnnualAssesment.size() :0));
			} catch (Exception e) {
				logger.error("Error in Q25fBeanMaker:" + e);
			}
			}
			return Arrays.asList(q25eData);
		}
		
	}