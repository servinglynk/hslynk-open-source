DROP SCHEMA IF EXISTS "v2017" cascade;
CREATE SCHEMA "v2017";
DROP TABLE IF EXISTS "v2017".hmis_type;
DROP TABLE IF EXISTS "v2017".path_status;
DROP TABLE IF EXISTS "v2017".rhybcp_status;
DROP TABLE IF EXISTS "v2017".employment;
DROP TABLE IF EXISTS "v2017".health_status;
DROP TABLE IF EXISTS "v2017".affiliation;
DROP TABLE IF EXISTS "v2017".inventory;
DROP TABLE IF EXISTS "v2017".funder;	
DROP TABLE IF EXISTS "v2017".enrollment_coc;
DROP TABLE IF EXISTS "v2017".medicalassistance;
DROP TABLE IF EXISTS "v2017".domesticviolence;
DROP TABLE IF EXISTS "v2017".disabilities;
DROP TABLE IF EXISTS "v2017".moveinDate;
DROP TABLE IF EXISTS "v2017".dateofengagement;
DROP TABLE IF EXISTS "v2017".incomeandsources;
DROP TABLE IF EXISTS "v2017".noncashbenefits;
DROP TABLE IF EXISTS "v2017".healthinsurance;
DROP TABLE IF EXISTS "v2017".exithousingassessment;
DROP TABLE IF EXISTS "v2017".housingassessmentdisposition;
DROP TABLE IF EXISTS "v2017".exit;
DROP TABLE IF EXISTS "v2017".coc;
DROP TABLE IF EXISTS "v2017".project; 
DROP TABLE IF EXISTS "v2017".enrollment;
DROP TABLE IF EXISTS "v2017".organization; 
DROP TABLE IF EXISTS "v2017".client_veteran_info;
DROP TABLE IF EXISTS "v2017".client;
DROP TABLE IF EXISTS "v2017".bulk_upload_activity;
DROP TABLE IF EXISTS "v2017".export; 
DROP TABLE IF EXISTS "v2017".source;
DROP TABLE IF EXISTS "v2017".exitRHY;
DROP TABLE IF EXISTS "v2017".rhyaftercare;
DROP TABLE IF EXISTS "v2017".vashexitreason;
DROP TABLE IF EXISTS "v2017".connectionwithsoar;
DROP TABLE IF EXISTS "v2017".geography;
DROP TABLE IF EXISTS "v2017".question;

DROP TYPE IF EXISTS "v2017".name_data_quality;
DROP TYPE IF EXISTS "v2017".dob_data_quality;
DROP TYPE IF EXISTS "v2017".ssn_data_quality;
DROP TYPE IF EXISTS "v2017".address_data_quality;
DROP TYPE IF EXISTS "v2017".veteran_status;
DROP TYPE IF EXISTS "v2017".race;
DROP TYPE IF EXISTS "v2017".gender;
DROP TYPE IF EXISTS "v2017".ethnicity;
DROP TYPE IF EXISTS "v2017".afghanistanoef;
DROP TYPE IF EXISTS "v2017".desertstorm;
DROP TYPE IF EXISTS "v2017".asked_forced_exchange_sex;
DROP TYPE IF EXISTS "v2017".assessment_disposition;
DROP TYPE IF EXISTS "v2017".availability;
DROP TYPE IF EXISTS "v2017".bed_type;
DROP TYPE IF EXISTS "v2017".count_of_exchange_sex;
DROP TYPE IF EXISTS "v2017".destination;
DROP TYPE IF EXISTS "v2017".disability_type;
DROP TYPE IF EXISTS "v2017".discharge_status;
DROP TYPE IF EXISTS "v2017".early_exit_reason;
DROP TYPE IF EXISTS "v2017".employment_type;
DROP TYPE IF EXISTS "v2017".federal_partner_components;
DROP TYPE IF EXISTS "v2017".five_val_dk_refused;
DROP TYPE IF EXISTS "v2017".fysb_rsn_not_providing_srvcs;
DROP TYPE IF EXISTS "v2017".health_category;
DROP TYPE IF EXISTS "v2017".health_status_type;
DROP TYPE IF EXISTS "v2017".house_hold_type;
DROP TYPE IF EXISTS "v2017".housing_assmnt_exit;
DROP TYPE IF EXISTS "v2017".homeless_atrisk_status;
DROP TYPE IF EXISTS "v2017".incarcerated_parent_status;	
DROP TYPE IF EXISTS "v2017".issues_number_of_years;
DROP TYPE IF EXISTS "v2017".last_grade_completed;
DROP TYPE IF EXISTS "v2017".military_branch;
DROP TYPE IF EXISTS "v2017".months_homeless_past_3_years;
DROP TYPE IF EXISTS "v2017".no_adap_reason;
DROP TYPE IF EXISTS "v2017".no_health_insurance_reason;
DROP TYPE IF EXISTS "v2017".no_medical_assistance_reason;
DROP TYPE IF EXISTS "v2017".not_employed_reason;
DROP TYPE IF EXISTS "v2017".no_yes;
DROP TYPE IF EXISTS "v2017".no_yes_refused;
DROP TYPE IF EXISTS "v2017".path_how_confirmed;	
DROP TYPE IF EXISTS "v2017".path_smi_info_how_confirmed;
DROP TYPE IF EXISTS "v2017".percentage_ami;
DROP TYPE IF EXISTS "v2017".project_completion_status;
DROP TYPE IF EXISTS "v2017".project_type;
DROP TYPE IF EXISTS "v2017".reason_not_enrolled;	
DROP TYPE IF EXISTS "v2017".record_type;
DROP TYPE IF EXISTS "v2017".referral_outcome;
DROP TYPE IF EXISTS "v2017".referral_source;
DROP TYPE IF EXISTS "v2017".relationship_to_head_of_household;
DROP TYPE IF EXISTS "v2017".residence_prior ;
DROP TYPE IF EXISTS "v2017".residence_prior_length_of_stay;
DROP TYPE IF EXISTS "v2017".school_status;
DROP TYPE IF EXISTS "v2017".sexual_orientation;	
DROP TYPE IF EXISTS "v2017".subsidy_information;
DROP TYPE IF EXISTS "v2017".target_population_type;
DROP TYPE IF EXISTS "v2017".times_homeless_past_3_years;
DROP TYPE IF EXISTS "v2017".tracking_method;
DROP TYPE IF EXISTS "v2017".when_dom_violence_occurred;
DROP TYPE IF EXISTS "v2017".youth_age_group;
DROP TYPE IF EXISTS "v2017".housing_status;
DROP TYPE IF EXISTS "v2017".state;
DROP TYPE IF EXISTS "v2017".contact_location;
DROP TYPE IF EXISTS "v2017".datacollectionstage;
DROP TYPE IF EXISTS "v2017".timeToHousingLoss;
DROP TYPE IF EXISTS "v2017".annualpercentami;
DROP TYPE IF EXISTS "v2017".evictionhistory;
DROP TYPE IF EXISTS "v2017".crisisServicesUse;	
DROP TYPE IF EXISTS "v2017".literalHomelessHistory;
DROP TYPE IF EXISTS "v2017".livingSituation;
DROP TYPE IF EXISTS "v2017".lengthOfStay;
DROP TYPE IF EXISTS "v2017".record_type;
DROP TYPE IF EXISTS "v2017".housingType;
DROP TYPE IF EXISTS "v2017".tcell_viralload_source;
DROP TYPE IF EXISTS "v2017".viral_load_available;
DROP TYPE IF EXISTS "v2017".cm_exit_reason;
DROP TYPE IF EXISTS "v2017".geography_type;


CREATE TYPE "v2017".cm_exit_reason AS ENUM ('1','2','3','4','5','6','7','8','9','10','11','12','13','99');
CREATE TYPE "v2017".tcell_viralload_source AS ENUM('1','2','3','99');
CREATE TYPE "v2017".viral_load_available AS ENUM('0','1','2','8','9','99');

CREATE TYPE "v2017".livingSituation AS ENUM('1','2','3','4','5','6','7','8','9','12','13','14','15','16','17','18','19','20','21','22','23','24','25','26','27','99');
CREATE TYPE "v2017".lengthOfStay AS ENUM('2','3','4','5','8','9','10','11','99');
CREATE TYPE "v2017".literalHomelessHistory AS ENUM('0','1','2','99');
CREATE TYPE "v2017".timeToHousingLoss as ENUM('0','1','2','3','99');
CREATE TYPE "v2017".annualpercentami as ENUM('0','1','2','99');
CREATE TYPE "v2017".crisisServicesUse as ENUM('0','1','2','3','4','5','8','9','99');

CREATE TYPE "v2017".name_data_quality AS ENUM ('1', '2', '8','9','99');
CREATE TYPE "v2017".dob_data_quality AS ENUM ('1', '2', '8','9','99');
CREATE TYPE "v2017".ssn_data_quality AS ENUM ('1', '2', '8','9','99');
CREATE TYPE "v2017".address_data_quality AS ENUM ('1', '2', '8','9','99');

CREATE TYPE "v2017".veteran_status AS ENUM ('0', '1', '8','9','99');
CREATE TYPE "v2017".race AS ENUM ('1', '2','3','4','5','8','9','99');
CREATE TYPE "v2017".gender AS ENUM ('0','1', '2','3','4','8','9','99');
CREATE TYPE "v2017".ethnicity AS ENUM ('0', '1', '8','9','99');
CREATE TYPE "v2017".afghanistanoef AS ENUM ('0', '1', '8','9','99');
CREATE TYPE "v2017".desertstorm AS ENUM ('0', '1', '8','9','99');
CREATE TYPE "v2017".asked_forced_exchange_sex AS ENUM ('0', '1', '8','9','99');
CREATE TYPE "v2017".assessment_disposition AS ENUM ('1','2','3','4','5','6','7','8','9','10','11','12','13','14');
CREATE TYPE "v2017".availability AS ENUM ('1', '2', '3');
CREATE TYPE "v2017".bed_type AS ENUM ('1', '2', '3');
CREATE TYPE "v2017".count_of_exchange_sex AS ENUM ('1', '2', '3','4','8','9');
CREATE TYPE "v2017".destination AS ENUM 
('24','1','15','6','14','7','25','26','27','11','21','3','16','4','10','19','28','20','29','18','22','12','23','13','5','2','17','30','8','9','99');
CREATE TYPE "v2017".disability_type AS ENUM ('5','6','7','8','9','10');
CREATE TYPE "v2017".discharge_status AS ENUM ('1','2','4','5','6','7','8','9','99');
CREATE TYPE "v2017".early_exit_reason AS ENUM ('1','2','3','4','5','6','99');
CREATE TYPE "v2017".employment_type AS ENUM ('1','2','3','99');
CREATE TYPE "v2017".federal_partner_components AS ENUM 
('1','2','3','4','5','6','7','8','9','10','11','12','13','14','15','16','17','18','19','20','21','22','23','24','25','26','27','28','29','30','31','32','33','34');
CREATE TYPE "v2017".five_val_dk_refused AS ENUM ('0','1','8','9','99');
CREATE TYPE "v2017".fysb_rsn_not_providing_srvcs AS ENUM ('1','2','3','4','99');
CREATE TYPE "v2017".health_category AS ENUM ('27','28','29');
CREATE TYPE "v2017".health_status_type AS ENUM ('1', '2','3','4','5','8','9','99');
CREATE TYPE "v2017".house_hold_type AS ENUM ('1','3','5');
CREATE TYPE "v2017".housing_assmnt_exit AS ENUM ('1','2','3','4','5','6','7','8','9','10','99');
CREATE TYPE "v2017".homeless_atrisk_status AS ENUM ('1','2','3','4','5','6','8','9','99');

CREATE TYPE "v2017".incarcerated_parent_status AS ENUM ('1','2','3','99');	
CREATE TYPE "v2017".issues_number_of_years AS ENUM ('1','2','3');
CREATE TYPE "v2017".last_grade_completed  AS ENUM ('1','2','3','4','5','6','7','10','8','9','99');
CREATE TYPE "v2017".military_branch AS ENUM ('1','2','3','4','6','8','9','99');
CREATE TYPE "v2017".months_homeless_past_3_years AS ENUM ('7','8','9','99','100','101','102','103','104','105','106','107','108','109','110','111','112');
CREATE TYPE "v2017".no_adap_reason AS ENUM ('1','2','3','4','8','9','99');
CREATE TYPE "v2017".no_health_insurance_reason AS ENUM ('1','2','3','4','8','9','99');
CREATE TYPE "v2017".no_medical_assistance_reason AS ENUM (	
'1',
'2',
'3',
'4',
'8',
'9',
'99');
CREATE TYPE "v2017".not_employed_reason  AS ENUM (	
'1',
'2',
'3',
'99');
CREATE TYPE "v2017".no_yes  AS ENUM (	
'0',
'1',
'8',
'9',
'99');
CREATE TYPE "v2017".no_yes_refused AS ENUM (
'0',
'1',
'9',
'99');
CREATE TYPE "v2017".path_how_confirmed AS ENUM (	
'1',
'2',
'3',
'99');
CREATE TYPE "v2017".path_smi_info_how_confirmed AS ENUM (	
'0',
'1',
'2',
'3',
'8',
'9',
'99');
CREATE TYPE "v2017".percentage_ami AS ENUM (	
'1',
'2',
'3',
'99');

CREATE TYPE "v2017".project_completion_status AS ENUM (	
'1',
'2',
'3',
'99');

CREATE TYPE "v2017".housingType AS ENUM (	
'1',
'2',
'3');


CREATE TYPE "v2017".project_type AS ENUM (
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
CREATE TYPE "v2017".reason_not_enrolled AS ENUM (	
'1',
'2',
'99');
CREATE TYPE "v2017".record_type AS ENUM (	
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

CREATE TYPE "v2017".referral_outcome AS ENUM (	
'1',
'2',
'3');
CREATE TYPE "v2017".referral_source AS ENUM (	
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

CREATE TYPE "v2017".relationship_to_head_of_household AS ENUM (
'1',
'2',
'3',
'4',
'5');
CREATE TYPE "v2017".residence_prior  AS ENUM (	
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

CREATE TYPE "v2017".residence_prior_length_of_stay AS ENUM (	
'2',
'3',
'4',
'5',
'8',
'9',
'10',
'11',
'99');
CREATE TYPE "v2017".school_status AS ENUM (	
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
CREATE TYPE "v2017".sexual_orientation AS ENUM (	
'1',
'2',
'3',
'4',
'5',
'8',
'9',
'99');
CREATE TYPE "v2017".subsidy_information  AS ENUM (
'1',
'2',
'3',
'4');
CREATE TYPE "v2017".target_population_type  AS ENUM ( 	
'1',
'3',
'4');

CREATE TYPE "v2017".times_homeless_past_3_years  AS ENUM (
'0',
'1',
'2',
'3',
'4',
'8',
'9',
'99');

CREATE TYPE "v2017".tracking_method  AS ENUM ( 	
'0',
'3');
CREATE TYPE "v2017".when_dom_violence_occurred AS ENUM (
'1',
'2',
'3',
'4',
'8',
'9',
'99');
CREATE TYPE "v2017".youth_age_group  AS ENUM (	
'1',
'2',
'3');

CREATE TYPE "v2017".housing_status AS ENUM (
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

CREATE TYPE "v2017".state AS ENUM (
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
CREATE TYPE "v2017".percentAMI  AS ENUM ('1','2','3','99');
CREATE TYPE "v2017".connection_with_soar  AS ENUM ('0','1','8','9','99');
CREATE TYPE "v2017".contact_location  AS ENUM ('1','2','3');

CREATE TYPE "v2017".written_after_care_plan  AS ENUM ('0','1','2','99');
CREATE TYPE "v2017".assistance_main_stream_benefits  AS ENUM ('0','1','2','99');
CREATE TYPE "v2017".permanent_housing_placement  AS ENUM ('0','1','2','99');
CREATE TYPE "v2017".temp_shelter_placement  AS ENUM ('0','1','2','99');
CREATE TYPE "v2017".exit_counseling  AS ENUM ('0','1','2','99');
CREATE TYPE "v2017".further_followup_services  AS ENUM ('0','1','2','99');
CREATE TYPE "v2017".scheduled_followup_contacts  AS ENUM ('0','1','2','99');
CREATE TYPE "v2017".resource_package  AS ENUM ('0','1','2','99');
CREATE TYPE "v2017".other_aftercare_plan_or_action  AS ENUM ('0','1','2','99');
CREATE TYPE "v2017".family_reunification_achieved  AS ENUM ('0','1','8','9','99');


CREATE TYPE "v2017".active_military_parent AS ENUM ('0','1','99');
CREATE TYPE "v2017".house_hold_dynamics AS ENUM ('0','1','99');
CREATE TYPE "v2017".insufficient_income_to_support_youth AS ENUM ('0','1','99'); 
CREATE TYPE "v2017".alcohol_drug_abuse_family_mbr AS ENUM ('0','1','99');
CREATE TYPE "v2017".alcohol_drug_abuse_youth AS ENUM ('0','1','99');
CREATE TYPE "v2017".abuse_and_neglect_family_mbr AS ENUM ('0','1','99');
CREATE TYPE "v2017".abuse_and_neglect_youth AS ENUM ('0','1','99');
CREATE TYPE "v2017".mental_disability_family_mbr AS ENUM ('0','1','99');
CREATE TYPE "v2017".mental_disability_youth AS ENUM ('0','1','99');
CREATE TYPE "v2017".physical_disability_family_mbr AS ENUM ('0','1','99');
CREATE TYPE "v2017".physical_disability_youth AS ENUM ('0','1','99');
CREATE TYPE "v2017".health_issues_family_mbr AS ENUM ('0','1','99');
CREATE TYPE "v2017".health_issues_youth AS ENUM ('0','1','99');
CREATE TYPE "v2017".mental_health_issues_family_mbrily_mbr AS ENUM ('0','1','99');
CREATE TYPE "v2017".mental_health_issues_youth AS ENUM ('0','1','99');
CREATE TYPE "v2017".unemployement_family_mbr AS ENUM ('0','1','99');
CREATE TYPE "v2017".school_educational_issues_youth AS ENUM ('0','1','99');
CREATE TYPE "v2017".school_education_issues_family_mbr AS ENUM ('0','1','99');
CREATE TYPE "v2017".unemployment_youth AS ENUM ('0','1','99');
CREATE TYPE "v2017".incarcerated_parent AS ENUM ('0','1','99');
CREATE TYPE "v2017".housing_issues_family_mbr AS ENUM ('0','1','99');
CREATE TYPE "v2017".housing_issues_youth AS ENUM ('0','1','99');
CREATE TYPE "v2017".sexual_orientation_gender_identity_Youth AS ENUM ('0','1','99');
CREATE TYPE "v2017".sexual_orientatiion_gender_identity_family_mbr AS ENUM ('0','1','99');

CREATE TYPE "v2017".years_child_welfr_forest_care AS ENUM ('1','2','3');
CREATE TYPE "v2017".years_juvenile_justice AS ENUM ('1','2','3');

CREATE TYPE "v2017".formerly_ward_child_welfr_forest_care AS ENUM ('0','1','8','9','99');
CREATE TYPE "v2017".formerly_ward_of_juvenile_justice AS ENUM ('0','1','8','9','99');
CREATE TYPE "v2017".asked_of_forced_to_exchange_for_sex_past_3_months AS ENUM ('0','1','8','9','99');
CREATE TYPE "v2017".exchange_for_sex_past_three_months AS ENUM ('0','1','8','9','99');
CREATE TYPE "v2017".coerced_to_continue_work AS ENUM ('0','1','8','9','99');
CREATE TYPE "v2017".work_place_promise_difference AS ENUM ('0','1','8','9','99');
CREATE TYPE "v2017".work_place_violence_threats AS ENUM ('0','1','8','9','99');

CREATE TYPE "v2017".count_of_exchange_for_sex AS ENUM ('1','2','3','4','8','9','99');
CREATE TYPE "v2017".asked_of_forced_to_exchange_for_sex AS ENUM ('0','1','8','9','99');
CREATE TYPE "v2017".datacollectionstage AS ENUM('1','2','3','5');
CREATE TYPE "v2017".evictionhistory as ENUM('0','1','2','3','99');

CREATE TYPE "v2017".geography_type as ENUM('1','2','3');

CREATE TABLE "v2017".hmis_type
(
  "id" serial NOT NULL ,
  "name" character(50) NOT NULL,
  "value" character(50) NOT NULL,
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

INSERT INTO "v2017".hmis_type (name,value,description,status) values ('tcellcountsource','1','Medical Report','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('tcellcountsource','2','Client Report','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('tcellcountsource','3','Other','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('tcellcountsource','99','Data not collected','ACTIVE');

INSERT INTO "v2017".hmis_type (name,value,description,status) values ('viral_load_source','1','Medical Report','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('viral_load_source','2','Client Report','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('viral_load_source','3','Other','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('viral_load_source','99','Data not collected','ACTIVE');

INSERT INTO "v2017".hmis_type (name,value,description,status) values ('viral_load_available','0','Not available','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('viral_load_available','1','Available','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('viral_load_available','2','Undetectable','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('viral_load_available','8','Client doesn''t know','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('viral_load_available','9','Client refused','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('viral_load_available','99','Data not collected','ACTIVE');



INSERT INTO "v2017".hmis_type (name,value,description,status) values ('literalHomelessHistory','0','4 or more times or total of at least 12 months in past three years','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('literalHomelessHistory','1','2-3 times in past three years','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('literalHomelessHistory','2','1 time in past three years','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('literalHomelessHistory','99','Data not collected','ACTIVE');

INSERT INTO "v2017".hmis_type (name,value,description,status) values ('annualpercentami','0','0-14% of AMI for household size','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('annualpercentami','1','15-30% of AMI for household size','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('annualpercentami','2','More than 30% of AMI for household size (0 points)','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('annualpercentami','99','Data not collected','ACTIVE');

INSERT INTO "v2017".hmis_type (name,value,description,status) values ('timeToHousingLoss','0','0-6 days','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('timeToHousingLoss','1','7-13 days','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('timeToHousingLoss','2','14-21 days','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('timeToHousingLoss','3','More than 21 days (0 points)','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('timeToHousingLoss','99','Data not collected','ACTIVE');

INSERT INTO "v2017".hmis_type (name,value,description,status) values ('zeroincome','0','No','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('zeroincome','1','Yes','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('zeroincome','99','Data not collected','ACTIVE');

INSERT INTO "v2017".hmis_type (name,value,description,status) values ('financialchange','0','No','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('financialchange','1','Yes','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('financialchange','99','Data not collected','ACTIVE');

INSERT INTO "v2017".hmis_type (name,value,description,status) values ('evictionhistory','0','4 or more prior rental evictions','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('evictionhistory','1','2-3 prior rental evictions','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('evictionhistory','2','1 prior rental eviction','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('evictionhistory','3','No prior rental evictions (0 points)','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('evictionhistory','99','Data not collected','ACTIVE');

INSERT INTO "v2017".hmis_type (name,value,description,status) values ('householdchange','0','No','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('householdchange','1','Yes','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('householdchange','99','Data not collected','ACTIVE');

INSERT INTO "v2017".hmis_type (name,value,description,status) values ('subsidyatrisk','0','No','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('subsidyatrisk','1','Yes','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('subsidyatrisk','99','Data not collected','ACTIVE');

INSERT INTO "v2017".hmis_type (name,value,description,status) values ('disablehoh','0','No','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('disablehoh','1','Yes','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('disablehoh','99','Data not collected','ACTIVE');

INSERT INTO "v2017".hmis_type (name,value,description,status) values ('criminalrecord','0','No','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('criminalrecord','1','Yes','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('criminalrecord','99','Data not collected','ACTIVE');

INSERT INTO "v2017".hmis_type (name,value,description,status) values ('sexoffender','0','No','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('sexoffender','1','Yes','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('sexoffender','99','Data not collected','ACTIVE');

INSERT INTO "v2017".hmis_type (name,value,description,status) values ('dependendunder6','0','No','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('dependendunder6','1','Yes','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('dependendunder6','99','Data not collected','ACTIVE');

INSERT INTO "v2017".hmis_type (name,value,description,status) values ('singleparent','0','No','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('singleparent','1','Yes','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('singleparent','99','Data not collected','ACTIVE');

INSERT INTO "v2017".hmis_type (name,value,description,status) values ('hh5plus','0','No','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('hh5plus','1','Yes','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('hh5plus','99','Data not collected','ACTIVE');

INSERT INTO "v2017".hmis_type (name,value,description,status) values ('iraqafghanistan','0','No','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('iraqafghanistan','1','Yes','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('iraqafghanistan','99','Data not collected','ACTIVE');

INSERT INTO "v2017".hmis_type (name,value,description,status) values ('femvet','0','No','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('femvet','1','Yes','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('femvet','99','Data not collected','ACTIVE');

INSERT INTO "v2017".hmis_type (name,value,description,status) values ('losunderthreshold','0','No','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('losunderthreshold','1','Yes','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('losunderthreshold','99','Data not collected','ACTIVE');


INSERT INTO "v2017".hmis_type (name,value,description,status) values ('victimServiceProvider','0','No','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('victimServiceProvider','1','Yes','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('victimServiceProvider','99','Data not collected','ACTIVE');


INSERT INTO "v2017".hmis_type (name,value,description,status) values ('continuumproject','0','No','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('continuumproject','1','Yes','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('continuumproject','99','Data not collected','ACTIVE');





INSERT INTO "v2017".hmis_type (name,value,description,status) values ('previousStreetESSH','0','No','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('previousStreetESSH','1','Yes','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('previousStreetESSH','99','Data not collected','ACTIVE');

INSERT INTO "v2017".hmis_type (name,value,description,status) values ('ervisits','0','0','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('ervisits','1','1-2','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('ervisits','2','3-5','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('ervisits','3','6-10','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('ervisits','4','11-20','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('ervisits','5','More than 20','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('ervisits','8','Client doesn''t know','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('ervisits','9','Client refused','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('ervisits','99','Data not collected','ACTIVE');

INSERT INTO "v2017".hmis_type (name,value,description,status) values ('jailnights','0','0','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('jailnights','1','1-2','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('jailnights','2','3-5','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('jailnights','3','6-10','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('jailnights','4','11-20','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('jailnights','5','More than 20','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('jailnights','8','Client doesn''t know','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('jailnights','9','Client refused','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('jailnights','99','Data not collected','ACTIVE');

INSERT INTO "v2017".hmis_type (name,value,description,status) values ('hospitalnights','0','0','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('hospitalnights','1','1-2','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('hospitalnights','2','3-5','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('hospitalnights','3','6-10','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('hospitalnights','4','11-20','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('hospitalnights','5','More than 20','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('hospitalnights','8','Client doesn''t know','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('hospitalnights','9','Client refused','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('hospitalnights','99','Data not collected','ACTIVE');

INSERT INTO "v2017".hmis_type (name,value,description,status) values ('world_war_2','0','No','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('world_war_2','1','Yes','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('world_war_2','8','Client doesn''t know','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('world_war_2','9','Client refused','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('world_war_2','99','Data not collected','ACTIVE');

INSERT INTO "v2017".hmis_type (name,value,description,status) values ('korean_war','0','No','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('korean_war','1','Yes','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('korean_war','8','Client doesn''t know','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('korean_war','9','Client refused','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('korean_war','99','Data not collected','ACTIVE');

INSERT INTO "v2017".hmis_type (name,value,description,status) values ('vietnam_war','0','No','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('vietnam_war','1','Yes','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('vietnam_war','8','Client doesn''t know','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('vietnam_war','9','Client refused','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('vietnam_war','99','Data not collected','ACTIVE');

INSERT INTO "v2017".hmis_type (name,value,description,status) values ('desertstorm','0','No','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('desertstorm','1','Yes','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('desertstorm','8','Client doesn''t know','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('desertstorm','9','Client refused','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('desertstorm','99','Data not collected','ACTIVE');

INSERT INTO "v2017".hmis_type (name,value,description,status) values ('iraq_oif','0','No','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('iraq_oif','1','Yes','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('iraq_oif','8','Client doesn''t know','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('iraq_oif','9','Client refused','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('iraq_oif','99','Data not collected','ACTIVE');

INSERT INTO "v2017".hmis_type (name,value,description,status) values ('iraq_ond','0','No','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('iraq_ond','1','Yes','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('iraq_ond','8','Client doesn''t know','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('iraq_ond','9','Client refused','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('iraq_ond','99','Data not collected','ACTIVE');

INSERT INTO "v2017".hmis_type (name,value,description,status) values ('other_theater','0','No','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('other_theater','1','Yes','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('other_theater','8','Client doesn''t know','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('other_theater','9','Client refused','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('other_theater','99','Data not collected','ACTIVE');

INSERT INTO "v2017".hmis_type (name,value,description,status) values ('employed','0','No','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('employed','1','Yes','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('employed','8','Client doesn''t know','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('employed','9','Client refused','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('employed','99','Data not collected','ACTIVE');


   
  
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('address_data_quality','1','Full address reported','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('address_data_quality','2','Incomplete or estimated address reported','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('address_data_quality','8','Client doesn''t know','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('address_data_quality','9','Client refused','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('address_data_quality','99','Data not collected','ACTIVE');

INSERT INTO "v2017".hmis_type (name,value,description,status) values ('askedorforcedtoexchangeforsex','0','No','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('askedorforcedtoexchangeforsex','1','Yes','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('askedorforcedtoexchangeforsex','8','Client doesn''t know','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('askedorforcedtoexchangeforsex','9','Client refused','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('askedorforcedtoexchangeforsex','99','Data not collected','ACTIVE');

INSERT INTO "v2017".hmis_type (name,status,value,description) values ('assessmentdisposition','ACTIVE','1',  'Referred to emergency shelter/safe haven');
INSERT INTO "v2017".hmis_type (name,status,value,description) values ('assessmentdisposition','ACTIVE','2', 'Referred to transitional housing');
INSERT INTO "v2017".hmis_type (name,status,value,description) values ('assessmentdisposition','ACTIVE','3', 'Referred to rapid re-housing');
INSERT INTO "v2017".hmis_type (name,status,value,description) values ('assessmentdisposition','ACTIVE','4', 'Referred to permanent supportive housing');
INSERT INTO "v2017".hmis_type (name,status,value,description) values ('assessmentdisposition','ACTIVE','5', 'Referred to homelessness prevention');
INSERT INTO "v2017".hmis_type (name,status,value,description) values ('assessmentdisposition','ACTIVE','6', 'Referred to street outreach');
INSERT INTO "v2017".hmis_type (name,status,value,description) values ('assessmentdisposition','ACTIVE','7', 'Referred to other continuum project type');
INSERT INTO "v2017".hmis_type (name,status,value,description) values ('assessmentdisposition','ACTIVE','8', 'Referred to a homelessness diversion program');
INSERT INTO "v2017".hmis_type (name,status,value,description) values ('assessmentdisposition','ACTIVE','9', 'Unable to refer/accept within continuum; ineligible for continuum projects');
INSERT INTO "v2017".hmis_type (name,status,value,description) values ('assessmentdisposition','ACTIVE','10','Unable to refer/accept within continuum; continuum services unavailable');
INSERT INTO "v2017".hmis_type (name,status,value,description) values ('assessmentdisposition','ACTIVE','11','Referred to other community project (non-continuum)');
INSERT INTO "v2017".hmis_type (name,status,value,description) values ('assessmentdisposition','ACTIVE','12','Applicant declined referral/acceptance');
INSERT INTO "v2017".hmis_type (name,status,value,description) values ('assessmentdisposition','ACTIVE','13','Applicant terminated assessment prior to completion');
INSERT INTO "v2017".hmis_type (name,status,value,description) values ('assessmentdisposition','ACTIVE','14','Other/specify');

INSERT INTO "v2017".hmis_type (name,status,value,description) values ('availabilty','ACTIVE','1','Year-round');
INSERT INTO "v2017".hmis_type (name,status,value,description) values ('availabilty','ACTIVE','2','Seasonal');
INSERT INTO "v2017".hmis_type (name,status,value,description) values ('availabilty','ACTIVE','3','Overflow');

INSERT INTO "v2017".hmis_type (name,status,value,description) values ('bedtype','ACTIVE','1','Facility-based');
INSERT INTO "v2017".hmis_type (name,status,value,description) values ('bedtype','ACTIVE','2','Voucher');
INSERT INTO "v2017".hmis_type (name,status,value,description) values ('bedtype','ACTIVE','3','Other');

INSERT INTO "v2017".hmis_type (name,status,value,description) values ('countofexchangeforsex','ACTIVE','1','1-3');
INSERT INTO "v2017".hmis_type (name,status,value,description) values ('countofexchangeforsex','ACTIVE','2','4-7');
INSERT INTO "v2017".hmis_type (name,status,value,description) values ('countofexchangeforsex','ACTIVE','3','8-30');
INSERT INTO "v2017".hmis_type (name,status,value,description) values ('countofexchangeforsex','ACTIVE','4','More than 30');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('countofexchangeforsex','8','Client doesn''t know','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('countofexchangeforsex','9','Client refused','ACTIVE');

INSERT INTO "v2017".hmis_type (name,status,value,description) values ('disabilitytype','ACTIVE','5','Physical Disability');
INSERT INTO "v2017".hmis_type (name,status,value,description) values ('disabilitytype','ACTIVE','6','Developmental Disability');
INSERT INTO "v2017".hmis_type (name,status,value,description) values ('disabilitytype','ACTIVE','7','Chronic Health Condition');
INSERT INTO "v2017".hmis_type (name,status,value,description) values ('disabilitytype','ACTIVE','8','HIV/AIDS');
INSERT INTO "v2017".hmis_type (name,status,value,description) values ('disabilitytype','ACTIVE','9','Mental Health Problem');
INSERT INTO "v2017".hmis_type (name,status,value,description) values ('disabilitytype','ACTIVE','10','Substance Abuse');

INSERT INTO "v2017".hmis_type (name,status,value,description) values ('discharge_status','ACTIVE','1','Honorable');
INSERT INTO "v2017".hmis_type (name,status,value,description) values ('discharge_status','ACTIVE','2','General under honorable conditions');
INSERT INTO "v2017".hmis_type (name,status,value,description) values ('discharge_status','ACTIVE','4','Bad conduct');
INSERT INTO "v2017".hmis_type (name,status,value,description) values ('discharge_status','ACTIVE','5','Dishonorable');
INSERT INTO "v2017".hmis_type (name,status,value,description) values ('discharge_status','ACTIVE','6','Under other than honorable conditions (OTH)');
INSERT INTO "v2017".hmis_type (name,status,value,description) values ('discharge_status','ACTIVE','7','Uncharacterized');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('discharge_status','8','Client doesn''t know','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('discharge_status','9','Client refused','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('discharge_status','99','Data not collected','ACTIVE');

INSERT INTO "v2017".hmis_type (name,value,description,status) values ('dob_data_quality','1','Full DOB reported','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('dob_data_quality','2','Approximate or partial DOB reported','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('dob_data_quality','8','Client doesn''t know','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('dob_data_quality','9','Client refused','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('dob_data_quality','99','Data not collected','ACTIVE');


INSERT INTO "v2017".hmis_type (name,status,value,description) values ('earlyexitreason','ACTIVE','1','Left for other opportunities – Independent living');
INSERT INTO "v2017".hmis_type (name,status,value,description) values ('earlyexitreason','ACTIVE','2','Left for other opportunities - Education');
INSERT INTO "v2017".hmis_type (name,status,value,description) values ('earlyexitreason','ACTIVE','3','Left for other opportunities - Military');
INSERT INTO "v2017".hmis_type (name,status,value,description) values ('earlyexitreason','ACTIVE','4','Left for other opportunities - Other');
INSERT INTO "v2017".hmis_type (name,status,value,description) values ('earlyexitreason','ACTIVE','5','Needs could not be met by project');
INSERT INTO "v2017".hmis_type (name,status,value,description) values ('earlyexitreason','ACTIVE','99','Data not collected');

 
 INSERT INTO "v2017".hmis_type (name,status,value,description) values ('employment_type','ACTIVE','1','Full-time');
 INSERT INTO "v2017".hmis_type (name,status,value,description) values ('employment_type','ACTIVE','2','Part-time');
 INSERT INTO "v2017".hmis_type (name,status,value,description) values ('employment_type','ACTIVE','3','Seasonal / sporadic (including day labor)');
 INSERT INTO "v2017".hmis_type (name,status,value,description) values ('employment_type','ACTIVE','99','Data not collected');
 
 INSERT INTO "v2017".hmis_type (name,value,description,status) values ('ethnicity','0','Non-Hispanic/Non-Latino','ACTIVE');
 INSERT INTO "v2017".hmis_type (name,value,description,status) values ('ethnicity','1','Hispanic/Latino','ACTIVE');
 INSERT INTO "v2017".hmis_type (name,value,description,status) values    ('ethnicity','8','Client does not know','ACTIVE');
 INSERT INTO "v2017".hmis_type  (name,value,description,status) values  ('ethnicity','9','Client refused','ACTIVE');
 INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('ethnicity','99','Data not collected','ACTIVE');

INSERT INTO "v2017".hmis_type (name,status,value,description) values ('destination','ACTIVE','24','Deceased');
INSERT INTO "v2017".hmis_type (name,status,value,description) values ('destination','ACTIVE','1','Emergency shelter, including hotel or motel paid for with emergency shelter voucher');
INSERT INTO "v2017".hmis_type (name,status,value,description) values ('destination','ACTIVE','15','Foster care home or foster care group home');
INSERT INTO "v2017".hmis_type (name,status,value,description) values ('destination','ACTIVE','6','Hospital or other residential non-psychiatric medical facility');
INSERT INTO "v2017".hmis_type (name,status,value,description) values ('destination','ACTIVE','14','Hotel or motel paid for without emergency shelter voucher');
INSERT INTO "v2017".hmis_type (name,status,value,description) values ('destination','ACTIVE','7','Jail, prison or juvenile detention facility');
INSERT INTO "v2017".hmis_type (name,status,value,description) values ('destination','ACTIVE','25','Long-term care facility or nursing home');	
INSERT INTO "v2017".hmis_type (name,status,value,description) values ('destination','ACTIVE','26','Moved from one HOPWA funded project to HOPWA PH ');   
INSERT INTO "v2017".hmis_type (name,status,value,description) values ('destination','ACTIVE','27','Moved from one HOPWA funded project to HOPWA TH');
INSERT INTO "v2017".hmis_type (name,status,value,description) values ('destination','ACTIVE','11','Owned by client, no ongoing housing subsidy');
INSERT INTO "v2017".hmis_type (name,status,value,description) values ('destination','ACTIVE','21','Owned by client, with ongoing housing subsidy');
INSERT INTO "v2017".hmis_type (name,status,value,description) values ('destination','ACTIVE','3','Permanent housing for formerly homeless persons (such as: CoC project; or HUD legacy programs; or HOPWA PH)');
INSERT INTO "v2017".hmis_type (name,status,value,description) values ('destination','ACTIVE','16','Place not meant for habitation (e.g., a vehicle, an abandoned building, bus/train/subway station/airport or anywhere outside)');
INSERT INTO "v2017".hmis_type (name,status,value,description) values ('destination','ACTIVE','4','Psychiatric hospital or other psychiatric facility');
INSERT INTO "v2017".hmis_type (name,status,value,description) values ('destination','ACTIVE','10','Rental by client, no ongoing housing subsidy');	
INSERT INTO "v2017".hmis_type (name,status,value,description) values ('destination','ACTIVE','19','Rental by client, with VASH housing subsidy');  
INSERT INTO "v2017".hmis_type (name,status,value,description) values ('destination','ACTIVE','28','Rental by client, with GPD TIP housing subsidy');
INSERT INTO "v2017".hmis_type (name,status,value,description) values ('destination','ACTIVE','20','Rental by client, with other ongoing housing subsidy');
INSERT INTO "v2017".hmis_type (name,status,value,description) values ('destination','ACTIVE','29','Residential project or halfway house with no homeless criteria');
INSERT INTO "v2017".hmis_type (name,status,value,description) values ('destination','ACTIVE','18','Safe Haven');
INSERT INTO "v2017".hmis_type (name,status,value,description) values ('destination','ACTIVE','22','Staying or living with family, permanent tenure');
INSERT INTO "v2017".hmis_type (name,status,value,description) values ('destination','ACTIVE','12','Staying or living with family, temporary tenure (e.g., room, apartment or house)');
INSERT INTO "v2017".hmis_type (name,status,value,description) values ('destination','ACTIVE','23','Staying or living with friends, permanent tenure');	
INSERT INTO "v2017".hmis_type (name,status,value,description) values ('destination','ACTIVE','13','Staying or living with friends, temporary tenure (e.g., room apartment or house)');  
INSERT INTO "v2017".hmis_type (name,status,value,description) values ('destination','ACTIVE','5','Substance abuse treatment facility or detox center ');
INSERT INTO "v2017".hmis_type (name,status,value,description) values ('destination','ACTIVE','2','Transitional housing for homeless persons (including homeless youth)');
INSERT INTO "v2017".hmis_type (name,status,value,description) values ('destination','ACTIVE','17','Other');
INSERT INTO "v2017".hmis_type (name,status,value,description) values ('destination','ACTIVE','30','No exit interview completed');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('destination','8','Client doesn''t know','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('destination','9','Client refused','ACTIVE');   											    
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('destination','99','Data not collected','ACTIVE'); 

 INSERT INTO "v2017".hmis_type (name,status,value,description) values ('funder','ACTIVE','1','HUD:CoC – Homelessness Prevention (High Performing Comm. Only)'); 
 INSERT INTO "v2017".hmis_type (name,status,value,description) values ('funder','ACTIVE','2','HUD:CoC – Permanent Supportive Housing');
 INSERT INTO "v2017".hmis_type (name,status,value,description) values ('funder','ACTIVE','3','HUD:CoC – Rapid Re-Housing');
 INSERT INTO "v2017".hmis_type (name,status,value,description) values ('funder','ACTIVE','4','HUD:CoC – Supportive Services Only');
 INSERT INTO "v2017".hmis_type (name,status,value,description) values ('funder','ACTIVE','5','HUD:CoC – Transitional Housing');
 INSERT INTO "v2017".hmis_type (name,status,value,description) values ('funder','ACTIVE','6','HUD:CoC – Safe Haven');
 INSERT INTO "v2017".hmis_type (name,status,value,description) values ('funder','ACTIVE','7','HUD:CoC – Single Room Occupancy (SRO)');   
 INSERT INTO "v2017".hmis_type (name,status,value,description) values ('funder','ACTIVE','8','HUD:ESG – Emergency Shelter (operating and/or essential services)');  
 INSERT INTO "v2017".hmis_type (name,status,value,description) values ('funder','ACTIVE','9','HUD:ESG – Homelessness Prevention'); 
 INSERT INTO "v2017".hmis_type (name,status,value,description) values ('funder','ACTIVE','10','HUD:ESG – Rapid Rehousing');  
 INSERT INTO "v2017".hmis_type (name,status,value,description) values ('funder','ACTIVE','11','HUD:ESG – Street Outreach');
 INSERT INTO "v2017".hmis_type (name,status,value,description) values ('funder','ACTIVE','12','HUD:Rural Housing Stability Assistance Program');
 INSERT INTO "v2017".hmis_type (name,status,value,description) values ('funder','ACTIVE','13','HUD:HOPWA – Hotel/Motel Vouchers');
 INSERT INTO "v2017".hmis_type (name,status,value,description) values ('funder','ACTIVE','14','HUD:HOPWA – Housing Information');  
 INSERT INTO "v2017".hmis_type (name,status,value,description) values ('funder','ACTIVE','15','HUD:HOPWA – Permanent Housing (facility based or TBRA)');  
 INSERT INTO "v2017".hmis_type (name,status,value,description) values ('funder','ACTIVE','16','HUD:HOPWA – Permanent Housing Placement');  
 INSERT INTO "v2017".hmis_type (name,status,value,description) values ('funder','ACTIVE','17','HUD:HOPWA – Short-Term Rent, Mortgage, Utility assistance'); 
 INSERT INTO "v2017".hmis_type (name,status,value,description) values ('funder','ACTIVE','18','HUD:HOPWA – Short-Term Supportive Facility');
 INSERT INTO "v2017".hmis_type (name,status,value,description) values ('funder','ACTIVE','19','HUD:HOPWA – Transitional Housing (facility based or TBRA)'); 
 INSERT INTO "v2017".hmis_type (name,status,value,description) values ('funder','ACTIVE','20','HUD:HUD/VASH');  
 INSERT INTO "v2017".hmis_type (name,status,value,description) values ('funder','ACTIVE','21','HHS:PATH – Street Outreach and Supportive Services Only');   
 INSERT INTO "v2017".hmis_type (name,status,value,description) values ('funder','ACTIVE','22','HHS:RHY – Basic Center Program (prevention and shelter)');   
 INSERT INTO "v2017".hmis_type (name,status,value,description) values ('funder','ACTIVE','23','HHS:RHY – Maternity Group Home for Pregnant and Parenting Youth');   
 INSERT INTO "v2017".hmis_type (name,status,value,description) values ('funder','ACTIVE','24','HHS:RHY – Transitional Living Program');  
 INSERT INTO "v2017".hmis_type (name,status,value,description) values ('funder','ACTIVE','25','HHS:RHY – Street Outreach Project');
 INSERT INTO "v2017".hmis_type (name,status,value,description) values ('funder','ACTIVE','26','HHS:RHY – Demonstration Project');
 INSERT INTO "v2017".hmis_type (name,status,value,description) values ('funder','ACTIVE','27','VA: Community Contract Emergency Housing');
 INSERT INTO "v2017".hmis_type (name,status,value,description) values ('funder','ACTIVE','28','VA: Community Contract Residential Treatment Program');
 INSERT INTO "v2017".hmis_type (name,status,value,description) values ('funder','ACTIVE','29','VA:Domiciliary Care');
 INSERT INTO "v2017".hmis_type (name,status,value,description) values ('funder','ACTIVE','30','VA:Community Contract Safe Haven Program');
 INSERT INTO "v2017".hmis_type (name,status,value,description) values ('funder','ACTIVE','31','VA:Grant and Per Diem Program');
 INSERT INTO "v2017".hmis_type (name,status,value,description) values ('funder','ACTIVE','32','VA:Compensated Work Therapy Transitional Residence');
 INSERT INTO "v2017".hmis_type (name,status,value,description) values ('funder','ACTIVE','33','VA:Supportive Services for Veteran Families');
 INSERT INTO "v2017".hmis_type (name,status,value,description) values ('funder','ACTIVE','34','N/A');

 INSERT INTO "v2017".hmis_type (name,status,value,description) values ('reason_no_services','ACTIVE','1','Out of age range');
 INSERT INTO "v2017".hmis_type (name,status,value,description) values ('reason_no_services','ACTIVE','2','Ward of the State – Immediate Reunification');
 INSERT INTO "v2017".hmis_type (name,status,value,description) values ('reason_no_services','ACTIVE','3','Ward of the Criminal Justice System – Immediate Reunification');
 INSERT INTO "v2017".hmis_type (name,status,value,description) values ('reason_no_services','ACTIVE','4','Other');
 INSERT INTO "v2017".hmis_type (name,value,description,status) values ('reason_no_services','99','Data not collected','ACTIVE'); 
 INSERT INTO "v2017".hmis_type (name,value,description,status)  values ('gender','0','Female','ACTIVE');
 INSERT INTO "v2017".hmis_type (name,value,description,status)  values ('gender','1','Male','ACTIVE');
 INSERT INTO "v2017".hmis_type (name,value,description,status)  values ('gender','2','Transgender male to female','ACTIVE');
 INSERT INTO "v2017".hmis_type (name,value,description,status)  values ('gender','3','Transgender female to male','ACTIVE');
 INSERT INTO "v2017".hmis_type (name,value,description,status)  values ('gender','4','Other','ACTIVE');
 INSERT INTO "v2017".hmis_type (name,value,description,status)  values ('gender','8','Client does not know','ACTIVE');
 INSERT INTO "v2017".hmis_type (name,value,description,status)  values ('gender','9','Client refused','ACTIVE');
 INSERT INTO "v2017".hmis_type (name,value,description,status)  values ('gender','99','Data not collected','ACTIVE');
 
  INSERT INTO "v2017".hmis_type (name,status,value,description) values ('health_category','ACTIVE','27','General Health Status');
  INSERT INTO "v2017".hmis_type (name,status,value,description) values ('health_category','ACTIVE','28','Dental Health Status');
  INSERT INTO "v2017".hmis_type (name,status,value,description) values ('health_category','ACTIVE','29','Mental Health Status');
  
   INSERT INTO "v2017".hmis_type (name,status,value,description) values ('health_status','ACTIVE','1','Excellent');
   INSERT INTO "v2017".hmis_type (name,status,value,description) values ('health_status','ACTIVE','2','Very good');
   INSERT INTO "v2017".hmis_type (name,status,value,description) values ('health_status','ACTIVE','3','Good');
   INSERT INTO "v2017".hmis_type (name,status,value,description) values ('health_status','ACTIVE','4','Fair'); 
   INSERT INTO "v2017".hmis_type (name,status,value,description) values ('health_status','ACTIVE','5','Poor');	
    INSERT INTO "v2017".hmis_type (name,value,description,status)  values ('health_status','8','Client does not know','ACTIVE');
    INSERT INTO "v2017".hmis_type (name,value,description,status)  values ('health_status','9','Client refused','ACTIVE');
 INSERT INTO "v2017".hmis_type (name,value,description,status)  values ('health_status','99','Data not collected','ACTIVE');	
	
	
   INSERT INTO "v2017".hmis_type (name,status,value,description) values ('householdtype','ACTIVE','1','Households without children'); 
   INSERT INTO "v2017".hmis_type (name,status,value,description) values ('householdtype','ACTIVE','3','Households with at least one adult and one child'); 
   INSERT INTO "v2017".hmis_type (name,status,value,description) values ('householdtype','ACTIVE','4','Households with only children');

 INSERT INTO "v2017".hmis_type (name,status,value,description) values ('housingassessment','ACTIVE','1','Able to maintain the housing they had at project entry');
 INSERT INTO "v2017".hmis_type (name,status,value,description) values ('housingassessment','ACTIVE','2','Moved to new housing unit');
 INSERT INTO "v2017".hmis_type (name,status,value,description) values ('housingassessment','ACTIVE','3','Moved in with family/friends on a temporary basis');
 INSERT INTO "v2017".hmis_type (name,status,value,description) values ('housingassessment','ACTIVE','4','Moved in with family/friends on a permanent basis ');
 INSERT INTO "v2017".hmis_type (name,status,value,description) values ('housingassessment','ACTIVE','5','Moved to a transitional or temporary housing facility or program');
 INSERT INTO "v2017".hmis_type (name,status,value,description) values ('housingassessment','ACTIVE','6','Client became homeless – moving to a shelter or other place unfit for human habitation');
 INSERT INTO "v2017".hmis_type (name,status,value,description) values ('housingassessment','ACTIVE','7','Client went to jail/prison');
 INSERT INTO "v2017".hmis_type (name,status,value,description) values ('housingassessment','ACTIVE','10','Client died ');
    INSERT INTO "v2017".hmis_type (name,value,description,status)  values ('housingassessment','8','Client does not know','ACTIVE');
    INSERT INTO "v2017".hmis_type (name,value,description,status)  values ('housingassessment','9','Client refused','ACTIVE');
 INSERT INTO "v2017".hmis_type (name,value,description,status)  values ('housingassessment','99','Data not collected','ACTIVE');	

INSERT INTO "v2017".hmis_type (name,status,value,description) values ('incarceratedparentstatus','ACTIVE','1','One parent / legal guardian is incarcerated');
INSERT INTO "v2017".hmis_type (name,status,value,description) values ('incarceratedparentstatus','ACTIVE','2','One parent / legal guardian is incarcerated');
INSERT INTO "v2017".hmis_type (name,status,value,description) values ('incarceratedparentstatus','ACTIVE','3','The only parent / legal guardian is incarcerated');
INSERT INTO "v2017".hmis_type (name,value,description,status)  values ('incarceratedparentstatus','99','Data not collected','ACTIVE');	

INSERT INTO "v2017".hmis_type (name,status,value,description) values ('juvenilejusticeyears','ACTIVE','1','Less than one year');
INSERT INTO "v2017".hmis_type (name,status,value,description) values ('juvenilejusticeyears','ACTIVE','2','1 to 2 years');
INSERT INTO "v2017".hmis_type (name,status,value,description) values ('juvenilejusticeyears','ACTIVE','3','3 to 5 or more years');

INSERT INTO "v2017".hmis_type (name,status,value,description) values ('childwelfareyears','ACTIVE','1','Less than one year');
INSERT INTO "v2017".hmis_type (name,status,value,description) values ('childwelfareyears','ACTIVE','2','1 to 2 years');
INSERT INTO "v2017".hmis_type (name,status,value,description) values ('childwelfareyears','ACTIVE','3','3 to 5 or more years');

 
  INSERT INTO "v2017".hmis_type (name,status,value,description) values ('military_branch','ACTIVE','1','Army');
  INSERT INTO "v2017".hmis_type (name,status,value,description) values ('military_branch','ACTIVE','2','Air Force');
  INSERT INTO "v2017".hmis_type (name,status,value,description) values ('military_branch','ACTIVE','3','Navy'); 
  INSERT INTO "v2017".hmis_type (name,status,value,description) values ('military_branch','ACTIVE','4','Marines'); 
  INSERT INTO "v2017".hmis_type (name,status,value,description) values ('military_branch','ACTIVE','6','Coast Guard');
  INSERT INTO "v2017".hmis_type (name,value,description,status)  values ('military_branch','8','Client does not know','ACTIVE');
  INSERT INTO "v2017".hmis_type (name,value,description,status)  values ('military_branch','9','Client refused','ACTIVE');
  INSERT INTO "v2017".hmis_type (name,value,description,status)  values ('military_branch','99','Data not collected','ACTIVE');
  
 
  INSERT INTO "v2017".hmis_type (name,status,value,description) values ('monthsHomelessPastThreeYears','ACTIVE','100','0 months');
  INSERT INTO "v2017".hmis_type (name,status,value,description) values ('monthsHomelessPastThreeYears','ACTIVE','101','1 month');
  INSERT INTO "v2017".hmis_type (name,status,value,description) values ('monthsHomelessPastThreeYears','ACTIVE','102','2 months');
  INSERT INTO "v2017".hmis_type (name,status,value,description) values ('monthsHomelessPastThreeYears','ACTIVE','103','3 months');
  INSERT INTO "v2017".hmis_type (name,status,value,description) values ('monthsHomelessPastThreeYears','ACTIVE','104','4 months');
  INSERT INTO "v2017".hmis_type (name,status,value,description) values ('monthsHomelessPastThreeYears','ACTIVE','105','5 months');
  INSERT INTO "v2017".hmis_type (name,status,value,description) values ('monthsHomelessPastThreeYears','ACTIVE','106','6 months');
  INSERT INTO "v2017".hmis_type (name,status,value,description) values ('monthsHomelessPastThreeYears','ACTIVE','107','7 months');
  INSERT INTO "v2017".hmis_type (name,status,value,description) values ('monthsHomelessPastThreeYears','ACTIVE','108','8 months');
  INSERT INTO "v2017".hmis_type (name,status,value,description) values ('monthsHomelessPastThreeYears','ACTIVE','109','9 months');
  INSERT INTO "v2017".hmis_type (name,status,value,description) values ('monthsHomelessPastThreeYears','ACTIVE','110','10 months');
  INSERT INTO "v2017".hmis_type (name,status,value,description) values ('monthsHomelessPastThreeYears','ACTIVE','111','11 months');
  INSERT INTO "v2017".hmis_type (name,status,value,description) values ('monthsHomelessPastThreeYears','ACTIVE','112','12 months');
  INSERT INTO "v2017".hmis_type (name,status,value,description) values ('monthsHomelessPastThreeYears','ACTIVE','7','More than 12 months');
  INSERT INTO "v2017".hmis_type (name,status,value,description) values ('monthsHomelessPastThreeYears','ACTIVE','1','More than 12 months');
    INSERT INTO "v2017".hmis_type (name,value,description,status)  values ('monthsHomelessPastThreeYears','8','Client does not know','ACTIVE');
    INSERT INTO "v2017".hmis_type (name,value,description,status)  values ('monthsHomelessPastThreeYears','9','Client refused','ACTIVE');
    INSERT INTO "v2017".hmis_type (name,value,description,status)  values ('monthsHomelessPastThreeYears','99','Data not collected','ACTIVE');
    
    INSERT INTO "v2017".hmis_type (name,status,value,description) values ('monthsHomelessThisTime','ACTIVE','100','0 months');
  INSERT INTO "v2017".hmis_type (name,status,value,description) values ('monthsHomelessThisTime','ACTIVE','101','1 month');
  INSERT INTO "v2017".hmis_type (name,status,value,description) values ('monthsHomelessThisTime','ACTIVE','102','2 months');
  INSERT INTO "v2017".hmis_type (name,status,value,description) values ('monthsHomelessThisTime','ACTIVE','103','3 months');
  INSERT INTO "v2017".hmis_type (name,status,value,description) values ('monthsHomelessThisTime','ACTIVE','104','4 months');
  INSERT INTO "v2017".hmis_type (name,status,value,description) values ('monthsHomelessThisTime','ACTIVE','105','5 months');
  INSERT INTO "v2017".hmis_type (name,status,value,description) values ('monthsHomelessThisTime','ACTIVE','106','6 months');
  INSERT INTO "v2017".hmis_type (name,status,value,description) values ('monthsHomelessThisTime','ACTIVE','107','7 months');
  INSERT INTO "v2017".hmis_type (name,status,value,description) values ('monthsHomelessThisTime','ACTIVE','108','8 months');
  INSERT INTO "v2017".hmis_type (name,status,value,description) values ('monthsHomelessThisTime','ACTIVE','109','9 months');
  INSERT INTO "v2017".hmis_type (name,status,value,description) values ('monthsHomelessThisTime','ACTIVE','110','10 months');
  INSERT INTO "v2017".hmis_type (name,status,value,description) values ('monthsHomelessThisTime','ACTIVE','111','11 months');
  INSERT INTO "v2017".hmis_type (name,status,value,description) values ('monthsHomelessThisTime','ACTIVE','112','12 months');
  INSERT INTO "v2017".hmis_type (name,status,value,description) values ('monthsHomelessThisTime','ACTIVE','7','More than 12 months');
  INSERT INTO "v2017".hmis_type (name,status,value,description) values ('monthsHomelessThisTime','ACTIVE','1','More than 12 months');
    INSERT INTO "v2017".hmis_type (name,value,description,status)  values ('monthsHomelessThisTime','8','Client does not know','ACTIVE');
    INSERT INTO "v2017".hmis_type (name,value,description,status)  values ('monthsHomelessThisTime','9','Client refused','ACTIVE');
    INSERT INTO "v2017".hmis_type (name,value,description,status)  values ('monthsHomelessThisTime','99','Data not collected','ACTIVE');
    
  INSERT INTO "v2017".hmis_type (name,status,value,description) values ('name_data_quality','ACTIVE','1','Full name reported'); 
  INSERT INTO "v2017".hmis_type (name,status,value,description) values ('name_data_quality','ACTIVE','2','Partial, street name, or code name reported');  
    INSERT INTO "v2017".hmis_type (name,value,description,status)  values ('name_data_quality','8','Client does not know','ACTIVE');  
    INSERT INTO "v2017".hmis_type (name,value,description,status)  values ('name_data_quality','9','Client refused','ACTIVE');  
    INSERT INTO "v2017".hmis_type (name,value,description,status)  values ('name_data_quality','99','Data not collected','ACTIVE');  
    
      INSERT INTO "v2017".hmis_type (name,status,value,description) values ('noadapreason','ACTIVE','1','Applied; decision pending');
      INSERT INTO "v2017".hmis_type (name,status,value,description) values ('noadapreason','ACTIVE','2','Applied; client not eligible');
      INSERT INTO "v2017".hmis_type (name,status,value,description) values ('noadapreason','ACTIVE','3','Client did not apply');
      INSERT INTO "v2017".hmis_type (name,status,value,description) values ('noadapreason','ACTIVE','4','Insurance type N/A for this client');
  INSERT INTO "v2017".hmis_type (name,value,description,status)  values ('noadapreason','8','Client does not know','ACTIVE');  
  INSERT INTO "v2017".hmis_type (name,value,description,status)  values ('noadapreason','9','Client refused','ACTIVE');  
  INSERT INTO "v2017".hmis_type (name,value,description,status)  values ('noadapreason','99','Data not collected','ACTIVE');  
    
INSERT INTO "v2017".hmis_type (name,status,value,description) values ('nocobrareason','ACTIVE','1','Applied; decision pending');
INSERT INTO "v2017".hmis_type (name,status,value,description) values ('nocobrareason','ACTIVE','2','Applied; client not eligible');    
INSERT INTO "v2017".hmis_type (name,status,value,description) values ('nocobrareason','ACTIVE','3','Client did not apply');
INSERT INTO "v2017".hmis_type (name,status,value,description) values ('nocobrareason','ACTIVE','4','Insurance type N/A for this client');
INSERT INTO "v2017".hmis_type (name,value,description,status)  values ('nocobrareason','8','Client does not know','ACTIVE'); 
INSERT INTO "v2017".hmis_type (name,value,description,status)  values ('nocobrareason','9','Client refused','ACTIVE');  
INSERT INTO "v2017".hmis_type (name,value,description,status)  values ('nocobrareason','99','Data not collected','ACTIVE');  

INSERT INTO "v2017".hmis_type (name,status,value,description) values ('noemployerprovidedreason','ACTIVE','1','Applied; decision pending');
INSERT INTO "v2017".hmis_type (name,status,value,description) values ('noemployerprovidedreason','ACTIVE','2','Applied; client not eligible');    
INSERT INTO "v2017".hmis_type (name,status,value,description) values ('noemployerprovidedreason','ACTIVE','3','Client did not apply');
INSERT INTO "v2017".hmis_type (name,status,value,description) values ('noemployerprovidedreason','ACTIVE','4','Insurance type N/A for this client');
INSERT INTO "v2017".hmis_type (name,value,description,status)  values ('noemployerprovidedreason','8','Client does not know','ACTIVE'); 
INSERT INTO "v2017".hmis_type (name,value,description,status)  values ('noemployerprovidedreason','9','Client refused','ACTIVE');  
INSERT INTO "v2017".hmis_type (name,value,description,status)  values ('noemployerprovidedreason','99','Data not collected','ACTIVE');  

INSERT INTO "v2017".hmis_type (name,status,value,description) values ('nomedicaidreason','ACTIVE','1','Applied; decision pending');
INSERT INTO "v2017".hmis_type (name,status,value,description) values ('nomedicaidreason','ACTIVE','2','Applied; client not eligible');    
INSERT INTO "v2017".hmis_type (name,status,value,description) values ('nomedicaidreason','ACTIVE','3','Client did not apply');
INSERT INTO "v2017".hmis_type (name,status,value,description) values ('nomedicaidreason','ACTIVE','4','Insurance type N/A for this client');
INSERT INTO "v2017".hmis_type (name,value,description,status)  values ('nomedicaidreason','8','Client does not know','ACTIVE'); 
INSERT INTO "v2017".hmis_type (name,value,description,status)  values ('nomedicaidreason','9','Client refused','ACTIVE');  
INSERT INTO "v2017".hmis_type (name,value,description,status)  values ('nomedicaidreason','99','Data not collected','ACTIVE');  

 INSERT INTO "v2017".hmis_type (name,status,value,description) values ('nomedicarereason','ACTIVE','1','Applied; decision pending');
 INSERT INTO "v2017".hmis_type (name,status,value,description) values ('nomedicarereason','ACTIVE','2','Applied; client not eligible');    
 INSERT INTO "v2017".hmis_type (name,status,value,description) values ('nomedicarereason','ACTIVE','3','Client did not apply');
 INSERT INTO "v2017".hmis_type (name,status,value,description) values ('nomedicarereason','ACTIVE','4','Insurance type N/A for this client');
 INSERT INTO "v2017".hmis_type (name,value,description,status)  values ('nomedicarereason','8','Client does not know','ACTIVE'); 
 INSERT INTO "v2017".hmis_type (name,value,description,status)  values ('nomedicarereason','9','Client refused','ACTIVE');  
 INSERT INTO "v2017".hmis_type (name,value,description,status)  values ('nomedicarereason','99','Data not collected','ACTIVE');  

INSERT INTO "v2017".hmis_type (name,status,value,description) values ('noprivatepayreason','ACTIVE','1','Applied; decision pending');
INSERT INTO "v2017".hmis_type (name,status,value,description) values ('noprivatepayreason','ACTIVE','2','Applied; client not eligible');    
INSERT INTO "v2017".hmis_type (name,status,value,description) values ('noprivatepayreason','ACTIVE','3','Client did not apply');
INSERT INTO "v2017".hmis_type (name,status,value,description) values ('noprivatepayreason','ACTIVE','4','Insurance type N/A for this client');
INSERT INTO "v2017".hmis_type (name,value,description,status)  values ('noprivatepayreason','8','Client does not know','ACTIVE'); 
INSERT INTO "v2017".hmis_type (name,value,description,status)  values ('noprivatepayreason','9','Client refused','ACTIVE');  
INSERT INTO "v2017".hmis_type (name,value,description,status)  values ('noprivatepayreason','99','Data not collected','ACTIVE');  

INSERT INTO "v2017".hmis_type (name,status,value,description) values ('noschipreason','ACTIVE','1','Applied; decision pending');
INSERT INTO "v2017".hmis_type (name,status,value,description) values ('noschipreason','ACTIVE','2','Applied; client not eligible');    
INSERT INTO "v2017".hmis_type (name,status,value,description) values ('noschipreason','ACTIVE','3','Client did not apply');
INSERT INTO "v2017".hmis_type (name,status,value,description) values ('noschipreason','ACTIVE','4','Insurance type N/A for this client');
INSERT INTO "v2017".hmis_type (name,value,description,status)  values ('noschipreason','8','Client does not know','ACTIVE'); 
INSERT INTO "v2017".hmis_type (name,value,description,status)  values ('noschipreason','9','Client refused','ACTIVE');  
INSERT INTO "v2017".hmis_type (name,value,description,status)  values ('noschipreason','99','Data not collected','ACTIVE');  

INSERT INTO "v2017".hmis_type (name,status,value,description) values ('nostatehealthinsreason','ACTIVE','1','Applied; decision pending');
INSERT INTO "v2017".hmis_type (name,status,value,description) values ('nostatehealthinsreason','ACTIVE','2','Applied; client not eligible');    
INSERT INTO "v2017".hmis_type (name,status,value,description) values ('nostatehealthinsreason','ACTIVE','3','Client did not apply');
INSERT INTO "v2017".hmis_type (name,status,value,description) values ('nostatehealthinsreason','ACTIVE','4','Insurance type N/A for this client');
INSERT INTO "v2017".hmis_type (name,value,description,status)  values ('nostatehealthinsreason','8','Client does not know','ACTIVE'); 
INSERT INTO "v2017".hmis_type (name,value,description,status)  values ('nostatehealthinsreason','9','Client refused','ACTIVE');  
INSERT INTO "v2017".hmis_type (name,value,description,status)  values ('nostatehealthinsreason','99','Data not collected','ACTIVE');  


INSERT INTO "v2017".hmis_type (name,status,value,description) values ('novamedreason','ACTIVE','1','Applied; decision pending');
INSERT INTO "v2017".hmis_type (name,status,value,description) values ('novamedreason','ACTIVE','2','Applied; client not eligible');    
INSERT INTO "v2017".hmis_type (name,status,value,description) values ('novamedreason','ACTIVE','3','Client did not apply');
INSERT INTO "v2017".hmis_type (name,status,value,description) values ('novamedreason','ACTIVE','4','Insurance type N/A for this client');
INSERT INTO "v2017".hmis_type (name,value,description,status)  values ('novamedreason','8','Client does not know','ACTIVE'); 
INSERT INTO "v2017".hmis_type (name,value,description,status)  values ('novamedreason','9','Client refused','ACTIVE');  
INSERT INTO "v2017".hmis_type (name,value,description,status)  values ('novamedreason','99','Data not collected','ACTIVE');  

INSERT INTO "v2017".hmis_type (name,status,value,description) values ('nohivaidsassistancereason','ACTIVE','1','Applied; decision pending');
INSERT INTO "v2017".hmis_type (name,status,value,description) values ('nohivaidsassistancereason','ACTIVE','2','Applied; client not eligible');
INSERT INTO "v2017".hmis_type (name,status,value,description) values ('nohivaidsassistancereason','ACTIVE','3','Client did not apply');
INSERT INTO "v2017".hmis_type (name,status,value,description) values ('nohivaidsassistancereason','ACTIVE','4','Insurance type N/A for this client');
INSERT INTO "v2017".hmis_type (name,value,description,status)  values ('nohivaidsassistancereason','8','Client does not know','ACTIVE'); 
INSERT INTO "v2017".hmis_type (name,value,description,status)  values ('nohivaidsassistancereason','9','Client refused','ACTIVE');  
INSERT INTO "v2017".hmis_type (name,value,description,status)  values ('nohivaidsassistancereason','99','Data not collected','ACTIVE');  

INSERT INTO "v2017".hmis_type (name,status,value,description) values ('not_employed_reason','ACTIVE','1','Looking for work');
INSERT INTO "v2017".hmis_type (name,status,value,description) values ('not_employed_reason','ACTIVE','2','Unable to work');
INSERT INTO "v2017".hmis_type (name,status,value,description) values ('not_employed_reason','ACTIVE','3','Not looking for work');
INSERT INTO "v2017".hmis_type (name,value,description,status)  values ('not_employed_reason','99','Data not collected','ACTIVE');  

 INSERT INTO "v2017".hmis_type (name,status,value,description) values ('pathhowconfirmed','ACTIVE','1','Unconfirmed; presumptive or self-report');
 INSERT INTO "v2017".hmis_type (name,status,value,description) values ('pathhowconfirmed','ACTIVE','2','Confirmed through assessment and clinical evaluation'); 
 INSERT INTO "v2017".hmis_type (name,status,value,description) values ('pathhowconfirmed','ACTIVE','3','Confirmed by prior evaluation or clinical records');
INSERT INTO "v2017".hmis_type (name,value,description,status)  values ('pathhowconfirmed','99','Data not collected','ACTIVE');   

INSERT INTO "v2017".hmis_type (name,status,value,description) values ('pathsmiinformation','ACTIVE','0','No');
INSERT INTO "v2017".hmis_type (name,status,value,description) values ('pathsmiinformation','ACTIVE','1','Unconfirmed; presumptive or self-report');
INSERT INTO "v2017".hmis_type (name,status,value,description) values ('pathsmiinformation','ACTIVE','2','Confirmed through assessment and clinical evaluation'); 
INSERT INTO "v2017".hmis_type (name,status,value,description) values ('pathsmiinformation','ACTIVE','3','Confirmed by prior evaluation or clinical records');
INSERT INTO "v2017".hmis_type (name,value,description,status)  values ('pathsmiinformation','8','Client does not know','ACTIVE'); 
INSERT INTO "v2017".hmis_type (name,value,description,status)  values ('pathsmiinformation','9','Client refused','ACTIVE');  
INSERT INTO "v2017".hmis_type (name,value,description,status)  values ('pathsmiinformation','99','Data not collected','ACTIVE');  
 
INSERT INTO "v2017".hmis_type (name,status,value,description) values ('projectcompletionstatus','ACTIVE','1','Completed project');
INSERT INTO "v2017".hmis_type (name,status,value,description) values ('projectcompletionstatus','ACTIVE','2','Youth voluntarily left early'); 
INSERT INTO "v2017".hmis_type (name,status,value,description) values ('projectcompletionstatus','ACTIVE','3','Youth was expelled or otherwise involuntarily discharged from project');
INSERT INTO "v2017".hmis_type (name,value,description,status)  values ('projectcompletionstatus','99','Data not collected','ACTIVE');  

INSERT INTO "v2017".hmis_type (name,value,description,status)  values ('race','1','American Indian or Alaska Native','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status)  values ('race','2','Asian','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status)  values ('race','3','Black or African American','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status)  values ('race','4','Native Hawaiian or Other Pacific Islander','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status)  values ('race','5','White','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status)  values ('race','8','Client does not know','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status)  values ('race','9','Client refused','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status)  values ('race','99','Data not collected','ACTIVE');	

INSERT INTO "v2017".hmis_type (name,status,value,description) values ('housingType','ACTIVE','1','Site-based - single site'); 
 INSERT INTO "v2017".hmis_type (name,status,value,description) values ('housingType','ACTIVE','2','Site-based - clustered/multiple sites'); 
 INSERT INTO "v2017".hmis_type (name,status,value,description) values ('housingType','ACTIVE','3','Tenant-based - scattered site');


 INSERT INTO "v2017".hmis_type (name,status,value,description) values ('projecttype','ACTIVE','1','Emergency Shelter'); 
 INSERT INTO "v2017".hmis_type (name,status,value,description) values ('projecttype','ACTIVE','2','Transitional Housing'); 
 INSERT INTO "v2017".hmis_type (name,status,value,description) values ('projecttype','ACTIVE','3','PH - Permanent Supportive Housing (disability required for entry)');
 INSERT INTO "v2017".hmis_type (name,status,value,description) values ('projecttype','ACTIVE','4','Street Outreach'); 
 INSERT INTO "v2017".hmis_type (name,status,value,description) values ('projecttype','ACTIVE','6','Services Only');
 INSERT INTO "v2017".hmis_type (name,status,value,description) values ('projecttype','ACTIVE','7','Other'); 
 INSERT INTO "v2017".hmis_type (name,status,value,description) values ('projecttype','ACTIVE','8','Safe Haven'); 
 INSERT INTO "v2017".hmis_type (name,status,value,description) values ('projecttype','ACTIVE','9','PH – Housing Only');
 INSERT INTO "v2017".hmis_type (name,status,value,description) values ('projecttype','ACTIVE','10','PH – Housing with Services (no disability required for entry)');
 INSERT INTO "v2017".hmis_type (name,status,value,description) values ('projecttype','ACTIVE','11','Day Shelter');
 INSERT INTO "v2017".hmis_type (name,status,value,description) values ('projecttype','ACTIVE','12','Homelessness Prevention'); 
 INSERT INTO "v2017".hmis_type (name,status,value,description) values ('projecttype','ACTIVE','13','PH - Rapid Re-Housing');
 INSERT INTO "v2017".hmis_type (name,status,value,description) values ('projecttype','ACTIVE','14','Coordinated Assessment');
 

 INSERT INTO "v2017".hmis_type (name,status,value,description) values ('reason_not_enrolled','ACTIVE','1','Client was found ineligible for PATH');
 INSERT INTO "v2017".hmis_type (name,status,value,description) values ('reason_not_enrolled','ACTIVE','2','Client was not enrolled for other reason(s)');
  INSERT INTO "v2017".hmis_type (name,value,description,status)  values ('reason_not_enrolled','99','Data not collected','ACTIVE'); 


 INSERT INTO "v2017".hmis_type (name,status,value,description) values ('projecttype','ACTIVE','12','Contact');
 INSERT INTO "v2017".hmis_type (name,status,value,description) values ('projecttype','ACTIVE','14','Services Provided');
 INSERT INTO "v2017".hmis_type (name,status,value,description) values ('projecttype','ACTIVE','15','Financial Assistance');
 INSERT INTO "v2017".hmis_type (name,status,value,description) values ('projecttype','ACTIVE','16','Referrals Provided');
  INSERT INTO "v2017".hmis_type (name,status,value,description) values ('projecttype','ACTIVE','141','PATH service');
  INSERT INTO "v2017".hmis_type (name,status,value,description) values ('projecttype','ACTIVE','142','RHY service');
  INSERT INTO "v2017".hmis_type (name,status,value,description) values ('projecttype','ACTIVE','143','HOPWA service');
  INSERT INTO "v2017".hmis_type (name,status,value,description) values ('projecttype','ACTIVE','144','SSVF service');
  INSERT INTO "v2017".hmis_type (name,status,value,description) values ('projecttype','ACTIVE','151','HOPWA financial assistance');
  INSERT INTO "v2017".hmis_type (name,status,value,description) values ('projecttype','ACTIVE','152','SSVF financial assistance');
  INSERT INTO "v2017".hmis_type (name,status,value,description) values ('projecttype','ACTIVE','161','PATH referral');
  INSERT INTO "v2017".hmis_type (name,status,value,description) values ('projecttype','ACTIVE','162','RHY referral');
  INSERT INTO "v2017".hmis_type (name,status,value,description) values ('projecttype','ACTIVE','200','Bed night');
  
  INSERT INTO "v2017".hmis_type (name,status,value,description) values ('referraloutcome','ACTIVE','1','Attained');
  INSERT INTO "v2017".hmis_type (name,status,value,description) values ('referraloutcome','ACTIVE','2','Not Attained');
  INSERT INTO "v2017".hmis_type (name,status,value,description) values ('referraloutcome','ACTIVE','3','Unkown');
 
 
 INSERT INTO "v2017".hmis_type (name,status,value,description) values ('referral_source','ACTIVE','1','Self-Referral');
 INSERT INTO "v2017".hmis_type (name,status,value,description) values ('referral_source','ACTIVE','2','Individual: Parent/Guardian');
 INSERT INTO "v2017".hmis_type (name,status,value,description) values ('referral_source','ACTIVE','3','Individual: Relative or Friend');
 INSERT INTO "v2017".hmis_type (name,status,value,description) values ('referral_source','ACTIVE','4','Individual: Other Adult or Youth'); 
 INSERT INTO "v2017".hmis_type (name,status,value,description) values ('referral_source','ACTIVE','5','Individual: Partner/Spouse');
 INSERT INTO "v2017".hmis_type (name,status,value,description) values ('referral_source','ACTIVE','6','Individual: Foster Parent');
 INSERT INTO "v2017".hmis_type (name,status,value,description) values ('referral_source','ACTIVE','7','Outreach Project: FYSB');  	
 INSERT INTO "v2017".hmis_type (name,status,value,description) values ('referral_source','ACTIVE','10','Outreach Project: Other');
 INSERT INTO "v2017".hmis_type (name,status,value,description) values ('referral_source','ACTIVE','11','Temporary Shelter: FYSB Basic Center Project');
 INSERT INTO "v2017".hmis_type (name,status,value,description) values ('referral_source','ACTIVE','12','Temporary Shelter: Other Youth Only Emergency Shelter');
 INSERT INTO "v2017".hmis_type (name,status,value,description) values ('referral_source','ACTIVE','13','Temporary Shelter: Emergency Shelter for Families');
 INSERT INTO "v2017".hmis_type (name,status,value,description) values ('referral_source','ACTIVE','14','Temporary Shelter: Emergency Shelter for Individuals');
 INSERT INTO "v2017".hmis_type (name,status,value,description) values ('referral_source','ACTIVE','15','Temporary Shelter: Domestic Violence Shelter');
 INSERT INTO "v2017".hmis_type (name,status,value,description) values ('referral_source','ACTIVE','16','Temporary Shelter: Safe Place');
 INSERT INTO "v2017".hmis_type (name,status,value,description) values ('referral_source','ACTIVE','17','Temporary Shelter: Other');
 INSERT INTO "v2017".hmis_type (name,status,value,description) values ('referral_source','ACTIVE','18','Residential Project: FYSB Transitional Living Project'); 
 INSERT INTO "v2017".hmis_type (name,status,value,description) values ('referral_source','ACTIVE','19','Residential Project: Other Transitional Living Project');
 INSERT INTO "v2017".hmis_type (name,status,value,description) values ('referral_source','ACTIVE','20','Residential Project: Group Home'); 
 INSERT INTO "v2017".hmis_type (name,status,value,description) values ('referral_source','ACTIVE','21','Residential Project: Independent Living Project'); 
 INSERT INTO "v2017".hmis_type (name,status,value,description) values ('referral_source','ACTIVE','22','Residential Project: Job Corps'); 
 INSERT INTO "v2017".hmis_type (name,status,value,description) values ('referral_source','ACTIVE','23','Residential Project: Drug Treatment Center');
 INSERT INTO "v2017".hmis_type (name,status,value,description) values ('referral_source','ACTIVE','24','Residential Project: Treatment Center');
 INSERT INTO "v2017".hmis_type (name,status,value,description) values ('referral_source','ACTIVE','25','Residential Project: Educational Institute'); 
 INSERT INTO "v2017".hmis_type (name,status,value,description) values ('referral_source','ACTIVE','26','Residential Project: Other Agency project'); 
 INSERT INTO "v2017".hmis_type (name,status,value,description) values ('referral_source','ACTIVE','27','Residential Project: Other Project'); 
 INSERT INTO "v2017".hmis_type (name,status,value,description) values ('referral_source','ACTIVE','28','Hotline: National Runaway Switchboard'); 
 INSERT INTO "v2017".hmis_type (name,status,value,description) values ('referral_source','ACTIVE','29','Hotline: Other'); 
 INSERT INTO "v2017".hmis_type (name,status,value,description) values ('referral_source','ACTIVE','30','Other Agency: Child Welfare/CPS'); 
 INSERT INTO "v2017".hmis_type (name,status,value,description) values ('referral_source','ACTIVE','31','Other Agency: Non-Residential Independent Living Project');
 INSERT INTO "v2017".hmis_type (name,status,value,description) values ('referral_source','ACTIVE','32','Other Project Operated by your Agency');
 INSERT INTO "v2017".hmis_type (name,status,value,description) values ('referral_source','ACTIVE','33','Other Youth Services Agency');
 INSERT INTO "v2017".hmis_type (name,status,value,description) values ('referral_source','ACTIVE','34','Juvenile Justice');
 INSERT INTO "v2017".hmis_type (name,status,value,description) values ('referral_source','ACTIVE','35','Law Enforcement/ Police');
 INSERT INTO "v2017".hmis_type (name,status,value,description) values ('referral_source','ACTIVE','36','Religious Organization');
 INSERT INTO "v2017".hmis_type (name,status,value,description) values ('referral_source','ACTIVE','37','Mental Hospital');
 INSERT INTO "v2017".hmis_type (name,status,value,description) values ('referral_source','ACTIVE','38','School');
 INSERT INTO "v2017".hmis_type (name,status,value,description) values ('referral_source','ACTIVE','39','Other Organization');
 INSERT INTO "v2017".hmis_type (name,value,description,status)  values ('referral_source','8','Client does not know','ACTIVE'); 
 INSERT INTO "v2017".hmis_type (name,value,description,status)  values ('referral_source','9','Client refused','ACTIVE');  
 INSERT INTO "v2017".hmis_type (name,value,description,status)  values ('referral_source','99','Data not collected','ACTIVE');  
 
  INSERT INTO "v2017".hmis_type (name,status,value,description) values ('relationshiptohoh','ACTIVE','1','Self (head of household)'); 
  INSERT INTO "v2017".hmis_type (name,status,value,description) values ('relationshiptohoh','ACTIVE','2','Head of household’s child'); 
  INSERT INTO "v2017".hmis_type (name,status,value,description) values ('relationshiptohoh','ACTIVE','3','Head of household’s spouse or partner');
  INSERT INTO "v2017".hmis_type (name,status,value,description) values ('relationshiptohoh','ACTIVE','4','Head of household’s other relation member (other relation to head of household)');
  INSERT INTO "v2017".hmis_type (name,status,value,description) values ('relationshiptohoh','ACTIVE','5','Other: non-relation member');
  
  
   INSERT INTO "v2017".hmis_type (name,status,value,description) values ('residencePrior','ACTIVE','1','Emergency shelter, including hotel or motel paid for with emergency shelter voucher');
   INSERT INTO "v2017".hmis_type (name,status,value,description) values ('residencePrior','ACTIVE','2','Transitional housing for homeless persons (including homeless youth)');
   INSERT INTO "v2017".hmis_type (name,status,value,description) values ('residencePrior','ACTIVE','3','Permanent housing for formerly homeless persons (such as: CoC project; HUD legacy programs; or HOPWA PH)'); 
   INSERT INTO "v2017".hmis_type (name,status,value,description) values ('residencePrior','ACTIVE','4','Psychiatric hospital or other psychiatric facility');
   INSERT INTO "v2017".hmis_type (name,status,value,description) values ('residencePrior','ACTIVE','5','Substance abuse treatment facility or detox center');
   INSERT INTO "v2017".hmis_type (name,status,value,description) values ('residencePrior','ACTIVE','6','Hospital or other residential non-psychiatric medical facility');
   INSERT INTO "v2017".hmis_type (name,status,value,description) values ('residencePrior','ACTIVE','7','Jail, prison or juvenile detention facility'); 
   INSERT INTO "v2017".hmis_type (name,status,value,description) values ('residencePrior','ACTIVE','8','Client does not know');
   INSERT INTO "v2017".hmis_type (name,status,value,description) values ('residencePrior','ACTIVE','9','Client refused'); 
  INSERT INTO "v2017".hmis_type (name,status,value,description) values ('referral_source','ACTIVE','12','Staying or living in a family member’s room, apartment or house');          
  INSERT INTO "v2017".hmis_type (name,status,value,description) values ('referral_source','ACTIVE','13','Staying or living in a friend’s room, apartment or house');
  INSERT INTO "v2017".hmis_type (name,status,value,description) values ('referral_source','ACTIVE','14','Hotel or motel paid for without emergency shelter voucher'); 
  INSERT INTO "v2017".hmis_type (name,status,value,description) values ('referral_source','ACTIVE','15','Foster care home or foster care group home');                         
  INSERT INTO "v2017".hmis_type (name,status,value,description) values ('referral_source','ACTIVE','16','Place not meant for habitation (e.g. a vehicle, an abandoned building, bus/train/subway station/airport or anywhere outside)');
  INSERT INTO "v2017".hmis_type (name,status,value,description) values ('referral_source','ACTIVE','17','Other');
  INSERT INTO "v2017".hmis_type (name,status,value,description) values ('referral_source','ACTIVE','18','Safe Haven');
  INSERT INTO "v2017".hmis_type (name,status,value,description) values ('referral_source','ACTIVE','19','Rental by client, with VASH subsidy');
  INSERT INTO "v2017".hmis_type (name,status,value,description) values ('referral_source','ACTIVE','20','Rental by client, with other ongoing housing subsidy');
  INSERT INTO "v2017".hmis_type (name,status,value,description) values ('referral_source','ACTIVE','21','Owned by client, with ongoing housing subsidy'); 
  INSERT INTO "v2017".hmis_type (name,status,value,description) values ('referral_source','ACTIVE','22','Rental by client, no ongoing housing subsidy');
  INSERT INTO "v2017".hmis_type (name,status,value,description) values ('referral_source','ACTIVE','23','Owned by client, no ongoing housing subsidy'); 
  INSERT INTO "v2017".hmis_type (name,status,value,description) values ('referral_source','ACTIVE','24','Long-term care facility or nursing home');
  INSERT INTO "v2017".hmis_type (name,status,value,description) values ('referral_source','ACTIVE','25','Rental by client, with GPD TIP subsidy');
  INSERT INTO "v2017".hmis_type (name,status,value,description) values ('referral_source','ACTIVE','26','Residential project or halfway house with no homeless criteria');
  INSERT INTO "v2017".hmis_type (name,value,description,status)  values ('referral_source','99','Data not collected','ACTIVE');
   
  
  INSERT INTO "v2017".hmis_type (name,value,description,status)  values ('record_type','12','Contact records collected under 2014 HMIS Data Standards v5.1','ACTIVE');
  INSERT INTO "v2017".hmis_type (name,value,description,status)  values ('record_type','13','4.12 Contact records collected under 2017 HMIS Data Standards','ACTIVE');
  INSERT INTO "v2017".hmis_type (name,value,description,status)  values ('record_type','141','P1 Services Provided – PATH','ACTIVE');
  INSERT INTO "v2017".hmis_type (name,value,description,status)  values ('record_type','142','R14 RHY Service Connections','ACTIVE');
  INSERT INTO "v2017".hmis_type (name,value,description,status)  values ('record_type','143','W1 Services Provided – HOPWA','ACTIVE');
  INSERT INTO "v2017".hmis_type (name,value,description,status)  values ('record_type','144','V2 Services Provided – SSVF','ACTIVE');
  INSERT INTO "v2017".hmis_type (name,value,description,status)  values ('record_type','151','W2 Financial Assistance – HOPWA','ACTIVE');
  INSERT INTO "v2017".hmis_type (name,value,description,status)  values ('record_type','152','V3 Financial Assistance – SSVF','ACTIVE');
  INSERT INTO "v2017".hmis_type (name,value,description,status)  values ('record_type','161','P2 Referrals Provided – PATH','ACTIVE');
  INSERT INTO "v2017".hmis_type (name,value,description,status)  values ('record_type','200','4.14  Bed night','ACTIVE');
  INSERT INTO "v2017".hmis_type (name,value,description,status)  values ('record_type','210','V8 HUD-VASH Voucher Tracking','ACTIVE');
  
     INSERT INTO "v2017".hmis_type (name,status,value,description) values ('residencePriorlengthofstay','ACTIVE','2','More than one week, but less than one month'); 
     INSERT INTO "v2017".hmis_type (name,status,value,description) values ('residencePriorlengthofstay','ACTIVE','3','One to three months'); 
     INSERT INTO "v2017".hmis_type (name,status,value,description) values ('residencePriorlengthofstay','ACTIVE','4','More than three months, but less than one year');  
     INSERT INTO "v2017".hmis_type (name,status,value,description) values ('residencePriorlengthofstay','ACTIVE','5','One year or longer'); 
     INSERT INTO "v2017".hmis_type (name,status,value,description) values ('residencePriorlengthofstay','ACTIVE','8','Client doesn''t know'); 
     INSERT INTO "v2017".hmis_type (name,status,value,description) values ('residencePriorlengthofstay','ACTIVE','9','Client refused');
    INSERT INTO "v2017".hmis_type (name,status,value,description) values ('residencePriorlengthofstay','ACTIVE','10','One day or less');
    INSERT INTO "v2017".hmis_type (name,status,value,description) values ('residencePriorlengthofstay','ACTIVE','11','Two days to one week'); 
   INSERT INTO "v2017".hmis_type (name,value,description,status)  values ('residencePriorlengthofstay','99','Data not collected','ACTIVE'); 
 
         INSERT INTO "v2017".hmis_type (name,value,description,status) values ('ssn_data_quality','1','Full SSN reported','ACTIVE');
        INSERT INTO "v2017".hmis_type (name,value,description,status) values   ('ssn_data_quality','2','Approximate or partial SSN reported','ACTIVE');
        INSERT INTO "v2017".hmis_type (name,value,description,status) values    ('ssn_data_quality','8','Client does not know','ACTIVE');
        INSERT INTO "v2017".hmis_type  (name,value,description,status) values  ('ssn_data_quality','9','Client refused','ACTIVE');
        INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('ssn_data_quality','99','Data not collected','ACTIVE');
      
        
        INSERT INTO "v2017".hmis_type (name,status,value,description) values ('subsidyinformation','ACTIVE','1','Without a subsidy');
        INSERT INTO "v2017".hmis_type (name,status,value,description) values ('subsidyinformation','ACTIVE','2','With the subsidy they had at project entry');
   	INSERT INTO "v2017".hmis_type (name,status,value,description) values ('subsidyinformation','ACTIVE','3','With an on-going subsidy acquired since project entry');
   	INSERT INTO "v2017".hmis_type (name,status,value,description) values ('subsidyinformation','ACTIVE','4','Only with financial assistance other than a subsidy'); 
   	
   	INSERT INTO "v2017".hmis_type (name,status,value,description) values ('targetpopulation','ACTIVE','1','DV Domestic Violence victims');
   	INSERT INTO "v2017".hmis_type (name,status,value,description) values ('targetpopulation','ACTIVE','3','HIV Persons with HIV/AIDS');
   	INSERT INTO "v2017".hmis_type (name,status,value,description) values ('targetpopulation','ACTIVE','4','NA Not Applicable');
   	
	
	INSERT INTO "v2017".hmis_type (name,value,description,status) values ('timesHomelesspastthreeyears','0','0 (not homeless - Prevention only)','ACTIVE');
	INSERT INTO "v2017".hmis_type (name,value,description,status) values ('timesHomelesspastthreeyears','1','1 (homeless only this time)','ACTIVE');
	INSERT INTO "v2017".hmis_type (name,value,description,status) values ('timesHomelesspastthreeyears','2','2','ACTIVE');
	INSERT INTO "v2017".hmis_type (name,value,description,status) values ('timesHomelesspastthreeyears','3','3','ACTIVE');
	INSERT INTO "v2017".hmis_type (name,value,description,status) values ('timesHomelesspastthreeyears','4','4 or more','ACTIVE');
	INSERT INTO "v2017".hmis_type (name,value,description,status) values  ('timesHomelesspastthreeyears','8','Client does not know','ACTIVE');
	INSERT INTO "v2017".hmis_type  (name,value,description,status) values  ('timesHomelesspastthreeyears','9','Client refused','ACTIVE');
	INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('timesHomelesspastthreeyears','99','Data not collected','ACTIVE');
		       
	
	INSERT INTO "v2017".hmis_type (name,value,description,status) values ('trackingmethod','0','Entry/Exit Date','ACTIVE');
	INSERT INTO "v2017".hmis_type (name,value,description,status) values ('trackingmethod','3','Night-by-Night','ACTIVE');
	
	
	INSERT INTO "v2017".hmis_type (name,value,description,status) values ('whenoccurred','1','Within the past three months','ACTIVE');
	INSERT INTO "v2017".hmis_type (name,value,description,status) values ('whenoccurred','2','Three to six months ago (excluding six months exactly)','ACTIVE');
	INSERT INTO "v2017".hmis_type (name,value,description,status) values ('whenoccurred','3','Six months to one year ago (excluding one year exactly)','ACTIVE');
	INSERT INTO "v2017".hmis_type (name,value,description,status) values ('whenoccurred','4','One year ago or more','ACTIVE');
	INSERT INTO "v2017".hmis_type (name,value,description,status) values  ('whenoccurred','8','Client does not know','ACTIVE');
	INSERT INTO "v2017".hmis_type  (name,value,description,status) values  ('whenoccurred','9','Client refused','ACTIVE');
	INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('whenoccurred','99','Data not collected','ACTIVE');
	
	
	
	INSERT INTO "v2017".hmis_type (name,value,description,status) values ('housingstatus','1','Category 1 - Homeless','ACTIVE');
	INSERT INTO "v2017".hmis_type (name,value,description,status) values ('housingstatus','2','Category 2 - At imminent risk of losing housing','ACTIVE');
	INSERT INTO "v2017".hmis_type (name,value,description,status) values ('housingstatus','3','At-risk of homelessness','ACTIVE');
	INSERT INTO "v2017".hmis_type (name,value,description,status) values ('housingstatus','4','Stably Housed','ACTIVE');
	INSERT INTO "v2017".hmis_type (name,value,description,status) values ('housingstatus','5','Category 3 - Homeless only under other federal statutes','ACTIVE');
	INSERT INTO "v2017".hmis_type (name,value,description,status) values ('housingstatus','6','Category 4 - Fleeing domestic violence','ACTIVE');
	INSERT INTO "v2017".hmis_type (name,value,description,status) values  ('housingstatus','8','Client does not know','ACTIVE');
	INSERT INTO "v2017".hmis_type  (name,value,description,status) values  ('housingstatus','9','Client refused','ACTIVE');
	INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('housingstatus','99','Data not collected','ACTIVE');
	
	INSERT INTO "v2017".hmis_type (name,value,description,status) values ('youth_age_group','1','Only under age 18','ACTIVE');
	INSERT INTO "v2017".hmis_type (name,value,description,status) values ('youth_age_group','2','Only ages 18 to 24','ACTIVE'); 
	INSERT INTO "v2017".hmis_type (name,value,description,status) values ('youth_age_group','3','Only youth under age 24 (both of the above)','ACTIVE');
	
	
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('veteran_status','0','No','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('veteran_status','1','Yes','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values    ('veteran_status','8','Client does not know','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values  ('veteran_status','9','Client refused','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('veteran_status','99','Data not collected','ACTIVE');

INSERT INTO "v2017".hmis_type (name,value,description,status) values ('afghanistan_oef','0','No','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values ('afghanistan_oef','1','Yes','ACTIVE');
INSERT INTO "v2017".hmis_type (name,value,description,status) values    ('afghanistan_oef','8','Client does not know','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values  ('afghanistan_oef','9','Client refused','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('afghanistan_oef','99','Data not collected','ACTIVE');

-- New ENUMS Insert Starts
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('percentami','1','Less than 30%','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('percentami','2','30% to 50%','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('percentami','3','Greater than 50%','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('percentami','99','Data not collected','ACTIVE');

INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('connection_with_soar','0','No%','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('connection_with_soar','1','Yes','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('connection_with_soar','8','Client doesnt know','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('connection_with_soar','9','Client refused','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('connection_with_soar','99','Data not collected','ACTIVE');

INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('contact_location','1','Place not meant for habitation','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('contact_location','2','Service setting, non-residential','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('contact_location','3','Service setting, residential','ACTIVE');

INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('written_after_care_plan','0','No','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('written_after_care_plan','1','Yes','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('written_after_care_plan','2','Client refused','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('written_after_care_plan','99','Data Not Collected','ACTIVE');

INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('assistance_main_stream_benefits','0','No','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('assistance_main_stream_benefits','1','Yes','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('assistance_main_stream_benefits','2','Client refused','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('assistance_main_stream_benefits','99','Data Not Collected','ACTIVE');

INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('permanent_housing_placement','0','No','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('permanent_housing_placement','1','Yes','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('permanent_housing_placement','2','Client refused','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('permanent_housing_placement','99','Data Not Collected','ACTIVE');

INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('temp_shelter_placement','0','No','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('temp_shelter_placement','1','Yes','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('temp_shelter_placement','2','Client refused','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('temp_shelter_placement','99','Data Not Collected','ACTIVE');

INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('exit_counseling','0','No','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('exit_counseling','1','Yes','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('exit_counseling','2','Client refused','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('exit_counseling','99','Data Not Collected','ACTIVE');

INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('further_followup_services','0','No','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('further_followup_services','1','Yes','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('further_followup_services','2','Client refused','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('further_followup_services','99','Data Not Collected','ACTIVE');

INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('scheduled_followup_contacts','0','No','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('scheduled_followup_contacts','1','Yes','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('scheduled_followup_contacts','2','Client refused','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('scheduled_followup_contacts','99','Data Not Collected','ACTIVE');

INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('resource_package','0','No','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('resource_package','1','Yes','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('resource_package','2','Client refused','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('resource_package','99','Data Not Collected','ACTIVE');

INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('other_aftercare_plan_or_action','0','No','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('other_aftercare_plan_or_action','1','Yes','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('other_aftercare_plan_or_action','2','Client refused','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('other_aftercare_plan_or_action','99','Data Not Collected','ACTIVE');

INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('family_reunification_achieved','0','No','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('family_reunification_achieved','1','Yes','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('family_reunification_achieved','8','Client doesnt know','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('family_reunification_achieved','9','Client refused','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('family_reunification_achieved','99','Data Not Collected','ACTIVE');

INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('project_completion_status','1','Completed project','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('project_completion_status','2','Youth voluntarily left early','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('project_completion_status','3','Youth was expelled or otherwise involuntarily discharged from project','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('project_completion_status','99','Data Not Collected','ACTIVE');

INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('early_exit_reason','1','if 4.37A: Left for other opportunities – Independent living *OR* if 4.37B: Criminal activity/destruction of property/violence','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('early_exit_reason','2','if 4.37A: Left for other opportunities - Education *OR* if 4.37B: Non-compliance with project rules','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('early_exit_reason','3','if 4.37A: Left for other opportunities - Military *OR* if 4.37B: Non-payment of rent/occupancy charge','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('early_exit_reason','4','if 4.37A: Left for other opportunities - Other *OR* if 4.37B: Reached maximum time allowed by project','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('early_exit_reason','5','if 4.37A: Needs could not be met by project *OR* if 4.37B: Project terminated','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('early_exit_reason','6','4.37B only: Unknown/disappeared','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('early_exit_reason','99','both 4.37A and 4.37B: Data not collected','ACTIVE');

INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('active_military_parent','0','No','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('active_military_parent','1','Yes','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('active_military_parent','99','Data Not Collected','ACTIVE');

INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('house_hold_dynamics','0','No','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('house_hold_dynamics','1','Yes','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('house_hold_dynamics','99','Data Not Collected','ACTIVE');

INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('insufficient_income_to_support_youth','0','No','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('insufficient_income_to_support_youth','1','Yes','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('insufficient_income_to_support_youth','99','Data Not Collected','ACTIVE');

INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('alcohol_drug_abuse_family_mbr','0','No','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('alcohol_drug_abuse_family_mbr','1','Yes','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('alcohol_drug_abuse_family_mbr','99','Data Not Collected','ACTIVE');

INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('alcohol_drug_abuse_youth','0','No','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('alcohol_drug_abuse_youth','1','Yes','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('alcohol_drug_abuse_youth','99','Data Not Collected','ACTIVE');

INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('abuse_and_neglect_family_mbr','0','No','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('abuse_and_neglect_family_mbr','1','Yes','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('abuse_and_neglect_family_mbr','99','Data Not Collected','ACTIVE');

INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('abuse_and_neglect_youth','0','No','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('abuse_and_neglect_youth','1','Yes','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('abuse_and_neglect_youth','99','Data Not Collected','ACTIVE');

INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('mental_disability_family_mbr','0','No','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('mental_disability_family_mbr','1','Yes','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('mental_disability_family_mbr','99','Data Not Collected','ACTIVE');

INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('mental_disability_youth','0','No','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('mental_disability_youth','1','Yes','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('mental_disability_youth','99','Data Not Collected','ACTIVE');

INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('physical_disability_family_mbr','0','No','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('physical_disability_family_mbr','1','Yes','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('physical_disability_family_mbr','99','Data Not Collected','ACTIVE');

INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('physical_disability_youth','0','No','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('physical_disability_youth','1','Yes','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('physical_disability_youth','99','Data Not Collected','ACTIVE');

INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('health_issues_family_mbr','0','No','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('health_issues_family_mbr','1','Yes','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('health_issues_family_mbr','99','Data Not Collected','ACTIVE');

INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('health_issues_youth','0','No','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('health_issues_youth','1','Yes','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('health_issues_youth','99','Data Not Collected','ACTIVE');

INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('mental_health_issues_family_mbrily_mbr','0','No','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('mental_health_issues_family_mbrily_mbr','1','Yes','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('mental_health_issues_family_mbrily_mbr','99','Data Not Collected','ACTIVE');

INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('mental_health_issues_youth','0','No','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('mental_health_issues_youth','1','Yes','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('mental_health_issues_youth','99','Data Not Collected','ACTIVE');

INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('unemployement_family_mbr','0','No','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('unemployement_family_mbr','1','Yes','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('unemployement_family_mbr','99','Data Not Collected','ACTIVE');

INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('school_educational_issues_youth','0','No','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('school_educational_issues_youth','1','Yes','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('school_educational_issues_youth','99','Data Not Collected','ACTIVE');

INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('school_education_issues_family_mbr','0','No','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('school_education_issues_family_mbr','1','Yes','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('school_education_issues_family_mbr','99','Data Not Collected','ACTIVE');

INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('unemployment_youth','0','No','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('unemployment_youth','1','Yes','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('unemployment_youth','99','Data Not Collected','ACTIVE');

INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('incarcerated_parent','0','No','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('incarcerated_parent','1','Yes','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('incarcerated_parent','99','Data Not Collected','ACTIVE');

INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('housing_issues_family_mbr','0','No','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('housing_issues_family_mbr','1','Yes','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('housing_issues_family_mbr','99','Data Not Collected','ACTIVE');

INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('housing_issues_youth','0','No','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('housing_issues_youth','1','Yes','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('housing_issues_youth','99','Data Not Collected','ACTIVE');

INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('sexual_orientation_gender_identity_Youth','0','No','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('sexual_orientation_gender_identity_Youth','1','Yes','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('sexual_orientation_gender_identity_Youth','99','Data Not Collected','ACTIVE');

INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('sexual_orientatiion_gender_identity_family_mbr','0','No','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('sexual_orientatiion_gender_identity_family_mbr','1','Yes','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('sexual_orientatiion_gender_identity_family_mbr','99','Data Not Collected','ACTIVE');

INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('years_child_welfr_forest_care','1','Less than one year','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('years_child_welfr_forest_care','2','Less than one year','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('years_child_welfr_forest_care','3','3 to 5 or more years','ACTIVE');

INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('years_juvenile_justice','1','Less than one year','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('years_juvenile_justice','2','Less than one year','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('years_juvenile_justice','3','3 to 5 or more years','ACTIVE');

INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('formerly_ward_child_welfr_forest_care','0','No','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('formerly_ward_child_welfr_forest_care','1','Yes','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('formerly_ward_child_welfr_forest_care','8','Client doesnt know','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('formerly_ward_child_welfr_forest_care','9','Client refused','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('formerly_ward_child_welfr_forest_care','99','Data Not Collected','ACTIVE');

INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('formerly_ward_of_juvenile_justice','0','No','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('formerly_ward_of_juvenile_justice','1','Yes','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('formerly_ward_of_juvenile_justice','8','Client doesnt know','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('formerly_ward_of_juvenile_justice','9','Client refused','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('formerly_ward_of_juvenile_justice','99','Data Not Collected','ACTIVE');

INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('asked_of_forced_to_exchange_for_sex_past_3_months','0','No','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('asked_of_forced_to_exchange_for_sex_past_3_months','1','Yes','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('asked_of_forced_to_exchange_for_sex_past_3_months','8','Client doesnt know','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('asked_of_forced_to_exchange_for_sex_past_3_months','9','Client refused','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('asked_of_forced_to_exchange_for_sex_past_3_months','99','Data Not Collected','ACTIVE');

INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('exchange_for_sex_past_three_months','0','No','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('exchange_for_sex_past_three_months','1','Yes','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('exchange_for_sex_past_three_months','8','Client doesnt know','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('exchange_for_sex_past_three_months','9','Client refused','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('exchange_for_sex_past_three_months','99','Data Not Collected','ACTIVE');

INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('coerced_to_continue_work','0','No','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('coerced_to_continue_work','1','Yes','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('coerced_to_continue_work','8','Client doesnt know','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('coerced_to_continue_work','9','Client refused','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('coerced_to_continue_work','99','Data Not Collected','ACTIVE');

INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('work_place_promise_difference','0','No','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('work_place_promise_difference','1','Yes','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('work_place_promise_difference','8','Client doesnt know','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('work_place_promise_difference','9','Client refused','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('work_place_promise_difference','99','Data Not Collected','ACTIVE');

INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('work_place_violence_threats','0','No','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('work_place_violence_threats','1','Yes','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('work_place_violence_threats','8','Client doesnt know','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('work_place_violence_threats','9','Client refused','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('work_place_violence_threats','99','Data Not Collected','ACTIVE');

INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('incarcerated_parent_status','1','One parent / legal guardian is incarcerated','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('incarcerated_parent_status','2','One parent / legal guardian is incarcerated','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('incarcerated_parent_status','3','The only parent / legal guardian is incarceratedt','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('incarcerated_parent_status','99','Data Not Collected','ACTIVE');

INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('count_of_exchange_for_sex','1','1-3','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('count_of_exchange_for_sex','2','4-7','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('count_of_exchange_for_sex','3','8-11','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('count_of_exchange_for_sex','4','12 or more','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('count_of_exchange_for_sex','8','Client doesnt know','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('count_of_exchange_for_sex','9','Client refused','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('count_of_exchange_for_sex','99','Data Not Collected','ACTIVE');

INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('asked_of_forced_to_exchange_for_sex','0','No','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('asked_of_forced_to_exchange_for_sex','1','Yes','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('asked_of_forced_to_exchange_for_sex','8','Client doesnt know','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('asked_of_forced_to_exchange_for_sex','9','Client refused','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('asked_of_forced_to_exchange_for_sex','99','Data Not Collected','ACTIVE');

INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('geography_type','1','Urban','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('geography_type','2','Suburban','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('geography_type','3','Rural','ACTIVE');

INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('cm_exit_reason','1','Accomplished goals and/or obtained services and no longer needs CM','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('cm_exit_reason','2','Transferred to another HUD-VASH program site','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('cm_exit_reason','3','Found/chose other housing','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('cm_exit_reason','4','Did not comply with HUD-VASH CM','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('cm_exit_reason','5','Eviction and/or other housing related issues','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('cm_exit_reason','6','Unhappy with HUD-VASH housing','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('cm_exit_reason','7','No longer financially eligible for HUD/VASH voucher','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('cm_exit_reason','8','No longer interested in participating in this program','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('cm_exit_reason','9','Veteran cannot be located','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('cm_exit_reason','10','Veteran too ill to participate at this time','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('cm_exit_reason','11','Veteran is incarcerated','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('cm_exit_reason','12','Veteran is deceased','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('cm_exit_reason','13','Other','ACTIVE');
INSERT INTO "v2017".hmis_type  (name,value,description,status) values ('cm_exit_reason','99','Data not collected','ACTIVE');

-- New ENUMS Insert Ends

create table "v2017".source
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

create table "v2017".export
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
      REFERENCES v2017.source (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
     )
with (
  oids=false
);



create table "v2017".organization
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


CREATE TABLE  "v2017".project
(
	  id uuid NOT NULL,
	  project_id character varying(8),
	  projectname text,
	  continuumproject "v2017".no_yes,
	  projecttype "v2017".project_type,
	  residentialaffiliation integer,
	  operatingstartdate timestamp,
	  operatingenddate timestamp,
	  trackingmethod "v2017".tracking_method,
	  targetpopulation "v2017".target_population_type,
	  victimServiceProvider "v2017".no_yes,
	  housingType  "v2017".housingType,
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
	      REFERENCES v2017.organization (id) MATCH SIMPLE
	      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);

-- DROP TABLE "v2017"."client";
CREATE TABLE "v2017".client
(
  "id" uuid NOT NULL,
  "dedup_client_id" uuid,
  "first_name" character(50),
  "middle_name" character(50),
  "last_name" character(50),
  "name_suffix" character(50),
  "name_data_quality" "v2017".name_data_quality,
	dob BYTEA, 
	ssn BYTEA,
  "ssn_data_quality" "v2017".ssn_data_quality,
  "dob_data_quality" "v2017".dob_data_quality,
  "gender" "v2017".gender,
--  "other_gender" text,
  "ethnicity" "v2017".ethnicity,
  "race"  "v2017".race,
  "veteran_status" "v2017".veteran_status,
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
-- Table: "v2017"."client"

-- veteran_info changed to client_veteran_info
CREATE TABLE "v2017".client_veteran_info
(
  "id" uuid NOT NULL,
  "year_entrd_service" integer,
  "year_seperated" integer,
  "world_war_2" "v2017".five_val_dk_refused,
  "korean_war" "v2017".five_val_dk_refused,
  "vietnam_war" "v2017".five_val_dk_refused,
  "desert_storm" "v2017".five_val_dk_refused,
  "afghanistan_oef" "v2017".afghanistanoef,
  "iraq_oif" "v2017".five_val_dk_refused,
  "iraq_ond" "v2017".five_val_dk_refused,
  "other_theater" "v2017".five_val_dk_refused,
  "military_branch" "v2017".military_branch,
  "discharge_status" "v2017".discharge_status,
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
      REFERENCES "v2017".client ("id") MATCH SIMPLE
)
WITH (
  OIDS=FALSE
);

CREATE TABLE "v2017".enrollment
(
  	id uuid NOT NULL,
	projectentryid uuid,
	entrydate timestamp,
	householdid text,
	relationshiptohoh "v2017".relationship_to_head_of_household,
	livingSituation "v2017".livingSituation,
	lengthOfStay "v2017".lengthOfStay,
	losunderthreshold "v2017".no_yes, 
	previousStreetESSH "v2017".no_yes,
	disablingCondition "v2017".five_val_dk_refused,
	dateToStreetESSH timestamp,
	timesHomelesspastthreeyears "v2017".times_homeless_past_3_years,
	monthsHomelessPastThreeYears "v2017".months_homeless_past_3_years,
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
	source varchar varying(56) DEFAULT 2017,
  		CONSTRAINT "enrollment_pkey" PRIMARY KEY (id),
    	CONSTRAINT enrollment_client_fk FOREIGN KEY ("client_id")
      	REFERENCES "v2017".client ("id") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
      	CONSTRAINT enrollment_project_fk FOREIGN KEY ("projectid")
      	REFERENCES "v2017".project ("id") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);




CREATE TABLE "v2017".path_status
(
  "id" uuid NOT NULL,
  "date_of_status" timestamp,
  "client_enrolled_in_path" bigint,
  "reason_not_enrolled"  "v2017".reason_not_enrolled,
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
      REFERENCES v2017.enrollment ("id") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);


CREATE TABLE "v2017".entrySSVF
(
	"id" uuid NOT NULL,
	"enrollmentid" uuid,
	"percentami"  "v2017".percentAMI,
	last_permanent_street character(50),
	last_permanent_city character(50),
	last_permanent_state character(50),
	last_permanent_zip character(50),
	address_data_quality "v2017".address_data_quality,
	urgent_referral "v2017".no_yes,
	timeToHousingLoss "v2017".timeToHousingLoss,
	zeroincome "v2017".no_yes,
	annualpercentami "v2017".annualpercentami,
	financialchange "v2017".no_yes,
	householdchange "v2017".no_yes,
	evictionhistory "v2017".evictionhistory,
	subsidyatrisk "v2017".no_yes,
	literalHomelessHistory "v2017".literalHomelessHistory,
	disablehoh "v2017".no_yes,
	criminalrecord "v2017".no_yes,
	sexoffender "v2017".no_yes,
	dependendunder6 "v2017".no_yes,
	singleparent "v2017".no_yes,
	hh5plus "v2017".no_yes,
	iraqafghanistan "v2017".no_yes,
	femvet "v2017".no_yes,
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
      REFERENCES v2017.enrollment ("id") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);	

CREATE TABLE "v2017".entryRHY
(
	"id" uuid NOT NULL,
	"enrollmentid" uuid,
	"sexual_orientation" "v2017".sexual_orientation,
	"unemployement_family_mbr" "v2017".unemployement_family_mbr,
	"mental_health_issues_family_mbrily_mbr" "v2017".mental_health_issues_family_mbrily_mbr,
	"physical_disability_family_mbr" "v2017".physical_disability_family_mbr,
	"alcohol_drug_abuse_family_mbr" "v2017".alcohol_drug_abuse_family_mbr,
	"insufficient_income_to_support_youth" "v2017".insufficient_income_to_support_youth,
	"incarcerated_parent" "v2017".incarcerated_parent,
	"formerly_ward_of_juvenile_justice" "v2017".formerly_ward_of_juvenile_justice,
	"years_juvenile_justice" "v2017".years_juvenile_justice,
	"months_juvenile_justice" integer, 
	"formerly_ward_child_welfr_forest_care" "v2017".formerly_ward_child_welfr_forest_care,
	"years_child_welfr_forest_care" "v2017".years_child_welfr_forest_care,
	months_child_welfr_forest_care integer,
	referral_source "v2017".referral_source,
	count_out_reach_referral_approaches integer,
	 information_date timestamp,
 	 "datacollectionstage" "v2017".datacollectionstage,
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
      REFERENCES v2017.enrollment ("id") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);	

CREATE TABLE "v2017".enrollment_coc
(
	  id uuid NOT NULL,
  	  enrollmentid uuid,
	  coc_code character(20),
	  householdid text,
	  information_date timestamp,
	  "datacollectionstage" "v2017".datacollectionstage,
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
      	REFERENCES v2017.enrollment ("id") MATCH SIMPLE
      	ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);


CREATE TABLE "v2017".service_fa_referral
(
  "id" uuid NOT NULL,
  "enrollmentid" uuid,
  dateProvided timestamp,
  record_type "v2017".record_type,
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
	REFERENCES v2017.enrollment ("id") MATCH SIMPLE
	ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);

-- Table: v2017.last_grade_completed

CREATE TABLE "v2017".schoolstatus
(
  "id" uuid NOT NULL,
  "information_date" timestamp,
  "school_status" "v2017".school_status,
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
      REFERENCES v2017.enrollment ("id") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);


CREATE TABLE "v2017".employment
(
  "id" uuid NOT NULL,
  "information_date" timestamp,
  "datacollectionstage" "v2017".datacollectionstage,
  "employed" "v2017".five_val_dk_refused,
  "employment_type" "v2017".employment_type,
  "not_employed_reason" "v2017".not_employed_reason,
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
      REFERENCES v2017.enrollment ("id") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);


CREATE TABLE "v2017".health_status
(
  "id" uuid NOT NULL,
  "enrollmentid" uuid,
  "information_date" timestamp,
  "datacollectionstage" "v2017".datacollectionstage,
  "health_category" "v2017".health_category,
  "health_status" "v2017".health_status_type,
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
      REFERENCES v2017.enrollment ("id") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);


create table "v2017".contact
(
	id uuid not null, 
	contact_date timestamp,
	contact_location v2017.contact_location,
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
      REFERENCES v2017.enrollment ("id") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);


-- Table: "affiliation"

-- DROP TABLE "affiliation";

CREATE TABLE "v2017".affiliation
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
		REFERENCES v2017.project (id) MATCH SIMPLE
		ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);

-- table: "projectcoc" changed to CoC

-- drop table "coc";

create table "v2017".coc
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
      references v2017.project (id) match simple
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
with (
  oids=false
);


create table "v2017".inventory
(
   id uuid not null,
  householdtype "v2017".house_hold_type,
  bedtype "v2017".bed_type,
  availabilty "v2017".availability,
  unitinventory integer,
  bed_inventory integer,
  ch_bed_inventory integer,
  vet_bed_inventory integer,
  youth_bed_inventory integer,
  --youth_age_group integer,
  facility_bed_inventory integer,
  voucher_bed_inventory integer,
  other_bed_inventory integer,
  inventorystartdate timestamp,
  inventoryenddate timestamp,
  hmisparticipatingbeds integer,
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
      references v2017."coc" (id) match simple
      on update no action on delete no action
)
with (
  oids=false
);


-- table: "funder"

-- drop table "funder";

create table  "v2017".funder
(
  "id"  uuid not null,
  "enddate" timestamp,
  "funder" "v2017".federal_partner_components,
  "grantid" uuid,
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
      references v2017.project (id) match simple
      on update no action on delete no action
)
with (
  oids=false
);


CREATE TABLE "v2017".rhybcp_status
(
  "id" uuid NOT NULL,
  "status_date" timestamp,
  eligible_for_rhy  "v2017".no_yes,
  "reason_no_services" "v2017".fysb_rsn_not_providing_srvcs,
  runaway_youth  "v2017".no_yes,
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
	REFERENCES v2017.enrollment ("id") MATCH SIMPLE
	ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);


-- table: "medicalassistance"

-- drop table "medicalassistance";

create table "v2017".medicalassistance
(
	id uuid not null,  
	hivaidsassistance "v2017".five_val_dk_refused,
  	nohivaidsassistancereason "v2017".no_medical_assistance_reason,
  	adap "v2017".five_val_dk_refused,
  	noadapreason "v2017".no_medical_assistance_reason,
  	information_date timestamp,
  	"datacollectionstage" "v2017".datacollectionstage,
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
      references v2017.enrollment ("id") match simple
      on update no action on delete no action
      
)
with (
  oids=false
);

-- table: "domesticviolence"

-- drop table "domesticviolence";

create table "v2017".domesticviolence
(
  "id"  uuid not null,
  "domesticviolencevictim" "v2017".five_val_dk_refused,
  "enrollmentid" uuid,
  "whenoccurred" "v2017".when_dom_violence_occurred,
  currently_fleeing integer,
  information_date timestamp,
  "datacollectionstage" "v2017".datacollectionstage,
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
      references v2017.enrollment ("id") match simple
      on update no action on delete no action
)
with (
  oids=false
);

-- table: "disabilities"

-- drop table "disabilities";

create table "v2017".disabilities
(
  "id" uuid not null,
  "disabilitytype" "v2017".disability_type,
  "disabilityresponse" integer,
  "indefiniteandimpairs" "v2017".five_val_dk_refused,
  "enrollmentid" uuid,
  tcellcountavailable  "v2017".no_yes,
  tcellcount integer,
  tcellcountsource "v2017".tcell_viralload_source,
  viral_load_available "v2017".viral_load_available,
  viral_load integer,
  viral_load_source "v2017".tcell_viralload_source,
  information_date timestamp,
  "datacollectionstage" "v2017".datacollectionstage,
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
      references v2017.enrollment ("id") match simple
      on update no action on delete no action
)
with (
  oids=false
);
-- table: "moveinDate"

-- drop table "moveinDate";

create table  "v2017".moveinDate
(
  	id uuid not null,
	--inpermanenthousing "v2017".no_yes,
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
      references v2017.enrollment ("id") match simple 
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
with (
  oids=false
);

-- table: "dateofengagement"

-- drop table "dateofengagement";

create table  "v2017".dateofengagement
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
     	references v2017.enrollment ("id") match simple
    	on update no action on delete no action
)
with (
  oids=false
);

create table  "v2017".entryRHSP
(
  	"id" uuid not null,
	worst_housing_situation integer,
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
      	references v2017.enrollment ("id") match simple
      	on update no action on delete no action
)
with (
  oids=false
);

create table  "v2017".education
(
  	"id" uuid not null,
	lastgradecompleted "v2017".last_grade_completed,
	"school_status" "v2017".school_status,
	"enrollmentid" uuid,
	 information_date timestamp,
     "datacollectionstage" "v2017".datacollectionstage,
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
      	references v2017.enrollment ("id") match simple
      	on update no action on delete no action
)
with (
  oids=false
);

-- drop table "incomeandsources";

create table "v2017".incomeandsources
(
  alimony "v2017".no_yes,
  alimonyamount numeric(15,3),
  childsupport "v2017".no_yes,
  childsupportamount numeric(15,3),
  earned "v2017".no_yes,
  earnedamount numeric(15,3),
  ga "v2017".no_yes,
  gaamount numeric(15,3),
  id uuid not null,
  incomefromanysource "v2017".five_val_dk_refused,
  othersource "v2017".no_yes,
  othersourceamount numeric(15,3),
  othersourceidentify text,
  pension "v2017".no_yes,
  pensionamount numeric(15,3),
  privatedisability "v2017".no_yes,
  privatedisabilityamount numeric(15,3),
  enrollmentid uuid,
  socsecretirement "v2017".no_yes,
  socsecretirementamount numeric(15,3),
  ssdi "v2017".no_yes,
  ssdiamount numeric(15,3),
  ssi "v2017".no_yes,
  ssiamount numeric(15,3),
  tanf "v2017".no_yes,
  tanfamount numeric(15,3),
  totalmonthlyincome numeric(15,3),
  unemployment "v2017".no_yes,
  unemploymentamount numeric(15,3),
  vadisabilitynonservice "v2017".no_yes,
  vadisabilitynonserviceamount numeric(15,3),
  vadisabilityservice "v2017".no_yes,
  vadisabilityserviceamount numeric(15,3),
  workerscomp "v2017".no_yes,
  workerscompamount numeric(15,3),
   information_date timestamp,
  "datacollectionstage" "v2017".datacollectionstage,
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
      references v2017.enrollment ("id") match simple
      on update no action on delete no action
)
with (
  oids=false
);



-- drop table "noncashbenefits";

create table "v2017".noncashbenefits
(
	id uuid not null,  
	benefitsfromanysource "v2017".five_val_dk_refused,
  	othersource "v2017".no_yes,
  	othersourceidentify text,
  	othertanf "v2017".no_yes,
  	enrollmentid uuid,
  	rentalassistanceongoing "v2017".no_yes,
  	rentalassistancetemp "v2017".no_yes,
  	snap "v2017".no_yes,
  	tanfchildcare "v2017".no_yes,
  	tanftransportation "v2017".no_yes,
  	wic "v2017".no_yes,
  	information_date timestamp,
    "datacollectionstage" "v2017".datacollectionstage,
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
      references v2017.enrollment ("id") match simple
      on update no action on delete no action
)
with (
  oids=false
);

-- table: "healthinsurance"

-- drop table "healthinsurance";

create table "v2017".healthinsurance
(
  "id" uuid not null,
  "insurancefromanysource" "v2017".five_val_dk_refused,
  "medicaid" "v2017".no_yes,
  "nomedicaidreason" "v2017".no_health_insurance_reason,
  "medicare" "v2017".no_yes,
  "nomedicarereason" "v2017".no_health_insurance_reason,
  "schip" "v2017".no_yes,
  "noschipreason" "v2017".no_health_insurance_reason,
  "vamedicalservices" "v2017".no_yes,
  "novamedreason" "v2017".no_health_insurance_reason,
  "employerprovided" integer,
  "noemployerprovidedreason" "v2017".no_health_insurance_reason,
  "cobra" integer,
  "nocobrareason" "v2017".no_health_insurance_reason,
  "privatepay" "v2017".no_yes,
  "noprivatepayreason" "v2017".no_health_insurance_reason,
  "statehealthinadults" "v2017".no_yes,
  "nostatehealthinsreason" "v2017".no_health_insurance_reason,
  other_insurance "v2017".no_yes,
  other_insurance_identify text,
  "indianhealthservices" "v2017".no_yes,
  "noindianhealthservicesreason" "v2017".no_health_insurance_reason,
  "enrollmentid" uuid,
   information_date timestamp,
  "datacollectionstage" "v2017".datacollectionstage,
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
      references v2017.enrollment ("id") match simple
      on update no action on delete no action
)
with (
  oids=false
);

create table "v2017".exit
(
	"id" uuid not null,  
	"destination" "v2017".destination,
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
		references v2017.enrollment ("id") match simple
		on update no action on delete no action
)
with (
  oids=false
);

---Done--
create table  "v2017".exithousingassessment
(
  "id" uuid not null,
  "exitid" uuid,
  "housingassessment" "v2017".housing_assmnt_exit,
  "subsidyinformation" "v2017".subsidy_information,
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
      references v2017.exit(id) match simple
      on update no action on delete no action
)
with (
  oids=false
);


create table "v2017".exitRHY
(
	"id" uuid not null, 
	"exitid" uuid,
	"project_completion_status" "v2017".project_completion_status,
	"early_exit_reason" "v2017".early_exit_reason,
	exchage_for_sex  "v2017".no_yes,
	exchange_for_sex_past_three_months "v2017".no_yes,
	count_of_exchange_for_sex "v2017".count_of_exchange_for_sex,
	asked_or_forced_to_exchange_for_sex "v2017".no_yes,
	asked_or_forced_to_exchange_for_sex_past_three_months "v2017".no_yes,
	work_place_violence_threats "v2017".no_yes,
	work_place_promise_difference "v2017".no_yes,
	coerced_to_continue_work "v2017".no_yes,
	labor_exploit_past_three_months "v2017".no_yes,
	counseling_received "v2017".no_yes,
	individual_counseling "v2017".no_yes,
	family_counseling "v2017".no_yes,
	group_counseling "v2017".no_yes,
	session_count_at_exit integer,
	sessions_in_plan integer,
	post_exit_counseling_plan "v2017".no_yes,
	destination_safe_client "v2017".no_yes,
	destination_safe_worker "v2017".no_yes,
	pos_adult_connections "v2017".no_yes,
	pos_peer_connections "v2017".no_yes,
	pos_community_connections "v2017".no_yes,
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
		references v2017.exit("id") match simple
		on update no action on delete no action
)
with (
  oids=false
);

create table "v2017".rhyaftercare
(
	"id" uuid not null, 
	after_care_date timestamp,
	after_provided "v2017".no_yes,
	email_social_media "v2017".no_yes,
	telephone "v2017".no_yes,
	in_person_individual "v2017".no_yes,
	in_person_group "v2017".no_yes,
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
		references v2017.exit("id") match simple
		on update no action on delete no action
)
with (
  oids=false
);

create table "v2017".vashexitreason
(
	"id" uuid not null, 
	cm_exit_reason "v2017".cm_exit_reason,
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
		references v2017.exit("id") match simple
		on update no action on delete no action
)
with (
  oids=false
);

create table "v2017".connectionwithsoar
(
	"id" uuid not null, 
	information_date timestamp,
	"connection_with_soar" "v2017".connection_with_soar,
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
		references v2017.exit("id") match simple
		on update no action on delete no action
)
with (
  oids=false
);

create table "v2017".geography
(
	"id" uuid not null, 
	information_date timestamp,
	geo_code varchar(10),
	address1 varchar(100),
	address2 varchar(100),
	city varchar(50),
	state varchar(50),
	zip varchar(15),
	geography_type "v2017".geography_type,
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
		references v2017.coc("id") match simple
		on update no action on delete no action
)
with (
  oids=false
);



-- table: "exitplansactions"

-- drop table "exitplansactions";


create table "v2017".housingassessmentdisposition
(
  "id" uuid not null,
  "assessmentdisposition" "v2017".assessment_disposition,
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
      references v2017."exit" ("id") match simple
      on update no action on delete no action
)
with (
  oids=false
);


CREATE SEQUENCE "v2017".bulk_upload_id_seq START 1;

create table "v2017".bulk_upload_activity
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
      REFERENCES v2017.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT bulk_upload_activity_pk PRIMARY KEY ("id")
);


DROP TABLE IF EXISTS v2017.bulk_upload_error;

CREATE TABLE v2017.bulk_upload_error
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

 --DROP SEQUENCE v2017.error_sequence IF EXISTS;

CREATE SEQUENCE v2017.error_sequence
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;

  
  CREATE TABLE "v2017".sync
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



CREATE TABLE "v2017"."question" (
"id" uuid NOT NULL,
"question_description" character varying(256),
"display_text" character varying(256) ,
"question_data_type" character varying(256) ,
"question_type" character varying(256) ,
"created_at" timestamp,
"updated_at" timestamp,
"user_id" character varying(256),
"is_active" BOOLEAN,
"picklist_group_name" character varying(256),
"deleted" BOOLEAN DEFAULT false,
"hud_question_id" character varying(32),
"update_url_template" character varying(512),
PRIMARY KEY ("id")
)
WITH (OIDS=FALSE)
;




ALTER TABLE v2017.enrollment 
DROP COLUMN dateToStreetESSH;

ALTER TABLE v2017.enrollment
add COLUMN dateToStreetESSH  timestamp;

ALTER TABLE v2017.inventory
add column projectid uuid; 

ALTER TABLE inventory 
ADD CONSTRAINT inventory_project_fk FOREIGN KEY (projectid) REFERENCES v2017.project (id);

