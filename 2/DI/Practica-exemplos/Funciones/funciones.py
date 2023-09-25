# Para declarar una funcion se define con def

# Esto es un comentario de solo una linea
"""
Se pueden hacer de dos formas:


Esto es un comentario de varias lineas.
Tambien sirve para documentar una función
:param …:
:return:
"""
def nome_da_funcion (parametro1, parametro2):
    """
    Función de exemplo para mostrar como se escriben as funcións

    A función fai unha sum, si é número, do parámetro 1 e 2
    :param parametro1:
    :param parametro2:
    :return: parametro1
    """
    print(parametro1, parametro2)
    return parametro1 + parametro2

print(nome_da_funcion(1,2))

print(nome_da_funcion("hola", "que tal")) # Al hacer print, hace print del return, al ser una suma las pone juntas

print(nome_da_funcion(parametro2 = "que tal", parametro1 = "Ola")) # Puedes mandar los parámetros de forma desordenada

# nome_da_funcion("Hola") # Necesitas darle los dos parámetros por que si no te da error

def repetir(cadea, veces = 1): # El segundo parámetro es un parámetro por defecto (si no le das ningún valor a la hora de llamar a la función)
    print(cadea * veces)

repetir("Hola ", 5)
repetir("Adeus")

def volumeParalelogramo(lado1 = 1, lado2 = 1, altura = 1):
    return lado1*lado2*altura

print(volumeParalelogramo())
print(volumeParalelogramo(6))
print(volumeParalelogramo(6, 4))
print(volumeParalelogramo(6, 4, 5))
print(volumeParalelogramo(altura = 5))

def funcionSumaMoitosParametros(valor1, valor2, *outros): # minimo 2 parametros
    suma = valor1 + valor2
    for x in outros:
        suma += x
    return suma
print(funcionSumaMoitosParametros(1,2, 4, 5, 6, 7, 8, 9, 10, 11))

def usuarioConDatosExtendidos(nome, dni, edade, **outros):
    print("Nome: " + nome)
    print("Dni: " + dni)
    print("Edad:", edade) # si pongo un + en vez de la coma va a dar error por que no puede sumar un int con un string, tendria que hacer un casteo --> print("Edad: " + str(edade))
    for clave in outros.keys(): # .keys() nos devuelve una tupla con el diccionario, hay otra opcion: diccionario.items()
        print(clave, ":" , outros[clave]) # pasa lo mismo que con la edad

usuarioConDatosExtendidos("Nico", "98798754Y", 20, Sexo = "Varón", Direccion = "Balaidos", Estado = "Casado", Vivo = True)

var = 5
def funcion(valor):
# Si quieres usar la variable var que está antes de la función tendrías que usar el nombre de la clase.var main.var-->no lo cambia, pero puedes usarlo para hacer operaciones, sacar su valor...
    var = valor # Creas otro variable, ya que para la función no existía la variable var
    print(var)
funcion(9)
print(var)