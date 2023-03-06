/*
Impedir que se poda rexistrar no stock de unha farmacia un    medicamento do que xa hai mais de tres unidades en stock (independentemente da sua presentacion) se ademais esa farmacia esta nuha cidade onde hai polo menos unha farmacia mais.
*/
DROP FUNCTION tpresentacion() CASCADE;
CREATE FUNCTION tpresentacion()
	RETURNS TRIGGER
	LANGUAGE PLPGSQL
    AS 
$$  
DECLARE
  cuenta integer;
  codigo integer;
  cuenta2 integer;
BEGIN
cuenta = 0;
  select sum(cantidads) into cuenta from stock where codm=new.codm;
  select codc into codigo from farmacias where codf=new.codf;
  select count(*) into cuenta2 from farmacias where codc=codigo;
  if cuenta > 3 then
  	if cuenta2 > 1 then
  	  	raise exception 'no se pueden tener más cantidades de ese medicamento';
  			raise notice 'inserción añadida';
  	end if;
  	else
		raise notice 'inserción añadida';
  end if;
  return new;
END;
$$;
CREATE TRIGGER tpresentaciont before INSERT ON stock for each row EXECUTE PROCEDURE tpresentacion();
