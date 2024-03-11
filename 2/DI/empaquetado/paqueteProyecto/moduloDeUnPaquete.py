
def miFuncionDeUnPaquete():
    print("Hola desde miFuncion de un paquete")


class MiClaseDeUnPaquete:
    def __init__(self):
        print("Hola desde MiClase de un paquete")

print("Hola desde moduloUno.py, ejecutase siempre en un paquete")

if __name__ == "__main__":
    print("Hola desde moduloUno.py no se ejecuta siempre en un paquete")