for $x in doc("Boletin39")//libro
return <autor>{data($x/autores/autor[1]/nombre)}, {data($x/autores/autor[1]/apellido)}</autor>/text()