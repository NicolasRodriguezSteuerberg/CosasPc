import sys

from PyQt6.QtGui import QColor, QIcon
# importamos del pyqt6 los elementos que nos importa -> ventana principal, boton
from PyQt6.QtWidgets import (QApplication, QMainWindow, QPushButton, QLabel,
                             QVBoxLayout, QWidget, QLineEdit, QListView, QHBoxLayout)
from PyQt6.QtCore import Qt, QAbstractListModel

class MyModel(QAbstractListModel):
    def __init__(self, tasks=None):
        super().__init__()

        # if we don't pass a list, we create an empty one
        self.tasks = tasks or []

    # we implement the methods of the abstract class
    def data(self, index, role):
        '''
        Roles:
            - DisplayRole -> the text to be displayed
            - DecorationRole -> the icon to be displayed
            - EditRole -> the text to be edited
        '''
        if role == Qt.ItemDataRole.DisplayRole:
            # the _ is a convention to say that we don't use the variable
            _, text = self.tasks[index.row()]
            return text
        elif role == Qt.ItemDataRole.DecorationRole:
            state, _ = self.tasks[index.row()]
            if state:
                return QIcon('icons/check.png')
            else:
                return QIcon('icons/uncheck.png')

        ''' Para poner color de fondo
        elif role == Qt.ItemDataRole.BackgroundRole:
            state, text = self.tasks[index.row()]
            if state:
                return QColor('green')
            else:
                return QColor('red')
        '''

    def rowCount(self, index):
        return len(self.tasks)



# creamos clase que hereda de QMainWindow
class MyView (QMainWindow):
    # iniciamos a ventana
    def __init__(self):
        # llamamos al constructor de la superclase
        super().__init__()

        self.setWindowTitle( "Mi primera ventana con Qt")

        # we create a list
        taskList = [
            (False, "Tarea 1"),
            (False, "Tarea 2"),
            (False, "Tarea 3")
        ]
        # we create a model
        self.myModel = MyModel(taskList)

        # create a vertical box
        vBox = QVBoxLayout()

        # create a list view
        self.listView = QListView()
        # we add the model to the list view
        self.listView.setModel(self.myModel)
        # we set the selection mode to multiples
        self.listView.setSelectionMode(QListView.SelectionMode.ExtendedSelection)
        # we add the list view to the vertical box
        vBox.addWidget(self.listView)

        # we create a horizontal box with two buttons
        hBox = QHBoxLayout()
        # create the buttons
        deleteButton = QPushButton("Borrar")
        # we connect the button to the method
        deleteButton.pressed.connect(self.on_buttonDelete_pressed)
        # create the button to mark the task as done
        doneButton = QPushButton("Feito")
        # we connect the button to the method
        doneButton.pressed.connect(self.on_buttonDone_pressed)
        # we add the buttons to the horizontal box
        hBox.addWidget(deleteButton)
        hBox.addWidget(doneButton)
        # we add the horizontal box to the vertical box
        vBox.addLayout(hBox)

        # create a line edit
        self.lineEdit = QLineEdit()
        # we connect the line edit to the method
        # if we press enter, we add the text to the list view
        self.lineEdit.editingFinished.connect(self.on_buttonAddTask_pressed)
        # we add the line edit to the vertical box
        vBox.addWidget(self.lineEdit)

        # create a button to add the text of the line edit to the list view
        buttonAddTask = QPushButton("Engadir")
        # we connect the button to the method
        buttonAddTask.pressed.connect(self.on_buttonAddTask_pressed)
        # we add the button to the vertical box
        vBox.addWidget(buttonAddTask)

        # creamos el contenedor
        container = QWidget()
        container.setLayout(vBox)
        self.setCentralWidget(container)

        self.setFixedSize(400, 300)
        # mostramos la ventana
        self.show() # para que se vea a pantalla

    def on_buttonAddTask_pressed(self):
        text = self.lineEdit.text().strip() # strip() -> remove the spaces at the beginning and at the end
        # if the text is not empty we add it to the list view
        if text:
            # we add the text to the list
            self.myModel.tasks.append((False, text))
            # we update the list view -> we emit the signal layoutChanged to the model to update the view
            self.myModel.layoutChanged.emit()
            # we clear the line edit
            self.lineEdit.setText("")

    # function to delete the selected task
    def on_buttonDelete_pressed(self):
        # we get the selected indexes
        indexes = self.listView.selectedIndexes()
        # we see if the index is valid
        if indexes:
            # we remove the task from the list, we use a for because sometimes we can select more than one task
            # we use sorted to delete the tasks from the last to the first, if we don't use it, we will have problems
            for index in sorted(indexes, reverse=True):
                del self.myModel.tasks[index.row()]
            # we update the list view -> we emit the signal layoutChanged to the model to update the view
            self.myModel.layoutChanged.emit()
            # we clear the selection
            self.listView.clearSelection()
    
    def on_buttonDone_pressed(self):
        # we get the selected indexes
        indexes = self.listView.selectedIndexes()
        # we see if we have selected something
        if indexes:
            for index in indexes:
                # we get the state and the text
                state, text = self.myModel.tasks[index.row()]
                # we change the state
                self.myModel.tasks[index.row()] = (not state, text)
            self.myModel.layoutChanged.emit()
            self.listView.clearSelection()

        

if __name__ == "__main__":
    # creamos un objeto de instancia qapplication
    aplicacion = QApplication(sys.argv) # sys.argv -> unimos la aplicacion con el sistema operativo
    # creamos un objeto de la ventana
    ventana = MyView()
    # ejecutamos la union?
    aplicacion.exec()