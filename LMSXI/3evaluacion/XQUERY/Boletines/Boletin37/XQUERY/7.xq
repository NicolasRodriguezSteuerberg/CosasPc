for $x in doc("Boletin37")//alumno
order by $x/apells
return data($x/nombre)