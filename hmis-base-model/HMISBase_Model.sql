DROP SCHEMA IF EXISTS "base" cascade;
CREATE SCHEMA "base";

DROP TABLE IF EXISTS "base".organization; 
DROP TABLE IF EXISTS "base".hmis_user;
DROP TABLE IF EXISTS  base.hmis_account_consent;
DROP TABLE IF EXISTS  base.hmis_account_data_change;
DROP TABLE IF EXISTS  base.hmis_account_lockout;
DROP TABLE IF EXISTS  base.hmis_account_preference;
DROP TABLE IF EXISTS  base.hmis_api_group;
DROP TABLE IF EXISTS  base.hmis_api_method;
DROP TABLE IF EXISTS  base.hmis_consent_message;
DROP TABLE IF EXISTS  base.hmis_developer_company;
DROP TABLE IF EXISTS  base.hmis_developer_company_account;
DROP TABLE IF EXISTS  base.hmis_developer_company_status;
DROP TABLE IF EXISTS  base.hmis_notification_header;
DROP TABLE IF EXISTS  base.hmis_password_reset;
DROP TABLE IF EXISTS  base.hmis_permission_set;
DROP TABLE IF EXISTS  base.hmis_permission_set_acl;
DROP TABLE IF EXISTS  base.hmis_profile;
DROP TABLE IF EXISTS  base.hmis_profile_acl;
DROP TABLE IF EXISTS  base.hmis_redirect_uri;
DROP TABLE IF EXISTS  base.hmis_refresh_token;
DROP TABLE IF EXISTS  base.hmis_request_token;
DROP TABLE IF EXISTS  base.hmis_role;
DROP TABLE IF EXISTS  base.hmis_service;
DROP TABLE IF EXISTS  base.hmis_service_api_method;
DROP TABLE IF EXISTS  base.hmis_service_status;
DROP TABLE IF EXISTS  base.hmis_session;
DROP TABLE IF EXISTS  base.hmis_sharing_rule;
DROP TABLE IF EXISTS  base.hmis_trusted_app;
DROP TABLE IF EXISTS  base.hmis_trusted_app_status;
DROP TABLE IF EXISTS  base.hmis_user_permission_set_acl;
DROP TABLE IF EXISTS  base.hmis_user_role_map;
DROP TABLE IF EXISTS  base.hmis_verification;
DROP TABLE IF EXISTS  base.client;
DROP TABLE IF EXISTS  base.bulk_upload;
DROP TABLE IF EXISTS  base.bulk_upload_activity;

DROP TYPE IF EXISTS "base".gender;

DROP TYPE IF EXISTS "base".name_data_quality;
DROP TYPE IF EXISTS "base".dob_data_quality;
DROP TYPE IF EXISTS "base".ssn_data_quality;
DROP TYPE IF EXISTS "base".gender;
DROP TYPE IF EXISTS "base".ethnicity;
DROP TYPE IF EXISTS "base".veteran_status;
DROP TYPE IF EXISTS "base".race;

CREATE TYPE "base".name_data_quality AS ENUM ('1', '2', '8','9','99');
CREATE TYPE "base".dob_data_quality AS ENUM ('1', '2', '8','9','99');
CREATE TYPE "base".ssn_data_quality AS ENUM ('1', '2', '8','9','99');
CREATE TYPE "base".veteran_status AS ENUM ('0', '1', '8','9','99');
CREATE TYPE "base".race AS ENUM ('1', '2','3','4','5','8','9','99');
CREATE TYPE "base".ethnicity AS ENUM ('0', '1', '8','9','99');
CREATE TYPE "base".gender AS ENUM ('1', '2','3','4','8','9','99');

-- DROP TABLE "base"."client";
CREATE TABLE base.hmis_user
(
  id uuid NOT NULL,
  first_name character(50),
  middle_name character(50),
  last_name character(50),
  name_suffix character(50),
  ssn character(9),
  dob timestamp,
  gender base.gender,
  is_user_in_hive boolean DEFAULT false,
  is_user_hive_password_updated boolean DEFAULT false,
  hive_password character(100),
  hive_username character(100),
  date_created timestamp,
  date_updated timestamp,
  CONSTRAINT hmis_user_pk PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);

create table "base".hmis_organization
(
  organizationcommonname text,
  id uuid not null,
  organizationname text,
  "project_group_code" character varying(8),
   "date_created" timestamp,"date_created_from_source" timestamp,"date_updated_from_source" timestamp,
  "date_updated" timestamp,
  "user_id" uuid,
  
  parent_id uuid,
version integer,
deleted boolean DEFAULT false,
sync boolean DEFAULT false,
  constraint "organization_pkey" primary key (id),
      CONSTRAINT hmis_user_fkey FOREIGN KEY (user_id)
      REFERENCES base.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
with (
  oids=false
);

CREATE TABLE base.hmis_consent_message
(
  id uuid NOT NULL,
  external_id character varying(256) NOT NULL,
  message character varying(512) NOT NULL,
  created_at date NOT NULL,
  modified_at timestamp,
  created_by character varying(256) NOT NULL,
  modified_by character varying(256),
  deleted timestamp,
  CONSTRAINT "PK_CONSENT_MESSAGE" PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);

CREATE TABLE base.hmis_verification
(
  id uuid NOT NULL,
  verification_token character varying(256),
  verification_type character varying(256),
  status character varying(256),
  created_at date NOT NULL,
  modified_at timestamp,
  created_by character varying(256) NOT NULL,
  modified_by character varying(256),
  CONSTRAINT "PK_VERIFICATION" PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);

CREATE TABLE base.hmis_service
(
  id uuid NOT NULL,
  external_id character varying(128),
  friendly_name character varying(256),
  description character varying(512),
  license_type character varying(20) NOT NULL,
  developer_company_id uuid NOT NULL,
  external_product_id character varying(128),
  created_at date NOT NULL,
  modified_at timestamp,
  
  created_by character varying(256) NOT NULL,
  modified_by character varying(256),
  deleted timestamp,
  status character varying(20),
  CONSTRAINT "PK_SERVICE" PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);

CREATE TABLE base.hmis_trusted_app
(
  id uuid NOT NULL,
  friendly_name character varying(256),
  external_id character varying(256) NOT NULL,
  description character varying(1024),
  status character varying(256) NOT NULL,
  created_at date NOT NULL,
  modified_at timestamp,
  created_by character varying(256) NOT NULL,
  modified_by character varying(256),
  deleted timestamp,
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
  last_released_at timestamp,
  container_access_token_allowed boolean,
  is_internal boolean,
  api_method_check_required boolean,
  auth_code_grant_supported boolean,
  implicit_grant_supported boolean,
  refresh_token_supported boolean,
  CONSTRAINT "PK_TRUSTED_APP" PRIMARY KEY (id),
  CONSTRAINT "FK_TAPP_SERVICE_ID" FOREIGN KEY (service_id)
      REFERENCES base.hmis_service (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);


CREATE TABLE base.hmis_account_consent
(
  id uuid NOT NULL,
  trustedapp_id uuid,
  consented boolean,
  consented_at timestamp,
  created_at timestamp,
  created_by character varying(256),
  modified_at timestamp,
  modified_by character varying(256),
  consent_token character varying(256),
  user_id uuid,
  CONSTRAINT "PK_ACCOUNT_CONSENT" PRIMARY KEY (id),
  CONSTRAINT "FK_AC_TRUSTEDAPP_ID" FOREIGN KEY (trustedapp_id)
      REFERENCES base.hmis_trusted_app (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "FK_AC_USERID" FOREIGN KEY (user_id)
      REFERENCES base.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);


CREATE TABLE base.hmis_account_data_change
(
  id uuid NOT NULL,
  old_user_name character varying(256),
  new_user_name character varying(256),
  verification_id uuid,
  created_at timestamp,
  modified_at timestamp,
  created_by character varying(256),
  modified_by character varying(256),
  user_id uuid,
  CONSTRAINT "PK_ACCOUNT_DATA_CHANGE" PRIMARY KEY (id),
  CONSTRAINT "FK_ADCHANGE_USERID" FOREIGN KEY (user_id)
      REFERENCES base.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "FK_ADC_VERIFICATIONID" FOREIGN KEY (verification_id)
      REFERENCES base.hmis_verification (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);


CREATE TABLE base.hmis_account_lockout
(
  id uuid NOT NULL,
  last_attempt_status integer,
  last_attempt_at timestamp,
  failure_attempt_count integer,
  created_at date NOT NULL,
  modified_at timestamp,
  created_by character varying(256) NOT NULL,
  modified_by character varying(256),
  user_id uuid,
  CONSTRAINT "PK_ACCOUNT_LOOCKOUT" PRIMARY KEY (id),
  CONSTRAINT "FK_AL_USER_ID" FOREIGN KEY (user_id)
      REFERENCES base.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);

CREATE TABLE base.hmis_account_preference
(
  id uuid NOT NULL,
  iso_language_code character varying(120),
  iso_country_code character varying(120),
  newsletter_opt_in integer,
  created_at date NOT NULL,
  modified_at timestamp,
  created_by character varying(256) NOT NULL,
  modified_by character varying(256),
  user_id uuid,
  CONSTRAINT "PK_ACCOUNT_PREFERENCE" PRIMARY KEY (id),
  CONSTRAINT "FK_AP_USER_ID" FOREIGN KEY (user_id)
      REFERENCES base.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);

CREATE TABLE base.hmis_api_group
(
  id uuid NOT NULL,
  external_id character varying(128) NOT NULL,
  friendly_name character varying(256),
  description character varying(512),
  authorization_msg character varying(512),
  group_sequence bigint,
  created_at date NOT NULL,
  modified_at timestamp,
  created_by character varying(256) NOT NULL,
  modified_by character varying(256),
  deleted timestamp,
  consent_message_id uuid,
  detailed_consent_message_id uuid,
  CONSTRAINT "PK_API_GROUP" PRIMARY KEY (id),
  CONSTRAINT "FK_AG_CONSENT_MESSAGE_ID" FOREIGN KEY (consent_message_id)
      REFERENCES base.hmis_consent_message (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "FK_AG_DTL_CONSENT_MESSAGE_ID" FOREIGN KEY (detailed_consent_message_id)
      REFERENCES base.hmis_consent_message (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);


INSERT INTO base.hmis_api_group(id, external_id, friendly_name, description, authorization_msg, created_at,  created_by)
    VALUES ('084ab7d7de7e-1138-4f74-b50e-d9ebbc10', 'DEVELOPER_SERVICES','DEVELOPER SERVICES', 'DEVELOPER SERVICES', 'DEVELOPER SERVICES', current_timestamp,  'MASTER DATA'),
	       ('13e91f4220ae-96ef-4a61-95a1-e71607df', 'USER_SERVICES','USER SERVICES', 'USER SERVICES', 'USER SERVICES', current_timestamp,  'MASTER DATA'),
	       ('38c0c9b6e73c-6de8-4c69-b0d0-e7a454be', 'ACL_SERVICES','ACL SERVICES', 'ACL SERVICES', 'ACL SERVICES', current_timestamp,  'MASTER DATA'),
	       ('bf1fcd6abb4e-4c6f-4e54-b3d8-fbe73fb7', 'AUTH_SERVICES','AUTH SERVICES', 'AUTH SERVICES', 'AUTH SERVICES', current_timestamp,  'MASTER DATA'),
	       ('55269f08-273f-4f68-ae9b-f98467b4d091', 'CLIENT_API','CLIENT_API', 'CLIENT_API', 'CLIENT_API', current_timestamp,  'MASTER DATA');

CREATE TABLE base.hmis_api_method
(
  id uuid NOT NULL,
  external_id character varying(128),
  friendly_name character varying(256),
  description character varying(512),
  type character varying(256) NOT NULL,
  account_consent_msg character varying(512),
  account_consent_msg_order bigint,
  created_at date NOT NULL,
  modified_at timestamp,
  created_by character varying(256) NOT NULL,
  modified_by character varying(256),
  deleted timestamp,
  api_group_id uuid,
  deprecated bigint DEFAULT 0,
  consent_message_id uuid,
  detailed_consent_message_id uuid,
  is_public boolean,
  requires_access_token boolean,
  CONSTRAINT "PK_API_METHOD" PRIMARY KEY (id),
  CONSTRAINT "FK_AM_CONSENT_MESSAGE_ID" FOREIGN KEY (consent_message_id)
      REFERENCES base.hmis_consent_message (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "FK_AM_DTL_CONSENT_MESSAGE_ID" FOREIGN KEY (detailed_consent_message_id)
      REFERENCES base.hmis_consent_message (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "FK_AM_GROUP_ID" FOREIGN KEY (api_group_id)
      REFERENCES base.hmis_api_group (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);


INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('4561a939-edea-4b8a-974c-fab36201613d','ACL_CREATE_ROLE','ACL_CREATE_ROLE','ACL_CREATE_ROLE','POST',CURRENT_timestamp,'MASTER DATA','38c0c9b6e73c-6de8-4c69-b0d0-e7a454be',0,TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('8c17c5e4-85ff-4abc-bcfa-77746cae15c1','ACL_UPDATE_ROLE','ACL_UPDATE_ROLE','ACL_UPDATE_ROLE','PUT',CURRENT_timestamp,'MASTER DATA','38c0c9b6e73c-6de8-4c69-b0d0-e7a454be',0,TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('c3e1e197-0e7a-41b0-ab68-1d9365f9f948','ACL_DELETE_ROLE','ACL_DELETE_ROLE','ACL_DELETE_ROLE','DELETE',CURRENT_timestamp,'MASTER DATA','38c0c9b6e73c-6de8-4c69-b0d0-e7a454be',0,TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('e0dee727-31d1-4a36-acc4-78ddd177ed88','ACL_GET_ALL_ROLES','ACL_GET_ALL_ROLES','ACL_GET_ALL_ROLES','GET',CURRENT_timestamp,'MASTER DATA','38c0c9b6e73c-6de8-4c69-b0d0-e7a454be',0,TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('76adcdd5-f6e2-4587-bfbc-40f52b2d0a5b','ACL_CREATE_SHARING_RULE','ACL_CREATE_SHARING_RULE','ACL_CREATE_SHARING_RULE','POST',CURRENT_timestamp,'MASTER DATA','38c0c9b6e73c-6de8-4c69-b0d0-e7a454be',0,TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('cfe095c8-5316-4c37-bcfb-65757eb30a64','ACL_UPDATE_SHARING_RULE','ACL_UPDATE_SHARING_RULE','ACL_UPDATE_SHARING_RULE','PUT',CURRENT_timestamp,'MASTER DATA','38c0c9b6e73c-6de8-4c69-b0d0-e7a454be',0,TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('5389777e-4bd7-440c-9cc0-ed3069df463d','ACL_DELETE_SHARING_RULE','ACL_DELETE_SHARING_RULE','ACL_DELETE_SHARING_RULE','DELETE',CURRENT_timestamp,'MASTER DATA','38c0c9b6e73c-6de8-4c69-b0d0-e7a454be',0,TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('55269f08-273f-4f68-ae9a-f98467b4d091','ACL_CREATE_PROFILE','ACL_CREATE_PROFILE','ACL_CREATE_PROFILE','POST',CURRENT_timestamp,'MASTER DATA','38c0c9b6e73c-6de8-4c69-b0d0-e7a454be',0,TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('604b8afb-782a-4576-9146-c6b8f1cce560','ACL_UPDATE_PROFILE','ACL_UPDATE_PROFILE','ACL_UPDATE_PROFILE','PUT',CURRENT_timestamp,'MASTER DATA','38c0c9b6e73c-6de8-4c69-b0d0-e7a454be',0,TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('6f77f4c7-8708-4eb1-b663-12f8a11dfc3e','ACL_DELETE_PROFILE','ACL_DELETE_PROFILE','ACL_DELETE_PROFILE','DELETE',CURRENT_timestamp,'MASTER DATA','38c0c9b6e73c-6de8-4c69-b0d0-e7a454be',0,TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('3500719b-c2dd-4c1d-8ab6-f9059a141c6a','ACL_GET_PROFILE','ACL_GET_PROFILE','ACL_GET_PROFILE','GET',CURRENT_timestamp,'MASTER DATA','38c0c9b6e73c-6de8-4c69-b0d0-e7a454be',0,TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('23a43f92-1f75-4b70-aac6-23dcbeb33ba5','ACL_GET_ALL_PROFILES','ACL_GET_ALL_PROFILES','ACL_GET_ALL_PROFILES','GET',CURRENT_timestamp,'MASTER DATA','38c0c9b6e73c-6de8-4c69-b0d0-e7a454be',0,TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('2192f57b-fa89-41b4-8680-e78f0b3c4c3e','ACL_CREATE_PRMISSION_SET','ACL_CREATE_PRMISSION_SET','ACL_CREATE_PRMISSION_SET','POST',CURRENT_timestamp,'MASTER DATA','38c0c9b6e73c-6de8-4c69-b0d0-e7a454be',0,TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('2be134e2-6723-414f-a2eb-7d325f607fc2','ACL_UPDATE_PRMISSION_SET','ACL_UPDATE_PRMISSION_SET','ACL_UPDATE_PRMISSION_SET','PUT',CURRENT_timestamp,'MASTER DATA','38c0c9b6e73c-6de8-4c69-b0d0-e7a454be',0,TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('680d4f6e-645d-469b-a8d1-9ce0ebaeb70f','ACL_DELETE_PRMISSION_SET','ACL_DELETE_PRMISSION_SET','ACL_DELETE_PRMISSION_SET','DELETE',CURRENT_timestamp,'MASTER DATA','38c0c9b6e73c-6de8-4c69-b0d0-e7a454be',0,TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('5cf162dc-9497-4e20-8109-32cf47c8241b','ACL_GET_PRMISSION_SET','ACL_GET_PRMISSION_SET','ACL_GET_PRMISSION_SET','GET',CURRENT_timestamp,'MASTER DATA','38c0c9b6e73c-6de8-4c69-b0d0-e7a454be',0,TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('659ebd34-999a-4611-ab9f-966ef8822a29','ACL_ASSIGN_PRMISSION_SET','ACL_ASSIGN_PRMISSION_SET','ACL_ASSIGN_PRMISSION_SET','PUT',CURRENT_timestamp,'MASTER DATA','38c0c9b6e73c-6de8-4c69-b0d0-e7a454be',0,TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('b04e67bf-9729-443a-aa27-6fa228c7be6b','ACL_CREATE_USER_ROLE','ACL_CREATE_USER_ROLE','ACL_CREATE_USER_ROLE','POST',CURRENT_timestamp,'MASTER DATA','38c0c9b6e73c-6de8-4c69-b0d0-e7a454be',0,TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('d61b2d9e-bfd4-4b02-9a6f-d6884f502539','ACL_UPDATE_USER_ROLE','ACL_UPDATE_USER_ROLE','ACL_UPDATE_USER_ROLE','PUT',CURRENT_timestamp,'MASTER DATA','38c0c9b6e73c-6de8-4c69-b0d0-e7a454be',0,TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('1264d1d4-0fe4-4f29-a3bc-62102f420a11','USR_CREATE_ACCOUNT','USR_CREATE_ACCOUNT','USR_CREATE_ACCOUNT','POST',CURRENT_timestamp,'MASTER DATA','13e91f4220ae-96ef-4a61-95a1-e71607df',0,TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('c1befc78-01b0-4de9-8ac9-eb34a9c78bb0','USR_GET_ACCOUNT_EMAIL_ADDRESS','USR_GET_ACCOUNT_EMAIL_ADDRESS','USR_GET_ACCOUNT_EMAIL_ADDRESS','GET',CURRENT_timestamp,'MASTER DATA','13e91f4220ae-96ef-4a61-95a1-e71607df',0,TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('0e17ff09-8ab1-4913-9dde-0552193fcbf6','USR_GET_ACCOUNT_BASIC_INFO','USR_GET_ACCOUNT_BASIC_INFO','USR_GET_ACCOUNT_BASIC_INFO','GET',CURRENT_timestamp,'MASTER DATA','13e91f4220ae-96ef-4a61-95a1-e71607df',0,TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('e0ca45cc-33e3-4e9d-b5f9-537d4b88c459','USR_GET_AUTHORIZED_TRUSTEDAPPS','USR_GET_AUTHORIZED_TRUSTEDAPPS','USR_GET_AUTHORIZED_TRUSTEDAPPS','GET',CURRENT_timestamp,'MASTER DATA','13e91f4220ae-96ef-4a61-95a1-e71607df',0,TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('e63574d1-1d4b-4e01-a3db-060915f3295d','USR_GET_ACCOUNT','USR_GET_ACCOUNT','USR_GET_ACCOUNT','GET',CURRENT_timestamp,'MASTER DATA','13e91f4220ae-96ef-4a61-95a1-e71607df',0,TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('e832df6f-c238-456b-b03e-c60b917f508a','USR_UPDATE_ACCOUNT','USR_UPDATE_ACCOUNT','USR_UPDATE_ACCOUNT','PUT',CURRENT_timestamp,'MASTER DATA','13e91f4220ae-96ef-4a61-95a1-e71607df',0,TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('29d8611c-bf90-427d-b18a-1fe2473c9ffd','USR_GET_ACCOUNT_STATUS','USR_GET_ACCOUNT_STATUS','USR_GET_ACCOUNT_STATUS','GET',CURRENT_timestamp,'MASTER DATA','13e91f4220ae-96ef-4a61-95a1-e71607df',0,TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('e63156ff-e93a-447e-9080-b8c164992b97','USR_GET_ACCOUNT_PREFERENCES','USR_GET_ACCOUNT_PREFERENCES','USR_GET_ACCOUNT_PREFERENCES','GET',CURRENT_timestamp,'MASTER DATA','13e91f4220ae-96ef-4a61-95a1-e71607df',0,TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('30bee259-fc5e-4667-854f-98c7fd81f3e2','USR_UPDATE_ACCOUNT_PREFERENCES','USR_UPDATE_ACCOUNT_PREFERENCES','USR_UPDATE_ACCOUNT_PREFERENCES','PUT',CURRENT_timestamp,'MASTER DATA','13e91f4220ae-96ef-4a61-95a1-e71607df',0,TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('72df4ae1-3659-49cb-a221-84cee475a58e','USR_PASSWORD_RESET','USR_PASSWORD_RESET','USR_PASSWORD_RESET','PUT',CURRENT_timestamp,'MASTER DATA','13e91f4220ae-96ef-4a61-95a1-e71607df',0,TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('b02a288d-85f2-4a5e-95d1-a43db8383e05','USR_PASSWORD_UPDATE','USR_PASSWORD_UPDATE','USR_PASSWORD_UPDATE','PUT',CURRENT_timestamp,'MASTER DATA','13e91f4220ae-96ef-4a61-95a1-e71607df',0,TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('75900937-5126-44b6-937f-6494b0722657','USR_USERNAME_CHANGE','USR_USERNAME_CHANGE','USR_USERNAME_CHANGE','PUT',CURRENT_timestamp,'MASTER DATA','13e91f4220ae-96ef-4a61-95a1-e71607df',0,TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('17ec1d67-d1a0-4aee-94bb-a686c0f25a41','USR_GET_ORGANIZATION_USERS','USR_GET_ORGANIZATION_USERS','USR_GET_ORGANIZATION_USERS','GET',CURRENT_timestamp,'MASTER DATA','13e91f4220ae-96ef-4a61-95a1-e71607df',0,TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('2a54536b-f208-41d7-a2e3-f7f1c0953c1a','USR_CHECK_API_AUTHORIZATION','USR_CHECK_API_AUTHORIZATION','USR_CHECK_API_AUTHORIZATION','POST',CURRENT_timestamp,'MASTER DATA','13e91f4220ae-96ef-4a61-95a1-e71607df',0,TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('18ac92c9-7cba-43df-aa00-f5c4a2c802c3','USR_GET_BASIC_TRUSTEDAPP_INFO','USR_GET_BASIC_TRUSTEDAPP_INFO','USR_GET_BASIC_TRUSTEDAPP_INFO','GET',CURRENT_timestamp,'MASTER DATA','13e91f4220ae-96ef-4a61-95a1-e71607df',0,TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('60935f25-fec5-4e4d-b0c3-452d21d1848f','USR_CREATE_SESSION','USR_CREATE_SESSION','USR_CREATE_SESSION','POST',CURRENT_timestamp,'MASTER DATA','13e91f4220ae-96ef-4a61-95a1-e71607df',0,TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('600df1a9-b9e4-4953-b90e-8d55d67233ac','USR_END_SESSION','USR_END_SESSION','USR_END_SESSION','DELETE',CURRENT_timestamp,'MASTER DATA','13e91f4220ae-96ef-4a61-95a1-e71607df',0,TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('611df1a9-b9e4-4953-b90e-8d55d67233ac','USR_GET_APIMETHODS','USR_GET_APIMETHODS','USR_GET_APIMETHODS','GET',CURRENT_timestamp,'MASTER DATA','13e91f4220ae-96ef-4a61-95a1-e71607df',0,TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('3336586d-5034-41fc-a32c-9aab26873dd3','USR_UPDATE_VERIFICATION_STATUS','USR_UPDATE_VERIFICATION_STATUS','USR_UPDATE_VERIFICATION_STATUS','PUT',CURRENT_timestamp,'MASTER DATA','13e91f4220ae-96ef-4a61-95a1-e71607df',0,TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('039c55be-bf44-4e22-8a79-5ba861756c45','USR_CREATE_VERIFICATION','USR_CREATE_VERIFICATION','USR_CREATE_VERIFICATION','POST',CURRENT_timestamp,'MASTER DATA','13e91f4220ae-96ef-4a61-95a1-e71607df',0,TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('b0b768dd-ebb8-4ab4-8124-8d84bec4cdd6','DCS_CREATE_DEVELOPER_COMPANY','DCS_CREATE_DEVELOPER_COMPANY','DCS_CREATE_DEVELOPER_COMPANY','POST',CURRENT_timestamp,'MASTER DATA','084ab7d7de7e-1138-4f74-b50e-d9ebbc10',0,TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('6bcdc400-1ddc-43c7-b8ab-192811119710','DCS_UPDATE_DEVELOPER_COMPANY','DCS_UPDATE_DEVELOPER_COMPANY','DCS_UPDATE_DEVELOPER_COMPANY','PUT',CURRENT_timestamp,'MASTER DATA','084ab7d7de7e-1138-4f74-b50e-d9ebbc10',0,TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('fdb04b89-8962-44ec-ae66-3b5508109925','DCS_ASSOCIATE_DEVELOPER_ACCOUNT','DCS_ASSOCIATE_DEVELOPER_ACCOUNT','DCS_ASSOCIATE_DEVELOPER_ACCOUNT','POST',CURRENT_timestamp,'MASTER DATA','084ab7d7de7e-1138-4f74-b50e-d9ebbc10',0,TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('ed2f4926-bf7c-4103-a0cc-623c7f409bf2','DCS_DISASSOCIATE_DEVELOPER_ACCOUNT','DCS_DISASSOCIATE_DEVELOPER_ACCOUNT','DCS_DISASSOCIATE_DEVELOPER_ACCOUNT','DELETE',CURRENT_timestamp,'MASTER DATA','084ab7d7de7e-1138-4f74-b50e-d9ebbc10',0,TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('16a154ba-e95f-4514-89e6-c11e6f4a43f7','DCS_CREATE_SERVICE','DCS_CREATE_SERVICE','DCS_CREATE_SERVICE','POST',CURRENT_timestamp,'MASTER DATA','084ab7d7de7e-1138-4f74-b50e-d9ebbc10',0,TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('0c41fe4d-c0bc-4514-bd64-13fb8b79ce65','DCS_DELETE_DEVELOPER_COMPANY','DCS_DELETE_DEVELOPER_COMPANY','DCS_DELETE_DEVELOPER_COMPANY','DELETE',CURRENT_timestamp,'MASTER DATA','084ab7d7de7e-1138-4f74-b50e-d9ebbc10',0,TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('cd9407c6-b926-4311-8f74-3c22f8523aef','DCS_GET_OWN_DEVELOPER_COMPANIES','DCS_GET_OWN_DEVELOPER_COMPANIES','DCS_GET_OWN_DEVELOPER_COMPANIES','GET',CURRENT_timestamp,'MASTER DATA','084ab7d7de7e-1138-4f74-b50e-d9ebbc10',0,TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('cd8407c6-b926-4311-8f74-3c22f8523aef','DCS_GET_DEVELOPER_COMPANY','DCS_GET_DEVELOPER_COMPANY','DCS_GET_DEVELOPER_COMPANY','GET',CURRENT_timestamp,'MASTER DATA','084ab7d7de7e-1138-4f74-b50e-d9ebbc10',0,TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('9aacbe33-b5b3-4e82-bfa8-7de2c94fee8c','DCS_GET_DEVELOPER_COMPANY_ACCOUNTS','DCS_GET_DEVELOPER_COMPANY_ACCOUNTS','DCS_GET_DEVELOPER_COMPANY_ACCOUNTS','GET',CURRENT_timestamp,'MASTER DATA','084ab7d7de7e-1138-4f74-b50e-d9ebbc10',0,TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('8dec892c-3dec-4b35-92c6-e133e3d502cd','DCS_GET_SERVICES','DCS_GET_SERVICES','DCS_GET_SERVICES','GET',CURRENT_timestamp,'MASTER DATA','084ab7d7de7e-1138-4f74-b50e-d9ebbc10',0,TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('7549ee25-e8ec-4461-ac9d-97134be54563','DCS_GET_ALL_DEVELOPER_COMPANY','DCS_GET_ALL_DEVELOPER_COMPANY','DCS_GET_ALL_DEVELOPER_COMPANY','GET',CURRENT_timestamp,'MASTER DATA','084ab7d7de7e-1138-4f74-b50e-d9ebbc10',0,TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('156d7669-0240-4fbd-8600-c1ebb75d366b','DCS_CREATE_DEVELOPER_APPROVAL_DECISION','DCS_CREATE_DEVELOPER_APPROVAL_DECISION','DCS_CREATE_DEVELOPER_APPROVAL_DECISION','POST',CURRENT_timestamp,'MASTER DATA','084ab7d7de7e-1138-4f74-b50e-d9ebbc10',0,TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('75381266-2797-4a38-bf28-404079017428','DCS_UPDATE_SERVICE','DCS_UPDATE_SERVICE','DCS_UPDATE_SERVICE','PUT',CURRENT_timestamp,'MASTER DATA','084ab7d7de7e-1138-4f74-b50e-d9ebbc10',0,TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('5256353f-b254-44fe-af66-d57d63312f62','DCS_DELETE_SERVICE','DCS_DELETE_SERVICE','DCS_DELETE_SERVICE','DELETE',CURRENT_timestamp,'MASTER DATA','084ab7d7de7e-1138-4f74-b50e-d9ebbc10',0,TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('795778b9-ba24-4434-b140-192db2fa745b','DCS_CREATE_TRUSTEDAPP_FOR_SERVICE','DCS_CREATE_TRUSTEDAPP_FOR_SERVICE','DCS_CREATE_TRUSTEDAPP_FOR_SERVICE','POST',CURRENT_timestamp,'MASTER DATA','084ab7d7de7e-1138-4f74-b50e-d9ebbc10',0,TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('e8ce14b5-b732-4235-bb4d-cfca8e333c2a','DCS_CREATE_SERVICE_APPROVAL_SUBMISSION','DCS_CREATE_SERVICE_APPROVAL_SUBMISSION','DCS_CREATE_SERVICE_APPROVAL_SUBMISSION','POST',CURRENT_timestamp,'MASTER DATA','084ab7d7de7e-1138-4f74-b50e-d9ebbc10',0,TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('3b6c1791-3d69-4abc-8716-0cecf831357d','DCS_CREATE_SERVICE_APPROVAL_DECISION','DCS_CREATE_SERVICE_APPROVAL_DECISION','DCS_CREATE_SERVICE_APPROVAL_DECISION','POST',CURRENT_timestamp,'MASTER DATA','084ab7d7de7e-1138-4f74-b50e-d9ebbc10',0,TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('66729788-94cb-493a-9b3d-16cac138f609','DCS_GET_TRUSTEDAPPS_FOR_SERVICE','DCS_GET_TRUSTEDAPPS_FOR_SERVICE','DCS_GET_TRUSTEDAPPS_FOR_SERVICE','GET',CURRENT_timestamp,'MASTER DATA','084ab7d7de7e-1138-4f74-b50e-d9ebbc10',0,TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('82f91a18-27c5-4a6e-bf24-7d93053f499e','DCS_UPDATE_TRUSTEDAPP','DCS_UPDATE_TRUSTEDAPP','DCS_UPDATE_TRUSTEDAPP','PUT',CURRENT_timestamp,'MASTER DATA','084ab7d7de7e-1138-4f74-b50e-d9ebbc10',0,TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('761a583b-5c1b-4be6-a364-9adafcaaf3b0','DCS_DELETE_TRUSTEDAPP','DCS_DELETE_TRUSTEDAPP','DCS_DELETE_TRUSTEDAPP','DELETE',CURRENT_timestamp,'MASTER DATA','084ab7d7de7e-1138-4f74-b50e-d9ebbc10',0,TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('c4400a71-cf49-48aa-bc09-a1a0a7ad2fc1','DCS_REGENERATE_TRUSTEDAPP_SECRETE','DCS_REGENERATE_TRUSTEDAPP_SECRETE','DCS_REGENERATE_TRUSTEDAPP_SECRETE','PUT',CURRENT_timestamp,'MASTER DATA','084ab7d7de7e-1138-4f74-b50e-d9ebbc10',0,TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('5a63dc2b-d28d-4b5c-bfdf-f8ce372338ad','DCS_CREATE_APPROVAL_SUBMISSION_FOR_TRUSTEDAPP','DCS_CREATE_APPROVAL_SUBMISSION_FOR_TRUSTEDAPP','DCS_CREATE_APPROVAL_SUBMISSION_FOR_TRUSTEDAPP','POST',CURRENT_timestamp,'MASTER DATA','084ab7d7de7e-1138-4f74-b50e-d9ebbc10',0,TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('aa424f3c-8743-430a-bb4f-51f2f7930570','DCS_CREATE_APPROVAL_DECISION_FOR_TRUSTEDAPP','DCS_CREATE_APPROVAL_DECISION_FOR_TRUSTEDAPP','DCS_CREATE_APPROVAL_DECISION_FOR_TRUSTEDAPP','POST',CURRENT_timestamp,'MASTER DATA','084ab7d7de7e-1138-4f74-b50e-d9ebbc10',0,TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('b75217f9-d6c3-4c9d-8566-1f2065817740','DCS_GET_TRUSTEDAPP','DCS_GET_TRUSTEDAPP','DCS_GET_TRUSTEDAPP','GET',CURRENT_timestamp,'MASTER DATA','084ab7d7de7e-1138-4f74-b50e-d9ebbc10',0,TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('50965196-a164-45fc-8ca2-52fd5de04710','DCS_REGISTER_REDIRECT_URI','DCS_REGISTER_REDIRECT_URI','DCS_REGISTER_REDIRECT_URI','POST',CURRENT_timestamp,'MASTER DATA','084ab7d7de7e-1138-4f74-b50e-d9ebbc10',0,TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('6ac3e289-b885-4e1c-901c-382c1e12d415','DCS_GET_REDIRECT_URIS','DCS_GET_REDIRECT_URIS','DCS_GET_REDIRECT_URIS','GET',CURRENT_timestamp,'MASTER DATA','084ab7d7de7e-1138-4f74-b50e-d9ebbc10',0,TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('84ccf81d-35f1-44d6-a8fd-8fd67cde958d','AUTH_AUTHORIZE','AUTH_AUTHORIZE','AUTH_AUTHORIZE','GET',CURRENT_timestamp,'MASTER DATA','bf1fcd6abb4e-4c6f-4e54-b3d8-fbe73fb7',0,TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('c7261bb4-4c5a-4c42-9837-6215fa63fdc3','AUTH_GET_CONSENT_MESSAGES','AUTH_GET_CONSENT_MESSAGES','AUTH_GET_CONSENT_MESSAGES','GET',CURRENT_timestamp,'MASTER DATA','bf1fcd6abb4e-4c6f-4e54-b3d8-fbe73fb7',0,TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('9cec44bb-ecc5-4020-a81b-1d1f43bc397a','AUTH_GET_DETAILED_CONSENT_MESSAGES','AUTH_GET_DETAILED_CONSENT_MESSAGES','AUTH_GET_DETAILED_CONSENT_MESSAGES','GET',CURRENT_timestamp,'MASTER DATA','bf1fcd6abb4e-4c6f-4e54-b3d8-fbe73fb7',0,TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('6a29e5d5-2342-4cf2-b40a-45a37d522b83','AUTH_AUTHORIZE_TOKEN','AUTH_AUTHORIZE_TOKEN','AUTH_AUTHORIZE_TOKEN','POST',CURRENT_timestamp,'MASTER DATA','bf1fcd6abb4e-4c6f-4e54-b3d8-fbe73fb7',0,TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('31636bef-4d68-4eb0-9343-0a86c9be2f4c','AUTH_REVOKE_TOKEN','AUTH_REVOKE_TOKEN','AUTH_REVOKE_TOKEN','POST',CURRENT_timestamp,'MASTER DATA','bf1fcd6abb4e-4c6f-4e54-b3d8-fbe73fb7',0,TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('e004e7f9-c898-4842-bbb3-8d12d511b475', 'CLIENT_API_CREATE_CLIENT', 'CLIENT_API_CREATE_CLIENT', 'CLIENT_API_CREATE_CLIENT', 'POST',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('c95c271c-60b5-4aa9-abed-605e2223e1f4', 'CLIENT_API_UPDATE_CLIENT', 'CLIENT_API_UPDATE_CLIENT', 'CLIENT_API_UPDATE_CLIENT', 'PUT',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0,  TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('7af80b93-35ef-463c-87fc-a3239deb07dd', 'CLIENT_API_DELETE_CLIENT', 'CLIENT_API_DELETE_CLIENT', 'CLIENT_API_DELETE_CLIENT', 'DELETE',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('8f04c22e-4ae7-4a58-86af-76bd2cf309c5', 'CLIENT_API_GET_CLIENT_BY_ID', 'CLIENT_API_GET_CLIENT_BY_ID', 'CLIENT_API_GET_CLIENT_BY_ID', 'DELETE',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('63384328-39d3-4258-9b6c-68139d59e9aa', 'CLIENT_API_GET_ALL_CLIENTS', 'CLIENT_API_GET_ALL_CLIENTS', 'CLIENT_API_GET_ALL_CLIENTS', 'DELETE',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('57419432-9792-400c-9a2b-37c3c70057f5', 'CLIENT_API_CREATE_ENROLLMENT', 'CLIENT_API_CREATE_ENROLLMENT', 'CLIENT_API_CREATE_ENROLLMENT', 'DELETE',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('20b29446-3b0e-4a39-a7bc-c564395097ec', 'CLIENT_API_UPDATE_ENROLLMENT', 'CLIENT_API_UPDATE_ENROLLMENT', 'CLIENT_API_UPDATE_ENROLLMENT', 'DELETE',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('9f73b8e8-c36f-4338-b82f-8c13c85779a3', 'CLIENT_API_DELETE_ENROLLMENT', 'CLIENT_API_DELETE_ENROLLMENT', 'CLIENT_API_DELETE_ENROLLMENT', 'DELETE',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('4f5554ba-ec19-428a-a7f0-827fc74bb1e8', 'CLIENT_API_GET_ENROLLMENT_BY_ID', 'CLIENT_API_GET_ENROLLMENT_BY_ID', 'CLIENT_API_GET_ENROLLMENT_BY_ID', 'DELETE',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('9593ca58-78f6-4794-9d39-9412216c2f97', 'CLIENT_API_GET_ALL_CLIENT_ENROLLMENTS', 'CLIENT_API_GET_ALL_CLIENT_ENROLLMENTS', 'CLIENT_API_GET_ALL_CLIENT_ENROLLMENTS', 'DELETE',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('bdfbf444-7c38-4f6d-834e-5ec9fd96ea45', 'CLIENT_API_CREATE_ORGANIZATION', 'CLIENT_API_CREATE_ORGANIZATION', 'CLIENT_API_CREATE_ORGANIZATION', 'POST',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('571b5e1d-a604-40f5-b1a5-4c5cca3ecfe9', 'CLIENT_API_UPDATE_ORGANIZATION', 'CLIENT_API_UPDATE_ORGANIZATION', 'CLIENT_API_UPDATE_ORGANIZATION', 'PUT',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('bd0613c8-4e0c-4b1c-8fd0-4124c3c05614', 'CLIENT_API_DELETE_ORGANIZATION', 'CLIENT_API_DELETE_ORGANIZATION', 'CLIENT_API_DELETE_ORGANIZATION', 'DELETE',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('0d8fa06e-0b11-45ba-8fc5-454f8756b793', 'CLIENT_API_GET_ORGANIZATION_BY_ID', 'CLIENT_API_GET_ORGANIZATION_BY_ID', 'CLIENT_API_GET_ORGANIZATION_BY_ID', 'GET',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('de62bf18-9f06-4189-b164-60d59ab48e98', 'CLIENT_API_GET_ALL_ORGANIZATIONS', 'CLIENT_API_GET_ALL_ORGANIZATIONS', 'CLIENT_API_GET_ALL_ORGANIZATIONS', 'GET',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('dd2a641d-cbca-4840-9024-9cbf5c279aeb', 'CLIENT_API_CREATE_PROJECT', 'CLIENT_API_CREATE_PROJECT', 'CLIENT_API_CREATE_PROJECT', 'POST',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('b9f44583-b7e7-415b-9b2b-9f981ba30574', 'CLIENT_API_UPDATE_PROJECT', 'CLIENT_API_UPDATE_PROJECT', 'CLIENT_API_UPDATE_PROJECT', 'PUT',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('198a60e1-8ef9-4c2a-96cd-8e15e49f774a', 'CLIENT_API_DELETE_PROJECT', 'CLIENT_API_DELETE_PROJECT', 'CLIENT_API_DELETE_PROJECT', 'DELETE',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('f4f0f4d5-0eef-4cf1-8226-eb1343975c4f', 'CLIENT_API_GET_PROJECT_BY_ID', 'CLIENT_API_GET_PROJECT_BY_ID', 'CLIENT_API_GET_PROJECT_BY_ID', 'GET',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('cd448336-1791-4b7e-96f9-34fc2cb20a62', 'CLIENT_API_GET_ALL_PROJECTS', 'CLIENT_API_GET_ALL_PROJECTS', 'CLIENT_API_GET_ALL_PROJECTS', 'GET',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('60dc7f8b-72cd-43b8-8b22-56d35929302e', 'CLIENT_API_CREATE_EXIT', 'CLIENT_API_CREATE_EXIT', 'CLIENT_API_CREATE_EXIT', 'POST',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('6f72857a-f541-4727-9bb7-fc960ce6dfb5', 'CLIENT_API_UPDATE_EXIT', 'CLIENT_API_UPDATE_EXIT', 'CLIENT_API_UPDATE_EXIT', 'PUT',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('f68ce487-2bbf-4a36-b4e8-e693ab7194de', 'CLIENT_API_DELETE_EXIT', 'CLIENT_API_DELETE_EXIT', 'CLIENT_API_DELETE_EXIT', 'DELETE',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('63967a85-6ebb-47d0-a6f7-2f9655e24003', 'CLIENT_API_GET_EXIT_BY_ID', 'CLIENT_API_GET_EXIT_BY_ID', 'CLIENT_API_GET_EXIT_BY_ID', 'GET',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('8e765380-7904-4956-8b10-1f1f020cb941', 'CLIENT_API_GET_ALL_ENROLLMENT_EXITS', 'CLIENT_API_GET_ALL_ENROLLMENT_EXITS', 'CLIENT_API_GET_ALL_ENROLLMENT_EXITS', 'GET',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('355091a6-3cf4-4ebb-b2d4-978150d8642a', 'CLIENT_API_CREATE_EMPLOYMENT', 'CLIENT_API_CREATE_EMPLOYMENT', 'CLIENT_API_CREATE_EMPLOYMENT', 'POST',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('9e4d1e1f-d745-4b08-8897-0f9f3bd169c4', 'CLIENT_API_UPDATE_EMPLOYMENT', 'CLIENT_API_UPDATE_EMPLOYMENT', 'CLIENT_API_UPDATE_EMPLOYMENT', 'PUT',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('d911b5d4-4ebf-49b4-b9af-5c1a55bab3ec', 'CLIENT_API_DELETE_EMPLOYMENT', 'CLIENT_API_DELETE_EMPLOYMENT', 'CLIENT_API_DELETE_EMPLOYMENT', 'DELETE',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('4888faa8-c77c-4616-8b1b-35b1f3580b58', 'CLIENT_API_GET_EMPLOYMENT_BY_ID', 'CLIENT_API_GET_EMPLOYMENT_BY_ID', 'CLIENT_API_GET_EMPLOYMENT_BY_ID', 'GET',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('7f75f7a1-2417-4451-aa94-7ec6117c4457', 'CLIENT_API_GET_ALL_ENROLLMENT_EMPLOYMENTS', 'CLIENT_API_GET_ALL_ENROLLMENT_EMPLOYMENTS', 'CLIENT_API_GET_ALL_ENROLLMENT_EMPLOYMENTS', 'GET',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('5e1be2f5-9ce0-4e6f-a5d7-70ebf02102a0', 'CREATE_RELEASE_OF_INFO', 'CREATE_RELEASE_OF_INFO', 'CREATE_RELEASE_OF_INFO', 'POST',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('1e06c880-3f22-49d1-8d0f-6198f9f655f4', 'UPDATE_RELEASE_OF_INFO', 'UPDATE_RELEASE_OF_INFO', 'UPDATE_RELEASE_OF_INFO', 'PUT',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('fef09357-a5db-4aad-b37d-186a75761df0', 'DELETE_RELEASE_OF_INFO', 'DELETE_RELEASE_OF_INFO', 'DELETE_RELEASE_OF_INFO', 'DELETE',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('c3a6b7b3-3c11-433c-9fc9-ea89e4144f87', 'CLIENT_API_CREATE_VETERANINFO', 'CLIENT_API_CREATE_VETERANINFO', 'CLIENT_API_CREATE_VETERANINFO', 'POST',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('0a1508df-fb98-454a-9cf0-674bd97e7d14', 'CLIENT_API_UPDATE_VETERANINFO', 'CLIENT_API_UPDATE_VETERANINFO', 'CLIENT_API_UPDATE_VETERANINFO', 'PUT',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('f7a9ef22-cf7f-430d-b6d8-cc768aeadb66', 'CLIENT_API_DELETE_VETERANINFO', 'CLIENT_API_DELETE_VETERANINFO', 'CLIENT_API_DELETE_VETERANINFO', 'DELETE',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('50a617a7-0b06-488f-8bd5-28f4a405ebb2', 'CLIENT_API_GET_VETERANINFO_BY_ID', 'CLIENT_API_GET_VETERANINFO_BY_ID', 'CLIENT_API_GET_VETERANINFO_BY_ID', 'GET',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('13217607-c73b-40c4-a763-3296b5d75453', 'CLIENT_API_GET_ALL_CLIENT_VETERANINFOS', 'CLIENT_API_GET_ALL_CLIENT_VETERANINFOS', 'CLIENT_API_GET_ALL_CLIENT_VETERANINFOS', 'GET',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('8a91c8c8-0d15-4ff8-b6d2-739f3c0b169c', 'CLIENT_API_CREATE_DISABILITIES', 'CLIENT_API_CREATE_DISABILITIES', 'CLIENT_API_CREATE_DISABILITIES', 'POST',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('eb58705d-7c2e-4cdf-8d3b-6ee68ee9fdcd', 'CLIENT_API_UPDATE_DISABILITIES', 'CLIENT_API_UPDATE_DISABILITIES', 'CLIENT_API_UPDATE_DISABILITIES', 'PUT',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('350ec67e-8630-4589-a559-286036822f80', 'CLIENT_API_DELETE_DISABILITIES', 'CLIENT_API_DELETE_DISABILITIES', 'CLIENT_API_DELETE_DISABILITIES', 'DELETE',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('14fbd19f-5c74-439f-8297-5f858c9c2c30', 'CLIENT_API_GET_DISABILITIES_BY_ID', 'CLIENT_API_GET_DISABILITIES_BY_ID', 'CLIENT_API_GET_DISABILITIES_BY_ID', 'GET',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('abe7f2ad-e97a-46bc-9198-95caf5bce5c0', 'CLIENT_API_GET_ALL_ENROLLMENT_DISABILITIES', 'CLIENT_API_GET_ALL_ENROLLMENT_DISABILITIES', 'CLIENT_API_GET_ALL_ENROLLMENT_DISABILITIES', 'GET',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('341fefb0-c6f9-4958-b06e-352a01907dce', 'CLIENT_API_CREATE_INCOMEANDSOURCE', 'CLIENT_API_CREATE_INCOMEANDSOURCE', 'CLIENT_API_CREATE_INCOMEANDSOURCE', 'POST',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('a482933a-7102-4829-81fb-a8364eed2314', 'CLIENT_API_UPDATE_INCOMEANDSOURCE', 'CLIENT_API_UPDATE_INCOMEANDSOURCE', 'CLIENT_API_UPDATE_INCOMEANDSOURCE', 'PUT',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('78f221e3-72cb-415f-89ca-c3c3075640eb', 'CLIENT_API_DELETE_INCOMEANDSOURCE', 'CLIENT_API_DELETE_INCOMEANDSOURCE', 'CLIENT_API_DELETE_INCOMEANDSOURCE', 'DELETE',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('3662e8c3-d44b-44b1-8a7f-69bb99a873f2', 'CLIENT_API_GET_INCOMEANDSOURCE_BY_ID', 'CLIENT_API_GET_INCOMEANDSOURCE_BY_ID', 'CLIENT_API_GET_INCOMEANDSOURCE_BY_ID', 'GET',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('59a4e91e-1cbc-4546-a31a-a17a30c6aca5', 'CLIENT_API_GET_ALL_ENROLLMENT_INCOMEANDSOURCE', 'CLIENT_API_GET_ALL_ENROLLMENT_INCOMEANDSOURCE', 'CLIENT_API_GET_ALL_ENROLLMENT_INCOMEANDSOURCE', 'GET',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('0be58adf-acbb-49d1-932a-fa45fd11f01b', 'CLIENT_API_CREATE_HEALTHINSURANCE', 'CLIENT_API_CREATE_HEALTHINSURANCE', 'CLIENT_API_CREATE_HEALTHINSURANCE', 'POST',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('11fd5572-6b81-4421-abd6-bf5978a544ee', 'CLIENT_API_UPDATE_HEALTHINSURANCE', 'CLIENT_API_UPDATE_HEALTHINSURANCE', 'CLIENT_API_UPDATE_HEALTHINSURANCE', 'PUT',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('6e80e630-ddc0-4afd-afa3-42e9f35bb800', 'CLIENT_API_DELETE_HEALTHINSURANCE', 'CLIENT_API_DELETE_HEALTHINSURANCE', 'CLIENT_API_DELETE_HEALTHINSURANCE', 'DELETE',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('adfb3551-9f79-4def-b75a-9891f812b6a9', 'CLIENT_API_GET_HEALTHINSURANCE_BY_ID', 'CLIENT_API_GET_HEALTHINSURANCE_BY_ID', 'CLIENT_API_GET_HEALTHINSURANCE_BY_ID', 'GET',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('402c3747-7682-49b6-a17e-676f354b9f2b', 'CLIENT_API_GET_ALL_ENROLLMENT_HEALTHINSURANCE', 'CLIENT_API_GET_ALL_ENROLLMENT_HEALTHINSURANCE', 'CLIENT_API_GET_ALL_ENROLLMENT_HEALTHINSURANCE', 'GET',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('a12fc32c-439d-455d-9f12-7861277f82d1', 'CLIENT_API_CREATE_SERVICES', 'CLIENT_API_CREATE_SERVICES', 'CLIENT_API_CREATE_SERVICES', 'POST',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('9923b935-14d9-4256-bfbe-a40d279eee32', 'CLIENT_API_UPDATE_SERVICES', 'CLIENT_API_UPDATE_SERVICES', 'CLIENT_API_UPDATE_SERVICES', 'PUT',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('d20687b3-4ceb-47ba-b80d-9a1925bbcca2', 'CLIENT_API_DELETE_SERVICES', 'CLIENT_API_DELETE_SERVICES', 'CLIENT_API_DELETE_SERVICES', 'DELETE',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('c4cf4f01-cc9a-416c-8045-0459cf425ba1', 'CLIENT_API_GET_SERVICES_BY_ID', 'CLIENT_API_GET_SERVICES_BY_ID', 'CLIENT_API_GET_SERVICES_BY_ID', 'GET',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('8c7f3727-57fb-40a6-947b-79c6ddddb605', 'CLIENT_API_GET_ALL_ENROLLMENT_SERVICES', 'CLIENT_API_GET_ALL_ENROLLMENT_SERVICES', 'CLIENT_API_GET_ALL_ENROLLMENT_SERVICES', 'GET',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('6991292c-d6c6-4c79-a2e7-98149b9be0cd', 'CLIENT_API_CREATE_HEALTHSTATUS', 'CLIENT_API_CREATE_HEALTHSTATUS', 'CLIENT_API_CREATE_HEALTHSTATUS', 'POST',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('394d665f-e6be-45ef-b117-ba77d0e30957', 'CLIENT_API_UPDATE_HEALTHSTATUS', 'CLIENT_API_UPDATE_HEALTHSTATUS', 'CLIENT_API_UPDATE_HEALTHSTATUS', 'PUT',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('ec3bb7dc-e7c2-4a61-90d1-58b8f690aa40', 'CLIENT_API_DELETE_HEALTHSTATUS', 'CLIENT_API_DELETE_HEALTHSTATUS', 'CLIENT_API_DELETE_HEALTHSTATUS', 'DELETE',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('6632c6cc-0fe9-4347-a114-425f91174209', 'CLIENT_API_GET_HEALTHSTATUS_BY_ID', 'CLIENT_API_GET_HEALTHSTATUS_BY_ID', 'CLIENT_API_GET_HEALTHSTATUS_BY_ID', 'GET',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('c0a290cf-dd88-4178-a83f-995612562c73', 'CLIENT_API_GET_ALL_ENROLLMENT_HEALTHSTATUS', 'CLIENT_API_GET_ALL_ENROLLMENT_HEALTHSTATUS', 'CLIENT_API_GET_ALL_ENROLLMENT_HEALTHSTATUS', 'GET',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('afb941bb-0357-4f82-8226-f21e26b3e43f', 'CLIENT_API_CREATE_COMMERCIAL_SEXUAL_EXPLOITATION', 'CLIENT_API_CREATE_COMMERCIAL_SEXUAL_EXPLOITATION', 'CLIENT_API_CREATE_COMMERCIAL_SEXUAL_EXPLOITATION', 'POST',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('6cc8fdb7-bad4-4ba7-9ae7-4a4b7fbc7217', 'CLIENT_API_UPDATE_COMMERCIAL_SEXUAL_EXPLOITATION', 'CLIENT_API_UPDATE_COMMERCIAL_SEXUAL_EXPLOITATION', 'CLIENT_API_UPDATE_COMMERCIAL_SEXUAL_EXPLOITATION', 'PUT',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('c6aa7a91-3a51-45c4-b272-3a8176567cb7', 'CLIENT_API_DELETE_COMMERCIAL_SEXUAL_EXPLOITATION', 'CLIENT_API_DELETE_COMMERCIAL_SEXUAL_EXPLOITATION', 'CLIENT_API_DELETE_COMMERCIAL_SEXUAL_EXPLOITATION', 'DELETE',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('9e11c79b-acec-4a44-8901-64d8183f929b', 'CLIENT_API_GET_COMMERCIAL_SEXUAL_EXPLOITATION_BY_ID', 'CLIENT_API_GET_COMMERCIAL_SEXUAL_EXPLOITATION_BY_ID', 'CLIENT_API_GET_COMMERCIAL_SEXUAL_EXPLOITATION_BY_ID', 'GET',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('13df344f-e431-494f-b775-e906fb35e8cd', 'CLIENT_API_GET_ALL_ENROLLMENT_COMMERCIAL_SEXUAL_EXPLOITATION', 'CLIENT_API_GET_ALL_ENROLLMENT_COMMERCIAL_SEXUAL_EXPLOITATION', 'CLIENT_API_GET_ALL_ENROLLMENT_COMMERCIAL_SEXUAL_EXPLOITATION', 'GET',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('d361bdb6-3d08-45d9-9525-3bb47635f7ed', 'CLIENT_API_CREATE_DATEOFENGAGEMENT', 'CLIENT_API_CREATE_DATEOFENGAGEMENT', 'CLIENT_API_CREATE_DATEOFENGAGEMENT', 'POST',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('dbc13111-6484-418b-b13e-656844d263b4', 'CLIENT_API_UPDATE_DATEOFENGAGEMENT', 'CLIENT_API_UPDATE_DATEOFENGAGEMENT', 'CLIENT_API_UPDATE_DATEOFENGAGEMENT', 'PUT',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('744c4025-6b52-4d84-9667-d15330ce809b', 'CLIENT_API_DELETE_DATEOFENGAGEMENT', 'CLIENT_API_DELETE_DATEOFENGAGEMENT', 'CLIENT_API_DELETE_DATEOFENGAGEMENT', 'DELETE',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('badf96ca-4d84-4c70-aa1c-17b970bce72e', 'CLIENT_API_GET_DATEOFENGAGEMENT_BY_ID', 'CLIENT_API_GET_DATEOFENGAGEMENT_BY_ID', 'CLIENT_API_GET_DATEOFENGAGEMENT_BY_ID', 'GET',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('3ddc65d9-5e83-423d-ad88-f4429fad36fc', 'CLIENT_API_GET_ALL_ENROLLMENT_DATEOFENGAGEMENT', 'CLIENT_API_GET_ALL_ENROLLMENT_DATEOFENGAGEMENT', 'CLIENT_API_GET_ALL_ENROLLMENT_DATEOFENGAGEMENT', 'GET',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('479e3241-c67e-40be-8be1-702de6d495d9', 'CLIENT_API_CREATE_DOMESTICVIOLENCE', 'CLIENT_API_CREATE_DOMESTICVIOLENCE', 'CLIENT_API_CREATE_DOMESTICVIOLENCE', 'POST',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('924cfbbe-2d7e-4787-b1fb-b0baa8808f98', 'CLIENT_API_UPDATE_DOMESTICVIOLENCE', 'CLIENT_API_UPDATE_DOMESTICVIOLENCE', 'CLIENT_API_UPDATE_DOMESTICVIOLENCE', 'PUT',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('4a88c712-c12e-43b5-ba72-75ee68af229a', 'CLIENT_API_DELETE_DOMESTICVIOLENCE', 'CLIENT_API_DELETE_DOMESTICVIOLENCE', 'CLIENT_API_DELETE_DOMESTICVIOLENCE', 'DELETE',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('8a612812-7d39-4058-899a-cff574ebabe8', 'CLIENT_API_GET_DOMESTICVIOLENCE_BY_ID', 'CLIENT_API_GET_DOMESTICVIOLENCE_BY_ID', 'CLIENT_API_GET_DOMESTICVIOLENCE_BY_ID', 'GET',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('de1e9398-151e-4895-93c9-020862c046da', 'CLIENT_API_GET_ALL_ENROLLMENT_DOMESTICVIOLENCE', 'CLIENT_API_GET_ALL_ENROLLMENT_DOMESTICVIOLENCE', 'CLIENT_API_GET_ALL_ENROLLMENT_DOMESTICVIOLENCE', 'GET',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('edaa2799-7dd6-4398-b2ad-876b89ac6343', 'CLIENT_API_CREATE_LASTPERMANENTADDRESS', 'CLIENT_API_CREATE_LASTPERMANENTADDRESS', 'CLIENT_API_CREATE_LASTPERMANENTADDRESS', 'POST',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('e7439dff-2ac5-449c-92b1-d908d141085e', 'CLIENT_API_UPDATE_LASTPERMANENTADDRESS', 'CLIENT_API_UPDATE_LASTPERMANENTADDRESS', 'CLIENT_API_UPDATE_LASTPERMANENTADDRESS', 'PUT',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('4f6e4806-ffca-493e-aa55-79456ce995d8', 'CLIENT_API_DELETE_LASTPERMANENTADDRESS', 'CLIENT_API_DELETE_LASTPERMANENTADDRESS', 'CLIENT_API_DELETE_LASTPERMANENTADDRESS', 'DELETE',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('582ed8a9-36da-4277-a582-76ecc2170f67', 'CLIENT_API_GET_LASTPERMANENTADDRESS_BY_ID', 'CLIENT_API_GET_LASTPERMANENTADDRESS_BY_ID', 'CLIENT_API_GET_LASTPERMANENTADDRESS_BY_ID', 'GET',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('72701850-deb3-4352-80da-3083268d2efd', 'CLIENT_API_GET_ALL_ENROLLMENT_LASTPERMANENTADDRESS', 'CLIENT_API_GET_ALL_ENROLLMENT_LASTPERMANENTADDRESS', 'CLIENT_API_GET_ALL_ENROLLMENT_LASTPERMANENTADDRESS', 'GET',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('78cdbebc-0d58-458c-8b77-55cb1f0d504b', 'CLIENT_API_CREATE_YOUTHCRITICALISSUES', 'CLIENT_API_CREATE_YOUTHCRITICALISSUES', 'CLIENT_API_CREATE_YOUTHCRITICALISSUES', 'POST',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('4ec1c5f4-7ed7-4a2a-aa1e-d8982026d2b7', 'CLIENT_API_UPDATE_YOUTHCRITICALISSUES', 'CLIENT_API_UPDATE_YOUTHCRITICALISSUES', 'CLIENT_API_UPDATE_YOUTHCRITICALISSUES', 'PUT',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('a4732d69-498b-424f-a87d-a70a6080fa2f', 'CLIENT_API_DELETE_YOUTHCRITICALISSUES', 'CLIENT_API_DELETE_YOUTHCRITICALISSUES', 'CLIENT_API_DELETE_YOUTHCRITICALISSUES', 'DELETE',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('face51a2-9cf9-491c-b401-70895f0f6212', 'CLIENT_API_GET_YOUTHCRITICALISSUES_BY_ID', 'CLIENT_API_GET_YOUTHCRITICALISSUES_BY_ID', 'CLIENT_API_GET_YOUTHCRITICALISSUES_BY_ID', 'GET',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('f6e0c6de-0643-4ac8-b437-aba71ef10f3f', 'CLIENT_API_GET_ALL_ENROLLMENT_YOUTHCRITICALISSUES', 'CLIENT_API_GET_ALL_ENROLLMENT_YOUTHCRITICALISSUES', 'CLIENT_API_GET_ALL_ENROLLMENT_YOUTHCRITICALISSUES', 'GET',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('58711f6f-1ad7-4a52-8fdc-877b0bdd60a5', 'CLIENT_API_CREATE_WORSTHOUSINGSITUATION', 'CLIENT_API_CREATE_WORSTHOUSINGSITUATION', 'CLIENT_API_CREATE_WORSTHOUSINGSITUATION', 'POST',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('35068953-ef21-430a-93fb-bed54dfacca7', 'CLIENT_API_UPDATE_WORSTHOUSINGSITUATION', 'CLIENT_API_UPDATE_WORSTHOUSINGSITUATION', 'CLIENT_API_UPDATE_WORSTHOUSINGSITUATION', 'PUT',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('3c0f2c54-619b-4ce7-b951-1e2f78ebdf66', 'CLIENT_API_DELETE_WORSTHOUSINGSITUATION', 'CLIENT_API_DELETE_WORSTHOUSINGSITUATION', 'CLIENT_API_DELETE_WORSTHOUSINGSITUATION', 'DELETE',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('a290891b-9290-4f0d-8b6d-8e8fd5bf45a7', 'CLIENT_API_GET_WORSTHOUSINGSITUATION_BY_ID', 'CLIENT_API_GET_WORSTHOUSINGSITUATION_BY_ID', 'CLIENT_API_GET_WORSTHOUSINGSITUATION_BY_ID', 'GET',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('566feb4b-b124-4b1d-8434-e54badc8188b', 'CLIENT_API_GET_ALL_ENROLLMENT_WORSTHOUSINGSITUATION', 'CLIENT_API_GET_ALL_ENROLLMENT_WORSTHOUSINGSITUATION', 'CLIENT_API_GET_ALL_ENROLLMENT_WORSTHOUSINGSITUATION', 'GET',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('04c98d58-11e9-4bbc-a139-84ee1c5cb483', 'CLIENT_API_CREATE_SEXUALORIENTATION', 'CLIENT_API_CREATE_SEXUALORIENTATION', 'CLIENT_API_CREATE_SEXUALORIENTATION', 'POST',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('4bbe267a-476f-4eed-ae8e-3e1e4b687f41', 'CLIENT_API_UPDATE_SEXUALORIENTATION', 'CLIENT_API_UPDATE_SEXUALORIENTATION', 'CLIENT_API_UPDATE_SEXUALORIENTATION', 'PUT',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('782a5983-f13d-48b7-a8ca-3a9bb45c6b8c', 'CLIENT_API_DELETE_SEXUALORIENTATION', 'CLIENT_API_DELETE_SEXUALORIENTATION', 'CLIENT_API_DELETE_SEXUALORIENTATION', 'DELETE',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('f8dc1d92-ba90-4a70-a514-123ba300d271', 'CLIENT_API_GET_SEXUALORIENTATION_BY_ID', 'CLIENT_API_GET_SEXUALORIENTATION_BY_ID', 'CLIENT_API_GET_SEXUALORIENTATION_BY_ID', 'GET',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('dcc33c8e-c755-4440-acc5-6c1fc11d6248', 'CLIENT_API_GET_ALL_ENROLLMENT_SEXUALORIENTATION', 'CLIENT_API_GET_ALL_ENROLLMENT_SEXUALORIENTATION', 'CLIENT_API_GET_ALL_ENROLLMENT_SEXUALORIENTATION', 'GET',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('1905d0ff-67e0-4336-bb58-d464242d4736', 'CLIENT_API_CREATE_SCHOOLSTATUS', 'CLIENT_API_CREATE_SCHOOLSTATUS', 'CLIENT_API_CREATE_SCHOOLSTATUS', 'POST',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('a1760a4e-cfe0-44f9-9ad0-51699f6e66ad', 'CLIENT_API_UPDATE_SCHOOLSTATUS', 'CLIENT_API_UPDATE_SCHOOLSTATUS', 'CLIENT_API_UPDATE_SCHOOLSTATUS', 'PUT',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('4e609b82-22f7-4c99-8e05-df7d5fb011a4', 'CLIENT_API_DELETE_SCHOOLSTATUS', 'CLIENT_API_DELETE_SCHOOLSTATUS', 'CLIENT_API_DELETE_SCHOOLSTATUS', 'DELETE',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('e1ac8c7a-ddb9-46d7-b853-2382fa8cde2f', 'CLIENT_API_GET_SCHOOLSTATUS_BY_ID', 'CLIENT_API_GET_SCHOOLSTATUS_BY_ID', 'CLIENT_API_GET_SCHOOLSTATUS_BY_ID', 'GET',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('217e1e9d-867f-475d-b384-8bc157b0d9da', 'CLIENT_API_GET_ALL_ENROLLMENT_SCHOOLSTATUS', 'CLIENT_API_GET_ALL_ENROLLMENT_SCHOOLSTATUS', 'CLIENT_API_GET_ALL_ENROLLMENT_SCHOOLSTATUS', 'GET',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('23035de9-d605-48db-8af8-004cde21efd5', 'CLIENT_API_CREATE_RHYBCPSTATUS', 'CLIENT_API_CREATE_RHYBCPSTATUS', 'CLIENT_API_CREATE_RHYBCPSTATUS', 'POST',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('3102b3c0-eec4-4009-8b91-676703b96a0e', 'CLIENT_API_UPDATE_RHYBCPSTATUS', 'CLIENT_API_UPDATE_RHYBCPSTATUS', 'CLIENT_API_UPDATE_RHYBCPSTATUS', 'PUT',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('1413a447-07e8-4811-9c65-98b6621ef596', 'CLIENT_API_DELETE_RHYBCPSTATUS', 'CLIENT_API_DELETE_RHYBCPSTATUS', 'CLIENT_API_DELETE_RHYBCPSTATUS', 'DELETE',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('e3ef900a-aab0-4750-8207-f61e9fe8e977', 'CLIENT_API_GET_RHYBCPSTATUS_BY_ID', 'CLIENT_API_GET_RHYBCPSTATUS_BY_ID', 'CLIENT_API_GET_RHYBCPSTATUS_BY_ID', 'GET',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('56f67c36-e816-48ac-95df-ff2730bd67e5', 'CLIENT_API_GET_ALL_ENROLLMENT_RHYBCPSTATUS', 'CLIENT_API_GET_ALL_ENROLLMENT_RHYBCPSTATUS', 'CLIENT_API_GET_ALL_ENROLLMENT_RHYBCPSTATUS', 'GET',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('b848f4db-ed2d-45ba-9119-96d2c62bfc9f', 'CLIENT_API_CREATE_RESIDENTIALMOVEINDATE', 'CLIENT_API_CREATE_RESIDENTIALMOVEINDATE', 'CLIENT_API_CREATE_RESIDENTIALMOVEINDATE', 'POST',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('fe71b6a6-e87c-42e9-9075-aaf347f18c08', 'CLIENT_API_UPDATE_RESIDENTIALMOVEINDATE', 'CLIENT_API_UPDATE_RESIDENTIALMOVEINDATE', 'CLIENT_API_UPDATE_RESIDENTIALMOVEINDATE', 'PUT',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('dfe2f69c-7fc4-4f49-a3f9-bf95e5c13786', 'CLIENT_API_DELETE_RESIDENTIALMOVEINDATE', 'CLIENT_API_DELETE_RESIDENTIALMOVEINDATE', 'CLIENT_API_DELETE_RESIDENTIALMOVEINDATE', 'DELETE',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('28f918f9-f9fb-4e3f-9544-9fe88f883138', 'CLIENT_API_GET_RESIDENTIALMOVEINDATE_BY_ID', 'CLIENT_API_GET_RESIDENTIALMOVEINDATE_BY_ID', 'CLIENT_API_GET_RESIDENTIALMOVEINDATE_BY_ID', 'GET',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('e117a157-b660-4b9e-9477-522dba201d37', 'CLIENT_API_GET_ALL_ENROLLMENT_RESIDENTIALMOVEINDATE', 'CLIENT_API_GET_ALL_ENROLLMENT_RESIDENTIALMOVEINDATE', 'CLIENT_API_GET_ALL_ENROLLMENT_RESIDENTIALMOVEINDATE', 'GET',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('3b9c45fa-4cde-4b71-a0c4-19956d8b11c9', 'CLIENT_API_CREATE_REFERRALSOURCE', 'CLIENT_API_CREATE_REFERRALSOURCE', 'CLIENT_API_CREATE_REFERRALSOURCE', 'POST',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('1c08e652-d950-4112-b84e-094f118da746', 'CLIENT_API_UPDATE_REFERRALSOURCE', 'CLIENT_API_UPDATE_REFERRALSOURCE', 'CLIENT_API_UPDATE_REFERRALSOURCE', 'PUT',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('eed5a604-438e-47df-9685-d4e777f8408b', 'CLIENT_API_DELETE_REFERRALSOURCE', 'CLIENT_API_DELETE_REFERRALSOURCE', 'CLIENT_API_DELETE_REFERRALSOURCE', 'DELETE',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('2c1865d5-b841-42a4-b98d-088157ce9349', 'CLIENT_API_GET_REFERRALSOURCE_BY_ID', 'CLIENT_API_GET_REFERRALSOURCE_BY_ID', 'CLIENT_API_GET_REFERRALSOURCE_BY_ID', 'GET',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('e92759df-2282-4998-bb15-1da523b26c0e', 'CLIENT_API_GET_ALL_ENROLLMENT_REFERRALSOURCE', 'CLIENT_API_GET_ALL_ENROLLMENT_REFERRALSOURCE', 'CLIENT_API_GET_ALL_ENROLLMENT_REFERRALSOURCE', 'GET',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('b0fff4c4-046f-4d37-9408-59891617a4e6', 'CLIENT_API_CREATE_PERCENTAMI', 'CLIENT_API_CREATE_PERCENTAMI', 'CLIENT_API_CREATE_PERCENTAMI', 'POST',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('c3969509-452a-421c-a5dd-20af814ad57e', 'CLIENT_API_UPDATE_PERCENTAMI', 'CLIENT_API_UPDATE_PERCENTAMI', 'CLIENT_API_UPDATE_PERCENTAMI', 'PUT',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('87becc4f-de09-4ab0-b77a-e723f93e71c7', 'CLIENT_API_DELETE_PERCENTAMI', 'CLIENT_API_DELETE_PERCENTAMI', 'CLIENT_API_DELETE_PERCENTAMI', 'DELETE',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('7510471c-577b-495a-82bd-2dd5ea6ce3cd', 'CLIENT_API_GET_PERCENTAMI_BY_ID', 'CLIENT_API_GET_PERCENTAMI_BY_ID', 'CLIENT_API_GET_PERCENTAMI_BY_ID', 'GET',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('cab14611-39d2-4243-9aa2-ea3e983d131a', 'CLIENT_API_GET_ALL_ENROLLMENT_PERCENTAMI', 'CLIENT_API_GET_ALL_ENROLLMENT_PERCENTAMI', 'CLIENT_API_GET_ALL_ENROLLMENT_PERCENTAMI', 'GET',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('0d57b1f7-74ce-441b-a1ef-cdb6a9e23ab5', 'CLIENT_API_CREATE_PATHSTATUS', 'CLIENT_API_CREATE_PATHSTATUS', 'CLIENT_API_CREATE_PATHSTATUS', 'POST',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('d33601be-7f8e-4d97-b2a2-307fabea17d3', 'CLIENT_API_UPDATE_PATHSTATUS', 'CLIENT_API_UPDATE_PATHSTATUS', 'CLIENT_API_UPDATE_PATHSTATUS', 'PUT',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('739c55f6-beae-4e50-8cb9-b0092d9b173f', 'CLIENT_API_DELETE_PATHSTATUS', 'CLIENT_API_DELETE_PATHSTATUS', 'CLIENT_API_DELETE_PATHSTATUS', 'DELETE',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('f23595ef-0333-4256-ac8e-059f9227bafd', 'CLIENT_API_GET_PATHSTATUS_BY_ID', 'CLIENT_API_GET_PATHSTATUS_BY_ID', 'CLIENT_API_GET_PATHSTATUS_BY_ID', 'GET',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('51e79830-e0ca-4c87-9306-909c6cdd9b37', 'CLIENT_API_GET_ALL_ENROLLMENT_PATHSTATUS', 'CLIENT_API_GET_ALL_ENROLLMENT_PATHSTATUS', 'CLIENT_API_GET_ALL_ENROLLMENT_PATHSTATUS', 'GET',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('5a271d8b-0e6a-46b1-b507-b4532c1e41f0', 'CLIENT_API_CREATE_MEDICALASSISTANCE', 'CLIENT_API_CREATE_MEDICALASSISTANCE', 'CLIENT_API_CREATE_MEDICALASSISTANCE', 'POST',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('b6424776-2314-459d-85e1-acd51acf1522', 'CLIENT_API_UPDATE_MEDICALASSISTANCE', 'CLIENT_API_UPDATE_MEDICALASSISTANCE', 'CLIENT_API_UPDATE_MEDICALASSISTANCE', 'PUT',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('1a482c73-73aa-48f4-8e93-7f84b326fa5c', 'CLIENT_API_DELETE_MEDICALASSISTANCE', 'CLIENT_API_DELETE_MEDICALASSISTANCE', 'CLIENT_API_DELETE_MEDICALASSISTANCE', 'DELETE',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('93640f23-ecfe-426a-95b3-e34491c3950f', 'CLIENT_API_GET_MEDICALASSISTANCE_BY_ID', 'CLIENT_API_GET_MEDICALASSISTANCE_BY_ID', 'CLIENT_API_GET_MEDICALASSISTANCE_BY_ID', 'GET',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('33eae13a-0eec-4845-a7d4-a5ffa91a11c9', 'CLIENT_API_GET_ALL_ENROLLMENT_MEDICALASSISTANCE', 'CLIENT_API_GET_ALL_ENROLLMENT_MEDICALASSISTANCE', 'CLIENT_API_GET_ALL_ENROLLMENT_MEDICALASSISTANCE', 'GET',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('8374d2a9-3093-4916-a681-aeca2a797a76', 'CLIENT_API_CREATE_PROJECTCOC', 'CLIENT_API_CREATE_PROJECTCOC', 'CLIENT_API_CREATE_PROJECTCOC', 'POST',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('71067f7e-c75e-4ad1-b379-0d1a75001a8d', 'CLIENT_API_UPDATE_PROJECTCOC', 'CLIENT_API_UPDATE_PROJECTCOC', 'CLIENT_API_UPDATE_PROJECTCOC', 'PUT',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('aac3ace0-ce8c-4da2-9c74-316d2fee97c5', 'CLIENT_API_DELETE_PROJECTCOC', 'CLIENT_API_DELETE_PROJECTCOC', 'CLIENT_API_DELETE_PROJECTCOC', 'DELETE',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('667b382b-dec6-480c-b88a-28d712c03faf', 'CLIENT_API_GET_PROJECTCOC_BY_ID', 'CLIENT_API_GET_PROJECTCOC_BY_ID', 'CLIENT_API_GET_PROJECTCOC_BY_ID', 'GET',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('988e57a4-92d3-49eb-8be6-d0a588cb59af', 'CLIENT_API_GET_ALL_PROJECT_PROJECTCOC', 'CLIENT_API_GET_ALL_PROJECT_PROJECTCOC', 'CLIENT_API_GET_ALL_PROJECT_PROJECTCOC', 'GET',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('25dff91c-39f8-4ada-a184-ef6c73252310', 'CLIENT_API_CREATE_NONCASHBENEFIT', 'CLIENT_API_CREATE_NONCASHBENEFIT', 'CLIENT_API_CREATE_NONCASHBENEFIT', 'POST',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('ca963a73-e6b1-4a3c-b9c4-ce06ff2cf4be', 'CLIENT_API_UPDATE_NONCASHBENEFIT', 'CLIENT_API_UPDATE_NONCASHBENEFIT', 'CLIENT_API_UPDATE_NONCASHBENEFIT', 'PUT',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('c4268328-2d4b-4f86-b552-f4473119ad58', 'CLIENT_API_DELETE_NONCASHBENEFIT', 'CLIENT_API_DELETE_NONCASHBENEFIT', 'CLIENT_API_DELETE_NONCASHBENEFIT', 'DELETE',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('d5ee258a-749b-409c-b2a9-7bf7e3d28ff3', 'CLIENT_API_GET_NONCASHBENEFIT_BY_ID', 'CLIENT_API_GET_NONCASHBENEFIT_BY_ID', 'CLIENT_API_GET_NONCASHBENEFIT_BY_ID', 'GET',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('62a74f2e-85f1-4b70-ac82-bd48a82a3f97', 'CLIENT_API_GET_ALL_ENROLLMENT_NONCASHBENEFIT', 'CLIENT_API_GET_ALL_ENROLLMENT_NONCASHBENEFIT', 'CLIENT_API_GET_ALL_ENROLLMENT_NONCASHBENEFIT', 'GET',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('eadb3086-3776-446f-aafa-d7584dcf4f19', 'CLIENT_API_CREATE_SITE', 'CLIENT_API_CREATE_SITE', 'CLIENT_API_CREATE_SITE', 'POST',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('648b4c9a-b914-4bda-8d23-6bfafde9c117', 'CLIENT_API_UPDATE_SITE', 'CLIENT_API_UPDATE_SITE', 'CLIENT_API_UPDATE_SITE', 'PUT',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('0d4c567d-fd6e-4ddc-a421-041723b97865', 'CLIENT_API_DELETE_SITE', 'CLIENT_API_DELETE_SITE', 'CLIENT_API_DELETE_SITE', 'DELETE',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('a8181c53-e27c-4e00-ab88-fa8eb70d07a0', 'CLIENT_API_GET_SITE_BY_ID', 'CLIENT_API_GET_SITE_BY_ID', 'CLIENT_API_GET_SITE_BY_ID', 'GET',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('bd5bc4cb-ab3e-4f90-a748-3480994cc414', 'CLIENT_API_GET_ALL_PROJECTCOC_SITE', 'CLIENT_API_GET_ALL_PROJECTCOC_SITE', 'CLIENT_API_GET_ALL_PROJECTCOC_SITE', 'GET',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('b0be0b23-7531-40db-a6ca-18ad38b83ebf', 'CLIENT_API_CREATE_INVENTORY', 'CLIENT_API_CREATE_INVENTORY', 'CLIENT_API_CREATE_INVENTORY', 'POST',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('2a12c58d-8485-4c93-994a-4740b2c7ddbf', 'CLIENT_API_UPDATE_INVENTORY', 'CLIENT_API_UPDATE_INVENTORY', 'CLIENT_API_UPDATE_INVENTORY', 'PUT',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('3f59c2f2-1d93-4980-8cea-b33f4dd7ab7f', 'CLIENT_API_DELETE_INVENTORY', 'CLIENT_API_DELETE_INVENTORY', 'CLIENT_API_DELETE_INVENTORY', 'DELETE',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('e6c6e413-c49d-4f07-a931-9078b4601504', 'CLIENT_API_GET_INVENTORY_BY_ID', 'CLIENT_API_GET_INVENTORY_BY_ID', 'CLIENT_API_GET_INVENTORY_BY_ID', 'GET',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('42332d41-614c-4b29-949f-17557ed83953', 'CLIENT_API_GET_ALL_PROJECTCOC_INVENTORY', 'CLIENT_API_GET_ALL_PROJECTCOC_INVENTORY', 'CLIENT_API_GET_ALL_PROJECTCOC_INVENTORY', 'GET',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('30d1f4d0-f41f-4a9e-b524-bcacba7ba079', 'USR_CREATE_PROJECTGROUP', 'USR_CREATE_PROJECTGROUP', 'USR_CREATE_PROJECTGROUP', 'POST',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('27aa0372-0299-4661-a519-ef5557bda8a1', 'USR_UPDATE_PROJECTGROUP', 'USR_UPDATE_ROJECTGROUP', 'USR_UPDATE_ROJECTGROUP', 'PUT',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('4876e8ea-967e-4dc5-9679-091e033e6433', 'USR_DELTEE_PROJECTGROUP', 'USR_DELTEE_PROJECTGROUP', 'USR_DELTEE_PROJECTGROUP', 'DELETE',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('eb23bef5-423f-464f-946c-5521eda0820b', 'USR_GET_PROJECTGROUP_ID', 'USR_GET_PROJECTGROUP_ID', 'USR_GET_PROJECTGROUP_ID', 'GET',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('eb23bef5-423f-464f-946c-5521eda0850c', 'USR_BULK_UPLOAD', 'USR_BULK_UPLOAD', 'USR_BULK_UPLOAD', 'POST',current_timestamp, 'MASTER DATA', '13e91f42-20ae-96ef-4a61-95a1e71607df', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('754ee226-2f0f-9691-d164-fd0499832bc6', 'GET_USR_BULK_UPLOAD', 'GET_USR_BULK_UPLOAD', 'GET_USR_BULK_UPLOAD', 'GET',current_timestamp, 'MASTER DATA', '13e91f42-20ae-96ef-4a61-95a1e71607df', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('89103d70-6b5b-471b-9d79-9bd0b8bc7932','DCS_GET_SERVICE_API_GROUPS','DCS_GET_SERVICE_API_GROUPS','DCS_GET_SERVICE_API_GROUPS','GET',CURRENT_timestamp,'MASTER DATA','084ab7d7de7e-1138-4f74-b50e-d9ebbc10',0,TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('eb23bef5-423f-464f-946c-5521eda0850a', 'CLIENT_DEDUP_AUTHENTICATE', 'CLIENT_DEDUP_AUTHENTICATE', 'CLIENT_DEDUP_AUTHENTICATE', 'POST',current_timestamp, 'MASTER DATA', '13e91f42-20ae-96ef-4a61-95a1e71607df', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('eb23bef5-423f-464f-946c-5521eda0850b', 'CLIENT_DEDUP_SERVICE', 'CLIENT_DEDUP_SERVICE', 'CLIENT_DEDUP_SERVICE', 'POST',current_timestamp, 'MASTER DATA', '13e91f42-20ae-96ef-4a61-95a1e71607df', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('eb23bef5-423f-464f-946c-5521eda0851c', 'CLIENT_API_CREATE_ENROLLMENTCOC', 'CLIENT_API_CREATE_ENROLLMENTCOC', 'CLIENT_API_CREATE_ENROLLMENTCOC', 'POST',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);

INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('eb23bef5-423f-464f-946c-5521eda0852a', 'CLIENT_API_UPDATE_ENROLLMENTCOC', 'CLIENT_API_UPDATE_ENROLLMENTCOC', 'CLIENT_API_UPDATE_ENROLLMENTCOC', 'PUT',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('eb23bef5-423f-464f-946c-5521eda0852b', 'CLIENT_API_DELETE_ENROLLMENTCOC', 'CLIENT_API_DELETE_ENROLLMENTCOC', 'CLIENT_API_DELETE_ENROLLMENTCOC', 'DELETE',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('eb23bef5-423f-464f-946c-5521eda0852c', 'CLIENT_API_GET_ENROLLMENTCOC_BY_ID', 'CLIENT_API_GET_ENROLLMENTCOC_BY_ID', 'CLIENT_API_GET_ENROLLMENTCOC_BY_ID', 'GET',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);
INSERT INTO base.hmis_api_method(id,external_id,friendly_name, description,type,created_at,created_by,api_group_id,deprecated,requires_access_token) VALUES ('eb23bef5-423f-464f-946c-5521eda0852d', 'CLIENT_API_GET_ALL_ENROLLMENT_ENROLLMENTCOC', 'CLIENT_API_GET_ALL_ENROLLMENT_ENROLLMENTCOC', 'CLIENT_API_GET_ALL_ENROLLMENT_ENROLLMENTCOC', 'GET',current_timestamp, 'MASTER DATA', '55269f08-273f-4f68-ae9b-f98467b4d091', 0, TRUE);


CLIENT_API_UPDATE_ENROLLMENTCOC
CLIENT_API_DELETE_ENROLLMENTCOC
CLIENT_API_GET_ENROLLMENTCOC_BY_ID
CLIENT_API_GET_ALL_ENROLLMENT_ENROLLMENTCOC

CREATE TABLE base.hmis_developer_company
(
  id uuid NOT NULL,
  external_id character varying(128),
  name character varying(1048) NOT NULL,
  domain character varying(256),
  logo_url character varying(1048),
  created_at date NOT NULL,
  modified_at timestamp,
  created_by character varying(256) NOT NULL,
  modified_by character varying(256),
  deleted timestamp,
  company_size bigint DEFAULT 1,
  app_experience character varying(1024),
  company_skill_set character varying(1024),
  app_platforms character varying(1024),
  expected_app_finish_date timestamp,
  contact_email character varying(256),
  status character varying(10),
  owner_user_id uuid,
  CONSTRAINT "PK_DEVELOPER_COMPANY" PRIMARY KEY (id),
  CONSTRAINT "FK_DC_USERID" FOREIGN KEY (owner_user_id)
      REFERENCES base.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);

CREATE TABLE base.hmis_developer_company_account
(
  id uuid NOT NULL,
  developer_company_id uuid NOT NULL,
  role character varying(32),
  created_at date NOT NULL,
  modified_at timestamp,
  created_by character varying(256) NOT NULL,
  modified_by character varying(256),
  deleted timestamp,
  user_id uuid,
  CONSTRAINT "PK_DEVELOPER_COMPANY_ACCOUNT" PRIMARY KEY (id),
  CONSTRAINT "FK_DCA_USERID" FOREIGN KEY (user_id)
      REFERENCES base.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);


CREATE TABLE base.hmis_developer_company_status
(
  id uuid NOT NULL,
  developer_company_id uuid NOT NULL,
  status character varying(20),
  comments character varying(512),
  created_at date NOT NULL,
  modified_at timestamp,
  created_by character varying(256) NOT NULL,
  modified_by character varying(256),
  deleted timestamp,
  CONSTRAINT "PK_DEVELOPER_COMPANY_STATUS" PRIMARY KEY (id),
  CONSTRAINT "FK_DCS_DEVELOPER_COMPANY_ID" FOREIGN KEY (developer_company_id)
      REFERENCES base.hmis_developer_company_status (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);


CREATE TABLE base.hmis_password_reset
(
  id uuid NOT NULL,
  new_password character varying(256),
  verification_id uuid,
  status character varying(256),
  created_at timestamp,
  modified_at timestamp,
  created_by character varying(256),
  modified_by character varying(256),
  user_id uuid,
  CONSTRAINT "PK_PASSWORD_RESET" PRIMARY KEY (id),
  CONSTRAINT "FK_PR_USER_ID" FOREIGN KEY (user_id)
      REFERENCES base.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "FK_PR_VERIFICATION_ID" FOREIGN KEY (verification_id)
      REFERENCES base.hmis_verification (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);

CREATE TABLE base.hmis_permission_set
(
  id uuid NOT NULL,
  permission_set_name character varying(256),
  permission_set_description character varying(256),
  created_at timestamp,
  created_by character varying(256),
  modified_at timestamp,
  modified_by character varying(256),
  CONSTRAINT "PK_PERMISSION_SET" PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);

CREATE TABLE base.hmis_permission_set_acl
(
  id uuid NOT NULL,
  permission_set_id uuid,
  api_method_id uuid,
  created_at timestamp,
  created_by character varying(256),
  modified_at timestamp,
  modified_by character varying(256),
  CONSTRAINT "PK_PERMISSION_SET_ACL" PRIMARY KEY (id),
  CONSTRAINT "FK_PSA_API_METHOD_ID" FOREIGN KEY (api_method_id)
      REFERENCES base.hmis_api_method (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "FK_PSA_PERMISSION_SET_ID" FOREIGN KEY (permission_set_id)
      REFERENCES base.hmis_permission_set (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);


CREATE TABLE base.hmis_profile
(
  id uuid NOT NULL,
  profile_name character varying(256),
  profile_description character varying(256),
  created_at timestamp,
  created_by character varying(256),
  modified_at timestamp,
  modified_by character varying(256),
  CONSTRAINT "PK_PROFILE" PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);

CREATE TABLE base.hmis_profile_acl
(
  profile_id uuid,
  api_method_id uuid,
  id uuid NOT NULL,
  created_at timestamp,
  created_by character varying(256),
  modified_at timestamp,
  modified_by character varying(256),
  CONSTRAINT "PK_PROFILE_ACL" PRIMARY KEY (id),
  CONSTRAINT "FK_PACL_API_METHOD_ID" FOREIGN KEY (api_method_id)
      REFERENCES base.hmis_api_method (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "FK_PACL_PROFILE_ID" FOREIGN KEY (profile_id)
      REFERENCES base.hmis_profile (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);

CREATE TABLE base.hmis_redirect_uri
(
  id uuid NOT NULL,
  uri character varying(1048) NOT NULL,
  trustedapp_id uuid NOT NULL,
  created_at date NOT NULL,
  modified_at timestamp,
  created_by character varying(256) NOT NULL,
  modified_by character varying(256),
  deleted timestamp,
  CONSTRAINT "PK_REDIRECT_URI" PRIMARY KEY (id),
  CONSTRAINT "FK_RU_TRUSTEDAPP_ID" FOREIGN KEY (trustedapp_id)
      REFERENCES base.hmis_trusted_app (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);

CREATE TABLE base.hmis_refresh_token
(
  id uuid NOT NULL,
  token character varying(128),
  auth_code character varying(128),
  trustedapp_id uuid NOT NULL,
  created_at date NOT NULL,
  modified_at timestamp,
  created_by character varying(256) NOT NULL,
  modified_by character varying(256),
  deleted timestamp,
  user_id uuid,
  CONSTRAINT "PK_REFRESH_TOKEN" PRIMARY KEY (id),
  CONSTRAINT "FK_RT_TRUSTEDAPP_ID" FOREIGN KEY (trustedapp_id)
      REFERENCES base.hmis_trusted_app (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "FK_RT_USERID" FOREIGN KEY (user_id)
      REFERENCES base.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);

CREATE TABLE base.hmis_request_token
(
  id uuid NOT NULL,
  token character varying(128) NOT NULL,
  target_type character varying(32) NOT NULL,
  target_external_id character varying(128) NOT NULL,
  used bigint NOT NULL,
  expires_at date NOT NULL,
  created_at date NOT NULL,
  modified_at timestamp,
  created_by character varying(256) NOT NULL,
  modified_by character varying(256),
  deleted timestamp,
  max_use bigint DEFAULT 1,
  CONSTRAINT "PK_REQUEST_TOKEN" PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);

CREATE TABLE base.hmis_role
(
  id uuid NOT NULL,
  role_name character varying(256),
  role_description character varying(256),
  role_code character varying(256),
  parent_role_id uuid,
  created_at timestamp,
  created_by character varying(256),
  modified_at timestamp,
  modified_by character varying(256),
  CONSTRAINT "PK_ROLE" PRIMARY KEY (id),
  CONSTRAINT "FK_PARENT_ROLE_ID" FOREIGN KEY (parent_role_id)
      REFERENCES base.hmis_role (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);

CREATE TABLE base.hmis_service_api_method
(
  id uuid NOT NULL,
  service_id uuid NOT NULL,
  api_method_id uuid NOT NULL,
  created_at date NOT NULL,
  modified_at timestamp,
  created_by character varying(256) NOT NULL,
  modified_by character varying(256),
  deleted timestamp,
  CONSTRAINT "PK_SERVICE_API_METHOD" PRIMARY KEY (id),
  CONSTRAINT "FK_SAM_API_METHOD_ID" FOREIGN KEY (api_method_id)
      REFERENCES base.hmis_api_method (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "FK_SAM_SERVICE_ID" FOREIGN KEY (service_id)
      REFERENCES base.hmis_service (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);

CREATE TABLE base.hmis_service_status
(
  id uuid NOT NULL,
  service_id uuid NOT NULL,
  status character varying(20),
  comments character varying(512),
  created_at date NOT NULL,
  modified_at timestamp,
  created_by character varying(256) NOT NULL,
  modified_by character varying(256),
  deleted timestamp,
  CONSTRAINT "PK_SERVICE_STATUS" PRIMARY KEY (id),
  CONSTRAINT "FK_SS_SERVICE_ID" FOREIGN KEY (service_id)
      REFERENCES base.hmis_service (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);


CREATE TABLE base.hmis_session
(
  id uuid NOT NULL,
  session_token character varying(256),
  expires_at timestamp(0) without time zone,
  trustedapp_id uuid,
  auth_code character varying(256),
  auth_code_expires_at timestamp without time zone,
  redirect_uri character varying(256),
  refresh_token_id uuid,
  created_at timestamp,
  modified_at timestamp,
  created_by character varying(256),
  modified_by character varying(256),
  user_id uuid,
  CONSTRAINT "PK_SESSION" PRIMARY KEY (id),
  CONSTRAINT "FK_SESS_REFRESH_TOKEN_ID" FOREIGN KEY (refresh_token_id)
      REFERENCES base.hmis_refresh_token (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "FK_SESS_TRUSTEDAPP_ID" FOREIGN KEY (trustedapp_id)
      REFERENCES base.hmis_trusted_app (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "FK_SESS_USERID" FOREIGN KEY (user_id)
      REFERENCES base.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);

CREATE TABLE base.hmis_trusted_app_status
(
  id uuid NOT NULL,
  trustedapp_id uuid NOT NULL,
  status character varying(20),
  comments character varying(512),
  created_at date NOT NULL,
  modified_at timestamp,
  created_by character varying(256) NOT NULL,
  modified_by character varying(256),
  deleted timestamp,
  CONSTRAINT "PK_TRUSTED_APP_STATUS" PRIMARY KEY (id),
  CONSTRAINT "FK_TAPPS_TRUSTED_APP_ID" FOREIGN KEY (trustedapp_id)
      REFERENCES base.hmis_trusted_app (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);

CREATE TABLE base.hmis_user_permission_set_acl
(
  id uuid NOT NULL,
  user_id uuid,
  permission_set_id uuid,
  profile_id uuid,
  role_id uuid,
  created_at timestamp,
  created_by character varying(256),
  modified_at timestamp,
  modified_by character varying(256),
  CONSTRAINT "PK_USER_PERMISSION_SET_ACL" PRIMARY KEY (id),
  CONSTRAINT "FK_UPSA_PERMISSION_SET_ID" FOREIGN KEY (permission_set_id)
      REFERENCES base.hmis_permission_set (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "FK_UPSA_PROFILE_ID" FOREIGN KEY (profile_id)
      REFERENCES base.hmis_profile (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "FK_UPSA_ROLE_ID" FOREIGN KEY (role_id)
      REFERENCES base.hmis_role (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "FK_UPSA_USER_ID" FOREIGN KEY (user_id)
      REFERENCES base.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);


CREATE TABLE base.hmis_user_role_map
(
  id uuid NOT NULL,
  user_id uuid,
  role_id uuid,
  created_at timestamp,
  created_by character varying(256),
  modified_at timestamp,
  modified_by character varying(256),
  CONSTRAINT "PK_USER_ROLE_MAP" PRIMARY KEY (id),
  CONSTRAINT "FK_UR_ROLE_ID" FOREIGN KEY (role_id)
      REFERENCES base.hmis_role (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "FK_UR_USER_ID" FOREIGN KEY (user_id)
      REFERENCES base.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);

CREATE TABLE base.hmis_project_group
(
   id uuid, 
   project_group_name character varying(32), 
   project_group_desc character varying(256),
   project_group_code character varying(8),
   is_project_group_in_hive boolean,
   skip_user_identifers boolean default false,
   INSERT_AT timestamp without time zone, 
   INSERT_BY character varying(32), 
   UPDATE_AT timestamp without time zone, 
   UPDATE_BY character varying(32), 
   CONSTRAINT pk_hmis_project_group PRIMARY KEY (id)
) 
WITH (
  OIDS = FALSE
);


CREATE TABLE base.hmis_property
(
  id uuid NOT NULL,
  service character varying(64),
  key_name character varying(256),
  value character varying(256),
  created_at timestamp without time zone,
  modified_at timestamp without time zone,
  created_by character varying(256),
  modified_by character varying(256),
  CONSTRAINT "PK_HMIS_PROPERTY" PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);

-- DROP TABLE "base"."client";
CREATE TABLE "base".client
(
  "id" uuid NOT NULL,
  "dedup_client_id" uuid,
  "first_name" character(50),
  "middle_name" character(50),
  "last_name" character(50),
  "name_suffix" character(50),
  "name_data_quality" "base".name_data_quality,
   "ssn" character(9),
  "ssn_data_quality" "base".ssn_data_quality,
  "dob" timestamp,
  "dob_data_quality" "base".dob_data_quality,
  "gender" "base".gender,
  "other_gender" character(10),
  "ethnicity" "base".ethnicity,
  "race"  "base".race,
  "veteran_status" "base".veteran_status,
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
  CONSTRAINT client_pk PRIMARY KEY ("id")
      )
WITH (
  OIDS=FALSE
);
-- Table: "base"."client"

CREATE TABLE base.bulk_upload
(
  id bigint NOT NULL,
  inputPath text,
  status character(10),
  description text,
  year bigint,
  size bigint,
  export_id uuid,
  "project_group_code" character varying(8),
  "date_created" timestamp,
  "date_created_from_source" timestamp,
  "date_updated_from_source" timestamp,
  "date_updated" timestamp,
  "user_id" uuid,
  parent_id uuid,
  version integer,
  deleted boolean DEFAULT false, 
  sync boolean DEFAULT false,
  CONSTRAINT bulk_upload_pk PRIMARY KEY (id),
   CONSTRAINT "FK_BULK_UPLOAD_USERID" FOREIGN KEY (user_id)
      REFERENCES base.hmis_user (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);


ALTER TABLE base.hmis_user ADD COLUMN created_by character varying(256);
ALTER TABLE base.hmis_user ADD COLUMN modified_by character varying(256);
ALTER TABLE base.hmis_user ADD COLUMN organization_id uuid;
ALTER TABLE base.hmis_user ADD COLUMN password character varying(256);
ALTER TABLE base.hmis_user ADD COLUMN profile_id uuid;
ALTER TABLE base.hmis_user ADD COLUMN email_address character varying(266);
ALTER TABLE base.hmis_user ADD COLUMN status character varying(266);
ALTER TABLE base.hmis_user ADD COLUMN username character varying(256);
ALTER TABLE base.hmis_user ADD COLUMN verification_id uuid;
ALTER TABLE base.hmis_user ADD COLUMN project_group_id uuid;
ALTER TABLE base.hmis_user ADD COLUMN authenticator_secret character varying(16);
ALTER TABLE base.hmis_user ADD COLUMN two_factor_authentication boolean;


ALTER TABLE  base.hmis_user ADD CONSTRAINT  "FK_USER_ORGANIZATION_ID" FOREIGN KEY (organization_id) REFERENCES base.hmis_organization (id) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE  base.hmis_user ADD CONSTRAINT "FK_USER_PROFILE_ID" FOREIGN KEY (profile_id) REFERENCES base.hmis_profile (id) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE  base.hmis_user ADD CONSTRAINT "FK_USER_VERIFICATION_ID" FOREIGN KEY (verification_id) REFERENCES base.hmis_verification (id) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE  base.hmis_user ADD CONSTRAINT "FK_USER_PROJECT_GROUP_ID" FOREIGN KEY (project_group_id) REFERENCES base.hmis_project_group (id) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION;
update base.hmis_user set two_factor_authentication =false;

INSERT INTO base.hmis_project_group(
            id, project_group_name, project_group_desc, project_group_code,is_project_group_in_hive,
            INSERT_AT, INSERT_BY, UPDATE_AT, UPDATE_BY)
    VALUES (
'ed938948-b73e-4868-940d-371c5bd2d3f8','PROJECT_GROUP_NAME','PROJECT_GROUP_DESCRIPTION','PG0001',false,'2015-12-10 00:00:00','MASTER_DATA','2015-12-10 00:00:00','MASTER_DATA');

INSERT INTO base.hmis_user(
            id, first_name, middle_name, last_name, name_suffix, ssn, dob, 
            gender, date_created, date_updated, created_by, modified_by, 
             password, email_address, status, 
            username, project_group_id,two_factor_authentication)
    VALUES 
('2be4334a-ba97-4e12-a695-991752ca0391','Super Admin','Super Admin','Super Admin','Super Admin','','2015-12-10 00:00:00',
'1','2015-12-10 00:00:00','2015-12-10 00:00:00','MASTER DATA','MASTER DATA',
'XohImNooBHFR0OVvjcYpJ3NgPQ1qq73WKhHvch0VQtg=','superadmin@hmis.com','ACTIVE','admin','ed938948-b73e-4868-940d-371c5bd2d3f8',false);