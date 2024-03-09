import os

from reportlab.lib import colors
from reportlab.lib.colors import Color
from reportlab.platypus import SimpleDocTemplate, Table, Image, Paragraph, Spacer, Flowable
from reportlab.lib.styles import getSampleStyleSheet
from reportlab.lib.pagesizes import A4

class PositionedTable(Flowable):
    def __init__(self, table, x, y):
        Flowable.__init__(self)
        self.table = table
        self.x = x
        self.y = y

    def draw(self):
        self.canv.saveState()
        self.canv.translate(self.x, self.y)
        self.table.wrapOn(self.canv, 0, 0)
        self.table.drawOn(self.canv, 0, 0)
        self.canv.restoreState()
class Factura:
    def __init__(self):
        # cuando quieres poner texto sin una tabla
        self.hojaEstilo = getSampleStyleSheet()
        # donde guardamos to-do lo que queremos que se imprima
        self.elementosDoc = []
        self.bordeIzquierdo()
        self.cabecera()
        self.tablaArriba()
        self.tablaDireccion()
        self.tablaProductos()
        self.total()
        self.lineaSeparadora()
        self.piePagina()
        # creamos el documento
        documento = SimpleDocTemplate("factura.pdf", pagesize=A4)
        # construimos el documento
        documento.build(self.elementosDoc)

    def piePagina(self):
        pie_estilo = self.hojaEstilo["BodyText"]
        pie_estilo.textColor = colors.darkgreen
        pie_estilo.alignment = 1 # 0 izquierda, 1 centro, 2 derecha
        pie_estilo.fontName = "Helvetica-Bold"

        pie = Paragraph("GRACIAS POR SU CONFIANZA", pie_estilo)
        self.elementosDoc.append(pie)

    def lineaSeparadora(self):
        elementos = ["", "", "", ""],
        estilo = [
            # estilo , (inicio columna, inicio fila), (fin columna, fin fila), color
            # poner linea de abajo
            ("LINEBELOW", (0, 0), (-1, 0), 1, colors.black),
        ]

        tabla = Table(data=elementos, style=estilo, colWidths=[210, 90, 90, 100], rowHeights=35)
        self.elementosDoc.append(tabla)
        self.elementosDoc.append(Spacer(0, 20))

    def total(self):
        elementos = [
            ["", "", "TOTAL", "385 €"]
        ]
        estilo = [
            # estilo , (inicio columna, inicio fila), (fin columna, fin fila), color
            # color de la letra
            ("TEXTCOLOR", (0, 0), (-1, -1), colors.white),
            # cambiar el fondo
            ("BACKGROUND", (-2, 0), (-1, 0), colors.darkgreen),
            # cambiar el tamaño
            ("FONTSIZE", (0, 0), (-1, -1), 12),
            # poner en negrita
            ("FONTNAME", (0, 0), (-1, 0), "Helvetica-Bold"),
            # align hacia el centro
            ("ALIGN", (0, 0), (-1, -1), "CENTER"),
            ("VALIGN", (0, 0), (-1, -1), "MIDDLE"),
            # espacio entre celdas
            ("GRID", (0, 0), (-1, -1), 1, colors.white),
        ]
        tabla = Table(data=elementos, style=estilo, colWidths=[210, 90, 90, 100], rowHeights=35)
        self.elementosDoc.append(tabla)
        self.elementosDoc.append(Spacer(0, 25))

    def tablaProductos(self):
        elementos = [
            ["Descripción", "Importe", "Cantidad", "Total"],
            ["Producto 1", "3,2", "5", "16,00"],
            ["Producto 2", "2,1", "3", "6,30"],
            ["Producto 3", "2,9", "76", "220,40"],
            ["Producto 4", "5", "23", "115"],
            ["Producto 5", "4,95", "3", "14,85"],
            ["Producto 6", "6", "2", "12,00"],
        ]
        estilo = [
            # estilo , (inicio columna, inicio fila), (fin columna, fin fila), color
            # color de la letra
            ("TEXTCOLOR", (0, 0), (-1, 0), colors.white),
            # cambiar el fondo
            ("BACKGROUND", (0, 0), (-1, 0), colors.darkgreen),
            ("BACKGROUND", (0, 1), (-1, -1), colors.lightgreen),
            # poner en negrita
            ("FONTNAME", (0, 0), (-1, 0), "Helvetica-Bold"),
            # align hacia el centro
            ("ALIGN", (0, 0), (-1, -1), "CENTER"),
            ("ALIGN", (-1, 1), (-1, -1), "RIGHT"),
            # espacio entre celdas
            ("GRID", (0, 0), (-1, -1), 1, colors.white),
        ]
        tabla = Table(data=elementos, style=estilo, colWidths=[210, 90, 90, 100])
        self.elementosDoc.append(tabla)
        self.elementosDoc.append(Spacer(0, 10))

    def tablaDireccion(self):
        elementos = [
            ["Dirección"],
            ["Ciudad y País"],
            ["CIF/NIF", "Fecha Emisión", "DD/MM/AAAA"],
            ["Teléfono", "Número de Factura", "A0001"],
            ["Mail"]
        ]
        estilo = [
            # estilo , (inicio columna, inicio fila), (fin columna, fin fila), color
            # color de la letra
            ("TEXTCOLOR", (0, 0), (-1, -1), colors.darkgreen),
            # cambiar el tamaño
            ("FONTSIZE", (0, 0), (-1, -1), 10),
            # poner en negrita + cursiva
            ("FONTNAME", (0, 0), (1, -1), "Helvetica-BoldOblique"),
            # align hacia la izquierda
            ("ALIGN", (0, 0), (0, -1), "LEFT"),
            # align hacia el medio
            ("ALIGN", (1, 0), (1, -1), "RIGHT"),
            # align hacia el medio
            ("ALIGN", (2, 0), (-1, -1), "CENTER"),
        ]

        tabla = Table(data=elementos, style=estilo, colWidths=[300,100,100]) # colWidths=[300,100,100] es para darle un tamaño a las columnas
        self.elementosDoc.append(tabla)
        self.elementosDoc.append(Spacer(0, 30))

    def tablaArriba(self):

        cabeceraEmpresa = [
            ["Nombre de tu Empresa", "Logo de la empresa"]
        ]

        estilocabeceraEmpresa = [
            # Color de la letra (inicio columna, inicio fila), (fin columna, fin fila), color
            ("TEXTCOLOR", (0, 0), (-1, 0), colors.darkgreen),
            # cambiar el tamaño
            ("FONTSIZE", (0, 0), (0, -1), 18),
            # cambiar el tamaño de la otra columna
            ("FONTSIZE", (-1, 0), (-1, -1), 14),
            # poner en negrita
            ("FONTNAME", (0, 0), (-1, 0), "Helvetica-Bold"),
            # align hacia la izquierda
            ("ALIGN", (0, 0), (0, -1), "LEFT"),
            # align hacia la derecha
            ("ALIGN", (-1, 0), (-1, -1), "RIGHT"),
            # vertical align
            ("VALIGN", (0, 0), (-1, -1), "BOTTOM")
        ]
        # creamos la 1 tabla
        tabla = Table(data=cabeceraEmpresa, style=estilocabeceraEmpresa, colWidths=[400, 100])
        # añadimos la tabla a la lista de elementos
        self.elementosDoc.append(tabla)
        self.elementosDoc.append(Spacer(25, 15))

    def cabecera(self):
        self.elementosDoc.append(Spacer(25, 0))
        cabecera_estilo = self.hojaEstilo["Heading1"]
        cabecera_estilo.alignment = 2 # 0 izquierda, 1 centro, 2 derecha
        cabecera_estilo.textColor = colors.darkolivegreen
        cabecera_estilo.fontSize = 16
        cabecera = Paragraph("FACTURA SIMPLIFICADA", cabecera_estilo)
        self.elementosDoc.append(cabecera)
        self.elementosDoc.append(Spacer(25, 0))

    def bordeIzquierdo(self):
        elementos = [
            [""],
            [""],
            [""],
            [""]
        ]
        estilo = [
            # estilo , (inicio columna, inicio fila), (fin columna, fin fila), color
            # background
            ("BACKGROUND", (0, 0), (0, 0), colors.darkgreen),
            ("BACKGROUND", (0, 1), (0, 1), colors.lightgreen),
            ("BACKGROUND", (0, 2), (0, 2), colors.white), # para que haya espacio en blanco
            ("BACKGROUND", (0, 3), (0, 3), colors.lightgreen),
        ]
        tablaIzquierda = Table(data=elementos, style=estilo, colWidths=27, rowHeights=[50,300,5,165])
        tabla = PositionedTable(tablaIzquierda, -60, -495)
        self.elementosDoc.append(tabla)

if __name__ == "__main__":
    factura = Factura()
    print("Factura creada")