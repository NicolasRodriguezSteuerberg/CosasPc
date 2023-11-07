import gi
gi.require_version("Gtk", "3.0")
from gi.repository import Gtk

class VentanaPrincipal (Gtk.Window):
    def __init__(self):
        super().__init__()
        self.set_title("First check-radio buttons")

        # existe el toggled button tambien, link button (enlace de wifi?), spin button(subir, bajar)
        # switch button (on/off)

        caixa = Gtk.Box(orientation = Gtk.Orientation.VERTICAL, spacing = 10)

        # creamos el primer radio botón
        radioBtn1 = Gtk.RadioButton.new_with_label_from_widget(None, "Boton 1")
        radioBtn1.connect("toggled", self.on_radioBtn_toggled, "1")
        caixa.pack_start(radioBtn1, False, False, 2)

        # está relacionado con el boton 1
        radioBtn2 = Gtk.RadioButton.new_from_widget(radioBtn1)
        radioBtn2.set_label("Boton 2")
        radioBtn2.connect("toggled", self.on_radioBtn_toggled, "2")
        caixa.pack_start(radioBtn2, False, False, 2)

        # tercer boton B_oton 3 -> si presionas la tecla B, se marca ese (en teoria, no va)
        radioBtn3 = Gtk.RadioButton.new_with_mnemonic_from_widget(radioBtn1, "_Boton 3")
        # este no tiene label
        radioBtn3.connect("toggled", self.on_radioBtn_toggled, "3")
        caixa.pack_start(radioBtn3, False, False, 2)

        # mete como un borde para juntar cosas, solo le puedes añadir un widget por lo que tendrás
        # que crear un contenedor para meterlo en el
        myFrame = Gtk.Frame( label = "CHECKS")
        caixa2 = Gtk.Box(orientation = Gtk.Orientation.VERTICAL, spacing = 10)

        checkB1 = Gtk.CheckButton.new_with_label("Check 1")
        checkB1.connect("toggled", self.on_check_toggled)
        # caixa.pack_start(checkB1, False, False, 2)
        caixa2.pack_start(checkB1, False, False, 2)

        checkB2 = Gtk.CheckButton.new_with_label("Check 2")
        checkB2.connect("toggled", self.on_check_toggled)
        # caixa.pack_start(checkB2, False, False, 2)
        caixa2.pack_start(checkB2, False, False, 2)

        checkB3 = Gtk.CheckButton.new_with_label("Check 3")
        checkB3.connect("toggled", self.on_check_toggled)
        # caixa.pack_start(checkB3, False, False, 2)
        caixa2.pack_start(checkB3, False, False, 2)

        checkB4 = Gtk.CheckButton.new_with_label("Check 4")
        checkB4.connect("toggled", self.on_check_toggled)
        # caixa.pack_start(checkB4, False, False, 2)
        caixa2.pack_start(checkB4, False, False, 2)

        checkB5 = Gtk.CheckButton.new_with_label("Check 5")
        checkB5.connect("toggled", self.on_check_toggled)
        # caixa.pack_start(checkB5, False, False, 2)
        caixa2.pack_start(checkB5, False, False, 2)

        myFrame.add(caixa2)
        caixa.pack_start(myFrame, False, False, 2)

        self.lbl = Gtk.Label(label = "Etiqueta")
        caixa.pack_start(self.lbl, False, False, 2)

        self.add(caixa)
        # para los listeners/eventos
        self.connect("delete-event", Gtk.main_quit) # sin los parentesis del método main_quit
        self.show_all()

    # button: sirve cualquier nombre para recoger una referencia al control que generó
    # la señal (el evento clicked), lo tiene que recibir SIEMPRE!!!
    def on_radioBtn_toggled(self, sinalEvent, number):
        if sinalEvent.get_active():
            print("Boton", number, "ha sido seleccionado")
        else:
            print("Boton", number, "ha sido deseleccionado")


    def on_check_toggled(self, sinal):
        # A C T I V E ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! !
        if sinal.get_active():
            self.lbl.set_text("Activado " + sinal.get_label())
        else:
            self.lbl.set_text("Desactivado " + sinal.get_label())



if __name__ == "__main__":
    VentanaPrincipal()
    Gtk.main()