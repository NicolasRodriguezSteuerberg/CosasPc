import sys
from PyQt6.QtWidgets import (QApplication, QMainWindow, QWidget, QPushButton,
                             QGridLayout, QStackedLayout, QVBoxLayout, QHBoxLayout)

# importo la clase caixaColor de la clase VentanaEjercicio
from VentanaEjercicio import CaixaColor
from VentanasQStackLayout import PanelGrid

class HBoxModificado (QHBoxLayout):
    def __init__(self):
        super().__init__()
        vBox1 = QVBoxLayout()
        vBox2 = QVBoxLayout()

        vBox1.addWidget(CaixaColor("red"))
        vBox1.addWidget(CaixaColor("yellow"))
        vBox1.addWidget(CaixaColor("purple"))
        self.addLayout(vBox1)

        self.addWidget(CaixaColor("green"))

        vBox2.addWidget(CaixaColor("blue"))
        vBox2.addWidget(CaixaColor("orange"))
        self.addLayout(vBox2)


class VentanaPrincipal(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Exemplo QStacked Layout con Qt")

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

        boxMod = QPushButton("Box modificado")
        boxMod.pressed.connect(self.on_boxMod_pressed)

        # Añadimos los botones a la caja horizontal
        horizontalBox.addWidget(redButton)
        horizontalBox.addWidget(blueButton)
        horizontalBox.addWidget(gridButton)
        horizontalBox.addWidget(boxMod)

        # creamos las tarjetas
        self.tarjetas = QStackedLayout()
        # añadimos las tarjetas
        self.tarjetas.addWidget(CaixaColor("red"))
        self.tarjetas.addWidget(CaixaColor("blue"))
        # para añadir el gridLayout
        widgetGrid = QWidget()
        widgetGrid.setLayout(PanelGrid())
        self.tarjetas.addWidget(widgetGrid)
        # para añadir el boxLayout
        widgetBox = QWidget()
        widgetBox.setLayout(HBoxModificado())
        self.tarjetas.addWidget(widgetBox)
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

    def on_boxMod_pressed(self):
        self.tarjetas.setCurrentIndex(3)

if __name__ == "__main__":
    # creamos un objeto de instancia qapplication
    aplicacion = QApplication(sys.argv) # sys.argv -> unimos la aplicacion con el sistema operativo
    # creamos un objeto de la ventana
    ventana = VentanaPrincipal()
    # ejecutamos la union?
    aplicacion.exec()