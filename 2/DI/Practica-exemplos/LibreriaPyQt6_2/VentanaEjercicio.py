import sys

from PyQt6.QtWidgets import (QApplication, QMainWindow, QLabel,
                             QVBoxLayout, QWidget, QHBoxLayout)
from PyQt6.QtGui import QColor, QPalette

class CaixaColor (QWidget):
    def __init__(self, color):
        super().__init__()
        self.setAutoFillBackground(True)
        paleta = self.palette()
        paleta.setColor(QPalette.ColorRole.Window, QColor(color))
        self.setPalette(paleta)
        
class VentanaEjercicio (QMainWindow):
    # definimos la interfaz
    def __init__(self):
        super().__init__()
        # caja que contenga todo
        box = QHBoxLayout()

        # una caja que contenga varios cuadrados
        squares1 = QVBoxLayout()
        # añadimos los coloes
        squares1.addWidget(CaixaColor("red"))
        squares1.addWidget(CaixaColor("yellow"))
        squares1.addWidget(CaixaColor("purple"))

        # caja que contenga otra etiqueta
        square2 = QVBoxLayout()
        square2.addWidget(CaixaColor("green"))

        # caja que contrnga otras etiquetas
        square3 = QVBoxLayout()
        square3.addWidget(CaixaColor("red"))
        square3.addWidget(CaixaColor("purple"))

        # añadimos a la caja grande las otras cajas
        box.addLayout(squares1)
        box.addLayout(square2)
        box.addLayout(square3)

        container = QWidget()
        container.setLayout(box)
        self.setCentralWidget(container)
        # mostramos la ventana
        self.show()

if __name__ == "__main__":
    # creamos un objeto de instancia qapplication
    aplicacion = QApplication(sys.argv) # sys.argv -> unimos la aplicacion con el sistema operativo
    # creamos un objeto de la ventana
    ventana = VentanaEjercicio()
    # ejecutamos la union?
    aplicacion.exec()