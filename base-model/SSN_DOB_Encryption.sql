 CREATE EXTENSION pgcrypto;
 
 CREATE OR REPLACE FUNCTION dob_decrypt(bytea)
  RETURNS bytea AS
$BODY$
SELECT decrypt($1, '02459710b84811e6bdda06c37be0e663','AES')
$BODY$
  LANGUAGE sql VOLATILE
  COST 100;
  
  
  CREATE OR REPLACE FUNCTION dob_encrypt(character varying)
  RETURNS bytea AS
$BODY$
SELECT encrypt(decode($1,'escape'), decode('02459710b84811e6bdda06c37be0e663','escape'),'AES')
$BODY$
  LANGUAGE sql VOLATILE
  COST 100;
  
  
  CREATE OR REPLACE FUNCTION ssn_decrypt(bytea)
  RETURNS bytea AS
$BODY$
SELECT decrypt($1, 'ae34e355ed1d4eacad5f9cbc28abef50','AES')
$BODY$
  LANGUAGE sql VOLATILE
  COST 100;
  
  
CREATE OR REPLACE FUNCTION ssn_encrypt(character varying)
  RETURNS bytea AS
$BODY$
SELECT encrypt(decode($1,'escape'), decode('ae34e355ed1d4eacad5f9cbc28abef50','escape'),'AES')
$BODY$
  LANGUAGE sql VOLATILE
  COST 100;
  

ALTER TABLE base.client RENAME dob  TO dob_old;
ALTER TABLE base.client RENAME ssn  TO ssn_old;
ALTER TABLE base.client ADD COLUMN dob bytea;
ALTER TABLE base.client ADD COLUMN ssn bytea;

ALTER TABLE v2014.client RENAME dob  TO dob_old;
ALTER TABLE v2014.client RENAME ssn  TO ssn_old;
ALTER TABLE v2014.client ADD COLUMN dob bytea;
ALTER TABLE v2014.client ADD COLUMN ssn bytea;

ALTER TABLE v2015.client RENAME dob  TO dob_old;
ALTER TABLE v2015.client RENAME ssn  TO ssn_old;
ALTER TABLE v2015.client ADD COLUMN dob bytea;
ALTER TABLE v2015.client ADD COLUMN ssn bytea;

ALTER TABLE v2016.client RENAME dob  TO dob_old;
ALTER TABLE v2016.client RENAME ssn  TO ssn_old;
ALTER TABLE v2016.client ADD COLUMN dob bytea;
ALTER TABLE v2016.client ADD COLUMN ssn bytea;


UPDATE base.client SET dob = dob_encrypt(to_char(dob_old, 'YYYY-mm-dd HH12:MI:SS'));
UPDATE base.client SET ssn = ssn_encrypt(ssn_old);

UPDATE v2014.client SET dob = dob_encrypt(to_char(dob_old, 'YYYY-mm-dd HH12:MI:SS'));
UPDATE v2014.client SET ssn = ssn_encrypt(ssn_old);

UPDATE v2015.client SET dob = dob_encrypt(to_char(dob_old, 'YYYY-mm-dd HH12:MI:SS'));
UPDATE v2015.client SET ssn = ssn_encrypt(ssn_old);

UPDATE v2016.client SET dob = dob_encrypt(to_char(dob_old, 'YYYY-mm-dd HH12:MI:SS'));
UPDATE v2016.client SET ssn = ssn_encrypt(ssn_old);