import gi

gi.require_version("Gtk", "3.0")
from gi.repository import Gtk, Gdk

class GridLayout(Gtk.Grid):
    def __init__(self):
        super().__init__()

        button1 = Gtk.Button(label = "Boton 1")
        button2 = Gtk.Button(label="Boton 2")
        button3 = Gtk.Button(label="Boton 3")
        button4 = Gtk.Button(label="Boton 4")
        button5 = Gtk.Button(label="Boton 5")
        button6 = Gtk.Button(label="Boton 6")
        # widht -> filas a ocupar, height -> columnas a ocupar

        # fila 1
        self.attach(button1, 0, 0, 1, 1)
        self.attach_next_to(button2, button1, Gtk.PositionType.RIGHT, 2, 1)

        # fila 2
        self.attach_next_to(button3, button1, Gtk.PositionType.BOTTOM,1, 2)
        self.attach_next_to(button4,button2,Gtk.PositionType.BOTTOM,2,1)

        # fila 3
        self.attach_next_to(button5, button4, Gtk.PositionType.BOTTOM,1,1)
        self.attach_next_to(button6,button5, Gtk.PositionType.RIGHT,1,1)

class ButtonColorsPanel (Gtk.Box):
    def __init__(self):
        super().__init__()
        self.set_orientation(Gtk.Orientation.HORIZONTAL)
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

class VentanaPrincipal (Gtk.Window):
    def __init__(self):
        super().__init__()
        self.set_title("Primer stack layout en gtk")

        vBox = Gtk.Box(orientation = Gtk.Orientation.VERTICAL, spacing = 6)

        cardStack = Gtk.Stack()
        cardStack.set_transition_type(Gtk.StackTransitionType.SLIDE_LEFT_RIGHT)
        cardStack.set_transition_duration(1000)

        checkButton = Gtk.CheckButton(label = "Púlsame o arrepientete")

        cardStack.add_titled(checkButton, "Press", "Check button")

        lblMod = Gtk.Label()
        lblMod.set_markup("<big>Esta etiqueta es elegante</big>")

        cardStack.add_titled(lblMod, "etiqueta", "Etiqueta elegante")

        cardStack.add_titled(GridLayout(), "grid", "GridLayout")

        cardStack.add_titled(ButtonColorsPanel(),"colores", "caja colores")

        cardsButtons = Gtk.StackSwitcher()
        cardsButtons.set_stack(cardStack)

        vBox.add(cardStack)
        vBox.pack_start(cardsButtons, True, True, 0)
        self.add(vBox)

        self.connect("delete-event", Gtk.main_quit)  # sin los parentesis del método main_quit
        self.show_all()

if __name__ == "__main__":
    VentanaPrincipal()
    Gtk.main()