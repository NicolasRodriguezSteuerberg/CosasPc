for $x in doc("Boletin36")//libro
return $x/titulo/text()
(:return data($x/titulo) -- las dos opciones serian iguales:)