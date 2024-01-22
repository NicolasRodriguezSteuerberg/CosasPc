import sys

# importamos del pyqt6 los elementos que nos importa -> ventana principal, boton
from PyQt6.QtWidgets import (QApplication, QMainWindow,QCheckBox , QRadioButton,
                             QVBoxLayout, QWidget, QLineEdit)
from PyQt6.QtCore import Qt

# creamos clase que heread de QMainWindow
class VentanaPrincipal (QMainWindow):
    # iniciamos a ventana
    def __init__(self):
        # call the constructor of the superclass
        super().__init__()

        # set the title and size of the window
        self.setWindowTitle( "Mi primera ventana con Qt")
        self.setFixedSize(800,500)

        # we create a vertical box
        caixaV = QVBoxLayout()

        # checkbuttons
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
        # convert the vertical box into a widget
        widgetCaixaV2 = QWidget()
        widgetCaixaV2.setLayout(caixaV2)
        # we add the vertical box to the first vertical box
        caixaV.addWidget(widgetCaixaV2)

        # radio buttons
        self.radioButton1 = QRadioButton("Radio 1", widgetCaixaV2)
        self.radioButton1.toggled.connect(self.on_radioButton_toggled)
            # 2
        self.radioButton2 = QRadioButton("Radio 2", widgetCaixaV2)
        self.radioButton2.toggled.connect(self.on_radioButton2_toggled)
            # 3
        self.radioButton3 = QRadioButton("Radio 3", widgetCaixaV2)
        self.radioButton3.toggled.connect(self.on_radioButton3_toggled)

        # we add the radio buttons to the 2 vertical box
        caixaV2.addWidget(self.radioButton1)
        caixaV2.addWidget(self.radioButton2)
        caixaV2.addWidget(self.radioButton3)

        # create a third vertical box for other radio buttons
        caixaV3 = QVBoxLayout()
        # convert the vertical box into a widget
        widgetCaixaV3 = QWidget()
        widgetCaixaV3.setLayout(caixaV3)
        # we add the vertical box to the first vertical box
        caixaV.addWidget(widgetCaixaV3)

        # radio buttons 4-6
        self.radioButton4 = QRadioButton("Radio 1, Grupo 2", widgetCaixaV3)
        self.radioButton4.toggled.connect(self.on_radioButton4_toggled)
            # 5
        self.radioButton5 = QRadioButton("Radio 2, Grupo 2", widgetCaixaV3)
        self.radioButton5.toggled.connect(self.on_radioButton5_toggled)
            # 6
        self.radioButton6 = QRadioButton("Radio 3, Grupo 2", widgetCaixaV3)
        self.radioButton6.toggled.connect(self.on_radioButton6_toggled)

        # we add the radio buttons to the 3 vertical box
        caixaV3.addWidget(self.radioButton4)
        caixaV3.addWidget(self.radioButton5)
        caixaV3.addWidget(self.radioButton6)


        # we create a container and add the vertical box to it
        container = QWidget()
        container.setLayout(caixaV)

        # we set the container as the central widget
        self.setCentralWidget(container)

        # we show the window
        self.show()

    def on_checkButton_toggled(self):
        if self.checkButton1.isChecked():
            print("Boton check 1 activado", self.checkButton1.text())
        else:
            print("Boton check 1 desactivado", self.checkButton1.text())

    def on_checkButton2_toggled(self):
        if self.checkButton2.isChecked():
            print("Boton check 2 activado", self.checkButton2.text())
        else:
            print("Boton check 2 desactivado", self.checkButton2.text())


    # toggle of the radio buttons 1-6
    def on_radioButton_toggled(self):
        if self.radioButton1.isChecked():
            print("Boton radio 1 activado", self.radioButton1.text())
        else:
            print("Boton radio 1 desactivado", self.radioButton1.text())

    def on_radioButton2_toggled(self):
        if self.radioButton2.isChecked():
            print("Boton radio 2 activado", self.radioButton2.text())
        else:
            print("Boton radio 2 desactivado", self.radioButton2.text())

    def on_radioButton3_toggled(self):
        if self.radioButton3.isChecked():
            print("Boton radio 3 activado", self.radioButton3.text())
        else:
            print("Boton radio 3 desactivado", self.radioButton3.text())

    def on_radioButton4_toggled(self):
        if self.radioButton4.isChecked():
            print("Boton radio 4 activado", self.radioButton4.text())
        else:
            print("Boton radio 4 desactivado", self.radioButton4.text())

    def on_radioButton5_toggled(self):
        if self.radioButton5.isChecked():
            print("Boton radio 5 activado", self.radioButton5.text())
        else:
            print("Boton radio 5 desactivado", self.radioButton5.text())

    def on_radioButton6_toggled(self):
        if self.radioButton6.isChecked():
            print("Boton radio 6 activado", self.radioButton6.text())
        else:
            print("Boton radio 6 desactivado", self.radioButton6.text())


if __name__ == "__main__":
    # creamos un objeto de instancia qapplication
    aplicacion = QApplication(sys.argv) # sys.argv -> unimos la aplicacion con el sistema operativo
    # creamos un objeto de la ventana
    ventana = VentanaPrincipal()
    # ejecutamos la union?
    aplicacion.exec()

