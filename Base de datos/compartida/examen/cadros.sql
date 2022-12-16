set datestyle = "ISO, DMY";
set datestyle to DMY, SQL;
show datestyle;
drop table if exists pais cascade;
drop table if exists persoas cascade;
drop table if exists pintores cascade;
drop table if exists mecenas cascade;
drop table if exists apoian cascade;
drop table if exists cadros cascade;
drop table if exists pigmentos cascade;
drop table if exists usan cascade;
drop table if exists visitantes  cascade;
drop table if exists museos cascade;
drop table if exists ubican cascade;
drop table if exists visitan cascade;

create table pais (
codpa varchar(4),
nompa varchar(13),
primary key (codpa)
);
insert into pais values('pa0','austria');
insert into pais values('pa1','francia');
insert into pais values('pa2','egipto');
insert into pais values('pa3','vaticano');
insert into pais values('pa4','turquia');
insert into pais values('pa5','belgica');
insert into pais values('pa6','italia');
insert into pais values('pa7','colombia');
insert into pais values('pa8','inglaterra');
insert into pais values('pa9','alemania');
insert into pais values ('pa10','portugal');
insert into pais values ('pa11','espanha');


create table persoas(
codp varchar(3),
nomp varchar (25),
codpa varchar(4),
primary key(codp),
foreign key (codpa) references pais(codpa)
);
insert  into persoas values ('p1','giotto','pa6');
insert  into persoas values ('p2','scrovegni','pa6');
insert  into persoas values ('p3','fouquet',null);
insert  into persoas values ('p4','chevalier','pa1');
insert  into persoas values ('p5','botticelli','pa1');
insert  into persoas values ('p6','lorenzo de medici','pa1');
insert  into persoas values ('p7','leonardo da vinci','pa1');
insert  into persoas values ('p8','sforza','pa1');
insert  into persoas values ('p9','correggio',null);
insert  into persoas values ('p10','mantua','pa1');
insert  into persoas values ('p11','miguel angel','pa1');
insert  into persoas values ('p12','soroya','pa11');

create table pintores (
codp varchar(3),
datan integer,
primary key (codp),
foreign key (codp) references persoas(codp)
);
insert  into pintores values ('p1',1267);
insert  into pintores values ('p3',1420);
insert  into pintores values ('p5',1445);
insert  into pintores values ('p7',1452);
insert  into pintores values ('p9',1489);
insert  into pintores values ('p11',1475);
insert into pintores values('p12',1863);


create table mecenas (
codp varchar(3),
posicion varchar(15),
primary key (codp),
foreign key (codp) references persoas(codp)
);
insert  into mecenas values ('p2','comerciante');
insert  into mecenas values ('p4','tesorero real');
insert  into mecenas values ('p6','estadista');
insert  into mecenas values ('p8','duque');
insert  into mecenas values ('p10','duque');

create table apoian (
codp varchar(3),
codpm varchar(3),
primary key (codp,codpm),
foreign key (codp) references pintores(codp),
foreign key (codpm) references mecenas(codp)
);
insert  into apoian values ('p1','p2');
insert  into apoian values ('p3','p4');
insert  into apoian values ('p5','p6');
insert  into apoian values ('p7','p8');
insert  into apoian values ('p9','p10');
insert  into apoian values ('p11','p6');


create table cadros(
codp varchar(3),
n integer ,
titulo varchar (30),
data integer,
primary key(codp,n),
foreign key (codp) references pintores(codp)
);
insert into cadros values('p1',1,'lamentacion',1300);
insert into cadros values('p3',1,'virxen de melun',1452);
insert into cadros values('p3',2,'retrato de carlos setimo',1445);
insert into cadros values('p5',1,'nacimento de venus',1485);
insert into cadros values('p5',2,'primavera',1482);
insert into cadros values('p7',1,'gioconda',1503);
insert into cadros values('p7',2,'a ultima cea',1498);
insert into cadros values('p7',3,'santa ana coa virxen e o neno ',1503);
insert into cadros values('p9',1,'noli me tangere',1525);
insert into cadros values('p11',1,'boveda capilla sixtina',1512);

create table pigmentos (
codpi varchar(4),
nompi varchar(20),
codpa varchar(4),
primary key (codpi),
foreign key (codpa) references pais(codpa)
);


insert into pigmentos values ('pi1','vermello cadmio','pa1');
insert into pigmentos values ('pi2','azul ultramar','pa6');
insert into pigmentos values ('pi3','azul  prusia','pa9');
insert into pigmentos values ('pi4','azul cobalto','pa6');
insert into pigmentos values ('pi5','verde esmeralda','pa8');
insert into pigmentos values ('pi6','verde cobalto','pa6');
insert into pigmentos values ('pi7','amarelo cadmio','pa8');
insert into pigmentos values ('pi8','amarelo ocre','pa9');
insert into pigmentos values ('pi9','violeta cobalto','pa6');
insert into pigmentos values ('pi10','violeta extrusio',null);
insert into pigmentos values ('pi11','azul rombio',null);


create table usan (
codp varchar(3),
n integer ,
codpi varchar(4),
primary key (codp,n,codpi),
foreign key (codp,n) references cadros(codp,n),
foreign key (codpi) references pigmentos(codpi)
);
insert into usan values('p1',1,'pi1');
insert into usan values('p1',1,'pi8');
insert into usan values('p1',1,'pi9');
insert into usan values('p1',1,'pi6');

insert into usan values('p3',1,'pi2');
insert into usan values('p3',1,'pi3');
insert into usan values('p3',1,'pi5');


insert into usan values('p3',2,'pi1');
insert into usan values('p3',2,'pi2');
insert into usan values('p3',2,'pi3');
insert into usan values('p3',2,'pi5');
insert into usan values('p3',2,'pi8');
insert into usan values('p3',2,'pi9');

insert into usan values('p5',1,'pi1');
insert into usan values('p5',1,'pi4');
insert into usan values('p5',1,'pi3');
insert into usan values('p5',1,'pi5');
insert into usan values('p5',1,'pi7');

insert into usan values('p5',2,'pi3');
insert into usan values('p5',2,'pi4');
insert into usan values('p5',2,'pi5');
insert into usan values('p5',2,'pi7');

insert into usan values('p7',1,'pi2');
insert into usan values('p7',1,'pi4');
insert into usan values('p7',1,'pi8');
insert into usan values('p7',1,'pi9');


create table visitantes (
codpa varchar(4),
n integer ,
nif varchar(4),
nomv varchar(15),
primary key (codpa,n),
foreign key (codpa) references pais(codpa)
);

insert into visitantes values ('pa10',1,'361','luis');
insert into visitantes values ('pa10',2,'362','ana');
insert into visitantes values ('pa10',3,'363','silvia');
insert into visitantes values ('pa1',1,'364','juan');
insert into visitantes values ('pa1',2,'365','pedro');
insert into visitantes values ('pa0',1,'366','beatriz');
insert into visitantes values ('pa0',2,'367','carlos');
insert into visitantes values ('pa0',3,'368','manuel');
insert into visitantes values ('pa2',1,'369','nuria');
insert into visitantes values ('pa2',2,'3610','amanda');
insert into visitantes values ('pa2',3,'3611','lua');
insert into visitantes values ('pa2',4,'3612','jose');
insert into visitantes values ('pa3',1,'3613','benito');
insert into visitantes values ('pa3',2,'3614','josefa');
insert into visitantes values ('pa4',1,'3615','altea');


create table museos (
codm varchar(3),
nomm varchar(30),
codm2 varchar(3),
primary key (codm),
foreign key (codm2) references museos(codm)
);

insert into museos values ('m1','louvre' , null);
insert into museos values ('m2','prado' , null);
insert into museos values ('m3','belas artes amberes' , null);
insert into museos values ('m4','galeria uffizi',null);
insert into museos values ('m5','santa maria de le grazie ',null);
insert into museos values ('m6','capela sixtina',null);
insert into museos values ('m7','capela scrovegni ',null);


create table ubican (
codp varchar(3),
n integer ,
codm varchar(3),
datae date,
datas date,
primary key (codp,n,datae),
foreign key (codp,n) references cadros(codp,n),
foreign key (codm) references museos(codm)
);

insert into ubican values('p1',1, 'm7','1/1/1000',null);
insert into ubican values('p3',1, 'm3','7/3/1995',null);
insert into ubican values('p3',2, 'm1','7/5/1990',null);
insert into ubican values('p5',1, 'm4','4/4/1960',null);
insert into ubican values('p5',2, 'm4','2/10/1870',null);
insert into ubican values('p7',1, 'm1','2/3/1980',null);
insert into ubican values('p7',2, 'm5','1/1/1000',null);
insert into ubican values('p7',3, 'm1','8/12/1995',null);
insert into ubican values('p9',1, 'm2','7/4/2000',null);
insert into ubican values('p11',1, 'm6','1/1/1000',null);

create table visitan (
codpa varchar(4),
n integer ,
codm varchar(3),
datavi date,
prezo integer,
primary key (codpa,n,datavi),
foreign key (codpa,n) references visitantes(codpa,n),
foreign key (codm) references museos(codm)
);
insert into visitan values ('pa10',1,'m1','7/3/2016', 10);
insert into visitan values ('pa10',1,'m2','6/5/2016', 15);
insert into visitan values ('pa10',2,'m1','4/3/2017', 20);
insert into visitan values ('pa1',1,'m1','15/12/2018', 10);
insert into visitan values ('pa1',1,'m4','21/8/2019', 15);
insert into visitan values ('pa0',1,'m1','17/9/2019', 15);
insert into visitan values ('pa10',1,'m1','12/4/2018', 5);
insert into visitan values ('pa0',2,'m1','3/7/2016', 7);
insert into visitan values ('pa2',1,'m1','19/10/2015', 15);
insert into visitan values ('pa0',2,'m1','25/9/2014', 10);
insert into visitan values ('pa3',1,'m6','24/11/2012', 5);
insert into visitan values ('pa0',3,'m6','11/8/2011', 5);
insert into visitan values ('pa1',1,'m6','8/7/2014', 10);
insert into visitan values ('pa3',1,'m4','13/1/2010', 15);
insert into visitan values ('pa2',1,'m6','9/3/2020', 20);

