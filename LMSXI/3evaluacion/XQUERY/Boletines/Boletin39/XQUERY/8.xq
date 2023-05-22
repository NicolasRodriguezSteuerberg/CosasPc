<html>
<body>
<h4>Lista</h4>
<ul>
  {
    for $x in doc("Boletin39")/libros/libro
    return
      <li><b>Titulo: </b> {$x/titulo}</li>
  }
    
  {
    for $x in doc("Boletin39")/libros/libro
    return
      <li><b>Precio: </b>{$x/precio}</li>
    }
</ul>
</body>
</html>