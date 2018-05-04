package com.servinglynk.report.business;

import static java.time.temporal.TemporalAdjusters.lastDayOfMonth;
import static java.time.temporal.TemporalAdjusters.previousOrSame;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.servinglynk.hive.connection.ImpalaConnection;
import com.servinglynk.hive.connection.ReportQuery;
import com.servinglynk.report.bean.HomePageDataBean;
import com.servinglynk.report.model.ClientModel;
import com.servinglynk.report.model.ContactModel;
import com.servinglynk.report.model.DateOfEngagementModel;
import com.servinglynk.report.model.EnrollmentModel;
import com.servinglynk.report.model.ExitModel;
import com.servinglynk.report.model.IncomeAndSourceModel;
import com.servinglynk.report.model.ProjectModel;

public class BaseBeanMaker {
	
	protected static Date chCutoffDate = new Date(2016, 10, 1);

	public static boolean isChild(Date dob) {
		try {
			LocalDate currentDate = LocalDate.now();
			if(dob !=null) {
				@SuppressWarnings("deprecation")
				LocalDate dateOfBirth = LocalDate.of(dob.getYear(), dob.getMonth(), dob.getDay());
				Period p = Period.between(dateOfBirth, currentDate);
				if(p.getYears() < 18 )
					return true;
				else 
					return false;
			}
			return false;
		}catch(Exception e) {
			return false;
		}
		
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
			 ContactModel model = new ContactModel(resultSet.getString("contact_id"), resultSet.getString("project_entry_id"), resultSet.getDate("contact_date"), resultSet.getString("contact_location"), resultSet.getString("source_system_id"));
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
			 DateOfEngagementModel model = new DateOfEngagementModel(resultSet.getString("dateofengagement_id"),resultSet.getString("project_entry_id"), resultSet.getDate("dateofengagement"), resultSet.getString("source_system_id"));
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
			 ClientModel model = new ClientModel(resultSet.getString("personalid"), resultSet.getString("dedup_client_id"), 
					 resultSet.getString("name_data_quality"),resultSet.getString("name_data_quality_desc"), 
					 resultSet.getString("ssn_data_quality"), resultSet.getString("ssn_data_quality_desc"), 
					 null,resultSet.getString("dob_data_quality"), 
					 resultSet.getString("dob_data_quality_desc"), resultSet.getString("gender"), 
					 resultSet.getString("gender_desc"), resultSet.getString("other_gender"), resultSet.getString("ethnicity"), 
					 resultSet.getString("ethnicity_desc"), resultSet.getString("race"), resultSet.getString("race_desc"), 
					 resultSet.getString("veteran_status"), resultSet.getString("source_system_id"));
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
	
	
	public static boolean isAdult(Date dob) {
		try {
			LocalDate currentDate = LocalDate.now();
			if(dob !=null) {
				@SuppressWarnings("deprecation")
				LocalDate dateOfBirth = LocalDate.of(dob.getYear(), dob.getMonth(), dob.getDay());
				Period p = Period.between(dateOfBirth, currentDate);
				if(p.getYears() >= 18 )
					return true;
				else 
					return false;
			}
			return false;
		}catch(Exception e) {
			return false;
		}
	
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
				 IncomeAndSourceModel model = new IncomeAndSourceModel( resultSet.getString("incomeandsources.datacollectionstage"),resultSet.getString("incomeandsources.project_entry_id"));
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
		public static List<EnrollmentModel> getEnrollmentsByCocId(String schema,String  cocId,Date reportStartDate, Date reportEndDate) {
			ResultSet resultSet = null;
			PreparedStatement statement = null;
			Connection connection = null;
			List<EnrollmentModel>  models = new ArrayList<EnrollmentModel>();
			try {
				connection = ImpalaConnection.getConnection();
				statement = connection.prepareStatement(String.format(ReportQuery.GET_ENROLLMENTS_BY_COC_ID,schema));
				statement.setString(1, cocId);
				resultSet = statement.executeQuery();
			 while(resultSet.next()) {
				 EnrollmentModel model = new EnrollmentModel(resultSet.getString("project_entry_id"), 
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
						 resultSet.getString("otherresidenceprior"), 
						 resultSet.getString("project_id"), 
						 resultSet.getString("relationshiptohoh"), 
						 resultSet.getString("relationshiptohoh_desc"), 
						 resultSet.getString("residenceprior"), 
						 resultSet.getString("residenceprior_desc"), 
						 resultSet.getString("residencepriorlengthofstay"), 
						 resultSet.getString("residencepriorlengthofstay_desc"), 
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
						 resultSet.getDate("datetostreetessh"));
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
				statement = connection.prepareStatement(String.format(ReportQuery.GET_PROJECTS_BY_COC,schema));
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
				 ExitModel model = new ExitModel( resultSet.getString("exit.exit_id"), resultSet.getString("exit.destination"), 
						 resultSet.getString("destination_desc"), 
						 resultSet.getDate("exitdate"), 
						 resultSet.getString("otherdestination"), 
						 resultSet.getString("project_entry_id"), resultSet.getString("exit.source_system_id"), resultSet.getDate("exit.date_created_from_source"));
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
