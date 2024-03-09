from reportlab.graphics.shapes import Image, Drawing
from reportlab.graphics import renderPDF
from reportlab.lib.pagesizes import A4
# empieza en el 0,0 -> abajo izquierda

imaxes = []
imaxe = Image(10, -100, 300, 281, "tombaker.jpg")
debuxo = Drawing()
debuxo.add(imaxe)
# movemos la imagen 700 puntos hacia arriba
debuxo.translate(0,700)
imaxes.append(debuxo)

debuxo = Drawing()
debuxo.add(imaxe)
debuxo.rotate(45)
debuxo.scale(2,0.35)
debuxo.translate(125, 300)
imaxes.append(debuxo)

debuxo = Drawing(A4[0], A4[1])

for aux in imaxes:
    debuxo.add(aux)
renderPDF.drawToFile(debuxo,"exemploImageRpl.pdf")