for $x at $i in doc("Boletin36")//libro
return <hagoEtiquetas>{$i}, {$x/titulo/text()}</hagoEtiquetas>