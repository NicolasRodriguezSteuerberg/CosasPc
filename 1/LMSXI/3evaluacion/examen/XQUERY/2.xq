<html>
<body>
<table style="border: 1px solid black;">
<tr><th>Nombre</th> <th>Horas</th> <th>Curso</th></tr>
  {
    for $x in doc("Examen")//modulo[ciclo="DAW"]
    return
      <tr> <td>{data($x/nombre)}</td> <td>{data($x/horas)}</td> <td>{data($x/curso)}</td></tr>
  }
</table>
</body>
</html>