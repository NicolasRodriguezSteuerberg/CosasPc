import sys

from PyQt6.QtGui import QColor, QIcon
# importamos del pyqt6 los elementos que nos importa -> ventana principal, boton
from PyQt6.QtWidgets import (
    QApplication, QMainWindow, QVBoxLayout,
    QLineEdit, QHBoxLayout, QTableView, QWidget, QComboBox, QCheckBox
)

from PyQt6.QtCore import Qt, QAbstractTableModel

class ModeloTaboa(QAbstractTableModel):
    def __init__(self, table):
        super().__init__()
        self.table = table

    def rowCount(self, index):
        return len(self.table)

    def columnCount(self, index):
        return len(self.table[0])

    def data(self, index, role):
        if index.isValid() and (role == Qt.ItemDataRole.EditRole or role == Qt.ItemDataRole.DisplayRole):
            return self.table[index.row()][index.column()]

    def setData(self, index, value, role):
        if role == Qt.ItemDataRole.EditRole:
            self.table[index.row()][index.column()] = value
            return True
        return False

    def flags(self, index):
        if index.row() == 0:
            return Qt.ItemFlag.ItemIsEnabled
        return Qt.ItemFlag.ItemIsEnabled | Qt.ItemFlag.ItemIsEditable | Qt.ItemFlag.ItemIsSelectable

# creamos clase que hereda de QMainWindow
class MyView (QMainWindow):
    # iniciamos a ventana
    def __init__(self):
        # llamamos al constructor de la superclase
        super().__init__()

        self.setWindowTitle( "Mi primera ventana con Qt")

        # we create a list
        self.table = [
            ["Name","DNI","Gender", "Dead?"],
            ["Ana Pérez", "1234Y", "Muller", True],
            ["Paco Pecas", "6789I", "Home", False],
            ["Roque Vila", "4567H", "Home", True],
            ["Luis Yánez", "4321W", "Home", False]
        ]

        containerBox = QVBoxLayout()

        self.tableView = QTableView()
        modelTable = ModeloTaboa(self.table)
        self.tableView.setModel(modelTable)
        self.selection = self.tableView.selectionModel()
        self.selection.selectionChanged.connect(self.on_row_selected)
        containerBox.addWidget(self.tableView)

        # creating a box that contains the fields to fill
        horizontalBox = QHBoxLayout()
        # creating the widgets of the horizontal box
        self.txtName = QLineEdit("Nome")
        txtDni = QLineEdit()
        cmbGender = QComboBox()
        chkDead = QCheckBox("Muerto?")
        # adding the items to the combo box
        cmbGender.addItems(["Home", "Muller", "Outros"])
        # adding the widgets to the horizontal box
        horizontalBox.addWidget(self.txtName)
        horizontalBox.addWidget(txtDni)
        horizontalBox.addWidget(cmbGender)
        containerBox.addLayout(horizontalBox)

        # convert the containerBox into a widget
        widget = QWidget()
        widget.setLayout(containerBox)

        self.setCentralWidget(widget)

        self.setFixedSize(400, 300)
        # mostramos la ventana
        self.show() # para que se vea a pantalla

    def on_row_selected(self):
        index = self.tableView.selectedIndexes()
        print(index)
        self.txtName.setText(self.table[index[0].row()][0])


if __name__ == "__main__":
    # creamos un objeto de instancia qapplication
    aplicacion = QApplication(sys.argv) # sys.argv -> unimos la aplicacion con el sistema operativo
    # creamos un objeto de la ventana
    ventana = MyView()
    # ejecutamos la union?
    aplicacion.exec()