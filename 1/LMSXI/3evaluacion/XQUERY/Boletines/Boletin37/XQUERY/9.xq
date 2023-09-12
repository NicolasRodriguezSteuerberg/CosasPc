for $x at $i in doc("Boletin37")//alumno
return <etiqueta>{$i,"--",data($x/nombre)}</etiqueta>/text()