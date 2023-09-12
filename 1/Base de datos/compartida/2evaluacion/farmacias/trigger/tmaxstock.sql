--trigger chamdo tmaxstock que impida que se poda rexistrar no stock de unha farmacia un medicamento do que xa hai mais de tres unidades en stock (independentemente da sua presentacion)
DROP FUNCTION tmaxstock() CASCADE;
CREATE FUNCTION tmaxstock()
	RETURNS TRIGGER
	LANGUAGE PLPGSQL
    AS 
$$  
DECLARE
  fila record;
  cuenta integer;
BEGIN
cuenta = 0;
  select sum(cantidads) into cuenta from stock where codm=new.codm and codf=new.codf;
  
  if cuenta > 3 then
  	raise exception 'no se pueden tener más cantidades de ese medicamento';
  	else
  		raise notice 'inserción añadida';
  end if;
  return new;
END;
$$;
CREATE TRIGGER tmaxstockt before INSERT ON stock for each row EXECUTE PROCEDURE tmaxstock()
