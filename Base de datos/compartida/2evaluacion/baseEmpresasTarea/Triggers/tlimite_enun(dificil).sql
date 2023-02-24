/*
tlimite
valor : 2'5 puntos
trigger que rexeite  entrevistar a unha persoa para un posto si xa se lle fixeron 2 ou mais entrevistas para outros postos xestionados polo mesmo  xestor que o do posto o que se presenta. 

ex:  insert into entrevista values('p16',5,'f','f');
ERROR:  non podes entrevistar a esta persoa para dito posto pois xa se lle fixeron 2 entrevistas para outros postos xestionados polo mesmo  xestor que o do posto o que se presenta

insert into entrevista values('p55',12,'f','f');
non existe a persoa ou o posto

insert into entrevista values('p12',55,'f','f');
non existe a persoa ou o posto


ex: insert into entrevista values('p12',5,'f','f');
NOTICE:   entrevista aceptada pois a persoa non tiña todavia duas  entrevistas co mesmo xestor deste posto


*/
