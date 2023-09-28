import math


class Punto:
    """
    Clase que define a un punto nun plano bidimensional
    Las variables de las clases en python generalmente son públicas
    Y no declaramos ninguna variable al principio de la clase
    """
    def __init__(self, x = 0, y = 0):
        # init é un método para inicializar
        # self sirve para que crear y declar las variables que están en el parentesis
        # Se declara e se inicializa á vez
        self.x = x
        self.y = y

p1 = Punto(1.0,2.3)
p1.x = 15.66
print("Coordenadas do punto: " + str(p1.x) + ", " + str(p1.y))
print(type(p1))

class Circulo(Punto): # (extiende de Punto), hereda sus atributos
    """
    Clase que representa un circulado centrado nun punto
    """
    def __init__(self, x, y, r = 1):
        Punto.__init__(self, x, y)
        self.__r = r # self.__r --> de esta manera pones privado la variable y asi una vez creado el objeto no lo puedes modificar

    def superficie(self):
        return math.pi * (self.__r**2)

    def perimetro(self):
        return 2 * math.pi * self.__r

    def getR(self):
        return self.__r

    def setR(self, r):
        self.__r = r

    r = property(getR, setR) # el getter y setter se pone sin el parentesis, esto hace que si con el objeto de la clase llamamos a r no cree una variable nueva y se haga el setter

c1 = Circulo(1,3,3)
print("A superficie é:", c1.superficie())
c1.r = 1 # crea una variable llamada c1.r, no le cambia el valor a r del objeto c1
print("A superficie é:", c1.superficie())
