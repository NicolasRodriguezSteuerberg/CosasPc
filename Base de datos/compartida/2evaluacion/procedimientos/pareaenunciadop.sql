/*
parea
procedemento que liste os codigos de todas as areas e para cada codigo de area os nomes dos asegurados de dita area xunto co numero total deles.
Se un area non ten asegurados debe imprimirse a mensaxe: area sen asegurados:

puntuacion:
amosar codigos de area: .5
amosar nomes de asegurados: 1
amosar numero total de asegurados: .25
amosar 'area sen asegurados' : .25 
call parea();

codigo de area: a1
luis
ana
numero de asegurados: 2
codigo de area: a2
pedro
juan
carlos
numero de asegurados: 3
codigo de area: a3
bieito
numero de asegurados: 1
codigo de area: a4
xoan
eva
comba
ainara
numero de asegurados: 4
codigo de area: a5
dorotea
elisa
amalia
dolores
maria
xose
andrea
iria
antia
xana
numero de asegurados: 10
codigo de area: a6
area  sen asegurados
codigo de area: a7
jose
numero de asegurados: 1
*/

CREATE or replace procedure parea()
    LANGUAGE PLPGSQL
    AS
$$
DECLARE
  x varchar;
  fila record;
  filay record;
  z integer;
BEGIN
   x = '';
   for fila in select coda from area LOOP
   z = 0;
   x = x || E'\nCódigo de area: ' || fila.coda;
   	for filay in select nomas from asegurado where coda = fila.coda LOOP
   		z = z+1;
   		x = x || E'\n\t' || filay.nomas;
   	end LOOP;
   	if z=0 then
   		x = x || E'\n   ' || 'area sen asegurados';
           else
	   	x = x || E'\n   ' || 'numero de asegurados: ' || z;
	end if;	
   end LOOP;
   raise notice '%',x;

end;
$$;
