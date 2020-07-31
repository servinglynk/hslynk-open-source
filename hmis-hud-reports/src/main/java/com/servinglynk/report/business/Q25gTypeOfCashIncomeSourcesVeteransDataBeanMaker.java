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
import com.servinglynk.report.bean.Q25gTypeOfCashIncomeSourcesVeteransDataBean;
import com.servinglynk.report.bean.ReportData;
import com.servinglynk.report.model.ClientModel;
import com.servinglynk.report.model.DataCollectionStage;

public class Q25gTypeOfCashIncomeSourcesVeteransDataBeanMaker extends BaseBeanMaker {
	
	public static List<Q25gTypeOfCashIncomeSourcesVeteransDataBean> getQ25gTypeOfCashIncomeSourcesVeteranList(ReportData data){
		
		Q25gTypeOfCashIncomeSourcesVeteransDataBean q25gDataBean = new Q25gTypeOfCashIncomeSourcesVeteransDataBean();
		
		if(data.isLiveMode()) {
			try{
			String entryQuery = " select count(e.dedup_client_id) as cnt  from %s.incomeandsources i, %s.enrollment e ,%s.client c where  e.client_id = c.id and   e.id=i.enrollmentid "+ 
								" and TO_DATE(i.information_date) = TO_DATE(e.entrydate)  and i.information_date <= :endDate and c.veteran_status= '1' and i.datacollectionstage='1' and e.ageatentry >= 18 ";
			
			String exitQuery = " select count(e.dedup_client_id) as cnt  from %s.incomeandsources i, %s.enrollment e ,%s.client c,%s.exit ext where  e.client_id = c.id and   e.id=i.enrollmentid  and   e.id=ext.enrollmentid"+ 
					" and TO_DATE(i.information_date) = TO_DATE(ext.exitdate)  and i.information_date <= :endDate and c.veteran_status= '1' and i.datacollectionstage='3' and e.ageatentry >= 18 ";

			String annualAssesmentQuery = " select count(distinct(e.dedup_client_id)) as cnt  from %s.incomeandsources i, %s.enrollment e,%s.client c where   e.client_id = c.id and  e.id=i.enrollmentid and c.veteran_status= '1' "+ 
					" and i.information_date >= e.entrydate and i.datacollectionstage='5' and i.information_date >= e.entrydate and i.information_date <= :endDate  and e.ageatentry >= 18 ";

			
			int alimonyIncomeAtEntry = getIncomeCntForVeterans(data.getSchema(), entryQuery +" and alimony ='1' ", DataCollectionStage.ENTRY.getCode(),data);
			int alimonyIncomeAtExit = getIncomeCntForVeterans(data.getSchema(), exitQuery +" and  alimony ='1' ", DataCollectionStage.EXIT.getCode(),data);
			int alimonyIncomeAtAnnualAssesment = getIncomeCntForVeterans(data.getSchema(), annualAssesmentQuery +"  and alimony ='1' ", DataCollectionStage.ANNUAL_ASSESMENT.getCode(),data);
			
			q25gDataBean.setQ25gAlimonyAtEntry(BigInteger.valueOf(alimonyIncomeAtEntry));
			q25gDataBean.setQ25gAlimonyLeavers(BigInteger.valueOf(alimonyIncomeAtExit));
			q25gDataBean.setQ25gAlimonyStayers(BigInteger.valueOf(alimonyIncomeAtAnnualAssesment));
			
			int childsupportIncomeAtEntry = getIncomeCntForVeterans(data.getSchema(), entryQuery +"  and childsupport ='1' ", DataCollectionStage.ENTRY.getCode(),data);
			int childsupportIncomeAtExit = getIncomeCntForVeterans(data.getSchema(), exitQuery +"  and childsupport ='1' ", DataCollectionStage.EXIT.getCode(),data);
			int childsupportIncomeAtAnnualAssesment = getIncomeCntForVeterans(data.getSchema(), annualAssesmentQuery +"  and childsupport ='1' ", DataCollectionStage.ANNUAL_ASSESMENT.getCode(),data);
			
			q25gDataBean.setQ25gChildSupportAtEntry(BigInteger.valueOf(childsupportIncomeAtEntry));
			q25gDataBean.setQ25gChildSupportLeavers(BigInteger.valueOf(childsupportIncomeAtExit));
			q25gDataBean.setQ25gChildSupportStayers(BigInteger.valueOf(childsupportIncomeAtAnnualAssesment));
			
			int earnedIncomeAtEntry = getIncomeCntForVeterans(data.getSchema(), entryQuery +" and  earned ='1' ", DataCollectionStage.ENTRY.getCode(),data);
			int earnedIncomeAtExit = getIncomeCntForVeterans(data.getSchema(), exitQuery +" and  earned ='1' ", DataCollectionStage.EXIT.getCode(),data);
			int earnedIncomeAtAnnualAssesment = getIncomeCntForVeterans(data.getSchema(), annualAssesmentQuery +"  and earned ='1' ", DataCollectionStage.ANNUAL_ASSESMENT.getCode(),data);
			
			q25gDataBean.setQ25gEarnedIncomeAtEntry(BigInteger.valueOf(earnedIncomeAtEntry));
			q25gDataBean.setQ25gEarnedIncomeLeavers(BigInteger.valueOf(earnedIncomeAtExit));
			q25gDataBean.setQ25gEarnedIncomeStayers(BigInteger.valueOf(earnedIncomeAtAnnualAssesment));
			
			
			int gaIncomeAtEntry = getIncomeCntForVeterans(data.getSchema(), entryQuery +"  and ga ='1' ", DataCollectionStage.ENTRY.getCode(),data);
			int gaIncomeAtExit = getIncomeCntForVeterans(data.getSchema(), exitQuery +"  and ga ='1' ", DataCollectionStage.EXIT.getCode(),data);
			int gaIncomeAtAnnualAssesment = getIncomeCntForVeterans(data.getSchema(), annualAssesmentQuery +"  and ga ='1' ", DataCollectionStage.ANNUAL_ASSESMENT.getCode(),data);
			
			q25gDataBean.setQ25gGeneralAssistanceAtEntry(BigInteger.valueOf(gaIncomeAtEntry));
			q25gDataBean.setQ25gGeneralAssistanceLeavers(BigInteger.valueOf(gaIncomeAtExit));
			q25gDataBean.setQ25gGeneralAssistanceStayers(BigInteger.valueOf(gaIncomeAtAnnualAssesment));
			
			int othersourceIncomeAtEntry = getIncomeCntForVeterans(data.getSchema(), entryQuery +"  and othersource ='1' ", DataCollectionStage.ENTRY.getCode(),data);
			int othersourceIncomeAtExit = getIncomeCntForVeterans(data.getSchema(), exitQuery +"  and othersource ='1' ", DataCollectionStage.EXIT.getCode(),data);
			int othersourceIncomeAtAnnualAssesment = getIncomeCntForVeterans(data.getSchema(), annualAssesmentQuery +" and  othersource ='1' ", DataCollectionStage.ANNUAL_ASSESMENT.getCode(),data);
			
			
			q25gDataBean.setQ25gOtherSourceAtEntry(BigInteger.valueOf(othersourceIncomeAtEntry));
			q25gDataBean.setQ25gOtherSourceLeavers(BigInteger.valueOf(othersourceIncomeAtExit));
			q25gDataBean.setQ25gOtherSourceStayers(BigInteger.valueOf(othersourceIncomeAtAnnualAssesment));
			
			int pensionIncomeAtEntry = getIncomeCntForVeterans(data.getSchema(), entryQuery +" and  pension ='1' ", DataCollectionStage.ENTRY.getCode(),data);
			int pensionIncomeAtExit = getIncomeCntForVeterans(data.getSchema(), exitQuery +"  and pension ='1' ", DataCollectionStage.EXIT.getCode(),data);
			int pensionIncomeAtAnnualAssesment = getIncomeCntForVeterans(data.getSchema(), annualAssesmentQuery +"  and pension ='1' ", DataCollectionStage.ANNUAL_ASSESMENT.getCode(),data);
			
			q25gDataBean.setQ25gPensionFromFormerJobAtEntry(BigInteger.valueOf(pensionIncomeAtEntry));
			q25gDataBean.setQ25gPensionFromFormerJobLeavers(BigInteger.valueOf(pensionIncomeAtExit));
			q25gDataBean.setQ25gPensionFromFormerJobStayers(BigInteger.valueOf(pensionIncomeAtAnnualAssesment));
			
			
			int privatedisabilityIncomeAtEntry = getIncomeCntForVeterans(data.getSchema(), entryQuery +" and  privatedisability ='1' ", DataCollectionStage.ENTRY.getCode(),data);
			int privatedisabilityIncomeAtExit = getIncomeCntForVeterans(data.getSchema(), exitQuery +" and  privatedisability ='1' ", DataCollectionStage.EXIT.getCode(),data);
			int privatedisabilityIncomeAtAnnualAssesment = getIncomeCntForVeterans(data.getSchema(), annualAssesmentQuery +"  and privatedisability ='1' ", DataCollectionStage.ANNUAL_ASSESMENT.getCode(),data);
			
			q25gDataBean.setQ25gPrivateDisabilityInsuranceAtEntry(BigInteger.valueOf(privatedisabilityIncomeAtEntry));
			q25gDataBean.setQ25gPrivateDisabilityInsuranceLeavers(BigInteger.valueOf(privatedisabilityIncomeAtExit));
			q25gDataBean.setQ25gPrivateDisabilityInsuranceStayers(BigInteger.valueOf(privatedisabilityIncomeAtAnnualAssesment));
			
			int socsecretirementIncomeAtEntry = getIncomeCntForVeterans(data.getSchema(), entryQuery +"  and socsecretirement ='1' ", DataCollectionStage.ENTRY.getCode(),data);
			int socsecretirementIncomeAtExit = getIncomeCntForVeterans(data.getSchema(), exitQuery +" and  socsecretirement ='1' ", DataCollectionStage.EXIT.getCode(),data);
			int socsecretirementIncomeAtAnnualAssesment = getIncomeCntForVeterans(data.getSchema(), annualAssesmentQuery +"  and socsecretirement ='1' ", DataCollectionStage.ANNUAL_ASSESMENT.getCode(),data);
			
			q25gDataBean.setQ25gRetirementAtEntry(BigInteger.valueOf(socsecretirementIncomeAtEntry));
			q25gDataBean.setQ25gRetirementLeavers(BigInteger.valueOf(socsecretirementIncomeAtExit));
			q25gDataBean.setQ25gRetirementStayers(BigInteger.valueOf(socsecretirementIncomeAtAnnualAssesment));
			
			int ssdiIncomeAtEntry = getIncomeCntForVeterans(data.getSchema(), entryQuery +" and  ssdi ='1' ", DataCollectionStage.ENTRY.getCode(),data);
			int ssdiIncomeAtExit = getIncomeCntForVeterans(data.getSchema(), exitQuery +" and  ssdi ='1' ", DataCollectionStage.EXIT.getCode(),data);
			int ssdiIncomeAtAnnualAssesment = getIncomeCntForVeterans(data.getSchema(), annualAssesmentQuery +" and  ssdi ='1' ", DataCollectionStage.ANNUAL_ASSESMENT.getCode(),data);
			
			q25gDataBean.setQ25gSSDIAtEntry(BigInteger.valueOf(ssdiIncomeAtEntry));
			q25gDataBean.setQ25gSSDILeavers(BigInteger.valueOf(ssdiIncomeAtExit));
			q25gDataBean.setQ25gSSDIStayers(BigInteger.valueOf(ssdiIncomeAtAnnualAssesment));
		
			int ssiIncomeAtEntry = getIncomeCntForVeterans(data.getSchema(), entryQuery +"  and ssi ='1' ", DataCollectionStage.ENTRY.getCode(),data);
			int ssiIncomeAtExit = getIncomeCntForVeterans(data.getSchema(), exitQuery +"  and ssi ='1' ", DataCollectionStage.EXIT.getCode(),data);
			int ssiIncomeAtAnnualAssesment = getIncomeCntForVeterans(data.getSchema(), annualAssesmentQuery +"  and ssi ='1' ", DataCollectionStage.ANNUAL_ASSESMENT.getCode(),data);
			
			q25gDataBean.setQ25gSSIAtEntry(BigInteger.valueOf(ssiIncomeAtEntry));
			q25gDataBean.setQ25gSSILeavers(BigInteger.valueOf(ssiIncomeAtExit));
			q25gDataBean.setQ25gSSIStayers(BigInteger.valueOf(ssiIncomeAtAnnualAssesment));
			
			int tanfIncomeAtEntry = getIncomeCntForVeterans(data.getSchema(), entryQuery +" and  tanf ='1' ", DataCollectionStage.ENTRY.getCode(),data);
			int tanfIncomeAtExit = getIncomeCntForVeterans(data.getSchema(), exitQuery +"  and  tanf ='1' ", DataCollectionStage.EXIT.getCode(),data);
			int tanfIncomeAtAnnualAssesment = getIncomeCntForVeterans(data.getSchema(), annualAssesmentQuery +"  and tanf ='1' ", DataCollectionStage.ANNUAL_ASSESMENT.getCode(),data);
			
			q25gDataBean.setQ25gTANFAtEntry(BigInteger.valueOf(tanfIncomeAtEntry));
			q25gDataBean.setQ25gTANFLeavers(BigInteger.valueOf(tanfIncomeAtExit));
			q25gDataBean.setQ25gTANFStayers(BigInteger.valueOf(tanfIncomeAtAnnualAssesment));
			
			int unemploymentIncomeAtEntry = getIncomeCntForVeterans(data.getSchema(), entryQuery +" and  unemployment ='1' ", DataCollectionStage.ENTRY.getCode(),data);
			int unemploymentIncomeAtExit = getIncomeCntForVeterans(data.getSchema(), exitQuery +"  and unemployment ='1' ", DataCollectionStage.EXIT.getCode(),data);
			int unemploymentIncomeAtAnnualAssesment = getIncomeCntForVeterans(data.getSchema(), annualAssesmentQuery +"  and unemployment ='1' ", DataCollectionStage.ANNUAL_ASSESMENT.getCode(),data);
			
			q25gDataBean.setQ25gUnemploymentInsuranceAtEntry(BigInteger.valueOf(unemploymentIncomeAtEntry));
			q25gDataBean.setQ25gUnemploymentInsuranceLeavers(BigInteger.valueOf(unemploymentIncomeAtExit));
			q25gDataBean.setQ25gUnemploymentInsuranceStayers(BigInteger.valueOf(unemploymentIncomeAtAnnualAssesment));
			
			int vadisabilitynonserviceIncomeAtEntry = getIncomeCntForVeterans(data.getSchema(), entryQuery +" and  vadisabilitynonservice ='1' ", DataCollectionStage.ENTRY.getCode(),data);
			int vadisabilitynonserviceIncomeAtExit = getIncomeCntForVeterans(data.getSchema(), exitQuery +" and  vadisabilitynonservice ='1' ", DataCollectionStage.EXIT.getCode(),data);
			int vadisabilitynonserviceIncomeAtAnnualAssesment = getIncomeCntForVeterans(data.getSchema(), annualAssesmentQuery +" and  vadisabilitynonservice ='1' ", DataCollectionStage.ANNUAL_ASSESMENT.getCode(),data);
			
			q25gDataBean.setQ25gVANonServiceConnectedDisabilityAtEntry(BigInteger.valueOf(vadisabilitynonserviceIncomeAtEntry));
			q25gDataBean.setQ25gVANonServiceConnectedDisabilityLeavers(BigInteger.valueOf(vadisabilitynonserviceIncomeAtExit));
			q25gDataBean.setQ25gVANonServiceConnectedDisabilityStayers(BigInteger.valueOf(vadisabilitynonserviceIncomeAtAnnualAssesment));
			
			
			int vadisabilityserviceIncomeAtEntry = getIncomeCntForVeterans(data.getSchema(), entryQuery +"  and vadisabilityservice ='1' ", DataCollectionStage.ENTRY.getCode(),data);
			int vadisabilityserviceIncomeAtExit = getIncomeCntForVeterans(data.getSchema(), entryQuery +" and  vadisabilityservice ='1' ", DataCollectionStage.EXIT.getCode(),data);
			int vadisabilityserviceIncomeAtAnnualAssesment = getIncomeCntForVeterans(data.getSchema(), annualAssesmentQuery +" and  vadisabilityservice ='1' ", DataCollectionStage.ANNUAL_ASSESMENT.getCode(),data);
			
			q25gDataBean.setQ25gVAServiceConnectedDisabilityAtEntry(BigInteger.valueOf(vadisabilityserviceIncomeAtEntry));
			q25gDataBean.setQ25gVAServiceConnectedDisabilityLeavers(BigInteger.valueOf(vadisabilityserviceIncomeAtExit));
			q25gDataBean.setQ25gVAServiceConnectedDisabilityStayers(BigInteger.valueOf(vadisabilityserviceIncomeAtAnnualAssesment));
			
			int workerscompIncomeAtEntry = getIncomeCntForVeterans(data.getSchema(), entryQuery +" and  workerscomp ='1' ", DataCollectionStage.ENTRY.getCode(),data);
			int workerscompIncomeAtExit = getIncomeCntForVeterans(data.getSchema(), exitQuery +" and  workerscomp ='1' ", DataCollectionStage.EXIT.getCode(),data);
			int workerscompIncomeAtAnnualAssesment = getIncomeCntForVeterans(data.getSchema(), entryQuery +" and  workerscomp ='1' ", DataCollectionStage.ANNUAL_ASSESMENT.getCode(),data);
			
			q25gDataBean.setQ25gWorkersCompensationAtEntry(BigInteger.valueOf(workerscompIncomeAtEntry));
			q25gDataBean.setQ25gWorkersCompensationLeavers(BigInteger.valueOf(workerscompIncomeAtExit));
			q25gDataBean.setQ25gWorkersCompensationStayers(BigInteger.valueOf(workerscompIncomeAtAnnualAssesment));
			
			
			List<String> enrollmentsAtEnrty = getClients(data.getSchema(), entryQuery,data);
			List<String> enrollmentsAtExit = getClients(data.getSchema(), exitQuery, data);
			List<String> enrollmentsAtAnnualAssesment = getClients(data.getSchema(), annualAssesmentQuery,data);
		
			q25gDataBean.setQ25gAdultsWithIncomeInfoAtEntryAtEntry(BigInteger.valueOf(0));
			q25gDataBean.setQ25gAdultsWithIncomeInfoAtEntryLeavers(BigInteger.valueOf(0));
			q25gDataBean.setQ25gAdultsWithIncomeInfoAtEntryStayers(BigInteger.valueOf(0));
			
			if(CollectionUtils.isNotEmpty(enrollmentsAtExit) && CollectionUtils.isNotEmpty(enrollmentsAtEnrty)) {
				int cnt =0;
				for(String dedupClient : enrollmentsAtExit) {
					if(enrollmentsAtEnrty.contains(dedupClient)) {
						cnt++;
					}
				}
				q25gDataBean.setQ25gAdultsWithIncomeInfoAtEntryLeavers(BigInteger.valueOf(cnt));
			}
			if(CollectionUtils.isNotEmpty(enrollmentsAtAnnualAssesment) && CollectionUtils.isNotEmpty(enrollmentsAtEnrty)) {
				int cnt =0;
				for(String dedupClient : enrollmentsAtAnnualAssesment) {
					if(enrollmentsAtEnrty.contains(dedupClient)) {
						cnt++;
					}
				}
				q25gDataBean.setQ25gAdultsWithIncomeInfoAtEntryStayers(BigInteger.valueOf(cnt));
			}
			
		} catch (Exception e) {
			logger.error("Error in Q17BeanMaker:" + e);
		}
			}
			return Arrays.asList(q25gDataBean);
		}
		
		public static List<String> getClients(String schema,String query,ReportData data) {
			ResultSet resultSet = null;
			List<String> enrollments = new ArrayList<>();
			Statement statement = null;
			Connection connection = null;
			try {
				connection = ImpalaConnection.getConnection();
				statement = connection.createStatement();
				
				List<ClientModel> clients = data.getVeterans();
				 if(CollectionUtils.isNotEmpty(clients)) {
					 StringBuilder enrollmentBuilder = new StringBuilder(" and e.dedup_client_id in  ( ");
					 int index = 0;
					 for(ClientModel client : clients) {
						 enrollmentBuilder.append("'"+client.getDedupClientId()+"'");
						 if(index != clients.size()) {
							 enrollmentBuilder.append(",");
						 }
					 }
					 enrollmentBuilder.deleteCharAt(enrollmentBuilder.length() -1);
					 enrollmentBuilder.append(" ) ");
					 query = query + enrollmentBuilder.toString();
				 }
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

	}
