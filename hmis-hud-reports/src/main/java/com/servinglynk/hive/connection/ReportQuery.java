package com.servinglynk.hive.connection;

public class ReportQuery {
public static String GET_PROJECT_BY_ID= "select * from %s.project where id = ? ";
public static String GET_ORG_BY_ID= "select * from %s.organization where id = ?";
public static String GET_ALL_CLIENTS = "select * from %s.client";
public static String GET_ALL_CONTACTS = "select * from %s.contact";
public static String GET_DOMESTIC_VIOLENCE_BY_VICTIM = "select enrollmentid from %s.domesticviolence where domesticviolencevictim = ?";
public static String GET_DOMESTIC_VIOLENCE_BY_VICTIM_DK = "select enrollmentid from %s.domesticviolence where domesticviolencevictim in ('8','9') ";
public static String GET_ALL_DOE = "select * from %s.dateofengagement";
public static String GET_ALL_ENROLLMENTS = "select * from %s.enrollment";
public static String GET_ALL_EXITS = "select * from %s.exit";
public static String GET_PROJECTS_BY_COC = "select * from %s.project where id in (select projectid from %s.coc where coc_id = ? )";
public static String GET_PROJECTS = "select * from %s.project where id in (";
public static String GET_ENROLLMENTS_BY_COC_ID = "select * from %s.enrollment where projectid in (select projectid from %s.coc where id = ? )";
public static String GET_ENROLLMENTS_PROJECT_ID = "select * from %s.enrollment where projectid in (";
public static String GET_INCOMEANDSOURCE = "select * from %s.incomeandsources";
public static String NAME_DATE_QUALITY_DNE_REFUSED ="select count(*) %s.from client where name_data_quality in ('8','9')";
public static String NAME_DATE_QUALITY_DNC ="select count(*) from %s.client where name_data_quality in ('99')";
public static String SSN_DATE_QUALITY_DNE_REFUSED ="select count(*) from %s.client where ssn_data_quality in ('8','9')";
public static String SSN_DATE_QUALITY_DNC ="select count(*) from %s.client where ssn_data_quality in ('99')";
public static String PROJECT_WITH_HOUSEHOLD_WITHOUT_CHILDREN ="select projectid,householdtype from %s.inventory where 	householdtype='1'";
public static String PROJECT_WITH_HOUSEHOLD_WITH_ONE_ADULT_CHILD ="select projectid,householdtype from %s.inventory where 	householdtype='3'";
public static String PROJECT_WITH_HOUSEHOLD_ONLY_CHILDREN ="select projectid,householdtype from %s.inventory where 	householdtype='4'";
public static String PROJECT_WITH_HOUSEHOLD_TYPE_UNKNOWN ="select projectid,householdtype from %s.inventory where 	householdtype is null";
public static String REQUIRED_ANNUAL_ASSESMENT_QUERY= "select  alimonyamount,childsupportamount,earnedamount,gaamount,othersourceamount,pensionamount,privatedisabilityamount, "+
		 " socsecretirementamount,ssiamount,tanfamount,totalmonthlyincome,unemploymentamount,vadisabilitynonserviceamount,  "+
		 " vadisabilityserviceamount,workerscompamount,e.dedup_client_id from incomeandsources i, enrollment e where e.id=i.enrollmentid  "+
		 "  and i.information_date >= e.entrydate and e.entrydate <= ?   and e.ageatentry >=18 "+
		 " and   e.id not in ( select enrollmentid from exit  where  exitdate >= ? )  "+
		 " and   e.id not in ( select enrollmentid from enrollment_coc where datacollectionstage='5' and datediff(now(),information_date) < 365 )  ";
      
}
