/*
pnaveslan.sql
decir si ou non unha nave cuxo nome se pasa como parametro , ten capacidade para levar a toda a sua tripulacion dunha vez nas lanzaderas de que dispon.
call pnaveslan('voyager');

resultado:= 'a nave pode levar a todos os seus tripulantes no conxunto das suas lanzqderas';


call pnaveslan('enterprise');
a nave non pode levar a todos os seus tripulantes no conxunto das suas
lanzaderas
*/
CREATE or replace procedure pnaveslan(nome varchar)
    LANGUAGE PLPGSQL
    AS
$$
DECLARE
  x varchar;
  fila record;
  suma integer;
  filax record;
  filay record;
BEGIN
x = '';
suma = 0;
   select codn, nomen, tripul into STRICT fila from naves where nome=nomen;
   x = x || fila.nomen;

   for filax in select codn, numero, capacidade from lanzaderas where codn=fila.codn LOOP
   	for filay numero
   	suma = suma + filax.capacidade;
   end LOOP;
   
   if suma>fila.tripul then
   	x = x || ' a nave pode levar a todos os tripulantes no conxunto das súas lanzaderas';
     else
       x = x || ' a nave non pode levar a todos os seus tripulantes no conxunto das suaslanzaderas';
   end if;
   
 exception
   when no_data_found then
	x = x || nome || ' no existe';
	
   raise notice '%', x;

end;
$$;
