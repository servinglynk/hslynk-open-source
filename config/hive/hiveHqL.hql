create table test1.client2 AS select key ,id,dedup_client_id,first_name,middle_name,last_name,name_suffix,name_data_quality ,ssn,ssn_data_quality,dob,dob_data_quality,gender,other_gender,ethnicity,race,veteran_status ,user_id ,export_id, date_created ,date_updated  from default.client where veteran_status = '0';





