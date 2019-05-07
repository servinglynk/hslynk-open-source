package com.servinglynk.hmis.warehouse;

public class ViewQuery {
public static String GET_DISTINCT_SURVEY=	"select distinct(survey_id) from survey.response where submission_id is not null and client_id is not null and project_group_code not in ('TE0008','MO0006','TE0011','JP0005','FI0009','BA0007','PG0001','TE0003','CP0004')";
public static String GET_DISPLAY_TEXT_FROM_QUESTION =	"select display_text from survey.question where id= ?";
public static String GET_DISTINCT_QUESTIONS_FOR_SURVEY =	"select distinct(question_id) from survey.response where survey_id = ? and deleted=false";
public static String GET_DISTICNT_CLIENT_FOR_SURVEY = "select distinct(client_id) from survey.response where survey_id = ?";
public static String GET_CLIENTS_WITH_RESPONSE = "select submission_id,client_id,question_id,response_text,created_at,deleted  from survey.response where submission_id is not null and client_id is not null and survey_id=? and project_group_code=? order by submission_id";

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

public static String HOUSING_INVENTORY_ACTIVE_LIST = "select survey_score as score, client_id, survey_date, ignore_match_process from housing_inventory.eligible_clients where project_group_code=? and deleted=false  order by date_created desc";
public static String GET_LASTEST_SURVEY_BY_CLIENT="select r.survey_id,r.created_at as created_at,s.survey_title as survey_title from survey.response r,survey.survey s where client_id=? and s.project_group_code=? and s.id= r.survey_id order by created_at desc limit 1";
public static String GET_LASTEST_SURVEY_BY_CLIENT_FROM_SCORE ="select survey_id,ss.created_at as created_at,s.survey_title as survey_title  from survey.section_score ss,survey.survey s where client_id=? and s.project_group_code=? and ss.survey_id=s.id order by created_at desc limit 1";
public static String GET_ACTIVE_LIST_DATA = "select sum(section_score)as score,ss.survey_id,ss.client_id,ss.created_at from survey.section_score ss,survey.survey s where  ss.survey_id= s.id  and s.project_group_code=? group by ss.survey_id,ss.client_id,ss.created_at order by ss.created_at desc";
public static String GET_CLIENT_BY_ID="select first_name,last_name,phone_number,email_address,convert_from(dob_decrypt(dob),'UTF-8') as dob from base.client where id = ?";
public static String GET_NOTES ="select response_text from survey.response where question_id  in( select id from survey.question where lower(question_description) like '%note%') and client_id= ?";
}
