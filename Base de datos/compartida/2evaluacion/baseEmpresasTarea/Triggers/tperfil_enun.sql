/*
tperfil:
realizar un trigger  chamado tperfil que comprobe que cando se entrevista a unha persona para un posto , dita persoa ten o mesmo perfil que corresponde o puesto.
Cando o perfil do posto e persona coincidan debe realizarse a insercion lanzandose a mensaje : entrevista insertada perfiles coincidentes. Si o perfil de posto e persona non coinciden a mensaxe debe ser : perfiles de posto e persoa non coincidentes.
insert into entrevista values('p14',14,'f','f');
ERROR:  perfiles de posto e persoa non coincidentes

insert into entrevista values('p14',15,'f','f');
NOTICE:   entrevista insertada perfiles coincidentes

*/

