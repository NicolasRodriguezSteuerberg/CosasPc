/*
thorasmaxs

impedir que un mismo actor interprete mas de 500 horas en un misma serie

insert into interpretesser values ('a18','p1','s3',1);
	insercion rechadaza, este actor non pode traballar máis de 500 horas realizadas na serie s3
	
insert into interpretesser values('a12','p1','s3',101);
	insercion rechadaza, este actor non pode traballar máis de 500 horas realizadas na serie s3
	
insert into interpretesser values('a12','p1','s3',100);
	insercion añadida
*/

DROP FUNCTION thorasmaxs() CASCADE;
CREATE FUNCTION thorasmaxs()
	RETURNS TRIGGER
	LANGUAGE PLPGSQL
    AS 
$$  
DECLARE
 cuenta integer;
BEGIN
  select sum(coalesce(horas,0))+coalesce(new.horas,0) into cuenta from interpretesser where coda=new.coda and cods=new.cods;
  cuenta = cuenta + coalesce(new.horas,0);
  if cuenta <= 500 then
  	raise notice 'inserción añadida';
	else
	   raise exception 'inserción fallida, este actor no puede traballar máis de 500 horas en la serie %',new.cods;
  end if;
  return new;
END;
$$;
CREATE TRIGGER thorasmaxst before INSERT ON interpretesser for each row EXECUTE PROCEDURE thorasmaxs();
