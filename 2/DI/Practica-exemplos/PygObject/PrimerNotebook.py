import gi

gi.require_version("Gtk", "3.0")
from gi.repository import Gtk

from ColorBoxBotons import BoxConBotons

class VentanaNotebook(Gtk.Window):
    def __init__(self):
        super().__init__()
        self.set_title("Primera ventan con Gtk")

        notebook = Gtk.Notebook()

        # creo una pagina
        page1 = Gtk.Box()
        page1.set_border_width(10)
        page1.add(Gtk.Label(label = "Páxina por defecto"))
        # añado la pagina al notebook
        notebook.append_page(page1,Gtk.Label(label = "Titulo"))

        # creo otra pagina
        page2 = Gtk.Box()
        page2.set_border_width(100)
        image = Gtk.Image()
        image.set_from_file("dino.jpg")
        page2.add(image)
        # añado la pagina al notebook
        notebook.append_page(page2,Gtk.Image.new_from_icon_name("help-about",Gtk.IconSize.MENU))

        page3 = BoxConBotons()
        page3.set_border_width(10)
        notebook.append_page(page3,Gtk.Label(label = "Botones"))


        self.add(notebook)
        self.connect("delete-event", Gtk.main_quit)  # sin los parentesis del método main_quit
        self.show_all()

if __name__ == "__main__":
    VentanaNotebook()
    Gtk.main()