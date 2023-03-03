--procedemento pfarmacianome tal que pasandolle como parámetro o código dunha farmacia amose o seu nome
CREATE or replace procedure pfarmacianome(codigo integer)
    LANGUAGE PLPGSQL
    AS
$$
DECLARE
  x varchar;
BEGIN
   select nomf into x from farmacias where codf=codigo;
   raise notice E'\n%',x;

end;
$$;
