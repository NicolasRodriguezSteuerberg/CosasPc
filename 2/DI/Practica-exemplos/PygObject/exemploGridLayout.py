import gi

gi.require_version("Gtk", "3.0")
from gi.repository import Gtk

class VentanaPrincipal (Gtk.Window):
    def __init__(self):
        super().__init__()
        self.set_title("Primera ventan con Gtk")

        button1 = Gtk.Button(label = "Boton 1")
        button2 = Gtk.Button(label="Boton 2")
        button3 = Gtk.Button(label="Boton 3")
        button4 = Gtk.Button(label="Boton 4")
        button5 = Gtk.Button(label="Boton 5")
        button6 = Gtk.Button(label="Boton 6")

        # añadimos los elementos al grid
        grid = Gtk.Grid()
        # widht -> filas a ocupar, height -> columnas a ocupar

        # fila 1
        grid.attach(button1, 0, 0, 1, 1)
        grid.attach_next_to(button2, button1, Gtk.PositionType.RIGHT, 2, 1)

        # fila 2
        grid.attach_next_to(button3, button1, Gtk.PositionType.BOTTOM,1, 2)
        grid.attach_next_to(button4,button2,Gtk.PositionType.BOTTOM,2,1)

        # fila 3
        grid.attach_next_to(button5, button4, Gtk.PositionType.BOTTOM,1,1)
        grid.attach_next_to(button6,button5, Gtk.PositionType.RIGHT,1,1)
        # metes el elemento a la derecha o abajo de otro elemento
        # grid.attach_next_to(button2, button1, )

        self.add(grid)

        # para los listeners/eventos
        self.connect("delete-event", Gtk.main_quit) # sin los parentesis del método main_quit
        self.show_all()


if __name__ == "__main__":
    VentanaPrincipal()
    Gtk.main()