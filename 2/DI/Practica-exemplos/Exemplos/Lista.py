l = list() # lista vacia
l = [] # lista vacia
l.append("Objeto nuevo") # meter nuevo objeto
l.append(2)
l.append(3)
l.append(6)
l.append([2,3,5])
print(l)
print(l.count(2)) # cuenta las veces que se repite el valor 2
l.extend([6,7,8,"nove"]) # coge los elementos de una lista y los pone por separado en la otra lista
print(l)
print(len(l)) # nos dice la longitud de la lista
l.insert(3, "sete") # añade en la posicion x lo que queremos y mueve el que está en la posicion 3 y los siguiente uno a la derecha
print(l)
print(l.pop(3)) # para buscar el elemento de la posicion 3 == l[3]
l.remove([2,3,5]) # elimina lo que sea igual, en este caso remueve la lista que contiene 2,3,5 de la lista principal
print(l)
l.reverse() # pone los elementos de forma invertida
print(l)

l2 = [2,5,3,6,7,1,3,6,9]
l2.sort() # ordena la lista de menor a mayor (si tienes numeros y string no se ordenará)
print(l2)