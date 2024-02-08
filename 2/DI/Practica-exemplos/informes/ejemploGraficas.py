import os

from reportlab.graphics.charts.barcharts import VerticalBarChart
from reportlab.graphics.charts.legends import LineLegend, Legend
from reportlab.graphics.charts.linecharts import HorizontalLineChart
from reportlab.graphics.shapes import Drawing
from reportlab.graphics.widgets.markers import makeMarker
from reportlab.lib import colors
from reportlab.platypus import SimpleDocTemplate
from reportlab.lib.styles import getSampleStyleSheet
from reportlab.lib.pagesizes import A4
from reportlab.graphics.charts.piecharts import Pie, Pie3d

follaEstilo = getSampleStyleSheet()

elementosDoc = []


temperaturas = [
    ["Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"],
    [15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26],
    [-3, -4, 2, 5, 9, 1, 11, 12, 3, 4, 5, -10]
]

debuxo = Drawing(400, 200)

gb = VerticalBarChart()
gb.x = 50
gb.y = 50
gb.height = 125
gb.width = 300
gb.data = temperaturas[1:]
gb.strokeColor = colors.black
gb.valueAxis.valueMin = -10
gb.valueAxis.valueMax = 30
gb.valueAxis.valueStep = 5
gb.categoryAxis.labels.boxAnchor = 'ne'
gb.categoryAxis.labels.dx = 8
gb.categoryAxis.labels.dy = -30
gb.categoryAxis.labels.angle = 30
gb.categoryAxis.categoryNames = temperaturas[0]
gb.groupSpacing = 10
gb.barSpacing = 2

debuxo.add(gb)

elementosDoc.append(debuxo)

debuxo = Drawing(400, 200)
gl = HorizontalLineChart()
gl.x = 30
gl.y = 50
gl.height = 125
gl.width = 300
gl.data = temperaturas[1:]
gl.categoryAxis.categoryNames = temperaturas[0]
gl.categoryAxis.labels.boxAnchor = 'n'
gl.categoryAxis.labels.angle = 30
gl.categoryAxis.labels.dx = 10
gl.categoryAxis.labels.dy = -30
gl.valueAxis._valueMin = 0
gl.valueAxis._valueMax = 40
gl.valueAxis._valueStep = 10
gl.lines[0].strokeWidth = 2
gl.lines[0].symbol = makeMarker('FilledCircle')
gl.lines[0].strokeColor = colors.blue

debuxo.add(gl)

lenda = LineLegend()
lenda.fontSize = 8
lenda.fontName = "Helvetica"
lenda.alignment = "right"
lenda.x = 0
lenda.y = 0
lenda.columnMaximum = 2
series = ["Maximas", "Minimas"]
lenda.colorNamePairs = [(gl.lines[i].strokeColor, series[i]) for i in range(len(gl.data))]
debuxo.add(lenda)

elementosDoc.append(debuxo)

debuxo = Drawing(300, 200)
tarta = Pie3d()
tarta.x = 65
tarta.y = 15
# porcenteaje de las porciones
tarta.data = [10, 5, 20, 25, 40]
tarta.labels = ["Edge", "Brave", "Firefox", "Safari", "Chrome"]

tarta.slices.strokeWidth = 0.5

# separacion de las porciones
tarta.slices[3].popout = 10
# grosor del borde
tarta.slices[3].strokeWidth = 2
# resultado con lineas punteadas
tarta.slices[3].strokeDashArray = [2,2]
tarta.slices[3].labelRadius = 2
tarta.slices[3].fontColor = colors.blue
# linea hacia las etiquetas
tarta.sideLabels = 1
debuxo.add(tarta)

lenda = Legend()
lenda.x = 300
lenda.y = 5
lenda.dx = 10
lenda.dy = 10
lenda.fontName = "Helvetica"
lenda.fontSize = 7
lenda.boxAnchor = "n"
lenda.columnMaximum = 15
lenda.strokeWidth = 0.5
lenda.strokeColor = colors.grey
lenda.deltax = 75
lenda.deltay = 10
lenda.autoXPadding = 5
lenda.yGap = 1.5
lenda.dxTextSpace = 3
lenda.alignment = "right"
lenda.dividerLines = 1|4
lenda.dividerOffsY = 4.5
lenda.subCols.rpad = 30

coloresLenda = []

colores = [colors.blue, colors.red, colors.pink, colors.yellow, colors.green]

for i, color in enumerate(colores):
    tarta.slices[i].fillColor = color
    coloresLenda.append((color, tarta.labels[i]))

lenda.colorNamePairs = coloresLenda


debuxo.add(lenda)
elementosDoc.append(debuxo)

documento = SimpleDocTemplate("exemploGrafico.pdf", pagesize = A4)
documento.build(elementosDoc)