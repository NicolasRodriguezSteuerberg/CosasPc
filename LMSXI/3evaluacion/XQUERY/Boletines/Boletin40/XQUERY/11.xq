for $x in doc("Boletin40")//baile
for $y in doc("pasos")//baile
  where $x/nombre=$y/nombre
  return <baile-pasos>{data($x/nombre)}, {data($y/pasos)}</baile-pasos>