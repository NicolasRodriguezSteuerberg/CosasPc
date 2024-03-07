import doctest
def cadrados(lista):
    """
    Funcion que crea el cuadrado de los numeros de una lista
    :param lista: lista de numeros
    :return: Lista de numeros elevados al cuadrado

    >>> l = [0,2,5,100]
    >>> cadrados(l)
    [0, 4, 25, 10000]
    """
    return [n ** 2 for n in lista]

def cadrado(numero):
    """
    Funcion que crea el cuadrado de un número
    :param numero: numero
    :return: numero elevado al cuadrado

    >>> l = [0, 2, 5, 100]
    >>> for n in l:
    ...     cadrado(n)
    0
    4
    25
    10000

    >>> l = [0, 2, 5, 100]
    >>> for n in l:
    ...     cadrado(n)
    0
    4
    25
    10000
    """
    return numero ** 2

def _test():
    doctest.testmod()

if __name__ == "__main__":
    _test()