def funcion1(numeros):
    lista = list()
    for i in numeros:
        if i % 2 != 0 and i % 3 != 0 and i % 5 != 0:
            lista.append(i)
    print(lista)
    print(lista[0])

def funcion2(numeros):
    suma = 0
    contador = 0
    for i in numeros:
        suma+=i
        contador+=1
    print("Sumatoria =", suma)
    print("Valor promedio =", (suma/contador))

def funcion3(numeros):
    for numero in numeros:
        factorial = 1
        if numero >=1:
            for i in range(1, numero+1):
                factorial*=i
        print("O factorial do número:", numero, "es", factorial)


lista = (1,2,4,5, 6,7,9,11,13,15,17,20,25,22)
funcion1(lista)
funcion2(lista)
funcion3(lista)