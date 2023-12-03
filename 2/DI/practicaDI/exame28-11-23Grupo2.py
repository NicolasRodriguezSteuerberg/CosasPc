import sys
from PyQt6.QtCore import QSize, Qt, QAbstractListModel
from PyQt6.QtGui import QPixmap
from PyQt6.QtWidgets import (QApplication, QMainWindow,
                             QLabel, QListWidget, QPushButton, QComboBox,  QLineEdit,
                             QRadioButton, QVBoxLayout, QHBoxLayout, QWidget, QGridLayout, QListView)

class PersonasModelo(QAbstractListModel):

    def __init__(self, personas=None):
        super().__init__()
        self.personas = personas or []

    def data(self, index, role):
        if role == Qt.ItemDataRole.DisplayRole:
            tratamento, _, _, _ = self.personas[index.row()]
            _, nome, _, _ = self.personas[index.row()]
            _, _, apelido, _ = self.personas[index.row()]
            _, _, _, email = self.personas[index.row()]
            return tratamento + " , " + nome + " , " + apelido + " , " + email

    def rowCount(self, indice):
        return len(self.personas)



class FiestraPrincipal (QMainWindow):
    def __init__(self):
        super().__init__()

        self.setWindowTitle("Exame 12-12_2022")



        lblNome = QLabel("Nome")
        lblApelido = QLabel("Apelido")
        lblTratamento = QLabel("Tratamento")
        lblUsuario = QLabel("Usuario")
        self.txtNome = QLineEdit()
        self.txtApelido = QLineEdit()
        self.txtTratamento = QLineEdit()
        self.txtUsuario = QLineEdit()
        lblFormato = QLabel("Formato")
        self.cmbFormato = QComboBox()

        lblDireccionC = QLabel("Dirección de correo")
        self.txtDireccionC = QLineEdit()


        btnEngadir = QPushButton("Engadir")
        btnEngadir.pressed.connect(self.on_btnEngadir_pressed)
        btnEditar = QPushButton("Editar")
        btnBorrar = QPushButton("Borrar")
        btnBorrar.pressed.connect(self.on_btnBorrar_pressed)
        btnPorDefecto = QPushButton("Por Defecto")

        lblFormatoC = QLabel("Formato de correo:")
        self.rbtHtml = QRadioButton("HTML")
        self.rbtHtml.toggled.connect(self.on_radioHTML_toggled)
        self.rbtTextoPlano = QRadioButton ("Texto Plano")
        self.rbtTextoPlano.toggled.connect(self.on_radioTextoPlano_toggled)
        self.rbtPersonalizado = QRadioButton ("Personalizado")
        self.rbtPersonalizado.toggled.connect(self.on_radioPersonalizado_toggled)

        btnAceptar = QPushButton("Aceptar")
        btnCancelar = QPushButton("Cancelar")

        # CAJA VERTICAL
        boxV = QVBoxLayout()

        grid = QGridLayout()

        # first row
        grid.addWidget(lblNome, 0, 0, 1, 1)
        grid.addWidget(lblTratamento, 0, 2, 1, 1)
        # second row
        grid.addWidget(self.txtNome, 1, 0, 1, 2)
        grid.addWidget(self.txtTratamento, 1, 2, 1, 2)
        # third row
        grid.addWidget(lblApelido, 2, 0, 1, 1)
        grid.addWidget(lblUsuario, 2, 2, 1, 1)
        # fourth row
        grid.addWidget(self.txtApelido, 3, 0, 1, 2)
        grid.addWidget(self.txtUsuario, 3, 2, 1, 2)

        boxV.addLayout(grid)

        # CAJA HORIZONTAL (FORMATO)
        boxH = QHBoxLayout()
        boxH.addWidget(lblFormato)
        # combo box
        # index 0
        self.cmbFormato.addItem("")
        # index 1
        self.cmbFormato.addItem("HTML")
        # index 2
        self.cmbFormato.addItem("Texto Plano")
        # index 3
        self.cmbFormato.addItem("Personalizado")
        # si no lo pongo se queda mal puesto
        self.cmbFormato.setFixedSize(430, 25)
        boxH.addWidget(self.cmbFormato)
        boxV.addLayout(boxH)

        # CAJA HORIZONTAL (email, lista, botones)
        boxH2 = QHBoxLayout()
        # CAJA VERTICAL (email, lista)
        boxV2 = QVBoxLayout()
        boxH2_1 = QHBoxLayout() # email
        boxH2_2 = QHBoxLayout() # lista
        # CAJA VERTICAL (botones)
        boxV3 = QVBoxLayout()

        # caja vertical (email, lista)
        boxH2_1.addWidget(lblDireccionC)
        boxH2_1.addWidget(self.txtDireccionC)
        # boxV2.addWidget(self.listView)
        boxV2.addLayout(boxH2_1)

        # lista
        personList = [
            ("Fisio", "Gabriel", "Perez", "gperez@daniel.com"),
            ("Neuro", "Alan", "Garcia", "alan@hotmail.com")
        ]
        self.myModel = PersonasModelo(personList)
        self.listView = QListView()
        self.listView.setModel(self.myModel)
        self.listView.setSelectionMode(QListView.SelectionMode.SingleSelection)
        self.listView.setFixedSize(395, 200)
        # añadimos la lista
        boxH2_2.addWidget(self.listView)
        boxV2.addLayout(boxH2_2)
        boxH2.addLayout(boxV2)

        # caja vertical (botones)
        boxV3.addWidget(btnEngadir)
        boxV3.addWidget(btnEditar)
        boxV3.addWidget(btnBorrar)
        boxV3.addWidget(btnPorDefecto)
        boxV3.setAlignment(Qt.AlignmentFlag.AlignTop)
        boxH2.addLayout(boxV3)

        boxV.addLayout(boxH2)

        boxV.addWidget(lblFormatoC)
        # box radio buttons
        boxH3 = QHBoxLayout()
        boxH3.addWidget(self.rbtHtml)
        boxH3.addWidget(self.rbtTextoPlano)
        boxH3.addWidget(self.rbtPersonalizado)
        boxH3.setAlignment(Qt.AlignmentFlag.AlignLeft)
        boxV.addLayout(boxH3)

        # botones aceptar y cancelar
        boxH4 = QHBoxLayout()
        boxH4.addWidget(btnAceptar)
        boxH4.addWidget(btnCancelar)
        boxH4.setAlignment(Qt.AlignmentFlag.AlignRight)
        boxV.addLayout(boxH4)




        conteiner = QWidget()
        conteiner.setLayout(boxV)
        self.setCentralWidget(conteiner)
        self.show()


    def on_radioHTML_toggled(self):
        if self.rbtHtml.isChecked():
            self.cmbFormato.setCurrentIndex(1)

    def on_radioTextoPlano_toggled(self):
        if self.rbtTextoPlano.isChecked():
            self.cmbFormato.setCurrentIndex(2)

    def on_radioPersonalizado_toggled(self):
        if self.rbtPersonalizado.isChecked():
            self.cmbFormato.setCurrentIndex(3)

    def on_btnEngadir_pressed(self):
        persona = []
        persona.append(self.txtTratamento.text())
        persona.append(self.txtNome.text())
        persona.append(self.txtApelido.text())
        persona.append(self.txtDireccionC.text())

        if (persona[0] != "" and persona[1] != "" and persona[2] != "" and persona[3] != ""):
            self.myModel.personas.append(persona)
            self.myModel.layoutChanged.emit()
            self.txtNome.setText("")
            self.txtApelido.setText("")
            self.txtTratamento.setText("")
            self.txtDireccionC.setText("")
            self.txtUsuario.setText("")

    def on_btnBorrar_pressed(self):
        del self.myModel.personas[self.listView.currentIndex().row()]
        self.myModel.layoutChanged.emit()







if __name__=="__main__":

    aplicacion = QApplication(sys.argv)
    fiestra = FiestraPrincipal()

    aplicacion.exec()