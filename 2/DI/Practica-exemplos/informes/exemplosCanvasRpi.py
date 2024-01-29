# (0,0) corner bottom left
from reportlab.pdfgen import canvas

auxiliar = canvas.Canvas("firstDocument.pdf")

auxiliar.drawString(0,0, "Posicion orixe (X,Y) = (0,0)")
auxiliar.drawString(50,100, "Posicion (X,Y) = (50,100)")
auxiliar.drawString(150, 20, "Posicion (X,Y) = (150,20)")

auxiliar.drawImage("tombaker.jpg", 250,300,512,512)

auxiliar.showPage()
auxiliar.save()