import os

from reportlab.lib import colors
from reportlab.lib.colors import Color
from reportlab.platypus import SimpleDocTemplate, Table, Image, Paragraph
from reportlab.lib.styles import getSampleStyleSheet
from reportlab.lib.pagesizes import A4

follaEstilo = getSampleStyleSheet()

elementosDoc = []

temperaturas = [
    ["", "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"],
    ["Maximas", 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26],
    ["Minimas", -3, -4, 2, 5, 9, 1, 11, 12, 3, 4, 5, -10]
]

estilo = [
    ("TEXTCOLOR", (0,0), (-1,0), colors.grey),
    ("TEXTCOLOR", (0,1),(0,-1), colors.grey),
    ("BOX", (1,1),(-1,-1), 1.50, colors.grey),
    ("INNERGRID", (1,1), (-1,-1), 0.5, colors.lightgrey),
]

for i,fila in enumerate(temperaturas):
        for j,temperatura in enumerate(fila):
                if type(temperatura)==int:
                        estilo.append(('TEXTCOLOR',(j,i),(j,i),colors.black))
                        if temperatura>30:
                                estilo.append(('BACKGROUND', (j, i), (j, i), colors.fidred))
                        elif temperatura<=30 and temperatura>20:
                                estilo.append(('BACKGROUND', (j, i), (j, i), colors.orange))
                        elif temperatura<=20 and temperatura>10:
                                estilo.append(('BACKGROUND', (j, i), (j, i), colors.lightpink))
                        elif temperatura<=10 and temperatura>0:
                                estilo.append(('BACKGROUND', (j, i), (j, i), colors.lightblue))
                        else:
                                estilo.append(('TEXTCOLOR',(j,i),(j,i),colors.blue))
                                estilo.append(('BACKGROUND',(j,i),(j,i),colors.lightgrey))

taboa = Table(data = temperaturas, style=estilo)
# taboa.setStyle(estilo)

elementosDoc.append(taboa)

documento = SimpleDocTemplate("exemploTaboasRpl2.pdf", pagesize = A4)
documento.build(elementosDoc)