
	update lsa.tlsa_HHID
	set Active = '1' 
		,Step = '5.1'
	from lsa.tlsa_HHID hhid
	inner join lsa.lsa_Report rpt on rpt.ReportEnd >= hhid.EntryDate
	inner join lsa.lsa_Project p on  p.ProjectID = hhid.ProjectID
	where (hhid.ExitDate is null or hhid.ExitDate >= rpt.ReportStart) 
		and (select  coc.coc_code
			from v2020.enrollment_coc coc 
			where cast (coc.enrollmentid as varchar) = hhid.EnrollmentID
				and coc.information_date <= rpt.ReportEnd
				and coc.deleted IS false and coc.parent_id is null
			order by coc.information_date desc limit 1) = rpt.ReportCoC;

/*
	5.2  Get Active Enrollments
*/

	update lsa.tlsa_Enrollment 
	set Active = '1'
		, Step = '5.2'
	from lsa.lsa_Report rpt
	inner join lsa.tlsa_Enrollment n on n.EntryDate <= rpt.ReportEnd
	inner join lsa.tlsa_HHID hhid on hhid.HouseholdID = n.HouseholdID and hhid.Active = '1'
	where n.ExitDate is null or n.ExitDate >= rpt.ReportStart;

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
			when c.race in ('8','9') then 98
			when c.race IN ('1', '2','3','4','5')  then 6
			when c.race IN ('5')  and c.ethnicity = '1' then 1
			when c.race IN ('5')  then 0
			when c.race in ('3')  then 2
			when c.race IN ('2')  then 3
			when c.race IN ('1')  then 4
			when c.race IN ('3')  then 5
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

	-- CH status is based on HMIS enrollment data in the three year period ending on the client's 
	-- last active date in the report period.
	update lsa.tlsa_Person
	set lp.LastActive =  
		(select max(case 
			when n.ExitDate is null and 
				(hhid.LastBedNight is null or hhid.LastBedNight = rpt.ReportEnd) then rpt.ReportEnd 
			when hhid.LastBednight is not null then dateadd('d', 1, hhid.LastBednight)
			else n.ExitDate end) 
		from lsa.lsa_Report rpt
		inner join lsa.tlsa_Enrollment n on n.EntryDate <= rpt.ReportEnd and n.Active = 1
		inner join lsa.tlsa_HHID hhid on hhid.HouseholdID = n.HouseholdID
		where n.PersonalID = lp.PersonalID)
		, lp.Step = '5.5.1'
	from tlsa_Person lp
	where lp.HoHAdult > 0
 
	--The start of the period is:  LastActive minus (3 years) plus (1 day)
	update lsa.tlsa_Person
	set CHStart = dateadd('d', 1, (dateadd('y', -3, lp.LastActive)))
		, Step = '5.5.2'
	from lsa.tlsa_Person lp
	where lp.HoHAdult > 0;

/*
	5.6 Enrollments Relevant to Counting ES/SH/Street Dates
*/

	update lsa.tlsa_Enrollment
	set CH = '1'
		, Step = '5.6'
	from lsa.tlsa_Person lp
	inner join lsa.tlsa_Enrollment n on n.PersonalID = lp.PersonalID	
		and n.EntryDate <= lp.LastActive
	inner join lsa.tlsa_HHID hhid on hhid.HouseholdID = n.HouseholdID
	where lp.HoHAdult > 0 
		and (n.ExitDate is null or (n.ExitDate > lp.CHStart));
	
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
	where chn.ProjectType in (2,3,13);

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
			and bn.deleted is null
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
			and cal.theDate < hn.entrydate
		left outer join lsa.ch_Exclude chx on chx.excludeDate = cal.theDate
			and chx.PersonalID = chn.PersonalID
		left outer join lsa.ch_Include chi on chi.ESSHStreetDate = cal.theDate 
			and chi.PersonalID = chn.PersonalID
	where chx.excludeDate is null
		and chi.ESSHStreetDate is null
			and (chn.ProjectType in (1,8)
				or hn.livingsituation in ('1','18','16')		
				or (hn.previousstreetessh = '1' and hn.lengthofstay in ('10','11'))
				or (hn.previousstreetessh = '1' and hn.lengthofstay in ('2','3')
					and hn.livingsituation in ('4','5','6','7','15','25') ) 
				);

	--	For RRH/PSH, dates from entry to the earlier of move-in or exit are counted
	--   when LivingSituation at entry is ES/SH/Street.
	insert into lsa.ch_Include (PersonalID, ESSHStreetDate, Step)
	select distinct lp.PersonalID, cal.theDate, '5.8.4'
	from lsa.tlsa_Person lp
	inner join lsa.tlsa_Enrollment chn on chn.PersonalID = lp.PersonalID and chn.CH = '1'
	inner join v2020.enrollment hn on CAST (hn.id AS varchar) = chn.EnrollmentID and hn.deleted is false and hn.parent_id is null
	inner join lsa.ref_Calendar cal on cal.theDate >= hn.entrydate
		and cal.theDate >= lp.CHStart 
		and cal.theDate < coalesce(chn.MoveInDate, chn.ExitDate, lp.LastActive)
	left outer join lsa.ch_Exclude chx on chx.excludeDate = cal.theDate
		and chx.PersonalID = chn.PersonalID
	left outer join lsa.ch_Include chi on chi.ESSHStreetDate = cal.theDate 
		and chi.PersonalID = chn.PersonalID
	where chx.excludeDate is null
		and chi.ESSHStreetDate is null
			and hn.livingsituation in ('1','18','16');		

	--Gaps of less than 7 nights between two ESSHStreet dates are counted
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

/*
	5.9 Get ES/SH/Street Episodes
*/
	delete from lsa.ch_Episodes;

	-- For any given PersonalID:
	-- Any ESSHStreetDate in lsa.ch_Include without a record for the day before is the start of an episode (episodeStart).
	-- Any cdDate in lsa.ch_Include without a record for the day after is the end of an episode (episodeEnd).
	-- Each episodeStart combined with the next earliest episodeEnd represents one episode.
	-- The length of the episode is the difference in days between episodeStart and episodeEnd + 1 day.

	insert into lsa.ch_Episodes (PersonalID, episodeStart, episodeEnd, Step)
	select distinct s.PersonalID, s.ESSHStreetDate, min(e.ESSHStreetDate), '5.9.1'
	from lsa.ch_Include s 
	inner join lsa.ch_Include e on e.PersonalID = s.PersonalID  and e.ESSHStreetDate >= s.ESSHStreetDate
	--any date in lsa.ch_Include without a record for the day before is the start of an episode
	where s.PersonalID not in (select PersonalID from lsa.ch_Include where ESSHStreetDate = dateadd('d', -1, s.ESSHStreetDate))
	--any date in lsa.ch_Include without a record for the day after is the end of an episode
		and e.PersonalID not in (select PersonalID from lsa.ch_Include where ESSHStreetDate = dateadd('d', 1, e.ESSHStreetDate))
	group by s.PersonalID, s.ESSHStreetDate;

	update lsa.ch_Episodes
	set episodeDays = DATE_PART('day', chep.episodeEnd::timestamp - chep.episodeStart::timestamp) + 1
		, Step = '5.9.2'
	from lsa.ch_Episodes chep;



/*
	5.10 Set CHTime and CHTimeStatus 
*/

	--Any client with a 365+ day episode that overlaps with their
	--last year of activity meets the time criteria for CH
	update lsa.tlsa_Person 
	set CHTime = case when lp.HoHAdult = 0 then -1 else 0 end
		, CHTimeStatus = -1
		, Step = '5.10.1'
	from lsa.tlsa_Person lp;	
	
	update lsa.tlsa_Person 
	set CHTime = 365, CHTimeStatus = 1, Step = '5.10.2'
	from lsa.tlsa_Person lp
		inner join lsa.ch_Episodes chep on chep.PersonalID = lp.PersonalID
			and chep.episodeDays >= 365
			and chep.episodeEnd > dateadd('y', -1, lp.LastActive)
	where lp.CHTime = 0;

	--Clients with a total of 365+ days in the three year period and at least four episodes 
	--  meet time criteria for CH
	update lsa.tlsa_Person 
	set CHTime = case 
			when ep.episodeDays >= 365 then 365
			when ep.episodeDays between 270 and 364 then 270
			else 0 end
		, CHTimeStatus = case
			when ep.episodeDays < 365 then -1 
			when ep.episodes >= 4 then 2
			else 3 end
		, Step = '5.10.3'
	from lsa.tlsa_Person lp
	inner join (select chep.PersonalID
		, sum(chep.episodeDays) as episodeDays, count(distinct chep.episodeStart) as episodes
		from lsa.ch_Episodes chep
		group by chep.PersonalID) ep on ep.PersonalID = lp.PersonalID
	where lp.CHTime = 0;

	--Clients with 3.917 data for an entry in their last year of activity 
	--  showing 12+ months and 4+ episodes meet time criteria for CH 
	update lsa.tlsa_Person 
	set CHTime = 400
		, CHTimeStatus = 2
		, Step = '5.10.4'
	from lsa.tlsa_Person lp
		inner join lsa.tlsa_Enrollment chn on chn.PersonalID = lp.PersonalID and chn.CH = '1'
		inner join v2020.enrollment hn on CAST(hn.id AS varchar) = chn.EnrollmentID and hn.deleted is false and hn.parent_id is null
			and hn.monthshomelesspastthreeyears in ('112','113') 
			and hn.timeshomelesspastthreeyears = '4'
			and hn.entrydate > dateadd('y', -1, lp.LastActive)
	where 
		lp.CHTime not in (-1,365) or lp.CHTimeStatus = 3;

	--Anyone who doesn't meet CH time criteria and is missing data in 3.917 
	--for an active enrollment should be identified as missing data.
		
	update lsa.tlsa_Person 
	set CHTimeStatus = 99
		,Step = '5.10.5'
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
			));

/*
	5.11 EST/RRH/PSH AgeMin and AgeMax - LSAPerson
*/


with t as (
   select n.ActiveAge as ActiveAge , n.PersonalID  as personalID
		 from lsa.tlsa_Enrollment n
		 where n.ProjectType in ('1','2','8') and n.Active = '1'

)






	update lsa.tlsa_Person 
	set ESTAgeMin = coalesce(
		(select min(n.ActiveAge) 
		 from lsa.tlsa_Enrollment n, lsa.tlsa_Person lp1
		 where n.PersonalID = lp1.PersonalID and n.ProjectType in ('1','2','8') and n.Active = '1')
		 , -1)
		, Step = '5.11.1'
	from lsa.tlsa_Person lp;
	
	
	
		update lsa.tlsa_Enrollment
	set ActiveAge = case when n.ExitDate < rpt.ReportStart
				or n.EntryDate >= rpt.ReportStart 
				or n.EntryAge in (98,99) then n.EntryAge
			--  If enrollment is inactive, age is unknown, 
			--		or entry is in report period, use EntryAge; 
			--  Otherwise, recalculate age as of ReportStart 
			when DATEADD('y', 65, cast (convert_from(dob_decrypt(c.dob), 'utf-8') as date)) <= rpt.ReportStart then 65
			when DATEADD('y', 55, cast (convert_from(dob_decrypt(c.dob), 'utf-8') as date)) <= rpt.ReportStart then 64
			when DATEADD('y', 45, cast (convert_from(dob_decrypt(c.dob), 'utf-8') as date)) <= rpt.ReportStart then 54
			when DATEADD('y', 35, cast (convert_from(dob_decrypt(c.dob), 'utf-8') as date)) <= rpt.ReportStart then 44
			when DATEADD('y', 25, cast (convert_from(dob_decrypt(c.dob), 'utf-8') as date)) <= rpt.ReportStart then 34
			when DATEADD('y', 22, cast (convert_from(dob_decrypt(c.dob), 'utf-8') as date)) <= rpt.ReportStart then 24
			when DATEADD('y', 18, cast (convert_from(dob_decrypt(c.dob), 'utf-8') as date)) <= rpt.ReportStart then 21
			when DATEADD('y', 6, cast (convert_from(dob_decrypt(c.dob), 'utf-8') as date)) <= rpt.ReportStart then 17
			when DATEADD('y', 3, cast (convert_from(dob_decrypt(c.dob), 'utf-8') as date)) <= rpt.ReportStart then 5
			when DATEADD('y', 1, cast (convert_from(dob_decrypt(c.dob), 'utf-8') as date)) <= rpt.ReportStart then 2
			else 0 end 		
		, Step = '3.5.1'
	from lsa.lsa_Report rpt
	inner join lsa.tlsa_Enrollment n on n.EntryDate <= rpt.ReportEnd 
	inner join v2020.client c on CAST (c.id AS varchar) = n.PersonalID 
	where n.PersonalID='c671dd29-b2f7-4de2-9bf9-eedb60f2b1ef';


update lsa.tlsa_Person 
	set ESTAgeMin = n.ActiveAge	
		, Step = '5.11.1'
	from lsa.lsa_Report rpt
	inner join lsa.tlsa_Enrollment n on  n.ProjectType in ('1','2','8') and n.Active = '1'
	inner join lsa.tlsa_Person lp on  n.PersonalID = lp.PersonalID and rpt.ReportID = lp.ReportID;


update lsa.tlsa_Person 
	set ESTAgeMax = n.ActiveAge	
		, Step = '5.11.2'
	from lsa.lsa_Report rpt
	inner join lsa.tlsa_Enrollment n on  n.ProjectType in ('1','2','8') and n.Active = '1'
	inner join lsa.tlsa_Person lp on  n.PersonalID = lp.PersonalID and rpt.ReportID = lp.ReportID;


update lsa.tlsa_Person 
	set RRHAgeMin = n.ActiveAge	
		, Step = '5.11.3'
	from lsa.lsa_Report rpt
	inner join lsa.tlsa_Enrollment n on  n.ProjectType in ('13') and n.Active = '1'
	inner join lsa.tlsa_Person lp on  n.PersonalID = lp.PersonalID and rpt.ReportID = lp.ReportID;



update lsa.tlsa_Person 
	set RRHAgeMax = n.ActiveAge	
		, Step = '5.11.4'
	from lsa.lsa_Report rpt
	inner join lsa.tlsa_Enrollment n on  n.ProjectType in ('13') and n.Active = '1'
	inner join lsa.tlsa_Person lp on  n.PersonalID = lp.PersonalID and rpt.ReportID = lp.ReportID;




update lsa.tlsa_Person 
	set PSHAgeMin = n.ActiveAge	
		, Step = '5.11.5'
	from lsa.lsa_Report rpt
	inner join lsa.tlsa_Enrollment n on  n.ProjectType in ('3') and n.Active = '1'
	inner join lsa.tlsa_Person lp on  n.PersonalID = lp.PersonalID and rpt.ReportID = lp.ReportID;


update lsa.tlsa_Person 
	set PSHAgeMax = n.ActiveAge	
		, Step = '5.11.6'
	from lsa.lsa_Report rpt
	inner join lsa.tlsa_Enrollment n on  n.ProjectType in ('3') and n.Active = '1'
	inner join lsa.tlsa_Person lp on  n.PersonalID = lp.PersonalID and rpt.ReportID = lp.ReportID;



	
	/*
	5.12 Set lsa.tlsa_Person Project Group Identifiers by Household Type
*/
	update lsa.tlsa_Person 
	set HHTypeEST = null, HHTypeRRH = null, HHTypePSH = null;

	--set EST HHType 
	update lsa.tlsa_Person
	set HHTypeEST = 
		case when hh.HHTypeCombined is null then -1
		else hh.HHTypeCombined end	
		, Step = '5.12.1'
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
			) hh on hh.PersonalID = lp.PersonalID;

	--set RRH HHType 
	update lsa.tlsa_Person 
	set HHTypeRRH = 
		case when hh.HHTypeCombined is null then -1
		else hh.HHTypeCombined end	
		, Step = '5.12.2'
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
			) hh on hh.PersonalID = lp.PersonalID;

	--set PSH HHType 
	update lsa.tlsa_Person
	set HHTypePSH = 
		case when hh.HHTypeCombined is null then -1
		else hh.HHTypeCombined end	
		, Step = '5.12.3'
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
						where n.ProjectType = '3' and n.Active = '1') HHTypes  
			group by HHTypes.PersonalID
			) hh on hh.PersonalID = lp.PersonalID;

/*
	5.13 Set lsa.tlsa_Person Head of Household Identifiers by HHType for Each Project Group 
*/

	--set EST HoH identifiers 
	update lsa.tlsa_Person lsaPerson
	set HoHEST = 
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
			, -1) end	
		, Step = '5.13.1'
	from lsa.tlsa_Person lp where lsaPerson.PersonalID = lp.PersonalID;

	--set RRH HoH identifiers 
	update lsa.tlsa_Person  lsap
	set HoHRRH = 
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
			, -1) end	
		, Step = '5.13.2'
	from lsa.tlsa_Person lp where lsap.PersonalID = lp.PersonalID;

	--set PSH HoH identifiers 
	update lsa.tlsa_Person lsap
	set HoHPSH = 
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
			, -1) end	
		, Step = '5.13.3'
	from lsa.tlsa_Person lp where lsap.PersonalID = lp.PersonalID;

/*
	5.14 Set lsa.tlsa_Person AHAR Identifiers by HHType for each Project Group
*/

	--set EST AHAR HHType 
	update lsa.tlsa_Person lsap
	set AHAREST = 
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
				, -1) end	
		, Step = '5.14.1'
	from lsa.tlsa_Person lp where lsap.PersonalID = lp.PersonalID;
	
	--set RRH HHType 
	update lsa.tlsa_Person lsap
	set AHARRRH = 
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
				, -1) end		
		, Step = '5.14.2'
	from lsa.tlsa_Person lp where lsap.PersonalID = lp.PersonalID;

	--set PSH HHType 
	update lsa.tlsa_Person lsap
	set AHARPSH = 
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
				, -1) end	
		, Step = '5.14.3'
	from lsa.tlsa_Person lp where lsap.PersonalID = lp.PersonalID;

/*
	5.15 Set lsa.tlsa_Person AHAR Adult Identifiers by HHType for each Project Group
*/

	--set AdultEST
	update lsa.tlsa_Person lsap
	set AdultEST = 
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
				, -1) end	
		, Step = '5.15.1'
	from lsa.tlsa_Person lp where lsap.PersonalID = lp.PersonalID;

	--set AdultRRH 
	update lsa.tlsa_Person lsap
	set AdultRRH = 
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
				, -1) end	
		, Step = '5.15.2'
	from lsa.tlsa_Person lp where lsap.PersonalID = lp.PersonalID;

	--set AdultPSH Sandeep need to fix this
	update lsa.tlsa_Person lp
	set AdultPSH = 
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
				, -1) end	
		, Step = '5.15.3';
	
	
	

/*
	5.16 Set lsa.tlsa_Person AHAR Head of Household Identifiers by HHType for each Project Group
*/

	update lsa.tlsa_Person lp
	set AHARHoHEST = 
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
				, -1) end	
		, Step = '5.16.1';
	
	--set RRH HHType 
	update lsa.tlsa_Person lp
	set AHARHoHRRH = 
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
				, -1) end	
		, Step = '5.16.2';

	--set PSH HHType 
	update lsa.tlsa_Person lp
	set AHARHoHPSH = 
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
				, -1) end	
		, Step = '5.16.3';
		



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
	
	update lsa.tlsa_Person
	set HHChronicEST = case popHHTypes.HHChronicEST
			when '0' then -1
			else cast(replace(popHHTypes.HHChronicEST::varchar, '0'::varchar, ''::varchar) as integer) end
	   , HHVetEST = case popHHTypes.HHVetEST
			when '0' then -1
			else cast(replace(popHHTypes.HHVetEST::varchar, '0'::varchar, ''::varchar)as integer) end
	   , HHDisabilityEST = case popHHTypes.HHDisabilityEST
			when '0' then -1
			else cast(replace(popHHTypes.HHDisabilityEST::varchar, '0'::varchar, ''::varchar) as integer) end
	   , HHFleeingDVEST = case popHHTypes.HHFleeingDVEST
			when '0' then -1
			else cast(replace(popHHTypes.HHFleeingDVEST::varchar, '0'::varchar, ''::varchar) as  integer) end
	   , HHParentEST = case popHHTypes.HHParentEST
			when '0' then -1
			else cast(replace(popHHTypes.HHParentEST::varchar, '0'::varchar, ''::varchar) as integer) end
		, Step = '5.18.2'
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
	where lp.HHTypeEST <> -1;

	update lsa.tlsa_Person
	set HHChronicRRH = -1
		, HHVetRRH = -1
		, HHDisabilityRRH = -1
		, HHFleeingDVRRH = -1
		, HHParentRRH = -1
		, Step = '5.18.3'
	from lsa.tlsa_Person lp
	where lp.HHTypeRRH = -1;

	update lsa.tlsa_Person 
	set HHChronicRRH = case popHHTypes.HHChronicEST
			when '0' then -1
			else cast(replace(popHHTypes.HHChronicEST::varchar, '0'::varchar, ''::varchar) as integer) end
	   , HHVetRRH = case popHHTypes.HHVetEST
			when '0' then -1
			else cast(replace(popHHTypes.HHVetEST::varchar, '0'::varchar, ''::varchar) as integer) end
	   , HHDisabilityRRH = case popHHTypes.HHDisabilityEST
			when '0' then -1
			else cast(replace(popHHTypes.HHDisabilityEST::varchar, '0'::varchar, ''::varchar) as integer) end
	   , HHFleeingDVRRH = case popHHTypes.HHFleeingDVEST
			when '0' then -1
			else cast(replace(popHHTypes.HHFleeingDVEST::varchar, '0'::varchar, ''::varchar) as integer) end
	   , HHParentRRH = case popHHTypes.HHParentEST
			when '0' then -1
			else cast(replace(popHHTypes.HHParentEST::varchar, '0'::varchar, ''::varchar) as integer) end
		, Step = '5.18.4'
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
	where lp.HHTypeRRH <> -1;

	update lsa.tlsa_Person 
	set HHChronicPSH = -1
		, HHVetPSH = -1
		, HHDisabilityPSH = -1
		, HHFleeingDVPSH = -1
		, HHParentPSH = -1
		, Step = '5.18.5'
	from lsa.tlsa_Person lp
	where lp.HHTypePSH = -1;


      
	update lsa.tlsa_Person
	set HHChronicPSH = case popHHTypes.HHChronic
			when '0' then -1
			else cast(replace(popHHTypes.HHChronic::varchar, '0'::varchar, ''::varchar) AS integer) end
	   , HHVetPSH = case popHHTypes.HHVet
			when '0' then -1
			else cast(replace(popHHTypes.HHVet::varchar, '0'::varchar, ''::varchar) AS integer) end
	   , HHDisabilityPSH = case popHHTypes.HHDisability
			when '0' then -1
			else cast(replace(popHHTypes.HHDisability::varchar, '0'::varchar, ''::varchar) AS integer) end
	   , HHFleeingDVPSH = case popHHTypes.HHFleeingDV
			when '0' then -1
			else cast(replace(popHHTypes.HHFleeingDV::varchar, '0'::varchar, ''::varchar) AS integer) end
	   , HHParentPSH = case popHHTypes.HHParent
			when '0' then -1
			else cast(replace(popHHTypes.HHParent::varchar, '0'::varchar, ''::varchar) AS integer) end
		, Step = '5.18.6'
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
	where lp.HHTypePSH <> -1;


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
	
