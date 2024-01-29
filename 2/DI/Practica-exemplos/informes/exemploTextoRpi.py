from reportlab.pdfgen import canvas

frase = [
    "Esta es una bonita frase",
    "para tener distintas partes",
    "para incluir en nuestro",
    "texto de ejemplo"
]

auxiliar = canvas.Canvas("exemploTexto.pdf")
obxectoTexto = auxiliar.beginText()
obxectoTexto.setTextOrigin(100,500)
obxectoTexto.setFont("Courier", 16)
for linea in frase:
    obxectoTexto.textLine(linea)

obxectoTexto.setFillGray(0.5)

parrafo = '''
    Esto es un texto multilinea para poner de exemplo.
    En el escribimos varias frases ene un parrafo
    para que despues lo presente detro del documento
    o drawText de canvas.
'''

obxectoTexto.textLines(parrafo)

auxiliar.drawText(obxectoTexto)
auxiliar.showPage()
auxiliar.save()