DROP FUNCTION tx() CASCADE;
CREATE FUNCTION tx()
	RETURNS TRIGGER
	LANGUAGE PLPGSQL
    AS 
$$  
DECLARE

BEGIN


END;
$$;
CREATE TRIGGER txt before INSERT ON tabla for each row EXECUTE PROCEDURE tx();