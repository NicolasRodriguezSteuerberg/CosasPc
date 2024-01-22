import sys

from PyQt6.QtGui import QColor, QIcon
# importamos del pyqt6 los elementos que nos importa -> ventana principal, boton
from PyQt6.QtWidgets import (QApplication, QMainWindow, QPushButton, QLabel,
                             QVBoxLayout, QWidget, QLineEdit, QListView, QHBoxLayout)
from PyQt6.QtCore import Qt, QAbstractListModel

class ModeloTaboa(QAbstractListModel):
    


# creamos clase que hereda de QMainWindow
class MyView (QMainWindow):
    # iniciamos a ventana
    def __init__(self):
        # llamamos al constructor de la superclase
        super().__init__()

        self.setWindowTitle( "Mi primera ventana con Qt")

        # we create a list
        datos = [
            [1,3,5],
            [3,8,7],
            [-2,3,1],
            [6,-3,-4],
            [4,5,5]
        ]

        twTaboa = QTableView()

        self.setCentralWidget(twTaboa)

        self.setFixedSize(400, 300)
        # mostramos la ventana
        self.show() # para que se vea a pantalla


if __name__ == "__main__":
    # creamos un objeto de instancia qapplication
    aplicacion = QApplication(sys.argv) # sys.argv -> unimos la aplicacion con el sistema operativo
    # creamos un objeto de la ventana
    ventana = MyView()
    # ejecutamos la union?
    aplicacion.exec()