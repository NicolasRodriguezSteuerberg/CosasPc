CREATE or replace procedure nomeProcedimiento()
    LANGUAGE PLPGSQL
    AS
$$
DECLARE
  x tipoDato;
BEGIN
   --
   raise notice '%',x;

end;
$$;


