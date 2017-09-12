CREATE EXTERNAL TABLE IF NOT EXISTS picklist_group(picklist_group_id string ,picklist_group_name string ,created_at timestamp,  updated_at timestamp,user_id string,is_active string) STORED BY 'org.apache.hadoop.hive.hbase.HBaseStorageHandler' WITH SERDEPROPERTIES ("hbase.columns.mapping" = ":key,CF:picklist_group_name,CF:created_at,CF:updated_at,CF:user_id,CF:is_active") TBLPROPERTIES ("hbase.table.name" = "picklist_group_survey");
CREATE EXTERNAL TABLE IF NOT EXISTS picklist_value(picklist_value_id string ,picklist_value_code string ,created_at timestamp,  updated_at timestamp,user_id string,is_active string,value_text string,picklist_group_id string ) STORED BY 'org.apache.hadoop.hive.hbase.HBaseStorageHandler' WITH SERDEPROPERTIES ("hbase.columns.mapping" = ":key,CF:picklist_value_code,CF:created_at,CF:updated_at,CF:user_id,CF:is_active,CF:picklist_value_code,CF:picklist_group_id") TBLPROPERTIES ("hbase.table.name" = "picklist_value_survey");
CREATE EXTERNAL TABLE IF NOT EXISTS question(question_id string ,project_group_id string ,question_description string,display_text string,question_data_type string,
question_type string,correct_value_for_assessment string,hud_question string,locked string,question_weight string,question_group_id string,picklist_group_id string,
is_copy_question_id string,created_at timestamp,  updated_at timestamp,user_id string,is_active string) STORED BY 'org.apache.hadoop.hive.hbase.HBaseStorageHandler' WITH SERDEPROPERTIES 
("hbase.columns.mapping" = ":key,CF:project_group_id,CF:question_description,CF:display_text,CF:question_data_type,CF:question_type,CF:correct_value_for_assessment,CF:hud_question,CF:locked,
CF:question_weight,CF:question_group_id,CF:picklist_group_id,CF:is_copy_question_id,CF:created_at,CF:updated_at,CF:user_id,CF:is_active") TBLPROPERTIES ("hbase.table.name" = "question_survey");
CREATE EXTERNAL TABLE IF NOT EXISTS question_group(question_group_id string ,question_group_name string ,created_at timestamp,  updated_at timestamp,user_id string,is_active string) STORED BY 'org.apache.hadoop.hive.hbase.HBaseStorageHandler' WITH SERDEPROPERTIES ("hbase.columns.mapping" = ":key,CF:question_group_name,CF:created_at,CF:updated_at,CF:user_id,CF:is_active") TBLPROPERTIES ("hbase.table.name" = "question_group_survey");

CREATE EXTERNAL TABLE IF NOT EXISTS response(response_id string ,response_text string ,question_score string,app_id string,effective_date timestamp,
section_id string,submission_id string,question_id string,client_id string,survey_id string,refused string,created_at timestamp,  updated_at timestamp,user_id string,is_active string) STORED BY 'org.apache.hadoop.hive.hbase.HBaseStorageHandler' WITH SERDEPROPERTIES 
("hbase.columns.mapping" = ":key,CF:response_text,CF:question_score,CF:app_id,CF:effective_date,CF:section_id,CF:submission_id,CF:question_id,CF:client_id,CF:survey_id,CF:refused,CF:created_at,CF:updated_at,CF:user_id,CF:is_active") TBLPROPERTIES ("hbase.table.name" = "response_survey");

CREATE EXTERNAL TABLE IF NOT EXISTS section_question_mapping(section_question_mapping_id string,is_required string,question_id string,question_group_id string,section_id string,created_at timestamp,  updated_at timestamp,user_id string,is_active string) STORED BY 'org.apache.hadoop.hive.hbase.HBaseStorageHandler' WITH SERDEPROPERTIES ("hbase.columns.mapping" = ":key,CF:is_required,CF:question_id,CF:question_group_id,CF:section_id,CF:created_at,CF:updated_at,CF:user_id,CF:is_active") TBLPROPERTIES ("hbase.table.name" = "section_question_mapping_survey");
CREATE EXTERNAL TABLE IF NOT EXISTS section_score(section_score_id string ,section_score string ,survey_id string,section_id string,created_at timestamp,  updated_at timestamp,user_id string,is_active string) STORED BY 'org.apache.hadoop.hive.hbase.HBaseStorageHandler' WITH SERDEPROPERTIES ("hbase.columns.mapping" = ":key,CF:section_score,CF:survey_id,CF:section_id,CF:created_at,CF:updated_at,CF:user_id,CF:is_active") TBLPROPERTIES ("hbase.table.name" = "section_score_survey");
CREATE EXTERNAL TABLE IF NOT EXISTS survey(survey_id string ,project_group_code string ,survey_title string,survey_owner string,locked string,is_copy_survey_id string,tag_value string,created_at timestamp,  updated_at timestamp,user_id string,is_active string) STORED BY 'org.apache.hadoop.hive.hbase.HBaseStorageHandler' WITH SERDEPROPERTIES ("hbase.columns.mapping" = ":key,CF:project_group_code,CF:survey_title,CF:survey_owner,CF:locked,CF:is_copy_survey_id,CF:tag_value,CF:created_at,CF:updated_at,CF:user_id,CF:is_active") TBLPROPERTIES ("hbase.table.name" = "survey_survey");
CREATE EXTERNAL TABLE IF NOT EXISTS survey_section(section_text string,survey_section_id string ,survey_id string ,section_detail string,section_weight string,section_order string,created_at timestamp,  updated_at timestamp,user_id string,is_active string) STORED BY 'org.apache.hadoop.hive.hbase.HBaseStorageHandler' WITH SERDEPROPERTIES ("hbase.columns.mapping" = ":key,CF:id,CF:survey_id ,CF:section_detail,CF:section_weight,CF:section_order,CF:created_at,CF:updated_at,CF:user_id,CF:is_active") TBLPROPERTIES ("hbase.table.name" = "survey_section_survey");



CREATE EXTERNAL TABLE IF NOT EXISTS match_process_log(match_process_log_id string ,status_message string ,status string,housing_unit_id string,client_id string,
project_id string,project_group_code string,process_id string,created_at timestamp,updated_at timestamp,user_id string) STORED BY 'org.apache.hadoop.hive.hbase.HBaseStorageHandler' WITH SERDEPROPERTIES 
("hbase.columns.mapping" = ":key,CF:status_message,CF:status,CF:housing_unit_id,CF:client_id,CF:project_id,CF:project_group_code,CF:process_id,CF:created_at,CF:updated_at,CF:user_id") TBLPROPERTIES ("hbase.table.name" = "match_process_log_housing_inventory");

CREATE EXTERNAL TABLE IF NOT EXISTS global_household(global_household_id string ,inactive string ,head_of_household_id string,head_of_household_link string,
project_group_code string,user_id string,user_create string,user_update string,date_created timestamp,date_updated timestamp,deleted boolean) STORED BY 'org.apache.hadoop.hive.hbase.HBaseStorageHandler' WITH SERDEPROPERTIES 
("hbase.columns.mapping" = ":key,CF:inactive,CF:head_of_household_id,CF:head_of_household_link,CF:project_group_code,
CF:user_id,CF:user_create,CF:user_update,CF:date_created,CF:date_updated,CF:deleted") TBLPROPERTIES ("hbase.table.name" = "global_household_housing_inventory");

create table global_household as select * from default.global_household where project_group_code='MO0010';

CREATE EXTERNAL TABLE IF NOT EXISTS eligible_clients
(id string,
client_id	string,
survey_type	string,		
survey_score string,	
program_type	string,			
matched		string,
survey_date	 date,
spdat_label	string,
zip_code	string,		
project_group_code	string,		
coc_score	string,
client_link	string,
date_created date,	
date_updated date,	
user_id	string,
deleted boolean,
ignore_match_process boolean)
STORED BY 'org.apache.hadoop.hive.hbase.HBaseStorageHandler' WITH SERDEPROPERTIES 
("hbase.columns.mapping" = "
:key,
CF:client_id,	
CF:survey_type,			
CF:survey_score,			
CF:program_type,			
CF:matched,	
CF:survey_date,			
CF:spdat_label,			
CF:zip_code,			
CF:project_group_code,			
CF:coc_score,			
CF:client_link,			
CF:date_created,			
CF:date_updated,			
CF:user_id,			
CF:deleted,			
CF:ignore_match_process") TBLPROPERTIES ("hbase.table.name" = "eligible_clients_housing_inventory");

create table eligible_clients as select * from default.eligible_clients where project_group_code='MO0010';

CREATE EXTERNAL TABLE IF NOT EXISTS housing_unit
(housing_unit_id string,
date_created timestamp,
date_updated timestamp,
inactive boolean,
beds_capacity BIGINT,
beds_current BIGINT,
family_unit boolean,
in_service boolean,
user_id string,
vacant boolean,
created_by string,
last_modified_by string,
alias_name string,
schema_year  BIGINT,
project_group_code string,
project_id string,
deleted boolean)
STORED BY 'org.apache.hadoop.hive.hbase.HBaseStorageHandler' WITH SERDEPROPERTIES 
("hbase.columns.mapping" = "
:key,
CF:date_created,
CF:date_updated,
CF:inactive,
CF:beds_capacity,
CF:beds_current,
CF:family_unit,
CF:in_service,
CF:user_id,
CF:vacant,
CF:created_by,
CF:last_modified_by,
CF:alias_name,
CF:schema_year,
CF:project_group_code,
CF:project_id,
CF:deleted") TBLPROPERTIES ("hbase.table.name" = "housing_unit_housing_inventory");

create table housing_unit as select * from default.housing_unit where project_group_code='MO0010';

CREATE EXTERNAL TABLE IF NOT EXISTS housing_unit_eligibility
(eligibility_id string,
housing_unit_id string,
project_id string,
eligibility string,
date_created timestamp,
date_updated timestamp,
user_id string,
created_by string,
last_modified_by string,
inactive boolean,
project_group_code string,
deleted boolean)
STORED BY 'org.apache.hadoop.hive.hbase.HBaseStorageHandler' WITH SERDEPROPERTIES 
("hbase.columns.mapping" = "
:key,
CF:housing_unit_id,
CF:project_id,
CF:eligibility,
CF:date_created,
CF:date_updated,
CF:user_id,
CF:created_by,
CF:last_modified_by,
CF:inactive,
CF:project_group_code,
CF:deleted") TBLPROPERTIES ("hbase.table.name" = "housing_unit_eligibility_housing_inventory");

create table housing_unit_eligibility as select * from default.housing_unit_eligibility where project_group_code='MO0010';

CREATE EXTERNAL TABLE IF NOT EXISTS active_list
(client_id	string,
first_name string,
last_name string,
survey_id string,
survey_title string,
survey_date timestamp,
score BIGINT,
phone string,
email string,
age BIGINT,
ignore_match_process boolean)
STORED BY 'org.apache.hadoop.hive.hbase.HBaseStorageHandler' WITH SERDEPROPERTIES 
("hbase.columns.mapping" = ":key,CF:first_name,CF:last_name,CF:survey_id,CF:survey_title,CF:survey_date,CF:survey_score,CF:phone,CF:email,CF:age,CF:ignore_match_process") TBLPROPERTIES ("hbase.table.name" = "active_list_MO0010");