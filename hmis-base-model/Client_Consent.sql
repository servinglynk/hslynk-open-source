DROP TABLE base.client_consent;

CREATE TABLE base.client_consent
(
  id uuid NOT NULL,
  client_id uuid,
  start_time timestamp without time zone,
  end_time timestamp without time zone,
  status character varying(255),
  consent_document character varying(255),
  deleted boolean DEFAULT false,
  created_at date,
  created_by character varying(255),
  modified_at date,
  modified_by character varying(255),
  project_group_code character varying(16),
  parent_id uuid,
  entity_group character varying(256),
  user_id uuid,
  consent_project_group character varying(256),
  consent_user_id uuid,
  CONSTRAINT "PK_client_consent" PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);


CREATE TABLE base.client_consent_request
(
  id uuid NOT NULL,
  client_id uuid,
  start_time timestamp without time zone,
  end_time timestamp without time zone,
  status character varying(255),
  consent_document character varying(255),
  deleted boolean DEFAULT false,
  created_at date,
  created_by character varying(255),
  modified_at date,
  modified_by character varying(255),
  project_group_code character varying(16),
  parent_id uuid,
  entity_group character varying(256),
  user_id uuid,
  consent_project_group character varying(256),
  consent_user_id uuid,
  CONSTRAINT "PK_client_consent_request" PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);

ALTER TABLE base.hmis_api_method
  ADD COLUMN client_consent_required boolean DEFAULT false;
ALTER TABLE base.hmis_api_method
  ADD COLUMN client_consent_group character varying(256);