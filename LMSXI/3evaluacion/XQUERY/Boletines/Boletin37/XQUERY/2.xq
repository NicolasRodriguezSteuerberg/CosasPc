for $x in doc("Boletin37")//alumno[last()]
return data($x/nota)