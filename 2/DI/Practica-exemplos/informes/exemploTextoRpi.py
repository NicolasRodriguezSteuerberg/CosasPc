from reportlab.pdfgen import canvas

frase = [
    "Esta es una bonita frase",
    "para tener distintas partes",
    "para incluir en nuestro",
    "texto de ejemplo"
]
# inicializamos el documento con el nombre exemploTexto.pdf
auxiliar = canvas.Canvas("exemploTexto.pdf")
# creamos un obxectoTexto para escribir en el documento
obxectoTexto = auxiliar.beginText()
# establecemos a posición do texto (0,0) abajo a la izquierda
# altura maxima 841, anchura maxima 595
obxectoTexto.setTextOrigin(100,500) # (anchura, altura)
# establecemos a fonte e o tamaño
obxectoTexto.setFont("Courier", 16)
for linea in frase:
    # añadimos una linea de texto (con salto de linea al final), si no queremos salto de linea al final, usamos textOut
    obxectoTexto.textLine(linea)

# establecemos el color del texto a gris (de aqui en adelante to_do el texto que escribamos sera gris)
obxectoTexto.setFillGray(0.5)

parrafo = '''
    Esto es un texto multilinea para poner de exemplo.
    En el escribimos varias frases ene un parrafo
    para que despues lo presente detro del documento
    o drawText de canvas.
'''
# añadimos el parrafo al obxectoTexto, se pone lines para que separe las lineas
obxectoTexto.textLines(parrafo)
# añadimos el obxectoTexto al documento para que se pinte
auxiliar.drawText(obxectoTexto)
# mostramos la pagina (no se hace)
auxiliar.showPage()
# guardamos el documento
auxiliar.save()