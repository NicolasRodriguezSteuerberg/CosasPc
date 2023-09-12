for $x in doc("Boletin37")//alumno[nota>=5]
return data($x/nombre)