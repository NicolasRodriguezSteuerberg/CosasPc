CREATE or replace procedure plibros()
    LANGUAGE PLPGSQL
    AS
$$
DECLARE
  x varchar;
  fila record;
  fila2 record;
  cuenta integer;
BEGIN
   x = '';
   for fila in select * from autor LOOP
   	cuenta = 0;
   	x = x || E'\n' || fila.nomea;
   	for fila2 in select titulo,editorial from libro where codautor=fila.codautor LOOP
   		x = x || E'\n\t' || fila2.titulo || '----' || fila2.editorial;
   		cuenta = cuenta + 1;
   	end LOOP;
   	if cuenta > 0 then
	   	x = x || E'\n\ttotal: ' || cuenta;
	   else
	   	x = x || E'\n\tnon dispomos de libros de este autor';
	end if;
   end LOOP;
   raise notice '%',x;

end;
$$;
