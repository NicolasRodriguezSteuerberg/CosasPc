def funcion(lista):
    lista2 = list()
    for elementos in lista:
        lista3 = (elementos[1], elementos[2] + ".", elementos[0],)
        lista2.append(lista3)
    print(lista2)

lista = [("Rodriguez","Nicolas","S"),("Rodriguez","pepe","r")]
funcion(lista)