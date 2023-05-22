for $x in doc("funciones")/bookstore/book
  where contains($x/title, "X")
return $x/@category