--procedemento pcidadefarmacias tal que pasandolle como parametro o código dunha cidade me diga os nomes das farmacias que se atopan nela 
CREATE or replace procedure pcidadefarmacias(codigo integer)
    LANGUAGE PLPGSQL
    AS
$$
DECLARE
  x varchar;
  y integer;
  fila record;
BEGIN
x='';
   select count(*) into y from cidades where codc=codigo;
   if y=0 then
   	raise exception 'codigo de cidade inexistente';
   	else
	   for fila in select nomf from farmacias where codc=codigo LOOP
   		x = x || E'\n' || fila.nomf;
	   end LOOP;
   end if;
   raise notice '%',x;

end;
$$;
