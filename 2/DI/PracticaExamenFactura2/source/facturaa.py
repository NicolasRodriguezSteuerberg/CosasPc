from reportlab.lib.pagesizes import A4
from reportlab.lib.styles import getSampleStyleSheet
from reportlab.platypus import Image, Table, SimpleDocTemplate


class Factura():
    """
    Clase que genera una factura en formato PDF
    """
    def __init__(
            self,
            numeroAlbara="",
            dataAlbara="", dataEntrega="",numeroCliente="",
            tableData=["", "", "", "", ""]
    ):
        hojaEstilo = getSampleStyleSheet()
        self.elementosDoc = []
        self.cabecera()
        self.Albara(numeroAlbara, dataAlbara, dataEntrega, numeroCliente)
        self.tabla2(tableData)
        documento = SimpleDocTemplate("factura.pdf", pagesize=A4)
        documento.build(self.elementosDoc)
        print("AAAAAAAAAAAAAA")

    def tabla2(self, tableData):
        """
        Método que añade una tabla a la factura
        :param numeroAlbaran: Número de albarán
        :param codigoProducto: Código del producto
        :param cantidade: Cantidad
        :param prezoUnitario: Precio unitario
        :param numeroLinhaAlbaran: Número de línea del albarán
        """
        elementos = [
            ["NumeroAlbaran", "Código Producto", "Cantidade", "Prezo Unitario", "Número Linha Albarán", "total"]
        ]
        for elemento in tableData:
            array = list(elemento)
            array.append(elemento[2]*elemento[3])
            elementos.append(array)
        print(elementos)
        estilo = [
            # estilo , (inicio columna, inicio fila), (fin columna, fin fila),
            ("INNERGRID", (0, 0), (-1, -1), 1, "BLACK"),
            ("BOX", (0, 0), (-1, -1), 1, "RED"),
            ("VALIGN", (0, 0), (-1, -1), "MIDDLE"),
            ("ALIGN", (0, 0), (-1, -1), "CENTER"),
            ("BACKGROUND", (0, 0), (-1, 0), "LIGHTGREEN"),
            ("BACKGROUND", (0, 1), (-1, -1), "GREEN")
        ]
        tabla = Table(data=elementos, style=estilo, colWidths=[75,75,75,75,100,75], rowHeights=30)
        self.elementosDoc.append(tabla)

    def Albara(self, numeroAlbara, dataAlbara, dataEntrega, numeroCliente):
        """
        Método que añade una tabla a la factura
        :param numeroAlbara: Número de albarán
        :param dataAlbara: Fecha del albarán
        :param dataEntrega: Fecha de entrega
        :param numeroCliente: Número de cliente
        """
        elementos_tabla1 = [
            ["Número Albarán:" ,numeroAlbara, ""],
            ["Data Albarán:", dataAlbara, ""],
            ["Data Entrega:", dataEntrega, ""],
            ["Número Cliente:", numeroCliente, ""]
        ]
        estilo_tabla1 = [
            ("GRID", (0, 0), (-2, -1), 1, "BLACK"),
            ("VALIGN", (0, 0), (-1, -1), "TOP"),
            ("ALIGN", (0, 0), (-1, -1), "LEFT"),
        ]
        tabla1 = Table(data=elementos_tabla1, style=estilo_tabla1, colWidths=[100,75,300], rowHeights=60)
        self.elementosDoc.append(tabla1)

    def cabecera(self):
        """
        Método que añade una cabecera a la factura, con el logo de la empresa
        """
        imagen = Image("logoFactura2.png", 250, 50)
        elementos = [
            ["Factura sevDesk", imagen]
        ]
        estilo = [
            ("FONTSIZE", (0, 0), (-1, -1), 20),
            ("FONTNAME", (0, 0), (-1, -1), "Helvetica-Bold"),
            ("ALIGN", (0, 0), (-1, -1), "CENTER"),
            ("VALIGN", (0, 0), (-1, -1), "MIDDLE"),
        ]
        tabla = Table(data=elementos, style=estilo, colWidths=300, rowHeights=100)
        self.elementosDoc.append(tabla)