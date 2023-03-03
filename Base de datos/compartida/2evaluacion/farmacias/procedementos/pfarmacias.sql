--procedemento chamado pfarmacias que liste os nomes de todas as farmacias
CREATE or replace procedure pfarmacias()
    LANGUAGE PLPGSQL
    AS
$$
DECLARE
  fila record;
  x varchar;
BEGIN
   x = '';
   for fila in select nomf from farmacias LOOP
   	x = x || E'\n' || fila.nomf;
   end LOOP;
   raise notice '%',x;

end;
$$;
