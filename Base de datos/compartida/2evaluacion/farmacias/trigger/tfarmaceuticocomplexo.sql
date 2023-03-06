/*
impedir que nunha mesma farmacia traballe mais dun farmaceutico, a menos que o novo farmaceutico sexa da mesma cidade na que esta a a farmacia
*/
DROP FUNCTION tfarmaceuticocomplexo() CASCADE;
CREATE FUNCTION tfarmaceuticocomplexo()
	RETURNS TRIGGER
	LANGUAGE PLPGSQL
    AS 
$$  
DECLARE
 x integer;
 y integer;
 z integer;
BEGIN
  select count(*) into x from traballan where codf=new.codf;
  select codc into y from farmacias where codf=new.codf;
  select codc into z from farmaceuticos where dnip=new.dnip;
  if x=0 then
	  raise notice 'inserción añadida';
    else
  	if y=z then
	  	raise notice 'inserción añadida';
	  else 
  		raise exception 'inserción denegada';
  	end if;
  end if;
  return new;
END;
$$;
CREATE TRIGGER tfarmaceuticocomplexot before INSERT ON traballan for each row EXECUTE PROCEDURE tfarmaceuticocomplexo();
