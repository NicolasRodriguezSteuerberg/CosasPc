--procedemento chamado pfarmaciascidades que liste os nomes de todasa as farmacias e o nome da cidade onde se atopan
CREATE or replace procedure pfarmaciascidades()
    LANGUAGE PLPGSQL
    AS
$$
DECLARE
  fila record;
  filax varchar;
  x varchar;
BEGIN
x='';
   for fila in select nomf, codc from farmacias LOOP
   	select nomc into filax from cidades where codc=fila.codc;
   	x = x || E'\n' || fila.nomf || E'\n\t' || filax;
   end LOOP;
   raise notice '%',x;

end;
$$;
