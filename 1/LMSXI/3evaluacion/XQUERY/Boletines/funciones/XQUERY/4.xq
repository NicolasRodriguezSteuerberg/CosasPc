for $x in doc("funciones")/bookstore/book
  where contains($x/title,"X") or contains($x/title,"x")
  order by $x/title descending
return data($x/title)