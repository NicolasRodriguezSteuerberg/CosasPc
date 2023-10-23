import gi
gi.require_version("Gtk", "3.0")
from gi.repository import Gtk

class VentanaPrincipal (Gtk.Window):
    def __init__(self):
        super().__init__()
        self.set_title("Primera ventan con Gtk")

        caixa = Gtk.Box(orientation = Gtk.Orientation.VERTICAL, spacing = 10)

        imagen = Gtk.Image()
        imagen.set_from_file("dino.jpg")

        self.lblEtiqueta = Gtk.Label(label = "Hola a todos")

        # linea de texto editable
        self.editText = Gtk.Entry()
        # que si le des al enter se cambie el texto de la etiqueta
        self.editText.connect("activate",self.buttonPressed)

        btnBoton = Gtk.Button(label = "Pulsame")
        # evento a la hora de clickar el boton, nombre del evento, función que va a hacer
        btnBoton.connect("clicked",self.buttonPressed)

        # tienen expand y fill
        caixa.pack_start(imagen, True, True, 5)
        caixa.pack_start(self.lblEtiqueta,True, True, 5)
        caixa.pack_start(self.editText, True, True, 5)
        caixa.pack_start(btnBoton,True, False, 5)

        self.add(caixa)

        # para los listeners/eventos
        self.connect("delete-event", Gtk.main_quit) # sin los parentesis del método main_quit
        self.show_all()

    # button: sirve cualquier nombre para recoger una referencia al control que generó
    # la señal (el evento clicked), lo tiene que recibir SIEMPRE!!!
    def buttonPressed(self, boton):
        if len(self.editText.get_text())==0:
            self.lblEtiqueta.set_text("Pa que tocas")
        else:
            self.lblEtiqueta.set_text(self.editText.get_text())
        self.editText.set_text("")


if __name__ == "__main__":
    VentanaPrincipal()
    Gtk.main()