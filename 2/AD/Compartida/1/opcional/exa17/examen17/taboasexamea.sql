drop table if exists vendas cascade ;
drop table if exists clientes cascade ;
drop table if exists produtos cascade ;


create table produtos(codigop varchar(3),nomep varchar(15),prezo integer,stock integer, primary key (codigop));
insert into produtos values ('p1','tornillos',10,1000);
insert into produtos values ('p2','arandelas',20,500);
insert into produtos values ('p3','tuercas',30,100);



create table clientes(codigoc varchar(3),nomec varchar(15),direc varchar(15),gasto integer, primary key (codigoc));
insert into clientes values ('c1','juan','r/burgos',0);
insert into clientes values ('c2','ana','r/urzaiz',0);
insert into clientes values ('c3','luis','r/faisan',0);


create table vendas(codigoc varchar(3),codigop varchar(3), data varchar(10), total integer,  primary key (codigoc,codigop,data),foreign key (codigop) references produtos(codigop), foreign key (codigoc) references clientes(codigoc) );

select * from clientes;
select * from produtos;
select * from vendas;


