<html>
  <body>
    <ul>
      {
        for $x in doc("Boletin40")//baile
        return
          <li><strong>Profesor:</strong> {data($x/profesor)} - <strong>Nombre baile: </strong> {data($x/nombre)}</li>
      }
    </ul>
  </body>
</html>