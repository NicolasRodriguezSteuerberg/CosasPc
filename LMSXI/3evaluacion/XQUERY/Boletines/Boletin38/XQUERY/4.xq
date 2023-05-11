for $x in doc("Boletin38")//libro[precio>20]
order by $x/titulo
return <etiqueta>{data($x/titulo),", ",data($x/autor)}</etiqueta>/text()