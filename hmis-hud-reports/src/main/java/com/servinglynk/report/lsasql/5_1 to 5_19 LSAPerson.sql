CREATE OR REPLACE FUNCTION lsa.run_lsaperson (IN reportId integer, IN project_group_code varchar)
RETURNS void
 LANGUAGE plpgsql
AS $function$
BEGIN


WITH subquery AS (
		select  hhid.householdid  as HouseholdID
	from lsa.tlsa_HHID hhid
	inner join lsa.lsa_Report rpt on rpt.ReportEnd >= hhid.EntryDate
	inner join lsa.lsa_Project p on  p.ProjectID = hhid.ProjectID
	where (hhid.ExitDate is null or hhid.ExitDate >= rpt.ReportStart)
		and (select  coc.coc_code
			from v2020.enrollment_coc coc
			where cast (coc.enrollmentid as varchar) = hhid.EnrollmentID
				and coc.information_date <= rpt.ReportEnd
				and coc.deleted IS false and coc.parent_id is null
			order by coc.information_date desc limit 1) = rpt.ReportCoC
)

update lsa.tlsa_HHID
set Active = '1'
	, Step = '5.1'
	from subquery
	where subquery.HouseholdID = lsa.tlsa_HHID.HouseholdID ;

WITH subquery5_2 AS (
		select   n.enrollmentid  as enrollmentid
from lsa.lsa_Report rpt
	inner join lsa.tlsa_Enrollment n on n.EntryDate <= rpt.ReportEnd
	inner join lsa.tlsa_HHID hhid on hhid.HouseholdID = n.HouseholdID and hhid.Active = '1'
	where n.ExitDate is null or n.ExitDate >= rpt.ReportStart
)

/*
	5.2  Get Active Enrollments
*/

	update lsa.tlsa_Enrollment
	set Active = '1'
		, Step = '5.2'
		from subquery5_2
		where subquery5_2.enrollmentid = lsa.tlsa_Enrollment.enrollmentid ;


/*
	5.3 Get Active Clients for lsa.tlsa_Person
	5.4 LSAPerson Demographics
		(Gender, Race, Ethnicity, VetStatus, DisabilityStatus, and DVStatus)
*/
	delete from lsa.tlsa_Person;

		insert into lsa.tlsa_Person (PersonalID, HoHAdult,
			Gender, Ethnicity, Race, VetStatus, DisabilityStatus, DVStatus, ReportID, Step)
		select distinct n.PersonalID
			, HoHAdult.stat
		, case
				when HoHAdult.stat = 0 then -1
				when c.gender in ('8','9') then 98
				when c.gender in ('0','1','2') then cast (cast (c.gender as varchar) as integer) + 1
				when c.gender in ('3','4') then cast (cast (c.gender as varchar) as integer)
				else 99 end
			, case
				when HoHAdult.stat = 0 then -1
				when c.ethnicity in ('8','9') then 98
				when c.ethnicity in ('0','1') then cast (cast (c.ethnicity as varchar) as integer)
				else 99 end
			, case
				when HoHAdult.stat = 0 then -1
				when (c.race is not null and c.race1 is not null)  then 6
				when c.race in ('8','9') then 98
				when c.race = '5'  and c.ethnicity = '1' then 1
				when c.race = '5'  then 0
				when c.race = '3'  then 2
				when c.race = '2'  then 3
				when c.race = '1'  then 4
				when c.race = '4'  then 5
				else 99 end
			, case
				when HoHAdult.stat not in (1,3) then -1
				when c.veteran_status in ('8','9') then 98
				when c.veteran_status in ('0','1') then cast (cast (c.veteran_status as varchar)as integer)
				else 99 end
			, case
				when HoHAdult.stat = 0 then -1
				when Disability.stat is null then 99
				else Disability.stat end
			, case
				when HoHAdult.stat = 0 then -1
				when DV.stat = 10 then 0
				when DV.stat is null then 99
				else DV.stat end
			, rpt.ReportID
			, '5.3-5.4'
		from lsa.lsa_Report rpt
		inner join lsa.tlsa_Enrollment n on n.EntryDate <= rpt.ReportEnd and n.Active = '1'
		inner join
		--   HoHAdult identifies people served as heads of household or adults at any time in the report period.
		--     There is no corresponding column in lsa.lsa_Person -- it is only used to identify records for which
		--		demographic data are required / simplify the queries that set the column values.
		(select n.PersonalID, max(case when n.ActiveAge between 18 and 65 then 1
				else 0 end)
			--Plus ever served-as-HoH = 2
			  + max(case when n.RelationshipToHoH <> 1 then 0
				else 2 end) as stat
			--Equals:  0=Not HoH or Adult, 1=Adult, 2=HoH, 3=Both
			from lsa.tlsa_Enrollment n
			where n.Active = '1'
			group by n.PersonalID) HoHAdult on HoHAdult.PersonalID = n.PersonalID
		inner join v2020.client c on CAST (c.id AS varchar) = n.PersonalID and rpt.project_group_code=c.project_group_code and c.deleted IS false and c.parent_id is null
		left outer join
			(select n.PersonalID, max(n.DisabilityStatus) as stat
			from lsa.tlsa_Enrollment n
			where n.Active = '1'
			group by n.PersonalID) Disability on Disability.PersonalID = n.PersonalID
		left outer join
			(select n.PersonalID, min(n.DVStatus) as stat
			from lsa.tlsa_Enrollment n
			where n.Active = '1'
			group by n.PersonalID) DV on DV.PersonalID = n.PersonalID	;


/*
	5.5 Get Dates for Three Year Period Relevant to Chronic Homelessness Status
		 for Each Active Adult and Head of Household
*/
WITH subquery5_5_2 AS (
	select lp.PersonalID as personalid, max(case
			when n.ExitDate is null and
				(hhid.LastBedNight is null or hhid.LastBedNight = rpt.ReportEnd) then rpt.ReportEnd
			when hhid.LastBednight is not null then dateadd('d', 1, hhid.LastBednight)
			else n.ExitDate end)  as LastActive
		from lsa.lsa_Report rpt,
		lsa.tlsa_Enrollment n,
		lsa.tlsa_HHID hhid,
		lsa.tlsa_Person lp
		where
		n.EntryDate <= rpt.ReportEnd and n.Active = '1'
		and hhid.HouseholdID = n.HouseholdID
		and n.PersonalID = lp.PersonalID
		group by lp.PersonalID
)

	-- CH status is based on HMIS enrollment data in the three year period ending on the client's
	-- last active date in the report period.
	update lsa.tlsa_Person
	set LastActive =  subquery5_5_2.LastActive
		, Step = '5.5.1'
	from subquery5_5_2
	where subquery5_5_2.personalid = lsa.tlsa_Person.personalid
	and HoHAdult > 0;

	--The start of the period is:  LastActive minus (3 years) plus (1 day)
	update  lsa.tlsa_Person
	set CHStart = dateadd('d', 1, (dateadd('y', -3, LastActive)))
		, Step = '5.5.2'
	where HoHAdult > 0;


/*
	5.6 Enrollments Relevant to Counting ES/SH/Street Dates
*/
WITH subquery5_6 AS (
   select n.enrollmentid as enrollmentid
	from lsa.tlsa_Person lp
	inner join lsa.tlsa_Enrollment n on n.PersonalID = lp.PersonalID
		and n.EntryDate <= lp.LastActive
	inner join lsa.tlsa_HHID hhid on hhid.HouseholdID = n.HouseholdID
	where lp.HoHAdult > 0
		and (n.ExitDate is null or (n.ExitDate > lp.CHStart))
	)


	update lsa.tlsa_Enrollment
	set CH = '1'
		, Step = '5.6'
	from subquery5_6
	where subquery5_6.enrollmentid = lsa.tlsa_Enrollment.enrollmentid ;


/*
	5.7 Get Dates to Exclude from Counts of ES/SH/Street Days
*/

	-- lsa.ch_Exclude identifies dates between CHStart and LastActive when client was enrolled in TH
	-- or housed in RRH/PSH.
	delete from lsa.ch_Exclude;

	insert into lsa.ch_Exclude (PersonalID, excludeDate, Step)
	select distinct lp.PersonalID, cal.theDate, '5.7'
	from lsa.tlsa_Person lp
	inner join lsa.tlsa_Enrollment chn on chn.PersonalID = lp.PersonalID and chn.CH = '1'
	inner join lsa.ref_Calendar cal on cal.theDate >=
			case when chn.ProjectType in (3,13) then chn.MoveInDate
				else chn.EntryDate end
		and (cal.theDate < chn.ExitDate or chn.ExitDate is null)
		and cal.theDate between lp.CHStart and lp.LastActive
	where chn.ProjectType in (2,3,13) ;

/*
	5.8 Get Dates to Include in Counts of ES/SH/Street Days
*/
	--lsa.ch_Include identifies dates on which a client was in ES/SH or on the street
	-- (excluding any dates in lsa.ch_Exclude) based on:
	--	 HMIS entry/exit dates for enrollments in those project types
	--   Responses to DE 3.917 when EntryDate > CHStart
	--   Bed nights in nbn ES
	delete from lsa.ch_Include;


	--Dates enrolled in ES entry/exit or SH
	insert into lsa.ch_Include (PersonalID, ESSHStreetDate, Step)
	select distinct lp.PersonalID, cal.theDate, '5.8.1'
	from lsa.tlsa_Person lp
		inner join lsa.tlsa_Enrollment chn on chn.PersonalID = lp.PersonalID and chn.CH = '1'
		inner join lsa.ref_Calendar cal on
			cal.theDate >= chn.EntryDate
		and (cal.theDate < chn.ExitDate or chn.ExitDate is null)
			and cal.theDate between lp.CHStart and lp.LastActive
		left outer join lsa.ch_Exclude chx on chx.excludeDate = cal.theDate
			and chx.PersonalID = chn.PersonalID
	where (chn.ProjectType = 8 or (chn.ProjectType = 1 and chn.TrackingMethod = 0))
		and chx.excludeDate is null;

	--ES nbn bed nights
	insert into lsa.ch_Include (PersonalID, ESSHStreetDate, Step)
	select distinct lp.PersonalID, cal.theDate, '5.8.2'
	from lsa.tlsa_Person lp
		inner join lsa.tlsa_Enrollment chn on chn.PersonalID = lp.PersonalID and chn.CH = '1'
		inner join v2020.service_fa_referral bn on CAST (bn.enrollmentid AS varchar) = chn.EnrollmentID and bn.deleted is false and bn.parent_id is null
			and bn.record_type = '200'
			and bn.dateprovided >= chn.EntryDate
			and (bn.dateprovided < chn.ExitDate or chn.ExitDate is null)
			and bn.deleted = false
			and parent_id is null
		inner join lsa.ref_Calendar cal on
			cal.theDate = bn.dateprovided
			and cal.theDate between lp.CHStart and lp.LastActive
		left outer join lsa.ch_Exclude chx on chx.excludeDate = cal.theDate
			and chx.PersonalID = chn.PersonalID
		left outer join lsa.ch_Include chi on chi.ESSHStreetDate = cal.theDate
			and chi.PersonalID = chn.PersonalID
	where chn.ProjectType = 1 and chn.TrackingMethod = 3 and chx.excludeDate is null
		and chi.ESSHStreetDate is null;

	--ES/SH/Street dates from 3.917 DateToStreetESSH to the day prior to
	--  EntryDates > CHStart.
	insert into lsa.ch_Include (PersonalID, ESSHStreetDate, Step)
	select distinct lp.PersonalID, cal.theDate, '5.8.3'
	from lsa.tlsa_Person lp
		inner join lsa.tlsa_Enrollment chn on chn.PersonalID = lp.PersonalID
			and chn.EntryDate > lp.CHStart
		inner join v2020.enrollment hn on CAST(hn.id AS varchar)= chn.EnrollmentID and hn.deleted is false and hn.parent_id is null
		inner join lsa.ref_Calendar cal on
			cal.theDate >= hn.datetostreetessh
			and cal.theDate between lp.CHStart and lp.LastActive
		left outer join lsa.ch_Exclude chx on chx.excludeDate = cal.theDate
			and chx.PersonalID = chn.PersonalID
		left outer join lsa.ch_Include chi on chi.ESSHStreetDate = cal.theDate
			and chi.PersonalID = chn.PersonalID
	where chx.excludeDate is null
		and chi.ESSHStreetDate is NULL
        and (hn.LivingSituation in ('1','18','16')
			or (chn.ProjectType not in (1,8) and hn.PreviousStreetESSH = '1' and hn.LengthOfStay in ('10','11'))
			or (chn.ProjectType not in (1,8) and hn.PreviousStreetESSH = '1' and hn.LengthOfStay in ('2','3')
					and hn.LivingSituation in ('4','5','6','7','15','25'))
			)
		and (
			(-- for ES/SH/TH, count dates prior to EntryDate
				chn.ProjectType in (1,2,8) and cal.theDate < chn.EntryDate)
			or (-- for PSH/RRH, dates prior to and after EntryDate are counted for
				-- as long as the client remains homeless in the project
				chn.ProjectType in (3,13)
				and (cal.theDate < chn.MoveInDate
					 or (chn.MoveInDate is NULL and cal.theDate < chn.ExitDate)
					 or (chn.MoveInDate is NULL and chn.ExitDate is NULL and cal.theDate <= lp.LastActive)
					)
				)
			);

/*	--Gaps of less than 7 nights between two ESSHStreet dates are counted
	insert into lsa.ch_Include (PersonalID, ESSHStreetDate, Step)
	select gap.PersonalID, cal.theDate, '5.8.5'
	from (select distinct s.PersonalID, s.ESSHStreetDate as StartDate, min(e.ESSHStreetDate) as EndDate
			from lsa.ch_Include s
				inner join lsa.ch_Include e on e.PersonalID = s.PersonalID and e.ESSHStreetDate > s.ESSHStreetDate
					and dateadd('d', -7, e.ESSHStreetDate) <= s.ESSHStreetDate
			where s.PersonalID not in
				(select PersonalID
				from lsa.ch_Include
				where ESSHStreetDate = dateadd('d', 1, s.ESSHStreetDate))
			group by s.PersonalID, s.ESSHStreetDate) gap
		inner join lsa.ref_Calendar cal on cal.theDate between gap.StartDate and gap.EndDate
		left outer join lsa.ch_Include chi on chi.PersonalID = gap.PersonalID
			and chi.ESSHStreetDate = cal.theDate
	where chi.ESSHStreetDate is null;
	*/

   INSERT INTO lsa.ch_Include (PersonalID, ESSHStreetDate, Step)
   SELECT gap.PersonalID, cal.theDate, '5.8.5'
      FROM (SELECT *
              FROM (  SELECT DISTINCT
                             s.PersonalID,
                             s.ESSHStreetDate           AS StartDate,
                             MIN (e.ESSHStreetDate)     AS EndDate
                        FROM lsa.ch_Include s
                             INNER JOIN lsa.ch_Include e
                                 ON     e.PersonalID = s.PersonalID
                                    AND e.ESSHStreetDate > s.ESSHStreetDate
                                    AND dateadd ('d', -7, e.ESSHStreetDate) <=
                                        s.ESSHStreetDate
                    GROUP BY s.PersonalID, s.ESSHStreetDate) temp
             WHERE NOT EXISTS
                       (SELECT PersonalID
                          FROM lsa.ch_Include
                         WHERE     PersonalID = temp.PersonalID
                               AND ESSHStreetDate =
                                   dateadd ('d', 1, temp.StartDate))) gap
           INNER JOIN lsa.ref_Calendar cal
               ON cal.theDate BETWEEN gap.StartDate AND gap.EndDate
           LEFT OUTER JOIN lsa.ch_Include chi
               ON     chi.PersonalID = gap.PersonalID
                  AND chi.ESSHStreetDate = cal.theDate
     WHERE chi.ESSHStreetDate IS NULL;

/*
	5.9 Get ES/SH/Street Episodes
*/
	delete from lsa.ch_Episodes;

	-- For any given PersonalID:
	-- Any ESSHStreetDate in lsa.ch_Include without a record for the day before is the start of an episode (episodeStart).
	-- Any cdDate in lsa.ch_Include without a record for the day after is the end of an episode (episodeEnd).
	-- Each episodeStart combined with the next earliest episodeEnd represents one episode.
	-- The length of the episode is the difference in days between episodeStart and episodeEnd + 1 day.
/*
	insert into lsa.ch_Episodes (PersonalID, episodeStart, episodeEnd, Step)
	select distinct s.PersonalID, s.ESSHStreetDate, min(e.ESSHStreetDate), '5.9.1'
	from lsa.ch_Include s
	inner join lsa.ch_Include e on e.PersonalID = s.PersonalID  and e.ESSHStreetDate >= s.ESSHStreetDate
	--any date in lsa.ch_Include without a record for the day before is the start of an episode
	where s.PersonalID not in (select PersonalID from lsa.ch_Include where ESSHStreetDate = dateadd('d', -1, s.ESSHStreetDate))
	--any date in lsa.ch_Include without a record for the day after is the end of an episode
			and e.PersonalID not in (select PersonalID from lsa.ch_Include where ESSHStreetDate = dateadd('d', 1, e.ESSHStreetDate))
	group by s.PersonalID, s.ESSHStreetDate;*/

   insert into lsa.ch_Episodes (PersonalID, episodeStart, episodeEnd, Step)
   select distinct s.PersonalID, s.ESSHStreetDate, min(e.ESSHStreetDate), '5.9.1'
	 from lsa.ch_Include s
	inner join lsa.ch_Include e on e.PersonalID = s.PersonalID  and e.ESSHStreetDate >= s.ESSHStreetDate
	where not exists (select PersonalID from lsa.ch_Include where PersonalID  = s.PersonalID and ESSHStreetDate = dateadd('d', -1, s.ESSHStreetDate))
	  and not exists (select PersonalID from lsa.ch_Include where PersonalID  = e.PersonalID and ESSHStreetDate = dateadd('d', 1, e.ESSHStreetDate))
	group by s.PersonalID, s.ESSHStreetDate;

	update lsa.ch_Episodes
	set episodeDays = DATE_PART('day', episodeEnd::timestamp - episodeStart::timestamp) + 1
		, Step = '5.9.2';



/*
	5.10 Set CHTime and CHTimeStatus
*/

	--Any client with a 365+ day episode that overlaps with their
	--last year of activity meets the time criteria for CH
	update lsa.tlsa_Person
	set CHTime = case when HoHAdult = 0 then -1 else 0 end
		, CHTimeStatus = -1
		, Step = '5.10.1';

	WITH subquery_5_10_2 AS (
	select lp.personalid  as personalid
	from lsa.tlsa_Person lp
		inner join lsa.ch_Episodes chep on chep.PersonalID = lp.PersonalID
			and chep.episodeDays >= 365
			and chep.episodeEnd > dateadd('y', -1, lp.LastActive)
	where lp.CHTime = 0

)
	update lsa.tlsa_Person
	set CHTime = 365, CHTimeStatus = 1, Step = '5.10.2'
	from subquery_5_10_2
	where subquery_5_10_2.personalid = lsa.tlsa_Person.personalid ;

	--Clients with a total of 365+ days in the three year period and at least four episodes
	--  meet time criteria for CH
	WITH subquery_5_10_3 AS (
select lp.personalid  as personalid ,
	 case
			when ep.episodeDays >= 365 then 365
			when ep.episodeDays between 270 and 364 then 270
			else 0 end as CHTime
		,  case
			when ep.episodeDays < 365 then -1
			when ep.episodes >= 4 then 2
			else 3 end as CHTimeStatus
	from lsa.tlsa_Person lp
	inner join (select chep.PersonalID
		, sum(chep.episodeDays) as episodeDays, count(distinct chep.episodeStart) as episodes
		from lsa.ch_Episodes chep
		group by chep.PersonalID) ep on ep.PersonalID = lp.PersonalID
	where lp.CHTime = 0
	)

	update lsa.tlsa_Person
	set CHTime =subquery_5_10_3.CHTime,
	CHTimeStatus = subquery_5_10_3.CHTimeStatus,
	 Step = '5.10.3'
	 from subquery_5_10_3
	 where subquery_5_10_3.personalid = lsa.tlsa_Person.personalid ;

WITH subquery_5_10_4 AS (
	select lp.personalid  as personalid
	from lsa.tlsa_Person lp
		inner join lsa.tlsa_Enrollment chn on chn.PersonalID = lp.PersonalID and chn.CH = '1'
		inner join v2020.enrollment hn on CAST(hn.id AS varchar) = chn.EnrollmentID and hn.deleted is false and hn.parent_id is null
			and hn.monthshomelesspastthreeyears in ('112','113')
			and hn.timeshomelesspastthreeyears = '4'
			and hn.entrydate > dateadd('y', -1, lp.LastActive)
	where
		lp.CHTime not in (-1,365) or lp.CHTimeStatus = 3
	)

	--Clients with 3.917 data for an entry in their last year of activity
	--  showing 12+ months and 4+ episodes meet time criteria for CH
	update lsa.tlsa_Person
	set CHTime = 400
		, CHTimeStatus = 2
		, Step = '5.10.4'
		from subquery_5_10_4
		where subquery_5_10_4.personalid = lsa.tlsa_Person.personalid ;



	--Anyone who doesn't meet CH time criteria and is missing data in 3.917
	--for an active enrollment should be identified as missing data.
WITH subquery_5_10_5 AS (
	select distinct lp.personalid  as personalid
	from lsa.tlsa_Person lp
		inner join lsa.tlsa_Enrollment chn on chn.PersonalID = lp.PersonalID and chn.CH = '1'
		inner join v2020.enrollment hn on CAST (hn.id AS varchar)= chn.EnrollmentID and hn.deleted is false and hn.parent_id is null
	where (lp.CHTime in (0,270) or lp.CHTimeStatus = 3)
		and (hn.datetostreetessh> hn.entrydate
				or (hn.livingsituation in ('8','9','99') or hn.livingsituation is null)
				or (hn.lengthofstay in ('8','9','99') or hn.lengthofstay is null)
				or (chn.ProjectType not in ('1','8') and hn.livingsituation in ('4','5','6','7','15','25')
						and hn.lengthofstay in ('2','3')
						and (hn.previousstreetessh is null or hn.previousstreetessh not in ('0','1')))
				or (chn.ProjectType not in ('1','8') and hn.lengthofstay in ('10','11')
							and (hn.previousstreetessh is null or hn.previousstreetessh not in ('0','1')))
				or ((chn.ProjectType in ('1','8')
					  or hn.livingsituation in ('1','16','18')
					  or (chn.ProjectType not in ('1','8') and hn.livingsituation in ('4','5','6','7','15','25')
							and hn.lengthofstay in ('2','3')
							and hn.previousstreetessh = '1')
					  or (chn.ProjectType not in ('1','8') and hn.lengthofstay in ('10','11')
							and hn.previousstreetessh = '1')
					)
					and (
						hn.monthshomelesspastthreeyears in ('8','9','99')
							or hn.monthshomelesspastthreeyears is null
							or hn.timeshomelesspastthreeyears in ('8','9','99')
							or hn.timeshomelesspastthreeyears is null
							or hn.datetostreetessh is null
						)
			))
			)


	update lsa.tlsa_Person
	set CHTimeStatus = 99
		,Step = '5.10.5'
		from subquery_5_10_5
		where subquery_5_10_5.personalid = lsa.tlsa_Person.personalid ;

/*
	5.11 EST/RRH/PSH AgeMin and AgeMax - LSAPerson
*/




UPDATE lsa.tlsa_Person
SET ESTAgemin = lsa.tlsa_Enrollment.ActiveAge,
 ESTAgemax = lsa.tlsa_Enrollment.ActiveAge,
Step = '5.11.2'
FROM lsa.tlsa_Enrollment
WHERE
lsa.tlsa_Enrollment.PersonalID = lsa.tlsa_Person.PersonalID
and lsa.tlsa_Enrollment.ProjectType in ('1','2','8')
and lsa.tlsa_Enrollment.Active = '1';


UPDATE lsa.tlsa_Person
SET RRHAgeMax = lsa.tlsa_Enrollment.ActiveAge,
 RRHAgeMin = lsa.tlsa_Enrollment.ActiveAge,
Step = '5.11.4'
FROM lsa.tlsa_Enrollment
WHERE
lsa.tlsa_Enrollment.PersonalID = lsa.tlsa_Person.PersonalID
and lsa.tlsa_Enrollment.ProjectType ='13'
and lsa.tlsa_Enrollment.Active = '1';


UPDATE lsa.tlsa_Person
SET PSHAgeMin = lsa.tlsa_Enrollment.ActiveAge,
 PSHAgeMax = lsa.tlsa_Enrollment.ActiveAge,
Step = '5.11.6'
FROM lsa.tlsa_Enrollment
WHERE
lsa.tlsa_Enrollment.PersonalID = lsa.tlsa_Person.PersonalID
and lsa.tlsa_Enrollment.ProjectType ='3'
and lsa.tlsa_Enrollment.Active = '1';


update lsa.tlsa_Person   set ESTAgemin =-1 where ESTAgemin is null;
update lsa.tlsa_Person   set ESTAgemax =-1 where ESTAgemax is null;
update lsa.tlsa_Person   set RRHAgeMax =-1 where RRHAgeMax is null;
update lsa.tlsa_Person   set RRHAgeMin =-1 where RRHAgeMin is null;
update lsa.tlsa_Person   set PSHAgeMin =-1 where PSHAgeMin is null;
update lsa.tlsa_Person   set PSHAgeMax =-1 where PSHAgeMax is null;


	/*
	5.12 Set lsa.tlsa_Person Project Group Identifiers by Household Type
*/
WITH subquery_5_12_1 AS (
select lp.PersonalID as personalid ,
		case when hh.HHTypeCombined is null then -1
		else hh.HHTypeCombined end as HHTypeCombined
	from lsa.tlsa_Person lp
		left outer join --Level 2 - combine HHTypes into a single value
		 (select HHTypes.PersonalID
			, cast(replace(cast(sum(HHTypes.HHTypeEach) as varchar), '0', '') as int)
				as HHTypeCombined
			from --Level 1 - get distinct HHTypes for EST
					 (select distinct n.PersonalID
						, case when hhid.ActiveHHType = 1 then 1000
							when hhid.ActiveHHType = 2 then 200
							when hhid.ActiveHHType = 3 then 30
							else 9 end as HHTypeEach
						from lsa.tlsa_Enrollment n
						inner join lsa.tlsa_HHID hhid on hhid.HouseholdID = n.HouseholdID
						where n.ProjectType in (1,2,8) and n.Active = '1') HHTypes
			group by HHTypes.PersonalID
			) hh on hh.PersonalID = lp.PersonalID
		)
	--set EST HHType
	update lsa.tlsa_Person
	set HHTypeEST =subquery_5_12_1.HHTypeCombined
	, Step = '5.12.1'
	from subquery_5_12_1
	where subquery_5_12_1.personalid = lsa.tlsa_Person.personalid ;

	WITH subquery_5_12_2 AS (
		select lp.personalid as personalid , case when hh.HHTypeCombined is null then -1
		else hh.HHTypeCombined end as HHTypeCombined
	from lsa.tlsa_Person lp
		left outer join --Level 2 - combine HHTypes into a single value
		 (select HHTypes.PersonalID
			, cast(replace(cast(sum(HHTypes.HHTypeEach) as varchar), '0', '') as int)
				as HHTypeCombined
			from --Level 1 - get distinct HHTypes for EST
					 (select distinct n.PersonalID
						, case when hhid.ActiveHHType = 1 then 1000
							when hhid.ActiveHHType = 2 then 200
							when hhid.ActiveHHType = 3 then 30
							else 9 end as HHTypeEach
						from lsa.tlsa_Enrollment n
						inner join lsa.tlsa_HHID hhid on hhid.HouseholdID = n.HouseholdID
						where n.ProjectType = 13 and n.Active = '1') HHTypes
			group by HHTypes.PersonalID
			) hh on hh.PersonalID = lp.PersonalID
)

	--set RRH HHType
	update lsa.tlsa_Person
	set HHTypeRRH = subquery_5_12_2.HHTypeCombined
	, Step = '5.12.2'
	from subquery_5_12_2
	where subquery_5_12_2.personalid = lsa.tlsa_Person.personalid ;

	--set PSH HHType
WITH subquery_5_12_3 AS (
   select lp.PersonalID as personalid,
			case when hh.HHTypeCombined is null then -1
		else hh.HHTypeCombined end as HHTypeCombined
	from lsa.tlsa_Person lp
		left outer join --Level 2 - combine HHTypes into a single value
		 (select HHTypes.PersonalID
			, cast(replace(cast(sum(HHTypes.HHTypeEach) as varchar), '0', '') as int)
				as HHTypeCombined
			from --Level 1 - get distinct HHTypes for EST
					 (select distinct n.PersonalID
						, case when hhid.ActiveHHType = 1 then 1000
							when hhid.ActiveHHType = 2 then 200
							when hhid.ActiveHHType = 3 then 30
							else 9 end as HHTypeEach
						from lsa.tlsa_Enrollment n
						inner join lsa.tlsa_HHID hhid on hhid.HouseholdID = n.HouseholdID
						where n.ProjectType = 3 and n.Active = '1') HHTypes
			group by HHTypes.PersonalID
			) hh on hh.PersonalID = lp.PersonalID
			)

	update lsa.tlsa_Person
	set HHTypePSH = subquery_5_12_3.HHTypeCombined
, Step = '5.12.3'
from subquery_5_12_3
where subquery_5_12_3.personalid = lsa.tlsa_Person.personalid ;

/*
	5.13 Set lsa.tlsa_Person Head of Household Identifiers by HHType for Each Project Group
*/

	--set EST HoH identifiers
	WITH subquery_5_13_1 AS (
	select lp.PersonalID as PersonalID ,
		case when lp.HoHAdult not in (2,3) or lp.HHTypeEST = -1 then -1
		else COALESCE
			(
				(select cast(replace(cast(sum(HHTypes.HHTypeEach) as varchar), '0', '') as int)
				 from
					 (select distinct n.PersonalID
						, case when hhid.ActiveHHType = 1 then 1000
							when hhid.ActiveHHType = 2 then 200
							when hhid.ActiveHHType = 3 then 30
							else 9 end as HHTypeEach
						from lsa.tlsa_Enrollment n
						inner join lsa.tlsa_HHID hhid on hhid.HouseholdID = n.HouseholdID
						where n.Active = '1' and n.ProjectType in (1,2,8) and n.RelationshipToHoH = 1) HHTypes
				where HHTypes.PersonalID = lp.PersonalID)
			, -1) end as HoHEST
	from lsa.tlsa_Person lp
	)

	update lsa.tlsa_Person lsaPerson
	set HoHEST = subquery_5_13_1.HoHEST
		, Step = '5.13.1'
	from subquery_5_13_1
 where lsaPerson.PersonalID = subquery_5_13_1.PersonalID;

WITH subquery_5_13_2 AS (
select lp.personalid  as personalid,
		case when lp.HoHAdult not in (2,3) or lp.HHTypeRRH = -1 then -1
		else COALESCE
			(
				(select cast(replace(cast(sum(HHTypes.HHTypeEach) as varchar), '0', '') as int)
				 from
					 (select distinct n.PersonalID
						, case when hhid.ActiveHHType = 1 then 1000
							when hhid.ActiveHHType = 2 then 200
							when hhid.ActiveHHType = 3 then 30
							else 9 end as HHTypeEach
						from lsa.tlsa_Enrollment n
						inner join lsa.tlsa_HHID hhid on hhid.HouseholdID = n.HouseholdID
						where n.Active = '1' and n.ProjectType = 13 and n.RelationshipToHoH = 1) HHTypes
				where HHTypes.PersonalID = lp.PersonalID)
			, -1) end as HoHRRH
			from lsa.tlsa_Person lp
	)

	--set RRH HoH identifiers
	update lsa.tlsa_Person  lsap
	set HoHRRH =subquery_5_13_2.HoHRRH
	, Step = '5.13.2'
	from subquery_5_13_2
    where lsap.PersonalID = subquery_5_13_2.PersonalID;

   WITH subquery_5_13_3 AS (
select lp.personalid  as personalid,
   	case when lp.HoHAdult not in (2,3) or lp.HHTypePSH = -1 then -1
		else COALESCE
			(
				(select cast(replace(cast(sum(HHTypes.HHTypeEach) as varchar), '0', '') as int)
				 from
					 (select distinct n.PersonalID
						, case when hhid.ActiveHHType = 1 then 1000
							when hhid.ActiveHHType = 2 then 200
							when hhid.ActiveHHType = 3 then 30
							else 9 end as HHTypeEach
						from lsa.tlsa_Enrollment n
						inner join lsa.tlsa_HHID hhid on hhid.HouseholdID = n.HouseholdID
						where n.Active = '1' and n.ProjectType = 3 and n.RelationshipToHoH = 1) HHTypes
				where HHTypes.PersonalID = lp.PersonalID)
			, -1) end as HoHPSH
				from lsa.tlsa_Person lp
		)
	--set PSH HoH identifiers
	update lsa.tlsa_Person lsap
	set HoHPSH =subquery_5_13_3.HoHPSH
	, Step = '5.13.3'
	from subquery_5_13_3 where
	lsap.PersonalID = subquery_5_13_3.PersonalID;

/*
	5.14 Set lsa.tlsa_Person AHAR Identifiers by HHType for each Project Group
*/
   WITH subquery_5_14_1 AS (
select lp.personalid  as personalid,
	case when lp.HHTypeEST = -1 then -1
			else COALESCE
				(
					(select cast(replace(cast(sum(HHTypes.HHTypeEach) as varchar), '0', '') as int)
				 from
					 (select distinct n.PersonalID
						, case when hhid.ActiveHHType = 1 then 1000
							when hhid.ActiveHHType = 2 then 200
							when hhid.ActiveHHType = 3 then 30
							else 9 end as HHTypeEach
						from lsa.tlsa_Enrollment n
						inner join lsa.tlsa_HHID hhid on hhid.HouseholdID = n.HouseholdID
						where n.Active = '1' and n.ProjectType in (1,2,8)
							and (n.ExitDate is null or n.ExitDate > (select ReportStart from lsa.lsa_Report ))) HHTypes
					where HHTypes.PersonalID = lp.PersonalID)
				, -1) end as AHAREST
				from lsa.tlsa_Person lp
		)
	--set EST AHAR HHType
	update lsa.tlsa_Person lsap
	set AHAREST = subquery_5_14_1.AHAREST
		, Step = '5.14.1'
	from subquery_5_14_1
	where lsap.PersonalID = subquery_5_14_1.PersonalID;

   WITH subquery_5_14_2 AS (
select lp.personalid  as personalid,
case when lp.HHTypeRRH = -1 then -1
			else COALESCE
				(
					(select cast(replace(cast(sum(HHTypes.HHTypeEach) as varchar), '0', '') as int)
				 from
					 (select distinct n.PersonalID
						, case when hhid.ActiveHHType = 1 then 1000
							when hhid.ActiveHHType = 2 then 200
							when hhid.ActiveHHType = 3 then 30
							else 9 end as HHTypeEach
						from lsa.tlsa_Enrollment n
						inner join lsa.lsa_Report rpt on n.Active = '1'
						inner join lsa.tlsa_HHID hhid on hhid.HouseholdID = n.HouseholdID
						where n.ProjectType = 13
                            and n.MoveInDate is not null
							and
							(n.ExitDate is null
							 or n.ExitDate > rpt.ReportStart
							 or (n.MoveInDate = n.ExitDate and n.MoveInDate = rpt.ReportStart))) HHTypes
					where HHTypes.PersonalID = lp.PersonalID)
				, -1) end as AHARRRH
				from lsa.tlsa_Person lp
		)


	--set RRH HHType
	update lsa.tlsa_Person lsap
	set AHARRRH =subquery_5_14_2.AHARRRH
		, Step = '5.14.2'
	from subquery_5_14_2 where
	lsap.PersonalID = subquery_5_14_2.PersonalID;

   WITH subquery_5_14_3 AS (
select lp.personalid  as personalid,
case when lp.HHTypePSH = -1 then -1
			else COALESCE
				(
					(select cast(replace(cast(sum(HHTypes.HHTypeEach) as varchar), '0', '') as int)
				 from
					 (select distinct n.PersonalID
						, case when hhid.ActiveHHType = 1 then 1000
							when hhid.ActiveHHType = 2 then 200
							when hhid.ActiveHHType = 3 then 30
					        else 9 end as HHTypeEach
							from lsa.tlsa_Enrollment n
					inner join lsa.tlsa_HHID hhid on hhid.HouseholdID = n.HouseholdID
						where n.Active = '1' and n.ProjectType = 3 and n.MoveInDate is not null
							and (n.ExitDate is null or n.ExitDate > (select ReportStart from lsa.lsa_Report))) HHTypes
					where HHTypes.PersonalID = lp.PersonalID)
				, -1) end as AHARPSH
					from lsa.tlsa_Person lp
		)


	--set PSH HHType
	update lsa.tlsa_Person lsap
	set AHARPSH = subquery_5_14_3.AHARPSH
	, Step = '5.14.3'
	from subquery_5_14_3 where
lsap.PersonalID = subquery_5_14_3.PersonalID;

/*
	5.15 Set lsa.tlsa_Person AHAR Adult Identifiers by HHType for each Project Group
*/
   WITH subquery_5_15_1 AS (
select lp.personalid  as personalid,
case when lp.HoHAdult not in (1,3) or lp.AHAREST = -1 then -1
			else COALESCE
				(
					(select cast(replace(cast(sum(HHTypes.HHTypeEach) as varchar), '0', '') as int)
				 from
					 (select distinct n.PersonalID
						, case when hhid.ActiveHHType = 1 then 1000
							when hhid.ActiveHHType = 2 then 200
							else 9 end as HHTypeEach
						from lsa.tlsa_Enrollment n
						inner join lsa.tlsa_HHID hhid on hhid.HouseholdID = n.HouseholdID
						where n.Active = '1' and n.ProjectType in (1,2,8) and n.ActiveAge between 18 and 65
							and (n.ExitDate is null or n.ExitDate > (select ReportStart from lsa.lsa_Report))) HHTypes
					where HHTypes.PersonalID = lp.PersonalID)
				, -1) end as AdultEST
					from lsa.tlsa_Person lp
		)



	--set AdultEST
	update lsa.tlsa_Person lsap
	set AdultEST =subquery_5_15_1.AdultEST
	, Step = '5.15.1'
	from subquery_5_15_1 where
    lsap.PersonalID = subquery_5_15_1.PersonalID;

      WITH subquery_5_15_2 AS (
select lp.personalid  as personalid,
   case when lp.HoHAdult not in (1,3) or lp.AHARRRH = -1 then -1
			else COALESCE
				(
					(select cast(replace(cast(sum(HHTypes.HHTypeEach) as varchar), '0', '') as int)
				 from
					 (select distinct n.PersonalID
						, case when hhid.ActiveHHType = 1 then 1000
							when hhid.ActiveHHType = 2 then 200
							else 9 end as HHTypeEach
						from lsa.tlsa_Enrollment n
						inner join lsa.lsa_Report rpt on n.Active = '1'
						inner join lsa.tlsa_HHID hhid on hhid.HouseholdID = n.HouseholdID
						where n.ProjectType = 13
                            and n.MoveInDate is not null
							and n.ActiveAge between 18 and 65
							and
							(n.ExitDate is null
							 or n.ExitDate > rpt.ReportStart
							 or (n.MoveInDate = n.ExitDate and n.MoveInDate = rpt.ReportStart
							 ))) HHTypes
					where HHTypes.PersonalID = lp.PersonalID)
				, -1) end as AdultRRH
			from lsa.tlsa_Person lp
			)

	--set AdultRRH
	update lsa.tlsa_Person lsap
	set AdultRRH =subquery_5_15_2.AdultRRH
		, Step = '5.15.2'
	from subquery_5_15_2
   where lsap.PersonalID = subquery_5_15_2.PersonalID;


    WITH subquery_5_15_3 AS (
select lp.personalid  as personalid,
		case when lp.HoHAdult not in (1,3) or lp.AHAREST = -1 then -1
			else COALESCE
				(
					(select cast(replace(cast(sum(HHTypes.HHTypeEach) as varchar), '0', '') as int)
				 from
					 (select distinct n.PersonalID
						, case when hhid.ActiveHHType = 1 then 1000
							when hhid.ActiveHHType = 2 then 200
							else 9 end as HHTypeEach
						from lsa.tlsa_Enrollment n
						inner join lsa.tlsa_HHID hhid on hhid.HouseholdID = n.HouseholdID
						where n.Active = '1' and n.ProjectType = 3 and n.MoveInDate is not null
							and (n.ExitDate is null or n.ExitDate > (select ReportStart from lsa.lsa_Report))
							and n.ActiveAge between 18 and 65) HHTypes
				where HHTypes.PersonalID = lp.PersonalID)
				, -1) end as AdultPSH
				from lsa.tlsa_Person lp
			)


	--set AdultPSH Sandeep need to fix this
	update lsa.tlsa_Person
	set AdultPSH=subquery_5_15_3.AdultPSH
		, Step = '5.15.3'
	from subquery_5_15_3
	where subquery_5_15_3.personalid = lsa.tlsa_Person.personalid;




/*
	5.16 Set lsa.tlsa_Person AHAR Head of Household Identifiers by HHType for each Project Group
*/
    WITH subquery_5_16_1 AS (
select lp.personalid  as personalid,
case when lp.HoHEST = -1 or lp.AHAREST = -1 then -1
			else COALESCE
				(
					(select cast(replace(cast(sum(HHTypes.HHTypeEach) as varchar), '0', '') as int)
				 from
					 (select distinct n.PersonalID
						, case when hhid.ActiveHHType = 1 then 1000
							when hhid.ActiveHHType = 2 then 200
							when hhid.ActiveHHType = 3 then 30
							else 9 end as HHTypeEach
						from lsa.tlsa_Enrollment n
						inner join lsa.tlsa_HHID hhid on hhid.HouseholdID = n.HouseholdID
						where n.Active = '1' and n.ProjectType in (1,2,8) and n.RelationshipToHoH = 1
							and (n.ExitDate is null or n.ExitDate > (select ReportStart from lsa.lsa_Report))) HHTypes
				where HHTypes.PersonalID = lp.PersonalID)
				, -1) end as AHARHoHEST
				from lsa.tlsa_Person lp
			)


	update lsa.tlsa_Person lp
	set AHARHoHEST = subquery_5_16_1.AHARHoHEST
		, Step = '5.16.1'
from subquery_5_16_1
where subquery_5_16_1.PersonalID = lp.personalid ;

   WITH subquery_5_16_2 AS (
select lp.personalid  as personalid,
case when lp.HoHRRH = -1 or lp.AHARRRH = -1 then -1
			else COALESCE
				(
					(select cast(replace(cast(sum(HHTypes.HHTypeEach) as varchar), '0', '') as int)
				 from
					 (select distinct n.PersonalID
						, case when hhid.ActiveHHType = 1 then 1000
							when hhid.ActiveHHType = 2 then 200
							when hhid.ActiveHHType = 3 then 30
							else 9 end as HHTypeEach
						from lsa.tlsa_Enrollment n
						inner join lsa.lsa_Report rpt on n.Active = '1'
						inner join lsa.tlsa_HHID hhid on hhid.HouseholdID = n.HouseholdID
						where n.ProjectType = 13
							and n.RelationshipToHoH = 1
                                                        and n.MoveInDate is not null
							and
							(n.ExitDate is null
							 or n.ExitDate > rpt.ReportStart
							 or (n.MoveInDate = n.ExitDate and n.MoveInDate = rpt.ReportStart
							 ))) HHTypes
					where HHTypes.PersonalID = lp.PersonalID)
				, -1) end as AHARHoHRRH
			from lsa.tlsa_Person lp
			)

	--set RRH HHType
	update lsa.tlsa_Person lp
	set AHARHoHRRH =subquery_5_16_2.AHARHoHRRH
		, Step = '5.16.2'
		from subquery_5_16_2
	where subquery_5_16_2.personalid = lp.personalid ;

   WITH subquery_5_16_3 AS (
select lp.personalid  as personalid,
case when lp.HoHPSH = -1 or lp.AHARPSH = -1 then -1
			else COALESCE
				(
					(select cast(replace(cast(sum(HHTypes.HHTypeEach) as varchar), '0', '') as int)
				 from
					 (select distinct n.PersonalID
						, case when hhid.ActiveHHType = 1 then 1000
							when hhid.ActiveHHType = 2 then 200
							when hhid.ActiveHHType = 3 then 30
							else 9 end as HHTypeEach
						from lsa.tlsa_Enrollment n
						inner join lsa.tlsa_HHID hhid on hhid.HouseholdID = n.HouseholdID
						where n.Active = '1' and n.ProjectType = 3 and n.MoveInDate is not null
							and (n.ExitDate is null or n.ExitDate > (select ReportStart from lsa.lsa_Report))
							and n.RelationshipToHoH = 1) HHTypes
					where HHTypes.PersonalID = lp.PersonalID)
				, -1) end as AHARHoHPSH
				from lsa.tlsa_Person lp
			)


	--set PSH HHType
	update lsa.tlsa_Person lp
	set AHARHoHPSH =subquery_5_16_3.AHARHoHPSH
		, Step = '5.16.3'
		from subquery_5_16_3
		where subquery_5_16_3.PersonalID = lp.personalid ;


/*
	5.17 Set Population Identifiers for Active HouseholdIDs
*/

	update lsa.tlsa_HHID hhid
	set HHChronic = (select max(
					case when (n.ActiveAge not between 18 and 65 and n.PersonalID <> hh.HouseholdID)
						or lp.DisabilityStatus <> 1 then 0
					when (lp.CHTime = 365 and lp.CHTimeStatus in (1,2))
						or (lp.CHTime = 400 and lp.CHTimeStatus = 2) then 1
					else 0 end)
			from lsa.tlsa_Person lp
			inner join lsa.tlsa_Enrollment n on n.PersonalID = lp.PersonalID and n.Active = '1'
			inner join lsa.tlsa_HHID hh on hh.HouseholdID = n.HouseholdID
			where n.HouseholdID = hhid.HouseholdID)
		, HHVet = (select max(
					case when lp.VetStatus = 1
						and n.ActiveAge between 18 and 65
						and hh.ActiveHHType <> 3 then 1
					else 0 end)
			from lsa.tlsa_Person lp
			inner join lsa.tlsa_Enrollment n on n.PersonalID = lp.PersonalID and n.Active = '1'
			inner join lsa.tlsa_HHID hh on hh.HouseholdID = n.HouseholdID
			where n.HouseholdID = hhid.HouseholdID)
		, HHDisability = (select max(
				case when lp.DisabilityStatus = 1
					and (n.ActiveAge between 18 and 65 or n.RelationshipToHoH = 1) then 1
				else 0 end)
			from lsa.tlsa_Person lp
			inner join lsa.tlsa_Enrollment n on n.PersonalID = lp.PersonalID and n.Active = '1'
			where n.HouseholdID = hhid.HouseholdID)
		, HHFleeingDV = (select max(
				case when lp.DVStatus = 1
					and (n.ActiveAge between 18 and 65 or n.RelationshipToHoH = 1) then 1
				else 0 end)
			from lsa.tlsa_Person lp
			inner join lsa.tlsa_Enrollment n on n.PersonalID = lp.PersonalID and n.Active = '1'
			where n.HouseholdID = hhid.HouseholdID)
		--Set HHAdultAge for active households based on HH member AgeGroup(s)
		, HHAdultAge = (select
				-- n/a for households with member(s) of unknown age
				case when max(n.ActiveAge) >= 98 then -1
					-- n/a for CO households
					when max(n.ActiveAge) <= 17 then -1
					-- 18-21
					when max(n.ActiveAge) = 21 then 18
					-- 22-24
					when max(n.ActiveAge) = 24 then 24
					-- 55+
					when min(n.ActiveAge) between 64 and 65 then 55
					-- all other combinations
					else 25 end
				from lsa.tlsa_Enrollment n
				where n.HouseholdID = hhid.HouseholdID and n.Active = '1')
		, AC3Plus = (select case sum(case when n.ActiveAge <= 17 and hh.ActiveHHType = 2 then 1
								else 0 end)
							when 0 then 0
							when 1 then 0
							when 2 then 0
							else 1 end
				from lsa.tlsa_Enrollment n
				inner join lsa.tlsa_HHID hh on hh.HouseholdID = n.HouseholdID
				where n.Active = '1' and n.HouseholdID = hhid.HouseholdID)
		, Step = '5.17.1'
	where hhid.Active = '1';


	update lsa.tlsa_HHID hhid
	set HHParent = (select max(
			case when n.RelationshipToHoH = 2 then 1
				else 0 end)
		from lsa.tlsa_Enrollment n
		where n.Active = '1' and n.HouseholdID = hhid.HouseholdID)
		, Step = '5.17.2'
	where hhid.Active = '1';

/*
	5.18 Set lsa.tlsa_Person Population Identifiers from Active Households
*/

	update lsa.tlsa_Person
	set HHChronicEST = -1
		, HHVetEST = -1
		, HHDisabilityEST = -1
		, HHFleeingDVEST = -1
		, HHParentEST = -1
		, Step = '5.18.1'
	from lsa.tlsa_Person lp
	where lp.HHTypeEST = -1;


 with subquery_5_18_2 as  (

 select lp.personalid,
	 case popHHTypes.HHChronicEST
		 when '0' then -1
		 else cast(replace(popHHTypes.HHChronicEST::varchar, '0'::varchar, ''::varchar) as integer) end as HHChronicEST
		, case popHHTypes.HHVetEST
		 when '0' then -1
		 else cast(replace(popHHTypes.HHVetEST::varchar, '0'::varchar, ''::varchar)as integer) end as HHVetEST
		, case popHHTypes.HHDisabilityEST
		 when '0' then -1
		 else cast(replace(popHHTypes.HHDisabilityEST::varchar, '0'::varchar, ''::varchar) as integer) end as HHDisabilityEST
		, case popHHTypes.HHFleeingDVEST
		 when '0' then -1
		 else cast(replace(popHHTypes.HHFleeingDVEST::varchar, '0'::varchar, ''::varchar) as  integer) end as HHFleeingDVEST
		, case popHHTypes.HHParentEST
		 when '0' then -1
		 else cast(replace(popHHTypes.HHParentEST::varchar, '0'::varchar, ''::varchar) as integer) end as HHParentEST
 from lsa.tlsa_Person lp
	 inner join (select distinct lp.PersonalID
		 , (select cast (sum(distinct
				 case when hhid.HHChronic = 0 then 0
					 when hhid.ActiveHHType = 1 then 1000
					 when hhid.ActiveHHType = 2 then 200
					 when hhid.ActiveHHType = 3 then 30
					 when hhid.ActiveHHType = 99 then 9
					 else 0 end) as integer)
			 from lsa.tlsa_HHID hhid
			 inner join lsa.tlsa_Enrollment n on hhid.HouseholdID = n.HouseholdID
					 and n.Active = '1' and n.ProjectType in (1,2,8)
			 where n.PersonalID = lp.PersonalID) HHChronicEST
		 , (select cast(sum(distinct
				 case when hhid.HHVet = 0 then 0
					 when hhid.ActiveHHType = 1 then 1000
					 when hhid.ActiveHHType = 2 then 200
					 when hhid.ActiveHHType = 3 then 30
					 when hhid.ActiveHHType = 99 then 9
					 else 0 end) as integer)
			 from lsa.tlsa_HHID hhid
			 inner join lsa.tlsa_Enrollment n on hhid.HouseholdID = n.HouseholdID
					 and n.Active = '1' and n.ProjectType in (1,2,8)
			 where n.PersonalID = lp.PersonalID) HHVetEST
		 , (select cast(sum(distinct
				 case when hhid.HHDisability = 0 then 0
					 when hhid.ActiveHHType = 1 then 1000
					 when hhid.ActiveHHType = 2 then 200
					 when hhid.ActiveHHType = 3 then 30
					 when hhid.ActiveHHType = 99 then 9
					 else 0 end) as integer)
			 from lsa.tlsa_HHID hhid
			 inner join lsa.tlsa_Enrollment n on hhid.HouseholdID = n.HouseholdID
					 and n.Active = '1' and n.ProjectType in (1,2,8)
			 where n.PersonalID = lp.PersonalID) HHDisabilityEST
		 , (select cast(sum(distinct
				 case when hhid.HHFleeingDV = 0 then 0
					 when hhid.ActiveHHType = 1 then 1000
					 when hhid.ActiveHHType = 2 then 200
					 when hhid.ActiveHHType = 3 then 30
					 when hhid.ActiveHHType = 99 then 9
					 else 0 end) as integer)
			 from lsa.tlsa_HHID hhid
			 inner join lsa.tlsa_Enrollment n on hhid.HouseholdID = n.HouseholdID
					 and n.Active = '1' and n.ProjectType in (1,2,8)
			 where n.PersonalID = lp.PersonalID) HHFleeingDVEST
		 , (select sum(distinct
				 case when hhid.HHParent = 0 then 0
					 when hhid.ActiveHHType = 1 then 1000
					 when hhid.ActiveHHType = 2 then 200
					 when hhid.ActiveHHType = 3 then 30
					 when hhid.ActiveHHType = 99 then 9
					 else 0 end) HHParentEST
			 from lsa.tlsa_HHID hhid
			 inner join lsa.tlsa_Enrollment n on hhid.HouseholdID = n.HouseholdID
					 and n.Active = '1' and n.ProjectType in (1,2,8)
			 where n.PersonalID = lp.PersonalID)
		 from lsa.tlsa_Person lp
 ) popHHTypes on popHHTypes.PersonalID = lp.PersonalID
 where lp.HHTypeEST <> -1 )

 update lsa.tlsa_Person
 set HHChronicEST = subquery_5_18_2.HHChronicEST
	 , HHVetEST = subquery_5_18_2.HHVetEST
	 , HHDisabilityEST = subquery_5_18_2.HHDisabilityEST
	 , HHFleeingDVEST = subquery_5_18_2.HHFleeingDVEST
	 , HHParentEST = subquery_5_18_2.HHParentEST
	 , Step = '5.18.2'
 from subquery_5_18_2
 where subquery_5_18_2.personalid = lsa.tlsa_person.personalid ;


	update lsa.tlsa_Person
	set HHChronicRRH = -1
		, HHVetRRH = -1
		, HHDisabilityRRH = -1
		, HHFleeingDVRRH = -1
		, HHParentRRH = -1
		, Step = '5.18.3'
	from lsa.tlsa_Person lp
	where lp.HHTypeRRH = -1;


with subquery_5_18_4 as (
select lp.personalid ,
case popHHTypes.HHChronicEST
when '0' then -1
else cast(replace(popHHTypes.HHChronicEST::varchar, '0'::varchar, ''::varchar) as integer) end as HHChronicRRH
,case popHHTypes.HHVetEST
when '0' then -1
else cast(replace(popHHTypes.HHVetEST::varchar, '0'::varchar, ''::varchar) as integer) end as HHVetRRH
,case popHHTypes.HHDisabilityEST
when '0' then -1
else cast(replace(popHHTypes.HHDisabilityEST::varchar, '0'::varchar, ''::varchar) as integer) end as HHDisabilityRRH
,case popHHTypes.HHFleeingDVEST
when '0' then -1
else cast(replace(popHHTypes.HHFleeingDVEST::varchar, '0'::varchar, ''::varchar) as integer) end as HHFleeingDVRRH
,case popHHTypes.HHParentEST
when '0' then -1
else cast(replace(popHHTypes.HHParentEST::varchar, '0'::varchar, ''::varchar) as integer) end as HHParentRRH
from lsa.tlsa_Person lp
inner join (select distinct lp.PersonalID
, (select cast(sum(distinct
		case when hhid.HHChronic = 0 then 0
			when hhid.ActiveHHType = 1 then 1000
			when hhid.ActiveHHType = 2 then 200
			when hhid.ActiveHHType = 3 then 30
			when hhid.ActiveHHType = 99 then 9
			else 0 end) as integer)
	from lsa.tlsa_HHID hhid
	inner join lsa.tlsa_Enrollment n on hhid.HouseholdID = n.HouseholdID
			and n.Active = '1' and n.ProjectType = 13
	where n.PersonalID = lp.PersonalID) HHChronicEST
, (select cast(sum(distinct
		case when hhid.HHVet = 0 then 0
			when hhid.ActiveHHType = 1 then 1000
			when hhid.ActiveHHType = 2 then 200
			when hhid.ActiveHHType = 3 then 30
			when hhid.ActiveHHType = 99 then 9
			else 0 end)AS integer)
	from lsa.tlsa_HHID hhid
	inner join lsa.tlsa_Enrollment n on hhid.HouseholdID = n.HouseholdID
			and n.Active = '1' and n.ProjectType = 13
	where n.PersonalID = lp.PersonalID) HHVetEST
, (select cast(sum(distinct
		case when hhid.HHDisability = 0 then 0
			when hhid.ActiveHHType = 1 then 1000
			when hhid.ActiveHHType = 2 then 200
			when hhid.ActiveHHType = 3 then 30
			when hhid.ActiveHHType = 99 then 9
			else 0 end) AS integer)
	from lsa.tlsa_HHID hhid
	inner join lsa.tlsa_Enrollment n on hhid.HouseholdID = n.HouseholdID
			and n.Active = '1' and n.ProjectType = 13
	where n.PersonalID = lp.PersonalID) HHDisabilityEST
,   (select CAST(sum(distinct
		case when hhid.HHFleeingDV = 0 then 0
			when hhid.ActiveHHType = 1 then 1000
			when hhid.ActiveHHType = 2 then 200
			when hhid.ActiveHHType = 3 then 30
			when hhid.ActiveHHType = 99 then 9
			else 0 end) AS integer)
	from lsa.tlsa_HHID hhid
	inner join lsa.tlsa_Enrollment n on hhid.HouseholdID = n.HouseholdID
			and n.Active = '1' and n.ProjectType = 13
	where n.PersonalID = lp.PersonalID) HHFleeingDVEST
, (select CAST (sum(distinct
		case when hhid.HHParent = 0 then 0
			when hhid.ActiveHHType = 1 then 1000
			when hhid.ActiveHHType = 2 then 200
			when hhid.ActiveHHType = 3 then 30
			when hhid.ActiveHHType = 99 then 9
			else 0 end) AS integer) HHParentEST
	from lsa.tlsa_HHID hhid
	inner join lsa.tlsa_Enrollment n on hhid.HouseholdID = n.HouseholdID
			and n.Active = '1' and n.ProjectType = 13
	where n.PersonalID = lp.PersonalID)
from lsa.tlsa_Person lp
) popHHTypes on popHHTypes.PersonalID = lp.PersonalID
where lp.HHTypeRRH <> -1)

update lsa.tlsa_Person
set HHChronicRRH = subquery_5_18_4.HHChronicRRH
, HHVetRRH = subquery_5_18_4.HHVetRRH
, HHDisabilityRRH = subquery_5_18_4.HHDisabilityRRH
, HHFleeingDVRRH =subquery_5_18_4.HHFleeingDVRRH
, HHParentRRH = subquery_5_18_4.HHParentRRH
, Step = '5.18.4'
from subquery_5_18_4
where subquery_5_18_4.personalid = lsa.tlsa_person.personalid ;


	update lsa.tlsa_Person
	set HHChronicPSH = -1
		, HHVetPSH = -1
		, HHDisabilityPSH = -1
		, HHFleeingDVPSH = -1
		, HHParentPSH = -1
		, Step = '5.18.5'
	from lsa.tlsa_Person lp
	where lp.HHTypePSH = -1;

	with subquery_5_18_6 as (
	select lp.personalid ,
		case popHHTypes.HHChronic
				when '0' then -1
				else cast(replace(popHHTypes.HHChronic::varchar, '0'::varchar, ''::varchar) AS integer) end as HHChronicPSH
		   ,case popHHTypes.HHVet
				when '0' then -1
				else cast(replace(popHHTypes.HHVet::varchar, '0'::varchar, ''::varchar) AS integer) end as HHVetPSH
		   ,case popHHTypes.HHDisability
				when '0' then -1
				else cast(replace(popHHTypes.HHDisability::varchar, '0'::varchar, ''::varchar) AS integer) end as HHDisabilityPSH
		   ,case popHHTypes.HHFleeingDV
				when '0' then -1
				else cast(replace(popHHTypes.HHFleeingDV::varchar, '0'::varchar, ''::varchar) AS integer) end as HHFleeingDVPSH
		   ,case popHHTypes.HHParent
				when '0' then -1
				else cast(replace(popHHTypes.HHParent::varchar, '0'::varchar, ''::varchar) AS integer) end as HHParentPSH
		from lsa.tlsa_Person lp
			inner join (select distinct lp.PersonalID
				, (select cast(sum(distinct
						case when hhid.HHChronic = 0 then 0
							when hhid.ActiveHHType = 1 then 1000
							when hhid.ActiveHHType = 2 then 200
							when hhid.ActiveHHType = 3 then 30
							when hhid.ActiveHHType = 99 then 9
							else 0 end) AS varchar)
					from lsa.tlsa_HHID hhid
					inner join lsa.tlsa_Enrollment n on hhid.HouseholdID = n.HouseholdID
							and n.Active = '1' and n.ProjectType = 3
					where n.PersonalID = lp.PersonalID) HHChronic
				, (select cast(sum(distinct
						case when hhid.HHVet = 0 then 0
							when hhid.ActiveHHType = 1 then 1000
							when hhid.ActiveHHType = 2 then 200
							when hhid.ActiveHHType = 3 then 30
							when hhid.ActiveHHType = 99 then 9
							else 0 end)AS varchar)
					from lsa.tlsa_HHID hhid
					inner join lsa.tlsa_Enrollment n on hhid.HouseholdID = n.HouseholdID
							and n.Active = '1' and n.ProjectType = 3
					where n.PersonalID = lp.PersonalID) HHVet
				, (select cast(sum(distinct
						case when hhid.HHDisability = 0 then 0
							when hhid.ActiveHHType = 1 then 1000
							when hhid.ActiveHHType = 2 then 200
							when hhid.ActiveHHType = 3 then 30
							when hhid.ActiveHHType = 99 then 9
							else 0 end)AS varchar)
					from lsa.tlsa_HHID hhid
					inner join lsa.tlsa_Enrollment n on hhid.HouseholdID = n.HouseholdID
							and n.Active = '1' and n.ProjectType = 3
					where n.PersonalID = lp.PersonalID) HHDisability
				, (select cast(sum(distinct
						case when hhid.HHFleeingDV = 0 then 0
							when hhid.ActiveHHType = 1 then 1000
							when hhid.ActiveHHType = 2 then 200
							when hhid.ActiveHHType = 3 then 30
							when hhid.ActiveHHType = 99 then 9
							else 0 end)AS varchar)
					from lsa.tlsa_HHID hhid
					inner join lsa.tlsa_Enrollment n on hhid.HouseholdID = n.HouseholdID
							and n.Active = '1' and n.ProjectType = 3
					where n.PersonalID = lp.PersonalID) HHFleeingDV
				, (select cast(sum(distinct
						case when hhid.HHParent = 0 then 0
							when hhid.ActiveHHType = 1 then 1000
							when hhid.ActiveHHType = 2 then 200
							when hhid.ActiveHHType = 3 then 30
							when hhid.ActiveHHType = 99 then 9
							else 0 end)AS varchar) HHParent
					from lsa.tlsa_HHID hhid
					inner join lsa.tlsa_Enrollment n on hhid.HouseholdID = n.HouseholdID
							and n.Active = '1' and n.ProjectType = 3
					where n.PersonalID = lp.PersonalID)
				from lsa.tlsa_Person lp
		) popHHTypes on popHHTypes.PersonalID = lp.PersonalID
		where lp.HHTypePSH <> -1)

			update lsa.tlsa_Person
		set HHChronicPSH = subquery_5_18_6.HHChronicPSH
			, HHVetPSH = subquery_5_18_6.HHVetPSH
			, HHDisabilityPSH = subquery_5_18_6.HHDisabilityPSH
			, HHFleeingDVPSH = subquery_5_18_6.HHFleeingDVPSH
			, HHParentPSH = subquery_5_18_6.HHParentPSH
			, Step = '5.18.6'
		from subquery_5_18_6
		where subquery_5_18_6.personalid =lsa.tlsa_Person.personalid ;


	update lsa.tlsa_Person lp
	set HHAdultAgeAOEST = coalesce((select case when min(hhid.HHAdultAge) between 18 and 24
					then min(hhid.HHAdultAge)
				else max(hhid.HHAdultAge) end
				from lsa.tlsa_Enrollment n
				inner join lsa.tlsa_HHID hhid on hhid.HouseholdID = n.HouseholdID
					and hhid.HHAdultAge between 18 and 55 and hhid.ActiveHHType = 1
					and hhid.ProjectType in (1,2,8)
				where n.PersonalID = lp.PersonalID and n.Active = '1'), -1)
		, HHAdultAgeACEST = coalesce((select case when min(hhid.HHAdultAge) between 18 and 24
					then min(hhid.HHAdultAge)
				else max(hhid.HHAdultAge) end
				from lsa.tlsa_Enrollment n
				inner join lsa.tlsa_HHID hhid on hhid.HouseholdID = n.HouseholdID
					and hhid.HHAdultAge between 18 and 55 and hhid.ActiveHHType = 2
					and hhid.ProjectType in (1,2,8)
				where n.PersonalID = lp.PersonalID and n.Active = '1'), -1)
		, HHAdultAgeAORRH = coalesce((select case when min(hhid.HHAdultAge) between 18 and 24
					then min(hhid.HHAdultAge)
				else max(hhid.HHAdultAge) end
				from lsa.tlsa_Enrollment n
				inner join lsa.tlsa_HHID hhid on hhid.HouseholdID = n.HouseholdID
					and hhid.HHAdultAge between 18 and 55 and hhid.ActiveHHType = 1
					and hhid.ProjectType = 13
				where n.PersonalID = lp.PersonalID and n.Active = '1'), -1)
		, HHAdultAgeACRRH = coalesce((select case when min(hhid.HHAdultAge) between 18 and 24
					then min(hhid.HHAdultAge)
				else max(hhid.HHAdultAge) end
				from lsa.tlsa_Enrollment n
				inner join lsa.tlsa_HHID hhid on hhid.HouseholdID = n.HouseholdID
					and hhid.HHAdultAge between 18 and 55 and hhid.ActiveHHType = 2
					and hhid.ProjectType = 13
				where n.PersonalID = lp.PersonalID), -1)
		, HHAdultAgeAOPSH = coalesce((select case when min(hhid.HHAdultAge) between 18 and 24
					then min(hhid.HHAdultAge)
				else max(hhid.HHAdultAge) end
				from lsa.tlsa_Enrollment n
				inner join lsa.tlsa_HHID hhid on hhid.HouseholdID = n.HouseholdID
					and hhid.HHAdultAge between 18 and 55 and hhid.ActiveHHType = 1
					and hhid.ProjectType = 3
				where n.PersonalID = lp.PersonalID and n.Active = '1'), -1)
		, HHAdultAgeACPSH = coalesce((select case when min(hhid.HHAdultAge) between 18 and 24
					then min(hhid.HHAdultAge)
				else max(hhid.HHAdultAge) end
				from lsa.tlsa_Enrollment n
				inner join lsa.tlsa_HHID hhid on hhid.HouseholdID = n.HouseholdID
					and hhid.HHAdultAge between 18 and 55 and hhid.ActiveHHType = 2
					and hhid.ProjectType = 3
				where n.PersonalID = lp.PersonalID and n.Active = '1'), -1)
		, Step = '5.18.7';

	update lsa.tlsa_Person lp
	set AC3PlusEST = coalesce((select max(hhid.AC3Plus)
				from lsa.tlsa_HHID hhid
					inner join lsa.tlsa_Enrollment n on hhid.HouseholdID = n.HouseholdID
				where n.PersonalID = lp.PersonalID
					and n.ProjectType in (1,2,8) and n.Active = '1'), 0)
		, AC3PlusRRH = coalesce((select max(hhid.AC3Plus)
				from lsa.tlsa_HHID hhid
					inner join lsa.tlsa_Enrollment n on hhid.HouseholdID = n.HouseholdID
				where n.PersonalID = lp.PersonalID
					and n.ProjectType = 13 and n.Active = '1'), 0)
		, AC3PlusPSH = coalesce((select max(hhid.AC3Plus)
				from lsa.tlsa_HHID hhid
					inner join lsa.tlsa_Enrollment n on hhid.HouseholdID = n.HouseholdID
				where n.PersonalID = lp.PersonalID
					and n.ProjectType = 3 and n.Active = '1'), 0)
		, Step = '5.18.8';

update lsa.tlsa_Person set AdultPSH=-1   where AdultPSH is null;
	update lsa.tlsa_person set ac3plusest=0 where ac3plusest  is null;
update lsa.tlsa_person set pshagemin=-1 where pshagemin  is null;
update lsa.tlsa_person set pshagemax=-1 where pshagemax  is null;
update lsa.tlsa_person set ac3pluspsh=0 where ac3pluspsh  is null;
update lsa.tlsa_person set rrhagemin=-1 where rrhagemin  is null;


/*
	5.19 Select Data for Export to LSAPerson
*/
	-- LSAPerson
	delete from lsa.lsa_Person;
	insert into lsa.lsa_Person (RowTotal
		, Gender, Race, Ethnicity, VetStatus, DisabilityStatus
		, CHTime, CHTimeStatus, DVStatus
		, ESTAgeMin, ESTAgeMax, HHTypeEST, HoHEST, AdultEST, HHChronicEST, HHVetEST, HHDisabilityEST
		, HHFleeingDVEST, HHAdultAgeAOEST, HHAdultAgeACEST, HHParentEST, AC3PlusEST, AHAREST, AHARHoHEST
		, RRHAgeMin, RRHAgeMax, HHTypeRRH, HoHRRH, AdultRRH, HHChronicRRH, HHVetRRH, HHDisabilityRRH
		, HHFleeingDVRRH, HHAdultAgeAORRH, HHAdultAgeACRRH, HHParentRRH, AC3PlusRRH, AHARRRH, AHARHoHRRH
		, PSHAgeMin, PSHAgeMax, HHTypePSH, HoHPSH, AdultPSH, HHChronicPSH, HHVetPSH, HHDisabilityPSH
		, HHFleeingDVPSH, HHAdultAgeAOPSH, HHAdultAgeACPSH, HHParentPSH, AC3PlusPSH, AHARPSH, AHARHoHPSH
		, ReportID
		)
	select count(distinct PersonalID)
		, Gender, Race, Ethnicity, VetStatus, DisabilityStatus
		, CHTime, CHTimeStatus, DVStatus
		, ESTAgeMin, ESTAgeMax, HHTypeEST, HoHEST, AdultEST, HHChronicEST, HHVetEST, HHDisabilityEST
		, HHFleeingDVEST, HHAdultAgeAOEST, HHAdultAgeACEST, HHParentEST, AC3PlusEST, AHAREST, AHARHoHEST
		, RRHAgeMin, RRHAgeMax, HHTypeRRH, HoHRRH, AdultRRH, HHChronicRRH, HHVetRRH, HHDisabilityRRH
		, HHFleeingDVRRH, HHAdultAgeAORRH, HHAdultAgeACRRH, HHParentRRH, AC3PlusRRH, AHARRRH, AHARHoHRRH
		, PSHAgeMin, PSHAgeMax, HHTypePSH, HoHPSH, AdultPSH, HHChronicPSH, HHVetPSH, HHDisabilityPSH
		, HHFleeingDVPSH, HHAdultAgeAOPSH, HHAdultAgeACPSH, HHParentPSH, AC3PlusPSH, AHARPSH, AHARHoHPSH
		, ReportID
	from lsa.tlsa_Person
	group by
		Gender, Race, Ethnicity, VetStatus, DisabilityStatus
		, CHTime, CHTimeStatus, DVStatus
		, ESTAgeMin, ESTAgeMax, HHTypeEST, HoHEST, AdultEST, HHChronicEST, HHVetEST, HHDisabilityEST
		, HHFleeingDVEST, HHAdultAgeAOEST, HHAdultAgeACEST, HHParentEST, AC3PlusEST, AHAREST, AHARHoHEST
		, RRHAgeMin, RRHAgeMax, HHTypeRRH, HoHRRH, AdultRRH, HHChronicRRH, HHVetRRH, HHDisabilityRRH
		, HHFleeingDVRRH, HHAdultAgeAORRH, HHAdultAgeACRRH, HHParentRRH, AC3PlusRRH, AHARRRH, AHARHoHRRH
		, PSHAgeMin, PSHAgeMax, HHTypePSH, HoHPSH, AdultPSH, HHChronicPSH, HHVetPSH, HHDisabilityPSH
		, HHFleeingDVPSH, HHAdultAgeAOPSH, HHAdultAgeACPSH, HHParentPSH, AC3PlusPSH, AHARPSH, AHARHoHPSH
		, ReportID ;

		END
$function$
;
