for $x in doc("Boletin38")//libro[precio>20]/titulo
order by $x
return data($x)