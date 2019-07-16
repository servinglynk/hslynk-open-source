package com.servinglynk.report.business;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import com.servinglynk.hive.connection.ImpalaConnection;
import com.servinglynk.report.bean.Q16CashIncomeRangesDataBean;
import com.servinglynk.report.bean.ReportData;
import com.servinglynk.report.model.DataCollectionStage;
import com.servinglynk.report.model.IncomeAndSourceModel;

public class Q16BeanMaker extends BaseBeanMaker {
	
	public static List<Q16CashIncomeRangesDataBean> getQ16CashIncomeRangesList(ReportData data) {
		
		Q16CashIncomeRangesDataBean q16Bean = new Q16CashIncomeRangesDataBean();
		if(data.isLiveMode()) {
		try {
			List<IncomeAndSourceModel> incomeAndSourcesAtEntry = data.getIncomeAndSourcesAtEntry();
			Map<String, Integer> incomeEntries = getIncome(incomeAndSourcesAtEntry);
		    Collection<Integer> incomeAtEntry = incomeEntries.values();
		    List<IncomeAndSourceModel> incomeAndSourcesAtExit = data.getIncomeAndSourcesAtExit();
		    List<IncomeAndSourceModel> incomeAndSourcesAtAnnualAssesment = data.getIncomeAndSourcesAtAnnualAssesment();
		
		

		String notRequiredAnnualAssesment = "select  count(distinct(dedup_client_id))  as cnt from %s.incomeandsources i, %s.enrollment e where "+
				"   i.information_date >= e.entrydate and e.entrydate <= :startDate   and e.ageatentry >=18 "+
				" and   e.id not in ( select enrollmentid from %s.exit  where  exitdate <= :endDate )  "+
				" and   e.id in ( select enrollmentid from %s.enrollment_coc where datacollectionstage='5' and datediff(now(),information_date) > 365 )    ";
		
		String withOutRequiredAnnualAssesment = "select  count(distinct(dedup_client_id))  as cnt from %s.incomeandsources i, %s.enrollment e where "+
				"   i.information_date >= e.entrydate and e.entrydate <= :startDate   and e.ageatentry >=18 "+
				" and   e.id not in ( select enrollmentid from %s.exit  where  exitdate >= :endDate )  "+
				" and   e.id in ( select enrollmentid from %s.enrollment_coc where datacollectionstage='5' and datediff(now(),information_date) > 365 )    union all "+
				" select  count(distinct(dedup_client_id))  as cnt from %s.incomeandsources  i, %s.enrollment e where "+
				"   i.information_date >= e.entrydate and e.entrydate <= :startDate   and e.ageatentry >=18 "+
				" and   e.id not in ( select enrollmentid from %s.exit  where  exitdate >= :endDate )  "+
				" and   e.id in ( select enrollmentid from %s.enrollment_coc where datacollectionstage='5' and datediff(now(),information_date) > 365 )   ";
		
		List<IncomeAndSourceModel> incomeAtEntryWith0 = incomeAndSourcesAtEntry.parallelStream().filter(income -> getFloat(income.getTotalmonthlyincome()) == 0).collect(Collectors.toList());
		List<IncomeAndSourceModel> incomeAtExitWith0 = incomeAndSourcesAtExit.parallelStream().filter(income -> getFloat(income.getTotalmonthlyincome()) == 0).collect(Collectors.toList());
		List<IncomeAndSourceModel> incomeAtStayersWith0 = incomeAndSourcesAtAnnualAssesment.parallelStream().filter(income -> getFloat(income.getTotalmonthlyincome()) == 0).collect(Collectors.toList());
		
		q16Bean.setQ16NoIncomeIncomeAtEntry(BigInteger.valueOf(getIncomeCnt(incomeAtEntryWith0)));
		q16Bean.setQ16NoIncomeIncomeAtExitforLeavers(BigInteger.valueOf(getIncomeCnt(incomeAtExitWith0)));
		q16Bean.setQ16NoIncomeIncomeAtLatestFollowupforStayers(BigInteger.valueOf(getIncomeCnt(incomeAtStayersWith0)));
		
		List<IncomeAndSourceModel> incomeAtEntryWith150 = incomeAndSourcesAtEntry.parallelStream().filter(income -> getFloat(income.getTotalmonthlyincome()) >= 1 && getFloat(income.getTotalmonthlyincome()) <=150).collect(Collectors.toList());
		List<IncomeAndSourceModel> incomeAtExitWith150 = incomeAndSourcesAtExit.parallelStream().filter(income -> getFloat(income.getTotalmonthlyincome()) >= 1 && getFloat(income.getTotalmonthlyincome()) <=150).collect(Collectors.toList());
		List<IncomeAndSourceModel> incomeAtStayersWith150 = incomeAndSourcesAtAnnualAssesment.parallelStream().filter(income -> getFloat(income.getTotalmonthlyincome()) >= 1 && getFloat(income.getTotalmonthlyincome()) <=150).collect(Collectors.toList());
		
		q16Bean.setQ161To150IncomeAtEntry(BigInteger.valueOf(incomeAtEntryWith150 != null ?incomeAtEntryWith150.size() :0));
		q16Bean.setQ161To150IncomeAtExitforLeavers(BigInteger.valueOf(incomeAtExitWith150 != null ? incomeAtExitWith150.size() :0));
		q16Bean.setQ161To150IncomeAtLatestFollowupforStayers(BigInteger.valueOf(incomeAtStayersWith150 != null ? incomeAtStayersWith150.size() :0));
		
		List<IncomeAndSourceModel> incomeAtEntryWith250 = incomeAndSourcesAtEntry.parallelStream().filter(income -> getFloat(income.getTotalmonthlyincome()) >= 151 && getFloat(income.getTotalmonthlyincome()) <=250).collect(Collectors.toList());
		List<IncomeAndSourceModel> incomeAtExitWith250 = incomeAndSourcesAtExit.parallelStream().filter(income -> getFloat(income.getTotalmonthlyincome()) >= 151 && getFloat(income.getTotalmonthlyincome()) <=250).collect(Collectors.toList());
		List<IncomeAndSourceModel> incomeAtStayersWith250 = incomeAndSourcesAtAnnualAssesment.parallelStream().filter(income -> getFloat(income.getTotalmonthlyincome()) >= 151 && getFloat(income.getTotalmonthlyincome()) <=250).collect(Collectors.toList());
		
		q16Bean.setQ16151To250IncomeAtEntry(BigInteger.valueOf(incomeAtEntryWith250 != null ? incomeAtEntryWith250.size() : 0 ));
		q16Bean.setQ16151To250IncomeAtExitforLeavers(BigInteger.valueOf(incomeAtExitWith250 != null ? incomeAtExitWith250.size():0));
		q16Bean.setQ16151To250IncomeAtLatestFollowupforStayers(BigInteger.valueOf(incomeAtStayersWith250 != null ? incomeAtStayersWith250.size():0));
		
		List<IncomeAndSourceModel> incomeAtEntryWith500 = incomeAndSourcesAtEntry.parallelStream().filter(income -> getFloat(income.getTotalmonthlyincome()) >= 251 && getFloat(income.getTotalmonthlyincome()) <=500).collect(Collectors.toList());
		List<IncomeAndSourceModel> incomeAtExitWith500 = incomeAndSourcesAtExit.parallelStream().filter(income -> getFloat(income.getTotalmonthlyincome()) >= 251 && getFloat(income.getTotalmonthlyincome()) <=500).collect(Collectors.toList());
		List<IncomeAndSourceModel> incomeAtStayersWith500 = incomeAndSourcesAtAnnualAssesment.parallelStream().filter(income -> getFloat(income.getTotalmonthlyincome()) >= 251 && getFloat(income.getTotalmonthlyincome()) <=500).collect(Collectors.toList());
		
		q16Bean.setQ16251To500IncomeAtEntry(BigInteger.valueOf(incomeAtEntryWith500 != null ? incomeAtEntryWith500.size() : 0 ));
		q16Bean.setQ16251To500IncomeAtExitforLeavers(BigInteger.valueOf(incomeAtExitWith500 != null ?incomeAtExitWith500.size():0));
		q16Bean.setQ16251To500IncomeAtLatestFollowupforStayers(BigInteger.valueOf(incomeAtStayersWith500 != null ?incomeAtStayersWith500.size():0));
		
		List<IncomeAndSourceModel> incomeAtEntryWith1000 = incomeAndSourcesAtEntry.parallelStream().filter(income -> getFloat(income.getTotalmonthlyincome()) >= 501 && getFloat(income.getTotalmonthlyincome()) <=1000).collect(Collectors.toList());
		List<IncomeAndSourceModel> incomeAtExitWith1000 = incomeAndSourcesAtExit.parallelStream().filter(income -> getFloat(income.getTotalmonthlyincome()) >= 501 && getFloat(income.getTotalmonthlyincome()) <=1000).collect(Collectors.toList());
		List<IncomeAndSourceModel> incomeAtStayersWith1000 = incomeAndSourcesAtAnnualAssesment.parallelStream().filter(income -> getFloat(income.getTotalmonthlyincome()) >= 501 && getFloat(income.getTotalmonthlyincome()) <=1000).collect(Collectors.toList());
		
		q16Bean.setQ16501To1000IncomeAtEntry(BigInteger.valueOf(incomeAtEntryWith1000 != null ? incomeAtEntryWith1000.size() : 0 ));
		q16Bean.setQ16501To1000IncomeAtExitforLeavers(BigInteger.valueOf(incomeAtExitWith1000 != null ?incomeAtExitWith1000.size():0));
		q16Bean.setQ16501To1000IncomeAtLatestFollowupforStayers(BigInteger.valueOf(incomeAtStayersWith1000 != null ?incomeAtStayersWith1000.size():0));
		
		List<IncomeAndSourceModel> incomeAtEntryWith1500 = incomeAndSourcesAtEntry.parallelStream().filter(income -> getFloat(income.getTotalmonthlyincome()) >= 1001 && getFloat(income.getTotalmonthlyincome()) <=1500).collect(Collectors.toList());
		List<IncomeAndSourceModel> incomeAtExitWith1500 = incomeAndSourcesAtExit.parallelStream().filter(income -> getFloat(income.getTotalmonthlyincome()) >= 1001 && getFloat(income.getTotalmonthlyincome()) <=1500).collect(Collectors.toList());
		List<IncomeAndSourceModel> incomeAtStayersWith1500 = incomeAndSourcesAtAnnualAssesment.parallelStream().filter(income -> getFloat(income.getTotalmonthlyincome()) >= 1001 && getFloat(income.getTotalmonthlyincome()) <=1500).collect(Collectors.toList());
		
		q16Bean.setQ161001To1500IncomeAtEntry(BigInteger.valueOf(incomeAtEntryWith1500 != null ? incomeAtEntryWith1500.size() : 0 ));
		q16Bean.setQ161001To1500IncomeAtExitforLeavers(BigInteger.valueOf(incomeAtExitWith1500 != null ?incomeAtExitWith1500.size():0));
		q16Bean.setQ161001To1500IncomeAtLatestFollowupforStayers(BigInteger.valueOf(incomeAtStayersWith1500 != null ?incomeAtStayersWith1500.size():0));
		
		List<IncomeAndSourceModel> incomeAtEntryWith2000 = incomeAndSourcesAtEntry.parallelStream().filter(income -> getFloat(income.getTotalmonthlyincome()) >= 1501 && getFloat(income.getTotalmonthlyincome()) <=2000).collect(Collectors.toList());
		List<IncomeAndSourceModel> incomeAtExitWith2000 = incomeAndSourcesAtExit.parallelStream().filter(income -> getFloat(income.getTotalmonthlyincome()) >= 1501 && getFloat(income.getTotalmonthlyincome()) <=2000).collect(Collectors.toList());
		List<IncomeAndSourceModel> incomeAtStayersWith2000 = incomeAndSourcesAtAnnualAssesment.parallelStream().filter(income -> getFloat(income.getTotalmonthlyincome()) >= 1501 && getFloat(income.getTotalmonthlyincome()) <=2000).collect(Collectors.toList());
		
		
		q16Bean.setQ161501To2000IncomeAtEntry(BigInteger.valueOf(incomeAtEntryWith2000 != null ? incomeAtEntryWith2000.size() : 0 ));
		q16Bean.setQ161501To2000IncomeAtExitforLeavers(BigInteger.valueOf(incomeAtExitWith2000 != null ?incomeAtExitWith2000.size():0));
		q16Bean.setQ161501To2000IncomeAtLatestFollowupforStayers(BigInteger.valueOf(incomeAtStayersWith2000 != null ?incomeAtStayersWith2000.size():0));
		
		List<IncomeAndSourceModel> incomeAtEntryabove2001 = incomeAndSourcesAtEntry.parallelStream().filter(income -> getFloat(income.getTotalmonthlyincome()) >= 2001).collect(Collectors.toList());
		List<IncomeAndSourceModel> incomeAtExitWith2001 = incomeAndSourcesAtExit.parallelStream().filter(income -> getFloat(income.getTotalmonthlyincome()) >= 2001).collect(Collectors.toList());
		List<IncomeAndSourceModel> incomeAtStayersWith2001 = incomeAndSourcesAtAnnualAssesment.parallelStream().filter(income -> getFloat(income.getTotalmonthlyincome()) >= 2001).collect(Collectors.toList());
		
		
		q16Bean.setQ162000PlusIncomeAtEntry(BigInteger.valueOf(incomeAtEntryabove2001 != null ? incomeAtEntryabove2001.size() : 0 ));
		q16Bean.setQ162000PlusIncomeAtExitforLeavers(BigInteger.valueOf(incomeAtExitWith2001 != null ?incomeAtExitWith2001.size():0));
		q16Bean.setQ162000PlusIncomeAtLatestFollowupforStayers(BigInteger.valueOf(incomeAtStayersWith2001 != null ?incomeAtStayersWith2001.size():0));
		
		
		List<IncomeAndSourceModel> incomeAtEntryDKE = incomeAndSourcesAtEntry.parallelStream().filter(income -> (StringUtils.equals("8", income.getIncomefromanysource()) || StringUtils.equals("9", income.getIncomefromanysource())) && getFloat(income.getTotalmonthlyincome()) == 0 ).collect(Collectors.toList());
		List<IncomeAndSourceModel> incomeAtExitDKE = incomeAndSourcesAtExit.parallelStream().filter(income -> (StringUtils.equals("8", income.getIncomefromanysource()) || StringUtils.equals("9", income.getIncomefromanysource())) && getFloat(income.getTotalmonthlyincome()) == 0 ).collect(Collectors.toList());
		List<IncomeAndSourceModel> incomeAADKE = incomeAndSourcesAtAnnualAssesment.parallelStream().filter(income -> (StringUtils.equals("8", income.getIncomefromanysource()) || StringUtils.equals("9", income.getIncomefromanysource())) && getFloat(income.getTotalmonthlyincome()) == 0 ).collect(Collectors.toList());
		
		q16Bean.setQ16ClientDoesntKnowIncomeAtEntry(BigInteger.valueOf(getIncomeCnt(incomeAtEntryDKE)));
		q16Bean.setQ16ClientDoesntKnowIncomeAtExitforLeavers(BigInteger.valueOf(getIncomeCnt(incomeAtExitDKE)));
		q16Bean.setQ16ClientDoesntKnowIncomeAtLatestFollowupforStayers(BigInteger.valueOf(getIncomeCnt(incomeAADKE)));
		
		List<IncomeAndSourceModel> incomeAtEntryDNC = incomeAndSourcesAtEntry.parallelStream().filter(income -> (StringUtils.equals("99", income.getIncomefromanysource())) && getFloat(income.getTotalmonthlyincome()) == 0 ).collect(Collectors.toList());
		List<IncomeAndSourceModel> incomeAtExitDNC = incomeAndSourcesAtExit.parallelStream().filter(income -> (StringUtils.equals("99", income.getIncomefromanysource())) && getFloat(income.getTotalmonthlyincome()) == 0 ).collect(Collectors.toList());
		List<IncomeAndSourceModel> incomeAADNC = incomeAndSourcesAtAnnualAssesment.parallelStream().filter(income -> (StringUtils.equals("99", income.getIncomefromanysource())) && getFloat(income.getTotalmonthlyincome()) == 0 ).collect(Collectors.toList());
		
		
		q16Bean.setQ16DataNotCollectedIncomeAtEntry(BigInteger.valueOf(getIncomeCnt(incomeAtEntryDNC)));
		q16Bean.setQ16DataNotCollectedIncomeAtExitforLeavers(BigInteger.valueOf(getIncomeCnt(incomeAtExitDNC)));
		q16Bean.setQ16DataNotCollectedIncomeAtLatestFollowupforStayers(BigInteger.valueOf(getIncomeCnt(incomeAADNC)));
		
		
		q16Bean.setQ16NumberOfAdultStayersNotYetRequiredIncomeAtEntry(BigInteger.valueOf(0));
		q16Bean.setQ16NumberOfAdultStayersNotYetRequiredIncomeAtExitforLeavers(BigInteger.valueOf(0));
		q16Bean.setQ16NumberOfAdultStayersNotYetRequiredIncomeAtLatestFollowupforStayers(BigInteger.valueOf(getIncomeCnt(data.getSchema(), notRequiredAnnualAssesment,DataCollectionStage.ANNUAL_ASSESMENT.getCode(), data)));
		
		q16Bean.setQ16NumberOfAdultStayersWithoutRequiredIncomeAtEntry(BigInteger.valueOf(0));
		q16Bean.setQ16NumberOfAdultStayersWithoutRequiredIncomeAtExitforLeavers(BigInteger.valueOf(0));
		q16Bean.setQ16NumberOfAdultStayersWithoutRequiredIncomeAtLatestFollowupforStayers(BigInteger.valueOf(getClientCntWithOutRequiredAnnualAssesment(data.getSchema(), withOutRequiredAnnualAssesment, data)));

		data.setNumOfAdultStayersNotRequiredAnnualAssesment(q16Bean.getQ16NumberOfAdultStayersNotYetRequiredIncomeAtLatestFollowupforStayers());
		data.setNumOfAdultStayersWithoutRequiredAnnualAssesment(q16Bean.getQ16NumberOfAdultStayersWithoutRequiredIncomeAtLatestFollowupforStayers());
		q16Bean.setQ16TotalAdultsIncomeAtEntry(data.getNumOfAdults());
		q16Bean.setQ16TotalAdultsIncomeAtExitforLeavers(data.getTotNoOfAdultLeavers());
		q16Bean.setQ16TotalAdultsIncomeAtLatestFollowupforStayers(data.getTotNoOfAdultStayers());
	} catch (Exception e) {
		logger.error("Error in Q16BeanMaker:" + e);
	}
		}
		return Arrays.asList(q16Bean);
	}
	
	
	public static int getClientCntWithOutRequiredAnnualAssesment(String schema,String query,ReportData data) {
		ResultSet resultSet = null;
		Statement statement = null;
		Connection connection = null;
		int count =0;
		try {
			connection = ImpalaConnection.getConnection();
			statement = connection.createStatement();
			
			resultSet = statement.executeQuery(formatQuery(getQueryForProjectDB(data, query),schema,data));
			
		 while(resultSet.next()) {
			 count = resultSet.getInt(1);
	     }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
					//connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return count;
	}
	
}
