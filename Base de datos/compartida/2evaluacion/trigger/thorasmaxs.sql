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
  select count(horas) into cuenta from interpretesser where coda=new.coda and c
  return new;
END;
$$;
CREATE TRIGGER thorasmaxst before INSERT ON interpretesser for each row EXECUTE PROCEDURE thorasmaxst();
