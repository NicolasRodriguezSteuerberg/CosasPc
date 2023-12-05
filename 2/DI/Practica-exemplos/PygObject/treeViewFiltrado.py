import gi
import sqlite3 as dbapi

gi.require_version("Gtk", "3.0")
from gi.repository import Gtk, Pango
# para que funcione primero tenemos que tener la base de datos creada


class FestraPrincipal(Gtk.Window):
    def __init__(self):
        super().__init__()
        self.set_title("Ejemplo Treeview Filtrado")

        self.set_default_size(250, 100)
        self.set_border_width(10)

        caixa = Gtk.Box(orientation=Gtk.Orientation.VERTICAL, spacing=4)

        # Establecemos el tipo que tendra en cada columna
        modelo = Gtk.ListStore(str, str, int, str, bool)
        try:
            database = dbapi.connect("baseDatos2.dat")
            cursor = database.cursor()
            cursor.execute("select * from usuarios")
            for usuario in cursor:
                modelo.append(usuario)
        except dbapi.StandardError as e:
            print(e)
        except dbapi.DatabaseError as e:
            print(e)
        finally:
            cursor.close()
            database.close()

        self.miTreeView = Gtk.TreeView(model=modelo)
        selection = self.miTreeView.get_selection()
        for i, nombreColumna in enumerate(["DNI", "Nombre", "Edad"]):
            celda = Gtk.CellRendererText()
            col = Gtk.TreeViewColumn(nombreColumna, celda, text=i)
            self.miTreeView.append_column(col)

        # celda con barra de progreso para la edad (para probar)
        celda = Gtk.CellRendererProgress()
        col = Gtk.TreeViewColumn(nombreColumna, celda, value=2) # 2 es el indice de la columna de la edad
        self.miTreeView.append_column(col)

        # celda con combo
        modeloCombo = Gtk.ListStore(str)
        modeloCombo.append(("Home",))
        modeloCombo.append(("Muller",))
        modeloCombo.append(("Outros",))
        celdaCombo = Gtk.CellRendererCombo()
        celdaCombo.set_property("editable", True)
        celdaCombo.props.model = modeloCombo
        # celdaCombo.set_property("model", modeloCombo)
        celdaCombo.set_property("text-column", 0) # esto es el indice de la columna
        celdaCombo.set_property("has-entry", False)
        columna = Gtk.TreeViewColumn("Xenero", celdaCombo, text=3)
        self.miTreeView.append_column(columna)


        caixa.pack_start(self.miTreeView, True, True, 0)

        self.add(caixa)

        self.connect("delete-event",Gtk.main_quit)  ## la el segundo argumento no debe tener el parentesis de funcion, ya que en ese caso la ejecutaria

        self.show_all()


if __name__ == "__main__":
    FestraPrincipal()
    Gtk.main()