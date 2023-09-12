for $x in doc("Examen")//modulo[curso=1]
where ($x/ciclo = "DAW")
return $x/nombre/text()