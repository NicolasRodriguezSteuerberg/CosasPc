import sys
from PyQt6.QtCore import QSize, Qt
from PyQt6.QtGui import QPixmap
from PyQt6.QtWidgets import (QApplication, QMainWindow,
                             QLabel, QCheckBox, QTextEdit, QPushButton, QComboBox, QSlider,
                             QGroupBox, QDial, QGridLayout, QWidget, QVBoxLayout, QLineEdit, QHBoxLayout)



class FiestraPrincipal (QMainWindow):
    def __init__(self):
        super().__init__()

        self.setWindowTitle("Exame 14-12_2023")
        self.setFixedSize(800,600)

        boxPrincipal = QVBoxLayout()


        self.tedConsolaOperacions = QTextEdit()
        self.tedConsolaOperacions.setReadOnly(True)
        self.lneOperacionResultado = QLineEdit()

        boxH = QHBoxLayout()
        boVH1 = QVBoxLayout()
        boVH1.addWidget(self.tedConsolaOperacions)
        boVH1.addWidget(self.lneOperacionResultado)
        boxH.addLayout(boVH1)

        boxPrincipal.addLayout(boxH)

        self.cmbMoedaIncial = QComboBox()
        self.cmbMoedaIncial.addItem("Dólar estadounidense")
        self.cmbMoedaIncial.addItem("Euro")
        self.cmbMoedaIncial.addItem("Libra esterlina")
        self.cmbMoedaIncial.addItem("Corona danesa")

        self.cmbMoedaCambio = QComboBox()
        self.cmbMoedaCambio.addItem("Euro")
        self.cmbMoedaCambio.addItem("Dólar estadounidense")
        self.cmbMoedaCambio.addItem("Libra esterlina")
        self.cmbMoedaCambio.addItem("Corona danesa")
        self.lblCambio = QLabel("$0=€0")

        boxHCambio = QHBoxLayout()
        boxHCambio.addWidget(self.cmbMoedaIncial)
        boxHCambio.addWidget(self.cmbMoedaCambio)
        boxHCambio.setSpacing(20)
        boxHCambio.addWidget(self.lblCambio)

        boxPrincipal.addLayout(boxHCambio)


        btnBorrar = QPushButton("Del")
        btnAbreParentese = QPushButton("(")
        btnPechaParentese = QPushButton(")")
        btnModulo = QPushButton("Mod")
        btnLogaritmo = QPushButton("log")
        btnRaiz = QPushButton("V")
        btnPotencia = QPushButton("xY")
        btnUn = QPushButton("1")
        btnUn.pressed.connect(self.on_uno_pressed)
        btnDous = QPushButton("2")
        btnDous.pressed.connect(self.on_dos_pressed)
        btnTres = QPushButton("3")
        btnTres.pressed.connect(self.on_tres_pressed)
        btnCatro = QPushButton("4")
        btnCinco = QPushButton("5")
        btnSeis = QPushButton("6")
        btnSete = QPushButton("7")
        btnOito = QPushButton("8")
        btnNove = QPushButton("9")
        btnCero = QPushButton("0")
        btnSuma = QPushButton("+")
        btnSuma.pressed.connect(self.on_mas_pressed)
        btnResta = QPushButton("-")
        btnMultiplicacion = QPushButton("*")
        btnDivision = QPushButton("/")
        btnIgual = QPushButton("=")
        btnIgual.pressed.connect(self.on_igual_pressed)
        self.lneOperacionResultado.editingFinished.connect(self.on_igual_pressed)
        self.lneOperacionResultado.textChanged.connect(self.on_esIgual_pressed)
        btnComa = QPushButton(",")
        btnPorcentaxe = QPushButton("%")

        btnCtrm = QPushButton("Ctrm")
        btnCtrm.pressed.connect(self.on_cambio_pressed)
        btnDbd = QPushButton("Dbd")
        btnFv = QPushButton("Fv")
        btnMBB = QPushButton("MBB")
        btnPmt = QPushButton("Pmt")
        btnPv = QPushButton("Pv")
        btnTaxa = QPushButton("Taxa")
        btnSln = QPushButton("Sln")
        btnSyd = QPushButton("Syd")
        btnPeriodo = QPushButton("Período")


        cmbEquis = QComboBox()
        cmbEquis.addItem("x")

        boxGrid = QHBoxLayout()

        boxGrid1 = QVBoxLayout()

        gridNumeros = QGridLayout()

        # primera fila
        gridNumeros.addWidget(btnBorrar,0,0,1,1)
        gridNumeros.addWidget(btnAbreParentese, 0, 1, 1, 1)
        gridNumeros.addWidget(btnPechaParentese, 0, 2, 1, 1)
        gridNumeros.addWidget(btnModulo, 0, 3, 1, 1)
        gridNumeros.addWidget(btnLogaritmo, 0, 4, 1, 1)

        # segunda fila
        gridNumeros.addWidget(btnSete,1,0,1,1)
        gridNumeros.addWidget(btnOito,1,1,1,1)
        gridNumeros.addWidget(btnNove,1,2,1,1)
        gridNumeros.addWidget(btnDivision,1,3,1,1)
        gridNumeros.addWidget(btnRaiz,1,4,1,1)

        # tercera
        gridNumeros.addWidget(btnCatro,2,0,1,1)
        gridNumeros.addWidget(btnCinco,2,1,1,1)
        gridNumeros.addWidget(btnSeis,2,2,1,1)
        gridNumeros.addWidget(btnMultiplicacion,2,3,1,1)
        gridNumeros.addWidget(btnPotencia,2,4,1,1)

        # cuarta
        gridNumeros.addWidget(btnUn,3,0,1,1)
        gridNumeros.addWidget(btnDous,3,1,1,1)
        gridNumeros.addWidget(btnTres,3,2,1,1)
        gridNumeros.addWidget(btnResta, 3, 3 , 1, 1)
        gridNumeros.addWidget(btnIgual,3,4,2,1)

        # cuarta
        gridNumeros.addWidget(btnCero, 4, 0, 1, 1)
        gridNumeros.addWidget(btnComa,4,1,1,1)
        gridNumeros.addWidget(btnPorcentaxe,4,2,1,1)
        gridNumeros.addWidget(btnSuma,4,3,1,1)

        # segunda parte
        # primera fila
        gridNumeros.addWidget(btnCtrm,0,6,1,2)
        gridNumeros.addWidget(btnDbd,0,8,1,2)
        gridNumeros.addWidget(btnFv,0,10,1,2)

        gridNumeros.addWidget(btnMBB,1,6,1,2)
        gridNumeros.addWidget(btnPmt,1,8,1,2)
        gridNumeros.addWidget(btnPv,1,10,1,2)

        gridNumeros.addWidget(btnTaxa,2,6,1,2)
        gridNumeros.addWidget(btnSln,2,8,1,2)
        gridNumeros.addWidget(btnSyd,2,10,1,2)

        gridNumeros.addWidget(btnPeriodo,3,8,1,2)

        gridNumeros.addWidget(cmbEquis,4,6,1,6)

        boxGrid.addLayout(gridNumeros)
        boxPrincipal.addLayout(boxGrid)





        conteiner = QWidget()
        conteiner.setLayout(boxPrincipal)
        self.setCentralWidget(conteiner)
        self.show()

    def on_uno_pressed(self):
        self.lneOperacionResultado.setText(self.lneOperacionResultado.text() + "1")

    def on_dos_pressed(self):
        self.lneOperacionResultado.setText(self.lneOperacionResultado.text() + "2")

    def on_tres_pressed(self):
        self.lneOperacionResultado.setText(self.lneOperacionResultado.text() + "3")

    def on_mas_pressed(self):
        self.lneOperacionResultado.setText(self.lneOperacionResultado.text() + "+")

    def on_igual_pressed(self):
        if (self.lneOperacionResultado.text().find("+")!=-1):
            text = self.lneOperacionResultado.text().strip()
            list = text.split("+")
            operando1 = int(list[0])
            operando2 = int(list[1])
            resultado = operando1 + operando2
            self.lneOperacionResultado.setText(str(resultado))
            if(self.tedConsolaOperacions.toPlainText()==""):
                self.tedConsolaOperacions.setText(str(operando1) + "+" + str(operando2) + " = " + str(resultado))
            else:
                self.tedConsolaOperacions.setText(self.tedConsolaOperacions.toPlainText() + "\n" + str(operando1) + "+" + str(operando2) + " = " + str(resultado))

        else:
            print("Falta sumando")

    def on_cambio_pressed(self):
        num = float(self.lneOperacionResultado.text())
        if(num):
            cambiar = self.cmbMoedaIncial.currentText()
            cambio = self.cmbMoedaCambio.currentText()
            if (cambiar=="Euro"):
                if(cambio=="Dólar estadounidense"):
                    numCambio = 1.088
                    resultado = num * 1.088
                elif(cambio=="Libra esterlina"):
                    numCambio = 0.861
                    resultado = num * 0.861
                elif(cambio=="Corona danesa"):
                    numCambio = 7.456
                    resultado = num * 7.456
                else:
                    print("No puedo cambiar al mismo tipo de moneda")
            elif (cambiar=="Dólar estadounidense"):
                if(cambio=="Euro"):
                    numCambio = 0.919
                    resultado = num * 0.919
            elif (cambiar == "Libra esterlina"):
                if(cambio == "Euro"):
                    numCambio = 1.16
                    resultado = num * 1.16
            elif (cambiar == "Corona danesa"):
                if(cambio == "Euro"):
                    numCambio = 0.134
                    resultado = num * 0.134

            self.lneOperacionResultado.setText(str(resultado))
            self.lblCambio.setText(str(1) + "-->" + str(numCambio))

    def on_esIgual_pressed(self, texto):
        find = texto.find("=")
        if(find != -1):
            self.lneOperacionResultado.setText(texto.replace("=",""))
            self.on_igual_pressed()


if __name__=="__main__":

    aplicacion = QApplication(sys.argv)
    fiestra = FiestraPrincipal()

    aplicacion.exec()