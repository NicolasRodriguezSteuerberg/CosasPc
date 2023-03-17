/*
impedir que nunha mesma farmacia traballe mais dun farmaceutico, a menos que o novo farmaceutico sexa da mesma cidade na que esta a a farmacia
insercion 1
  insert into traballan values(10,3611);
  propio añadido
insercion 2
  insert into traballan values(9,3610);
  primer farmaceutico en la farmacia
insercion 3
  insert into traballan values(10,3640);
  farmaceutico mesma ciudad
insercion 4
  insert into traballan values(7,3680);
  insercion denegada

*/
DROP FUNCTION tfarmaceuticocomplexo() CASCADE;
CREATE FUNCTION tfarmaceuticocomplexo()
	RETURNS TRIGGER
	LANGUAGE PLPGSQL
    AS 
$$  
DECLARE
 x integer;
 y integer;
 z integer;
 j integer;
 fila record;
 contador integer;
BEGIN
contador = 0;
  select count(*) into j from farmaceuticos where dnip=new.dnip;
    if j = 0 then
	raise notice 'propio añadido';
      else
      for fila in select dnip from farmaceuticos LOOP
	  select count(*) into x from traballan where codf=new.codf and dnip=fila.dnip;
	  if x >0 then
	  	contador = contador + 1;
	  end if;
      end LOOP;
      
	  select codc into y from farmacias where codf=new.codf;
	  select codc into z from farmaceuticos where dnip=new.dnip;
	  
	  if contador=0 then
		  raise notice 'inserción añadida, 1 farmaceutico en la farmacia';
	    else
	  	if y=z then
		  	raise notice 'inserción añadida, misma ciudad';
		  else 
	  		raise exception 'inserción denegada';
	  	end if;
	  end if;
     end if;  
  return new;
END;
$$;
CREATE TRIGGER tfarmaceuticocomplexot before INSERT ON traballan for each row EXECUTE PROCEDURE tfarmaceuticocomplexo();
