package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.servinglynk.report.bean.Q26fClientCashIncomeChronicallyHomelessPersonsDataBean;
import com.servinglynk.report.bean.ReportData;
import com.servinglynk.report.model.EnrollmentModel;
import com.servinglynk.report.model.IncomeAndSourceModel;
import com.servinglynk.report.model.IncomeAndSourceModel;
import com.servinglynk.report.model.NoYesEnum;

public class Q26fClientCashIncomeChronicallyHomelessPersonsDataBeanMaker extends BaseBeanMaker{
	
	public static List<Q26fClientCashIncomeChronicallyHomelessPersonsDataBean> getQ26fClientCashIncomeChronicallyHomelessPersonsList(ReportData data){
		
		Q26fClientCashIncomeChronicallyHomelessPersonsDataBean q18eData = new Q26fClientCashIncomeChronicallyHomelessPersonsDataBean();
		try {
			if(data.isLiveMode()) {
				
				List<EnrollmentModel> chronicHomeLess = data.getChronicHomeLess();
				if(CollectionUtils.isNotEmpty(chronicHomeLess)) {
					return Arrays.asList(q18eData);
				}
				Set<String> veteransDedup = new HashSet<>();
				chronicHomeLess.forEach(client -> veteransDedup.add(client.getDedupClientId()));
				List<IncomeAndSourceModel> incomeEntry = data.getIncomeAndSourcesAtEntry();
				List<IncomeAndSourceModel> incomeAtEntry  = incomeEntry.parallelStream().filter(income -> veteransDedup.contains(income.getDedupClientId())).collect(Collectors.toList());
				List<IncomeAndSourceModel> incomeExit= data.getIncomeAndSourcesAtExit();
				List<IncomeAndSourceModel> incomeAA = data.getIncomeAndSourcesAtAnnualAssesment();
				List<IncomeAndSourceModel> incomeAtExit  = incomeExit.parallelStream().filter(income -> veteransDedup.contains(income.getDedupClientId())).collect(Collectors.toList());
				List<IncomeAndSourceModel> incomeAtAnnualAssesment  = incomeAA.parallelStream().filter(income -> veteransDedup.contains(income.getDedupClientId())).collect(Collectors.toList());
				
						
						q18eData.setQ26fAdultsWithIncomeInfoAtEntryAtEntry(BigInteger.valueOf(getSize(incomeAtEntry)));
						q18eData.setQ26fAdultsWithIncomeInfoAtEntryLeavers(BigInteger.valueOf(getSize(incomeAtExit)));
						q18eData.setQ26fAdultsWithIncomeInfoAtEntryStayers(BigInteger.valueOf(getSize(incomeAtAnnualAssesment)));
						
						List<IncomeAndSourceModel> earnedIncomeAtEntry = incomeAtEntry.parallelStream().filter(income -> getFloat(income.getEarnedamount()) >0 &&  (getFloat(income.getTotalmonthlyincome()) - getFloat(income.getOthersourceamount())) ==0).collect(Collectors.toList());
						List<IncomeAndSourceModel> earnedIncomeAtsAtExit = incomeAtExit.parallelStream().filter(income -> getFloat(income.getEarnedamount()) >0 &&  (getFloat(income.getTotalmonthlyincome()) - getFloat(income.getOthersourceamount())) ==0).collect(Collectors.toList());
						List<IncomeAndSourceModel> earnedIncomeAtAnnualAssesment = incomeAtAnnualAssesment.parallelStream().filter(income -> getFloat(income.getEarnedamount()) >0 &&  (getFloat(income.getTotalmonthlyincome()) - getFloat(income.getOthersourceamount())) ==0).collect(Collectors.toList());
						
						q18eData.setQ26fAdultsWithOnlyEarnedIncomeAtEntry(BigInteger.valueOf(getSize(earnedIncomeAtEntry)));
						q18eData.setQ26fAdultsWithOnlyEarnedIncomeLeavers(BigInteger.valueOf(getSize(earnedIncomeAtsAtExit)));
						q18eData.setQ26fAdultsWithOnlyEarnedIncomeStayers(BigInteger.valueOf(getSize(earnedIncomeAtAnnualAssesment)));
						
						List<IncomeAndSourceModel> bothEarnedAndOtherIncomeAtEntry = incomeAtEntry.parallelStream().filter(income -> getFloat(income.getEarnedamount()) >0 &&  (getFloat(income.getTotalmonthlyincome()) - getFloat(income.getOthersourceamount())) >0).collect(Collectors.toList());
						List<IncomeAndSourceModel> bothEarnedAndOtherIncomeAtsAtExit = incomeAtExit.parallelStream().filter(income -> getFloat(income.getEarnedamount()) >0 &&  (getFloat(income.getTotalmonthlyincome()) - getFloat(income.getOthersourceamount())) >0).collect(Collectors.toList());
						List<IncomeAndSourceModel> bothEarnedAndOtherIncomeAtAnnualAssesment = incomeAtAnnualAssesment.parallelStream().filter(income -> getFloat(income.getEarnedamount()) >0 &&  (getFloat(income.getTotalmonthlyincome()) - getFloat(income.getOthersourceamount())) >0).collect(Collectors.toList());
						
						q18eData.setQ26fAdultsWithBothEarnedAndOtherIncomeAtEntry(BigInteger.valueOf(getSize(bothEarnedAndOtherIncomeAtEntry)));
						q18eData.setQ26fAdultsWithBothEarnedAndOtherIncomeLeavers(BigInteger.valueOf(getSize(bothEarnedAndOtherIncomeAtsAtExit)));
						q18eData.setQ26fAdultsWithBothEarnedAndOtherIncomeStayers(BigInteger.valueOf(getSize(bothEarnedAndOtherIncomeAtAnnualAssesment)));
						
						List<IncomeAndSourceModel> noearnedIncomeAtEntry = incomeAtEntry.parallelStream().filter(income -> getFloat(income.getEarnedamount()) == 0).collect(Collectors.toList());
						List<IncomeAndSourceModel> noearnedIncomeAtExit = incomeAtExit.parallelStream().filter(income -> getFloat(income.getEarnedamount()) == 0).collect(Collectors.toList());
						List<IncomeAndSourceModel> noearnedIncomeAtAnnualAssesment = incomeAtAnnualAssesment.parallelStream().filter(income -> getFloat(income.getEarnedamount()) == 0).collect(Collectors.toList());			
						
						List<IncomeAndSourceModel> otherIncomeAtEntry = noearnedIncomeAtEntry.parallelStream().filter(income ->  ((getFloat(income.getTotalmonthlyincome()) - getFloat(income.getOthersourceamount())) > 0)).collect(Collectors.toList());
						List<IncomeAndSourceModel> otherIncomeAtsAtExit = noearnedIncomeAtExit.parallelStream().filter(income ->  ((getFloat(income.getTotalmonthlyincome()) - getFloat(income.getOthersourceamount())) > 0)).collect(Collectors.toList());
						List<IncomeAndSourceModel> otherIncomeAtAnnualAssesment = noearnedIncomeAtAnnualAssesment.parallelStream().filter(income ->  ((getFloat(income.getTotalmonthlyincome()) - getFloat(income.getOthersourceamount())) > 0)).collect(Collectors.toList());
						

						q18eData.setQ26fAdultsWithOnlyOtherIncomeAtEntry(BigInteger.valueOf(getSize(otherIncomeAtEntry)));
						q18eData.setQ26fAdultsWithOnlyOtherIncomeLeavers(BigInteger.valueOf(getSize(otherIncomeAtsAtExit)));
						q18eData.setQ26fAdultsWithOnlyOtherIncomeStayers(BigInteger.valueOf(getSize(otherIncomeAtAnnualAssesment)));
						
						List<IncomeAndSourceModel> dkIncomeAtEntry = incomeAtEntry.parallelStream().filter(income -> income != null && ( StringUtils.equals(NoYesEnum.EIGHT.getValue(), income.getIncomefromanysource()) || StringUtils.equals(NoYesEnum.NINE.getValue(), income.getIncomefromanysource())) ).collect(Collectors.toList());
						List<IncomeAndSourceModel> dkIncomeAtsAtExit = incomeAtExit.parallelStream().filter(income -> income != null && ( StringUtils.equals(NoYesEnum.EIGHT.getValue(), income.getIncomefromanysource()) || StringUtils.equals(NoYesEnum.NINE.getValue(), income.getIncomefromanysource())) ).collect(Collectors.toList());
						List<IncomeAndSourceModel> dkIncomeAtAnnualAssesment = incomeAtAnnualAssesment.parallelStream().filter(income -> income != null && ( StringUtils.equals(NoYesEnum.EIGHT.getValue(), income.getIncomefromanysource()) || StringUtils.equals(NoYesEnum.NINE.getValue(), income.getIncomefromanysource())) ).collect(Collectors.toList());

						q18eData.setQ26fAdultsWithDontRefusedIncomeAtEntry(BigInteger.valueOf(dkIncomeAtEntry != null ? dkIncomeAtEntry.size(): 0));
						q18eData.setQ26fAdultsWithDontRefusedIncomeLeavers(BigInteger.valueOf(dkIncomeAtsAtExit != null ? dkIncomeAtsAtExit.size() : 0));
						q18eData.setQ26fAdultsWithDontRefusedIncomeStayers(BigInteger.valueOf(dkIncomeAtAnnualAssesment  != null ? dkIncomeAtAnnualAssesment.size() : 0));
						
						List<IncomeAndSourceModel> missingIncomeAtEntry = incomeAtEntry.parallelStream().filter(income -> income != null && ( StringUtils.equals(NoYesEnum.NINTY_NINE.getValue(), income.getIncomefromanysource()) )).collect(Collectors.toList());
						List<IncomeAndSourceModel> missingIncomeAtsAtExit = incomeAtExit.parallelStream().filter(income -> income != null && ( StringUtils.equals(NoYesEnum.NINTY_NINE.getValue(), income.getIncomefromanysource()) )).collect(Collectors.toList());
						List<IncomeAndSourceModel> missingIncomeAtAnnualAssesment = incomeAtAnnualAssesment.parallelStream().filter(income -> income != null && ( StringUtils.equals(NoYesEnum.NINTY_NINE.getValue(), income.getIncomefromanysource()) )).collect(Collectors.toList());
						
					
						q18eData.setQ26fAdultsWithMissingIncomeInfoAtEntry(BigInteger.valueOf(missingIncomeAtEntry != null ? missingIncomeAtEntry .size() :0));
						q18eData.setQ26fAdultsWithMissingIncomeInfoLeavers(BigInteger.valueOf(missingIncomeAtsAtExit != null ? missingIncomeAtsAtExit.size() :0 ));
						q18eData.setQ26fAdultsWithMissingIncomeInfoStayers(BigInteger.valueOf(missingIncomeAtAnnualAssesment != null ? missingIncomeAtAnnualAssesment.size() :0));
						
						List<IncomeAndSourceModel> noIncomeAtEntry = incomeAtEntry.parallelStream().filter(income -> getFloat(income.getTotalmonthlyincome()) ==0 ).collect(Collectors.toList());
						List<IncomeAndSourceModel> noIncomeAtsAtExit = incomeAtExit.parallelStream().filter(income -> getFloat(income.getTotalmonthlyincome()) ==0).collect(Collectors.toList());
						List<IncomeAndSourceModel> noIncomeAtAnnualAssesment = incomeAtAnnualAssesment.parallelStream().filter(income -> getFloat(income.getTotalmonthlyincome()) ==0).collect(Collectors.toList());
						
						
						q18eData.setQ26fAdultsWithNoIncomeAtEntry(BigInteger.valueOf(noIncomeAtEntry !=null ? noIncomeAtEntry.size() :0));
						q18eData.setQ26fAdultsWithNoIncomeLeavers(BigInteger.valueOf(noIncomeAtsAtExit != null ? noIncomeAtsAtExit.size() :0 ));
						q18eData.setQ26fAdultsWithNoIncomeStayers(BigInteger.valueOf(noIncomeAtAnnualAssesment != null ? noIncomeAtAnnualAssesment.size() :0));
						
						
					
						q18eData.setQ26fNumberOfAdultStayersNotYetRequiredAtEntry(BigInteger.valueOf(0));
						q18eData.setQ26fNumberOfAdultStayersNotYetRequiredLeavers(BigInteger.valueOf(0));
						q18eData.setQ26fNumberOfAdultStayersNotYetRequiredStayers(data.getNumOfAdultStayersNotRequiredAnnualAssesment());
						
						q18eData.setQ26fNumberOfAdultStayersWithoutRequiredAtEntry(BigInteger.valueOf(0));
						q18eData.setQ26fNumberOfAdultStayersWithoutRequiredLeavers(BigInteger.valueOf(0));
						q18eData.setQ26fNumberOfAdultStayersWithoutRequiredStayers(data.getNumOfAdultStayersWithoutRequiredAnnualAssesment());
						
						
						q18eData.setQ26fTotalAdultsAtEntry(BigInteger.valueOf(getSize(data.getChronicHomeLess())));
						q18eData.setQ26fTotalAdultsLeavers(data.getTotNoOfAdultLeavers());
						q18eData.setQ26fTotalAdultsStayers(data.getTotNoOfAdultStayers());
						
						List<IncomeAndSourceModel> oneOrMoreIncomeAtEntry = incomeAtEntry.parallelStream().filter(income -> getFloat(income.getTotalmonthlyincome()) >0 ).collect(Collectors.toList());
						List<IncomeAndSourceModel> oneOrMoreIncomeAtsAtExit = incomeAtExit.parallelStream().filter(income -> getFloat(income.getTotalmonthlyincome()) >0).collect(Collectors.toList());
						List<IncomeAndSourceModel> oneOrMoreIncomeAtAnnualAssesment = incomeAtAnnualAssesment.parallelStream().filter(income -> getFloat(income.getTotalmonthlyincome()) >0).collect(Collectors.toList());
						
						q18eData.setQ26f1OrMoreSourceOfIncomeAtEntry(BigInteger.valueOf(oneOrMoreIncomeAtEntry != null ? oneOrMoreIncomeAtEntry.size() :0));
						q18eData.setQ26f1OrMoreSourceOfIncomeLeavers(BigInteger.valueOf(oneOrMoreIncomeAtsAtExit != null ? oneOrMoreIncomeAtsAtExit.size() :0));
						q18eData.setQ26f1OrMoreSourceOfIncomeStayers(BigInteger.valueOf(oneOrMoreIncomeAtAnnualAssesment != null ? oneOrMoreIncomeAtAnnualAssesment.size() :0));
						
					}
					} catch (Exception e) {
							logger.error("Error in Q26fBeanMaker:" + e);
						}
						return Arrays.asList(q18eData);
					}
				
				}
