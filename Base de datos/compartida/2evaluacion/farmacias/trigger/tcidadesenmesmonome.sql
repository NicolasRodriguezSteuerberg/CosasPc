--trigger que impida rexistrar dúas cidades co mesmo nome.
DROP FUNCTION tcidadesenmesmonome() CASCADE;
CREATE FUNCTION tcidadesenmesmonome()
	RETURNS TRIGGER
	LANGUAGE PLPGSQL
    AS 
$$  
DECLARE
 x integer;
BEGIN
  select count(*) into x from cidades where nomc=new.nomc;
  if x > 0 then
  	raise exception 'non se poden ter cidades co mesmo nome';
  	else
  		raise notice 'cidade insertada';
  end if;
  return new;
END;
$$;
CREATE TRIGGER tcidadesenmesmonomet before INSERT ON cidades for each row EXECUTE PROCEDURE tcidadesenmesmonome();
