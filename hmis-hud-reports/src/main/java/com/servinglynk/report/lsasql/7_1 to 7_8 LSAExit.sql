update lsa.tlsa_HHID
	set ExitCohort = cd.Cohort
		, Step = '7.1'
	from lsa.tlsa_HHID hhid
	inner join lsa.lsa_Report rpt on rpt.ReportEnd >= hhid.EntryDate
	inner join lsa.tlsa_CohortDates cd on hhid.ExitDate between cd.CohortStart and cd.CohortEnd
		and cd.Cohort between -2 and 0
	left outer join lsa.lsa_Project p on p.ProjectID = hhid.ProjectID 
	left outer join lsa.tlsa_HHID disqualify on disqualify.HouseholdID = hhid.HouseholdID
		and ((cd.Cohort = -2 and disqualify.Exit2HHType = hhid.Exit2HHType) 
				or (cd.Cohort = -1 and disqualify.Exit1HHType = hhid.Exit1HHType)
				or (cd.Cohort = 0 and disqualify.ActiveHHType = hhid.ActiveHHType)
			)
		and	disqualify.EnrollmentID <> hhid.EnrollmentID 
		and disqualify.EntryDate < dateadd('d', 14, hhid.ExitDate)
		and (disqualify.ExitDate is null or disqualify.ExitDate > hhid.ExitDate)
		and (select coc_code 
			 from v2020.enrollment_coc 
			 where CAST (enrollmentid AS varchar) = disqualify.EnrollmentID and deleted is false and parent_id is null
				and information_date <= dateadd('d', 14, hhid.ExitDate)
			 order by information_date DESC limit 1) = rpt.ReportCoC
	where disqualify.EnrollmentID is null
		and (rpt.LSAScope = 1 or p.ProjectID is not null)
		and (select coc.coc_code
			from v2020.enrollment_coc coc
			where cast (coc.enrollmentid as varchar) = hhid.EnrollmentID
				and coc.information_date <= rpt.ReportEnd
				and coc.deleted is false and coc.parent_id is null
			order by coc.information_date DESC limit 1) = rpt.ReportCoC;

/*
	7.2 Select Reportable Exits
*/
	delete from lsa.tlsa_Exit;

	insert into lsa.tlsa_Exit (Cohort, HouseholdID, HHType, QualifyingExitHHID
		, ExitFrom, ExitTo, ReportID, Step)
	select distinct hhid.ExitCohort, hhid.HouseholdID
		, case hhid.ExitCohort when -2 then hhid.Exit2HHType
			when -1 then hhid.Exit1HHType
			else hhid.ActiveHHType end
		, hhid.HouseholdID
		, case 
              when hhid.ProjectType = 1 then 2
              when hhid.ProjectType = 2 then 3 
              when hhid.ProjectType = 8 then 4
              when hhid.ProjectType = 13 and hhid.MoveInDate is not null then 5
              when hhid.ProjectType = 3 and hhid.MoveInDate is not null then 6
              when hhid.ProjectType = 13 then 7
              else 8 end
		, hhid.ExitDest
		, rpt.ReportID
		, '7.2'
	from lsa.tlsa_HHID hhid
	inner join lsa.lsa_Report rpt on rpt.ReportEnd >= hhid.EntryDate
	where hhid.ExitCohort is not null and hhid.EnrollmentID in 
			(
			select qx.EnrollmentID 
			from lsa.tlsa_HHID qx 
			where qx.ExitCohort = hhid.ExitCohort and qx.HouseholdID = hhid.HouseholdID
				and case hhid.ExitCohort when -2 then hhid.Exit2HHType
					when -1 then hhid.Exit1HHType
					else hhid.ActiveHHType end
					= case qx.ExitCohort when -2 then qx.Exit2HHType
					when -1 then qx.Exit1HHType
					else qx.ActiveHHType end
			order by case when qx.ExitDest between 1 and 6 then 2
                      when qx.ExitDest between 7 and 14 then 3
                      else 4 end asc, qx.ExitDate ASC limit 1
			);
	
/*
	7.3 Return Time for Exit Cohort Households
*/
	
	update lsa.tlsa_Exit
	set ReturnTime = 
		case when later.HouseholdID is null then -1
			else date_part('day', later.EntryDate::timestamp -qx.ExitDate::timestamp ) end
		, Step = '7.3'
	from lsa.tlsa_Exit ex 
	inner join lsa.tlsa_HHID qx on qx.HouseholdID = ex.QualifyingExitHHID
	inner join lsa.lsa_Report rpt on rpt.ReportEnd >= qx.EntryDate
	left outer join (select rn.HouseholdID, min(rn.EntryDate) as  EntryDate
				, rn.ActiveHHType, rn.Exit1HHType, rn.Exit2HHType
			from lsa.tlsa_HHID rn 
			inner join lsa.lsa_Report rpt on rpt.ReportEnd >= rn.EntryDate
			inner join v2020.enrollment_coc coc on CAST (coc.enrollmentid AS varchar)= rn.EnrollmentID 
				and coc.information_date = rn.EntryDate and coc.deleted is false and coc.parent_id is null
				and coc.coc_code= rpt.ReportCoC
                       group by rn.HouseholdID rn.ActiveHHType, rn.Exit1HHType, rn.Exit2HHType
			) later on later.HouseholdID = qx.HouseholdID and 
				case qx.ExitCohort 
					when -2 then later.Exit2HHType
					when -1 then later.Exit1HHType
					else later.ActiveHHType end
					= ex.HHType
				and later.EntryDate between dateadd('d', 15, qx.ExitDate) and dateadd('d', 730, qx.ExitDate) ;


/*
	7.4 Population Identifiers for LSAExit
*/

	update lsa.tlsa_Exit
	set HHVet = (select max(case when c.veteran_status = '1' then 1 else 0 end)
			from v2020.client c
			where cast (c.id as varchar) = hh.PersonalID and c.deleted is false and c.parent_id is null)
		, HHDisability = (select max(case when disability.DisabilityStatus = 1 then 1 else 0 end)
			from lsa.tlsa_Enrollment disability
			where disability.HouseholdID = hh.HouseholdID)
		, HHFleeingDV = (select max(case when dv.DVStatus = 1 then 1 else 0 end)
			from lsa.tlsa_Enrollment dv
			where dv.HouseholdID = hh.HouseholdID)
		, HoHRace =  case 
			when hoh.race in ('8','9') then 98
			when hoh.race in ('1','2','3','4','5')  then 6
			when hoh.race in ('5') and hoh.ethnicity = '1' then 1
			when hoh.race in('5')  then 0
			when hoh.race in ('3') then 2
			when hoh.race in ('2') then 3
			when hoh.race in ('1') then 4
			when hoh.race in ('4')  then 5
			else 99 end 
		, HoHEthnicity = case 
			when hoh.ethnicity in ('8','9') then 98
			when hoh.ethnicity in ('0','1') then cast (cast (hoh.ethnicity as varchar) as integer) 
			else 99 end 
		, HHParent = (select max(case when parent.RelationshipToHoH = 2 then 1 else 0 end)
			from lsa.tlsa_Enrollment parent
			where parent.HouseholdID = hh.HouseholdID)
		, Step = '7.4.1'
	from lsa.tlsa_Exit ex 
	inner join lsa.tlsa_HHID hhid on hhid.HouseholdID = ex.QualifyingExitHHID 
	inner join v2020.client hoh on cast (hoh.id as varchar)= ex.HouseholdID and hoh.deleted is false and hoh.parent_id is null
	inner join (
		select n.HouseholdID, n.PersonalID, n.EnrollmentID, hhid.ExitCohort
			, case hhid.ExitCohort
				when -2 then n.Exit2Age
				when -1 then n.Exit1Age
				else n.ActiveAge end as Age
			, n.RelationshipToHoH
		from lsa.tlsa_Enrollment n
		inner join lsa.tlsa_HHID hhid on hhid.HouseholdID = n.HouseholdID) hh on hh.HouseholdID = ex.QualifyingExitHHID and hh.ExitCohort = ex.Cohort;


update lsa.tlsa_Exit
set HHAdultAge = case when ages.MaxAge not between 18 and 65 then -1
	when ages.MaxAge = 21 then 18
	when ages.MaxAge = 24 then 24
	when ages.MinAge between 55 and 65 then 55
	else 25 end
	,Step = '7.4.2'
from lsa.tlsa_Exit ex
inner join (select hhid.HouseholdID, case hhid.ExitCohort 
			when 0 then hhid.ActiveHHType
			when -1 then hhid.Exit1HHType
			when -2 then hhid.Exit2HHType end as HHType
		, hhid.ExitCohort as Cohort
		, max(case hhid.ExitCohort 
			when 0 then n.ActiveAge
			when -1 then n.Exit1Age
			when -2 then n.Exit2Age end) as MaxAge
		, min(case hhid.ExitCohort 
			when 0 then n.ActiveAge
			when -1 then n.Exit1Age
			when -2 then n.Exit2Age end) as MinAge
	from lsa.tlsa_HHID hhid
	inner join lsa.tlsa_Enrollment n on n.HouseholdID = hhid.HouseholdID 
	group by hhid.HouseholdID, case hhid.ExitCohort 
			when 0 then hhid.ActiveHHType
			when -1 then hhid.Exit1HHType
			when -2 then hhid.Exit2HHType end 
		, hhid.ExitCohort
	) ages on ages.HouseholdID = ex.HouseholdID and ages.Cohort = ex.Cohort and ages.HHType = ex.HHType;

update lsa.tlsa_Exit 
set AC3Plus = 
		(select case count(distinct n.PersonalID)
			when 0 then 0
			when 1 then 0
			when 2 then 0 			
			else 1 end		
			from lsa.tlsa_HHID hhid
		inner join lsa.tlsa_Enrollment n on n.HouseholdID = hhid.HouseholdID 
		where case hhid.ExitCohort 
			when 0 then n.ActiveAge 
			when -1 then n.Exit1Age 
			when -2 then n.Exit2Age end <= 17
		 and case hhid.ExitCohort 
			when 0 then hhid.ActiveHHType 
			when -1 then hhid.Exit1HHType
			when -2 then hhid.Exit2HHType end = 2
		 and hhid.HouseholdID = ex.QualifyingExitHHID)
		, Step = '7.4.3'
from lsa.tlsa_Exit ex;

/*
	7.5 System Engagement Status for Exit Cohort Households
*/

	update lsa.tlsa_Exit
	set Stat = 
		case when prior.HouseholdID is null then 1
			when prior.ExitDate >= dateadd('d', -14, qx.EntryDate) then 5
			when prior.ExitDest between 1 and 6 then 2
			when prior.ExitDest between 7 and 14 then 3
			else 4 end 
		, Step = '7.5'
	from lsa.tlsa_Exit ex 
	inner join lsa.tlsa_HHID qx on qx.HouseholdID = ex.QualifyingExitHHID
	left outer join lsa.tlsa_HHID prior on prior.HouseholdID = ex.HouseholdID 
		and case qx.ExitCohort when -2 then prior.Exit2HHType
					when -1 then prior.Exit1HHType
					else prior.ActiveHHType end
					= case qx.ExitCohort when -2 then qx.Exit2HHType
					when -1 then qx.Exit1HHType
					else qx.ActiveHHType end
                and prior.EntryDate < qx.EntryDate
		and prior.ExitDate between dateadd(dd, -730, qx.EntryDate) and qx.ExitDate;


/*
	7.6  Last Inactive Date for Exit Cohorts
*/

--LastInactive = (EntryDate - 1 day) for any household where Stat <> 5
	--  and for any household where Stat = 5 but there is no enrollment for the HouseholdID/HHType
	--  active in the six days prior to the qualifying exit EntryDate. 
	update lsa.tlsa_Exit
	set LastInactive = dateadd('d', -1, hhid.EntryDate)
		, Step = '7.6.1'
	from lsa.tlsa_Exit ex
	inner join lsa.tlsa_HHID hhid on hhid.HouseholdID = ex.QualifyingExitHHID
	where ex.Stat <> 5 
		or (SELECT prior.EnrollmentID 
			from lsa.tlsa_HHID prior
			where prior.HouseholdID = ex.HouseholdID and case ex.Cohort 
				when -2 then prior.Exit2HHType
				when -1 then prior.Exit1HHType
				else prior.ActiveHHType end = ex.HHType
			and dateadd('d', 6, hhid.ExitDate) >= hhid.EntryDate limit 1) is null;

	delete from lsa.sys_TimePadded;

	insert into lsa.sys_TimePadded (HouseholdID, HHType, Cohort, StartDate, EndDate, Step)
	select distinct ex.HouseholdID, ex.HHType, 1
		, hhid.EntryDate	
		, case when hhid.ExitDate is null then cd.CohortEnd 
			else dateadd('d', 6, hhid.ExitDate) end
		, '7.6.2.a'
	from lsa.tlsa_Exit ex
	inner join lsa.tlsa_HHID hhid on hhid.HouseholdID = ex.QualifyingExitHHID
	inner join lsa.tlsa_CohortDates cd on cd.Cohort = ex.Cohort
	inner join lsa.tlsa_HHID possible on possible.HouseholdID = ex.HouseholdID and case ex.Cohort 
				when -2 then possible.Exit2HHType
				when -1 then possible.Exit1HHType
				else possible.ActiveHHType end = ex.HHType 
			and possible.ExitDate <= hhid.ExitDate
	where ex.LastInactive is null 
		and possible.TrackingMethod <> 3
	union
	select distinct ex.HouseholdID, ex.HHType, 1
		, bn.dateprovided	
		, dateadd('d', 6, bn.dateprovided::date) 
		, '7.6.2.b'
	from lsa.tlsa_Exit ex
	inner join lsa.tlsa_HHID hhid on hhid.HouseholdID = ex.QualifyingExitHHID
	inner join lsa.tlsa_CohortDates cd on cd.Cohort = ex.Cohort
	inner join lsa.tlsa_HHID possible on possible.HouseholdID = ex.HouseholdID and case ex.Cohort 
				when -2 then possible.Exit2HHType
				when -1 then possible.Exit1HHType
				else possible.ActiveHHType end = ex.HHType 
			and possible.ExitDate <= hhid.ExitDate
	inner join v2020.service_fa_referral bn on CAST (bn.enrollmentid as varchar) = possible.EnrollmentID 
		and bn.dateprovided <= cd.CohortEnd
		-- 5/14/2020 correct DateDeleted = 0 to DateDeleted is null
		and bn.record_type = '200' and bn.deleted is false and bn.parent_id is null
	where ex.LastInactive is null 
		and possible.TrackingMethod = 3;
		
	update lsa.tlsa_Exit
	set LastInactive = coalesce(lastDay.inactive, '2012-09-30')
		, Step = '7.6.3'
	from lsa.tlsa_Exit ex
	left outer join 
		(select ex.HouseholdID, ex.HHType, max(cal.theDate) as inactive
		  from lsa.tlsa_Exit ex
		  inner join lsa.tlsa_HHID hhid on hhid.HouseholdID = ex.QualifyingExitHHID
		  inner join lsa.tlsa_CohortDates cd on cd.Cohort = ex.Cohort
		  inner join lsa.ref_Calendar cal on cal.theDate <= cd.CohortEnd
			and cal.theDate >= '2012-10-01'
		  left outer join
			 lsa.sys_TimePadded stp on stp.HouseholdID = ex.HouseholdID and stp.HHType = ex.HHType
			  and stp.Cohort = ex.Cohort
			  and cal.theDate between stp.StartDate and stp.EndDate
		  where stp.HouseholdID is null
			and cal.theDate < hhid.EntryDate
		group by ex.HouseholdID, ex.HHType, ex.Cohort
	  ) lastDay on lastDay.HouseholdID = ex.HouseholdID and lastDay.HHType = ex.HHType
	where ex.LastInactive is null;

/*
	7.7 Set System Path for Exit Cohort Households
*/

--SystemPath is n/a for any household housed in PSH as of CohortStart
-- or any household housed for at least a year in RRH/PSH prior to exit
update lsa.tlsa_Exit
set SystemPath = -1
	, Step = '7.7.1'
from lsa.tlsa_Exit ex
inner join lsa.tlsa_HHID qx on qx.HouseholdID = ex.QualifyingExitHHID
inner join lsa.tlsa_CohortDates cd on cd.Cohort = ex.Cohort
where (ex.ExitTo = 6 and qx.MoveInDate < cd.CohortStart) 
	or (ex.ExitTo in (5,6) and dateadd('d', 365, qx.MoveInDate) <= qx.ExitDate);

-- SystemPath can be set directly based on ExitFrom for
-- -Any first time homeless household (Stat = 1)
-- -Any household returning/re-engaging after 15-730 days (Stat in (2,3,4))
-- and any household whose LastInactive date is the day before the EntryDate for the qualifying exit. 
update lsa.tlsa_Exit
set SystemPath = case ex.ExitFrom
	when 2 then 1
	when 3 then 2
	when 4 then 1
	when 5 then 4
	when 6 then 8
	else 8 end
	, Step = '7.7.2'
from lsa.tlsa_Exit ex 
inner join lsa.tlsa_HHID qx on qx.HouseholdID = ex.QualifyingExitHHID
where ex.SystemPath is null
	and (ex.Stat in (1,2,3,4) or ex.LastInactive = dateadd('d', -1, qx.EntryDate));

update lsa.tlsa_Exit
set SystemPath = case ptype.summary
	when 1 then 1
	when 10 then 2
	when 11 then 3
	when 100 then 4
	when 101 then 5
	when 110 then 6
	when 111 then 7
	when 1000 then 8
	when 1001 then 9
	when 1101 then 10
	when 1100 then 11
	else 12 end 
	, Step = '7.7.3'
from lsa.tlsa_Exit ex
inner join (select distinct ex.HouseholdID, ex.HHType, ex.Cohort
			, case when rrh.HouseholdID is not null then 100 else 0 end
				+ case when th.HouseholdID is not null then 10 else 0 end
				+ case when es.HouseholdID is not null then 1 else 0 end
				+ case when psh.HouseholdID is not null then 1000 else 0 end
					as summary
		from lsa.tlsa_Exit ex 
		inner join lsa.tlsa_HHID qx on qx.HouseholdID = ex.QualifyingExitHHID
		left outer join lsa.tlsa_HHID es on es.ProjectType in (1,8)
			and es.HouseholdID = ex.HouseholdID and es.EntryDate <= qx.ExitDate and es.ExitDate > ex.LastInactive
			and (es.ActiveHHType = ex.HHType)
		left outer join lsa.tlsa_HHID th on th.ProjectType = 2
			and th.HouseholdID = ex.HouseholdID and th.EntryDate <= qx.ExitDate and th.ExitDate > ex.LastInactive
			and (th.ActiveHHType = ex.HHType)
		left outer join lsa.tlsa_HHID rrh on rrh.ProjectType = 13
			and rrh.HouseholdID = ex.HouseholdID and rrh.EntryDate <= qx.ExitDate and rrh.ExitDate > ex.LastInactive
			and (rrh.ActiveHHType = ex.HHType)
		left outer join lsa.tlsa_HHID psh on psh.ProjectType = 3
			and psh.EntryDate <= qx.ExitDate and psh.HouseholdID = ex.HouseholdID 
			and (psh.ActiveHHType = ex.HHType)
		) ptype on ptype.HouseholdID = ex.HouseholdID and ptype.HHType = ex.HHType 
		and ptype.Cohort = ex.Cohort
where ex.Cohort = 0 and ex.SystemPath is null;

update lsa.tlsa_Exit
set SystemPath = case ptype.summary
	when 1 then 1
	when 10 then 2
	when 11 then 3
	when 100 then 4
	when 101 then 5
	when 110 then 6
	when 111 then 7
	when 1000 then 8
	when 1001 then 9
	when 1101 then 10
	when 1100 then 11
	else 12 end 
	, Step = '7.7.4'
from lsa.tlsa_Exit ex
inner join (select distinct ex.HouseholdID, ex.HHType, ex.Cohort
			, case when rrh.HouseholdID is not null then 100 else 0 end
				+ case when th.HouseholdID is not null then 10 else 0 end
				+ case when es.HouseholdID is not null then 1 else 0 end
				+ case when psh.HouseholdID is not null then 1000 else 0 end
					as summary
		from lsa.tlsa_Exit ex 
		inner join lsa.tlsa_HHID qx on qx.HouseholdID = ex.QualifyingExitHHID
		left outer join lsa.tlsa_HHID es on es.ProjectType in (1,8)
			and es.HouseholdID = ex.HouseholdID and es.EntryDate <= qx.ExitDate and es.ExitDate > ex.LastInactive
			and (es.Exit1HHType = ex.HHType)
		left outer join lsa.tlsa_HHID th on th.ProjectType = 2
			and th.HouseholdID = ex.HouseholdID and th.EntryDate <= qx.ExitDate and th.ExitDate > ex.LastInactive
			and (th.Exit1HHType = ex.HHType)
		left outer join lsa.tlsa_HHID rrh on rrh.ProjectType = 13
			and rrh.HouseholdID = ex.HouseholdID and rrh.EntryDate <= qx.ExitDate and rrh.ExitDate > ex.LastInactive
			and (rrh.Exit1HHType = ex.HHType)
		left outer join lsa.tlsa_HHID psh on psh.ProjectType = 3
			and psh.EntryDate <= qx.ExitDate and psh.HouseholdID = ex.HouseholdID 
			and (psh.Exit1HHType = ex.HHType)
		) ptype on ptype.HouseholdID = ex.HouseholdID and ptype.HHType = ex.HHType 
		and ptype.Cohort = ex.Cohort
where ex.Cohort = -1 and ex.SystemPath is null;

update lsa.tlsa_Exit
set SystemPath = case ptype.summary
	when 1 then 1
	when 10 then 2
	when 11 then 3
	when 100 then 4
	when 101 then 5
	when 110 then 6
	when 111 then 7
	when 1000 then 8
	when 1001 then 9
	when 1101 then 10
	when 1100 then 11
	else 12 end 
	, Step = '7.7.5'
from lsa.tlsa_Exit ex
inner join (select distinct ex.HouseholdID, ex.HHType, ex.Cohort
			, case when rrh.HouseholdID is not null then 100 else 0 end
				+ case when th.HouseholdID is not null then 10 else 0 end
				+ case when es.HouseholdID is not null then 1 else 0 end
				+ case when psh.HouseholdID is not null then 1000 else 0 end
					as summary
		from lsa.tlsa_Exit ex 
		inner join lsa.tlsa_HHID qx on qx.HouseholdID = ex.QualifyingExitHHID
		left outer join lsa.tlsa_HHID es on es.ProjectType in (1,8)
			and es.HouseholdID = ex.HouseholdID and es.EntryDate <= qx.ExitDate and es.ExitDate > ex.LastInactive
			and (es.Exit2HHType = ex.HHType)
		left outer join lsa.tlsa_HHID th on th.ProjectType = 2
			and th.HouseholdID = ex.HouseholdID and th.EntryDate <= qx.ExitDate and th.ExitDate > ex.LastInactive
			and (th.Exit2HHType = ex.HHType)
		left outer join lsa.tlsa_HHID rrh on rrh.ProjectType = 13
			and rrh.HouseholdID = ex.HouseholdID and rrh.EntryDate <= qx.ExitDate and rrh.ExitDate > ex.LastInactive
			and (rrh.Exit2HHType = ex.HHType)
		left outer join lsa.tlsa_HHID psh on psh.ProjectType = 3
			and psh.EntryDate <= qx.ExitDate and psh.HouseholdID = ex.HouseholdID 
			and (psh.Exit2HHType = ex.HHType)
		) ptype on ptype.HouseholdID = ex.HouseholdID and ptype.HHType = ex.HHType 
		and ptype.Cohort = ex.Cohort
where ex.Cohort = -2 and ex.SystemPath is null;

/*
	7.8 Select Data for Export to LSAExit
*/

delete from lsa.lsa_Exit;
insert into lsa.lsa_Exit (RowTotal
	, Cohort, Stat, ExitFrom, ExitTo, ReturnTime, HHType
	, HHVet, HHDisability, HHFleeingDV, HoHRace, HoHEthnicity
	, HHAdultAge, HHParent, AC3Plus, SystemPath, ReportID)
select count (distinct HouseholdID || cast(HHType as varchar))
	, Cohort, Stat, ExitFrom, ExitTo
	, case when ReturnTime between 15 and 30 then 30
		when ReturnTime between 31 and 60 then 60
		when ReturnTime between 61 and 90 then 90
		when ReturnTime between 91 and 180 then 180
		when ReturnTime between 181 and 365 then 365
		when ReturnTime between 366 and 547 then 547
		when ReturnTime >= 548 then 730
		else ReturnTime end
	, HHType, HHVet, HHDisability, HHFleeingDV, HoHRace, HoHEthnicity
	, HHAdultAge, HHParent, AC3Plus, SystemPath, ReportID
from lsa.tlsa_Exit
group by Cohort, Stat, ExitFrom, ExitTo
	, case when ReturnTime between 15 and 30 then 30
		when ReturnTime between 31 and 60 then 60
		when ReturnTime between 61 and 90 then 90
		when ReturnTime between 91 and 180 then 180
		when ReturnTime between 181 and 365 then 365
		when ReturnTime between 366 and 547 then 547
		when ReturnTime >= 548 then 730
		else ReturnTime end
	, HHType, HHVet, HHDisability, HHFleeingDV, HoHRace, HoHEthnicity
	, HHAdultAge, HHParent, AC3Plus, SystemPath, ReportID;