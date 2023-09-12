CREATE or replace procedure ptitulos(nombreT varchar)
    LANGUAGE PLPGSQL
    AS
$$
DECLARE
  x varchar;
  codigoL varchar;
  fila record;
  cuenta integer;
BEGIN
x = '';
cuenta = 0;
   select clibro into STRICT codigoL from libro where titulo=nombreT;
   x = x || E'\ncodigo do libro: ' || codigoL;
   
   for fila in select clibro,numeroe from exemplar where clibro=codigoL LOOP
   	x = x || E'\n\t' || fila.clibro || ',' ||fila.numeroe;
   	cuenta = cuenta +1;
   end LOOP;
   
   if cuenta = 0 then
   	x = x || E'\n\tLibro sin exemplares';
      else
      	x = x || E'\n\tTotal dos exemplares: ' || cuenta;
   end if; 
   	
   raise notice '%',x;

   exception
   	when no_data_found then
   		raise notice 'libro inexistente';
end;
$$;
