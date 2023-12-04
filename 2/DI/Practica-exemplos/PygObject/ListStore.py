import gi
import sqlite3 as dbapi

gi.require_version("Gtk", "3.0")
from gi.repository import Gtk, Pango

columnas = ("Nombre", "Apellido", "Numero de teléfono")
agendaTelefonica = (("Pepe", "Pérez", "986 444 555"),
                    ("Ana", "Yañéz", "985 333 777"),
                    ("Roque", "Díz", "987 222 889"),
                    )


class FestraPrincipal(Gtk.Window):
    def __init__(self):
        super().__init__()
        self.set_title("Ejemplo listin telefonico con Treeview")

        self.set_default_size(250, 100)
        self.set_border_width(10)

        # Establecemos el tipo que tendra en cada columna
        modelo = Gtk.ListStore(str, str, str)
        try:
            database = dbapi.connect("baseDatosListaTelefonos.dat")
            # print(database)
            cursor = database.cursor()
            cursor.execute("select * from listaTelefonos")
            for usuario in cursor:
                modelo.append(usuario)
            cursor.close()
            database.close()
        except dbapi.StandardError as e:
            print(e)
        except dbapi.DatabaseError as e:
            print(e)
        self.vistaVerdista = Gtk.TreeView(model=modelo)
        cambiar = self.vistaVerdista.get_selection()
        cambiar.connect("changed", self.on_obxectoSeleccion_changed)
        for i, nombreColumna in enumerate(columnas):
            celda = Gtk.CellRendererText()
            if i == 0:
                celda.props.weight_set = True
                celda.props.weight = Pango.Weight.BOLD
            if i == 2:
                celda.props.editable = True
                celda.connect("edited", self.on_celda_edited, modelo)
            col = Gtk.TreeViewColumn(nombreColumna, celda, text=i)
            self.vistaVerdista.append_column(col)

        """
        El tema es que esto tiene varias cosas que darle.

        Darle un modelo, luego el treeview, luego un Gtk.TreeviewColumn, y luego los celdas
        """

        ## Box almacena los objetos que puedan haber en el entorno grafico
        caja = Gtk.Box(orientation=Gtk.Orientation.VERTICAL, spacing=10)
        caja.pack_start(self.vistaVerdista, True, True, 0)

        grid = Gtk.Grid()
        grid.set_row_spacing(5)
        grid.set_column_spacing(10)
        caja.pack_start(grid, True, True, 0)

        # etiquetas del grid
        lblNome = Gtk.Label(label="Nombre")
        lblApelido = Gtk.Label(label="Apellido")
        lblTelefono = Gtk.Label(label="Telefono")

        # textos de las etiquetas
        self.txtNome = Gtk.Entry()
        self.txtApelido = Gtk.Entry()
        self.txtTelefono = Gtk.Entry()

        # botones
        btnEngadir = Gtk.Button(label="Engadir")
        btnEngadir.connect("clicked", self.on_engadir_clicked, modelo)
        btnEliminar = Gtk.Button(label="Eliminar")
        btnEliminar.connect("clicked", self.on_eliminar_clicked, cambiar)

        # añadimos al grid
        grid.add(lblNome)
        grid.attach_next_to(self.txtNome, lblNome, Gtk.PositionType.RIGHT, 1, 1)
        grid.attach_next_to(lblApelido, self.txtNome, Gtk.PositionType.RIGHT, 1, 1)
        grid.attach_next_to(self.txtApelido, lblApelido, Gtk.PositionType.RIGHT, 1, 1)
        grid.attach_next_to(lblTelefono, lblNome, Gtk.PositionType.BOTTOM, 1 ,1)
        grid.attach_next_to(self.txtTelefono, lblTelefono, Gtk.PositionType.RIGHT, 1, 1)
        grid.attach_next_to(btnEngadir, self.txtTelefono, Gtk.PositionType.RIGHT, 2, 1)
        grid.attach_next_to(btnEliminar, lblTelefono, Gtk.PositionType.BOTTOM, 4, 1)


        self.add(caja)

        self.connect("delete-event",Gtk.main_quit)  ## la el segundo argumento no debe tener el parentesis de funcion, ya que en ese caso la ejecutaria

        self.show_all()

    def on_obxectoSeleccion_changed(self, seleccion):
        (modelo, fila) = seleccion.get_selected()
        self.txtNome.set_text(modelo[fila][0])
        self.txtApelido.set_text(modelo[fila][1])
        self.txtTelefono.set_text(modelo[fila][2])

    def on_engadir_clicked(self, boton, modelo):
        nome = self.txtNome.get_text()
        apelido = self.txtApelido.get_text()
        telefono = self.txtTelefono.get_text()
        if (nome != "" and apelido != "" and telefono != ""):
            modelo.append((nome, apelido, telefono))
            self.insertarDatos(nome, apelido, telefono)
            self.txtNome.set_text("")
            self.txtApelido.set_text("")
            self.txtTelefono.set_text("")

    def insertarDatos(self, nome, apelido, telefono):
        try:
            database = dbapi.connect("baseDatosListaTelefonos.dat")
            # print(database)
            cursor = database.cursor()
            cursor.execute("insert into listaTelefonos values (?,?,?)", (nome, apelido, telefono))
            database.commit()

            cursor.close()
            database.close()
        except dbapi.DatabaseError as e:
            print(e)

    def on_eliminar_clicked(self, boton, selection):
        (modelo, fila) = selection.get_selected()
        self.eliminarDatos(modelo[fila][0], modelo[fila][1], modelo[fila][2])
        modelo.remove(fila)
        self.txtNome.set_text("")
        self.txtApelido.set_text("")
        self.txtTelefono.set_text("")

    def eliminarDatos(self, nome, apelido, telefono):
        try:
            database = dbapi.connect("baseDatosListaTelefonos.dat")
            # print(database)
            cursor = database.cursor()
            cursor.execute("delete from listaTelefonos where nome = ? and apelido = ? and telefono = ?", (nome, apelido, telefono))
            database.commit()

            cursor.close()
            database.close()

        except dbapi.StandardError as e:
            print(e)
        except dbapi.DatabaseError as e:
            print(e)

    def on_celda_edited(self, celda, fila, texto, modelo):
        modelo[fila][2] = texto
        self.actualizarDatos(modelo[fila][0], modelo[fila][1], modelo[fila][2])

    def actualizarDatos(self, nome, apelido, telefono):
        try:
            database = dbapi.connect("baseDatosListaTelefonos.dat")
            # print(database)
            cursor = database.cursor()
            cursor.execute("update listaTelefonos set telefono = ? where nome = ? and apelido = ?", (telefono, nome, apelido))
            database.commit()

            cursor.close()
            database.close()

        except dbapi.StandardError as e:
            print(e)
        except dbapi.DatabaseError as e:
            print(e)


if __name__ == "__main__":
    FestraPrincipal()
    Gtk.main()