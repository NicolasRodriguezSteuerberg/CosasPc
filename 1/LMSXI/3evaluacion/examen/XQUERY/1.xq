for $x in doc("Examen")//modulo
order by $x/@codigo
return <resultado>{data($x/nombre)}, {data($x/@codigo)}</resultado>/text()