import gi
import sqlite3 as dbapi

gi.require_version("Gtk", "3.0")
from gi.repository import Gtk

class FestraPrincipal(Gtk.Window):
    def __init__(self):
        super().__init__()
        self.set_title("Ejemplo TreeView con CellRendererPixbuf")

        self.set_default_size(250, 100)
        self.set_border_width(10)

        caja = Gtk.Box(orientation=Gtk.Orientation.VERTICAL, spacing=4)

        # Establecemos el tipo que tendra en cada columna
        modelo = Gtk.ListStore(str, str)
        modelo.append(("Nuevo", "document-new"))
        modelo.append(("Abrir", "document-open"))
        modelo.append(("Guardar", "document-save"))

        treeView = Gtk.TreeView(model = modelo)

        celdaTexto = Gtk.CellRendererText()
        col_texto = Gtk.TreeViewColumn("Texto", celdaTexto, text = 0)
        treeView.append_column(col_texto)

        celdaImaxe = Gtk.CellRendererPixbuf()
        col_imaxe = Gtk.TreeViewColumn("Imaxe", celdaImaxe, icon_name = 1)
        treeView.append_column(col_imaxe)

        caja.pack_start(treeView, True, True, 0)

        self.add(caja)

        self.connect("delete-event",Gtk.main_quit)  ## la el segundo argumento no debe tener el parentesis de funcion, ya que en ese caso la ejecutaria

        self.show_all()


if __name__ == "__main__":
    FestraPrincipal()
    Gtk.main()