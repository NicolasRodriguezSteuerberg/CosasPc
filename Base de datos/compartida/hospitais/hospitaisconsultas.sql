 'c1) Amosar nomes de hospitais que tenhan mais de 100 camas' 

select nomh from hospital where numc>100;


'c2) Amosar nomes de hospitais  concertados que tenhan mais de 100 camas' 

select nomh from hospital,concertado where hospital.codh=concertado.codh and numc>100;

select nomh from hospital where codh in (select codh from concertado) and numc>100;


'c3 )amosar cantos asegurados hay en cada poliza ' 

select codp,count(*) from asegurado group by codp order by to_number(codp,'099');


 'c4 )amosar nomes de asegurados que tenhan una letra -e- ou unha letra -o- no seu nome ' 

select nomas from asegurado where nomas like '%e%' or nomas like '%o%' order by nomas;


 'c5 )amosar codigo e nome  dos medicos que non hospitalizaron  a ningun asegurado de ningunha das categorias existentes ' 

select codm,nomm from medico where codm not in (select codm from hosp1) and codm not in (select codm from hosp2);


 'c6 )amosar para todos e cada un dos codigos de areas existentes  cantas medicos tenhen  adscritos ' 

select area.coda,count(codm) from area left join adscrito on area.coda=adscrito.coda group by area.coda order by to_number(substr(area.coda,2),'9');


 'c7 )amosar codico e nome de medicos que que non tenhen ningun medico  que mande neles' 

select codm,nomm from medico where codm1 is null;


 'c8) amosar codigo  dos asegurados de primeira categoria que foron  hospitalizados entre o 10/2/16 e o 23/3/2017 ambolas duas datas incluidas ' 

select codp,numas,count(numas) from hosp1 where datai<='23/03/2017' and dataf>='10/02/2016' group by codp,numas;


 'c9) amosar o numero total de camas dos hospitais concertados ' 

select sum(numc) from hospital where codh in (select codh from concertado);
select sum(numc) from hospital, concertado where hospital.codh=concertado.codh;


 'c10) amosar codigo e nome de hospitais cuxo numero de camas corresponda polo menos a un hospital propio e a un hospital privado ' 

select codh, nomh from hospital where numc in (select numc from hospital where codh in(select codh from concertado)) and numc in (select numc from hospital where codh in (select codh from propio));


