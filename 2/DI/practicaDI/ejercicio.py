import sys
from PyQt6.QtCore import QSize, Qt, QAbstractListModel
from PyQt6.QtGui import QPixmap, QIcon
from PyQt6.QtWidgets import (QApplication, QMainWindow,
                             QLabel, QListWidget, QPushButton, QComboBox, QLineEdit,
                             QRadioButton, QWidget, QVBoxLayout, QHBoxLayout, QGridLayout, QListView)

class MyModel(QAbstractListModel):
    def __init__(self, tasks=None):
        super().__init__()

        # if we don't pass a list, we create an empty one
        self.tasks = tasks or []

    # we implement the methods of the abstract class
    def data(self, index, role):
        '''
        Roles:
            - DisplayRole -> the text to be displayed
            - DecorationRole -> the icon to be displayed
            - EditRole -> the text to be edited
        '''
        if role == Qt.ItemDataRole.DisplayRole:
            # the _ is a convention to say that we don't use the variable
            _, text = self.tasks[index.row()]
            return text

        ''' Para poner color de fondo
        elif role == Qt.ItemDataRole.BackgroundRole:
            state, text = self.tasks[index.row()]
            if state:
                return QColor('green')
            else:
                return QColor('red')
        '''

    def rowCount(self, index):
        return len(self.tasks)


class FiestraPrincipal (QMainWindow):
    def __init__(self):
        super().__init__()

        self.setWindowTitle("Exame 12-12_2022")


        # instancia de widgets
        lblNome = QLabel("Nome")
        lblApelido = QLabel("Apelido")
        lblTratamento = QLabel("Tratamento")
        lblTelefono = QLabel("Teléfono")
        self.txtNome = QLineEdit()
        self.txtApelido = QLineEdit()
        self.txtTratamento = QLineEdit()
        self.txtTelefono = QLineEdit()
        lblFormato = QLabel("Formato")
        cmbFormato = QComboBox()
        cmbFormato.addItem("")
        cmbFormato.addItem("Formato 1")
        cmbFormato.addItem("Formato 2")

        lblDireccionC = QLabel("Dirección de correo")
        txtDireccionC = QLineEdit()

        # para la listview
        # we need a list to store the tasks
        myList = []
        # we need the list view
        self.lstDireccionC = QListView()
        # we need the model, we pass the list to the model
        self.myModel = MyModel(myList)
        # we need to set the model to the list view
        self.lstDireccionC.setModel(self.myModel)
        # we didn't put an especific selection mode, so we have the default one(single)
        # we put the click event in the list view
        self.lstDireccionC.clicked.connect(self.on_editar_pressed)


        # we create the buttons and press events
        btnEngadir = QPushButton("Engadir")
        btnEngadir.clicked.connect(self.on_engadir_pressed)
        btnEngadir.setFixedSize(70,25)
        btnEditar = QPushButton("Editar")
        btnEditar.setFixedSize(70,25)
        btnBorrar = QPushButton("Borrar")
        btnBorrar.setFixedSize(70,25)
        btnPorDefecto = QPushButton("Por Defecto")
        btnPorDefecto.setFixedSize(70,25)

        # we create the 'title' of the radio buttons
        lblFormatoCorreo = QLabel("Formato de correo:")
        # we create the radio buttons with them pressed events
        self.rbtHtml = QRadioButton("HTML")
        self.rbtHtml.toggled.connect(self.on_radioHtml_pressed)
        self.rbtTextoPlano = QRadioButton ("Texto Plano")
        self.rbtTextoPlano.toggled.connect(self.on_radioTextoPlano_pressed)
        self.rbtPersonalizado = QRadioButton ("Personalizado")
        self.rbtPersonalizado.toggled.connect(self.on_radioPersonalizado_pressed)

        # we create the accept and cancel buttons
        btnAceptar = QPushButton("Aceptar")
        btnAceptar.setFixedSize(70,25)
        btnCancelar = QPushButton("Cancelar")
        # the event of the cancel button is to close the window
        btnCancelar.clicked.connect(self.close)
        btnCancelar.setFixedSize(70,25)

        # the main box
        QVBox = QVBoxLayout()
        # we need a horizontal box for the first part of the window
        QHBox = QHBoxLayout()
        QVBox.addLayout(QHBox)
        # we create a grid for the first part of the window
        grid = QGridLayout()
        QHBox.addLayout(grid)

        # we need a vertical box for the correo format
        QVBoxCorreo = QVBoxLayout()
        # we add the widgets to the vertical box
        QVBoxCorreo.addWidget(lblFormatoCorreo)
        QVBoxCorreo.addWidget(self.rbtHtml)
        QVBoxCorreo.addWidget(self.rbtTextoPlano)
        QVBoxCorreo.addWidget(self.rbtPersonalizado)

        # first row
        grid.addWidget(lblNome,0,0)
        grid.addWidget(self.txtNome,0,1)
        grid.addWidget(lblApelido,0,2)
        grid.addWidget(self.txtApelido,0,3)
        # second row
        grid.addWidget(lblTratamento,1,0)
        grid.addWidget(self.txtTratamento,1,1)
        grid.addWidget(lblTelefono,1,2)
        grid.addWidget(self.txtTelefono,1,3)
        # third row
        grid.addWidget(lblFormato,2,0)
        grid.addWidget(cmbFormato,2,1,1,3)
        # fourth row
        grid.addWidget(self.lstDireccionC,3,0,7,3)
        grid.addLayout(QVBoxCorreo,3,3,4,1)
        # 10 row
        # we need a horizontal box
        QHBoxCorreoDirection = QHBoxLayout()
        QHBoxCorreoDirection.addWidget(lblDireccionC)
        QHBoxCorreoDirection.addWidget(txtDireccionC)
        grid.addLayout(QHBoxCorreoDirection,10,0,1,3)

        # horizontal box for the buttons
        QHBoxButtons = QHBoxLayout()
        QHBoxButtons.addWidget(btnEngadir)
        QHBoxButtons.addWidget(btnEditar)
        QHBoxButtons.addWidget(btnBorrar)
        QHBoxButtons.addWidget(btnPorDefecto)
        # we align the buttons to the left
        QHBoxButtons.setAlignment(Qt.AlignmentFlag.AlignLeft)
        # we put a small space between the buttons
        QHBoxButtons.setSpacing(2)
        # add the horizontal box to the vertical box
        QVBox.addLayout(QHBoxButtons)

        # horizontal box for the accept and cancel buttons
        QHBoxAcceptCancel = QHBoxLayout()
        QHBoxAcceptCancel.addWidget(btnCancelar)
        QHBoxAcceptCancel.addWidget(btnAceptar)
        # we align the buttons to the right
        QHBoxAcceptCancel.setAlignment(Qt.AlignmentFlag.AlignRight)
        # we put a small space between the buttons
        QHBoxAcceptCancel.setSpacing(2)
        # add the horizontal box to the vertical box
        QVBox.addLayout(QHBoxAcceptCancel)
        # put the QHBoxAcceptCancel in the final of the row



        conteiner = QWidget()
        conteiner.setLayout(QVBox)
        self.setCentralWidget(conteiner)
        self.show()

    def on_engadir_pressed(self):
        textNome = self.txtNome.text().strip()
        textApelido = self.txtApelido.text().strip()
        textTelefono = self.txtTelefono.text().strip()
        if textNome or textApelido or textTelefono:
            # we add the task to the list, we need to pass a tuple
            # f"{textNome} {textApelido} {textTelefono}" -> to concatenate the strings with a space between them
            self.myModel.tasks.append((False, f"{textNome} {textApelido} {textTelefono}"))
            # we need to emit the signal to update the view
            self.myModel.layoutChanged.emit()
            # we clear the lines edit
            self.txtNome.clear()
            self.txtApelido.clear()
            self.txtTelefono.clear()

    def on_editar_pressed(self):
        # we get the text from the selected indexes
        text = self.myModel.tasks[self.lstDireccionC.currentIndex().row()][1]
        # we split the text in the spaces
        self.txtNome.setText(text.split()[0])
        self.txtApelido.setText(text.split()[1])
        self.txtTelefono.setText(text.split()[2])

    def on_radioHtml_pressed(self):
        if self.rbtHtml.isChecked():
            print("HTML checked")

    def on_radioTextoPlano_pressed(self):
        if self.rbtTextoPlano.isChecked():
            print("Texto Plano checked")

    def on_radioPersonalizado_pressed(self):
        if self.rbtPersonalizado.isChecked():
            print("Personalizado checked")


if __name__=="__main__":

    aplicacion = QApplication(sys.argv)
    fiestra = FiestraPrincipal()

    aplicacion.exec()