import gi
gi.require_version("Gtk", "3.0")
from gi.repository import Gtk

class VentanaPrincipal (Gtk.Window):
    def __init__(self):
        super().__init__()
        self.set_title("First check-radio buttons")

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

        checkB1 = Gtk.CheckButton.new_with_label("Check 1")
        # checkB1.connect("activa")
        caixa.pack_start(checkB1, False, False, 2)

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


if __name__ == "__main__":
    VentanaPrincipal()
    Gtk.main()