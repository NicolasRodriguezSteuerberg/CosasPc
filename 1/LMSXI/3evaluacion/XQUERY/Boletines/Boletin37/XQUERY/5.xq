for $x in doc("Boletin37")//alumno[nota>=5]
return <alumno>{data($x/@dni),",",data($x/nota)}</alumno>/text()