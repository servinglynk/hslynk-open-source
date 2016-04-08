package com.seringlynk.hmis.warehouse.report;


import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.hadoop.hbase.filter.CompareFilter;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

import com.seringlynk.hmis.warehouse.ResultSetMapper;
import com.servinglynk.hmis.warehouse.model.v2014.Project;
import com.servinglynk.hmis.warehouse.model.v2014.ReportMaster;

public class Reporter {
        @SuppressWarnings("unchecked")
        public static void main(String[] args) throws Exception {
        		//URL path = Reporter.class.getResource("Project_Identifiers.jrxml");
        	Reporter main = new Reporter();
        	List<ReportMaster> reportMasters = main.getReportMaster();
        	if(reportMasters !=null && reportMasters.size() > 0) {
        		for(ReportMaster master : reportMasters )  {
        			main.generateReport(master);
        			main.updateEmailSent(master);
        		}	
        	}
        }

        private void generateReport(ReportMaster master) throws Exception {
        	//Sandeep TODO: Need to get the rowKey from the report requested:
        	
            InputStream inputStream = new FileInputStream ("/home/ubuntu/Project_Identifiers.jrxml");
            //hydradeBeanData();
            DataBeanMaker dataBeanMaker = new DataBeanMaker();
            ArrayList<DataBean> dataBeanList = dataBeanMaker.getDataBeanList(master);
            
            JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(dataBeanList);
            
            Map parameters = new HashMap();
    
            JasperDesign jasperDesign = JRXmlLoader.load(inputStream);
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, beanColDataSource);
            String fileName =  "/home/ubuntu/report.pdf";
            JasperExportManager.exportReportToPdfFile(jasperPrint,fileName); 
            SendMail.generateAndSendEmail(master.getEmail(),fileName);
            // 		Write code to email the report.
            //Update email sent to true
            System.out.println("Report is generated");
        }
    	private Connection getConnection() throws SQLException {
    		Connection connection = DriverManager.getConnection(
    				"jdbc:postgresql://hmisdb1.cvvhlvb3ryja.us-west-2.rds.amazonaws.com:5432/hmis", "hmisdb1",
    				"hmisdb1234");
    		return connection;
    	}
        
    	public List<ReportMaster> getReportMaster() {
    		ResultSet resultSet = null;
    		PreparedStatement statement = null;
    		try {
    			Connection connection = getConnection();
//    			PreparedStatement statement = connection.prepareStatement("SELECT max(insert_at) FROM live.bulk_upload where status='LIVE'");
    			statement = connection.prepareStatement("SELECT * FROM live.report_master where emailsent=false");
    			resultSet = statement.executeQuery();
    			ResultSetMapper<ReportMaster> resultSetMapper = new ResultSetMapper<ReportMaster>();
    			List<ReportMaster> pojoList = resultSetMapper.mapRersultSetToObject(resultSet, ReportMaster.class);
    			
    			// print out the list retrieved from database
    			return pojoList;
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		} finally {
    			if (statement != null) {
    				try {
    					statement.close();
    				} catch (SQLException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				}
    			}
    		}

    		return null;
    	}
    	
    	public void updateEmailSent(ReportMaster master) {
    		PreparedStatement statement = null;
    		try {
    			Connection connection = getConnection();
    			statement = connection.prepareStatement("UPDATE live.report_master SET emailsent=? where id =?");
    			statement.setBoolean(1, true);
    			statement.setInt(2, master.getId());
    			int status = statement.executeUpdate();
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		} finally {
    			if (statement != null) {
    				try {
    					statement.close();
    				} catch (SQLException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				}
    			}
    		}
    	}
}