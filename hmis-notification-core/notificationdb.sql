DROP SCHEMA IF EXISTS "notificationdb" cascade;
CREATE SCHEMA "notificationdb";

DROP TABLE IF EXISTS "notificationdb".hmis_notification_header;
DROP TABLE IF EXISTS "notificationdb".hmis_notification_line;
DROP TABLE IF EXISTS "notificationdb".hmis_notification_param;
DROP TABLE IF EXISTS "notificationdb".hmis_report_header;
DROP TABLE IF EXISTS "notificationdb".hmis_report_line;
DROP TABLE IF EXISTS "notificationdb".hmis_report_recipient;
DROP TABLE IF EXISTS "notificationdb".hmis_template_header;
DROP TABLE IF EXISTS "notificationdb".hmis_template_line;
DROP TABLE IF EXISTS "notificationdb".hmis_worker_header;
DROP TABLE IF EXISTS "notificationdb".hmis_worker_line;


CREATE TABLE "notificationdb".hmis_notification_header
(
  id bigint NOT NULL,
  status_message character varying(256),
  originator_id character varying(256),
  originator_type character varying(256),
  sender character varying(256),
  sender_friendly character varying(256),
  external_id character varying(256),
  notification_data character varying(256),
  status character varying(256),
  insert_at date,
  insert_by character varying(256),
  update_at date,
  update_by character varying(256),
  CONSTRAINT hmis_notification_header_pk PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);


CREATE TABLE "notificationdb".hmis_notification_line
(
  id bigint NOT NULL,
  attempts integer,
  deliver_to character varying(256),
  delivery_method character varying(256),
  sent_at date,
  status_message character varying(256),
  status character varying(256),
  template_id integer,
  carrier_attempts integer,
  external_id character varying(256),
  insert_by character varying(256),
  update_by character varying(256),
  insert_at date,
  update_at date,
  carrier character varying(256),
  carrier_confirmation character varying(256),
  notification_header_id bigint,
  username character varying(256),
  template_version integer,
  CONSTRAINT hmis_notification_line_pk PRIMARY KEY (id),
  CONSTRAINT hmis_notification_line_fk FOREIGN KEY (notification_header_id)
      REFERENCES "notificationdb".hmis_notification_header (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);


CREATE TABLE "notificationdb".hmis_notification_param
(
  id integer NOT NULL,
  sender_email_address character varying(250) DEFAULT NULL::character varying,
  sender_friendly_name character varying(250) DEFAULT NULL::character varying,
  external_id character varying(250) DEFAULT NULL::character varying,
  insert_at date,
  insert_by character varying(250) DEFAULT NULL::character varying,
  update_at date,
  update_by character varying(250) DEFAULT NULL::character varying,
  template_id character varying(256),
  CONSTRAINT "HMIS_NOTIFICATION_PARAM_PK" PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);


CREATE TABLE "notificationdb".hmis_report_header
(
  id bigint NOT NULL,
  friendly_name character varying(150) DEFAULT NULL::character varying,
  external_id character varying(100) DEFAULT NULL::character varying,
  report_template character varying(100) DEFAULT NULL::character varying,
  version bigint,
  name character varying(100) DEFAULT NULL::character varying,
  insert_at date,
  insert_by character varying(100) DEFAULT NULL::character varying,
  update_at date,
  update_by character varying(100) DEFAULT NULL::character varying,
  report_location character varying(256) DEFAULT NULL::character varying,
  report_name_prefix character varying(256) DEFAULT NULL::character varying,
  temp_location character varying(200),
  output_type character varying(200),
  macro_template character varying(200),
  CONSTRAINT hmis_report_header_pk PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);

CREATE TABLE "notificationdb".hmis_report_line
(
  id bigint NOT NULL,
  report_header_id bigint,
  request_time timestamp without time zone,
  completed_time timestamp without time zone,
  report_location character varying(100) DEFAULT NULL::character varying,
  external_id character varying(50) DEFAULT NULL::character varying,
  status character varying(20) DEFAULT NULL::character varying,
  insert_at date,
  insert_by character varying(50) DEFAULT NULL::character varying,
  update_at date,
  update_by character varying(50) DEFAULT NULL::character varying,
  status_message character varying(200),
  CONSTRAINT hmis_report_line_pk PRIMARY KEY (id),
  CONSTRAINT hmis_report_line_fk FOREIGN KEY (report_header_id)
      REFERENCES "notificationdb".hmis_report_header (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);

CREATE TABLE "notificationdb".hmis_report_recipient
(
  id bigint NOT NULL,
  report_header_id bigint,
  external_id character varying(50) DEFAULT NULL::character varying,
  recipient_email character varying(500) DEFAULT NULL::character varying,
  insert_at date NOT NULL,
  insert_by character varying(50) DEFAULT NULL::character varying,
  update_at date NOT NULL,
  update_by character varying(50) DEFAULT NULL::character varying,
  CONSTRAINT hmis_report_recipient_pk PRIMARY KEY (id),
  CONSTRAINT hmis_report_recipient_fk FOREIGN KEY (report_header_id)
      REFERENCES "notificationdb".hmis_report_header (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);

CREATE TABLE "notificationdb".hmis_template_header
(
  id bigint NOT NULL,
  friendly_name character varying(256),
  external_id character varying(256),
  insert_by character varying(256),
  update_by character varying(256),
  update_at date,
  insert_at date,
  CONSTRAINT hmis_template_header_pk PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);

CREATE TABLE "notificationdb".hmis_template_line
(
  id bigint NOT NULL,
  template_header_id bigint,
  version character varying(256),
  body_location character varying(255),
  insert_by character varying(256),
  update_by character varying(256),
  update_at date,
  insert_at date,
  external_id character varying(256),
  subject character varying(256),
  CONSTRAINT hmis_template_line_pk PRIMARY KEY (id),
  CONSTRAINT template_header_id_fk FOREIGN KEY (template_header_id)
      REFERENCES "notificationdb".hmis_template_header (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);


CREATE TABLE "notificationdb".hmis_worker_header
(
  external_id character varying(256),
  description character varying(256),
  max_retry integer,
  retry_interval integer,
  status character varying(256),
  insert_at date,
  insert_by integer,
  update_at date,
  update_by integer,
  id bigint NOT NULL,
  CONSTRAINT "HMIS_WORKER_HEADER_PK" PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);


CREATE TABLE "notificationdb".hmis_worker_line
(
  external_id character varying(256),
  line_input character varying(2000),
  line_output character varying(2000),
  status character varying(256),
  max_retry integer,
  curr_retry integer,
  retry_interval integer,
  worker_header_id integer,
  insert_at date,
  update_at date,
  insert_by character varying(256),
  update_by character varying(256),
  id integer NOT NULL,
  CONSTRAINT "HMIS_WORKER_LINE_PK" PRIMARY KEY (id),
  CONSTRAINT worker_header_id_fk FOREIGN KEY (worker_header_id)
      REFERENCES "notificationdb".hmis_worker_header (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);


CREATE TABLE "notificationdb".HMIS_PROPERTY
(
   id integer, 
   SERVICE character varying(16), 
   KEY_NAME character varying(52), 
   KEY_VALUE character varying(56),
   insert_at date,
   update_at date,
   insert_by character varying(256),
   update_by character varying(256),
   CONSTRAINT "HMIS_PROPERTY_PK" PRIMARY KEY (id)
) 
WITH (
  OIDS = FALSE
);


INSERT INTO "notificationdb".hmis_notification_param (id, sender_email_address, sender_friendly_name, external_id, insert_at, insert_by, update_at, update_by, template_id) VALUES (1, 'hmsiprojects@gmail.com', 'HMIS_RESOURCE_CREATION', 'HMIS_RESOURCE_CREATION', NULL, NULL, NULL, NULL, 'HMIS_RESOURCE_CREATION');
INSERT INTO "notificationdb".hmis_notification_param (id, sender_email_address, sender_friendly_name, external_id, insert_at, insert_by, update_at, update_by, template_id) VALUES (2, 'hmisprojects@gmail.com', 'HMIS_DEVELOPER_COMPANY_CREATION', 'HMIS_DEVELOPER_COMPANY_CREATION', NULL, NULL, NULL, NULL, 'HMIS_DEVELOPER_COMPANY_CREATION');
INSERT INTO "notificationdb".hmis_notification_param (id, sender_email_address, sender_friendly_name, external_id, insert_at, insert_by, update_at, update_by, template_id) VALUES (3, 'hmisprojects@gmail.com', 'HMIS_TRUSTEDAPP_CREATION', 'HMIS_TRUSTEDAPP_CREATION', NULL, NULL, NULL, NULL, 'HMIS_TRUSTEDAPP_CREATION');
INSERT INTO "notificationdb".hmis_notification_param (id, sender_email_address, sender_friendly_name, external_id, insert_at, insert_by, update_at, update_by, template_id) VALUES (4, 'hmisprojects@gmail.com', 'HMIS_DEVELOPER_SERVICE_CREATION', 'HMIS_DEVELOPER_SERVICE_CREATION', NULL, NULL, NULL, NULL, 'HMIS_DEVELOPER_SERVICE_CREATION');
INSERT INTO "notificationdb".hmis_notification_param (id, sender_email_address, sender_friendly_name, external_id, insert_at, insert_by, update_at, update_by, template_id) VALUES (5, 'hmisprojects@gmail.com', 'DEV_COMPANY_SETUP_RESOURCE_CREATION', 'DEV_COMPANY_SETUP_RESOURCE_CREATION', NULL, NULL, NULL, NULL, 'DEV_COMPANY_SETUP_RESOURCE_CREATION');
INSERT INTO "notificationdb".hmis_notification_param (id, sender_email_address, sender_friendly_name, external_id, insert_at, insert_by, update_at, update_by, template_id) VALUES (6, 'hmisprojects@gmail.com', 'TRUSTEDAPP_STATUS_UPDATE', 'TRUSTEDAPP_STATUS_UPDATE', NULL, NULL, NULL, NULL, 'TRUSTEDAPP_STATUS_UPDATE');
INSERT INTO "notificationdb".hmis_notification_param (id, sender_email_address, sender_friendly_name, external_id, insert_at, insert_by, update_at, update_by, template_id) VALUES (7, 'hmisprojects@gmail.com', 'DEVELOPER_SERVICE_STATUS_UPDATE', 'DEVELOPER_SERVICE_STATUS_UPDATE', NULL, NULL, NULL, NULL, 'DEVELOPER_SERVICE_STATUS_UPDATE');
INSERT INTO "notificationdb".hmis_notification_param (id, sender_email_address, sender_friendly_name, external_id, insert_at, insert_by, update_at, update_by, template_id) VALUES (8, 'hmisprojects@gmail.com', 'DEVELOPER_COMPANY_STATUS_UPDATE', 'DEVELOPER_COMPANY_STATUS_UPDATE', NULL, NULL, NULL, NULL, 'DEVELOPER_COMPANY_STATUS_UPDATE');

INSERT INTO "notificationdb".hmis_property (id, service, key_name, key_value, insert_at, update_at, insert_by, update_by) VALUES (6, 'common', 'notification.template.location', 'D:\\\\notification-templates', '2015-11-24', '2015-12-14', NULL, NULL);
INSERT INTO "notificationdb".hmis_property (id, service, key_name, key_value, insert_at, update_at, insert_by, update_by) VALUES (3, 'common', 'notification.mail.username', 'hmis.projects@gmail.com', '2015-11-24', '2015-12-14', NULL, NULL);
INSERT INTO "notificationdb".hmis_property (id, service, key_name, key_value, insert_at, update_at, insert_by, update_by) VALUES (4, 'common', 'notification.mail.password', 'satyaX0109', '2015-11-25', '2015-12-14', NULL, NULL);
INSERT INTO "notificationdb".hmis_property (id, service, key_name, key_value, insert_at, update_at, insert_by, update_by) VALUES (1, 'common', 'notification.mail.host', 'smtp.gmail.com', '2015-12-14', '2015-12-14', NULL, NULL);
INSERT INTO "notificationdb".hmis_property (id, service, key_name, key_value, insert_at, update_at, insert_by, update_by) VALUES (2, 'common', 'notification.mail.port', '587', '2015-11-25', '2015-12-14', NULL, NULL);
INSERT INTO "notificationdb".hmis_property (id, service, key_name, key_value, insert_at, update_at, insert_by, update_by) VALUES (5, 'common', 'notification.mail.sender', 'hmis.projects@gmail.com', '2015-11-25', '2015-12-14', NULL, NULL);


INSERT INTO "notificationdb".hmis_template_header (id, friendly_name, external_id, insert_by, update_by, update_at, insert_at) VALUES (1, 'HMIS_DEVELOPER_COMPANY_CREATION', 'HMIS_DEVELOPER_COMPANY_CREATION', NULL, NULL, NULL, NULL);
INSERT INTO "notificationdb".hmis_template_header (id, friendly_name, external_id, insert_by, update_by, update_at, insert_at) VALUES (2, 'HMIS_TRUSTEDAPP_CREATION', 'HMIS_TRUSTEDAPP_CREATION', NULL, NULL, NULL, NULL);
INSERT INTO "notificationdb".hmis_template_header (id, friendly_name, external_id, insert_by, update_by, update_at, insert_at) VALUES (3, 'HMIS_DEVELOPER_SERVICE_CREATION', 'HMIS_DEVELOPER_SERVICE_CREATION', NULL, NULL, NULL, NULL);
INSERT INTO "notificationdb".hmis_template_header (id, friendly_name, external_id, insert_by, update_by, update_at, insert_at) VALUES (4, 'DEV_COMPANY_SETUP_RESOURCE_CREATION', 'DEV_COMPANY_SETUP_RESOURCE_CREATION', NULL, NULL, NULL, NULL);
INSERT INTO "notificationdb".hmis_template_header (id, friendly_name, external_id, insert_by, update_by, update_at, insert_at) VALUES (5, 'HMIS_RESOURCE_CREATION', 'HMIS_RESOURCE_CREATION', NULL, NULL, NULL, NULL);
INSERT INTO "notificationdb".hmis_template_header (id, friendly_name, external_id, insert_by, update_by, update_at, insert_at) VALUES (6, 'DEVELOPER_COMPANY_STATUS_UPDATE', 'DEVELOPER_COMPANY_STATUS_UPDATE', NULL, NULL, NULL, NULL);
INSERT INTO "notificationdb".hmis_template_header (id, friendly_name, external_id, insert_by, update_by, update_at, insert_at) VALUES (7, 'DEVELOPER_SERVICE_STATUS_UPDATE', 'DEVELOPER_SERVICE_STATUS_UPDATE', NULL, NULL, NULL, NULL);
INSERT INTO "notificationdb".hmis_template_header (id, friendly_name, external_id, insert_by, update_by, update_at, insert_at) VALUES (8, 'TRUSTEDAPP_STATUS_UPDATE', 'TRUSTEDAPP_STATUS_UPDATE', NULL, NULL, NULL, NULL);

INSERT INTO "notificationdb".hmis_template_line (id, template_header_id, version, body_location, insert_by, update_by, update_at, insert_at, external_id, subject) VALUES (1, 1, '1', 'developerCompanyCreation.vm', NULL, NULL, NULL, NULL, 'HMIS_DEVELOPER_COMPANY_CREATION', 'New Developer Company Created.');
INSERT INTO "notificationdb".hmis_template_line (id, template_header_id, version, body_location, insert_by, update_by, update_at, insert_at, external_id, subject) VALUES (2, 2, '1', 'trustedAppCreation.vm', NULL, NULL, NULL, NULL, 'HMIS_TRUSTEDAPP_CREATION', 'New Trusted App Created.');
INSERT INTO "notificationdb".hmis_template_line (id, template_header_id, version, body_location, insert_by, update_by, update_at, insert_at, external_id, subject) VALUES (3, 3, '1', 'developerServiceCreation.vm', NULL, NULL, NULL, NULL, 'HMIS_DEVELOPER_SERVICE_CREATION', 'New Developer Service Created.');
INSERT INTO "notificationdb".hmis_template_line (id, template_header_id, version, body_location, insert_by, update_by, update_at, insert_at, external_id, subject) VALUES (4, 4, '1', 'vt.hmis_dev_company_resource_creation.vm', NULL, NULL, NULL, NULL, 'DEV_COMPANY_SETUP_RESOURCE_CREATION', 'Welcome to HMIS Developer Platform !');
INSERT INTO "notificationdb".hmis_template_line (id, template_header_id, version, body_location, insert_by, update_by, update_at, insert_at, external_id, subject) VALUES (5, 5, '1', 'vt.hmis_resource_creation.vm', NULL, NULL, NULL, NULL, 'HMIS_RESOURCE_CREATION', 'Welcome to HMIS Platform !');
INSERT INTO "notificationdb".hmis_template_line (id, template_header_id, version, body_location, insert_by, update_by, update_at, insert_at, external_id, subject) VALUES (6, 6, '1', 'vt.developer_company_status_update.vm', NULL, NULL, NULL, NULL, 'DEVELOPER_COMPANY_STATUS_UPDATE', 'Developer Company Status Updation');
INSERT INTO "notificationdb".hmis_template_line (id, template_header_id, version, body_location, insert_by, update_by, update_at, insert_at, external_id, subject) VALUES (7, 7, '1', 'vt.developer_service_status_update.vm', NULL, NULL, NULL, NULL, 'DEVELOPER_SERVICE_STATUS_UPDATE', 'Developer Service Status Updation');
INSERT INTO "notificationdb".hmis_template_line (id, template_header_id, version, body_location, insert_by, update_by, update_at, insert_at, external_id, subject) VALUES (7, 7, '1', 'vt.trustedApp_status_update.vm', NULL, NULL, NULL, NULL, 'TRUSTEDAPP_STATUS_UPDATE', 'TrustedApp Status Updation');


INSERT INTO "notificationdb".hmis_worker_header (external_id, description, max_retry, retry_interval, status, insert_at, insert_by, update_at, update_by, id) VALUES ('NOTIFICATION_WORKER', 'NOTIFICATION_WORKER', 5, 5, 'ACTIVE', NULL, NULL, NULL, NULL, 1);
INSERT INTO "notificationdb".hmis_worker_header (external_id, description, max_retry, retry_interval, status, insert_at, insert_by, update_at, update_by, id) VALUES ('REPORT_WORKER', 'REPORT_WORKER', 5, 5, 'ACTIVE', NULL, NULL, NULL, NULL, 2);