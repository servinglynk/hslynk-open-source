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
import com.servinglynk.report.bean.Q26gTypeOfCashIncomeSourcesChronicallyHomelessDataBean;
import com.servinglynk.report.bean.ReportData;
import com.servinglynk.report.model.DataCollectionStage;

public class Q26gTypeOfCashIncomeSourcesChronicallyHomelessDataBeanMaker extends BaseBeanMaker{
	
	public static List<Q26gTypeOfCashIncomeSourcesChronicallyHomelessDataBean> getQ26gTypeOfCashIncomeSourcesChronicallyHomelessList(ReportData data){
		
		Q26gTypeOfCashIncomeSourcesChronicallyHomelessDataBean q26gDataBean = new Q26gTypeOfCashIncomeSourcesChronicallyHomelessDataBean();
		
		if(data.isLiveMode()) {
			try{
			String entryQuery = " select count(e.dedup_client_id) as cnt  from %s.incomeandsources i, %s.enrollment e ,%s.client c where  e.client_id = c.id and   e.id=i.enrollmentid "+ 
								" and i.information_date >= e.entrydate and i.information_date >= :startDate and i.information_date <= :endDate and e.chronichomeless='true' and i.datacollectionstage=:datacollectionstage and e.ageatentry >= 18 ";
		
			String annualAssesmentQuery = " select count(distinct(e.dedup_client_id)) as cnt  from %s.incomeandsources i, %s.enrollment e,%s.client c where   e.client_id = c.id and  e.id=i.enrollmentid and e.chronichomeless='true' "+ 
					" and i.information_date >= e.entrydate and i.datacollectionstage=:datacollectionstage  and i.information_date >= :startDate and i.information_date <= :endDate  and e.ageatentry >= 18 "+
					" and   e.id not in ( select enrollmentid from %s.exit  where exitdate <= :startDate )  "+
					" and   e.id not in ( select enrollmentid from %s.enrollment_coc where datacollectionstage=:datacollectionstage and datediff(now(),information_date) > 365 )  ";

			
			int alimonyIncomeAtEntry = getIncomeCnt(data.getSchema(), entryQuery +" and alimony ='1' ", DataCollectionStage.ENTRY.getCode(),data);
			int alimonyIncomeAtExit = getIncomeCnt(data.getSchema(), entryQuery +" and  alimony ='1' ", DataCollectionStage.EXIT.getCode(),data);
			int alimonyIncomeAtAnnualAssesment = getIncomeCntForAnnualAssesment(data.getSchema(), annualAssesmentQuery +"  and alimony ='1' ", DataCollectionStage.ANNUAL_ASSESMENT.getCode(),data);
			
			q26gDataBean.setQ26gAlimonyAtEntry(BigInteger.valueOf(alimonyIncomeAtEntry));
			q26gDataBean.setQ26gAlimonyLeavers(BigInteger.valueOf(alimonyIncomeAtExit));
			q26gDataBean.setQ26gAlimonyStayers(BigInteger.valueOf(alimonyIncomeAtAnnualAssesment));
			
			int childsupportIncomeAtEntry = getIncomeCnt(data.getSchema(), entryQuery +"  and childsupport ='1' ", DataCollectionStage.ENTRY.getCode(),data);
			int childsupportIncomeAtExit = getIncomeCnt(data.getSchema(), entryQuery +"  and childsupport ='1' ", DataCollectionStage.EXIT.getCode(),data);
			int childsupportIncomeAtAnnualAssesment = getIncomeCnt(data.getSchema(), annualAssesmentQuery +"  and childsupport ='1' ", DataCollectionStage.ANNUAL_ASSESMENT.getCode(),data);
			
			q26gDataBean.setQ26gChildSupportAtEntry(BigInteger.valueOf(childsupportIncomeAtEntry));
			q26gDataBean.setQ26gChildSupportLeavers(BigInteger.valueOf(childsupportIncomeAtExit));
			q26gDataBean.setQ26gChildSupportStayers(BigInteger.valueOf(childsupportIncomeAtAnnualAssesment));
			
			int earnedIncomeAtEntry = getIncomeCnt(data.getSchema(), entryQuery +" and  earned ='1' ", DataCollectionStage.ENTRY.getCode(),data);
			int earnedIncomeAtExit = getIncomeCnt(data.getSchema(), entryQuery +" and  earned ='1' ", DataCollectionStage.EXIT.getCode(),data);
			int earnedIncomeAtAnnualAssesment = getIncomeCnt(data.getSchema(), annualAssesmentQuery +"  and earned ='1' ", DataCollectionStage.ANNUAL_ASSESMENT.getCode(),data);
			
			q26gDataBean.setQ26gEarnedIncomeAtEntry(BigInteger.valueOf(earnedIncomeAtEntry));
			q26gDataBean.setQ26gEarnedIncomeLeavers(BigInteger.valueOf(earnedIncomeAtExit));
			q26gDataBean.setQ26gEarnedIncomeStayers(BigInteger.valueOf(earnedIncomeAtAnnualAssesment));
			
			
			int gaIncomeAtEntry = getIncomeCnt(data.getSchema(), entryQuery +"  and ga ='1' ", DataCollectionStage.ENTRY.getCode(),data);
			int gaIncomeAtExit = getIncomeCnt(data.getSchema(), entryQuery +"  and ga ='1' ", DataCollectionStage.EXIT.getCode(),data);
			int gaIncomeAtAnnualAssesment = getIncomeCnt(data.getSchema(), annualAssesmentQuery +"  and ga ='1' ", DataCollectionStage.ANNUAL_ASSESMENT.getCode(),data);
			
			q26gDataBean.setQ26gGeneralAssistanceAtEntry(BigInteger.valueOf(gaIncomeAtEntry));
			q26gDataBean.setQ26gGeneralAssistanceLeavers(BigInteger.valueOf(gaIncomeAtExit));
			q26gDataBean.setQ26gGeneralAssistanceStayers(BigInteger.valueOf(gaIncomeAtAnnualAssesment));
			
			int othersourceIncomeAtEntry = getIncomeCnt(data.getSchema(), entryQuery +"  and othersource ='1' ", DataCollectionStage.ENTRY.getCode(),data);
			int othersourceIncomeAtExit = getIncomeCnt(data.getSchema(), entryQuery +"  and othersource ='1' ", DataCollectionStage.EXIT.getCode(),data);
			int othersourceIncomeAtAnnualAssesment = getIncomeCnt(data.getSchema(), annualAssesmentQuery +" and  othersource ='1' ", DataCollectionStage.ANNUAL_ASSESMENT.getCode(),data);
			
			
			q26gDataBean.setQ26gOtherSourceAtEntry(BigInteger.valueOf(othersourceIncomeAtEntry));
			q26gDataBean.setQ26gOtherSourceLeavers(BigInteger.valueOf(othersourceIncomeAtExit));
			q26gDataBean.setQ26gOtherSourceStayers(BigInteger.valueOf(othersourceIncomeAtAnnualAssesment));
			
			int pensionIncomeAtEntry = getIncomeCnt(data.getSchema(), entryQuery +" and  pension ='1' ", DataCollectionStage.ENTRY.getCode(),data);
			int pensionIncomeAtExit = getIncomeCnt(data.getSchema(), entryQuery +"  and pension ='1' ", DataCollectionStage.EXIT.getCode(),data);
			int pensionIncomeAtAnnualAssesment = getIncomeCnt(data.getSchema(), annualAssesmentQuery +"  and pension ='1' ", DataCollectionStage.ANNUAL_ASSESMENT.getCode(),data);
			
			q26gDataBean.setQ26gPensionFromFormerJobAtEntry(BigInteger.valueOf(pensionIncomeAtEntry));
			q26gDataBean.setQ26gPensionFromFormerJobLeavers(BigInteger.valueOf(pensionIncomeAtExit));
			q26gDataBean.setQ26gPensionFromFormerJobStayers(BigInteger.valueOf(pensionIncomeAtAnnualAssesment));
			
			
			int privatedisabilityIncomeAtEntry = getIncomeCnt(data.getSchema(), entryQuery +" and  privatedisability ='1' ", DataCollectionStage.ENTRY.getCode(),data);
			int privatedisabilityIncomeAtExit = getIncomeCnt(data.getSchema(), entryQuery +" and  privatedisability ='1' ", DataCollectionStage.EXIT.getCode(),data);
			int privatedisabilityIncomeAtAnnualAssesment = getIncomeCnt(data.getSchema(), annualAssesmentQuery +"  and privatedisability ='1' ", DataCollectionStage.ANNUAL_ASSESMENT.getCode(),data);
			
			q26gDataBean.setQ26gPrivateDisabilityInsuranceAtEntry(BigInteger.valueOf(privatedisabilityIncomeAtEntry));
			q26gDataBean.setQ26gPrivateDisabilityInsuranceLeavers(BigInteger.valueOf(privatedisabilityIncomeAtExit));
			q26gDataBean.setQ26gPrivateDisabilityInsuranceStayers(BigInteger.valueOf(privatedisabilityIncomeAtAnnualAssesment));
			
			int socsecretirementIncomeAtEntry = getIncomeCnt(data.getSchema(), entryQuery +"  and socsecretirement ='1' ", DataCollectionStage.ENTRY.getCode(),data);
			int socsecretirementIncomeAtExit = getIncomeCnt(data.getSchema(), entryQuery +" and  socsecretirement ='1' ", DataCollectionStage.EXIT.getCode(),data);
			int socsecretirementIncomeAtAnnualAssesment = getIncomeCnt(data.getSchema(), annualAssesmentQuery +"  and socsecretirement ='1' ", DataCollectionStage.ANNUAL_ASSESMENT.getCode(),data);
			
			q26gDataBean.setQ26gRetirementAtEntry(BigInteger.valueOf(socsecretirementIncomeAtEntry));
			q26gDataBean.setQ26gRetirementLeavers(BigInteger.valueOf(socsecretirementIncomeAtExit));
			q26gDataBean.setQ26gRetirementStayers(BigInteger.valueOf(socsecretirementIncomeAtAnnualAssesment));
			
			int ssdiIncomeAtEntry = getIncomeCnt(data.getSchema(), entryQuery +" and  ssdi ='1' ", DataCollectionStage.ENTRY.getCode(),data);
			int ssdiIncomeAtExit = getIncomeCnt(data.getSchema(), entryQuery +" and  ssdi ='1' ", DataCollectionStage.EXIT.getCode(),data);
			int ssdiIncomeAtAnnualAssesment = getIncomeCnt(data.getSchema(), annualAssesmentQuery +" and  ssdi ='1' ", DataCollectionStage.ANNUAL_ASSESMENT.getCode(),data);
			
			q26gDataBean.setQ26gSSDIAtEntry(BigInteger.valueOf(ssdiIncomeAtEntry));
			q26gDataBean.setQ26gSSDILeavers(BigInteger.valueOf(ssdiIncomeAtExit));
			q26gDataBean.setQ26gSSDIStayers(BigInteger.valueOf(ssdiIncomeAtAnnualAssesment));
		
			int ssiIncomeAtEntry = getIncomeCnt(data.getSchema(), entryQuery +"  and ssi ='1' ", DataCollectionStage.ENTRY.getCode(),data);
			int ssiIncomeAtExit = getIncomeCnt(data.getSchema(), entryQuery +"  and ssi ='1' ", DataCollectionStage.EXIT.getCode(),data);
			int ssiIncomeAtAnnualAssesment = getIncomeCnt(data.getSchema(), annualAssesmentQuery +"  and ssi ='1' ", DataCollectionStage.ANNUAL_ASSESMENT.getCode(),data);
			
			q26gDataBean.setQ26gSSIAtEntry(BigInteger.valueOf(ssiIncomeAtEntry));
			q26gDataBean.setQ26gSSILeavers(BigInteger.valueOf(ssiIncomeAtExit));
			q26gDataBean.setQ26gSSIStayers(BigInteger.valueOf(ssiIncomeAtAnnualAssesment));
			
			int tanfIncomeAtEntry = getIncomeCnt(data.getSchema(), entryQuery +" and  tanf ='1' ", DataCollectionStage.ENTRY.getCode(),data);
			int tanfIncomeAtExit = getIncomeCnt(data.getSchema(), entryQuery +"  and  tanf ='1' ", DataCollectionStage.EXIT.getCode(),data);
			int tanfIncomeAtAnnualAssesment = getIncomeCnt(data.getSchema(), annualAssesmentQuery +"  and tanf ='1' ", DataCollectionStage.ANNUAL_ASSESMENT.getCode(),data);
			
			q26gDataBean.setQ26gTANFAtEntry(BigInteger.valueOf(tanfIncomeAtEntry));
			q26gDataBean.setQ26gTANFLeavers(BigInteger.valueOf(tanfIncomeAtExit));
			q26gDataBean.setQ26gTANFStayers(BigInteger.valueOf(tanfIncomeAtAnnualAssesment));
			
			int unemploymentIncomeAtEntry = getIncomeCnt(data.getSchema(), entryQuery +" and  unemployment ='1' ", DataCollectionStage.ENTRY.getCode(),data);
			int unemploymentIncomeAtExit = getIncomeCnt(data.getSchema(), entryQuery +"  and unemployment ='1' ", DataCollectionStage.EXIT.getCode(),data);
			int unemploymentIncomeAtAnnualAssesment = getIncomeCnt(data.getSchema(), annualAssesmentQuery +"  and unemployment ='1' ", DataCollectionStage.ANNUAL_ASSESMENT.getCode(),data);
			
			q26gDataBean.setQ26gUnemploymentInsuranceAtEntry(BigInteger.valueOf(unemploymentIncomeAtEntry));
			q26gDataBean.setQ26gUnemploymentInsuranceLeavers(BigInteger.valueOf(unemploymentIncomeAtExit));
			q26gDataBean.setQ26gUnemploymentInsuranceStayers(BigInteger.valueOf(unemploymentIncomeAtAnnualAssesment));
			
			int vadisabilitynonserviceIncomeAtEntry = getIncomeCnt(data.getSchema(), entryQuery +" and  vadisabilitynonservice ='1' ", DataCollectionStage.ENTRY.getCode(),data);
			int vadisabilitynonserviceIncomeAtExit = getIncomeCnt(data.getSchema(), entryQuery +" and  vadisabilitynonservice ='1' ", DataCollectionStage.EXIT.getCode(),data);
			int vadisabilitynonserviceIncomeAtAnnualAssesment = getIncomeCnt(data.getSchema(), annualAssesmentQuery +" and  vadisabilitynonservice ='1' ", DataCollectionStage.ANNUAL_ASSESMENT.getCode(),data);
			
			q26gDataBean.setQ26gVANonServiceConnectedDisabilityAtEntry(BigInteger.valueOf(vadisabilitynonserviceIncomeAtEntry));
			q26gDataBean.setQ26gVANonServiceConnectedDisabilityLeavers(BigInteger.valueOf(vadisabilitynonserviceIncomeAtExit));
			q26gDataBean.setQ26gVANonServiceConnectedDisabilityStayers(BigInteger.valueOf(vadisabilitynonserviceIncomeAtAnnualAssesment));
			
			
			int vadisabilityserviceIncomeAtEntry = getIncomeCnt(data.getSchema(), entryQuery +"  and vadisabilityservice ='1' ", DataCollectionStage.ENTRY.getCode(),data);
			int vadisabilityserviceIncomeAtExit = getIncomeCnt(data.getSchema(), entryQuery +" and  vadisabilityservice ='1' ", DataCollectionStage.EXIT.getCode(),data);
			int vadisabilityserviceIncomeAtAnnualAssesment = getIncomeCnt(data.getSchema(), annualAssesmentQuery +" and  vadisabilityservice ='1' ", DataCollectionStage.ANNUAL_ASSESMENT.getCode(),data);
			
			q26gDataBean.setQ26gVAServiceConnectedDisabilityAtEntry(BigInteger.valueOf(vadisabilityserviceIncomeAtEntry));
			q26gDataBean.setQ26gVAServiceConnectedDisabilityLeavers(BigInteger.valueOf(vadisabilityserviceIncomeAtExit));
			q26gDataBean.setQ26gVAServiceConnectedDisabilityStayers(BigInteger.valueOf(vadisabilityserviceIncomeAtAnnualAssesment));
			
			int workerscompIncomeAtEntry = getIncomeCnt(data.getSchema(), entryQuery +" and  workerscomp ='1' ", DataCollectionStage.ENTRY.getCode(),data);
			int workerscompIncomeAtExit = getIncomeCnt(data.getSchema(), entryQuery +" and  workerscomp ='1' ", DataCollectionStage.EXIT.getCode(),data);
			int workerscompIncomeAtAnnualAssesment = getIncomeCnt(data.getSchema(), entryQuery +" and  workerscomp ='1' ", DataCollectionStage.ANNUAL_ASSESMENT.getCode(),data);
			
			q26gDataBean.setQ26gWorkerCompensationAtEntry(BigInteger.valueOf(workerscompIncomeAtEntry));
			q26gDataBean.setQ26gWorkerCompensationLeavers(BigInteger.valueOf(workerscompIncomeAtExit));
			q26gDataBean.setQ26gWorkerCompensationStayers(BigInteger.valueOf(workerscompIncomeAtAnnualAssesment));
			
			
			String adultsIncomeQuery = " select dedup_client_id  from %s.incomeandsources i, %s.enrollment e,%s.client c where  e.client_id = c.id and i.datacollectionstage=:datacollectionstage and  e.id=i.enrollmentid "+ 
					" and i.information_date >= e.entrydate and i.information_date >= :startDate and i.information_date <= :endDate order by dedup_client_id ";
			data.setQueryDataCollectionStage(DataCollectionStage.EXIT.getCode());
			List<String> enrollmentsAtEnrty = getClients(data.getSchema(), adultsIncomeQuery,data);
			data.setQueryDataCollectionStage(DataCollectionStage.EXIT.getCode());
			List<String> enrollmentsAtExit = getClients(data.getSchema(), adultsIncomeQuery, data);
			data.setQueryDataCollectionStage(DataCollectionStage.ANNUAL_ASSESMENT.getCode());
			List<String> enrollmentsAtAnnualAssesment = getClients(data.getSchema(), adultsIncomeQuery,data);
		
			q26gDataBean.setQ26gAdultsWithIncomeInfoAtEntry(BigInteger.valueOf(0));
			q26gDataBean.setQ26gAdultsWithIncomeInfoLeavers(BigInteger.valueOf(0));
			q26gDataBean.setQ26gAdultsWithIncomeInfoStayers(BigInteger.valueOf(0));
			
			if(CollectionUtils.isNotEmpty(enrollmentsAtExit) && CollectionUtils.isNotEmpty(enrollmentsAtEnrty)) {
				int cnt =0;
				for(String dedupClient : enrollmentsAtExit) {
					if(enrollmentsAtEnrty.contains(dedupClient)) {
						cnt++;
					}
				}
				q26gDataBean.setQ26gAdultsWithIncomeInfoLeavers(BigInteger.valueOf(cnt));
			}
			if(CollectionUtils.isNotEmpty(enrollmentsAtAnnualAssesment) && CollectionUtils.isNotEmpty(enrollmentsAtEnrty)) {
				int cnt =0;
				for(String dedupClient : enrollmentsAtAnnualAssesment) {
					if(enrollmentsAtEnrty.contains(dedupClient)) {
						cnt++;
					}
				}
				q26gDataBean.setQ26gAdultsWithIncomeInfoStayers(BigInteger.valueOf(cnt));
			}
			
		} catch (Exception e) {
			logger.error("Error in Q17BeanMaker:" + e);
		}
			}
			return Arrays.asList(q26gDataBean);
		}
		
		public static List<String> getClients(String schema,String query,ReportData data) {
			ResultSet resultSet = null;
			List<String> enrollments = new ArrayList<>();
			Statement statement = null;
			Connection connection = null;
			try {
				connection = ImpalaConnection.getConnection();
				statement = connection.createStatement();
				resultSet = statement.executeQuery(formatQuery(query,schema,data));
				
			 while(resultSet.next()) {
				 enrollments.add(resultSet.getString(1));
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
			return enrollments;
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

