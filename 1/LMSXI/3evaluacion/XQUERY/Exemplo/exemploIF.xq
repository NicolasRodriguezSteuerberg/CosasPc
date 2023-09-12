for $x in //libro
  return 
  if ($x/@leng="español")
    then <español>(data($x/titulo))</español>
  else(<extranjero>(data($x/titulo))</extranjero>)
    
    