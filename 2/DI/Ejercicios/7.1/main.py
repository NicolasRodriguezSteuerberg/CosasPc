def estanOrdenados(numeros):
    validar = True
    for numero in range(len(numeros)):
        if numero == (len(numeros)-1):
            break
        else:
            validar = numeros[numero] < numeros[numero + 1]

        if validar == False:
            break
        else:
            continue
    return validar
numeros = (1,2,5,3)
if estanOrdenados(numeros)==True:
    print("Está ordenado")
else:
    print("Está desordenado")