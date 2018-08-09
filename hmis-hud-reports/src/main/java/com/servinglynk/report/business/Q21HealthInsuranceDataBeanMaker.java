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
					List<HealthInsuranceModel> stayersHealthInsurances = getHealthInsuranceModel(data, stayersQuery, DataCollectionStage.ANNUAL_ASSESMENT.getCode());
					List<HealthInsuranceModel> exitHealthInsurances = getHealthInsuranceModel(data, exitQuery, DataCollectionStage.EXIT	.getCode());
					if(CollectionUtils.isNotEmpty(entryHealthInsurances)) {
						List<HealthInsuranceModel> medicaidHealthInsurance = entryHealthInsurances.parallelStream().filter(healthInsurance -> isPositive(healthInsurance.getMedicaid()) ).collect(Collectors.toList());
						List<HealthInsuranceModel> medicareHealthInsurance = entryHealthInsurances.parallelStream().filter(healthInsurance -> isPositive(healthInsurance.getMedicare()) ).collect(Collectors.toList());
						List<HealthInsuranceModel> stateChildHealthInsurance = entryHealthInsurances.parallelStream().filter(healthInsurance -> isPositive(healthInsurance.getStatehealthinadults()) ).collect(Collectors.toList());
						List<HealthInsuranceModel> medicalServices = entryHealthInsurances.parallelStream().filter(healthInsurance -> isPositive(healthInsurance.getVamedicalservices()) ).collect(Collectors.toList());
						List<HealthInsuranceModel> employerProvidedHealthInsurance = entryHealthInsurances.parallelStream().filter(healthInsurance -> isPositive(healthInsurance.getEmployerprovided()) ).collect(Collectors.toList());
						List<HealthInsuranceModel> healthInsuranceThroughCobra = entryHealthInsurances.parallelStream().filter(healthInsurance -> isPositive(healthInsurance.getInsurancefromanysource()) ).collect(Collectors.toList());
						List<HealthInsuranceModel> privatePayHealthInsurance = entryHealthInsurances.parallelStream().filter(healthInsurance -> isPositive(healthInsurance.getPrivatepay()) ).collect(Collectors.toList());
						List<HealthInsuranceModel> stateHealthInsuranceForAdults = entryHealthInsurances.parallelStream().filter(healthInsurance -> isPositive(healthInsurance.getStatehealthinadults()) ).collect(Collectors.toList());
						List<HealthInsuranceModel> indianHealthServicesProgram = entryHealthInsurances.parallelStream().filter(healthInsurance -> isPositive(healthInsurance.getIndianhealthservices()) ).collect(Collectors.toList());
						List<HealthInsuranceModel> other = entryHealthInsurances.parallelStream().filter(healthInsurance -> isPositive(healthInsurance.getOtherinsurance()) ).collect(Collectors.toList());
						List<HealthInsuranceModel> noHealthInsurance = entryHealthInsurances.parallelStream().filter(healthInsurance -> isPositive(healthInsurance.getVamedicalservices()) ).collect(Collectors.toList());
						List<HealthInsuranceModel> clientRefused = entryHealthInsurances.parallelStream().filter(healthInsurance -> isPositive(healthInsurance.getVamedicalservices()) ).collect(Collectors.toList());
						List<HealthInsuranceModel> dataNotCollected = entryHealthInsurances.parallelStream().filter(healthInsurance -> isPositive(healthInsurance.getVamedicalservices()) ).collect(Collectors.toList());
						
						q21HealthInsuranceDataBeanTable.setQ21AMedicaidHealthInsuranceAtEntry(BigInteger.valueOf(medicaidHealthInsurance != null ? medicaidHealthInsurance.size() : 0));
						q21HealthInsuranceDataBeanTable.setQ21BMedicaidHealthInsuranceAtEntry(BigInteger.valueOf(medicareHealthInsurance != null ? medicareHealthInsurance.size() :0));
						q21HealthInsuranceDataBeanTable.setQ21CStateChildHealthInsuranceAtEntry(BigInteger.valueOf(stateChildHealthInsurance != null ? stateChildHealthInsurance.size() :0));
						q21HealthInsuranceDataBeanTable.setQ21DVAMedicalServicesAtEntry(BigInteger.valueOf(medicalServices != null ? medicalServices.size() :0));
						q21HealthInsuranceDataBeanTable.setQ21EEmployerProvidedHealthInsuranceAtEntry(BigInteger.valueOf(employerProvidedHealthInsurance != null ? employerProvidedHealthInsurance.size() :0));
						q21HealthInsuranceDataBeanTable.setQ21FHealthInsuranceThroughCobraAtEntry(BigInteger.valueOf(healthInsuranceThroughCobra != null ? healthInsuranceThroughCobra.size() :0));
						q21HealthInsuranceDataBeanTable.setQ21GPrivatePayHealthInsuranceAtEntry(BigInteger.valueOf(privatePayHealthInsurance != null ?privatePayHealthInsurance.size() :0));
						q21HealthInsuranceDataBeanTable.setQ21HStateHealthInsuranceForAdultsAtEntry(BigInteger.valueOf(stateHealthInsuranceForAdults != null ? stateHealthInsuranceForAdults.size() :0));
						q21HealthInsuranceDataBeanTable.setQ21IIndianHealthServicesProgramAtEntry(BigInteger.valueOf(indianHealthServicesProgram != null ? indianHealthServicesProgram.size() :0));
						q21HealthInsuranceDataBeanTable.setQ21JOtherAtEntry(BigInteger.valueOf(other != null ? other.size() :0));
						q21HealthInsuranceDataBeanTable.setQ21KNoHealthInsuranceAtEntry(BigInteger.valueOf(0));
						q21HealthInsuranceDataBeanTable.setQ21LClientRefusedAtEntry(BigInteger.valueOf(0));
						q21HealthInsuranceDataBeanTable.setQ21MDataNotCollectedAtEntry(BigInteger.valueOf(0));
						q21HealthInsuranceDataBeanTable.setQ21NNoOfAdultStayersNotRequiredAtEntry(BigInteger.valueOf(0));
						q21HealthInsuranceDataBeanTable.setQ21O1SourceOfHealthInsuranceAtEntry(BigInteger.valueOf(0));
						q21HealthInsuranceDataBeanTable.setQ21PMoreThan1SourceOfHealthInsuranceAtEntry(BigInteger.valueOf(0));
						
					}
					if(CollectionUtils.isNotEmpty(stayersHealthInsurances)) {
						List<HealthInsuranceModel> medicaidHealthInsurance = stayersHealthInsurances.parallelStream().filter(healthInsurance -> isPositive(healthInsurance.getMedicaid()) ).collect(Collectors.toList());
						List<HealthInsuranceModel> medicareHealthInsurance = stayersHealthInsurances.parallelStream().filter(healthInsurance -> isPositive(healthInsurance.getMedicare()) ).collect(Collectors.toList());
						List<HealthInsuranceModel> stateChildHealthInsurance = entryHealthInsurances.parallelStream().filter(healthInsurance -> isPositive(healthInsurance.getStatehealthinadults()) ).collect(Collectors.toList());
						List<HealthInsuranceModel> medicalServices = stayersHealthInsurances.parallelStream().filter(healthInsurance -> isPositive(healthInsurance.getVamedicalservices()) ).collect(Collectors.toList());
						List<HealthInsuranceModel> employerProvidedHealthInsurance = stayersHealthInsurances.parallelStream().filter(healthInsurance -> isPositive(healthInsurance.getEmployerprovided()) ).collect(Collectors.toList());
						List<HealthInsuranceModel> healthInsuranceThroughCobra = stayersHealthInsurances.parallelStream().filter(healthInsurance -> isPositive(healthInsurance.getInsurancefromanysource()) ).collect(Collectors.toList());
						List<HealthInsuranceModel> privatePayHealthInsurance = stayersHealthInsurances.parallelStream().filter(healthInsurance -> isPositive(healthInsurance.getPrivatepay()) ).collect(Collectors.toList());
						List<HealthInsuranceModel> stateHealthInsuranceForAdults = stayersHealthInsurances.parallelStream().filter(healthInsurance -> isPositive(healthInsurance.getStatehealthinadults()) ).collect(Collectors.toList());
						List<HealthInsuranceModel> indianHealthServicesProgram = stayersHealthInsurances.parallelStream().filter(healthInsurance -> isPositive(healthInsurance.getIndianhealthservices()) ).collect(Collectors.toList());
						List<HealthInsuranceModel> other = stayersHealthInsurances.parallelStream().filter(healthInsurance -> isPositive(healthInsurance.getOtherinsurance()) ).collect(Collectors.toList());
						List<HealthInsuranceModel> noHealthInsurance = stayersHealthInsurances.parallelStream().filter(healthInsurance -> isPositive(healthInsurance.getVamedicalservices()) ).collect(Collectors.toList());
						List<HealthInsuranceModel> clientRefused = stayersHealthInsurances.parallelStream().filter(healthInsurance -> isPositive(healthInsurance.getVamedicalservices()) ).collect(Collectors.toList());
						List<HealthInsuranceModel> dataNotCollected = stayersHealthInsurances.parallelStream().filter(healthInsurance -> isPositive(healthInsurance.getVamedicalservices()) ).collect(Collectors.toList());
						
						q21HealthInsuranceDataBeanTable.setQ21AMedicaidHealthInsuranceAtLatestStayers(BigInteger.valueOf(medicaidHealthInsurance != null ? medicaidHealthInsurance.size() : 0));
						q21HealthInsuranceDataBeanTable.setQ21BMedicaidHealthInsuranceAtLatestStayers(BigInteger.valueOf(medicareHealthInsurance != null ? medicareHealthInsurance.size() :0));
						q21HealthInsuranceDataBeanTable.setQ21CStateChildHealthInsuranceAtLatestStayers(BigInteger.valueOf(stateChildHealthInsurance != null ? stateChildHealthInsurance.size() :0));
						q21HealthInsuranceDataBeanTable.setQ21DVAMedicalServicesAtLatestStayers(BigInteger.valueOf(medicalServices != null ? medicalServices.size() :0));
						q21HealthInsuranceDataBeanTable.setQ21EEmployerProvidedHealthInsuranceAtLatestStayers(BigInteger.valueOf(employerProvidedHealthInsurance != null ? employerProvidedHealthInsurance.size() :0));
						q21HealthInsuranceDataBeanTable.setQ21FHealthInsuranceThroughCobraAtLatestStayers(BigInteger.valueOf(healthInsuranceThroughCobra != null ? healthInsuranceThroughCobra.size() :0));
						q21HealthInsuranceDataBeanTable.setQ21GPrivatePayHealthInsuranceAtLatestStayers(BigInteger.valueOf(privatePayHealthInsurance != null ?privatePayHealthInsurance.size() :0));
						q21HealthInsuranceDataBeanTable.setQ21HStateHealthInsuranceForAdultsAtLatestStayers(BigInteger.valueOf(stateHealthInsuranceForAdults != null ? stateHealthInsuranceForAdults.size() :0));
						q21HealthInsuranceDataBeanTable.setQ21IIndianHealthServicesProgramAtLatestStayers(BigInteger.valueOf(indianHealthServicesProgram != null ? indianHealthServicesProgram.size() :0));
						q21HealthInsuranceDataBeanTable.setQ21JOtherAtLatestStayers(BigInteger.valueOf(other != null ? other.size() :0));
						
						q21HealthInsuranceDataBeanTable.setQ21KNoHealthInsuranceAtLatestStayers(BigInteger.valueOf(0));
						q21HealthInsuranceDataBeanTable.setQ21LClientRefusedAtLatestStayers(BigInteger.valueOf(0));
						q21HealthInsuranceDataBeanTable.setQ21MDataNotCollectedAtLatestStayers(BigInteger.valueOf(0));
						q21HealthInsuranceDataBeanTable.setQ21NNoOfAdultStayersNotRequiredAtLatestStayers(BigInteger.valueOf(0));
						q21HealthInsuranceDataBeanTable.setQ21O1SourceOfHealthInsuranceAtLatestStayers(BigInteger.valueOf(0));
						q21HealthInsuranceDataBeanTable.setQ21PMoreThan1SourceOfHealthInsuranceAtLatestStayers(BigInteger.valueOf(0));
						
					}
					
					if(CollectionUtils.isNotEmpty(exitHealthInsurances)) {
						List<HealthInsuranceModel> medicaidHealthInsurance = exitHealthInsurances.parallelStream().filter(healthInsurance -> isPositive(healthInsurance.getMedicaid()) ).collect(Collectors.toList());
						List<HealthInsuranceModel> medicareHealthInsurance = exitHealthInsurances.parallelStream().filter(healthInsurance -> isPositive(healthInsurance.getMedicare()) ).collect(Collectors.toList());
						List<HealthInsuranceModel> stateChildHealthInsurance = exitHealthInsurances.parallelStream().filter(healthInsurance -> isPositive(healthInsurance.getStatehealthinadults()) ).collect(Collectors.toList());
						List<HealthInsuranceModel> medicalServices = exitHealthInsurances.parallelStream().filter(healthInsurance -> isPositive(healthInsurance.getVamedicalservices()) ).collect(Collectors.toList());
						List<HealthInsuranceModel> employerProvidedHealthInsurance = exitHealthInsurances.parallelStream().filter(healthInsurance -> isPositive(healthInsurance.getEmployerprovided()) ).collect(Collectors.toList());
						List<HealthInsuranceModel> healthInsuranceThroughCobra = exitHealthInsurances.parallelStream().filter(healthInsurance -> isPositive(healthInsurance.getInsurancefromanysource()) ).collect(Collectors.toList());
						List<HealthInsuranceModel> privatePayHealthInsurance = exitHealthInsurances.parallelStream().filter(healthInsurance -> isPositive(healthInsurance.getPrivatepay()) ).collect(Collectors.toList());
						List<HealthInsuranceModel> stateHealthInsuranceForAdults = exitHealthInsurances.parallelStream().filter(healthInsurance -> isPositive(healthInsurance.getStatehealthinadults()) ).collect(Collectors.toList());
						List<HealthInsuranceModel> indianHealthServicesProgram = exitHealthInsurances.parallelStream().filter(healthInsurance -> isPositive(healthInsurance.getIndianhealthservices()) ).collect(Collectors.toList());
						List<HealthInsuranceModel> other = exitHealthInsurances.parallelStream().filter(healthInsurance -> isPositive(healthInsurance.getOtherinsurance()) ).collect(Collectors.toList());
						List<HealthInsuranceModel> noHealthInsurance = exitHealthInsurances.parallelStream().filter(healthInsurance -> isPositive(healthInsurance.getVamedicalservices()) ).collect(Collectors.toList());
						List<HealthInsuranceModel> clientRefused = exitHealthInsurances.parallelStream().filter(healthInsurance -> isPositive(healthInsurance.getVamedicalservices()) ).collect(Collectors.toList());
						List<HealthInsuranceModel> dataNotCollected = exitHealthInsurances.parallelStream().filter(healthInsurance -> isPositive(healthInsurance.getVamedicalservices()) ).collect(Collectors.toList());
						
						
						q21HealthInsuranceDataBeanTable.setQ21AMedicaidHealthInsuranceAtExitLeavers(BigInteger.valueOf(medicaidHealthInsurance != null ?medicaidHealthInsurance.size() :0));
						q21HealthInsuranceDataBeanTable.setQ21BMedicaidHealthInsuranceAtExitLeavers(BigInteger.valueOf(0));
						q21HealthInsuranceDataBeanTable.setQ21CStateChildHealthInsuranceAtExitLeavers(BigInteger.valueOf(0));
						q21HealthInsuranceDataBeanTable.setQ21DVAMedicalServicesAtExitLeavers(BigInteger.valueOf(0));	
						q21HealthInsuranceDataBeanTable.setQ21EEmployerProvidedHealthInsuranceAtExitLeavers(BigInteger.valueOf(0));
						q21HealthInsuranceDataBeanTable.setQ21FHealthInsuranceThroughCobraAtExitLeavers(BigInteger.valueOf(0));
						q21HealthInsuranceDataBeanTable.setQ21GPrivatePayHealthInsuranceAtExitLeavers(BigInteger.valueOf(0));
						q21HealthInsuranceDataBeanTable.setQ21HStateHealthInsuranceForAdultsAtExitLeavers(BigInteger.valueOf(0));
						q21HealthInsuranceDataBeanTable.setQ21IIndianHealthServicesProgramAtExitLeavers(BigInteger.valueOf(0));
						q21HealthInsuranceDataBeanTable.setQ21JOtherAtExitLeavers(BigInteger.valueOf(0));
						
						
						
						q21HealthInsuranceDataBeanTable.setQ21BMedicaidHealthInsuranceAtLatestStayers(BigInteger.valueOf(medicareHealthInsurance != null ? medicareHealthInsurance.size() :0));
						q21HealthInsuranceDataBeanTable.setQ21CStateChildHealthInsuranceAtLatestStayers(BigInteger.valueOf(stateChildHealthInsurance != null ? stateChildHealthInsurance.size() :0));
						q21HealthInsuranceDataBeanTable.setQ21DVAMedicalServicesAtLatestStayers(BigInteger.valueOf(medicalServices != null ? medicalServices.size() :0));
						q21HealthInsuranceDataBeanTable.setQ21EEmployerProvidedHealthInsuranceAtLatestStayers(BigInteger.valueOf(employerProvidedHealthInsurance != null ? employerProvidedHealthInsurance.size() :0));
						q21HealthInsuranceDataBeanTable.setQ21FHealthInsuranceThroughCobraAtLatestStayers(BigInteger.valueOf(healthInsuranceThroughCobra != null ? healthInsuranceThroughCobra.size() :0));
						q21HealthInsuranceDataBeanTable.setQ21GPrivatePayHealthInsuranceAtLatestStayers(BigInteger.valueOf(privatePayHealthInsurance != null ?privatePayHealthInsurance.size() :0));
						q21HealthInsuranceDataBeanTable.setQ21HStateHealthInsuranceForAdultsAtLatestStayers(BigInteger.valueOf(stateHealthInsuranceForAdults != null ? stateHealthInsuranceForAdults.size() :0));
						q21HealthInsuranceDataBeanTable.setQ21IIndianHealthServicesProgramAtLatestStayers(BigInteger.valueOf(indianHealthServicesProgram != null ? indianHealthServicesProgram.size() :0));
						q21HealthInsuranceDataBeanTable.setQ21JOtherAtLatestStayers(BigInteger.valueOf(other != null ? other.size() :0));
						
						
						
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
