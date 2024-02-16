drop table if exists produtos cascade;
drop type if exists cida cascade;

--Agrupación de campos en una misma variable--
create type cida as (
    cidade varchar(25),
    cp integer
);
--para describir cida: \d cida--
create table produtos(
    codigo varchar(3),
    descripcion varchar(15),
    prezo numeric(6,2), --numeric(6,2) = 6 digitos de los cuales 2 son decimales--
    ci cida,
    primary key (codigo)
);
--select (ci).cidade from produtos; para poder sacar cidade de ci (tipo cida)--
--update produtos SET ci.cp=36 where (ci).cidade='Vigo'; para un update--
--update produtos SET ci.cp=(ci).cp+1 where (ci).cidade='Vigo';--
