def es_par(n):
    return (n%2==0)

lista = [1,2,3,4]

# posibilidad distinta a lambda
l2 = filter(es_par, lista)
for n in l2:
    print(n)
# filter, redireccionar hacia una funcion que le des como parámetro junto al parametro que quieres ejecutar en la funcion el segundo termino es lo que recibe
# lamda: es mas economico en terminos de memoria
l3 = filter(lambda n: n%2 == 0, lista) # va cogiendo cada valor de la lista y va haciendo la función, si es igual a 0 lo guarda en l3

for n in l3:
    print(n)

#lista lambdeada

l4 = [n for n in lista if n % 2 == 0] # guarda en n (que guarda en l4) todos los elementos de la lista cuando se cumpla la condicion
print(l4)

l5 = [n**2 for n in lista] # que se eleve a cuadrado todos los numeros de la lista
print(l5)
"""
Equivalente:
l5 = []
for n in lista:
    l5.append(n**2)
"""
m = ["a","b"]
n = [s*n for s in m
         for n in lista
            if n>0]
# que se multiplique s(que coge el valor de m) y lo multiplica por n(valor de la lista) si es mayor que 0, (por cada valor de m se multiplica por todos los valores de la lista)
print(n)

# si en vez de los [...] pongo (...) se convierte en un generador y solo conseguimos los valores cuando los necesitamos ...
x = (n**2 for n in lista)
print(x)
for r in x:
    print(r)
print()


# construir el for normal de java
def meu_for(n = 0, m = 1, i = 1):
    while (n<m):
        yield n # produce valores
        n += i


for n in meu_for(m = 5):
    print(n)
