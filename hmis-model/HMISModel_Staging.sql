DROP SEQUENCE IF EXISTS "staging".bulk_upload_id_seq;
DROP SEQUENCE IF EXISTS "staging".seq_account_consent;
DROP SEQUENCE IF EXISTS "staging".seq_account_data_change;
DROP SEQUENCE IF EXISTS "staging".seq_account_lockout;
DROP SEQUENCE IF EXISTS "staging".seq_account_preference;
DROP SEQUENCE IF EXISTS "staging".seq_api_group;
DROP SEQUENCE IF EXISTS "staging".seq_api_method;
DROP SEQUENCE IF EXISTS "staging".seq_consent_message;
DROP SEQUENCE IF EXISTS "staging".seq_developer_company;
DROP SEQUENCE IF EXISTS "staging".seq_developer_company_account;
DROP SEQUENCE IF EXISTS "staging".seq_developer_company_status;
DROP SEQUENCE IF EXISTS "staging".seq_password_reset;
DROP SEQUENCE IF EXISTS "staging".seq_redirect_uri;
DROP SEQUENCE IF EXISTS "staging".seq_refresh_token;
DROP SEQUENCE IF EXISTS "staging".seq_request_token;
DROP SEQUENCE IF EXISTS "staging".seq_service;
DROP SEQUENCE IF EXISTS "staging".seq_service_api_method;
DROP SEQUENCE IF EXISTS "staging".seq_service_status;
DROP SEQUENCE IF EXISTS "staging".seq_session;
DROP SEQUENCE IF EXISTS "staging".seq_trusted_app;
DROP SEQUENCE IF EXISTS "staging".seq_trusted_app_status;
DROP SEQUENCE IF EXISTS "staging".seq_verification;

DROP TABLE IF EXISTS "staging".hmis_type;
DROP TABLE IF EXISTS "staging".path_status;
DROP TABLE IF EXISTS "staging".rhybcp_status;
DROP TABLE IF EXISTS "staging".last_perm_address;
DROP TABLE IF EXISTS "staging".percent_ami;
DROP TABLE IF EXISTS "staging".lastgradecompleted;
DROP TABLE IF EXISTS "staging".schoolstatus;
DROP TABLE IF EXISTS "staging".employment;

DROP TABLE IF EXISTS "staging".health_status;
DROP TABLE IF EXISTS "staging".affiliation;
DROP TABLE IF EXISTS "staging".site;
DROP TABLE IF EXISTS "staging".inventory;
DROP TABLE IF EXISTS "staging".funder;	
DROP TABLE IF EXISTS "staging".enrollment_coc;

DROP TABLE IF EXISTS "staging".pathstatus;
DROP TABLE IF EXISTS "staging".rhybcpstatus;
DROP TABLE IF EXISTS "staging".sexualorientation;
DROP TABLE IF EXISTS "staging".formerwardjuvenilejustice;
DROP TABLE IF EXISTS "staging".lastpermanentaddress;
DROP TABLE IF EXISTS "staging".percentami;
DROP TABLE IF EXISTS "staging".medicalassistance;
DROP TABLE IF EXISTS "staging".youthcriticalissues;
DROP TABLE IF EXISTS "staging".formerwardchildwelfare;
DROP TABLE IF EXISTS "staging".referralsource;
DROP TABLE IF EXISTS "staging".commercialsexualexploitation;
DROP TABLE IF EXISTS "staging".domesticviolence;
DROP TABLE IF EXISTS "staging".disabilities;
DROP TABLE IF EXISTS "staging".residentialmoveindate;
DROP TABLE IF EXISTS "staging".dateofengagement;
DROP TABLE IF EXISTS "staging".services;
DROP TABLE IF EXISTS "staging".incomeandsources;
DROP TABLE IF EXISTS "staging".noncashbenefits;
DROP TABLE IF EXISTS "staging".healthinsurance;
DROP TABLE IF EXISTS "staging".exithousingassessment;
DROP TABLE IF EXISTS "staging".exitplansactions;
DROP TABLE IF EXISTS "staging".housingassessmentdisposition;
DROP TABLE IF EXISTS "staging".familyreunification;
DROP TABLE IF EXISTS "staging".connectionwithsoar;
DROP TABLE IF EXISTS "staging".projectcompletionstatus;
DROP  table IF EXISTS  "staging".worsthousingsituation;
DROP TABLE IF EXISTS "staging".exit;
DROP TABLE IF EXISTS "staging".bedinventory;
DROP TABLE IF EXISTS "staging".projectcoc;
DROP TABLE IF EXISTS "staging".bulk_upload;
 
DROP TABLE IF EXISTS "staging".hud_coc_report_question_7;
DROP TABLE IF EXISTS  staging.hmis_account_consent;
DROP TABLE IF EXISTS  staging.hmis_account_data_change;
DROP TABLE IF EXISTS  staging.hmis_account_lockout;
DROP TABLE IF EXISTS  staging.hmis_account_preference;

DROP TABLE IF EXISTS  staging.hmis_user_permission_set_acl;
DROP TABLE IF EXISTS  staging.hmis_user_project;
DROP TABLE IF EXISTS  staging.hmis_user_role_map;
DROP TABLE IF EXISTS  staging.hmis_password_reset;
DROP TABLE IF EXISTS  staging.hmis_permission_set_acl;
DROP TABLE IF EXISTS  staging.hmis_permission_set;


DROP TABLE IF EXISTS  staging.hmis_profile_acl;
DROP TABLE IF EXISTS  staging.hmis_session;
DROP TABLE IF EXISTS  staging.hmis_redirect_uri;
DROP TABLE IF EXISTS  staging.hmis_refresh_token;
DROP TABLE IF EXISTS  staging.hmis_request_token;



DROP TABLE IF EXISTS  staging.hmis_sharing_rule;
DROP TABLE IF EXISTS  staging.hmis_role;
DROP TABLE IF EXISTS  staging.hmis_trusted_app_status;
DROP TABLE IF EXISTS  staging.hmis_trusted_app;
DROP TABLE IF EXISTS  staging.hmis_service_api_method;
DROP TABLE IF EXISTS  staging.hmis_service_status;
DROP TABLE IF EXISTS  staging.hmis_service;


DROP TABLE IF EXISTS  staging.hmis_api_method;
DROP TABLE IF EXISTS  staging.hmis_api_group;

DROP TABLE IF EXISTS  staging.hmis_consent_message;
DROP TABLE IF EXISTS  staging.hmis_developer_company;
DROP TABLE IF EXISTS  staging.hmis_developer_company_account;
DROP TABLE IF EXISTS  staging.hmis_developer_company_status;
DROP TABLE IF EXISTS  staging.hmis_notification_header;
DROP TABLE IF EXISTS "staging".project;
DROP TABLE IF EXISTS "staging".enrollment;

DROP TABLE IF  EXISTS "staging".sync;
DROP TABLE IF EXISTS "staging".veteran_info;
DROP TABLE IF EXISTS "staging".client;

DROP TABLE IF EXISTS "staging".organization; 
DROP TABLE IF EXISTS "staging".export;
DROP TABLE IF EXISTS "staging".hmis_user;

DROP TABLE IF EXISTS "staging".source;
DROP TABLE IF EXISTS  staging.hmis_verification;
DROP TABLE IF EXISTS  staging.hmis_profile;
-- Table: "staging"."client"


DROP TYPE IF EXISTS "staging".name_data_quality;
DROP TYPE IF EXISTS "staging".dob_data_quality;
DROP TYPE IF EXISTS "staging".ssn_data_quality;
DROP TYPE IF EXISTS "staging".address_data_quality;
DROP TYPE IF EXISTS "staging".veteran_status;
DROP TYPE IF EXISTS "staging".race;
DROP TYPE IF EXISTS "staging".gender;
DROP TYPE IF EXISTS "staging".ethnicity;
DROP TYPE IF EXISTS "staging".afghanistanoef;
DROP TYPE IF EXISTS "staging".desertstorm;
DROP TYPE IF EXISTS "staging".asked_forced_exchange_sex;
DROP TYPE IF EXISTS "staging".assessment_disposition;
DROP TYPE IF EXISTS "staging".availability;
DROP TYPE IF EXISTS "staging".bed_type;
DROP TYPE IF EXISTS "staging".count_of_exchange_sex;
DROP TYPE IF EXISTS "staging".destination;
DROP TYPE IF EXISTS "staging".disability_type;
DROP TYPE IF EXISTS "staging".discharge_status;
DROP TYPE IF EXISTS "staging".early_exit_reason;
DROP TYPE IF EXISTS "staging".employment_type;
DROP TYPE IF EXISTS "staging".federal_partner_components;
DROP TYPE IF EXISTS "staging".five_val_dk_refused;
DROP TYPE IF EXISTS "staging".fysb_rsn_not_providing_srvcs;
DROP TYPE IF EXISTS "staging".health_category;
DROP TYPE IF EXISTS "staging".health_status_type;
DROP TYPE IF EXISTS "staging".house_hold_type;
DROP TYPE IF EXISTS "staging".housing_assmnt_exit;
DROP TYPE IF EXISTS "staging".homeless_atrisk_status;
DROP TYPE IF EXISTS "staging".incarcerated_parent_status;	
DROP TYPE IF EXISTS "staging".issues_number_of_years;
DROP TYPE IF EXISTS "staging".last_grade_completed;
DROP TYPE IF EXISTS "staging".military_branch;
DROP TYPE IF EXISTS "staging".months_homeless_past_3_years;
DROP TYPE IF EXISTS "staging".no_adap_reason;
DROP TYPE IF EXISTS "staging".no_health_insurance_reason;
DROP TYPE IF EXISTS "staging".no_medical_assistance_reason;
DROP TYPE IF EXISTS "staging".not_employed_reason;
DROP TYPE IF EXISTS "staging".no_yes;
DROP TYPE IF EXISTS "staging".no_yes_refused;
DROP TYPE IF EXISTS "staging".path_how_confirmed;	
DROP TYPE IF EXISTS "staging".path_smi_info_how_confirmed;
DROP TYPE IF EXISTS "staging".percentage_ami;
DROP TYPE IF EXISTS "staging".project_completion_status;
DROP TYPE IF EXISTS "staging".project_type;
DROP TYPE IF EXISTS "staging".reason_not_enrolled;	
DROP TYPE IF EXISTS "staging".record_type;
DROP TYPE IF EXISTS "staging".referral_outcome;
DROP TYPE IF EXISTS "staging".referral_source;
DROP TYPE IF EXISTS "staging".relationship_to_head_of_household;
DROP TYPE IF EXISTS "staging".residence_prior ;
DROP TYPE IF EXISTS "staging".residence_prior_length_of_stay;
DROP TYPE IF EXISTS "staging".school_status;
DROP TYPE IF EXISTS "staging".sexual_orientation;	
DROP TYPE IF EXISTS "staging".subsidy_information;
DROP TYPE IF EXISTS "staging".target_population_type;
DROP TYPE IF EXISTS "staging".times_homeless_past_3_years;
DROP TYPE IF EXISTS "staging".tracking_method;
DROP TYPE IF EXISTS "staging".when_dom_violence_occurred;
DROP TYPE IF EXISTS "staging".youth_age_group;
DROP TYPE IF EXISTS "staging".housing_status;
DROP TYPE IF EXISTS "staging".state;



CREATE TYPE "staging".name_data_quality AS ENUM ('1', '2', '8','9','99');
CREATE TYPE "staging".dob_data_quality AS ENUM ('1', '2', '8','9','99');
CREATE TYPE "staging".ssn_data_quality AS ENUM ('1', '2', '8','9','99');
CREATE TYPE "staging".address_data_quality AS ENUM ('1', '2', '8','9','99');

CREATE TYPE "staging".veteran_status AS ENUM ('0', '1', '8','9','99');
CREATE TYPE "staging".race AS ENUM ('1', '2','3','4','5','8','9','99');
CREATE TYPE "staging".gender AS ENUM ('1', '2','3','4','8','9','99');
CREATE TYPE "staging".ethnicity AS ENUM ('0', '1', '8','9','99');
CREATE TYPE "staging".afghanistanoef AS ENUM ('0', '1', '8','9','99');
CREATE TYPE "staging".desertstorm AS ENUM ('0', '1', '8','9','99');
CREATE TYPE "staging".asked_forced_exchange_sex AS ENUM ('0', '1', '8','9','99');
CREATE TYPE "staging".assessment_disposition AS ENUM ('1','2','3','4','5','6','7','8','9','10','11','12','13','14');
CREATE TYPE "staging".availability AS ENUM ('1', '2', '3');
CREATE TYPE "staging".bed_type AS ENUM ('1', '2', '3');
CREATE TYPE "staging".count_of_exchange_sex AS ENUM ('1', '2', '3','4','8','9');
CREATE TYPE "staging".destination AS ENUM 
('24','1','15','6','14','7','25','26','27','11','21','3','16','4','10','19','28','20','29','18','22','12','23','13','5','2','17','30','8','9','99');
CREATE TYPE "staging".disability_type AS ENUM ('5','6','7','8','9','10');
CREATE TYPE "staging".discharge_status AS ENUM ('1','2','4','5','6','7','8','9','99');
CREATE TYPE "staging".early_exit_reason AS ENUM ('1','2','3','4','5','99');
CREATE TYPE "staging".employment_type AS ENUM ('1','2','3','99');
CREATE TYPE "staging".federal_partner_components AS ENUM 
('1','2','3','4','5','6','7','8','9','10','11','12','13','14','15','16','17','18','19','20','21','22','23','24','25','26','27','28','29','30','31','32','33','34');
CREATE TYPE "staging".five_val_dk_refused AS ENUM ('0','1','8','9','99');
CREATE TYPE "staging".fysb_rsn_not_providing_srvcs AS ENUM ('1','2','3','4','99');
CREATE TYPE "staging".health_category AS ENUM ('27','28','29');
CREATE TYPE "staging".health_status_type AS ENUM ('1', '2','3','4','5','8','9','99');
CREATE TYPE "staging".house_hold_type AS ENUM ('1','3','5');
CREATE TYPE "staging".housing_assmnt_exit AS ENUM ('1','2','3','4','5','6','7','8','9','10','99');
CREATE TYPE "staging".homeless_atrisk_status AS ENUM ('1','2','3','4','5','6','8','9','99');

CREATE TYPE "staging".incarcerated_parent_status AS ENUM ('1','2','3','99');	
CREATE TYPE "staging".issues_number_of_years AS ENUM ('1','2','3');
CREATE TYPE "staging".last_grade_completed  AS ENUM ('1','2','3','4','5','6','7','10','8','9','99');
CREATE TYPE "staging".military_branch AS ENUM ('1','2','3','4','6','8','9','99');
CREATE TYPE "staging".months_homeless_past_3_years AS ENUM ('100','7','8','9','99');
CREATE TYPE "staging".no_adap_reason AS ENUM ('1','2','3','4','8','9','99');
CREATE TYPE "staging".no_health_insurance_reason AS ENUM ('1','2','3','4','8','9','99');
CREATE TYPE "staging".no_medical_assistance_reason AS ENUM (	
'1',
'2',
'3',
'4',
'8',
'9',
'99');
CREATE TYPE "staging".not_employed_reason  AS ENUM (	
'1',
'2',
'3',
'99');
CREATE TYPE "staging".no_yes  AS ENUM (	
'0',
'1',
'99');
CREATE TYPE "staging".no_yes_refused AS ENUM (
'0',
'1',
'9',
'99');
CREATE TYPE "staging".path_how_confirmed AS ENUM (	
'1',
'2',
'3',
'99');
CREATE TYPE "staging".path_smi_info_how_confirmed AS ENUM (	
'0',
'1',
'2',
'3',
'8',
'9',
'99');
CREATE TYPE "staging".percentage_ami AS ENUM (	
'1',
'2',
'3',
'99');

CREATE TYPE "staging".project_completion_status AS ENUM (	
'1',
'2',
'3',
'99');

CREATE TYPE "staging".project_type AS ENUM (
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
CREATE TYPE "staging".reason_not_enrolled AS ENUM (	
'1',
'2',
'99');
CREATE TYPE "staging".record_type AS ENUM (	
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

CREATE TYPE "staging".referral_outcome AS ENUM (	
'1',
'2',
'3');
CREATE TYPE "staging".referral_source AS ENUM (	
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

CREATE TYPE "staging".relationship_to_head_of_household AS ENUM (
'1',
'2',
'3',
'4',
'5');
CREATE TYPE "staging".residence_prior  AS ENUM (	
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

CREATE TYPE "staging".residence_prior_length_of_stay AS ENUM (	
'2',
'3',
'4',
'5',
'8',
'9',
'10',
'11',
'99');
CREATE TYPE "staging".school_status AS ENUM (	
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
CREATE TYPE "staging".sexual_orientation AS ENUM (	
'1',
'2',
'3',
'4',
'5',
'8',
'9',
'99');
CREATE TYPE "staging".subsidy_information  AS ENUM (
'1',
'2',
'3',
'4');
CREATE TYPE "staging".target_population_type  AS ENUM ( 	
'1',
'3',
'4');

CREATE TYPE "staging".times_homeless_past_3_years  AS ENUM (
'0',
'1',
'2',
'3',
'4',
'8',
'9',
'99');

CREATE TYPE "staging".tracking_method  AS ENUM ( 	
'0',
'3');
CREATE TYPE "staging".when_dom_violence_occurred AS ENUM (
'1',
'2',
'3',
'4',
'8',
'9',
'99');
CREATE TYPE "staging".youth_age_group  AS ENUM (	
'1',
'2',
'3');

CREATE TYPE "staging".housing_status AS ENUM (
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

CREATE TYPE "staging".state AS ENUM (
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

-- DROP TABLE "staging"."base_metadata";


-- DROP TABLE "staging"."client";
CREATE TABLE staging.hmis_user
(
  id uuid NOT NULL,
  first_name character(50),
  middle_name character(50),
  last_name character(50),
  name_suffix character(50),
  ssn character(9),
  dob date,
  gender staging.gender,
  date_created date,
  date_updated date,
  CONSTRAINT hmis_user_pk PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);


 
CREATE TABLE "staging".hmis_type
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
      REFERENCES staging.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);


INSERT INTO "staging".hmis_type (name,value,description,status) values ('dobdataquality','1','Full DOB reported','ACTIVE');
INSERT INTO "staging".hmis_type (name,value,description,status) values   ('dobdataquality','2','Approximate or partial DOB reported','ACTIVE');
INSERT INTO "staging".hmis_type (name,value,description,status) values    ('dobdataquality','8','Client does not know','ACTIVE');
INSERT INTO "staging".hmis_type  (name,value,description,status) values  ('dobdataquality','9','Client refused','ACTIVE');
INSERT INTO "staging".hmis_type  (name,value,description,status) values ('dobdataquality','99','Data not collected','ACTIVE');


INSERT INTO "staging".hmis_type (name,value,description,status)  values ('race','1','American Indian or Alaska Native','ACTIVE');
INSERT INTO "staging".hmis_type (name,value,description,status)  values ('race','2','Asian','ACTIVE');
INSERT INTO "staging".hmis_type (name,value,description,status)  values ('race','3','Black or African American','ACTIVE');
INSERT INTO "staging".hmis_type (name,value,description,status)  values ('race','4','Native Hawaiian or Other Pacific Islander','ACTIVE');
INSERT INTO "staging".hmis_type (name,value,description,status)  values ('race','5','White','ACTIVE');
INSERT INTO "staging".hmis_type (name,value,description,status)  values ('race','8','Client does not know','ACTIVE');
INSERT INTO "staging".hmis_type (name,value,description,status)  values ('race','9','Client refused','ACTIVE');
INSERT INTO "staging".hmis_type (name,value,description,status)  values ('race','99','Data not collected','ACTIVE');

INSERT INTO "staging".hmis_type (name,value,description,status)  values ('gender','1','Male','ACTIVE');
INSERT INTO "staging".hmis_type (name,value,description,status)  values ('gender','2','Transgender male to female','ACTIVE');
INSERT INTO "staging".hmis_type (name,value,description,status)  values ('gender','3','Transgender female to male','ACTIVE');
INSERT INTO "staging".hmis_type (name,value,description,status)  values ('gender','4','Other','ACTIVE');
INSERT INTO "staging".hmis_type (name,value,description,status)  values ('gender','8','Client does not know','ACTIVE');
INSERT INTO "staging".hmis_type (name,value,description,status)  values ('gender','9','Client refused','ACTIVE');
INSERT INTO "staging".hmis_type (name,value,description,status)  values ('gender','99','Data not collected','ACTIVE');

INSERT INTO "staging".hmis_type (name,value,description,status) values ('namedataquality','1','Full name reported','ACTIVE');
INSERT INTO "staging".hmis_type (name,value,description,status) values   ('namedataquality','2','Partial, street name, or code name reported','ACTIVE');
INSERT INTO "staging".hmis_type (name,value,description,status) values    ('namedataquality','8','Client does not know','ACTIVE');
INSERT INTO "staging".hmis_type  (name,value,description,status) values  ('namedataquality','9','Client refused','ACTIVE');
INSERT INTO "staging".hmis_type  (name,value,description,status) values ('namedataquality','99','Data not collected','ACTIVE');

INSERT INTO "staging".hmis_type (name,value,description,status) values ('ssndataquality','1','Full SSN reported','ACTIVE');
INSERT INTO "staging".hmis_type (name,value,description,status) values   ('ssndataquality','2','Approximate or partial SSN reported','ACTIVE');
INSERT INTO "staging".hmis_type (name,value,description,status) values    ('ssndataquality','8','Client does not know','ACTIVE');
INSERT INTO "staging".hmis_type  (name,value,description,status) values  ('ssndataquality','9','Client refused','ACTIVE');
INSERT INTO "staging".hmis_type  (name,value,description,status) values ('ssndataquality','99','Data not collected','ACTIVE');

INSERT INTO "staging".hmis_type (name,value,description,status) values ('ethnicity','0','Non-Hispanic/Non-Latino','ACTIVE');
INSERT INTO "staging".hmis_type (name,value,description,status) values ('ethnicity','1','Hispanic/Latino','ACTIVE');
INSERT INTO "staging".hmis_type (name,value,description,status) values    ('ethnicity','8','Client does not know','ACTIVE');
INSERT INTO "staging".hmis_type  (name,value,description,status) values  ('ethnicity','9','Client refused','ACTIVE');
INSERT INTO "staging".hmis_type  (name,value,description,status) values ('ethnicity','99','Data not collected','ACTIVE');

INSERT INTO "staging".hmis_type (name,value,description,status) values ('veteran_status','0','No','ACTIVE');
INSERT INTO "staging".hmis_type (name,value,description,status) values ('veteran_status','1','Yes','ACTIVE');
INSERT INTO "staging".hmis_type (name,value,description,status) values    ('veteran_status','8','Client does not know','ACTIVE');
INSERT INTO "staging".hmis_type  (name,value,description,status) values  ('veteran_status','9','Client refused','ACTIVE');
INSERT INTO "staging".hmis_type  (name,value,description,status) values ('veteran_status','99','Data not collected','ACTIVE');


INSERT INTO "staging".hmis_type (name,value,description,status) values ('afghanistanoef','0','No','ACTIVE');
INSERT INTO "staging".hmis_type (name,value,description,status) values ('afghanistanoef','1','Yes','ACTIVE');
INSERT INTO "staging".hmis_type (name,value,description,status) values    ('afghanistanoef','8','Client does not know','ACTIVE');
INSERT INTO "staging".hmis_type  (name,value,description,status) values  ('afghanistanoef','9','Client refused','ACTIVE');
INSERT INTO "staging".hmis_type  (name,value,description,status) values ('afghanistanoef','99','Data not collected','ACTIVE');

create table "staging".source
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
      REFERENCES staging.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
     )
with (
  oids=false
);

create table "staging".export
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
      REFERENCES staging.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
      CONSTRAINT source_fkey FOREIGN KEY (source_id)
      REFERENCES staging.source (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
     )
with (
  oids=false
);

-- DROP TABLE "staging"."client";
CREATE TABLE "staging".client
(
  "id" uuid NOT NULL,
  "dedup_client_id" uuid,
  "first_name" character(50),
  "middle_name" character(50),
  "last_name" character(50),
  "name_suffix" character(50),
  "name_data_quality" "staging".name_data_quality,
   "ssn" character(9),
  "ssn_data_quality" "staging".ssn_data_quality,
  "dob" date,
  "dob_data_quality" "staging".dob_data_quality,
  "gender" "staging".gender,
  "other_gender" character(10),
  "ethnicity" "staging".ethnicity,
  "race"  "staging".race,
  "veteran_status" "staging".veteran_status,
  "date_created" date,
  "date_updated" date,
  "user_id" uuid,
   export_id uuid,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES staging.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT client_pk PRIMARY KEY ("id"),
   CONSTRAINT hmis_user_fkey FOREIGN KEY (user_id)
      REFERENCES staging.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
      )
WITH (
  OIDS=FALSE
);
-- Table: "staging"."client"


CREATE TABLE "staging".veteran_info
(
  "id" uuid NOT NULL,
  "year_entrd_service" integer,
  "year_seperated" integer,
  "world_war_2" "staging".five_val_dk_refused,
  "korean_war" "staging".five_val_dk_refused,
  "vietnam_war" "staging".five_val_dk_refused,
  "desert_storm" "staging".five_val_dk_refused,
  "afghanistan_oef" "staging".afghanistanoef,
  "iraq_oif" "staging".five_val_dk_refused,
  "iraq_ond" "staging".five_val_dk_refused,
  "other_theater" "staging".five_val_dk_refused,
  "military_branch" "staging".military_branch,
  "discharge_status" "staging".discharge_status,
  "date_created" date,
  "date_updated" date,
  "user_id" uuid,
  "client_id" uuid,
  export_id uuid,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES staging.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT veteran_info_pk PRIMARY KEY ("id"),
  CONSTRAINT veteran_info_client_fk FOREIGN KEY ("client_id")
      REFERENCES "staging".client ("id"),
   CONSTRAINT hmis_user_fkey FOREIGN KEY (user_id)
      REFERENCES staging.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);

CREATE TABLE "staging".enrollment
(
  id uuid NOT NULL,
 continuouslyHomelessOneYear "staging".youth_age_group,
disablingCondition "staging".five_val_dk_refused,
entrydate date,
householdid uuid,
housingstatus "staging".housing_status,
monthsHomelessPastThreeYears "staging".months_homeless_past_3_years,
monthsHomelessThisTime "staging".times_homeless_past_3_years,
otherresidenceprior character varying(50),
personalid uuid,
projectentryid uuid,
projectid uuid,
relationshiptohoh "staging".relationship_to_head_of_household,
residencePrior "staging".residence_prior,
residencePriorlengthofstay "staging".residence_prior_length_of_stay,
statusDocumented "staging".no_yes,
timesHomelesspastthreeyears "staging".times_homeless_past_3_years,
yearshomeless integer,
client_id uuid,
date_created date,
date_updated date,
user_id uuid,
export_id uuid,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES staging.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "enrollment_pkey" PRIMARY KEY (id),
    CONSTRAINT enrollment_client_fk FOREIGN KEY ("client_id")
      REFERENCES "staging".client ("id"),
 CONSTRAINT hmis_user_fkey FOREIGN KEY (user_id)
      REFERENCES staging.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);


CREATE TABLE "staging".path_status
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
      REFERENCES staging.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT path_status_pk PRIMARY KEY ("id"),
   CONSTRAINT "enrollment_path_status_fk_key" FOREIGN KEY ("enrollmentid")
      REFERENCES staging.enrollment ("id") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
   CONSTRAINT hmis_user_fkey FOREIGN KEY (user_id)
      REFERENCES staging.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);



CREATE TABLE "staging".rhybcp_status
(
  "id" uuid NOT NULL,
  "status_date" date,
  "fysb_youth" "staging".no_yes,
  "reason_no_services" "staging".fysb_rsn_not_providing_srvcs,
  "enrollmentid" uuid,
  "date_created" date,
  "date_updated" date,
  "user_id" uuid,
  export_id uuid,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES staging.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT rhybcp_status_pk PRIMARY KEY ("id"),
   CONSTRAINT "enrollment_rhybcp_status_fk_key" FOREIGN KEY ("enrollmentid")
      REFERENCES staging.enrollment ("id") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
   CONSTRAINT hmis_user_fkey FOREIGN KEY (user_id)
      REFERENCES staging.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);

-- Table: staging.last_perm_address



CREATE TABLE "staging".last_perm_address
(
  "id" uuid NOT NULL,
  "street" text,
  "city" text,
  "state" "staging".state,
  "zip" character(10),
  "address_data_quality" "staging".address_data_quality,
  "enrollmentid" uuid,
  "date_created" date,
  "date_updated" date,
  "user_id" uuid,
  export_id uuid,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES staging.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT last_perm_address_pk PRIMARY KEY ("id"),
   CONSTRAINT "enrollment_last_perm_address_fk_key" FOREIGN KEY ("enrollmentid")
      REFERENCES staging.enrollment ("id") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
   CONSTRAINT hmis_user_fkey FOREIGN KEY (user_id)
      REFERENCES staging.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);

-- Table: staging.percent_ami



CREATE TABLE "staging".percent_ami
(
 "id" uuid NOT NULL,
  "percentage" integer,
  "enrollmentid" uuid,
  "date_created" date,
  "date_updated" date,
  "user_id" uuid,
  export_id uuid,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES staging.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT percent_ami_pk PRIMARY KEY ("id"),
   CONSTRAINT "enrollment_percent_ami_fk_key" FOREIGN KEY ("enrollmentid")
      REFERENCES staging.enrollment ("id") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
   CONSTRAINT hmis_user_fkey FOREIGN KEY (user_id)
      REFERENCES staging.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
-- Table: staging.last_grade_completed

CREATE TABLE "staging".schoolstatus
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
      REFERENCES staging.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT school_status_pk PRIMARY KEY ("id"),
   CONSTRAINT "enrollment_schoolstatus_fk_key" FOREIGN KEY ("enrollmentid")
      REFERENCES staging.enrollment ("id") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
   CONSTRAINT hmis_user_fkey FOREIGN KEY (user_id)
      REFERENCES staging.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);


CREATE TABLE "staging".employment
(
  "id" uuid NOT NULL,
  "information_date" date,
  "employed" "staging".five_val_dk_refused,
  "employment_type" "staging".employment_type,
  "not_employed_reason" "staging".not_employed_reason,
  "enrollmentid" uuid,
  "date_created" date,
  "date_updated" date,
  "user_id" uuid,
  export_id uuid,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES staging.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT employment_pk PRIMARY KEY ("id"),
   CONSTRAINT "enrollment_coc_employment_fk_key" FOREIGN KEY ("enrollmentid")
      REFERENCES staging.enrollment ("id") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
   CONSTRAINT hmis_user_fkey FOREIGN KEY (user_id)
      REFERENCES staging.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);


CREATE TABLE "staging".health_status
(
  "id" uuid NOT NULL,
  "enrollmentid" uuid,
  "information_date" date,
  "health_category" "staging".health_category,
  "health_status" "staging".health_status_type,
  "due_date" date,
  "date_created" date,
  "date_updated" date,
  "user_id" uuid,
  export_id uuid,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES staging.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT health_status_pk PRIMARY KEY ("id"),
     CONSTRAINT "enrollment_health_status_fk_key" FOREIGN KEY ("enrollmentid")
      REFERENCES staging.enrollment ("id") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
   CONSTRAINT hmis_user_fkey FOREIGN KEY (user_id)
      REFERENCES staging.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);

create table "staging".organization
(
  organizationcommonname character varying(32),
  id uuid not null,
  organizationname character varying(32),
   "date_created" date,
  "date_updated" date,
  "user_id" uuid,
  export_id uuid,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES staging.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  constraint "organization_pkey" primary key (id),
      CONSTRAINT hmis_user_fkey FOREIGN KEY (user_id)
      REFERENCES staging.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
with (
  oids=false
);


CREATE TABLE  "staging".project
(
  id uuid NOT NULL,
  "enrollmentid" uuid,
  continuumproject "staging".no_yes,
  organizationid uuid,
  projectcommonname character varying(32),
  projectname character varying(32),
  projecttype "staging".project_type,
  residentialaffiliation "staging".no_yes,
  targetpopulation "staging".target_population_type,
  trackingmethod "staging".tracking_method,
   "date_created" date,
  "date_updated" date,
  "user_id" uuid,
  export_id uuid,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES staging.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "project_pk" PRIMARY KEY (id),
       CONSTRAINT "enrollment_project_fk_key" FOREIGN KEY ("enrollmentid")
      REFERENCES staging.enrollment ("id") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
        CONSTRAINT "organization_project_fkey" FOREIGN KEY (organizationid)
      REFERENCES staging.organization (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
   CONSTRAINT hmis_user_fkey FOREIGN KEY (user_id)
      REFERENCES staging.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);


-- Table: "affiliation"

-- DROP TABLE "affiliation";

CREATE TABLE "staging".affiliation
(
  id uuid NOT NULL,
  projectid uuid,
  resprojectid character varying(32),
   "date_created" date,
  "date_updated" date,
  "user_id" uuid,
  export_id uuid,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES staging.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "affiliation_pkey" PRIMARY KEY (id),
  CONSTRAINT "affiliation_project_fkey" FOREIGN KEY (projectid)
      REFERENCES staging.project (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
   CONSTRAINT hmis_user_fkey FOREIGN KEY (user_id)
      REFERENCES staging.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);



CREATE TABLE "staging".bedinventory
(
  id uuid NOT NULL,
  bed_inventory integer,
  ch_bed_inventory integer,
  vet_bed_inventory integer,
  youth_age_group "staging".youth_age_group,
  youth_bed_inventory bigint,
   "date_created" date,
  "date_updated" date,
  "user_id" uuid,
  export_id uuid,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES staging.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "bedinventory_pkey" PRIMARY KEY (id),
 CONSTRAINT hmis_user_fkey FOREIGN KEY (user_id)
      REFERENCES staging.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);

-- table: "projectcoc"

-- drop table "projectcoc";

create table "staging".projectcoc
(
  id uuid not null,
  coccode character varying(32),
  projectid uuid,
   date_created date,
date_updated date,
user_id uuid,
export_id uuid,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES staging.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  constraint "projectcoc_pkey" primary key (id),
  constraint "projectcoc_projectid_fkey" foreign key (projectid)
      references staging.project (id) match simple,
  CONSTRAINT "hmis_user_fkey" FOREIGN KEY (user_id)
      REFERENCES staging.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
with (
  oids=false
);
CREATE TABLE "staging".enrollment_coc
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
      REFERENCES staging.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
 CONSTRAINT "enrollment_coc_pkey" PRIMARY KEY ("id"),
  CONSTRAINT "enrollment_coc_project_co_fk_key" FOREIGN KEY ("enrollmentid")
      REFERENCES staging.enrollment ("id") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
   CONSTRAINT "project_coc_enrollment_coc_fkey" FOREIGN KEY ("project_co_id")
      REFERENCES staging.projectcoc ("id") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
 CONSTRAINT "hmis_user_fkey" FOREIGN KEY (user_id)
      REFERENCES staging.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);


create table "staging".site
(
id uuid not null,
address character varying(100),
city  character varying(50),
geocode  integer, 
principal_site "staging".no_yes,
project_coc_id uuid,
state "staging".state, 
zip text,
date_created date,
date_updated date,
user_id uuid,
export_id uuid,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES staging.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
constraint "site_pkey" primary key (id),
  constraint "site_projectcoc_fkey" foreign key (project_coc_id)
      references staging."projectcoc" (id) match simple
      on update no action on delete no action,
       CONSTRAINT hmis_user_fkey FOREIGN KEY (user_id)
      REFERENCES staging.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
with (
  oids=false
);



create table "staging".inventory
(
   id uuid not null,
  availabilty "staging".availability,
  bedinventory uuid,
  bedtype "staging".bed_type,
  hmisparticipatingbeds integer,
  householdtype "staging".house_hold_type,
  inventoryenddate date,
  inventorystartdate date,
  project_coc_id uuid,
  unitinventory integer,
  date_created date,
date_updated date,
user_id uuid,
export_id uuid,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES staging.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  constraint "inventory_pkey" primary key (id),
  constraint "inventory_projectcocid_fkey" foreign key (project_coc_id)
      references staging."projectcoc" (id) match simple
      on update no action on delete no action,
      CONSTRAINT "bed_inventory_fkey" FOREIGN KEY (bedinventory)
      REFERENCES staging.bedinventory (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
        CONSTRAINT hmis_user_fkey FOREIGN KEY (user_id)
      REFERENCES staging.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
with (
  oids=false
);


-- table: "funder"

-- drop table "funder";

create table  "staging".funder
(
"id"  uuid not null,
  "enddate" date,
  "funder" "staging".federal_partner_components,
  "grantid" uuid,
  "projectid" uuid,
  "startdate" date,
  date_created date,
date_updated date,
user_id uuid,
export_id uuid,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES staging.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  constraint "funder_pkey" primary key ("id"),
  constraint "funder_projectid_fkey" foreign key ("projectid")
      references staging.project (id) match simple
      on update no action on delete no action,
        CONSTRAINT hmis_user_fkey FOREIGN KEY (user_id)
      REFERENCES staging.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
with (
  oids=false
);


-- table: "pathstatus"

-- drop table "pathstatus";

create table "staging".pathstatus
(
  clientenrolledinpath "staging".no_yes,
  dateofstatus date,
  id uuid not null,
  enrollmentid uuid,
  reasonnotenrolled "staging".reason_not_enrolled,
   "date_created" date,
  "date_updated" date,
  "user_id" uuid,
  export_id uuid,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES staging.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  constraint "pathstatus_pkey" primary key (id),
  constraint "pathstatus_enrollmentid_fkey" foreign key (enrollmentid)
      references staging.enrollment ("id") match simple
      on update no action on delete no action,
            CONSTRAINT hmis_user_fkey FOREIGN KEY (user_id)
      REFERENCES staging.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
with (
  oids=false
);


create table "staging".rhybcpstatus
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
      REFERENCES staging.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  constraint "rhybcpstatus_pkey" primary key (id),
  constraint "rhybcpstatus_enrollmentid_fkey" foreign key (enrollmentid)
      references staging.enrollment ("id") match simple
      on update no action on delete no action,
                  CONSTRAINT hmis_user_fkey FOREIGN KEY (user_id)
      REFERENCES staging.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
with (
  oids=false
);


-- table: "sexualorientation"

-- drop table "sexualorientation";

create table "staging".sexualorientation
(
  id uuid not null,
  enrollmentid uuid,
  sexualorientation "staging".sexual_orientation,
  "date_created" date,
  "date_updated" date,
  "user_id" uuid,
  export_id uuid,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES staging.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  constraint "sexualorientation_pkey" primary key (id),
  constraint "sexualorientation_enrollmentid_fkey" foreign key (enrollmentid)
      references staging.enrollment ("id") match simple
      on update no action on delete no action,
                  CONSTRAINT hmis_user_fkey FOREIGN KEY (user_id)
      REFERENCES staging.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
with (
  oids=false
);

create table "staging".formerwardjuvenilejustice
(
"id" uuid not null,
  "formerwardjuvenilejustice" "staging".five_val_dk_refused,
  "juvenilejusticemonths" integer,
  "juvenilejusticeyears"  "staging".issues_number_of_years,
  "enrollmentid" uuid,
   "date_created" date,
  "date_updated" date,
  "user_id" uuid,
  export_id uuid,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES staging.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  constraint "formerwardjuvenilejustice_pkey" primary key ("id"),
  constraint "formerwardjuvenilejustice_enrollmentid_fkey" foreign key ("enrollmentid")
      references staging.enrollment ("id") match simple
      on update no action on delete no action,
                    CONSTRAINT hmis_user_fkey FOREIGN KEY (user_id)
      REFERENCES staging.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
with (
  oids=false
);

create table "staging".lastpermanentaddress
(
  id uuid not null,
  addressdataquality integer,
  lastpermanentcity character varying(50),
  lastpermanentstate "staging".state,
  lastpermanentstreet character varying(100),
  lastpermanentzip character varying(32),
  enrollmentid uuid,
   "date_created" date,
  "date_updated" date,
  "user_id" uuid,
  export_id uuid,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES staging.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  constraint "lastpermanentaddress_pkey" primary key (id),
  constraint "lastpermanentaddress_enrollmentid_fkey" foreign key (enrollmentid)
      references staging.enrollment ("id") match simple
      on update no action on delete no action,
                    CONSTRAINT hmis_user_fkey FOREIGN KEY (user_id)
      REFERENCES staging.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
with (
  oids=false
);

create table "staging".percentami
(
  percentami integer,
  id uuid not null,
  enrollmentid uuid,
     "date_created" date,
  "date_updated" date,
  "user_id" uuid,
  export_id uuid,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES staging.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  constraint "percentami_pkey" primary key (id),
  constraint "percentami_enrollmentid_fkey" foreign key (enrollmentid)
      references staging.enrollment ("id") match simple
      on update no action on delete no action,
   CONSTRAINT hmis_user_fkey FOREIGN KEY (user_id)
      REFERENCES staging.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
with (
  oids=false
);

-- table: "medicalassistance"

-- drop table "medicalassistance";

create table "staging".medicalassistance
(
  adap "staging".five_val_dk_refused,
  hivaidsassistance "staging".five_val_dk_refused,
  id uuid not null,
  noadapreason "staging".no_medical_assistance_reason,
  nohivaidsassistancereason "staging".no_medical_assistance_reason,
   enrollmentid uuid,
     "date_created" date,
  "date_updated" date,
  "user_id" uuid,
  export_id uuid,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES staging.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  constraint "medicalassistance_pkey" primary key (id),
  constraint "medicalassistance_enrollmentid_fkey" foreign key (enrollmentid)
      references staging.enrollment ("id") match simple
      on update no action on delete no action,
         CONSTRAINT hmis_user_fkey FOREIGN KEY (user_id)
      REFERENCES staging.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
      
)
with (
  oids=false
);



create table "staging".youthcriticalissues
(
  abuseandneglectfam "staging".no_yes,
  abuseandneglectyouth "staging".no_yes,
  activemilitaryparent "staging".no_yes,
  alcoholdrugabusefam "staging".no_yes,
  alcoholdrugabuseyouth "staging".no_yes,
  healthissuesfam "staging".no_yes,
  healthissuesyouth "staging".no_yes,
  householddynamics "staging".no_yes,
  housingissuesfam "staging".no_yes,
  housingissuesyouth "staging".no_yes,
  incarceratedparent "staging".no_yes,
  incarceratedparentstatus  "staging".incarcerated_parent_status,
  insufficientincome "staging".no_yes,
  mentaldisabilityfam "staging".no_yes,
  mentaldisabilityyouth "staging".no_yes,
  mentalhealthissuesfam "staging".no_yes,
  mentalhealthissuesyouth "staging".no_yes,
  physicaldisabilityfam "staging".no_yes,
  physicaldisabilityyouth "staging".no_yes,
  enrollmentid uuid,
  schooleducationalissuesfam "staging".no_yes,
  schooleducationalissuesyouth "staging".no_yes,
  sexualorientationgenderidfam "staging".no_yes,
  sexualorientationgenderidyouth "staging".no_yes,
  unemploymentfam "staging".no_yes,
  unemploymentyouth "staging".no_yes,
  id uuid not null,
     "date_created" date,
  "date_updated" date,
  "user_id" uuid,
  export_id uuid,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES staging.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  constraint "youthcriticalissues_pkey" primary key (id),
  constraint "youthcriticalissues_enrollmentid_fkey" foreign key (enrollmentid)
      references staging.enrollment ("id") match simple
      on update no action on delete no action,
       CONSTRAINT hmis_user_fkey FOREIGN KEY (user_id)
      REFERENCES staging.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
with (
  oids=false
);

-- table: "worsthousingsituation"

-- drop table "worsthousingsituation";

create table  "staging".worsthousingsituation
(
  enrollmentid uuid,
  worsthousingsituation "staging".five_val_dk_refused,
  id uuid not null,
      "date_created" date,
  "date_updated" date,
  "user_id" uuid,
  export_id uuid,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES staging.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  constraint "worsthousingsituation_pkey" primary key (id),
  constraint "worsthousingsituation_enrollmentid_fkey" foreign key (enrollmentid)
      references staging.enrollment ("id") match simple
      on update no action on delete no action,
       CONSTRAINT hmis_user_fkey FOREIGN KEY (user_id)
      REFERENCES staging.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
with (
  oids=false
);

create table "staging".formerwardchildwelfare
(
  "childwelfaremonths" integer,
  "childwelfareyears" "staging".issues_number_of_years,
  "formerwardchildwelfare" "staging".five_val_dk_refused,
  "id" uuid not null,
  "enrollmentid" uuid,
     "date_created" date,
  "date_updated" date,
  "user_id" uuid,
  export_id uuid,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES staging.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  constraint "formerwardchildwelfare_pkey" primary key ("id"),
  constraint "formerwardchildwelfare_enrollmentid_fkey" foreign key ("enrollmentid")
      references staging.enrollment ("id") match simple
      on update no action on delete no action,
          CONSTRAINT hmis_user_fkey FOREIGN KEY (user_id)
      REFERENCES staging.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
with (
  oids=false
);


-- drop table "lastgradecompleted";

create table "staging".lastgradecompleted
(
  lastgradecompleted "staging".last_grade_completed,
  id uuid not null,
  enrollmentid uuid,
       "date_created" date,
  "date_updated" date,
  "user_id" uuid,
  export_id uuid,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES staging.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  constraint "lastgradecompleted_pkey" primary key (id),
  constraint "lastgradecompleted_enrollmentid_fkey" foreign key (enrollmentid)
      references staging.enrollment ("id") match simple
      on update no action on delete no action,
                CONSTRAINT hmis_user_fkey FOREIGN KEY (user_id)
      REFERENCES staging.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
with (
  oids=false
);


create table "staging".referralsource
(
  countoutreachreferralapproaches integer,
  enrollmentid uuid,
  referralsource "staging".referral_source,
  id uuid not null,
       "date_created" date,
  "date_updated" date,
  "user_id" uuid,
  export_id uuid,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES staging.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  constraint "referralsource_pkey" primary key (id),
  constraint "referralsource_enrollmentid_fkey" foreign key (enrollmentid)
      references staging.enrollment ("id") match simple
      on update no action on delete no action,
                 CONSTRAINT hmis_user_fkey FOREIGN KEY (user_id)
      REFERENCES staging.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
with (
  oids=false
);


create table "staging".commercialsexualexploitation
(
  "askedorforcedtoexchangeforsex" "staging".asked_forced_exchange_sex,
  "id" uuid not null,
  "countofexchangeforsex" "staging".count_of_exchange_sex,
  "exchangeforsexpastthreemonths" "staging".five_val_dk_refused,
   enrollmentid uuid,
   "date_created" date,
  "date_updated" date,
  "user_id" uuid,
  export_id uuid,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES staging.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  constraint "commercialsexualexploitation_pkey" primary key ("id"),
  constraint "commercialsexualexploitation_enrollmentid_fkey" foreign key ("enrollmentid")
      references staging.enrollment ("id") match simple
      on update no action on delete no action,
                 CONSTRAINT hmis_user_fkey FOREIGN KEY (user_id)
      REFERENCES staging.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
with (
  oids=false
);

-- table: "domesticviolence"

-- drop table "domesticviolence";

create table "staging".domesticviolence
(
  "id"  uuid not null,
  "domesticviolencevictim" "staging".five_val_dk_refused,
  "enrollmentid" uuid,
  "whenoccurred" "staging".when_dom_violence_occurred,
       "date_created" date,
  "date_updated" date,
  "user_id" uuid,
  export_id uuid,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES staging.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  constraint "domesticviolence_pkey" primary key ("id"),
  constraint "domesticviolence_enrollmentid_fkey" foreign key ("enrollmentid")
      references staging.enrollment ("id") match simple
      on update no action on delete no action,
                 CONSTRAINT hmis_user_fkey FOREIGN KEY (user_id)
      REFERENCES staging.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
with (
  oids=false
);

-- table: "disabilities"

-- drop table "disabilities";

create table "staging".disabilities
(
  "id" uuid not null,
  "disabilityresponse" integer,
  "disabilitytype" "staging".disability_type,
  "documentationonfile" "staging".no_yes,
  "indefiniteandimpairs" "staging".five_val_dk_refused,
  "pathhowconfirmed" "staging".path_how_confirmed,
  "pathsmiinformation" "staging".path_smi_info_how_confirmed,
   "enrollmentid" uuid,
  "receivingservices" "staging".five_val_dk_refused,
         "date_created" date,
  "date_updated" date,
  "user_id" uuid,
  export_id uuid,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES staging.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  constraint "disabilities_pkey" primary key ("id"),
  constraint "disabilities_enrollmentid_fkey" foreign key ("enrollmentid")
      references staging.enrollment ("id") match simple
      on update no action on delete no action,
                CONSTRAINT hmis_user_fkey FOREIGN KEY (user_id)
      REFERENCES staging.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
with (
  oids=false
);
-- table: "residentialmoveindate"

-- drop table "residentialmoveindate";

create table  "staging".residentialmoveindate
(
  inpermanenthousing "staging".no_yes,
  enrollmentid uuid,
  residentialmoveindate date,
  id uuid not null,       
  "date_created" date,
  "date_updated" date,
  "user_id" uuid,
  export_id uuid,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES staging.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  constraint "residentialmoveindate_pkey" primary key (id),
  constraint "residentialmoveindate_enrollmentid_fkey" foreign key (enrollmentid)
      references staging.enrollment ("id") match simple,
         CONSTRAINT hmis_user_fkey FOREIGN KEY (user_id)
      REFERENCES staging.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
with (
  oids=false
);

-- table: "dateofengagement"

-- drop table "dateofengagement";

create table  "staging".dateofengagement
(
  "dateofengagement" date,
  "id" uuid not null,
  "enrollmentid" uuid,
           "date_created" date,
  "date_updated" date,
  "user_id" uuid,
  export_id uuid,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES staging.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  constraint "dateofengagement_pkey" primary key ("id"),
  constraint "dateofengagement_enrollmentid_fkey" foreign key ("enrollmentid")
      references staging.enrollment ("id") match simple
      on update no action on delete no action,
       CONSTRAINT hmis_user_fkey FOREIGN KEY (user_id)
      REFERENCES staging.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
with (
  oids=false
);


create table "staging".services
(
  dateprovided date,
  faamount numeric(15,3),
  othertypeprovided character varying(50),
  enrollmentid uuid,
  recordtype "staging".record_type,
  referraloutcome "staging".referral_outcome,
  id uuid not null,
  subtypeprovided integer,
  typeprovided integer,
           "date_created" date,
  "date_updated" date,
  "user_id" uuid,
  export_id uuid,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES staging.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  constraint "services_pkey" primary key (id),
  constraint "services_enrollmentid_fkey" foreign key (enrollmentid)
      references staging.enrollment ("id") match simple
      on update no action on delete no action,
            CONSTRAINT hmis_user_fkey FOREIGN KEY (user_id)
      REFERENCES staging.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
with (
  oids=false
);


-- drop table "incomeandsources";

create table "staging".incomeandsources
(
  alimony "staging".no_yes,
  alimonyamount numeric(15,3),
  childsupport "staging".no_yes,
  childsupportamount numeric(15,3),
  earned "staging".no_yes,
  earnedamount numeric(15,3),
  ga "staging".no_yes,
  gaamount numeric(15,3),
  id uuid not null,
  incomefromanysource "staging".five_val_dk_refused,
  othersource "staging".no_yes,
  othersourceamount numeric(15,3),
  othersourceidentify character varying(32),
  pension "staging".no_yes,
  pensionamount numeric(15,3),
  privatedisability "staging".no_yes,
  privatedisabilityamount numeric(15,3),
  enrollmentid uuid,
  socsecretirement "staging".no_yes,
  socsecretirementamount numeric(15,3),
  ssdi "staging".no_yes,
  ssdiamount numeric(15,3),
  ssi "staging".no_yes,
  ssiamount numeric(15,3),
  tanf "staging".no_yes,
  tanfamount numeric(15,3),
  totalmonthlyincome numeric(15,3),
  unemployment "staging".no_yes,
  unemploymentamount numeric(15,3),
  vadisabilitynonservice "staging".no_yes,
  vadisabilitynonserviceamount numeric(15,3),
  vadisabilityservice "staging".no_yes,
  vadisabilityserviceamount numeric(15,3),
  workerscomp "staging".no_yes,
  workerscompamount numeric(15,3),
           "date_created" date,
  "date_updated" date,
  "user_id" uuid,
  export_id uuid,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES staging.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  constraint "incomeandsources_pkey" primary key (id),
  constraint "incomeandsources_enrollmentid_fkey" foreign key (enrollmentid)
      references staging.enrollment ("id") match simple
      on update no action on delete no action,
            CONSTRAINT hmis_user_fkey FOREIGN KEY (user_id)
      REFERENCES staging.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
with (
  oids=false
);



-- drop table "noncashbenefits";

create table "staging".noncashbenefits
(
  benefitsfromanysource "staging".five_val_dk_refused,
  id uuid not null,
  othersource "staging".no_yes,
  othersourceidentify character varying(32),
  othertanf "staging".no_yes,
  enrollmentid uuid,
  rentalassistanceongoing "staging".no_yes,
  rentalassistancetemp "staging".no_yes,
  snap "staging".no_yes,
  tanfchildcare "staging".no_yes,
  tanftransportation "staging".no_yes,
  wic "staging".no_yes,
             "date_created" date,
  "date_updated" date,
  "user_id" uuid,
  export_id uuid,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES staging.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  constraint "noncashbenefits_pkey" primary key (id),
  constraint "noncashbenefits_enrollmentid_fkey" foreign key (enrollmentid)
      references staging.enrollment ("id") match simple
      on update no action on delete no action,
                  CONSTRAINT hmis_user_fkey FOREIGN KEY (user_id)
      REFERENCES staging.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
with (
  oids=false
);

-- table: "healthinsurance"

-- drop table "healthinsurance";

create table "staging".healthinsurance
(
  "cobra" integer,
  "employerprovided" integer,
  "id" uuid not null,
  "insurancefromanysource" "staging".five_val_dk_refused,
  "medicaid" "staging".no_yes,
  "medicare" "staging".no_yes,
  "nocobrareason" "staging".no_health_insurance_reason,
  "noemployerprovidedreason" "staging".no_health_insurance_reason,
  "nomedicaidreason" "staging".no_health_insurance_reason,
  "nomedicarereason" "staging".no_health_insurance_reason,
  "noprivatepayreason" "staging".no_health_insurance_reason,
  "noschipreason" "staging".no_health_insurance_reason,
  "nostatehealthinsreason" "staging".no_health_insurance_reason,
  "novamedreason" "staging".no_health_insurance_reason,
  "privatepay" "staging".no_yes,
  "enrollmentid" uuid,
  "schip" "staging".no_yes,
  "statehealthins" "staging".no_yes,
  "vamedicalservices" "staging".no_yes,
  "date_created" date,
  "date_updated" date,
  "user_id" uuid,
  export_id uuid,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES staging.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  constraint "healthinsurance_pkey" primary key ("id"),
  constraint "healthinsurance_enrollmentid_fkey" foreign key ("enrollmentid")
      references staging.enrollment ("id") match simple
      on update no action on delete no action,
                       CONSTRAINT hmis_user_fkey FOREIGN KEY (user_id)
      REFERENCES staging.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
with (
  oids=false
);

create table "staging".exit
(
  "destination" "staging".destination,
  "exitdate" date,
  "id" uuid not null,
  "otherdestination" character varying(32),
  "enrollmentid" uuid,
                 "date_created" date,
  "date_updated" date,
  "user_id" uuid,
  export_id uuid,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES staging.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  constraint "exit_pkey" primary key ("id"),
  constraint "exit_enrollmentid_fkey" foreign key ("enrollmentid")
      references staging.enrollment ("id") match simple
      on update no action on delete no action,
                          CONSTRAINT hmis_user_fkey FOREIGN KEY (user_id)
      REFERENCES staging.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
with (
  oids=false
);


create table  "staging".exithousingassessment
(
  "id" uuid not null,
  "exitid" uuid,
  "housingassessment" "staging".housing_assmnt_exit,
  "subsidyinformation" "staging".subsidy_information,
  "date_created" date,
  "date_updated" date,
  "user_id" uuid,
  export_id uuid,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES staging.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  constraint "exithousingassessment_pkey" primary key ("id"),
  constraint "exithousingassessment_exitid_fkey" foreign key ("exitid")
      references staging."exit" ("id") match simple
      on update no action on delete no action,
                        CONSTRAINT hmis_user_fkey FOREIGN KEY (user_id)
      REFERENCES staging.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
with (
  oids=false
);

-- table: "exitplansactions"

-- drop table "exitplansactions";

create table  "staging".exitplansactions
(
  "assistancemainstreambenefits" "staging".no_yes_refused,
  "exitcounseling"  "staging".no_yes_refused,
  "exitid" uuid,
  "id" uuid not null,
  "furtherfollowupservices" "staging".no_yes_refused,
  "otheraftercareplanoraction" "staging".no_yes_refused,
  "permanenthousingplacement" "staging".no_yes_refused,
  "resourcepackage" "staging".no_yes_refused,
  "scheduledfollowupcontacts" "staging".no_yes_refused,
  "temporaryshelterplacement" "staging".no_yes_refused,
  "writtenaftercareplan" "staging".no_yes_refused,
                    "date_created" date,
  "date_updated" date,
  "user_id" uuid,
  export_id uuid,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES staging.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  constraint "exitplansactions_pkey" primary key ("id"),
  constraint "exitplansactions_exitid_fkey" foreign key ("exitid")
      references staging."exit" ("id") match simple
      on update no action on delete no action,
                CONSTRAINT hmis_user_fkey FOREIGN KEY (user_id)
      REFERENCES staging.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
with (
  oids=false
);


-- table: "housingassessmentdisposition"

-- drop table "housingassessmentdisposition";

create table "staging".housingassessmentdisposition
(
  "assessmentdisposition" "staging".assessment_disposition,
  "exitid" uuid,
  "id" uuid not null,
  "otherdisposition" character varying(32),
              "date_created" date,
  "date_updated" date,
  "user_id" uuid,
  export_id uuid,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES staging.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  constraint "housingassessmentdisposition_pkey" primary key ("id"),
  constraint "housingassessmentdisposition_exitid_fkey" foreign key ("exitid")
      references staging."exit" ("id") match simple
      on update no action on delete no action,
                  CONSTRAINT hmis_user_fkey FOREIGN KEY (user_id)
      REFERENCES staging.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
with (
  oids=false
);


create table "staging".familyreunification
(
  "exitid" uuid,
  "familyreunificationachieved" "staging".five_val_dk_refused,
  "id" uuid not null,
              "date_created" date,
  "date_updated" date,
  "user_id" uuid,
  export_id uuid,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES staging.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  constraint "familyreunification_pkey" primary key ("id"),
  constraint "familyreunification_exitid_fkey" foreign key ("exitid")
      references staging."exit" ("id") match simple
      on update no action on delete no action,
                  CONSTRAINT hmis_user_fkey FOREIGN KEY (user_id)
      REFERENCES staging.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
with (
  oids=false
);

-- drop table "connectionwithsoar";

create table "staging".connectionwithsoar
(
  "connectionwithsoar" integer,
  "id" uuid,
  "exitid" uuid,
           "date_created" date,
  "date_updated" date,
  "user_id" uuid,
  export_id uuid,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES staging.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  constraint "connectionwithsoar_pkey" primary key ("id"),
  constraint "connectionwithsoar_exitid_fkey" foreign key ("exitid")
      references staging."exit" ("id") match simple
      on update no action on delete no action,
                CONSTRAINT hmis_user_fkey FOREIGN KEY (user_id)
      REFERENCES staging.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
with (
  oids=false
);
-- table: "projectcompletionstatus"

-- drop table "projectcompletionstatus";

create table "staging".projectcompletionstatus
(
  earlyexitreason "staging".early_exit_reason,
  exitid uuid,
  projectcompletionstatus "staging".project_completion_status,
  id uuid not null,
          "date_created" date,
  "date_updated" date,
  "user_id" uuid,
  export_id uuid,
      CONSTRAINT export_fkey FOREIGN KEY (export_id)
      REFERENCES staging.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  constraint "projectcompletionstatus_pkey" primary key (id),
  constraint "projectcompletionstatus_exitid_fkey" foreign key (exitid)
      references staging."exit" ("id") match simple
      on update no action on delete no action,
         CONSTRAINT hmis_user_fkey FOREIGN KEY (user_id)
      REFERENCES staging.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
     )
with (
  oids=false
);

-- drop table "projectcompletionstatus";

CREATE TABLE "staging".sync
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

CREATE TABLE "staging".bulk_upload
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
      REFERENCES staging.export (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT bulk_upload_pk PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);

CREATE SEQUENCE "staging".bulk_upload_id_seq START 1;

CREATE TABLE "staging".hud_coc_report_question_7(
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

CREATE SEQUENCE "staging".seq_consent_message START 1;

CREATE TABLE staging.hmis_consent_message
(
  id bigint NOT NULL,
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

CREATE SEQUENCE "staging".seq_verification START 1;

CREATE TABLE staging.hmis_verification
(
  id integer NOT NULL,
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

CREATE SEQUENCE "staging".seq_service START 1;

CREATE TABLE staging.hmis_service
(
  id bigint NOT NULL,
  external_id character varying(128),
  friendly_name character varying(256),
  description character varying(512),
  license_type character varying(20) NOT NULL,
  developer_company_id bigint NOT NULL,
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

CREATE SEQUENCE "staging".seq_trusted_app START 1;

CREATE TABLE staging.hmis_trusted_app
(
  id bigint NOT NULL,
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
  container_trustedapp_id bigint,
  logo_url character varying(1048),
  service_id bigint,
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
      REFERENCES staging.hmis_service (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);

CREATE SEQUENCE "staging".seq_account_consent START 1;

CREATE TABLE staging.hmis_account_consent
(
  id bigint NOT NULL,
  trustedapp_id bigint,
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
      REFERENCES staging.hmis_trusted_app (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "FK_AC_USERID" FOREIGN KEY (user_id)
      REFERENCES staging.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);

CREATE SEQUENCE "staging".seq_account_data_change START 1;

CREATE TABLE staging.hmis_account_data_change
(
  id integer NOT NULL,
  old_user_name character varying(256),
  new_user_name character varying(256),
  verification_id integer,
  created_at date,
  modified_at date,
  created_by character varying(256),
  modified_by character varying(256),
  user_id uuid,
  CONSTRAINT "PK_ACCOUNT_DATA_CHANGE" PRIMARY KEY (id),
  CONSTRAINT "FK_ADCHANGE_USERID" FOREIGN KEY (user_id)
      REFERENCES staging.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "FK_ADC_VERIFICATIONID" FOREIGN KEY (verification_id)
      REFERENCES staging.hmis_verification (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);

CREATE SEQUENCE "staging".seq_account_lockout START 1;

CREATE TABLE staging.hmis_account_lockout
(
  id integer NOT NULL,
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
      REFERENCES staging.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);

CREATE SEQUENCE "staging".seq_account_preference START 1;

CREATE TABLE staging.hmis_account_preference
(
  id integer NOT NULL,
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
      REFERENCES staging.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);

CREATE SEQUENCE "staging".seq_api_group START 1;

CREATE TABLE staging.hmis_api_group
(
  id bigint NOT NULL,
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
  consent_message_id bigint,
  detailed_consent_message_id bigint,
  CONSTRAINT "PK_API_GROUP" PRIMARY KEY (id),
  CONSTRAINT "FK_AG_CONSENT_MESSAGE_ID" FOREIGN KEY (consent_message_id)
      REFERENCES staging.hmis_consent_message (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "FK_AG_DTL_CONSENT_MESSAGE_ID" FOREIGN KEY (detailed_consent_message_id)
      REFERENCES staging.hmis_consent_message (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);

INSERT INTO staging.hmis_api_group(id, external_id, friendly_name, description, authorization_msg, created_at,  created_by)
    VALUES (1, 'DEVELOPER_SERVICES','DEVELOPER SERVICES', 'DEVELOPER SERVICES', 'DEVELOPER SERVICES', current_date,  'MASTER DATA'),
	       (2, 'USER_SERVICES','USER SERVICES', 'USER SERVICES', 'USER SERVICES', current_date,  'MASTER DATA'),
	       (3, 'ACL_SERVICES','ACL SERVICES', 'ACL SERVICES', 'ACL SERVICES', current_date,  'MASTER DATA'),
	       (4, 'AUTH_SERVICES','AUTH SERVICES', 'AUTH SERVICES', 'AUTH SERVICES', current_date,  'MASTER DATA');


CREATE SEQUENCE "staging".seq_api_method START 1;

CREATE TABLE staging.hmis_api_method
(
  id bigint NOT NULL,
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
  api_group_id bigint,
  deprecated bigint DEFAULT 0,
  consent_message_id bigint,
  detailed_consent_message_id bigint,
  is_public boolean,
  requires_access_token boolean,
  CONSTRAINT "PK_API_METHOD" PRIMARY KEY (id),
  CONSTRAINT "FK_AM_CONSENT_MESSAGE_ID" FOREIGN KEY (consent_message_id)
      REFERENCES staging.hmis_consent_message (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "FK_AM_DTL_CONSENT_MESSAGE_ID" FOREIGN KEY (detailed_consent_message_id)
      REFERENCES staging.hmis_consent_message (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "FK_AM_GROUP_ID" FOREIGN KEY (api_group_id)
      REFERENCES staging.hmis_api_group (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);


INSERT INTO staging.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES (1,'ACL_CREATE_ROLE','ACL_CREATE_ROLE','ACL_CREATE_ROLE','POST',CURRENT_DATE,'MASTER DATA',3,0,TRUE);
INSERT INTO staging.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES (2,'ACL_UPDATE_ROLE','ACL_UPDATE_ROLE','ACL_UPDATE_ROLE','PUT',CURRENT_DATE,'MASTER DATA',3,0,TRUE);
INSERT INTO staging.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES (3,'ACL_DELETE_ROLE','ACL_DELETE_ROLE','ACL_DELETE_ROLE','DELETE',CURRENT_DATE,'MASTER DATA',3,0,TRUE);
INSERT INTO staging.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES (4,'ACL_GET_ALL_ROLES','ACL_GET_ALL_ROLES','ACL_GET_ALL_ROLES','GET',CURRENT_DATE,'MASTER DATA',3,0,TRUE);
INSERT INTO staging.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES (5,'ACL_CREATE_SHARING_RULE','ACL_CREATE_SHARING_RULE','ACL_CREATE_SHARING_RULE','POST',CURRENT_DATE,'MASTER DATA',3,0,TRUE);
INSERT INTO staging.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES (6,'ACL_UPDATE_SHARING_RULE','ACL_UPDATE_SHARING_RULE','ACL_UPDATE_SHARING_RULE','PUT',CURRENT_DATE,'MASTER DATA',3,0,TRUE);
INSERT INTO staging.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES (7,'ACL_DELETE_SHARING_RULE','ACL_DELETE_SHARING_RULE','ACL_DELETE_SHARING_RULE','DELETE',CURRENT_DATE,'MASTER DATA',3,0,TRUE);
INSERT INTO staging.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES (8,'ACL_CREATE_PROFILE','ACL_CREATE_PROFILE','ACL_CREATE_PROFILE','POST',CURRENT_DATE,'MASTER DATA',3,0,TRUE);
INSERT INTO staging.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES (9,'ACL_UPDATE_PROFILE','ACL_UPDATE_PROFILE','ACL_UPDATE_PROFILE','PUT',CURRENT_DATE,'MASTER DATA',3,0,TRUE);
INSERT INTO staging.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES (10,'ACL_DELETE_PROFILE','ACL_DELETE_PROFILE','ACL_DELETE_PROFILE','DELETE',CURRENT_DATE,'MASTER DATA',3,0,TRUE);
INSERT INTO staging.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES (11,'ACL_GET_PROFILE','ACL_GET_PROFILE','ACL_GET_PROFILE','GET',CURRENT_DATE,'MASTER DATA',3,0,TRUE);
INSERT INTO staging.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES (12,'ACL_GET_ALL_PROFILES','ACL_GET_ALL_PROFILES','ACL_GET_ALL_PROFILES','GET',CURRENT_DATE,'MASTER DATA',3,0,TRUE);
INSERT INTO staging.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES (13,'ACL_CREATE_PRMISSION_SET','ACL_CREATE_PRMISSION_SET','ACL_CREATE_PRMISSION_SET','POST',CURRENT_DATE,'MASTER DATA',3,0,TRUE);
INSERT INTO staging.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES (14,'ACL_UPDATE_PRMISSION_SET','ACL_UPDATE_PRMISSION_SET','ACL_UPDATE_PRMISSION_SET','PUT',CURRENT_DATE,'MASTER DATA',3,0,TRUE);
INSERT INTO staging.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES (15,'ACL_DELETE_PRMISSION_SET','ACL_DELETE_PRMISSION_SET','ACL_DELETE_PRMISSION_SET','DELETE',CURRENT_DATE,'MASTER DATA',3,0,TRUE);
INSERT INTO staging.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES (16,'ACL_GET_PRMISSION_SET','ACL_GET_PRMISSION_SET','ACL_GET_PRMISSION_SET','GET',CURRENT_DATE,'MASTER DATA',3,0,TRUE);
INSERT INTO staging.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES (17,'ACL_ASSIGN_PRMISSION_SET','ACL_ASSIGN_PRMISSION_SET','ACL_ASSIGN_PRMISSION_SET','PUT',CURRENT_DATE,'MASTER DATA',3,0,TRUE);
INSERT INTO staging.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES (18,'ACL_CREATE_USER_ROLE','ACL_CREATE_USER_ROLE','ACL_CREATE_USER_ROLE','POST',CURRENT_DATE,'MASTER DATA',3,0,TRUE);
INSERT INTO staging.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES (19,'ACL_UPDATE_USER_ROLE','ACL_UPDATE_USER_ROLE','ACL_UPDATE_USER_ROLE','PUT',CURRENT_DATE,'MASTER DATA',3,0,TRUE);
INSERT INTO staging.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES (20,'USR_CREATE_ACCOUNT','USR_CREATE_ACCOUNT','USR_CREATE_ACCOUNT','POST',CURRENT_DATE,'MASTER DATA',2,0,TRUE);
INSERT INTO staging.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES (21,'USR_GET_ACCOUNT_EMAIL_ADDRESS','USR_GET_ACCOUNT_EMAIL_ADDRESS','USR_GET_ACCOUNT_EMAIL_ADDRESS','GET',CURRENT_DATE,'MASTER DATA',2,0,TRUE);
INSERT INTO staging.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES (22,'USR_GET_ACCOUNT_BASIC_INFO','USR_GET_ACCOUNT_BASIC_INFO','USR_GET_ACCOUNT_BASIC_INFO','GET',CURRENT_DATE,'MASTER DATA',2,0,TRUE);
INSERT INTO staging.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES (23,'USR_GET_AUTHORIZED_TRUSTEDAPPS','USR_GET_AUTHORIZED_TRUSTEDAPPS','USR_GET_AUTHORIZED_TRUSTEDAPPS','GET',CURRENT_DATE,'MASTER DATA',2,0,TRUE);
INSERT INTO staging.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES (24,'USR_GET_ACCOUNT','USR_GET_ACCOUNT','USR_GET_ACCOUNT','GET',CURRENT_DATE,'MASTER DATA',2,0,TRUE);
INSERT INTO staging.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES (25,'USR_UPDATE_ACCOUNT','USR_UPDATE_ACCOUNT','USR_UPDATE_ACCOUNT','PUT',CURRENT_DATE,'MASTER DATA',2,0,TRUE);
INSERT INTO staging.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES (26,'USR_GET_ACCOUNT_STATUS','USR_GET_ACCOUNT_STATUS','USR_GET_ACCOUNT_STATUS','GET',CURRENT_DATE,'MASTER DATA',2,0,TRUE);
INSERT INTO staging.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES (27,'USR_GET_ACCOUNT_PREFERENCES','USR_GET_ACCOUNT_PREFERENCES','USR_GET_ACCOUNT_PREFERENCES','GET',CURRENT_DATE,'MASTER DATA',2,0,TRUE);
INSERT INTO staging.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES (28,'USR_UPDATE_ACCOUNT_PREFERENCES','USR_UPDATE_ACCOUNT_PREFERENCES','USR_UPDATE_ACCOUNT_PREFERENCES','PUT',CURRENT_DATE,'MASTER DATA',2,0,TRUE);
INSERT INTO staging.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES (29,'USR_PASSWORD_RESET','USR_PASSWORD_RESET','USR_PASSWORD_RESET','PUT',CURRENT_DATE,'MASTER DATA',2,0,TRUE);
INSERT INTO staging.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES (30,'USR_PASSWORD_UPDATE','USR_PASSWORD_UPDATE','USR_PASSWORD_UPDATE','PUT',CURRENT_DATE,'MASTER DATA',2,0,TRUE);
INSERT INTO staging.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES (31,'USR_USERNAME_CHANGE','USR_USERNAME_CHANGE','USR_USERNAME_CHANGE','PUT',CURRENT_DATE,'MASTER DATA',2,0,TRUE);
INSERT INTO staging.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES (32,'USR_GET_ORGANIZATION_USERS','USR_GET_ORGANIZATION_USERS','USR_GET_ORGANIZATION_USERS','GET',CURRENT_DATE,'MASTER DATA',2,0,TRUE);
INSERT INTO staging.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES (33,'USR_CHECK_API_AUTHORIZATION','USR_CHECK_API_AUTHORIZATION','USR_CHECK_API_AUTHORIZATION','POST',CURRENT_DATE,'MASTER DATA',2,0,TRUE);
INSERT INTO staging.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES (34,'USR_GET_BASIC_TRUSTEDAPP_INFO','USR_GET_BASIC_TRUSTEDAPP_INFO','USR_GET_BASIC_TRUSTEDAPP_INFO','GET',CURRENT_DATE,'MASTER DATA',2,0,TRUE);
INSERT INTO staging.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES (35,'USR_CREATE_SESSION','USR_CREATE_SESSION','USR_CREATE_SESSION','POST',CURRENT_DATE,'MASTER DATA',2,0,TRUE);
INSERT INTO staging.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES (36,'USR_END_SESSION','USR_END_SESSION','USR_END_SESSION','DELETE',CURRENT_DATE,'MASTER DATA',2,0,TRUE);
INSERT INTO staging.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES (37,'USR_UPDATE_VERIFICATION_STATUS','USR_UPDATE_VERIFICATION_STATUS','USR_UPDATE_VERIFICATION_STATUS','PUT',CURRENT_DATE,'MASTER DATA',2,0,TRUE);
INSERT INTO staging.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES (38,'USR_CREATE_VERIFICATION','USR_CREATE_VERIFICATION','USR_CREATE_VERIFICATION','POST',CURRENT_DATE,'MASTER DATA',2,0,TRUE);
INSERT INTO staging.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES (39,'DCS_CREATE_DEVELOPER_COMPANY','DCS_CREATE_DEVELOPER_COMPANY','DCS_CREATE_DEVELOPER_COMPANY','POST',CURRENT_DATE,'MASTER DATA',1,0,TRUE);
INSERT INTO staging.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES (40,'DCS_UPDATE_DEVELOPER_COMPANY','DCS_UPDATE_DEVELOPER_COMPANY','DCS_UPDATE_DEVELOPER_COMPANY','PUT',CURRENT_DATE,'MASTER DATA',1,0,TRUE);
INSERT INTO staging.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES (41,'DCS_ASSOCIATE_DEVELOPER_ACCOUNT','DCS_ASSOCIATE_DEVELOPER_ACCOUNT','DCS_ASSOCIATE_DEVELOPER_ACCOUNT','POST',CURRENT_DATE,'MASTER DATA',1,0,TRUE);
INSERT INTO staging.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES (42,'DCS_DISASSOCIATE_DEVELOPER_ACCOUNT','DCS_DISASSOCIATE_DEVELOPER_ACCOUNT','DCS_DISASSOCIATE_DEVELOPER_ACCOUNT','DELETE',CURRENT_DATE,'MASTER DATA',1,0,TRUE);
INSERT INTO staging.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES (43,'DCS_CREATE_SERVICE','DCS_CREATE_SERVICE','DCS_CREATE_SERVICE','POST',CURRENT_DATE,'MASTER DATA',1,0,TRUE);
INSERT INTO staging.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES (44,'DCS_DELETE_DEVELOPER_COMPANY','DCS_DELETE_DEVELOPER_COMPANY','DCS_DELETE_DEVELOPER_COMPANY','DELETE',CURRENT_DATE,'MASTER DATA',1,0,TRUE);
INSERT INTO staging.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES (45,'DCS_GET_DEVELOPER_COMPANY','DCS_GET_DEVELOPER_COMPANY','DCS_GET_DEVELOPER_COMPANY','GET',CURRENT_DATE,'MASTER DATA',1,0,TRUE);
INSERT INTO staging.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES (46,'DCS_GET_DEVELOPER_COMPANY_ACCOUNTS','DCS_GET_DEVELOPER_COMPANY_ACCOUNTS','DCS_GET_DEVELOPER_COMPANY_ACCOUNTS','GET',CURRENT_DATE,'MASTER DATA',1,0,TRUE);
INSERT INTO staging.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES (47,'DCS_GET_SERVICES','DCS_GET_SERVICES','DCS_GET_SERVICES','GET',CURRENT_DATE,'MASTER DATA',1,0,TRUE);
INSERT INTO staging.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES (48,'DCS_GET_ALL_DEVELOPER_COMPANY','DCS_GET_ALL_DEVELOPER_COMPANY','DCS_GET_ALL_DEVELOPER_COMPANY','GET',CURRENT_DATE,'MASTER DATA',1,0,TRUE);
INSERT INTO staging.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES (49,'DCS_CREATE_DEVELOPER_APPROVAL_DECISION','DCS_CREATE_DEVELOPER_APPROVAL_DECISION','DCS_CREATE_DEVELOPER_APPROVAL_DECISION','POST',CURRENT_DATE,'MASTER DATA',1,0,TRUE);
INSERT INTO staging.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES (50,'DCS_CREATE_SERVICE','DCS_CREATE_SERVICE','DCS_CREATE_SERVICE','POST',CURRENT_DATE,'MASTER DATA',1,0,TRUE);
INSERT INTO staging.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES (51,'DCS_UPDATE_SERVICE','DCS_UPDATE_SERVICE','DCS_UPDATE_SERVICE','PUT',CURRENT_DATE,'MASTER DATA',1,0,TRUE);
INSERT INTO staging.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES (52,'DCS_DELETE_SERVICE','DCS_DELETE_SERVICE','DCS_DELETE_SERVICE','DELETE',CURRENT_DATE,'MASTER DATA',1,0,TRUE);
INSERT INTO staging.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES (53,'DCS_CREATE_TRUSTEDAPP_FOR_SERVICE','DCS_CREATE_TRUSTEDAPP_FOR_SERVICE','DCS_CREATE_TRUSTEDAPP_FOR_SERVICE','POST',CURRENT_DATE,'MASTER DATA',1,0,TRUE);
INSERT INTO staging.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES (54,'DCS_CREATE_SERVICE_APPROVAL_SUBMISSION','DCS_CREATE_SERVICE_APPROVAL_SUBMISSION','DCS_CREATE_SERVICE_APPROVAL_SUBMISSION','POST',CURRENT_DATE,'MASTER DATA',1,0,TRUE);
INSERT INTO staging.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES (55,'DCS_CREATE_SERVICE_APPROVAL_DECISION','DCS_CREATE_SERVICE_APPROVAL_DECISION','DCS_CREATE_SERVICE_APPROVAL_DECISION','POST',CURRENT_DATE,'MASTER DATA',1,0,TRUE);
INSERT INTO staging.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES (56,'DCS_GET_TRUSTEDAPPS_FOR_SERVICE','DCS_GET_TRUSTEDAPPS_FOR_SERVICE','DCS_GET_TRUSTEDAPPS_FOR_SERVICE','GET',CURRENT_DATE,'MASTER DATA',1,0,TRUE);
INSERT INTO staging.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES (57,'DCS_UPDATE_TRUSTEDAPP','DCS_UPDATE_TRUSTEDAPP','DCS_UPDATE_TRUSTEDAPP','PUT',CURRENT_DATE,'MASTER DATA',1,0,TRUE);
INSERT INTO staging.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES (58,'DCS_DELETE_TRUSTEDAPP','DCS_DELETE_TRUSTEDAPP','DCS_DELETE_TRUSTEDAPP','DELETE',CURRENT_DATE,'MASTER DATA',1,0,TRUE);
INSERT INTO staging.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES (59,'DCS_REGENERATE_TRUSTEDAPP_SECRETE','DCS_REGENERATE_TRUSTEDAPP_SECRETE','DCS_REGENERATE_TRUSTEDAPP_SECRETE','PUT',CURRENT_DATE,'MASTER DATA',1,0,TRUE);
INSERT INTO staging.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES (60,'DCS_CREATE_APPROVAL_SUBMISSION_FOR_TRUSTEDAPP','DCS_CREATE_APPROVAL_SUBMISSION_FOR_TRUSTEDAPP','DCS_CREATE_APPROVAL_SUBMISSION_FOR_TRUSTEDAPP','POST',CURRENT_DATE,'MASTER DATA',1,0,TRUE);
INSERT INTO staging.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES (61,'DCS_CREATE_APPROVAL_DECISION_FOR_TRUSTEDAPP','DCS_CREATE_APPROVAL_DECISION_FOR_TRUSTEDAPP','DCS_CREATE_APPROVAL_DECISION_FOR_TRUSTEDAPP','POST',CURRENT_DATE,'MASTER DATA',1,0,TRUE);
INSERT INTO staging.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES (62,'DCS_GET_TRUSTEDAPP','DCS_GET_TRUSTEDAPP','DCS_GET_TRUSTEDAPP','GET',CURRENT_DATE,'MASTER DATA',1,0,TRUE);
INSERT INTO staging.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES (63,'DCS_REGISTER_REDIRECT_URI','DCS_REGISTER_REDIRECT_URI','DCS_REGISTER_REDIRECT_URI','POST',CURRENT_DATE,'MASTER DATA',1,0,TRUE);
INSERT INTO staging.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES (64,'DCS_GET_REDIRECT_URIS','DCS_GET_REDIRECT_URIS','DCS_GET_REDIRECT_URIS','GET',CURRENT_DATE,'MASTER DATA',1,0,TRUE);
INSERT INTO staging.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES (65,'AUTH_AUTHORIZE','AUTH_AUTHORIZE','AUTH_AUTHORIZE','GET',CURRENT_DATE,'MASTER DATA',4,0,TRUE);
INSERT INTO staging.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES (66,'AUTH_GET_CONSENT_MESSAGES','AUTH_GET_CONSENT_MESSAGES','AUTH_GET_CONSENT_MESSAGES','GET',CURRENT_DATE,'MASTER DATA',4,0,TRUE);
INSERT INTO staging.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES (67,'AUTH_GET_DETAILED_CONSENT_MESSAGES','AUTH_GET_DETAILED_CONSENT_MESSAGES','AUTH_GET_DETAILED_CONSENT_MESSAGES','GET',CURRENT_DATE,'MASTER DATA',4,0,TRUE);
INSERT INTO staging.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES (68,'AUTH_AUTHORIZE_TOKEN','AUTH_AUTHORIZE_TOKEN','AUTH_AUTHORIZE_TOKEN','POST',CURRENT_DATE,'MASTER DATA',4,0,TRUE);
INSERT INTO staging.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES (69,'AUTH_REVOKE_TOKEN','AUTH_REVOKE_TOKEN','AUTH_REVOKE_TOKEN','POST',CURRENT_DATE,'MASTER DATA',4,0,TRUE);


CREATE SEQUENCE "staging".seq_developer_company START 1;

CREATE TABLE staging.hmis_developer_company
(
  id bigint NOT NULL,
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
      REFERENCES staging.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);

CREATE SEQUENCE "staging".seq_developer_company_account START 1;

CREATE TABLE staging.hmis_developer_company_account
(
  id bigint NOT NULL,
  developer_company_id bigint NOT NULL,
  role character varying(32),
  created_at date NOT NULL,
  modified_at date,
  created_by character varying(256) NOT NULL,
  modified_by character varying(256),
  deleted date,
  user_id uuid,
  CONSTRAINT "PK_DEVELOPER_COMPANY_ACCOUNT" PRIMARY KEY (id),
  CONSTRAINT "FK_DCA_USERID" FOREIGN KEY (user_id)
      REFERENCES staging.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);

CREATE SEQUENCE "staging".seq_developer_company_status START 1;

CREATE TABLE staging.hmis_developer_company_status
(
  id bigint NOT NULL,
  developer_company_id bigint NOT NULL,
  status character varying(20),
  comments character varying(512),
  created_at date NOT NULL,
  modified_at date,
  created_by character varying(256) NOT NULL,
  modified_by character varying(256),
  deleted date,
  CONSTRAINT "PK_DEVELOPER_COMPANY_STATUS" PRIMARY KEY (id),
  CONSTRAINT "FK_DCS_DEVELOPER_COMPANY_ID" FOREIGN KEY (developer_company_id)
      REFERENCES staging.hmis_developer_company_status (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);

CREATE SEQUENCE "staging".seq_password_reset START 1;

CREATE TABLE staging.hmis_password_reset
(
  id integer NOT NULL,
  new_password character varying(256),
  verification_id integer,
  status character varying(256),
  created_at date,
  modified_at date,
  created_by character varying(256),
  modified_by character varying(256),
  user_id uuid,
  CONSTRAINT "PK_PASSWORD_RESET" PRIMARY KEY (id),
  CONSTRAINT "FK_PR_USER_ID" FOREIGN KEY (user_id)
      REFERENCES staging.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "FK_PR_VERIFICATION_ID" FOREIGN KEY (verification_id)
      REFERENCES staging.hmis_verification (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);

CREATE TABLE staging.hmis_permission_set
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

CREATE TABLE staging.hmis_permission_set_acl
(
  id uuid NOT NULL,
  permission_set_id uuid,
  api_method_id bigint,
  created_at date,
  created_by character varying(256),
  modified_at date,
  modified_by character varying(256),
  CONSTRAINT "PK_PERMISSION_SET_ACL" PRIMARY KEY (id),
  CONSTRAINT "FK_PSA_API_METHOD_ID" FOREIGN KEY (api_method_id)
      REFERENCES staging.hmis_api_method (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "FK_PSA_PERMISSION_SET_ID" FOREIGN KEY (permission_set_id)
      REFERENCES staging.hmis_permission_set (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);


CREATE TABLE staging.hmis_profile
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

CREATE TABLE staging.hmis_profile_acl
(
  profile_id uuid,
  api_method_id bigint,
  id uuid NOT NULL,
  created_at date,
  created_by character varying(256),
  modified_at date,
  modified_by character varying(256),
  CONSTRAINT "PK_PROFILE_ACL" PRIMARY KEY (id),
  CONSTRAINT "FK_PACL_API_METHOD_ID" FOREIGN KEY (api_method_id)
      REFERENCES staging.hmis_api_method (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "FK_PACL_PROFILE_ID" FOREIGN KEY (profile_id)
      REFERENCES staging.hmis_profile (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);

CREATE SEQUENCE "staging".seq_redirect_uri START 1;

CREATE TABLE staging.hmis_redirect_uri
(
  id bigint NOT NULL,
  uri character varying(1048) NOT NULL,
  trustedapp_id bigint NOT NULL,
  created_at date NOT NULL,
  modified_at date,
  created_by character varying(256) NOT NULL,
  modified_by character varying(256),
  deleted date,
  CONSTRAINT "PK_REDIRECT_URI" PRIMARY KEY (id),
  CONSTRAINT "FK_RU_TRUSTEDAPP_ID" FOREIGN KEY (trustedapp_id)
      REFERENCES staging.hmis_trusted_app (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);

CREATE SEQUENCE "staging".seq_refresh_token START 1;

CREATE TABLE staging.hmis_refresh_token
(
  id bigint NOT NULL,
  token character varying(128),
  auth_code character varying(128),
  trustedapp_id bigint NOT NULL,
  created_at date NOT NULL,
  modified_at date,
  created_by character varying(256) NOT NULL,
  modified_by character varying(256),
  deleted date,
  user_id uuid,
  CONSTRAINT "PK_REFRESH_TOKEN" PRIMARY KEY (id),
  CONSTRAINT "FK_RT_TRUSTEDAPP_ID" FOREIGN KEY (trustedapp_id)
      REFERENCES staging.hmis_trusted_app (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "FK_RT_USERID" FOREIGN KEY (user_id)
      REFERENCES staging.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);

CREATE SEQUENCE "staging".seq_request_token START 1;

CREATE TABLE staging.hmis_request_token
(
  id bigint NOT NULL,
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

CREATE TABLE staging.hmis_role
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
      REFERENCES staging.hmis_role (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);


CREATE SEQUENCE "staging".seq_service_api_method START 1;

CREATE TABLE staging.hmis_service_api_method
(
  id bigint NOT NULL,
  service_id bigint NOT NULL,
  api_method_id bigint NOT NULL,
  created_at date NOT NULL,
  modified_at date,
  created_by character varying(256) NOT NULL,
  modified_by character varying(256),
  deleted date,
  CONSTRAINT "PK_SERVICE_API_METHOD" PRIMARY KEY (id),
  CONSTRAINT "FK_SAM_API_METHOD_ID" FOREIGN KEY (api_method_id)
      REFERENCES staging.hmis_api_method (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "FK_SAM_SERVICE_ID" FOREIGN KEY (service_id)
      REFERENCES staging.hmis_service (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);

CREATE SEQUENCE "staging".seq_service_status START 1;

CREATE TABLE staging.hmis_service_status
(
  id bigint NOT NULL,
  service_id bigint NOT NULL,
  status character varying(20),
  comments character varying(512),
  created_at date NOT NULL,
  modified_at date,
  created_by character varying(256) NOT NULL,
  modified_by character varying(256),
  deleted date,
  CONSTRAINT "PK_SERVICE_STATUS" PRIMARY KEY (id),
  CONSTRAINT "FK_SS_SERVICE_ID" FOREIGN KEY (service_id)
      REFERENCES staging.hmis_service (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);

CREATE SEQUENCE "staging".seq_session START 1;

CREATE TABLE staging.hmis_session
(
  id integer NOT NULL,
  session_token character varying(256),
  expires_at timestamp(0) without time zone,
  trustedapp_id integer,
  auth_code character varying(256),
  auth_code_expires_at timestamp without time zone,
  redirect_uri character varying(256),
  refresh_token_id integer,
  created_at date,
  modified_at date,
  created_by character varying(256),
  modified_by character varying(256),
  user_id uuid,
  CONSTRAINT "PK_SESSION" PRIMARY KEY (id),
  CONSTRAINT "FK_SESS_REFRESH_TOKEN_ID" FOREIGN KEY (refresh_token_id)
      REFERENCES staging.hmis_refresh_token (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "FK_SESS_TRUSTEDAPP_ID" FOREIGN KEY (trustedapp_id)
      REFERENCES staging.hmis_trusted_app (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "FK_SESS_USERID" FOREIGN KEY (user_id)
      REFERENCES staging.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);

CREATE TABLE staging.hmis_sharing_rule
(
  id uuid NOT NULL,
  from_organization_id uuid,
  enrollment_id uuid,
  role_id uuid,
  to_organization_id uuid,
  project_id uuid,
  created_at date,
  created_by character varying(256),
  modified_at date,
  modified_by character varying(256),
  CONSTRAINT "PK_SHARING_RULE" PRIMARY KEY (id),
  CONSTRAINT "FK_SR_ENROLLMENT_ID" FOREIGN KEY (enrollment_id)
      REFERENCES staging.enrollment (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "FK_SR_FROM_ORGANIZATION_ID" FOREIGN KEY (from_organization_id)
      REFERENCES staging.organization (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "FK_SR_PROJECT_ID" FOREIGN KEY (project_id)
      REFERENCES staging.project (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "FK_SR_ROLE_ID" FOREIGN KEY (role_id)
      REFERENCES staging.hmis_role (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "FK_SR_TO_ORGANIZATION_ID" FOREIGN KEY (to_organization_id)
      REFERENCES staging.organization (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);

CREATE SEQUENCE "staging".seq_trusted_app_status START 1;

CREATE TABLE staging.hmis_trusted_app_status
(
  id bigint NOT NULL,
  trustedapp_id bigint NOT NULL,
  status character varying(20),
  comments character varying(512),
  created_at date NOT NULL,
  modified_at date,
  created_by character varying(256) NOT NULL,
  modified_by character varying(256),
  deleted date,
  CONSTRAINT "PK_TRUSTED_APP_STATUS" PRIMARY KEY (id),
  CONSTRAINT "FK_TAPPS_TRUSTED_APP_ID" FOREIGN KEY (trustedapp_id)
      REFERENCES staging.hmis_trusted_app (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);

CREATE TABLE staging.hmis_user_permission_set_acl
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
      REFERENCES staging.hmis_permission_set (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "FK_UPSA_PROFILE_ID" FOREIGN KEY (profile_id)
      REFERENCES staging.hmis_profile (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "FK_UPSA_ROLE_ID" FOREIGN KEY (role_id)
      REFERENCES staging.hmis_role (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "FK_UPSA_USER_ID" FOREIGN KEY (user_id)
      REFERENCES staging.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);

CREATE TABLE staging.hmis_user_project
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
      REFERENCES staging.project (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "FK_UP_USER_ID" FOREIGN KEY (user_id)
      REFERENCES staging.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);

CREATE TABLE staging.hmis_user_role_map
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
      REFERENCES staging.hmis_role (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "FK_UR_USER_ID" FOREIGN KEY (user_id)
      REFERENCES staging.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);



ALTER TABLE staging.hmis_user ADD COLUMN created_by character varying(256);
ALTER TABLE staging.hmis_user ADD COLUMN modified_by character varying(256);
ALTER TABLE staging.hmis_user ADD COLUMN organization_id uuid;
ALTER TABLE staging.hmis_user ADD COLUMN password character varying(256);
ALTER TABLE staging.hmis_user ADD COLUMN pofile_id uuid;
ALTER TABLE staging.hmis_user ADD COLUMN status character varying(266);
ALTER TABLE staging.hmis_user ADD COLUMN username character varying(256);
ALTER TABLE staging.hmis_user ADD COLUMN verification_id bigint;


ALTER TABLE  staging.hmis_user ADD CONSTRAINT  "FK_USER_ORGANIZATION_ID" FOREIGN KEY (organization_id) REFERENCES staging.organization (id) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE  staging.hmis_user ADD  CONSTRAINT "FK_USER_PROFILE_ID" FOREIGN KEY (pofile_id) REFERENCES staging.hmis_profile (id) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE  staging.hmis_user ADD  CONSTRAINT "FK_USER_VERIFICATION_ID" FOREIGN KEY (verification_id) REFERENCES staging.hmis_verification (id) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION;


