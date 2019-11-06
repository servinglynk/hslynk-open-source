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

 INSERT INTO base.hmis_api_method VALUES ('45552518-d070-5992-2ec8-05b3f9f745f2', 'CLIENT_API_UNMERGE', 'CLIENT_API_UNMERGE', 'CLIENT_API_UNMERGE', 'POST', NULL, NULL, '2016-05-11', NULL, 'MASTER DATA', NULL, NULL, '55269f08-273f-4f68-ae9b-f98467b4d091', 0, NULL, NULL, NULL, true, true);
  INSERT INTO base.hmis_api_method VALUES ('45552518-d070-5992-2ec8-05b3f9f745d5', 'CLIENT_API_MERGE', 'CLIENT_API_MERGE', 'CLIENT_API_MERGE', 'POST', NULL, NULL, '2016-05-11', NULL, 'MASTER DATA', NULL, NULL, '55269f08-273f-4f68-ae9b-f98467b4d091', 0, NULL, NULL, NULL, true, true);
  INSERT INTO base.hmis_api_method VALUES ('45552518-d070-5992-2ec8-05b3f9f745d8', 'CLIENT_API_GET_ALL_EXITRHY', 'CLIENT_API_GET_ALL_EXITRHY', 'CLIENT_API_GET_ALL_EXITRHY', 'GET', NULL, NULL, '2016-05-11', NULL, 'MASTER DATA', NULL, NULL, '55269f08-273f-4f68-ae9b-f98467b4d091', 0, NULL, NULL, NULL, true, true);
 

				
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

INSERT INTO base.hmis_profile_acl(profile_id, api_method_id, id, created_at, created_by ) VALUES ('d78c38a1-2762-4393-b69b-41a0a11e6efc','754ee226-2f0f-9691-d164-fd0499832bc8' , (SELECT uuid_in(md5(random()::text || now()::text)::cstring)), current_date, 'MASTER DATA');
INSERT INTO base.hmis_profile_acl(profile_id, api_method_id, id, created_at, created_by ) VALUES ('d78c38a1-2762-4393-b69b-41a0a11e6efc','754ee226-2f0f-9691-d164-fd0499832bc9' , (SELECT uuid_in(md5(random()::text || now()::text)::cstring)), current_date, 'MASTER DATA');


INSERT INTO base.hmis_profile_acl(profile_id, api_method_id, id, created_at, created_by ) VALUES ('004aed07-b4d4-4696-b8f6-1607f6f49bac','45552518-d070-5992-2ec8-05b3f9f745f2' , '5fd85889-aa2e-4c2a-a4e2-9dc927485245', current_date, 'MASTER DATA');
 INSERT INTO base.hmis_profile_acl(profile_id, api_method_id, id, created_at, created_by ) VALUES ('004aed07-b4d4-4696-b8f6-1607f6f49bac','45552518-d070-5992-2ec8-05b3f9f745d5' , '5fd85889-aa2e-4c2a-a4e2-9dc927485246', current_date, 'MASTER DATA');
  INSERT INTO base.hmis_profile_acl(profile_id, api_method_id, id, created_at, created_by ) VALUES ('004aed07-b4d4-4696-b8f6-1607f6f49bae','45552518-d070-5992-2ec8-05b3f9f745d8' , '5fd85889-aa2e-4c2a-a4e2-9dc927485256', current_date, 'MASTER DATA');

 

				

  
  INSERT INTO base.hmis_api_method VALUES ('45552518-d070-5992-2ec8-05b3f9f745d9', 'CLIENT_API_CREATE_ASSESSMENT', 'CLIENT_API_CREATE_ASSESSMENT', 'CLIENT_API_CREATE_ASSESSMENT', 'POST', NULL, NULL, '2016-05-11', NULL, 'MASTER DATA', NULL, NULL, '55269f08-273f-4f68-ae9b-f98467b4d091', 0, NULL, NULL, NULL, true, true);
  INSERT INTO base.hmis_profile_acl(profile_id, api_method_id, id, created_at, created_by ) VALUES ('004aed07-b4d4-4696-b8f6-1607f6f49bae','45552518-d070-5992-2ec8-05b3f9f745d9' , '5fd85889-aa2e-4c2a-a4e2-9dc927485257', current_date, 'MASTER DATA');

  INSERT INTO base.hmis_api_method VALUES ('5ebd9f2f-ac3b-4419-a31b-1d34bc0abd5d', 'CLIENT_API_UPDATE_ASSESSMENT', 'CLIENT_API_UPDATE_ASSESSMENT', 'CLIENT_API_UPDATE_ASSESSMENT', 'PUT', NULL, NULL, '2016-05-11', NULL, 'MASTER DATA', NULL, NULL, '55269f08-273f-4f68-ae9b-f98467b4d091', 0, NULL, NULL, NULL, true, true);
  INSERT INTO base.hmis_profile_acl(profile_id, api_method_id, id, created_at, created_by ) VALUES ('004aed07-b4d4-4696-b8f6-1607f6f49bae','5ebd9f2f-ac3b-4419-a31b-1d34bc0abd5d' , gen_random_uuid(), current_date, 'MASTER DATA');

                                                            INSERT INTO base.hmis_api_method VALUES ('c614d61d-3ac3-4b84-9cae-979d0ee7cfc5', 'CLIENT_API_GET_ASSESSMENT_BY_ID', 'CLIENT_API_GET_ASSESSMENT_BY_ID', 'CLIENT_API_GET_ASSESSMENT_BY_ID', 'GET', NULL, NULL, '2016-05-11', NULL, 'MASTER DATA', NULL, NULL, '55269f08-273f-4f68-ae9b-f98467b4d091', 0, NULL, NULL, NULL, true, true);
  INSERT INTO base.hmis_profile_acl(api_method_id,profile_id, id, created_at, created_by ) VALUES ('c614d61d-3ac3-4b84-9cae-979d0ee7cfc5','004aed07-b4d4-4696-b8f6-1607f6f49bae', gen_random_uuid(), current_date, 'MASTER DATA');


                                 INSERT INTO base.hmis_api_method VALUES ('fe2b8dd2-9709-4641-91f3-62f97be13559', 'CLIENT_API_DELETE_ASSESSMENT', 'CLIENT_API_DELETE_ASSESSMENT', 'CLIENT_API_GET_ASSESSMENT_BY_ID', 'DELETE', NULL, NULL, '2016-05-11', NULL, 'MASTER DATA', NULL, NULL, '55269f08-273f-4f68-ae9b-f98467b4d091', 0, NULL, NULL, NULL, true, true);
  INSERT INTO base.hmis_profile_acl(api_method_id,profile_id, id, created_at, created_by ) VALUES ('fe2b8dd2-9709-4641-91f3-62f97be13559','004aed07-b4d4-4696-b8f6-1607f6f49bae', gen_random_uuid(), current_date, 'MASTER DATA');

  
        INSERT INTO base.hmis_api_method VALUES ('5d846fd5-a221-4ace-947f-164a88a2b13d', 'CLIENT_API_GET_ALL_ENROLLMENT_ASSESSMENT', 'CLIENT_API_GET_ALL_ENROLLMENT_ASSESSMENT', 'CLIENT_API_GET_ALL_ENROLLMENT_ASSESSMENT', 'GET', NULL, NULL, '2016-05-11', NULL, 'MASTER DATA', NULL, NULL, '55269f08-273f-4f68-ae9b-f98467b4d091', 0, NULL, NULL, NULL, true, true);
  INSERT INTO base.hmis_profile_acl(api_method_id,profile_id, id, created_at, created_by ) VALUES ('5d846fd5-a221-4ace-947f-164a88a2b13d','004aed07-b4d4-4696-b8f6-1607f6f49bae', gen_random_uuid(), current_date, 'MASTER DATA');

                                                      INSERT INTO base.hmis_api_method VALUES ('c614d61d-3ac3-4b84-9cae-979d0ee7cfc5', 'CLIENT_API_GET_ASSESSMENT_BY_ID', 'CLIENT_API_GET_ASSESSMENT_BY_ID', 'CLIENT_API_GET_ASSESSMENT_BY_ID', 'GET', NULL, NULL, '2016-05-11', NULL, 'MASTER DATA', NULL, NULL, '55269f08-273f-4f68-ae9b-f98467b4d091', 0, NULL, NULL, NULL, true, true);
  INSERT INTO base.hmis_profile_acl(api_method_id,profile_id, id, created_at, created_by ) VALUES ('c614d61d-3ac3-4b84-9cae-979d0ee7cfc5','004aed07-b4d4-4696-b8f6-1607f6f49bae', gen_random_uuid(), current_date, 'MASTER DATA');


                                 INSERT INTO base.hmis_api_method VALUES ('fe2b8dd2-9709-4641-91f3-62f97be13559', 'CLIENT_API_DELETE_ASSESSMENT', 'CLIENT_API_DELETE_ASSESSMENT', 'CLIENT_API_GET_ASSESSMENT_BY_ID', 'DELETE', NULL, NULL, '2016-05-11', NULL, 'MASTER DATA', NULL, NULL, '55269f08-273f-4f68-ae9b-f98467b4d091', 0, NULL, NULL, NULL, true, true);
  INSERT INTO base.hmis_profile_acl(api_method_id,profile_id, id, created_at, created_by ) VALUES ('fe2b8dd2-9709-4641-91f3-62f97be13559','004aed07-b4d4-4696-b8f6-1607f6f49bae', gen_random_uuid(), current_date, 'MASTER DATA');

           INSERT INTO base.hmis_api_method VALUES ('5d846fd5-a221-4ace-947f-164a88a2b13d', 'CLIENT_API_GET_ALL_ENROLLMENT_ASSESSMENT', 'CLIENT_API_GET_ALL_ENROLLMENT_ASSESSMENT', 'CLIENT_API_GET_ALL_ENROLLMENT_ASSESSMENT', 'GET', NULL, NULL, '2016-05-11', NULL, 'MASTER DATA', NULL, NULL, '55269f08-273f-4f68-ae9b-f98467b4d091', 0, NULL, NULL, NULL, true, true);
  INSERT INTO base.hmis_profile_acl(api_method_id,profile_id, id, created_at, created_by ) VALUES ('5d846fd5-a221-4ace-947f-164a88a2b13d','004aed07-b4d4-4696-b8f6-1607f6f49bae', gen_random_uuid(), current_date, 'MASTER DATA');


                                                            INSERT INTO base.hmis_api_method VALUES ('7f6f75aa-0955-4706-818b-19a2645aa623', 'CLIENT_API_CREATE_ASSESSMENT_QUESTION', 'CLIENT_API_CREATE_ASSESSMENT_QUESTION', 'CLIENT_API_CREATE_ASSESSMENT_QUESTION', 'POST', NULL, NULL, '2016-05-11', NULL, 'MASTER DATA', NULL, NULL, '55269f08-273f-4f68-ae9b-f98467b4d091', 0, NULL, NULL, NULL, true, true);
  INSERT INTO base.hmis_profile_acl(api_method_id,profile_id, id, created_at, created_by ) VALUES ('7f6f75aa-0955-4706-818b-19a2645aa623','004aed07-b4d4-4696-b8f6-1607f6f49bae', gen_random_uuid(), current_date, 'MASTER DATA');

                                                         INSERT INTO base.hmis_api_method VALUES ('0953b10f-363c-4e78-956b-834f2a0cc15f', 'CLIENT_API_UPDATE__ASSESSMENT_QUESTION', 'CLIENT_API_UPDATE__ASSESSMENT_QUESTION', 'CLIENT_API_UPDATE__ASSESSMENT_QUESTION', 'PUT', NULL, NULL, '2016-05-11', NULL, 'MASTER DATA', NULL, NULL, '55269f08-273f-4f68-ae9b-f98467b4d091', 0, NULL, NULL, NULL, true, true);
  INSERT INTO base.hmis_profile_acl(api_method_id,profile_id, id, created_at, created_by ) VALUES ('0953b10f-363c-4e78-956b-834f2a0cc15f','004aed07-b4d4-4696-b8f6-1607f6f49bae', gen_random_uuid(), current_date, 'MASTER DATA');

                                                         INSERT INTO base.hmis_api_method VALUES ('95e5bf42-b8d9-4a03-8b19-5b75046a49f3', 'CLIENT_API_DELETE__ASSESSMENT_QUESTION', 'CLIENT_API_DELETE__ASSESSMENT_QUESTION', 'CLIENT_API_DELETE__ASSESSMENT_QUESTION', 'DELETE', NULL, NULL, '2016-05-11', NULL, 'MASTER DATA', NULL, NULL, '55269f08-273f-4f68-ae9b-f98467b4d091', 0, NULL, NULL, NULL, true, true);
  INSERT INTO base.hmis_profile_acl(api_method_id,profile_id, id, created_at, created_by ) VALUES ('95e5bf42-b8d9-4a03-8b19-5b75046a49f3','004aed07-b4d4-4696-b8f6-1607f6f49bae', gen_random_uuid(), current_date, 'MASTER DATA');

                                                         INSERT INTO base.hmis_api_method VALUES ('22d3e01e-ce8b-4649-9484-a92ff85a6ce6', 'CLIENT_API_GET__ASSESSMENT_QUESTION_BY_ID', 'CLIENT_API_GET__ASSESSMENT_QUESTION_BY_ID', 'CLIENT_API_GET__ASSESSMENT_QUESTION_BY_ID', 'GET', NULL, NULL, '2016-05-11', NULL, 'MASTER DATA', NULL, NULL, '55269f08-273f-4f68-ae9b-f98467b4d091', 0, NULL, NULL, NULL, true, true);
  INSERT INTO base.hmis_profile_acl(api_method_id,profile_id, id, created_at, created_by ) VALUES ('22d3e01e-ce8b-4649-9484-a92ff85a6ce6','004aed07-b4d4-4696-b8f6-1607f6f49bae', gen_random_uuid(), current_date, 'MASTER DATA');

                                                         INSERT INTO base.hmis_api_method VALUES ('618d4e72-3bac-47ab-9a90-cd1b3e2462e7', 'CLIENT_API_GET_ALL_ENROLLMENT__ASSESSMENT_QUESTION', 'CLIENT_API_GET_ALL_ENROLLMENT__ASSESSMENT_QUESTION', 'CLIENT_API_GET_ALL_ENROLLMENT__ASSESSMENT_QUESTION', 'GET', NULL, NULL, '2016-05-11', NULL, 'MASTER DATA', NULL, NULL, '55269f08-273f-4f68-ae9b-f98467b4d091', 0, NULL, NULL, NULL, true, true);
  INSERT INTO base.hmis_profile_acl(api_method_id,profile_id, id, created_at, created_by ) VALUES ('618d4e72-3bac-47ab-9a90-cd1b3e2462e7','004aed07-b4d4-4696-b8f6-1607f6f49bae', gen_random_uuid(), current_date, 'MASTER DATA');

  
  
                                                            INSERT INTO base.hmis_api_method VALUES ('b88b5267-c4e1-437f-86d3-13162cc37f4a', 'CLIENT_API_CREATE_ASSESSMENT_RESULT', 'CLIENT_API_CREATE_ASSESSMENT_RESULT', 'CLIENT_API_CREATE_ASSESSMENT_RESULT', 'POST', NULL, NULL, '2016-05-11', NULL, 'MASTER DATA', NULL, NULL, '55269f08-273f-4f68-ae9b-f98467b4d091', 0, NULL, NULL, NULL, true, true);
  INSERT INTO base.hmis_profile_acl(api_method_id,profile_id, id, created_at, created_by ) VALUES ('b88b5267-c4e1-437f-86d3-13162cc37f4a','004aed07-b4d4-4696-b8f6-1607f6f49bae', gen_random_uuid(), current_date, 'MASTER DATA');

                                                         INSERT INTO base.hmis_api_method VALUES ('0c9557a5-805d-4af6-9719-15ef8df0e720', 'CLIENT_API_UPDATE__ASSESSMENT_RESULT', 'CLIENT_API_UPDATE__ASSESSMENT_RESULT', 'CLIENT_API_UPDATE__ASSESSMENT_RESULT', 'PUT', NULL, NULL, '2016-05-11', NULL, 'MASTER DATA', NULL, NULL, '55269f08-273f-4f68-ae9b-f98467b4d091', 0, NULL, NULL, NULL, true, true);
  INSERT INTO base.hmis_profile_acl(api_method_id,profile_id, id, created_at, created_by ) VALUES ('0c9557a5-805d-4af6-9719-15ef8df0e720','004aed07-b4d4-4696-b8f6-1607f6f49bae', gen_random_uuid(), current_date, 'MASTER DATA');

                                                         INSERT INTO base.hmis_api_method VALUES ('ab3582c4-51aa-4646-8bc6-cbfcaf849004', 'CLIENT_API_DELETE__ASSESSMENT_RESULT', 'CLIENT_API_DELETE__ASSESSMENT_RESULT', 'CLIENT_API_DELETE__ASSESSMENT_RESULT', 'DELETE', NULL, NULL, '2016-05-11', NULL, 'MASTER DATA', NULL, NULL, '55269f08-273f-4f68-ae9b-f98467b4d091', 0, NULL, NULL, NULL, true, true);
  INSERT INTO base.hmis_profile_acl(api_method_id,profile_id, id, created_at, created_by ) VALUES ('ab3582c4-51aa-4646-8bc6-cbfcaf849004','004aed07-b4d4-4696-b8f6-1607f6f49bae', gen_random_uuid(), current_date, 'MASTER DATA');

                                                         INSERT INTO base.hmis_api_method VALUES ('690e1b0b-8024-47f3-8453-3946dbbd7c2a', 'CLIENT_API_GET__ASSESSMENT_RESULT_BY_ID', 'CLIENT_API_GET__ASSESSMENT_RESULT_BY_ID', 'CLIENT_API_GET__ASSESSMENT_RESULT_BY_ID', 'GET', NULL, NULL, '2016-05-11', NULL, 'MASTER DATA', NULL, NULL, '55269f08-273f-4f68-ae9b-f98467b4d091', 0, NULL, NULL, NULL, true, true);
  INSERT INTO base.hmis_profile_acl(api_method_id,profile_id, id, created_at, created_by ) VALUES ('690e1b0b-8024-47f3-8453-3946dbbd7c2a','004aed07-b4d4-4696-b8f6-1607f6f49bae', gen_random_uuid(), current_date, 'MASTER DATA');

                                                         INSERT INTO base.hmis_api_method VALUES ('cc1f8fa9-7ee0-4693-8d4b-62169c7c4399', 'CLIENT_API_GET_ALL_ENROLLMENT__ASSESSMENT_RESULT', 'CLIENT_API_GET_ALL_ENROLLMENT__ASSESSMENT_RESULT', 'CLIENT_API_GET_ALL_ENROLLMENT__ASSESSMENT_RESULT', 'GET', NULL, NULL, '2016-05-11', NULL, 'MASTER DATA', NULL, NULL, '55269f08-273f-4f68-ae9b-f98467b4d091', 0, NULL, NULL, NULL, true, true);
  INSERT INTO base.hmis_profile_acl(api_method_id,profile_id, id, created_at, created_by ) VALUES ('cc1f8fa9-7ee0-4693-8d4b-62169c7c4399','004aed07-b4d4-4696-b8f6-1607f6f49bae', gen_random_uuid(), current_date, 'MASTER DATA');


                                                            INSERT INTO base.hmis_api_method VALUES ('5bab4c55-0e89-40ae-ba6b-0299d6399236', 'CLIENT_API_CREATE_EVENT', 'CLIENT_API_CREATE_EVENT', 'CLIENT_API_CREATE_EVENT', 'POST', NULL, NULL, '2016-05-11', NULL, 'MASTER DATA', NULL, NULL, '55269f08-273f-4f68-ae9b-f98467b4d091', 0, NULL, NULL, NULL, true, true);
  INSERT INTO base.hmis_profile_acl(api_method_id,profile_id, id, created_at, created_by ) VALUES ('5bab4c55-0e89-40ae-ba6b-0299d6399236','004aed07-b4d4-4696-b8f6-1607f6f49bae', gen_random_uuid(), current_date, 'MASTER DATA');

                                                         INSERT INTO base.hmis_api_method VALUES ('e7612451-3191-4a51-889c-d2a5cc7ce2a1', 'CLIENT_API_UPDATE_EVENT', 'CLIENT_API_UPDATE_EVENT', 'CLIENT_API_UPDATE_EVENT', 'PUT', NULL, NULL, '2016-05-11', NULL, 'MASTER DATA', NULL, NULL, '55269f08-273f-4f68-ae9b-f98467b4d091', 0, NULL, NULL, NULL, true, true);
  INSERT INTO base.hmis_profile_acl(api_method_id,profile_id, id, created_at, created_by ) VALUES ('e7612451-3191-4a51-889c-d2a5cc7ce2a1','004aed07-b4d4-4696-b8f6-1607f6f49bae', gen_random_uuid(), current_date, 'MASTER DATA');

                                                         INSERT INTO base.hmis_api_method VALUES ('ba8526bb-4f8d-4316-b093-8482985fd0fe', 'CLIENT_API_DELETE_EVENT', 'CLIENT_API_DELETE_EVENT', 'CLIENT_API_DELETE_EVENT', 'DELETE', NULL, NULL, '2016-05-11', NULL, 'MASTER DATA', NULL, NULL, '55269f08-273f-4f68-ae9b-f98467b4d091', 0, NULL, NULL, NULL, true, true);
  INSERT INTO base.hmis_profile_acl(api_method_id,profile_id, id, created_at, created_by ) VALUES ('ba8526bb-4f8d-4316-b093-8482985fd0fe','004aed07-b4d4-4696-b8f6-1607f6f49bae', gen_random_uuid(), current_date, 'MASTER DATA');

                                                         INSERT INTO base.hmis_api_method VALUES ('3a2d6ad6-9924-4f15-8522-97af782f30ea', 'CLIENT_API_GET_EVENT_BY_ID', 'CLIENT_API_GET_EVENT_BY_ID', 'CLIENT_API_GET_EVENT_BY_ID', 'GET', NULL, NULL, '2016-05-11', NULL, 'MASTER DATA', NULL, NULL, '55269f08-273f-4f68-ae9b-f98467b4d091', 0, NULL, NULL, NULL, true, true);
  INSERT INTO base.hmis_profile_acl(api_method_id,profile_id, id, created_at, created_by ) VALUES ('3a2d6ad6-9924-4f15-8522-97af782f30ea','004aed07-b4d4-4696-b8f6-1607f6f49bae', gen_random_uuid(), current_date, 'MASTER DATA');

                                                         INSERT INTO base.hmis_api_method VALUES ('7732f822-841a-4d40-b529-b0c7d085e866', 'CLIENT_API_GET_ALL_ENROLLMENT_EVENT', 'CLIENT_API_GET_ALL_ENROLLMENT_EVENT', 'CLIENT_API_GET_ALL_ENROLLMENT_EVENT', 'GET', NULL, NULL, '2016-05-11', NULL, 'MASTER DATA', NULL, NULL, '55269f08-273f-4f68-ae9b-f98467b4d091', 0, NULL, NULL, NULL, true, true);
  INSERT INTO base.hmis_profile_acl(api_method_id,profile_id, id, created_at, created_by ) VALUES ('7732f822-841a-4d40-b529-b0c7d085e866','004aed07-b4d4-4696-b8f6-1607f6f49bae', gen_random_uuid(), current_date, 'MASTER DATA');

                                                          INSERT INTO base.hmis_api_method VALUES ('17ca88ea-5ba6-41f9-a6c7-080ffd243cd3', 'CLIENT_API_CREATE_CURRENT_LIVING_SITUATION', 'CLIENT_API_CREATE_CURRENT_LIVING_SITUATION', 'CLIENT_API_CREATE_CURRENT_LIVING_SITUATION', 'POST', NULL, NULL, '2016-05-11', NULL, 'MASTER DATA', NULL, NULL, '55269f08-273f-4f68-ae9b-f98467b4d091', 0, NULL, NULL, NULL, true, true);
  INSERT INTO base.hmis_profile_acl(api_method_id,profile_id, id, created_at, created_by ) VALUES ('17ca88ea-5ba6-41f9-a6c7-080ffd243cd3','004aed07-b4d4-4696-b8f6-1607f6f49bae', gen_random_uuid(), current_date, 'MASTER DATA');

                                                         INSERT INTO base.hmis_api_method VALUES ('fd78f677-be82-49e6-9332-ef183c917079', 'CLIENT_API_UPDATE_CURRENT_LIVING_SITUATION', 'CLIENT_API_UPDATE_CURRENT_LIVING_SITUATION', 'CLIENT_API_UPDATE_CURRENT_LIVING_SITUATION', 'PUT', NULL, NULL, '2016-05-11', NULL, 'MASTER DATA', NULL, NULL, '55269f08-273f-4f68-ae9b-f98467b4d091', 0, NULL, NULL, NULL, true, true);
  INSERT INTO base.hmis_profile_acl(api_method_id,profile_id, id, created_at, created_by ) VALUES ('fd78f677-be82-49e6-9332-ef183c917079','004aed07-b4d4-4696-b8f6-1607f6f49bae', gen_random_uuid(), current_date, 'MASTER DATA');

                                                         INSERT INTO base.hmis_api_method VALUES ('9970afbe-f222-4dae-9c55-07174f7e8f98', 'CLIENT_API_DELETE_CURRENT_LIVING_SITUATION', 'CLIENT_API_DELETE_CURRENT_LIVING_SITUATION', 'CLIENT_API_DELETE_CURRENT_LIVING_SITUATION', 'DELETE', NULL, NULL, '2016-05-11', NULL, 'MASTER DATA', NULL, NULL, '55269f08-273f-4f68-ae9b-f98467b4d091', 0, NULL, NULL, NULL, true, true);
  INSERT INTO base.hmis_profile_acl(api_method_id,profile_id, id, created_at, created_by ) VALUES ('9970afbe-f222-4dae-9c55-07174f7e8f98','004aed07-b4d4-4696-b8f6-1607f6f49bae', gen_random_uuid(), current_date, 'MASTER DATA');

                                                         INSERT INTO base.hmis_api_method VALUES ('79633f2b-c70c-4bf3-8e18-bcd55a2bdee6', 'CLIENT_API_GET_CURRENT_LIVING_SITUATION_BY_ID', 'CLIENT_API_GET_CURRENT_LIVING_SITUATION_BY_ID', 'CLIENT_API_GET_CURRENT_LIVING_SITUATION_BY_ID', 'GET', NULL, NULL, '2016-05-11', NULL, 'MASTER DATA', NULL, NULL, '55269f08-273f-4f68-ae9b-f98467b4d091', 0, NULL, NULL, NULL, true, true);
  INSERT INTO base.hmis_profile_acl(api_method_id,profile_id, id, created_at, created_by ) VALUES ('79633f2b-c70c-4bf3-8e18-bcd55a2bdee6','004aed07-b4d4-4696-b8f6-1607f6f49bae', gen_random_uuid(), current_date, 'MASTER DATA');

                                                         INSERT INTO base.hmis_api_method VALUES ('c5e76ddb-120f-4312-88ea-b61a75754e14', 'CLIENT_API_GET_ALL_ENROLLMENT_CURRENT_LIVING_SITUATION', 'CLIENT_API_GET_ALL_ENROLLMENT_CURRENT_LIVING_SITUATION', 'CLIENT_API_GET_ALL_ENROLLMENT_CURRENT_LIVING_SITUATION', 'GET', NULL, NULL, '2016-05-11', NULL, 'MASTER DATA', NULL, NULL, '55269f08-273f-4f68-ae9b-f98467b4d091', 0, NULL, NULL, NULL, true, true);
  INSERT INTO base.hmis_profile_acl(api_method_id,profile_id, id, created_at, created_by ) VALUES ('c5e76ddb-120f-4312-88ea-b61a75754e14','004aed07-b4d4-4696-b8f6-1607f6f49bae', gen_random_uuid(), current_date, 'MASTER DATA');
