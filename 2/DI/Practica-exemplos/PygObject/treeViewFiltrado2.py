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

        caja = Gtk.Box(orientation=Gtk.Orientation.HORIZONTAL,spacing=4)

        # la lista
        caixa = Gtk.Box(orientation=Gtk.Orientation.VERTICAL, spacing=4)

        self.filtradoXenero="None"

        # Establecemos el tipo que tendra en cada columna
        modelo = Gtk.ListStore(str, str, int, str, bool)
        modelo_filtrado = modelo.filter_new()
        modelo_filtrado.set_visible_func(self.filtrar_usuarios_xenero)

        filaSeleccionada = self.miTreeView.get_selection()
        filaSeleccionada.connect("changed", self.on_rowSelection_changed)

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

        caja.pack_start(caixa, True, True, 0)


        # para añadir, editar...
        cajaDatosGeneral = Gtk.Box(orientation=Gtk.Orientation.VERTICAL, spacing=10)

        # para las labels y los cuadros de texto
        cajaDatos = Gtk.Box(orientation=Gtk.Orientation.HORIZONTAL, spacing=5)
        # etiqueta y cuadro de texto nombre
        lblNombre = Gtk.Label(label="Nome")
        self.txtNombre = Gtk.Entry()
        # dni
        lblDni = Gtk.Label(label="DNI")
        self.txtDni = Gtk.Entry()
        # edad
        lblEdad = Gtk.Label(label="Edade")
        self.txtEdad = Gtk.Entry()

        # añadimos las cosas
        cajaDatos.pack_start(lblNombre, True, True, 0)
        cajaDatos.pack_start(self.txtNombre, True, True, 0)
        cajaDatos.pack_start(lblDni, True, True, 0)
        cajaDatos.pack_start(self.txtDni, True, True, 0)
        cajaDatos.pack_start(lblEdad, True, True, 0)
        cajaDatos.pack_start(self.txtEdad, True, True, 0)

        # caja para el radioButton
        cajaRadioButtons = Gtk.Box(orientation=Gtk.Orientation.HORIZONTAL, spacing=5)
        # creamos la etiqueta
        lblEtiqueta = Gtk.Label(label="Xénero")
        # creamos los radio buttons
        rbtDatosHome = Gtk.RadioButton.new_with_label_from_widget(None, "Home")
        rbtDatosHome.connect("toggled", self.on_rbt_toggled2, "Home")
        rbtDatosMuller = Gtk.RadioButton.new_with_label_from_widget(rbtDatosHome, "Muller")
        rbtDatosMuller.connect("toggled", self.on_rbt_toggled2, "Muller")
        rbtDatosOutros = Gtk.RadioButton.new_with_label_from_widget(rbtDatosHome, "Outros")
        rbtDatosOutros.connect("toggled", self.on_rbt_toggled2, "Outros")

        # añadimos los radio a la caja
        cajaRadioButtons.pack_start(lblEtiqueta, True, True, 0)
        cajaRadioButtons.pack_start(rbtDatosHome, True, True, 0)
        cajaRadioButtons.pack_start(rbtDatosMuller, True, True, 0)
        cajaRadioButtons.pack_start(rbtDatosOutros, True, True, 0)
        self.generoActivo = "Home"
        # caja para los botones
        cajaBotones = Gtk.Box(orientation=Gtk.Orientation.HORIZONTAL, spacing=5)
        # variable para aceptar y cancelar
        # 0 -> nada, 1 -> Nuevo, 2 -> Editar
        self.aceptarFlag = 0

        self.btnNuevo = Gtk.Button(label="Nuevo")
        self.btnNuevo.connect("clicked", self.btnNuevoPulsado)
        self.btnEditar = Gtk.Button(label="Editar")
        self.btnEditar.connect("clicked", self.btnEditarPulsado)
        self.btnAceptar = Gtk.Button(label="Aceptar")
        self.btnAceptar.connect("clicked", self.aceptar_pulsado, modelo, modelo_filtrado)
        self.btnCancelar = Gtk.Button(label="Cancelar")
        self.btnCancelar.connect("clicked", self.cancelar_pulsado)
        cajaBotones.pack_start(self.btnNuevo, True, True, 0)
        cajaBotones.pack_start(self.btnEditar, True, True, 0)
        cajaBotones.pack_start(self.btnAceptar, True, True, 0)
        cajaBotones.pack_start(self.btnCancelar, True, True, 0)

        # añadimos las cajas al general
        cajaDatosGeneral.pack_start(cajaDatos, True, True, 0)
        cajaDatosGeneral.pack_start(cajaRadioButtons, True, True, 0)
        cajaDatosGeneral.pack_start(cajaBotones, True, True, 0)

        caja.pack_start(cajaDatosGeneral, True, True, 0)

        self.add(caja)

        self.connect("delete-event",Gtk.main_quit)  ## la el segundo argumento no debe tener el parentesis de funcion, ya que en ese caso la ejecutaria

        self.show_all()

        # ocultamos los botones Aceptar y Cancelar
        self.btnAceptar.hide()
        self.btnCancelar.hide()

    def on_rowSelection_changed(self, selection):
        model, treeiter = selection.get_selected()
        if treeiter is not None:
            # Obtener los valores de las columnas para la fila seleccionada
            self.txtDni.set_text(model[treeiter][0])
            nombre = model[treeiter][1]
            edad = model[treeiter][2]
            genero = model[treeiter][3]
            activo = model[treeiter][4]

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

    def on_rbt_toggled2(self, botonSeleccionado, genero):
        if botonSeleccionado.get_active():
            self.generoActivo = genero

    def btnNuevoPulsado(self,banderaboton):
        self.aceptarFlag = 1
        self.cambiar_botones_verAC()

    def btnEditarPulsado(self,banderaboton):
        self.aceptarFlag = 2
        self.cambiar_botones_verNE()

    # ocultar botones nuevo y editado + mostrar botones aceptar y cancelar
    def cambiar_botones_verAC(self):
        self.btnNuevo.hide()
        self.btnEditar.hide()

        self.btnAceptar.show()
        self.btnCancelar.show()

    def cambiar_botones_verNE(self):
        self.btnAceptar.hide()
        self.btnCancelar.hide()

        self.btnNuevo.show()
        self.btnEditar.show()

    def aceptar_pulsado(self, banderaboton, modelo, modelo_filtrado):
        if self.aceptarFlag == 1:
            self.engadir_usuario(modelo, modelo_filtrado)
        elif self.aceptarFlag ==2:
            self.editar_usuario(modelo, modelo_filtrado)
        else:
            print("Error al aceptar")

    def cancelar_pulsado(self, banderaboton):
        self.cambiar_botones_verNE()

    def engadir_usuario(self,modelo, modelo_filtrado):
        if (self.txtDni!="" and self.txtNombre!="" and self.txtEdad!=""):
            self.engadir_bdusuario(self.txtNombre.get_text(), self.txtDni.get_text(), int(self.txtEdad.get_text()), self.generoActivo)
            modelo.append((self.txtDni.get_text(), self.txtNombre.get_text(), int(self.txtEdad.get_text()), self.generoActivo, True))
            modelo_filtrado.refilter()
            self.cambiar_botones_verNE()

    def engadir_bdusuario(self, nome, dni, edade, genero):
        try:
            database = dbapi.connect("baseDatos2.dat")
            cursor = database.cursor()
            cursor.execute("insert into usuarios values(?,?,?,?,?)", (dni,nome,edade,genero,True))
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

    def editar_usuario(self, modelo, modelo_filtrado):
        self.editar_usuarioBD(self.txtNombre.get_text(), self.txtDni.get_text(), int(self.txtEdad.get_text()), self.generoActivo)

    def editar_usuarioBD(self, nome, dni, edade, genero):
        try:
            database = dbapi.connect("baseDatos2.dat")
            cursor = database.cursor()
            cursor.execute("update usuarios set nome = ?, edade = ?, xenero = ? where dni = ?", (nome, edade, genero, dni))
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
if __name__ == "__main__":
    FestraPrincipal()
    Gtk.main()