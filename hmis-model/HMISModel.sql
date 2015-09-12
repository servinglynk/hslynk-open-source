DROP SEQUENCE IF EXISTS "live".bulk_upload_id_seq;
DROP SEQUENCE IF EXISTS "live".seq_account_preference;
DROP SEQUENCE IF EXISTS "live".seq_api_group;
DROP SEQUENCE IF EXISTS "live".seq_api_method;
DROP SEQUENCE IF EXISTS "live".seq_consent_message;
DROP SEQUENCE IF EXISTS "live".seq_developer_company;
DROP SEQUENCE IF EXISTS "live".seq_developer_company_account;
DROP SEQUENCE IF EXISTS "live".seq_developer_company_status;
DROP SEQUENCE IF EXISTS "live".seq_redirect_uri;
DROP SEQUENCE IF EXISTS "live".seq_refresh_token;
DROP SEQUENCE IF EXISTS "live".seq_request_token;
DROP SEQUENCE IF EXISTS "live".seq_service;
DROP SEQUENCE IF EXISTS "live".seq_service_api_method;
DROP SEQUENCE IF EXISTS "live".seq_service_status;
DROP SEQUENCE IF EXISTS "live".seq_trusted_app;
DROP SEQUENCE IF EXISTS "live".seq_trusted_app_status;
DROP SEQUENCE IF EXISTS "live".seq_verification;

DROP TABLE IF EXISTS "live".hmis_type;
DROP TABLE IF EXISTS "live".path_status;
DROP TABLE IF EXISTS "live".rhybcp_status;
DROP TABLE IF EXISTS "live".last_perm_address;
DROP TABLE IF EXISTS "live".percent_ami;
DROP TABLE IF EXISTS "live".lastgradecompleted;
DROP TABLE IF EXISTS "live".schoolstatus;
DROP TABLE IF EXISTS "live".employment;

DROP TABLE IF EXISTS "live".health_status;
DROP TABLE IF EXISTS "live".affiliation;
DROP TABLE IF EXISTS "live".site;
DROP TABLE IF EXISTS "live".inventory;
DROP TABLE IF EXISTS "live".funder;	
DROP TABLE IF EXISTS "live".enrollment_coc;

DROP TABLE IF EXISTS "live".pathstatus;
DROP TABLE IF EXISTS "live".rhybcpstatus;
DROP TABLE IF EXISTS "live".sexualorientation;
DROP TABLE IF EXISTS "live".formerwardjuvenilejustice;
DROP TABLE IF EXISTS "live".lastpermanentaddress;
DROP TABLE IF EXISTS "live".percentami;
DROP TABLE IF EXISTS "live".medicalassistance;
DROP TABLE IF EXISTS "live".youthcriticalissues;
DROP TABLE IF EXISTS "live".formerwardchildwelfare;
DROP TABLE IF EXISTS "live".referralsource;
DROP TABLE IF EXISTS "live".commercialsexualexploitation;
DROP TABLE IF EXISTS "live".domesticviolence;
DROP TABLE IF EXISTS "live".disabilities;
DROP TABLE IF EXISTS "live".residentialmoveindate;
DROP TABLE IF EXISTS "live".dateofengagement;
DROP TABLE IF EXISTS "live".services;
DROP TABLE IF EXISTS "live".incomeandsources;
DROP TABLE IF EXISTS "live".noncashbenefits;
DROP TABLE IF EXISTS "live".healthinsurance;
DROP TABLE IF EXISTS "live".exithousingassessment;
DROP TABLE IF EXISTS "live".exitplansactions;
DROP TABLE IF EXISTS "live".housingassessmentdisposition;
DROP TABLE IF EXISTS "live".familyreunification;
DROP TABLE IF EXISTS "live".connectionwithsoar;
DROP TABLE IF EXISTS "live".projectcompletionstatus;
DROP  table IF EXISTS  "live".worsthousingsituation;
DROP TABLE IF EXISTS "live".exit;
DROP TABLE IF EXISTS "live".bedinventory;
DROP TABLE IF EXISTS "live".projectcoc;
DROP TABLE IF EXISTS "live".project; 
DROP TABLE IF EXISTS "live".enrollment;
DROP TABLE IF EXISTS "live".organization; 
DROP TABLE IF  EXISTS "live".sync;
DROP TABLE IF EXISTS "live".veteran_info;
DROP TABLE IF EXISTS "live".client;


DROP TABLE IF EXISTS "live".bulk_upload;
DROP TABLE IF EXISTS "live".export; 
DROP TABLE IF EXISTS "live".source;
DROP TABLE IF EXISTS "live".hmis_user;
DROP TABLE IF EXISTS "live".hud_coc_report_question_7;
DROP TABLE IF EXISTS  live.hmis_account_consent;
DROP TABLE IF EXISTS  live.hmis_account_data_change;
DROP TABLE IF EXISTS  live.hmis_account_lockout;
DROP TABLE IF EXISTS  live.hmis_account_preference;
DROP TABLE IF EXISTS  live.hmis_api_group;
DROP TABLE IF EXISTS  live.hmis_api_method;
DROP TABLE IF EXISTS  live.hmis_consent_message;
DROP TABLE IF EXISTS  live.hmis_developer_company;
DROP TABLE IF EXISTS  live.hmis_developer_company_account;
DROP TABLE IF EXISTS  live.hmis_developer_company_status;
DROP TABLE IF EXISTS  live.hmis_notification_header;
DROP TABLE IF EXISTS  live.hmis_password_reset;
DROP TABLE IF EXISTS  live.hmis_permission_set;
DROP TABLE IF EXISTS  live.hmis_permission_set_acl;
DROP TABLE IF EXISTS  live.hmis_profile;
DROP TABLE IF EXISTS  live.hmis_profile_acl;
DROP TABLE IF EXISTS  live.hmis_redirect_uri;
DROP TABLE IF EXISTS  live.hmis_refresh_token;
DROP TABLE IF EXISTS  live.hmis_request_token;
DROP TABLE IF EXISTS  live.hmis_role;
DROP TABLE IF EXISTS  live.hmis_service;
DROP TABLE IF EXISTS  live.hmis_service_api_method;
DROP TABLE IF EXISTS  live.hmis_service_status;
DROP TABLE IF EXISTS  live.hmis_session;
DROP TABLE IF EXISTS  live.hmis_sharing_rule;
DROP TABLE IF EXISTS  live.hmis_trusted_app;
DROP TABLE IF EXISTS  live.hmis_trusted_app_status;
DROP TABLE IF EXISTS  live.hmis_user_permission_set_acl;
DROP TABLE IF EXISTS  live.hmis_user_project;
DROP TABLE IF EXISTS  live.hmis_user_role_map;
DROP TABLE IF EXISTS  live.hmis_verification;
DROP TABLE IF EXISTS  live.hmis_release_of_info;


-- Table: "live"."client"


DROP TYPE IF EXISTS "live".name_data_quality;
DROP TYPE IF EXISTS "live".dob_data_quality;
DROP TYPE IF EXISTS "live".ssn_data_quality;
DROP TYPE IF EXISTS "live".address_data_quality;
DROP TYPE IF EXISTS "live".veteran_status;
DROP TYPE IF EXISTS "live".race;
DROP TYPE IF EXISTS "live".gender;
DROP TYPE IF EXISTS "live".ethnicity;
DROP TYPE IF EXISTS "live".afghanistanoef;
DROP TYPE IF EXISTS "live".desertstorm;
DROP TYPE IF EXISTS "live".asked_forced_exchange_sex;
DROP TYPE IF EXISTS "live".assessment_disposition;
DROP TYPE IF EXISTS "live".availability;
DROP TYPE IF EXISTS "live".bed_type;
DROP TYPE IF EXISTS "live".count_of_exchange_sex;
DROP TYPE IF EXISTS "live".destination;
DROP TYPE IF EXISTS "live".disability_type;
DROP TYPE IF EXISTS "live".discharge_status;
DROP TYPE IF EXISTS "live".early_exit_reason;
DROP TYPE IF EXISTS "live".employment_type;
DROP TYPE IF EXISTS "live".federal_partner_components;
DROP TYPE IF EXISTS "live".five_val_dk_refused;
DROP TYPE IF EXISTS "live".fysb_rsn_not_providing_srvcs;
DROP TYPE IF EXISTS "live".health_category;
DROP TYPE IF EXISTS "live".health_status_type;
DROP TYPE IF EXISTS "live".house_hold_type;
DROP TYPE IF EXISTS "live".housing_assmnt_exit;
DROP TYPE IF EXISTS "live".homeless_atrisk_status;
DROP TYPE IF EXISTS "live".incarcerated_parent_status;	
DROP TYPE IF EXISTS "live".issues_number_of_years;
DROP TYPE IF EXISTS "live".last_grade_completed;
DROP TYPE IF EXISTS "live".military_branch;
DROP TYPE IF EXISTS "live".months_homeless_past_3_years;
DROP TYPE IF EXISTS "live".no_adap_reason;
DROP TYPE IF EXISTS "live".no_health_insurance_reason;
DROP TYPE IF EXISTS "live".no_medical_assistance_reason;
DROP TYPE IF EXISTS "live".not_employed_reason;
DROP TYPE IF EXISTS "live".no_yes;
DROP TYPE IF EXISTS "live".no_yes_refused;
DROP TYPE IF EXISTS "live".path_how_confirmed;	
DROP TYPE IF EXISTS "live".path_smi_info_how_confirmed;
DROP TYPE IF EXISTS "live".percentage_ami;
DROP TYPE IF EXISTS "live".project_completion_status;
DROP TYPE IF EXISTS "live".project_type;
DROP TYPE IF EXISTS "live".reason_not_enrolled;	
DROP TYPE IF EXISTS "live".record_type;
DROP TYPE IF EXISTS "live".referral_outcome;
DROP TYPE IF EXISTS "live".referral_source;
DROP TYPE IF EXISTS "live".relationship_to_head_of_household;
DROP TYPE IF EXISTS "live".residence_prior ;
DROP TYPE IF EXISTS "live".residence_prior_length_of_stay;
DROP TYPE IF EXISTS "live".school_status;
DROP TYPE IF EXISTS "live".sexual_orientation;	
DROP TYPE IF EXISTS "live".subsidy_information;
DROP TYPE IF EXISTS "live".target_population_type;
DROP TYPE IF EXISTS "live".times_homeless_past_3_years;
DROP TYPE IF EXISTS "live".tracking_method;
DROP TYPE IF EXISTS "live".when_dom_violence_occurred;
DROP TYPE IF EXISTS "live".youth_age_group;
DROP TYPE IF EXISTS "live".housing_status;
DROP TYPE IF EXISTS "live".state;



CREATE TYPE "live".name_data_quality AS ENUM ('1', '2', '8','9','99');
CREATE TYPE "live".dob_data_quality AS ENUM ('1', '2', '8','9','99');
CREATE TYPE "live".ssn_data_quality AS ENUM ('1', '2', '8','9','99');
CREATE TYPE "live".address_data_quality AS ENUM ('1', '2', '8','9','99');

CREATE TYPE "live".veteran_status AS ENUM ('0', '1', '8','9','99');
CREATE TYPE "live".race AS ENUM ('1', '2','3','4','5','8','9','99');
CREATE TYPE "live".gender AS ENUM ('1', '2','3','4','8','9','99');
CREATE TYPE "live".ethnicity AS ENUM ('0', '1', '8','9','99');
CREATE TYPE "live".afghanistanoef AS ENUM ('0', '1', '8','9','99');
CREATE TYPE "live".desertstorm AS ENUM ('0', '1', '8','9','99');
CREATE TYPE "live".asked_forced_exchange_sex AS ENUM ('0', '1', '8','9','99');
CREATE TYPE "live".assessment_disposition AS ENUM ('1','2','3','4','5','6','7','8','9','10','11','12','13','14');
CREATE TYPE "live".availability AS ENUM ('1', '2', '3');
CREATE TYPE "live".bed_type AS ENUM ('1', '2', '3');
CREATE TYPE "live".count_of_exchange_sex AS ENUM ('1', '2', '3','4','8','9');
CREATE TYPE "live".destination AS ENUM 
('24','1','15','6','14','7','25','26','27','11','21','3','16','4','10','19','28','20','29','18','22','12','23','13','5','2','17','30','8','9','99');
CREATE TYPE "live".disability_type AS ENUM ('5','6','7','8','9','10');
CREATE TYPE "live".discharge_status AS ENUM ('1','2','4','5','6','7','8','9','99');
CREATE TYPE "live".early_exit_reason AS ENUM ('1','2','3','4','5','99');
CREATE TYPE "live".employment_type AS ENUM ('1','2','3','99');
CREATE TYPE "live".federal_partner_components AS ENUM 
('1','2','3','4','5','6','7','8','9','10','11','12','13','14','15','16','17','18','19','20','21','22','23','24','25','26','27','28','29','30','31','32','33','34');
CREATE TYPE "live".five_val_dk_refused AS ENUM ('0','1','8','9','99');
CREATE TYPE "live".fysb_rsn_not_providing_srvcs AS ENUM ('1','2','3','4','99');
CREATE TYPE "live".health_category AS ENUM ('27','28','29');
CREATE TYPE "live".health_status_type AS ENUM ('1', '2','3','4','5','8','9','99');
CREATE TYPE "live".house_hold_type AS ENUM ('1','3','5');
CREATE TYPE "live".housing_assmnt_exit AS ENUM ('1','2','3','4','5','6','7','8','9','10','99');
CREATE TYPE "live".homeless_atrisk_status AS ENUM ('1','2','3','4','5','6','8','9','99');

CREATE TYPE "live".incarcerated_parent_status AS ENUM ('1','2','3','99');	
CREATE TYPE "live".issues_number_of_years AS ENUM ('1','2','3');
CREATE TYPE "live".last_grade_completed  AS ENUM ('1','2','3','4','5','6','7','10','8','9','99');
CREATE TYPE "live".military_branch AS ENUM ('1','2','3','4','6','8','9','99');
CREATE TYPE "live".months_homeless_past_3_years AS ENUM ('100','7','8','9','99');
CREATE TYPE "live".no_adap_reason AS ENUM ('1','2','3','4','8','9','99');
CREATE TYPE "live".no_health_insurance_reason AS ENUM ('1','2','3','4','8','9','99');
CREATE TYPE "live".no_medical_assistance_reason AS ENUM (	
'1',
'2',
'3',
'4',
'8',
'9',
'99');
CREATE TYPE "live".not_employed_reason  AS ENUM (	
'1',
'2',
'3',
'99');
CREATE TYPE "live".no_yes  AS ENUM (	
'0',
'1',
'99');
CREATE TYPE "live".no_yes_refused AS ENUM (
'0',
'1',
'9',
'99');
CREATE TYPE "live".path_how_confirmed AS ENUM (	
'1',
'2',
'3',
'99');
CREATE TYPE "live".path_smi_info_how_confirmed AS ENUM (	
'0',
'1',
'2',
'3',
'8',
'9',
'99');
CREATE TYPE "live".percentage_ami AS ENUM (	
'1',
'2',
'3',
'99');

CREATE TYPE "live".project_completion_status AS ENUM (	
'1',
'2',
'3',
'99');

CREATE TYPE "live".project_type AS ENUM (
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
CREATE TYPE "live".reason_not_enrolled AS ENUM (	
'1',
'2',
'99');
CREATE TYPE "live".record_type AS ENUM (	
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

CREATE TYPE "live".referral_outcome AS ENUM (	
'1',
'2',
'3');
CREATE TYPE "live".referral_source AS ENUM (	
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

CREATE TYPE "live".relationship_to_head_of_household AS ENUM (
'1',
'2',
'3',
'4',
'5');
CREATE TYPE "live".residence_prior  AS ENUM (	
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

CREATE TYPE "live".residence_prior_length_of_stay AS ENUM (	
'2',
'3',
'4',
'5',
'8',
'9',
'10',
'11',
'99');
CREATE TYPE "live".school_status AS ENUM (	
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
CREATE TYPE "live".sexual_orientation AS ENUM (	
'1',
'2',
'3',
'4',
'5',
'8',
'9',
'99');
CREATE TYPE "live".subsidy_information  AS ENUM (
'1',
'2',
'3',
'4');
CREATE TYPE "live".target_population_type  AS ENUM ( 	
'1',
'3',
'4');

CREATE TYPE "live".times_homeless_past_3_years  AS ENUM (
'0',
'1',
'2',
'3',
'4',
'8',
'9',
'99');

CREATE TYPE "live".tracking_method  AS ENUM ( 	
'0',
'3');
CREATE TYPE "live".when_dom_violence_occurred AS ENUM (
'1',
'2',
'3',
'4',
'8',
'9',
'99');
CREATE TYPE "live".youth_age_group  AS ENUM (	
'1',
'2',
'3');

CREATE TYPE "live".housing_status AS ENUM (
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

CREATE TYPE "live".state AS ENUM (
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

-- DROP TABLE "live"."base_metadata";


-- DROP TABLE "live"."client";
CREATE TABLE live.hmis_user
(
  id uuid NOT NULL,
  first_name character(50),
  middle_name character(50),
  last_name character(50),
  name_suffix character(50),
  ssn character(9),
  dob date,
  gender live.gender,
  date_created date,
  date_updated date,
  CONSTRAINT hmis_user_pk PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);


 
CREATE TABLE "live".hmis_type
(
  "id" serial NOT NULL ,
  "name" character(50) NOT NULL,
  "value" character(50) NOT NULL,
  "description" character(50),
  "status" character(10),
  "expiration_date" date,
  "date_created" date,
  "date_updated" date,
  "user_id" uuid,
  CONSTRAINT hmis_type_pk PRIMARY KEY ("id"),
   CONSTRAINT hmis_user_fkey FOREIGN KEY (user_id)
      REFERENCES live.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);


INSERT INTO "live".hmis_type (name,value,description,status) values ('dobdataquality','1','Full DOB reported','ACTIVE');
INSERT INTO "live".hmis_type (name,value,description,status) values   ('dobdataquality','2','Approximate or partial DOB reported','ACTIVE');
INSERT INTO "live".hmis_type (name,value,description,status) values    ('dobdataquality','8','Client does not know','ACTIVE');
INSERT INTO "live".hmis_type  (name,value,description,status) values  ('dobdataquality','9','Client refused','ACTIVE');
INSERT INTO "live".hmis_type  (name,value,description,status) values ('dobdataquality','99','Data not collected','ACTIVE');


INSERT INTO "live".hmis_type (name,value,description,status)  values ('race','1','American Indian or Alaska Native','ACTIVE');
INSERT INTO "live".hmis_type (name,value,description,status)  values ('race','2','Asian','ACTIVE');
INSERT INTO "live".hmis_type (name,value,description,status)  values ('race','3','Black or African American','ACTIVE');
INSERT INTO "live".hmis_type (name,value,description,status)  values ('race','4','Native Hawaiian or Other Pacific Islander','ACTIVE');
INSERT INTO "live".hmis_type (name,value,description,status)  values ('race','5','White','ACTIVE');
INSERT INTO "live".hmis_type (name,value,description,status)  values ('race','8','Client does not know','ACTIVE');
INSERT INTO "live".hmis_type (name,value,description,status)  values ('race','9','Client refused','ACTIVE');
INSERT INTO "live".hmis_type (name,value,description,status)  values ('race','99','Data not collected','ACTIVE');

INSERT INTO "live".hmis_type (name,value,description,status)  values ('gender','1','Male','ACTIVE');
INSERT INTO "live".hmis_type (name,value,description,status)  values ('gender','2','Transgender male to female','ACTIVE');
INSERT INTO "live".hmis_type (name,value,description,status)  values ('gender','3','Transgender female to male','ACTIVE');
INSERT INTO "live".hmis_type (name,value,description,status)  values ('gender','4','Other','ACTIVE');
INSERT INTO "live".hmis_type (name,value,description,status)  values ('gender','8','Client does not know','ACTIVE');
INSERT INTO "live".hmis_type (name,value,description,status)  values ('gender','9','Client refused','ACTIVE');
INSERT INTO "live".hmis_type (name,value,description,status)  values ('gender','99','Data not collected','ACTIVE');

INSERT INTO "live".hmis_type (name,value,description,status) values ('namedataquality','1','Full name reported','ACTIVE');
INSERT INTO "live".hmis_type (name,value,description,status) values   ('namedataquality','2','Partial, street name, or code name reported','ACTIVE');
INSERT INTO "live".hmis_type (name,value,description,status) values    ('namedataquality','8','Client does not know','ACTIVE');
INSERT INTO "live".hmis_type  (name,value,description,status) values  ('namedataquality','9','Client refused','ACTIVE');
INSERT INTO "live".hmis_type  (name,value,description,status) values ('namedataquality','99','Data not collected','ACTIVE');

INSERT INTO "live".hmis_type (name,value,description,status) values ('ssndataquality','1','Full SSN reported','ACTIVE');
INSERT INTO "live".hmis_type (name,value,description,status) values   ('ssndataquality','2','Approximate or partial SSN reported','ACTIVE');
INSERT INTO "live".hmis_type (name,value,description,status) values    ('ssndataquality','8','Client does not know','ACTIVE');
INSERT INTO "live".hmis_type  (name,value,description,status) values  ('ssndataquality','9','Client refused','ACTIVE');
INSERT INTO "live".hmis_type  (name,value,description,status) values ('ssndataquality','99','Data not collected','ACTIVE');

INSERT INTO "live".hmis_type (name,value,description,status) values ('ethnicity','0','Non-Hispanic/Non-Latino','ACTIVE');
INSERT INTO "live".hmis_type (name,value,description,status) values ('ethnicity','1','Hispanic/Latino','ACTIVE');
INSERT INTO "live".hmis_type (name,value,description,status) values    ('ethnicity','8','Client does not know','ACTIVE');
INSERT INTO "live".hmis_type  (name,value,description,status) values  ('ethnicity','9','Client refused','ACTIVE');
INSERT INTO "live".hmis_type  (name,value,description,status) values ('ethnicity','99','Data not collected','ACTIVE');

INSERT INTO "live".hmis_type (name,value,description,status) values ('veteran_status','0','No','ACTIVE');
INSERT INTO "live".hmis_type (name,value,description,status) values ('veteran_status','1','Yes','ACTIVE');
INSERT INTO "live".hmis_type (name,value,description,status) values    ('veteran_status','8','Client does not know','ACTIVE');
INSERT INTO "live".hmis_type  (name,value,description,status) values  ('veteran_status','9','Client refused','ACTIVE');
INSERT INTO "live".hmis_type  (name,value,description,status) values ('veteran_status','99','Data not collected','ACTIVE');


INSERT INTO "live".hmis_type (name,value,description,status) values ('afghanistanoef','0','No','ACTIVE');
INSERT INTO "live".hmis_type (name,value,description,status) values ('afghanistanoef','1','Yes','ACTIVE');
INSERT INTO "live".hmis_type (name,value,description,status) values    ('afghanistanoef','8','Client does not know','ACTIVE');
INSERT INTO "live".hmis_type  (name,value,description,status) values  ('afghanistanoef','9','Client refused','ACTIVE');
INSERT INTO "live".hmis_type  (name,value,description,status) values ('afghanistanoef','99','Data not collected','ACTIVE');

create table "live".source
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
  "date_created" date,
  "date_updated" date,
  "user_id" uuid,
  constraint "source_pkey" primary key (id),
         CONSTRAINT hmis_user_fkey FOREIGN KEY (user_id)
      REFERENCES live.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
     )
with (
  oids=false
);

create table "live".export
(
  id uuid not null,
  export_date  date,
  start_date  date,
  end_date  date,
  exportPeriodType text,
  exportDirective text,
  source_id uuid,
  "date_created" date,
  "date_updated" date,
  "user_id" uuid,
  constraint "export_pkey" primary key (id),
         CONSTRAINT hmis_user_fkey FOREIGN KEY (user_id)
      REFERENCES live.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
      CONSTRAINT source_fkey FOREIGN KEY (source_id)
      REFERENCES live.source (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
     )
with (
  oids=false
);

-- DROP TABLE "live"."client";
CREATE TABLE "live".client
(
  "id" uuid NOT NULL,
  "dedup_client_id" uuid,
  "first_name" character(50),
  "middle_name" character(50),
  "last_name" character(50),
  "name_suffix" character(50),
  "name_data_quality" "live".name_data_quality,
   "ssn" character(9),
  "ssn_data_quality" "live".ssn_data_quality,
  "dob" date,
  "dob_data_quality" "live".dob_data_quality,
  "gender" "live".gender,
  "other_gender" character(10),
  "ethnicity" "live".ethnicity,
  "race"  "live".race,
  "veteran_status" "live".veteran_status,
  "date_created" date,
  "date_updated" date,
  "user_id" uuid,
   export_id uuid,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES live.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT client_pk PRIMARY KEY ("id"),
   CONSTRAINT hmis_user_fkey FOREIGN KEY (user_id)
      REFERENCES live.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
      )
WITH (
  OIDS=FALSE
);
-- Table: "live"."client"


CREATE TABLE "live".veteran_info
(
  "id" uuid NOT NULL,
  "year_entrd_service" integer,
  "year_seperated" integer,
  "world_war_2" "live".five_val_dk_refused,
  "korean_war" "live".five_val_dk_refused,
  "vietnam_war" "live".five_val_dk_refused,
  "desert_storm" "live".five_val_dk_refused,
  "afghanistan_oef" "live".afghanistanoef,
  "iraq_oif" "live".five_val_dk_refused,
  "iraq_ond" "live".five_val_dk_refused,
  "other_theater" "live".five_val_dk_refused,
  "military_branch" "live".military_branch,
  "discharge_status" "live".discharge_status,
  "date_created" date,
  "date_updated" date,
  "user_id" uuid,
  "client_id" uuid,
  export_id uuid,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES live.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT veteran_info_pk PRIMARY KEY ("id"),
  CONSTRAINT veteran_info_client_fk FOREIGN KEY ("client_id")
      REFERENCES "live".client ("id"),
   CONSTRAINT hmis_user_fkey FOREIGN KEY (user_id)
      REFERENCES live.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);

CREATE TABLE "live".enrollment
(
  id uuid NOT NULL,
 continuouslyHomelessOneYear "live".youth_age_group,
disablingCondition "live".five_val_dk_refused,
entrydate date,
householdid uuid,
housingstatus "live".housing_status,
monthsHomelessPastThreeYears "live".months_homeless_past_3_years,
monthsHomelessThisTime "live".times_homeless_past_3_years,
otherresidenceprior character varying(50),
personalid uuid,
projectentryid uuid,
projectid uuid,
relationshiptohoh "live".relationship_to_head_of_household,
residencePrior "live".residence_prior,
residencePriorlengthofstay "live".residence_prior_length_of_stay,
statusDocumented "live".no_yes,
timesHomelesspastthreeyears "live".times_homeless_past_3_years,
yearshomeless integer,
client_id uuid,
date_created date,
date_updated date,
user_id uuid,
export_id uuid,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES live.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "enrollment_pkey" PRIMARY KEY (id),
    CONSTRAINT enrollment_client_fk FOREIGN KEY ("client_id")
      REFERENCES "live".client ("id"),
 CONSTRAINT hmis_user_fkey FOREIGN KEY (user_id)
      REFERENCES live.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);


CREATE TABLE "live".path_status
(
  "id" uuid NOT NULL,
  "date_of_status" date,
  "client_enrolled_in_path" bigint,
  "reason_not_enrolled" bigint,
  "enrollmentid" uuid,
  "date_created" date,
  "date_updated" date,
  "user_id" uuid,
  export_id uuid,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES live.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT path_status_pk PRIMARY KEY ("id"),
   CONSTRAINT "enrollment_path_status_fk_key" FOREIGN KEY ("enrollmentid")
      REFERENCES live.enrollment ("id") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
   CONSTRAINT hmis_user_fkey FOREIGN KEY (user_id)
      REFERENCES live.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);



CREATE TABLE "live".rhybcp_status
(
  "id" uuid NOT NULL,
  "status_date" date,
  "fysb_youth" "live".no_yes,
  "reason_no_services" "live".fysb_rsn_not_providing_srvcs,
  "enrollmentid" uuid,
  "date_created" date,
  "date_updated" date,
  "user_id" uuid,
  export_id uuid,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES live.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT rhybcp_status_pk PRIMARY KEY ("id"),
   CONSTRAINT "enrollment_rhybcp_status_fk_key" FOREIGN KEY ("enrollmentid")
      REFERENCES live.enrollment ("id") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
   CONSTRAINT hmis_user_fkey FOREIGN KEY (user_id)
      REFERENCES live.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);

-- Table: live.last_perm_address



CREATE TABLE "live".last_perm_address
(
  "id" uuid NOT NULL,
  "street" text,
  "city" text,
  "state" "live".state,
  "zip" character(10),
  "address_data_quality" "live".address_data_quality,
  "enrollmentid" uuid,
  "date_created" date,
  "date_updated" date,
  "user_id" uuid,
  export_id uuid,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES live.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT last_perm_address_pk PRIMARY KEY ("id"),
   CONSTRAINT "enrollment_last_perm_address_fk_key" FOREIGN KEY ("enrollmentid")
      REFERENCES live.enrollment ("id") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
   CONSTRAINT hmis_user_fkey FOREIGN KEY (user_id)
      REFERENCES live.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);

-- Table: live.percent_ami



CREATE TABLE "live".percent_ami
(
 "id" uuid NOT NULL,
  "percentage" integer,
  "enrollmentid" uuid,
  "date_created" date,
  "date_updated" date,
  "user_id" uuid,
  export_id uuid,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES live.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT percent_ami_pk PRIMARY KEY ("id"),
   CONSTRAINT "enrollment_percent_ami_fk_key" FOREIGN KEY ("enrollmentid")
      REFERENCES live.enrollment ("id") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
   CONSTRAINT hmis_user_fkey FOREIGN KEY (user_id)
      REFERENCES live.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
-- Table: live.last_grade_completed

CREATE TABLE "live".schoolstatus
(
  "id" uuid NOT NULL,
  "information_date" date,
  "school_status" integer,
  "enrollmentid" uuid,
  "date_created" date,
  "date_updated" date,
  "user_id" uuid,
  export_id uuid,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES live.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT school_status_pk PRIMARY KEY ("id"),
   CONSTRAINT "enrollment_schoolstatus_fk_key" FOREIGN KEY ("enrollmentid")
      REFERENCES live.enrollment ("id") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
   CONSTRAINT hmis_user_fkey FOREIGN KEY (user_id)
      REFERENCES live.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);


CREATE TABLE "live".employment
(
  "id" uuid NOT NULL,
  "information_date" date,
  "employed" "live".five_val_dk_refused,
  "employment_type" "live".employment_type,
  "not_employed_reason" "live".not_employed_reason,
  "enrollmentid" uuid,
  "date_created" date,
  "date_updated" date,
  "user_id" uuid,
  export_id uuid,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES live.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT employment_pk PRIMARY KEY ("id"),
   CONSTRAINT "enrollment_coc_employment_fk_key" FOREIGN KEY ("enrollmentid")
      REFERENCES live.enrollment ("id") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
   CONSTRAINT hmis_user_fkey FOREIGN KEY (user_id)
      REFERENCES live.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);


CREATE TABLE "live".health_status
(
  "id" uuid NOT NULL,
  "enrollmentid" uuid,
  "information_date" date,
  "health_category" "live".health_category,
  "health_status" "live".health_status_type,
  "due_date" date,
  "date_created" date,
  "date_updated" date,
  "user_id" uuid,
  export_id uuid,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES live.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT health_status_pk PRIMARY KEY ("id"),
     CONSTRAINT "enrollment_health_status_fk_key" FOREIGN KEY ("enrollmentid")
      REFERENCES live.enrollment ("id") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
   CONSTRAINT hmis_user_fkey FOREIGN KEY (user_id)
      REFERENCES live.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);

create table "live".organization
(
  organizationcommonname character varying(32),
  id uuid not null,
  organizationname character varying(32),
   "date_created" date,
  "date_updated" date,
  "user_id" uuid,
  export_id uuid,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES live.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  constraint "organization_pkey" primary key (id),
      CONSTRAINT hmis_user_fkey FOREIGN KEY (user_id)
      REFERENCES live.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
with (
  oids=false
);


CREATE TABLE  "live".project
(
  id uuid NOT NULL,
  "enrollmentid" uuid,
  continuumproject "live".no_yes,
  organizationid uuid,
  projectcommonname character varying(32),
  projectname character varying(32),
  projecttype "live".project_type,
  residentialaffiliation "live".no_yes,
  targetpopulation "live".target_population_type,
  trackingmethod "live".tracking_method,
   "date_created" date,
  "date_updated" date,
  "user_id" uuid,
  export_id uuid,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES live.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "project_pk" PRIMARY KEY (id),
       CONSTRAINT "enrollment_project_fk_key" FOREIGN KEY ("enrollmentid")
      REFERENCES live.enrollment ("id") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
        CONSTRAINT "organization_project_fkey" FOREIGN KEY (organizationid)
      REFERENCES live.organization (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
   CONSTRAINT hmis_user_fkey FOREIGN KEY (user_id)
      REFERENCES live.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);


-- Table: "affiliation"

-- DROP TABLE "affiliation";

CREATE TABLE "live".affiliation
(
  id uuid NOT NULL,
  projectid uuid,
  resprojectid character varying(32),
   "date_created" date,
  "date_updated" date,
  "user_id" uuid,
  export_id uuid,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES live.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "affiliation_pkey" PRIMARY KEY (id),
  CONSTRAINT "affiliation_project_fkey" FOREIGN KEY (projectid)
      REFERENCES live.project (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
   CONSTRAINT hmis_user_fkey FOREIGN KEY (user_id)
      REFERENCES live.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);



CREATE TABLE "live".bedinventory
(
  id uuid NOT NULL,
  bed_inventory integer,
  ch_bed_inventory integer,
  vet_bed_inventory integer,
  youth_age_group "live".youth_age_group,
  youth_bed_inventory bigint,
   "date_created" date,
  "date_updated" date,
  "user_id" uuid,
  export_id uuid,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES live.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "bedinventory_pkey" PRIMARY KEY (id),
 CONSTRAINT hmis_user_fkey FOREIGN KEY (user_id)
      REFERENCES live.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);

-- table: "projectcoc"

-- drop table "projectcoc";

create table "live".projectcoc
(
  id uuid not null,
  coccode character varying(32),
  projectid uuid,
   date_created date,
date_updated date,
user_id uuid,
export_id uuid,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES live.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  constraint "projectcoc_pkey" primary key (id),
  constraint "projectcoc_projectid_fkey" foreign key (projectid)
      references live.project (id) match simple,
  CONSTRAINT "hmis_user_fkey" FOREIGN KEY (user_id)
      REFERENCES live.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
with (
  oids=false
);
CREATE TABLE "live".enrollment_coc
(
  id uuid NOT NULL,
  project_co_id uuid,
  enrollmentid uuid,
  coc_code character(20),
  date_created date,
date_updated date,
user_id uuid,
export_id uuid,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES live.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
 CONSTRAINT "enrollment_coc_pkey" PRIMARY KEY ("id"),
  CONSTRAINT "enrollment_coc_project_co_fk_key" FOREIGN KEY ("enrollmentid")
      REFERENCES live.enrollment ("id") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
   CONSTRAINT "project_coc_enrollment_coc_fkey" FOREIGN KEY ("project_co_id")
      REFERENCES live.projectcoc ("id") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
 CONSTRAINT "hmis_user_fkey" FOREIGN KEY (user_id)
      REFERENCES live.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);


create table "live".site
(
id uuid not null,
address character varying(100),
city  character varying(50),
geocode  integer, 
principal_site "live".no_yes,
project_coc_id uuid,
state "live".state, 
zip text,
date_created date,
date_updated date,
user_id uuid,
export_id uuid,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES live.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
constraint "site_pkey" primary key (id),
  constraint "site_projectcoc_fkey" foreign key (project_coc_id)
      references live."projectcoc" (id) match simple
      on update no action on delete no action,
       CONSTRAINT hmis_user_fkey FOREIGN KEY (user_id)
      REFERENCES live.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
with (
  oids=false
);



create table "live".inventory
(
   id uuid not null,
  availabilty "live".availability,
  bedinventory uuid,
  bedtype "live".bed_type,
  hmisparticipatingbeds integer,
  householdtype "live".house_hold_type,
  inventoryenddate date,
  inventorystartdate date,
  project_coc_id uuid,
  unitinventory integer,
  date_created date,
date_updated date,
user_id uuid,
export_id uuid,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES live.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  constraint "inventory_pkey" primary key (id),
  constraint "inventory_projectcocid_fkey" foreign key (project_coc_id)
      references live."projectcoc" (id) match simple
      on update no action on delete no action,
      CONSTRAINT "bed_inventory_fkey" FOREIGN KEY (bedinventory)
      REFERENCES live.bedinventory (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
        CONSTRAINT hmis_user_fkey FOREIGN KEY (user_id)
      REFERENCES live.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
with (
  oids=false
);


-- table: "funder"

-- drop table "funder";

create table  "live".funder
(
"id"  uuid not null,
  "enddate" date,
  "funder" "live".federal_partner_components,
  "grantid" uuid,
  "projectid" uuid,
  "startdate" date,
  date_created date,
date_updated date,
user_id uuid,
export_id uuid,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES live.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  constraint "funder_pkey" primary key ("id"),
  constraint "funder_projectid_fkey" foreign key ("projectid")
      references live.project (id) match simple
      on update no action on delete no action,
        CONSTRAINT hmis_user_fkey FOREIGN KEY (user_id)
      REFERENCES live.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
with (
  oids=false
);


-- table: "pathstatus"

-- drop table "pathstatus";

create table "live".pathstatus
(
  clientenrolledinpath "live".no_yes,
  dateofstatus date,
  id uuid not null,
  enrollmentid uuid,
  reasonnotenrolled "live".reason_not_enrolled,
   "date_created" date,
  "date_updated" date,
  "user_id" uuid,
  export_id uuid,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES live.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  constraint "pathstatus_pkey" primary key (id),
  constraint "pathstatus_enrollmentid_fkey" foreign key (enrollmentid)
      references live.enrollment ("id") match simple
      on update no action on delete no action,
            CONSTRAINT hmis_user_fkey FOREIGN KEY (user_id)
      REFERENCES live.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
with (
  oids=false
);


create table "live".rhybcpstatus
(
  id uuid not null,
  fysbyouth integer,
  enrollmentid uuid,
  reasonnoservices integer,
  statusdate date,
     "date_created" date,
  "date_updated" date,
  "user_id" uuid,
  export_id uuid,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES live.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  constraint "rhybcpstatus_pkey" primary key (id),
  constraint "rhybcpstatus_enrollmentid_fkey" foreign key (enrollmentid)
      references live.enrollment ("id") match simple
      on update no action on delete no action,
                  CONSTRAINT hmis_user_fkey FOREIGN KEY (user_id)
      REFERENCES live.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
with (
  oids=false
);


-- table: "sexualorientation"

-- drop table "sexualorientation";

create table "live".sexualorientation
(
  id uuid not null,
  enrollmentid uuid,
  sexualorientation "live".sexual_orientation,
  "date_created" date,
  "date_updated" date,
  "user_id" uuid,
  export_id uuid,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES live.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  constraint "sexualorientation_pkey" primary key (id),
  constraint "sexualorientation_enrollmentid_fkey" foreign key (enrollmentid)
      references live.enrollment ("id") match simple
      on update no action on delete no action,
                  CONSTRAINT hmis_user_fkey FOREIGN KEY (user_id)
      REFERENCES live.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
with (
  oids=false
);

create table "live".formerwardjuvenilejustice
(
"id" uuid not null,
  "formerwardjuvenilejustice" "live".five_val_dk_refused,
  "juvenilejusticemonths" integer,
  "juvenilejusticeyears"  "live".issues_number_of_years,
  "enrollmentid" uuid,
   "date_created" date,
  "date_updated" date,
  "user_id" uuid,
  export_id uuid,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES live.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  constraint "formerwardjuvenilejustice_pkey" primary key ("id"),
  constraint "formerwardjuvenilejustice_enrollmentid_fkey" foreign key ("enrollmentid")
      references live.enrollment ("id") match simple
      on update no action on delete no action,
                    CONSTRAINT hmis_user_fkey FOREIGN KEY (user_id)
      REFERENCES live.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
with (
  oids=false
);

create table "live".lastpermanentaddress
(
  id uuid not null,
  addressdataquality integer,
  lastpermanentcity character varying(50),
  lastpermanentstate "live".state,
  lastpermanentstreet character varying(100),
  lastpermanentzip character varying(32),
  enrollmentid uuid,
   "date_created" date,
  "date_updated" date,
  "user_id" uuid,
  export_id uuid,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES live.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  constraint "lastpermanentaddress_pkey" primary key (id),
  constraint "lastpermanentaddress_enrollmentid_fkey" foreign key (enrollmentid)
      references live.enrollment ("id") match simple
      on update no action on delete no action,
                    CONSTRAINT hmis_user_fkey FOREIGN KEY (user_id)
      REFERENCES live.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
with (
  oids=false
);

create table "live".percentami
(
  percentami integer,
  id uuid not null,
  enrollmentid uuid,
     "date_created" date,
  "date_updated" date,
  "user_id" uuid,
  export_id uuid,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES live.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  constraint "percentami_pkey" primary key (id),
  constraint "percentami_enrollmentid_fkey" foreign key (enrollmentid)
      references live.enrollment ("id") match simple
      on update no action on delete no action,
   CONSTRAINT hmis_user_fkey FOREIGN KEY (user_id)
      REFERENCES live.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
with (
  oids=false
);

-- table: "medicalassistance"

-- drop table "medicalassistance";

create table "live".medicalassistance
(
  adap "live".five_val_dk_refused,
  hivaidsassistance "live".five_val_dk_refused,
  id uuid not null,
  noadapreason "live".no_medical_assistance_reason,
  nohivaidsassistancereason "live".no_medical_assistance_reason,
   enrollmentid uuid,
     "date_created" date,
  "date_updated" date,
  "user_id" uuid,
  export_id uuid,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES live.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  constraint "medicalassistance_pkey" primary key (id),
  constraint "medicalassistance_enrollmentid_fkey" foreign key (enrollmentid)
      references live.enrollment ("id") match simple
      on update no action on delete no action,
         CONSTRAINT hmis_user_fkey FOREIGN KEY (user_id)
      REFERENCES live.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
      
)
with (
  oids=false
);



create table "live".youthcriticalissues
(
  abuseandneglectfam "live".no_yes,
  abuseandneglectyouth "live".no_yes,
  activemilitaryparent "live".no_yes,
  alcoholdrugabusefam "live".no_yes,
  alcoholdrugabuseyouth "live".no_yes,
  healthissuesfam "live".no_yes,
  healthissuesyouth "live".no_yes,
  householddynamics "live".no_yes,
  housingissuesfam "live".no_yes,
  housingissuesyouth "live".no_yes,
  incarceratedparent "live".no_yes,
  incarceratedparentstatus  "live".incarcerated_parent_status,
  insufficientincome "live".no_yes,
  mentaldisabilityfam "live".no_yes,
  mentaldisabilityyouth "live".no_yes,
  mentalhealthissuesfam "live".no_yes,
  mentalhealthissuesyouth "live".no_yes,
  physicaldisabilityfam "live".no_yes,
  physicaldisabilityyouth "live".no_yes,
  enrollmentid uuid,
  schooleducationalissuesfam "live".no_yes,
  schooleducationalissuesyouth "live".no_yes,
  sexualorientationgenderidfam "live".no_yes,
  sexualorientationgenderidyouth "live".no_yes,
  unemploymentfam "live".no_yes,
  unemploymentyouth "live".no_yes,
  id uuid not null,
     "date_created" date,
  "date_updated" date,
  "user_id" uuid,
  export_id uuid,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES live.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  constraint "youthcriticalissues_pkey" primary key (id),
  constraint "youthcriticalissues_enrollmentid_fkey" foreign key (enrollmentid)
      references live.enrollment ("id") match simple
      on update no action on delete no action,
       CONSTRAINT hmis_user_fkey FOREIGN KEY (user_id)
      REFERENCES live.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
with (
  oids=false
);

-- table: "worsthousingsituation"

-- drop table "worsthousingsituation";

create table  "live".worsthousingsituation
(
  enrollmentid uuid,
  worsthousingsituation "live".five_val_dk_refused,
  id uuid not null,
      "date_created" date,
  "date_updated" date,
  "user_id" uuid,
  export_id uuid,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES live.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  constraint "worsthousingsituation_pkey" primary key (id),
  constraint "worsthousingsituation_enrollmentid_fkey" foreign key (enrollmentid)
      references live.enrollment ("id") match simple
      on update no action on delete no action,
       CONSTRAINT hmis_user_fkey FOREIGN KEY (user_id)
      REFERENCES live.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
with (
  oids=false
);

create table "live".formerwardchildwelfare
(
  "childwelfaremonths" integer,
  "childwelfareyears" "live".issues_number_of_years,
  "formerwardchildwelfare" "live".five_val_dk_refused,
  "id" uuid not null,
  "enrollmentid" uuid,
     "date_created" date,
  "date_updated" date,
  "user_id" uuid,
  export_id uuid,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES live.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  constraint "formerwardchildwelfare_pkey" primary key ("id"),
  constraint "formerwardchildwelfare_enrollmentid_fkey" foreign key ("enrollmentid")
      references live.enrollment ("id") match simple
      on update no action on delete no action,
          CONSTRAINT hmis_user_fkey FOREIGN KEY (user_id)
      REFERENCES live.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
with (
  oids=false
);


-- drop table "lastgradecompleted";

create table "live".lastgradecompleted
(
  lastgradecompleted "live".last_grade_completed,
  id uuid not null,
  enrollmentid uuid,
       "date_created" date,
  "date_updated" date,
  "user_id" uuid,
  export_id uuid,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES live.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  constraint "lastgradecompleted_pkey" primary key (id),
  constraint "lastgradecompleted_enrollmentid_fkey" foreign key (enrollmentid)
      references live.enrollment ("id") match simple
      on update no action on delete no action,
                CONSTRAINT hmis_user_fkey FOREIGN KEY (user_id)
      REFERENCES live.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
with (
  oids=false
);


create table "live".referralsource
(
  countoutreachreferralapproaches integer,
  enrollmentid uuid,
  referralsource "live".referral_source,
  id uuid not null,
       "date_created" date,
  "date_updated" date,
  "user_id" uuid,
  export_id uuid,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES live.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  constraint "referralsource_pkey" primary key (id),
  constraint "referralsource_enrollmentid_fkey" foreign key (enrollmentid)
      references live.enrollment ("id") match simple
      on update no action on delete no action,
                 CONSTRAINT hmis_user_fkey FOREIGN KEY (user_id)
      REFERENCES live.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
with (
  oids=false
);


create table "live".commercialsexualexploitation
(
  "askedorforcedtoexchangeforsex" "live".asked_forced_exchange_sex,
  "id" uuid not null,
  "countofexchangeforsex" "live".count_of_exchange_sex,
  "exchangeforsexpastthreemonths" "live".five_val_dk_refused,
   enrollmentid uuid,
   "date_created" date,
  "date_updated" date,
  "user_id" uuid,
  export_id uuid,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES live.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  constraint "commercialsexualexploitation_pkey" primary key ("id"),
  constraint "commercialsexualexploitation_enrollmentid_fkey" foreign key ("enrollmentid")
      references live.enrollment ("id") match simple
      on update no action on delete no action,
                 CONSTRAINT hmis_user_fkey FOREIGN KEY (user_id)
      REFERENCES live.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
with (
  oids=false
);

-- table: "domesticviolence"

-- drop table "domesticviolence";

create table "live".domesticviolence
(
  "id"  uuid not null,
  "domesticviolencevictim" "live".five_val_dk_refused,
  "enrollmentid" uuid,
  "whenoccurred" "live".when_dom_violence_occurred,
       "date_created" date,
  "date_updated" date,
  "user_id" uuid,
  export_id uuid,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES live.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  constraint "domesticviolence_pkey" primary key ("id"),
  constraint "domesticviolence_enrollmentid_fkey" foreign key ("enrollmentid")
      references live.enrollment ("id") match simple
      on update no action on delete no action,
                 CONSTRAINT hmis_user_fkey FOREIGN KEY (user_id)
      REFERENCES live.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
with (
  oids=false
);

-- table: "disabilities"

-- drop table "disabilities";

create table "live".disabilities
(
  "id" uuid not null,
  "disabilityresponse" integer,
  "disabilitytype" "live".disability_type,
  "documentationonfile" "live".no_yes,
  "indefiniteandimpairs" "live".five_val_dk_refused,
  "pathhowconfirmed" "live".path_how_confirmed,
  "pathsmiinformation" "live".path_smi_info_how_confirmed,
   "enrollmentid" uuid,
  "receivingservices" "live".five_val_dk_refused,
         "date_created" date,
  "date_updated" date,
  "user_id" uuid,
  export_id uuid,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES live.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  constraint "disabilities_pkey" primary key ("id"),
  constraint "disabilities_enrollmentid_fkey" foreign key ("enrollmentid")
      references live.enrollment ("id") match simple
      on update no action on delete no action,
                CONSTRAINT hmis_user_fkey FOREIGN KEY (user_id)
      REFERENCES live.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
with (
  oids=false
);
-- table: "residentialmoveindate"

-- drop table "residentialmoveindate";

create table  "live".residentialmoveindate
(
  inpermanenthousing "live".no_yes,
  enrollmentid uuid,
  residentialmoveindate date,
  id uuid not null,       
  "date_created" date,
  "date_updated" date,
  "user_id" uuid,
  export_id uuid,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES live.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  constraint "residentialmoveindate_pkey" primary key (id),
  constraint "residentialmoveindate_enrollmentid_fkey" foreign key (enrollmentid)
      references live.enrollment ("id") match simple,
         CONSTRAINT hmis_user_fkey FOREIGN KEY (user_id)
      REFERENCES live.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
with (
  oids=false
);

-- table: "dateofengagement"

-- drop table "dateofengagement";

create table  "live".dateofengagement
(
  "dateofengagement" date,
  "id" uuid not null,
  "enrollmentid" uuid,
           "date_created" date,
  "date_updated" date,
  "user_id" uuid,
  export_id uuid,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES live.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  constraint "dateofengagement_pkey" primary key ("id"),
  constraint "dateofengagement_enrollmentid_fkey" foreign key ("enrollmentid")
      references live.enrollment ("id") match simple
      on update no action on delete no action,
       CONSTRAINT hmis_user_fkey FOREIGN KEY (user_id)
      REFERENCES live.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
with (
  oids=false
);


create table "live".services
(
  dateprovided date,
  faamount numeric(15,3),
  othertypeprovided character varying(50),
  enrollmentid uuid,
  recordtype "live".record_type,
  referraloutcome "live".referral_outcome,
  id uuid not null,
  subtypeprovided integer,
  typeprovided integer,
           "date_created" date,
  "date_updated" date,
  "user_id" uuid,
  export_id uuid,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES live.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  constraint "services_pkey" primary key (id),
  constraint "services_enrollmentid_fkey" foreign key (enrollmentid)
      references live.enrollment ("id") match simple
      on update no action on delete no action,
            CONSTRAINT hmis_user_fkey FOREIGN KEY (user_id)
      REFERENCES live.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
with (
  oids=false
);


-- drop table "incomeandsources";

create table "live".incomeandsources
(
  alimony "live".no_yes,
  alimonyamount numeric(15,3),
  childsupport "live".no_yes,
  childsupportamount numeric(15,3),
  earned "live".no_yes,
  earnedamount numeric(15,3),
  ga "live".no_yes,
  gaamount numeric(15,3),
  id uuid not null,
  incomefromanysource "live".five_val_dk_refused,
  othersource "live".no_yes,
  othersourceamount numeric(15,3),
  othersourceidentify character varying(32),
  pension "live".no_yes,
  pensionamount numeric(15,3),
  privatedisability "live".no_yes,
  privatedisabilityamount numeric(15,3),
  enrollmentid uuid,
  socsecretirement "live".no_yes,
  socsecretirementamount numeric(15,3),
  ssdi "live".no_yes,
  ssdiamount numeric(15,3),
  ssi "live".no_yes,
  ssiamount numeric(15,3),
  tanf "live".no_yes,
  tanfamount numeric(15,3),
  totalmonthlyincome numeric(15,3),
  unemployment "live".no_yes,
  unemploymentamount numeric(15,3),
  vadisabilitynonservice "live".no_yes,
  vadisabilitynonserviceamount numeric(15,3),
  vadisabilityservice "live".no_yes,
  vadisabilityserviceamount numeric(15,3),
  workerscomp "live".no_yes,
  workerscompamount numeric(15,3),
           "date_created" date,
  "date_updated" date,
  "user_id" uuid,
  export_id uuid,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES live.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  constraint "incomeandsources_pkey" primary key (id),
  constraint "incomeandsources_enrollmentid_fkey" foreign key (enrollmentid)
      references live.enrollment ("id") match simple
      on update no action on delete no action,
            CONSTRAINT hmis_user_fkey FOREIGN KEY (user_id)
      REFERENCES live.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
with (
  oids=false
);



-- drop table "noncashbenefits";

create table "live".noncashbenefits
(
  benefitsfromanysource "live".five_val_dk_refused,
  id uuid not null,
  othersource "live".no_yes,
  othersourceidentify character varying(32),
  othertanf "live".no_yes,
  enrollmentid uuid,
  rentalassistanceongoing "live".no_yes,
  rentalassistancetemp "live".no_yes,
  snap "live".no_yes,
  tanfchildcare "live".no_yes,
  tanftransportation "live".no_yes,
  wic "live".no_yes,
             "date_created" date,
  "date_updated" date,
  "user_id" uuid,
  export_id uuid,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES live.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  constraint "noncashbenefits_pkey" primary key (id),
  constraint "noncashbenefits_enrollmentid_fkey" foreign key (enrollmentid)
      references live.enrollment ("id") match simple
      on update no action on delete no action,
                  CONSTRAINT hmis_user_fkey FOREIGN KEY (user_id)
      REFERENCES live.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
with (
  oids=false
);

-- table: "healthinsurance"

-- drop table "healthinsurance";

create table "live".healthinsurance
(
  "cobra" integer,
  "employerprovided" integer,
  "id" uuid not null,
  "insurancefromanysource" "live".five_val_dk_refused,
  "medicaid" "live".no_yes,
  "medicare" "live".no_yes,
  "nocobrareason" "live".no_health_insurance_reason,
  "noemployerprovidedreason" "live".no_health_insurance_reason,
  "nomedicaidreason" "live".no_health_insurance_reason,
  "nomedicarereason" "live".no_health_insurance_reason,
  "noprivatepayreason" "live".no_health_insurance_reason,
  "noschipreason" "live".no_health_insurance_reason,
  "nostatehealthinsreason" "live".no_health_insurance_reason,
  "novamedreason" "live".no_health_insurance_reason,
  "privatepay" "live".no_yes,
  "enrollmentid" uuid,
  "schip" "live".no_yes,
  "statehealthins" "live".no_yes,
  "vamedicalservices" "live".no_yes,
  "date_created" date,
  "date_updated" date,
  "user_id" uuid,
  export_id uuid,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES live.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  constraint "healthinsurance_pkey" primary key ("id"),
  constraint "healthinsurance_enrollmentid_fkey" foreign key ("enrollmentid")
      references live.enrollment ("id") match simple
      on update no action on delete no action,
                       CONSTRAINT hmis_user_fkey FOREIGN KEY (user_id)
      REFERENCES live.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
with (
  oids=false
);

create table "live".exit
(
  "destination" "live".destination,
  "exitdate" date,
  "id" uuid not null,
  "otherdestination" character varying(32),
  "enrollmentid" uuid,
                 "date_created" date,
  "date_updated" date,
  "user_id" uuid,
  export_id uuid,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES live.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  constraint "exit_pkey" primary key ("id"),
  constraint "exit_enrollmentid_fkey" foreign key ("enrollmentid")
      references live.enrollment ("id") match simple
      on update no action on delete no action,
                          CONSTRAINT hmis_user_fkey FOREIGN KEY (user_id)
      REFERENCES live.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
with (
  oids=false
);


create table  "live".exithousingassessment
(
  "id" uuid not null,
  "exitid" uuid,
  "housingassessment" "live".housing_assmnt_exit,
  "subsidyinformation" "live".subsidy_information,
  "date_created" date,
  "date_updated" date,
  "user_id" uuid,
  export_id uuid,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES live.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  constraint "exithousingassessment_pkey" primary key ("id"),
  constraint "exithousingassessment_exitid_fkey" foreign key ("exitid")
      references live."exit" ("id") match simple
      on update no action on delete no action,
                        CONSTRAINT hmis_user_fkey FOREIGN KEY (user_id)
      REFERENCES live.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
with (
  oids=false
);

-- table: "exitplansactions"

-- drop table "exitplansactions";

create table  "live".exitplansactions
(
  "assistancemainstreambenefits" "live".no_yes_refused,
  "exitcounseling"  "live".no_yes_refused,
  "exitid" uuid,
  "id" uuid not null,
  "furtherfollowupservices" "live".no_yes_refused,
  "otheraftercareplanoraction" "live".no_yes_refused,
  "permanenthousingplacement" "live".no_yes_refused,
  "resourcepackage" "live".no_yes_refused,
  "scheduledfollowupcontacts" "live".no_yes_refused,
  "temporaryshelterplacement" "live".no_yes_refused,
  "writtenaftercareplan" "live".no_yes_refused,
                    "date_created" date,
  "date_updated" date,
  "user_id" uuid,
  export_id uuid,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES live.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  constraint "exitplansactions_pkey" primary key ("id"),
  constraint "exitplansactions_exitid_fkey" foreign key ("exitid")
      references live."exit" ("id") match simple
      on update no action on delete no action,
                CONSTRAINT hmis_user_fkey FOREIGN KEY (user_id)
      REFERENCES live.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
with (
  oids=false
);


-- table: "housingassessmentdisposition"

-- drop table "housingassessmentdisposition";

create table "live".housingassessmentdisposition
(
  "assessmentdisposition" "live".assessment_disposition,
  "exitid" uuid,
  "id" uuid not null,
  "otherdisposition" character varying(32),
              "date_created" date,
  "date_updated" date,
  "user_id" uuid,
  export_id uuid,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES live.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  constraint "housingassessmentdisposition_pkey" primary key ("id"),
  constraint "housingassessmentdisposition_exitid_fkey" foreign key ("exitid")
      references live."exit" ("id") match simple
      on update no action on delete no action,
                  CONSTRAINT hmis_user_fkey FOREIGN KEY (user_id)
      REFERENCES live.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
with (
  oids=false
);


create table "live".familyreunification
(
  "exitid" uuid,
  "familyreunificationachieved" "live".five_val_dk_refused,
  "id" uuid not null,
              "date_created" date,
  "date_updated" date,
  "user_id" uuid,
  export_id uuid,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES live.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  constraint "familyreunification_pkey" primary key ("id"),
  constraint "familyreunification_exitid_fkey" foreign key ("exitid")
      references live."exit" ("id") match simple
      on update no action on delete no action,
                  CONSTRAINT hmis_user_fkey FOREIGN KEY (user_id)
      REFERENCES live.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
with (
  oids=false
);

-- drop table "connectionwithsoar";

create table "live".connectionwithsoar
(
  "connectionwithsoar" integer,
  "id" uuid,
  "exitid" uuid,
           "date_created" date,
  "date_updated" date,
  "user_id" uuid,
  export_id uuid,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES live.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  constraint "connectionwithsoar_pkey" primary key ("id"),
  constraint "connectionwithsoar_exitid_fkey" foreign key ("exitid")
      references live."exit" ("id") match simple
      on update no action on delete no action,
                CONSTRAINT hmis_user_fkey FOREIGN KEY (user_id)
      REFERENCES live.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
with (
  oids=false
);
-- table: "projectcompletionstatus"

-- drop table "projectcompletionstatus";

create table "live".projectcompletionstatus
(
  earlyexitreason "live".early_exit_reason,
  exitid uuid,
  projectcompletionstatus "live".project_completion_status,
  id uuid not null,
          "date_created" date,
  "date_updated" date,
  "user_id" uuid,
  export_id uuid,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES live.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  constraint "projectcompletionstatus_pkey" primary key (id),
  constraint "projectcompletionstatus_exitid_fkey" foreign key (exitid)
      references live."exit" ("id") match simple
      on update no action on delete no action,
         CONSTRAINT hmis_user_fkey FOREIGN KEY (user_id)
      REFERENCES live.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
     )
with (
  oids=false
);

-- drop table "projectcompletionstatus";

CREATE TABLE "live".sync
(
  id uuid NOT NULL,
  sync_table character(100),
  status character(10),
  json text,
  date_created date,
  date_updated date,
  CONSTRAINT sync_pk PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);

CREATE TABLE "live".bulk_upload
(
  id bigint NOT NULL,
  inputPath text,
  status character(10),
  insert_at date,
  update_at date,
  insert_by character(100),
  update_by character(100),
   export_id uuid,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES live.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT bulk_upload_pk PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);

CREATE SEQUENCE "live".bulk_upload_id_seq START 1;

CREATE TABLE "live".hud_coc_report_question_7(
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

CREATE SEQUENCE "live".seq_consent_message START 1;

CREATE TABLE live.hmis_consent_message
(
  id uuid NOT NULL,
  external_id character varying(256) NOT NULL,
  message character varying(512) NOT NULL,
  created_at date NOT NULL,
  modified_at date,
  created_by character varying(256) NOT NULL,
  modified_by character varying(256),
  deleted date,
  CONSTRAINT "PK_CONSENT_MESSAGE" PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);

CREATE TABLE live.hmis_verification
(
  id uuid NOT NULL,
  verification_token character varying(256),
  verification_type character varying(256),
  status character varying(256),
  created_at date NOT NULL,
  modified_at date,
  created_by character varying(256) NOT NULL,
  modified_by character varying(256),
  CONSTRAINT "PK_VERIFICATION" PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);

CREATE SEQUENCE "live".seq_service START 1;

CREATE TABLE live.hmis_service
(
  id uuid NOT NULL,
  external_id character varying(128),
  friendly_name character varying(256),
  description character varying(512),
  license_type character varying(20) NOT NULL,
  developer_company_id uuid NOT NULL,
  external_product_id character varying(128),
  created_at date NOT NULL,
  modified_at date,
  created_by character varying(256) NOT NULL,
  modified_by character varying(256),
  deleted date,
  status character varying(20),
  CONSTRAINT "PK_SERVICE" PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);

CREATE SEQUENCE "live".seq_trusted_app START 1;

CREATE TABLE live.hmis_trusted_app
(
  id uuid NOT NULL,
  friendly_name character varying(256),
  external_id character varying(256) NOT NULL,
  description character varying(1024),
  status character varying(256) NOT NULL,
  created_at date NOT NULL,
  modified_at date,
  created_by character varying(256) NOT NULL,
  modified_by character varying(256),
  deleted date,
  expiration_time bigint DEFAULT 86400,
  trustedapp_secret character varying(32),
  trustedapp_family_type character varying(32),
  trustedapp_profile_type character varying(32),
  account_consent_type character varying(32),
  container_trustedapp_id uuid,
  logo_url character varying(1048),
  service_id uuid,
  notification_callback_url character varying(512),
  publish_status character varying(256),
  version character varying(128),
  download_url character varying(1024),
  last_released_at date,
  container_access_token_allowed boolean,
  is_internal boolean,
  api_method_check_required boolean,
  auth_code_grant_supported boolean,
  implicit_grant_supported boolean,
  refresh_token_supported boolean,
  CONSTRAINT "PK_TRUSTED_APP" PRIMARY KEY (id),
  CONSTRAINT "FK_TAPP_SERVICE_ID" FOREIGN KEY (service_id)
      REFERENCES live.hmis_service (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);


CREATE TABLE live.hmis_account_consent
(
  id uuid NOT NULL,
  trustedapp_id uuid,
  consented boolean,
  consented_at date,
  created_at date,
  created_by character varying(256),
  modified_at date,
  modified_by character varying(256),
  consent_token character varying(256),
  user_id uuid,
  CONSTRAINT "PK_ACCOUNT_CONSENT" PRIMARY KEY (id),
  CONSTRAINT "FK_AC_TRUSTEDAPP_ID" FOREIGN KEY (trustedapp_id)
      REFERENCES live.hmis_trusted_app (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "FK_AC_USERID" FOREIGN KEY (user_id)
      REFERENCES live.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);


CREATE TABLE live.hmis_account_data_change
(
  id uuid NOT NULL,
  old_user_name character varying(256),
  new_user_name character varying(256),
  verification_id uuid,
  created_at date,
  modified_at date,
  created_by character varying(256),
  modified_by character varying(256),
  user_id uuid,
  CONSTRAINT "PK_ACCOUNT_DATA_CHANGE" PRIMARY KEY (id),
  CONSTRAINT "FK_ADCHANGE_USERID" FOREIGN KEY (user_id)
      REFERENCES live.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "FK_ADC_VERIFICATIONID" FOREIGN KEY (verification_id)
      REFERENCES live.hmis_verification (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);


CREATE TABLE live.hmis_account_lockout
(
  id uuid NOT NULL,
  last_attempt_status integer,
  last_attempt_at date,
  failure_attempt_count integer,
  created_at date NOT NULL,
  modified_at date,
  created_by character varying(256) NOT NULL,
  modified_by character varying(256),
  user_id uuid,
  CONSTRAINT "PK_ACCOUNT_LOOCKOUT" PRIMARY KEY (id),
  CONSTRAINT "FK_AL_USER_ID" FOREIGN KEY (user_id)
      REFERENCES live.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);

CREATE SEQUENCE "live".seq_account_preference START 1;

CREATE TABLE live.hmis_account_preference
(
  id uuid NOT NULL,
  iso_language_code character varying(120),
  iso_country_code character varying(120),
  newsletter_opt_in integer,
  created_at date NOT NULL,
  modified_at date,
  created_by character varying(256) NOT NULL,
  modified_by character varying(256),
  user_id uuid,
  CONSTRAINT "PK_ACCOUNT_PREFERENCE" PRIMARY KEY (id),
  CONSTRAINT "FK_AP_USER_ID" FOREIGN KEY (user_id)
      REFERENCES live.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);

CREATE SEQUENCE "live".seq_api_group START 1;

CREATE TABLE live.hmis_api_group
(
  id uuid NOT NULL,
  external_id character varying(128) NOT NULL,
  friendly_name character varying(256),
  description character varying(512),
  authorization_msg character varying(512),
  group_sequence bigint,
  created_at date NOT NULL,
  modified_at date,
  created_by character varying(256) NOT NULL,
  modified_by character varying(256),
  deleted date,
  consent_message_id uuid,
  detailed_consent_message_id uuid,
  CONSTRAINT "PK_API_GROUP" PRIMARY KEY (id),
  CONSTRAINT "FK_AG_CONSENT_MESSAGE_ID" FOREIGN KEY (consent_message_id)
      REFERENCES live.hmis_consent_message (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "FK_AG_DTL_CONSENT_MESSAGE_ID" FOREIGN KEY (detailed_consent_message_id)
      REFERENCES live.hmis_consent_message (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);


INSERT INTO live.hmis_api_group(id, external_id, friendly_name, description, authorization_msg, created_at,  created_by)
    VALUES ('084ab7d7de7e-1138-4f74-b50e-d9ebbc10', 'DEVELOPER_SERVICES','DEVELOPER SERVICES', 'DEVELOPER SERVICES', 'DEVELOPER SERVICES', current_date,  'MASTER DATA'),
	       ('13e91f4220ae-96ef-4a61-95a1-e71607df', 'USER_SERVICES','USER SERVICES', 'USER SERVICES', 'USER SERVICES', current_date,  'MASTER DATA'),
	       ('38c0c9b6e73c-6de8-4c69-b0d0-e7a454be', 'ACL_SERVICES','ACL SERVICES', 'ACL SERVICES', 'ACL SERVICES', current_date,  'MASTER DATA'),
	       ('bf1fcd6abb4e-4c6f-4e54-b3d8-fbe73fb7', 'AUTH_SERVICES','AUTH SERVICES', 'AUTH SERVICES', 'AUTH SERVICES', current_date,  'MASTER DATA');


CREATE SEQUENCE "live".seq_api_method START 1;

CREATE TABLE live.hmis_api_method
(
  id uuid NOT NULL,
  external_id character varying(128),
  friendly_name character varying(256),
  description character varying(512),
  type character varying(256) NOT NULL,
  account_consent_msg character varying(512),
  account_consent_msg_order bigint,
  created_at date NOT NULL,
  modified_at date,
  created_by character varying(256) NOT NULL,
  modified_by character varying(256),
  deleted date,
  api_group_id uuid,
  deprecated bigint DEFAULT 0,
  consent_message_id uuid,
  detailed_consent_message_id uuid,
  is_public boolean,
  requires_access_token boolean,
  CONSTRAINT "PK_API_METHOD" PRIMARY KEY (id),
  CONSTRAINT "FK_AM_CONSENT_MESSAGE_ID" FOREIGN KEY (consent_message_id)
      REFERENCES live.hmis_consent_message (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "FK_AM_DTL_CONSENT_MESSAGE_ID" FOREIGN KEY (detailed_consent_message_id)
      REFERENCES live.hmis_consent_message (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "FK_AM_GROUP_ID" FOREIGN KEY (api_group_id)
      REFERENCES live.hmis_api_group (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);


INSERT INTO live.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('4561a939-edea-4b8a-974c-fab36201613d','ACL_CREATE_ROLE','ACL_CREATE_ROLE','ACL_CREATE_ROLE','POST',CURRENT_DATE,'MASTER DATA','38c0c9b6e73c-6de8-4c69-b0d0-e7a454be',0,TRUE);
INSERT INTO live.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('8c17c5e4-85ff-4abc-bcfa-77746cae15c1','ACL_UPDATE_ROLE','ACL_UPDATE_ROLE','ACL_UPDATE_ROLE','PUT',CURRENT_DATE,'MASTER DATA','38c0c9b6e73c-6de8-4c69-b0d0-e7a454be',0,TRUE);
INSERT INTO live.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('c3e1e197-0e7a-41b0-ab68-1d9365f9f948','ACL_DELETE_ROLE','ACL_DELETE_ROLE','ACL_DELETE_ROLE','DELETE',CURRENT_DATE,'MASTER DATA','38c0c9b6e73c-6de8-4c69-b0d0-e7a454be',0,TRUE);
INSERT INTO live.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('e0dee727-31d1-4a36-acc4-78ddd177ed88','ACL_GET_ALL_ROLES','ACL_GET_ALL_ROLES','ACL_GET_ALL_ROLES','GET',CURRENT_DATE,'MASTER DATA','38c0c9b6e73c-6de8-4c69-b0d0-e7a454be',0,TRUE);
INSERT INTO live.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('76adcdd5-f6e2-4587-bfbc-40f52b2d0a5b','ACL_CREATE_SHARING_RULE','ACL_CREATE_SHARING_RULE','ACL_CREATE_SHARING_RULE','POST',CURRENT_DATE,'MASTER DATA','38c0c9b6e73c-6de8-4c69-b0d0-e7a454be',0,TRUE);
INSERT INTO live.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('cfe095c8-5316-4c37-bcfb-65757eb30a64','ACL_UPDATE_SHARING_RULE','ACL_UPDATE_SHARING_RULE','ACL_UPDATE_SHARING_RULE','PUT',CURRENT_DATE,'MASTER DATA','38c0c9b6e73c-6de8-4c69-b0d0-e7a454be',0,TRUE);
INSERT INTO live.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('5389777e-4bd7-440c-9cc0-ed3069df463d','ACL_DELETE_SHARING_RULE','ACL_DELETE_SHARING_RULE','ACL_DELETE_SHARING_RULE','DELETE',CURRENT_DATE,'MASTER DATA','38c0c9b6e73c-6de8-4c69-b0d0-e7a454be',0,TRUE);
INSERT INTO live.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('55269f08-273f-4f68-ae9a-f98467b4d091','ACL_CREATE_PROFILE','ACL_CREATE_PROFILE','ACL_CREATE_PROFILE','POST',CURRENT_DATE,'MASTER DATA','38c0c9b6e73c-6de8-4c69-b0d0-e7a454be',0,TRUE);
INSERT INTO live.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('604b8afb-782a-4576-9146-c6b8f1cce560','ACL_UPDATE_PROFILE','ACL_UPDATE_PROFILE','ACL_UPDATE_PROFILE','PUT',CURRENT_DATE,'MASTER DATA','38c0c9b6e73c-6de8-4c69-b0d0-e7a454be',0,TRUE);
INSERT INTO live.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('6f77f4c7-8708-4eb1-b663-12f8a11dfc3e','ACL_DELETE_PROFILE','ACL_DELETE_PROFILE','ACL_DELETE_PROFILE','DELETE',CURRENT_DATE,'MASTER DATA','38c0c9b6e73c-6de8-4c69-b0d0-e7a454be',0,TRUE);
INSERT INTO live.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('3500719b-c2dd-4c1d-8ab6-f9059a141c6a','ACL_GET_PROFILE','ACL_GET_PROFILE','ACL_GET_PROFILE','GET',CURRENT_DATE,'MASTER DATA','38c0c9b6e73c-6de8-4c69-b0d0-e7a454be',0,TRUE);
INSERT INTO live.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('23a43f92-1f75-4b70-aac6-23dcbeb33ba5','ACL_GET_ALL_PROFILES','ACL_GET_ALL_PROFILES','ACL_GET_ALL_PROFILES','GET',CURRENT_DATE,'MASTER DATA','38c0c9b6e73c-6de8-4c69-b0d0-e7a454be',0,TRUE);
INSERT INTO live.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('2192f57b-fa89-41b4-8680-e78f0b3c4c3e','ACL_CREATE_PRMISSION_SET','ACL_CREATE_PRMISSION_SET','ACL_CREATE_PRMISSION_SET','POST',CURRENT_DATE,'MASTER DATA','38c0c9b6e73c-6de8-4c69-b0d0-e7a454be',0,TRUE);
INSERT INTO live.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('2be134e2-6723-414f-a2eb-7d325f607fc2','ACL_UPDATE_PRMISSION_SET','ACL_UPDATE_PRMISSION_SET','ACL_UPDATE_PRMISSION_SET','PUT',CURRENT_DATE,'MASTER DATA','38c0c9b6e73c-6de8-4c69-b0d0-e7a454be',0,TRUE);
INSERT INTO live.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('680d4f6e-645d-469b-a8d1-9ce0ebaeb70f','ACL_DELETE_PRMISSION_SET','ACL_DELETE_PRMISSION_SET','ACL_DELETE_PRMISSION_SET','DELETE',CURRENT_DATE,'MASTER DATA','38c0c9b6e73c-6de8-4c69-b0d0-e7a454be',0,TRUE);
INSERT INTO live.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('5cf162dc-9497-4e20-8109-32cf47c8241b','ACL_GET_PRMISSION_SET','ACL_GET_PRMISSION_SET','ACL_GET_PRMISSION_SET','GET',CURRENT_DATE,'MASTER DATA','38c0c9b6e73c-6de8-4c69-b0d0-e7a454be',0,TRUE);
INSERT INTO live.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('659ebd34-999a-4611-ab9f-966ef8822a29','ACL_ASSIGN_PRMISSION_SET','ACL_ASSIGN_PRMISSION_SET','ACL_ASSIGN_PRMISSION_SET','PUT',CURRENT_DATE,'MASTER DATA','38c0c9b6e73c-6de8-4c69-b0d0-e7a454be',0,TRUE);
INSERT INTO live.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('b04e67bf-9729-443a-aa27-6fa228c7be6b','ACL_CREATE_USER_ROLE','ACL_CREATE_USER_ROLE','ACL_CREATE_USER_ROLE','POST',CURRENT_DATE,'MASTER DATA','38c0c9b6e73c-6de8-4c69-b0d0-e7a454be',0,TRUE);
INSERT INTO live.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('d61b2d9e-bfd4-4b02-9a6f-d6884f502539','ACL_UPDATE_USER_ROLE','ACL_UPDATE_USER_ROLE','ACL_UPDATE_USER_ROLE','PUT',CURRENT_DATE,'MASTER DATA','38c0c9b6e73c-6de8-4c69-b0d0-e7a454be',0,TRUE);
INSERT INTO live.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('1264d1d4-0fe4-4f29-a3bc-62102f420a11','USR_CREATE_ACCOUNT','USR_CREATE_ACCOUNT','USR_CREATE_ACCOUNT','POST',CURRENT_DATE,'MASTER DATA','13e91f4220ae-96ef-4a61-95a1-e71607df',0,TRUE);
INSERT INTO live.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('c1befc78-01b0-4de9-8ac9-eb34a9c78bb0','USR_GET_ACCOUNT_EMAIL_ADDRESS','USR_GET_ACCOUNT_EMAIL_ADDRESS','USR_GET_ACCOUNT_EMAIL_ADDRESS','GET',CURRENT_DATE,'MASTER DATA','13e91f4220ae-96ef-4a61-95a1-e71607df',0,TRUE);
INSERT INTO live.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('0e17ff09-8ab1-4913-9dde-0552193fcbf6','USR_GET_ACCOUNT_BASIC_INFO','USR_GET_ACCOUNT_BASIC_INFO','USR_GET_ACCOUNT_BASIC_INFO','GET',CURRENT_DATE,'MASTER DATA','13e91f4220ae-96ef-4a61-95a1-e71607df',0,TRUE);
INSERT INTO live.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('e0ca45cc-33e3-4e9d-b5f9-537d4b88c459','USR_GET_AUTHORIZED_TRUSTEDAPPS','USR_GET_AUTHORIZED_TRUSTEDAPPS','USR_GET_AUTHORIZED_TRUSTEDAPPS','GET',CURRENT_DATE,'MASTER DATA','13e91f4220ae-96ef-4a61-95a1-e71607df',0,TRUE);
INSERT INTO live.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('e63574d1-1d4b-4e01-a3db-060915f3295d','USR_GET_ACCOUNT','USR_GET_ACCOUNT','USR_GET_ACCOUNT','GET',CURRENT_DATE,'MASTER DATA','13e91f4220ae-96ef-4a61-95a1-e71607df',0,TRUE);
INSERT INTO live.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('e832df6f-c238-456b-b03e-c60b917f508a','USR_UPDATE_ACCOUNT','USR_UPDATE_ACCOUNT','USR_UPDATE_ACCOUNT','PUT',CURRENT_DATE,'MASTER DATA','13e91f4220ae-96ef-4a61-95a1-e71607df',0,TRUE);
INSERT INTO live.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('29d8611c-bf90-427d-b18a-1fe2473c9ffd','USR_GET_ACCOUNT_STATUS','USR_GET_ACCOUNT_STATUS','USR_GET_ACCOUNT_STATUS','GET',CURRENT_DATE,'MASTER DATA','13e91f4220ae-96ef-4a61-95a1-e71607df',0,TRUE);
INSERT INTO live.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('e63156ff-e93a-447e-9080-b8c164992b97','USR_GET_ACCOUNT_PREFERENCES','USR_GET_ACCOUNT_PREFERENCES','USR_GET_ACCOUNT_PREFERENCES','GET',CURRENT_DATE,'MASTER DATA','13e91f4220ae-96ef-4a61-95a1-e71607df',0,TRUE);
INSERT INTO live.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('30bee259-fc5e-4667-854f-98c7fd81f3e2','USR_UPDATE_ACCOUNT_PREFERENCES','USR_UPDATE_ACCOUNT_PREFERENCES','USR_UPDATE_ACCOUNT_PREFERENCES','PUT',CURRENT_DATE,'MASTER DATA','13e91f4220ae-96ef-4a61-95a1-e71607df',0,TRUE);
INSERT INTO live.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('72df4ae1-3659-49cb-a221-84cee475a58e','USR_PASSWORD_RESET','USR_PASSWORD_RESET','USR_PASSWORD_RESET','PUT',CURRENT_DATE,'MASTER DATA','13e91f4220ae-96ef-4a61-95a1-e71607df',0,TRUE);
INSERT INTO live.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('b02a288d-85f2-4a5e-95d1-a43db8383e05','USR_PASSWORD_UPDATE','USR_PASSWORD_UPDATE','USR_PASSWORD_UPDATE','PUT',CURRENT_DATE,'MASTER DATA','13e91f4220ae-96ef-4a61-95a1-e71607df',0,TRUE);
INSERT INTO live.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('75900937-5126-44b6-937f-6494b0722657','USR_USERNAME_CHANGE','USR_USERNAME_CHANGE','USR_USERNAME_CHANGE','PUT',CURRENT_DATE,'MASTER DATA','13e91f4220ae-96ef-4a61-95a1-e71607df',0,TRUE);
INSERT INTO live.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('17ec1d67-d1a0-4aee-94bb-a686c0f25a41','USR_GET_ORGANIZATION_USERS','USR_GET_ORGANIZATION_USERS','USR_GET_ORGANIZATION_USERS','GET',CURRENT_DATE,'MASTER DATA','13e91f4220ae-96ef-4a61-95a1-e71607df',0,TRUE);
INSERT INTO live.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('2a54536b-f208-41d7-a2e3-f7f1c0953c1a','USR_CHECK_API_AUTHORIZATION','USR_CHECK_API_AUTHORIZATION','USR_CHECK_API_AUTHORIZATION','POST',CURRENT_DATE,'MASTER DATA','13e91f4220ae-96ef-4a61-95a1-e71607df',0,TRUE);
INSERT INTO live.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('18ac92c9-7cba-43df-aa00-f5c4a2c802c3','USR_GET_BASIC_TRUSTEDAPP_INFO','USR_GET_BASIC_TRUSTEDAPP_INFO','USR_GET_BASIC_TRUSTEDAPP_INFO','GET',CURRENT_DATE,'MASTER DATA','13e91f4220ae-96ef-4a61-95a1-e71607df',0,TRUE);
INSERT INTO live.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('60935f25-fec5-4e4d-b0c3-452d21d1848f','USR_CREATE_SESSION','USR_CREATE_SESSION','USR_CREATE_SESSION','POST',CURRENT_DATE,'MASTER DATA','13e91f4220ae-96ef-4a61-95a1-e71607df',0,TRUE);
INSERT INTO live.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('600df1a9-b9e4-4953-b90e-8d55d67233ac','USR_END_SESSION','USR_END_SESSION','USR_END_SESSION','DELETE',CURRENT_DATE,'MASTER DATA','13e91f4220ae-96ef-4a61-95a1-e71607df',0,TRUE);
INSERT INTO live.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('3336586d-5034-41fc-a32c-9aab26873dd3','USR_UPDATE_VERIFICATION_STATUS','USR_UPDATE_VERIFICATION_STATUS','USR_UPDATE_VERIFICATION_STATUS','PUT',CURRENT_DATE,'MASTER DATA','13e91f4220ae-96ef-4a61-95a1-e71607df',0,TRUE);
INSERT INTO live.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('039c55be-bf44-4e22-8a79-5ba861756c45','USR_CREATE_VERIFICATION','USR_CREATE_VERIFICATION','USR_CREATE_VERIFICATION','POST',CURRENT_DATE,'MASTER DATA','13e91f4220ae-96ef-4a61-95a1-e71607df',0,TRUE);
INSERT INTO live.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('b0b768dd-ebb8-4ab4-8124-8d84bec4cdd6','DCS_CREATE_DEVELOPER_COMPANY','DCS_CREATE_DEVELOPER_COMPANY','DCS_CREATE_DEVELOPER_COMPANY','POST',CURRENT_DATE,'MASTER DATA','084ab7d7de7e-1138-4f74-b50e-d9ebbc10',0,TRUE);
INSERT INTO live.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('6bcdc400-1ddc-43c7-b8ab-192811119710','DCS_UPDATE_DEVELOPER_COMPANY','DCS_UPDATE_DEVELOPER_COMPANY','DCS_UPDATE_DEVELOPER_COMPANY','PUT',CURRENT_DATE,'MASTER DATA','084ab7d7de7e-1138-4f74-b50e-d9ebbc10',0,TRUE);
INSERT INTO live.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('fdb04b89-8962-44ec-ae66-3b5508109925','DCS_ASSOCIATE_DEVELOPER_ACCOUNT','DCS_ASSOCIATE_DEVELOPER_ACCOUNT','DCS_ASSOCIATE_DEVELOPER_ACCOUNT','POST',CURRENT_DATE,'MASTER DATA','084ab7d7de7e-1138-4f74-b50e-d9ebbc10',0,TRUE);
INSERT INTO live.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('ed2f4926-bf7c-4103-a0cc-623c7f409bf2','DCS_DISASSOCIATE_DEVELOPER_ACCOUNT','DCS_DISASSOCIATE_DEVELOPER_ACCOUNT','DCS_DISASSOCIATE_DEVELOPER_ACCOUNT','DELETE',CURRENT_DATE,'MASTER DATA','084ab7d7de7e-1138-4f74-b50e-d9ebbc10',0,TRUE);
INSERT INTO live.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('16a154ba-e95f-4514-89e6-c11e6f4a43f7','DCS_CREATE_SERVICE','DCS_CREATE_SERVICE','DCS_CREATE_SERVICE','POST',CURRENT_DATE,'MASTER DATA','084ab7d7de7e-1138-4f74-b50e-d9ebbc10',0,TRUE);
INSERT INTO live.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('0c41fe4d-c0bc-4514-bd64-13fb8b79ce65','DCS_DELETE_DEVELOPER_COMPANY','DCS_DELETE_DEVELOPER_COMPANY','DCS_DELETE_DEVELOPER_COMPANY','DELETE',CURRENT_DATE,'MASTER DATA','084ab7d7de7e-1138-4f74-b50e-d9ebbc10',0,TRUE);
INSERT INTO live.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('cd8407c6-b926-4311-8f74-3c22f8523aef','DCS_GET_DEVELOPER_COMPANY','DCS_GET_DEVELOPER_COMPANY','DCS_GET_DEVELOPER_COMPANY','GET',CURRENT_DATE,'MASTER DATA','084ab7d7de7e-1138-4f74-b50e-d9ebbc10',0,TRUE);
INSERT INTO live.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('9aacbe33-b5b3-4e82-bfa8-7de2c94fee8c','DCS_GET_DEVELOPER_COMPANY_ACCOUNTS','DCS_GET_DEVELOPER_COMPANY_ACCOUNTS','DCS_GET_DEVELOPER_COMPANY_ACCOUNTS','GET',CURRENT_DATE,'MASTER DATA','084ab7d7de7e-1138-4f74-b50e-d9ebbc10',0,TRUE);
INSERT INTO live.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('8dec892c-3dec-4b35-92c6-e133e3d502cd','DCS_GET_SERVICES','DCS_GET_SERVICES','DCS_GET_SERVICES','GET',CURRENT_DATE,'MASTER DATA','084ab7d7de7e-1138-4f74-b50e-d9ebbc10',0,TRUE);
INSERT INTO live.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('7549ee25-e8ec-4461-ac9d-97134be54563','DCS_GET_ALL_DEVELOPER_COMPANY','DCS_GET_ALL_DEVELOPER_COMPANY','DCS_GET_ALL_DEVELOPER_COMPANY','GET',CURRENT_DATE,'MASTER DATA','084ab7d7de7e-1138-4f74-b50e-d9ebbc10',0,TRUE);
INSERT INTO live.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('156d7669-0240-4fbd-8600-c1ebb75d366b','DCS_CREATE_DEVELOPER_APPROVAL_DECISION','DCS_CREATE_DEVELOPER_APPROVAL_DECISION','DCS_CREATE_DEVELOPER_APPROVAL_DECISION','POST',CURRENT_DATE,'MASTER DATA','084ab7d7de7e-1138-4f74-b50e-d9ebbc10',0,TRUE);
INSERT INTO live.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('efd1e4b6-7d4e-4565-b005-3df75dc75d75','DCS_CREATE_SERVICE','DCS_CREATE_SERVICE','DCS_CREATE_SERVICE','POST',CURRENT_DATE,'MASTER DATA','084ab7d7de7e-1138-4f74-b50e-d9ebbc10',0,TRUE);
INSERT INTO live.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('75381266-2797-4a38-bf28-404079017428','DCS_UPDATE_SERVICE','DCS_UPDATE_SERVICE','DCS_UPDATE_SERVICE','PUT',CURRENT_DATE,'MASTER DATA','084ab7d7de7e-1138-4f74-b50e-d9ebbc10',0,TRUE);
INSERT INTO live.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('5256353f-b254-44fe-af66-d57d63312f62','DCS_DELETE_SERVICE','DCS_DELETE_SERVICE','DCS_DELETE_SERVICE','DELETE',CURRENT_DATE,'MASTER DATA','084ab7d7de7e-1138-4f74-b50e-d9ebbc10',0,TRUE);
INSERT INTO live.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('795778b9-ba24-4434-b140-192db2fa745b','DCS_CREATE_TRUSTEDAPP_FOR_SERVICE','DCS_CREATE_TRUSTEDAPP_FOR_SERVICE','DCS_CREATE_TRUSTEDAPP_FOR_SERVICE','POST',CURRENT_DATE,'MASTER DATA','084ab7d7de7e-1138-4f74-b50e-d9ebbc10',0,TRUE);
INSERT INTO live.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('e8ce14b5-b732-4235-bb4d-cfca8e333c2a','DCS_CREATE_SERVICE_APPROVAL_SUBMISSION','DCS_CREATE_SERVICE_APPROVAL_SUBMISSION','DCS_CREATE_SERVICE_APPROVAL_SUBMISSION','POST',CURRENT_DATE,'MASTER DATA','084ab7d7de7e-1138-4f74-b50e-d9ebbc10',0,TRUE);
INSERT INTO live.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('3b6c1791-3d69-4abc-8716-0cecf831357d','DCS_CREATE_SERVICE_APPROVAL_DECISION','DCS_CREATE_SERVICE_APPROVAL_DECISION','DCS_CREATE_SERVICE_APPROVAL_DECISION','POST',CURRENT_DATE,'MASTER DATA','084ab7d7de7e-1138-4f74-b50e-d9ebbc10',0,TRUE);
INSERT INTO live.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('66729788-94cb-493a-9b3d-16cac138f609','DCS_GET_TRUSTEDAPPS_FOR_SERVICE','DCS_GET_TRUSTEDAPPS_FOR_SERVICE','DCS_GET_TRUSTEDAPPS_FOR_SERVICE','GET',CURRENT_DATE,'MASTER DATA','084ab7d7de7e-1138-4f74-b50e-d9ebbc10',0,TRUE);
INSERT INTO live.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('82f91a18-27c5-4a6e-bf24-7d93053f499e','DCS_UPDATE_TRUSTEDAPP','DCS_UPDATE_TRUSTEDAPP','DCS_UPDATE_TRUSTEDAPP','PUT',CURRENT_DATE,'MASTER DATA','084ab7d7de7e-1138-4f74-b50e-d9ebbc10',0,TRUE);
INSERT INTO live.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('761a583b-5c1b-4be6-a364-9adafcaaf3b0','DCS_DELETE_TRUSTEDAPP','DCS_DELETE_TRUSTEDAPP','DCS_DELETE_TRUSTEDAPP','DELETE',CURRENT_DATE,'MASTER DATA','084ab7d7de7e-1138-4f74-b50e-d9ebbc10',0,TRUE);
INSERT INTO live.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('c4400a71-cf49-48aa-bc09-a1a0a7ad2fc1','DCS_REGENERATE_TRUSTEDAPP_SECRETE','DCS_REGENERATE_TRUSTEDAPP_SECRETE','DCS_REGENERATE_TRUSTEDAPP_SECRETE','PUT',CURRENT_DATE,'MASTER DATA','084ab7d7de7e-1138-4f74-b50e-d9ebbc10',0,TRUE);
INSERT INTO live.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('5a63dc2b-d28d-4b5c-bfdf-f8ce372338ad','DCS_CREATE_APPROVAL_SUBMISSION_FOR_TRUSTEDAPP','DCS_CREATE_APPROVAL_SUBMISSION_FOR_TRUSTEDAPP','DCS_CREATE_APPROVAL_SUBMISSION_FOR_TRUSTEDAPP','POST',CURRENT_DATE,'MASTER DATA','084ab7d7de7e-1138-4f74-b50e-d9ebbc10',0,TRUE);
INSERT INTO live.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('aa424f3c-8743-430a-bb4f-51f2f7930570','DCS_CREATE_APPROVAL_DECISION_FOR_TRUSTEDAPP','DCS_CREATE_APPROVAL_DECISION_FOR_TRUSTEDAPP','DCS_CREATE_APPROVAL_DECISION_FOR_TRUSTEDAPP','POST',CURRENT_DATE,'MASTER DATA','084ab7d7de7e-1138-4f74-b50e-d9ebbc10',0,TRUE);
INSERT INTO live.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('b75217f9-d6c3-4c9d-8566-1f2065817740','DCS_GET_TRUSTEDAPP','DCS_GET_TRUSTEDAPP','DCS_GET_TRUSTEDAPP','GET',CURRENT_DATE,'MASTER DATA','084ab7d7de7e-1138-4f74-b50e-d9ebbc10',0,TRUE);
INSERT INTO live.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('50965196-a164-45fc-8ca2-52fd5de04710','DCS_REGISTER_REDIRECT_URI','DCS_REGISTER_REDIRECT_URI','DCS_REGISTER_REDIRECT_URI','POST',CURRENT_DATE,'MASTER DATA','084ab7d7de7e-1138-4f74-b50e-d9ebbc10',0,TRUE);
INSERT INTO live.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('6ac3e289-b885-4e1c-901c-382c1e12d415','DCS_GET_REDIRECT_URIS','DCS_GET_REDIRECT_URIS','DCS_GET_REDIRECT_URIS','GET',CURRENT_DATE,'MASTER DATA','084ab7d7de7e-1138-4f74-b50e-d9ebbc10',0,TRUE);
INSERT INTO live.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('84ccf81d-35f1-44d6-a8fd-8fd67cde958d','AUTH_AUTHORIZE','AUTH_AUTHORIZE','AUTH_AUTHORIZE','GET',CURRENT_DATE,'MASTER DATA','bf1fcd6abb4e-4c6f-4e54-b3d8-fbe73fb7',0,TRUE);
INSERT INTO live.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('c7261bb4-4c5a-4c42-9837-6215fa63fdc3','AUTH_GET_CONSENT_MESSAGES','AUTH_GET_CONSENT_MESSAGES','AUTH_GET_CONSENT_MESSAGES','GET',CURRENT_DATE,'MASTER DATA','bf1fcd6abb4e-4c6f-4e54-b3d8-fbe73fb7',0,TRUE);
INSERT INTO live.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('9cec44bb-ecc5-4020-a81b-1d1f43bc397a','AUTH_GET_DETAILED_CONSENT_MESSAGES','AUTH_GET_DETAILED_CONSENT_MESSAGES','AUTH_GET_DETAILED_CONSENT_MESSAGES','GET',CURRENT_DATE,'MASTER DATA','bf1fcd6abb4e-4c6f-4e54-b3d8-fbe73fb7',0,TRUE);
INSERT INTO live.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('6a29e5d5-2342-4cf2-b40a-45a37d522b83','AUTH_AUTHORIZE_TOKEN','AUTH_AUTHORIZE_TOKEN','AUTH_AUTHORIZE_TOKEN','POST',CURRENT_DATE,'MASTER DATA','bf1fcd6abb4e-4c6f-4e54-b3d8-fbe73fb7',0,TRUE);
INSERT INTO live.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('31636bef-4d68-4eb0-9343-0a86c9be2f4c','AUTH_REVOKE_TOKEN','AUTH_REVOKE_TOKEN','AUTH_REVOKE_TOKEN','POST',CURRENT_DATE,'MASTER DATA','bf1fcd6abb4e-4c6f-4e54-b3d8-fbe73fb7',0,TRUE);


CREATE SEQUENCE "live".seq_developer_company START 1;

CREATE TABLE live.hmis_developer_company
(
  id uuid NOT NULL,
  external_id character varying(128),
  name character varying(1048) NOT NULL,
  domain character varying(256),
  logo_url character varying(1048),
  created_at date NOT NULL,
  modified_at date,
  created_by character varying(256) NOT NULL,
  modified_by character varying(256),
  deleted date,
  company_size bigint DEFAULT 1,
  app_experience character varying(1024),
  company_skill_set character varying(1024),
  app_platforms character varying(1024),
  expected_app_finish_date date,
  contact_email character varying(256),
  status character varying(10),
  owner_user_id uuid,
  CONSTRAINT "PK_DEVELOPER_COMPANY" PRIMARY KEY (id),
  CONSTRAINT "FK_DC_USERID" FOREIGN KEY (owner_user_id)
      REFERENCES live.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);

CREATE SEQUENCE "live".seq_developer_company_account START 1;

CREATE TABLE live.hmis_developer_company_account
(
  id uuid NOT NULL,
  developer_company_id uuid NOT NULL,
  role character varying(32),
  created_at date NOT NULL,
  modified_at date,
  created_by character varying(256) NOT NULL,
  modified_by character varying(256),
  deleted date,
  user_id uuid,
  CONSTRAINT "PK_DEVELOPER_COMPANY_ACCOUNT" PRIMARY KEY (id),
  CONSTRAINT "FK_DCA_USERID" FOREIGN KEY (user_id)
      REFERENCES live.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);

CREATE SEQUENCE "live".seq_developer_company_status START 1;

CREATE TABLE live.hmis_developer_company_status
(
  id uuid NOT NULL,
  developer_company_id uuid NOT NULL,
  status character varying(20),
  comments character varying(512),
  created_at date NOT NULL,
  modified_at date,
  created_by character varying(256) NOT NULL,
  modified_by character varying(256),
  deleted date,
  CONSTRAINT "PK_DEVELOPER_COMPANY_STATUS" PRIMARY KEY (id),
  CONSTRAINT "FK_DCS_DEVELOPER_COMPANY_ID" FOREIGN KEY (developer_company_id)
      REFERENCES live.hmis_developer_company_status (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);


CREATE TABLE live.hmis_password_reset
(
  id uuid NOT NULL,
  new_password character varying(256),
  verification_id uuid,
  status character varying(256),
  created_at date,
  modified_at date,
  created_by character varying(256),
  modified_by character varying(256),
  user_id uuid,
  CONSTRAINT "PK_PASSWORD_RESET" PRIMARY KEY (id),
  CONSTRAINT "FK_PR_USER_ID" FOREIGN KEY (user_id)
      REFERENCES live.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "FK_PR_VERIFICATION_ID" FOREIGN KEY (verification_id)
      REFERENCES live.hmis_verification (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);

CREATE TABLE live.hmis_permission_set
(
  id uuid NOT NULL,
  permission_set_name character varying(256),
  permission_set_description character varying(256),
  created_at date,
  created_by character varying(256),
  modified_at date,
  modified_by character varying(256),
  CONSTRAINT "PK_PERMISSION_SET" PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);

CREATE TABLE live.hmis_permission_set_acl
(
  id uuid NOT NULL,
  permission_set_id uuid,
  api_method_id uuid,
  created_at date,
  created_by character varying(256),
  modified_at date,
  modified_by character varying(256),
  CONSTRAINT "PK_PERMISSION_SET_ACL" PRIMARY KEY (id),
  CONSTRAINT "FK_PSA_API_METHOD_ID" FOREIGN KEY (api_method_id)
      REFERENCES live.hmis_api_method (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "FK_PSA_PERMISSION_SET_ID" FOREIGN KEY (permission_set_id)
      REFERENCES live.hmis_permission_set (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);


CREATE TABLE live.hmis_profile
(
  id uuid NOT NULL,
  profile_name character varying(256),
  profile_description character varying(256),
  created_at date,
  created_by character varying(256),
  modified_at date,
  modified_by character varying(256),
  CONSTRAINT "PK_PROFILE" PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);

CREATE TABLE live.hmis_profile_acl
(
  profile_id uuid,
  api_method_id uuid,
  id uuid NOT NULL,
  created_at date,
  created_by character varying(256),
  modified_at date,
  modified_by character varying(256),
  CONSTRAINT "PK_PROFILE_ACL" PRIMARY KEY (id),
  CONSTRAINT "FK_PACL_API_METHOD_ID" FOREIGN KEY (api_method_id)
      REFERENCES live.hmis_api_method (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "FK_PACL_PROFILE_ID" FOREIGN KEY (profile_id)
      REFERENCES live.hmis_profile (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);

CREATE SEQUENCE "live".seq_redirect_uri START 1;

CREATE TABLE live.hmis_redirect_uri
(
  id uuid NOT NULL,
  uri character varying(1048) NOT NULL,
  trustedapp_id uuid NOT NULL,
  created_at date NOT NULL,
  modified_at date,
  created_by character varying(256) NOT NULL,
  modified_by character varying(256),
  deleted date,
  CONSTRAINT "PK_REDIRECT_URI" PRIMARY KEY (id),
  CONSTRAINT "FK_RU_TRUSTEDAPP_ID" FOREIGN KEY (trustedapp_id)
      REFERENCES live.hmis_trusted_app (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);

CREATE SEQUENCE "live".seq_refresh_token START 1;

CREATE TABLE live.hmis_refresh_token
(
  id uuid NOT NULL,
  token character varying(128),
  auth_code character varying(128),
  trustedapp_id uuid NOT NULL,
  created_at date NOT NULL,
  modified_at date,
  created_by character varying(256) NOT NULL,
  modified_by character varying(256),
  deleted date,
  user_id uuid,
  CONSTRAINT "PK_REFRESH_TOKEN" PRIMARY KEY (id),
  CONSTRAINT "FK_RT_TRUSTEDAPP_ID" FOREIGN KEY (trustedapp_id)
      REFERENCES live.hmis_trusted_app (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "FK_RT_USERID" FOREIGN KEY (user_id)
      REFERENCES live.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);

CREATE SEQUENCE "live".seq_request_token START 1;

CREATE TABLE live.hmis_request_token
(
  id uuid NOT NULL,
  token character varying(128) NOT NULL,
  target_type character varying(32) NOT NULL,
  target_external_id character varying(128) NOT NULL,
  used bigint NOT NULL,
  expires_at date NOT NULL,
  created_at date NOT NULL,
  modified_at date,
  created_by character varying(256) NOT NULL,
  modified_by character varying(256),
  deleted date,
  max_use bigint DEFAULT 1,
  CONSTRAINT "PK_REQUEST_TOKEN" PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);

CREATE TABLE live.hmis_role
(
  id uuid NOT NULL,
  role_name character varying(256),
  role_description character varying(256),
  parent_role_id uuid,
  created_at date,
  created_by character varying(256),
  modified_at date,
  modified_by character varying(256),
  CONSTRAINT "PK_ROLE" PRIMARY KEY (id),
  CONSTRAINT "FK_PARENT_ROLE_ID" FOREIGN KEY (parent_role_id)
      REFERENCES live.hmis_role (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);


CREATE SEQUENCE "live".seq_service_api_method START 1;

CREATE TABLE live.hmis_service_api_method
(
  id uuid NOT NULL,
  service_id uuid NOT NULL,
  api_method_id uuid NOT NULL,
  created_at date NOT NULL,
  modified_at date,
  created_by character varying(256) NOT NULL,
  modified_by character varying(256),
  deleted date,
  CONSTRAINT "PK_SERVICE_API_METHOD" PRIMARY KEY (id),
  CONSTRAINT "FK_SAM_API_METHOD_ID" FOREIGN KEY (api_method_id)
      REFERENCES live.hmis_api_method (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "FK_SAM_SERVICE_ID" FOREIGN KEY (service_id)
      REFERENCES live.hmis_service (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);

CREATE SEQUENCE "live".seq_service_status START 1;

CREATE TABLE live.hmis_service_status
(
  id uuid NOT NULL,
  service_id uuid NOT NULL,
  status character varying(20),
  comments character varying(512),
  created_at date NOT NULL,
  modified_at date,
  created_by character varying(256) NOT NULL,
  modified_by character varying(256),
  deleted date,
  CONSTRAINT "PK_SERVICE_STATUS" PRIMARY KEY (id),
  CONSTRAINT "FK_SS_SERVICE_ID" FOREIGN KEY (service_id)
      REFERENCES live.hmis_service (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);


CREATE TABLE live.hmis_session
(
  id uuid NOT NULL,
  session_token character varying(256),
  expires_at timestamp(0) without time zone,
  trustedapp_id uuid,
  auth_code character varying(256),
  auth_code_expires_at timestamp without time zone,
  redirect_uri character varying(256),
  refresh_token_id uuid,
  created_at date,
  modified_at date,
  created_by character varying(256),
  modified_by character varying(256),
  user_id uuid,
  CONSTRAINT "PK_SESSION" PRIMARY KEY (id),
  CONSTRAINT "FK_SESS_REFRESH_TOKEN_ID" FOREIGN KEY (refresh_token_id)
      REFERENCES live.hmis_refresh_token (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "FK_SESS_TRUSTEDAPP_ID" FOREIGN KEY (trustedapp_id)
      REFERENCES live.hmis_trusted_app (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "FK_SESS_USERID" FOREIGN KEY (user_id)
      REFERENCES live.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);

CREATE TABLE live.hmis_sharing_rule
(
  id uuid NOT NULL,
  from_organization_id uuid,
  enrollment_id uuid,
  role_id uuid,
  to_organization_id uuid,
  project_id uuid,
  active_from date,
  active_to date,
  created_at date,
  created_by character varying(256),
  modified_at date,
  modified_by character varying(256),
  CONSTRAINT "PK_SHARING_RULE" PRIMARY KEY (id),
  CONSTRAINT "FK_SR_ENROLLMENT_ID" FOREIGN KEY (enrollment_id)
      REFERENCES live.enrollment (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "FK_SR_FROM_ORGANIZATION_ID" FOREIGN KEY (from_organization_id)
      REFERENCES live.organization (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "FK_SR_PROJECT_ID" FOREIGN KEY (project_id)
      REFERENCES live.project (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "FK_SR_ROLE_ID" FOREIGN KEY (role_id)
      REFERENCES live.hmis_role (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "FK_SR_TO_ORGANIZATION_ID" FOREIGN KEY (to_organization_id)
      REFERENCES live.organization (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);

CREATE SEQUENCE "live".seq_trusted_app_status START 1;

CREATE TABLE live.hmis_trusted_app_status
(
  id uuid NOT NULL,
  trustedapp_id uuid NOT NULL,
  status character varying(20),
  comments character varying(512),
  created_at date NOT NULL,
  modified_at date,
  created_by character varying(256) NOT NULL,
  modified_by character varying(256),
  deleted date,
  CONSTRAINT "PK_TRUSTED_APP_STATUS" PRIMARY KEY (id),
  CONSTRAINT "FK_TAPPS_TRUSTED_APP_ID" FOREIGN KEY (trustedapp_id)
      REFERENCES live.hmis_trusted_app (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);

CREATE TABLE live.hmis_user_permission_set_acl
(
  id uuid NOT NULL,
  user_id uuid,
  permission_set_id uuid,
  profile_id uuid,
  role_id uuid,
  created_at date,
  created_by character varying(256),
  modified_at date,
  modified_by character varying(256),
  CONSTRAINT "PK_USER_PERMISSION_SET_ACL" PRIMARY KEY (id),
  CONSTRAINT "FK_UPSA_PERMISSION_SET_ID" FOREIGN KEY (permission_set_id)
      REFERENCES live.hmis_permission_set (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "FK_UPSA_PROFILE_ID" FOREIGN KEY (profile_id)
      REFERENCES live.hmis_profile (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "FK_UPSA_ROLE_ID" FOREIGN KEY (role_id)
      REFERENCES live.hmis_role (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "FK_UPSA_USER_ID" FOREIGN KEY (user_id)
      REFERENCES live.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);

CREATE TABLE live.hmis_user_project
(
  id uuid NOT NULL,
  user_id uuid,
  project_id uuid,
  created_at date,
  created_by character varying(256),
  modified_at date,
  modified_by character varying(256),
  CONSTRAINT "PK_USER_PROJECT" PRIMARY KEY (id),
  CONSTRAINT "FK_UP_PROJECT_ID" FOREIGN KEY (project_id)
      REFERENCES live.project (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "FK_UP_USER_ID" FOREIGN KEY (user_id)
      REFERENCES live.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);

CREATE TABLE live.hmis_user_role_map
(
  id uuid NOT NULL,
  user_id uuid,
  role_id uuid,
  created_at date,
  created_by character varying(256),
  modified_at date,
  modified_by character varying(256),
  CONSTRAINT "PK_USER_ROLE_MAP" PRIMARY KEY (id),
  CONSTRAINT "FK_UR_ROLE_ID" FOREIGN KEY (role_id)
      REFERENCES live.hmis_role (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "FK_UR_USER_ID" FOREIGN KEY (user_id)
      REFERENCES live.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);


CREATE TABLE live.hmis_release_of_info
(
  id uuid NOT NULL,
  enrollment_id uuid,
  is_consented boolean,
  project_id uuid,
  created_at date,
  created_by character varying(256),
  modified_at date,
  modified_by character varying(256),
  CONSTRAINT "PK_ROI_ID" PRIMARY KEY (id),
  CONSTRAINT "FK_ROI_ENROLLMENT_ID" FOREIGN KEY (enrollment_id)
      REFERENCES live.enrollment (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "FK_ROI_PROJECT_ID" FOREIGN KEY (project_id)
      REFERENCES live.project (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);


ALTER TABLE live.hmis_user ADD COLUMN created_by character varying(256);
ALTER TABLE live.hmis_user ADD COLUMN modified_by character varying(256);
ALTER TABLE live.hmis_user ADD COLUMN organization_id uuid;
ALTER TABLE live.hmis_user ADD COLUMN password character varying(256);
ALTER TABLE live.hmis_user ADD COLUMN profile_id uuid;
ALTER TABLE live.hmis_user ADD COLUMN status character varying(266);
ALTER TABLE live.hmis_user ADD COLUMN username character varying(256);
ALTER TABLE live.hmis_user ADD COLUMN verification_id uuid;


ALTER TABLE  live.hmis_user ADD CONSTRAINT  "FK_USER_ORGANIZATION_ID" FOREIGN KEY (organization_id) REFERENCES live.organization (id) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE  live.hmis_user ADD  CONSTRAINT "FK_USER_PROFILE_ID" FOREIGN KEY (profile_id) REFERENCES live.hmis_profile (id) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE  live.hmis_user ADD  CONSTRAINT "FK_USER_VERIFICATION_ID" FOREIGN KEY (verification_id) REFERENCES live.hmis_verification (id) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION;
