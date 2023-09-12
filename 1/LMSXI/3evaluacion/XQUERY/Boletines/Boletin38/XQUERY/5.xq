for $x in doc("Boletin38")//libro
return
if($x/@tema="Gastronomía")
  then <entretenido>{data($x/titulo)}</entretenido>
else(<no_entretenido>{data($x/titulo)}</no_entretenido>)