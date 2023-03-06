/*
que impida que nunha mesma farmacia traballe mais dun farmaceutico
 */
 
 DROP FUNCTION tfarmaceuticosimple() CASCADE;
CREATE FUNCTION tfarmaceuticosimple()
	RETURNS TRIGGER
	LANGUAGE PLPGSQL
    AS 
$$  
DECLARE
 x integer;
BEGIN
  select count(*) into x from traballan where codf=new.codf;
  if x=0 then
  	raise notice 'inserción añadida';
  	else
  		raise exception 'non poden traballar máis de un farmaceutico por farmacia';
  end if;
  return new;
END;
$$;
CREATE TRIGGER tfarmaceuticosimplet before INSERT ON traballan for each row EXECUTE PROCEDURE tfarmaceuticosimple();
