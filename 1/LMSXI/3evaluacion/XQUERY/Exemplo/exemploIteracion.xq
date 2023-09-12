for $x at $i in doc("Boletin36")//libro
(:la $i te da en que vez está recorriendo el for:)
return ($i,$x/titulo/text())
