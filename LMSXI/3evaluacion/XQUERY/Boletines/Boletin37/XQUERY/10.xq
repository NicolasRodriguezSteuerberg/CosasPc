for $x in doc("Boletin37")//alumno
return 
if ($x[nota>=5])
  then <aprobo>{data($x/@dni)}</aprobo>
else(<suspendio>{data($x/nombre)}</suspendio>)