for $x in doc("Boletin39")/libros/libro
return 
  if(count($x/autores/autor)>1)
    then <variosAutores>{data($x/titulo)}</variosAutores>
    else(<unAutor>{data($x/titulo)}</unAutor>)