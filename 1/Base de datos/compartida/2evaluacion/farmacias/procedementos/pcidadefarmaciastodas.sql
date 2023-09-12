--procedemento chamdo pcidadefarmaciastodas tal que liste os nomes de todas as cidades e para cada unha delas os nomes de todas as farmacias que se atopan nela
CREATE or replace procedure pcidadefarmaciastodas()
    LANGUAGE PLPGSQL
    AS
$$
DECLARE
  x varchar;
  fila record;
  filax record;
BEGIN
 x='';
   for fila in select codc, nomc from cidades LOOP
   	x = x || E'\n' || fila.nomc;
   	for filax in select nomf from farmacias where codc=fila.codc LOOP
   		x = x || E'\n\t' || filax.nomf;
   	end LOOP;
   end LOOP;
   raise notice '%',x;

end;
$$;
