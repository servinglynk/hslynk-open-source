CREATE OR REPLACE FUNCTION lsa.fun_lsahousehold (IN reportId integer, IN project_group_code varchar)
RETURNS void
 LANGUAGE plpgsql
AS $function$
BEGIN

/*
LSA FY2019 Sample Code

Name:  6_1 to 6_19 LSAHousehold.sql  (File 6 of 10)
Date:  4/20/2020
	   5/14/2020 -  section 6.12 - correct "DateDeleted" = 0" to "DateDeleted" is null"
	   				section 6.14 - correct 24 (deceased) to 25 (LTC/nursing home) 
								   in list of institutional living situations
	   5/21/2020 -  section 6.12.2.a and b - add parentheses to join to lsa."tlsa_HHID"
				    section 6.14 - correct second instance of 24 (deceased) to 25 (LTC/nursing home) 
								   in list of institutional living situations
					Sections 6.1-6.18 - add set of "Step" column to all insert and update statements
	   5/28/2020 -  section 6.5 - add host home (HMIS value = 32) to living situation case statements
	   6/18/2020 - 6.4.1 and 6.4.2 -- correct RRH/PSHMoveIn values from 10 and 20 to 1 and 2
				   6.9.3 - add note to explain a sequence difference between code and specs
							and correct criteria for setting Stat = 5 and ReturnTime = -1
				   6.10 - correct criteria for RRHPreMoveInDays to include ExitDate instead of 
				          stopping at ExitDate - 1 day
				   6.18 - remove 2 extraneous < signs (was <= 0, but < 0 is impossible)
						  correct SystemPath 4 criteria from RRHStatus >= 2 to RRHStatus >= 11
	   7/9/2020 -  6.12.1 - Set LastInactive to 9/30/2012 if the calculated date is earlier
				   6.12.2.b - Only use bednights that are valid (fall during the period of the enrollment)
						  and relevant to LastInactive (>= 10/1/2012)

	6.1 Get Unique Households and Population Identifiers for tlsa_Household
*/
	delete from lsa."tlsa_Household";

	insert into lsa."tlsa_Household" ("HouseholdID", "HHType"
		, "HHChronic", "HHVet", "HHDisability", "HHFleeingDV"
		, "HoHRace", "HoHEthnicity"
		, "HHParent", "ReportID", "Step")
	select distinct hhid."HouseholdID", hhid."ActiveHHType"
		, max(hhid."HHChronic")
		, max(hhid."HHVet")
		, max(hhid."HHDisability")
		, max(hhid."HHFleeingDV")
		, lp."Race", lp."Ethnicity"
		, max(hhid."HHParent")
		, lp."ReportID"
		, '6.1'
	from lsa."tlsa_HHID" hhid
	inner join lsa."lsa_Report" rpt on rpt."ReportEnd" >= hhid."EntryDate"
	inner join lsa."tlsa_Person" lp on lp."PersonalID" = hhid."HouseholdID" 
	where hhid."Active" = B'1'
	group by hhid."HouseholdID", hhid."ActiveHHType", lp."Race", lp."Ethnicity"
		, lp."ReportID";

/*
	6.2 Set Population Identifiers for LSAHousehold
*/
	update lsa."tlsa_Household"
	set "HHChild" = (select case when count(distinct n."PersonalID") >= 3 then 3
					else count(distinct n."PersonalID") end
				from lsa."tlsa_HHID" hhid
				inner join lsa."tlsa_Enrollment" n on n."HouseholdID" = hhid."HouseholdID" and n."Active" = B'1'
				where n."ActiveAge" < 18
				and hhid."ActiveHHType" = hh."HHType" and hhid."HouseholdID" = hh."HouseholdID")
		, "HHAdult" = (select case when count(distinct n."PersonalID") >= 3 then 3
					else count(distinct n."PersonalID") end
				from lsa."tlsa_HHID" hhid
				inner join lsa."tlsa_Enrollment" n on n."HouseholdID" = hhid."HouseholdID" and n."Active" = B'1' 
				where n."ActiveAge" between 18 and 65 
					and hhid."ActiveHHType" = hh."HHType" and hhid."HouseholdID" = hh."HouseholdID"
					and n."PersonalID" not in 
						(select n17."PersonalID" 
						 from lsa."tlsa_HHID" hh17
						 inner join lsa."tlsa_Enrollment" n17 on n17."HouseholdID" = hh17."HouseholdID" and n17."Active" = B'1'
						 where hh17."HouseholdID" = hhid."HouseholdID" and hh17."ActiveHHType" = hhid."ActiveHHType"
							and n17."ActiveAge" < 18))
		, "HHNoDOB" = (select case when count(distinct n."PersonalID") >= 3 then 3
					else count(distinct n."PersonalID") end
				from lsa."tlsa_HHID" hhid
				inner join lsa."tlsa_Enrollment" n on n."HouseholdID" = hhid."HouseholdID" and n."Active" = B'1' 
				where n."ActiveAge" in (98,99)
				and hhid."ActiveHHType" = hh."HHType" and hhid."HouseholdID" = hh."HouseholdID")
		, "Step" = '6.2.1'
	from lsa."tlsa_Household" hh;

	update lsa."tlsa_Household" 
	set "HHAdultAge" = null, "Step" = '6.2.2'
	from lsa."tlsa_Household" hh;

	update lsa."tlsa_Household"
	set "HHAdultAge" = hhid."HHAdultAge", "Step" = '6.2.3' 
	from lsa."tlsa_Household" hh
	inner join lsa."tlsa_HHID" hhid
		on hhid."HouseholdID" = hh."HouseholdID" and hhid."ActiveHHType" = hh."HHType"
			and hhid."Active" = B'1'
	where hhid."HHAdultAge" = 18;

	update lsa."tlsa_Household"
	set "HHAdultAge" = hhid."HHAdultAge", "Step" = '6.2.4' 
	from lsa."tlsa_Household" hh
	inner join lsa."tlsa_HHID" hhid
		on hhid."HouseholdID" = hh."HouseholdID" and hhid."ActiveHHType" = hh."HHType"
			and hhid."Active" = B'1'
	where hhid."HHAdultAge" = 24 and hh."HHAdultAge" is null;

	update lsa."tlsa_Household"
	set "HHAdultAge" = hhid."HHAdultAge", "Step" = '6.2.5' 
	from lsa."tlsa_Household" hh
	inner join lsa."tlsa_HHID" hhid
		on hhid."HouseholdID" = hh."HouseholdID" and hhid."ActiveHHType" = hh."HHType"
			and hhid."Active" = B'1'
	where hhid."HHAdultAge" = 55 and hh."HHAdultAge" is null;

	update lsa."tlsa_Household"
	SET "HHAdultAge" = hhid."HHAdultAge", "Step" = '6.2.6' 
	from lsa."tlsa_Household" hh
	inner join lsa."tlsa_HHID" hhid
		on hhid."HouseholdID" = hh."HouseholdID" and hhid."ActiveHHType" = hh."HHType"
			and hhid."Active" = B'1'
	where hhid."HHAdultAge" = 25 and hh."HHAdultAge" is null;

	update lsa."tlsa_Household" 
	set "HHAdultAge" = -1, "Step" = '6.2.7' 
	from lsa."tlsa_Household" hh
	where hh."HHAdultAge" is null;

/*
	6.3 Set lsa."tlsa_Household" Project Group Status Indicators
*/

	update lsa."tlsa_Household"
	set "ESTStatus" = case when n.nStat is null then 0 
			else n.nStat + n.xStat end
		, "Step" = '6.3.1'
	from lsa."tlsa_Household" hh
	left outer join 
		(select hhid."HouseholdID", hhid."ActiveHHType" as "HHType"
			, min(case when hhid."EntryDate" < rpt."ReportStart" then 10 else 20 end) as nStat
			, min(case when hhid."ExitDate" is null then 1 else 2 end) as xStat
		from lsa."tlsa_HHID" hhid
		inner join lsa."lsa_Report" rpt on hhid."EntryDate" <= rpt."ReportEnd"
		where hhid."Active" = B'1'  and hhid."ProjectType" in (1,2,8)
		group by hhid."HouseholdID", hhid."ActiveHHType"
		) n on n."HouseholdID" = hh."HouseholdID" and n."HHType" = hh."HHType";

	update lsa."tlsa_Household"
	set "RRHStatus" = case when n.nStat is null then 0 
			else n.nStat + n.xStat end
		, "Step" = '6.3.2'
	from lsa."tlsa_Household" hh
	left outer join 
		(select hhid."HouseholdID", hhid."ActiveHHType" as "HHType"
			, min(case when hhid."EntryDate" < rpt."ReportStart" then 10 else 20 end) as nStat
			, min(case when hhid."ExitDate" is null then 1 else 2 end) as xStat
		from lsa."tlsa_HHID" hhid
		inner join lsa."lsa_Report" rpt on hhid."EntryDate" <= rpt."ReportEnd"
		where hhid."Active" = B'1'  and hhid."ProjectType" = 13
		group by hhid."HouseholdID", hhid."ActiveHHType"
		) n on n."HouseholdID" = hh."HouseholdID" and n."HHType" = hh."HHType";

	update lsa."tlsa_Household"
	set "PSHStatus" = case when n.nStat is null then 0 
			else n.nStat + n.xStat end
		, "Step" = '6.3.3'
	from lsa."tlsa_Household" hh
	left outer join 
		(select hhid."HouseholdID", hhid."ActiveHHType" as "HHType"
			, min(case when hhid."EntryDate" < rpt."ReportStart" then 10 else 20 end) as nStat
			, min(case when hhid."ExitDate" is null then 1 else 2 end) as xStat
		from lsa."tlsa_HHID" hhid
		inner join lsa."lsa_Report" rpt on hhid."EntryDate" <= rpt."ReportEnd"
		where hhid."Active" = B'1'  and hhid."ProjectType" = 3
		group by hhid."HouseholdID", hhid."ActiveHHType"
		) n on n."HouseholdID" = hh."HouseholdID" and n."HHType" = hh."HHType";
	       
/*
	6.4 Set lsa."tlsa_Household" RRH and PSH Move-In Status Indicators
*/

	update lsa."tlsa_Household"
	set "RRHMoveIn" = case when hh."RRHStatus" = 0 then -1
		when n.MoveInStat is null then 0 
		else n.MoveInStat end
		, "Step" = '6.4.1'
	from lsa."tlsa_Household" hh
	left outer join 
		(select hhid."HouseholdID", hhid."ActiveHHType" as "HHType"
			, min(case when hhid."MoveInDate" >= rpt."ReportStart" then 1 else 2 end) as MoveInStat
		from lsa."tlsa_HHID" hhid
		inner join lsa."lsa_Report" rpt on hhid."EntryDate" <= rpt."ReportEnd"
		where hhid."Active" = B'1'  and hhid."MoveInDate" is not null and hhid."ProjectType" = 13
		group by hhid."HouseholdID", hhid."ActiveHHType"
		) n on n."HouseholdID" = hh."HouseholdID" and n."HHType" = hh."HHType";

	update lsa."tlsa_Household"
	set "PSHMoveIn" = case when hh."RRHStatus" = 0 then -1
		when n.MoveInStat is null then 0 
		else n.MoveInStat end
		, "Step" = '6.4.2'
	from lsa."tlsa_Household" hh
	left outer join 
		(select hhid."HouseholdID", hhid."ActiveHHType" as "HHType"
			, min(case when hhid."MoveInDate" >= rpt."ReportStart" then 1 else 2 end) as MoveInStat
		from lsa."tlsa_HHID" hhid
		inner join lsa."lsa_Report" rpt on hhid."EntryDate" <= rpt."ReportEnd"
		where hhid."Active" = B'1'  and hhid."MoveInDate" is not null and hhid."ProjectType" = 3
		group by hhid."HouseholdID", hhid."ActiveHHType"
		) n on n."HouseholdID" = hh."HouseholdID" and n."HHType" = hh."HHType";

       
/*
	6.5 Set lsa."tlsa_Household" Geography for Each Project Group 
	-- Enrollment with latest active date in report period for project group
*/

	update lsa."tlsa_Household"
	set "ESTGeography" = case when hh."ESTStatus" = 0 then -1 
			else coalesce(
				(select coc."GeographyType"
				from lsa."tlsa_HHID" hhid
				inner join lsa."lsa_Report" rpt on rpt."ReportEnd" >= hhid."EntryDate"
				inner join lsa."lsa_ProjectCoC" coc on coc."ProjectID" = hhid."ProjectID" 
				where hhid."Active" = B'1'  and hhid."ProjectType" in (1,2,8) 
					and hhid."HouseholdID" = hh."HouseholdID" and hhid."ActiveHHType" = hh."HHType"
				order by case when hhid."ExitDate" is null then rpt."ReportEnd" else hhid."ExitDate" end desc
					, hhid."EntryDate" DESC limit 1)
				, 99) end
		, "Step" = '6.5.1'
	from lsa."tlsa_Household" hh ;

	update lsa."tlsa_Household"
	set "RRHGeography" = case when hh."RRHStatus" = 0 then -1 
			else coalesce(
				(select coc."GeographyType"
				from lsa."tlsa_HHID" hhid
				inner join lsa."lsa_Report" rpt on rpt."ReportEnd" >= hhid."EntryDate"
				inner join lsa."lsa_ProjectCoC" coc on coc."ProjectID" = hhid."ProjectID" 
				where hhid."Active" = B'1'  and hhid."ProjectType" = 13 
					and hhid."HouseholdID" = hh."HouseholdID" and hhid."ActiveHHType" = hh."HHType"
				order by case when hhid."ExitDate" is null then rpt."ReportEnd" else hhid."ExitDate" end desc
					, hhid."EntryDate" DESC limit 1)
				, 99) end
		, "Step" = '6.5.2'
	from lsa."tlsa_Household" hh ;

	update lsa."tlsa_Household"
	set "PSHGeography" = case when hh."PSHStatus" = 0 then -1 
			else coalesce(
				(select coc."GeographyType"
				from lsa."tlsa_HHID" hhid
				inner join lsa."lsa_Report" rpt on rpt."ReportEnd" >= hhid."EntryDate"
				inner join lsa."lsa_ProjectCoC" coc on coc."ProjectID" = hhid."ProjectID" 
				where hhid."Active" = B'1'  and hhid."ProjectType" = 3 
					and hhid."HouseholdID" = hh."HouseholdID" and hhid."ActiveHHType" = hh."HHType"
				order by case when hhid."ExitDate" is null then rpt."ReportEnd" else hhid."ExitDate" end desc
					, hhid."EntryDate" DESC limit 1)
				, 99) end
		, "Step" = '6.5.3'
	from lsa."tlsa_Household" hh ;

/*
	6.6 Set lsa."tlsa_Household" Living Situation for Each Project Group 
	--earliest active enrollment in project group
*/

	update lsa."tlsa_Household"
	set "ESTLivingSit" = 
		case when hh."ESTStatus" = 0 then -1
			when hn."livingsituation" = '16' then 1 --Homeless - Street
			when hn."livingsituation" in ('1','18') then 2	--Homeless - ES/SH
			when hn."livingsituation" = '27' then 3	--Interim Housing
			when hn."livingsituation" in ('2','32') then 4	--Homeless - TH or host home
			when hn."livingsituation" = '14' then 5	--Hotel/Motel - no voucher
			when hn."livingsituation" = '29' then 6	--Residential project
			when hn."livingsituation" = '35' then 7	--Family		
			when hn."livingsituation" = '36' then 8	--Friends
			when hn."livingsituation" = '3' then 9	--PSH
			when hn."livingsituation" in ('21','11') then 10	--PH - own
			when hn."livingsituation" = '10' then 11	--PH - rent no subsidy
			when hn."livingsituation" in ('19','28','20','33','34') then 12	--PH - rent with subsidy
			when hn."livingsituation" = '15' then 13	--Foster care
			when hn."livingsituation" = '25' then 14	--Long-term care
			when hn."livingsituation" = '7' then 15	--Institutions - incarceration
			when hn."livingsituation" in ('4','5','6') then 16	--Institutions - medical
			else 99	end
		, "Step" = '6.6.1'
	from lsa."tlsa_Household" hh
	inner join v2020.enrollment hn on cast (hn."client_id" as varchar) = hh."HouseholdID" and hn.deleted is false and hn.parent_id is null
	where hh."ESTStatus" = 0 
		or cast (hn."id" as varchar )in 
			(select hhid."EnrollmentID" 
			 from lsa."tlsa_HHID" hhid
			 where hhid."ProjectType" in (1,2,8) 
				and hhid."HouseholdID" = hh."HouseholdID" and hhid."ActiveHHType" = hh."HHType"
				and hhid."Active" = B'1' 
			 order by hhid."EntryDate" ASC limit 1);

	update lsa."tlsa_Household"
	set "RRHLivingSit" = 
		case when hh."RRHStatus" = 0 then -1 
			when hn."livingsituation" = '16' then 1 --Homeless - Street
			when hn."livingsituation" in ('1','18') then 2	--Homeless - ES/SH
			when hn."livingsituation" = '27' then 3	--Interim Housing
			when hn."livingsituation" in ('2','32') then 4	--Homeless - TH or host home
			when hn."livingsituation" = '14' then 5	--Hotel/Motel - no voucher
			when hn."livingsituation" = '29' then 6	--Residential project
			when hn."livingsituation" = '35' then 7	--Family		
			when hn."livingsituation" = '36' then 8	--Friends
			when hn."livingsituation" = '3' then 9	--PSH
			when hn."livingsituation" in ('21','11') then 10	--PH - own
			when hn."livingsituation" = '10' then 11	--PH - rent no subsidy
			when hn."livingsituation" in ('19','28','20','33','34') then 12	--PH - rent with subsidy
			when hn."livingsituation" = '15' then 13	--Foster care
			when hn."livingsituation" = '25' then 14	--Long-term care
			when hn."livingsituation" = '7' then 15	--Institutions - incarceration
			when hn."livingsituation" in ('4','5','6') then 16	--Institutions - medical
			else 99	end	
		, "Step" = '6.6.2'
	from lsa."tlsa_Household" hh
	inner join v2020.enrollment hn on cast (hn."client_id" as varchar) = hh."HouseholdID" and hn.deleted is false and hn.parent_id is null
	where hh."RRHStatus" = 0  
		or cast (hn."id" as varchar) in 
			(select  hhid."EnrollmentID" 
			 from lsa."tlsa_HHID" hhid
			 where hhid."ProjectType" = 13 
				and hhid."HouseholdID" = hh."HouseholdID" and hhid."ActiveHHType" = hh."HHType"
				and hhid."Active" = B'1' 
			 order by hhid."EntryDate" asc limit 1);

	update lsa."tlsa_Household"
	set "PSHLivingSit" = 
		case when hh."PSHStatus" = 0 then -1 
			when hn."livingsituation" = '16' then 1 --Homeless - Street
			when hn."livingsituation" in ('1','18') then 2	--Homeless - ES/SH
			when hn."livingsituation" ='27' then 3	--Interim Housing
			when hn."livingsituation" in ('2','32') then 4	--Homeless - TH or host home
			when hn."livingsituation" = '14' then 5	--Hotel/Motel - no voucher
			when hn."livingsituation" = '29' then 6	--Residential project
			when hn."livingsituation" = '35' then 7	--Family		
			when hn."livingsituation" = '36' then 8	--Friends
			when hn."livingsituation" = '3' then 9	--PSH
			when hn."livingsituation" in ('21','11') then 10	--PH - own
			when hn."livingsituation" = '10' then 11	--PH - rent no subsidy
			when hn."livingsituation" in ('19','28','20','33','34') then 12	--PH - rent with subsidy
			when hn."livingsituation" = '15' then 13	--Foster care
			when hn."livingsituation" = '25' then 14	--Long-term care
			when hn."livingsituation" = '7' then 15	--Institutions - incarceration
			when hn."livingsituation" in ('4','5','6') then 16	--Institutions - medical
			else 99	end	
		, "Step" = '6.6.3'
	from lsa."tlsa_Household" hh
	inner join v2020.enrollment hn on CAST (hn."client_id" AS varchar) = hh."HouseholdID" and hn.deleted is false and hn.parent_id is null
	where hh."PSHStatus" = 0  
		or CAST (hn."id" AS VARCHAR ) in 
			(select hhid."EnrollmentID" 
			 from lsa."tlsa_HHID" hhid
			 where hhid."ProjectType" = 3 
				and hhid."HouseholdID" = hh."HouseholdID" and hhid."ActiveHHType" = hh."HHType"
				and hhid."Active" = B'1' 
			 order by hhid."EntryDate" ASC limit 1) ;

/*
	6.7 Set lsa."tlsa_Household" Destination for Each Project Group 
	--most recent exit from project group for households not active in project group at "ReportEnd"
*/

	update lsa."tlsa_Household"
	set "ESTDestination" = 
		case when hh."ESTStatus" not in (12,22) then -1
			 else hhid."ExitDest" end
		, "Step" = '6.7.1'
	from lsa."tlsa_Household" hh 
	inner join lsa."tlsa_HHID" hhid on hhid."HouseholdID" = hh."HouseholdID"
		and hhid."ActiveHHType" = hh."HHType" and hhid."Active" = B'1' 
	where hh."ESTStatus" not in (12,22)  
		or hhid."EnrollmentID" in 
			(select hhid."EnrollmentID" 
			 from lsa."tlsa_HHID" hhid
			 where hhid."ProjectType" in (1,2,8) 
				and hhid."HouseholdID" = hh."HouseholdID" and hhid."ActiveHHType" = hh."HHType"
				and hhid."Active" = B'1' 
			 order by hhid."ExitDate" DESC limit 1);

	update lsa."tlsa_Household"
	set "RRHDestination" = 
		case when hh."RRHStatus" not in (12,22) then -1
			 else hhid."ExitDest" end
		, "Step" = '6.7.2'
	from lsa."tlsa_Household" hh 
	inner join lsa."tlsa_HHID" hhid on hhid."HouseholdID" = hh."HouseholdID"
		and hhid."ActiveHHType" = hh."HHType" and hhid."Active" = B'1' 
	where hh."RRHStatus" not in (12,22)  
		or hhid."EnrollmentID" in 
			(select hhid."EnrollmentID" 
			 from lsa."tlsa_HHID" hhid
			 where hhid."ProjectType" = 13 
				and hhid."HouseholdID" = hh."HouseholdID" and hhid."ActiveHHType" = hh."HHType"
				and hhid."Active" = B'1' 
			 order by hhid."ExitDate" DESC limit 1);

	update lsa."tlsa_Household"
	set "PSHDestination" = 
		case when hh."PSHStatus" not in (12,22) then -1
			 else hhid."ExitDest" end
		, "Step" = '6.7.3'
	from lsa."tlsa_Household" hh 
	inner join lsa."tlsa_HHID" hhid on hhid."HouseholdID" = hh."HouseholdID"
		and hhid."ActiveHHType" = hh."HHType" and hhid."Active" = B'1' 
	where hh."PSHStatus" not in (12,22)  
		or hhid."EnrollmentID" in 
			(select hhid."EnrollmentID" 
			 from lsa."tlsa_HHID" hhid
			 where hhid."ProjectType" = 3 
				and hhid."HouseholdID" = hh."HouseholdID" and hhid."ActiveHHType" = hh."HHType"
				and hhid."Active" = B'1' 
			 order by hhid."ExitDate" DESC limit 1);

/*
	6.8	EST/RRH/PSH Population Identifiers for LSAHousehold
*/

	update lsa."tlsa_Household" 
	set "ESTAC3Plus" = coalesce (
			(select max(hhid."AC3Plus")
			 from lsa."tlsa_HHID" hhid 
			 where hhid."Active" = B'1'  and hhid."ActiveHHType" = hh."HHType" and hhid."HouseholdID" = hh."HouseholdID"
				and hhid."ProjectType" in (1,2,8)), 0)
		, "ESTVet" = coalesce (
			(select max(hhid."HHVet")
			 from lsa."tlsa_HHID" hhid 
			 where hhid."Active" = B'1'  and hhid."ActiveHHType" = hh."HHType" and hhid."HouseholdID" = hh."HouseholdID"
				and hhid."ProjectType" in (1,2,8)), 0)
		, "ESTChronic" = coalesce (
			(select max(hhid."HHChronic")
			 from lsa."tlsa_HHID" hhid 
			 where hhid."Active" = B'1'  and hhid."ActiveHHType" = hh."HHType" and hhid."HouseholdID" = hh."HouseholdID"
				and hhid."ProjectType" in (1,2,8)), 0)
		, "ESTDisability" = coalesce (
			(select max(hhid."HHDisability")
			 from lsa."tlsa_HHID" hhid 
			 where hhid."Active" = B'1'  and hhid."ActiveHHType" = hh."HHType" and hhid."HouseholdID" = hh."HouseholdID"
				and hhid."ProjectType" in (1,2,8)), 0)
		, "ESTFleeingDV" = coalesce (
			(select max(hhid."HHFleeingDV")
			 from lsa."tlsa_HHID" hhid 
			 where hhid."Active" = B'1'  and hhid."ActiveHHType" = hh."HHType" and hhid."HouseholdID" = hh."HouseholdID"
				and hhid."ProjectType" in (1,2,8)), 0)
		, "ESTParent" = coalesce (
			(select max(hhid."HHParent")
			 from lsa."tlsa_HHID" hhid 
			 where hhid."Active" = B'1'  and hhid."ActiveHHType" = hh."HHType" and hhid."HouseholdID" = hh."HouseholdID"
				and hhid."ProjectType" in (1,2,8)), 0)
		, "ESTAdultAge" = coalesce (hh18."HHAdultAge",
			hh24."HHAdultAge",
			hh55."HHAdultAge",
			hh25."HHAdultAge",
			-1)
		, "Step" = '6.8.1'
	from lsa."tlsa_Household" hh
	left outer join lsa."tlsa_HHID" hh18 on hh18."HHAdultAge" = 18 
		and hh18."HouseholdID" = hh."HouseholdID" and hh18."ActiveHHType" = hh."HHType"
		and hh18."Active" = B'1'  and hh18."ProjectType" in (1,2,8)
	left outer join lsa."tlsa_HHID" hh24 on hh24."HHAdultAge" = 24 
		and hh24."HouseholdID" = hh."HouseholdID" and hh24."ActiveHHType" = hh."HHType"		
		and hh24."Active" = B'1'  and hh24."ProjectType" in (1,2,8)
	left outer join lsa."tlsa_HHID" hh55 on hh55."HHAdultAge" = 55 
		and hh55."HouseholdID" = hh."HouseholdID" and hh55."ActiveHHType" = hh."HHType"
		and hh55."Active" = B'1'  and hh55."ProjectType" in (1,2,8)
	left outer join lsa."tlsa_HHID" hh25 on hh25."HHAdultAge" = 25 
		and hh25."Active" = B'1'  and hh25."HouseholdID" = hh."HouseholdID" and hh25."ActiveHHType" = hh."HHType"
		and hh25."ProjectType" in (1,2,8);


	update lsa."tlsa_Household" 
	set "RRHAC3Plus" = coalesce (
			(select max(hhid."AC3Plus")
			 from lsa."tlsa_HHID" hhid 
			 where hhid."Active" = B'1'  and hhid."ActiveHHType" = hh."HHType" and hhid."HouseholdID" = hh."HouseholdID"
				and hhid."ProjectType" = 13), 0)
		, "RRHVet" = coalesce (
			(select max(hhid."HHVet")
			 from lsa."tlsa_HHID" hhid 
			 where hhid."Active" = B'1'  and hhid."ActiveHHType" = hh."HHType" and hhid."HouseholdID" = hh."HouseholdID"
				and hhid."ProjectType" = 13), 0)
		, "RRHChronic" = coalesce (
			(select max(hhid."HHChronic")
			 from lsa."tlsa_HHID" hhid 
			 where hhid."Active" = B'1'  and hhid."ActiveHHType" = hh."HHType" and hhid."HouseholdID" = hh."HouseholdID"
				and hhid."ProjectType" = 13), 0)
		, "RRHDisability" = coalesce (
			(select max(hhid."HHDisability")
			 from lsa."tlsa_HHID" hhid 
			 where hhid."Active" = B'1'  and hhid."ActiveHHType" = hh."HHType" and hhid."HouseholdID" = hh."HouseholdID"
				and hhid."ProjectType" = 13), 0)
		, "RRHFleeingDV" = coalesce (
			(select max(hhid."HHFleeingDV")
			 from lsa."tlsa_HHID" hhid 
			 where hhid."Active" = B'1'  and hhid."ActiveHHType" = hh."HHType" and hhid."HouseholdID" = hh."HouseholdID"
				and hhid."ProjectType" = 13), 0)
		, "RRHParent" = coalesce (
			(select max(hhid."HHParent")
			 from lsa."tlsa_HHID" hhid 
			 where hhid."Active" = B'1'  and hhid."ActiveHHType" = hh."HHType" and hhid."HouseholdID" = hh."HouseholdID"
				and hhid."ProjectType" = 13), 0)
		, "RRHAdultAge" = coalesce (hh18."HHAdultAge",
			hh24."HHAdultAge",
			hh55."HHAdultAge",
			hh25."HHAdultAge",
			-1)
		, "Step" = '6.8.2'
	from lsa."tlsa_Household" hh
	left outer join lsa."tlsa_HHID" hh18 on hh18."HHAdultAge" = 18 
		and hh18."HouseholdID" = hh."HouseholdID" and hh18."ActiveHHType" = hh."HHType"
		and hh18."Active" = B'1'  and hh18."ProjectType" = 13
	left outer join lsa."tlsa_HHID" hh24 on hh24."HHAdultAge" = 24 
		and hh24."HouseholdID" = hh."HouseholdID" and hh24."ActiveHHType" = hh."HHType"		
		and hh24."Active" = B'1'  and hh24."ProjectType" = 13
	left outer join lsa."tlsa_HHID" hh55 on hh55."HHAdultAge" = 55 
		and hh55."HouseholdID" = hh."HouseholdID" and hh55."ActiveHHType" = hh."HHType"
		and hh55."Active" = B'1'  and hh55."ProjectType" = 13
	left outer join lsa."tlsa_HHID" hh25 on hh25."HHAdultAge" = 25 
		and hh25."Active" = B'1'  and hh25."HouseholdID" = hh."HouseholdID" and hh25."ActiveHHType" = hh."HHType"
		and hh25."ProjectType" = 13;

	update lsa."tlsa_Household" 
	set "PSHAC3Plus" = coalesce (
			(select max(hhid."AC3Plus")
			 from lsa."tlsa_HHID" hhid 
			 where hhid."Active" = B'1'  and hhid."ActiveHHType" = hh."HHType" and hhid."HouseholdID" = hh."HouseholdID"
				and hhid."ProjectType" = 3), 0)
		, "PSHVet" = coalesce (
			(select max(hhid."HHVet")
			 from lsa."tlsa_HHID" hhid 
			 where hhid."Active" = B'1'  and hhid."ActiveHHType" = hh."HHType" and hhid."HouseholdID" = hh."HouseholdID"
				and hhid."ProjectType" = 3), 0)
		, "PSHChronic" = coalesce (
			(select max(hhid."HHChronic")
			 from lsa."tlsa_HHID" hhid 
			 where hhid."Active" = B'1'  and hhid."ActiveHHType" = hh."HHType" and hhid."HouseholdID" = hh."HouseholdID"
				and hhid."ProjectType" = 3), 0)
		, "PSHDisability" = coalesce (
			(select max(hhid."HHDisability")
			 from lsa."tlsa_HHID" hhid 
			 where hhid."Active" = B'1'  and hhid."ActiveHHType" = hh."HHType" and hhid."HouseholdID" = hh."HouseholdID"
				and hhid."ProjectType" = 3), 0)
		, "PSHFleeingDV" = coalesce (
			(select max(hhid."HHFleeingDV")
			 from lsa."tlsa_HHID" hhid 
			 where hhid."Active" = B'1'  and hhid."ActiveHHType" = hh."HHType" and hhid."HouseholdID" = hh."HouseholdID"
				and hhid."ProjectType" = 3), 0)
		, "PSHParent" = coalesce (
			(select max(hhid."HHParent")
			 from lsa."tlsa_HHID" hhid 
			 where hhid."Active" = B'1'  and hhid."ActiveHHType" = hh."HHType" and hhid."HouseholdID" = hh."HouseholdID"
				and hhid."ProjectType" = 3), 0)
		, "PSHAdultAge" = coalesce (hh18."HHAdultAge",
			hh24."HHAdultAge",
			hh55."HHAdultAge",
			hh25."HHAdultAge",
			-1)
		, "Step" = '6.8.3'
	from lsa."tlsa_Household" hh
	left outer join lsa."tlsa_HHID" hh18 on hh18."HHAdultAge" = 18 
		and hh18."HouseholdID" = hh."HouseholdID" and hh18."ActiveHHType" = hh."HHType"
		and hh18."Active" = B'1'  and hh18."ProjectType" = 3
	left outer join lsa."tlsa_HHID" hh24 on hh24."HHAdultAge" = 24 
		and hh24."HouseholdID" = hh."HouseholdID" and hh24."ActiveHHType" = hh."HHType"		
		and hh24."Active" = B'1'  and hh24."ProjectType" = 3
	left outer join lsa."tlsa_HHID" hh55 on hh55."HHAdultAge" = 55 
		and hh55."HouseholdID" = hh."HouseholdID" and hh55."ActiveHHType" = hh."HHType"
		and hh55."Active" = B'1'  and hh55."ProjectType" = 3
	left outer join lsa."tlsa_HHID" hh25 on hh25."HHAdultAge" = 25 
		and hh25."Active" = B'1'  and hh25."HouseholdID" = hh."HouseholdID" and hh25."ActiveHHType" = hh."HHType"
		and hh25."ProjectType" = 3;

/*
	6.9	System Engagement Status and Return Time 
*/

	update lsa."tlsa_Household"
	set "FirstEntry" = (select min(hhid."EntryDate")
		from lsa."tlsa_HHID" hhid
		where hhid."Active" = B'1'  and hhid."HouseholdID" = hh."HouseholdID" and hhid."ActiveHHType" = hh."HHType")
		, "Step" = '6.9.1'
	from lsa."tlsa_Household" hh;

	update lsa."tlsa_Household"
	set "StatEnrollmentID" = 
	  (select prior."EnrollmentID"
		from lsa."tlsa_HHID" prior 
		inner join lsa."lsa_Report" rpt on rpt."ReportStart" > prior."ExitDate"
		where prior."ExitDate" >= dateadd ('d',-730,hh."FirstEntry") 
			and prior."HouseholdID" = hh."HouseholdID" and prior."ActiveHHType" = hh."HHType"
		order by prior."ExitDate" DESC limit 1)
		, "Step" = '6.9.2'
	from lsa."tlsa_Household" hh;  
	
	update lsa."tlsa_Household"
	set "Stat" = case 
			when hh."PSHStatus" in (11,12) or hh."RRHStatus" in (11,12) or hh."ESTStatus" in (11,12)
				then 5
			when hh."StatEnrollmentID" is null then 1
			when dateadd('d', 15, prior."ExitDate") >= hh."FirstEntry" then 5 
			when prior."ExitDest" between 1 and 6 then 2
			when prior."ExitDest" between 7 and 14 then 3
			else 4 end  
		, "ReturnTime" = case 
			when hh."PSHStatus" in (11,12) or hh."RRHStatus" in (11,12) or hh."ESTStatus" in (11,12) 
				or hh."StatEnrollmentID" is null 
				or dateadd('d', 15, prior."ExitDate") >= hh."FirstEntry" then -1
			else DATE_PART('day', hh."FirstEntry"::timestamp - prior."ExitDate"::timestamp ) end
		, "Step" = '6.9.3'
	from lsa."tlsa_Household" hh
	left outer join lsa."tlsa_HHID" prior on prior."EnrollmentID" = hh."StatEnrollmentID" ;

/*
	6.10 Get Days In RRH Pre-Move-In
*/
	update lsa."tlsa_Household"
	set "RRHPreMoveInDays" = (select count(distinct cal."theDate")
			from lsa."tlsa_HHID" hhid 
			inner join lsa."lsa_Report" rpt on rpt."ReportEnd" >= hhid."EntryDate"
			inner join lsa."ref_Calendar" cal on cal."theDate" >= hhid."EntryDate"
				and cal."theDate" <= coalesce(
						  dateadd('d', -1, hhid."MoveInDate")
						, dateadd('d', -1, hhid."ExitDate")
						, rpt."ReportEnd")
			where hhid."ProjectType" = 13 
				and hhid."ActiveHHType" = hh."HHType" and hhid."HouseholdID" = hh."HouseholdID"
				and hhid."Active" = B'1' ) 
		, "Step" = '6.10'
	from lsa."tlsa_Household" hh;

/*
	6.11 Get Dates Housed in PSH or RRH
*/
	delete from lsa."sys_Time";

	insert into lsa."sys_Time" ("HouseholdID", "HHType", "sysDate", "sysStatus", "Step")
	select distinct hhid."HouseholdID", hhid."ActiveHHType", cal."theDate"
		, min(case hhid."ProjectType"
				when 3 then 1
				else 2 end)
		, '6.11'
	from lsa."tlsa_HHID" hhid
	inner join lsa."lsa_Report" rpt on rpt."ReportEnd" >= hhid."EntryDate"
	inner join lsa."ref_Calendar" cal on cal."theDate" >= hhid."MoveInDate"
		and (cal."theDate" < hhid."ExitDate" 
				or (hhid."ExitDate" is null and cal."theDate" <= rpt."ReportEnd"))
	where hhid."ProjectType" in (3,13) and hhid."Active" = B'1' 
	group by hhid."HouseholdID", hhid."ActiveHHType", cal."theDate";
/*
	6.12  Get Last Inactive Date
*/

	--"LastInactive" = ("FirstEntry" - 1 day) for any household where "Stat" <> 5
	--  and for any household where "Stat" = 5 but there is no enrollment for the "HouseholdID"/"HHType"
	--  active in the six days prior to First Entry. 
update lsa."tlsa_Household"
set "LastInactive" = case 
			when dateadd('d', -1, hh."FirstEntry") < '2012-09-30' then '2012-09-30'
			else  dateadd('d', -1, hh."FirstEntry") end
		, "Step" = '6.12.1'
	from lsa."tlsa_Household" hh 
	where hh."Stat" <> 5 
		or (select hhid."EnrollmentID" 
			from lsa."tlsa_HHID" hhid
			inner join lsa."lsa_Report" rpt on hhid."ExitDate" < rpt."ReportStart"
			where hhid."HouseholdID" = hh."HouseholdID" and hhid."ActiveHHType" = hh."HHType" 
			and dateadd('d', 6, hhid."ExitDate") >= hh."FirstEntry" limit 1) is null;

		insert into lsa."sys_TimePadded" ("HouseholdID", "HHType", "Cohort", "StartDate", "EndDate", "Step")
	select distinct hh."HouseholdID", hh."HHType", 1
		, hhid."EntryDate"	
		, case when hhid."ExitDate" is null then rpt."ReportEnd" 
			else dateadd('d', 6, hhid."ExitDate") end
		, '6.12.2.a'
	from lsa."tlsa_Household" hh
	inner join lsa."lsa_Report" rpt on rpt."ReportStart" >= hh."FirstEntry"
	inner join lsa."tlsa_HHID" hhid on hhid."HouseholdID" = hh."HouseholdID" and hhid."ActiveHHType" = hh."HHType"
		and (hhid."Active" = B'1'  or hhid."ExitDate" < rpt."ReportStart") 
	where hh."LastInactive" is null 
		and hh."PSHMoveIn" <> 2
		and hhid."TrackingMethod" <> 3
	union
	select distinct hh."HouseholdID", hh."HHType", 1
		, bn.DateProvided	
		, dateadd('d', 6, bn.dateprovided::date)
		, '6.12.2.b'
	from lsa."tlsa_Household" hh
	inner join lsa."lsa_Report" rpt on rpt."ReportStart" >= hh."FirstEntry"
	inner join lsa."tlsa_HHID" hhid on hhid."HouseholdID" = hh."HouseholdID" and hhid."ActiveHHType" = hh."HHType"
		and (hhid."Active" = B'1'  or hhid."ExitDate" < rpt."ReportStart") 
	inner join v2020.service_fa_referral bn on CAST (bn."enrollmentid" AS varchar)= hhid."EnrollmentID" 

		and bn.dateprovided between '2012-01-10' and rpt."ReportEnd"
		and bn.dateprovided >= hhid."EntryDate"
		and (bn.dateprovided < hhid."ExitDate" or hhid."ExitDate" is null)
		-- 5/14/2020 correct "DateDeleted" = 0" to "DateDeleted" is null"
		and bn.record_type = '200' and bn.deleted is false and bn.parent_id is null
	where hh."LastInactive" is null 
		and hh."PSHMoveIn" <> 2
		and hhid."TrackingMethod" = 3;
		
	update lsa."tlsa_Household"
	set "LastInactive" = coalesce(lastDay.inactive, '2012-09-30')
		,"Step" = '6.12.3'
	from lsa."tlsa_Household" hh
	left outer join 
		(select hh."HouseholdID", hh."HHType", max(cal."theDate") as inactive
		  from lsa."tlsa_Household" hh
		  inner join lsa."lsa_Report" rpt on rpt."ReportID" = hh."ReportID"
		  inner join lsa."ref_Calendar" cal on cal."theDate" <= rpt."ReportEnd"
			and cal."theDate" >= '2012-10-1'
		  left outer join
			 lsa."sys_TimePadded" stp on stp."HouseholdID" = hh."HouseholdID" and stp."HHType" = hh."HHType"
			  and cal."theDate" between stp."StartDate" and stp."EndDate"
		  where stp."HouseholdID" is null
			and cal."theDate" < hh."FirstEntry"
		group by hh."HouseholdID", hh."HHType"
	  ) lastDay on lastDay."HouseholdID" = hh."HouseholdID" and lastDay."HHType" = hh."HHType"
	where hh."LastInactive" is null;

/*
	6.13 Get Dates of Other System Use
*/
	--Transitional Housing and Entry/Exit ES ("sysStatus" = 3 and 4)
	insert into lsa."sys_Time" ("HouseholdID", "HHType", "sysDate", "sysStatus", "Step")
	select distinct hh."HouseholdID", hh."HHType", cal."theDate"
		, min(case when hhid."ProjectType" = 2 then 3 else 4 end)
		, '6.13.1'
	from lsa."tlsa_Household" hh 
	inner join lsa."tlsa_HHID" hhid on hhid."HouseholdID" = hh."HouseholdID" and hhid."ActiveHHType" = hh."HHType"
		and hhid."EntryDate" > hh."LastInactive" 
	inner join lsa."lsa_Report" rpt on rpt."ReportEnd" >= hhid."EntryDate"
	inner join lsa."ref_Calendar" cal on 
		cal."theDate" >= hhid."EntryDate"
		and cal."theDate" <= coalesce(dateadd('d', -1, hhid."ExitDate"), rpt."ReportEnd")
	left outer join lsa."sys_Time" housed on housed."HouseholdID" = hh."HouseholdID" and housed."HHType" = hh."HHType"
		and housed."sysDate" = cal."theDate"
	where housed."sysDate" is null 
		and (hhid."ProjectType" = 2 or (hhid."ProjectType" = 1 and hhid."TrackingMethod" = 0))
	group by hh."HouseholdID", hh."HHType", cal."theDate";

	--Emergency Shelter (Night-by-Night) ("sysStatus" = 4)
	insert into lsa."sys_Time" ("HouseholdID", "HHType", "sysDate", "sysStatus", "Step")
	select distinct hh."HouseholdID", hh."HHType", cal."theDate", 4
		, '6.13.2'
	from lsa."tlsa_Household" hh 
	inner join lsa."tlsa_HHID" hhid on hhid."HouseholdID" = hh."HouseholdID" and hhid."ActiveHHType" = hh."HHType"
		and hhid."EntryDate" > hh."LastInactive" 
	inner join lsa."lsa_Report" rpt on rpt."ReportEnd" >= hhid."EntryDate"
	inner join v2020.service_fa_referral bn on CAST (bn."enrollmentid" AS varchar) = hhid."EnrollmentID"
		and bn.record_type = '200' and bn.deleted is false and bn.parent_id is null
	inner join lsa."ref_Calendar" cal on 
		cal."theDate" = bn.dateprovided
		and cal."theDate" between hhid."EntryDate" and coalesce(dateadd('d', -1, hhid."ExitDate"), rpt."ReportEnd")
	left outer join lsa."sys_Time" other on other."HouseholdID" = hh."HouseholdID" and other."HHType" = hh."HHType"
		and other."sysDate" = cal."theDate"
	where other."sysDate" is null and hhid."ProjectType" = 1 and hhid."TrackingMethod" = 3;
	
	--Homeless (Time prior to Move-In) in PSH and RRH ("sysStatus" = 5 and 6)
	insert into lsa."sys_Time" ("HouseholdID", "HHType", "sysDate", "sysStatus", "Step")
	select distinct hh."HouseholdID", hh."HHType", cal."theDate"
		, min (case when hhid."ProjectType" = 3 then 5 else 6 end)
		, '6.13.3'
	from lsa."tlsa_Household" hh 
	inner join lsa."tlsa_HHID" hhid on hhid."HouseholdID" = hh."HouseholdID" and hhid."ActiveHHType" = hh."HHType"
		and hhid."EntryDate" > hh."LastInactive" 
	inner join lsa."lsa_Report" rpt on rpt."ReportEnd" >= hhid."EntryDate"
	inner join lsa."ref_Calendar" cal on 
		cal."theDate" >= hhid."EntryDate"
		and cal."theDate" <= coalesce(dateadd('d', -1, hhid."MoveInDate"), dateadd('d', -1, hhid."ExitDate"), rpt."ReportEnd")
	left outer join lsa."sys_Time" other on other."HouseholdID" = hh."HouseholdID" and other."HHType" = hh."HHType"
		and other."sysDate" = cal."theDate"
	where cal."theDate" > hh."LastInactive"
		and other."sysDate" is null and hhid."ProjectType" in (3,13)
	group by hh."HouseholdID", hh."HHType", cal."theDate";

/*
	6.14 Get Other Dates Homeless from 3.917 Living Situation
*/
	--If there are enrollments in sys_Enrollment where "EntryDate" >= "LastInactive",
	-- dates between the earliest DateToStreetESSH and "LastInactive" --
	-- i.e., dates without a potential status conflict based on other system use --
	-- populate "Other3917Days" as the difference in days between DateToStreetESSH
	-- and "LastInactive" + 1. 

	--NOTE:  This statement will leave "Other3917Days" NULL for households without
	--at least one DateToStreetESSH prior to "LastInactive".  Final value for "Other3917Days"
	--is the sum of days prior to "LastInactive" (if any) PLUS the count of dates 
	--added to lsa."sys_Time" in the next statement.  
	update lsa."tlsa_Household"
	set "Other3917Days" = (select DATE_PART ('day', hh."LastInactive"::timestamp-
			(select  hn.DateToStreetESSH
			from lsa."tlsa_HHID" hhid 
			inner join v2020.enrollment hn on CAST (hn."id" AS varchar) = hhid."EnrollmentID" and hn.deleted is false and hn.parent_id is null
			where hhid."HouseholdID" = hh."HouseholdID" and hhid."ActiveHHType" = hh."HHType"
				and hhid."EntryDate" > hh."LastInactive"
				and hn.datetostreetessh<= hh."LastInactive" 
				and (hhid."ProjectType" in (1,8)
					or hn."livingsituation" in ('1','18','16')
					or (hn."lengthofstay" in ('10','11') and hn."previousstreetessh" = '1')
					--5/14/2020 - correct 24 (deceased) to 25 (LTC/nursing home) 
					or (hn."livingsituation" in ('4','5','6','7','15','25') 
						and hn."lengthofstay" in ('2','3') and hn."previousstreetessh" = '1'))
			order by hn.datetostreetessh asc limit 1)::timestamp )+ 1)
		, "Step" = '6.14.1'
	from lsa."tlsa_Household" hh;

	insert into lsa."sys_Time" ("HouseholdID", "HHType", "sysDate", "sysStatus", "Step")
	select distinct hh."HouseholdID", hh."HHType", cal."theDate", 7
		, '6.14.2'
	from lsa."tlsa_Household" hh 
	inner join lsa."tlsa_HHID" hhid on hhid."HouseholdID" = hh."HouseholdID" and hhid."ActiveHHType" = hh."HHType"
		and hhid."EntryDate" > hh."LastInactive" 
	inner join v2020.enrollment hn on CAST (hn."id" AS varchar) = hhid."EnrollmentID" and hn.deleted is false and hn.parent_id is null
	inner join lsa."lsa_Report" rpt on rpt."ReportEnd" >= hhid."EntryDate" and rpt.project_group_code=hn.project_group_code
	inner join lsa."ref_Calendar" cal on 
		cal."theDate" >= hn.datetostreetessh
		and cal."theDate" < hn."entrydate"
	left outer join lsa."sys_Time" other on other."HouseholdID" = hh."HouseholdID" and other."HHType" = hh."HHType"
		and other."sysDate" = cal."theDate"
	where other."sysDate" is null and hhid."EnrollmentID" in 
			(select cast (hn."id" as varchar)
			from lsa."tlsa_HHID" hhid 
			inner join v2020.enrollment hn on cast (hn."id" as varchar) = hhid."EnrollmentID"
			where hhid."HouseholdID" = hh."HouseholdID" and hhid."ActiveHHType" = hh."HHType"
				and hhid."EntryDate" > hh."LastInactive" and hn.deleted is false and hn.parent_id is null
				and hn.datetostreetessh<= hh."LastInactive" 
				and (hhid."ProjectType" in ('1','8')
					or hn."livingsituation" in ('1','18','16')
					or (hn."lengthofstay" in ('10','11') and hn."previousstreetessh" = '1')
					--5/21/2020 - correct 24 (deceased) to 25 (LTC/nursing home) 
					or (hn."livingsituation" in ('4','5','6','7','15','25') 
						and hn."lengthofstay" in ('2','3') and hn."previousstreetessh" = '1'))
			order by hn.datetostreetessh asc limit 1);

/*
	6.15 Set System Use Days for LSAHousehold
*/
	update lsa."tlsa_Household"
	set "ESDays" = (select count(distinct st."sysDate")
			from lsa."sys_Time" st 
			where st."sysStatus" = 4
			and st."HouseholdID" = hh."HouseholdID" and st."HHType" = hh."HHType")
		, "THDays" = (select count(distinct st."sysDate")
			from lsa."sys_Time" st 
			where st."sysStatus" = 3
			and st."HouseholdID" = hh."HouseholdID" and st."HHType" = hh."HHType")
		, "ESTDays" = (select count(distinct st."sysDate")
			from lsa."sys_Time" st 
			where st."sysStatus" in (3,4)
			and st."HouseholdID" = hh."HouseholdID" and st."HHType" = hh."HHType")
		, "RRHPSHPreMoveInDays" = (select count(distinct st."sysDate")
			from lsa."sys_Time" st 
			where st."sysStatus" in (5,6)
			and st."HouseholdID" = hh."HouseholdID" and st."HHType" = hh."HHType")
		, "RRHHousedDays" = (select count(distinct st."sysDate")
			from lsa."sys_Time" st 
			where st."sysStatus" = 2
			and st."HouseholdID" = hh."HouseholdID" and st."HHType" = hh."HHType")
		, "SystemDaysNotPSHHoused" = (select count(distinct st."sysDate")
			from lsa."sys_Time" st 
			where st."sysStatus" in (2,3,4,5,6)
			and st."HouseholdID" = hh."HouseholdID" and st."HHType" = hh."HHType")
		, "SystemHomelessDays" = (select count(distinct st."sysDate")
			from lsa."sys_Time" st 
			where st."sysStatus" in (3,4,5,6)
			and st."HouseholdID" = hh."HouseholdID" and st."HHType" = hh."HHType")
		, "Other3917Days" = case 
				when hh."Other3917Days" is null then 0 
				else hh."Other3917Days" end 
				+ (select count(distinct st."sysDate")
					from lsa."sys_Time" st 
					where st."sysStatus" = 7
					and st."HouseholdID" = hh."HouseholdID" and st."HHType" = hh."HHType")
		, "TotalHomelessDays" = case 
				when hh."Other3917Days" is null then 0 
				else hh."Other3917Days" end + (select count(distinct st."sysDate")
			from lsa."sys_Time" st 
			where st."sysStatus" in (3,4,5,6,7)
			and st."HouseholdID" = hh."HouseholdID" and st."HHType" = hh."HHType")
		, "PSHHousedDays" = (select count(distinct st."sysDate")
			from lsa."sys_Time" st 
			where st."sysStatus" = 1
			and st."HouseholdID" = hh."HouseholdID" and st."HHType" = hh."HHType")
		, "Step" = '6.15'
	from lsa."tlsa_Household" hh;

/*
	6.16 Update "ESTStatus" and "RRHStatus"
*/

	update lsa."tlsa_Household"
	set "ESTStatus" = 2
		, "Step" = '6.16.1'
	from lsa."tlsa_Household" hh
	inner join lsa."sys_Time" st on st."HouseholdID" = hh."HouseholdID" and st."HHType" = hh."HHType"
	where hh."ESTStatus" = 0 
		and st."sysStatus" in (3,4) ;

	update lsa."tlsa_Household"
	set "RRHStatus" = 2
		, "Step" = '6.16.2'
	from lsa."tlsa_Household" hh
	inner join lsa."sys_Time" st on st."HouseholdID" = hh."HouseholdID" and st."HHType" = hh."HHType"
	where hh."RRHStatus" = 0 
		and st."sysStatus" = 6;

	update lsa."tlsa_Household"
	set "PSHStatus" = 2
		, "Step" = '6.16.3'
	from lsa."tlsa_Household" hh
	inner join lsa."sys_Time" st on st."HouseholdID" = hh."HouseholdID" and st."HHType" = hh."HHType"
	where hh."PSHStatus" = 0 
		and st."sysStatus" = 5;

/*
	6.17 Set EST/RRH/"PSHAHAR"
*/
	update lsa."tlsa_Household"
	set "ESTAHAR" = 0, "RRHAHAR" = 0, "PSHAHAR" = 0
		, "Step" = '6.17.1'
	from lsa."tlsa_Household" hh;

	update lsa."tlsa_Household"
	set "ESTAHAR" = 1
		, "Step" = '6.17.2'
	from lsa."tlsa_Household" hh
	inner join lsa."sys_Time" st on st."HouseholdID" = hh."HouseholdID" and st."HHType" = hh."HHType"
	inner join lsa."lsa_Report" rpt on st."sysDate" between rpt."ReportStart" and rpt."ReportEnd" 
		and st."sysStatus" in (3,4); 

	update lsa."tlsa_Household"
	set "RRHAHAR" = 1
		,"Step" = '6.17.3'
	from lsa."tlsa_Household" hh
	inner join lsa."sys_Time" st on st."HouseholdID" = hh."HouseholdID" and st."HHType" = hh."HHType"
	inner join lsa."lsa_Report" rpt on st."sysDate" between rpt."ReportStart" and rpt."ReportEnd" 
		and st."sysStatus" = 2 ;

	update lsa."tlsa_Household"
	set "PSHAHAR" = 1
		, "Step" = '6.17.4'
	from lsa."tlsa_Household" hh
	inner join lsa."sys_Time" st on st."HouseholdID" = hh."HouseholdID" and st."HHType" = hh."HHType"
	inner join lsa."lsa_Report" rpt on st."sysDate" between rpt."ReportStart" and rpt."ReportEnd" 
		and st."sysStatus" = 1;

/*
	6.18 Set "SystemPath" for LSAHousehold
*/

update lsa."tlsa_Household"
set "SystemPath" = 
	case when hh."ESTStatus" not in (21,22) and hh."RRHStatus" not in (21,22) and hh."PSHMoveIn" = 2 
		then -1
	when hh."ESDays" >= 1 and hh."THDays" = 0 and hh."RRHStatus" = 0 and hh."PSHStatus" = 0 
		then 1
	when hh."ESDays" = 0 and hh."THDays" >= 1 and hh."RRHStatus" = 0 and hh."PSHStatus" = 0 
		then 2
	when hh."ESDays" >= 1 and hh."THDays" >= 1 and hh."RRHStatus" = 0 and hh."PSHStatus" = 0 
		then 3
	when hh."ESTStatus" = 0 and hh."RRHStatus" >= 11 and hh."PSHStatus" = 0 
		then 4
	when hh."ESDays" >= 1 and hh."THDays" = 0 and hh."RRHStatus" >= 2 and hh."PSHStatus" = 0 
		then 5
	when hh."ESDays" = 0 and hh."THDays" >= 1 and hh."RRHStatus" >= 2 and hh."PSHStatus" = 0 
		then 6
	when hh."ESDays" >= 1 and hh."THDays" >= 1 and hh."RRHStatus" >= 2 and hh."PSHStatus" = 0 
		then 7
	when hh."ESTStatus" = 0 and hh."RRHStatus" = 0 and hh."PSHStatus" >= 11 and hh."PSHMoveIn" <> 2
		then 8
	when hh."ESDays" >= 1 and hh."THDays" = 0 and hh."RRHStatus" = 0 and hh."PSHStatus" >= 11 and hh."PSHMoveIn" <> 2
		then 9
	when hh."ESTStatus" in (21,22) and hh."ESDays" >= 1 and hh."THDays" = 0 and hh."RRHStatus" = 0 and hh."PSHStatus" >= 11 and hh."PSHMoveIn" = 2
		then 9
	when hh."ESDays" >= 1 and hh."THDays" <= 0 and hh."RRHStatus" >= 2 and hh."PSHStatus" >= 11 and hh."PSHMoveIn" <> 2
		then 10
	when hh."ESTStatus" in (21,22) and hh."ESDays" >= 1 and hh."THDays" = 0 and hh."RRHStatus" in (21,22) and hh."PSHStatus" >= 11 and hh."PSHMoveIn" = 2
		then 10
	when hh."ESTStatus" = 0 and hh."RRHStatus" >= 2 and hh."PSHStatus" >= 11 and hh."PSHMoveIn" <> 2
		then 11
	when hh."ESTStatus" = 0 and hh."RRHStatus" in (21,22) and hh."PSHStatus" >= 11 and hh."PSHMoveIn" = 2
		then 11
	else 12 end
	, "Step" = '6.18'
from lsa."tlsa_Household" hh;

/*
	6.19 LSAHousehold
*/

delete from lsa."lsa_Household";
insert into lsa."lsa_Household"("RowTotal"
	, "Stat", "ReturnTime"
	, "HHType", "HHChronic", "HHVet", "HHDisability", "HHFleeingDV", "HoHRace", "HoHEthnicity"
	, "HHAdult", "HHChild", "HHNoDOB"
	, "HHAdultAge", "HHParent"
	, "ESTStatus", "ESTGeography", "ESTLivingSit", "ESTDestination", "ESTChronic", "ESTVet", "ESTDisability", "ESTFleeingDV", "ESTAC3Plus", "ESTAdultAge", "ESTParent"
	, "RRHStatus", "RRHMoveIn", "RRHGeography", "RRHLivingSit", "RRHDestination", "RRHPreMoveInDays", "RRHChronic", "RRHVet", "RRHDisability", "RRHFleeingDV", "RRHAC3Plus", "RRHAdultAge", "RRHParent"
	, "PSHStatus", "PSHMoveIn", "PSHGeography", "PSHLivingSit", "PSHDestination", "PSHHousedDays", "PSHChronic", "PSHVet", "PSHDisability", "PSHFleeingDV", "PSHAC3Plus", "PSHAdultAge", "PSHParent"
	, "ESDays", "THDays", "ESTDays", "RRHPSHPreMoveInDays", "RRHHousedDays", "SystemDaysNotPSHHoused", "SystemHomelessDays", "Other3917Days", "TotalHomelessDays"
	, "SystemPath", "ESTAHAR", "RRHAHAR", "PSHAHAR", "ReportID" 
)
select count (distinct "HouseholdID" || cast("HHType" as varchar)), "Stat"
	, case when "Stat" in (1,5) then -1
		when "ReturnTime" between 15 and 30 then 30
		when "ReturnTime" between 31 and 60 then 60
		when "ReturnTime" between 61 and 90 then 90
		when "ReturnTime" between 91 and 180 then 180
		when "ReturnTime" between 181 and 365 then 365
		when "ReturnTime" between 366 and 547 then 547
		when "ReturnTime" >= 548 then 730
		else "ReturnTime" end
	, "HHType", "HHChronic", "HHVet", "HHDisability", "HHFleeingDV", "HoHRace", "HoHEthnicity"
	, "HHAdult", "HHChild", "HHNoDOB"
	, "HHAdultAge", "HHParent"
	, "ESTStatus", "ESTGeography", "ESTLivingSit", "ESTDestination", "ESTChronic", "ESTVet", "ESTDisability", "ESTFleeingDV", "ESTAC3Plus", "ESTAdultAge", "ESTParent"
	, "RRHStatus", "RRHMoveIn", "RRHGeography", "RRHLivingSit", "RRHDestination" 	
	, case when "RRHPreMoveInDays" between 1 and 7 then 7
		when "RRHPreMoveInDays" between 8 and 30 then 30 
		when "RRHPreMoveInDays" between 31 and 60 then 60 
		when "RRHPreMoveInDays" between 61 and 90 then 90 
		when "RRHPreMoveInDays" between 91 and 180 then 180 
		when "RRHPreMoveInDays" between 181 and 365 then 365 
		when "RRHPreMoveInDays" between 366 and 547 then 547 
		when "RRHPreMoveInDays" between 548 and 730 then 730 
		when "RRHPreMoveInDays" between 731 and 1094 then 1094 
		when "RRHPreMoveInDays" > 1094 then 1095
		else "RRHPreMoveInDays" end 
	, "RRHChronic", "RRHVet", "RRHDisability", "RRHFleeingDV", "RRHAC3Plus", "RRHAdultAge", "RRHParent"
	, "PSHStatus", "PSHMoveIn", "PSHGeography", "PSHLivingSit", "PSHDestination"	
	--NOTE:  Groupings for "PSHHousedDays" differ from all other xDays columns
	, case when "PSHHousedDays" between 1 and 90 then 3
		when "PSHHousedDays" between 91 and 180 then 6 
		when "PSHHousedDays" between 181 and 365 then 12 
		when "PSHHousedDays" between 366 and 730 then 24 
		when "PSHHousedDays" between 731 and 1095 then 36 
		when "PSHHousedDays" between 1096 and 1460 then 48 
		when "PSHHousedDays" between 1461 and 1825 then 60 
		when "PSHHousedDays" between 1826 and 2555 then 84 
		when "PSHHousedDays" between 2556 and 3650 then 120 
		when "PSHHousedDays" > 3650 then 121
		else "PSHHousedDays" end 
, "PSHChronic", "PSHVet", "PSHDisability", "PSHFleeingDV", "PSHAC3Plus", "PSHAdultAge", "PSHParent"
	, case when "ESDays" between 1 and 7 then 7
		when "ESDays" between 8 and 30 then 30 
		when "ESDays" between 31 and 60 then 60 
		when "ESDays" between 61 and 90 then 90 
		when "ESDays" between 91 and 180 then 180 
		when "ESDays" between 181 and 365 then 365 
		when "ESDays" between 366 and 547 then 547 
		when "ESDays" between 548 and 730 then 730 
		when "ESDays" between 731 and 1094 then 1094 
		when "ESDays" > 1094 then 1095
		else "ESDays" end 
	, case when "THDays" between 1 and 7 then 7
		when "THDays" between 8 and 30 then 30 
		when "THDays" between 31 and 60 then 60 
		when "THDays" between 61 and 90 then 90 
		when "THDays" between 91 and 180 then 180 
		when "THDays" between 181 and 365 then 365 
		when "THDays" between 366 and 547 then 547 
		when "THDays" between 548 and 730 then 730 
		when "THDays" between 731 and 1094 then 1094 
		when "THDays" > 1094 then 1095
		else "THDays" end 
	, case when "ESTDays" between 1 and 7 then 7
		when "ESTDays" between 8 and 30 then 30 
		when "ESTDays" between 31 and 60 then 60 
		when "ESTDays" between 61 and 90 then 90 
		when "ESTDays" between 91 and 180 then 180 
		when "ESTDays" between 181 and 365 then 365 
		when "ESTDays" between 366 and 547 then 547 
		when "ESTDays" between 548 and 730 then 730 
		when "ESTDays" between 731 and 1094 then 1094 
		when "ESTDays" > 1094 then 1095
		else "ESTDays" end 
	, case when "RRHPSHPreMoveInDays" between 1 and 7 then 7
		when "RRHPSHPreMoveInDays" between 8 and 30 then 30 
		when "RRHPSHPreMoveInDays" between 31 and 60 then 60 
		when "RRHPSHPreMoveInDays" between 61 and 90 then 90 
		when "RRHPSHPreMoveInDays" between 91 and 180 then 180 
		when "RRHPSHPreMoveInDays" between 181 and 365 then 365 
		when "RRHPSHPreMoveInDays" between 366 and 547 then 547 
		when "RRHPSHPreMoveInDays" between 548 and 730 then 730 
		when "RRHPSHPreMoveInDays" between 731 and 1094 then 1094 
		when "RRHPSHPreMoveInDays" > 1094 then 1095
		else "RRHPSHPreMoveInDays" end 
	, case when "RRHHousedDays" between 1 and 7 then 7
		when "RRHHousedDays" between 8 and 30 then 30 
		when "RRHHousedDays" between 31 and 60 then 60 
		when "RRHHousedDays" between 61 and 90 then 90 
		when "RRHHousedDays" between 91 and 180 then 180 
		when "RRHHousedDays" between 181 and 365 then 365 
		when "RRHHousedDays" between 366 and 547 then 547 
		when "RRHHousedDays" between 548 and 730 then 730 
		when "RRHHousedDays" between 731 and 1094 then 1094 
		when "RRHHousedDays" > 1094 then 1095
		else "RRHHousedDays" end 
	, case when "SystemDaysNotPSHHoused" between 1 and 7 then 7
		when "SystemDaysNotPSHHoused" between 8 and 30 then 30 
		when "SystemDaysNotPSHHoused" between 31 and 60 then 60 
		when "SystemDaysNotPSHHoused" between 61 and 90 then 90 
		when "SystemDaysNotPSHHoused" between 91 and 180 then 180 
		when "SystemDaysNotPSHHoused" between 181 and 365 then 365 
		when "SystemDaysNotPSHHoused" between 366 and 547 then 547 
		when "SystemDaysNotPSHHoused" between 548 and 730 then 730 
		when "SystemDaysNotPSHHoused" between 731 and 1094 then 1094 
		when "SystemDaysNotPSHHoused" > 1094 then 1095
		else "SystemDaysNotPSHHoused" end 
	, case when "SystemHomelessDays" between 1 and 7 then 7
		when "SystemHomelessDays" between 8 and 30 then 30 
		when "SystemHomelessDays" between 31 and 60 then 60 
		when "SystemHomelessDays" between 61 and 90 then 90 
		when "SystemHomelessDays" between 91 and 180 then 180 
		when "SystemHomelessDays" between 181 and 365 then 365 
		when "SystemHomelessDays" between 366 and 547 then 547 
		when "SystemHomelessDays" between 548 and 730 then 730 
		when "SystemHomelessDays" between 731 and 1094 then 1094 
		when "SystemHomelessDays" > 1094 then 1095
		else "SystemHomelessDays" end 
	, case when "Other3917Days" between 1 and 7 then 7
		when "Other3917Days" between 8 and 30 then 30 
		when "Other3917Days" between 31 and 60 then 60 
		when "Other3917Days" between 61 and 90 then 90 
		when "Other3917Days" between 91 and 180 then 180 
		when "Other3917Days" between 181 and 365 then 365 
		when "Other3917Days" between 366 and 547 then 547 
		when "Other3917Days" between 548 and 730 then 730 
		when "Other3917Days" between 731 and 1094 then 1094 
		when "Other3917Days" > 1094 then 1095
		else "Other3917Days" end 
	, case when "TotalHomelessDays" between 1 and 7 then 7
		when "TotalHomelessDays" between 8 and 30 then 30 
		when "TotalHomelessDays" between 31 and 60 then 60 
		when "TotalHomelessDays" between 61 and 90 then 90 
		when "TotalHomelessDays" between 91 and 180 then 180 
		when "TotalHomelessDays" between 181 and 365 then 365 
		when "TotalHomelessDays" between 366 and 547 then 547 
		when "TotalHomelessDays" between 548 and 730 then 730 
		when "TotalHomelessDays" between 731 and 1094 then 1094 
		when "TotalHomelessDays" > 1094 then 1095
		else "TotalHomelessDays" end 
	, "SystemPath", "ESTAHAR", "RRHAHAR", "PSHAHAR", "ReportID" 
from lsa."tlsa_Household"
group by "Stat"	
	, case when "Stat" in (1,5) then -1
		when "ReturnTime" between 15 and 30 then 30
		when "ReturnTime" between 31 and 60 then 60
		when "ReturnTime" between 61 and 90 then 90
		when "ReturnTime" between 91 and 180 then 180
		when "ReturnTime" between 181 and 365 then 365
		when "ReturnTime" between 366 and 547 then 547
		when "ReturnTime" >= 548 then 730
		else "ReturnTime" end
	, "HHType", "HHChronic", "HHVet", "HHDisability", "HHFleeingDV", "HoHRace", "HoHEthnicity"
	, "HHAdult", "HHChild", "HHNoDOB"
	, "HHAdultAge", "HHParent"
	, "ESTStatus", "ESTGeography", "ESTLivingSit", "ESTDestination", "ESTChronic", "ESTVet", "ESTDisability", "ESTFleeingDV", "ESTAC3Plus", "ESTAdultAge", "ESTParent"
	, "RRHStatus", "RRHMoveIn", "RRHGeography", "RRHLivingSit", "RRHDestination"	
	, case when "RRHPreMoveInDays" between 1 and 7 then 7
		when "RRHPreMoveInDays" between 8 and 30 then 30 
		when "RRHPreMoveInDays" between 31 and 60 then 60 
		when "RRHPreMoveInDays" between 61 and 90 then 90 
		when "RRHPreMoveInDays" between 91 and 180 then 180 
		when "RRHPreMoveInDays" between 181 and 365 then 365 
		when "RRHPreMoveInDays" between 366 and 547 then 547 
		when "RRHPreMoveInDays" between 548 and 730 then 730 
		when "RRHPreMoveInDays" between 731 and 1094 then 1094 
		when "RRHPreMoveInDays" > 1094 then 1095
		else "RRHPreMoveInDays" end 
	, "RRHChronic", "RRHVet", "RRHDisability", "RRHFleeingDV", "RRHAC3Plus", "RRHAdultAge", "RRHParent"
	, "PSHStatus", "PSHMoveIn", "PSHGeography", "PSHLivingSit", "PSHDestination"	
	, case when "PSHHousedDays" between 1 and 90 then 3
		when "PSHHousedDays" between 91 and 180 then 6 
		when "PSHHousedDays" between 181 and 365 then 12 
		when "PSHHousedDays" between 366 and 730 then 24 
		when "PSHHousedDays" between 731 and 1095 then 36 
		when "PSHHousedDays" between 1096 and 1460 then 48 
		when "PSHHousedDays" between 1461 and 1825 then 60 
		when "PSHHousedDays" between 1826 and 2555 then 84 
		when "PSHHousedDays" between 2556 and 3650 then 120 
		when "PSHHousedDays" > 3650 then 121
		else "PSHHousedDays" end 
, "PSHChronic", "PSHVet", "PSHDisability", "PSHFleeingDV", "PSHAC3Plus", "PSHAdultAge", "PSHParent"
	, case when "ESDays" between 1 and 7 then 7
		when "ESDays" between 8 and 30 then 30 
		when "ESDays" between 31 and 60 then 60 
		when "ESDays" between 61 and 90 then 90 
		when "ESDays" between 91 and 180 then 180 
		when "ESDays" between 181 and 365 then 365 
		when "ESDays" between 366 and 547 then 547 
		when "ESDays" between 548 and 730 then 730 
		when "ESDays" between 731 and 1094 then 1094 
		when "ESDays" > 1094 then 1095
		else "ESDays" end 
	, case when "THDays" between 1 and 7 then 7
		when "THDays" between 8 and 30 then 30 
		when "THDays" between 31 and 60 then 60 
		when "THDays" between 61 and 90 then 90 
		when "THDays" between 91 and 180 then 180 
		when "THDays" between 181 and 365 then 365 
		when "THDays" between 366 and 547 then 547 
		when "THDays" between 548 and 730 then 730 
		when "THDays" between 731 and 1094 then 1094 
		when "THDays" > 1094 then 1095
		else "THDays" end 
	, case when "ESTDays" between 1 and 7 then 7
		when "ESTDays" between 8 and 30 then 30 
		when "ESTDays" between 31 and 60 then 60 
		when "ESTDays" between 61 and 90 then 90 
		when "ESTDays" between 91 and 180 then 180 
		when "ESTDays" between 181 and 365 then 365 
		when "ESTDays" between 366 and 547 then 547 
		when "ESTDays" between 548 and 730 then 730 
		when "ESTDays" between 731 and 1094 then 1094 
		when "ESTDays" > 1094 then 1095
		else "ESTDays" end 
	, case when "RRHPSHPreMoveInDays" between 1 and 7 then 7
		when "RRHPSHPreMoveInDays" between 8 and 30 then 30 
		when "RRHPSHPreMoveInDays" between 31 and 60 then 60 
		when "RRHPSHPreMoveInDays" between 61 and 90 then 90 
		when "RRHPSHPreMoveInDays" between 91 and 180 then 180 
		when "RRHPSHPreMoveInDays" between 181 and 365 then 365 
		when "RRHPSHPreMoveInDays" between 366 and 547 then 547 
		when "RRHPSHPreMoveInDays" between 548 and 730 then 730 
		when "RRHPSHPreMoveInDays" between 731 and 1094 then 1094 
		when "RRHPSHPreMoveInDays" > 1094 then 1095
		else "RRHPSHPreMoveInDays" end 
	, case when "RRHHousedDays" between 1 and 7 then 7
		when "RRHHousedDays" between 8 and 30 then 30 
		when "RRHHousedDays" between 31 and 60 then 60 
		when "RRHHousedDays" between 61 and 90 then 90 
		when "RRHHousedDays" between 91 and 180 then 180 
		when "RRHHousedDays" between 181 and 365 then 365 
		when "RRHHousedDays" between 366 and 547 then 547 
		when "RRHHousedDays" between 548 and 730 then 730 
		when "RRHHousedDays" between 731 and 1094 then 1094 
		when "RRHHousedDays" > 1094 then 1095
		else "RRHHousedDays" end 
	, case when "SystemDaysNotPSHHoused" between 1 and 7 then 7
		when "SystemDaysNotPSHHoused" between 8 and 30 then 30 
		when "SystemDaysNotPSHHoused" between 31 and 60 then 60 
		when "SystemDaysNotPSHHoused" between 61 and 90 then 90 
		when "SystemDaysNotPSHHoused" between 91 and 180 then 180 
		when "SystemDaysNotPSHHoused" between 181 and 365 then 365 
		when "SystemDaysNotPSHHoused" between 366 and 547 then 547 
		when "SystemDaysNotPSHHoused" between 548 and 730 then 730 
		when "SystemDaysNotPSHHoused" between 731 and 1094 then 1094 
		when "SystemDaysNotPSHHoused" > 1094 then 1095
		else "SystemDaysNotPSHHoused" end 
	, case when "SystemHomelessDays" between 1 and 7 then 7
		when "SystemHomelessDays" between 8 and 30 then 30 
		when "SystemHomelessDays" between 31 and 60 then 60 
		when "SystemHomelessDays" between 61 and 90 then 90 
		when "SystemHomelessDays" between 91 and 180 then 180 
		when "SystemHomelessDays" between 181 and 365 then 365 
		when "SystemHomelessDays" between 366 and 547 then 547 
		when "SystemHomelessDays" between 548 and 730 then 730 
		when "SystemHomelessDays" between 731 and 1094 then 1094 
		when "SystemHomelessDays" > 1094 then 1095
		else "SystemHomelessDays" end 
	, case when "Other3917Days" between 1 and 7 then 7
		when "Other3917Days" between 8 and 30 then 30 
		when "Other3917Days" between 31 and 60 then 60 
		when "Other3917Days" between 61 and 90 then 90 
		when "Other3917Days" between 91 and 180 then 180 
		when "Other3917Days" between 181 and 365 then 365 
		when "Other3917Days" between 366 and 547 then 547 
		when "Other3917Days" between 548 and 730 then 730 
		when "Other3917Days" between 731 and 1094 then 1094 
		when "Other3917Days" > 1094 then 1095
		else "Other3917Days" end 
	, case when "TotalHomelessDays" between 1 and 7 then 7
		when "TotalHomelessDays" between 8 and 30 then 30 
		when "TotalHomelessDays" between 31 and 60 then 60 
		when "TotalHomelessDays" between 61 and 90 then 90 
		when "TotalHomelessDays" between 91 and 180 then 180 
		when "TotalHomelessDays" between 181 and 365 then 365 
		when "TotalHomelessDays" between 366 and 547 then 547 
		when "TotalHomelessDays" between 548 and 730 then 730 
		when "TotalHomelessDays" between 731 and 1094 then 1094 
		when "TotalHomelessDays" > 1094 then 1095
		else "TotalHomelessDays" end 
	, "SystemPath", "ESTAHAR", "RRHAHAR", "PSHAHAR", "ReportID" ;

/*
	End LSAHousehold
*/


END
$function$
;
