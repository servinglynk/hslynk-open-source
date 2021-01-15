CREATE OR REPLACE FUNCTION lsa.run_lsahousehold (IN reportId integer, IN project_group_code varchar)
RETURNS void
 LANGUAGE plpgsql
AS $function$
BEGIN

	delete from lsa.tlsa_Household;

	insert into lsa.tlsa_Household (hohid, HHType
		, HHChronic, HHVet, HHDisability, HHFleeingDV
		, HoHRace, HoHEthnicity
		, HHParent, ReportID, Step)
	select distinct hhid.hohid, hhid.ActiveHHType
		, max(hhid.HHChronic)
		, max(hhid.HHVet)
		, max(hhid.HHDisability)
		, max(hhid.HHFleeingDV)
		, lp.Race, lp.Ethnicity
		, max(hhid.HHParent)
		, lp.ReportID
		, '6.1'
	from lsa.tlsa_HHID hhid
	inner join lsa.lsa_Report rpt on rpt.ReportEnd >= hhid.EntryDate
	inner join lsa.tlsa_Person lp on lp.PersonalID = hhid.hohid
	where hhid.Active = '1'
	group by hhid.hohid, hhid.ActiveHHType, lp.Race, lp.Ethnicity
		, lp.ReportID;

/*
	6.2 Set Population Identifiers for LSAHousehold
*/

with subquery_6_2_1 as (
select hh.hohid,
(select case when count(distinct n.PersonalID) >= 3 then 3
			else count(distinct n.PersonalID) end
		from lsa.tlsa_HHID hhid
		inner join lsa.tlsa_Enrollment n on n.HouseholdID = hhid.HouseholdID and n.Active = '1'
		where n.ActiveAge < 18
		and hhid.ActiveHHType = hh.HHType and hhid.HoHID = hh.hohid) as HHChild
, (select case when count(distinct n.PersonalID) >= 3 then 3
			else count(distinct n.PersonalID) end
		from lsa.tlsa_HHID hhid
		inner join lsa.tlsa_Enrollment n on n.HouseholdID = hhid.HouseholdID and n.Active = '1'
		where n.ActiveAge between 18 and 65
			and hhid.ActiveHHType = hh.HHType and hhid.HoHID = hh.hohid
			and n.PersonalID not in
				(select n17.PersonalID
				 from lsa.tlsa_HHID hh17
				 inner join lsa.tlsa_Enrollment n17 on n17.HouseholdID = hh17.HouseholdID and n17.Active = '1'
				 where hh17.HouseholdID = hhid.HouseholdID and hh17.ActiveHHType = hhid.ActiveHHType
					and n17.ActiveAge < 18)) as HHAdult
, (select case when count(distinct n.PersonalID) >= 3 then 3
			else count(distinct n.PersonalID) end
		from lsa.tlsa_HHID hhid
		inner join lsa.tlsa_Enrollment n on n.HouseholdID = hhid.HouseholdID and n.Active = '1'
		where n.ActiveAge in (98,99)
		and hhid.ActiveHHType = hh.HHType and hhid.HoHID = hh.hohid) as HHNoDOB
from lsa.tlsa_Household hh)

update lsa.tlsa_Household
set HHChild =subquery_6_2_1.HHChild
, HHAdult = subquery_6_2_1.HHAdult
, HHNoDOB = subquery_6_2_1.HHNoDOB
, Step = '6.2.1'
from subquery_6_2_1 where subquery_6_2_1.hohid = lsa.tlsa_Household.hohid ;

	update lsa.tlsa_Household
	set HHAdultAge = null, Step = '6.2.2'
	from lsa.tlsa_Household hh;

	update lsa.tlsa_Household
	set HHAdultAge = null, Step = '6.2.2'
	from lsa.tlsa_Household hh;


	with subquery_6_2_3 as (
	select hh.hohid ,
	hhid.HHAdultAge as HHAdultAge
	from lsa.tlsa_Household hh
	inner join lsa.tlsa_HHID hhid
		on hhid.hohid = hh.hohid and hhid.ActiveHHType = hh.HHType
			and hhid.Active = '1'
	where hhid.HHAdultAge = 18)

	update lsa.tlsa_Household
	set HHAdultAge = subquery_6_2_3.HHAdultAge, Step = '6.2.3'
	from subquery_6_2_3
	where subquery_6_2_3.hohid=lsa.tlsa_Household.hohid ;




	with subquery_6_2_4 as (
	select hh.hohid ,
	hhid.HHAdultAge as HHAdultAge
	from lsa.tlsa_Household hh
	inner join lsa.tlsa_HHID hhid
		on hhid.hohid = hh.hohid and hhid.ActiveHHType = hh.HHType
			and hhid.Active = '1'
	where hhid.HHAdultAge = 24 and hh.HHAdultAge is null)

	update lsa.tlsa_Household
	set HHAdultAge = subquery_6_2_4.HHAdultAge, Step = '6.2.4'
	from subquery_6_2_4
	where subquery_6_2_4.hohid=lsa.tlsa_Household.hohid ;




	with subquery_6_2_5 as (
	select hh.hohid ,
	hhid.HHAdultAge as HHAdultAge
	from lsa.tlsa_Household hh
	inner join lsa.tlsa_HHID hhid
		on hhid.hohid = hh.hohid and hhid.ActiveHHType = hh.HHType
			and hhid.Active = '1'
	where hhid.HHAdultAge = 55 and hh.HHAdultAge is null)

	update lsa.tlsa_Household
	set HHAdultAge = subquery_6_2_5.HHAdultAge, Step = '6.2.5'
	from subquery_6_2_5
	where subquery_6_2_5.hohid=lsa.tlsa_Household.hohid ;





	with subquery_6_2_6 as (
	select hh.hohid ,
	hhid.HHAdultAge as HHAdultAge
	from lsa.tlsa_Household hh
	inner join lsa.tlsa_HHID hhid
		on hhid.hohid = hh.hohid and hhid.ActiveHHType = hh.HHType
			and hhid.Active = '1'
	where hhid.HHAdultAge = 25 and hh.HHAdultAge is null)

	update lsa.tlsa_Household
	set HHAdultAge = subquery_6_2_6.HHAdultAge, Step = '6.2.6'
	from subquery_6_2_6
	where subquery_6_2_6.hohid=lsa.tlsa_Household.hohid ;


	update lsa.tlsa_Household
	set HHAdultAge = -1, Step = '6.2.7'
	where HHAdultAge is null;
/*
	6.3 Set lsa.tlsa_Household Project Group Status Indicators
*/

with subquery_6_3_1 as (
	select hh.hohid ,
	case when n.nStat is null then 0
			else n.nStat + n.xStat end as ESTStatus
	from lsa.tlsa_Household hh
	left outer join
		(select hhid.hohid, hhid.ActiveHHType as HHType
			, min(case when hhid.EntryDate < rpt.ReportStart then 10 else 20 end) as nStat
			, min(case when hhid.ExitDate is null then 1 else 2 end) as xStat
		from lsa.tlsa_HHID hhid
		inner join lsa.lsa_Report rpt on hhid.EntryDate <= rpt.ReportEnd
		where hhid.Active = '1'  and hhid.ProjectType in (1,2,8) and hhid.hohid ='76450444-ad42-4b3b-8d9a-589c639616f5'
		group by hhid.hohid, hhid.ActiveHHType
		) n on n.hohid = hh.hohid and n.HHType = hh.HHType
	)

	update lsa.tlsa_Household
	set ESTStatus = subquery_6_3_1.ESTStatus
		, Step = '6.3.1'
		from subquery_6_3_1
		where subquery_6_3_1.hohid  = lsa.tlsa_Household.hohid ;

		with subquery_6_3_2 as (
	select  hh.hohid,
	case when n.nStat is null then 0
			else n.nStat + n.xStat end as RRHStatus
	from lsa.tlsa_Household hh
	left outer join
		(select hhid.hohid, hhid.ActiveHHType as HHType
			, min(case when hhid.EntryDate < rpt.ReportStart then 10 else 20 end) as nStat
			, min(case when hhid.ExitDate is null then 1 else 2 end) as xStat
		from lsa.tlsa_HHID hhid
		inner join lsa.lsa_Report rpt on hhid.EntryDate <= rpt.ReportEnd
		where hhid.Active = '1'  and hhid.ProjectType = 13
		group by hhid.hohid, hhid.ActiveHHType
		) n on n.hohid = hh.hohid and n.HHType = hh.HHType
		)

	update lsa.tlsa_Household
	set RRHStatus = subquery_6_3_2.RRHStatus
		, Step = '6.3.2'
		from subquery_6_3_2
		where subquery_6_3_2.hohid  = lsa.tlsa_Household.hohid ;



		with subquery_6_3_3 as (
			select hh.hohid,
			case when n.nStat is null then 0
					else n.nStat + n.xStat end as PSHStatus

			from lsa.tlsa_Household hh
			left outer join
				(select hhid.hohid, hhid.ActiveHHType as HHType
					, min(case when hhid.EntryDate < rpt.ReportStart then 10 else 20 end) as nStat
					, min(case when hhid.ExitDate is null then 1 else 2 end) as xStat
				from lsa.tlsa_HHID hhid
				inner join lsa.lsa_Report rpt on hhid.EntryDate <= rpt.ReportEnd
				where hhid.Active = '1'  and hhid.ProjectType = 3
				group by hhid.hohid, hhid.ActiveHHType
				) n on n.hohid = hh.hohid and n.HHType = hh.HHType
				)


			update lsa.tlsa_Household
			set PSHStatus = subquery_6_3_3.PSHStatus
			, Step = '6.3.3'
			from subquery_6_3_3
			where subquery_6_3_3.hohid = lsa.tlsa_Household.hohid ;


/*
	6.4 Set lsa.tlsa_Household RRH and PSH Move-In Status Indicators
*/


with subquery_6_4_1 as (
select hh.hohid ,
	case when hh.RRHStatus = 0 then -1
		when n.MoveInStat is null then 0
		else n.MoveInStat end as RRHMoveIn

	from lsa.tlsa_Household hh
	left outer join
		(select hhid.hohid , hhid.ActiveHHType as HHType
			, min(case when hhid.MoveInDate >= rpt.ReportStart then 1 else 2 end) as MoveInStat
		from lsa.tlsa_HHID hhid
		inner join lsa.lsa_Report rpt on hhid.EntryDate <= rpt.ReportEnd
		where hhid.Active = '1'  and hhid.MoveInDate is not null and hhid.ProjectType = 13
		group by hhid.hohid, hhid.ActiveHHType
		) n on n.hohid = hh.hohid and n.HHType = hh.HHType
	)

	update lsa.tlsa_Household
	set RRHMoveIn = subquery_6_4_1.RRHMoveIn
	, Step = '6.4.1'
	from subquery_6_4_1
	where subquery_6_4_1.hohid = lsa.tlsa_Household.hohid ;

	with subquery_6_4_2 as (
		select  hh.hohid,
		case when hh.RRHStatus = 0 then -1
			when n.MoveInStat is null then 0
			else n.MoveInStat end as PSHMoveIn
		from lsa.tlsa_Household hh
		left outer join
			(select hhid.hohid, hhid.ActiveHHType as HHType
				, min(case when hhid.MoveInDate >= rpt.ReportStart then 1 else 2 end) as MoveInStat
			from lsa.tlsa_HHID hhid
			inner join lsa.lsa_Report rpt on hhid.EntryDate <= rpt.ReportEnd
			where hhid.Active = '1'  and hhid.MoveInDate is not null and hhid.ProjectType = 3
			group by hhid.hohid, hhid.ActiveHHType
			) n on n.hohid = hh.hohid and n.HHType = hh.HHType
		)

	update lsa.tlsa_Household
		set PSHMoveIn = subquery_6_4_2.PSHMoveIn
		, Step = '6.4.2'
		from subquery_6_4_2
		where subquery_6_4_2.hohid = lsa.tlsa_Household.hohid ;


/*
	6.5 Set lsa.tlsa_Household Geography for Each Project Group
	-- Enrollment with latest active date in report period for project group
*/


with subquery_6_5_1 as (
	select  hh.hohid,
	case when hh.ESTStatus = 0 then -1
			else coalesce(
				(select coc.GeographyType
				from lsa.tlsa_HHID hhid
				inner join lsa.lsa_Report rpt on rpt.ReportEnd >= hhid.EntryDate
				inner join lsa.lsa_ProjectCoC coc on coc.ProjectID = hhid.ProjectID
				where hhid.Active = '1'  and hhid.ProjectType in (1,2,8)
					and hhid.hohid = hh.hohid and hhid.ActiveHHType = hh.HHType
				order by case when hhid.ExitDate is null then rpt.ReportEnd else hhid.ExitDate end desc
					, hhid.EntryDate DESC limit 1)
				, 99) end as ESTGeography
	from lsa.tlsa_Household hh
	)

update lsa.tlsa_Household
	set ESTGeography = subquery_6_5_1.ESTGeography
	, Step = '6.5.1'
	from subquery_6_5_1
	where subquery_6_5_1.hohid = lsa.tlsa_Household.hohid ;



	with subquery_6_5_2 as (
		select  hh.hohid,
		case when hh.RRHStatus = 0 then -1
				else coalesce(
					(select coc.GeographyType
					from lsa.tlsa_HHID hhid
					inner join lsa.lsa_Report rpt on rpt.ReportEnd >= hhid.EntryDate
					inner join lsa.lsa_ProjectCoC coc on coc.ProjectID = hhid.ProjectID
					where hhid.Active = '1'  and hhid.ProjectType = 13
						and hhid.hohid = hh.hohid and hhid.ActiveHHType = hh.HHType
					order by case when hhid.ExitDate is null then rpt.ReportEnd else hhid.ExitDate end desc
						, hhid.EntryDate DESC limit 1)
					, 99) end as RRHGeography
		from lsa.tlsa_Household hh
		)

	update lsa.tlsa_Household
		set RRHGeography = subquery_6_5_2.RRHGeography
		, Step = '6.5.2'
		from subquery_6_5_2
		where subquery_6_5_2.hohid = lsa.tlsa_Household.hohid ;

		with subquery_6_5_3 as (
			select  hh.hohid,
			case when hh.PSHStatus = 0 then -1
					else coalesce(
						(select coc.GeographyType
						from lsa.tlsa_HHID hhid
						inner join lsa.lsa_Report rpt on rpt.ReportEnd >= hhid.EntryDate
						inner join lsa.lsa_ProjectCoC coc on coc.ProjectID = hhid.ProjectID
						where hhid.Active = '1'  and hhid.ProjectType = 3
							and hhid.hohid = hh.hohid and hhid.ActiveHHType = hh.HHType
						order by case when hhid.ExitDate is null then rpt.ReportEnd else hhid.ExitDate end desc
							, hhid.EntryDate DESC limit 1)
						, 99) end as PSHGeography
			from lsa.tlsa_Household hh
			)

		update lsa.tlsa_Household
			set PSHGeography = subquery_6_5_3.PSHGeography
			, Step = '6.5.3'
			from subquery_6_5_3
			where subquery_6_5_3.hohid = lsa.tlsa_Household.hohid ;

/*
	6.6 Set lsa.tlsa_Household Living Situation for Each Project Group
	--earliest active enrollment in project group
*/



	with subquery_6_6_1 as (
	select  hh.hohid,
		case when hh.ESTStatus = 0 then -1
			when hn.livingsituation = '16' then 1 --Homeless - Street
			when hn.livingsituation in ('1','18') then 2	--Homeless - ES/SH
			when hn.livingsituation = '27' then 3	--Interim Housing
			when hn.livingsituation in ('2','32') then 4	--Homeless - TH or host home
			when hn.livingsituation = '14' then 5	--Hotel/Motel - no voucher
			when hn.livingsituation = '29' then 6	--Residential project
			when hn.livingsituation = '35' then 7	--Family
			when hn.livingsituation = '36' then 8	--Friends
			when hn.livingsituation = '3' then 9	--PSH
			when hn.livingsituation in ('21','11') then 10	--PH - own
			when hn.livingsituation = '10' then 11	--PH - rent no subsidy
			when hn.livingsituation in ('19','28','20','33','34') then 12	--PH - rent with subsidy
			when hn.livingsituation = '15' then 13	--Foster care
			when hn.livingsituation = '25' then 14	--Long-term care
			when hn.livingsituation = '7' then 15	--Institutions - incarceration
			when hn.livingsituation in ('4','5','6') then 16	--Institutions - medical
			else 99	end as ESTLivingSit

	from lsa.tlsa_Household hh
	inner join v2020.enrollment hn on cast (hn.client_id as varchar) = hh.hohid and hn.deleted is false and hn.parent_id is null
	where hh.ESTStatus = 0
		or cast (hn.id as varchar )in
			(select hhid.EnrollmentID
			 from lsa.tlsa_HHID hhid
			 where hhid.ProjectType in (1,2,8)
				and hhid.hohid = hh.hohid and hhid.ActiveHHType = hh.HHType
				and hhid.Active = '1'
			 order by hhid.EntryDate ASC limit 1)
	)

	update lsa.tlsa_Household
	set ESTLivingSit = subquery_6_6_1.ESTLivingSit
	, Step = '6.6.1'
	from subquery_6_6_1
	where subquery_6_6_1.hohid =  lsa.tlsa_Household.hohid ;


	with subquery_6_6_2 as (
	select hh.hohid,
		case when hh.RRHStatus = 0 then -1
			when hn.livingsituation = '16' then 1 --Homeless - Street
			when hn.livingsituation in ('1','18') then 2	--Homeless - ES/SH
			when hn.livingsituation = '27' then 3	--Interim Housing
			when hn.livingsituation in ('2','32') then 4	--Homeless - TH or host home
			when hn.livingsituation = '14' then 5	--Hotel/Motel - no voucher
			when hn.livingsituation = '29' then 6	--Residential project
			when hn.livingsituation = '35' then 7	--Family
			when hn.livingsituation = '36' then 8	--Friends
			when hn.livingsituation = '3' then 9	--PSH
			when hn.livingsituation in ('21','11') then 10	--PH - own
			when hn.livingsituation = '10' then 11	--PH - rent no subsidy
			when hn.livingsituation in ('19','28','20','33','34') then 12	--PH - rent with subsidy
			when hn.livingsituation = '15' then 13	--Foster care
			when hn.livingsituation = '25' then 14	--Long-term care
			when hn.livingsituation = '7' then 15	--Institutions - incarceration
			when hn.livingsituation in ('4','5','6') then 16	--Institutions - medical
			else 99	end as RRHLivingSit
	from lsa.tlsa_Household hh
	inner join v2020.enrollment hn on cast (hn.client_id as varchar) = hh.hohid and hn.deleted is false and hn.parent_id is null
	where hh.RRHStatus = 0
		or cast (hn.id as varchar) in
			(select  hhid.EnrollmentID
			 from lsa.tlsa_HHID hhid
			 where hhid.ProjectType = 13
				and hhid.hohid = hh.hohid and hhid.ActiveHHType = hh.HHType
				and hhid.Active = '1'
			 order by hhid.EntryDate asc limit 1)
	)

	update lsa.tlsa_Household
	set RRHLivingSit =subquery_6_6_2.RRHLivingSit
	, Step = '6.6.2'
	from subquery_6_6_2
	where subquery_6_6_2.hohid = lsa.tlsa_Household.hohid ;



		with subquery_6_6_3 as (
		select hh.hohid,
			case when hh.PSHStatus = 0 then -1
				when hn.livingsituation = '16' then 1 --Homeless - Street
				when hn.livingsituation in ('1','18') then 2	--Homeless - ES/SH
				when hn.livingsituation ='27' then 3	--Interim Housing
				when hn.livingsituation in ('2','32') then 4	--Homeless - TH or host home
				when hn.livingsituation = '14' then 5	--Hotel/Motel - no voucher
				when hn.livingsituation = '29' then 6	--Residential project
				when hn.livingsituation = '35' then 7	--Family
				when hn.livingsituation = '36' then 8	--Friends
				when hn.livingsituation = '3' then 9	--PSH
				when hn.livingsituation in ('21','11') then 10	--PH - own
				when hn.livingsituation = '10' then 11	--PH - rent no subsidy
				when hn.livingsituation in ('19','28','20','33','34') then 12	--PH - rent with subsidy
				when hn.livingsituation = '15' then 13	--Foster care
				when hn.livingsituation = '25' then 14	--Long-term care
				when hn.livingsituation = '7' then 15	--Institutions - incarceration
				when hn.livingsituation in ('4','5','6') then 16	--Institutions - medical
				else 99	end as PSHLivingSit
		from lsa.tlsa_Household hh
		inner join v2020.enrollment hn on CAST (hn.client_id AS varchar) = hh.hohid and hn.deleted is false and hn.parent_id is null
		where hh.PSHStatus = 0
			or CAST (hn.id AS VARCHAR ) in
				(select hhid.EnrollmentID
				 from lsa.tlsa_HHID hhid
				 where hhid.ProjectType = 3
					and hhid.hohid = hh.hohid and hhid.ActiveHHType = hh.HHType
					and hhid.Active = '1'
				 order by hhid.EntryDate ASC limit 1)
		)

		update lsa.tlsa_Household
		set PSHLivingSit =subquery_6_6_3.PSHLivingSit
		, Step = '6.6.3'
		from subquery_6_6_3
		where subquery_6_6_3.hohid = lsa.tlsa_Household.hohid ;

/*
	6.7 Set lsa.tlsa_Household Destination for Each Project Group
	--most recent exit from project group for households not active in project group at ReportEnd
*/


	with subquery_6_7_1 as (
	select hh.hohid,
		case when hh.ESTStatus not in (12,22) then -1
			 else hhid.ExitDest end as ESTDestination
	from lsa.tlsa_Household hh
	inner join lsa.tlsa_HHID hhid on hhid.hohid = hh.hohid
		and hhid.ActiveHHType = hh.HHType and hhid.Active = '1'
	where hh.ESTStatus not in (12,22)
		or hhid.EnrollmentID in
			(select hhid.EnrollmentID
			 from lsa.tlsa_HHID hhid
			 where hhid.ProjectType in (1,2,8)
				and hhid.hohid = hh.hohid and hhid.ActiveHHType = hh.HHType
				and hhid.Active = '1'
			 order by hhid.ExitDate DESC limit 1)
	)

	update lsa.tlsa_Household
	set ESTDestination =subquery_6_7_1.ESTDestination
	,Step = '6.7.1'
	from subquery_6_7_1
	where subquery_6_7_1.hohid = lsa.tlsa_Household.hohid ;



		with subquery_6_7_2 as (
		select hh.hohid,
			case when hh.RRHStatus not in (12,22) then -1
				 else hhid.ExitDest end as RRHDestination
		from lsa.tlsa_Household hh
		inner join lsa.tlsa_HHID hhid on hhid.hohid = hh.hohid
			and hhid.ActiveHHType = hh.HHType and hhid.Active = '1'
		where hh.RRHStatus not in (12,22)
			or hhid.EnrollmentID in
				(select hhid.EnrollmentID
				 from lsa.tlsa_HHID hhid
				 where hhid.ProjectType = 13
					and hhid.hohid = hh.hohid and hhid.ActiveHHType = hh.HHType
					and hhid.Active = '1'
				 order by hhid.ExitDate DESC limit 1)
		)

		update lsa.tlsa_Household
		set RRHDestination =subquery_6_7_2.RRHDestination
		,Step = '6.7.2'
		from subquery_6_7_2
		where subquery_6_7_2.hohid = lsa.tlsa_Household.hohid ;


		with subquery_6_7_3 as (
		select hh.hohid,
			case when hh.PSHStatus not in (12,22) then -1
				 else hhid.ExitDest end as PSHDestination
		from lsa.tlsa_Household hh
		inner join lsa.tlsa_HHID hhid on hhid.hohid = hh.hohid
			and hhid.ActiveHHType = hh.HHType and hhid.Active = '1'
		where hh.PSHStatus not in (12,22)
			or hhid.EnrollmentID in
				(select hhid.EnrollmentID
				 from lsa.tlsa_HHID hhid
				 where hhid.ProjectType = 3
					and hhid.hohid = hh.hohid and hhid.ActiveHHType = hh.HHType
					and hhid.Active = '1'
				 order by hhid.ExitDate DESC limit 1)
		)

		update lsa.tlsa_Household
		set PSHDestination =subquery_6_7_3.PSHDestination
		,Step = '6.7.3'
		from subquery_6_7_3
		where subquery_6_7_3.hohid = lsa.tlsa_Household.hohid ;

/*
	6.8	EST/RRH/PSH Population Identifiers for LSAHousehold
*/

with subquery_6_8_1 as (
select hh.hohid,
	coalesce (
			(select max(hhid.AC3Plus)
			 from lsa.tlsa_HHID hhid
			 where hhid.Active = '1'  and hhid.ActiveHHType = hh.HHType and hhid.hohid = hh.hohid
				and hhid.ProjectType in (1,2,8)), 0) as ESTAC3Plus
		, coalesce (
			(select max(hhid.HHVet)
			 from lsa.tlsa_HHID hhid
			 where hhid.Active = '1'  and hhid.ActiveHHType = hh.HHType and hhid.hohid = hh.hohid
				and hhid.ProjectType in (1,2,8)), 0) as ESTVet
		, coalesce (
			(select max(hhid.HHChronic)
			 from lsa.tlsa_HHID hhid
			 where hhid.Active = '1'  and hhid.ActiveHHType = hh.HHType and hhid.hohid = hh.hohid
				and hhid.ProjectType in (1,2,8)), 0) as ESTChronic
		, coalesce (
			(select max(hhid.HHDisability)
			 from lsa.tlsa_HHID hhid
			 where hhid.Active = '1'  and hhid.ActiveHHType = hh.HHType and hhid.hohid = hh.hohid
				and hhid.ProjectType in (1,2,8)), 0) as ESTDisability
		, coalesce (
			(select max(hhid.HHFleeingDV)
			 from lsa.tlsa_HHID hhid
			 where hhid.Active = '1'  and hhid.ActiveHHType = hh.HHType and hhid.hohid = hh.hohid
				and hhid.ProjectType in (1,2,8)), 0) as ESTFleeingDV
		, coalesce (
			(select max(hhid.HHParent)
			 from lsa.tlsa_HHID hhid
			 where hhid.Active = '1'  and hhid.ActiveHHType = hh.HHType and hhid.hohid = hh.hohid
				and hhid.ProjectType in (1,2,8)), 0) as ESTParent
		, coalesce (hh18.HHAdultAge,
			hh24.HHAdultAge,
			hh55.HHAdultAge,
			hh25.HHAdultAge,
			-1) as ESTAdultAge
	from lsa.tlsa_Household hh
	left outer join lsa.tlsa_HHID hh18 on hh18.HHAdultAge = 18
		and hh18.HouseholdID = hh.hohid and hh18.ActiveHHType = hh.HHType
		and hh18.Active = '1'  and hh18.ProjectType in (1,2,8)
	left outer join lsa.tlsa_HHID hh24 on hh24.HHAdultAge = 24
		and hh24.HouseholdID = hh.hohid and hh24.ActiveHHType = hh.HHType
		and hh24.Active = '1'  and hh24.ProjectType in (1,2,8)
	left outer join lsa.tlsa_HHID hh55 on hh55.HHAdultAge = 55
		and hh55.HouseholdID = hh.hohid and hh55.ActiveHHType = hh.HHType
		and hh55.Active = '1'  and hh55.ProjectType in (1,2,8)
	left outer join lsa.tlsa_HHID hh25 on hh25.HHAdultAge = 25
		and hh25.Active = '1'  and hh25.HouseholdID = hh.hohid and hh25.ActiveHHType = hh.HHType
		and hh25.ProjectType in (1,2,8)

		)

		update lsa.tlsa_Household set
		ESTAC3Plus = subquery_6_8_1.ESTAC3Plus,
		ESTVet = subquery_6_8_1.ESTVet,
		ESTChronic = subquery_6_8_1.ESTChronic,
		ESTDisability = subquery_6_8_1.ESTDisability,
		ESTFleeingDV = subquery_6_8_1.ESTFleeingDV,
		ESTParent = subquery_6_8_1.ESTParent,
		ESTAdultAge = subquery_6_8_1.ESTAdultAge
		, Step = '6.8.1'
		from subquery_6_8_1
		where subquery_6_8_1.hohid = lsa.tlsa_Household.hohid ;


		with subquery_6_8_2 as (
	select hh.hohid,
		coalesce (
				(select max(hhid.AC3Plus)
				 from lsa.tlsa_HHID hhid
				 where hhid.Active = '1'  and hhid.ActiveHHType = hh.HHType and hhid.hohid = hh.hohid
					and hhid.ProjectType = 13), 0) as RRHAC3Plus
			,coalesce (
				(select max(hhid.HHVet)
				 from lsa.tlsa_HHID hhid
				 where hhid.Active = '1'  and hhid.ActiveHHType = hh.HHType and hhid.hohid = hh.hohid
					and hhid.ProjectType = 13), 0) as RRHVet
			,coalesce (
				(select max(hhid.HHChronic)
				 from lsa.tlsa_HHID hhid
				 where hhid.Active = '1'  and hhid.ActiveHHType = hh.HHType and hhid.hohid = hh.hohid
					and hhid.ProjectType = 13), 0) as RRHChronic
			,coalesce (
				(select max(hhid.HHDisability)
				 from lsa.tlsa_HHID hhid
				 where hhid.Active = '1'  and hhid.ActiveHHType = hh.HHType and hhid.hohid = hh.hohid
					and hhid.ProjectType = 13), 0) as RRHDisability
			,coalesce (
				(select max(hhid.HHFleeingDV)
				 from lsa.tlsa_HHID hhid
				 where hhid.Active = '1'  and hhid.ActiveHHType = hh.HHType and hhid.hohid = hh.hohid
					and hhid.ProjectType = 13), 0) as RRHFleeingDV
			, coalesce (
				(select max(hhid.HHParent)
				 from lsa.tlsa_HHID hhid
				 where hhid.Active = '1'  and hhid.ActiveHHType = hh.HHType and hhid.hohid = hh.hohid
					and hhid.ProjectType = 13), 0) as RRHParent
			, coalesce (hh18.HHAdultAge,
				hh24.HHAdultAge,
				hh55.HHAdultAge,
				hh25.HHAdultAge,
				-1) as RRHAdultAge
		from lsa.tlsa_Household hh
		left outer join lsa.tlsa_HHID hh18 on hh18.HHAdultAge = 18
			and hh18.HouseholdID = hh.hohid and hh18.ActiveHHType = hh.HHType
			and hh18.Active = '1'  and hh18.ProjectType = 13
		left outer join lsa.tlsa_HHID hh24 on hh24.HHAdultAge = 24
			and hh24.HouseholdID = hh.hohid and hh24.ActiveHHType = hh.HHType
			and hh24.Active = '1'  and hh24.ProjectType = 13
		left outer join lsa.tlsa_HHID hh55 on hh55.HHAdultAge = 55
			and hh55.HouseholdID = hh.hohid and hh55.ActiveHHType = hh.HHType
			and hh55.Active = '1'  and hh55.ProjectType = 13
		left outer join lsa.tlsa_HHID hh25 on hh25.HHAdultAge = 25
			and hh25.Active = '1'  and hh25.HouseholdID = hh.hohid and hh25.ActiveHHType = hh.HHType
			and hh25.ProjectType = 13
			)

			update lsa.tlsa_Household
		set RRHAC3Plus = subquery_6_8_2.RRHAC3Plus,
		RRHVet         = subquery_6_8_2.RRHVet,
		RRHChronic     = subquery_6_8_2.RRHChronic,
		RRHDisability  = subquery_6_8_2.RRHDisability,
		RRHFleeingDV   = subquery_6_8_2.RRHFleeingDV,
		RRHParent      = subquery_6_8_2.RRHParent,
		RRHAdultAge    = subquery_6_8_2.RRHAdultAge
		, Step = '6.8.2'
		from subquery_6_8_2
		where subquery_6_8_2.hohid = lsa.tlsa_Household.hohid;


		with subquery_6_8_3 as  (
			select hh.hohid,
			coalesce (
					(select max(hhid.AC3Plus)
					 from lsa.tlsa_HHID hhid
					 where hhid.Active = '1'  and hhid.ActiveHHType = hh.HHType and hhid.hohid = hh.hohid
						and hhid.ProjectType = 3), 0) as PSHAC3Plus
				, coalesce (
					(select max(hhid.HHVet)
					 from lsa.tlsa_HHID hhid
					 where hhid.Active = '1'  and hhid.ActiveHHType = hh.HHType and hhid.hohid = hh.hohid
						and hhid.ProjectType = 3), 0) as PSHVet
				, coalesce (
					(select max(hhid.HHChronic)
					 from lsa.tlsa_HHID hhid
					 where hhid.Active = '1'  and hhid.ActiveHHType = hh.HHType and hhid.hohid = hh.hohid
						and hhid.ProjectType = 3), 0) as PSHChronic
				, coalesce (
					(select max(hhid.HHDisability)
					 from lsa.tlsa_HHID hhid
					 where hhid.Active = '1'  and hhid.ActiveHHType = hh.HHType and hhid.hohid = hh.hohid
						and hhid.ProjectType = 3), 0) as PSHDisability
				, coalesce (
					(select max(hhid.HHFleeingDV)
					 from lsa.tlsa_HHID hhid
					 where hhid.Active = '1'  and hhid.ActiveHHType = hh.HHType and hhid.hohid = hh.hohid
						and hhid.ProjectType = 3), 0) as PSHFleeingDV
				, coalesce (
					(select max(hhid.HHParent)
					 from lsa.tlsa_HHID hhid
					 where hhid.Active = '1'  and hhid.ActiveHHType = hh.HHType and hhid.hohid = hh.hohid
						and hhid.ProjectType = 3), 0) as PSHParent
				,  coalesce (hh18.HHAdultAge,
					hh24.HHAdultAge,
					hh55.HHAdultAge,
					hh25.HHAdultAge,
					-1) as PSHAdultAge
			from lsa.tlsa_Household hh
			left outer join lsa.tlsa_HHID hh18 on hh18.HHAdultAge = 18
				and hh18.HouseholdID = hh.hohid and hh18.ActiveHHType = hh.HHType
				and hh18.Active = '1'  and hh18.ProjectType = 3
			left outer join lsa.tlsa_HHID hh24 on hh24.HHAdultAge = 24
				and hh24.HouseholdID = hh.hohid and hh24.ActiveHHType = hh.HHType
				and hh24.Active = '1'  and hh24.ProjectType = 3
			left outer join lsa.tlsa_HHID hh55 on hh55.HHAdultAge = 55
				and hh55.HouseholdID = hh.hohid and hh55.ActiveHHType = hh.HHType
				and hh55.Active = '1'  and hh55.ProjectType = 3
			left outer join lsa.tlsa_HHID hh25 on hh25.HHAdultAge = 25
				and hh25.Active = '1'  and hh25.HouseholdID = hh.hohid and hh25.ActiveHHType = hh.HHType
				and hh25.ProjectType = 3
				)

				update lsa.tlsa_Household set
				PSHAC3Plus = subquery_6_8_3.PSHAC3Plus,
				PSHVet =subquery_6_8_3.PSHVet,
				PSHChronic= subquery_6_8_3.PSHChronic,
				PSHDisability =subquery_6_8_3.PSHDisability,
				PSHFleeingDV = subquery_6_8_3.PSHFleeingDV,
				PSHParent = subquery_6_8_3.PSHParent,
				PSHAdultAge = subquery_6_8_3.PSHAdultAge
				, Step = '6.8.3'
				from subquery_6_8_3
				where subquery_6_8_3.hohid = lsa.tlsa_Household.hohid ;


/*
	6.9	System Engagement Status and Return Time
*/

	WITH subquery6_9_1 AS (
	select min(hhid.EntryDate) as entrydate ,hh.hohid as hohid
		from lsa.tlsa_HHID hhid,
		lsa.tlsa_Household hh
		where hhid.Active = '1'
		and hhid.hohid = hh.hohid
		and hhid.ActiveHHType = hh.HHType
		group by hh.hohid
	)

	update lsa.tlsa_Household
	set FirstEntry = subquery6_9_1.entrydate
		, Step = '6.9.1'
	from subquery6_9_1
    where subquery6_9_1.hohid = lsa.tlsa_Household.hohid;


		with subquery_6_9_2 as (
	  select
	  		hh.hohid as hohid,
	  		prior.EnrollmentID as EnrollmentID
	 		from lsa.tlsa_HHID prior
	 		inner join lsa.lsa_Report rpt on rpt.ReportStart > prior.ExitDate
	 		inner join lsa.tlsa_Household hh on prior.hohid = hh.hohid
	 		where prior.ExitDate >= dateadd ('d',-730,hh.FirstEntry)
	 			and prior.hohid = hh.hohid and prior.ActiveHHType = hh.HHType
	 		order by prior.ExitDate DESC limit 1)

	 update lsa.tlsa_Household
	 	set StatEnrollmentID = subquery_6_9_2.EnrollmentID
	 		, Step = '6.9.2'
	 	from  subquery_6_9_2
	 	where subquery_6_9_2.hohid = lsa.tlsa_Household.hohid;




			with subquery_6_9_3 as (
			select hh.hohid ,
					case
					when hh.PSHStatus in (11,12) or hh.RRHStatus in (11,12) or hh.ESTStatus in (11,12)
						then 5
					when hh.StatEnrollmentID is null then 1
		            --correction to line below from >= to just >
					when dateadd('d', 15, prior.ExitDate) > hh.FirstEntry then 5
					when prior.ExitDest between 1 and 6 then 2
					when prior.ExitDest between 7 and 14 then 3
					else 4 end as Stat
				,  case
					when hh.PSHStatus in (11,12) or hh.RRHStatus in (11,12) or hh.ESTStatus in (11,12)
						or hh.StatEnrollmentID is null
						or dateadd('d', 15, prior.ExitDate) > hh.FirstEntry then -1
					else DATE_PART('day', hh.FirstEntry::timestamp - prior.ExitDate::timestamp ) end as ReturnTime
			from lsa.tlsa_Household hh
			left outer join lsa.tlsa_HHID prior on prior.EnrollmentID = hh.StatEnrollmentID )

				update lsa.tlsa_Household
			set Stat = subquery_6_9_3.Stat,
			ReturnTime = subquery_6_9_3.ReturnTime
			, Step = '6.9.3'
			from subquery_6_9_3
			where subquery_6_9_3.hohid = lsa.tlsa_Household.hohid ;


/*
	6.10 Get Days In RRH Pre-Move-In
*/


 with subquery_6_10 as	(
 	select 	hhid.hohid,
 			count(distinct cal.theDate) as RRHPreMoveInDays
			from lsa.tlsa_HHID hhid
			inner join lsa.lsa_Report rpt on rpt.ReportEnd >= hhid.EntryDate
			inner join lsa.tlsa_Household hh on hh.hohid  = hhid.hohid
			inner join lsa.ref_Calendar cal on cal.theDate >= hhid.EntryDate
				and cal.theDate <= coalesce(
						  dateadd('d', -1, hhid.MoveInDate)
						  -- line below corrected to use the ExitDate and not ExitDate - 1
						, hhid.ExitDate
						, rpt.ReportEnd)
			where hhid.ProjectType = 13
				and hhid.ActiveHHType = hh.HHType and hhid.hohid = hh.hohid
				and hhid.Active = '1'
				group by hhid.hohid

				)

	update lsa.tlsa_Household
	set RRHPreMoveInDays = subquery_6_10.RRHPreMoveInDays
		, Step = '6.10'
		from subquery_6_10
		where subquery_6_10.hohid = lsa.tlsa_Household.hohid ;

/*
	6.11 Get Dates Housed in PSH or RRH
*/
	delete from lsa.sys_Time;

	insert into lsa.sys_Time (hohid, HHType, sysDate, sysStatus, Step)
	select distinct hhid.hohid, hhid.ActiveHHType, cal.theDate
		, min(case hhid.ProjectType
				when 3 then 1
				else 2 end)
		, '6.11'
	from lsa.tlsa_HHID hhid
	inner join lsa.tlsa_Household hh on hh.HoHID = hhid.HoHID and hh.HHType = hhid.ActiveHHType
	inner join lsa.lsa_Report rpt on rpt.ReportEnd >= hhid.EntryDate
	inner join lsa.ref_Calendar cal on cal.theDate >= hhid.MoveInDate
		and (cal.theDate < hhid.ExitDate
			or (cal.theDate = hhid.MoveInDate and cal.theDate = hhid.ExitDate and hhid.ProjectType = 13)
			or (hhid.ExitDate is null and cal.theDate <= rpt.ReportEnd))
	where hhid.ProjectType in (3,13) and hhid.Active = '1'
	group by hhid.hohid, hhid.ActiveHHType, cal.theDate;
/*
	6.12  Get Last Inactive Date
*/
with query_6_12_1 as (
select hh.hohid as hohid,
 case
			when dateadd('d', -1, hh.FirstEntry) < '2012-09-30' then '2012-09-30'
			else  dateadd('d', -1, hh.FirstEntry) end as lastinactive

	from lsa.tlsa_Household hh
	where hh.Stat <> 5
		or (select hhid.EnrollmentID
			from lsa.tlsa_HHID hhid
			inner join lsa.lsa_Report rpt on hhid.ExitDate < rpt.ReportStart
			where hhid.hohid = hh.hohid and hhid.ActiveHHType = hh.HHType
			and dateadd('d', 6, hhid.ExitDate) >= hh.FirstEntry limit 1) is null
)

	--LastInactive = (FirstEntry - 1 day) for any household where Stat <> 5
	--  and for any household where Stat = 5 but there is no enrollment for the HouseholdID/HHType
	--  active in the six days prior to First Entry.
update lsa.tlsa_Household
 set LastInactive = query_6_12_1.lastinactive
, Step = '6.12.1'
from query_6_12_1
where query_6_12_1.hohid = lsa.tlsa_Household.hohid ;


		insert into lsa.sys_TimePadded (hohid, HHType, Cohort, StartDate, EndDate, Step)
	select distinct hh.hohid, hh.HHType, 1
		, hhid.EntryDate
		, case when hhid.ExitDate is null then rpt.ReportEnd
			else dateadd('d', 6, hhid.ExitDate) end
		, '6.12.2.a'
	from lsa.tlsa_Household hh
	inner join lsa.lsa_Report rpt on rpt.ReportStart >= hh.FirstEntry
	inner join lsa.tlsa_HHID hhid on hhid.hohid = hh.hohid and hhid.ActiveHHType = hh.HHType
		and (hhid.Active = '1'  or hhid.ExitDate < rpt.ReportStart)
	where hh.LastInactive is null
		and (hhid.ProjectType <> 1 or hhid.TrackingMethod = 0)
	union
	select distinct hh.hohid, hh.HHType, 1
		, bn.DateProvided
		, dateadd('d', 6, bn.dateprovided::date)
		, '6.12.2.b'
	from lsa.tlsa_Household hh
	inner join lsa.lsa_Report rpt on rpt.ReportStart >= hh.FirstEntry
	inner join lsa.tlsa_HHID hhid on hhid.hohid = hh.hohid and hhid.ActiveHHType = hh.HHType
		and (hhid.Active = '1'  or hhid.ExitDate < rpt.ReportStart)
	inner join v2020.service_fa_referral bn on CAST (bn.enrollmentid AS varchar)= hhid.EnrollmentID
		and bn.dateprovided between '2012-01-10' and rpt.ReportEnd
		and bn.dateprovided >= hhid.EntryDate
		and (bn.dateprovided < hhid.ExitDate or hhid.ExitDate is null)
		-- 5/14/2020 correct DateDeleted = 0 to DateDeleted is null
		and bn.record_type = '200' and bn.deleted is false and bn.parent_id is null
	where hh.LastInactive is null
		and hhid.TrackingMethod = 3;

	update lsa.tlsa_Household
	set LastInactive = coalesce(lastDay.inactive, '2012-09-30')
		,Step = '6.12.3'
	from lsa.tlsa_Household hh
	left outer join
		(select hh.hohid, hh.HHType, max(cal.theDate) as inactive
		  from lsa.tlsa_Household hh
		  inner join lsa.lsa_Report rpt on rpt.ReportID = hh.ReportID
		  inner join lsa.ref_Calendar cal on cal.theDate <= rpt.ReportEnd
			and cal.theDate >= '2012-10-1'
		  left outer join
			 lsa.sys_TimePadded stp on stp.hohid = hh.hohid and stp.HHType = hh.HHType
			  and cal.theDate between stp.StartDate and stp.EndDate
		  where stp.hohid is null
			and cal.theDate < hh.FirstEntry
		group by hh.hohid, hh.HHType
	  ) lastDay on lastDay.hohid = hh.hohid and lastDay.HHType = hh.HHType
	where hh.LastInactive is null;

/*
	6.13 Get Dates of Other System Use
*/
	--Transitional Housing and Entry/Exit ES (sysStatus = 3 and 4)
	insert into lsa.sys_Time (hohid, HHType, sysDate, sysStatus, Step)
	select distinct hh.hohid, hh.HHType, cal.theDate
		, min(case when hhid.ProjectType = 2 then 3 else 4 end)
		, '6.13.1'
	from lsa.tlsa_Household hh
	inner join lsa.tlsa_HHID hhid on hhid.hohid = hh.hohid and hhid.ActiveHHType = hh.HHType and hhid.EntryDate > hh.LastInactive
	inner join lsa.lsa_Report rpt on rpt.ReportEnd >= hhid.EntryDate
	inner join lsa.ref_Calendar cal on
		cal.theDate >= hhid.EntryDate
		and cal.theDate > hh.LastInactive
		and cal.theDate <= coalesce(dateadd('d', -1, hhid.ExitDate), rpt.ReportEnd)
	left outer join lsa.sys_Time housed on housed.hohid = hh.hohid and housed.HHType = hh.HHType
		and housed.sysDate = cal.theDate
	where housed.sysDate is null
		and (hhid.ProjectType in (2,8) or (hhid.ProjectType = 1 and hhid.TrackingMethod = 0))
	group by hh.hohid, hh.HHType, cal.theDate;

	--Emergency Shelter (Night-by-Night) (sysStatus = 4)
	insert into lsa.sys_Time (hohid, HHType, sysDate, sysStatus, Step)
	select distinct hh.hohid, hh.HHType, cal.theDate, 4
		, '6.13.2'
	from lsa.tlsa_Household hh
	inner join lsa.tlsa_HHID hhid on hhid.hohid = hh.hohid and hhid.ActiveHHType = hh.HHType  and hhid.EntryDate > hh.LastInactive
	inner join lsa.lsa_Report rpt on rpt.ReportEnd >= hhid.EntryDate
	inner join v2020.service_fa_referral bn on CAST (bn.enrollmentid AS varchar) = hhid.EnrollmentID
		and bn.record_type = '200' and bn.deleted is false and bn.parent_id is null
	inner join lsa.ref_Calendar cal on
		cal.theDate = bn.dateprovided
		and cal.theDate > hh.LastInactive
		and cal.theDate between hhid.EntryDate and coalesce(dateadd('d', -1, hhid.ExitDate), rpt.ReportEnd)
	left outer join lsa.sys_Time other on other.hohid = hh.hohid and other.HHType = hh.HHType
		and other.sysDate = cal.theDate
	where other.sysDate is null and hhid.ProjectType = 1 and hhid.TrackingMethod = 3;

	--Homeless (Time prior to Move-In) in PSH and RRH (sysStatus = 5 and 6)
	insert into lsa.sys_Time (hohid, HHType, sysDate, sysStatus, Step)
	select distinct hh.hohid, hh.HHType, cal.theDate
		, min (case when hhid.ProjectType = 3 then 5 else 6 end)
		, '6.13.3'
	from lsa.tlsa_Household hh
	inner join lsa.tlsa_HHID hhid on hhid.hohid = hh.hohid and hhid.ActiveHHType = hh.HHType and hhid.EntryDate > hh.LastInactive
	inner join lsa.lsa_Report rpt on rpt.ReportEnd >= hhid.EntryDate
	inner join lsa.ref_Calendar cal on
		cal.theDate >= hhid.EntryDate
		and cal.theDate <= coalesce(dateadd('d', -1, hhid.MoveInDate), dateadd('d', -1, hhid.ExitDate), rpt.ReportEnd)
	left outer join lsa.sys_Time other on other.hohid = hh.hohid and other.HHType = hh.HHType
		and other.sysDate = cal.theDate
	where cal.theDate > hh.LastInactive
		and other.sysDate is null and hhid.ProjectType in (3,13)
	group by hh.hohid, hh.HHType, cal.theDate;

/*
	6.14 Get Other Dates Homeless from 3.917 Living Situation
*/
	--If there are enrollments in sys_Enrollment where EntryDate >= LastInactive,
	-- dates between the earliest DateToStreetESSH and LastInactive --
	-- i.e., dates without a potential status conflict based on other system use --
	-- populate Other3917Days as the difference in days between DateToStreetESSH
	-- and LastInactive + 1.

	--NOTE:  This statement will leave Other3917Days NULL for households without
	--at least one DateToStreetESSH prior to LastInactive.  Final value for Other3917Days
	--is the sum of days prior to LastInactive (if any) PLUS the count of dates
	--added to lsa.sys_Time in the next statement.
	with subquery_6_14_1 as (
	select (DATE_PART ('day', hh.LastInactive::timestamp - hn.DateToStreetESSH::timestamp )+ 1) as Other3917Days, hhid.hohid
			from lsa.tlsa_HHID hhid
			left outer join lsa.tlsa_Household hh on  hhid.hohid = hh.hohid
			inner join v2020.enrollment hn on CAST (hn.id AS varchar) = hhid.EnrollmentID and hn.deleted is false and hn.parent_id is null
			where hhid.hohid = hh.hohid and hhid.ActiveHHType = hh.HHType
				and hhid.EntryDate > hh.LastInactive
				and hn.datetostreetessh<= hh.LastInactive
				and (hhid.ProjectType in (1,8)
					or hn.livingsituation in ('1','18','16')
					or (hn.lengthofstay in ('10','11') and hn.previousstreetessh = '1')
					--5/14/2020 - correct 24 (deceased) to 25 (LTC/nursing home)
					or (hn.livingsituation in ('4','5','6','7','15','25')
						and hn.lengthofstay in ('2','3') and hn.previousstreetessh = '1'))
	   )

	update 	lsa.tlsa_Household
	set Other3917Days = subquery_6_14_1.Other3917Days
		, Step = '6.14.1'
	from subquery_6_14_1
	where subquery_6_14_1.hohid = 	lsa.tlsa_Household.hohid ;

	insert into lsa.sys_Time (hohid, HHType, sysDate, sysStatus, Step)
	select distinct hh.hohid, hh.HHType, cal.theDate, 7
		, '6.14.2'
	from lsa.tlsa_Household hh
	inner join lsa.tlsa_HHID hhid on hhid.hohid = hh.hohid and hhid.ActiveHHType = hh.HHType
		and hhid.EntryDate > hh.LastInactive
	inner join v2020.enrollment hn on CAST (hn.id AS varchar) = hhid.EnrollmentID and hn.deleted is false and hn.parent_id is null
	inner join lsa.lsa_Report rpt on rpt.ReportEnd >= hhid.EntryDate and rpt.project_group_code=hn.project_group_code
	inner join lsa.ref_Calendar cal on
		cal.theDate >= hn.datetostreetessh
		and cal.theDate < hn.entrydate
	left outer join lsa.sys_Time other on other.hohid = hh.hohid and other.HHType = hh.HHType
		and other.sysDate = cal.theDate
	where other.sysDate is null and hhid.EnrollmentID in
			(select cast (hn.id as varchar)
			from lsa.tlsa_HHID hhid
			inner join v2020.enrollment hn on cast (hn.id as varchar) = hhid.EnrollmentID
			where hhid.hohid = hh.hohid and hhid.ActiveHHType = hh.HHType
				and hhid.EntryDate > hh.LastInactive and hn.deleted is false and hn.parent_id is null
				and hn.datetostreetessh<= hh.LastInactive
				and (hhid.ProjectType in ('1','8')
					or hn.livingsituation in ('1','18','16')
					or (hn.lengthofstay in ('10','11') and hn.previousstreetessh = '1')
					--5/21/2020 - correct 24 (deceased) to 25 (LTC/nursing home)
					or (hn.livingsituation in ('4','5','6','7','15','25')
						and hn.lengthofstay in ('2','3') and hn.previousstreetessh = '1'))
			order by hn.datetostreetessh asc limit 1);

/*
	6.15 Set System Use Days for LSAHousehold
*/

with subquery_6_15 as (
select hh.hohid ,
	(select count(distinct st.sysDate)
			from lsa.sys_Time st
			where st.sysStatus = 4
			and st.hohid = hh.hohid and st.HHType = hh.HHType) as ESDays
		, (select count(distinct st.sysDate)
			from lsa.sys_Time st
			where st.sysStatus = 3
			and st.hohid = hh.hohid and st.HHType = hh.HHType) as THDays
		, (select count(distinct st.sysDate)
			from lsa.sys_Time st
			where st.sysStatus in (3,4)
			and st.hohid = hh.hohid and st.HHType = hh.HHType) as ESTDays
		,  (select count(distinct st.sysDate)
			from lsa.sys_Time st
			where st.sysStatus in (5,6)
			and st.hohid = hh.hohid and st.HHType = hh.HHType) as RRHPSHPreMoveInDays
		,  (select count(distinct st.sysDate)
			from lsa.sys_Time st
			where st.sysStatus = 2
			and st.hohid = hh.hohid and st.HHType = hh.HHType) as RRHHousedDays
		,  (select count(distinct st.sysDate)
			from lsa.sys_Time st
			where st.sysStatus in (2,3,4,5,6)
			and st.hohid = hh.hohid and st.HHType = hh.HHType) as SystemDaysNotPSHHoused
		,  (select count(distinct st.sysDate)
			from lsa.sys_Time st
			where st.sysStatus in (3,4,5,6)
			and st.hohid = hh.hohid and st.HHType = hh.HHType) as SystemHomelessDays
		,  case
				when hh.Other3917Days is null then 0
				else hh.Other3917Days end
				+ (select count(distinct st.sysDate)
					from lsa.sys_Time st
					where st.sysStatus = 7
					and st.hohid = hh.hohid and st.HHType = hh.HHType) as Other3917Days
		, case
				when hh.Other3917Days is null then 0
				else hh.Other3917Days end + (select count(distinct st.sysDate)
			from lsa.sys_Time st
			where st.sysStatus in (3,4,5,6,7)
			and st.hohid = hh.hohid and st.HHType = hh.HHType) as TotalHomelessDays
		, (select count(distinct st.sysDate)
			from lsa.sys_Time st
			where st.sysStatus = 1
			and st.hohid = hh.hohid and st.HHType = hh.HHType) as PSHHousedDays
	from lsa.tlsa_Household hh )

	update lsa.tlsa_Household
	set ESDays = subquery_6_15.ESDays,
	THDays = subquery_6_15.THDays,
	ESTDays = subquery_6_15.ESTDays,
	RRHPSHPreMoveInDays = subquery_6_15.RRHPSHPreMoveInDays,
	RRHHousedDays = subquery_6_15.RRHHousedDays,
	SystemDaysNotPSHHoused = subquery_6_15.SystemDaysNotPSHHoused,
	SystemHomelessDays = subquery_6_15.SystemHomelessDays,
	Other3917Days = subquery_6_15.Other3917Days,
	TotalHomelessDays = subquery_6_15.TotalHomelessDays,
	PSHHousedDays = subquery_6_15.PSHHousedDays
		, Step = '6.15'
		from subquery_6_15
		where subquery_6_15.hohid = lsa.tlsa_Household.hohid ;

/*
	6.16 Update ESTStatus and RRHStatus
*/

with subquery_6_16_1 as (
	select distinct hh.hohid
	from lsa.tlsa_Household hh
	inner join lsa.sys_Time st on st.hohid = hh.hohid and st.HHType = hh.HHType
	where hh.ESTStatus = 0
		and st.sysStatus in (3,4)
)

with subquery_6_16_1 as (
select distinct hh.hohid
from lsa.tlsa_Household hh
inner join lsa.sys_Time st on st.hohid = hh.hohid and st.HHType = hh.HHType
where hh.ESTStatus = 0
and st.sysStatus in (3,4)
)
update lsa.tlsa_Household
set ESTStatus = 2
, Step = '6.16.1'
from subquery_6_16_1
where subquery_6_16_1.hohid = lsa.tlsa_Household.hohid ;


with subquery_6_16_2 as (
select distinct hh.hohid
from lsa.tlsa_Household hh
inner join lsa.sys_Time st on st.hohid = hh.hohid and st.HHType = hh.HHType
where hh.RRHStatus = 0
and st.sysStatus = 6
)

update lsa.tlsa_Household
set RRHStatus = 2
, Step = '6.16.2'
from subquery_6_16_2
where subquery_6_16_2.hohid = lsa.tlsa_Household.hohid ;


with subquery_6_16_3 as (
select distinct hh.hohid
from lsa.tlsa_Household hh
inner join lsa.sys_Time st on st.hohid = hh.hohid and st.HHType = hh.HHType
where hh.PSHStatus = 0
and st.sysStatus = 5
)

update lsa.tlsa_Household
set PSHStatus = 2
, Step = '6.16.3'
from subquery_6_16_3
where subquery_6_16_3.hohid = lsa.tlsa_Household.hohid ;

/*
	6.17 Set EST/RRH/PSHAHAR
*/
update lsa.tlsa_Household
set ESTAHAR = 0, RRHAHAR = 0, PSHAHAR = 0
	, Step = '6.17.1';



	with subquery_6_17_2 as (
	 select distinct hh.hohid
		from lsa.tlsa_Household hh
		inner join lsa.sys_Time st on st.hohid = hh.hohid and st.HHType = hh.HHType
		inner join lsa.lsa_Report rpt on st.sysDate between rpt.ReportStart and rpt.ReportEnd
			and st.sysStatus in (3,4)
		)
		update lsa.tlsa_Household
		set ESTAHAR = 1
			, Step = '6.17.2'
		from subquery_6_17_2
		where subquery_6_17_2.hohid =  lsa.tlsa_Household.hohid ;

	with subquery_6_17_3 as (
	 select distinct hh.hohid
		from lsa.tlsa_Household hh
		inner join lsa.sys_Time st on st.hohid = hh.hohid and st.HHType = hh.HHType
		inner join lsa.lsa_Report rpt on st.sysDate between rpt.ReportStart and rpt.ReportEnd
			and st.sysStatus = 2
		)

	update lsa.tlsa_Household
		set RRHAHAR = 1
			, Step = '6.17.3'
		from subquery_6_17_3
		where subquery_6_17_3.hohid =  lsa.tlsa_Household.hohid ;


	with subquery_6_17_4 as (
	 select distinct hh.hohid
		from lsa.tlsa_Household hh
		inner join lsa.sys_Time st on st.hohid = hh.hohid and st.HHType = hh.HHType
		inner join lsa.lsa_Report rpt on st.sysDate between rpt.ReportStart and rpt.ReportEnd
			and st.sysStatus = 1
		)


		update lsa.tlsa_Household
		set PSHAHAR = 1
			, Step = '6.17.44'
		from subquery_6_17_4
		where subquery_6_17_4.hohid =  lsa.tlsa_Household.hohid ;

/*
	6.18 Set SystemPath for LSAHousehold
*/

update lsa.tlsa_Household
set SystemPath =
	case when ESTStatus not in (21,22) and RRHStatus not in (21,22) and PSHMoveIn = 2
		then -1
	when ESDays >= 1 and THDays = 0 and RRHStatus = 0 and PSHStatus = 0
		then 1
	when ESDays = 0 and THDays >= 1 and RRHStatus = 0 and PSHStatus = 0
		then 2
	when ESDays >= 1 and THDays >= 1 and RRHStatus = 0 and PSHStatus = 0
		then 3
	when ESTStatus = 0 and RRHStatus >= 11 and PSHStatus = 0
		then 4
	when ESDays >= 1 and THDays = 0 and RRHStatus >= 2 and PSHStatus = 0
		then 5
	when ESDays = 0 and THDays >= 1 and RRHStatus >= 2 and PSHStatus = 0
		then 6
	when ESDays >= 1 and THDays >= 1 and RRHStatus >= 2 and PSHStatus = 0
		then 7
	when ESTStatus = 0 and RRHStatus = 0 and PSHStatus >= 11 and PSHMoveIn <> 2
		then 8
	when ESDays >= 1 and THDays = 0 and RRHStatus = 0 and PSHStatus >= 11 and PSHMoveIn <> 2
		then 9
	when ESTStatus in (21,22) and ESDays >= 1 and THDays = 0 and RRHStatus = 0 and PSHStatus >= 11 and PSHMoveIn = 2
		then 9
	when ESDays >= 1 and THDays <= 0 and RRHStatus >= 2 and PSHStatus >= 11 and PSHMoveIn <> 2
		then 10
	when ESTStatus in (21,22) and ESDays >= 1 and THDays = 0 and RRHStatus in (21,22) and PSHStatus >= 11 and PSHMoveIn = 2
		then 10
	when ESTStatus = 0 and RRHStatus >= 2 and PSHStatus >= 11 and PSHMoveIn <> 2
		then 11
	when ESTStatus = 0 and RRHStatus in (21,22) and PSHStatus >= 11 and PSHMoveIn = 2
		then 11
	else 12 end
	, Step = '6.18';

/*
	6.19 LSAHousehold
*/

delete from lsa.lsa_Household;
update lsa.tlsa_household  set estdestination = -1 where estdestination is null;
update lsa.tlsa_household  set rrhdestination = -1 where rrhdestination is null;
update lsa.tlsa_household  set pshdestination = -1 where pshdestination is null;
update lsa.tlsa_household  set rrhpremoveindays = 0 where rrhpremoveindays is null;


insert into lsa.lsa_Household(RowTotal
	, Stat, ReturnTime
	, HHType, HHChronic, HHVet, HHDisability, HHFleeingDV, HoHRace, HoHEthnicity
	, HHAdult, HHChild, HHNoDOB
	, HHAdultAge, HHParent
	, ESTStatus, ESTGeography, ESTLivingSit, ESTDestination, ESTChronic, ESTVet, ESTDisability, ESTFleeingDV, ESTAC3Plus, ESTAdultAge, ESTParent
	, RRHStatus, RRHMoveIn, RRHGeography, RRHLivingSit, RRHDestination, RRHPreMoveInDays, RRHChronic, RRHVet, RRHDisability, RRHFleeingDV, RRHAC3Plus, RRHAdultAge, RRHParent
	, PSHStatus, PSHMoveIn, PSHGeography, PSHLivingSit, PSHDestination, PSHHousedDays, PSHChronic, PSHVet, PSHDisability, PSHFleeingDV, PSHAC3Plus, PSHAdultAge, PSHParent
	, ESDays, THDays, ESTDays, RRHPSHPreMoveInDays, RRHHousedDays, SystemDaysNotPSHHoused, SystemHomelessDays, Other3917Days, TotalHomelessDays
	, SystemPath, ESTAHAR, RRHAHAR, PSHAHAR, ReportID
)
select count (distinct hohid || cast(HHType as varchar)), Stat
	, case when Stat in (1,5) then -1
		when ReturnTime between 15 and 30 then 30
		when ReturnTime between 31 and 60 then 60
		when ReturnTime between 61 and 90 then 90
		when ReturnTime between 91 and 180 then 180
		when ReturnTime between 181 and 365 then 365
		when ReturnTime between 366 and 547 then 547
		when ReturnTime >= 548 then 730
		else ReturnTime end
	, HHType, HHChronic, HHVet, HHDisability, HHFleeingDV, HoHRace, HoHEthnicity
	, HHAdult, HHChild, HHNoDOB
	, HHAdultAge, HHParent
	, ESTStatus, ESTGeography, ESTLivingSit, ESTDestination, ESTChronic, ESTVet, ESTDisability, ESTFleeingDV, ESTAC3Plus, ESTAdultAge, ESTParent
	, RRHStatus, RRHMoveIn, RRHGeography, RRHLivingSit, RRHDestination
	, case when RRHPreMoveInDays between 1 and 7 then 7
		when RRHPreMoveInDays between 8 and 30 then 30
		when RRHPreMoveInDays between 31 and 60 then 60
		when RRHPreMoveInDays between 61 and 90 then 90
		when RRHPreMoveInDays between 91 and 180 then 180
		when RRHPreMoveInDays between 181 and 365 then 365
		when RRHPreMoveInDays between 366 and 547 then 547
		when RRHPreMoveInDays between 548 and 730 then 730
		when RRHPreMoveInDays between 731 and 1094 then 1094
		when RRHPreMoveInDays > 1094 then 1095
		else RRHPreMoveInDays end
	, RRHChronic, RRHVet, RRHDisability, RRHFleeingDV, RRHAC3Plus, RRHAdultAge, RRHParent
	, PSHStatus, PSHMoveIn, PSHGeography, PSHLivingSit, PSHDestination
	--NOTE:  Groupings for PSHHousedDays differ from all other xDays columns
	, case when PSHHousedDays between 1 and 90 then 3
		when PSHHousedDays between 91 and 180 then 6
		when PSHHousedDays between 181 and 365 then 12
		when PSHHousedDays between 366 and 730 then 24
		when PSHHousedDays between 731 and 1095 then 36
		when PSHHousedDays between 1096 and 1460 then 48
		when PSHHousedDays between 1461 and 1825 then 60
		when PSHHousedDays between 1826 and 2555 then 84
		when PSHHousedDays between 2556 and 3650 then 120
		when PSHHousedDays > 3650 then 121
		else PSHHousedDays end
, PSHChronic, PSHVet, PSHDisability, PSHFleeingDV, PSHAC3Plus, PSHAdultAge, PSHParent
	, case when ESDays between 1 and 7 then 7
		when ESDays between 8 and 30 then 30
		when ESDays between 31 and 60 then 60
		when ESDays between 61 and 90 then 90
		when ESDays between 91 and 180 then 180
		when ESDays between 181 and 365 then 365
		when ESDays between 366 and 547 then 547
		when ESDays between 548 and 730 then 730
		when ESDays between 731 and 1094 then 1094
		when ESDays > 1094 then 1095
		else ESDays end
	, case when THDays between 1 and 7 then 7
		when THDays between 8 and 30 then 30
		when THDays between 31 and 60 then 60
		when THDays between 61 and 90 then 90
		when THDays between 91 and 180 then 180
		when THDays between 181 and 365 then 365
		when THDays between 366 and 547 then 547
		when THDays between 548 and 730 then 730
		when THDays between 731 and 1094 then 1094
		when THDays > 1094 then 1095
		else THDays end
	, case when ESTDays between 1 and 7 then 7
		when ESTDays between 8 and 30 then 30
		when ESTDays between 31 and 60 then 60
		when ESTDays between 61 and 90 then 90
		when ESTDays between 91 and 180 then 180
		when ESTDays between 181 and 365 then 365
		when ESTDays between 366 and 547 then 547
		when ESTDays between 548 and 730 then 730
		when ESTDays between 731 and 1094 then 1094
		when ESTDays > 1094 then 1095
		else ESTDays end
	, case when RRHPSHPreMoveInDays between 1 and 7 then 7
		when RRHPSHPreMoveInDays between 8 and 30 then 30
		when RRHPSHPreMoveInDays between 31 and 60 then 60
		when RRHPSHPreMoveInDays between 61 and 90 then 90
		when RRHPSHPreMoveInDays between 91 and 180 then 180
		when RRHPSHPreMoveInDays between 181 and 365 then 365
		when RRHPSHPreMoveInDays between 366 and 547 then 547
		when RRHPSHPreMoveInDays between 548 and 730 then 730
		when RRHPSHPreMoveInDays between 731 and 1094 then 1094
		when RRHPSHPreMoveInDays > 1094 then 1095
		else RRHPSHPreMoveInDays end
	, case when RRHHousedDays between 1 and 7 then 7
		when RRHHousedDays between 8 and 30 then 30
		when RRHHousedDays between 31 and 60 then 60
		when RRHHousedDays between 61 and 90 then 90
		when RRHHousedDays between 91 and 180 then 180
		when RRHHousedDays between 181 and 365 then 365
		when RRHHousedDays between 366 and 547 then 547
		when RRHHousedDays between 548 and 730 then 730
		when RRHHousedDays between 731 and 1094 then 1094
		when RRHHousedDays > 1094 then 1095
		else RRHHousedDays end
	, case when SystemDaysNotPSHHoused between 1 and 7 then 7
		when SystemDaysNotPSHHoused between 8 and 30 then 30
		when SystemDaysNotPSHHoused between 31 and 60 then 60
		when SystemDaysNotPSHHoused between 61 and 90 then 90
		when SystemDaysNotPSHHoused between 91 and 180 then 180
		when SystemDaysNotPSHHoused between 181 and 365 then 365
		when SystemDaysNotPSHHoused between 366 and 547 then 547
		when SystemDaysNotPSHHoused between 548 and 730 then 730
		when SystemDaysNotPSHHoused between 731 and 1094 then 1094
		when SystemDaysNotPSHHoused > 1094 then 1095
		else SystemDaysNotPSHHoused end
	, case when SystemHomelessDays between 1 and 7 then 7
		when SystemHomelessDays between 8 and 30 then 30
		when SystemHomelessDays between 31 and 60 then 60
		when SystemHomelessDays between 61 and 90 then 90
		when SystemHomelessDays between 91 and 180 then 180
		when SystemHomelessDays between 181 and 365 then 365
		when SystemHomelessDays between 366 and 547 then 547
		when SystemHomelessDays between 548 and 730 then 730
		when SystemHomelessDays between 731 and 1094 then 1094
		when SystemHomelessDays > 1094 then 1095
		else SystemHomelessDays end
	, case when Other3917Days between 1 and 7 then 7
		when Other3917Days between 8 and 30 then 30
		when Other3917Days between 31 and 60 then 60
		when Other3917Days between 61 and 90 then 90
		when Other3917Days between 91 and 180 then 180
		when Other3917Days between 181 and 365 then 365
		when Other3917Days between 366 and 547 then 547
		when Other3917Days between 548 and 730 then 730
		when Other3917Days between 731 and 1094 then 1094
		when Other3917Days > 1094 then 1095
		else Other3917Days end
	, case when TotalHomelessDays between 1 and 7 then 7
		when TotalHomelessDays between 8 and 30 then 30
		when TotalHomelessDays between 31 and 60 then 60
		when TotalHomelessDays between 61 and 90 then 90
		when TotalHomelessDays between 91 and 180 then 180
		when TotalHomelessDays between 181 and 365 then 365
		when TotalHomelessDays between 366 and 547 then 547
		when TotalHomelessDays between 548 and 730 then 730
		when TotalHomelessDays between 731 and 1094 then 1094
		when TotalHomelessDays > 1094 then 1095
		else TotalHomelessDays end
	, SystemPath, ESTAHAR, RRHAHAR, PSHAHAR, ReportID
from lsa.tlsa_Household
group by Stat
	, case when Stat in (1,5) then -1
		when ReturnTime between 15 and 30 then 30
		when ReturnTime between 31 and 60 then 60
		when ReturnTime between 61 and 90 then 90
		when ReturnTime between 91 and 180 then 180
		when ReturnTime between 181 and 365 then 365
		when ReturnTime between 366 and 547 then 547
		when ReturnTime >= 548 then 730
		else ReturnTime end
	, HHType, HHChronic, HHVet, HHDisability, HHFleeingDV, HoHRace, HoHEthnicity
	, HHAdult, HHChild, HHNoDOB
	, HHAdultAge, HHParent
	, ESTStatus, ESTGeography, ESTLivingSit, ESTDestination, ESTChronic, ESTVet, ESTDisability, ESTFleeingDV, ESTAC3Plus, ESTAdultAge, ESTParent
	, RRHStatus, RRHMoveIn, RRHGeography, RRHLivingSit, RRHDestination
	, case when RRHPreMoveInDays between 1 and 7 then 7
		when RRHPreMoveInDays between 8 and 30 then 30
		when RRHPreMoveInDays between 31 and 60 then 60
		when RRHPreMoveInDays between 61 and 90 then 90
		when RRHPreMoveInDays between 91 and 180 then 180
		when RRHPreMoveInDays between 181 and 365 then 365
		when RRHPreMoveInDays between 366 and 547 then 547
		when RRHPreMoveInDays between 548 and 730 then 730
		when RRHPreMoveInDays between 731 and 1094 then 1094
		when RRHPreMoveInDays > 1094 then 1095
		else RRHPreMoveInDays end
	, RRHChronic, RRHVet, RRHDisability, RRHFleeingDV, RRHAC3Plus, RRHAdultAge, RRHParent
	, PSHStatus, PSHMoveIn, PSHGeography, PSHLivingSit, PSHDestination
	, case when PSHHousedDays between 1 and 90 then 3
		when PSHHousedDays between 91 and 180 then 6
		when PSHHousedDays between 181 and 365 then 12
		when PSHHousedDays between 366 and 730 then 24
		when PSHHousedDays between 731 and 1095 then 36
		when PSHHousedDays between 1096 and 1460 then 48
		when PSHHousedDays between 1461 and 1825 then 60
		when PSHHousedDays between 1826 and 2555 then 84
		when PSHHousedDays between 2556 and 3650 then 120
		when PSHHousedDays > 3650 then 121
		else PSHHousedDays end
, PSHChronic, PSHVet, PSHDisability, PSHFleeingDV, PSHAC3Plus, PSHAdultAge, PSHParent
	, case when ESDays between 1 and 7 then 7
		when ESDays between 8 and 30 then 30
		when ESDays between 31 and 60 then 60
		when ESDays between 61 and 90 then 90
		when ESDays between 91 and 180 then 180
		when ESDays between 181 and 365 then 365
		when ESDays between 366 and 547 then 547
		when ESDays between 548 and 730 then 730
		when ESDays between 731 and 1094 then 1094
		when ESDays > 1094 then 1095
		else ESDays end
	, case when THDays between 1 and 7 then 7
		when THDays between 8 and 30 then 30
		when THDays between 31 and 60 then 60
		when THDays between 61 and 90 then 90
		when THDays between 91 and 180 then 180
		when THDays between 181 and 365 then 365
		when THDays between 366 and 547 then 547
		when THDays between 548 and 730 then 730
		when THDays between 731 and 1094 then 1094
		when THDays > 1094 then 1095
		else THDays end
	, case when ESTDays between 1 and 7 then 7
		when ESTDays between 8 and 30 then 30
		when ESTDays between 31 and 60 then 60
		when ESTDays between 61 and 90 then 90
		when ESTDays between 91 and 180 then 180
		when ESTDays between 181 and 365 then 365
		when ESTDays between 366 and 547 then 547
		when ESTDays between 548 and 730 then 730
		when ESTDays between 731 and 1094 then 1094
		when ESTDays > 1094 then 1095
		else ESTDays end
	, case when RRHPSHPreMoveInDays between 1 and 7 then 7
		when RRHPSHPreMoveInDays between 8 and 30 then 30
		when RRHPSHPreMoveInDays between 31 and 60 then 60
		when RRHPSHPreMoveInDays between 61 and 90 then 90
		when RRHPSHPreMoveInDays between 91 and 180 then 180
		when RRHPSHPreMoveInDays between 181 and 365 then 365
		when RRHPSHPreMoveInDays between 366 and 547 then 547
		when RRHPSHPreMoveInDays between 548 and 730 then 730
		when RRHPSHPreMoveInDays between 731 and 1094 then 1094
		when RRHPSHPreMoveInDays > 1094 then 1095
		else RRHPSHPreMoveInDays end
	, case when RRHHousedDays between 1 and 7 then 7
		when RRHHousedDays between 8 and 30 then 30
		when RRHHousedDays between 31 and 60 then 60
		when RRHHousedDays between 61 and 90 then 90
		when RRHHousedDays between 91 and 180 then 180
		when RRHHousedDays between 181 and 365 then 365
		when RRHHousedDays between 366 and 547 then 547
		when RRHHousedDays between 548 and 730 then 730
		when RRHHousedDays between 731 and 1094 then 1094
		when RRHHousedDays > 1094 then 1095
		else RRHHousedDays end
	, case when SystemDaysNotPSHHoused between 1 and 7 then 7
		when SystemDaysNotPSHHoused between 8 and 30 then 30
		when SystemDaysNotPSHHoused between 31 and 60 then 60
		when SystemDaysNotPSHHoused between 61 and 90 then 90
		when SystemDaysNotPSHHoused between 91 and 180 then 180
		when SystemDaysNotPSHHoused between 181 and 365 then 365
		when SystemDaysNotPSHHoused between 366 and 547 then 547
		when SystemDaysNotPSHHoused between 548 and 730 then 730
		when SystemDaysNotPSHHoused between 731 and 1094 then 1094
		when SystemDaysNotPSHHoused > 1094 then 1095
		else SystemDaysNotPSHHoused end
	, case when SystemHomelessDays between 1 and 7 then 7
		when SystemHomelessDays between 8 and 30 then 30
		when SystemHomelessDays between 31 and 60 then 60
		when SystemHomelessDays between 61 and 90 then 90
		when SystemHomelessDays between 91 and 180 then 180
		when SystemHomelessDays between 181 and 365 then 365
		when SystemHomelessDays between 366 and 547 then 547
		when SystemHomelessDays between 548 and 730 then 730
		when SystemHomelessDays between 731 and 1094 then 1094
		when SystemHomelessDays > 1094 then 1095
		else SystemHomelessDays end
	, case when Other3917Days between 1 and 7 then 7
		when Other3917Days between 8 and 30 then 30
		when Other3917Days between 31 and 60 then 60
		when Other3917Days between 61 and 90 then 90
		when Other3917Days between 91 and 180 then 180
		when Other3917Days between 181 and 365 then 365
		when Other3917Days between 366 and 547 then 547
		when Other3917Days between 548 and 730 then 730
		when Other3917Days between 731 and 1094 then 1094
		when Other3917Days > 1094 then 1095
		else Other3917Days end
	, case when TotalHomelessDays between 1 and 7 then 7
		when TotalHomelessDays between 8 and 30 then 30
		when TotalHomelessDays between 31 and 60 then 60
		when TotalHomelessDays between 61 and 90 then 90
		when TotalHomelessDays between 91 and 180 then 180
		when TotalHomelessDays between 181 and 365 then 365
		when TotalHomelessDays between 366 and 547 then 547
		when TotalHomelessDays between 548 and 730 then 730
		when TotalHomelessDays between 731 and 1094 then 1094
		when TotalHomelessDays > 1094 then 1095
		else TotalHomelessDays end
	, SystemPath, ESTAHAR, RRHAHAR, PSHAHAR, ReportID;

/*
	End LSAHousehold
*/
END
$function$
;
