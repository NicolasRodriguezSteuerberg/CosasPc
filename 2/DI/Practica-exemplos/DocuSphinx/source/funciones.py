def nombre_de_la_funcion(parametro1, parametro2):
    """
    Funcion de ejemplo para mostar como se escriben las funciones.

    La función hace una suma, si es número, del parametro 1 y 2.
    Si es una cadena, hace una concatenacion.

    :param parametro1: primero a sumar
    :param parametro2: segundo a sumar
    :return:
    """
    print(parametro1)
    return parametro1+parametro2

print(nombre_de_la_funcion(1,2))
print(nombre_de_la_funcion("hola ","que tal"))
