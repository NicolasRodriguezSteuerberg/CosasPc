DROP FUNCTION trixe() CASCADE;
CREATE FUNCTION trixe()
	RETURNS TRIGGER
	LANGUAGE PLPGSQL
    AS 
$$  
DECLARE
  fila record;
  cuenta integer;
  bandera integer;
BEGIN
bandera=0;
  for fila in select nomea from area where nomed=new.nomed LOOP
  	select count(*) into cuenta from profesor where nomea=fila.nomea and nsocio=new.nsocio;
  	if cuenta !=0 then
  		bandera=1;
  	end if;
  end LOOP;
  if bandera=1 then
  	raise notice 'rexistro inserido';
     else
     	raise exception 'o profesor non traballa en ningunha area do departamento';
  end if;
  return new;
END;
$$;
CREATE TRIGGER trixet before INSERT ON dirixe for each row EXECUTE PROCEDURE trixe();
