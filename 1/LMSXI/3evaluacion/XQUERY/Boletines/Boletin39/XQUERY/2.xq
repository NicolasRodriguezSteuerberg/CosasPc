for $x in doc("Boletin39")//libro
order by $x/autores/autor[1]/nombre
return $x/titulo