--triggers que impidan que unha persoa sexa rexistrada    ao mesmo tempo na tabla    'farmaceuticos' e na taboa 'propios'. (so pode estar rexistrada nunha das taboas).
DROP FUNCTION tmeterpropios() CASCADE;
CREATE FUNCTION tmeterpropios()
	RETURNS TRIGGER
	LANGUAGE PLPGSQL
    AS 
$$  
DECLARE
 z integer;
BEGIN
  select count(*) into z from farmaceuticos where dnip=new.dnip;
  if z > 0 then
  	raise exception 'non se pode añadir xa que está en farmaceuticos';
     else
     	 raise notice 'inserción añadida';
  end if;
  return new;
END;
$$;
CREATE TRIGGER tmeterpropiost before INSERT ON propios for each row EXECUTE PROCEDURE tmeterpropios();



DROP FUNCTION tmeterfarmaceuticos() CASCADE;
CREATE FUNCTION tmeterfarmaceuticos()
	RETURNS TRIGGER
	LANGUAGE PLPGSQL
    AS 
$$  
DECLARE
 z integer;
BEGIN
  select count(*) into z from propios where dnip=new.dnip;
  if z > 0 then
  	raise exception 'non se pode añadir xa que está en propios';
     else
     	 raise notice 'inserción añadida';
  end if;
  return new;
END;
$$;
CREATE TRIGGER tmeterfarmaceuticost before INSERT ON farmaceuticos for each row EXECUTE PROCEDURE tmeterfarmaceuticos();
