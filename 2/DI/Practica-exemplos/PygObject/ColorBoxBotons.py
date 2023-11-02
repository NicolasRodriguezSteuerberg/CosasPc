import gi

gi.require_version("Gtk", "3.0")
from gi.repository import Gtk, Gdk

class BoxConBotons (Gtk.Box):
    def __init__(self):
        super().__init__()

        self.set_orientation(orientation = Gtk.Orientation.HORIZONTAL)
        self.set_spacing(5)

        caixa1Color = Gtk.Box(orientation = Gtk.Orientation.VERTICAL, spacing = 10)
        caixa2Color = Gtk.Box(orientation = Gtk.Orientation.VERTICAL, spacing = 10)

        # añadimos los botones a la caja
        caixa1Color.pack_start(self.buttonWithColor("red"), True, True, 5)
        caixa1Color.pack_start(self.buttonWithColor("yellow"), True, True, 5)
        caixa1Color.pack_start(self.buttonWithColor("purple"), True, True, 5)

        # hacemos los botones de la segunda caja y se los añadimos
        caixa2Color.pack_start(self.buttonWithColor("red"), True, True, 5)
        caixa2Color.pack_start(self.buttonWithColor("purple"), True, True, 5)

        # tienen expand y fill
        self.pack_start(caixa1Color,True, True, 5)
        self.pack_start(self.buttonWithColor("green"), True, True, 5)
        self.pack_start(caixa2Color, True, True, 5)

    def on_debuxa(self, control, cr, datos):
        contexto = control.get_style_context()
        ancho = control.get_allocated_width()
        alto = control.get_allocated_height()
        Gtk.render_background(contexto,cr,0,0, ancho, alto)

        r, g, b, a = datos["color"]
        cr.set_source_rgba (r, g, b, a)
        cr.rectangle(0, 0, ancho, alto)
        cr.fill()

    def buttonWithColor(self, color):
        rgba = Gdk.RGBA()
        rgba.parse(color)

        boton = Gtk.Button()
        area = Gtk.DrawingArea()
        area.set_size_request(32,24)
        area.connect("draw",self.on_debuxa, {"color": rgba})

        boton.add(area)
        return boton

    # button: sirve cualquier nombre para recoger una referencia al control que generó
    # la señal (el evento clicked), lo tiene que recibir SIEMPRE!!!
    def buttonPressed(self, boton):
        if len(self.editText.get_text())==0:
            self.lblEtiqueta.set_text("Pa que tocas")
        else:
            self.lblEtiqueta.set_text(self.editText.get_text())
        self.editText.set_text("")