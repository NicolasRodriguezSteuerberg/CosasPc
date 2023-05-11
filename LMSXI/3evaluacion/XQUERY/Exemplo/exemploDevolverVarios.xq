for $x in doc("Boletin36")//libro
return <titulo-autor>{$x/titulo/text()," -- ", $x/autor/text()}</titulo-autor>