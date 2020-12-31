

CREATE OR REPLACE FUNCTION lsa.run_hmis_households_and_enrollments (IN reportId integer, IN project_group_code varchar)
RETURNS void
 LANGUAGE plpgsql
AS $function$
BEGIN

delete from lsa.tlsa_CohortDates;

	insert into lsa.tlsa_CohortDates (Cohort, CohortStart, CohortEnd, ReportID)
	select 1, rpt.ReportStart, rpt.ReportEnd, rpt.ReportID
	from lsa.lsa_Report rpt;

	insert into lsa.tlsa_CohortDates (Cohort, CohortStart, CohortEnd, ReportID)
	select 0, rpt.ReportStart,
		case when dateadd('m', -6, rpt.ReportEnd) <= rpt.ReportStart
			then rpt.ReportEnd
			else dateadd('m', -6, rpt.ReportEnd) end
		, rpt.ReportID
	from lsa.lsa_Report rpt;

	insert into lsa.tlsa_CohortDates (Cohort, CohortStart, CohortEnd, ReportID)
	select -1, dateadd('y', -1, rpt.ReportStart)
		, dateadd('y', -1, rpt.ReportEnd)
		, rpt.ReportID
	from lsa.lsa_Report rpt;

	insert into lsa.tlsa_CohortDates (Cohort, CohortStart, CohortEnd, ReportID)
	select -2, dateadd('y', -2, rpt.ReportStart)
		, dateadd('y', -2, rpt.ReportEnd)
		, rpt.ReportID
	from lsa.lsa_Report rpt;

	insert into lsa.tlsa_CohortDates (Cohort, CohortStart, CohortEnd, ReportID)
	select distinct case cal.mm
		when 10 then 10
		when 1 then 11
		when 4 then 12
		else 13 end
		, cal.theDate
		, cal.theDate
		, rpt.ReportID
	from lsa.lsa_Report rpt
	inner join lsa.ref_Calendar cal
		on cal.theDate between rpt.ReportStart and rpt.ReportEnd
	where (cal.mm = 10 and cal.dd = 31 and cal.yyyy = date_part('year', rpt.ReportStart))
		or (cal.mm = 1 and cal.dd = 31 and cal.yyyy = date_part('year', rpt.ReportEnd))
		or (cal.mm = 4 and cal.dd = 30 and cal.yyyy = date_part('year', rpt.ReportEnd))
		or (cal.mm = 7 and cal.dd = 31 and cal.yyyy = date_part('year', rpt.ReportEnd));

	insert into lsa.tlsa_CohortDates (Cohort, CohortStart, CohortEnd, ReportID)
	select 20, dateadd('d', 1, dateadd('y', -3, rpt.ReportEnd)), rpt.ReportEnd, rpt.ReportID
	from lsa.lsa_Report rpt;

/*
	3.3 HMIS HouseholdIDs
*/

delete from lsa.tlsa_HHID;

insert into lsa.tlsa_HHID (
	  HouseholdID, HoHID, EnrollmentID
	, ProjectID, ProjectType, TrackingMethod
	, EntryDate
	, MoveInDate
	, ExitDate
	, LastBednight
	, Step)
	select distinct hoh.householdid, hoh.client_id, hoh.id
		, hoh.projectid, cast (cast (p.projecttype as varchar) as integer), cast (cast (p.trackingmethod as varchar) as integer)
		, hoh.entrydate
		, case when mid.moveindate > rpt.ReportEnd
				or p.projecttype not in ('3','13')
				or mid.moveindate < hoh.entrydate
				or mid.moveindate > p.operatingenddate then null
			when p.projecttype = '3' and (mid.moveindate < hx.exitdate or hx.exitdate is null)
				then mid.moveindate
			when p.projecttype = '13' and (mid.moveindate <= hx.exitdate or hx.exitdate is null)
				then mid.moveindate
			else null END
	    ,case when p.ProjectType = '1' and p.TrackingMethod = '3'
					and dateadd('d', 1,bn.LastBednight::date) >= p.OperatingEndDate
					then p.OperatingEndDate
		    when p.ProjectType = '1' and p.TrackingMethod = '3' and hx.ExitDate > dateadd('d', 1, bn.LastBednight::date)
				then dateadd('d', 1, bn.LastBednight::date)
			when p.ProjectType = '1' and p.TrackingMethod = '3' and hx.ExitDate is null
				and dateadd('d', 90, bn.LastBednight::date) <= rpt.ReportEnd then dateadd('d', 1, bn.LastBednight::date)
			when p.OperatingEndDate <= rpt.ReportEnd and hx.ExitDate is null then p.OperatingEndDate
			else hx.ExitDate end
		, bn.LastBednight
		, '3.3.1'
	from v2020.enrollment hoh
	inner join lsa.lsa_Report rpt on rpt.ReportEnd >= hoh.entrydate AND rpt.project_group_code = hoh.project_group_code AND hoh.deleted is false AND hoh.parent_id is null
	inner join v2020.moveindate mid on mid.enrollmentid = hoh.id AND rpt.project_group_code = mid.project_group_code AND mid.deleted is false AND mid.parent_id is null
	inner join v2020.enrollment_coc coc on coc.enrollmentid = hoh.id AND  rpt.project_group_code = coc.project_group_code
		and coc.coc_code= rpt.ReportCoC and coc.information_date <= rpt.ReportEnd
		and coc.deleted is false AND coc.parent_id is null
	inner join v2020.project p on p.id = hoh.projectid AND rpt.project_group_code = p.project_group_code
		and p.deleted is false AND p.parent_id is null
	left outer join v2020.exit hx on hx.enrollmentid = hoh.id
		and hx.exitdate <= rpt.ReportEnd
		and (hx.exitdate <= p.operatingenddate or p.operatingenddate is null)
		and rpt.project_group_code = hx.project_group_code
		and hx.deleted = false and hx.parent_id  is null
	left outer join v2020.enrollment hohCheck on hohCheck.householdid = hoh.householdid
		and hohCheck.relationshiptohoh = '1' and hohCheck.id <> hoh.id
		and hohCheck.deleted is false AND hohCheck.parent_id is null
		and hohCheck.project_group_code = rpt.project_group_code
	left outer join (select distinct svc.enrollmentid, max(svc.dateprovided) as LastBednight
			from v2020.service_fa_referral svc
			inner join v2020.enrollment nbn on nbn.id = svc.enrollmentid
			left outer join v2020.exit nbnx on nbnx.enrollmentid = nbn.id
			AND nbnx.deleted is false AND nbnx.parent_id is NULL
			AND nbnx.project_group_code=nbn.project_group_code
			inner join v2020.project p on p.id = nbn.projectid
				and p.projecttype = '1' and p.trackingmethod = '3'
				and p.deleted is false AND p.parent_id is NULL
				AND  p.project_group_code=nbn.project_group_code
				and (p.operatingenddate is null or p.operatingenddate > svc.dateprovided)
			inner join lsa.lsa_Report rpt on svc.dateprovided between '2012-10-1' and rpt.ReportEnd
			where svc.record_type = '200' and svc.deleted is false AND svc.parent_id is null
				and svc.dateprovided >= nbn.entrydate and nbn.deleted is false AND nbn.parent_id is null
				and nbn.project_group_code = rpt.project_group_code
				and (nbnx.exitdate is null or svc.dateprovided < nbnx.exitdate)
			group by svc.enrollmentid
			) bn on bn.enrollmentid = hoh.id
	where hoh.relationshiptohoh = '1'
	        and p.continuumproject = '1'
		and (p.operatingenddate is null
			or (p.OperatingEndDate > p.OperatingStartDate
			AND hoh.entrydate < p.operatingenddate
			and p.operatingenddate >= '2012-10-1'))
		and	(hx.exitdate is null or
				(hx.exitdate >= '2012-10-1' and hx.exitdate > hoh.entrydate)
			)
		and ((p.projecttype in ('2','3','8','13'))
				or (p.projecttype = '1' and p.trackingmethod = '0')
				or (p.projecttype = '1' and p.trackingmethod = '3' and bn.LastBednight is not null)
			);

			WITH subquery_3_3_2 AS (
		select hhid.enrollmentid ,
						case
						-- 5/14/2020 exit destination must be 99 when the effective exit date differs from HMIS
						when hx.exitdate is null or hx.exitdate <> hhid.ExitDate then 99
						when hx.destination = '3' then 1 --PSH
						when hx.destination = '31' then 2	--PH - rent/temp subsidy --TODO
						when hx.destination in ('19','20','21','26','28','33','34') then 3	--PH - rent/own with subsidy
						when hx.destination in ('10','11') then 4	--PH - rent/own no subsidy
						when hx.destination = '22' then 5	--Family - perm
						when hx.destination = '23' then 6	--Friends - perm
						when hx.destination in ('15','25') then 7	--Institutions - group/assisted
						when hx.destination in ('4','5','6') then 8	--Institutions - medical
						when hx.destination = '7' then 9	--Institutions - incarceration
						when hx.destination in ('14','29') then 10	--Temporary - not homeless
						when hx.destination in ('1','2','18','27','32') then 11	--Homeless - ES/SH/TH/host home
						when hx.destination = '16' then 12	--Homeless - Street
						when hx.destination = '12' then 13	--Family - temp
						when hx.destination = '13' then 14	--Friends - temp
						when hx.destination = '24' then 15	--Deceased
						else 99	end as ExitDest
					, Step = '3.3.2'
				from lsa.tlsa_HHID hhid
				left outer join v2020.exit hx on cast (hx.enrollmentid as varchar)= hhid.EnrollmentID
					and hx.deleted is false and hx.parent_id  is null
				where hhid.ExitDate is not null )

			update lsa.tlsa_HHID
				set ExitDest = subquery_3_3_2.ExitDest
			from subquery_3_3_2
			where subquery_3_3_2.enrollmentid = lsa.tlsa_HHID.enrollmentid ;



/*
	3.4  HMIS Client Enrollments
*/
	delete from lsa.tlsa_Enrollment;

	insert into lsa.tlsa_Enrollment
		(EnrollmentID, PersonalID, HouseholdID
		, RelationshipToHoH
		, ProjectID, ProjectType, TrackingMethod
		, EntryDate, MoveInDate, ExitDate
		, EntryAge
		, DisabilityStatus
		, Step)
	select distinct hn.id, hn.client_id, hn.householdid
		,cast( cast (hn.relationshiptohoh as varchar) as integer)
		, hhid.ProjectID, hhid.ProjectType, hhid.TrackingMethod
		, hn.entrydate
		, case when hhid.MoveInDate < hn.entrydate then hn.entrydate
			when hhid.MoveInDate > hx.exitdate then NULL
			when hhid.MoveInDate = hx.exitdate and
				(hhid.ExitDate is NULL or hhid.ExitDate > hx.exitdate) then NULL
			else hhid.MoveInDate end
		, case when hx.exitdate >= hhid.ExitDate then hhid.ExitDate
			when hx.exitdate is NULL and hhid.ExitDate is not NULL then hhid.ExitDate
			else hx.exitdate end
		, case when c.dob_data_quality in ('8','9') then 98
			when cast (convert_from(dob_decrypt(c.dob), 'utf-8') as date)is null
				or cast (convert_from(dob_decrypt(c.dob), 'utf-8') as date)= '1900-1-1'
				or cast (convert_from(dob_decrypt(c.dob), 'utf-8') as date)> hn.entrydate
				or (hn.relationshiptohoh = '1' and cast (convert_from(dob_decrypt(c.dob), 'utf-8') as date)= hn.entrydate)
				or DATEADD('y', 105, cast (convert_from(dob_decrypt(c.dob), 'utf-8') as date)) <= hn.entrydate
				or c.dob_data_quality is null
				or c.dob_data_quality not in ('1','2') then 99
			when DATEADD('y', 65, cast (convert_from(dob_decrypt(c.dob), 'utf-8') as date)) <= hn.entrydate then 65
			when DATEADD('y', 55, cast (convert_from(dob_decrypt(c.dob), 'utf-8') as date)) <= hn.entrydate then 64
			when DATEADD('y', 45, cast (convert_from(dob_decrypt(c.dob), 'utf-8') as date)) <= hn.entrydate then 54
			when DATEADD('y', 35, cast (convert_from(dob_decrypt(c.dob), 'utf-8') as date)) <= hn.entrydate then 44
			when DATEADD('y', 25, cast (convert_from(dob_decrypt(c.dob), 'utf-8') as date)) <= hn.entrydate then 34
			when DATEADD('y', 22, cast (convert_from(dob_decrypt(c.dob), 'utf-8') as date)) <= hn.entrydate then 24
			when DATEADD('y', 18, cast (convert_from(dob_decrypt(c.dob), 'utf-8') as date)) <= hn.entrydate then 21
			when DATEADD('y', 6, cast (convert_from(dob_decrypt(c.dob), 'utf-8') as date)) <= hn.entrydate then 17
			when DATEADD('y', 3, cast (convert_from(dob_decrypt(c.dob), 'utf-8') as date)) <= hn.entrydate then 5
			when DATEADD('y', 1, cast (convert_from(dob_decrypt(c.dob), 'utf-8') as date)) <= hn.entrydate then 2
			else 0 end
		, case when hn.disablingcondition in ('0','1') then cast (cast (hn.disablingcondition as varchar) as integer)
			else null end
		, '3.4.1'
	from lsa.tlsa_HHID hhid
	inner join v2020.enrollment hn on hn.householdid = hhid.HouseholdID AND hn.parent_id is null and hn.deleted is false
	inner join v2020.client c on c.id = hn.client_id AND c.parent_id is null and c.deleted is false AND c.project_group_code=hn.project_group_code
	inner join lsa.lsa_Report rpt on rpt.ReportEnd >= hn.entrydate AND rpt.project_group_code=hn.project_group_code
	left outer join v2020.exit hx on hx.enrollmentid = hn.id	and c.parent_id is null and c.deleted is false AND hx.project_group_code=hn.project_group_code
		and hx.exitdate <= rpt.ReportEnd
	where hn.relationshiptohoh in ('1','2','3','4','5')
		and hn.entrydate between hhid.EntryDate and COALESCE(hhid.ExitDate, rpt.ReportEnd)
		and (hx.exitdate is null or
				(hx.exitdate > hhid.EntryDate and hx.exitdate >= '2012-10-1'
					and hx.exitdate > hn.entrydate)) ;


	WITH dvstatusquery AS (
	select n.EnrollmentID as eid, min(case when dv.domesticviolencevictim = '1' and dv.currently_fleeing = 1 then 1
				when dv.domesticviolencevictim = '1' and dv.currently_fleeing = 0 then 2
				when dv.domesticviolencevictim = '1' then 3
				when dv.domesticviolencevictim = '0' then 10
				when dv.domesticviolencevictim in ('8','9') then 98
				else null end) as status
			from lsa.lsa_Report rpt,
			lsa.tlsa_Enrollment n,
			v2020.domesticviolence dv
			where cast (dv.enrollmentid as varchar) = n.EnrollmentID
			        and dv.deleted= false and dv.parent_id is null
			        and dv.project_group_code = rpt.project_group_code
				 and dv.information_date <= rpt.ReportEnd
				 and (dv.information_date <= n.ExitDate or n.ExitDate is null)
				 group by n.EnrollmentID
				 )

update lsa.tlsa_Enrollment set DVStatus =dvstatusquery.status
from dvstatusquery
where enrollmentid  = dvstatusquery.eid;


/*
	3.5 Enrollment Ages - Active and Exit
		NOTE:  EntryAge is included in the 3.4 insert statement
*/

	update lsa.tlsa_enrollment  set ActiveAge = entryage , Step = '3.5.2';
	update lsa.tlsa_enrollment  set exit1age = entryage , Step = '3.5.3';



	update lsa.tlsa_enrollment  set ActiveAge = entryage , Step = '3.5.2' ;
	update lsa.tlsa_enrollment  set exit1age = entryage , Step = '3.5.3' ;
	update lsa.tlsa_enrollment  set exit2age = entryage , Step = '3.5.3' ;



/*
	3.6 Household Types
*/

-- Note:  Code here and elsewhere uses 'between 18 and 65' instead of 'between 21 and 65' because the output
--        is the same (there are no values of 18, 19, or 20) and it is easier to understand without consulting
--		  the LSA Dictionary.

WITH subquery AS (
    select  hhid.HouseholdID as HouseholdID ,
	     case
	       when adult.EnrollmentID is not null
				and child.EnrollmentID is null
				and noDOB.EnrollmentID is null then 1
			when adult.EnrollmentID is not null
				and child.EnrollmentID is not null then 2
			when adult.EnrollmentID is null
				and child.EnrollmentID is not null
				and noDOB.EnrollmentID is null then 3
			else 99 end as hhtype
	from lsa.tlsa_HHID hhid
	left outer join lsa.tlsa_Enrollment adult on adult.HouseholdID = hhid.HouseholdID
		and adult.EntryAge between 18 and 65
	left outer join lsa.tlsa_Enrollment child on child.HouseholdID = hhid.HouseholdID
		and child.EntryAge < 18
	left outer join lsa.tlsa_Enrollment noDOB on noDOB.HouseholdID = hhid.HouseholdID
		and noDOB.EntryAge in (98,99)
	)

	update lsa.tlsa_HHID set	EntryHHType =subquery.hhtype,
	Step = '3.6.1'
	from subquery
		where
		lsa.tlsa_HHID.HouseholdID = subquery.HouseholdID;


		WITH subquery1 AS (
	select  hhid.HouseholdID as HouseholdID ,
	case
	when hhid.ExitDate < rpt.ReportStart
				or hhid.EntryDate >= rpt.ReportStart then hhid.EntryHHType
			when adult.EnrollmentID is not null
				and child.EnrollmentID is null
				and noDOB.EnrollmentID is null then 1
			when adult.EnrollmentID is not null
				and child.EnrollmentID is not null then 2
			when adult.EnrollmentID is null
				and child.EnrollmentID is not null
				and noDOB.EnrollmentID is null then 3
			else 99 end as hhtype
	from lsa.tlsa_HHID hhid
	inner join lsa.lsa_Report rpt on rpt.ReportEnd >= hhid.EntryDate
	left outer join lsa.tlsa_Enrollment adult on adult.HouseholdID = hhid.HouseholdID
		and adult.ActiveAge between 18 and 65
		and (adult.ExitDate is null or adult.ExitDate >= rpt.ReportStart)
	left outer join lsa.tlsa_Enrollment child on child.HouseholdID = hhid.HouseholdID
		and child.ActiveAge < 18
		and (child.ExitDate is null or child.ExitDate >= rpt.ReportStart)
	left outer join lsa.tlsa_Enrollment noDOB on noDOB.HouseholdID = hhid.HouseholdID
		and noDOB.ActiveAge in (98,99)
		and (noDOB.ExitDate is null or noDOB.ExitDate >= rpt.ReportStart)
	)

	update lsa.tlsa_HHID set ActiveHHType =subquery1.hhtype,
	Step = '3.6.2'
	from subquery1
	where
	lsa.tlsa_HHID.HouseholdID = subquery1.HouseholdID;


	WITH subquery2 AS (
	select  hhid.HouseholdID as HouseholdID ,
	 case
			when hhid.ExitDate < cd.CohortStart
				or hhid.EntryDate >= cd.CohortStart then hhid.EntryHHType
			when adult.EnrollmentID is not null
				and child.EnrollmentID is null
				and noDOB.EnrollmentID is null then 1
			when adult.EnrollmentID is not null
				and child.EnrollmentID is not null then 2
			when adult.EnrollmentID is null
				and child.EnrollmentID is not null
				and noDOB.EnrollmentID is null then 3
			else 99 end as hhtype
	from lsa.tlsa_HHID hhid
	inner join lsa.tlsa_CohortDates cd on cd.CohortEnd <> hhid.EntryDate and cd.Cohort = -1
	left outer join lsa.tlsa_Enrollment adult on adult.HouseholdID = hhid.HouseholdID
		and adult.Exit1Age between 18 and 65 and adult.ExitDate between cd.CohortStart and cd.CohortEnd
	left outer join lsa.tlsa_Enrollment child on child.HouseholdID = hhid.HouseholdID
		and child.Exit1Age < 18 and child.ExitDate between cd.CohortStart and cd.CohortEnd
	left outer join lsa.tlsa_Enrollment noDOB on noDOB.HouseholdID = hhid.HouseholdID
		and noDOB.Exit1Age in (98,99) and noDOB.ExitDate between cd.CohortStart and cd.CohortEnd
		)

	update lsa.tlsa_HHID set Exit1HHType =subquery2.hhtype,
	Step = '3.6.3'
	from subquery2
	where
	lsa.tlsa_HHID.HouseholdID = subquery2.HouseholdID;




	WITH subquery3 AS (
	select  hhid.HouseholdID as HouseholdID ,
	  	   case
			when hhid.ExitDate < cd.CohortStart
				or hhid.EntryDate >= cd.CohortStart then hhid.EntryHHType
			when adult.EnrollmentID is not null
				and child.EnrollmentID is null
				and noDOB.EnrollmentID is null then 1
			when adult.EnrollmentID is not null
				and child.EnrollmentID is not null then 2
			when adult.EnrollmentID is null
				and child.EnrollmentID is not null
				and noDOB.EnrollmentID is null then 3
			else 99 end as hhtype

	from lsa.tlsa_HHID hhid
	inner join lsa.tlsa_CohortDates cd on cd.CohortEnd <> hhid.EntryDate and cd.Cohort = -2
	left outer join lsa.tlsa_Enrollment adult on adult.HouseholdID = hhid.HouseholdID
		and adult.Exit2Age between 18 and 65 and adult.ExitDate between cd.CohortStart and cd.CohortEnd
	left outer join lsa.tlsa_Enrollment child on child.HouseholdID = hhid.HouseholdID
		and child.Exit2Age < 18 and child.ExitDate between cd.CohortStart and cd.CohortEnd
	left outer join lsa.tlsa_Enrollment noDOB on noDOB.HouseholdID = hhid.HouseholdID
		and noDOB.Exit2Age in (98,99) and noDOB.ExitDate between cd.CohortStart and cd.CohortEnd
	)

	update lsa.tlsa_HHID set Exit2HHType =subquery3.hhtype,
	Step = '3.6.4'
	from subquery3
	where
	lsa.tlsa_HHID.HouseholdID = subquery3.HouseholdID;

	END
$function$
;
