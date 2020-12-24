CREATE OR REPLACE FUNCTION lsa.fun_hmis_households_and_enrollments (IN reportId integer, IN project_group_code varchar)
RETURNS void
 LANGUAGE plpgsql
AS $function$
BEGIN

/*
LSA FY2019 Sample Code

Name:  3_2 to 3_6 HMIS Households and Enrollments.sql 

Date:	4/16/2020 -- original 
		4/30/2020 -- create two separate scripts from original file (3_1 to 3_6 households and enrollments.sql):
					 - 3_1 LSAReport Parameters and Vendor Info Hardcoded Sample Data.sql
				     - 3_2 to 3_6 HMIS Households and Enrollments.sql
		5/14/2020 -- 3.3 - HoH enrollment EntryDate must be prior to project OperatingEndDate
					     - Exit destination must be 99 when effective exit date differs from HMIS
		5/21/2020 -- set value for Step columns in sections 3.3-3.6
		5/28/2020 -- section 3.3 
						- INSERT statement to lsa.tlsa_HHID:
							- include 'mid.moveindate > p.operatingenddate' in CASE statement list of conditions
								where lsa.tlsa_HHID.MoveInDate should be set to NULL
						- UPDATE statement to set ExitDest:
							- correct host home destination (HMIS value 32) from LSA category 10 to 11
							- remove 'hx.exitdate = hhid.ExitDate' from left outer join to exit 
				  -- section 3.4 - set DVStatus for lsa.tlsa_Enrollment in a separate step after INSERT 
									to ensure records are dated prior to ExitDate (actual or effective) if it exists
				  -- 3.5.2 and 3.5.3 - add missing parentheses to CASE
				  -- 3.6.2 - corrected table aliases in joins for adult/child/noDOB ExitDate
		6/4/2020 -- 3.5.1/2/3 -- corrections to FROM joins so that ActiveAge, Exit1Age, and Exit2Age are calculated for all enrollments
						and not just for those active during the relevant cohort period.
					3.5.2/3 -- simplified CASE statement/removed redundancies - no change to output
					3.3.1 - correction so that all enrollments located in ReportCoC at any time are included in lsa.tlsa_HHID 
							instead of limiting it to enrollment in ReportCoC as of the most recent EnrollmentCoC record.

	3.2 Cohort Dates 
*/

	
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
	, hoh.projectid, cast (cast (p.projecttype as text) as integer), cast (cast (p.trackingmethod as text) as integer)
	, hoh.entrydate 
	, case when mid.moveindate > rpt.ReportEnd 
			or p.projecttype not in ('3','13') 
			or mid.moveindate < hoh.entrydate 
			or mid.moveindate > p.operatingenddate then null
		when p.projecttype = '3' and (mid.moveindate < hx.exitdate or hx.exitdate is null) 
			then mid.moveindate
		when p.projecttype = '13' and (mid.moveindate <= hx.exitdate or hx.exitdate is null) 
			then mid.moveindate
		else null end
	, case when p.projecttype ='1' and p.trackingmethod = '3'
				and dateadd('d', 1, bn.LastBednight::date) >= p.operatingenddate then p.operatingenddate
		when p.projecttype = '1' and p.trackingmethod = '3' and hx.exitdate > dateadd('d', 1, bn.LastBednight::date)
			then dateadd('d', 1, bn.LastBednight::date)
		when p.projecttype = '1' and p.trackingmethod = '3' and hx.exitdate is null 
			and dateadd('d', 90, bn.LastBednight::date) <= rpt.ReportEnd then dateadd('d', 1, bn.LastBednight::date) 
		when p.operatingenddate <= rpt.ReportEnd and hx.exitdate is null then p.operatingenddate
		else hx.exitdate end
	, bn.LastBednight
	, '3.3.1'
from v2020.enrollment hoh
inner join lsa.lsa_Report rpt on rpt.ReportEnd >= hoh.entrydate AND rpt.project_group_code = hoh.project_group_code AND hoh.deleted is false AND hoh.parent_id is null
inner join v2020.moveindate mid on mid.enrollmentid = hoh.id
inner join v2020.enrollment_coc coc on coc.enrollmentid = hoh.id AND  rpt.project_group_code = coc.project_group_code
	and coc.coc_code= rpt.ReportCoC and coc.information_date <= rpt.ReportEnd
	and coc.deleted is false AND coc.parent_id is null
inner join v2020.project p on p.id = hoh.projectid AND rpt.project_group_code = p.project_group_code
	and (p.operatingenddate >= rpt.ReportStart or p.operatingenddate is NULL)
	and p.deleted is false AND p.parent_id is null 
left outer join v2020.exit hx on hx.enrollmentid = hoh.id
	and hx.exitdate <= rpt.ReportEnd 
	and (hx.exitdate <= p.operatingenddate or p.operatingenddate is null)
	and hx.deleted is null
left outer join v2020.enrollment hohCheck on hohCheck.householdid = hoh.householdid
	and hohCheck.relationshiptohoh = '1' and hohCheck.id <> hoh.id
	and hohCheck.deleted is false AND hohCheck.parent_id is null
left outer join (select distinct svc.enrollmentid, max(svc.dateprovided) as LastBednight
		from v2020.service_fa_referral svc
		inner join v2020.enrollment nbn on nbn.id = svc.enrollmentid
		left outer join v2020.exit nbnx on nbnx.enrollmentid = nbn.id AND nbnx.deleted is false AND nbnx.parent_id is NULL AND nbnx.project_group_code=nbn.project_group_code
		inner join v2020.project p on p.id = nbn.projectid 
			and p.projecttype = '1' and p.trackingmethod = '3' and p.deleted is false AND p.parent_id is NULL AND  p.project_group_code=nbn.project_group_code
			and (p.operatingenddate is null or p.operatingenddate > svc.dateprovided)
		inner join lsa.lsa_Report rpt on svc.dateprovided between '2012-10-1' and rpt.ReportEnd
		where svc.record_type = '200' and svc.deleted is false AND svc.parent_id is null 
			and svc.dateprovided >= nbn.entrydate and nbn.deleted is false AND nbn.parent_id is null 
			and (nbnx.exitdate is null or svc.dateprovided < nbnx.exitdate)
		group by svc.enrollmentid
		) bn on bn.enrollmentid = hoh.id
where hoh.relationshiptohoh = '1'
        and p.continuumproject = '1' 
	and (p.operatingenddate is null 
		-- 5/14/2020 EntryDate must be prior to OperatingEndDate
		or (p.operatingenddate > p.operatingstartdate  and hoh.entrydate < p.operatingenddate and p.operatingenddate >= '2012-10-1'))
	and	(hx.exitdate is null or 
			(hx.exitdate >= '2012-10-1' and hx.exitdate > hoh.entrydate) 
		)
	and ((p.projecttype in ('2','3','8','13'))
			or (p.projecttype = '1' and p.trackingmethod = '0')
			or (p.projecttype = '1' and p.trackingmethod = '3' and bn.LastBednight is not null)
		);

		update lsa.tlsa_HHID
		set ExitDest = case	
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
				else 99	end
			, Step = '3.3.2'
		from lsa.tlsa_HHID hhid
		left outer join v2020.exit hx on cast (hx.enrollmentid as varchar)= hhid.EnrollmentID
			and hx.deleted is null 
		where hhid.ExitDate is not null;	

/*
	3.4  HMIS Client Enrollments
*/
	delete from lsa.tlsa_Enrollment;

	insert into lsa.tlsa_Enrollment 
		(EnrollmentID, PersonalID, HouseholdID
		, RelationshipToHoH
		, ProjectID, ProjectType, TrackingMethod
		, EntryDate, MoveInDate, ExitDate
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


update n
set n.EntryAge = case when c.DOBDataQuality in (8,9) then 98
			when c.DOB is null 
				or c.DOB = '1/1/1900'
				or c.DOB > n.EntryDate
				or (n.RelationshipToHoH = 1 and c.DOB = n.EntryDate)
				or DATEADD(yy, 105, c.DOB) <= n.EntryDate 
				or c.DOBDataQuality is null
				or c.DOBDataQuality not in (1,2) then 99
			when DATEADD(yy, 65, c.DOB) <= n.EntryDate then 65
			when DATEADD(yy, 55, c.DOB) <= n.EntryDate then 64
			when DATEADD(yy, 45, c.DOB) <= n.EntryDate then 54
			when DATEADD(yy, 35, c.DOB) <= n.EntryDate then 44
			when DATEADD(yy, 25, c.DOB) <= n.EntryDate then 34
			when DATEADD(yy, 22, c.DOB) <= n.EntryDate then 24
			when DATEADD(yy, 18, c.DOB) <= n.EntryDate then 21
			when DATEADD(yy, 6, c.DOB) <= n.EntryDate then 17
			when DATEADD(yy, 3, c.DOB) <= n.EntryDate then 5
			when DATEADD(yy, 1, c.DOB) <= n.EntryDate then 2
			else 0 end 	
	, n.Step = '3.4.2'
from tlsa_Enrollment n
inner join v2020.client c on c.id = n.PersonalID;


update lsa.tlsa_Enrollment set Step = '3.4.3', DVStatus =
	 (select  min(case when dv.domesticviolencevictim = '1' and dv.currently_fleeing = 1 then 1
				when dv.domesticviolencevictim = '1' and dv.currently_fleeing = 0 then 2 
				when dv.domesticviolencevictim = '1' then 3
				when dv.domesticviolencevictim = '0' then 10
				when dv.domesticviolencevictim in ('8','9') then 98
				else null end) 
			from lsa.lsa_Report rpt,
			lsa.tlsa_Enrollment n,
			v2020.domesticviolence dv 
			where cast (dv.enrollmentid as varchar) = n.EnrollmentID 
			        and dv.deleted= false and dv.parent_id is null
			        and dv.project_group_code = rpt.project_group_code
				 and dv.information_date <= rpt.ReportEnd
				 and (dv.information_date <= n.ExitDate or n.ExitDate is null))
		
/*
	3.5 Enrollment Ages - Active and Exit
		NOTE:  EntryAge is included in the 3.4 insert statement
*/

update n
	set n.EntryAge = 99, n.Step = '3.5.2'
	from lsa.tlsa_Enrollment n
	inner join lsa.tlsa_Enrollment DOBIssue on DOBIssue.PersonalID = n.PersonalID
		and DOBIssue.EntryAge = 99;
		
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
		, Step = '3.5.2'
	from lsa.lsa_Report rpt
	inner join lsa.tlsa_Enrollment n on n.EntryDate <= rpt.ReportEnd 
	inner join v2020.client c on CAST (c.id AS varchar) = n.PersonalID;


update lsa.tlsa_Enrollment
	set ActiveAge =  EntryAge ;
	
	update lsa.tlsa_Enrollment
	set Exit1Age = case when n.ExitDate < cd.CohortStart
				or n.EntryDate >= cd.CohortStart
				or n.EntryAge in (98,99) then n.EntryAge
			--  If exit is prior to cohort start, age is unknown, 
			--		or entry is in or after cohort period, use EntryAge; 
			--  Otherwise, recalculate age as of CohortStart 
			when DATEADD('y', 65, cast (convert_from(dob_decrypt(c.dob), 'utf-8') as date)) <= cd.CohortStart then 65
			when DATEADD('y', 55, cast (convert_from(dob_decrypt(c.dob), 'utf-8') as date)) <= cd.CohortStart then 64
			when DATEADD('y', 45, cast (convert_from(dob_decrypt(c.dob), 'utf-8') as date)) <= cd.CohortStart then 54
			when DATEADD('y', 35, cast (convert_from(dob_decrypt(c.dob), 'utf-8') as date)) <= cd.CohortStart then 44
			when DATEADD('y', 25, cast (convert_from(dob_decrypt(c.dob), 'utf-8') as date)) <= cd.CohortStart then 34
			when DATEADD('y', 22, cast (convert_from(dob_decrypt(c.dob), 'utf-8') as date)) <= cd.CohortStart then 24
			when DATEADD('y', 18, cast (convert_from(dob_decrypt(c.dob), 'utf-8') as date)) <= cd.CohortStart then 21
			when DATEADD('y', 6, cast (convert_from(dob_decrypt(c.dob), 'utf-8') as date)) <= cd.CohortStart then 17
			when DATEADD('y', 3, cast (convert_from(dob_decrypt(c.dob), 'utf-8') as date)) <= cd.CohortStart then 5
			when DATEADD('y', 1, cast (convert_from(dob_decrypt(c.dob), 'utf-8') as date)) <= cd.CohortStart then 2
			else 0 end 				
		, Step = '3.5.3'
	from  lsa.tlsa_Enrollment n
	inner join lsa.tlsa_CohortDates cd on cd.Cohort = -1 
	inner join v2020.client c on CAST(c.id AS varchar) = n.PersonalID;

	update lsa.tlsa_Enrollment
	set Exit2Age = case when n.ExitDate < cd.CohortStart
				or n.EntryDate >= cd.CohortStart
				or n.EntryAge in (98,99) then n.EntryAge
			--  If exit is prior to cohort start, age is unknown, 
			--		or entry is in or after cohort period, use EntryAge; 
			--  Otherwise, recalculate age as of CohortStart 
			when DATEADD('y', 65, cast (convert_from(dob_decrypt(c.dob), 'utf-8') as date)) <= cd.CohortStart then 65
			when DATEADD('y', 55, cast (convert_from(dob_decrypt(c.dob), 'utf-8') as date)) <= cd.CohortStart then 64
			when DATEADD('y', 45, cast (convert_from(dob_decrypt(c.dob), 'utf-8') as date)) <= cd.CohortStart then 54
			when DATEADD('y', 35, cast (convert_from(dob_decrypt(c.dob), 'utf-8') as date)) <= cd.CohortStart then 44
			when DATEADD('y', 25, cast (convert_from(dob_decrypt(c.dob), 'utf-8') as date)) <= cd.CohortStart then 34
			when DATEADD('y', 22, cast (convert_from(dob_decrypt(c.dob), 'utf-8') as date)) <= cd.CohortStart then 24
			when DATEADD('y', 18, cast (convert_from(dob_decrypt(c.dob), 'utf-8') as date)) <= cd.CohortStart then 21
			when DATEADD('y', 6, cast (convert_from(dob_decrypt(c.dob), 'utf-8') as date)) <= cd.CohortStart then 17
			when DATEADD('y', 3, cast (convert_from(dob_decrypt(c.dob), 'utf-8') as date)) <= cd.CohortStart then 5
			when DATEADD('y', 1, cast (convert_from(dob_decrypt(c.dob), 'utf-8') as date)) <= cd.CohortStart then 2
			else 0 end 				
		, Step = '3.5.4'
	from  lsa.tlsa_Enrollment n
	inner join lsa.tlsa_CohortDates cd on cd.Cohort = -2 
	inner join v2020.client c on CAST (c.id AS varchar) = n.PersonalID;

/*
	3.6 Household Types
*/

-- Note:  Code here and elsewhere uses 'between 18 and 65' instead of 'between 21 and 65' because the output
--        is the same (there are no values of 18, 19, or 20) and it is easier to understand without consulting 
--		  the LSA Dictionary.
	update lsa.tlsa_HHID
	set EntryHHType = case 
			when adult.EnrollmentID is not null 
				and child.EnrollmentID is null
				and noDOB.EnrollmentID is null then 1
			when adult.EnrollmentID is not null 
				and child.EnrollmentID is not null then 2
			when adult.EnrollmentID is null 
				and child.EnrollmentID is not null
				and noDOB.EnrollmentID is null then 3	
			else 99 end
		, Step = '3.6.1'
	from lsa.tlsa_HHID hhid 
	left outer join lsa.tlsa_Enrollment adult on adult.HouseholdID = hhid.HouseholdID 
		and adult.EntryAge between 18 and 65
	left outer join lsa.tlsa_Enrollment child on child.HouseholdID = hhid.HouseholdID 
		and child.EntryAge < 18
	left outer join lsa.tlsa_Enrollment noDOB on noDOB.HouseholdID = hhid.HouseholdID 
		and noDOB.EntryAge in (98,99);

	update lsa.tlsa_HHID
	set ActiveHHType = case 
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
			else 99 end
		, Step = '3.6.2'
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
		and (noDOB.ExitDate is null or noDOB.ExitDate >= rpt.ReportStart);

	update lsa.tlsa_HHID
	set Exit1HHType = case 
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
			else 99 end
		, Step = '3.6.3'
	from lsa.tlsa_HHID hhid
	inner join lsa.tlsa_CohortDates cd on cd.CohortEnd <> hhid.EntryDate anch d cd.Cohort = -1
	left outer join lsa.tlsa_Enrollment adult on adult.HouseholdID = hhid.HouseholdID 
		and adult.Exit1Age between 18 and 65 and adult.ExitDate between cd.CohortStart and cd.CohortEnd
	left outer join lsa.tlsa_Enrollment child on child.HouseholdID = hhid.HouseholdID 
		and child.Exit1Age < 18 and child.ExitDate between cd.CohortStart and cd.CohortEnd
	left outer join lsa.tlsa_Enrollment noDOB on noDOB.HouseholdID = hhid.HouseholdID 
		and noDOB.Exit1Age in (98,99) and noDOB.ExitDate between cd.CohortStart and cd.CohortEnd;

	update lsa.tlsa_HHID
	set Exit2HHType = case 
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
			else 99 end
		, Step = '3.6.4'
	from lsa.tlsa_HHID hhid
	inner join lsa.tlsa_CohortDates cd on cd.CohortEnd <> hhid.EntryDate and cd.Cohort = -2
	left outer join lsa.tlsa_Enrollment adult on adult.HouseholdID = hhid.HouseholdID 
		and adult.Exit2Age between 18 and 65 and adult.ExitDate between cd.CohortStart and cd.CohortEnd
	left outer join lsa.tlsa_Enrollment child on child.HouseholdID = hhid.HouseholdID 
		and child.Exit2Age < 18 and child.ExitDate between cd.CohortStart and cd.CohortEnd
	left outer join lsa.tlsa_Enrollment noDOB on noDOB.HouseholdID = hhid.HouseholdID 
		and noDOB.Exit2Age in (98,99) and noDOB.ExitDate between cd.CohortStart and cd.CohortEnd;


END
$function$
;
