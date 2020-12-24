/*
Name:  4_2 to 4_6 Other PDDEs for Export.sql

Date:	4/2/2020 -- original 
		4/30/2020 -- create two separate scripts from original file (4_1 to 4_6 PDDEs for export.sql):
					 - 4_1 Get Project Records for Export.sql
				     - 4_2 to 4_6 Other PDDEs for Export.sql
				  -- correct all date formatting from "yyyy"-"mm"-"dd" to "yyyy"-MM-"dd"
		5/14/2020 -- section 4.3 - include "OtherFunder" column
				  -- section 4.5 - include 'future' inventory records
		6/11/2020 -- sections 4.2-4.5 - correct time format for "DateCreated" and "DateUpdated" to 24-hour 
						(HH:"mm":ss instead of hh:"mm":ss)
				  -- section 4.5 - format "InventoryStartDate" and "InventoryEndDate"
		6/18/2020 -- section 4.5 - cast "InventoryEndDate" as datetime (required to use ISDATE() function).					    

	4.2 Get Organization Records for Export
		Export organization records for all projects selected in 4.2.
		Organization.csv must have exactly one Organization record for each 
			"OrganizationID" in Project.csv 
*/	  	

	delete from lsa.lsa_Organization;

	insert into lsa.lsa_Organization
		(OrganizationID, OrganizationName
		, VictimServicesProvider
		, DateCreated, DateUpdated, ExportID)
	select distinct ho.id
		, left(ho.organizationname, 50)
		, cast (cast(ho.victimserviceprovider as varchar)	as integer)
		, to_char(ho.date_created::date, 'yyyy-MM-dd hh:mm:ss')
		, to_char(ho.date_updated::date, 'yyyy-MM-dd hh:mm:ss')
		, lp.ExportID
	from v2020.organization ho
	inner join lsa.lsa_Project lp on lp.OrganizationID = CAST (ho.id AS varchar)
	where ho.deleted is false AND ho.parent_id IS null ;

/*
	4.3 Get Funder Records for Export
		Get records for project funders with grants active in the report period.
		Funder.csv must have at least one Funder record for each ProjectID 
			in Project.csv. 
*/

	delete from lsa.lsa_Funder;

	insert into lsa.lsa_Funder	
		 (FunderID, ProjectID, Funder, OtherFunder
		, StartDate, EndDate
		, DateCreated, DateUpdated, ExportID)
	select distinct hf.id, hf.projectid, cast(cast(hf.funder as varchar) as integer), hf.otherfunder
		, to_char(hf.startdate, 'yyyy-MM-dd')
		, case when hf.enddate is not null then  to_char(hf.enddate, 'yyyy-MM-dd') else null end
		,  to_char(hf.date_created, 'yyyy-MM-dd hh:mm:ss')
		,  to_char(hf.date_updated, 'yyyy-MM-dd hh:mm:ss')
		, lp.ExportID
	from v2020.funder hf
	inner join lsa.lsa_Project lp on lp.ProjectID = cast (hf.projectid as varchar)
	inner join lsa.lsa_Report rpt on cast(lp.ExportID as int) = rpt.ReportID AND rpt.project_group_code=hf.project_group_code
	where hf.deleted is false AND hf.parent_id is null 
		and (hf.enddate is null 
			 or	(hf.enddate >= rpt.ReportStart
				 and hf.enddate > hf.startdate)
			)  ;
/*
	4.4 Get ProjectCoC Records for Export
		ProjectCoC.csv must have exactly one record for each ProjectID in Project.csv
			and the CoCCode must match ReportCoC 
*/

	delete from lsa.lsa_ProjectCoC;
	 
	insert into lsa.lsa_ProjectCoC (
		  ProjectCoCID, ProjectID, CoCCode
		, Geocode
		, Address1, Address2, City, State
		, ZIP, GeographyType 
		, DateCreated, DateUpdated, ExportID
		)
	select hcoc.id, hcoc.projectid, hcoc.coccode
		, hcoc.geo_code
		, left(hcoc.address1, 100), left(hcoc.address2, 100), left(hcoc.city, 50), hcoc.state
		, left(hcoc.zip, 5), cast (cast (hcoc.geography_type as varchar) as integer)
		, to_char(hcoc.date_created::date, 'yyyy-MM-dd hh:mm:ss')
		, to_char(hcoc.date_updated::date, 'yyyy-MM-dd hh:mm:ss')
		, lp.ExportID
	from v2020.coc hcoc
	inner join lsa.lsa_Project lp on lp.ProjectID = cast (hcoc.projectid as varchar)
	inner join lsa.lsa_Report rpt on cast(lp.ExportID as int) = rpt.ReportID AND rpt.project_group_code=hcoc.project_group_code
	where hcoc.deleted is false AND hcoc.parent_id is null
		and hcoc.coccode = rpt.ReportCoC;

/*
	4.5 Get Inventory Records for Export
		Inventory.csv must have at least one record for each ProjectID in Project.csv
			and the CoCCode must match ReportCoC.
*/

	delete from lsa.lsa_Inventory ;

	insert into lsa.lsa_Inventory (
		  InventoryID, ProjectID, CoCCode
		, HouseholdType, Availability
		, UnitInventory, BedInventory
		, CHVetBedInventory, YouthVetBedInventory, VetBedInventory
		, CHYouthBedInventory, YouthBedInventory
		, CHBedInventory, OtherBedInventory
		, ESBedType
		, InventoryStartDate, InventoryEndDate
		, DateCreated, DateUpdated, ExportID)
	select distinct hi.id, hi.projectid, hi.coccode
		, cast(cast (hi.householdtype as varchar) as integer)
		, case when lp.ProjectType = 1 then cast(cast(hi.availabilty as varchar) as integer) else null end 
		, hi.unitinventory, hi.bed_inventory
		, hi.ch_vet_bed_inventory, hi.youth_vet_bed_inventory, hi.vet_bed_inventory
		, hi.ch_youth_bed_inventory, hi.youth_bed_inventory
		, hi.ch_bed_inventory, hi.other_bed_inventory		
		, case when lp.ProjectType = 1 then cast(cast(hi.bedtype as varchar) as integer) else null end
		, to_char(hi.inventorystartdate::date, 'yyyy-MM-dd')
		, case when isdate(cast(hi.inventoryenddate as varchar)) = '1' then to_char(hi.inventoryenddate, 'yyyy-MM-dd') else null end
		, to_char(hi.date_created, 'yyyy-MM-dd HH:mm:ss')
		, to_char(hi.date_updated, 'yyyy-MM-dd HH:mm:ss')
		, lp.ExportID	
	from v2020.inventory hi
	inner join lsa.lsa_Project lp on lp.ProjectID = cast (hi.projectid as varchar)
	inner join lsa.lsa_Report rpt on cast(lp.ExportID as int) = rpt.ReportID AND rpt.project_group_code=hi.project_group_code
	where hi.deleted is false AND hi.parent_id is null 
		and hi.coccode = rpt.ReportCoC
		and (hi.inventoryenddate is null 
			or (hi.inventoryenddate >= rpt.ReportStart
				and hi.inventoryenddate > hi.inventorystartdate)
			);