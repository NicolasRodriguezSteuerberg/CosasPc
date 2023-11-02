import sys
from PyQt6.QtWidgets import (QApplication, QMainWindow, QWidget, QTabWidget)

# importo la clase caixaColor de la clase VentanaEjercicio
from VentanaEjercicio import CaixaColor

class VentanaPrincipal(QMainWindow):
    def __init__(self):
        super().__init__()

        self.setWindowTitle("Exemplo QTabWidget")

        tabWidget = QTabWidget()
        tabWidget.setTabPosition(QTabWidget.TabPosition.North)
        # te pertite mover las "fichas"
        tabWidget.setMovable(True)

        for color in ["red", "green","blue","yellow"]:
            tabWidget.addTab(CaixaColor(color), color)

        self.setCentralWidget(tabWidget)
        self.show()

if __name__ == "__main__":
    # creamos un objeto de instancia qapplication
    aplicacion = QApplication(sys.argv) # sys.argv -> unimos la aplicacion con el sistema operativo
    # creamos un objeto de la ventana
    ventana = VentanaPrincipal()
    # ejecutamos la union?
    aplicacion.exec()