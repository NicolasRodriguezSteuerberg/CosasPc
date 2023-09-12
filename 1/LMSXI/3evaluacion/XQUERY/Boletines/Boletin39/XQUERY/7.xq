for $x in doc("Boletin39A")/almacen
return
  if (name($x/vendidos))
    then data(<vendidos>{$x/vendidos}</vendidos>)
  else()