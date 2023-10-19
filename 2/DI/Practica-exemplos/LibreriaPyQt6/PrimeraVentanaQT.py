import sys

# importamos del pyqt6 los elementos que nos importa -> ventana principal, boton
from PyQt6.QtWidgets import QApplication, QMainWindow, QPushButton, QLabel, QVBoxLayout, QWidget
from PyQt6.QtGui import QPixmap

# creamos clase que heread de QMainWindow
class VentanaPrincipal (QMainWindow):
    # iniciamos a ventana
    def __init__(self):
        # llamamos al constructor de la superclase
        super().__init__()

        self.setWindowTitle( "Mi primera ventana con Qt")
        self.setFixedSize(600,500)

        # creamos lo que quereamos poner en la ventana:
        lblEtiqueta = QLabel ("Hola :)")
        # usando el self hago que sea una variable de la clase VentanaPrincipal y poder usarla en otros métodos, si no, sería una variable temporal
        self.lblEtiqueta2 = QLabel("No quiero cambiar nunca")

        # solo se puede poner imagenes jpg?
        lblEtiqueta.setPixmap(QPixmap("dino.jpg"))

        # lo pone en el centro (solo verticalmente) -> solo podemos usar 1
        # self.setCentralWidget(lblEtiqueta)

        # creamos un objeto
        btnSumar = QPushButton("Cambia la etiqueta pulsandome")
        btnSumar.clicked.connect(self.btnCambioEtiqueta)

        # usamos una box vertical para añadir varias cosas
        caixaV = QVBoxLayout()
        caixaV.addWidget(lblEtiqueta)
        caixaV.addWidget(self.lblEtiqueta2)
        caixaV.addWidget(btnSumar)

        container = QWidget()
        container.setLayout(caixaV)

        self.setCentralWidget(container)

        # mostramos la ventana
        self.show() # para que se vea a pantalla

    def btnCambioEtiqueta(self):
        self.lblEtiqueta2.setText("Ahora he cambiado por tu culpa")

if __name__ == "__main__":
    # creamos un objeto de instancia qapplication
    aplicacion = QApplication(sys.argv) # sys.argv -> unimos la aplicacion con el sistema operativo
    # creamos un objeto de la ventana
    ventana = VentanaPrincipal()
    # ejecutamos la union?
    aplicacion.exec()

