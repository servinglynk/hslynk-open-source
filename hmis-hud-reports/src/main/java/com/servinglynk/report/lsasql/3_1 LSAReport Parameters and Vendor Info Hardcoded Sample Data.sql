CREATE OR REPLACE FUNCTION lsa.fun_lsareport_parameters_and_vendor_info (IN reportId integer, IN project_group_code varchar)
RETURNS void
 LANGUAGE plpgsql
AS $function$
BEGIN

/*
LSA FY2019 Sample Code

Name:  3_1 LSAReport Parameters and Vendor Info Hardcoded Sample Data.sql 

Date:	4/16/2020 -- original 
		4/30/2020 -- create two separate scripts from original file (3_1 to 3_6 households and enrollments.sql):
					 - 3_1 LSAReport Parameters and Vendor Info Hardcoded Sample Data.sql
				     - 3_2 to 3_6 HMIS Households and Enrollments.sql
		5/14/2020 -- do not set "ReportDate" -- it is set in 9.3

	3.1 Report Parameters and Metadata 

	The hard-coded values here must be replaced with code to accept actual user-entered parameters 
	and info specific to the HMIS application.
*/
delete from lsa."lsa_Report"; 

insert into lsa."lsa_Report" (
		  "ReportID"			--system-generated unique identifier for report process
		, "ReportStart"		--user-entered start of report period
		, "ReportEnd"			--user-entered end of report period 
		, "ReportCoC"			--user-selected HUD Continuum of Care Code
		, "SoftwareVendor"	--name of vendor  
		, "SoftwareName"		--name of HMIS application
		, "VendorContact"		--name of vendor contact
		, "VendorEmail"		--email address of vendor contact
		, "LSAScope"			--user-selected 1=systemwide, 2=project-focused
		, "project_group_code"
		)
	select
		  12345
		, '2018-1-10'
		, '2019-9-30'
		, 'XX-500'
		, 'Sample Code Inc.'
		, 'LSA Online'
		, 'Molly'			
		, 'molly@squarepegdata.com'
		, 1
		, 'LS0024'
;

END
$function$
;
