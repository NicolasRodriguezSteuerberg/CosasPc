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
print(f)
f()