import os

from reportlab.lib import colors
from reportlab.lib.colors import Color
from reportlab.platypus import SimpleDocTemplate, Table, Image, Paragraph
from reportlab.lib.styles import getSampleStyleSheet
from reportlab.lib.pagesizes import A4

follaEstilo = getSampleStyleSheet()

imaxe = Image("tombaker.jpg")
parafo = Paragraph("Optare", style = [Color(0,0,150,0)])

elementosDoc = []

datos = [
    ["Empresas", "Candidato 1", "Candidato 2", "Especificaciones"],
    ["Ayco", "Marcos", "Ruben", "Desenvolvemento web con PHP"],
    ["Iterat", "Borja", "Juan", "Recoñecemento de imaxes con OpenCV"],
    [[parafo,imaxe],"Lidier", "Lucas","Apliccacions para as telco"]
]

estilo = [
    # estilo , (inicio columna, inicio fila), (fin columna, fin fila), color
    ("TEXTCOLOR", (0,0), (0,-1), colors.blue),
    ("TEXTCOLOR", (0,0), (-1,0), colors.blueviolet),
    ("TEXTCOLOR", (1,1), (-1,-1), colors.grey),
    # estilo, (inicio columna, inicio fila), (fin columna, fin fila), ancho, color)
    ("BOX", (1,1), (-1,-1), 1.25, colors.grey),
    # estilo, (inicio columna, inicio fila), (fin columna, fin fila), ancho, color)
    # celda
    ("INNERGRID", (1,1), (-1,-1), 1.25, colors.lightgrey),
    # estilo, (inicio columna, inicio fila), (fin columna, fin fila), alineacion
    # vertical align
    ("VALIGN", (0,0), (-1,-1), "MIDDLE")
]

taboa = Table(data = datos, style=estilo ,colWidths = 100, rowHeights = 30)
# taboa.setStyle(estilo)

elementosDoc.append(taboa)

documento = SimpleDocTemplate("exemploTaboasRpl.pdf", pagesize = A4, showBoundary = 0)
documento.build(elementosDoc)