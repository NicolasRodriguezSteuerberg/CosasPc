import sys
from PyQt6.QtCore import QSize, Qt
from PyQt6.QtGui import QPixmap
from PyQt6.QtWidgets import (QApplication, QMainWindow, QGridLayout, QVBoxLayout, QHBoxLayout, QWidget,
                             QLabel, QListWidget, QPushButton, QComboBox,  QLineEdit,
                             QRadioButton, QGroupBox, QTableView)

from conexionBD import ConexionBD
from facturaa import Factura
from modeloTaboa import ModeloTaboa


class FiestraPrincipal (QMainWindow):
    def __init__(self):
        super().__init__()

        self.setWindowTitle("Exame 20-02-2024")

        # Conexión a la base de datos
        self.obxConeccionBD = ConexionBD("modelosClasicos.dat")
        self.obxConeccionBD.conectaBD()
        self.obxConeccionBD.creaCursor()


        gpbAlbara = QGroupBox("Albará")


        lblNumeroAlbara = QLabel("Número Albará")
        lblDataAlbara = QLabel("Data")
        lblDataEntrega = QLabel("Data entrega")
        lblNumeroCliente = QLabel("Número cliente")

        self.cmbNumeroAlbara = QComboBox()
        # cargar los datos en el combo
        datosCombo = self.obxConeccionBD.consultaSenParametros("SELECT numeroAlbaran FROM ventas")
        for fila in datosCombo:
            self.cmbNumeroAlbara.addItem(str(fila[0]))
        self.cmbNumeroAlbara.currentIndexChanged.connect(self.cambiarDatosAlbara)

        self.txtDataAlbara = QLineEdit()
        self.txtDataEntrega = QLineEdit()
        self.txtNumeroCliente = QLineEdit()

        btnEngadir = QPushButton("Engadir")
        btnEditar = QPushButton("Editar")
        btnBorrar = QPushButton("Borrar")
        btnBorrar.clicked.connect(self.on_btnBorrar_clicked)

        btnAceptar = QPushButton("Aceptar")

        btnCancelar = QPushButton("Cancelar")

        # caja horizontal que contiene toda la ventana
        cajaV = QVBoxLayout()

        # grid que contiene el albará
        gridAlbara = QGridLayout()
        gridAlbara.addWidget(lblNumeroAlbara,0,0)
        gridAlbara.addWidget(self.cmbNumeroAlbara,0,1)
        gridAlbara.addWidget(lblDataAlbara,0,2)
        gridAlbara.addWidget(self.txtDataAlbara,0,3)
        gridAlbara.addWidget(lblDataEntrega,1,0)
        gridAlbara.addWidget(self.txtDataEntrega,1,1,1,3)
        gridAlbara.addWidget(lblNumeroCliente,2,0)
        gridAlbara.addWidget(self.txtNumeroCliente,2,1,1,3)

        gpbAlbara.setLayout(gridAlbara)
        cajaV.addWidget(gpbAlbara)

        # caja vertical que contiene los botones
        cajaH = QHBoxLayout()
        cajaH.addWidget(btnEngadir)
        cajaH.addWidget(btnEditar)
        cajaH.addWidget(btnBorrar)

        cajaV.addLayout(cajaH)

        # creación de la tabla
        self.tablaDetalleAlbara = QTableView()
        # cambiar el seleccionar fila
        # to select the entire row
        self.tablaDetalleAlbara.setSelectionBehavior(QTableView.SelectionBehavior.SelectRows)
        # to select only one row
        self.tablaDetalleAlbara.setSelectionMode(QTableView.SelectionMode.MultiSelection)
        # to do the selection

        # implementacion medida de usuabilidade
        self.headerData = self.obtenerNombreColumnas()

        cajaV.addWidget(self.tablaDetalleAlbara)

        # Creación de la caja horizontal que contiene los botones aceptar y cancelar
        cajaAC = QHBoxLayout()
        cajaAC.addWidget(btnCancelar)
        cajaAC.addWidget(btnAceptar)


        buttonImprimir = QPushButton("Imprimir")
        cajaAC.addWidget(buttonImprimir)
        buttonImprimir.clicked.connect(self.on_imprimir_clicked)

        # añadir la caja horizontal a la caja vertical al final
        cajaV.addLayout(cajaAC)

        # Contenedor principal
        container = QWidget()
        container.setLayout(cajaV)

        self.cambiarDatosAlbara()

        btnAceptar.clicked.connect(self.on_btnAceptar_clicked)

        self.setCentralWidget(container)
        self.setFixedSize(512, 500)

        self.show()
    def on_btnAceptar_clicked(self):
        self.datosTabla = []
        for elemento in self.tableData:
            self.datosTabla.append(elemento)
        for elemento in self.datosTabla:
            print(elemento)

    def on_imprimir_clicked(self):
        numeroAlbara = self.cmbNumeroAlbara.currentText()
        dataAlbara = self.txtDataAlbara.text()
        dataEntrega = self.txtDataEntrega.text()
        numeroCliente = self.txtNumeroCliente.text()
        index = self.tablaDetalleAlbara.selectedIndexes()
        if not index==[]:
            self.codigoProducto = self.tableData[index[0].row()][0]
            self.cantidade = self.tableData[index[0].row()][1]
            self.prezoUnitario = self.tableData[index[0].row()][2]
            self.numeroLinhaAlbaran = self.tableData[index[0].row()][3]
            print("dsajlkhfgsdlkjg")

        Factura(numeroAlbara, dataAlbara, dataEntrega, numeroCliente, self.tableData)

    # metodo cambiar numero albará
    def cambiarDatosAlbara(self):
        numeroAlbara = self.cmbNumeroAlbara.currentText()
        datosAlbara = self.obxConeccionBD.consultaConParametros("SELECT * FROM ventas WHERE numeroAlbaran=?", numeroAlbara)
        self.txtDataAlbara.setText(datosAlbara[0][1])
        self.txtDataEntrega.setText(datosAlbara[0][2])
        self.txtNumeroCliente.setText(str(datosAlbara[0][3]))
        self.changeTableData(numeroAlbara)

    # metodo cambiar datos de la tabla
    def changeTableData(self, numeroAlbara):
        self.tableData = self.obxConeccionBD.consultaConParametros("SELECT * FROM main.detalleVentas WHERE numeroAlbaran=?", numeroAlbara)
        modelo = ModeloTaboa(self.tableData, self.headerData)
        self.tablaDetalleAlbara.setModel(modelo)

        # cambiar el tamaño de las columnas dependiendo del tamaño del contenido
        self.tablaDetalleAlbara.resizeColumnsToContents()

    # metodo para borrar la fila seleccionada
    def on_btnBorrar_clicked(self):
        index = self.tablaDetalleAlbara.selectedIndexes()
        if not index==[]:
            numeroAlbara = self.tableData[index[0].row()][0]
            codigoProducto = self.tableData[index[0].row()][1]
            isDeleted = self.obxConeccionBD.consultaParaBorrado("DELETE FROM main.detalleVentas WHERE numeroAlbaran=? AND codigoProducto=?", numeroAlbara, codigoProducto)
            if isDeleted:
                self.tableData.pop(index[0].row())
                self.obxConeccionBD.conexion.commit()
                self.changeTableData(numeroAlbara)
            else:
                print("Error al borrar la fila")


    # metodo para obtener el nombre de las columnas
    def obtenerNombreColumnas(self):
        resultado = self.obxConeccionBD.consultaSenParametros("PRAGMA table_info(detalleVentas)")
        nombres_columnas = [columna[1] for columna in resultado]
        return nombres_columnas







if __name__=="__main__":

    aplicacion = QApplication(sys.argv)
    fiestra = FiestraPrincipal()

    aplicacion.exec()
