set datestyle = "ISO, DMY";
set datestyle to DMY, SQL;
drop table if exists producion cascade;
drop table if exists prezoskilo cascade;
drop type if exists public.arbores ;
create type public.arbores as (
nomea varchar(15),
numa numeric(5)
);

create  table producion (
codf varchar(3),
arbol arbores,
primary key (codf)
);
insert into producion  values('f1',('maceira',1500));
insert into producion  values('f2',('pereira',2000));
insert into producion  values('f3',('laranxeira',1550));
insert into producion  values('f4',('ameixeira',3000));
insert into producion  values('f5',('cerdeira',2500));
insert into producion  values('f6',('figueira',1560));
insert into producion  values('f7',('nispereiro',900));
insert into producion  values('f8',('figueira',1260));
insert into producion  values('f9',('nispereiro',700));

create  table prezoskilo (
nomear varchar(15),
prezok numeric(3,2),
primary key (nomear)
);

insert into prezoskilo values('figueira',1.25);
insert into prezoskilo values('nispereiro',1.50);
insert into prezoskilo values('cerdeira',2);
insert into prezoskilo values('maceira',0.80);
insert into prezoskilo values('laranxeira',0.90);
insert into prezoskilo values('pereira',1.2);
insert into prezoskilo values('ameixeira',1.7);







