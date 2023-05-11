for $x in doc("Boletin36")//libro
order by $x/titulo 
return data($x/titulo)