import sys
from PyQt6.QtWidgets import (QApplication, QMainWindow,QPushButton, QLabel,
                             QVBoxLayout, QWidget, QLineEdit, QGridLayout)
from PyQt6.QtCore import Qt

# importo la clase caixaColor de la clase VentanaEjercicio
from VentanaEjercicio import CaixaColor

class VentanaPrincipal(QMainWindow):
    def __init__(self):
        super().__init__()

        self.setWindowTitle("Exemplo grid")

        grid = QGridLayout()
        # objeto, fila, columna, height, column

        # fila 1
        grid.addWidget(CaixaColor("red"))
        grid.addWidget(CaixaColor("blue"), 0, 1, 1, 2)

        # fila 2
        grid.addWidget(CaixaColor("green"), 1, 0, 2, 1)
        grid.addWidget(CaixaColor("pink"), 1, 1, 1, 2)

        # fila 3
        grid.addWidget(CaixaColor("orange"), 2, 1, 1, 1)
        grid.addWidget(CaixaColor("yellow"), 2, 2, 1 , 1)

        control = QWidget()
        control.setLayout(grid)
        self.setCentralWidget(control)
        self.show()

if __name__ == "__main__":
    # creamos un objeto de instancia qapplication
    aplicacion = QApplication(sys.argv) # sys.argv -> unimos la aplicacion con el sistema operativo
    # creamos un objeto de la ventana
    ventana = VentanaPrincipal()
    # ejecutamos la union?
    aplicacion.exec()