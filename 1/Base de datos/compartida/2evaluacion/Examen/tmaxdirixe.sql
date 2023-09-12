DROP FUNCTION tmaxdirixe() CASCADE;
CREATE FUNCTION tmaxdirixe()
	RETURNS TRIGGER
	LANGUAGE PLPGSQL
    AS 
$$  
DECLARE
  cuenta integer;
BEGIN
  select count(*) into cuenta from dirixe where nsocio=new.nsocio;
  
  if cuenta >=2 then
  	raise exception 'o profesor non debe dirixir mais de dous departamentos, insercion rexeitada';
     else
     	raise notice 'rexistro inserido';
  end if;
  return new;
END;
$$;
CREATE TRIGGER tmaxdirixet before INSERT ON dirixe for each row EXECUTE PROCEDURE tmaxdirixe();
