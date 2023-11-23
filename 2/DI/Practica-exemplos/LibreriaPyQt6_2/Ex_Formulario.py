import sys

from PyQt6.QtCore import Qt, QAbstractListModel
from PyQt6.QtGui import QColor, QIcon, QPixmap
# importamos del pyqt6 los elementos que nos importa -> ventana principal, boton
from PyQt6.QtWidgets import (QMainWindow, QApplication, QVBoxLayout, QWidget,
                             QHBoxLayout, QGridLayout, QLabel, QCheckBox, QListView, QPushButton, QSizePolicy,
                             QComboBox, QFrame)
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
        listView = QListView()
        listView.setModel(MyModel())

        # create the widgets of the third column
        # create 8 buttons
        btn1 = QPushButton("Engadir a pista a reproducir")
        btnUp = QPushButton("Subir na lista")
        btnDown = QPushButton("Baixar na lista")
        btnSkip = QPushButton("Saltar")
        comboBoxSkip = QComboBox()
        btnOpen = QPushButton("Abrir fichero")
        btnReproduce = QPushButton("Reproducir fichero")
        btnSave = QPushButton("Gardar como")
        btnDelete = QPushButton("Eliminar pista")


        # putting the widgets in the grid
        # first column
        firstGrid.addWidget(image)
        firstGrid.addWidget(checkBoxAnimated, 1, 0, 1, 1)
        # second column
        firstGrid.addWidget(listView, 0, 1, 8, 4)
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
        btnRythm = QPushButton("Ritmo")
        btnVolume = QPushButton("Volume")
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
        reproductionFrame = QFrame()
        # create a horizontal box for the frame
        reproductionBoxH = QHBoxLayout()
        # set title to the frame
        reproductionFrame.setWindowTitle("Opcións de reproducción")
        reproductionFrame.setFrameShape(QFrame.Shape.Box)

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



        # we create a container widget
        container = QWidget()
        container.setLayout(boxV)

        # we set the container as the central widget of the window
        self.setCentralWidget(container)
         # we show the window
        self.show()



if __name__ == "__main__":
    # creamos un objeto de instancia qapplication
    aplicacion = QApplication(sys.argv)  # sys.argv -> unimos la aplicacion con el sistema operativo
    # creamos un objeto de la ventana
    ventana = View()
    # ejecutamos la union?
    aplicacion.exec()