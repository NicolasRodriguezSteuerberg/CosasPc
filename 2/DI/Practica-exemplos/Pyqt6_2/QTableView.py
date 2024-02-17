import sys

from PyQt6.QtGui import QColor
# importamos del pyqt6 los elementos que nos importa -> ventana principal, boton
from PyQt6.QtWidgets import (
    QApplication, QMainWindow, QVBoxLayout,
    QLineEdit, QHBoxLayout, QTableView, QWidget, QComboBox, QCheckBox
)

from PyQt6.QtCore import Qt, QAbstractTableModel


class ModeloTaboa(QAbstractTableModel):
    """
    Clase que hereda de QAbstractTableModel para crear un modelo de tabla
    A partir de esta clase se creará un modelo de tabla que se usará para cambiar el estilo de la tabla
    """
    def __init__(self, table, headerData):
        super().__init__()
        self.table = table
        self.headerData = headerData

    def rowCount(self, index):
        return len(self.table)

    def columnCount(self, index):
        return len(self.table[0])

    # to fill the table
    def data(self, index, role):
        if index.isValid():
            if role == Qt.ItemDataRole.EditRole or role == Qt.ItemDataRole.DisplayRole:
                return self.table[index.row()][index.column()]
            ''' color texto
            if role == Qt.ItemDataRole.ForegroundRole:
                if self.table[index.row()][3]:
                    return QColor(255,0,0)
            '''
            # color de fondo
            if role == Qt.ItemDataRole.BackgroundRole:
                if self.table[index.row()][2] == "Muller":
                    if self.table[index.row()][3]:
                        return QColor(255,80,150)
                    else:
                        return QColor(255,150,203)
                else:
                    if self.table[index.row()][3]:
                        return QColor(0,150,255)
                    else:
                        return QColor(0,200,255)

    # to edit the table
    def setData(self, index, value, role):
        if role == Qt.ItemDataRole.EditRole:
            self.table[index.row()][index.column()] = value
            return True
        return False

     # esta funcion es para que se pueda editar la tabla (por defecto no se puede)
    def flags(self, index):
        return Qt.ItemFlag.ItemIsEnabled | Qt.ItemFlag.ItemIsEditable | Qt.ItemFlag.ItemIsSelectable

    def headerData(self, section, orientation, role):
        # para añadir la cabezera
        if role == Qt.ItemDataRole.DisplayRole:
            if orientation == Qt.Orientation.Horizontal:
                return self.headerData[0][section]
            ''' para que se ponga a la izquierda numeros
            elif orientation == Qt.Orientation.Vertical:
                return section + 1
            '''

# creamos clase que hereda de QMainWindow
class MyView (QMainWindow):
    # iniciamos a ventana
    def __init__(self):
        # llamamos al constructor de la superclase
        super().__init__()

        self.setWindowTitle( "Mi primera ventana con Qt")

        # we create a list
        self.table = [
            ["Ana Pérez", "1234Y", "Muller", True],
            ["Paco Pecas", "6789I", "Home", False],
            ["Roque Vila", "4567H", "Home", True],
            ["Luis Yánez", "4321W", "Home", False]
        ]
        headerData = [
            ["Name", "DNI", "Gender", "Dead?"]
        ]

        containerBox = QVBoxLayout()

        # create the table
        self.tableView = QTableView()
        # create the model of the table (class ModeloTaboa)
        modelTable = ModeloTaboa(self.table, headerData)
        # set the model to the table
        self.tableView.setModel(modelTable)

        # to select the entire row
        self.tableView.setSelectionBehavior(QTableView.SelectionBehavior.SelectRows)
        # to select only one row
        self.tableView.setSelectionMode(QTableView.SelectionMode.SingleSelection)
        # to do the selection
        self.selection = self.tableView.selectionModel()
        self.selection.selectionChanged.connect(self.on_row_selected)

        # add the table to the container box
        containerBox.addWidget(self.tableView)

        # creating a box that contains the fields to fill
        horizontalBox = QHBoxLayout()
        # creating the widgets of the horizontal box
        self.txtName = QLineEdit()
        self.txtDni = QLineEdit()
        self.cmbGender = QComboBox()
        self.chkDead = QCheckBox("Falecido")
        # adding the items to the combo box
        self.cmbGender.addItems(["Home", "Muller", "Outros"])
        # adding the widgets to the horizontal box
        horizontalBox.addWidget(self.txtName)
        horizontalBox.addWidget(self.txtDni)
        horizontalBox.addWidget(self.cmbGender)
        horizontalBox.addWidget(self.chkDead)
        containerBox.addLayout(horizontalBox)

        # convert the containerBox into a widget
        widget = QWidget()
        widget.setLayout(containerBox)

        # init the selection
        self.tableView.selectRow(0)
        # call the function to fill the fields
        self.on_row_selected()

        self.setCentralWidget(widget)

        self.setFixedSize(400, 300)
        # mostramos la ventana
        self.show() # para que se vea a pantalla

    # function to fill the fields with the selected row
    def on_row_selected(self):

        index = self.tableView.selectedIndexes()
        if not index==[]:
            self.txtName.setText(self.table[index[0].row()][0])
            self.txtDni.setText(self.table[index[0].row()][1])
            self.cmbGender.setCurrentText(self.table[index[0].row()][2])
            self.chkDead.setChecked(self.table[index[0].row()][3])


if __name__ == "__main__":
    # creamos un objeto de instancia qapplication
    aplicacion = QApplication(sys.argv) # sys.argv -> unimos la aplicacion con el sistema operativo
    # creamos un objeto de la ventana
    ventana = MyView()
    # ejecutamos la union?
    aplicacion.exec()