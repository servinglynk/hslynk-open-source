package com.servinglynk.hive.connection;

public class ReportQuery {
public static String GET_PROJECT_BY_ID= "select * from %s.project where id = ? ";
public static String GET_ORG_BY_ID= "select * from %s.organization where id = ?";
public static String GET_ALL_CLIENTS = " select distinct(c.dedup_client_id) as dedup_client_id, c.id,name_data_quality,name_data_quality_desc,ssn_data_quality,ssn_data_quality_desc,dob_data_quality, "+
					  " dob_data_quality_desc,gender,gender_desc,ethnicity,ethnicity_desc,race,race_desc,veteran_status,c.source_system_id,c.age "+
					 " from %s.client c,%s.enrollment e, %s.project p,%s.exit ext where e.client_id=c.id and e.projectid= p.id  %p and entrydate <= :endDate  "+
				      " and e.id not in ( select enrollmentid from %s.exit ext where  ext.exitdate is null  or  ext.exitdate <= :startDate ) "+
					 "   order by c.dedup_client_id";
public static String GET_ALL_CONTACTS = "select * from %s.contact";
public static String GET_ALL_CONTACTS_FROM_SERVICE = "select * from %s.service_fa_referral where record_type='12' ";
public static String GET_DOMESTIC_VIOLENCE_BY_VICTIM = "select distinct(e.dedup_client_id) as dedup_client_id from %s.domesticviolence d,%s.enrollment e where e.id =d.enrollmentid and domesticviolencevictim = ";
public static String GET_DOMESTIC_VIOLENCE_BY_VICTIM_DK = "select e.id as enrollmentid  from  %s.domesticviolence d,%s.enrollment e where e.id =d.enrollmentid and domesticviolencevictim in ('8','9') ";
public static String GET_ALL_DOE = "select * from %s.dateofengagement";
public static String GET_ALL_ENROLLMENTS = "select e.* from %s.client c,%s.enrollment e, %s.project p,%s.exit ext where e.client_id=c.id and e.projectid= p.id  %p and entrydate <= :endDate and entryDate >= :startDate  "+
					          " and e.id not in ( select enrollmentid from %s.exit ext where  ext.exitdate is null  or  ext.exitdate <= :startDate ) ";

public static String GET_ALL_EXITS = "select ext.* from %s.exit ext, %s.enrollment e where  e.id = ext.enrollmentid and exitdate >= :startDate and exitdate <= :endDate and e.projectid in  ( "; 

public static String GET_PROJECTS_BY_COC = "select * from %s.project where id in (select projectid from %s.coc where coc_id = ? )";
public static String GET_PROJECTS = "select * from %s.project where id in (";
public static String GET_ENROLLMENTS_BY_COC_ID = "select * from %s.enrollment where  entrydate >=:startDate and entrydate <= :endDate and projectid in (select projectid from %s.coc where id = ? ) ";
public static String GET_ENROLLMENTS_PROJECT_ID = "select distinct(e.dedup_client_id) as dedup_id, e.*  "+
											" from %s.client c,%s.enrollment e, %s.project p,%s.exit ext where e.client_id=c.id and e.projectid= p.id  %p and entrydate <= :endDate "+
										      " and e.id not in ( select enrollmentid from %s.exit ext where  ext.exitdate is null  or  ext.exitdate <= :startDate ) "+
											"   order by e.dedup_client_id";
public static String GET_INCOMEANDSOURCE = "select * from %s.incomeandsources";
public static String NAME_DATE_QUALITY_DNE_REFUSED ="select count(*) %s.from client where name_data_quality in ('8','9')";
public static String NAME_DATE_QUALITY_DNC ="select count(*) from %s.client where name_data_quality in ('99')";
public static String SSN_DATE_QUALITY_DNE_REFUSED ="select count(*) from %s.client where ssn_data_quality in ('8','9')";
public static String SSN_DATE_QUALITY_DNC ="select count(*) from %s.client where ssn_data_quality in ('99')";
public static String PROJECT_WITH_HOUSEHOLD_WITHOUT_CHILDREN ="select i.projectid,householdtype from %s.inventory i,%s.project p  where 	householdtype='1'  and i.projectid =p.id %p ";
public static String PROJECT_WITH_HOUSEHOLD_WITH_ONE_ADULT_CHILD ="select i.projectid,householdtype from %s.inventory i,%s.project p  where 	householdtype='3' and  i.projectid =p.id %p  ";
public static String PROJECT_WITH_HOUSEHOLD_ONLY_CHILDREN ="select i.projectid,householdtype from %s.inventory i,%s.project p where 	householdtype='4' and i.projectid =p.id %p ";
public static String PROJECT_WITH_HOUSEHOLD_TYPE_UNKNOWN ="select i.projectid,householdtype from %s.inventory i,%s.project p  where 	householdtype is null  and i.projectid =p.id %p ";
public static String REQUIRED_ANNUAL_ASSESMENT_QUERY= "select  alimonyamount,childsupportamount,earnedamount,gaamount,othersourceamount,pensionamount,privatedisabilityamount, "+
		 " socsecretirementamount,ssiamount,tanfamount,totalmonthlyincome,unemploymentamount,vadisabilitynonserviceamount,  "+
		 " vadisabilityserviceamount,workerscompamount,e.dedup_client_id,i.incomefromanysource from %s.incomeandsources i, %s.enrollment e, %s.project p where e.id=i.enrollmentid  "+
		 " and e.projectid = p.id %p  %e "+
		 "  and i.information_date = e.entrydate and e.entrydate <= :startDate   and e.ageatentry >=18 "+
		 " and   e.id not in ( select enrollmentid from %s.exit  where  exitdate >= :endDate )  "+
		 " and   e.id not in ( select enrollmentid from %s.enrollment_coc where datacollectionstage='5' and datediff(now(),information_date) < 365 )  ";
      
}
