package com.servinglynk.report.business;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.servinglynk.hive.connection.ImpalaConnection;
import com.servinglynk.report.bean.Q17CashIncomeSourcesDataBean;
import com.servinglynk.report.bean.ReportData;
import com.servinglynk.report.model.DataCollectionStage;

public class Q17DataBeanMaker extends BaseBeanMaker {
	
	public static List<Q17CashIncomeSourcesDataBean> getQ17CashIncomeSourcesList(ReportData data){
		/**********************
		 * ANY changs to this file needs changes in Q25g
		 */
		Q17CashIncomeSourcesDataBean q17CashIncomeSourcesDataBeanTable =new Q17CashIncomeSourcesDataBean();
		if(data.isLiveMode()) {
		try{
		String entryQuery = " select count(dedup_client_id) as cnt  from %s.incomeandsources i, %s.enrollment e where   e.id=i.enrollmentid "+ 
							" and i.information_date >= e.entrydate and i.information_date >= :startDate and i.information_date <= :endDate  and i.datacollectionstage=:datacollectionstage and e.ageatentry >= 18 ";
	
		String annualAssesmentQuery = " select count(distinct(dedup_client_id)) as cnt  from %s.incomeandsources i, %s.enrollment e where   e.id=i.enrollmentid "+ 
				" and i.information_date >= e.entrydate and i.datacollectionstage=:datacollectionstage  and i.information_date >= :startDate and i.information_date <= :endDate  and e.ageatentry >= 18 "+
				" and   e.id not in ( select enrollmentid from %s.exit  where exitdate <= :startDate )  "+
				" and   e.id not in ( select enrollmentid from %s.enrollment_coc where datacollectionstage=:datacollectionstage and datediff(now(),information_date) > 365 )  ";

		
		int alimonyIncomeAtEntry = getIncomeCnt(data.getSchema(), entryQuery +" and alimony ='1' ", DataCollectionStage.ENTRY.getCode(),data);
		int alimonyIncomeAtExit = getIncomeCnt(data.getSchema(), entryQuery +" and  alimony ='1' ", DataCollectionStage.EXIT.getCode(),data);
		int alimonyIncomeAtAnnualAssesment = getIncomeCntForAnnualAssesment(data.getSchema(), annualAssesmentQuery +"  and alimony ='1' ", DataCollectionStage.ANNUAL_ASSESMENT.getCode(),data);
		
		q17CashIncomeSourcesDataBeanTable.setQ17AlimonyAtEntry(BigInteger.valueOf(alimonyIncomeAtEntry));
		q17CashIncomeSourcesDataBeanTable.setQ17AlimonyAtExitforLeavers(BigInteger.valueOf(alimonyIncomeAtExit));
		q17CashIncomeSourcesDataBeanTable.setQ17AlimonyAtLatestAnnualAssessmentforStayers(BigInteger.valueOf(alimonyIncomeAtAnnualAssesment));
		
		int childsupportIncomeAtEntry = getIncomeCnt(data.getSchema(), entryQuery +"  and childsupport ='1' ", DataCollectionStage.ENTRY.getCode(),data);
		int childsupportIncomeAtExit = getIncomeCnt(data.getSchema(), entryQuery +"  and childsupport ='1' ", DataCollectionStage.EXIT.getCode(),data);
		int childsupportIncomeAtAnnualAssesment = getIncomeCnt(data.getSchema(), annualAssesmentQuery +"  and childsupport ='1' ", DataCollectionStage.ANNUAL_ASSESMENT.getCode(),data);
		
		q17CashIncomeSourcesDataBeanTable.setQ17ChildSupportAtEntry(BigInteger.valueOf(childsupportIncomeAtEntry));
		q17CashIncomeSourcesDataBeanTable.setQ17ChildSupportAtExitforLeavers(BigInteger.valueOf(childsupportIncomeAtExit));
		q17CashIncomeSourcesDataBeanTable.setQ17ChildSupportAtLatestAnnualAssessmentforStayers(BigInteger.valueOf(childsupportIncomeAtAnnualAssesment));
		
		int earnedIncomeAtEntry = getIncomeCnt(data.getSchema(), entryQuery +" and  earned ='1' ", DataCollectionStage.ENTRY.getCode(),data);
		int earnedIncomeAtExit = getIncomeCnt(data.getSchema(), entryQuery +" and  earned ='1' ", DataCollectionStage.EXIT.getCode(),data);
		int earnedIncomeAtAnnualAssesment = getIncomeCnt(data.getSchema(), annualAssesmentQuery +"  and earned ='1' ", DataCollectionStage.ANNUAL_ASSESMENT.getCode(),data);
		
		q17CashIncomeSourcesDataBeanTable.setQ17EarnedIncomeAtEntry(BigInteger.valueOf(earnedIncomeAtEntry));
		q17CashIncomeSourcesDataBeanTable.setQ17EarnedIncomeAtExitforLeavers(BigInteger.valueOf(earnedIncomeAtExit));
		q17CashIncomeSourcesDataBeanTable.setQ17EarnedIncomeAtLatestAnnualAssessmentforStayers(BigInteger.valueOf(earnedIncomeAtAnnualAssesment));
		
		
		int gaIncomeAtEntry = getIncomeCnt(data.getSchema(), entryQuery +"  and ga ='1' ", DataCollectionStage.ENTRY.getCode(),data);
		int gaIncomeAtExit = getIncomeCnt(data.getSchema(), entryQuery +"  and ga ='1' ", DataCollectionStage.EXIT.getCode(),data);
		int gaIncomeAtAnnualAssesment = getIncomeCnt(data.getSchema(), annualAssesmentQuery +"  and ga ='1' ", DataCollectionStage.ANNUAL_ASSESMENT.getCode(),data);
		
		q17CashIncomeSourcesDataBeanTable.setQ17GeneralAssistanceAtEntry(BigInteger.valueOf(gaIncomeAtEntry));
		q17CashIncomeSourcesDataBeanTable.setQ17GeneralAssistanceAtExitforLeavers(BigInteger.valueOf(gaIncomeAtExit));
		q17CashIncomeSourcesDataBeanTable.setQ17GeneralAssistanceAtLatestAnnualAssessmentforStayers(BigInteger.valueOf(gaIncomeAtAnnualAssesment));
		
		int othersourceIncomeAtEntry = getIncomeCnt(data.getSchema(), entryQuery +"  and othersource ='1' ", DataCollectionStage.ENTRY.getCode(),data);
		int othersourceIncomeAtExit = getIncomeCnt(data.getSchema(), entryQuery +"  and othersource ='1' ", DataCollectionStage.EXIT.getCode(),data);
		int othersourceIncomeAtAnnualAssesment = getIncomeCnt(data.getSchema(), annualAssesmentQuery +" and  othersource ='1' ", DataCollectionStage.ANNUAL_ASSESMENT.getCode(),data);
		
		
		q17CashIncomeSourcesDataBeanTable.setQ17OtherSourcesAtEntry(BigInteger.valueOf(othersourceIncomeAtEntry));
		q17CashIncomeSourcesDataBeanTable.setQ17OtherSourcesAtExitforLeavers(BigInteger.valueOf(othersourceIncomeAtExit));
		q17CashIncomeSourcesDataBeanTable.setQ17OtherSourcesAtLatestAnnualAssessmentforStayers(BigInteger.valueOf(othersourceIncomeAtAnnualAssesment));
		
		int pensionIncomeAtEntry = getIncomeCnt(data.getSchema(), entryQuery +" and  pension ='1' ", DataCollectionStage.ENTRY.getCode(),data);
		int pensionIncomeAtExit = getIncomeCnt(data.getSchema(), entryQuery +"  and pension ='1' ", DataCollectionStage.EXIT.getCode(),data);
		int pensionIncomeAtAnnualAssesment = getIncomeCnt(data.getSchema(), annualAssesmentQuery +"  and pension ='1' ", DataCollectionStage.ANNUAL_ASSESMENT.getCode(),data);
		
		q17CashIncomeSourcesDataBeanTable.setQ17PensionFormerJobAtEntry(BigInteger.valueOf(pensionIncomeAtEntry));
		q17CashIncomeSourcesDataBeanTable.setQ17PensionFormerJobAtExitforLeavers(BigInteger.valueOf(pensionIncomeAtExit));
		q17CashIncomeSourcesDataBeanTable.setQ17PensionFormerJobAtLatestAnnualAssessmentforStayers(BigInteger.valueOf(pensionIncomeAtAnnualAssesment));
		
		
		int privatedisabilityIncomeAtEntry = getIncomeCnt(data.getSchema(), entryQuery +" and  privatedisability ='1' ", DataCollectionStage.ENTRY.getCode(),data);
		int privatedisabilityIncomeAtExit = getIncomeCnt(data.getSchema(), entryQuery +" and  privatedisability ='1' ", DataCollectionStage.EXIT.getCode(),data);
		int privatedisabilityIncomeAtAnnualAssesment = getIncomeCnt(data.getSchema(), annualAssesmentQuery +"  and privatedisability ='1' ", DataCollectionStage.ANNUAL_ASSESMENT.getCode(),data);
		
		q17CashIncomeSourcesDataBeanTable.setQ17PrivateDisabilityAtEntry(BigInteger.valueOf(privatedisabilityIncomeAtEntry));
		q17CashIncomeSourcesDataBeanTable.setQ17PrivateDisabilityAtExitforLeavers(BigInteger.valueOf(privatedisabilityIncomeAtExit));
		q17CashIncomeSourcesDataBeanTable.setQ17PrivateDisabilityAtLatestAnnualAssessmentforStayers(BigInteger.valueOf(privatedisabilityIncomeAtAnnualAssesment));
		
		int socsecretirementIncomeAtEntry = getIncomeCnt(data.getSchema(), entryQuery +"  and socsecretirement ='1' ", DataCollectionStage.ENTRY.getCode(),data);
		int socsecretirementIncomeAtExit = getIncomeCnt(data.getSchema(), entryQuery +" and  socsecretirement ='1' ", DataCollectionStage.EXIT.getCode(),data);
		int socsecretirementIncomeAtAnnualAssesment = getIncomeCnt(data.getSchema(), annualAssesmentQuery +"  and socsecretirement ='1' ", DataCollectionStage.ANNUAL_ASSESMENT.getCode(),data);
		
		q17CashIncomeSourcesDataBeanTable.setQ17RetirementAtEntry(BigInteger.valueOf(socsecretirementIncomeAtEntry));
		q17CashIncomeSourcesDataBeanTable.setQ17RetirementAtExitforLeavers(BigInteger.valueOf(socsecretirementIncomeAtExit));
		q17CashIncomeSourcesDataBeanTable.setQ17RetirementAtLatestAnnualAssessmentforStayers(BigInteger.valueOf(socsecretirementIncomeAtAnnualAssesment));
		
		int ssdiIncomeAtEntry = getIncomeCnt(data.getSchema(), entryQuery +" and  ssdi ='1' ", DataCollectionStage.ENTRY.getCode(),data);
		int ssdiIncomeAtExit = getIncomeCnt(data.getSchema(), entryQuery +" and  ssdi ='1' ", DataCollectionStage.EXIT.getCode(),data);
		int ssdiIncomeAtAnnualAssesment = getIncomeCnt(data.getSchema(), annualAssesmentQuery +" and  ssdi ='1' ", DataCollectionStage.ANNUAL_ASSESMENT.getCode(),data);
		
		q17CashIncomeSourcesDataBeanTable.setQ17SSDIAtEntry(BigInteger.valueOf(ssdiIncomeAtEntry));
		q17CashIncomeSourcesDataBeanTable.setQ17SSDIAtExitforLeavers(BigInteger.valueOf(ssdiIncomeAtExit));
		q17CashIncomeSourcesDataBeanTable.setQ17SSDIAtLatestAnnualAssessmentforStayers(BigInteger.valueOf(ssdiIncomeAtAnnualAssesment));
	
		int ssiIncomeAtEntry = getIncomeCnt(data.getSchema(), entryQuery +"  and ssi ='1' ", DataCollectionStage.ENTRY.getCode(),data);
		int ssiIncomeAtExit = getIncomeCnt(data.getSchema(), entryQuery +"  and ssi ='1' ", DataCollectionStage.EXIT.getCode(),data);
		int ssiIncomeAtAnnualAssesment = getIncomeCnt(data.getSchema(), annualAssesmentQuery +"  and ssi ='1' ", DataCollectionStage.ANNUAL_ASSESMENT.getCode(),data);
		
		q17CashIncomeSourcesDataBeanTable.setQ17SSIAtEntry(BigInteger.valueOf(ssiIncomeAtEntry));
		q17CashIncomeSourcesDataBeanTable.setQ17SSIAtExitforLeavers(BigInteger.valueOf(ssiIncomeAtExit));
		q17CashIncomeSourcesDataBeanTable.setQ17SSIAtLatestAnnualAssessmentforStayers(BigInteger.valueOf(ssiIncomeAtAnnualAssesment));
		
		int tanfIncomeAtEntry = getIncomeCnt(data.getSchema(), entryQuery +" and  tanf ='1' ", DataCollectionStage.ENTRY.getCode(),data);
		int tanfIncomeAtExit = getIncomeCnt(data.getSchema(), entryQuery +"  and  tanf ='1' ", DataCollectionStage.EXIT.getCode(),data);
		int tanfIncomeAtAnnualAssesment = getIncomeCnt(data.getSchema(), annualAssesmentQuery +"  and tanf ='1' ", DataCollectionStage.ANNUAL_ASSESMENT.getCode(),data);
		
		q17CashIncomeSourcesDataBeanTable.setQ17TANFAtEntry(BigInteger.valueOf(tanfIncomeAtEntry));
		q17CashIncomeSourcesDataBeanTable.setQ17TANFAtExitforLeavers(BigInteger.valueOf(tanfIncomeAtExit));
		q17CashIncomeSourcesDataBeanTable.setQ17TANFAtLatestAnnualAssessmentforStayers(BigInteger.valueOf(tanfIncomeAtAnnualAssesment));
		
		int unemploymentIncomeAtEntry = getIncomeCnt(data.getSchema(), entryQuery +" and  unemployment ='1' ", DataCollectionStage.ENTRY.getCode(),data);
		int unemploymentIncomeAtExit = getIncomeCnt(data.getSchema(), entryQuery +"  and unemployment ='1' ", DataCollectionStage.EXIT.getCode(),data);
		int unemploymentIncomeAtAnnualAssesment = getIncomeCnt(data.getSchema(), annualAssesmentQuery +"  and unemployment ='1' ", DataCollectionStage.ANNUAL_ASSESMENT.getCode(),data);
		
		q17CashIncomeSourcesDataBeanTable.setQ17UnemployementInsuranceAtEntry(BigInteger.valueOf(unemploymentIncomeAtEntry));
		q17CashIncomeSourcesDataBeanTable.setQ17UnemployementInsuranceAtExitforLeavers(BigInteger.valueOf(unemploymentIncomeAtExit));
		q17CashIncomeSourcesDataBeanTable.setQ17UnemployementInsuranceAtLatestAnnualAssessmentforStayers(BigInteger.valueOf(unemploymentIncomeAtAnnualAssesment));
		
		int vadisabilitynonserviceIncomeAtEntry = getIncomeCnt(data.getSchema(), entryQuery +" and  vadisabilitynonservice ='1' ", DataCollectionStage.ENTRY.getCode(),data);
		int vadisabilitynonserviceIncomeAtExit = getIncomeCnt(data.getSchema(), entryQuery +" and  vadisabilitynonservice ='1' ", DataCollectionStage.EXIT.getCode(),data);
		int vadisabilitynonserviceIncomeAtAnnualAssesment = getIncomeCnt(data.getSchema(), annualAssesmentQuery +" and  vadisabilitynonservice ='1' ", DataCollectionStage.ANNUAL_ASSESMENT.getCode(),data);
		
		q17CashIncomeSourcesDataBeanTable.setQ17VANonServiceAtEntry(BigInteger.valueOf(vadisabilitynonserviceIncomeAtEntry));
		q17CashIncomeSourcesDataBeanTable.setQ17VANonServiceAtExitforLeavers(BigInteger.valueOf(vadisabilitynonserviceIncomeAtExit));
		q17CashIncomeSourcesDataBeanTable.setQ17VANonServiceAtLatestAnnualAssessmentforStayers(BigInteger.valueOf(vadisabilitynonserviceIncomeAtAnnualAssesment));
		
		
		int vadisabilityserviceIncomeAtEntry = getIncomeCnt(data.getSchema(), entryQuery +"  and vadisabilityservice ='1' ", DataCollectionStage.ENTRY.getCode(),data);
		int vadisabilityserviceIncomeAtExit = getIncomeCnt(data.getSchema(), entryQuery +" and  vadisabilityservice ='1' ", DataCollectionStage.EXIT.getCode(),data);
		int vadisabilityserviceIncomeAtAnnualAssesment = getIncomeCnt(data.getSchema(), annualAssesmentQuery +" and  vadisabilityservice ='1' ", DataCollectionStage.ANNUAL_ASSESMENT.getCode(),data);
		
		q17CashIncomeSourcesDataBeanTable.setQ17VAServiceAtEntry(BigInteger.valueOf(vadisabilityserviceIncomeAtEntry));
		q17CashIncomeSourcesDataBeanTable.setQ17VAServiceAtExitforLeavers(BigInteger.valueOf(vadisabilityserviceIncomeAtExit));
		q17CashIncomeSourcesDataBeanTable.setQ17VAServiceAtLatestAnnualAssessmentforStayers(BigInteger.valueOf(vadisabilityserviceIncomeAtAnnualAssesment));
		
		int workerscompIncomeAtEntry = getIncomeCnt(data.getSchema(), entryQuery +" and  workerscomp ='1' ", DataCollectionStage.ENTRY.getCode(),data);
		int workerscompIncomeAtExit = getIncomeCnt(data.getSchema(), entryQuery +" and  workerscomp ='1' ", DataCollectionStage.EXIT.getCode(),data);
		int workerscompIncomeAtAnnualAssesment = getIncomeCnt(data.getSchema(), entryQuery +" and  workerscomp ='1' ", DataCollectionStage.ANNUAL_ASSESMENT.getCode(),data);
		
		q17CashIncomeSourcesDataBeanTable.setQ17WorkersCompensationAtEntry(BigInteger.valueOf(workerscompIncomeAtEntry));
		q17CashIncomeSourcesDataBeanTable.setQ17WorkersCompensationAtExitforLeavers(BigInteger.valueOf(workerscompIncomeAtExit));
		q17CashIncomeSourcesDataBeanTable.setQ17WorkersCompensationAtLatestAnnualAssessmentforStayers(BigInteger.valueOf(workerscompIncomeAtAnnualAssesment));
		
		
		String adultsIncomeQuery = " select dedup_client_id  from %s.incomeandsources i, %s.enrollment e where i.datacollectionstage=:datacollectionstage and  e.id=i.enrollmentid "+ 
				" and i.information_date >= e.entrydate and i.information_date >= :startDate and i.information_date <= :endDate order by dedup_client_id ";
		data.setQueryDataCollectionStage(DataCollectionStage.EXIT.getCode());
		List<String> enrollmentsAtEnrty = getClients(data.getSchema(), adultsIncomeQuery,data);
		data.setQueryDataCollectionStage(DataCollectionStage.EXIT.getCode());
		List<String> enrollmentsAtExit = getClients(data.getSchema(), adultsIncomeQuery, data);
		data.setQueryDataCollectionStage(DataCollectionStage.ANNUAL_ASSESMENT.getCode());
		List<String> enrollmentsAtAnnualAssesment = getClients(data.getSchema(), adultsIncomeQuery,data);
	
		q17CashIncomeSourcesDataBeanTable.setQ17AdultsWithIncomeAtEntry(BigInteger.valueOf(0));
		q17CashIncomeSourcesDataBeanTable.setQ17AdultsWithIncomeAtExitforLeavers(BigInteger.valueOf(0));
		q17CashIncomeSourcesDataBeanTable.setQ17AdultsWithIncomeAtLatestAnnualAssessmentforStayers(BigInteger.valueOf(0));
		
		if(CollectionUtils.isNotEmpty(enrollmentsAtExit) && CollectionUtils.isNotEmpty(enrollmentsAtEnrty)) {
			int cnt =0;
			for(String dedupClient : enrollmentsAtExit) {
				if(enrollmentsAtEnrty.contains(dedupClient)) {
					cnt++;
				}
			}
			q17CashIncomeSourcesDataBeanTable.setQ17AdultsWithIncomeAtExitforLeavers(BigInteger.valueOf(cnt));
		}
		if(CollectionUtils.isNotEmpty(enrollmentsAtAnnualAssesment) && CollectionUtils.isNotEmpty(enrollmentsAtEnrty)) {
			int cnt =0;
			for(String dedupClient : enrollmentsAtAnnualAssesment) {
				if(enrollmentsAtEnrty.contains(dedupClient)) {
					cnt++;
				}
			}
			q17CashIncomeSourcesDataBeanTable.setQ17AdultsWithIncomeAtLatestAnnualAssessmentforStayers(BigInteger.valueOf(cnt));
		}
		
	} catch (Exception e) {
		logger.error("Error in Q17BeanMaker:" + e);
	}
		}
		return Arrays.asList(q17CashIncomeSourcesDataBeanTable);
	}
	
	public static int getIncomeCnt(String schema,String query,String datacollectionStage,ReportData data) {
		ResultSet resultSet = null;
		Statement statement = null;
		Connection connection = null;
		int count =0;
		try {
			connection = ImpalaConnection.getConnection();
			statement = connection.createStatement();
			data.setQueryDataCollectionStage(datacollectionStage);
			resultSet = statement.executeQuery(formatQuery(query,schema,data));
			
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
	
	
	public static int getIncomeCntForAnnualAssesment(String schema,String query,String datacollectionStage,ReportData data) {
		ResultSet resultSet = null;
		Statement statement = null;
		Connection connection = null;
		int count =0;
		try {
			connection = ImpalaConnection.getConnection();
			statement = connection.createStatement();
			data.setQueryDataCollectionStage(datacollectionStage);
			resultSet = statement.executeQuery(formatQuery(query,schema,data));
			
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
