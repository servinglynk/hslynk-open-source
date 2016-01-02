package com.servinglynk.hmis.warehouse.test.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.common.security.HMISCryptographer;

public class CreateMasterData {

	public Connection getConnection() throws Exception {
		Class.forName("org.postgresql.Driver");
//		return DriverManager.getConnection("jdbc:postgresql://hmisdb1.cvvhlvb3ryja.us-west-2.rds.amazonaws.com:5432/hmis?currentSchema=live", "hmisdb1", "hmisdb1234");
		return DriverManager.getConnection("jdbc:postgresql://localhost:5432/hmis?currentSchema=live", "postgres", "postgres");
		
	}
	
	public void createTrustedApp() throws Exception {
		UUID id = UUID.randomUUID();
		String query= "INSERT INTO live.hmis_trusted_app( id, friendly_name, external_id, description, status, created_at, created_by, expiration_time) " 
			+	" VALUES ('"+id+"','MASTER_TRUSTED_APP', 'MASTER_TRUSTED_APP', 'MASTER_TRUSTED_APP','ACTIVE', current_date, 'MASTER DATA',  2000)";

		Connection connection =getConnection();
		Statement statement1= connection.createStatement();
		statement1.execute(query);
		System.out.println(query);
		if(!connection.isClosed()) connection.close();		
	}
	
	
	public UUID createProjectGroup() throws Exception{
		
		UUID orgid = this.createOrganizations("Project Group Organization");
		UUID projId1 = this.createProjects(orgid);
		UUID projId2 = this.createProjects(orgid);
		UUID projeGroupId = UUID.randomUUID();
		String query1 = "INSERT INTO live.hmis_project_group( id, project_group_name, project_group_desc, project_group_code, INSERT_AT, INSERT_BY) values "
				+ "		 ( '"+projeGroupId+"','PROJECT_GROUP_NAME','PROJECT_GROUP_DESCRIPTION','PG0001', current_date,'MASTER_DATA')" ;
		
		String query2 = "INSERT INTO live.hmis_project_projectgroup_map( id, project_id, project_group_id, insert_at, insert_by) values "
						+ " ( '"+UUID.randomUUID()+"','"+projId1+"','"+projeGroupId+"', current_date,'MASTER_DATA')";
		
		String query3 = "INSERT INTO live.hmis_project_projectgroup_map( id, project_id, project_group_id, insert_at, insert_by) values "
				+ " ( '"+UUID.randomUUID()+"','"+projId2+"','"+projeGroupId+"', current_date,'MASTER_DATA')";
		
		Connection connection = getConnection();
		Statement statement = connection.createStatement();
		statement.execute(query1);
		statement.execute(query2);
		statement.execute(query3);
		if(!connection.isClosed()) connection.close();
		return projeGroupId;
	}
	
	
    String[] methods = {"CLIENT_API_CREATE_VETERANINFO","CLIENT_API_UPDATE_VETERANINFO","CLIENT_API_DELETE_VETERANINFO","CLIENT_API_GET_VETERANINFO_BY_ID","CLIENT_API_GET_ALL_CLIENT_VETERANINFOS"};

    String[] methodTypes = {"POST","PUT","DELETE","GET","GET"};
    
    
    
    
	
	public UUID createApiMethod() throws Exception{
		System.out.println(methods.length);
		int i=0;
		while(i< methods.length){
		UUID id=UUID.fromString(getUUID());
		String methodName=methods[i];
		String type = methodTypes[i];
		UUID apiGroup =UUID.fromString("55269f08-273f-4f68-ae9b-f98467b4d091");
		String query ="INSERT INTO live.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES "
										+"('"+id+"', '"+methodName+"', '"+methodName+"', '"+methodName+"', '"+type+"',current_date, 'MASTER DATA', '"+apiGroup+"', 0, TRUE)";
		
		System.out.println(query+";");
		Connection connection =getConnection();
		Statement statement1= connection.createStatement();
		statement1.execute(query);
		if(!connection.isClosed()) connection.close();		
		i++;
		return id;
		}
		return null;
	}
	
	public void assignToAdmonProfile(UUID methodId) throws Exception{
		
		UUID id=UUID.fromString(getUUID());
		UUID profileId=UUID.fromString("2a0de2d3-ce1f-4cf1-9145-04aa70e3196c");
		String insQuery ="INSERT INTO hmis_profile_acl(profile_id, api_method_id, id, created_at, created_by ) "
				+ "VALUES ('"+profileId+"','"+methodId+"' , '"+id+"', current_date, 'MASTET DATA')";
		Connection connection =getConnection();
		Statement statement1= connection.createStatement();
		statement1.execute(insQuery);
		if(!connection.isClosed()) connection.close();		
	}
	

	public void createHmisRedirectUri() throws Exception {
		UUID id=UUID.fromString(getUUID());
		//UUID profileId=UUID.fromString("2a0de2d3-ce1f-4cf1-9145-04aa70e3196c");
		String insQuery ="INSERT INTO live.hmis_redirect_uri(id, uri, trustedapp_id, created_at, created_by ) "
				+ "VALUES ('"+id+"','/login-web.html' , '84846c9d-9afc-4fb2-b22d-ae57f1fd14a3', current_date, 'MASTET DATA')";
		Connection connection =getConnection();
		Statement statement1= connection.createStatement();
		statement1.execute(insQuery);
		if(!connection.isClosed()) connection.close();	
	}	
	
	public void createApiGroups() throws Exception {
		
	}
	public String getUUID(){
		return UUID.randomUUID().toString();
	}
	
	public String createSuperAdminProfile() throws Exception{
		UUID id=UUID.fromString(getUUID());
    	String query="INSERT INTO hmis_profile( id, profile_name, profile_description, created_at, created_by)"+ 
          "  VALUES ('"+id+"', 'Super Admin Profile', 'Super Admin Profile', current_date, 'MASTER DATA')";
		
		System.out.println(query);
    	Connection connection =getConnection();
		Statement statement= connection.createStatement();
		statement.execute(query);
		if(!connection.isClosed()) connection.close();
		return id.toString();
	}
	
	public void createSuperAdminACL(String profileId) throws Exception {
		
		String selQuery = "select * from hmis_api_method";
		Connection connection =getConnection();
		Statement statement= connection.createStatement();
		ResultSet rs =	statement.executeQuery(selQuery);
		while(rs.next()){
			UUID id=UUID.fromString(getUUID());
			String methodId =rs.getString("id");
			String insQuery ="INSERT INTO hmis_profile_acl(profile_id, api_method_id, id, created_at, created_by ) "
					+ "VALUES ('"+profileId+"','"+methodId+"' , '"+id+"', current_date, 'MASTET DATA')";
			Statement statement1= connection.createStatement();
			statement1.execute(insQuery);
		}
		
	}
	
	public void createMasterUser(String profileId,UUID projectGroupId) throws Exception{
		UUID orgId1 =createOrganizations("Organization 1");
		UUID id=UUID.fromString(getUUID());
		String password =HMISCryptographer.Encrypt("password");
		String userQuery="INSERT INTO hmis_user( id, first_name, middle_name, last_name, name_suffix, ssn, dob,  date_created,  created_by, password, profile_id, status, username,organization_id,project_group_id)"
									+" VALUES ('"+id+"', 'Super Admin','Super Admin', 'Super Admin', 'Super Admin', '', current_date,current_date , 'MASTER DATA',  '"+password+"', '"+profileId+"', 'ACTIVE', 'superadmin@hmis.com','"+orgId1+"','"+projectGroupId+"')";
		Connection connection =getConnection();
		Statement statement= connection.createStatement();
		statement.execute(userQuery);
		if(!connection.isClosed()) connection.close();
	}
	
	
	public UUID createOrganizations(String organizationName) throws Exception {
		UUID id1=UUID.fromString(getUUID());
		String org1="INSERT INTO organization( organizationcommonname, id, organizationname, date_created ) VALUES ('"+organizationName+"', '"+id1+"', '"+organizationName+"',current_date)";
		Connection connection =getConnection();
		Statement statement= connection.createStatement();
		statement.execute(org1);
		if(!connection.isClosed()) connection.close();
		return id1;
	}
	
	
	public UUID createProjects(UUID orgId) throws Exception {
		UUID id1=UUID.fromString(getUUID());
		String org1="INSERT INTO project( id,  organizationid, projectcommonname, projectname,  date_created) "
					+" VALUES ('"+id1+"', '"+orgId+"', 'Project_"+System.currentTimeMillis()+"','Project_"+System.currentTimeMillis()+"', current_date)";
		Connection connection =getConnection();
		Statement statement= connection.createStatement();
		statement.execute(org1);
		if(!connection.isClosed()) connection.close();
		return id1;
	}
	
	
	public void clearData() throws Exception {
		String truncateuser="truncate hmis_user cascade";
		String truncateProfileACL="truncate hmis_profile_acl cascade";
		String truncateProfile="truncate hmis_profile cascade";
		String truncateOrg="truncate organization cascade";
		String truncateProjectGroup ="truncate hmis_project_group cascade";
		String truncatePojGroupMap = "truncate hmis_project_projectgroup_map cascade";
		Connection connection =getConnection();
		Statement statement= connection.createStatement();
		statement.execute(truncateuser);
		statement.execute(truncateProfile);
		statement.execute(truncateProfileACL);
		statement.execute(truncateOrg);
		statement.execute(truncateProjectGroup);
		statement.execute(truncatePojGroupMap);
		if(!connection.isClosed()) connection.close();
		
		
				
	}
	
	public UUID createEnrollment(UUID projectId) throws Exception {
		UUID id1=UUID.fromString(getUUID());
		String enroll = "INSERT INTO live.enrollment( id, entrydate,  projectid, date_created) VALUES ('"+id1+"',current_date, '"+projectId+"',current_date)";
		Connection connection =getConnection();
		Statement statement= connection.createStatement();
		statement.execute(enroll);
		if(!connection.isClosed()) connection.close();
		return id1;
	}
	
	public static void main(String args[]){
		CreateMasterData data=new CreateMasterData();
		try{
			data.createHmisRedirectUri();
			/*
			data.clearData();
			String id= data.createSuperAdminProfile();
			UUID projectgroupid = data.createProjectGroup();
			data.createSuperAdminACL(id);
			data.createMasterUser(id,projectgroupid);
			data.createTrustedApp();
			
			UUID orgId1 = data.createOrganizations("Organization 1");
			UUID projId = data.createProjects(orgId1);
			data.createEnrollment(projId);
			data.createEnrollment(projId);
			data.createEnrollment(projId);
			data.createEnrollment(projId);
			data.createProjects(orgId1);
			UUID orgId2 = data.createOrganizations("Organization 2");
			data.createProjects(orgId2);
			data.createProjects(orgId2);
			*/
			
//			UUID methodId =	data.createApiMethod();
//			data.assignToAdmonProfile(methodId);	
	
		  /*  String[] methods = {"USR_CREATE_PROJECTGROUP","USR_UPDATE_ROJECTGROUP","USR_DELTEE_PROJECTGROUP","USR_GET_PROJECTGROUP_ID"};

		    String[] methodTypes = {"POST","PUT","DELETE","GET"};

			int i=0;
			while(i< methods.length){
			UUID pk=UUID.randomUUID();
			String methodName=methods[i];
			String type = methodTypes[i];
			UUID apiGroup =UUID.fromString("55269f08-273f-4f68-ae9b-f98467b4d091");
			String query ="INSERT INTO live.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES "
											+"('"+pk+"', '"+methodName+"', '"+methodName+"', '"+methodName+"', '"+type+"',current_timestamp, 'MASTER DATA', '"+apiGroup+"', 0, TRUE)";
			System.out.println(query+";");
			i++;
			}

			
			System.out.println(UUID.randomUUID()); */
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
