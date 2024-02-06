import os

from reportlab.lib import colors
from reportlab.lib.colors import Color
from reportlab.platypus import SimpleDocTemplate, Table, Image, Paragraph
from reportlab.lib.styles import getSampleStyleSheet
from reportlab.lib.pagesizes import A4

follaEstilo = getSampleStyleSheet()

elementosDoc = []

temperaturas = [
    ["Arriba\nEsquerda", "", "02", "03", "04"],
    ["", "", "12", "13", "14"],
    ["20", "21", "22", "Abaijo\nDerecha", ""],
    ["30", "31", "32", "", ""]
]

estilo = [
    # estilo , (inicio columna, inicio fila), (fin columna, fin fila), color
    ("GRID", (0,0), (-1,-1), 1, colors.grey),
    ("BACKGROUND", (0,0), (1,1), colors.pink),
    ("SPAN", (0,0), (1,1)),
    # el menos es para empezar a contar desde el ultimo elemento
    ("BACKGROUND", (-2,-2), (-1,-1), colors.lavenderblush),
    ("SPAN", (-1,-1), (-2,-2))
]


taboa = Table(data = temperaturas, style=estilo)
# taboa.setStyle(estilo)

elementosDoc.append(taboa)

documento = SimpleDocTemplate("exemploTaboasRpl3.pdf", pagesize = A4)
documento.build(elementosDoc)