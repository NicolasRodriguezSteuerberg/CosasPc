import gi
gi.require_version("Gtk", "3.0")
from gi.repository import Gtk

class FilaListBoxDatos(Gtk.ListBoxRow):
    def __init__(self, word):
        super().__init__()
        self.word = word
        self.add(Gtk.Label(label = word))

class ListBox(Gtk.Window):
    # init method
    def __init__(self):
        super().__init__()
        self.set_title("ListBox")

        # create a box
        box = Gtk.Box(orientation=Gtk.Orientation.VERTICAL, spacing=10)
        # create a listbox
        listBox = Gtk.ListBox()
        box.add(listBox)

        # create elements for the listbox
        elements = "Esto es una cadena para ordenar con ListBox, para el ListBox".split()
        for word in elements:
            listBox.add(FilaListBoxDatos(word))

        def function_order(row1, row2):
            return row1.word.lower() > row2.word.lower()

        # filter function
        # one Listbox has a ,(ListBox,) then it will be shown
        def function_filter(row):
            return False if row.word == "ListBox" else True

        # sort function
        listBox.set_sort_func(function_order)
        listBox.set_filter_func(function_filter)
        # connect the listbox with the row-activated event
        listBox.connect("row-activated", self.on_row_activated)

        # we add the box to the window
        self.add(box)
        # create the delete program event
        self.connect("delete-event", Gtk.main_quit)
        self.show_all()

    # function to show the word of the row activated
    def on_row_activated(self, listBox, row):
        print(row.word)


if __name__ == "__main__":
    ListBox()
    Gtk.main()