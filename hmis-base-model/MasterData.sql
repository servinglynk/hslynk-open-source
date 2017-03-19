truncate base.hmis_user cascade;
truncate base.hmis_profile_acl cascade;
truncate base.hmis_profile cascade;
truncate base.organization cascade;
truncate base.hmis_project_group cascade;
truncate base.hmis_trusted_app cascade;
truncate base.hmis_role cascade;
INSERT INTO base.organization( organizationcommonname, id, organizationname, date_created, version ) VALUES ('Developer Organization', 'b5598c6c-d021-4f5f-9695-77f7f4685ed2', 'Developer Organization',current_date,0);
INSERT INTO base.organization( organizationcommonname, id, organizationname, date_created, version ) VALUES ('Servinglynk', 'ad1dba89-7ed1-4f16-a81a-d1ed4446fe07', 'Servinglynk',current_date,0);
INSERT INTO base.hmis_role(id, role_name,role_code, role_description, created_at,created_by) VALUES ('1ebd9476-600c-463f-8c3d-bf8accad472b', 'DEVELOPER','DEVELOPER', 'Developer Role', current_date, 'MASTER_DATA');
INSERT INTO base.hmis_role(id, role_name,role_code, role_description, created_at,created_by) VALUES ('b67c38a1-2762-4393-b69b-41a0a11e6efc', 'SUPERADMIN','SUPERADMIN', 'Super Admin Role', current_date, 'MASTER_DATA');
INSERT INTO base.hmis_role(id, role_name,role_code, role_description, created_at,created_by) VALUES ('b67c38a1-2762-4393-b69b-41a0a11e6efd', 'CUSTADMIN','CUSTADMIN', 'Customer Admin Role', current_date, 'MASTER_DATA');
INSERT INTO base.hmis_profile( id, profile_name, profile_description, created_at, created_by)  VALUES ('b67c38a1-2762-4393-b69b-41a0a11e6efc', 'Super Admin Profile', 'Super Admin Profile', current_date, 'MASTER DATA');
INSERT INTO base.hmis_profile( id, profile_name, profile_description, created_at, created_by)  VALUES ('1ebd9476-600c-463f-8c3d-bf8accad472b', 'Developer Profile', 'Developer Profile', current_date, 'MASTER DATA');
INSERT INTO base.hmis_project_group( id, project_group_name, project_group_desc, project_group_code, insert_at, insert_by) values ('9b9792ca-8730-4d21-9a39-6902229fd4b9','PROJECT_GROUP_NAME','PROJECT_GROUP_DESCRIPTION','PG0001', current_date,'MASTER_DATA');
INSERT INTO base.hmis_trusted_app( id, friendly_name, external_id, description, status, created_at, created_by, expiration_time, trustedapp_secret, auth_code_grant_supported)  VALUES ('f9091e61-d617-4923-b50a-9e9bd405e313','MASTER_TRUSTED_APP', 'MASTER_TRUSTED_APP', 'MASTER_TRUSTED_APP','ACTIVE', current_date, 'MASTER DATA',  20000, 'HMIS',true);
INSERT INTO base.hmis_user( id, first_name, middle_name, last_name, name_suffix, ssn, dob,  date_created,  created_by, password, profile_id, status, username,organization_id,project_group_id,two_factor_authentication,email_address) VALUES ('8b6c6ef2-87c7-47f0-8874-4cca6f09365c', 'Super Admin','Super Admin', 'Super Admin', 'Super Admin', '', current_date,current_date , 'MASTER DATA',  'XohImNooBHFR0OVvjcYpJ3NgPQ1qq73WKhHvch0VQtg=', 'b67c38a1-2762-4393-b69b-41a0a11e6efc', 'ACTIVE', 'superadmin@hmis.com','b5598c6c-d021-4f5f-9695-77f7f4685ed2','9b9792ca-8730-4d21-9a39-6902229fd4b9',false,'hmisprojects@gmail.com');
INSERT INTO base.hmis_user_role_map(id, user_id, role_id, created_at, created_by) VALUES ('75bfada0-bca3-4e3a-96a8-ff1bdb1ae5d0', '8b6c6ef2-87c7-47f0-8874-4cca6f09365c', 'b67c38a1-2762-4393-b69b-41a0a11e6efc', current_date,'MASTER_DATA');
INSERT INTO base.hmis_user( id, first_name, middle_name, last_name, name_suffix, ssn, dob,  date_created,  created_by, password, profile_id, status, username,organization_id,project_group_id,two_factor_authentication,email_address) VALUES ('8b6c6ef2-87c7-47f0-8874-4cca6f09367c', 'Developer Admin','Developer Admin', 'Developer Admin', 'Developer Admin', '', current_date,current_date , 'MASTER DATA',  'XohImNooBHFR0OVvjcYpJ3NgPQ1qq73WKhHvch0VQtg=', 'b67c38a1-2762-4393-b69b-41a0a11e6efc', 'ACTIVE', 'developeradmin@hmis.com','ad1dba89-7ed1-4f16-a81a-d1ed4446fe07','9b9792ca-8730-4d21-9a39-6902229fd4b9',false,'hmisprojects@gmail.com');
INSERT INTO base.hmis_user_role_map(id, user_id, role_id, created_at, created_by) VALUES ('8b6c6ef2-87c7-47f0-8874-4cca6f09367c', '8b6c6ef2-87c7-47f0-8874-4cca6f09367c', 'b67c38a1-2762-4393-b69b-41a0a11e6efc', current_date,'MASTER_DATA');

INSERT INTO base.hmis_redirect_uri(id, uri, trustedapp_id, created_at, created_by ) 
				VALUES ('2a0de2d3-ce1f-4cf1-9145-04aa70e3196c','http://localhost:8081/hmis-admin/#/admin/dashborad' , 'f9091e61-d617-4923-b50a-9e9bd405e313', current_date, 'MASTER DATA');

				
INSERT INTO base.hmis_profile( id, profile_name, profile_description, created_at, created_by)  VALUES ('004aed07-b4d4-4696-b8f6-1607f6f49bac', 'Standard Profile', 'Standard Profile', current_date, 'MASTER DATA');
INSERT INTO base.hmis_profile_acl(profile_id, api_method_id, id, created_at, created_by ) VALUES ('004aed07-b4d4-4696-b8f6-1607f6f49bac','039c55be-bf44-4e22-8a79-5ba861756c45' , '54b2ce51-acd8-4afc-9c8f-50c37a843f8b', current_date, 'MASTER DATA');
INSERT INTO base.hmis_profile_acl(profile_id, api_method_id, id, created_at, created_by ) VALUES ('004aed07-b4d4-4696-b8f6-1607f6f49bac','3336586d-5034-41fc-a32c-9aab26873dd3' , '5fd85889-aa2e-4c2a-a4e2-9dc927485230', current_date, 'MASTER DATA');
INSERT INTO base.hmis_profile_acl(profile_id, api_method_id, id, created_at, created_by ) VALUES ('004aed07-b4d4-4696-b8f6-1607f6f49bac','29d8611c-bf90-427d-b18a-1fe2473c9ffd' , 'a6941afd-695d-4aa3-a846-786ee0e105bd', current_date, 'MASTER DATA');
INSERT INTO base.hmis_profile_acl(profile_id, api_method_id, id, created_at, created_by ) VALUES ('004aed07-b4d4-4696-b8f6-1607f6f49bac','72df4ae1-3659-49cb-a221-84cee475a58e' , 'ba399214-8a93-4c88-86aa-4a11beb252cd', current_date, 'MASTER DATA');
INSERT INTO base.hmis_profile_acl(profile_id, api_method_id, id, created_at, created_by ) VALUES ('004aed07-b4d4-4696-b8f6-1607f6f49bac','b02a288d-85f2-4a5e-95d1-a43db8383e05' , 'a4673349-f258-4588-9d92-c3d74eff58e8', current_date, 'MASTER DATA');
INSERT INTO base.hmis_profile_acl(profile_id, api_method_id, id, created_at, created_by ) VALUES ('004aed07-b4d4-4696-b8f6-1607f6f49bac','60935f25-fec5-4e4d-b0c3-452d21d1848f' , 'aee9f6a9-feb3-48e7-bcbc-273515988c52', current_date, 'MASTER DATA');
INSERT INTO base.hmis_profile_acl(profile_id, api_method_id, id, created_at, created_by ) VALUES ('004aed07-b4d4-4696-b8f6-1607f6f49bac','600df1a9-b9e4-4953-b90e-8d55d67233ac' , '43dcac43-9886-47ed-847f-d4cec2a2941e', current_date, 'MASTER DATA');
INSERT INTO base.hmis_profile_acl(profile_id, api_method_id, id, created_at, created_by ) VALUES ('004aed07-b4d4-4696-b8f6-1607f6f49bac','3336586d-5034-41fc-a32c-9aab26873dd3' , '6a39596d-32f1-4ec3-94e4-7ba364960386', current_date, 'MASTER DATA');
INSERT INTO base.hmis_profile_acl(profile_id, api_method_id, id, created_at, created_by ) VALUES ('004aed07-b4d4-4696-b8f6-1607f6f49bac','9593ca58-78f6-4794-9d39-9412216c2f97' , '98e7215a-d544-40da-a9b7-d23b52545ff9', current_date, 'MASTER DATA');
INSERT INTO base.hmis_profile_acl(profile_id, api_method_id, id, created_at, created_by ) VALUES ('004aed07-b4d4-4696-b8f6-1607f6f49bac','eb23bef5-423f-464f-946c-5521eda0850c' , 'f9a80c00-d46a-2caa-f217-9d68094dd49d', current_date, 'MASTER DATA');
INSERT INTO base.hmis_profile_acl(profile_id, api_method_id, id, created_at, created_by ) VALUES ('004aed07-b4d4-4696-b8f6-1607f6f49bac','0e17ff09-8ab1-4913-9dde-0552193fcbf6' , (SELECT uuid_in(md5(random()::text || now()::text)::cstring)), current_date, 'MASTER DATA');
				
