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

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.servinglynk.hive.connection.ImpalaConnection;
import com.servinglynk.report.bean.Q21HealthInsuranceDataBean;
import com.servinglynk.report.bean.ReportData;
import com.servinglynk.report.model.DataCollectionStage;
import com.servinglynk.report.model.HealthInsuranceModel;

public class Q21HealthInsuranceDataBeanMaker extends BaseBeanMaker {

	public static List<Q21HealthInsuranceDataBean> getQ21HealthInsuranceList(ReportData data){
		
		Q21HealthInsuranceDataBean q21HealthInsuranceDataBeanTable = new Q21HealthInsuranceDataBean();
		String entryQuery = " select  i.insurancefromanysource as insurancefromanysource , i.medicaid as medicaid,i.medicare as medicare, i.statehealthinadults as statehealthinadults,"+
				  "i.vamedicalservices as vamedicalservices,i.employerprovided as employerprovided, i.privatepay as privatepay,i.schip as schip,i.indianhealthservices as indianhealthservices "+
				   "i.other_insurance as other_insurance, e.dedup_client_id  as dedup_client_id from %s.healthinsurance i, %s.enrollment e where e.id=i.enrollmentid  "+
				  " and i.information_date = e.entrydate and i.information_date <= ? and i.information_date >= ? "+
				  " and e.ageatentry >=18  and i.datacollectionstage = '1' ";
			       
			String  exitQuery = " select  i.insurancefromanysource as insurancefromanysource , i.medicaid as medicaid,i.medicare as medicare, i.statehealthinadults as statehealthinadults,"+
				  "i.vamedicalservices as vamedicalservices,i.employerprovided as employerprovided, i.privatepay as privatepay,i.schip as schip,i.indianhealthservices as indianhealthservices "+
				   "i.other_insurance as other_insurance, e.dedup_client_id  as dedup_client_id from %s.healthinsurance i, %s.enrollment e,%s.exit ext where e.id=i.enrollmentid  "+
				  " and e.id = ext.enrollmentid"+
					  " and i.information_date = ext.extdate and i.information_date <= ? and i.information_date >= ? "+
					  " and e.ageatentry >=18  and i.datacollectionstage = '3' ";
				       
			String stayersQuery = " select  nb.snap as snap ,nb.wic as wic ,nb.tanfchildcare as tanfchildcare,nb.tanftransportation as tanftransportation,nb.othertanf as othertanf,nb.benefitsfromanysource as benefitsfromanysource,e.dedup_client_id  as dedup_client_id from %s.incomeandsources i, %s.enrollment e,%s.noncashbenefits nb where e.id=i.enrollmentid  "+
							" and i.information_date >= e.entrydate and i.information_date >= ? and i.information_date <= ? and e.ageatentry >= 18 "+
						" and   e.id not in ( select enrollmentid from %s.exit  where  exitdate <= ?  )   "+
						" and   e.id not in ( select enrollmentid from %s.enrollment_coc where datacollectionstage='5' and datediff(now(),information_date) > 365 ) ";   
				
			try {
				if(data.isLiveMode()) {
					List<HealthInsuranceModel> entryHealthInsurances = getHealthInsuranceModel(data, entryQuery, DataCollectionStage.ENTRY.getCode());
					List<HealthInsuranceModel> stayersHealthInsurances = getHealthInsuranceModel(data, entryQuery, DataCollectionStage.ANNUAL_ASSESMENT.getCode());
					List<HealthInsuranceModel> exitHealthInsurances = getHealthInsuranceModel(data, entryQuery, DataCollectionStage.EXIT	.getCode());
					if(CollectionUtils.isNotEmpty(entryHealthInsurances)) {
						List<HealthInsuranceModel> medicaidHealthInsuranceAtEntry = entryHealthInsurances.parallelStream().filter(healthInsurance -> isPositive(healthInsurance.getMedicaid()) ).collect(Collectors.toList());
						q21HealthInsuranceDataBeanTable.setQ21AMedicaidHealthInsuranceAtEntry(BigInteger.valueOf(medicaidHealthInsuranceAtEntry != null ? medicaidHealthInsuranceAtEntry.size() : 0));
						List<HealthInsuranceModel> medicareHealthInsuranceAtEntry = entryHealthInsurances.parallelStream().filter(healthInsurance -> isPositive(healthInsurance.getMedicare()) ).collect(Collectors.toList());
						
						q21HealthInsuranceDataBeanTable.setQ21BMedicaidHealthInsuranceAtEntry(BigInteger.valueOf(medicareHealthInsuranceAtEntry != null ? medicareHealthInsuranceAtEntry.size() :0));
						q21HealthInsuranceDataBeanTable.setQ21CStateChildHealthInsuranceAtEntry(BigInteger.valueOf(0));
						q21HealthInsuranceDataBeanTable.setQ21DVAMedicalServicesAtEntry(BigInteger.valueOf(0));
						q21HealthInsuranceDataBeanTable.setQ21EEmployerProvidedHealthInsuranceAtEntry(BigInteger.valueOf(0));
						q21HealthInsuranceDataBeanTable.setQ21FHealthInsuranceThroughCobraAtEntry(BigInteger.valueOf(0));
						q21HealthInsuranceDataBeanTable.setQ21GPrivatePayHealthInsuranceAtEntry(BigInteger.valueOf(0));
						q21HealthInsuranceDataBeanTable.setQ21HStateHealthInsuranceForAdultsAtEntry(BigInteger.valueOf(0));
						q21HealthInsuranceDataBeanTable.setQ21IIndianHealthServicesProgramAtEntry(BigInteger.valueOf(0));
						q21HealthInsuranceDataBeanTable.setQ21JOtherAtEntry(BigInteger.valueOf(0));
						q21HealthInsuranceDataBeanTable.setQ21KNoHealthInsuranceAtEntry(BigInteger.valueOf(0));
						q21HealthInsuranceDataBeanTable.setQ21LClientRefusedAtEntry(BigInteger.valueOf(0));
						q21HealthInsuranceDataBeanTable.setQ21MDataNotCollectedAtEntry(BigInteger.valueOf(0));
						q21HealthInsuranceDataBeanTable.setQ21NNoOfAdultStayersNotRequiredAtEntry(BigInteger.valueOf(0));
						q21HealthInsuranceDataBeanTable.setQ21O1SourceOfHealthInsuranceAtEntry(BigInteger.valueOf(0));
						q21HealthInsuranceDataBeanTable.setQ21PMoreThan1SourceOfHealthInsuranceAtEntry(BigInteger.valueOf(0));
						
					}
					if(CollectionUtils.isNotEmpty(stayersHealthInsurances)) {
						List<HealthInsuranceModel> medicaidHealthInsuranceAtStayers = stayersHealthInsurances.parallelStream().filter(healthInsurance -> isPositive(healthInsurance.getMedicaid()) ).collect(Collectors.toList());
						List<HealthInsuranceModel> medicareHealthInsuranceAtStayers = stayersHealthInsurances.parallelStream().filter(healthInsurance -> isPositive(healthInsurance.getMedicare()) ).collect(Collectors.toList());
						
						q21HealthInsuranceDataBeanTable.setQ21AMedicaidHealthInsuranceAtLatestStayers(BigInteger.valueOf(medicaidHealthInsuranceAtStayers != null ? medicaidHealthInsuranceAtStayers.size() :0));
						q21HealthInsuranceDataBeanTable.setQ21BMedicaidHealthInsuranceAtLatestStayers(BigInteger.valueOf(0));
						q21HealthInsuranceDataBeanTable.setQ21CStateChildHealthInsuranceAtLatestStayers(BigInteger.valueOf(0));
						q21HealthInsuranceDataBeanTable.setQ21DVAMedicalServicesAtLatestStayers(BigInteger.valueOf(0));
						q21HealthInsuranceDataBeanTable.setQ21EEmployerProvidedHealthInsuranceAtLatestStayers(BigInteger.valueOf(0));
						q21HealthInsuranceDataBeanTable.setQ21FHealthInsuranceThroughCobraAtLatestStayers(BigInteger.valueOf(0));

						q21HealthInsuranceDataBeanTable.setQ21GPrivatePayHealthInsuranceAtLatestStayers(BigInteger.valueOf(0));
						q21HealthInsuranceDataBeanTable.setQ21HStateHealthInsuranceForAdultsAtLatestStayers(BigInteger.valueOf(0));
						q21HealthInsuranceDataBeanTable.setQ21IIndianHealthServicesProgramAtLatestStayers(BigInteger.valueOf(0));
						q21HealthInsuranceDataBeanTable.setQ21JOtherAtLatestStayers(BigInteger.valueOf(0));
						q21HealthInsuranceDataBeanTable.setQ21KNoHealthInsuranceAtLatestStayers(BigInteger.valueOf(0));
						q21HealthInsuranceDataBeanTable.setQ21LClientRefusedAtLatestStayers(BigInteger.valueOf(0));
						q21HealthInsuranceDataBeanTable.setQ21MDataNotCollectedAtLatestStayers(BigInteger.valueOf(0));
						q21HealthInsuranceDataBeanTable.setQ21NNoOfAdultStayersNotRequiredAtLatestStayers(BigInteger.valueOf(0));
						q21HealthInsuranceDataBeanTable.setQ21O1SourceOfHealthInsuranceAtLatestStayers(BigInteger.valueOf(0));
						q21HealthInsuranceDataBeanTable.setQ21PMoreThan1SourceOfHealthInsuranceAtLatestStayers(BigInteger.valueOf(0));
						
					}
					
					if(CollectionUtils.isNotEmpty(exitHealthInsurances)) {
						List<HealthInsuranceModel> medicaiHealthInsuranceAtExit = exitHealthInsurances.parallelStream().filter(healthInsurance -> isPositive(healthInsurance.getMedicaid()) ).collect(Collectors.toList());
						q21HealthInsuranceDataBeanTable.setQ21AMedicaidHealthInsuranceAtExitLeavers(BigInteger.valueOf(medicaiHealthInsuranceAtExit != null ?medicaiHealthInsuranceAtExit.size() :0));
						List<HealthInsuranceModel> medicareHealthInsuranceAtExit = exitHealthInsurances.parallelStream().filter(healthInsurance -> isPositive(healthInsurance.getMedicare()) ).collect(Collectors.toList());

						q21HealthInsuranceDataBeanTable.setQ21BMedicaidHealthInsuranceAtExitLeavers(BigInteger.valueOf(0));
						q21HealthInsuranceDataBeanTable.setQ21CStateChildHealthInsuranceAtExitLeavers(BigInteger.valueOf(0));
						q21HealthInsuranceDataBeanTable.setQ21DVAMedicalServicesAtExitLeavers(BigInteger.valueOf(0));	
						q21HealthInsuranceDataBeanTable.setQ21EEmployerProvidedHealthInsuranceAtExitLeavers(BigInteger.valueOf(0));
						q21HealthInsuranceDataBeanTable.setQ21FHealthInsuranceThroughCobraAtExitLeavers(BigInteger.valueOf(0));
						
						q21HealthInsuranceDataBeanTable.setQ21GPrivatePayHealthInsuranceAtExitLeavers(BigInteger.valueOf(0));
						q21HealthInsuranceDataBeanTable.setQ21HStateHealthInsuranceForAdultsAtExitLeavers(BigInteger.valueOf(0));
						q21HealthInsuranceDataBeanTable.setQ21IIndianHealthServicesProgramAtExitLeavers(BigInteger.valueOf(0));
						q21HealthInsuranceDataBeanTable.setQ21JOtherAtExitLeavers(BigInteger.valueOf(0));
						q21HealthInsuranceDataBeanTable.setQ21KNoHealthInsuranceAtExitLeavers(BigInteger.valueOf(0));
						q21HealthInsuranceDataBeanTable.setQ21LClientRefusedAtExitLeavers(BigInteger.valueOf(0));
						q21HealthInsuranceDataBeanTable.setQ21MDataNotCollectedAtExitLeavers(BigInteger.valueOf(0));
						q21HealthInsuranceDataBeanTable.setQ21NNoOfAdultStayersNotRequiredAtExitLeavers(BigInteger.valueOf(0));
						q21HealthInsuranceDataBeanTable.setQ21O1SourceOfHealthInsuranceAtExitLeavers(BigInteger.valueOf(0));
						q21HealthInsuranceDataBeanTable.setQ21PMoreThan1SourceOfHealthInsuranceAtExitLeavers(BigInteger.valueOf(0));
		
					}
				}
			}catch(Exception e) {
				logger.error("Error in Q21BeanMaker:" + e);
			}
			
		
		return Arrays.asList(q21HealthInsuranceDataBeanTable);
	}
	
	
	 public static List<HealthInsuranceModel> getHealthInsuranceModel(ReportData data,String query,String datacollectionStage) {
		 List<HealthInsuranceModel> healthInsuranceModels = new ArrayList<HealthInsuranceModel>();
			ResultSet resultSet = null;
			PreparedStatement statement = null;
			Connection connection = null;
			try {
				connection = ImpalaConnection.getConnection();
				statement = connection.prepareStatement(formatQuery(query,data.getSchema()));
				statement.setDate(1, data.getReportStartDate());
				statement.setDate(2, data.getReportEndDate());
				if(StringUtils.equals(datacollectionStage, DataCollectionStage.ANNUAL_ASSESMENT.getCode())) {
					statement.setDate(3, data.getReportEndDate());
				}
					
				resultSet = statement.executeQuery();
				
			 while(resultSet.next()) {
				 healthInsuranceModels.add(new HealthInsuranceModel(resultSet.getString("insurancefromanysource"), resultSet.getString("medicaid"), resultSet.getString("medicare"), 
						 resultSet.getString("statehealthinadults"), resultSet.getString("vamedicalservices"), resultSet.getString("employerprovided"), 
						 resultSet.getString("privatepay"), resultSet.getString("schip"), resultSet.getString("indianhealthservices"), resultSet.getString("otherinsurance"), resultSet.getString("dedupClientId")));
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
			return healthInsuranceModels;
		}	
	
}
