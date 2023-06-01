<html>
<body>
  {
    for $x in doc("Examen")//modulo[horas<5]
    return <p style="text-transform: uppercase;">{data($x/nombre)}</p>
  
  }
</body>
</html>
