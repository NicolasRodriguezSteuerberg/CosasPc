import sys

from PyQt6.QtWidgets import (QApplication, QMainWindow, QPushButton, QLabel,QCheckBox,
                             QVBoxLayout, QHBoxLayout, QWidget, QListView, QLineEdit,
                             QComboBox, QGridLayout, QSlider, QFrame)
from PyQt6.QtCore import Qt, QAbstractListModel
from PyQt6.QtGui import QPixmap



class FiestraPrincipal (QMainWindow):
    def __init__(self):
        super().__init__()

        self.setWindowTitle( "Exemplo interface son")
        self.setFixedSize(800,400)

        caixaV = QVBoxLayout()
        caixaH1 = QHBoxLayout()
        caixaV.addLayout(caixaH1)
        caixaH2 = QHBoxLayout()
        caixaV.addLayout(caixaH2)
        caixa3 = QVBoxLayout()
        caixa3.setAlignment(Qt.AlignmentFlag.AlignTop)
        caixaH1.addLayout(caixa3)
        lblIconoCd = QLabel ()
        lblIconoCd.setPixmap(QPixmap("ico_cd.png"))
        caixa3.addWidget(lblIconoCd)
        chkAnimado = QCheckBox("Animado")
        caixa3.addWidget(chkAnimado)
        lswLista = QListView()
        lswLista.setFixedSize(300,200)
        caixaH1.addWidget(lswLista)

        caixa4 = QVBoxLayout()
        caixaH1.addLayout(caixa4)
        btnEngadirLista =QPushButton("Engadir Lista a reproducir")
        caixa4.addWidget(btnEngadirLista)
        btnSubirLista = QPushButton("Subir na lista")
        caixa4.addWidget(btnSubirLista)
        btnBaixarLista = QPushButton("Baixar na lista")
        caixa4.addWidget(btnBaixarLista)
        grid = QGridLayout()
        btnSaltar = QPushButton("Saltar")
        grid.addWidget(btnSaltar)
        caixa4.addLayout(grid)
        cmbSaltar = QComboBox()
        grid.addWidget(cmbSaltar,0,1,1,2)
        btnAbrirFicheiro = QPushButton("Abrir Ficheiro...")
        caixa4.addWidget(btnAbrirFicheiro)
        btnReproducirFicheiro = QPushButton("Reproducir Ficheiro")
        caixa4.addWidget(btnReproducirFicheiro)
        btnGardar = QPushButton("Gardar como...")
        caixa4.addWidget(btnGardar)
        btnEliminarPista = QPushButton("EliminarPista")
        caixa4.addWidget(btnEliminarPista)

        grid2 = QGridLayout()
        caixaH2.addLayout(grid2)
        lblSon = QLabel("Son:")
        lblRitmo = QLabel("Ritmo:")
        lblVolume = QLabel("Volume:")
        lblFormato = QLabel("Formato:")
        lblSaida = QLabel("Saída de audio:")
        grid2.addWidget(lblSon,0,0,1,1)
        grid2.addWidget(lblRitmo, 1, 0, 1, 1)
        grid2.addWidget(lblVolume, 2, 0, 1, 1)
        grid2.addWidget(lblFormato, 3, 0, 1, 1)
        grid2.addWidget(lblSaida,4, 0, 1, 1)

        cmbSon = QComboBox()
        grid2.addWidget(cmbSon,0,1,1,2)
        sldRitmo = QSlider(Qt.Orientation.Horizontal)
        grid2.addWidget(sldRitmo, 1, 1, 1, 2)
        sldVolume = QSlider(Qt.Orientation.Horizontal)
        grid2.addWidget(sldVolume, 2, 1, 1, 2)
        cmbFormato = QComboBox()
        grid2.addWidget(cmbFormato, 3, 1, 1, 2)
        cmbSaida = QComboBox()
        grid2.addWidget(cmbSaida, 4, 1, 1, 2)

        caixa5 = QHBoxLayout()
        frmOpReproduccion = QFrame()
        frmOpReproduccion.setFrameStyle(QFrame.Shape.Box)

        frmOpReproduccion.setLayout(caixa5)
        frmOpReproduccion.setWindowTitle("Opcións de reproducción")
        caixaH2.addWidget(frmOpReproduccion)
        caixa6 = QVBoxLayout()
        caixa7 = QVBoxLayout()
        caixa5.addLayout(caixa6)
        caixa5.addLayout(caixa7)
        chkAsincrono = QCheckBox ("Asíncrono")
        chkENome = QCheckBox("É nome de ficheiro")
        chkXml = QCheckBox("XML persistente")
        caixa6.addWidget(chkAsincrono)
        caixa6.addWidget(chkENome)
        caixa6.addWidget(chkXml)

        chkFiltrar = QCheckBox("Filtrar antes de reproducir")
        chkEXml = QCheckBox("É XML")
        chkReproduccion = QCheckBox("Reproducción NPL")
        caixa7.addWidget(chkFiltrar)
        caixa7.addWidget(chkEXml)
        caixa7.addWidget(chkReproduccion)

        container = QWidget()
        container.setLayout(caixaV)
        self.setCentralWidget (container)


        self.show()




if __name__=="__main__":
    aplicacion = QApplication(sys.argv)
    fiestra = FiestraPrincipal()
    aplicacion.exec()