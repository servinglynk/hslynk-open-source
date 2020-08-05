CREATE OR REPLACE FUNCTION lsa.fun_get_project_records_for_export (IN reportId integer, IN project_group_code varchar)
RETURNS void
 LANGUAGE plpgsql
AS $function$
BEGIN

/*
Name:  4_1 Get Project Records for Export.sql

Date:	4/2/2020 -- original 
		4/30/2020 -- create two separate scripts from original file (4_1 to 4_6 PDDEs for export.sql):
					 - 4_1 Get Project Records for Export.sql
				     - 4_2 to 4_6 Other PDDEs for Export.sql
				  -- correct all date formatting from "yyyy"-"mm"-"dd" to "yyyy"-MM-"dd"
		5/21/2020 -- add 'and coc."ProjectID" = hp."id"' to hmis_ProjectCoC join

	4.1 Get Project Records for Export
		Export records for continuum ES (1), SH (8), TH (2), RRH (13), PSH (3), and OPH (9 or 10)
		projects active in the report period.

		NOTE:   If used in production, must be modified to accept user-selected ProjectIDs as 
				parameters when "LSAScope" = 2.
*/	  	
	delete from lsa."lsa_Project";

	insert into lsa."lsa_Project"
		("ProjectID", "OrganizationID", "ProjectName"
		 , "OperatingStartDate", "OperatingEndDate"
		 , "ContinuumProject", "ProjectType", "HousingType"
		 , "TrackingMethod", "HMISParticipatingProject"
		 , "TargetPopulation"
		 , "DateCreated", "DateUpdated", "ExportID")
	select distinct 
		hp."id", hp."organizationid", left(hp."projectname", 50)
		, to_char(hp."operatingstartdate"::date, '"yyyy"-MM-"dd"')
		, case when hp."operatingenddate" is not null then to_char(hp."operatingenddate", '"yyyy"-MM-"dd"') else null end
		, cast (cast (hp."continuumproject" as varchar) as integer), cast (cast (hp."projecttype" as varchar) as integer), cast (cast (hp."housingtype" as varchar) as integer)
		, cast (cast (hp."trackingmethod" as varchar) as integer), cast (cast (hp."hmisparticipatingproject" as varchar) as integer)
		, cast (cast (hp."targetpopulation"  as varchar) as integer)
		, to_char(hp."date_created", '"yyyy"-MM-"dd" hh:"mm":ss')
		, to_char(hp."date_updated", '"yyyy"-MM-"dd" hh:"mm":ss')
		, rpt."ReportID"
	from v2020.project hp
	inner join lsa."lsa_Report" rpt on hp."operatingstartdate" <= rpt."ReportEnd" AND hp.project_group_code = rpt.project_group_code
inner join v2020.coc coc on coc."coccode" = rpt."ReportCoC"
		and coc."projectid" = hp."id" AND coc."deleted" is false AND coc.parent_id is null
	where hp."deleted" is false AND hp.parent_id is null AND hp.project_group_code = coc.project_group_code
		and hp."continuumproject" = '1' 
		and hp."projecttype" in ('1','2','3','8','9','10','13')
		and hp."operatingstartdate" <= rpt."ReportEnd"
		and (hp."operatingenddate" is null 
			 or	(hp."operatingenddate" >= rpt."ReportStart"
				 and hp."operatingenddate" > hp."operatingstartdate")
			)  ;

END
$function$
;
