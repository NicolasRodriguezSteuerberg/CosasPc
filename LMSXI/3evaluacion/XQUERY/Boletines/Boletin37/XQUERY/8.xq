for $x in doc("Boletin37")//alumno
order by $x/@dni
return data($x/nombre)