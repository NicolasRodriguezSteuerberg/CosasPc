import sys

# importamos del pyqt6 los elementos que nos importa -> ventana principal, boton
from PyQt6.QtWidgets import (QApplication, QMainWindow,QCheckBox , QLabel,
                             QVBoxLayout, QWidget, QLineEdit)
from PyQt6.QtCore import Qt

# creamos clase que heread de QMainWindow
class VentanaPrincipal (QMainWindow):
    # iniciamos a ventana
    def __init__(self):
        # llamamos al constructor de la superclase
        super().__init__()
        self.setWindowTitle( "Mi primera ventana con Qt")
        self.setFixedSize(800,500)

        # usamos una box vertical para añadir varias cosas
        caixaV = QVBoxLayout()

        self.checkButton1 = QCheckBox("Check 1")
        self.checkButton1.toggled.connect(self.on_checkButton_toggled)

        self.checkButton2 = QCheckBox("Check 2")
        self.checkButton2.toggled.connect(self.on_checkButton_toggled)

        caixaV.addWidget(self.checkButton1)
        caixaV.addWidget(self.checkButton2)

        container = QWidget()
        container.setLayout(caixaV)

        self.setCentralWidget(container)

        # mostramos la ventana
        self.show() # para que se vea a pantalla

    def on_checkButton_toggled(self):
        if self.checkButton1.isChecked():
            print("Boton check 1 activado", self.checkButton1.text())
        if not self.checkButton1.isChecked():
            print("Boton check 1 desactivado", self.checkButton1.text())
        if self.checkButton2.isChecked():
            print("Boton check 2 desactivado", self.checkButton2.text())
        else:
            print("Boton check 2 desactivado", self.checkButton2.text())

if __name__ == "__main__":
    # creamos un objeto de instancia qapplication
    aplicacion = QApplication(sys.argv) # sys.argv -> unimos la aplicacion con el sistema operativo
    # creamos un objeto de la ventana
    ventana = VentanaPrincipal()
    # ejecutamos la union?
    aplicacion.exec()

