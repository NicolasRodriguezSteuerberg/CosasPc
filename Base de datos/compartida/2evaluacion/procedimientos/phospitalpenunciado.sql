CREATE or replace procedure phospitalp(nome varchar)
    LANGUAGE PLPGSQL
    AS
$$
DECLARE
  x varchar;
  fila record;
  filay record;
  filaz record;
  z integer;
BEGIN
   x = '';
   select codh into STRICT fila from hospital where nomh=nome;
   x = x || E'\n' || nome;
   z = 0;
   for filay in select codp,numas from hosp2 where codh=fila.codh LOOP
   	z = 1;
   	for filaz in select nomas from asegurado where codp=filay.codp and numas=filay.numas LOOP
   		x = x || E'\n\t' || nomas;
   	end LOOP;
   end LOOP;
   if z=0 then
   	x = x || E'\n\t' || 'no tiene asegurados';
   end if;
   raise notice '%',x;
   
   exception
      when no_data_found then
      x = x || 'este hospital no existe';
      raise notice '%',x;
      
end;
$$;
