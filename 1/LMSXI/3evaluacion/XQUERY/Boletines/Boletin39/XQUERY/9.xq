<html>
<body>
<h1>Libros</h1>
  <table border="1">
  <tr><th>Titulo</th><th>ISBN</th><th>Precio</th></tr>
  {
    for $x in doc("Boletin39")/libros/libro
    return
    <tr>
      <td>{$x/titulo}</td>
      <td>{$x/isbn}</td>
      <td>{$x/precio}</td>
    </tr>
  }
   
  </table>
</body>
</html>