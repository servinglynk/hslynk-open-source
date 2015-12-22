DROP SEQUENCE IF EXISTS hmis_notification_header_id_seq;
DROP SEQUENCE IF EXISTS hmis_notification_line_id_seq;
DROP SEQUENCE IF EXISTS hmis_report_header_id_seq;
DROP SEQUENCE IF EXISTS hmis_report_line_id_seq;
DROP SEQUENCE IF EXISTS hmis_report_recipient_id_seq;
DROP SEQUENCE IF EXISTS hmis_template_header_id_seq;
DROP SEQUENCE IF EXISTS hmis_template_line_id_seq;
DROP SEQUENCE IF EXISTS hmis_worker_header_id_seq;
DROP SEQUENCE IF EXISTS hmis_worker_line_id_seq;
DROP SEQUENCE IF EXISTS hmis_notification_param_seq;


DROP TABLE IF EXISTS hmis_notification_header;
DROP TABLE IF EXISTS hmis_notification_line;
DROP TABLE IF EXISTS hmis_notification_param;
DROP TABLE IF EXISTS hmis_report_header;
DROP TABLE IF EXISTS hmis_report_line;
DROP TABLE IF EXISTS hmis_report_recipient;
DROP TABLE IF EXISTS hmis_template_header;
DROP TABLE IF EXISTS hmis_template_line;
DROP TABLE IF EXISTS hmis_worker_header;
DROP TABLE IF EXISTS hmis_worker_line;


CREATE SEQUENCE hmis_notification_header_id_seq;
CREATE SEQUENCE hmis_notification_line_id_seq;
CREATE SEQUENCE hmis_report_header_id_seq;
CREATE SEQUENCE hmis_report_line_id_seq;
CREATE SEQUENCE hmis_report_recipient_id_seq;
CREATE SEQUENCE hmis_template_header_id_seq;
CREATE SEQUENCE hmis_template_line_id_seq;
CREATE SEQUENCE hmis_worker_header_id_seq;
CREATE SEQUENCE hmis_worker_line_id_seq;
CREATE SEQUENCE hmis_notification_param_seq;


CREATE TABLE hmis_notification_header
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


CREATE TABLE hmis_notification_line
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
      REFERENCES hmis_notification_header (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);


CREATE TABLE hmis_notification_param
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


CREATE TABLE hmis_report_header
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

CREATE TABLE hmis_report_line
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
      REFERENCES hmis_report_header (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);

CREATE TABLE hmis_report_recipient
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
      REFERENCES hmis_report_header (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);

CREATE TABLE hmis_template_header
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

CREATE TABLE hmis_template_line
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
      REFERENCES hmis_template_header (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);


CREATE TABLE hmis_worker_header
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


CREATE TABLE hmis_worker_line
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
      REFERENCES hmis_worker_header (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);


CREATE TABLE "HMIS_PROPERTY"
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