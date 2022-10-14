drop table if exists partido cascade;
drop table if exists estadio cascade;
drop table if exists xogador cascade;
drop table if exists equipo cascade;

create table equipo(
CODEQU varchar(3),
NOMEQU varchar(17),
NUMX integer,
primary key (CODEQU)
);
create table xogador(
CODX varchar(3),
NOMX varchar(11),
CODEQU varchar(3),
SALARIO integer,
COMISION integer,
DATAN date,
primary key (CODX),
foreign key (CODEQU) references equipo(CODEQU)
);
create table estadio(
CODEST varchar(3),
NOMEST varchar(11),
primary key (CODEST)
);
create table partido(
CODPAR varchar(3),
NOMPAR varchar(21),
DATA date,
CODEST varchar(3),
primary key (CODPAR),
foreign key (CODEST) references estadio(CODEST)
);
create table colexiado(
CODC varchar(3),
NOMC varchar(11),
primary key (CODC)
);
create table interven(
CODC varchar(3),
CODPAR varchar(3),
FUNCION integer,
primary key (CODC, CODPAR),
foreign key (CODC) references colexiado(CODC),
foreign key (CODPAR) references partido(CODPAR)
);
create table xogar(
CODX varchar(3),
CODPAR varchar(3),
POSTO integer,
GOLES integer,
primary key (CODX, CODPAR),
foreign key (CODX) references xogador(CODX),
foreign key (CODPAR) references partido(CODPAR)
);
create table adestrar(
CODEQU varchar(3),
ANO integer,
CODEST varchar(3),
primary key (CODEQU, ANO),
foreign key (CODEQU) references equipo(CODEQU),
foreign key (CODEST) references estadio(CODEST)
);
