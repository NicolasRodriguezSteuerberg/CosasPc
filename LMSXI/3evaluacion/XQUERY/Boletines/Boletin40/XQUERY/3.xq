for $x in doc("Boletin40")/distinct-values(//baile[precio/@cuota='mensual']/profesor)
return $x