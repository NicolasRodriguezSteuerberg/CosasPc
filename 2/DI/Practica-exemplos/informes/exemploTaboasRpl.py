import os

from reportlab.lib import colors
from reportlab.lib.colors import Color
from reportlab.platypus import SimpleDocTemplate, Table, Image, Paragraph
from reportlab.lib.styles import getSampleStyleSheet
from reportlab.lib.pagesizes import A4

follaEstilo = getSampleStyleSheet()

imaxe = Image("tombaker.jpg", 20, 20)

estiloCorpoTexto = follaEstilo["BodyText"]
estiloCorpoTexto.textColor = Color(0,0,250,0.5)
estiloCorpoTexto2 = follaEstilo["Heading4"]

parrafo = Paragraph("Optare", style = estiloCorpoTexto)
parrafo2 = Paragraph("Optare", style = estiloCorpoTexto2)

elementosDoc = []

datos = [
    ["Empresas", "Candidato 1", "Candidato 2", "Especificaciones"],
    ["Ayco", "Marcos", "Ruben", "Desenvolvemento web con PHP"],
    [[parrafo,parrafo2], "Borja", "Juan", "Recoñecemento de imaxes con OpenCV"],
    [[parrafo, imaxe], "Lidier", "Lucas", "Apliccacions para as telco"]
]

estilo = [
    # estilo , (inicio columna, inicio fila), (fin columna, fin fila), color
    ("TEXTCOLOR", (0,0), (0,-1), colors.blue),
    ("TEXTCOLOR", (1,0), (-1,0), colors.blueviolet),
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

taboa = Table(data = datos, style=estilo)
# taboa.setStyle(estilo)

elementosDoc.append(taboa)

documento = SimpleDocTemplate("exemploTaboasRpl.pdf", pagesize = A4, showBoundary = 0)
documento.build(elementosDoc)