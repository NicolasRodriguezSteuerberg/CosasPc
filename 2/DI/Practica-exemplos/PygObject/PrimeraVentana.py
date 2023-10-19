import gi
gi.require_version("Gtk", "3.0")
from gi.repository import Gtk

class VentanaPrincipal (Gtk.Window):
    def __init__(self):
        super().__init__()
        self.set_title("Primera ventan con Gtk")

        caixa = Gtk.Box(orientation = Gtk.Orientation.HORIZONTAL, spacing = 10)

        imagen = Gtk.Image()
        imagen.set_from_file("dino.jpg")

        lblEtiqueta = Gtk.Label(label = "Hola a todos")

        btnBoton = Gtk.Button(label = "Pulsame")

        # tienen expand y fill
        caixa.pack_start(imagen, True, True, 5)
        caixa.pack_start(lblEtiqueta,True, True, 5)
        caixa.pack_start(btnBoton,True, False, 5)

        self.add(caixa)

        # para los listeners/eventos
        self.connect("delete-event", Gtk.main_quit) # sin los parentesis del método main_quit
        self.show_all()

if __name__ == "__main__":
    VentanaPrincipal()
    Gtk.main()