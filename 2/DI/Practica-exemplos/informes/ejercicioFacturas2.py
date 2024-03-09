from reportlab.lib.pagesizes import A4
from reportlab.lib.styles import getSampleStyleSheet, ParagraphStyle
from reportlab.platypus import SimpleDocTemplate, Paragraph, Image, Table, Spacer


class Factura2():
    def __init__(self):
        self.hojaEstilo = getSampleStyleSheet()
        self.elementosDoc = []
        self.cabecera()
        self.tablaFactura()
        self.tablaDescripcion()
        self.tablaDescripcionPago()
        self.textoDespedida()
        documento = SimpleDocTemplate("factura2.pdf", pagesize=A4)
        documento.build(self.elementosDoc)

    def textoDespedida(self):
        pie_estilo = self.hojaEstilo["BodyText"]
        pie_estilo.alignment = 0
        pie_estilo.fontSize = 10

        pie1 = Paragraph("Gracias por su confianza", pie_estilo)
        pie2 = Paragraph("Atentamente,", pie_estilo)
        self.elementosDoc.append(pie1)
        self.elementosDoc.append(Spacer(0, 20))
        self.elementosDoc.append(pie2)

    def tablaDescripcionPago(self):
        elementos_tabla1 = [
            ["Método de pago:"]
        ]
        estilo_tabla1 = [
            ("GRID", (0, 0), (-1, -1), 1, "black"),
            ("VALIGN", (0, 0), (-1, -1), "TOP"),
            ("ALIGN", (0, 0), (-1, -1), "LEFT"),
        ]
        tabla1 = Table(data=elementos_tabla1, style=estilo_tabla1, colWidths=245, rowHeights=60)

        elementos_tabla2 = [
            ["Importe neto", ""],
            ["IVA de   %", ""],
            ["IRPF de   %", ""],
            ["",""],
            ["IMPORTE BRUTO", ""],
        ]
        estilo_tabla2 = [
            # estilo , (inicio columna, inicio fila), (fin columna, fin fila), color
            ("GRID", (0, 0), (-1, -1), 1, "black"),
            ("BACKGROUND", (0, -1), (-1, -1), "lightgrey"),
            ("VALIGN", (0, 0), (-1, -1), "MIDDLE"),
            ("FONTSIZE", (0, -1), (-1, -1), 12),
            ("FONTNAME", (0, -1), (-1, -1), "Helvetica-Bold"),
        ]
        tabla2 = Table(data=elementos_tabla2, style=estilo_tabla2, colWidths=[120, 70], rowHeights=[20,20,20,2,30])

        elementos = [
            [tabla1, "",tabla2]
        ]
        estilo = [
            ("VALIGN", (0, 0), (-1, -1), "TOP"),
            ("LEFTPADDING", (0, 0), (-1, -1), 0),
        ]
        tabla = Table(data=elementos, style=estilo,colWidths=[255, 15,190])
        self.elementosDoc.append(tabla)
        self.elementosDoc.append(Spacer(0, 5))

    def tablaDescripcion(self):
        elementos = [
            ["Pos.", "Concepto/Descripcion", "Cantidad", "Unidad", "Precio\nunitario", "Importe"],
            ["1", "", "", "", "", ""],
            ["2", "", "", "", "", ""],
            ["", "", "", "", "", ""],
        ]
        estilo = [
            # estilo , (inicio columna, inicio fila), (fin columna, fin fila), color
            ("GRID", (0, 0), (-1, -1), 1, "black"),
            ("VALIGN", (0, 0), (-1, -1), "TOP"),
            ("ALIGN", (0, 0), (-1, 0), "CENTER"),
            ("BACKGROUND", (0, 0), (-1, 0), "lightgrey"),
        ]
        tabla = Table(data=elementos, style=estilo, colWidths=[35, 200, 60, 45, 60, 60])
        self.elementosDoc.append(tabla)
        self.elementosDoc.append(Spacer(0, 50))
    def tablaFactura(self):
        # creamos los datos de la tabla
        elementos_izquierda = [
            [""],
            ["Cliente"],
            ["Domilicio"],
            ["Código Postal/ciudad"],
            ["(NIF)"],
            [""]
        ]
        estilo_izquierda = [
            ("LEFTPADDING", (0, 0), (-1, -1), 0), # asi le quitamos el padding
        ]
        tabla_izquierda = Table(data=elementos_izquierda, style=estilo_izquierda, colWidths=100, rowHeights=15)

        elementos_derecha = [
            ["Fecha"],
            ["Nº de pedido"],
            ["Fecha de vencimiento"],
            ["Condiciones de pago"]
        ]
        estilo_derecha = [
            ("ALIGN", (0, 0), (-1, -1), "LEFT"),
            ("LEFTPADDING", (0, 0), (-1, -1), 0), # asi le quitamos el padding
        ]
        tabla_derecha = Table(data=elementos_derecha, style=estilo_derecha, colWidths=200, rowHeights=25)

        elementos_externos = [
            ["FACTURAR A:", "Nº DE FACTURA"],
            [tabla_izquierda, tabla_derecha]
        ]
        estilo = [
            # estilo , (inicio columna, inicio fila), (fin columna, fin fila), color
            ("FONTSIZE", (-1, 0), (-1, 0), 14),
            ("BACKGROUND", (0, 0), (-1, -1), "whitesmoke"),
        ]
        tabla = Table(data=elementos_externos, style=estilo, colWidths=230, rowHeights=[20,95])
        self.elementosDoc.append(tabla)
        self.elementosDoc.append(Spacer(0, 25))

    def cabecera(self):
        # texto de la cabecera
        cabecera_estilo = self.hojaEstilo["Heading1"]
        cabecera_estilo.fontSize = 20
        cabecera = Paragraph("FACTURA Proforma", cabecera_estilo)
        # imagen de la cabecera
        imagen = Image("logoFactura2.png", width=250, height=50)
        # creamos la tabla
        elementos = [
            [cabecera,imagen]
        ]
        estilo = [
            # estilo , (inicio columna, inicio fila), (fin columna, fin fila), color
            ("VALIGN", (0, 0), (1, -1), "MIDDLE"),
            ("VALIGN", (-1, 0), (-1, 0), "BOTTOM"),
        ]
        table = Table(data = elementos, style = estilo, colWidths = [205, 255])
        self.elementosDoc.append(table)
        self.elementosDoc.append(Spacer(0, 50))

if __name__ == "__main__":
    Factura2()