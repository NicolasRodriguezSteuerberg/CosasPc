# This is a sample Python script.
def funcion1(lista, numeroK):
    lista1, lista2, lista3 = list(), list(), list()
    for numero in lista:
        if numero < numeroK:
            lista1.append(numero)
    for numero in lista:
        if numero > numeroK:
            lista2.append(numero)
    for numero in lista:
        if numero == numeroK:
            lista3.append(numero)
    print("Lista de numeros menos que",numeroK, ":", lista1)
    print("Lista de numeros maiores que", numeroK, ":", lista2)
    print("Lista de numero iguales que", numeroK, ":", lista3)

def funcion2(lista, numeroK):
    lista1 = list()
    for numero in lista:
        if numero % numeroK == 0:
            lista1.append(numero)
    print("Lista de numero que son múltiplos de:", numeroK, ":", lista1)


lista = (1,2,34,5,7,6,14,21)
funcion1(lista, 6)
funcion2(lista, 7)