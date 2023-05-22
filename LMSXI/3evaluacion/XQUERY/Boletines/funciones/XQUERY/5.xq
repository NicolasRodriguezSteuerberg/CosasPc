for $x in doc("funciones")//book/year/text()

return distinct-values($x)