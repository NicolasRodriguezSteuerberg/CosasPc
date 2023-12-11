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

        self.filtradoXenero="None"

        # Establecemos el tipo que tendra en cada columna
        modelo = Gtk.ListStore(str, str, int, str, bool)
        modelo_filtrado = modelo.filter_new()
        modelo_filtrado.set_visible_func(self.filtrar_usuarios_xenero)
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

        #self.miTreeView = Gtk.TreeView(model=modelo)
        self.miTreeView = Gtk.TreeView(model=modelo_filtrado)
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
        celdaCombo.connect("edited", self.on_celdaCombo_edited, modelo_filtrado, 3)
        columna = Gtk.TreeViewColumn("Xenero", celdaCombo, text=3)
        self.miTreeView.append_column(columna)

        caixa.pack_start(self.miTreeView, True, True, 0)

        caixaH = Gtk.Box(orientation=Gtk.Orientation.HORIZONTAL, spacing=2)
        caixa.pack_start(caixaH, True, True, 0)
        rbtAll = Gtk.RadioButton.new_with_label(None, "All")
        rbtHome = Gtk.RadioButton.new_with_label_from_widget(rbtAll, "Home")
        rbtMuller = Gtk.RadioButton.new_with_label_from_widget(rbtAll, "Muller")
        rbtOutros = Gtk.RadioButton.new_with_label_from_widget(rbtAll, "Outros")
        caixaH.pack_start(rbtAll, True, True, 2)
        caixaH.pack_start(rbtHome, True, True, 2)
        caixaH.pack_start(rbtMuller, True, True, 2)
        caixaH.pack_start(rbtOutros, True, True, 2)

        rbtAll.connect("toggled", self.on_rbt_toggled, "None", modelo_filtrado)
        rbtHome.connect("toggled", self.on_rbt_toggled, "Home", modelo_filtrado)
        rbtMuller.connect("toggled", self.on_rbt_toggled, "Muller", modelo_filtrado)
        rbtOutros.connect("toggled", self.on_rbt_toggled, "Outros", modelo_filtrado)

        self.add(caixa)

        self.connect("delete-event",Gtk.main_quit)  ## la el segundo argumento no debe tener el parentesis de funcion, ya que en ese caso la ejecutaria

        self.show_all()

    def on_celdaCombo_edited(self, celda, fila, texto, modelo, indice):
        cambiado = self.modificarComboBD(texto,modelo,fila)
        if cambiado:
            modelo[fila][indice] = texto
        else:
            print("Error al cambiar")

    def modificarComboBD(self, texto, modelo, fila):
        try:
            database = dbapi.connect("baseDatos2.dat")
            cursor = database.cursor()
            cursor.execute("update usuarios set xenero = ? where dni = ?", (texto, modelo[fila][0]))
            database.commit()
            return True
        except dbapi.StandardError as e:
            print(e)
            return False
        except dbapi.DatabaseError as e:
            print(e)
            return False
        finally:
            cursor.close()
            database.close()

    def on_rbt_toggled(self, botonSeleccionado, genero, modelo):
        if botonSeleccionado.get_active():
            self.filtradoXenero = genero
            modelo.refilter()

    def filtrar_usuarios_xenero(self, modelo, fila, datos):
        if self.filtradoXenero == "None" or self.filtradoXenero is None:
            return True
        else:
            return modelo[fila][3] == self.filtradoXenero

if __name__ == "__main__":
    FestraPrincipal()
    Gtk.main()