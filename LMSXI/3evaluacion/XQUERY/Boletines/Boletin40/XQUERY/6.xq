<html>
  <head>
    table,tr,th,td{
      border=1
    }
  </head>
  <body>
    <table>
      <tr><th>Nombre</th><th>Profesor</th><th>Plazas</th></tr>
      {
      for $x in doc("Boletin40")//baile
      order by $x/plazas ascending
      return
      <tr>
        <td>{data($x/nombre)}</td>
        <td>{data($x/profesor)}</td>
        <td>{data($x/plazas)}</td>
      </tr>
        }
    </table>
  </body>
</html>