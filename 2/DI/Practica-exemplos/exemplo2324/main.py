#a = int(9)
#print(type(a))
#a = 'a'
#b = 3
#print(type(a))

#octal = 0o27
#print(type(octal), octal)
#hexadecimal = 0xabc
#print(type(hexadecimal),hexadecimal)
#binario = 0b100011
#print(type(binario),binario)

#numReal = 0.0001
#numReal2 = 1e-4
#print(numReal, numReal2)


#encendido = bool(1) #true
#apagado = not encendido #si encendido fuera un valor distinto de 0 seguiria dando false
#if encendido: #coge 1 como true
#    print("A luz está prendida")
#
#print(apagado and encendido) #falso y verdadero es lo mismo? no pues falso
#print(apagado or encendido) #falso o verdadero? verdadero
"""
dir = 128^255
print(dir)
division = 128>>3 # mueve el 1 del 128 3 posiciones a la derecha
print(division)
"""

lista = [1,2,3,4,5]
print(lista[3])

lista2 = [[1,2,3,4],[5,6,7],[8,9,10,11,12]]
print(lista2[1][2]) #coge la lista de la posicion 1 y su posicion 2 (acordarse que empiezan en 0)
print(lista2[0][2])
lista2[0][2] = "tres"
print(lista2[0][2])

lista3 = [1,2.0,"Hola que tal",[3+7j,23]]
print(lista3[3][0])
print(lista3[0:3]) #imprime de la posicion 0 a justo la de antes de la posicion 3
print(lista3[0:4:3])
lista3[0:3] = ["uno", "dos", "tres", "cuatro"]
print(lista3)

l = list() # así creas un array vació
print(l)

t = (1,2,4,5,2.0,"HOla", 4+5j)
print(t)

z = ("1",)
#tambien puedes crear una tupla vacia pero es estupido w = tuple()
print(type(z))
print(type(lista3))

w = tuple(lista3)
print(type(w),w)

cadena = "el patio de mi casa es particular"
print(cadena[4:10])

diccionario = { 1: "un",
                2: "dos",
                3: "tres",
                4: "cuatro"
                }
print(diccionario[3])
diccionario[3] = 0b00011 #el 0b significa que es binario
print(diccionario[3])