"""Diccionarios"""

diccionario = {
    1: "Un",
    2: "Dos",
    3: "Tres",
    4: ["Catro", 4, "IV", 0b00000100, 0o4, 0x4, 4.0]
}

print(diccionario[3])
print(diccionario.get(3))
print(diccionario.get(6, "No existe")) # con el get, podemos darle un valor por si no existe
print(6 in diccionario) # si existe la key 6
print(diccionario.items()) # nos da una lista con las keys y sus valores
print(diccionario.keys()) # nos da una lista con las keys
print(diccionario.values()) # nos da una lista con los valores (sin las keys)
print("Borrando o valor: " + diccionario.pop(2, "No existe el valor"))
print(diccionario.items())
diccionario.clear()
print(diccionario.items())