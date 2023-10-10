
# uso el switch de la clase switch para lo siguiente
def saudar (lingua):
    def saudar_es():
        print("Hola")
    def saudar_gl():
        print("Ola")
    def saudar_it():
        print("Ciao")
    def saudar_en():
        print("Hello")

    # un diccionario para despues poder returnar una función
    saudo_idiomas = {
        "es": saudar_es,
        "gl": saudar_gl,
        "it": saudar_it,
        "en": saudar_en
    }
    return saudo_idiomas[lingua]

f = saudar("es") # se guarda en la variable la función


def meu_decorador(funcion):
    def novaFuncion(*args):
        print("Chamada a función:", funcion.__name__)
        retorno = funcion(*args)
        return retorno
    # no se ponen los paréntesis por que si no, se ejecutaria la función y no la devolvería
    return novaFuncion

print(meu_decorador(saudar("gl")))

def outro_decorador(funcion):
    def novaFuncion(*args):
        print("Accións previas do outro_decorador")
        retorno = funcion(*args)
        # hago el printeo de la funcion
        print(retorno)

        print("Accións posteriores do outro_decorador")
        return retorno # retorna para la funcion exterior
    return novaFuncion # retorna la nueva funcion


@outro_decorador
@meu_decorador
def sumar(a,b):
    return "A suma de a+b = " + str(a+b)

resultado2 = sumar(1, 2)