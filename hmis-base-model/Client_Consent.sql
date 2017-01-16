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
  modified_by character varying(255)
)
WITH (
  OIDS=FALSE
);

DROP TABLE base.client_consent_entities;

CREATE TABLE base.client_consent_entities
(
  id uuid NOT NULL,
  client_consent_id uuid,
  consent_type_id uuid,
  consent_entity_id uuid,
  deleted boolean DEFAULT false,
  created_at date,
  created_by character varying(255),
  modified_at date,
  modified_by character varying(255)
)
WITH (
  OIDS=FALSE
);


 DROP TABLE base.consent_type;

CREATE TABLE base.consent_type
(
  id uuid NOT NULL,
  consent_type character varying(255),
  consent_type_desc character varying(255),
  consent_type_entity character varying(255),
  deleted boolean DEFAULT false,
  created_at date,
  created_by character varying(255),
  modified_at date,
  modified_by character varying(255),
  CONSTRAINT consent_type_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
