CREATE OR REPLACE FUNCTION lsa.fun_lsareport_dq_and_reportdate (IN reportId integer, IN project_group_code varchar)
RETURNS void
 LANGUAGE plpgsql
AS $function$
BEGIN

/*
LSA FY2019 Sample Code

Name: 9_1 to 9_3 LSAReport dq and "ReportDate" (File 10 of 10)
Date:  4/7/2020   
	   5/14/2020 - section 9.1 - change check of leftmost character in SSN from ">= '9'" to "= '9'"
							   - add parentheses to WHERE clause 
	   5/21/2020 - section 9.1 - add set of "Step" to INSERT statement
				   section 9.2 - correct 24 (deceased) to 25 (LTC/nursing home) in list of institutional 
								 living situations for "HomelessDate1"/3, "TimesHomeless1"/3, "MonthsHomeless1"/3
	   5/28/2020 - section 9.2 - add missing PH destinations (HMIS values 33,34) to "HoHPermToPH1"/3
	9.1 Get Relevant Enrollments for Data Quality Checks
*/

delete from lsa."dq_Enrollment";
insert into lsa."dq_Enrollment" ("EnrollmentID", "PersonalID", "HouseholdID", "RelationshipToHoH"
	, "ProjectType", "EntryDate", "MoveInDate", "ExitDate", "Status1", "Status3", "SSNValid", "Step")
select distinct n."id", n."client_id", n."householdid", cast(cast (n."relationshiptohoh" as varchar)as integer)
	, cast(cast (p."projecttype" as varchar)as integer), n."entrydate", hhinfo."MoveInDate", "exitdate"
	, case when x."exitdate" < cd1."CohortStart" then null
			when c."dob_data_quality" in ('8','9') 
			or cast (convert_from(v2020.dob_decrypt(c.dob), 'utf-8') as date)is null 
			or cast (convert_from(v2020.dob_decrypt(c.dob), 'utf-8') as date)= '1900-1-1'
			or cast (convert_from(v2020.dob_decrypt(c.dob), 'utf-8') as date)> n."entrydate"
			or (cast (convert_from(v2020.dob_decrypt(c.dob), 'utf-8') as date)= n."entrydate" and n."relationshiptohoh" = '1')
			or dateadd('y', 105, cast (convert_from(v2020.dob_decrypt(c.dob), 'utf-8') as date)) <= n."entrydate" 
			or c."dob_data_quality" is null
			or c."dob_data_quality" not in ('1','2') then 99
		when dateadd('y', 18, cast (convert_from(v2020.dob_decrypt(c.dob), 'utf-8') as date)) <= n."entrydate" 
			or dateadd('y', 18, cast (convert_from(v2020.dob_decrypt(c.dob), 'utf-8') as date)) <= cd1."CohortStart" then 1
		else 0 end
	, case when c."dob_data_quality" in ('8','9') 
				or cast (convert_from(v2020.dob_decrypt(c.dob), 'utf-8') as date)is null 
				or cast (convert_from(v2020.dob_decrypt(c.dob), 'utf-8') as date)= '1900-1-1'
				or cast (convert_from(v2020.dob_decrypt(c.dob), 'utf-8') as date)> n."entrydate"
				or (cast (convert_from(v2020.dob_decrypt(c.dob), 'utf-8') as date)= n."entrydate" and n."relationshiptohoh" = '1')
				or dateadd('y', 105, cast (convert_from(v2020.dob_decrypt(c.dob), 'utf-8') as date)) <= n."entrydate" 
				or c."dob_data_quality" is null
				or c."dob_data_quality" not in ('1','2') then 99
		when dateadd('y', 18, cast (convert_from(v2020.dob_decrypt(c.dob), 'utf-8') as date)) <= n."entrydate" 
			or dateadd('y', 18, cast (convert_from(v2020.dob_decrypt(c.dob), 'utf-8') as date)) <= cd3."CohortStart"  then 1
		else 0 end
, case when c.ssn_data_quality in ('8','9') then null
		when SUBSTRING(c.SSN,1,3) in ('000','666')
				or LENGTH(convert_from(v2020.dob_decrypt(c.SSN), 'utf-8')) <> 9
				or SUBSTRING(c.SSN,4,2) = '00'
				or SUBSTRING(c.SSN,6,4) ='0000'
				or c.SSN is null
				or c.SSN = ''
				or c.SSN like '%[^0-9]%'
				--5/14/2020 changed below from ">= '9'"  to "= '9'")
				or left(convert_from(v2020.dob_decrypt(c.SSN), 'utf-8'),1) = '9'
				or c.SSN in ('123456789','111111111','222222222','333333333','444444444'
						,'555555555','777777777','888888888')
			then 0 else 1 end 
		, '9.1'
from v2020.enrollment n 
inner join lsa."tlsa_CohortDates" cd1 on cd1."Cohort" = 1
	and n."entrydate" <= cd1."CohortEnd" and n.deleted is false and n.parent_id is null
inner join lsa."tlsa_CohortDates" cd3 on cd3."Cohort" = 20
inner join v2020.project p on p."id" = n."projectid" AND p.deleted is false and p.parent_id is null
inner join v2020.client c on c."id" = n."client_id" and c.deleted is false and c.parent_id is null
left outer join v2020."exit" x on x."enrollmentid" = n."id" 
	and x.deleted is false and x.parent_id is null 
	and x."exitdate" <= cd3."CohortEnd"
left outer join (select distinct hh."householdid", min(mv."moveindate") as "MoveInDate"
	from v2020.enrollment hh
	inner join lsa."lsa_Report" rpt on hh."entrydate" <= rpt."ReportEnd" and rpt.project_group_code=hh.project_group_code and hh.deleted is false and hh.parent_id is null
	inner join v2020."moveindate" mv on hh."id" = mv."enrollmentid" and mv.deleted is false and mv.parent_id is null
	inner join v2020.project p on p."id" = hh."projectid" and p.deleted is false and p.parent_id is null
	inner join v2020.enrollment_coc coc on coc."enrollmentid" = hh."id"
		and coc."coc_code"= rpt."ReportCoC"
		and coc.deleted is false and coc.parent_id is null
	where p."projecttype" in ('3','13') 
		and mv."moveindate" <= rpt."ReportEnd" 
		and p."continuumproject" = '1'
	group by hh."householdid"
	) hhinfo on hhinfo."householdid" = n."householdid"
--5/14/2020 add parentheses to WHERE clause 
where (x."exitdate" is null or x."exitdate" >= cd3."CohortStart")
	and n."deleted" is null; 

/*
	9.2 Set LSAReport Data Quality Values 

	NOTE:  In practice, there is no need to check for non-NULL values in "Status3" as there 
			are no non-NULL values in lsa."dq_Enrollment".
*/
update lsa."lsa_Report" 
	set	"UnduplicatedClient1" = (select count(distinct n."PersonalID")
			from lsa."dq_Enrollment" n
			where n."Status1" is not null)
	,	"UnduplicatedClient3" = (select count(distinct n."PersonalID")
			from lsa."dq_Enrollment" n)
	,	"UnduplicatedAdult1" = (select count(distinct n."PersonalID")
			from lsa."dq_Enrollment" n 
			where n."Status1" = 1)
	,	"UnduplicatedAdult3" = (select count(distinct n."PersonalID")
			from lsa."dq_Enrollment" n 
			where n."Status3" = 1)
	,	"AdultHoHEntry1" = (select count(distinct n."EnrollmentID")
			from lsa."dq_Enrollment" n 
			where n."Status1" = 1 or (n."Status1" is not null and n."RelationshipToHoH" = 1))
	,	"AdultHoHEntry3" = (select count(distinct n."EnrollmentID")
			from lsa."dq_Enrollment" n 
			where n."Status3" = 1 or n."RelationshipToHoH" = 1)
	,	"ClientEntry1" = (select count(distinct n."EnrollmentID")
			from lsa."dq_Enrollment" n
			where n."Status1" is not null)
	,	"ClientEntry3" = (select count(distinct n."EnrollmentID")
			from lsa."dq_Enrollment" n)
	,	"ClientExit1" = (select count(distinct n."EnrollmentID")
			from lsa."dq_Enrollment" n 
			inner join lsa."lsa_Report" rpt on n."ExitDate" between rpt."ReportStart" and rpt."ReportEnd")
	,	"ClientExit3" = (select count(distinct n."EnrollmentID")
			from lsa."dq_Enrollment" n 
			where n."ExitDate" is not null)
	,	"Household1" = (select count(distinct n."HouseholdID")
			from lsa."dq_Enrollment" n
			where n."Status1" is not null)
	,	"Household3" = (select count(distinct n."HouseholdID")
			from lsa."dq_Enrollment" n)
	,	"HoHPermToPH1" = (select count(distinct n."EnrollmentID")
			from lsa."dq_Enrollment" n
			inner join v2020."exit" x on cast (x."enrollmentid" as varchar)= n."EnrollmentID" 
				and x.deleted is false and x.parent_id is null
			where n."Status1" is not null and n."RelationshipToHoH" = 1
				and n."ProjectType" in (3,13)
				and x.Destination in ('3','31','19','20','21','26','28','10','11','22','23','33','34'))
	,	"HoHPermToPH3" = (select count(distinct n."EnrollmentID")
			from lsa."dq_Enrollment" n
			inner join v2020."exit" x on cast (x."enrollmentid" as varchar)= n."EnrollmentID" 
				and x.deleted is false and x.parent_id is null
			where n."RelationshipToHoH" = 1
				and n."ProjectType" in (3,13)
				and x.Destination in ('3','31','19','20','21','26','28','10','11','22','23','33','34'))
	,   "NoCoC" = (select count (distinct n."householdid")
			from v2020.enrollment n 
			left outer join v2020.enrollment_coc coc on 
				coc."enrollmentid" = n."id" AND n.deleted is false and n.parent_id is null
				and coc.deleted is false and coc.parent_id is null
			inner join v2020.project p on p."id" = n."projectid"
				and p."continuumproject" = '1' and p."projecttype" in ('1','2','3','8','13') and p.deleted is false and p.parent_id is null
			inner join v2020."coc" pcoc on pcoc."coccode" = rpt."ReportCoC"
				and pcoc.deleted is false and pcoc.parent_id is null
			left outer join v2020."exit" x on x."enrollmentid" = n."id" 
				and x."exitdate" >= dateadd('y', -3, rpt."ReportStart")
				and x.deleted is false and x.parent_id is null
			where n."entrydate" <= rpt."ReportEnd" 
				and n."relationshiptohoh" = '1' 
				and coc."coc_code"is null
				and coc.deleted is false and coc.parent_id is null)
	,	"SSNNotProvided" = (select count(distinct n."PersonalID")
			from lsa."dq_Enrollment" n
			where n."SSNValid" is null)
	,	"SSNMissingOrInvalid" = (select count(distinct n."PersonalID")
			from lsa."dq_Enrollment" n
			where n."SSNValid" = 0)
	,	"ClientSSNNotUnique" = (select count(distinct n."PersonalID")
			from lsa."dq_Enrollment" n
			inner join v2020.client c on cast (c."id" as varchar)= n."PersonalID" and c.deleted is false and c.parent_id is null
			inner join v2020.client oc on oc.SSN = c.SSN 
				and oc."id" <> c."id" and oc.deleted is false and oc.parent_id is null
			inner join lsa."dq_Enrollment" dqn on dqn."PersonalID" = cast (oc."id" as varchar) 
			where n."SSNValid" = 1)
	,	"DistinctSSNValueNotUnique" = (select count(distinct d.SSN)
			from (select distinct c.SSN
				from v2020.client c 
				inner join lsa."dq_Enrollment" n on n."PersonalID" = cast (c."id" as varchar)
					and n."SSNValid" = 1 AND c.deleted is false and c.parent_id is null
				group by c.SSN
				having count(distinct n."PersonalID") > 1) d)
	,	"DOB1" = (select count(distinct n."PersonalID")
			from lsa."dq_Enrollment" n
			where n."Status1" = 99)
	,	"DOB3" = (select count(distinct n."PersonalID")
			from lsa."dq_Enrollment" n
			where n."Status3" = 99)
	,	"Gender1" = (select count(distinct n."PersonalID")
			from lsa."dq_Enrollment" n
			inner join v2020.client c on cast (c."id" as varchar) = n."PersonalID" AND c.deleted is false and c.parent_id is null
				and (c."gender" not in ('0','1','2','3','4') or c."gender" is null)
			where n."Status1" is not null)
	,	"Gender3" = (select count(distinct n."PersonalID")
			from lsa."dq_Enrollment" n
			inner join v2020.client c on cast (c."id" as varchar) = n."PersonalID"
				and (c."gender" not in ('0','1','2','3','4') or c."gender" is null))
	,	"Race1" = (select count(distinct n."PersonalID")
			from lsa."dq_Enrollment" n
			inner join v2020.client c on cast (c."id" as varchar) = n."PersonalID" AND c.deleted is false and c.parent_id is null
			where n."Status1" is not null and (coalesce(c.race in ('1','2','3','4','5'), '0') 
					or c.race in ('8','9','99')))
	,	"Race3" = (select count(distinct n."PersonalID")
			from lsa."dq_Enrollment" n
			inner join v2020.client c on cast (c."id" as varchar) = n."PersonalID" AND c.deleted is false and c.parent_id is null
			where (coalesce(c.race in ('1','2','3','4','5'), '0')
					or c.race in ('8','9','99')))
	,	"Ethnicity1" = (select count(distinct n."PersonalID")
			from lsa."dq_Enrollment" n
			inner join v2020.client c on cast (c."id" as varchar) = n."PersonalID" AND c.deleted is false and c.parent_id is null
			where n."Status1" is not null and (c."ethnicity" not in ('0','1') or c."ethnicity" is null))
	,	"Ethnicity3" = (select count(distinct n."PersonalID")
			from lsa."dq_Enrollment" n
			inner join v2020.client c on cast (c."id" as varchar) = n."PersonalID" AND c.deleted is false and c.parent_id is null
			where (c."ethnicity" not in ('0','1') or c."ethnicity" is null))
	,	"VetStatus1" = (select count(distinct c."id")
			from lsa."dq_Enrollment" n
			inner join v2020.client c on cast (c."id" as varchar) = n."PersonalID" AND c.deleted is false and c.parent_id is null
			where n."Status1" = 1 
				and (c.veteran_status not in ('0','1') or c.veteran_status is null))
	,	"VetStatus3" = (select count(distinct c."id")
			from lsa."dq_Enrollment" n
			inner join v2020.client c on cast (c."id" as varchar) = n."PersonalID" AND c.deleted is false and c.parent_id is null
			where n."Status3" = 1 
				and (c.veteran_status not in ('0','1') or c.veteran_status is null))
	,	"RelationshipToHoH1" = (select count(distinct n."EnrollmentID")
			from lsa."dq_Enrollment" n
			where n."Status1" is not null 
				and (n."RelationshipToHoH" not in (1,2,3,4,5) or n."RelationshipToHoH" is null))
	,	"RelationshipToHoH3" = (select count(distinct n."EnrollmentID")
			from lsa."dq_Enrollment" n
			where  (n."RelationshipToHoH" not in (1,2,3,4,5) or n."RelationshipToHoH" is null))
	,	"DisablingCond1" = (select count(distinct n."EnrollmentID")
			from lsa."dq_Enrollment" n
			inner join lsa."lsa_Report" rpt on rpt."ReportStart" >= n."ExitDate" or n."ExitDate" is null
			inner join v2020.enrollment hn on cast (hn."id" as varchar) = n."EnrollmentID" and rpt.project_group_code=hn.project_group_code AND hn.deleted is false and hn.parent_id is null
			--5/14/2020 - add check for "Status1" not null
			where n."Status1" is not null 
				and (hn."disablingcondition" not in ('0','1') or hn."disablingcondition" is null))
	,	"DisablingCond3" = (select count(distinct n."EnrollmentID")
			from lsa."dq_Enrollment" n
			inner join v2020.enrollment hn on cast (hn."id" as varchar) = n."EnrollmentID" AND hn.deleted is false and hn.parent_id is null
			where (hn."disablingcondition" not in ('0','1') or hn."disablingcondition" is null))
	,	"LivingSituation1" = (select count(distinct n."EnrollmentID")
			from lsa."dq_Enrollment" n
			inner join lsa."lsa_Report" rpt on rpt."ReportStart" >= n."ExitDate" or n."ExitDate" is null
			inner join v2020.enrollment hn on cast (hn."id" as varchar) = n."EnrollmentID" and rpt.project_group_code=hn.project_group_code AND hn.deleted is false and hn.parent_id is null
			where (n."Status1" = 1 or (n."RelationshipToHoH" = 1 and n."Status1" is not null))
				and (hn."livingsituation" in ('8','9','99') or hn."livingsituation" is null))
	,	"LivingSituation3" = (select count(distinct n."EnrollmentID")
			from lsa."dq_Enrollment" n
			inner join v2020.enrollment hn on cast(hn."id" as varchar)= n."EnrollmentID" AND hn.deleted is false and hn.parent_id is null
			where (n."RelationshipToHoH" = 1 or n."Status3" = 1)
				and (hn."livingsituation" in ('8','9','99') or hn."livingsituation" is null))
	,	"LengthOfStay1" = (select count(distinct n."EnrollmentID")
			from lsa."dq_Enrollment" n
			inner join lsa."lsa_Report" rpt on rpt."ReportStart" >= n."ExitDate" or n."ExitDate" is null
			inner join v2020.enrollment hn on cast (hn."id" as varchar) = n."EnrollmentID" and rpt.project_group_code=hn.project_group_code AND hn.deleted is false and hn.parent_id is null
			where (n."Status1" = 1 or (n."RelationshipToHoH" = 1 and n."Status1" is not null))
				and (hn."lengthofstay" in ('8','9','99') or hn."lengthofstay" is null))
	,	"LengthOfStay3" = (select count(distinct n."EnrollmentID")
			from lsa."dq_Enrollment" n
			inner join v2020.enrollment hn on cast (hn."id" as varchar)= n."EnrollmentID" AND hn.deleted is false and hn.parent_id is null
			where (n."RelationshipToHoH" = 1 or n."Status3" = 1)
				and (hn."lengthofstay" in ('8','9','99') or hn."lengthofstay" is null))
	,	"HomelessDate1" = (select count(distinct n."EnrollmentID")
			from lsa."dq_Enrollment" n
			inner join lsa."lsa_Report" rpt on rpt."ReportStart" >= n."ExitDate" or n."ExitDate" is NULL 
			inner join v2020.enrollment hn on cast (hn."id" as varchar)= n."EnrollmentID" and rpt.project_group_code=hn.project_group_code AND hn.deleted is false and hn.parent_id is null
			where (n."Status1" = 1 or (n."RelationshipToHoH" = 1 and n."Status1" is not null))
				-- DateToStreetESSH may not be after hn."entrydate"...
				and (hn.datetostreetessh > hn."entrydate"
				-- ...and may not be null if...
				or (hn.datetostreetessh is null 
				-- ..."ProjectType" is ES/SH...
				and (n."ProjectType" in (1,8)
						-- ... or when LivingSituation is ES/SH/street/interim housing
						or hn."livingsituation" in ('1','16','18','27') 
						-- ... or when LOS is < 7 days and PreviousStreetESSH = 1
						or ((hn."previousstreetessh" = '1' or hn."previousstreetessh" is NULL) and hn."lengthofstay" in ('10','11'))
						-- ... or when LivingSituation is institutional, LOS is < 90 days
							-- and PreviousStreetESSH = 1 
						or ((hn."previousstreetessh" = '1' or hn."previousstreetessh" is NULL) and hn."lengthofstay" in ('2','3')
							and hn."livingsituation" in ('4','5','6','7','15','25'))
					))))
	,	"HomelessDate3" = (select count(distinct n."EnrollmentID")
			from lsa."dq_Enrollment" n
			inner join v2020.enrollment hn on cast(hn."id" as varchar) = n."EnrollmentID" AND hn.deleted is false and hn.parent_id is null
			where (n."RelationshipToHoH" = 1 or n."Status3" = 1)
				-- DateToStreetESSH is required and may not be after hn."entrydate" if...
				and (hn.datetostreetessh is null or hn.datetostreetessh> hn."entrydate") 
				-- ..."ProjectType" is ES/SH...
				and (n."ProjectType" in (1,8)
						-- ... or when LivingSituation is ES/SH/street/interim housing
						or hn."livingsituation" in ('1','16','18','27') 
						-- ... or when LOS is < 7 days and PreviousStreetESSH = 1
						or ((hn."previousstreetessh" = '1' or hn."previousstreetessh" is NULL) and hn."lengthofstay" in ('10','11'))
						-- ... or when LivingSituation is institutional, LOS is < 90 days
							-- and PreviousStreetESSH = 1 
						or ((hn."previousstreetessh" = '1' or hn."previousstreetessh" is NULL) and hn."lengthofstay" in ('2','3')
							and hn."livingsituation" in ('4','5','6','7','15','25'))
					))
	,	"TimesHomeless1" = (select count(distinct n."EnrollmentID")
			from lsa."dq_Enrollment" n
			inner join lsa."lsa_Report" rpt on rpt."ReportStart" >= n."ExitDate" or n."ExitDate" is null
			inner join v2020.enrollment hn on cast (hn."id" as varchar) = n."EnrollmentID" and rpt.project_group_code=hn.project_group_code AND hn.deleted is false and hn.parent_id is null
			where (n."Status1" = 1 or (n."RelationshipToHoH" = 1 and n."Status1" is not null))
				--TimesHomelessPastThreeYears is required and must be a valid value if...
				and (cast (cast (hn."timeshomelesspastthreeyears" as varchar)as integer)not between 1 and 4  
					or hn."timeshomelesspastthreeyears" is null)
				-- ..."ProjectType" is ES/SH...
				and (n."ProjectType" in (1,8)
						-- ... or when LivingSituation is ES/SH/street/interim housing
						or hn."livingsituation" in ('1','16','18','27') 
						-- ... or when LOS is < 7 days and PreviousStreetESSH = 1
						or (hn."previousstreetessh" = '1' and hn."lengthofstay" in ('10','11'))
						-- ... or when LivingSituation is institutional, LOS is < 90 days
							-- and PreviousStreetESSH = 1 
						or (hn."previousstreetessh" = '1' and hn."lengthofstay" in ('2','3')
							and hn."livingsituation" in ('4','5','6','7','15','25'))
					))
	,	"TimesHomeless3" = (select count(distinct n."EnrollmentID")
			from lsa."dq_Enrollment" n
			inner join v2020.enrollment hn on cast (hn."id" as varchar)= n."EnrollmentID" AND hn.deleted is false and hn.parent_id is null
			where (n."RelationshipToHoH" = 1 or n."Status3" = 1)
				--TimesHomelessPastThreeYears is required and must be a valid value if...
				and (cast(cast(hn."timeshomelesspastthreeyears"as varchar) as integer) not between 1 and 4  
					or hn."timeshomelesspastthreeyears" is null)
				-- ..."ProjectType" is ES/SH...
				and (n."ProjectType" in ('1','8')
						-- ... or when LivingSituation is ES/SH/street/interim housing
						or hn."livingsituation" in ('1','16','18','27') 
						-- ... or when LOS is < 7 days and PreviousStreetESSH = 1
						or (hn."previousstreetessh" = '1' and hn."lengthofstay" in ('10','11'))
						-- ... or when LivingSituation is institutional, LOS is < 90 days
							-- and PreviousStreetESSH = 1 
						or (hn."previousstreetessh" = '1' and hn."lengthofstay" in ('2','3')
							and hn."livingsituation" in ('4','5','6','7','15','25'))
					))
	,	"MonthsHomeless1" = (select count(distinct n."EnrollmentID")
			from lsa."dq_Enrollment" n
			inner join lsa."lsa_Report" rpt on rpt."ReportStart" >= n."ExitDate" or n."ExitDate" is null
			inner join v2020.enrollment hn on cast(hn."id" as varchar)= n."EnrollmentID" and rpt.project_group_code=hn.project_group_code AND hn.deleted is false and hn.parent_id is null
			where (n."Status1" = 1 or (n."RelationshipToHoH" = 1 and n."Status1" is not null))
				--MonthsHomelessPastThreeYears is required and must be a valid value if...
				and (cast (cast (hn."monthshomelesspastthreeyears" as varchar) as integer)not between 101 and 113 
				or hn."monthshomelesspastthreeyears" is null)
				-- ..."ProjectType" is ES/SH...
				and (n."ProjectType" in (1,8)
						-- ... or when LivingSituation is ES/SH/street/interim housing
						or hn."livingsituation" in ('1','16','18','27') 
						-- ... or when LOS is < 7 days and PreviousStreetESSH = 1
						or (hn."previousstreetessh" = '1' and hn."lengthofstay" in ('10','11'))
						-- ... or when LivingSituation is institutional, LOS is < 90 days
							-- and PreviousStreetESSH = 1 
						or (hn."previousstreetessh" = '1' and hn."lengthofstay" in ('2','3')
							and hn."livingsituation" in ('4','5','6','7','15','25'))	
					))
	,	"MonthsHomeless3" = (select count(distinct n."EnrollmentID")
			from lsa."dq_Enrollment" n
			inner join v2020.enrollment hn on cast (hn."id" as varchar)= n."EnrollmentID" AND hn.deleted is false and hn.parent_id is null
			where (n."RelationshipToHoH" = 1 or n."Status3" = 1)
				--MonthsHomelessPastThreeYears is required and must be a valid value if...
				and (cast (cast (hn."monthshomelesspastthreeyears" as varchar) as integer) not between 101 and 113 
				or hn."monthshomelesspastthreeyears" is null)
				-- ..."ProjectType" is ES/SH...
				and (n."ProjectType" in (1,8)
						-- ... or when LivingSituation is ES/SH/street/interim housing
						or hn."livingsituation" in ('1','16','18','27') 
						-- ... or when LOS is < 7 days and PreviousStreetESSH = 1
						or (hn."previousstreetessh" = '1' and hn."lengthofstay" in ('10','11'))
						-- ... or when LivingSituation is institutional, LOS is < 90 days
							-- and PreviousStreetESSH = 1 
						or (hn."previousstreetessh" = '1' and hn."lengthofstay" in ('2','3')
							and hn."livingsituation" in ('4','5','6','7','15','25'))	
					))
	,	"DV1" = (select count(distinct n."EnrollmentID")
			from lsa."dq_Enrollment" n
			inner join lsa."lsa_Report" rpt on rpt."ReportStart" >= n."ExitDate" or n."ExitDate" is null
			left outer join v2020.domesticviolence dv on CAST(dv."enrollmentid" as varchar) = n."EnrollmentID" and rpt.project_group_code=dv.project_group_code AND dv.deleted is false and dv.parent_id is null
				and dv.datacollectionstage = '1'
				and dv."deleted" is null 
			where (n."Status1" = 1 or (n."RelationshipToHoH" = 1 and n."Status1" is not null))
				and (cast (cast (dv.domesticviolencevictim as varchar) as integer) not in (0,1)
						or dv.domesticviolencevictim is null
						or (dv.domesticviolencevictim = '1' and 
							(dv.currently_fleeing not in (0,1) 
								or dv.currently_fleeing is null))))
	,	"DV3" = (select count(distinct n."EnrollmentID")
			from lsa."dq_Enrollment" n
			left outer join v2020.domesticviolence dv on cast (dv."enrollmentid" as varchar) = n."EnrollmentID" AND dv.deleted is false and dv.parent_id is null
				and dv.datacollectionstage = '1'
				and dv."deleted" is null 
			where (n."RelationshipToHoH" = 1 or n."Status3" = 1)
				and (dv.domesticviolencevictim not in ('0','1')
						or dv.domesticviolencevictim is null
						or (dv.domesticviolencevictim = '1' and 
							(dv.currently_fleeing not in (0,1) 
								or dv.currently_fleeing is null))))
	,	"Destination1" = (select count(distinct n."EnrollmentID")
			from lsa."dq_Enrollment" n
			inner join v2020."exit" x on CAST (x."enrollmentid" AS varchar) = n."EnrollmentID" AND x.deleted is false and x.parent_id is null 
				and x."deleted" is null 
			inner join lsa."lsa_Report" rpt on x."exitdate" > rpt."ReportStart" and rpt.project_group_code=x.project_group_code
			where (x.destination in ('8','9','17','30','99') or x.destination is null))
	,	"Destination3" = (select count(distinct n."EnrollmentID")
			from lsa."dq_Enrollment" n
			inner join v2020."exit" x on CAST (x."enrollmentid" AS varchar) = n."EnrollmentID" AND x.deleted is false and x.parent_id is null
				and x."deleted" is null 
			where n."ExitDate" is not null and (x.Destination in ('8','9','17','30','99') or x.destination is null))
	,	"NotOneHoH1" = (select count(distinct n."HouseholdID")
			from lsa."dq_Enrollment" n
			inner join lsa."lsa_Report" rpt on rpt."ReportEnd" >= n."ExitDate" or n."ExitDate" is null
			left outer join (select hn."householdid", count(distinct hn."id") as hoh
				from v2020.enrollment hn
				where hn."relationshiptohoh" = '1' AND hn.deleted is false and hn.parent_id is null
				group by hn."householdid"
			) hoh on hoh."householdid" = n."HouseholdID"
			where hoh.hoh <> 1 or hoh."householdid" is null)
	,	"NotOneHoH3" = (select count(distinct n."HouseholdID")
			from lsa."dq_Enrollment" n
			left outer join (select hn."householdid", count(distinct hn."id") as hoh
				from v2020.enrollment hn
				where hn."relationshiptohoh" = '1' AND hn.deleted is false and hn.parent_id is null
				group by hn."householdid"
			) hoh on hoh."householdid" = n."HouseholdID"
			where hoh.hoh <> 1 or hoh."householdid" is null)
	,	"MoveInDate1" = coalesce((select count(distinct n."EnrollmentID")
			from lsa."dq_Enrollment" n
			inner join lsa."lsa_Report" rpt on rpt."ReportEnd" >= n."EntryDate" 
			left outer join v2020."exit" x on CAST (x."enrollmentid" AS varchar) = n."EnrollmentID" and rpt.project_group_code=x.project_group_code
				AND x.deleted is false and x.parent_id is null
			where n."RelationshipToHoH" = 1
				and n."ProjectType" in (3,13)
				and (x."exitdate" is null or x."exitdate" >= rpt."ReportStart")
				and ((n."MoveInDate" < n."EntryDate" or n."MoveInDate" > x."exitdate")
					or (x.Destination in ('3','31','19','20','21','26','28','10','11','22','23','33','34') 
						and n."MoveInDate" is null))), 0)
	,	"MoveInDate3" = coalesce((select count(distinct n."EnrollmentID")
			from lsa."dq_Enrollment" n
			inner join lsa."lsa_Report" rpt on rpt."ReportEnd" >= n."EntryDate"
			left outer join v2020."exit" x on CAST(x."enrollmentid" AS varchar) = n."EnrollmentID" and rpt.project_group_code=x.project_group_code
				and x."exitdate" < rpt."ReportEnd"
				AND x.deleted is false and x.parent_id is null
			where n."RelationshipToHoH" = 1
				and n."ProjectType" in (3,13)
				and (x."exitdate" is null or x."exitdate" >= rpt."ReportStart")
				and ((n."MoveInDate" < n."EntryDate" or n."MoveInDate" > x."exitdate")
					or (x.Destination in ('3','31','19','20','21','26','28','10','11','22','23','33','34') 
						and n."MoveInDate" is null))), 0)
from lsa."lsa_Report" rpt;

/*
	9.3 Set "ReportDate" for LSAReport
*/
update lsa."lsa_Report" set "ReportDate" = now();

END
$function$
;
