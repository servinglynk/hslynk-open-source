package com.servinglynk.hive.connection;

public class ViewQuery {
public static String GET_DISTINCT_SURVEY=	"select distinct(survey_id) from survey.response where submission_id is not null and client_id is not null";
public static String GET_DISTINCT_QUESTIONS_FOR_SURVEY =	"select distinct(question_id) from survey.response where survey_id = ?";
public static String GET_CLIENTS_WITH_RESPONSE =	"select submission_id,client_id,question_id,response_text from survey.response where submission_id is not null and client_id is not null and survey_id=? group by client_id,submission_id,question_id,response_text order by client_id,submission_id";
public static String GET_SURVEY_BY_ID =	"select survey_title,project_group_code,created_at from survey.survey where id = ?";

public static String GET_PROJECT_BY_ID= "select * from project where projectid = ? ";
public static String GET_ORG_BY_ID= "select * from organization where organizationid = ?";
public static String GET_ALL_CLIENTS = "select * from client";
public static String GET_ALL_ENROLLMENTS = "select * from enrollment";
public static String GET_ALL_EXITS = "select * from exit";
public static String GET_ENROLLMENTS_BY_PROJECT_ID = "select * from enrollment where projectid= ?";
public static String NAME_DATE_QUALITY_DNE_REFUSED ="select count(*) from client where name_data_quality in ('8','9')";
public static String NAME_DATE_QUALITY_DNC ="select count(*) from client where name_data_quality in ('99')";
public static String SSN_DATE_QUALITY_DNE_REFUSED ="select count(*) from client where ssn_data_quality in ('8','9')";
public static String SSN_DATE_QUALITY_DNC ="select count(*) from client where ssn_data_quality in ('99')";

}
