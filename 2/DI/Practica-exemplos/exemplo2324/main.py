a = int(9)
print(type(a))
a = 'a'
b = 3
print(type(a))

octal = 0o27
print(type(octal), octal)
hexadecimal = 0xabc
print(type(hexadecimal),hexadecimal)
binario = 0b100011
print(type(binario),binario)

numReal = 0.0001
numReal2 = 1e-4
print(numReal, numReal2)


encendido = bool(1) #true
apagado = not encendido #si encendido fuera un valor distinto de 0 seguiria dando false
if encendido: #coge 1 como true
    print("A luz está prendida")

print(apagado and encendido) #falso y verdadero es lo mismo? no pues falso
print(apagado or encendido) #falso o verdadero? verdadero