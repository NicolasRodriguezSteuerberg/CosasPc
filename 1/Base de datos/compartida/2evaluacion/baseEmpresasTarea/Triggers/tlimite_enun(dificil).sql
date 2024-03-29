/*
tlimite
valor : 2'5 puntos
trigger que rexeite  entrevistar a unha persoa para un posto si xa se lle fixeron 2 ou mais entrevistas para outros postos xestionados polo mesmo  xestor que o do posto o que se presenta. 

ex:  insert into entrevista values('p16',5,'f','f');
ERROR:  non podes entrevistar a esta persoa para dito posto pois xa se lle fixeron 2 entrevistas para outros postos xestionados polo mesmo  xestor que o do posto o que se presenta

insert into entrevista values('p55',12,'f','f');
non existe a persoa ou o posto

insert into entrevista values('p12',55,'f','f');
non existe a persoa ou o posto


ex: insert into entrevista values('p12',5,'f','f');
NOTICE:   entrevista aceptada pois a persoa non tiña todavia duas  entrevistas co mesmo xestor deste posto
*/
DROP FUNCTION tlimite() CASCADE;
CREATE FUNCTION tlimite()
	RETURNS TRIGGER
	LANGUAGE PLPGSQL
    AS 
$$  
DECLARE
 t integer;
 w integer;
 y varchar;
 cuenta integer;
 fila record;
 z varchar;
BEGIN
  select count(cod_posto) into t from postos where cod_posto=new.cod_posto;
  select count(num_persoa) into w from persoas where num_persoa=new.num_persoa;
   if t=0 or w=0 then
   	  raise exception 'non existe a persoa ou o posto';
      else
          cuenta = 0;
   	  select cod_xestor into y from postos where cod_posto=new.cod_posto;
   	  for fila in select cod_posto from entrevista where num_persoa=new.num_persoa LOOP
		select cod_xestor into z from postos where cod_posto=fila.cod_posto;
			if y=z then
				cuenta = cuenta + 1;
			end if;
	  end LOOP;
		if cuenta>1 then
			raise exception 'non podes entrevistar a esta persoa para dito posto pois xa se lle fixeron 2 entrevistas para outros postos xestionados polo mesmo  xestor que o do posto o que se presenta';	 
		    else
		        raise notice 'entrevista aceptada pois a persoa non tiña todavia duas  entrevistas co mesmo xestor deste posto';
		end if;
   end if;
  return new;
END;
$$;
CREATE TRIGGER tlimitet before INSERT ON entrevista for each row EXECUTE PROCEDURE tlimite();
