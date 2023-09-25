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
import funciones

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

if t[0]==1:
    # O bloque márcase con ':'
    # Se tabula o código con espazos
    # O número de espazos é libre pero sempre o mesmo denrto do bloque de código
    print("Nico guapo")
else:
    print("Nico no es guapo")

variable = 3
var = "par" if variable % 2 ==0 else "impar"
print(var)

while variable < 20:
    variable+=1
    if variable % 5:
        continue
    else:
        print("O valor é: " + str(variable))
numeros = [1, 2, 3, 4, 5]
suma = 0
for numero in numeros:
    print(numero)
    suma+=numero
    print("suma: " + str(suma))

print("\nSuma final: " + str(suma))

# for i in range (1,3,1):
#    print(i)

for i in range(len(numeros)):
    print(numeros[i])

#for i in enumerate(numeros):   -> de esta manera la i es una tupla
#    print(i, numeros[i])

for i, num in enumerate(numeros):
    #print(i, numeros[i]) -> sirve igualmente
    print(i, num) # guarda el elemento de numeros en num

funciones.nome_da_funcion("Hola", 2)