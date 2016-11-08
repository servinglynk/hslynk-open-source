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

import org.apache.commons.lang3.StringUtils;

import com.servinglynk.hive.connection.HiveConnection;
import com.servinglynk.hive.connection.ReportQuery;
import com.servinglynk.report.bean.ClientModel;
import com.servinglynk.report.bean.Q05aHMISComparableDBDataQualityDataBean;

public class Q05aHMISComparableDBDataQualityDataBeanMaker {
	
	public static List<Q05aHMISComparableDBDataQualityDataBean> getQ05aHMISCDDQDataList(String schema){
	       
		Q05aHMISComparableDBDataQualityDataBean q05aHMISCDDQBean = new Q05aHMISComparableDBDataQualityDataBean();
		List<ClientModel> clients = getClients(schema);
		List<ClientModel> firstNameCNF = clients.parallelStream()
				.filter(client -> "8".equals(client.getName_data_quality()) || "9".equals(client.getName_data_quality())) 
					.collect(Collectors.toList());
		List<ClientModel> firstNameDataNotCollected = clients.parallelStream()
				.filter(client ->  "99".equals(client.getName_data_quality())) 
					.collect(Collectors.toList());
		List<ClientModel> ssnCNF = clients.parallelStream()
				.filter(client ->  StringUtils.equals("8", client.getSsn_data_quality())|| StringUtils.equals("9", client.getSsn_data_quality())) 
					.collect(Collectors.toList());
		List<ClientModel> ssnDNC= clients.parallelStream()
				.filter(client ->  StringUtils.equals("99", client.getSsn_data_quality())) 
					.collect(Collectors.toList());
		List<ClientModel> dobCNF = clients.parallelStream()
				.filter(client -> "8".equals(client.getDob_data_quality()) || "9".equals(client.getDob_data_quality())) 
					.collect(Collectors.toList());
		List<ClientModel> dobDataNotCollected = clients.parallelStream()
				.filter(client ->  "99".equals(client.getDob_data_quality())) 
					.collect(Collectors.toList());
		List<ClientModel> race = clients.parallelStream()
				.filter(client -> "8".equals(client.getRace()) || "9".equals(client.getRace())) 
					.collect(Collectors.toList());
		List<ClientModel> raceDataNotCollected = clients.parallelStream()
				.filter(client ->  "99".equals(client.getRace())) 
					.collect(Collectors.toList());
		List<ClientModel> ethinicity = clients.parallelStream()
				.filter(client -> "8".equals(client.getEthnicity()) || "9".equals(client.getEthnicity())) 
					.collect(Collectors.toList());
		List<ClientModel> ethinicityDataNotCollected = clients.parallelStream()
				.filter(client ->  "99".equals(client.getEthnicity())) 
					.collect(Collectors.toList());
		
		List<ClientModel> gender = clients.parallelStream()
				.filter(client -> "8".equals(client.getGender()) || "9".equals(client.getGender())) 
					.collect(Collectors.toList());
		List<ClientModel> genderDataNotCollected = clients.parallelStream()
				.filter(client ->  "99".equals(client.getEthnicity())) 
					.collect(Collectors.toList());
		List<ClientModel> veteranStatus = clients.parallelStream()
				.filter(client -> "8".equals(client.getVeteran_status()) || "9".equals(client.getVeteran_status())) 
					.collect(Collectors.toList());
		List<ClientModel> veteranStatusDataNotCollected = clients.parallelStream()
				.filter(client ->  "99".equals(client.getVeteran_status())) 
					.collect(Collectors.toList());
		
		
		q05aHMISCDDQBean.setQ05aFirstName(BigInteger.valueOf(firstNameCNF != null ? firstNameCNF.size() :0));
		q05aHMISCDDQBean.setQ05aDNCFirstName(BigInteger.valueOf(firstNameDataNotCollected != null ? firstNameDataNotCollected.size() : 0));
		q05aHMISCDDQBean.setQ05aLastName(BigInteger.valueOf(firstNameCNF != null ? firstNameCNF.size() :0));
		q05aHMISCDDQBean.setQ05aDNCLastName(BigInteger.valueOf(firstNameDataNotCollected != null ? firstNameDataNotCollected.size() : 0));
		q05aHMISCDDQBean.setQ05aSSN(BigInteger.valueOf(ssnCNF !=null ? ssnCNF.size() :0));
		q05aHMISCDDQBean.setQ05aDNCSSN(BigInteger.valueOf(ssnDNC !=null ?ssnDNC.size() :0));
		q05aHMISCDDQBean.setQ05aDoB(BigInteger.valueOf(dobCNF !=null ? dobCNF.size() :0));
		q05aHMISCDDQBean.setQ05aDNCDoB(BigInteger.valueOf(dobDataNotCollected !=null ? dobDataNotCollected.size() : 0));
		q05aHMISCDDQBean.setQ05aRace(BigInteger.valueOf(race !=null ? race.size() :0));
		q05aHMISCDDQBean.setQ05aDNCRace(BigInteger.valueOf(raceDataNotCollected !=null ?raceDataNotCollected.size() : 0));
		q05aHMISCDDQBean.setQ05aEthinicity(BigInteger.valueOf(ethinicity != null ?ethinicity.size() : 0));
		q05aHMISCDDQBean.setQ05aDNCEthinicity(BigInteger.valueOf(ethinicityDataNotCollected !=null ?ethinicityDataNotCollected.size() :0));
		q05aHMISCDDQBean.setQ05aGender(BigInteger.valueOf(gender !=null ?gender.size() :0));
		q05aHMISCDDQBean.setQ05aDNCGender(BigInteger.valueOf(genderDataNotCollected !=null ? genderDataNotCollected.size() :0));
		q05aHMISCDDQBean.setQ05aVeteranStatus(BigInteger.valueOf(veteranStatus !=null ?veteranStatus.size() :0));
		q05aHMISCDDQBean.setQ05aDNCVeteranStatus(BigInteger.valueOf(veteranStatusDataNotCollected != null ? veteranStatusDataNotCollected.size():0));
		q05aHMISCDDQBean.setQ05aDisablingCond(BigInteger.valueOf(0));
		q05aHMISCDDQBean.setQ05aDNCDisablingCond(BigInteger.valueOf(2));
		q05aHMISCDDQBean.setQ05aResidencePriorEntry(BigInteger.valueOf(1));
		q05aHMISCDDQBean.setQ05aDNCResidencePriorEntry(BigInteger.valueOf(0));
		q05aHMISCDDQBean.setQ05aRelationshipToHH(BigInteger.valueOf(10));
		q05aHMISCDDQBean.setQ05aDNCRelationshipToHH(BigInteger.valueOf(0));
		q05aHMISCDDQBean.setQ05aDestination(BigInteger.valueOf(0));
		q05aHMISCDDQBean.setQ05aDNCDestination(BigInteger.valueOf(3));
		q05aHMISCDDQBean.setQ05aClientLocatorPE(BigInteger.valueOf(0));
		q05aHMISCDDQBean.setQ05aDNCClientLocatorPE(BigInteger.valueOf(16));
		q05aHMISCDDQBean.setQ05aLengthOfTime(BigInteger.valueOf(0));
		q05aHMISCDDQBean.setQ05aDNCLengthOfTime(BigInteger.valueOf(1));
		
         		
        return Arrays.asList(q05aHMISCDDQBean);
    }

	public static List<ClientModel> getClients(String schema) {
		ResultSet resultSet = null;
		PreparedStatement statement = null;
		Connection connection = null;
		List<ClientModel>  models = new ArrayList<ClientModel>();
		try {
			connection = HiveConnection.getConnection();
			statement = connection.prepareStatement(ReportQuery.GET_ALL_CLIENTS);
			resultSet = statement.executeQuery();
		 while(resultSet.next()) {
			 ClientModel model = new ClientModel(resultSet.getString("client.personalid"), resultSet.getString("client.dedup_client_id"), 
					 resultSet.getString("client.name_data_quality"),resultSet.getString("client.name_data_quality_desc"), 
					 resultSet.getString("client.ssn_data_quality"), resultSet.getString("client.ssn_data_quality_desc"), 
					 resultSet.getDate("client.dob"),resultSet.getString("client.dob_data_quality"), 
					 resultSet.getString("client.dob_data_quality_desc"), resultSet.getString("client.gender"), 
					 resultSet.getString("client.gender_desc"), resultSet.getString("client.other_gender"), resultSet.getString("client.ethnicity"), 
					 resultSet.getString("client.ethnicity_desc"), resultSet.getString("client.race"), resultSet.getString("client.race_desc"), 
					 resultSet.getString("client.veteran_status"), resultSet.getString("client.client_source_system_id"));
			 models.add(model);
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
		return models;
	}

	
	public static List<ClientModel> getEnrollments(String schema) {
		ResultSet resultSet = null;
		PreparedStatement statement = null;
		Connection connection = null;
		List<ClientModel>  models = new ArrayList<ClientModel>();
		try {
			connection = HiveConnection.getConnection();
			statement = connection.prepareStatement(ReportQuery.GET_ALL_CLIENTS);
			resultSet = statement.executeQuery();
		 while(resultSet.next()) {
			 ClientModel model = new ClientModel(resultSet.getString("client.personalid"), resultSet.getString("client.dedup_client_id"), 
					 resultSet.getString("client.name_data_quality"),resultSet.getString("client.name_data_quality_desc"), 
					 resultSet.getString("client.ssn_data_quality"), resultSet.getString("client.ssn_data_quality_desc"), 
					 resultSet.getDate("client.dob"),resultSet.getString("client.dob_data_quality"), 
					 resultSet.getString("client.dob_data_quality_desc"), resultSet.getString("client.gender"), 
					 resultSet.getString("client.gender_desc"), resultSet.getString("client.other_gender"), resultSet.getString("client.ethnicity"), 
					 resultSet.getString("client.ethnicity_desc"), resultSet.getString("client.race"), resultSet.getString("client.race_desc"), 
					 resultSet.getString("client.veteran_status"), resultSet.getString("client.client_source_system_id"));
			 models.add(model);
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
		return models;
	}

}
