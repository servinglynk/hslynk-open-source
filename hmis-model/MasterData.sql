truncate live.hmis_user cascade;
truncate live.hmis_profile_acl cascade;
truncate live.hmis_profile cascade;
truncate live.organization cascade;
truncate live.hmis_project_group cascade;
truncate live.hmis_project_projectgroup_map cascade;
truncate live.hmis_trusted_app cascade;
truncate live.hmis_role cascade;
INSERT INTO live.hmis_profile( id, profile_name, profile_description, created_at, created_by)  VALUES ('b67c38a1-2762-4393-b69b-41a0a11e6efc', 'Super Admin Profile', 'Super Admin Profile', current_date, 'MASTER DATA');
INSERT INTO live.organization( organizationcommonname, id, organizationname, date_created ) VALUES ('Project Group Organization', '3551c2f2-7909-4129-9243-6c0195dcbb74', 'Project Group Organization',current_date);
INSERT INTO live.project( id,  organizationid, projectcommonname, projectname,  date_created)  VALUES ('0dda7333-0592-4fa7-ba79-1fe2dfaaff4e', '3551c2f2-7909-4129-9243-6c0195dcbb74', 'Project_1451380098841','Project_1451380098841', current_date);
INSERT INTO live.project( id,  organizationid, projectcommonname, projectname,  date_created)  VALUES ('6a55ba6c-9577-403a-8647-57f0c3456e01', '3551c2f2-7909-4129-9243-6c0195dcbb74', 'Project_1451380098905','Project_1451380098905', current_date);
INSERT INTO live.hmis_project_group( id, project_group_name, project_group_desc, project_group_code, INSERT_AT, INSERT_BY) values ( '9b9792ca-8730-4d21-9a39-6902229fd4b9','PROJECT_GROUP_NAME','PROJECT_GROUP_DESCRIPTION','PG0001', current_date,'MASTER_DATA');
INSERT INTO live.hmis_project_projectgroup_map( id, project_id, project_group_id, insert_at, insert_by) values  ( 'eb101a53-03e1-4647-a9b3-b6439b1f7a72','0dda7333-0592-4fa7-ba79-1fe2dfaaff4e','9b9792ca-8730-4d21-9a39-6902229fd4b9', current_date,'MASTER_DATA');
INSERT INTO live.hmis_project_projectgroup_map( id, project_id, project_group_id, insert_at, insert_by) values  ( '75bfada0-bca3-4e3a-96a8-ff1bdb1ae5d0','6a55ba6c-9577-403a-8647-57f0c3456e01','9b9792ca-8730-4d21-9a39-6902229fd4b9', current_date,'MASTER_DATA');
INSERT INTO live.organization( organizationcommonname, id, organizationname, date_created ) VALUES ('Developer Organization', 'b5598c6c-d021-4f5f-9695-77f7f4685ed2', 'Developer Organization',current_date);
INSERT INTO live.hmis_user( id, first_name, middle_name, last_name, name_suffix, ssn, dob,  date_created,  created_by, password, profile_id, status, username,organization_id,project_group_id,two_factor_authentication,email_address) VALUES ('8b6c6ef2-87c7-47f0-8874-4cca6f09365c', 'Super Admin','Super Admin', 'Super Admin', 'Super Admin', '', current_date,current_date , 'MASTER DATA',  'XohImNooBHFR0OVvjcYpJ3NgPQ1qq73WKhHvch0VQtg=', 'b67c38a1-2762-4393-b69b-41a0a11e6efc', 'ACTIVE', 'superadmin@hmis.com','b5598c6c-d021-4f5f-9695-77f7f4685ed2','9b9792ca-8730-4d21-9a39-6902229fd4b9',false,'hmisprojects@gmail.com');
INSERT INTO live.hmis_trusted_app( id, friendly_name, external_id, description, status, created_at, created_by, expiration_time)  VALUES ('f9091e61-d617-4923-b50a-9e9bd405e313','MASTER_TRUSTED_APP', 'MASTER_TRUSTED_APP', 'MASTER_TRUSTED_APP','ACTIVE', current_date, 'MASTER DATA',  2000);
INSERT INTO live.organization( organizationcommonname, id, organizationname, date_created ) VALUES ('Organization 1', 'ad1dba89-7ed1-4f16-a81a-d1ed4446fe07', 'Organization 1',current_date);
INSERT INTO live.project( id,  organizationid, projectcommonname, projectname,  date_created)  VALUES ('b2658cb5-e748-401c-8318-d68bd27a9eff', 'ad1dba89-7ed1-4f16-a81a-d1ed4446fe07', 'Project_1451380099605','Project_1451380099606', current_date);
INSERT INTO live.enrollment( id, entrydate,  projectid, date_created) VALUES ('855d4695-d54f-4734-93f5-0568fee0c714',current_date, 'b2658cb5-e748-401c-8318-d68bd27a9eff',current_date);
INSERT INTO live.enrollment( id, entrydate,  projectid, date_created) VALUES ('ad5f5b6b-ad94-4ba7-835d-9e602f081c8c',current_date, 'b2658cb5-e748-401c-8318-d68bd27a9eff',current_date);
INSERT INTO live.enrollment( id, entrydate,  projectid, date_created) VALUES ('aa559202-afd2-4dee-9333-3b144eb47e71',current_date, 'b2658cb5-e748-401c-8318-d68bd27a9eff',current_date);
INSERT INTO live.enrollment( id, entrydate,  projectid, date_created) VALUES ('fdc7505f-cd42-4abe-829b-9197685fcba3',current_date, 'b2658cb5-e748-401c-8318-d68bd27a9eff',current_date);
INSERT INTO live.project( id,  organizationid, projectcommonname, projectname,  date_created)  VALUES ('68fe1db9-02c9-4886-a106-fdb602d12291', 'ad1dba89-7ed1-4f16-a81a-d1ed4446fe07', 'Project_1451380099918','Project_1451380099918', current_date);
INSERT INTO live.organization( organizationcommonname, id, organizationname, date_created ) VALUES ('Organization 2', '68a7ba41-48a3-4f25-a43f-6d2a9e01874a', 'Organization 2',current_date);
INSERT INTO live.project( id,  organizationid, projectcommonname, projectname,  date_created)  VALUES ('2b14f416-871b-4fd4-b20b-ab9f81c2e4bd', '68a7ba41-48a3-4f25-a43f-6d2a9e01874a', 'Project_1451380100046','Project_1451380100046', current_date);
INSERT INTO live.project( id,  organizationid, projectcommonname, projectname,  date_created)  VALUES ('1ebd9476-600c-463f-8c3d-bf8accad472b', '68a7ba41-48a3-4f25-a43f-6d2a9e01874a', 'Project_1451380100105','Project_1451380100105', current_date);
INSERT INTO live.hmis_role(id, role_name, role_description, created_at,created_by) VALUES ('1ebd9476-600c-463f-8c3d-bf8accad472b', 'DEVELOPER', 'Developer Role', current_date, 'MASTER_DATA');
INSERT INTO live.hmis_profile( id, profile_name, profile_description, created_at, created_by)  VALUES ('1ebd9476-600c-463f-8c3d-bf8accad472b', 'Developer Profile', 'Developer Profile', current_date, 'MASTER DATA');
INSERT INTO live.hmis_project_group( id, project_group_name, project_group_desc, project_group_code, INSERT_AT, INSERT_BY) values ( '1ebd9476-600c-463f-8c3d-bf8accad472b','DEVELOPER_PROJECT_GROUP','DEVELOPER_PROJECT_GROUP','DG0001', current_date,'MASTER_DATA');


CREATE OR REPLACE FUNCTION live.createSuperAdminProfileAcl() RETURNS SETOF live.hmis_api_method AS
$BODY$
DECLARE
    r live.hmis_api_method%rowtype;
BEGIN
    FOR r IN SELECT * FROM live.hmis_api_method
  
    LOOP
    RAISE NOTICE '%',r.id;
        INSERT INTO live.hmis_profile_acl(profile_id, api_method_id, id, created_at, created_by) VALUES ('b67c38a1-2762-4393-b69b-41a0a11e6efc', r.id, r.id, current_timestamp, 'MASTER_DATA');
    END LOOP;
    RETURN;
END
$BODY$
LANGUAGE 'plpgsql' ;

select * from live.createSuperAdminProfileAcl();