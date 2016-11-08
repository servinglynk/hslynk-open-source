package com.servinglynk.report.business;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.servinglynk.hive.connection.HiveConnection;
import com.servinglynk.hive.connection.ReportQuery;
import com.servinglynk.report.bean.HomePageDataBean;

public class HomePageDataBeanMaker {
	
		public static List<HomePageDataBean> getHomePageDataList(String schema,String projectId){
	       
			HomePageDataBean homePageDataBean = new HomePageDataBean();
			
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			Date date = new Date();
             
			homePageDataBean.setHomePageStartDate(dateFormat.format(date/*"1/1/2015"*/));
			homePageDataBean.setHomePageEndDate(dateFormat.format(date/*"11/10/2016"*/));
			homePageDataBean.setHomePageProjects("APR - Services Only");
			homePageDataBean.setHomePageHomeLess("Everyone");
			homePageDataBean.setHomePageGrants("all grants");
			homePageDataBean.setHomePageView("Aggregate / summary");
			
			populateProject(schema, projectId, homePageDataBean);
			homePageDataBean.setQ04aHmisProjectIdService(BigInteger.valueOf(240));
			homePageDataBean.setQ04aIdentityProjectId(BigInteger.valueOf(0));
			
			homePageDataBean.setQ05aHMISComparableDBDataQualityDataBean(Q05aHMISComparableDBDataQualityDataBeanMaker.getQ05aHMISCDDQDataList(schema));
			homePageDataBean.setQ06aReportValidationsTableDataBean(Q06aReportValidationsTableDataBeanMaker.getQ06aReportValidationsTableList(schema));
			homePageDataBean.setQ06bNumberOfPersonsServedDataBean(Q06bNumberOfPersonsServedDataBeanMaker.getQ06bNumberOfPersonsServedTableList());
			homePageDataBean.setQ06cPointInTimeCountPersonsLastWednesdayDataBean(Q06cPointInTimeCountPersonsLastWednesdayDataBeanMaker.getQ06cPointInTimeCountPersonsLastWednesdayList());
			homePageDataBean.setQ07aHouseholdsServedDataBean(Q07aHouseHoldsDataBeanMaker.getQ07aHouseholdsServeList());
			homePageDataBean.setQ07bPointInTimeCountHouseholdsLastWednesdayDataBean(Q07bPointInTimeCountHouseholdsLastWednesdayDataBeanMaker.getQ07bPointInTimeCountHouseholdsLastWednesdayList());
			homePageDataBean.setqQ09aNumberPersonsContactedDataBean(Q09aNumberPersonsContactedDataBeanMaker.getQ09aNumberPersonsContactedList());
			homePageDataBean.setQ09bNumberofPersonsEngagedDataBean(Q09bNumberofPersonsEngagedDataBeanMaker.getQ09bNumberofPersonsEngagedList());
			
			
	        return Arrays.asList(homePageDataBean);
	    }
		
		public static void populateProject(String schema,String id, HomePageDataBean homePageDataBean) {
			ResultSet resultSet = null;
			PreparedStatement statement = null;
			Connection connection = null;
			try {
				connection = HiveConnection.getConnection();
				statement = connection.prepareStatement(ReportQuery.GET_PROJECT_BY_ID);
				statement.setString(1, id);
				resultSet = statement.executeQuery();
			 while(resultSet.next()) {
				 homePageDataBean.setQ04aProjectName(resultSet.getString("project.projectname"));
				 homePageDataBean.setQ04aHmisProjectType(resultSet.getString("project.projecttype_desc"));
				 homePageDataBean.setQ04aProjectId(resultSet.getString("project.project_source_system_id"));
				 homePageDataBean.setQ04aMethodOfTracking(resultSet.getString("project.trackingmethod_desc"));
				 String organizationId = resultSet.getString("project.organizationid");
				 populateOranization(schema, organizationId, homePageDataBean);
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
		}
			public static void populateOranization(String schema,String id, HomePageDataBean homePageDataBean) {
				ResultSet resultSet = null;
				PreparedStatement statement = null;
				Connection connection = null;
				try {
					connection = HiveConnection.getConnection();
					statement = connection.prepareStatement(ReportQuery.GET_ORG_BY_ID);
					statement.setString(1, id);
					resultSet = statement.executeQuery();
					int count = 0;
				 while(resultSet.next()) {
					 homePageDataBean.setQ04aOrgName(resultSet.getString("organization.organizationname"));
				     homePageDataBean.setQ04aOrgId(resultSet.getString("organization.organization_source_system_id"));
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
			}

}
