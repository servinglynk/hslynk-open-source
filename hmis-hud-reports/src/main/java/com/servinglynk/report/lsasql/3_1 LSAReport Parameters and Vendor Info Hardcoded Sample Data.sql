CREATE OR REPLACE FUNCTION lsa.run_lsa_report_create (IN reportId integer, IN project_group_code varchar)
RETURNS void
 LANGUAGE plpgsql
AS $function$
BEGIN

/*
LSA FY2019 Sample Code

Name:  3_1 LSAReport Parameters and Vendor Info Hardcoded Sample Data.sql

Date:	4/16/2020 -- original
		4/30/2020 -- create two separate scripts from original file (3_1 to 3_6 households and enrollments.sql):
					 - 3_1 LSAReport Parameters and Vendor Info Hardcoded Sample Data.sql
				     - 3_2 to 3_6 HMIS Households and Enrollments.sql
		5/14/2020 -- do not set "ReportDate" -- it is set in 9.3

	3.1 Report Parameters and Metadata

	The hard-coded values here must be replaced with code to accept actual user-entered parameters
	and info specific to the HMIS application.
*/



update v2020.exit set destination = '31'
where  project_group_code  = 'LS0024' and source_system_id in(
'172482',
'172482_25204',
'172482_25205',
'172484',
'172484_25176',
'172484_25177',
'172484_25293',
'172484_25294',
'172484_25295',
'172484_25296',
'172485',
'172486',
'172486_25178',
'172486_25179',
'172487',
'172487_25180',
'172487_25286',
'172496',
'172496_25192',
'172496_25193',
'172496_25239',
'172496_25240',
'172499',
'172499_25212',
'172505',
'172505_25224',
'172506',
'172506_25187',
'172506_25188',
'172506_25189',
'172506_25190',
'172506_25287',
'172506_25288',
'172506_25289',
'172506_25290',
'172506_25291',
'172506_25292',
'172510',
'172510_25279',
'172510_25284',
'172523',
'172523_25260',
'172527',
'172527_25281',
'172527_25282',
'172531',
'172531_25285',
'172532',
'172532_25298',
'172610',
'172610_25350',
'172610_25372',
'172650',
'172650_25388',
'172650_25389',
'172652',
'172652_25393',
'172652_25559',
'172652_25560',
'172699',
'172699_25516',
'172699_25712',
'172699_25713',
'172724',
'172724_25997',
'172770',
'172772',
'172772_26031',
'172783',
'172783_25744',
'172783_25866',
'172804',
'172804_25581',
'172804_25582',
'172804_25870',
'172847',
'172847_25663',
'172847_25890',
'172859',
'172859_25770',
'172859_25771',
'172866',
'172866_25714',
'172866_25715',
'172866_25716',
'172866_25717',
'172866_25718',
'172879',
'172879_25862',
'172879_25863',
'172879_25864',
'172888',
'172888_25779',
'172888_25929',
'172897',
'172897_25936',
'172914',
'172914_25882',
'172914_25883',
'172917',
'172917_25491',
'172917_25895',
'172930',
'172930_25998',
'172930_25999',
'172936',
'172936_26011',
'172936_26012',
'172949',
'172949_25699',
'172949_26056',
'172949_26057',
'172949_26058');


update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4073419'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4073427'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	99	where source_system_id =	'4073431'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4073436'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4073443'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	99	where source_system_id =	'4073445'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	8	where source_system_id =	'4073451'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4073453'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	9	where source_system_id =	'4073457'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4073463'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4073471'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	8	where source_system_id =	'4073479'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	99	where source_system_id =	'4073487'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	99	where source_system_id =	'4073493'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4073494'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	8	where source_system_id =	'4073498'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4073503'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	8	where source_system_id =	'4073509'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4073513'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4073517'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	99	where source_system_id =	'4073521'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4073533'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	9	where source_system_id =	'4073535'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4073541'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	99	where source_system_id =	'4073543'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4073548'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4073561'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	8	where source_system_id =	'4073565'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	99	where source_system_id =	'4073571'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4073575'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4073581'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4073587'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	8	where source_system_id =	'4073591'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4073595'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	99	where source_system_id =	'4073599'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4073603'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	9	where source_system_id =	'4073609'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	8	where source_system_id =	'4073615'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4073620'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4073621'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4073630'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	9	where source_system_id =	'4073636'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4073644'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4073646'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	8	where source_system_id =	'4073654'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	99	where source_system_id =	'4073656'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4073665'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	8	where source_system_id =	'4073669'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4073675'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	99	where source_system_id =	'4073685'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4073687'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	9	where source_system_id =	'4073691'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4073695'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	8	where source_system_id =	'4073701'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4073707'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4073708'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	9	where source_system_id =	'4073712'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	8	where source_system_id =	'4073716'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4073718'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4073730'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4073741'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4073743'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	9	where source_system_id =	'4073749'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	99	where source_system_id =	'4073753'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	8	where source_system_id =	'4073759'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	9	where source_system_id =	'4073761'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4073765'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	8	where source_system_id =	'4073777'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4073783'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4073788'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	99	where source_system_id =	'4073792'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4073799'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	9	where source_system_id =	'4073803'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4073807'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	99	where source_system_id =	'4073811'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4073817'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	8	where source_system_id =	'4073819'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	9	where source_system_id =	'4073823'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4073827'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	8	where source_system_id =	'4073833'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4073834'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4073847'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4073850'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	99	where source_system_id =	'4073852'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	9	where source_system_id =	'4073856'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	8	where source_system_id =	'4073862'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4073868'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	9	where source_system_id =	'4073869'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4073875'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	8	where source_system_id =	'4073883'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4073885'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	99	where source_system_id =	'4073895'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4073897'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4073906'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4073907'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	99	where source_system_id =	'4073911'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	8	where source_system_id =	'4073915'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4073919'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4073922'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	9	where source_system_id =	'4073926'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	8	where source_system_id =	'4073932'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4073936'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4073944'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4073954'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	9	where source_system_id =	'4073956'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4073958'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	99	where source_system_id =	'4073962'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4073970'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	9	where source_system_id =	'4073974'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4073977'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	8	where source_system_id =	'4073982'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4073986'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4073992'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4073997'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4073998'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	9	where source_system_id =	'4074002'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	99	where source_system_id =	'4074005'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	8	where source_system_id =	'4074008'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4074010'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	9	where source_system_id =	'4074011'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4074015'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	8	where source_system_id =	'4074023'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4074024'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4074031'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	99	where source_system_id =	'4074037'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4074046'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	9	where source_system_id =	'4074050'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4074052'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	99	where source_system_id =	'4074054'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	8	where source_system_id =	'4074058'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	9	where source_system_id =	'4074062'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4074064'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	8	where source_system_id =	'4074074'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4074081'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4074086'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	99	where source_system_id =	'4074087'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	9	where source_system_id =	'4074091'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4074097'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	8	where source_system_id =	'4074099'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	99	where source_system_id =	'4074103'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4074107'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4074109'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	9	where source_system_id =	'4074111'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4074114'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4074120'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	8	where source_system_id =	'4074126'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4074129'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	99	where source_system_id =	'4074136'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4074137'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	9	where source_system_id =	'4074146'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	99	where source_system_id =	'4074147'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4074149'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	8	where source_system_id =	'4074154'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	9	where source_system_id =	'4074157'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4074160'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	8	where source_system_id =	'4074168'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4074172'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4074178'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	99	where source_system_id =	'4074183'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4074189'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	9	where source_system_id =	'4074193'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4074196'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	99	where source_system_id =	'4074198'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	8	where source_system_id =	'4074202'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4074204'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	9	where source_system_id =	'4074210'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	8	where source_system_id =	'4074211'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4074223'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	99	where source_system_id =	'4074232'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4074238'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4074242'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	99	where source_system_id =	'4074246'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	9	where source_system_id =	'4074250'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	8	where source_system_id =	'4074256'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4074260'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	8	where source_system_id =	'4074267'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4074271'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4074279'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	99	where source_system_id =	'4074285'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4074291'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	9	where source_system_id =	'4074295'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4074296'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	99	where source_system_id =	'4074300'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4074303'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	9	where source_system_id =	'4074305'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4074313'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	8	where source_system_id =	'4074319'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4074323'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	99	where source_system_id =	'4074339'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4074349'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	9	where source_system_id =	'4074350'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4074353'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	99	where source_system_id =	'4074358'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4074362'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	8	where source_system_id =	'4074365'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4074367'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	8	where source_system_id =	'4074371'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4074379'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	9	where source_system_id =	'4074383'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4074389'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	9	where source_system_id =	'4074392'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4074394'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	99	where source_system_id =	'4074400'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	8	where source_system_id =	'4074401'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4074407'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	9	where source_system_id =	'4074411'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4074412'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	8	where source_system_id =	'4074416'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4074430'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	99	where source_system_id =	'4074432'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4074441'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	9	where source_system_id =	'4074443'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	99	where source_system_id =	'4074447'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	8	where source_system_id =	'4074451'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4074459'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4074472'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4074476'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4074485'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	9	where source_system_id =	'4074489'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4074495'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	99	where source_system_id =	'4074499'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	8	where source_system_id =	'4074501'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4074505'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4074506'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	9	where source_system_id =	'4074510'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	8	where source_system_id =	'4074520'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4074529'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4074531'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4074534'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	99	where source_system_id =	'4074540'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4074546'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	9	where source_system_id =	'4074548'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	8	where source_system_id =	'4074550'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	99	where source_system_id =	'4074555'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4074557'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	9	where source_system_id =	'4074559'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4074565'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4074573'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	8	where source_system_id =	'4074576'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	99	where source_system_id =	'4074586'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4074589'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	9	where source_system_id =	'4074597'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4074599'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4074602'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	9	where source_system_id =	'4074608'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	8	where source_system_id =	'4074610'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	99	where source_system_id =	'4074612'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	8	where source_system_id =	'4074618'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4074620'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4074627'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4074631'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4074644'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	9	where source_system_id =	'4074648'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4074650'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	9	where source_system_id =	'4074657'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4074659'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	8	where source_system_id =	'4074669'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4074671'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4074678'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	99	where source_system_id =	'4074686'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	9	where source_system_id =	'4074692'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4074696'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	99	where source_system_id =	'4074700'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	8	where source_system_id =	'4074704'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	9	where source_system_id =	'4074709'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4074713'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	8	where source_system_id =	'4074718'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4074724'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	99	where source_system_id =	'4074733'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4074737'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	9	where source_system_id =	'4074747'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	99	where source_system_id =	'4074751'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	8	where source_system_id =	'4074755'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4074759'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	9	where source_system_id =	'4074761'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4074763'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4074767'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	8	where source_system_id =	'4074773'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4074779'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	99	where source_system_id =	'4074787'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	9	where source_system_id =	'4074791'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4074793'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4074797'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	99	where source_system_id =	'4074801'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	8	where source_system_id =	'4074807'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	9	where source_system_id =	'4074810'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4074814'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4074820'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	8	where source_system_id =	'4074824'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4074827'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	99	where source_system_id =	'4074840'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4074843'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	9	where source_system_id =	'4074849'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	99	where source_system_id =	'4074854'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4074858'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4074861'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	9	where source_system_id =	'4074863'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4074875'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4074879'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	99	where source_system_id =	'4074883'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4074890'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	9	where source_system_id =	'4074891'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	99	where source_system_id =	'4074899'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4074901'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	9	where source_system_id =	'4074905'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4074917'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4074924'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4074930'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	9	where source_system_id =	'4074932'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4074938'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	99	where source_system_id =	'4074946'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4074948'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	8	where source_system_id =	'4074950'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	9	where source_system_id =	'4074956'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	8	where source_system_id =	'4074966'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4074972'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4074978'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	99	where source_system_id =	'4074982'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4074988'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	99	where source_system_id =	'4074994'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	9	where source_system_id =	'4075000'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	8	where source_system_id =	'4075004'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4075008'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	9	where source_system_id =	'4075014'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	8	where source_system_id =	'4075020'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4075022'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4075031'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	99	where source_system_id =	'4075037'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4075038'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	9	where source_system_id =	'4075040'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	8	where source_system_id =	'4075055'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4075060'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	9	where source_system_id =	'4075064'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4075068'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	8	where source_system_id =	'4075072'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4075080'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4075081'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4075091'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4075093'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	9	where source_system_id =	'4075095'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4075105'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	8	where source_system_id =	'4075107'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	99	where source_system_id =	'4075109'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	9	where source_system_id =	'4075111'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4075114'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	8	where source_system_id =	'4075123'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4075134'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	99	where source_system_id =	'4075136'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	9	where source_system_id =	'4075141'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4075143'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	99	where source_system_id =	'4075144'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	8	where source_system_id =	'4075146'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	9	where source_system_id =	'4075150'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4075152'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4075162'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	8	where source_system_id =	'4075166'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4075174'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	99	where source_system_id =	'4075179'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4075186'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	99	where source_system_id =	'4075188'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	9	where source_system_id =	'4075194'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4075196'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	8	where source_system_id =	'4075199'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4075203'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	9	where source_system_id =	'4075207'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4075210'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	8	where source_system_id =	'4075216'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4075226'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4075232'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4075236'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	9	where source_system_id =	'4075242'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4075245'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	99	where source_system_id =	'4075249'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	8	where source_system_id =	'4075253'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4075255'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4075267'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	9	where source_system_id =	'4075269'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	8	where source_system_id =	'4075275'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4075279'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4075287'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	99	where source_system_id =	'4075288'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4075294'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	9	where source_system_id =	'4075302'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	99	where source_system_id =	'4075308'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4075312'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4075317'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	9	where source_system_id =	'4075319'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4075321'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	8	where source_system_id =	'4075326'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4075331'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4075340'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	99	where source_system_id =	'4075342'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	9	where source_system_id =	'4075348'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4075351'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	8	where source_system_id =	'4075356'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	99	where source_system_id =	'4075358'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4075365'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	9	where source_system_id =	'4075373'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	8	where source_system_id =	'4075375'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4075381'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4075391'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	99	where source_system_id =	'4075393'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	9	where source_system_id =	'4075403'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4075404'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4075405'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	99	where source_system_id =	'4075412'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4075415'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	8	where source_system_id =	'4075419'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	9	where source_system_id =	'4075421'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4075426'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	8	where source_system_id =	'4075428'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4075436'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	99	where source_system_id =	'4075439'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4075445'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	9	where source_system_id =	'4075447'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4075453'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	99	where source_system_id =	'4075457'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	8	where source_system_id =	'4075462'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	9	where source_system_id =	'4075468'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4075471'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4075475'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	8	where source_system_id =	'4075485'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4075487'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	99	where source_system_id =	'4075490'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4075496'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	9	where source_system_id =	'4075501'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4075502'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	99	where source_system_id =	'4075506'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	8	where source_system_id =	'4075512'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4075514'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4075517'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	8	where source_system_id =	'4075526'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4075528'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4075535'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	99	where source_system_id =	'4075536'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4075546'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	9	where source_system_id =	'4075552'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	8	where source_system_id =	'4075557'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	99	where source_system_id =	'4075561'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4075565'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	9	where source_system_id =	'4075569'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4075573'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	8	where source_system_id =	'4075579'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4075585'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4075587'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	99	where source_system_id =	'4075596'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4075601'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	9	where source_system_id =	'4075603'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	99	where source_system_id =	'4075604'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4075606'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	8	where source_system_id =	'4075615'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	9	where source_system_id =	'4075619'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4075623'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4075625'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	8	where source_system_id =	'4075628'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4075636'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4075641'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	9	where source_system_id =	'4075650'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4075652'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4075656'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	8	where source_system_id =	'4075662'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4075667'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	9	where source_system_id =	'4075672'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4075679'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4075681'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4075691'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4075695'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	9	where source_system_id =	'4075697'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	99	where source_system_id =	'4075698'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	9	where source_system_id =	'4075702'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4075706'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4075712'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	8	where source_system_id =	'4075720'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4075726'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4075731'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	9	where source_system_id =	'4075737'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	99	where source_system_id =	'4075743'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4075749'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	99	where source_system_id =	'4075753'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4075756'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4075760'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	9	where source_system_id =	'4075762'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4075769'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4075777'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4075785'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	9	where source_system_id =	'4075790'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	99	where source_system_id =	'4075791'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	8	where source_system_id =	'4075793'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4075799'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	9	where source_system_id =	'4075803'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4075805'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4075812'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	99	where source_system_id =	'4075813'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4075820'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	9	where source_system_id =	'4075825'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4075826'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	99	where source_system_id =	'4075830'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	8	where source_system_id =	'4075834'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4075835'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4075839'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	8	where source_system_id =	'4075845'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4075847'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4075851'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4075866'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	9	where source_system_id =	'4075868'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	99	where source_system_id =	'4075874'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	8	where source_system_id =	'4075876'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4075880'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4075881'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	9	where source_system_id =	'4075886'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4075891'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	8	where source_system_id =	'4075893'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4075901'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4075907'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	99	where source_system_id =	'4075913'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4075920'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	9	where source_system_id =	'4075924'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4075928'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	99	where source_system_id =	'4075932'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	8	where source_system_id =	'4075936'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4075940'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	9	where source_system_id =	'4075944'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4075948'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	8	where source_system_id =	'4075954'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4075958'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4075962'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	99	where source_system_id =	'4075968'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	9	where source_system_id =	'4075975'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4075979'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	99	where source_system_id =	'4075987'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4075992'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	9	where source_system_id =	'4075994'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4075998'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	8	where source_system_id =	'4076008'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4076010'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	99	where source_system_id =	'4076025'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4076026'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4076032'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	9	where source_system_id =	'4076038'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	99	where source_system_id =	'4076040'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4076043'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4076051'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	8	where source_system_id =	'4076056'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4076072'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4076082'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	99	where source_system_id =	'4076084'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	9	where source_system_id =	'4076087'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4076089'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4076097'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4076102'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	8	where source_system_id =	'4076106'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	99	where source_system_id =	'4076113'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4076117'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4076125'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	9	where source_system_id =	'4076130'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4076132'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	8	where source_system_id =	'4076134'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	99	where source_system_id =	'4076136'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	9	where source_system_id =	'4076142'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4076146'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4076150'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4076160'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4076163'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	99	where source_system_id =	'4076167'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4076175'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	9	where source_system_id =	'4076178'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4076182'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	99	where source_system_id =	'4076183'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	8	where source_system_id =	'4076189'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4076194'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4076196'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	8	where source_system_id =	'4076202'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4076207'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	99	where source_system_id =	'4076216'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	9	where source_system_id =	'4076220'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4076222'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4076228'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	99	where source_system_id =	'4076232'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4076234'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	9	where source_system_id =	'4076240'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4076244'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4076249'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	8	where source_system_id =	'4076251'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4076261'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4076266'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	9	where source_system_id =	'4076270'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4076277'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	8	where source_system_id =	'4076281'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4076283'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	99	where source_system_id =	'4076287'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4076290'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	9	where source_system_id =	'4076296'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	8	where source_system_id =	'4076302'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4076304'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	99	where source_system_id =	'4076318'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4076320'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4076327'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	99	where source_system_id =	'4076335'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4076337'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	8	where source_system_id =	'4076341'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4076347'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	8	where source_system_id =	'4076353'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	99	where source_system_id =	'4076362'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4076364'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4076376'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	9	where source_system_id =	'4076377'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4076381'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	99	where source_system_id =	'4076385'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4076389'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	8	where source_system_id =	'4076391'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	9	where source_system_id =	'4076397'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4076401'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	8	where source_system_id =	'4076402'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4076409'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	99	where source_system_id =	'4076417'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4076421'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	9	where source_system_id =	'4076427'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4076431'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4076435'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4076445'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	9	where source_system_id =	'4076447'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4076453'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4076467'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	99	where source_system_id =	'4076473'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	9	where source_system_id =	'4076476'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4076480'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4076486'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4076494'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	9	where source_system_id =	'4076500'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4076506'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	8	where source_system_id =	'4076508'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	8	where source_system_id =	'4076519'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4076521'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4076534'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4076536'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4076544'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	99	where source_system_id =	'4076548'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4076551'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4076554'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	9	where source_system_id =	'4076561'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	8	where source_system_id =	'4076565'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	8	where source_system_id =	'4076569'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4076574'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	99	where source_system_id =	'4076578'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4076582'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	9	where source_system_id =	'4076588'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	8	where source_system_id =	'4076589'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	99	where source_system_id =	'4076593'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4076597'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	9	where source_system_id =	'4076599'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4076605'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	8	where source_system_id =	'4076607'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	99	where source_system_id =	'4076619'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4076621'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4076627'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	9	where source_system_id =	'4076633'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	99	where source_system_id =	'4076635'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4076641'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	8	where source_system_id =	'4076645'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4076648'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	9	where source_system_id =	'4076652'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4076656'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	8	where source_system_id =	'4076664'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4076668'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4076682'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	99	where source_system_id =	'4076686'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4076692'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	9	where source_system_id =	'4076698'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4076700'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4435300'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4435352'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4435915'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4446244'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4451821'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4457234'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4459679'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4461263'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4465541'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4465647'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4470303'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4471089'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4472222'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4472836'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4472840'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4472845'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4472850'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4485189'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4485196'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4486663'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4486733'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4486814'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4486938'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4486960'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4487002'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4487177'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4492073'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4492337'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4517916'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4518609'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4519478'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4519829'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4520515'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4521085'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4521684'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4525395'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	99	where source_system_id =	'4525891'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4526723'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4527021'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4527439'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4527707'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4527749'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4528148'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4528366'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4528383'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4528390'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4528903'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4529732'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4529821'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4530047'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4530722'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4531714'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4531755'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	99	where source_system_id =	'4533084'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	99	where source_system_id =	'4533188'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4534599'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4536766'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4537400'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4537573'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4537868'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4538656'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4539247'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4656383'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4676853'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4677375'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4677767'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4679877'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4680669'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4681124'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4682638'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4684818'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4689223'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4690541'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4691100'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4692600'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4694136'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4694144'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4694413'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4694756'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4694766'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4699225'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4699602'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4699854'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4701610'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4702827'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4703269'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4703565'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4704262'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4704678'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4705033'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4705242'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4706081'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4706229'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4706779'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4707333'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4707517'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4708948'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4709226'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4710445'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4710898'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4711292'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4711539'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	1	where source_system_id =	'4711957'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4712233'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4712800'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4712930'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4713313'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4713521'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	8	where source_system_id =	'4713745'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4714004'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4715646'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	8	where source_system_id =	'4716134'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4716145'	 and project_group_code ='LS0024';
update v2020.domesticviolence set currently_fleeing =	0	where source_system_id =	'4716214'	 and project_group_code ='LS0024';


	update v2020.client set race1='3'
	where project_group_code ='LS0024'
	and source_system_id  in (
	'61961',
	'61970',
	'61997',
	'62005',
	'62008',
	'62016',
	'62023',
	'62032',
	'62044',
	'62048',
	'62054',
	'62069',
	'62070',
	'62072',
	'62080',
	'62087',
	'62093',
	'62096',
	'62103',
	'62108',
	'62114',
	'62125',
	'62130',
	'62134',
	'62151',
	'62155',
	'62169',
	'62174',
	'62203',
	'62206',
	'62215',
	'62239',
	'62246',
	'62253',
	'62263',
	'62299',
	'62308',
	'62322',
	'62324',
	'62327',
	'62333',
	'62336',
	'62340',
	'62358',
	'62373',
	'62380',
	'62384',
	'62391',
	'62396',
	'62398',
	'62409',
	'62420',
	'62424',
	'62434',
	'62436',
	'62439',
	'62449',
	'62467',
	'62469',
	'62473',
	'62475',
	'62486',
	'62488',
	'62489',
	'62510',
	'62523',
	'62537',
	'67580',
	'67709',
	'69576',
	'70585',
	'73399',
	'73612',
	'73628',
	'73681',
	'73763',
	'73819',
	'74187',
	'74388',
	'74649');


	update v2020.enrollment  set monthshomelesspastthreeyears='113'
	where source_system_id  in
	('169151',
	'169145',
	'169576',
	'169654',
	'169573',
	'169879',
	'169943',
	'169787',
	'169657',
	'169528',
	'170345',
	'170148',
	'170397',
	'168994',
	'169952',
	'169752',
	'169772',
	'169299',
	'168883',
	'169989',
	'169976',
	'168878',
	'168978',
	'169813',
	'169326',
	'169205',
	'168922',
	'169021',
	'169095',
	'169294',
	'170390',
	'169319',
	'170102',
	'168890',
	'168900',
	'170117',
	'170124',
	'169427',
	'169419',
	'169782',
	'169168',
	'169362',
	'169384',
	'170158',
	'169382',
	'168914',
	'170246',
	'169763',
	'169480',
	'170093',
	'170323',
	'169409',
	'170276',
	'170319',
	'170362',
	'169212',
	'170083',
	'169452',
	'170359',
	'169207',
	'169558',
	'169577',
	'169846',
	'170289',
	'170342',
	'169293',
	'169825',
	'169853',
	'168910',
	'170337',
	'169408',
	'169516',
	'169980',
	'169831',
	'168988',
	'169814',
	'170137',
	'170347',
	'169568',
	'170101',
	'170105',
	'170112',
	'170116',
	'170248',
	'170389',
	'168915',
	'170199',
	'169291',
	'169830',
	'170208',
	'169542',
	'169571',
	'169742',
	'169527',
	'170177',
	'170038',
	'170292',
	'169367',
	'169378',
	'170109',
	'169111',
	'169585',
	'169603',
	'169998',
	'170028',
	'170054',
	'169161',
	'169496',
	'168869',
	'170021',
	'170344',
	'168901',
	'170343',
	'170399',
	'169344',
	'170058',
	'169137',
	'169238',
	'169920',
	'169591',
	'169661',
	'169080',
	'169424',
	'169432',
	'169487',
	'169287',
	'170164',
	'169678',
	'170076',
	'170084',
	'169995',
	'169248',
	'170327',
	'169927',
	'169170',
	'169187',
	'170329',
	'169302',
	'169833',
	'169584',
	'169898',
	'169934',
	'169974',
	'170046',
	'169872',
	'169334',
	'169866',
	'170335',
	'170064',
	'169975',
	'169629',
	'169618',
	'169640',
	'170271',
	'170281',
	'169476',
	'169493',
	'169652',
	'170091',
	'169515',
	'169694',
	'169713',
	'170126',
	'169642',
	'169619',
	'169676',
	'169750',
	'169662',
	'170252',
	'169631',
	'169687',
	'169761',
	'169760',
	'169753',
	'169959',
	'170048',
	'169892',
	'169730',
	'169738',
	'170044',
	'169736',
	'169741',
	'170086',
	'169665',
	'169993',
	'170377',
	'169893',
	'170173',
	'169895',
	'170145',
	'170406',
	'169942',
	'169955',
	'170227',
	'169954',
	'169982',
	'170284',
	'169102',
	'170403',
	'169788',
	'170114',
	'170127',
	'170181',
	'170235',
	'169724',
	'169790',
	'169894',
	'170188',
	'170193',
	'170213',
	'169486',
	'170217',
	'170328',
	'169079',
	'169055',
	'169599',
	'170001',
	'169160',
	'169922',
	'169348',
	'169929',
	'169524',
	'169881',
	'170169',
	'169349',
	'170138',
	'170303',
	'169549',
	'169182',
	'169310',
	'169518',
	'169049',
	'169252',
	'168885',
	'169210',
	'169000',
	'169163',
	'169439',
	'169284',
	'170017',
	'169709',
	'169290',
	'168905',
	'170192',
	'169366',
	'169148',
	'169090',
	'169845',
	'170309',
	'169202',
	'169732',
	'170006',
	'170357',
	'169936',
	'169822',
	'169193',
	'169274',
	'169292',
	'169301',
	'169499',
	'169273',
	'169823',
	'170035',
	'169450',
	'169268',
	'169305',
	'169712',
	'169912',
	'169887',
	'170016',
	'169121',
	'169746',
	'169548',
	'169462',
	'169764',
	'171786',
	'172478',
	'171798',
	'171804',
	'171821',
	'172483',
	'171827',
	'172485',
	'171836',
	'171836_23868',
	'171836_23869',
	'171985_24251',
	'171841',
	'171841_23880',
	'171841_23881',
	'172490',
	'172490_25183',
	'171852',
	'171852_23911',
	'171852_23912',
	'171852_23913',
	'171852_23914',
	'171862',
	'172494',
	'171862_23948',
	'172494_25191',
	'171786_23727',
	'172478_25194',
	'171786_23728',
	'172478_25195',
	'171871',
	'171798_23752',
	'171798_23753',
	'171798_23754',
	'171873',
	'171877',
	'171884',
	'171887',
	'171804_23771',
	'171804_23772',
	'171975_24233',
	'172504',
	'171904',
	'171905',
	'172511',
	'172511_25219',
	'172504_25225',
	'172504_25226',
	'171904_24066',
	'171884_24010',
	'172518',
	'171887_24015',
	'172520',
	'172518_25251',
	'172518_25252',
	'172518_25253',
	'172518_25254',
	'172518_25255',
	'172518_25256',
	'171939',
	'171871_23973',
	'171877_23983',
	'171877_23984',
	'171877_23985',
	'171821_23822',
	'172483_25264',
	'171960',
	'171904_24067',
	'171905_24068',
	'171971',
	'171971_24220',
	'171971_24221',
	'171971_24222',
	'171971_24223',
	'171971_24224',
	'171827_23846',
	'172485_25283',
	'171905_24069',
	'171975',
	'171981',
	'172532',
	'171983',
	'171983_24249',
	'171985',
	'171985_24252',
	'171985_24253',
	'171985_24254',
	'171988',
	'171988_24266',
	'171981_24245',
	'172532_25298',
	'172550',
	'172552',
	'172556',
	'172561',
	'172561_25304',
	'172494_25307',
	'172572',
	'172550_25315',
	'172574',
	'172799_25318',
	'172478_25319',
	'172576',
	'172577',
	'172578',
	'172578_25322',
	'172579',
	'172591',
	'172591_25328',
	'172552_25349',
	'172614',
	'172615',
	'172628',
	'172632',
	'172638',
	'172643',
	'172645',
	'172655',
	'172679',
	'172556_25420',
	'172693',
	'172698',
	'172698_25429',
	'172645_25438',
	'172645_25441',
	'172679_25444',
	'172715',
	'172724',
	'172591_25460',
	'172576_25462',
	'172576_25463',
	'172655_25464',
	'172478_25476',
	'172550_25486',
	'172550_25487',
	'172759',
	'172759_25495',
	'172763',
	'172632_25539',
	'172763_25540',
	'172632_25544',
	'172715_25546',
	'172786',
	'172786_25548',
	'172789',
	'172789_25551',
	'172789_25552',
	'172789_25553',
	'172791',
	'172799',
	'172800',
	'172759_25574',
	'172811',
	'172816',
	'172816_25608',
	'172615_25619',
	'172791_25627',
	'172791_25628',
	'172834',
	'172556_25636',
	'172763_25649',
	'172638_25666',
	'172638_25667',
	'172579_25672',
	'172550_25703',
	'172638_25751',
	'172886',
	'172886_25767',
	'172799_25781',
	'172890',
	'172890_25782',
	'172861_25787',
	'172861_25788',
	'172628_25808',
	'172912',
	'172912_25874',
	'172572_25905',
	'172927',
	'172927_25944',
	'172574_25995',
	'172724_25997',
	'172643_26001',
	'172643_26002',
	'172643_26003',
	'172643_26004',
	'172643_26005',
	'172556_26015',
	'172577_26064',
	'177420',
	'177799',
	'177918',
	'178505',
	'178506',
	'178510',
	'178565',
	'178566',
	'179076',
	'179085',
	'179133',
	'179134',
	'179137',
	'179285')
	and project_group_code ='LS0024';

delete from lsa.lsa_Report;

insert into lsa.lsa_Report (
		  ReportID			--system-generated unique identifier for report process
		, ReportStart		--user-entered start of report period
		, ReportEnd			--user-entered end of report period
		, ReportCoC			--user-selected HUD Continuum of Care Code
		, SoftwareVendor	--name of vendor
		, SoftwareName		--name of HMIS application
		, VendorContact		--name of vendor contact
		, VendorEmail		--email address of vendor contact
		, LSAScope			--user-selected 1=systemwide, 2=project-focused
		, project_group_code
		)
	select
		  12345
		, '2018-10-01'
		, '2019-9-30'
		, 'XX-500'
		, 'ServingLynk Inc.'
		, 'LSA Online'
		, 'Sandeep'
		, 'sandeep.dolia@gmail.com'
		, 1
		, 'LS0024'
;
