DROP SCHEMA IF EXISTS "v2020" cascade;
CREATE SCHEMA "v2020";
DROP TABLE IF EXISTS "v2020".hmis_type;
DROP TABLE IF EXISTS "v2020".path_status;
DROP TABLE IF EXISTS "v2020".rhybcp_status;
DROP TABLE IF EXISTS "v2020".employment;
DROP TABLE IF EXISTS "v2020".health_status;
DROP TABLE IF EXISTS "v2020".affiliation;
DROP TABLE IF EXISTS "v2020".inventory;
DROP TABLE IF EXISTS "v2020".funder;	
DROP TABLE IF EXISTS "v2020".enrollment_coc;
DROP TABLE IF EXISTS "v2020".medicalassistance;
DROP TABLE IF EXISTS "v2020".domesticviolence;
DROP TABLE IF EXISTS "v2020".disabilities;
DROP TABLE IF EXISTS "v2020".moveinDate;
DROP TABLE IF EXISTS "v2020".dateofengagement;
DROP TABLE IF EXISTS "v2020".incomeandsources;
DROP TABLE IF EXISTS "v2020".noncashbenefits;
DROP TABLE IF EXISTS "v2020".healthinsurance;
DROP TABLE IF EXISTS "v2020".exithousingassessment;
DROP TABLE IF EXISTS "v2020".housingassessmentdisposition;
DROP TABLE IF EXISTS "v2020".exit;
DROP TABLE IF EXISTS "v2020".coc;
DROP TABLE IF EXISTS "v2020".project; 
DROP TABLE IF EXISTS "v2020".enrollment;
DROP TABLE IF EXISTS "v2020".organization; 
DROP TABLE IF EXISTS "v2020".client_veteran_info;
DROP TABLE IF EXISTS "v2020".client;
DROP TABLE IF EXISTS "v2020".bulk_upload_activity;
DROP TABLE IF EXISTS "v2020".export; 
DROP TABLE IF EXISTS "v2020".source;
DROP TABLE IF EXISTS "v2020".exitRHY;
DROP TABLE IF EXISTS "v2020".rhyaftercare;
DROP TABLE IF EXISTS "v2020".vashexitreason;
DROP TABLE IF EXISTS "v2020".connectionwithsoar;
DROP TABLE IF EXISTS "v2020".geography;
DROP TABLE IF EXISTS "v2020".question;

DROP TYPE IF EXISTS "v2020".name_data_quality;
DROP TYPE IF EXISTS "v2020".dob_data_quality;
DROP TYPE IF EXISTS "v2020".ssn_data_quality;
DROP TYPE IF EXISTS "v2020".address_data_quality;
DROP TYPE IF EXISTS "v2020".veteran_status;
DROP TYPE IF EXISTS "v2020".race;
DROP TYPE IF EXISTS "v2020".gender;
DROP TYPE IF EXISTS "v2020".ethnicity;
DROP TYPE IF EXISTS "v2020".afghanistanoef;
DROP TYPE IF EXISTS "v2020".desertstorm;
DROP TYPE IF EXISTS "v2020".asked_forced_exchange_sex;
DROP TYPE IF EXISTS "v2020".assessment_disposition;
DROP TYPE IF EXISTS "v2020".availability;
DROP TYPE IF EXISTS "v2020".bed_type;
DROP TYPE IF EXISTS "v2020".count_of_exchange_sex;
DROP TYPE IF EXISTS "v2020".destination;
DROP TYPE IF EXISTS "v2020".disability_type;
DROP TYPE IF EXISTS "v2020".discharge_status;
DROP TYPE IF EXISTS "v2020".early_exit_reason;
DROP TYPE IF EXISTS "v2020".employment_type;
DROP TYPE IF EXISTS "v2020".federal_partner_components;
DROP TYPE IF EXISTS "v2020".five_val_dk_refused;
DROP TYPE IF EXISTS "v2020".fysb_rsn_not_providing_srvcs;
DROP TYPE IF EXISTS "v2020".health_category;
DROP TYPE IF EXISTS "v2020".health_status_type;
DROP TYPE IF EXISTS "v2020".house_hold_type;
DROP TYPE IF EXISTS "v2020".housing_assmnt_exit;
DROP TYPE IF EXISTS "v2020".homeless_atrisk_status;
DROP TYPE IF EXISTS "v2020".incarcerated_parent_status;	
DROP TYPE IF EXISTS "v2020".issues_number_of_years;
DROP TYPE IF EXISTS "v2020".last_grade_completed;
DROP TYPE IF EXISTS "v2020".military_branch;
DROP TYPE IF EXISTS "v2020".months_homeless_past_3_years;
DROP TYPE IF EXISTS "v2020".no_adap_reason;
DROP TYPE IF EXISTS "v2020".no_health_insurance_reason;
DROP TYPE IF EXISTS "v2020".no_medical_assistance_reason;
DROP TYPE IF EXISTS "v2020".not_employed_reason;
DROP TYPE IF EXISTS "v2020".projectcompletionstatus;
DROP TYPE IF EXISTS "v2020".no_yes;
DROP TYPE IF EXISTS "v2020".no_yes_refused;
DROP TYPE IF EXISTS "v2020".path_how_confirmed;	
DROP TYPE IF EXISTS "v2020".path_smi_info_how_confirmed;
DROP TYPE IF EXISTS "v2020".percentage_ami;
DROP TYPE IF EXISTS "v2020".project_completion_status;
DROP TYPE IF EXISTS "v2020".project_type;
DROP TYPE IF EXISTS "v2020".reason_not_enrolled;	
DROP TYPE IF EXISTS "v2020".record_type;
DROP TYPE IF EXISTS "v2020".referral_outcome;
DROP TYPE IF EXISTS "v2020".referral_source;
DROP TYPE IF EXISTS "v2020".relationship_to_head_of_household;
DROP TYPE IF EXISTS "v2020".residence_prior ;
DROP TYPE IF EXISTS "v2020".residence_prior_length_of_stay;
DROP TYPE IF EXISTS "v2020".school_status;
DROP TYPE IF EXISTS "v2020".sexual_orientation;	
DROP TYPE IF EXISTS "v2020".subsidy_information;
DROP TYPE IF EXISTS "v2020".target_population_type;
DROP TYPE IF EXISTS "v2020".times_homeless_past_3_years;
DROP TYPE IF EXISTS "v2020".tracking_method;
DROP TYPE IF EXISTS "v2020".when_dom_violence_occurred;
DROP TYPE IF EXISTS "v2020".youth_age_group;
DROP TYPE IF EXISTS "v2020".housing_status;
DROP TYPE IF EXISTS "v2020".state;
DROP TYPE IF EXISTS "v2020".contact_location;
DROP TYPE IF EXISTS "v2020".datacollectionstage;
DROP TYPE IF EXISTS "v2020".timeToHousingLoss;
DROP TYPE IF EXISTS "v2020".annualpercentami;
DROP TYPE IF EXISTS "v2020".evictionhistory;
DROP TYPE IF EXISTS "v2020".crisisServicesUse;	
DROP TYPE IF EXISTS "v2020".literalHomelessHistory;
DROP TYPE IF EXISTS "v2020".livingSituation;
DROP TYPE IF EXISTS "v2020".lengthOfStay;
DROP TYPE IF EXISTS "v2020".record_type;
DROP TYPE IF EXISTS "v2020".housingType;
DROP TYPE IF EXISTS "v2020".tcell_viralload_source;
DROP TYPE IF EXISTS "v2020".viral_load_available;
DROP TYPE IF EXISTS "v2020".cm_exit_reason;
DROP TYPE IF EXISTS "v2020".geography_type;


CREATE TYPE "v2020".cm_exit_reason AS ENUM ('1','2','3','4','5','6','7','8','9','10','11','12','13','99');
CREATE TYPE "v2020".tcell_viralload_source AS ENUM('1','2','3','99');
CREATE TYPE "v2020".viral_load_available AS ENUM('0','1','2','8','9','99');

CREATE TYPE "v2020".livingSituation AS ENUM('1','2','3','4','5','6','7','8','9','12','13','14','15','16','17','18','19','20','21','22','23','24','25','26','27','99');
CREATE TYPE "v2020".lengthOfStay AS ENUM('2','3','4','5','8','9','10','11','99');
CREATE TYPE "v2020".literalHomelessHistory AS ENUM('0','1','2','99');
CREATE TYPE "v2020".timeToHousingLoss as ENUM('0','1','2','3','99');
CREATE TYPE "v2020".annualpercentami as ENUM('0','1','2','99');
CREATE TYPE "v2020".crisisServicesUse as ENUM('0','1','2','3','4','5','8','9','99');

CREATE TYPE "v2020".name_data_quality AS ENUM ('1', '2', '8','9','99');
CREATE TYPE "v2020".dob_data_quality AS ENUM ('1', '2', '8','9','99');
CREATE TYPE "v2020".ssn_data_quality AS ENUM ('1', '2', '8','9','99');
CREATE TYPE "v2020".address_data_quality AS ENUM ('1', '2', '8','9','99');

CREATE TYPE "v2020".veteran_status AS ENUM ('0', '1', '8','9','99');
CREATE TYPE "v2020".race AS ENUM ('1', '2','3','4','5','8','9','99');
CREATE TYPE "v2020".gender AS ENUM ('0','1', '2','3','4','8','9','99');
CREATE TYPE "v2020".ethnicity AS ENUM ('0', '1', '8','9','99');
CREATE TYPE "v2020".afghanistanoef AS ENUM ('0', '1', '8','9','99');
CREATE TYPE "v2020".desertstorm AS ENUM ('0', '1', '8','9','99');
CREATE TYPE "v2020".asked_forced_exchange_sex AS ENUM ('0', '1', '8','9','99');
CREATE TYPE "v2020".assessment_disposition AS ENUM ('1','2','3','4','5','6','7','8','9','10','11','12','13','14');
CREATE TYPE "v2020".availability AS ENUM ('1', '2', '3');
CREATE TYPE "v2020".bed_type AS ENUM ('1', '2', '3');
CREATE TYPE "v2020".count_of_exchange_sex AS ENUM ('1', '2', '3','4','8','9');
CREATE TYPE "v2020".destination AS ENUM 
('24','1','15','6','14','7','25','26','27','11','21','3','16','4','10','19','28','20','29','18','22','12','23','13','5','2','17','30','8','9','99');
CREATE TYPE "v2020".disability_type AS ENUM ('5','6','7','8','9','10');
CREATE TYPE "v2020".discharge_status AS ENUM ('1','2','4','5','6','7','8','9','99');
CREATE TYPE "v2020".early_exit_reason AS ENUM ('1','2','3','4','5','6','99');
CREATE TYPE "v2020".employment_type AS ENUM ('1','2','3','99');
CREATE TYPE "v2020".federal_partner_components AS ENUM 
('1','2','3','4','5','6','7','8','9','10','11','12','13','14','15','16','17','18','19','20','21','22','23','24','25','26','27','28','29','30','31','32','33','34');
CREATE TYPE "v2020".five_val_dk_refused AS ENUM ('0','1','8','9','99');
CREATE TYPE "v2020".fysb_rsn_not_providing_srvcs AS ENUM ('1','2','3','4','99');
CREATE TYPE "v2020".health_category AS ENUM ('27','28','29');
CREATE TYPE "v2020".health_status_type AS ENUM ('1', '2','3','4','5','8','9','99');
CREATE TYPE "v2020".house_hold_type AS ENUM ('1','3','5');
CREATE TYPE "v2020".housing_assmnt_exit AS ENUM ('1','2','3','4','5','6','7','8','9','10','99');
CREATE TYPE "v2020".homeless_atrisk_status AS ENUM ('1','2','3','4','5','6','8','9','99');

CREATE TYPE "v2020".incarcerated_parent_status AS ENUM ('1','2','3','99');	
CREATE TYPE "v2020".issues_number_of_years AS ENUM ('1','2','3');
CREATE TYPE "v2020".last_grade_completed  AS ENUM ('1','2','3','4','5','6','7','10','8','9','99');
CREATE TYPE "v2020".military_branch AS ENUM ('1','2','3','4','6','8','9','99');
CREATE TYPE "v2020".months_homeless_past_3_years AS ENUM ('7','8','9','99','100','101','102','103','104','105','106','107','108','109','110','111','112');
CREATE TYPE "v2020".no_adap_reason AS ENUM ('1','2','3','4','8','9','99');
CREATE TYPE "v2020".no_health_insurance_reason AS ENUM ('1','2','3','4','8','9','99');
CREATE TYPE "v2020".no_medical_assistance_reason AS ENUM (	
'1',
'2',
'3',
'4',
'8',
'9',
'99');
CREATE TYPE "v2020".not_employed_reason  AS ENUM (	
'1',
'2',
'3',
'99');
CREATE TYPE "v2020".projectcompletionstatus  AS ENUM (	
'1',
'2',
'3',
'99');


CREATE TYPE "v2020".no_yes  AS ENUM (	
'0',
'1',
'8',
'9',
'99');
CREATE TYPE "v2020".no_yes_refused AS ENUM (
'0',
'1',
'8',
'9',
'99');
CREATE TYPE "v2020".path_how_confirmed AS ENUM (	
'1',
'2',
'3',
'99');
CREATE TYPE "v2020".path_smi_info_how_confirmed AS ENUM (	
'0',
'1',
'2',
'3',
'8',
'9',
'99');
CREATE TYPE "v2020".percentage_ami AS ENUM (	
'1',
'2',
'3',
'99');

CREATE TYPE "v2020".project_completion_status AS ENUM (	
'1',
'2',
'3',
'99');

CREATE TYPE "v2020".housingType AS ENUM (	
'1',
'2',
'3');


CREATE TYPE "v2020".project_type AS ENUM (
'1',
'2',
'3',
'4',
'6',
'7',
'8',
'9',
'10',
'11',
'12',
'13',
'14');
CREATE TYPE "v2020".reason_not_enrolled AS ENUM (	
'1',
'2',
'99');
CREATE TYPE "v2020".record_type AS ENUM (	
'12',
'13',
'141',
'142',
'143',
'144',
'151',
'152',
'161',
'200',
'210');

CREATE TYPE "v2020".referral_outcome AS ENUM (	
'1',
'2',
'3');
CREATE TYPE "v2020".referral_source AS ENUM (	
'1',
'2',
'3',
'4',
'5',
'6',
'7',
'10',
'11',
'12',
'13',
'14',
'15',
'16',
'17',
'18',
'19',
'20',
'21',
'22',
'23',
'24',
'25',
'26',
'27',
'28',
'29',
'30',
'31',
'32',
'33',
'34',
'35',
'36',
'37',
'38',
'39',
'8',
'9',
'99');

CREATE TYPE "v2020".relationship_to_head_of_household AS ENUM (
'1',
'2',
'3',
'4',
'5');
CREATE TYPE "v2020".residence_prior  AS ENUM (	
'1',
'2',
'3',
'4',
'5',
'6',
'7',
'8',
'9',
'12',
'13',
'14',
'15',
'16',
'17',
'18',
'19',
'20',
'21',
'22',
'23',
'24',
'25',
'26',
'99');

CREATE TYPE "v2020".residence_prior_length_of_stay AS ENUM (	
'2',
'3',
'4',
'5',
'8',
'9',
'10',
'11',
'99');
CREATE TYPE "v2020".school_status AS ENUM (	
'1',
'2',
'3',
'4',
'5',
'6',
'7',
'8',
'9',
'99');
CREATE TYPE "v2020".sexual_orientation AS ENUM (	
'1',
'2',
'3',
'4',
'5',
'8',
'9',
'99');
CREATE TYPE "v2020".subsidy_information  AS ENUM (
'1',
'2',
'3',
'4');
CREATE TYPE "v2020".target_population_type  AS ENUM ( 	
'1',
'3',
'4');

CREATE TYPE "v2020".times_homeless_past_3_years  AS ENUM (
'0',
'1',
'2',
'3',
'4',
'8',
'9',
'99');

CREATE TYPE "v2020".tracking_method  AS ENUM ( 	
'0',
'3');
CREATE TYPE "v2020".when_dom_violence_occurred AS ENUM (
'1',
'2',
'3',
'4',
'8',
'9',
'99');
CREATE TYPE "v2020".youth_age_group  AS ENUM (	
'1',
'2',
'3');

CREATE TYPE "v2020".housing_status AS ENUM (
'1',
'2',
'3',
'4',
'5',
'6',
'7',
'8',
'9',
'99');

CREATE TYPE "v2020".state AS ENUM (
'AK',
'AL',
'AR',
'AZ',
'CA',
'CO',
'CT',
'DE',
'FL',
'GA',
'HI',
'IA',
'ID',
'IL',
'IN',
'KS',
'KY',
'LA',
'MA',
'MD',
'ME',
'MI',
'MN',
'MO',
'MS',
'MT',
'NC',
'ND',
'NE',
'NH',
'NJ',
'NM',
'NV',
'NY',
'OH',
'OK',
'OR',
'PA',
'RI',
'SC',
'SD',
'TN',
'TX',
'UT',
'VA',
'VT',
'WA',
'WI',
'WV',
'WY',
'DC',
'AS',
'FM',
'GU',
'MH',
'MP',
'PR',
'PW',
'VI',
'AA',
'AE',
'AP');
-- Newly created ENUMS -- Starts
CREATE TYPE "v2020".percentAMI  AS ENUM ('1','2','3','99');
CREATE TYPE "v2020".connection_with_soar  AS ENUM ('0','1','8','9','99');
CREATE TYPE "v2020".contact_location  AS ENUM ('1','2','3');

CREATE TYPE "v2020".written_after_care_plan  AS ENUM ('0','1','2','99');
CREATE TYPE "v2020".assistance_main_stream_benefits  AS ENUM ('0','1','2','99');
CREATE TYPE "v2020".permanent_housing_placement  AS ENUM ('0','1','2','99');
CREATE TYPE "v2020".temp_shelter_placement  AS ENUM ('0','1','2','99');
CREATE TYPE "v2020".scheduled_followup_contacts  AS ENUM ('0','1','2','99');
CREATE TYPE "v2020".other_aftercare_plan_or_action  AS ENUM ('0','1','2','99');
CREATE TYPE "v2020".family_reunification_achieved  AS ENUM ('0','1','8','9','99');


CREATE TYPE "v2020".active_military_parent AS ENUM ('0','1','99');
CREATE TYPE "v2020".house_hold_dynamics AS ENUM ('0','1','99');
CREATE TYPE "v2020".insufficient_income_to_support_youth AS ENUM ('0','1','99'); 
CREATE TYPE "v2020".alcohol_drug_abuse_family_mbr AS ENUM ('0','1','99');
CREATE TYPE "v2020".alcohol_drug_abuse_youth AS ENUM ('0','1','99');
CREATE TYPE "v2020".abuse_and_neglect_family_mbr AS ENUM ('0','1','99');
CREATE TYPE "v2020".abuse_and_neglect_youth AS ENUM ('0','1','99');
CREATE TYPE "v2020".mental_disability_family_mbr AS ENUM ('0','1','99');
CREATE TYPE "v2020".physical_disability_family_mbr AS ENUM ('0','1','99');
CREATE TYPE "v2020".physical_disability_youth AS ENUM ('0','1','99');
CREATE TYPE "v2020".health_issues_family_mbr AS ENUM ('0','1','99');
CREATE TYPE "v2020".health_issues_youth AS ENUM ('0','1','99');
CREATE TYPE "v2020".mental_health_issues_family_mbrily_mbr AS ENUM ('0','1','99');
CREATE TYPE "v2020".mental_health_issues_youth AS ENUM ('0','1','99');
CREATE TYPE "v2020".unemployement_family_mbr AS ENUM ('0','1','99');
CREATE TYPE "v2020".school_educational_issues_youth AS ENUM ('0','1','99');
CREATE TYPE "v2020".school_education_issues_family_mbr AS ENUM ('0','1','99');
CREATE TYPE "v2020".incarcerated_parent AS ENUM ('0','1','99');
CREATE TYPE "v2020".sexual_orientation_gender_identity_Youth AS ENUM ('0','1','99');
CREATE TYPE "v2020".sexual_orientatiion_gender_identity_family_mbr AS ENUM ('0','1','99');

CREATE TYPE "v2020".years_child_welfr_forest_care AS ENUM ('1','2','3');
CREATE TYPE "v2020".years_juvenile_justice AS ENUM ('1','2','3');

CREATE TYPE "v2020".formerly_ward_child_welfr_forest_care AS ENUM ('0','1','8','9','99');
CREATE TYPE "v2020".formerly_ward_of_juvenile_justice AS ENUM ('0','1','8','9','99');
CREATE TYPE "v2020".asked_of_forced_to_exchange_for_sex_past_3_months AS ENUM ('0','1','8','9','99');
CREATE TYPE "v2020".exchange_for_sex_past_three_months AS ENUM ('0','1','8','9','99');
CREATE TYPE "v2020".coerced_to_continue_work AS ENUM ('0','1','8','9','99');
CREATE TYPE "v2020".work_place_promise_difference AS ENUM ('0','1','8','9','99');
CREATE TYPE "v2020".work_place_violence_threats AS ENUM ('0','1','8','9','99');

CREATE TYPE "v2020".count_of_exchange_for_sex AS ENUM ('1','2','3','4','8','9','99');
CREATE TYPE "v2020".asked_of_forced_to_exchange_for_sex AS ENUM ('0','1','8','9','99');
CREATE TYPE "v2020".datacollectionstage AS ENUM('1','2','3','5');
CREATE TYPE "v2020".evictionhistory as ENUM('0','1','2','3','99');

CREATE TYPE "v2020".geography_type as ENUM('1','2','3');

CREATE TABLE "v2020".hmis_type
(
  "id" serial NOT NULL ,
  "name" character(500) NOT NULL,
  "value" character(500) NOT NULL,
  "description" text,
  "year" bigint,
  "status" character(10),
  "expiration_date" timestamp,
  "date_created" timestamp,
  "date_updated" timestamp,
  "user_id" uuid,
  CONSTRAINT hmis_type_pk PRIMARY KEY ("id")
)
WITH (
  OIDS=FALSE
);

CREATE TABLE v2020.question (id UUID NOT NULL, question_description CHARACTER VARYING(256), display_text CHARACTER VARYING(256), question_data_type CHARACTER VARYING(256), question_type CHARACTER VARYING(256), created_at TIMESTAMP(0) WITHOUT TIME ZONE, updated_at TIMESTAMP(0) WITHOUT TIME ZONE, user_id CHARACTER VARYING(256), is_active BOOLEAN, picklist_group_name CHARACTER VARYING(256), deleted BOOLEAN DEFAULT false, hud_question_id CHARACTER VARYING(32), update_url_template CHARACTER VARYING(512), picklist_group_id UUID, uri_object_field CHARACTER VARYING(255), question_group_id BIGINT, PRIMARY KEY (id));


insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template) values
('024c9acd-d3e1-4cc4-9800-a9db85edad81','RunawayYouth','RunawayYouth','STRING','DROPDOWN',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'runaway_youth',false,'R2.B','/v2020/hmistypes/EligibleForRHY/values');

insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template) values
('024c9acd-d3e1-4cc4-9800-a9db85edad87','JuvenileJusticeMonths','JuvenileJusticeMonths','STRING','INTEGER',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'months_juvenile_justice',false,'R12.B','/v2020/hmistypes/JuvenileJusticeMonths/values');


insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template) values
('024c9acd-d3e1-4cc4-9800-a9db85edad93','CountOutreachReferralApproaches','CountOutreachReferralApproaches','STRING','INTEGER',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'count_out_reach_referral_approaches',false,'R1.A','/v2020/hmistypes/CountOutreachReferralApproaches/values');


insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template) values
('024c9acd-d3e1-4cc4-9800-a9db85edad97','HPScreeningScore','HPScreeningScore','STRING','INTEGER',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'hp_screen_score',false,'V7.20','/v2020/hmistypes/HPScreeningScore/values');
insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template) values
('024c9acd-d3e1-4cc4-9800-a9db85edaf71','ThresholdScore','ThresholdScore','STRING','INTEGER',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'thresholdscore',false,'V7.21','/v2020/hmistypes/ThresholdScore/values');


insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template) values
('024c9acd-d3e1-4cc4-9800-a9db85edad98','ExchangeForSex','ExchangeForSex','STRING','DROPDOWN',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'exchage_for_sex',false,'R15.1','/v2020/hmistypes/ExchangeForSex/values');

INSERT INTO "v2020".hmis_type (name,value,description,status) values ('labor_exploit_past_three_months','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('labor_exploit_past_three_months','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('labor_exploit_past_three_months','99','Data not collected','ACTIVE');

insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template) values
('024c9acd-d3e1-4cc4-9800-a9db85edaf92','Earned','Earned','STRING','DROPDOWN',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'earned',false,'4.2.3','/{clientid}/enrollments/{enrollmentid}/incomeandsources/{incomeAndSourceid}');

insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template,uri_object_field) values
('024c9acd-d3e1-4cc4-9800-a9db85edaf19','Earned','Earned','STRING','DROPDOWN',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'unemployment',false,'4.2.4','/v2020/clients/{clientid}/enrollments/{enrollmentid}/incomeandsources/{incomeandsourceid}','incomeAndSource.unemployment');


INSERT INTO "v2020".hmis_type (name,value,description,status) values ('unemployment','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('unemployment','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('unemployment','99','Data not collected','ACTIVE');




INSERT INTO "v2020".hmis_type (name,value,description,status) values ('earned','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('earned','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('earned','99','Data not collected','ACTIVE');


INSERT INTO "v2020".hmis_type (name,value,description,status) values ('after_provided','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('after_provided','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('after_provided','9','Client refused','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('after_provided','99','Data not collected','ACTIVE');


insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template) values
('024c9acd-d3e1-4cc4-9800-a9db85edaf86','AfterCareProvided','AfterCareProvided','STRING','DROPDOWN',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'after_provided',false,'R20.2','/v2020/hmistypes/AfterCareProvided/values');



insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template) values
('024c9acd-d3e1-4cc4-9800-a9db85edaf87','EmailSocialMedia','EmailSocialMedia','STRING','DROPDOWN',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'email_social_media',false,'R20.A','/v2020/exits/{exitid}/rhyaftercares/{rhyaftercareid}');

INSERT INTO "v2020".hmis_type (name,value,description,status) values ('email_social_media','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('email_social_media','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('email_social_media','99','Data not collected','ACTIVE');

insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template) values
('024c9acd-d3e1-4cc4-9800-a9db85edaf96','VADisabilityService','VADisabilityService','STRING','DROPDOWN',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'vadisabilityservice',false,'4.2.7','/{clientid}/enrollments/{enrollmentid}/incomeandsources/{incomeAndSourceid}');

INSERT INTO "v2020".hmis_type (name,value,description,status) values ('vadisabilityservice','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('vadisabilityservice','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('vadisabilityservice','99','Data not collected','ACTIVE');


insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template) values
('024c9acd-d3e1-4cc4-9800-a9db85edaf97','VADisabilityNonService','VADisabilityNonService','STRING','DROPDOWN',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'vadisabilitynonservice',false,'4.2.8','/{clientid}/enrollments/{enrollmentid}/incomeandsources/{incomeAndSourceid}');

INSERT INTO "v2020".hmis_type (name,value,description,status) values ('vadisabilitynonservice','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('vadisabilitynonservice','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('vadisabilitynonservice','99','Data not collected','ACTIVE');



insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template) values
('024c9acd-d3e1-4cc4-9800-a9db85edaf98','PrivateDisability','PrivateDisability','STRING','DROPDOWN',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'privatedisability',false,'4.2.9','/{clientid}/enrollments/{enrollmentid}/incomeandsources/{incomeAndSourceid}');

INSERT INTO "v2020".hmis_type (name,value,description,status) values ('privatedisability','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('privatedisability','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('privatedisability','99','Data not collected','ACTIVE');

insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template) values
('024c9acd-d3e1-4cc4-9800-a9db85edaf99','WorkersComp','WorkersComp','STRING','DROPDOWN',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'workerscomp',false,'4.2.10','/{clientid}/enrollments/{enrollmentid}/incomeandsources/{incomeAndSourceid}');

INSERT INTO "v2020".hmis_type (name,value,description,status) values ('workerscomp','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('workerscomp','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('workerscomp','99','Data not collected','ACTIVE');



insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template) values
('024c9acd-d3e1-4cc4-9800-a9db85edaf88','Telephone','Telephone','STRING','DROPDOWN',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'telephone',false,'R20.A','/v2020/exits/{exitid}/rhyaftercares/{rhyaftercareid}');

INSERT INTO "v2020".hmis_type (name,value,description,status) values ('telephone','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('telephone','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('telephone','99','Data not collected','ACTIVE');


insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template) values
('024c9acd-d3e1-4cc4-9800-a9db85edaf93','SSI','SSI','STRING','DROPDOWN',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'ssi',false,'4.2.5','/{clientid}/enrollments/{enrollmentid}/incomeandsources/{incomeAndSourceid}');

INSERT INTO "v2020".hmis_type (name,value,description,status) values ('ssi','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('ssi','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('ssi','99','Data not collected','ACTIVE');


insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template) values
('024c9acd-d3e1-4cc4-9800-a9db85edaf94','SSDI','SSDI','STRING','DROPDOWN',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'ssdi',false,'4.2.6','/{clientid}/enrollments/{enrollmentid}/incomeandsources/{incomeAndSourceid}');

INSERT INTO "v2020".hmis_type (name,value,description,status) values ('ssdi','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('ssdi','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('ssdi','99','Data not collected','ACTIVE');


insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template) values
('024c9acd-d3e1-4cc4-9800-a9db85edaf91','InPersonIndividual','InPersonIndividual','STRING','DROPDOWN',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'in_person_individual',false,'R20.A','/v2020/exits/{exitid}/rhyaftercares/{rhyaftercareid}');

INSERT INTO "v2020".hmis_type (name,value,description,status) values ('in_person_individual','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('in_person_individual','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('in_person_individual','99','Data not collected','ACTIVE');

insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template) values
('024c9acd-d3e1-4cc4-9800-a9db85edaf45','InPersonGroup','InPersonGroup','STRING','DROPDOWN',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'in_person_group',false,'R20.A','/v2020/exits/{exitid}/rhyaftercares/{rhyaftercareid}');

INSERT INTO "v2020".hmis_type (name,value,description,status) values ('in_person_group','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('in_person_group','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('in_person_group','99','Data not collected','ACTIVE');



INSERT INTO "v2020".hmis_type (name,value,description,status) values ('exchage_for_sex','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('exchage_for_sex','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('exchage_for_sex','99','Data not collected','ACTIVE');

insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template) values
('024c9acd-d3e1-4cc4-9800-a9db85edaf70','LaborExploitPastThreeMonths','LaborExploitPastThreeMonths','STRING','DROPDOWN',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'labor_exploit_past_three_months',false,'R16.B','/v2020/hmistypes/LaborExploitPastThreeMonths/values');

INSERT INTO "v2020".hmis_type (name,value,description,status) values ('labor_exploit_past_three_months','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('labor_exploit_past_three_months','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('labor_exploit_past_three_months','8','Client doesn''t know','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('labor_exploit_past_three_months','9','Client refused','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('labor_exploit_past_three_months','99','Data not collected','ACTIVE');


insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template) values
('024c9acd-d3e1-4cc4-9800-a9db85edaf72','AskedOrForcedToExchangeForSexPastThreeMonths','AskedOrForcedToExchangeForSexPastThreeMonths','STRING','DROPDOWN',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'asked_or_forced_to_exchange_for_sex_past_three_months',false,'R15.D','/v2020/hmistypes/AskedOrForcedToExchangeForSexPastThreeMonths/values');


INSERT INTO "v2020".hmis_type (name,value,description,status) values ('asked_or_forced_to_exchange_for_sex_past_three_months','0','Not available','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('asked_or_forced_to_exchange_for_sex_past_three_months','1','Available','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('asked_or_forced_to_exchange_for_sex_past_three_months','2','Undetectable','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('asked_or_forced_to_exchange_for_sex_past_three_months','8','Client doesn''t know','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('asked_or_forced_to_exchange_for_sex_past_three_months','9','Client refused','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('asked_or_forced_to_exchange_for_sex_past_three_months','99','Data not collected','ACTIVE');

INSERT INTO "v2020".hmis_type (name,value,description,status) values ('physicalDisability','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('physicalDisability','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('physicalDisability','8','Client doesn''t know','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('physicalDisability','9','Client refused','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('physicalDisability','99','Data not collected','ACTIVE');


INSERT INTO "v2020".hmis_type (name,value,description,status) values ('developmentalDisability','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('developmentalDisability','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('developmentalDisability','8','Client doesn''t know','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('developmentalDisability','9','Client refused','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('developmentalDisability','99','Data not collected','ACTIVE');

INSERT INTO "v2020".hmis_type (name,value,description,status) values ('chronicHealthCondition','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('chronicHealthCondition','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('chronicHealthCondition','8','Client doesn''t know','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('chronicHealthCondition','9','Client refused','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('chronicHealthCondition','99','Data not collected','ACTIVE');

INSERT INTO "v2020".hmis_type (name,value,description,status) values ('hivAids','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('hivAids','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('hivAids','8','Client doesn''t know','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('hivAids','9','Client refused','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('hivAids','99','Data not collected','ACTIVE');

INSERT INTO "v2020".hmis_type (name,value,description,status) values ('mentalHealthProblem','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('mentalHealthProblem','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('mentalHealthProblem','8','Client doesn''t know','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('mentalHealthProblem','9','Client refused','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('mentalHealthProblem','99','Data not collected','ACTIVE');

INSERT INTO "v2020".hmis_type (name,value,description,status) values ('substanceAbuse','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('substanceAbuse','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('substanceAbuse','8','Client doesn''t know','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('substanceAbuse','9','Client refused','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('substanceAbuse','99','Data not collected','ACTIVE');


INSERT INTO "v2020".hmis_type (name,value,description,status) values ('runaway_youth','0','Not available','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('runaway_youth','1','Available','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('runaway_youth','2','Undetectable','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('runaway_youth','8','Client doesn''t know','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('runaway_youth','9','Client refused','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('runaway_youth','99','Data not collected','ACTIVE');


INSERT INTO "v2020".hmis_type (name,value,description,status) values ('tcellcountsource','1','Medical Report','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('tcellcountsource','2','Client Report','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('tcellcountsource','3','Other','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('tcellcountsource','99','Data not collected','ACTIVE');


INSERT INTO "v2020".hmis_type (name,value,description,status) values ('eligible_for_rhy','0','Not available','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('eligible_for_rhy','1','Available','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('eligible_for_rhy','2','Undetectable','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('eligible_for_rhy','8','Client doesn''t know','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('eligible_for_rhy','9','Client refused','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('eligible_for_rhy','99','Data not collected','ACTIVE');

insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template) values
('024c9acd-d3e1-4cc4-9800-a9db85edad80','EligibleForRHY','EligibleForRHY','STRING','DROPDOWN',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'eligible_for_rhy',false,'R2.2','/v2020/hmistypes/EligibleForRHY/values');


INSERT INTO "v2020".hmis_type (name,value,description,status) values ('viral_load_source','1','Medical Report','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('viral_load_source','2','Client Report','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('viral_load_source','3','Other','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('viral_load_source','99','Data not collected','ACTIVE');

INSERT INTO "v2020".hmis_type (name,value,description,status) values ('viral_load_available','0','Not available','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('viral_load_available','1','Available','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('viral_load_available','2','Undetectable','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('viral_load_available','8','Client doesn''t know','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('viral_load_available','9','Client refused','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('viral_load_available','99','Data not collected','ACTIVE');

INSERT INTO "v2020".hmis_type (name,value,description,status) values ('worst_housing_situation','0','Not available','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('worst_housing_situation','1','Available','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('worst_housing_situation','2','Undetectable','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('worst_housing_situation','8','Client doesn''t know','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('worst_housing_situation','9','Client refused','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('worst_housing_situation','99','Data not collected','ACTIVE');


insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template) values
('024c9acd-d3e1-4cc4-9800-a9db85edad79','WorstHousingSituation','WorstHousingSituation','STRING','DROPDOWN',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'worst_housing_situation',false,'U1.1','/v2020/hmistypes/WorstHousingSituation/values');

INSERT INTO "v2020".hmis_type (name,value,description,status) values ('literalHomelessHistory','0','4 or more times or total of at least 12 months in past three years','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('literalHomelessHistory','1','2-3 times in past three years','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('literalHomelessHistory','2','1 time in past three years','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('literalHomelessHistory','3','None (0 points)','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('literalHomelessHistory','99','Data not collected','ACTIVE');

INSERT INTO "v2020".hmis_type (name,value,description,status) values ('annualpercentami','0','0-14% of AMI for household size','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('annualpercentami','1','15-30% of AMI for household size','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('annualpercentami','2','More than 30% of AMI for household size (0 points)','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('annualpercentami','99','Data not collected','ACTIVE');

INSERT INTO "v2020".hmis_type (name,value,description,status) values ('timeToHousingLoss','0','0-6 days','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('timeToHousingLoss','1','7-13 days','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('timeToHousingLoss','2','14-21 days','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('timeToHousingLoss','3','More than 21 days (0 points)','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('timeToHousingLoss','99','Data not collected','ACTIVE');

INSERT INTO "v2020".hmis_type (name,value,description,status) values ('zeroincome','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('zeroincome','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('zeroincome','99','Data not collected','ACTIVE');

INSERT INTO "v2020".hmis_type (name,value,description,status) values ('client_enrolled_in_path','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('client_enrolled_in_path','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('client_enrolled_in_path','99','Data not collected','ACTIVE');

insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template) values
('024c9acd-d3e1-4cc4-9800-a9db85edad78','ClientEnrolledInPATH','ClientEnrolledInPATH','STRING','DROPDOWN',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'client_enrolled_in_path',false,'P3.2','/v2020/hmistypes/ClientEnrolledInPATH/values');





INSERT INTO "v2020".hmis_type (name,value,description,status) values ('residentialaffiliation','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('residentialaffiliation','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('residentialaffiliation','99','Data not collected','ACTIVE');

INSERT INTO "v2020".hmis_type (name,value,description,status) values ('financialchange','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('financialchange','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('financialchange','99','Data not collected','ACTIVE');

insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template) values
('024c9acd-d3e1-4cc4-9800-a9db85edad94','UrgentReferral','UrgentReferral','STRING','DROPDOWN',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'urgent_referral',false,'V7.1','/v2020/hmistypes/UrgentReferral/values');

INSERT INTO "v2020".hmis_type (name,value,description,status) values ('urgent_referral','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('urgent_referral','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('urgent_referral','99','Data not collected','ACTIVE');




INSERT INTO "v2020".hmis_type (name,value,description,status) values ('evictionhistory','0','4 or more prior rental evictions','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('evictionhistory','1','2-3 prior rental evictions','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('evictionhistory','2','1 prior rental eviction','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('evictionhistory','3','No prior rental evictions (0 points)','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('evictionhistory','99','Data not collected','ACTIVE');

INSERT INTO "v2020".hmis_type (name,value,description,status) values ('householdchange','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('householdchange','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('householdchange','99','Data not collected','ACTIVE');

INSERT INTO "v2020".hmis_type (name,value,description,status) values ('subsidyatrisk','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('subsidyatrisk','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('subsidyatrisk','99','Data not collected','ACTIVE');

insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template) values
('024c9acd-d3e1-4cc4-9800-a9db85edad95','DisabledHoH','DisabledHoH','STRING','DROPDOWN',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'disablehoh',false,'V7.10','/v2020/hmistypes/DisabledHoH/values');


INSERT INTO "v2020".hmis_type (name,value,description,status) values ('disablehoh','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('disablehoh','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('disablehoh','99','Data not collected','ACTIVE');

INSERT INTO "v2020".hmis_type (name,value,description,status) values ('criminalrecord','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('criminalrecord','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('criminalrecord','99','Data not collected','ACTIVE');

INSERT INTO "v2020".hmis_type (name,value,description,status) values ('sexoffender','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('sexoffender','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('sexoffender','99','Data not collected','ACTIVE');

insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template) values
('024c9acd-d3e1-4cc4-9800-a9db85edad96','DependentUnder6','DependentUnder6','STRING','DROPDOWN',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'dependendunder6',false,'V7.13','/v2020/hmistypes/DependentUnder6/values');


INSERT INTO "v2020".hmis_type (name,value,description,status) values ('dependendunder6','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('dependendunder6','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('dependendunder6','99','Data not collected','ACTIVE');

INSERT INTO "v2020".hmis_type (name,value,description,status) values ('singleparent','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('singleparent','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('singleparent','99','Data not collected','ACTIVE');

INSERT INTO "v2020".hmis_type (name,value,description,status) values ('hh5plus','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('hh5plus','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('hh5plus','99','Data not collected','ACTIVE');

INSERT INTO "v2020".hmis_type (name,value,description,status) values ('iraqafghanistan','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('iraqafghanistan','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('iraqafghanistan','99','Data not collected','ACTIVE');

INSERT INTO "v2020".hmis_type (name,value,description,status) values ('femvet','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('femvet','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('femvet','99','Data not collected','ACTIVE');

INSERT INTO "v2020".hmis_type (name,value,description,status) values ('losunderthreshold','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('losunderthreshold','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('losunderthreshold','99','Data not collected','ACTIVE');


INSERT INTO "v2020".hmis_type (name,value,description,status) values ('victimServiceProvider','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('victimServiceProvider','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('victimServiceProvider','99','Data not collected','ACTIVE');


INSERT INTO "v2020".hmis_type (name,value,description,status) values ('continuumproject','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('continuumproject','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('continuumproject','99','Data not collected','ACTIVE');





INSERT INTO "v2020".hmis_type (name,value,description,status) values ('previousStreetESSH','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('previousStreetESSH','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('previousStreetESSH','99','Data not collected','ACTIVE');

INSERT INTO "v2020".hmis_type (name,value,description,status) values ('world_war_2','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('world_war_2','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('world_war_2','8','Client doesn''t know','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('world_war_2','9','Client refused','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('world_war_2','99','Data not collected','ACTIVE');

INSERT INTO "v2020".hmis_type (name,value,description,status) values ('korean_war','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('korean_war','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('korean_war','8','Client doesn''t know','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('korean_war','9','Client refused','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('korean_war','99','Data not collected','ACTIVE');


INSERT INTO "v2020".hmis_type (name,value,description,status) values ('disablingCondition','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('disablingCondition','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('disablingCondition','8','Client doesn''t know','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('disablingCondition','9','Client refused','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('disablingCondition','99','Data not collected','ACTIVE');

insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template) values
('024c9acd-d3e1-4cc4-9800-a9db85edad77','Disabling Condition','Disabling Condition','STRING','DROPDOWN',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'disablingCondition',false,'3.8','/v2020/hmistypes/disablingCondition/values');



INSERT INTO "v2020".hmis_type (name,value,description,status) values ('vietnam_war','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('vietnam_war','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('vietnam_war','8','Client doesn''t know','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('vietnam_war','9','Client refused','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('vietnam_war','99','Data not collected','ACTIVE');

INSERT INTO "v2020".hmis_type (name,value,description,status) values ('desert_storm','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('desert_storm','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('desert_storm','8','Client doesn''t know','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('desert_storm','9','Client refused','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('desert_storm','99','Data not collected','ACTIVE');

INSERT INTO "v2020".hmis_type (name,value,description,status) values ('iraq_oif','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('iraq_oif','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('iraq_oif','8','Client doesn''t know','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('iraq_oif','9','Client refused','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('iraq_oif','99','Data not collected','ACTIVE');

insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template) values
('024c9acd-d3e1-4cc4-9800-a9db85edad57','CHBedInventory','CHBedInventory','STRING','DROPDOWN',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'ch_bed_inventory',false,'2.7.7','/v2020/hmistypes/ch_bed_inventory/values');


insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template) values
('024c9acd-d3e1-4cc4-9800-a9db85edaf74','CounselingReceived','CounselingReceived','STRING','DROPDOWN',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'counseling_received',false,'R18.1','/v2020/hmistypes/CounselingReceived/values');

insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template) values
('024c9acd-d3e1-4cc4-9800-a9db85edaf75','IndividualCounseling','IndividualCounseling','STRING','DROPDOWN',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'individual_counseling',false,'R18.A','/v2020/hmistypes/IndividualCounseling/values');

insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template) values
('024c9acd-d3e1-4cc4-9800-a9db85edaf76','FamilyCounseling','FamilyCounseling','STRING','DROPDOWN',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'family_counseling',false,'R18.A','/v2020/hmistypes/FamilyCounseling/values');


insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template) values
('024c9acd-d3e1-4cc4-9800-a9db85edaf77','GroupCounseling','GroupCounseling','STRING','DROPDOWN',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'group_counseling',false,'R18.A','/v2020/hmistypes/GroupCounseling/values');

insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template) values
('024c9acd-d3e1-4cc4-9800-a9db85edaf78','PostExitCounselingPlan','PostExitCounselingPlan','STRING','DROPDOWN',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'post_exit_counseling_plan',false,'R18.3','/v2020/hmistypes/PostExitCounselingPlan/values');

insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template) values
('024c9acd-d3e1-4cc4-9800-a9db85edaf79','SessionCountAtExit','SessionCountAtExit','STRING','INTEGER',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'session_count_at_exit',false,'R18.B','/v2020/hmistypes/SessionCountAtExit/values');

insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template) values
('024c9acd-d3e1-4cc4-9800-a9db85edaf80','SessionsInPlan','SessionsInPlan','STRING','INTEGER',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'sessions_in_plan',false,'R18.2','/v2020/hmistypes/SessionsInPlan/values');

insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template) values
('024c9acd-d3e1-4cc4-9800-a9db85edaf81','DestinationSafeClient','DestinationSafeClient','STRING','DROPDOWN',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'destination_safe_client',false,'R19.1','/v2020/hmistypes/DestinationSafeClient/values');

insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template) values
('024c9acd-d3e1-4cc4-9800-a9db85edaf82','DestinationSafeWorker','DestinationSafeWorker','STRING','DROPDOWN',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'destination_safe_worker',false,'R19.2','/v2020/hmistypes/DestinationSafeWorker/values');

insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template) values
('024c9acd-d3e1-4cc4-9800-a9db85edaf83','PosAdultConnections','PosAdultConnections','STRING','DROPDOWN',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'pos_adult_connections',false,'R19.3','/v2020/hmistypes/PosAdultConnections/values');

insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template) values
('024c9acd-d3e1-4cc4-9800-a9db85edaf84','PosPeerConnections','PosPeerConnections','STRING','DROPDOWN',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'pos_peer_connections',false,'R19.4','/v2020/hmistypes/PosPeerConnections/values');

insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template) values
('024c9acd-d3e1-4cc4-9800-a9db85edaf85','PosCommunityConnections','PosCommunityConnections','STRING','DROPDOWN',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'pos_community_connections',false,'R19.5','/v2020/hmistypes/PosCommunityConnections/values');


INSERT INTO "v2020".hmis_type (name,value,description,status) values ('destination_safe_worker','2','Worker Doesn''t Know','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('pos_adult_connections','2','Worker Doesn''t Know','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('pos_peer_connections','2','Worker Doesn''t Know','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('pos_community_connections','2','Worker Doesn''t Know','ACTIVE');


INSERT INTO "v2020".hmis_type (name,value,description,status) values ('counseling_received','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('counseling_received','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('counseling_received','8','Client doesn''t know','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('counseling_received','9','Client refused','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('counseling_received','99','Data not collected','ACTIVE');

INSERT INTO "v2020".hmis_type (name,value,description,status) values ('individual_counseling','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('individual_counseling','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('individual_counseling','99','Data not collected','ACTIVE');

INSERT INTO "v2020".hmis_type (name,value,description,status) values ('family_counseling','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('family_counseling','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('family_counseling','99','Data not collected','ACTIVE');

INSERT INTO "v2020".hmis_type (name,value,description,status) values ('group_counseling','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('group_counseling','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('group_counseling','99','Data not collected','ACTIVE');

INSERT INTO "v2020".hmis_type (name,value,description,status) values ('post_exit_counseling_plan','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('post_exit_counseling_plan','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('post_exit_counseling_plan','8','Client doesn''t know','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('post_exit_counseling_plan','9','Client refused','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('post_exit_counseling_plan','99','Data not collected','ACTIVE');

INSERT INTO "v2020".hmis_type (name,value,description,status) values ('destination_safe_client','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('destination_safe_client','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('destination_safe_client','8','Client doesn''t know','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('destination_safe_client','9','Client refused','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('destination_safe_client','99','Data not collected','ACTIVE');

INSERT INTO "v2020".hmis_type (name,value,description,status) values ('destination_safe_worker','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('destination_safe_worker','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('destination_safe_worker','8','Client doesn''t know','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('destination_safe_worker','9','Client refused','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('destination_safe_worker','99','Data not collected','ACTIVE');


INSERT INTO "v2020".hmis_type (name,value,description,status) values ('pos_adult_connections','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('pos_adult_connections','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('pos_adult_connections','8','Client doesn''t know','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('pos_adult_connections','9','Client refused','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('pos_adult_connections','99','Data not collected','ACTIVE');

INSERT INTO "v2020".hmis_type (name,value,description,status) values ('pos_peer_connections','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('pos_peer_connections','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('pos_peer_connections','8','Client doesn''t know','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('pos_peer_connections','9','Client refused','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('pos_peer_connections','99','Data not collected','ACTIVE');

INSERT INTO "v2020".hmis_type (name,value,description,status) values ('pos_community_connections','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('pos_community_connections','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('pos_community_connections','8','Client doesn''t know','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('pos_community_connections','9','Client refused','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('pos_community_connections','99','Data not collected','ACTIVE');



INSERT INTO "v2020".hmis_type (name,value,description,status) values ('youth_bed_inventory','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('youth_bed_inventory','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('youth_bed_inventory','8','Client doesn''t know','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('youth_bed_inventory','9','Client refused','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('youth_bed_inventory','99','Data not collected','ACTIVE');

insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template) values
('024c9acd-d3e1-4cc4-9800-a9db85edad34','YouthBedInventory','YouthBedInventory','STRING','DROPDOWN',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'youth_bed_inventory',false,'2.7.11','/v2020/hmistypes/youth_bed_inventory/values');


insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template) values
('024c9acd-d3e1-4cc4-9800-a9db85edad65','HMISParticipatingBeds','HMISParticipatingBeds','STRING','DROPDOWN',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'hmisparticipatingbeds',false,'2.7.13','/v2020/hmistypes/hmisparticipatingbeds/values');

INSERT INTO "v2020".hmis_type (name,value,description,status) values ('iraq_ond','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('iraq_ond','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('iraq_ond','8','Client doesn''t know','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('iraq_ond','9','Client refused','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('iraq_ond','99','Data not collected','ACTIVE');

INSERT INTO "v2020".hmis_type (name,value,description,status) values ('other_theater','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('other_theater','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('other_theater','8','Client doesn''t know','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('other_theater','9','Client refused','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('other_theater','99','Data not collected','ACTIVE');

INSERT INTO "v2020".hmis_type (name,value,description,status) values ('employed','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('employed','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('employed','8','Client doesn''t know','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('employed','9','Client refused','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('employed','99','Data not collected','ACTIVE');


   
  
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('address_data_quality','1','Full address reported','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('address_data_quality','2','Incomplete or estimated address reported','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('address_data_quality','8','Client doesn''t know','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('address_data_quality','9','Client refused','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('address_data_quality','99','Data not collected','ACTIVE');

INSERT INTO "v2020".hmis_type (name,status,value,description) values ('assessmentdisposition','ACTIVE','1',  'Referred to emergency shelter/safe haven');
INSERT INTO "v2020".hmis_type (name,status,value,description) values ('assessmentdisposition','ACTIVE','2', 'Referred to transitional housing');
INSERT INTO "v2020".hmis_type (name,status,value,description) values ('assessmentdisposition','ACTIVE','3', 'Referred to rapid re-housing');
INSERT INTO "v2020".hmis_type (name,status,value,description) values ('assessmentdisposition','ACTIVE','4', 'Referred to permanent supportive housing');
INSERT INTO "v2020".hmis_type (name,status,value,description) values ('assessmentdisposition','ACTIVE','5', 'Referred to homelessness prevention');
INSERT INTO "v2020".hmis_type (name,status,value,description) values ('assessmentdisposition','ACTIVE','6', 'Referred to street outreach');
INSERT INTO "v2020".hmis_type (name,status,value,description) values ('assessmentdisposition','ACTIVE','7', 'Referred to other continuum project type');
INSERT INTO "v2020".hmis_type (name,status,value,description) values ('assessmentdisposition','ACTIVE','8', 'Referred to a homelessness diversion program');
INSERT INTO "v2020".hmis_type (name,status,value,description) values ('assessmentdisposition','ACTIVE','9', 'Unable to refer/accept within continuum; ineligible for continuum projects');
INSERT INTO "v2020".hmis_type (name,status,value,description) values ('assessmentdisposition','ACTIVE','10','Unable to refer/accept within continuum; continuum services unavailable');
INSERT INTO "v2020".hmis_type (name,status,value,description) values ('assessmentdisposition','ACTIVE','11','Referred to other community project (non-continuum)');
INSERT INTO "v2020".hmis_type (name,status,value,description) values ('assessmentdisposition','ACTIVE','12','Applicant declined referral/acceptance');
INSERT INTO "v2020".hmis_type (name,status,value,description) values ('assessmentdisposition','ACTIVE','13','Applicant terminated assessment prior to completion');
INSERT INTO "v2020".hmis_type (name,status,value,description) values ('assessmentdisposition','ACTIVE','14','Other/specify');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('assessmentdisposition','99','Data not collected','ACTIVE');

INSERT INTO "v2020".hmis_type (name,status,value,description) values ('availabilty','ACTIVE','1','Year-round');
INSERT INTO "v2020".hmis_type (name,status,value,description) values ('availabilty','ACTIVE','2','Seasonal');
INSERT INTO "v2020".hmis_type (name,status,value,description) values ('availabilty','ACTIVE','3','Overflow');

INSERT INTO "v2020".hmis_type (name,status,value,description) values ('bedtype','ACTIVE','1','Facility-based');
INSERT INTO "v2020".hmis_type (name,status,value,description) values ('bedtype','ACTIVE','2','Voucher');
INSERT INTO "v2020".hmis_type (name,status,value,description) values ('bedtype','ACTIVE','3','Other');

INSERT INTO "v2020".hmis_type (name,status,value,description) values ('disabilitytype','ACTIVE','5','Physical Disability');
INSERT INTO "v2020".hmis_type (name,status,value,description) values ('disabilitytype','ACTIVE','6','Developmental Disability');
INSERT INTO "v2020".hmis_type (name,status,value,description) values ('disabilitytype','ACTIVE','7','Chronic Health Condition');
INSERT INTO "v2020".hmis_type (name,status,value,description) values ('disabilitytype','ACTIVE','8','HIV/AIDS');
INSERT INTO "v2020".hmis_type (name,status,value,description) values ('disabilitytype','ACTIVE','9','Mental Health Problem');
INSERT INTO "v2020".hmis_type (name,status,value,description) values ('disabilitytype','ACTIVE','10','Substance Abuse');

INSERT INTO "v2020".hmis_type (name,status,value,description) values ('discharge_status','ACTIVE','1','Honorable');
INSERT INTO "v2020".hmis_type (name,status,value,description) values ('discharge_status','ACTIVE','2','General under honorable conditions');
INSERT INTO "v2020".hmis_type (name,status,value,description) values ('discharge_status','ACTIVE','4','Bad conduct');
INSERT INTO "v2020".hmis_type (name,status,value,description) values ('discharge_status','ACTIVE','5','Dishonorable');
INSERT INTO "v2020".hmis_type (name,status,value,description) values ('discharge_status','ACTIVE','6','Under other than honorable conditions (OTH)');
INSERT INTO "v2020".hmis_type (name,status,value,description) values ('discharge_status','ACTIVE','7','Uncharacterized');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('discharge_status','8','Client doesn''t know','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('discharge_status','9','Client refused','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('discharge_status','99','Data not collected','ACTIVE');

INSERT INTO "v2020".hmis_type (name,value,description,status) values ('dob_data_quality','1','Full DOB reported','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('dob_data_quality','2','Approximate or partial DOB reported','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('dob_data_quality','8','Client doesn''t know','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('dob_data_quality','9','Client refused','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('dob_data_quality','99','Data not collected','ACTIVE');


 INSERT INTO "v2020".hmis_type (name,status,value,description) values ('employment_type','ACTIVE','1','Full-time');
 INSERT INTO "v2020".hmis_type (name,status,value,description) values ('employment_type','ACTIVE','2','Part-time');
 INSERT INTO "v2020".hmis_type (name,status,value,description) values ('employment_type','ACTIVE','3','Seasonal / sporadic (including day labor)');
 INSERT INTO "v2020".hmis_type (name,status,value,description) values ('employment_type','ACTIVE','99','Data not collected');
 
 INSERT INTO "v2020".hmis_type (name,value,description,status) values ('ethnicity','0','Non-Hispanic/Non-Latino','ACTIVE');
 INSERT INTO "v2020".hmis_type (name,value,description,status) values ('ethnicity','1','Hispanic/Latino','ACTIVE');
 INSERT INTO "v2020".hmis_type (name,value,description,status) values    ('ethnicity','8','Client does not know','ACTIVE');
 INSERT INTO "v2020".hmis_type  (name,value,description,status) values  ('ethnicity','9','Client refused','ACTIVE');
 INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('ethnicity','99','Data not collected','ACTIVE');

INSERT INTO "v2020".hmis_type (name,status,value,description) values ('destination','ACTIVE','24','Deceased');
INSERT INTO "v2020".hmis_type (name,status,value,description) values ('destination','ACTIVE','1','Emergency shelter, including hotel or motel paid for with emergency shelter voucher');
INSERT INTO "v2020".hmis_type (name,status,value,description) values ('destination','ACTIVE','15','Foster care home or foster care group home');
INSERT INTO "v2020".hmis_type (name,status,value,description) values ('destination','ACTIVE','6','Hospital or other residential non-psychiatric medical facility');
INSERT INTO "v2020".hmis_type (name,status,value,description) values ('destination','ACTIVE','14','Hotel or motel paid for without emergency shelter voucher');
INSERT INTO "v2020".hmis_type (name,status,value,description) values ('destination','ACTIVE','7','Jail, prison or juvenile detention facility');
INSERT INTO "v2020".hmis_type (name,status,value,description) values ('destination','ACTIVE','25','Long-term care facility or nursing home');	
INSERT INTO "v2020".hmis_type (name,status,value,description) values ('destination','ACTIVE','26','Moved from one HOPWA funded project to HOPWA PH ');   
INSERT INTO "v2020".hmis_type (name,status,value,description) values ('destination','ACTIVE','27','Moved from one HOPWA funded project to HOPWA TH');
INSERT INTO "v2020".hmis_type (name,status,value,description) values ('destination','ACTIVE','11','Owned by client, no ongoing housing subsidy');
INSERT INTO "v2020".hmis_type (name,status,value,description) values ('destination','ACTIVE','21','Owned by client, with ongoing housing subsidy');
INSERT INTO "v2020".hmis_type (name,status,value,description) values ('destination','ACTIVE','3','Permanent housing (other than RRH) for formerly homeless persons');
INSERT INTO "v2020".hmis_type (name,status,value,description) values ('destination','ACTIVE','16','Place not meant for habitation (e.g., a vehicle, an abandoned building, bus/train/subway station/airport or anywhere outside)');
INSERT INTO "v2020".hmis_type (name,status,value,description) values ('destination','ACTIVE','4','Psychiatric hospital or other psychiatric facility');
INSERT INTO "v2020".hmis_type (name,status,value,description) values ('destination','ACTIVE','10','Rental by client, no ongoing housing subsidy');	
INSERT INTO "v2020".hmis_type (name,status,value,description) values ('destination','ACTIVE','19','Rental by client, with VASH housing subsidy');  
INSERT INTO "v2020".hmis_type (name,status,value,description) values ('destination','ACTIVE','28','Rental by client, with GPD TIP housing subsidy');
INSERT INTO "v2020".hmis_type (name,status,value,description) values ('destination','ACTIVE','20','Rental by client, with other ongoing housing subsidy');
INSERT INTO "v2020".hmis_type (name,status,value,description) values ('destination','ACTIVE','29','Residential project or halfway house with no homeless criteria');
INSERT INTO "v2020".hmis_type (name,status,value,description) values ('destination','ACTIVE','18','Safe Haven');
INSERT INTO "v2020".hmis_type (name,status,value,description) values ('destination','ACTIVE','22','Staying or living with family, permanent tenure');
INSERT INTO "v2020".hmis_type (name,status,value,description) values ('destination','ACTIVE','12','Staying or living with family, temporary tenure (e.g., room, apartment or house)');
INSERT INTO "v2020".hmis_type (name,status,value,description) values ('destination','ACTIVE','23','Staying or living with friends, permanent tenure');	
INSERT INTO "v2020".hmis_type (name,status,value,description) values ('destination','ACTIVE','13','Staying or living with friends, temporary tenure (e.g., room apartment or house)');  
INSERT INTO "v2020".hmis_type (name,status,value,description) values ('destination','ACTIVE','5','Substance abuse treatment facility or detox center ');
INSERT INTO "v2020".hmis_type (name,status,value,description) values ('destination','ACTIVE','2','Transitional housing for homeless persons (including homeless youth)');
INSERT INTO "v2020".hmis_type (name,status,value,description) values ('destination','ACTIVE','17','Other');
INSERT INTO "v2020".hmis_type (name,status,value,description) values ('destination','ACTIVE','30','No exit interview completed');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('destination','8','Client doesn''t know','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('destination','9','Client refused','ACTIVE');   											    
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('destination','99','Data not collected','ACTIVE'); 
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('destination','31','Rental by client, with RRH or equivalent subsidy','ACTIVE');
 

INSERT INTO "v2020".hmis_type (name,value,description,status) values ('livingSituation','1','Emergency shelter, including hotel or motel paid for with emergency shelter voucher','ACTIVE'); 
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('livingSituation','2','Transitional housing for homeless persons (including homeless youth)','ACTIVE'); 
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('livingSituation','3','Permanent housing (other than RRH) for formerly homeless persons','ACTIVE'); 
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('livingSituation','4','Psychiatric hospital or other psychiatric facility','ACTIVE'); 
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('livingSituation','5','Substance abuse treatment facility or detox center','ACTIVE'); 
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('livingSituation','6','Hospital or other residential non-psychiatric medical facility','ACTIVE'); 
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('livingSituation','7','Jail, prison or juvenile detention facility','ACTIVE'); 
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('livingSituation','8','Client does not know','ACTIVE'); 
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('livingSituation','9','Client refused','ACTIVE'); 
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('livingSituation','12','Staying or living in a family members room, apartment or house','ACTIVE'); 
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('livingSituation','13','Staying or living in a friends room, apartment or house','ACTIVE'); 
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('livingSituation','14','Hotel or motel paid for without emergency shelter voucher','ACTIVE'); 
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('livingSituation','15','Foster care home or foster care group homes','ACTIVE'); 
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('livingSituation','16','Place not meant for habitation (e.g., a vehicle, an abandoned building, bus/train/subway station/airport or anywhere outside)','ACTIVE'); 
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('livingSituation','17','Other','ACTIVE'); 
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('livingSituation','18','Safe Haven','ACTIVE'); 
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('livingSituation','19','Rental by client, with VASH subsidy','ACTIVE'); 
 INSERT INTO "v2020".hmis_type (name,value,description,status) values ('livingSituation','20','Rental by client, with other housing subsidy (including RRH)','ACTIVE'); 
 INSERT INTO "v2020".hmis_type (name,value,description,status) values ('livingSituation','21','Owned by client, with ongoing housing subsidy ','ACTIVE'); 
 INSERT INTO "v2020".hmis_type (name,value,description,status) values ('livingSituation','22','Rental by client, no ongoing housing subsidy','ACTIVE'); 
 INSERT INTO "v2020".hmis_type (name,value,description,status) values ('livingSituation','23','Owned by client, no ongoing housing subsidy','ACTIVE'); 
 INSERT INTO "v2020".hmis_type (name,value,description,status) values ('livingSituation','24','Long-term care facility or nursing home','ACTIVE'); 
 INSERT INTO "v2020".hmis_type (name,value,description,status) values ('livingSituation','25','Rental by client, with GPD TIP subsidy','ACTIVE'); 
 INSERT INTO "v2020".hmis_type (name,value,description,status) values ('livingSituation','26','Residential project or halfway house with no homeless criteria','ACTIVE'); 
 INSERT INTO "v2020".hmis_type (name,value,description,status) values ('livingSituation','27','Interim housing','ACTIVE'); 
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('livingSituation','99','Data not collected','ACTIVE'); 


 INSERT INTO "v2020".hmis_type (name,status,value,description) values ('funder','ACTIVE','1','HUD:CoC – Homelessness Prevention (High Performing Comm. Only)'); 
 INSERT INTO "v2020".hmis_type (name,status,value,description) values ('funder','ACTIVE','2','HUD:CoC – Permanent Supportive Housing');
 INSERT INTO "v2020".hmis_type (name,status,value,description) values ('funder','ACTIVE','3','HUD:CoC – Rapid Re-Housing');
 INSERT INTO "v2020".hmis_type (name,status,value,description) values ('funder','ACTIVE','4','HUD:CoC – Supportive Services Only');
 INSERT INTO "v2020".hmis_type (name,status,value,description) values ('funder','ACTIVE','5','HUD:CoC – Transitional Housing');
 INSERT INTO "v2020".hmis_type (name,status,value,description) values ('funder','ACTIVE','6','HUD:CoC – Safe Haven');
 INSERT INTO "v2020".hmis_type (name,status,value,description) values ('funder','ACTIVE','7','HUD:CoC – Single Room Occupancy (SRO)');   
 INSERT INTO "v2020".hmis_type (name,status,value,description) values ('funder','ACTIVE','8','HUD:ESG – Emergency Shelter (operating and/or essential services)');  
 INSERT INTO "v2020".hmis_type (name,status,value,description) values ('funder','ACTIVE','9','HUD:ESG – Homelessness Prevention'); 
 INSERT INTO "v2020".hmis_type (name,status,value,description) values ('funder','ACTIVE','10','HUD:ESG – Rapid Rehousing');  
 INSERT INTO "v2020".hmis_type (name,status,value,description) values ('funder','ACTIVE','11','HUD:ESG – Street Outreach');
 INSERT INTO "v2020".hmis_type (name,status,value,description) values ('funder','ACTIVE','12','HUD:Rural Housing Stability Assistance Program');
 INSERT INTO "v2020".hmis_type (name,status,value,description) values ('funder','ACTIVE','13','HUD:HOPWA – Hotel/Motel Vouchers');
 INSERT INTO "v2020".hmis_type (name,status,value,description) values ('funder','ACTIVE','14','HUD:HOPWA – Housing Information');  
 INSERT INTO "v2020".hmis_type (name,status,value,description) values ('funder','ACTIVE','15','HUD:HOPWA – Permanent Housing (facility based or TBRA)');  
 INSERT INTO "v2020".hmis_type (name,status,value,description) values ('funder','ACTIVE','16','HUD:HOPWA – Permanent Housing Placement');  
 INSERT INTO "v2020".hmis_type (name,status,value,description) values ('funder','ACTIVE','17','HUD:HOPWA – Short-Term Rent, Mortgage, Utility assistance'); 
 INSERT INTO "v2020".hmis_type (name,status,value,description) values ('funder','ACTIVE','18','HUD:HOPWA – Short-Term Supportive Facility');
 INSERT INTO "v2020".hmis_type (name,status,value,description) values ('funder','ACTIVE','19','HUD:HOPWA – Transitional Housing (facility based or TBRA)'); 
 INSERT INTO "v2020".hmis_type (name,status,value,description) values ('funder','ACTIVE','20','HUD:HUD/VASH');  
 INSERT INTO "v2020".hmis_type (name,status,value,description) values ('funder','ACTIVE','21','HHS:PATH – Street Outreach and Supportive Services Only');   
 INSERT INTO "v2020".hmis_type (name,status,value,description) values ('funder','ACTIVE','22','HHS:RHY – Basic Center Program (prevention and shelter)');   
 INSERT INTO "v2020".hmis_type (name,status,value,description) values ('funder','ACTIVE','23','HHS:RHY – Maternity Group Home for Pregnant and Parenting Youth');   
 INSERT INTO "v2020".hmis_type (name,status,value,description) values ('funder','ACTIVE','24','HHS:RHY – Transitional Living Program');  
 INSERT INTO "v2020".hmis_type (name,status,value,description) values ('funder','ACTIVE','25','HHS:RHY – Street Outreach Project');
 INSERT INTO "v2020".hmis_type (name,status,value,description) values ('funder','ACTIVE','26','HHS:RHY – Demonstration Project');
 INSERT INTO "v2020".hmis_type (name,status,value,description) values ('funder','ACTIVE','27','VA: Community Contract Emergency Housing');
 INSERT INTO "v2020".hmis_type (name,status,value,description) values ('funder','ACTIVE','28','VA: Community Contract Residential Treatment Program');
 INSERT INTO "v2020".hmis_type (name,status,value,description) values ('funder','ACTIVE','29','VA:Domiciliary Care');
 INSERT INTO "v2020".hmis_type (name,status,value,description) values ('funder','ACTIVE','30','VA:Community Contract Safe Haven Program');
 INSERT INTO "v2020".hmis_type (name,status,value,description) values ('funder','ACTIVE','31','VA:Grant and Per Diem Program');
 INSERT INTO "v2020".hmis_type (name,status,value,description) values ('funder','ACTIVE','32','VA:Compensated Work Therapy Transitional Residence');
 INSERT INTO "v2020".hmis_type (name,status,value,description) values ('funder','ACTIVE','33','VA:Supportive Services for Veteran Families');
 INSERT INTO "v2020".hmis_type (name,status,value,description) values ('funder','ACTIVE','34','N/A');
	INSERT INTO "v2020".hmis_type (name,value,description,status) values ('funder','35','HUD:  Pay for Success','ACTIVE');
	INSERT INTO "v2020".hmis_type (name,value,description,status) values ('funder','36','HUD:  Public and Indian Housing (PIH) Programs','ACTIVE');
	INSERT INTO "v2020".hmis_type (name,value,description,status) values ('funder','37','VA:  Grant Per Diem – Bridge Housing','ACTIVE');
	INSERT INTO "v2020".hmis_type (name,value,description,status) values ('funder','38','VA:  Grant Per Diem – Low Demand','ACTIVE');
	INSERT INTO "v2020".hmis_type (name,value,description,status) values  ('funder','39','VA:  Grant Per Diem – Hospital to Housing','ACTIVE');
	INSERT INTO "v2020".hmis_type  (name,value,description,status) values  ('funder','40','VA:  Grant Per Diem – Clinical Treatment','ACTIVE');
	INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('funder','41','VA:  Grant Per Diem – Service Intensive Transitional Housing','ACTIVE');
	INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('funder','42','VA:  Grant Per Diem – Transition in Place','ACTIVE');
	INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('funder','43','HUD:CoC – Youth Homeless Demonstration Program','ACTIVE');
			
	 
 INSERT INTO "v2020".hmis_type (name,status,value,description) values ('reason_no_services','ACTIVE','1','Out of age range');
 INSERT INTO "v2020".hmis_type (name,status,value,description) values ('reason_no_services','ACTIVE','2','Ward of the State – Immediate Reunification');
 INSERT INTO "v2020".hmis_type (name,status,value,description) values ('reason_no_services','ACTIVE','3','Ward of the Criminal Justice System – Immediate Reunification');
 INSERT INTO "v2020".hmis_type (name,status,value,description) values ('reason_no_services','ACTIVE','4','Other');
 INSERT INTO "v2020".hmis_type (name,value,description,status) values ('reason_no_services','99','Data not collected','ACTIVE'); 
 INSERT INTO "v2020".hmis_type (name,value,description,status)  values ('gender','0','Female','ACTIVE');
 INSERT INTO "v2020".hmis_type (name,value,description,status)  values ('gender','1','Male','ACTIVE');
 INSERT INTO "v2020".hmis_type (name,value,description,status)  values ('gender','2','Transgender male to female','ACTIVE');
 INSERT INTO "v2020".hmis_type (name,value,description,status)  values ('gender','3','Transgender female to male','ACTIVE');
 INSERT INTO "v2020".hmis_type (name,value,description,status)  values ('gender','4','Other','ACTIVE');
 INSERT INTO "v2020".hmis_type (name,value,description,status)  values ('gender','8','Client does not know','ACTIVE');
 INSERT INTO "v2020".hmis_type (name,value,description,status)  values ('gender','9','Client refused','ACTIVE');
 INSERT INTO "v2020".hmis_type (name,value,description,status)  values ('gender','99','Data not collected','ACTIVE');
 
  INSERT INTO "v2020".hmis_type (name,status,value,description) values ('health_category','ACTIVE','27','General Health Status');
  INSERT INTO "v2020".hmis_type (name,status,value,description) values ('health_category','ACTIVE','28','Dental Health Status');
  INSERT INTO "v2020".hmis_type (name,status,value,description) values ('health_category','ACTIVE','29','Mental Health Status');
  INSERT INTO "v2020".hmis_type (name,status,value,description) values ('health_category','ACTIVE','30','Pregnancy Status');
  
   INSERT INTO "v2020".hmis_type (name,status,value,description) values ('health_status','ACTIVE','1','Excellent');
   INSERT INTO "v2020".hmis_type (name,status,value,description) values ('health_status','ACTIVE','2','Very good');
   INSERT INTO "v2020".hmis_type (name,status,value,description) values ('health_status','ACTIVE','3','Good');
   INSERT INTO "v2020".hmis_type (name,status,value,description) values ('health_status','ACTIVE','4','Fair'); 
   INSERT INTO "v2020".hmis_type (name,status,value,description) values ('health_status','ACTIVE','5','Poor');	
    INSERT INTO "v2020".hmis_type (name,value,description,status)  values ('health_status','8','Client does not know','ACTIVE');
    INSERT INTO "v2020".hmis_type (name,value,description,status)  values ('health_status','9','Client refused','ACTIVE');
 INSERT INTO "v2020".hmis_type (name,value,description,status)  values ('health_status','99','Data not collected','ACTIVE');	
	
	
   INSERT INTO "v2020".hmis_type (name,status,value,description) values ('householdtype','ACTIVE','1','Households without children'); 
   INSERT INTO "v2020".hmis_type (name,status,value,description) values ('householdtype','ACTIVE','3','Households with at least one adult and one child'); 
   INSERT INTO "v2020".hmis_type (name,status,value,description) values ('householdtype','ACTIVE','4','Households with only children');

 INSERT INTO "v2020".hmis_type (name,status,value,description) values ('housingassessment','ACTIVE','1','Able to maintain the housing they had at project entry');
 INSERT INTO "v2020".hmis_type (name,status,value,description) values ('housingassessment','ACTIVE','2','Moved to new housing unit');
 INSERT INTO "v2020".hmis_type (name,status,value,description) values ('housingassessment','ACTIVE','3','Moved in with family/friends on a temporary basis');
 INSERT INTO "v2020".hmis_type (name,status,value,description) values ('housingassessment','ACTIVE','4','Moved in with family/friends on a permanent basis ');
 INSERT INTO "v2020".hmis_type (name,status,value,description) values ('housingassessment','ACTIVE','5','Moved to a transitional or temporary housing facility or program');
 INSERT INTO "v2020".hmis_type (name,status,value,description) values ('housingassessment','ACTIVE','6','Client became homeless – moving to a shelter or other place unfit for human habitation');
 INSERT INTO "v2020".hmis_type (name,status,value,description) values ('housingassessment','ACTIVE','7','Client went to jail/prison');
 INSERT INTO "v2020".hmis_type (name,status,value,description) values ('housingassessment','ACTIVE','10','Client died ');
    INSERT INTO "v2020".hmis_type (name,value,description,status)  values ('housingassessment','8','Client does not know','ACTIVE');
    INSERT INTO "v2020".hmis_type (name,value,description,status)  values ('housingassessment','9','Client refused','ACTIVE');
 INSERT INTO "v2020".hmis_type (name,value,description,status)  values ('housingassessment','99','Data not collected','ACTIVE');	


INSERT INTO "v2020".hmis_type (name,status,value,description) values ('childwelfareyears','ACTIVE','1','Less than one year');
INSERT INTO "v2020".hmis_type (name,status,value,description) values ('childwelfareyears','ACTIVE','2','1 to 2 years');
INSERT INTO "v2020".hmis_type (name,status,value,description) values ('childwelfareyears','ACTIVE','3','3 to 5 or more years');

 
  INSERT INTO "v2020".hmis_type (name,status,value,description) values ('military_branch','ACTIVE','1','Army');
  INSERT INTO "v2020".hmis_type (name,status,value,description) values ('military_branch','ACTIVE','2','Air Force');
  INSERT INTO "v2020".hmis_type (name,status,value,description) values ('military_branch','ACTIVE','3','Navy'); 
  INSERT INTO "v2020".hmis_type (name,status,value,description) values ('military_branch','ACTIVE','4','Marines'); 
  INSERT INTO "v2020".hmis_type (name,status,value,description) values ('military_branch','ACTIVE','6','Coast Guard');
  INSERT INTO "v2020".hmis_type (name,value,description,status)  values ('military_branch','8','Client does not know','ACTIVE');
  INSERT INTO "v2020".hmis_type (name,value,description,status)  values ('military_branch','9','Client refused','ACTIVE');
  INSERT INTO "v2020".hmis_type (name,value,description,status)  values ('military_branch','99','Data not collected','ACTIVE');
  
 
  INSERT INTO "v2020".hmis_type (name,status,value,description) values ('monthsHomelessPastThreeYears','ACTIVE','100','0 months');
  INSERT INTO "v2020".hmis_type (name,status,value,description) values ('monthsHomelessPastThreeYears','ACTIVE','101','1 month');
  INSERT INTO "v2020".hmis_type (name,status,value,description) values ('monthsHomelessPastThreeYears','ACTIVE','102','2 months');
  INSERT INTO "v2020".hmis_type (name,status,value,description) values ('monthsHomelessPastThreeYears','ACTIVE','103','3 months');
  INSERT INTO "v2020".hmis_type (name,status,value,description) values ('monthsHomelessPastThreeYears','ACTIVE','104','4 months');
  INSERT INTO "v2020".hmis_type (name,status,value,description) values ('monthsHomelessPastThreeYears','ACTIVE','105','5 months');
  INSERT INTO "v2020".hmis_type (name,status,value,description) values ('monthsHomelessPastThreeYears','ACTIVE','106','6 months');
  INSERT INTO "v2020".hmis_type (name,status,value,description) values ('monthsHomelessPastThreeYears','ACTIVE','107','7 months');
  INSERT INTO "v2020".hmis_type (name,status,value,description) values ('monthsHomelessPastThreeYears','ACTIVE','108','8 months');
  INSERT INTO "v2020".hmis_type (name,status,value,description) values ('monthsHomelessPastThreeYears','ACTIVE','109','9 months');
  INSERT INTO "v2020".hmis_type (name,status,value,description) values ('monthsHomelessPastThreeYears','ACTIVE','110','10 months');
  INSERT INTO "v2020".hmis_type (name,status,value,description) values ('monthsHomelessPastThreeYears','ACTIVE','111','11 months');
  INSERT INTO "v2020".hmis_type (name,status,value,description) values ('monthsHomelessPastThreeYears','ACTIVE','112','12 months');
  INSERT INTO "v2020".hmis_type (name,status,value,description) values ('monthsHomelessPastThreeYears','ACTIVE','113','More than 12 months');
  INSERT INTO "v2020".hmis_type (name,status,value,description) values ('monthsHomelessPastThreeYears','ACTIVE','1','More than 12 months');
    INSERT INTO "v2020".hmis_type (name,value,description,status)  values ('monthsHomelessPastThreeYears','8','Client does not know','ACTIVE');
    INSERT INTO "v2020".hmis_type (name,value,description,status)  values ('monthsHomelessPastThreeYears','9','Client refused','ACTIVE');
    INSERT INTO "v2020".hmis_type (name,value,description,status)  values ('monthsHomelessPastThreeYears','99','Data not collected','ACTIVE');
    
  INSERT INTO "v2020".hmis_type (name,status,value,description) values ('name_data_quality','ACTIVE','1','Full name reported'); 
  INSERT INTO "v2020".hmis_type (name,status,value,description) values ('name_data_quality','ACTIVE','2','Partial, street name, or code name reported');  
    INSERT INTO "v2020".hmis_type (name,value,description,status)  values ('name_data_quality','8','Client does not know','ACTIVE');  
    INSERT INTO "v2020".hmis_type (name,value,description,status)  values ('name_data_quality','9','Client refused','ACTIVE');  
    INSERT INTO "v2020".hmis_type (name,value,description,status)  values ('name_data_quality','99','Data not collected','ACTIVE');  
    
      INSERT INTO "v2020".hmis_type (name,status,value,description) values ('noadapreason','ACTIVE','1','Applied; decision pending');
      INSERT INTO "v2020".hmis_type (name,status,value,description) values ('noadapreason','ACTIVE','2','Applied; client not eligible');
      INSERT INTO "v2020".hmis_type (name,status,value,description) values ('noadapreason','ACTIVE','3','Client did not apply');
      INSERT INTO "v2020".hmis_type (name,status,value,description) values ('noadapreason','ACTIVE','4','Insurance type N/A for this client');
  INSERT INTO "v2020".hmis_type (name,value,description,status)  values ('noadapreason','8','Client does not know','ACTIVE');  
  INSERT INTO "v2020".hmis_type (name,value,description,status)  values ('noadapreason','9','Client refused','ACTIVE');  
  INSERT INTO "v2020".hmis_type (name,value,description,status)  values ('noadapreason','99','Data not collected','ACTIVE');  
    
INSERT INTO "v2020".hmis_type (name,status,value,description) values ('nocobrareason','ACTIVE','1','Applied; decision pending');
INSERT INTO "v2020".hmis_type (name,status,value,description) values ('nocobrareason','ACTIVE','2','Applied; client not eligible');    
INSERT INTO "v2020".hmis_type (name,status,value,description) values ('nocobrareason','ACTIVE','3','Client did not apply');
INSERT INTO "v2020".hmis_type (name,status,value,description) values ('nocobrareason','ACTIVE','4','Insurance type N/A for this client');
INSERT INTO "v2020".hmis_type (name,value,description,status)  values ('nocobrareason','8','Client does not know','ACTIVE'); 
INSERT INTO "v2020".hmis_type (name,value,description,status)  values ('nocobrareason','9','Client refused','ACTIVE');  
INSERT INTO "v2020".hmis_type (name,value,description,status)  values ('nocobrareason','99','Data not collected','ACTIVE');  

INSERT INTO "v2020".hmis_type (name,status,value,description) values ('noemployerprovidedreason','ACTIVE','1','Applied; decision pending');
INSERT INTO "v2020".hmis_type (name,status,value,description) values ('noemployerprovidedreason','ACTIVE','2','Applied; client not eligible');    
INSERT INTO "v2020".hmis_type (name,status,value,description) values ('noemployerprovidedreason','ACTIVE','3','Client did not apply');
INSERT INTO "v2020".hmis_type (name,status,value,description) values ('noemployerprovidedreason','ACTIVE','4','Insurance type N/A for this client');
INSERT INTO "v2020".hmis_type (name,value,description,status)  values ('noemployerprovidedreason','8','Client does not know','ACTIVE'); 
INSERT INTO "v2020".hmis_type (name,value,description,status)  values ('noemployerprovidedreason','9','Client refused','ACTIVE');  
INSERT INTO "v2020".hmis_type (name,value,description,status)  values ('noemployerprovidedreason','99','Data not collected','ACTIVE');  

INSERT INTO "v2020".hmis_type (name,status,value,description) values ('nomedicaidreason','ACTIVE','1','Applied; decision pending');
INSERT INTO "v2020".hmis_type (name,status,value,description) values ('nomedicaidreason','ACTIVE','2','Applied; client not eligible');    
INSERT INTO "v2020".hmis_type (name,status,value,description) values ('nomedicaidreason','ACTIVE','3','Client did not apply');
INSERT INTO "v2020".hmis_type (name,status,value,description) values ('nomedicaidreason','ACTIVE','4','Insurance type N/A for this client');
INSERT INTO "v2020".hmis_type (name,value,description,status)  values ('nomedicaidreason','8','Client does not know','ACTIVE'); 
INSERT INTO "v2020".hmis_type (name,value,description,status)  values ('nomedicaidreason','9','Client refused','ACTIVE');  
INSERT INTO "v2020".hmis_type (name,value,description,status)  values ('nomedicaidreason','99','Data not collected','ACTIVE');  

 INSERT INTO "v2020".hmis_type (name,status,value,description) values ('nomedicarereason','ACTIVE','1','Applied; decision pending');
 INSERT INTO "v2020".hmis_type (name,status,value,description) values ('nomedicarereason','ACTIVE','2','Applied; client not eligible');    
 INSERT INTO "v2020".hmis_type (name,status,value,description) values ('nomedicarereason','ACTIVE','3','Client did not apply');
 INSERT INTO "v2020".hmis_type (name,status,value,description) values ('nomedicarereason','ACTIVE','4','Insurance type N/A for this client');
 INSERT INTO "v2020".hmis_type (name,value,description,status)  values ('nomedicarereason','8','Client does not know','ACTIVE'); 
 INSERT INTO "v2020".hmis_type (name,value,description,status)  values ('nomedicarereason','9','Client refused','ACTIVE');  
 INSERT INTO "v2020".hmis_type (name,value,description,status)  values ('nomedicarereason','99','Data not collected','ACTIVE');  

INSERT INTO "v2020".hmis_type (name,status,value,description) values ('noprivatepayreason','ACTIVE','1','Applied; decision pending');
INSERT INTO "v2020".hmis_type (name,status,value,description) values ('noprivatepayreason','ACTIVE','2','Applied; client not eligible');    
INSERT INTO "v2020".hmis_type (name,status,value,description) values ('noprivatepayreason','ACTIVE','3','Client did not apply');
INSERT INTO "v2020".hmis_type (name,status,value,description) values ('noprivatepayreason','ACTIVE','4','Insurance type N/A for this client');
INSERT INTO "v2020".hmis_type (name,value,description,status)  values ('noprivatepayreason','8','Client does not know','ACTIVE'); 
INSERT INTO "v2020".hmis_type (name,value,description,status)  values ('noprivatepayreason','9','Client refused','ACTIVE');  
INSERT INTO "v2020".hmis_type (name,value,description,status)  values ('noprivatepayreason','99','Data not collected','ACTIVE');  

INSERT INTO "v2020".hmis_type (name,status,value,description) values ('noschipreason','ACTIVE','1','Applied; decision pending');
INSERT INTO "v2020".hmis_type (name,status,value,description) values ('noschipreason','ACTIVE','2','Applied; client not eligible');    
INSERT INTO "v2020".hmis_type (name,status,value,description) values ('noschipreason','ACTIVE','3','Client did not apply');
INSERT INTO "v2020".hmis_type (name,status,value,description) values ('noschipreason','ACTIVE','4','Insurance type N/A for this client');
INSERT INTO "v2020".hmis_type (name,value,description,status)  values ('noschipreason','8','Client does not know','ACTIVE'); 
INSERT INTO "v2020".hmis_type (name,value,description,status)  values ('noschipreason','9','Client refused','ACTIVE');  
INSERT INTO "v2020".hmis_type (name,value,description,status)  values ('noschipreason','99','Data not collected','ACTIVE');  

INSERT INTO "v2020".hmis_type (name,status,value,description) values ('nostatehealthinsreason','ACTIVE','1','Applied; decision pending');
INSERT INTO "v2020".hmis_type (name,status,value,description) values ('nostatehealthinsreason','ACTIVE','2','Applied; client not eligible');    
INSERT INTO "v2020".hmis_type (name,status,value,description) values ('nostatehealthinsreason','ACTIVE','3','Client did not apply');
INSERT INTO "v2020".hmis_type (name,status,value,description) values ('nostatehealthinsreason','ACTIVE','4','Insurance type N/A for this client');
INSERT INTO "v2020".hmis_type (name,value,description,status)  values ('nostatehealthinsreason','8','Client does not know','ACTIVE'); 
INSERT INTO "v2020".hmis_type (name,value,description,status)  values ('nostatehealthinsreason','9','Client refused','ACTIVE');  
INSERT INTO "v2020".hmis_type (name,value,description,status)  values ('nostatehealthinsreason','99','Data not collected','ACTIVE');  


INSERT INTO "v2020".hmis_type (name,status,value,description) values ('novamedreason','ACTIVE','1','Applied; decision pending');
INSERT INTO "v2020".hmis_type (name,status,value,description) values ('novamedreason','ACTIVE','2','Applied; client not eligible');    
INSERT INTO "v2020".hmis_type (name,status,value,description) values ('novamedreason','ACTIVE','3','Client did not apply');
INSERT INTO "v2020".hmis_type (name,status,value,description) values ('novamedreason','ACTIVE','4','Insurance type N/A for this client');
INSERT INTO "v2020".hmis_type (name,value,description,status)  values ('novamedreason','8','Client does not know','ACTIVE'); 
INSERT INTO "v2020".hmis_type (name,value,description,status)  values ('novamedreason','9','Client refused','ACTIVE');  
INSERT INTO "v2020".hmis_type (name,value,description,status)  values ('novamedreason','99','Data not collected','ACTIVE');  

INSERT INTO "v2020".hmis_type (name,status,value,description) values ('nohivaidsassistancereason','ACTIVE','1','Applied; decision pending');
INSERT INTO "v2020".hmis_type (name,status,value,description) values ('nohivaidsassistancereason','ACTIVE','2','Applied; client not eligible');
INSERT INTO "v2020".hmis_type (name,status,value,description) values ('nohivaidsassistancereason','ACTIVE','3','Client did not apply');
INSERT INTO "v2020".hmis_type (name,status,value,description) values ('nohivaidsassistancereason','ACTIVE','4','Insurance type N/A for this client');
INSERT INTO "v2020".hmis_type (name,value,description,status)  values ('nohivaidsassistancereason','8','Client does not know','ACTIVE'); 
INSERT INTO "v2020".hmis_type (name,value,description,status)  values ('nohivaidsassistancereason','9','Client refused','ACTIVE');  
INSERT INTO "v2020".hmis_type (name,value,description,status)  values ('nohivaidsassistancereason','99','Data not collected','ACTIVE');  

INSERT INTO "v2020".hmis_type (name,status,value,description) values ('not_employed_reason','ACTIVE','1','Looking for work');
INSERT INTO "v2020".hmis_type (name,status,value,description) values ('not_employed_reason','ACTIVE','2','Unable to work');
INSERT INTO "v2020".hmis_type (name,status,value,description) values ('not_employed_reason','ACTIVE','3','Not looking for work');
INSERT INTO "v2020".hmis_type (name,value,description,status)  values ('not_employed_reason','99','Data not collected','ACTIVE');  

INSERT INTO "v2020".hmis_type (name,status,value,description) values ('projectcompletionstatus','ACTIVE','1','Completed project');
INSERT INTO "v2020".hmis_type (name,status,value,description) values ('projectcompletionstatus','ACTIVE','2','Youth voluntarily left early'); 
INSERT INTO "v2020".hmis_type (name,status,value,description) values ('projectcompletionstatus','ACTIVE','3','Youth was expelled or otherwise involuntarily discharged from project');
INSERT INTO "v2020".hmis_type (name,value,description,status)  values ('projectcompletionstatus','99','Data not collected','ACTIVE');  

INSERT INTO "v2020".hmis_type (name,value,description,status)  values ('race','1','American Indian or Alaska Native','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status)  values ('race','2','Asian','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status)  values ('race','3','Black or African American','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status)  values ('race','4','Native Hawaiian or Other Pacific Islander','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status)  values ('race','5','White','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status)  values ('race','8','Client does not know','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status)  values ('race','9','Client refused','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status)  values ('race','99','Data not collected','ACTIVE');	

INSERT INTO "v2020".hmis_type (name,status,value,description) values ('housingType','ACTIVE','1','Site-based - single site'); 
 INSERT INTO "v2020".hmis_type (name,status,value,description) values ('housingType','ACTIVE','2','Site-based - clustered/multiple sites'); 
 INSERT INTO "v2020".hmis_type (name,status,value,description) values ('housingType','ACTIVE','3','Tenant-based - scattered site');


 INSERT INTO "v2020".hmis_type (name,status,value,description) values ('projecttype','ACTIVE','1','Emergency Shelter'); 
 INSERT INTO "v2020".hmis_type (name,status,value,description) values ('projecttype','ACTIVE','2','Transitional Housing'); 
 INSERT INTO "v2020".hmis_type (name,status,value,description) values ('projecttype','ACTIVE','3','PH - Permanent Supportive Housing (disability required for entry)');
 INSERT INTO "v2020".hmis_type (name,status,value,description) values ('projecttype','ACTIVE','4','Street Outreach'); 
 INSERT INTO "v2020".hmis_type (name,status,value,description) values ('projecttype','ACTIVE','6','Services Only');
 INSERT INTO "v2020".hmis_type (name,status,value,description) values ('projecttype','ACTIVE','7','Other'); 
 INSERT INTO "v2020".hmis_type (name,status,value,description) values ('projecttype','ACTIVE','8','Safe Haven'); 
 INSERT INTO "v2020".hmis_type (name,status,value,description) values ('projecttype','ACTIVE','9','PH – Housing Only');
 INSERT INTO "v2020".hmis_type (name,status,value,description) values ('projecttype','ACTIVE','10','PH – Housing with Services (no disability required for entry)');
 INSERT INTO "v2020".hmis_type (name,status,value,description) values ('projecttype','ACTIVE','11','Day Shelter');
 INSERT INTO "v2020".hmis_type (name,status,value,description) values ('projecttype','ACTIVE','12','Homelessness Prevention'); 
 INSERT INTO "v2020".hmis_type (name,status,value,description) values ('projecttype','ACTIVE','13','PH - Rapid Re-Housing');
 INSERT INTO "v2020".hmis_type (name,status,value,description) values ('projecttype','ACTIVE','14','Coordinated Assessment');
 

 INSERT INTO "v2020".hmis_type (name,status,value,description) values ('reason_not_enrolled','ACTIVE','1','Client was found ineligible for PATH');
 INSERT INTO "v2020".hmis_type (name,status,value,description) values ('reason_not_enrolled','ACTIVE','2','Client was not enrolled for other reason(s)');
  INSERT INTO "v2020".hmis_type (name,value,description,status)  values ('reason_not_enrolled','99','Data not collected','ACTIVE'); 


 INSERT INTO "v2020".hmis_type (name,status,value,description) values ('projecttype','ACTIVE','12','Contact');
 INSERT INTO "v2020".hmis_type (name,status,value,description) values ('projecttype','ACTIVE','14','Services Provided');
 INSERT INTO "v2020".hmis_type (name,status,value,description) values ('projecttype','ACTIVE','15','Financial Assistance');
 INSERT INTO "v2020".hmis_type (name,status,value,description) values ('projecttype','ACTIVE','16','Referrals Provided');
  INSERT INTO "v2020".hmis_type (name,status,value,description) values ('projecttype','ACTIVE','141','PATH service');
  INSERT INTO "v2020".hmis_type (name,status,value,description) values ('projecttype','ACTIVE','142','RHY service');
  INSERT INTO "v2020".hmis_type (name,status,value,description) values ('projecttype','ACTIVE','143','HOPWA service');
  INSERT INTO "v2020".hmis_type (name,status,value,description) values ('projecttype','ACTIVE','144','SSVF service');
  INSERT INTO "v2020".hmis_type (name,status,value,description) values ('projecttype','ACTIVE','151','HOPWA financial assistance');
  INSERT INTO "v2020".hmis_type (name,status,value,description) values ('projecttype','ACTIVE','152','SSVF financial assistance');
  INSERT INTO "v2020".hmis_type (name,status,value,description) values ('projecttype','ACTIVE','161','PATH referral');
  INSERT INTO "v2020".hmis_type (name,status,value,description) values ('projecttype','ACTIVE','162','RHY referral');
  INSERT INTO "v2020".hmis_type (name,status,value,description) values ('projecttype','ACTIVE','200','Bed night');
  
 
 INSERT INTO "v2020".hmis_type (name,status,value,description) values ('referral_source','ACTIVE','1','Self-Referral');
 INSERT INTO "v2020".hmis_type (name,status,value,description) values ('referral_source','ACTIVE','2','Individual: Parent/Guardian');
 INSERT INTO "v2020".hmis_type (name,status,value,description) values ('referral_source','ACTIVE','3','Individual: Relative or Friend');
 INSERT INTO "v2020".hmis_type (name,status,value,description) values ('referral_source','ACTIVE','4','Individual: Other Adult or Youth'); 
 INSERT INTO "v2020".hmis_type (name,status,value,description) values ('referral_source','ACTIVE','5','Individual: Partner/Spouse');
 INSERT INTO "v2020".hmis_type (name,status,value,description) values ('referral_source','ACTIVE','6','Individual: Foster Parent');
 INSERT INTO "v2020".hmis_type (name,status,value,description) values ('referral_source','ACTIVE','7','Outreach Project: FYSB');  	
 INSERT INTO "v2020".hmis_type (name,status,value,description) values ('referral_source','ACTIVE','10','Outreach Project: Other');
 INSERT INTO "v2020".hmis_type (name,status,value,description) values ('referral_source','ACTIVE','11','Temporary Shelter: FYSB Basic Center Project');
 INSERT INTO "v2020".hmis_type (name,status,value,description) values ('referral_source','ACTIVE','12','Temporary Shelter: Other Youth Only Emergency Shelter');
 INSERT INTO "v2020".hmis_type (name,status,value,description) values ('referral_source','ACTIVE','13','Temporary Shelter: Emergency Shelter for Families');
 INSERT INTO "v2020".hmis_type (name,status,value,description) values ('referral_source','ACTIVE','14','Temporary Shelter: Emergency Shelter for Individuals');
 INSERT INTO "v2020".hmis_type (name,status,value,description) values ('referral_source','ACTIVE','15','Temporary Shelter: Domestic Violence Shelter');
 INSERT INTO "v2020".hmis_type (name,status,value,description) values ('referral_source','ACTIVE','16','Temporary Shelter: Safe Place');
 INSERT INTO "v2020".hmis_type (name,status,value,description) values ('referral_source','ACTIVE','17','Temporary Shelter: Other');
 INSERT INTO "v2020".hmis_type (name,status,value,description) values ('referral_source','ACTIVE','18','Residential Project: FYSB Transitional Living Project'); 
 INSERT INTO "v2020".hmis_type (name,status,value,description) values ('referral_source','ACTIVE','19','Residential Project: Other Transitional Living Project');
 INSERT INTO "v2020".hmis_type (name,status,value,description) values ('referral_source','ACTIVE','20','Residential Project: Group Home'); 
 INSERT INTO "v2020".hmis_type (name,status,value,description) values ('referral_source','ACTIVE','21','Residential Project: Independent Living Project'); 
 INSERT INTO "v2020".hmis_type (name,status,value,description) values ('referral_source','ACTIVE','22','Residential Project: Job Corps'); 
 INSERT INTO "v2020".hmis_type (name,status,value,description) values ('referral_source','ACTIVE','23','Residential Project: Drug Treatment Center');
 INSERT INTO "v2020".hmis_type (name,status,value,description) values ('referral_source','ACTIVE','24','Residential Project: Treatment Center');
 INSERT INTO "v2020".hmis_type (name,status,value,description) values ('referral_source','ACTIVE','25','Residential Project: Educational Institute'); 
 INSERT INTO "v2020".hmis_type (name,status,value,description) values ('referral_source','ACTIVE','26','Residential Project: Other Agency project'); 
 INSERT INTO "v2020".hmis_type (name,status,value,description) values ('referral_source','ACTIVE','27','Residential Project: Other Project'); 
 INSERT INTO "v2020".hmis_type (name,status,value,description) values ('referral_source','ACTIVE','28','Hotline: National Runaway Switchboard'); 
 INSERT INTO "v2020".hmis_type (name,status,value,description) values ('referral_source','ACTIVE','29','Hotline: Other'); 
 INSERT INTO "v2020".hmis_type (name,status,value,description) values ('referral_source','ACTIVE','30','Other Agency: Child Welfare/CPS'); 
 INSERT INTO "v2020".hmis_type (name,status,value,description) values ('referral_source','ACTIVE','31','Other Agency: Non-Residential Independent Living Project');
 INSERT INTO "v2020".hmis_type (name,status,value,description) values ('referral_source','ACTIVE','32','Other Project Operated by your Agency');
 INSERT INTO "v2020".hmis_type (name,status,value,description) values ('referral_source','ACTIVE','33','Other Youth Services Agency');
 INSERT INTO "v2020".hmis_type (name,status,value,description) values ('referral_source','ACTIVE','34','Juvenile Justice');
 INSERT INTO "v2020".hmis_type (name,status,value,description) values ('referral_source','ACTIVE','35','Law Enforcement/ Police');
 INSERT INTO "v2020".hmis_type (name,status,value,description) values ('referral_source','ACTIVE','36','Religious Organization');
 INSERT INTO "v2020".hmis_type (name,status,value,description) values ('referral_source','ACTIVE','37','Mental Hospital');
 INSERT INTO "v2020".hmis_type (name,status,value,description) values ('referral_source','ACTIVE','38','School');
 INSERT INTO "v2020".hmis_type (name,status,value,description) values ('referral_source','ACTIVE','39','Other Organization');
 INSERT INTO "v2020".hmis_type (name,value,description,status)  values ('referral_source','8','Client does not know','ACTIVE'); 
 INSERT INTO "v2020".hmis_type (name,value,description,status)  values ('referral_source','9','Client refused','ACTIVE');  
 INSERT INTO "v2020".hmis_type (name,value,description,status)  values ('referral_source','99','Data not collected','ACTIVE');  
 
  INSERT INTO "v2020".hmis_type (name,status,value,description) values ('relationshiptohoh','ACTIVE','1','Self (head of household)'); 
  INSERT INTO "v2020".hmis_type (name,status,value,description) values ('relationshiptohoh','ACTIVE','2','Head of household’s child'); 
  INSERT INTO "v2020".hmis_type (name,status,value,description) values ('relationshiptohoh','ACTIVE','3','Head of household’s spouse or partner');
  INSERT INTO "v2020".hmis_type (name,status,value,description) values ('relationshiptohoh','ACTIVE','4','Head of household’s other relation member (other relation to head of household)');
  INSERT INTO "v2020".hmis_type (name,status,value,description) values ('relationshiptohoh','ACTIVE','5','Other: non-relation member');
  INSERT INTO "v2020".hmis_type (name,value,description,status)  values ('relationshiptohoh','99','Data not collected','ACTIVE');
   
 
  INSERT INTO "v2020".hmis_type (name,status,value,description) values ('referral_source','ACTIVE','12','Staying or living in a family member’s room, apartment or house');          
  INSERT INTO "v2020".hmis_type (name,status,value,description) values ('referral_source','ACTIVE','13','Staying or living in a friend’s room, apartment or house');
  INSERT INTO "v2020".hmis_type (name,status,value,description) values ('referral_source','ACTIVE','14','Hotel or motel paid for without emergency shelter voucher'); 
  INSERT INTO "v2020".hmis_type (name,status,value,description) values ('referral_source','ACTIVE','15','Foster care home or foster care group home');                         
  INSERT INTO "v2020".hmis_type (name,status,value,description) values ('referral_source','ACTIVE','16','Place not meant for habitation (e.g. a vehicle, an abandoned building, bus/train/subway station/airport or anywhere outside)');
  INSERT INTO "v2020".hmis_type (name,status,value,description) values ('referral_source','ACTIVE','17','Other');
  INSERT INTO "v2020".hmis_type (name,status,value,description) values ('referral_source','ACTIVE','18','Safe Haven');
  INSERT INTO "v2020".hmis_type (name,status,value,description) values ('referral_source','ACTIVE','19','Rental by client, with VASH subsidy');
  INSERT INTO "v2020".hmis_type (name,status,value,description) values ('referral_source','ACTIVE','20','Rental by client, with other ongoing housing subsidy');
  INSERT INTO "v2020".hmis_type (name,status,value,description) values ('referral_source','ACTIVE','21','Owned by client, with ongoing housing subsidy'); 
  INSERT INTO "v2020".hmis_type (name,status,value,description) values ('referral_source','ACTIVE','22','Rental by client, no ongoing housing subsidy');
  INSERT INTO "v2020".hmis_type (name,status,value,description) values ('referral_source','ACTIVE','23','Owned by client, no ongoing housing subsidy'); 
  INSERT INTO "v2020".hmis_type (name,status,value,description) values ('referral_source','ACTIVE','24','Long-term care facility or nursing home');
  INSERT INTO "v2020".hmis_type (name,status,value,description) values ('referral_source','ACTIVE','25','Rental by client, with GPD TIP subsidy');
  INSERT INTO "v2020".hmis_type (name,status,value,description) values ('referral_source','ACTIVE','26','Residential project or halfway house with no homeless criteria');
  INSERT INTO "v2020".hmis_type (name,value,description,status)  values ('referral_source','99','Data not collected','ACTIVE');
   
  
  INSERT INTO "v2020".hmis_type (name,value,description,status)  values ('record_type','12','Contact records collected under 2014 HMIS Data Standards v5.1','ACTIVE');
  INSERT INTO "v2020".hmis_type (name,value,description,status)  values ('record_type','13','4.12 Contact records collected under 2020 HMIS Data Standards','ACTIVE');
  INSERT INTO "v2020".hmis_type (name,value,description,status)  values ('record_type','141','P1 Services Provided – PATH','ACTIVE');
  INSERT INTO "v2020".hmis_type (name,value,description,status)  values ('record_type','142','R14 RHY Service Connections','ACTIVE');
  INSERT INTO "v2020".hmis_type (name,value,description,status)  values ('record_type','143','W1 Services Provided – HOPWA','ACTIVE');
  INSERT INTO "v2020".hmis_type (name,value,description,status)  values ('record_type','144','V2 Services Provided – SSVF','ACTIVE');
  INSERT INTO "v2020".hmis_type (name,value,description,status)  values ('record_type','151','W2 Financial Assistance – HOPWA','ACTIVE');
  INSERT INTO "v2020".hmis_type (name,value,description,status)  values ('record_type','152','V3 Financial Assistance – SSVF','ACTIVE');
  INSERT INTO "v2020".hmis_type (name,value,description,status)  values ('record_type','161','P2 Referrals Provided – PATH','ACTIVE');
  INSERT INTO "v2020".hmis_type (name,value,description,status)  values ('record_type','200','4.14  Bed night','ACTIVE');
  INSERT INTO "v2020".hmis_type (name,value,description,status)  values ('record_type','210','V8 HUD-VASH Voucher Tracking','ACTIVE');
  
     INSERT INTO "v2020".hmis_type (name,status,value,description) values ('lengthOfStay','ACTIVE','2','More than one week, but less than one month'); 
     INSERT INTO "v2020".hmis_type (name,status,value,description) values ('lengthOfStay','ACTIVE','3','One to three months'); 
     INSERT INTO "v2020".hmis_type (name,status,value,description) values ('lengthOfStay','ACTIVE','4','More than three months, but less than one year');  
     INSERT INTO "v2020".hmis_type (name,status,value,description) values ('lengthOfStay','ACTIVE','5','One year or longer'); 
     INSERT INTO "v2020".hmis_type (name,status,value,description) values ('lengthOfStay','ACTIVE','8','Client doesn''t know'); 
     INSERT INTO "v2020".hmis_type (name,status,value,description) values ('lengthOfStay','ACTIVE','9','Client refused');
    INSERT INTO "v2020".hmis_type (name,status,value,description) values ('lengthOfStay','ACTIVE','10','One day or less');
    INSERT INTO "v2020".hmis_type (name,status,value,description) values ('lengthOfStay','ACTIVE','11','Two days to one week'); 
   INSERT INTO "v2020".hmis_type (name,value,description,status)  values ('lengthOfStay','99','Data not collected','ACTIVE'); 
 
         INSERT INTO "v2020".hmis_type (name,value,description,status) values ('ssn_data_quality','1','Full SSN reported','ACTIVE');
        INSERT INTO "v2020".hmis_type (name,value,description,status) values   ('ssn_data_quality','2','Approximate or partial SSN reported','ACTIVE');
        INSERT INTO "v2020".hmis_type (name,value,description,status) values    ('ssn_data_quality','8','Client does not know','ACTIVE');
        INSERT INTO "v2020".hmis_type  (name,value,description,status) values  ('ssn_data_quality','9','Client refused','ACTIVE');
        INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('ssn_data_quality','99','Data not collected','ACTIVE');
      
        
        INSERT INTO "v2020".hmis_type (name,status,value,description) values ('subsidyinformation','ACTIVE','1','Without a subsidy');
        INSERT INTO "v2020".hmis_type (name,status,value,description) values ('subsidyinformation','ACTIVE','2','With the subsidy they had at project entry');
   	INSERT INTO "v2020".hmis_type (name,status,value,description) values ('subsidyinformation','ACTIVE','3','With an on-going subsidy acquired since project entry');
   	INSERT INTO "v2020".hmis_type (name,status,value,description) values ('subsidyinformation','ACTIVE','4','Only with financial assistance other than a subsidy'); 
   		INSERT INTO "v2020".hmis_type (name,status,value,description) values ('subsidyinformation','ACTIVE','11','With on-going subsidy'); 
   		INSERT INTO "v2020".hmis_type (name,status,value,description) values ('subsidyinformation','ACTIVE','12','Without an on-going subsidy'); 
   	INSERT INTO "v2020".hmis_type (name,status,value,description) values ('subsidyinformation','ACTIVE','99','Data not collected'); 
   	
   	
   	
   	
   	INSERT INTO "v2020".hmis_type (name,status,value,description) values ('targetpopulation','ACTIVE','1','DV Domestic Violence victims');
   	INSERT INTO "v2020".hmis_type (name,status,value,description) values ('targetpopulation','ACTIVE','3','HIV Persons with HIV/AIDS');
   	INSERT INTO "v2020".hmis_type (name,status,value,description) values ('targetpopulation','ACTIVE','4','NA Not Applicable');
   	
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('generalHealthStatus','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('generalHealthStatus','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('generalHealthStatus','8','Client doesn''t know','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('generalHealthStatus','9','Client refused','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('generalHealthStatus','99','Data not collected','ACTIVE');


INSERT INTO "v2020".hmis_type (name,value,description,status) values ('pregnancyStatus','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('pregnancyStatus','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('pregnancyStatus','8','Client doesn''t know','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('pregnancyStatus','9','Client refused','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('pregnancyStatus','99','Data not collected','ACTIVE');

INSERT INTO "v2020".hmis_type (name,value,description,status) values ('dentalHealthStatus','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('dentalHealthStatus','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('dentalHealthStatus','8','Client doesn''t know','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('dentalHealthStatus','9','Client refused','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('dentalHealthStatus','99','Data not collected','ACTIVE');

INSERT INTO "v2020".hmis_type (name,value,description,status) values ('mentalHealthStatus','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('mentalHealthStatus','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('mentalHealthStatus','8','Client doesn''t know','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('mentalHealthStatus','9','Client refused','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('mentalHealthStatus','99','Data not collected','ACTIVE');


	INSERT INTO "v2020".hmis_type (name,value,description,status) values ('timesHomelesspastthreeyears','1','One time','ACTIVE');
	INSERT INTO "v2020".hmis_type (name,value,description,status) values ('timesHomelesspastthreeyears','2','Two times','ACTIVE');
	INSERT INTO "v2020".hmis_type (name,value,description,status) values ('timesHomelesspastthreeyears','3','Three times','ACTIVE');
	INSERT INTO "v2020".hmis_type (name,value,description,status) values ('timesHomelesspastthreeyears','4','Four or more time​s','ACTIVE');
	INSERT INTO "v2020".hmis_type (name,value,description,status) values  ('timesHomelesspastthreeyears','8','Client does not know','ACTIVE');
	INSERT INTO "v2020".hmis_type  (name,value,description,status) values  ('timesHomelesspastthreeyears','9','Client refused','ACTIVE');
	INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('timesHomelesspastthreeyears','99','Data not collected','ACTIVE');
		       
	insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template) values
('024c9acd-d3e1-4cc4-9800-a9db85edad67','DOBDataQuality','DOBDataQuality','STRING','DROPDOWN',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'dob_data_quality',false,'3.3.2','/v2020/hmistypes/dob_data_quality/values');

	insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template,uri_object_field) values
('024c9acd-d3e1-4cc4-9800-a9db85edad10','Affiliated with a residential project','Affiliated with a residential project','STRING','DROPDOWN',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'residentialaffiliation',false,'2.4.2A','/v2020/projects/{projectid}','project.residentialAffiliation');




	INSERT INTO "v2020".hmis_type (name,value,description,status) values ('trackingmethod','0','Entry/Exit Date','ACTIVE');
	INSERT INTO "v2020".hmis_type (name,value,description,status) values ('trackingmethod','3','Night-by-Night','ACTIVE');
	
	
	INSERT INTO "v2020".hmis_type (name,value,description,status) values ('whenoccurred','1','Within the past three months','ACTIVE');
	INSERT INTO "v2020".hmis_type (name,value,description,status) values ('whenoccurred','2','Three to six months ago (excluding six months exactly)','ACTIVE');
	INSERT INTO "v2020".hmis_type (name,value,description,status) values ('whenoccurred','3','Six months to one year ago (excluding one year exactly)','ACTIVE');
	INSERT INTO "v2020".hmis_type (name,value,description,status) values ('whenoccurred','4','One year ago or more','ACTIVE');
	INSERT INTO "v2020".hmis_type (name,value,description,status) values  ('whenoccurred','8','Client does not know','ACTIVE');
	INSERT INTO "v2020".hmis_type  (name,value,description,status) values  ('whenoccurred','9','Client refused','ACTIVE');
	INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('whenoccurred','99','Data not collected','ACTIVE');
	
	
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('veteran_status','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('veteran_status','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values    ('veteran_status','8','Client does not know','ACTIVE');
INSERT INTO "v2020".hmis_type  (name,value,description,status) values  ('veteran_status','9','Client refused','ACTIVE');
INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('veteran_status','99','Data not collected','ACTIVE');

INSERT INTO "v2020".hmis_type (name,value,description,status) values ('afghanistan_oef','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('afghanistan_oef','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values    ('afghanistan_oef','8','Client does not know','ACTIVE');
INSERT INTO "v2020".hmis_type  (name,value,description,status) values  ('afghanistan_oef','9','Client refused','ACTIVE');
INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('afghanistan_oef','99','Data not collected','ACTIVE');

-- New ENUMS Insert Starts
INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('percentami','1','Less than 30%','ACTIVE');
INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('percentami','2','30% to 50%','ACTIVE');
INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('percentami','3','Greater than 50%','ACTIVE');
INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('percentami','99','Data not collected','ACTIVE');

INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('connection_with_soar','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('connection_with_soar','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('connection_with_soar','8','Client doesnt know','ACTIVE');
INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('connection_with_soar','9','Client refused','ACTIVE');
INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('connection_with_soar','99','Data not collected','ACTIVE');

INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('contact_location','1','Place not meant for habitation','ACTIVE');
INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('contact_location','2','Service setting, non-residential','ACTIVE');
INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('contact_location','3','Service setting, residential','ACTIVE');

INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('project_completion_status','1','Completed project','ACTIVE');
INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('project_completion_status','2','Youth voluntarily left early','ACTIVE');
INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('project_completion_status','3','Youth was expelled or otherwise involuntarily discharged from project','ACTIVE');
INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('project_completion_status','99','Data Not Collected','ACTIVE');

INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('early_exit_reason','1','Criminal activity/destruction of property/violence','ACTIVE');
INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('early_exit_reason','2','Non-compliance with project rules','ACTIVE');
INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('early_exit_reason','3','Non-payment of rent/occupancy charge','ACTIVE');
INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('early_exit_reason','4','Reached maximum time allowed by project','ACTIVE');
INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('early_exit_reason','5','Project terminated','ACTIVE');
INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('early_exit_reason','6','Unknown/disappeared','ACTIVE');
INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('early_exit_reason','99','Data not collected','ACTIVE');

insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template) values
('024c9acd-d3e1-4cc4-9800-a9db85edad92','InsufficientIncome','InsufficientIncome','STRING','DROPDOWN',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'insufficient_income_to_support_youth',false,'R13.22','/v2020/hmistypes/InsufficientIncome/values');


INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('insufficient_income_to_support_youth','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('insufficient_income_to_support_youth','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('insufficient_income_to_support_youth','99','Data Not Collected','ACTIVE');


insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template) values
('024c9acd-d3e1-4cc4-9800-a9db85edad91','AlcoholDrugAbuseFam','AlcoholDrugAbuseFam','STRING','DROPDOWN',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'alcohol_drug_abuse_family_mbr',false,'R13.21','/v2020/hmistypes/AlcoholDrugAbuseFam/values');


INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('alcohol_drug_abuse_family_mbr','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('alcohol_drug_abuse_family_mbr','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('alcohol_drug_abuse_family_mbr','99','Data Not Collected','ACTIVE');

insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template) values
('024c9acd-d3e1-4cc4-9800-a9db85edad90','PhysicalDisabilityFam','PhysicalDisabilityFam','STRING','DROPDOWN',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'physical_disability_family_mbr',false,'R13.21','/v2020/hmistypes/PhysicalDisabilityFam/values');


INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('physical_disability_family_mbr','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('physical_disability_family_mbr','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('physical_disability_family_mbr','99','Data Not Collected','ACTIVE');

insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template) values
('024c9acd-d3e1-4cc4-9800-a9db85edad89','MentalHealthIssuesFam','MentalHealthIssuesFam','STRING','DROPDOWN',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'mental_health_issues_family_mbrily_mbr',false,'R13.11','/v2020/hmistypes/MentalHealthIssuesFam/values');



INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('mental_health_issues_family_mbrily_mbr','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('mental_health_issues_family_mbrily_mbr','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('mental_health_issues_family_mbrily_mbr','99','Data Not Collected','ACTIVE');

INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('unemployement_family_mbr','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('unemployement_family_mbr','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('unemployement_family_mbr','99','Data Not Collected','ACTIVE');

insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template) values
('024c9acd-d3e1-4cc4-9800-a9db85edad88','UnemploymentFam','UnemploymentFam','STRING','DROPDOWN',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'unemployement_family_mbr',false,'R13.9','/v2020/hmistypes/UnemploymentFam/values');




INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('incarcerated_parent','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('incarcerated_parent','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('incarcerated_parent','99','Data Not Collected','ACTIVE');


INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('sexual_orientation','1','Heterosexual','ACTIVE');
INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('sexual_orientation','2','Gay','ACTIVE');
INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('sexual_orientation','3','Lesbian','ACTIVE');
INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('sexual_orientation','4','Bisexual','ACTIVE');
INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('sexual_orientation','5','Questioning / Unsure','ACTIVE');
INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('sexual_orientation','8','Client doesnt know','ACTIVE');
INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('sexual_orientation','9','Client refused','ACTIVE');
INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('sexual_orientation','99','Data Not Collected','ACTIVE');

insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template) values
('024c9acd-d3e1-4cc4-9800-a9db85edad82','SexualOrientation','SexualOrientation','STRING','DROPDOWN',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'sexual_orientation',false,'R3.1','/v2020/hmistypes/SexualOrientation/values');


INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('years_child_welfr_forest_care','1','Less than one year','ACTIVE');
INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('years_child_welfr_forest_care','2','Less than one year','ACTIVE');
INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('years_child_welfr_forest_care','3','3 to 5 or more years','ACTIVE');

insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template) values
('024c9acd-d3e1-4cc4-9800-a9db85edad84','ChildWelfareYears','ChildWelfareYears','STRING','DROPDOWN',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'years_child_welfr_forest_care',false,'R11.A','/v2020/hmistypes/ChildWelfareYears/values');


INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('months_child_welfr_forest_care','1','Less than one year','ACTIVE');
INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('months_child_welfr_forest_care','2','Less than one year','ACTIVE');
INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('months_child_welfr_forest_care','3','3 to 5 or more years','ACTIVE');


insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template) values
('024c9acd-d3e1-4cc4-9800-a9db85edad85','ChildWelfareMonths','ChildWelfareMonths','STRING','DROPDOWN',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'months_child_welfr_forest_care',false,'R11.B','/v2020/hmistypes/ChildWelfareMonths/values');



INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('years_juvenile_justice','1','Less than one year','ACTIVE');
INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('years_juvenile_justice','2','Less than one year','ACTIVE');
INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('years_juvenile_justice','3','3 to 5 or more years','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('years_juvenile_justice','99','Data not collected','ACTIVE');

INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('formerly_ward_child_welfr_forest_care','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('formerly_ward_child_welfr_forest_care','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('formerly_ward_child_welfr_forest_care','8','Client doesnt know','ACTIVE');
INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('formerly_ward_child_welfr_forest_care','9','Client refused','ACTIVE');
INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('formerly_ward_child_welfr_forest_care','99','Data Not Collected','ACTIVE');

insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template) values
('024c9acd-d3e1-4cc4-9800-a9db85edad83','FormerWardChildWelfare','FormerWardChildWelfare','STRING','DROPDOWN',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'formerly_ward_child_welfr_forest_care',false,'R11.1','/v2020/hmistypes/FormerWardChildWelfare/values');


insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template) values
('024c9acd-d3e1-4cc4-9800-a9db85edad86','FormerWardJuvenileJustice','FormerWardJuvenileJustice','STRING','DROPDOWN',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'formerly_ward_of_juvenile_justice',false,'R12.1','/v2020/hmistypes/FormerWardJuvenileJustice/values');



INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('formerly_ward_of_juvenile_justice','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('formerly_ward_of_juvenile_justice','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('formerly_ward_of_juvenile_justice','8','Client doesnt know','ACTIVE');
INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('formerly_ward_of_juvenile_justice','9','Client refused','ACTIVE');
INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('formerly_ward_of_juvenile_justice','99','Data Not Collected','ACTIVE');

INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('exchange_for_sex_past_three_months','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('exchange_for_sex_past_three_months','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('exchange_for_sex_past_three_months','8','Client doesnt know','ACTIVE');
INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('exchange_for_sex_past_three_months','9','Client refused','ACTIVE');
INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('exchange_for_sex_past_three_months','99','Data Not Collected','ACTIVE');


INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('exchange_for_sex','8','Client doesnt know','ACTIVE');
INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('exchange_for_sex','9','Client refused','ACTIVE');


INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('coerced_to_continue_work','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('coerced_to_continue_work','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('coerced_to_continue_work','8','Client doesnt know','ACTIVE');
INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('coerced_to_continue_work','9','Client refused','ACTIVE');
INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('coerced_to_continue_work','99','Data Not Collected','ACTIVE');

insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template) values
('024c9acd-d3e1-4cc4-9800-a9db85edaf73','WorkplacePromiseDifference','WorkplacePromiseDifference','STRING','DROPDOWN',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'work_place_promise_difference',false,'R16.2','/v2020/hmistypes/WorkplacePromiseDifference/values');



INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('work_place_promise_difference','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('work_place_promise_difference','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('work_place_promise_difference','8','Client doesnt know','ACTIVE');
INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('work_place_promise_difference','9','Client refused','ACTIVE');
INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('work_place_promise_difference','99','Data Not Collected','ACTIVE');

INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('work_place_violence_threats','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('work_place_violence_threats','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('work_place_violence_threats','8','Client doesnt know','ACTIVE');
INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('work_place_violence_threats','9','Client refused','ACTIVE');
INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('work_place_violence_threats','99','Data Not Collected','ACTIVE');

INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('count_of_exchange_for_sex','1','1-3','ACTIVE');
INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('count_of_exchange_for_sex','2','4-7','ACTIVE');
INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('count_of_exchange_for_sex','3','8-11','ACTIVE');
INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('count_of_exchange_for_sex','4','12 or more','ACTIVE');
INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('count_of_exchange_for_sex','8','Client doesnt know','ACTIVE');
INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('count_of_exchange_for_sex','9','Client refused','ACTIVE');
INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('count_of_exchange_for_sex','99','Data Not Collected','ACTIVE');

INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('asked_or_forced_to_exchange_for_sex','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('asked_or_forced_to_exchange_for_sex','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('asked_or_forced_to_exchange_for_sex','8','Client doesnt know','ACTIVE');
INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('asked_or_forced_to_exchange_for_sex','9','Client refused','ACTIVE');
INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('asked_or_forced_to_exchange_for_sex','99','Data Not Collected','ACTIVE');

INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('geography_type','1','Urban','ACTIVE');
INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('geography_type','2','Suburban','ACTIVE');
INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('geography_type','3','Rural','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('geography_type','99','Data not collected','ACTIVE');


INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('cm_exit_reason','1','Accomplished goals and/or obtained services and no longer needs CM','ACTIVE');
INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('cm_exit_reason','2','Transferred to another HUD-VASH program site','ACTIVE');
INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('cm_exit_reason','3','Found/chose other housing','ACTIVE');
INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('cm_exit_reason','4','Did not comply with HUD-VASH CM','ACTIVE');
INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('cm_exit_reason','5','Eviction and/or other housing related issues','ACTIVE');
INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('cm_exit_reason','6','Unhappy with HUD-VASH housing','ACTIVE');
INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('cm_exit_reason','7','No longer financially eligible for HUD/VASH voucher','ACTIVE');
INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('cm_exit_reason','8','No longer interested in participating in this program','ACTIVE');
INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('cm_exit_reason','9','Veteran cannot be located','ACTIVE');
INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('cm_exit_reason','10','Veteran too ill to participate at this time','ACTIVE');
INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('cm_exit_reason','11','Veteran is incarcerated','ACTIVE');
INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('cm_exit_reason','12','Veteran is deceased','ACTIVE');
INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('cm_exit_reason','13','Other','ACTIVE');
INSERT INTO "v2020".hmis_type  (name,value,description,status) values ('cm_exit_reason','99','Data not collected','ACTIVE');

-- New ENUMS Insert Ends

create table "v2020".source
(
id uuid not null,
  export text,
  sourcetype text,
  softwarename text,
  softwareVersion character varying(50),
  sourceContactEmail	text,
  sourceContactExtension	text,
  sourceContactFirst	character varying(50),
  sourceContactLast	character varying(50),
  sourceContactPhone	character varying(12),
  sourceID	text,
  sourceName	character varying(50),
  "project_group_code" character varying(8),
  "date_created" timestamp,
  "date_created_from_source" timestamp,
  "date_updated_from_source" timestamp,
  "date_updated" timestamp,
  "user_id" uuid,
  export_id uuid,
  parent_id uuid,
  version integer,source_system_id text,
  deleted boolean DEFAULT false,active boolean DEFAULT true,  
  sync boolean DEFAULT false,
  constraint "source_pkey" primary key (id)
     )
with (
  oids=false
);

create table "v2020".export
(
  id uuid not null,
  export_date  timestamp,
  start_date  timestamp,
  end_date  timestamp,
  exportPeriodType text,
  exportDirective text,
  source_id uuid,
  "project_group_code" character varying(8),
  "date_created" timestamp,
  "date_created_from_source" timestamp,
  "date_updated_from_source" timestamp,
  "date_updated" timestamp,
  "user_id" uuid,
    export_id uuid,
  parent_id uuid,
  version integer,source_system_id text,
  deleted boolean DEFAULT false,active boolean DEFAULT true,  
  sync boolean DEFAULT false,
   constraint "export_pkey" primary key (id),
      CONSTRAINT source_fkey FOREIGN KEY (source_id)
      REFERENCES v2020.source (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
     )
with (
  oids=false
);



create table "v2020".organization
(
	id uuid not null,  
	organizationname text,
	organizationcommonname text,
   "project_group_code" character varying(8),
   "date_created" timestamp,
   "date_created_from_source" timestamp,
   "date_updated_from_source" timestamp,
   "date_updated" timestamp,
   "user_id" uuid,
   export_id uuid,
   parent_id uuid,
   version integer,source_system_id text,
   deleted boolean DEFAULT false,active boolean DEFAULT true, 
   sync boolean DEFAULT false,
  	  constraint "organization_pkey" primary key (id)
)
with (
  oids=false
);


CREATE TABLE  "v2020".project
(
	  id uuid NOT NULL,
	  project_id character varying(8),
	  projectname text,
	  continuumproject "v2020".no_yes,
	  hmisparticipatingproject "v2020".no_yes,
	  projecttype "v2020".project_type,
	  pitcount integer,
	  residentialaffiliation integer, --Sandeep change to to no_yes
	  operatingstartdate timestamp,
	  operatingenddate timestamp,
	  trackingmethod "v2020".tracking_method,
	  targetpopulation "v2020".target_population_type,
	  victimServiceProvider "v2020".no_yes,
	  housingType  "v2020".housingType,
	  projectcommonname text,
	  organizationid uuid,
	    "date_created" timestamp,
   "date_created_from_source" timestamp,
   "date_updated_from_source" timestamp,
   "date_updated" timestamp,
      "project_group_code" character varying(8),
	  user_id uuid,
	  export_id uuid,
	  parent_id uuid,
	  version integer,source_system_id text,
	  deleted boolean DEFAULT false,active boolean DEFAULT true, 
	  sync boolean DEFAULT false,
	  	  CONSTRAINT "project_pk" PRIMARY KEY (id),
	      CONSTRAINT "organization_project_fkey" FOREIGN KEY (organizationid)
	      REFERENCES v2020.organization (id) MATCH SIMPLE
	      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);

-- DROP TABLE "v2020"."client";
CREATE TABLE "v2020".client
(
  "id" uuid NOT NULL,
  "dedup_client_id" uuid,
  "first_name" character(50),
  "middle_name" character(50),
  "last_name" character(50),
  "name_suffix" character(50),
  "name_data_quality" "v2020".name_data_quality,
	dob BYTEA, 
	ssn BYTEA,
  "ssn_data_quality" "v2020".ssn_data_quality,
  "dob_data_quality" "v2020".dob_data_quality,
  "gender" "v2020".gender,
--  "other_gender" text,
  "ethnicity" "v2020".ethnicity,
  "race"  "v2020".race,
  "veteran_status" "v2020".veteran_status,
  "project_group_code" character varying(8),
  "date_created" timestamp,
  "date_created_from_source" timestamp,
  "date_updated_from_source" timestamp,
  "date_updated" timestamp,
  "user_id" uuid,
  export_id uuid,
  parent_id uuid,
  version integer,source_system_id text,
  deleted boolean DEFAULT false,active boolean DEFAULT true,  
  sync boolean DEFAULT false,
      


  	  CONSTRAINT client_pk PRIMARY KEY ("id")
      )
WITH (
  OIDS=FALSE
);
-- Table: "v2020"."client"

-- veteran_info changed to client_veteran_info
CREATE TABLE "v2020".client_veteran_info
(
  "id" uuid NOT NULL,
  "year_entrd_service" integer,
  "year_seperated" integer,
  "world_war_2" "v2020".five_val_dk_refused,
  "korean_war" "v2020".five_val_dk_refused,
  "vietnam_war" "v2020".five_val_dk_refused,
  "desert_storm" "v2020".five_val_dk_refused,
  "afghanistan_oef" "v2020".afghanistanoef,
  "iraq_oif" "v2020".five_val_dk_refused,
  "iraq_ond" "v2020".five_val_dk_refused,
  "other_theater" "v2020".five_val_dk_refused,
  "military_branch" "v2020".military_branch,
  "discharge_status" "v2020".discharge_status,
  "project_group_code" character varying(8),
  "date_created" timestamp,
  "date_created_from_source" timestamp,
  "date_updated_from_source" timestamp,
  "date_updated" timestamp,
  "user_id" uuid,
  "client_id" uuid,
  export_id uuid,
  parent_id uuid,
  version integer,source_system_id text,
  deleted boolean DEFAULT false,active boolean DEFAULT true,  
  sync boolean DEFAULT false,  
      
  	  CONSTRAINT veteran_info_pk PRIMARY KEY ("id"),
  	  CONSTRAINT veteran_info_client_fk FOREIGN KEY ("client_id")
      REFERENCES "v2020".client ("id") MATCH SIMPLE
)
WITH (
  OIDS=FALSE
);

CREATE TABLE "v2020".enrollment
(
  	id uuid NOT NULL,
	projectentryid uuid,
	entrydate timestamp,
	householdid text,
	relationshiptohoh "v2020".relationship_to_head_of_household,
	livingSituation "v2020".livingSituation,
	lengthOfStay "v2020".lengthOfStay,
	losunderthreshold "v2020".no_yes, 
	previousStreetESSH "v2020".no_yes,
	disablingCondition "v2020".five_val_dk_refused,
	dateToStreetESSH timestamp,
	timesHomelesspastthreeyears "v2020".times_homeless_past_3_years,
	monthsHomelessPastThreeYears "v2020".months_homeless_past_3_years,
	projectid uuid,
	client_id uuid,
	project_group_code character varying(8),
	date_created timestamp,
	date_updated timestamp,
	"date_created_from_source" timestamp,
	"date_updated_from_source" timestamp,
	user_id uuid,
	export_id uuid,
	parent_id uuid,
	chronicHomeless boolean DEFAULT false,
	version integer,source_system_id text,
	deleted boolean DEFAULT false,active boolean DEFAULT true, 
	sync boolean DEFAULT false,
	source character varying(56) DEFAULT 2020,
  		CONSTRAINT "enrollment_pkey" PRIMARY KEY (id),
    	CONSTRAINT enrollment_client_fk FOREIGN KEY ("client_id")
      	REFERENCES "v2020".client ("id") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
      	CONSTRAINT enrollment_project_fk FOREIGN KEY ("projectid")
      	REFERENCES "v2020".project ("id") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);




CREATE TABLE "v2020".path_status
(
  "id" uuid NOT NULL,
  "date_of_status" timestamp,
  "client_enrolled_in_path" bigint, --sandeep change this to fk-5
  "reason_not_enrolled"  "v2020".reason_not_enrolled,
  "enrollmentid" uuid,
  "project_group_code" character varying(8),
  "date_created" timestamp,
  "date_created_from_source" timestamp,
  "date_updated_from_source" timestamp,
  "date_updated" timestamp,
  "user_id" uuid,
  export_id uuid,
  parent_id uuid,
  version integer,source_system_id text,
  deleted boolean DEFAULT false,active boolean DEFAULT true, 
  sync boolean DEFAULT false,  
      


	  CONSTRAINT path_status_pk PRIMARY KEY ("id"),
	  CONSTRAINT "enrollment_path_status_fk_key" FOREIGN KEY ("enrollmentid")
      REFERENCES v2020.enrollment ("id") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);


CREATE TABLE "v2020".entrySSVF
(
	"id" uuid NOT NULL,
	"enrollmentid" uuid,
	"percentami"  "v2020".percentAMI,
	last_permanent_street character(50),
	last_permanent_city character(50),
	last_permanent_state character(50),
	last_permanent_zip character(50),
	address_data_quality "v2020".address_data_quality,
	urgent_referral "v2020".no_yes,
	timeToHousingLoss "v2020".timeToHousingLoss,
	zeroincome "v2020".no_yes,
	annualpercentami "v2020".annualpercentami,
	financialchange "v2020".no_yes,
	householdchange "v2020".no_yes,
	evictionhistory "v2020".evictionhistory,
	subsidyatrisk "v2020".no_yes,
	literalHomelessHistory "v2020".literalHomelessHistory,
	disablehoh "v2020".no_yes,
	criminalrecord "v2020".no_yes,
	sexoffender "v2020".no_yes,
	dependendunder6 "v2020".no_yes,
	singleparent "v2020".no_yes,
	hh5plus "v2020".no_yes,
	iraqafghanistan "v2020".no_yes,
	femvet "v2020".no_yes,
	thresholdscore integer,
	hp_screen_score integer,
	vamc_staction character(50),
	"project_group_code" character varying(8),
  	"date_created" timestamp,
  	"date_created_from_source" timestamp,
  	"date_updated_from_source" timestamp,
  	"date_updated" timestamp,
  	"user_id" uuid,
  	export_id uuid,
  	parent_id uuid,
  	version integer,source_system_id text,
  	deleted boolean DEFAULT false,active boolean DEFAULT true, 
  	sync boolean DEFAULT false,  
  	  CONSTRAINT entrySSVF_pk PRIMARY KEY ("id"),
	  CONSTRAINT "enrollment_entrySSVF_fk_key" FOREIGN KEY ("enrollmentid")
      REFERENCES v2020.enrollment ("id") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);	

CREATE TABLE "v2020".entryRHY
(
	"id" uuid NOT NULL,
	"enrollmentid" uuid,
	"sexual_orientation" "v2020".sexual_orientation,
	"unemployement_family_mbr" "v2020".unemployement_family_mbr,
	"mental_health_issues_family_mbrily_mbr" "v2020".mental_health_issues_family_mbrily_mbr,
	"physical_disability_family_mbr" "v2020".physical_disability_family_mbr,
	"alcohol_drug_abuse_family_mbr" "v2020".alcohol_drug_abuse_family_mbr,
	"insufficient_income_to_support_youth" "v2020".insufficient_income_to_support_youth,
	"incarcerated_parent" "v2020".incarcerated_parent,
	"formerly_ward_of_juvenile_justice" "v2020".formerly_ward_of_juvenile_justice,
	"years_juvenile_justice" "v2020".years_juvenile_justice,
	"months_juvenile_justice" integer, -- Sandeep change this to yes no
	"formerly_ward_child_welfr_forest_care" "v2020".formerly_ward_child_welfr_forest_care,
	"years_child_welfr_forest_care" "v2020".years_child_welfr_forest_care,
	months_child_welfr_forest_care integer,
	referral_source "v2020".referral_source,
	count_out_reach_referral_approaches integer,
	 information_date timestamp,
 	 "datacollectionstage" "v2020".datacollectionstage,
	"project_group_code" character varying(8),
  	"date_created" timestamp,
  	"date_created_from_source" timestamp,
  	"date_updated_from_source" timestamp,
  	"date_updated" timestamp,
  	"user_id" uuid,
  	export_id uuid,
  	parent_id uuid,
  	version integer,source_system_id text,
  	deleted boolean DEFAULT false,active boolean DEFAULT true, 
  	sync boolean DEFAULT false,  
  	  CONSTRAINT entryRHY_pk PRIMARY KEY ("id"),
	  CONSTRAINT "enrollment_entryRHY_fk_key" FOREIGN KEY ("enrollmentid")
      REFERENCES v2020.enrollment ("id") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);	

CREATE TABLE "v2020".enrollment_coc
(
	  id uuid NOT NULL,
  	  enrollmentid uuid,
	  coc_code character(20),
	  householdid text,
	  information_date timestamp,
	  "datacollectionstage" "v2020".datacollectionstage,
	  project_group_code character varying(8),
	  date_created timestamp,
	  date_updated timestamp,
	  "date_created_from_source" timestamp,
  	  "date_updated_from_source" timestamp,
	  user_id uuid,
	  export_id uuid,
	  parent_id uuid,
	  version integer,source_system_id text,
	  deleted boolean DEFAULT false,active boolean DEFAULT true, 
	  sync boolean DEFAULT false,
 		CONSTRAINT "enrollment_coc_pkey" PRIMARY KEY ("id"),
  		CONSTRAINT "enrollment_coc_fk_key" FOREIGN KEY ("enrollmentid")
      	REFERENCES v2020.enrollment ("id") MATCH SIMPLE
      	ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);


CREATE TABLE "v2020".service_fa_referral
(
  "id" uuid NOT NULL,
  "enrollmentid" uuid,
  dateProvided timestamp,
  record_type "v2020".record_type,
  type_provided integer,
  other_type_provided text,
  sub_type_provided integer,
  fa_amount numeric(10,2),
  referral_outcome integer,
  "project_group_code" character varying(8),
  "date_created" timestamp,
  "date_created_from_source" timestamp,
  "date_updated_from_source" timestamp,
  "date_updated" timestamp,
  "user_id" uuid,
  export_id uuid,
  parent_id uuid,
  version integer,source_system_id text,
  deleted boolean DEFAULT false,active boolean DEFAULT true, 
  sync boolean DEFAULT false,
   	CONSTRAINT service_fa_referral_pk PRIMARY KEY ("id"),
	CONSTRAINT "service_fa_referral_fk_key" FOREIGN KEY ("enrollmentid")
	REFERENCES v2020.enrollment ("id") MATCH SIMPLE
	ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);

-- Table: v2020.last_grade_completed

CREATE TABLE "v2020".schoolstatus
(
  "id" uuid NOT NULL,
  "information_date" timestamp,
  "school_status" "v2020".school_status,
  "enrollmentid" uuid,
  "project_group_code" character varying(8),
  "date_created" timestamp,
  "date_created_from_source" timestamp,
  "date_updated_from_source" timestamp,
  "date_updated" timestamp,
  "user_id" uuid,
  export_id uuid,
  parent_id uuid,
  version integer,source_system_id text,
  deleted boolean DEFAULT false,active boolean DEFAULT true, 
  sync boolean DEFAULT false,  
      


  CONSTRAINT school_status_pk PRIMARY KEY ("id"),
   CONSTRAINT "enrollment_schoolstatus_fk_key" FOREIGN KEY ("enrollmentid")
      REFERENCES v2020.enrollment ("id") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);


CREATE TABLE "v2020".employment
(
  "id" uuid NOT NULL,
  "information_date" timestamp,
  "datacollectionstage" "v2020".datacollectionstage,
  "employed" "v2020".five_val_dk_refused,
  "employment_type" "v2020".employment_type,
  "not_employed_reason" "v2020".not_employed_reason,
  "enrollmentid" uuid,
  "project_group_code" character varying(8),
  "date_created" timestamp,
  "date_created_from_source" timestamp,
  "date_updated_from_source" timestamp,
  "date_updated" timestamp,
  "user_id" uuid,
  export_id uuid,
  parent_id uuid,
  version integer,source_system_id text,
  deleted boolean DEFAULT false,active boolean DEFAULT true, 
  sync boolean DEFAULT false,
      
	  CONSTRAINT employment_pk PRIMARY KEY ("id"),
	  CONSTRAINT "enrollment_employment_fk_key" FOREIGN KEY ("enrollmentid")
      REFERENCES v2020.enrollment ("id") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);


CREATE TABLE "v2020".health_status
(
  "id" uuid NOT NULL,
  "enrollmentid" uuid,
  "information_date" timestamp,
  "datacollectionstage" "v2020".datacollectionstage,
  "health_category" "v2020".health_category,
  "health_status" "v2020".health_status_type,
  "due_date" timestamp,
  "project_group_code" character varying(8),
  "date_created" timestamp,
  "date_created_from_source" timestamp,
  "date_updated_from_source" timestamp,
  "date_updated" timestamp,
  "user_id" uuid,
  export_id uuid,
  parent_id uuid,
  version integer,source_system_id text,
  deleted boolean DEFAULT false,active boolean DEFAULT true, 
  sync boolean DEFAULT false,  

  	  CONSTRAINT health_status_pk PRIMARY KEY ("id"),
      CONSTRAINT "enrollment_health_status_fk_key" FOREIGN KEY ("enrollmentid")
      REFERENCES v2020.enrollment ("id") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);


create table "v2020".contact
(
	id uuid not null, 
	contact_date timestamp,
	contact_location v2020.contact_location,
	"enrollmentid" uuid,
	"project_group_code" character varying(8),
  	"date_created" timestamp,
  	"date_created_from_source" timestamp,
  	"date_updated_from_source" timestamp,
  	"date_updated" timestamp,
  	"user_id" uuid,
  	export_id uuid,
  	parent_id uuid,
  	version integer,source_system_id text,
  	deleted boolean DEFAULT false,active boolean DEFAULT true, 
  	sync boolean DEFAULT false,  
 
  	  CONSTRAINT contact_pk PRIMARY KEY ("id"),
      CONSTRAINT "enrollment_health_status_fk_key" FOREIGN KEY ("enrollmentid")
      REFERENCES v2020.enrollment ("id") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);


-- Table: "affiliation"

-- DROP TABLE "affiliation";

CREATE TABLE "v2020".affiliation
(
	  id uuid NOT NULL,
	  projectid uuid,
	  resprojectid text,
	  "project_group_code" character varying(8),
	  "date_created" timestamp,
	  "date_created_from_source" timestamp,
	  "date_updated_from_source" timestamp,
	  "date_updated" timestamp,
	  "user_id" uuid,
	  export_id uuid,
	  parent_id uuid,
	  version integer,source_system_id text,
	  deleted boolean DEFAULT false,active boolean DEFAULT true, 
	  sync boolean DEFAULT false,  
		CONSTRAINT "affiliation_pkey" PRIMARY KEY (id),
		CONSTRAINT "affiliation_project_fkey" FOREIGN KEY (projectid)
		REFERENCES v2020.project (id) MATCH SIMPLE
		ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);

-- table: "projectcoc" changed to CoC

-- drop table "coc";

create table "v2020".project_coc
(
  id uuid not null,
  coccode text,
   projectid uuid,
  "project_group_code" character varying(8),
   date_created timestamp,
   "date_created_from_source" timestamp,
  "date_updated_from_source" timestamp,
   date_updated timestamp,
   user_id uuid,
   export_id uuid,
   parent_id uuid,
   version integer,source_system_id text,
   deleted boolean DEFAULT false,active boolean DEFAULT true, 
   sync boolean DEFAULT false,
 
  constraint "coc_pkey" primary key (id),
  constraint "coc_projectid_fkey" foreign key (projectid)
      references v2020.project (id) match simple
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
with (
  oids=false
);


create table "v2020".inventory
(
   id uuid not null,
  householdtype "v2020".house_hold_type,
  bedtype "v2020".bed_type,
  coccode text,
  availabilty "v2020".availability,
  unitinventory integer,
  bed_inventory integer, -- Sandeep need to change this to five_val_dk_refused
  ch_bed_inventory integer, -- Sandeep need to change this to five_val_dk_refused
  vet_bed_inventory integer, -- Sandeep need to change this to five_val_dk_refused
  youth_bed_inventory integer,-- Sandeep need to change this to five_val_dk_refused
  --youth_age_group integer,
  facility_bed_inventory integer,
  voucher_bed_inventory integer,
  other_bed_inventory integer,
  inventorystartdate timestamp,
  inventoryenddate timestamp,
  hmisparticipatingbeds integer, --Sandeep change this to five_val_dk_refused
  --project_coc_id uuid,
  coc_id uuid,
  "project_group_code" character varying(8),
  date_created timestamp,
  date_updated timestamp,
   "date_created_from_source" timestamp,
  "date_updated_from_source" timestamp,
  user_id uuid,
  informationDate timestamp,
  export_id uuid,
  parent_id uuid,
  version integer,source_system_id text,
  deleted boolean DEFAULT false,active boolean DEFAULT true, 
  sync boolean DEFAULT false,
      


  constraint "inventory_pkey" primary key (id),
  constraint "inventory_cocid_fkey" foreign key (coc_id)
      references v2020."coc" (id) match simple
      on update no action on delete no action
)
with (
  oids=false
);


-- table: "funder"

-- drop table "funder";

create table  "v2020".funder
(
  "id"  uuid not null,
  "enddate" timestamp,
  "funder" "v2020".federal_partner_components,
  "otherfunder" character varying(500),
  "grantid" text, --Sandeep Alter and change the column to text
  "projectid" uuid,
  "startdate" timestamp,
  "project_group_code" character varying(8),
  date_created timestamp,
  date_updated timestamp,
  "date_created_from_source" timestamp,
  "date_updated_from_source" timestamp,
  user_id uuid,
  export_id uuid,
  parent_id uuid,
  version integer,source_system_id text,
  deleted boolean DEFAULT false,active boolean DEFAULT true, 
  sync boolean DEFAULT false,
  
      constraint "funder_pkey" primary key ("id"),
      constraint "funder_projectid_fkey" foreign key ("projectid")
      references v2020.project (id) match simple
      on update no action on delete no action
)
with (
  oids=false
);


CREATE TABLE "v2020".rhybcp_status
(
  "id" uuid NOT NULL,
  "status_date" timestamp,
  eligible_for_rhy  "v2020".no_yes,
  "reason_no_services" "v2020".fysb_rsn_not_providing_srvcs,
  runaway_youth  "v2020".no_yes,
  "enrollmentid" uuid,
  "project_group_code" character varying(8),
  "date_created" timestamp,
  "date_created_from_source" timestamp,
  "date_updated_from_source" timestamp,
  "date_updated" timestamp,
  "user_id" uuid,
  export_id uuid,
  parent_id uuid,
  version integer,source_system_id text,
  deleted boolean DEFAULT false,active boolean DEFAULT true, 
  sync boolean DEFAULT false,
	CONSTRAINT rhybcp_status_pk PRIMARY KEY ("id"),
	CONSTRAINT "enrollment_rhybcp_status_fk_key" FOREIGN KEY ("enrollmentid")
	REFERENCES v2020.enrollment ("id") MATCH SIMPLE
	ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);


-- table: "medicalassistance"

-- drop table "medicalassistance";

create table "v2020".medicalassistance
(
	id uuid not null,  
	hivaidsassistance "v2020".five_val_dk_refused,
  	nohivaidsassistancereason "v2020".no_medical_assistance_reason,
  	adap "v2020".five_val_dk_refused,
  	noadapreason "v2020".no_medical_assistance_reason,
  	information_date timestamp,
  	"datacollectionstage" "v2020".datacollectionstage,
	enrollmentid uuid,
    "project_group_code" character varying(8),
    "date_created" timestamp,
    "date_updated" timestamp,
    "date_created_from_source" timestamp,
	"date_updated_from_source" timestamp,
    "user_id" uuid,
	  export_id uuid,
	  parent_id uuid,
	  version integer,source_system_id text,
	  deleted boolean DEFAULT false,active boolean DEFAULT true, 
	  sync boolean DEFAULT false,
  	  constraint "medicalassistance_pkey" primary key (id),
	  constraint "medicalassistance_enrollmentid_fkey" foreign key (enrollmentid)
      references v2020.enrollment ("id") match simple
      on update no action on delete no action
      
)
with (
  oids=false
);

-- table: "domesticviolence"

-- drop table "domesticviolence";

create table "v2020".domesticviolence
(
  "id"  uuid not null,
  "domesticviolencevictim" "v2020".five_val_dk_refused,
  "enrollmentid" uuid,
  "whenoccurred" "v2020".when_dom_violence_occurred,
  currently_fleeing integer, --Sandeep no_yes
  information_date timestamp,
  "datacollectionstage" "v2020".datacollectionstage,
  "project_group_code" character varying(8),
  "date_created" timestamp,
  "date_created_from_source" timestamp,
   "date_updated_from_source" timestamp,
  "date_updated" timestamp,
  "user_id" uuid,
  export_id uuid,
  parent_id uuid,
  version integer,source_system_id text,
  deleted boolean DEFAULT false,active boolean DEFAULT true, 
  sync boolean DEFAULT false,
      


  		constraint "domesticviolence_pkey" primary key ("id"),
  		constraint "domesticviolence_enrollmentid_fkey" foreign key ("enrollmentid")
      references v2020.enrollment ("id") match simple
      on update no action on delete no action
)
with (
  oids=false
);

-- table: "disabilities"

-- drop table "disabilities";

create table "v2020".disabilities
(
  "id" uuid not null,
  "disabilitytype" "v2020".disability_type,
  "disabilityresponse" integer,
  "indefiniteandimpairs" "v2020".five_val_dk_refused,
  "enrollmentid" uuid,
  tcellcountavailable  "v2020".no_yes,
  tcellcount integer,
  tcellcountsource "v2020".tcell_viralload_source,
  viral_load_available "v2020".viral_load_available,
  viral_load integer,
  viral_load_source "v2020".tcell_viralload_source,
  information_date timestamp,
  "datacollectionstage" "v2020".datacollectionstage,
  "project_group_code" character varying(8),
  "date_created" timestamp,
  "date_created_from_source" timestamp,
   "date_updated_from_source" timestamp,
  "date_updated" timestamp,
  "user_id" uuid,
  export_id uuid,
  parent_id uuid,
  version integer,source_system_id text,
  deleted boolean DEFAULT false,active boolean DEFAULT true, 
  sync boolean DEFAULT false,
 
	  constraint "disabilities_pkey" primary key ("id"),
	  constraint "disabilities_enrollmentid_fkey" foreign key ("enrollmentid")
      references v2020.enrollment ("id") match simple
      on update no action on delete no action
)
with (
  oids=false
);
-- table: "moveinDate"

-- drop table "moveinDate";

create table  "v2020".moveinDate
(
  	id uuid not null,
	--inpermanenthousing "v2020".no_yes,
  	enrollmentid uuid,
  	moveinDate timestamp,
    "project_group_code" character varying(8),
  	"date_created" timestamp,
  	"date_created_from_source" timestamp,
   	"date_updated_from_source" timestamp,
  	"date_updated" timestamp,
  	"user_id" uuid,
  	export_id uuid,
  	parent_id uuid,
  	version integer,source_system_id text,
  	deleted boolean DEFAULT false,active boolean DEFAULT true, 
  	sync boolean DEFAULT false,
  
  	  constraint "moveinDate_pkey" primary key (id),
      constraint "moveinDate_enrollmentid_fkey" foreign key (enrollmentid)
      references v2020.enrollment ("id") match simple 
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
with (
  oids=false
);

-- table: "dateofengagement"

-- drop table "dateofengagement";

create table  "v2020".dateofengagement
(
  	"id" uuid not null,
	"dateofengagement" timestamp,
	"enrollmentid" uuid,
	"project_group_code" character varying(8),
	"date_created" timestamp,
	"date_created_from_source" timestamp,
	"date_updated_from_source" timestamp,
	"date_updated" timestamp,
	"user_id" uuid,
	export_id uuid,
	parent_id uuid,
	version integer,source_system_id text,
	deleted boolean DEFAULT false,active boolean DEFAULT true, 
	sync boolean DEFAULT false,
  	constraint "dateofengagement_pkey" primary key ("id"),
  	constraint "dateofengagement_enrollmentid_fkey" foreign key ("enrollmentid")
     	references v2020.enrollment ("id") match simple
    	on update no action on delete no action
)
with (
  oids=false
);

create table  "v2020".entryRHSP
(
  	"id" uuid not null,
	worst_housing_situation integer, -- This needs fk
	"enrollmentid" uuid,
	"project_group_code" character varying(8),
	"date_created" timestamp,
	"date_created_from_source" timestamp,
	"date_updated_from_source" timestamp,
	"date_updated" timestamp,
	"user_id" uuid,
	export_id uuid,
	parent_id uuid,
	version integer,source_system_id text,
	deleted boolean DEFAULT false,active boolean DEFAULT true, 
	sync boolean DEFAULT false,
  		constraint "entryRHSP_pkey" primary key ("id"),
  		constraint "entryRHSP_enrollmentid_fkey" foreign key ("enrollmentid")
      	references v2020.enrollment ("id") match simple
      	on update no action on delete no action
)
with (
  oids=false
);

create table  "v2020".education
(
  	"id" uuid not null,
	lastgradecompleted "v2020".last_grade_completed,
	"school_status" "v2020".school_status,
	"enrollmentid" uuid,
	 information_date timestamp,
     "datacollectionstage" "v2020".datacollectionstage,
	"project_group_code" character varying(8),
	"date_created" timestamp,
	"date_created_from_source" timestamp,
	"date_updated_from_source" timestamp,
	"date_updated" timestamp,
	"user_id" uuid,
	export_id uuid,
	parent_id uuid,
	version integer,source_system_id text,
	deleted boolean DEFAULT false,active boolean DEFAULT true, 
	sync boolean DEFAULT false,
  		constraint "education_pkey" primary key ("id"),
  		constraint "education_fkey" foreign key ("enrollmentid")
      	references v2020.enrollment ("id") match simple
      	on update no action on delete no action
)
with (
  oids=false
);

-- drop table "incomeandsources";

create table "v2020".incomeandsources
(
  alimony "v2020".no_yes,
  alimonyamount numeric(15,3),
  childsupport "v2020".no_yes,
  childsupportamount numeric(15,3),
  earned "v2020".no_yes,
  earnedamount numeric(15,3),
  ga "v2020".no_yes,
  gaamount numeric(15,3),
  id uuid not null,
  incomefromanysource "v2020".five_val_dk_refused,
  othersource "v2020".no_yes,
  othersourceamount numeric(15,3),
  othersourceidentify text,
  pension "v2020".no_yes,
  pensionamount numeric(15,3),
  privatedisability "v2020".no_yes,
  privatedisabilityamount numeric(15,3),
  enrollmentid uuid,
  socsecretirement "v2020".no_yes,
  socsecretirementamount numeric(15,3),
  ssdi "v2020".no_yes,
  ssdiamount numeric(15,3),
  ssi "v2020".no_yes,
  ssiamount numeric(15,3),
  tanf "v2020".no_yes,
  tanfamount numeric(15,3),
  totalmonthlyincome numeric(15,3),
  unemployment "v2020".no_yes,
  unemploymentamount numeric(15,3),
  vadisabilitynonservice "v2020".no_yes,
  vadisabilitynonserviceamount numeric(15,3),
  vadisabilityservice "v2020".no_yes,
  vadisabilityserviceamount numeric(15,3),
  workerscomp "v2020".no_yes,
  workerscompamount numeric(15,3),
   information_date timestamp,
  "datacollectionstage" "v2020".datacollectionstage,
  "project_group_code" character varying(8),
  "date_created" timestamp,
  "date_created_from_source" timestamp,
    "date_updated_from_source" timestamp,
  "date_updated" timestamp,
  "user_id" uuid,
  export_id uuid,
  parent_id uuid,
  version integer,source_system_id text,
  deleted boolean DEFAULT false,active boolean DEFAULT true, 
  sync boolean DEFAULT false, 
      


  constraint "incomeandsources_pkey" primary key (id),
  constraint "incomeandsources_enrollmentid_fkey" foreign key (enrollmentid)
      references v2020.enrollment ("id") match simple
      on update no action on delete no action
)
with (
  oids=false
);



-- drop table "noncashbenefits";

create table "v2020".noncashbenefits
(
	id uuid not null,  
	benefitsfromanysource "v2020".five_val_dk_refused,
  	othersource "v2020".no_yes,
  	othersourceidentify text,
  	othertanf "v2020".no_yes,
  	enrollmentid uuid,
  	rentalassistanceongoing "v2020".no_yes,
  	rentalassistancetemp "v2020".no_yes,
  	snap "v2020".no_yes,
  	tanfchildcare "v2020".no_yes,
  	tanftransportation "v2020".no_yes,
  	wic "v2020".no_yes,
  	information_date timestamp,
    "datacollectionstage" "v2020".datacollectionstage,
  	"project_group_code" character varying(8),
  	"date_created" timestamp,
  	"date_created_from_source" timestamp,
    "date_updated_from_source" timestamp,
  	"date_updated" timestamp,
  	"user_id" uuid,
  	export_id uuid,
  	parent_id uuid,
  	version integer,source_system_id text,
  	deleted boolean DEFAULT false,active boolean DEFAULT true, 
  	sync boolean DEFAULT false,
      constraint "noncashbenefits_pkey" primary key (id),
	  constraint "noncashbenefits_enrollmentid_fkey" foreign key (enrollmentid)
      references v2020.enrollment ("id") match simple
      on update no action on delete no action
)
with (
  oids=false
);

-- table: "healthinsurance"

-- drop table "healthinsurance";

create table "v2020".healthinsurance
(
  "id" uuid not null,
  "insurancefromanysource" "v2020".five_val_dk_refused,
  "medicaid" "v2020".no_yes,
  "nomedicaidreason" "v2020".no_health_insurance_reason,
  "medicare" "v2020".no_yes,
  "nomedicarereason" "v2020".no_health_insurance_reason,
  "schip" "v2020".no_yes,
  "noschipreason" "v2020".no_health_insurance_reason,
  "vamedicalservices" "v2020".no_yes,
  "novamedreason" "v2020".no_health_insurance_reason,
  "employerprovided" integer, --Sandeep change this to noYes
  "noemployerprovidedreason" "v2020".no_health_insurance_reason,
  "cobra" integer, --Sandeep 
  "nocobrareason" "v2020".no_health_insurance_reason,
  "privatepay" "v2020".no_yes,
  "noprivatepayreason" "v2020".no_health_insurance_reason,
  "statehealthinadults" "v2020".no_yes,
  "nostatehealthinsreason" "v2020".no_health_insurance_reason,
  other_insurance "v2020".no_yes,
  other_insurance_identify text,
  "indianhealthservices" "v2020".no_yes,
  "noindianhealthservicesreason" "v2020".no_health_insurance_reason,
  "enrollmentid" uuid,
   information_date timestamp,
  "datacollectionstage" "v2020".datacollectionstage,
  "project_group_code" character varying(8),
  "date_created" timestamp,
  "date_created_from_source" timestamp,
  "date_updated_from_source" timestamp,
  "date_updated" timestamp,
  "user_id" uuid,
  export_id uuid,
  parent_id uuid,
  version integer,source_system_id text,
  deleted boolean DEFAULT false,active boolean DEFAULT true, 
  sync boolean DEFAULT false,
      constraint "healthinsurance_pkey" primary key ("id"),
	  constraint "healthinsurance_enrollmentid_fkey" foreign key ("enrollmentid")
      references v2020.enrollment ("id") match simple
      on update no action on delete no action
)
with (
  oids=false
);

create table "v2020".exit
(
	"id" uuid not null,  
	"destination" "v2020".destination,
	"exitdate" timestamp,
	"otherdestination" text,
	"enrollmentid" uuid,
	"project_group_code" character varying(8),
	"date_created" timestamp,
	"date_created_from_source" timestamp,
	"date_updated_from_source" timestamp,
	"date_updated" timestamp,
	"user_id" uuid,
	export_id uuid,
	parent_id uuid,
	version integer,source_system_id text,
	deleted boolean DEFAULT false,active boolean DEFAULT true, 
	sync boolean DEFAULT false,
		constraint "exit_pkey" primary key ("id"),
		constraint "exit_enrollmentid_fkey" foreign key ("enrollmentid")
		references v2020.enrollment ("id") match simple
		on update no action on delete no action
)
with (
  oids=false
);

---Done--
create table  "v2020".exithousingassessment
(
  "id" uuid not null,
  "exitid" uuid,
  "housingassessment" "v2020".housing_assmnt_exit,
  "subsidyinformation" "v2020".subsidy_information,
  "project_group_code" character varying(8),
  "date_created" timestamp,
  "date_created_from_source" timestamp,
  "date_updated_from_source" timestamp,
  "date_updated" timestamp,
  "user_id" uuid,
  export_id uuid,
  parent_id uuid,
  version integer,source_system_id text,
  deleted boolean DEFAULT false,active boolean DEFAULT true, 
  sync boolean DEFAULT false,
	  constraint "exithousingassessment_pkey" primary key ("id"),
	  constraint "exithousingassessment_fkey" foreign key ("exitid")
      references v2020.exit(id) match simple
      on update no action on delete no action
)
with (
  oids=false
);


create table "v2020".exitRHY
(
	"id" uuid not null, 
	"exitid" uuid,
	"project_completion_status" "v2020".project_completion_status,
	"early_exit_reason" "v2020".early_exit_reason,
	exchage_for_sex  "v2020".no_yes,
	exchange_for_sex_past_three_months "v2020".no_yes,
	count_of_exchange_for_sex "v2020".count_of_exchange_for_sex,
	asked_or_forced_to_exchange_for_sex "v2020".no_yes,
	asked_or_forced_to_exchange_for_sex_past_three_months "v2020".no_yes,
	work_place_violence_threats "v2020".no_yes,
	work_place_promise_difference "v2020".no_yes,
	coerced_to_continue_work "v2020".no_yes,
	labor_exploit_past_three_months "v2020".no_yes,
	counseling_received "v2020".no_yes,
	individual_counseling "v2020".no_yes,
	family_counseling "v2020".no_yes,
	group_counseling "v2020".no_yes,
	session_count_at_exit integer,
	sessions_in_plan integer,
	post_exit_counseling_plan "v2020".no_yes,
	destination_safe_client "v2020".no_yes,
	destination_safe_worker "v2020".no_yes,
	pos_adult_connections "v2020".no_yes,
	pos_peer_connections "v2020".no_yes,
	pos_community_connections "v2020".no_yes,
	"project_group_code" character varying(8),
	"date_created" timestamp,
	"date_created_from_source" timestamp,
	"date_updated_from_source" timestamp,
	"date_updated" timestamp,
	"user_id" uuid,
	export_id uuid,
	parent_id uuid,
	version integer,source_system_id text,
	deleted boolean DEFAULT false,active boolean DEFAULT true, 
	sync boolean DEFAULT false,
		constraint "exitRHY_pkey" primary key ("id"),
		constraint "exitRHY_fkey" foreign key ("exitid")
		references v2020.exit("id") match simple
		on update no action on delete no action
)
with (
  oids=false
);

create table "v2020".rhyaftercare
(
	"id" uuid not null, 
	after_care_date timestamp,
	after_provided "v2020".no_yes,
	email_social_media "v2020".no_yes,
	telephone "v2020".no_yes,
	in_person_individual "v2020".no_yes,
	in_person_group "v2020".no_yes,
	exitid uuid,
	"project_group_code" character varying(8),
	"date_created" timestamp,
	"date_created_from_source" timestamp,
	"date_updated_from_source" timestamp,
	"date_updated" timestamp,
	"user_id" uuid,
	export_id uuid,
	parent_id uuid,
	version integer,source_system_id text,
	deleted boolean DEFAULT false,active boolean DEFAULT true, 
	sync boolean DEFAULT false,
		constraint "rhyaftercare_pkey" primary key ("id"),
		constraint "rhyaftercare_fkey" foreign key ("exitid")
		references v2020.exit("id") match simple
		on update no action on delete no action
)
with (
  oids=false
);

create table "v2020".vashexitreason
(
	"id" uuid not null, 
	cm_exit_reason "v2020".cm_exit_reason,
	exitid uuid,
	"project_group_code" character varying(8),
	"date_created" timestamp,
	"date_created_from_source" timestamp,
	"date_updated_from_source" timestamp,
	"date_updated" timestamp,
	"user_id" uuid,
	export_id uuid,
	parent_id uuid,
	version integer,source_system_id text,
	deleted boolean DEFAULT false,active boolean DEFAULT true, 
	sync boolean DEFAULT false,
		constraint "vashexitreason_pkey" primary key ("id"),
		constraint "vashexitreason_fkey" foreign key ("exitid")
		references v2020.exit("id") match simple
		on update no action on delete no action
)
with (
  oids=false
);

create table "v2020".connectionwithsoar
(
	"id" uuid not null, 
	information_date timestamp,
	"connection_with_soar" "v2020".connection_with_soar,
	"enrollmentid" uuid,
	"project_group_code" character varying(8),
	"date_created" timestamp,
	"date_created_from_source" timestamp,
	"date_updated_from_source" timestamp,
	"date_updated" timestamp,
	"user_id" uuid,
	export_id uuid,
	parent_id uuid,
	version integer,source_system_id text,
	deleted boolean DEFAULT false,active boolean DEFAULT true, 
	sync boolean DEFAULT false,
		constraint "connectionwithsoar_pkey" primary key ("id"),
		constraint "connectionwithsoar_fkey" foreign key ("enrollmentid")
		references v2020.exit("id") match simple
		on update no action on delete no action
)
with (
  oids=false
);

create table "v2020".geography
(
	"id" uuid not null, 
	information_date timestamp,
	geo_code varchar(10),
	address1 varchar(100),
	address2 varchar(100),
	city varchar(50),
	state varchar(50),
	zip varchar(15),
	geography_type "v2020".geography_type,
	coc_id uuid,
	"project_group_code" character varying(8),
	"date_created" timestamp,
	"date_created_from_source" timestamp,
	"date_updated_from_source" timestamp,
	"date_updated" timestamp,
	"user_id" uuid,
	export_id uuid,
	parent_id uuid,
	version integer,source_system_id text,
	deleted boolean DEFAULT false,active boolean DEFAULT true, 
	sync boolean DEFAULT false,
		constraint "geography_pkey" primary key ("id"),
		constraint "geography_fkey" foreign key ("coc_id")
		references v2020.coc("id") match simple
		on update no action on delete no action
)
with (
  oids=false
);



-- table: "exitplansactions"

-- drop table "exitplansactions";


create table "v2020".housingassessmentdisposition
(
  "id" uuid not null,
  "assessmentdisposition" "v2020".assessment_disposition,
  "exitid" uuid,
  "otherdisposition" text,
  "project_group_code" character varying(8),
  "date_created" timestamp,
  "date_created_from_source" timestamp,
  "date_updated_from_source" timestamp,
  "date_updated" timestamp,
  "user_id" uuid,
  export_id uuid,
  parent_id uuid,
  version integer,source_system_id text,
  deleted boolean DEFAULT false,active boolean DEFAULT true, 
  sync boolean DEFAULT false,
	  constraint "housingassessmentdisposition_pkey" primary key ("id"),
	  constraint "housingassessmentdisposition_exitid_fkey" foreign key ("exitid")
      references v2020."exit" ("id") match simple
      on update no action on delete no action
)
with (
  oids=false
);


CREATE SEQUENCE "v2020".bulk_upload_id_seq START 1;

create table "v2020".bulk_upload_activity
(
 id serial not null,
 bulk_upload_id bigint,
 table_name character varying(100),
 records_processed bigint,
 description text,
  "project_group_code" character varying(8),
  "date_created" timestamp,
  "date_updated" timestamp,
  inserted  bigint,
  updated bigint,
  "user_id" uuid,
  export_id uuid,
  parent_id uuid,
  version integer,source_system_id text,
  deleted boolean DEFAULT false,active boolean DEFAULT true,  
  sync boolean DEFAULT false,
     CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES v2020.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT bulk_upload_activity_pk PRIMARY KEY ("id")
);


DROP TABLE IF EXISTS v2020.bulk_upload_error;

CREATE TABLE v2020.bulk_upload_error
(
  id bigint NOT NULL,
  model_id uuid,
  bulk_upload_ui bigint,
  table_name text,
  project_group_code character varying(8),
  source_system_id text,
  type character varying(8),
  error_description text,
  date_created timestamp without time zone,
  CONSTRAINT bulk_upload_error_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);

 --DROP SEQUENCE v2020.error_sequence IF EXISTS;

CREATE SEQUENCE v2020.error_sequence
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;

  
  CREATE TABLE "v2020".sync
(
  id serial,
  sync_table character(100),
  status character(10),
  description text,
  project_group_code character(8),
  date_created timestamp,
  date_updated timestamp,
  CONSTRAINT sync_pk PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);





ALTER TABLE v2020.enrollment 
DROP COLUMN dateToStreetESSH;

ALTER TABLE v2020.enrollment
add COLUMN dateToStreetESSH  timestamp;

ALTER TABLE v2020.inventory
add column projectid uuid; 

ALTER TABLE v2020.inventory 

ADD CONSTRAINT inventory_project_fk FOREIGN KEY (projectid) REFERENCES v2020.project (id);

ALTER TABLE v2020.enrollment DROP COLUMN projectentryid;


insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template) values
('024c9acd-d3e1-4cc4-9800-a9db85edad36','Relationship to Head of Household','Relationship to Head of Household',
'STRING','DROPDOWN',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,(null),	true,'relationshiptohoh',
false,'3.15.1','/v2020/hmistypes/relationshiptohoh/values');

insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template) values
('024c9acd-d3e1-4cc4-9800-a9db85edad99','Physical Disability','Physical Disability',
'STRING','DROPDOWN',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,(null),	true,'indefiniteandimpairs',
false,'4.5.2A','/v2020/clients/{clientid}/enrollments/{enrollmentid}/disabilities/{disabilityid}');



insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template) values
('024c9acd-d3e1-4cc4-9800-a9db85edad37','Living Situation','Living Situation','STRING','DROPDOWN',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'livingSituation',false,'3.917.1','/v2020/hmistypes/livingSituation/values');

insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template) values
('024c9acd-d3e1-4cc4-9800-a9db85edad38','Length Of Stay','Living Situation','STRING','DROPDOWN',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'lengthOfStay',false,'3.917.2','/v2020/hmistypes/lengthOfStay/values');

insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template) values
('024c9acd-d3e1-4cc4-9800-a9db85edad39','Los Under Threshold','Los Under Threshold','STRING','DROPDOWN',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'lengthOfStay',false,'3.917.2','/v2020/hmistypes/losunderthreshold/values');

insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template) values
('024c9acd-d3e1-4cc4-9800-a9db85edad40','Previous Street ESSH','Previous Street ESSH','STRING','DROPDOWN',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'previousStreetESSH',false,'3.917.2','/v2020/hmistypes/previousStreetESSH/values');


insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template) values
('024c9acd-d3e1-4cc4-9800-a9db85edad41','Times Homeless Past Three Years','Times Homeless Past Three Years','STRING','DROPDOWN',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'timesHomelesspastthreeyears',false,'3.917.2','/v2020/hmistypes/timesHomelesspastthreeyears/values');


insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template) values
('024c9acd-d3e1-4cc4-9800-a9db85edad42','Months Homeless Past Three Years','Months Homeless Past Three Years','STRING','DROPDOWN',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'monthsHomelessPastThreeYears',false,'3.917.2','/v2020/hmistypes/monthsHomelessPastThreeYears/values');

insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template) values
('024c9acd-d3e1-4cc4-9800-a9db85edad68','YearEnteredService','YearEnteredService','STRING','INTEGER',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'year_entrd_service',false,'V1.1','/v2020/hmistypes/year_entrd_service/values');

insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template) values
('024c9acd-d3e1-4cc4-9800-a9db85edad66','YearSeparated','YearSeparated','STRING','INTEGER',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'year_seperated',false,'V1.2','/v2020/hmistypes/year_seperated/values');

insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template) values
('024c9acd-d3e1-4cc4-9800-a9db85edad70','WorldWarII','WorldWarII','STRING','DROPDOWN',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'world_war_2',false,'V1.2','/v2020/hmistypes/world_war_2/values');

insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template) values
('024c9acd-d3e1-4cc4-9800-a9db85edad71','KoreanWar','KoreanWar','STRING','DROPDOWN',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'korean_war',false,'V1.4','/v2020/hmistypes/korean_war/values');

insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template) values
('024c9acd-d3e1-4cc4-9800-a9db85edad73','DesertStorm','DesertStorm','STRING','DROPDOWN',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'desert_storm',false,'V1.6','/v2020/hmistypes/desert_storm/values');


insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template) values
('024c9acd-d3e1-4cc4-9800-a9db85edad72','AfghanistanOEF','AfghanistanOEF','STRING','DROPDOWN',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'afghanistan_oef',false,'V1.7','/v2020/hmistypes/afghanistan_oef/values');

insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template) values
('024c9acd-d3e1-4cc4-9800-a9db85edad74','IraqOIF','IraqOIF','STRING','DROPDOWN',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'iraq_oif',false,'V1.8','/v2020/hmistypes/iraq_oif/values');


insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template) values
('024c9acd-d3e1-4cc4-9800-a9db85edad75','IraqOND','IraqOND','STRING','DROPDOWN',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'iraq_ond',false,'V1.9','/v2020/hmistypes/iraq_ond/values');


insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template) values
('024c9acd-d3e1-4cc4-9800-a9db85edaf60','Temporary Assistance for Needy Families ','Temporary Assistance for Needy Families ','STRING','DROPDOWN',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'tanf',false,'4.2.11','/{clientid}/enrollments/{enrollmentid}/incomeandsources/{incomeAndSourceid}');

INSERT INTO "v2020".hmis_type (name,value,description,status) values ('tanf','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('tanf','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('tanf','99','Data not collected','ACTIVE');

insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template) values
('024c9acd-d3e1-4cc4-9800-a9db85edaf61','General Assistance ','General Assistance','STRING','DROPDOWN',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'ga',false,'4.2.12','/{clientid}/enrollments/{enrollmentid}/incomeandsources/{incomeAndSourceid}');

INSERT INTO "v2020".hmis_type (name,value,description,status) values ('ga','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('ga','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('ga','99','Data not collected','ACTIVE');


insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template) values
('024c9acd-d3e1-4cc4-9800-a9db85edaf40','Retirement Income from Social Security','Retirement Income from Social Security','STRING','DROPDOWN',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'socsecretirement',false,'4.2.13','/{clientid}/enrollments/{enrollmentid}/incomeandsources/{incomeAndSourceid}');

INSERT INTO "v2020".hmis_type (name,value,description,status) values ('socsecretirement','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('socsecretirement','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('socsecretirement','99','Data not collected','ACTIVE');

insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template) values
('024c9acd-d3e1-4cc4-9800-a9db85edaf41','Pension or retirement income from a former job','Pension or retirement income from a former job','STRING','DROPDOWN',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'pension',false,'4.2.14','/{clientid}/enrollments/{enrollmentid}/incomeandsources/{incomeAndSourceid}');

INSERT INTO "v2020".hmis_type (name,value,description,status) values ('pension','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('pension','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('pension','99','Data not collected','ACTIVE');

insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template) values
('024c9acd-d3e1-4cc4-9800-a9db85edaf42','Child support','Child support','STRING','DROPDOWN',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'childsupport',false,'4.2.15','/{clientid}/enrollments/{enrollmentid}/incomeandsources/{incomeAndSourceid}');

INSERT INTO "v2020".hmis_type (name,value,description,status) values ('childsupport','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('childsupport','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('childsupport','99','Data not collected','ACTIVE');

insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template) values
('024c9acd-d3e1-4cc4-9800-a9db85edaf43','Alimony and other spousal support','Alimony and other spousal support','STRING','DROPDOWN',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'alimony',false,'4.2.16','/{clientid}/enrollments/{enrollmentid}/incomeandsources/{incomeAndSourceid}');

INSERT INTO "v2020".hmis_type (name,value,description,status) values ('alimony','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('alimony','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('alimony','99','Data not collected','ACTIVE');


insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template) values
('024c9acd-d3e1-4cc4-9800-a9db85edaf44','Other Income Source','Other Income Source','STRING','DROPDOWN',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'othersource',false,'4.2.17','/{clientid}/enrollments/{enrollmentid}/incomeandsources/{incomeAndSourceid}');

INSERT INTO "v2020".hmis_type (name,value,description,status) values ('othersource','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('othersource','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('othersource','99','Data not collected','ACTIVE');


insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template) values
('024c9acd-d3e1-4cc4-9800-a9db85edaf69','Non-Cash Benefits from Any Source','Non-Cash Benefits from Any Source','STRING','DROPDOWN',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'benefitsfromanysource',false,'4.3.2','/{clientid}/enrollments/{enrollmentid}/incomeandsources/{incomeAndSourceid}');

INSERT INTO "v2020".hmis_type (name,value,description,status) values ('benefitsfromanysource','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('benefitsfromanysource','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('benefitsfromanysource','8','Client doesn''t know','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('benefitsfromanysource','9','Client refused','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('benefitsfromanysource','99','Data not collected','ACTIVE');

INSERT INTO "v2020".hmis_type (name,value,description,status) values ('unemployment','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('unemployment','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('unemployment','99','Data not collected','ACTIVE');


INSERT INTO "v2020".hmis_type (name,value,description,status) values ('tcellcountavailable','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('tcellcountavailable','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('tcellcountavailable','8','Client doesn''t know','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('tcellcountavailable','9','Client refused','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('tcellcountavailable','99','Data not collected','ACTIVE');



INSERT INTO "v2020".hmis_type (name,value,description,status) values ('indefiniteandimpairs','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('indefiniteandimpairs','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('indefiniteandimpairs','8','Client doesn''t know','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('indefiniteandimpairs','9','Client refused','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('indefiniteandimpairs','99','Data not collected','ACTIVE');



insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template) values
('024c9acd-d3e1-4cc4-9800-a9db85edaf46','Income from Any Source','Income Benefits from Any Source','STRING','DROPDOWN',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'incomefromanysource',false,'4.3.2','/{clientid}/enrollments/{enrollmentid}/incomeandsources/{incomeAndSourceid}');

INSERT INTO "v2020".hmis_type (name,value,description,status) values ('incomefromanysource','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('incomefromanysource','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('incomefromanysource','8','Client doesn''t know','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('incomefromanysource','9','Client refused','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('incomefromanysource','99','Data not collected','ACTIVE');

insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template) values
('024c9acd-d3e1-4cc4-9800-a9db85edaf47','Supplemental Nutrition Assistance Program','Supplemental Nutrition Assistance Program','STRING','DROPDOWN',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'snap',false,'4.3.3','/clients/{clientid}/enrollments/{enrollmentid}/noncashbenefits/{noncashbenefitid}');

INSERT INTO "v2020".hmis_type (name,value,description,status) values ('snap','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('snap','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('snap','8','Client doesn''t know','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('snap','9','Client refused','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('snap','99','Data not collected','ACTIVE');


insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template) values
('024c9acd-d3e1-4cc4-9800-a9db85edaf02','Special Supplemental Nutrition Program for Women, Infants, and Children','Special Supplemental Nutrition Program for Women, Infants, and Children','STRING','DROPDOWN',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'wic',false,'4.3.4','/clients/{clientid}/enrollments/{enrollmentid}/noncashbenefits/{noncashbenefitid}');

INSERT INTO "v2020".hmis_type (name,value,description,status) values ('wic','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('wic','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('wic','8','Client doesn''t know','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('wic','9','Client refused','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('wic','99','Data not collected','ACTIVE');


insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template) values
('024c9acd-d3e1-4cc4-9800-a9db85edaf48','Special Supplemental Nutrition Program for Women, Infants, and Children','Special Supplemental Nutrition Program for Women, Infants, and Children','STRING','DROPDOWN',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'tanfchildcare',false,'4.3.5','/clients/{clientid}/enrollments/{enrollmentid}/noncashbenefits/{noncashbenefitid}');

INSERT INTO "v2020".hmis_type (name,value,description,status) values ('tanfchildcare','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('tanfchildcare','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('tanfchildcare','99','Data not collected','ACTIVE');


insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template) values
('024c9acd-d3e1-4cc4-9800-a9db85edaf49','TANF transportation services','TANF transportation services','STRING','DROPDOWN',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'tanftransportation',false,'4.3.6','/clients/{clientid}/enrollments/{enrollmentid}/noncashbenefits/{noncashbenefitid}');

INSERT INTO "v2020".hmis_type (name,value,description,status) values ('tanftransportation','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('tanftransportation','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('tanftransportation','8','Client doesn''t know','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('tanftransportation','9','Client refused','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('tanftransportation','99','Data not collected','ACTIVE');



insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template) values
('024c9acd-d3e1-4cc4-9800-a9db85edaf50','Other TANF-funded services','Other TANF-funded services','STRING','DROPDOWN',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'othertanf',false,'4.3.6','/clients/{clientid}/enrollments/{enrollmentid}/noncashbenefits/{noncashbenefitid}');

INSERT INTO "v2020".hmis_type (name,value,description,status) values ('othertanf','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('othertanf','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('othertanf','8','Client doesn''t know','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('othertanf','9','Client refused','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('othertanf','99','Data not collected','ACTIVE');



insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template) values
('024c9acd-d3e1-4cc4-9800-a9db85edaf51','Other source','Other source','STRING','DROPDOWN',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'othersource',false,'4.3.9','/clients/{clientid}/enrollments/{enrollmentid}/noncashbenefits/{noncashbenefitid}');

insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template) values
('024c9acd-d3e1-4cc4-9800-a9db85edaf52','Other source','Other source','STRING','DROPDOWN',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'insurancefromanysource',false,'4.4.2','/clients/{clientid}/enrollments/{enrollmentid}/healthinsurances/{healthinsuranceid}');

INSERT INTO "v2020".hmis_type (name,value,description,status) values ('insurancefromanysource','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('insurancefromanysource','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('insurancefromanysource','8','Client doesn''t know','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('insurancefromanysource','9','Client refused','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('insurancefromanysource','99','Data not collected','ACTIVE');


insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template) values
('024c9acd-d3e1-4cc4-9800-a9db85edaf53','MEDICAID','MEDICAID','STRING','DROPDOWN',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'medicaid',false,'4.4.3','/clients/{clientid}/enrollments/{enrollmentid}/healthinsurances/{healthinsuranceid}');

INSERT INTO "v2020".hmis_type (name,value,description,status) values ('medicaid','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('medicaid','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('medicaid','8','Client doesn''t know','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('medicaid','9','Client refused','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('medicaid','99','Data not collected','ACTIVE');


insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template) values
('024c9acd-d3e1-4cc4-9800-a9db85edaf54','MEDICARE','MEDICARE','STRING','DROPDOWN',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'medicare',false,'4.4.4','/clients/{clientid}/enrollments/{enrollmentid}/healthinsurances/{healthinsuranceid}');

INSERT INTO "v2020".hmis_type (name,value,description,status) values ('medicare','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('medicare','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('medicare','8','Client doesn''t know','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('medicare','9','Client refused','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('medicare','99','Data not collected','ACTIVE');

insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template) values
('024c9acd-d3e1-4cc4-9800-a9db85edaf55','State Health Insurance for Adults','State Health Insurance for Adults','STRING','DROPDOWN',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'schip',false,'4.4.5','/clients/{clientid}/enrollments/{enrollmentid}/healthinsurances/{healthinsuranceid}');

INSERT INTO "v2020".hmis_type (name,value,description,status) values ('schip','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('schip','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('schip','8','Client doesn''t know','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('schip','9','Client refused','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('schip','99','Data not collected','ACTIVE');

insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template) values
('024c9acd-d3e1-4cc4-9800-a9db85edaf56','State Health Insurance for Adults','State Health Insurance for Adults','STRING','DROPDOWN',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'vamedicalservices',false,'4.4.6','/clients/{clientid}/enrollments/{enrollmentid}/healthinsurances/{healthinsuranceid}');

INSERT INTO "v2020".hmis_type (name,value,description,status) values ('vamedicalservices','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('vamedicalservices','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('vamedicalservices','8','Client doesn''t know','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('vamedicalservices','9','Client refused','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('vamedicalservices','99','Data not collected','ACTIVE');

insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template) values
('024c9acd-d3e1-4cc4-9800-a9db85edaf57','Employer – Provided Health Insurance','Employer – Provided Health Insurance','STRING','DROPDOWN',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'employerprovided',false,'4.4.7','/clients/{clientid}/enrollments/{enrollmentid}/healthinsurances/{healthinsuranceid}');

INSERT INTO "v2020".hmis_type (name,value,description,status) values ('employerprovided','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('employerprovided','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('employerprovided','8','Client doesn''t know','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('employerprovided','9','Client refused','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('employerprovided','99','Data not collected','ACTIVE');

insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template) values
('024c9acd-d3e1-4cc4-9800-a9db85edaf58','Private Pay Health Insurance','Private Pay Health Insurance','STRING','DROPDOWN',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'cobra',false,'4.4.8','/clients/{clientid}/enrollments/{enrollmentid}/healthinsurances/{healthinsuranceid}');

INSERT INTO "v2020".hmis_type (name,value,description,status) values ('cobra','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('cobra','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('cobra','8','Client doesn''t know','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('cobra','9','Client refused','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('cobra','99','Data not collected','ACTIVE');

insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template) values
('024c9acd-d3e1-4cc4-9800-a9db85edaf59','Private Pay Health Insurance','Private Pay Health Insurance','STRING','DROPDOWN',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'privatepay',false,'4.4.9','/clients/{clientid}/enrollments/{enrollmentid}/healthinsurances/{healthinsuranceid}');

INSERT INTO "v2020".hmis_type (name,value,description,status) values ('privatepay','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('privatepay','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('privatepay','8','Client doesn''t know','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('privatepay','9','Client refused','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('privatepay','99','Data not collected','ACTIVE');

insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template) values
('024c9acd-d3e1-4cc4-9800-a9db85edaf20','State Health Insurance for Adults','State Health Insurance for Adults','STRING','DROPDOWN',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'statehealthinadults',false,'4.4.10','/clients/{clientid}/enrollments/{enrollmentid}/healthinsurances/{healthinsuranceid}');

INSERT INTO "v2020".hmis_type (name,value,description,status) values ('statehealthinadults','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('statehealthinadults','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('statehealthinadults','8','Client doesn''t know','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('statehealthinadults','9','Client refused','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('statehealthinadults','99','Data not collected','ACTIVE');


insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template) values
('024c9acd-d3e1-4cc4-9800-a9db85edaf21','Indian Health Services Program','Indian Health Services Program','STRING','DROPDOWN',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'indianhealthservices',false,'4.4.11','/clients/{clientid}/enrollments/{enrollmentid}/healthinsurances/{healthinsuranceid}');

INSERT INTO "v2020".hmis_type (name,value,description,status) values ('indianhealthservices','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('indianhealthservices','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('indianhealthservices','8','Client doesn''t know','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('indianhealthservices','9','Client refused','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('indianhealthservices','99','Data not collected','ACTIVE');


insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template) values
('024c9acd-d3e1-4cc4-9800-a9db85edaf22','Reason not insured under Indian Health Services Program','Reason not insured under Indian Health Services Program','STRING','DROPDOWN',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'noindianhealthservicesreason',false,'4.4.11A','/clients/{clientid}/enrollments/{enrollmentid}/healthinsurances/{healthinsuranceid}');


INSERT INTO "v2020".hmis_type (name,status,value,description) values ('noindianhealthservicesreason','ACTIVE','1','Applied; decision pending');
INSERT INTO "v2020".hmis_type (name,status,value,description) values ('noindianhealthservicesreason','ACTIVE','2','Applied; client not eligible');    
INSERT INTO "v2020".hmis_type (name,status,value,description) values ('noindianhealthservicesreason','ACTIVE','3','Client did not apply');
INSERT INTO "v2020".hmis_type (name,status,value,description) values ('noindianhealthservicesreason','ACTIVE','4','Insurance type N/A for this client');
INSERT INTO "v2020".hmis_type (name,value,description,status)  values ('noindianhealthservicesreason','8','Client does not know','ACTIVE'); 
INSERT INTO "v2020".hmis_type (name,value,description,status)  values ('noindianhealthservicesreason','9','Client refused','ACTIVE');  
INSERT INTO "v2020".hmis_type (name,value,description,status)  values ('noindianhealthservicesreason','99','Data not collected','ACTIVE');  



insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template) values
('024c9acd-d3e1-4cc4-9800-a9db85edaf23','Other insurance','Other insurance','STRING','DROPDOWN',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'other_insurance',false,'4.4.12','/clients/{clientid}/enrollments/{enrollmentid}/healthinsurances/{healthinsuranceid}');


INSERT INTO "v2020".hmis_type (name,value,description,status) values ('other_insurance','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('other_insurance','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('other_insurance','8','Client doesn''t know','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('other_insurance','9','Client refused','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('other_insurance','99','Data not collected','ACTIVE');

insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template) values
('024c9acd-d3e1-4cc4-9800-a9db85edaf24','HIV/AIDS','HIV/AIDS','STRING','DROPDOWN',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'hivaidsassistance',false,'W3.2','/clients/{clientid}/enrollments/{enrollmentid}/healthinsurances/{healthinsuranceid}');


INSERT INTO "v2020".hmis_type (name,value,description,status) values ('hivaidsassistance','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('hivaidsassistance','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('hivaidsassistance','8','Client doesn''t know','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('hivaidsassistance','9','Client refused','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('hivaidsassistance','99','Data not collected','ACTIVE');

insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template) values
('024c9acd-d3e1-4cc4-9800-a9db85edaf25','Receiving AIDS Drug Assistance Program','Receiving AIDS Drug Assistance Program','STRING','DROPDOWN',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'adap',false,'W3.3','/clients/{clientid}/enrollments/{enrollmentid}/healthinsurances/{healthinsuranceid}');


INSERT INTO "v2020".hmis_type (name,value,description,status) values ('adap','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('adap','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('adap','8','Client doesn''t know','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('adap','9','Client refused','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('adap','99','Data not collected','ACTIVE');


insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template) values
('024c9acd-d3e1-4cc4-9800-a9db85edaf26','Connection with SOAR','Connection with SOAR','STRING','DROPDOWN',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'connection_with_soar',false,'P4.1','/clients/{clientid}/enrollments/{enrollmentid}/healthinsurances/{healthinsuranceid}');



insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template) values
('024c9acd-d3e1-4cc4-9800-a9db85edaf27','Domestic Violence Victim/Survivor','Domestic Violence Victim/Survivor','STRING','DROPDOWN',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'domesticviolencevictim',false,'4.11.2','/clients/{clientid}/enrollments/{enrollmentid}/healthinsurances/{healthinsuranceid}');


INSERT INTO "v2020".hmis_type (name,value,description,status) values ('domesticviolencevictim','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('domesticviolencevictim','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('domesticviolencevictim','8','Client doesn''t know','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('domesticviolencevictim','9','Client refused','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('domesticviolencevictim','99','Data not collected','ACTIVE');



insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template) values
('024c9acd-d3e1-4cc4-9800-a9db85edaf28','Are you currently fleeing?','Are you currently fleeing?','STRING','DROPDOWN',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'currently_fleeing',false,'4.11.B','/clients/{clientid}/enrollments/{enrollmentid}/healthinsurances/{healthinsuranceid}');


INSERT INTO "v2020".hmis_type (name,value,description,status) values ('currently_fleeing','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('currently_fleeing','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('currently_fleeing','8','Client doesn''t know','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('currently_fleeing','9','Client refused','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('currently_fleeing','99','Data not collected','ACTIVE');


insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template) values
('024c9acd-d3e1-4cc4-9800-a9db85edaf29','General Health Status','General Health Status','STRING','DROPDOWN',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'health_category',false,'R8.1','/clients/{clientid}/enrollments/{enrollmentid}/healthstatuses/{healthstatusid}');


insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template) values
('024c9acd-d3e1-4cc4-9800-a9db85edaf30','Dental Health Status','Dental Health Status','STRING','DROPDOWN',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'health_category',false,'R8.1','/clients/{clientid}/enrollments/{enrollmentid}/healthstatuses/{healthstatusid}');

insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template) values
('024c9acd-d3e1-4cc4-9800-a9db85edaf31','Mental Health Status','Mental Health Status','STRING','DROPDOWN',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'health_category',false,'R9.1','/clients/{clientid}/enrollments/{enrollmentid}/healthstatuses/{healthstatusid}');


insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template) values
('024c9acd-d3e1-4cc4-9800-a9db85edaf32','Pregnancy Status','Pregnancy Status','STRING','DROPDOWN',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'health_category',false,'R10.1','/clients/{clientid}/enrollments/{enrollmentid}/healthstatuses/{healthstatusid}');


insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template) values
('024c9acd-d3e1-4cc4-9800-a9db85edaf33','Last grade completed','Last grade completed','STRING','DROPDOWN',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'lastgradecompleted',false,'R4.1','/clients/{clientid}/enrollments/{enrollmentid}/educations/{educationid}');

INSERT INTO "v2020".hmis_type (name,value,description,status) values ('lastgradecompleted','1','Less than Grade 5','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('lastgradecompleted','2','Grades 5-6','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('lastgradecompleted','3','Grades 7-8','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('lastgradecompleted','4','Grades 9-11','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('lastgradecompleted','5','Grade 12','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('lastgradecompleted','6','School program does not have grade levels','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('lastgradecompleted','7','GED','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('lastgradecompleted','10','Some college','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('lastgradecompleted','11','Associate''s degree','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('lastgradecompleted','12','Bachelor''s degree','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('lastgradecompleted','13','Graduate degree','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('lastgradecompleted','14','Vocational certification','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('lastgradecompleted','8','Client doesn''t know','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('lastgradecompleted','9','Client refused','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('lastgradecompleted','99','Data not collected','ACTIVE');



INSERT INTO "v2020".hmis_type (name,value,description,status) values ('school_status','1','Attending school regularly','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('school_status','2','Attending school irregularly','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('school_status','3','Graduated from high school','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('school_status','4','Obtained GED','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('school_status','5','Dropped out','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('school_status','6','Suspended','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('school_status','7','Expelled','ACTIVE');			
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('school_status','8','Client doesn''t know','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('school_status','9','Client refused','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('school_status','99','Data not collected','ACTIVE');

insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template) values
('024c9acd-d3e1-4cc4-9800-a9db85edaf34','School status','School status','STRING','DROPDOWN',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'school_status',false,'R5.1','/clients/{clientid}/enrollments/{enrollmentid}/educations/{educationid}');

insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template) values
('024c9acd-d3e1-4cc4-9800-a9db85edaf35','Employed','Employed','STRING','DROPDOWN',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'employed',false,'R6.2','/clients/{clientid}/enrollments/{enrollmentid}/employments/{employmentid}');

insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template) values
('024c9acd-d3e1-4cc4-9800-a9db85edaf36','Type of Employment','Type of Employment','STRING','DROPDOWN',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'employment_type',false,'R6.A','/clients/{clientid}/enrollments/{enrollmentid}/employments/{employmentid}');

insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template) values
('024c9acd-d3e1-4cc4-9800-a9db85edaf37','Why Not Employed','Why Not Employed','STRING','DROPDOWN',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'not_employed_reason',false,'R6.B','/clients/{clientid}/enrollments/{enrollmentid}/employments/{employmentid}');

insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template) values
('024c9acd-d3e1-4cc4-9800-a9db85edaf38','T-Cell (CD4) Count Available','T-Cell (CD4) Count Available','STRING','DROPDOWN',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'tcellcountavailable',false,'W4.2','/clients/{clientid}/enrollments/{enrollmentid}/disabilities/{disabilityid}');

insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template) values
('024c9acd-d3e1-4cc4-9800-a9db85edaf39','T-cell Count','T-cell Count','STRING','DROPDOWN',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'tcellcount',false,'W4.A','/clients/{clientid}/enrollments/{enrollmentid}/disabilities/{disabilityid}');

insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template) values
('024c9acd-d3e1-4cc4-9800-a9db85edaf10','T-cell Source','T-cell Source','STRING','DROPDOWN',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'tcellcountsource',false,'W4.B','/clients/{clientid}/enrollments/{enrollmentid}/disabilities/{disabilityid}');

insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template) values
('024c9acd-d3e1-4cc4-9800-a9db85edaf11','Viral Load Information Available','Viral Load Information Available','STRING','DROPDOWN',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'viral_load_available',false,'W4.3','/clients/{clientid}/enrollments/{enrollmentid}/disabilities/{disabilityid}');

insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template) values
('024c9acd-d3e1-4cc4-9800-a9db85edaf12','Viral Load','Viral Load ','STRING','DROPDOWN',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'viral_load',false,'W4.C','/clients/{clientid}/enrollments/{enrollmentid}/disabilities/{disabilityid}');

insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template) values
('024c9acd-d3e1-4cc4-9800-a9db85edaf14','Viral Load Source','Viral Load Source','STRING','DROPDOWN',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'viral_load_source',false,'W4.D','/clients/{clientid}/enrollments/{enrollmentid}/disabilities/{disabilityid}');


update v2020.question set 
hud_question_id='4.12.2A',
update_url_template='/clients/{clientid}/enrollments/{enrollmentid}/contacts/{contactid}' ,
question_description='Contact location',
display_text='Contact location'
where picklist_group_name='contact_location';

ALTER TYPE v2020.years_juvenile_justice add value '99';
ALTER TYPE v2020.years_child_welfr_forest_care add value '99';
ALTER TYPE v2020.no_yes add value '2';

INSERT INTO "v2020".hmis_type (name,value,description,status) values ('after_provided','8','Client doesn''t know','ACTIVE');



insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template,uri_object_field) values
('024c9acd-d3e1-4cc4-9800-a9db85edad18','Other Type provided','Other Type provided','STRING','STRING',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'other_type_provided',false,'4.12','/v2020/clients/{clientid}/enrollments/{enrollmentid}/servicefareferrals/{servicefareferralid}','servicefareferral.otherTypeProvided');

insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template,uri_object_field) values
('024c9acd-d3e1-4cc4-9800-a9db85edad19','Sub Type provided','Sub Type provided','STRING','STRING',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'sub_type_provided',false,'4.12','/v2020/clients/{clientid}/enrollments/{enrollmentid}/servicefareferrals/{servicefareferralid}','servicefareferral.subTypeProvided');

insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template,uri_object_field) values
('024c9acd-d3e1-4cc4-9800-a9db85edad20','Fa amount','Fa amount','STRING','MONEY',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'fa_amount',false,'4.12','/v2020/clients/{clientid}/enrollments/{enrollmentid}/servicefareferrals/{servicefareferralid}','servicefareferral.faAmount');

insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template,uri_object_field) values
('024c9acd-d3e1-4cc4-9800-a9db85edad21','Referral outcome','Referral outcome','STRING','MONEY',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'referral_outcome',false,'4.16A','/v2020/clients/{clientid}/enrollments/{enrollmentid}/servicefareferrals/{servicefareferralid}','servicefareferral.referralOutcome');

INSERT INTO "v2020".hmis_type (name,value,description,status) values ('referral_outcome','1','Attained','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('referral_outcome','2','Not attained','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('referral_outcome','3','Unknown','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('referral_outcome','99','Data not collected','ACTIVE');

insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template,uri_object_field) values
('024c9acd-d3e1-4cc4-9800-a9db85edad22','Coc code','Coc code','STRING','STRING',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,	(null),	
true,'coccode',false,'2.8.2','/v2020/{projectid}/projectcocs/{projectcocid}/geographies/{geographyid}','geography.cocCode');

alter table v2020.geography add column coccode text;

insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template,uri_object_field) values
('024c9acd-d3e1-4cc4-9800-a9db85edad23','Physical Disability','Physical Disability',
'STRING','DROPDOWN',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,(null),	true,'indefiniteandimpairs',
false,'4.5.2A','/v2020/clients/{clientid}/enrollments/{enrollmentid}/disabilities/{disabilityid}','disabilities.indefiniteandImpairs');

insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template,uri_object_field) values
('024c9acd-d3e1-4cc4-9800-a9db85edad24','Developmental Disability','Developmental Disability',
'STRING','DROPDOWN',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,(null),	true,'indefiniteandimpairs',
false,'4.6.2A','/v2020/clients/{clientid}/enrollments/{enrollmentid}/disabilities/{disabilityid}','disabilities.indefiniteandImpairs');


insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template,uri_object_field) values
('024c9acd-d3e1-4cc4-9800-a9db85edad25','Chronic Health Condition','Chronic Health Condition',
'STRING','DROPDOWN',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,(null),	true,'indefiniteandimpairs',
false,'4.7.2A','/v2020/clients/{clientid}/enrollments/{enrollmentid}/disabilities/{disabilityid}','disabilities.indefiniteandImpairs');

insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template,uri_object_field) values
('024c9acd-d3e1-4cc4-9800-a9db85edad26','HIV/AIDS','HIV/AIDS',
'STRING','DROPDOWN',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,(null),	true,'indefiniteandimpairs',
false,'4.8.2A','/v2020/clients/{clientid}/enrollments/{enrollmentid}/disabilities/{disabilityid}','disabilities.indefiniteandImpairs');


insert into v2020.question(id,question_description,display_text,question_data_type,question_type,created_at,updated_at,user_id,is_active,picklist_group_name,deleted,hud_question_id,update_url_template,uri_object_field) values
('024c9acd-d3e1-4cc4-9800-a9db85edad28','Substance Abuse Problem','Substance Abuse Problem',
'STRING','DROPDOWN',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,(null),	true,'disabilityresponse',
false,'4.10.2','/v2020/clients/{clientid}/enrollments/{enrollmentid}/disabilities/{disabilityid}','disabilities.disabilityresponse');





DROP TABLE IF EXISTS "v2020".assessment;
DROP TABLE IF EXISTS "v2020".assessment_questions;
DROP TABLE IF EXISTS "v2020".assessment_results;

CREATE TYPE "v2020".assessment_type  AS ENUM ('1','2','3');
CREATE TYPE "v2020".assessment_level  AS ENUM ('1','2');
CREATE TYPE "v2020".prioritization_status AS ENUM ('1','2'); 
CREATE TYPE "v2020".event AS ENUM('1','2','3','4','5','6','7','8','9','10','11','12','13','14','15');

INSERT INTO "v2020".hmis_type (name,value,description,status) values ('event','1','Referral to Prevention Assistance project','ACTIVE'); 
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('event','2','Problem Solving/Diversion/Rapid Resolution intervention or service','ACTIVE'); 
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('event','3','Referral to scheduled Coordinated Entry Crisis Needs Assessment','ACTIVE'); 
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('event','4','Referral to scheduled Coordinated Entry Housing Needs Assessment','ACTIVE'); 
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('event','5','Referral to post-placement/follow-up case management','ACTIVE'); 
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('event','6','Referral to Street Outreach project or services','ACTIVE'); 
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('event','7','Referral to Housing Navigation project or services','ACTIVE'); 
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('event','8','Referral to Non-continuum services: Ineligible for continuum services','ACTIVE'); 
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('event','9','Referral to Non continuum services: No availability in continuum services','ACTIVE'); 
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('event','10','Referral to Emergency Shelter bed opening','ACTIVE'); 
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('event','11','Referral to Transitional Housing bed/unit opening','ACTIVE'); 
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('event','12','Referral to Joint TH-RRH project/unit/resource opening','ACTIVE'); 
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('event','13','Referral to RRH project resource opening','ACTIVE'); 
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('event','14','Referral to PSH project resource opening','ACTIVE'); 
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('event','15','Referral to Other PH project/unit/resource opening','ACTIVE'); 
				

INSERT INTO "v2020".hmis_type (name,value,description,status) values ('assessment_type','1','Phone','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('assessment_type','2','Virtual','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('assessment_type','3','In person','ACTIVE');

INSERT INTO "v2020".hmis_type (name,value,description,status) values ('assessment_level','1','Crisis Needs Assessment','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('assessment_level','2','Housing Needs Assessment','ACTIVE');

INSERT INTO "v2020".hmis_type (name,value,description,status) values ('prioritization_status','1','Placed on prioritization list','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('prioritization_status','2','Not placed on prioritization list','ACTIVE');

INSERT INTO "v2020".hmis_type (name,value,description,status) values ('leavesituation14days','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('leavesituation14days','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('leavesituation14days','8','Client doesn''t know','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('leavesituation14days','9','Client refused','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('leavesituation14days','99','Data not collected','ACTIVE');

INSERT INTO "v2020".hmis_type (name,value,description,status) values ('subsequentresidence','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('subsequentresidence','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('subsequentresidence','8','Client doesn''t know','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('subsequentresidence','9','Client refused','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('subsequentresidence','99','Data not collected','ACTIVE');

INSERT INTO "v2020".hmis_type (name,value,description,status) values ('resourcestoobtain','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('resourcestoobtain','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('resourcestoobtain','8','Client doesn''t know','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('resourcestoobtain','9','Client refused','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('resourcestoobtain','99','Data not collected','ACTIVE');

INSERT INTO "v2020".hmis_type (name,value,description,status) values ('leaseown60day','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('leaseown60day','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('leaseown60day','8','Client doesn''t know','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('leaseown60day','9','Client refused','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('leaseown60day','99','Data not collected','ACTIVE');

INSERT INTO "v2020".hmis_type (name,value,description,status) values ('movedtwoormore','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('movedtwoormore','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('movedtwoormore','8','Client doesn''t know','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('movedtwoormore','9','Client refused','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('movedtwoormore','99','Data not collected','ACTIVE');

INSERT INTO "v2020".hmis_type (name,value,description,status) values ('referral_case_manage_after','0','No','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('referral_case_manage_after','1','Yes','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('referral_case_manage_after','8','Client doesn''t know','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('referral_case_manage_after','9','Client refused','ACTIVE');
INSERT INTO "v2020".hmis_type (name,value,description,status) values ('referral_case_manage_after','99','Data not collected','ACTIVE');

   
   
create table "v2020".assessment
(
  "id" uuid not null,
  assessment_date date,
  assessment_location character varying(500),
  assessment_type "v2020".assessment_type,
  assessment_level "v2020".assessment_level,
  prioritization_status "v2020".prioritization_status,
  enrollmentid uuid,
  client_id uuid,
  "project_group_code" character varying(8),
  "date_created" timestamp,
  "date_created_from_source" timestamp,
  "date_updated_from_source" timestamp,
  "date_updated" timestamp,
  "user_id" uuid,
  export_id uuid,
  parent_id uuid,
  version integer,source_system_id text,
  deleted boolean DEFAULT false,active boolean DEFAULT true, 
  sync boolean DEFAULT false,
      constraint "assessment_pkey" primary key ("id"),
	  constraint "assessment_enrollmentid_fkey" foreign key ("enrollmentid")
      references v2020.enrollment ("id") match simple
      on update no action on delete no action
)
with (
  oids=false
);

create table "v2020".assessment_questions
(
  "id" uuid not null,
  assessment_id uuid,
  enrollmentid uuid,
  client_id uuid,
   assessment_question_group  character varying(500),
   assessment_question_order integer,
   assessment_question  character varying(500),
   assessment_answer   character varying(500),
  "project_group_code" character varying(8),
  "date_created" timestamp,
  "date_created_from_source" timestamp,
  "date_updated_from_source" timestamp,
  "date_updated" timestamp,
  "user_id" uuid,
  export_id uuid,
  parent_id uuid,
  version integer,source_system_id text,
  deleted boolean DEFAULT false,active boolean DEFAULT true, 
  sync boolean DEFAULT false,
      constraint "assessment_questions_pkey" primary key ("id"),
	  constraint "assessment_questions_enrollmentid_fkey" foreign key ("enrollmentid")
      references v2020.enrollment ("id") match simple
      on update no action on delete no action,
      CONSTRAINT assessment_questions_client_fk FOREIGN KEY ("client_id")
      	REFERENCES "v2020".client ("id") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
       CONSTRAINT assessment_questions_assessment_fk FOREIGN KEY ("assessment_id")
      	REFERENCES "v2020".assessment_id ("id") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
with (
  oids=false
);



create table "v2020".assessment_results
(
  "id" uuid not null,
  assessment_id uuid,
  enrollmentid uuid,
  client_id uuid,
   assessment_result  character varying(500),
  "project_group_code" character varying(8),
  "date_created" timestamp,
  "date_created_from_source" timestamp,
  "date_updated_from_source" timestamp,
  "date_updated" timestamp,
  "user_id" uuid,
  export_id uuid,
  parent_id uuid,
  version integer,source_system_id text,
  deleted boolean DEFAULT false,active boolean DEFAULT true, 
  sync boolean DEFAULT false,
	  constraint "assessment_results_pkey" primary key ("id"),
	  constraint "assessment_results_enrollmentid_fkey" foreign key ("enrollmentid")
      references v2020.enrollment ("id") match simple
      on update no action on delete no action,
      CONSTRAINT assessment_results_client_fk FOREIGN KEY ("client_id")
      	REFERENCES "v2020".client ("id") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
       CONSTRAINT assessment_results_assessment_fk FOREIGN KEY ("assessment_id")
      	REFERENCES "v2020".assessment_id ("id") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
with (
  oids=false
);

  create table "v2020".current_living_situation
(
  "id" uuid not null,
   enrollmentid uuid,
   client_id uuid,
   livingSituation  v2020.livingSituation,
   verified_by  character varying(500),
   leavesituation14days  v2020.no_yes_refused,
   subsequentresidence v2020.no_yes_refused,
   resourcestoobtain v2020.no_yes_refused,
   leaseown60day v2020.no_yes_refused,
   movedtwoormore v2020.no_yes_refused,
   locationdetails  character varying(500),
  "project_group_code" character varying(8),
  "date_created" timestamp,
  "date_created_from_source" timestamp,
  "date_updated_from_source" timestamp,
  "date_updated" timestamp,
  "user_id" uuid,
  export_id uuid,
  parent_id uuid,
  version integer,source_system_id text,
  deleted boolean DEFAULT false,active boolean DEFAULT true, 
  sync boolean DEFAULT false,
	  constraint "current_living_situation_pkey" primary key ("id"),
	  constraint "current_living_situation_enrollmentid_fkey" foreign key ("enrollmentid")
      references v2020.enrollment ("id") match simple
      on update no action on delete no action,
      CONSTRAINT current_living_situation_client_fk FOREIGN KEY ("client_id")
      	REFERENCES "v2020".client ("id") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
with (
  oids=false
); 


 create table "v2020".event
(
  "id" uuid not null,
   enrollmentid uuid,
   client_id uuid,
   event_date  date,
   event  v2020.event,
   referral_case_manage_after  v2020.no_yes_refused,
   locationcrisisorphhousing  character varying(500),
   referral_result character varying(500),
   result_date date,
  "project_group_code" character varying(8),
  "date_created" timestamp,
  "date_created_from_source" timestamp,
  "date_updated_from_source" timestamp,
  "date_updated" timestamp,
  "user_id" uuid,
  export_id uuid,
  parent_id uuid,
  version integer,source_system_id text,
  deleted boolean DEFAULT false,active boolean DEFAULT true, 
  sync boolean DEFAULT false,
	  constraint "event_pkey" primary key ("id"),
	  constraint "event_enrollmentid_fkey" foreign key ("enrollmentid")
      references v2020.enrollment ("id") match simple
      on update no action on delete no action,
      CONSTRAINT event_client_fk FOREIGN KEY ("client_id")
      	REFERENCES "v2020".client ("id") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
with (
  oids=false
);          
