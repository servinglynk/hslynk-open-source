package com.servinglynk.report.business;

import static java.time.temporal.TemporalAdjusters.lastDayOfMonth;
import static java.time.temporal.TemporalAdjusters.previousOrSame;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.servinglynk.hive.connection.ImpalaConnection;
import com.servinglynk.hive.connection.ReportQuery;
import com.servinglynk.report.bean.HomePageDataBean;
import com.servinglynk.report.bean.Q19DataBean;
import com.servinglynk.report.bean.ReportData;
import com.servinglynk.report.model.ClientModel;
import com.servinglynk.report.model.ContactModel;
import com.servinglynk.report.model.DataCollectionStage;
import com.servinglynk.report.model.DateOfEngagementModel;
import com.servinglynk.report.model.DisabilitiesModel;
import com.servinglynk.report.model.EnrollmentModel;
import com.servinglynk.report.model.ExitModel;
import com.servinglynk.report.model.IncomeAndSourceModel;
import com.servinglynk.report.model.ProjectModel;
import com.servinglynk.report.model.Q22BeanModel;

public class BaseBeanMaker {
	protected static Logger logger = Logger.getLogger(BaseBeanMaker.class);
	protected static Date chCutoffDate = new Date(2016, 10, 1);

	public static boolean isChild(int age) {
		if(age < 18 && age != 0) {
			return true;
		}
		return false;
	}
	
	public static boolean isAdult(int age) {
		if(age >= 18  && age !=0) {
			return true;
		}
		return false;
	 }
	 protected static long subtractDate(Date from, Date to) {
		 if(from != null && to != null) {
			 long between = ChronoUnit.DAYS.between(LocalDate.parse(to.toString()),LocalDate.parse(from.toString()));
			 return between;
		 }
		 return 0;
	 }
	 protected static String joinProjectIds(String query,ReportData data) {
		 StringBuilder builder = new StringBuilder("");
			List<String> projectIds = data.getProjectIds();
			 if(CollectionUtils.isNotEmpty(projectIds)) {
				 int count = 0;
				 for(String projectId : projectIds) {
					 builder.append("'"+projectId+"'");
					 if(count != projectIds.size()) {
						 builder.append(",");
					 }
				 }
			 }
			 builder.deleteCharAt(builder.length() -1);
			 builder.append(" ) ");
			String newQuery = query + builder.toString();
			return newQuery;
	 }
	
	 protected static String joinEnrollmentIds(String query,ReportData data) {
		 StringBuilder builder = new StringBuilder(" and e.id in  ( ");
			List<EnrollmentModel> enrollments = data.getActiveClients();
			 if(CollectionUtils.isNotEmpty(enrollments)) {
				 int count = 0;
				 for(EnrollmentModel enrollment : enrollments) {
					 builder.append("'"+enrollment.getProjectEntryID()+"'");
					 if(count != enrollments.size()) {
						 builder.append(",");
					 }
				 }
			 }
			 builder.deleteCharAt(builder.length() -1);
			 builder.append(" ) ");
			String newQuery = query + builder.toString();
			return newQuery;
	 }
	protected static String formatQuery(String query, String schema,ReportData data) {
		if(StringUtils.isNotBlank(query)) {
			query = query.replaceAll(":datacollectionstage", "'"+ data.getQueryDataCollectionStage()+"'");
			query = query.replaceAll(":startDate", "'"+ data.getReportStartDate()+"'");
			query = query.replaceAll(":endDate", "'"+ data.getReportEndDate()+"'");
			query = query.replaceAll(":dedupClientId", data.getQueryDedupClientId());
			if(query.contains("%e")) {
				query = joinEnrollmentIds(query, data);
				query = query.replace("%e", "");
			}
			
			query = query.replaceAll("%s", schema);
			System.out.println(query);
			return query;
		}
		return null;
	}
	
	public static int getSize(List list) {
		if(CollectionUtils.isNotEmpty(list)) {
			return list.size();
		}
		return 0;
	}
	
	public static int getSize(Collection collection) {
		if(CollectionUtils.isNotEmpty(collection)) {
			return collection.size();
		}
		return 0;
	}
	
	public static BigInteger getBigIntValue(BigInteger value) {
		if(value != null) {
			return value;
		}
		return getDefaultValue();
	}
	public static BigInteger getDefaultValue() {
		return BigInteger.valueOf(0);
	}
	
	public static int getDefaultIntValue() {
		return 0;
	}
	 public static LocalDate lasWednesayOf(Date date,int month) {
		 Calendar cal = Calendar.getInstance();
		 cal.setTime(date);
		 int year = cal.get(Calendar.YEAR);
		 return LocalDate.of(year, month, 1).with(lastDayOfMonth()).with(previousOrSame(DayOfWeek.WEDNESDAY));
	  }
	
	public static List<String> getProjectsForHouseHoldType(String schema,String query,ReportData data) {
		ResultSet resultSet = null;
		PreparedStatement statement = null;
		Connection connection = null;
		List<String>  models = new ArrayList<String>();
		try {
			connection = ImpalaConnection.getConnection();
			statement = connection.prepareStatement(formatQuery(query, schema, data));
			resultSet = statement.executeQuery();
		 while(resultSet.next()) {
			 models.add(resultSet.getString(1));
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
	public static List<String> getEnrollmentByLivingSituation(String schema,String query) {
		ResultSet resultSet = null;
		PreparedStatement statement = null;
		Connection connection = null;
		List<String>  models = new ArrayList<String>();
		try {
			connection = ImpalaConnection.getConnection();
			statement = connection.prepareStatement(String.format(query,schema));
			resultSet = statement.executeQuery();
		 while(resultSet.next()) {
			 models.add(resultSet.getString(1));
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
	
	public static Set<String> getEnrollmentFromDisabilities(String schema,ReportData data,String query) {
		ResultSet resultSet = null;
		Statement statement = null;
		Connection connection = null;
		Set<String>  models = new HashSet<String>();
		try {
			connection = ImpalaConnection.getConnection();
			statement = connection.createStatement();
			StringBuilder builder = new StringBuilder(" and e.dedup_client_id in  ( ");
			List<ClientModel> clients = data.getClients();
			 if(CollectionUtils.isNotEmpty(clients)) {
				 int count = 0;
				 for(ClientModel client : clients) {
					 builder.append("'"+client.getDedupClientId()+"'");
					 if(count != clients.size()) {
						 builder.append(",");
					 }
				 }
			 }
			 builder.deleteCharAt(builder.length() -1);
			 builder.append(" ) ");
			String newQuery = query + builder.toString();
			resultSet = statement.executeQuery(formatQuery(newQuery, schema, data));
		 while(resultSet.next()) {
			 models.add(resultSet.getString(1));
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
	
	public static Set<String> getEnrollmentFromDisabilitiesForLeavers(String schema,ReportData data,String query) {
		ResultSet resultSet = null;
		Statement statement = null;
		Connection connection = null;
		Set<String>  models = new HashSet<String>();
		try {
			connection = ImpalaConnection.getConnection();
			statement = connection.createStatement();
			StringBuilder builder = new StringBuilder(" and e.dedup_client_id in  ( ");
			List<EnrollmentModel> enrollments = data.getAdultLeavers();
			if(CollectionUtils.isEmpty(enrollments)){
					 return new HashSet<>();
			}
			 if(CollectionUtils.isNotEmpty(enrollments)) {
				 int count = 0;
				 for(EnrollmentModel enrollment : enrollments) {
					 builder.append("'"+enrollment.getDedupClientId()+"'");
					 if(count != enrollments.size()) {
						 builder.append(",");
					 }
				 }
			 }
			 builder.deleteCharAt(builder.length() -1);
			 builder.append(" ) ");
			String newQuery = query + builder.toString();
			resultSet = statement.executeQuery(formatQuery(newQuery, schema, data));
		 while(resultSet.next()) {
			 models.add(resultSet.getString(1));
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
	
	public static List<DisabilitiesModel> getEnrollmentFromDisabilitiesCount(String schema,ReportData data, String query) {
		ResultSet resultSet = null;
		Statement statement = null;
		Connection connection = null;
		List<DisabilitiesModel>  models = new ArrayList<DisabilitiesModel>();
		try {
			connection = ImpalaConnection.getConnection();
			statement = connection.createStatement();
			StringBuilder builder = new StringBuilder(" and e.dedup_client_id in  ( ");
			List<ClientModel> clients = data.getClients();
			if(CollectionUtils.isEmpty(clients)){
				 return new ArrayList<>();
			}
			 if(CollectionUtils.isNotEmpty(clients)) {
				 int count = 0;
				 for(ClientModel client : clients) {
					 builder.append("'"+client.getDedupClientId()+"'");
					 if(count != clients.size()) {
						 builder.append(",");
					 }
				 }
			 }
			 builder.deleteCharAt(builder.length() -1);
			 builder.append(" ) group by dedup_client_id ");
			String newQuery = query + builder.toString();
			resultSet = statement.executeQuery(formatQuery(newQuery, schema, data));
		 while(resultSet.next()) {
			 models.add(new DisabilitiesModel(resultSet.getString(1),resultSet.getInt(2)));
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
	public static List<DisabilitiesModel> getEnrollmentFromDisabilitiesCountForLeavers(String schema,ReportData data, String query) {
		ResultSet resultSet = null;
		Statement statement = null;
		Connection connection = null;
		List<DisabilitiesModel>  models = new ArrayList<DisabilitiesModel>();
		try {
			connection = ImpalaConnection.getConnection();
			statement = connection.createStatement();
			StringBuilder builder = new StringBuilder(" and e.dedup_client_id in  ( ");
			List<EnrollmentModel> enrollments = data.getAdultLeavers();
			if(CollectionUtils.isEmpty(enrollments)){
				 return new ArrayList<>();
			}
			if(CollectionUtils.isEmpty(enrollments)){
				 return new ArrayList<>();
			}
			 if(CollectionUtils.isNotEmpty(enrollments)) {
				 int count = 0;
				 for(EnrollmentModel enrollment : enrollments) {
					 builder.append("'"+enrollment.getDedupClientId()+"'");
					 if(count != enrollments.size()) {
						 builder.append(",");
					 }
				 }
			 }
			 builder.deleteCharAt(builder.length() -1);
			 builder.append(" ) group by dedup_client_id ");
			String newQuery = query + builder.toString();
			resultSet = statement.executeQuery(formatQuery(newQuery, schema, data));
		 while(resultSet.next()) {
			 models.add(new DisabilitiesModel(resultSet.getString(1),resultSet.getInt(2)));
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
	public static List<DisabilitiesModel> getEnrollmentFromDisabilitiesCountWithDate(String schema,String query,ReportData data) {
		ResultSet resultSet = null;
		Statement statement = null;
		Connection connection = null;
		List<DisabilitiesModel>  models = new ArrayList<DisabilitiesModel>();
		try {
			connection = ImpalaConnection.getConnection();
			statement = connection.createStatement();
			StringBuilder builder = new StringBuilder(" and e.dedup_client_id in  ( ");
			List<EnrollmentModel> enrollments = data.getActiveClients();
			if(CollectionUtils.isEmpty(enrollments)){
				 return new ArrayList<>();
			}
			 if(CollectionUtils.isNotEmpty(enrollments)) {
				 int count = 0;
				 for(EnrollmentModel enrollment : enrollments) {
					 builder.append("'"+enrollment.getDedupClientId()+"'");
					 if(count != enrollments.size()) {
						 builder.append(",");
					 }
				 }
			 }
			 builder.deleteCharAt(builder.length() -1);
			 builder.append(" )  group by dedup_client_id ");
			String newQuery = query + builder.toString();
			resultSet = statement.executeQuery(formatQuery(newQuery,schema,data));
		 while(resultSet.next()) {
			 models.add(new DisabilitiesModel(resultSet.getString(1),resultSet.getInt(2)));
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
	public static Set<String> getEnrollmentFromDisabilitiesWithInformationDate(String schema,ReportData data,String query) {
		ResultSet resultSet = null;
		Statement statement = null;
		Connection connection = null;
		Set<String>  models = new HashSet<String>();
		try {
			connection = ImpalaConnection.getConnection();
			statement = connection.createStatement();
			StringBuilder builder = new StringBuilder(" and e.dedup_client_id in  ( ");
			List<EnrollmentModel> enrollments = data.getActiveClients();
			if(CollectionUtils.isEmpty(enrollments)){
				 return new HashSet<>();
			}
			 if(CollectionUtils.isNotEmpty(enrollments)) {
				 int count = 0;
				 for(EnrollmentModel enrollment : enrollments) {
					 builder.append("'"+enrollment.getDedupClientId()+"'");
					 if(count != enrollments.size()) {
						 builder.append(",");
					 }
				 }
			 }
			 builder.deleteCharAt(builder.length() -1);
			 builder.append(" ) ");
			String newQuery = query + builder.toString();
			resultSet = statement.executeQuery(formatQuery(newQuery,schema,data));
		 while(resultSet.next()) {
			 models.add(resultSet.getString(1));
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
	
	public static List<String> getDomesticViolenceByVictim(final String schema,final String victim,ReportData data,String query) {
		ResultSet resultSet = null;
		PreparedStatement statement = null;
		Connection connection = null;
		List<String>  models = new ArrayList<String>();
		try {
			connection = ImpalaConnection.getConnection();
			StringBuilder builder = new StringBuilder( " and e.id in  ( ");
			List<EnrollmentModel> enrollments = data.getEnrollments();
			if(CollectionUtils.isEmpty(enrollments)){
				 return new ArrayList<>();
			}
			 if(CollectionUtils.isNotEmpty(enrollments)) {
				 int count = 0;
				 for(EnrollmentModel enrollment : enrollments) {
					 builder.append("'"+enrollment.getProjectEntryID()+"'");
					 if(count != enrollments.size()) {
						 builder.append(",");
					 }
				 }
			 }
			 builder.deleteCharAt(builder.length() -1);
			 builder.append(" ) ");
			 String newQuery = query +"'"+victim+"'"+ builder.toString();
			statement = connection.prepareStatement(formatQuery(newQuery,schema,data));
			resultSet = statement.executeQuery();
		 while(resultSet.next()) {
			 models.add(resultSet.getString("dedup_client_id"));
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
	
	public static List<String> getDomesticViolenceByVictimDK(final String schema,ReportData data) {
		ResultSet resultSet = null;
		PreparedStatement statement = null;
		Connection connection = null;
		List<String>  models = new ArrayList<String>();
		try {
			connection = ImpalaConnection.getConnection();
			StringBuilder builder = new StringBuilder( " and e.id in  ( ");
			List<EnrollmentModel> enrollments = data.getActiveClients();
			if(CollectionUtils.isEmpty(enrollments)){
				 return new ArrayList<>();
			}
			 if(CollectionUtils.isNotEmpty(enrollments)) {
				 int count = 0;
				 for(EnrollmentModel enrollment : enrollments) {
					 builder.append("'"+enrollment.getProjectEntryID()+"'");
					 if(count != enrollments.size()) {
						 builder.append(",");
					 }
				 }
			 }
			 builder.deleteCharAt(builder.length() -1);
			 builder.append(" ) ");
			 String newQuery = ReportQuery.GET_DOMESTIC_VIOLENCE_BY_VICTIM_DK + builder.toString();
			statement = connection.prepareStatement(formatQuery(newQuery,schema,data));
			resultSet = statement.executeQuery();
		 while(resultSet.next()) {
			 models.add(resultSet.getString("enrollmentid"));
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
	
	public static List<ContactModel> getContacts(final String schema) {
		ResultSet resultSet = null;
		PreparedStatement statement = null;
		Connection connection = null;
		List<ContactModel>  models = new ArrayList<ContactModel>();
		try {
			connection = ImpalaConnection.getConnection();
			statement = connection.prepareStatement(String.format(ReportQuery.GET_ALL_CONTACTS,schema));
			resultSet = statement.executeQuery();
		 while(resultSet.next()) {
			 ContactModel model = new ContactModel(resultSet.getString("id"), resultSet.getString("enrollmentid"), resultSet.getDate("contact_date"), resultSet.getString("contact_location"), resultSet.getString("source_system_id"));
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
	
	public static List<ContactModel> getContactsFromService(final String schema) {
		ResultSet resultSet = null;
		PreparedStatement statement = null;
		Connection connection = null;
		List<ContactModel>  models = new ArrayList<ContactModel>();
		try {
			connection = ImpalaConnection.getConnection();
			statement = connection.prepareStatement(String.format(ReportQuery.GET_ALL_CONTACTS_FROM_SERVICE,schema));
			resultSet = statement.executeQuery();
		 while(resultSet.next()) {
			 ContactModel model = new ContactModel(resultSet.getString("id"), resultSet.getString("enrollmentid"), resultSet.getDate("dateprovided"), resultSet.getString("type_provided"), resultSet.getString("source_system_id"));
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
	public static List<DateOfEngagementModel> getDateOfEngagements(final String schema) {
		ResultSet resultSet = null;
		PreparedStatement statement = null;
		Connection connection = null;
		List<DateOfEngagementModel>  models = new ArrayList<DateOfEngagementModel>();
		try {
			connection = ImpalaConnection.getConnection();
			statement = connection.prepareStatement(String.format(ReportQuery.GET_ALL_DOE,schema));
			resultSet = statement.executeQuery();
		 while(resultSet.next()) {
			 DateOfEngagementModel model = new DateOfEngagementModel(resultSet.getString("id"),resultSet.getString("enrollmentid"), resultSet.getDate("dateofengagement"), resultSet.getString("source_system_id"));
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
	public static List<ClientModel> getClients(String schema,ReportData data) {
		ResultSet resultSet = null;
		PreparedStatement statement = null;
		Connection connection = null;
		List<ClientModel>  models = new ArrayList<ClientModel>();
		try {
			connection = ImpalaConnection.getConnection();
			statement = connection.prepareStatement(formatQuery(getQueryForProjectDB(data, ReportQuery.GET_ALL_CLIENTS),schema,data));
			resultSet = statement.executeQuery();
			String prevDedupClientId = "";
			while(resultSet.next()) {
		    String dedupClientId = resultSet.getString("dedup_client_id");
			if(!StringUtils.equals(prevDedupClientId, dedupClientId)) {
			 ClientModel model = new ClientModel(resultSet.getString("id"),dedupClientId , 
					 resultSet.getString("name_data_quality"),resultSet.getString("name_data_quality_desc"), 
					 resultSet.getString("ssn_data_quality"), resultSet.getString("ssn_data_quality_desc"), 
					 null,resultSet.getString("dob_data_quality"), 
					 resultSet.getString("dob_data_quality_desc"), resultSet.getString("gender"), 
					 resultSet.getString("gender_desc"), null, resultSet.getString("ethnicity"), 
					 resultSet.getString("ethnicity_desc"), resultSet.getString("race"), resultSet.getString("race_desc"), 
					 resultSet.getString("veteran_status"), resultSet.getString("source_system_id"),resultSet.getInt("age"));
			 models.add(model);
		     }
			prevDedupClientId = dedupClientId;
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

	public static boolean isYouthUnder25(Date dob) {
		try {
			LocalDate currentDate = LocalDate.now();
			if(dob !=null) {
				@SuppressWarnings("deprecation")
				LocalDate dateOfBirth = LocalDate.of(dob.getYear(), dob.getMonth(), dob.getDay());
				Period p = Period.between(dateOfBirth, currentDate);
				if(p.getYears() < 25 )
					return true;
				else 
					return false;
			}
			return false;
		}catch(Exception e) {
			return false;
		}
		
	}
	public static boolean inProjectForMoreThan365Days(Date entryDate) {
		try {
			LocalDate currentDate = LocalDate.now();
			if(entryDate !=null) {
				@SuppressWarnings("deprecation")
				LocalDate entryLocalDate = LocalDate.parse(entryDate.toString());
				
				Period p = Period.between(entryLocalDate, currentDate);
				if(p.getYears() >= 1 )
					return true;
				else 
					return false;
			}
			return false;
		}catch(Exception e) {
			return false;
		}
		
	}
	
	
//	public static boolean isAdult(Date dob) {
//		try {
//			LocalDate currentDate = LocalDate.now();
//			if(dob !=null) {
//				@SuppressWarnings("deprecation")
//				LocalDate dateOfBirth = LocalDate.of(dob.getYear(), dob.getMonth(), dob.getDay());
//				Period p = Period.between(dateOfBirth, currentDate);
//				if(p.getYears() >= 18 )
//					return true;
//				else 
//					return false;
//			}
//			return false;
//		}catch(Exception e) {
//			return false;
//		}
//	
//	}
	
	public static int getYearBetweenDates(Date fromDate,Date toDate) {
		try {
			if(fromDate !=null && toDate != null) {
				@SuppressWarnings("deprecation")
				LocalDate fromLocalDate = LocalDate.of(fromDate.getYear(), fromDate.getMonth(), fromDate.getDay());
				LocalDate toLocalDate = LocalDate.of(toDate.getYear(), toDate.getMonth(), toDate.getDay());
				Period p = Period.between(fromLocalDate, toLocalDate);
				return p.getYears();
			}
		}catch(Exception e) {
		}
		return 0;
	}
	public static void populateProject(String schema,String id, HomePageDataBean homePageDataBean) {
		ResultSet resultSet = null;
		PreparedStatement statement = null;
		Connection connection = null;
		try {
			connection = ImpalaConnection.getConnection();
			statement = connection.prepareStatement(String.format(ReportQuery.GET_PROJECT_BY_ID,schema));
			statement.setString(1, id);
			resultSet = statement.executeQuery();
		 while(resultSet.next()) {
			 homePageDataBean.setQ04aProjectName(resultSet.getString("projectname"));
			 homePageDataBean.setQ04aHmisProjectType(resultSet.getString("projecttype_desc"));
			 homePageDataBean.setQ04aProjectId(resultSet.getString("project_source_system_id"));
//			 homePageDataBean.setQ04aProjectId("");
			 homePageDataBean.setQ04aMethodOfTracking(resultSet.getString("trackingmethod_desc"));
			 String organizationId = resultSet.getString("organizationid");
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
				connection = ImpalaConnection.getConnection();
				statement = connection.prepareStatement(String.format(ReportQuery.GET_ORG_BY_ID,schema));
				statement.setString(1, id);
				resultSet = statement.executeQuery();
//				int count = 0;
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

		public static List<IncomeAndSourceModel> getIncomeAndSource(ReportData data,String query,DataCollectionStage dataColletionStage) {
			ResultSet resultSet = null;
			PreparedStatement statement = null;
			Connection connection = null;
			List<IncomeAndSourceModel>  models = new ArrayList<IncomeAndSourceModel>();
			try {
				connection = ImpalaConnection.getConnection();
				String newQuery = buildQueryFromDataCollectionStage(dataColletionStage.getCode(),query,data);
				statement = connection.prepareStatement(formatQuery(newQuery,data.getSchema(),data));
				resultSet = statement.executeQuery();
			 while(resultSet.next()) {
				 /*
				  * select  alimonyamount,childsupportamount,earnedamount,gaamount,othersourceamount,pensionamount,privatedisabilityamount, "+
" socsecretirementamount,ssiamount,tanfamount,totalmonthlyincome,unemploymentamount,vadisabilitynonserviceamount, "+
" vadisabilityserviceamount,workerscompamount,e.dedup_client_id as dedup_client_id,i.incomefromanysource,e.entrydate

alimonyamount,childsupportamount,earnedamount,gaamount,othersourceamount,pensionamount,privatedisabilityamount, "+
" socsecretirementamount,ssiamount,tanfamount,totalmonthlyincome,unemploymentamount,vadisabilitynonserviceamount, "+
" vadisabilityserviceamount,workerscompamount,

				  */
				 IncomeAndSourceModel model = null;
				 if(DataCollectionStage.ENTRY.equals(dataColletionStage) || DataCollectionStage.ANNUAL_ASSESMENT.equals(dataColletionStage)) {
					 
					 
					 model = new IncomeAndSourceModel(resultSet.getString("datacollectionstage"), resultSet.getString("dedup_client_id"), resultSet.getDate("information_date"), resultSet.getDate("entrydate"), 
							 resultSet.getFloat(1), resultSet.getFloat(2),  resultSet.getFloat(3) , resultSet.getFloat(4), 
							 resultSet.getFloat(5), resultSet.getFloat(6), resultSet.getFloat(7), resultSet.getFloat(8), 
							 resultSet.getFloat(9), resultSet.getFloat(10), resultSet.getFloat(11), resultSet.getFloat(12), 
							 resultSet.getFloat(13), resultSet.getFloat(14),resultSet.getFloat(15), 
							 resultSet.getString("incomefromanysource"), resultSet.getInt("ageatentry"),
							 resultSet.getString("alimony"),
							 resultSet.getString("childsupport"),
							 resultSet.getString("earned"),
							 resultSet.getString("ga"),
							 resultSet.getString("othersource"),
							 resultSet.getString("pension"),
							 resultSet.getString("privatedisability"),
							 resultSet.getString("socsecretirement"),
							 resultSet.getString("ssdi"),
							 resultSet.getString("ssi"),
							 resultSet.getString("tanf"),
							 resultSet.getString("unemployment"),
							 resultSet.getString("vadisabilitynonservice"),
							 resultSet.getString("vadisabilityservice"),
							 resultSet.getString("workerscomp")
							 );
				 } else if(DataCollectionStage.EXIT.equals(dataColletionStage)) {
					 model = new IncomeAndSourceModel(resultSet.getString("datacollectionstage"), resultSet.getString("dedup_client_id"), resultSet.getDate("information_date"), resultSet.getDate("exitdate"), 
							 resultSet.getFloat(1), resultSet.getFloat(2),  resultSet.getFloat(3) , resultSet.getFloat(4), 
							 resultSet.getFloat(5), resultSet.getFloat(6), resultSet.getFloat(7), resultSet.getFloat(8), 
							 resultSet.getFloat(9), resultSet.getFloat(10), resultSet.getFloat(11), resultSet.getFloat(12), 
							 resultSet.getFloat(13), resultSet.getFloat(14),resultSet.getFloat(15), 
							 resultSet.getString("incomefromanysource"),resultSet.getInt("ageatentry"),
							 resultSet.getString("alimony"),
							 resultSet.getString("childsupport"),
							 resultSet.getString("earned"),
							 resultSet.getString("ga"),
							 resultSet.getString("othersource"),
							 resultSet.getString("pension"),
							 resultSet.getString("privatedisability"),
							 resultSet.getString("socsecretirement"),
							 resultSet.getString("ssdi"),
							 resultSet.getString("ssi"),
							 resultSet.getString("tanf"),
							 resultSet.getString("unemployment"),
							 resultSet.getString("vadisabilitynonservice"),
							 resultSet.getString("vadisabilityservice"),
							 resultSet.getString("workerscomp"));
				 }
				 
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
		public static List<EnrollmentModel> getEnrollmentsByCocId(String schema,String  cocId, ReportData data) {
			ResultSet resultSet = null;
			PreparedStatement statement = null;
			Connection connection = null;
			List<EnrollmentModel>  models = new ArrayList<EnrollmentModel>();
			try {
				connection = ImpalaConnection.getConnection();
				statement = connection.prepareStatement(formatQuery(ReportQuery.GET_ENROLLMENTS_BY_COC_ID,schema,data));
				statement.setString(1, cocId);
				resultSet = statement.executeQuery();
			 while(resultSet.next()) {
				 EnrollmentModel model = new EnrollmentModel(resultSet.getString("id"), 
						// resultSet.getString("enrollment.continuouslyhomelessoneyear"),
						 null,
						 resultSet.getString("disablingcondition"), 
						 resultSet.getDate("entrydate"), 
						 resultSet.getString("householdid"), 
						 resultSet.getString("housingstatus"), 
						 resultSet.getString("housingstatus_desc"), 
						 resultSet.getString("monthshomelesspastthreeyears"), 
						 resultSet.getString("monthshomelesspastthreeyears_desc"), 
						// resultSet.getString("monthshomelessthistime"), 
						 null,
						 null, 
						 resultSet.getString("projectid"), 
						 resultSet.getString("relationshiptohoh"), 
						 resultSet.getString("relationshiptohoh_desc"), 
						null, 
						null, 
						 resultSet.getString("lengthofstay"), 
						 resultSet.getString("lengthofstay_desc"), 
						// resultSet.getString("statusdocumented"), 
						 null,
						 resultSet.getString("timeshomelesspastthreeyears"), 
						 resultSet.getString("timeshomelesspastthreeyears_desc"), 
						 resultSet.getString("ageatentry"), 
						 resultSet.getString("client_id"), 
						// resultSet.getInt("yearshomeless"), 
						 0,
						 (Boolean)resultSet.getBoolean("chronichomeless"), 
						 resultSet.getString("source_system_id"),
						 resultSet.getDate("date_created_from_source"),
						 resultSet.getString("livingSituation"),
						 resultSet.getDate("datetostreetessh"),
						 resultSet.getString("dedup_client_id"));
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

		public static List<EnrollmentModel> getEnrollmentsByProjectcId(String schema,List<String>  projects,ReportData data) {
			ResultSet resultSet = null;
			Statement statement = null;
			Connection connection = null;
			List<EnrollmentModel>  models = new ArrayList<EnrollmentModel>();
			try {
				connection = ImpalaConnection.getConnection();
				statement = connection.createStatement();
				String query = formatQuery(getQueryForProjectDB(data,ReportQuery.GET_ENROLLMENTS_PROJECT_ID),schema, data);
				resultSet = statement.executeQuery(query);
				String prevDedupClientId = "";
			 while(resultSet.next()) {
				 String dedupClientId = resultSet.getString("dedup_id");
				 if(!StringUtils.equals(prevDedupClientId, dedupClientId)) {
					 EnrollmentModel model = new EnrollmentModel(resultSet.getString("id"), 
								// resultSet.getString("enrollment.continuouslyhomelessoneyear"),
								 null,
								 resultSet.getString("disablingcondition"), 
								 resultSet.getDate("entrydate"), 
								 resultSet.getString("householdid"), 
								 null, 
								 null, 
								 resultSet.getString("monthshomelesspastthreeyears"), 
								 resultSet.getString("monthshomelesspastthreeyears_desc"), 
								// resultSet.getString("monthshomelessthistime"), 
								 null,
								 null, 
								 resultSet.getString("projectid"), 
								 resultSet.getString("relationshiptohoh"), 
								 resultSet.getString("relationshiptohoh_desc"), 
								 null, 
								 null, 
								 resultSet.getString("lengthofstay"), 
								 resultSet.getString("lengthofstay_desc"), 
								// resultSet.getString("statusdocumented"), 
								 null,
								 resultSet.getString("timeshomelesspastthreeyears"), 
								 resultSet.getString("timeshomelesspastthreeyears_desc"), 
								 null, 
								 resultSet.getString("client_id"), 
								// resultSet.getInt("yearshomeless"), 
								 resultSet.getInt("ageatentry"),
								 resultSet.getBoolean("chronichomeless"), 
								 resultSet.getString("source_system_id"),
								 resultSet.getDate("date_created_from_source"),
								 resultSet.getString("livingsituation"),
								 resultSet.getDate("datetostreetessh"),
								 resultSet.getString("dedup_client_id"));
					 prevDedupClientId = resultSet.getString("dedup_client_id");
						 models.add(model);
				 }
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
		
		public static List<ProjectModel> getProjects(String schema,List<String> projects) {
			ResultSet resultSet = null;
			Statement statement = null;
			Connection connection = null;
			List<ProjectModel>  models = new ArrayList<ProjectModel>();
			try {
				connection = ImpalaConnection.getConnection();
				statement = connection.createStatement();
				String query = String.format(ReportQuery.GET_PROJECTS,schema);
				StringBuilder builder = new StringBuilder(query);
				int i=1;
				for(String project : projects) {
					builder.append("\""+ project +"\"");
					if(i != projects.size()) {
						builder.append(",");
					}
					i++;
				}
				builder.append(")");
				resultSet = statement.executeQuery(builder.toString());
			 while(resultSet.next()) {
				 ProjectModel model = new ProjectModel(resultSet.getString("projectname"), resultSet.getString("projecttype"), resultSet.getString("id"),resultSet.getString("organizationid"),resultSet.getString("trackingmethod"));
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
		public static List<ProjectModel> getProjectsByCoc(String schema,String cocId) {
			ResultSet resultSet = null;
			PreparedStatement statement = null;
			Connection connection = null;
			List<ProjectModel>  models = new ArrayList<ProjectModel>();
			try {
				connection = ImpalaConnection.getConnection();
				statement = connection.prepareStatement(String.format(ReportQuery.GET_PROJECTS_BY_COC,schema,schema));
				statement.setString(1, cocId);
				resultSet = statement.executeQuery();
			 while(resultSet.next()) {
				 ProjectModel model = new ProjectModel(resultSet.getString("projectname"), resultSet.getString("projectType"), resultSet.getString("project_id"),resultSet.getString("organizationid"),resultSet.getString("trackingmethod"));
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
		
		public static List<ExitModel> getAllExits(String schema,ReportData data) {
			ResultSet resultSet = null;
			PreparedStatement statement = null;
			Connection connection = null;
			List<ExitModel>  models = new ArrayList<ExitModel>();
			try {
				connection = ImpalaConnection.getConnection();
				String query = joinProjectIds(ReportQuery.GET_ALL_EXITS, data);
				statement = connection.prepareStatement(formatQuery(query,schema,data));
				resultSet = statement.executeQuery();
			 while(resultSet.next()) {
				 ExitModel model = new ExitModel( resultSet.getString("id"), resultSet.getString("destination"), 
						 resultSet.getString("destination_desc"), 
						 resultSet.getDate("exitdate"), 
						 resultSet.getString("otherdestination"), 
						 resultSet.getString("enrollmentid"), resultSet.getString("source_system_id"), resultSet.getDate("date_created_from_source"));
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

		 public static Map<String,Date>  getEnrollmentsByDataCollectionStage(String schema,String datacollectionStage,ReportData data) {
				String  query= " SELECT e.id,ecoc.information_date from %s.enrollment e, %s.enrollment_coc ecoc where e.id = ecoc.enrollmentid and ecoc.datacollectionstage='5' and ecoc.information_date >= :startDate and  ecoc.information_date <=:endDate   ";
				ResultSet resultSet = null;
				Statement statement = null;
				Connection connection = null;
				Map<String,Date> annualAssesments = new HashMap<>();
				try {
					connection = ImpalaConnection.getConnection();
					statement = connection.createStatement();
					data.setQueryDataCollectionStage(datacollectionStage);
					resultSet = statement.executeQuery(formatQuery(query, schema, data));
					
				 while(resultSet.next()) {
					 String dedupClientId =(String)resultSet.getObject(1);
					 Date informationDate = resultSet.getDate(2);
					 annualAssesments.put(dedupClientId, informationDate);
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
					return annualAssesments;
			    }
		 
		 
		 public static int getIncomeCnt(ReportData data,String query,String datacollectionStage) {
				ResultSet resultSet = null;
				Statement statement = null;
				Connection connection = null;
				int count =0;
				try {
					connection = ImpalaConnection.getConnection();
					statement = connection.createStatement();
					String buildQueryFromDataCollectionStage = buildQueryFromDataCollectionStage(datacollectionStage, query, data);
					resultSet = statement.executeQuery(formatQuery(buildQueryFromDataCollectionStage,data.getSchema(), data));
					
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
		 public static int getIncomeForAnnualAssesment(ReportData data,String query,String datacollectionStage) {
				ResultSet resultSet = null;
				Statement statement = null;
				Connection connection = null;
				int count =0;
				try {
					connection = ImpalaConnection.getConnection();
					statement = connection.createStatement();
					data.setQueryDataCollectionStage(datacollectionStage);
					String buildQueryFromDataCollectionStage = buildQueryFromDataCollectionStage(datacollectionStage, query, data);
					resultSet = statement.executeQuery(formatQuery(buildQueryFromDataCollectionStage,data.getSchema(),data));
					
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
		 
		 public static boolean isNullOrNegative(String value) {
			 if(StringUtils.isEmpty(value) || (StringUtils.equals("0", value))) {
				 return true;
			 }
			 return false;
		 }
	
		 public static boolean isPositive(String value) {
			 if(StringUtils.equals("1", value)) {
				 return true;
			 }
			 return false;
		 }
		 
		 public static boolean didNotKnowOrRefused(String value) {
			 if(StringUtils.equals("8", value) || StringUtils.equals("9", value) ) {
				 return true;
			 }
			 return false;
		 }
		 
		 public static boolean dataNotCollected(String value) {
			 if(StringUtils.equals("99", value)) {
				 return true;
			 }
			 return false;
		 }
		 
		 private static Boolean convertStringBoolean(String value) {
				 if(StringUtils.equals("t", value)) {
					return Boolean.TRUE;
				 }
				 if(StringUtils.equals("f", value)) {
					 return Boolean.FALSE;
				 }
				 return Boolean.FALSE;
		 }
		 protected static void populateBedNights(Q22BeanModel model, ReportData data) {
				String[] method1 = new String[] { "2", "4", "6", "7", "8", "11", "12", "14"};
				List<String> method1List = Arrays.asList(method1);
				String[] method3 = new String[] {"3", "9", "10", "13" };
				List<String> method3List = Arrays.asList(method3);
				Date reportStartDate = data.getReportStartDate();
				Date reportEndDate = data.getReportEndDate();
				if((StringUtils.equals("1",model.getProjectType()) && StringUtils.equals(model.getTrackingMethod(), "0")) || 
					(StringUtils.isNotEmpty(model.getProjectType()) &&	method1List.contains(model.getProjectType()))) {
					    /*** Bed nights = [minimum of ( [project exit date], [report end date] + 1) ]
								– [maximum of ( [project start date], [report start date] ) ] 
					    **/
					   model.setNumberOfDays(subtractDate(getMaximumDate(model.getExitdate(),reportEndDate),getMinimumDate(model.getEntrydate(), reportStartDate)));
				}
				if(StringUtils.equals("1",model.getProjectType()) && StringUtils.equals(model.getTrackingMethod(), "3")) {
					/***
					 * [bed night date] must be:
						>= [project start date]
						and < [project exit date] or [project exit date] is null
						and >= [report start date]
						and <= [report end date]
					 */
					String bedNightsQuery = " select count(sfr.id) from enrollment e join project p  on (e.projectid = p.id and e.dedup_client_id=?  %p ) "+
							" join service_fa_referral sfr  on  (sfr.enrollmentid = e.id and record_type='200' and dateprovided >= e.entrydate  and dateprovided >= :startDate and dateprovided <= :endDate) "+
						    " join exit ext on (sfr.dateprovided < ext.exitdate or ext.exitdate is null) ";

					// May be have another query to get the correct bed nights count.
					model.setNumberOfDays(getBedNights(bedNightsQuery, data, model.getDedupClientId()));
				}
				
				if(StringUtils.isNotEmpty(model.getProjectType()) && method3List.contains(model.getProjectType())) {
					model.setNumberOfDays(subtractDate(getMaximumDate(model.getExitdate(),reportEndDate),getMinimumDate(model.getEntrydate(), reportStartDate)));
				}
				
			}
			
			public static Date addDays(Date date, int days) {
		        Calendar c = Calendar.getInstance();
		        c.setTime(date);
		        c.add(Calendar.DATE, days);
		        return new Date(c.getTimeInMillis());
		    }
			 public static Date getMinimumDate(Date date1, Date date2) {
				 if(date1 == null)  {
					 return date2;
				 }
				 if(date2 == null) {
					 return date1;
				 }
				 
				 if(date1.before(date2)) {
					 return addDays(date1,1);
				 }
				return addDays(date2,1);
			}
			 
			 public static Date getMaximumDate(Date date1, Date date2) {
				 if(date1 == null)  {
					 return date2;
				 }
				 if(date2 == null) {
					 return date1;
				 }
				 if(date1.after(date2)) {
					 return date1;
				 }
				return date2;
			}
			 
			 public static int getIncomeCnt(String schema,String query,String datacollectionStage, ReportData data) {
					ResultSet resultSet = null;
					Statement statement = null;
					Connection connection = null;
					int count =0;
					try {
						connection = ImpalaConnection.getConnection();
						StringBuilder builder = new StringBuilder(" and e.id in  ( ");
						List<EnrollmentModel> enrollments = data.getActiveClients();
						 if(CollectionUtils.isNotEmpty(enrollments)) {
							 int index = 0;
							 for(EnrollmentModel enrollment : enrollments) {
								 builder.append("'"+enrollment.getProjectEntryID()+"'");
								 if(index != enrollments.size()) {
									 builder.append(",");
								 }
							 }
						 }
						 builder.deleteCharAt(builder.length() -1);
						 builder.append(" ) ");
						String newQuery = query + builder.toString();
						statement = connection.createStatement();
						resultSet = statement.executeQuery(formatQuery(getQueryForProjectDB(data, newQuery),schema,data));
						
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
			  public static String getQueryForProjectDB(ReportData data,String query){
					String projectQuery = " and p.id in ( ";
					StringBuilder builder = new StringBuilder(projectQuery);
				  List<String> projectIds = data.getProjectIds();
					 if(CollectionUtils.isNotEmpty(projectIds)) {
						 int count = 0;
						 for(String project : projectIds) {
							 builder.append("'"+project+"'");
							 if(count != projectIds.size()) {
								 builder.append(",");
							 }
						 }
					 }
					 builder.deleteCharAt(builder.length() -1);
					 builder.append(" ) ");
					String newQuery = query;
					 if(CollectionUtils.isNotEmpty(projectIds)) {
						 newQuery = query.replace("%p", builder.toString());
					 }else {
						 newQuery = query.replace("%p", " ");
					 }
					 return newQuery;
			  }
				
			    public static long getBedNights(String query, ReportData data, String dedupClientId) {
			    	long bedNights = 0;
			    	ResultSet resultSet = null;
					Statement statement = null;
				
					Connection connection = null;
					try {
						connection = ImpalaConnection.getConnection();
						statement = connection.createStatement();
						data.setQueryDedupClientId(dedupClientId);
					
						resultSet = statement.executeQuery(formatQuery(getQueryForProjectDB(data, query),data.getSchema(),data));
						 while(resultSet.next()) {
							 bedNights = resultSet.getLong(1);
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
					return bedNights;
			    }
			    
			    
			    
			    
			    
			    public static List<Q22BeanModel> getQ22BeanLengthOfStay(ReportData data,String query,List<String> filteredProjectIds, boolean allProjects,boolean withDestination) {
					 List<Q22BeanModel> q22Beans = new ArrayList<Q22BeanModel>();
					 if(CollectionUtils.isNotEmpty(filteredProjectIds))
					 {
						 return q22Beans;
					 }
						ResultSet resultSet = null;
						Statement statement = null;
						String projectQuery = " and p.id in ( ";
						StringBuilder builder = new StringBuilder(projectQuery);
						Connection connection = null;
						try {
							connection = ImpalaConnection.getConnection();
							 List<String> projectIds = data.getProjectIds();
							 if(CollectionUtils.isNotEmpty(projectIds)) {
								 int count = 0;
								 for(String project : projectIds) {
									 if ((filteredProjectIds !=null && filteredProjectIds.contains(project)) || allProjects) {
										 builder.append("'"+project+"'");
										 if(count != projectIds.size()) {
											 builder.append(",");
										 }
									 }
								 }
							 }
							 builder.deleteCharAt(builder.length()-1);
							 builder.append(" ) ");
							String newQuery = query;
							 if(CollectionUtils.isNotEmpty(filteredProjectIds)) {
								 newQuery = query.replace("%p", builder.toString());
							 }else {
								 newQuery = query.replace("%p", " ");
							 }
							
							 StringBuilder enrollmentBuilder = new StringBuilder(" and e.id in  ( ");
								List<EnrollmentModel> enrollments = data.getAdultLeavers();
								 if(CollectionUtils.isNotEmpty(enrollments)) {
									 int index = 0;
									 for(EnrollmentModel enrollment : enrollments) {
										 enrollmentBuilder.append("'"+enrollment.getProjectEntryID()+"'");
										 if(index != enrollments.size()) {
											 enrollmentBuilder.append(",");
										 }
									 }
								 }
								 enrollmentBuilder.deleteCharAt(enrollmentBuilder.length() -1);
								 enrollmentBuilder.append(" ) ");
								String finalQuery = newQuery + enrollmentBuilder.toString();
							statement = connection.createStatement();
							resultSet = statement.executeQuery(formatQuery(finalQuery,data.getSchema(),data));
							
						 while(resultSet.next()) {
							 Date entryDate = resultSet.getDate("entrydate");
							 Date moveinDate = resultSet.getDate("moveindate");
							 
							 Q22BeanModel bean = new Q22BeanModel(resultSet.getString("dedup_client_id"), resultSet.getString("trackingmethod"),resultSet.getString("projecttype"), 
									 resultSet.getDate("operatingstartdate"),resultSet.getDate("exitdate"),entryDate,moveinDate,null);
							 populateBedNights(bean, data);
							 if(withDestination) {
								 bean.setDestination(resultSet.getString("destination"));
							 }
							 q22Beans.add(bean);
						 
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
						return q22Beans;
					}	
			    
			    public static List<Q22BeanModel> getQ22BeanLengthOfStayForExit(ReportData data,String query,List<String> filteredProjectIds, boolean allProjects,boolean withDestination) {
					 List<Q22BeanModel> q22Beans = new ArrayList<Q22BeanModel>();
					 if(CollectionUtils.isEmpty(filteredProjectIds) && !allProjects)
					 {
						 return q22Beans;
					 }	
					 ResultSet resultSet = null;
						Statement statement = null;
						String projectQuery = " and p.id in ( ";
						StringBuilder builder = new StringBuilder(projectQuery);
						Connection connection = null;
						try {
							connection = ImpalaConnection.getConnection();
							 List<String> projectIds = data.getProjectIds();
							 if(CollectionUtils.isNotEmpty(projectIds)) {
								 int count = 0;
								 for(String project : projectIds) {
									 if ((filteredProjectIds !=null && filteredProjectIds.contains(project)) || allProjects) {
										 builder.append("'"+project+"'");
										 if(count != projectIds.size()) {
											 builder.append(",");
										 }
									 }
								 }
							 }
							 builder.deleteCharAt(builder.length()-1);
							 builder.append(" ) ");
							String newQuery = query;
							 if(CollectionUtils.isNotEmpty(filteredProjectIds)) {
								 newQuery = query.replace("%p", builder.toString());
							 }else {
								 newQuery = query.replace("%p", " ");
							 }
							 String newQueryWithEnrollments = newQuery;
							 StringBuilder builderWithEnrollments = new StringBuilder(" where e.id in  ( ");
								List<EnrollmentModel> enrollments = data.getAdultLeavers();
								if(CollectionUtils.isEmpty(enrollments)){
									 return new ArrayList<>();
								}
								 if(CollectionUtils.isNotEmpty(enrollments)) {
									 int count = 0;
									 for(EnrollmentModel enrollment : enrollments) {
										 builderWithEnrollments.append("'"+enrollment.getProjectEntryID()+"'");
										 if(count != enrollments.size()) {
											 builderWithEnrollments.append(",");
										 }
									 }
								 }
								 builderWithEnrollments.deleteCharAt(builderWithEnrollments.length() -1);
								 builderWithEnrollments.append(" ) ");
								
								 newQueryWithEnrollments =	 newQueryWithEnrollments + builderWithEnrollments.toString();
							statement = connection.createStatement();
							resultSet = statement.executeQuery(formatQuery(newQueryWithEnrollments+ " order by e.dedup_client_id ",data.getSchema(),data));
							
						 while(resultSet.next()) {
							 Date entryDate = resultSet.getDate("entrydate");
							 Date moveinDate = resultSet.getDate("moveindate");
							 
							 Q22BeanModel bean = new Q22BeanModel(resultSet.getString("dedup_client_id"), resultSet.getString("trackingmethod"),resultSet.getString("projecttype"), 
									 resultSet.getDate("operatingstartdate"),resultSet.getDate("exitdate"),entryDate,moveinDate,null);
							 populateBedNights(bean, data);
							 if(withDestination) {
								 bean.setDestination(resultSet.getString("destination"));
							 }
							 q22Beans.add(bean);
						 
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
						return q22Beans;
					}	
			    
			    public static String buildQueryFromDataCollectionStage(String datacollectionStage,String query, ReportData data) {
			    	String reportType= "ALL";
			    	if(StringUtils.equals(datacollectionStage, DataCollectionStage.ANNUAL_ASSESMENT.getCode())) {
						reportType = "STAYERS";
					}else if(StringUtils.equals(datacollectionStage, DataCollectionStage.EXIT.getCode())) {
						reportType = "LEAVERS";
					}else if(StringUtils.equals(datacollectionStage, DataCollectionStage.ENTRY.getCode())) {
						reportType = "ALL";
					}
					return buildQuery(query, reportType, data);
			    }
			    
			    public static String buildQuery(String query, String reportType,ReportData data) {
			    	StringBuilder builder = new StringBuilder();
			    	String newQuery = "";
			    	List<EnrollmentModel> enrollments =  null;
			    	if(StringUtils.equals("LEAVERS", reportType) ) {
			    		enrollments = data.getLeavers();
					}else if(StringUtils.equals("STAYERS", reportType) ) {
						enrollments = data.getAdultStayersHoh365Days();
					}else if(StringUtils.equals("ALL", reportType) ) {
						enrollments = data.getEnrollments();
					} else if(StringUtils.equals("ANNUAL_ASSESMENT", reportType) ) {
						enrollments = data.getAdultStayersHoh365Days();
					}
					 if(CollectionUtils.isNotEmpty(enrollments)) {
						 builder.append(" and e.dedup_client_id in ( ");
						 int count = 0;
						 for(EnrollmentModel enrollment : enrollments) {
							 builder.append("'"+enrollment.getDedupClientId()+"'");
							 if(count != enrollments.size()) {
								 builder.append(",");
							 }
						 }
						 builder.deleteCharAt(builder.length()-1);
						 builder.append(" ) ");
					 }
					 if(CollectionUtils.isNotEmpty(enrollments)) {
						 newQuery = query.replace("%dedup", builder.toString());
					 }else {
						 newQuery = query.replace("%dedup", " ");
					 }
					 
					 return newQuery;
			    }
			    public static List<Q22BeanModel> getQ22Bean(ReportData data,String query,String reportType) {
					 List<Q22BeanModel> q22Beans = new ArrayList<Q22BeanModel>();
						ResultSet resultSet = null;
						Statement statement = null;
						String projectQuery = " and p.id in ( ";
						StringBuilder builder = new StringBuilder(projectQuery);
						Connection connection = null;
						try {
							connection = ImpalaConnection.getConnection();
							 List<String> projectIds = data.getProjectIds();
							 if(CollectionUtils.isNotEmpty(projectIds)) {
								 int count = 0;
								 for(String project : projectIds) {
									 builder.append("'"+project+"'");
									 if(count != projectIds.size()) {
										 builder.append(",");
									 }
								 }
							 }
							 builder.deleteCharAt(builder.length()-1);
							 builder.append(" ) ");
							String newQuery = query;
							 if(CollectionUtils.isNotEmpty(projectIds)) {
								 newQuery = query.replace("%p", builder.toString());
							 }else {
								 newQuery = query.replace("%p", " ");
							 }
							 
							newQuery = buildQuery(newQuery, reportType, data);
							statement = connection.createStatement();
							
							resultSet = statement.executeQuery(formatQuery(newQuery,data.getSchema(),data));
							
						 while(resultSet.next()) {
							 q22Beans.add(new Q22BeanModel(resultSet.getString("dedup_client_id"),resultSet.getString("trackingmethod"), resultSet.getString("projecttype"), 
									 resultSet.getDate("operatingstartdate"),resultSet.getDate("exitdate"),resultSet.getDate("entrydate"),resultSet.getDate("moveindate"),null));
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
						return q22Beans;
					}	
				
			    protected static List<String> getClients(String schema,String query,ReportData data) {
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
			 
			    public static List<String> getClients(ReportData data,String query,List<String> filteredProjectIds, boolean allProjects) {
					 List<String> clients = new ArrayList<String>();
					 if (CollectionUtils.isEmpty(filteredProjectIds) &&  !allProjects) {
						 return clients;
					 	}
						ResultSet resultSet = null;
						Statement statement = null;
						String projectQuery = " and p.id in ( ";
						StringBuilder builder = new StringBuilder(projectQuery);
						Connection connection = null;
						try {
							connection = ImpalaConnection.getConnection();
							 List<String> projectIds = data.getProjectIds();
							 if(CollectionUtils.isNotEmpty(projectIds)) {
								 int count = 0;
								 for(String project : projectIds) {
									 if ((filteredProjectIds !=null && filteredProjectIds.contains(project)) || allProjects) {
										 builder.append("'"+project+"'");
										 if(count != projectIds.size()) {
											 builder.append(",");
										 }
									 }
								 }
							 }
							 builder.deleteCharAt(builder.length() -1 );
							 builder.append(" ) ");
							String newQuery = query;
							 if(CollectionUtils.isNotEmpty(filteredProjectIds) || allProjects) {
								 newQuery = query.replace("%p", builder.toString());
							 }else {
								 newQuery = query.replace("%p", " ");
							 }
							 
							 String newQueryWithEnrollments = newQuery;
							 
								List<EnrollmentModel> enrollments = data.getAdultLeavers();
								 if(CollectionUtils.isNotEmpty(enrollments)) {
									 StringBuilder builderWithEnrollments = new StringBuilder(" and e.id in  ( ");
									 int count = 0;
									 for(EnrollmentModel enrollment : enrollments) {
										 builderWithEnrollments.append("'"+enrollment.getProjectEntryID()+"'");
										 if(count != enrollments.size()) {
											 builderWithEnrollments.append(",");
										 }
									 }
									 builderWithEnrollments.deleteCharAt(builderWithEnrollments.length() -1);
									 builderWithEnrollments.append(" ) ");
									 newQueryWithEnrollments =	 newQueryWithEnrollments + builderWithEnrollments.toString();
								 }
							statement = connection.createStatement();
							resultSet = statement.executeQuery(formatQuery(newQueryWithEnrollments,data.getSchema(),data));
							
						 while(resultSet.next()) {
							 clients.add(resultSet.getString(1));
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
						return clients;
					}	
			    
			    
			    

				public static int  getDestination (List<Q22BeanModel> q22Beans , String destination) {
					if(CollectionUtils.isNotEmpty(q22Beans)) {
						List<Q22BeanModel>  q22Bean7DaysOrLessAllData = q22Beans.parallelStream().filter(q22BeanModel -> StringUtils.equals(destination, q22BeanModel.getDestination())).collect(Collectors.toList());
						return q22Bean7DaysOrLessAllData.size();
					}
					 return 0;
				}

				public static int  getDestination (List<Q22BeanModel> q22Beans , String destination1,String destination2) {
					if(CollectionUtils.isNotEmpty(q22Beans)) {
						List<Q22BeanModel>  q22Bean7DaysOrLessAllData = q22Beans.parallelStream().filter(q22BeanModel ->  ( StringUtils.equals(destination1, q22BeanModel.getDestination())  || StringUtils.equals(destination2, q22BeanModel.getDestination()) )).collect(Collectors.toList());
						return q22Bean7DaysOrLessAllData.size();
					}
					 return 0;
				}
				
				public static int  getDestinationByDestinationType(List<Q22BeanModel> q22Beans , List<String> destinations) {
					if(CollectionUtils.isNotEmpty(q22Beans)) {
						List<Q22BeanModel>  q22Bean7DaysOrLessAllData = q22Beans.parallelStream().filter(q22BeanModel ->  ( destinations.contains(q22BeanModel.getDestination()))).collect(Collectors.toList());
						return q22Bean7DaysOrLessAllData.size();
					}
					 return 0;
				}
				
				public static int  getDestinationByProjectType(List<Q22BeanModel> q22Beans , List<String> destinations,String projectType) {
					if(CollectionUtils.isNotEmpty(q22Beans)) {
						List<Q22BeanModel>  q22Bean7DaysOrLessAllData = q22Beans.parallelStream().filter(q22BeanModel ->  ( destinations.contains(q22BeanModel.getDestination())) && StringUtils.equals(projectType, q22BeanModel.getProjectType()) ).collect(Collectors.toList());
						return q22Bean7DaysOrLessAllData.size();
					}
					 return 0;
				}
				
				public static int  getDestinationByProjectTypes(List<Q22BeanModel> q22Beans , List<String> destinations,List<String> projectTypes) {
					if(CollectionUtils.isNotEmpty(q22Beans)) {
						List<Q22BeanModel>  q22Bean7DaysOrLessAllData = q22Beans.parallelStream().filter(q22BeanModel ->  ( destinations.contains(q22BeanModel.getDestination())) && projectTypes.contains(q22BeanModel.getProjectType()) ).collect(Collectors.toList());
						return q22Bean7DaysOrLessAllData.size();
					}
					 return 0;
				}
				
				public static long  divide(int destination41 , int destination40,int destination42) {
					if(destination41 == 0){
						 return 0;
					}
					int subTotal = (destination40 - destination42);
					if(subTotal <= 0) {
						return 0;
					}
					long percentage = destination41/subTotal;
					return percentage;
				}
				
				
				public static int getFloatValue(ResultSet resultSet , int index) {
					try {
						Float value = (Float)resultSet.getFloat(index);
						if(value != null) {
							return value.intValue();
						}
						
					} catch (SQLException e) {
						return 0;
					}
					return 0;	
				}		
				
				public static int getFloatValue(ResultSet resultSet , String column) {
					try {
						Float value = (Float)resultSet.getFloat(column);
						if(value != null) {
							return value.intValue();
						}
						
					} catch (SQLException e) {
						return 0;
					}
					return 0;	
				}		
				
			    public static List<IncomeAndSourceModel> filterMissingIncomeAndSource(List<IncomeAndSourceModel> incomeAndSources) {
			    	List<IncomeAndSourceModel> filteredIncomeAndSource = new ArrayList<>();
			    	if(CollectionUtils.isNotEmpty(incomeAndSources)) {
			    		filteredIncomeAndSource  = incomeAndSources.parallelStream().filter(incomeAndSource -> StringUtils.equals("8", incomeAndSource.getIncomefromanysource()) || StringUtils.equals("9", incomeAndSource.getIncomefromanysource()) ||  StringUtils.equals("99", incomeAndSource.getIncomefromanysource())   || StringUtils.equals("8", incomeAndSource.getIncomefromanysource())).collect(Collectors.toList());
			    	}
			    	return filteredIncomeAndSource;
			    }
			    
			    public static List<IncomeAndSourceModel> filterIdentifiedSource(List<IncomeAndSourceModel> incomeAndSources) {
			    	List<IncomeAndSourceModel> filteredIncomeAndSource = new ArrayList<>();
			    	if(CollectionUtils.isNotEmpty(incomeAndSources)) {
			    		filteredIncomeAndSource  = incomeAndSources.parallelStream().filter(incomeAndSource -> StringUtils.equals("0", incomeAndSource.getIncomefromanysource()) 
			    				&&
			    				(isGreaterThanZero(incomeAndSource.getAlimonyamount()) ||
			    				 isGreaterThanZero(incomeAndSource.getChildsupportamount()) ||
			    				 isGreaterThanZero(incomeAndSource.getEarnedamount()) ||
			    				 isGreaterThanZero(incomeAndSource.getGaamount()) ||
			    				 isGreaterThanZero(incomeAndSource.getOthersourceamount()) ||
			    				 isGreaterThanZero(incomeAndSource.getPensionamount()) ||
			    				 isGreaterThanZero(incomeAndSource.getPrivatedisabilityamount()) ||
			    				 isGreaterThanZero(incomeAndSource.getSocsecretirementamount()) ||
			    				 isGreaterThanZero(incomeAndSource.getSsiamount()) ||
			    				 isGreaterThanZero(incomeAndSource.getTanfamount()) ||
			    				 isGreaterThanZero(incomeAndSource.getUnemploymentamount()) ||
			    				 isGreaterThanZero(incomeAndSource.getVadisabilitynonserviceamount()) ||
			    				 isGreaterThanZero(incomeAndSource.getVadisabilityserviceamount()) ||
			    				 isGreaterThanZero(incomeAndSource.getWorkerscompamount())
			    				)
			    				).collect(Collectors.toList());
			    	}
			    	return filteredIncomeAndSource;
			    }
			
			    public static List<IncomeAndSourceModel> filterUnIdentifiedSource(List<IncomeAndSourceModel> incomeAndSources) {
			    	List<IncomeAndSourceModel> filteredIncomeAndSource = new ArrayList<>();
			    	if(CollectionUtils.isNotEmpty(incomeAndSources)) {
			    		filteredIncomeAndSource  = incomeAndSources.parallelStream().filter(incomeAndSource -> StringUtils.equals("1", incomeAndSource.getIncomefromanysource()) 
			    				&&
			    				(isLessThanEqualToZero(incomeAndSource.getAlimonyamount()) &&
			    				 isLessThanEqualToZero(incomeAndSource.getChildsupportamount()) &&
			    				 isLessThanEqualToZero(incomeAndSource.getEarnedamount()) &&
			    				 isLessThanEqualToZero(incomeAndSource.getGaamount()) &&
			    				 isLessThanEqualToZero(incomeAndSource.getOthersourceamount()) &&
			    				 isLessThanEqualToZero(incomeAndSource.getPensionamount()) &&
			    				 isLessThanEqualToZero(incomeAndSource.getPrivatedisabilityamount()) &&
			    				 isLessThanEqualToZero(incomeAndSource.getSocsecretirementamount()) &&
			    				 isLessThanEqualToZero(incomeAndSource.getSsiamount()) &&
			    				 isLessThanEqualToZero(incomeAndSource.getTanfamount()) &&
			    				 isLessThanEqualToZero(incomeAndSource.getUnemploymentamount()) &&
			    				 isLessThanEqualToZero(incomeAndSource.getVadisabilitynonserviceamount()) &&
			    				 isLessThanEqualToZero(incomeAndSource.getVadisabilityserviceamount()) &&
			    				 isLessThanEqualToZero(incomeAndSource.getWorkerscompamount())
			    				)
			    				).collect(Collectors.toList());
			    	}
			    	return filteredIncomeAndSource;
			    }
			    

				public static Map<String,Integer> getIncome(List<IncomeAndSourceModel> incomeAndSources) {
					Map<String,Integer> incomes = new HashMap<>();
					if(CollectionUtils.isNotEmpty(incomeAndSources)) {
						for(IncomeAndSourceModel incomeAndSource : incomeAndSources ) {
							int totalAmount = getFloat(incomeAndSource.getTotalmonthlyincome());
							incomes.put(incomeAndSource.getDedupClientId(),totalAmount);
						}
					}
					return incomes;
				}
				
				public static int getIncomeCnt(List<IncomeAndSourceModel> incomeAndSources) {
					Map<String, Integer> income = getIncome(incomeAndSources);
					if(income != null) {
						 Collection<String> values = income.keySet();
						if(CollectionUtils.isNotEmpty(values)) {
							return values.size();
						}
							
					}
					return 0;
				}
			    
				
				public static int getIncomeCntWithIncome(List<IncomeAndSourceModel> incomeAndSources) {
					Map<String, Integer> income = getIncome(incomeAndSources);
					int count  =0;
					if(income != null) {
						 Collection<Integer> values = income.values();
						 
						if(CollectionUtils.isNotEmpty(values)) {
							for(Integer index : values ) {
								if(index != null && index.intValue() > 0) {
									count++;
								}
							}
							return count;
						}
					}
					return 0;
				}
				public static int getFloat(Float value) {
					try {
						if(value != null) {
							return value.intValue();
						}
					} catch (Exception e) {
						return 0;
					}
					return 0;	
				}
				
				public static boolean isGreaterThanZero(Float value) {
					 int intValue = getFloat(value);
					 if(intValue > 0) {
						 return true;
					 }
					 return false;
				}
				public static boolean isLessThanEqualToZero(Float value) {
					 int intValue = getFloat(value);
					 if(intValue == 0) {
						 return true;
					 }
					 return false;
				}
				
				 public static boolean isWithIn30DaysOfAnniversary(Date entryDate,Date informationDate) {
					 Calendar cal = Calendar.getInstance();
					 cal.setTime(entryDate);
					 int day = cal.get(Calendar.DAY_OF_YEAR);
					 
					 Calendar cal2 = Calendar.getInstance();
					 cal2.setTime(informationDate);
					 int day2 = cal2.get(Calendar.DAY_OF_YEAR);
					 
					 int betweenDays = day - day2;
					 
					 if(betweenDays >= -30 && betweenDays <=30){
						 return true;
					 }
					 return false;
				 }
				 
				 
					public static Q19DataBean populateEarnedIncome(List<IncomeAndSourceModel> incomeAtEntry,List<IncomeAndSourceModel> incomeAtAA,BigInteger allClientsBigInt,List<IncomeAndSourceModel> didNotHaveIncomeAtEntry,List<IncomeAndSourceModel> didNotHaveIncomeATEntryButNotAtAA) {
						Q19DataBean q19DataBean = new Q19DataBean();
						Map<String,BigInteger>  incomeMapAtEntry = new HashMap<>();
						incomeAtEntry.forEach(incomeAndSource ->  {incomeMapAtEntry.put(incomeAndSource.getDedupClientId(), BigInteger.valueOf(getFloat(incomeAndSource.getEarnedamount()))); } );
						
						Map<String,BigInteger>  incomeMapAtAA = new HashMap<>();
						incomeAtAA.forEach(incomeAndSource -> { incomeMapAtAA.put(incomeAndSource.getDedupClientId(), BigInteger.valueOf(getFloat(incomeAndSource.getEarnedamount()))); });
						
						Set<String> keySetAtEntry = incomeMapAtEntry.keySet();
						int earnedIncomeAtStartWithOutAA = 0;
						
						int retainIncomeCatLessAtAAThanAtEntry = 0;
						int retainIncomeCatSameAtAAThanAtEntry = 0;
						int retainIncomeCatGreaterAtAAThanAtEntry = 0;
						
						BigInteger incomeCatLessAtAAThanAtEntry = BigInteger.ZERO;
						BigInteger incomeCatGreaterAtAAThanAtEntry = BigInteger.ZERO;
						BigInteger incomePerformaceMeasure = BigInteger.ZERO;
						BigInteger incomeAtStartAndNotAtAA = BigInteger.ZERO;
						
						for(String key : keySetAtEntry) {
							BigInteger amountAtEntry = incomeMapAtEntry.get(key);
							BigInteger amountAtAA = incomeMapAtAA.get(key);
							// Income at start and not a AA
								if(amountAtAA == null) {
									earnedIncomeAtStartWithOutAA++;
									incomeAtStartAndNotAtAA = incomeAtStartAndNotAtAA.add(incomeMapAtEntry.get(key));
								}
								   int aa = (amountAtAA != null ? amountAtAA : BigInteger.ZERO).intValue();
								   int ea = (amountAtEntry != null ? amountAtEntry : BigInteger.ZERO).intValue();
								 // Income at Entry greater than AA
								if(ea > aa && ea !=0) {
									retainIncomeCatLessAtAAThanAtEntry++;
									incomeCatLessAtAAThanAtEntry = incomeCatGreaterAtAAThanAtEntry.add(amountAtEntry.subtract(amountAtAA != null ? amountAtAA : BigInteger.ZERO)) ;
								}
								// Income at Entry same as AA
								else if(ea==aa && ea !=0) {
									retainIncomeCatSameAtAAThanAtEntry++;
								}
								// Income at Entry less than AA
								else if(ea < aa && aa !=0) {
									incomeCatGreaterAtAAThanAtEntry = incomeCatGreaterAtAAThanAtEntry.add(amountAtAA.subtract(amountAtEntry != null ? amountAtEntry : BigInteger.ZERO )) ;
									retainIncomeCatGreaterAtAAThanAtEntry++;
								}
								
						}
						
						//#B
						if(CollectionUtils.isNotEmpty(incomeAtEntry)) {
							BigInteger average = incomeAtStartAndNotAtAA.divide(BigInteger.valueOf(earnedIncomeAtStartWithOutAA));
							average = average.multiply(BigInteger.valueOf(-1));
							q19DataBean.setAverageChangeInEarnedIncomeHadIncomeCategoryAtEntryAndNotHaveFollowup(average);
							q19DataBean.setNoOfAdltsWithEarnedIncomeHadIncomeCategoryAtEntryAndNotHaveFollowup(BigInteger.valueOf(earnedIncomeAtStartWithOutAA));
						}
						
						//#C
						q19DataBean.setNoOfAdltsWithEarnedIncomeRetainedIncomeCategoryButHadLessDollar(BigInteger.valueOf(retainIncomeCatLessAtAAThanAtEntry));
						if(retainIncomeCatLessAtAAThanAtEntry !=0) {
							BigInteger retainIncomeAtAAThenAtEntryAmount = incomeCatLessAtAAThanAtEntry.divide(BigInteger.valueOf(retainIncomeCatLessAtAAThanAtEntry));
							q19DataBean.setAverageChangeInEarnedIncomeRetainedIncomeCategoryButHadLessDollar(retainIncomeAtAAThenAtEntryAmount);
						}
						//#D
						q19DataBean.setNoOfAdltsWithEarnedIncomeRetainedIncomeCategoryAndSameDollar(BigInteger.valueOf(retainIncomeCatSameAtAAThanAtEntry));
						q19DataBean.setAverageChangeInEarnedIncomeRetainedIncomeCategoryAndSameDollar(BigInteger.ZERO);
						
						
						Set<String> keySetAtAA = incomeMapAtAA.keySet();
						int noOfAdultsDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome = 0;
						BigInteger sumadultsDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome = BigInteger.ZERO;
						for(String key : keySetAtAA) {
							BigInteger earnedAmountAtEntry = incomeMapAtEntry.get(key);
							BigInteger amountAtAA = incomeMapAtAA.get(key);
							if((earnedAmountAtEntry == null || ( earnedAmountAtEntry != null && earnedAmountAtEntry.compareTo(BigInteger.ZERO) ==0 )) && amountAtAA !=null) {
								noOfAdultsDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome ++;
								sumadultsDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome = sumadultsDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome.add(amountAtAA);
							}
						}
						Set<String> clientIdWithNoIncome = new HashSet<>();
						if(CollectionUtils.isNotEmpty(didNotHaveIncomeAtEntry)) {
							didNotHaveIncomeAtEntry.forEach(incomeSource -> clientIdWithNoIncome.add(incomeSource.getDedupClientId()));
						}
						if(CollectionUtils.isNotEmpty(didNotHaveIncomeATEntryButNotAtAA)) {
							didNotHaveIncomeATEntryButNotAtAA.forEach(incomeSource -> clientIdWithNoIncome.add(incomeSource.getDedupClientId()));
						}
						int performanceMeasure=0;
						//#F
						if(noOfAdultsDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome != 0 && sumadultsDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome != BigInteger.ZERO) {
							BigInteger average = sumadultsDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome.divide(BigInteger.valueOf(noOfAdultsDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome));
							performanceMeasure = performanceMeasure + average.intValue();
							q19DataBean.setNoOfAdltsWithEarnedIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome(BigInteger.valueOf(noOfAdultsDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome));
							q19DataBean.setAverageChangeInEarnedIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome(average);
						}
						//#G
						int clientsWithNoIncome = getSize(didNotHaveIncomeATEntryButNotAtAA);
						q19DataBean.setNoOfAdltsWithEarnedIncomeDidNotHaveTheIncomeCategoryAtEntryOrFollowup(BigInteger.valueOf(clientsWithNoIncome));
						q19DataBean.setAverageChangeInEarnedIncomeDidNotHaveTheIncomeCategoryAtEntryOrFollowup(BigInteger.ZERO);
						
						List<IncomeAndSourceModel> totalIncomeAndSource = new ArrayList<>();
						totalIncomeAndSource.addAll(incomeAtEntry);
						totalIncomeAndSource.addAll(incomeAtAA);
						Set<String>  totalAdults = new HashSet<>();
						
						if(CollectionUtils.isNotEmpty(totalIncomeAndSource)) {
							for(IncomeAndSourceModel incomeAndSource : totalIncomeAndSource ) {
								totalAdults.add(incomeAndSource.getDedupClientId());
							}
							
						}
						int totalAdultSize = getSize(totalAdults);
						
						//#H 
						if(totalAdultSize !=0) {
							q19DataBean.setNoOfAdltsWithEarnedIncomeTotalAdult(BigInteger.valueOf(totalAdultSize));
							q19DataBean.setAverageChangeInEarnedIncomeTotalAdult(BigInteger.ZERO);
						}
						
						if(retainIncomeCatGreaterAtAAThanAtEntry !=0) {
							//#E
							q19DataBean.setNoOfAdltsWithEarnedIncomeRetainedIncomeCategoryAndIncreasedDollar(BigInteger.valueOf(retainIncomeCatGreaterAtAAThanAtEntry));
							BigInteger retainIncomeCatGreater = BigInteger.valueOf(retainIncomeCatGreaterAtAAThanAtEntry);
							BigInteger earnedIncomeCatGreaterAtAAThanAtEntryAmount = incomeCatGreaterAtAAThanAtEntry.divide(retainIncomeCatGreater);
							q19DataBean.setAverageChangeInEarnedIncomeRetainedIncomeCategoryAndIncreasedDollar(earnedIncomeCatGreaterAtAAThanAtEntryAmount);
							
							//#I = E + F
							performanceMeasure = performanceMeasure + earnedIncomeCatGreaterAtAAThanAtEntryAmount.intValue();
							incomePerformaceMeasure = BigInteger.valueOf(performanceMeasure);
							
							BigInteger  earnedIncomePerformaceMeasureAverage =  incomePerformaceMeasure.divide(BigInteger.valueOf(2));
							int totalPerformaceMeasure = retainIncomeCatGreaterAtAAThanAtEntry + noOfAdultsDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome; 
							q19DataBean.setNoOfAdltsWithEarnedIncomePerformanceMeasures(BigInteger.valueOf(totalPerformaceMeasure));
							q19DataBean.setAverageChangeInEarnedIncomePerformanceMeasures(earnedIncomePerformaceMeasureAverage);
						
							//#J = I/H
							int performancePercentage = ((totalPerformaceMeasure * 100)/totalAdultSize);
							q19DataBean.setNoOfAdltsWithEarnedIncomePercent(BigInteger.valueOf(performancePercentage));
							q19DataBean.setAverageChangeInEarnedIncomePercent(BigInteger.ZERO);
					   }
						return q19DataBean;
					}
					
			
					public static Q19DataBean populateOtherIncome(List<IncomeAndSourceModel> incomeAtEntry,List<IncomeAndSourceModel> incomeAtAA,BigInteger allClientsBigInt,List<IncomeAndSourceModel> didNotHaveIncomeAtEntry,List<IncomeAndSourceModel> didNotHaveIncomeATEntryButNotAtAA) {
						Q19DataBean q19DataBean = new Q19DataBean();
						Map<String,BigInteger>  incomeMapAtEntry = new HashMap<>();
						incomeAtEntry.forEach(incomeAndSource ->  {incomeMapAtEntry.put(incomeAndSource.getDedupClientId(), BigInteger.valueOf(getFloat(incomeAndSource.getTotalmonthlyincome()) - getFloat(incomeAndSource.getEarnedamount()) )); } );
						
						Map<String,BigInteger>  incomeMapAtAA = new HashMap<>();
						incomeAtAA.forEach(incomeAndSource -> { incomeMapAtAA.put(incomeAndSource.getDedupClientId(), BigInteger.valueOf(getFloat(incomeAndSource.getTotalmonthlyincome()) - getFloat(incomeAndSource.getEarnedamount()))); });
						
						Set<String> keySetAtEntry = incomeMapAtEntry.keySet();
						int incomeAtStartWithOutAA = 0;
						
						int retainIncomeCatLessAtAAThanAtEntry = 0;
						int retainIncomeCatSameAtAAThanAtEntry = 0;
						int retainIncomeCatGreaterAtAAThanAtEntry = 0;
						
						BigInteger incomeCatLessAtAAThanAtEntry = BigInteger.ZERO;
						BigInteger incomeCatGreaterAtAAThanAtEntry = BigInteger.ZERO;
						BigInteger incomePerformaceMeasure = BigInteger.ZERO;
						BigInteger incomeAtStartAndNotAtAA = BigInteger.ZERO;
						
						for(String key : keySetAtEntry) {
							BigInteger amountAtEntry = incomeMapAtEntry.get(key);
							BigInteger amountAtAA = incomeMapAtAA.get(key);
							// Income at start and not a AA
								if(amountAtAA == null) {
									incomeAtStartWithOutAA++;
									incomeAtStartAndNotAtAA = incomeAtStartAndNotAtAA.add(incomeMapAtEntry.get(key));
								}
								   int aa = (amountAtAA != null ? amountAtAA : BigInteger.ZERO).intValue();
								   int ea = (amountAtEntry != null ? amountAtEntry : BigInteger.ZERO).intValue();
								 // Income at Entry greater than AA
								if(ea > aa && ea !=0) {
									retainIncomeCatLessAtAAThanAtEntry++;
									incomeCatLessAtAAThanAtEntry = incomeCatGreaterAtAAThanAtEntry.add(amountAtEntry.subtract(amountAtAA != null ? amountAtAA : BigInteger.ZERO)) ;
								}
								// Income at Entry same as AA
								else if(ea==aa && ea !=0) {
									retainIncomeCatSameAtAAThanAtEntry++;
								}
								// Income at Entry less than AA
								else if(ea < aa && aa !=0) {
									incomeCatGreaterAtAAThanAtEntry = incomeCatGreaterAtAAThanAtEntry.add(amountAtAA.subtract(amountAtEntry != null ? amountAtEntry : BigInteger.ZERO )) ;
									retainIncomeCatGreaterAtAAThanAtEntry++;
								}
						}
						
						//#B
						if(CollectionUtils.isNotEmpty(incomeAtEntry)) {
							BigInteger average = incomeAtStartAndNotAtAA.divide(BigInteger.valueOf(incomeAtStartWithOutAA));
							average = average.multiply(BigInteger.valueOf(-1));
							q19DataBean.setAverageChangeInOtherIncomeHadIncomeCategoryAtEntryAndNotHaveFollowup(average);
							q19DataBean.setNoOfAdultsWithOtherIncomeHadIncomeCategoryAtEntryAndNotHaveFollowup(BigInteger.valueOf(incomeAtStartWithOutAA));
						}
						
						//#C
						q19DataBean.setNoOfAdultsWithOtherIncomeRetainedIncomeCategoryButHadLessDollar(BigInteger.valueOf(retainIncomeCatLessAtAAThanAtEntry));
						if(retainIncomeCatLessAtAAThanAtEntry !=0) {
							BigInteger retainIncomeAtAAThenAtEntryAmount = incomeCatLessAtAAThanAtEntry.divide(BigInteger.valueOf(retainIncomeCatLessAtAAThanAtEntry));
							q19DataBean.setAverageChangeInOtherIncomeRetainedIncomeCategoryButHadLessDollar(retainIncomeAtAAThenAtEntryAmount);
						}
						//#D
						q19DataBean.setNoOfAdultsWithOtherIncomeRetainedIncomeCategoryAndSameDollar(BigInteger.valueOf(retainIncomeCatSameAtAAThanAtEntry));
						q19DataBean.setAverageChangeInOtherIncomeRetainedIncomeCategoryAndSameDollar(BigInteger.ZERO);
						
						
						Set<String> keySetAtAA = incomeMapAtAA.keySet();
						int noOfAdultsDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome = 0;
						BigInteger sumadultsDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome = BigInteger.ZERO;
						for(String key : keySetAtAA) {
							BigInteger earnedAmountAtEntry = incomeMapAtEntry.get(key);
							BigInteger amountAtAA = incomeMapAtAA.get(key);
							if((earnedAmountAtEntry == null || ( earnedAmountAtEntry != null && earnedAmountAtEntry.compareTo(BigInteger.ZERO) ==0 )) && amountAtAA !=null) {
								noOfAdultsDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome ++;
								sumadultsDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome = sumadultsDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome.add(amountAtAA);
							}
						}
						Set<String> clientIdWithNoIncome = new HashSet<>();
						if(CollectionUtils.isNotEmpty(didNotHaveIncomeAtEntry)) {
							didNotHaveIncomeAtEntry.forEach(incomeSource -> clientIdWithNoIncome.add(incomeSource.getDedupClientId()));
						}
						if(CollectionUtils.isNotEmpty(didNotHaveIncomeATEntryButNotAtAA)) {
							didNotHaveIncomeATEntryButNotAtAA.forEach(incomeSource -> clientIdWithNoIncome.add(incomeSource.getDedupClientId()));
						}
						int performanceMeasure=0;
						//#F
						if(noOfAdultsDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome != 0 && sumadultsDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome != BigInteger.ZERO) {
							BigInteger average = sumadultsDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome.divide(BigInteger.valueOf(noOfAdultsDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome));
							performanceMeasure = average.intValue();
							q19DataBean.setNoOfAdultsWithOtherIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome(BigInteger.valueOf(noOfAdultsDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome));
							q19DataBean.setAverageChangeInOtherIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome(average);
						}
						//#G
						int clientsWithNoIncome = getSize(didNotHaveIncomeATEntryButNotAtAA);
						q19DataBean.setNoOfAdultsWithOtherIncomeDidNotHaveTheIncomeCategoryAtEntryOrFollowup(BigInteger.valueOf(clientsWithNoIncome));
						q19DataBean.setAverageChangeInOtherIncomeDidNotHaveTheIncomeCategoryAtEntryOrFollowup(BigInteger.ZERO);
						
						List<IncomeAndSourceModel> totalIncomeAndSource = new ArrayList<>();
						totalIncomeAndSource.addAll(incomeAtEntry);
						totalIncomeAndSource.addAll(incomeAtAA);
						Set<String>  totalAdults = new HashSet<>();
						
						if(CollectionUtils.isNotEmpty(totalIncomeAndSource)) {
							for(IncomeAndSourceModel incomeAndSource : totalIncomeAndSource ) {
								totalAdults.add(incomeAndSource.getDedupClientId());
							}
							
						}
						int totalAdultSize = getSize(totalAdults);
						
						//#H 
						if(totalAdultSize !=0) {
							q19DataBean.setNoOfAdultsWithOtherIncomeTotalAdult(BigInteger.valueOf(totalAdultSize));
							q19DataBean.setAverageChangeInOtherIncomeTotalAdult(BigInteger.ZERO);
						}
						
						if(retainIncomeCatGreaterAtAAThanAtEntry !=0) {
							//#E
							q19DataBean.setNoOfAdultsWithOtherIncomeRetainedIncomeCategoryAndIncreasedDollar(BigInteger.valueOf(retainIncomeCatGreaterAtAAThanAtEntry));
							BigInteger retainIncomeCatGreater = BigInteger.valueOf(retainIncomeCatGreaterAtAAThanAtEntry);
							BigInteger incomeCatGreaterAtAAThanAtEntryAmount = incomeCatGreaterAtAAThanAtEntry.divide(retainIncomeCatGreater);
							q19DataBean.setAverageChangeInOtherIncomeRetainedIncomeCategoryAndIncreasedDollar(incomeCatGreaterAtAAThanAtEntryAmount);
							
							//#I = E + F
							performanceMeasure = performanceMeasure + incomeCatGreaterAtAAThanAtEntryAmount.intValue();
							incomePerformaceMeasure = BigInteger.valueOf(performanceMeasure);
							BigInteger  incomePerformaceMeasureAverage =  incomePerformaceMeasure.divide(BigInteger.valueOf(2));
							
							int totalPerformaceMeasure = retainIncomeCatGreaterAtAAThanAtEntry + noOfAdultsDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome; 
							q19DataBean.setNoOfAdultsWithOtherIncomePerformanceMeasures(BigInteger.valueOf(totalPerformaceMeasure));
							q19DataBean.setAverageChangeInOtherIncomePerformanceMeasures(incomePerformaceMeasureAverage);
						
							//#J = I/H
							int performancePercentage = ((totalPerformaceMeasure * 100)/totalAdultSize);
							q19DataBean.setNoOfAdultsWithOtherIncomePercent(BigInteger.valueOf(performancePercentage));
							q19DataBean.setAverageChangeInOtherIncomePercent(BigInteger.ZERO);
					   }
						return q19DataBean;
					}

				
				public static Q19DataBean populateOverallIncomeIncome(List<IncomeAndSourceModel> incomeAtEntry,List<IncomeAndSourceModel> incomeAtAA,BigInteger allClientsBigInt,List<IncomeAndSourceModel> didNotHaveIncomeAtEntry,List<IncomeAndSourceModel> didNotHaveIncomeATEntryButNotAtAA) {
					Q19DataBean q19DataBean = new Q19DataBean();
					Map<String,BigInteger>  incomeMapAtEntry = new HashMap<>();
					incomeAtEntry.forEach(incomeAndSource ->  {incomeMapAtEntry.put(incomeAndSource.getDedupClientId(), BigInteger.valueOf(getFloat(incomeAndSource.getTotalmonthlyincome()))); } );
					
					Map<String,BigInteger>  incomeMapAtAA = new HashMap<>();
					incomeAtAA.forEach(incomeAndSource -> { incomeMapAtAA.put(incomeAndSource.getDedupClientId(), BigInteger.valueOf(getFloat(incomeAndSource.getTotalmonthlyincome()))); });
					
					Set<String> keySetAtEntry = incomeMapAtEntry.keySet();
					int incomeAtStartWithOutAA = 0;
					
					int retainIncomeCatLessAtAAThanAtEntry = 0;
					int retainIncomeCatSameAtAAThanAtEntry = 0;
					int retainIncomeCatGreaterAtAAThanAtEntry = 0;
					
					BigInteger incomeCatLessAtAAThanAtEntry = BigInteger.ZERO;
					BigInteger incomeCatGreaterAtAAThanAtEntry = BigInteger.ZERO;
					BigInteger incomePerformaceMeasure = BigInteger.ZERO;
					BigInteger incomeAtStartAndNotAtAA = BigInteger.ZERO;
					
					for(String key : keySetAtEntry) {
						BigInteger amountAtEntry = incomeMapAtEntry.get(key);
						BigInteger amountAtAA = incomeMapAtAA.get(key);
						// Income at start and not a AA
							if(amountAtAA == null) {
								incomeAtStartWithOutAA++;
								incomeAtStartAndNotAtAA = incomeAtStartAndNotAtAA.add(incomeMapAtEntry.get(key));
							}
							   int aa = (amountAtAA != null ? amountAtAA : BigInteger.ZERO).intValue();
							   int ea = (amountAtEntry != null ? amountAtEntry : BigInteger.ZERO).intValue();
							 // Income at Entry greater than AA
							if(ea > aa && ea !=0) {
								retainIncomeCatLessAtAAThanAtEntry++;
								incomeCatLessAtAAThanAtEntry = incomeCatGreaterAtAAThanAtEntry.add(amountAtEntry.subtract(amountAtAA != null ? amountAtAA : BigInteger.ZERO)) ;
							}
							// Income at Entry same as AA
							else if(ea==aa && ea !=0) {
								retainIncomeCatSameAtAAThanAtEntry++;
							}
							// Income at Entry less than AA
							else if(ea < aa && aa !=0) {
								incomeCatGreaterAtAAThanAtEntry = incomeCatGreaterAtAAThanAtEntry.add(amountAtAA.subtract(amountAtEntry != null ? amountAtEntry : BigInteger.ZERO )) ;
								retainIncomeCatGreaterAtAAThanAtEntry++;
							}
					}
					
					//#B
					if(CollectionUtils.isNotEmpty(incomeAtEntry)) {
						BigInteger average = incomeAtStartAndNotAtAA.divide(BigInteger.valueOf(incomeAtStartWithOutAA));
						average = average.multiply(BigInteger.valueOf(-1));
						q19DataBean.setAverageChangeInOverallIncomeHadIncomeCategoryAtEntryAndNotHaveFollowup(average);
						q19DataBean.setNumberOfAdultsWithAnyIncomeHadIncomeCategoryAtEntryAndNotHaveFollowup(BigInteger.valueOf(incomeAtStartWithOutAA));
					}
					
					//#C
					q19DataBean.setNumberOfAdultsWithAnyIncomeRetainedIncomeCategoryButHadLessDollar(BigInteger.valueOf(retainIncomeCatLessAtAAThanAtEntry));
					if(retainIncomeCatLessAtAAThanAtEntry !=0) {
						BigInteger retainIncomeAtAAThenAtEntryAmount = incomeCatLessAtAAThanAtEntry.divide(BigInteger.valueOf(retainIncomeCatLessAtAAThanAtEntry));
						q19DataBean.setAverageChangeInOverallIncomeRetainedIncomeCategoryButHadLessDollar(retainIncomeAtAAThenAtEntryAmount);
					}
					//#D
					q19DataBean.setNumberOfAdultsWithAnyIncomeRetainedIncomeCategoryAndSameDollar(BigInteger.valueOf(retainIncomeCatSameAtAAThanAtEntry));
					q19DataBean.setAverageChangeInOverallIncomeRetainedIncomeCategoryAndSameDollar(BigInteger.ZERO);
					
					
					Set<String> keySetAtAA = incomeMapAtAA.keySet();
					int noOfAdultsDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome = 0;
					BigInteger sumadultsDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome = BigInteger.ZERO;
					for(String key : keySetAtAA) {
						BigInteger earnedAmountAtEntry = incomeMapAtEntry.get(key);
						BigInteger amountAtAA = incomeMapAtAA.get(key);
						if((earnedAmountAtEntry == null || ( earnedAmountAtEntry != null && earnedAmountAtEntry.compareTo(BigInteger.ZERO) ==0 )) && amountAtAA !=null) {
							noOfAdultsDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome ++;
							sumadultsDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome = sumadultsDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome.add(amountAtAA);
						}
					}
					Set<String> clientIdWithNoIncome = new HashSet<>();
					if(CollectionUtils.isNotEmpty(didNotHaveIncomeAtEntry)) {
						didNotHaveIncomeAtEntry.forEach(incomeSource -> clientIdWithNoIncome.add(incomeSource.getDedupClientId()));
					}
					if(CollectionUtils.isNotEmpty(didNotHaveIncomeATEntryButNotAtAA)) {
						didNotHaveIncomeATEntryButNotAtAA.forEach(incomeSource -> clientIdWithNoIncome.add(incomeSource.getDedupClientId()));
					}
					int performanceMeasure = 0;
					//#F
					if(noOfAdultsDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome != 0 && sumadultsDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome != BigInteger.ZERO) {
						BigInteger average = sumadultsDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome.divide(BigInteger.valueOf(noOfAdultsDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome));
						performanceMeasure = average.intValue();
						q19DataBean.setNumberOfAdultsWithAnyIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome(BigInteger.valueOf(noOfAdultsDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome));
						q19DataBean.setAverageChangeInOverallIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome(average);
					}
					//#G
					int clientsWithNoIncome = getSize(didNotHaveIncomeATEntryButNotAtAA);
					q19DataBean.setNumberOfAdultsWithAnyIncomeDidNotHaveTheIncomeCategoryAtEntryOrFollowup(BigInteger.valueOf(clientsWithNoIncome));
					q19DataBean.setAverageChangeInOverallIncomeDidNotHaveTheIncomeCategoryAtEntryOrFollowup(BigInteger.ZERO);
					
					List<IncomeAndSourceModel> totalIncomeAndSource = new ArrayList<>();
					totalIncomeAndSource.addAll(incomeAtEntry);
					totalIncomeAndSource.addAll(incomeAtAA);
					Set<String>  totalAdults = new HashSet<>();
					
					if(CollectionUtils.isNotEmpty(totalIncomeAndSource)) {
						for(IncomeAndSourceModel incomeAndSource : totalIncomeAndSource ) {
							totalAdults.add(incomeAndSource.getDedupClientId());
						}
						
					}
					int totalAdultSize = getSize(totalAdults);
					
					//#H 
					if(totalAdultSize !=0) {
						q19DataBean.setNumberOfAdultsWithAnyIncomeTotalAdult(BigInteger.valueOf(totalAdultSize));
						q19DataBean.setAverageChangeInOverallIncomeTotalAdult(BigInteger.ZERO);
					}
					
					if(retainIncomeCatGreaterAtAAThanAtEntry !=0) {
						//#E
						q19DataBean.setNumberOfAdultsWithAnyIncomeRetainedIncomeCategoryAndIncreasedDollar(BigInteger.valueOf(retainIncomeCatGreaterAtAAThanAtEntry));
						BigInteger retainIncomeCatGreater = BigInteger.valueOf(retainIncomeCatGreaterAtAAThanAtEntry);
						BigInteger incomeCatGreaterAtAAThanAtEntryAmount = incomeCatGreaterAtAAThanAtEntry.divide(retainIncomeCatGreater);
						q19DataBean.setAverageChangeInOverallIncomeRetainedIncomeCategoryAndIncreasedDollar(incomeCatGreaterAtAAThanAtEntryAmount);
						
						//#I = E + F
						performanceMeasure = performanceMeasure + incomeCatGreaterAtAAThanAtEntryAmount.intValue();
						incomePerformaceMeasure = BigInteger.valueOf(performanceMeasure);
						BigInteger  incomePerformaceMeasureAverage =  incomePerformaceMeasure.divide(BigInteger.valueOf(2));
						int totalPerformaceMeasure = retainIncomeCatGreaterAtAAThanAtEntry + noOfAdultsDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome; 
						q19DataBean.setNumberOfAdultsWithAnyIncomePerformanceMeasures(BigInteger.valueOf(totalPerformaceMeasure));
						q19DataBean.setAverageChangeInOverallIncomePerformanceMeasures(incomePerformaceMeasureAverage);
					
						//#J = I/H
						if(totalPerformaceMeasure !=0 && totalAdultSize !=0) {
							int finalPercent = ((totalPerformaceMeasure * 100)/totalAdultSize);
							q19DataBean.setNumberOfAdultsWithAnyIncomePercent(BigInteger.valueOf(finalPercent));
							q19DataBean.setAverageChangeInOverallIncomePercent(BigInteger.ZERO);
						}
						
				   }
					return q19DataBean;
				}
}

