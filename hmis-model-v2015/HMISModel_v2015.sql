DROP SCHEMA IF EXISTS "v2015" cascade;
CREATE SCHEMA "v2015";
DROP SEQUENCE IF EXISTS "v2015".bulk_upload_id_seq;
DROP SEQUENCE IF EXISTS "v2015".bulk_upload_activity_id_seq;
DROP TABLE IF EXISTS "v2015".hmis_type;
DROP TABLE IF EXISTS "v2014".path_status;
DROP TABLE IF EXISTS "v2015".rhybcp_status;
DROP TABLE IF EXISTS "v2015".employment;
DROP TABLE IF EXISTS "v2015".health_status;
DROP TABLE IF EXISTS "v2015".affiliation;
DROP TABLE IF EXISTS "v2015".site;
DROP TABLE IF EXISTS "v2015".inventory;
DROP TABLE IF EXISTS "v2015".funder;	
DROP TABLE IF EXISTS "v2015".enrollment_coc;
DROP TABLE IF EXISTS "v2015".medicalassistance;
DROP TABLE IF EXISTS "v2015".domesticviolence;
DROP TABLE IF EXISTS "v2015".disabilities;
DROP TABLE IF EXISTS "v2015".residentialmoveindate;
DROP TABLE IF EXISTS "v2015".dateofengagement;
DROP TABLE IF EXISTS "v2015".incomeandsources;
DROP TABLE IF EXISTS "v2015".noncashbenefits;
DROP TABLE IF EXISTS "v2015".healthinsurance;
DROP TABLE IF EXISTS "v2015".exithousingassessment;
DROP TABLE IF EXISTS "v2015".housingassessmentdisposition;
DROP TABLE IF EXISTS "v2015".exit;
DROP TABLE IF EXISTS "v2015".bedinventory;
DROP TABLE IF EXISTS "v2015".coc;
DROP TABLE IF EXISTS "v2015".project; 
DROP TABLE IF EXISTS "v2015".enrollment;
DROP TABLE IF EXISTS "v2015".organization; 
DROP TABLE IF  EXISTS "v2015".sync;
DROP TABLE IF EXISTS "v2015".client_veteran_info;
-- DROP TABLE IF EXISTS "v2015".client;
DROP TABLE IF EXISTS "v2015".bulk_upload;
DROP TABLE IF EXISTS "v2015".bulk_upload_activity;
DROP TABLE IF EXISTS "v2015".export; 
DROP TABLE IF EXISTS "v2015".source;
DROP TABLE IF EXISTS v2015.exitRHY;
DROP TABLE IF EXISTS v2015.exitPath;
-- Table: "v2015"."client"


DROP TYPE IF EXISTS "v2015".name_data_quality;
DROP TYPE IF EXISTS "v2015".dob_data_quality;
DROP TYPE IF EXISTS "v2015".ssn_data_quality;
DROP TYPE IF EXISTS "v2015".address_data_quality;
DROP TYPE IF EXISTS "v2015".veteran_status;
DROP TYPE IF EXISTS "v2015".race;
DROP TYPE IF EXISTS "v2015".gender;
DROP TYPE IF EXISTS "v2015".ethnicity;
DROP TYPE IF EXISTS "v2015".afghanistanoef;
DROP TYPE IF EXISTS "v2015".desertstorm;
DROP TYPE IF EXISTS "v2015".asked_forced_exchange_sex;
DROP TYPE IF EXISTS "v2015".assessment_disposition;
DROP TYPE IF EXISTS "v2015".availability;
DROP TYPE IF EXISTS "v2015".bed_type;
DROP TYPE IF EXISTS "v2015".count_of_exchange_sex;
DROP TYPE IF EXISTS "v2015".destination;
DROP TYPE IF EXISTS "v2015".disability_type;
DROP TYPE IF EXISTS "v2015".discharge_status;
DROP TYPE IF EXISTS "v2015".early_exit_reason;
DROP TYPE IF EXISTS "v2015".employment_type;
DROP TYPE IF EXISTS "v2015".federal_partner_components;
DROP TYPE IF EXISTS "v2015".five_val_dk_refused;
DROP TYPE IF EXISTS "v2015".fysb_rsn_not_providing_srvcs;
DROP TYPE IF EXISTS "v2015".health_category;
DROP TYPE IF EXISTS "v2015".health_status_type;
DROP TYPE IF EXISTS "v2015".house_hold_type;
DROP TYPE IF EXISTS "v2015".housing_assmnt_exit;
DROP TYPE IF EXISTS "v2015".homeless_atrisk_status;
DROP TYPE IF EXISTS "v2015".incarcerated_parent_status;	
DROP TYPE IF EXISTS "v2015".issues_number_of_years;
DROP TYPE IF EXISTS "v2015".last_grade_completed;
DROP TYPE IF EXISTS "v2015".military_branch;
DROP TYPE IF EXISTS "v2015".months_homeless_past_3_years;
DROP TYPE IF EXISTS "v2015".no_adap_reason;
DROP TYPE IF EXISTS "v2015".no_health_insurance_reason;
DROP TYPE IF EXISTS "v2015".no_medical_assistance_reason;
DROP TYPE IF EXISTS "v2015".not_employed_reason;
DROP TYPE IF EXISTS "v2015".no_yes;
DROP TYPE IF EXISTS "v2015".no_yes_refused;
DROP TYPE IF EXISTS "v2015".path_how_confirmed;	
DROP TYPE IF EXISTS "v2015".path_smi_info_how_confirmed;
DROP TYPE IF EXISTS "v2015".percentage_ami;
DROP TYPE IF EXISTS "v2015".project_completion_status;
DROP TYPE IF EXISTS "v2015".project_type;
DROP TYPE IF EXISTS "v2015".reason_not_enrolled;	
DROP TYPE IF EXISTS "v2015".record_type;
DROP TYPE IF EXISTS "v2015".referral_outcome;
DROP TYPE IF EXISTS "v2015".referral_source;
DROP TYPE IF EXISTS "v2015".relationship_to_head_of_household;
DROP TYPE IF EXISTS "v2015".residence_prior ;
DROP TYPE IF EXISTS "v2015".residence_prior_length_of_stay;
DROP TYPE IF EXISTS "v2015".school_status;
DROP TYPE IF EXISTS "v2015".sexual_orientation;	
DROP TYPE IF EXISTS "v2015".subsidy_information;
DROP TYPE IF EXISTS "v2015".target_population_type;
DROP TYPE IF EXISTS "v2015".times_homeless_past_3_years;
DROP TYPE IF EXISTS "v2015".tracking_method;
DROP TYPE IF EXISTS "v2015".when_dom_violence_occurred;
DROP TYPE IF EXISTS "v2015".youth_age_group;
DROP TYPE IF EXISTS "v2015".housing_status;
DROP TYPE IF EXISTS "v2015".state;



CREATE TYPE "v2015".name_data_quality AS ENUM ('1', '2', '8','9','99');
CREATE TYPE "v2015".dob_data_quality AS ENUM ('1', '2', '8','9','99');
CREATE TYPE "v2015".ssn_data_quality AS ENUM ('1', '2', '8','9','99');
CREATE TYPE "v2015".address_data_quality AS ENUM ('1', '2', '8','9','99');

CREATE TYPE "v2015".veteran_status AS ENUM ('0', '1', '8','9','99');
CREATE TYPE "v2015".race AS ENUM ('1', '2','3','4','5','8','9','99');
CREATE TYPE "v2015".gender AS ENUM ('1', '2','3','4','8','9','99');
CREATE TYPE "v2015".ethnicity AS ENUM ('0', '1', '8','9','99');
CREATE TYPE "v2015".afghanistanoef AS ENUM ('0', '1', '8','9','99');
CREATE TYPE "v2015".desertstorm AS ENUM ('0', '1', '8','9','99');
CREATE TYPE "v2015".asked_forced_exchange_sex AS ENUM ('0', '1', '8','9','99');
CREATE TYPE "v2015".assessment_disposition AS ENUM ('1','2','3','4','5','6','7','8','9','10','11','12','13','14');
CREATE TYPE "v2015".availability AS ENUM ('1', '2', '3');
CREATE TYPE "v2015".bed_type AS ENUM ('1', '2', '3');
CREATE TYPE "v2015".count_of_exchange_sex AS ENUM ('1', '2', '3','4','8','9');
CREATE TYPE "v2015".destination AS ENUM 
('24','1','15','6','14','7','25','26','27','11','21','3','16','4','10','19','28','20','29','18','22','12','23','13','5','2','17','30','8','9','99');
CREATE TYPE "v2015".disability_type AS ENUM ('5','6','7','8','9','10');
CREATE TYPE "v2015".discharge_status AS ENUM ('1','2','4','5','6','7','8','9','99');
CREATE TYPE "v2015".early_exit_reason AS ENUM ('1','2','3','4','5','99');
CREATE TYPE "v2015".employment_type AS ENUM ('1','2','3','99');
CREATE TYPE "v2015".federal_partner_components AS ENUM 
('1','2','3','4','5','6','7','8','9','10','11','12','13','14','15','16','17','18','19','20','21','22','23','24','25','26','27','28','29','30','31','32','33','34');
CREATE TYPE "v2015".five_val_dk_refused AS ENUM ('0','1','8','9','99');
CREATE TYPE "v2015".fysb_rsn_not_providing_srvcs AS ENUM ('1','2','3','4','99');
CREATE TYPE "v2015".health_category AS ENUM ('27','28','29');
CREATE TYPE "v2015".health_status_type AS ENUM ('1', '2','3','4','5','8','9','99');
CREATE TYPE "v2015".house_hold_type AS ENUM ('1','3','5');
CREATE TYPE "v2015".housing_assmnt_exit AS ENUM ('1','2','3','4','5','6','7','8','9','10','99');
CREATE TYPE "v2015".homeless_atrisk_status AS ENUM ('1','2','3','4','5','6','8','9','99');

CREATE TYPE "v2015".incarcerated_parent_status AS ENUM ('1','2','3','99');	
CREATE TYPE "v2015".issues_number_of_years AS ENUM ('1','2','3');
CREATE TYPE "v2015".last_grade_completed  AS ENUM ('1','2','3','4','5','6','7','10','8','9','99');
CREATE TYPE "v2015".military_branch AS ENUM ('1','2','3','4','6','8','9','99');
CREATE TYPE "v2015".months_homeless_past_3_years AS ENUM ('100','7','8','9','99');
CREATE TYPE "v2015".no_adap_reason AS ENUM ('1','2','3','4','8','9','99');
CREATE TYPE "v2015".no_health_insurance_reason AS ENUM ('1','2','3','4','8','9','99');
CREATE TYPE "v2015".no_medical_assistance_reason AS ENUM (	
'1',
'2',
'3',
'4',
'8',
'9',
'99');
CREATE TYPE "v2015".not_employed_reason  AS ENUM (	
'1',
'2',
'3',
'99');
CREATE TYPE "v2015".no_yes  AS ENUM (	
'0',
'1',
'99');
CREATE TYPE "v2015".no_yes_refused AS ENUM (
'0',
'1',
'9',
'99');
CREATE TYPE "v2015".path_how_confirmed AS ENUM (	
'1',
'2',
'3',
'99');
CREATE TYPE "v2015".path_smi_info_how_confirmed AS ENUM (	
'0',
'1',
'2',
'3',
'8',
'9',
'99');
CREATE TYPE "v2015".percentage_ami AS ENUM (	
'1',
'2',
'3',
'99');

CREATE TYPE "v2015".project_completion_status AS ENUM (	
'1',
'2',
'3',
'99');

CREATE TYPE "v2015".project_type AS ENUM (
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
CREATE TYPE "v2015".reason_not_enrolled AS ENUM (	
'1',
'2',
'99');
CREATE TYPE "v2015".record_type AS ENUM (	
'12',
'14',
'15',
'16',
'141',
'142',
'143',
'144',
'151',
'152',
'161',
'162',
'200');

CREATE TYPE "v2015".referral_outcome AS ENUM (	
'1',
'2',
'3');
CREATE TYPE "v2015".referral_source AS ENUM (	
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

CREATE TYPE "v2015".relationship_to_head_of_household AS ENUM (
'1',
'2',
'3',
'4',
'5');
CREATE TYPE "v2015".residence_prior  AS ENUM (	
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

CREATE TYPE "v2015".residence_prior_length_of_stay AS ENUM (	
'2',
'3',
'4',
'5',
'8',
'9',
'10',
'11',
'99');
CREATE TYPE "v2015".school_status AS ENUM (	
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
CREATE TYPE "v2015".sexual_orientation AS ENUM (	
'1',
'2',
'3',
'4',
'5',
'8',
'9',
'99');
CREATE TYPE "v2015".subsidy_information  AS ENUM (
'1',
'2',
'3',
'4');
CREATE TYPE "v2015".target_population_type  AS ENUM ( 	
'1',
'3',
'4');

CREATE TYPE "v2015".times_homeless_past_3_years  AS ENUM (
'0',
'1',
'2',
'3',
'4',
'8',
'9',
'99');

CREATE TYPE "v2015".tracking_method  AS ENUM ( 	
'0',
'3');
CREATE TYPE "v2015".when_dom_violence_occurred AS ENUM (
'1',
'2',
'3',
'4',
'8',
'9',
'99');
CREATE TYPE "v2015".youth_age_group  AS ENUM (	
'1',
'2',
'3');

CREATE TYPE "v2015".housing_status AS ENUM (
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

CREATE TYPE "v2015".state AS ENUM (
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

CREATE TABLE "v2015".hmis_type
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

INSERT INTO "v2015".hmis_type (name,value,description,status) values ('world_war_2','0','No','ACTIVE');
INSERT INTO "v2015".hmis_type (name,value,description,status) values ('world_war_2','1','Yes','ACTIVE');
INSERT INTO "v2015".hmis_type (name,value,description,status) values ('world_war_2','8','Client doesn''t know','ACTIVE');
INSERT INTO "v2015".hmis_type (name,value,description,status) values ('world_war_2','9','Client refused','ACTIVE');
INSERT INTO "v2015".hmis_type (name,value,description,status) values ('world_war_2','99','Data not collected','ACTIVE');

INSERT INTO "v2015".hmis_type (name,value,description,status) values ('korean_war','0','No','ACTIVE');
INSERT INTO "v2015".hmis_type (name,value,description,status) values ('korean_war','1','Yes','ACTIVE');
INSERT INTO "v2015".hmis_type (name,value,description,status) values ('korean_war','8','Client doesn''t know','ACTIVE');
INSERT INTO "v2015".hmis_type (name,value,description,status) values ('korean_war','9','Client refused','ACTIVE');
INSERT INTO "v2015".hmis_type (name,value,description,status) values ('korean_war','99','Data not collected','ACTIVE');

INSERT INTO "v2015".hmis_type (name,value,description,status) values ('vietnam_war','0','No','ACTIVE');
INSERT INTO "v2015".hmis_type (name,value,description,status) values ('vietnam_war','1','Yes','ACTIVE');
INSERT INTO "v2015".hmis_type (name,value,description,status) values ('vietnam_war','8','Client doesn''t know','ACTIVE');
INSERT INTO "v2015".hmis_type (name,value,description,status) values ('vietnam_war','9','Client refused','ACTIVE');
INSERT INTO "v2015".hmis_type (name,value,description,status) values ('vietnam_war','99','Data not collected','ACTIVE');

INSERT INTO "v2015".hmis_type (name,value,description,status) values ('desertstorm','0','No','ACTIVE');
INSERT INTO "v2015".hmis_type (name,value,description,status) values ('desertstorm','1','Yes','ACTIVE');
INSERT INTO "v2015".hmis_type (name,value,description,status) values ('desertstorm','8','Client doesn''t know','ACTIVE');
INSERT INTO "v2015".hmis_type (name,value,description,status) values ('desertstorm','9','Client refused','ACTIVE');
INSERT INTO "v2015".hmis_type (name,value,description,status) values ('desertstorm','99','Data not collected','ACTIVE');

INSERT INTO "v2015".hmis_type (name,value,description,status) values ('iraq_oif','0','No','ACTIVE');
INSERT INTO "v2015".hmis_type (name,value,description,status) values ('iraq_oif','1','Yes','ACTIVE');
INSERT INTO "v2015".hmis_type (name,value,description,status) values ('iraq_oif','8','Client doesn''t know','ACTIVE');
INSERT INTO "v2015".hmis_type (name,value,description,status) values ('iraq_oif','9','Client refused','ACTIVE');
INSERT INTO "v2015".hmis_type (name,value,description,status) values ('iraq_oif','99','Data not collected','ACTIVE');

INSERT INTO "v2015".hmis_type (name,value,description,status) values ('iraq_ond','0','No','ACTIVE');
INSERT INTO "v2015".hmis_type (name,value,description,status) values ('iraq_ond','1','Yes','ACTIVE');
INSERT INTO "v2015".hmis_type (name,value,description,status) values ('iraq_ond','8','Client doesn''t know','ACTIVE');
INSERT INTO "v2015".hmis_type (name,value,description,status) values ('iraq_ond','9','Client refused','ACTIVE');
INSERT INTO "v2015".hmis_type (name,value,description,status) values ('iraq_ond','99','Data not collected','ACTIVE');

INSERT INTO "v2015".hmis_type (name,value,description,status) values ('other_theater','0','No','ACTIVE');
INSERT INTO "v2015".hmis_type (name,value,description,status) values ('other_theater','1','Yes','ACTIVE');
INSERT INTO "v2015".hmis_type (name,value,description,status) values ('other_theater','8','Client doesn''t know','ACTIVE');
INSERT INTO "v2015".hmis_type (name,value,description,status) values ('other_theater','9','Client refused','ACTIVE');
INSERT INTO "v2015".hmis_type (name,value,description,status) values ('other_theater','99','Data not collected','ACTIVE');

INSERT INTO "v2015".hmis_type (name,value,description,status) values ('employed','0','No','ACTIVE');
INSERT INTO "v2015".hmis_type (name,value,description,status) values ('employed','1','Yes','ACTIVE');
INSERT INTO "v2015".hmis_type (name,value,description,status) values ('employed','8','Client doesn''t know','ACTIVE');
INSERT INTO "v2015".hmis_type (name,value,description,status) values ('employed','9','Client refused','ACTIVE');
INSERT INTO "v2015".hmis_type (name,value,description,status) values ('employed','99','Data not collected','ACTIVE');


   
  
INSERT INTO "v2015".hmis_type (name,value,description,status) values ('address_data_quality','1','Full address reported','ACTIVE');
INSERT INTO "v2015".hmis_type (name,value,description,status) values ('address_data_quality','2','Incomplete or estimated address reported','ACTIVE');
INSERT INTO "v2015".hmis_type (name,value,description,status) values ('address_data_quality','8','Client doesn''t know','ACTIVE');
INSERT INTO "v2015".hmis_type (name,value,description,status) values ('address_data_quality','9','Client refused','ACTIVE');
INSERT INTO "v2015".hmis_type (name,value,description,status) values ('address_data_quality','99','Data not collected','ACTIVE');

INSERT INTO "v2015".hmis_type (name,value,description,status) values ('askedorforcedtoexchangeforsex','0','No','ACTIVE');
INSERT INTO "v2015".hmis_type (name,value,description,status) values ('askedorforcedtoexchangeforsex','1','Yes','ACTIVE');
INSERT INTO "v2015".hmis_type (name,value,description,status) values ('askedorforcedtoexchangeforsex','8','Client doesn''t know','ACTIVE');
INSERT INTO "v2015".hmis_type (name,value,description,status) values ('askedorforcedtoexchangeforsex','9','Client refused','ACTIVE');
INSERT INTO "v2015".hmis_type (name,value,description,status) values ('askedorforcedtoexchangeforsex','99','Data not collected','ACTIVE');

INSERT INTO "v2015".hmis_type (name,status,value,description) values ('assessmentdisposition','ACTIVE','1',  'Referred to emergency shelter/safe haven');
INSERT INTO "v2015".hmis_type (name,status,value,description) values ('assessmentdisposition','ACTIVE','2', 'Referred to transitional housing');
INSERT INTO "v2015".hmis_type (name,status,value,description) values ('assessmentdisposition','ACTIVE','3', 'Referred to rapid re-housing');
INSERT INTO "v2015".hmis_type (name,status,value,description) values ('assessmentdisposition','ACTIVE','4', 'Referred to permanent supportive housing');
INSERT INTO "v2015".hmis_type (name,status,value,description) values ('assessmentdisposition','ACTIVE','5', 'Referred to homelessness prevention');
INSERT INTO "v2015".hmis_type (name,status,value,description) values ('assessmentdisposition','ACTIVE','6', 'Referred to street outreach');
INSERT INTO "v2015".hmis_type (name,status,value,description) values ('assessmentdisposition','ACTIVE','7', 'Referred to other continuum project type');
INSERT INTO "v2015".hmis_type (name,status,value,description) values ('assessmentdisposition','ACTIVE','8', 'Referred to a homelessness diversion program');
INSERT INTO "v2015".hmis_type (name,status,value,description) values ('assessmentdisposition','ACTIVE','9', 'Unable to refer/accept within continuum; ineligible for continuum projects');
INSERT INTO "v2015".hmis_type (name,status,value,description) values ('assessmentdisposition','ACTIVE','10','Unable to refer/accept within continuum; continuum services unavailable');
INSERT INTO "v2015".hmis_type (name,status,value,description) values ('assessmentdisposition','ACTIVE','11','Referred to other community project (non-continuum)');
INSERT INTO "v2015".hmis_type (name,status,value,description) values ('assessmentdisposition','ACTIVE','12','Applicant declined referral/acceptance');
INSERT INTO "v2015".hmis_type (name,status,value,description) values ('assessmentdisposition','ACTIVE','13','Applicant terminated assessment prior to completion');
INSERT INTO "v2015".hmis_type (name,status,value,description) values ('assessmentdisposition','ACTIVE','14','Other/specify');

INSERT INTO "v2015".hmis_type (name,status,value,description) values ('availabilty','ACTIVE','1','Year-round');
INSERT INTO "v2015".hmis_type (name,status,value,description) values ('availabilty','ACTIVE','2','Seasonal');
INSERT INTO "v2015".hmis_type (name,status,value,description) values ('availabilty','ACTIVE','3','Overflow');

INSERT INTO "v2015".hmis_type (name,status,value,description) values ('bedtype','ACTIVE','1','Facility-based');
INSERT INTO "v2015".hmis_type (name,status,value,description) values ('bedtype','ACTIVE','2','Voucher');
INSERT INTO "v2015".hmis_type (name,status,value,description) values ('bedtype','ACTIVE','3','Other');

INSERT INTO "v2015".hmis_type (name,status,value,description) values ('countofexchangeforsex','ACTIVE','1','1-3');
INSERT INTO "v2015".hmis_type (name,status,value,description) values ('countofexchangeforsex','ACTIVE','2','4-7');
INSERT INTO "v2015".hmis_type (name,status,value,description) values ('countofexchangeforsex','ACTIVE','3','8-30');
INSERT INTO "v2015".hmis_type (name,status,value,description) values ('countofexchangeforsex','ACTIVE','4','More than 30');
INSERT INTO "v2015".hmis_type (name,value,description,status) values ('countofexchangeforsex','8','Client doesn''t know','ACTIVE');
INSERT INTO "v2015".hmis_type (name,value,description,status) values ('countofexchangeforsex','9','Client refused','ACTIVE');

INSERT INTO "v2015".hmis_type (name,status,value,description) values ('disabilitytype','ACTIVE','5','Physical Disability');
INSERT INTO "v2015".hmis_type (name,status,value,description) values ('disabilitytype','ACTIVE','6','Developmental Disability');
INSERT INTO "v2015".hmis_type (name,status,value,description) values ('disabilitytype','ACTIVE','7','Chronic Health Condition');
INSERT INTO "v2015".hmis_type (name,status,value,description) values ('disabilitytype','ACTIVE','8','HIV/AIDS');
INSERT INTO "v2015".hmis_type (name,status,value,description) values ('disabilitytype','ACTIVE','9','Mental Health Problem');
INSERT INTO "v2015".hmis_type (name,status,value,description) values ('disabilitytype','ACTIVE','10','Substance Abuse');

INSERT INTO "v2015".hmis_type (name,status,value,description) values ('discharge_status','ACTIVE','1','Honorable');
INSERT INTO "v2015".hmis_type (name,status,value,description) values ('discharge_status','ACTIVE','2','General under honorable conditions');
INSERT INTO "v2015".hmis_type (name,status,value,description) values ('discharge_status','ACTIVE','4','Bad conduct');
INSERT INTO "v2015".hmis_type (name,status,value,description) values ('discharge_status','ACTIVE','5','Dishonorable');
INSERT INTO "v2015".hmis_type (name,status,value,description) values ('discharge_status','ACTIVE','6','Under other than honorable conditions (OTH)');
INSERT INTO "v2015".hmis_type (name,status,value,description) values ('discharge_status','ACTIVE','7','Uncharacterized');
INSERT INTO "v2015".hmis_type (name,value,description,status) values ('discharge_status','8','Client doesn''t know','ACTIVE');
INSERT INTO "v2015".hmis_type (name,value,description,status) values ('discharge_status','9','Client refused','ACTIVE');
INSERT INTO "v2015".hmis_type (name,value,description,status) values ('discharge_status','99','Data not collected','ACTIVE');

INSERT INTO "v2015".hmis_type (name,value,description,status) values ('dob_data_quality','1','Full DOB reported','ACTIVE');
INSERT INTO "v2015".hmis_type (name,value,description,status) values ('dob_data_quality','2','Approximate or partial DOB reported','ACTIVE');
INSERT INTO "v2015".hmis_type (name,value,description,status) values ('dob_data_quality','8','Client doesn''t know','ACTIVE');
INSERT INTO "v2015".hmis_type (name,value,description,status) values ('dob_data_quality','9','Client refused','ACTIVE');
INSERT INTO "v2015".hmis_type (name,value,description,status) values ('dob_data_quality','99','Data not collected','ACTIVE');


INSERT INTO "v2015".hmis_type (name,status,value,description) values ('earlyexitreason','ACTIVE','1','Left for other opportunities – Independent living');
INSERT INTO "v2015".hmis_type (name,status,value,description) values ('earlyexitreason','ACTIVE','2','Left for other opportunities - Education');
INSERT INTO "v2015".hmis_type (name,status,value,description) values ('earlyexitreason','ACTIVE','3','Left for other opportunities - Military');
INSERT INTO "v2015".hmis_type (name,status,value,description) values ('earlyexitreason','ACTIVE','4','Left for other opportunities - Other');
INSERT INTO "v2015".hmis_type (name,status,value,description) values ('earlyexitreason','ACTIVE','5','Needs could not be met by project');
INSERT INTO "v2015".hmis_type (name,status,value,description) values ('earlyexitreason','ACTIVE','99','Data not collected');

 
 INSERT INTO "v2015".hmis_type (name,status,value,description) values ('employment_type','ACTIVE','1','Full-time');
 INSERT INTO "v2015".hmis_type (name,status,value,description) values ('employment_type','ACTIVE','2','Part-time');
 INSERT INTO "v2015".hmis_type (name,status,value,description) values ('employment_type','ACTIVE','3','Seasonal / sporadic (including day labor)');
 INSERT INTO "v2015".hmis_type (name,status,value,description) values ('employment_type','ACTIVE','99','Data not collected');
 
 INSERT INTO "v2015".hmis_type (name,value,description,status) values ('ethnicity','0','Non-Hispanic/Non-Latino','ACTIVE');
 INSERT INTO "v2015".hmis_type (name,value,description,status) values ('ethnicity','1','Hispanic/Latino','ACTIVE');
 INSERT INTO "v2015".hmis_type (name,value,description,status) values    ('ethnicity','8','Client does not know','ACTIVE');
 INSERT INTO "v2015".hmis_type  (name,value,description,status) values  ('ethnicity','9','Client refused','ACTIVE');
 INSERT INTO "v2015".hmis_type  (name,value,description,status) values ('ethnicity','99','Data not collected','ACTIVE');

INSERT INTO "v2015".hmis_type (name,status,value,description) values ('destination','ACTIVE','24','Deceased');
INSERT INTO "v2015".hmis_type (name,status,value,description) values ('destination','ACTIVE','1','Emergency shelter, including hotel or motel paid for with emergency shelter voucher');
INSERT INTO "v2015".hmis_type (name,status,value,description) values ('destination','ACTIVE','15','Foster care home or foster care group home');
INSERT INTO "v2015".hmis_type (name,status,value,description) values ('destination','ACTIVE','6','Hospital or other residential non-psychiatric medical facility');
INSERT INTO "v2015".hmis_type (name,status,value,description) values ('destination','ACTIVE','14','Hotel or motel paid for without emergency shelter voucher');
INSERT INTO "v2015".hmis_type (name,status,value,description) values ('destination','ACTIVE','7','Jail, prison or juvenile detention facility');
INSERT INTO "v2015".hmis_type (name,status,value,description) values ('destination','ACTIVE','25','Long-term care facility or nursing home');	
INSERT INTO "v2015".hmis_type (name,status,value,description) values ('destination','ACTIVE','26','Moved from one HOPWA funded project to HOPWA PH ');   
INSERT INTO "v2015".hmis_type (name,status,value,description) values ('destination','ACTIVE','27','Moved from one HOPWA funded project to HOPWA TH');
INSERT INTO "v2015".hmis_type (name,status,value,description) values ('destination','ACTIVE','11','Owned by client, no ongoing housing subsidy');
INSERT INTO "v2015".hmis_type (name,status,value,description) values ('destination','ACTIVE','21','Owned by client, with ongoing housing subsidy');
INSERT INTO "v2015".hmis_type (name,status,value,description) values ('destination','ACTIVE','3','Permanent housing for formerly homeless persons (such as: CoC project; or HUD legacy programs; or HOPWA PH)');
INSERT INTO "v2015".hmis_type (name,status,value,description) values ('destination','ACTIVE','16','Place not meant for habitation (e.g., a vehicle, an abandoned building, bus/train/subway station/airport or anywhere outside)');
INSERT INTO "v2015".hmis_type (name,status,value,description) values ('destination','ACTIVE','4','Psychiatric hospital or other psychiatric facility');
INSERT INTO "v2015".hmis_type (name,status,value,description) values ('destination','ACTIVE','10','Rental by client, no ongoing housing subsidy');	
INSERT INTO "v2015".hmis_type (name,status,value,description) values ('destination','ACTIVE','19','Rental by client, with VASH housing subsidy');  
INSERT INTO "v2015".hmis_type (name,status,value,description) values ('destination','ACTIVE','28','Rental by client, with GPD TIP housing subsidy');
INSERT INTO "v2015".hmis_type (name,status,value,description) values ('destination','ACTIVE','20','Rental by client, with other ongoing housing subsidy');
INSERT INTO "v2015".hmis_type (name,status,value,description) values ('destination','ACTIVE','29','Residential project or halfway house with no homeless criteria');
INSERT INTO "v2015".hmis_type (name,status,value,description) values ('destination','ACTIVE','18','Safe Haven');
INSERT INTO "v2015".hmis_type (name,status,value,description) values ('destination','ACTIVE','22','Staying or living with family, permanent tenure');
INSERT INTO "v2015".hmis_type (name,status,value,description) values ('destination','ACTIVE','12','Staying or living with family, temporary tenure (e.g., room, apartment or house)');
INSERT INTO "v2015".hmis_type (name,status,value,description) values ('destination','ACTIVE','23','Staying or living with friends, permanent tenure');	
INSERT INTO "v2015".hmis_type (name,status,value,description) values ('destination','ACTIVE','13','Staying or living with friends, temporary tenure (e.g., room apartment or house)');  
INSERT INTO "v2015".hmis_type (name,status,value,description) values ('destination','ACTIVE','5','Substance abuse treatment facility or detox center ');
INSERT INTO "v2015".hmis_type (name,status,value,description) values ('destination','ACTIVE','2','Transitional housing for homeless persons (including homeless youth)');
INSERT INTO "v2015".hmis_type (name,status,value,description) values ('destination','ACTIVE','17','Other');
INSERT INTO "v2015".hmis_type (name,status,value,description) values ('destination','ACTIVE','30','No exit interview completed');
INSERT INTO "v2015".hmis_type (name,value,description,status) values ('destination','8','Client doesn''t know','ACTIVE');
INSERT INTO "v2015".hmis_type (name,value,description,status) values ('destination','9','Client refused','ACTIVE');   											    
INSERT INTO "v2015".hmis_type (name,value,description,status) values ('destination','99','Data not collected','ACTIVE'); 

 INSERT INTO "v2015".hmis_type (name,status,value,description) values ('funder','ACTIVE','1','HUD:CoC – Homelessness Prevention (High Performing Comm. Only)'); 
 INSERT INTO "v2015".hmis_type (name,status,value,description) values ('funder','ACTIVE','2','HUD:CoC – Permanent Supportive Housing');
 INSERT INTO "v2015".hmis_type (name,status,value,description) values ('funder','ACTIVE','3','HUD:CoC – Rapid Re-Housing');
 INSERT INTO "v2015".hmis_type (name,status,value,description) values ('funder','ACTIVE','4','HUD:CoC – Supportive Services Only');
 INSERT INTO "v2015".hmis_type (name,status,value,description) values ('funder','ACTIVE','5','HUD:CoC – Transitional Housing');
 INSERT INTO "v2015".hmis_type (name,status,value,description) values ('funder','ACTIVE','6','HUD:CoC – Safe Haven');
 INSERT INTO "v2015".hmis_type (name,status,value,description) values ('funder','ACTIVE','7','HUD:CoC – Single Room Occupancy (SRO)');   
 INSERT INTO "v2015".hmis_type (name,status,value,description) values ('funder','ACTIVE','8','HUD:ESG – Emergency Shelter (operating and/or essential services)');  
 INSERT INTO "v2015".hmis_type (name,status,value,description) values ('funder','ACTIVE','9','HUD:ESG – Homelessness Prevention'); 
 INSERT INTO "v2015".hmis_type (name,status,value,description) values ('funder','ACTIVE','10','HUD:ESG – Rapid Rehousing');  
 INSERT INTO "v2015".hmis_type (name,status,value,description) values ('funder','ACTIVE','11','HUD:ESG – Street Outreach');
 INSERT INTO "v2015".hmis_type (name,status,value,description) values ('funder','ACTIVE','12','HUD:Rural Housing Stability Assistance Program');
 INSERT INTO "v2015".hmis_type (name,status,value,description) values ('funder','ACTIVE','13','HUD:HOPWA – Hotel/Motel Vouchers');
 INSERT INTO "v2015".hmis_type (name,status,value,description) values ('funder','ACTIVE','14','HUD:HOPWA – Housing Information');  
 INSERT INTO "v2015".hmis_type (name,status,value,description) values ('funder','ACTIVE','15','HUD:HOPWA – Permanent Housing (facility based or TBRA)');  
 INSERT INTO "v2015".hmis_type (name,status,value,description) values ('funder','ACTIVE','16','HUD:HOPWA – Permanent Housing Placement');  
 INSERT INTO "v2015".hmis_type (name,status,value,description) values ('funder','ACTIVE','17','HUD:HOPWA – Short-Term Rent, Mortgage, Utility assistance'); 
 INSERT INTO "v2015".hmis_type (name,status,value,description) values ('funder','ACTIVE','18','HUD:HOPWA – Short-Term Supportive Facility');
 INSERT INTO "v2015".hmis_type (name,status,value,description) values ('funder','ACTIVE','19','HUD:HOPWA – Transitional Housing (facility based or TBRA)'); 
 INSERT INTO "v2015".hmis_type (name,status,value,description) values ('funder','ACTIVE','20','HUD:HUD/VASH');  
 INSERT INTO "v2015".hmis_type (name,status,value,description) values ('funder','ACTIVE','21','HHS:PATH – Street Outreach and Supportive Services Only');   
 INSERT INTO "v2015".hmis_type (name,status,value,description) values ('funder','ACTIVE','22','HHS:RHY – Basic Center Program (prevention and shelter)');   
 INSERT INTO "v2015".hmis_type (name,status,value,description) values ('funder','ACTIVE','23','HHS:RHY – Maternity Group Home for Pregnant and Parenting Youth');   
 INSERT INTO "v2015".hmis_type (name,status,value,description) values ('funder','ACTIVE','24','HHS:RHY – Transitional Living Program');  
 INSERT INTO "v2015".hmis_type (name,status,value,description) values ('funder','ACTIVE','25','HHS:RHY – Street Outreach Project');
 INSERT INTO "v2015".hmis_type (name,status,value,description) values ('funder','ACTIVE','26','HHS:RHY – Demonstration Project');
 INSERT INTO "v2015".hmis_type (name,status,value,description) values ('funder','ACTIVE','27','VA: Community Contract Emergency Housing');
 INSERT INTO "v2015".hmis_type (name,status,value,description) values ('funder','ACTIVE','28','VA: Community Contract Residential Treatment Program');
 INSERT INTO "v2015".hmis_type (name,status,value,description) values ('funder','ACTIVE','29','VA:Domiciliary Care');
 INSERT INTO "v2015".hmis_type (name,status,value,description) values ('funder','ACTIVE','30','VA:Community Contract Safe Haven Program');
 INSERT INTO "v2015".hmis_type (name,status,value,description) values ('funder','ACTIVE','31','VA:Grant and Per Diem Program');
 INSERT INTO "v2015".hmis_type (name,status,value,description) values ('funder','ACTIVE','32','VA:Compensated Work Therapy Transitional Residence');
 INSERT INTO "v2015".hmis_type (name,status,value,description) values ('funder','ACTIVE','33','VA:Supportive Services for Veteran Families');
 INSERT INTO "v2015".hmis_type (name,status,value,description) values ('funder','ACTIVE','34','N/A');

 INSERT INTO "v2015".hmis_type (name,status,value,description) values ('reason_no_services','ACTIVE','1','Out of age range');
 INSERT INTO "v2015".hmis_type (name,status,value,description) values ('reason_no_services','ACTIVE','2','Ward of the State – Immediate Reunification');
 INSERT INTO "v2015".hmis_type (name,status,value,description) values ('reason_no_services','ACTIVE','3','Ward of the Criminal Justice System – Immediate Reunification');
 INSERT INTO "v2015".hmis_type (name,status,value,description) values ('reason_no_services','ACTIVE','4','Other');
 INSERT INTO "v2015".hmis_type (name,value,description,status) values ('reason_no_services','99','Data not collected','ACTIVE'); 
 INSERT INTO "v2015".hmis_type (name,value,description,status)  values ('gender','1','Male','ACTIVE');
 INSERT INTO "v2015".hmis_type (name,value,description,status)  values ('gender','2','Transgender male to female','ACTIVE');
 INSERT INTO "v2015".hmis_type (name,value,description,status)  values ('gender','3','Transgender female to male','ACTIVE');
 INSERT INTO "v2015".hmis_type (name,value,description,status)  values ('gender','4','Other','ACTIVE');
 INSERT INTO "v2015".hmis_type (name,value,description,status)  values ('gender','8','Client does not know','ACTIVE');
 INSERT INTO "v2015".hmis_type (name,value,description,status)  values ('gender','9','Client refused','ACTIVE');
 INSERT INTO "v2015".hmis_type (name,value,description,status)  values ('gender','99','Data not collected','ACTIVE');
 
  INSERT INTO "v2015".hmis_type (name,status,value,description) values ('health_category','ACTIVE','27','General Health Status');
  INSERT INTO "v2015".hmis_type (name,status,value,description) values ('health_category','ACTIVE','28','Dental Health Status');
  INSERT INTO "v2015".hmis_type (name,status,value,description) values ('health_category','ACTIVE','29','Mental Health Status');
  
   INSERT INTO "v2015".hmis_type (name,status,value,description) values ('health_status','ACTIVE','1','Excellent');
   INSERT INTO "v2015".hmis_type (name,status,value,description) values ('health_status','ACTIVE','2','Very good');
   INSERT INTO "v2015".hmis_type (name,status,value,description) values ('health_status','ACTIVE','3','Good');
   INSERT INTO "v2015".hmis_type (name,status,value,description) values ('health_status','ACTIVE','4','Fair'); 
   INSERT INTO "v2015".hmis_type (name,status,value,description) values ('health_status','ACTIVE','5','Poor');	
    INSERT INTO "v2015".hmis_type (name,value,description,status)  values ('health_status','8','Client does not know','ACTIVE');
    INSERT INTO "v2015".hmis_type (name,value,description,status)  values ('health_status','9','Client refused','ACTIVE');
 INSERT INTO "v2015".hmis_type (name,value,description,status)  values ('health_status','99','Data not collected','ACTIVE');	
	
	
   INSERT INTO "v2015".hmis_type (name,status,value,description) values ('householdtype','ACTIVE','1','Households without children'); 
   INSERT INTO "v2015".hmis_type (name,status,value,description) values ('householdtype','ACTIVE','3','Households with at least one adult and one child'); 
   INSERT INTO "v2015".hmis_type (name,status,value,description) values ('householdtype','ACTIVE','4','Households with only children');

 INSERT INTO "v2015".hmis_type (name,status,value,description) values ('housingassessment','ACTIVE','1','Able to maintain the housing they had at project entry');
 INSERT INTO "v2015".hmis_type (name,status,value,description) values ('housingassessment','ACTIVE','2','Moved to new housing unit');
 INSERT INTO "v2015".hmis_type (name,status,value,description) values ('housingassessment','ACTIVE','3','Moved in with family/friends on a temporary basis');
 INSERT INTO "v2015".hmis_type (name,status,value,description) values ('housingassessment','ACTIVE','4','Moved in with family/friends on a permanent basis ');
 INSERT INTO "v2015".hmis_type (name,status,value,description) values ('housingassessment','ACTIVE','5','Moved to a transitional or temporary housing facility or program');
 INSERT INTO "v2015".hmis_type (name,status,value,description) values ('housingassessment','ACTIVE','6','Client became homeless – moving to a shelter or other place unfit for human habitation');
 INSERT INTO "v2015".hmis_type (name,status,value,description) values ('housingassessment','ACTIVE','7','Client went to jail/prison');
 INSERT INTO "v2015".hmis_type (name,status,value,description) values ('housingassessment','ACTIVE','10','Client died ');
    INSERT INTO "v2015".hmis_type (name,value,description,status)  values ('housingassessment','8','Client does not know','ACTIVE');
    INSERT INTO "v2015".hmis_type (name,value,description,status)  values ('housingassessment','9','Client refused','ACTIVE');
 INSERT INTO "v2015".hmis_type (name,value,description,status)  values ('housingassessment','99','Data not collected','ACTIVE');	

INSERT INTO "v2015".hmis_type (name,status,value,description) values ('incarceratedparentstatus','ACTIVE','1','One parent / legal guardian is incarcerated');
INSERT INTO "v2015".hmis_type (name,status,value,description) values ('incarceratedparentstatus','ACTIVE','2','One parent / legal guardian is incarcerated');
INSERT INTO "v2015".hmis_type (name,status,value,description) values ('incarceratedparentstatus','ACTIVE','3','The only parent / legal guardian is incarcerated');
INSERT INTO "v2015".hmis_type (name,value,description,status)  values ('incarceratedparentstatus','99','Data not collected','ACTIVE');	

INSERT INTO "v2015".hmis_type (name,status,value,description) values ('juvenilejusticeyears','ACTIVE','1','Less than one year');
INSERT INTO "v2015".hmis_type (name,status,value,description) values ('juvenilejusticeyears','ACTIVE','2','1 to 2 years');
INSERT INTO "v2015".hmis_type (name,status,value,description) values ('juvenilejusticeyears','ACTIVE','3','3 to 5 or more years');

INSERT INTO "v2015".hmis_type (name,status,value,description) values ('childwelfareyears','ACTIVE','1','Less than one year');
INSERT INTO "v2015".hmis_type (name,status,value,description) values ('childwelfareyears','ACTIVE','2','1 to 2 years');
INSERT INTO "v2015".hmis_type (name,status,value,description) values ('childwelfareyears','ACTIVE','3','3 to 5 or more years');

 
  INSERT INTO "v2015".hmis_type (name,status,value,description) values ('military_branch','ACTIVE','1','Army');
  INSERT INTO "v2015".hmis_type (name,status,value,description) values ('military_branch','ACTIVE','2','Air Force');
  INSERT INTO "v2015".hmis_type (name,status,value,description) values ('military_branch','ACTIVE','3','Navy'); 
  INSERT INTO "v2015".hmis_type (name,status,value,description) values ('military_branch','ACTIVE','4','Marines'); 
  INSERT INTO "v2015".hmis_type (name,status,value,description) values ('military_branch','ACTIVE','6','Coast Guard');
  INSERT INTO "v2015".hmis_type (name,value,description,status)  values ('military_branch','8','Client does not know','ACTIVE');
  INSERT INTO "v2015".hmis_type (name,value,description,status)  values ('military_branch','9','Client refused','ACTIVE');
  INSERT INTO "v2015".hmis_type (name,value,description,status)  values ('military_branch','99','Data not collected','ACTIVE');
  
  INSERT INTO "v2015".hmis_type (name,status,value,description) values ('monthsHomelessPastThreeYears','ACTIVE','100','0 to 12 months (with a leading 1)');
  INSERT INTO "v2015".hmis_type (name,status,value,description) values ('monthsHomelessPastThreeYears','ACTIVE','7','More than 12 months');
    INSERT INTO "v2015".hmis_type (name,value,description,status)  values ('monthsHomelessPastThreeYears','8','Client does not know','ACTIVE');
    INSERT INTO "v2015".hmis_type (name,value,description,status)  values ('monthsHomelessPastThreeYears','9','Client refused','ACTIVE');
    INSERT INTO "v2015".hmis_type (name,value,description,status)  values ('monthsHomelessPastThreeYears','99','Data not collected','ACTIVE');
  
  INSERT INTO "v2015".hmis_type (name,status,value,description) values ('name_data_quality','ACTIVE','1','Full name reported'); 
  INSERT INTO "v2015".hmis_type (name,status,value,description) values ('name_data_quality','ACTIVE','2','Partial, street name, or code name reported');  
    INSERT INTO "v2015".hmis_type (name,value,description,status)  values ('name_data_quality','8','Client does not know','ACTIVE');  
    INSERT INTO "v2015".hmis_type (name,value,description,status)  values ('name_data_quality','9','Client refused','ACTIVE');  
    INSERT INTO "v2015".hmis_type (name,value,description,status)  values ('name_data_quality','99','Data not collected','ACTIVE');  
    
      INSERT INTO "v2015".hmis_type (name,status,value,description) values ('noadapreason','ACTIVE','1','Applied; decision pending');
      INSERT INTO "v2015".hmis_type (name,status,value,description) values ('noadapreason','ACTIVE','2','Applied; client not eligible');
      INSERT INTO "v2015".hmis_type (name,status,value,description) values ('noadapreason','ACTIVE','3','Client did not apply');
      INSERT INTO "v2015".hmis_type (name,status,value,description) values ('noadapreason','ACTIVE','4','Insurance type N/A for this client');
  INSERT INTO "v2015".hmis_type (name,value,description,status)  values ('noadapreason','8','Client does not know','ACTIVE');  
  INSERT INTO "v2015".hmis_type (name,value,description,status)  values ('noadapreason','9','Client refused','ACTIVE');  
  INSERT INTO "v2015".hmis_type (name,value,description,status)  values ('noadapreason','99','Data not collected','ACTIVE');  
    
INSERT INTO "v2015".hmis_type (name,status,value,description) values ('nocobrareason','ACTIVE','1','Applied; decision pending');
INSERT INTO "v2015".hmis_type (name,status,value,description) values ('nocobrareason','ACTIVE','2','Applied; client not eligible');    
INSERT INTO "v2015".hmis_type (name,status,value,description) values ('nocobrareason','ACTIVE','3','Client did not apply');
INSERT INTO "v2015".hmis_type (name,status,value,description) values ('nocobrareason','ACTIVE','4','Insurance type N/A for this client');
INSERT INTO "v2015".hmis_type (name,value,description,status)  values ('nocobrareason','8','Client does not know','ACTIVE'); 
INSERT INTO "v2015".hmis_type (name,value,description,status)  values ('nocobrareason','9','Client refused','ACTIVE');  
INSERT INTO "v2015".hmis_type (name,value,description,status)  values ('nocobrareason','99','Data not collected','ACTIVE');  

INSERT INTO "v2015".hmis_type (name,status,value,description) values ('noemployerprovidedreason','ACTIVE','1','Applied; decision pending');
INSERT INTO "v2015".hmis_type (name,status,value,description) values ('noemployerprovidedreason','ACTIVE','2','Applied; client not eligible');    
INSERT INTO "v2015".hmis_type (name,status,value,description) values ('noemployerprovidedreason','ACTIVE','3','Client did not apply');
INSERT INTO "v2015".hmis_type (name,status,value,description) values ('noemployerprovidedreason','ACTIVE','4','Insurance type N/A for this client');
INSERT INTO "v2015".hmis_type (name,value,description,status)  values ('noemployerprovidedreason','8','Client does not know','ACTIVE'); 
INSERT INTO "v2015".hmis_type (name,value,description,status)  values ('noemployerprovidedreason','9','Client refused','ACTIVE');  
INSERT INTO "v2015".hmis_type (name,value,description,status)  values ('noemployerprovidedreason','99','Data not collected','ACTIVE');  

INSERT INTO "v2015".hmis_type (name,status,value,description) values ('nomedicaidreason','ACTIVE','1','Applied; decision pending');
INSERT INTO "v2015".hmis_type (name,status,value,description) values ('nomedicaidreason','ACTIVE','2','Applied; client not eligible');    
INSERT INTO "v2015".hmis_type (name,status,value,description) values ('nomedicaidreason','ACTIVE','3','Client did not apply');
INSERT INTO "v2015".hmis_type (name,status,value,description) values ('nomedicaidreason','ACTIVE','4','Insurance type N/A for this client');
INSERT INTO "v2015".hmis_type (name,value,description,status)  values ('nomedicaidreason','8','Client does not know','ACTIVE'); 
INSERT INTO "v2015".hmis_type (name,value,description,status)  values ('nomedicaidreason','9','Client refused','ACTIVE');  
INSERT INTO "v2015".hmis_type (name,value,description,status)  values ('nomedicaidreason','99','Data not collected','ACTIVE');  

 INSERT INTO "v2015".hmis_type (name,status,value,description) values ('nomedicarereason','ACTIVE','1','Applied; decision pending');
 INSERT INTO "v2015".hmis_type (name,status,value,description) values ('nomedicarereason','ACTIVE','2','Applied; client not eligible');    
 INSERT INTO "v2015".hmis_type (name,status,value,description) values ('nomedicarereason','ACTIVE','3','Client did not apply');
 INSERT INTO "v2015".hmis_type (name,status,value,description) values ('nomedicarereason','ACTIVE','4','Insurance type N/A for this client');
 INSERT INTO "v2015".hmis_type (name,value,description,status)  values ('nomedicarereason','8','Client does not know','ACTIVE'); 
 INSERT INTO "v2015".hmis_type (name,value,description,status)  values ('nomedicarereason','9','Client refused','ACTIVE');  
 INSERT INTO "v2015".hmis_type (name,value,description,status)  values ('nomedicarereason','99','Data not collected','ACTIVE');  

INSERT INTO "v2015".hmis_type (name,status,value,description) values ('noprivatepayreason','ACTIVE','1','Applied; decision pending');
INSERT INTO "v2015".hmis_type (name,status,value,description) values ('noprivatepayreason','ACTIVE','2','Applied; client not eligible');    
INSERT INTO "v2015".hmis_type (name,status,value,description) values ('noprivatepayreason','ACTIVE','3','Client did not apply');
INSERT INTO "v2015".hmis_type (name,status,value,description) values ('noprivatepayreason','ACTIVE','4','Insurance type N/A for this client');
INSERT INTO "v2015".hmis_type (name,value,description,status)  values ('noprivatepayreason','8','Client does not know','ACTIVE'); 
INSERT INTO "v2015".hmis_type (name,value,description,status)  values ('noprivatepayreason','9','Client refused','ACTIVE');  
INSERT INTO "v2015".hmis_type (name,value,description,status)  values ('noprivatepayreason','99','Data not collected','ACTIVE');  

INSERT INTO "v2015".hmis_type (name,status,value,description) values ('noschipreason','ACTIVE','1','Applied; decision pending');
INSERT INTO "v2015".hmis_type (name,status,value,description) values ('noschipreason','ACTIVE','2','Applied; client not eligible');    
INSERT INTO "v2015".hmis_type (name,status,value,description) values ('noschipreason','ACTIVE','3','Client did not apply');
INSERT INTO "v2015".hmis_type (name,status,value,description) values ('noschipreason','ACTIVE','4','Insurance type N/A for this client');
INSERT INTO "v2015".hmis_type (name,value,description,status)  values ('noschipreason','8','Client does not know','ACTIVE'); 
INSERT INTO "v2015".hmis_type (name,value,description,status)  values ('noschipreason','9','Client refused','ACTIVE');  
INSERT INTO "v2015".hmis_type (name,value,description,status)  values ('noschipreason','99','Data not collected','ACTIVE');  

INSERT INTO "v2015".hmis_type (name,status,value,description) values ('nostatehealthinsreason','ACTIVE','1','Applied; decision pending');
INSERT INTO "v2015".hmis_type (name,status,value,description) values ('nostatehealthinsreason','ACTIVE','2','Applied; client not eligible');    
INSERT INTO "v2015".hmis_type (name,status,value,description) values ('nostatehealthinsreason','ACTIVE','3','Client did not apply');
INSERT INTO "v2015".hmis_type (name,status,value,description) values ('nostatehealthinsreason','ACTIVE','4','Insurance type N/A for this client');
INSERT INTO "v2015".hmis_type (name,value,description,status)  values ('nostatehealthinsreason','8','Client does not know','ACTIVE'); 
INSERT INTO "v2015".hmis_type (name,value,description,status)  values ('nostatehealthinsreason','9','Client refused','ACTIVE');  
INSERT INTO "v2015".hmis_type (name,value,description,status)  values ('nostatehealthinsreason','99','Data not collected','ACTIVE');  


INSERT INTO "v2015".hmis_type (name,status,value,description) values ('novamedreason','ACTIVE','1','Applied; decision pending');
INSERT INTO "v2015".hmis_type (name,status,value,description) values ('novamedreason','ACTIVE','2','Applied; client not eligible');    
INSERT INTO "v2015".hmis_type (name,status,value,description) values ('novamedreason','ACTIVE','3','Client did not apply');
INSERT INTO "v2015".hmis_type (name,status,value,description) values ('novamedreason','ACTIVE','4','Insurance type N/A for this client');
INSERT INTO "v2015".hmis_type (name,value,description,status)  values ('novamedreason','8','Client does not know','ACTIVE'); 
INSERT INTO "v2015".hmis_type (name,value,description,status)  values ('novamedreason','9','Client refused','ACTIVE');  
INSERT INTO "v2015".hmis_type (name,value,description,status)  values ('novamedreason','99','Data not collected','ACTIVE');  

INSERT INTO "v2015".hmis_type (name,status,value,description) values ('nohivaidsassistancereason','ACTIVE','1','Applied; decision pending');
INSERT INTO "v2015".hmis_type (name,status,value,description) values ('nohivaidsassistancereason','ACTIVE','2','Applied; client not eligible');
INSERT INTO "v2015".hmis_type (name,status,value,description) values ('nohivaidsassistancereason','ACTIVE','3','Client did not apply');
INSERT INTO "v2015".hmis_type (name,status,value,description) values ('nohivaidsassistancereason','ACTIVE','4','Insurance type N/A for this client');
INSERT INTO "v2015".hmis_type (name,value,description,status)  values ('nohivaidsassistancereason','8','Client does not know','ACTIVE'); 
INSERT INTO "v2015".hmis_type (name,value,description,status)  values ('nohivaidsassistancereason','9','Client refused','ACTIVE');  
INSERT INTO "v2015".hmis_type (name,value,description,status)  values ('nohivaidsassistancereason','99','Data not collected','ACTIVE');  

INSERT INTO "v2015".hmis_type (name,status,value,description) values ('not_employed_reason','ACTIVE','1','Looking for work');
INSERT INTO "v2015".hmis_type (name,status,value,description) values ('not_employed_reason','ACTIVE','2','Unable to work');
INSERT INTO "v2015".hmis_type (name,status,value,description) values ('not_employed_reason','ACTIVE','3','Not looking for work');
INSERT INTO "v2015".hmis_type (name,value,description,status)  values ('not_employed_reason','99','Data not collected','ACTIVE');  

 INSERT INTO "v2015".hmis_type (name,status,value,description) values ('pathhowconfirmed','ACTIVE','1','Unconfirmed; presumptive or self-report');
 INSERT INTO "v2015".hmis_type (name,status,value,description) values ('pathhowconfirmed','ACTIVE','2','Confirmed through assessment and clinical evaluation'); 
 INSERT INTO "v2015".hmis_type (name,status,value,description) values ('pathhowconfirmed','ACTIVE','3','Confirmed by prior evaluation or clinical records');
INSERT INTO "v2015".hmis_type (name,value,description,status)  values ('pathhowconfirmed','99','Data not collected','ACTIVE');   

INSERT INTO "v2015".hmis_type (name,status,value,description) values ('pathsmiinformation','ACTIVE','0','No');
INSERT INTO "v2015".hmis_type (name,status,value,description) values ('pathsmiinformation','ACTIVE','1','Unconfirmed; presumptive or self-report');
INSERT INTO "v2015".hmis_type (name,status,value,description) values ('pathsmiinformation','ACTIVE','2','Confirmed through assessment and clinical evaluation'); 
INSERT INTO "v2015".hmis_type (name,status,value,description) values ('pathsmiinformation','ACTIVE','3','Confirmed by prior evaluation or clinical records');
INSERT INTO "v2015".hmis_type (name,value,description,status)  values ('pathsmiinformation','8','Client does not know','ACTIVE'); 
INSERT INTO "v2015".hmis_type (name,value,description,status)  values ('pathsmiinformation','9','Client refused','ACTIVE');  
INSERT INTO "v2015".hmis_type (name,value,description,status)  values ('pathsmiinformation','99','Data not collected','ACTIVE');  
 
INSERT INTO "v2015".hmis_type (name,status,value,description) values ('projectcompletionstatus','ACTIVE','1','Completed project');
INSERT INTO "v2015".hmis_type (name,status,value,description) values ('projectcompletionstatus','ACTIVE','2','Youth voluntarily left early'); 
INSERT INTO "v2015".hmis_type (name,status,value,description) values ('projectcompletionstatus','ACTIVE','3','Youth was expelled or otherwise involuntarily discharged from project');
INSERT INTO "v2015".hmis_type (name,value,description,status)  values ('projectcompletionstatus','99','Data not collected','ACTIVE');  

INSERT INTO "v2015".hmis_type (name,value,description,status)  values ('race','1','American Indian or Alaska Native','ACTIVE');
INSERT INTO "v2015".hmis_type (name,value,description,status)  values ('race','2','Asian','ACTIVE');
INSERT INTO "v2015".hmis_type (name,value,description,status)  values ('race','3','Black or African American','ACTIVE');
INSERT INTO "v2015".hmis_type (name,value,description,status)  values ('race','4','Native Hawaiian or Other Pacific Islander','ACTIVE');
INSERT INTO "v2015".hmis_type (name,value,description,status)  values ('race','5','White','ACTIVE');
INSERT INTO "v2015".hmis_type (name,value,description,status)  values ('race','8','Client does not know','ACTIVE');
INSERT INTO "v2015".hmis_type (name,value,description,status)  values ('race','9','Client refused','ACTIVE');
INSERT INTO "v2015".hmis_type (name,value,description,status)  values ('race','99','Data not collected','ACTIVE');	

 INSERT INTO "v2015".hmis_type (name,status,value,description) values ('projecttype','ACTIVE','1','Emergency Shelter'); 
 INSERT INTO "v2015".hmis_type (name,status,value,description) values ('projecttype','ACTIVE','2','Transitional Housing'); 
 INSERT INTO "v2015".hmis_type (name,status,value,description) values ('projecttype','ACTIVE','3','PH - Permanent Supportive Housing (disability required for entry)');
 INSERT INTO "v2015".hmis_type (name,status,value,description) values ('projecttype','ACTIVE','4','Street Outreach'); 
 INSERT INTO "v2015".hmis_type (name,status,value,description) values ('projecttype','ACTIVE','6','Services Only');
 INSERT INTO "v2015".hmis_type (name,status,value,description) values ('projecttype','ACTIVE','7','Other'); 
 INSERT INTO "v2015".hmis_type (name,status,value,description) values ('projecttype','ACTIVE','8','Safe Haven'); 
 INSERT INTO "v2015".hmis_type (name,status,value,description) values ('projecttype','ACTIVE','9','PH – Housing Only');
 INSERT INTO "v2015".hmis_type (name,status,value,description) values ('projecttype','ACTIVE','10','PH – Housing with Services (no disability required for entry)');
 INSERT INTO "v2015".hmis_type (name,status,value,description) values ('projecttype','ACTIVE','11','Day Shelter');
 INSERT INTO "v2015".hmis_type (name,status,value,description) values ('projecttype','ACTIVE','12','Homelessness Prevention'); 
 INSERT INTO "v2015".hmis_type (name,status,value,description) values ('projecttype','ACTIVE','13','PH - Rapid Re-Housing');
 INSERT INTO "v2015".hmis_type (name,status,value,description) values ('projecttype','ACTIVE','14','Coordinated Assessment');
 

 INSERT INTO "v2015".hmis_type (name,status,value,description) values ('reason_not_enrolled','ACTIVE','1','Client was found ineligible for PATH');
 INSERT INTO "v2015".hmis_type (name,status,value,description) values ('reason_not_enrolled','ACTIVE','2','Client was not enrolled for other reason(s)');
  INSERT INTO "v2015".hmis_type (name,value,description,status)  values ('reason_not_enrolled','99','Data not collected','ACTIVE'); 


 INSERT INTO "v2015".hmis_type (name,status,value,description) values ('projecttype','ACTIVE','12','Contact');
 INSERT INTO "v2015".hmis_type (name,status,value,description) values ('projecttype','ACTIVE','14','Services Provided');
 INSERT INTO "v2015".hmis_type (name,status,value,description) values ('projecttype','ACTIVE','15','Financial Assistance');
 INSERT INTO "v2015".hmis_type (name,status,value,description) values ('projecttype','ACTIVE','16','Referrals Provided');
  INSERT INTO "v2015".hmis_type (name,status,value,description) values ('projecttype','ACTIVE','141','PATH service');
  INSERT INTO "v2015".hmis_type (name,status,value,description) values ('projecttype','ACTIVE','142','RHY service');
  INSERT INTO "v2015".hmis_type (name,status,value,description) values ('projecttype','ACTIVE','143','HOPWA service');
  INSERT INTO "v2015".hmis_type (name,status,value,description) values ('projecttype','ACTIVE','144','SSVF service');
  INSERT INTO "v2015".hmis_type (name,status,value,description) values ('projecttype','ACTIVE','151','HOPWA financial assistance');
  INSERT INTO "v2015".hmis_type (name,status,value,description) values ('projecttype','ACTIVE','152','SSVF financial assistance');
  INSERT INTO "v2015".hmis_type (name,status,value,description) values ('projecttype','ACTIVE','161','PATH referral');
  INSERT INTO "v2015".hmis_type (name,status,value,description) values ('projecttype','ACTIVE','162','RHY referral');
  INSERT INTO "v2015".hmis_type (name,status,value,description) values ('projecttype','ACTIVE','200','Bed night');
  
  INSERT INTO "v2015".hmis_type (name,status,value,description) values ('referraloutcome','ACTIVE','1','Attained');
  INSERT INTO "v2015".hmis_type (name,status,value,description) values ('referraloutcome','ACTIVE','2','Not Attained');
  INSERT INTO "v2015".hmis_type (name,status,value,description) values ('referraloutcome','ACTIVE','3','Unkown');
 
 
 INSERT INTO "v2015".hmis_type (name,status,value,description) values ('referralsource','ACTIVE','1','Self-Referral');
 INSERT INTO "v2015".hmis_type (name,status,value,description) values ('referralsource','ACTIVE','2','Individual: Parent/Guardian');
 INSERT INTO "v2015".hmis_type (name,status,value,description) values ('referralsource','ACTIVE','3','Individual: Relative or Friend');
 INSERT INTO "v2015".hmis_type (name,status,value,description) values ('referralsource','ACTIVE','4','Individual: Other Adult or Youth'); 
 INSERT INTO "v2015".hmis_type (name,status,value,description) values ('referralsource','ACTIVE','5','Individual: Partner/Spouse');
 INSERT INTO "v2015".hmis_type (name,status,value,description) values ('referralsource','ACTIVE','6','Individual: Foster Parent');
 INSERT INTO "v2015".hmis_type (name,status,value,description) values ('referralsource','ACTIVE','7','Outreach Project: FYSB');  	
 INSERT INTO "v2015".hmis_type (name,status,value,description) values ('referralsource','ACTIVE','10','Outreach Project: Other');
 INSERT INTO "v2015".hmis_type (name,status,value,description) values ('referralsource','ACTIVE','11','Temporary Shelter: FYSB Basic Center Project');
 INSERT INTO "v2015".hmis_type (name,status,value,description) values ('referralsource','ACTIVE','12','Temporary Shelter: Other Youth Only Emergency Shelter');
 INSERT INTO "v2015".hmis_type (name,status,value,description) values ('referralsource','ACTIVE','13','Temporary Shelter: Emergency Shelter for Families');
 INSERT INTO "v2015".hmis_type (name,status,value,description) values ('referralsource','ACTIVE','14','Temporary Shelter: Emergency Shelter for Individuals');
 INSERT INTO "v2015".hmis_type (name,status,value,description) values ('referralsource','ACTIVE','15','Temporary Shelter: Domestic Violence Shelter');
 INSERT INTO "v2015".hmis_type (name,status,value,description) values ('referralsource','ACTIVE','16','Temporary Shelter: Safe Place');
 INSERT INTO "v2015".hmis_type (name,status,value,description) values ('referralsource','ACTIVE','17','Temporary Shelter: Other');
 INSERT INTO "v2015".hmis_type (name,status,value,description) values ('referralsource','ACTIVE','18','Residential Project: FYSB Transitional Living Project'); 
 INSERT INTO "v2015".hmis_type (name,status,value,description) values ('referralsource','ACTIVE','19','Residential Project: Other Transitional Living Project');
 INSERT INTO "v2015".hmis_type (name,status,value,description) values ('referralsource','ACTIVE','20','Residential Project: Group Home'); 
 INSERT INTO "v2015".hmis_type (name,status,value,description) values ('referralsource','ACTIVE','21','Residential Project: Independent Living Project'); 
 INSERT INTO "v2015".hmis_type (name,status,value,description) values ('referralsource','ACTIVE','22','Residential Project: Job Corps'); 
 INSERT INTO "v2015".hmis_type (name,status,value,description) values ('referralsource','ACTIVE','23','Residential Project: Drug Treatment Center');
 INSERT INTO "v2015".hmis_type (name,status,value,description) values ('referralsource','ACTIVE','24','Residential Project: Treatment Center');
 INSERT INTO "v2015".hmis_type (name,status,value,description) values ('referralsource','ACTIVE','25','Residential Project: Educational Institute'); 
 INSERT INTO "v2015".hmis_type (name,status,value,description) values ('referralsource','ACTIVE','26','Residential Project: Other Agency project'); 
 INSERT INTO "v2015".hmis_type (name,status,value,description) values ('referralsource','ACTIVE','27','Residential Project: Other Project'); 
 INSERT INTO "v2015".hmis_type (name,status,value,description) values ('referralsource','ACTIVE','28','Hotline: National Runaway Switchboard'); 
 INSERT INTO "v2015".hmis_type (name,status,value,description) values ('referralsource','ACTIVE','29','Hotline: Other'); 
 INSERT INTO "v2015".hmis_type (name,status,value,description) values ('referralsource','ACTIVE','30','Other Agency: Child Welfare/CPS'); 
 INSERT INTO "v2015".hmis_type (name,status,value,description) values ('referralsource','ACTIVE','31','Other Agency: Non-Residential Independent Living Project');
 INSERT INTO "v2015".hmis_type (name,status,value,description) values ('referralsource','ACTIVE','32','Other Project Operated by your Agency');
 INSERT INTO "v2015".hmis_type (name,status,value,description) values ('referralsource','ACTIVE','33','Other Youth Services Agency');
 INSERT INTO "v2015".hmis_type (name,status,value,description) values ('referralsource','ACTIVE','34','Juvenile Justice');
 INSERT INTO "v2015".hmis_type (name,status,value,description) values ('referralsource','ACTIVE','35','Law Enforcement/ Police');
 INSERT INTO "v2015".hmis_type (name,status,value,description) values ('referralsource','ACTIVE','36','Religious Organization');
 INSERT INTO "v2015".hmis_type (name,status,value,description) values ('referralsource','ACTIVE','37','Mental Hospital');
 INSERT INTO "v2015".hmis_type (name,status,value,description) values ('referralsource','ACTIVE','38','School');
 INSERT INTO "v2015".hmis_type (name,status,value,description) values ('referralsource','ACTIVE','39','Other Organization');
 INSERT INTO "v2015".hmis_type (name,value,description,status)  values ('referralsource','8','Client does not know','ACTIVE'); 
 INSERT INTO "v2015".hmis_type (name,value,description,status)  values ('referralsource','9','Client refused','ACTIVE');  
 INSERT INTO "v2015".hmis_type (name,value,description,status)  values ('referralsource','99','Data not collected','ACTIVE');  
 
  INSERT INTO "v2015".hmis_type (name,status,value,description) values ('relationshiptohoh','ACTIVE','1','Self (head of household)'); 
  INSERT INTO "v2015".hmis_type (name,status,value,description) values ('relationshiptohoh','ACTIVE','2','Head of household’s child'); 
  INSERT INTO "v2015".hmis_type (name,status,value,description) values ('relationshiptohoh','ACTIVE','3','Head of household’s spouse or partner');
  INSERT INTO "v2015".hmis_type (name,status,value,description) values ('relationshiptohoh','ACTIVE','4','Head of household’s other relation member (other relation to head of household)');
  INSERT INTO "v2015".hmis_type (name,status,value,description) values ('relationshiptohoh','ACTIVE','5','Other: non-relation member');
  
  
   INSERT INTO "v2015".hmis_type (name,status,value,description) values ('residencePrior','ACTIVE','1','Emergency shelter, including hotel or motel paid for with emergency shelter voucher');
   INSERT INTO "v2015".hmis_type (name,status,value,description) values ('residencePrior','ACTIVE','2','Transitional housing for homeless persons (including homeless youth)');
   INSERT INTO "v2015".hmis_type (name,status,value,description) values ('residencePrior','ACTIVE','3','Permanent housing for formerly homeless persons (such as: CoC project; HUD legacy programs; or HOPWA PH)'); 
   INSERT INTO "v2015".hmis_type (name,status,value,description) values ('residencePrior','ACTIVE','4','Psychiatric hospital or other psychiatric facility');
   INSERT INTO "v2015".hmis_type (name,status,value,description) values ('residencePrior','ACTIVE','5','Substance abuse treatment facility or detox center');
   INSERT INTO "v2015".hmis_type (name,status,value,description) values ('residencePrior','ACTIVE','6','Hospital or other residential non-psychiatric medical facility');
   INSERT INTO "v2015".hmis_type (name,status,value,description) values ('residencePrior','ACTIVE','7','Jail, prison or juvenile detention facility'); 
   INSERT INTO "v2015".hmis_type (name,status,value,description) values ('residencePrior','ACTIVE','8','Client does not know');
   INSERT INTO "v2015".hmis_type (name,status,value,description) values ('residencePrior','ACTIVE','9','Client refused'); 
  INSERT INTO "v2015".hmis_type (name,status,value,description) values ('referralsource','ACTIVE','12','Staying or living in a family member’s room, apartment or house');          
  INSERT INTO "v2015".hmis_type (name,status,value,description) values ('referralsource','ACTIVE','13','Staying or living in a friend’s room, apartment or house');
  INSERT INTO "v2015".hmis_type (name,status,value,description) values ('referralsource','ACTIVE','14','Hotel or motel paid for without emergency shelter voucher'); 
  INSERT INTO "v2015".hmis_type (name,status,value,description) values ('referralsource','ACTIVE','15','Foster care home or foster care group home');                         
  INSERT INTO "v2015".hmis_type (name,status,value,description) values ('referralsource','ACTIVE','16','Place not meant for habitation (e.g. a vehicle, an abandoned building, bus/train/subway station/airport or anywhere outside)');
  INSERT INTO "v2015".hmis_type (name,status,value,description) values ('referralsource','ACTIVE','17','Other');
  INSERT INTO "v2015".hmis_type (name,status,value,description) values ('referralsource','ACTIVE','18','Safe Haven');
  INSERT INTO "v2015".hmis_type (name,status,value,description) values ('referralsource','ACTIVE','19','Rental by client, with VASH subsidy');
  INSERT INTO "v2015".hmis_type (name,status,value,description) values ('referralsource','ACTIVE','20','Rental by client, with other ongoing housing subsidy');
  INSERT INTO "v2015".hmis_type (name,status,value,description) values ('referralsource','ACTIVE','21','Owned by client, with ongoing housing subsidy'); 
  INSERT INTO "v2015".hmis_type (name,status,value,description) values ('referralsource','ACTIVE','22','Rental by client, no ongoing housing subsidy');
  INSERT INTO "v2015".hmis_type (name,status,value,description) values ('referralsource','ACTIVE','23','Owned by client, no ongoing housing subsidy'); 
  INSERT INTO "v2015".hmis_type (name,status,value,description) values ('referralsource','ACTIVE','24','Long-term care facility or nursing home');
  INSERT INTO "v2015".hmis_type (name,status,value,description) values ('referralsource','ACTIVE','25','Rental by client, with GPD TIP subsidy');
  INSERT INTO "v2015".hmis_type (name,status,value,description) values ('referralsource','ACTIVE','26','Residential project or halfway house with no homeless criteria');
  INSERT INTO "v2015".hmis_type (name,value,description,status)  values ('referralsource','99','Data not collected','ACTIVE');
  
  
     INSERT INTO "v2015".hmis_type (name,status,value,description) values ('residencePriorlengthofstay','ACTIVE','2','More than one week, but less than one month'); 
     INSERT INTO "v2015".hmis_type (name,status,value,description) values ('residencePriorlengthofstay','ACTIVE','3','One to three months'); 
     INSERT INTO "v2015".hmis_type (name,status,value,description) values ('residencePriorlengthofstay','ACTIVE','4','More than three months, but less than one year');  
     INSERT INTO "v2015".hmis_type (name,status,value,description) values ('residencePriorlengthofstay','ACTIVE','5','One year or longer'); 
     INSERT INTO "v2015".hmis_type (name,status,value,description) values ('residencePriorlengthofstay','ACTIVE','8','Client doesn''t know'); 
     INSERT INTO "v2015".hmis_type (name,status,value,description) values ('residencePriorlengthofstay','ACTIVE','9','Client refused');
    INSERT INTO "v2015".hmis_type (name,status,value,description) values ('residencePriorlengthofstay','ACTIVE','10','One day or less');
    INSERT INTO "v2015".hmis_type (name,status,value,description) values ('residencePriorlengthofstay','ACTIVE','11','Two days to one week'); 
   INSERT INTO "v2015".hmis_type (name,value,description,status)  values ('residencePriorlengthofstay','99','Data not collected','ACTIVE'); 
 
          
        INSERT INTO "v2015".hmis_type (name,value,description,status) values ('ssndataquality','1','Full SSN reported','ACTIVE');
        INSERT INTO "v2015".hmis_type (name,value,description,status) values   ('ssndataquality','2','Approximate or partial SSN reported','ACTIVE');
        INSERT INTO "v2015".hmis_type (name,value,description,status) values    ('ssndataquality','8','Client does not know','ACTIVE');
        INSERT INTO "v2015".hmis_type  (name,value,description,status) values  ('ssndataquality','9','Client refused','ACTIVE');
        INSERT INTO "v2015".hmis_type  (name,value,description,status) values ('ssndataquality','99','Data not collected','ACTIVE');
        
        
        INSERT INTO "v2015".hmis_type (name,status,value,description) values ('subsidyinformation','ACTIVE','1','Without a subsidy');
        INSERT INTO "v2015".hmis_type (name,status,value,description) values ('subsidyinformation','ACTIVE','2','With the subsidy they had at project entry');
   	INSERT INTO "v2015".hmis_type (name,status,value,description) values ('subsidyinformation','ACTIVE','3','With an on-going subsidy acquired since project entry');
   	INSERT INTO "v2015".hmis_type (name,status,value,description) values ('subsidyinformation','ACTIVE','4','Only with financial assistance other than a subsidy'); 
   	
   	INSERT INTO "v2015".hmis_type (name,status,value,description) values ('targetpopulation','ACTIVE','1','DV Domestic Violence victims');
   	INSERT INTO "v2015".hmis_type (name,status,value,description) values ('targetpopulation','ACTIVE','3','HIV Persons with HIV/AIDS');
   	INSERT INTO "v2015".hmis_type (name,status,value,description) values ('targetpopulation','ACTIVE','4','NA Not Applicable');
   	
	
	INSERT INTO "v2015".hmis_type (name,value,description,status) values ('timesHomelesspastthreeyears','0','0 (not homeless - Prevention only)','ACTIVE');
	INSERT INTO "v2015".hmis_type (name,value,description,status) values ('timesHomelesspastthreeyears','1','1 (homeless only this time)','ACTIVE');
	INSERT INTO "v2015".hmis_type (name,value,description,status) values ('timesHomelesspastthreeyears','2','2','ACTIVE');
	INSERT INTO "v2015".hmis_type (name,value,description,status) values ('timesHomelesspastthreeyears','3','3','ACTIVE');
	INSERT INTO "v2015".hmis_type (name,value,description,status) values ('timesHomelesspastthreeyears','4','4 or more','ACTIVE');
	INSERT INTO "v2015".hmis_type (name,value,description,status) values  ('timesHomelesspastthreeyears','8','Client does not know','ACTIVE');
	INSERT INTO "v2015".hmis_type  (name,value,description,status) values  ('timesHomelesspastthreeyears','9','Client refused','ACTIVE');
	INSERT INTO "v2015".hmis_type  (name,value,description,status) values ('timesHomelesspastthreeyears','99','Data not collected','ACTIVE');
		       
	
	INSERT INTO "v2015".hmis_type (name,value,description,status) values ('trackingmethod','0','Entry/Exit Date','ACTIVE');
	INSERT INTO "v2015".hmis_type (name,value,description,status) values ('trackingmethod','3','Night-by-Night','ACTIVE');
	
	
	INSERT INTO "v2015".hmis_type (name,value,description,status) values ('whenoccurred','1','Within the past three months','ACTIVE');
	INSERT INTO "v2015".hmis_type (name,value,description,status) values ('whenoccurred','2','Three to six months ago (excluding six months exactly)','ACTIVE');
	INSERT INTO "v2015".hmis_type (name,value,description,status) values ('whenoccurred','3','Six months to one year ago (excluding one year exactly)','ACTIVE');
	INSERT INTO "v2015".hmis_type (name,value,description,status) values ('whenoccurred','4','One year ago or more','ACTIVE');
	INSERT INTO "v2015".hmis_type (name,value,description,status) values  ('whenoccurred','8','Client does not know','ACTIVE');
	INSERT INTO "v2015".hmis_type  (name,value,description,status) values  ('whenoccurred','9','Client refused','ACTIVE');
	INSERT INTO "v2015".hmis_type  (name,value,description,status) values ('whenoccurred','99','Data not collected','ACTIVE');
	
	
	
	INSERT INTO "v2015".hmis_type (name,value,description,status) values ('housingstatus','1','Category 1 - Homeless','ACTIVE');
	INSERT INTO "v2015".hmis_type (name,value,description,status) values ('housingstatus','2','Category 2 - At imminent risk of losing housing','ACTIVE');
	INSERT INTO "v2015".hmis_type (name,value,description,status) values ('housingstatus','3','At-risk of homelessness','ACTIVE');
	INSERT INTO "v2015".hmis_type (name,value,description,status) values ('housingstatus','4','Stably Housed','ACTIVE');
	INSERT INTO "v2015".hmis_type (name,value,description,status) values ('housingstatus','5','Category 3 - Homeless only under other federal statutes','ACTIVE');
	INSERT INTO "v2015".hmis_type (name,value,description,status) values ('housingstatus','6','Category 4 - Fleeing domestic violence','ACTIVE');
	INSERT INTO "v2015".hmis_type (name,value,description,status) values  ('housingstatus','8','Client does not know','ACTIVE');
	INSERT INTO "v2015".hmis_type  (name,value,description,status) values  ('housingstatus','9','Client refused','ACTIVE');
	INSERT INTO "v2015".hmis_type  (name,value,description,status) values ('housingstatus','99','Data not collected','ACTIVE');
	
	INSERT INTO "v2015".hmis_type (name,value,description,status) values ('youth_age_group','1','Only under age 18','ACTIVE');
	INSERT INTO "v2015".hmis_type (name,value,description,status) values ('youth_age_group','2','Only ages 18 to 24','ACTIVE'); 
	INSERT INTO "v2015".hmis_type (name,value,description,status) values ('youth_age_group','3','Only youth under age 24 (both of the above)','ACTIVE');
	
	
INSERT INTO "v2015".hmis_type (name,value,description,status) values ('veteran_status','0','No','ACTIVE');
INSERT INTO "v2015".hmis_type (name,value,description,status) values ('veteran_status','1','Yes','ACTIVE');
INSERT INTO "v2015".hmis_type (name,value,description,status) values    ('veteran_status','8','Client does not know','ACTIVE');
INSERT INTO "v2015".hmis_type  (name,value,description,status) values  ('veteran_status','9','Client refused','ACTIVE');
INSERT INTO "v2015".hmis_type  (name,value,description,status) values ('veteran_status','99','Data not collected','ACTIVE');

INSERT INTO "v2015".hmis_type (name,value,description,status) values ('afghanistan_oef','0','No','ACTIVE');
INSERT INTO "v2015".hmis_type (name,value,description,status) values ('afghanistan_oef','1','Yes','ACTIVE');
INSERT INTO "v2015".hmis_type (name,value,description,status) values    ('afghanistan_oef','8','Client does not know','ACTIVE');
INSERT INTO "v2015".hmis_type  (name,value,description,status) values  ('afghanistan_oef','9','Client refused','ACTIVE');
INSERT INTO "v2015".hmis_type  (name,value,description,status) values ('afghanistan_oef','99','Data not collected','ACTIVE');

create table "v2015".source
(
id uuid not null,
  export text,
  softwarevendor character varying(50),
  softwareVersion character varying(50),
  sourceContactEmail	text,
  sourceContactExtension	text,
  sourceContactFirst	character varying(50),
  sourceContactLast	character varying(50),
  sourceContactPhone	character varying(12),
  sourceID	character varying(32),
  sourceName	character varying(50),
  "project_group_code" character varying(8),
  "date_created" timestamp,
  "date_created_from_source" timestamp,
  "date_updated_from_source" timestamp,
  "date_updated" timestamp,
  "user_id" uuid,
  export_id uuid,
  parent_id uuid,
  version integer,
  deleted boolean DEFAULT false, 
  sync boolean DEFAULT false,
  constraint "source_pkey" primary key (id)
     )
with (
  oids=false
);

create table "v2015".export
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
  version integer,
  deleted boolean DEFAULT false, 
  sync boolean DEFAULT false,
   constraint "export_pkey" primary key (id),
      CONSTRAINT source_fkey FOREIGN KEY (source_id)
      REFERENCES v2015.source (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
     )
with (
  oids=false
);


create table "v2015".organization
(
	id uuid not null,  
	organizationname character varying(32),
	organizationcommonname character varying(32),
   "project_group_code" character varying(8),
   "date_created" timestamp,
   "date_created_from_source" timestamp,
   "date_updated_from_source" timestamp,
   "date_updated" timestamp,
   "user_id" uuid,
   export_id uuid,
   parent_id uuid,
   version integer,
   deleted boolean DEFAULT false,
   sync boolean DEFAULT false,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES v2015.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  	  constraint "organization_pkey" primary key (id)
)
with (
  oids=false
);


CREATE TABLE  "v2015".project
(
	  id uuid NOT NULL,
	  --project_id character varying(8),
	  projectname character varying(32),
	  continuumproject "v2015".no_yes,
	  projecttype "v2015".project_type,
	  --residentialaffiliation "v2015".no_yes,
	  trackingmethod "v2015".tracking_method,
	  targetpopulation "v2015".target_population_type,
	  projectcommonname character varying(32),
	  organizationid uuid,
	  date_created timestamp,
	  date_updated timestamp,
	  "date_created_from_source" timestamp,
      "date_updated_from_source" timestamp,
      "project_group_code" character varying(8),
	  user_id uuid,
	  export_id uuid,
	  parent_id uuid,
	  version integer,
	  deleted boolean DEFAULT false,
	  sync boolean DEFAULT false,
	      CONSTRAINT export_fkey FOREIGN KEY (export_id)
	      REFERENCES v2015.export (id) MATCH SIMPLE
	      ON UPDATE NO ACTION ON DELETE NO ACTION,
	  	  CONSTRAINT "project_pk" PRIMARY KEY (id),
	      CONSTRAINT "organization_project_fkey" FOREIGN KEY (organizationid)
	      REFERENCES v2015.organization (id) MATCH SIMPLE
	      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);

-- DROP TABLE "v2015"."client";
CREATE TABLE "v2015".client
(
  "id" uuid NOT NULL,
  "dedup_client_id" uuid,
  "first_name" character(50),
  "middle_name" character(50),
  "last_name" character(50),
  "name_suffix" character(50),
  "name_data_quality" "v2015".name_data_quality,
  "ssn" character(9),
  "ssn_data_quality" "v2015".ssn_data_quality,
  "dob" timestamp,
  "dob_data_quality" "v2015".dob_data_quality,
  "gender" "v2015".gender,
  "other_gender" character(10),
  "ethnicity" "v2015".ethnicity,
  "race"  "v2015".race,
  "veteran_status" "v2015".veteran_status,
  "project_group_code" character varying(8),
  "date_created" timestamp,
  "date_created_from_source" timestamp,
  "date_updated_from_source" timestamp,
  "date_updated" timestamp,
  "user_id" uuid,
  export_id uuid,
  parent_id uuid,
  version integer,
  deleted boolean DEFAULT false, 
  sync boolean DEFAULT false,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES v2015.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  	  CONSTRAINT client_pk PRIMARY KEY ("id")
      )
WITH (
  OIDS=FALSE
);
-- Table: "v2015"."client"

-- veteran_info changed to client_veteran_info
CREATE TABLE "v2015".client_veteran_info
(
  "id" uuid NOT NULL,
  "year_entrd_service" integer,
  "year_seperated" integer,
  "world_war_2" "v2015".five_val_dk_refused,
  "korean_war" "v2015".five_val_dk_refused,
  "vietnam_war" "v2015".five_val_dk_refused,
  "desert_storm" "v2015".five_val_dk_refused,
  "afghanistan_oef" "v2015".afghanistanoef,
  "iraq_oif" "v2015".five_val_dk_refused,
  "iraq_ond" "v2015".five_val_dk_refused,
  "other_theater" "v2015".five_val_dk_refused,
  "military_branch" "v2015".military_branch,
  "discharge_status" "v2015".discharge_status,
  "project_group_code" character varying(8),
  "date_created" timestamp,
  "date_created_from_source" timestamp,
  "date_updated_from_source" timestamp,
  "date_updated" timestamp,
  "user_id" uuid,
  "client_id" uuid,
  export_id uuid,
  parent_id uuid,
  version integer,
  deleted boolean DEFAULT false, 
  sync boolean DEFAULT false,  
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES v2015.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  	  CONSTRAINT veteran_info_pk PRIMARY KEY ("id"),
  	  CONSTRAINT veteran_info_client_fk FOREIGN KEY ("client_id")
      REFERENCES "v2015".client ("id") MATCH SIMPLE
)
WITH (
  OIDS=FALSE
);

CREATE TABLE "v2015".enrollment
(
  	id uuid NOT NULL,
 --continuouslyHomelessOneYear "v2015".youth_age_group,
	projectentryid uuid,
	entrydate timestamp,
	householdid uuid,
	relationshiptohoh "v2015".relationship_to_head_of_household,
	otherresidenceprior character varying(50),
	residencePrior "v2015".residence_prior,
	residencePriorlengthofstay "v2015".residence_prior_length_of_stay,
	disablingCondition "v2015".five_val_dk_refused,
	housingstatus "v2015".housing_status,
	entryFromStreetESSH integer,
	dateToStreetESSH integer,
	timesHomelesspastthreeyears "v2015".times_homeless_past_3_years,
	monthsHomelessPastThreeYears "v2015".months_homeless_past_3_years,
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
	version integer,
	deleted boolean DEFAULT false,
	sync boolean DEFAULT false,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES v2015.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  		CONSTRAINT "enrollment_pkey" PRIMARY KEY (id),
    	CONSTRAINT enrollment_client_fk FOREIGN KEY ("client_id")
      	REFERENCES "v2015".client ("id") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
      	CONSTRAINT enrollment_project_fk FOREIGN KEY ("projectid")
      	REFERENCES "v2015".project ("id") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);




CREATE TABLE "v2015".path_status
(
  "id" uuid NOT NULL,
  "date_of_status" timestamp,
  "client_enrolled_in_path" bigint,
  "reason_not_enrolled"  "v2015".reason_not_enrolled,
  "enrollmentid" uuid,
  "project_group_code" character varying(8),
  "date_created" timestamp,
  "date_created_from_source" timestamp,
  "date_updated_from_source" timestamp,
  "date_updated" timestamp,
  "user_id" uuid,
  export_id uuid,
  parent_id uuid,
  version integer,
  deleted boolean DEFAULT false,
  sync boolean DEFAULT false,  
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES v2015.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
	  CONSTRAINT path_status_pk PRIMARY KEY ("id"),
	  CONSTRAINT "enrollment_path_status_fk_key" FOREIGN KEY ("enrollmentid")
      REFERENCES v2015.enrollment ("id") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);


CREATE TABLE "v2015".entryRHY
(
	"id" uuid NOT NULL,
	"enrollmentid" uuid,
	sexual_orientation integer,
	formerly_ward_child_welfr_forest_care integer,
	years_child_welfr_forest_care integer,
	months_child_welfr_forest_care integer,
	formerly_ward_of_juvenile_justice integer,
	years_juvenile_justice integer,
	house_hold_dynamics integer,
	sexual_orientatiion_gender_identity_youth integer,
	sexual_orientatiion_gender_identity_family_mbr integer,
	housing_issues_youth integer,
	housing_issues_family_mbr integer,
	school_education_issues_youth integer,
	school_education_issues_family_mbr integer,
	unemployement_youth integer,
	unemployement_family_mbr integer,
	mental_health_issues_youth integer,
	mental_health_issues_family_mbr integer,
	health_issues_youth integer,
	health_issues_family_mbr integer,
	physical_disability_youth integer,
	physical_disability_family_mbr integer,
	mental_disability_youth integer,
	mental_disability_family_mbr integer,
	abuse_and_neglect_youth integer,
	abuse_and_neglect_family_mbr integer,
	alcohol_drug_abuse_youth integer,
	alcohol_drug_abuse_family_mbr integer,
	insufficient_income_to_support_youth integer,
	active_military_parent integer,
	incarcerated_parent integer,
	incarcerated_parent_status integer,
	referral_source integer,
	count_out_reach_referral_approaches integer,
	exchange_for_sex integer,
	exchange_for_sex_past_three_months integer,
	count_of_exchange_for_sex integer,
	asked_of_forced_to_exchange_for_sex integer,
	asked_of_forced_to_exchange_for_sex_past_three_months integer,
	work_place_violence_threat integer,
	work_place_promise_difference integer,
	coerced_to_continue_work integer,
	labor_exploit_past_three_months integer,
	"project_group_code" character varying(8),
  	"date_created" timestamp,
  	"date_created_from_source" timestamp,
  	"date_updated_from_source" timestamp,
  	"date_updated" timestamp,
  	"user_id" uuid,
  	export_id uuid,
  	parent_id uuid,
  	version integer,
  	deleted boolean DEFAULT false,
  	sync boolean DEFAULT false,  
      CONSTRAINT entryRHY_fkey FOREIGN KEY (export_id)
      REFERENCES v2015.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  	  CONSTRAINT entryRHY_pk PRIMARY KEY ("id"),
	  CONSTRAINT "enrollment_entryRHY_fk_key" FOREIGN KEY ("enrollmentid")
      REFERENCES v2015.enrollment ("id") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);	

CREATE TABLE "v2015".entrySSVF
(
	"id" uuid NOT NULL,
	"enrollmentid" uuid,
	percentAMI integer,
	last_permanent_street character(50),
	last_permanent_city character(50),
	last_permanent_state character(50),
	last_permanent_zip character(50),
	address_data_quality integer,
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
  	version integer,
  	deleted boolean DEFAULT false,
  	sync boolean DEFAULT false,  
      CONSTRAINT entrySSVF_fkey FOREIGN KEY (export_id)
      REFERENCES v2015.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  	  CONSTRAINT entrySSVF_pk PRIMARY KEY ("id"),
	  CONSTRAINT "enrollment_entrySSVF_fk_key" FOREIGN KEY ("enrollmentid")
      REFERENCES v2015.enrollment ("id") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);	

CREATE TABLE "v2015".enrollment_coc
(
	  id uuid NOT NULL,
  	  enrollmentid uuid,
	  client_code character(20),
	  information_date timestamp,
	  project_group_code character varying(8),
	  date_created timestamp,
	  date_updated timestamp,
	  "date_created_from_source" timestamp,
  	  "date_updated_from_source" timestamp,
	  user_id uuid,
	  export_id uuid,
	  parent_id uuid,
	  version integer,
	  deleted boolean DEFAULT false,
	  sync boolean DEFAULT false,
      	CONSTRAINT export_fkey FOREIGN KEY (export_id)
      	REFERENCES v2015.export (id) MATCH SIMPLE
      	ON UPDATE NO ACTION ON DELETE NO ACTION,
 		CONSTRAINT "enrollment_coc_pkey" PRIMARY KEY ("id"),
  		CONSTRAINT "enrollment_coc_fk_key" FOREIGN KEY ("enrollmentid")
      	REFERENCES v2015.enrollment ("id") MATCH SIMPLE
      	ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);


CREATE TABLE "v2015".service_fa_referral
(
  "id" uuid NOT NULL,
  "enrollmentid" uuid,
  dateProvided timestamp,
  service_category integer,
  funder_list integer,
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
  version integer,
  deleted boolean DEFAULT false,
  sync boolean DEFAULT false,
    CONSTRAINT export_fkey FOREIGN KEY (export_id)
    REFERENCES v2015.export (id) MATCH SIMPLE
    ON UPDATE NO ACTION ON DELETE NO ACTION,
	CONSTRAINT service_fa_referral_pk PRIMARY KEY ("id"),
	CONSTRAINT "service_fa_referral_fk_key" FOREIGN KEY ("enrollmentid")
	REFERENCES v2015.enrollment ("id") MATCH SIMPLE
	ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);

-- Table: v2015.last_grade_completed

CREATE TABLE "v2015".schoolstatus
(
  "id" uuid NOT NULL,
  "information_date" timestamp,
  "school_status" "v2015".school_status,
  "enrollmentid" uuid,
  "project_group_code" character varying(8),
  "date_created" timestamp,
  "date_created_from_source" timestamp,
  "date_updated_from_source" timestamp,
  "date_updated" timestamp,
  "user_id" uuid,
  export_id uuid,
  parent_id uuid,
  version integer,
  deleted boolean DEFAULT false,
  sync boolean DEFAULT false,  
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES v2015.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT school_status_pk PRIMARY KEY ("id"),
   CONSTRAINT "enrollment_schoolstatus_fk_key" FOREIGN KEY ("enrollmentid")
      REFERENCES v2015.enrollment ("id") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);


CREATE TABLE "v2015".employment
(
  "id" uuid NOT NULL,
  "information_date" timestamp,
  "employed" "v2015".five_val_dk_refused,
  "employment_type" "v2015".employment_type,
  "not_employed_reason" "v2015".not_employed_reason,
  "enrollmentid" uuid,
  "project_group_code" character varying(8),
  "date_created" timestamp,
  "date_created_from_source" timestamp,
  "date_updated_from_source" timestamp,
  "date_updated" timestamp,
  "user_id" uuid,
  export_id uuid,
  parent_id uuid,
  version integer,
  deleted boolean DEFAULT false,
  sync boolean DEFAULT false,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES v2015.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
	  CONSTRAINT employment_pk PRIMARY KEY ("id"),
	  CONSTRAINT "enrollment_employment_fk_key" FOREIGN KEY ("enrollmentid")
      REFERENCES v2015.enrollment ("id") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);


CREATE TABLE "v2015".health_status
(
  "id" uuid NOT NULL,
  "enrollmentid" uuid,
  "information_date" timestamp,
  "health_category" "v2015".health_category,
  "health_status" "v2015".health_status_type,
  "due_date" timestamp,
  "project_group_code" character varying(8),
  "date_created" timestamp,
  "date_created_from_source" timestamp,
  "date_updated_from_source" timestamp,
  "date_updated" timestamp,
  "user_id" uuid,
  export_id uuid,
  parent_id uuid,
  version integer,
  deleted boolean DEFAULT false,
  sync boolean DEFAULT false,  
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES v2015.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  	  CONSTRAINT health_status_pk PRIMARY KEY ("id"),
      CONSTRAINT "enrollment_health_status_fk_key" FOREIGN KEY ("enrollmentid")
      REFERENCES v2015.enrollment ("id") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);


create table "v2015".contact
(
	id uuid not null, 
	contact_date timestamp,
	contact_location integer,
	"enrollmentid" uuid,
	"project_group_code" character varying(8),
  	"date_created" timestamp,
  	"date_created_from_source" timestamp,
  	"date_updated_from_source" timestamp,
  	"date_updated" timestamp,
  	"user_id" uuid,
  	export_id uuid,
  	parent_id uuid,
  	version integer,
  	deleted boolean DEFAULT false,
  	sync boolean DEFAULT false,  
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES v2015.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  	  CONSTRAINT contact_pk PRIMARY KEY ("id"),
      CONSTRAINT "enrollment_health_status_fk_key" FOREIGN KEY ("enrollmentid")
      REFERENCES v2015.enrollment ("id") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);


-- Table: "affiliation"

-- DROP TABLE "affiliation";

CREATE TABLE "v2015".affiliation
(
	  id uuid NOT NULL,
	  projectid uuid,
	  resprojectid character varying(32),
	  "project_group_code" character varying(8),
	  "date_created" timestamp,
	  "date_created_from_source" timestamp,
	  "date_updated_from_source" timestamp,
	  "date_updated" timestamp,
	  "user_id" uuid,
	  export_id uuid,
	  parent_id uuid,
	  version integer,
	  deleted boolean DEFAULT false,
	  sync boolean DEFAULT false,  
		CONSTRAINT export_fkey FOREIGN KEY (export_id)
		REFERENCES v2015.export (id) MATCH SIMPLE
		ON UPDATE NO ACTION ON DELETE NO ACTION,
		CONSTRAINT "affiliation_pkey" PRIMARY KEY (id),
		CONSTRAINT "affiliation_project_fkey" FOREIGN KEY (projectid)
		REFERENCES v2015.project (id) MATCH SIMPLE
		ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);



CREATE TABLE "v2015".bedinventory
(
  id uuid NOT NULL,
  bed_inventory integer,
  ch_bed_inventory integer,
  vet_bed_inventory integer,
  youth_age_group "v2015".youth_age_group,
  youth_bed_inventory bigint,
  "project_group_code" character varying(8),
   "date_created" timestamp,
   "date_created_from_source" timestamp,
  "date_updated_from_source" timestamp,
  "date_updated" timestamp,
  "user_id" uuid,
  export_id uuid,
  parent_id uuid,
  version integer,
  deleted boolean DEFAULT false,
  sync boolean DEFAULT false,  
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES v2015.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "bedinventory_pkey" PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);

-- table: "projectcoc" changed to CoC

-- drop table "coc";

create table "v2015".coc
(
  id uuid not null,
  coccode character varying(32),
   projectid uuid,
  "project_group_code" character varying(8),
   date_created timestamp,
   "date_created_from_source" timestamp,
  "date_updated_from_source" timestamp,
   date_updated timestamp,
   user_id uuid,
   export_id uuid,
   parent_id uuid,
   version integer,
   deleted boolean DEFAULT false,
   sync boolean DEFAULT false,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES v2015.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  constraint "coc_pkey" primary key (id),
  constraint "coc_projectid_fkey" foreign key (projectid)
      references v2015.project (id) match simple
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
with (
  oids=false
);


create table "v2015".site
(
	id uuid not null,
	address character varying(100),
	city  character varying(50),
	geocode  integer, 
	principal_site "v2015".no_yes,
	--project_coc_id uuid,
	coc_id uuid,
	state "v2015".state, 
	zip text,
	"project_group_code" character varying(8),
	date_created timestamp,
	"date_created_from_source" timestamp,
	"date_updated_from_source" timestamp,
	date_updated timestamp,
	user_id uuid,
	export_id uuid,
	parent_id uuid,
	version integer,
	deleted boolean DEFAULT false,
	sync boolean DEFAULT false,
		CONSTRAINT export_fkey FOREIGN KEY (export_id)
		REFERENCES v2015.export (id) MATCH SIMPLE
		ON UPDATE NO ACTION ON DELETE NO ACTION,
		constraint "site_pkey" primary key (id),
		constraint "site_coc_fkey" foreign key (coc_id)
		references v2015."coc" (id) match simple
		on update no action on delete no action
)
with (
  oids=false
);


create table "v2015".inventory
(
   id uuid not null,
  householdtype "v2015".house_hold_type,
  bedtype "v2015".bed_type,
  availabilty "v2015".availability,
  unitinventory integer,
  bedinventory uuid,
  ch_bed_inventory integer,
  vet_bed_inventory integer,
  youth_bed_inventory integer,
  youth_age_group integer,
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
  version integer,
  deleted boolean DEFAULT false,
  sync boolean DEFAULT false,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES v2015.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  constraint "inventory_pkey" primary key (id),
  constraint "inventory_cocid_fkey" foreign key (coc_id)
      references v2015."coc" (id) match simple
      on update no action on delete no action,
      CONSTRAINT "bed_inventory_fkey" FOREIGN KEY (bedinventory)
      REFERENCES v2015.bedinventory (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
with (
  oids=false
);


-- table: "funder"

-- drop table "funder";

create table  "v2015".funder
(
  "id"  uuid not null,
  "enddate" timestamp,
  "funder" "v2015".federal_partner_components,
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
  version integer,
  deleted boolean DEFAULT false,
  sync boolean DEFAULT false,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES v2015.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
      constraint "funder_pkey" primary key ("id"),
      constraint "funder_projectid_fkey" foreign key ("projectid")
      references v2015.project (id) match simple
      on update no action on delete no action
)
with (
  oids=false
);


CREATE TABLE "v2015".rhybcp_status
(
  "id" uuid NOT NULL,
  "status_date" timestamp,
  "fysb_youth" "v2015".no_yes,
  "reason_no_services" "v2015".fysb_rsn_not_providing_srvcs,
  "enrollmentid" uuid,
  "project_group_code" character varying(8),
  "date_created" timestamp,
  "date_created_from_source" timestamp,
  "date_updated_from_source" timestamp,
  "date_updated" timestamp,
  "user_id" uuid,
  export_id uuid,
  parent_id uuid,
  version integer,
  deleted boolean DEFAULT false,
  sync boolean DEFAULT false,
    CONSTRAINT export_fkey FOREIGN KEY (export_id)
    REFERENCES v2015.export (id) MATCH SIMPLE
    ON UPDATE NO ACTION ON DELETE NO ACTION,
	CONSTRAINT rhybcp_status_pk PRIMARY KEY ("id"),
	CONSTRAINT "enrollment_rhybcp_status_fk_key" FOREIGN KEY ("enrollmentid")
	REFERENCES v2015.enrollment ("id") MATCH SIMPLE
	ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);


-- table: "medicalassistance"

-- drop table "medicalassistance";

create table "v2015".medicalassistance
(
	id uuid not null,  
	hivaidsassistance "v2015".five_val_dk_refused,
  	nohivaidsassistancereason "v2015".no_medical_assistance_reason,
  	adap "v2015".five_val_dk_refused,
  	noadapreason "v2015".no_medical_assistance_reason,
  	information_date timestamp,
	enrollmentid uuid,
    "project_group_code" character varying(8),
    "date_created" timestamp,
    "date_updated" timestamp,
     "date_created_from_source" timestamp,
  "date_updated_from_source" timestamp,
    "user_id" uuid,
	  export_id uuid,
	  parent_id uuid,
	  version integer,
	  deleted boolean DEFAULT false,
	  sync boolean DEFAULT false,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES v2015.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
	  constraint "medicalassistance_pkey" primary key (id),
	  constraint "medicalassistance_enrollmentid_fkey" foreign key (enrollmentid)
      references v2015.enrollment ("id") match simple
      on update no action on delete no action
      
)
with (
  oids=false
);

-- table: "domesticviolence"

-- drop table "domesticviolence";

create table "v2015".domesticviolence
(
  "id"  uuid not null,
  "domesticviolencevictim" "v2015".five_val_dk_refused,
  "enrollmentid" uuid,
  "whenoccurred" "v2015".when_dom_violence_occurred,
  currently_fleeing integer,
  "project_group_code" character varying(8),
  "date_created" timestamp,
  "date_created_from_source" timestamp,
   "date_updated_from_source" timestamp,
  "date_updated" timestamp,
  "user_id" uuid,
  export_id uuid,
  parent_id uuid,
  version integer,
  deleted boolean DEFAULT false,
  sync boolean DEFAULT false,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES v2015.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  		constraint "domesticviolence_pkey" primary key ("id"),
  		constraint "domesticviolence_enrollmentid_fkey" foreign key ("enrollmentid")
      references v2015.enrollment ("id") match simple
      on update no action on delete no action
)
with (
  oids=false
);

-- table: "disabilities"

-- drop table "disabilities";

create table "v2015".disabilities
(
  "id" uuid not null,
  "disabilitytype" "v2015".disability_type,
  "disabilityresponse" integer,
  "indefiniteandimpairs" "v2015".five_val_dk_refused,
  "documentationonfile" "v2015".no_yes,
  "receivingservices" "v2015".five_val_dk_refused,
  "pathhowconfirmed" "v2015".path_how_confirmed,
  "pathsmiinformation" "v2015".path_smi_info_how_confirmed,
  "enrollmentid" uuid,
  tcellcountavailable integer,
  tcellcount integer,
  tcellcountsource character(8),
  viral_load_available integer,
  viral_load integer,
  viral_load_source character(8),
  information_date timestamp,
  "project_group_code" character varying(8),
  "date_created" timestamp,
  "date_created_from_source" timestamp,
   "date_updated_from_source" timestamp,
  "date_updated" timestamp,
  "user_id" uuid,
  export_id uuid,
  parent_id uuid,
  version integer,
  deleted boolean DEFAULT false,
  sync boolean DEFAULT false,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES v2015.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
	  constraint "disabilities_pkey" primary key ("id"),
	  constraint "disabilities_enrollmentid_fkey" foreign key ("enrollmentid")
      references v2015.enrollment ("id") match simple
      on update no action on delete no action
)
with (
  oids=false
);
-- table: "residentialmoveindate"

-- drop table "residentialmoveindate";

create table  "v2015".residentialmoveindate
(
  	id uuid not null,
	inpermanenthousing "v2015".no_yes,
  	enrollmentid uuid,
  	residentialmoveindate timestamp,
    "project_group_code" character varying(8),
  	"date_created" timestamp,
  	"date_created_from_source" timestamp,
   	"date_updated_from_source" timestamp,
  	"date_updated" timestamp,
  	"user_id" uuid,
  	export_id uuid,
  	parent_id uuid,
  	version integer,
  	deleted boolean DEFAULT false,
  	sync boolean DEFAULT false,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES v2015.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  	  constraint "residentialmoveindate_pkey" primary key (id),
      constraint "residentialmoveindate_enrollmentid_fkey" foreign key (enrollmentid)
      references v2015.enrollment ("id") match simple 
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
with (
  oids=false
);

-- table: "dateofengagement"

-- drop table "dateofengagement";

create table  "v2015".dateofengagement
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
	version integer,
	deleted boolean DEFAULT false,
	sync boolean DEFAULT false,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES v2015.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  		constraint "dateofengagement_pkey" primary key ("id"),
  		constraint "dateofengagement_enrollmentid_fkey" foreign key ("enrollmentid")
      	references v2015.enrollment ("id") match simple
      	on update no action on delete no action
)
with (
  oids=false
);

create table  "v2015".entryRHSP
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
	version integer,
	deleted boolean DEFAULT false,
	sync boolean DEFAULT false,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES v2015.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  		constraint "entryRHSP_pkey" primary key ("id"),
  		constraint "entryRHSP_enrollmentid_fkey" foreign key ("enrollmentid")
      	references v2015.enrollment ("id") match simple
      	on update no action on delete no action
)
with (
  oids=false
);

create table  "v2015".education
(
  	"id" uuid not null,
	lastgradecompleted "stagv2014".last_grade_completed,
	"school_status" "stagv2014".school_status,
	"enrollmentid" uuid,
	"project_group_code" character varying(8),
	"date_created" timestamp,
	"date_created_from_source" timestamp,
	"date_updated_from_source" timestamp,
	"date_updated" timestamp,
	"user_id" uuid,
	export_id uuid,
	parent_id uuid,
	version integer,
	deleted boolean DEFAULT false,
	sync boolean DEFAULT false,
      CONSTRAINT education_export_fkey FOREIGN KEY (export_id)
      REFERENCES v2015.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  		constraint "education_pkey" primary key ("id"),
  		constraint "education_fkey" foreign key ("enrollmentid")
      	references v2015.enrollment ("id") match simple
      	on update no action on delete no action
)
with (
  oids=false
);

-- drop table "incomeandsources";

create table "v2015".incomeandsources
(
  alimony "v2015".no_yes,
  alimonyamount numeric(15,3),
  childsupport "v2015".no_yes,
  childsupportamount numeric(15,3),
  earned "v2015".no_yes,
  earnedamount numeric(15,3),
  ga "v2015".no_yes,
  gaamount numeric(15,3),
  id uuid not null,
  incomefromanysource "v2015".five_val_dk_refused,
  othersource "v2015".no_yes,
  othersourceamount numeric(15,3),
  othersourceidentify character varying(32),
  pension "v2015".no_yes,
  pensionamount numeric(15,3),
  privatedisability "v2015".no_yes,
  privatedisabilityamount numeric(15,3),
  enrollmentid uuid,
  socsecretirement "v2015".no_yes,
  socsecretirementamount numeric(15,3),
  ssdi "v2015".no_yes,
  ssdiamount numeric(15,3),
  ssi "v2015".no_yes,
  ssiamount numeric(15,3),
  tanf "v2015".no_yes,
  tanfamount numeric(15,3),
  totalmonthlyincome numeric(15,3),
  unemployment "v2015".no_yes,
  unemploymentamount numeric(15,3),
  vadisabilitynonservice "v2015".no_yes,
  vadisabilitynonserviceamount numeric(15,3),
  vadisabilityservice "v2015".no_yes,
  vadisabilityserviceamount numeric(15,3),
  workerscomp "v2015".no_yes,
  workerscompamount numeric(15,3),
  "project_group_code" character varying(8),
  "date_created" timestamp,
  "date_created_from_source" timestamp,
    "date_updated_from_source" timestamp,
  "date_updated" timestamp,
  "user_id" uuid,
  export_id uuid,
  parent_id uuid,
  version integer,
  deleted boolean DEFAULT false,
  sync boolean DEFAULT false, 
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES v2015.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  constraint "incomeandsources_pkey" primary key (id),
  constraint "incomeandsources_enrollmentid_fkey" foreign key (enrollmentid)
      references v2015.enrollment ("id") match simple
      on update no action on delete no action
)
with (
  oids=false
);



-- drop table "noncashbenefits";

create table "v2015".noncashbenefits
(
	id uuid not null,  
	benefitsfromanysource "v2015".five_val_dk_refused,
  	othersource "v2015".no_yes,
  	othersourceidentify character varying(32),
  	othertanf "v2015".no_yes,
  	enrollmentid uuid,
  	rentalassistanceongoing "v2015".no_yes,
  	rentalassistancetemp "v2015".no_yes,
  	snap "v2015".no_yes,
  	tanfchildcare "v2015".no_yes,
  	tanftransportation "v2015".no_yes,
  	wic "v2015".no_yes,
  	"project_group_code" character varying(8),
  	"date_created" timestamp,
  	"date_created_from_source" timestamp,
    "date_updated_from_source" timestamp,
  	"date_updated" timestamp,
  	"user_id" uuid,
  	export_id uuid,
  	parent_id uuid,
  	version integer,
  	deleted boolean DEFAULT false,
  	sync boolean DEFAULT false,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES v2015.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
	  constraint "noncashbenefits_pkey" primary key (id),
	  constraint "noncashbenefits_enrollmentid_fkey" foreign key (enrollmentid)
      references v2015.enrollment ("id") match simple
      on update no action on delete no action
)
with (
  oids=false
);

-- table: "healthinsurance"

-- drop table "healthinsurance";

create table "v2015".healthinsurance
(
  "id" uuid not null,
  "insurancefromanysource" "v2015".five_val_dk_refused,
  "medicaid" "v2015".no_yes,
  "nomedicaidreason" "v2015".no_health_insurance_reason,
  "medicare" "v2015".no_yes,
  "nomedicarereason" "v2015".no_health_insurance_reason,
  "schip" "v2015".no_yes,
  "noschipreason" "v2015".no_health_insurance_reason,
  "vamedicalservices" "v2015".no_yes,
  "novamedreason" "v2015".no_health_insurance_reason,
  "employerprovided" integer,
  "noemployerprovidedreason" "v2015".no_health_insurance_reason,
  "cobra" integer,
  "nocobrareason" "v2015".no_health_insurance_reason,
  "privatepay" "v2015".no_yes,
  "noprivatepayreason" "v2015".no_health_insurance_reason,
  "statehealthins" "v2015".no_yes,
  "nostatehealthinsreason" "v2015".no_health_insurance_reason,
  other_source integer,
  other_source_identify character(8),
  "enrollmentid" uuid,
  "project_group_code" character varying(8),
  "date_created" timestamp,
  "date_created_from_source" timestamp,
  "date_updated_from_source" timestamp,
  "date_updated" timestamp,
  "user_id" uuid,
  export_id uuid,
  parent_id uuid,
  version integer,
  deleted boolean DEFAULT false,
  sync boolean DEFAULT false,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES v2015.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
	  constraint "healthinsurance_pkey" primary key ("id"),
	  constraint "healthinsurance_enrollmentid_fkey" foreign key ("enrollmentid")
      references v2015.enrollment ("id") match simple
      on update no action on delete no action
)
with (
  oids=false
);

create table "v2015".exit
(
	"id" uuid not null,  
	"destination" "v2015".destination,
	"exitdate" timestamp,
	"otherdestination" character varying(32),
	"enrollmentid" uuid,
	"project_group_code" character varying(8),
	"date_created" timestamp,
	"date_created_from_source" timestamp,
	"date_updated_from_source" timestamp,
	"date_updated" timestamp,
	"user_id" uuid,
	export_id uuid,
	parent_id uuid,
	version integer,
	deleted boolean DEFAULT false,
	sync boolean DEFAULT false,
		CONSTRAINT export_fkey FOREIGN KEY (export_id)
		REFERENCES v2015.export (id) MATCH SIMPLE
		ON UPDATE NO ACTION ON DELETE NO ACTION,
		constraint "exit_pkey" primary key ("id"),
		constraint "exit_enrollmentid_fkey" foreign key ("enrollmentid")
		references v2015.enrollment ("id") match simple
		on update no action on delete no action
)
with (
  oids=false
);

create table "v2015".exitPath
(
	"id" uuid not null, 
	connection_with_soar integer,
	"exitid" uuid,
	"project_group_code" character varying(8),
	"date_created" timestamp,
	"date_created_from_source" timestamp,
	"date_updated_from_source" timestamp,
	"date_updated" timestamp,
	"user_id" uuid,
	export_id uuid,
	parent_id uuid,
	version integer,
	deleted boolean DEFAULT false,
	sync boolean DEFAULT false,
		CONSTRAINT export_fkey FOREIGN KEY (export_id)
		REFERENCES v2015.export (id) MATCH SIMPLE
		ON UPDATE NO ACTION ON DELETE NO ACTION,
		constraint "exit_path_pkey" primary key ("id"),
		constraint "exit_fkey" foreign key ("exitid")
		references v2015.exit(id) match simple
		on update no action on delete no action
)
with (
  oids=false
);

---Done--
create table  "v2015".exithousingassessment
(
  "id" uuid not null,
  "exitid" uuid,
  "housingassessment" "v2015".housing_assmnt_exit,
  "subsidyinformation" "v2015".subsidy_information,
  "project_group_code" character varying(8),
  "date_created" timestamp,
  "date_created_from_source" timestamp,
  "date_updated_from_source" timestamp,
  "date_updated" timestamp,
  "user_id" uuid,
  export_id uuid,
  parent_id uuid,
  version integer,
  deleted boolean DEFAULT false,
  sync boolean DEFAULT false,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES v2015.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
	  constraint "exithousingassessment_pkey" primary key ("id"),
	  constraint "exithousingassessment_fkey" foreign key ("exitid")
      references v2015.exit(id) match simple
      on update no action on delete no action
)
with (
  oids=false
);


create table "v2015".exitRHY
(
	"id" uuid not null, 
	"exitid" uuid,
	project_completion_status integer,
	early_exit_reason integer,
	family_reunification_achieved integer,
	written_after_care_plan integer,
	assistance_main_stream_benefits integer,
	permenant_housing_placement integer,
	temp_shelter_placement integer,
	exit_counseling integer,
	further_followup_services integer,
	scheduled_followup_contacts integer,
	resource_package integer,
	other_aftercare_plan_or_action integer,
	"project_group_code" character varying(8),
	"date_created" timestamp,
	"date_created_from_source" timestamp,
	"date_updated_from_source" timestamp,
	"date_updated" timestamp,
	"user_id" uuid,
	export_id uuid,
	parent_id uuid,
	version integer,
	deleted boolean DEFAULT false,
	sync boolean DEFAULT false,
		CONSTRAINT export_fkey FOREIGN KEY (export_id)
		REFERENCES v2015.export (id) MATCH SIMPLE
		ON UPDATE NO ACTION ON DELETE NO ACTION,
		constraint "exitRHY_pkey" primary key ("id"),
		constraint "exitRHY_fkey" foreign key ("exitid")
		references v2015.exit("id") match simple
		on update no action on delete no action
)
with (
  oids=false
);


-- table: "exitplansactions"

-- drop table "exitplansactions";


create table "v2015".housingassessmentdisposition
(
  "id" uuid not null,
  "assessmentdisposition" "v2015".assessment_disposition,
  "exitid" uuid,
  "otherdisposition" character varying(32),
  "project_group_code" character varying(8),
  "date_created" timestamp,
  "date_created_from_source" timestamp,
  "date_updated_from_source" timestamp,
  "date_updated" timestamp,
  "user_id" uuid,
  export_id uuid,
  parent_id uuid,
  version integer,
  deleted boolean DEFAULT false,
  sync boolean DEFAULT false,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES v2015.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
	  constraint "housingassessmentdisposition_pkey" primary key ("id"),
	  constraint "housingassessmentdisposition_exitid_fkey" foreign key ("exitid")
      references v2015."exit" ("id") match simple
      on update no action on delete no action
)
with (
  oids=false
);



CREATE TABLE "v2015".sync
(
  id uuid NOT NULL,
  sync_table character(100),
  status character(10),
  json text,
  date_created timestamp,
  date_updated timestamp,
  CONSTRAINT sync_pk PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);

CREATE TABLE "v2015".bulk_upload
(
  id serial NOT NULL,
  inputPath text,
  status character(10),
  "project_group_code" character varying(8),
  "date_created" timestamp,
  "date_created_from_source" timestamp,
  "date_updated_from_source" timestamp,
  "date_updated" timestamp,
  "user_id" uuid,
  export_id uuid,
  parent_id uuid,
  version integer,
  deleted boolean DEFAULT false,
  sync boolean DEFAULT false,
  constraint "bulk_upload_pkey" primary key ("id"),
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES v2015.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
--CREATE SEQUENCE "v2015".bulk_upload_id_seq START 1;

create table "v2015".bulk_upload_activity
(
 id serial not null,
 bulk_upload_id bigint,
 table_name character varying(100),
 records_processed bigint,
 description text,
  "project_group_code" character varying(8),
  "date_created" timestamp,
  "date_updated" timestamp,
  "user_id" uuid,
  export_id uuid,
  parent_id uuid,
  version integer,
  deleted boolean DEFAULT false, 
  sync boolean DEFAULT false,
     CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES v2015.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT bulk_upload_activity_pk PRIMARY KEY ("id")
);

CREATE TABLE "v2015".hud_coc_report_question_7(
id bigint primary key NOT NULL,
first_name bigint, 
last_name bigint ,
ssn bigint , 
dob bigint , 
race bigint ,
ethnicity bigint ,
gender bigint ,
veteran_status bigint ,
disabling_cond bigint ,
residence_prior_to_entry bigint ,
zip_lpa bigint ,
housing_stat_entry bigint ,
income_entry bigint ,
income_exit bigint ,
non_cash_benefits_entry bigint ,
non_cash_benefits_exit bigint ,
physical_disability_entry bigint ,
devlopmental_disability_entry bigint ,
chronic_health_condition_entry bigint ,
hiv_aids_entry bigint ,
mental_health_entry bigint ,
substance_abuse_entry bigint ,
domestic_violence_entry bigint ,
destination bigint ,
total_clients bigint ,
total_adults bigint ,
total_unaccompanied_youth bigint ,
total_leavers bigint , 
del_flag char(3),
status_flag char(3)
);