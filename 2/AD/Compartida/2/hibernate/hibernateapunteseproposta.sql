/*

Introdución a ORM (Object Relational Mapping) e Hibernate 

https://www2.deloitte.com/es/es/pages/technology/articles/que-es-orm.html

Hibernate apuntes con exemplos claros 
http://www.cursohibernate.es/doku.php?id=unidades:02_hibernate:02_entidad&do=index
dentro do mesmo
http://www.cursohibernate.es/doku.php?id=unidades:02_hibernate:04_usando_hibernate
na mesma web moi bo : mapeo dunha entidade
http://www.cursohibernate.es/doku.php?id=unidades:02_hibernate:02_entidad

Hibernate actualizado pero sen exemplos completos (31-10-2022)

https://docs.jboss.org/hibernate/orm/5.6/quickstart/html_single/#hibernate-gsg-tutorial-basic-test


Seguindo a información que atoparás nos enlaces anteriores desenvolve unha aplicación mínima que insira, modifique e elimine datos dunha taboa .
o script de creacion da taboa para facer as probas pode ser este :
*/
drop table if exists personas;
create table personas(
id numeric,
nombre varchar(32),
apellido varchar(32),
salario numeric,
primary key (id)
)
;
insert into personas values (1,'luis','perez',2000.4);
insert into personas values (2,'ana','suarez',2100.427);
insert into personas values (3,'pedro','aguiño',1500.6123254);




