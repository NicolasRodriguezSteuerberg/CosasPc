import sys
from PyQt6.QtWidgets import (QApplication, QMainWindow, QWidget, QPushButton,
                             QGridLayout, QStackedLayout, QVBoxLayout, QHBoxLayout)

# importo la clase caixaColor de la clase VentanaEjercicio
from VentanaEjercicio import CaixaColor

class PanelGrid(QGridLayout):
    def __init__(self):
        super().__init__()
        # objeto, fila, columna, height, column
        # fila 1
        self.addWidget(CaixaColor("red"))
        self.addWidget(CaixaColor("blue"), 0, 1, 1, 2)
        # fila 2
        self.addWidget(CaixaColor("green"), 1, 0, 2, 1)
        self.addWidget(CaixaColor("pink"), 1, 1, 1, 2)
        # fila 3
        self.addWidget(CaixaColor("orange"), 2, 1, 1, 1)
        self.addWidget(CaixaColor("yellow"), 2, 2, 1, 1)


class VentanaPrincipal(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Exemplo QStackedLayout")

        # creamos las cajas
        verticalBox = QVBoxLayout()
        horizontalBox = QHBoxLayout()

        # creamos los botones
        redButton = QPushButton("Rojo")
        redButton.pressed.connect(self.on_red_pressed)

        blueButton = QPushButton("Azul")
        blueButton.pressed.connect(self.on_blue_pressed)

        gridButton = QPushButton("Grid")
        gridButton.pressed.connect(self.on_grid_pressed)

        greenButton = QPushButton("Verde")
        greenButton.pressed.connect(self.on_green_pressed)

        # Añadimos los botones a la caja horizontal
        horizontalBox.addWidget(redButton)
        horizontalBox.addWidget(blueButton)
        horizontalBox.addWidget(gridButton)
        horizontalBox.addWidget(greenButton)

        # creamos las tarjetas
        self.tarjetas = QStackedLayout()
        # añadimos las tarjetas
        self.tarjetas.addWidget(CaixaColor("red"))
        self.tarjetas.addWidget(CaixaColor("blue"))
        # para añadir el gridLayout
        widgetGrid = QWidget()
        widgetGrid.setLayout(PanelGrid())
        self.tarjetas.addWidget(widgetGrid)
        self.tarjetas.addWidget(CaixaColor("green"))
        self.tarjetas.setCurrentIndex(0)

        # añadimos las tarjetas a la caja vertical
        verticalBox.addLayout(self.tarjetas)
        verticalBox.addLayout(horizontalBox)

        # añadimos el control con su layout
        control = QWidget()
        control.setLayout(verticalBox)
        # lo mostramos
        self.setCentralWidget(control)
        self.show()

    def on_red_pressed(self):
        self.tarjetas.setCurrentIndex(0)

    def on_blue_pressed(self):
        self.tarjetas.setCurrentIndex(1)

    def on_grid_pressed(self):
        self.tarjetas.setCurrentIndex(2)

    def on_green_pressed(self):
        self.tarjetas.setCurrentIndex(3)


if __name__ == "__main__":
    # creamos un objeto de instancia qapplication
    aplicacion = QApplication(sys.argv) # sys.argv -> unimos la aplicacion con el sistema operativo
    # creamos un objeto de la ventana
    ventana = VentanaPrincipal()
    # ejecutamos la union?
    aplicacion.exec()