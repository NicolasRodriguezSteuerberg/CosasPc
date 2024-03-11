

from PyQt6.QtCore import QAbstractTableModel, Qt



class ModeloTaboa(QAbstractTableModel):
    def __init__(self,datos, headerData):
        super().__init__()
        self.datos = datos
        self.headerData = headerData

    def rowCount(self, index):
        return len(self.datos)

    def columnCount(self, index):
        return len(self.datos[0])

    def data(self, index, role=Qt.ItemDataRole.DisplayRole):
        if index.isValid():
            if role == Qt.ItemDataRole.DisplayRole or role == Qt.ItemDataRole.EditRole:
                value = self.datos[index.row()][index.column()]
                return str(value)

    def setData(self, index, value, role):
        if role == Qt.ItemDataRole.EditRole:
            self.datos[index.row()][index.column()] = value
            return True
        return False

    def headerData(self, section, orientation, role):
        # para añadir la cabezera
        if role == Qt.ItemDataRole.DisplayRole:
            if orientation == Qt.Orientation.Horizontal:
                return self.headerData[section]
            elif orientation == Qt.Orientation.Vertical:
                return section + 1
    