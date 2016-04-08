package com.servinglynk.hmis.warehouse.upload.endpoint;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/mapper")
public class ReportMasterController {
	private static final Logger logger = LoggerFactory
			.getLogger(ReportMasterController.class);
	
	@RequestMapping(value = "/reportMaster", method = RequestMethod.GET)
	public @ResponseBody
	Boolean createReportMaster(@RequestParam("report") String report,@RequestParam("id") String id,@RequestParam("email") String email,@RequestParam("year") String year ) {
		PreparedStatement statement = null;
		try {
			UUID syncID = UUID.randomUUID();
			Connection connection = getConnection();
			statement = connection.prepareStatement("INSERT INTO live.report_master (email, emailsent, project_id,report,year,created_at) VALUES (?, ?, ?, ?, ?, ?)");
			statement.setObject(1, email);
			statement.setBoolean(2, false);
			statement.setObject(3, UUID.fromString(id));
			statement.setString(4, report);
			statement.setString(5, year);
			statement.setTimestamp(6,getCUrrentTimestamp() );
			boolean execute = statement.execute();
			
		return Boolean.valueOf(execute);	
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
		return false;
	}
	private Timestamp getCUrrentTimestamp() {
		Calendar calendar = Calendar.getInstance();
		java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(calendar.getTime().getTime());
		return currentTimestamp;
		
	}
	
	
public static void main (String args[])
{
	
ReportMasterController controller = new ReportMasterController();
List<ReportMasterDTO> reportMaster = controller.getReportMaster();
System.out.println("Report Master"+reportMaster.size());
	
}
	@RequestMapping(value = "/getReportMaster", method = RequestMethod.GET)
	public @ResponseBody
	List<ReportMasterDTO> getReportMaster() {
		 ResultSet resultSet = null;
		 List<ReportMasterDTO> masters = new ArrayList<ReportMasterDTO>();
			Connection connection = null;
			try {
				connection = getConnection();

				String queryString = "SELECT * FROM live.report_master order by created_at desc" ;
				PreparedStatement statement = connection.prepareStatement(queryString);
				resultSet = statement.executeQuery();
				
				 while (resultSet.next()) {
					 ReportMasterDTO reportMaster = new ReportMasterDTO();
					 reportMaster.setProject_id(resultSet.getObject("project_id").toString());
					 reportMaster.setReport(resultSet.getString("report"));
					 reportMaster.setEmail(resultSet.getString("email"));
					 reportMaster.setEmailsent(resultSet.getBoolean("emailsent"));
					 reportMaster.setYear(resultSet.getInt("year"));
					 reportMaster.setCreated_at(resultSet.getTimestamp("created_at"));
					 masters.add(reportMaster);
				 }
					
				}catch(Exception ex){
					
				}
		 
		return masters;
	}
	
	@RequestMapping(value = "/projects", method = RequestMethod.GET)
	public @ResponseBody
	List<ProjectDTO> getProjects() {
		 ResultSet resultSet = null;
		 List<ProjectDTO> projects = new ArrayList<ProjectDTO>();
			Connection connection = null;
			try {
				connection = getConnection();

				String queryString = "SELECT * FROM live.project" ;
				PreparedStatement statement = connection.prepareStatement(queryString);
				resultSet = statement.executeQuery();
				
				 while (resultSet.next()) {
					 ProjectDTO project = new ProjectDTO();
					 project.setExportID(resultSet.getObject("export_id").toString());
					 project.setProjectName(resultSet.getString("projectname"));
					 projects.add(project);
				 }
					
				}catch(Exception ex){
					
				}
		 
		return projects;
	}
	

	private Connection getConnection() throws SQLException {
		Connection connection = DriverManager.getConnection(
				"jdbc:postgresql://hmisdb1.cvvhlvb3ryja.us-west-2.rds.amazonaws.com:5432/hmis", "hmisdb1",
				"hmisdb1234");
		return connection;
	}
}
