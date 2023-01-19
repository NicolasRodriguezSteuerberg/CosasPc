CREATE or replace FUNCTION fequxog(nombre varchar)
	RETURNS integer
	LANGUAGE PLPGSQL
   AS
$$
DECLARE
--variable declaration
e varchar;
BEGIN
 --logic

 select count(*) into e from xogador where codequ=nombre; 
 RETURN e;
END;
$$;
CREATE or replace FUNCTION fsalxog(minimo integer, maximo integer)
	RETURNS integer
	LANGUAGE PLPGSQL
    AS
$$  
DECLARE
 --variable declaration
d integer;
BEGIN
 --logic
 select count(*) into d from xogador where salario>=minimo and salario<=maximo;

 
 RETURN d;
END;
$$;

