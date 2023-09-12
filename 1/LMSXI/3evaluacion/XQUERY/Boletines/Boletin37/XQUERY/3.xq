for $x in doc("Boletin37")//alumno
return <alumno>{data($x/nombre)}, {data($x/nota)} </alumno>/text()