import sys

# importamos del pyqt6 los elementos que nos importa -> ventana principal, boton
from PyQt6.QtWidgets import QApplication, QMainWindow, QPushButton, QLabel
from PyQt6.QtGui import QPixmap

# creamos clase que heread de QMainWindow
class VentanaPrincipal (QMainWindow):
    # iniciamos a ventana
    def __init__(self):
        # llamamos al constructor de la superclase
        super().__init__()

        self.setWindowTitle( "Mi primera ventana con Qt")
        self.setFixedSize(600,400)

        # creamos lo que quereamos poner en la ventana:
        lblEtiqueta = QLabel ("Hola :)")

        # solo se puede poner imagenes jpg?
        lblEtiqueta.setPixmap(QPixmap("dino.jpg"))
        # lo pone en el centro (solo verticalmente) -> solo podemos usar 1
        self.setCentralWidget(lblEtiqueta)


        # mostramos la ventana
        self.show() # para que se vea a pantalla

# creamos un objeto de instancia qapplication
aplicacion = QApplication(sys.argv) # sys.argv -> unimos la aplicacion con el sistema operativo

# creamos un objeto de la ventana
ventana = VentanaPrincipal()

# ejecutamos la union?
aplicacion.exec()