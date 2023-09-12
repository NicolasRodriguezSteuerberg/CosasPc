/*
trigger
tal que cada vez que se insira un xogador na taboa xogador, actualiza o numero de xogadores correspondente ao seu equipo

insert into xogador values('x30','kike','e1',2000,0,null);
*/

DROP FUNCTION tactualizanumx() CASCADE;
CREATE FUNCTION tactualizanumx()
	RETURNS TRIGGER
	LANGUAGE PLPGSQL
    AS 
$$  
DECLARE
 
BEGIN
   update equipo set numx=coalesce(numx,0)+1 where codequ=new.codequ;
 return new;
END;
$$;
CREATE TRIGGER tactualizanumxt before INSERT ON xogador for each row EXECUTE PROCEDURE tactualizanumx();
