for $x in doc("Boletin37")//alumno[nota>=6 and nota<=8]
return data($x/nombre)