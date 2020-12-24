--Populate lsa."ref_Calendar"
CREATE OR REPLACE FUNCTION lsa.dateadd(character varying, integer, date)
RETURNS date AS
$BODY$

DECLARE
p_Interval ALIAS FOR $1;
p_N ALIAS FOR $2;
p_Date ALIAS FOR $3;

BEGIN
if p_Interval = 'm' then
return p_Date + cast(p_N || ' months' as interval);
elseif p_Interval = 'y' then
return p_Date + cast(p_N || ' years' as interval);
elseif p_Interval = 'd' then
return p_Date + cast(p_N || ' days' as interval);

else
raise exception 'dateadd interval parameter not supported';
return null;
end if;
END;
$BODY$
LANGUAGE 'plpgsql';


CREATE OR REPLACE PROCEDURE lsa.populate_ref_calendar()
 LANGUAGE plpgsql
AS $procedure$

	declare
	startDate date default '2012-10-01';
	endDate date default'2022-09-30';
	i int default 0;
	total_days int = DATE_PART('day', endDate::timestamp - startDate::timestamp);
	begin
	
	while (i <= total_days) 
		LOOP
			insert into lsa.ref_Calendar (theDate) select cast(lsa.dateadd('d', i, startDate) as date); 
			i = i + 1;
		end loop;
	
	end;

$procedure$
;

CREATE OR REPLACE FUNCTION lsa.isdate(s varchar) returns boolean as $$
		begin
	perform s::date;
	return true;
	exception when others then
	return false;
	end;
$$ language plpgsql;
