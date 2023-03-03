--trigger chamdo tmaxstock que impida que se poda rexistrar no stock de unha farmacia un medicamento do que xa hai mais de tres unidades en stock (independentemente da sua presentacion)
DROP FUNCTION tmaxstock() CASCADE;
CREATE FUNCTION tmaxstock()
	RETURNS TRIGGER
	LANGUAGE PLPGSQL
    AS 
$$  
DECLARE

BEGIN

  return new;
END;
$$;
CREATE TRIGGER tmaxstockt before INSERT ON tabla for each row EXECUTE PROCEDURE tmaxstock()
