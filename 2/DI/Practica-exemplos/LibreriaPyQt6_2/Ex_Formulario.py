import sys

from PyQt6.QtCore import Qt, QAbstractListModel
from PyQt6.QtGui import QColor, QIcon, QPixmap
# importamos del pyqt6 los elementos que nos importa -> ventana principal, boton
from PyQt6.QtWidgets import (QMainWindow, QApplication, QVBoxLayout, QWidget,
                             QHBoxLayout, QGridLayout, QLabel, QCheckBox, QListView, QPushButton, QSizePolicy,
                             QComboBox, QFrame, QGroupBox, QSlider, QRadioButton, QLineEdit)
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
        elif role == Qt.ItemDataRole.DecorationRole:
            state, _ = self.tasks[index.row()]
            if state:
                return QIcon('icons/check.png')
            else:
                return QIcon('icons/uncheck.png')

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

class View(QMainWindow):
    def __init__(self):
        # call the constructor of the superclass
        super().__init__()
        # set the title of the window
        self.setWindowTitle("Exame 15-12-2018")
        # set the size of the window
        self.resize(800, 300)

        # we create a vertical box
        boxV = QVBoxLayout()
        # we create the 2 horizontal boxes that will be inside the vertical box
        boxH1 = QHBoxLayout()
        boxH2 = QHBoxLayout()
        # we add the horizontal boxes to the vertical box
        boxV.addLayout(boxH1)
        boxV.addLayout(boxH2)

        # create a grid layout for the first horizontal box
        firstGrid = QGridLayout()
        # creating the widgets of the first column
        # create a image
        image = QLabel("Imagen")
        # set the image
        image.setPixmap(QPixmap("icons/cd-case.svg"))
        # create the checkBox animado
        checkBoxAnimated = QCheckBox("Animado")

        # creating the widgets of the second column
        # Create a listView
        # we need to create a list
        taskList = []
        self.listView = QListView()
        self.myModel = MyModel(taskList)
        self.listView.setModel(self.myModel)
        # putting multiple selection
        self.listView.setSelectionMode(QListView.SelectionMode.ExtendedSelection)

        # create the widgets of the third column
        # create 8 buttons
        btn1 = QPushButton("Engadir a pista a reproducir")
        btn1.clicked.connect(self.on_btn1_clicked)
        btnUp = QPushButton("Subir na lista")
        btnDown = QPushButton("Baixar na lista")
        btnSkip = QPushButton("Saltar")
        # combobox
        comboBoxSkip = QComboBox()
        # add the items to the combobox, i can add them one by one or all at once
        comboBoxSkip.addItems(["1", "2", "3", "4", "5", "6", "7", "8"])
        btnOpen = QPushButton("Abrir fichero")
        btnReproduce = QPushButton("Reproducir fichero")
        btnSave = QPushButton("Gardar como")
        btnDelete = QPushButton("Eliminar pista")
        btnDelete.clicked.connect(self.on_deleteButton)


        # putting the widgets in the grid
        # first column
        firstGrid.addWidget(image)
        firstGrid.addWidget(checkBoxAnimated, 1, 0, 1, 1)
        # second column
        firstGrid.addWidget(self.listView, 0, 1, 8, 4)
        # third column
        firstGrid.addWidget(btn1, 0, 5, 1, 2)
        firstGrid.addWidget(btnUp, 1, 5, 1, 2)
        firstGrid.addWidget(btnDown, 2, 5, 1, 2)
        firstGrid.addWidget(btnSkip, 3, 5, 1, 1)
        firstGrid.addWidget(comboBoxSkip, 3, 6, 1, 1)
        firstGrid.addWidget(btnOpen, 4, 5, 1, 2)
        firstGrid.addWidget(btnReproduce, 5, 5, 1, 2)
        firstGrid.addWidget(btnSave, 6, 5, 1, 2)
        firstGrid.addWidget(btnDelete, 7, 5, 1, 2)
        # we add the grid to the first horizontal box
        boxH1.addLayout(firstGrid)

        # create a vertical box for the second horizontal box
        boxVGrid = QVBoxLayout()
        # create a grid layout for the second horizontal box
        secondGrid = QGridLayout()
        # create the widgets of the first column
        # create the 5 labels
        lblAudio = QLabel("Son")
        lblRythm = QLabel("Ritmo")
        lblVolume = QLabel("Volume")
        lblFormat = QLabel("Formato")
        lblAudioOut = QLabel("Saída de audio")
        # create the widgets of the second column
        # create the 3 comboBox and 2 buttons
        comboBoxAudio = QComboBox()
        btnRythm = QSlider(Qt.Orientation.Horizontal)
        btnVolume = QSlider(Qt.Orientation.Horizontal)
        comboBoxFormat = QComboBox()
        comboBoxAudioOut = QComboBox()

        # putting the widgets in the grid
        # first column
        secondGrid.addWidget(lblAudio)
        secondGrid.addWidget(lblRythm, 1, 0, 1, 1)
        secondGrid.addWidget(lblVolume, 2, 0, 1, 1)
        secondGrid.addWidget(lblFormat, 3, 0, 1, 1)
        secondGrid.addWidget(lblAudioOut, 4, 0, 1, 1)
        # second column
        secondGrid.addWidget(comboBoxAudio, 0, 1, 1, 1)
        secondGrid.addWidget(btnRythm, 1, 1, 1, 1)
        secondGrid.addWidget(btnVolume, 2, 1, 1, 1)
        secondGrid.addWidget(comboBoxFormat, 3, 1, 1, 1)
        secondGrid.addWidget(comboBoxAudioOut, 4, 1, 1, 1)
        # we add the grid to the vertical box
        boxVGrid.addLayout(secondGrid)
        # we add the vertical box to the second horizontal box
        boxH2.addLayout(boxVGrid)


        # create a frame for the second horizontal box
        reproductionFrame = QGroupBox("Opcións de reproducción")
        # create a horizontal box for the frame
        reproductionBoxH = QHBoxLayout()
        # reproductionFrame.setFrameShape(QFrame.Shape.Box)

        # set the layout of the frame
        reproductionFrame.setLayout(reproductionBoxH)
        # create 2 vertical boxes for the reproductionBoxH
        reproductionBoxV1 = QVBoxLayout()
        reproductionBoxV2 = QVBoxLayout()
        # add the vertical boxes to the horizontal box
        reproductionBoxH.addLayout(reproductionBoxV1)
        reproductionBoxH.addLayout(reproductionBoxV2)

        # create the widgets of the first vertical box (frame)
        # create 3 checkBox
        checkBoxAsincrono = QCheckBox("Asíncrono")
        checkBoxName = QCheckBox("É nome de ficheriro")
        checkBoxXML = QCheckBox("XML persistente")
        # add the widgets to the first vertical box
        reproductionBoxV1.addWidget(checkBoxAsincrono)
        reproductionBoxV1.addWidget(checkBoxName)
        reproductionBoxV1.addWidget(checkBoxXML)

        # create the widgets of the second vertical box (frame)
        # create 3 checkBox
        checkBoxFilter = QCheckBox("Filtar antes de reproducir")
        checkBoxXML2 = QCheckBox("É XML")
        checkBoxNPL = QCheckBox("Reproducir NPL")
        # add the widgets to the second vertical box
        reproductionBoxV2.addWidget(checkBoxFilter)
        reproductionBoxV2.addWidget(checkBoxXML2)
        reproductionBoxV2.addWidget(checkBoxNPL)

        # add the frame to the second horizontal box
        boxH2.addWidget(reproductionFrame)

        # extra -> to remember how checkbuttons and radiobuttons work
        # create a horizontal box for the checkbuttons
        caixaH = QHBoxLayout()
        # create a vertical box for the checkbuttons
        caixaV = QVBoxLayout()
        # put the vertical box inside the horizontal box
        caixaH.addLayout(caixaV)
        # create the checkbuttons
        self.checkButton1 = QCheckBox("Check 1")
        self.checkButton1.toggled.connect(self.on_checkButton_toggled)
        # 2
        self.checkButton2 = QCheckBox("Check 2")
        self.checkButton2.toggled.connect(self.on_checkButton2_toggled)
        # we add the checkbuttons to the vertical box
        caixaV.addWidget(self.checkButton1)
        caixaV.addWidget(self.checkButton2)
        # create a second vertical box for the radio buttons
        caixaV2 = QVBoxLayout()
        # create the radio buttons
        self.radioButton1 = QRadioButton("Radio 1")
        self.radioButton1.toggled.connect(self.on_radioButton_toggled)
        # 2
        self.radioButton2 = QRadioButton("Radio 2")
        self.radioButton2.toggled.connect(self.on_radioButton2_toggled)
        # add the radio buttons to the second vertical box
        caixaV2.addWidget(self.radioButton1)
        caixaV2.addWidget(self.radioButton2)
        # add the second vertical box to the horizontal box
        caixaH.addLayout(caixaV2)
        # add the horizontal box to the vertical box
        boxV.addLayout(caixaH)

        # create a QLineEdit
        self.lineEdit = QLineEdit()
        # we connect the line edit to the method
        # if we press enter, we add the text to the list view
        self.lineEdit.editingFinished.connect(self.on_btn1_clicked)
        # we add the line edit to the vertical box
        boxV.addWidget(self.lineEdit)


        # we create a container widget
        container = QWidget()
        container.setLayout(boxV)

        # we set the container as the central widget of the window
        self.setCentralWidget(container)
         # we show the window
        self.show()

    def on_btn1_clicked(self):
        text = self.lineEdit.text().strip() # strip() -> remove the spaces at the beginning and at the end
        # if the text is empty, we don't add it to the list
        if text:
            # we add the 'song' to the list
            self.myModel.tasks.append((False, text))
            # we update the list
            self.myModel.layoutChanged.emit()
            self.lineEdit.clear()

    def on_deleteButton(self):
        indexes = self.listView.selectedIndexes()
        if indexes:
            for index in sorted(indexes, reverse=True):
                # tasks is the list of tuples of the model
                del self.myModel.tasks[index.row()]
            self.myModel.layoutChanged.emit()
            self.listView.clearSelection()

    def on_checkButton_toggled(self):
        if self.checkButton1.isChecked():
            print("Check 1 checked")
        else:
            print("Check 1 unchecked")

    def on_checkButton2_toggled(self):
        if self.checkButton2.isChecked():
            print("Check 2 checked")
        else:
            print("Check 2 unchecked")

    def on_radioButton_toggled(self):
        if self.radioButton1.isChecked():
            print("Radio 1 checked")
        else:
            print("Radio 1 unchecked")

    def on_radioButton2_toggled(self):
        if self.radioButton2.isChecked():
            print("Radio 2 checked")
        else:
            print("Radio 2 unchecked")

if __name__ == "__main__":
    # creamos un objeto de instancia qapplication
    aplicacion = QApplication(sys.argv)  # sys.argv -> unimos la aplicacion con el sistema operativo
    # creamos un objeto de la ventana
    ventana = View()
    # ejecutamos la union?
    aplicacion.exec()