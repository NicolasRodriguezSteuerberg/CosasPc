import gi
gi.require_version("Gtk", "3.0")
from gi.repository import Gtk

class VentanaPrincipal ():
    def __init__(self):
        # para poder usar el archivo glade
        builder = Gtk.Builder()
        builder.add_from_file("PrimeraVentana.glade")

        self.TextEntry = builder.get_object("TextEntry")
        MyButton = builder.get_object("MyButton")

        self.MyLabel = builder.get_object("MyLabel")

        sinals = {
            "changeLabel" : self.changeLabel,
            "closeProject": Gtk.main_quit
        }

        builder.connect_signals(sinals)

    # sinalEvent: sirve cualquier nombre para recoger una referencia al control que generó
    # la señal (el evento clicked), lo tiene que recibir SIEMPRE!!!
    def changeLabel(self, sinalEvent):
        if len(self.TextEntry.get_text())==0:
            self.MyLabel.set_text("Pa que tocas")
        else:
            self.MyLabel.set_text(self.TextEntry.get_text())
        self.TextEntry.set_text("")


if __name__ == "__main__":
    VentanaPrincipal()
    Gtk.main()