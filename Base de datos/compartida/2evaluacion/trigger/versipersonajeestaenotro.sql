/*

insert into klingon values ('p1',null,'pla1');
	personaje en humanos

insert into klingon values ('p2',null,'pla1');
	personaje en vulcanos

insert into klingon values ('p5',null,'pla1');
	insercion aceptada
*/
DROP FUNCTION thumanounico() CASCADE;
CREATE FUNCTION thumanounico()
	RETURNS TRIGGER
	LANGUAGE PLPGSQL
    AS 
$$  
DECLARE
 x integer;
 y varchar;
BEGIN
 select count(codper) into x from vulcanos where codper=new.codper;
 if x > 0 then
 	raise exception E'\nNon se pode añadir xa que está en vulcanos';
    else
    	select count(codper) into x from klingon where codper=new.codper;
    	if x > 0 then
    		raise exception E'\nNon se pode añadir xa que está en klingon';
    	  else
    		raise notice E'\nInserción añadida';
    	end if;
 end if;
 return new;
END;
$$;
CREATE TRIGGER thumanounicot before INSERT ON humanos for each row EXECUTE PROCEDURE thumanounico();


DROP FUNCTION tklingonunico() CASCADE;
CREATE FUNCTION tklingonunico()
	RETURNS TRIGGER
	LANGUAGE PLPGSQL
    AS 
$$  
DECLARE
 x integer;
 y varchar;
BEGIN
 select count(codper) into x from vulcanos where codper=new.codper;
 if x > 0 then
 	raise exception E'\nNon se pode añadir xa que está en vulcanos';
    else
    	select count(codper) into x from humanos where codper=new.codper;
    	if x > 0 then
    		raise exception E'\nNon se pode añadir xa que está en humanos';
    	  else
		raise notice E'\nInserción añadida';
    	end if;
 end if;
 return new;
END;
$$;
CREATE TRIGGER tklingonunicot before INSERT ON klingon for each row EXECUTE PROCEDURE tklingonunico();


DROP FUNCTION tvulcanosunico() CASCADE;
CREATE FUNCTION tvulcanosunico()
	RETURNS TRIGGER
	LANGUAGE PLPGSQL
    AS 
$$  
DECLARE
 x integer;
 y varchar;
BEGIN
 select count(codper) into x from klingon where codper=new.codper;
 if x > 0 then
 	raise exception E'\nNon se pode añadir xa que está en klingon';
    else
    	select count(codper) into x from humanos where codper=new.codper;
    	if x > 0 then
    		raise exception E'\nNon se pode añadir xa que está en humanos';
    	  else
    		 raise notice E'\nInserción añadida';
    	end if;
 end if;
 return new;
END;
$$;
CREATE TRIGGER tvulcanosunicot before INSERT ON vulcanos for each row EXECUTE PROCEDURE tvulcanosunico();


