/* 
1) amosar datos de clientes
select * from cliente;

2) amosar nif e email de cliente ordeados por email
select nif, email from cliente order by email;

3) amosar nome e direcion de clientes da xona 'z1'
select nome, direcion from cliente where codz='z1';

4) amosar nif, nome e telefono dos clientes da zona 'z1' ou que vivan na rua 'r/coruxo'
select nif, nome, telefono from cliente where codz='z1' or direcion='r/coruxo';

5) amosar numero total de clientes 
select count(*) from cliente;

6) amosar nmero total de clientes que non te�an zona asignada
select count(*) from cliente where codz is null;


7) amosar numero total de clientes que  te�an zona asignada

select count(*) from cliente where codz is not null;

select count(codz) from cliente;
 count


-- -- consultas que utilizen funcions bassicas integradas no SXBD


8) amosar suma de totais de pedidos

select sum(total) from pedido;


9) amosar a media dos totais de todos os pedidos

select sum(total)::float/count(*) from pedido;

select avg(coalesce(total,0)) from pedido;


10) amosar suma dos totais dos pedidos do cliente de codigo de nif '361a';

select sum(total) from pedido where nif='361a';


11) amosar media dos totais dos pedidos do cliente cuxo  nif e  '361a';
select avg(coalesce(total,0)) from pedido where nif='361a';

select sum(total)::float/count(*) from pedido where nif='361a';


12) amosar a suma dos totais dos pedidos 'p1' e 'p3'

select sum(total) from pedido where codp='p1' or codp='p3';


13) amosar a suma dos totais dos pedidos 'p1' e 'p15'

select sum(total) from pedido where codp='p1' or codp='p15';


14) amosar nomes de clientes que teñan conta en gmail

select nome from cliente where email like '%gmail%';


15) amosar nif e nome de clientes que te�an unha letra 'a' como segunda letra do seu nome

select nif, nome from cliente where substr(nome,2,1)='a';

16) amosar codigo e nome de productos cuxo prezo supere os 3 euros

select codm,n, nome from produto where prezo>3;


-- -- consultas sobre mais dunha taboa mediante combinacions internas


21) amosar nif e nome de clientes da zona 'centro'

select nif, nome from cliente where codz in(select codz from zona where nomz='centro');


22) amosar nif e nome de clientes da zona centro con correo de hotmail

select nif, nome from cliente where codz in(select codz from zona where nomz='centro') and email like '%hotmail%';


23) amosar codigos de pedidos do cliente de email 'anax@hotmail.com'

select codp from pedido where nif in(select nif from cliente where email='anax@hotmail.com');


24) amosar nomes dos productos da marca 'argal'

select nome from produto where codm in (select codm from marca where nomm='argal'); 


-- -- consultas sobre mais dunha taboa mediante combinacions externas


25)amosar  nif e nome de cliente e nome da zona onde viven:

select nif, nome, nomz from cliente left join zona on cliente.codz=zona.codz;


26)amosar cantos pedidos estan cargados na furgoneta 1 polo repartidor que ten a clave z1,2:

select count(*) from carga where nf='1' and codz='z1' and n='2';


27) amosar o nif e nome dos clientes que fixeron pedidos entre o '7/7/2020' e o '13/7/2020'

select nome, pedido.nif from cliente, pedido where cliente.nif=pedido.nif and data>'7/7/2020' and data<'13/7/2020';


