package com.servinglynk.report.business;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.servinglynk.hive.connection.ImpalaConnection;
import com.servinglynk.hive.connection.ReportQuery;
import com.servinglynk.report.bean.Q16CashIncomeRangesDataBean;
import com.servinglynk.report.bean.ReportData;
import com.servinglynk.report.model.DataCollectionStage;

public class Q16BeanMaker extends BaseBeanMaker {
	
	public static List<Q16CashIncomeRangesDataBean> getQ16CashIncomeRangesList(ReportData data) {
		
		/*List<ClientModel> clients = data.getClients();
		List<EnrollmentModel>  enrollments = data.getEnrollments();
		List<ClientModel> adults = clients.parallelStream().filter(client -> Q05aBeanMaker.isAdult(client.getDob())).collect(Collectors.toList());
		List<ClientModel> children = clients.parallelStream().filter(client -> Q05aBeanMaker.isChild(client.getDob())).collect(Collectors.toList());
		List<ClientModel> ageUnknown = clients.parallelStream().filter(client -> client.getDob() == null).collect(Collectors.toList());
		List<ExitModel> exits = data.getExits();
		List<ClientModel> veterans = clients.parallelStream().filter(client -> StringUtils.equals(DataCollectionStage.ENTRY.getCode(),client.getVeteran_status())).collect(Collectors.toList());
		int stayers = clients !=null && exits != null ? clients.size() - exits.size() : 0;*/
		/*
		 * select  alimonyamount,childsupportamount,earnedamount,gaamount,othersourceamount,pensionamount,privatedisabilityamount, 
		 socsecretirementamount,ssiamount,tanfamount,totalmonthlyincome,unemploymentamount,vadisabilitynonserviceamount, 
		 vadisabilityserviceamount,workerscompamount,e.dedup_client_id from incomeandsources i, enrollment e where e.id=i.enrollmentid 
		 and i.information_date >= e.entrydate and e.entrydate <= '2015-06-24 00:00:00'
        and   e.id not in ( select enrollmentid from exit  where  exitdate >= '2015-06-24 00:00:00' ) 
        and   e.id not in ( select enrollmentid from enrollment_coc where datacollectionstage='5' and datediff(now(),information_date) < 365 )  
        
		 */
		Q16CashIncomeRangesDataBean q16Bean = new Q16CashIncomeRangesDataBean();
		if(data.isLiveMode()) {
		try {
		String query = "select  alimonyamount,childsupportamount,earnedamount,gaamount,othersourceamount,pensionamount,privatedisabilityamount, "+
		" socsecretirementamount,ssiamount,tanfamount,totalmonthlyincome,unemploymentamount,vadisabilitynonserviceamount, "+
		" vadisabilityserviceamount,workerscompamount,e.dedup_client_id from %s.incomeandsources i, %s.enrollment e where i.datacollectionstage=? and  e.id=i.enrollmentid "+
		" and i.information_date >= e.entrydate ";
		List<Float> incomeAtEntry = getIncome(data.getSchema(), query, DataCollectionStage.ENTRY.getCode());
		List<Float> incomeAtExit = getIncome(data.getSchema(), query, DataCollectionStage.EXIT.getCode());
		
		
		List<Float> incomeAtStayers = getIncomeForAnnualAssesment(data.getSchema(), ReportQuery.REQUIRED_ANNUAL_ASSESMENT_QUERY, data);
		
		String clientDKE = "select count(distinct(dedup_client_id)) as cnt from %s.incomeandsources i, %s.enrollment e where e.id=i.enrollmentid  and (totalmonthlyincome is null or totalmonthlyincome =0) and incomefromanysource in ('8','9') and datacollectionstage=? ";
		
		String clientDNC = "select count(distinct(dedup_client_id)) as cnt from %s.incomeandsources i, %s.enrollment e where e.id=i.enrollmentid  and (totalmonthlyincome is null or totalmonthlyincome =0) and incomefromanysource in ('99') and datacollectionstage=? ";
		
		String clientAnnualAssesmentDKE = "select  count(distinct(dedup_client_id))  as cnt from %s.incomeandsources where (totalmonthlyincome is null or totalmonthlyincome =0) and incomefromanysource in('8','9')"+
				"  and i.information_date >= e.entrydate and e.entrydate <= ?   and e.ageatentry >=18 "+
				" and   e.id not in ( select enrollmentid from %s.exit  where  exitdate <= ? )  "+
				" and   e.id not in ( select enrollmentid from %s.enrollment_coc where datacollectionstage='5' and datediff(now(),information_date) > 365 )  ";
		
		
		String clientAnnualAssesmentDNC = "select  count(distinct(dedup_client_id))  as cnt from %s.incomeandsources where (totalmonthlyincome is null or totalmonthlyincome =0) and incomefromanysource='99'"+
				"  and i.information_date >= e.entrydate and e.entrydate <= ?   and e.ageatentry >=18 "+
				" and   e.id not in ( select enrollmentid from %s.exit  where  exitdate <= ? )  "+
				" and   e.id not in ( select enrollmentid from %s.enrollment_coc where datacollectionstage='5' and datediff(now(),information_date) > 365 )  ";
		
		String notRequiredAnnualAssesment = "select  count(distinct(dedup_client_id))  as cnt from %s.incomeandsources where "+
				"   i.information_date >= e.entrydate and e.entrydate <= ?   and e.ageatentry >=18 "+
				" and   e.id not in ( select enrollmentid from %s.exit  where  exitdate <= ? )  "+
				" and   e.id in ( select enrollmentid from %s.enrollment_coc where datacollectionstage='5' and datediff(now(),information_date) > 365 )  ";
		
		String withOutRequiredAnnualAssesment = "select  count(distinct(dedup_client_id))  as cnt from %s.incomeandsources where "+
				"   i.information_date >= e.entrydate and e.entrydate <= ?   and e.ageatentry >=18 "+
				" and   e.id not in ( select enrollmentid from %s.exit  where  exitdate >= ? )  "+
				" and   e.id in ( select enrollmentid from %s.enrollment_coc where datacollectionstage='5' and datediff(now(),information_date) > 365 )  union all "+
				" select  count(distinct(dedup_client_id))  as cnt from %s.incomeandsources where "+
				"   i.information_date >= e.entrydate and e.entrydate <= ?   and e.ageatentry >=18 "+
				" and   e.id not in ( select enrollmentid from %s.exit  where  exitdate >= ? )  "+
				" and   e.id in ( select enrollmentid from %s.enrollment_coc where datacollectionstage='5' and datediff(now(),information_date) > 365 ) ";
		
		List<Float> incomeAtEntryWith0 = incomeAtEntry.parallelStream().filter(income -> income == 0).collect(Collectors.toList());
		List<Float> incomeAtExitWith0 = incomeAtExit.parallelStream().filter(income -> income == 0).collect(Collectors.toList());
		List<Float> incomeAtStayersWith0 = incomeAtStayers.parallelStream().filter(income -> income == 0).collect(Collectors.toList());
		
		q16Bean.setQ16NoIncomeIncomeAtEntry(BigInteger.valueOf(incomeAtEntryWith0 != null ? incomeAtEntryWith0.size() :0));
		q16Bean.setQ16NoIncomeIncomeAtExitforLeavers(BigInteger.valueOf( incomeAtExitWith0 != null ? incomeAtExitWith0.size() :0));
		q16Bean.setQ16NoIncomeIncomeAtLatestFollowupforStayers(BigInteger.valueOf(incomeAtStayersWith0 != null ? incomeAtStayersWith0.size() :0));
		
		List<Float> incomeAtEntryWith150 = incomeAtEntry.parallelStream().filter(income -> income >= 1 && income <=150).collect(Collectors.toList());
		List<Float> incomeAtExitWith150 = incomeAtExit.parallelStream().filter(income -> income >= 1 && income <=150).collect(Collectors.toList());
		List<Float> incomeAtStayersWith150 = incomeAtStayers.parallelStream().filter(income -> income >= 1 && income <=150).collect(Collectors.toList());
		
		q16Bean.setQ161To150IncomeAtEntry(BigInteger.valueOf(incomeAtEntryWith150 != null ?incomeAtEntryWith150.size() :0));
		q16Bean.setQ161To150IncomeAtExitforLeavers(BigInteger.valueOf(incomeAtExitWith150 != null ? incomeAtExitWith150.size() :0));
		q16Bean.setQ161To150IncomeAtLatestFollowupforStayers(BigInteger.valueOf(incomeAtStayersWith150 != null ? incomeAtStayersWith150.size() :0));
		
		List<Float> incomeAtEntryWith250 = incomeAtEntry.parallelStream().filter(income -> income >= 151 && income <=250).collect(Collectors.toList());
		List<Float> incomeAtExitWith250 = incomeAtExit.parallelStream().filter(income -> income >= 151 && income <=250).collect(Collectors.toList());
		List<Float> incomeAtStayersWith250 = incomeAtStayers.parallelStream().filter(income -> income >= 151 && income <=250).collect(Collectors.toList());
		
		q16Bean.setQ16151To250IncomeAtEntry(BigInteger.valueOf(incomeAtEntryWith250 != null ? incomeAtEntryWith250.size() : 0 ));
		q16Bean.setQ16151To250IncomeAtExitforLeavers(BigInteger.valueOf(incomeAtExitWith250 != null ? incomeAtExitWith250.size():0));
		q16Bean.setQ16151To250IncomeAtLatestFollowupforStayers(BigInteger.valueOf(incomeAtStayersWith250 != null ? incomeAtStayersWith250.size():0));
		
		List<Float> incomeAtEntryWith500 = incomeAtEntry.parallelStream().filter(income -> income >= 251 && income <=500).collect(Collectors.toList());
		List<Float> incomeAtExitWith500 = incomeAtExit.parallelStream().filter(income -> income >= 251 && income <=500).collect(Collectors.toList());
		List<Float> incomeAtStayersWith500 = incomeAtStayers.parallelStream().filter(income -> income >= 251 && income <=500).collect(Collectors.toList());
		
		q16Bean.setQ16251To500IncomeAtEntry(BigInteger.valueOf(incomeAtEntryWith500 != null ? incomeAtEntryWith500.size() : 0 ));
		q16Bean.setQ16251To500IncomeAtExitforLeavers(BigInteger.valueOf(incomeAtExitWith500 != null ?incomeAtExitWith500.size():0));
		q16Bean.setQ16251To500IncomeAtLatestFollowupforStayers(BigInteger.valueOf(incomeAtStayersWith500 != null ?incomeAtStayersWith500.size():0));
		
		List<Float> incomeAtEntryWith1000 = incomeAtEntry.parallelStream().filter(income -> income >= 501 && income <=1000).collect(Collectors.toList());
		List<Float> incomeAtExitWith1000 = incomeAtExit.parallelStream().filter(income -> income >= 501 && income <=1000).collect(Collectors.toList());
		List<Float> incomeAtStayersWith1000 = incomeAtStayers.parallelStream().filter(income -> income >= 501 && income <=1000).collect(Collectors.toList());
		
		q16Bean.setQ16501To1000IncomeAtEntry(BigInteger.valueOf(incomeAtEntryWith1000 != null ? incomeAtEntryWith1000.size() : 0 ));
		q16Bean.setQ16501To1000IncomeAtExitforLeavers(BigInteger.valueOf(incomeAtExitWith1000 != null ?incomeAtExitWith1000.size():0));
		q16Bean.setQ16501To1000IncomeAtLatestFollowupforStayers(BigInteger.valueOf(incomeAtStayersWith1000 != null ?incomeAtStayersWith1000.size():0));
		
		List<Float> incomeAtEntryWith1500 = incomeAtEntry.parallelStream().filter(income -> income >= 1001 && income <=1500).collect(Collectors.toList());
		List<Float> incomeAtExitWith1500 = incomeAtExit.parallelStream().filter(income -> income >= 1001 && income <=1500).collect(Collectors.toList());
		List<Float> incomeAtStayersWith1500 = incomeAtStayers.parallelStream().filter(income -> income >= 1001 && income <=1500).collect(Collectors.toList());
		
		q16Bean.setQ161001To1500IncomeAtEntry(BigInteger.valueOf(incomeAtEntryWith1500 != null ? incomeAtEntryWith1500.size() : 0 ));
		q16Bean.setQ161001To1500IncomeAtExitforLeavers(BigInteger.valueOf(incomeAtExitWith1500 != null ?incomeAtExitWith1500.size():0));
		q16Bean.setQ161001To1500IncomeAtLatestFollowupforStayers(BigInteger.valueOf(incomeAtStayersWith1500 != null ?incomeAtStayersWith1500.size():0));
		
		List<Float> incomeAtEntryWith2000 = incomeAtEntry.parallelStream().filter(income -> income >= 1501 && income <=2000).collect(Collectors.toList());
		List<Float> incomeAtExitWith2000 = incomeAtExit.parallelStream().filter(income -> income >= 1501 && income <=2000).collect(Collectors.toList());
		List<Float> incomeAtStayersWith2000 = incomeAtStayers.parallelStream().filter(income -> income >= 1501 && income <=2000).collect(Collectors.toList());
		
		
		q16Bean.setQ161501To2000IncomeAtEntry(BigInteger.valueOf(incomeAtEntryWith2000 != null ? incomeAtEntryWith2000.size() : 0 ));
		q16Bean.setQ161501To2000IncomeAtExitforLeavers(BigInteger.valueOf(incomeAtExitWith2000 != null ?incomeAtExitWith2000.size():0));
		q16Bean.setQ161501To2000IncomeAtLatestFollowupforStayers(BigInteger.valueOf(incomeAtStayersWith2000 != null ?incomeAtStayersWith2000.size():0));
		
		List<Float> incomeAtEntryabove2001 = incomeAtEntry.parallelStream().filter(income -> income >= 2001).collect(Collectors.toList());
		List<Float> incomeAtExitWith2001 = incomeAtExit.parallelStream().filter(income -> income >= 2001).collect(Collectors.toList());
		List<Float> incomeAtStayersWith2001 = incomeAtStayers.parallelStream().filter(income -> income >= 2001).collect(Collectors.toList());
		
		
		q16Bean.setQ162000PlusIncomeAtEntry(BigInteger.valueOf(incomeAtEntryabove2001 != null ? incomeAtEntryabove2001.size() : 0 ));
		q16Bean.setQ162000PlusIncomeAtExitforLeavers(BigInteger.valueOf(incomeAtExitWith2001 != null ?incomeAtExitWith2001.size():0));
		q16Bean.setQ162000PlusIncomeAtLatestFollowupforStayers(BigInteger.valueOf(incomeAtStayersWith2001 != null ?incomeAtStayersWith2001.size():0));
		
		q16Bean.setQ16ClientDoesntKnowIncomeAtEntry(BigInteger.valueOf(getIncomeCnt(data.getSchema(), clientDKE, DataCollectionStage.ENTRY.getCode())));
		q16Bean.setQ16ClientDoesntKnowIncomeAtExitforLeavers(BigInteger.valueOf(getIncomeCnt(data.getSchema(), clientDKE, DataCollectionStage.EXIT.getCode())));
		q16Bean.setQ16ClientDoesntKnowIncomeAtLatestFollowupforStayers(BigInteger.valueOf(getIncomeCnt(data.getSchema(), clientAnnualAssesmentDKE, data)));
		
		q16Bean.setQ16DataNotCollectedIncomeAtEntry(BigInteger.valueOf(getIncomeCnt(data.getSchema(), clientDNC, DataCollectionStage.ENTRY.getCode())));
		q16Bean.setQ16DataNotCollectedIncomeAtExitforLeavers(BigInteger.valueOf(getIncomeCnt(data.getSchema(), clientDNC, DataCollectionStage.EXIT.getCode())));
		q16Bean.setQ16DataNotCollectedIncomeAtLatestFollowupforStayers(BigInteger.valueOf(getIncomeCnt(data.getSchema(), clientAnnualAssesmentDNC, data)));
		
		
		q16Bean.setQ16NumberOfAdultStayersNotYetRequiredIncomeAtEntry(BigInteger.valueOf(0));
		q16Bean.setQ16NumberOfAdultStayersNotYetRequiredIncomeAtExitforLeavers(BigInteger.valueOf(0));
		q16Bean.setQ16NumberOfAdultStayersNotYetRequiredIncomeAtLatestFollowupforStayers(BigInteger.valueOf(getIncomeCnt(data.getSchema(), notRequiredAnnualAssesment, data)));
		
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

	
	public static List<Float> getIncome(String schema,String query,String datacollectionStage) {
		List<Float> incomes = new ArrayList<>();
		ResultSet resultSet = null;
		PreparedStatement statement = null;
		Connection connection = null;
		try {
			connection = ImpalaConnection.getConnection();
			statement = connection.prepareStatement(formatQuery(query,schema));
			statement.setString(1, datacollectionStage);
			resultSet = statement.executeQuery();
			
		 while(resultSet.next()) {
			 incomes.add(getFloatValue(resultSet,1)+getFloatValue(resultSet,2)+getFloatValue(resultSet,3)+getFloatValue(resultSet,4)+getFloatValue(resultSet,5)+getFloatValue(resultSet,6)+getFloatValue(resultSet,7)+
			 getFloatValue(resultSet,8)+getFloatValue(resultSet,9)+getFloatValue(resultSet,10)+getFloatValue(resultSet,11)+getFloatValue(resultSet,12)+getFloatValue(resultSet,13)+getFloatValue(resultSet,14)+getFloatValue(resultSet,15));
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
		return incomes;
	}
	
	public static int getIncomeCnt(String schema,String query,String datacollectionStage) {
		ResultSet resultSet = null;
		PreparedStatement statement = null;
		Connection connection = null;
		int count =0;
		try {
			connection = ImpalaConnection.getConnection();
			statement = connection.prepareStatement(formatQuery(query,schema));
			statement.setString(1, datacollectionStage);
			resultSet = statement.executeQuery();
			
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
	
	public static int getIncomeCnt(String schema,String query,ReportData data) {
		ResultSet resultSet = null;
		PreparedStatement statement = null;
		Connection connection = null;
		int count =0;
		try {
			connection = ImpalaConnection.getConnection();
			statement = connection.prepareStatement(formatQuery(query,schema));
			statement.setDate(1, data.getReportStartDate());
			statement.setDate(2, data.getReportEndDate());
			resultSet = statement.executeQuery();
			
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
	
	public static int getClientCntWithOutRequiredAnnualAssesment(String schema,String query,ReportData data) {
		ResultSet resultSet = null;
		PreparedStatement statement = null;
		Connection connection = null;
		int count =0;
		try {
			connection = ImpalaConnection.getConnection();
			statement = connection.prepareStatement(formatQuery(query,schema));
			statement.setDate(1, data.getReportStartDate());
			statement.setDate(2, data.getReportEndDate());
			statement.setDate(3, data.getReportStartDate());
			statement.setDate(4, data.getReportEndDate());
			resultSet = statement.executeQuery();
			
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
	
	
	
	
	public static List<Float> getIncomeForAnnualAssesment(String schema,String query,ReportData data) {
		List<Float> incomes = new ArrayList<>();
		ResultSet resultSet = null;
		PreparedStatement statement = null;
		Connection connection = null;
		try {
			connection = ImpalaConnection.getConnection();
			statement = connection.prepareStatement(formatQuery(query,schema));
			statement.setDate(1, data.getReportStartDate());
			statement.setDate(2, data.getReportEndDate());
			resultSet = statement.executeQuery();
			
		 while(resultSet.next()) {
			 incomes.add(getFloatValue(resultSet,1)+getFloatValue(resultSet,2)+getFloatValue(resultSet,3)+getFloatValue(resultSet,4)+getFloatValue(resultSet,5)+getFloatValue(resultSet,6)+getFloatValue(resultSet,7)+
					 getFloatValue(resultSet,8)+getFloatValue(resultSet,9)+getFloatValue(resultSet,10)+getFloatValue(resultSet,11)+getFloatValue(resultSet,12)+getFloatValue(resultSet,13)+getFloatValue(resultSet,14)+getFloatValue(resultSet,15));

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
		return incomes;
	}
	
	
	private static Float getFloatValue(ResultSet resultSet , int index) {
		try {
			Float value = (Float)resultSet.getFloat(index);
			if(value != null) {
				return value;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new Float(0);
	}
	
	
}
