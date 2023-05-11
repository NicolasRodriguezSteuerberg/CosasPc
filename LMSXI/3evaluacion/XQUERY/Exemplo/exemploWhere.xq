for $x in doc("Boletin36")//libro
(:de esta manera solo saca los que tengan precio menor que 30:)
where $x/precio<30 and $x/autor='Moliere'
return data($x/titulo)