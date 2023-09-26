class Punto:
    """
    Clase que define a un punto nun plano bidimensional
    Las variables de las clases en python generalmente son públicas
    Y no declaramos ninguna variable al principio de la clase
    """
    def __init__(self, x, y):
        # init é un método para inicializar
        # self sirve para que crear y declar las variables que están en el parentesis
        # Se declara e se inicializa á vez
        self.x = x
        self.y = y

p1 = Punto(1.0,2.3)

p1.x = 15.66

print("Coordenadas do punto: " + str(p1.x) + ", " + str(p1.y))

print(type(p1))