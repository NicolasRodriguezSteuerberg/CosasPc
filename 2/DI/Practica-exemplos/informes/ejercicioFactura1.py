import os

from reportlab.lib import colors
from reportlab.lib.colors import Color
from reportlab.platypus import SimpleDocTemplate, Table, Image, Paragraph, Spacer
from reportlab.lib.styles import getSampleStyleSheet
from reportlab.lib.pagesizes import A4

class Factura:
    def __init__(self):
        # cuando quieres poner texto sin una tabla
        self.hojaEstilo = getSampleStyleSheet()
        # donde guardamos to-do lo que queremos que se imprima
        self.elementosDoc = []
        self.tablaArriba()
        self.tablaDireccion()
        self.tablaDescripciones()
        # creamos el documento
        documento = SimpleDocTemplate("factura.pdf", pagesize=A4)
        # construimos el documento
        documento.build(self.elementosDoc)

    def tablaDescripciones(self):
        elementos = [
            ["Descripción", "Importe", "Cantidad", "Total"],

        ]
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
        self.elementosDoc.append(Spacer(0, 20))

if __name__ == "__main__":
    factura = Factura()
    print("Factura creada")