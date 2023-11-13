import gi
gi.require_version("Gtk", "3.0")
from gi.repository import Gtk

# class BoxWithLabelTextField (Gtk.Box):
class BoxWithLabelTextField(Gtk.Box):
    def __init__(self, labelText, textFieldText):
        super().__init__(orientation=Gtk.Orientation.HORIZONTAL, spacing=5)
        self.set_border_width(5)

        self.label = Gtk.Label(label=labelText)
        self.label.set_width_chars(10)
        self.textField = Gtk.Entry()
        self.textField.set_placeholder_text(textFieldText)

        self.pack_start(self.label, False, False, 0)
        self.pack_start(self.textField, False, False, 0)

# class GridAssignatures
class BoxAssignatures (Gtk.Box):
    def __init__(self):
        super().__init__(orientation=Gtk.Orientation.VERTICAL, spacing=10)
        self.set_border_width(5)
        # create a box for the name of the asignature, the note and a checkbox for see if it's bilingual
        self.boxCOD = GridBoxNameAsignature("COD")
        self.boxPROG = GridBoxNameAsignature("PROG")
        self.boxSI = GridBoxNameAsignature("SI")

        # we add the boxes to the box
        self.pack_start(self.boxCOD, False, False, 0)
        self.pack_start(self.boxPROG, False, False, 0)
        self.pack_start(self.boxSI, False, False, 0)


# class with the name of the asignature, the note and a checkbox for see if it's bilingual
class GridBoxNameAsignature (Gtk.Box):
    def __init__(self, nameAsignature):
        super().__init__(orientation=Gtk.Orientation.HORIZONTAL, spacing=5)
        self.labelName = Gtk.Label(label=nameAsignature)
        self.labelName.set_width_chars(5)
        self.noteField = Gtk.Entry()
        self.noteField.set_placeholder_text("Nota")
        self.noteField.set_width_chars(4)
        self.noteField.set_max_length(2)
        self.checkButton2 = Gtk.CheckButton()

        self.labelBilingual = Gtk.Label(label="Bilingüe")
        self.pack_start(self.labelName, False, False, 0)
        self.pack_start(self.noteField, False, False, 0)
        self.pack_start(self.labelBilingual, False, False, 0)
        self.pack_start(self.checkButton2, False, False, 0)



# class VentanaPrincipal
class VentanaPrincipal (Gtk.Window):
    def __init__(self):
        super().__init__()
        self.set_title("Alumnos")
        self.set_default_size(475, 275)

        # we create a list for the students
        self.listStudents = []

        # we create a main box as the main container
        mainBox = Gtk.Box(orientation=Gtk.Orientation.VERTICAL, spacing=0)

        # we create a gridbox
        grid = Gtk.Grid()

        # create 2 labels
        labelStudents = Gtk.Label(label="Alumno")
        labelModules = Gtk.Label(label="Módulos")


        # create a box for the name
        self.boxName = BoxWithLabelTextField("Nombre", "Introduce el nombre")
        # create a box for the surname
        self.boxSurname = BoxWithLabelTextField("Apellidos", "Introduce los apellidos")
        # create a box for the asignatures
        self.boxAssignatures = BoxAssignatures()
        # button to save the student
        buttonSave = Gtk.Button(label="Guardar")
        # we create a event for the button
        buttonSave.connect("clicked", self.buttonPressed)

        # we add to the main box the other boxes
        grid.attach(labelStudents, 0, 0, 1, 1)
        grid.attach_next_to(self.boxName, labelStudents, Gtk.PositionType.BOTTOM, 1, 1)
        grid.attach_next_to(self.boxSurname, self.boxName, Gtk.PositionType.BOTTOM, 1, 1)

        grid.attach_next_to(labelModules, labelStudents, Gtk.PositionType.RIGHT, 1, 1)
        grid.attach_next_to(self.boxAssignatures, self.boxName, Gtk.PositionType.RIGHT, 1, 4)


        # we add the grid and the button to the main box
        mainBox.pack_start(grid, True, True, 0)
        mainBox.pack_start(buttonSave, False, False, 0)


        # we add the box to the window
        self.add(mainBox)
        # create the delete event (to close the window) and show the window
        self.connect("delete-event", Gtk.main_quit)  # sin los parentesis del método main_quit
        self.show_all()

    # function to save the student in a list
    def buttonPressed(self, sinal):
        # we create a list for the asignatures

        listStudent = [
            self.boxName.textField.get_text(),
            self.boxSurname.textField.get_text(),
            [self.boxAssignatures.boxCOD.labelName.get_label(),self.boxAssignatures.boxCOD.noteField.get_text(), "bilingue" if self.boxAssignatures.boxCOD.checkButton2.get_active() else None],
            [self.boxAssignatures.boxPROG.labelName.get_label(), self.boxAssignatures.boxPROG.noteField.get_text(), "bilingue" if self.boxAssignatures.boxPROG.checkButton2.get_active() else None],
            [self.boxAssignatures.boxSI.labelName.get_label(), self.boxAssignatures.boxSI.noteField.get_text(), "bilingue" if self.boxAssignatures.boxSI.checkButton2.get_active() else None]
        ]

        # we add the student to the list with the asignatures
        self.listStudents.append(listStudent)
        # we print the list with a for
        for student in self.listStudents:
            print(student)




if __name__ == "__main__":
    VentanaPrincipal()
    Gtk.main()