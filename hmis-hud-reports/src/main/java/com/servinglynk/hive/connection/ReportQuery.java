package com.servinglynk.hive.connection;

public class ReportQuery {
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
