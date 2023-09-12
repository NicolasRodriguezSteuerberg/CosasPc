create or replace procedure phcamas(ncamas integer)
	language plpgsql
	as
$$
declare
r varchar;
fila record;
fila2 record;
nomAseg varchar;
m integer;
m2 integer;
begin
r = E'\n';
m=0;
m2=0;

for fila in select * from hospital where codh in (select codh from propio) and numc>ncamas loop
	r=r||'nombreh: '||fila.nomh||E'\n';
	m = 1;
		m2=0;
		for fila2 in select * from hosp1 where codh = fila.codh loop
			m2=m2 +1;	

				select nomas into nomAseg from asegurado where codp = fila2.codp and numas = fila2.numas;

					r=r||'nombreASEG:  '||nomAseg||E'\n';



		end loop;
		
		if m2 = 0 then
		r=r||E'\t'||'hospital sen hospitalizados'||E'\n';
		else
		r=r||'el numero de hospitalizads es: '||m2||E'\n';


		end if;


end loop;
	
	if m = 0 then
		r=r||'ningun hospital propio supera ese numero de camas';

	end if;
	

raise notice '%',r;
end;
$$
;