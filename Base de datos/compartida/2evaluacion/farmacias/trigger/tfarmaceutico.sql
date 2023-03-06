/*
impedir que nunha mesma farmacia traballe mais dun farmaceutico, a menos que o novo farmaceutico sexa da mesma cidade na que esté a farmacia
*/
DROP FUNCTION tfarmaceutico() CASCADE;
CREATE FUNCTION tfarmaceutico()
	RETURNS TRIGGER
	LANGUAGE PLPGSQL
    AS 
$$  
DECLARE
 cuenta integer;
 x integer;
 y integer;
BEGIN
  select count(*) into cuenta from traballan where codf=new.codf;
  if cuenta >=1 then
  	select codc into x from farmacias where codf=new.codf;
  	select codc into y from farmaceuticos where dnip=new.dnip;
  	if x=y then
  		raise notice 'inserción añadida';
  		else
  			raise exception 'ese farmaceutico non pode trabajar nesa farmacia';
  	end if;
  	else
  	    raise notice 'inserción añadida';
  end if;
  return new;
END;
$$;
CREATE TRIGGER tfarmaceuticot before INSERT ON traballan for each row EXECUTE PROCEDURE tfarmaceutico();
