import math

class PrimeiroCadranteError(Exception):
    def __init__(self, coordenada):
        self.valor = coordenada
    def __str__(self):
        return "Error de coordenadas, " + self.valor + ": No es un punto del primer cuadrante"

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
        self.setX(x)
        self.setY(y)

    def getY(self):
        return self.__y

    def getX(self):
        return self.__x
    def setX(self,x):
        if x >= 0:
            self.__x = x
        else:
            raise PrimeiroCadranteError("X")

    def setY(self, y):
        if y >= 0:
            self.__y = y
        else:
            raise PrimeiroCadranteError("Y")

    def __aCadea(self):
        return "(x,y) = " + str(self.__x) + "," + str(self.__y)

    def aCadea2(self):
        return self.__aCadea()

    x = property(getX, setX)
    y = property(getY, setY)

#p1 = Punto(1.0,2.3)
#p1.x = 15.66
#print("Coordenadas do punto: " + str(p1.getX) + ", " + str(p1.getY))
#print(type(p1))

class Circulo(Punto): # (extiende de Punto), hereda sus atributos
    """
    Clase que representa un circulado centrado nun punto
    """
    def __init__(self, x, y, r = 1):
        Punto.__init__(self, x, y)
        self.__r = r # self.__r --> de esta manera pones privado la variable y asi una vez creado el objeto no lo puedes modificar
        self.x = x
        self.y = y

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
c1.r = 1 # crea una variable llamada c1.r, no le cambia el valor a r del objeto c1, a no ser que pongas el property de arriba
print("A superficie é:", c1.superficie())

class Cilindro(Circulo):
    """
    Clase que representa un cilindro
    """
    def __init__(self, x = 0, y = 0, r = 1, h = 1):
        super().__init__(x, y, r)
        self.h = h
    def superficie(self):
        return super().superficie() * 2  + super().perimetro() * self.h

    def __str__(self):
        return "Mi cilindro tiene centro en " + str(self.x) + "," + str(self.y) + " cun radio de " + str(self.r) + " y una altura de " + str(self.h)

    def __gt__(self, other): # grand then ...
        return self.superficie()>other.superficie()

    def __lt__(self, other): # less then...
        return self.superficie() < other.superficie()

    def __eq__(self, other):
        return self.x == other.x and self.y == other.y and self.h == other.h and self.r == other.r

    """
    __ne__ not equals !=
    __ge__ grand or equal then >=
    __le__ less or equal then <=
    __len__ longitud
    """

cil1 = Cilindro(1, 5, 3, 2)
print("A superficie é:", cil1.superficie())
print(cil1.__str__())
cil2 = Cilindro (1,5,3,2)
print(cil1 == cil2)
print(cil1.__gt__(cil2))
print(cil1.__eq__(cil2))
print(cil1.__doc__)


try:
    #raise (Exception("Este é otro erro indeterminado"))
    p1 = Punto(1, 3)
    p2 = Punto (1, -3)
    p1.x = 3
    print (p1.x, p1.y)
    print(p1.aCadea2())
    print(p1.getY())
    print(p1._Punto__x)
except PrimeiroCadranteError as error:
    print(error)
except Exception as error:
    print(error)
else:
    print("Só se executa cando non hai erros")
finally:
    print("Executase o finally")