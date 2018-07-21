package com.servinglynk.report.business;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import com.servinglynk.hive.connection.ImpalaConnection;
import com.servinglynk.report.bean.Q18DataBean;
import com.servinglynk.report.bean.ReportData;
import com.servinglynk.report.model.DataCollectionStage;

public class Q18DataBeanMaker extends BaseBeanMaker {

	public static List<Q18DataBean> getQ18ClientCashIncomeCategoryEarnedOtherIncomeList(ReportData data){
		
		Q18DataBean q18eData = new Q18DataBean();
		
		String query = " select count(dedup_client_id)  from %s.incomeandsources i, %s.enrollment e where i.datacollectionstage='1' and  e.project_entry_id=i.project_entry_id "+ 
				" and i.information_date >= e.entrydate and i.information_date >= ? and i.information_date <= ? and e.ageatentry >= 18 ";

		int incomeAtEntry = getIncomeCnt(data.getSchema(), query+" earned=true and earnedamount > 0", DataCollectionStage.ENTRY.getCode(), data.getReportStartDate(), data.getReportEndDate());
		q18eData.setQ18AdultsWithOnlyEarnedIncomeNumberOfAdultsAtEntry(BigInteger.valueOf(incomeAtEntry));
		q18eData.setQ18AdultsWithOnlyEarnedIncomeNumberOfAdultsAtExit(BigInteger.valueOf(0));
		q18eData.setQ18AdultsWithOnlyEarnedIncomeNumberOfAdultsAtFollowup(BigInteger.valueOf(0));
		
		q18eData.setQ18AdultsWithBothEarnedAndOtherIncomeNumberOfAdultsAtEntry(BigInteger.valueOf(0));
		q18eData.setQ18AdultsWithBothEarnedAndOtherIncomeNumberOfAdultsAtExit(BigInteger.valueOf(0));
		q18eData.setQ18AdultsWithBothEarnedAndOtherNumberOfAdultsAtFollowup(BigInteger.valueOf(0));
		
		q18eData.setQ18AdultsWithDKRNumberOfAdultsAtEntry(BigInteger.valueOf(0));
		q18eData.setQ18AdultsWithDKRNumberOfAdultsAtExit(BigInteger.valueOf(0));
		q18eData.setQ18AdultsWithDKRNumberOfAdultsAtFollowup(BigInteger.valueOf(0));
		
		q18eData.setQ18AdultsWithIncomeInfoAtEntryNumberOfAdultsAtEntry(BigInteger.valueOf(0));
		q18eData.setQ18AdultsWithIncomeInfoAtEntryNumberOfAdultsAtExit(BigInteger.valueOf(0));
		q18eData.setQ18AdultsWithIncomeInfoAtEntryNumberOfAdultsAtFollowup(BigInteger.valueOf(0));
		
		q18eData.setQ18AdultsWithMissingInfoNumberOfAdultsAtEntry(BigInteger.valueOf(0));
		q18eData.setQ18AdultsWithMissingInfoNumberOfAdultsAtExit(BigInteger.valueOf(0));
		q18eData.setQ18AdultsWithMissingInfoNumberOfAdultsAtFollowup(BigInteger.valueOf(0));
		
		q18eData.setQ18AdultsWithNoIncomeNumberOfAdultsAtEntry(BigInteger.valueOf(0));
		q18eData.setQ18AdultsWithNoIncomeNumberOfAdultsAtExit(BigInteger.valueOf(0));
		q18eData.setQ18AdultsWithNoOtherNumberOfAdultsAtFollowup(BigInteger.valueOf(0));
		
		q18eData.setQ18AdultsWithOnlyOtherIncomeNumberOfAdultsAtEntry(BigInteger.valueOf(0));
		q18eData.setQ18AdultsWithOnlyOtherIncomeNumberOfAdultsAtExit(BigInteger.valueOf(0));
		q18eData.setQ18AdultsWithOnlyOtherIncomeNumberOfAdultsAtFollowup(BigInteger.valueOf(0));
		
		q18eData.setQ18NumberOfAdultStayersNotRequiredNumberOfAdultsAtEntry(BigInteger.valueOf(0));
		q18eData.setQ18NumberOfAdultStayersNotRequiredNumberOfAdultsAtExit(BigInteger.valueOf(0));
		q18eData.setQ18NumberOfAdultStayersNotRequiredNumberOfAdultsAtFollowup(BigInteger.valueOf(0));
		
		q18eData.setQ18NumberOfAdultStayersWithoutRequiredNumberOfAdultsAtEntry(BigInteger.valueOf(0));
		q18eData.setQ18NumberOfAdultStayersWithoutRequiredNumberOfAdultsAtExit(BigInteger.valueOf(0));
		q18eData.setQ18NumberOfAdultStayersWithoutRequiredNumberOfAdultsAtFollowup(BigInteger.valueOf(0));
		
		q18eData.setQ18TotalAdultsNumberOfAdultsAtEntry(data.getNumOfAdults());
		q18eData.setQ18TotalAdultsNumberOfAdultsAtExit(data.getTotNoOfAdultLeavers());
		q18eData.setQ18TotalAdultsNumberOfAdultsAtFollowup(data.getTotNoOfAdultStayers());
		
		q18eData.setQ18OneOrMoreSourceofIncomeNumberOfAdultsAtEntry(BigInteger.valueOf(0));
		q18eData.setQ18OneOrMoreSourceofIncomeNumberOfAdultsAtExit(BigInteger.valueOf(0));
		q18eData.setQ18OneOrMoreSourceofIncomeNumberOfAdultsAtFollowup(BigInteger.valueOf(0));
		
		return Arrays.asList(q18eData);
	}
	
	
	public static int getIncomeCnt(String schema,String query,String datacollectionStage,Date reportStartDate, Date reportEndDate) {
		ResultSet resultSet = null;
		PreparedStatement statement = null;
		Connection connection = null;
		int count =0;
		try {
			connection = ImpalaConnection.getConnection();
			statement = connection.prepareStatement(formatQuery(query,schema));
			statement.setString(1, datacollectionStage);
			statement.setDate(2, reportStartDate);
			statement.setDate(3, reportEndDate);
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
	
}
