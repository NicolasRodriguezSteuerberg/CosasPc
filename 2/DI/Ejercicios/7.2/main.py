# This is a sample Python script.

# Escribir unha función que indique si duas fichas de dominó encaixan ou non.
# As fichas recíbense en duas tuplas, por exemplo: (3,4) y (5,4).
def encaixe(tupla1, tupla2):
    """
    Funcion que compara se unha ficha de dominó entra noutra
    :param tupla1: tupla cunha ficha de domino
    :param tupla2: tupla con outra ficha
    :return: 'encaixan' ou 'non encaixan'
    """
    if tupla1[0] == tupla2[0] or tupla1[0] == tupla2[1] or tupla1[1] == tupla2[0] or tupla1[1] == tupla2[1]:
        return "encaixan"
    else:
        return "non encaixan"


print(encaixe((3,4), (5,4)))

# Escribir unha función que indique si duas fichas de dominó encaixan ou non.
# As fichas recíbense nunha cadea, por exemplo: 3-4 2-5.
# Nota: utilizar a función split dlas cadeas.
def encaixan(cadena):
    """
    Funcion que compara se unha ficha de dominó encaixa noutra ou non
    :param cadena: unha cadena de texto cos valores das fichas exemplo '3-4 2-5'
    :return: encaixan ou non encaixan
    """
    aux = cadena.split()
    aux1 = aux[0].split("-")
    aux2 = aux[1].split("-")
    return encaixe(aux1, aux2)

print(encaixan("3-4 2-5"))
