for $x at $i in doc("Boletin36")//libro
return <hagoEtiquetas>{$i}, {$x/titulo/text()}</hagoEtiquetas>/text()
(:de esta manera no salen en diferentes lineas (el /text() para que no salga la etiqueta):)