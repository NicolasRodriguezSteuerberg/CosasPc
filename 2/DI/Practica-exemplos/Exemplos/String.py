"""Cadeas de string"""
c = "Hola que tal"
print(c.count("qu")) # cuenta cuantas qu (juntas, no por separado) hay
print(c.find("qu")) # te dice la posicion donde empieza qu (la posicion de la q)
c.join("varias cadeas") # no se sabe que hace
print(c.partition(" ")) # te separa la cadena, dandote una tupla
c = c.replace(" ", "_") # cambia los espacios por _
print(c)
print(c.split("_")) # te devuelve una lista separandolos por _
print(c[0:2]) # printea de la posicion 0 a la 2

print(c[::2]) # va imprimiendo cada 2 caracteres, podrias poner que vaya de una posicion a otra saltando caracteres

# Puedes hacer que la cadena sea invertida
cadea = "Hola"
cadea = cadea[::-1]
print(cadea)

# Puedes remplazar digitos de una cadena por un caracter:
cadea = "Sua clave é: 1540"
caracter = "X"
for element in cadea:
    if element.isdigit(): # mira si es un digito
        cadea = cadea.replace(element, caracter)
print(cadea)

# Puedes crear una lista a partir de una cadena:
cadena = "Quiero ser una lista"
lista = list(cadena)
print(lista)