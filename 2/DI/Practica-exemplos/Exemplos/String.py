"""Cadeas de string"""
c = "Hola que tal"
print(c.count("qu")) # cuenta cuantas qu (juntas, no por separado) hay
print(c.find("qu")) # te dice la posicion donde empieza qu (la posicion de la q)
c.join("varias cadeas") # no se sabe que hace
print(c.partition(" ")) # te separa la cadena, dandote una tupla
c = c.replace(" ", "_") # cambia los espacios por _
print(c)
print(c.split("_")) # te devuelve una lista separandolos por _