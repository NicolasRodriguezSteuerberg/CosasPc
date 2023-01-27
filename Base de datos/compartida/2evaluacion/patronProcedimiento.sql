CREATE or replace procedure nomeProcedimiento (...)
    LANGUAGE PLPGSQL
    AS
$$
DECLARE
  x tipoDato;
BEGIN
   --
   raise_notice 'o salario do xogador de codigo % é %', codigo,x;

end;
$$;


