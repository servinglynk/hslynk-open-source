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
dedup_client_id STRING,
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
("hbase.columns.mapping" = ":key,CF:dedup_client_id,CF:first_name,CF:last_name,CF:survey_id,CF:survey_title,CF:survey_date,CF:survey_score,CF:phone,CF:email,CF:age,CF:ignore_match_process") TBLPROPERTIES ("hbase.table.name" = "active_list_MO0010");



CREATE EXTERNAL TABLE IF NOT EXISTS new_vi_spdat_tay_youth_v1(submission_id string,client_id string,survey_date  timestamp,
q_17__Do_you_have_any_chronic_health_issues_with_your_liver__kidneys__stomach__lungs_or_heart_ string  ,q_Agency string  ,q_28__Are_there_any_medications_like_painkillers_that_you_don_t_take_the_way_the_doctor_prescribed_or_ string  ,q_2__How_long_has_it_been_since_you_lived_in_permanent_stable_housing_ string  ,q_Where_do_you_sleep_most_frequently___check_one__br_ string  ,q_f__Stayed_one_or_more_nights_in_a_holding_cell__jail_or_prison__whether_that_was_a_short_term_stay_l string  ,q_c__Because_your_family_or_friends_caused_you_to_become_homeless_ string  ,q_e__Talked_to_police_because_you_witnessed_a_crime__were_the_victim_of_a_crime__or_the_alleged_perpet string  ,q_Survey_Location string  ,q_8__Were_you_ever_incarcerated_when_younger_than_age_18_ string  ,q_20__When_you_are_sick_or_not_feeling_well__do_you_avoid_getting_medical_help_ string  ,q_9__Does_anybody_force_or_trick_you_to_do_things_that_you_do_not_want_to_do_ string  ,q_f__Because_of_an_unhealthy_or_abusive_relationship__either_at_home_or_elsewhere_ string  ,q_19__Do_you_have_any_physical_disabilities_that_would_limit_the_type_of_housing_you_could_access__or_ string  ,q_Enter_any_notes_regarding_your_contact_with_the_client string  ,q_Who_is_conducting_the_survey_ string  ,q_a__Received_health_care_at_an_emergency_department_room_ string  ,q_12__Do_you_get_any_money_from_the_government__an_inheritance__an_allowance__working_under_the_table_ string  ,q_b__Because_of_a_difference_in_religious_or_cultural_beliefs_from_your_parents__guardians_or_caregive string  ,q_3__In_the_last_three_years__how_many_times_have_you_been_homeless_ string  ,q_5__Have_you_been_attacked_or_beaten_up_since_you_ve_become_homeless_ string  ,q_21__Are_you_currently_pregnant__have_you_ever_been_pregnant_or_have_you_ever_gotten_someone_pregnant string  ,q_11__Is_there_any_person__past_landlord__business__bookie__dealer__or_government_group_like_the_IRS_t string  ,q_Age string  ,q_Is_there_a_phone_number_and_or_email_where_someone_can_safely_get_in_touch_with_you_or_leave_you_a_m string  ,q_d__Because_of_conflicts_around_gender_identity_or_sexual_orientation_ string  ,q_a__A_mental_health_issue_or_concern_ string  ,q_b__A_past_head_injury_ string  ,q_b__Taken_an_ambulance_to_the_hospital_ string  ,q_In_what_language_do_you_feel_best_able_to_express_yourself_ string  ,q_10__Do_you_ever_do_things_that_may_be_considered_to_be_risky_like_exchange_sex_for_money__food__drug string  ,q_a__Because_you_ran_away_from_your_family_home__a_group_home_or_a_foster_home_ string  ,q_c__Been_hospitalized_as_an_inpatient_ string  ,q_13__Do_you_have_planned_activities__other_than_just_surviving__that_make_you_fell_happy_and_fulfille string  ,q_26__Do_you_have_any_mental_health_or_brain_issues_that_would_make_it_hard_for_you_to_live_independen string  ,q_Date_of_Birth string  ,q_c__A_learning_disability__developmental_disability__or_other_impairment_ string  ,q_Ok__now_I_d_like_to_take_your_picture_so_that_it_is_easier_to_find_you_and_confirm_your_identity_in_ string  ,q_14__Are_you_currently_able_to_take_care_of_basic_needs_like_bathing__changing_clothes__using_a_restr string  ,q_16__Have_you_ever_had_to_leave_an_apartment__shelter_program__or_other_place_you_were_staying_becaus string  ,q_7__Do_you_have_any_legal_stuff_going_on_right_now_that_may_result_in_you_being_locked_up__having_to_ string  ,q_d__Used_a_crisis_service__including_sexual_assault_crisis__mental_health_crisis__family_intimate_vio string  ,q_22__Has_your_drinking_or_drug_use_led_you_to_being_kicked_out_of_an_apartment_or_program_where_you_w string  ,q_23__Will_drinking_or_drugs_use_make_it_difficult_for_you_to_stay_housed_or_afford_your_housing__br_ string  ,q_Interviewer_s_Name string  ,q_6__Have_you_threatened_to_or_tried_to_harm_yourself_or_anyone_else_in_the_last_year_ string  ,q_e__Because_of_violence_at_home_between_family_members_ string  ,q_18__If_there_was_space_available_in_a_program_that_specifically_assists_people_that_live_with_HIV_or string  ,q_On_a_regular_day__where_is_it_easiest_to_find_you_and_what_time_of_day_is_easiest_to_do_so_ string  ,q_27__Are_there_any_medications_that_a_doctor_said_you_should_be_taking_that__for_whatever_reason__you string ,q_24__If_you_ve_ever_used_marijuana__did_you_ever_try_it_at_age_12_or_younger_ string) STORED BY 'org.apache.hadoop.hive.hbase.HBaseStorageHandler' WITH SERDEPROPERTIES ("hbase.columns.mapping" = ":key,CF:client_id,CF:survey_date,CF:7ac97262-c933-49d5-b579-81d177cd3acf,CF:8087f3d6-d020-453b-b771-3fec06e2111e,CF:d9dc358b-69ad-4483-8a77-226c605a2e7b,CF:699d0bfa-10cb-4492-ae8d-c5e909a5e38e,CF:e6245008-0de9-4dcc-86eb-acc8ef043b3b,CF:89dbcb50-c511-42a9-9838-21afaba7126d,CF:f6f0ec63-2c45-4281-bd43-fb73f7ab31b0,CF:355a2d95-9063-4ad0-ada1-b73a5503e278,CF:d6e2993f-b4cd-412b-bdf7-4229c89eb273,CF:f0571095-50fa-44e6-8955-bfda8036c6fb,CF:492ba561-52e1-4160-af82-20017d5c3dc9,CF:82922fab-fbc5-4ecf-8b56-0e6cda23b12f,CF:614de037-0eda-4675-8971-e9e2d0316d84,CF:9fb1a45f-bfc1-4ead-a114-64d4608b3123,CF:edce4078-bf18-4db0-bf17-ad7f9a825f70,CF:e87c34fe-ebd9-464e-9507-01f5f70803c2,CF:dd52746f-8dcb-4536-80df-07823e083646,CF:38949cc4-d93e-4558-ac80-1e6eb5c1e165,CF:04a45f27-a859-4c37-a2bb-7251ae6ad63d,CF:eda30beb-2290-4414-97e9-e0c38487388d,CF:4467ba3e-644e-4d6e-a14e-ec126b2b5a3b,CF:d0688044-e33d-4902-8220-34c3da00f0a0,CF:3d99726d-7ab1-4d44-954b-1e256c3dab4c,CF:8a70a510-3035-4c45-8d7c-70e5e48117c2,CF:e29be8f9-5413-4b78-a972-d7f616885ea4,CF:3023590c-a2e4-4f5c-a483-2ccda3ef7fba,CF:439a41bd-e2da-4fa5-905d-3eece21e08d3,CF:a51bbe68-4fd5-4e3d-b353-1e329970b557,CF:859db113-7aa3-43c4-a795-3926d0be98d5,CF:178a96d0-dc61-4a1c-9537-139156c4f99f,CF:02d705ae-1744-4282-af83-aa0a7bfba63c,CF:7b657bbb-2b7d-47e7-a0cf-0f13d19b445c,CF:4062595b-9d70-4d12-86d2-275cbb838419,CF:a1d57864-e878-478c-8e94-d0e13146f644,CF:00930865-f1be-4811-8e86-4f63657101cc,CF:2875c580-1046-4d1a-a21b-2ea7d90e0403,CF:bbb6e063-d9c9-4bd5-b7f6-96801f723e82,CF:c7c60f70-1919-40e6-8f16-ce96288d6a62,CF:9135c56e-df2c-4c59-a6db-977e16a64f35,CF:dec86408-2ab2-456a-8cd1-62523b5b57fe,CF:967d3a72-2642-4e22-84ba-4ab9848c4805,CF:e2968741-ba6f-4dc7-be50-98aabca335b4,CF:54cee876-4303-43c5-884f-9661faa8dddc,CF:7a5e09de-7edd-45dc-ad6b-db2b1242eed5,CF:00c28967-5b96-44ce-b71c-ae39c8e00445,CF:86f6566e-8562-4d94-b225-b9f6adfc0a5b,CF:4c69f23e-efeb-49dd-b266-d16f9493d2b0,CF:8e38784d-2c00-4b3c-9da1-8755d0e55856,CF:a10f159b-f542-4999-b310-9b44b37e7491,CF:acae7b1e-273d-4965-b71a-339c68a2f0f9,CF:a6f1a991-d80b-450a-bc31-866eb1373aa9") TBLPROPERTIES ("hbase.table.name" = "vi_spdat_tay_youth_v1_MO0010");
