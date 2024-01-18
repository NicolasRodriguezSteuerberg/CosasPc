import gi
import sqlite3 as dbapi

from gi.overrides.Gdk import Gdk

gi.require_version("Gtk", "3.0")
from gi.repository import Gtk, Pango
# para que funcione primero tenemos que tener la base de datos creada

class FestraPrincipal(Gtk.Window):
    def __init__(self):
        super().__init__()
        self.set_title("Ejemplo Treeview Filtrado")

        self.set_default_size(250, 100)
        self.set_border_width(10)

        # caja general
        self.css_provider = Gtk.CssProvider()
        self.css_provider.load_from_path('estilo.css')

        self.contexto = Gtk.StyleContext()
        self.screen = Gdk.Screen.get_default()
        self.contexto.add_provider_for_screen(self.screen, self.css_provider, Gtk.STYLE_PROVIDER_PRIORITY_APPLICATION)

        caja_general = Gtk.Box(orientation=Gtk.Orientation.HORIZONTAL,spacing=4)

        # la lista
        caja_tabla = Gtk.Box(orientation=Gtk.Orientation.VERTICAL, spacing=4)

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

        # Creamos un scroll
        fiestraScroll = Gtk.ScrolledWindow()
        fiestraScroll.set_policy(Gtk.PolicyType.NEVER, Gtk.PolicyType.AUTOMATIC)
        fiestraScroll.set_size_request(100, 132)
        #self.miTreeView = Gtk.TreeView(model=modelo)
        self.miTreeView = Gtk.TreeView(model=modelo_filtrado)
        selection = self.miTreeView.get_selection()
        selection.connect("changed", self.on_obxectoSeleccion_changed)

        # Añadimos el treeview al scroll
        fiestraScroll.add(self.miTreeView)

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

        caja_tabla.pack_start(fiestraScroll, True, True, 0)

        caja_ordenar = Gtk.Box(orientation=Gtk.Orientation.HORIZONTAL, spacing=2)
        caja_tabla.pack_start(caja_ordenar, True, True, 0)
        rbtAll = Gtk.RadioButton.new_with_label(None, "All")
        rbtHome = Gtk.RadioButton.new_with_label_from_widget(rbtAll, "Home")
        rbtMuller = Gtk.RadioButton.new_with_label_from_widget(rbtAll, "Muller")
        rbtOutros = Gtk.RadioButton.new_with_label_from_widget(rbtAll, "Outros")
        caja_ordenar.pack_start(rbtAll, True, True, 2)
        caja_ordenar.pack_start(rbtHome, True, True, 2)
        caja_ordenar.pack_start(rbtMuller, True, True, 2)
        caja_ordenar.pack_start(rbtOutros, True, True, 2)

        rbtAll.connect("toggled", self.on_rbt_toggled, "None", modelo_filtrado)
        rbtHome.connect("toggled", self.on_rbt_toggled, "Home", modelo_filtrado)
        rbtMuller.connect("toggled", self.on_rbt_toggled, "Muller", modelo_filtrado)
        rbtOutros.connect("toggled", self.on_rbt_toggled, "Outros", modelo_filtrado)

        caja_general.pack_start(caja_tabla, True, True, 0)


        # para añadir, editar...
        cajaDatosGeneral = Gtk.Box(orientation=Gtk.Orientation.VERTICAL, spacing=10)

        # para las labels y los cuadros de texto
        cajaDatos = Gtk.Box(orientation=Gtk.Orientation.HORIZONTAL, spacing=5)
        # etiqueta y cuadro de texto nombre
        self.lblNombre = Gtk.Label(label="Nome")
        self.txtNombre = Gtk.Entry()
        self.txtNombre.set_width_chars(15)
        self.txtNombre.set_max_length(15)

        # dni
        self.lblDni = Gtk.Label(label="DNI")
        self.txtDni = Gtk.Entry()
        self.txtDni.set_width_chars(9)
        self.txtDni.set_max_length(9)

        # edad
        self.lblEdad = Gtk.Label(label="Edade")
        self.txtEdad = Gtk.Entry()
        self.txtEdad.set_width_chars(3)
        self.txtEdad.set_max_length(3)

        # añadimos las cosas
        cajaDatos.pack_start(self.lblNombre, True, True, 0)
        cajaDatos.pack_start(self.txtNombre, True, True, 0)
        cajaDatos.pack_start(self.lblDni, True, True, 0)
        cajaDatos.pack_start(self.txtDni, True, True, 0)
        cajaDatos.pack_start(self.lblEdad, True, True, 0)
        cajaDatos.pack_start(self.txtEdad, True, True, 0)

        # caja para el radioButton
        cajaRadioButtons = Gtk.Box(orientation=Gtk.Orientation.HORIZONTAL, spacing=5)
        # creamos la etiqueta
        lblEtiqueta = Gtk.Label(label="Xénero")
        # creamos los radio buttons
        self.rbtDatosHome = Gtk.RadioButton.new_with_label_from_widget(None, "Home")
        self.rbtDatosHome.connect("toggled", self.on_gender_changed, "Home")
        self.rbtDatosMuller = Gtk.RadioButton.new_with_label_from_widget(self.rbtDatosHome, "Muller")
        self.rbtDatosMuller.connect("toggled", self.on_gender_changed, "Muller")
        self.rbtDatosOutros = Gtk.RadioButton.new_with_label_from_widget(self.rbtDatosHome, "Outros")
        self.rbtDatosOutros.connect("toggled", self.on_gender_changed, "Outros")

        # bloqueamos los campos de texto y los radio buttons
        self.bloquear_campos_texto()

        # añadimos los radio a la caja
        cajaRadioButtons.pack_start(lblEtiqueta, True, True, 0)
        cajaRadioButtons.pack_start(self.rbtDatosHome, True, True, 0)
        cajaRadioButtons.pack_start(self.rbtDatosMuller, True, True, 0)
        cajaRadioButtons.pack_start(self.rbtDatosOutros, True, True, 0)
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

        caja_general.pack_start(cajaDatosGeneral, True, True, 0)

        self.add(caja_general)

        self.connect("delete-event",Gtk.main_quit)  ## la el segundo argumento no debe tener el parentesis de funcion, ya que en ese caso la ejecutaria

        self.show_all()

        # no dejamos tocar los botones Aceptar y Cancelar
        self.btnAceptar.set_sensitive(False)
        self.btnCancelar.set_sensitive(False)

    def on_obxectoSeleccion_changed(self, seleccion):
        (modelo, fila) = seleccion.get_selected()

        self.txtNombre.set_text(modelo[fila][1])
        self.txtDni.set_text(modelo[fila][0])
        self.txtEdad.set_text(str(modelo[fila][2]))
        if modelo[fila][3] == "Home":
            self.rbtDatosHome.set_active(True)
        elif modelo[fila][3] == "Muller":
            self.rbtDatosMuller.set_active(True)
        elif modelo[fila][3] == "Outros":
            self.rbtDatosOutros.set_active(True)


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

    def on_gender_changed(self, botonSeleccionado, genero):
        if botonSeleccionado.get_active():
            self.generoActivo = genero

    def vaciar_campos(self):
        self.txtNombre.set_text("")
        self.txtDni.set_text("")
        self.txtEdad.set_text("")

    def btnNuevoPulsado(self,banderaboton):
        self.aceptarFlag = 1
        self.vaciar_campos()
        self.cambiar_botones_verAC()

    def btnEditarPulsado(self,banderaboton):
        self.aceptarFlag = 2
        self.cambiar_botones_verAC()

    def bloquear_campos_texto(self):
        self.txtNombre.set_sensitive(False)
        self.txtDni.set_sensitive(False)
        self.txtEdad.set_sensitive(False)

        self.rbtDatosHome.set_sensitive(False)
        self.rbtDatosMuller.set_sensitive(False)
        self.rbtDatosOutros.set_sensitive(False)


    # ocultar botones nuevo y editado + mostrar botones aceptar y cancelar
    def cambiar_botones_verAC(self):
        self.btnNuevo.set_sensitive(False)
        self.btnEditar.set_sensitive(False)

        self.btnAceptar.set_sensitive(True)
        self.btnCancelar.set_sensitive(True)

        self.txtNombre.set_sensitive(True)
        self.txtDni.set_sensitive(True)
        self.txtEdad.set_sensitive(True)

        self.rbtDatosHome.set_sensitive(True)
        self.rbtDatosMuller.set_sensitive(True)
        self.rbtDatosOutros.set_sensitive(True)

    def cambiar_botones_verNE(self):
        self.btnAceptar.set_sensitive(False)
        self.btnCancelar.set_sensitive(False)

        self.btnNuevo.set_sensitive(True)
        self.btnEditar.set_sensitive(True)

        self.bloquear_campos_texto()

    def aceptar_pulsado(self, banderaboton, modelo, modelo_filtrado):
        self.lblNombre.set_name("normal")
        self.lblDni.set_name("normal")
        self.lblEdad.set_name("normal")
        self.contexto.add_provider_for_screen(self.screen, self.css_provider, Gtk.STYLE_PROVIDER_PRIORITY_APPLICATION)
        if self.aceptarFlag == 1:
            self.engadir_usuario(modelo, modelo_filtrado)
        elif self.aceptarFlag ==2:
            self.editar_usuario(modelo, modelo_filtrado)
        else:
            print("Error al aceptar")

    def cancelar_pulsado(self, banderaboton):
        self.lblNome.set_name("normal")
        self.lblDni.set_name("normal")
        self.lblEdad.set_name("normal")
        self.contexto.add_provider_for_screen(self.screen, self.css_provider, Gtk.STYLE_PROVIDER_PRIORITY_APPLICATION)
        self.cambiar_botones_verNE()

    def engadir_usuario(self,modelo, modelo_filtrado):
        # comprobrar que la edad, dni y nombre son correctos para poder añadir
        if(self.comprobaciones(self.txtDni.get_text(), self.txtNombre.get_text(), self.txtEdad.get_text())):
            # recoger datos
            dni = self.txtDni.get_text()
            edad = int(self.txtEdad.get_text())
            nombre = self.txtNombre.get_text()
            genero = self.generoActivo
            # añadir los datos
            self.engadir_bdusuario(nombre, dni, edad, genero)
            modelo.append((dni, nombre, edad, genero, True))
            # refiltramos
            modelo_filtrado.refilter()
            # cambiamos la visibilidad de los botones
            self.vaciar_campos()
            self.cambiar_botones_verNE()

    def comprobaciones(self, dni, nombre, edad):
        if(self.comprobar_dni(dni) and self.comprobar_edad(edad)):
            return True
        else:
            return False

    def comprobar_dni(self, dni):
        if len(dni) == 9 and dni[0:8].isdigit() and dni[8].isalpha():
                return True
        else:
            # change color of the text
            self.lblDni.set_name("error")
            self.contexto.add_provider_for_screen(self.screen, self.css_provider,
                                                  Gtk.STYLE_PROVIDER_PRIORITY_APPLICATION)
            return False

    def comprobar_edad(self, edad):
        if edad.isdigit() and (int(edad) >= 0 and int(edad) <= 150):
            return True
        else:
            # change color of the text
            self.lblEdad.set_name("error")
            self.contexto.add_provider_for_screen(self.screen, self.css_provider,
                                                  Gtk.STYLE_PROVIDER_PRIORITY_APPLICATION)
            return False


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
        dni = self.txtDni.get_text()
        nombre = self.txtNombre.get_text()
        edad = int(self.txtEdad.get_text())
        genero = self.generoActivo
        self.editar_usuarioBD(nombre, dni, edad, genero)
        for lista in modelo:
            if lista[0] == dni:
                lista[0] = dni
                lista[1] = nombre
                lista[2] = edad
                lista[3] = genero
                break
        modelo_filtrado.refilter()
        self.vaciar_campos()
        self.cambiar_botones_verNE()

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