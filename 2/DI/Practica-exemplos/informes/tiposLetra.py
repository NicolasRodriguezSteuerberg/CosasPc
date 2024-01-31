from reportlab.pdfgen import canvas

frase = "Esta es una bonita frase para ver los distintos tipos de letra"

auxiliar = canvas.Canvas("exemploTiposLetra.pdf")
objetoTexto = auxiliar.beginText()
objetoTexto.setTextOrigin(20,500)
# objetoTexto.setFillColor("red")
objetoTexto.setFillColorRGB(1,0,0) # red, green, blue
espace = 0

for tipo in auxiliar.getAvailableFonts():
    objetoTexto.setCharSpace(espace)
    objetoTexto.setFont(tipo, 12)
    objetoTexto.textLine(tipo + ": " + frase)
    objetoTexto.moveCursor(20,15)
    espace += 1

espace = 0
objetoTexto.setFillGray(0.5)
objetoTexto.setFont("Helvetica", 14)
objetoTexto.setCharSpace(0)
objetoTexto.setTextOrigin(20,100)

for i in range(10):
    objetoTexto.setWordSpace(i)
    objetoTexto.textLine(frase)

auxiliar.drawText(objetoTexto)
auxiliar.showPage()
auxiliar.save()