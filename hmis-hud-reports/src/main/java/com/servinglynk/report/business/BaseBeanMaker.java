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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.servinglynk.hive.connection.ImpalaConnection;
import com.servinglynk.hive.connection.ReportQuery;
import com.servinglynk.report.bean.HomePageDataBean;
import com.servinglynk.report.bean.ReportData;
import com.servinglynk.report.model.ClientModel;
import com.servinglynk.report.model.ContactModel;
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
		 long between = ChronoUnit.DAYS.between(LocalDate.parse(from.toString()),LocalDate.parse(to.toString()));
		 return between;
	 }
	
	protected static String formatQuery(String query, String schema,ReportData data) {
		if(StringUtils.isNotBlank(query)) {
			query = query.replaceAll(":datacollectionstage", "'"+ data.getQueryDataCollectionStage()+"'");
			query = query.replaceAll(":startDate", "'"+ data.getReportStartDate()+"'");
			query = query.replaceAll(":endDate", "'"+ data.getReportEndDate()+"'");
			query = query.replaceAll(":dedupClientId", data.getQueryDedupClientId());
			return query.replaceAll("%s", schema);
		}
		return null;
	}
	
	public static int getSize(List list) {
		if(CollectionUtils.isNotEmpty(list)) {
			return list.size();
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
	 public static LocalDate lasWednesayOf(int year,int month) {
		 return LocalDate.of(year, month, 1).with(lastDayOfMonth()).with(previousOrSame(DayOfWeek.WEDNESDAY));
	  }
	
	public static List<String> getProjectsForHouseHoldType(String schema,String query) {
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
	
	public static List<String> getEnrollmentFromDisabilities(String schema,ReportData data,String query) {
		ResultSet resultSet = null;
		Statement statement = null;
		Connection connection = null;
		List<String>  models = new ArrayList<String>();
		try {
			connection = ImpalaConnection.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(formatQuery(query, schema, data));
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
			resultSet = statement.executeQuery(formatQuery(query, schema, data));
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
			resultSet = statement.executeQuery(formatQuery(query,schema,data));
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
	public static List<String> getEnrollmentFromDisabilitiesWithInformationDate(String schema,ReportData data,String query) {
		ResultSet resultSet = null;
		Statement statement = null;
		Connection connection = null;
		List<String>  models = new ArrayList<String>();
		try {
			connection = ImpalaConnection.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(formatQuery(query,schema,data));
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
	
	public static List<String> getDomesticViolenceByVictim(final String schema,final String victim) {
		ResultSet resultSet = null;
		PreparedStatement statement = null;
		Connection connection = null;
		List<String>  models = new ArrayList<String>();
		try {
			connection = ImpalaConnection.getConnection();
			statement = connection.prepareStatement(String.format(ReportQuery.GET_DOMESTIC_VIOLENCE_BY_VICTIM,schema));
			statement.setString(1, victim);
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
	
	public static List<String> getDomesticViolenceByVictimDK(final String schema) {
		ResultSet resultSet = null;
		PreparedStatement statement = null;
		Connection connection = null;
		List<String>  models = new ArrayList<String>();
		try {
			connection = ImpalaConnection.getConnection();
			statement = connection.prepareStatement(String.format(ReportQuery.GET_DOMESTIC_VIOLENCE_BY_VICTIM_DK,schema));
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
	public static List<ClientModel> getClients(String schema) {
		ResultSet resultSet = null;
		PreparedStatement statement = null;
		Connection connection = null;
		List<ClientModel>  models = new ArrayList<ClientModel>();
		try {
			connection = ImpalaConnection.getConnection();
			statement = connection.prepareStatement(String.format(ReportQuery.GET_ALL_CLIENTS,schema));
			resultSet = statement.executeQuery();
		 while(resultSet.next()) {
			 ClientModel model = new ClientModel(resultSet.getString("id"), resultSet.getString("dedup_client_id"), 
					 resultSet.getString("name_data_quality"),resultSet.getString("name_data_quality_desc"), 
					 resultSet.getString("ssn_data_quality"), resultSet.getString("ssn_data_quality_desc"), 
					 null,resultSet.getString("dob_data_quality"), 
					 resultSet.getString("dob_data_quality_desc"), resultSet.getString("gender"), 
					 resultSet.getString("gender_desc"), null, resultSet.getString("ethnicity"), 
					 resultSet.getString("ethnicity_desc"), resultSet.getString("race"), resultSet.getString("race_desc"), 
					 resultSet.getString("veteran_status"), resultSet.getString("source_system_id"),resultSet.getInt("age"));
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
				LocalDate entryLocalDate = LocalDate.of(entryDate.getYear(), entryDate.getMonth(), entryDate.getDay());
				
				Period p = Period.between(entryLocalDate, currentDate);
				if(p.getDays() > 365 )
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

		public static List<IncomeAndSourceModel> getIncomeAndSource(String schema) {
			ResultSet resultSet = null;
			PreparedStatement statement = null;
			Connection connection = null;
			List<IncomeAndSourceModel>  models = new ArrayList<IncomeAndSourceModel>();
			try {
				connection = ImpalaConnection.getConnection();
				statement = connection.prepareStatement(String.format(ReportQuery.GET_INCOMEANDSOURCE,schema));
				resultSet = statement.executeQuery();
			 while(resultSet.next()) {
				 IncomeAndSourceModel model = new IncomeAndSourceModel( resultSet.getString("datacollectionstage"),resultSet.getString("enrollmentid"));
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
		public static List<EnrollmentModel> getEnrollmentsByCocId(String schema,String  cocId,java.util.Date reportStartDate, java.util.Date reportEndDate) {
			ResultSet resultSet = null;
			PreparedStatement statement = null;
			Connection connection = null;
			List<EnrollmentModel>  models = new ArrayList<EnrollmentModel>();
			try {
				connection = ImpalaConnection.getConnection();
				statement = connection.prepareStatement(String.format(ReportQuery.GET_ENROLLMENTS_BY_COC_ID,schema,schema));
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

		public static List<EnrollmentModel> getEnrollmentsByProjectcId(String schema,List<String>  projects,java.util.Date reportStartDate, java.util.Date reportEndDate) {
			ResultSet resultSet = null;
			Statement statement = null;
			Connection connection = null;
			List<EnrollmentModel>  models = new ArrayList<EnrollmentModel>();
			try {
				connection = ImpalaConnection.getConnection();
				statement = connection.createStatement();
				String query = String.format(ReportQuery.GET_ENROLLMENTS_PROJECT_ID,schema);
				StringBuilder builder = new StringBuilder(query);
				int i=1;
				for(String project : projects) {
					builder.append("\""+ project +"\"");
					if(i != projects.size()) {
						builder.append(",");
					}
					i++;
				}
				builder.append(") order by dedup_client_id");
				resultSet = statement.executeQuery(builder.toString());
				String prevDedupClientId = "";
			 while(resultSet.next()) {
				 String dedupClientId = resultSet.getString("dedup_client_id");
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
								 convertStringBoolean(resultSet.getString("chronichomeless")), 
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
		
		public static List<ExitModel> getAllExits(String schema) {
			ResultSet resultSet = null;
			PreparedStatement statement = null;
			Connection connection = null;
			List<ExitModel>  models = new ArrayList<ExitModel>();
			try {
				connection = ImpalaConnection.getConnection();
				statement = connection.prepareStatement(String.format(ReportQuery.GET_ALL_EXITS,schema));
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
					
					resultSet = statement.executeQuery(formatQuery(query,data.getSchema(), data));
					
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
					resultSet = statement.executeQuery(formatQuery(query,data.getSchema(),data));
					
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
					   model.setNumberOfDays(subtractDate(getMinimumDate(model.getExitdate(),reportEndDate),getMaximumDate(model.getEntrydate(), reportStartDate)));
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
					model.setNumberOfDays(subtractDate(getMinimumDate(model.getExitdate(),reportEndDate),getMaximumDate(model.getMoveInDate(), reportStartDate)));
				}
				
			}
			
			public static Date addDays(Date date, int days) {
		        Calendar c = Calendar.getInstance();
		        c.setTime(date);
		        c.add(Calendar.DATE, days);
		        return new Date(c.getTimeInMillis());
		    }
			 public static Date getMinimumDate(Date date1, Date date2) {
				 if(date1.before(date1)) {
					 return addDays(date1,1);
				 }
				return addDays(date2,1);
			}
			 
			 public static Date getMaximumDate(Date date1, Date date2) {
				 if(date1.after(date1)) {
					 return date1;
				 }
				return date2;
			}
			 
				
			    public static long getBedNights(String query, ReportData data, String dedupClientId) {
			    	long bedNights = 0;
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
						 builder.deleteCharAt(builder.length() -1);
						 builder.append(" ) ");
						String newQuery = query;
						 if(CollectionUtils.isNotEmpty(projectIds)) {
							 newQuery = query.replace("%p", builder.toString());
						 }else {
							 newQuery = query.replace("%p", " ");
						 }
						statement = connection.createStatement();
						data.setQueryDedupClientId(dedupClientId);
					
						resultSet = statement.executeQuery(formatQuery(newQuery,data.getSchema(),data));
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
							
							statement = connection.createStatement();
							resultSet = statement.executeQuery(formatQuery(newQuery,data.getSchema(),data));
							
						 while(resultSet.next()) {
							 Date entryDate = resultSet.getDate("entrydate");
							 Date moveinDate = resultSet.getDate("moveindate");
							 
							 Q22BeanModel bean = new Q22BeanModel(resultSet.getString("dedup_client_id"), null,null, 
									 null,resultSet.getDate("exitdate"),entryDate,moveinDate,null);
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
							statement = connection.createStatement();
//							if(StringUtils.equals("LEAVERS", reportType) ) {
//								statement.setDate(1, data.getReportStartDate());
//								statement.setDate(2, data.getReportEndDate());
//							}else if(StringUtils.equals("STAYERS", reportType) ) {
//								statement.setDate(1, data.getReportEndDate());
//								statement.setDate(2, data.getReportEndDate());
//							}
							resultSet = statement.executeQuery(formatQuery(newQuery,data.getSchema(),data));
							
						 while(resultSet.next()) {
							 q22Beans.add(new Q22BeanModel(resultSet.getString("dedup_client_id"), resultSet.getString("projecttype"), resultSet.getString("trackingmethod"), 
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
							 if(CollectionUtils.isNotEmpty(filteredProjectIds)) {
								 newQuery = query.replace("%p", builder.toString());
							 }else {
								 newQuery = query.replace("%p", " ");
							 }
							statement = connection.createStatement();
							resultSet = statement.executeQuery(formatQuery(newQuery,data.getSchema(),data));
							
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
}

