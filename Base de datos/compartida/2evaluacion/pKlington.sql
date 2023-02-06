/*
18 procedemento pklingon
procedemento que devolva todos os titulos da peliculas e para cada una delas os nomes dos personaxes klingon que interveñen nela
*/
CREATE or replace procedure pklingon()
    LANGUAGE PLPGSQL
    AS
$$
DECLARE
  x varchar;
  tabla record;
  tablax record;
  tablaz record;
  tablay record;
  num integer;
BEGIN
 x = '';
 for tabla in select titulo, codpel from peliculas LOOP
	num = 0;
   	x = x || E'\n' ||tabla.titulo;
   	for tablax in select codpel,codper from interpretespel where codpel=tabla.codpel LOOP
   		for tablaz in select codper from klingon where codper=tablax.codper LOOP
			num = num + 1;
	   		select nomper into tablay from personaxes where codper=tablaz.codper;
	   		x = x || E'\n\t' || tablay.nomper;
	   	end LOOP;
   	end LOOP;
   	if num = 0 then
   		x = x || E'\n\t' || 'Non teñen personaxes klingon';
   	end if;
   	
 end LOOP;
   
 raise notice '%',x;

end;
$$;

